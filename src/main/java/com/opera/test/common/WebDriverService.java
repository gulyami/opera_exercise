package com.opera.test.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
@Component
public class WebDriverService {

    private WebDriver driver;

    public WebDriver initializeDriver() {
        if (OperaConfig.BROWSER.equals("FF")) {
            //todo configure driver
            FirefoxBinary binary = new FirefoxBinary(new File(OperaConfig.BROWSER_PATH));
            FirefoxProfile profile = new FirefoxProfile();
            driver = new FirefoxDriver(binary, profile);
            driver.manage().window().maximize();
            return driver;
        } else if (OperaConfig.BROWSER.equals("IE")) {
            //todo configure driver
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            return driver;
       /* } else if (OperaConfig.BROWSER.equals("OP")) {
            //todo configure driver
            driver = new OperaDriver();
            driver.manage().window().maximize();
            return driver;*/
        } else if (OperaConfig.BROWSER.equals("CH")) {
            //todo configure driver
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        } else {
            //todo configure driver
            driver = new HtmlUnitDriver();
            driver.manage().window().maximize();
            return driver;
        }

    }

    public WebDriver getUrl(String url) {
        driver.get(url);
        return driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }


}
