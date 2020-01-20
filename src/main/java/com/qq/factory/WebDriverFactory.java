package com.qq.factory;

import com.qq.util.EnvUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.IOException;

/**
 * @author: lu
 */
public class WebDriverFactory {
    private WebDriverFactory() {
    }

    private static WebDriver driver;

    /**
     * 获取单例driver
     */
    public static WebDriver getDriver() throws IOException {
        if (null == driver) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, EnvUtil.driverPath());
            driver = new ChromeDriver();
        }
        return driver;
    }

    /**
     * 关闭driver
     */
    public static void close() {
        if (null != driver) {
            driver.quit();
        }
    }
}
