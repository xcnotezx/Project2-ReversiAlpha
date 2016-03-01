/*
 * extends the Player class and represents a human player
 * of the game playing on the console. Said human player must
 * have a keyboard in order to play.
 */

package reversi;

import java.util.Scanner;

public class HumanPlayer extends Player {
	
	Scanner keyboard = new Scanner(System.in);
	
	//char of 'X' or 'O' representing player name
	private char playerName;
	
	//Creates a new HumanPlayer object with a name of 'X' or 'O'
	HumanPlayer(char p){
				
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
	}//HumanPlayer(char p)
	
	//getter class for the playerName variable
	public char getPlayerName(){
		return playerName;
	}//getPlayerName()
	
	/*
	 * Asks the "command line" for a move and returns a string representation
	 * of that move.
	 * @return: 3 character string with digit representing row
	 * at index 0, whitespace at index 1, and digit representing
	 * column at index 2
	 */
	public String getMove(reversiBoard b){
		boolean isValidMove = false;
		String input;
		
		do{
			System.out.print("Enter your move, " + playerName + " player: ");
			input = keyboard.nextLine();
			if(input.length() == 3){
				if(Character.isDigit(input.charAt(0)) && input.charAt(0) <= 8){
					if(Character.isWhitespace(input.charAt(1))){
						if(Character.isDigit(input.charAt(2)) && input.charAt(2) <= 8){
							isValidMove = true;
						}
						else {
							System.out.println("Invalid move. Please try again.");
						}
					}
					else {
						System.out.println("Invalid move. Please try again.");
					}
				}
				else {
					System.out.println("Invalid move. Please try again.");
				}
			}
			else {
				System.out.println("Invalid move. Please try again.");
			}
		} while(isValidMove == false);
		
		return input;

	}//getMove()

}//HumanPlayer
