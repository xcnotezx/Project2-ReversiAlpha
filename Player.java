/**
 *Represents a player of the game. 
 */

public abstract class Player {
	
	/**
	 * Integer containing number of legal moves for the Player
	 * object.
	 */
	private int numLegalMoves = 0;
	
	/**
	 * String containing a list of all legal moves for the Player
	 * object.
	 */
	private String legalMoves = "";
	
	/**
	 * Returns a string containing the entirety of the legal
	 * moves available to the player. Also updates the
	 * numLegalMoves variable with the updated number of legal
	 * moves.
	 * 
	 * @author 		John Carolin
	 * @author		Sinna Uy
	 * @param	b	reversiBoard object to be checked
	 * @return		String object containing all legal moves for
	 * 				Player object in the format 
	 * 				"r c,r c,r c,r c,..." where r is the row number 
	 * 				and c is the column number. String is empty if 
	 * 				there are no legal moves available.
	 */
	public String findLegalMoves(Reversi r){
		
		legalMoves = "";
		numLegalMoves = 0;
		
		for(int i = 1; i <= 8; i++){
			for(int j = 1; j <= 8; j++){
				if(r.isLegalMove(i, j, this.getPlayerName())){
					numLegalMoves ++;
					legalMoves.concat(String.valueOf(i));
					legalMoves.concat(String.valueOf(' '));
					legalMoves.concat(String.valueOf(j));
					legalMoves.concat(String.valueOf(','));
				}//if legal
				
			}// for loop j
			
		}//for loop i
		
		
		if(numLegalMoves <= 0){
			System.out.println(this.getPlayerName() + " player has no legal moves.");
		}//if no legal moves
		
		return legalMoves;
		
	}//findLegalMoves(reversiBoard b)
	
	/**
	 * Returns number of legal moves for player object
	 * 
	 * @author	John Carolin
	 * @author	Sinna Uy
	 * @return	number of legal moves for player object
	 */
	public int getNumLegalMoves(){
		return numLegalMoves;
	}//getNumLegalMoves()
	
	/**
	 * Returns string representation of legal moves for
	 * player object
	 * 
	 * @author 	John Carolin
	 * @author 	Sinna Uy
	 * @return	String object containing all legal moves for
	 * 			Player object in the format 
	 * 			"r c,r c,r c,r c,..." where r is the row number 
	 * 			and c is the column number. String is empty if 
	 * 			there are no legal moves available.
	 */
	public String getLegalMoves(){
		return legalMoves;
	}//getLegalMoves()
	
	/**
	 * Returns character representation of player's name.
	 * Should be either 'X' or 'O'.
	 * 
	 * @author	John Carolin
	 * @author	Sinna Uy
	 * @return	Character representation of player's name
	 */
	public abstract char getPlayerName();
	
	
	/**
	 * Returns string representation of the player's move.
	 * Determines player's move depending on what type of
	 * Player object calls the method
	 * 
	 * @author		John Carolin
	 * @param	r	Reversi object representing game in progress
	 */
	public abstract String getMove(Reversi r);
	
}//Player
