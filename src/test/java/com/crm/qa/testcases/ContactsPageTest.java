package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage; //create a global variable for LoginPage to use functions of that class
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;

	public ContactsPageTest() { //constructor for our testclass
		
			super(); // this is used to call constructor of our TestBase class which holds Config properties
		
	}
	
	@BeforeMethod
	public void setup() {

	initialisation(); //calling method of our TestBaseClass to launchchrome .. etc
	testutil = new TestUtil();
	contactspage = new ContactsPage();
	loginpage = new LoginPage();//creating a object for LoginPage to use login method in nextline.
	//homepage = new HomePage();
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	testutil.switchtoFrame();
	contactspage = homepage.clickonContacts();
	
}
	
	@Test(priority=1)
	public void ContactsLabelTest() {
		
		Assert.assertTrue(contactspage.validateContactsLabel());
	}
	
	@Test(priority=2)
	public void selectcontactTest() {
		
		contactspage.selectcontacts("Vamshi2 Test2");
	}
	
	@Test(priority=3)
	public void selectmultiplecontactsTest() {
		
		contactspage.selectcontacts("Vamshi2 Test2");
		contactspage.selectcontacts("vamshi1 test1");

	}
	
	
	@Test(priority=4)
	public void createnewcontactTest() throws InterruptedException {
		
		homepage.clickonNewContact();
		Thread.sleep(3000);
		contactspage.createnewcontact("Mr.", "Surya", "B", "IMP");
	}
	
	@AfterMethod
	public void closebrowser() {
		
		driver.quit();
		
	}
	
	
}
