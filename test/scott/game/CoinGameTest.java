package scott.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinGameTest {

	@Test
	public void testEvaluatePosition() {

		// end-game positions
		assertFalse("0", CoinGame.evaluatePosition(0));
		assertTrue("1", CoinGame.evaluatePosition(1));
		assertFalse("2", CoinGame.evaluatePosition(2));
		assertTrue("3", CoinGame.evaluatePosition(3));
		assertTrue("4", CoinGame.evaluatePosition(4));

		// penultimate positions
		assertTrue("5", CoinGame.evaluatePosition(5));
		assertTrue("6", CoinGame.evaluatePosition(6));
		assertFalse("7", CoinGame.evaluatePosition(7));
		assertTrue("8", CoinGame.evaluatePosition(8));

		// Test higher positions. Heuristically, we find that any multiple of 7
		// or a multiple of 7 plus 2 is a losing position.
		assertFalse("9", CoinGame.evaluatePosition(9));
		assertTrue("10", CoinGame.evaluatePosition(10));
		assertTrue("11", CoinGame.evaluatePosition(11));
		assertTrue("20", CoinGame.evaluatePosition(20));
		assertFalse("21", CoinGame.evaluatePosition(21));
		assertTrue("29", CoinGame.evaluatePosition(29));
		assertFalse("44", CoinGame.evaluatePosition(44));
		assertTrue("71", CoinGame.evaluatePosition(71));
		assertFalse("100", CoinGame.evaluatePosition(100));
		
	}

}
