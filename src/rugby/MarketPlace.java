package rugby;

import java.util.ArrayList;

public class MarketPlace extends GameEnviroment{
	private ArrayList<Athlete> playersForSale = new ArrayList<Athlete>();
	private ArrayList<Item> itemsForSale = new ArrayList<Item>();
	
	public MarketPlace() {
		updateMarket();
	}
	
	public void updateMarket() {
		playersForSale.clear();
		for (int i = 0; i < 5; i++) {
			playersForSale.add(generatePlayer());
		}
	}
	
	public void buyObject(Object thing) {
		if (moneyTransfer(-100)) {
			System.out.println("Success");
		} else {
			System.out.println("Fail");
		}
		
	}
	
	public void test() {
		money += 100;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarketPlace market = new MarketPlace();
		market.updateMarket();
		Athlete ed = GameEnviroment.generatePlayer();
		market.buyObject(ed);
		
		
	}

}
