package rugby;

import java.util.HashMap;

public class Item {
	
	public String item;
	public HashMap<String, String> stats;
	public int price;
	
	public Item(String item, int price, String[] value) {
		this.item = item;
		this.price = price;
		this.stats = new HashMap<String, String>();
		
		String[] holder = new String[]{"Pace", "Passing", "Defence", "Tacking", "Ofense", "Fitness"};
		for (int i = 0; i < 6; i++) {
			this.stats.put(holder[i], value[i]);
		}
	}
	
	public void useItem(Athlete athlete) {
		String[] holder = new String[]{"Pace", "Passing", "Defence", "Tacking", "Ofense", "Fitness"}; 
		for (int i = 0; i < 6; i++) {
			athlete.stats.put(athlete.stats.get(holder[i]), athlete.stats.get(holder[i]) + (this.stats.get(holder[i])));
		}
	}
	public static void main(String[] args) {
		
		String[] tester = new String[]{"1", "2", "345", "54", "65", "1"};
		Athlete liams = new Athlete("liam", 10, 10, 10, false, "rb", 90, tester);
		Item liam = new Item("liam", 90, tester);
		System.out.println(liams.stats);
		liam.useItem(liams);
		System.out.println(liams.stats);
	}

}
