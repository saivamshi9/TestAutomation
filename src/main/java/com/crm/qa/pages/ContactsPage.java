package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(name="first_name")
	WebElement firstname;  
	
	@FindBy(name="surname")
	WebElement lastname; 
	
	@FindBy(name="client_lookup")
	WebElement companyname;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement savecontact;
	
//	@FindBy(xpath="//a[contains(text(),'Vamshi2 Test2')]/parent::td//preceding-sibling::td//input[@name='contact_id']")
//	WebElement checkbox;
	
//Above method is commented as we may have 1000's of contacts then we should'nt use pagefactory ,we will create a method for it inside class.

	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateContactsLabel() {
		return contactslabel.isDisplayed();
	}
	
	public void selectcontacts(String name) {
		
		driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		
	}
	
	public void createnewcontact(String title , String FName , String LName , String CName) {
		
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstname.sendKeys(FName);
		lastname.sendKeys(LName);
		companyname.sendKeys(CName);
		savecontact.click();
		
	}

	}
