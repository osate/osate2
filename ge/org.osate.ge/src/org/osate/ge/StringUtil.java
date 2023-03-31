/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Utility functions related to {@link String}
 * @since 2.0
 */
public final class StringUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private StringUtil() {
	}

	/**
	 * Joins together strings with a specified delimiter between the segments
	 * @param segs an array of strings to be joined together
	 * @param startIdx the index of the first string that will be part of the result
	 * @param endIdx the string with the end index will not be included
	 * @param del the delimiter to use to join the strings
	 * @return is the joined string
	 */
	public static String join(final String[] segs, final int startIdx, final int endIdx, final String del) {
		final StringBuilder res = new StringBuilder(segs[startIdx]);
		for (int i = startIdx + 1; i < endIdx; i++) {
			res.append(del);
			res.append(segs[i]);
		}
		return res.toString();
	}

	/**
	 * Converts a string from lower or upper camel case to a user-friendly format.
	 * This method converts the string to a title case. Example "sytemInstance" =&gt; "System Instance"
	 * @param str the camel case string to be converted
	 * @return the title case string
	 */
	public static String camelCaseToUser(final String str) {
		if (str.isEmpty()) {
			return str;
		}

		final StringBuilder result = new StringBuilder();
		str.codePoints().forEachOrdered(cp -> {
			if (result.length() == 0) {
				result.appendCodePoint(Character.toUpperCase(cp));
			} else {
				if (Character.isUpperCase(cp)) {
					result.append(' ');
				}
				result.appendCodePoint(cp);
			}
		});

		return result.toString();
	}

	/**
	 * Returns the specified string with the first letter capitalized.
	 * @param value the string to capitalize
	 * @return the capitalized string. If the specified string is null or empty, the specified string is returned.
	 */
	public static String capitalize(final String value) {
		if (value == null || value.length() == 0) {
			return value;
		}

		return value.substring(0, 1).toUpperCase() + value.substring(1);
	}

	/**
	 * Deprecated. Use @link #snakeCaseToLowercaseUser(String)}.
	 * @param value is the string to convert.
	 * @return the converted string.
	 * @deprecated use {@link #snakeCaseToLowercaseWords(String)}
	 */
	@Deprecated
	public static String upperUnderscoreToLowercaseUser(final String value) {
		return snakeCaseToLowercaseWords(value);
	}

	/**
	 * Converts a string which is in snake case format to a phrase which is all in lower-case and which has underscores replaced with
	 * spaces. Example "NEW_CLASSIFIER" =&gt; "new classifier"
	 * @param value a snake case string
	 * @return the resulting string
	 * @since 3.0
	 */
	public static String snakeCaseToLowercaseWords(final String value) {
		return Arrays.stream(value.split("_")).map(String::toLowerCase).collect(Collectors.joining(" "));
	}

	/**
	 * Converts a string which is in snake case format to a phrase which is all in lower-case and which has underscores replaced with
	 * spaces. Example "NEW_CLASSIFIER" =&gt; "New Classifier"
	 * @param value a snake case string
	 * @return the resulting string
	 * @since 3.0
	 */
	public static String snakeCaseToTitleCase(final String value) {
		return Arrays.stream(value.split("_"))
				.map(String::toLowerCase)
				.map(StringUtil::capitalize)
				.collect(Collectors.joining(" "));
	}
}
