package rugby;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		for (int i = 0; i < 7; i++) {
			club.team.addPlayer(event);
		}
	}
	
	@Test
	public void reduceStamina() {
		club.team.reduceStamina();
		for (int i = 0; i < 7; i++) {
			assertTrue(club.team.players.get(i).stamina < 100);
		}
	}
	
	@Test
	public void maxStamina() {
		club.team.reduceStamina();
		club.team.maxStamina();
		for (int i = 0; i < 7; i++) {
			assertTrue(club.team.players.get(0).stamina == 100);
		}
	}
	
	@Test
	public void checkReady() {
		club.team.players.get(0).injury();
		assertFalse(club.team.checkReady());
	}
	
	@Test
	public void teamRating() {
		assertTrue(club.team.teamRating(club.team) == 10);	
	}

}
