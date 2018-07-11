package com.qait.automation.parallel;

//import org.testng.AssertJUnit.assertNotEquals;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class NewTest {
	WebDriver driver1;
	WebDriver driver2;
	App app1,app2;
	
  @BeforeClass
  public void before() 
    {
	  
	  driver1=new ChromeDriver();
	  driver1.get("https://hris.qainfotech.com/login.php");
	  app1=new App(driver1);
      
//	  driver2=new ChromeDriver();
//	  driver2.get("https://hris.qainfotech.com/login.php");
//	  app2=new App(driver2);

    }
	
	
  @Test
  public void testvalidlogin() throws IOException {
	  String str=app1.validlogin();
	  System.out.println("Test Case one with Thread Id:- "
				+ Thread.currentThread().getId());
	  Assert.assertEquals(str,"https://hris.qainfotech.com:8086/time/timesheet");
	  app1.logout();
  }
  
  @Test
  public void testinvlaidlogin() throws IOException
  {
  String str=app2.invalidlogin();
  System.out.println("Test Case two with Thread Id:- "
			+ Thread.currentThread().getId());
  Assert.assertNotEquals(str,"https://hris.qainfotech.com:8086/time/timesheet");
}
}
