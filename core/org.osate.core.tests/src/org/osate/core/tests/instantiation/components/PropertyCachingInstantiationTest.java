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
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * Property caching runs over the finished hierarchy, so a value declared on a classifier lands on every
 * instance of it, and a contained property association lands on the one instance it applies to. This
 * pins the pipeline order rather than the caching itself, which the caching switches own.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class PropertyCachingInstantiationTest extends AbstractComponentInstantiationTest {
	private static final String FILE = "PropertyCaching.aadl";

	/** The value from the classifier is cached on the instance that has no association of its own. */
	@Test
	public void valueFromTheClassifierIsCachedOnTheInstance() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var thread = component(component(result.instance(), "p"), "t");

		assertEquals(10, period(thread));
		assertEquals(List.of(), diagnostics(result));
	}

	/** A contained property association overrides the classifier value on the instance it applies to. */
	@Test
	public void containedAssociationIsCachedOnTheInstanceItAppliesTo() throws Exception {
		var process = component(instantiate(FILE, "Top.i").instance(), "p");

		assertEquals(20, period(component(process, "u")));
		assertEquals(10, period(component(process, "t")));
	}

	/** Nothing is cached where the property does not apply. */
	@Test
	public void noAssociationWhereThePropertyDoesNotApply() throws Exception {
		var result = instantiate(FILE, "Top.i");

		assertTrue(result.instance().getOwnedPropertyAssociations().isEmpty());
		assertTrue(component(result.instance(), "p").getOwnedPropertyAssociations().isEmpty());
	}

	private static long period(ComponentInstance component) {
		var associations = component.getOwnedPropertyAssociations()
				.stream()
				.filter(association -> association.getProperty().getName().equals("Period"))
				.toList();
		assertEquals(path(component), 1, associations.size());
		var value = associations.get(0).getOwnedValues().get(0).getOwnedValue();
		return (long) ((IntegerLiteral) value).getValue();
	}
}
