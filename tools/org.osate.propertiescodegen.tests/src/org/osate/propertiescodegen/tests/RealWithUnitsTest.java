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

/** Verifies exact generated Java for real with units. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class RealWithUnitsTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testRealWithUnits() throws Exception {
		var otherPs = """
				property set other_ps is
				\tmass: type units (g, kg => g * 1000);
				end other_ps;
				""";
		var realWithUnitsTest = """
				property set real_with_units_test is
				\twith other_ps;
				\t
				\ttime: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				\t
				\towned: aadlreal units (B, KiB => B * 1024) applies to (all);
				\tsame_file: aadlreal units real_with_units_test::time applies to (all);
				\tother_file: aadlreal units other_ps::mass applies to (all);
				\t
				\tlist_1_owned: list of aadlreal units (mg, g => mg * 1000) applies to (all);
				\tlist_1_same_file: list of aadlreal units real_with_units_test::time applies to (all);
				\tlist_1_other_file: list of aadlreal units other_ps::mass applies to (all);
				\t
				\trecord_property: record (
				\t\towned: aadlreal units (hour, day => hour * 24);
				\t\tsame_file: aadlreal units real_with_units_test::time;
				\t\tother_file: aadlreal units other_ps::mass;
				\t\t
				\t\tlist_1_owned: list of aadlreal units (ml, l => ml * 1000);
				\t\tlist_1_same_file: list of aadlreal units real_with_units_test::time;
				\t\tlist_1_other_file: list of aadlreal units other_ps::mass;
				\t) applies to (all);
				\t
				\towned_constant: constant aadlreal units (B, KiB => B * 1024) => 1.1 B;
				\tsame_file_constant: constant aadlreal units real_with_units_test::time => 2.2 sec;
				\tother_file_constant: constant aadlreal units other_ps::mass => 3.3 g;
				\t
				\tlist_1_owned_constant: constant list of aadlreal units (mg, g => mg * 1000) => (4.4 mg, 5.5 g);
				\tlist_1_same_file_constant: constant list of aadlreal units real_with_units_test::time => (6.6 sec, 7.7 min);
				\tlist_1_other_file_constant: constant list of aadlreal units other_ps::mass => (8.8 g, 9.9 kg);
				end real_with_units_test;
				""";
		var realWithUnitsTestClass = """
				package realwithunitstest;

				import java.util.List;
				import java.util.Optional;

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
				import org.osate.pluginsupport.properties.RealWithUnits;

				import otherps.Mass;

				public final class RealWithUnitsTest {
				\tpublic static final String REAL_WITH_UNITS_TEST__NAME = "real_with_units_test";

				\tprivate RealWithUnitsTest() {}

				\t// Lookup methods for real_with_units_test::owned

				\tpublic static final String OWNED__NAME = "owned";

				\tpublic static boolean acceptsOwned(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getOwned_Property(lookupContext));
				\t}

				\tpublic static Optional<RealWithUnits<Owned>> getOwned(NamedElement lookupContext) {
				\t\treturn getOwned(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RealWithUnits<Owned>> getOwned(NamedElement lookupContext, Mode mode) {
				\t\treturn getOwned(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RealWithUnits<Owned>> getOwned(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getOwned_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RealWithUnits<>(resolved, Owned.class));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getOwned_Property(EObject lookupContext) {
				\t\tvar name = REAL_WITH_UNITS_TEST__NAME + "::" + OWNED__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getOwned_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getOwned_Property(lookupContext));
				\t}

				\t// Lookup methods for real_with_units_test::same_file

				\tpublic static final String SAME_FILE__NAME = "same_file";

				\tpublic static boolean acceptsSameFile(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getSameFile_Property(lookupContext));
				\t}

				\tpublic static Optional<RealWithUnits<Time>> getSameFile(NamedElement lookupContext) {
				\t\treturn getSameFile(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RealWithUnits<Time>> getSameFile(NamedElement lookupContext, Mode mode) {
				\t\treturn getSameFile(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RealWithUnits<Time>> getSameFile(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getSameFile_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RealWithUnits<>(resolved, Time.class));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getSameFile_Property(EObject lookupContext) {
				\t\tvar name = REAL_WITH_UNITS_TEST__NAME + "::" + SAME_FILE__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getSameFile_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getSameFile_Property(lookupContext));
				\t}

				\t// Lookup methods for real_with_units_test::other_file

				\tpublic static final String OTHER_FILE__NAME = "other_file";

				\tpublic static boolean acceptsOtherFile(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getOtherFile_Property(lookupContext));
				\t}

				\tpublic static Optional<RealWithUnits<Mass>> getOtherFile(NamedElement lookupContext) {
				\t\treturn getOtherFile(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RealWithUnits<Mass>> getOtherFile(NamedElement lookupContext, Mode mode) {
				\t\treturn getOtherFile(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RealWithUnits<Mass>> getOtherFile(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getOtherFile_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RealWithUnits<>(resolved, Mass.class));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getOtherFile_Property(EObject lookupContext) {
				\t\tvar name = REAL_WITH_UNITS_TEST__NAME + "::" + OTHER_FILE__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getOtherFile_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getOtherFile_Property(lookupContext));
				\t}

				\t// Lookup methods for real_with_units_test::list_1_owned

				\tpublic static final String LIST_1_OWNED__NAME = "list_1_owned";

				\tpublic static boolean acceptsList1Owned(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1Owned_Property(lookupContext));
				\t}

				\tpublic static Optional<List<RealWithUnits<List1Owned>>> getList1Owned(NamedElement lookupContext) {
				\t\treturn getList1Owned(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<RealWithUnits<List1Owned>>> getList1Owned(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1Owned(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<RealWithUnits<List1Owned>>> getList1Owned(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1Owned_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new RealWithUnits<>(resolved1, List1Owned.class);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1Owned_Property(EObject lookupContext) {
				\t\tvar name = REAL_WITH_UNITS_TEST__NAME + "::" + LIST_1_OWNED__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1Owned_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1Owned_Property(lookupContext));
				\t}

				\t// Lookup methods for real_with_units_test::list_1_same_file

				\tpublic static final String LIST_1_SAME_FILE__NAME = "list_1_same_file";

				\tpublic static boolean acceptsList1SameFile(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1SameFile_Property(lookupContext));
				\t}

				\tpublic static Optional<List<RealWithUnits<Time>>> getList1SameFile(NamedElement lookupContext) {
				\t\treturn getList1SameFile(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<RealWithUnits<Time>>> getList1SameFile(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1SameFile(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<RealWithUnits<Time>>> getList1SameFile(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1SameFile_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new RealWithUnits<>(resolved1, Time.class);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1SameFile_Property(EObject lookupContext) {
				\t\tvar name = REAL_WITH_UNITS_TEST__NAME + "::" + LIST_1_SAME_FILE__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1SameFile_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1SameFile_Property(lookupContext));
				\t}

				\t// Lookup methods for real_with_units_test::list_1_other_file

				\tpublic static final String LIST_1_OTHER_FILE__NAME = "list_1_other_file";

				\tpublic static boolean acceptsList1OtherFile(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1OtherFile_Property(lookupContext));
				\t}

				\tpublic static Optional<List<RealWithUnits<Mass>>> getList1OtherFile(NamedElement lookupContext) {
				\t\treturn getList1OtherFile(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<RealWithUnits<Mass>>> getList1OtherFile(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1OtherFile(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<RealWithUnits<Mass>>> getList1OtherFile(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1OtherFile_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new RealWithUnits<>(resolved1, Mass.class);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1OtherFile_Property(EObject lookupContext) {
				\t\tvar name = REAL_WITH_UNITS_TEST__NAME + "::" + LIST_1_OTHER_FILE__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1OtherFile_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1OtherFile_Property(lookupContext));
				\t}

				\t// Lookup methods for real_with_units_test::record_property

				\tpublic static final String RECORD_PROPERTY__NAME = "record_property";

				\tpublic static boolean acceptsRecordProperty(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRecordProperty_Property(lookupContext));
				\t}

				\tpublic static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext) {
				\t\treturn getRecordProperty(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext, Mode mode) {
				\t\treturn getRecordProperty(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRecordProperty_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RecordProperty(resolved, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRecordProperty_Property(EObject lookupContext) {
				\t\tvar name = REAL_WITH_UNITS_TEST__NAME + "::" + RECORD_PROPERTY__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRecordProperty_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRecordProperty_Property(lookupContext));
				\t}

				\t// Lookup methods for real_with_units_test::owned_constant

				\tpublic static final String OWNED_CONSTANT__NAME = "owned_constant";

				\tpublic static RealWithUnits<OwnedConstant> getOwnedConstant(EObject lookupContext) {
				\t\tvar constant = getOwnedConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new RealWithUnits<>(resolved, OwnedConstant.class);
				\t}

				\tpublic static PropertyConstant getOwnedConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = REAL_WITH_UNITS_TEST__NAME + "::" + OWNED_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for real_with_units_test::same_file_constant

				\tpublic static final String SAME_FILE_CONSTANT__NAME = "same_file_constant";

				\tpublic static RealWithUnits<Time> getSameFileConstant(EObject lookupContext) {
				\t\tvar constant = getSameFileConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new RealWithUnits<>(resolved, Time.class);
				\t}

				\tpublic static PropertyConstant getSameFileConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = REAL_WITH_UNITS_TEST__NAME + "::" + SAME_FILE_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for real_with_units_test::other_file_constant

				\tpublic static final String OTHER_FILE_CONSTANT__NAME = "other_file_constant";

				\tpublic static RealWithUnits<Mass> getOtherFileConstant(EObject lookupContext) {
				\t\tvar constant = getOtherFileConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn new RealWithUnits<>(resolved, Mass.class);
				\t}

				\tpublic static PropertyConstant getOtherFileConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = REAL_WITH_UNITS_TEST__NAME + "::" + OTHER_FILE_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for real_with_units_test::list_1_owned_constant

				\tpublic static final String LIST_1_OWNED_CONSTANT__NAME = "list_1_owned_constant";

				\tpublic static List<RealWithUnits<List1OwnedConstant>> getList1OwnedConstant(EObject lookupContext) {
				\t\tvar constant = getList1OwnedConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn new RealWithUnits<>(resolved1, List1OwnedConstant.class);
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1OwnedConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = REAL_WITH_UNITS_TEST__NAME + "::" + LIST_1_OWNED_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for real_with_units_test::list_1_same_file_constant

				\tpublic static final String LIST_1_SAME_FILE_CONSTANT__NAME = "list_1_same_file_constant";

				\tpublic static List<RealWithUnits<Time>> getList1SameFileConstant(EObject lookupContext) {
				\t\tvar constant = getList1SameFileConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn new RealWithUnits<>(resolved1, Time.class);
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1SameFileConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = REAL_WITH_UNITS_TEST__NAME + "::" + LIST_1_SAME_FILE_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for real_with_units_test::list_1_other_file_constant

				\tpublic static final String LIST_1_OTHER_FILE_CONSTANT__NAME = "list_1_other_file_constant";

				\tpublic static List<RealWithUnits<Mass>> getList1OtherFileConstant(EObject lookupContext) {
				\t\tvar constant = getList1OtherFileConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn new RealWithUnits<>(resolved1, Mass.class);
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1OtherFileConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = REAL_WITH_UNITS_TEST__NAME + "::" + LIST_1_OTHER_FILE_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}
				}
				""";
		var time = """
				package realwithunitstest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum Time implements GeneratedUnits<Time> {
				\tSEC(1.0, "sec", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				\tMIN(60.0, "min", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				\tHR(3600.0, "hr", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
				\tDAY(86400.0, "day", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate Time(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static Time valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(Time target) {
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
		var owned = """
				package realwithunitstest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum Owned implements GeneratedUnits<Owned> {
				\tB(1.0, "B", "__synthetic1.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.0"),
				\tKIB(1024.0, "KiB", "__synthetic1.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate Owned(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static Owned valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(Owned target) {
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
		var list1Owned = """
				package realwithunitstest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum List1Owned implements GeneratedUnits<List1Owned> {
				\tMG(1.0, "mg", "__synthetic1.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.0"),
				\tG(1000.0, "g", "__synthetic1.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate List1Owned(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static List1Owned valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(List1Owned target) {
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
		var recordProperty = """
				package realwithunitstest;

				import java.util.List;
				import java.util.Objects;
				import java.util.Optional;
				import java.util.stream.Collectors;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.ListValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;
				import org.osate.pluginsupport.properties.GeneratedUnits;
				import org.osate.pluginsupport.properties.RealWithUnits;

				import otherps.Mass;

				public class RecordProperty extends GeneratedRecord {
				\tpublic static final String OWNED__NAME = "owned";
				\tpublic static final String SAME_FILE__NAME = "same_file";
				\tpublic static final String OTHER_FILE__NAME = "other_file";
				\tpublic static final String LIST_1_OWNED__NAME = "list_1_owned";
				\tpublic static final String LIST_1_SAME_FILE__NAME = "list_1_same_file";
				\tpublic static final String LIST_1_OTHER_FILE__NAME = "list_1_other_file";
				\tpublic static final URI OWNED__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.0");
				\tpublic static final URI SAME_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.1");
				\tpublic static final URI OTHER_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.2");
				\tpublic static final URI LIST_1_OWNED__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.3");
				\tpublic static final URI LIST_1_SAME_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.4");
				\tpublic static final URI LIST_1_OTHER_FILE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.5");

				\tprivate final Optional<RealWithUnits<Owned_FieldType>> owned;
				\tprivate final Optional<RealWithUnits<Time>> sameFile;
				\tprivate final Optional<RealWithUnits<Mass>> otherFile;
				\tprivate final Optional<List<RealWithUnits<List1Owned_FieldType>>> list1Owned;
				\tprivate final Optional<List<RealWithUnits<Time>>> list1SameFile;
				\tprivate final Optional<List<RealWithUnits<Mass>>> list1OtherFile;

				\tpublic RecordProperty(
				\t\t\tOptional<RealWithUnits<Owned_FieldType>> owned,
				\t\t\tOptional<RealWithUnits<Time>> sameFile,
				\t\t\tOptional<RealWithUnits<Mass>> otherFile,
				\t\t\tOptional<List<RealWithUnits<List1Owned_FieldType>>> list1Owned,
				\t\t\tOptional<List<RealWithUnits<Time>>> list1SameFile,
				\t\t\tOptional<List<RealWithUnits<Mass>>> list1OtherFile
				\t) {
				\t\tthis.owned = owned;
				\t\tthis.sameFile = sameFile;
				\t\tthis.otherFile = otherFile;
				\t\tthis.list1Owned = list1Owned;
				\t\tthis.list1SameFile = list1SameFile;
				\t\tthis.list1OtherFile = list1OtherFile;
				\t}

				\tpublic RecordProperty(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<RealWithUnits<Owned_FieldType>> owned_local;
				\t\ttry {
				\t\t\towned_local = findFieldValue(recordValue, OWNED__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new RealWithUnits<>(resolved, Owned_FieldType.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\towned_local = Optional.empty();
				\t\t}
				\t\tthis.owned = owned_local;

				\t\tOptional<RealWithUnits<Time>> sameFile_local;
				\t\ttry {
				\t\t\tsameFile_local = findFieldValue(recordValue, SAME_FILE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new RealWithUnits<>(resolved, Time.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tsameFile_local = Optional.empty();
				\t\t}
				\t\tthis.sameFile = sameFile_local;

				\t\tOptional<RealWithUnits<Mass>> otherFile_local;
				\t\ttry {
				\t\t\totherFile_local = findFieldValue(recordValue, OTHER_FILE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new RealWithUnits<>(resolved, Mass.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\totherFile_local = Optional.empty();
				\t\t}
				\t\tthis.otherFile = otherFile_local;

				\t\tOptional<List<RealWithUnits<List1Owned_FieldType>>> list1Owned_local;
				\t\ttry {
				\t\t\tlist1Owned_local = findFieldValue(recordValue, LIST_1_OWNED__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new RealWithUnits<>(resolved1, List1Owned_FieldType.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1Owned_local = Optional.empty();
				\t\t}
				\t\tthis.list1Owned = list1Owned_local;

				\t\tOptional<List<RealWithUnits<Time>>> list1SameFile_local;
				\t\ttry {
				\t\t\tlist1SameFile_local = findFieldValue(recordValue, LIST_1_SAME_FILE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new RealWithUnits<>(resolved1, Time.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1SameFile_local = Optional.empty();
				\t\t}
				\t\tthis.list1SameFile = list1SameFile_local;

				\t\tOptional<List<RealWithUnits<Mass>>> list1OtherFile_local;
				\t\ttry {
				\t\t\tlist1OtherFile_local = findFieldValue(recordValue, LIST_1_OTHER_FILE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new RealWithUnits<>(resolved1, Mass.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1OtherFile_local = Optional.empty();
				\t\t}
				\t\tthis.list1OtherFile = list1OtherFile_local;
				\t}

				\tpublic RecordProperty(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<RealWithUnits<Owned_FieldType>> owned_local;
				\t\ttry {
				\t\t\towned_local = findFieldValue(recordValue, OWNED__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new RealWithUnits<>(resolved, Owned_FieldType.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\towned_local = Optional.empty();
				\t\t}
				\t\tthis.owned = owned_local;

				\t\tOptional<RealWithUnits<Time>> sameFile_local;
				\t\ttry {
				\t\t\tsameFile_local = findFieldValue(recordValue, SAME_FILE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new RealWithUnits<>(resolved, Time.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tsameFile_local = Optional.empty();
				\t\t}
				\t\tthis.sameFile = sameFile_local;

				\t\tOptional<RealWithUnits<Mass>> otherFile_local;
				\t\ttry {
				\t\t\totherFile_local = findFieldValue(recordValue, OTHER_FILE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new RealWithUnits<>(resolved, Mass.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\totherFile_local = Optional.empty();
				\t\t}
				\t\tthis.otherFile = otherFile_local;

				\t\tOptional<List<RealWithUnits<List1Owned_FieldType>>> list1Owned_local;
				\t\ttry {
				\t\t\tlist1Owned_local = findFieldValue(recordValue, LIST_1_OWNED__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new RealWithUnits<>(resolved1, List1Owned_FieldType.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1Owned_local = Optional.empty();
				\t\t}
				\t\tthis.list1Owned = list1Owned_local;

				\t\tOptional<List<RealWithUnits<Time>>> list1SameFile_local;
				\t\ttry {
				\t\t\tlist1SameFile_local = findFieldValue(recordValue, LIST_1_SAME_FILE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new RealWithUnits<>(resolved1, Time.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1SameFile_local = Optional.empty();
				\t\t}
				\t\tthis.list1SameFile = list1SameFile_local;

				\t\tOptional<List<RealWithUnits<Mass>>> list1OtherFile_local;
				\t\ttry {
				\t\t\tlist1OtherFile_local = findFieldValue(recordValue, LIST_1_OTHER_FILE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new RealWithUnits<>(resolved1, Mass.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlist1OtherFile_local = Optional.empty();
				\t\t}
				\t\tthis.list1OtherFile = list1OtherFile_local;
				\t}

				\tpublic Optional<RealWithUnits<Owned_FieldType>> getOwned() {
				\t\treturn owned;
				\t}

				\tpublic Optional<RealWithUnits<Time>> getSameFile() {
				\t\treturn sameFile;
				\t}

				\tpublic Optional<RealWithUnits<Mass>> getOtherFile() {
				\t\treturn otherFile;
				\t}

				\tpublic Optional<List<RealWithUnits<List1Owned_FieldType>>> getList1Owned() {
				\t\treturn list1Owned;
				\t}

				\tpublic Optional<List<RealWithUnits<Time>>> getList1SameFile() {
				\t\treturn list1SameFile;
				\t}

				\tpublic Optional<List<RealWithUnits<Mass>>> getList1OtherFile() {
				\t\treturn list1OtherFile;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (owned.isEmpty()
				\t\t\t\t&& sameFile.isEmpty()
				\t\t\t\t&& otherFile.isEmpty()
				\t\t\t\t&& list1Owned.isEmpty()
				\t\t\t\t&& list1SameFile.isEmpty()
				\t\t\t\t&& list1OtherFile.isEmpty()
				\t\t) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\towned.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED__URI, OWNED__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\tsameFile.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, SAME_FILE__URI, SAME_FILE__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\totherFile.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OTHER_FILE__URI, OTHER_FILE__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\tlist1Owned.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_1_OWNED__URI, LIST_1_OWNED__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\tlist1SameFile.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_1_SAME_FILE__URI, LIST_1_SAME_FILE__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\tlist1OtherFile.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_1_OTHER_FILE__URI, LIST_1_OTHER_FILE__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(
				\t\t\t\towned,
				\t\t\t\tsameFile,
				\t\t\t\totherFile,
				\t\t\t\tlist1Owned,
				\t\t\t\tlist1SameFile,
				\t\t\t\tlist1OtherFile
				\t\t);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordProperty other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.owned, other.owned)
				\t\t\t\t&& Objects.equals(this.sameFile, other.sameFile)
				\t\t\t\t&& Objects.equals(this.otherFile, other.otherFile)
				\t\t\t\t&& Objects.equals(this.list1Owned, other.list1Owned)
				\t\t\t\t&& Objects.equals(this.list1SameFile, other.list1SameFile)
				\t\t\t\t&& Objects.equals(this.list1OtherFile, other.list1OtherFile);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.owned.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.sameFile.ifPresent(field -> {
				\t\t\tbuilder.append(SAME_FILE__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.otherFile.ifPresent(field -> {
				\t\t\tbuilder.append(OTHER_FILE__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.list1Owned.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_1_OWNED__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.list1SameFile.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_1_SAME_FILE__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.list1OtherFile.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_1_OTHER_FILE__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}

				\tpublic enum Owned_FieldType implements GeneratedUnits<Owned_FieldType> {
				\t\tHOUR(1.0, "hour", "__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.0"),
				\t\tDAY(24.0, "day", "__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.1");

				\t\tprivate final double factorToBase;
				\t\tprivate final String originalName;
				\t\tprivate final URI uri;

				\t\tprivate Owned_FieldType(double factorToBase, String originalName, String uri) {
				\t\t\tthis.factorToBase = factorToBase;
				\t\t\tthis.originalName = originalName;
				\t\t\tthis.uri = URI.createURI(uri);
				\t\t}

				\t\tpublic static Owned_FieldType valueOf(PropertyExpression propertyExpression) {
				\t\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorToBase() {
				\t\t\treturn factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorTo(Owned_FieldType target) {
				\t\t\treturn factorToBase / target.factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic URI getURI() {
				\t\t\treturn uri;
				\t\t}

				\t\t@Override
				\t\tpublic String toString() {
				\t\t\treturn originalName;
				\t\t}
				\t}

				\tpublic enum List1Owned_FieldType implements GeneratedUnits<List1Owned_FieldType> {
				\t\tML(1.0, "ml", "__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.0"),
				\t\tL(1000.0, "l", "__synthetic1.aadl#/0/@ownedProperty.6/@ownedPropertyType/@ownedField.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.1");

				\t\tprivate final double factorToBase;
				\t\tprivate final String originalName;
				\t\tprivate final URI uri;

				\t\tprivate List1Owned_FieldType(double factorToBase, String originalName, String uri) {
				\t\t\tthis.factorToBase = factorToBase;
				\t\t\tthis.originalName = originalName;
				\t\t\tthis.uri = URI.createURI(uri);
				\t\t}

				\t\tpublic static List1Owned_FieldType valueOf(PropertyExpression propertyExpression) {
				\t\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorToBase() {
				\t\t\treturn factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorTo(List1Owned_FieldType target) {
				\t\t\treturn factorToBase / target.factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic URI getURI() {
				\t\t\treturn uri;
				\t\t}

				\t\t@Override
				\t\tpublic String toString() {
				\t\t\treturn originalName;
				\t\t}
				\t}
				}
				""";
		var ownedConstant = """
				package realwithunitstest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum OwnedConstant implements GeneratedUnits<OwnedConstant> {
				\tB(1.0, "B", "__synthetic1.aadl#/0/@ownedPropertyConstant.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.0"),
				\tKIB(1024.0, "KiB", "__synthetic1.aadl#/0/@ownedPropertyConstant.0/@ownedPropertyType/@ownedUnitsType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate OwnedConstant(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static OwnedConstant valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(OwnedConstant target) {
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
		var list1OwnedConstant = """
				package realwithunitstest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum List1OwnedConstant implements GeneratedUnits<List1OwnedConstant> {
				\tMG(1.0, "mg", "__synthetic1.aadl#/0/@ownedPropertyConstant.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.0"),
				\tG(1000.0, "g", "__synthetic1.aadl#/0/@ownedPropertyConstant.3/@ownedPropertyType/@ownedElementType/@ownedUnitsType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate List1OwnedConstant(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static List1OwnedConstant valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(List1OwnedConstant target) {
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
		var results = generateAndCompile(testHelper.parseString(realWithUnitsTest, otherPs));
		assertEquals("src-gen/realwithunitstest", results.getPackagePath());
		assertEquals(7, results.getClasses().size());

		assertEquals("RealWithUnitsTest.java", results.getClasses().get(0).getFileName());
		assertEquals(realWithUnitsTestClass, results.getClasses().get(0).getContents());

		assertEquals("Time.java", results.getClasses().get(1).getFileName());
		assertEquals(time, results.getClasses().get(1).getContents());

		assertEquals("Owned.java", results.getClasses().get(2).getFileName());
		assertEquals(owned, results.getClasses().get(2).getContents());

		assertEquals("List1Owned.java", results.getClasses().get(3).getFileName());
		assertEquals(list1Owned, results.getClasses().get(3).getContents());

		assertEquals("RecordProperty.java", results.getClasses().get(4).getFileName());
		assertEquals(recordProperty, results.getClasses().get(4).getContents());

		assertEquals("OwnedConstant.java", results.getClasses().get(5).getFileName());
		assertEquals(ownedConstant, results.getClasses().get(5).getContents());

		assertEquals("List1OwnedConstant.java", results.getClasses().get(6).getFileName());
		assertEquals(list1OwnedConstant, results.getClasses().get(6).getContents());
	}
}
