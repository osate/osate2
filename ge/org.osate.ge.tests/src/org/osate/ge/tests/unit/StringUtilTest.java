package org.osate.ge.tests.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.osate.ge.internal.util.StringUtil;

public class StringUtilTest {

	@Test
	public void Jointest() {
		String[] test_str_arry = {"All","The","Strings","dot","JPEG"};
		int startId = 0;
		int endId = 4;
		String delimit = "-";
				
		assertEquals("check if Valid Join","All-The-Strings-dot", StringUtil.join(test_str_arry, startId, endId, delimit));

	}
	@Test
	public void camelCaseTest()
	{
		String testStr = "testMethodOneTwoThreeFourFiveSixSeven";
		assertEquals("Test if camelCase method works","Test Method One Two Three Four Five Six Seven", StringUtil.camelCaseToUser(testStr));
	}
}
