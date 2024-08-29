package com.myntrajio.generic.javalibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class JavaLibrary {
	
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return sdf.format(date);
	}
	/**
	 * This method generates random number within Specified limit
	 * 
	 * @param limit
	 * @return
	 */
	public int generateRandomNum(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}
}
