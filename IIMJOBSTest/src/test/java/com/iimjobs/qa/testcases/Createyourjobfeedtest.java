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

public class Createyourjobfeedtest extends Testbase {
	
	
	LoginPage loginpage;
	JobFeed jobfeed;
	Createyourjobfeed createyourjobfeed;

	public Createyourjobfeedtest() throws IOException {
		super();
		
	}
	
	@BeforeMethod

	public void setuphomepage() throws IOException {
		initilization();
		loginpage = new LoginPage();
		jobfeed=new JobFeed();
		createyourjobfeed=new Createyourjobfeed();
		loginpage.login(prop.getProperty("EmailID"), prop.getProperty("Password"));
}
	
	@Test(priority=1)
	public void VerifyCreateyourownjobfeedpage() throws IOException {
		jobfeed.createownjobfeed();
		boolean flag=createyourjobfeed.validatecreateyourownfeed();
		Assert.assertTrue(flag);
	
	}
	
	@Test(priority=2)
	public void verifyclikonITandsystemjobsandITmgmt() throws IOException, InterruptedException {
		jobfeed.createownjobfeed();
		createyourjobfeed.ClikonITsystemjobs();
		//createyourjobfeed.ChooseandclickITmgmt();
		createyourjobfeed.ClickonDone();
	}
	@Test(priority=3)
	public void Verifyjobfeedfilter() throws InterruptedException{
		createyourjobfeed.Experiencelevel();
		createyourjobfeed.Anylocation();
		createyourjobfeed.Filteredjobfeed();
		boolean flag=	createyourjobfeed.validatejobfeedfilter();
		Assert.assertTrue(flag);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
