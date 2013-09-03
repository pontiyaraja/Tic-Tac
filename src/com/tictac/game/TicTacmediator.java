package com.tictac.game;

import static com.tictac.game.TicTacConstants.*;

import java.util.Random;
import java.util.Scanner;

/**
 * This class is for read user input and computer input
 * 
 * @author pandiyaraja
 * 
 */
public class TicTacmediator extends TicTacControl {

	private Random random;
	private char[][] array;

	/**
	 * this method reads user input from console It takes TicTacData class
	 * parameter.
	 * 
	 * @param tdata
	 */
	public void userInput(TicTacData tdata) {
		array = tdata.getArray();
		Scanner scan = new Scanner(System.in);
		correct: for (int row = 0; row < ROW; row++) {
			String c = scan.next();
			for (int col = 0; col < COL; col++) {

				if (c.charAt(col) == O || c.charAt(col) == X
						|| c.charAt(col) == C) {
					if (array[row][col] == C) {
						array[row][col] = C;
					} else if (array[row][col] == O) {
						array[row][col] = O;
					} else if (array[row][col] == X) {
						array[row][col] = c.charAt(col);
					}
				} else {
					System.out.println("WRONG INPUT");
					continue correct;
				}

			}
		}
		tdata.setArray(array);
	}

	/**
	 * This method reads computer input it takes TicTacData class as parameter.
	 * 
	 * @param tdata
	 */
	public void gameInput(TicTacData tdata) {
		if (tdata.getCOUNT() == ONE) {
			System.out.println(tdata.getCOUNT());
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

	private boolean diagonalsCheckAgain(TicTacData tdata, char[][] array) {
		boolean flag = false;
		int i = 0, j = 0;
		if (array[i][j] == O && array[i + 1][j + 1] == O
				&& array[i + 2][j + 2] == X) {
			array[i + 2][j + 2] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j] == O && array[i + 1][j + 1] == X
				&& array[i + 2][j + 2] == O) {
			array[i + 1][j + 1] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j] == X && array[i + 1][j + 1] == O
				&& array[i + 2][j + 2] == O) {
			array[i][j] = C;
			flag = true;
			tdata.setArray(array);
		}
		else if (array[i][j + 2] == O && array[i + 1][j + 1] == O
				&& array[i + 2][j] == X) {
			array[i + 2][j] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2] == O && array[i + 1][j + 1] == X
				&& array[i + 2][j] == O) {
			array[i + 1][j + 1] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2] == X && array[i + 1][j + 1] == O
				&& array[i + 2][j] == O) {
			array[i][j + 2] = C;
			flag = true;
			tdata.setArray(array);
		}
		else if (array[i][j + 2] == C && array[i + 1][j + 1] == X
				&& array[i + 2][j] == X) {
			array[i + 2][j] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2] == X && array[i + 1][j + 1] == X
				&& array[i + 2][j] == C) {
			array[i][j + 2] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2] == X && array[i + 1][j + 1] == C
				&& array[i + 2][j] == X) {
			array[i][j + 2] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2] == O && array[i + 1][j + 1] == X
				&& array[i + 2][j] == C) {
			array[i + 1][j + 1] = C;
			flag = true;

		} else if (array[i][j] == C && array[+1][i] == X
				&& array[j + 2][i] == O) {
			array[i + 1][j + 1] = C;
			flag = true;

		} else if (array[i][j] == C && array[i + 1][j + 1] == X
				&& array[i + 2][j + 2] == X) {
			array[i + 2][j] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j] == X && array[i + 1][j + 1] == X
				&& array[i + 2][j + 2] == C) {
			array[i][j + 2] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j] == X && array[i + 1][j + 1] == C
				&& array[i + 2][j + 2] == X) {
			array[i][j + 2] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j] == O && array[i + 1][j + 1] == X
				&& array[i + 2][j + 2] == C) {
			array[i + 1][j + 1] = C;
			flag = true;

		} else if (array[i][j] == C && array[i + 1][j + 1] == X
				&& array[i + 2][j + 2] == O) {
			array[i + 1][j + 1] = C;
			flag = true;

		}

		return flag;
	}

	private boolean colCheckAgain(TicTacData tdata, char[][] array) {
		int j = 0;
		boolean flag = false;
		for (int i = 0; i < ROW; i++) {
			if (array[j][i] == O && array[j + 1][i] == X
					&& array[j + 2][i] == O) {
				array[j + 1][i] = C;
				flag = true;
				break;
			} else if (array[j][i] == O && array[j + 1][i] == O
					&& array[j + 2][i] == X) {
				array[j + 2][i] = C;
				flag = true;
				break;
			} else if (array[j][i] == X && array[j + 1][i] == O
					&& array[j + 2][i] == O) {
				array[j][i] = C;
				flag = true;
				break;
			}		
			else if (array[j][i] == C && array[j + 1][i] == X
					&& array[j + 2][i] == X) {
				array[j + 2][i] = C;
				flag = true;
				break;
			} else if (array[j][i] == X && array[j + 1][i] == X
					&& array[j + 2][i] == C) {
				array[j][i] = C;
				flag = true;
				break;
			} else if (array[j][i] == X && array[j + 1][i] == C
					&& array[j + 2][i] == X) {
				array[j][i] = C;
				flag = true;
				break;
			} else if (array[j][i] == O && array[j + 1][i] == X
					&& array[j + 2][i] == X) {
				array[j + 2][i] = C;
				flag = true;
				break;
			} else if (array[j][i] == X && array[j + 1][i] == X
					&& array[j + 2][i] == O) {
				array[j][i] = C;
				flag = true;
				break;
			} else if (array[j][i] == O && array[j + 1][i] == X
					&& array[j + 2][i] == C) {
				array[j + 1][i] = C;
				flag = true;
				break;
			} else if (array[j][i] == C && array[j + 1][i] == X
					&& array[j + 2][i] == O) {
				array[j + 1][i] = C;
				flag = true;
				break;
			}
		}
		tdata.setArray(array);
		return flag;
	}

	private boolean rowCheckAgain(TicTacData tdata, char[][] array) {
		int j = 0;
		boolean flag = false;
		for (int i = 0; i < ROW; i++) {
			if (array[i][j] == O && array[i][j + 1] == X
					&& array[i][j + 2] == O) {
				array[i][j + 1] = C;
				flag = true;
				break;
			} else if (array[i][j] == O && array[i][j + 1] == O
					&& array[i][j + 2] == X) {
				array[i][j + 2] = C;
				flag = true;
				break;
			} else if (array[j][j] == X && array[i][j + 1] == O
					&& array[i][j + 2] == O) {
				array[i][j] = C;
				flag = true;
				break;
			}
			else if (array[i][j] == C && array[i][j + 1] == X
					&& array[i][j + 2] == X) {
				array[i][j + 2] = C;
				flag = true;
				break;
			} else if (array[i][j] == X && array[i][j + 1] == X
					&& array[i][j + 2] == C) {
				array[i][j] = C;
				flag = true;
				break;
			} else if (array[i][j] == X && array[i][j + 1] == C
					&& array[i][j + 2] == X) {
				array[i][j + 2] = C;
				flag = true;
				break;
			} else if (array[i][j] == O && array[i][j + 1] == X
					&& array[i][j + 2] == X) {
				array[i][j + 2] = C;
				flag = true;
				break;
			} else if (array[i][j] == X && array[i][j + 1] == X
					&& array[i][j + 2] == O) {
				array[i][j] = C;
				flag = true;
				break;
			} else if (array[i][j] == O && array[i][j + 1] == X
					&& array[i][j + 2] == C) {
				array[i][j + 1] = C;
				flag = true;
				break;
			} else if (array[i][j] == C && array[i][j + 1] == X
					&& array[i][j + 2] == O) {
				array[i][j + 1] = C;
				flag = true;
				break;
			}
		}
		tdata.setArray(array);
		return flag;

	}

	private boolean colCheck(TicTacData tdata, char[][] array) {
		int j = 0;
		boolean flag = false;
		for (int i = 0; i < ROW; i++) {
			if (array[j][i] == C && array[j + 1][i] == C
					&& array[j + 2][i] == X) {
				array[j + 2][i] = C;
				flag = true;
				break;
			} else if (array[j][i] == C && array[j + 1][i] == X
					&& array[j + 2][i] == C) {
				array[j + 1][i] = C;
				flag = true;
				break;
			} else if (array[j][i] == X && array[j + 1][i] == C
					&& array[j + 2][i] == C) {
				array[j][i] = C;
				flag = true;
				break;
			} 
		}
		tdata.setArray(array);
		return flag;

	}

	private boolean rowCheck(TicTacData tdata, char[][] array) {
		int j = 0;
		boolean flag = false;
		for (int i = 0; i < ROW; i++) {
			if (array[i][j] == C && array[i][j + 1] == C
					&& array[i][j + 2] == X) {
				array[i][j + 2] = C;
				flag = true;
				break;
			} else if (array[i][j] == C && array[i][j + 1] == X
					&& array[i][j + 2] == C) {
				array[i][j + 1] = C;
				flag = true;
				break;
			} else if (array[i][j] == X && array[i][j + 1] == C
					&& array[i][j + 2] == C) {
				array[i][j] = C;
				flag = true;
				break;
			} 
		}
		tdata.setArray(array);
		return flag;
	}

	private boolean diagonalsCheck(TicTacData tdata, char[][] array) {

		boolean flag = false;
		int i = 0, j = 0;
		if (array[i][j] == C && array[i + 1][j + 1] == C
				&& array[i + 2][j + 2] == X) {
			array[i + 2][j + 2] = C;
			flag = true;
		} else if (array[i][j] == C && array[i + 1][j + 1] == X
				&& array[i + 2][j + 2] == C) {
			array[i + 1][j + 1] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j] == X && array[i + 1][j + 1] == C
				&& array[i + 2][j + 2] == C) {
			array[i][j] = C;
			flag = true;
			tdata.setArray(array);
		}else if (array[i][j + 2] == C && array[i + 1][j + 1] == C
				&& array[i + 2][j] == X) {
			array[i + 2][j] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2] == C && array[i + 1][j + 1] == X
				&& array[i + 2][j] == C) {
			array[i + 1][j + 1] = C;
			flag = true;
			tdata.setArray(array);
		} else if (array[i][j + 2] == X && array[i + 1][j + 1] == C
				&& array[i + 2][j] == C) {
			array[i][j + 2] = C;
			flag = true;
			tdata.setArray(array);
		} 
		return flag;
	}
}
