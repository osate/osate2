package org.osate.ui.utils;

/**
 * @since 6.0
 */
public class StringSorter {
	public static String[] sort(String[] args) {
		int count = args.length;
		String temp;

		// Sorting the strings
		for (int i = 0; i < count; i++) {
			for (int j = i + 1; j < count; j++) {
				if (args[i].compareToIgnoreCase(args[j]) > 0) {
					temp = args[i];
					args[i] = args[j];
					args[j] = temp;
				}
			}
		}

		return args;
	}
}