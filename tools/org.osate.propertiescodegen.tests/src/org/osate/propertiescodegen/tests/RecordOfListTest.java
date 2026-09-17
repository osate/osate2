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

/** Verifies exact generated Java for record of list. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class RecordOfListTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testRecordOfListType() throws Exception {
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
				\trecord_of_list_of_boolean: type record (
				\t\tfield1: list of aadlboolean;
				\t\tfield2: list of list of aadlboolean;
				\t\tfield3: list of list of list of aadlboolean;
				\t\tfield4: list of list of list of list of aadlboolean;
				\t\tfield5: list of list of list of list of list of aadlboolean;
				\t);
				\trecord_of_list_of_string: type record (
				\t\tfield1: list of aadlstring;
				\t\tfield5: list of list of list of list of list of aadlstring;
				\t);
				\trecord_of_list_of_classifier: type record (
				\t\tfield1: list of classifier;
				\t\tfield5: list of list of list of list of list of classifier;
				\t);
				\trecord_of_list_of_integer_no_units: type record (field: list of aadlinteger;);
				\trecord_of_list_of_real_no_units: type record (field: list of aadlreal;);
				\trecord_of_list_of_reference: type record (
				\t\tfield1: list of reference;
				\t\tfield5: list of list of list of list of list of reference;
				\t);
				\t
				\trecord_of_list_of_owned_types: type record (
				\t\towned_enum: list of enumeration (mercury, gemini, apollo);
				\t\towned_units: list of units (ms, s => ms * 1000);
				\t\towned_integer_with_units: list of aadlinteger units ps1::time;
				\t\towned_range: list of range of aadlinteger;
				\t\towned_record: list of record (
				\t\t\tboolean_field: aadlboolean;
				\t\t\trecord_field: record (
				\t\t\t\tstring_field: aadlstring;
				\t\t\t\tinteger_field: aadlinteger;
				\t\t\t);
				\t\t);
				\t);
				\t
				\trecord_of_list_of_referenced_types: type record (
				\t\tenum_no_import: list of ps1::enum_type_1;
				\t\tenum_with_import: list of ps2::color;
				\t\tunits_no_import: list of ps1::time;
				\t\tunits_with_import: list of ps2::mass;
				\t\tnumber_with_units_no_import: list of ps1::integer_owned_units;
				\t\tnumber_with_units_with_import: list of ps2::mass_type;
				\t\trange_no_import: list of ps1::range_of_integer_no_units;
				\t\trange_with_import: list of ps2::basic_range;
				\t\trecord_no_import: list of ps1::record_of_boolean;
				\t\trecord_with_import: list of ps2::basic_record;
				\t);
				end ps1;
				""";
		var ps1Class = """
				package ps1;

				public final class Ps1 {
				\tpublic static final String PS1__NAME = "ps1";

				\tprivate Ps1() {}
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
		var recordOfListOfBoolean = """
				package ps1;

				import java.util.List;
				import java.util.Objects;
				import java.util.Optional;
				import java.util.stream.Collectors;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.BooleanLiteral;
				import org.osate.aadl2.ListValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordOfListOfBoolean extends GeneratedRecord {
				\tpublic static final String FIELD1__NAME = "field1";
				\tpublic static final String FIELD2__NAME = "field2";
				\tpublic static final String FIELD3__NAME = "field3";
				\tpublic static final String FIELD4__NAME = "field4";
				\tpublic static final String FIELD5__NAME = "field5";
				\tpublic static final URI FIELD1__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedField.0");
				\tpublic static final URI FIELD2__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedField.1");
				\tpublic static final URI FIELD3__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedField.2");
				\tpublic static final URI FIELD4__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedField.3");
				\tpublic static final URI FIELD5__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedField.4");

				\tprivate final Optional<List<Boolean>> field1;
				\tprivate final Optional<List<List<Boolean>>> field2;
				\tprivate final Optional<List<List<List<Boolean>>>> field3;
				\tprivate final Optional<List<List<List<List<Boolean>>>>> field4;
				\tprivate final Optional<List<List<List<List<List<Boolean>>>>>> field5;

				\tpublic RecordOfListOfBoolean(
				\t\t\tOptional<List<Boolean>> field1,
				\t\t\tOptional<List<List<Boolean>>> field2,
				\t\t\tOptional<List<List<List<Boolean>>>> field3,
				\t\t\tOptional<List<List<List<List<Boolean>>>>> field4,
				\t\t\tOptional<List<List<List<List<List<Boolean>>>>>> field5
				\t) {
				\t\tthis.field1 = field1;
				\t\tthis.field2 = field2;
				\t\tthis.field3 = field3;
				\t\tthis.field4 = field4;
				\t\tthis.field5 = field5;
				\t}

				\tpublic RecordOfListOfBoolean(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<Boolean>> field1_local;
				\t\ttry {
				\t\t\tfield1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((BooleanLiteral) resolved1).getValue();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield1_local = Optional.empty();
				\t\t}
				\t\tthis.field1 = field1_local;

				\t\tOptional<List<List<Boolean>>> field2_local;
				\t\ttry {
				\t\t\tfield2_local = findFieldValue(recordValue, FIELD2__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\t\treturn ((BooleanLiteral) resolved2).getValue();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield2_local = Optional.empty();
				\t\t}
				\t\tthis.field2 = field2_local;

				\t\tOptional<List<List<List<Boolean>>>> field3_local;
				\t\ttry {
				\t\t\tfield3_local = findFieldValue(recordValue, FIELD3__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\t\treturn ((BooleanLiteral) resolved3).getValue();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield3_local = Optional.empty();
				\t\t}
				\t\tthis.field3 = field3_local;

				\t\tOptional<List<List<List<List<Boolean>>>>> field4_local;
				\t\ttry {
				\t\t\tfield4_local = findFieldValue(recordValue, FIELD4__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
				\t\t\t\t\t\t\t\treturn ((BooleanLiteral) resolved4).getValue();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield4_local = Optional.empty();
				\t\t}
				\t\tthis.field4 = field4_local;

				\t\tOptional<List<List<List<List<List<Boolean>>>>>> field5_local;
				\t\ttry {
				\t\t\tfield5_local = findFieldValue(recordValue, FIELD5__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
				\t\t\t\t\t\t\t\treturn ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
				\t\t\t\t\t\t\t\t\tvar resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
				\t\t\t\t\t\t\t\t\treturn ((BooleanLiteral) resolved5).getValue();
				\t\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield5_local = Optional.empty();
				\t\t}
				\t\tthis.field5 = field5_local;
				\t}

				\tpublic RecordOfListOfBoolean(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<Boolean>> field1_local;
				\t\ttry {
				\t\t\tfield1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((BooleanLiteral) resolved1).getValue();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield1_local = Optional.empty();
				\t\t}
				\t\tthis.field1 = field1_local;

				\t\tOptional<List<List<Boolean>>> field2_local;
				\t\ttry {
				\t\t\tfield2_local = findFieldValue(recordValue, FIELD2__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\t\t\treturn ((BooleanLiteral) resolved2).getValue();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield2_local = Optional.empty();
				\t\t}
				\t\tthis.field2 = field2_local;

				\t\tOptional<List<List<List<Boolean>>>> field3_local;
				\t\ttry {
				\t\t\tfield3_local = findFieldValue(recordValue, FIELD3__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3);
				\t\t\t\t\t\t\treturn ((BooleanLiteral) resolved3).getValue();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield3_local = Optional.empty();
				\t\t}
				\t\tthis.field3 = field3_local;

				\t\tOptional<List<List<List<List<Boolean>>>>> field4_local;
				\t\ttry {
				\t\t\tfield4_local = findFieldValue(recordValue, FIELD4__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3);
				\t\t\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4);
				\t\t\t\t\t\t\t\treturn ((BooleanLiteral) resolved4).getValue();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield4_local = Optional.empty();
				\t\t}
				\t\tthis.field4 = field4_local;

				\t\tOptional<List<List<List<List<List<Boolean>>>>>> field5_local;
				\t\ttry {
				\t\t\tfield5_local = findFieldValue(recordValue, FIELD5__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3);
				\t\t\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4);
				\t\t\t\t\t\t\t\treturn ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
				\t\t\t\t\t\t\t\t\tvar resolved5 = CodeGenUtil.resolveNamedValue(element5);
				\t\t\t\t\t\t\t\t\treturn ((BooleanLiteral) resolved5).getValue();
				\t\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield5_local = Optional.empty();
				\t\t}
				\t\tthis.field5 = field5_local;
				\t}

				\tpublic Optional<List<Boolean>> getField1() {
				\t\treturn field1;
				\t}

				\tpublic Optional<List<List<Boolean>>> getField2() {
				\t\treturn field2;
				\t}

				\tpublic Optional<List<List<List<Boolean>>>> getField3() {
				\t\treturn field3;
				\t}

				\tpublic Optional<List<List<List<List<Boolean>>>>> getField4() {
				\t\treturn field4;
				\t}

				\tpublic Optional<List<List<List<List<List<Boolean>>>>>> getField5() {
				\t\treturn field5;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (field1.isEmpty()
				\t\t\t\t&& field2.isEmpty()
				\t\t\t\t&& field3.isEmpty()
				\t\t\t\t&& field4.isEmpty()
				\t\t\t\t&& field5.isEmpty()
				\t\t) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\tfield1.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD1__URI, FIELD1__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1)));
				\t\t});
				\t\tfield2.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD2__URI, FIELD2__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1, element2 -> CodeGenUtil.toPropertyExpression(element2))));
				\t\t});
				\t\tfield3.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD3__URI, FIELD3__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1, element2 -> CodeGenUtil.toPropertyExpression(element2, element3 -> CodeGenUtil.toPropertyExpression(element3)))));
				\t\t});
				\t\tfield4.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD4__URI, FIELD4__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1, element2 -> CodeGenUtil.toPropertyExpression(element2, element3 -> CodeGenUtil.toPropertyExpression(element3, element4 -> CodeGenUtil.toPropertyExpression(element4))))));
				\t\t});
				\t\tfield5.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD5__URI, FIELD5__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1, element2 -> CodeGenUtil.toPropertyExpression(element2, element3 -> CodeGenUtil.toPropertyExpression(element3, element4 -> CodeGenUtil.toPropertyExpression(element4, element5 -> CodeGenUtil.toPropertyExpression(element5)))))));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(
				\t\t\t\tfield1,
				\t\t\t\tfield2,
				\t\t\t\tfield3,
				\t\t\t\tfield4,
				\t\t\t\tfield5
				\t\t);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordOfListOfBoolean other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.field1, other.field1)
				\t\t\t\t&& Objects.equals(this.field2, other.field2)
				\t\t\t\t&& Objects.equals(this.field3, other.field3)
				\t\t\t\t&& Objects.equals(this.field4, other.field4)
				\t\t\t\t&& Objects.equals(this.field5, other.field5);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.field1.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD1__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.field2.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD2__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(element1 -> element1.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.field3.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD3__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(element1 -> element1.stream().map(element2 -> element2.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.field4.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD4__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(element1 -> element1.stream().map(element2 -> element2.stream().map(element3 -> element3.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.field5.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD5__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(element1 -> element1.stream().map(element2 -> element2.stream().map(element3 -> element3.stream().map(element4 -> element4.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var recordOfListOfString = """
				package ps1;

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
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.StringLiteral;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordOfListOfString extends GeneratedRecord {
				\tpublic static final String FIELD1__NAME = "field1";
				\tpublic static final String FIELD5__NAME = "field5";
				\tpublic static final URI FIELD1__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.6/@ownedField.0");
				\tpublic static final URI FIELD5__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.6/@ownedField.1");

				\tprivate final Optional<List<String>> field1;
				\tprivate final Optional<List<List<List<List<List<String>>>>>> field5;

				\tpublic RecordOfListOfString(
				\t\t\tOptional<List<String>> field1,
				\t\t\tOptional<List<List<List<List<List<String>>>>>> field5
				\t) {
				\t\tthis.field1 = field1;
				\t\tthis.field5 = field5;
				\t}

				\tpublic RecordOfListOfString(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<String>> field1_local;
				\t\ttry {
				\t\t\tfield1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((StringLiteral) resolved1).getValue();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield1_local = Optional.empty();
				\t\t}
				\t\tthis.field1 = field1_local;

				\t\tOptional<List<List<List<List<List<String>>>>>> field5_local;
				\t\ttry {
				\t\t\tfield5_local = findFieldValue(recordValue, FIELD5__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
				\t\t\t\t\t\t\t\treturn ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
				\t\t\t\t\t\t\t\t\tvar resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
				\t\t\t\t\t\t\t\t\treturn ((StringLiteral) resolved5).getValue();
				\t\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield5_local = Optional.empty();
				\t\t}
				\t\tthis.field5 = field5_local;
				\t}

				\tpublic RecordOfListOfString(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<String>> field1_local;
				\t\ttry {
				\t\t\tfield1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((StringLiteral) resolved1).getValue();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield1_local = Optional.empty();
				\t\t}
				\t\tthis.field1 = field1_local;

				\t\tOptional<List<List<List<List<List<String>>>>>> field5_local;
				\t\ttry {
				\t\t\tfield5_local = findFieldValue(recordValue, FIELD5__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3);
				\t\t\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4);
				\t\t\t\t\t\t\t\treturn ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
				\t\t\t\t\t\t\t\t\tvar resolved5 = CodeGenUtil.resolveNamedValue(element5);
				\t\t\t\t\t\t\t\t\treturn ((StringLiteral) resolved5).getValue();
				\t\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield5_local = Optional.empty();
				\t\t}
				\t\tthis.field5 = field5_local;
				\t}

				\tpublic Optional<List<String>> getField1() {
				\t\treturn field1;
				\t}

				\tpublic Optional<List<List<List<List<List<String>>>>>> getField5() {
				\t\treturn field5;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (field1.isEmpty()
				\t\t\t\t&& field5.isEmpty()
				\t\t) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\tfield1.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD1__URI, FIELD1__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1)));
				\t\t});
				\t\tfield5.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD5__URI, FIELD5__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1, element2 -> CodeGenUtil.toPropertyExpression(element2, element3 -> CodeGenUtil.toPropertyExpression(element3, element4 -> CodeGenUtil.toPropertyExpression(element4, element5 -> CodeGenUtil.toPropertyExpression(element5)))))));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(
				\t\t\t\tfield1,
				\t\t\t\tfield5
				\t\t);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordOfListOfString other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.field1, other.field1)
				\t\t\t\t&& Objects.equals(this.field5, other.field5);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.field1.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD1__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(element1 -> '\\"' + element1 + '\\"').collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.field5.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD5__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(element1 -> element1.stream().map(element2 -> element2.stream().map(element3 -> element3.stream().map(element4 -> element4.stream().map(element5 -> '\\"' + element5 + '\\"').collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var recordOfListOfClassifier = """
				package ps1;

				import java.util.List;
				import java.util.Objects;
				import java.util.Optional;
				import java.util.stream.Collectors;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.Classifier;
				import org.osate.aadl2.ClassifierValue;
				import org.osate.aadl2.ListValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordOfListOfClassifier extends GeneratedRecord {
				\tpublic static final String FIELD1__NAME = "field1";
				\tpublic static final String FIELD5__NAME = "field5";
				\tpublic static final URI FIELD1__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.7/@ownedField.0");
				\tpublic static final URI FIELD5__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.7/@ownedField.1");

				\tprivate final Optional<List<Classifier>> field1;
				\tprivate final Optional<List<List<List<List<List<Classifier>>>>>> field5;

				\tpublic RecordOfListOfClassifier(
				\t\t\tOptional<List<Classifier>> field1,
				\t\t\tOptional<List<List<List<List<List<Classifier>>>>>> field5
				\t) {
				\t\tthis.field1 = field1;
				\t\tthis.field5 = field5;
				\t}

				\tpublic RecordOfListOfClassifier(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<Classifier>> field1_local;
				\t\ttry {
				\t\t\tfield1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((ClassifierValue) resolved1).getClassifier();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield1_local = Optional.empty();
				\t\t}
				\t\tthis.field1 = field1_local;

				\t\tOptional<List<List<List<List<List<Classifier>>>>>> field5_local;
				\t\ttry {
				\t\t\tfield5_local = findFieldValue(recordValue, FIELD5__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
				\t\t\t\t\t\t\t\treturn ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
				\t\t\t\t\t\t\t\t\tvar resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
				\t\t\t\t\t\t\t\t\treturn ((ClassifierValue) resolved5).getClassifier();
				\t\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield5_local = Optional.empty();
				\t\t}
				\t\tthis.field5 = field5_local;
				\t}

				\tpublic RecordOfListOfClassifier(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<Classifier>> field1_local;
				\t\ttry {
				\t\t\tfield1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((ClassifierValue) resolved1).getClassifier();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield1_local = Optional.empty();
				\t\t}
				\t\tthis.field1 = field1_local;

				\t\tOptional<List<List<List<List<List<Classifier>>>>>> field5_local;
				\t\ttry {
				\t\t\tfield5_local = findFieldValue(recordValue, FIELD5__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3);
				\t\t\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4);
				\t\t\t\t\t\t\t\treturn ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
				\t\t\t\t\t\t\t\t\tvar resolved5 = CodeGenUtil.resolveNamedValue(element5);
				\t\t\t\t\t\t\t\t\treturn ((ClassifierValue) resolved5).getClassifier();
				\t\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield5_local = Optional.empty();
				\t\t}
				\t\tthis.field5 = field5_local;
				\t}

				\tpublic Optional<List<Classifier>> getField1() {
				\t\treturn field1;
				\t}

				\tpublic Optional<List<List<List<List<List<Classifier>>>>>> getField5() {
				\t\treturn field5;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (field1.isEmpty()
				\t\t\t\t&& field5.isEmpty()
				\t\t) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\tfield1.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD1__URI, FIELD1__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1)));
				\t\t});
				\t\tfield5.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD5__URI, FIELD5__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1, element2 -> CodeGenUtil.toPropertyExpression(element2, element3 -> CodeGenUtil.toPropertyExpression(element3, element4 -> CodeGenUtil.toPropertyExpression(element4, element5 -> CodeGenUtil.toPropertyExpression(element5)))))));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(
				\t\t\t\tfield1,
				\t\t\t\tfield5
				\t\t);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordOfListOfClassifier other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.field1, other.field1)
				\t\t\t\t&& Objects.equals(this.field5, other.field5);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.field1.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD1__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(element1 -> "classifier (" + element1.getQualifiedName() + ")").collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.field5.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD5__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(element1 -> element1.stream().map(element2 -> element2.stream().map(element3 -> element3.stream().map(element4 -> element4.stream().map(element5 -> "classifier (" + element5.getQualifiedName() + ")").collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var recordOfListOfIntegerNoUnits = """
				package ps1;

				import java.util.List;
				import java.util.Objects;
				import java.util.Optional;
				import java.util.stream.Collectors;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.IntegerLiteral;
				import org.osate.aadl2.ListValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordOfListOfIntegerNoUnits extends GeneratedRecord {
				\tpublic static final String FIELD__NAME = "field";
				\tpublic static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.8/@ownedField.0");

				\tprivate final Optional<List<Long>> field;

				\tpublic RecordOfListOfIntegerNoUnits(Optional<List<Long>> field) {
				\t\tthis.field = field;
				\t}

				\tpublic RecordOfListOfIntegerNoUnits(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<Long>> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((IntegerLiteral) resolved1).getValue();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic RecordOfListOfIntegerNoUnits(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<Long>> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((IntegerLiteral) resolved1).getValue();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic Optional<List<Long>> getField() {
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
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1)));
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
				\t\tif (!(obj instanceof RecordOfListOfIntegerNoUnits other)) {
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
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var recordOfListOfRealNoUnits = """
				package ps1;

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
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RealLiteral;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordOfListOfRealNoUnits extends GeneratedRecord {
				\tpublic static final String FIELD__NAME = "field";
				\tpublic static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.0");

				\tprivate final Optional<List<Double>> field;

				\tpublic RecordOfListOfRealNoUnits(Optional<List<Double>> field) {
				\t\tthis.field = field;
				\t}

				\tpublic RecordOfListOfRealNoUnits(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<Double>> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((RealLiteral) resolved1).getValue();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic RecordOfListOfRealNoUnits(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<Double>> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((RealLiteral) resolved1).getValue();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic Optional<List<Double>> getField() {
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
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1)));
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
				\t\tif (!(obj instanceof RecordOfListOfRealNoUnits other)) {
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
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var recordOfListOfReference = """
				package ps1;

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
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.instance.InstanceObject;
				import org.osate.aadl2.instance.InstanceReferenceValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordOfListOfReference extends GeneratedRecord {
				\tpublic static final String FIELD1__NAME = "field1";
				\tpublic static final String FIELD5__NAME = "field5";
				\tpublic static final URI FIELD1__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.10/@ownedField.0");
				\tpublic static final URI FIELD5__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.10/@ownedField.1");

				\tprivate final Optional<List<InstanceObject>> field1;
				\tprivate final Optional<List<List<List<List<List<InstanceObject>>>>>> field5;

				\tpublic RecordOfListOfReference(
				\t\t\tOptional<List<InstanceObject>> field1,
				\t\t\tOptional<List<List<List<List<List<InstanceObject>>>>>> field5
				\t) {
				\t\tthis.field1 = field1;
				\t\tthis.field5 = field5;
				\t}

				\tpublic RecordOfListOfReference(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<InstanceObject>> field1_local;
				\t\ttry {
				\t\t\tfield1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield1_local = Optional.empty();
				\t\t}
				\t\tthis.field1 = field1_local;

				\t\tOptional<List<List<List<List<List<InstanceObject>>>>>> field5_local;
				\t\ttry {
				\t\t\tfield5_local = findFieldValue(recordValue, FIELD5__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
				\t\t\t\t\t\t\t\treturn ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
				\t\t\t\t\t\t\t\t\tvar resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
				\t\t\t\t\t\t\t\t\treturn ((InstanceReferenceValue) resolved5).getReferencedInstanceObject();
				\t\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield5_local = Optional.empty();
				\t\t}
				\t\tthis.field5 = field5_local;
				\t}

				\tpublic RecordOfListOfReference(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<InstanceObject>> field1_local;
				\t\ttry {
				\t\t\tfield1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield1_local = Optional.empty();
				\t\t}
				\t\tthis.field1 = field1_local;

				\t\tOptional<List<List<List<List<List<InstanceObject>>>>>> field5_local;
				\t\ttry {
				\t\t\tfield5_local = findFieldValue(recordValue, FIELD5__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3);
				\t\t\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4);
				\t\t\t\t\t\t\t\treturn ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
				\t\t\t\t\t\t\t\t\tvar resolved5 = CodeGenUtil.resolveNamedValue(element5);
				\t\t\t\t\t\t\t\t\treturn ((InstanceReferenceValue) resolved5).getReferencedInstanceObject();
				\t\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield5_local = Optional.empty();
				\t\t}
				\t\tthis.field5 = field5_local;
				\t}

				\tpublic Optional<List<InstanceObject>> getField1() {
				\t\treturn field1;
				\t}

				\tpublic Optional<List<List<List<List<List<InstanceObject>>>>>> getField5() {
				\t\treturn field5;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (field1.isEmpty()
				\t\t\t\t&& field5.isEmpty()
				\t\t) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\tfield1.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD1__URI, FIELD1__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1)));
				\t\t});
				\t\tfield5.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD5__URI, FIELD5__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1, element2 -> CodeGenUtil.toPropertyExpression(element2, element3 -> CodeGenUtil.toPropertyExpression(element3, element4 -> CodeGenUtil.toPropertyExpression(element4, element5 -> CodeGenUtil.toPropertyExpression(element5)))))));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(
				\t\t\t\tfield1,
				\t\t\t\tfield5
				\t\t);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordOfListOfReference other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.field1, other.field1)
				\t\t\t\t&& Objects.equals(this.field5, other.field5);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.field1.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD1__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(element1 -> "reference (" + element1.getName() + ")").collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.field5.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD5__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(element1 -> element1.stream().map(element2 -> element2.stream().map(element3 -> element3.stream().map(element4 -> element4.stream().map(element5 -> "reference (" + element5.getName() + ")").collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var recordOfListOfOwnedTypes = """
				package ps1;

				import java.util.List;
				import java.util.Objects;
				import java.util.Optional;
				import java.util.OptionalLong;
				import java.util.stream.Collectors;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.BooleanLiteral;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.IntegerLiteral;
				import org.osate.aadl2.ListValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.StringLiteral;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedEnumeration;
				import org.osate.pluginsupport.properties.GeneratedRecord;
				import org.osate.pluginsupport.properties.GeneratedUnits;
				import org.osate.pluginsupport.properties.IntegerRange;
				import org.osate.pluginsupport.properties.IntegerWithUnits;

				public class RecordOfListOfOwnedTypes extends GeneratedRecord {
				\tpublic static final String OWNED_ENUM__NAME = "owned_enum";
				\tpublic static final String OWNED_UNITS__NAME = "owned_units";
				\tpublic static final String OWNED_INTEGER_WITH_UNITS__NAME = "owned_integer_with_units";
				\tpublic static final String OWNED_RANGE__NAME = "owned_range";
				\tpublic static final String OWNED_RECORD__NAME = "owned_record";
				\tpublic static final URI OWNED_ENUM__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.0");
				\tpublic static final URI OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.1");
				\tpublic static final URI OWNED_INTEGER_WITH_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.2");
				\tpublic static final URI OWNED_RANGE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.3");
				\tpublic static final URI OWNED_RECORD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.4");

				\tprivate final Optional<List<OwnedEnum_FieldType>> ownedEnum;
				\tprivate final Optional<List<OwnedUnits_FieldType>> ownedUnits;
				\tprivate final Optional<List<IntegerWithUnits<Time>>> ownedIntegerWithUnits;
				\tprivate final Optional<List<IntegerRange>> ownedRange;
				\tprivate final Optional<List<OwnedRecord_FieldType>> ownedRecord;

				\tpublic RecordOfListOfOwnedTypes(
				\t\t\tOptional<List<OwnedEnum_FieldType>> ownedEnum,
				\t\t\tOptional<List<OwnedUnits_FieldType>> ownedUnits,
				\t\t\tOptional<List<IntegerWithUnits<Time>>> ownedIntegerWithUnits,
				\t\t\tOptional<List<IntegerRange>> ownedRange,
				\t\t\tOptional<List<OwnedRecord_FieldType>> ownedRecord
				\t) {
				\t\tthis.ownedEnum = ownedEnum;
				\t\tthis.ownedUnits = ownedUnits;
				\t\tthis.ownedIntegerWithUnits = ownedIntegerWithUnits;
				\t\tthis.ownedRange = ownedRange;
				\t\tthis.ownedRecord = ownedRecord;
				\t}

				\tpublic RecordOfListOfOwnedTypes(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<OwnedEnum_FieldType>> ownedEnum_local;
				\t\ttry {
				\t\t\townedEnum_local = findFieldValue(recordValue, OWNED_ENUM__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn OwnedEnum_FieldType.valueOf(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedEnum_local = Optional.empty();
				\t\t}
				\t\tthis.ownedEnum = ownedEnum_local;

				\t\tOptional<List<OwnedUnits_FieldType>> ownedUnits_local;
				\t\ttry {
				\t\t\townedUnits_local = findFieldValue(recordValue, OWNED_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn OwnedUnits_FieldType.valueOf(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedUnits_local = Optional.empty();
				\t\t}
				\t\tthis.ownedUnits = ownedUnits_local;

				\t\tOptional<List<IntegerWithUnits<Time>>> ownedIntegerWithUnits_local;
				\t\ttry {
				\t\t\townedIntegerWithUnits_local = findFieldValue(recordValue, OWNED_INTEGER_WITH_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new IntegerWithUnits<>(resolved1, Time.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedIntegerWithUnits_local = Optional.empty();
				\t\t}
				\t\tthis.ownedIntegerWithUnits = ownedIntegerWithUnits_local;

				\t\tOptional<List<IntegerRange>> ownedRange_local;
				\t\ttry {
				\t\t\townedRange_local = findFieldValue(recordValue, OWNED_RANGE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new IntegerRange(resolved1, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRange_local = Optional.empty();
				\t\t}
				\t\tthis.ownedRange = ownedRange_local;

				\t\tOptional<List<OwnedRecord_FieldType>> ownedRecord_local;
				\t\ttry {
				\t\t\townedRecord_local = findFieldValue(recordValue, OWNED_RECORD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new OwnedRecord_FieldType(resolved1, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRecord_local = Optional.empty();
				\t\t}
				\t\tthis.ownedRecord = ownedRecord_local;
				\t}

				\tpublic RecordOfListOfOwnedTypes(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<OwnedEnum_FieldType>> ownedEnum_local;
				\t\ttry {
				\t\t\townedEnum_local = findFieldValue(recordValue, OWNED_ENUM__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn OwnedEnum_FieldType.valueOf(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedEnum_local = Optional.empty();
				\t\t}
				\t\tthis.ownedEnum = ownedEnum_local;

				\t\tOptional<List<OwnedUnits_FieldType>> ownedUnits_local;
				\t\ttry {
				\t\t\townedUnits_local = findFieldValue(recordValue, OWNED_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn OwnedUnits_FieldType.valueOf(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedUnits_local = Optional.empty();
				\t\t}
				\t\tthis.ownedUnits = ownedUnits_local;

				\t\tOptional<List<IntegerWithUnits<Time>>> ownedIntegerWithUnits_local;
				\t\ttry {
				\t\t\townedIntegerWithUnits_local = findFieldValue(recordValue, OWNED_INTEGER_WITH_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new IntegerWithUnits<>(resolved1, Time.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedIntegerWithUnits_local = Optional.empty();
				\t\t}
				\t\tthis.ownedIntegerWithUnits = ownedIntegerWithUnits_local;

				\t\tOptional<List<IntegerRange>> ownedRange_local;
				\t\ttry {
				\t\t\townedRange_local = findFieldValue(recordValue, OWNED_RANGE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new IntegerRange(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRange_local = Optional.empty();
				\t\t}
				\t\tthis.ownedRange = ownedRange_local;

				\t\tOptional<List<OwnedRecord_FieldType>> ownedRecord_local;
				\t\ttry {
				\t\t\townedRecord_local = findFieldValue(recordValue, OWNED_RECORD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new OwnedRecord_FieldType(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRecord_local = Optional.empty();
				\t\t}
				\t\tthis.ownedRecord = ownedRecord_local;
				\t}

				\tpublic Optional<List<OwnedEnum_FieldType>> getOwnedEnum() {
				\t\treturn ownedEnum;
				\t}

				\tpublic Optional<List<OwnedUnits_FieldType>> getOwnedUnits() {
				\t\treturn ownedUnits;
				\t}

				\tpublic Optional<List<IntegerWithUnits<Time>>> getOwnedIntegerWithUnits() {
				\t\treturn ownedIntegerWithUnits;
				\t}

				\tpublic Optional<List<IntegerRange>> getOwnedRange() {
				\t\treturn ownedRange;
				\t}

				\tpublic Optional<List<OwnedRecord_FieldType>> getOwnedRecord() {
				\t\treturn ownedRecord;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (ownedEnum.isEmpty()
				\t\t\t\t&& ownedUnits.isEmpty()
				\t\t\t\t&& ownedIntegerWithUnits.isEmpty()
				\t\t\t\t&& ownedRange.isEmpty()
				\t\t\t\t&& ownedRecord.isEmpty()
				\t\t) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\townedEnum.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_ENUM__URI, OWNED_ENUM__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\townedUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_UNITS__URI, OWNED_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\townedIntegerWithUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_INTEGER_WITH_UNITS__URI, OWNED_INTEGER_WITH_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\townedRange.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_RANGE__URI, OWNED_RANGE__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression()));
				\t\t});
				\t\townedRecord.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_RECORD__URI, OWNED_RECORD__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(
				\t\t\t\townedEnum,
				\t\t\t\townedUnits,
				\t\t\t\townedIntegerWithUnits,
				\t\t\t\townedRange,
				\t\t\t\townedRecord
				\t\t);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordOfListOfOwnedTypes other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.ownedEnum, other.ownedEnum)
				\t\t\t\t&& Objects.equals(this.ownedUnits, other.ownedUnits)
				\t\t\t\t&& Objects.equals(this.ownedIntegerWithUnits, other.ownedIntegerWithUnits)
				\t\t\t\t&& Objects.equals(this.ownedRange, other.ownedRange)
				\t\t\t\t&& Objects.equals(this.ownedRecord, other.ownedRecord);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.ownedEnum.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_ENUM__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedUnits.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedIntegerWithUnits.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_INTEGER_WITH_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedRange.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_RANGE__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedRecord.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_RECORD__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}

				\tpublic enum OwnedEnum_FieldType implements GeneratedEnumeration {
				\t\tMERCURY("mercury", "__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.0/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
				\t\tGEMINI("gemini", "__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.0/@ownedPropertyType/@ownedElementType/@ownedLiteral.1"),
				\t\tAPOLLO("apollo", "__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.0/@ownedPropertyType/@ownedElementType/@ownedLiteral.2");

				\t\tprivate final String originalName;
				\t\tprivate final URI uri;

				\t\tprivate OwnedEnum_FieldType(String originalName, String uri) {
				\t\t\tthis.originalName = originalName;
				\t\t\tthis.uri = URI.createURI(uri);
				\t\t}

				\t\tpublic static OwnedEnum_FieldType valueOf(PropertyExpression propertyExpression) {
				\t\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\t\treturn valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
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

				\tpublic enum OwnedUnits_FieldType implements GeneratedUnits<OwnedUnits_FieldType> {
				\t\tMS(1.0, "ms", "__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.1/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
				\t\tS(1000.0, "s", "__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.1/@ownedPropertyType/@ownedElementType/@ownedLiteral.1");

				\t\tprivate final double factorToBase;
				\t\tprivate final String originalName;
				\t\tprivate final URI uri;

				\t\tprivate OwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
				\t\t\tthis.factorToBase = factorToBase;
				\t\t\tthis.originalName = originalName;
				\t\t\tthis.uri = URI.createURI(uri);
				\t\t}

				\t\tpublic static OwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
				\t\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorToBase() {
				\t\t\treturn factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorTo(OwnedUnits_FieldType target) {
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

				\tpublic static class OwnedRecord_FieldType extends GeneratedRecord {
				\t\tpublic static final String BOOLEAN_FIELD__NAME = "boolean_field";
				\t\tpublic static final String RECORD_FIELD__NAME = "record_field";
				\t\tpublic static final URI BOOLEAN_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.4/@ownedPropertyType/@ownedElementType/@ownedField.0");
				\t\tpublic static final URI RECORD_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.4/@ownedPropertyType/@ownedElementType/@ownedField.1");

				\t\tprivate final Optional<Boolean> booleanField;
				\t\tprivate final Optional<RecordField_FieldType> recordField;

				\t\tpublic OwnedRecord_FieldType(
				\t\t\t\tOptional<Boolean> booleanField,
				\t\t\t\tOptional<RecordField_FieldType> recordField
				\t\t) {
				\t\t\tthis.booleanField = booleanField;
				\t\t\tthis.recordField = recordField;
				\t\t}

				\t\tpublic OwnedRecord_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\tOptional<Boolean> booleanField_local;
				\t\t\ttry {
				\t\t\t\tbooleanField_local = findFieldValue(recordValue, BOOLEAN_FIELD__NAME).map(field -> {
				\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t\t});
				\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\tbooleanField_local = Optional.empty();
				\t\t\t}
				\t\t\tthis.booleanField = booleanField_local;

				\t\t\tOptional<RecordField_FieldType> recordField_local;
				\t\t\ttry {
				\t\t\t\trecordField_local = findFieldValue(recordValue, RECORD_FIELD__NAME).map(field -> {
				\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\t\treturn new RecordField_FieldType(resolved, lookupContext, mode);
				\t\t\t\t});
				\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\trecordField_local = Optional.empty();
				\t\t\t}
				\t\t\tthis.recordField = recordField_local;
				\t\t}

				\t\tpublic OwnedRecord_FieldType(PropertyExpression propertyExpression) {
				\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\tOptional<Boolean> booleanField_local;
				\t\t\ttry {
				\t\t\t\tbooleanField_local = findFieldValue(recordValue, BOOLEAN_FIELD__NAME).map(field -> {
				\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t\t});
				\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\tbooleanField_local = Optional.empty();
				\t\t\t}
				\t\t\tthis.booleanField = booleanField_local;

				\t\t\tOptional<RecordField_FieldType> recordField_local;
				\t\t\ttry {
				\t\t\t\trecordField_local = findFieldValue(recordValue, RECORD_FIELD__NAME).map(field -> {
				\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\t\treturn new RecordField_FieldType(resolved);
				\t\t\t\t});
				\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\trecordField_local = Optional.empty();
				\t\t\t}
				\t\t\tthis.recordField = recordField_local;
				\t\t}

				\t\tpublic Optional<Boolean> getBooleanField() {
				\t\t\treturn booleanField;
				\t\t}

				\t\tpublic Optional<RecordField_FieldType> getRecordField() {
				\t\t\treturn recordField;
				\t\t}

				\t\t@Override
				\t\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\t\tif (booleanField.isEmpty()
				\t\t\t\t\t&& recordField.isEmpty()
				\t\t\t) {
				\t\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t\t}
				\t\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\t\tbooleanField.ifPresent(field -> {
				\t\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\t\tfieldAssociation.setProperty(loadField(resourceSet, BOOLEAN_FIELD__URI, BOOLEAN_FIELD__NAME));
				\t\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t\t});
				\t\t\trecordField.ifPresent(field -> {
				\t\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\t\tfieldAssociation.setProperty(loadField(resourceSet, RECORD_FIELD__URI, RECORD_FIELD__NAME));
				\t\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t\t});
				\t\t\treturn recordValue;
				\t\t}

				\t\t@Override
				\t\tpublic int hashCode() {
				\t\t\treturn Objects.hash(
				\t\t\t\t\tbooleanField,
				\t\t\t\t\trecordField
				\t\t\t);
				\t\t}

				\t\t@Override
				\t\tpublic boolean equals(Object obj) {
				\t\t\tif (this == obj) {
				\t\t\t\treturn true;
				\t\t\t}
				\t\t\tif (!(obj instanceof OwnedRecord_FieldType other)) {
				\t\t\t\treturn false;
				\t\t\t}
				\t\t\treturn Objects.equals(this.booleanField, other.booleanField)
				\t\t\t\t\t&& Objects.equals(this.recordField, other.recordField);
				\t\t}

				\t\t@Override
				\t\tpublic String toString() {
				\t\t\tvar builder = new StringBuilder();
				\t\t\tbuilder.append('[');
				\t\t\tthis.booleanField.ifPresent(field -> {
				\t\t\t\tbuilder.append(BOOLEAN_FIELD__NAME);
				\t\t\t\tbuilder.append(" => ");
				\t\t\t\tbuilder.append(field);
				\t\t\t\tbuilder.append(';');
				\t\t\t});
				\t\t\tthis.recordField.ifPresent(field -> {
				\t\t\t\tbuilder.append(RECORD_FIELD__NAME);
				\t\t\t\tbuilder.append(" => ");
				\t\t\t\tbuilder.append(field);
				\t\t\t\tbuilder.append(';');
				\t\t\t});
				\t\t\tbuilder.append(']');
				\t\t\treturn builder.toString();
				\t\t}

				\t\tpublic static class RecordField_FieldType extends GeneratedRecord {
				\t\t\tpublic static final String STRING_FIELD__NAME = "string_field";
				\t\t\tpublic static final String INTEGER_FIELD__NAME = "integer_field";
				\t\t\tpublic static final URI STRING_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.4/@ownedPropertyType/@ownedElementType/@ownedField.1/@ownedPropertyType/@ownedField.0");
				\t\t\tpublic static final URI INTEGER_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.4/@ownedPropertyType/@ownedElementType/@ownedField.1/@ownedPropertyType/@ownedField.1");

				\t\t\tprivate final Optional<String> stringField;
				\t\t\tprivate final OptionalLong integerField;

				\t\t\tpublic RecordField_FieldType(
				\t\t\t\t\tOptional<String> stringField,
				\t\t\t\t\tOptionalLong integerField
				\t\t\t) {
				\t\t\t\tthis.stringField = stringField;
				\t\t\t\tthis.integerField = integerField;
				\t\t\t}

				\t\t\tpublic RecordField_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\t\tOptional<String> stringField_local;
				\t\t\t\ttry {
				\t\t\t\t\tstringField_local = findFieldValue(recordValue, STRING_FIELD__NAME).map(field -> {
				\t\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t\t\t});
				\t\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\t\tstringField_local = Optional.empty();
				\t\t\t\t}
				\t\t\t\tthis.stringField = stringField_local;

				\t\t\t\tOptionalLong integerField_local;
				\t\t\t\ttry {
				\t\t\t\t\tintegerField_local = findFieldValue(recordValue, INTEGER_FIELD__NAME).map(field -> {
				\t\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\t\tintegerField_local = OptionalLong.empty();
				\t\t\t\t}
				\t\t\t\tthis.integerField = integerField_local;
				\t\t\t}

				\t\t\tpublic RecordField_FieldType(PropertyExpression propertyExpression) {
				\t\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\t\tOptional<String> stringField_local;
				\t\t\t\ttry {
				\t\t\t\t\tstringField_local = findFieldValue(recordValue, STRING_FIELD__NAME).map(field -> {
				\t\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t\t\t});
				\t\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\t\tstringField_local = Optional.empty();
				\t\t\t\t}
				\t\t\t\tthis.stringField = stringField_local;

				\t\t\t\tOptionalLong integerField_local;
				\t\t\t\ttry {
				\t\t\t\t\tintegerField_local = findFieldValue(recordValue, INTEGER_FIELD__NAME).map(field -> {
				\t\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\t\tintegerField_local = OptionalLong.empty();
				\t\t\t\t}
				\t\t\t\tthis.integerField = integerField_local;
				\t\t\t}

				\t\t\tpublic Optional<String> getStringField() {
				\t\t\t\treturn stringField;
				\t\t\t}

				\t\t\tpublic OptionalLong getIntegerField() {
				\t\t\t\treturn integerField;
				\t\t\t}

				\t\t\t@Override
				\t\t\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\t\t\tif (stringField.isEmpty()
				\t\t\t\t\t\t&& integerField.isEmpty()
				\t\t\t\t) {
				\t\t\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t\t\t}
				\t\t\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\t\t\tstringField.ifPresent(field -> {
				\t\t\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\t\t\tfieldAssociation.setProperty(loadField(resourceSet, STRING_FIELD__URI, STRING_FIELD__NAME));
				\t\t\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t\t\t});
				\t\t\t\tintegerField.ifPresent(field -> {
				\t\t\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\t\t\tfieldAssociation.setProperty(loadField(resourceSet, INTEGER_FIELD__URI, INTEGER_FIELD__NAME));
				\t\t\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t\t\t});
				\t\t\t\treturn recordValue;
				\t\t\t}

				\t\t\t@Override
				\t\t\tpublic int hashCode() {
				\t\t\t\treturn Objects.hash(
				\t\t\t\t\t\tstringField,
				\t\t\t\t\t\tintegerField
				\t\t\t\t);
				\t\t\t}

				\t\t\t@Override
				\t\t\tpublic boolean equals(Object obj) {
				\t\t\t\tif (this == obj) {
				\t\t\t\t\treturn true;
				\t\t\t\t}
				\t\t\t\tif (!(obj instanceof RecordField_FieldType other)) {
				\t\t\t\t\treturn false;
				\t\t\t\t}
				\t\t\t\treturn Objects.equals(this.stringField, other.stringField)
				\t\t\t\t\t\t&& Objects.equals(this.integerField, other.integerField);
				\t\t\t}

				\t\t\t@Override
				\t\t\tpublic String toString() {
				\t\t\t\tvar builder = new StringBuilder();
				\t\t\t\tbuilder.append('[');
				\t\t\t\tthis.stringField.ifPresent(field -> {
				\t\t\t\t\tbuilder.append(STRING_FIELD__NAME);
				\t\t\t\t\tbuilder.append(" => \\"");
				\t\t\t\t\tbuilder.append(field);
				\t\t\t\t\tbuilder.append("\\";");
				\t\t\t\t});
				\t\t\t\tthis.integerField.ifPresent(field -> {
				\t\t\t\t\tbuilder.append(INTEGER_FIELD__NAME);
				\t\t\t\t\tbuilder.append(" => ");
				\t\t\t\t\tbuilder.append(field);
				\t\t\t\t\tbuilder.append(';');
				\t\t\t\t});
				\t\t\t\tbuilder.append(']');
				\t\t\t\treturn builder.toString();
				\t\t\t}
				\t\t}
				\t}
				}
				""";
		var recordOfListOfReferencedTypes = """
				package ps1;

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
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;
				import org.osate.pluginsupport.properties.IntegerRange;
				import org.osate.pluginsupport.properties.IntegerWithUnits;
				import org.osate.pluginsupport.properties.RealRange;
				import org.osate.pluginsupport.properties.RealWithUnits;

				import ps2.BasicRecord;
				import ps2.Color;
				import ps2.Mass;

				public class RecordOfListOfReferencedTypes extends GeneratedRecord {
				\tpublic static final String ENUM_NO_IMPORT__NAME = "enum_no_import";
				\tpublic static final String ENUM_WITH_IMPORT__NAME = "enum_with_import";
				\tpublic static final String UNITS_NO_IMPORT__NAME = "units_no_import";
				\tpublic static final String UNITS_WITH_IMPORT__NAME = "units_with_import";
				\tpublic static final String NUMBER_WITH_UNITS_NO_IMPORT__NAME = "number_with_units_no_import";
				\tpublic static final String NUMBER_WITH_UNITS_WITH_IMPORT__NAME = "number_with_units_with_import";
				\tpublic static final String RANGE_NO_IMPORT__NAME = "range_no_import";
				\tpublic static final String RANGE_WITH_IMPORT__NAME = "range_with_import";
				\tpublic static final String RECORD_NO_IMPORT__NAME = "record_no_import";
				\tpublic static final String RECORD_WITH_IMPORT__NAME = "record_with_import";
				\tpublic static final URI ENUM_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.0");
				\tpublic static final URI ENUM_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.1");
				\tpublic static final URI UNITS_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.2");
				\tpublic static final URI UNITS_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.3");
				\tpublic static final URI NUMBER_WITH_UNITS_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.4");
				\tpublic static final URI NUMBER_WITH_UNITS_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.5");
				\tpublic static final URI RANGE_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.6");
				\tpublic static final URI RANGE_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.7");
				\tpublic static final URI RECORD_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.8");
				\tpublic static final URI RECORD_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.9");

				\tprivate final Optional<List<EnumType1>> enumNoImport;
				\tprivate final Optional<List<Color>> enumWithImport;
				\tprivate final Optional<List<Time>> unitsNoImport;
				\tprivate final Optional<List<Mass>> unitsWithImport;
				\tprivate final Optional<List<IntegerWithUnits<IntegerOwnedUnits>>> numberWithUnitsNoImport;
				\tprivate final Optional<List<RealWithUnits<Mass>>> numberWithUnitsWithImport;
				\tprivate final Optional<List<IntegerRange>> rangeNoImport;
				\tprivate final Optional<List<RealRange>> rangeWithImport;
				\tprivate final Optional<List<RecordOfBoolean>> recordNoImport;
				\tprivate final Optional<List<BasicRecord>> recordWithImport;

				\tpublic RecordOfListOfReferencedTypes(
				\t\t\tOptional<List<EnumType1>> enumNoImport,
				\t\t\tOptional<List<Color>> enumWithImport,
				\t\t\tOptional<List<Time>> unitsNoImport,
				\t\t\tOptional<List<Mass>> unitsWithImport,
				\t\t\tOptional<List<IntegerWithUnits<IntegerOwnedUnits>>> numberWithUnitsNoImport,
				\t\t\tOptional<List<RealWithUnits<Mass>>> numberWithUnitsWithImport,
				\t\t\tOptional<List<IntegerRange>> rangeNoImport,
				\t\t\tOptional<List<RealRange>> rangeWithImport,
				\t\t\tOptional<List<RecordOfBoolean>> recordNoImport,
				\t\t\tOptional<List<BasicRecord>> recordWithImport
				\t) {
				\t\tthis.enumNoImport = enumNoImport;
				\t\tthis.enumWithImport = enumWithImport;
				\t\tthis.unitsNoImport = unitsNoImport;
				\t\tthis.unitsWithImport = unitsWithImport;
				\t\tthis.numberWithUnitsNoImport = numberWithUnitsNoImport;
				\t\tthis.numberWithUnitsWithImport = numberWithUnitsWithImport;
				\t\tthis.rangeNoImport = rangeNoImport;
				\t\tthis.rangeWithImport = rangeWithImport;
				\t\tthis.recordNoImport = recordNoImport;
				\t\tthis.recordWithImport = recordWithImport;
				\t}

				\tpublic RecordOfListOfReferencedTypes(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<EnumType1>> enumNoImport_local;
				\t\ttry {
				\t\t\tenumNoImport_local = findFieldValue(recordValue, ENUM_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn EnumType1.valueOf(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tenumNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.enumNoImport = enumNoImport_local;

				\t\tOptional<List<Color>> enumWithImport_local;
				\t\ttry {
				\t\t\tenumWithImport_local = findFieldValue(recordValue, ENUM_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn Color.valueOf(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tenumWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.enumWithImport = enumWithImport_local;

				\t\tOptional<List<Time>> unitsNoImport_local;
				\t\ttry {
				\t\t\tunitsNoImport_local = findFieldValue(recordValue, UNITS_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn Time.valueOf(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tunitsNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.unitsNoImport = unitsNoImport_local;

				\t\tOptional<List<Mass>> unitsWithImport_local;
				\t\ttry {
				\t\t\tunitsWithImport_local = findFieldValue(recordValue, UNITS_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn Mass.valueOf(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tunitsWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.unitsWithImport = unitsWithImport_local;

				\t\tOptional<List<IntegerWithUnits<IntegerOwnedUnits>>> numberWithUnitsNoImport_local;
				\t\ttry {
				\t\t\tnumberWithUnitsNoImport_local = findFieldValue(recordValue, NUMBER_WITH_UNITS_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new IntegerWithUnits<>(resolved1, IntegerOwnedUnits.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tnumberWithUnitsNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.numberWithUnitsNoImport = numberWithUnitsNoImport_local;

				\t\tOptional<List<RealWithUnits<Mass>>> numberWithUnitsWithImport_local;
				\t\ttry {
				\t\t\tnumberWithUnitsWithImport_local = findFieldValue(recordValue, NUMBER_WITH_UNITS_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new RealWithUnits<>(resolved1, Mass.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tnumberWithUnitsWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.numberWithUnitsWithImport = numberWithUnitsWithImport_local;

				\t\tOptional<List<IntegerRange>> rangeNoImport_local;
				\t\ttry {
				\t\t\trangeNoImport_local = findFieldValue(recordValue, RANGE_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new IntegerRange(resolved1, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trangeNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.rangeNoImport = rangeNoImport_local;

				\t\tOptional<List<RealRange>> rangeWithImport_local;
				\t\ttry {
				\t\t\trangeWithImport_local = findFieldValue(recordValue, RANGE_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new RealRange(resolved1, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trangeWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.rangeWithImport = rangeWithImport_local;

				\t\tOptional<List<RecordOfBoolean>> recordNoImport_local;
				\t\ttry {
				\t\t\trecordNoImport_local = findFieldValue(recordValue, RECORD_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new RecordOfBoolean(resolved1, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trecordNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.recordNoImport = recordNoImport_local;

				\t\tOptional<List<BasicRecord>> recordWithImport_local;
				\t\ttry {
				\t\t\trecordWithImport_local = findFieldValue(recordValue, RECORD_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn new BasicRecord(resolved1, lookupContext, mode);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trecordWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.recordWithImport = recordWithImport_local;
				\t}

				\tpublic RecordOfListOfReferencedTypes(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<List<EnumType1>> enumNoImport_local;
				\t\ttry {
				\t\t\tenumNoImport_local = findFieldValue(recordValue, ENUM_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn EnumType1.valueOf(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tenumNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.enumNoImport = enumNoImport_local;

				\t\tOptional<List<Color>> enumWithImport_local;
				\t\ttry {
				\t\t\tenumWithImport_local = findFieldValue(recordValue, ENUM_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn Color.valueOf(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tenumWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.enumWithImport = enumWithImport_local;

				\t\tOptional<List<Time>> unitsNoImport_local;
				\t\ttry {
				\t\t\tunitsNoImport_local = findFieldValue(recordValue, UNITS_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn Time.valueOf(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tunitsNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.unitsNoImport = unitsNoImport_local;

				\t\tOptional<List<Mass>> unitsWithImport_local;
				\t\ttry {
				\t\t\tunitsWithImport_local = findFieldValue(recordValue, UNITS_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn Mass.valueOf(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tunitsWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.unitsWithImport = unitsWithImport_local;

				\t\tOptional<List<IntegerWithUnits<IntegerOwnedUnits>>> numberWithUnitsNoImport_local;
				\t\ttry {
				\t\t\tnumberWithUnitsNoImport_local = findFieldValue(recordValue, NUMBER_WITH_UNITS_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new IntegerWithUnits<>(resolved1, IntegerOwnedUnits.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tnumberWithUnitsNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.numberWithUnitsNoImport = numberWithUnitsNoImport_local;

				\t\tOptional<List<RealWithUnits<Mass>>> numberWithUnitsWithImport_local;
				\t\ttry {
				\t\t\tnumberWithUnitsWithImport_local = findFieldValue(recordValue, NUMBER_WITH_UNITS_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new RealWithUnits<>(resolved1, Mass.class);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tnumberWithUnitsWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.numberWithUnitsWithImport = numberWithUnitsWithImport_local;

				\t\tOptional<List<IntegerRange>> rangeNoImport_local;
				\t\ttry {
				\t\t\trangeNoImport_local = findFieldValue(recordValue, RANGE_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new IntegerRange(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trangeNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.rangeNoImport = rangeNoImport_local;

				\t\tOptional<List<RealRange>> rangeWithImport_local;
				\t\ttry {
				\t\t\trangeWithImport_local = findFieldValue(recordValue, RANGE_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new RealRange(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trangeWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.rangeWithImport = rangeWithImport_local;

				\t\tOptional<List<RecordOfBoolean>> recordNoImport_local;
				\t\ttry {
				\t\t\trecordNoImport_local = findFieldValue(recordValue, RECORD_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new RecordOfBoolean(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trecordNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.recordNoImport = recordNoImport_local;

				\t\tOptional<List<BasicRecord>> recordWithImport_local;
				\t\ttry {
				\t\t\trecordWithImport_local = findFieldValue(recordValue, RECORD_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn new BasicRecord(resolved1);
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\trecordWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.recordWithImport = recordWithImport_local;
				\t}

				\tpublic Optional<List<EnumType1>> getEnumNoImport() {
				\t\treturn enumNoImport;
				\t}

				\tpublic Optional<List<Color>> getEnumWithImport() {
				\t\treturn enumWithImport;
				\t}

				\tpublic Optional<List<Time>> getUnitsNoImport() {
				\t\treturn unitsNoImport;
				\t}

				\tpublic Optional<List<Mass>> getUnitsWithImport() {
				\t\treturn unitsWithImport;
				\t}

				\tpublic Optional<List<IntegerWithUnits<IntegerOwnedUnits>>> getNumberWithUnitsNoImport() {
				\t\treturn numberWithUnitsNoImport;
				\t}

				\tpublic Optional<List<RealWithUnits<Mass>>> getNumberWithUnitsWithImport() {
				\t\treturn numberWithUnitsWithImport;
				\t}

				\tpublic Optional<List<IntegerRange>> getRangeNoImport() {
				\t\treturn rangeNoImport;
				\t}

				\tpublic Optional<List<RealRange>> getRangeWithImport() {
				\t\treturn rangeWithImport;
				\t}

				\tpublic Optional<List<RecordOfBoolean>> getRecordNoImport() {
				\t\treturn recordNoImport;
				\t}

				\tpublic Optional<List<BasicRecord>> getRecordWithImport() {
				\t\treturn recordWithImport;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (enumNoImport.isEmpty()
				\t\t\t\t&& enumWithImport.isEmpty()
				\t\t\t\t&& unitsNoImport.isEmpty()
				\t\t\t\t&& unitsWithImport.isEmpty()
				\t\t\t\t&& numberWithUnitsNoImport.isEmpty()
				\t\t\t\t&& numberWithUnitsWithImport.isEmpty()
				\t\t\t\t&& rangeNoImport.isEmpty()
				\t\t\t\t&& rangeWithImport.isEmpty()
				\t\t\t\t&& recordNoImport.isEmpty()
				\t\t\t\t&& recordWithImport.isEmpty()
				\t\t) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\tenumNoImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, ENUM_NO_IMPORT__URI, ENUM_NO_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\tenumWithImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, ENUM_WITH_IMPORT__URI, ENUM_WITH_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\tunitsNoImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, UNITS_NO_IMPORT__URI, UNITS_NO_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\tunitsWithImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, UNITS_WITH_IMPORT__URI, UNITS_WITH_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\tnumberWithUnitsNoImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, NUMBER_WITH_UNITS_NO_IMPORT__URI, NUMBER_WITH_UNITS_NO_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\tnumberWithUnitsWithImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, NUMBER_WITH_UNITS_WITH_IMPORT__URI, NUMBER_WITH_UNITS_WITH_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\trangeNoImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, RANGE_NO_IMPORT__URI, RANGE_NO_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression()));
				\t\t});
				\t\trangeWithImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, RANGE_WITH_IMPORT__URI, RANGE_WITH_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression()));
				\t\t});
				\t\trecordNoImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, RECORD_NO_IMPORT__URI, RECORD_NO_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\trecordWithImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, RECORD_WITH_IMPORT__URI, RECORD_WITH_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> element1.toPropertyExpression(resourceSet)));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(
				\t\t\t\tenumNoImport,
				\t\t\t\tenumWithImport,
				\t\t\t\tunitsNoImport,
				\t\t\t\tunitsWithImport,
				\t\t\t\tnumberWithUnitsNoImport,
				\t\t\t\tnumberWithUnitsWithImport,
				\t\t\t\trangeNoImport,
				\t\t\t\trangeWithImport,
				\t\t\t\trecordNoImport,
				\t\t\t\trecordWithImport
				\t\t);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordOfListOfReferencedTypes other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.enumNoImport, other.enumNoImport)
				\t\t\t\t&& Objects.equals(this.enumWithImport, other.enumWithImport)
				\t\t\t\t&& Objects.equals(this.unitsNoImport, other.unitsNoImport)
				\t\t\t\t&& Objects.equals(this.unitsWithImport, other.unitsWithImport)
				\t\t\t\t&& Objects.equals(this.numberWithUnitsNoImport, other.numberWithUnitsNoImport)
				\t\t\t\t&& Objects.equals(this.numberWithUnitsWithImport, other.numberWithUnitsWithImport)
				\t\t\t\t&& Objects.equals(this.rangeNoImport, other.rangeNoImport)
				\t\t\t\t&& Objects.equals(this.rangeWithImport, other.rangeWithImport)
				\t\t\t\t&& Objects.equals(this.recordNoImport, other.recordNoImport)
				\t\t\t\t&& Objects.equals(this.recordWithImport, other.recordWithImport);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.enumNoImport.ifPresent(field -> {
				\t\t\tbuilder.append(ENUM_NO_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.enumWithImport.ifPresent(field -> {
				\t\t\tbuilder.append(ENUM_WITH_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.unitsNoImport.ifPresent(field -> {
				\t\t\tbuilder.append(UNITS_NO_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.unitsWithImport.ifPresent(field -> {
				\t\t\tbuilder.append(UNITS_WITH_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.numberWithUnitsNoImport.ifPresent(field -> {
				\t\t\tbuilder.append(NUMBER_WITH_UNITS_NO_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.numberWithUnitsWithImport.ifPresent(field -> {
				\t\t\tbuilder.append(NUMBER_WITH_UNITS_WITH_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.rangeNoImport.ifPresent(field -> {
				\t\t\tbuilder.append(RANGE_NO_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.rangeWithImport.ifPresent(field -> {
				\t\t\tbuilder.append(RANGE_WITH_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.recordNoImport.ifPresent(field -> {
				\t\t\tbuilder.append(RECORD_NO_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.recordWithImport.ifPresent(field -> {
				\t\t\tbuilder.append(RECORD_WITH_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(ps1, ps2));
		assertEquals("src-gen/ps1", results.getPackagePath());
		assertEquals(13, results.getClasses().size());

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

		assertEquals("RecordOfListOfBoolean.java", results.getClasses().get(5).getFileName());
		assertEquals(recordOfListOfBoolean, results.getClasses().get(5).getContents());

		assertEquals("RecordOfListOfString.java", results.getClasses().get(6).getFileName());
		assertEquals(recordOfListOfString, results.getClasses().get(6).getContents());

		assertEquals("RecordOfListOfClassifier.java", results.getClasses().get(7).getFileName());
		assertEquals(recordOfListOfClassifier, results.getClasses().get(7).getContents());

		assertEquals("RecordOfListOfIntegerNoUnits.java", results.getClasses().get(8).getFileName());
		assertEquals(recordOfListOfIntegerNoUnits, results.getClasses().get(8).getContents());

		assertEquals("RecordOfListOfRealNoUnits.java", results.getClasses().get(9).getFileName());
		assertEquals(recordOfListOfRealNoUnits, results.getClasses().get(9).getContents());

		assertEquals("RecordOfListOfReference.java", results.getClasses().get(10).getFileName());
		assertEquals(recordOfListOfReference, results.getClasses().get(10).getContents());

		assertEquals("RecordOfListOfOwnedTypes.java", results.getClasses().get(11).getFileName());
		assertEquals(recordOfListOfOwnedTypes, results.getClasses().get(11).getContents());

		assertEquals("RecordOfListOfReferencedTypes.java", results.getClasses().get(12).getFileName());
		assertEquals(recordOfListOfReferencedTypes, results.getClasses().get(12).getContents());
	}
}
