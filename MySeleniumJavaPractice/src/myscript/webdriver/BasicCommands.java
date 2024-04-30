package myscript.webdriver;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicCommands {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "browser-drivers/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // Browser Launched

		String URL= "https://artoftesting.com";
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicit Wait - Selenium4

		driver.manage().window().fullscreen(); // Full Window Screen size
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		
		driver.get(URL); // URL Opened

		driver.getClass();

		driver.getCurrentUrl(); // Getting current URL
		
		driver.getPageSource(); //return pageSourece
		
		driver.getTitle(); //get pagetitle 
		
		String cuuentwindow = driver.getWindowHandle();
		
		Set<String> allwindow =driver.getWindowHandles();
		
		driver.navigate().to("https://artoftesting.com/samplesiteforselenium"); // Navigate to URL
		
		driver.navigate().back(); // Navigate Back
		
		driver.navigate().forward(); // Navigate Forward
		
		
		
		//driver.close(); //Closed Browser

		driver.quit(); // Quit Browser

	}
}
