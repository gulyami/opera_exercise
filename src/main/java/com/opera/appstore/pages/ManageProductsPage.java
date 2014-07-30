package com.opera.appstore.pages;

import com.opera.appstore.common.StaticData;
import com.opera.appstore.pages.constants.ManageProductsPageConstants;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

import static com.opera.appstore.common.CommonMethods.getRandomString;
import static com.opera.appstore.common.CommonMethods.getRandomValueFromList;
import static com.opera.appstore.common.StaticData.InstallerTypeValues.DEVICE_INSTALLER;
import static com.opera.appstore.common.StaticData.PlatformValues.ANDROID;
import static com.opera.appstore.common.StaticData.TypeValues.FREEWARE;
import static com.opera.appstore.common.StaticData.VersionsValues.*;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 20:52
 * To change this template use File | Settings | File Templates.
 */
public class ManageProductsPage extends BasePage {
    private static Logger logger = Logger.getLogger(ManageProductsPage.class);

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.MESSAGE)
    private WebElement successMessage;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.ADD_PRODUCT_LINK)
    private WebElement addProductLink;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.TITLE_INPUT)
    private WebElement title;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.SHORT_DESCRIPTION_TEXTAREA)
    private WebElement shortDescription;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.FULL_DESCRIPTION_TEXTAREA)
    private WebElement fullDescription;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.UPLOAD_IMAGES)
    private WebElement uploadImages;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.UPLOAD_THUMBNAILS)
    private WebElement uploadThumbnails;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.SAVE_AND_CONTINUE_TO_BUILDS)
    private WebElement saveAndContinueButton;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.CATEGORY_SELECT)
    private WebElement categorySelect;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.TYPE_SELECT)
    private WebElement typeSelect;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.PLATFORM_SELECT)
    private WebElement platformSelect;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.INSTALLER_TYPE_SELECT)
    private WebElement installerTypeSelect;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.UPLOAD_APK)
    private WebElement uploadApk;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.VERSION_SELECT)
    private WebElement versionSelect;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.ENABLE_SCREEN_RESOLUTION_CHKBX)
    private WebElement enableScreenResolutionChckbx;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.SAVE_BUILD_BTN)
    private WebElement saveBuildBtn;

    @FindBy(how = How.XPATH, xpath = ManageProductsPageConstants.MANAGE_PRODUCTS_LINK)
    private WebElement manageProducts;


    public ManageProductsPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFiles(List<File> filesToUpload, WebElement webElement, StaticData.UploadType uploadType) {
        for (File file : filesToUpload) {
            try {
                uploadFile(webElement, file.getAbsolutePath());
                switch (uploadType) {
                    case THUMBNAIL: {
                        waitUntilEnabled(this.driver, By.xpath(ManageProductsPageConstants.UPLOAD_THUMBNAILS));
                        break;
                    }
                    case IMAGE: {
                        waitUntilEnabled(this.driver, By.xpath(ManageProductsPageConstants.UPLOAD_IMAGES));
                        break;
                    }
                    case APK: {
                        waitUntilEnabled(this.driver, By.xpath(ManageProductsPageConstants.UPLOAD_APK));
                        break;
                    }
                }
                logger.info("File Uploaded Successfully");
            } catch (Exception e) {
                logger.info("Unable to upload file" + file.getName());
                throw new RuntimeException("Looks like Functionality does not work correctly");
            }
        }
    }

    public void fillMandatoryFields() {
        //input title
        inputText(title, getRandomString(10));
        //input short description
        inputText(shortDescription, getRandomString(15));
        //input full description
        inputText(fullDescription, getRandomString(20));
        //select random value from Category drpdwn
        selectDropDownValue(categorySelect, getRandomValueFromList(getDropDownValues(categorySelect)));
        //select type Freeware
        selectDropDownValue(typeSelect, FREEWARE.toString());

    }

    public void manageBuild() {
        selectDropDownValue(platformSelect, ANDROID.toString());
        selectDropDownValue(installerTypeSelect, DEVICE_INSTALLER.toString());
        selectDropDownValue(versionSelect, FULL.toString());
        selectCheckBox(enableScreenResolutionChckbx, true);
        selectExtensionCheckBox("320x240");

    }


    public void selectExtensionCheckBox(String extension) {
        String xpath = ".//div[@id='advanced_compatibility_container']//input[@value='" + extension + "']";
        try {
            WebElement element = this.driver.findElement(By.xpath(xpath));

            clickOn(element);
        } catch (NoSuchElementException e) {
            logger.info("Unable to find needed extension checkbox by xpath :" + xpath);
            throw new RuntimeException("Web Element does not present on the page");
        }
    }


    public void saveAndContinue() {
        clickOn(saveAndContinueButton);
        waitUntilDisplayed(this.driver, By.xpath(ManageProductsPageConstants.PLATFORM_SELECT));
        logger.info("Form saved successfully");
    }

    public void clickOnManageProductsLink() {
        clickOn(manageProducts);
        //todo add wait for another form
    }

    public void clickOnAddProductLink() {
        clickOn(addProductLink);
        waitUntilDisplayed(this.driver, By.xpath(ManageProductsPageConstants.TITLE_INPUT));
    }

    public void saveBuild() {
        clickOn(saveBuildBtn);
        waitUntilDisplayed(this.driver, By.xpath(ManageProductsPageConstants.MESSAGE));
        logger.info("Form saved successfully");
    }

    public WebElement getUploadWebElement() {
        return this.uploadImages;
    }

    public WebElement getUploadThumbnails() {
        return this.uploadThumbnails;
    }

    public WebElement getUploadApk() {
        return this.uploadApk;
    }


}
