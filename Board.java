/**
 *Acts as an interface for a generic game board.
 */

public interface Board {
	/**
	 * index of the last row of the game board.
	 */
	final int rows = 8;
	
	/**
	 * index of the last column of the game board.
	 */
	final int cols = 8;

	/**
	 * Turn on OR off game
	 */
	public abstract boolean power(boolean p);
	
	/**
	 * Prints an introductory message for the game. The
	 * message is unique to the game that is being
	 * played
	 * 
	 * @author	John Carolin
	 * @author	Sinna Uy
	 */
	public abstract void intro();
	
	/**
	 * Constructs a new board object
	 */
	public abstract void board();
	
	/**
	 * Parses a string in the format specified in the
	 * Player class and returns an integer representation
	 * of the row of the board specified
	 * 
	 * @param 	r	String in the format specified by the
	 * 			getMove() method in the Player class
	 * @return		Returns an integer representation of
	 * 			the row specified by the String input
	 */
	public abstract int rowInput(String r);
	
	/**
	 * Parses a string in the format specified in the
	 * Player class and returns an integer representation
	 * of the row of the board specified
	 * 
	 * @param 	r	String in the format specified by the
	 * 			getMove() method in the Player class
	 * @return		Returns an integer representation of
	 * 			the row specified by the String input
	 */
	public abstract int colInput(String c);
	
	/**
	 * Checks to see if the specified player is making a legal
	 * move. Returns true if they are and false if not.
	 * 
	 * @param row	Row that the move is made to
	 * @param col	Column that the move is made to
	 * @param move	Player making the move
	 * @return	True if move is legal, false otherwise
	 */
	public abstract boolean isLegalMove(int row, int col, char move);
}

