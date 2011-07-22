/*
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * @version $Id$
 */
package org.osate.xtext.aadl2.validation;




/**
 * Utility methods for parsing and checking AADL models.
 * 
 * @author aarong
 */
public class AadlParseUtil {
	/* The following contants are related to interpreting AADL
	 * numeric literals.
	 */
	private static final char UNDERLINE = '_';
	private static final char HASHMARK = '#';
	private static final char EXPONENT = 'E';
	private static final char PLUS = '+';
	private static final char MINUS = '-';

	
	

	

	// ------------------------------------------------------------------------
	// -- Helper methods for parsing AADL numeric values
	// ------------------------------------------------------------------------
	
	/**
	 * Parse a string representation of an aadlinteger.
	 * @param stringValue The string to parse.
	 * @return An array of length 2: the first element is the base
	 * and the second element is the value.
	 * @exception IllegalArgumentException thrown if there is some kind of 
	 * parsing error.
	 */
	public static long[] parseAadlInteger(final String stringValue) {
		/* First remove '_', convert to upper case, get as char[]. We assume
		 * the result still has at least one 1 character in it. (Should have
		 * at least one digit in it and have no '.' in it; otherwise the
		 * parser/lexer failed us).
		 */
		final char[] valueAsChars = normalizeValue(stringValue);

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
				throw new IllegalArgumentException("Unexpected character '" +
						c + "' at string index " + currentIdx);
			}
		}
		
		final int base;
		if (currentIdx == valueAsChars.length)  {
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
					throw new IllegalArgumentException(
							"Base not between 2 and 16: " + base);
				} else { // base is good
					value = 0L;
					char c = valueAsChars[++currentIdx];
					while (c != HASHMARK) {
						final int digit = Character.digit(c, base);
						if (digit == -1) {
							throw new IllegalArgumentException(
									"'" + c + "' at string index " + currentIdx +
									" is not an extended digit in base " + base);
						} else {
							value = (value * base) + digit;
							if (value < 0) {
								throw new IllegalArgumentException(
										"Integer value is not representable");
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
					throw new IllegalArgumentException(
							"Integers cannot have a negative exponent");
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
						throw new IllegalArgumentException("Unexpected character '" +
								c + "' at string index " + currentIdx);
					}
				}
				
				for (int i = 0; i < exponent; i++) {
					value *= base;
					if (value < 0) {
						throw new IllegalArgumentException(
								"Integer value is not representable");
					}
				}
			}
		}
		
		if (isNegative) value = -value;

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
			return Double.parseDouble(stringValue);
		} catch(final NumberFormatException e) {
			throw new IllegalArgumentException(
					"Couldn't resolve literal: " + e.getMessage());
		}
	}


	/**
	 * Remove the underlines, &ldquo; <code>_</code>,&rdquo; from the numeric
	 * literal and forces letters to be uppercase.
	 * 
	 * @param value
	 *            The string to process
	 * @return The provided string with all the underlines removed, returned as
	 *         a character array.
	 */
	private static char[] normalizeValue(final String value) {
		int nextUnderlineLoc = value.indexOf(UNDERLINE);
		if (nextUnderlineLoc == -1) {
			return value.toUpperCase().toCharArray();
		} else {
			// size of the new string <= size of value
			final StringBuffer working = new StringBuffer(value.length());
			int lastUnderlineLoc = 0;
			// already found the first underscore...
			do {
				working.append(value.substring(lastUnderlineLoc, nextUnderlineLoc).toUpperCase());
				lastUnderlineLoc = nextUnderlineLoc+1;
				nextUnderlineLoc = value.indexOf(UNDERLINE, lastUnderlineLoc);
			} while (nextUnderlineLoc != -1);
			// append the last portion of the string
			working.append(value.substring(lastUnderlineLoc));
			return working.toString().toCharArray();
		}
	}
}
