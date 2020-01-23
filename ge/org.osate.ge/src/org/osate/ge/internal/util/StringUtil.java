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
package org.osate.ge.internal.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtil {
	/**
	 * Joins together strings with a specified delimiter between the segments
	 * @param segs an array of strings to be joined together
	 * @param startIdx the index of the first string that will be part of the result
	 * @param endIdx the string with the end index will not be include
	 * @param del the delimiter to use to join the strings
	 * @return
	 */
	public static String join(final String[] segs, final int startIdx, final int endIdx, final String del) {
		String res = segs[startIdx];
		for (int i = startIdx + 1; i < endIdx; i++) {
			res += del + segs[i];
		}
		return res;
	}

	/**
	 * Accepts a string, searches it for all uppercase characters and then ensures the first character is capitalized. When a
	 * capital character found the method inserts a space at the end of the string for every capital letter and shifts all characters
	 * at and below the current index to index + 1. Then a space is inserted at the current index and the method continues.
	 * @param str the string to be made processed
	 * @return A more human readable version of str
	 */
	public static String camelCaseToUser(final String str){

		char[] str_arr = str.toCharArray();
		String h_str = str;
		char c = 'X';
		int i = (str_arr.length-1);

		if ((str_arr[0] > 96) && (str_arr[0] < 123))	//Checks if first char is a lower case letter
		{
			str_arr[0] = (char) (str_arr[0] - ' ');
		}

		h_str = new String(str_arr);

		while (i != 0)
		{
			c = str_arr[i];

			if ((c >= 'A') && (c <= 'Z'))
			{
				str_arr = (h_str + ' ').toCharArray();
				int j = (str_arr.length-1);
				while (j >= i)
				{
					str_arr[j] = str_arr[j-1];
					j--;
				}
				str_arr[j+1] = ' ';
				h_str = new String(str_arr);
			}
			i--;
		}
		return h_str;
	}

	public static String capitalize(final String value) {
		if (value == null || value.length() == 0) {
			return value;
		}

		return value.substring(0, 1).toUpperCase() + value.substring(1);
	}

	/**
	 * Converts a string which is in upper underscore format to a phrase which is all in lowercase. Example NEW_CLASSIFIER => new classifier
	 * @param value
	 * @return
	 */
	public static String upperUnderscoreToLowercaseUser(final String value) {
		return Arrays.stream(value.split("_")).map(String::toLowerCase).collect(Collectors.joining(" "));
	}
}
