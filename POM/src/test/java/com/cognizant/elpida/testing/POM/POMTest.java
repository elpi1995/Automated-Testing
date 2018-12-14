package com.cognizant.elpida.testing.POM;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class POMTest {
	public WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void searchText	() throws InterruptedException, IOException {
		driver.get("https://www.bing.com/");
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File("C:\\Users\\Admin\\Desktop\\Pictures\\pic2.png"));
		BingLandingPage bingPage = PageFactory.initElements(driver, BingLandingPage.class);
		BingSearchedPage bingSearchPage = PageFactory.initElements(driver, BingSearchedPage.class);
		
		bingPage.search("Selenium");
		assertEquals("Selenium", bingSearchPage.getSearch().getText());	
	}
	

	@After
	public void tearDown() {
		driver.quit();
	}

}