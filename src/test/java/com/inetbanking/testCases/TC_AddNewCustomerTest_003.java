package com.inetbanking.testCases;

import com.inetbanking.pageObjects.AddNewCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC_AddNewCustomerTest_003 extends BaseClass {

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("User name is provided");
        lp.setPassword(password);
        logger.info("Password is provided");
        lp.clickSubmit();
        logger.info("Clicked submit button");
        Thread.sleep(5000);
        logger.info("Providing customer details...");
        AddNewCustomerPage addNewCustomerPage = new AddNewCustomerPage(driver);
        addNewCustomerPage.clickOnAddNewCustomer();
        addNewCustomerPage.enterName("Tom Day");
        addNewCustomerPage.clickGender("male");
        addNewCustomerPage.enterDOB("04", "20", "1996");
        Thread.sleep(5000);
        addNewCustomerPage.enterCity("London");
        addNewCustomerPage.enterState("Wales");
        addNewCustomerPage.enterPin("123456");
        addNewCustomerPage.enterMobile("+123456789");
        addNewCustomerPage.enterEmailID(Utils.generateRandomString() + "@mail.com");
        addNewCustomerPage.clickSubmit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
        logger.info("Validation started...");
        if (res == true) {
            Assert.assertTrue(true);
            logger.info("Test Case Passed - Customer Created Successfully");
        } else {
            logger.info("Test Case Failed - Some error occurred");
            captureScreen(driver, "addNewCustomer");
            Assert.assertTrue(false);
        }
    }


}
