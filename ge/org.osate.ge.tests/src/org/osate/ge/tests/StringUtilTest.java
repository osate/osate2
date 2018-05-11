/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.tests;

import static org.junit.Assert.*;

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
