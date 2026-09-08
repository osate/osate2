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
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue879Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/issue879/";

	private static final String FILE1 = "simple.aadl";

	private static final String FILE2 = "pkg1.aadl";

	private static final String FILE3 = "pkg2.aadl";

	private static final String WARNING_FLOW_EMPTY = "Flow implementation is empty and does not add value to the model";

	private static final String S_J = "S.j";

	private static final String S_K = "S.k";

	private static final String MY_SOURCE = "mySrc";

	private static final String MY_SINK = "mySink";

	private static final String MY_PATH = "myPath";

	private static final String A1_I = "a1.i";

	private static final String A2_I = "a2.i";

	private static final String INSTANCE_NAME = "a1_i_Instance";

	private static final String FPATH1 = "fpath1";

	private static final String FSRC1 = "fsrc1";

	private static final String ERROR_NO_END_TO_END_FLOW1 = "Cannot create end to end flow 'etef1' because there are no semantic connections that connect to the start of the flow 'fpath1' at feature 'af1'";

	private static final String ERROR_NO_END_TO_END_FLOW2 = "Cannot create end to end flow 'etef1' because there are no semantic connections that continue the flow 'fsrc1' from feature 'af2'";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void test1() throws Exception {
		AadlPackage pkg = testFile(FILE1);
		assertEquals("simple", pkg.getName());

		ComponentImplementation sj = implementationNamed(pkg, S_J);
		assertEmptyFlow(sj, MY_SOURCE);
		assertEmptyFlow(sj, MY_SINK);
		assertEmptyFlow(sj, MY_PATH);

		assertEmptyFlow(implementationNamed(pkg, S_K), MY_PATH);

		finish();
	}

	@Test
	public void test2() throws Exception {
		assertEmptyFlowThenInstantiationError(FILE2, "pkg1", FPATH1, ERROR_NO_END_TO_END_FLOW1);
	}

	@Test
	public void test3() throws Exception {
		assertEmptyFlowThenInstantiationError(FILE3, "pkg2", FSRC1, ERROR_NO_END_TO_END_FLOW2);
	}

	private void assertEmptyFlowThenInstantiationError(String file, String expectedPackageName, String flowSpecName,
			String expectedError) throws Exception {
		AadlPackage pkg = testFile(file);
		assertEquals(expectedPackageName, pkg.getName());

		assertEmptyFlow(implementationNamed(pkg, A2_I), flowSpecName);
		finish();

		ComponentImplementation a1i = implementationNamed(pkg, A1_I);
		AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		var instance = InstantiateModel.instantiate(a1i, errorManager);
		assertEquals(INSTANCE_NAME, instance.getName());
		var messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors();
		assertTrue(messages.size() == 1);
		assertEquals(QueuingAnalysisErrorReporter.Kind.ERROR, messages.get(0).kind);
		assertEquals(expectedError, messages.get(0).message);
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

	private static ComponentImplementation implementationNamed(AadlPackage pkg, String name) {
		return (ComponentImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> name.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
	}

	private void assertEmptyFlow(ComponentImplementation impl, String flowSpecName) {
		var flow = impl.getOwnedFlowImplementations()
				.stream()
				.filter(candidate -> flowSpecName.equals(candidate.getSpecification().getName()))
				.findFirst()
				.orElse(null);
		AssertHelper.assertWarning(flow, testFileResult.getIssues(), issueCollection, WARNING_FLOW_EMPTY);
	}
}
