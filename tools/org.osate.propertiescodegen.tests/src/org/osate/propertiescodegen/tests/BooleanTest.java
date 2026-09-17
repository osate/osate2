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

/** Verifies exact generated Java for boolean. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class BooleanTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testBoolean() throws Exception {
		var otherPs = """
				property set other_ps is
				\tother_boolean_type: type aadlboolean;
				end other_ps;
				""";
		var booleanTest = """
				property set boolean_test is
				\twith other_ps;
				\t
				\tlocal_boolean_type: type aadlboolean;
				\t
				\towned_boolean: aadlboolean applies to (all);
				\treferenced_boolean_local: boolean_test::local_boolean_type applies to (all);
				\treferenced_boolean_other: other_ps::other_boolean_type applies to (all);
				\t
				\tlist_1_boolean: list of other_ps::other_boolean_type applies to (all);
				\tlist_5_boolean: list of list of list of list of list of other_ps::other_boolean_type applies to (all);
				\t
				\tboolean_constant: constant aadlboolean => true;
				\t
				\tlist_1_boolean_constant: constant list of aadlboolean => (boolean_test::boolean_constant, false);
				\tlist_5_boolean_constant: constant list of list of list of list of list of aadlboolean => ((((
				\t\t(true, false, true),
				\t\t()
				\t))));
				end boolean_test;
				""";
		var booleanTestClass = """
				package booleantest;

				import java.util.List;
				import java.util.Optional;

				import org.eclipse.emf.ecore.EObject;
				import org.osate.aadl2.Aadl2Package;
				import org.osate.aadl2.BooleanLiteral;
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

				public final class BooleanTest {
				\tpublic static final String BOOLEAN_TEST__NAME = "boolean_test";

				\tprivate BooleanTest() {}

				\t// Lookup methods for boolean_test::owned_boolean

				\tpublic static final String OWNED_BOOLEAN__NAME = "owned_boolean";

				\tpublic static boolean acceptsOwnedBoolean(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getOwnedBoolean_Property(lookupContext));
				\t}

				\tpublic static Optional<Boolean> getOwnedBoolean(NamedElement lookupContext) {
				\t\treturn getOwnedBoolean(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<Boolean> getOwnedBoolean(NamedElement lookupContext, Mode mode) {
				\t\treturn getOwnedBoolean(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<Boolean> getOwnedBoolean(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getOwnedBoolean_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((BooleanLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getOwnedBoolean_Property(EObject lookupContext) {
				\t\tvar name = BOOLEAN_TEST__NAME + "::" + OWNED_BOOLEAN__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getOwnedBoolean_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getOwnedBoolean_Property(lookupContext));
				\t}

				\t// Lookup methods for boolean_test::referenced_boolean_local

				\tpublic static final String REFERENCED_BOOLEAN_LOCAL__NAME = "referenced_boolean_local";

				\tpublic static boolean acceptsReferencedBooleanLocal(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedBooleanLocal_Property(lookupContext));
				\t}

				\tpublic static Optional<Boolean> getReferencedBooleanLocal(NamedElement lookupContext) {
				\t\treturn getReferencedBooleanLocal(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<Boolean> getReferencedBooleanLocal(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedBooleanLocal(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<Boolean> getReferencedBooleanLocal(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedBooleanLocal_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((BooleanLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedBooleanLocal_Property(EObject lookupContext) {
				\t\tvar name = BOOLEAN_TEST__NAME + "::" + REFERENCED_BOOLEAN_LOCAL__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedBooleanLocal_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedBooleanLocal_Property(lookupContext));
				\t}

				\t// Lookup methods for boolean_test::referenced_boolean_other

				\tpublic static final String REFERENCED_BOOLEAN_OTHER__NAME = "referenced_boolean_other";

				\tpublic static boolean acceptsReferencedBooleanOther(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedBooleanOther_Property(lookupContext));
				\t}

				\tpublic static Optional<Boolean> getReferencedBooleanOther(NamedElement lookupContext) {
				\t\treturn getReferencedBooleanOther(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<Boolean> getReferencedBooleanOther(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedBooleanOther(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<Boolean> getReferencedBooleanOther(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedBooleanOther_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((BooleanLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedBooleanOther_Property(EObject lookupContext) {
				\t\tvar name = BOOLEAN_TEST__NAME + "::" + REFERENCED_BOOLEAN_OTHER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedBooleanOther_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedBooleanOther_Property(lookupContext));
				\t}

				\t// Lookup methods for boolean_test::list_1_boolean

				\tpublic static final String LIST_1_BOOLEAN__NAME = "list_1_boolean";

				\tpublic static boolean acceptsList1Boolean(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1Boolean_Property(lookupContext));
				\t}

				\tpublic static Optional<List<Boolean>> getList1Boolean(NamedElement lookupContext) {
				\t\treturn getList1Boolean(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<Boolean>> getList1Boolean(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1Boolean(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<Boolean>> getList1Boolean(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1Boolean_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((BooleanLiteral) resolved1).getValue();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1Boolean_Property(EObject lookupContext) {
				\t\tvar name = BOOLEAN_TEST__NAME + "::" + LIST_1_BOOLEAN__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1Boolean_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1Boolean_Property(lookupContext));
				\t}

				\t// Lookup methods for boolean_test::list_5_boolean

				\tpublic static final String LIST_5_BOOLEAN__NAME = "list_5_boolean";

				\tpublic static boolean acceptsList5Boolean(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList5Boolean_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<List<List<Boolean>>>>>> getList5Boolean(NamedElement lookupContext) {
				\t\treturn getList5Boolean(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<List<List<Boolean>>>>>> getList5Boolean(NamedElement lookupContext, Mode mode) {
				\t\treturn getList5Boolean(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<List<List<Boolean>>>>>> getList5Boolean(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList5Boolean_Property(lookupContext);
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
				\t\t\t\t\t\t\t\treturn ((BooleanLiteral) resolved5).getValue();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList5Boolean_Property(EObject lookupContext) {
				\t\tvar name = BOOLEAN_TEST__NAME + "::" + LIST_5_BOOLEAN__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList5Boolean_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList5Boolean_Property(lookupContext));
				\t}

				\t// Lookup methods for boolean_test::boolean_constant

				\tpublic static final String BOOLEAN_CONSTANT__NAME = "boolean_constant";

				\tpublic static boolean getBooleanConstant(EObject lookupContext) {
				\t\tvar constant = getBooleanConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((BooleanLiteral) resolved).getValue();
				\t}

				\tpublic static PropertyConstant getBooleanConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = BOOLEAN_TEST__NAME + "::" + BOOLEAN_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for boolean_test::list_1_boolean_constant

				\tpublic static final String LIST_1_BOOLEAN_CONSTANT__NAME = "list_1_boolean_constant";

				\tpublic static List<Boolean> getList1BooleanConstant(EObject lookupContext) {
				\t\tvar constant = getList1BooleanConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn ((BooleanLiteral) resolved1).getValue();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1BooleanConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = BOOLEAN_TEST__NAME + "::" + LIST_1_BOOLEAN_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for boolean_test::list_5_boolean_constant

				\tpublic static final String LIST_5_BOOLEAN_CONSTANT__NAME = "list_5_boolean_constant";

				\tpublic static List<List<List<List<List<Boolean>>>>> getList5BooleanConstant(EObject lookupContext) {
				\t\tvar constant = getList5BooleanConstant_PropertyConstant(lookupContext);
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
				\t\t\t\t\t\t\treturn ((BooleanLiteral) resolved5).getValue();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList5BooleanConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = BOOLEAN_TEST__NAME + "::" + LIST_5_BOOLEAN_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(booleanTest, otherPs));
		assertEquals("src-gen/booleantest", results.getPackagePath());
		assertEquals(1, results.getClasses().size());

		assertEquals("BooleanTest.java", results.getClasses().getFirst().getFileName());
		assertEquals(booleanTestClass, results.getClasses().getFirst().getContents());
	}
}
