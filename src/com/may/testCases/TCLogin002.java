package com.may.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.may.commonFunctions.BaseClass;
import com.may.pageObjects.AddCustomerPageObjects;

public class TCLogin002 extends BaseClass {

	static Logger logger=Logger.getLogger(TCLogin002.class);

	@Test
	public void custDetails(){
		
		logger.info("Entered all the given details in customer section");

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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}else{

			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}




	}


}
