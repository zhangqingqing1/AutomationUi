package com.qq.util;


import com.qq.demo.Demo_zqq;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class MyUtil  {
   // 获取driver
    public  static WebDriver getDriver() throws IOException {
        String machineName = System.getProperty("user.name");
        Properties properties = new Properties();
        properties.load(MyUtil.class.getResourceAsStream("/chromeversion.properties"));
        String chromeVersion = properties.getProperty(machineName);
        String driverPath = Demo_zqq.class.getResource("/").getPath() + "drivers/chromedriver" + chromeVersion + ".exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver();
    }
//获取开始日期
    public static String getDateStart() throws ParseException {
        return Calendar.getInstance().get(Calendar.YEAR) + "-01-01";
    }
//获取结束日期
    public static String getDateEnd() {
        return new SimpleDateFormat("yyyy-MM-dd ").format(new Date());
    }
// 获取指定日期0：0：0 时间戳
    public static Long getDayBegin(String datestr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(datestr);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return c.getTimeInMillis();
    }

    // 获取指定日期23：59：59时间戳
    public static Long getDayEnd(String datestrr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(datestrr);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        c.set(Calendar.MINUTE, 59);
        //将秒至59
        c.set(Calendar.SECOND, 59);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        // 获取本月最后一天的时间戳
        return c.getTimeInMillis();
    }

}

