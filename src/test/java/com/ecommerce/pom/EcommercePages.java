package com.ecommerce.pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EcommercePages {

	static WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "signin2")
	WebElement signUpButton;

	@FindBy(xpath = "//input[@id='sign-username']")
	WebElement usernameInputox;

	@FindBy(xpath = "//input[@id='sign-password']")
	WebElement passwordInputBox;

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signUp;

	@FindBy(id = "login2")
	WebElement loginButton;

	@FindBy(id = "loginusername")
	WebElement loginUserName;

	@FindBy(id = "loginpassword")
	WebElement loginPassword;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginButtonSubmit;

	@FindBy(id = "nameofuser")
	WebElement welcomeWebElement;

	@FindBy(xpath = "//a[text()='Phones']")
	WebElement phoneTab;

	@FindBy(xpath = "//button[text()='Next']")
	WebElement nextButton;

	@FindBy(xpath = "//a[text()='Laptops']")
	WebElement laptopsTab;

	@FindBy(xpath = "//a[text()='Monitors']")
	WebElement monitorsTab;

	@FindBy(xpath = "//a[text()='Nokia lumia 1520']")
	WebElement nokiaPhone;

	@FindBy(xpath = "//a[text()='MacBook Pro']")
	WebElement lastProduct;

	@FindBy(xpath = "//a[text()='Add to cart']")
	WebElement addToCart;

	@FindBy(xpath = "//a[text()='Cart']")
	WebElement viewCart;

	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement placeOrder;

	@FindBy(id = "name")
	WebElement nameOrderForm;

	@FindBy(id = "country")
	WebElement countryOrderForm;

	@FindBy(id = "city")
	WebElement cityOrderForm;

	@FindBy(id = "card")
	WebElement cardOrderForm;

	@FindBy(id = "month")
	WebElement monthOrderForm;

	@FindBy(id = "year")
	WebElement yearOrderForm;

	@FindBy(xpath = "//button[text()='Purchase']")
	WebElement purchaseButton;

	@FindBy(xpath = "//a[text()='Home ']")
	WebElement homeButton;

	@FindAll(@FindBy(how = How.XPATH, using = "//td//a[text()='Delete']"))
	List<WebElement> allElements;

	@FindAll(@FindBy(how = How.XPATH, using = "//button[text()='Next']"))
	List<WebElement> nextButtons;
	
	@FindBy(xpath = "//button[text()='OK']")
	WebElement okButton;
	
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logoutButton;
	

	@FindBy(xpath = "//button[text()='Close']")
	WebElement closeButton;
	
	public EcommercePages(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean signupPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin2")));
		boolean result = signUpButton.isDisplayed();
		return result;
	}

	public void UsersignupPage() throws InterruptedException {
		Thread.sleep(2000);
		signUpButton.click();
		Thread.sleep(2000);
		usernameInputox.sendKeys("RutikmM");
		Thread.sleep(2000);
		passwordInputBox.sendKeys("Rut78123");
		signUp.click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.switchTo().alert().getText(), "Sign up successful.");
		driver.switchTo().alert().accept();
		closeButton.click();

	}

	public void UsersignupPageBlankInput() throws InterruptedException {
		Thread.sleep(2000);
		signUpButton.click();
		Thread.sleep(2000);
		usernameInputox.sendKeys("   ");
		passwordInputBox.sendKeys("");
		signUp.click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.switchTo().alert().getText(), "Please fill out Username and Password.");
		driver.switchTo().alert().accept();
		

	}

	public void Login() throws InterruptedException {

		loginButton.click();
		Thread.sleep(2000);
		loginUserName.sendKeys("Rutik More");
		loginPassword.sendKeys("RutikMore@123");
		Thread.sleep(200);
		loginButtonSubmit.click();
		Assert.assertFalse(welcomeWebElement.getText().contains("Welcome"));
		// welcomeWebElement.getText().contains("Welcome")
//	Assert.assertEquals(welcomeWebElement.getText().,"");

	}

	public void InvalidCredLogin() throws InterruptedException {

		loginButton.click();
		Thread.sleep(2000);
		loginUserName.sendKeys("Rut");
		loginPassword.sendKeys("RutikMo23");

		loginButtonSubmit.click();
		// welcomeWebElement.getText().contains("Welcome")
		Thread.sleep(2000);
		Assert.assertEquals(driver.switchTo().alert().getText(), "Wrong password.");
		driver.switchTo().alert().accept();
	}

	public void BrowseProduct() throws InterruptedException {
		loginButton.click();
		Thread.sleep(2000);
		loginUserName.sendKeys("Rutik More");
		loginPassword.sendKeys("RutikMore@123");
		Thread.sleep(200);
		loginButtonSubmit.click();
		Assert.assertFalse(welcomeWebElement.getText().contains("Welcome"));
		Thread.sleep(2000);
		phoneTab.click();
		nokiaPhone.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		js.executeScript("window.scrollBy(0,-250)", "");
	}

	public void NavigateProductCatogary() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		loginButton.click();
		Thread.sleep(2000);
		loginUserName.sendKeys("Rutik More");
		loginPassword.sendKeys("RutikMore@123");
		Thread.sleep(200);
		loginButtonSubmit.click();
		Assert.assertFalse(welcomeWebElement.getText().contains("Welcome"));
		Thread.sleep(2000);
		phoneTab.click();
		js.executeScript("window.scrollBy(0,250)", "");
