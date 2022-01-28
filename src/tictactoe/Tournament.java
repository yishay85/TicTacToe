package tictactoe;

public class Tournament {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PlayerFactory play = new PlayerFactory();
		RendererFactory render = new RendererFactory();
		Player p1 = play.buildPlayer("human");
		Player p2 = play.buildPlayer("human");
		Renderer r1 = render.buildRenderer();
		Game g = new Game(p1, p2, r1);
		int count = 0;
		while (count < Board.WIN_STREAK) {
			Winner win = g.run();
			if (win == Winner.X_WIN)
				p1.setCountWin();
			else if (win == Winner.O_WIN)
				p2.setCountWin();
			count++;
			System.out.println(win);
		}
		System.out.println("Player1 as " + p1.getCountWin() + " win and Player2 as:" + p2.getCountWin() + " wins");

	}

}
