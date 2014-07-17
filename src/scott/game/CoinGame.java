package scott.game;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * A game where n number of coins are on the table. Two players take turns
 * removing 1, 3, or 4 coins. The player to remove the last coin from the table
 * wins.
 * 
 * This is a bottom-up solution to a problem given to me in a job interview. My
 * original attempt was a top-down recursive approach, but that turned out to be
 * a brute-force algorithm with O(2**n). This solution is O(3n), which is
 * acceptable performance.
 * 
 * Not threadsafe.
 * 
 * @author smalyszka
 * 
 */
public class CoinGame {

	// holds calculations of positions. k = num coins in position, v = it's a
	// winning position for player with current turn
	// Always ensure that keys 0..n are consecutive ints, leaving no gaps.
	private static SortedMap<Integer, Boolean> positionsMatrix = new TreeMap<Integer, Boolean>();

	// Per game rules, zero is the base case and indicates lose.
	static {
		positionsMatrix.put(0, false);
	}

	// list of possible moves, i.e. number of coins a player can remove in a
	// turn
	private static final int[] MOVES = { 1, 3, 4 };

	/**
	 * loads the positionsMatrix up to numCoins, ensuring no gaps in the keys
	 * from 0 to numCoins.
	 * 
	 * @param numCoins
	 *            the game position that we want to evaluate as winning or
	 *            losing
	 * @return true if numCoins is a winning position, false if not.
	 */
	public static boolean evaluatePosition(int numCoins) {

		// start at the next position to be evaluated
		int currentPosition = positionsMatrix.size();
		System.out.printf("evaluate %d starting at %d", numCoins,
				currentPosition);

		while (currentPosition <= numCoins) {
			// check possible moves at current position. If we can put the
			// opponent in a lose position from the current position, then
			// current position is a win. Otherwise it's a lose.
			for (int move : MOVES) {
				int candidate = currentPosition - move;
				if (positionsMatrix.containsKey(candidate)
						&& !positionsMatrix.get(candidate)) {
					positionsMatrix.put(currentPosition, true);
					break;
				}
			}
			// if we've fallen out of the loop without finding a winning
			// candidate, then current position is a lose
			if (!positionsMatrix.containsKey(currentPosition)) {
				positionsMatrix.put(currentPosition, false);
			}

			currentPosition++;
		}

		System.out.println("Finished evaluating positions. Matrix is "
				+ positionsMatrix);
		return positionsMatrix.get(numCoins);

	}

}
