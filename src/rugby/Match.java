package rugby;

import java.util.ArrayList;
import java.util.Collection;

public class Match {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tester = new int[]{1, 2, 345, 54, 65, 40};
		int[] tester2 = new int[]{7, 5, 367, 54, 63, 41};
		int[] tester3 = new int[]{5, 6, 315, 59, 45, 10};
		int[] tester4 = new int[]{0, 0, 38, 5, 5, 2};
		Athlete joel = new Athlete("Joel", 10, 10, 10, false, "rb", 90, tester);
		joel.changeNickName("Joel");
		Athlete liam = new Athlete("Liam", 10, 10, 10, false, "rb", 90, tester2);
		liam.changeNickName("Liam");
		Athlete jack = new Athlete("Jack", 10, 10, 10, false, "rb", 90, tester3);
		joel.changeNickName("Joel");
		Athlete bob = new Athlete("Bob", 10, 10, 10, false, "rb", 90, tester4);
		liam.changeNickName("Liam");
		
		Match game =  new Match();
		
		Team hrfc = new Team();
		Team srfc = new Team();
		
		hrfc.addPlayer(liam);
		hrfc.addPlayer(joel);
		
		srfc.addPlayer(bob);
		srfc.addPlayer(jack);
		
		game.matchResult(hrfc, srfc);
		game.matchResult(hrfc, srfc);
		game.matchResult(hrfc, srfc);

	}
	
	public static int matchResult(Team team1, Team team2) {
		
		if (team1.checkReady()) {
			ArrayList<Athlete> roster1 = team1.getAthletes();
			ArrayList<Athlete> roster2 = team2.getAthletes();
			int totalScore = 0;
			for (int i = 0; i < roster1.size(); i++) {
				Match game =  new Match();
				totalScore += game.compareStats(roster1.get(i), roster2.get(i));
			}
			

			
			if (totalScore > 0) {
				System.out.printf("Your team won by %s\n", totalScore);
				return totalScore;
			}
			else if (totalScore < 0) {
				System.out.printf("Your team lost by %s\n", totalScore * -1);
				return totalScore;
			} else{
				System.out.printf("You drew\n");
				return 0;
			}
		} else {
			return -2;
		}
	}
	
	private int compareStats(Athlete athlete1, Athlete athlete2) {
		Collection<Integer> athlete1Stats = athlete1.stats.values();
		ArrayList<Integer> values1 = new ArrayList<Integer>(athlete1Stats);
		Collection<Integer> athlete2Stats = athlete2.stats.values();
		ArrayList<Integer> values2 = new ArrayList<Integer>(athlete2Stats);
		
		int score = 0;
		
		for (int i = 0; i < values1.size(); i++) {
			if (values1.get(i) > values2.get(i)) {
				score += 1;
			}
			else if(values1.get(i) < values2.get(i)){
				score -= 1;
			}
			
		}
		
		
		if (score > 0) {
			System.out.printf("Your athlete %s beat the opposition athlete %s by %s\n", athlete1.name, athlete2.name, score);
			return 1;
		}
		else if (score < 0) {
			System.out.printf("Your athlete %s lost to the opposition athlete %s by %s\n", athlete1.name, athlete2.name, score * -1);
			return -1;
		} else{
			System.out.printf("Your athlete %s drew with the opposition athlete %s\n", athlete1.name, athlete2.name);
			return 0;
		}
		
	}

}
