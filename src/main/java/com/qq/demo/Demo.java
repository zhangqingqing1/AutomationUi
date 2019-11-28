package com.qq.demo;

import com.qq.enums.MachineChromeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @Desc
 * @Author qiwei.lu@b-and-qchina.com
 * @Date 2019/11/26 15:22
 */
public class Demo {
    //private static final String driverPath = Demo.class.getResource("/").getPath() + "drivers/chromedriver77.0.3865.90.exe";
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String machineName = System.getProperty("user.name");
        String chromeVersion = MachineChromeMap.getChromeVersion(machineName);
        String driverPath = Demo.class.getResource("/").getPath() + "drivers/chromedriver" + chromeVersion + ".exe";



        String keyWorld = "hello world";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //搜索hello world
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys(keyWorld);
        driver.findElement(By.id("su")).click();

        //检查预期
        Thread.sleep(1000 * 3);//等待搜索结果
        //搜索结果
        WebElement h3 = driver.findElement(By.xpath("//*[@id='content_left']//h3"));//第一行搜索结果的标题
        //检查标题内容
        String expected = h3.getText();
        if (expected.contains(keyWorld)) {
            System.out.println("搜索成功，符合预期");
        } else {
            System.out.println("搜索结果不符合预期");
        }

        //关闭浏览器连接，释放资源
        driver.quit();
    }
}
