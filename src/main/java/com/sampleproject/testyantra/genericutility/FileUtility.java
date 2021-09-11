package com.sampleproject.testyantra.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Chetan
 *
 */
public class FileUtility {
	
	/**
	 * This method is used to read the common data from .properties files based on Key passed as an argument.
	 * @param key
	 * @throws Throwable 
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigerCommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}
