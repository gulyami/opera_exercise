package com.opera.tests;

import com.opera.appstore.common.FilesHandler;
import com.opera.appstore.common.OperaConfig;
import com.opera.appstore.common.StaticData;
import com.opera.appstore.pages.AppOperaLoginPage;
import com.opera.appstore.pages.ManageProductsPage;
import com.opera.configuration.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public class SimpleTest extends BaseTest {

    @Test
    public void simpleTest() throws Exception {

        webDriverService.getUrl(operaConfig.getUrl());

        AppOperaLoginPage appOperaLoginPage = new AppOperaLoginPage(webDriverService.getDriver(), operaConfig);

        //login to application
        ManageProductsPage manageProductsPage = appOperaLoginPage.login();

        //Go to manage products form
        manageProductsPage.clickOnManageProductsLink();

        //go to add product form
        manageProductsPage.clickOnAddProductLink();

        //fill all mandatory fields
        manageProductsPage.fillMandatoryFields();

        //upload images
        manageProductsPage
                .uploadFiles(
                        filesHandler.getAllFilesFromFolder(new File(operaConfig.getImages())), manageProductsPage
                        .getUploadWebElement(), StaticData.UploadType.IMAGE);

        //resize uploaded images to thumbnails (preffered sixe 512x512)
        filesHandler.transformImages(new File(operaConfig.getImages()), 512, 512);

        //upload generated thumbnails .. here I've got a little miss understanding. I've thought that thumbnail can be loaded in the same way as images
        manageProductsPage.uploadFiles(
                filesHandler.getOneFileFromList(filesHandler.getAllFilesFromFolder(new File(operaConfig.getThumbNails()))), manageProductsPage
                .getUploadThumbnails(), StaticData.UploadType.THUMBNAIL);

        // save and continue
        manageProductsPage.saveAndContinue();

        //fill all mandatory fields on Mange Build form
        manageProductsPage.manageBuild();

        //upload apk file
        manageProductsPage.uploadFiles(
                filesHandler.getAllFilesFromFolder(new File(operaConfig.getApkPath())), manageProductsPage
                .getUploadApk(), StaticData.UploadType.APK);

        //save build
        manageProductsPage.saveBuild();

        //go to ManageProducts form
        manageProductsPage.clickOnManageProductsLink();

    }
}
