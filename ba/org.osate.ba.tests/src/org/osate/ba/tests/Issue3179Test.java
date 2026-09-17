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

import java.util.EnumSet;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Verifies that every component category permits alternative final states in standard behavior specifications. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3179Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void multipleFinalStatesAreAllowedInEveryComponentCategory() throws Exception {
		var root = testHelper.parseFile("org.osate.ba.tests/models/issue3179/Issue3179.aadl");
		validationHelper.assertNoIssues(root);

		var typeCategories = EnumSet.noneOf(ComponentCategory.class);
		var implementationCategories = EnumSet.noneOf(ComponentCategory.class);
		for (var classifier : root.getOwnedPublicSection().getOwnedClassifiers()) {
			var component = (ComponentClassifier) classifier;
			var categories = component instanceof ComponentType ? typeCategories : implementationCategories;
			categories.add(component.getCategory());
			var annex = (DefaultAnnexSubclause) component.getOwnedAnnexSubclauses().getFirst();
			var behavior = (BehaviorAnnex) annex.getParsedAnnexSubclause();
			assertEquals(component.getQualifiedName(), 2, behavior.getStateGroups().stream()
					.filter(BehaviorStateGroup::isFinal).mapToInt(group -> group.getStates().size()).sum());
		}
		assertEquals(EnumSet.allOf(ComponentCategory.class), typeCategories);
		assertEquals(EnumSet.allOf(ComponentCategory.class), implementationCategories);
	}
}
