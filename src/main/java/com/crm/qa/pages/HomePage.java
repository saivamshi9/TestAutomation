package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class HomePage extends TestBase {
	
	

	@FindBy(xpath="//td[contains(text(),'User: sai vamshi')]")
	WebElement userloggedin;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	
	public HomePage() { //class constructor to initalise page objects
		
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean VerifyCurrentUser() {
		
		return userloggedin.isDisplayed();
		
	}
	
    public String validateHomepagetitle() { // it returns a String i.e why used public String
		
		return driver.getTitle();
	}
	
	 
	 public ContactsPage clickonContacts() { // it returns a ContactsPage as landing page onclick i.e why used public ContactsPage
		 
		
		 contactslink.click();
		 
		 return new ContactsPage();
	 }
	
	 
 public DealsPage clickonDeals() { // it returns a DealsPage as landing page onclick i.e why used public DealsPage
		 
	 
	 	dealslink.click();
		 
		 return new DealsPage();
	 }
	
 public TasksPage clickonTasks() { // it returns a TasksPage as landing page onclick i.e why used public TasksPage
	 
	
	 	taskslink.click();
		 
		 return new TasksPage();
	 }
 public void clickonNewContact() {
	 
	 Actions action = new Actions(driver);
	 action.moveToElement(contactslink).build().perform();
	 newcontactslink.click();
	 
 }
 
}
