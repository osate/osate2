package edu.uah.rsesc.aadl.age.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CamelCaseTest {

	@Test
	public void test() {
		//StringUtil tester = new StringUtil();
		String test_str1 = "testMethod1";
		String test_str2 = "Testmethod2";
		String test_str3 = "testmethod3";
		
		assertEquals("check if test Method1 is output","Test Method1",StringUtil.camelCaseToUser(test_str1) );
		assertEquals("check if Test Method2 is output","Testmethod2",StringUtil.camelCaseToUser(test_str2) );
		assertEquals("check if test Method3 is output","testmethod3",StringUtil.camelCaseToUser(test_str3) );
	}

}
