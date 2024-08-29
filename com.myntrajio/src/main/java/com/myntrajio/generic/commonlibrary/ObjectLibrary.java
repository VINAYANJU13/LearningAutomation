package com.myntrajio.generic.commonlibrary;

import com.myntrajio.generic.excellibrary.ReadExcelFile;
import com.myntrajio.generic.javalibrary.JavaLibrary;
import com.myntrajio.generic.propertyfilelibrary.ReadPropertyFileLibrary;
import com.myntrajio.generic.webdriverlibrary.WebDriverlibrary;

public class ObjectLibrary {
	public ReadExcelFile excellibrary;
	public ReadPropertyFileLibrary propertyfilelibrary;
	public JavaLibrary javaLibrary;
	public WebDriverlibrary webdriverlibrary;

	public void createObject() {
		excellibrary = new ReadExcelFile();
		javaLibrary = new JavaLibrary();
		propertyfilelibrary = new ReadPropertyFileLibrary();
		webdriverlibrary = new WebDriverlibrary();
	}
}
