package rugby;

import java.util.HashMap;

/**
 * class for base level object item
 * @author Joel Bremner & Liam Ceelan-Thomas
 *
 */
public class Item {
	
	public String item;
	public HashMap<String, Integer> stats;
	public int price;
	public int sellPrice;
	public String[] attributes = new String[]{"Pace", "Passing", "Defence", "Tackling", "Offence", "Fitness"};
	
	/**
	 * Constructor
	 * @param item
	 * @param price
	 * @param value
	 */
	public Item(String item, int price, int[] value) {
		this.item = item;
		this.price = price;
		this.stats = new HashMap<String, Integer>();
		this.sellPrice = price - 100;
		
		for (int i = 0; i < 6; i++) {
			this.stats.put(attributes[i], value[i]);
		}
	}
	
	/**
	 * Use item on selected athletes
	 * @param athlete - athlete to use item on
	 * @param item - to use on athlete
	 */
	public void useItem(Athlete athlete, Item item) {
		for (int i = 0; i < 6; i++) {
			System.out.println(athlete.stats.get(attributes[i]) + (item.stats.get(attributes[i])));
			athlete.stats.put(attributes[i], athlete.stats.get(attributes[i]) + (item.stats.get(attributes[i])));
		}
	}
	
	/**
	 * Price Getter
	 * @return - price of item
	 */
	public int getPrice() {
		return this.price;
	}
	
	/**
	 * Name Getter
	 * @return - name of item
	 */
	public String getName() {
		return this.item;
	}
	
	@Override
	public String toString() {
		return String.format("%s Sell Price: $%d",this.item, this.sellPrice);
	}

}
