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
package org.osate.ba.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.DispatchCondition;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Verifies that invalid frozen-list names are diagnosed without breaking strict-model translation. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3263Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3263/";
	private static final String FROZEN_PORT = "org.osate.xtext.aadl2.ba.frozenPort";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void behaviorVariableInFrozenListIsReportedOnTheReference() throws Exception {
		var root = testHelper.parseFile(PATH + "Issue3263.aadl");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root);
		assertEquals(issues.toString(), 1, issues.size());
		var issue = issues.getFirst();
		assertEquals(Severity.ERROR, issue.getSeverity());
		assertEquals(FROZEN_PORT, issue.getCode());
		assertEquals("v", source.substring(issue.getOffset(), issue.getOffset() + issue.getLength()));
		assertEquals("'v' is not a frozen port: a frozen list can only name an incoming port", issue.getMessage());
	}

	@Test
	public void invalidFrozenReferenceIsOmittedFromTheStrictModel() throws Exception {
		var dispatch = strictDispatch("Issue3263.aadl");
		assertEquals(List.of(), dispatch.getFrozenPorts());
	}

	@Test
	public void incomingFrozenPortRemainsInTheStrictModel() throws Exception {
		var root = testHelper.parseFile(PATH + "IncomingFrozenPort.aadl");
		validationHelper.assertNoIssues(root);
		var dispatch = strictDispatch(root);
		assertEquals(List.of("incoming"),
				dispatch.getFrozenPorts().stream().map(port -> port.getPort().getName()).toList());
	}

	private DispatchCondition strictDispatch(String model) throws Exception {
		return strictDispatch(testHelper.parseFile(PATH + model));
	}

	private static DispatchCondition strictDispatch(AadlPackage root) {
		var annex = AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
		var strict = BehaviorAnnexUtil.getStrictModel(annex);
		return (DispatchCondition) strict.getTransitions().getFirst().getCondition();
	}
}
