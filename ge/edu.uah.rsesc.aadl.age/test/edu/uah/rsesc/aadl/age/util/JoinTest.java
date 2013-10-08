package edu.uah.rsesc.aadl.age.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class JoinTest {

	//public static String join(final String[] segs, final int startIdx, final int endIdx, final String del)
	@Test
	public void test() {
		String[] test_str_arry = {"All","The","Strings","dot","JPEG"};
		int startId = 0;
		int endId = 3;
		String delimit = "-";
		
		StringUtil.join(test_str_arry, startId, endId, delimit);
		
		assertEquals("check if Valid Join","All-Strings", StringUtil.join(test_str_arry, startId, endId, delimit));

	}

}
