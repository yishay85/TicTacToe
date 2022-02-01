package tictactoe;

import java.util.Random;

/**
 * Auto player performance. Randomly selects a location on the board
 * 
 * @author Yishay
 *
 */
public class WhateverPlayer implements Player {

	private int countWin;
	private Random rand = new Random();

	public WhateverPlayer() {
		this.countWin = 0;
	}

	@Override
	public void playTurn(Mark mark, Board board) {
		int i, j;
		while (true) {
			i = rand.nextInt(Board.SIZE);
			j = rand.nextInt(Board.SIZE);
			if (board.getMark(i, j) == Mark.BLANK) {
				board.putMark(mark, i, j);
				return;
			}
		}

	}

	@Override
	public int getCountWin() {
		return countWin;
	}

	@Override
	public void setCountWin() {
		countWin++;
	}

}
