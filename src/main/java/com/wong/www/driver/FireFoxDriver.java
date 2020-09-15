package com.wong.www.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

/**
 * @author wong
 * @date Created in 2020/9/15 20:55
 * @Description 火狐浏览器驱动，设置火狐浏览器的相关参数
 * @Version 1.0
 */
public class FireFoxDriver {
    private WebDriver driver;

    /**
     * 构造方法，实例完成后得到一个浏览器对象
     *
     * @param foxProPath 火狐浏览器安装位置
     * @param driverPath 火狐浏览器的driver，注意版本对应
     */
    public FireFoxDriver(String foxProPath, String driverPath) {
        //设置Firefox  driver路径
        System.setProperty("webdriver.gecko.driver", driverPath);
        //设置Firefox的安装路径
        if (foxProPath != null && foxProPath.length() > 0) {
            System.setProperty("webdriver.firefox.bin", foxProPath);
        }
        FirefoxOptions options = new FirefoxOptions();
        //加载用户配置文件
        File pro = new File("C:\\\\Users\\\\wong\\\\AppData\\\\Roaming\\\\Mozilla\\\\Firefox\\\\Profiles\\\\0n7bc4yl.default-release");
        FirefoxProfile proFile = new FirefoxProfile(pro);
        options.setProfile(proFile);
        try {
            driver = new FirefoxDriver(options);
            //设置浏览器最大化
            driver.manage().window().maximize();
            driver.get("about:blank");
            AutoLogger.log.info("firefox.driver创建完成");
        } catch (Exception e) {
            AutoLogger.log.info("firefox.driver创建失败，请检查");
            AutoLogger.log.info(e, e.fillInStackTrace());
        }

    }

    /**
     * 获取有用于操作浏览器的driver
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return this.driver;
    }
}
