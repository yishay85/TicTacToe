package tictactoe;

import java.util.Scanner;

/***
 * The class responsible for running the game
 * 
 * @author Yishay
 *
 */

public class Game {

	static Scanner scanner = new Scanner(System.in);

	private Player playerX, playerO;
	private Renderer renderer;

	public Game(Player playerX, Player playerO, Renderer renderer) {
		this.playerX = playerX;
		this.playerO = playerO;
		this.renderer = renderer;

	}

	/**
	 * A main method that runs the game and ensures that each player plays in turn.
	 * 
	 * @return The winner of the game (or drow)
	 */
	public Winner run() {
		Mark markXorO = Mark.X;
		Board board = new Board();
		do {
			if (markXorO == Mark.X)
				markXorO = turn(playerX, markXorO, board);
			else
				markXorO = turn(playerO, markXorO, board);
			renderer.renderBoard(board);
		} while (!board.isGameEnded());

		return board.GameStatus();
	}

	/**
	 * Switches the turn of one player to the other player
	 * 
	 * @param p:     The player
	 * @param mark:  The player's sign (X or O)
	 * @param board: The board of the game
	 * @return mark turn
	 */
	private Mark turn(Player p, Mark mark, Board board) {
		p.playTurn(mark, board);
		if (mark == Mark.X)
			return Mark.O;
		return Mark.X;
	}

}
