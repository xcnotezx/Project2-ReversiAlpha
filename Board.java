/*
 *defines operations of a game board
 */
public interface Board {
	//interface does not define methods. implements will define the methods
	final int rows = 8;
	final int cols = 8;
	
	//intro
	public abstract void intro();
	
	//create grid OR board
	public abstract void board();
	
	//row input
	public abstract String rowInput(String r);
	
	//col input
	public abstract String colInput(String c);
	
	//is the cpu making legal moves
	public abstract boolean isLegalMove(int row, int col, char move);
}
