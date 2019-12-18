package com.qq.page;

import com.qq.util.EnvUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.Serializable;

/**
 * @description:
 * @author: lu
 * @date 2019/12/13 23:30
 */
public class BasePage implements Serializable {
    private static final long serialVersionUID = 1611412425740156525L;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(String url) throws IOException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, EnvUtil.driverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get(url);
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        wait = new WebDriverWait(driver, 10);
    }
    public BasePage(){}

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public void sendkeys(By by, String text) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        clearAndSend(input, text);
    }

    public void sendkeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        clearAndSend(element, text);
    }

    private void clearAndSend(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        //输入完成后，失去焦点，触发某些输入框的校验逻辑(如果有)
        ((JavascriptExecutor) driver).executeScript("arguments[0].blur()", element);
    }

    public void click(By by) {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(by));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", btn);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }
}
