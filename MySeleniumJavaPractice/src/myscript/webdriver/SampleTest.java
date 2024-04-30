package myscript.webdriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

	public static void main(String[] args) {
		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "browser-drivers/chromedriver-win64/chromedriver.exe");
		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// imlicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
}
