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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * Mode instances, the modes a subcomponent instance is active in, and how a required mode is mapped to a
 * mode of the containing component - explicitly through a mode binding, or implicitly by name.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ModeInstantiationTest extends AbstractComponentInstantiationTest {
	private static final String FILE = "ModeInstantiation.aadl";

	/** Modes are instantiated in declaration order, and only the declared initial mode is initial. */
	@Test
	public void modesAreInstantiatedInDeclarationOrder() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();

		assertEquals(List.of("m1", "m2"), modeNames(root));
		assertTrue(mode(root, "m1").isInitial());
		assertFalse(mode(root, "m2").isInitial());
		assertFalse(mode(root, "m1").isDerived());
		assertTrue(mode(root, "m1").getParents().isEmpty());
		assertSame(root.getModeInstances().get(0).getMode(), mode(root, "m1").getMode());
	}

	/** A subcomponent is active in the modes its declaration names, and in all of them otherwise. */
	@Test
	public void subcomponentActiveModesComeFromItsDeclaration() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();

		assertTrue(component(root, "always").getInModes().isEmpty());
		assertEquals(List.of("Top_i_Instance.m1"), paths(component(root, "only_m1").getInModes()));
	}

	/** A subcomponent with its own modes gets its own mode instances, unrelated to its parent's. */
	@Test
	public void subcomponentWithOwnModesKeepsThemSeparate() throws Exception {
		var own = component(instantiate(FILE, "Top.i").instance(), "own");

		assertEquals(List.of("o1", "o2"), modeNames(own));
		assertTrue(mode(own, "o1").isInitial());
		assertFalse(mode(own, "o1").isDerived());
		assertTrue(mode(own, "o1").getParents().isEmpty());
	}

	/** An explicit mode binding makes each required mode derived from the parent mode it is mapped to. */
	@Test
	public void explicitModeBindingLinksRequiredModesToParentModes() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();
		var explicit = component(root, "derived_explicit");

		assertEquals(List.of("d1", "d2"), modeNames(explicit));
		assertTrue(mode(explicit, "d1").isDerived());
		assertFalse(mode(explicit, "d1").isInitial());
		assertEquals(List.of("Top_i_Instance.m1"), paths(mode(explicit, "d1").getParents()));
		assertEquals(List.of("Top_i_Instance.m2"), paths(mode(explicit, "d2").getParents()));
		assertEquals(List.of("Top_i_Instance.m1", "Top_i_Instance.m2"), paths(explicit.getInModes()));
	}

	/** Without a mode binding, required modes are mapped to the parent modes of the same name. */
	@Test
	public void implicitModeMapMatchesRequiredModesByName() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();
		var implicit = component(root, "derived_implicit");

		assertEquals(List.of("m1", "m2"), modeNames(implicit));
		assertTrue(mode(implicit, "m1").isDerived());
		assertEquals(List.of("Top_i_Instance.m1"), paths(mode(implicit, "m1").getParents()));
		assertEquals(List.of("Top_i_Instance.m2"), paths(mode(implicit, "m2").getParents()));
		assertTrue(implicit.getInModes().isEmpty());
	}

	/**
	 * Required modes of the root are treated as ordinary modes, because there is no containing component
	 * that could provide a parent mode.
	 */
	@Test
	public void requiredModesOfTheRootAreNotDerived() throws Exception {
		var result = instantiate(FILE, "Derived.i");
		var root = result.instance();

		assertEquals(List.of("d1", "d2"), modeNames(root));
		assertFalse(mode(root, "d1").isDerived());
		assertTrue(mode(root, "d1").getParents().isEmpty());
		assertEquals(List.of("som_1", "som_2"), somNames(root));
		assertEquals(List.of(), diagnostics(result));
	}

	/**
	 * A required mode with no counterpart in the containing component is reported. The mode instance is
	 * still created, and stays derived with no parent, which keeps it out of every system operation mode.
	 */
	@Test
	public void requiredModeWithoutAParentModeIsReported() throws Exception {
		var result = instantiate("MissingParentMode.aadl", "Top.i");
		var child = component(result.instance(), "child");

		assertEquals(List.of("nomatch"), modeNames(child));
		assertTrue(mode(child, "nomatch").isDerived());
		assertTrue(mode(child, "nomatch").getParents().isEmpty());
		assertEquals(List.of("Error Top_i_Instance.child.nomatch: "
				+ "Required mode 'nomatch' not found in containing component"), diagnostics(result));
		assertEquals(List.of(List.of("Top_i_Instance.m1"), List.of("Top_i_Instance.m2")), somModes(result.instance()));
	}
}
