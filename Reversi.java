/*
 *to hold a Reversi board
 */
import java.util.Scanner;
public class Reversi implements Board {
	
	protected String[][] grid = new String[Board.rows][Board.cols];
	protected int rowInput = 0;
	protected int colInput = 0;
	
	//intro
	@Override
	public void intro() {
		System.out.println("\nWelcome to Reversi! Moves should be entered in \"[row] [column]\" format.\n");
	}
	
	//create grid OR board
	@Override
	public void board() {
		
		//String temp = "";
		int turns = 0;
		this.grid = new String[Board.rows][Board.cols];
		int numRow = 1;
    	//COL OF NUMBERS
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
		    		//BOARD CHANGES
		    		if((gridRows == 3 && gridCols == 2) || (gridRows == 4 && gridCols == 3)) {
		    			this.grid[gridRows][gridCols] = " X";
		    			System.out.print(this.grid[gridRows][gridCols]);
		    		}
		    		else if((gridRows == 3 && gridCols == 3) || (gridRows == 4 && gridCols == 2)) {
		    			this.grid[gridRows][gridCols] = " O";
		    			System.out.print(this.grid[gridRows][gridCols]);
		    		}
		    		//PLAYER OR CPU MOVE
		    		else if((gridRows == 2 && gridCols == 3) || (gridRows == 3 && gridCols == 4) || (gridRows == 5 && gridCols == 2) || (gridRows == 4 && gridCols == 1)) {
		    			this.grid[gridRows][gridCols] = " _";
		    			System.out.print(this.grid[gridRows][gridCols]);
		    		}
		    		else {
		    			this.grid[gridRows][gridCols] = " .";
		    			System.out.print(this.grid[gridRows][gridCols]);
		    		}
		    	}
		    }
		}
		
	}
	//row input
	@Override
	public int rowInput(String r) {
		this.rowInput = Integer.parseInt(r.substring(0,1));
		return this.rowInput;
	}
	//col input
	@Override
	public int colInput(String c) {
		this.colInput = Integer.parseInt(c.substring(2));
		return this.colInput;
	}
	
	//is the cpu making legal moves
	@Override
	public boolean isLegalMove(int row, int col, char move) {
		boolean isMoveLegal = true;
		return isMoveLegal;
	}
	
	public static void main (String[] args) {
		
		Reversi game = new Reversi();
		game.intro();
		game.board();
		//PLAYER 1
		if(args[0].equalsIgnoreCase("Human")) {
			Player humanPlayer = new HumanPlayer('X');
			String userInput = humanPlayer.getMove(game);
			game.rowInput(userInput);
			game.colInput(userInput);
		}
		else if(args[0].equalsIgnoreCase("RandomComputerPlayer")) {
			Player randomComputerPlayer = new RandomComputerPlayer('X');
		}
		else if(args[0].equalsIgnoreCase("IntelligentComputerPlayer")) {
			//Player intelligentComputerPlayer = new IntelligentComputerPlayer('X');
		}
		else {
			System.out.println("Usage: java Reversi [PLAYER1] [PLAYER2]");
			System.exit(0);
		}
		
		game.board();
		//PLAYER 2
		if(args[1].equalsIgnoreCase("Human")) {
			Player humanPlayer = new HumanPlayer('O');
			String userInput = humanPlayer.getMove(game);
			game.rowInput(userInput);
			game.colInput(userInput);
		}
		else if(args[1].equalsIgnoreCase("RandomComputerPlayer")) {
			Player randomComputerPlayer = new RandomComputerPlayer('O');
		}
		else if(args[1].equalsIgnoreCase("IntelligentComputerPlayer")) {
			//Player intelligentComputerPlayer = new IntelligentComputerPlayer('X');
		}
		else {
			System.out.println("Usage: java Reversi [PLAYER1] [PLAYER2]");
			System.exit(0);
		}
	}
}
