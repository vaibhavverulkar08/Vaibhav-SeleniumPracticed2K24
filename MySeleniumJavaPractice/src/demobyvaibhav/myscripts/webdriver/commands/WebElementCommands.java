package myscripts.webdriver.commands;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import myscript.webdriver.snippet.HighlightElement;

// Selenium WebDriver - WebElement Commands
//Test Automation Scenario : Verify valid user Gmail SigIn page.
// Automated By Vaibhav Verulkar
public class WebElementCommands {

	WebDriver driver;
	String url = "https://www.google.com/";
	String userEmail = "user1@gmail.com";
	// String xpathSigninbtn = //*[@id="gb"]/div/div[2]/a/span
	// xpath Nextbtn = //*[@id="identifierNext"]/div/button/span

	public static void main(String[] args) throws Exception {
		WebElementCommands ts = new WebElementCommands();
		// Steps:
		System.out.println("---------------------------------------------");
		ts.launchBrowser();
		System.out.println("Browser Launched");
		ts.openURL();
		System.out.println("URl Opened");
		Thread.sleep(4000);

		ts.clickOnSignInBtn();
		System.out.println("SignIn Button Clicked");
		Thread.sleep(4000);

		ts.enterEmail();
		System.out.println("Email Entered");
		Thread.sleep(4000);

		ts.clickNext();
		System.out.println("Clicked on NEXT");
		Thread.sleep(4000);

		System.out.println("---Printing Message on Console:---");
		ts.getScreenMessage();
		Thread.sleep(4000);

		System.out.println("Browser Closed");
		ts.tearDown();
		System.out.println("---------------------------------------------");

	}

	public void launchBrowser() {
		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "browser-drivers/chromedriver-win64/chromedriver.exe");
		// Instantiate a ChromeDriver class.
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// imlicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void getpageDetails() {
		System.out.println("Curent Page URL: " + driver.getCurrentUrl());
		System.out.println("Curent Page Title: " + driver.getTitle());
	}

	public void openURL() {
		driver.get(url);
		getpageDetails();
	}

	public void clickOnSignInBtn() {
		WebElement sigInbtn = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a/span"));
		HighlightElement.highlightElement(driver, sigInbtn);
		
		sigInbtn.click();
	}

	public void enterEmail() {
		// WebElement inputEmail = driver.findElement(By.id("identifierId"));
		// inputEmail.clear();
		// inputEmail.sendKeys(userEmail);

		// OR
		WebElement emailInputField = driver.findElement(By.id("identifierId"));
		HighlightElement.highlightElement(driver, emailInputField);
		
		boolean status = emailInputField.isEnabled();
		// Check that if the Text field is enabled, if yes enter value
		System.out.println(status);
		if (status) {
			emailInputField.sendKeys(userEmail);
		}
	}

	private void clickNext() throws Exception {
		WebElement btnNext = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
		HighlightElement.highlightElement(driver, btnNext);

		btnNext.click();
		Thread.sleep(4000);
		//getpageDetails();
	}
	
	public void getScreenMessage() {
		//WebElement fetchText = driver.findElement(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div[2]"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement fetchText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div[2]")));
		HighlightElement.highlightElement(driver, fetchText);
		String message =fetchText.getText();
		System.out.println("The Message is on Screen: "+message);
	}
	
	public void tearDown() {
		driver.quit();
	}
}
