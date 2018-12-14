package com.cognizant.elpida.testing.JavaScript;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class JSTest {
public WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void javaScriptTest	() throws InterruptedException, IOException {
		driver.get("https://www.bing.com/");
		WebElement element = driver.findElement(By.id("sb_form_q"));
		element.sendKeys("Hello");
		script(JavaScript)
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	

}
