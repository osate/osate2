/*******************************************************************************
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.propertiescodegen.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.PropertySet
import org.osate.propertiescodegen.PropertiesCodeGen
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class RangeTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testRange() {
		val otherPs = '''
			property set other_ps is
				mass: type units (g, kg => g * 1000);
			end other_ps;
		'''
		val rangeTest = '''
			property set range_test is
				with other_ps;
				
				time: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				
				integer_no_units: range of aadlinteger applies to (all);
				integer_owned_units: range of aadlinteger units (cm, m => cm * 100) applies to (all);
				integer_same_file_units: range of aadlinteger units range_test::time applies to (all);
				integer_other_file_units: range of aadlinteger units other_ps::mass applies to (all);
				
				list_1_integer_no_units: list of range of aadlinteger applies to (all);
				list_1_integer_owned_units: list of range of aadlinteger units (m, km => m * 1000) applies to (all);
				list_1_integer_same_file_units: list of range of aadlinteger units range_test::time applies to (all);
				list_1_integer_other_file_units: list of range of aadlinteger units other_ps::mass applies to (all);
				
				real_no_units: range of aadlreal applies to (all);
				real_owned_units: range of aadlreal units (mm, cm => mm * 10) applies to (all);
				real_same_file_units: range of aadlreal units range_test::time applies to (all);
				real_other_file_units: range of aadlreal units other_ps::mass applies to (all);
				
				list_1_real_no_units: list of range of aadlreal applies to (all);
				list_1_real_owned_units: list of range of aadlreal units (mg, cg => mg * 10) applies to (all);
				list_1_real_same_file_units: list of range of aadlreal units range_test::time applies to (all);
				list_1_real_other_file_units: list of range of aadlreal units other_ps::mass applies to (all);
				
				record_property: record (
					integer_no_units: range of aadlinteger;
					integer_owned_units: range of aadlinteger units (cm, m => cm * 100);
					integer_same_file_units: range of aadlinteger units range_test::time;
					integer_other_file_units: range of aadlinteger units other_ps::mass;
					
					list_1_integer_no_units: list of range of aadlinteger;
					list_1_integer_owned_units: list of range of aadlinteger units (m, km => m * 1000);
					list_1_integer_same_file_units: list of range of aadlinteger units range_test::time;
					list_1_integer_other_file_units: list of range of aadlinteger units other_ps::mass;
					
					real_no_units: range of aadlreal;
					real_owned_units: range of aadlreal units (mm, cm => mm * 10);
					real_same_file_units: range of aadlreal units range_test::time;
					real_other_file_units: range of aadlreal units other_ps::mass;
					
					list_1_real_no_units: list of range of aadlreal;
					list_1_real_owned_units: list of range of aadlreal units (mg, cg => mg * 10);
					list_1_real_same_file_units: list of range of aadlreal units range_test::time;
					list_1_real_other_file_units: list of range of aadlreal units other_ps::mass;
				) applies to (all);
				
				integer_no_units_constant: constant range of aadlinteger => 1 .. 2;
				integer_owned_units_constant: constant range of aadlinteger units (cm, m => cm * 100) => 3 cm .. 4 m;
				integer_same_file_units_constant: constant range of aadlinteger units range_test::time => 5 sec .. 6 min;
				integer_other_file_units_constant: constant range of aadlinteger units other_ps::mass => 7 g .. 8 kg;
				
				list_1_integer_no_units_constant: constant list of range of aadlinteger => (9 .. 10, 11 .. 12);
				list_1_integer_owned_units_constant: constant list of range of aadlinteger units (m, km => m * 1000) => (13 m .. 14 km, 15 m .. 16 km);
				list_1_integer_same_file_units_constant: constant list of range of aadlinteger units range_test::time => (17 sec .. 18 min, 19 hr .. 20 day);
				list_1_integer_other_file_units_constant: constant list of range of aadlinteger units other_ps::mass => (21 g .. 22 kg, 23 g .. 24 kg);
				
				real_no_units_constant: constant range of aadlreal => 25.25 .. 26.26;
				real_owned_units_constant: constant range of aadlreal units (mm, cm => mm * 10) => 27.27 mm .. 28.28 cm;
				real_same_file_units_constant: constant range of aadlreal units range_test::time => 29.29 sec .. 30.0 min;
				real_other_file_units_constant: constant range of aadlreal units other_ps::mass => 31.31 g .. 32.32 kg;
				
				list_1_real_no_units_constant: constant list of range of aadlreal => (33.33 .. 34.34, 35.35 .. 36.36);
				list_1_real_owned_units_constant: constant list of range of aadlreal units (mg, cg => mg * 10) => (37.37 mg .. 38.38 cg, 39.39 mg .. 40.0 cg);
				list_1_real_same_file_units_constant: constant list of range of aadlreal units range_test::time => (41.41 sec .. 42.42 min, 43.43 hr .. 44.44 day);
				list_1_real_other_file_units_constant: constant list of range of aadlreal units other_ps::mass => (45.45 g .. 46.46 kg, 47.47 g .. 48.48 kg);
			end range_test;
		'''
		val rangeTestClass = '''
			package rangetest;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
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
				public static final String RANGE_TEST__NAME = "range_test";
				
				private RangeTest() {}
				
				// Lookup methods for range_test::integer_no_units
				
				public static final String INTEGER_NO_UNITS__NAME = "integer_no_units";
				
				public static boolean acceptsIntegerNoUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getIntegerNoUnits_Property(lookupContext));
				}
				
				public static Optional<IntegerRange> getIntegerNoUnits(NamedElement lookupContext) {
					return getIntegerNoUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerRange> getIntegerNoUnits(NamedElement lookupContext, Mode mode) {
					return getIntegerNoUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerRange> getIntegerNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getIntegerNoUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerRange(resolved, lookupContext, mode));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getIntegerNoUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + INTEGER_NO_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getIntegerNoUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getIntegerNoUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::integer_owned_units
				
				public static final String INTEGER_OWNED_UNITS__NAME = "integer_owned_units";
				
				public static boolean acceptsIntegerOwnedUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getIntegerOwnedUnits_Property(lookupContext));
				}
				
				public static Optional<IntegerRangeWithUnits<IntegerOwnedUnits>> getIntegerOwnedUnits(NamedElement lookupContext) {
					return getIntegerOwnedUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerRangeWithUnits<IntegerOwnedUnits>> getIntegerOwnedUnits(NamedElement lookupContext, Mode mode) {
					return getIntegerOwnedUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerRangeWithUnits<IntegerOwnedUnits>> getIntegerOwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getIntegerOwnedUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerRangeWithUnits<>(resolved, IntegerOwnedUnits.class, lookupContext, mode));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getIntegerOwnedUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + INTEGER_OWNED_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getIntegerOwnedUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getIntegerOwnedUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::integer_same_file_units
				
				public static final String INTEGER_SAME_FILE_UNITS__NAME = "integer_same_file_units";
				
				public static boolean acceptsIntegerSameFileUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getIntegerSameFileUnits_Property(lookupContext));
				}
				
				public static Optional<IntegerRangeWithUnits<Time>> getIntegerSameFileUnits(NamedElement lookupContext) {
					return getIntegerSameFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerRangeWithUnits<Time>> getIntegerSameFileUnits(NamedElement lookupContext, Mode mode) {
					return getIntegerSameFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerRangeWithUnits<Time>> getIntegerSameFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getIntegerSameFileUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerRangeWithUnits<>(resolved, Time.class, lookupContext, mode));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getIntegerSameFileUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + INTEGER_SAME_FILE_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getIntegerSameFileUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getIntegerSameFileUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::integer_other_file_units
				
				public static final String INTEGER_OTHER_FILE_UNITS__NAME = "integer_other_file_units";
				
				public static boolean acceptsIntegerOtherFileUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getIntegerOtherFileUnits_Property(lookupContext));
				}
				
				public static Optional<IntegerRangeWithUnits<Mass>> getIntegerOtherFileUnits(NamedElement lookupContext) {
					return getIntegerOtherFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerRangeWithUnits<Mass>> getIntegerOtherFileUnits(NamedElement lookupContext, Mode mode) {
					return getIntegerOtherFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerRangeWithUnits<Mass>> getIntegerOtherFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getIntegerOtherFileUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerRangeWithUnits<>(resolved, Mass.class, lookupContext, mode));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getIntegerOtherFileUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + INTEGER_OTHER_FILE_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getIntegerOtherFileUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getIntegerOtherFileUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::list_1_integer_no_units
				
				public static final String LIST_1_INTEGER_NO_UNITS__NAME = "list_1_integer_no_units";
				
				public static boolean acceptsList1IntegerNoUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1IntegerNoUnits_Property(lookupContext));
				}
				
				public static Optional<List<IntegerRange>> getList1IntegerNoUnits(NamedElement lookupContext) {
					return getList1IntegerNoUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerRange>> getList1IntegerNoUnits(NamedElement lookupContext, Mode mode) {
					return getList1IntegerNoUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerRange>> getList1IntegerNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1IntegerNoUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerRange(resolved1, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1IntegerNoUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_NO_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1IntegerNoUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1IntegerNoUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::list_1_integer_owned_units
				
				public static final String LIST_1_INTEGER_OWNED_UNITS__NAME = "list_1_integer_owned_units";
				
				public static boolean acceptsList1IntegerOwnedUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1IntegerOwnedUnits_Property(lookupContext));
				}
				
				public static Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits>>> getList1IntegerOwnedUnits(NamedElement lookupContext) {
					return getList1IntegerOwnedUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits>>> getList1IntegerOwnedUnits(NamedElement lookupContext, Mode mode) {
					return getList1IntegerOwnedUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits>>> getList1IntegerOwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1IntegerOwnedUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerRangeWithUnits<>(resolved1, List1IntegerOwnedUnits.class, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1IntegerOwnedUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_OWNED_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1IntegerOwnedUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1IntegerOwnedUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::list_1_integer_same_file_units
				
				public static final String LIST_1_INTEGER_SAME_FILE_UNITS__NAME = "list_1_integer_same_file_units";
				
				public static boolean acceptsList1IntegerSameFileUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1IntegerSameFileUnits_Property(lookupContext));
				}
				
				public static Optional<List<IntegerRangeWithUnits<Time>>> getList1IntegerSameFileUnits(NamedElement lookupContext) {
					return getList1IntegerSameFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerRangeWithUnits<Time>>> getList1IntegerSameFileUnits(NamedElement lookupContext, Mode mode) {
					return getList1IntegerSameFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerRangeWithUnits<Time>>> getList1IntegerSameFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1IntegerSameFileUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1IntegerSameFileUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_SAME_FILE_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1IntegerSameFileUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1IntegerSameFileUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::list_1_integer_other_file_units
				
				public static final String LIST_1_INTEGER_OTHER_FILE_UNITS__NAME = "list_1_integer_other_file_units";
				
				public static boolean acceptsList1IntegerOtherFileUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1IntegerOtherFileUnits_Property(lookupContext));
				}
				
				public static Optional<List<IntegerRangeWithUnits<Mass>>> getList1IntegerOtherFileUnits(NamedElement lookupContext) {
					return getList1IntegerOtherFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerRangeWithUnits<Mass>>> getList1IntegerOtherFileUnits(NamedElement lookupContext, Mode mode) {
					return getList1IntegerOtherFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerRangeWithUnits<Mass>>> getList1IntegerOtherFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1IntegerOtherFileUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1IntegerOtherFileUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_OTHER_FILE_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1IntegerOtherFileUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1IntegerOtherFileUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::real_no_units
				
				public static final String REAL_NO_UNITS__NAME = "real_no_units";
				
				public static boolean acceptsRealNoUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getRealNoUnits_Property(lookupContext));
				}
				
				public static Optional<RealRange> getRealNoUnits(NamedElement lookupContext) {
					return getRealNoUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<RealRange> getRealNoUnits(NamedElement lookupContext, Mode mode) {
					return getRealNoUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RealRange> getRealNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getRealNoUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RealRange(resolved, lookupContext, mode));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getRealNoUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + REAL_NO_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getRealNoUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getRealNoUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::real_owned_units
				
				public static final String REAL_OWNED_UNITS__NAME = "real_owned_units";
				
				public static boolean acceptsRealOwnedUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getRealOwnedUnits_Property(lookupContext));
				}
				
				public static Optional<RealRangeWithUnits<RealOwnedUnits>> getRealOwnedUnits(NamedElement lookupContext) {
					return getRealOwnedUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<RealRangeWithUnits<RealOwnedUnits>> getRealOwnedUnits(NamedElement lookupContext, Mode mode) {
					return getRealOwnedUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RealRangeWithUnits<RealOwnedUnits>> getRealOwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getRealOwnedUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RealRangeWithUnits<>(resolved, RealOwnedUnits.class, lookupContext, mode));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getRealOwnedUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + REAL_OWNED_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getRealOwnedUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getRealOwnedUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::real_same_file_units
				
				public static final String REAL_SAME_FILE_UNITS__NAME = "real_same_file_units";
				
				public static boolean acceptsRealSameFileUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getRealSameFileUnits_Property(lookupContext));
				}
				
				public static Optional<RealRangeWithUnits<Time>> getRealSameFileUnits(NamedElement lookupContext) {
					return getRealSameFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<RealRangeWithUnits<Time>> getRealSameFileUnits(NamedElement lookupContext, Mode mode) {
					return getRealSameFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RealRangeWithUnits<Time>> getRealSameFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getRealSameFileUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RealRangeWithUnits<>(resolved, Time.class, lookupContext, mode));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getRealSameFileUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + REAL_SAME_FILE_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getRealSameFileUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getRealSameFileUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::real_other_file_units
				
				public static final String REAL_OTHER_FILE_UNITS__NAME = "real_other_file_units";
				
				public static boolean acceptsRealOtherFileUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getRealOtherFileUnits_Property(lookupContext));
				}
				
				public static Optional<RealRangeWithUnits<Mass>> getRealOtherFileUnits(NamedElement lookupContext) {
					return getRealOtherFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<RealRangeWithUnits<Mass>> getRealOtherFileUnits(NamedElement lookupContext, Mode mode) {
					return getRealOtherFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RealRangeWithUnits<Mass>> getRealOtherFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getRealOtherFileUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RealRangeWithUnits<>(resolved, Mass.class, lookupContext, mode));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getRealOtherFileUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + REAL_OTHER_FILE_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getRealOtherFileUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getRealOtherFileUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::list_1_real_no_units
				
				public static final String LIST_1_REAL_NO_UNITS__NAME = "list_1_real_no_units";
				
				public static boolean acceptsList1RealNoUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1RealNoUnits_Property(lookupContext));
				}
				
				public static Optional<List<RealRange>> getList1RealNoUnits(NamedElement lookupContext) {
					return getList1RealNoUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RealRange>> getList1RealNoUnits(NamedElement lookupContext, Mode mode) {
					return getList1RealNoUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RealRange>> getList1RealNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1RealNoUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RealRange(resolved1, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1RealNoUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_REAL_NO_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1RealNoUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1RealNoUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::list_1_real_owned_units
				
				public static final String LIST_1_REAL_OWNED_UNITS__NAME = "list_1_real_owned_units";
				
				public static boolean acceptsList1RealOwnedUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1RealOwnedUnits_Property(lookupContext));
				}
				
				public static Optional<List<RealRangeWithUnits<List1RealOwnedUnits>>> getList1RealOwnedUnits(NamedElement lookupContext) {
					return getList1RealOwnedUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RealRangeWithUnits<List1RealOwnedUnits>>> getList1RealOwnedUnits(NamedElement lookupContext, Mode mode) {
					return getList1RealOwnedUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RealRangeWithUnits<List1RealOwnedUnits>>> getList1RealOwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1RealOwnedUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RealRangeWithUnits<>(resolved1, List1RealOwnedUnits.class, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1RealOwnedUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_REAL_OWNED_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1RealOwnedUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1RealOwnedUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::list_1_real_same_file_units
				
				public static final String LIST_1_REAL_SAME_FILE_UNITS__NAME = "list_1_real_same_file_units";
				
				public static boolean acceptsList1RealSameFileUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1RealSameFileUnits_Property(lookupContext));
				}
				
				public static Optional<List<RealRangeWithUnits<Time>>> getList1RealSameFileUnits(NamedElement lookupContext) {
					return getList1RealSameFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RealRangeWithUnits<Time>>> getList1RealSameFileUnits(NamedElement lookupContext, Mode mode) {
					return getList1RealSameFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RealRangeWithUnits<Time>>> getList1RealSameFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1RealSameFileUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RealRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1RealSameFileUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_REAL_SAME_FILE_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1RealSameFileUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1RealSameFileUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::list_1_real_other_file_units
				
				public static final String LIST_1_REAL_OTHER_FILE_UNITS__NAME = "list_1_real_other_file_units";
				
				public static boolean acceptsList1RealOtherFileUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1RealOtherFileUnits_Property(lookupContext));
				}
				
				public static Optional<List<RealRangeWithUnits<Mass>>> getList1RealOtherFileUnits(NamedElement lookupContext) {
					return getList1RealOtherFileUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RealRangeWithUnits<Mass>>> getList1RealOtherFileUnits(NamedElement lookupContext, Mode mode) {
					return getList1RealOtherFileUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RealRangeWithUnits<Mass>>> getList1RealOtherFileUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1RealOtherFileUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RealRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1RealOtherFileUnits_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_REAL_OTHER_FILE_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1RealOtherFileUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1RealOtherFileUnits_Property(lookupContext));
				}
				
				// Lookup methods for range_test::record_property
				
				public static final String RECORD_PROPERTY__NAME = "record_property";
				
				public static boolean acceptsRecordProperty(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getRecordProperty_Property(lookupContext));
				}
				
				public static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext) {
					return getRecordProperty(lookupContext, Optional.empty());
				}
				
				public static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext, Mode mode) {
					return getRecordProperty(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getRecordProperty_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RecordProperty(resolved, lookupContext, mode));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getRecordProperty_Property(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + RECORD_PROPERTY__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getRecordProperty_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getRecordProperty_Property(lookupContext));
				}
				
				// Lookup methods for range_test::integer_no_units_constant
				
				public static final String INTEGER_NO_UNITS_CONSTANT__NAME = "integer_no_units_constant";
				
				public static IntegerRange getIntegerNoUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getIntegerNoUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return new IntegerRange(resolved);
				}
				
				public static PropertyConstant getIntegerNoUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + INTEGER_NO_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::integer_owned_units_constant
				
				public static final String INTEGER_OWNED_UNITS_CONSTANT__NAME = "integer_owned_units_constant";
				
				public static IntegerRangeWithUnits<IntegerOwnedUnitsConstant> getIntegerOwnedUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getIntegerOwnedUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return new IntegerRangeWithUnits<>(resolved, IntegerOwnedUnitsConstant.class);
				}
				
				public static PropertyConstant getIntegerOwnedUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + INTEGER_OWNED_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::integer_same_file_units_constant
				
				public static final String INTEGER_SAME_FILE_UNITS_CONSTANT__NAME = "integer_same_file_units_constant";
				
				public static IntegerRangeWithUnits<Time> getIntegerSameFileUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getIntegerSameFileUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return new IntegerRangeWithUnits<>(resolved, Time.class);
				}
				
				public static PropertyConstant getIntegerSameFileUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + INTEGER_SAME_FILE_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::integer_other_file_units_constant
				
				public static final String INTEGER_OTHER_FILE_UNITS_CONSTANT__NAME = "integer_other_file_units_constant";
				
				public static IntegerRangeWithUnits<Mass> getIntegerOtherFileUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getIntegerOtherFileUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return new IntegerRangeWithUnits<>(resolved, Mass.class);
				}
				
				public static PropertyConstant getIntegerOtherFileUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + INTEGER_OTHER_FILE_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::list_1_integer_no_units_constant
				
				public static final String LIST_1_INTEGER_NO_UNITS_CONSTANT__NAME = "list_1_integer_no_units_constant";
				
				public static List<IntegerRange> getList1IntegerNoUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getList1IntegerNoUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return new IntegerRange(resolved1);
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1IntegerNoUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_NO_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::list_1_integer_owned_units_constant
				
				public static final String LIST_1_INTEGER_OWNED_UNITS_CONSTANT__NAME = "list_1_integer_owned_units_constant";
				
				public static List<IntegerRangeWithUnits<List1IntegerOwnedUnitsConstant>> getList1IntegerOwnedUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getList1IntegerOwnedUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return new IntegerRangeWithUnits<>(resolved1, List1IntegerOwnedUnitsConstant.class);
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1IntegerOwnedUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_OWNED_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::list_1_integer_same_file_units_constant
				
				public static final String LIST_1_INTEGER_SAME_FILE_UNITS_CONSTANT__NAME = "list_1_integer_same_file_units_constant";
				
				public static List<IntegerRangeWithUnits<Time>> getList1IntegerSameFileUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getList1IntegerSameFileUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return new IntegerRangeWithUnits<>(resolved1, Time.class);
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1IntegerSameFileUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_SAME_FILE_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::list_1_integer_other_file_units_constant
				
				public static final String LIST_1_INTEGER_OTHER_FILE_UNITS_CONSTANT__NAME = "list_1_integer_other_file_units_constant";
				
				public static List<IntegerRangeWithUnits<Mass>> getList1IntegerOtherFileUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getList1IntegerOtherFileUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return new IntegerRangeWithUnits<>(resolved1, Mass.class);
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1IntegerOtherFileUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_INTEGER_OTHER_FILE_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::real_no_units_constant
				
				public static final String REAL_NO_UNITS_CONSTANT__NAME = "real_no_units_constant";
				
				public static RealRange getRealNoUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getRealNoUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return new RealRange(resolved);
				}
				
				public static PropertyConstant getRealNoUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + REAL_NO_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::real_owned_units_constant
				
				public static final String REAL_OWNED_UNITS_CONSTANT__NAME = "real_owned_units_constant";
				
				public static RealRangeWithUnits<RealOwnedUnitsConstant> getRealOwnedUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getRealOwnedUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return new RealRangeWithUnits<>(resolved, RealOwnedUnitsConstant.class);
				}
				
				public static PropertyConstant getRealOwnedUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + REAL_OWNED_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::real_same_file_units_constant
				
				public static final String REAL_SAME_FILE_UNITS_CONSTANT__NAME = "real_same_file_units_constant";
				
				public static RealRangeWithUnits<Time> getRealSameFileUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getRealSameFileUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return new RealRangeWithUnits<>(resolved, Time.class);
				}
				
				public static PropertyConstant getRealSameFileUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + REAL_SAME_FILE_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::real_other_file_units_constant
				
				public static final String REAL_OTHER_FILE_UNITS_CONSTANT__NAME = "real_other_file_units_constant";
				
				public static RealRangeWithUnits<Mass> getRealOtherFileUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getRealOtherFileUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return new RealRangeWithUnits<>(resolved, Mass.class);
				}
				
				public static PropertyConstant getRealOtherFileUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + REAL_OTHER_FILE_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::list_1_real_no_units_constant
				
				public static final String LIST_1_REAL_NO_UNITS_CONSTANT__NAME = "list_1_real_no_units_constant";
				
				public static List<RealRange> getList1RealNoUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getList1RealNoUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return new RealRange(resolved1);
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1RealNoUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_REAL_NO_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::list_1_real_owned_units_constant
				
				public static final String LIST_1_REAL_OWNED_UNITS_CONSTANT__NAME = "list_1_real_owned_units_constant";
				
				public static List<RealRangeWithUnits<List1RealOwnedUnitsConstant>> getList1RealOwnedUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getList1RealOwnedUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return new RealRangeWithUnits<>(resolved1, List1RealOwnedUnitsConstant.class);
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1RealOwnedUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_REAL_OWNED_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::list_1_real_same_file_units_constant
				
				public static final String LIST_1_REAL_SAME_FILE_UNITS_CONSTANT__NAME = "list_1_real_same_file_units_constant";
				
				public static List<RealRangeWithUnits<Time>> getList1RealSameFileUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getList1RealSameFileUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return new RealRangeWithUnits<>(resolved1, Time.class);
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1RealSameFileUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_REAL_SAME_FILE_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for range_test::list_1_real_other_file_units_constant
				
				public static final String LIST_1_REAL_OTHER_FILE_UNITS_CONSTANT__NAME = "list_1_real_other_file_units_constant";
				
				public static List<RealRangeWithUnits<Mass>> getList1RealOtherFileUnitsConstant(EObject lookupContext) {
					PropertyConstant constant = getList1RealOtherFileUnitsConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return new RealRangeWithUnits<>(resolved1, Mass.class);
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1RealOtherFileUnitsConstant_PropertyConstant(EObject lookupContext) {
					String name = RANGE_TEST__NAME + "::" + LIST_1_REAL_OTHER_FILE_UNITS_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
			}
		'''
		val time = '''
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum Time implements GeneratedUnits<Time> {
				SEC(1.0, "sec", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				MIN(60.0, "min", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				HR(3600.0, "hr", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
				DAY(86400.0, "day", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private Time(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static Time valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(Time target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val integerOwnedUnits = '''
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum IntegerOwnedUnits implements GeneratedUnits<IntegerOwnedUnits> {
				CM(1.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				M(100.0, "m", "__synthetic1.aadl#/0/@ownedProperty.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private IntegerOwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static IntegerOwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(IntegerOwnedUnits target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val list1IntegerOwnedUnits = '''
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum List1IntegerOwnedUnits implements GeneratedUnits<List1IntegerOwnedUnits> {
				M(1.0, "m", "__synthetic1.aadl#/0/@ownedProperty.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				KM(1000.0, "km", "__synthetic1.aadl#/0/@ownedProperty.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private List1IntegerOwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static List1IntegerOwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(List1IntegerOwnedUnits target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val realOwnedUnits = '''
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum RealOwnedUnits implements GeneratedUnits<RealOwnedUnits> {
				MM(1.0, "mm", "__synthetic1.aadl#/0/@ownedProperty.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				CM(10.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private RealOwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static RealOwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(RealOwnedUnits target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val list1RealOwnedUnits = '''
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum List1RealOwnedUnits implements GeneratedUnits<List1RealOwnedUnits> {
				MG(1.0, "mg", "__synthetic1.aadl#/0/@ownedProperty.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				CG(10.0, "cg", "__synthetic1.aadl#/0/@ownedProperty.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private List1RealOwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static List1RealOwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(List1RealOwnedUnits target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val recordProperty = '''
			package rangetest;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.BasicPropertyAssociation;
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
				public static final String INTEGER_NO_UNITS__NAME = "integer_no_units";
				public static final String INTEGER_OWNED_UNITS__NAME = "integer_owned_units";
				public static final String INTEGER_SAME_FILE_UNITS__NAME = "integer_same_file_units";
				public static final String INTEGER_OTHER_FILE_UNITS__NAME = "integer_other_file_units";
				public static final String LIST_1_INTEGER_NO_UNITS__NAME = "list_1_integer_no_units";
				public static final String LIST_1_INTEGER_OWNED_UNITS__NAME = "list_1_integer_owned_units";
				public static final String LIST_1_INTEGER_SAME_FILE_UNITS__NAME = "list_1_integer_same_file_units";
				public static final String LIST_1_INTEGER_OTHER_FILE_UNITS__NAME = "list_1_integer_other_file_units";
				public static final String REAL_NO_UNITS__NAME = "real_no_units";
				public static final String REAL_OWNED_UNITS__NAME = "real_owned_units";
				public static final String REAL_SAME_FILE_UNITS__NAME = "real_same_file_units";
				public static final String REAL_OTHER_FILE_UNITS__NAME = "real_other_file_units";
				public static final String LIST_1_REAL_NO_UNITS__NAME = "list_1_real_no_units";
				public static final String LIST_1_REAL_OWNED_UNITS__NAME = "list_1_real_owned_units";
				public static final String LIST_1_REAL_SAME_FILE_UNITS__NAME = "list_1_real_same_file_units";
				public static final String LIST_1_REAL_OTHER_FILE_UNITS__NAME = "list_1_real_other_file_units";
				public static final URI INTEGER_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.0");
				public static final URI INTEGER_OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.1");
				public static final URI INTEGER_SAME_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.2");
				public static final URI INTEGER_OTHER_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.3");
				public static final URI LIST_1_INTEGER_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.4");
				public static final URI LIST_1_INTEGER_OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.5");
				public static final URI LIST_1_INTEGER_SAME_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.6");
				public static final URI LIST_1_INTEGER_OTHER_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.7");
				public static final URI REAL_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.8");
				public static final URI REAL_OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.9");
				public static final URI REAL_SAME_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.10");
				public static final URI REAL_OTHER_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.11");
				public static final URI LIST_1_REAL_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.12");
				public static final URI LIST_1_REAL_OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.13");
				public static final URI LIST_1_REAL_SAME_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.14");
				public static final URI LIST_1_REAL_OTHER_FILE_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.15");
				
				private final Optional<IntegerRange> integerNoUnits;
				private final Optional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> integerOwnedUnits;
				private final Optional<IntegerRangeWithUnits<Time>> integerSameFileUnits;
				private final Optional<IntegerRangeWithUnits<Mass>> integerOtherFileUnits;
				private final Optional<List<IntegerRange>> list1IntegerNoUnits;
				private final Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> list1IntegerOwnedUnits;
				private final Optional<List<IntegerRangeWithUnits<Time>>> list1IntegerSameFileUnits;
				private final Optional<List<IntegerRangeWithUnits<Mass>>> list1IntegerOtherFileUnits;
				private final Optional<RealRange> realNoUnits;
				private final Optional<RealRangeWithUnits<RealOwnedUnits_FieldType>> realOwnedUnits;
				private final Optional<RealRangeWithUnits<Time>> realSameFileUnits;
				private final Optional<RealRangeWithUnits<Mass>> realOtherFileUnits;
				private final Optional<List<RealRange>> list1RealNoUnits;
				private final Optional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> list1RealOwnedUnits;
				private final Optional<List<RealRangeWithUnits<Time>>> list1RealSameFileUnits;
				private final Optional<List<RealRangeWithUnits<Mass>>> list1RealOtherFileUnits;
				
				public RecordProperty(
						Optional<IntegerRange> integerNoUnits,
						Optional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> integerOwnedUnits,
						Optional<IntegerRangeWithUnits<Time>> integerSameFileUnits,
						Optional<IntegerRangeWithUnits<Mass>> integerOtherFileUnits,
						Optional<List<IntegerRange>> list1IntegerNoUnits,
						Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> list1IntegerOwnedUnits,
						Optional<List<IntegerRangeWithUnits<Time>>> list1IntegerSameFileUnits,
						Optional<List<IntegerRangeWithUnits<Mass>>> list1IntegerOtherFileUnits,
						Optional<RealRange> realNoUnits,
						Optional<RealRangeWithUnits<RealOwnedUnits_FieldType>> realOwnedUnits,
						Optional<RealRangeWithUnits<Time>> realSameFileUnits,
						Optional<RealRangeWithUnits<Mass>> realOtherFileUnits,
						Optional<List<RealRange>> list1RealNoUnits,
						Optional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> list1RealOwnedUnits,
						Optional<List<RealRangeWithUnits<Time>>> list1RealSameFileUnits,
						Optional<List<RealRangeWithUnits<Mass>>> list1RealOtherFileUnits
				) {
					this.integerNoUnits = integerNoUnits;
					this.integerOwnedUnits = integerOwnedUnits;
					this.integerSameFileUnits = integerSameFileUnits;
					this.integerOtherFileUnits = integerOtherFileUnits;
					this.list1IntegerNoUnits = list1IntegerNoUnits;
					this.list1IntegerOwnedUnits = list1IntegerOwnedUnits;
					this.list1IntegerSameFileUnits = list1IntegerSameFileUnits;
					this.list1IntegerOtherFileUnits = list1IntegerOtherFileUnits;
					this.realNoUnits = realNoUnits;
					this.realOwnedUnits = realOwnedUnits;
					this.realSameFileUnits = realSameFileUnits;
					this.realOtherFileUnits = realOtherFileUnits;
					this.list1RealNoUnits = list1RealNoUnits;
					this.list1RealOwnedUnits = list1RealOwnedUnits;
					this.list1RealSameFileUnits = list1RealSameFileUnits;
					this.list1RealOtherFileUnits = list1RealOtherFileUnits;
				}
				
				public RecordProperty(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<IntegerRange> integerNoUnits_local;
					try {
						integerNoUnits_local = findFieldValue(recordValue, INTEGER_NO_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerRange(resolved, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						integerNoUnits_local = Optional.empty();
					}
					this.integerNoUnits = integerNoUnits_local;
					
					Optional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> integerOwnedUnits_local;
					try {
						integerOwnedUnits_local = findFieldValue(recordValue, INTEGER_OWNED_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerRangeWithUnits<>(resolved, IntegerOwnedUnits_FieldType.class, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						integerOwnedUnits_local = Optional.empty();
					}
					this.integerOwnedUnits = integerOwnedUnits_local;
					
					Optional<IntegerRangeWithUnits<Time>> integerSameFileUnits_local;
					try {
						integerSameFileUnits_local = findFieldValue(recordValue, INTEGER_SAME_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerRangeWithUnits<>(resolved, Time.class, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						integerSameFileUnits_local = Optional.empty();
					}
					this.integerSameFileUnits = integerSameFileUnits_local;
					
					Optional<IntegerRangeWithUnits<Mass>> integerOtherFileUnits_local;
					try {
						integerOtherFileUnits_local = findFieldValue(recordValue, INTEGER_OTHER_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						integerOtherFileUnits_local = Optional.empty();
					}
					this.integerOtherFileUnits = integerOtherFileUnits_local;
					
					Optional<List<IntegerRange>> list1IntegerNoUnits_local;
					try {
						list1IntegerNoUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_NO_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerRange(resolved1, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1IntegerNoUnits_local = Optional.empty();
					}
					this.list1IntegerNoUnits = list1IntegerNoUnits_local;
					
					Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> list1IntegerOwnedUnits_local;
					try {
						list1IntegerOwnedUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_OWNED_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerRangeWithUnits<>(resolved1, List1IntegerOwnedUnits_FieldType.class, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1IntegerOwnedUnits_local = Optional.empty();
					}
					this.list1IntegerOwnedUnits = list1IntegerOwnedUnits_local;
					
					Optional<List<IntegerRangeWithUnits<Time>>> list1IntegerSameFileUnits_local;
					try {
						list1IntegerSameFileUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_SAME_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1IntegerSameFileUnits_local = Optional.empty();
					}
					this.list1IntegerSameFileUnits = list1IntegerSameFileUnits_local;
					
					Optional<List<IntegerRangeWithUnits<Mass>>> list1IntegerOtherFileUnits_local;
					try {
						list1IntegerOtherFileUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_OTHER_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1IntegerOtherFileUnits_local = Optional.empty();
					}
					this.list1IntegerOtherFileUnits = list1IntegerOtherFileUnits_local;
					
					Optional<RealRange> realNoUnits_local;
					try {
						realNoUnits_local = findFieldValue(recordValue, REAL_NO_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new RealRange(resolved, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						realNoUnits_local = Optional.empty();
					}
					this.realNoUnits = realNoUnits_local;
					
					Optional<RealRangeWithUnits<RealOwnedUnits_FieldType>> realOwnedUnits_local;
					try {
						realOwnedUnits_local = findFieldValue(recordValue, REAL_OWNED_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new RealRangeWithUnits<>(resolved, RealOwnedUnits_FieldType.class, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						realOwnedUnits_local = Optional.empty();
					}
					this.realOwnedUnits = realOwnedUnits_local;
					
					Optional<RealRangeWithUnits<Time>> realSameFileUnits_local;
					try {
						realSameFileUnits_local = findFieldValue(recordValue, REAL_SAME_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new RealRangeWithUnits<>(resolved, Time.class, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						realSameFileUnits_local = Optional.empty();
					}
					this.realSameFileUnits = realSameFileUnits_local;
					
					Optional<RealRangeWithUnits<Mass>> realOtherFileUnits_local;
					try {
						realOtherFileUnits_local = findFieldValue(recordValue, REAL_OTHER_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new RealRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						realOtherFileUnits_local = Optional.empty();
					}
					this.realOtherFileUnits = realOtherFileUnits_local;
					
					Optional<List<RealRange>> list1RealNoUnits_local;
					try {
						list1RealNoUnits_local = findFieldValue(recordValue, LIST_1_REAL_NO_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RealRange(resolved1, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1RealNoUnits_local = Optional.empty();
					}
					this.list1RealNoUnits = list1RealNoUnits_local;
					
					Optional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> list1RealOwnedUnits_local;
					try {
						list1RealOwnedUnits_local = findFieldValue(recordValue, LIST_1_REAL_OWNED_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RealRangeWithUnits<>(resolved1, List1RealOwnedUnits_FieldType.class, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1RealOwnedUnits_local = Optional.empty();
					}
					this.list1RealOwnedUnits = list1RealOwnedUnits_local;
					
					Optional<List<RealRangeWithUnits<Time>>> list1RealSameFileUnits_local;
					try {
						list1RealSameFileUnits_local = findFieldValue(recordValue, LIST_1_REAL_SAME_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RealRangeWithUnits<>(resolved1, Time.class, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1RealSameFileUnits_local = Optional.empty();
					}
					this.list1RealSameFileUnits = list1RealSameFileUnits_local;
					
					Optional<List<RealRangeWithUnits<Mass>>> list1RealOtherFileUnits_local;
					try {
						list1RealOtherFileUnits_local = findFieldValue(recordValue, LIST_1_REAL_OTHER_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RealRangeWithUnits<>(resolved1, Mass.class, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1RealOtherFileUnits_local = Optional.empty();
					}
					this.list1RealOtherFileUnits = list1RealOtherFileUnits_local;
				}
				
				public RecordProperty(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<IntegerRange> integerNoUnits_local;
					try {
						integerNoUnits_local = findFieldValue(recordValue, INTEGER_NO_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new IntegerRange(resolved);
						});
					} catch (PropertyNotPresentException e) {
						integerNoUnits_local = Optional.empty();
					}
					this.integerNoUnits = integerNoUnits_local;
					
					Optional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> integerOwnedUnits_local;
					try {
						integerOwnedUnits_local = findFieldValue(recordValue, INTEGER_OWNED_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new IntegerRangeWithUnits<>(resolved, IntegerOwnedUnits_FieldType.class);
						});
					} catch (PropertyNotPresentException e) {
						integerOwnedUnits_local = Optional.empty();
					}
					this.integerOwnedUnits = integerOwnedUnits_local;
					
					Optional<IntegerRangeWithUnits<Time>> integerSameFileUnits_local;
					try {
						integerSameFileUnits_local = findFieldValue(recordValue, INTEGER_SAME_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new IntegerRangeWithUnits<>(resolved, Time.class);
						});
					} catch (PropertyNotPresentException e) {
						integerSameFileUnits_local = Optional.empty();
					}
					this.integerSameFileUnits = integerSameFileUnits_local;
					
					Optional<IntegerRangeWithUnits<Mass>> integerOtherFileUnits_local;
					try {
						integerOtherFileUnits_local = findFieldValue(recordValue, INTEGER_OTHER_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new IntegerRangeWithUnits<>(resolved, Mass.class);
						});
					} catch (PropertyNotPresentException e) {
						integerOtherFileUnits_local = Optional.empty();
					}
					this.integerOtherFileUnits = integerOtherFileUnits_local;
					
					Optional<List<IntegerRange>> list1IntegerNoUnits_local;
					try {
						list1IntegerNoUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_NO_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new IntegerRange(resolved1);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1IntegerNoUnits_local = Optional.empty();
					}
					this.list1IntegerNoUnits = list1IntegerNoUnits_local;
					
					Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> list1IntegerOwnedUnits_local;
					try {
						list1IntegerOwnedUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_OWNED_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new IntegerRangeWithUnits<>(resolved1, List1IntegerOwnedUnits_FieldType.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1IntegerOwnedUnits_local = Optional.empty();
					}
					this.list1IntegerOwnedUnits = list1IntegerOwnedUnits_local;
					
					Optional<List<IntegerRangeWithUnits<Time>>> list1IntegerSameFileUnits_local;
					try {
						list1IntegerSameFileUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_SAME_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new IntegerRangeWithUnits<>(resolved1, Time.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1IntegerSameFileUnits_local = Optional.empty();
					}
					this.list1IntegerSameFileUnits = list1IntegerSameFileUnits_local;
					
					Optional<List<IntegerRangeWithUnits<Mass>>> list1IntegerOtherFileUnits_local;
					try {
						list1IntegerOtherFileUnits_local = findFieldValue(recordValue, LIST_1_INTEGER_OTHER_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new IntegerRangeWithUnits<>(resolved1, Mass.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1IntegerOtherFileUnits_local = Optional.empty();
					}
					this.list1IntegerOtherFileUnits = list1IntegerOtherFileUnits_local;
					
					Optional<RealRange> realNoUnits_local;
					try {
						realNoUnits_local = findFieldValue(recordValue, REAL_NO_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new RealRange(resolved);
						});
					} catch (PropertyNotPresentException e) {
						realNoUnits_local = Optional.empty();
					}
					this.realNoUnits = realNoUnits_local;
					
					Optional<RealRangeWithUnits<RealOwnedUnits_FieldType>> realOwnedUnits_local;
					try {
						realOwnedUnits_local = findFieldValue(recordValue, REAL_OWNED_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new RealRangeWithUnits<>(resolved, RealOwnedUnits_FieldType.class);
						});
					} catch (PropertyNotPresentException e) {
						realOwnedUnits_local = Optional.empty();
					}
					this.realOwnedUnits = realOwnedUnits_local;
					
					Optional<RealRangeWithUnits<Time>> realSameFileUnits_local;
					try {
						realSameFileUnits_local = findFieldValue(recordValue, REAL_SAME_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new RealRangeWithUnits<>(resolved, Time.class);
						});
					} catch (PropertyNotPresentException e) {
						realSameFileUnits_local = Optional.empty();
					}
					this.realSameFileUnits = realSameFileUnits_local;
					
					Optional<RealRangeWithUnits<Mass>> realOtherFileUnits_local;
					try {
						realOtherFileUnits_local = findFieldValue(recordValue, REAL_OTHER_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new RealRangeWithUnits<>(resolved, Mass.class);
						});
					} catch (PropertyNotPresentException e) {
						realOtherFileUnits_local = Optional.empty();
					}
					this.realOtherFileUnits = realOtherFileUnits_local;
					
					Optional<List<RealRange>> list1RealNoUnits_local;
					try {
						list1RealNoUnits_local = findFieldValue(recordValue, LIST_1_REAL_NO_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new RealRange(resolved1);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1RealNoUnits_local = Optional.empty();
					}
					this.list1RealNoUnits = list1RealNoUnits_local;
					
					Optional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> list1RealOwnedUnits_local;
					try {
						list1RealOwnedUnits_local = findFieldValue(recordValue, LIST_1_REAL_OWNED_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new RealRangeWithUnits<>(resolved1, List1RealOwnedUnits_FieldType.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1RealOwnedUnits_local = Optional.empty();
					}
					this.list1RealOwnedUnits = list1RealOwnedUnits_local;
					
					Optional<List<RealRangeWithUnits<Time>>> list1RealSameFileUnits_local;
					try {
						list1RealSameFileUnits_local = findFieldValue(recordValue, LIST_1_REAL_SAME_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new RealRangeWithUnits<>(resolved1, Time.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1RealSameFileUnits_local = Optional.empty();
					}
					this.list1RealSameFileUnits = list1RealSameFileUnits_local;
					
					Optional<List<RealRangeWithUnits<Mass>>> list1RealOtherFileUnits_local;
					try {
						list1RealOtherFileUnits_local = findFieldValue(recordValue, LIST_1_REAL_OTHER_FILE_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new RealRangeWithUnits<>(resolved1, Mass.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1RealOtherFileUnits_local = Optional.empty();
					}
					this.list1RealOtherFileUnits = list1RealOtherFileUnits_local;
				}
				
				public Optional<IntegerRange> getIntegerNoUnits() {
					return integerNoUnits;
				}
				
				public Optional<IntegerRangeWithUnits<IntegerOwnedUnits_FieldType>> getIntegerOwnedUnits() {
					return integerOwnedUnits;
				}
				
				public Optional<IntegerRangeWithUnits<Time>> getIntegerSameFileUnits() {
					return integerSameFileUnits;
				}
				
				public Optional<IntegerRangeWithUnits<Mass>> getIntegerOtherFileUnits() {
					return integerOtherFileUnits;
				}
				
				public Optional<List<IntegerRange>> getList1IntegerNoUnits() {
					return list1IntegerNoUnits;
				}
				
				public Optional<List<IntegerRangeWithUnits<List1IntegerOwnedUnits_FieldType>>> getList1IntegerOwnedUnits() {
					return list1IntegerOwnedUnits;
				}
				
				public Optional<List<IntegerRangeWithUnits<Time>>> getList1IntegerSameFileUnits() {
					return list1IntegerSameFileUnits;
				}
				
				public Optional<List<IntegerRangeWithUnits<Mass>>> getList1IntegerOtherFileUnits() {
					return list1IntegerOtherFileUnits;
				}
				
				public Optional<RealRange> getRealNoUnits() {
					return realNoUnits;
				}
				
				public Optional<RealRangeWithUnits<RealOwnedUnits_FieldType>> getRealOwnedUnits() {
					return realOwnedUnits;
				}
				
				public Optional<RealRangeWithUnits<Time>> getRealSameFileUnits() {
					return realSameFileUnits;
				}
				
				public Optional<RealRangeWithUnits<Mass>> getRealOtherFileUnits() {
					return realOtherFileUnits;
				}
				
				public Optional<List<RealRange>> getList1RealNoUnits() {
					return list1RealNoUnits;
				}
				
				public Optional<List<RealRangeWithUnits<List1RealOwnedUnits_FieldType>>> getList1RealOwnedUnits() {
					return list1RealOwnedUnits;
				}
				
				public Optional<List<RealRangeWithUnits<Time>>> getList1RealSameFileUnits() {
					return list1RealSameFileUnits;
				}
				
				public Optional<List<RealRangeWithUnits<Mass>>> getList1RealOtherFileUnits() {
					return list1RealOtherFileUnits;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!integerNoUnits.isPresent()
							&& !integerOwnedUnits.isPresent()
							&& !integerSameFileUnits.isPresent()
							&& !integerOtherFileUnits.isPresent()
							&& !list1IntegerNoUnits.isPresent()
							&& !list1IntegerOwnedUnits.isPresent()
							&& !list1IntegerSameFileUnits.isPresent()
							&& !list1IntegerOtherFileUnits.isPresent()
							&& !realNoUnits.isPresent()
							&& !realOwnedUnits.isPresent()
							&& !realSameFileUnits.isPresent()
							&& !realOtherFileUnits.isPresent()
							&& !list1RealNoUnits.isPresent()
							&& !list1RealOwnedUnits.isPresent()
							&& !list1RealSameFileUnits.isPresent()
							&& !list1RealOtherFileUnits.isPresent()
					) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					integerNoUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, INTEGER_NO_UNITS__URI, INTEGER_NO_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression());
					});
					integerOwnedUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, INTEGER_OWNED_UNITS__URI, INTEGER_OWNED_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					integerSameFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, INTEGER_SAME_FILE_UNITS__URI, INTEGER_SAME_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					integerOtherFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, INTEGER_OTHER_FILE_UNITS__URI, INTEGER_OTHER_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					list1IntegerNoUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_INTEGER_NO_UNITS__URI, LIST_1_INTEGER_NO_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression();
						}));
					});
					list1IntegerOwnedUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_INTEGER_OWNED_UNITS__URI, LIST_1_INTEGER_OWNED_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1IntegerSameFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_INTEGER_SAME_FILE_UNITS__URI, LIST_1_INTEGER_SAME_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1IntegerOtherFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_INTEGER_OTHER_FILE_UNITS__URI, LIST_1_INTEGER_OTHER_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					realNoUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, REAL_NO_UNITS__URI, REAL_NO_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression());
					});
					realOwnedUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, REAL_OWNED_UNITS__URI, REAL_OWNED_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					realSameFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, REAL_SAME_FILE_UNITS__URI, REAL_SAME_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					realOtherFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, REAL_OTHER_FILE_UNITS__URI, REAL_OTHER_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					list1RealNoUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_REAL_NO_UNITS__URI, LIST_1_REAL_NO_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression();
						}));
					});
					list1RealOwnedUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_REAL_OWNED_UNITS__URI, LIST_1_REAL_OWNED_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1RealSameFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_REAL_SAME_FILE_UNITS__URI, LIST_1_REAL_SAME_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1RealOtherFileUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_REAL_OTHER_FILE_UNITS__URI, LIST_1_REAL_OTHER_FILE_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					return recordValue;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							integerNoUnits,
							integerOwnedUnits,
							integerSameFileUnits,
							integerOtherFileUnits,
							list1IntegerNoUnits,
							list1IntegerOwnedUnits,
							list1IntegerSameFileUnits,
							list1IntegerOtherFileUnits,
							realNoUnits,
							realOwnedUnits,
							realSameFileUnits,
							realOtherFileUnits,
							list1RealNoUnits,
							list1RealOwnedUnits,
							list1RealSameFileUnits,
							list1RealOtherFileUnits
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordProperty)) {
						return false;
					}
					RecordProperty other = (RecordProperty) obj;
					return Objects.equals(this.integerNoUnits, other.integerNoUnits)
							&& Objects.equals(this.integerOwnedUnits, other.integerOwnedUnits)
							&& Objects.equals(this.integerSameFileUnits, other.integerSameFileUnits)
							&& Objects.equals(this.integerOtherFileUnits, other.integerOtherFileUnits)
							&& Objects.equals(this.list1IntegerNoUnits, other.list1IntegerNoUnits)
							&& Objects.equals(this.list1IntegerOwnedUnits, other.list1IntegerOwnedUnits)
							&& Objects.equals(this.list1IntegerSameFileUnits, other.list1IntegerSameFileUnits)
							&& Objects.equals(this.list1IntegerOtherFileUnits, other.list1IntegerOtherFileUnits)
							&& Objects.equals(this.realNoUnits, other.realNoUnits)
							&& Objects.equals(this.realOwnedUnits, other.realOwnedUnits)
							&& Objects.equals(this.realSameFileUnits, other.realSameFileUnits)
							&& Objects.equals(this.realOtherFileUnits, other.realOtherFileUnits)
							&& Objects.equals(this.list1RealNoUnits, other.list1RealNoUnits)
							&& Objects.equals(this.list1RealOwnedUnits, other.list1RealOwnedUnits)
							&& Objects.equals(this.list1RealSameFileUnits, other.list1RealSameFileUnits)
							&& Objects.equals(this.list1RealOtherFileUnits, other.list1RealOtherFileUnits);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.integerNoUnits.ifPresent(field -> {
						builder.append(INTEGER_NO_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.integerOwnedUnits.ifPresent(field -> {
						builder.append(INTEGER_OWNED_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.integerSameFileUnits.ifPresent(field -> {
						builder.append(INTEGER_SAME_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.integerOtherFileUnits.ifPresent(field -> {
						builder.append(INTEGER_OTHER_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.list1IntegerNoUnits.ifPresent(field -> {
						builder.append(LIST_1_INTEGER_NO_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1IntegerOwnedUnits.ifPresent(field -> {
						builder.append(LIST_1_INTEGER_OWNED_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1IntegerSameFileUnits.ifPresent(field -> {
						builder.append(LIST_1_INTEGER_SAME_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1IntegerOtherFileUnits.ifPresent(field -> {
						builder.append(LIST_1_INTEGER_OTHER_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.realNoUnits.ifPresent(field -> {
						builder.append(REAL_NO_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.realOwnedUnits.ifPresent(field -> {
						builder.append(REAL_OWNED_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.realSameFileUnits.ifPresent(field -> {
						builder.append(REAL_SAME_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.realOtherFileUnits.ifPresent(field -> {
						builder.append(REAL_OTHER_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.list1RealNoUnits.ifPresent(field -> {
						builder.append(LIST_1_REAL_NO_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1RealOwnedUnits.ifPresent(field -> {
						builder.append(LIST_1_REAL_OWNED_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1RealSameFileUnits.ifPresent(field -> {
						builder.append(LIST_1_REAL_SAME_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1RealOtherFileUnits.ifPresent(field -> {
						builder.append(LIST_1_REAL_OTHER_FILE_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum IntegerOwnedUnits_FieldType implements GeneratedUnits<IntegerOwnedUnits_FieldType> {
					CM(1.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
					M(100.0, "m", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private IntegerOwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
					}
					
					public static IntegerOwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public double getFactorTo(IntegerOwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public URI getURI() {
						return uri;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum List1IntegerOwnedUnits_FieldType implements GeneratedUnits<List1IntegerOwnedUnits_FieldType> {
					M(1.0, "m", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
					KM(1000.0, "km", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private List1IntegerOwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
					}
					
					public static List1IntegerOwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public double getFactorTo(List1IntegerOwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public URI getURI() {
						return uri;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum RealOwnedUnits_FieldType implements GeneratedUnits<RealOwnedUnits_FieldType> {
					MM(1.0, "mm", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
					CM(10.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private RealOwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
					}
					
					public static RealOwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public double getFactorTo(RealOwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public URI getURI() {
						return uri;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum List1RealOwnedUnits_FieldType implements GeneratedUnits<List1RealOwnedUnits_FieldType> {
					MG(1.0, "mg", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
					CG(10.0, "cg", "__synthetic1.aadl#/0/@ownedProperty.16/@ownedPropertyType/@ownedField.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private List1RealOwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
					}
					
					public static List1RealOwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public double getFactorTo(List1RealOwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public URI getURI() {
						return uri;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
			}
		'''
		val integerOwnedUnitsConstant = '''
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum IntegerOwnedUnitsConstant implements GeneratedUnits<IntegerOwnedUnitsConstant> {
				CM(1.0, "cm", "__synthetic1.aadl#/0/@ownedPropertyConstant.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				M(100.0, "m", "__synthetic1.aadl#/0/@ownedPropertyConstant.1/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private IntegerOwnedUnitsConstant(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static IntegerOwnedUnitsConstant valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(IntegerOwnedUnitsConstant target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val list1IntegerOwnedUnitsConstant = '''
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum List1IntegerOwnedUnitsConstant implements GeneratedUnits<List1IntegerOwnedUnitsConstant> {
				M(1.0, "m", "__synthetic1.aadl#/0/@ownedPropertyConstant.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				KM(1000.0, "km", "__synthetic1.aadl#/0/@ownedPropertyConstant.5/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private List1IntegerOwnedUnitsConstant(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static List1IntegerOwnedUnitsConstant valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(List1IntegerOwnedUnitsConstant target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val realOwnedUnitsConstant = '''
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum RealOwnedUnitsConstant implements GeneratedUnits<RealOwnedUnitsConstant> {
				MM(1.0, "mm", "__synthetic1.aadl#/0/@ownedPropertyConstant.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				CM(10.0, "cm", "__synthetic1.aadl#/0/@ownedPropertyConstant.9/@ownedPropertyType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private RealOwnedUnitsConstant(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static RealOwnedUnitsConstant valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(RealOwnedUnitsConstant target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val list1RealOwnedUnitsConstant = '''
			package rangetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum List1RealOwnedUnitsConstant implements GeneratedUnits<List1RealOwnedUnitsConstant> {
				MG(1.0, "mg", "__synthetic1.aadl#/0/@ownedPropertyConstant.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				CG(10.0, "cg", "__synthetic1.aadl#/0/@ownedPropertyConstant.13/@ownedPropertyType/@ownedElementType/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private List1RealOwnedUnitsConstant(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static List1RealOwnedUnitsConstant valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(List1RealOwnedUnitsConstant target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(rangeTest, otherPs))
		assertEquals("src-gen/rangetest", results.packagePath)
		assertEquals(11, results.classes.size)
		
		assertEquals("RangeTest.java", results.classes.get(0).fileName)
		assertEquals(rangeTestClass.toString, results.classes.get(0).contents)
		
		assertEquals("Time.java", results.classes.get(1).fileName)
		assertEquals(time.toString, results.classes.get(1).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.classes.get(2).fileName)
		assertEquals(integerOwnedUnits.toString, results.classes.get(2).contents)
		
		assertEquals("List1IntegerOwnedUnits.java", results.classes.get(3).fileName)
		assertEquals(list1IntegerOwnedUnits.toString, results.classes.get(3).contents)
		
		assertEquals("RealOwnedUnits.java", results.classes.get(4).fileName)
		assertEquals(realOwnedUnits.toString, results.classes.get(4).contents)
		
		assertEquals("List1RealOwnedUnits.java", results.classes.get(5).fileName)
		assertEquals(list1RealOwnedUnits.toString, results.classes.get(5).contents)
		
		assertEquals("RecordProperty.java", results.classes.get(6).fileName)
		assertEquals(recordProperty.toString, results.classes.get(6).contents)
		
		assertEquals("IntegerOwnedUnitsConstant.java", results.classes.get(7).fileName)
		assertEquals(integerOwnedUnitsConstant.toString, results.classes.get(7).contents)
		
		assertEquals("List1IntegerOwnedUnitsConstant.java", results.classes.get(8).fileName)
		assertEquals(list1IntegerOwnedUnitsConstant.toString, results.classes.get(8).contents)
		
		assertEquals("RealOwnedUnitsConstant.java", results.classes.get(9).fileName)
		assertEquals(realOwnedUnitsConstant.toString, results.classes.get(9).contents)
		
		assertEquals("List1RealOwnedUnitsConstant.java", results.classes.get(10).fileName)
		assertEquals(list1RealOwnedUnitsConstant.toString, results.classes.get(10).contents)
	}
}