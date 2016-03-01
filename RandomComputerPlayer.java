/*
 * represents a computer player of reversi that determines which move
 * to make by randomly selecting from a list of legal reversi moves.
 * This player uses no strategy to play the game, but only ensures that they
 * don't make illegal moves.
 */

package reversi;

import java.util.Random;


public class RandomComputerPlayer extends ComputerPlayer {
	
	Random r = new Random();
	
	//char of 'X' or 'O' representing player name
	char playerName;
	
	//Creates a new RandomComputerPlayer object with a name of 'X' or 'O'
		RandomComputerPlayer(char p){
					
			if(p == 'X' || playerName == 'x'){
				playerName = 'X';
			}
			else if(p == 'O' || p == 'o'){
				playerName = 'O';
			}
			else{
				System.out.println("Invalid player name. The game will now exit");
				System.exit(0);;
			}	
		}//RandomComputerPlayer(char p)
	
	//returns char playerName
	public char getPlayerName(){
		return playerName;
	}//getPlayerName()
	
	/*
	 *computer randomly selects a move from string of legal moves
	 *@return: 3 character string with digit representing row
	 *at index 0, whitespace at index 1, and digit representing
	 *column at index 2
	 */
	public String getMove(reversiBoard b){
		
		this.findLegalMoves(b);
		
		int moveNumber = (int)(Math.random() * this.getNumLegalMoves()) + 1;		
		
		String move = this.getLegalMoves().substring(((moveNumber -1) * 4), (moveNumber * 4) - 1);
		
		return move;
	}//getMove()
	
}//RandomComputerPlayer
