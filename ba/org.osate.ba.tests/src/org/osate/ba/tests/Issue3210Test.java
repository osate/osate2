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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyAssociation;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorArraySize;
import org.osate.ba.aadlba.BehaviorIntegerLiteral;
import org.osate.ba.aadlba.BehaviorPropertyConstant;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ba.aadlba.ClassifierFeaturePropertyReference;
import org.osate.ba.aadlba.PropertyReference;
import org.osate.ba.aadlba.PropertySetPropertyReference;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;

/**
 * AS5506/3 Rev A D.3 writes a behavior variable array size as an integer value constant, which D.7 spells as an integer
 * literal or a property reference. Verifies that translation keeps the integer value that was written, that a property
 * reference keeps its own form instead of the value the declarative model happens to supply for it, and that validation
 * accepts a property reference without asking whether that model can supply a value at all.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3210Test {
	private static final String MODELS = "org.osate.ba.tests/models/issue3210/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * A literal and an unindexed property constant are the two array sizes core AADL can express, so those extents also
	 * reach the inherited {@code aadl2::ArraySize} that consumers of a core array dimension read.
	 */
	@Test
	public void aLiteralAndAPropertyConstantAlsoKeepTheCoreExtent() throws Exception {
		var variables = strictAnnex("Issue3210.aadl").getVariables();

		var literal = arraySize(variables.get(0));
		assertEquals("byLiteral", variables.get(0).getName());
		assertEquals(8L, literal.getSize());
		assertTrue(describe(literal), literal.getIntegerValue() instanceof BehaviorIntegerLiteral);
		assertEquals(8L, ((BehaviorIntegerLiteral) literal.getIntegerValue()).getValue());

		var constant = arraySize(variables.get(1));
		assertEquals("byConstant", variables.get(1).getName());
		assertEquals("Max_Queue_Size", ((NamedElement) constant.getSizeProperty()).getName());
		assertTrue(describe(constant), constant.getIntegerValue() instanceof BehaviorPropertyConstant);
		assertEquals("Max_Queue_Size",
				((BehaviorPropertyConstant) constant.getIntegerValue()).getProperty().getName());
	}

	/**
	 * The prefixed feature declares {@code Queue_Size => 8}, so a translation that read the property would have frozen
	 * that 8 into the dimension.
	 */
	@Test
	public void aPrefixedPropertyReferenceKeepsItsOwnForm() throws Exception {
		var variable = strictAnnex("Issue3210.aadl").getVariables().get(2);
		assertEquals("byPrefixed", variable.getName());
		var size = arraySize(variable);
		var value = size.getIntegerValue();
		assertTrue(describe(size), value instanceof ClassifierFeaturePropertyReference);
		var reference = (ClassifierFeaturePropertyReference) value;
		assertEquals("input", reference.getComponent().getElement().getName());
		assertEquals(List.of("Queue_Size"), propertyNames(reference));
		assertNotEvaluated(size);
	}

	/**
	 * A property definition with no element prefix denotes no single value, and no rule of D.3 says otherwise, so the
	 * reference is kept and the declaration is accepted.
	 */
	@Test
	public void aBarePropertyDefinitionIsAcceptedAndKept() throws Exception {
		var variable = strictAnnex("BareProperty.aadl").getVariables().getFirst();
		assertEquals("byProperty", variable.getName());
		var size = arraySize(variable);
		var value = size.getIntegerValue();
		assertTrue(describe(size), value instanceof PropertySetPropertyReference);
		assertEquals("Communication_Properties",
				((PropertySetPropertyReference) value).getPropertySet().getName());
		assertNotEvaluated(size);
	}

	/**
	 * The extent of this dimension comes from a contained property association two path elements away, which belongs to
	 * the instance model. Reading the declarative model would have missed it and frozen the property default instead.
	 */
	@Test
	public void aContainedPropertyAssociationIsNotReadFromTheDeclarativeModel() throws Exception {
		var variable = strictAnnex("ContainedProperty.aadl").getVariables().getFirst();
		assertEquals("sized", variable.getName());
		var size = arraySize(variable);
		var value = size.getIntegerValue();
		assertTrue(describe(size), value instanceof ClassifierFeaturePropertyReference);
		assertEquals(List.of("Queue_Size"), propertyNames((PropertyReference) value));
		assertNotEvaluated(size);
	}

	/** Asserts that no value was read for the size, leaving the core extent unset. */
	private static void assertNotEvaluated(final BehaviorArraySize size) {
		assertEquals("Extent read from the declarative model", 0L, size.getSize());
		assertNull("Size property", size.getSizeProperty());
	}

	private static BehaviorArraySize arraySize(final BehaviorVariable variable) {
		return (BehaviorArraySize) variable.getArrayDimensions().getFirst().getSize();
	}

	/** Names the properties a reference reads, taking the property of an association the reference resolved to. */
	private static List<String> propertyNames(final PropertyReference reference) {
		return reference.getProperties().stream().map(holder -> propertyName(holder.getProperty().getElement())).toList();
	}

	private static String propertyName(final Element element) {
		if (element instanceof PropertyAssociation association) {
			return association.getProperty().getName();
		}
		return element instanceof NamedElement named ? named.getName() : String.valueOf(element);
	}

	/** Describes a size by its parts, so a failing run reports the translated size instead of only a class cast. */
	private static String describe(final BehaviorArraySize size) {
		var value = size.getIntegerValue();
		return "size=" + size.getSize() + ", sizeProperty=" + size.getSizeProperty() + ", integerValue="
				+ (value == null ? "<null>" : value.eClass().getName());
	}

	private BehaviorAnnex strictAnnex(final String model) throws Exception {
		var root = testHelper.parseFile(MODELS + model);
		validationHelper.assertNoIssues(root);
		return BehaviorAnnexUtil.getStrictModel(AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst());
	}
}
