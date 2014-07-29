package com.opera.test.common;

import org.apache.commons.lang.RandomStringUtils;

import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class CommonMethods {

    public static String getRandomString(int size) {
        return RandomStringUtils.randomAlphanumeric(size).toUpperCase();
    }

    public static String getRandomValueFromList(List<String> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

}
