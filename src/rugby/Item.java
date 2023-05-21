package rugby;

import java.util.HashMap;

public class Item {
	
	public String item;
	public HashMap<String, Integer> stats;
	public int price;
	public String[] attributes = new String[]{"Pace", "Passing", "Defence", "Tacking", "Ofense", "Fitness"};
	
	public Item(String item, int price, int[] value) {
		this.item = item;
		this.price = price;
		this.stats = new HashMap<String, Integer>();
		
		for (int i = 0; i < 6; i++) {
			this.stats.put(attributes[i], value[i]);
		}
	}
	
	public void useItem(Athlete athlete, Item item) {
		
		for (int i = 0; i < 6; i++) {
			athlete.stats.put(attributes[i], athlete.stats.get(attributes[i]) + (item.stats.get(attributes[i])));
		}
//		System.out.println("You have used item " + this.item + ", it has boosted your athletes stats by:");
//		printEffect();
	}
	
//	public void printEffect(){
//		for (int i = 0; i < 6; i++) {
//			if (this.stats.get(attributes[i]) > 0){
//				System.out.println(attributes[i] + ":" + this.stats.get(attributes[i]));
//			}
//		}
//	}
//	
	@Override
	public String toString() {
		return String.format("%s, %d",this.item, this.price);
	}
	
//	public void itemOptions() {
//		System.out.println("Options");
//	}
	public static void main(String[] args) {

	}

}
