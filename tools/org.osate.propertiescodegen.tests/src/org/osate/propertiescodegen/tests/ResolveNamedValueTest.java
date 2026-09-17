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

/** Verifies exact generated Java for resolve named value. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ResolveNamedValueTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testResolveNamedValue() throws Exception {
		var resolveNamedValueTest = """
				property set resolve_named_value_test is
				\tlength: type units (m);
				\t
				\tbool_const: constant aadlboolean => true;
				\tint_const_1: constant aadlinteger => 1;
				\tint_const_2: constant aadlinteger => 2;
				\tint_with_units_const_1: constant aadlinteger units resolve_named_value_test::length => 3m;
				\tint_with_units_const_2: constant aadlinteger units resolve_named_value_test::length => 4m;
				\treal_const_1: constant aadlreal => 5.5;
				\treal_const_2: constant aadlreal => 6.6;
				\treal_with_units_const_1: constant aadlreal units resolve_named_value_test::length => 7.7m;
				\treal_with_units_const_2: constant aadlreal units resolve_named_value_test::length => 8.8m;
				\tlist_1_int_const: constant list of aadlinteger => (resolve_named_value_test::int_const_1);
				\tlist_2_int_const: constant list of list of aadlinteger => (resolve_named_value_test::list_1_int_const);
				\tlist_3_int_const: constant list of list of list of aadlinteger => (resolve_named_value_test::list_2_int_const);
				\t
				\tint_def_1: aadlinteger applies to (all);
				\tint_def_2: aadlinteger applies to (all);
				\tlist_3_int_def: list of list of list of aadlinteger applies to (all);
				\tint_range_no_units_def: range of aadlinteger applies to (all);
				\tint_range_with_units_def: range of aadlinteger units resolve_named_value_test::length applies to (all);
				\treal_range_no_units_def: range of aadlreal applies to (all);
				\treal_range_with_units_def: range of aadlreal units resolve_named_value_test::length applies to (all);
				\trecord_def: record (
				\t\tbool_field: aadlboolean;
				\t\tint_field: aadlinteger;
				\t\treal_field: aadlreal;
				\t\tlist_3_int_field: list of list of list of aadlinteger;
				\t) applies to (all);
				end resolve_named_value_test;
				""";
		var resolveNamedValueTestClass = """
				package resolvenamedvaluetest;

				import java.util.List;
				import java.util.Optional;
				import java.util.OptionalLong;

				import org.eclipse.emf.ecore.EObject;
				import org.osate.aadl2.Aadl2Package;
				import org.osate.aadl2.BooleanLiteral;
				import org.osate.aadl2.IntegerLiteral;
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
				import org.osate.pluginsupport.properties.IntegerRange;
				import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
				import org.osate.pluginsupport.properties.IntegerWithUnits;
				import org.osate.pluginsupport.properties.RealRange;
				import org.osate.pluginsupport.properties.RealRangeWithUnits;
				import org.osate.pluginsupport.properties.RealWithUnits;

				public final class ResolveNamedValueTest {
				\tpublic static final String RESOLVE_NAMED_VALUE_TEST__NAME = "resolve_named_value_test";

				\tprivate ResolveNamedValueTest() {}

				\t// Lookup methods for resolve_named_value_test::int_def_1

				\tpublic static final String INT_DEF_1__NAME = "int_def_1";

				\tpublic static boolean acceptsIntDef1(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getIntDef1_Property(lookupContext));
				\t}

				\tpublic static OptionalLong getIntDef1(NamedElement lookupContext) {
				\t\treturn getIntDef1(lookupContext, Optional.empty());
				\t}

				\tpublic static OptionalLong getIntDef1(NamedElement lookupContext, Mode mode) {
				\t\treturn getIntDef1(lookupContext, Optional.of(mode));
				\t}

				\tpublic static OptionalLong getIntDef1(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getIntDef1_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn OptionalLong.of(((IntegerLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn OptionalLong.empty();
				\t\t}
				\t}

				\tpublic static Property getIntDef1_Property(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + INT_DEF_1__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getIntDef1_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getIntDef1_Property(lookupContext));
				\t}

				\t// Lookup methods for resolve_named_value_test::int_def_2

				\tpublic static final String INT_DEF_2__NAME = "int_def_2";

				\tpublic static boolean acceptsIntDef2(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getIntDef2_Property(lookupContext));
				\t}

				\tpublic static OptionalLong getIntDef2(NamedElement lookupContext) {
				\t\treturn getIntDef2(lookupContext, Optional.empty());
				\t}

				\tpublic static OptionalLong getIntDef2(NamedElement lookupContext, Mode mode) {
				\t\treturn getIntDef2(lookupContext, Optional.of(mode));
				\t}

				\tpublic static OptionalLong getIntDef2(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getIntDef2_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn OptionalLong.of(((IntegerLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn OptionalLong.empty();
				\t\t}
				\t}

				\tpublic static Property getIntDef2_Property(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + INT_DEF_2__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getIntDef2_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getIntDef2_Property(lookupContext));
				\t}

				\t// Lookup methods for resolve_named_value_test::list_3_int_def

				\tpublic static final String LIST_3_INT_DEF__NAME = "list_3_int_def";

				\tpublic static boolean acceptsList3IntDef(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList3IntDef_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<Long>>>> getList3IntDef(NamedElement lookupContext) {
				\t\treturn getList3IntDef(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<Long>>>> getList3IntDef(NamedElement lookupContext, Mode mode) {
				\t\treturn getList3IntDef(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<Long>>>> getList3IntDef(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList3IntDef_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\treturn ((IntegerLiteral) resolved3).getValue();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList3IntDef_Property(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + LIST_3_INT_DEF__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList3IntDef_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList3IntDef_Property(lookupContext));
				\t}

				\t// Lookup methods for resolve_named_value_test::int_range_no_units_def

				\tpublic static final String INT_RANGE_NO_UNITS_DEF__NAME = "int_range_no_units_def";

				\tpublic static boolean acceptsIntRangeNoUnitsDef(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getIntRangeNoUnitsDef_Property(lookupContext));
				\t}

				\tpublic static Optional<IntegerRange> getIntRangeNoUnitsDef(NamedElement lookupContext) {
				\t\treturn getIntRangeNoUnitsDef(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<IntegerRange> getIntRangeNoUnitsDef(NamedElement lookupContext, Mode mode) {
				\t\treturn getIntRangeNoUnitsDef(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<IntegerRange> getIntRangeNoUnitsDef(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getIntRangeNoUnitsDef_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new IntegerRange(resolved, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getIntRangeNoUnitsDef_Property(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + INT_RANGE_NO_UNITS_DEF__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getIntRangeNoUnitsDef_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getIntRangeNoUnitsDef_Property(lookupContext));
				\t}

				\t// Lookup methods for resolve_named_value_test::int_range_with_units_def

				\tpublic static final String INT_RANGE_WITH_UNITS_DEF__NAME = "int_range_with_units_def";

				\tpublic static boolean acceptsIntRangeWithUnitsDef(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getIntRangeWithUnitsDef_Property(lookupContext));
				\t}

				\tpublic static Optional<IntegerRangeWithUnits<Length>> getIntRangeWithUnitsDef(NamedElement lookupContext) {
				\t\treturn getIntRangeWithUnitsDef(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<IntegerRangeWithUnits<Length>> getIntRangeWithUnitsDef(NamedElement lookupContext, Mode mode) {
				\t\treturn getIntRangeWithUnitsDef(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<IntegerRangeWithUnits<Length>> getIntRangeWithUnitsDef(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getIntRangeWithUnitsDef_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new IntegerRangeWithUnits<>(resolved, Length.class, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getIntRangeWithUnitsDef_Property(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + INT_RANGE_WITH_UNITS_DEF__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getIntRangeWithUnitsDef_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getIntRangeWithUnitsDef_Property(lookupContext));
				\t}

				\t// Lookup methods for resolve_named_value_test::real_range_no_units_def

				\tpublic static final String REAL_RANGE_NO_UNITS_DEF__NAME = "real_range_no_units_def";

				\tpublic static boolean acceptsRealRangeNoUnitsDef(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRealRangeNoUnitsDef_Property(lookupContext));
				\t}

				\tpublic static Optional<RealRange> getRealRangeNoUnitsDef(NamedElement lookupContext) {
				\t\treturn getRealRangeNoUnitsDef(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RealRange> getRealRangeNoUnitsDef(NamedElement lookupContext, Mode mode) {
				\t\treturn getRealRangeNoUnitsDef(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RealRange> getRealRangeNoUnitsDef(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRealRangeNoUnitsDef_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RealRange(resolved, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRealRangeNoUnitsDef_Property(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + REAL_RANGE_NO_UNITS_DEF__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRealRangeNoUnitsDef_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRealRangeNoUnitsDef_Property(lookupContext));
				\t}

				\t// Lookup methods for resolve_named_value_test::real_range_with_units_def

				\tpublic static final String REAL_RANGE_WITH_UNITS_DEF__NAME = "real_range_with_units_def";

				\tpublic static boolean acceptsRealRangeWithUnitsDef(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRealRangeWithUnitsDef_Property(lookupContext));
				\t}

				\tpublic static Optional<RealRangeWithUnits<Length>> getRealRangeWithUnitsDef(NamedElement lookupContext) {
				\t\treturn getRealRangeWithUnitsDef(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RealRangeWithUnits<Length>> getRealRangeWithUnitsDef(NamedElement lookupContext, Mode mode) {
				\t\treturn getRealRangeWithUnitsDef(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RealRangeWithUnits<Length>> getRealRangeWithUnitsDef(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRealRangeWithUnitsDef_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RealRangeWithUnits<>(resolved, Length.class, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRealRangeWithUnitsDef_Property(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + REAL_RANGE_WITH_UNITS_DEF__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRealRangeWithUnitsDef_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRealRangeWithUnitsDef_Property(lookupContext));
				\t}

				\t// Lookup methods for resolve_named_value_test::record_def

				\tpublic static final String RECORD_DEF__NAME = "record_def";

				\tpublic static boolean acceptsRecordDef(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRecordDef_Property(lookupContext));
				\t}

				\tpublic static Optional<RecordDef> getRecordDef(NamedElement lookupContext) {
				\t\treturn getRecordDef(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RecordDef> getRecordDef(NamedElement lookupContext, Mode mode) {
				\t\treturn getRecordDef(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RecordDef> getRecordDef(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRecordDef_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RecordDef(resolved, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRecordDef_Property(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + RECORD_DEF__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRecordDef_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRecordDef_Property(lookupContext));
				\t}

				\t// Lookup methods for resolve_named_value_test::bool_const

				\tpublic static final String BOOL_CONST__NAME = "bool_const";

				\tpublic static boolean getBoolConst(EObject lookupContext) {
				\t\tvar constant = getBoolConst_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((BooleanLiteral) resolved).getValue();
				\t}

				\tpublic static PropertyConstant getBoolConst_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + BOOL_CONST__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for resolve_named_value_test::int_const_1

				\tpublic static final String INT_CONST_1__NAME = "int_const_1";

				\tpublic static long getIntConst1(EObject lookupContext) {
				\t\tvar constant = getIntConst1_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((IntegerLiteral) resolved).getValue();
				\t}

				\tpublic static PropertyConstant getIntConst1_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + INT_CONST_1__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for resolve_named_value_test::int_const_2

				\tpublic static final String INT_CONST_2__NAME = "int_const_2";

				\tpublic static long getIntConst2(EObject lookupContext) {
				\t\tvar constant = getIntConst2_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((IntegerLiteral) resolved).getValue();
				\t}

				\tpublic static PropertyConstant getIntConst2_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + INT_CONST_2__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for resolve_named_value_test::int_with_units_const_1

				\tpublic static final String INT_WITH_UNITS_CONST_1__NAME = "int_with_units_const_1";

				\tpublic static IntegerWithUnits<Length> getIntWithUnitsConst1(EObject lookupContext) {
				\t\tvar constant = getIntWithUnitsConst1_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new IntegerWithUnits<>(resolved, Length.class);
				\t}

				\tpublic static PropertyConstant getIntWithUnitsConst1_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + INT_WITH_UNITS_CONST_1__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for resolve_named_value_test::int_with_units_const_2

				\tpublic static final String INT_WITH_UNITS_CONST_2__NAME = "int_with_units_const_2";

				\tpublic static IntegerWithUnits<Length> getIntWithUnitsConst2(EObject lookupContext) {
				\t\tvar constant = getIntWithUnitsConst2_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new IntegerWithUnits<>(resolved, Length.class);
				\t}

				\tpublic static PropertyConstant getIntWithUnitsConst2_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + INT_WITH_UNITS_CONST_2__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for resolve_named_value_test::real_const_1

				\tpublic static final String REAL_CONST_1__NAME = "real_const_1";

				\tpublic static double getRealConst1(EObject lookupContext) {
				\t\tvar constant = getRealConst1_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((RealLiteral) resolved).getValue();
				\t}

				\tpublic static PropertyConstant getRealConst1_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + REAL_CONST_1__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for resolve_named_value_test::real_const_2

				\tpublic static final String REAL_CONST_2__NAME = "real_const_2";

				\tpublic static double getRealConst2(EObject lookupContext) {
				\t\tvar constant = getRealConst2_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((RealLiteral) resolved).getValue();
				\t}

				\tpublic static PropertyConstant getRealConst2_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + REAL_CONST_2__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for resolve_named_value_test::real_with_units_const_1

				\tpublic static final String REAL_WITH_UNITS_CONST_1__NAME = "real_with_units_const_1";

				\tpublic static RealWithUnits<Length> getRealWithUnitsConst1(EObject lookupContext) {
				\t\tvar constant = getRealWithUnitsConst1_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new RealWithUnits<>(resolved, Length.class);
				\t}

				\tpublic static PropertyConstant getRealWithUnitsConst1_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + REAL_WITH_UNITS_CONST_1__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for resolve_named_value_test::real_with_units_const_2

				\tpublic static final String REAL_WITH_UNITS_CONST_2__NAME = "real_with_units_const_2";

				\tpublic static RealWithUnits<Length> getRealWithUnitsConst2(EObject lookupContext) {
				\t\tvar constant = getRealWithUnitsConst2_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new RealWithUnits<>(resolved, Length.class);
				\t}

				\tpublic static PropertyConstant getRealWithUnitsConst2_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + REAL_WITH_UNITS_CONST_2__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for resolve_named_value_test::list_1_int_const

				\tpublic static final String LIST_1_INT_CONST__NAME = "list_1_int_const";

				\tpublic static List<Long> getList1IntConst(EObject lookupContext) {
				\t\tvar constant = getList1IntConst_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn ((IntegerLiteral) resolved1).getValue();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1IntConst_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + LIST_1_INT_CONST__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for resolve_named_value_test::list_2_int_const

				\tpublic static final String LIST_2_INT_CONST__NAME = "list_2_int_const";

				\tpublic static List<List<Long>> getList2IntConst(EObject lookupContext) {
				\t\tvar constant = getList2IntConst_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\treturn ((IntegerLiteral) resolved2).getValue();
				\t\t\t}).toList();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList2IntConst_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + LIST_2_INT_CONST__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for resolve_named_value_test::list_3_int_const

				\tpublic static final String LIST_3_INT_CONST__NAME = "list_3_int_const";

				\tpublic static List<List<List<Long>>> getList3IntConst(EObject lookupContext) {
				\t\tvar constant = getList3IntConst_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3);
				\t\t\t\t\treturn ((IntegerLiteral) resolved3).getValue();
				\t\t\t\t}).toList();
				\t\t\t}).toList();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList3IntConst_PropertyConstant(EObject lookupContext) {
				\t\tvar name = RESOLVE_NAMED_VALUE_TEST__NAME + "::" + LIST_3_INT_CONST__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}
				}
				""";
		var length = """
				package resolvenamedvaluetest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum Length implements GeneratedUnits<Length> {
				\tM(1.0, "m", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate Length(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static Length valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(Length target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var recordDef = """
				package resolvenamedvaluetest;

				import java.util.List;
				import java.util.Objects;
				import java.util.Optional;
				import java.util.OptionalDouble;
				import java.util.OptionalLong;
				import java.util.stream.Collectors;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.BooleanLiteral;
				import org.osate.aadl2.IntegerLiteral;
				import org.osate.aadl2.ListValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RealLiteral;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordDef extends GeneratedRecord {
				\tpublic static final String BOOL_FIELD__NAME = "bool_field";
				\tpublic static final String INT_FIELD__NAME = "int_field";
				\tpublic static final String REAL_FIELD__NAME = "real_field";
				\tpublic static final String LIST_3_INT_FIELD__NAME = "list_3_int_field";
				\tpublic static final URI BOOL_FIELD__URI = URI.createURI("__synthetic0.aadl#/0/@ownedProperty.7/@ownedPropertyType/@ownedField.0");
				\tpublic static final URI INT_FIELD__URI = URI.createURI("__synthetic0.aadl#/0/@ownedProperty.7/@ownedPropertyType/@ownedField.1");
				\tpublic static final URI REAL_FIELD__URI = URI.createURI("__synthetic0.aadl#/0/@ownedProperty.7/@ownedPropertyType/@ownedField.2");
				\tpublic static final URI LIST_3_INT_FIELD__URI = URI.createURI("__synthetic0.aadl#/0/@ownedProperty.7/@ownedPropertyType/@ownedField.3");

				\tprivate final Optional<Boolean> boolField;
				\tprivate final OptionalLong intField;
				\tprivate final OptionalDouble realField;
				\tprivate final Optional<List<List<List<Long>>>> list3IntField;

				\tpublic RecordDef(
				\t\t\tOptional<Boolean> boolField,
				\t\t\tOptionalLong intField,
				\t\t\tOptionalDouble realField,
				\t\t\tOptional<List<List<List<Long>>>> list3IntField
				\t) {
				\t\tthis.boolField = boolField;
				\t\tthis.intField = intField;
				\t\tthis.realField = realField;
				\t\tthis.list3IntField = list3IntField;
				\t}

				\tpublic RecordDef(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Boolean> boolField_local;
				\t\ttry {
				\t\t\tboolField_local = findFieldValue(recordValue, BOOL_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tboolField_local = Optional.empty();
				\t\t}
				\t\tthis.boolField = boolField_local;

				\t\tOptionalLong intField_local;
				\t\ttry {
				\t\t\tintField_local = findFieldValue(recordValue, INT_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tintField_local = OptionalLong.empty();
				\t\t}
				\t\tthis.intField = intField_local;

				\t\tOptionalDouble realField_local;
				\t\ttry {
				\t\t\trealField_local = findFieldValue(recordValue, REAL_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((RealLiteral) resolved).getValue();
				\t\t\t}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trealField_local = OptionalDouble.empty();
				\t\t}
				\t\tthis.realField = realField_local;

				\t\tOptional<List<List<List<Long>>>> list3IntField_local;
				\t\ttry {
				\t\t\tlist3IntField_local = findFieldValue(recordValue, LIST_3_INT_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\t\treturn ((IntegerLiteral) resolved3).getValue();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist3IntField_local = Optional.empty();
				\t\t}
				\t\tthis.list3IntField = list3IntField_local;
				\t}

				\tpublic RecordDef(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Boolean> boolField_local;
				\t\ttry {
				\t\t\tboolField_local = findFieldValue(recordValue, BOOL_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tboolField_local = Optional.empty();
				\t\t}
				\t\tthis.boolField = boolField_local;

				\t\tOptionalLong intField_local;
				\t\ttry {
				\t\t\tintField_local = findFieldValue(recordValue, INT_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tintField_local = OptionalLong.empty();
				\t\t}
				\t\tthis.intField = intField_local;

				\t\tOptionalDouble realField_local;
				\t\ttry {
				\t\t\trealField_local = findFieldValue(recordValue, REAL_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((RealLiteral) resolved).getValue();
				\t\t\t}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trealField_local = OptionalDouble.empty();
				\t\t}
				\t\tthis.realField = realField_local;

				\t\tOptional<List<List<List<Long>>>> list3IntField_local;
				\t\ttry {
				\t\t\tlist3IntField_local = findFieldValue(recordValue, LIST_3_INT_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3);
				\t\t\t\t\t\t\treturn ((IntegerLiteral) resolved3).getValue();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist3IntField_local = Optional.empty();
				\t\t}
				\t\tthis.list3IntField = list3IntField_local;
				\t}

				\tpublic Optional<Boolean> getBoolField() {
				\t\treturn boolField;
				\t}

				\tpublic OptionalLong getIntField() {
				\t\treturn intField;
				\t}

				\tpublic OptionalDouble getRealField() {
				\t\treturn realField;
				\t}

				\tpublic Optional<List<List<List<Long>>>> getList3IntField() {
				\t\treturn list3IntField;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (boolField.isEmpty()
				\t\t\t\t&& intField.isEmpty()
				\t\t\t\t&& realField.isEmpty()
				\t\t\t\t&& list3IntField.isEmpty()
				\t\t) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\tboolField.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, BOOL_FIELD__URI, BOOL_FIELD__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\tintField.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, INT_FIELD__URI, INT_FIELD__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\trealField.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REAL_FIELD__URI, REAL_FIELD__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\tlist3IntField.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_3_INT_FIELD__URI, LIST_3_INT_FIELD__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1, element2 -> CodeGenUtil.toPropertyExpression(element2, element3 -> CodeGenUtil.toPropertyExpression(element3)))));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(
				\t\t\t\tboolField,
				\t\t\t\tintField,
				\t\t\t\trealField,
				\t\t\t\tlist3IntField
				\t\t);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordDef other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.boolField, other.boolField)
				\t\t\t\t&& Objects.equals(this.intField, other.intField)
				\t\t\t\t&& Objects.equals(this.realField, other.realField)
				\t\t\t\t&& Objects.equals(this.list3IntField, other.list3IntField);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.boolField.ifPresent(field -> {
				\t\t\tbuilder.append(BOOL_FIELD__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.intField.ifPresent(field -> {
				\t\t\tbuilder.append(INT_FIELD__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.realField.ifPresent(field -> {
				\t\t\tbuilder.append(REAL_FIELD__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.list3IntField.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_3_INT_FIELD__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(element1 -> element1.stream().map(element2 -> element2.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(resolveNamedValueTest));
		assertEquals("src-gen/resolvenamedvaluetest", results.getPackagePath());
		assertEquals(3, results.getClasses().size());

		assertEquals("ResolveNamedValueTest.java", results.getClasses().get(0).getFileName());
		assertEquals(resolveNamedValueTestClass, results.getClasses().get(0).getContents());

		assertEquals("Length.java", results.getClasses().get(1).getFileName());
		assertEquals(length, results.getClasses().get(1).getContents());

		assertEquals("RecordDef.java", results.getClasses().get(2).getFileName());
		assertEquals(recordDef, results.getClasses().get(2).getContents());
	}
}
