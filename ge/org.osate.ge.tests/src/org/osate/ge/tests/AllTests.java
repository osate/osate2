package org.osate.ge.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AgeDiagramTests.class,
	DiagramUpdaterTests.class,
	DiagramStorageTests.class})
public class AllTests {
}
