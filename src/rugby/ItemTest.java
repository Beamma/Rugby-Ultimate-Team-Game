package rugby;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class ItemTest {
	
	@Test
	void useItem() {
		GameEnviroment manager = new GameEnviroment();
		Inventory club = new Inventory(manager);
		manager.club = club;
		Team team = new Team();
		club.team = team;
		Athlete event1 = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		Athlete constantevent1 = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		Item event2 = new Item("Fitness Train", 500, new int[]{10, 10, 10, 10, 10, 10});
		
		// when using a item the rarity of the player correctly changes
		
		event2.useItem(event1, event2);
		
		for (int p = 0; p < 6; p++) {
			assertTrue(event1.stats.get(event1.attributes[p]) == constantevent1.stats.get(constantevent1.attributes[p]) + event2.stats.get(event2.attributes[p]));
		}
	}
	
	@Test
	void getName() {
		//get name test
		Item event = new Item("event", 500, new int[]{10, 10, 10, 10, 10, 10});
		assertTrue(event.getName() == "event");
	}
	
	@Test
	void getSellPrice() {
		//get sell price test
		Item event = new Item("event", 500, new int[]{10, 10, 10, 10, 10, 10});
		assertTrue(event.getSellPrice() == 400);
	}
	
	@Test
	void getPrice() {
		//get price test
		Item event = new Item("event", 500, new int[]{10, 10, 10, 10, 10, 10});
		assertTrue(event.getPrice() == 500);
	}

}
