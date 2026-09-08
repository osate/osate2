/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ThreadImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1987Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue1987/";

	private static final String FILE1 = "DataTest.aadl";

	private static final String FILE2 = "DataTestBad.aadl";

	private static final String FILE3 = "EndToEndFlowData.aadl";

	private static final String FILE4 = "SubprogramCallTest.aadl";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void testDataAsFlowSourceSink_good() throws Exception {
		AadlPackage pkg = testFile(FILE1);
		assertEquals("DataTest", pkg.getName());
		finish();
	}

	@Test
	public void testDataAsFlowSourceSink_bad() throws Exception {
		AadlPackage pkg = testFile(FILE2);
		assertEquals("DataTestBad", pkg.getName());

		ThreadImplementation ti = (ThreadImplementation) classifierNamed(pkg, "T.i");
		AssertHelper.assertError(flowNamed(ti, "fsrc").getOwnedFlowSegments().get(1), testFileResult.getIssues(),
				issueCollection,
				"The source component 'myData' of connection 'c' does not match the preceding subcomponent 'myData2'");

		ThreadImplementation tti = (ThreadImplementation) classifierNamed(pkg, "TT.i");
		AssertHelper.assertError(flowNamed(tti, "fsnk").getOwnedFlowSegments().get(0), testFileResult.getIssues(),
				issueCollection,
				"The destination component 'myData' of connection 'c' does not match the succeeding subcomponent "
						+ " 'myData2'");
		finish();
	}

	@Test
	public void testEndToEndFlowData() throws Exception {
		AadlPackage pkg = testFile(FILE3);
		assertEquals("EndToEndFlowData", pkg.getName());

		ProcessImplementation top = (ProcessImplementation) classifierNamed(pkg, "P.top");
		var e2eBad = top.getOwnedEndToEndFlows()
				.stream()
				.filter(flow -> "e2e_bad".equals(flow.getName()))
				.findFirst()
				.orElse(null);
		AssertHelper.assertError(e2eBad.getOwnedEndToEndFlowSegments().get(1), testFileResult.getIssues(),
				issueCollection,
				"The source of connection 'c1' does not match the preceding subcomponent or out flow spec feature"
						+ " 'dataD2'");
		AssertHelper.assertError(e2eBad.getOwnedEndToEndFlowSegments().get(3), testFileResult.getIssues(),
				issueCollection,
				"The destination of connection 'c2' does not match the succeeding subcomponent or in flow spec feature"
						+ " 'dataE2'");
		finish();
	}

	@Test
	public void testSubprogramCalls() throws Exception {
		AadlPackage pkg = testFile(FILE4);
		assertEquals("SubprogramCallTest", pkg.getName());

		ThreadImplementation ti = (ThreadImplementation) classifierNamed(pkg, "T.i");

		var fsrc = flowNamed(ti, "fsrc");
		AssertHelper.assertError(fsrc.getOwnedFlowSegments().get(1), testFileResult.getIssues(), issueCollection,
				"The destination component 'call1' of connection 'b' does not match the succeeding subcomponent "
						+ " 'dummy'");
		AssertHelper.assertError(fsrc.getOwnedFlowSegments().get(3), testFileResult.getIssues(), issueCollection,
				"The source of connection 'c' does not match the preceding subcomponent 'dummy'");

		var fsnk = flowNamed(ti, "fsnk");
		AssertHelper.assertError(fsnk.getOwnedFlowSegments().get(0), testFileResult.getIssues(), issueCollection,
				"The destination component 'call2' of connection 'e' does not match the succeeding subcomponent "
						+ " 'dummy'");
		AssertHelper.assertError(fsnk.getOwnedFlowSegments().get(2), testFileResult.getIssues(), issueCollection,
				"The source of connection 'f' does not match the preceding subcomponent 'dummy'");
		finish();
	}

	private AadlPackage testFile(String file) throws Exception {
		testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + file);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		return (AadlPackage) testFileResult.getResource().getContents().get(0);
	}

	private void finish() {
		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private static Classifier classifierNamed(AadlPackage pkg, String name) {
		return pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> name.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
	}

	private static FlowImplementation flowNamed(ComponentImplementation impl, String specName) {
		return impl.getOwnedFlowImplementations()
				.stream()
				.filter(flow -> specName.equals(flow.getSpecification().getName()))
				.findFirst()
				.orElse(null);
	}
}
