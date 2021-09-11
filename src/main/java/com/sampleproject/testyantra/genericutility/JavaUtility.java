package com.sampleproject.testyantra.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains Java specific generic libraries
 * @author Chetan
 *
 */
public class JavaUtility {
	
	/**
	 * This method is used to generate the random integer number within the boundary of 0 to 10000
	 * @return intData
	 */
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		return randomNumber;
	}

	/**
	 * This method is used to get the current System date and time
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		String systemDateandTime = date.toString();
		return systemDateandTime;
		
	}
	
	/**
	 * This method is used to get the current System date with YYYY-MM-DD format
	 * @return
	 */
	public String getSystemDateAndTime_YYYY_MM_DD_Format() {
		Date date = new Date();
		String systemDateandTime = date.toString();
		System.out.println(systemDateandTime);
		String[] arr = systemDateandTime.split(" ");
		String DD = arr[2];
		String YYYY = arr[5];
		int MM = date.getMonth()+1;
		
		String dateWithFormat = YYYY+"-"+MM+"-"+DD;
		return dateWithFormat;
	}
}
