package com.inetbanking.pageObjects;

import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class AddNewCustomerPage {

    WebDriver driver;

    //@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
    @FindBy(partialLinkText = "New Customer")
    @CacheLookup
    WebElement lnkAddNewCustomer;

    @FindBy(name = "name")
    @CacheLookup
    WebElement txtCustomerName;

    @FindBy(css = "[value='m']")
    @CacheLookup
    WebElement rdGender;

    @FindBy(name = "dob")
    @CacheLookup
    WebElement txtDob;

    @FindBy(name = "addr")
    @CacheLookup
    WebElement txtAddress;

    @FindBy(name = "city")
    @CacheLookup
    WebElement txtCity;

    @FindBy(name = "state")
    @CacheLookup
    WebElement txtState;

    @FindBy(name = "pinno")
    @CacheLookup
    WebElement txtPIN;

    @FindBy(name = "telephoneno")
    @CacheLookup
    WebElement txtTelephoneNo;

    @FindBy(name = "emailid")
    @CacheLookup
    WebElement txtEmailId;

    @FindBy(name = "password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(name = "sub")
    @CacheLookup
    WebElement btnSubmit;

    public AddNewCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddNewCustomer(){
       lnkAddNewCustomer.click();
    }
    public void enterName(String customer_name){
        txtCustomerName.sendKeys(customer_name);
    }

    public void clickGender(String customer_gender){
        rdGender.click();
    }

    public void enterDOB(String mm, String dd, String yy) throws InterruptedException {
        txtDob.sendKeys(mm);
        Thread.sleep(5000);
        txtDob.sendKeys(dd);
        Thread.sleep(5000);
        txtDob.sendKeys(yy);
        Thread.sleep(5000);
    }

    public void enterAddress(String customer_address){
        txtAddress.sendKeys(customer_address);
    }

    public void enterCity(String customer_city){
        txtCity.sendKeys(customer_city);
    }

    public void enterState(String customer_state){
        txtState.sendKeys(customer_state);
    }

    public void enterPin(String customer_pin){
        txtPIN.sendKeys(customer_pin);
    }

    public void enterMobile(String customer_mobile){
        txtTelephoneNo.sendKeys(customer_mobile);
    }

    public void enterEmailID(String email){
        txtEmailId.sendKeys(email);
    }

    public void enterPassword(String pwd){
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    public void clickSubmit(){
        btnSubmit.click();
    }

}
