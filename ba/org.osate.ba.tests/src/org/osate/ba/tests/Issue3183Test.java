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

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Exercises otherwise-transition rules through embedded AADL validation. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3183Test extends XtextTest {
	private static final String MODELS = "org.osate.ba.tests/models/issue3183/";
	private static final String PRIORITY = "WARNING: An otherwise transition should not have an explicit priority: "
			+ "Behavior Annex D.3.";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void oneOtherwisePerSourceAndOrdinaryPriorityAreAccepted() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3183.aadl");
		validationHelper.assertNoIssues(root);
	}

	@Test
	public void allDuplicateOtherwiseTransitionsAreErrors() throws Exception {
		assertEquals(List.of(duplicate("first"), duplicate("first"), duplicate("first")),
				diagnostics("Duplicates"));
	}

	@Test
	public void overlappingSourcesOnlyConflictAtSharedState() throws Exception {
		assertEquals(List.of(duplicate("second"), duplicate("second")), diagnostics("OverlappingSources"));
	}

	@Test
	public void duplicateSourceGroupsCheckEverySource() throws Exception {
		// Three transitions expanded over two sources must diagnose both sources without dropping any reports.
		assertEquals(List.of(duplicate("first"), duplicate("first"), duplicate("first"), duplicate("second"),
				duplicate("second"), duplicate("second")), diagnostics("DuplicateSourceGroups"));
	}

	@Test
	public void explicitZeroAndPositivePrioritiesWarnOncePerDeclaration() throws Exception {
		assertEquals(List.of(PRIORITY, PRIORITY), diagnostics("Priorities"));
	}

	private static String duplicate(String state) {
		return "ERROR: State '" + state + "' must have at most one outgoing otherwise transition: Behavior Annex D.3.";
	}

	private List<String> diagnostics(String model) throws Exception {
		var root = testHelper.parseFile(MODELS + model + ".aadl");
		return validationHelper.validate(root).stream()
				.map(issue -> issue.getSeverity() + ": " + issue.getMessage()).sorted().toList();
	}
}
