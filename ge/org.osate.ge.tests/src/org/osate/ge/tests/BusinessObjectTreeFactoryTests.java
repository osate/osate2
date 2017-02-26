package org.osate.ge.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osate.ge.internal.boTree.BusinessObjectTree;
import org.osate.ge.internal.boTree.BusinessObjectTreeConfiguration;
import org.osate.ge.internal.boTree.BusinessObjectTreeFactory;
import org.osate.ge.internal.boTree.EnabledProviderGroupNode;

public class BusinessObjectTreeFactoryTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBusinessObjectTreeFactory() {
		// TODO: Move setup code to other functions as appropriate
		// TODO: Set with and without root business objects
			
		// TODO: Build list of all providers..
		// TODO: Build a list of rules
		// TODO: Build the enabled provider group nodes		
		
		final Collection<EnabledProviderGroupNode> enableRootProviderGroups = new ArrayList<>();
		
		final BusinessObjectTreeConfiguration config = new BusinessObjectTreeConfiguration(Collections.emptySet(), enableRootProviderGroups);
		
		// TODO: Pass in actual values
		final BusinessObjectTree tree = BusinessObjectTreeFactory.createBusinessObjectTree(config, Collections.emptyList(), null);
		
		// TODO: Assert that the tree is as it should be..
		
		//fail("Not yet implemented");
	}

}
