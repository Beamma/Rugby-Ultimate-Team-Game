package rugby;

import java.util.HashMap;

public class Item {
	
	public String item;
	public HashMap<String, Integer> stats;
	public int price;
	String[] attributes = new String[]{"Pace", "Passing", "Defence", "Tacking", "Ofense", "Fitness"};
	
	public Item(String item, int price, int[] value) {
		this.item = item;
		this.price = price;
		this.stats = new HashMap<String, Integer>();
		
		for (int i = 0; i < 6; i++) {
			this.stats.put(attributes[i], value[i]);
		}
	}
	
	public void useItem(Athlete athlete) { /* make this method return a string saying " used <item name> boosting his <stat> stat by <value> */
		
		for (int i = 0; i < 6; i++) {
			athlete.stats.put(attributes[i], athlete.stats.get(attributes[i]) + (this.stats.get(attributes[i])));
		}
		System.out.println("You have used item " + this.item + ", it has boosted your athletes stats by:");
		printEffect();
	}
	
	public void printEffect(){
		for (int i = 0; i < 6; i++) {
			if (this.stats.get(attributes[i]) > 0){
				System.out.println(attributes[i] + ":" + this.stats.get(attributes[i]));
			}
		}
	}
	public static void main(String[] args) {
		
		int[] tester = new int[]{1, 0, 3, 4, 6, 5};
		int[] tester2 = new int[]{60, 60, 60, 60, 60, 60};
		Athlete liams = new Athlete("liam", 10, 10, 10, false, "rb", 90, tester2);
		Item liam = new Item("liam", 90, tester);
		System.out.println(liams.stats);
		liam.useItem(liams);
		System.out.println(liams.stats);
	}

}
