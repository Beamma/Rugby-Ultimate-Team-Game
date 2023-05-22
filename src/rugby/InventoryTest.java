package rugby;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InventoryTest {
	private static Inventory club;
	private static GameEnviroment manager;
	private static Team team;
	
	
	
	@BeforeAll 
	public static void init(){
		manager = new GameEnviroment();
		club = new Inventory(manager);
		team = new Team();
		club.team = team;
	}
	
	@Test
	void addPlayer() {
		Athlete event = GameEnviroment.generatePlayer(2);
		club.addPlayer(event);
		assertTrue(club.team.players.size() == 1);
	}
	
	@Test
	void addPlayerFull() {
		// if reserve team is full
		Athlete event = GameEnviroment.generatePlayer(2);
		for (int i = 0; i < 36; i++ ) {
			club.addPlayer(event);
		}
		club.addPlayer(event);
		assertTrue(club.players.size() == 5);
	}
	
	@Test
	void swapPlayer() {

		// checking to see if event1 gets swapped in reserves while even2 goes into team
		Athlete event1 = GameEnviroment.generatePlayer(2);
		Athlete event2 = GameEnviroment.generatePlayer(2);
		club.swapPlayer(event1, event2);
		assertTrue(club.players.contains(event1));
		assertTrue(club.team.players.contains(event2));
		
	}
	
	@Test
	void getPlayerWages() {
		//checking that the wage gets both active and reserve members
		GameEnviroment manager = new GameEnviroment();
		Inventory club = new Inventory(manager);
		Team team = new Team();
		club.team = team;
		int wage = 0;
		
		Athlete event = GameEnviroment.generatePlayer(2);
		for (int i = 0; i < 5; i++ ) {
			club.addPlayer(event);
			wage += event.wage;
		}
		for (int i = 0; i < 15; i++ ) {
			System.out.println(i);
			club.team.addPlayer(event);
			wage += event.wage;
		}
		
		assertTrue(wage == club.getPlayerWages());
		
	}


}
