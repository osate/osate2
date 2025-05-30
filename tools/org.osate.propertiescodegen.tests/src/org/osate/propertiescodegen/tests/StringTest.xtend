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
class StringTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testString() {
		val otherPs = '''
			property set other_ps is
				other_string_type: type aadlstring;
			end other_ps;
		'''
		val stringTest = '''
			property set string_test is
				with other_ps;
				
				local_string_type: type aadlstring;
				
				owned_string: aadlstring applies to (all);
				referenced_string_local: string_test::local_string_type applies to (all);
				referenced_string_other: other_ps::other_string_type applies to (all);
				
				list_1_string: list of other_ps::other_string_type applies to (all);
				list_5_string: list of list of list of list of list of other_ps::other_string_type applies to (all);
				
				string_constant: constant aadlstring => "constant value";
				
				list_1_string_constant: constant list of aadlstring => (string_test::string_constant, "abc");
				list_5_string_constant: constant list of list of list of list of list of aadlstring => ((((
					("one", "two", "three"),
					()
				))));
			end string_test;
		'''
		val stringTestClass = '''
			package stringtest;
			
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
			import org.osate.aadl2.StringLiteral;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public final class StringTest {
				public static final String STRING_TEST__NAME = "string_test";
				
				private StringTest() {}
				
				// Lookup methods for string_test::owned_string
				
				public static final String OWNED_STRING__NAME = "owned_string";
				
				public static boolean acceptsOwnedString(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getOwnedString_Property(lookupContext));
				}
				
				public static Optional<String> getOwnedString(NamedElement lookupContext) {
					return getOwnedString(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getOwnedString(NamedElement lookupContext, Mode mode) {
					return getOwnedString(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getOwnedString(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getOwnedString_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getOwnedString_Property(EObject lookupContext) {
					String name = STRING_TEST__NAME + "::" + OWNED_STRING__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getOwnedString_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getOwnedString_Property(lookupContext));
				}
				
				// Lookup methods for string_test::referenced_string_local
				
				public static final String REFERENCED_STRING_LOCAL__NAME = "referenced_string_local";
				
				public static boolean acceptsReferencedStringLocal(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedStringLocal_Property(lookupContext));
				}
				
				public static Optional<String> getReferencedStringLocal(NamedElement lookupContext) {
					return getReferencedStringLocal(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getReferencedStringLocal(NamedElement lookupContext, Mode mode) {
					return getReferencedStringLocal(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getReferencedStringLocal(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedStringLocal_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getReferencedStringLocal_Property(EObject lookupContext) {
					String name = STRING_TEST__NAME + "::" + REFERENCED_STRING_LOCAL__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedStringLocal_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedStringLocal_Property(lookupContext));
				}
				
				// Lookup methods for string_test::referenced_string_other
				
				public static final String REFERENCED_STRING_OTHER__NAME = "referenced_string_other";
				
				public static boolean acceptsReferencedStringOther(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedStringOther_Property(lookupContext));
				}
				
				public static Optional<String> getReferencedStringOther(NamedElement lookupContext) {
					return getReferencedStringOther(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getReferencedStringOther(NamedElement lookupContext, Mode mode) {
					return getReferencedStringOther(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getReferencedStringOther(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedStringOther_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getReferencedStringOther_Property(EObject lookupContext) {
					String name = STRING_TEST__NAME + "::" + REFERENCED_STRING_OTHER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedStringOther_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedStringOther_Property(lookupContext));
				}
				
				// Lookup methods for string_test::list_1_string
				
				public static final String LIST_1_STRING__NAME = "list_1_string";
				
				public static boolean acceptsList1String(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1String_Property(lookupContext));
				}
				
				public static Optional<List<String>> getList1String(NamedElement lookupContext) {
					return getList1String(lookupContext, Optional.empty());
				}
				
				public static Optional<List<String>> getList1String(NamedElement lookupContext, Mode mode) {
					return getList1String(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<String>> getList1String(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1String_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((StringLiteral) resolved1).getValue();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1String_Property(EObject lookupContext) {
					String name = STRING_TEST__NAME + "::" + LIST_1_STRING__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1String_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1String_Property(lookupContext));
				}
				
				// Lookup methods for string_test::list_5_string
				
				public static final String LIST_5_STRING__NAME = "list_5_string";
				
				public static boolean acceptsList5String(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList5String_Property(lookupContext));
				}
				
				public static Optional<List<List<List<List<List<String>>>>>> getList5String(NamedElement lookupContext) {
					return getList5String(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List<List<String>>>>>> getList5String(NamedElement lookupContext, Mode mode) {
					return getList5String(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List<List<String>>>>>> getList5String(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList5String_Property(lookupContext);
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
											return ((StringLiteral) resolved5).getValue();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList5String_Property(EObject lookupContext) {
					String name = STRING_TEST__NAME + "::" + LIST_5_STRING__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList5String_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList5String_Property(lookupContext));
				}
				
				// Lookup methods for string_test::string_constant
				
				public static final String STRING_CONSTANT__NAME = "string_constant";
				
				public static String getStringConstant(EObject lookupContext) {
					PropertyConstant constant = getStringConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((StringLiteral) resolved).getValue();
				}
				
				public static PropertyConstant getStringConstant_PropertyConstant(EObject lookupContext) {
					String name = STRING_TEST__NAME + "::" + STRING_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for string_test::list_1_string_constant
				
				public static final String LIST_1_STRING_CONSTANT__NAME = "list_1_string_constant";
				
				public static List<String> getList1StringConstant(EObject lookupContext) {
					PropertyConstant constant = getList1StringConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return ((StringLiteral) resolved1).getValue();
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1StringConstant_PropertyConstant(EObject lookupContext) {
					String name = STRING_TEST__NAME + "::" + LIST_1_STRING_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for string_test::list_5_string_constant
				
				public static final String LIST_5_STRING_CONSTANT__NAME = "list_5_string_constant";
				
				public static List<List<List<List<List<String>>>>> getList5StringConstant(EObject lookupContext) {
					PropertyConstant constant = getList5StringConstant_PropertyConstant(lookupContext);
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
										return ((StringLiteral) resolved5).getValue();
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList5StringConstant_PropertyConstant(EObject lookupContext) {
					String name = STRING_TEST__NAME + "::" + LIST_5_STRING_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(stringTest, otherPs))
		assertEquals("src-gen/stringtest", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("StringTest.java", results.classes.head.fileName)
		assertEquals(stringTestClass.toString, results.classes.head.contents)
	}
}