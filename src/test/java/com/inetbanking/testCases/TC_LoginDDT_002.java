package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(user);
        logger.info("Username provided");
        lp.setPassword(pwd);
        logger.info("Password provided");
        lp.clickSubmit();
        logger.info("Clicked submit button");

        if(isAlertPresent()==true){
            driver.switchTo().alert().accept(); // close the alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warning("Login failed");
        }else{
            Assert.assertTrue(true);
            logger.warning("Login passed");
            lp.clickLogout();
            driver.switchTo().alert().accept(); // close the logout alert
            driver.switchTo().defaultContent();
        }
    }

    // user defined method to check alert is present or not
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @DataProvider(name = "LoginData")
    public Object[] getData() throws IOException {
        String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/Banking-Login-Data.xlsx";
        int rownum = XLUtils.getRowCount(path, "Sheet1");
        int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
        String loginData[][] = new String[rownum][colcount];
        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j); // 1   0

            }
        }
        return loginData;
    }

}
