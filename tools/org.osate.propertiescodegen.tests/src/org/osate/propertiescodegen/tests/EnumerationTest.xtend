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
class EnumerationTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testEnumeration() {
		val otherPs = '''
			property set other_ps is
				other_enumeration_type: type enumeration (one, two, three);
			end other_ps;
		'''
		val enumerationTest = '''
			property set enumeration_test is
				with other_ps;
				
				local_enumeration_type: type enumeration (a, b, c);
				
				owned_enumeration: enumeration (x, y, z) applies to (all);
				referenced_enumeration_local: enumeration_test::local_enumeration_type applies to (all);
				referenced_enumeration_other: other_ps::other_enumeration_type applies to (all);
				
				list_1_enumeration: list of enumeration (red, green, blue) applies to (all);
				list_3_enumeration: list of list of list of enumeration_test::local_enumeration_type applies to (all);
				list_5_enumeration: list of list of list of list of list of other_ps::other_enumeration_type applies to (all);
				
				owned_constant: constant enumeration (canada, usa, mexico) => canada;
				referenced_local_constant: constant enumeration_test::local_enumeration_type => a;
				referenced_other_constant: constant other_ps::other_enumeration_type => one;
				
				list_1_constant: constant list of enumeration (mac, linux, windows) => (mac, linux);
				list_3_constant: constant list of list of list of enumeration_test::local_enumeration_type => (((a, b), ()));
				list_5_constant: constant list of list of list of list of list of other_ps::other_enumeration_type => ((((
					(one, two),
					(three),
					()
				))));
			end enumeration_test;
		'''
		val enumerationTestClass = '''
			package enumerationtest;
			
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
			
			import otherps.OtherEnumerationType;
			
			public final class EnumerationTest {
				public static final String ENUMERATION_TEST__NAME = "enumeration_test";
				
				private EnumerationTest() {}
				
				// Lookup methods for enumeration_test::owned_enumeration
				
				public static final String OWNED_ENUMERATION__NAME = "owned_enumeration";
				
				public static boolean acceptsOwnedEnumeration(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getOwnedEnumeration_Property(lookupContext));
				}
				
				public static Optional<OwnedEnumeration> getOwnedEnumeration(NamedElement lookupContext) {
					return getOwnedEnumeration(lookupContext, Optional.empty());
				}
				
				public static Optional<OwnedEnumeration> getOwnedEnumeration(NamedElement lookupContext, Mode mode) {
					return getOwnedEnumeration(lookupContext, Optional.of(mode));
				}
				
				public static Optional<OwnedEnumeration> getOwnedEnumeration(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getOwnedEnumeration_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(OwnedEnumeration.valueOf(resolved));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getOwnedEnumeration_Property(EObject lookupContext) {
					String name = ENUMERATION_TEST__NAME + "::" + OWNED_ENUMERATION__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getOwnedEnumeration_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getOwnedEnumeration_Property(lookupContext));
				}
				
				// Lookup methods for enumeration_test::referenced_enumeration_local
				
				public static final String REFERENCED_ENUMERATION_LOCAL__NAME = "referenced_enumeration_local";
				
				public static boolean acceptsReferencedEnumerationLocal(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedEnumerationLocal_Property(lookupContext));
				}
				
				public static Optional<LocalEnumerationType> getReferencedEnumerationLocal(NamedElement lookupContext) {
					return getReferencedEnumerationLocal(lookupContext, Optional.empty());
				}
				
				public static Optional<LocalEnumerationType> getReferencedEnumerationLocal(NamedElement lookupContext, Mode mode) {
					return getReferencedEnumerationLocal(lookupContext, Optional.of(mode));
				}
				
				public static Optional<LocalEnumerationType> getReferencedEnumerationLocal(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedEnumerationLocal_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(LocalEnumerationType.valueOf(resolved));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getReferencedEnumerationLocal_Property(EObject lookupContext) {
					String name = ENUMERATION_TEST__NAME + "::" + REFERENCED_ENUMERATION_LOCAL__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedEnumerationLocal_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedEnumerationLocal_Property(lookupContext));
				}
				
				// Lookup methods for enumeration_test::referenced_enumeration_other
				
				public static final String REFERENCED_ENUMERATION_OTHER__NAME = "referenced_enumeration_other";
				
				public static boolean acceptsReferencedEnumerationOther(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedEnumerationOther_Property(lookupContext));
				}
				
				public static Optional<OtherEnumerationType> getReferencedEnumerationOther(NamedElement lookupContext) {
					return getReferencedEnumerationOther(lookupContext, Optional.empty());
				}
				
				public static Optional<OtherEnumerationType> getReferencedEnumerationOther(NamedElement lookupContext, Mode mode) {
					return getReferencedEnumerationOther(lookupContext, Optional.of(mode));
				}
				
				public static Optional<OtherEnumerationType> getReferencedEnumerationOther(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedEnumerationOther_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(OtherEnumerationType.valueOf(resolved));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getReferencedEnumerationOther_Property(EObject lookupContext) {
					String name = ENUMERATION_TEST__NAME + "::" + REFERENCED_ENUMERATION_OTHER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedEnumerationOther_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedEnumerationOther_Property(lookupContext));
				}
				
				// Lookup methods for enumeration_test::list_1_enumeration
				
				public static final String LIST_1_ENUMERATION__NAME = "list_1_enumeration";
				
				public static boolean acceptsList1Enumeration(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1Enumeration_Property(lookupContext));
				}
				
				public static Optional<List<List1Enumeration>> getList1Enumeration(NamedElement lookupContext) {
					return getList1Enumeration(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List1Enumeration>> getList1Enumeration(NamedElement lookupContext, Mode mode) {
					return getList1Enumeration(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List1Enumeration>> getList1Enumeration(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1Enumeration_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return List1Enumeration.valueOf(resolved1);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1Enumeration_Property(EObject lookupContext) {
					String name = ENUMERATION_TEST__NAME + "::" + LIST_1_ENUMERATION__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1Enumeration_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1Enumeration_Property(lookupContext));
				}
				
				// Lookup methods for enumeration_test::list_3_enumeration
				
				public static final String LIST_3_ENUMERATION__NAME = "list_3_enumeration";
				
				public static boolean acceptsList3Enumeration(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList3Enumeration_Property(lookupContext));
				}
				
				public static Optional<List<List<List<LocalEnumerationType>>>> getList3Enumeration(NamedElement lookupContext) {
					return getList3Enumeration(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<LocalEnumerationType>>>> getList3Enumeration(NamedElement lookupContext, Mode mode) {
					return getList3Enumeration(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<LocalEnumerationType>>>> getList3Enumeration(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList3Enumeration_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
									PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
									return LocalEnumerationType.valueOf(resolved3);
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList3Enumeration_Property(EObject lookupContext) {
					String name = ENUMERATION_TEST__NAME + "::" + LIST_3_ENUMERATION__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList3Enumeration_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList3Enumeration_Property(lookupContext));
				}
				
				// Lookup methods for enumeration_test::list_5_enumeration
				
				public static final String LIST_5_ENUMERATION__NAME = "list_5_enumeration";
				
				public static boolean acceptsList5Enumeration(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList5Enumeration_Property(lookupContext));
				}
				
				public static Optional<List<List<List<List<List<OtherEnumerationType>>>>>> getList5Enumeration(NamedElement lookupContext) {
					return getList5Enumeration(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List<List<OtherEnumerationType>>>>>> getList5Enumeration(NamedElement lookupContext, Mode mode) {
					return getList5Enumeration(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List<List<OtherEnumerationType>>>>>> getList5Enumeration(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList5Enumeration_Property(lookupContext);
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
											return OtherEnumerationType.valueOf(resolved5);
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList5Enumeration_Property(EObject lookupContext) {
					String name = ENUMERATION_TEST__NAME + "::" + LIST_5_ENUMERATION__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList5Enumeration_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList5Enumeration_Property(lookupContext));
				}
				
				// Lookup methods for enumeration_test::owned_constant
				
				public static final String OWNED_CONSTANT__NAME = "owned_constant";
				
				public static OwnedConstant getOwnedConstant(EObject lookupContext) {
					PropertyConstant constant = getOwnedConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return OwnedConstant.valueOf(resolved);
				}
				
				public static PropertyConstant getOwnedConstant_PropertyConstant(EObject lookupContext) {
					String name = ENUMERATION_TEST__NAME + "::" + OWNED_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for enumeration_test::referenced_local_constant
				
				public static final String REFERENCED_LOCAL_CONSTANT__NAME = "referenced_local_constant";
				
				public static LocalEnumerationType getReferencedLocalConstant(EObject lookupContext) {
					PropertyConstant constant = getReferencedLocalConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return LocalEnumerationType.valueOf(resolved);
				}
				
				public static PropertyConstant getReferencedLocalConstant_PropertyConstant(EObject lookupContext) {
					String name = ENUMERATION_TEST__NAME + "::" + REFERENCED_LOCAL_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for enumeration_test::referenced_other_constant
				
				public static final String REFERENCED_OTHER_CONSTANT__NAME = "referenced_other_constant";
				
				public static OtherEnumerationType getReferencedOtherConstant(EObject lookupContext) {
					PropertyConstant constant = getReferencedOtherConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return OtherEnumerationType.valueOf(resolved);
				}
				
				public static PropertyConstant getReferencedOtherConstant_PropertyConstant(EObject lookupContext) {
					String name = ENUMERATION_TEST__NAME + "::" + REFERENCED_OTHER_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for enumeration_test::list_1_constant
				
				public static final String LIST_1_CONSTANT__NAME = "list_1_constant";
				
				public static List<List1Constant> getList1Constant(EObject lookupContext) {
					PropertyConstant constant = getList1Constant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return List1Constant.valueOf(resolved1);
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1Constant_PropertyConstant(EObject lookupContext) {
					String name = ENUMERATION_TEST__NAME + "::" + LIST_1_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for enumeration_test::list_3_constant
				
				public static final String LIST_3_CONSTANT__NAME = "list_3_constant";
				
				public static List<List<List<LocalEnumerationType>>> getList3Constant(EObject lookupContext) {
					PropertyConstant constant = getList3Constant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
							PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2);
							return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
								PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3);
								return LocalEnumerationType.valueOf(resolved3);
							}).collect(Collectors.toList());
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList3Constant_PropertyConstant(EObject lookupContext) {
					String name = ENUMERATION_TEST__NAME + "::" + LIST_3_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for enumeration_test::list_5_constant
				
				public static final String LIST_5_CONSTANT__NAME = "list_5_constant";
				
				public static List<List<List<List<List<OtherEnumerationType>>>>> getList5Constant(EObject lookupContext) {
					PropertyConstant constant = getList5Constant_PropertyConstant(lookupContext);
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
										return OtherEnumerationType.valueOf(resolved5);
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList5Constant_PropertyConstant(EObject lookupContext) {
					String name = ENUMERATION_TEST__NAME + "::" + LIST_5_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
			}
		'''
		val localEnumerationType = '''
			package enumerationtest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.pluginsupport.properties.GeneratedEnumeration;
			
			public enum LocalEnumerationType implements GeneratedEnumeration {
				A("a", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				B("b", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				C("c", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2");
				
				private final String originalName;
				private final URI uri;
				
				private LocalEnumerationType(String originalName, String uri) {
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static LocalEnumerationType valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
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
		val ownedEnumeration = '''
			package enumerationtest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.pluginsupport.properties.GeneratedEnumeration;
			
