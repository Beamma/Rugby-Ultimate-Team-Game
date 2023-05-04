package rugby;

import java.util.Map;

public class Athlete {
	
	public String name;
	public String nickName;
	public Map<String, String> stats;
	public int wage;
	public int sellPrice;
	public int buyPrice;
	public int stamina = 100;
	public boolean injured;
	public String position;
	public int rarity;
	
	/*public Athlete(String name, String nickName, int wage, int sellPrice, int buyPrice, int stamina, boolean injured, String position, int rarity)*/
	
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
	
	public void reduceStamina(int value) {
		if (this.stamina - value < 0) {
			this.injury();
			this.stamina = 0;
		}
		else {
			this.stamina = value;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Athlete liam = new Athlete();
		liam.changeNickName("test");
		liam.changeNickName("tests");
		System.out.println(liam.injured);
		System.out.println(liam.stamina);
		liam.reduceStamina(101);
		System.out.println(liam.nickName);
		System.out.println(liam.injured);
		System.out.println(liam.stamina);
		
	}

}
