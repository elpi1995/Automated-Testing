package com.cognizant.elpida.testing.Tea;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {
	WebDriver driver;
	static ExtentReports reports;
	ExtentTest tests;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@After
	public void teardown() {
		driver.quit();
	}
	@Given("^the correct web address$")
	public void the_correct_web_address() throws Throwable {
	    
	    driver.get("http://www.practiceselenium.com/welcome.html");
	    
	    
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws Throwable {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
		element.click();
	    
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
		WebElement greenTea = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong"));
		WebElement redTea = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong"));
		WebElement oolongTea = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p/span/span/strong"));
		greenTea.isDisplayed();
		redTea.isDisplayed();
		oolongTea.isDisplayed();
		
		
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
	    WebElement checkout = driver.findElement(By.partialLinkText("Check Out"));
	    checkout.click();
	   
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {
	    driver.get("http://www.practiceselenium.com/check-out.html");
	}

}
