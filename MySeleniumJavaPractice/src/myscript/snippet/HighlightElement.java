package myscript.webdriver.snippet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElement {

	public static void highlightElement(WebDriver driver, WebElement element) {
		// Execute JavaScript to highlight the element
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid yellow'",
				element);
	}
}
