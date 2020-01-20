package com.qq.cases;

import com.qq.factory.WebDriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

/**
 * @author: lu
 */
public class CommonTest {
    @BeforeTest
    public void beforeTest() {
        try {
            WebDriverFactory.getDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void afterTest() {
        WebDriverFactory.close();
    }

}
