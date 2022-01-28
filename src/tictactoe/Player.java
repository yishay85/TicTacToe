package tictactoe;

public interface Player {

	public void playTurn(Mark mark, Board board);

	public int getCountWin();

	public void setCountWin();
}
