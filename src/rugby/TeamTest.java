package rugby;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TeamTest {
	private static Inventory club;
	private static GameEnviroment manager;
	private static Team team;
	private static Athlete athlete;
	
	
	@BeforeAll
	public static void init(){
		manager = new GameEnviroment();
		club = new Inventory(manager);
		team = new Team();
		club.team = team;
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		athlete = event;
		for (int i = 0; i < 7; i++) {
			club.team.addPlayer(event);
		}
	}
	
	@Test
	public void reduceStamina() {
		//reduce stamina
		club.team.reduceStamina();
		for (int i = 0; i < 7; i++) {
			assertTrue(club.team.players.get(i).getStamina() < 100);
		}
	}
	
	@Test
	public void maxStamina() {
		//max stamina
		club.team.reduceStamina();
		club.team.maxStamina();
		for (int i = 0; i < 7; i++) {
			assertTrue(club.team.players.get(0).getStamina() == 100);
		}
	}
	
	@Test
	public void checkReady() {
		//check ready
		club.team.players.get(0).injury();
		assertFalse(club.team.checkReady());
	}
	
	@Test
	public void teamRating() {
		//get rating
		assertTrue(club.team.teamRating(club.team) == 10);	
	}
	
	@Test
	public void getTeamName() {
		//get name test
		club.team.setTeamName("test");
		assertTrue(club.team.getTeamName() == "test");
	}
	
	@Test
	public void setTeamName() {
		//set name test
		club.team.setTeamName("test");
		assertTrue(club.team.getTeamName() == "test");	
	}
	
	@Test
	public void emovePlayer() {
		//remiove player test
		club.team.players.clear();
		club.team.addPlayer(athlete);
		club.team.removePlayer(athlete);
		
		assertFalse(club.team.players.contains(athlete));
		
	}


}
