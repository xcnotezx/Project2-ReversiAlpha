/**
 * Represents a computer player of reversi that determines which move
 * to make by randomly selecting from a list of legal reversi moves.
 * This player uses no strategy to play the game, but ensures that they
 * don't make illegal moves.
 */

import java.util.Random;

public class RandomComputerPlayer extends ComputerPlayer {
		
	Random generator = new Random();
	
	/**
	 * Character representation of player's name. Should be only 'X'
	 * or 'O'
	 */
	char playerName;
	
	/**
	 * Constructor for new IntelligentComputerPlayer object with
	 * name of p. P is not case sensitive, but should only take X
	 * or O
	 * 
	 * @author		John Carolin
	 * @author		Sinna Uy
	 * @param	p	Character representation of computer player name
	 * 				Is not case sensitive. Only accepts valid names of
	 * 				'x' or 'o'
	 */
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
	
	/**
	 * Returns char of player's name
	 * 
	 * @author	John Carolin
	 * @author	Sinna Uy
	 * @return	Character representation of player's name
	 */
	@Override
	public char getPlayerName(){
		return playerName;
	}//getPlayerName()
	
	/**
	 *Computer randomly selects a move from string of legal moves.
	 *
	 * @author		John Carolin
	 * @author		Sinna Uy
	 * @param	r	Reversi object representing game in progress
	 * @return		3 character string with digit representing row
	 *				at index 0, whitespace at index 1, and digit
	 *				representing column at index 2. If no legal moves,
	 *				returns empty string.
	 */
	@Override
	public String getMove(Reversi r){
		this.findLegalMoves(r);
		
		if(this.getNumLegalMoves() == 0){
			System.out.println("Player " + this.getPlayerName() + " has no legal moves. They forfeit their turn.");
			return "";
		}//if no legal moves
		else {
			
			
			int moveNumber = generator.nextInt(this.getNumLegalMoves()) + 1;
						
			String move = this.getLegalMoves().substring(((moveNumber -1) * 4), (moveNumber * 4) - 1);
			
			System.out.println("\nRandom Computer Player " + this.getPlayerName() + " moves: " + move);
			
			return move;
		}//else

	}//getMove()
	
}//RandomComputerPlayer
