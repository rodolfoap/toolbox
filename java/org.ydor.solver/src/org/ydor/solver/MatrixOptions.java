package org.ydor.solver;

public class MatrixOptions {
	public boolean[][][] matrix = new boolean[10][10][10];
	private Solver solver;

	public MatrixOptions(Solver solver) {
		this.matrix = new boolean[10][10][10];
		this.solver = solver;
	}

	public void initialize() {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		for (int n = 1; n < 10; n++) {
			for (int x = 1; x < 10; x++) {
				for (int y = 1; y < 10; y++) {
					this.matrix[n][x][y] = true;
				}
			}
		}
	}

	public void setNXY(int n, int x, int y, boolean state) {
		this.matrix[n][x][y] = state;
	}

	public void applySolutions() {
		for (int x = 1; x < 10; x++) {
			for (int y = 1; y < 10; y++) {
				Utils.getRing(x);
				int n = solver.solutn.matrix[x][y];
				if (n > 0) {
					for (int k = 1; k < 10; k++) {
						// All options for this cell
						this.matrix[k][x][y] = false;
						// Fill Row
						this.matrix[n][k][y] = false;
						// Fill Column
						this.matrix[n][x][k] = false;
						if (Utils.getRing(x) == Utils.getRing(k)
								|| Utils.getRing(y) == Utils.getRing(k)) {
							setNOnRingXY(n, x, y, false);
						}
					}
				}
			}
		}
	}

	/**
	 * Used normally to unset a value on the whole ring: for example if the
	 * solution to (1,1) is n=5, X=1..3 and Y=1..3 (9 cells in total) will be
	 * disabled for 5
	 * 
	 * @param n
	 *            The solution for the Cell
	 * @param a
	 *            The X Coordinate of the solution
	 * @param b
	 *            The Y Coordinate of the solution
	 * @param st
	 *            The boolean state to be set
	 */
	private void setNOnRingXY(int n, int a, int b, boolean state) {
		for (int x = 1; x < 10; x++) {
			for (int y = 1; y < 10; y++) {
				if (Utils.getRing(a) == Utils.getRing(x)
						&& Utils.getRing(b) == Utils.getRing(y)) {
					this.matrix[n][x][y] = state;
				}
			}
		}
	}

}
