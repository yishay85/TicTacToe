package tictactoe;

/**
 * Interface for players
 * 
 * @author Yishay
 *
 */
public interface Player {

	/**
	 * play the turn of the player
	 * 
	 * @param mark:  The player's sign (X or O)
	 * @param board: The board of the game
	 */
	public void playTurn(Mark mark, Board board);

	/**
	 * 
	 * @return the amount of wins
	 */
	public int getCountWin();

	/**
	 * Count the player's victories
	 */
	public void setCountWin();
}
