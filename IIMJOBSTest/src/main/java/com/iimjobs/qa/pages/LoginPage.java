package com.iimjobs.qa.pages;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iimjobs.qa.base.Testbase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class LoginPage extends Testbase{
	
	//Page Factory Object repositery

	@FindBy(id="large-email")
	WebElement EmailID;
	
	@FindBy(id="large-password")
	WebElement Password;
	@FindBy(id="open-modal")
	WebElement LOGINBTN;
	@FindBy(xpath="//div[@class='main-container-text']/h2[contains(text(),'Choose a job you love, and you will  never have to work a day in your life.')]")
	WebElement LoginHeaderText;
	
	@FindBy(partialLinkText="https://static.iimjobs.com/static/images/background-image.png")
	WebElement Loginbackgroundimage;
	
	
    //Intiallizing the page objects
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	
	public String validateloginpage() {
		
		return driver.getTitle();
	}
	
	public boolean validateloginheadertext() {
		
		return LoginHeaderText.isDisplayed();
		
	}
public Screenshot validatebackgroundimage() throws IOException, InterruptedException {
		
	Screenshot screenshot = new AShot().takeScreenshot(driver);
    ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") +"\\screenshots\\Backgroundimage.png"));

    Thread.sleep(2000);
	return screenshot;
		
	}
	
	public JobFeed login(String em,String pwd) throws IOException {
		
		EmailID.sendKeys(em);
		Password.sendKeys(pwd);
		LOGINBTN.click();
		
		return new JobFeed();
		
		
	}
	

}
