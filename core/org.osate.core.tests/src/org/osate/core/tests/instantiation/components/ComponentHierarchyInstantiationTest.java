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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.ComponentCategory;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * What instantiation makes of the component hierarchy: the root, the shape of the tree below it, the
 * order the subcomponent instances appear in, and the two subcomponents that carry less than a full
 * classifier.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ComponentHierarchyInstantiationTest extends AbstractComponentInstantiationTest {
	private static final String FILE = "Hierarchy.aadl";

	/**
	 * The root is named after the type and implementation name of what was instantiated, carries both
	 * the implementation and the classifier, and is the first object in the instance resource.
	 */
	@Test
	public void rootIsNamedAfterTheImplementation() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var root = result.instance();

		assertEquals("Top_i_Instance", root.getName());
		assertEquals("Top_i_Instance", path(root));
		assertEquals(ComponentCategory.SYSTEM, root.getCategory());
		assertSame(result.implementation(), root.getComponentImplementation());
		assertSame(result.implementation(), root.getClassifier());
		assertTrue(root.getIndices().isEmpty());
		assertNull(root.eContainer());
		assertSame(root, root.eResource().getContents().get(0));
	}

	/**
	 * Subcomponent instances are grouped by the kind of subcomponent they come from, not created in
	 * declaration order. {@code Top.i} declares p, b, untyped, typeonly.
	 */
	@Test
	public void subcomponentInstancesAreGroupedByKind() throws Exception {
		var result = instantiate(FILE, "Top.i");

		assertEquals(List.of("b", "p", "untyped", "typeonly"), componentNames(result.instance()));
	}

	/**
	 * Every level of the declarative hierarchy becomes a level of component instances, once per
	 * subcomponent, and a subcomponent that is not an array is indexed with a single zero.
	 */
	@Test
	public void hierarchyIsInstantiatedOncePerSubcomponent() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var root = result.instance();

		var process = component(root, "p");
		assertEquals(List.of("t1", "t2"), componentNames(process));
		assertSame(root, process.getContainingComponentInstance());
		assertEquals(List.of(0L), process.getIndices());

		var thread = component(process, "t1");
		assertEquals(ComponentCategory.THREAD, thread.getCategory());
		assertEquals("Top_i_Instance.p.t1", path(thread));

		var data = component(thread, "d");
		assertEquals(ComponentCategory.DATA, data.getCategory());
		assertEquals("Top_i_Instance.p.t1.d", path(data));
		assertTrue(data.getComponentInstances().isEmpty());
	}

	/**
	 * A subcomponent instance refers back to the subcomponent it was created from, which is what tells
	 * the two instances of the same classifier apart.
	 */
	@Test
	public void subcomponentInstanceRefersToItsDeclaration() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var process = component(result.instance(), "p");

		var t1 = component(process, "t1");
		var t2 = component(process, "t2");
		assertEquals("t1", t1.getSubcomponent().getName());
		assertEquals("t2", t2.getSubcomponent().getName());
		assertSame(t1.getClassifier(), t2.getClassifier());
	}

	/**
	 * A subcomponent without a classifier is reported as a warning, keeps the category it was declared
	 * with, and gets no classifier and no contents.
	 */
	@Test
	public void subcomponentWithoutClassifierIsReported() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var untyped = component(result.instance(), "untyped");

		assertEquals(ComponentCategory.SYSTEM, untyped.getCategory());
		assertNull(untyped.getClassifier());
		assertTrue(untyped.getComponentInstances().isEmpty());
		assertTrue(untyped.getFeatureInstances().isEmpty());
		assertEquals(List.of("Warning Top_i_Instance.untyped: "
				+ "Instantiated subcomponent doesn't have a component classifier"), diagnostics(result));
	}

	/**
	 * A subcomponent whose classifier is a component type gets that type's features but nothing below
	 * it, because there is no implementation to take subcomponents from.
	 */
	@Test
	public void subcomponentWithComponentTypeOnlyGetsFeaturesOnly() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var typeOnly = component(result.instance(), "typeonly");

		assertEquals("Hierarchy::WithFeatures", typeOnly.getClassifier().getQualifiedName());
		assertEquals(List.of("p"), featureNames(typeOnly));
		assertTrue(typeOnly.getComponentInstances().isEmpty());
	}

	/**
	 * The root does not have to be a system. Instantiating a process implementation produces a system
	 * instance object whose category is the category of that implementation.
	 */
	@Test
	public void rootCanBeANonSystemImplementation() throws Exception {
		var result = instantiate(FILE, "Proc.i");
		var root = result.instance();

		assertEquals("Proc_i_Instance", root.getName());
		assertEquals(ComponentCategory.PROCESS, root.getCategory());
		assertEquals(List.of("t1", "t2"), componentNames(root));
		assertEquals(List.of(), diagnostics(result));
	}
}
