package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Chrome_drivers {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		//public static final WebDriver webDriver = new ChromeDriver();;
		//webDriver.get("http://www.demo.guru99.com/V4/");
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);
		driver.close();
	}
}
