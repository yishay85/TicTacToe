package tictactoe;

public class RendererFactory {

	/**
	 * Factory of renderer
	 * 
	 * @param rendererName: Name of the renderer to show
	 * @return Instance of renderer
	 */
	public Renderer buildRenderer(String rendererName) {
		Renderer renderer = null;
		switch (rendererName) {
		case "console":
			renderer = new ConsoleRenderer();
			break;
		case "void":
			renderer = new VoidRenderer();
			break;
		}
		return renderer;
	}
}
