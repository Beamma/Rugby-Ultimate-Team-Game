package rugby;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

/**
 * Class for the clubs team
 * @author sport Joel Bremner & Liam Ceelan-Thomas
 */
public class Team {
	public ArrayList<Athlete> players = new ArrayList<Athlete>();
	public String teamName;
	
	/**
	 * 
	 * @param athlete - athlete to add to team
	 * @return - Successful or not
	 */
	
	public boolean addPlayer(Athlete athlete){
		if (this.players.size() >= GameEnviroment.teamSize) {
			return false;
		}else {
			this.players.add(athlete);
			return true;
		}
	}
	
	/**
	 * 
	 * @param athlete - athlete to remove from team
	 */
	
	public void removePlayer(Athlete athlete) {
		if (this.players.contains(athlete)) {
			this.players.remove(athlete);
		}
	}
	
	/**
	 * 
	 * @param athlete1 - athlete to swap
	 * @param athlete2 - athlete to swap
	 */
	
	public void swapPlayer(Athlete athlete1, Athlete athlete2) {
		this.removePlayer(athlete2);
		this.addPlayer(athlete1);
	}
	
	/**
	 * 
	 * @return - players in team
	 */
	public ArrayList<Athlete> getAthletes(){
		return this.players;
	}
	
	/**
	 *  Reduces stamina of all athletes in team
	 */
	public void reduceStamina() {
		for (Athlete athlete: this.players) {
			athlete.reduceStamina();
		}
	}
	
	/**
	 * Returns all stamina of athletes in team to max
	 */
	public void maxStamina() {
		for (Athlete athlete: this.players) {
			athlete.rest();
		}
	}
	
	/**
	 * Check whether team is ready to play or not
	 * @return whether team is ready to play or not
	 */
	public boolean checkReady() {
		for (Athlete athlete: this.players) {
			if (athlete.injured == true | athlete.stamina == 0) {
				return false;
			}
		}
		if (this.getAthletes().size() < GameEnviroment.teamSize){
			return false;
		}
		return true;
	}
	

	/**
	 * Recalculate team ratings
	 * @param team - Object team to calculate rating
	 * @return new rating of team
	 */
	public int teamRating(Team team) {
		int overallRating = 0;
		for (int i = 0; i < GameEnviroment.teamSize; i++) {
			int a = team.players.get(i).rarity;
			overallRating += a;
		}
		return overallRating/GameEnviroment.teamSize;
	}
<<<<<<< HEAD
=======
	
	public static void main(String[] args) {
		
		}
>>>>>>> e8521fbb8edc1f7cb5e215cff4a9fd3b3fcdf054

}
