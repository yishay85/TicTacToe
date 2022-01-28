package tictactoe;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1 = new Player();
		Player p2 = new Player();
		Renderer r1 = new Renderer();
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
