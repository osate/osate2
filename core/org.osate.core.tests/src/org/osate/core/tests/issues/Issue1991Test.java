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
import org.osate.aadl2.ThreadImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1991Test extends XtextTest {
	private static final String FG_TEST = """
			package FGtest
			public
			\tfeature group FG
			\t\tfeatures
			\t\t\toutPort: out event port;
			\t\t\tinPort: in event port;
			\tend FG;
			\t
			\t
			\tthread T
			\t\tfeatures
			\t\t\tfg: feature group FG;
			\t\t\tfg_inv: feature group inverse of fg;
			\t\tflows
			\t\t\tfsrc1: flow source fg;
			    \t\tfsrc2: flow source fg_inv;

			    \t\tfsnk1: flow sink fg;
			    \t\tfsnk2: flow sink fg_inv;
			    \t\t

			    \t\tfpath1: flow path fg -> fg_inv;
			    \t\tfpath2: flow path fg_inv -> fg;
			    \t\tfpath3: flow path fg -> fg_inv;
			    \t\tfpath4: flow path fg_inv -> fg;
			\tend T;
			\t
			\tthread implementation T.impl
			\t\tflows
			\t\t\tfsrc1: flow source fg.inPort;\s
			    \t\tfsrc2: flow source fg_inv.outPort;\s
			    \t\t
			    \t\tfsnk1: flow sink fg.outPort;
			    \t\tfsnk2: flow sink fg_inv.inPort;\s

			    \t\tfpath1: flow path fg.outPort -> fg_inv.outPort;\s
			    \t\tfpath2: flow path fg_inv.inPort -> fg.inPort;
			    \t\tfpath3: flow path fg.inPort -> fg_inv.inPort;
			    \t\tfpath4: flow path fg_inv.outPort -> fg.outPort;
			\tend T.impl;
			end FGtest;
			""";

	private static final String FGT_TEST = """
			package FGTtest
			public
			\tfeature group FG
			\t\tfeatures
			\t\t\toutPort: out event port;
			\t\t\tinPort: in event port;
			\tend FG;
			\t
			\tfeature group FG_inv inverse of FG
			\tend FG_inv;
			\t
			\tthread T
			\t\tfeatures
			\t\t\tfg: feature group FG;
			\t\t\tfg_inv: feature group FG_inv;
			\t\tflows
			\t\t\tfsrc1: flow source fg;
			    \t\tfsrc2: flow source fg_inv;

			    \t\tfsnk1: flow sink fg;
			    \t\tfsnk2: flow sink fg_inv;

			    \t\tfpath1: flow path fg -> fg_inv;
			    \t\tfpath2: flow path fg_inv -> fg;
			    \t\tfpath3: flow path fg -> fg_inv;
			    \t\tfpath4: flow path fg_inv -> fg;
			\tend T;
			\t
			\tthread implementation T.impl
			\t\tflows
			\t\t\tfsrc1: flow source fg.inPort;
			    \t\tfsrc2: flow source fg_inv.outPort;\s
			    \t\t
			    \t\tfsnk1: flow sink fg.outPort;
			    \t\tfsnk2: flow sink fg_inv.inPort;\s
			    \t\t
			\t\t\tfpath1: flow path fg.outPort -> fg_inv.outPort;
			\t\t\tfpath2: flow path fg_inv.inPort -> fg.inPort;
			\t\t\tfpath3: flow path fg.inPort -> fg_inv.inPort;
			    \t\tfpath4: flow path fg_inv.outPort -> fg.outPort;
			\tend T.impl;
			end FGTtest;
			""";

	private static final String FG_IN_PORT_MUST_BE_OUT = "'fg.inPort' must be an out or in out feature.";

	private static final String FG_INV_OUT_PORT_MUST_BE_OUT = "'fg_inv.outPort' must be an out or in out feature.";

	private static final String FG_OUT_PORT_MUST_BE_IN = "'fg.outPort' must be an in or in out feature.";

	private static final String FG_INV_IN_PORT_MUST_BE_IN = "'fg_inv.inPort' must be an in or in out feature.";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	private ThreadImplementation threadImpl;

	@Test
	public void fgTest() throws Exception {
		load(FG_TEST, "FGtest", 2);
		assertFlowEndErrors();
	}

	@Test
	public void fgtTest() throws Exception {
		load(FGT_TEST, "FGTtest", 3);
		assertFlowEndErrors();
	}

	private void assertFlowEndErrors() {
		assertOutEndError(0, FG_IN_PORT_MUST_BE_OUT);
		assertOutEndError(1, FG_INV_OUT_PORT_MUST_BE_OUT);
		assertInEndError(2, FG_OUT_PORT_MUST_BE_IN);
		assertInEndError(3, FG_INV_IN_PORT_MUST_BE_IN);
		assertInEndError(4, FG_OUT_PORT_MUST_BE_IN);
		assertInEndError(5, FG_INV_IN_PORT_MUST_BE_IN);
		assertOutEndError(4, FG_INV_OUT_PORT_MUST_BE_OUT);
		assertOutEndError(5, FG_IN_PORT_MUST_BE_OUT);

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void load(String text, String expectedPackageName, int implIndex) throws Exception {
		testFileResult = issues = testHelper.testString(text);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals(expectedPackageName, pkg.getName());
		threadImpl = (ThreadImplementation) pkg.getPublicSection().getOwnedClassifiers().get(implIndex);
		assertEquals("T.impl", threadImpl.getName());
	}

	private void assertOutEndError(int flowIndex, String expectedMessage) {
		AssertHelper.assertError(threadImpl.getAllFlowImplementations().get(flowIndex).getOutEnd(),
				testFileResult.getIssues(), issueCollection, expectedMessage);
	}

	private void assertInEndError(int flowIndex, String expectedMessage) {
		AssertHelper.assertError(threadImpl.getAllFlowImplementations().get(flowIndex).getInEnd(),
				testFileResult.getIssues(), issueCollection, expectedMessage);
	}
}
