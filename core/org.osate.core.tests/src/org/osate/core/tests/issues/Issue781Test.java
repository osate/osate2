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
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.FlowImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue781Test extends XtextTest {
	private static final String AADL_TEXT = """
			package pkg1
			public
			\tabstract a1
			\t	features
			\t		af1: feature;
			\t		fg1: feature group fgt1;
			\t	flows
			\t		flow1: flow source af1;
			\t		flow2: flow sink af1;
			\t		flow3: flow path af1 -> af1;
			\t		flow4: flow source fg1;
			\t		flow5: flow sink fg1;
			\t		flow6: flow path fg1 -> fg1;
			\tend a1;
			\t
			\tabstract implementation a1.i
			\t  subcomponents
			\t    s1: abstract a1;
			\t    s2: abstract a1;
			\t  connections
			\t    c1: feature s1.af1 -> s2.af1;
			\tflows
			\t	flow1: flow source af1;
			\t	flow2: flow sink af1;
			\t	flow3: flow path af1 -> af1;
			\t	flow4: flow source fg1.af2;
			\t	flow5: flow sink fg1.af2;
			\t	flow6: flow path fg1.af2 -> fg1.af2;
			\tend a1.i;
			\t
			\tfeature group fgt1
			\t	features
			\t		af2: feature;
			\tend fgt1;
			end pkg1;
			""";

	private static final String EMPTY_FLOW = "Flow implementation is empty and does not add value to the model";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void testIssue781() throws Exception {
		testFileResult = issues = testHelper.testString(AADL_TEXT);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("pkg1", pkg.getName());

		AbstractImplementation impl = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("a1.i", impl.getName());
		var flows = impl.getOwnedFlowImplementations();
		assertEmptyFlow(flows.get(0), "flow1");
		assertEmptyFlow(flows.get(1), "flow2");
		assertEmptyFlow(flows.get(2), "flow3");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void assertEmptyFlow(FlowImplementation flow, String expectedSpecName) {
		assertEquals(expectedSpecName, flow.getSpecification().getName());
		AssertHelper.assertWarning(flow, testFileResult.getIssues(), issueCollection, EMPTY_FLOW);
	}
}
