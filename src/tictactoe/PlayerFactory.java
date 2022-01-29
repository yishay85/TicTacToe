package tictactoe;

public class PlayerFactory {

	public Player buildPlayer(String namePlayer) {
		Player player = null;

		switch (namePlayer) {
		case "human":
			player = new HumanPlayer();
			break;
		case "clever":
			break;
		case "whatever":
			player = new WhateverPlayer();
			break;
		}
		return player;
	}
}
