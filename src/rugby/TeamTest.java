package rugby;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TeamTest {
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
	public void reduceStamina() {
		Athlete newPlayer = GameEnviroment.generatePlayer();
		club.team.addPlayer(newPlayer);
		club.team.reduceStamina();
		assertTrue(club.team.players.get(0).stamina < 100);
	}
	
	@Test
	public void maxStamina() {
		Athlete newPlayer = GameEnviroment.generatePlayer();
		club.team.addPlayer(newPlayer);
		club.team.reduceStamina();
		club.team.maxStamina();
		
		assertTrue(club.team.players.get(0).stamina == 100);
	}

	
	@Test
	public void checkReady() {
		fail("Not yet implemented");
	}
	
	@Test
	public void teamRating() {
		fail("Not yet implemented");
	}


}
