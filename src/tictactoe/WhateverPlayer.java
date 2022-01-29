package tictactoe;

import java.util.Random;

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
			i = rand.nextInt(board.SIZE);
			j = rand.nextInt(board.SIZE);
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
