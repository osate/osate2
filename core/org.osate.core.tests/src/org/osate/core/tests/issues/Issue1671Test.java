package org.osate.core.tests.issues;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1671Test {
	private static final String PATH = "org.osate.core.tests/models/issue1671/";
	
	@Inject
	private TestHelper<AadlPackage> testHelper;
	
	@Inject
	private ValidationTestHelper validationHelper;
	
	@Test
	public void testAaronExample() {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "aaron_example.aadl"));
	}
	
	@Test
	public void testInverseOnly() {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "inverse_only.aadl"));
	}
	
	@Test
	public void testNotDiamond() {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "not_diamond.aadl"));
	}
}