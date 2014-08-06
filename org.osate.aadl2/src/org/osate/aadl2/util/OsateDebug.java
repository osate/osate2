package org.osate.aadl2.util;

public class OsateDebug {

	static boolean DEBUG_ENABLE = true;

	public static void osateDebug(String str) {
		if (DEBUG_ENABLE) {
			System.out.println(str);
		}
	}

	public static void osateDebug(String severity, String details) {
		osateDebug("[" + severity + "]" + " " + details);
	}
}
