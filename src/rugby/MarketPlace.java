package rugby;

import java.util.ArrayList;
import java.util.Scanner;

public class MarketPlace extends GameEnviroment{
	public ArrayList<Athlete> playersForSale = new ArrayList<Athlete>();
	public ArrayList<Item> itemsForSale = new ArrayList<Item>();
	private GameEnviroment game;
	private Inventory club;
	
	public MarketPlace(GameEnviroment game, Inventory club) {
		this.game = game;
		this.club = club;
<<<<<<< HEAD
		for (int i = 0 ; i <= 20 ; i++) {
			playersForSale.add(generatePlayer());
=======
		for (int i = 0 ; i <= 15 ; i++) {
			playersForSale.add(generatePlayer());
		}
		
		for (int i = 0 ; i <= 9 ; i++) {
			itemsForSale.add(generateItem());
>>>>>>> 4b5065267adf72c10658d32b390d7e94649784ad
		}
		itemsForSale.add(generateItem());
		itemsForSale.add(generateItem());
		itemsForSale.add(generateItem());
	}
	
	
	public void removeMarketPlayer(Athlete athlete) {
		playersForSale.remove(athlete);
	}
	
	public void removeMarketItem(Item item) {
		itemsForSale.remove(item);
	}
	
	public void updateMarket() {
		playersForSale.clear();
		itemsForSale.clear();
		for (int i = 0; i < 5; i++) {
			playersForSale.add(generatePlayer());
			}
		itemsForSale.add(generateItem());
		itemsForSale.add(generateItem());
		itemsForSale.add(generateItem());
	}
	
	public void buyObject(Athlete athlete) {
		if (game.moneyTransfer(-100)) {
			System.out.println("Success");
			club.addPlayer(athlete);
		} else {
			System.out.println("Fail");
		}
	}
	
	public ArrayList<String> getAllItemsNames(){
		ArrayList<String> itemNames = new ArrayList<String>();
		for (Item item : this.itemsForSale) {
			itemNames.add(item.item);
		}
		return itemNames;
	}
	
	public void sellObject(Athlete athlete) {
		game.moneyTransfer(athlete.sellPrice);
		club.removePlayer(athlete);
		System.out.printf("Sold %s for %s", athlete.name, athlete.sellPrice);
	}
	
	public void listBuyables() {
		System.out.println("Athletes Currently Available For Purchase:");
		System.out.printf("%-4s%-10s%-10s%-10s%-10s%35s%n"," ", "Name", "Price", "Wage", "Rating", "Stats");
		int i = 0;
		for (Athlete athlete : this.playersForSale) {
			System.out.printf("%-2s: %-10s$%-10s$%-10s%-10s%s%n", i, athlete.name, athlete.buyPrice, athlete.wage, athlete.rarity, athlete.stats);
			i += 1;
		}
		
		System.out.println();
		System.out.println("Items Currently Available For Purchase:");
		System.out.printf("%-4s%-10s%-10s%35s%n"," ", "Item", "Price", "Boosts");
		
		for (Item item : this.itemsForSale) {
			System.out.printf("%-2s: %-10s$%-10s%s%n", i, item.item, item.price, item.stats);
			i += 1;
		}
		
		selectBuyables();
	}
		
		
	public void selectBuyables() {
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Select An Object To Purchase, or press -1 to return: ");
			int athlete = input.nextInt();
			if (athlete == -1) {
				return;
			} else {
				buyObject(playersForSale.get(athlete));
			}
			
		}
		
		catch(Exception  e) {
			System.out.println("Please Select A Valid Input");
			selectBuyables();
			
		}
	}

		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method setup
		
		
	}

}
