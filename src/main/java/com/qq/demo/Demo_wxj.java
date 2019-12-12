package com.qq.demo;

import com.qq.util.DateUtilWang;
import com.qq.util.ExcelUtil_wxj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Demo_wxj {
    private static WebDriver driver;
    @BeforeTest
    public void beforeTest() throws IOException {
        String userName = System.getProperty("user.name");
        Properties properties = new Properties();
        properties.load(Demo_wxj.class.getResourceAsStream("/chromeversion.properties"));
        String chromeVersion = properties.getProperty(userName);
        String driverPath = Demo_wxj.class.getResource("/").getPath() + "drivers/chromedriver" + chromeVersion + ".exe";

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /* 第一种：Object[][]方法 */
    @DataProvider(name = "test1")
    public Object[][] createData() throws IOException {
        File file= new File(".\\src\\main\\resources\\BaiduTest.xlsx");
        List<HashMap<String, Object>> list = ExcelUtil_wxj.readExcel(file);
        int row = list.size();
        Object[][] obj = new Object[row][3];
        for(int i=0;i<row;i++){
            obj[i][0] = list.get(i).get("keyword");
            obj[i][1] = list.get(i).get("startTime");
            obj[i][2] = list.get(i).get("endTime");
        }
        return obj;
    }


    @Test(dataProvider = "test1")
    public void searchTest(String keyword,String startTime,String endTime) throws InterruptedException{
        //搜索关键字
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys(keyword);
        driver.findElement(By.id("su")).click();

        //检查预期
        Thread.sleep(1000 * 3);
        //搜索结果
        WebElement h3 = driver.findElement(By.xpath("//*[@id='content_left']//h3"));//第一行搜索结果的标题
        //检查标题内容
        String expected = h3.getText();
        if (expected.contains(keyword)) {
            System.out.println("搜索成功，符合预期");
        } else {
            System.out.println("搜索结果不符合预期");
        }

        /*搜索工具筛选*/
        //点击搜索工具
        driver.findElement(By.className("search_tool")).click();
        Thread.sleep(1000 * 1);
        //点击时间不限
        driver.findElement(By.className("search_tool_tf")).click();
        Thread.sleep(1000 * 1);
        //清空开始时间输入框 并获取开始时间
        driver.findElement(By.name("st")).clear();
        Thread.sleep(1000 * 1);
//        driver.findElement(By.name("st")).sendKeys(DateUtilWang.getFirstDayOfCurrentYear());
        driver.findElement(By.name("st")).sendKeys(startTime);
        Thread.sleep(1000 * 1);

        //清空结束时间输入框 并获取结束时间
        driver.findElement(By.name("et")).clear();
        Thread.sleep(1000 * 1);
//        driver.findElement(By.name("et")).sendKeys(DateUtilWang.getCurrentDay());
        driver.findElement(By.name("et")).sendKeys(endTime);
        Thread.sleep(1000 * 1);
        //点击确定
        driver.findElement(By.className("c-tip-custom-submit")).click();

        //检查预期
        Thread.sleep(1000 * 3);//等待搜索结果
        //搜索结果
        WebElement h3ByFilter = driver.findElement(By.xpath("//*[@id='content_left']//h3"));//第一行搜索结果的标题
        //检查标题内容
        String expectedFilter = h3ByFilter.getText();
        if (expectedFilter.contains(keyword)) {
            System.out.println("筛选后搜索结果 第一条包含"+" "+keyword);
        } else {
            System.out.println("筛选后搜索结果 第一条不包含"+" "+keyword);
        }
    }

    /* 第二种：Iterator<Object[]>方法 */
    @DataProvider(name = "test2")
    public Iterator<Object[]> createData2() throws IOException {
        File file= new File(".\\src\\main\\resources\\BaiduTest.xlsx");
        List<HashMap<String, Object>> list = ExcelUtil_wxj.readExcel(file);
        int row = list.size();
        List<Object[]>  listObj = new ArrayList<>();
        Object[][] obj = new Object[row][3];
        for (int i=0;i<row;i++){
            for(int j=0;j<3;j++){
                obj[i][0] = list.get(i).get("keyword");
                obj[i][1] = list.get(i).get("startTime");
                obj[i][2] = list.get(i).get("endTime");
            }
            listObj.add(obj[i]);
        }
        return listObj.iterator();
    }

    @Test(dataProvider = "test2")
    public void searchTest2(Object[] obj) throws InterruptedException{
        //搜索关键字
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys((CharSequence) obj[0]);
        driver.findElement(By.id("su")).click();
        //检查预期
        Thread.sleep(1000 * 3);
        //搜索结果
        WebElement h3 = driver.findElement(By.xpath("//*[@id='content_left']//h3"));//第一行搜索结果的标题
        //检查标题内容
        String expected = h3.getText();
        if (expected.contains((CharSequence) obj[0])) {
            System.out.println("搜索成功，符合预期");
        } else {
            System.out.println("搜索结果不符合预期");
        }
        /*搜索工具筛选*/
        //点击搜索工具
        driver.findElement(By.className("search_tool")).click();
        Thread.sleep(1000 * 1);
        //点击时间不限
        driver.findElement(By.className("search_tool_tf")).click();
        Thread.sleep(1000 * 1);
        //清空开始时间输入框 并获取开始时间
        driver.findElement(By.name("st")).clear();
        Thread.sleep(1000 * 1);
//        driver.findElement(By.name("st")).sendKeys(DateUtilWang.getFirstDayOfCurrentYear());
        driver.findElement(By.name("st")).sendKeys((CharSequence) obj[1]);
        Thread.sleep(1000 * 1);
        //清空结束时间输入框 并获取结束时间
        driver.findElement(By.name("et")).clear();
        Thread.sleep(1000 * 1);
//        driver.findElement(By.name("et")).sendKeys(DateUtilWang.getCurrentDay());
        driver.findElement(By.name("et")).sendKeys((CharSequence) obj[2]);
        Thread.sleep(1000 * 1);
        //点击确定
        driver.findElement(By.className("c-tip-custom-submit")).click();
        //检查预期
        Thread.sleep(1000 * 3);//等待搜索结果
        //搜索结果
        WebElement h3ByFilter = driver.findElement(By.xpath("//*[@id='content_left']//h3"));//第一行搜索结果的标题
        //检查标题内容
        String expectedFilter = h3ByFilter.getText();
        if (expectedFilter.contains((CharSequence) obj[0])) {
            System.out.println("筛选后搜索结果 第一条包含"+" "+(CharSequence) obj[0]);
        } else {
            System.out.println("筛选后搜索结果 第一条不包含"+" "+(CharSequence) obj[0]);
        }
    }

    /* 第三种：Object[]方法 */
    @DataProvider(name = "test3")
    public Object[] createData3() throws IOException {
        File file= new File(".\\src\\main\\resources\\BaiduTest.xlsx");
        List<HashMap<String, Object>> list = ExcelUtil_wxj.readExcel(file);
        int row = list.size();
        Object[][] obj = new Object[row][3];
        for (int i=0;i<row;i++){
            for(int j=0;j<3;j++){
                obj[i][0] = list.get(i).get("keyword");
                obj[i][1] = list.get(i).get("startTime");
                obj[i][2] = list.get(i).get("endTime");
            }
        }
        return obj;
    }

    @Test(dataProvider = "test3")
    public void searchTest3(Object[] obj) throws InterruptedException{
        //搜索关键字
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys((CharSequence) obj[0]);
        driver.findElement(By.id("su")).click();
        //检查预期
        Thread.sleep(1000 * 3);
        //搜索结果
        WebElement h3 = driver.findElement(By.xpath("//*[@id='content_left']//h3"));//第一行搜索结果的标题
        //检查标题内容
        String expected = h3.getText();
        if (expected.contains((CharSequence) obj[0])) {
            System.out.println("搜索成功，符合预期");
        } else {
            System.out.println("搜索结果不符合预期");
        }
        /*搜索工具筛选*/
        //点击搜索工具
        driver.findElement(By.className("search_tool")).click();
        Thread.sleep(1000 * 1);
        //点击时间不限
        driver.findElement(By.className("search_tool_tf")).click();
        Thread.sleep(1000 * 1);
        //清空开始时间输入框 并获取开始时间
        driver.findElement(By.name("st")).clear();
        Thread.sleep(1000 * 1);
//        driver.findElement(By.name("st")).sendKeys(DateUtilWang.getFirstDayOfCurrentYear());
        driver.findElement(By.name("st")).sendKeys((CharSequence) obj[1]);
        Thread.sleep(1000 * 1);
        //清空结束时间输入框 并获取结束时间
        driver.findElement(By.name("et")).clear();
        Thread.sleep(1000 * 1);
//        driver.findElement(By.name("et")).sendKeys(DateUtilWang.getCurrentDay());
        driver.findElement(By.name("et")).sendKeys((CharSequence) obj[2]);
        Thread.sleep(1000 * 1);
        //点击确定
        driver.findElement(By.className("c-tip-custom-submit")).click();
        //检查预期
        Thread.sleep(1000 * 3);//等待搜索结果
        //搜索结果
        WebElement h3ByFilter = driver.findElement(By.xpath("//*[@id='content_left']//h3"));//第一行搜索结果的标题
        //检查标题内容
        String expectedFilter = h3ByFilter.getText();
        if (expectedFilter.contains((CharSequence) obj[0])) {
            System.out.println("筛选后搜索结果 第一条包含"+" "+(CharSequence) obj[0]);
        } else {
            System.out.println("筛选后搜索结果 第一条不包含"+" "+(CharSequence) obj[0]);
        }
    }

    /* 第四种：Iterator<Object>方法 */
    @DataProvider(name = "test4")
    public Iterator<Object> createData4() throws IOException {
        File file= new File(".\\src\\main\\resources\\BaiduTest.xlsx");
        List<HashMap<String, Object>> list = ExcelUtil_wxj.readExcel(file);
        int row = list.size();
        List<Object>  listObj = new ArrayList<>();
        Object[][] obj = new Object[row][3];
        for (int i=0;i<row;i++){
            for(int j=0;j<3;j++){
                obj[i][0] = list.get(i).get("keyword");
                obj[i][1] = list.get(i).get("startTime");
                obj[i][2] = list.get(i).get("endTime");
            }
            listObj.add(obj[i]);
        }
        return listObj.iterator();
    }

    @Test(dataProvider = "test4")
    public void searchTest4(Object[] obj) throws InterruptedException{
        //搜索关键字
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys((CharSequence) obj[0]);
        driver.findElement(By.id("su")).click();
        //检查预期
        Thread.sleep(1000 * 3);
        //搜索结果
        WebElement h3 = driver.findElement(By.xpath("//*[@id='content_left']//h3"));//第一行搜索结果的标题
        //检查标题内容
        String expected = h3.getText();
        if (expected.contains((CharSequence) obj[0])) {
            System.out.println("搜索成功，符合预期");
        } else {
            System.out.println("搜索结果不符合预期");
        }
        /*搜索工具筛选*/
        //点击搜索工具
        driver.findElement(By.className("search_tool")).click();
        Thread.sleep(1000 * 1);
        //点击时间不限
        driver.findElement(By.className("search_tool_tf")).click();
        Thread.sleep(1000 * 1);
        //清空开始时间输入框 并获取开始时间
        driver.findElement(By.name("st")).clear();
        Thread.sleep(1000 * 1);
//        driver.findElement(By.name("st")).sendKeys(DateUtilWang.getFirstDayOfCurrentYear());
        driver.findElement(By.name("st")).sendKeys((CharSequence) obj[1]);
        Thread.sleep(1000 * 1);
        //清空结束时间输入框 并获取结束时间
        driver.findElement(By.name("et")).clear();
        Thread.sleep(1000 * 1);
//        driver.findElement(By.name("et")).sendKeys(DateUtilWang.getCurrentDay());
        driver.findElement(By.name("et")).sendKeys((CharSequence) obj[2]);
        Thread.sleep(1000 * 1);
        //点击确定
        driver.findElement(By.className("c-tip-custom-submit")).click();
        //检查预期
        Thread.sleep(1000 * 3);//等待搜索结果
        //搜索结果
        WebElement h3ByFilter = driver.findElement(By.xpath("//*[@id='content_left']//h3"));//第一行搜索结果的标题
        //检查标题内容
        String expectedFilter = h3ByFilter.getText();
        if (expectedFilter.contains((CharSequence) obj[0])) {
            System.out.println("筛选后搜索结果 第一条包含"+" "+(CharSequence) obj[0]);
        } else {
            System.out.println("筛选后搜索结果 第一条不包含"+" "+(CharSequence) obj[0]);
        }
    }

    @AfterTest
    public void afterTest() {if(null != driver) driver.quit();}
}
