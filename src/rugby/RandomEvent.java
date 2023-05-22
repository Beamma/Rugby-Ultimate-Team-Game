package rugby;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;  

/**
 * Class which generates random events
 * @author Joel Bremner & Liam Ceelan-Thomas
 *
 */
public class RandomEvent {
	public int event = 0;
	public static GameEnviroment gameEnviroment;
	
	/**
	 * Decides what random even to call, then returns the random event
	 * @param randnomness
	 * @param inventory
	 * @return - returns an int based on the random event chosen
	 */
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
	
	/**
	 * Generates a new player
	 * @param inventory
	 * @return - Option selected
	 */
	public static int newPlayer(Inventory inventory){
		Athlete newPlayer = GameEnviroment.generatePlayer(gameEnviroment.difficulty);
		inventory.addPlayer(newPlayer);
		return 1;
	}
	
	/**
	 * Removes random player from your inventory
	 * @param inventory
	 * @return - option selected
	 */
	public static int playerLeaves(Inventory inventory){
		Athlete remove = getRandomPlayer(inventory);
		inventory.removePlayer(remove);
		return 2;
	}
	
	/**
	 * Trains a random player
	 * @param randnomness
	 * @return - option selected
	 */
	public static boolean playerTrained(int randnomness){
		Random rand = new Random();  
		int event = rand.nextInt(randnomness);
		if (event == 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Injures a random player from inventory
	 * @param inventory
	 * @return - option selected
	 */
	public static int playerInjured(Inventory inventory){
		Athlete injur = getRandomPlayer(inventory);
		injur.injured = true;
		return 0;
	}
	
	/**
	 * Returns random player from inventory
	 * @param inventory
	 * @return - Athlete randomly chosen
	 */
	public static Athlete getRandomPlayer(Inventory inventory) {
		ArrayList<Athlete> athletes = inventory.team.players;
		Random rand = new Random();  
		int event = rand.nextInt(athletes.size());
		return (athletes.get(event));
	}
	
}
