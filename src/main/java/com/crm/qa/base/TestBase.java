package com.crm.qa.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	static public WebDriver driver;
	static public Properties prop;
	
	
	
	public TestBase() { //initialsing a constructor for main class
		
	try {
		
		 prop = new Properties();
		
		FileInputStream ip = new FileInputStream("C:\\Automation\\POM E2E\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		
		prop.load(ip);
	}
	catch(FileNotFoundException e) {
		
		e.printStackTrace();
	}
	catch(IOException e) {
		
		e.printStackTrace();
	}
	}


public static void initialisation() { //create an initialization method
	
	String browsername = prop.getProperty("browser");
	if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","G:/chromedriver_96/chromedriver.exe");
		 driver = new ChromeDriver();
	}
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS); //wait for page
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	//log.info("app url is " + prop.getProperty("url") );
	//for some edit
	

}

}