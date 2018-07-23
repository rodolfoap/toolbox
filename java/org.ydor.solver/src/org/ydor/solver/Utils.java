package org.ydor.solver;

import java.io.Console;

public class Utils {
	public static Console getConsole() {
		System.err.println(new Throwable().getStackTrace()[0].toString());

		Console console = System.console();
		if (console == null) {
			System.err.println(new Throwable().getStackTrace()[0].toString()
					+ ":Unable to fetch console");
			return null;
		}
		return console;
	}

	public static int getRing(int k) {
		return (k - 1) / 3 + 1;
	}
}
