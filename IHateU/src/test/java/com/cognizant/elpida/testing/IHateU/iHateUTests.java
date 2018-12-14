package com.cognizant.elpida.testing.IHateU;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class iHateUTests {
	WebDriver driver;
	static ExtentReports reports;
	ExtentTest tests;
	@BeforeClass
	public static void initial() {
		reports = new ExtentReports("C:\\Users\\Admin\\Desktop\\Foldery\\IHateReporty.html",true);
	}
	
	@AfterClass
	public static  void end() {
		reports.close();
	}
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://christophperrins.github.io/TestingSite/");
		
		
	}
	@After
	public void teardown() throws InterruptedException {
		System.out.println("After");
		reports.endTest(tests);
		reports.flush();
		driver.quit();
	}
	@Test
	public void threadTest() throws InterruptedException {
		tests = reports.startTest("Thread Test");
		try {
			WebElement iHateU = driver.findElement(By.id("quote"));
			Thread.sleep(5500);
			
			if (iHateU.isDisplayed()) {
				tests.log(LogStatus.PASS, "It has found I HATE U");
			}
			else {
				tests.log(LogStatus.FAIL, "it has not found I HATE U");
				fail();
			}
		}
		catch(NoSuchElementException e) {
			tests.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		}
	}
	@Test
	public void implicitTest() throws InterruptedException {
		tests = reports.startTest("implicit test");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			WebElement iHateU2 = driver.findElement(By.xpath("//*[@id=\"quote\"]/h2"));
			Thread.sleep(101);
			if (iHateU2.isDisplayed()) {
				tests.log(LogStatus.PASS, "It has found I HATE U");
			}
			else {
				tests.log(LogStatus.FAIL, "it has not found I HATE U");
				fail();
			}
		}
		catch(NoSuchElementException e) {
			tests.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		}
	}
	@Test
	public void explicitTest() throws InterruptedException {
		tests = reports.startTest("explicit test");
		try {
			WebElement iHateU3 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"quote\"]/h2")));
			if (iHateU3.isDisplayed()) {
				tests.log(LogStatus.PASS, "It has found I HATE U");
			}
			else {
				tests.log(LogStatus.FAIL, "it has not found I HATE U");
				fail();
			}
		}
		catch(NoSuchElementException e) {
			tests.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		}
	}
}
