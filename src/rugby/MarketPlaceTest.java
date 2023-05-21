package rugby;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MarketPlaceTest {

	@Test
	void updateMarket() {
		GameEnviroment manager = new GameEnviroment();
		Inventory club = new Inventory(manager);
		MarketPlace market = new MarketPlace(manager, club);
		ArrayList<Athlete> previousMarket = new ArrayList<Athlete>();
		for (int i = 0; i <5; i++) {
			previousMarket.add(market.playersForSale.get(i));
		}
		
		market.updateMarket();
		
		// checking to see if the market contain any of the old athletes
		for (int i = 0; i <5; i++) {
			assertFalse(previousMarket.contains(market.playersForSale.get(i)));
		}
	}
	
	@Test
	void removeMarketPlayer() {
		GameEnviroment manager = new GameEnviroment();
		Inventory club = new Inventory(manager);
		MarketPlace market = new MarketPlace(manager, club);
		Athlete event = market.playersForSale.get(0);
		market.removeMarketPlayer(market.playersForSale.get(0));
		
		assertFalse(market.playersForSale.contains(event));
		
	}
	
	@Test
	void removeMarketItem() {
		GameEnviroment manager = new GameEnviroment();
		Inventory club = new Inventory(manager);
		MarketPlace market = new MarketPlace(manager, club);
		Item event = market.itemsForSale.get(0);
		market.removeMarketItem(market.itemsForSale.get(0));
		
		assertFalse(market.itemsForSale.contains(event));
	}

}
