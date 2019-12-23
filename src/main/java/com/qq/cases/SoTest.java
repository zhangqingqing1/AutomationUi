package com.qq.cases;

import com.qq.util.EnvUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;


/**
 * @description: 360搜索测试
 * @author: lu
 * @date 2019/12/12 11:01
 */
public class SoTest {
    private static WebDriver driver;
    WebDriverWait wait;

//    @BeforeClass
//    public void beforeClass() throws IOException {
//        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, EnvUtil.driverPath());
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 10);//全局设置显示等待10s,超时则异常
//    }

    @Test(dataProviderClass = com.qq.util.QQDataProvider.class, dataProvider = "provider")
    public void searchTest(Map<String, String> map) {
        String keyword = map.get("keyword");
        driver.get("https://www.so.com");
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input")));
        input.clear();
        input.sendKeys(keyword);
        driver.findElement(By.id("search-button")).click();

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='result']//h3")));

        if (!result.getText().contains(keyword)) throw new AssertionError("360搜索结果不符合预期");
    }

//    @AfterClass
//    public void AfterTest() {
//        driver.quit();
//    }
}




