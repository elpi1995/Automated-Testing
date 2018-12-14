package com.cognizant.elpida.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class shoppingTest {
	WebDriver driver;
	static ExtentReports reports;
	ExtentTest tests;
	@BeforeClass
	public static void initial() {
		reports = new ExtentReports("C:\\Users\\Admin\\Desktop\\Foldery\\CapitalistReporty.html",true);
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
		System.out.println("Before");
	}
	@After
	public void teardown() throws InterruptedException {
		System.out.println("After");
		reports.endTest(tests);
		reports.flush();
		driver.quit();

	}
	@Test
	public void searchBlouse() {
		driver.get("http://automationpractice.com/index.php");
		tests = reports.startTest("Dress Test");
		try {
			WebElement women = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
			women.click();
			WebElement tops = driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a/img"));
			tops.click();
			WebElement blouses = driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a/img"));
			blouses.click();
			WebElement blouse = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
			if(blouse.isDisplayed()) {
				tests.log(LogStatus.PASS, "It has found blouse");
			}
			else {
				tests.log(LogStatus.FAIL, "it has not found blouse");
				fail();
			}
		}
		catch(NoSuchElementException e) {
			tests.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		}	
	}
}
