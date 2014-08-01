package com.opera.appstore.common;

import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 21:11
 * To change this template use File | Settings | File Templates.
 */
@Component
public class WebDriverFactory {

    @Autowired
    private OperaConfig operaConfig;

    public WebDriver getWebDriver() {
        WebDriver driver = null;
        switch (operaConfig.getBrowser()) {
            case FF:
                FirefoxBinary binary = new FirefoxBinary(new File(operaConfig.getFireFoxBrowserPath()));
                FirefoxProfile profile = new FirefoxProfile();
                driver = new FirefoxDriver(binary, profile);
                driver.manage().window().maximize();
                break;

            case IE:
                //todo configure driver
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                break;

            case CHROME:
                //todo configure driver
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

            default:
                //todo configure driver
                driver = new HtmlUnitDriver() {
                    protected WebClient modifyWebClient(WebClient client) {
                        // This class ships with HtmlUnit itself
                        DefaultCredentialsProvider creds = new DefaultCredentialsProvider();

                        // Set some example credentials
                        creds.addCredentials(operaConfig.getLogin(), operaConfig.getPassword());

                        // And now add the provider to the webClient instance
                        client.setCredentialsProvider(creds);

                        return client;
                    }
                };
                break;
        }
        return driver;
    }

}
