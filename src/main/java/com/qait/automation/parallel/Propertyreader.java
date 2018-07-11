package com.qait.automation.parallel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Propertyreader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties p=new Properties();
	 FileReader fr=new FileReader("/home/vijayprakash/eclipse-workspace/parallel/src/main/java/dataproperty/db.properties");
	 p.load(fr);
	 String user=p.getProperty("invaliduser");
	 System.out.println(user);
	 System.out.println(p.getProperty("username")+p.getProperty("password")+p.getProperty("invalidpassword"));
	 

	}

}
