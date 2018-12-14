package com.cognizant.elpida.testing.AutoPokemon;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
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


public class TaskTwo {
	@Test
	public void test2() throws InterruptedException {
		System.out.println("1");
		WebElement body  = TestRunner.driver.findElement(By.tagName("body"));
		System.out.println("2");
		WebElement enemy = TestRunner.driver.findElement(By.id("enemyInfo"));
		System.out.println("3");
		WebElement route = TestRunner.driver.findElement(By.id("currentRoute"));
		System.out.println("4");
		System.out.println(route.getText());
		
		
	
	}
}
