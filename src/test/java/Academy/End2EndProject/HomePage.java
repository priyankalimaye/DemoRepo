package Academy.End2EndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
public static Logger log=LogManager.getLogger(base.class.getName());

@BeforeTest
public void initialize() throws IOException
{
	driver=initializeDriver();
	
}

@Test(dataProvider="getData")
public void basePageNavigation(String Username,String Password,String text) throws IOException, InterruptedException
{
	
	
	driver.get(prop.getProperty("url"));
	
	/*try 
	{ 
	    driver.switchTo().alert(); 
	    System.out.println(" Alert Present");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[contains(text(),'NO THANKS')]")).click();
	}  
	catch (NoAlertPresentException e) 
	{ 
	    System.out.println("No Alert Present");
	} */
	
		
		LandingPage l=new LandingPage(driver);
		
		
		Thread.sleep(3000);
		l.getLogin().click();
		
		LoginPage lp=new LoginPage(driver); 
		lp.getEmail().sendKeys(Username);//this username and password does not exists and will get error to login
		lp.getPassword().sendKeys(Password);
		//System.out.println(text);
		log.info(text);
		
		lp.getLogin().click();
		
	
	
	//Now Run as Testng but after some testcases we will run everything from maven and integrate with jenkins
}

@AfterTest
public void teardown()
{
	 driver.close();
	 driver=null;
}

@ DataProvider
public Object[][] getData()
{
	//Row stands for how many different data types test should run
	//column stands for how many values per each test
	//
	Object[][] data=new Object[2][3];
	//0th row 
	data[0][0]="non restricted user";
	data[0][1]="1223";
	data[0][2]="Restricted User";
	
	//1st row
	data[1][0]="Restricted user";
	data[1][1]="45678";
	data[1][2]="Non restricted user";
	
	return data;
	
}

 

}
