package rugby;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RandomEventTest {
	private static Inventory club;
	private static Team team;
	
	@BeforeAll 
	public static void init(){
		// Initialing the game 
		GameEnviroment manager = new GameEnviroment();
		club = new Inventory(manager);
		team = new Team();
		club.team = team;
	}
	
	@Test
	public void playerLeaves() {
		// player leaving random
		RandomEvent.playerLeaves(club);
		assertTrue(club.team.players.size() == 0);
	}
	
	
	@Test
	public void newPlayer() {
		// new player
		RandomEvent.newPlayer(club);
		assertTrue(club.team.players.size() > 0);
	}
	
	@Test
	public void getRandomPlayer() {
		// checking it gets a player from the team
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		club.team.addPlayer(event);
		assertTrue(RandomEvent.getRandomPlayer(club) == event);
		
				
	}

}
