package com.cognizant.elpida.testing.Reports101;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportsTest101 {
	ExtentReports reports;
	ExtentTest tests;
	WebDriver driver;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		reports = new ExtentReports("C:\\Users\\Admin\\Desktop\\Foldery\\Reporty.html",true);
	}
	@Test
	public void reports101test() throws InterruptedException {
		tests = reports.startTest("Bing Search for Selinium");
		driver.manage().window().maximize();
		driver.get("https://www.bing.com");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("sb_form_q"));
		element.sendKeys("seleniumiumium");
		element.submit();
		Thread.sleep(1000);
		try {
			WebElement sidebar = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div"));
			if(sidebar.getText().equals("Selenium")) {
				tests.log(LogStatus.PASS, "It has found Selenium at the given xpath");
			}
			else {
				tests.log(LogStatus.FAIL, "it has not found Selenium at the given xpath");
				fail();
			}
		}
		catch(NoSuchElementException e) {
			tests.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		}
		         
	}
	@Test
	public void testy2() throws InterruptedException {
		tests = reports.startTest("Bing Search for selenium");
		driver.get("https://www.bing.com/");
		WebElement element = driver.findElement(By.id("sb_form_q"));
		element.sendKeys("Selenium");
		element.submit();
		Thread.sleep(1000);
		try {
			WebElement sideBar = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
			if (sideBar.getText().equals("Selenium")) {
				tests.log(LogStatus.PASS, "It has found selenium at the given xpath");
			} else {
				tests.log(LogStatus.FAIL, "It has not found selenium at the given xpath");
				fail();
			}
		} catch (Exception e) {
			tests.log(LogStatus.FAIL, e.getLocalizedMessage());
			fail();
		}
	}
	
	
	@After
	public void teardown() throws InterruptedException {
		System.out.println("After");
		reports.endTest(tests);
		reports.flush();
		driver.quit();
	}
	

}
