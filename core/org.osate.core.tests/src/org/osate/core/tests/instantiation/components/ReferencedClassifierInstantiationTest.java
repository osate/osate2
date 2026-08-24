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
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * A feature that has a component classifier gets a component instance for that classifier. Those
 * instances are roots of their own next to the system instance in the instance resource, not part of the
 * system instance tree, and one root serves every feature that names the same classifier.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ReferencedClassifierInstantiationTest extends AbstractComponentInstantiationTest {
	private static final String FILE = "ReferencedClassifiers.aadl";

	/** The classifier roots sit in the resource, in the order they were discovered, after the root. */
	@Test
	public void referencedClassifiersBecomeRootsInTheResource() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var contents = result.instance().eResource().getContents();

		assertSame(result.instance(), contents.get(0));
		assertEquals(3, contents.size());
		assertEquals(List.of("ReferencedClassifiers::D.i", "ReferencedClassifiers::D"),
				contents.subList(1, 3).stream().map(content -> ((ComponentInstance) content).getName()).toList());
		assertTrue(contents.subList(1, 3).stream().noneMatch(SystemInstance.class::isInstance));
		assertEquals(List.of(), diagnostics(result));
	}

	/** Every feature that names the same classifier points at the same root. */
	@Test
	public void featuresWithTheSameClassifierShareOneRoot() throws Exception {
		var thread = component(component(instantiate(FILE, "Top.i").instance(), "p"), "t");

		var shared = feature(thread, "p1").getType();
		assertEquals("ReferencedClassifiers::D.i", shared.getName());
		assertSame(shared, feature(thread, "p2").getType());
		assertSame(shared, feature(thread, "shared").getType());
	}

	/** A different classifier gets a root of its own. */
	@Test
	public void differentClassifierGetsItsOwnRoot() throws Exception {
		var thread = component(component(instantiate(FILE, "Top.i").instance(), "p"), "t");

		var type = feature(thread, "p3").getType();
		assertEquals("ReferencedClassifiers::D", type.getName());
		assertEquals(ComponentCategory.DATA, type.getCategory());
		assertTrue(type.getComponentInstances().isEmpty());
	}

	/** A feature without a classifier has no type instance. */
	@Test
	public void featureWithoutClassifierHasNoTypeInstance() throws Exception {
		var thread = component(component(instantiate(FILE, "Top.i").instance(), "p"), "t");

		assertNull(feature(thread, "event_no_classifier").getType());
	}

	/** A classifier root goes through the same hierarchy instantiation as the system instance. */
	@Test
	public void classifierRootIsInstantiatedLikeAnyOtherRoot() throws Exception {
		var thread = component(component(instantiate(FILE, "Top.i").instance(), "p"), "t");
		var implementationRoot = feature(thread, "p1").getType();

		assertEquals(ComponentCategory.DATA, implementationRoot.getCategory());
		assertEquals(List.of("field"), componentNames(implementationRoot));
		assertEquals("ReferencedClassifiers::D.i.field", path(component(implementationRoot, "field")));
	}
}
