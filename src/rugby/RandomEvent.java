package rugby;

import java.util.Random;  

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
	
	public static void newPlayer(){
		System.out.printf("A new player has joined your club");
	}
	
	public static void playerLeaves(){
		System.out.printf("A player has left your club");
	}
	
	public static void playerInjured(){
		System.out.printf(" A player is now injured");
	}

}
