package rugby;

import java.util.HashMap;

/**
 * 
 * This class is simply a base object for athlete, has base level method to go with
 *
 */
public class Athlete {
	
	private String name;
	private String nickName = name;
	public HashMap<String, Integer> stats;
	private int wage;
	private int sellPrice;
	private int buyPrice;
	private int stamina = 100;
	private boolean injured = false;
	private String position;
	private int rarity;
	public String[] attributes = new String[]{"Pace", "Passing", "Defence", "Tackling", "Offence", "Fitness"};
	
	/**
	 * Constructor
	 * @param name String
	 * @param wage int
	 * @param sellPrice int
	 * @param buyPrice int
	 * @param injured boolean
	 * @param position String
	 * @param rarity int
	 * @param value int
	 */
	public Athlete(String name, int wage, int sellPrice, int buyPrice, boolean injured, String position, int rarity, int[] value) {
		this.name = name;
		this.nickName = name;
		this.wage = wage;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.position = position;
		this.rarity = rarity;
		this.stats = new HashMap<String, Integer>();
		
		for (int i = 0; i < 6; i++) {
			this.stats.put(attributes[i], value[i]);
		}
	}
	
	/**
	 * Overrides the base to string
	 */
	@Override
	public String toString() {

		return String.format("%s Stamina: %d Pos: %s Rating: %d",this.nickName, this.stamina, this.position, this.rarity);

	}
	
	/**
	 * Sets nickname for selected athlete
	 * @param changeName String new nickname for athlete
	 */
	public void changeNickName(String changeName){
		this.nickName = changeName;
	}
	
	/**
	 * Restore athlete stamina to full
	 */
	public void rest(){
		this.stamina = 100;
	}

	/**
	 * increase all stats of an athlete
	 */
	public void trainAll(){
		for (String stat : attributes) {
			stats.put(stat, stats.get(stat) + 1);
		}
	}
	
	/**
	 * Gets new rating for selected athlete
	 */
	public void updateRating() {
		int newRating = 0;
		for (int i = 0; i < 6; i++) {
			newRating += this.stats.get(attributes[i]);
		}
		this.rarity = newRating/6;
		this.sellPrice = this.rarity*15;
	}
	
	/**
	 * update sell price for athlete
	 * @param changeValue int new value for sell price
	 */
	public void changeValue(int changeValue) {
		this.sellPrice = changeValue;
	}
	
	/**
	 * Make player injured
	 */
	public void injury() {
		this.injured = true;
	}
	
	/**
	 * reduce stamina of athlete
	 */
	public void reduceStamina() {
		int athleteFitness = this.stats.get("Fitness");
		if (this.stamina - (100 - athleteFitness) <= 0) {
			this.stamina = 0;
		}
		else{
			this.stamina -= (100 - athleteFitness);  
		}
	}
	
	/**
	 * Name Getter
	 * @return String name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Buy Price Getter
	 * @return int Buy Price
	 */
	public int getBuyPrice() {
		return this.buyPrice;
	}
	
	/**
	 * Sell Price Getter
	 * @return int Sell Price
	 */
	public int getSellPrice() {
		return this.sellPrice;
	}
	
	/**
	 * Injury  Getter
	 * @return boolean Injury
	 */
	public boolean getInjury() {
		return this.injured;
	}
	
	/**
	 * Rating Getter
	 * @return int new rating of athlete
	 */
	public int getRating() {
		return this.rarity;
	}
	
	/**
	 * Wage Getter
	 * @return int wage
	 */
	public int getWage() {
		return this.wage;
	}
	
	/**
	 * Position getter
	 * @return String position of athlete
	 */
	public String getPosition() {
		return this.position;
	}

	/**
	 * Stamina getter
	 * @return int stamina of athlete
	 */
	public int getStamina() {
		return this.stamina;
	}
}
