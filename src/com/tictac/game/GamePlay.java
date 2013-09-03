package com.tictac.game;

import java.io.IOException;

/**
 * This class is the main class of Tic-Tac program it calls TicTacControl class
 * 
 * @author pandiyaraja
 * 
 */

public class GamePlay {

	public static void main(String args[]) throws IOException {
		TicTacControl tc = new TicTacControl();
		tc.play();

	}

}
