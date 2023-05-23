package rugby;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InventoryTest {
	private static Inventory club;
	private static GameEnviroment manager;
	private static Team team;
	private static Athlete athlete;
	
	
	@BeforeAll 
	public static void init(){
		//Initiating the game 
		manager = new GameEnviroment();
		club = new Inventory(manager);
		team = new Team();
		club.team = team;
		// making team full
		Athlete event = GameEnviroment.generatePlayer(2);
		for (int i = 0; i < 7; i++ ) {
			club.addPlayer(event);
		}
		//storing a athlete to swap
		athlete = event;
	}
	
	@Test
	void addPlayer() {
		//adding player to reserve team then checking it goes up by one
		Athlete event = GameEnviroment.generatePlayer(2);
		//clearing all previous players
		club.players.clear();
		club.addPlayer(event);
		assertTrue(club.players.size() == 1);
	}
	

	
	@Test
	void swapPlayer() {

		// checking to see if event1 gets swapped in reserves while even2 goes into team
		Athlete event1 = GameEnviroment.generatePlayer(2);
		club.swapPlayer(athlete, event1);
		assertTrue(club.players.contains(athlete));
		assertTrue(club.team.players.contains(event1));
		
	}
	
	@Test
	void getPlayerWages() {
		
		//checking that the wage gets both active and reserve members
		int wage = 0;
		club.players.clear();
		club.team.players.clear();
		Athlete event = GameEnviroment.generatePlayer(2);
		for (int i = 0; i < 12; i++ ) {
			club.addPlayer(event);
			wage += event.getWage();
		}
		
		assertTrue(wage == club.getPlayerWages());
		
	}


}
