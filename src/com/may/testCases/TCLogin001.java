package com.may.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.may.commonFunctions.BaseClass;
import com.may.pageObjects.LoginPageObjects;

public class TCLogin001 extends BaseClass{
	
	@Test
	public void login(){
		
		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.txtUsername.sendKeys(properties.getProperty("username"));
		LoginPageObjects.txtPassword.sendKeys(properties.getProperty("password"));
		LoginPageObjects.submitButton.click();
	}

}
