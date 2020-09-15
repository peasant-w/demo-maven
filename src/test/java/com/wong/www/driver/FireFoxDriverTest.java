package com.wong.www.driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author wong
 * @date Created in 2020/9/15 21:09
 * @Description
 * @Version
 */
public class FireFoxDriverTest {
   public WebDriver driver;

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testGetDriver() {
        FireFoxDriver fireFox =  new FireFoxDriver("C:\\Program Files\\Mozilla Firefox\\firefox.exe","tools/geckodriver.exe");
        driver = fireFox.getDriver();
        driver.get("https://www.baidu.com");
        driver.close();
    }
}