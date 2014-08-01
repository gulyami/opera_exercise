package com.opera.appstore.common;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */

@Component
public class WebDriverService {

    private static Logger logger = Logger.getLogger(WebDriverService.class);
    @Autowired
    private WebDriverFactory webDriverFactory;

    private WebDriver driver;

    @PostConstruct
    private void initializeDriver() {
        driver = webDriverFactory.getWebDriver();
    }

    public WebDriver getUrl(String url) {
        driver.get(url);
        return driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void closeDriver() {
        try {
            this.driver.close();
        } catch (Exception e) {
            logger.info("Some problems were occurred during web driver closing");
        }
    }

}
