package rugby;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
	
	public ArrayList<Athlete> players = new ArrayList<Athlete>();
	public ArrayList<Item> items = new ArrayList<Item>();
	public Team team;
	private GameEnviroment game;
	
	public Inventory(GameEnviroment game) {
		this.game = game;
	}
	
	public ArrayList<Athlete> getAllAthletes(){
		return this.players;
	}
	
//	public void addPlayer(Athlete athlete) {
//		if (players.size() < 5) {
//			players.add(athlete);
//		}
//	}
	
	public void addPlayer(Athlete athlete) {
		if (team.addPlayer(athlete)) {
		} else {
			players.add(athlete);
		} 
	}
	public void removePlayer(Athlete athlete) {
		if (players.contains(athlete)) {
			players.remove(athlete);
		} 
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		if (this.items.contains(item)) {
			this.items.remove(item);
		} else {
//			System.out.println("The item you've chosen is not currently in your inventory");
		}
	}
	
	public void swapPlayer(Athlete athlete1, Athlete athlete2) {
		this.addPlayer(athlete1);
		this.team.removePlayer(athlete1);
		this.removePlayer(athlete2);
		this.team.addPlayer(athlete2);
	}
	
	public ArrayList<Athlete> getPlayers(){
		return players;
	}
	
	public ArrayList<Item> getItems(){
		return this.items;
	}
	
//	public void useItem(){
//		Item item = selectItem();
//		Athlete athlete = selectAthlete();
//		
//		if (this.items.contains(item)) {
//			items.remove(item);
//			item.useItem(athlete);
//		} else {
//			System.out.println("You do not own this item");
//		}
//	}
	
//	public Item selectItem() {
//		int count = 0;
//		for (Item item: this.items) {
//			count += 1;
//			System.out.printf(String.valueOf(count) + ": " + item.item);
//			System.out.println();
//		}
//		
//		Scanner input = new Scanner(System.in);
//		System.out.println("Please Select One Of The Above Items To Use:");
//		int itemIndex = input.nextInt();
//		return this.items.get(itemIndex-1);
//	}
	
//	public Athlete selectAthlete() {
//		
//		int count = 0;
//		for (Athlete athlete: this.players) {
//			count += 1;
//			System.out.printf(String.valueOf(count) + ": " + athlete.name);
//			System.out.println();
//		}
//		
//		Scanner input = new Scanner(System.in);
//		System.out.println("Please Select One Of The Above Players:");
//		int athlete = input.nextInt();
//		return this.players.get(athlete-1);
//		
//	}
	
//	public void displayAthletes() {
//		for (Athlete player : players) {
//			System.out.println(player.name);
//		}
//	}
	
	public int getPlayerWages(){
		int weeklyWage = 0;
		if (this.team.players.size() <= 0) {
			return 0;
		}
		for (Athlete player : this.team.players) {
			weeklyWage += player.wage;
		}
		for (Athlete player : this.players) {
			weeklyWage += player.wage;
		}
		return weeklyWage;
	}
	
	public void boostStamina() {
		for (Athlete athlete : this.players) {
			athlete.rest();
		}
	}
	
//	public void returnInventory() {
//		Scanner input = new Scanner(System.in);
//		System.out.println("Would you like to view 1:Players or 2:Items or 3:Team Roster: ");
//		int option = input.nextInt();
//		if (option == 1) {
//			Athlete player = selectAthlete();
//			player.athleteOptions();
//		}
//		
//		else if (option == 2){
//			Item item = selectItem();
//			item.itemOptions();
//		}
//		
//		else if (option == 3){
//			Athlete player = team.selectAthlete();
//			player.athleteOptions();
//		} else {
//			System.out.println("Invalid option selected please try again");
//			this.returnInventory();
//		}
//	}
	
	public static void main(String[] args) {
//		GameEnviroment manager = new GameEnviroment();
//		Inventory club = new Inventory(manager);
//		Team team = new Team();
//		club.team = team;
//		int wage = 0;
//		
//		Athlete event = GameEnviroment.generatePlayer();
//		for (int i = 0; i < 5; i++ ) {
//			club.addPlayer(event);
//			wage += event.wage;
//		}
//		for (int i = 0; i < 15; i++ ) {
//			System.out.println(i);
//			club.team.addPlayer(event);
//			wage += event.wage;
//		}
//		
//		System.out.println(club.getPlayerWages());
//		System.out.println(wage );
		
	}

}
