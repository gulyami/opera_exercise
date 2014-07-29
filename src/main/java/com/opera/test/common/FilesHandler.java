package com.opera.test.common;

import org.apache.log4j.Logger;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.opera.test.common.CommonMethods.getRandomString;
import static com.opera.test.common.CommonMethods.getRandomValueFromList;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 */
public class FilesHandler {

    private static Logger logger = Logger.getLogger(FilesHandler.class);

    //todo add check for file format
    public static List<File> getAllFilesFromFolder(File folder) {
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
    public static List<File> getOneFileFromList(List<File> fileList) {
        List<File> files = new ArrayList<File>();
        Random r = new Random();
        files.add(fileList.get(r.nextInt(fileList.size())));
        return files;
    }

    public static void scaleImageAndSave(File file, int height, int width) throws IOException {
        BufferedImage img = ImageIO.read(file); // load image
        BufferedImage thumbImg = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, height, width, Scalr.OP_ANTIALIAS);
        File f2 = new File(OperaConfig.THUMBNAILS + "\\" + getRandomString(10) + ".jpg");
        ImageIO.write(thumbImg, "jpg", f2);

    }

    public static void transformImages(File folder, int height, int width) throws IOException {
        for (File file : getAllFilesFromFolder(folder)) {
            scaleImageAndSave(file, height, width);
        }
    }

}
