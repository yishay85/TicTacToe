package tictactoe;

/**
 * The class that serves as a human player. The user of the game chooses where
 * to put marks.
 * 
 * @author Yishay
 *
 */
public class HumanPlayer implements Player {
	private int countWin;

	public HumanPlayer() {
		this.countWin = 0;
	}

	@Override
	public void playTurn(Mark mark, Board board) {
		int row, col;
		do {
			System.out.println("Player" + mark + " turn: enter location: ");
			int loc = Game.scanner.nextInt();
			if (loc < 99) {
				col = (loc % 10) - 1;
				row = (loc / 10 % 10) - 1;
			} else
				col = row = -1;

		} while (!board.putMark(mark, row, col));
	}

	@Override
	public int getCountWin() {
		return countWin;
	}

	@Override
	public void setCountWin() {
		this.countWin++;
	}

}
