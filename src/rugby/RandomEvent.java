package rugby;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;  

public class RandomEvent {
	public int event = 0;
	public static GameEnviroment gameEnviroment;
	
	public static int randomEvents(int randnomness, Inventory inventory) {
		int joinChance = (5 - inventory.players.size());
		
		Random rand = new Random();  
		int event = rand.nextInt(randnomness);
		
		if (event <= joinChance) {
			return(newPlayer(inventory));
		}else if (event == 7){
			return(playerLeaves(inventory));
		}else if (event == 8){
			return(playerInjured(inventory));
		}
		return 4;
	}
	
	public static int newPlayer(Inventory inventory){
		Athlete newPlayer = GameEnviroment.generatePlayer(gameEnviroment.difficulty);
		inventory.addPlayer(newPlayer);
		//System.out.println("add");
		return 1;

//		if (inventory.players.size() < 16) {
//			inventory.players.add(newPlayer);
//			System.out.println("add");
//		}else {
//			System.out.println("your team is full if u wish swap out a player, enter number of player. if not enter 0");
//			inventory.displayAthletes();
//			Scanner input = new Scanner(System.in);
//			String  userName = input.nextLine();
//			int holder2 = Integer.parseInt(userName);
//			if (holder2 != 0) {
//				Athlete swap = inventory.players.get(holder2-1);
//				inventory.removePlayer(swap);
//				inventory.addPlayer(newPlayer);
//			}
//		}
	}
	
	public static int playerLeaves(Inventory inventory){
		Athlete remove = getRandomPlayer(inventory);
		inventory.removePlayer(remove);
		return 2;
	}
	
	public static boolean playerTrained(int randnomness){
		Random rand = new Random();  
		int event = rand.nextInt(randnomness);
		if (event == 1) {
			return true;
		}
		return false;
	}
	
	public static int playerInjured(Inventory inventory){
		Athlete injur = getRandomPlayer(inventory);
		injur.injured = true;
		return 0;
	}
	
	public static Athlete getRandomPlayer(Inventory inventory) {
		ArrayList<Athlete> athletes = inventory.team.players;
		Random rand = new Random();  
		int event = rand.nextInt(athletes.size());
		return (athletes.get(event));
	}
	
	public static void main(String[] args) {
	}
	
}
