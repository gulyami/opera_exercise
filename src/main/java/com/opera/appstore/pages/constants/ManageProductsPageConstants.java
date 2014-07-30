package com.opera.appstore.pages.constants;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 21:37
 * To change this template use File | Settings | File Templates.
 */
public class ManageProductsPageConstants {

    public static final String POPUP = ".//div[@id='splash' and @class='popup']";
    public static final String CLOSE_POPUP = ".//a[@class='close' and @title='Close popup']";
    public static final String TITLE_INPUT = ".//form[@id='save-product']//label[contains(.,'Title:')]//..//..//input[@type='text']";
    public static final String SHORT_DESCRIPTION_TEXTAREA = ".//form[@id='save-product']//label[contains(.,'Short Description:')]//..//..//textarea";
    public static final String FULL_DESCRIPTION_TEXTAREA = ".//form[@id='save-product']//label[contains(.,'Full Description:')]//..//..//textarea";
    public static final String UPLOAD_IMAGES = ".//div[@id='product-images-langspec-en']//div[@class='file-list-actions']//span//input[@type='file']";
    public static final String UPLOAD_THUMBNAILS = ".//div[@id='product-thumbnail']//div[@class='file-list-actions']//span//input[@type='file']";
    public static final String SAVE_AND_CONTINUE_TO_BUILDS = ".//input[@type='submit' and @value='Save and continue to builds']";
    public static final String CATEGORY_SELECT = ".//select[@id='raw_category_id']";
    public static final String TYPE_SELECT = ".//select[@name='type']";
    public static final String PLATFORM_SELECT = ".//label[contains(.,'Platform')]//..//..//select";
    public static final String INSTALLER_TYPE_SELECT = ".//label[contains(.,'Installer type:')]//..//..//select";
    public static final String VERSION_SELECT = ".//label[contains(.,'Version:')]//..//..//select";
    public static final String UPLOAD_APK = ".//label[contains(.,'APK file')]//..//..//input[@type='file']";
    public static final String ENABLE_SCREEN_RESOLUTION_CHKBX = ".//div[@id='advanced_compatibility_container']//input[@name='advanced_resolution_selection']";
    public static final String SAVE_BUILD_BTN = ".//input[@type='submit' and @value='Save build']";
    public static final String MESSAGE = ".//div[@class='session-flash session-flash-notice']";
    public static final String MANAGE_PRODUCTS_LINK = ".//ul[@id='mainmenu']/*[contains(.,'Manage Products')]/a";
    public static final String ADD_PRODUCT_LINK = ".//li[contains(.,'Add Product')]/a";

}
