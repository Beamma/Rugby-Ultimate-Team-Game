package rugby;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import gui.GameScreen;

class MatchTest {
	private static Inventory club;
	private static GameEnviroment manager;
	private static GameScreen gameScreen;
	private static Team myTeam;
	 
	
	@BeforeAll 
	public static void init(){
		//Initiating the game 
		manager = new GameEnviroment();
		club = new Inventory(manager);
		manager.club = club;
		myTeam = new Team();
		club.team = myTeam;
		gameScreen = new GameScreen(manager, myTeam);
	}
	
	@Test
	void matchResultWin() {
		// if match is a win
		myTeam.players.clear();
		Athlete athlete1 = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{20, 20, 20, 20, 20, 20});
		for (int i =0 ; i <15; i++) {
			myTeam.addPlayer(athlete1);
		}

		Athlete athlete2 = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{11, 11, 11, 11, 11, 11});
		Team opposition = new Team();
		for (int i =0 ; i <15; i++) {
			opposition.addPlayer(athlete2);
		}
		
		assertTrue(Match.matchResult(myTeam, opposition, club, gameScreen) == 7);
	}
	
	@Test
	void matchResultLoss() {
		// if match is a loss
		Athlete athlete1 = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		for (int i =0 ; i <15; i++) {
			myTeam.addPlayer(athlete1);
		}
		Athlete athlete2 = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{11, 11, 11, 11, 11, 11});
		Team opposition = new Team();
		for (int i =0 ; i <15; i++) {
			opposition.addPlayer(athlete2);
		}
		
		assertTrue(Match.matchResult(myTeam, opposition, club, gameScreen) == -7);
	}
	
	@Test
	void matchResultDraw() {
		// if match is a draw
		myTeam.players.clear();
		Athlete athlete1 = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		for (int i =0 ; i <15; i++) {
			myTeam.addPlayer(athlete1);
		}
		Athlete athlete2 = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		Team opposition = new Team();
		for (int i =0 ; i <15; i++) {
			opposition.addPlayer(athlete2);
		}
		
		assertTrue(Match.matchResult(myTeam, opposition, club, gameScreen) == 0);
	}
}
