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
	public ArrayList<Team> oposition = new ArrayList<Team>();
	private HashMap<String, Integer> standings;
	public Inventory club;
	public int seasonLength;
	public int[] winloss = new int[]{0,0,0};
	int randomness = (20 - (3*this.difficulty));
	public MarketPlace market;
	public boolean trained = false;
//	public String[]  teamNames = new String[]{"Kiakoura", "Glenmark-Cheviot", "Hurunui", "Amberly", "Ashley", "Saracens", "Oxford", "Kaipoi", "Woodend", "Ohoka",
//			"Sumner", "New Brighton", "Linwood", "Shirley", "HSOB", "Christchurch", "Belfast", "Sydnham", "UC", "Lincoln Uni", "Burnside", "Marist-Albion",
//			"Oatutahi", "Suburbs", "Lyttleton", "Halswell Wigram", "Hornby", "Prebbleton", "Southbridge", "Linolcn", "Rolleston", "Springston", "Waihora", "Darfield",
//			"WestMelton", "Kirwee", "BDI", "Banks Penninsula", "Diamond Harbour", "Leeston", "Rakaia", "Methven", "Southern", "Celtic"};
			
	
	
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
			this.money = 450000;
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
			Team team1 = generateTeam(this, this.difficulty);
			Team team2 = generateTeam(this, this.difficulty);
			Team team3 = generateTeam(this, this.difficulty);
			this.oposition.add(team1);
			this.oposition.add(team2);
			this.oposition.add(team3);
			System.out.println(this.week);
			market.updateMarket();
		
			this.market.playersForSale.clear();
			this.market.itemsForSale.clear();
			for (int i = 0 ; i <= 5 ; i++) {
				this.market.playersForSale.add(generatePlayer());
				this.market.itemsForSale.add(generateItem());
			}
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
	
	public boolean checkString(String setupCheck) {
		for (int i = 0; i < setupCheck.length(); i++) {
			if((Character.isLetter(setupCheck.charAt(i)) == false)){
				return false;
			}
		}
		return true;
	}
	
	public int getMatchResult(Team team1, Team team2, Inventory club) {
		int resultMatch = Match.matchResult(team1, team2, club);
		
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
	
	public static Athlete generatePlayer(int diffuculty) {
		int lowValue = 0;
		int highValue = 0;
		if (diffuculty == 1) {
			lowValue = 40;
			highValue = 75;
		}else if(diffuculty == 2) {
			lowValue = 50;
			highValue = 85;
		}else if(diffuculty == 3) {
			lowValue = 60;
			highValue = 100;
		}
		
		int[] atributes = new int[]{0, 0, 0, 0, 0, 0};
		Random r = new Random();
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
		
		Item fitness = new Item("Fitness Train", 500, new int[]{10, 0, 0, 0, 0, 20});
		Item gym = new Item("Gym Session", 750, new int[]{0, 0, 0, 20, 20, 0});
		Item train = new Item("Training Camp", 1500, new int[]{10, 10, 10, 10, 10, 10});
		Item skills = new Item("Skills Session", 250, new int[]{0, 10, 10, 0, 0, 0});
		Item coaching = new Item("Focused Coaching", 2000, new int[]{0, 25, 25, 10, 10, 0});
		
		Item[] items = new Item[] {fitness, gym, train, skills, coaching};
		Random r = new Random();
		return(items[r.nextInt(5)]);
	}
	
	
	public Team generateTeam(GameEnviroment gameEnviroment, int diffuculty){
		Random r = new Random();
	    Team opisiton = new Team();
	    for (int i = 0; i < 15; i++){
	        Athlete random = GameEnviroment.generatePlayer(gameEnviroment.difficulty);
	        opisiton.addPlayer(random);
	    }
	    
	    String[] clubNameGenerator = new String[] {"Crusaders", "Blues", "Cheifs", "Hurricanes", "Highlanders", "Drua", "Pasifika", "Reds", "Warratahs", "Force", "Rebels", "Brumbies"};
		
	    opisiton.teamName = clubNameGenerator[r.nextInt(clubNameGenerator.length)];
	    	
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
		Team team1 = this.generateTeam(this, this.difficulty);
		Team team2 = this.generateTeam(this, this.difficulty);
		Team team3 = this.generateTeam(this, this.difficulty);
		this.oposition.add(team1);
		this.oposition.add(team2);
		this.oposition.add(team3);
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
	
	public void refreshInventoryScreen(InventoryScreen inventoryScreen) {
		inventoryScreen.closeWindow();
		launchInventoryScreen();
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
	
	public void refreshMarketPlaceScreen(MarketPlaceScreen marketWindow) {
		marketWindow.closeWindow();
		launchMarketPlaceScreen();
	}
	
	public void closeTeamScreen(MarketPlaceScreen marketWindow, Athlete athlete) {
		marketWindow.closeWindow();
		launchAthleteScreen(athlete);
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
	
	public void closeGameScreen(GameScreen gameWindow, int team) {
		gameWindow.closeWindow();
		launchTeamScreen();
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
		manager.launchSetupScreen();

		
		
		
	}

}
