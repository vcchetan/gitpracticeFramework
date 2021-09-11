package com.sampleproject.testyantra.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sampleproject.testyantra.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Products")
	private WebElement productsLink;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement logoutLink;
	
	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public void logout() {
		mouseHover(driver, administratorImg);
		logoutLink.click();
	}
	
	
}
