package com.cognizant.elpida.testing.Tea;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\cognizant\\elpida\\testing\\Tea\\TeaTesting.feature")
public class Runner {

}