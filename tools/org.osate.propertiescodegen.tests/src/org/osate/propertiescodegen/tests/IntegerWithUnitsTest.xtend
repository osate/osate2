/*******************************************************************************
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file). 
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
class IntegerWithUnitsTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testIntegerWithUnits() {
		val otherPs = '''
			property set other_ps is
				mass: type units (g, kg => g * 1000);
			end other_ps;
		'''
		val integerWithUnitsTest = '''
			property set integer_with_units_test is
				with other_ps;
				
				time: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				
				owned: aadlinteger units (B, KiB => B * 1024) applies to (all);
				same_file: aadlinteger units integer_with_units_test::time applies to (all);
				other_file: aadlinteger units other_ps::mass applies to (all);
				
				list_1_owned: list of aadlinteger units (mg, g => mg * 1000) applies to (all);
				list_1_same_file: list of aadlinteger units integer_with_units_test::time applies to (all);
				list_1_other_file: list of aadlinteger units other_ps::mass applies to (all);
				
				record_property: record (
					owned: aadlinteger units (hour, day => hour * 24);
					same_file: aadlinteger units integer_with_units_test::time;
					other_file: aadlinteger units other_ps::mass;
					
					list_1_owned: list of aadlinteger units (ml, l => ml * 1000);
					list_1_same_file: list of aadlinteger units integer_with_units_test::time;
					list_1_other_file: list of aadlinteger units other_ps::mass;
				) applies to (all);
				
				owned_constant: constant aadlinteger units (B, KiB => B * 1024) => 1 B;
				same_file_constant: constant aadlinteger units integer_with_units_test::time => 2 sec;
				other_file_constant: constant aadlinteger units other_ps::mass => 3 g;
				
				list_1_owned_constant: constant list of aadlinteger units (mg, g => mg * 1000) => (4 mg, 5 g);
				list_1_same_file_constant: constant list of aadlinteger units integer_with_units_test::time => (6 sec, 7 min);
				list_1_other_file_constant: constant list of aadlinteger units other_ps::mass => (8 g, 9 kg);
				
				record_constant: constant record (
					owned: aadlinteger units (hour, day => hour * 24);
					same_file: aadlinteger units integer_with_units_test::time;
					other_file: aadlinteger units other_ps::mass;
					
					list_1_owned: list of aadlinteger units (ml, l => ml * 1000);
					list_1_same_file: list of aadlinteger units integer_with_units_test::time;
					list_1_other_file: list of aadlinteger units other_ps::mass;
				) => [
					owned => 1 hour;
					same_file => 2 sec;
					other_file => 3 g;
					
					list_1_owned => (4 ml, 5 l);
					list_1_same_file => (6 sec, 7 min);
					list_1_other_file => (8 g, 9 kg);
				];
			end integer_with_units_test;
		'''
		val integerWithUnitsTestClass = '''
			package integerwithunitstest;
			
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
			import org.osate.pluginsupport.properties.IntegerWithUnits;
			
			import otherps.Mass;
			
			public final class IntegerWithUnitsTest {
				public static final String INTEGER_WITH_UNITS_TEST__NAME = "integer_with_units_test";
				
				private IntegerWithUnitsTest() {}
				
				// Lookup methods for integer_with_units_test::owned
				
				public static final String OWNED__NAME = "owned";
				
				public static boolean acceptsOwned(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getOwned_Property(lookupContext));
				}
				
				public static Optional<IntegerWithUnits<Owned>> getOwned(NamedElement lookupContext) {
					return getOwned(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerWithUnits<Owned>> getOwned(NamedElement lookupContext, Mode mode) {
					return getOwned(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerWithUnits<Owned>> getOwned(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getOwned_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerWithUnits<>(resolved, Owned.class));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getOwned_Property(EObject lookupContext) {
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + OWNED__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getOwned_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getOwned_Property(lookupContext));
				}
				
				// Lookup methods for integer_with_units_test::same_file
				
				public static final String SAME_FILE__NAME = "same_file";
				
				public static boolean acceptsSameFile(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getSameFile_Property(lookupContext));
				}
				
				public static Optional<IntegerWithUnits<Time>> getSameFile(NamedElement lookupContext) {
					return getSameFile(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerWithUnits<Time>> getSameFile(NamedElement lookupContext, Mode mode) {
					return getSameFile(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerWithUnits<Time>> getSameFile(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getSameFile_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerWithUnits<>(resolved, Time.class));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getSameFile_Property(EObject lookupContext) {
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + SAME_FILE__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getSameFile_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getSameFile_Property(lookupContext));
				}
				
				// Lookup methods for integer_with_units_test::other_file
				
				public static final String OTHER_FILE__NAME = "other_file";
				
				public static boolean acceptsOtherFile(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getOtherFile_Property(lookupContext));
				}
				
				public static Optional<IntegerWithUnits<Mass>> getOtherFile(NamedElement lookupContext) {
					return getOtherFile(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerWithUnits<Mass>> getOtherFile(NamedElement lookupContext, Mode mode) {
					return getOtherFile(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerWithUnits<Mass>> getOtherFile(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getOtherFile_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerWithUnits<>(resolved, Mass.class));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getOtherFile_Property(EObject lookupContext) {
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + OTHER_FILE__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getOtherFile_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getOtherFile_Property(lookupContext));
				}
				
				// Lookup methods for integer_with_units_test::list_1_owned
				
				public static final String LIST_1_OWNED__NAME = "list_1_owned";
				
				public static boolean acceptsList1Owned(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1Owned_Property(lookupContext));
				}
				
				public static Optional<List<IntegerWithUnits<List1Owned>>> getList1Owned(NamedElement lookupContext) {
					return getList1Owned(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerWithUnits<List1Owned>>> getList1Owned(NamedElement lookupContext, Mode mode) {
					return getList1Owned(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerWithUnits<List1Owned>>> getList1Owned(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1Owned_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerWithUnits<>(resolved1, List1Owned.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1Owned_Property(EObject lookupContext) {
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + LIST_1_OWNED__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1Owned_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1Owned_Property(lookupContext));
				}
				
				// Lookup methods for integer_with_units_test::list_1_same_file
				
				public static final String LIST_1_SAME_FILE__NAME = "list_1_same_file";
				
				public static boolean acceptsList1SameFile(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1SameFile_Property(lookupContext));
				}
				
				public static Optional<List<IntegerWithUnits<Time>>> getList1SameFile(NamedElement lookupContext) {
					return getList1SameFile(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerWithUnits<Time>>> getList1SameFile(NamedElement lookupContext, Mode mode) {
					return getList1SameFile(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerWithUnits<Time>>> getList1SameFile(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1SameFile_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerWithUnits<>(resolved1, Time.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1SameFile_Property(EObject lookupContext) {
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + LIST_1_SAME_FILE__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1SameFile_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1SameFile_Property(lookupContext));
				}
				
				// Lookup methods for integer_with_units_test::list_1_other_file
				
				public static final String LIST_1_OTHER_FILE__NAME = "list_1_other_file";
				
				public static boolean acceptsList1OtherFile(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1OtherFile_Property(lookupContext));
				}
				
				public static Optional<List<IntegerWithUnits<Mass>>> getList1OtherFile(NamedElement lookupContext) {
					return getList1OtherFile(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerWithUnits<Mass>>> getList1OtherFile(NamedElement lookupContext, Mode mode) {
					return getList1OtherFile(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerWithUnits<Mass>>> getList1OtherFile(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1OtherFile_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerWithUnits<>(resolved1, Mass.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1OtherFile_Property(EObject lookupContext) {
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + LIST_1_OTHER_FILE__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1OtherFile_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1OtherFile_Property(lookupContext));
				}
				
				// Lookup methods for integer_with_units_test::record_property
				
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
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + RECORD_PROPERTY__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getRecordProperty_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getRecordProperty_Property(lookupContext));
				}
				
				// Lookup methods for integer_with_units_test::owned_constant
				
				public static final String OWNED_CONSTANT__NAME = "owned_constant";
				
				public static IntegerWithUnits<OwnedConstant> getOwnedConstant(EObject lookupContext) {
					PropertyConstant constant = getOwnedConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return new IntegerWithUnits<>(resolved, OwnedConstant.class);
				}
				
				public static PropertyConstant getOwnedConstant_PropertyConstant(EObject lookupContext) {
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + OWNED_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for integer_with_units_test::same_file_constant
				
				public static final String SAME_FILE_CONSTANT__NAME = "same_file_constant";
				
				public static IntegerWithUnits<Time> getSameFileConstant(EObject lookupContext) {
					PropertyConstant constant = getSameFileConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return new IntegerWithUnits<>(resolved, Time.class);
				}
				
				public static PropertyConstant getSameFileConstant_PropertyConstant(EObject lookupContext) {
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + SAME_FILE_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for integer_with_units_test::other_file_constant
				
				public static final String OTHER_FILE_CONSTANT__NAME = "other_file_constant";
				
				public static IntegerWithUnits<Mass> getOtherFileConstant(EObject lookupContext) {
					PropertyConstant constant = getOtherFileConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return new IntegerWithUnits<>(resolved, Mass.class);
				}
				
				public static PropertyConstant getOtherFileConstant_PropertyConstant(EObject lookupContext) {
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + OTHER_FILE_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for integer_with_units_test::list_1_owned_constant
				
				public static final String LIST_1_OWNED_CONSTANT__NAME = "list_1_owned_constant";
				
				public static List<IntegerWithUnits<List1OwnedConstant>> getList1OwnedConstant(EObject lookupContext) {
					PropertyConstant constant = getList1OwnedConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return new IntegerWithUnits<>(resolved1, List1OwnedConstant.class);
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1OwnedConstant_PropertyConstant(EObject lookupContext) {
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + LIST_1_OWNED_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for integer_with_units_test::list_1_same_file_constant
				
				public static final String LIST_1_SAME_FILE_CONSTANT__NAME = "list_1_same_file_constant";
				
				public static List<IntegerWithUnits<Time>> getList1SameFileConstant(EObject lookupContext) {
					PropertyConstant constant = getList1SameFileConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return new IntegerWithUnits<>(resolved1, Time.class);
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1SameFileConstant_PropertyConstant(EObject lookupContext) {
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + LIST_1_SAME_FILE_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for integer_with_units_test::list_1_other_file_constant
				
				public static final String LIST_1_OTHER_FILE_CONSTANT__NAME = "list_1_other_file_constant";
				
				public static List<IntegerWithUnits<Mass>> getList1OtherFileConstant(EObject lookupContext) {
					PropertyConstant constant = getList1OtherFileConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return new IntegerWithUnits<>(resolved1, Mass.class);
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1OtherFileConstant_PropertyConstant(EObject lookupContext) {
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + LIST_1_OTHER_FILE_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for integer_with_units_test::record_constant
				
				public static final String RECORD_CONSTANT__NAME = "record_constant";
				
				public static RecordConstant getRecordConstant(EObject lookupContext) {
					PropertyConstant constant = getRecordConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return new RecordConstant(resolved);
				}
				
				public static PropertyConstant getRecordConstant_PropertyConstant(EObject lookupContext) {
					String name = INTEGER_WITH_UNITS_TEST__NAME + "::" + RECORD_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
			}
		'''
		val time = '''
			package integerwithunitstest;
			
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
		val owned = '''
			package integerwithunitstest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum Owned implements GeneratedUnits<Owned> {
				B(1.0, "B", "__synthetic1.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.0"),
				KIB(1024.0, "KiB", "__synthetic1.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private Owned(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static Owned valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(Owned target) {
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
		val list1Owned = '''
			package integerwithunitstest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum List1Owned implements GeneratedUnits<List1Owned> {
				MG(1.0, "mg", "__synthetic1.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.0"),
				G(1000.0, "g", "__synthetic1.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private List1Owned(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static List1Owned valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(List1Owned target) {
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
			package integerwithunitstest;
			
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
			import org.osate.pluginsupport.properties.IntegerWithUnits;
			
			import otherps.Mass;
			
			public class RecordProperty extends GeneratedRecord {
				public static final String OWNED__NAME = "owned";
				public static final String SAME_FILE__NAME = "same_file";
				public static final String OTHER_FILE__NAME = "other_file";
				public static final String LIST_1_OWNED__NAME = "list_1_owned";
				public static final String LIST_1_SAME_FILE__NAME = "list_1_same_file";
				public static final String LIST_1_OTHER_FILE__NAME = "list_1_other_file";
				public static final URI OWNED__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.0");
				public static final URI SAME_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.1");
				public static final URI OTHER_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.2");
				public static final URI LIST_1_OWNED__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.3");
				public static final URI LIST_1_SAME_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.4");
				public static final URI LIST_1_OTHER_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.5");
				
				private final Optional<IntegerWithUnits<Owned_FieldType>> owned;
				private final Optional<IntegerWithUnits<Time>> sameFile;
				private final Optional<IntegerWithUnits<Mass>> otherFile;
				private final Optional<List<IntegerWithUnits<List1Owned_FieldType>>> list1Owned;
				private final Optional<List<IntegerWithUnits<Time>>> list1SameFile;
				private final Optional<List<IntegerWithUnits<Mass>>> list1OtherFile;
				
				public RecordProperty(
						Optional<IntegerWithUnits<Owned_FieldType>> owned,
						Optional<IntegerWithUnits<Time>> sameFile,
						Optional<IntegerWithUnits<Mass>> otherFile,
						Optional<List<IntegerWithUnits<List1Owned_FieldType>>> list1Owned,
						Optional<List<IntegerWithUnits<Time>>> list1SameFile,
						Optional<List<IntegerWithUnits<Mass>>> list1OtherFile
				) {
					this.owned = owned;
					this.sameFile = sameFile;
					this.otherFile = otherFile;
					this.list1Owned = list1Owned;
					this.list1SameFile = list1SameFile;
					this.list1OtherFile = list1OtherFile;
				}
				
				public RecordProperty(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<IntegerWithUnits<Owned_FieldType>> owned_local;
					try {
						owned_local = findFieldValue(recordValue, OWNED__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerWithUnits<>(resolved, Owned_FieldType.class);
						});
					} catch (PropertyNotPresentException e) {
						owned_local = Optional.empty();
					}
					this.owned = owned_local;
					
					Optional<IntegerWithUnits<Time>> sameFile_local;
					try {
						sameFile_local = findFieldValue(recordValue, SAME_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerWithUnits<>(resolved, Time.class);
						});
					} catch (PropertyNotPresentException e) {
						sameFile_local = Optional.empty();
					}
					this.sameFile = sameFile_local;
					
					Optional<IntegerWithUnits<Mass>> otherFile_local;
					try {
						otherFile_local = findFieldValue(recordValue, OTHER_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerWithUnits<>(resolved, Mass.class);
						});
					} catch (PropertyNotPresentException e) {
						otherFile_local = Optional.empty();
					}
					this.otherFile = otherFile_local;
					
					Optional<List<IntegerWithUnits<List1Owned_FieldType>>> list1Owned_local;
					try {
						list1Owned_local = findFieldValue(recordValue, LIST_1_OWNED__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerWithUnits<>(resolved1, List1Owned_FieldType.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1Owned_local = Optional.empty();
					}
					this.list1Owned = list1Owned_local;
					
					Optional<List<IntegerWithUnits<Time>>> list1SameFile_local;
					try {
						list1SameFile_local = findFieldValue(recordValue, LIST_1_SAME_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerWithUnits<>(resolved1, Time.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1SameFile_local = Optional.empty();
					}
					this.list1SameFile = list1SameFile_local;
					
					Optional<List<IntegerWithUnits<Mass>>> list1OtherFile_local;
					try {
						list1OtherFile_local = findFieldValue(recordValue, LIST_1_OTHER_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerWithUnits<>(resolved1, Mass.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1OtherFile_local = Optional.empty();
					}
					this.list1OtherFile = list1OtherFile_local;
				}
				
				public RecordProperty(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<IntegerWithUnits<Owned_FieldType>> owned_local;
					try {
						owned_local = findFieldValue(recordValue, OWNED__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new IntegerWithUnits<>(resolved, Owned_FieldType.class);
						});
					} catch (PropertyNotPresentException e) {
						owned_local = Optional.empty();
					}
					this.owned = owned_local;
					
					Optional<IntegerWithUnits<Time>> sameFile_local;
					try {
						sameFile_local = findFieldValue(recordValue, SAME_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new IntegerWithUnits<>(resolved, Time.class);
						});
					} catch (PropertyNotPresentException e) {
						sameFile_local = Optional.empty();
					}
					this.sameFile = sameFile_local;
					
					Optional<IntegerWithUnits<Mass>> otherFile_local;
					try {
						otherFile_local = findFieldValue(recordValue, OTHER_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new IntegerWithUnits<>(resolved, Mass.class);
						});
					} catch (PropertyNotPresentException e) {
						otherFile_local = Optional.empty();
					}
					this.otherFile = otherFile_local;
					
					Optional<List<IntegerWithUnits<List1Owned_FieldType>>> list1Owned_local;
					try {
						list1Owned_local = findFieldValue(recordValue, LIST_1_OWNED__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new IntegerWithUnits<>(resolved1, List1Owned_FieldType.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1Owned_local = Optional.empty();
					}
					this.list1Owned = list1Owned_local;
					
					Optional<List<IntegerWithUnits<Time>>> list1SameFile_local;
					try {
						list1SameFile_local = findFieldValue(recordValue, LIST_1_SAME_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new IntegerWithUnits<>(resolved1, Time.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1SameFile_local = Optional.empty();
					}
					this.list1SameFile = list1SameFile_local;
					
					Optional<List<IntegerWithUnits<Mass>>> list1OtherFile_local;
					try {
						list1OtherFile_local = findFieldValue(recordValue, LIST_1_OTHER_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new IntegerWithUnits<>(resolved1, Mass.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1OtherFile_local = Optional.empty();
					}
					this.list1OtherFile = list1OtherFile_local;
				}
				
				public Optional<IntegerWithUnits<Owned_FieldType>> getOwned() {
					return owned;
				}
				
				public Optional<IntegerWithUnits<Time>> getSameFile() {
					return sameFile;
				}
				
				public Optional<IntegerWithUnits<Mass>> getOtherFile() {
					return otherFile;
				}
				
				public Optional<List<IntegerWithUnits<List1Owned_FieldType>>> getList1Owned() {
					return list1Owned;
				}
				
				public Optional<List<IntegerWithUnits<Time>>> getList1SameFile() {
					return list1SameFile;
				}
				
				public Optional<List<IntegerWithUnits<Mass>>> getList1OtherFile() {
					return list1OtherFile;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!owned.isPresent()
							&& !sameFile.isPresent()
							&& !otherFile.isPresent()
							&& !list1Owned.isPresent()
							&& !list1SameFile.isPresent()
							&& !list1OtherFile.isPresent()
					) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					owned.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, OWNED__URI, OWNED__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					sameFile.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, SAME_FILE__URI, SAME_FILE__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					otherFile.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, OTHER_FILE__URI, OTHER_FILE__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					list1Owned.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_OWNED__URI, LIST_1_OWNED__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1SameFile.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_SAME_FILE__URI, LIST_1_SAME_FILE__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1OtherFile.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_OTHER_FILE__URI, LIST_1_OTHER_FILE__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					return recordValue;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							owned,
							sameFile,
							otherFile,
							list1Owned,
							list1SameFile,
							list1OtherFile
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
					return Objects.equals(this.owned, other.owned)
							&& Objects.equals(this.sameFile, other.sameFile)
							&& Objects.equals(this.otherFile, other.otherFile)
							&& Objects.equals(this.list1Owned, other.list1Owned)
							&& Objects.equals(this.list1SameFile, other.list1SameFile)
							&& Objects.equals(this.list1OtherFile, other.list1OtherFile);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.owned.ifPresent(field -> {
						builder.append(OWNED__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.sameFile.ifPresent(field -> {
						builder.append(SAME_FILE__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.otherFile.ifPresent(field -> {
						builder.append(OTHER_FILE__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.list1Owned.ifPresent(field -> {
						builder.append(LIST_1_OWNED__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1SameFile.ifPresent(field -> {
						builder.append(LIST_1_SAME_FILE__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1OtherFile.ifPresent(field -> {
						builder.append(LIST_1_OTHER_FILE__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum Owned_FieldType implements GeneratedUnits<Owned_FieldType> {
					HOUR(1.0, "hour", "__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.0"),
					DAY(24.0, "day", "__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private Owned_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
					}
					
					public static Owned_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public double getFactorTo(Owned_FieldType target) {
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
				
				public enum List1Owned_FieldType implements GeneratedUnits<List1Owned_FieldType> {
					ML(1.0, "ml", "__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.0"),
					L(1000.0, "l", "__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private List1Owned_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
					}
					
					public static List1Owned_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public double getFactorTo(List1Owned_FieldType target) {
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
		val ownedConstant = '''
			package integerwithunitstest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum OwnedConstant implements GeneratedUnits<OwnedConstant> {
				B(1.0, "B", "__synthetic1.aadl#/0/@ownedPropertyConstant.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.0"),
				KIB(1024.0, "KiB", "__synthetic1.aadl#/0/@ownedPropertyConstant.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private OwnedConstant(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static OwnedConstant valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(OwnedConstant target) {
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
		val list1OwnedConstant = '''
			package integerwithunitstest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum List1OwnedConstant implements GeneratedUnits<List1OwnedConstant> {
				MG(1.0, "mg", "__synthetic1.aadl#/0/@ownedPropertyConstant.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.0"),
				G(1000.0, "g", "__synthetic1.aadl#/0/@ownedPropertyConstant.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private List1OwnedConstant(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static List1OwnedConstant valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(List1OwnedConstant target) {
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
		val recordConstant = '''
			package integerwithunitstest;
			
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
			import org.osate.pluginsupport.properties.IntegerWithUnits;
			
			import otherps.Mass;
			
			public class RecordConstant extends GeneratedRecord {
				public static final String OWNED__NAME = "owned";
				public static final String SAME_FILE__NAME = "same_file";
				public static final String OTHER_FILE__NAME = "other_file";
				public static final String LIST_1_OWNED__NAME = "list_1_owned";
				public static final String LIST_1_SAME_FILE__NAME = "list_1_same_file";
				public static final String LIST_1_OTHER_FILE__NAME = "list_1_other_file";
				public static final URI OWNED__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyConstant.6/@ownedPropertyType/@ownedField.0");
				public static final URI SAME_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyConstant.6/@ownedPropertyType/@ownedField.1");
				public static final URI OTHER_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyConstant.6/@ownedPropertyType/@ownedField.2");
				public static final URI LIST_1_OWNED__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyConstant.6/@ownedPropertyType/@ownedField.3");
				public static final URI LIST_1_SAME_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyConstant.6/@ownedPropertyType/@ownedField.4");
				public static final URI LIST_1_OTHER_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyConstant.6/@ownedPropertyType/@ownedField.5");
				
				private final Optional<IntegerWithUnits<Owned_FieldType>> owned;
				private final Optional<IntegerWithUnits<Time>> sameFile;
				private final Optional<IntegerWithUnits<Mass>> otherFile;
				private final Optional<List<IntegerWithUnits<List1Owned_FieldType>>> list1Owned;
				private final Optional<List<IntegerWithUnits<Time>>> list1SameFile;
				private final Optional<List<IntegerWithUnits<Mass>>> list1OtherFile;
				
				public RecordConstant(
						Optional<IntegerWithUnits<Owned_FieldType>> owned,
						Optional<IntegerWithUnits<Time>> sameFile,
						Optional<IntegerWithUnits<Mass>> otherFile,
						Optional<List<IntegerWithUnits<List1Owned_FieldType>>> list1Owned,
						Optional<List<IntegerWithUnits<Time>>> list1SameFile,
						Optional<List<IntegerWithUnits<Mass>>> list1OtherFile
				) {
					this.owned = owned;
					this.sameFile = sameFile;
					this.otherFile = otherFile;
					this.list1Owned = list1Owned;
					this.list1SameFile = list1SameFile;
					this.list1OtherFile = list1OtherFile;
				}
				
				public RecordConstant(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<IntegerWithUnits<Owned_FieldType>> owned_local;
					try {
						owned_local = findFieldValue(recordValue, OWNED__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerWithUnits<>(resolved, Owned_FieldType.class);
						});
					} catch (PropertyNotPresentException e) {
						owned_local = Optional.empty();
					}
					this.owned = owned_local;
					
					Optional<IntegerWithUnits<Time>> sameFile_local;
					try {
						sameFile_local = findFieldValue(recordValue, SAME_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerWithUnits<>(resolved, Time.class);
						});
					} catch (PropertyNotPresentException e) {
						sameFile_local = Optional.empty();
					}
					this.sameFile = sameFile_local;
					
					Optional<IntegerWithUnits<Mass>> otherFile_local;
					try {
						otherFile_local = findFieldValue(recordValue, OTHER_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new IntegerWithUnits<>(resolved, Mass.class);
						});
					} catch (PropertyNotPresentException e) {
						otherFile_local = Optional.empty();
					}
					this.otherFile = otherFile_local;
					
					Optional<List<IntegerWithUnits<List1Owned_FieldType>>> list1Owned_local;
					try {
						list1Owned_local = findFieldValue(recordValue, LIST_1_OWNED__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerWithUnits<>(resolved1, List1Owned_FieldType.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1Owned_local = Optional.empty();
					}
					this.list1Owned = list1Owned_local;
					
					Optional<List<IntegerWithUnits<Time>>> list1SameFile_local;
					try {
						list1SameFile_local = findFieldValue(recordValue, LIST_1_SAME_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerWithUnits<>(resolved1, Time.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1SameFile_local = Optional.empty();
					}
					this.list1SameFile = list1SameFile_local;
					
					Optional<List<IntegerWithUnits<Mass>>> list1OtherFile_local;
					try {
						list1OtherFile_local = findFieldValue(recordValue, LIST_1_OTHER_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerWithUnits<>(resolved1, Mass.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1OtherFile_local = Optional.empty();
					}
					this.list1OtherFile = list1OtherFile_local;
				}
				
				public RecordConstant(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<IntegerWithUnits<Owned_FieldType>> owned_local;
					try {
						owned_local = findFieldValue(recordValue, OWNED__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new IntegerWithUnits<>(resolved, Owned_FieldType.class);
						});
					} catch (PropertyNotPresentException e) {
						owned_local = Optional.empty();
					}
					this.owned = owned_local;
					
					Optional<IntegerWithUnits<Time>> sameFile_local;
					try {
						sameFile_local = findFieldValue(recordValue, SAME_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new IntegerWithUnits<>(resolved, Time.class);
						});
					} catch (PropertyNotPresentException e) {
						sameFile_local = Optional.empty();
					}
					this.sameFile = sameFile_local;
					
					Optional<IntegerWithUnits<Mass>> otherFile_local;
					try {
						otherFile_local = findFieldValue(recordValue, OTHER_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return new IntegerWithUnits<>(resolved, Mass.class);
						});
					} catch (PropertyNotPresentException e) {
						otherFile_local = Optional.empty();
					}
					this.otherFile = otherFile_local;
					
					Optional<List<IntegerWithUnits<List1Owned_FieldType>>> list1Owned_local;
					try {
						list1Owned_local = findFieldValue(recordValue, LIST_1_OWNED__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new IntegerWithUnits<>(resolved1, List1Owned_FieldType.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1Owned_local = Optional.empty();
					}
					this.list1Owned = list1Owned_local;
					
					Optional<List<IntegerWithUnits<Time>>> list1SameFile_local;
					try {
						list1SameFile_local = findFieldValue(recordValue, LIST_1_SAME_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new IntegerWithUnits<>(resolved1, Time.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1SameFile_local = Optional.empty();
					}
					this.list1SameFile = list1SameFile_local;
					
					Optional<List<IntegerWithUnits<Mass>>> list1OtherFile_local;
					try {
						list1OtherFile_local = findFieldValue(recordValue, LIST_1_OTHER_FILE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
								return new IntegerWithUnits<>(resolved1, Mass.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						list1OtherFile_local = Optional.empty();
					}
					this.list1OtherFile = list1OtherFile_local;
				}
				
				public Optional<IntegerWithUnits<Owned_FieldType>> getOwned() {
					return owned;
				}
				
				public Optional<IntegerWithUnits<Time>> getSameFile() {
					return sameFile;
				}
				
				public Optional<IntegerWithUnits<Mass>> getOtherFile() {
					return otherFile;
				}
				
				public Optional<List<IntegerWithUnits<List1Owned_FieldType>>> getList1Owned() {
					return list1Owned;
				}
				
				public Optional<List<IntegerWithUnits<Time>>> getList1SameFile() {
					return list1SameFile;
				}
				
				public Optional<List<IntegerWithUnits<Mass>>> getList1OtherFile() {
					return list1OtherFile;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!owned.isPresent()
							&& !sameFile.isPresent()
							&& !otherFile.isPresent()
							&& !list1Owned.isPresent()
							&& !list1SameFile.isPresent()
							&& !list1OtherFile.isPresent()
					) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					owned.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, OWNED__URI, OWNED__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					sameFile.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, SAME_FILE__URI, SAME_FILE__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					otherFile.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, OTHER_FILE__URI, OTHER_FILE__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					list1Owned.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_OWNED__URI, LIST_1_OWNED__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1SameFile.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_SAME_FILE__URI, LIST_1_SAME_FILE__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					list1OtherFile.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_1_OTHER_FILE__URI, LIST_1_OTHER_FILE__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					return recordValue;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							owned,
							sameFile,
							otherFile,
							list1Owned,
							list1SameFile,
							list1OtherFile
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordConstant)) {
						return false;
					}
					RecordConstant other = (RecordConstant) obj;
					return Objects.equals(this.owned, other.owned)
							&& Objects.equals(this.sameFile, other.sameFile)
							&& Objects.equals(this.otherFile, other.otherFile)
							&& Objects.equals(this.list1Owned, other.list1Owned)
							&& Objects.equals(this.list1SameFile, other.list1SameFile)
							&& Objects.equals(this.list1OtherFile, other.list1OtherFile);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.owned.ifPresent(field -> {
						builder.append(OWNED__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.sameFile.ifPresent(field -> {
						builder.append(SAME_FILE__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.otherFile.ifPresent(field -> {
						builder.append(OTHER_FILE__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.list1Owned.ifPresent(field -> {
						builder.append(LIST_1_OWNED__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1SameFile.ifPresent(field -> {
						builder.append(LIST_1_SAME_FILE__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1OtherFile.ifPresent(field -> {
						builder.append(LIST_1_OTHER_FILE__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum Owned_FieldType implements GeneratedUnits<Owned_FieldType> {
					HOUR(1.0, "hour", "__synthetic1.aadl#/0/@ownedPropertyConstant.6/@ownedPropertyType/@ownedField.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.0"),
					DAY(24.0, "day", "__synthetic1.aadl#/0/@ownedPropertyConstant.6/@ownedPropertyType/@ownedField.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private Owned_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
					}
					
					public static Owned_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public double getFactorTo(Owned_FieldType target) {
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
				
				public enum List1Owned_FieldType implements GeneratedUnits<List1Owned_FieldType> {
					ML(1.0, "ml", "__synthetic1.aadl#/0/@ownedPropertyConstant.6/@ownedPropertyType/@ownedField.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.0"),
					L(1000.0, "l", "__synthetic1.aadl#/0/@ownedPropertyConstant.6/@ownedPropertyType/@ownedField.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private List1Owned_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
					}
					
					public static List1Owned_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public double getFactorTo(List1Owned_FieldType target) {
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
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(integerWithUnitsTest, otherPs))
		assertEquals("src-gen/integerwithunitstest", results.packagePath)
		assertEquals(8, results.classes.size)
		
		assertEquals("IntegerWithUnitsTest.java", results.classes.get(0).fileName)
		assertEquals(integerWithUnitsTestClass.toString, results.classes.get(0).contents)
		
		assertEquals("Time.java", results.classes.get(1).fileName)
		assertEquals(time.toString, results.classes.get(1).contents)
		
		assertEquals("Owned.java", results.classes.get(2).fileName)
		assertEquals(owned.toString, results.classes.get(2).contents)
		
		assertEquals("List1Owned.java", results.classes.get(3).fileName)
		assertEquals(list1Owned.toString, results.classes.get(3).contents)
		
		assertEquals("RecordProperty.java", results.classes.get(4).fileName)
		assertEquals(recordProperty.toString, results.classes.get(4).contents)
		
		assertEquals("OwnedConstant.java", results.classes.get(5).fileName)
		assertEquals(ownedConstant.toString, results.classes.get(5).contents)
		
		assertEquals("List1OwnedConstant.java", results.classes.get(6).fileName)
		assertEquals(list1OwnedConstant.toString, results.classes.get(6).contents)
		
		assertEquals("RecordConstant.java", results.classes.get(7).fileName)
		assertEquals(recordConstant.toString, results.classes.get(7).contents)
	}
}