package com.tictac.game;

import static com.tictac.game.TicTacConstants.*;

import java.util.Random;
import java.util.Scanner;

public class TicTacmediator extends TicTacControl {

	private Random random;
	private String[][] array;

	public void userInput(TicTacData tdata) {
		array = tdata.getArray();
		Scanner scan = new Scanner(System.in);
		correct: for (int row = 0; row < ROW; row++) {

			for (int col = 0; col < COL; col++) {

				String c = scan.next();
				if (c.equalsIgnoreCase(O) || c.equalsIgnoreCase(X)
						|| c.equalsIgnoreCase(C)) {
					if (array[row][col].equalsIgnoreCase(C)) {
						array[row][col] = C;
					} else if (array[row][col].equalsIgnoreCase(O)) {
						array[row][col] = O;
					} else if (array[row][col].equalsIgnoreCase(X)) {
						array[row][col] = c;
					}
				} else {
					System.out.println("WRONG INPUT");
					continue correct;
				}

			}
		}
		tdata.setArray(array);
	}

	public void gameInput(TicTacData tdata) {
		if (tdata.getCOUNT() == ONE) {
			array = tdata.getArray();
			random = new Random();
			array[random.nextInt(ROW - 1)][random.nextInt(COL - 1)] = C;
			tdata.setArray(array);
		} else {
			array = tdata.getArray();
			boolean check = false;
			check = rowCheck(tdata, array);
			if (check == false) {
				check = colCheck(tdata, array);
			}
			if (check == false) {
				check = diagonalsCheck(tdata, array);
			}
			if (check == false) {
				check = rowCheckAgain(tdata, array);
			}
			if (check == false) {
				check = colCheckAgain(tdata, array);
			}
			if (check == false) {
				check = diagonalsCheckAgain(tdata, array);
			}
		}

	}

