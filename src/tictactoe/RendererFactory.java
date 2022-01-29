package tictactoe;

public class RendererFactory {

	public Renderer buildRenderer(String rendererName) {
		return new ConsoleRenderer();
	}
}
