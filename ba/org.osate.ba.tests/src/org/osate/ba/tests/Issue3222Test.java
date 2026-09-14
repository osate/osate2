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

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.BasicPropertyHolder;
import org.osate.ba.aadlba.BehaviorArraySize;
import org.osate.ba.aadlba.ClassifierFeaturePropertyReference;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;

/**
 * A prefixed property reference denotes an effective value on an instance object. The strict model must preserve the
 * property definition so the same classifier's annex can be evaluated separately for instances with different values.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3222Test {
	private static final String MODEL = "org.osate.ba.tests/models/issue3222/Issue3222.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void prefixedPropertyReferenceKeepsThePropertyForInstanceLookup() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var annex = BehaviorAnnexUtil.getStrictModel(AnnexUtil.getAllDefaultAnnexSubclauses(pkg).getFirst());
		var size = (BehaviorArraySize) annex.getVariables().getFirst().getArrayDimensions().getFirst().getSize();
		var reference = (ClassifierFeaturePropertyReference) size.getIntegerValue();
		var holder = reference.getProperties().getFirst().getProperty();

		assertEquals("input", reference.getComponent().getElement().getName());
		assertTrue(holder.eClass().getName(), holder instanceof BasicPropertyHolder);
		assertTrue(String.valueOf(holder.getElement()), holder.getElement() instanceof Property);
		var property = (Property) holder.getElement();
		assertEquals("Communication_Properties::Queue_Size", property.getQualifiedName());

		var implementation = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("top.impl"))
				.findFirst()
				.orElseThrow();
		var instance = InstantiateModel.instantiate(implementation);

		assertEquals(8L, value(feature(component(instance, "unoverridden"), "input"), property));
		assertEquals(16L, value(feature(component(instance, "overridden"), "input"), property));
	}

	private static ComponentInstance component(final ComponentInstance container, final String name) {
		return container.getComponentInstances()
				.stream()
				.filter(component -> component.getName().equals(name))
				.findFirst()
				.orElseThrow();
	}

	private static NamedElement feature(final ComponentInstance component, final String name) {
		return component.getFeatureInstances()
				.stream()
				.filter(feature -> feature.getName().equals(name))
				.findFirst()
				.orElseThrow();
	}

	private static long value(final NamedElement element, final Property property) {
		var association = element.getPropertyValue(property).first();
		assertNotNull(element.getName(), association);
		var expression = association.getOwnedValues().getFirst().getOwnedValue();
		return (long) ((IntegerLiteral) expression).getValue();
	}
}
