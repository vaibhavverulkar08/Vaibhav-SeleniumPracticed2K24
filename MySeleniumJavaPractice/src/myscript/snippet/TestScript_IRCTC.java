package myscript.webdriver.snippet;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript_IRCTC {

	public static WebDriver driver;
	String urlAUT = "https://www.irctc.co.in/nget/user-registration";

	public static void main(String[] args) throws Exception {

		/*
		 * Test Scenario: The following application is used for demo purpose
		 * URL:https://www.irctc.co.in/nget/user-registration Scenario Open the
		 * https://www.irctc.co.in/nget/user-registration for AUT Find the text of radio
		 * buttons and print on console. Click On Contact & Fetch Contact Information
		 * print on console, Closed Contact PopUp Window.
		 */

		TestScript_IRCTC ts = new TestScript_IRCTC();
		ts.setUp();
		// Wait for 30 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ts.testCaseOneOpenURL();
		ts.testCaseTwoGetListOfRadioButtonsCountAndText();
		ts.TestCaseGetContact();
		ts.tearDown();

	}

	public void setUp() {
		// System Property for ChromeDriver
		System.setProperty("webdriver.chrome.driver", "browser-drivers//chromedriver-win64//chromedriver.exe");

		// Instantiate a ChromeDriver class.
		// Launch The Browser
		driver = new ChromeDriver();

		// Maximize The Window
		driver.manage().window().maximize();

		System.out.println("Set Up Done.");
		System.out.println("-------------------");
	}

	public void testCaseOneOpenURL() {
		// Getting URl of AUT
		driver.get(urlAUT);
		System.out.println("URL is Opened.");
		System.out.println("----- TC_01_Finished -------");

	}

	public void testCaseTwoGetListOfRadioButtonsCountAndText() {
		// Test Script for Test Scenario :
		// Locating Elements for radio buttons
		List<WebElement> elements = driver.findElements(By.id("M"));

		//
		System.out.println("Number of elements:" + elements.size());

		// Printing all Radio buttons
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
		}
		System.out.println("----- TC_02 _Finished -------");
		System.out.println("-------------------");
		System.out.println("Test Script Finished.");
	}

	public void TestCaseGetContact() throws Exception {
		WebElement Contactbtn = driver.findElement(By.xpath("//a[@aria-label='Click here to open contact us popup']"));
		Contactbtn.click();

		WebElement contactInfo = driver
				.findElement(By.xpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[5]/div/div/div[2]"));
		System.out.println("Contact Info Fetched:");
		System.out.println("--------------------------------------------------------");
		System.out.println(contactInfo.getText());
		System.out.println("--------------------------------------------------------");
		Thread.sleep(2000);

		WebElement closeBtn = driver.findElement(
				By.xpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[5]/div/div/div[1]/div/a"));
		closeBtn.click();
		System.out.println("Closed Contact Popup");
		Thread.sleep(2000);

		System.out.println("----- TC_03 _Finished -------");
		System.out.println("-------------------");

	}

	public void tearDown() {
		driver.quit();
		System.out.println("Browser Window Quit.");
		System.out.println("-------------------");

	}
}
