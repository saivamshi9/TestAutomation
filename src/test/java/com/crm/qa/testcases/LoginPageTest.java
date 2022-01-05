package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{ //new jenkins job commit
	
	LoginPage loginpage; //create a global variable for LoginPage to use functions of that class
	HomePage homepage; // create a global variable for HomePage to use functions of that class
	
	
	
	public LoginPageTest() { //constructor for our testclass
		
		super(); // this is used to call constructor of our TestBase class which holds Config properties
		
	}

	@BeforeMethod
	public void setup() {
		
		initialisation(); //calling method of our TestBaseClass to launchchrome .. etc
		loginpage = new LoginPage(); //calling loginpage constructor
		}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title = loginpage.validateloginpagetitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmlogoimgtest() {
		
		boolean flag = loginpage.validatecrmlogo();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void logintest() {
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//because loginpage.login method is returning a homepage reference so we are storing in above way 
		
		
	}
	
	
	@AfterMethod
	public void closebrowser(){
		driver.quit();
	}
	
	
	}
	
	

