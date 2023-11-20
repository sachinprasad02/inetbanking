package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider = "loginData")
	public void loginDDT(String userName, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(userName);
		logger.info("User Name Provided");
		
		loginPage.setPassword(password);
		logger.info("Password Provided");
		
		loginPage.clickSubmit();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			loginPage.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
			
		} catch (Exception e) {
			return false;			
		}
	}
	
	@DataProvider(name = "loginData")
	String[][] getData() throws IOException {
		
		String path = System.getProperty("user.dir")+"src\\test\\java\\com\\inetbanking\\testData\\LoginData.ods";
		
		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "sheet1", 1);
		
		String loginData [][] = new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			
			for(int j=0;j<colcount;j++) {
				
				loginData[i-1][j]= XLUtils.getCellData(path, "sheet1", i, j);
			}
			
		}
		return loginData;
	}

}
