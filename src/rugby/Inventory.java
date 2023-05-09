package rugby;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
	
	public ArrayList<Athlete> players = new ArrayList<Athlete>();
	private ArrayList<Item> items = new ArrayList<Item>();
	public Team team = new Team();
	
	public void addPlayer(Athlete athlete) {
		players.add(athlete);
	}
	
	public void removePlayer(Athlete athlete) {
		if (this.players.contains(athlete)) {
			this.players.remove(athlete);
		} else {
			System.out.println("The athlete you've chosen is not currently in your club");
		}
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		if (this.items.contains(item)) {
			this.items.remove(item);
		} else {
			System.out.println("The item you've chosen is not currently in your inventory");
		}
	}
	
	public void swapPlayer(Team team) {
		Athlete athlete1 = selectAthlete();
		Athlete athlete2 = selectAthlete();
		if (athlete1 == athlete2) {
			System.out.println("You have chosen the same player twice, please select two different players");
		} else {
			team.swapPlayer(athlete1, athlete2);
			System.out.println("Swap completed your new team is:");
			team.printTeamInfo();
		}
	}
	
	public void useItem(){
		Item item = selectItem();
		Athlete athlete = selectAthlete();
		
		if (this.items.contains(item)) {
			items.remove(item);
			item.useItem(athlete);
		} else {
			System.out.println("You do not own this item");
		}
	}
	
	public Item selectItem() {
		int count = 0;
		for (Item item: this.items) {
			count += 1;
			System.out.printf(String.valueOf(count) + ": " + item.item);
			System.out.println();
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please Select One Of The Above Items To Use:");
		int itemIndex = input.nextInt();
		return this.items.get(itemIndex-1);
	}
	
	public Athlete selectAthlete() {
		
		int count = 0;
		for (Athlete athlete: this.players) {
			count += 1;
			System.out.printf(String.valueOf(count) + ": " + athlete.nickName);
			System.out.println();
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please Select One Of The Above Players:");
		int athlete = input.nextInt();
		return this.players.get(athlete-1);
		
	}
	
	public int getPlayerWages(){
		int weeklyWage = 0;
		for (Athlete player : players) {
			weeklyWage += player.wage;
		}
		return weeklyWage;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
