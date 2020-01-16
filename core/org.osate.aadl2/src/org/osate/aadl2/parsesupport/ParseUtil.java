/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.parsesupport;

import java.util.HashMap;
import java.util.Map;

public class ParseUtil {

	private static final char UNDERLINE = '_';
	private static final char HASHMARK = '#';
	private static final char EXPONENT = 'E';
	private static final char PLUS = '+';
	private static final char MINUS = '-';

	private static Map<String, String> annexNS = new HashMap<String, String>();

	/**
	 * Trick to get rid of an additional dependency to annexsupport
	 * @param annexName
	 * @param annexNSName
	 */
	public static void setAnnexNS(String annexName, String annexNSName) {
		if ((annexName != null) && (annexNSName != null)) {
//			OsateDebug.osateDebug("called setAnnexNSURI with " + annexName + annexNSName);
			annexName = annexName.toLowerCase();
			if (annexNS.get(annexName) == null) {
				annexNS.put(annexName, annexNSName);
			}
		}
	}

	public static String getAnnexNS(String annexName) {
		String ns;
		annexName = annexName.toLowerCase();
		ns = annexNS.get(annexName);
//		if ((annexName!=null) && (ns != null))
//		{
//			OsateDebug.osateDebug("called getAnnexNSURI with " + annexName + ns);
//		}
		return ns;
	}

	/**
	 * Parse a string representation of an aadlinteger.
	 * @param stringValue The string to parse.
	 * @return An array of length 2: the first element is the base
	 * and the second element is the value.
	 * @exception IllegalArgumentException thrown if there is some kind of
	 * parsing error.
	 */
	public static long[] parseAadlInteger(final String stringValue) {
		/*
		 * First remove '_', convert to upper case, get as char[]. We assume
		 * the result still has at least one 1 character in it. (Should have
		 * at least one digit in it and have no '.' in it; otherwise the
		 * parser/lexer failed us).
		 */
		final char[] valueAsChars = normalizeValue(stringValue).toCharArray();

		// Get the sign
		int currentIdx = 0;
		final boolean isNegative;
		if (valueAsChars[0] == PLUS) {
			isNegative = false;
			currentIdx = 1;
		} else if (valueAsChars[0] == MINUS) {
			isNegative = true;
			currentIdx = 1;
		} else {
			isNegative = false;
		}

		// Process as base 10 until we hit end of string, 'E' or '#'
		long value = 0L;
		for (; currentIdx < valueAsChars.length; currentIdx++) {
			final char c = valueAsChars[currentIdx];
			if (c == EXPONENT || c == HASHMARK) {
				break;
			} else if ('0' <= c && c <= '9') {
				value = (value * 10) + Character.digit(c, 10);
				if (value < 0) {
					throw new IllegalArgumentException("Integer value is not representable");
				}
			} else {
				throw new IllegalArgumentException("Unexpected character '" + c + "' at string index " + currentIdx);
			}
		}

		final int base;
		if (currentIdx == valueAsChars.length) {
			// Hit end of string, it's a simple decimal integer
			base = 10;
		} else {
			if (valueAsChars[currentIdx] == EXPONENT) {
				// Decimal integer with exponent
				base = 10;
			} else {
				// based_integer
				base = (int) value;
				if (base < 2 || base > 16) { // base is bad
					throw new IllegalArgumentException("Base not between 2 and 16: " + base);
				} else { // base is good
					value = 0L;
					char c = valueAsChars[++currentIdx];
					while (c != HASHMARK) {
						final int digit = Character.digit(c, base);
						if (digit == -1) {
							throw new IllegalArgumentException("'" + c + "' at string index " + currentIdx
									+ " is not an extended digit in base " + base);
						} else {
							value = (value * base) + digit;
							if (value < 0) {
								throw new IllegalArgumentException("Integer value is not representable");
							}
						}
						c = valueAsChars[++currentIdx];
					}
					// eat hashmark
					currentIdx += 1;
				}
			}

			// eat the 'e'; based integers don't have to have an exponent
			if (++currentIdx < valueAsChars.length) {
				// deal with sign
				char c = valueAsChars[currentIdx];
				if (c == MINUS) {
					throw new IllegalArgumentException("Integers cannot have a negative exponent");
				} else if (c == PLUS) {
					currentIdx += 1;
				}

				int exponent = 0;
				while (currentIdx < valueAsChars.length) {
					c = valueAsChars[currentIdx++];
					if ('0' <= c && c <= '9') {
						exponent = (exponent * 10) + Character.digit(c, 10);
						if (exponent < 0) {
							throw new IllegalArgumentException(
									"Integer value is not representable: cannot represent exponent");
						}
					} else {
						throw new IllegalArgumentException(
								"Unexpected character '" + c + "' at string index " + currentIdx);
					}
				}

				for (int i = 0; i < exponent; i++) {
					value *= base;
					if (value < 0) {
						throw new IllegalArgumentException("Integer value is not representable");
					}
				}
			}
		}

		if (isNegative) {
			value = -value;
		}

		return new long[] { base, value };
	}

	/**
	 * Parse a string representation of an aadlreal.
	 *
	 * @param stringValue
	 *            The real value to resolve.
	 * @return The value
	 * @exception IllegalArgumentException Thrown if the value is not
	 * parsable into an aadlreal value.
	 */
	public static double parseAadlReal(final String stringValue) {
		try {
			return Double.parseDouble(normalizeValue(stringValue));
		} catch (final NumberFormatException e) {
			throw new IllegalArgumentException("Couldn't resolve literal: " + e.getMessage());
		}
	}

	/**
	 * Remove the underlines, &ldquo; <code>_</code>,&rdquo; from the numeric
	 * literal and forces letters to be uppercase.
	 *
	 * @param value
	 *            The string to process
	 * @return The provided string with all the underlines removed.
	 */
	private static String normalizeValue(final String value) {
		int nextUnderlineLoc = value.indexOf(UNDERLINE);
		if (nextUnderlineLoc == -1) {
			return value.toUpperCase();
		} else {
			// size of the new string <= size of value
			final StringBuffer working = new StringBuffer(value.length());
			int lastUnderlineLoc = 0;
			// already found the first underscore...
			do {
				working.append(value.substring(lastUnderlineLoc, nextUnderlineLoc).toUpperCase());
				lastUnderlineLoc = nextUnderlineLoc + 1;
				nextUnderlineLoc = value.indexOf(UNDERLINE, lastUnderlineLoc);
			} while (nextUnderlineLoc != -1);
			// append the last portion of the string
			working.append(value.substring(lastUnderlineLoc));
			return working.toString();
		}
	}

}
