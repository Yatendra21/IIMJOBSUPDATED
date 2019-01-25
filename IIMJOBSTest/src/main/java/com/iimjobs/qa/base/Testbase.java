package com.iimjobs.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.iimjobs.qa.util.Testutil;
import com.iimjobs.qa.util.WebEventListener;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public Testbase() throws IOException {
		
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Yatendra\\Documents\\Selenium\\workspacesel\\IIMJOBSTest\\src\\main\\java\\com\\iimjobs\\qa\\config\\config.properties");
			prop.load(ip);
	}
	
	public void initilization() throws IOException {
		String browsername =prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Yatendra\\Documents\\Selenium\\Chrome driver 07 june\\chromedriver.exe");
			driver = new ChromeDriver();
			//driver=new HtmlUnitDriver();
			
		}
		else if(browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Yatendra\\Documents\\Selenium\\Firfox latest Driver\\geckodriver.exe");
			driver = new ChromeDriver();
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		
		eventListener = new WebEventListener();
		e_driver.register(eventListener); // for event log on console
		driver = e_driver;
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOADTIME, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Testutil.IMLISIT_WAIT,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		
		
		
	}
	}
	



