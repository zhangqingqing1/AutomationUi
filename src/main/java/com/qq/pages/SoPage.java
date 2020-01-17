package com.qq.pages;

import com.qq.Factory.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class SoPage extends BasePage {
    WebDriver driver;

    {
        try {
            driver = WebDriverFactory.getDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    WebDriverWait wait = new WebDriverWait(driver, 10);
    public String  input;
    public String  submit;
    public String  xpath;

    public SoPage() {
    }

    public void search(String keyword){
        driver.get("https://www.so.com");
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input")));
        input.clear();
        input.sendKeys(keyword);
        driver.findElement(By.id("search-button")).click();

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='result']//h3")));

        if (!result.getText().contains(keyword)) throw new AssertionError("360搜索结果不符合预期");

    }
}
