package rugby;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Joel Bremner & Liam Ceelan-Thomas
 * Inventory class that is in charge of athletes and items
 */
public class Inventory {
	
	public ArrayList<Athlete> players = new ArrayList<Athlete>();
	public ArrayList<Item> items = new ArrayList<Item>();
	public Team team;
	private GameEnviroment game;
	
	/**
	 * Constructor
	 * @param game
	 */
	public Inventory(GameEnviroment game) {
		this.game = game;
	}
	
	/**
	 * Returns all reserves
	 * @return - array of reserves
	 */
	public ArrayList<Athlete> getAllAthletes(){
		return this.players;
	}
	
	/**
	 * Add athlete to inventory
	 * @param athlete - athlete to add to inventory
	 */
	public void addPlayer(Athlete athlete) {
		if (team.addPlayer(athlete)) {
		} else {
			players.add(athlete);
		} 
	}
	
	/**
	 * Remove athlete from inventory
	 * @param athlete - athlete to remove from inventory
	 */
	public void removePlayer(Athlete athlete) {
		if (players.contains(athlete)) {
			players.remove(athlete);
			System.out.println("Reserve");
		} 
		else if (team.getAthletes().contains(athlete) && players.size() > 0){
			team.removePlayer(athlete);
			team.addPlayer(players.get(0));
			players.remove(0);
			System.out.println("Player, move reserve");
		}
		else {
			team.removePlayer(athlete);
			System.out.println("Player ");
		}
	}
	
	/**
	 * Add item to inventory
	 * @param item - item to add to inventory
	 */
	public void addItem(Item item) {
		items.add(item);
	}
	
	/**
	 * Remove item from inventory
	 * @param item - item to remove from inventory
	 */
	public void removeItem(Item item) {
		if (this.items.contains(item)) {
			this.items.remove(item);
		} 
	}
	
	/**
	 * Swap a reserve player with a player in your team
	 * @param athlete1
	 * @param athlete2
	 */
	public void swapPlayer(Athlete athlete1, Athlete athlete2) {
		this.addPlayer(athlete1);
		this.team.removePlayer(athlete1);
		this.removePlayer(athlete2);
		this.team.addPlayer(athlete2);
	}
	
	/**
	 * Return arraylist of reserves
	 * @return - Return arraylist of reserves
	 */
	public ArrayList<Athlete> getPlayers(){
		return players;
	}
	
	/**
	 * return array list of items
	 * @return - return array list of items
	 */
	public ArrayList<Item> getItems(){
		return this.items;
	}
	

	/**
	 * Get weekly wages of all players in inventory
	 * @return - Weekly wage
	 */
	public int getPlayerWages(){
		int weeklyWage = 0;
		if (this.team.players.size() <= 0) {
			return 0;
		}
		for (Athlete player : this.team.players) {
			weeklyWage += player.wage;
		}
		for (Athlete player : this.players) {
			weeklyWage += player.wage;
		}
		return weeklyWage;
	}
	
	/**
	 * Rests all players in inventory
	 */
	public void boostStamina() {
		for (Athlete athlete : this.players) {
			athlete.rest();
		}
	}
	


	}
