package com.opera.appstore.common;

import org.apache.log4j.Logger;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.opera.appstore.common.CommonMethods.getRandomString;


/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 */

@Component
public class FilesHandler {

    private static Logger logger = Logger.getLogger(FilesHandler.class);

    @Autowired
    private OperaConfig operaConfig;

    //todo add check for file format
    public List<File> getAllFilesFromFolder(File folder) {
        List<File> filesList = new ArrayList<File>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                getAllFilesFromFolder(fileEntry);
            } else {
                logger.info(fileEntry.getName() + " added to the files list");
                filesList.add(fileEntry);
            }
        }
        return filesList;
    }

    // Sorry for such hard code but I have not enough time to refactor methods :)
    // stub for thumbnails upload, due to only one img can be loaded
    public List<File> getOneFileFromList(List<File> fileList) {
        List<File> files = new ArrayList<File>();
        Random r = new Random();
        files.add(fileList.get(r.nextInt(fileList.size())));
        return files;
    }

    public void scaleImageAndSave(File file, int height, int width) throws IOException {
        BufferedImage img = ImageIO.read(file); // load image
        BufferedImage thumbImg = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, height, width, Scalr.OP_ANTIALIAS);
        File f2 = new File(operaConfig.getThumbNails() + "\\" + getRandomString(10) + ".jpg");
        ImageIO.write(thumbImg, "jpg", f2);

    }

    public void transformImages(File folder, int height, int width) throws IOException {
        for (File file : getAllFilesFromFolder(folder)) {
            scaleImageAndSave(file, height, width);
        }
    }

}
