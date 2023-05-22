package rugby;
import java.util.ArrayList;
import java.util.Scanner;


public class Team {
	public ArrayList<Athlete> players = new ArrayList<Athlete>();
	public String teamName;
	
	public boolean addPlayer(Athlete athlete){
		if (this.players.size() >= GameEnviroment.teamSize) {
			return false;
		}else {
			this.players.add(athlete);
			return true;
		}
	}
	
	public void removePlayer(Athlete athlete) {
		if (this.players.contains(athlete)) {
			this.players.remove(athlete);
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
//		System.out.println("Your athletes all now fully rested and have max stamina");
	}
	
	public boolean checkReady() {
		for (Athlete athlete: this.players) {
			if (athlete.injured == true | athlete.stamina == 0) {
//				System.out.println("You cannot participate in a match as one or more of your players are injured please swap them out of your squad");
				return false;
			}
		}
		if (this.getAthletes().size() < GameEnviroment.teamSize){
			return false;
		}
		return true;
	}
	
//	public void printTeamInfo(){
//		for (Athlete athlete: this.players) {
//			System.out.println(athlete.stamina);
//		}
//	}
	
//	public Athlete selectAthlete() {
//		
//		int count = 0;
//		for (Athlete athlete: this.players) {
//			count += 1;
//			System.out.printf(String.valueOf(count) + ": " + athlete.nickName);
//			System.out.println();
//		}
//		
//		Scanner input = new Scanner(System.in);
//		System.out.println("Please Select One Of The Above Players:");
//		int athlete = input.nextInt();
//		return this.players.get(athlete-1);
//		
//	}
	
	public int teamRating(Team team) {
		int overallRating = 0;
		for (int i = 0; i < GameEnviroment.teamSize; i++) {
			int a = team.players.get(i).rarity;
			overallRating += a;
		}
		return overallRating/GameEnviroment.teamSize;
	}
	
	public static void main(String[] args) {
		}

}
