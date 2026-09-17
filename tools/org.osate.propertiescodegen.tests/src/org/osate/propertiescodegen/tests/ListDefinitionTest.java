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

/** Verifies exact generated Java for list definition. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ListDefinitionTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testListDefinition() throws Exception {
		var ps2 = """
				property set ps2 is
				\tmass: type units (g, kg => g * 1000);
				\tmass_type: type aadlreal units ps2::mass;
				\tcolor: type enumeration (red, green, blue);
				\tbasic_range: type range of aadlreal;
				\tbasic_record: type record (field: aadlreal;);
				end ps2;
				""";
		var ps1 = """
				property set ps1 is
				\twith ps2;
				\t
				\ttime: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				\tinteger_owned_units: type aadlinteger units (mm, cm => mm * 10, m => cm * 100);
				\tenum_type_1: type enumeration (one, two, three);
				\trange_of_integer_no_units: type range of aadlinteger;
				\trecord_of_boolean: type record (field: aadlboolean;);
				\t
				\tlist_1_boolean: list of aadlboolean applies to (all);
				\tlist_2_boolean: list of list of aadlboolean applies to (all);
				\tlist_3_boolean: list of list of list of aadlboolean applies to (all);
				\tlist_4_boolean: list of list of list of list of aadlboolean applies to (all);
				\tlist_5_boolean: list of list of list of list of list of aadlboolean applies to (all);
				\t
				\tlist_1_string: list of aadlstring applies to (all);
				\tlist_1_classifier: list of classifier applies to (all);
				\tlist_1_integer_no_units: list of aadlinteger applies to (all);
				\tlist_1_real_no_units: list of aadlreal applies to (all);
				\tlist_1_reference: list of reference applies to (all);
				\t
				\tlist_1_owned_enum: list of enumeration (mercury, venus, earth, mars) applies to (all);
				\tlist_1_owned_units: list of units (cm, m => cm * 100) applies to (all);
				\tlist_1_owned_integer_with_units: list of aadlinteger units ps1::time applies to (all);
				\tlist_1_owned_range: list of range of aadlinteger applies to (all);
				\tlist_1_owned_record: list of record (
				\t\tboolean_field: aadlboolean;
				\t\tstring_field: aadlstring;
				\t\trecord_field: record (
				\t\t\tinteger_field: aadlinteger;
				\t\t\treal_field: aadlreal;
				\t\t);
				\t) applies to (all);
				\t
				\tlist_1_referenced_enum_no_import: list of ps1::enum_type_1 applies to (all);
				\tlist_1_referenced_enum_with_import: list of ps2::color applies to (all);
				\tlist_1_referenced_units_no_import: list of ps1::time applies to (all);
				\tlist_1_referenced_units_with_import: list of ps2::mass applies to (all);
				\tlist_1_referenced_number_with_units_no_import: list of ps1::integer_owned_units applies to (all);
				\tlist_1_referenced_number_with_units_with_import: list of ps2::mass_type applies to (all);
				\tlist_1_referenced_range_no_import: list of ps1::range_of_integer_no_units applies to (all);
				\tlist_1_referenced_range_with_import: list of ps2::basic_range applies to (all);
				\tlist_1_referenced_record_no_import: list of ps1::record_of_boolean applies to (all);
				\tlist_1_referenced_record_with_import: list of ps2::basic_record applies to (all);
				\t
				\tlist_3_owned_enum: list of list of list of enumeration (north_america, south_america) applies to (all);
				\tlist_5_owned_range: list of list of list of list of list of range of aadlreal applies to (all);
				\tlist_3_referenced_enum_no_import: list of list of list of ps1::enum_type_1 applies to (all);
				\tlist_5_referenced_range_with_import: list of list of list of list of list of ps2::basic_range applies to (all);
				end ps1;
				""";
		var ps1Class = """
				package ps1;

				import java.util.List;
				import java.util.Optional;

				import org.eclipse.emf.ecore.EObject;
				import org.osate.aadl2.Aadl2Package;
				import org.osate.aadl2.BooleanLiteral;
				import org.osate.aadl2.Classifier;
				import org.osate.aadl2.ClassifierValue;
				import org.osate.aadl2.IntegerLiteral;
				import org.osate.aadl2.ListValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.Property;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RealLiteral;
				import org.osate.aadl2.StringLiteral;
				import org.osate.aadl2.instance.InstanceObject;
				import org.osate.aadl2.instance.InstanceReferenceValue;
				import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
				import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.IntegerRange;
				import org.osate.pluginsupport.properties.IntegerWithUnits;
				import org.osate.pluginsupport.properties.RealRange;
				import org.osate.pluginsupport.properties.RealWithUnits;

				import ps2.BasicRecord;
				import ps2.Color;
				import ps2.Mass;

				public final class Ps1 {
				\tpublic static final String PS1__NAME = "ps1";

				\tprivate Ps1() {}

				\t// Lookup methods for ps1::list_1_boolean

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
				\t\tvar name = PS1__NAME + "::" + LIST_1_BOOLEAN__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1Boolean_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1Boolean_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_2_boolean

				\tpublic static final String LIST_2_BOOLEAN__NAME = "list_2_boolean";

				\tpublic static boolean acceptsList2Boolean(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList2Boolean_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<Boolean>>> getList2Boolean(NamedElement lookupContext) {
				\t\treturn getList2Boolean(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<Boolean>>> getList2Boolean(NamedElement lookupContext, Mode mode) {
				\t\treturn getList2Boolean(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<Boolean>>> getList2Boolean(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList2Boolean_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\treturn ((BooleanLiteral) resolved2).getValue();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList2Boolean_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_2_BOOLEAN__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList2Boolean_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList2Boolean_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_3_boolean

				\tpublic static final String LIST_3_BOOLEAN__NAME = "list_3_boolean";

				\tpublic static boolean acceptsList3Boolean(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList3Boolean_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<Boolean>>>> getList3Boolean(NamedElement lookupContext) {
				\t\treturn getList3Boolean(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<Boolean>>>> getList3Boolean(NamedElement lookupContext, Mode mode) {
				\t\treturn getList3Boolean(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<Boolean>>>> getList3Boolean(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList3Boolean_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\treturn ((BooleanLiteral) resolved3).getValue();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList3Boolean_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_3_BOOLEAN__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList3Boolean_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList3Boolean_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_4_boolean

				\tpublic static final String LIST_4_BOOLEAN__NAME = "list_4_boolean";

				\tpublic static boolean acceptsList4Boolean(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList4Boolean_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<List<Boolean>>>>> getList4Boolean(NamedElement lookupContext) {
				\t\treturn getList4Boolean(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<List<Boolean>>>>> getList4Boolean(NamedElement lookupContext, Mode mode) {
				\t\treturn getList4Boolean(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<List<Boolean>>>>> getList4Boolean(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList4Boolean_Property(lookupContext);
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
				\t\t\t\t\t\t\treturn ((BooleanLiteral) resolved4).getValue();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList4Boolean_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_4_BOOLEAN__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList4Boolean_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList4Boolean_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_5_boolean

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
				\t\tvar name = PS1__NAME + "::" + LIST_5_BOOLEAN__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList5Boolean_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList5Boolean_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_string

				\tpublic static final String LIST_1_STRING__NAME = "list_1_string";

				\tpublic static boolean acceptsList1String(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1String_Property(lookupContext));
				\t}

				\tpublic static Optional<List<String>> getList1String(NamedElement lookupContext) {
				\t\treturn getList1String(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<String>> getList1String(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1String(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<String>> getList1String(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1String_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((StringLiteral) resolved1).getValue();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1String_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_STRING__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1String_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1String_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_classifier

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
				\t\tvar name = PS1__NAME + "::" + LIST_1_CLASSIFIER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1Classifier_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1Classifier_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_integer_no_units

				\tpublic static final String LIST_1_INTEGER_NO_UNITS__NAME = "list_1_integer_no_units";

				\tpublic static boolean acceptsList1IntegerNoUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1IntegerNoUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<List<Long>> getList1IntegerNoUnits(NamedElement lookupContext) {
				\t\treturn getList1IntegerNoUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<Long>> getList1IntegerNoUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1IntegerNoUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<Long>> getList1IntegerNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1IntegerNoUnits_Property(lookupContext);
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

				\tpublic static Property getList1IntegerNoUnits_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_INTEGER_NO_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1IntegerNoUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1IntegerNoUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_real_no_units

				\tpublic static final String LIST_1_REAL_NO_UNITS__NAME = "list_1_real_no_units";

				\tpublic static boolean acceptsList1RealNoUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1RealNoUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<List<Double>> getList1RealNoUnits(NamedElement lookupContext) {
				\t\treturn getList1RealNoUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<Double>> getList1RealNoUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1RealNoUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<Double>> getList1RealNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1RealNoUnits_Property(lookupContext);
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

				\tpublic static Property getList1RealNoUnits_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_REAL_NO_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1RealNoUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1RealNoUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_reference

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
				\t\tvar name = PS1__NAME + "::" + LIST_1_REFERENCE__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1Reference_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1Reference_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_owned_enum

				\tpublic static final String LIST_1_OWNED_ENUM__NAME = "list_1_owned_enum";

				\tpublic static boolean acceptsList1OwnedEnum(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1OwnedEnum_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List1OwnedEnum>> getList1OwnedEnum(NamedElement lookupContext) {
				\t\treturn getList1OwnedEnum(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List1OwnedEnum>> getList1OwnedEnum(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1OwnedEnum(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List1OwnedEnum>> getList1OwnedEnum(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1OwnedEnum_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn List1OwnedEnum.valueOf(resolved1);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1OwnedEnum_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_OWNED_ENUM__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1OwnedEnum_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1OwnedEnum_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_owned_units

				\tpublic static final String LIST_1_OWNED_UNITS__NAME = "list_1_owned_units";

				\tpublic static boolean acceptsList1OwnedUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1OwnedUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List1OwnedUnits>> getList1OwnedUnits(NamedElement lookupContext) {
				\t\treturn getList1OwnedUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List1OwnedUnits>> getList1OwnedUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1OwnedUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List1OwnedUnits>> getList1OwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1OwnedUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn List1OwnedUnits.valueOf(resolved1);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1OwnedUnits_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_OWNED_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1OwnedUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1OwnedUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_owned_integer_with_units

				\tpublic static final String LIST_1_OWNED_INTEGER_WITH_UNITS__NAME = "list_1_owned_integer_with_units";

				\tpublic static boolean acceptsList1OwnedIntegerWithUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1OwnedIntegerWithUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<List<IntegerWithUnits<Time>>> getList1OwnedIntegerWithUnits(NamedElement lookupContext) {
				\t\treturn getList1OwnedIntegerWithUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<IntegerWithUnits<Time>>> getList1OwnedIntegerWithUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1OwnedIntegerWithUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<IntegerWithUnits<Time>>> getList1OwnedIntegerWithUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1OwnedIntegerWithUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new IntegerWithUnits<>(resolved1, Time.class);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1OwnedIntegerWithUnits_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_OWNED_INTEGER_WITH_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1OwnedIntegerWithUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1OwnedIntegerWithUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_owned_range

				\tpublic static final String LIST_1_OWNED_RANGE__NAME = "list_1_owned_range";

				\tpublic static boolean acceptsList1OwnedRange(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1OwnedRange_Property(lookupContext));
				\t}

				\tpublic static Optional<List<IntegerRange>> getList1OwnedRange(NamedElement lookupContext) {
				\t\treturn getList1OwnedRange(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<IntegerRange>> getList1OwnedRange(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1OwnedRange(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<IntegerRange>> getList1OwnedRange(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1OwnedRange_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new IntegerRange(resolved1, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1OwnedRange_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_OWNED_RANGE__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1OwnedRange_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1OwnedRange_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_owned_record

				\tpublic static final String LIST_1_OWNED_RECORD__NAME = "list_1_owned_record";

				\tpublic static boolean acceptsList1OwnedRecord(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1OwnedRecord_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List1OwnedRecord>> getList1OwnedRecord(NamedElement lookupContext) {
				\t\treturn getList1OwnedRecord(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List1OwnedRecord>> getList1OwnedRecord(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1OwnedRecord(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List1OwnedRecord>> getList1OwnedRecord(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1OwnedRecord_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new List1OwnedRecord(resolved1, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1OwnedRecord_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_OWNED_RECORD__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1OwnedRecord_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1OwnedRecord_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_referenced_enum_no_import

				\tpublic static final String LIST_1_REFERENCED_ENUM_NO_IMPORT__NAME = "list_1_referenced_enum_no_import";

				\tpublic static boolean acceptsList1ReferencedEnumNoImport(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1ReferencedEnumNoImport_Property(lookupContext));
				\t}

				\tpublic static Optional<List<EnumType1>> getList1ReferencedEnumNoImport(NamedElement lookupContext) {
				\t\treturn getList1ReferencedEnumNoImport(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<EnumType1>> getList1ReferencedEnumNoImport(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1ReferencedEnumNoImport(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<EnumType1>> getList1ReferencedEnumNoImport(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1ReferencedEnumNoImport_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn EnumType1.valueOf(resolved1);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1ReferencedEnumNoImport_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_REFERENCED_ENUM_NO_IMPORT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1ReferencedEnumNoImport_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1ReferencedEnumNoImport_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_referenced_enum_with_import

				\tpublic static final String LIST_1_REFERENCED_ENUM_WITH_IMPORT__NAME = "list_1_referenced_enum_with_import";

				\tpublic static boolean acceptsList1ReferencedEnumWithImport(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1ReferencedEnumWithImport_Property(lookupContext));
				\t}

				\tpublic static Optional<List<Color>> getList1ReferencedEnumWithImport(NamedElement lookupContext) {
				\t\treturn getList1ReferencedEnumWithImport(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<Color>> getList1ReferencedEnumWithImport(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1ReferencedEnumWithImport(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<Color>> getList1ReferencedEnumWithImport(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1ReferencedEnumWithImport_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn Color.valueOf(resolved1);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1ReferencedEnumWithImport_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_REFERENCED_ENUM_WITH_IMPORT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1ReferencedEnumWithImport_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1ReferencedEnumWithImport_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_referenced_units_no_import

				\tpublic static final String LIST_1_REFERENCED_UNITS_NO_IMPORT__NAME = "list_1_referenced_units_no_import";

				\tpublic static boolean acceptsList1ReferencedUnitsNoImport(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1ReferencedUnitsNoImport_Property(lookupContext));
				\t}

				\tpublic static Optional<List<Time>> getList1ReferencedUnitsNoImport(NamedElement lookupContext) {
				\t\treturn getList1ReferencedUnitsNoImport(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<Time>> getList1ReferencedUnitsNoImport(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1ReferencedUnitsNoImport(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<Time>> getList1ReferencedUnitsNoImport(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1ReferencedUnitsNoImport_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn Time.valueOf(resolved1);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1ReferencedUnitsNoImport_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_REFERENCED_UNITS_NO_IMPORT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1ReferencedUnitsNoImport_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1ReferencedUnitsNoImport_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_referenced_units_with_import

				\tpublic static final String LIST_1_REFERENCED_UNITS_WITH_IMPORT__NAME = "list_1_referenced_units_with_import";

				\tpublic static boolean acceptsList1ReferencedUnitsWithImport(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1ReferencedUnitsWithImport_Property(lookupContext));
				\t}

				\tpublic static Optional<List<Mass>> getList1ReferencedUnitsWithImport(NamedElement lookupContext) {
				\t\treturn getList1ReferencedUnitsWithImport(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<Mass>> getList1ReferencedUnitsWithImport(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1ReferencedUnitsWithImport(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<Mass>> getList1ReferencedUnitsWithImport(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1ReferencedUnitsWithImport_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn Mass.valueOf(resolved1);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1ReferencedUnitsWithImport_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_REFERENCED_UNITS_WITH_IMPORT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1ReferencedUnitsWithImport_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1ReferencedUnitsWithImport_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_referenced_number_with_units_no_import

				\tpublic static final String LIST_1_REFERENCED_NUMBER_WITH_UNITS_NO_IMPORT__NAME = "list_1_referenced_number_with_units_no_import";

				\tpublic static boolean acceptsList1ReferencedNumberWithUnitsNoImport(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1ReferencedNumberWithUnitsNoImport_Property(lookupContext));
				\t}

				\tpublic static Optional<List<IntegerWithUnits<IntegerOwnedUnits>>> getList1ReferencedNumberWithUnitsNoImport(NamedElement lookupContext) {
				\t\treturn getList1ReferencedNumberWithUnitsNoImport(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<IntegerWithUnits<IntegerOwnedUnits>>> getList1ReferencedNumberWithUnitsNoImport(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1ReferencedNumberWithUnitsNoImport(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<IntegerWithUnits<IntegerOwnedUnits>>> getList1ReferencedNumberWithUnitsNoImport(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1ReferencedNumberWithUnitsNoImport_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new IntegerWithUnits<>(resolved1, IntegerOwnedUnits.class);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1ReferencedNumberWithUnitsNoImport_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_REFERENCED_NUMBER_WITH_UNITS_NO_IMPORT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1ReferencedNumberWithUnitsNoImport_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1ReferencedNumberWithUnitsNoImport_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_referenced_number_with_units_with_import

				\tpublic static final String LIST_1_REFERENCED_NUMBER_WITH_UNITS_WITH_IMPORT__NAME = "list_1_referenced_number_with_units_with_import";

				\tpublic static boolean acceptsList1ReferencedNumberWithUnitsWithImport(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1ReferencedNumberWithUnitsWithImport_Property(lookupContext));
				\t}

				\tpublic static Optional<List<RealWithUnits<Mass>>> getList1ReferencedNumberWithUnitsWithImport(NamedElement lookupContext) {
				\t\treturn getList1ReferencedNumberWithUnitsWithImport(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<RealWithUnits<Mass>>> getList1ReferencedNumberWithUnitsWithImport(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1ReferencedNumberWithUnitsWithImport(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<RealWithUnits<Mass>>> getList1ReferencedNumberWithUnitsWithImport(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1ReferencedNumberWithUnitsWithImport_Property(lookupContext);
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

				\tpublic static Property getList1ReferencedNumberWithUnitsWithImport_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_REFERENCED_NUMBER_WITH_UNITS_WITH_IMPORT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1ReferencedNumberWithUnitsWithImport_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1ReferencedNumberWithUnitsWithImport_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_referenced_range_no_import

				\tpublic static final String LIST_1_REFERENCED_RANGE_NO_IMPORT__NAME = "list_1_referenced_range_no_import";

				\tpublic static boolean acceptsList1ReferencedRangeNoImport(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1ReferencedRangeNoImport_Property(lookupContext));
				\t}

				\tpublic static Optional<List<IntegerRange>> getList1ReferencedRangeNoImport(NamedElement lookupContext) {
				\t\treturn getList1ReferencedRangeNoImport(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<IntegerRange>> getList1ReferencedRangeNoImport(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1ReferencedRangeNoImport(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<IntegerRange>> getList1ReferencedRangeNoImport(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1ReferencedRangeNoImport_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new IntegerRange(resolved1, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1ReferencedRangeNoImport_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_REFERENCED_RANGE_NO_IMPORT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1ReferencedRangeNoImport_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1ReferencedRangeNoImport_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_referenced_range_with_import

				\tpublic static final String LIST_1_REFERENCED_RANGE_WITH_IMPORT__NAME = "list_1_referenced_range_with_import";

				\tpublic static boolean acceptsList1ReferencedRangeWithImport(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1ReferencedRangeWithImport_Property(lookupContext));
				\t}

				\tpublic static Optional<List<RealRange>> getList1ReferencedRangeWithImport(NamedElement lookupContext) {
				\t\treturn getList1ReferencedRangeWithImport(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<RealRange>> getList1ReferencedRangeWithImport(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1ReferencedRangeWithImport(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<RealRange>> getList1ReferencedRangeWithImport(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1ReferencedRangeWithImport_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new RealRange(resolved1, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1ReferencedRangeWithImport_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_REFERENCED_RANGE_WITH_IMPORT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1ReferencedRangeWithImport_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1ReferencedRangeWithImport_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_referenced_record_no_import

				\tpublic static final String LIST_1_REFERENCED_RECORD_NO_IMPORT__NAME = "list_1_referenced_record_no_import";

				\tpublic static boolean acceptsList1ReferencedRecordNoImport(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1ReferencedRecordNoImport_Property(lookupContext));
				\t}

				\tpublic static Optional<List<RecordOfBoolean>> getList1ReferencedRecordNoImport(NamedElement lookupContext) {
				\t\treturn getList1ReferencedRecordNoImport(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<RecordOfBoolean>> getList1ReferencedRecordNoImport(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1ReferencedRecordNoImport(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<RecordOfBoolean>> getList1ReferencedRecordNoImport(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1ReferencedRecordNoImport_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new RecordOfBoolean(resolved1, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1ReferencedRecordNoImport_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_REFERENCED_RECORD_NO_IMPORT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1ReferencedRecordNoImport_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1ReferencedRecordNoImport_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_1_referenced_record_with_import

				\tpublic static final String LIST_1_REFERENCED_RECORD_WITH_IMPORT__NAME = "list_1_referenced_record_with_import";

				\tpublic static boolean acceptsList1ReferencedRecordWithImport(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1ReferencedRecordWithImport_Property(lookupContext));
				\t}

				\tpublic static Optional<List<BasicRecord>> getList1ReferencedRecordWithImport(NamedElement lookupContext) {
				\t\treturn getList1ReferencedRecordWithImport(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<BasicRecord>> getList1ReferencedRecordWithImport(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1ReferencedRecordWithImport(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<BasicRecord>> getList1ReferencedRecordWithImport(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1ReferencedRecordWithImport_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn new BasicRecord(resolved1, lookupContext, mode);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1ReferencedRecordWithImport_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_1_REFERENCED_RECORD_WITH_IMPORT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1ReferencedRecordWithImport_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1ReferencedRecordWithImport_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_3_owned_enum

				\tpublic static final String LIST_3_OWNED_ENUM__NAME = "list_3_owned_enum";

				\tpublic static boolean acceptsList3OwnedEnum(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList3OwnedEnum_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<List3OwnedEnum>>>> getList3OwnedEnum(NamedElement lookupContext) {
				\t\treturn getList3OwnedEnum(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<List3OwnedEnum>>>> getList3OwnedEnum(NamedElement lookupContext, Mode mode) {
				\t\treturn getList3OwnedEnum(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<List3OwnedEnum>>>> getList3OwnedEnum(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList3OwnedEnum_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\treturn List3OwnedEnum.valueOf(resolved3);
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList3OwnedEnum_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_3_OWNED_ENUM__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList3OwnedEnum_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList3OwnedEnum_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_5_owned_range

				\tpublic static final String LIST_5_OWNED_RANGE__NAME = "list_5_owned_range";

				\tpublic static boolean acceptsList5OwnedRange(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList5OwnedRange_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<List<List<RealRange>>>>>> getList5OwnedRange(NamedElement lookupContext) {
				\t\treturn getList5OwnedRange(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<List<List<RealRange>>>>>> getList5OwnedRange(NamedElement lookupContext, Mode mode) {
				\t\treturn getList5OwnedRange(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<List<List<RealRange>>>>>> getList5OwnedRange(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList5OwnedRange_Property(lookupContext);
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
				\t\t\t\t\t\t\t\treturn new RealRange(resolved5, lookupContext, mode);
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList5OwnedRange_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_5_OWNED_RANGE__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList5OwnedRange_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList5OwnedRange_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_3_referenced_enum_no_import

				\tpublic static final String LIST_3_REFERENCED_ENUM_NO_IMPORT__NAME = "list_3_referenced_enum_no_import";

				\tpublic static boolean acceptsList3ReferencedEnumNoImport(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList3ReferencedEnumNoImport_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<EnumType1>>>> getList3ReferencedEnumNoImport(NamedElement lookupContext) {
				\t\treturn getList3ReferencedEnumNoImport(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<EnumType1>>>> getList3ReferencedEnumNoImport(NamedElement lookupContext, Mode mode) {
				\t\treturn getList3ReferencedEnumNoImport(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<EnumType1>>>> getList3ReferencedEnumNoImport(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList3ReferencedEnumNoImport_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\treturn EnumType1.valueOf(resolved3);
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList3ReferencedEnumNoImport_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_3_REFERENCED_ENUM_NO_IMPORT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList3ReferencedEnumNoImport_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList3ReferencedEnumNoImport_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::list_5_referenced_range_with_import

				\tpublic static final String LIST_5_REFERENCED_RANGE_WITH_IMPORT__NAME = "list_5_referenced_range_with_import";

				\tpublic static boolean acceptsList5ReferencedRangeWithImport(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList5ReferencedRangeWithImport_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<List<List<RealRange>>>>>> getList5ReferencedRangeWithImport(NamedElement lookupContext) {
				\t\treturn getList5ReferencedRangeWithImport(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<List<List<RealRange>>>>>> getList5ReferencedRangeWithImport(NamedElement lookupContext, Mode mode) {
				\t\treturn getList5ReferencedRangeWithImport(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<List<List<RealRange>>>>>> getList5ReferencedRangeWithImport(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList5ReferencedRangeWithImport_Property(lookupContext);
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
				\t\t\t\t\t\t\t\treturn new RealRange(resolved5, lookupContext, mode);
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList5ReferencedRangeWithImport_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + LIST_5_REFERENCED_RANGE_WITH_IMPORT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList5ReferencedRangeWithImport_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList5ReferencedRangeWithImport_Property(lookupContext));
				\t}
				}
				""";
		var time = """
				package ps1;

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
		var integerOwnedUnits = """
				package ps1;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum IntegerOwnedUnits implements GeneratedUnits<IntegerOwnedUnits> {
				\tMM(1.0, "mm", "__synthetic1.aadl#/0/@ownedPropertyType.1/@ownedUnitsType/@ownedLiteral.0"),
				\tCM(10.0, "cm", "__synthetic1.aadl#/0/@ownedPropertyType.1/@ownedUnitsType/@ownedLiteral.1"),
				\tM(1000.0, "m", "__synthetic1.aadl#/0/@ownedPropertyType.1/@ownedUnitsType/@ownedLiteral.2");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate IntegerOwnedUnits(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static IntegerOwnedUnits valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(IntegerOwnedUnits target) {
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
		var enumType1 = """
				package ps1;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.pluginsupport.properties.GeneratedEnumeration;

				public enum EnumType1 implements GeneratedEnumeration {
				\tONE("one", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedLiteral.0"),
				\tTWO("two", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedLiteral.1"),
				\tTHREE("three", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedLiteral.2");

				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate EnumType1(String originalName, String uri) {
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static EnumType1 valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
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
		var recordOfBoolean = """
				package ps1;

				import java.util.Objects;
				import java.util.Optional;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.BooleanLiteral;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordOfBoolean extends GeneratedRecord {
				\tpublic static final String FIELD__NAME = "field";
				\tpublic static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.4/@ownedField.0");

				\tprivate final Optional<Boolean> field;

				\tpublic RecordOfBoolean(Optional<Boolean> field) {
				\t\tthis.field = field;
				\t}

				\tpublic RecordOfBoolean(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Boolean> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic RecordOfBoolean(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Boolean> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic Optional<Boolean> getField() {
				\t\treturn field;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (field.isEmpty()) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\tfield.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD__URI, FIELD__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(field);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordOfBoolean other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.field, other.field);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.field.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var list1OwnedEnum = """
				package ps1;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.pluginsupport.properties.GeneratedEnumeration;

				public enum List1OwnedEnum implements GeneratedEnumeration {
				\tMERCURY("mercury", "__synthetic1.aadl#/0/@ownedProperty.10/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
				\tVENUS("venus", "__synthetic1.aadl#/0/@ownedProperty.10/@ownedPropertyType/@ownedElementType/@ownedLiteral.1"),
				\tEARTH("earth", "__synthetic1.aadl#/0/@ownedProperty.10/@ownedPropertyType/@ownedElementType/@ownedLiteral.2"),
				\tMARS("mars", "__synthetic1.aadl#/0/@ownedProperty.10/@ownedPropertyType/@ownedElementType/@ownedLiteral.3");

				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate List1OwnedEnum(String originalName, String uri) {
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static List1OwnedEnum valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
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
		var list1OwnedUnits = """
				package ps1;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum List1OwnedUnits implements GeneratedUnits<List1OwnedUnits> {
				\tCM(1.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.11/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
				\tM(100.0, "m", "__synthetic1.aadl#/0/@ownedProperty.11/@ownedPropertyType/@ownedElementType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate List1OwnedUnits(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static List1OwnedUnits valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(List1OwnedUnits target) {
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
		var list1OwnedRecord = """
				package ps1;

				import java.util.Objects;
				import java.util.Optional;
				import java.util.OptionalDouble;
				import java.util.OptionalLong;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.BooleanLiteral;
				import org.osate.aadl2.IntegerLiteral;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RealLiteral;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.StringLiteral;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class List1OwnedRecord extends GeneratedRecord {
				\tpublic static final String BOOLEAN_FIELD__NAME = "boolean_field";
				\tpublic static final String STRING_FIELD__NAME = "string_field";
				\tpublic static final String RECORD_FIELD__NAME = "record_field";
				\tpublic static final URI BOOLEAN_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.14/@ownedPropertyType/@ownedElementType/@ownedField.0");
				\tpublic static final URI STRING_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.14/@ownedPropertyType/@ownedElementType/@ownedField.1");
				\tpublic static final URI RECORD_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.14/@ownedPropertyType/@ownedElementType/@ownedField.2");

				\tprivate final Optional<Boolean> booleanField;
				\tprivate final Optional<String> stringField;
				\tprivate final Optional<RecordField_FieldType> recordField;

				\tpublic List1OwnedRecord(
				\t\t\tOptional<Boolean> booleanField,
				\t\t\tOptional<String> stringField,
				\t\t\tOptional<RecordField_FieldType> recordField
				\t) {
				\t\tthis.booleanField = booleanField;
				\t\tthis.stringField = stringField;
				\t\tthis.recordField = recordField;
				\t}

				\tpublic List1OwnedRecord(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Boolean> booleanField_local;
				\t\ttry {
				\t\t\tbooleanField_local = findFieldValue(recordValue, BOOLEAN_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tbooleanField_local = Optional.empty();
				\t\t}
				\t\tthis.booleanField = booleanField_local;

				\t\tOptional<String> stringField_local;
				\t\ttry {
				\t\t\tstringField_local = findFieldValue(recordValue, STRING_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tstringField_local = Optional.empty();
				\t\t}
				\t\tthis.stringField = stringField_local;

				\t\tOptional<RecordField_FieldType> recordField_local;
				\t\ttry {
				\t\t\trecordField_local = findFieldValue(recordValue, RECORD_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new RecordField_FieldType(resolved, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trecordField_local = Optional.empty();
				\t\t}
				\t\tthis.recordField = recordField_local;
				\t}

				\tpublic List1OwnedRecord(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Boolean> booleanField_local;
				\t\ttry {
				\t\t\tbooleanField_local = findFieldValue(recordValue, BOOLEAN_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tbooleanField_local = Optional.empty();
				\t\t}
				\t\tthis.booleanField = booleanField_local;

				\t\tOptional<String> stringField_local;
				\t\ttry {
				\t\t\tstringField_local = findFieldValue(recordValue, STRING_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tstringField_local = Optional.empty();
				\t\t}
				\t\tthis.stringField = stringField_local;

				\t\tOptional<RecordField_FieldType> recordField_local;
				\t\ttry {
				\t\t\trecordField_local = findFieldValue(recordValue, RECORD_FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new RecordField_FieldType(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trecordField_local = Optional.empty();
				\t\t}
				\t\tthis.recordField = recordField_local;
				\t}

				\tpublic Optional<Boolean> getBooleanField() {
				\t\treturn booleanField;
				\t}

				\tpublic Optional<String> getStringField() {
				\t\treturn stringField;
				\t}

				\tpublic Optional<RecordField_FieldType> getRecordField() {
				\t\treturn recordField;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (booleanField.isEmpty()
				\t\t\t\t&& stringField.isEmpty()
				\t\t\t\t&& recordField.isEmpty()
				\t\t) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\tbooleanField.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, BOOLEAN_FIELD__URI, BOOLEAN_FIELD__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\tstringField.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, STRING_FIELD__URI, STRING_FIELD__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\trecordField.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, RECORD_FIELD__URI, RECORD_FIELD__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(
				\t\t\t\tbooleanField,
				\t\t\t\tstringField,
				\t\t\t\trecordField
				\t\t);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof List1OwnedRecord other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.booleanField, other.booleanField)
				\t\t\t\t&& Objects.equals(this.stringField, other.stringField)
				\t\t\t\t&& Objects.equals(this.recordField, other.recordField);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.booleanField.ifPresent(field -> {
				\t\t\tbuilder.append(BOOLEAN_FIELD__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.stringField.ifPresent(field -> {
				\t\t\tbuilder.append(STRING_FIELD__NAME);
				\t\t\tbuilder.append(" => \\"");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append("\\";");
				\t\t});
				\t\tthis.recordField.ifPresent(field -> {
				\t\t\tbuilder.append(RECORD_FIELD__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}

				\tpublic static class RecordField_FieldType extends GeneratedRecord {
				\t\tpublic static final String INTEGER_FIELD__NAME = "integer_field";
				\t\tpublic static final String REAL_FIELD__NAME = "real_field";
				\t\tpublic static final URI INTEGER_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.14/@ownedPropertyType/@ownedElementType/@ownedField.2/@ownedPropertyType/@ownedField.0");
				\t\tpublic static final URI REAL_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.14/@ownedPropertyType/@ownedElementType/@ownedField.2/@ownedPropertyType/@ownedField.1");

				\t\tprivate final OptionalLong integerField;
				\t\tprivate final OptionalDouble realField;

				\t\tpublic RecordField_FieldType(
				\t\t\t\tOptionalLong integerField,
				\t\t\t\tOptionalDouble realField
				\t\t) {
				\t\t\tthis.integerField = integerField;
				\t\t\tthis.realField = realField;
				\t\t}

				\t\tpublic RecordField_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\tOptionalLong integerField_local;
				\t\t\ttry {
				\t\t\t\tintegerField_local = findFieldValue(recordValue, INTEGER_FIELD__NAME).map(field -> {
				\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\tintegerField_local = OptionalLong.empty();
				\t\t\t}
				\t\t\tthis.integerField = integerField_local;

				\t\t\tOptionalDouble realField_local;
				\t\t\ttry {
				\t\t\t\trealField_local = findFieldValue(recordValue, REAL_FIELD__NAME).map(field -> {
				\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\t\treturn ((RealLiteral) resolved).getValue();
				\t\t\t\t}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
				\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\trealField_local = OptionalDouble.empty();
				\t\t\t}
				\t\t\tthis.realField = realField_local;
				\t\t}

				\t\tpublic RecordField_FieldType(PropertyExpression propertyExpression) {
				\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\tOptionalLong integerField_local;
				\t\t\ttry {
				\t\t\t\tintegerField_local = findFieldValue(recordValue, INTEGER_FIELD__NAME).map(field -> {
				\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\tintegerField_local = OptionalLong.empty();
				\t\t\t}
				\t\t\tthis.integerField = integerField_local;

				\t\t\tOptionalDouble realField_local;
				\t\t\ttry {
				\t\t\t\trealField_local = findFieldValue(recordValue, REAL_FIELD__NAME).map(field -> {
				\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\t\treturn ((RealLiteral) resolved).getValue();
				\t\t\t\t}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
				\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\trealField_local = OptionalDouble.empty();
				\t\t\t}
				\t\t\tthis.realField = realField_local;
				\t\t}

				\t\tpublic OptionalLong getIntegerField() {
				\t\t\treturn integerField;
				\t\t}

				\t\tpublic OptionalDouble getRealField() {
				\t\t\treturn realField;
				\t\t}

				\t\t@Override
				\t\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\t\tif (integerField.isEmpty()
				\t\t\t\t\t&& realField.isEmpty()
				\t\t\t) {
				\t\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t\t}
				\t\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\t\tintegerField.ifPresent(field -> {
				\t\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\t\tfieldAssociation.setProperty(loadField(resourceSet, INTEGER_FIELD__URI, INTEGER_FIELD__NAME));
				\t\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t\t});
				\t\t\trealField.ifPresent(field -> {
				\t\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REAL_FIELD__URI, REAL_FIELD__NAME));
				\t\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t\t});
				\t\t\treturn recordValue;
				\t\t}

				\t\t@Override
				\t\tpublic int hashCode() {
				\t\t\treturn Objects.hash(
				\t\t\t\t\tintegerField,
				\t\t\t\t\trealField
				\t\t\t);
				\t\t}

				\t\t@Override
				\t\tpublic boolean equals(Object obj) {
				\t\t\tif (this == obj) {
				\t\t\t\treturn true;
				\t\t\t}
				\t\t\tif (!(obj instanceof RecordField_FieldType other)) {
				\t\t\t\treturn false;
				\t\t\t}
				\t\t\treturn Objects.equals(this.integerField, other.integerField)
				\t\t\t\t\t&& Objects.equals(this.realField, other.realField);
				\t\t}

				\t\t@Override
				\t\tpublic String toString() {
				\t\t\tvar builder = new StringBuilder();
				\t\t\tbuilder.append('[');
				\t\t\tthis.integerField.ifPresent(field -> {
				\t\t\t\tbuilder.append(INTEGER_FIELD__NAME);
				\t\t\t\tbuilder.append(" => ");
				\t\t\t\tbuilder.append(field);
				\t\t\t\tbuilder.append(';');
				\t\t\t});
				\t\t\tthis.realField.ifPresent(field -> {
				\t\t\t\tbuilder.append(REAL_FIELD__NAME);
				\t\t\t\tbuilder.append(" => ");
				\t\t\t\tbuilder.append(field);
				\t\t\t\tbuilder.append(';');
				\t\t\t});
				\t\t\tbuilder.append(']');
				\t\t\treturn builder.toString();
				\t\t}
				\t}
				}
				""";
		var list3OwnedEnum = """
				package ps1;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.pluginsupport.properties.GeneratedEnumeration;

				public enum List3OwnedEnum implements GeneratedEnumeration {
				\tNORTH_AMERICA("north_america", "__synthetic1.aadl#/0/@ownedProperty.25/@ownedPropertyType/@ownedElementType/@ownedElementType/@ownedElementType/@ownedLiteral.0"),
				\tSOUTH_AMERICA("south_america", "__synthetic1.aadl#/0/@ownedProperty.25/@ownedPropertyType/@ownedElementType/@ownedElementType/@ownedElementType/@ownedLiteral.1");

				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate List3OwnedEnum(String originalName, String uri) {
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static List3OwnedEnum valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
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
		var results = generateAndCompile(testHelper.parseString(ps1, ps2));
		assertEquals("src-gen/ps1", results.getPackagePath());
		assertEquals(9, results.getClasses().size());

		assertEquals("Ps1.java", results.getClasses().get(0).getFileName());
		assertEquals(ps1Class, results.getClasses().get(0).getContents());

		assertEquals("Time.java", results.getClasses().get(1).getFileName());
		assertEquals(time, results.getClasses().get(1).getContents());

		assertEquals("IntegerOwnedUnits.java", results.getClasses().get(2).getFileName());
		assertEquals(integerOwnedUnits, results.getClasses().get(2).getContents());

		assertEquals("EnumType1.java", results.getClasses().get(3).getFileName());
		assertEquals(enumType1, results.getClasses().get(3).getContents());

		assertEquals("RecordOfBoolean.java", results.getClasses().get(4).getFileName());
		assertEquals(recordOfBoolean, results.getClasses().get(4).getContents());

		assertEquals("List1OwnedEnum.java", results.getClasses().get(5).getFileName());
		assertEquals(list1OwnedEnum, results.getClasses().get(5).getContents());

		assertEquals("List1OwnedUnits.java", results.getClasses().get(6).getFileName());
		assertEquals(list1OwnedUnits, results.getClasses().get(6).getContents());

		assertEquals("List1OwnedRecord.java", results.getClasses().get(7).getFileName());
		assertEquals(list1OwnedRecord, results.getClasses().get(7).getContents());

		assertEquals("List3OwnedEnum.java", results.getClasses().get(8).getFileName());
		assertEquals(list3OwnedEnum, results.getClasses().get(8).getContents());
	}
}
