package rugby;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import gui.AthleteScreen;
import gui.EndGameScreen;
import gui.GameScreen;
import gui.HomeScreen;
import gui.InventoryScreen;
import gui.ItemScreen;
import gui.MarketAthleteScreen;
import gui.MarketItemScreen;
import gui.MarketPlaceScreen;
import gui.MatchScreen;
import gui.SetupScreen;
import gui.TeamScreen;
import gui.TrainScreen;  

/**
 * 
 * @author Joel Bremner & Liam Ceelen-thomas
 * Game environment class responsible for managing the play through of the game
 */
public class GameEnviroment {
	private int money;
	private String teamName;
	private int difficulty = 2;
	private int week = 1;
	public ArrayList<Team> oposition = new ArrayList<Team>();
	public Inventory club;
	private int seasonLength;
	public int[] winloss = new int[]{0,0,0};
	public int randomness = (20 - (3*this.difficulty));
	public MarketPlace market;
	public boolean trained = false;
	public static int teamSize = 7;
	private static ArrayList<String> teamNames = new ArrayList<String>(Arrays.asList(
			"Kiakoura", "Glenmark-Cheviot", "Hurunui", "Amberly", "Ashley", "Saracens", "Oxford", "Kaipoi", "Woodend", "Ohoka",
			"Sumner", "New Brighton", "Linwood", "Shirley", "HSOB", "Christchurch", "Belfast", "Sydnham", "UC", "Lincoln Uni", "Burnside", "Marist-Albion",
			"Oatutahi", "Suburbs", "Lyttleton", "Halswell Wigram", "Hornby", "Prebbleton", "Southbridge", "Linolcn", "Rolleston", "Springston", "Waihora", "Darfield",
			"WestMelton", "Kirwee", "BDI", "Banks Penninsula", "Diamond Harbour", "Leeston", "Rakaia", "Methven", "Southern", "Celtic", "Collegiate", "Mt Sommers", 
			"Hampstead", "Allenton", "Temuka", "Mackenzie", "Waimate", "Pleasant Point", "Geraldine", "Timaru Old Boys", "Timaru Celtic", "Harlequins"
			));
			
	/**
	 * Constructor
	 */
	public GameEnviroment() {
		RandomEvent.gameEnviroment = this;
	}
	
	/**
	 * Sets season length
	 * @param value - chosen season length
	 */
	public void setSeasonLength(int value) {
		this.seasonLength = value;
	}
	
	/**
	 * Sets difficulty of game
	 * @param value - chosen difficulty
	 */
	public void setDifficulty(String value) {
		this.difficulty = Integer.valueOf(value);
	}
	
	public int getDifficulty() {
		return this.difficulty;
	}
	
	/**
	 * Team Name setter
	 * @param name - chosen teamname
	 */
	public void setName(String name){
		this.teamName = name;
	}
	
	/**
	 * Sets start money based off difficulty
	 */
	public void setStartMoney() {
		if (this.difficulty == 1) {
			this.money = 50000;
		}
		else if (this.difficulty == 2){
			this.money = 35000;
		}
		else if (this.difficulty == 3) {
			this.money = 20000;
		}
	}
	
	/**
	 * updates week and creates new opponents for next week
	 */
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
			market.updateMarket();
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
	
	public int getMoney() {
		return this.money;
	}
	
	public void setMoney(int value) {
		this.money = value;
	}
	
	public String getName() {
		return this.teamName;
	}
	
	public int getWeek() {
		return this.week;
	}
	
	public int getSeasonLength() {
		return this.seasonLength;
	}
	
	public boolean checkString(String setupCheck) {
		for (int i = 0; i < setupCheck.length(); i++) {
			if((Character.isLetter(setupCheck.charAt(i)) == false)){
				return false;
			}
		}
		return true;
	}
	
	public int getMatchResult(Team team1, Team team2, Inventory club, GameScreen gameScreen) {
		int resultMatch = Match.matchResult(team1, team2, club, gameScreen);
		
		return resultMatch;
	}
	
