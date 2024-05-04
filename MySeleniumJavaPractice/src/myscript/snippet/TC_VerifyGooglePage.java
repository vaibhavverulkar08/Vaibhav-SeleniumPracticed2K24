package myscript.webdriver.snippet;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_VerifyGooglePage {
	public WebDriver driver;
	// Storing the Application Url in the String variable
	String url = ("https://www.google.co.in/");

	public static void main(String[] args) {
		TC_VerifyGooglePage script = new TC_VerifyGooglePage();

		System.out.println("---------------------");
		System.out.println("Script Statred");
		System.out.println("---------------------");

		script.launchBrowser();
		System.out.println("Browser Launched");
		System.out.println("---------------------");
		System.out.println("Test Case Running:");

		script.verifyTC_GooglePage();
		System.out.println("--Test Case Finished--");
		System.out.println("---------------------");

		script.navigateSeleniumCommands();
		script.tearDown();
		System.out.println("Browser closed");
		System.out.println("---------------------");

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

	public void verifyTC_GooglePage() {

		// Launch the WebSite
		driver.get(url);

		// Storing Title name in the String variable
		String title = driver.getTitle();

		// Storing Title length in the Int variable
		int titleLength = driver.getTitle().length();

		// Printing Title & Title length in the Console window
		System.out.println("Title of the page is : " + title);
		System.out.println("Length of the title is : " + titleLength);

		// Storing URL in String variable
		String actualUrl = driver.getCurrentUrl();

		if (actualUrl.equals("https://www.google.co.in/")) {
			System.out.println("Verification Successful - The correct Url is opened.");
		} else {

			System.out.println("Verification Failed - An incorrect Url is opened.");
		}

		// Storing Page Source in String variable
		String pageSource = driver.getPageSource();

		// Storing Page Source length in Int variable
		int pageSourceLength = pageSource.length();

		// Printing length of the Page Source on console
		System.out.println("Total length of the Pgae Source is : " + pageSourceLength);

	}

	private void navigateSeleniumCommands() {
		
	}
	public void tearDown() {
		// Closing browser
		// driver.close();
		// Quit the browser
		driver.quit();
	}

}
