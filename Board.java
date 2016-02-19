/*
 *defines operations of a game board
 */
public interface Board {
	//interface does not define methods. implements will define the methods
	final int row = 8;
	final int col = 8;
	
	//create grid OR board
	public void grid();
	//check board for out of bounds
	public boolean outOfBounds();
}
