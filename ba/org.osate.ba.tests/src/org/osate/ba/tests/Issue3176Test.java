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
import static org.junit.Assert.assertSame;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator.TranslationResult;

import com.google.inject.Inject;

/**
 * AS5506/3 Rev A D.3 declares a behavior variable with an array size per dimension, written as an integer literal or as
 * a property reference. Verifies that translation to the strict Behavior Annex model keeps every declared extent,
 * keeps a property constant as the size property of the dimension, and traces each dimension and size to the
 * declaration it came from.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3176Test {
	private static final String MODELS = "org.osate.ba.tests/models/issue3176/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void declaredArrayExtentsSurviveTranslation() throws Exception {
		assertEquals(List.of("samples[10]", "window[16]", "history[100]", "grid[3][4]", "left[2]", "right[3]", "total",
				"buffer[Max_Queue_Size]"),
				strictAnnex().getVariables().stream().map(Issue3176Test::describe).toList());
	}

	/**
	 * A dimension sized by a property constant carries the constant itself, so its extent is the constant's value.
	 */
	@Test
	public void aPropertyConstantSizeStillYieldsItsElementCount() throws Exception {
		var buffer = strictAnnex().getVariables().get(7);
		assertEquals("buffer", buffer.getName());
		assertEquals(512L, AadlUtil.getElementCount(buffer.getArrayDimensions().get(0).getSize()));
	}

	@Test
	public void everyDimensionAndSizeTracesToItsDeclaration() throws Exception {
		var annex = annex();
		var translation = translate(annex);
		var dimensionCount = 0;
		for (var group : sourceAnnex(annex).getVariableGroups()) {
			for (var variable : group.getVariables()) {
				var strict = (BehaviorVariable) translation.getStrict(variable);
				assertEquals("Translated dimension count of '" + variable.getName() + "'",
						variable.getArrayDimensions().size(), strict.getArrayDimensions().size());
				for (var index = 0; index < variable.getArrayDimensions().size(); index++) {
					var declared = variable.getArrayDimensions().get(index);
					var translated = strict.getArrayDimensions().get(index);
					assertSame("Declarative source of dimension " + index + " of '" + variable.getName() + "'",
							declared, translation.getDeclarative(translated));
					assertSame("Declarative source of the size of dimension " + index + " of '" + variable.getName()
							+ "'", declared.getSize(), translation.getDeclarative(translated.getSize()));
					dimensionCount++;
				}
			}
		}
		assertEquals("Traced dimensions", 8, dimensionCount);
	}

	private org.osate.ba.aadlba.BehaviorAnnex strictAnnex() throws Exception {
		return translate(annex()).getStrictAnnex();
	}

	private static org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex sourceAnnex(
			final DefaultAnnexSubclause annex) {
		return (org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex) annex.getParsedAnnexSubclause();
	}

	private static TranslationResult translate(final DefaultAnnexSubclause annex) {
		return new DeclarativeToStrictTranslator().translate(sourceAnnex(annex),
				(ComponentClassifier) annex.getContainingClassifier());
	}

	private DefaultAnnexSubclause annex() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3176.aadl");
		validationHelper.assertNoIssues(root);
		return AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
	}

	/** Describes a variable by its name and the extent of each of its dimensions. */
	private static String describe(final BehaviorVariable variable) {
		var result = new StringBuilder(variable.getName());
		for (var dimension : variable.getArrayDimensions()) {
			var size = dimension.getSize();
			result.append('[');
			if (size == null) {
				result.append("<null>");
			} else if (size.getSizeProperty() instanceof NamedElement property) {
				result.append(property.getName());
			} else {
				result.append(size.getSize());
			}
			result.append(']');
		}
		return result.toString();
	}
}
