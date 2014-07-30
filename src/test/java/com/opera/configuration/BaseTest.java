package com.opera.configuration;

import com.opera.appstore.common.WebDriverService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 15:29
 * To change this template use File | Settings | File Templates.
 */
@Component
@ContextConfiguration(locations = {"classpath:context.xml"})
public class BaseTest extends AbstractTestNGSpringContextTests {

    private static Logger logger = Logger.getLogger(BaseTest.class);

    @Autowired
    protected WebDriverService webDriverService;

    private Long time;

    @BeforeMethod
    public void setUp(Method method) {
        logger.info("----------------------------------");
        logger.info("Test name : " + method.getName());
        logger.info("----------------------------------\n");
        time = System.currentTimeMillis();
    }


    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        webDriverService.closeDriver();
        logger.info("----------------------------------");
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            logger.info("STATUS : FAILED");
            logger.info("----------------------------------");
        } else {
            logger.info("STATUS : PASSED");
            logger.info("----------------------------------");
        }

        logger.info("Time spent : " + calculateSpentTime(time) + "seconds");
    }

    private long calculateSpentTime(Long time) {
        long spentTime = (System.currentTimeMillis() - time) / 1000;
        return spentTime;
    }

}
