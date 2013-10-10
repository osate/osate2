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
	/**
	 * Accepts a string, ensures the first char is capitalized, and searches it for the last uppercase char. When found 
	 * the method shifts all charters before it 1 index down and replace the current index with a space.
	 * The method then returns the modified string
	 * @param str the string to be made processed
	 * @return
	 */
	public static String camelCaseToUser(final String str){
		char[] str_arr = (str + ' ').toCharArray();	
		String h_str = str;			
		char c = ' ';
		//System.out.println(str);	
				
		int middle = (str_arr.length / 2);		//start from middle and go out from there
		int offset = 0;	
		int j = (str_arr.length-1);	
		int i = 1;
				
		if ((str_arr[0] > 96) && (str_arr[0] < 123))	//Checks if first char is a lower case letter
		{
			str_arr[0] = (char) (str_arr[0] - ' ');
		}
		
		while ((i != 0) && (i != (str_arr.length-1)))
		{			
			i = middle + offset;
			c = str_arr[i];

			if ((c >= 'A') && (c <= 'Z'))
			{
				while (j >= i)
				{
					str_arr[j] = str_arr[j-1];
					j--;
				}
				str_arr[j+1] = ' ';
				h_str = new String(str_arr);
				return h_str;
			}
			
			if(offset == 0)
			{
				offset++;
			}
			else
			{
				if (offset < 0)	
				{
					offset *=-1;
					offset++;
				}
				else
				{
					offset *=-1;
				}
			}
		}

		return h_str;
	}
}
