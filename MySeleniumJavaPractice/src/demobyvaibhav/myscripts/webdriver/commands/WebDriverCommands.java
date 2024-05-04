package myscripts.webdriver.commands;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCommands {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "browser-drivers/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // Browser Launched

		String URL= "https://artoftesting.com";
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicit Wait - Selenium4
		
		//Point setpoint = driver.manage().window().setPosition(); //("Point","targetPosition");
		//Dimension setdim = driver.manage().window().setSize(); //("Dimension","targetSize")
		
		Point getDefaultPointion = driver.manage().window().getPosition(); //("Point","targetPosition");
		System.out.println("Poisition at  x: "+getDefaultPointion.x);
		System.out.println("Poisition at  y : "+getDefaultPointion.y);
		System.out.println("Poisition get at  x : "+getDefaultPointion.getX());
		System.out.println("Poisition get at  y: "+getDefaultPointion.getY());
		
		System.out.println("Default Position x&y: "+getDefaultPointion);
		
		Point pos = driver.manage().window().getPosition(); //("Point","targetPosition");
		System.out.println("Postion moved by (12,20) to origin(9,9):(21,29) "+pos.moveBy(12, 20));



		
		Dimension getdim = driver.manage().window().getSize();
		System.out.println("Dimension Height is: "+getdim.getHeight());
		System.out.println("Dimension Width is:"+getdim.getWidth());
		
		Dimension dimsizeDefault  = driver.manage().window().getSize(); 
		System.out.println("Default Window Size is: "+dimsizeDefault);
		
		driver.manage().window().fullscreen(); // Full Window Screen size
		
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		
		driver.get(URL); // URL Opened

		driver.getCurrentUrl(); // Getting current URL
		
		driver.getPageSource(); //return pageSourece
		
		driver.getTitle(); //get pagetitle 
		
		String cuuentwindow = driver.getWindowHandle();
		
		Set<String> allwindows =driver.getWindowHandles();
		
		driver.navigate().to("https://artoftesting.com/samplesiteforselenium"); // Navigate to URL
		
		driver.navigate().back(); // Navigate Back
		
		driver.navigate().forward(); // Navigate Forward
		
		//driver.close(); //Closed Browser

		driver.quit(); // Quit Browser

	}
}
