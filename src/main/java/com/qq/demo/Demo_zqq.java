package com.qq.demo;

import com.qq.util.ExcelUtil_zqq;
import com.qq.util.MyUtil;
import com.qq.util.MyWait;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @Desc
 * @Author qiwei.lu@b-and-qchina.com
 * @Date 2019/11/26 15:22
 */
public class Demo_zqq {
    private static WebDriver driver;
    WebDriverWait  wait;

    @BeforeClass
    public void beforeClass() throws InterruptedException, IOException, ParseException {
        //定义driver
        driver = MyUtil.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);//全局设置显示等待10s,超时则异常
    }

    @Test(dataProvider = "iterator")
    public void test(String keyword, String startTime, String endTime) throws InterruptedException, ParseException {

        //搜索hello world
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys(keyword);
        driver.findElement(By.id("su")).click();

        //搜索结果
        WebElement h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content_left']//h3")));
        //检查标题内容
        String expected = h3.getText();
        if (expected.contains(keyword)) {
            System.out.println("搜索成功，符合预期");
        } else {
            System.out.println("搜索结果不符合预期");
        }
        //任务2 在搜索出hello world的基础上，做筛选，自定义时间，当年的1月1号到今天（程序运行的这一天），然后再校验第一行搜索结果标题是不是包含hello world
        driver.findElement(By.className("search_tool")).click();
        WebElement search_tool_tf = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='search_tool_tf ']")));
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/span[2]")).click();
        // 输入时间
        driver.findElement(By.name("st")).clear();
        driver.findElement(By.name("st")).sendKeys(startTime);
        driver.findElement(By.name("et")).clear();
        driver.findElement(By.name("et")).sendKeys(endTime);
        Thread.sleep(1000 * 2);
        driver.findElement(By.linkText("确认")).click();
        Thread.sleep(1000 * 3);
        //搜索结果WebElement h3 =
        WebElement h4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content_left']//h3")));//第一行搜索结果的标题
        //检查标题内容
        String expected1 = h4.getText();
        if (expected1.contains(keyword)) {
            System.out.println("筛选结果正确，符合预期");
        } else {
            System.out.println("筛选结果不符合预期");
        }

    }
    @DataProvider(name = "provider")
    public Object[][] provider() {
        String excelFileName =Demo_zqq.class.getResource("/").getPath() + "BaiduTest.xlsx";
        List<Map<String, List<String>>> list = ExcelUtil_zqq.readExcelBYsheetname(excelFileName, "searchTest");
        Object[][] provider = new Object[4][3];
        for (int i = 0; i < list.size(); i++) {
            Map<String,List<String>> map=list.get(i);
            for(Map.Entry<String,List<String>> entry:map.entrySet()){
                provider[i][0] = entry.getValue().get(0);
                provider[i][1] = entry.getValue().get(1);
                provider[i][2] = entry.getValue().get(2);
            }




        }
        return provider;
    }
    @DataProvider(name="iterator")
    public Iterator<Object[]> getMethodData1() {
        String excelFileName =Demo_zqq.class.getResource("/").getPath() + "BaiduTest.xlsx";
        List<Map<String, List<String>>> list = ExcelUtil_zqq.readExcelBYsheetname(excelFileName, "searchTest");
        List<Object[]> testCases = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, List<String>> map = list.get(i);
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                Object[] objects = new Object[entry.getValue().size()];
                for (int j = 0; j < entry.getValue().size(); j++) {
                    objects[0] = entry.getValue().get(0);
                    objects[1] = entry.getValue().get(1);
                    objects[2] = entry.getValue().get(2);

                }
                testCases.add(objects);
            }

        }
        return testCases.iterator();
    }
        @AfterClass
    public void AfterTest() {
        driver.quit();
    }

}

