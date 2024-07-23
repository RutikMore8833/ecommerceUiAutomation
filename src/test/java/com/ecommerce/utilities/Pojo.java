package com.ecommerce.utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Pojo{

	public static WebDriver chromedriver()
	{
		System.setProperty("webdriver.chrome.driver","E:\\RUTIK PROJECT\\PanIndia\\PanIndia\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		//opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(opt);
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.demoblaze.com/");
		
		return driver;
	}
}
