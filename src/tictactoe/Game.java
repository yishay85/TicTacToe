package tictactoe;

import java.util.Scanner;

public class Game {

	static Scanner scanner = new Scanner(System.in);

	private Player playerX, playerO;
	private Renderer renderer;

	public Game(Player playerX, Player playerO, Renderer renderer) {
		this.playerX = playerX;
		this.playerO = playerO;
		this.renderer = renderer;

	}

	public Winner run() {
		Mark markXorO = Mark.X;
		Board board = new Board();
		System.out.println("\nWalcam\n");
		do {
			if (markXorO == Mark.X)
				markXorO = turn(playerX, markXorO, board);
			else
				markXorO = turn(playerO, markXorO, board);
			renderer.renderBoard(board);
		} while (!board.isGameEnded());

		return board.GameStatus();
	}

	private Mark turn(Player p, Mark mark, Board board) {
		p.playTurn(mark, board);
		if (mark == Mark.X)
			return Mark.O;
		return Mark.X;
	}

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * Renderer testRenderer = new Renderer(); Board b = new Board(); Player p = new
	 * Player(); System.out.println(p.playTurn(Mark.X, b));
	 * System.out.println(b.putMark(Mark.X, 2, 0));
	 * System.out.println(b.putMark(Mark.O, 0, 0)); System.out.println(b.getMark(1,
	 * 0)); testRenderer.renderBoard(b); }
	 */
}
