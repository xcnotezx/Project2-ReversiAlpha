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

public class IntelligentComputerPlayer extends ComputerPlayer {
	
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
	 * among all squares sharing that higher value.
	 * 
	 * @author		John Carolin
	 * @author		Sinna Uy
	 * @param	r	Reversi object representing game currently in
	 * 				progress
	 *@return		3 character string with digit representing row
	 *				at index 0, whitespace at index 1, and digit
	 *				representing column at index 2
	 */
	public String getMove(Reversi r){
		int bestMove = 0;
		int numBestMoves = 0;
		int moveNumber;
		String bestMoves = "";
		String legal = this.findLegalMoves(r);
		String move = "";
		if(this.getNumLegalMoves() == 0) {
			System.out.println("Player " + this.getPlayerName() + " has no legal moves. They forfeit their turn.");
			return move;
		}//if no legal moves
		else{
			int[] moveScores = new int[this.getNumLegalMoves()];
			
			for(int i = 0; i < moveScores.length; i++){
				if((legal.charAt(i*4) == 1 && legal.charAt((i*4) + 2) == 1) || (legal.charAt(i*4) == 8 && legal.charAt((i*4) + 2) == 1) || (legal.charAt(i*4) == 1 && legal.charAt((i*4) + 2) == 8) || (legal.charAt(i*4) == 8 && legal.charAt((i*4) + 2) == 8)){
					moveScores[i] = 4;
				}//if corner
				else if(legal.charAt(i*4) == 1 || legal.charAt(i*4) == 8 || legal.charAt((i*4) + 2) == 1 || legal.charAt((i*4) + 2) == 8){
					moveScores[i] = 3;
				}//else if edge
				else if(legal.charAt(i*4) == 2 || legal.charAt(i*4) == 7 || legal.charAt((i*4) + 2) == 2 || legal.charAt((i*4) + 2) == 7){
					moveScores[i] = 2;
				}//else if row/col 2 or 7
				else if(legal.charAt(i*4) == 3 || legal.charAt(i*4) == 6 || legal.charAt((i*4) + 2) == 3 || legal.charAt((i*4) + 2) == 6){
					moveScores[i] = 1;
				}//else if row/col 3 or 6
				else {
					moveScores[i] = 0;
				}//else if row/col 4 or 5 or unknown
			}//for
			
			for(int i = 0; i < moveScores.length; i++){
				if(moveScores[i] > bestMove){
					bestMove = moveScores[i];
				}//if greater than max, set to max
			}//for find bestMove
			
			
			
			for(int i = 0; i < moveScores.length; i++){
				if(moveScores[i] == bestMove){
					bestMoves = bestMoves.concat(legal.substring((i*4), ((i*4) + 4)));
				}//if best move, concatenate to bestMoves
			}//for find bestMoves
			
			numBestMoves = (bestMoves.length() / 4);
			
			moveNumber = (int)(Math.random() * numBestMoves) + 1;
			
			move = bestMoves.substring(((moveNumber -1) * 4), (moveNumber * 4) - 1);
			
			return move;
		}//else
		
	}//getMove(Reversi r)
	
}
