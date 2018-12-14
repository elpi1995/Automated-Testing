package com.cognizant.testing.BlackJack;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.rmi.activation.ActivationException;
import org.junit.Test;

public class BustTests {
	BlackJack blackjack = new BlackJack();
	@Test
	public void playerAndDealerBustWithEqualCards() {
		assertEquals("Bust Test where both the Player and the Dealer bust and they have equal cards: ",0,blackjack.play(22, 22));
	}
	@Test
	public void playerAndDealerBustWPlayerHigherCard() {
		assertEquals("Bust Test where both the Player and the Dealer bust and the Player has a higher card: ",0,blackjack.play(25, 30));
	}
	@Test
	public void playerAndDealerBustWDealerHigherCard() {
		assertEquals("Bust Test where both the Player and the Dealer bust and the Dealer has a higher card: ",0,blackjack.play(30, 25));
	}
	
	@Test
	public void playerBust() {
		assertEquals("Bust Test where Player busts: ",0,blackjack.play(30, 20));
	}
	@Test
	public void dealerBust() {
		assertEquals("Bust Test where Dealer busts: ",0,blackjack.play(20, 30));
	}
}
