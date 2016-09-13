package com.williamhill.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WilliamHill {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		// Firefox
		// System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		driver = new FirefoxDriver();
		// Chrome
		// System.setProperty("webdriver.gecko.driver","chromedriver.exe");
		// driver = new ChromeDriver();
		baseUrl = "http://sports.williamhill.es/bet_esp/es";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testWilliamHillNew() throws Exception {
		
		String betAmount = "0.05"; // This variable should be a float, but the Selenium Test has been generated with String and I have no time to perform the changes
		
		// Load the main page http://sports.williamhill.es/bet_esp/es
		driver.get(baseUrl + "/bet_esp/es/");
		// From the main page click on Id "football"
		driver.findElement(By.id("football")).click();
		// Select the button Clicks on Premiere League button
		driver.findElement(By.xpath("//div[@id='contentA']/div[9]/a[3]/span/span")).click();
		// Select the open match 10 Sep 13:30 ES Man Utd ₋ Man City
		driver.findElement(By.id("9825512_mkt_namespace")).click();
		// Select bet Manchester United as winner
		driver.findElement(By.id("ip_selection1302646554price")).click();
		// Click on the amount field
		driver.findElement(By.id("ip_selection1302646554name")).click();
		// Amount field have to be cleared
		driver.findElement(By.id("slip_sgl_stake1302646554L")).clear();
		// Insert the amount for the bet
		driver.findElement(By.id("slip_sgl_stake1302646554L")).sendKeys(betAmount);
		// Click on "Do Bet" button
		driver.findElement(By.id("slipBtnPlaceBet")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
