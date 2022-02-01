package tictactoe;

public class PlayerFactory {

	/**
	 * Factory of players
	 * 
	 * @param namePlayer: Name of the player playing
	 * @return instance of Player
	 */
	public Player buildPlayer(String namePlayer) {
		Player player = null;

		switch (namePlayer) {
		case "human":
			player = new HumanPlayer();
			break;
		case "clever":
			player = new CleverPlayer();
			break;
		case "whatever":
			player = new WhateverPlayer();
			break;
		}
		return player;
	}
}
