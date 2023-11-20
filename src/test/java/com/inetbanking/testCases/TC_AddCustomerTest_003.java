package com.inetbanking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObject.AddCustomerPage;
import com.inetbanking.pageObject.LoginPage;


public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws IOException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(userName);
		logger.info("User Name is Provided");
		loginPage.setPassword(password);
		logger.info("Password is Provided");
		loginPage.clickSubmit();
		
		
		AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
		addCustomerPage.clickAddCustomer();
		logger.info("Providing Customer Details");
		addCustomerPage.customerName("Virat");
		addCustomerPage.customerGender("male");
		addCustomerPage.customerDob("11", "05", "1988");
		addCustomerPage.customerAddress("India");
		addCustomerPage.customerCity("Bengaluru");
		addCustomerPage.customerState("Karnataka");
		addCustomerPage.customerPin("550076");
		String number = randomNum();
		addCustomerPage.customerMobileNumber(number);
		String email = randomString()+"@gmail.com";
		addCustomerPage.customerEmail(email);
		addCustomerPage.customerPassword("abcdef");
		addCustomerPage.clickSubmit();
		logger.info("Validation Started");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) {
			Assert.assertTrue(true);
	        logger.info("Test Cases Passed");
		}
		
		else {
			logger.info("Test Cases Failed");
			captureScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	
}
