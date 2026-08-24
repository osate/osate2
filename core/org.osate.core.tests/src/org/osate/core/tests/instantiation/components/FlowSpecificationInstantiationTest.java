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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * Flow specification instances, which are created with the component hierarchy rather than by the end to
 * end flow phase: one per flow specification of the component type, with the flow ends resolved to
 * feature instances and the mode membership resolved to mode and mode transition instances.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class FlowSpecificationInstantiationTest extends AbstractComponentInstantiationTest {
	private static final String FILE = "FlowSpecs.aadl";

	/** One flow specification instance per declaration, in declaration order. */
	@Test
	public void oneInstancePerFlowSpecification() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var device = component(result.instance(), "d");

		assertEquals(List.of("src", "snk", "thru", "fg_thru"), flowSpecificationNames(device));
		assertEquals("src", flowSpecification(device, "src").getFlowSpecification().getName());
		assertEquals(List.of(), diagnostics(result));
	}

	/** A flow source has only a destination, a flow sink only a source, a flow path both. */
	@Test
	public void flowEndsAreResolvedToFeatureInstances() throws Exception {
		var device = component(instantiate(FILE, "Top.i").instance(), "d");

		var source = flowSpecification(device, "src");
		assertNull(source.getSource());
		assertSame(feature(device, "out_p"), source.getDestination());

		var sink = flowSpecification(device, "snk");
		assertSame(feature(device, "in_p"), sink.getSource());
		assertNull(sink.getDestination());

		var path = flowSpecification(device, "thru");
		assertSame(feature(device, "in_p"), path.getSource());
		assertSame(feature(device, "out_p"), path.getDestination());
	}

	/** A flow end that names a feature group member is resolved inside that feature group instance. */
	@Test
	public void flowEndInsideAFeatureGroupIsResolved() throws Exception {
		var device = component(instantiate(FILE, "Top.i").instance(), "d");
		var path = flowSpecification(device, "fg_thru");

		assertEquals("Top_i_Instance.d.fg.a", path(path.getSource()));
		assertSame(feature(feature(device, "fg"), "a"), path.getSource());
	}

	/** Mode membership of a flow specification names mode instances, transition membership transitions. */
	@Test
	public void modeMembershipIsResolvedToInstances() throws Exception {
		var modal = component(instantiate(FILE, "Top.i").instance(), "m");

		var inMode = flowSpecification(modal, "modal_path");
		assertEquals(List.of("Top_i_Instance.m.m1"), paths(inMode.getInModes()));
		assertTrue(inMode.getInModeTransitions().isEmpty());

		var inTransition = flowSpecification(modal, "transition_path");
		assertTrue(inTransition.getInModes().isEmpty());
		assertEquals(1, inTransition.getInModeTransitions().size());
		assertSame(transition(modal, "t12"), inTransition.getInModeTransitions().get(0));
		assertNotNull(inTransition.getSource());
	}
}
