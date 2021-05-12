package com.may.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.may.commonFunctions.BaseClass;
import com.may.pageObjects.LoginPageObjects;

public class TCLogin001 extends BaseClass{
	
	static Logger logger = Logger.getLogger(TCLogin001.class);
	
	@Test
	public void login(){
		
		logger.info("Logging in to the application");
		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.txtUsername.sendKeys(properties.getProperty("username"));
		LoginPageObjects.txtPassword.sendKeys(properties.getProperty("password"));
		LoginPageObjects.submitButton.click();
	}

}
