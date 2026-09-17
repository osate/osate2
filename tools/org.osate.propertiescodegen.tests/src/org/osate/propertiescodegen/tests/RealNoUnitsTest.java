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

/** Verifies exact generated Java for real no units. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class RealNoUnitsTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testRealNoUnits() throws Exception {
		var otherPs = """
				property set other_ps is
				\tother_real_no_units_type: type aadlreal;
				end other_ps;
				""";
		var realNoUnitsTest = """
				property set real_no_units_test is
				\twith other_ps;
				\t
				\tlocal_real_type: type aadlreal;
				\t
				\towned_real: aadlreal applies to (all);
				\treferenced_real_local: real_no_units_test::local_real_type applies to (all);
				\treferenced_real_other: other_ps::other_real_no_units_type applies to (all);
				\t
				\tlist_1_real: list of other_ps::other_real_no_units_type applies to (all);
				\tlist_5_real: list of list of list of list of list of other_ps::other_real_no_units_type applies to (all);
				\t
				\treal_constant: constant aadlreal => 1.1;
				\t
				\tlist_1_real_constant: constant list of aadlreal => (real_no_units_test::real_constant, 2.2);
				\tlist_5_real_constant: constant list of list of list of list of list of aadlreal => ((((
				\t\t(3.3, 4.4, 5.5),
				\t\t()
				\t))));
				end real_no_units_test;
				""";
		var realNoUnitsTestClass = """
				package realnounitstest;

				import java.util.List;
				import java.util.Optional;
				import java.util.OptionalDouble;

				import org.eclipse.emf.ecore.EObject;
				import org.osate.aadl2.Aadl2Package;
				import org.osate.aadl2.ListValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.Property;
				import org.osate.aadl2.PropertyConstant;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RealLiteral;
				import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
				import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;

				public final class RealNoUnitsTest {
				\tpublic static final String REAL_NO_UNITS_TEST__NAME = "real_no_units_test";

				\tprivate RealNoUnitsTest() {}

				\t// Lookup methods for real_no_units_test::owned_real

				\tpublic static final String OWNED_REAL__NAME = "owned_real";

				\tpublic static boolean acceptsOwnedReal(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getOwnedReal_Property(lookupContext));
				\t}

				\tpublic static OptionalDouble getOwnedReal(NamedElement lookupContext) {
				\t\treturn getOwnedReal(lookupContext, Optional.empty());
				\t}

				\tpublic static OptionalDouble getOwnedReal(NamedElement lookupContext, Mode mode) {
				\t\treturn getOwnedReal(lookupContext, Optional.of(mode));
				\t}

				\tpublic static OptionalDouble getOwnedReal(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getOwnedReal_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn OptionalDouble.of(((RealLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn OptionalDouble.empty();
				\t\t}
				\t}

				\tpublic static Property getOwnedReal_Property(EObject lookupContext) {
				\t\tvar name = REAL_NO_UNITS_TEST__NAME + "::" + OWNED_REAL__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getOwnedReal_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getOwnedReal_Property(lookupContext));
				\t}

				\t// Lookup methods for real_no_units_test::referenced_real_local

				\tpublic static final String REFERENCED_REAL_LOCAL__NAME = "referenced_real_local";

				\tpublic static boolean acceptsReferencedRealLocal(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedRealLocal_Property(lookupContext));
				\t}

				\tpublic static OptionalDouble getReferencedRealLocal(NamedElement lookupContext) {
				\t\treturn getReferencedRealLocal(lookupContext, Optional.empty());
				\t}

				\tpublic static OptionalDouble getReferencedRealLocal(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedRealLocal(lookupContext, Optional.of(mode));
				\t}

				\tpublic static OptionalDouble getReferencedRealLocal(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedRealLocal_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn OptionalDouble.of(((RealLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn OptionalDouble.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedRealLocal_Property(EObject lookupContext) {
				\t\tvar name = REAL_NO_UNITS_TEST__NAME + "::" + REFERENCED_REAL_LOCAL__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedRealLocal_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedRealLocal_Property(lookupContext));
				\t}

				\t// Lookup methods for real_no_units_test::referenced_real_other

				\tpublic static final String REFERENCED_REAL_OTHER__NAME = "referenced_real_other";

				\tpublic static boolean acceptsReferencedRealOther(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedRealOther_Property(lookupContext));
				\t}

				\tpublic static OptionalDouble getReferencedRealOther(NamedElement lookupContext) {
				\t\treturn getReferencedRealOther(lookupContext, Optional.empty());
				\t}

				\tpublic static OptionalDouble getReferencedRealOther(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedRealOther(lookupContext, Optional.of(mode));
				\t}

				\tpublic static OptionalDouble getReferencedRealOther(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedRealOther_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn OptionalDouble.of(((RealLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn OptionalDouble.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedRealOther_Property(EObject lookupContext) {
				\t\tvar name = REAL_NO_UNITS_TEST__NAME + "::" + REFERENCED_REAL_OTHER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedRealOther_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedRealOther_Property(lookupContext));
				\t}

				\t// Lookup methods for real_no_units_test::list_1_real

				\tpublic static final String LIST_1_REAL__NAME = "list_1_real";

				\tpublic static boolean acceptsList1Real(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1Real_Property(lookupContext));
				\t}

				\tpublic static Optional<List<Double>> getList1Real(NamedElement lookupContext) {
				\t\treturn getList1Real(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<Double>> getList1Real(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1Real(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<Double>> getList1Real(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1Real_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((RealLiteral) resolved1).getValue();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1Real_Property(EObject lookupContext) {
				\t\tvar name = REAL_NO_UNITS_TEST__NAME + "::" + LIST_1_REAL__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1Real_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1Real_Property(lookupContext));
				\t}

				\t// Lookup methods for real_no_units_test::list_5_real

				\tpublic static final String LIST_5_REAL__NAME = "list_5_real";

				\tpublic static boolean acceptsList5Real(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList5Real_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<List<List<Double>>>>>> getList5Real(NamedElement lookupContext) {
				\t\treturn getList5Real(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<List<List<Double>>>>>> getList5Real(NamedElement lookupContext, Mode mode) {
				\t\treturn getList5Real(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<List<List<Double>>>>>> getList5Real(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList5Real_Property(lookupContext);
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
				\t\t\t\t\t\t\t\treturn ((RealLiteral) resolved5).getValue();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList5Real_Property(EObject lookupContext) {
				\t\tvar name = REAL_NO_UNITS_TEST__NAME + "::" + LIST_5_REAL__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList5Real_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList5Real_Property(lookupContext));
				\t}

				\t// Lookup methods for real_no_units_test::real_constant

				\tpublic static final String REAL_CONSTANT__NAME = "real_constant";

				\tpublic static double getRealConstant(EObject lookupContext) {
				\t\tvar constant = getRealConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((RealLiteral) resolved).getValue();
				\t}

				\tpublic static PropertyConstant getRealConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = REAL_NO_UNITS_TEST__NAME + "::" + REAL_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for real_no_units_test::list_1_real_constant

				\tpublic static final String LIST_1_REAL_CONSTANT__NAME = "list_1_real_constant";

				\tpublic static List<Double> getList1RealConstant(EObject lookupContext) {
				\t\tvar constant = getList1RealConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn ((RealLiteral) resolved1).getValue();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1RealConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = REAL_NO_UNITS_TEST__NAME + "::" + LIST_1_REAL_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for real_no_units_test::list_5_real_constant

				\tpublic static final String LIST_5_REAL_CONSTANT__NAME = "list_5_real_constant";

				\tpublic static List<List<List<List<List<Double>>>>> getList5RealConstant(EObject lookupContext) {
				\t\tvar constant = getList5RealConstant_PropertyConstant(lookupContext);
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
				\t\t\t\t\t\t\treturn ((RealLiteral) resolved5).getValue();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList5RealConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = REAL_NO_UNITS_TEST__NAME + "::" + LIST_5_REAL_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(realNoUnitsTest, otherPs));
		assertEquals("src-gen/realnounitstest", results.getPackagePath());
		assertEquals(1, results.getClasses().size());

		assertEquals("RealNoUnitsTest.java", results.getClasses().getFirst().getFileName());
		assertEquals(realNoUnitsTestClass, results.getClasses().getFirst().getContents());
	}
}
