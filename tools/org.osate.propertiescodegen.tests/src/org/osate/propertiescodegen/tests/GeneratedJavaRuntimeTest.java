/*******************************************************************************
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.propertiescodegen.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalLong;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.pluginsupport.properties.GeneratedEnumeration;
import org.osate.pluginsupport.properties.GeneratedRecord;
import org.osate.pluginsupport.properties.GeneratedUnits;
import org.osate.pluginsupport.properties.IntegerRange;
import org.osate.pluginsupport.properties.IntegerWithUnits;
import org.osate.propertiescodegen.tests.GeneratedJavaCompiler.CompiledJava;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

/** Executes freshly compiled generated classes against validated AADL property values. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class GeneratedJavaRuntimeTest {
	private static final String MODEL_PATH = "org.osate.propertiescodegen.tests/models/generatedjava/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	private AadlPackage model;
	private CompiledJava compiled;
	private Class<?> getters;

	@Before
	public void compileModel() throws Exception {
		model = testHelper.parseFile(MODEL_PATH + "RuntimeModel.aadl", MODEL_PATH + "ExternalTypes.aadl",
				MODEL_PATH + "RuntimeProperties.aadl");
		validationHelper.assertNoIssues(model);
		var properties = (PropertySet) model.getOwnedPublicSection().getImportedUnits().getFirst();
		validationHelper.assertNoIssues(properties);
		validationHelper.assertNoIssues(properties.getImportedUnits().getFirst());
		compiled = GeneratedJavaCompiler.compile(properties);
		getters = compiled.loadClass("generated.runtime.RuntimeProperties");
	}

	@After
	public void closeCompiledClasses() throws Exception {
		if (compiled != null) {
			compiled.close();
		}
	}

	@Test
	public void scalarGettersResolveValuesConstantsAndPropertyReferences() throws Exception {
		var context = classifier("Populated");
		assertEquals(Optional.of(true), get("Enabled", context));
		assertEquals(OptionalLong.of(41), get("Count", context));
		assertEquals(OptionalLong.of(41), get("CountAlias", context));
		assertEquals(OptionalDouble.of(1.5), get("Ratio", context));
		assertEquals(Optional.of("hello"), get("Label", context));
		assertEquals(41L, getters.getMethod("getAliasConstant", EObject.class).invoke(null, context));
		assertEquals(true, getters.getMethod("acceptsEnabled", NamedElement.class).invoke(null, context));
	}

	@Test
	public void absentAndInapplicablePropertiesReturnEmptyAndDefaultsAreApplied() throws Exception {
		var context = classifier("Empty");
		assertEquals(Optional.empty(), get("Enabled", context));
		assertEquals(OptionalLong.empty(), get("Count", context));
		assertEquals(OptionalDouble.empty(), get("Ratio", context));
		assertEquals(Optional.empty(), get("Settings", context));
		assertEquals(OptionalLong.of(7), get("DefaultCount", context));
		assertEquals(false, getters.getMethod("acceptsThreadOnly", NamedElement.class).invoke(null, context));
		assertEquals(Optional.empty(), get("ThreadOnly", context));
	}

	@Test
	public void modalGetterOverloadsSelectTheRequestedMode() throws Exception {
		var context = (ComponentImplementation) classifier("Populated.i");
		var low = context.getOwnedModes().getFirst();
		var high = context.getOwnedModes().getLast();
		var direct = getters.getMethod("getModeCount", NamedElement.class, Mode.class);
		var optional = getters.getMethod("getModeCount", NamedElement.class, Optional.class);
		assertEquals(OptionalLong.of(10), direct.invoke(null, context, low));
		assertEquals(OptionalLong.of(20), direct.invoke(null, context, high));
		assertEquals(OptionalLong.of(10), optional.invoke(null, context, Optional.of(low)));
		assertEquals(OptionalLong.of(20), optional.invoke(null, context, Optional.of(high)));
	}

	@Test
	public void nestedListsAreUnmodifiableAndRangesPreserveTheirValues() throws Exception {
		var context = classifier("Populated");
		var matrix = (List<?>) ((Optional<?>) get("Matrix", context)).orElseThrow();
		assertEquals(List.of(List.of(1L, 2L), List.of(), List.of(3L, 4L)), matrix);
		assertThrows(UnsupportedOperationException.class, matrix::clear);
		assertThrows(UnsupportedOperationException.class, ((List<?>) matrix.getFirst())::clear);
		assertThrows(UnsupportedOperationException.class, ((List<?>) matrix.get(1))::clear);
		var constant = (List<?>) getters.getMethod("getMatrixConstant", EObject.class).invoke(null, context);
		assertEquals(List.of(List.of(5L, 6L), List.of()), constant);
		assertThrows(UnsupportedOperationException.class, constant::clear);
		assertThrows(UnsupportedOperationException.class, ((List<?>) constant.getFirst())::clear);
		var range = (IntegerRange) ((Optional<?>) get("Bounds", context)).orElseThrow();
		assertEquals(1L, range.getMinimum());
		assertEquals(9L, range.getMaximum());
		assertEquals(OptionalLong.of(2), range.getDelta());
	}

	@Test
	public void importedEnumsAndUnitsResolveAndRoundTrip() throws Exception {
		var context = classifier("Populated");
		var resourceSet = model.eResource().getResourceSet();
		var choice = (GeneratedEnumeration) ((Optional<?>) get("Selection", context)).orElseThrow();
		assertEquals("green", choice.toString());
		assertEquals("GREEN", ((Enum<?>) choice).name());
		var choiceClass = compiled.loadClass("generated.runtime.types.Choice");
		assertSame(choice, choiceClass.getMethod("valueOf", PropertyExpression.class)
				.invoke(null, choice.toPropertyExpression(resourceSet)));
		var duration = (IntegerWithUnits<?>) ((Optional<?>) get("Duration", context)).orElseThrow();
		assertEquals(2L, duration.getValue());
		var unitsClass = compiled.loadClass("generated.runtime.types.TimeUnits");
		var milliseconds = unitsClass.getField("MS").get(null);
		var seconds = (GeneratedUnits<?>) duration.getUnit();
		assertEquals(1000.0, seconds.getFactorToBase(), 0.0);
		assertEquals(1000.0, (double) unitsClass.getMethod("getFactorTo", unitsClass).invoke(seconds, milliseconds),
				0.0);
		assertSame(seconds, unitsClass.getMethod("valueOf", PropertyExpression.class)
				.invoke(null, seconds.toPropertyExpression(resourceSet)));
		var expression = duration.toPropertyExpression(resourceSet);
		assertEquals(2L, expression.getValue());
		assertEquals("sec", expression.getUnit().getName());
	}

	@Test
	public void recordsExtractFieldsAndRoundTripNestedValues() throws Exception {
		var context = classifier("Populated");
		var record = (GeneratedRecord) ((Optional<?>) get("Settings", context)).orElseThrow();
		var type = record.getClass();
		assertEquals(Optional.of(true), type.getMethod("getEnabled").invoke(record));
		assertEquals(OptionalLong.of(3), type.getMethod("getRetries").invoke(record));
		assertEquals(Optional.of(List.of("a", "b")), type.getMethod("getLabels").invoke(record));
		var labels = (List<?>) ((Optional<?>) type.getMethod("getLabels").invoke(record)).orElseThrow();
		assertThrows(UnsupportedOperationException.class, labels::clear);
		var nested = ((Optional<?>) type.getMethod("getNested").invoke(record)).orElseThrow();
		assertEquals(OptionalLong.of(8), nested.getClass().getMethod("getAmount").invoke(nested));
		var expression = record.toPropertyExpression(model.eResource().getResourceSet());
		assertEquals(5, expression.getOwnedFieldValues().size());
		var copy = type.getConstructor(PropertyExpression.class, NamedElement.class, Optional.class)
				.newInstance(expression, context, Optional.empty());
		assertEquals(record, copy);
		assertEquals(record.hashCode(), copy.hashCode());
		assertEquals(record.toString(), copy.toString());
		assertTrue(record.toString().contains("retries => 3;"));
		assertFalse(record.equals(null));
		assertFalse(record.equals("not a record"));
		var constant = getters.getMethod("getSettingsConstant", EObject.class).invoke(null, context);
		assertEquals(Optional.of(false), type.getMethod("getEnabled").invoke(constant));
		assertEquals(OptionalLong.of(2), type.getMethod("getRetries").invoke(constant));
		assertEquals(Optional.empty(), type.getMethod("getNested").invoke(constant));
		assertNotEquals(record, constant);
	}

	private Object get(String property, NamedElement context) throws Exception {
		return getters.getMethod("get" + property, NamedElement.class).invoke(null, context);
	}

	private NamedElement classifier(String name) {
		return model.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equalsIgnoreCase(name))
				.findFirst()
				.orElseThrow();
	}
}
