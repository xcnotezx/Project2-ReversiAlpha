/**
 * This class acts as a representation of a board for a
 * Reversi game. This board is 8x8 in size and contains
 * game pieces represented by 'X' and 'O'.
 * 
 * @author John Carolin
 * @author Sinna Uy
 */
public class ReversiBoard implements Board {
	
	private char[][] board;
	
	/**
	 * Constructor for new ReversiBoard object. Constructs
	 * a new 8x8 board with the center squares already filled
	 * in properly.
	 * 
	 * @author John Carolin
	 * @author Sinna Uy
	 */
	public ReversiBoard(){
		board = new char[8][8];
		
		for(int i = 0; i <= 8; i++){
			for(int j = 0; j <= 8; j++){
				board[i][j] = '.';
			}
		}
		
		board[0][0] = ' ';
		board[0][1] = '1';
		board[0][2] = '2';
		board[0][3] = '3';
		board[0][4] = '4';
		board[0][5] = '5';
		board[0][6] = '6';
		board[0][7] = '7';
		board[0][8] = '8';
		board[1][0] = '1';
		board[2][0] = '2';
		board[3][0] = '3';
		board[4][0] = '4';
		board[5][0] = '5';
		board[6][0] = '6';
		board[7][0] = '7';
		board[8][0] = '8';
		board[4][4] = 'O';
		board[4][5] = 'X';
		board[5][4] = 'X';
		board[5][5] = 'O';
	}
	/**
	 * Returns a string representation of the current board.
	 * 
	 * @author 		John Carolin
	 * @author 		Sinna Uy
	 * @param	p	Player board is being printed for.
	 * @return 		String representation of the current board.
	 */
	@Override
	public String toString(char p){
		String b = "";
		for(int i = 0; i <= 8; i++){
			for(int j = 0; j <= 8; j++){
				if(board[i][j] == '.' && board.isLegalMove(i, j, p){
					b = b.concat("_ ");
				}
				else{
					b = b.concat(board[i][j] + " ");
				}
			}
			b = b.concat("\n");
		}
		return b;
	}
	
	/**
	 * Checks to see if there are still moves to be made on the board.
	 * Returns true if there are open spaces on the board and false
	 * otherwise.
	 * 
	 * @author 	John Carolin
	 * @author 	Sinna Uy
	 * @returns True if there are unoccupied spaces on the board and
	 * 			false otherwise.
	 */
	public boolean movesLeft(){
		boolean movesLeft = false;
		for(int i = 1; i <= 8; i++){
			for(int j = 1; j <= 8; j++){
				if(board[i][j] == '.'){
					movesLeft = true;
				}
			}
		}
		
		return movesLeft;
	}
	
	
	/**
	 * Checks to see if the specified move by the specified player
	 * is a legal move to make.
	 */
	public boolean isLegalMove(int row, int col, char p) {
		boolean legalMove = false;
		char otherPlayer;
		boolean legalSpace = false;
		boolean hasVerticalMove = false;
		boolean hasHorizontalMove = false;
		boolean hasDiagonalMove = false;
		
		if(p == 'X'){
			otherPlayer = 'Y';
		}
		else{
			otherPlayer = 'X';
		}
		
		//legalSpace
		if(row <= 8 && row >= 1 && col <= 8 && row >= 1){//space is on game board
			if(board[row][col] == '.'){//space is not occupied
				legalSpace = true;
			}//not occupied
		}//on board
		
		//hasVerticalMove down		
		if(board[row][col + 1] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row][col + i] == p){
					hasVerticalMove = true;
					break;
				}
				else if(board[row][col + i] == '.'){
					break;
				}
			}
		}
		
		//hasVerticalMove up
		if(board[row][col - 1] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row][col - i] == p){
					hasVerticalMove = true;
					break;
				}
				else if(board[row][col - i] == '.'){
					break;
				}
			}
		}
		
		//hasHorizontalMove left
		if(board[row - 1][col] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row - i][col] == p){
					hasHorizontalMove = true;
					break;
				}
				else if(board[row - i][col] == '.'){
					break;
				}
			}
		}
		
		//hasHorizontalMove right
		
		if(board[row + 1][col] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row + i][col] == p){
					hasHorizontalMove = true;
					break;
				}
				else if(board[row + i][col] == '.'){
					break;
				}
			}
		}
		
		//hasDiagonalMove up left
		if(board[row - 1][col - 1] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row - i][col - i] == p){
					hasDiagonalMove = true;
					break;
				}
				else if(board[row - i][col - i] == '.'){
					break;
				}
			}
		}
		
		//hasDiagonalMove down left
		if(board[row + 1][col - 1] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row + i][col - i] == p){
					hasDiagonalMove = true;
					break;
				}
				else if(board[row + i][col - i] == '.'){
					break;
				}
			}
		}
		
		//hasDiagonalMove up right
		if(board[row - 1][col + 1] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row - i][col + i] == p){
					hasDiagonalMove = true;
					break;
				}
				else if(board[row - i][col + i] == '.'){
					break;
				}
			}
		}
		
		//hasDiagonalMove down right
		if(board[row + 1][col + 1] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row + i][col + i] == p){
					hasDiagonalMove = true;
					break;
				}
				else if(board[row + i][col + i] == '.'){
					break;
				}
			}
		}
		
		if(legalSpace && (hasVerticalMove || hasHorizontalMove || hasDiagonalMove)){
			legalMove = true;
		}
		
		return legalMove;
		
	}
	
	/**
	 * Returns the score for the specified player. The score is the
	 * total number of squares that they control.
	 * 
	 * @param	p	Player to be scored
	 * @return		The score of the player, or number of squares that
	 * 				they control
	 */
	public int getScore(char p){
		int score = 0;
		for(int i = 1; i <= 8; i++){
			for(int j = 1; j <= 8; j++){
				if(board[i][j] == p){
					score++;
				}
			}
		}
		
		return score;
	}
	
	/**
	 * Makes a move in the specified location for the specified player.
	 * 
	 * @param	row	Row the move is made to
	 * @param	col	Column the move is made to
	 * @param	p	Player making the move
	 */
	public void makeMove(int row, int col, char p){
		char otherPlayer;
		
		boolean hasMoveUp = false;
		boolean hasMoveDown = false;
		boolean hasMoveLeft = false;
		boolean hasMoveRight = false;
		boolean hasMoveUpLeft = false;
		boolean hasMoveUpRight = false;
		boolean hasMoveDownLeft = false;
		boolean hasMoveDownRight = false;
		
		if(p == 'X'){
			otherPlayer = 'Y';
		}
		else{
			otherPlayer = 'X';
		}
		
		//hasMoveLeft
		if(board[row][col - 1] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row][col - i] == p){
					hasMoveLeft = true;
					break;
				}
				else if(board[row][col - i] == '.'){
					break;
				}
			}
		}
		
		//hasMoveRight	
		if(board[row][col + 1] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row][col + i] == p){
					hasMoveRight = true;
					break;
				}
				else if(board[row][col + i] == '.'){
					break;
				}
			}
		}
		
		//hasMoveUp
		if(board[row - 1][col] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row - i][col] == p){
					hasMoveUp = true;
					break;
				}
				else if(board[row - i][col] == '.'){
					break;
				}
			}
		}
		
		//hasMoveDown
		if(board[row + 1][col] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row + i][col] == p){
					hasMoveDown = true;
					break;
				}
				else if(board[row + i][col] == '.'){
					break;
				}
			}
		}
				
		//hasMoveUpLeft
		if(board[row - 1][col - 1] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row - i][col - i] == p){
					hasMoveUpLeft = true;
					break;
				}
				else if(board[row - i][col - i] == '.'){
					break;
				}
			}
		}
				
		//hasMoveDownLeft
		if(board[row + 1][col - 1] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row + i][col - i] == p){
					hasMoveDownLeft = true;
					break;
				}
				else if(board[row + i][col - i] == '.'){
					break;
				}
			}
		}
				
		//hasMoveUpRight
		if(board[row - 1][col + 1] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row - i][col + i] == p){
					hasMoveUpRight = true;
					break;
				}
				else if(board[row - i][col + i] == '.'){
					break;
				}
			}
		}
		
		//hasMoveDownRight
		if(board[row + 1][col + 1] == otherPlayer){
			for(int i = 2; i <= 7; i++){
				if(board[row + i][col + i] == p){
					hasMoveDownRight = true;
					break;
				}
				else if(board[row + i][col + i] == '.'){
					break;
				}
			}
		}
		
		if(this.isLegalMove(row, col, p)){
			if(hasMoveUp){
				for(int i = 1; i <= 7; i++){
					if(board[row - i][col] == otherPlayer){
						board[row - i][col] = p;
					}
					else{
						break;
					}
				}
			}
			
			if(hasMoveDown){
				for(int i = 1; i <=7; i++){
					if(board[row + i][col] == otherPlayer){
						board[row +i][col] = p;
					}
					else{
						break;
					}
				}
			}
			
			if(hasMoveLeft){
				for(int i = 1; i <= 7; i++){
					if(board[row][col - i] == otherPlayer){
						board[row][col - i] = p;
					}
					else{
						break;
					}
				}
			}
			
			if(hasMoveRight){
				for(int i = 1; i <= 7; i++){
					if(board[row][col + i] == otherPlayer){
						board[row][col + i] = p;
					}
					else{
						break;
					}
				}
			}
			
			if(hasMoveUpLeft){
				for(int i = 1; i <=7; i++){
					if(board[row - i][col - i] == otherPlayer){
						board[row - i][col - i] = p;
					}
					else{
						break;
					}
				}
			}
			
			if(hasMoveUpRight){
				for(int i = 1; i <= 7; i++){
					if(board[row - i][col + i] == otherPlayer){
						board[row - i][col + i] = p;
					}
					else{
						break;
					}
				}
			}
			
			if(hasMoveDownLeft){
				for(int i = 1; i <= 7; i++){
					if(board[row - i][col + i] == otherPlayer){
						board[row - i][col + i] = p;
					}
					else{
						break;
					}
				}
			}
			
			if(hasMoveDownRight){
				for(int i = 1; i <= 7; i++){
					if(board[row + i][col + i] == otherPlayer){
						board[row + i][col + i] = p;
					}
				}
			}
		}
		else{
			System.out.println("Illegal move that somehow wasn't caught. This turn is forefeit.");
		}
	}
	

}
