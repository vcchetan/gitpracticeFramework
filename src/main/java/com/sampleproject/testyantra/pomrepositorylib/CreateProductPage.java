package com.sampleproject.testyantra.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	WebDriver driver;
	public CreateProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement prodNameTextfield;
	
	@FindBy(id="productcode")
	private WebElement partNumberTextField;
	
	@FindBy(id="commissionrate")
	private WebElement commissionRateField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getProdNameTextfield() {
		return prodNameTextfield;
	}

	public WebElement getPartNameTextField() {
		return partNumberTextField;
	}
	
	public WebElement getCommissionRateField() {
		return commissionRateField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createNewProduct(String prodName) {
		prodNameTextfield.sendKeys(prodName);
		saveBtn.click();
	}
	
	public void createNewProduct(String prodName, String partNumber) {
		prodNameTextfield.sendKeys(prodName);
		partNumberTextField.sendKeys(partNumber);
		saveBtn.click();
	}
	
	public void createNewProduct(String prodName, String commRate, boolean b) {
		prodNameTextfield.sendKeys(prodName);
		commissionRateField.sendKeys(commRate);
		saveBtn.click();
	}
	
	
	
}