			public enum OwnedEnumeration implements GeneratedEnumeration {
				X("x", "__synthetic1.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedLiteral.0"),
				Y("y", "__synthetic1.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedLiteral.1"),
				Z("z", "__synthetic1.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedLiteral.2");
				
				private final String originalName;
				private final URI uri;
				
				private OwnedEnumeration(String originalName, String uri) {
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static OwnedEnumeration valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
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
		val list1Enumeration = '''
			package enumerationtest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.pluginsupport.properties.GeneratedEnumeration;
			
			public enum List1Enumeration implements GeneratedEnumeration {
				RED("red", "__synthetic1.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
				GREEN("green", "__synthetic1.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedElementType/@ownedLiteral.1"),
				BLUE("blue", "__synthetic1.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedElementType/@ownedLiteral.2");
				
				private final String originalName;
				private final URI uri;
				
				private List1Enumeration(String originalName, String uri) {
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static List1Enumeration valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
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
		val ownedConstant = '''
			package enumerationtest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.pluginsupport.properties.GeneratedEnumeration;
			
			public enum OwnedConstant implements GeneratedEnumeration {
				CANADA("canada", "__synthetic1.aadl#/0/@ownedPropertyConstant.0/@ownedPropertyType/@ownedLiteral.0"),
				USA("usa", "__synthetic1.aadl#/0/@ownedPropertyConstant.0/@ownedPropertyType/@ownedLiteral.1"),
				MEXICO("mexico", "__synthetic1.aadl#/0/@ownedPropertyConstant.0/@ownedPropertyType/@ownedLiteral.2");
				
				private final String originalName;
				private final URI uri;
				
				private OwnedConstant(String originalName, String uri) {
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static OwnedConstant valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
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
		val list1Constant = '''
			package enumerationtest;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.pluginsupport.properties.GeneratedEnumeration;
			
			public enum List1Constant implements GeneratedEnumeration {
				MAC("mac", "__synthetic1.aadl#/0/@ownedPropertyConstant.3/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
				LINUX("linux", "__synthetic1.aadl#/0/@ownedPropertyConstant.3/@ownedPropertyType/@ownedElementType/@ownedLiteral.1"),
				WINDOWS("windows", "__synthetic1.aadl#/0/@ownedPropertyConstant.3/@ownedPropertyType/@ownedElementType/@ownedLiteral.2");
				
				private final String originalName;
				private final URI uri;
				
				private List1Constant(String originalName, String uri) {
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static List1Constant valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
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
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(enumerationTest, otherPs))
		assertEquals("src-gen/enumerationtest", results.packagePath)
		assertEquals(6, results.classes.size)
		
		assertEquals("EnumerationTest.java", results.classes.get(0).fileName)
		assertEquals(enumerationTestClass.toString, results.classes.get(0).contents)
		
		assertEquals("LocalEnumerationType.java", results.classes.get(1).fileName)
		assertEquals(localEnumerationType.toString, results.classes.get(1).contents)
		
		assertEquals("OwnedEnumeration.java", results.classes.get(2).fileName)
		assertEquals(ownedEnumeration.toString, results.classes.get(2).contents)
		
		assertEquals("List1Enumeration.java", results.classes.get(3).fileName)
		assertEquals(list1Enumeration.toString, results.classes.get(3).contents)
		
		assertEquals("OwnedConstant.java", results.classes.get(4).fileName)
		assertEquals(ownedConstant.toString, results.classes.get(4).contents)
		
		assertEquals("List1Constant.java", results.classes.get(5).fileName)
		assertEquals(list1Constant.toString, results.classes.get(5).contents)
	}
}