package com.opera.test.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 21:11
 * To change this template use File | Settings | File Templates.
 */
public class WebDriverFactory {

    public static WebDriver getWebDriver(String browser) {
        return WebDriverFactory.getWebDriver(OperaConfig.BROWSER);
    }

}
