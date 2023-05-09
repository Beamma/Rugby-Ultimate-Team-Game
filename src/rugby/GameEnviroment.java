package rugby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;  

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
		
		int[] tester = new int[]{0, 0, 0, 0, 0, 0};
		Random r = new Random();
		int low = 50;
		int high = 100;
		int result = r.nextInt(high-low) + low;
		int rarity = 0;
		
		for (int i = 0; i < 6; i++) {
			int holder = r.nextInt((result+10)-(result-10)) + (result-10);
			if (holder > 99) {
				tester[i] = 99;
				rarity += 99;
			}else {
			tester[i] = holder;
			rarity += holder;
			}
		}
	   
		String[] nameGenerator = new String[] {"bob", "tim", "joel", "liam"};
		String name = nameGenerator[r.nextInt(3)];
		String position = "cb";
		int buyPrice = (rarity/6)*20;
		int sellPrice = (rarity/6)*15;
		int wage = (rarity/6)*8;
		
		return(new Athlete(name, wage, sellPrice, buyPrice, false, position, rarity/6, tester));
	}
	
	public static Item generateItem() {
		
		int[] tester = new int[]{0, 0, 0, 0, 0, 0};
		Random r = new Random();
		int low = 1;
		int high = 10;
		int result = r.nextInt(high-low) + low;
		
		for (int i = 0; i < 6; i++) {
			int holder = r.nextInt((result+2)-(result-2)) + (result-2);
			if (holder > 10) {
				tester[i] = 10;
			}else if (holder < 0) {
				tester[i] = 0;
			}else{
				tester[i] = holder;
			}
		}
	   
		String[] itemGenerator = new String[] {"water", "poweraid", "joel", "liam"};
		String item = itemGenerator[r.nextInt(4)];
		int price = 100;
		
		return(new Item(item, price, tester));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Athlete ed = generatePlayer();
		Item wads = generateItem();
		System.out.println(wads.stats);
	}

}
