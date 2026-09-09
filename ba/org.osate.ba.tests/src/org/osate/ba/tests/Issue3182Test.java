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
import static org.junit.Assert.assertNull;
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
import org.osate.aadl2.ComponentClassifier;
import org.osate.annexsupport.AnnexUtil;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Tests the shared D.3 declaration namespace through embedded AADL validation and strict translation. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3182Test extends XtextTest {
	private static final String MODELS = "org.osate.ba.tests/models/issue3182/";
	private static final String NAMING = "org.osate.xtext.aadl2.ba.declarationName";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void duplicateNamesMarkEveryDeclaration() throws Exception {
		// Triples cover the first, second, and later declarations, within and across groups. Cross-kind pairs
		// verify that variables, states, and transition labels share one case-insensitive namespace.
		assertNames("Duplicates", List.of("same", "SAME", "Same", "varState", "varTransition", "dupState",
				"DUPSTATE", "DupState", "VARSTATE", "stateTransition", "dupTransition", "DUPTRANSITION",
				"DupTransition", "VARTRANSITION", "STATETRANSITION"));
	}

	@Test
	public void inheritedEnclosingNamesConflictWithAllDeclarationKinds() throws Exception {
		// Complete states are exempt only for modes, never for features or data subcomponents.
		assertNames("EnclosingNames", List.of("VFEATURE", "VDATA", "VMODE", "SFEATURE", "SDATA", "SMODE",
				"COMPLETEFEATURE", "COMPLETEDATA", "TFEATURE", "TDATA", "TMODE"));
	}

	@Test
	public void componentTypeAnnexChecksInheritedFeaturesAndModes() throws Exception {
		assertNames("TypeNames", List.of("INPUT", "ACTIVE"));
	}

	@Test
	public void namesAreCheckedEvenWithUnresolvedClassifier() throws Exception {
		var root = testHelper.parseFile(MODELS + "UnlinkedNames.aadl");
		var issues = validationHelper.validate(root);
		var linkingIssues = issues.stream().filter(issue -> !NAMING.equals(issue.getCode())).toList();
		assertTrue(linkingIssues.toString(), !linkingIssues.isEmpty() && linkingIssues.stream()
				.allMatch(issue -> issue.getMessage().contains("MissingType")));
		assertEquals(List.of("value", "VALUE"), markedNames(root, issues));
	}

	@Test
	public void legalNamesAndCompleteModeStatesAreAccepted() throws Exception {
		// Separate annexes may reuse names; non-data subcomponents and implementation-only data do not conflict.
		var root = testHelper.parseFile(MODELS + "Issue3182.aadl");
		validationHelper.assertNoIssues(root);
	}

	@Test
	public void duplicateVariableReferenceDoesNotSelectDeclarationOrEnclosingFeature() throws Exception {
		var root = testHelper.parseFile(MODELS + "AmbiguousVariables.aadl");
		var annex = (BehaviorAnnex) AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst().getParsedAnnexSubclause();
		var translation = new DeclarativeToStrictTranslator().translate(annex,
				(ComponentClassifier) annex.getContainingClassifier());
		assertEquals(3, translation.getStrictAnnex().getVariables().size());
		var references = 0;
		for (var contents = annex.eAllContents(); contents.hasNext();) {
			if (contents.next() instanceof ReferenceSegment segment) {
				references++;
				assertNull("An ambiguous variable must not select either a duplicate or the enclosing feature",
						translation.getResolvedReference(segment));
			}
		}
		assertEquals(1, references);
	}

	private void assertNames(String model, List<String> expected) throws Exception {
		var root = testHelper.parseFile(MODELS + model + ".aadl");
		var issues = validationHelper.validate(root);
		assertTrue(issues.toString(), issues.stream().allMatch(issue -> NAMING.equals(issue.getCode())));
		assertEquals(expected, markedNames(root, issues));
	}

	private List<String> markedNames(AadlPackage root, List<Issue> issues) {
		var text = NodeModelUtils.getNode(root).getRootNode().getText();
		return issues.stream().filter(issue -> NAMING.equals(issue.getCode()))
				.sorted(Comparator.comparing(Issue::getOffset)).map(issue -> {
					assertEquals(Severity.ERROR, issue.getSeverity());
					return text.substring(issue.getOffset(), issue.getOffset() + issue.getLength());
				}).toList();
	}
}
