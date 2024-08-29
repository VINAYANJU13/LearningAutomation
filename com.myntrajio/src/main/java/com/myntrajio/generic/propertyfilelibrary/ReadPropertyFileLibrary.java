package com.myntrajio.generic.propertyfilelibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.Reporter;
import com.myntrajio.generic.commonlibrary.FrameworkConstant;

public class ReadPropertyFileLibrary implements FrameworkConstant {
	FileInputStream fis=null;
	FileOutputStream fos=null;
	Properties property=null;

	public String readData(String key) {
		// Converting physical File into Java Understandable using FileInputStream
		try {
			fis = new FileInputStream(propertypath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// create an object for properties class
		property =new Properties();

		// load the property file
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Fetch the data-By calling getProperty()
		String data = property.getProperty(key);

		return data;
	}

	public void writeData(String key,String value) {
		//Enter the data
		property.put(key, value);
		//Create an instance for file out stream class

		try {
			fos = new FileOutputStream(propertypath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Store the data
		try {
			property.store(fos, "Updated the new key-value Sucesfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void displayData(String key) {
		// Create an object of FileInputStream
		// Converting physical File into Java Understandable
		try {
			fis = new FileInputStream(propertypath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// create an object for properties class
		new Properties();

		// load the property file
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Fetch the data-By calling getProperty()
		String data = property.getProperty("username");
		//Display the data
		Reporter.log(key+":"+data,true);

	}

}
