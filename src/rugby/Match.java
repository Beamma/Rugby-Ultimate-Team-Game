package rugby;

import java.util.ArrayList;
import java.util.Collection;

import gui.GameScreen;
/**
 * Class for matches, where matches are simulated and a result is produced
 * @author Joel Bremner & Liam Ceelan-Thomas
 *
 */
public class Match {
	

	/**
	 * Constructor
	 * @param team1
	 * @param team2
	 * @param inventory
	 * @param gameScreen
	 * @return
	 */
	public static void main(String[] args) {
		GameEnviroment manager = new GameEnviroment();
		Inventory club = new Inventory(manager);
		manager.club = club;
		Team myTeam = new Team();
		club.team = myTeam;
		GameScreen gameScreen = new GameScreen(manager, myTeam);
		
		Athlete athlete1 = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{20, 20, 20, 20, 20, 20});
		for (int i =0 ; i <15; i++) {
			myTeam.addPlayer(athlete1);
		}
		Athlete athlete2 = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{11, 11, 11, 11, 11, 11});
		Team opposition = new Team();
		for (int i =0 ; i <15; i++) {
			opposition.addPlayer(athlete2);
		}
		
	
		System.out.println(Match.matchResult(myTeam, opposition, club, gameScreen));
	}
	
	/**
	 * Returns match result between two teams
	 * @param team1
	 * @param team2
	 * @param inventory
	 * @param gameScreen
	 * @return
	 */
	public static int matchResult(Team team1, Team team2, Inventory inventory, GameScreen gameScreen) {
		
		if (team1.checkReady()) {
			inventory.boostStamina();
			ArrayList<Athlete> roster1 = team1.getAthletes();
			ArrayList<Athlete> roster2 = team2.getAthletes();
			
			ArrayList<String> positions = new ArrayList<>();
			boolean flag = true;
			for (Athlete athlete : roster1) {
				if (positions.contains(athlete.getPosition())){
					flag = false;
				}
				positions.add(athlete.getPosition());
			}
			int totalScore = 0;
			for (int i = 0; i < roster1.size(); i++) {
				Match game =  new Match();
				totalScore += game.compareStats(roster1.get(i), roster2.get(i), flag, gameScreen);
			}
			

			
			if (totalScore > 0) {
				return totalScore;
			}
			else if (totalScore < 0) {
				return totalScore;
			} else{
				return 0;
			}
		} else {
			return -2;
		}
	}
	
	/**
	 * Comapares stats of two athletes and returns a winner
	 * @param athlete1
	 * @param athlete2
	 * @param flag
	 * @param gameScreen
	 * @return
	 */
	private int compareStats(Athlete athlete1, Athlete athlete2, boolean flag, GameScreen gameScreen) {
		Collection<Integer> athlete1Stats = athlete1.stats.values();
		ArrayList<Integer> values1 = new ArrayList<Integer>(athlete1Stats);
		Collection<Integer> athlete2Stats = athlete2.stats.values();
		ArrayList<Integer> values2 = new ArrayList<Integer>(athlete2Stats);
		
		int score = 0;
		
		for (int i = 0; i < values1.size(); i++) {
			if (flag) {
				if (values1.get(i) + 5 > values2.get(i)) {
					score += 1;
				}
				else if(values1.get(i) + 5 < values2.get(i)){
					score -= 1;
				}
			}
			else {
				if (values1.get(i) > values2.get(i)) {
					score += 1;
				}
				else if(values1.get(i) < values2.get(i)){
					score -= 1;
				}
			}
			
		}
		
		
		if (score > 0) {
			gameScreen.gameUpdates(String.format("Your athlete %s beat the opposition athlete %s by %s\n", athlete1.getName(), athlete2.getName(), score));
			return 1;
		}
		else if (score < 0) {
			gameScreen.gameUpdates(String.format("Your athlete %s lost to the opposition athlete %s by %s\n", athlete1.getName(), athlete2.getName(), score * -1));
			return -1;
		} else{
			gameScreen.gameUpdates(String.format("Your athlete %s drew with the opposition athlete %s\n", athlete1.getName(), athlete2.getName()));
			return 0;
		}
		
	}

}
