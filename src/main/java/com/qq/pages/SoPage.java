package com.qq.pages;

import com.qq.Factory.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class SoPage {

    WebDriver driver;

    {
        try {
            driver = WebDriverFactory.getDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    WebDriverWait wait=new WebDriverWait(driver, 10);
    //根据xpaht等待元素
    public WebElement waitWebElementByxpath(String test) throws NotFoundException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(test)));
    }

    //根据id等待元素
    public  WebElement waitWebElementByid(String test) throws NotFoundException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(test)));
    }

    //"点击search-button"
    public  void searchButtonClick()
            throws NotFoundException {
        driver.findElement(By.id("search-button")).click();
    }
}
