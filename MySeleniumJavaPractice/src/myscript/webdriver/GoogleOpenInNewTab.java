package myscript.webdriver;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	import java.util.ArrayList;

	public class GoogleOpenInNewTab {
	    public static void main(String[] args) {
	        // Set the path to the ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "browser-drivers/chromedriver-win64/chromedriver.exe");

	        // Initialize ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Navigate to Google's website
	        driver.get("https://www.google.com");

	        // Get the current window handle
	        String currentWindowHandle = driver.getWindowHandle();

	        // Get the current page URL
	        String currentUrl = driver.getCurrentUrl();

	        // Open the current page URL in a new tab/window
	        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	        driver.get(currentUrl);

	        // Get all window handles
	        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

	        // Check if there's more than one window handle
	        if (windowHandles.size() > 1) {
	            // Switch to the newly opened window
	            driver.switchTo().window(windowHandles.get(1));

	            // Now you are in the new window, you can perform operations here
	        } else {
	            System.out.println("No new window/tab opened.");
	        }

	        // Close the driver
	        driver.quit();
	    }
	}
	