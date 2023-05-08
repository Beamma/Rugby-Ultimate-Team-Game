package rugby;
import java.util.ArrayList;
import java.util.Scanner;

public class Team {
	public ArrayList<Athlete> players = new ArrayList<Athlete>();
	private String teamName;
	private String seasonInfo;
	
	public void addPlayer(Athlete athlete){
		this.players.add(athlete);
		if (this.players.size() == 20) {
			System.out.println("Your team is already full, try swapping a player");
		}
	}
	
	public void removePlayer(Athlete athlete) {
		if (this.players.contains(athlete)) {
			this.players.remove(athlete);
		} else {
			System.out.println("The athlete you've chosen is not currently in the team.");
		}
	}
	
	public void swapPlayer(Athlete athlete1, Athlete athlete2) {
		this.removePlayer(athlete2);
		this.addPlayer(athlete1);
	}
	
	public ArrayList<Athlete> getAthletes(){
		return this.players;
	}
	
	public void reduceStamina() {
		for (Athlete athlete: this.players) {
			athlete.reduceStamina();
		}
	}
	
	public void maxStamina() {
		for (Athlete athlete: this.players) {
			athlete.rest();
		}
		System.out.println("Your athletes all now fully rested and have max stamina");
	}
	
	public boolean checkReady() {
		for (Athlete athlete: this.players) {
			if (athlete.injured == true) {
				System.out.println("You cannot participate in a match as one or more of your players are injured please swap them out of your squad");
				return false;
			}
		}
		return true;
	}
	
	public void printTeamInfo(){
		for (Athlete athlete: this.players) {
			System.out.println(athlete.stamina);
		}
	}
	
	public Athlete selectAthlete() {
		
		int count = 0;
		for (Athlete athlete: this.players) {
			count += 1;
			System.out.printf(String.valueOf(count) + ": " + athlete.nickName);
			System.out.println();
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please Select One Of The Above Players:");
		int athlete = input.nextInt();
		return this.players.get(athlete-1);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tester = new int[]{1, 2, 345, 54, 65, 20};
		Athlete joel = new Athlete("Joel", 10, 10, 10, false, "rb", 90, tester);
		joel.changeNickName("Joel");
		Athlete liam = new Athlete("Liam", 10, 10, 10, false, "rb", 90, tester);
		liam.changeNickName("Liam");
		Team hrfc =  new Team();
		hrfc.addPlayer(joel);
		hrfc.addPlayer(liam);
		
		hrfc.printTeamInfo();
		
		Athlete ed = new Athlete("Ed", 10, 10, 10, false, "rb", 90, tester);
		ed.changeNickName("ed");
		hrfc.swapPlayer(ed, liam);
		
		hrfc.printTeamInfo();
		
		Athlete a = hrfc.selectAthlete();
		System.out.println(a.nickName);
		
		hrfc.reduceStamina();
		hrfc.reduceStamina();

		
		
		
	}

}
