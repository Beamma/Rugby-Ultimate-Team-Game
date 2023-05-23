package rugby;

import java.util.ArrayList;
/**
 * Market place where athlete objects and item objects are able to be bought and transfered to the team/inventory
 * @author Joel Bremner & Liam Ceelan-Thomas
 * 
 */
public class MarketPlace extends GameEnviroment{
	public ArrayList<Athlete> playersForSale = new ArrayList<Athlete>();
	public ArrayList<Item> itemsForSale = new ArrayList<Item>();
	private GameEnviroment game;
	private Inventory club;
	
	/**
	 * Constructor
	 * @param game
	 * @param club
	 */
	public MarketPlace(GameEnviroment game, Inventory club) {
		this.game = game;
		this.club = club;

		for (int i = 0 ; i < 14 ; i++) {
			playersForSale.add(generatePlayer(game.getDifficulty()));
		}
		
		for (int i = 0 ; i <= 2 ; i++) {
			itemsForSale.add(generateItem());
		}
	}
	
	/**
	 * Gets athlete from market
	 * @param index - index of player in playersForSale
	 * @return - Athlete at given index
	 */
	public Athlete returnPlayer(int index) {
		return playersForSale.get(index);
	}
	
	/**
	 * Gets item from market
	 * @param index - index of item in itemsForSale
	 * @return - Item at given index
	 */
	public Item returnItem(int index) {
		return itemsForSale.get(index);
	}
	
	/**
	 * Removes athlete from market
	 * @param athlete - athlete to be removed from market
	 */
	public void removeMarketPlayer(Athlete athlete) {
		playersForSale.remove(athlete);
	}
	
	/**
	 * Removes item from market
	 * @param item - item to be removed from market
	 */
	public void removeMarketItem(Item item) {
		itemsForSale.remove(item);
	}
	
	/**
	 * Updates market, getting rid of old objects and putting in 3 new athletes and 3 new items
	 */
	public void updateMarket() {
		playersForSale.clear();
		itemsForSale.clear();
		for (int i = 0; i < 3; i++) {
			playersForSale.add(generatePlayer(game.getDifficulty()));
			itemsForSale.add(generateItem());
			}
	}
	
	/**
	 * Returns a string formatted array of all athlete on the market
	 * @return - Returns a string formatted array of all athletes on the market
	 */
	public String[] returnPlayerArray() { 
		ArrayList<String> playerArrayList = new ArrayList<>();
		
		for (Athlete athlete: this.playersForSale) {
			playerArrayList.add(String.format("%-40s", (athlete.getName() + " $" + athlete.getBuyPrice() + " Pos: " + athlete.getPosition() + " Rating: " + athlete.getRating() )));
		}
		
		String[] playerArray = playerArrayList.toArray(new String[0]);
		return playerArray;
	}
	
	/**
	 * Returns a string formatted array of all items on the market
	 * @return Returns a string formatted array of all items on the market
	 */
	public String[] returnItemArray() {
		ArrayList<String> itemArrayList = new ArrayList<>();
		
		for (Item item: this.itemsForSale) {
			itemArrayList.add(String.format("%-60s", (item.getName() + " $" + item.getPrice())));
		}
		
		String[] itemArray = itemArrayList.toArray(new String[0]);
		return itemArray;
	}
	
	/**
	 * Buys athlete from market and adds it to your inventory
	 * @param index - index of athlete in playersForSale
	 * @return - athlete at given index
	 */
	public String buyAthlete(int index) {
		String result = "";
		Athlete athlete = playersForSale.get(index);
		if (athlete.getBuyPrice() <= game.getMoney() && club.getPlayers().size() < 5) {
			removeMarketPlayer(athlete);
			club.addPlayer(athlete);
			game.minusMoney(athlete.getBuyPrice());
			result = "Bought";
		}
		else if (athlete.getBuyPrice() > game.getMoney()){
			result = "You Dont Have Enough Money";
		}
		else {
			result = "Your Club Is Full";
		}
		return result;
	}
	
	/**
	 * Buys item from market and adds it to your inventory
	 * @param index - index of item in itemsForSale
	 * @return - item at given index
	 */
	public String buyItem(int index) {
		String result = "";
		Item item = itemsForSale.get(index);
		if (item.getPrice() <= game.getMoney() && club.getItems().size() < 5) {
			removeMarketItem(item);
			club.addItem(item);
			game.minusMoney(item.getPrice());
			result = "Bought";
		}
		else if (item.getPrice() > game.getMoney()) {
			result = "You Dont Have Enough Money";
		}
		else {
			result = "Your Club Is Full";
		}
		return result;
	}

}
