package myscript.webdriver.snippet;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class GoogleTest_HighlightElement {

	public static void main(String[] args) {
		// Set the path to chromedriver executable
		System.setProperty("webdriver.chrome.driver", "browser-drivers/chromedriver-win64/chromedriver.exe");

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();

		// Maximize the browser window
		driver.manage().window().maximize();

		// Navigate to Google homepage
		driver.get("https://www.google.com/");

		// Find the search text box and enter text
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Top indian cities");

		// Highlight the search box
		highlightElement(driver, searchBox);

		// Move the mouse beside the search button
		Actions actions = new Actions(driver);
		WebElement searchButton = driver.findElement(By.name("btnK"));
		actions.moveToElement(searchButton).perform();

		// Check if search button is enabled and clickable
		if (searchButton.isEnabled() && searchButton.isDisplayed()) {
			// Highlight the search button
			highlightElement(driver, searchButton);

			// Click the search button
			searchButton.click();

			// Wait for search results to load (add appropriate wait logic)
			// Perform actions on search results page
			// For example, assert/asserts to verify search results
		} else {
			System.out.println("Search button is not enabled or clickable");
		}

		// Close the browser
		//driver.quit();
	}

	// Method to highlight an element
	public static void highlightElement(WebDriver driver, WebElement element) {
		// Execute JavaScript to highlight the element
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
				element);
	}
}
