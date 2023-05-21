package rugby;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomEventTest {
	private static Inventory club;
	
	@BeforeAll 
	public static void init(){
		GameEnviroment manager = new GameEnviroment();
		club = new Inventory(manager);
	}
	
	@Test
	public void playerLeaves() {
		// player leaving random
		Athlete event = new Athlete("", 10, 10, 10, false, "", 10, new int[]{10, 10, 10, 10, 10, 10});
		club.addPlayer(event);
		
		RandomEvent.playerLeaves(club);
		
		assertTrue(club.players.size() == 1);
	}
	
	@Test
	public void playerTrained() {
		// player trained random
		fail("Not yet implemented");
	}
	
	@Test
	public void newPlayer() {
		// new player
		RandomEvent.newPlayer(club);
		assertTrue(club.players.size() > 0);
	}
	
	@Test
	public void randomEvents() {
		fail("Not yet implemented");
	}

}
