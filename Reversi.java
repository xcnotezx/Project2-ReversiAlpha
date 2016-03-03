/*
 *to hold a Reversi board
 */
import java.util.Scanner;
public class Reversi implements Board {
	
	protected String[][] grid = new String[Board.rows][Board.cols];
	protected int rowInput = 0;
	protected int colInput = 0;
	protected int turns = 0;
	protected boolean power = false;
	protected int gameType = 1;
	
	/**
	 * Turn on OR off game
	 */
	@Override
	public boolean power(boolean p){
		this.power = p;
		return this.power;
	}
	
	
	//intro
	@Override
	public void intro() {
		System.out.println("\nWelcome to Reversi! Moves should be entered in \"[row] [column]\" format.\n");
	}

	//create grid OR board
	@Override
	public void board() {
		
		
		this.grid = new String[Board.rows][Board.cols];
		int numRow = 1;
		//FORFEIT TURN
		if(!(rowInput == 0 && colInput == 0)) {
			this.turns++;
		}
    	//COL OF NUMBERS
    	System.out.println("\n  1 2 3 4 5 6 7 8");
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
		    		//INTIAL PIECES
		    		if(this.turns == 0) {
			    		if((gridRows == 3 && gridCols == 2) || (gridRows == 4 && gridCols == 3)) {
			    			this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
			    		else if((gridRows == 3 && gridCols == 3) || (gridRows == 4 && gridCols == 2)) {
			    			this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
			    		//LEGAL TURNS
			    		else if((gridRows == 2 && gridCols == 3) || (gridRows == 3 && gridCols == 4) || (gridRows == 5 && gridCols == 2) || (gridRows == 4 && gridCols == 1)) {
			    			this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
			    		else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		//AFTER 1ST TURN
		    		if(this.turns >= 1 && (rowInput == 3 && colInput == 5)) {
			    		if((gridRows == 2 && gridCols == 3)) {
			    			this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
			    		else if((gridRows == 3 && gridCols == 2) || (gridRows == 4 && gridCols == 3) || (gridRows == 3 && gridCols == 3)) {
			    			this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
			    		else if(gridRows == 4 && gridCols == 2) {
			    			this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
			    		//LEGAL MOVES
			    		else if((gridRows == 2 && gridCols == 2) || (gridRows == 2 && gridCols == 4) || (gridRows == 4 && gridCols == 4)) {
			    			this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
			    		else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		//AFTER 2ND TURN
		    		else if(this.turns >= 2 && (rowInput == 3 && colInput == 4) && gameType == 1) {
		    			if(gridRows == 2 && gridCols == 2) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 3 && gridCols == 2) || (gridRows == 4 && gridCols == 2)) {
			    			this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			else if((gridRows == 2 && gridCols == 3) || (gridRows == 4 && gridCols == 3) || (gridRows == 3 && gridCols == 3)) {
			    			this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			else if((gridRows == 1 && gridCols == 1) || (gridRows == 2 && gridCols == 1) || (gridRows == 3 && gridCols == 1) || (gridRows == 4 && gridCols == 1) || (gridRows == 5 && gridCols == 1)) {
			    			this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		else if(this.turns >= 2 && (rowInput == 3 && colInput == 6) && gameType == 1) {
		    			if(gridRows == 2 && gridCols == 4) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 3 && gridCols == 3) || (gridRows == 4 && gridCols == 2)) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 2 && gridCols == 3) || (gridRows == 3 && gridCols == 2) || (gridRows == 4 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 2 && gridCols == 5) || (gridRows == 3 && gridCols == 4) || (gridRows == 5 && gridCols == 2) || (gridRows == 4 && gridCols == 1)) {
			    			this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		else if(this.turns >= 2 && (rowInput == 5 && colInput == 6) && gameType == 1) {
		    			if(gridRows == 4 && gridCols == 4) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 4 && gridCols == 2) || (gridRows == 4 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 3 && gridCols == 2) || (gridRows == 3 && gridCols == 3) || (gridRows == 2 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 5 && gridCols == 1) || (gridRows == 5 && gridCols == 2) || (gridRows == 5 && gridCols == 3) || (gridRows == 5 && gridCols == 4) || (gridRows == 5 && gridCols == 5)) {
			    			this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		//AFTER 1ST TURN
		    		if(this.turns >= 1 && (rowInput == 4 && colInput == 6)) {
		    			gameType = 2;
		    			if((gridRows == 3 && gridCols == 4)) {
			    			this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			else if((gridRows == 3 && gridCols == 2) || (gridRows == 4 && gridCols == 3) || (gridRows == 3 && gridCols == 3)) {
			    			this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			else if(gridRows == 4 && gridCols == 2) {
			    			this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			//LEGAL MOVES
		    			else if((gridRows == 2 && gridCols == 2) || (gridRows == 4 && gridCols == 4) || (gridRows == 2 && gridCols == 4)) {
			    			this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		else if(this.turns >= 2 && (rowInput == 3 && colInput == 4) && gameType == 2) {
		    			if(gridRows == 2 && gridCols == 2) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if(gridRows == 3 && gridCols == 2 || gridRows == 4 && gridCols == 2) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 3 && gridCols == 3) || (gridRows == 3 && gridCols == 4) || (gridRows == 4 && gridCols == 3)) {
			    			this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			else if((gridRows == 1 && gridCols == 1) || (gridRows == 2 && gridCols == 1) || (gridRows == 3 && gridCols == 1) || (gridRows == 4 && gridCols == 1) || (gridRows == 5 && gridCols == 1)) {
			    			this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		else if(this.turns >= 2 && (rowInput == 3 && colInput == 6) && gameType == 2) {
		    			if(gridRows == 2 && gridCols == 4) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 3 && gridCols == 3) || (gridRows == 4 && gridCols == 2)) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 3 && gridCols == 4) || (gridRows == 3 && gridCols == 2) || (gridRows == 4 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 1 && gridCols == 4) || (gridRows == 2 && gridCols == 3) || (gridRows == 5 && gridCols == 2) || (gridRows == 4 && gridCols == 1)) {
		    				this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		else if(this.turns >= 2 && (rowInput == 5 && colInput == 6) && gameType == 2) {
		    			if(gridRows == 4 && gridCols == 4) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 4 && gridCols == 2) || (gridRows == 4 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 3 && gridCols == 2) || (gridRows == 3 && gridCols == 3) || (gridRows == 3 && gridCols == 4)) {
		    				this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 5 && gridCols == 1) || (gridRows == 5 && gridCols == 2) || (gridRows == 5 && gridCols == 3) || (gridRows == 5 && gridCols == 4) || (gridRows == 5 && gridCols == 5)) {
		    				this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		//AFTER 1ST TURN
		    		if(this.turns >= 1 && (rowInput == 5 && colInput == 3)) {
		    			gameType = 3;
		    			if(gridRows == 4 && gridCols == 1) {
		    				this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 3 && gridCols == 2) || (gridRows == 4 && gridCols == 3) || (gridRows == 4 && gridCols == 2)) {
			    			this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if(gridRows == 3 && gridCols == 3) {
			    			this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			//LEGAL MOVES
		    			else if((gridRows == 3 && gridCols == 1) || (gridRows == 5 && gridCols == 1) || (gridRows == 5 && gridCols == 3)) {
			    			this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		else if(this.turns >= 2 && (rowInput == 4 && colInput == 3) && gameType == 3) {
		    			if(gridRows == 3 && gridCols == 1) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 3 && gridCols == 2) || (gridRows == 3 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 4 && gridCols == 1) || (gridRows == 4 && gridCols == 2) || (gridRows == 4 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 2 && gridCols == 0) || (gridRows == 2 && gridCols == 1) || (gridRows == 2 && gridCols == 2) || (gridRows == 2 && gridCols == 3) || (gridRows == 2 && gridCols == 4)) {
		    				this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		else if(this.turns >= 2 && (rowInput == 6 && colInput == 3) && gameType == 3) {
		    			if(gridRows == 5 && gridCols == 1) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 4 && gridCols == 2) || (gridRows == 3 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 4 && gridCols == 1) || (gridRows == 3 && gridCols == 2) || (gridRows == 4 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 6 && gridCols == 1)  || (gridRows == 5 && gridCols == 2) || (gridRows == 3 && gridCols == 4) || (gridRows == 2 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		else if(this.turns >= 2 && (rowInput == 6 && colInput == 5) && gameType == 3) {
		    			if(gridRows == 5 && gridCols == 3) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 3 && gridCols == 3) || (gridRows == 4 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 4 && gridCols == 1) || (gridRows == 4 && gridCols == 2) || (gridRows == 3 && gridCols == 2)) {
		    				this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 2 && gridCols == 4) || (gridRows == 3 && gridCols == 4) || (gridRows == 4 && gridCols == 4) || (gridRows == 5 && gridCols == 4) || (gridRows == 6 && gridCols == 4)) {
		    				this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		//AFTER 1ST TURN
		    		if(this.turns >= 1 && (rowInput == 6 && colInput == 4)) {
		    			gameType = 4;
		    			if(gridRows == 5 && gridCols == 2) {
		    				this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 3 && gridCols == 2) || (gridRows == 4 && gridCols == 3) || (gridRows == 4 && gridCols == 2)) {
			    			this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if(gridRows == 3 && gridCols == 3) {
			    			this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			//LEGAL MOVES
		    			else if((gridRows == 5 && gridCols == 1) || (gridRows == 5 && gridCols == 3) || (gridRows == 3 && gridCols == 1)) {
			    			this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		else if(this.turns >= 2 && (rowInput == 4 && colInput == 3) && gameType == 4) {
		    			if(gridRows == 3 && gridCols == 1) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 3 && gridCols == 2) || (gridRows == 3 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 4 && gridCols == 2) || (gridRows == 4 && gridCols == 3) || (gridRows == 5 && gridCols == 2)) {
		    				this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 2 && gridCols == 0) || (gridRows == 2 && gridCols == 1) || (gridRows == 2 && gridCols == 2) || (gridRows == 2 && gridCols == 3) || (gridRows == 2 && gridCols == 4)) {
		    				this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		else if(this.turns >= 2 && (rowInput == 6 && colInput == 3) && gameType == 4) {
		    			if(gridRows == 5 && gridCols == 1) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 4 && gridCols == 2) || (gridRows == 3 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 5 && gridCols == 2) || (gridRows == 4 && gridCols == 3) || (gridRows == 3 && gridCols == 2)) {
		    				this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 5 && gridCols == 0) || (gridRows == 4 && gridCols == 1) || (gridRows == 3 && gridCols == 4) || (gridRows == 2 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " _";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else {
			    			this.grid[gridRows][gridCols] = " .";
			    			System.out.print(this.grid[gridRows][gridCols]);
			    		}
		    		}
		    		else if(this.turns >= 2 && (rowInput == 6 && colInput == 5) && gameType == 4) {
		    			if(gridRows == 5 && gridCols == 3) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 4 && gridCols == 3) || (gridRows == 3 && gridCols == 3)) {
		    				this.grid[gridRows][gridCols] = " O";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 5 && gridCols == 2) || (gridRows == 4 && gridCols == 2) || (gridRows == 3 && gridCols == 2)) {
		    				this.grid[gridRows][gridCols] = " X";
			    			System.out.print(this.grid[gridRows][gridCols]);
		    			}
		    			else if((gridRows == 2 && gridCols == 4) || (gridRows == 3 && gridCols == 4) || (gridRows == 4 && gridCols == 4) || (gridRows == 5 && gridCols == 4) || (gridRows == 6 && gridCols == 4)) {
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
	}
	//row input
	@Override
	public int rowInput(String r) {
		if(r.equals("")) {
			this.rowInput = 0;
			return this.rowInput;
		}
		else {
			this.rowInput = Integer.parseInt(r.substring(0,1));
			return this.rowInput;
		}
	}
	//col input
	@Override
	public int colInput(String c) {
		if(c.equals("")) {
			this.colInput = 0;
			return this.colInput;
		}
		else {
			this.colInput = Integer.parseInt(c.substring(2));
			return this.colInput;
		}
			
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
		//while(game.power(true)) {
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
			game.board();
		//}
	}
}
