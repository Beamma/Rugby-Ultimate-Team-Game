package rugby;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;  

public class RandomEvent {
	public int event = 0;
	
	public static void randomEvents(int randnomness) {
		
		Random rand = new Random();  
		int event = rand.nextInt(randnomness);
		
		if (event == 1) {
			newPlayer();
		}else if (event == 2){
			playerLeaves();
		}else if (event == 3){
			playerInjured();
		}
	}
	
	public static void newPlayer(Team team){
		Athlete holder = GameEnviroment.generatePlayer();
		if (team.players.size() < 20) {
			team.players.add(holder);
			System.out.println("add");
		}else {
			System.out.println("your team is full if u wish swap out a player, enter number of player. if not enter 0");
			team.printTeamInfo();
			Scanner input = new Scanner(System.in);
			String  userName = input.nextLine();
			int holder2 = Integer.parseInt(userName);
			if (holder2 != 0) {
				Athlete swap = team.players.get(holder2-1);
				team.swapPlayer(holder, swap);
			}
		}
	}
	
	public static void playerLeaves(Team team){
		Athlete remove = getRandomPlayer(team);
		team.removePlayer(remove);
	}
	
	public static void playerInjured(Team team){
		Athlete injur = getRandomPlayer(team);
		injur.injured = true;
	}
	
	public static Athlete getRandomPlayer(Team team) {
		ArrayList<Athlete> athletes = team.getAthletes();
		Random rand = new Random();  
		int event = rand.nextInt(athletes.size()-1);
		return (athletes.get(event));
	}
	
	public static void main(String[] args) {
		Athlete ed = GameEnviroment.generatePlayer();
		Athlete eds = GameEnviroment.generatePlayer();
		Team hrfc =  new Team();
		hrfc.addPlayer(ed);
		hrfc.addPlayer(eds);
		ArrayList<Athlete> a = hrfc.getAthletes();
		hrfc.printTeamInfo();
		newPlayer(hrfc);
		hrfc.printTeamInfo();
		playerLeaves(hrfc);
		hrfc.printTeamInfo();
	}
	
}
