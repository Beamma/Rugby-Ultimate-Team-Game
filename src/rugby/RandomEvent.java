package rugby;

import java.util.Random;  

public class RandomEvent {
	
	public int event = 0;
	
	public void randomEvents() {
		
		Random rand = new Random();  
		int event = rand.nextInt(3);
		
		if (event == 0) {
			newPlayer();
		}else if (event == 1){
			playerLeaves();
		}else {
			playerInjured();
		}
	}
	
	public void newPlayer(){
		System.out.printf(" Is now injured due to lack of stamina");
	}
	
	public void playerLeaves(){
		System.out.printf(" Is now in");
	}
	
	public void playerInjured(){
		System.out.printf(" Is now injured due ");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomEvent liam = new RandomEvent();
		liam.randomEvents();
	}

}
