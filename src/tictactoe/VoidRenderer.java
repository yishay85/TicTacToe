package tictactoe;

/**
 * In automatic games we would like to skip the board printing so this class
 * does nothing.
 * 
 * @author Yishay
 *
 */
public class VoidRenderer implements Renderer {

	@Override
	public void renderBoard(Board board) {
	}

}
