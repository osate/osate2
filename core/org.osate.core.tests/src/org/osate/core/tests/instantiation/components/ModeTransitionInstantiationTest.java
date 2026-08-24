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
package org.osate.core.tests.instantiation.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * Mode transition instances: the name each one gets, the mode instances it runs between, and which of
 * its triggers end up on the instance. Only triggers that are ports become trigger references, but the
 * generated name is built from the first trigger whether it is a port or not.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ModeTransitionInstantiationTest extends AbstractComponentInstantiationTest {
	private static final String FILE = "ModeTransitions.aadl";

	/**
	 * A declared name is kept. An unnamed transition is named source, trigger, destination, with the
	 * subcomponent prefixed to the trigger when the trigger is reached through one.
	 */
	@Test
	public void transitionNamesAreDeclaredOrGenerated() throws Exception {
		var result = instantiate(FILE, "Top.i");

		assertEquals(List.of("named", "m2_top_trigger_m3", "m3_fg_trigger_m1", "m3_s_trigger_m2", "m1_ie_m3"),
				transitionNames(result.instance()));
		assertEquals(List.of(), diagnostics(result));
	}

	/** A transition instance runs between the mode instances of its declared source and destination. */
	@Test
	public void transitionRunsBetweenModeInstances() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();
		var transition = transition(root, "named");

		assertSame(mode(root, "m1"), transition.getSource());
		assertSame(mode(root, "m2"), transition.getDestination());
		assertNotNull(transition.getModeTransition());
	}

	/** A trigger in a subcomponent becomes a reference to that subcomponent's feature instance. */
	@Test
	public void triggerInASubcomponentIsResolvedToItsFeatureInstance() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();

		assertEquals(List.of("Top_i_Instance.s.trigger"), paths(transition(root, "named").getTriggers()));
	}

	/** A trigger on the component itself and one inside a feature group are resolved the same way. */
	@Test
	public void triggerOnTheComponentAndInsideAFeatureGroupAreResolved() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();

		assertEquals(List.of("Top_i_Instance.top_trigger"),
				paths(transition(root, "m2_top_trigger_m3").getTriggers()));
		assertEquals(List.of("Top_i_Instance.fg.fg_trigger"),
				paths(transition(root, "m3_fg_trigger_m1").getTriggers()));
	}

	/** All triggers of a transition are kept, in declaration order, and the name uses the first one. */
	@Test
	public void allTriggersAreKeptInDeclarationOrder() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();

		assertEquals(List.of("Top_i_Instance.s.trigger", "Top_i_Instance.top_trigger"),
				paths(transition(root, "m3_s_trigger_m2").getTriggers()));
	}

	/**
	 * A trigger that is not a port - here an internal event - contributes to the generated name but not
	 * to the triggers of the instance.
	 */
	@Test
	public void triggerThatIsNotAPortIsNamedButNotReferenced() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();
		var transition = transition(root, "m1_ie_m3");

		assertTrue(transition.getTriggers().isEmpty());
		assertSame(mode(root, "m1"), transition.getSource());
		assertSame(mode(root, "m3"), transition.getDestination());
	}
}
