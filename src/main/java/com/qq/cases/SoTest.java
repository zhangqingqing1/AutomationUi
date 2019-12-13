package com.qq.cases;

import com.qq.util.DataProvider_zqq;
import com.qq.util.MyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.io.IOException;
import java.text.ParseException;


/**
 * @description: 360搜索测试
 * @author: lu
 * @date 2019/12/12 11:01
 */
public class SoTest {
        private static WebDriver driver;
        WebDriverWait wait;

        @BeforeClass
        public void beforeClass() throws InterruptedException, IOException, ParseException {
            //定义driver
            driver = MyUtil.getDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 10);//全局设置显示等待10s,超时则异常
        }

      @Test(dataProvider = "iterator",dataProviderClass = DataProvider_zqq.class)
      public void searchTest(String keyword, String startTime, String endTime) throws InterruptedException {
            //搜索hello world
            driver.get("https://www.baidu.com/");
            driver.findElement(By.id("kw")).sendKeys(keyword);
            driver.findElement(By.id("su")).click();

            //搜索结果
            WebElement h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content_left']//h3")));
            //检查标题内容
            String expected = h3.getText();
            if (expected.contains(keyword)) {
                System.out.println("搜索成功，符合预期");
            } else {
                System.out.println("搜索结果不符合预期");
            }
        }



        @AfterClass
        public void AfterTest() {
            driver.quit();
        }

    }




