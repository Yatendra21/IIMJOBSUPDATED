package com.iimjobs.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iimjobs.qa.base.Testbase;
import com.iimjobs.qa.pages.Createyourjobfeed;
import com.iimjobs.qa.pages.JobFeed;
import com.iimjobs.qa.pages.LoginPage;

public class JobFeedTest extends Testbase{
	LoginPage loginpage;
	JobFeed jobfeed;
	Createyourjobfeed createyourjobfeed;
	

	public JobFeedTest() throws IOException {
		super();
		
	}
	@BeforeMethod

	public void setuphomepage() throws IOException {
		initilization();
		loginpage = new LoginPage();
		jobfeed=new JobFeed();
		loginpage.login(prop.getProperty("EmailID"), prop.getProperty("Password"));
}
	
	@Test(priority=1)
	public void verifyjobfeedpage() {
		String title=jobfeed.validatejobfeedpage();
		Assert.assertEquals(title, "My Jobfeed");
	
	}
	
	@Test(priority=2)
	public void verifyjobfeedpagetext() {
		boolean flag=jobfeed.validatejobfeedpagetext();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void createyourjobfeed() throws IOException {
		createyourjobfeed=jobfeed.createownjobfeed();
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
