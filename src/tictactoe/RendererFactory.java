package tictactoe;

public class RendererFactory {

	public Renderer buildRenderer() {
		return new ConsoleRenderer();
	}
}
