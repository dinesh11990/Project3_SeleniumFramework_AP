package com.may.commonFunctions;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;



public class BaseClass {
	
	public static Properties properties=null;
	public static WebDriver driver=null;
	static Logger logger = Logger.getLogger(BaseClass.class);
	
	
	public Properties loadPropertyFile() {
	
		try{
			FileInputStream fis=new FileInputStream("./Configurations/config.properties");
			properties =new Properties();
			properties.load(fis);
			
		}catch(Exception e){
			
			System.out.println("Exception is: "+e.getMessage());
		}
		return properties;
		
	}
	
	@BeforeSuite
	public void launchBrowser(){
		
		PropertyConfigurator.configure("log4j.properties");
		
		logger.info("Web Application Begins");
		logger.info("Loading the property file");
		
		loadPropertyFile();
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String chromepath = properties.getProperty("chromepath");
		String firefoxpath = properties.getProperty("firefoxpath");
		String iepath = properties.getProperty("iepath");
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",chromepath);
			logger.info("Launching Chrome");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",firefoxpath);
			logger.info("Launching Firefox");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("iepath"))
		{
			System.setProperty("webdriver.ie.driver",iepath);
			logger.info("Launching Internet Explorer");
		}
		driver.manage().window().maximize();
		logger.info("Navigating to Application");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	    //Need to add the library commons.lang3
		//random string
			public String randomString()
			{
				String generatedString = RandomStringUtils.randomAlphabetic(8);
				return generatedString;
			}
		//random numbers
			public String randNumber()
			{
				String generatedNumber = RandomStringUtils.randomNumeric(5);
				return generatedNumber;
			}
	
	@AfterSuite
	public void tearDown()
	{
		logger.info("Execution done");
		driver.quit();
	}

}
