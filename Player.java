/*
 *Represents a player of the game
 */

package reversi;

public abstract class Player {
	
	/*
	 * getter method for playerName variable
	 * returns char playerName.
	 */
	public abstract char getPlayerName();
	
	/*
	 * Method asks player object for their move and returns a string
	 * containing move. Format for the string is that the string is
	 * exactly 3 characters, has a char digit representing rows at
	 * index 0, whitespace at index 1, and a char digit representing
	 * columns at index 2.
	 */
	public abstract String getMove(reversiBoard b);
	
}//Player
