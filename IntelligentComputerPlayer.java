/**
 * Represents a computer player of reversi that determines which move
 * to make by choosing the move that places a piece on the most valuable
 * square on the board. Value of squares is determined by their location
 * on the board. Corner squares are the most valuable, followed by edge
 * squares. Squares are progressively less valuable the further towards the
 * center of the board that they are. If there are multiple squares that are
 * legal moves of the same value, the computer picks the square at random
 * from among those squares.
 */

import java.util.Random;

public class IntelligentComputerPlayer extends ComputerPlayer {
	
	Random generator = new Random();
	
	/**
	 * Character representation of player's name
	 */
	private char playerName;
	
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
	IntelligentComputerPlayer(char p){				
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
	}//IntelligentComputerPlayer(char p)
	
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
	 * Returns an intelligently chosen move for the current
	 * player. Moves are chosen based on which legal move
	 * is the most valuable. Value is determined based on the
	 * location of the square in question. Certain squares, such
	 * as corners or edge squares are determined to be more
	 * valuable than others, such as interior squares. If multiple
	 * moves have the same value, then the move is chosen randomly
	 * among all squares sharing that higher value. Additional
	 * information can be found in the documentation of this
	 * program.
	 * 
	 * @author		John Carolin
	 * @author		Sinna Uy
	 * @param	r	Reversi object representing game currently in
	 * 				progress
	 *@return		3 character string with digit representing row
	 *				at index 0, whitespace at index 1, and digit
	 *				representing column at index 2
	 */
	@Override
	public String getMove(Reversi r){
		int bestMove = 0;
		int numBestMoves = 0;
		int moveNumber;
		String bestMoves = "";
		String legalMoves = this.findLegalMoves(r);
		String move = "";
		if(this.getNumLegalMoves() == 0) {
			System.out.println("Player " + this.getPlayerName() + " has no legal moves. They forfeit their turn.");
			return move;
		}//if no legal moves
		else{
			int[] moveScores = new int[this.getNumLegalMoves()];
			
			for(int i = 0; i < moveScores.length; i++){
				if((legalMoves.charAt(i*4) == 49 && legalMoves.charAt((i*4) + 2) == 49) || (legalMoves.charAt(i*4) == 56 && legalMoves.charAt((i*4) + 2) == 49) || (legalMoves.charAt(i*4) == 49 && legalMoves.charAt((i*4) + 2) == 56) || (legalMoves.charAt(i*4) == 56 && legalMoves.charAt((i*4) + 2) == 56)){ //If corner
					moveScores[i] = 4;
				}//if corner(1 1, 1 8, 8 1, 8 8)
				else if(legalMoves.charAt(i*4) == 49 || legalMoves.charAt(i*4) == 56 || legalMoves.charAt((i*4) + 2) == 49 || legalMoves.charAt((i*4) + 2) == 56){ //If edge
					moveScores[i] = 3;
				}//else if edge(row/col 1/8)
				else if(legalMoves.charAt(i*4) == 50 || legalMoves.charAt(i*4) == 55 || legalMoves.charAt((i*4) + 2) == 50 || legalMoves.charAt((i*4) + 2) == 55){ //If 7/2
					moveScores[i] = 2;
				}//else if row/col 2/7
				else if(legalMoves.charAt(i*4) == 51 || legalMoves.charAt(i*4) == 54 || legalMoves.charAt((i*4) + 2) == 51 || legalMoves.charAt((i*4) + 2) == 54){ //If 3/6
					moveScores[i] = 1;
				}//else if row/col 3/6
				else { //If 4/5 or otherwise
					moveScores[i] = 0;
				}//else if row/col 4/5 or unknown
			}//for
			
			for(int i = 0; i < moveScores.length; i++){
				if(moveScores[i] > bestMove){
					bestMove = moveScores[i];
				}//if greater than max, set to max
			}//for find bestMove
			
			
			
			for(int i = 0; i < moveScores.length; i++){
				if(moveScores[i] == bestMove){
					bestMoves = bestMoves.concat(legalMoves.substring((i*4), ((i*4) + 4)));
				}//if best move, concatenate to bestMoves
			}//for find bestMoves
			
			numBestMoves = (bestMoves.length() / 4);
			
			moveNumber = generator.nextInt(numBestMoves) + 1;
			
			move = bestMoves.substring(((moveNumber -1) * 4), (moveNumber * 4) - 1);
			
			System.out.println("\nIntelligent Computer Player " + this.getPlayerName() + " moves: " + move);
			
			return move;
		}//else
		
	}//getMove(Reversi r)
	
}
