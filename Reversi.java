/*
 *to hold a Reversi board
 */
public class Reversi implements Board {
	
	public String[][] grid = new String[Board.rows][Board.cols];
	
	//intro
	@Override
	public void intro() {
		System.out.println("\nWelcome to Reversi! Moves should be entered in \"[row] [column]\" format.");
	}
	//create grid OR board
	@Override
	public void grid() {
		
		//String temp = "";
		int rounds = 0;
		this.grid = new String[Board.rows][Board.cols];
		int numRow = 1;
    	int numCol = 1;
    	System.out.println("  1 2 3 4 5 6 7 8");
		for(int gridRows = 0; gridRows < Board.rows; gridRows++) {
		    for(int gridCols = 0; gridCols < Board.cols; gridCols++) {
			//ROW OF NUMBERS
		    	if(!(gridRows == Board.rows) && gridCols == 0) {
			    System.out.print(numRow + " .");
			    numRow++;
		    	}
		    	//RETURN EACH ROW
		    	if(gridCols == Board.cols - 1) {
			    System.out.println("");
		    	}
		    	else {
		    		//COL OF NUMBERS
		    		if((gridRows == 3 && gridCols == 2) || (gridRows == 4 && gridCols == 3)) {
		    			this.grid[gridRows][gridCols] = " X";
		    			System.out.print(this.grid[gridRows][gridCols]);
		    		}
		    		else if((gridRows == 3 && gridCols == 3) || (gridRows == 4 && gridCols == 2)) {
		    			this.grid[gridRows][gridCols] = " O";
		    			System.out.print(this.grid[gridRows][gridCols]);
		    		}
		    		//PLAYER OR CPU MOVE
		    		else if((gridRows == 2 && gridCols == 3) || (gridRows == 5 && gridCols == 2)) {
		    			this.grid[gridRows][gridCols] = " _";
		    			System.out.print(this.grid[gridRows][gridCols]);
		    		}
		    		else if(rounds == 0) {
		    			this.grid[gridRows][gridCols] = " .";
		    			System.out.print(this.grid[gridRows][gridCols]);
		    		}
		    	}
		    }
		}
	}
	//is the cpu making legal moves
	@Override
	public boolean isMoveLegal(int row, int col, char move) {
		boolean isMoveLegal = true;
		return isMoveLegal;
	}
	
	public static void main (String[] args) {
		
		Reversi board = new Reversi();
		board.intro();
		board.grid();
	}
}
