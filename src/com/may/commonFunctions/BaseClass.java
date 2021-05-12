package com.may.commonFunctions;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
	Logger logger = Logger.getLogger(BaseClass.class);
	
	
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
		
		loadPropertyFile();
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String chromepath = properties.getProperty("chromepath");
		String firefoxpath = properties.getProperty("firefoxpath");
		String iepath = properties.getProperty("iepath");
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",chromepath);
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",firefoxpath);
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("iepath"))
		{
			System.setProperty("webdriver.ie.driver",iepath);
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}

}
