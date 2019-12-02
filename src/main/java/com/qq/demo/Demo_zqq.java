package com.qq.demo;

import com.qq.util.MyUtil;
import com.qq.util.MyWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.ParseException;
import java.util.function.Function;

/**
 * @Desc
 * @Author qiwei.lu@b-and-qchina.com
 * @Date 2019/11/26 15:22
 */
public class Demo_zqq {
    //private static final String driverPath = Demo.class.getResource("/").getPath() + "drivers/chromedriver77.0.3865.90.exe";
    private static WebDriver driver;


    public static void main(String[] args) throws InterruptedException, IOException, ParseException {
         //定义driver
         driver = MyUtil.getDriver();
          Function function = (str)->{
            WebDriverWait wait = new WebDriverWait(driver, 5); // 设置等待时间， 最大等待 5 秒
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(String.valueOf(str))));

        };
        driver.manage().window().maximize();

        //搜索hello world
        String keyword="hello world";
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys(keyword);
        driver.findElement(By.id("su")).click();

        //检查预期
       MyWait myWait = new MyWait("//*[@id='content_left']//h3");
       Object until = myWait.until(function);
       System.out.println(until);
        //搜索结果
        WebElement h3 = driver.findElement(By.xpath("//*[@id='content_left']//h3"));//第一行搜索结果的标题
        //检查标题内容
        String expected = h3.getText();
        if (expected.contains(keyword)) {
            System.out.println("搜索成功，符合预期");
        } else {
            System.out.println("搜索结果不符合预期");
        }
        //任务2 在搜索出hello world的基础上，做筛选，自定义时间，当年的1月1号到今天（程序运行的这一天），然后再校验第一行搜索结果标题是不是包含hello world
        driver.findElement(By.className("search_tool")).click();
        Thread.sleep(1000 * 2);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/span[2]")).click();
        Thread.sleep(1000 * 2);
        // 输入时间
        driver.findElement(By.name("st")).clear();
        driver.findElement(By.name("st")).sendKeys(MyUtil.getDateStart());
        driver.findElement(By.name("et")).clear();
        driver.findElement(By.name("et")).sendKeys(MyUtil.getDateEnd());
        Thread.sleep(1000 * 2);
        driver.findElement(By.linkText("确认")).click();
        Thread.sleep(1000 * 3);
        //搜索结果
        WebElement h4 = driver.findElement(By.xpath("//*[@id=\"1\"]/h3/a"));//第一行搜索结果的标题
        //检查标题内容
        String expected1 = h4.getText();
        if (expected.contains(keyword)) {
            System.out.println("自定义时间搜索成功，符合预期");
        } else {
            System.out.println("搜索结果不符合预期");
        }
        //关闭浏览器连接，释放资源
       driver.quit();
    }
}