//		nextButton.click();
		Thread.sleep(2000);
		laptopsTab.click();
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
//		nextButton.click();
		Thread.sleep(2000);
		monitorsTab.click();
		js.executeScript("window.scrollBy(0,250)", "");
//		nextButton.click();
	}

	public void NavigateLastPageUsingNext() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		loginButton.click();
		Thread.sleep(2000);
		loginUserName.sendKeys("Rutik More");
		loginPassword.sendKeys("RutikMore@123");
		Thread.sleep(200);
		loginButtonSubmit.click();
		Assert.assertFalse(welcomeWebElement.getText().contains("Welcome"));
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,250)", "");
		//if(nextButtons.sj)
			for(WebElement elmnt:nextButtons)
			{
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,250)", "");
				elmnt.click();
			}
	}

	public void addProductToCart() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		loginButton.click();
		Thread.sleep(2000);
		loginUserName.sendKeys("Rutik More");
		loginPassword.sendKeys("RutikMore@123");
		Thread.sleep(200);
		loginButtonSubmit.click();
		Assert.assertFalse(welcomeWebElement.getText().contains("Welcome"));
		Thread.sleep(5000);
		viewCart.click();
		Thread.sleep(5000);
		if (allElements.size() != 0) {
			for (WebElement ele : allElements) {
				try {
				Thread.sleep(3000);
				ele.click();
				Thread.sleep(3000);
				}
				catch(StaleElementReferenceException e)
				{
					Thread.sleep(3000);
					ele.click();
					Thread.sleep(3000);
				}
			}
		}
		homeButton.click();
		js.executeScript("window.scrollBy(0,250)", "");
		//if(nextButtons.sj)
			for(WebElement elmnt:nextButtons)
			{
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,250)", "");
				elmnt.click();
			}
//		nextButton.click();
//		Thread.sleep(2000);
//		js.executeScript("window.scrollBy(0,250)", "");
//		nextButton.click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,250)", "");
		lastProduct.click();
		Thread.sleep(2000);
		addToCart.click();
		Thread.sleep(5000);
		if (driver.switchTo().alert().getText().contains("Product added.")) {
			driver.switchTo().alert().accept();
		}
		viewCart.click();
		Thread.sleep(2000);
		placeOrder.click();
		Thread.sleep(5000);
		nameOrderForm.sendKeys("Rutik More");
		countryOrderForm.sendKeys("India");
		cityOrderForm.sendKeys("Pune");
		cardOrderForm.sendKeys("1234 5678 7890");
		monthOrderForm.sendKeys("July");
		yearOrderForm.sendKeys("2024");
		Thread.sleep(2000);
		purchaseButton.click();
		Thread.sleep(2000);
		okButton.click();

	}
	public void LogOut() throws InterruptedException {

		loginButton.click();
		Thread.sleep(2000);
		loginUserName.sendKeys("Rutik More");
		loginPassword.sendKeys("RutikMore@123");
		Thread.sleep(2000);
		loginButtonSubmit.click();
		Assert.assertFalse(welcomeWebElement.getText().contains("Welcome"));
		Thread.sleep(5000);
		logoutButton.click();
		Assert.assertFalse(loginButton.getText().contains("Log In"));

	}
}
