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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * What instantiation makes of subcomponent arrays: how many instances, in what order, and how each one
 * is indexed. The element instances all carry the name of the subcomponent, so the index list is the
 * only thing that tells them apart.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class SubcomponentArrayInstantiationTest extends AbstractComponentInstantiationTest {
	private static final String FILE = "Arrays.aadl";
	private static final String CONSTANTS = "ArrayConstants.aadl";

	/** One instance per element, indexed from one, all under the name of the subcomponent. */
	@Test
	public void oneDimensionalArrayIsIndexedFromOne() throws Exception {
		var result = instantiate(FILE, "Top.i", CONSTANTS);
		var elements = components(result.instance(), "one");

		assertEquals(3, elements.size());
		assertEquals(List.of(List.of(1L), List.of(2L), List.of(3L)), elements.stream()
				.map(ComponentInstance::getIndices)
				.map(List::copyOf)
				.toList());
		assertEquals(List.of("Top_i_Instance.one[1]", "Top_i_Instance.one[2]", "Top_i_Instance.one[3]"),
				paths(elements));
		assertSame(elements.get(0).getSubcomponent(), elements.get(2).getSubcomponent());
	}

	/** A two dimensional array is enumerated with the last dimension changing fastest. */
	@Test
	public void twoDimensionalArrayIsEnumeratedLastDimensionFirst() throws Exception {
		var result = instantiate(FILE, "Top.i", CONSTANTS);
		var elements = components(result.instance(), "grid");

		assertEquals(6, elements.size());
		assertEquals(List.of(List.of(1L, 1L), List.of(1L, 2L), List.of(1L, 3L), List.of(2L, 1L), List.of(2L, 2L),
				List.of(2L, 3L)),
				elements.stream().map(ComponentInstance::getIndices).map(List::copyOf).toList());
		assertEquals("Top_i_Instance.grid[2][3]", path(elements.get(5)));
	}

	/** An array with no elements produces no component instances and no diagnostic. */
	@Test
	public void emptyArrayProducesNothing() throws Exception {
		var result = instantiate(FILE, "Top.i", CONSTANTS);

		assertTrue(components(result.instance(), "empty").isEmpty());
		assertEquals(List.of(), diagnostics(result));
	}

	/** The element count can come from a property constant instead of a literal. */
	@Test
	public void arraySizeCanComeFromAPropertyConstant() throws Exception {
		var result = instantiate(FILE, "Top.i", CONSTANTS);
		var elements = components(result.instance(), "sized");

		assertEquals(2, elements.size());
		assertEquals(List.of("Top_i_Instance.sized[1]", "Top_i_Instance.sized[2]"), paths(elements));
	}

	/** Indexing starts over inside each element of an enclosing array. */
	@Test
	public void arrayInsideAnArrayElementIsIndexedIndependently() throws Exception {
		var result = instantiate(FILE, "Top.i", CONSTANTS);
		var outer = components(result.instance(), "nested");

		assertEquals(2, outer.size());
		assertEquals(List.of("Top_i_Instance.nested[1].inner[1]", "Top_i_Instance.nested[1].inner[2]"),
				paths(components(outer.get(0), "inner")));
		assertEquals(List.of("Top_i_Instance.nested[2].inner[1]", "Top_i_Instance.nested[2].inner[2]"),
				paths(components(outer.get(1), "inner")));
	}

	/** All the array elements of one declaration are siblings under the containing instance. */
	@Test
	public void allElementsAreSiblingsInOneList() throws Exception {
		var result = instantiate(FILE, "Top.i", CONSTANTS);

		assertEquals(13, result.instance().getComponentInstances().size());
		assertEquals(List.of("one", "one", "one", "grid", "grid", "grid", "grid", "grid", "grid", "sized", "sized",
				"nested", "nested"), componentNames(result.instance()));
	}
}
