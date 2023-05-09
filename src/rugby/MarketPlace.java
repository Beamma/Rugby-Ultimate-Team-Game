package rugby;

import java.util.ArrayList;

public class MarketPlace {
	private ArrayList<Athlete> playersForSale = new ArrayList<Athlete>();
	private ArrayList<Item> itemsForSale = new ArrayList<Item>();
	
	public void updateMarket() {
		playersForSale.clear();
		for (int i = 0; i < 5; i++) {
			playersForSale.add(GameEnviroment.generatePlayer());
		}
	}
	
	public void buyObject(Object thing) {
		if (this.moneyTransfer());
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarketPlace market = new MarketPlace();
		market.updateMarket();
		Athlete ed = GameEnviroment.generatePlayer();
		market.buyObject(ed);
		
		
	}

}
