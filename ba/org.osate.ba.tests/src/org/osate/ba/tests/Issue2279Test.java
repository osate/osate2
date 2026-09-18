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

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Checks complete states for dispatchable components and components awaiting mode transitions. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue2279Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue2279/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void modalCategoriesRequireCompleteStatesInTypesAndImplementations() throws Exception {
		var root = testHelper.parseFile(PATH + "ModalCategories.aadl");
		var typeCategories = EnumSet.noneOf(ComponentCategory.class);
		var implementationCategories = EnumSet.noneOf(ComponentCategory.class);
		var messages = new ArrayList<String>();
		for (var classifier : root.getOwnedPublicSection().getOwnedClassifiers()) {
			var component = (ComponentClassifier) classifier;
			(component instanceof ComponentType ? typeCategories : implementationCategories).add(component.getCategory());
			messages.add(missingState(component.getQualifiedName(), "complete"));
		}
		var expected = EnumSet.complementOf(EnumSet.of(ComponentCategory.SUBPROGRAM_GROUP, ComponentCategory.SUBPROGRAM));
		assertDiagnostics(root, messages);
		assertEquals(expected, typeCategories);
		assertEquals(expected, implementationCategories);
	}

	@Test
	public void modalMemoryRequiresInitialAndCompleteStatesIncludingInheritedModes() throws Exception {
		assertDiagnostics(testHelper.parseFile(PATH + "Issue2279.aadl"), List.of(
				missingState("Issue2279::brain.missing_complete", "complete"),
				missingState("Issue2279::inherited.missing_initial", "initial"),
				missingState("Issue2279::brain.extended", "complete")));
	}

	@Test
	public void omittedStatesSectionStillReportsRequiredStates() throws Exception {
		var messages = new ArrayList<String>();
		for (var classifier : List.of("worker", "sensor", "scheduler", "storage", "storage.impl")) {
			messages.add(missingState("MissingStates::" + classifier, "initial"));
			messages.add(missingState("MissingStates::" + classifier, "complete"));
		}
		messages.add("MissingStates::routine has no initialstate : Behavior Annex D.3.(L1) legality rule failed.");
		messages.add("MissingStates::routine has no final state : Behavior Annex D.3.(L1) legality rule failed.");
		assertDiagnostics(testHelper.parseFile(PATH + "MissingStates.aadl"), messages);
	}

	@Test
	public void deviceDispatchNonmodalMemoryAndModalSubprogramRemainValid() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "Controls.aadl"));
	}

	private static String missingState(String classifier, String kind) {
		return classifier + " has no " + kind + " state : Behavior Annex D.3.(L3) legality rule failed.";
	}

	private void assertDiagnostics(AadlPackage root, List<String> messages) {
		var issues = validationHelper.validate(root);
		assertEquals(messages.stream().sorted().toList(),
				issues.stream().map(issue -> issue.getMessage()).sorted().toList());
		for (var issue : issues) {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("org.osate.xtext.aadl2.ba.checker", issue.getCode());
		}
	}
}
