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
class ClassifierTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testClassifier() {
		val otherPs = '''
			property set other_ps is
				other_classifier_type: type classifier;
			end other_ps;
		'''
		val pkg1 = '''
			package pkg1
			public
				system s1
				end s1;
				
				thread t1
				end t1;
				
				data d1
				end d1;
			end pkg1;
		'''
		val classifierTest = '''
			property set classifier_test is
				with other_ps;
				with pkg1;
				
				local_classifier_type: type classifier;
				
				owned_classifier: classifier applies to (all);
				referenced_classifier_local: classifier_test::local_classifier_type applies to (all);
				referenced_classifier_other: other_ps::other_classifier_type applies to (all);
				
				list_1_classifier: list of other_ps::other_classifier_type applies to (all);
				list_5_classifier: list of list of list of list of list of other_ps::other_classifier_type applies to (all);
				
				classifier_constant: constant classifier => classifier (pkg1::s1);
				
				constant_chain_1: constant classifier_test::local_classifier_type => classifier_test::constant_chain_2;
				constant_chain_2: constant classifier_test::local_classifier_type => classifier_test::constant_chain_3;
				constant_chain_3: constant classifier_test::local_classifier_type => classifier (pkg1::t1);
				
				list_1_classifier_constant: constant list of classifier_test::local_classifier_type => (
					classifier_test::constant_chain_1,
					classifier (pkg1::d1)
				);
				
				list_5_classifier_constant: constant list of list of list of list of list of classifier => ((((
					(classifier (pkg1::s1)),
					()
				))));
			end classifier_test;
		'''
		val classifierTestClass = '''
			package classifiertest;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.eclipse.emf.ecore.EObject;
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.Classifier;
			import org.osate.aadl2.ClassifierValue;
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
			
			public final class ClassifierTest {
				public static final String CLASSIFIER_TEST__NAME = "classifier_test";
				
				private ClassifierTest() {}
				
				// Lookup methods for classifier_test::owned_classifier
				
				public static final String OWNED_CLASSIFIER__NAME = "owned_classifier";
				
				public static boolean acceptsOwnedClassifier(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getOwnedClassifier_Property(lookupContext));
				}
				
				public static Optional<Classifier> getOwnedClassifier(NamedElement lookupContext) {
					return getOwnedClassifier(lookupContext, Optional.empty());
				}
				
				public static Optional<Classifier> getOwnedClassifier(NamedElement lookupContext, Mode mode) {
					return getOwnedClassifier(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Classifier> getOwnedClassifier(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getOwnedClassifier_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ClassifierValue) resolved).getClassifier());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getOwnedClassifier_Property(EObject lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + OWNED_CLASSIFIER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getOwnedClassifier_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getOwnedClassifier_Property(lookupContext));
				}
				
				// Lookup methods for classifier_test::referenced_classifier_local
				
				public static final String REFERENCED_CLASSIFIER_LOCAL__NAME = "referenced_classifier_local";
				
				public static boolean acceptsReferencedClassifierLocal(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedClassifierLocal_Property(lookupContext));
				}
				
				public static Optional<Classifier> getReferencedClassifierLocal(NamedElement lookupContext) {
					return getReferencedClassifierLocal(lookupContext, Optional.empty());
				}
				
				public static Optional<Classifier> getReferencedClassifierLocal(NamedElement lookupContext, Mode mode) {
					return getReferencedClassifierLocal(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Classifier> getReferencedClassifierLocal(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedClassifierLocal_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ClassifierValue) resolved).getClassifier());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getReferencedClassifierLocal_Property(EObject lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + REFERENCED_CLASSIFIER_LOCAL__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedClassifierLocal_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedClassifierLocal_Property(lookupContext));
				}
				
				// Lookup methods for classifier_test::referenced_classifier_other
				
				public static final String REFERENCED_CLASSIFIER_OTHER__NAME = "referenced_classifier_other";
				
				public static boolean acceptsReferencedClassifierOther(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedClassifierOther_Property(lookupContext));
				}
				
				public static Optional<Classifier> getReferencedClassifierOther(NamedElement lookupContext) {
					return getReferencedClassifierOther(lookupContext, Optional.empty());
				}
				
				public static Optional<Classifier> getReferencedClassifierOther(NamedElement lookupContext, Mode mode) {
					return getReferencedClassifierOther(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Classifier> getReferencedClassifierOther(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedClassifierOther_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ClassifierValue) resolved).getClassifier());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getReferencedClassifierOther_Property(EObject lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + REFERENCED_CLASSIFIER_OTHER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedClassifierOther_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedClassifierOther_Property(lookupContext));
				}
				
				// Lookup methods for classifier_test::list_1_classifier
				
				public static final String LIST_1_CLASSIFIER__NAME = "list_1_classifier";
				
				public static boolean acceptsList1Classifier(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1Classifier_Property(lookupContext));
				}
				
				public static Optional<List<Classifier>> getList1Classifier(NamedElement lookupContext) {
					return getList1Classifier(lookupContext, Optional.empty());
				}
				
				public static Optional<List<Classifier>> getList1Classifier(NamedElement lookupContext, Mode mode) {
					return getList1Classifier(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<Classifier>> getList1Classifier(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1Classifier_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ClassifierValue) resolved1).getClassifier();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList1Classifier_Property(EObject lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + LIST_1_CLASSIFIER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1Classifier_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1Classifier_Property(lookupContext));
				}
				
				// Lookup methods for classifier_test::list_5_classifier
				
				public static final String LIST_5_CLASSIFIER__NAME = "list_5_classifier";
				
				public static boolean acceptsList5Classifier(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList5Classifier_Property(lookupContext));
				}
				
				public static Optional<List<List<List<List<List<Classifier>>>>>> getList5Classifier(NamedElement lookupContext) {
					return getList5Classifier(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List<List<Classifier>>>>>> getList5Classifier(NamedElement lookupContext, Mode mode) {
					return getList5Classifier(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List<List<Classifier>>>>>> getList5Classifier(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList5Classifier_Property(lookupContext);
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
											return ((ClassifierValue) resolved5).getClassifier();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList5Classifier_Property(EObject lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + LIST_5_CLASSIFIER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList5Classifier_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList5Classifier_Property(lookupContext));
				}
				
				// Lookup methods for classifier_test::classifier_constant
				
				public static final String CLASSIFIER_CONSTANT__NAME = "classifier_constant";
				
				public static Classifier getClassifierConstant(EObject lookupContext) {
					PropertyConstant constant = getClassifierConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ClassifierValue) resolved).getClassifier();
				}
				
				public static PropertyConstant getClassifierConstant_PropertyConstant(EObject lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + CLASSIFIER_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for classifier_test::constant_chain_1
				
				public static final String CONSTANT_CHAIN_1__NAME = "constant_chain_1";
				
				public static Classifier getConstantChain1(EObject lookupContext) {
					PropertyConstant constant = getConstantChain1_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ClassifierValue) resolved).getClassifier();
				}
				
				public static PropertyConstant getConstantChain1_PropertyConstant(EObject lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + CONSTANT_CHAIN_1__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for classifier_test::constant_chain_2
				
				public static final String CONSTANT_CHAIN_2__NAME = "constant_chain_2";
				
				public static Classifier getConstantChain2(EObject lookupContext) {
					PropertyConstant constant = getConstantChain2_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ClassifierValue) resolved).getClassifier();
				}
				
				public static PropertyConstant getConstantChain2_PropertyConstant(EObject lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + CONSTANT_CHAIN_2__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for classifier_test::constant_chain_3
				
				public static final String CONSTANT_CHAIN_3__NAME = "constant_chain_3";
				
				public static Classifier getConstantChain3(EObject lookupContext) {
					PropertyConstant constant = getConstantChain3_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ClassifierValue) resolved).getClassifier();
				}
				
				public static PropertyConstant getConstantChain3_PropertyConstant(EObject lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + CONSTANT_CHAIN_3__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for classifier_test::list_1_classifier_constant
				
				public static final String LIST_1_CLASSIFIER_CONSTANT__NAME = "list_1_classifier_constant";
				
				public static List<Classifier> getList1ClassifierConstant(EObject lookupContext) {
					PropertyConstant constant = getList1ClassifierConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return ((ClassifierValue) resolved1).getClassifier();
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1ClassifierConstant_PropertyConstant(EObject lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + LIST_1_CLASSIFIER_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for classifier_test::list_5_classifier_constant
				
				public static final String LIST_5_CLASSIFIER_CONSTANT__NAME = "list_5_classifier_constant";
				
				public static List<List<List<List<List<Classifier>>>>> getList5ClassifierConstant(EObject lookupContext) {
					PropertyConstant constant = getList5ClassifierConstant_PropertyConstant(lookupContext);
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
										return ((ClassifierValue) resolved5).getClassifier();
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList5ClassifierConstant_PropertyConstant(EObject lookupContext) {
					String name = CLASSIFIER_TEST__NAME + "::" + LIST_5_CLASSIFIER_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(classifierTest, otherPs, pkg1))
		assertEquals("src-gen/classifiertest", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("ClassifierTest.java", results.classes.head.fileName)
		assertEquals(classifierTestClass.toString, results.classes.head.contents)
	}
}