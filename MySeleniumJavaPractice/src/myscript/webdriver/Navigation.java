package myscript.webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * s sample test, we will automate the following test scenarios:
Invoke ChromeBrowser
Navigate to URL: https://www.google.com/
Click on the image link on google page
Come back to the Home page using the back command
Again go back to the image page using forward command
Again come back to the Home page using To command
Refresh the Browser using Refresh command
Close the Browser
 * */
public class Navigation {
	WebDriver driver;
	String url = "https://www.google.com/";
	String linktextLocator = "Images";

	public static void main(String[] args) {
		Navigation ts = new Navigation();

		System.out.println("Browser Launched");
		ts.launchBrowser();

		System.out.println("Navigate to Google page");
		ts.navigateToHomePageUrl();
		System.out.println("-----------------------");

		System.out.println("Clicking on Image Link to go on Google Image page");
		ts.clickOnImageLink();
		System.out.println("-----------------------");

		System.out.println("Navigate Back to Google Home Page");
		ts.navigateBackToUrl();
		System.out.println("-----------------------");

		System.out.println("Go Forword to Google Image Page");
		ts.goBackToImageLinkLink();
		System.out.println("-----------------------");

		System.out.println("Again Back to Google Home Page");
		ts.navigateBackToUrl();
		System.out.println("Refresh the page");
		ts.refreshPage();
		System.out.println("-----------------------");

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

	public void navigateToHomePageUrl() {
		driver.navigate().to(url);
		getpageDetails();
	}

	public void clickOnImageLink() {
		driver.findElement(By.linkText(linktextLocator)).click();
		getpageDetails();
	}

	public void navigateBackToUrl() {
		driver.navigate().back();
	}

	public void goBackToImageLinkLink() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
		getpageDetails();
	}
}
