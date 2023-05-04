package rugby;

import java.util.HashMap;


public class Athlete {
	
	public String name;
	public String nickName = name;
	public HashMap<String, String> stats;
	public int wage;
	public int sellPrice;
	public int buyPrice;
	public int stamina = 100;
	public boolean injured = false;
	public String position;
	public int rarity;
	
	public Athlete(String name, int wage, int sellPrice, int buyPrice, boolean injured, String position, int rarity, String[] value) {
		this.name = name;
		this.wage = wage;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.position = position;
		this.rarity = rarity;
		this.stats = new HashMap<String, String>();
		
		String[] holder = new String[]{"Pace", "Passing", "Defence", "Tacking", "Ofense", "Fitness"};
		for (int i = 0; i < 6; i++) {
			this.stats.put(holder[i], value[i]);
		}
	}
	
	public void changeNickName(String changeName){
		this.nickName = changeName;
	}
	
	public void rest(){
		this.stamina = 100;
	}
	
	public void train(String stat){
		stats.put(stat, stats.get(stat) + 1);
	}
	
	public void changeValue(int changeValue) {
		this.sellPrice = changeValue;
	}
	
	public void injury() {
		this.injured = true;
	}
	
	public void reduceStamina(double value) {
		if (this.stamina - value < 0) {
			this.injury();
			this.stamina = 0;
		}
		else{
			String holder = this.stats.get("Fitness");
			this.stamina -= value / (Double.parseDouble(holder)/100);  
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tester = new String[]{"1", "2", "345", "54", "65", "70"};
		
		Athlete liam = new Athlete("liam", 10, 10, 10, false, "rb", 90, tester);
		liam.changeNickName("test");
		System.out.println(liam.stamina);
		liam.reduceStamina(20);
		System.out.println(liam.stamina);
		
	}

}
