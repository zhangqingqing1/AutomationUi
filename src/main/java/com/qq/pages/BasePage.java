package com.qq.pages;

import com.qq.Factory.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * @author: lu
 */
public class BasePage {
    private static final int WAIT_TIME_OUT = 20;//显示等待20秒
    private WebDriver driver;
    private WebDriverWait wait;

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

    public BasePage() {
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIME_OUT);
    }

    public BasePage(String url) throws IOException {
        this.driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        driver.get(url);
    }

    //输入框，指定元素
    public void sendkeys(WebElement element, String keywords) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(keywords);
    }

    //输入框，指定元素定位方式
    public void sendKeys(By by, String keywords) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(keywords);
    }

    //点击按钮
    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    //点击按钮
    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
}
