package com.wong.www.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

/**
 * @author wong
 * @date Created in 2020/9/15 20:36
 * @Description Google驱动类，初始化浏览器
 * @Version 1.0
 */
public class GoogleDriver {
    /**
     * 公共driver，用于操作浏览器
     */
    private WebDriver driver;

    /**
     * 构造方法，设置浏览器的启动参数
     *
     * @param driverPath Chromedriver的路径
     */
    public GoogleDriver(String driverPath) {
        //设置Google浏览器的driver路径
        System.setProperty("webdriver.chrome.driver", driverPath);
        //设置谷歌可选项
        ChromeOptions options = new ChromeOptions();
        //设置去除浏览器自动化控制检测
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        //加载谷歌用户文件
        options.addArguments("--user-data-dir=C:\\Users\\wong\\AppData\\Local\\Google\\Chrome\\User Data");
        try {
            driver = new ChromeDriver(options);
            //浏览器最大化
            driver.manage().window().maximize();
            //默认打开空白页
            driver.get("about:blank");
            AutoLogger.log.info("chrome.driver创建完成");
        } catch (Exception e) {
            AutoLogger.log.info("chrome.driver创建错误，请检查");
            AutoLogger.log.info(e, e.fillInStackTrace());
        }
    }

    /**
     * 获取操作浏览器的driver
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return this.driver;
    }
}
