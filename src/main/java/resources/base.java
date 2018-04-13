package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;



public class base {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
	    prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\priyanka.limaye\\eclipse-workspace\\End2EndProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if (browserName.equals("chrome"))
				{System.setProperty("webdriver.chrome.driver", "F:\\Chromedriver\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				//execute in chromedriver
				}
				
		else if(browserName.equals("IE"))
		{
		//execute in Internet explorer
		}
		else if(browserName.equals("firefox"))
		{//execute in firefox
	}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	
	}
	
	public void getscreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile (src, new File ("C://test//Screenshot.png"));
		Files.copy(src,new File("C://test//"+result+"Screenshot.png")); 
		
	
	}
}
