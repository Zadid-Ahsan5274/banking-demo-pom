package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(name = "uid")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(name = "password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    @CacheLookup
    WebElement lnkLogout;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void setUserName(String uname){
        txtUserName.clear();
        txtUserName.sendKeys(uname);
    }

    public void setPassword(String pwd){
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    public void clickSubmit(){
        btnLogin.click();
    }

    public void clickLogout(){
        lnkLogout.click();
    }
}
