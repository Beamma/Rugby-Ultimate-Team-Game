package rugby;
import java.util.ArrayList;

public class Team {
	private ArrayList<Athlete> players = new ArrayList<Athlete>();
	private String teamName;
	private String seasonInfo;
	
	public void addPlayer(Athlete athlete){
		this.players.add(athlete);
	}
	
	public void removePlayer(Athlete athlete) {
		this.players.remove(athlete);
	}
	
	public void swapPlayer(Athlete athlete1, Athlete athlete2) {
		this.removePlayer(athlete2);
		this.addPlayer(athlete1);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Athlete joel = new Athlete();
		Team hrfc =  new Team();
		hrfc.addPlayer(joel);
		System.out.println(hrfc.players);
	}

}
