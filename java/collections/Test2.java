package org.rap.prgtests.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Test2 {
	List<String> mScriptsList = new ArrayList<String>();

	Test2() {
		// Map<UUID, List<String>> scriptsMap = new HashMap<UUID,
		// List<String>>();
		System.err.println(new Throwable().getStackTrace()[0].toString()
				+ ":List:" + mScriptsList.toString());
		addToScriptsList("script1");

		System.err.println(new Throwable().getStackTrace()[0].toString()
				+ ":List:" + mScriptsList.toString());
		addToScriptsList("script2");

		System.err.println(new Throwable().getStackTrace()[0].toString()
				+ ":List:" + mScriptsList.toString());
		addToScriptsList("script2");

		System.err.println(new Throwable().getStackTrace()[0].toString()
				+ ":List:" + mScriptsList.toString());

		System.err.println(new Throwable().getStackTrace()[0].toString()
				+ ":find[True]:" + isScriptInList("script1"));

		System.err.println(new Throwable().getStackTrace()[0].toString()
				+ ":find[False]:" + isScriptInList("scriptX"));
	}

	public void addToScriptsList(String scriptName) {
		if (!this.mScriptsList.contains(scriptName)) {
			this.mScriptsList.add(scriptName);
		}
	}

	public boolean isScriptInList(String scriptName) {
		if (this.mScriptsList.contains(scriptName)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		new Test2();
	}
}
