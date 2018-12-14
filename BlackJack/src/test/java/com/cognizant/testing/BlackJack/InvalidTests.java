package com.cognizant.testing.BlackJack;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.rmi.activation.ActivationException;
import org.junit.Test;
public class InvalidTests {
	BlackJack blackjack = new BlackJack();
	@Test
	public void invalidBothLessThan2() {
		assertEquals("Invalid Tests with both numbers less than 2: ",-1,blackjack.play(0, 1));
	}
	@Test
	public void invalidBothMoreThan31() {
		assertEquals("Invalid Tests with both numbers more than 31: ",-1,blackjack.play(41, 60));
	}
	@Test
	public void invalidPlayerLessThan2() {
		assertEquals("Invalid Tests with Player number less than 2: ",-1,blackjack.play(12, 1));
		
	}
	@Test
	public void invalidDealerLessThan2() {
		assertEquals("Invalid Tests with Dealer number less than 2: ",-1,blackjack.play(1, 20));
		
	}
	@Test
	public void invalidPlayerMoreThan31() {
		assertEquals("Invalid Tests with Player number more than 31: ",-1,blackjack.play(21, 50));
		
	}
	@Test
	public void invalidDealerMoreThan31() {
		assertEquals("Invalid Tests with Dealer number more than 31: ",-1,blackjack.play(40, 20));
		
	}
}
