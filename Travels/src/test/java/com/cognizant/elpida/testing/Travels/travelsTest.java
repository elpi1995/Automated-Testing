package com.cognizant.elpida.testing.Travels;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class travelsTest {
	WebDriver driver;
	String destination = "London";
	String password = "Pass123";
	@Before
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("Before");
	}
	@After
	public void teardown() throws InterruptedException {
		System.out.println("After");

		driver.quit();
	}
	@Test
	public void bookTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/");
		WebElement hotels = driver.findElement(By.xpath("//*[@id=\"body-section\"]/section/div[2]/div/div/div[2]/ul/li[1]/a"));
		//WebElement city = driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div"));
		WebElement guests = driver.findElement(By.xpath("//*[@id=\"travellersInput\"]"));
		WebElement adultsPlus = driver.findElement(By.xpath("//*[@id=\"adultPlusBtn\"]"));
		WebElement childrenPlus = driver.findElement(By.xpath("//*[@id=\"childInput\"]"));
		WebElement arrival = driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input"));
		WebElement arrivalday = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr[3]/td[6]"));
		WebElement departure = driver.findElement(By.xpath("//*[@id=\"dpd2\"]/div/input"));
		WebElement departureday = driver.findElement(By.xpath("/html/body/div[10]/div[1]/table/tbody/tr[4]/td[1]"));
		Actions setGuestNumber = new Actions(driver);
		setGuestNumber.doubleClick(guests).click(adultsPlus).perform();
		Actions setDay = new Actions(driver);
		setDay.click(departure).click(departureday).click(arrival).click(arrivalday).perform();
		Actions setCity = new Actions(driver);
		
		Thread.sleep(5000);
		
		
	}
	
}