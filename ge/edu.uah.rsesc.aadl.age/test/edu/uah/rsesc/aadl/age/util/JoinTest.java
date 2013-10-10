package edu.uah.rsesc.aadl.age.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class JoinTest {

	//public static String join(final String[] segs, final int startIdx, final int endIdx, final String del)
	@Test
	public void test() {
		String[] test_str_arry = {"All","The","Strings","dot","JPEG"};
		int startId = 0;
		int endId = 4;
		String delimit = "-";
				
		assertEquals("check if Valid Join","All-The-Strings-dot", StringUtil.join(test_str_arry, startId, endId, delimit));

	}

}
