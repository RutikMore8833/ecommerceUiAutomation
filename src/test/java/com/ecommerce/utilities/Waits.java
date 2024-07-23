package com.ecommerce.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	WebDriver driver;

	public static void implicitWait(WebDriver driver)
	{
	   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
   public static void explicitWait(String s,WebDriver driver)
   {
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s)));
   }
}
