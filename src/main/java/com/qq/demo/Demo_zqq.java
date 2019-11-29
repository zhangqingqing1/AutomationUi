package com.qq.demo;

import com.qq.util.GetDate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

/**
 * @Desc
 * @Author qiwei.lu@b-and-qchina.com
 * @Date 2019/11/26 15:22
 */
public class Demo_zqq {
    //private static final String driverPath = Demo.class.getResource("/").getPath() + "drivers/chromedriver77.0.3865.90.exe";
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException, ParseException {
        String machineName = System.getProperty("user.name");
        Properties properties = new Properties();
        properties.load(Demo_zqq.class.getResourceAsStream("/chromeversion.properties"));
        String chromeVersion = properties.getProperty(machineName);
        String driverPath = Demo_zqq.class.getResource("/").getPath() + "drivers/chromedriver" + chromeVersion + ".exe";


        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //搜索hello world
        String keyword="hello world";
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys(keyword);
        driver.findElement(By.id("su")).click();

        //检查预期
        Thread.sleep(1000 * 3);//等待搜索结果
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
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div[2]/div")).click();
        Thread.sleep(1000 * 2);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/span[2]")).click();
        Thread.sleep(1000 * 2);
        // 输入时间
        driver.findElement(By.xpath("//*[@id=\"c-tips-container\"]/div[1]/div/div/ul/li[6]/p[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"c-tips-container\"]/div[1]/div/div/ul/li[6]/p[1]/input")).sendKeys(GetDate.getDateStart());
        driver.findElement(By.xpath("//*[@id=\"c-tips-container\"]/div[1]/div/div/ul/li[6]/p[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"c-tips-container\"]/div[1]/div/div/ul/li[6]/p[2]/input")).sendKeys(GetDate.getDateEnd());
        Thread.sleep(1000 * 2);
        driver.findElement(By.xpath("//*[@id=\"c-tips-container\"]/div[1]/div/div/ul/li[6]/a")).click();
        Thread.sleep(1000 * 3);
        //搜索结果
        WebElement h4 = driver.findElement(By.xpath("//*[@id=\"1\"]/h3/a/em"));//第一行搜索结果的标题
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
