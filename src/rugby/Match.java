package rugby;

import java.util.ArrayList;
import java.util.Collection;

public class Match {

	public static void main(String[] args) {
	}
	
	public static int matchResult(Team team1, Team team2, Inventory inventory) {
		
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
			System.out.println(flag);
			int totalScore = 0;
			for (int i = 0; i < roster1.size(); i++) {
				Match game =  new Match();
				totalScore += game.compareStats(roster1.get(i), roster2.get(i), flag);
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
	
	private int compareStats(Athlete athlete1, Athlete athlete2, boolean flag) {
		Collection<Integer> athlete1Stats = athlete1.stats.values();
		ArrayList<Integer> values1 = new ArrayList<Integer>(athlete1Stats);
		Collection<Integer> athlete2Stats = athlete2.stats.values();
		ArrayList<Integer> values2 = new ArrayList<Integer>(athlete2Stats);
		
		int score = 0;
		
		for (int i = 0; i < values1.size(); i++) {
			if (flag) {
				if (values1.get(i) + 5 > values2.get(i)) {
					score += 1;
					System.out.println("Boost");
				}
				else if(values1.get(i) + 5 < values2.get(i)){
					score -= 1;
					System.out.println("Boost");
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
//			System.out.printf("Your athlete %s beat the opposition athlete %s by %s\n", athlete1.name, athlete2.name, score);
			return 1;
		}
		else if (score < 0) {
//			System.out.printf("Your athlete %s lost to the opposition athlete %s by %s\n", athlete1.name, athlete2.name, score * -1);
			return -1;
		} else{
//			System.out.printf("Your athlete %s drew with the opposition athlete %s\n", athlete1.name, athlete2.name);
			return 0;
		}
		
	}

}
