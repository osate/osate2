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
import static org.junit.Assert.assertNull;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.ComponentCategory;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * Where the category of a component instance comes from. A subcomponent declared abstract takes the
 * category of the classifier it ends up with, which for a prototype is only known once the prototype
 * is resolved; a subcomponent with no classifier keeps the category it was declared with.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ComponentCategoryInstantiationTest extends AbstractComponentInstantiationTest {
	private static final String FILE = "Categories.aadl";

	/** An abstract subcomponent bound to a bus classifier becomes a bus. */
	@Test
	public void categoryComesFromTheClassifierWhenThatIsNotAbstract() throws Exception {
		var result = instantiate(FILE, "Top.i");

		var bus = component(component(result.instance(), "bus_bound"), "s");
		assertEquals(ComponentCategory.BUS, bus.getCategory());
		assertEquals("Categories::B.i", bus.getClassifier().getQualifiedName());

		var process = component(component(result.instance(), "process_bound"), "s");
		assertEquals(ComponentCategory.PROCESS, process.getCategory());
		assertEquals("Categories::P.i", process.getClassifier().getQualifiedName());
	}

	/** Two abstract ends stay abstract. */
	@Test
	public void categoryStaysAbstractWhenBothEndsAreAbstract() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var abstractInstance = component(result.instance(), "plain_abstract");

		assertEquals(ComponentCategory.ABSTRACT, abstractInstance.getCategory());
		assertEquals("Categories::Abs.i", abstractInstance.getClassifier().getQualifiedName());
	}

	/**
	 * A subcomponent that never gets a classifier - declared without one, or typed with a prototype that
	 * is neither bound nor constrained - keeps the declared category and is reported.
	 */
	@Test
	public void subcomponentWithoutClassifierKeepsItsDeclaredCategory() throws Exception {
		var result = instantiate(FILE, "Top.i");

		var declaredWithout = component(result.instance(), "no_classifier");
		assertEquals(ComponentCategory.ABSTRACT, declaredWithout.getCategory());
		assertNull(declaredWithout.getClassifier());

		var unresolvedPrototype = component(component(result.instance(), "unbound"), "s");
		assertEquals(ComponentCategory.ABSTRACT, unresolvedPrototype.getCategory());
		assertNull(unresolvedPrototype.getClassifier());

		assertEquals(List.of(
				"Warning Top_i_Instance.no_classifier: Instantiated subcomponent doesn't have a component classifier",
				"Warning Top_i_Instance.unbound.s: Instantiated subcomponent doesn't have a component classifier"),
				diagnostics(result));
	}

	/** The same implementation instantiated twice with different bindings produces different categories. */
	@Test
	public void prototypeBindingIsResolvedPerSubcomponentInstance() throws Exception {
		var result = instantiate(FILE, "Top.i");

		assertEquals(List.of("plain_abstract", "no_classifier", "bus_bound", "process_bound", "unbound"),
				componentNames(result.instance()));
		assertEquals("Categories::Holder.i",
				component(result.instance(), "bus_bound").getClassifier().getQualifiedName());
		assertEquals("Categories::Holder.i",
				component(result.instance(), "process_bound").getClassifier().getQualifiedName());
	}
}
