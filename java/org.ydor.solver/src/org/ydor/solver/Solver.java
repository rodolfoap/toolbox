/**
 * 
 */
package org.ydor.solver;

import java.io.Console;

/**
 * @author RodolfoAP
 */
public class Solver {
	boolean[][][] mxOpt = new boolean[9][9][10];

	public MatrixCanvas canvas;

	public MatrixSolutions solutn;

	public MatrixOptions option;

	public Console console;

	public Solver() {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		console = Utils.getConsole();
		newBoard();
		this.canvas.showOptions();
	}

	private void newBoard() {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		this.canvas = new MatrixCanvas(this);
		this.solutn = new MatrixSolutions(this);
		this.option = new MatrixOptions(this);
		this.solutn.initialize();
		this.option.initialize();
	}

	public static void main(String[] args) {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		new Solver().loop();
	}

	private void loop() {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		while (!this.solutn.solved) {
			String[] splited = console.readLine().split(" ");
			char command = splited[0].charAt(0);
			switch (command) {
			case 'n':
				System.err.println(new Throwable().getStackTrace()[0]
						.toString());
				newBoard();
				break;
			case 'o':
				System.err.println(new Throwable().getStackTrace()[0]
						.toString());
				this.canvas.showOptions();
				break;
			case 's':
				System.err.println(new Throwable().getStackTrace()[0]
						.toString());
				this.solutn.show();
				break;
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				System.err.println(new Throwable().getStackTrace()[0]
						.toString());
				this.solutn.setNXY(
						Character.getNumericValue(splited[0].charAt(2)),
						Character.getNumericValue(splited[0].charAt(0)),
						Character.getNumericValue(splited[0].charAt(1)));
				this.canvas.showOptions();
				break;
			default:
				System.err.println(new Throwable().getStackTrace()[0]
						.toString());
				break;
			}
		}
	}
}
