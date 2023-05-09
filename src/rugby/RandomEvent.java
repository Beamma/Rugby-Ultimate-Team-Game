package rugby;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;  

public class RandomEvent {
	public int event = 0;
	
	public static void randomEvents(int randnomness) {
		
		Random rand = new Random();  
		int event = rand.nextInt(randnomness);
		
		if (event == 1) {
			newPlayer();
		}else if (event == 2){
			playerLeaves();
		}else if (event == 3){
			playerInjured();
		}
	}
	
	public static void newPlayer(Inventory inventory){
		Athlete holder = GameEnviroment.generatePlayer();
		if (inventory.players.size() < 1) {
			inventory.players.add(holder);
			System.out.println("add");
		}else {
			System.out.println("your team is full if u wish swap out a player, enter number of player. if not enter 0");
			inventory.displayAthletes();
			Scanner input = new Scanner(System.in);
			String  userName = input.nextLine();
			int holder2 = Integer.parseInt(userName);
			if (holder2 != 0) {
				Athlete swap = inventory.players.get(holder2-1);
				inventory.removePlayer(swap);
				inventory.addPlayer(holder);
			}
		}
	}
	
	public static void playerLeaves(Inventory inventory){
		Athlete remove = getRandomPlayer(inventory);
		inventory.removePlayer(remove);
	}
	
	public static void playerInjured(Inventory inventory){
		Athlete injur = getRandomPlayer(inventory);
		injur.injured = true;
	}
	
	public static Athlete getRandomPlayer(Inventory inventory) {
		ArrayList<Athlete> athletes = inventory.players;
		Random rand = new Random();  
		int event = rand.nextInt(athletes.size());
		return (athletes.get(event));
	}
	
	public static void main(String[] args) {
		Athlete ed = GameEnviroment.generatePlayer();
		Athlete eds = GameEnviroment.generatePlayer();
		Inventory hrfc =  new Inventory();
		hrfc.addPlayer(ed);
		hrfc.addPlayer(eds);
		hrfc.displayAthletes();
		playerLeaves(hrfc);
		newPlayer(hrfc);
		hrfc.displayAthletes();
	}
	
}
