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
import static org.osate.propertiescodegen.tests.GeneratedJavaCompiler.generateAndCompile;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.PropertySet;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

/** Verifies exact generated Java for range. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class RangeTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testRange() throws Exception {
		var otherPs = """
				property set other_ps is
				\tmass: type units (g, kg => g * 1000);
				end other_ps;
				""";
		var rangeTest = """
				property set range_test is
				\twith other_ps;
				\t
				\ttime: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				\t
				\tinteger_no_units: range of aadlinteger applies to (all);
				\tinteger_owned_units: range of aadlinteger units (cm, m => cm * 100) applies to (all);
				\tinteger_same_file_units: range of aadlinteger units range_test::time applies to (all);
				\tinteger_other_file_units: range of aadlinteger units other_ps::mass applies to (all);
				\t
				\tlist_1_integer_no_units: list of range of aadlinteger applies to (all);
				\tlist_1_integer_owned_units: list of range of aadlinteger units (m, km => m * 1000) applies to (all);
				\tlist_1_integer_same_file_units: list of range of aadlinteger units range_test::time applies to (all);
				\tlist_1_integer_other_file_units: list of range of aadlinteger units other_ps::mass applies to (all);
				\t
				\treal_no_units: range of aadlreal applies to (all);
				\treal_owned_units: range of aadlreal units (mm, cm => mm * 10) applies to (all);
				\treal_same_file_units: range of aadlreal units range_test::time applies to (all);
				\treal_other_file_units: range of aadlreal units other_ps::mass applies to (all);
				\t
				\tlist_1_real_no_units: list of range of aadlreal applies to (all);
				\tlist_1_real_owned_units: list of range of aadlreal units (mg, cg => mg * 10) applies to (all);
				\tlist_1_real_same_file_units: list of range of aadlreal units range_test::time applies to (all);
				\tlist_1_real_other_file_units: list of range of aadlreal units other_ps::mass applies to (all);
				\t
				\trecord_property: record (
				\t\tinteger_no_units: range of aadlinteger;
				\t\tinteger_owned_units: range of aadlinteger units (cm, m => cm * 100);
				\t\tinteger_same_file_units: range of aadlinteger units range_test::time;
				\t\tinteger_other_file_units: range of aadlinteger units other_ps::mass;
				\t\t
				\t\tlist_1_integer_no_units: list of range of aadlinteger;
				\t\tlist_1_integer_owned_units: list of range of aadlinteger units (m, km => m * 1000);
				\t\tlist_1_integer_same_file_units: list of range of aadlinteger units range_test::time;
				\t\tlist_1_integer_other_file_units: list of range of aadlinteger units other_ps::mass;
				\t\t
				\t\treal_no_units: range of aadlreal;
				\t\treal_owned_units: range of aadlreal units (mm, cm => mm * 10);
				\t\treal_same_file_units: range of aadlreal units range_test::time;
				\t\treal_other_file_units: range of aadlreal units other_ps::mass;
				\t\t
				\t\tlist_1_real_no_units: list of range of aadlreal;
				\t\tlist_1_real_owned_units: list of range of aadlreal units (mg, cg => mg * 10);
				\t\tlist_1_real_same_file_units: list of range of aadlreal units range_test::time;
				\t\tlist_1_real_other_file_units: list of range of aadlreal units other_ps::mass;
				\t) applies to (all);
				\t
				\tinteger_no_units_constant: constant range of aadlinteger => 1 .. 2;
				\tinteger_owned_units_constant: constant range of aadlinteger units (cm, m => cm * 100) => 3 cm .. 4 m;
				\tinteger_same_file_units_constant: constant range of aadlinteger units range_test::time => 5 sec .. 6 min;
				\tinteger_other_file_units_constant: constant range of aadlinteger units other_ps::mass => 7 g .. 8 kg;
				\t
				\tlist_1_integer_no_units_constant: constant list of range of aadlinteger => (9 .. 10, 11 .. 12);
				\tlist_1_integer_owned_units_constant: constant list of range of aadlinteger units (m, km => m * 1000) => (13 m .. 14 km, 15 m .. 16 km);
				\tlist_1_integer_same_file_units_constant: constant list of range of aadlinteger units range_test::time => (17 sec .. 18 min, 19 hr .. 20 day);
				\tlist_1_integer_other_file_units_constant: constant list of range of aadlinteger units other_ps::mass => (21 g .. 22 kg, 23 g .. 24 kg);
				\t
				\treal_no_units_constant: constant range of aadlreal => 25.25 .. 26.26;
				\treal_owned_units_constant: constant range of aadlreal units (mm, cm => mm * 10) => 27.27 mm .. 28.28 cm;
				\treal_same_file_units_constant: constant range of aadlreal units range_test::time => 29.29 sec .. 30.0 min;
				\treal_other_file_units_constant: constant range of aadlreal units other_ps::mass => 31.31 g .. 32.32 kg;
				\t
				\tlist_1_real_no_units_constant: constant list of range of aadlreal => (33.33 .. 34.34, 35.35 .. 36.36);
				\tlist_1_real_owned_units_constant: constant list of range of aadlreal units (mg, cg => mg * 10) => (37.37 mg .. 38.38 cg, 39.39 mg .. 40.0 cg);
				\tlist_1_real_same_file_units_constant: constant list of range of aadlreal units range_test::time => (41.41 sec .. 42.42 min, 43.43 hr .. 44.44 day);
				\tlist_1_real_other_file_units_constant: constant list of range of aadlreal units other_ps::mass => (45.45 g .. 46.46 kg, 47.47 g .. 48.48 kg);
				end range_test;
				""";
		var rangeTestClass = """
				package rangetest;

				import java.util.List;
				import java.util.Optional;

				import org.eclipse.emf.ecore.EObject;
				import org.osate.aadl2.Aadl2Package;
				import org.osate.aadl2.ListValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.Property;
				import org.osate.aadl2.PropertyConstant;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
				import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.IntegerRange;
				import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
				import org.osate.pluginsupport.properties.RealRange;
				import org.osate.pluginsupport.properties.RealRangeWithUnits;

				import otherps.Mass;

				public final class RangeTest {
				\tpublic static final String RANGE_TEST__NAME = "range_test";

				\tprivate RangeTest() {}

				\t// Lookup methods for range_test::integer_no_units

				\tpublic static final String INTEGER_NO_UNITS__NAME = "integer_no_units";

				\tpublic static boolean acceptsIntegerNoUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getIntegerNoUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<IntegerRange> getIntegerNoUnits(NamedElement lookupContext) {
				\t\treturn getIntegerNoUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<IntegerRange> getIntegerNoUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getIntegerNoUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<IntegerRange> getIntegerNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getIntegerNoUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new IntegerRange(resolved, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getIntegerNoUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + INTEGER_NO_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getIntegerNoUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getIntegerNoUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::integer_owned_units

				\tpublic static final String INTEGER_OWNED_UNITS__NAME = "integer_owned_units";

				\tpublic static boolean acceptsIntegerOwnedUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getIntegerOwnedUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<IntegerRangeWithUnits<IntegerOwnedUnits>> getIntegerOwnedUnits(NamedElement lookupContext) {
				\t\treturn getIntegerOwnedUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<IntegerRangeWithUnits<IntegerOwnedUnits>> getIntegerOwnedUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getIntegerOwnedUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<IntegerRangeWithUnits<IntegerOwnedUnits>> getIntegerOwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getIntegerOwnedUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new IntegerRangeWithUnits<>(resolved, IntegerOwnedUnits.class, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getIntegerOwnedUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + INTEGER_OWNED_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getIntegerOwnedUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getIntegerOwnedUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::integer_same_file_units

				\tpublic static final String INTEGER_SAME_FILE_UNITS__NAME = "integer_same_file_units";

				\tpublic static boolean acceptsIntegerSameFileUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getIntegerSameFileUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<IntegerRangeWithUnits<Time>> getIntegerSameFileUnits(NamedElement lookupContext) {
				\t\treturn getIntegerSameFileUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<IntegerRangeWithUnits<Time>> getIntegerSameFileUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getIntegerSameFileUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<IntegerRangeWithUnits<Time>> getIntegerSameFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getIntegerSameFileUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new IntegerRangeWithUnits<>(resolved, Time.class, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getIntegerSameFileUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + INTEGER_SAME_FILE_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getIntegerSameFileUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getIntegerSameFileUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::integer_other_file_units

				\tpublic static final String INTEGER_OTHER_FILE_UNITS__NAME = "integer_other_file_units";

				\tpublic static boolean acceptsIntegerOtherFileUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getIntegerOtherFileUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<IntegerRangeWithUnits<Mass>> getIntegerOtherFileUnits(NamedElement lookupContext) {
				\t\treturn getIntegerOtherFileUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<IntegerRangeWithUnits<Mass>> getIntegerOtherFileUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getIntegerOtherFileUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<IntegerRangeWithUnits<Mass>> getIntegerOtherFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getIntegerOtherFileUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new IntegerRangeWithUnits<>(resolved, Mass.class, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getIntegerOtherFileUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + INTEGER_OTHER_FILE_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getIntegerOtherFileUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getIntegerOtherFileUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::list_1_integer_no_units

				\tpublic static final String LIST_1_INTEGER_NO_UNITS__NAME = "list_1_integer_no_units";

				\tpublic static boolean acceptsList1IntegerNoUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1IntegerNoUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<List<IntegerRange>> getList1IntegerNoUnits(NamedElement lookupContext) {
				\t\treturn getList1IntegerNoUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<IntegerRange>> getList1IntegerNoUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1IntegerNoUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<IntegerRange>> getList1IntegerNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1IntegerNoUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new IntegerRange(resolved1, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1IntegerNoUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_NO_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1IntegerNoUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1IntegerNoUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::list_1_integer_owned_units

				\tpublic static final String LIST_1_INTEGER_OWNED_UNITS__NAME = "list_1_integer_owned_units";

				\tpublic static boolean acceptsList1IntegerOwnedUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1IntegerOwnedUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits>>> getList1IntegerOwnedUnits(NamedElement lookupContext) {
				\t\treturn getList1IntegerOwnedUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits>>> getList1IntegerOwnedUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1IntegerOwnedUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits>>> getList1IntegerOwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1IntegerOwnedUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new IntegerRangeWithUnits<>(resolved1, List1IntegerOwnedUnits.class, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1IntegerOwnedUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_OWNED_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1IntegerOwnedUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1IntegerOwnedUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::list_1_integer_same_file_units

				\tpublic static final String LIST_1_INTEGER_SAME_FILE_UNITS__NAME = "list_1_integer_same_file_units";

				\tpublic static boolean acceptsList1IntegerSameFileUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1IntegerSameFileUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<List<IntegerRangeWithUnits<Time>>> getList1IntegerSameFileUnits(NamedElement lookupContext) {
				\t\treturn getList1IntegerSameFileUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<IntegerRangeWithUnits<Time>>> getList1IntegerSameFileUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1IntegerSameFileUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<IntegerRangeWithUnits<Time>>> getList1IntegerSameFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1IntegerSameFileUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new IntegerRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1IntegerSameFileUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_SAME_FILE_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1IntegerSameFileUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1IntegerSameFileUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::list_1_integer_other_file_units

				\tpublic static final String LIST_1_INTEGER_OTHER_FILE_UNITS__NAME = "list_1_integer_other_file_units";

				\tpublic static boolean acceptsList1IntegerOtherFileUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1IntegerOtherFileUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<List<IntegerRangeWithUnits<Mass>>> getList1IntegerOtherFileUnits(NamedElement lookupContext) {
				\t\treturn getList1IntegerOtherFileUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<IntegerRangeWithUnits<Mass>>> getList1IntegerOtherFileUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1IntegerOtherFileUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<IntegerRangeWithUnits<Mass>>> getList1IntegerOtherFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1IntegerOtherFileUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new IntegerRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1IntegerOtherFileUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_OTHER_FILE_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1IntegerOtherFileUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1IntegerOtherFileUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::real_no_units

				\tpublic static final String REAL_NO_UNITS__NAME = "real_no_units";

				\tpublic static boolean acceptsRealNoUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRealNoUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<RealRange> getRealNoUnits(NamedElement lookupContext) {
				\t\treturn getRealNoUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RealRange> getRealNoUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getRealNoUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RealRange> getRealNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRealNoUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RealRange(resolved, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRealNoUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + REAL_NO_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRealNoUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRealNoUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::real_owned_units

				\tpublic static final String REAL_OWNED_UNITS__NAME = "real_owned_units";

				\tpublic static boolean acceptsRealOwnedUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRealOwnedUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<RealRangeWithUnits<RealOwnedUnits>> getRealOwnedUnits(NamedElement lookupContext) {
				\t\treturn getRealOwnedUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RealRangeWithUnits<RealOwnedUnits>> getRealOwnedUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getRealOwnedUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RealRangeWithUnits<RealOwnedUnits>> getRealOwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRealOwnedUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RealRangeWithUnits<>(resolved, RealOwnedUnits.class, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRealOwnedUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + REAL_OWNED_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRealOwnedUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRealOwnedUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::real_same_file_units

				\tpublic static final String REAL_SAME_FILE_UNITS__NAME = "real_same_file_units";

				\tpublic static boolean acceptsRealSameFileUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRealSameFileUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<RealRangeWithUnits<Time>> getRealSameFileUnits(NamedElement lookupContext) {
				\t\treturn getRealSameFileUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RealRangeWithUnits<Time>> getRealSameFileUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getRealSameFileUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RealRangeWithUnits<Time>> getRealSameFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRealSameFileUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RealRangeWithUnits<>(resolved, Time.class, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRealSameFileUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + REAL_SAME_FILE_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRealSameFileUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRealSameFileUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::real_other_file_units

				\tpublic static final String REAL_OTHER_FILE_UNITS__NAME = "real_other_file_units";

				\tpublic static boolean acceptsRealOtherFileUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRealOtherFileUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<RealRangeWithUnits<Mass>> getRealOtherFileUnits(NamedElement lookupContext) {
				\t\treturn getRealOtherFileUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RealRangeWithUnits<Mass>> getRealOtherFileUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getRealOtherFileUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RealRangeWithUnits<Mass>> getRealOtherFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRealOtherFileUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RealRangeWithUnits<>(resolved, Mass.class, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRealOtherFileUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + REAL_OTHER_FILE_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRealOtherFileUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRealOtherFileUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::list_1_real_no_units

				\tpublic static final String LIST_1_REAL_NO_UNITS__NAME = "list_1_real_no_units";

				\tpublic static boolean acceptsList1RealNoUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1RealNoUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<List<RealRange>> getList1RealNoUnits(NamedElement lookupContext) {
				\t\treturn getList1RealNoUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<RealRange>> getList1RealNoUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1RealNoUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<RealRange>> getList1RealNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1RealNoUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new RealRange(resolved1, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1RealNoUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_REAL_NO_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1RealNoUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1RealNoUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::list_1_real_owned_units

				\tpublic static final String LIST_1_REAL_OWNED_UNITS__NAME = "list_1_real_owned_units";

				\tpublic static boolean acceptsList1RealOwnedUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1RealOwnedUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<List<RealRangeWithUnits<List1RealOwnedUnits>>> getList1RealOwnedUnits(NamedElement lookupContext) {
				\t\treturn getList1RealOwnedUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<RealRangeWithUnits<List1RealOwnedUnits>>> getList1RealOwnedUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1RealOwnedUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<RealRangeWithUnits<List1RealOwnedUnits>>> getList1RealOwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1RealOwnedUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new RealRangeWithUnits<>(resolved1, List1RealOwnedUnits.class, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1RealOwnedUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_REAL_OWNED_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1RealOwnedUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1RealOwnedUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::list_1_real_same_file_units

				\tpublic static final String LIST_1_REAL_SAME_FILE_UNITS__NAME = "list_1_real_same_file_units";

				\tpublic static boolean acceptsList1RealSameFileUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1RealSameFileUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<List<RealRangeWithUnits<Time>>> getList1RealSameFileUnits(NamedElement lookupContext) {
				\t\treturn getList1RealSameFileUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<RealRangeWithUnits<Time>>> getList1RealSameFileUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1RealSameFileUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<RealRangeWithUnits<Time>>> getList1RealSameFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1RealSameFileUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new RealRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1RealSameFileUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_REAL_SAME_FILE_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1RealSameFileUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1RealSameFileUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::list_1_real_other_file_units

				\tpublic static final String LIST_1_REAL_OTHER_FILE_UNITS__NAME = "list_1_real_other_file_units";

				\tpublic static boolean acceptsList1RealOtherFileUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1RealOtherFileUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<List<RealRangeWithUnits<Mass>>> getList1RealOtherFileUnits(NamedElement lookupContext) {
				\t\treturn getList1RealOtherFileUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<RealRangeWithUnits<Mass>>> getList1RealOtherFileUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1RealOtherFileUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<RealRangeWithUnits<Mass>>> getList1RealOtherFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1RealOtherFileUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new RealRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1RealOtherFileUnits_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_REAL_OTHER_FILE_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1RealOtherFileUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1RealOtherFileUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::record_property

				\tpublic static final String RECORD_PROPERTY__NAME = "record_property";

				\tpublic static boolean acceptsRecordProperty(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRecordProperty_Property(lookupContext));
				\t}

				\tpublic static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext) {
				\t\treturn getRecordProperty(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext, Mode mode) {
				\t\treturn getRecordProperty(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRecordProperty_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RecordProperty(resolved, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRecordProperty_Property(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + RECORD_PROPERTY__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRecordProperty_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRecordProperty_Property(lookupContext));
				\t}

				\t// Lookup methods for range_test::integer_no_units_constant

				\tpublic static final String INTEGER_NO_UNITS_CONSTANT__NAME = "integer_no_units_constant";

				\tpublic static IntegerRange getIntegerNoUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getIntegerNoUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new IntegerRange(resolved);
				\t}

				\tpublic static PropertyConstant getIntegerNoUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + INTEGER_NO_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::integer_owned_units_constant

				\tpublic static final String INTEGER_OWNED_UNITS_CONSTANT__NAME = "integer_owned_units_constant";

				\tpublic static IntegerRangeWithUnits<IntegerOwnedUnitsConstant> getIntegerOwnedUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getIntegerOwnedUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new IntegerRangeWithUnits<>(resolved, IntegerOwnedUnitsConstant.class);
				\t}

				\tpublic static PropertyConstant getIntegerOwnedUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + INTEGER_OWNED_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::integer_same_file_units_constant

				\tpublic static final String INTEGER_SAME_FILE_UNITS_CONSTANT__NAME = "integer_same_file_units_constant";

				\tpublic static IntegerRangeWithUnits<Time> getIntegerSameFileUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getIntegerSameFileUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new IntegerRangeWithUnits<>(resolved, Time.class);
				\t}

				\tpublic static PropertyConstant getIntegerSameFileUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + INTEGER_SAME_FILE_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::integer_other_file_units_constant

				\tpublic static final String INTEGER_OTHER_FILE_UNITS_CONSTANT__NAME = "integer_other_file_units_constant";

				\tpublic static IntegerRangeWithUnits<Mass> getIntegerOtherFileUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getIntegerOtherFileUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new IntegerRangeWithUnits<>(resolved, Mass.class);
				\t}

				\tpublic static PropertyConstant getIntegerOtherFileUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + INTEGER_OTHER_FILE_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::list_1_integer_no_units_constant

				\tpublic static final String LIST_1_INTEGER_NO_UNITS_CONSTANT__NAME = "list_1_integer_no_units_constant";

				\tpublic static List<IntegerRange> getList1IntegerNoUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getList1IntegerNoUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn new IntegerRange(resolved1);
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1IntegerNoUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_NO_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::list_1_integer_owned_units_constant

				\tpublic static final String LIST_1_INTEGER_OWNED_UNITS_CONSTANT__NAME = "list_1_integer_owned_units_constant";

				\tpublic static List<IntegerRangeWithUnits<List1IntegerOwnedUnitsConstant>> getList1IntegerOwnedUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getList1IntegerOwnedUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn new IntegerRangeWithUnits<>(resolved1, List1IntegerOwnedUnitsConstant.class);
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1IntegerOwnedUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_OWNED_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::list_1_integer_same_file_units_constant

				\tpublic static final String LIST_1_INTEGER_SAME_FILE_UNITS_CONSTANT__NAME = "list_1_integer_same_file_units_constant";

				\tpublic static List<IntegerRangeWithUnits<Time>> getList1IntegerSameFileUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getList1IntegerSameFileUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn new IntegerRangeWithUnits<>(resolved1, Time.class);
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1IntegerSameFileUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_SAME_FILE_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::list_1_integer_other_file_units_constant

				\tpublic static final String LIST_1_INTEGER_OTHER_FILE_UNITS_CONSTANT__NAME = "list_1_integer_other_file_units_constant";

				\tpublic static List<IntegerRangeWithUnits<Mass>> getList1IntegerOtherFileUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getList1IntegerOtherFileUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn new IntegerRangeWithUnits<>(resolved1, Mass.class);
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1IntegerOtherFileUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_OTHER_FILE_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::real_no_units_constant

				\tpublic static final String REAL_NO_UNITS_CONSTANT__NAME = "real_no_units_constant";

				\tpublic static RealRange getRealNoUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getRealNoUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new RealRange(resolved);
				\t}

				\tpublic static PropertyConstant getRealNoUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + REAL_NO_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::real_owned_units_constant

				\tpublic static final String REAL_OWNED_UNITS_CONSTANT__NAME = "real_owned_units_constant";

				\tpublic static RealRangeWithUnits<RealOwnedUnitsConstant> getRealOwnedUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getRealOwnedUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new RealRangeWithUnits<>(resolved, RealOwnedUnitsConstant.class);
				\t}

				\tpublic static PropertyConstant getRealOwnedUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + REAL_OWNED_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::real_same_file_units_constant

				\tpublic static final String REAL_SAME_FILE_UNITS_CONSTANT__NAME = "real_same_file_units_constant";

				\tpublic static RealRangeWithUnits<Time> getRealSameFileUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getRealSameFileUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new RealRangeWithUnits<>(resolved, Time.class);
				\t}

				\tpublic static PropertyConstant getRealSameFileUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + REAL_SAME_FILE_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::real_other_file_units_constant

				\tpublic static final String REAL_OTHER_FILE_UNITS_CONSTANT__NAME = "real_other_file_units_constant";

				\tpublic static RealRangeWithUnits<Mass> getRealOtherFileUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getRealOtherFileUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new RealRangeWithUnits<>(resolved, Mass.class);
				\t}

				\tpublic static PropertyConstant getRealOtherFileUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + REAL_OTHER_FILE_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::list_1_real_no_units_constant

				\tpublic static final String LIST_1_REAL_NO_UNITS_CONSTANT__NAME = "list_1_real_no_units_constant";

				\tpublic static List<RealRange> getList1RealNoUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getList1RealNoUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn new RealRange(resolved1);
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1RealNoUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_REAL_NO_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::list_1_real_owned_units_constant

				\tpublic static final String LIST_1_REAL_OWNED_UNITS_CONSTANT__NAME = "list_1_real_owned_units_constant";

				\tpublic static List<RealRangeWithUnits<List1RealOwnedUnitsConstant>> getList1RealOwnedUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getList1RealOwnedUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn new RealRangeWithUnits<>(resolved1, List1RealOwnedUnitsConstant.class);
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1RealOwnedUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_REAL_OWNED_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::list_1_real_same_file_units_constant

				\tpublic static final String LIST_1_REAL_SAME_FILE_UNITS_CONSTANT__NAME = "list_1_real_same_file_units_constant";

				\tpublic static List<RealRangeWithUnits<Time>> getList1RealSameFileUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getList1RealSameFileUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn new RealRangeWithUnits<>(resolved1, Time.class);
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1RealSameFileUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_REAL_SAME_FILE_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for range_test::list_1_real_other_file_units_constant

				\tpublic static final String LIST_1_REAL_OTHER_FILE_UNITS_CONSTANT__NAME = "list_1_real_other_file_units_constant";

				\tpublic static List<RealRangeWithUnits<Mass>> getList1RealOtherFileUnitsConstant(EObject lookupContext) {
				\t\tvar constant = getList1RealOtherFileUnitsConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn new RealRangeWithUnits<>(resolved1, Mass.class);
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1RealOtherFileUnitsConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RANGE_TEST__NAME + "::" + LIST_1_REAL_OTHER_FILE_UNITS_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}
				}
				""";
		var time = """
				package rangetest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum Time implements GeneratedUnits<Time> {
				\tSEC(1.0, "sec", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				\tMIN(60.0, "min", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				\tHR(3600.0, "hr", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
				\tDAY(86400.0, "day", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate Time(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static Time valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(Time target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var integerOwnedUnits = """
				package rangetest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum IntegerOwnedUnits implements GeneratedUnits<IntegerOwnedUnits> {
				\tCM(1.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\tM(100.0, "m", "__synthetic1.aadl#/0/@ownedProperty.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate IntegerOwnedUnits(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static IntegerOwnedUnits valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(IntegerOwnedUnits target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var list1IntegerOwnedUnits = """
				package rangetest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum List1IntegerOwnedUnits implements GeneratedUnits<List1IntegerOwnedUnits> {
				\tM(1.0, "m", "__synthetic1.aadl#/0/@ownedProperty.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\tKM(1000.0, "km", "__synthetic1.aadl#/0/@ownedProperty.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate List1IntegerOwnedUnits(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static List1IntegerOwnedUnits valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(List1IntegerOwnedUnits target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var realOwnedUnits = """
				package rangetest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum RealOwnedUnits implements GeneratedUnits<RealOwnedUnits> {
				\tMM(1.0, "mm", "__synthetic1.aadl#/0/@ownedProperty.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\tCM(10.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate RealOwnedUnits(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static RealOwnedUnits valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(RealOwnedUnits target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var list1RealOwnedUnits = """
				package rangetest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum List1RealOwnedUnits implements GeneratedUnits<List1RealOwnedUnits> {
				\tMG(1.0, "mg", "__synthetic1.aadl#/0/@ownedProperty.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\tCG(10.0, "cg", "__synthetic1.aadl#/0/@ownedProperty.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate List1RealOwnedUnits(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static List1RealOwnedUnits valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(List1RealOwnedUnits target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var recordProperty = """
				package rangetest;

				import java.util.List;
				import java.util.Objects;
				import java.util.Optional;
				import java.util.stream.Collectors;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.ListValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;
				import org.osate.pluginsupport.properties.GeneratedUnits;
				import org.osate.pluginsupport.properties.IntegerRange;
				import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
				import org.osate.pluginsupport.properties.RealRange;
				import org.osate.pluginsupport.properties.RealRangeWithUnits;

				import otherps.Mass;

				public class RecordProperty extends GeneratedRecord {
				\tpublic static final String INTEGER_NO_UNITS__NAME = "integer_no_units";
				\tpublic static final String INTEGER_OWNED_UNITS__NAME = "integer_owned_units";
				\tpublic static final String INTEGER_SAME_FILE_UNITS__NAME = "integer_same_file_units";
				\tpublic static final String INTEGER_OTHER_FILE_UNITS__NAME = "integer_other_file_units";
				\tpublic static final String LIST_1_INTEGER_NO_UNITS__NAME = "list_1_integer_no_units";
				\tpublic static final String LIST_1_INTEGER_OWNED_UNITS__NAME = "list_1_integer_owned_units";
				\tpublic static final String LIST_1_INTEGER_SAME_FILE_UNITS__NAME = "list_1_integer_same_file_units";
				\tpublic static final String LIST_1_INTEGER_OTHER_FILE_UNITS__NAME = "list_1_integer_other_file_units";
				\tpublic static final String REAL_NO_UNITS__NAME = "real_no_units";
				\tpublic static final String REAL_OWNED_UNITS__NAME = "real_owned_units";
				\tpublic static final String REAL_SAME_FILE_UNITS__NAME = "real_same_file_units";
				\tpublic static final String REAL_OTHER_FILE_UNITS__NAME = "real_other_file_units";
				\tpublic static final String LIST_1_REAL_NO_UNITS__NAME = "list_1_real_no_units";
				\tpublic static final String LIST_1_REAL_OWNED_UNITS__NAME = "list_1_real_owned_units";
				\tpublic static final String LIST_1_REAL_SAME_FILE_UNITS__NAME = "list_1_real_same_file_units";
				\tpublic static final String LIST_1_REAL_OTHER_FILE_UNITS__NAME = "list_1_real_other_file_units";
				\tpublic static final URI INTEGER_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.0");
				\tpublic static final URI INTEGER_OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.1");
				\tpublic static final URI INTEGER_SAME_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.2");
				\tpublic static final URI INTEGER_OTHER_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.3");
				\tpublic static final URI LIST_1_INTEGER_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.4");
				\tpublic static final URI LIST_1_INTEGER_OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.5");
				\tpublic static final URI LIST_1_INTEGER_SAME_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.6");
				\tpublic static final URI LIST_1_INTEGER_OTHER_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.7");
				\tpublic static final URI REAL_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.8");
				\tpublic static final URI REAL_OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.9");
				\tpublic static final URI REAL_SAME_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.10");
				\tpublic static final URI REAL_OTHER_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.11");
				\tpublic static final URI LIST_1_REAL_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.12");
				\tpublic static final URI LIST_1_REAL_OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.13");
				\tpublic static final URI LIST_1_REAL_SAME_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.14");
				\tpublic static final URI LIST_1_REAL_OTHER_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.15");

				\tprivate final Optional<IntegerRange> integerNoUnits;
				\tprivate final Optional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> integerOwnedUnits;
				\tprivate final Optional<IntegerRangeWithUnits<Time>> integerSameFileUnits;
				\tprivate final Optional<IntegerRangeWithUnits<Mass>> integerOtherFileUnits;
				\tprivate final Optional<List<IntegerRange>> list1IntegerNoUnits;
				\tprivate final Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> list1IntegerOwnedUnits;
				\tprivate final Optional<List<IntegerRangeWithUnits<Time>>> list1IntegerSameFileUnits;
				\tprivate final Optional<List<IntegerRangeWithUnits<Mass>>> list1IntegerOtherFileUnits;
				\tprivate final Optional<RealRange> realNoUnits;
				\tprivate final Optional<RealRangeWithUnits<RealOwnedUnits_FieldType>> realOwnedUnits;
				\tprivate final Optional<RealRangeWithUnits<Time>> realSameFileUnits;
				\tprivate final Optional<RealRangeWithUnits<Mass>> realOtherFileUnits;
				\tprivate final Optional<List<RealRange>> list1RealNoUnits;
				\tprivate final Optional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> list1RealOwnedUnits;
				\tprivate final Optional<List<RealRangeWithUnits<Time>>> list1RealSameFileUnits;
				\tprivate final Optional<List<RealRangeWithUnits<Mass>>> list1RealOtherFileUnits;

				\tpublic RecordProperty(
				\t\t\tOptional<IntegerRange> integerNoUnits,
				\t\t\tOptional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> integerOwnedUnits,
				\t\t\tOptional<IntegerRangeWithUnits<Time>> integerSameFileUnits,
				\t\t\tOptional<IntegerRangeWithUnits<Mass>> integerOtherFileUnits,
				\t\t\tOptional<List<IntegerRange>> list1IntegerNoUnits,
				\t\t\tOptional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> list1IntegerOwnedUnits,
				\t\t\tOptional<List<IntegerRangeWithUnits<Time>>> list1IntegerSameFileUnits,
				\t\t\tOptional<List<IntegerRangeWithUnits<Mass>>> list1IntegerOtherFileUnits,
				\t\t\tOptional<RealRange> realNoUnits,
				\t\t\tOptional<RealRangeWithUnits<RealOwnedUnits_FieldType>> realOwnedUnits,
				\t\t\tOptional<RealRangeWithUnits<Time>> realSameFileUnits,
				\t\t\tOptional<RealRangeWithUnits<Mass>> realOtherFileUnits,
				\t\t\tOptional<List<RealRange>> list1RealNoUnits,
				\t\t\tOptional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> list1RealOwnedUnits,
				\t\t\tOptional<List<RealRangeWithUnits<Time>>> list1RealSameFileUnits,
				\t\t\tOptional<List<RealRangeWithUnits<Mass>>> list1RealOtherFileUnits
				\t) {
				\t\tthis.integerNoUnits = integerNoUnits;
				\t\tthis.integerOwnedUnits = integerOwnedUnits;
				\t\tthis.integerSameFileUnits = integerSameFileUnits;
				\t\tthis.integerOtherFileUnits = integerOtherFileUnits;
				\t\tthis.list1IntegerNoUnits = list1IntegerNoUnits;
				\t\tthis.list1IntegerOwnedUnits = list1IntegerOwnedUnits;
				\t\tthis.list1IntegerSameFileUnits = list1IntegerSameFileUnits;
				\t\tthis.list1IntegerOtherFileUnits = list1IntegerOtherFileUnits;
				\t\tthis.realNoUnits = realNoUnits;
				\t\tthis.realOwnedUnits = realOwnedUnits;
				\t\tthis.realSameFileUnits = realSameFileUnits;
				\t\tthis.realOtherFileUnits = realOtherFileUnits;
				\t\tthis.list1RealNoUnits = list1RealNoUnits;
				\t\tthis.list1RealOwnedUnits = list1RealOwnedUnits;
				\t\tthis.list1RealSameFileUnits = list1RealSameFileUnits;
				\t\tthis.list1RealOtherFileUnits = list1RealOtherFileUnits;
				\t}

				\tpublic RecordProperty(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<IntegerRange> integerNoUnits_local;
				\t\ttry {
				\t\t\tintegerNoUnits_local = findFieldValue(recordValue, INTEGER_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new IntegerRange(resolved, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tintegerNoUnits_local = Optional.empty();
				\t\t}
				\t\tthis.integerNoUnits = integerNoUnits_local;

				\t\tOptional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> integerOwnedUnits_local;
				\t\ttry {
				\t\t\tintegerOwnedUnits_local = findFieldValue(recordValue, INTEGER_OWNED_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new IntegerRangeWithUnits<>(resolved, IntegerOwnedUnits_FieldType.class, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tintegerOwnedUnits_local = Optional.empty();
				\t\t}
				\t\tthis.integerOwnedUnits = integerOwnedUnits_local;

				\t\tOptional<IntegerRangeWithUnits<Time>> integerSameFileUnits_local;
				\t\ttry {
				\t\t\tintegerSameFileUnits_local = findFieldValue(recordValue, INTEGER_SAME_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new IntegerRangeWithUnits<>(resolved, Time.class, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tintegerSameFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.integerSameFileUnits = integerSameFileUnits_local;

				\t\tOptional<IntegerRangeWithUnits<Mass>> integerOtherFileUnits_local;
				\t\ttry {
				\t\t\tintegerOtherFileUnits_local = findFieldValue(recordValue, INTEGER_OTHER_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new IntegerRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tintegerOtherFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.integerOtherFileUnits = integerOtherFileUnits_local;

				\t\tOptional<List<IntegerRange>> list1IntegerNoUnits_local;
				\t\ttry {
				\t\t\tlist1IntegerNoUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new IntegerRange(resolved1, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1IntegerNoUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1IntegerNoUnits = list1IntegerNoUnits_local;

				\t\tOptional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> list1IntegerOwnedUnits_local;
				\t\ttry {
				\t\t\tlist1IntegerOwnedUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_OWNED_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new IntegerRangeWithUnits<>(resolved1, List1IntegerOwnedUnits_FieldType.class, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1IntegerOwnedUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1IntegerOwnedUnits = list1IntegerOwnedUnits_local;

				\t\tOptional<List<IntegerRangeWithUnits<Time>>> list1IntegerSameFileUnits_local;
				\t\ttry {
				\t\t\tlist1IntegerSameFileUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_SAME_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new IntegerRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1IntegerSameFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1IntegerSameFileUnits = list1IntegerSameFileUnits_local;

				\t\tOptional<List<IntegerRangeWithUnits<Mass>>> list1IntegerOtherFileUnits_local;
				\t\ttry {
				\t\t\tlist1IntegerOtherFileUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_OTHER_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new IntegerRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1IntegerOtherFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1IntegerOtherFileUnits = list1IntegerOtherFileUnits_local;

				\t\tOptional<RealRange> realNoUnits_local;
				\t\ttry {
				\t\t\trealNoUnits_local = findFieldValue(recordValue, REAL_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new RealRange(resolved, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trealNoUnits_local = Optional.empty();
				\t\t}
				\t\tthis.realNoUnits = realNoUnits_local;

				\t\tOptional<RealRangeWithUnits<RealOwnedUnits_FieldType>> realOwnedUnits_local;
				\t\ttry {
				\t\t\trealOwnedUnits_local = findFieldValue(recordValue, REAL_OWNED_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new RealRangeWithUnits<>(resolved, RealOwnedUnits_FieldType.class, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trealOwnedUnits_local = Optional.empty();
				\t\t}
				\t\tthis.realOwnedUnits = realOwnedUnits_local;

				\t\tOptional<RealRangeWithUnits<Time>> realSameFileUnits_local;
				\t\ttry {
				\t\t\trealSameFileUnits_local = findFieldValue(recordValue, REAL_SAME_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new RealRangeWithUnits<>(resolved, Time.class, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trealSameFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.realSameFileUnits = realSameFileUnits_local;

				\t\tOptional<RealRangeWithUnits<Mass>> realOtherFileUnits_local;
				\t\ttry {
				\t\t\trealOtherFileUnits_local = findFieldValue(recordValue, REAL_OTHER_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new RealRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trealOtherFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.realOtherFileUnits = realOtherFileUnits_local;

				\t\tOptional<List<RealRange>> list1RealNoUnits_local;
				\t\ttry {
				\t\t\tlist1RealNoUnits_local = findFieldValue(recordValue, LIST_1_REAL_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new RealRange(resolved1, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1RealNoUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1RealNoUnits = list1RealNoUnits_local;

				\t\tOptional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> list1RealOwnedUnits_local;
				\t\ttry {
				\t\t\tlist1RealOwnedUnits_local = findFieldValue(recordValue, LIST_1_REAL_OWNED_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new RealRangeWithUnits<>(resolved1, List1RealOwnedUnits_FieldType.class, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1RealOwnedUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1RealOwnedUnits = list1RealOwnedUnits_local;

				\t\tOptional<List<RealRangeWithUnits<Time>>> list1RealSameFileUnits_local;
				\t\ttry {
				\t\t\tlist1RealSameFileUnits_local = findFieldValue(recordValue, LIST_1_REAL_SAME_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new RealRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1RealSameFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1RealSameFileUnits = list1RealSameFileUnits_local;

				\t\tOptional<List<RealRangeWithUnits<Mass>>> list1RealOtherFileUnits_local;
				\t\ttry {
				\t\t\tlist1RealOtherFileUnits_local = findFieldValue(recordValue, LIST_1_REAL_OTHER_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new RealRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1RealOtherFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1RealOtherFileUnits = list1RealOtherFileUnits_local;
				\t}

				\tpublic RecordProperty(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<IntegerRange> integerNoUnits_local;
				\t\ttry {
				\t\t\tintegerNoUnits_local = findFieldValue(recordValue, INTEGER_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new IntegerRange(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tintegerNoUnits_local = Optional.empty();
				\t\t}
				\t\tthis.integerNoUnits = integerNoUnits_local;

				\t\tOptional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> integerOwnedUnits_local;
				\t\ttry {
				\t\t\tintegerOwnedUnits_local = findFieldValue(recordValue, INTEGER_OWNED_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new IntegerRangeWithUnits<>(resolved, IntegerOwnedUnits_FieldType.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tintegerOwnedUnits_local = Optional.empty();
				\t\t}
				\t\tthis.integerOwnedUnits = integerOwnedUnits_local;

				\t\tOptional<IntegerRangeWithUnits<Time>> integerSameFileUnits_local;
				\t\ttry {
				\t\t\tintegerSameFileUnits_local = findFieldValue(recordValue, INTEGER_SAME_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new IntegerRangeWithUnits<>(resolved, Time.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tintegerSameFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.integerSameFileUnits = integerSameFileUnits_local;

				\t\tOptional<IntegerRangeWithUnits<Mass>> integerOtherFileUnits_local;
				\t\ttry {
				\t\t\tintegerOtherFileUnits_local = findFieldValue(recordValue, INTEGER_OTHER_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new IntegerRangeWithUnits<>(resolved, Mass.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tintegerOtherFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.integerOtherFileUnits = integerOtherFileUnits_local;

				\t\tOptional<List<IntegerRange>> list1IntegerNoUnits_local;
				\t\ttry {
				\t\t\tlist1IntegerNoUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new IntegerRange(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1IntegerNoUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1IntegerNoUnits = list1IntegerNoUnits_local;

				\t\tOptional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> list1IntegerOwnedUnits_local;
				\t\ttry {
				\t\t\tlist1IntegerOwnedUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_OWNED_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new IntegerRangeWithUnits<>(resolved1, List1IntegerOwnedUnits_FieldType.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1IntegerOwnedUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1IntegerOwnedUnits = list1IntegerOwnedUnits_local;

				\t\tOptional<List<IntegerRangeWithUnits<Time>>> list1IntegerSameFileUnits_local;
				\t\ttry {
				\t\t\tlist1IntegerSameFileUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_SAME_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new IntegerRangeWithUnits<>(resolved1, Time.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1IntegerSameFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1IntegerSameFileUnits = list1IntegerSameFileUnits_local;

				\t\tOptional<List<IntegerRangeWithUnits<Mass>>> list1IntegerOtherFileUnits_local;
				\t\ttry {
				\t\t\tlist1IntegerOtherFileUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_OTHER_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new IntegerRangeWithUnits<>(resolved1, Mass.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1IntegerOtherFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1IntegerOtherFileUnits = list1IntegerOtherFileUnits_local;

				\t\tOptional<RealRange> realNoUnits_local;
				\t\ttry {
				\t\t\trealNoUnits_local = findFieldValue(recordValue, REAL_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new RealRange(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trealNoUnits_local = Optional.empty();
				\t\t}
				\t\tthis.realNoUnits = realNoUnits_local;

				\t\tOptional<RealRangeWithUnits<RealOwnedUnits_FieldType>> realOwnedUnits_local;
				\t\ttry {
				\t\t\trealOwnedUnits_local = findFieldValue(recordValue, REAL_OWNED_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new RealRangeWithUnits<>(resolved, RealOwnedUnits_FieldType.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trealOwnedUnits_local = Optional.empty();
				\t\t}
				\t\tthis.realOwnedUnits = realOwnedUnits_local;

				\t\tOptional<RealRangeWithUnits<Time>> realSameFileUnits_local;
				\t\ttry {
				\t\t\trealSameFileUnits_local = findFieldValue(recordValue, REAL_SAME_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new RealRangeWithUnits<>(resolved, Time.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trealSameFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.realSameFileUnits = realSameFileUnits_local;

				\t\tOptional<RealRangeWithUnits<Mass>> realOtherFileUnits_local;
				\t\ttry {
				\t\t\trealOtherFileUnits_local = findFieldValue(recordValue, REAL_OTHER_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new RealRangeWithUnits<>(resolved, Mass.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trealOtherFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.realOtherFileUnits = realOtherFileUnits_local;

				\t\tOptional<List<RealRange>> list1RealNoUnits_local;
				\t\ttry {
				\t\t\tlist1RealNoUnits_local = findFieldValue(recordValue, LIST_1_REAL_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new RealRange(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1RealNoUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1RealNoUnits = list1RealNoUnits_local;

				\t\tOptional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> list1RealOwnedUnits_local;
				\t\ttry {
				\t\t\tlist1RealOwnedUnits_local = findFieldValue(recordValue, LIST_1_REAL_OWNED_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new RealRangeWithUnits<>(resolved1, List1RealOwnedUnits_FieldType.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1RealOwnedUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1RealOwnedUnits = list1RealOwnedUnits_local;

				\t\tOptional<List<RealRangeWithUnits<Time>>> list1RealSameFileUnits_local;
				\t\ttry {
				\t\t\tlist1RealSameFileUnits_local = findFieldValue(recordValue, LIST_1_REAL_SAME_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new RealRangeWithUnits<>(resolved1, Time.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1RealSameFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1RealSameFileUnits = list1RealSameFileUnits_local;

				\t\tOptional<List<RealRangeWithUnits<Mass>>> list1RealOtherFileUnits_local;
				\t\ttry {
				\t\t\tlist1RealOtherFileUnits_local = findFieldValue(recordValue, LIST_1_REAL_OTHER_FILE_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new RealRangeWithUnits<>(resolved1, Mass.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1RealOtherFileUnits_local = Optional.empty();
				\t\t}
				\t\tthis.list1RealOtherFileUnits = list1RealOtherFileUnits_local;
				\t}

				\tpublic Optional<IntegerRange> getIntegerNoUnits() {
				\t\treturn integerNoUnits;
				\t}

				\tpublic Optional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> getIntegerOwnedUnits() {
				\t\treturn integerOwnedUnits;
				\t}

				\tpublic Optional<IntegerRangeWithUnits<Time>> getIntegerSameFileUnits() {
				\t\treturn integerSameFileUnits;
				\t}

				\tpublic Optional<IntegerRangeWithUnits<Mass>> getIntegerOtherFileUnits() {
				\t\treturn integerOtherFileUnits;
				\t}

				\tpublic Optional<List<IntegerRange>> getList1IntegerNoUnits() {
				\t\treturn list1IntegerNoUnits;
				\t}

				\tpublic Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> getList1IntegerOwnedUnits() {
				\t\treturn list1IntegerOwnedUnits;
				\t}

				\tpublic Optional<List<IntegerRangeWithUnits<Time>>> getList1IntegerSameFileUnits() {
				\t\treturn list1IntegerSameFileUnits;
				\t}

				\tpublic Optional<List<IntegerRangeWithUnits<Mass>>> getList1IntegerOtherFileUnits() {
				\t\treturn list1IntegerOtherFileUnits;
				\t}

				\tpublic Optional<RealRange> getRealNoUnits() {
				\t\treturn realNoUnits;
				\t}

				\tpublic Optional<RealRangeWithUnits<RealOwnedUnits_FieldType>> getRealOwnedUnits() {
				\t\treturn realOwnedUnits;
				\t}

				\tpublic Optional<RealRangeWithUnits<Time>> getRealSameFileUnits() {
				\t\treturn realSameFileUnits;
				\t}

				\tpublic Optional<RealRangeWithUnits<Mass>> getRealOtherFileUnits() {
				\t\treturn realOtherFileUnits;
				\t}

				\tpublic Optional<List<RealRange>> getList1RealNoUnits() {
				\t\treturn list1RealNoUnits;
				\t}

				\tpublic Optional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> getList1RealOwnedUnits() {
				\t\treturn list1RealOwnedUnits;
				\t}

				\tpublic Optional<List<RealRangeWithUnits<Time>>> getList1RealSameFileUnits() {
				\t\treturn list1RealSameFileUnits;
				\t}

				\tpublic Optional<List<RealRangeWithUnits<Mass>>> getList1RealOtherFileUnits() {
				\t\treturn list1RealOtherFileUnits;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (integerNoUnits.isEmpty()
				\t\t\t\t&& integerOwnedUnits.isEmpty()
				\t\t\t\t&& integerSameFileUnits.isEmpty()
				\t\t\t\t&& integerOtherFileUnits.isEmpty()
				\t\t\t\t&& list1IntegerNoUnits.isEmpty()
				\t\t\t\t&& list1IntegerOwnedUnits.isEmpty()
				\t\t\t\t&& list1IntegerSameFileUnits.isEmpty()
				\t\t\t\t&& list1IntegerOtherFileUnits.isEmpty()
				\t\t\t\t&& realNoUnits.isEmpty()
				\t\t\t\t&& realOwnedUnits.isEmpty()
				\t\t\t\t&& realSameFileUnits.isEmpty()
				\t\t\t\t&& realOtherFileUnits.isEmpty()
				\t\t\t\t&& list1RealNoUnits.isEmpty()
				\t\t\t\t&& list1RealOwnedUnits.isEmpty()
				\t\t\t\t&& list1RealSameFileUnits.isEmpty()
				\t\t\t\t&& list1RealOtherFileUnits.isEmpty()
				\t\t) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\tintegerNoUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, INTEGER_NO_UNITS__URI, INTEGER_NO_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression());
				\t\t});
				\t\tintegerOwnedUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, INTEGER_OWNED_UNITS__URI, INTEGER_OWNED_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\tintegerSameFileUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, INTEGER_SAME_FILE_UNITS__URI, INTEGER_SAME_FILE_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\tintegerOtherFileUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, INTEGER_OTHER_FILE_UNITS__URI, INTEGER_OTHER_FILE_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\tlist1IntegerNoUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_1_INTEGER_NO_UNITS__URI, LIST_1_INTEGER_NO_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression()));
				\t\t});
				\t\tlist1IntegerOwnedUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_1_INTEGER_OWNED_UNITS__URI, LIST_1_INTEGER_OWNED_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\tlist1IntegerSameFileUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_1_INTEGER_SAME_FILE_UNITS__URI, LIST_1_INTEGER_SAME_FILE_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\tlist1IntegerOtherFileUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_1_INTEGER_OTHER_FILE_UNITS__URI, LIST_1_INTEGER_OTHER_FILE_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\trealNoUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REAL_NO_UNITS__URI, REAL_NO_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression());
				\t\t});
				\t\trealOwnedUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REAL_OWNED_UNITS__URI, REAL_OWNED_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\trealSameFileUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REAL_SAME_FILE_UNITS__URI, REAL_SAME_FILE_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\trealOtherFileUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REAL_OTHER_FILE_UNITS__URI, REAL_OTHER_FILE_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\tlist1RealNoUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_1_REAL_NO_UNITS__URI, LIST_1_REAL_NO_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression()));
				\t\t});
				\t\tlist1RealOwnedUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_1_REAL_OWNED_UNITS__URI, LIST_1_REAL_OWNED_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\tlist1RealSameFileUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_1_REAL_SAME_FILE_UNITS__URI, LIST_1_REAL_SAME_FILE_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\tlist1RealOtherFileUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_1_REAL_OTHER_FILE_UNITS__URI, LIST_1_REAL_OTHER_FILE_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(
				\t\t\t\tintegerNoUnits,
				\t\t\t\tintegerOwnedUnits,
				\t\t\t\tintegerSameFileUnits,
				\t\t\t\tintegerOtherFileUnits,
				\t\t\t\tlist1IntegerNoUnits,
				\t\t\t\tlist1IntegerOwnedUnits,
				\t\t\t\tlist1IntegerSameFileUnits,
				\t\t\t\tlist1IntegerOtherFileUnits,
				\t\t\t\trealNoUnits,
				\t\t\t\trealOwnedUnits,
				\t\t\t\trealSameFileUnits,
				\t\t\t\trealOtherFileUnits,
				\t\t\t\tlist1RealNoUnits,
				\t\t\t\tlist1RealOwnedUnits,
				\t\t\t\tlist1RealSameFileUnits,
				\t\t\t\tlist1RealOtherFileUnits
				\t\t);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordProperty other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.integerNoUnits, other.integerNoUnits)
				\t\t\t\t&& Objects.equals(this.integerOwnedUnits, other.integerOwnedUnits)
				\t\t\t\t&& Objects.equals(this.integerSameFileUnits, other.integerSameFileUnits)
				\t\t\t\t&& Objects.equals(this.integerOtherFileUnits, other.integerOtherFileUnits)
				\t\t\t\t&& Objects.equals(this.list1IntegerNoUnits, other.list1IntegerNoUnits)
				\t\t\t\t&& Objects.equals(this.list1IntegerOwnedUnits, other.list1IntegerOwnedUnits)
				\t\t\t\t&& Objects.equals(this.list1IntegerSameFileUnits, other.list1IntegerSameFileUnits)
				\t\t\t\t&& Objects.equals(this.list1IntegerOtherFileUnits, other.list1IntegerOtherFileUnits)
				\t\t\t\t&& Objects.equals(this.realNoUnits, other.realNoUnits)
				\t\t\t\t&& Objects.equals(this.realOwnedUnits, other.realOwnedUnits)
				\t\t\t\t&& Objects.equals(this.realSameFileUnits, other.realSameFileUnits)
				\t\t\t\t&& Objects.equals(this.realOtherFileUnits, other.realOtherFileUnits)
				\t\t\t\t&& Objects.equals(this.list1RealNoUnits, other.list1RealNoUnits)
				\t\t\t\t&& Objects.equals(this.list1RealOwnedUnits, other.list1RealOwnedUnits)
				\t\t\t\t&& Objects.equals(this.list1RealSameFileUnits, other.list1RealSameFileUnits)
				\t\t\t\t&& Objects.equals(this.list1RealOtherFileUnits, other.list1RealOtherFileUnits);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.integerNoUnits.ifPresent(field -> {
				\t\t\tbuilder.append(INTEGER_NO_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.integerOwnedUnits.ifPresent(field -> {
				\t\t\tbuilder.append(INTEGER_OWNED_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.integerSameFileUnits.ifPresent(field -> {
				\t\t\tbuilder.append(INTEGER_SAME_FILE_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.integerOtherFileUnits.ifPresent(field -> {
				\t\t\tbuilder.append(INTEGER_OTHER_FILE_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.list1IntegerNoUnits.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_1_INTEGER_NO_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.list1IntegerOwnedUnits.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_1_INTEGER_OWNED_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.list1IntegerSameFileUnits.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_1_INTEGER_SAME_FILE_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.list1IntegerOtherFileUnits.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_1_INTEGER_OTHER_FILE_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.realNoUnits.ifPresent(field -> {
				\t\t\tbuilder.append(REAL_NO_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.realOwnedUnits.ifPresent(field -> {
				\t\t\tbuilder.append(REAL_OWNED_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.realSameFileUnits.ifPresent(field -> {
				\t\t\tbuilder.append(REAL_SAME_FILE_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.realOtherFileUnits.ifPresent(field -> {
				\t\t\tbuilder.append(REAL_OTHER_FILE_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.list1RealNoUnits.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_1_REAL_NO_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.list1RealOwnedUnits.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_1_REAL_OWNED_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.list1RealSameFileUnits.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_1_REAL_SAME_FILE_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.list1RealOtherFileUnits.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_1_REAL_OTHER_FILE_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}

				\tpublic enum IntegerOwnedUnits_FieldType implements GeneratedUnits<IntegerOwnedUnits_FieldType> {
				\t\tCM(1.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\t\tM(100.0, "m", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");

				\t\tprivate final double factorToBase;
				\t\tprivate final String originalName;
				\t\tprivate final URI uri;

				\t\tprivate IntegerOwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
				\t\t\tthis.factorToBase = factorToBase;
				\t\t\tthis.originalName = originalName;
				\t\t\tthis.uri = URI.createURI(uri);
				\t\t}

				\t\tpublic static IntegerOwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
				\t\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorToBase() {
				\t\t\treturn factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorTo(IntegerOwnedUnits_FieldType target) {
				\t\t\treturn factorToBase / target.factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic URI getURI() {
				\t\t\treturn uri;
				\t\t}

				\t\t@Override
				\t\tpublic String toString() {
				\t\t\treturn originalName;
				\t\t}
				\t}

				\tpublic enum List1IntegerOwnedUnits_FieldType implements GeneratedUnits<List1IntegerOwnedUnits_FieldType> {
				\t\tM(1.0, "m", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\t\tKM(1000.0, "km", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");

				\t\tprivate final double factorToBase;
				\t\tprivate final String originalName;
				\t\tprivate final URI uri;

				\t\tprivate List1IntegerOwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
				\t\t\tthis.factorToBase = factorToBase;
				\t\t\tthis.originalName = originalName;
				\t\t\tthis.uri = URI.createURI(uri);
				\t\t}

				\t\tpublic static List1IntegerOwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
				\t\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorToBase() {
				\t\t\treturn factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorTo(List1IntegerOwnedUnits_FieldType target) {
				\t\t\treturn factorToBase / target.factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic URI getURI() {
				\t\t\treturn uri;
				\t\t}

				\t\t@Override
				\t\tpublic String toString() {
				\t\t\treturn originalName;
				\t\t}
				\t}

				\tpublic enum RealOwnedUnits_FieldType implements GeneratedUnits<RealOwnedUnits_FieldType> {
				\t\tMM(1.0, "mm", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\t\tCM(10.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");

				\t\tprivate final double factorToBase;
				\t\tprivate final String originalName;
				\t\tprivate final URI uri;

				\t\tprivate RealOwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
				\t\t\tthis.factorToBase = factorToBase;
				\t\t\tthis.originalName = originalName;
				\t\t\tthis.uri = URI.createURI(uri);
				\t\t}

				\t\tpublic static RealOwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
				\t\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorToBase() {
				\t\t\treturn factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorTo(RealOwnedUnits_FieldType target) {
				\t\t\treturn factorToBase / target.factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic URI getURI() {
				\t\t\treturn uri;
				\t\t}

				\t\t@Override
				\t\tpublic String toString() {
				\t\t\treturn originalName;
				\t\t}
				\t}

				\tpublic enum List1RealOwnedUnits_FieldType implements GeneratedUnits<List1RealOwnedUnits_FieldType> {
				\t\tMG(1.0, "mg", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\t\tCG(10.0, "cg", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");

				\t\tprivate final double factorToBase;
				\t\tprivate final String originalName;
				\t\tprivate final URI uri;

				\t\tprivate List1RealOwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
				\t\t\tthis.factorToBase = factorToBase;
				\t\t\tthis.originalName = originalName;
				\t\t\tthis.uri = URI.createURI(uri);
				\t\t}

				\t\tpublic static List1RealOwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
				\t\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorToBase() {
				\t\t\treturn factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorTo(List1RealOwnedUnits_FieldType target) {
				\t\t\treturn factorToBase / target.factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic URI getURI() {
				\t\t\treturn uri;
				\t\t}

				\t\t@Override
				\t\tpublic String toString() {
				\t\t\treturn originalName;
				\t\t}
				\t}
				}
				""";
		var integerOwnedUnitsConstant = """
				package rangetest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum IntegerOwnedUnitsConstant implements GeneratedUnits<IntegerOwnedUnitsConstant> {
				\tCM(1.0, "cm", "__synthetic1.aadl#/0/@ownedPropertyConstant.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\tM(100.0, "m", "__synthetic1.aadl#/0/@ownedPropertyConstant.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate IntegerOwnedUnitsConstant(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static IntegerOwnedUnitsConstant valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(IntegerOwnedUnitsConstant target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var list1IntegerOwnedUnitsConstant = """
				package rangetest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum List1IntegerOwnedUnitsConstant implements GeneratedUnits<List1IntegerOwnedUnitsConstant> {
				\tM(1.0, "m", "__synthetic1.aadl#/0/@ownedPropertyConstant.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\tKM(1000.0, "km", "__synthetic1.aadl#/0/@ownedPropertyConstant.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate List1IntegerOwnedUnitsConstant(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static List1IntegerOwnedUnitsConstant valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(List1IntegerOwnedUnitsConstant target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var realOwnedUnitsConstant = """
				package rangetest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum RealOwnedUnitsConstant implements GeneratedUnits<RealOwnedUnitsConstant> {
				\tMM(1.0, "mm", "__synthetic1.aadl#/0/@ownedPropertyConstant.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\tCM(10.0, "cm", "__synthetic1.aadl#/0/@ownedPropertyConstant.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate RealOwnedUnitsConstant(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static RealOwnedUnitsConstant valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(RealOwnedUnitsConstant target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var list1RealOwnedUnitsConstant = """
				package rangetest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum List1RealOwnedUnitsConstant implements GeneratedUnits<List1RealOwnedUnitsConstant> {
				\tMG(1.0, "mg", "__synthetic1.aadl#/0/@ownedPropertyConstant.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\tCG(10.0, "cg", "__synthetic1.aadl#/0/@ownedPropertyConstant.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate List1RealOwnedUnitsConstant(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static List1RealOwnedUnitsConstant valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(List1RealOwnedUnitsConstant target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(rangeTest, otherPs));
		assertEquals("src-gen/rangetest", results.getPackagePath());
		assertEquals(11, results.getClasses().size());

		assertEquals("RangeTest.java", results.getClasses().get(0).getFileName());
		assertEquals(rangeTestClass, results.getClasses().get(0).getContents());

		assertEquals("Time.java", results.getClasses().get(1).getFileName());
		assertEquals(time, results.getClasses().get(1).getContents());

		assertEquals("IntegerOwnedUnits.java", results.getClasses().get(2).getFileName());
		assertEquals(integerOwnedUnits, results.getClasses().get(2).getContents());

		assertEquals("List1IntegerOwnedUnits.java", results.getClasses().get(3).getFileName());
		assertEquals(list1IntegerOwnedUnits, results.getClasses().get(3).getContents());

		assertEquals("RealOwnedUnits.java", results.getClasses().get(4).getFileName());
		assertEquals(realOwnedUnits, results.getClasses().get(4).getContents());

		assertEquals("List1RealOwnedUnits.java", results.getClasses().get(5).getFileName());
		assertEquals(list1RealOwnedUnits, results.getClasses().get(5).getContents());

		assertEquals("RecordProperty.java", results.getClasses().get(6).getFileName());
		assertEquals(recordProperty, results.getClasses().get(6).getContents());

		assertEquals("IntegerOwnedUnitsConstant.java", results.getClasses().get(7).getFileName());
		assertEquals(integerOwnedUnitsConstant, results.getClasses().get(7).getContents());

		assertEquals("List1IntegerOwnedUnitsConstant.java", results.getClasses().get(8).getFileName());
		assertEquals(list1IntegerOwnedUnitsConstant, results.getClasses().get(8).getContents());

		assertEquals("RealOwnedUnitsConstant.java", results.getClasses().get(9).getFileName());
		assertEquals(realOwnedUnitsConstant, results.getClasses().get(9).getContents());

		assertEquals("List1RealOwnedUnitsConstant.java", results.getClasses().get(10).getFileName());
		assertEquals(list1RealOwnedUnitsConstant, results.getClasses().get(10).getContents());
	}
}
