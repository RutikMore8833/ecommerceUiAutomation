package com.ecommerce.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecommerce.pom.EcommercePages;
import com.ecommerce.utilities.Pojo;

import com.ecommerce.utilities.Screenshot;
import com.ecommerce.utilities.Waits;

public class VerifyEcommercePages {

	WebDriver driver;

	@BeforeClass
	public void beforeclass() {
		
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriver driver=chromedriver();
		this.driver=driver;
		
	}

	private WebDriver chromedriver() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"E:\\RUTIK PROJECT\\PanIndia\\PanIndia\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		// opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.demoblaze.com");
		return driver;
	}

	@Test(priority = 0)
	public void verifySignUp() throws InterruptedException, EncryptedDocumentException, IOException {

		try {
		EcommercePages Signup = new EcommercePages(driver);
		Thread.sleep(2000);

		Signup.signupPage();

		Signup.UsersignupPage();

		} catch (Exception e) {
			Screenshot.takeScreenshot(driver);// take screenshot
			driver.close();

		}
	}

	@Test(priority = 1)
	public void verifySignWithBlankSpace() throws InterruptedException, EncryptedDocumentException, IOException {

		try {
		EcommercePages Signup = new EcommercePages(driver);
		Thread.sleep(2000);

		Signup.signupPage();
		Assert.assertEquals(true, true);

		Signup.UsersignupPageBlankInput();

		} catch (Exception e) {
			Screenshot.takeScreenshot(driver);// take screenshot
			driver.close();
		}
	}

	@Test(priority = 2)
	public void verifyLogin() throws InterruptedException, EncryptedDocumentException, IOException {

		try {
		EcommercePages Signup = new EcommercePages(driver);
		Thread.sleep(2000);

		Signup.Login();

		} catch (Exception e) {
			Screenshot.takeScreenshot(driver);// take screenshot
			driver.close();
		}
	}

	@Test(priority = 3)
	public void verifyInvalidLogin() throws InterruptedException, EncryptedDocumentException, IOException {

		try {
		EcommercePages Signup = new EcommercePages(driver);
		Thread.sleep(2000);

		Signup.InvalidCredLogin();

		} catch (Exception e) {
			Screenshot.takeScreenshot(driver);// take screenshot
			driver.close();
		}
	}

	@Test(priority = 4)
	public void browseProduct() throws InterruptedException, EncryptedDocumentException, IOException {

		try {
		EcommercePages Signup = new EcommercePages(driver);
		Thread.sleep(2000);

		Signup.BrowseProduct();

		} catch (Exception e) {
			Screenshot.takeScreenshot(driver);// take screenshot
			driver.close();
		}
	}

	@Test(priority = 5)
	public void navigateProductCatogary() throws InterruptedException, EncryptedDocumentException, IOException {

		try {
		EcommercePages Signup = new EcommercePages(driver);
		Thread.sleep(2000);

		Signup.NavigateProductCatogary();

		} catch (Exception e) {
			Screenshot.takeScreenshot(driver);// take screenshot
			driver.close();
		}
	}

	@Test(priority = 6)
	public void navigateProductUsingNext() throws InterruptedException, EncryptedDocumentException, IOException {

	try {
		EcommercePages Signup = new EcommercePages(driver);
		Thread.sleep(2000);

		Signup.NavigateLastPageUsingNext();

		} catch (Exception e) {

			Screenshot.takeScreenshot(driver);// take screenshot
			driver.close();
		}
	}

	@Test(priority = 7)
	public void orderProduct() throws InterruptedException, EncryptedDocumentException, IOException {

	try {
		EcommercePages Signup = new EcommercePages(driver);
		Thread.sleep(2000);
		Signup.addProductToCart();

		} catch (Exception e) {
			Screenshot.takeScreenshot(driver);// take screenshot
			driver.close();
			
		}
	}

	@Test(priority = 8)
	public void verifyLogOut() throws InterruptedException, EncryptedDocumentException, IOException {

	try {
		EcommercePages Signup = new EcommercePages(driver);
		Thread.sleep(2000);

		Signup.LogOut();
		//take screenshot
		} catch (Exception e) {
			Screenshot.takeScreenshot(driver);
			driver.close();
			
		}
	}

	@AfterMethod
	public void closeBrowser() {

		//driver.close();
	}

	@AfterClass
	public void afterclass() {

		driver.quit();
	}

}
