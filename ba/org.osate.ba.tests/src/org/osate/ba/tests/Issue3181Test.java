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
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.List;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.SubprogramCallAction;
import org.osate.ba.aadlba.Target;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Exercises communication targets and complete call signatures through embedded BA validation. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3181Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3181/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void inheritedRefinedAndPrototypeSignaturesRetainTheirOrder() throws Exception {
		var root = testHelper.parseFile(PATH + "InheritedCalls.aadl");
		validationHelper.assertNoIssues(root);
	}

	@Test
	public void validCommunicationsAndCallFormsAreAccepted() throws Exception {
		var root = testHelper.parseFile(PATH + "Issue3181.aadl");
		validationHelper.assertNoIssues(root);
		var annex = BehaviorAnnexUtil.getStrictModel(AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst());
		var call = (SubprogramCallAction) annex.getTransitions().get(5).getActionBlock().getContent();
		assertEquals(5, call.getParameterLabels().size());
		assertTrue("A record field used as an out actual must remain a target",
				call.getParameterLabels().get(1) instanceof Target);
		assertTrue("An output port formal must retain its target", call.getParameterLabels().get(4) instanceof Target);
	}

	@Test
	public void communicationTargetsAndPayloadCountsAreChecked() throws Exception {
		assertDiagnostics("CommunicationTargets",
				List.of(new Expected("input", "A port send action requires an outgoing port"),
						new Expected("output", "A dequeue action requires an incoming event or event data port"),
						new Expected("input_data", "A dequeue action requires an incoming event or event data port"),
						new Expected("output", "A freeze action requires an incoming port"),
						new Expected("value",
								"A send or call action requires a port, internal feature, or callable subprogram"),
						new Expected("value", "A dequeue action requires an incoming event or event data port"),
						new Expected("value", "A freeze action requires an incoming port"),
						new Expected("value", "A lock or unlock action requires a required data access"),
						new Expected("provided", "A lock or unlock action requires a required data access"),
						new Expected("output!(1, 2)", "A port send action accepts at most one value"),
						new Expected("output_event!(1)", "An event port send action cannot carry a value"),
						new Expected("input_event?(value)", "An event port dequeue action cannot assign a data value"),
						new Expected("input_data", "A dequeue target must be writable"),
						new Expected("output_event", "A dequeue target must be writable")));
	}

	@Test
	public void internalSendCannotDiscardExtraValues() throws Exception {
		assertDiagnostics("InternalSend",
				List.of(new Expected("internal_data!(1, 2)", "A port send action accepts at most one value")));
	}

	@Test
	public void everyFormalCountsForEveryCallableForm() throws Exception {
		assertDiagnostics("CallCounts",
				List.of(new Expected("operation!", "Subprogram call requires 5 actuals but has 0"),
						new Expected("operation.i!(1)", "Subprogram call requires 5 actuals but has 1"),
						new Expected("call_access!(1, value)", "Subprogram call requires 5 actuals but has 2"),
						new Expected("local_call!(1, value, value, value, value, value)",
								"Subprogram call requires 5 actuals but has 6")));
	}

	@Test
	public void parameterDirectionsRequireReadableValuesAndWritableTargets() throws Exception {
		assertDiagnostics("CallActuals",
				List.of(new Expected("2", "Actual for out parameter 'result' must be a writable target"),
						new Expected("value + 1", "Actual for out parameter 'result' must be a writable target"),
						new Expected("input", "Actual for out parameter 'result' must be a writable target"),
						new Expected("output", "Actual for in parameter 'argument' must be readable"),
						new Expected("i", "Actual for out parameter 'result' must be a writable target")));
	}

	@Test
	public void dataAccessAndPortActualsMatchTheirFormalCategories() throws Exception {
		assertDiagnostics("FeatureActuals", List.of(
				new Expected("2", "Actual for data access 'shared' must reference data"),
				new Expected("2", "Actual for port 'signal' must reference a port of the same category and direction"),
				new Expected("input_event",
						"Actual for port 'signal' must reference a port of the same category and direction"),
				new Expected("output",
						"Actual for port 'signal' must reference a port of the same category and direction")));
	}

	@Test
	public void inputActualExpressionsAreTypeChecked() throws Exception {
		var root = testHelper.parseFile(PATH + "CallExpressions.aadl");
		var issues = validationHelper.validate(root);
		assertEquals(issues.toString(), 1, issues.size());
		assertEquals(Severity.ERROR, issues.getFirst().getSeverity());
		assertTrue(issues.toString(), issues.getFirst().getMessage().contains("and"));
	}

	private void assertDiagnostics(String model, List<Expected> expected) throws Exception {
		var root = testHelper.parseFile(PATH + model + ".aadl");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		assertEquals(issues.toString(), expected.size(), issues.size());
		assertEquals(expected, issues.stream().map(issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			return new Expected(source.substring(issue.getOffset(), issue.getOffset() + issue.getLength()),
					issue.getMessage());
		}).toList());
	}

	private record Expected(String target, String message) {
	}
}
