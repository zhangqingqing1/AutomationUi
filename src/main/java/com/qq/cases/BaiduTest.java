package com.qq.cases;

import com.qq.Factory.WebDriverFactory;
import com.qq.pages.BaiduPage;
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

import static com.qq.pages.BaiduPage.*;


/**
 * @description:
 * @author: lu
 * @date 2019/12/5 14:16
 */
public class BaiduTest {
    private WebDriver driver;
    private WebDriverWait wait;
    BaiduPage baiduPage = new BaiduPage();

    @BeforeClass
    public void beforeClass() throws IOException {
        this.driver = WebDriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, 10);
    }

    /**
     * 搜索功能测试
     */
    @Test(dataProvider = "provider", dataProviderClass = QQDataProvider.class)
    public void searchTest(Map<String, String> caseData) {
        String keyword = caseData.get("keyword");
        String startDate = caseData.get("startTime");
        String endDate = caseData.get("endTime");
        BaiduPage baiduPage=new BaiduPage();
        //搜索hello world
//        String keyword = "日本";


        baiduPage.searchAndFilter(keyword,startDate,endDate);
    }
}