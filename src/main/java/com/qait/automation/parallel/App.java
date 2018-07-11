package com.qait.automation.parallel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class App 
{

    WebDriver driver;
    JavascriptExecutor executor;
    FileReader reader;
    Properties p;

    
  
    public App(WebDriver driver) {
    	
		// TODO Auto-generated constructor stub
    	this.driver=driver;
    	executor=(JavascriptExecutor)driver;
	}
    
    public void readfile() throws IOException
    {
    	 reader = null;
    	//File file=new File("/home/vijayprakash/eclipse-workspace/prop/src/main/java/propertyfile/db.properties");
    	try {
			reader=new FileReader("/home/vijayprakash/eclipse-workspace/prop/src/main/java/propertyfile/db.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	p=new Properties();
    	p.load(reader);
    	reader.close();
    }
   public Properties readinvalid() throws IOException
   {
	   FileReader reader2 = null ;
   	try {
			reader2=new FileReader("/home/vijayprakash/eclipse-workspace/parallel/src/main/java/invalid/invalid.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	Properties p=new Properties();
   	p.load(reader2);
   	return p;
	   
   }
    
    
	public WebElement getuserentry()
    {
    	WebElement username=driver.findElement(By.id("txtUserName"));
    	return username;
    }
    
    public WebElement getpasswordentry()
    {
    	WebElement password=driver.findElement(By.id("txtPassword"));
    	return password;
    }
    public String validlogin() throws IOException
    {
    	readfile();
    	getuserentry().clear();
    	getuserentry().sendKeys(p.getProperty("username"));
    	getpasswordentry().clear();
    	getpasswordentry().sendKeys(p.getProperty("password"));
    	getpasswordentry().submit();
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String url=driver.getCurrentUrl();
    	return url;
    	
    	
    }
    public String invalidlogin() throws IOException
    {
    	
    	Properties p=readinvalid();
    	getuserentry().clear();
    	String user=p.getProperty("username");
    	System.out.println(user);
    	getuserentry().sendKeys(user);
    	getpasswordentry().clear();
    	getpasswordentry().sendKeys(p.getProperty("password"));
    	getpasswordentry().submit();
    	String url=driver.getCurrentUrl();
    	return url;
    	
    }
    
    
    public void logout()
    {
    	driver.findElement(By.className("profile-btn")).click();
    	//driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/ul/li/ul/li[4]/a/span")).click();
    	/*driver.findElement(By.xpath("//*[text()[contains(.,'Logout')]]")).click();
        System.out.println(driver.getTitle());*/
    	//select.selectByVisibleText("Logout");
        
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//driver.findElement(By.className("user-profile-option")).findElement(By.cssSelector("ul > li:nth-child(4)")).click();	
    	WebElement element=driver.findElement(By.className("user-profile-option")).findElement(By.cssSelector("ul > li:nth-child(4) > a:nth-child(1) "));
    	executor.executeScript("arguments[0].click();",element);
    	
}
   
}
