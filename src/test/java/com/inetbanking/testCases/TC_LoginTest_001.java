package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {
        driver.get(baseURL);
        logger.info("URL is opened");
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Entered username");
        lp.setPassword(password);
        logger.info("Entered password");
        lp.clickSubmit();
        logger.info("Clicked submit button");
        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
            logger.info("Matched Tile - Test Case Passed");
        } else {
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            logger.info("Tile Not Matched - Test Case Failed");
        }
    }

}
