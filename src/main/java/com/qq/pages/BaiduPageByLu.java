package com.qq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author: lu
 */
public class BaiduPageByLu extends BasePage {
    public BaiduPageByLu() {
    }

    public BaiduPageByLu(WebDriver driver) {
        super(driver);
    }

    public BaiduPageByLu(String url) {
        super(url);
    }

    private By inputId = By.cssSelector("#kw");
    private By wdId = By.cssSelector("#wd");
    private By searchTool = By.cssSelector("[class='search_tool']");
    private By timeFilter = By.cssSelector("[class='search_tool_tf ']");
    private By st = By.name("st");
    private By et = By.name("et");
    private By ok = By.linkText("确认");

    /**
     * 搜索功能
     */
    public void search(String keyword) {
        sendKeys(inputId, keyword);
        click(wdId);
    }

    /**
     * 搜索并且按时间筛选结果
     */
    public void searchAndFilter(String keyword, String startTime, String endTime) {
        search(keyword);
        click(searchTool);
        click(timeFilter);
        sendKeys(st, startTime);
        sendKeys(et, endTime);
        click(ok);
    }
}
