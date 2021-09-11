package com.sampleproject.testyantra.genericutility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementingClass implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println(testName+" ======Execute and I'm listening=====");
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sDriver);
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(srcFile, new File("../vtiger/screenshot/"+testName+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
