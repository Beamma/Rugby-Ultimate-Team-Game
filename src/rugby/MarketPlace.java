package rugby;

import java.util.ArrayList;

public class MarketPlace extends GameEnviroment{
	private ArrayList<Athlete> playersForSale = new ArrayList<Athlete>();
	private ArrayList<Item> itemsForSale = new ArrayList<Item>();
	private GameEnviroment game;
	private Inventory club;
	
	public MarketPlace(GameEnviroment game, Inventory club) {
		this.game = game;
		this.club = club;
		updateMarket();
	}
	
	public void updateMarket() {
		playersForSale.clear();
		for (int i = 0; i < 5; i++) {
			playersForSale.add(generatePlayer());
		}
	}
	
	public void buyObject(Athlete athlete) {
		if (game.moneyTransfer(-100)) {
			System.out.println("Success");
			club.addPlayer(athlete);
		} else {
			System.out.println("Fail");
		}
	}
	
	public void sellObject(Athlete athlete) {
		game.moneyTransfer(athlete.sellPrice);
		club.removePlayer(athlete);
		System.out.printf("Sold %s for %s", athlete.name, athlete.sellPrice);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stup
		
		
	}

}
