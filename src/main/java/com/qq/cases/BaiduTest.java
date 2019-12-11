package com.qq.cases;

import com.qq.util.EnvUtil;
import com.qq.util.QQDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

/**
 * @description:
 * @author: lu
 * @date 2019/12/5 14:16
 */
public class BaiduTest {
    WebDriver driver;
    WebDriverWait wait;

    /**
     * 测试之前初始化WebDriver
     */
    @BeforeTest
    public void beforeTest() throws IOException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, EnvUtil.driverPath());
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);//全局设置显示等待10s,超时则异常
    }

    /**
     * 测试完成之后关闭driver
     */
    @AfterTest
    public void afterTest() {
        if (null != driver) driver.quit();
    }

    /**
     * 搜索功能测试
     */
    @Test(dataProvider = "provider", dataProviderClass = QQDataProvider.class)
    public void searchTest(Map<String, String> caseData) {
        String keyword = caseData.get("keyword");
        String startDate = caseData.get("startTime");
        String endDate = caseData.get("endTime");
        //搜索hello world
//        String keyword = "日本";
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys(keyword);
        driver.findElement(By.id("su")).click();

        //搜索结果检查
        WebElement h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content_left']//h3")));//第一行搜索结果的标题
        String expected = h3.getText();
        if (!expected.contains(keyword)) throw new AssertionError("搜索结果第一行标题不包含关键字");

        /**
         * 搜索筛选实现
         */
        driver.findElement(By.className("search_tool")).click();
        WebElement search_tool_tf = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='search_tool_tf ']")));
        search_tool_tf.click();
        WebElement startDateEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"c-tip-custom-st\"]/input")));
        WebElement endDateEle = driver.findElement(By.xpath("//*[@class=\"c-tip-custom-et\"]/input"));
        //输入开始时间与结束时间
        startDateEle.clear();
        startDateEle.sendKeys(startDate);
        endDateEle.clear();
        endDateEle.sendKeys(endDate);
        //点击"确认"
        driver.findElement(By.linkText("确认")).click();

        //检查预期搜索结果
        WebElement h3ByFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content_left']//h3")));//第一行搜索结果的标题
        String expectedFilter = h3ByFilter.getText();
        if (!expectedFilter.contains(keyword))
            throw new AssertionError("筛选后结果不符合预期");
    }
}
