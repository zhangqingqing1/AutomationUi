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
 * @description:
 * @author: lu
 * @date 2019/12/5 14:16
 */
public class BaiduTest {
    private WebDriver driver;
    private WebDriverWait wait;

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
        //搜索hello world
//        String keyword = "日本";
        driver.get("https://www.baidu.com/");
        setKeyword( keyword );
        sousuoClick();

        //搜索结果检查
        WebElement h3 =  waitWebElementByxpath("//*[@id='content_left']//h3");
        String expected = h3.getText();
        if (!expected.contains(keyword)) throw new AssertionError("搜索结果第一行标题不包含关键字");

        /**
         * 搜索筛选实现
         */
        selectClick();
        WebElement search_tool_tf =  waitWebElementByxpath("//*[@class='search_tool_tf ']");
        search_tool_tf.click();
        WebElement startDateEle =  waitWebElementByxpath("//*[@class=\"c-tip-custom-st\"]/input");
        WebElement endDateEle = getEnddate();
        //输入开始时间与结束时间
        startDateEle.clear();
        startDateEle.sendKeys(startDate);
        endDateEle.clear();
        endDateEle.sendKeys(endDate);
        //点击"确认"
        confirmClick();

        //检查预期搜索结果
        WebElement h3ByFilter = waitWebElementByxpath("//*[@id='content_left']//h3");
        String expectedFilter = h3ByFilter.getText();
        if (!expectedFilter.contains(keyword))
            throw new AssertionError("筛选后结果不符合预期");
    }
}
