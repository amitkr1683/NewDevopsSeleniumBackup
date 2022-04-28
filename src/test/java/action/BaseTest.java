package action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;

	@BeforeTest
	public void launchApp() {
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

	}
	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);
		driver.close();
	}
}