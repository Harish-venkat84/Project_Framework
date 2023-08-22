package com.w3schools.property;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FileReaderManager {

	static Properties property;
	
	// this method is used for load the property file on Properties class
	public FileReaderManager() {
		try {

			String path = System.getProperty("user.dir") + "\\source\\w3school.Properties";

			FileInputStream input = new FileInputStream(new File(path));

			property = new Properties();

			property.load(input);

		} catch (Exception ex) {
			
			System.out.println("problem on loading the property file");
			
			ex.printStackTrace();
		}
	}
	
	// return mailID value from property file as a String
	public String getMailID() {
		
		try { return property.getProperty("mailID"); }catch(Exception ex) {
			
			System.out.println("problem on getting mail id form the property file");
			
			ex.printStackTrace();
		}
		
		return "";
	}

	// return pass value from property file as a String
	public String getPass() {
		
		try { return property.getProperty("pass"); }catch (Exception ex) {
			
			System.out.println("problem on getting password from the property file");
			
			ex.printStackTrace();
		}
		
		return "";
	}
}
