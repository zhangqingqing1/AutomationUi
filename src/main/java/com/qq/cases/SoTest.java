package com.qq.cases;

import com.qq.util.MyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Map;


/**
 * @description: 360搜索测试
 * @author: lu
 * @date 2019/12/12 11:01
 */
public class SoTest extends  BaseTest{

    @Test(dataProviderClass = com.qq.util.QQDataProvider.class, dataProvider = "provider")
    public void searchTest(Map<String, String> map) throws InterruptedException {
        String keyword = map.get("keyword");
        Thread.sleep(1000*2);
        driver.get("https://www.so.com");
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input")));
        input.clear();
        input.sendKeys(keyword);
        driver.findElement(By.id("search-button")).click();

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='result']//h3")));

        if (!result.getText().contains(keyword)) throw new AssertionError("360搜索结果不符合预期");
    }

}




