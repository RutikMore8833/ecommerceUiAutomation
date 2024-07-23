package com.ecommerce.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void takeScreenshot(WebDriver driver) throws IOException
	{
		Date currentdate=new Date();
		String Screenshot=currentdate.toString().replace(" ","-").replace(":","-");
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\sande\\eclipse-workspace\\AutomationlPR\\ScreenShots\\"+Screenshot+".jpg");
		FileHandler.copy(source, dest);
	}
}
