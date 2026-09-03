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
package org.osate.xtext.aadl2.ba.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.SystemImplementation;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.services.BehaviorAnnexReferenceProposalService;
import org.osate.xtext.aadl2.ba.ui.outline.BehaviorAnnexOutlineTreeProvider;
import org.osate.xtext.aadl2.ba.ui.quickfix.BehaviorAnnexQuickfixProvider;

import com.google.inject.Inject;

/**
 * Exercises Phase 8 editor services over an embedded annex. The assertions pin reference completion candidates,
 * outline contents, and only the deterministic syntax corrections approved for Behavior Annex quick fixes.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexEmbeddedInjectorProvider.class)
public class BehaviorAnnexEditorServicesTest {
	private static final String MODEL = "org.osate.xtext.aadl2.ba.tests/models/phase4/Phase8.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private BehaviorAnnexReferenceProposalService proposals;

	@Test
	public void referenceProposalsIncludeBehaviorAndClassifierMembers() throws Exception {
		var annex = loadAnnex();
		assertEquals(List.of("counter", "input", "output", "self", "storage"), proposals.getRootProposals(annex));
	}

	@Test
	public void outlineContainsOnlyNamedTopLevelBehaviorElements() throws Exception {
		var annex = loadAnnex();
		assertEquals(List.of("counter", "idle", "running", "start"),
				BehaviorAnnexOutlineTreeProvider.getTopLevelElements(annex)
						.stream()
						.map(BehaviorAnnexOutlineTreeProvider::getElementName)
						.toList());
	}

	@Test
	public void quickFixesAreLimitedToUnambiguousSyntaxCorrections() {
		assertEquals("elsif", BehaviorAnnexQuickfixProvider.getSyntaxCorrection("elif").orElseThrow());
		assertEquals("end if", BehaviorAnnexQuickfixProvider.getSyntaxCorrection("endif").orElseThrow());
		assertEquals("=", BehaviorAnnexQuickfixProvider.getSyntaxCorrection("==").orElseThrow());
		assertEquals(false, BehaviorAnnexQuickfixProvider.getSyntaxCorrection("missing_name").isPresent());
	}

	private BehaviorAnnex loadAnnex() throws Exception {
		var result = testHelper.testFile(MODEL);
		var aadlPackage = (AadlPackage) result.getResource().getContents().get(0);
		var implementation = (SystemImplementation) aadlPackage.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(SystemImplementation.class::isInstance)
				.findFirst()
				.orElseThrow();
		var defaultAnnex = (DefaultAnnexSubclause) implementation.getOwnedAnnexSubclauses().get(0);
		return (BehaviorAnnex) defaultAnnex.getParsedAnnexSubclause();
	}
}
