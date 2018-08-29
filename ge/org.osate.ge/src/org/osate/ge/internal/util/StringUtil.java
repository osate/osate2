/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.util;

public class StringUtil {
	public interface Converter<I, O> {
		O convert(final I input);
	}

	/**
	 * Joins a series of objects together. Uses a specified converter to convert each object to a string.
	 * @param items
	 * @param del
	 * @param converter
	 * @return
	 */
	public static <T> String join(final Iterable<T> items, final String del, final Converter<T, String> converter) {
		String result = "";
		boolean first = true;
		for(final T item : items) {
			if(!first) {
				result += del;
			}
			first = false;

			result += converter.convert(item);
		}

		return result;
	}

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
		for(int i = startIdx+1; i < endIdx; i++) {
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
}
