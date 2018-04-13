package Academy.End2EndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateTitle extends base{
	
public static Logger log=LogManager.getLogger(base.class.getName());

@BeforeTest
public void initialize() throws IOException
{
	driver=initializeDriver();
	log.info("Driver is initialized");
	driver.get(prop.getProperty("url"));
	log.info("Navigated to Home Page");
}

@Test
public void basePageNavigation() throws IOException, InterruptedException
{
	

		LandingPage l=new LandingPage(driver);
		//compare the text from browser with the actual text
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated Text Message");
		//Assert.assertTrue(arg0);
	
	//Now Run as Testng but after some testcases we will run everything from maven and integrate with jenkins
}

@AfterTest
public void teardown()
{
	 driver.close();
	 driver=null;
}

}
