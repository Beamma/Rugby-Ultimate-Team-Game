package rugby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import gui.HomeScreen;
import gui.MainScreen;
import gui.SetupScreen;  

public class GameEnviroment {
	public int money = 1000;
	public String teamName;
	public int difficulty = 2;
	public int week = 0;
	private ArrayList<Team> bracket;
	private HashMap<String, Integer> standings;
	private Inventory club;
	
	
	public GameEnviroment() {
		
	}
	
	private void updateWeek() {
		if (moneyTransfer(club.getPlayerWages()*-1)) {
			this.week += 1;
			int randomness = (20 - (3*this.difficulty));
			System.out.println(this.week);
//			RandomEvent.randomEvents(randomness);
		} else {
			System.out.println("Sorry you do not have enough money to pay this weeks wages please remove some players from your club");
		}
	}
	
	public boolean moneyTransfer(int amount){
		if ((this.money += amount) < 0) {
			this.money -= amount;
			return false;
		} else {
			return true;
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
	
	public static Team generateTeam(int diffuculty){
	    Team opisiton = new Team();
	    for (int i = 0; i < 15; i++){
	        Athlete random = GameEnviroment.generatePlayer();
	        opisiton.addPlayer(random);
	    }
	    return opisiton;
	}
	
	public void launchHomeScreen() {
		HomeScreen mainWindow = new HomeScreen(this);
	}
	
	public void closeMainScreen(HomeScreen mainWindow) {
		mainWindow.closeWindow();
	}
	
	public void launchSetupScreen() {
		SetupScreen setupWindow = new SetupScreen(this);
	}
	
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
	}
	
	
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		GameEnviroment manager = new GameEnviroment();
//		manager.launchSetupScreen();
		/* 
		 * 
		 * 
		 */
		GameEnviroment game = new GameEnviroment();
		Inventory club = new Inventory(game);
		game.club = club;
		MarketPlace market = new MarketPlace(game, club);
		Team team = new Team();
		club.team = team;
		
		Athlete ed = generatePlayer();
		market.buyObject(ed);
		System.out.println(game.money);
		game.updateWeek();
		System.out.println(game.money);
//		club.returnInventory();
		market.listBuyables();
		
		
		
	}

}
