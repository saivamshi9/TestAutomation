package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory / Object Repository / Page Elements
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[@text='Sign Up']")
	WebElement signup;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmlogo;
	
	
	//Initialising page objects using constructor 
	public LoginPage() {
	
	PageFactory.initElements(driver, this);
	
	}
    
	//Actions
	public String validateloginpagetitle() { // wrote a method to return title of loginpage & it returns a String i.e why used public String
		
		return driver.getTitle();
	}
	
	public boolean validatecrmlogo() {	//wrote a boolean method because return method will throw true/false boolean values	
		
		return crmlogo.isDisplayed();
		
	}

	public HomePage login(String un, String pwd) { //create a method for login with return type as HomePage because on clicking login it will redirect to homepage.
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage();
	}
}
