package edu.uah.rsesc.aadl.age.util;

import static org.junit.Assert.*;

import org.junit.Test;

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
	//.camelCaseToUser("testMethod5")
	public void camelCaseTest()
	{
		String testStr = "TestMethod1";
		assertEquals("Test is camelCase method works","Test Method1", StringUtil.camelCaseToUser(testStr));

	}
}
