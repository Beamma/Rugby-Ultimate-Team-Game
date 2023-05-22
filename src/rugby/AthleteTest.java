package rugby;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public final class AthleteTest {

	@Test
	public void rarityTest() {
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		Item fitness = new Item("Fitness Train", 500, new int[]{10, 10, 10, 10, 10, 10});
		
		// when using a item the rarity of the player correctly changes
		
		assertTrue(event.rarity == 10);
		
		fitness.useItem(event, fitness);
		
		event.updateRating();
		
		assertTrue(event.rarity == 20);

		
	}	
	
	@Test
	void fitnessTest() {
	}	
	
	@Test
	public void statOverHundred() {
		
		// making sure that a player can never have a pregenerated stat over 100 
		
		for (int i = 0; i < 99; i++) {
			Athlete event = GameEnviroment.generatePlayer(2);
			for (int p = 0; p < 6; p++) {
				assertTrue(event.stats.get(event.attributes[p]) < 100);
			}
		}
	}
	
	
	@Test
	public void trainAthleteTest() {
		
		//checking if it trains all athletes by one and update rating works
		Athlete event = new Athlete("", 10, 10, 10, false, "", 10, new int[]{10, 10, 10, 10, 10, 10});
		Athlete constantEvent = new Athlete("", 10, 10, 10, false, "", 10, new int[]{10, 10, 10, 10, 10, 10});
		int startingRating = event.rarity;
		
		event.trainAll();
		event.updateRating();
		
		// checking if all attributes have been increased by one
		for (int i = 0; i < 6; i ++) {
			assertTrue(event.stats.get(event.attributes[i]) - constantEvent.stats.get(constantEvent.attributes[i]) == 1);
		}
		
		// checking if rating incresed 
		assertTrue(event.rarity > startingRating);
		
	}
	
	
	

}
