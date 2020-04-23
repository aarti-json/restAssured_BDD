package tests;

import org.apache.commons.lang3.RandomStringUtils;

public  class RestUtils {
	
	public static String getEmailId1(){
		
		String genratedString =RandomStringUtils.randomAlphabetic(1);
		return ("aarti "+ genratedString );
		
		
	}
      public static String getPassword(){
		
		String genratedString =RandomStringUtils.randomAlphabetic(1);
		return ("test "+ genratedString );
		
		
	}
	

}
