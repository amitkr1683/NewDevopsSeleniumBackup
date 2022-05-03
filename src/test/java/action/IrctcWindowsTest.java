package action;

import org.testng.annotations.Test;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcWindowsTest {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(2000);
		// driver.close();
		driver.quit();
	}

	@Test
	public void SwitchingTestCase1() throws Exception {

		// click on Ok button
		// driver.findElement(By.xpath("//button[contains(text(),'K')]")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();

		// handle windows
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);

		// click on Hotels
		driver.findElement(By.partialLinkText("HOTELS")).click();

		Set<String> AllWindowsHandles = driver.getWindowHandles();

		String mainIRCTCWindow = (String) AllWindowsHandles.toArray()[0];// main windows
		String hotelWindow = (String) AllWindowsHandles.toArray()[1];// hotel windows

		Thread.sleep(4000);

		// switch to hotel Windows
		driver.switchTo().window(hotelWindow);

		// click on login
		driver.findElement(By.linkText("Login")).click();

		Thread.sleep(4000);

		// switch to hotel windows
		driver.switchTo().window(mainIRCTCWindow);

		// click on Contact us
		driver.findElement(By.xpath("//a[contains(text(),'CONTACT US')]")).click();

	}
}
