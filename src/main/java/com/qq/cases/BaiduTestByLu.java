package com.qq.cases;

import com.qq.pages.BaiduPageByLu;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * @author: lu
 */
public class BaiduTestByLu {
    private BaiduPageByLu baiduPage;

    @BeforeClass
    @Parameters("url")
    public void beforeClass(String url) {
        baiduPage = new BaiduPageByLu(url);
    }

    @Test(dataProvider = "provider", dataProviderClass = com.qq.util.QQDataProvider.class)
    public void searchAndFilterTest(Map<String, String> caseData) {
        String keyWord = caseData.get("keyWord");
        String startTime = caseData.get("startTime");
        String endTime = caseData.get("endTime");
        baiduPage.searchAndFilter(keyWord, startTime, endTime);
    }
}
