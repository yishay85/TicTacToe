package tictactoe;

public class RendererFactory {

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
