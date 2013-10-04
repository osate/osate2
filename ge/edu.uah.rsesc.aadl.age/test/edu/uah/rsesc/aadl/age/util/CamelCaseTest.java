package edu.uah.rsesc.aadl.age.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CamelCaseTest {

	@Test
	public void test() {
		//StringUtil tester = new StringUtil();
		String test_str1 = "testMethod1";
		String test_str2 = "TestMethod1";
		
		assertEquals("check if test Method1 is output","test Method1",StringUtil.camelCaseToUser(test_str1) );
		assertEquals("check if Test Method1 is output","Test Method1",StringUtil.camelCaseToUser(test_str2) );
	}

}
