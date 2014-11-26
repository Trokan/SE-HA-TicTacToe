import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TicTacToeUnitTest {
	
	Board board1 = new Board();
	
	//leeres Board - keine Gewinner
	@Test
	public void TestNoBoard() {
		assertFalse(board1.hasWinner());
		System.out.println("*************Ende TestNoBoard*************");
	}
	
	//gültige Markierung setzen - keine Gewinner
	@Test
	public void TestMarkNoWinner() throws InvalidPositionException{
		board1.setMark("X", 0, 0);
		board1.setMark("O", 1, 0);
		board1.setMark("X", 2, 0);
		board1.setMark("O", 0, 1);
		board1.setMark("O", 1, 1);
		board1.setMark("X", 2, 1);
		board1.setMark("X", 0, 2);
		board1.setMark("X", 1, 2);
		board1.setMark("O", 2, 2);
		assertFalse(board1.hasWinner());
		System.out.println("*************Ende TestMarkNoWinner*************");
	}
	
	//gültige Markierung setzen - mit Gewinner
	@Test
	public void TestMarkWithWinner() throws InvalidPositionException{
		board1.setMark("X", 0, 0);
		board1.setMark("X", 1, 0);
		board1.setMark("X", 2, 0);
		assertTrue(board1.hasWinner());
		System.out.println("*************Ende TestMarkWithWinner*************");
	}
	
	//ungültige Markierung setzen
	@Test (expected = InvalidPositionException.class) //Achtung umgekehrte Logik: Es ist gut wenn eine Exception geworfen wird bei einer Falschen eingabe. Daher wird dieser Test bestanden!
	public void TestFalseMark() throws InvalidPositionException{
		board1.setMark("A", 0, 1);		
		System.out.println("*************Ende TestFalseMark*************");
	}

	

}
