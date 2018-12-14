package com.cognizant.testing.Selinium101;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelinium {
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Before");
	}
	@After
	public void teardown() throws InterruptedException {
		System.out.println("After");
		Thread.sleep(5000);
		driver.quit();
		
	}
//	@Test
//	public void seleniumTest() {
//		driver.get("https://www.newyorker.com/");
//		sb_form_go
//	}
//	@Test
//	public void testery() {
//		System.out.println("//*[@id="b_context"]/li[1]/div/div[1]/h2");
//	}
	@Test
	public void gettingElements() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://www.bing.com");
		WebElement textbox = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
		textbox.sendKeys("selenium");
		Thread.sleep(1000);
		WebElement search= driver.findElement(By.id("sb_form_go"));
		textbox.submit();
		Thread.sleep(1000);
		search.submit();
		Thread.sleep(1000);
		search.submit();
		Thread.sleep(1000);
		WebElement sel = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
		assertEquals("Selenium is not displayed: ", true, sel.isDisplayed());
		
		
	}
	
	
}
