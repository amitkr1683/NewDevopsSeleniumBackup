package action;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Class1 {
	private ChromeDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeMethod
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void firsttest() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.id("txtUsername")).click();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Logout")).click();
	}
}

