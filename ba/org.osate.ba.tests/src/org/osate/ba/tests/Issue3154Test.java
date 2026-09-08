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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.analyzers.AadlBaRulesCheckersDriver;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;

/**
 * Exercises multi-source transitions through ordinary AADL validation: source-state rules apply to every source,
 * while shared condition and action diagnostics occur once. Also checks that strict transitions retain the shared
 * behavior so downstream consumers see the complete transition, with properly contained condition copies.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3154Test {
	private static final String MODELS = "org.osate.ba.tests/models/issue3154/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void completeSourcesRetainConditionAndActions() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3154.aadl");
		validationHelper.assertNoIssues(root);
		var annex = AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
		var strict = BehaviorAnnexUtil.getStrictModel(annex);
		var first = strict.getTransitions().get(1);
		var second = strict.getTransitions().get(2);
		assertNotNull(first.getCondition());
		assertNotNull(first.getActionBlock());
		assertNotSame(first.getCondition(), second.getCondition());
		assertTrue(EcoreUtil.equals(first.getCondition(), second.getCondition()));
		assertSame(first.getActionBlock(), second.getActionBlock());
		assertSame(first, first.getCondition().eContainer());
		assertSame(second, second.getCondition().eContainer());
		assertSame(strict, first.getActionBlock().eContainer());
		assertEquals(1, strict.getActions().size());
	}

	@Test
	public void executionSourcesEachReportDispatchError() throws Exception {
		var error = "ERROR: Only transition out of complete states may have dispatch condition : "
				+ "Behavior Annex D.3.(L6) legality rule failed.";
		assertEquals(List.of(error, error), diagnostics("ExecutionSources"));
	}

	@Test
	public void sharedConditionIsCheckedOnce() throws Exception {
		assertEquals(List.of("WARNING: Using a dispatch condition in an abstract component means this component can only be "
				+ "refined into a component category on which the Dispatch_Protocol property can be applied."),
				diagnostics("SharedCondition"));
	}

	@Test
	public void sharedActionIsCheckedOnce() throws Exception {
		assertEquals(List.of("ERROR: In timed actions, the value of  the first parameter must be lesser than the "
				+ "second one: Behavior Annex D.6.(L8) legality rule failed."), diagnostics("SharedAction"));
	}

	@Test
	public void sharedExecuteConditionIsTypeCheckedOnce() throws Exception {
		var issues = diagnostics("SharedTypeCondition");
		assertEquals(issues.toString(), 1, issues.size());
		assertTrue(issues.getFirst(), issues.getFirst().contains("type error for 'the execute condition'"));
	}

	@Test
	public void sharedActionIsTypeCheckedOnce() throws Exception {
		var issues = diagnostics("SharedTypeAction");
		assertEquals(issues.toString(), 1, issues.size());
		assertTrue(issues.getFirst(), issues.getFirst().contains("type error"));
	}

	@Test
	public void eachBoundSourceChecksModeConsistency() throws Exception {
		var root = testHelper.parseFile(MODELS + "ModeSources.aadl");
		var annex = AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
		var owner = (ComponentImplementation) annex.getContainingClassifier();
		var strict = EcoreUtil.copy(BehaviorAnnexUtil.getStrictModel(annex));
		var resource = new ResourceImpl();
		resource.getContents().add(strict);
		var first = strict.getTransitions().get(1).getSourceState();
		var second = strict.getTransitions().get(2).getSourceState();
		// Mode binding is not populated by the translator yet. Supply bindings through the public strict API
		// to isolate C4's per-source checks from that independent limitation.
		first.setBindedMode(owner.getOwnedModes().get(0));
		second.setBindedMode(owner.getOwnedModes().get(1));
		var manager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		new AadlBaRulesCheckersDriver(strict, owner, manager).process(strict);
		var errors = ((QueuingAnalysisErrorReporter) manager.getReporter(resource)).getErrors();
		assertEquals(errors.toString(), 2, errors.size());
		assertTrue(errors.stream().allMatch(error -> error.message.contains("D.3.(C4)")));
		assertEquals(List.of(first, second), errors.stream().map(error -> error.where).toList());
	}

	private List<String> diagnostics(String model) throws Exception {
		return testHelper.testFile(MODELS + model + ".aadl").getIssues().stream()
				.map(issue -> issue.getSeverity() + ": " + issue.getMessage()).toList();
	}
}
