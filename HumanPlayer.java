/**
 * Extends the Player class and represents a human player
 * of the game playing on the console. Said human player must
 * have a keyboard in order to play.
 */

import java.util.Scanner;

public class HumanPlayer extends Player {
	
	Scanner keyboard = new Scanner(System.in);
	
	/**
	 * Character representation of player's name. Should be only 'X'
	 * or 'O'
	 */
	private char playerName;
	
	/**
	 * Constructor of HumanPlayer class. Creates a new HumanPlayer object
	 * with playerName set to be the character input. Input is not case
	 * sensitive
	 * 
	 * @author		John Carolin
	 * @author		Sinna Uy
	 * @param	p	Character representing player name. Should be either 'X'
	 * 				or 'O'.
	 */
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
	
	/**
	 * Returns the character representing the name of the player
	 * 
	 * @author	John Carolin
	 * @author	Sinna Uy
	 * @return	Character representing player name.
	 */
	public char getPlayerName(){
		return playerName;
	}//getPlayerName()
	
	/**
	 * Returns a String object containing the move to be made by the player
	 * 
	 * @author		John Carolin
	 * @author		Sinna Uy
	 * @param	r	the Reversi object representing the game in progress
	 * @return		3 character string with digit representing row
	 *				at index 0, whitespace at index 1, and digit
	 *				representing column at index 2. If no legal moves,
	 *				returns empty string.
	 */
	public String getMove(Reversi r){
		boolean isValidAndLegal = false;
		String input;
		
		this.findLegalMoves(r);
		
		if(this.getNumLegalMoves() == 0){
			System.out.println("Player " + this.getPlayerName() + " has no legal moves. They forfeit their turn.");
			return "";
		}//if(numLegalMoves == 0)
		else {
			do{
				System.out.print("Enter your move, " + playerName + " player: ");
				input = keyboard.nextLine();
				if(input.length() == 3){
					if(Character.isDigit(input.charAt(0)) && input.charAt(0) <= 8){
						if(Character.isWhitespace(input.charAt(1))){
							if(Character.isDigit(input.charAt(2)) && input.charAt(2) <= 8){
								if(r.isLegalMove(input.charAt(0), input.charAt(2), this.getPlayerName())){
									isValidAndLegal = true;
								}//Is valid input but illegal move
								else {
									System.out.println("Illegal move. Please try again.");
								}//Is valid input but illegal move
							}
							else {
								System.out.println("Invalid input. Please try again.");
							}
						}
						else {
							System.out.println("Invalid input. Please try again.");
						}
					}
					else {
						System.out.println("Invalid input. Please try again.");
					}
				}
				else {
					System.out.println("Invalid input. Please try again.");
				}
			} while(isValidAndLegal == false);
			
			return input;
		}//else
		
	}//getMove()

}//HumanPlayer
