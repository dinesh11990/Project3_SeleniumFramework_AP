package com.may.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.may.commonFunctions.BaseClass;
import com.may.pageObjects.LoginPageObjects;

public class TCLogin001 extends BaseClass{
	
	static Logger logger = Logger.getLogger(TCLogin001.class);
	
	@Test
	public void login() throws InterruptedException{
		
		logger.info("Logging in to the application");
		
		PageFactory.initElements(driver, LoginPageObjects.class);
		
		LoginPageObjects.txtUsername.sendKeys(properties.getProperty("username"));
		LoginPageObjects.txtPassword.sendKeys(properties.getProperty("password"));
		LoginPageObjects.submitButton.click();
		Thread.sleep(3000);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
			
		}else{
			
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}

}
