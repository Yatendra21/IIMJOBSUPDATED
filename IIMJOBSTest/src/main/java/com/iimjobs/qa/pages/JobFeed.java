package com.iimjobs.qa.pages;

import java.io.IOException;//PAGE LIBRARY 

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iimjobs.qa.base.Testbase;

public class JobFeed extends Testbase{
	
    //OR-object Repostory
	
	@FindBy(xpath="//div[@id='categorylist']/h1[contains(text(),'My Jobfeed')]")
	WebElement Validatejobfeedpage;
	
	@FindBy(xpath="//a[text()='here']")
	WebElement clickhereforcreatejobfeed;
	
	
	//intialize the construtor of jobfeedpage
		public JobFeed() throws IOException {
			
			 PageFactory.initElements(driver, this);
		}
		
		public String validatejobfeedpage() {
			
			return driver.getTitle();
		}
   
   public boolean validatejobfeedpagetext() {
	   
	return Validatejobfeedpage.isDisplayed();
	   
   }
   
   public  Createyourjobfeed createownjobfeed() throws IOException {
	   
	     clickhereforcreatejobfeed.click();
	     return new Createyourjobfeed();
		   
	   }
 
}
