package rugby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import gui.HomeScreen;
import gui.MainScreen;
import gui.SetupScreen;  

public class GameEnviroment {
	public int money;
	public String teamName;
	public int difficulty = 2;
	public int week = 1;
	public ArrayList<Team> oposition;
	private HashMap<String, Integer> standings;
	public Inventory club;
	public int seasonLength;
	public int[] winloss = new int[]{0,0,0};
	int randomness = (10 - (3*this.difficulty));
	public MarketPlace market;
	public boolean trained = false;
	
	public void setSeasonLength(int value) {
		this.seasonLength = value;
	}
	
	public void setdifficulty(String value) {
		this.difficulty = Integer.valueOf(value);
	}
	
	public void setName(String name){
		this.teamName = name;
	}
	
	public void setStartMoney() {
		if (this.difficulty == 1) {
			this.money = 45000;
		}
		else if (this.difficulty == 2){
			this.money = 30000;
		}
		else if (this.difficulty == 1) {
			this.money = 20000;
		}
	}
	public void updateWeek() {
		if (moneyTransfer(club.getPlayerWages()*-1)) {
				this.week += 1;
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
	
	public void addMoney(int amount){
		this.money += amount;
	} 
	
	
	public int getMatchResult(Team team1, Team team2) {
		int resultMatch = Match.matchResult(team1, team2);
		return resultMatch;
	}
	
	public static Athlete generatePlayer() {
		
		int[] atributes = new int[]{0, 0, 0, 0, 0, 0};
		Random r = new Random();
		int lowValue = 50;
		int highValue = 100;
		int result = r.nextInt(highValue-lowValue) + lowValue;
		int rarity = 0;
		
		for (int i = 0; i < 6; i++) {
			int statValue = r.nextInt((result+10)-(result-10)) + (result-10);
			if (statValue > 99) {
				atributes[i] = 99;
				rarity += 99;
			}else {
				atributes[i] = statValue;
				rarity += statValue;
			}
		}
		
		rarity = rarity/6; 
		
		String[] nameGenerator = new String[] {"Bob", "Tim", "Joel", "Liam", "Matt", "Jim","John", "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Robin","Doe", "Smith", "Johnson", "Williams", "Jones", "Brown", "Hood"};
		String name = nameGenerator[r.nextInt(nameGenerator.length)];
		String position = "cb";
		int buyPrice = rarity*20;
		int sellPrice = rarity*15;
		int wage = rarity*8;
		
		return(new Athlete(name, wage, sellPrice, buyPrice, false, position, rarity, atributes));
	}
	
	public static Item generateItem() {
		
		int[] atributes = new int[]{0, 0, 0, 0, 0, 0};
		Random r = new Random();
		int lowValue = 1;
		int highValue = 10;
		int result = r.nextInt(highValue-lowValue) + lowValue;
		
		for (int i = 0; i < 6; i++) {
			int statValue = r.nextInt((result+2)-(result-2)) + (result-2);
			if (statValue > 10) {
				atributes[i] = 10;
			}else if (statValue < 0) {
				atributes[i] = 0;
			}else{
				atributes[i] = statValue;
			}
		}
	   
		String[] itemGenerator = new String[] {"water", "poweraid", "joel", "liam"};
		String item = itemGenerator[r.nextInt(itemGenerator.length)];
		int price = 10 * result;
		
		return(new Item(item, price, atributes));
	}
	
	public static Team generateTeam(int diffuculty){
		Random r = new Random();
	    Team opisiton = new Team();
	    for (int i = 0; i < 15; i++){
	        Athlete random = GameEnviroment.generatePlayer();
	        opisiton.addPlayer(random);
	    }
	    
	    String[] clubNameGenerator = new String[] {"rfc", "ufc", "nfl", "abc"};
		
	    opisiton.teamName = clubNameGenerator[r.nextInt(4)];
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
			launchTrainScreen();
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
	
	public void closeInventoryScreen(InventoryScreen inventoryWindow, Item item) {
		inventoryWindow.closeWindow();
		launchItemScreen(item);
	}
	
	public void launchItemScreen(Item item) {
		ItemScreen itemWindow = new ItemScreen(this, item);
	}
	
	public void closeItemScreen(ItemScreen itemScreen) {
		itemScreen.closeWindow();
		launchHomeScreen();
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
	
	public void closeTeamScreen(TeamScreen teamWindow, Athlete athlete) {
		teamWindow.closeWindow();
		launchAthleteScreen(athlete);
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
	
	public void launchAthleteScreen(Athlete athlete) {
		AthleteScreen matchWindow = new AthleteScreen(this, athlete);
	}
	
	public void closeAthleteScreen(AthleteScreen athleteWindow) {
		athleteWindow.closeWindow();
		launchHomeScreen();
	}
	
	public void launchTrainScreen() {
		TrainScreen matchWindow = new TrainScreen(this);
	}
	
	public void closeTrainScreen(TrainScreen trainWindow) {
		trainWindow.closeWindow();
		launchHomeScreen();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameEnviroment manager = new GameEnviroment();
		Inventory club = new Inventory(manager);
		manager.club = club;
		Team team = new Team();
		club.team = team;
		MarketPlace market = new MarketPlace(manager, manager.club);
		manager.market = market;
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
		Item i = generateItem();
		club.items.add(i);

		manager.launchSetupScreen();

//		GameEnviroment game = new GameEnviroment();
//		Inventory club = new Inventory(game);sdadsa
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
