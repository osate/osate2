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
public class Issue1831Test {
	@Inject
	private TestHelper<AadlPackage> testHelper;
	
	@Inject
	private ValidationTestHelper validationHelper;
	
	@Test
	public void testIssue1831() {
		validationHelper.assertNoIssues(testHelper.parseFile("org.osate.core.tests/models/issue1831/issue_flow_refined_conn.aadl"));
	}
}