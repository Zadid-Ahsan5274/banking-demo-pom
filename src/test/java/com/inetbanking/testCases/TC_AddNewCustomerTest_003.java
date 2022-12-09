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
        Thread.sleep(3000);
        logger.info("Providing customer details...");
        AddNewCustomerPage addNewCustomerPage = new AddNewCustomerPage(driver);
        addNewCustomerPage.clickOnAddNewCustomer();
        addNewCustomerPage.enterName("Tom Day");
        Thread.sleep(3000);
        addNewCustomerPage.clickGender("male");
        Thread.sleep(3000);
        addNewCustomerPage.enterDOB("04", "20", "1996");
        Thread.sleep(3000);
        addNewCustomerPage.enterAddress("London");
        //Thread.sleep(3000);
        addNewCustomerPage.enterCity("United Kingdom");
        //Thread.sleep(3000);
        addNewCustomerPage.enterState("Wales");
        //Thread.sleep(3000);
        addNewCustomerPage.enterPin("123456");
        //Thread.sleep(3000);
        addNewCustomerPage.enterMobile("+123456789");
        //Thread.sleep(3000);
        addNewCustomerPage.enterEmailID(Utils.generateRandomString() + "@mail.com");
        //Thread.sleep(3000);
        addNewCustomerPage.enterPassword("Abcde@12345");
        Thread.sleep(3000);
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
