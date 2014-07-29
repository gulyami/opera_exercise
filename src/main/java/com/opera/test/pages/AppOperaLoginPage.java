package com.opera.test.pages;

import com.opera.test.common.OperaConfig;
import com.opera.test.pages.constants.AppOperaLoginPageConstants;
import com.opera.test.pages.constants.ManageProductsPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 20:17
 * To change this template use File | Settings | File Templates.
 */
public class AppOperaLoginPage extends BasePage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, xpath = AppOperaLoginPageConstants.LOGIN_INPUT_BOX)
    private WebElement loginInputBox;

    @FindBy(how = How.XPATH, xpath = AppOperaLoginPageConstants.PASSWORD_INPUT_BOX)
    private WebElement passwordInputBox;

    @FindBy(how = How.XPATH, xpath = AppOperaLoginPageConstants.REMEMBER_CHECKBOX)
    private WebElement rememberCHeckBox;

    @FindBy(how = How.XPATH, xpath = AppOperaLoginPageConstants.LOGIN_BUTTON)
    private WebElement loginButton;

    @FindBy(how = How.XPATH, xpath = AppOperaLoginPageConstants.FORGOT_YOUR_PASSWORD_LINK)
    private WebElement forgotYourPasswordLink;


    public AppOperaLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputLogin(String login) {
        inputText(loginInputBox, login);
    }

    public void inputPassword(String password) {
        inputText(passwordInputBox, password);
    }


    public ManageProductsPage login() {
        inputLogin(OperaConfig.LOGIN);
        inputPassword(OperaConfig.PASSWORD);
        clickOn(loginButton);
        //sorry for hard code had less time to make up a decision
        waitUntilDisplayed(this.driver, By.xpath(ManageProductsPageConstants.POPUP));
        clickOn(driver.findElement(By.xpath(ManageProductsPageConstants.CLOSE_POPUP)));
        return new ManageProductsPage(this.driver);
    }


}
