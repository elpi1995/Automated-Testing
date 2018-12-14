package com.cognizant.elpida.testing.AutoPokemon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PokemonSelection {
	@FindBy(id = "Charmander")
	private WebElement pokemon;
	
	@FindBy(id = "startAdventure")
	private WebElement adventure;
	
	
	public void startGame() {
		pokemon.click();
		adventure.click();
	}
}
