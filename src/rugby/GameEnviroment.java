package rugby;

import java.util.ArrayList;
import java.util.HashMap;

public class GameEnviroment {
	private int money = 0;
	public String teamName;
	public int difficulty = 2;
	public int week = 0;
	private ArrayList<Team> bracket;
	private HashMap<String, Integer> standings;
	public Inventory club = new Inventory();
	
	public boolean moneyTransfer(int amount) {
		if ((this.money += amount) < 0) {
			return false;
		} else {
			this.money += amount;
			return true;
		}
	}
	
	private void updateWeek() {
		if (moneyTransfer(club.getPlayerWages()*-1)) {
			this.week += 1;
			int randomness = (20 - (3*this.difficulty));
			RandomEvent.randomEvents(randomness);
		} else {
			System.out.println("Sorry you do not have enough money to pay this weeks wages please remove some players from your club");
		}
	}
	
	public static Athlete generatePlayer() {
		
		/* Code Here */
		
		return athlete;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