	private boolean diagonalsCheckAgain(TicTacData tdata, String[][] array) {
		boolean flag = false;
		int i = 0, j = 0;
		if (array[i][j + 2].equalsIgnoreCase(C)
				&& array[i + 1][j + 1].equalsIgnoreCase(X)
				&& array[i + 2][j].equalsIgnoreCase(X)) {
			array[i + 2][j] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2].equalsIgnoreCase(X)
				&& array[i + 1][j + 1].equalsIgnoreCase(X)
				&& array[i + 2][j].equalsIgnoreCase(C)) {
			array[i][j + 2] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2].equalsIgnoreCase(X)
				&& array[i + 1][j + 1].equalsIgnoreCase(C)
				&& array[i + 2][j].equalsIgnoreCase(X)) {
			array[i][j + 2] = C;
			flag = true;
			tdata.setArray(array);
		}
		return flag;
	}

	private boolean colCheckAgain(TicTacData tdata, String[][] array) {
		int j = 0;
		boolean flag = false;
		for (int i = 0; i < ROW; i++) {
			if (array[j][i].equalsIgnoreCase(C)
					&& array[j + 1][i].equalsIgnoreCase(X)
					&& array[j + 2][i].equalsIgnoreCase(X)) {
				array[j + 2][i] = C;
				flag = true;
				break;
			} else if (array[j][i].equalsIgnoreCase(X)
					&& array[j + 1][i].equalsIgnoreCase(X)
					&& array[j + 2][i].equalsIgnoreCase(C)) {
				array[j][i] = C;
				flag = true;
				break;
			} else if (array[j][i].equalsIgnoreCase(X)
					&& array[j + 1][i].equalsIgnoreCase(C)
					&& array[j + 2][i].equalsIgnoreCase(X)) {
				array[j][i] = C;
				flag = true;
				break;
			} else if (array[j][i].equalsIgnoreCase(O)
					&& array[j + 1][i].equalsIgnoreCase(X)
					&& array[j + 2][i].equalsIgnoreCase(X)) {
				array[j + 2][i] = C;
				flag = true;
				break;
			} else if (array[i][j].equalsIgnoreCase(X)
					&& array[j + 1][i].equalsIgnoreCase(X)
					&& array[j + 2][i].equalsIgnoreCase(O)) {
				array[j][i] = C;
				flag = true;
				break;
			}
		}
		tdata.setArray(array);
		return flag;
	}

	private boolean rowCheckAgain(TicTacData tdata, String[][] array) {
		int j = 0;
		boolean flag = false;
		for (int i = 0; i < ROW; i++) {
			if (array[i][j].equalsIgnoreCase(C)
					&& array[i][j + 1].equalsIgnoreCase(X)
					&& array[i][j + 2].equalsIgnoreCase(X)) {
				array[i][j + 2] = C;
				flag = true;
				break;
			} else if (array[i][j].equalsIgnoreCase(X)
					&& array[i][j + 1].equalsIgnoreCase(X)
					&& array[i][j + 2].equalsIgnoreCase(C)) {
				array[i][j] = C;
				flag = true;
				break;
			} else if (array[i][j].equalsIgnoreCase(X)
					&& array[i][j + 1].equalsIgnoreCase(C)
					&& array[i][j + 2].equalsIgnoreCase(X)) {
				array[i][j + 2] = C;
				flag = true;
				break;
			} else if (array[i][j].equalsIgnoreCase(O)
					&& array[i][j + 1].equalsIgnoreCase(X)
					&& array[i][j + 2].equalsIgnoreCase(X)) {
				array[i][j + 2] = C;
				flag = true;
				break;
			} else if (array[i][j].equalsIgnoreCase(X)
					&& array[i][j + 1].equalsIgnoreCase(X)
					&& array[i][j + 2].equalsIgnoreCase(O)) {
				array[i][j] = C;
				flag = true;
				break;
			}
		}
		tdata.setArray(array);
		return flag;

	}

	private boolean colCheck(TicTacData tdata, String[][] array) {
		int j = 0;
		boolean flag = false;
		for (int i = 0; i < ROW; i++) {
			if (array[j][i].equalsIgnoreCase(C)
					&& array[j + 1][i].equalsIgnoreCase(C)
					&& array[j + 2][i].equalsIgnoreCase(X)) {
				array[j + 2][i] = C;
				flag = true;
				break;
			} else if (array[j][i].equalsIgnoreCase(C)
					&& array[j + 1][i].equalsIgnoreCase(X)
					&& array[j + 2][i].equalsIgnoreCase(C)) {
				array[j + 1][i] = C;
				flag = true;
				break;
			} else if (array[j][i].equalsIgnoreCase(X)
					&& array[j + 1][i].equalsIgnoreCase(C)
					&& array[j + 2][i].equalsIgnoreCase(C)) {
				array[j][i] = C;
				flag = true;
				break;
			} else if (array[j][i].equalsIgnoreCase(O)
					&& array[j + 1][i].equalsIgnoreCase(X)
					&& array[j + 2][i].equalsIgnoreCase(O)) {
				array[j + 1][i] = C;
				flag = true;
				break;
			} else if (array[j][i].equalsIgnoreCase(O)
					&& array[j + 1][i].equalsIgnoreCase(O)
					&& array[j + 2][i].equalsIgnoreCase(X)) {
				array[j + 2][i] = C;
				flag = true;
				break;
			} else if (array[j][i].equalsIgnoreCase(X)
					&& array[j + 1][i].equalsIgnoreCase(O)
					&& array[j + 2][i].equalsIgnoreCase(O)) {
				array[j][i] = C;
				flag = true;
				break;
			}
		}
		tdata.setArray(array);
		return flag;

	}

	private boolean rowCheck(TicTacData tdata, String[][] array) {
		int j = 0;
		boolean flag = false;
		for (int i = 0; i < ROW; i++) {
			if (array[i][j].equalsIgnoreCase(C)
					&& array[i][j + 1].equalsIgnoreCase(C)
					&& array[i][j + 2].equalsIgnoreCase(X)) {
				array[i][j + 2] = C;
				flag = true;
				break;
			} else if (array[i][j].equalsIgnoreCase(C)
					&& array[i][j + 1].equalsIgnoreCase(X)
					&& array[i][j + 2].equalsIgnoreCase(C)) {
				array[i][j + 1] = C;
				flag = true;
				break;
			} else if (array[i][j].equalsIgnoreCase(X)
					&& array[i][j + 1].equalsIgnoreCase(C)
					&& array[i][j + 2].equalsIgnoreCase(C)) {
				array[i][j] = C;
				flag = true;
				break;
			} else if (array[i][j].equalsIgnoreCase(O)
					&& array[i][j + 1].equalsIgnoreCase(X)
					&& array[i][j + 2].equalsIgnoreCase(O)) {
				array[i][j + 1] = C;
				flag = true;
				break;
			} else if (array[i][j].equalsIgnoreCase(O)
					&& array[i][j + 1].equalsIgnoreCase(O)
					&& array[i][j + 2].equalsIgnoreCase(X)) {
				array[i][j + 2] = C;
				flag = true;
				break;
			} else if (array[j][j].equalsIgnoreCase(X)
					&& array[i][j + 1].equalsIgnoreCase(O)
					&& array[i][j + 2].equalsIgnoreCase(O)) {
				array[i][j] = C;
				flag = true;
				break;
			}
		}
		tdata.setArray(array);
		return flag;
	}

	private boolean diagonalsCheck(TicTacData tdata, String[][] array) {

		boolean flag = false;
		int i = 0, j = 0;
		if (array[i][j].equalsIgnoreCase(C)
				&& array[i + 1][j + 1].equalsIgnoreCase(C)
				&& array[i + 2][j + 2].equalsIgnoreCase(X)) {
			array[i + 2][j + 2] = C;
			flag = true;
		} else if (array[i][j].equalsIgnoreCase(C)
				&& array[i + 1][j + 1].equalsIgnoreCase(X)
				&& array[i + 2][j + 2].equalsIgnoreCase(C)) {
			array[i + 1][j + 1] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j].equalsIgnoreCase(X)
				&& array[i + 1][j + 1].equalsIgnoreCase(C)
				&& array[i + 2][j + 2].equalsIgnoreCase(C)) {
			array[i][j] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j].equalsIgnoreCase(O)
				&& array[i + 1][j + 1].equalsIgnoreCase(O)
				&& array[i + 2][j + 2].equalsIgnoreCase(X)) {
			array[i + 2][j + 2] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j].equalsIgnoreCase(O)
				&& array[i + 1][j + 1].equalsIgnoreCase(X)
				&& array[i + 2][j + 2].equalsIgnoreCase(O)) {
			array[i + 1][j + 1] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j].equalsIgnoreCase(X)
				&& array[i + 1][j + 1].equalsIgnoreCase(O)
				&& array[i + 2][j + 2].equalsIgnoreCase(O)) {
			array[i][j] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2].equalsIgnoreCase(C)
				&& array[i + 1][j + 1].equalsIgnoreCase(C)
				&& array[i + 2][j].equalsIgnoreCase(X)) {
			array[i + 2][j] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2].equalsIgnoreCase(C)
				&& array[i + 1][j + 1].equalsIgnoreCase(X)
				&& array[i + 2][j].equalsIgnoreCase(C)) {
			array[i + 1][j + 1] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2].equalsIgnoreCase(X)
				&& array[i + 1][j + 1].equalsIgnoreCase(C)
				&& array[i + 2][j].equalsIgnoreCase(C)) {
			array[i][j + 2] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2].equalsIgnoreCase(O)
				&& array[i + 1][j + 1].equalsIgnoreCase(O)
				&& array[i + 2][j].equalsIgnoreCase(X)) {
			array[i + 2][j] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2].equalsIgnoreCase(O)
				&& array[i + 1][j + 1].equalsIgnoreCase(X)
				&& array[i + 2][j].equalsIgnoreCase(O)) {
			array[i + 1][j + 1] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2].equalsIgnoreCase(X)
				&& array[i + 1][j + 1].equalsIgnoreCase(O)
				&& array[i + 2][j].equalsIgnoreCase(O)) {
			array[i][j + 2] = C;
			flag = true;
			tdata.setArray(array);
		}
		return flag;
	}
}
