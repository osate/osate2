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
class IntegerNoUnitsTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testIntegerNoUnits() {
		val otherPs = '''
			property set other_ps is
				other_integer_no_units_type: type aadlinteger;
			end other_ps;
		'''
		val integerNoUnitsTest = '''
			property set integer_no_units_test is
				with other_ps;
				
				local_integer_type: type aadlinteger;
				
				owned_integer: aadlinteger applies to (all);
				referenced_integer_local: integer_no_units_test::local_integer_type applies to (all);
				referenced_integer_other: other_ps::other_integer_no_units_type applies to (all);
				
				list_1_integer: list of other_ps::other_integer_no_units_type applies to (all);
				list_5_integer: list of list of list of list of list of other_ps::other_integer_no_units_type applies to (all);
				
				integer_constant: constant aadlinteger => 1;
				
				list_1_integer_constant: constant list of aadlinteger => (integer_no_units_test::integer_constant, 2);
				list_5_integer_constant: constant list of list of list of list of list of aadlinteger => ((((
					(3, 4, 5),
					()
				))));
			end integer_no_units_test;
		'''
		val integerNoUnitsTestClass = '''
			package integernounitstest;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.OptionalLong;
			import java.util.stream.Collectors;
			
			import org.eclipse.emf.ecore.EObject;
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.IntegerLiteral;
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
			
			public final class IntegerNoUnitsTest {
				public static final String INTEGER_NO_UNITS_TEST__NAME = "integer_no_units_test";
				
				private IntegerNoUnitsTest() {}
				
				// Lookup methods for integer_no_units_test::owned_integer
				
				public static final String OWNED_INTEGER__NAME = "owned_integer";
				
				public static boolean acceptsOwnedInteger(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getOwnedInteger_Property(lookupContext));
				}
				
				public static OptionalLong getOwnedInteger(NamedElement lookupContext) {
					return getOwnedInteger(lookupContext, Optional.empty());
				}
				
				public static OptionalLong getOwnedInteger(NamedElement lookupContext, Mode mode) {
					return getOwnedInteger(lookupContext, Optional.of(mode));
				}
				
				public static OptionalLong getOwnedInteger(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getOwnedInteger_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return OptionalLong.of(((IntegerLiteral) resolved).getValue());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return OptionalLong.empty();
					}
				}
				
				public static Property getOwnedInteger_Property(EObject lookupContext) {
					String name = INTEGER_NO_UNITS_TEST__NAME + "::" + OWNED_INTEGER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getOwnedInteger_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getOwnedInteger_Property(lookupContext));
				}
				
				// Lookup methods for integer_no_units_test::referenced_integer_local
				
				public static final String REFERENCED_INTEGER_LOCAL__NAME = "referenced_integer_local";
				
				public static boolean acceptsReferencedIntegerLocal(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedIntegerLocal_Property(lookupContext));
				}
				
				public static OptionalLong getReferencedIntegerLocal(NamedElement lookupContext) {
					return getReferencedIntegerLocal(lookupContext, Optional.empty());
				}
				
				public static OptionalLong getReferencedIntegerLocal(NamedElement lookupContext, Mode mode) {
					return getReferencedIntegerLocal(lookupContext, Optional.of(mode));
				}
				
				public static OptionalLong getReferencedIntegerLocal(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedIntegerLocal_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return OptionalLong.of(((IntegerLiteral) resolved).getValue());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return OptionalLong.empty();
					}
				}
				
				public static Property getReferencedIntegerLocal_Property(EObject lookupContext) {
					String name = INTEGER_NO_UNITS_TEST__NAME + "::" + REFERENCED_INTEGER_LOCAL__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedIntegerLocal_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedIntegerLocal_Property(lookupContext));
				}
				
				// Lookup methods for integer_no_units_test::referenced_integer_other
				
				public static final String REFERENCED_INTEGER_OTHER__NAME = "referenced_integer_other";
				
				public static boolean acceptsReferencedIntegerOther(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedIntegerOther_Property(lookupContext));
				}
				
				public static OptionalLong getReferencedIntegerOther(NamedElement lookupContext) {
					return getReferencedIntegerOther(lookupContext, Optional.empty());
				}
				
				public static OptionalLong getReferencedIntegerOther(NamedElement lookupContext, Mode mode) {
					return getReferencedIntegerOther(lookupContext, Optional.of(mode));
				}
				
				public static OptionalLong getReferencedIntegerOther(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedIntegerOther_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return OptionalLong.of(((IntegerLiteral) resolved).getValue());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return OptionalLong.empty();
					}
				}
				
				public static Property getReferencedIntegerOther_Property(EObject lookupContext) {
					String name = INTEGER_NO_UNITS_TEST__NAME + "::" + REFERENCED_INTEGER_OTHER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedIntegerOther_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedIntegerOther_Property(lookupContext));
				}
				
				// Lookup methods for integer_no_units_test::list_1_integer
				
				public static final String LIST_1_INTEGER__NAME = "list_1_integer";
				
				public static boolean acceptsList1Integer(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1Integer_Property(lookupContext));
				}
				
				public static Optional<List<Long>> getList1Integer(NamedElement lookupContext) {
					return getList1Integer(lookupContext, Optional.empty());
				}
				
				public static Optional<List<Long>> getList1Integer(NamedElement lookupContext, Mode mode) {
					return getList1Integer(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<Long>> getList1Integer(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1Integer_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((IntegerLiteral) resolved1).getValue();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1Integer_Property(EObject lookupContext) {
					String name = INTEGER_NO_UNITS_TEST__NAME + "::" + LIST_1_INTEGER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1Integer_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1Integer_Property(lookupContext));
				}
				
				// Lookup methods for integer_no_units_test::list_5_integer
				
				public static final String LIST_5_INTEGER__NAME = "list_5_integer";
				
				public static boolean acceptsList5Integer(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList5Integer_Property(lookupContext));
				}
				
				public static Optional<List<List<List<List<List<Long>>>>>> getList5Integer(NamedElement lookupContext) {
					return getList5Integer(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List<List<Long>>>>>> getList5Integer(NamedElement lookupContext, Mode mode) {
					return getList5Integer(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List<List<Long>>>>>> getList5Integer(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList5Integer_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
									PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
									return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
										PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
										return ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
											PropertyExpression resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
											return ((IntegerLiteral) resolved5).getValue();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList5Integer_Property(EObject lookupContext) {
					String name = INTEGER_NO_UNITS_TEST__NAME + "::" + LIST_5_INTEGER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList5Integer_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList5Integer_Property(lookupContext));
				}
				
				// Lookup methods for integer_no_units_test::integer_constant
				
				public static final String INTEGER_CONSTANT__NAME = "integer_constant";
				
				public static long getIntegerConstant(EObject lookupContext) {
					PropertyConstant constant = getIntegerConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((IntegerLiteral) resolved).getValue();
				}
				
				public static PropertyConstant getIntegerConstant_PropertyConstant(EObject lookupContext) {
					String name = INTEGER_NO_UNITS_TEST__NAME + "::" + INTEGER_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for integer_no_units_test::list_1_integer_constant
				
				public static final String LIST_1_INTEGER_CONSTANT__NAME = "list_1_integer_constant";
				
				public static List<Long> getList1IntegerConstant(EObject lookupContext) {
					PropertyConstant constant = getList1IntegerConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return ((IntegerLiteral) resolved1).getValue();
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1IntegerConstant_PropertyConstant(EObject lookupContext) {
					String name = INTEGER_NO_UNITS_TEST__NAME + "::" + LIST_1_INTEGER_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for integer_no_units_test::list_5_integer_constant
				
				public static final String LIST_5_INTEGER_CONSTANT__NAME = "list_5_integer_constant";
				
				public static List<List<List<List<List<Long>>>>> getList5IntegerConstant(EObject lookupContext) {
					PropertyConstant constant = getList5IntegerConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
							PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2);
							return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
								PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3);
								return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
									PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4);
									return ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
										PropertyExpression resolved5 = CodeGenUtil.resolveNamedValue(element5);
										return ((IntegerLiteral) resolved5).getValue();
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList5IntegerConstant_PropertyConstant(EObject lookupContext) {
					String name = INTEGER_NO_UNITS_TEST__NAME + "::" + LIST_5_INTEGER_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(integerNoUnitsTest, otherPs))
		assertEquals("src-gen/integernounitstest", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("IntegerNoUnitsTest.java", results.classes.head.fileName)
		assertEquals(integerNoUnitsTestClass.toString, results.classes.head.contents)
	}
}