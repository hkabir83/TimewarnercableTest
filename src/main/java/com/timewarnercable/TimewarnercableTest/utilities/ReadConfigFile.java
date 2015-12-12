package com.timewarnercable.TimewarnercableTest.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
	
	protected InputStream input = null;
	protected Properties property = null;
	
	public ReadConfigFile(){
		
		input = ReadConfigFile.class.getClassLoader().getResourceAsStream("com/timewarnercable/TimewarnercableTest/resources/config.properties");
		property = new Properties();
		try {
			property.load(input);
		} catch (IOException e) {
			System.out.println(input);
			e.printStackTrace();
		}
	}
	
	public String getBrowser(){
		
		if(property.getProperty("browser") == null)
			return "Browser is null";
		return property.getProperty("browser");
		
	}

}
