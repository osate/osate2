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
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.DispatchCondition;
import org.osate.ba.aadlba.DispatchTriggerLogicalExpression;
import org.osate.ba.aadlba.SubprogramAccessHolder;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Verifies that direct subprogram dispatch triggers retain the frozen-port list that follows them. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3264Test extends XtextTest {
	private static final String MODEL = "org.osate.ba.tests/models/issue3264/Issue3264.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void subprogramAndEventDispatchTriggersPreserveFrozenPorts() throws Exception {
		var root = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(root);
		var annex = AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
		var source = (org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex) annex.getParsedAnnexSubclause();
		var translation = new DeclarativeToStrictTranslator().translate(source,
				(ComponentClassifier) annex.getContainingClassifier());
		var transitions = translation.getStrictAnnex().getTransitions();
		assertEquals(List.of("rpc_trigger", "port_trigger"),
				transitions.stream().map(transition -> transition.getName()).toList());
		assertTrue(((DispatchCondition) transitions.get(0).getCondition()).getDispatchTriggerCondition()
				instanceof SubprogramAccessHolder);
		assertTrue(((DispatchCondition) transitions.get(1).getCondition()).getDispatchTriggerCondition()
				instanceof DispatchTriggerLogicalExpression);

		for (var index = 0; index < transitions.size(); index++) {
			var declared = source.getTransitions().get(index).getCondition().getDispatch().getFrozenPorts();
			var translated = ((DispatchCondition) transitions.get(index).getCondition()).getFrozenPorts();
			assertEquals(List.of("incoming"), translated.stream().map(port -> port.getPort().getName()).toList());
			assertEquals(declared.size(), translated.size());
			for (var port = 0; port < declared.size(); port++) {
				assertSame(declared.get(port), translation.getDeclarative(translated.get(port)));
			}
		}
	}
}
