package myscript.webdriver.snippet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

	public static void main(String[] args) {
		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "browser-drivers/chromedriver-win64/chromedriver.exe");
		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// imlicitly wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		String url = "https://www.google.com/";
		driver.get(url);
		WebElement q =driver.findElement(By.xpath("//textarea[@id='APjFqb']"));

		q.sendKeys("Top Indian Cities list");
		
	//	Actions action  = new Actions(driver);
	//	action.moveToElement(driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"))).build().perform();
		
	}
}
