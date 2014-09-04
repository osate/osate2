package org.osate.aadl2.modelsupport;

import java.util.ArrayList;

public class OsateLogger {

	static private ArrayList<String> theLog = new ArrayList<String>();
	private static int count = 0;
	private static int MAX = 2000;

	/**
	 * add a string to the current line of the output
	 * @param more String to be added
	 */
	static public void log(String more) {
		theLog.add(more);
		count++;
		if (count > MAX) {
			reset();
		}
	}

	static public Object[] getContent() {
		return theLog.toArray();
	}

	static public void reset() {
		theLog.clear();
		count = 0;
	}
}
