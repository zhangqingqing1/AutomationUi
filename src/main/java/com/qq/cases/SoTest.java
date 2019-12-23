package com.qq.cases;

import com.qq.Factory.WebDriverFactory;
import com.qq.util.QQDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.qq.cases.SousuoPage.*;


/**
 * @description: 360搜索测试
 * @author: lu
 * @date 2019/12/12 11:01
 */
public class SoTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws IOException {
        this.driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test(dataProviderClass = QQDataProvider.class, dataProvider = "provider")
    public void searchTest(Map<String, String> map) {
        String keyword = map.get("keyword");
        driver.get("https://www.so.com");
        WebElement input = waitWebElementByid("input");
        input.clear();
        input.sendKeys(keyword);
        searchButtonClick();

        WebElement result = waitWebElementByxpath("//*[@class='result']//h3");

        if (!result.getText().contains(keyword)) throw new AssertionError("360搜索结果不符合预期");
    }
}




