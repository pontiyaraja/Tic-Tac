package com.tictac.game;

import static com.tictac.game.TicTacConstants.*;

public class TicTacData {
	private int COUNT;
	private char[][] array = new char[ROW][COL];
	boolean move;
	String palyer;

	public int getCOUNT() {
		return COUNT;
	}

	public void setCOUNT(int cOUNT) {
		COUNT = cOUNT;
	}

	public char[][] getArray() {
		return array;
	}

	public void setArray(char[][] array) {
		this.array = array;
	}

	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public String getPalyer() {
		return palyer;
	}

	public void setPalyer(String palyer) {
		this.palyer = palyer;
	}

}
