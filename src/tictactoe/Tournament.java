package tictactoe;

/**
 * Main class responsible for creating players, game board and the game itself.
 * 
 * @author Yishay
 *
 */
public class Tournament {

	private Player player1, player2;
	private Renderer renderer;
	private int rounds;

	public Tournament(int rounds, Renderer renderer, Player player1, Player player2) {
		this.rounds = rounds;
		this.renderer = renderer;
		this.player1 = player1;
		this.player2 = player2;
	}

	/**
	 * creating players and renderer
	 * 
	 * @param args: [round count] [render target: console/void] [player:
	 *              human/clever/whatever/] [player: human/clever/whatever/]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 4) {
			System.err.println(
					"The number of arguments passed to the main function must be 4 arguments in the following format:\njava Tournament [round count] [render target: console/void] [player: human/clever/whatever/] [player: human/clever/whatever/] ");
			return;
		}
		int rounds;
		try {
			rounds = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.err.println("The first argument must have a number");
			return;
		}
		if (rounds <= 0) {
			System.err.println("The number of rounds must be greater than 0");
			return;
		}

		PlayerFactory play = new PlayerFactory();
		RendererFactory render = new RendererFactory();

		Renderer r1 = render.buildRenderer(args[1]);
		if (r1 == null) {
			System.err.println("The argument of renderer were wrong!!");
			return;
		}
		Player p1 = play.buildPlayer(args[2]);
		Player p2 = play.buildPlayer(args[3]);
		if (p1 == null || p2 == null) {
			System.err.println("There is no player by that name");
			return;
		}
		Tournament t1 = new Tournament(rounds, r1, p1, p2);

		int[] theWinner = t1.playTournament();

		System.out.println(
				"Player1: " + theWinner[1] + " win\nPlayer2: " + theWinner[2] + " wins\ndrow: " + theWinner[0]);

	}

	/**
	 * creating a tournament game
	 * 
	 * @return the result of the tournament
	 */
	public int[] playTournament() {
		int round = 0;
		int[] theWinner = { 0, 0, 0 };
		Game game = null;
		while (round < this.rounds) {
			if (round % 2 == 0)
				game = new Game(player1, player2, renderer);
			else
				game = new Game(player2, player1, renderer);
			Winner win = game.run();
			if ((win == Winner.X_WIN && round % 2 == 0) || (win == Winner.O_WIN && round % 2 == 1))
				player1.setCountWin();
			else if ((win == Winner.X_WIN && round % 2 == 1) || (win == Winner.O_WIN && round % 2 == 0))
				player2.setCountWin();
			else
				theWinner[0]++;
			round++;
		}
		theWinner[1] = player1.getCountWin();
		theWinner[2] = player2.getCountWin();

		return theWinner;
	}

}
