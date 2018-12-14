package com.cognizant.testing.BlackJack;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.rmi.activation.ActivationException;
import org.junit.Test;

public class NonBustTests {
	BlackJack blackjack = new BlackJack();
	@Test
	public void playerWin() {
		assertEquals("Non Bust Test where the Player wins: ",20,blackjack.play(15, 20));
	}
	@Test
	public void DealerWinsWEqualCards() {
		assertEquals("Non Bust Test where the Dealer wins with an equal card: ",21,blackjack.play(21, 21));
	}
	@Test
	public void DealerWinsWHigherCards() {
		assertEquals("Non Bust Test where the Dealer wins with higher cards: ",18,blackjack.play(18, 15));
	}
}
