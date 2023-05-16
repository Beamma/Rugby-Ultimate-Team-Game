package rugby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import gui.HomeScreen;
import gui.MainScreen;
import gui.SetupScreen;  

public class GameEnviroment {
	public int money = 10000;
	public String teamName;
	public int difficulty = 2;
	public int week = 1;
	public ArrayList<Team> oposition;
	private HashMap<String, Integer> standings;
	public Inventory club;
	private int seasonLength;
	public int[] winloss = new int[]{0,0,0};
	
	public void setSeasonLength(int value) {
		this.seasonLength = value;
	}
	
	public void setdifficulty(String value) {
		Integer.valueOf(value);
		this.difficulty = Integer.valueOf(value);
		System.out.println(this.difficulty);
	}
	
	public void setName(String name){
		this.teamName = name;
		System.out.println(this.teamName);
	}
	
	public void updateWeek() {
		if (moneyTransfer(club.getPlayerWages()*-1)) {
			this.week += 1;
			int randomness = (20 - (3*this.difficulty));
			this.oposition.clear();
			Team team1 = generateTeam(this.difficulty);
			Team team2 = generateTeam(this.difficulty);
			Team team3 = generateTeam(this.difficulty);
			this.oposition.add(team1);
			this.oposition.add(team2);
			this.oposition.add(team3);
			System.out.println(this.week);
			
//			RandomEvent.randomEvents(randomness);
		} else {
			System.out.println("Sorry you do not have enough money to pay this weeks wages please remove some players from your club");
		}
	}
	
	public ArrayList<Athlete> getTeam(){
		return(this.club.team.getAthletes());
	}
	
	public int getTeamRating(Team team){
		return(this.club.team.teamRating(team));
	}
	
	
	public void addPlayerTeam(Athlete athlete){
		this.club.team.addPlayer(athlete);
		}
	
	
	public boolean moneyTransfer(int amount){
		if ((this.money += amount) < 0) {
			this.money -= amount;
			return false;
		} else {
			return true;
		}
	}
	
	public void minusMoney(int amount){
		this.money -= amount;
	} 
	
	public int getMatchResult(Team team1, Team team2) {
		int hodler = Match.matchResult(team1, team2);
		return hodler;
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
		Random r = new Random();
	    Team opisiton = new Team();
	    for (int i = 0; i < 15; i++){
	        Athlete random = GameEnviroment.generatePlayer();
	        opisiton.addPlayer(random);
	    }
	    
	    String[] nameGenerator = new String[] {"rfc", "ufc", "nfl", "abc"};
		
	    opisiton.teamName = nameGenerator[r.nextInt(4)];
	    return opisiton;
	}
	
	public void launchHomeScreen() {
		if (this.week > this.seasonLength) {
			EndGameScreen endWindow = new EndGameScreen(this);
		}else {
			HomeScreen mainWindow = new HomeScreen(this);
		}
		
	}
	
	public void closeHomeScreen(HomeScreen homeWindow, int tester) {
		homeWindow.closeWindow();
		if (tester == 1) {
			launchSetupScreen();
		}
		else if (tester == 2) {
			launchInventoryScreen();
		}
		
		else if (tester == 3){
			launchMarketPlaceScreen();
		}
		
		else if (tester == 4){
			launchMarketPlaceScreen();
		}
		
		else if (tester == 5){
			launchMatchScreen();
		}
	}
	
	public void launchSetupScreen() {
		SetupScreen setupWindow = new SetupScreen(this);
	}
	
	
	
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
		launchHomeScreen();
	}
	
	public void launchInventoryScreen() {
		InventoryScreen inventoryWindow = new InventoryScreen(this);
	}
	
	public void closeInventoryScreen(InventoryScreen inventoryWindow, int holder) {
		inventoryWindow.closeWindow();
		if (holder == 1) {
			launchHomeScreen();
		}
		else{
			launchTeamScreen();
		}

	}
	
	public void launchMarketPlaceScreen() {
		MarketPlaceScreen marketWindow = new MarketPlaceScreen(this);
	}
	
	public void closeMarketPlaceScreen(MarketPlaceScreen marketWindow) {
		marketWindow.closeWindow();
		launchHomeScreen();
	}
	
	public void launchTeamScreen() {
		TeamScreen teamWindow = new TeamScreen(this);
	}
	
	public void closeTeamScreen(TeamScreen teamWindow) {
		teamWindow.closeWindow();
		launchHomeScreen();
	}
	
	public void launchMatchScreen() {
		MatchScreen matchWindow = new MatchScreen(this);
	}
	
	public void closeMatchScreen(MatchScreen matchWindow) {
		matchWindow.closeWindow();
		launchHomeScreen();
	}
	
	public void closeMatchScreen(MatchScreen matchWindow, Team team) {
		matchWindow.closeWindow();
		launchGameScreen(team);
	}
	
	public void launchGameScreen(Team team) {
		GameScreen matchWindow = new GameScreen(this, team);
	}
	
	public void closeGameScreen(GameScreen gameWindow) {
		gameWindow.closeWindow();
		launchHomeScreen();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameEnviroment manager = new GameEnviroment();
		Inventory club = new Inventory(manager);
		manager.club = club;
		Team team = new Team();
		club.team = team;
		Athlete ed = generatePlayer();
		manager.club.team.addPlayer(ed);
		Team liam = generateTeam(1);
		Team liams = generateTeam(1);
		Team liame = generateTeam(1);
		ArrayList<Team> holder = new ArrayList<Team>();
		holder.add(liam);
		holder.add(liame);
		holder.add(liams);
		manager.oposition = holder;
		manager.launchSetupScreen();

//		GameEnviroment game = new GameEnviroment();
//		Inventory club = new Inventory(game);
//		game.club = club;
//		MarketPlace market = new MarketPlace(game, club);
//		Team team = new Team();
//		club.team = team;
//		Athlete ed = generatePlayer();
//		game.club.addPlayer(ed);
//		game.club.team.addPlayer(ed);
//		game.club.team.printTeamInfo();
		
//		market.buyObject(ed);
//		System.out.println(game.money);
//		game.updateWeek();
//		System.out.println(game.money);
//		market.listBuyables();
		
		
		
	}

}
