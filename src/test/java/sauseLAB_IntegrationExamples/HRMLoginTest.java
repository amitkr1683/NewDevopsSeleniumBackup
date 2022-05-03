package sauseLAB_IntegrationExamples;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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

public class HRMLoginTest extends BaseTestSauceLab {

	public void doLogin() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	@Test(priority = 1)
	public void check_DashboardTest() throws Exception {
		doLogin();
		AssertJUnit.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
		
	}
	
	@Test(priority = 2)
	public void check_WelcomeTest() throws Exception {
		doLogin();
		Thread.sleep(2000);
		String welcomAmit = driver.findElement(By.id("Welcome")).getText();
		
		AssertJUnit.assertTrue(welcomAmit.contains("Welcome"));
		
	}	
}