package rugby;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MarketPlaceTest {
	private static Inventory club;
	private static GameEnviroment manager;
	private static MarketPlace market;
	
	@BeforeAll
	public static void init(){
		manager = new GameEnviroment();
		club = new Inventory(manager);
		market = new MarketPlace(manager, club);
		manager.market = market;
	}
	
	@Test
	void updateMarket() {
		ArrayList<Athlete> previousMarket = new ArrayList<Athlete>();
		for (int i = 0; i < 5; i++) {
			previousMarket.add(market.playersForSale.get(i));
		}
		
		market.updateMarket();
		
		// checking to see if the market contain any of the old athletes
		
		for (int i = 0; i < 3; i++) {
			assertFalse(previousMarket.contains(market.playersForSale.get(i)));
		}
	}
	
	@Test
	void removeMarketPlayer() {
		// checking removing a player
		Athlete event = market.playersForSale.get(0);
		market.removeMarketPlayer(market.playersForSale.get(0));
		
		assertFalse(market.playersForSale.contains(event));
		
	}
	
	@Test
	void removeMarketItem() {
		// checking removing a item
		Item event = market.itemsForSale.get(0);
		market.removeMarketItem(market.itemsForSale.get(0));
		
		assertFalse(market.itemsForSale.contains(event));
	}
	
	@Test
	void returnPlayer() {
		// checking return a player
		Athlete event = GameEnviroment.generatePlayer(2);
		market.playersForSale.clear();
		market.playersForSale.add(event);
		assertTrue(market.returnPlayer(0) == event);
	}
	
	@Test
	void returnItem() {
		// checking return a item
		Item event = GameEnviroment.generateItem();
		market.itemsForSale.clear();
		market.itemsForSale.add(event);
		assertTrue(market.returnItem(0) == event);
	}
	@Test
	void buyItem() {
		// checking buy a item
		Item event = GameEnviroment.generateItem();
		market.itemsForSale.clear();
		market.itemsForSale.add(event);
		market.buyItem(0);
		assertTrue(market.buyItem(0) == "You Dont Have Enough Money");
	}
	
	@Test
	void buyPlayer() {
		// checking buy player
		Athlete event = GameEnviroment.generatePlayer(2);
		market.playersForSale.clear();
		market.playersForSale.add(event);
		market.buyAthlete(0);
		assertTrue(market.buyAthlete(0) == "You Dont Have Enough Money");
	}
	

	
	
		
	
	
}
