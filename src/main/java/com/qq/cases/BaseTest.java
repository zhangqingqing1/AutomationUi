package com.qq.cases;

import com.qq.util.EnvUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {
    public static  WebDriver driver;
    public static   WebDriverWait wait;
        @BeforeSuite
        public void beforeSuite() throws InterruptedException, IOException {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, EnvUtil.driverPath());
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);//全局设置显示等待10s,超时则异常
            System.out.println("");
            System.out.println(" suite 运行");

        }

        @AfterSuite
        public void afterSuite(){

            //        System.out.println("after suite 运行");
            driver.quit();
        }
}


