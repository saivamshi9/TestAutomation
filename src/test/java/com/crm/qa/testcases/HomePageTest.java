package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage; //create a global variable for LoginPage to use functions of that class
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;
	TestUtil testutil;
	
	
	
	
	public HomePageTest() { //constructor for our testclass
		
		super(); // this is used to call constructor of our TestBase class which holds Config properties
		
	}
	
	@BeforeMethod
	public void setup() {
	
		initialisation(); //calling method of our TestBaseClass to launchchrome .. etc
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		dealspage =  new DealsPage();
		loginpage = new LoginPage(); //creating a object for LoginPage to use login method in nextline.
		taskspage = new TasksPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void homepagetitletest() {
		
		String homepagetitle = homepage.validateHomepagetitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Home Page title is not matched"); //3rd parameter is in failure situation.
		
	}
	
	@Test(priority=2)
	public void loggedinusertest() {
		
		testutil.switchtoFrame();
		Assert.assertTrue(homepage.VerifyCurrentUser());
	}
	@Test(priority=3)
	public void ClickOnContactstest()
	{
		 testutil.switchtoFrame();
		 contactspage = homepage.clickonContacts();
		
	}
	
	@Test(priority=4)
	public void ClickonDealstest()
	{
		 testutil.switchtoFrame();
		 dealspage = homepage.clickonDeals();
		
	}
	
	@Test(priority=5)
	public void ClickonTaskstest() {
		
		 testutil.switchtoFrame();
		taskspage = homepage.clickonTasks();
	}
	
	@AfterMethod
	public void closebrowser() {
		
		driver.quit();
		
	}

}
