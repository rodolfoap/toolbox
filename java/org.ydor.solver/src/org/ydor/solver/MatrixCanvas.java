package org.ydor.solver;

public class MatrixCanvas {
	public static final int SIZE = 43;
	public char[][] matrix = new char[SIZE][SIZE];
	private Solver solver;

	public MatrixCanvas(Solver modifyElement) {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		this.solver = modifyElement;
		this.matrix = new char[SIZE][SIZE];
	}

	public void showOptions() {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		solver.option.applySolutions();
		drawBoard();
		transferOptions();
		transferSolutions();
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				System.err.print(this.matrix[x][y]);
			}
			System.err.println();
		}
	}

	private void solveCell(int n, int a, int b) {
		int px = (a - 1) * 4 + (a - 1) / 3 * 2;
		int py = (b - 1) * 4 + (b - 1) / 3 * 2;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				this.matrix[px + 2 + x][py + 2 + y] = ' ';
				if (x == 1 && y == 1) {
					this.matrix[px + 2 + y][py + 2 + y] = getChar(n);
				}
			}
		}
	}

	private void drawBoard() {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				this.matrix[x][y] = ' ';
				if (x % 14 == 0 || y % 14 == 0) {
					this.matrix[x][y] = '#';
				}
			}
		}
	}

	private int getPosX(int x, int n) {
		int offset = 1;
		int offsetx = ((x - 1) / 3) * 2;
		int i = (x - 1) * 4 + (n - 1) % 3;
		return i + offset + offsetx + 1;
	}

	private int getPosY(int y, int n) {
		int offset = 1;
		int offsety = ((y - 1) / 3) * 2;
		int j = (int) ((y - 1) * 4 + Math.floor((n - 1) / 3));
		return j + offset + offsety + 1;
	}

	private char getChar(int n) {
		return (char) (n + 48);
	}

	private void transferSolutions() {
		for (int y = 1; y < 10; y++) {
			for (int x = 1; x < 10; x++) {
				if (solver.solutn.matrix[x][y] > 0) {
					solveCell(solver.solutn.matrix[x][y], x, y);
				}
			}
		}
	}

	private void transferOptions() {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		for (int n = 1; n < 10; n++) {
			for (int y = 1; y < 10; y++) {
				for (int x = 1; x < 10; x++) {
					this.matrix[getPosX(x, n)][getPosY(y, n)] = getChar(n);
					if (solver.option.matrix[n][x][y]) {
						this.matrix[getPosX(x, n)][getPosY(y, n)] = getChar(n);
					} else {
						this.matrix[getPosX(x, n)][getPosY(y, n)] = '.';
					}
				}
			}
		}
	}
}