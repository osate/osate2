package edu.uah.rsesc.aadl.age.util;

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
		for(int i = startIdx+1; i < endIdx; i++) {
			res += del + segs[i];
		}
		
		return res;
	}
}
