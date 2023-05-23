package rugby;

import java.util.ArrayList;
import java.util.Random;

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
		Athlete newPlayer = GameEnviroment.generatePlayer(gameEnviroment.getDifficulty());
		inventory.addPlayer(newPlayer);
		return 1;
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
		injur.injury();
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
