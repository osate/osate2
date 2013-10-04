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
	
	public static String camelCaseToUser(final String str){
		char[] str_arr = (str + ' ').toCharArray();
		//System.out.println(str);	
		String h_str = "666";
		
		int i = (str_arr.length - 1), j = 0;
		for (char c: str_arr)
		{			
			if ( j != 0)
			{
				if ((c >= 'A') && (c <= 'Z'))
				{
					while (i >= j)
					{
						str_arr[i] = str_arr[i-1];
						i--;
					}
					str_arr[i+1] = ' ';
					h_str = new String(str_arr);
					return h_str;
				}
			}
			j++;
		}
		return h_str;
	}
}
