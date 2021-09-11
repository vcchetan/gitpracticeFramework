package com.sampleproject.testyantra.pomrepositorylib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductsPage {
	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createProductLink;
	
	@FindBy(name="search_text")
	private WebElement searchTextField;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchCategory;
	
	@FindBy(name="submit")
	private WebElement searchNowButton;
	
	@FindBy(xpath="//div//tr[@class='lvtColData']")
	private WebElement searchedProductRow;
	
	//table[@class='lvt small']/tbody/tr[last()]/td[contains(text(),'PRO')]
	//div//tr[@class='lvtColData'])[last()]//td//span[@vtfieldname='product_no']/..
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[last()]/td[contains(text(),'PRO')]")
	private WebElement searchedProdNumberCellValue;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[last()]/td//span[contains(text(),'.')]")
	private WebElement searchedCommCellValue;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[last()]/td[contains(text(),'Part')]")
	private WebElement searchedPartNumberCellValue;

	@FindBy(xpath="//img[@src='themes/softed/images/status.gif']")
	private WebElement statusBar;
	
	
	
	public WebElement getStatusBar() {
		return statusBar;
	}

	public WebElement getSearchedProdNumberCellValue() {
		return searchedProdNumberCellValue;
	}

	public WebElement getSearchedCommCellValue() {
		return searchedCommCellValue;
	}

	public WebElement getSearchedPartNumberCellValue() {
		return searchedPartNumberCellValue;
	}

	public WebElement getSearchedProductRow() {
		return searchedProductRow;
	}

	public WebElement getCreateProductLink() {
		return createProductLink;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchCategory() {
		return searchCategory;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}
	
	public void searchProduct(String prodNumber) {
		prodNumber=prodNumber.substring(1);
		
		searchTextField.sendKeys(prodNumber);
		Select s = new Select(searchCategory);
		s.selectByVisibleText("Product No");
		searchNowButton.click();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(statusBar));
		String actualProdNo = searchedProdNumberCellValue.getText();
		System.out.println(actualProdNo);
		
		boolean verify = actualProdNo.contains(prodNumber);
//		if(actualProdNo.contains(prodNumber)) {
//			System.out.println("PASS----Search product by product number is successful and matching record displayed successfully");
//		} else {
//			System.out.println("FAIL----Search product by product number is not successful");
//		}
		
		Assert.assertTrue(verify);
			
	}
	
	public void searchProduct(String partNumber, String prodNumber, boolean b) {
		prodNumber=prodNumber.substring(1);
		
		searchTextField.sendKeys(partNumber);
		Select s = new Select(searchCategory);
		s.selectByVisibleText("Part Number");
		String expectedProdNo = prodNumber;
		String expectedPartNo = partNumber;
		String actualProdNo = searchedProdNumberCellValue.getText();
		String actualPartNo = searchedPartNumberCellValue.getText();
		searchNowButton.click();
		
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOf(statusBar));
		System.out.println(actualPartNo);
		System.out.println(expectedPartNo);
		boolean verifyProdNum = actualProdNo.contains(expectedProdNo);
		boolean verifyPartNum = actualPartNo.contains(expectedPartNo);
//		if(actualProdNo.contains(expectedProdNo) && actualPartNo.contains(expectedPartNo)) {
//			System.out.println("PASS----Search product by part number is successful and matching record displayed successfully");
//		} else {
//			System.out.println("FAIL----Search product by part number is not successful");
//		}
		Assert.assertEquals(verifyProdNum, verifyPartNum);
	}
	
	public void searchProduct(String commRate, String prodNumber, boolean b2, boolean b3) {
		prodNumber=prodNumber.substring(1);
		
		searchTextField.sendKeys(commRate);
		Select s = new Select(searchCategory);
		s.selectByVisibleText("Commission Rate");
		String expectedProdNo = prodNumber;
		String expectedCommRate = commRate;
		String actualProdNo = searchedProdNumberCellValue.getText();
		String actualCommRate = searchedCommCellValue.getText();
		searchNowButton.click();

		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOf(statusBar));
		System.out.println(actualCommRate);
		System.out.println(expectedCommRate);
		boolean verifyProdNum = actualProdNo.contains(expectedProdNo);
		boolean verifyCommRate = actualCommRate.contains(expectedCommRate);
//		if(actualProdNo.contains(expectedProdNo) && actualCommRate.contains(expectedCommRate)) {
//			System.out.println("PASS----Search product by commission rate is successful and matching record displayed successfully");
//		} else {
//			System.out.println("FAIL----Search product by commission rate is not successful");
//		}
		Assert.assertEquals(verifyProdNum, verifyCommRate);
	}
	
}
