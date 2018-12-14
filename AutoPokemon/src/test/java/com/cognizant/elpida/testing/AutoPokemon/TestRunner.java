package com.cognizant.elpida.testing.AutoPokemon;

import org.openqa.selenium.WebDriver;
import org.junit.runner.JUnitCore;
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

public class TestRunner {
	static WebDriver driver;
	public void start() {
		JUnitCore.runClasses(TaskOne.class);
		JUnitCore.runClasses(TaskTwo.class);
	}
	
	public static void main(String[] args) {
		TestRunner runner = new TestRunner();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		runner.start();
		
		
		
		driver.quit();
	}
	
}