package org.ydor.solver;

public class MatrixSolutions {
	public int[][] matrix = new int[10][10];
	public boolean solved = false;
	private Solver solver;

	public MatrixSolutions(Solver solver) {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		this.solver = solver;
	}

	public void initialize() {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		for (int x = 1; x < 10; x++) {
			for (int y = 1; y < 10; y++) {
				this.matrix[x][y] = 0;
			}
		}

	}

	public void setNXY(int n, int x, int y) {
		this.matrix[x][y] = n;
	}

	public void show() {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		for (int y = 1; y < 10; y++) {
			if ((y - 1) % 3 == 0)
				System.err.println();
			for (int x = 1; x < 10; x++) {
				if ((x - 1) % 3 == 0)
					System.err.print(" ");
				System.err.print(this.matrix[x][y]);
			}
			System.err.println();
		}
	}
}
