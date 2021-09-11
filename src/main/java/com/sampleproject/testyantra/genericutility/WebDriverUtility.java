package com.sampleproject.testyantra.genericutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains WebDriver specific generic libraries.
 * @author Chetan
 *
 */
public class WebDriverUtility {

	public void maximizeWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
	}
	
	/**
	 * This method waits for the element to be visible.
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	
	/**
	 * This method waits for 20 seconds to page loading.
	 * @param driver
	 */
	public void waitForElementVisibility(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method waits for the element to be clicked. It is a custom wait created to handle ElementClickInterceptedException.
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		
		int count = 0;
		while(count<20) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * This method enables user to handle dropdown using visible text.
	 * @param element
	 * @param option
	 */
	public void select(WebElement element, String option) {
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}
	
	/**
	 * This method enables user to handle dropdown using index.
	 * @param element
	 * @param option
	 */
	public void select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * This method performs mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	
}
