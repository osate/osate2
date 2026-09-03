/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 */
package org.osate.ge.ba.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.ge.ba.BehaviorAnnexReferenceUtil;
import org.osate.ge.ba.util.BehaviorAnnexNamingUtil;
import org.osate.ge.ba.util.BehaviorAnnexUtil;
import org.osate.ge.ba.util.BehaviorTransitionEmbeddedTextUtil;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition;

import com.google.inject.Inject;

/**
 * Pins the Graphical Editor's BA-facing reference, naming, package lookup, and embedded-condition extraction helpers
 * before those helpers are migrated from the legacy strict/declarative models to the Xtext-generated model.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexGeInjectorProvider.class)
public class BehaviorAnnexGeCharacterizationTest {
	private static final String MODEL = "org.osate.ge.ba.tests/models/characterization/GeCharacterization.aadl";

	@Inject
	private TestHelper<Element> testHelper;

	@Test
	public void characterizeGeFacingHelpers() {
		final AadlPackage pkg = (AadlPackage) testHelper.parseFile(MODEL);
		final ComponentClassifier classifier = (ComponentClassifier) pkg.getPublicSection().getOwnedClassifiers().get(0);
		final DefaultAnnexSubclause defaultAnnex = (DefaultAnnexSubclause) classifier.getOwnedAnnexSubclauses().get(0);
		final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) defaultAnnex.getParsedAnnexSubclause();
		final BehaviorTransition transition = behaviorAnnex.getTransitions().get(0);

		assertEquals(Arrays.asList("ba.behavior_state", "source"),
				BehaviorAnnexReferenceUtil.getStateRelativeReference("source").getSegments());
		assertEquals(Arrays.asList("ba.behavior_transition", "named_transition"),
				BehaviorAnnexReferenceUtil.getTransitionRelativeReference("named_transition").getSegments());
		assertEquals(Arrays.asList("ba.behavior_variable", "value"),
				BehaviorAnnexReferenceUtil.getVariableRelativeReference("value").getSegments());

		assertEquals("source2", BehaviorAnnexNamingUtil.buildUniqueIdentifier(behaviorAnnex, "source"));
		final var variable = BehaviorAnnexUtil.getVariables(behaviorAnnex).findFirst().orElseThrow();
		assertTrue(BehaviorAnnexNamingUtil.checkNameValidity(variable, "new_value").isEmpty());
		assertFalse(BehaviorAnnexNamingUtil.checkNameValidity(variable, "destination")
				.isEmpty());
		assertFalse(BehaviorAnnexNamingUtil.checkNameValidity(variable, "existing_feature")
				.isEmpty());

		assertSame(pkg, BehaviorAnnexUtil.getPackage(variable).orElseThrow());

		final String source = ((XtextResource) pkg.eResource()).getParseResult().getRootNode().getText();
		assertEquals("on dispatch trigger", BehaviorTransitionEmbeddedTextUtil.getConditionText(transition, source));
	}
}
