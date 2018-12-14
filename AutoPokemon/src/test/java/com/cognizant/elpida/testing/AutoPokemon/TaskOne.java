package com.cognizant.elpida.testing.AutoPokemon;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TaskOne {
	
	@Test
	public void test1() throws InterruptedException {

		TestRunner.driver.get("http://ishadijcks.github.io/");
		PokemonSelection selection = PageFactory.initElements(TestRunner.driver, PokemonSelection.class);
		selection.startGame();
		
	}
}