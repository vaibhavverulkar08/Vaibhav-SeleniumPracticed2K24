package myscript.webdriver.snippet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Goggle_Page {
	public static void main(String[] args) {

		//Set the system property for ChromeDriver (path to ChromeDriver executable)
		// System.setProperty("Key","path-of-driver");

		System.setProperty("webdriver.chrome.driver","browser-drivers/chromedriver-win64/chromedriver.exe");
	
		//Create an instance of ChromeDriver.
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser Launched");
	
		//Storing web URL in string variable URL
		String webAppURL = "https://www.google.com";

		//Opening the desired URL on browser.
		driver.get(webAppURL);
		System.out.println("Web-App URL opend on broswer");

		// Get and print the page title
		String pageTitle = driver.getTitle();
		System.out.println("The Page Title of Current WepPage: "+pageTitle);

		// wait for few seconds.
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println("few seconds over");

//		Close the browser.
		driver.quit();
		System.out.println("Browser closed");

	}
}
