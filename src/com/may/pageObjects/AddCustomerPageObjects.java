package com.may.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPageObjects {
	
	
	
	//Elements
	
		@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
		public static WebElement lnkAddNewCustomer;
		
		@FindBy(name="name")
		public static WebElement custName;
		
		@FindBy(name="rad1")
		public static WebElement genDer;
		
		@FindBy(name="dob")
		public static WebElement dBirth;
		
		@FindBy(name="addr")
		public static WebElement address;
		
		@FindBy(name="city")
		public static WebElement city;
		
		@FindBy(name="state")
		public static WebElement state;
		
		@FindBy(name="pinno")
		public static WebElement pin;
		
		@FindBy(name="telephoneno")
		public static WebElement mobile;
		
		@FindBy(name="emailid")
		public static WebElement mail;
		
		@FindBy(name="password")
		public static WebElement pwd1;
		
		@FindBy(name="sub")
		public static WebElement sub;

}
