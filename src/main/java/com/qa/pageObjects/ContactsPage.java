package com.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.BaseClass;
import com.qa.utils.ElementUtil;


public class ContactsPage extends BaseClass {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//locators
	
	private By firstName=By.xpath("//input[@name='first_name']");
	private By lastName=By.xpath("//input[@name='last_name']");
	private By email=By.xpath("//input[@name='email']");
	private By submitButton=By.xpath("//input[@type='submit']");
	private By comments=By.xpath("//textarea[@name='message']");
	
	private By successMessage=By.xpath("//h1[text()='Thank You for your Message!']");
	private By errorMessage=By.xpath("//br");
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public void enterContactDetails(String fname,String lname,String Email,String comment) {
		eleUtil.doSendKeys(firstName, fname);
		eleUtil.doSendKeys(lastName, lname);
		eleUtil.doSendKeys(email, Email);
		eleUtil.doSendKeys(comments, comment);
	}
	
	public void clickSubmitButton() {
		eleUtil.doClick(submitButton);
	}
	
	public Boolean verifySuccessMessage() {
		//eleUtil.waitForElementsPresence(successMessage, 5);
		return eleUtil.doElementIsDisplayed(successMessage);
	}
	
	public String getErroMessage() {
		eleUtil.waitForElementsPresence(errorMessage, 5);
		return eleUtil.doElementGetText(errorMessage);
	}
	
	
	

}
