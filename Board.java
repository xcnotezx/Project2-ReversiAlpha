/*
 *defines operations of a game board
 */
public interface Board {
	//interface does not define methods. implements will define the methods
	final int rows = 8;
	final int cols = 8;
	
	//intro
	public void intro();
	
	//menu: single OR 2 player game
	public int menu();
	
	//create grid OR board
	public void grid();
	
	//is the cpu making legal moves
	public boolean isMoveLegal(int row, int col, char move);
}
