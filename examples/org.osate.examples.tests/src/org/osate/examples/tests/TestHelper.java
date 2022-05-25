package org.osate.examples.tests;

import java.util.ArrayList;

import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.osate.aadl2.AadlPackage;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@Singleton
public class TestHelper extends XtextTest {
	@Inject
	private org.osate.testsupport.TestHelper<AadlPackage> testHelper;

	@Test
	public void ValidationAndInstantiationTest(ExampleConfig config) throws Exception {
		for (ExampleEntry entry : config.entries) {
			this._before();
			var testFileResult = issues = testHelper.testFile(config.bundle + "/" + entry.entry,
					entry.references.toArray(new String[] {}));
			var issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<Issue>(),
					new ArrayList<String>());

			issueCollection.sizeIs(testFileResult.getIssues().size());
			assertConstraints(issueCollection);
		}
	}
}