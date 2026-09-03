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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.modelsupport.errorreporting.QueuingParseErrorReporter;
import org.osate.annexsupport.AnnexParser;
import org.osate.annexsupport.AnnexParserRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparser;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.BehaviorAnnexStandaloneSetup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction;

import com.google.inject.Inject;

/**
 * Exercises the temporary Behavior Annex name through the real embedded-AADL parser path. These tests ensure that
 * phase 4 contributes the parser, linker, and unparser together; resolves local BA names and referenced AADL objects;
 * records the deliberate Xtext linking message; and does not accidentally add an annex-library form.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexEmbeddedInjectorProvider.class)
public class BehaviorAnnexIntegrationTest {
	private static final String MODEL_DIRECTORY = "org.osate.xtext.aadl2.ba.tests/models/phase4/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void parsesLinksAndSerializesEmbeddedSubclause() throws Exception {
		var result = testHelper.testFile(MODEL_DIRECTORY + "Phase4.aadl",
				MODEL_DIRECTORY + "Phase4Properties.aadl");
		assertTrue(result.getSummary(), result.getIssues()
				.stream()
				.noneMatch(issue -> issue.getSeverity() == Severity.ERROR));

		var annex = getBehaviorAnnex((AadlPackage) result.getResource().getContents().get(0));
		var variableGroup = annex.getVariableGroups().get(0);
		assertEquals("Integer", variableGroup.getDataClassifier().getName());
		assertFalse(variableGroup.getDataClassifier().eIsProxy());
		assertEquals("Test_Property", variableGroup.getPropertyAssociations().get(0).getProperty().getName());

		var transition = annex.getTransitions().get(0);
		var states = annex.getStateGroups().stream().flatMap(group -> group.getStates().stream()).toList();
		assertSame(states.get(0), transition.getSourceStates().get(0));
		assertSame(states.get(1), transition.getDestinationState());
		var timedAction = (TimedAction) transition.getActionBlock().getContent();
		assertEquals("ms", timedAction.getLowerTime().getUnit().getName());
		assertEquals("Cpu", timedAction.getProcessors().get(0).getName());

		AnnexUnparser unparser = ((AnnexUnparserRegistry) AnnexRegistry
				.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID))
				.getAnnexUnparser(BehaviorAnnexStandaloneSetup.ANNEX_NAME);
		String serialized = unparser.unparseAnnexSubclause(annex, "");
		assertTrue(serialized, serialized.contains("start: idle -[]-> running"));

		AnnexParser parser = ((AnnexParserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_PARSER_EXT_ID))
				.getAnnexParser(BehaviorAnnexStandaloneSetup.ANNEX_NAME);
		var reporter = new QueuingParseErrorReporter();
		assertNotNull(serialized, parser.parseAnnexSubclause(BehaviorAnnexStandaloneSetup.ANNEX_NAME, serialized,
				"serialized.baxtext", 1, 1, reporter));
		assertEquals(0, reporter.getNumErrors());
		assertNull(parser.parseAnnexLibrary(BehaviorAnnexStandaloneSetup.ANNEX_NAME, serialized,
				"serialized.baxtext", 1, 1, reporter));
	}

	@Test
	public void reportsXtextUnresolvedStateMessage() throws Exception {
		var result = testHelper.testFile(MODEL_DIRECTORY + "UnresolvedState.aadl");
		assertEquals(List.of("ERROR: Couldn't resolve reference to BehaviorState 'missing'."), result.getIssues()
				.stream()
				.map(issue -> issue.getSeverity() + ": " + issue.getMessage())
				.toList());
	}

	private static BehaviorAnnex getBehaviorAnnex(AadlPackage aadlPackage) {
		var system = (SystemType) aadlPackage.getOwnedPublicSection().getOwnedClassifiers()
				.stream()
				.filter(SystemType.class::isInstance)
				.findFirst()
				.orElseThrow();
		var defaultAnnex = (DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().get(0);
		assertNotNull(defaultAnnex.getParsedAnnexSubclause());
		return (BehaviorAnnex) defaultAnnex.getParsedAnnexSubclause();
	}
}
