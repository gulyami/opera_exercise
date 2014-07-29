package com.opera.test.common;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
@Component
public class OperaConfig {

    private static final Logger logger = Logger.getLogger(OperaConfig.class);

    public final static String BROWSER;
    public final static String BROWSER_PATH;
    public final static String IMAGES;
    public final static String THUMBNAILS;
    public final static String PASSWORD;
    public final static String LOGIN;
    public final static String URL;
    public final static String APK;


    static {
        URL = getPropertyValue("app.url", "src\\main\\resources\\" + getSystemVariable("env") + ".properties");
        BROWSER = getSystemVariable("browser");
        BROWSER_PATH = getPropertyValue("browser.path", "src\\main\\resources\\" + getSystemVariable("env") + ".properties");
        IMAGES = getPropertyValue("img.path", "src\\main\\resources\\" + getSystemVariable("env") + ".properties");
        THUMBNAILS = getPropertyValue("thumb.path", "src\\main\\resources\\" + getSystemVariable("env") + ".properties");
        PASSWORD = getPropertyValue("password", "src\\main\\resources\\" + getSystemVariable("env") + ".properties");
        LOGIN = getPropertyValue("login", "src\\main\\resources\\" + getSystemVariable("env") + ".properties");
        APK = getPropertyValue("apk.path", "src\\main\\resources\\" + getSystemVariable("env") + ".properties");
    }

    private static String getPropertyValue(String value, String propertyFile) {
        Properties prop = new Properties();
        InputStream input = null;

        prop = loadProperties(prop, input, propertyFile);
        return prop.getProperty(value);
    }

    private static Properties loadProperties(Properties prop, InputStream input, String propertyFile) {
        try {

            input = new FileInputStream(propertyFile);
            if (input == null) {
                logger.info("Sorry, unable to find " + propertyFile);
                throw new FileNotFoundException("Unable to load properties");
            }
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }

    private static String getSystemVariable(String key) {
        String result = System.getenv(key);
        if (result == null) {
            result = System.getProperty("env");
        }
        return result;
    }
}
