package com.tictac.game;

import static com.tictac.game.TicTacConstants.*;

/**
 * This class controls all the operations in this program
 * 
 * @author pandiyaraja
 * 
 */
public class TicTacControl {
	public TicTacData tdata = new TicTacData();
	public char[][] array = new char[ROW][COL];

	public TicTacControl() {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				array[i][j] = X;
			}
		}
		tdata = new TicTacData();
		tdata.setArray(array);
	}
	
	/**
	 * This method sets new array value and count value at new game starts.
	 */
	private void newData() {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				array[i][j] = X;
			}
		}
		tdata.setArray(array);
		tdata.setCOUNT(ZERO);
	}

	/**
	 * This method checks that each and every row, column, diagonals to check
	 * all are equal. if a row has a same value or column has a same value
	 * diagonals has a same value, it will return
	 * 
	 * @return status
	 */
	private boolean gameStatus() {

		int j = 0;
		boolean flag = false;
		char statusArray[][] = new char[ROW][COL];
		statusArray = tdata.getArray();
		for (int i = 0; i < ROW; i++) {
			if (statusArray[i][j] == statusArray[i][j + 1]
					&& statusArray[i][j + 1] == statusArray[i][j + 2]) {
				if (statusArray[i][j] == C) {
					System.out.println("Computer Win");
					tdata.setPalyer(COMPUTER);
					flag = true;
					break;
				} else if (statusArray[i][j] == O) {
					System.out.println("You Win");
					tdata.setPalyer(USER);
					flag = true;
					break;
				}

			} else if (statusArray[j][i] == statusArray[j + 1][i]
					&& statusArray[j + 1][i] == statusArray[j + 2][i]) {
				if (statusArray[j][i] == C) {
					System.out.println("Computer Win");
					tdata.setPalyer(COMPUTER);
					flag = true;
					break;
				} else if (statusArray[i][j] == O) {
					System.out.println("You Win");
					tdata.setPalyer(USER);
					flag = true;
					break;
				}
			}
		}
		if (flag == false) {
			int i = 0;
			if (statusArray[i][j] == statusArray[i + 1][j + 1]
					&& statusArray[i + 1][j + 1] == statusArray[i + 2][j + 2]) {
				if (statusArray[i][j] == C) {
					System.out.println("Computer Win");
					tdata.setPalyer(COMPUTER);
					flag = true;
				} else if (statusArray[i][j] == O) {
					System.out.println("You Win");
					tdata.setPalyer(USER);
					flag = true;
				}
			} else if (statusArray[i][j + 2] == statusArray[i + 1][j + 1]
					&& statusArray[i + 1][j + 1] == statusArray[i + 2][j]) {
				if (statusArray[i + 1][j + 1] == C) {
					System.out.println("Computer Win");
					tdata.setPalyer(COMPUTER);
					flag = true;
				} else if (statusArray[i + 1][j + 1] == O) {
					System.out.println("You Win");
					tdata.setPalyer(USER);
					flag = true;
				}
			}
		}
		if (flag == false && tdata.getCOUNT() == NINE) {
			System.out.println("!Oops game tied");
			flag = true;
			if (tdata.getPalyer().equalsIgnoreCase(COMPUTER)) {
				tdata.setPalyer(USER);
			} else {
				tdata.setPalyer(COMPUTER);
			}
		}
		return flag;
	}

	private void display() {

		char[][] rarray = tdata.getArray();
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				System.out.print(rarray[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * This method controls all the moves in this program
	 */
	public void play() {
		boolean status = false;
		boolean move = false;

		TicTacmediator tm;
		if (move == false) {
			tdata.setPalyer(COMPUTER);
			tdata.setArray(array);
			tdata.setMove(true);
			move = true;
		} else {
			tdata.setPalyer(COMPUTER);
			tdata.setArray(array);

		}
		do {
			game: for (int i = 1; i <= NINE; i++) {
				switch (i) {
				case 1: {
					tm = new TicTacmediator();

					if (tdata.getPalyer().equalsIgnoreCase(COMPUTER)) {
						System.out.println("computer");
						tdata.setCOUNT(ONE);
						tm.gameInput(tdata);
						tdata.setPalyer(USER);
						display();

					} else {
						System.out.println("users");
						tdata.setCOUNT(i);
						tm.userInput(tdata);
						tdata.setPalyer(COMPUTER);
					}
					break;
				}
				case 2: {
					tm = new TicTacmediator();

					if (tdata.getPalyer().equalsIgnoreCase(COMPUTER)) {
						tdata.setCOUNT(i);
						tm.gameInput(tdata);
						tdata.setPalyer(USER);
						display();
					} else {
						tdata.setCOUNT(i);
						tm.userInput(tdata);
						tdata.setPalyer(COMPUTER);
					}
					break;
				}
				case 3: {

					tm = new TicTacmediator();

					if (tdata.getPalyer().equalsIgnoreCase(COMPUTER)) {
						tdata.setCOUNT(i);
						tm.gameInput(tdata);
						tdata.setPalyer(USER);
						display();
					} else {
						tdata.setCOUNT(i);
						tm.userInput(tdata);
						tdata.setPalyer(COMPUTER);
					}
					break;
				}
				case 4: {

					tm = new TicTacmediator();

					if (tdata.getPalyer().equalsIgnoreCase(COMPUTER)) {
						tdata.setCOUNT(i);
						tm.gameInput(tdata);
						tdata.setPalyer(USER);
						display();
					} else {
						tdata.setCOUNT(i);
						tm.userInput(tdata);
						tdata.setPalyer(COMPUTER);
					}
					break;
				}
				case 5: {

					tm = new TicTacmediator();

					if (tdata.getPalyer().equalsIgnoreCase(COMPUTER)) {
						tdata.setCOUNT(i);
						tm.gameInput(tdata);
						display();
						status = gameStatus();
						if (status) {
							newData();
						} else {
							tdata.setPalyer(USER);
						}
					} else {
						tdata.setCOUNT(i);
						tm.userInput(tdata);
						status = gameStatus();
						if (status) {

							newData();
						} else {
							tdata.setPalyer(COMPUTER);
						}
					}
					break;
				}
				case 6: {

					tm = new TicTacmediator();

					if (tdata.getPalyer().equalsIgnoreCase(COMPUTER)) {
						tdata.setCOUNT(i);
						tm.gameInput(tdata);
						display();
						status = gameStatus();
						if (status) {

							newData();
						} else {
							tdata.setPalyer(USER);
						}
					} else {
						tdata.setCOUNT(i);
						tm.userInput(tdata);
						status = gameStatus();

						if (status) {

							newData();
						} else {
							tdata.setPalyer(COMPUTER);
						}
					}
					break;
				}
				case 7: {

					tm = new TicTacmediator();

					if (tdata.getPalyer().equalsIgnoreCase(COMPUTER)) {
						tdata.setCOUNT(i);
						tm.gameInput(tdata);

						display();
						status = gameStatus();
						if (status) {

							newData();
						} else {
							tdata.setPalyer(USER);
						}
					} else {
						tdata.setCOUNT(i);
						tm.userInput(tdata);
						status = gameStatus();

						if (status) {

							newData();
						} else {
							tdata.setPalyer(COMPUTER);
						}
					}
					break;
				}
				case 8: {

					tm = new TicTacmediator();

					if (tdata.getPalyer().equalsIgnoreCase(COMPUTER)) {
						tdata.setCOUNT(i);
						tm.gameInput(tdata);

						display();
						status = gameStatus();
						if (status) {

							newData();
						} else {
							tdata.setPalyer(USER);
						}
					} else {
						tdata.setCOUNT(i);
						tm.userInput(tdata);
						status = gameStatus();

						if (status) {

							newData();
						} else {
							tdata.setPalyer(COMPUTER);
						}
					}
					break;
				}
				case 9: {

					tm = new TicTacmediator();

					if (tdata.getPalyer().equalsIgnoreCase(COMPUTER)) {
						tdata.setCOUNT(i);
						tm.gameInput(tdata);
						display();
						status = gameStatus();
						if (status) {

							newData();
						}
					} else {
						tdata.setCOUNT(i);
						tm.userInput(tdata);
						status = gameStatus();
						if (status) {

							newData();
						}
					}
					break;
				}
				}
				if (status) {
					continue game;
				}
			}
		} while (status);
		
	}	
}
