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
package org.osate.ba.tests.characterization;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Element;
import org.osate.ba.tests.BehaviorAnnexInjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

/**
 * Records the diagnostics of the complete Behavior Annex corpus with the BA validator registered, which is the
 * configuration an OSATE user sees. {@link BehaviorAnnexCharacterizationTest} deliberately keeps the other half of the
 * pair: it parses and translates the same corpus with the plain AADL injector, so its {@code expected/diagnostics}
 * goldens contain only core-AADL findings. Two golden sets are needed because the semantic checks a model reaches
 * depend on that registration, and neither set alone shows which findings the BA front end contributes.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class BehaviorAnnexValidatedDiagnosticsTest {
	private static final String SUITE = "diagnostics-validated";

	@Inject
	private TestHelper<Element> testHelper;

	@Test
	public void validatedDiagnosticsMatchGoldens() throws Exception {
		var caseCount = 0;
		var behaviorAnnexRuleDiagnostics = 0;
		for (final var corpusCase : BehaviorAnnexCorpus.discover()) {
			final var root = testHelper.parseFile(corpusCase.getPath(), corpusCase.getReferencedPaths());
			assertNotNull("Could not load " + corpusCase.getPath(), root);

			final var issues = testHelper.testResource(root.eResource()).getIssues();
			GoldenFile.assertMatches(SUITE, corpusCase.getId(),
					BehaviorAnnexCharacterizationTest.formatDiagnostics(issues));
			behaviorAnnexRuleDiagnostics += BehaviorAnnexCharacterizationTest.countBehaviorAnnexRuleDiagnostics(issues);
			caseCount++;
		}

		assertTrue("The Behavior Annex corpus contributed no models, so this suite proved nothing", caseCount > 0);
		assertTrue("No Behavior Annex rule diagnostic was reported anywhere in the corpus, so the BA validator was "
				+ "not registered and every acceptance expectation in this bundle would be vacuous",
				behaviorAnnexRuleDiagnostics > 0);
	}
}
