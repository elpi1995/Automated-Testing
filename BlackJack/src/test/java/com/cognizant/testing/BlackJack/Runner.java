package com.cognizant.testing.BlackJack;




import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner {
	public static void main(String[] args) {
		Runner runner = new Runner();
		//runner.allSuites();
		runner.selectSuites(1);
		//take an input: if its: 1-> run all suites; 2-> run valid Suites; 3-> run busted invalid Suites
		
	}
	public void allSuites() {
		Result result = new JUnitCore().runClasses(ValidSuite.class,NonValidAndBust.class);
		if(!result.wasSuccessful()) {
			for(Failure failure: result.getFailures()) {
				System.out.println(failure.getMessage());
			}
		}
	}
	public void selectSuites(int number) {
		if(number==1) {
			Result result = new JUnitCore().runClasses(ValidSuite.class,NonValidAndBust.class);
			if(!result.wasSuccessful()) {
				for(Failure failure: result.getFailures()) {
					System.out.println(failure.getMessage());
				}
			}
			
		}
		else if(number ==2) {
			Result result = new JUnitCore().runClasses(ValidSuite.class);
			if(!result.wasSuccessful()) {
				for(Failure failure: result.getFailures()) {
					System.out.println(failure.getMessage());
				}
			}
			
		}
		else if(number ==3) {
			Result result = new JUnitCore().runClasses(NonValidAndBust.class);
			if(!result.wasSuccessful()) {
				for(Failure failure: result.getFailures()) {
					System.out.println(failure.getMessage());
				}
			}
			
		}
		
	}
}
