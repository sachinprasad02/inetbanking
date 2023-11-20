package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rbGender;
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtDob;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using ="pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtMobileNumber;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmail;
	
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;


    public void clickAddCustomer() {
	    lnkAddNewCustomer.click();
    }

    public void customerName(String cname) {
	    txtCustomerName.sendKeys(cname);
    }

    public void customerGender(String cgender) {
	    rbGender.click();
    }

    public void customerDob(String mm, String dd, String yyyy) {
	    txtDob.sendKeys(mm);
	    txtDob.sendKeys(dd);
	    txtDob.sendKeys(yyyy);
    }	
	public void customerAddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}
	
	public void customerCity(String ccity) {
		txtCity.sendKeys(ccity);
	}
	
	public void customerState(String cstate) {
		txtState.sendKeys(cstate);
	}
	
	public void customerPin(String cpin) {
		txtPin.sendKeys(cpin);
	}
	
	public void customerPin(int cpin) {
		txtPin.sendKeys(String.valueOf(cpin));
	}
	
	public void customerMobileNumber(String cmobilenumber) {
		txtMobileNumber.sendKeys(cmobilenumber);
	}
	
	public void customerEmail(String cemail) {
		txtEmail.sendKeys(cemail);
	}
	
	public void customerPassword(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}

}