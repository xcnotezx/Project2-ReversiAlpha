/*
 *represents a player of the game
 */
public abstract class Player {
	//does not create objects AND/OR define methods
	final String player1 = "dark";
	final String player2 = "light";
	private String gamePiece = "dark";
	
	//switch game piece
	public void setGamePiece(String g) {
		this.gamePiece = g;
	}
	//return game piece
	public String getGamePiece() {
		return this.gamePiece;
	}
}
