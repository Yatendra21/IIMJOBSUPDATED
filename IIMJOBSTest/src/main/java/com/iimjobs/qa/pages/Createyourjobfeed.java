package com.iimjobs.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.iimjobs.qa.base.Testbase;



public class Createyourjobfeed extends Testbase{
	
	
	

	
	 //OR-object Repostory
	
		@FindBy(xpath="//div[@class='col-md-9 pdlr0']/h1[contains(text(),'Get started! Create your own Job-feed')]")
		WebElement ValidateCreateyourownJobfeedpage	;
	
		
		@FindBy(xpath="//a[text()='IT & Systems Jobs  ']")
		WebElement clickonITsystemsJobs ;
		
		@FindBy(xpath="//descendant::a[@class='current' and text()='IT Product Management'][1]")
		WebElement ClickandchooseITProductMgmt ;
		
		@FindBy(xpath="//a[text()='DONE']")
		WebElement ClickonDone ;
		
		@FindBy(xpath="//div[@class='pull-left']/input[contains(@type,'submit')]")
		WebElement ClickonFilter ;
		
		@FindBy(xpath="//span[@class='exp-title']/b[contains(text(),'(1-3 yrs)')]")
		WebElement delhincr1to3 ;
		
		
		//intialize the construtor of jobfeedpage
			public Createyourjobfeed() throws IOException {
				
				 PageFactory.initElements(driver, this);
			}
			
              public boolean validatecreateyourownfeed() {
				
				return ValidateCreateyourownJobfeedpage.isDisplayed();
				
			}
              
              public void  ClikonITsystemjobs() {
       		   
            	  clickonITsystemsJobs.click();
       		     
       			   
       		   }
              
              /*public void  ChooseandclickITmgmt() throws InterruptedException {
            	  Thread.sleep(10000);
            	  ClickandchooseITProductMgmt.click();
       		     
       			   
       		   }*/
              public void  ClickonDone() throws InterruptedException {
            	  Thread.sleep(5000);
            	  ClickonDone.click();
       		     
       			   
       		   }
              
              

			public boolean validatejobfeedfilter() throws InterruptedException {
				Thread.sleep(5000);
				return delhincr1to3.isDisplayed();
				
			}
			
			public void Experiencelevel() throws InterruptedException
			{ 
				
				WebElement element = driver.findElement(By.xpath("//span[text() = 'Any Exp. Level']"));
				//JavascriptExecutor executor = (JavascriptExecutor)driver;
				element.click();
				
				Thread.sleep(5000);
				System.out.println("Part Two");
				WebElement element1 = driver.findElement(By.xpath("//a[text() = '1-3 yrs']"));
				element1.click();
			}
			
			public void Anylocation() throws InterruptedException
			{    Thread.sleep(5000);
			WebElement element3 = driver.findElement(By.xpath("//span[contains(text(), 'Any Location')]"));
			
			element3.click();
			Thread.sleep(3000);
			System.out.println("Part Four");
			driver.findElement(By.id("myLocInput")).sendKeys("Delhi");
			Thread.sleep(3000);
			WebElement element4 = driver.findElement(By.xpath("//label[contains(text(), 'Delhi NCR')]"));
			element4.click();
			}
			
			public String validatejobfeedpage() {
				
				return driver.getTitle();
			}
	 
	   
	   public void  Filteredjobfeed() throws InterruptedException {
		   Thread.sleep(3000);
		   
		   ClickonFilter.click();
		     
			   
		   }

}
