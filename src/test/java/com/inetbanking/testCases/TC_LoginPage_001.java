package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;

public class TC_LoginPage_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		
		logger.info("URL is opened");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(userName);
		logger.info("Entered UserName");
		
		loginPage.setPassword(password);
		logger.info("Entered Password");
		
		loginPage.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Passed");
		}
		else {
			
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
		
	}

}
