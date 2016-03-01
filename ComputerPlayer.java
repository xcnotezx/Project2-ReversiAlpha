/*
 * represents a computer player of the game. Different computer
 * players use different methods to determine which move to make
 */

package reversi;

public abstract class ComputerPlayer extends Player {
	
	//contains the number of legal moves for the computer player
	private int numLegalMoves = 0;
	
	//the string containing list of all legal moves for computer player
	private String legalMoves = "";
	
	/*
	 * returns a String of legal moves available to the computer
	 * player. String length varies based on the number of legal
	 * moves. Each legal move follows the following format,
	 * where 'r' is a digit representing rows and 'c' is a
	 * digit representing columns.
	 * "r c,"
	 */
	public String findLegalMoves(reversiBoard b){
		for(int i = 1; i <= 8; i++){
			for(int j = 1; j <= 8; j++){
				if(b.isLegalMove(i, j, this.getPlayerName())){
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
		
	}//findLegalMoves(reversiBoard b)
	
	//returns number of legal moves for computer player
	public int getNumLegalMoves(){
		return numLegalMoves;
	}//getNumLegalMoves()
	
	public String getLegalMoves(){
		return legalMoves;
	}//getLegalMoves()
	
}//ComputerPlayer