	public static Athlete generatePlayer(int diffuculty) {
		int lowValue = 0;
		int highValue = 0;
		if (diffuculty == 3) {
			lowValue = 40;
			highValue = 75;
		}else if(diffuculty == 2) {
			lowValue = 50;
			highValue = 85;
		}else if(diffuculty == 1) {
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
		
		String[] nameGenerator = new String[] {
				"Joel", "Liam", "Lorenz", "Matt", "Luke", "Sam", "Jade", "Matthew", "Flynn", "Will", "Tyler", "Richie", "Glenn", "Kane", "Jaydin", "Pio", "Caleb", "Michael",
				"Mike", "Calib", "Jaden", "Quentin", "Quinton", "Rob", "Robert", "Samuel", "Daniel", "Bryan", "Brydon", "Roger", "Steven", "Devo", "Wayne", "Ashton",
				"Kerryn", "Kerran", "Tane", "Sonny", "Shanley", "Jack", "Clint", "Jason", "James", "Jordan", "Jordy", "Ben", "Noah", "Alex", "Richard", "Henry", "Aaron",
				"Ted", "Dan", "Daniel", "Aron", "TJ", "David", "Bradon", "George", "Mitch", "Callum", "Pete", "Peter", "Warren"};
		
		String[] lastNames = new String[] {
				"Smith","Johnson","Williams","Brown","Jones","Garcia","Miller","Davis","Rodriguez","Martinez","Hernandez","Lopez","Gonzalez","Wilson","Anderson","Thomas",
				"Taylor","Moore","Jackson","Martin","Lee","Perez","Thompson","White","Harris","Sanchez","Clark","Ramirez","Lewis","Robinson","Walker","Young","Allen",
				"King","Wright","Scott","Torres","Nguyen","Hill","Flores","Green","Adams","Nelson","Baker","Hall","Rivera","Campbell","Mitchell","Carter","Roberts"
		};
		String nameFirst = nameGenerator[r.nextInt(nameGenerator.length)];
		String nameLast = lastNames[r.nextInt(lastNames.length)];
		String name = nameFirst + " " + nameLast;
		String[] positions = new String[] {"FR", "LF", "LK","HB", "FF", "MF", "OB"};
		String position = positions[r.nextInt(positions.length)];
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
		return(items[r.nextInt(items.length)]);

	}
	
	
	public Team generateTeam(GameEnviroment gameEnviroment, int diffuculty){
		Random r = new Random();
	    Team opisiton = new Team();
	    for (int i = 0; i < GameEnviroment.teamSize; i++){
	        Athlete random = GameEnviroment.generatePlayer(4-gameEnviroment.difficulty);
	        opisiton.addPlayer(random);
	    }
	    
	    int number = r.nextInt(GameEnviroment.teamNames.size());
	    opisiton.setTeamName(GameEnviroment.teamNames.get(number));
	    GameEnviroment.teamNames.remove(number);
	    
	    	
	    return opisiton;
	}
	
	
	public void launchHomeScreen() {
		if (this.week > this.seasonLength) {
			EndGameScreen endWindow = new EndGameScreen(this);
		}else {
			HomeScreen mainWindow = new HomeScreen(this);
		}
		
	}
	
	public void closeHomeScreen(HomeScreen homeWindow, int navigator) {
		homeWindow.closeWindow();
		if (navigator == 1) {
			launchTrainScreen();
		}
		else if (navigator == 2) {
			launchInventoryScreen();
		}
		
		else if (navigator == 3){
			launchMarketPlaceScreen();
		}
		
		else if (navigator == 4){
			launchMarketPlaceScreen();
		}
		
		else if (navigator == 5){
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
	
	public void closeInventoryScreen(InventoryScreen inventoryWindow, int navigator) {
		inventoryWindow.closeWindow();
		if (navigator == 1) {
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
	
	public void closeInventoryScreen(InventoryScreen inventoryWindow, Athlete athlete) {
		inventoryWindow.closeWindow();
		launchAthleteScreen(athlete);
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
	
	public void closeTeamScreen(MarketPlaceScreen marketWindow, Item item) {
		marketWindow.closeWindow();
		launchMarketItemScreen(item);
	}
	
	public void launchMarketItemScreen(Item item) {
		MarketItemScreen marketItemWindow = new MarketItemScreen(this, item);
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
	
	public void closeMarketItemScreen(MarketItemScreen marketItemScreen) {
		marketItemScreen.closeWindow();
		launchHomeScreen();
	}
	
	public void closeMarketAthleteScreen(MarketAthleteScreen marketAthleteScreen) {
		marketAthleteScreen.closeWindow();
		launchHomeScreen();
	}
	
	public void openMarketAthleteScreen(MarketPlaceScreen marketWindow, Athlete athlete) {
		marketWindow.closeWindow();
		launchMarketAthleteWindow(athlete);
	}
	
	private void launchMarketAthleteWindow(Athlete athlete) {
		MarketAthleteScreen marketAthlete = new MarketAthleteScreen(this, athlete);
	}

	public static void main(String[] args) {
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
