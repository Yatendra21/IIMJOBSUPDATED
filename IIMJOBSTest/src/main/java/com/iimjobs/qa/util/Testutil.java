package com.iimjobs.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.iimjobs.qa.base.Testbase;
import com.iimjobs.qa.util.Xls_Reader;

public class Testutil extends Testbase {
	static Xls_Reader reader;
	public static long PAGE_LOADTIME = 80;
	public static long IMLISIT_WAIT = 60;
	
	public Testutil() throws IOException {
		super();
		
	}

public static ArrayList<Object[]>  getDataFromExcel(){
	
	ArrayList<Object[]> mydata=new ArrayList<Object[]>();
	try {
		reader=new Xls_Reader("C:\\Users\\Yatendra\\Documents\\Selenium\\workspacesel\\Freecrmtest\\src\\main\\java\\com\\instappy\\qa\\testdata\\Instappy_Testdata.xlsx");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	for(int rowNum=2;rowNum<=reader.getRowCount("Appname");rowNum++) {
		
		
		String ApplicationName=reader.getCellData("Appname", "ApplicationName", rowNum);
        Object ob[]= {ApplicationName};//we have added no of coulmn fields in Object array
        mydata.add(ob);//
		
	}
	return mydata;
} 

public static void takeScreenshotAtEndOfTest() throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	
	}



}
