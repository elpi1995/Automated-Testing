package com.cognizant.elpida.testing.AutoPokemon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class enemyClick {
	@FindBy(id = "enemyInfo")
	private WebElement enemy;
	
	@FindBy(id = "currentRoute")
	private WebElement route;
	
	public void startGame() {
		
		while(route.getText().equals("Route 1 \r\n 10/10")) {
			enemy.click();
		}
	}
}
