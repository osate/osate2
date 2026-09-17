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

/** Verifies exact generated Java for reference. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ReferenceTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testReference() throws Exception {
		var otherPs = """
				property set other_ps is
				\tother_boolean_type: type aadlboolean;
				\tother_string_type: type aadlstring;
				\tother_classifier_type: type classifier;
				\tother_integer_no_units_type: type aadlinteger;
				\tother_real_no_units_type: type aadlreal;
				\tother_reference_type: type reference;
				end other_ps;
				""";
		var referenceTest = """
				property set reference_test is
				\twith other_ps;
				\t
				\tlocal_reference_type: type reference;
				\t
				\towned_reference: reference applies to (all);
				\treferenced_reference_local: reference_test::local_reference_type applies to (all);
				\treferenced_reference_other: other_ps::other_reference_type applies to (all);
				\t
				\tlist_1_reference: list of other_ps::other_reference_type applies to (all);
				\tlist_5_reference: list of list of list of list of list of other_ps::other_reference_type applies to (all);
				end reference_test;
				""";
		var referenceTestClass = """
				package referencetest;

				import java.util.List;
				import java.util.Optional;

				import org.eclipse.emf.ecore.EObject;
				import org.osate.aadl2.Aadl2Package;
				import org.osate.aadl2.ListValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.Property;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.instance.InstanceObject;
				import org.osate.aadl2.instance.InstanceReferenceValue;
				import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
				import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;

				public final class ReferenceTest {
				\tpublic static final String REFERENCE_TEST__NAME = "reference_test";

				\tprivate ReferenceTest() {}

				\t// Lookup methods for reference_test::owned_reference

				\tpublic static final String OWNED_REFERENCE__NAME = "owned_reference";

				\tpublic static boolean acceptsOwnedReference(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getOwnedReference_Property(lookupContext));
				\t}

				\tpublic static Optional<InstanceObject> getOwnedReference(NamedElement lookupContext) {
				\t\treturn getOwnedReference(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<InstanceObject> getOwnedReference(NamedElement lookupContext, Mode mode) {
				\t\treturn getOwnedReference(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<InstanceObject> getOwnedReference(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getOwnedReference_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getOwnedReference_Property(EObject lookupContext) {
				\t\tvar name = REFERENCE_TEST__NAME + "::" + OWNED_REFERENCE__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getOwnedReference_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getOwnedReference_Property(lookupContext));
				\t}

				\t// Lookup methods for reference_test::referenced_reference_local

				\tpublic static final String REFERENCED_REFERENCE_LOCAL__NAME = "referenced_reference_local";

				\tpublic static boolean acceptsReferencedReferenceLocal(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedReferenceLocal_Property(lookupContext));
				\t}

				\tpublic static Optional<InstanceObject> getReferencedReferenceLocal(NamedElement lookupContext) {
				\t\treturn getReferencedReferenceLocal(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<InstanceObject> getReferencedReferenceLocal(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedReferenceLocal(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<InstanceObject> getReferencedReferenceLocal(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedReferenceLocal_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedReferenceLocal_Property(EObject lookupContext) {
				\t\tvar name = REFERENCE_TEST__NAME + "::" + REFERENCED_REFERENCE_LOCAL__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedReferenceLocal_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedReferenceLocal_Property(lookupContext));
				\t}

				\t// Lookup methods for reference_test::referenced_reference_other

				\tpublic static final String REFERENCED_REFERENCE_OTHER__NAME = "referenced_reference_other";

				\tpublic static boolean acceptsReferencedReferenceOther(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedReferenceOther_Property(lookupContext));
				\t}

				\tpublic static Optional<InstanceObject> getReferencedReferenceOther(NamedElement lookupContext) {
				\t\treturn getReferencedReferenceOther(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<InstanceObject> getReferencedReferenceOther(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedReferenceOther(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<InstanceObject> getReferencedReferenceOther(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedReferenceOther_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedReferenceOther_Property(EObject lookupContext) {
				\t\tvar name = REFERENCE_TEST__NAME + "::" + REFERENCED_REFERENCE_OTHER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedReferenceOther_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedReferenceOther_Property(lookupContext));
				\t}

				\t// Lookup methods for reference_test::list_1_reference

				\tpublic static final String LIST_1_REFERENCE__NAME = "list_1_reference";

				\tpublic static boolean acceptsList1Reference(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1Reference_Property(lookupContext));
				\t}

				\tpublic static Optional<List<InstanceObject>> getList1Reference(NamedElement lookupContext) {
				\t\treturn getList1Reference(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<InstanceObject>> getList1Reference(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1Reference(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<InstanceObject>> getList1Reference(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1Reference_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1Reference_Property(EObject lookupContext) {
				\t\tvar name = REFERENCE_TEST__NAME + "::" + LIST_1_REFERENCE__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1Reference_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1Reference_Property(lookupContext));
				\t}

				\t// Lookup methods for reference_test::list_5_reference

				\tpublic static final String LIST_5_REFERENCE__NAME = "list_5_reference";

				\tpublic static boolean acceptsList5Reference(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList5Reference_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<List<List<InstanceObject>>>>>> getList5Reference(NamedElement lookupContext) {
				\t\treturn getList5Reference(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<List<List<InstanceObject>>>>>> getList5Reference(NamedElement lookupContext, Mode mode) {
				\t\treturn getList5Reference(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<List<List<InstanceObject>>>>>> getList5Reference(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList5Reference_Property(lookupContext);
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
				\t\t\t\t\t\t\t\treturn ((InstanceReferenceValue) resolved5).getReferencedInstanceObject();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList5Reference_Property(EObject lookupContext) {
				\t\tvar name = REFERENCE_TEST__NAME + "::" + LIST_5_REFERENCE__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList5Reference_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList5Reference_Property(lookupContext));
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(referenceTest, otherPs));
		assertEquals("src-gen/referencetest", results.getPackagePath());
		assertEquals(1, results.getClasses().size());

		assertEquals("ReferenceTest.java", results.getClasses().getFirst().getFileName());
		assertEquals(referenceTestClass, results.getClasses().getFirst().getContents());
	}
}
