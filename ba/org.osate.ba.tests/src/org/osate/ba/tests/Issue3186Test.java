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
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Mode;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Exercises the AS5506/3 Rev. A D.3 restrictions on external conditions by component category and {@code in modes}
 * context, and the inheritance and replacement of Behavior Annex subclauses through the public access path.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3186Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3186/";
	private static final String CHECKER = "org.osate.xtext.aadl2.ba.checker";
	private static final String EXTERNAL_CONDITION_IN_MODES = "org.osate.xtext.aadl2.ba.externalConditionInModes";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/** A component of a category other than thread and subprogram may leave an execution state on an event. */
	@Test
	public void externalConditionIsAcceptedOutOfAnExecutionState() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "Issue3186.aadl"));
	}

	@Test
	public void threadCannotUseAnExternalCondition() throws Exception {
		assertDiagnostics("ThreadExternalCondition", List.of(new Expected("on go", CHECKER,
				"thread components cannot use an external condition: an execute, dispatch, or internal condition must"
						+ " be used instead: Behavior Annex D.3 consistency rule failed.")));
	}

	/**
	 * The fixture's trigger is an outgoing event port because core AADL admits no other event port on a subprogram,
	 * so no subprogram can name the incoming port the D.3 event_trigger production asks for. The rule constrains the
	 * form of the condition rather than its triggers, so it is reported alongside the trigger-direction error.
	 */
	@Test
	public void subprogramCannotUseAnExternalCondition() throws Exception {
		assertDiagnostics("SubprogramExternalCondition", List.of(new Expected("on go", CHECKER,
				"subprogram components cannot use an external condition: an execute or internal condition must be used"
						+ " instead: Behavior Annex D.3 consistency rule failed."),
				new Expected("go", "org.osate.xtext.aadl2.ba.externalConditionTrigger",
						"'go' is not an external-condition trigger: expected an incoming event or event data port"
								+ " of the component, or an outgoing event or event data port of a subcomponent")));
	}

	/** Only external conditions leave the complete state, so the device rule has nothing to reject. */
	@Test
	public void deviceMayLeaveACompleteStateOnExternalConditionsAlone() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "DeviceExternalCondition.aadl"));
	}

	/** Each condition of the state is equally part of the mixture, so each one is reported. */
	@Test
	public void deviceCannotMixExternalAndDispatchConditionsOutOfOneCompleteState() throws Exception {
		var mixture = "The transitions out of complete state 'idle' of a device must use either only external"
				+ " conditions or only dispatch conditions: Behavior Annex D.3 consistency rule failed.";
		assertDiagnostics("DeviceConditionMix",
				List.of(new Expected("on dispatch go", CHECKER, mixture), new Expected("on go", CHECKER, mixture)));
	}

	/**
	 * An external condition describes the mode transition of a mode-representing complete state, so its triggers are
	 * checked against that mode transition the way a dispatch condition's triggers are.
	 */
	@Test
	public void externalConditionTriggersMustMatchTheModeTransition() throws Exception {
		assertDiagnostics("DeviceExternalTriggerMismatch", List.of(new Expected("on wrong", CHECKER,
				"The behavior transition tries to refine a transition mode but it is not consisting with any transition"
						+ " mode of DeviceExternalTriggerMismatch::sensor.impl component: Behavior Annex D.3.(C4)"
						+ " consistency rule failed.")));
	}

	@Test
	public void inModesSubclauseCannotUseAnExternalCondition() throws Exception {
		assertDiagnostics("InModesExternalCondition", List.of(new Expected("on go", EXTERNAL_CONDITION_IN_MODES,
				"A Behavior Annex subclause with an in modes statement cannot use an external condition: Behavior"
						+ " Annex D.3 consistency rule failed.")));
	}

	@Test
	public void inModesSubclauseMayUseAnExecuteCondition() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "InModesExecuteCondition.aadl"));
	}

	@Test
	public void classifierSubclauseAppliesToItself() throws Exception {
		assertStates(subclauses("base.impl"), List.of(List.of("waiting", "running")));
	}

	@Test
	public void ancestorSubclauseAppliesToADescendantThatDeclaresNone() throws Exception {
		assertStates(subclauses("base.inherited"), List.of(List.of("waiting", "running")));
	}

	@Test
	public void descendantSubclauseReplacesTheAncestorOne() throws Exception {
		assertStates(subclauses("base.replaced"), List.of(List.of("only")));
	}

	@Test
	public void typeSubclauseAppliesToAnImplementationThatDeclaresNone() throws Exception {
		assertStates(subclauses("base.fromtype"), List.of(List.of("fromtype")));
	}

	/** D.3 lets a component with modes declare a separate subclause for each mode. */
	@Test
	public void everyModalSubclauseOfTheClassifierApplies() throws Exception {
		assertStates(BehaviorAnnexUtil.getBehaviorAnnexSubclauses(modalClassifier("modal.impl")),
				List.of(List.of("whennormal"), List.of("whenbackup")));
	}

	@Test
	public void modalSubclausesAreSelectedByMode() throws Exception {
		var owner = modalClassifier("modal.impl");
		assertStates(BehaviorAnnexUtil.getBehaviorAnnexSubclauses(owner, mode(owner, "normal")),
				List.of(List.of("whennormal")));
		assertStates(BehaviorAnnexUtil.getBehaviorAnnexSubclauses(owner, mode(owner, "backup")),
				List.of(List.of("whenbackup")));
	}

	/** A subclause without an in modes statement is in effect in every mode. */
	@Test
	public void subclauseWithoutInModesIsSelectedInEveryMode() throws Exception {
		var owner = modalClassifier("modal.always");
		assertStates(BehaviorAnnexUtil.getBehaviorAnnexSubclauses(owner, mode(owner, "normal")),
				List.of(List.of("anymode")));
		assertStates(BehaviorAnnexUtil.getBehaviorAnnexSubclauses(owner, mode(owner, "backup")),
				List.of(List.of("anymode")));
	}

	private List<DefaultAnnexSubclause> subclauses(String classifierName) throws Exception {
		return BehaviorAnnexUtil.getBehaviorAnnexSubclauses(classifier("Inheritance", classifierName));
	}

	private ComponentClassifier modalClassifier(String classifierName) throws Exception {
		return classifier("ModalSubclauses", classifierName);
	}

	private ComponentClassifier classifier(String model, String classifierName) throws Exception {
		return (ComponentClassifier) testHelper.parseFile(PATH + model + ".aadl").getOwnedPublicSection()
				.getOwnedClassifiers().stream()
				.filter(candidate -> classifierName.equalsIgnoreCase(candidate.getName()))
				.findFirst()
				.orElseThrow();
	}

	private static void assertStates(List<DefaultAnnexSubclause> subclauses, List<List<String>> expected) {
		assertEquals(expected, subclauses.stream()
				.map(subclause -> BehaviorAnnexUtil.getStrictModel(subclause).getStates().stream()
						.map(org.osate.ba.aadlba.BehaviorState::getName)
						.toList())
				.toList());
	}

	private static Mode mode(ComponentClassifier owner, String name) {
		return owner.getAllModes().stream()
				.filter(mode -> name.equalsIgnoreCase(mode.getName()))
				.findFirst()
				.orElseThrow();
	}

	private void assertDiagnostics(String model, List<Expected> expected) throws Exception {
		var root = testHelper.parseFile(PATH + model + ".aadl");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		assertEquals(issues.toString(), expected.size(), issues.size());
		assertEquals(expected, issues.stream().map(issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			var target = source.substring(issue.getOffset(), issue.getOffset() + issue.getLength());
			return new Expected(target, issue.getCode(), issue.getMessage());
		}).toList());
	}

	private record Expected(String target, String code, String message) {
	}
}
