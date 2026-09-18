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
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Exercises shared-data resource lifetime through the embedded BA validator. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3189Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3189/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void balancedPathsAndUnreachableLocksAreAccepted() throws Exception {
		var root = testHelper.parseFile(PATH + "Balanced.aadl");
		validationHelper.assertNoIssues(root);
	}

	@Test
	public void unreleasedResourceIsReported() throws Exception {
		assertDiagnostics("Issue3189", List.of(new Expected("unreleased", "d")));
	}

	@Test
	public void alternativeBranchesPreservePossibleLocks() throws Exception {
		assertDiagnostics("Branches", List.of(new Expected("missingElse", "d", Severity.INFO),
				new Expected("oneBranch", "d", Severity.INFO), new Expected("elseIf", "d", Severity.INFO)));
	}

	@Test
	public void actionSetsConsiderEveryOrder() throws Exception {
		assertDiagnostics("ActionSets", List.of(new Expected("order", "d"), new Expected("nestedOrder", "d"),
				new Expected("unrelatedRelease", "d")));
	}

	@Test
	public void loopsAccountForSkippedAndRepeatedBodies() throws Exception {
		assertDiagnostics("Loops",
				List.of(new Expected("whileLock", "d", Severity.INFO), new Expected("whileMaySkip", "d", Severity.INFO),
						new Expected("doLock", "d", Severity.INFO), new Expected("forLock", "d"),
						new Expected("forallLock", "d"), new Expected("emptyRelease", "d")));
	}

	@Test
	public void wildcardOperationsIncludeInheritedRequiredAccesses() throws Exception {
		assertDiagnostics("Wildcards", List.of(new Expected("inheritedLock", "d"), new Expected("allLocked", "d"),
				new Expected("allLocked", "e"), new Expected("partialRelease", "e")));
	}

	@Test
	public void locksFlowThroughTransitionsJoinsAndCycles() throws Exception {
		assertDiagnostics("Transitions",
				List.of(new Expected("leaked", "d", Severity.INFO), new Expected("exitCycle", "d", Severity.INFO)));
	}

	@Test
	public void groupedResourcesRetainTheirAccessPaths() throws Exception {
		assertDiagnostics("GroupedResources",
				List.of(new Expected("wrongGroup", "left.d"), new Expected("allGroups", "nested.inner.d")));
	}

	@Test
	public void potentialFalsePositivesAreInformational() throws Exception {
		assertDiagnostics("PotentialFalsePositives", List.of(new Expected("correlated", "d", Severity.INFO),
				new Expected("bothBranches", "d"), new Expected("contradictory", "d", Severity.INFO)));
	}

	private void assertDiagnostics(String model, List<Expected> expected) throws Exception {
		var root = testHelper.parseFile(PATH + model + ".aadl");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root)
				.stream()
				.sorted(Comparator.comparing(Issue::getOffset).thenComparing(Issue::getMessage))
				.toList();
		assertEquals(issues.toString(), expected.size(), issues.size());
		for (var i = 0; i < expected.size(); i++) {
			var issue = issues.get(i);
			var diagnostic = expected.get(i);
			assertEquals(diagnostic.severity(), issue.getSeverity());
			assertEquals("Complete state 'ready' may be reached while shared data '" + diagnostic.resource()
					+ "' remains locked: Behavior Annex D.6.", issue.getMessage());
			var target = source.substring(issue.getOffset(), issue.getOffset() + issue.getLength());
			assertTrue(target, target.startsWith(diagnostic.transition() + " :"));
		}
	}

	private record Expected(String transition, String resource, Severity severity) {
		private Expected(String transition, String resource) {
			this(transition, resource, Severity.ERROR);
		}
	}
}
