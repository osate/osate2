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

/** Verifies exact generated Java for integer no units. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class IntegerNoUnitsTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testIntegerNoUnits() throws Exception {
		var otherPs = """
				property set other_ps is
				\tother_integer_no_units_type: type aadlinteger;
				end other_ps;
				""";
		var integerNoUnitsTest = """
				property set integer_no_units_test is
				\twith other_ps;
				\t
				\tlocal_integer_type: type aadlinteger;
				\t
				\towned_integer: aadlinteger applies to (all);
				\treferenced_integer_local: integer_no_units_test::local_integer_type applies to (all);
				\treferenced_integer_other: other_ps::other_integer_no_units_type applies to (all);
				\t
				\tlist_1_integer: list of other_ps::other_integer_no_units_type applies to (all);
				\tlist_5_integer: list of list of list of list of list of other_ps::other_integer_no_units_type applies to (all);
				\t
				\tinteger_constant: constant aadlinteger => 1;
				\t
				\tlist_1_integer_constant: constant list of aadlinteger => (integer_no_units_test::integer_constant, 2);
				\tlist_5_integer_constant: constant list of list of list of list of list of aadlinteger => ((((
				\t\t(3, 4, 5),
				\t\t()
				\t))));
				end integer_no_units_test;
				""";
		var integerNoUnitsTestClass = """
				package integernounitstest;

				import java.util.List;
				import java.util.Optional;
				import java.util.OptionalLong;

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
				\tpublic static final String INTEGER_NO_UNITS_TEST__NAME = "integer_no_units_test";

				\tprivate IntegerNoUnitsTest() {}

				\t// Lookup methods for integer_no_units_test::owned_integer

				\tpublic static final String OWNED_INTEGER__NAME = "owned_integer";

				\tpublic static boolean acceptsOwnedInteger(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getOwnedInteger_Property(lookupContext));
				\t}

				\tpublic static OptionalLong getOwnedInteger(NamedElement lookupContext) {
				\t\treturn getOwnedInteger(lookupContext, Optional.empty());
				\t}

				\tpublic static OptionalLong getOwnedInteger(NamedElement lookupContext, Mode mode) {
				\t\treturn getOwnedInteger(lookupContext, Optional.of(mode));
				\t}

				\tpublic static OptionalLong getOwnedInteger(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getOwnedInteger_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn OptionalLong.of(((IntegerLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn OptionalLong.empty();
				\t\t}
				\t}

				\tpublic static Property getOwnedInteger_Property(EObject lookupContext) {
				\t\tvar name = INTEGER_NO_UNITS_TEST__NAME + "::" + OWNED_INTEGER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getOwnedInteger_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getOwnedInteger_Property(lookupContext));
				\t}

				\t// Lookup methods for integer_no_units_test::referenced_integer_local

				\tpublic static final String REFERENCED_INTEGER_LOCAL__NAME = "referenced_integer_local";

				\tpublic static boolean acceptsReferencedIntegerLocal(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedIntegerLocal_Property(lookupContext));
				\t}

				\tpublic static OptionalLong getReferencedIntegerLocal(NamedElement lookupContext) {
				\t\treturn getReferencedIntegerLocal(lookupContext, Optional.empty());
				\t}

				\tpublic static OptionalLong getReferencedIntegerLocal(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedIntegerLocal(lookupContext, Optional.of(mode));
				\t}

				\tpublic static OptionalLong getReferencedIntegerLocal(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedIntegerLocal_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn OptionalLong.of(((IntegerLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn OptionalLong.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedIntegerLocal_Property(EObject lookupContext) {
				\t\tvar name = INTEGER_NO_UNITS_TEST__NAME + "::" + REFERENCED_INTEGER_LOCAL__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedIntegerLocal_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedIntegerLocal_Property(lookupContext));
				\t}

				\t// Lookup methods for integer_no_units_test::referenced_integer_other

				\tpublic static final String REFERENCED_INTEGER_OTHER__NAME = "referenced_integer_other";

				\tpublic static boolean acceptsReferencedIntegerOther(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedIntegerOther_Property(lookupContext));
				\t}

				\tpublic static OptionalLong getReferencedIntegerOther(NamedElement lookupContext) {
				\t\treturn getReferencedIntegerOther(lookupContext, Optional.empty());
				\t}

				\tpublic static OptionalLong getReferencedIntegerOther(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedIntegerOther(lookupContext, Optional.of(mode));
				\t}

				\tpublic static OptionalLong getReferencedIntegerOther(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedIntegerOther_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn OptionalLong.of(((IntegerLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn OptionalLong.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedIntegerOther_Property(EObject lookupContext) {
				\t\tvar name = INTEGER_NO_UNITS_TEST__NAME + "::" + REFERENCED_INTEGER_OTHER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedIntegerOther_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedIntegerOther_Property(lookupContext));
				\t}

				\t// Lookup methods for integer_no_units_test::list_1_integer

				\tpublic static final String LIST_1_INTEGER__NAME = "list_1_integer";

				\tpublic static boolean acceptsList1Integer(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1Integer_Property(lookupContext));
				\t}

				\tpublic static Optional<List<Long>> getList1Integer(NamedElement lookupContext) {
				\t\treturn getList1Integer(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<Long>> getList1Integer(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1Integer(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<Long>> getList1Integer(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1Integer_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((IntegerLiteral) resolved1).getValue();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1Integer_Property(EObject lookupContext) {
				\t\tvar name = INTEGER_NO_UNITS_TEST__NAME + "::" + LIST_1_INTEGER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1Integer_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1Integer_Property(lookupContext));
				\t}

				\t// Lookup methods for integer_no_units_test::list_5_integer

				\tpublic static final String LIST_5_INTEGER__NAME = "list_5_integer";

				\tpublic static boolean acceptsList5Integer(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList5Integer_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<List<List<Long>>>>>> getList5Integer(NamedElement lookupContext) {
				\t\treturn getList5Integer(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<List<List<Long>>>>>> getList5Integer(NamedElement lookupContext, Mode mode) {
				\t\treturn getList5Integer(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<List<List<Long>>>>>> getList5Integer(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList5Integer_Property(lookupContext);
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
				\t\t\t\t\t\t\t\treturn ((IntegerLiteral) resolved5).getValue();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList5Integer_Property(EObject lookupContext) {
				\t\tvar name = INTEGER_NO_UNITS_TEST__NAME + "::" + LIST_5_INTEGER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList5Integer_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList5Integer_Property(lookupContext));
				\t}

				\t// Lookup methods for integer_no_units_test::integer_constant

				\tpublic static final String INTEGER_CONSTANT__NAME = "integer_constant";

				\tpublic static long getIntegerConstant(EObject lookupContext) {
				\t\tvar constant = getIntegerConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((IntegerLiteral) resolved).getValue();
				\t}

				\tpublic static PropertyConstant getIntegerConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = INTEGER_NO_UNITS_TEST__NAME + "::" + INTEGER_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for integer_no_units_test::list_1_integer_constant

				\tpublic static final String LIST_1_INTEGER_CONSTANT__NAME = "list_1_integer_constant";

				\tpublic static List<Long> getList1IntegerConstant(EObject lookupContext) {
				\t\tvar constant = getList1IntegerConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn ((IntegerLiteral) resolved1).getValue();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1IntegerConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = INTEGER_NO_UNITS_TEST__NAME + "::" + LIST_1_INTEGER_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for integer_no_units_test::list_5_integer_constant

				\tpublic static final String LIST_5_INTEGER_CONSTANT__NAME = "list_5_integer_constant";

				\tpublic static List<List<List<List<List<Long>>>>> getList5IntegerConstant(EObject lookupContext) {
				\t\tvar constant = getList5IntegerConstant_PropertyConstant(lookupContext);
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
				\t\t\t\t\t\t\treturn ((IntegerLiteral) resolved5).getValue();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList5IntegerConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = INTEGER_NO_UNITS_TEST__NAME + "::" + LIST_5_INTEGER_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(integerNoUnitsTest, otherPs));
		assertEquals("src-gen/integernounitstest", results.getPackagePath());
		assertEquals(1, results.getClasses().size());

		assertEquals("IntegerNoUnitsTest.java", results.getClasses().getFirst().getFileName());
		assertEquals(integerNoUnitsTestClass, results.getClasses().getFirst().getContents());
	}
}
