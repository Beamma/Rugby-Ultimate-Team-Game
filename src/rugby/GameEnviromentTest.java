package rugby;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GameEnviromentTest {
	private static GameEnviroment manager;
	
	@BeforeAll 
	public static void init(){
		//initiating game 
		manager = new GameEnviroment();
	}
	
	@Test
	public void setSeasonLength() {
		// checking if set season works
		manager.setSeasonLength(2);
		assertTrue(manager.getSeasonLength() == 2);
	}
	
	@Test
	public void setdifficulty() {
		// checking if set difficulty works
		manager.setDifficulty("1");
		assertTrue(manager.getDifficulty() == 1);
	}
	
	@Test
	public void setName() {
		// checking if set name works
		manager.setName("test");
		assertTrue(manager.getName() == "test");
	}
	
	@Test
	public void minusMoney() {
		// checking if minus money works
		manager.setMoney(1000);
		manager.minusMoney(100);
		assertTrue(manager.getMoney() == 900);
	}
	
	@Test
	public void addMoney() {
		// checking if add money works
		manager.setMoney(1000);
		manager.addMoney(100);
		assertTrue(manager.getMoney() ==1100);
	}
	
	@Test
	public void getMoney() {
		// checking if get money works
		manager.setMoney(1000);
		assertTrue(manager.getMoney() ==1000);
	}
	
	@Test
	public void setMoney() {
		// checking if set money works
		manager.setMoney(1000);
		assertTrue(manager.getMoney() == 1000);
	}
	
	@Test
	public void checkString() {
		// checking if it works for all types of strings
		String trueString = "liam";
		String falseStringNumber = "112";
		String falseStringSpecial = "1&*";
		String falseStringMix = "1&*we";
		assertTrue(manager.checkString(trueString));
		assertFalse(manager.checkString(falseStringNumber));
		assertFalse(manager.checkString(falseStringSpecial));
		assertFalse(manager.checkString(falseStringMix));
	}
	
}
