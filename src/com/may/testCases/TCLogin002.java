package com.may.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.may.commonFunctions.BaseClass;
import com.may.pageObjects.AddCustomerPageObjects;
import com.may.pageObjects.LoginPageObjects;

public class TCLogin002 extends BaseClass {

	static Logger logger=Logger.getLogger(TCLogin002.class);


	public void login(){

		logger.info("Logging in to the application");
		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.txtUsername.sendKeys(properties.getProperty("username"));
		LoginPageObjects.txtPassword.sendKeys(properties.getProperty("password"));
		LoginPageObjects.submitButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void custDetails() throws InterruptedException{

		login();
		PageFactory.initElements(driver, AddCustomerPageObjects.class);
		AddCustomerPageObjects.lnkAddNewCustomer.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		AddCustomerPageObjects.custName.sendKeys("dinesh");
		AddCustomerPageObjects.genDer.click();
		AddCustomerPageObjects.dBirth.sendKeys("2","22","2021");
		AddCustomerPageObjects.address.sendKeys("nephal");
		AddCustomerPageObjects.city.sendKeys("Chaville");
		AddCustomerPageObjects.state.sendKeys("Tamilnadu");
		AddCustomerPageObjects.pin.sendKeys("123456");
		AddCustomerPageObjects.mobile.sendKeys("458471");
		String email = randomString()+"@gmail.com";
		AddCustomerPageObjects.mail.sendKeys(email);
		AddCustomerPageObjects.pwd1.sendKeys("sdfsafdfs");
		AddCustomerPageObjects.sub.click();

		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true)
		{
			Assert.assertTrue(true);
		}else{

			Assert.assertTrue(false);
		}




	}


}
