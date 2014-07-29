package com.opera.test.pages;

import com.opera.test.common.StaticData;
import com.opera.test.common.WebDriverService;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 14:09
 * To change this template use File | Settings | File Templates.
 */
public class BasePage {

    private final Logger logger = Logger.getLogger(BasePage.class);

    public BasePage() {
    }

    public void clickOn(WebElement webElement) {
        if (webElement.isDisplayed() && webElement.isEnabled()) {
            if (webElement.isSelected()) {
                logger.info("Web element has been already selected");
            } else {
                webElement.click();
                try {
                    logger.info("Web element with id - " + webElement.getAttribute("id") + " selected successfully");
                } catch (Exception e) {
                    logger.info("Web element selected successfully");
                }
            }
        }
    }

    public void inputText(WebElement element, String text) {
        try {
            element.sendKeys(text);
            logger.info("Inputted text: " + text);
        } catch (Exception e) {
            logger.info("Unable to enter text");
        }
    }

    public void closeAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void waitUntilDisplayed(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, StaticData.TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilEnabled(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, StaticData.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void uploadFile(WebElement element, String filePath) {
        element.sendKeys(filePath);
    }

    public void selectDropDownValue(WebElement webElement, String value) {
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
        logger.info(value + " selected");
    }

    public List<String> getDropDownValues(WebElement webElement) {
        Select select = new Select(webElement);
        List<String> options = new ArrayList<String>();
        for (WebElement element : select.getOptions()) {
            options.add(element.getText());
        }
        ;
        return options;
    }

    public void selectCheckBox(WebElement element, boolean condition) {
        if (condition) {
            if (!element.isSelected()) {
                clickOn(element);
            }
        } else {
            if (element.isSelected()) {
                clickOn(element);
            }
        }
    }


}
