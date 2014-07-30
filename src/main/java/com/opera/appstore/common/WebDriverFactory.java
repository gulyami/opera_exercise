package com.opera.appstore.common;

import org.openqa.selenium.WebDriver;

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
