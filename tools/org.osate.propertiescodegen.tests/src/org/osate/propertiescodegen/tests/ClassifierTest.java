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

/** Verifies exact generated Java for classifier. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ClassifierTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testClassifier() throws Exception {
		var otherPs = """
				property set other_ps is
				\tother_classifier_type: type classifier;
				end other_ps;
				""";
		var pkg1 = """
				package pkg1
				public
				\tsystem s1
				\tend s1;

				\tthread t1
				\tend t1;

				\tdata d1
				\tend d1;
				end pkg1;
				""";
		var classifierTest = """
				property set classifier_test is
				\twith other_ps;
				\twith pkg1;
				\t
				\tlocal_classifier_type: type classifier;
				\t
				\towned_classifier: classifier applies to (all);
				\treferenced_classifier_local: classifier_test::local_classifier_type applies to (all);
				\treferenced_classifier_other: other_ps::other_classifier_type applies to (all);
				\t
				\tlist_1_classifier: list of other_ps::other_classifier_type applies to (all);
				\tlist_5_classifier: list of list of list of list of list of other_ps::other_classifier_type applies to (all);
				\t
				\tclassifier_constant: constant classifier => classifier (pkg1::s1);
				\t
				\tconstant_chain_1: constant classifier_test::local_classifier_type => classifier_test::constant_chain_2;
				\tconstant_chain_2: constant classifier_test::local_classifier_type => classifier_test::constant_chain_3;
				\tconstant_chain_3: constant classifier_test::local_classifier_type => classifier (pkg1::t1);
				\t
				\tlist_1_classifier_constant: constant list of classifier_test::local_classifier_type => (
				\t\tclassifier_test::constant_chain_1,
				\t\tclassifier (pkg1::d1)
				\t);
				\t
				\tlist_5_classifier_constant: constant list of list of list of list of list of classifier => ((((
				\t\t(classifier (pkg1::s1)),
				\t\t()
				\t))));
				end classifier_test;
				""";
		var classifierTestClass = """
				package classifiertest;

				import java.util.List;
				import java.util.Optional;

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
				\tpublic static final String CLASSIFIER_TEST__NAME = "classifier_test";

				\tprivate ClassifierTest() {}

				\t// Lookup methods for classifier_test::owned_classifier

				\tpublic static final String OWNED_CLASSIFIER__NAME = "owned_classifier";

				\tpublic static boolean acceptsOwnedClassifier(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getOwnedClassifier_Property(lookupContext));
				\t}

				\tpublic static Optional<Classifier> getOwnedClassifier(NamedElement lookupContext) {
				\t\treturn getOwnedClassifier(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<Classifier> getOwnedClassifier(NamedElement lookupContext, Mode mode) {
				\t\treturn getOwnedClassifier(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<Classifier> getOwnedClassifier(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getOwnedClassifier_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ClassifierValue) resolved).getClassifier());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getOwnedClassifier_Property(EObject lookupContext) {
				\t\tvar name = CLASSIFIER_TEST__NAME + "::" + OWNED_CLASSIFIER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getOwnedClassifier_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getOwnedClassifier_Property(lookupContext));
				\t}

				\t// Lookup methods for classifier_test::referenced_classifier_local

				\tpublic static final String REFERENCED_CLASSIFIER_LOCAL__NAME = "referenced_classifier_local";

				\tpublic static boolean acceptsReferencedClassifierLocal(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedClassifierLocal_Property(lookupContext));
				\t}

				\tpublic static Optional<Classifier> getReferencedClassifierLocal(NamedElement lookupContext) {
				\t\treturn getReferencedClassifierLocal(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<Classifier> getReferencedClassifierLocal(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedClassifierLocal(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<Classifier> getReferencedClassifierLocal(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedClassifierLocal_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ClassifierValue) resolved).getClassifier());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedClassifierLocal_Property(EObject lookupContext) {
				\t\tvar name = CLASSIFIER_TEST__NAME + "::" + REFERENCED_CLASSIFIER_LOCAL__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedClassifierLocal_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedClassifierLocal_Property(lookupContext));
				\t}

				\t// Lookup methods for classifier_test::referenced_classifier_other

				\tpublic static final String REFERENCED_CLASSIFIER_OTHER__NAME = "referenced_classifier_other";

				\tpublic static boolean acceptsReferencedClassifierOther(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedClassifierOther_Property(lookupContext));
				\t}

				\tpublic static Optional<Classifier> getReferencedClassifierOther(NamedElement lookupContext) {
				\t\treturn getReferencedClassifierOther(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<Classifier> getReferencedClassifierOther(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedClassifierOther(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<Classifier> getReferencedClassifierOther(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedClassifierOther_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ClassifierValue) resolved).getClassifier());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedClassifierOther_Property(EObject lookupContext) {
				\t\tvar name = CLASSIFIER_TEST__NAME + "::" + REFERENCED_CLASSIFIER_OTHER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedClassifierOther_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedClassifierOther_Property(lookupContext));
				\t}

				\t// Lookup methods for classifier_test::list_1_classifier

				\tpublic static final String LIST_1_CLASSIFIER__NAME = "list_1_classifier";

				\tpublic static boolean acceptsList1Classifier(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1Classifier_Property(lookupContext));
				\t}

				\tpublic static Optional<List<Classifier>> getList1Classifier(NamedElement lookupContext) {
				\t\treturn getList1Classifier(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<Classifier>> getList1Classifier(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1Classifier(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<Classifier>> getList1Classifier(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1Classifier_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((ClassifierValue) resolved1).getClassifier();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1Classifier_Property(EObject lookupContext) {
				\t\tvar name = CLASSIFIER_TEST__NAME + "::" + LIST_1_CLASSIFIER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1Classifier_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1Classifier_Property(lookupContext));
				\t}

				\t// Lookup methods for classifier_test::list_5_classifier

				\tpublic static final String LIST_5_CLASSIFIER__NAME = "list_5_classifier";

				\tpublic static boolean acceptsList5Classifier(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList5Classifier_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<List<List<Classifier>>>>>> getList5Classifier(NamedElement lookupContext) {
				\t\treturn getList5Classifier(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<List<List<Classifier>>>>>> getList5Classifier(NamedElement lookupContext, Mode mode) {
				\t\treturn getList5Classifier(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<List<List<Classifier>>>>>> getList5Classifier(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList5Classifier_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
				\t\t\t\t\t\t\treturn ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
				\t\t\t\t\t\t\t\tvar resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
				\t\t\t\t\t\t\t\treturn ((ClassifierValue) resolved5).getClassifier();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList5Classifier_Property(EObject lookupContext) {
				\t\tvar name = CLASSIFIER_TEST__NAME + "::" + LIST_5_CLASSIFIER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList5Classifier_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList5Classifier_Property(lookupContext));
				\t}

				\t// Lookup methods for classifier_test::classifier_constant

				\tpublic static final String CLASSIFIER_CONSTANT__NAME = "classifier_constant";

				\tpublic static Classifier getClassifierConstant(EObject lookupContext) {
				\t\tvar constant = getClassifierConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ClassifierValue) resolved).getClassifier();
				\t}

				\tpublic static PropertyConstant getClassifierConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = CLASSIFIER_TEST__NAME + "::" + CLASSIFIER_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for classifier_test::constant_chain_1

				\tpublic static final String CONSTANT_CHAIN_1__NAME = "constant_chain_1";

				\tpublic static Classifier getConstantChain1(EObject lookupContext) {
				\t\tvar constant = getConstantChain1_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ClassifierValue) resolved).getClassifier();
				\t}

				\tpublic static PropertyConstant getConstantChain1_PropertyConstant(EObject lookupContext) {
				\t\tvar name = CLASSIFIER_TEST__NAME + "::" + CONSTANT_CHAIN_1__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for classifier_test::constant_chain_2

				\tpublic static final String CONSTANT_CHAIN_2__NAME = "constant_chain_2";

				\tpublic static Classifier getConstantChain2(EObject lookupContext) {
				\t\tvar constant = getConstantChain2_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ClassifierValue) resolved).getClassifier();
				\t}

				\tpublic static PropertyConstant getConstantChain2_PropertyConstant(EObject lookupContext) {
				\t\tvar name = CLASSIFIER_TEST__NAME + "::" + CONSTANT_CHAIN_2__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for classifier_test::constant_chain_3

				\tpublic static final String CONSTANT_CHAIN_3__NAME = "constant_chain_3";

				\tpublic static Classifier getConstantChain3(EObject lookupContext) {
				\t\tvar constant = getConstantChain3_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ClassifierValue) resolved).getClassifier();
				\t}

				\tpublic static PropertyConstant getConstantChain3_PropertyConstant(EObject lookupContext) {
				\t\tvar name = CLASSIFIER_TEST__NAME + "::" + CONSTANT_CHAIN_3__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for classifier_test::list_1_classifier_constant

				\tpublic static final String LIST_1_CLASSIFIER_CONSTANT__NAME = "list_1_classifier_constant";

				\tpublic static List<Classifier> getList1ClassifierConstant(EObject lookupContext) {
				\t\tvar constant = getList1ClassifierConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn ((ClassifierValue) resolved1).getClassifier();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1ClassifierConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = CLASSIFIER_TEST__NAME + "::" + LIST_1_CLASSIFIER_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for classifier_test::list_5_classifier_constant

				\tpublic static final String LIST_5_CLASSIFIER_CONSTANT__NAME = "list_5_classifier_constant";

				\tpublic static List<List<List<List<List<Classifier>>>>> getList5ClassifierConstant(EObject lookupContext) {
				\t\tvar constant = getList5ClassifierConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3);
				\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4);
				\t\t\t\t\t\treturn ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
				\t\t\t\t\t\t\tvar resolved5 = CodeGenUtil.resolveNamedValue(element5);
				\t\t\t\t\t\t\treturn ((ClassifierValue) resolved5).getClassifier();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList5ClassifierConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = CLASSIFIER_TEST__NAME + "::" + LIST_5_CLASSIFIER_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(classifierTest, otherPs, pkg1));
		assertEquals("src-gen/classifiertest", results.getPackagePath());
		assertEquals(1, results.getClasses().size());

		assertEquals("ClassifierTest.java", results.getClasses().getFirst().getFileName());
		assertEquals(classifierTestClass, results.getClasses().getFirst().getContents());
	}
}
