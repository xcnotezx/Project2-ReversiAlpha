/**
 * Represents a specific game of Reversi
 * 
 * @author John Carolin
 * @author Sinna Uy
 */
public class Reversi {

	
	
	/**
	 * Executes the Reversi game in the console. Arguments determine
	 * which players are playing in the given game.
	 * 
	 * @param args	String array of which players are playing in the
	 * 				game. Two inputs are expected. Valid inputs are
	 * 				"Human", "RandomComputerPlayer", and
	 * 				"IntelligentComputerPlayer". Inputs are not case
	 * 				sensitive.
	 */
	public static void main (String[] args) {
		
		Player player1;
		Player player2;
		
		if(args[0].equalsIgnoreCase("Human")){
			player1 = new HumanPlayer('X');
		}
		else if(args[0].equalsIgnoreCase("RandomComputerPlayer")){
			player1 = new RandomComputerPlayer('X');
		}
		else if(args[0].equalsIgnoreCase("IntelligentComputerPlayer")){
			player1 = new IntelligentComputerPlayer('X');
		}
		else{
			player1 = new HumanPlayer('X');
			System.out.println("Invalid input for player1 type. Options are \"Human\", \"RandomComputerPlayer\", and \"IntelligentComputerPlayer\".");
		}
		
		if(args[1].equalsIgnoreCase("Human")){
			player2 = new HumanPlayer('O');
		}
		else if(args[1].equalsIgnoreCase("RandomComputerPlayer")){
			player2 = new RandomComputerPlayer('O');
		}
		else if(args[1].equalsIgnoreCase("IntelligentComputerPlayer")){
			player2 = new IntelligentComputerPlayer('O');
		}
		else{
			player2 = new HumanPlayer('O');
			System.out.println("Invalid input for player2 type. Options are \"Human\", \"RandomComputerPlayer\", and \"IntelligentComputerPlayer\".");
		}
		
		ReversiBoard game = new ReversiBoard();
		
		System.out.println("Welcome to Reversi!\nMoves should be entered in \"[row]_[column]\" format.\n Good luck!");

		while((game.movesLeft() == true) && !player1.getMove(game).equals("") && !player2.getMove(game).equals("")){
			System.out.println(game);
			player1.getMove(game);
			System.out.println("The Score is: Player 1 " + game.getScore('X') +" Player 2 " +  game.getScore('O'));
			System.out.println(game);
			player2.getMove(game);
			System.out.println("The Score is: Player 1 " + game.getScore('X') +" Player 2 " +  game.getScore('O'));
				
		
				
//			while(game.power(true)) {
//			//PLAYER 1
//			String userInput = player1.getMove(game);
//			game.rowInput(userInput);
//			game.colInput(userInput);
//			game.board();
//			
//			//PLAYER 2
//			userInput = player2.getMove(game);
//			game.rowInput(userInput);
//			game.colInput(userInput);
//			game.board();
//			
		}
		System.out.println("There are no more available moves. Game Over");
		if(game.getScore('X') > game.getScore('Y')){
			System.out.println("Player 1 wins! Congratulations!");
		}
		else if(game.getScore('X') < game.getScore('Y')){
			System.out.println("Player 2 wins! Congratulations!");
		}
		else{
			System.out.println("Tie Game. Please play again!");
		}
	}
}
