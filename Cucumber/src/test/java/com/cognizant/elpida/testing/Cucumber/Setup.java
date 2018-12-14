package com.cognizant.elpida.testing.Cucumber;

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

public class Setup {
	WebDriver driver;
	static ExtentReports reports;
	ExtentTest tests;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		reports = new ExtentReports("C:\\Users\\Admin\\Desktop\\Foldery\\SillyReporty.html",true);
	}
	@After
	public void teardown() {
		driver.quit();
	}
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) throws Throwable {
	    driver.get(arg1);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {
	    WebElement searchbox = driver.findElement(By.id("sb_form_q"));
	    searchbox.sendKeys(arg1);
	    searchbox.submit();
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() throws Throwable {
		WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"b_results\"]"));
	    searchbox.isDisplayed();
	    
	}
}
