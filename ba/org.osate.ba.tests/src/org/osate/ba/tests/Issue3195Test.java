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
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.ThreadImplementation;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * A bare {@code on dispatch} has neither a trigger nor a frozen port list, so the {@code DispatchCondition} rule can
 * match on its keyword alone. Verifies that such a condition still becomes a dispatch condition object, whatever
 * whitespace or comment separates {@code on} from {@code dispatch}.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3195Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3195/";

	/** Transition names in declaration order, each a bare dispatch condition spelled with different hidden tokens. */
	private static final List<String> TRANSITIONS = List.of("single_space", "extra_space", "line_break",
			"with_comment");

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void bareDispatchConditionCreatesDeclarativeObject() throws Exception {
		var annex = annex(testHelper.parseFile(PATH + "Issue3195.aadl"));
		assertEquals(TRANSITIONS, annex.getTransitions().stream().map(transition -> transition.getName()).toList());
		for (var transition : annex.getTransitions()) {
			var condition = transition.getCondition();
			assertNotNull(transition.getName(), condition);
			assertNotNull(transition.getName(), condition.getDispatch());
		}
	}

	@Test
	public void bareDispatchConditionSurvivesTranslation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "Issue3195.aadl");
		var strict = BehaviorAnnexUtil.getStrictModel(defaultAnnex(pkg));
		assertEquals(TRANSITIONS, strict.getTransitions().stream().map(transition -> transition.getName()).toList());
		for (var transition : strict.getTransitions()) {
			assertTrue(transition.getName() + " condition=" + transition.getCondition(),
					transition.getCondition() instanceof org.osate.ba.aadlba.DispatchCondition);
		}
	}

	/** D.3.(L7) demands a dispatch condition on transitions out of complete states; every transition here has one. */
	@Test
	public void bareDispatchConditionSatisfiesLegalityRules() throws Exception {
		var result = testHelper.testFile(PATH + "Issue3195.aadl");
		assertEquals(result.getSummary(), List.of(), result.getIssues().stream().map(Object::toString).toList());
	}

	private static BehaviorAnnex annex(AadlPackage pkg) {
		return (BehaviorAnnex) defaultAnnex(pkg).getParsedAnnexSubclause();
	}

	private static DefaultAnnexSubclause defaultAnnex(AadlPackage pkg) {
		var implementation = (ThreadImplementation) pkg.getOwnedPublicSection().getOwnedClassifiers().get(1);
		return (DefaultAnnexSubclause) implementation.getOwnedAnnexSubclauses().getFirst();
	}
}
