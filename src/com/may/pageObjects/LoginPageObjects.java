package com.may.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
	
	//Elements
	
		@FindBy(name="uid")
		public static WebElement txtUsername;
		
		@FindBy(name="password")
		public static WebElement txtPassword;
		
		@FindBy(name="btnLogin")
		public static WebElement submitButton;

}
