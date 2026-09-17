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

/** Verifies exact generated Java for record type. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class RecordTypeTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testRecordType() throws Exception {
		var ps2 = """
				property set ps2 is
				\tmass: type units (g, kg => g * 1000);
				\tmass_type: type aadlreal units ps2::mass;
				\tcolor: type enumeration (red, green, blue);
				\tbasic_integer: type aadlinteger;
				\tbasic_real: type aadlreal;
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
				\tinteger_referenced_units_other_file: type aadlinteger units ps2::mass;
				\tboolean_type_1: type aadlboolean;
				\tstring_type_1: type aadlstring;
				\tclassifier_type_1: type classifier;
				\tenum_type_1: type enumeration (one, two, three);
				\treference_type_1: type reference;
				\trange_of_integer_no_units: type range of aadlinteger;
				\t
				\trecord_type_1: type record (
				\t\towned_boolean: aadlboolean;
				\t\towned_string: aadlstring;
				\t\towned_classifier: classifier;
				\t\towned_enumeration: enumeration (allegheny, monongahela, ohio);
				\t\towned_units: units (inch, foot => inch * 12, yard => foot * 3);
				\t\towned_integer_no_units: aadlinteger;
				\t\towned_real_no_units: aadlreal;
				\t\towned_number_with_units_no_import: aadlinteger units ps1::time;
				\t\towned_number_with_units_with_import: aadlinteger units ps2::mass;
				\t\towned_range_no_import: range of ps1::integer_referenced_units_other_file;
				\t\towned_range_import_number: range of ps2::mass_type;
				\t\towned_range_import_units: range of aadlinteger units ps2::mass;
				\t\towned_record: record (
				\t\t\tstring_field: aadlstring;
				\t\t\tinteger_field: aadlinteger;
				\t\t);
				\t\towned_reference: reference;
				\t\treferenced_boolean: ps1::boolean_type_1;
				\t\treferenced_string: ps1::string_type_1;
				\t\treferenced_classifier: ps1::classifier_type_1;
				\t\treferenced_enumeration_no_import: ps1::enum_type_1;
				\t\treferenced_enumeration_with_import: ps2::color;
				\t\treferenced_units_no_import: ps1::time;
				\t\treferenced_units_with_import: ps2::mass;
				\t\treferenced_integer_no_units: ps2::basic_integer;
				\t\treferenced_real_no_units: ps2::basic_real;
				\t\treferenced_number_with_units_no_import: ps1::integer_owned_units;
				\t\treferenced_number_with_units_with_import: ps2::mass_type;
				\t\treferenced_range_no_import: ps1::range_of_integer_no_units;
				\t\treferenced_range_with_import: ps2::basic_range;
				\t\treferenced_record_no_import: ps1::record_of_boolean;
				\t\treferenced_record_with_import: ps2::basic_record;
				\t\treferenced_reference: ps1::reference_type_1;
				\t);
				\trecord_of_boolean: type record (field: aadlboolean;);
				\trecord_of_string: type record (field: aadlstring;);
				\trecord_of_classifier: type record (field: classifier;);
				\trecord_of_enum: type record (field: enumeration (a, b, c););
				\trecord_of_units: type record (field: units (mm, cm => mm * 10););
				\trecord_of_integer: type record (field: aadlinteger;);
				\trecord_of_real: type record (field: aadlreal;);
				\trecord_of_reference: type record (field: reference;);
				\tnested_record: type record(field1: record (field2: record (field3: record (inner_field: aadlinteger;););););
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
				\tONE("one", "__synthetic1.aadl#/0/@ownedPropertyType.6/@ownedLiteral.0"),
				\tTWO("two", "__synthetic1.aadl#/0/@ownedPropertyType.6/@ownedLiteral.1"),
				\tTHREE("three", "__synthetic1.aadl#/0/@ownedPropertyType.6/@ownedLiteral.2");

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
		var recordType1 = """
				package ps1;

				import java.util.Objects;
				import java.util.Optional;
				import java.util.OptionalDouble;
				import java.util.OptionalLong;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.BooleanLiteral;
				import org.osate.aadl2.Classifier;
				import org.osate.aadl2.ClassifierValue;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.IntegerLiteral;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RealLiteral;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.StringLiteral;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.aadl2.instance.InstanceObject;
				import org.osate.aadl2.instance.InstanceReferenceValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedEnumeration;
				import org.osate.pluginsupport.properties.GeneratedRecord;
				import org.osate.pluginsupport.properties.GeneratedUnits;
				import org.osate.pluginsupport.properties.IntegerRange;
				import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
				import org.osate.pluginsupport.properties.IntegerWithUnits;
				import org.osate.pluginsupport.properties.RealRange;
				import org.osate.pluginsupport.properties.RealRangeWithUnits;
				import org.osate.pluginsupport.properties.RealWithUnits;

				import ps2.BasicRecord;
				import ps2.Color;
				import ps2.Mass;

				public class RecordType1 extends GeneratedRecord {
				\tpublic static final String OWNED_BOOLEAN__NAME = "owned_boolean";
				\tpublic static final String OWNED_STRING__NAME = "owned_string";
				\tpublic static final String OWNED_CLASSIFIER__NAME = "owned_classifier";
				\tpublic static final String OWNED_ENUMERATION__NAME = "owned_enumeration";
				\tpublic static final String OWNED_UNITS__NAME = "owned_units";
				\tpublic static final String OWNED_INTEGER_NO_UNITS__NAME = "owned_integer_no_units";
				\tpublic static final String OWNED_REAL_NO_UNITS__NAME = "owned_real_no_units";
				\tpublic static final String OWNED_NUMBER_WITH_UNITS_NO_IMPORT__NAME = "owned_number_with_units_no_import";
				\tpublic static final String OWNED_NUMBER_WITH_UNITS_WITH_IMPORT__NAME = "owned_number_with_units_with_import";
				\tpublic static final String OWNED_RANGE_NO_IMPORT__NAME = "owned_range_no_import";
				\tpublic static final String OWNED_RANGE_IMPORT_NUMBER__NAME = "owned_range_import_number";
				\tpublic static final String OWNED_RANGE_IMPORT_UNITS__NAME = "owned_range_import_units";
				\tpublic static final String OWNED_RECORD__NAME = "owned_record";
				\tpublic static final String OWNED_REFERENCE__NAME = "owned_reference";
				\tpublic static final String REFERENCED_BOOLEAN__NAME = "referenced_boolean";
				\tpublic static final String REFERENCED_STRING__NAME = "referenced_string";
				\tpublic static final String REFERENCED_CLASSIFIER__NAME = "referenced_classifier";
				\tpublic static final String REFERENCED_ENUMERATION_NO_IMPORT__NAME = "referenced_enumeration_no_import";
				\tpublic static final String REFERENCED_ENUMERATION_WITH_IMPORT__NAME = "referenced_enumeration_with_import";
				\tpublic static final String REFERENCED_UNITS_NO_IMPORT__NAME = "referenced_units_no_import";
				\tpublic static final String REFERENCED_UNITS_WITH_IMPORT__NAME = "referenced_units_with_import";
				\tpublic static final String REFERENCED_INTEGER_NO_UNITS__NAME = "referenced_integer_no_units";
				\tpublic static final String REFERENCED_REAL_NO_UNITS__NAME = "referenced_real_no_units";
				\tpublic static final String REFERENCED_NUMBER_WITH_UNITS_NO_IMPORT__NAME = "referenced_number_with_units_no_import";
				\tpublic static final String REFERENCED_NUMBER_WITH_UNITS_WITH_IMPORT__NAME = "referenced_number_with_units_with_import";
				\tpublic static final String REFERENCED_RANGE_NO_IMPORT__NAME = "referenced_range_no_import";
				\tpublic static final String REFERENCED_RANGE_WITH_IMPORT__NAME = "referenced_range_with_import";
				\tpublic static final String REFERENCED_RECORD_NO_IMPORT__NAME = "referenced_record_no_import";
				\tpublic static final String REFERENCED_RECORD_WITH_IMPORT__NAME = "referenced_record_with_import";
				\tpublic static final String REFERENCED_REFERENCE__NAME = "referenced_reference";
				\tpublic static final URI OWNED_BOOLEAN__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.0");
				\tpublic static final URI OWNED_STRING__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.1");
				\tpublic static final URI OWNED_CLASSIFIER__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.2");
				\tpublic static final URI OWNED_ENUMERATION__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.3");
				\tpublic static final URI OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.4");
				\tpublic static final URI OWNED_INTEGER_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.5");
				\tpublic static final URI OWNED_REAL_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.6");
				\tpublic static final URI OWNED_NUMBER_WITH_UNITS_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.7");
				\tpublic static final URI OWNED_NUMBER_WITH_UNITS_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.8");
				\tpublic static final URI OWNED_RANGE_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.9");
				\tpublic static final URI OWNED_RANGE_IMPORT_NUMBER__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.10");
				\tpublic static final URI OWNED_RANGE_IMPORT_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.11");
				\tpublic static final URI OWNED_RECORD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.12");
				\tpublic static final URI OWNED_REFERENCE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.13");
				\tpublic static final URI REFERENCED_BOOLEAN__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.14");
				\tpublic static final URI REFERENCED_STRING__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.15");
				\tpublic static final URI REFERENCED_CLASSIFIER__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.16");
				\tpublic static final URI REFERENCED_ENUMERATION_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.17");
				\tpublic static final URI REFERENCED_ENUMERATION_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.18");
				\tpublic static final URI REFERENCED_UNITS_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.19");
				\tpublic static final URI REFERENCED_UNITS_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.20");
				\tpublic static final URI REFERENCED_INTEGER_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.21");
				\tpublic static final URI REFERENCED_REAL_NO_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.22");
				\tpublic static final URI REFERENCED_NUMBER_WITH_UNITS_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.23");
				\tpublic static final URI REFERENCED_NUMBER_WITH_UNITS_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.24");
				\tpublic static final URI REFERENCED_RANGE_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.25");
				\tpublic static final URI REFERENCED_RANGE_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.26");
				\tpublic static final URI REFERENCED_RECORD_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.27");
				\tpublic static final URI REFERENCED_RECORD_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.28");
				\tpublic static final URI REFERENCED_REFERENCE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.29");

				\tprivate final Optional<Boolean> ownedBoolean;
				\tprivate final Optional<String> ownedString;
				\tprivate final Optional<Classifier> ownedClassifier;
				\tprivate final Optional<OwnedEnumeration_FieldType> ownedEnumeration;
				\tprivate final Optional<OwnedUnits_FieldType> ownedUnits;
				\tprivate final OptionalLong ownedIntegerNoUnits;
				\tprivate final OptionalDouble ownedRealNoUnits;
				\tprivate final Optional<IntegerWithUnits<Time>> ownedNumberWithUnitsNoImport;
				\tprivate final Optional<IntegerWithUnits<Mass>> ownedNumberWithUnitsWithImport;
				\tprivate final Optional<IntegerRangeWithUnits<Mass>> ownedRangeNoImport;
				\tprivate final Optional<RealRangeWithUnits<Mass>> ownedRangeImportNumber;
				\tprivate final Optional<IntegerRangeWithUnits<Mass>> ownedRangeImportUnits;
				\tprivate final Optional<OwnedRecord_FieldType> ownedRecord;
				\tprivate final Optional<InstanceObject> ownedReference;
				\tprivate final Optional<Boolean> referencedBoolean;
				\tprivate final Optional<String> referencedString;
				\tprivate final Optional<Classifier> referencedClassifier;
				\tprivate final Optional<EnumType1> referencedEnumerationNoImport;
				\tprivate final Optional<Color> referencedEnumerationWithImport;
				\tprivate final Optional<Time> referencedUnitsNoImport;
				\tprivate final Optional<Mass> referencedUnitsWithImport;
				\tprivate final OptionalLong referencedIntegerNoUnits;
				\tprivate final OptionalDouble referencedRealNoUnits;
				\tprivate final Optional<IntegerWithUnits<IntegerOwnedUnits>> referencedNumberWithUnitsNoImport;
				\tprivate final Optional<RealWithUnits<Mass>> referencedNumberWithUnitsWithImport;
				\tprivate final Optional<IntegerRange> referencedRangeNoImport;
				\tprivate final Optional<RealRange> referencedRangeWithImport;
				\tprivate final Optional<RecordOfBoolean> referencedRecordNoImport;
				\tprivate final Optional<BasicRecord> referencedRecordWithImport;
				\tprivate final Optional<InstanceObject> referencedReference;

				\tpublic RecordType1(
				\t\t\tOptional<Boolean> ownedBoolean,
				\t\t\tOptional<String> ownedString,
				\t\t\tOptional<Classifier> ownedClassifier,
				\t\t\tOptional<OwnedEnumeration_FieldType> ownedEnumeration,
				\t\t\tOptional<OwnedUnits_FieldType> ownedUnits,
				\t\t\tOptionalLong ownedIntegerNoUnits,
				\t\t\tOptionalDouble ownedRealNoUnits,
				\t\t\tOptional<IntegerWithUnits<Time>> ownedNumberWithUnitsNoImport,
				\t\t\tOptional<IntegerWithUnits<Mass>> ownedNumberWithUnitsWithImport,
				\t\t\tOptional<IntegerRangeWithUnits<Mass>> ownedRangeNoImport,
				\t\t\tOptional<RealRangeWithUnits<Mass>> ownedRangeImportNumber,
				\t\t\tOptional<IntegerRangeWithUnits<Mass>> ownedRangeImportUnits,
				\t\t\tOptional<OwnedRecord_FieldType> ownedRecord,
				\t\t\tOptional<InstanceObject> ownedReference,
				\t\t\tOptional<Boolean> referencedBoolean,
				\t\t\tOptional<String> referencedString,
				\t\t\tOptional<Classifier> referencedClassifier,
				\t\t\tOptional<EnumType1> referencedEnumerationNoImport,
				\t\t\tOptional<Color> referencedEnumerationWithImport,
				\t\t\tOptional<Time> referencedUnitsNoImport,
				\t\t\tOptional<Mass> referencedUnitsWithImport,
				\t\t\tOptionalLong referencedIntegerNoUnits,
				\t\t\tOptionalDouble referencedRealNoUnits,
				\t\t\tOptional<IntegerWithUnits<IntegerOwnedUnits>> referencedNumberWithUnitsNoImport,
				\t\t\tOptional<RealWithUnits<Mass>> referencedNumberWithUnitsWithImport,
				\t\t\tOptional<IntegerRange> referencedRangeNoImport,
				\t\t\tOptional<RealRange> referencedRangeWithImport,
				\t\t\tOptional<RecordOfBoolean> referencedRecordNoImport,
				\t\t\tOptional<BasicRecord> referencedRecordWithImport,
				\t\t\tOptional<InstanceObject> referencedReference
				\t) {
				\t\tthis.ownedBoolean = ownedBoolean;
				\t\tthis.ownedString = ownedString;
				\t\tthis.ownedClassifier = ownedClassifier;
				\t\tthis.ownedEnumeration = ownedEnumeration;
				\t\tthis.ownedUnits = ownedUnits;
				\t\tthis.ownedIntegerNoUnits = ownedIntegerNoUnits;
				\t\tthis.ownedRealNoUnits = ownedRealNoUnits;
				\t\tthis.ownedNumberWithUnitsNoImport = ownedNumberWithUnitsNoImport;
				\t\tthis.ownedNumberWithUnitsWithImport = ownedNumberWithUnitsWithImport;
				\t\tthis.ownedRangeNoImport = ownedRangeNoImport;
				\t\tthis.ownedRangeImportNumber = ownedRangeImportNumber;
				\t\tthis.ownedRangeImportUnits = ownedRangeImportUnits;
				\t\tthis.ownedRecord = ownedRecord;
				\t\tthis.ownedReference = ownedReference;
				\t\tthis.referencedBoolean = referencedBoolean;
				\t\tthis.referencedString = referencedString;
				\t\tthis.referencedClassifier = referencedClassifier;
				\t\tthis.referencedEnumerationNoImport = referencedEnumerationNoImport;
				\t\tthis.referencedEnumerationWithImport = referencedEnumerationWithImport;
				\t\tthis.referencedUnitsNoImport = referencedUnitsNoImport;
				\t\tthis.referencedUnitsWithImport = referencedUnitsWithImport;
				\t\tthis.referencedIntegerNoUnits = referencedIntegerNoUnits;
				\t\tthis.referencedRealNoUnits = referencedRealNoUnits;
				\t\tthis.referencedNumberWithUnitsNoImport = referencedNumberWithUnitsNoImport;
				\t\tthis.referencedNumberWithUnitsWithImport = referencedNumberWithUnitsWithImport;
				\t\tthis.referencedRangeNoImport = referencedRangeNoImport;
				\t\tthis.referencedRangeWithImport = referencedRangeWithImport;
				\t\tthis.referencedRecordNoImport = referencedRecordNoImport;
				\t\tthis.referencedRecordWithImport = referencedRecordWithImport;
				\t\tthis.referencedReference = referencedReference;
				\t}

				\tpublic RecordType1(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Boolean> ownedBoolean_local;
				\t\ttry {
				\t\t\townedBoolean_local = findFieldValue(recordValue, OWNED_BOOLEAN__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedBoolean_local = Optional.empty();
				\t\t}
				\t\tthis.ownedBoolean = ownedBoolean_local;

				\t\tOptional<String> ownedString_local;
				\t\ttry {
				\t\t\townedString_local = findFieldValue(recordValue, OWNED_STRING__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedString_local = Optional.empty();
				\t\t}
				\t\tthis.ownedString = ownedString_local;

				\t\tOptional<Classifier> ownedClassifier_local;
				\t\ttry {
				\t\t\townedClassifier_local = findFieldValue(recordValue, OWNED_CLASSIFIER__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ClassifierValue) resolved).getClassifier();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedClassifier_local = Optional.empty();
				\t\t}
				\t\tthis.ownedClassifier = ownedClassifier_local;

				\t\tOptional<OwnedEnumeration_FieldType> ownedEnumeration_local;
				\t\ttry {
				\t\t\townedEnumeration_local = findFieldValue(recordValue, OWNED_ENUMERATION__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn OwnedEnumeration_FieldType.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedEnumeration_local = Optional.empty();
				\t\t}
				\t\tthis.ownedEnumeration = ownedEnumeration_local;

				\t\tOptional<OwnedUnits_FieldType> ownedUnits_local;
				\t\ttry {
				\t\t\townedUnits_local = findFieldValue(recordValue, OWNED_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn OwnedUnits_FieldType.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedUnits_local = Optional.empty();
				\t\t}
				\t\tthis.ownedUnits = ownedUnits_local;

				\t\tOptionalLong ownedIntegerNoUnits_local;
				\t\ttry {
				\t\t\townedIntegerNoUnits_local = findFieldValue(recordValue, OWNED_INTEGER_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedIntegerNoUnits_local = OptionalLong.empty();
				\t\t}
				\t\tthis.ownedIntegerNoUnits = ownedIntegerNoUnits_local;

				\t\tOptionalDouble ownedRealNoUnits_local;
				\t\ttry {
				\t\t\townedRealNoUnits_local = findFieldValue(recordValue, OWNED_REAL_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((RealLiteral) resolved).getValue();
				\t\t\t}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRealNoUnits_local = OptionalDouble.empty();
				\t\t}
				\t\tthis.ownedRealNoUnits = ownedRealNoUnits_local;

				\t\tOptional<IntegerWithUnits<Time>> ownedNumberWithUnitsNoImport_local;
				\t\ttry {
				\t\t\townedNumberWithUnitsNoImport_local = findFieldValue(recordValue, OWNED_NUMBER_WITH_UNITS_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new IntegerWithUnits<>(resolved, Time.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedNumberWithUnitsNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.ownedNumberWithUnitsNoImport = ownedNumberWithUnitsNoImport_local;

				\t\tOptional<IntegerWithUnits<Mass>> ownedNumberWithUnitsWithImport_local;
				\t\ttry {
				\t\t\townedNumberWithUnitsWithImport_local = findFieldValue(recordValue, OWNED_NUMBER_WITH_UNITS_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new IntegerWithUnits<>(resolved, Mass.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedNumberWithUnitsWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.ownedNumberWithUnitsWithImport = ownedNumberWithUnitsWithImport_local;

				\t\tOptional<IntegerRangeWithUnits<Mass>> ownedRangeNoImport_local;
				\t\ttry {
				\t\t\townedRangeNoImport_local = findFieldValue(recordValue, OWNED_RANGE_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new IntegerRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRangeNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.ownedRangeNoImport = ownedRangeNoImport_local;

				\t\tOptional<RealRangeWithUnits<Mass>> ownedRangeImportNumber_local;
				\t\ttry {
				\t\t\townedRangeImportNumber_local = findFieldValue(recordValue, OWNED_RANGE_IMPORT_NUMBER__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new RealRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRangeImportNumber_local = Optional.empty();
				\t\t}
				\t\tthis.ownedRangeImportNumber = ownedRangeImportNumber_local;

				\t\tOptional<IntegerRangeWithUnits<Mass>> ownedRangeImportUnits_local;
				\t\ttry {
				\t\t\townedRangeImportUnits_local = findFieldValue(recordValue, OWNED_RANGE_IMPORT_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new IntegerRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRangeImportUnits_local = Optional.empty();
				\t\t}
				\t\tthis.ownedRangeImportUnits = ownedRangeImportUnits_local;

				\t\tOptional<OwnedRecord_FieldType> ownedRecord_local;
				\t\ttry {
				\t\t\townedRecord_local = findFieldValue(recordValue, OWNED_RECORD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new OwnedRecord_FieldType(resolved, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRecord_local = Optional.empty();
				\t\t}
				\t\tthis.ownedRecord = ownedRecord_local;

				\t\tOptional<InstanceObject> ownedReference_local;
				\t\ttry {
				\t\t\townedReference_local = findFieldValue(recordValue, OWNED_REFERENCE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedReference_local = Optional.empty();
				\t\t}
				\t\tthis.ownedReference = ownedReference_local;

				\t\tOptional<Boolean> referencedBoolean_local;
				\t\ttry {
				\t\t\treferencedBoolean_local = findFieldValue(recordValue, REFERENCED_BOOLEAN__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedBoolean_local = Optional.empty();
				\t\t}
				\t\tthis.referencedBoolean = referencedBoolean_local;

				\t\tOptional<String> referencedString_local;
				\t\ttry {
				\t\t\treferencedString_local = findFieldValue(recordValue, REFERENCED_STRING__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedString_local = Optional.empty();
				\t\t}
				\t\tthis.referencedString = referencedString_local;

				\t\tOptional<Classifier> referencedClassifier_local;
				\t\ttry {
				\t\t\treferencedClassifier_local = findFieldValue(recordValue, REFERENCED_CLASSIFIER__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ClassifierValue) resolved).getClassifier();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedClassifier_local = Optional.empty();
				\t\t}
				\t\tthis.referencedClassifier = referencedClassifier_local;

				\t\tOptional<EnumType1> referencedEnumerationNoImport_local;
				\t\ttry {
				\t\t\treferencedEnumerationNoImport_local = findFieldValue(recordValue, REFERENCED_ENUMERATION_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn EnumType1.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedEnumerationNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedEnumerationNoImport = referencedEnumerationNoImport_local;

				\t\tOptional<Color> referencedEnumerationWithImport_local;
				\t\ttry {
				\t\t\treferencedEnumerationWithImport_local = findFieldValue(recordValue, REFERENCED_ENUMERATION_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn Color.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedEnumerationWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedEnumerationWithImport = referencedEnumerationWithImport_local;

				\t\tOptional<Time> referencedUnitsNoImport_local;
				\t\ttry {
				\t\t\treferencedUnitsNoImport_local = findFieldValue(recordValue, REFERENCED_UNITS_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn Time.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedUnitsNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedUnitsNoImport = referencedUnitsNoImport_local;

				\t\tOptional<Mass> referencedUnitsWithImport_local;
				\t\ttry {
				\t\t\treferencedUnitsWithImport_local = findFieldValue(recordValue, REFERENCED_UNITS_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn Mass.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedUnitsWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedUnitsWithImport = referencedUnitsWithImport_local;

				\t\tOptionalLong referencedIntegerNoUnits_local;
				\t\ttry {
				\t\t\treferencedIntegerNoUnits_local = findFieldValue(recordValue, REFERENCED_INTEGER_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedIntegerNoUnits_local = OptionalLong.empty();
				\t\t}
				\t\tthis.referencedIntegerNoUnits = referencedIntegerNoUnits_local;

				\t\tOptionalDouble referencedRealNoUnits_local;
				\t\ttry {
				\t\t\treferencedRealNoUnits_local = findFieldValue(recordValue, REFERENCED_REAL_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((RealLiteral) resolved).getValue();
				\t\t\t}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedRealNoUnits_local = OptionalDouble.empty();
				\t\t}
				\t\tthis.referencedRealNoUnits = referencedRealNoUnits_local;

				\t\tOptional<IntegerWithUnits<IntegerOwnedUnits>> referencedNumberWithUnitsNoImport_local;
				\t\ttry {
				\t\t\treferencedNumberWithUnitsNoImport_local = findFieldValue(recordValue, REFERENCED_NUMBER_WITH_UNITS_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new IntegerWithUnits<>(resolved, IntegerOwnedUnits.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedNumberWithUnitsNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedNumberWithUnitsNoImport = referencedNumberWithUnitsNoImport_local;

				\t\tOptional<RealWithUnits<Mass>> referencedNumberWithUnitsWithImport_local;
				\t\ttry {
				\t\t\treferencedNumberWithUnitsWithImport_local = findFieldValue(recordValue, REFERENCED_NUMBER_WITH_UNITS_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new RealWithUnits<>(resolved, Mass.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedNumberWithUnitsWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedNumberWithUnitsWithImport = referencedNumberWithUnitsWithImport_local;

				\t\tOptional<IntegerRange> referencedRangeNoImport_local;
				\t\ttry {
				\t\t\treferencedRangeNoImport_local = findFieldValue(recordValue, REFERENCED_RANGE_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new IntegerRange(resolved, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedRangeNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedRangeNoImport = referencedRangeNoImport_local;

				\t\tOptional<RealRange> referencedRangeWithImport_local;
				\t\ttry {
				\t\t\treferencedRangeWithImport_local = findFieldValue(recordValue, REFERENCED_RANGE_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new RealRange(resolved, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedRangeWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedRangeWithImport = referencedRangeWithImport_local;

				\t\tOptional<RecordOfBoolean> referencedRecordNoImport_local;
				\t\ttry {
				\t\t\treferencedRecordNoImport_local = findFieldValue(recordValue, REFERENCED_RECORD_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new RecordOfBoolean(resolved, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedRecordNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedRecordNoImport = referencedRecordNoImport_local;

				\t\tOptional<BasicRecord> referencedRecordWithImport_local;
				\t\ttry {
				\t\t\treferencedRecordWithImport_local = findFieldValue(recordValue, REFERENCED_RECORD_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new BasicRecord(resolved, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedRecordWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedRecordWithImport = referencedRecordWithImport_local;

				\t\tOptional<InstanceObject> referencedReference_local;
				\t\ttry {
				\t\t\treferencedReference_local = findFieldValue(recordValue, REFERENCED_REFERENCE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedReference_local = Optional.empty();
				\t\t}
				\t\tthis.referencedReference = referencedReference_local;
				\t}

				\tpublic RecordType1(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Boolean> ownedBoolean_local;
				\t\ttry {
				\t\t\townedBoolean_local = findFieldValue(recordValue, OWNED_BOOLEAN__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedBoolean_local = Optional.empty();
				\t\t}
				\t\tthis.ownedBoolean = ownedBoolean_local;

				\t\tOptional<String> ownedString_local;
				\t\ttry {
				\t\t\townedString_local = findFieldValue(recordValue, OWNED_STRING__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedString_local = Optional.empty();
				\t\t}
				\t\tthis.ownedString = ownedString_local;

				\t\tOptional<Classifier> ownedClassifier_local;
				\t\ttry {
				\t\t\townedClassifier_local = findFieldValue(recordValue, OWNED_CLASSIFIER__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ClassifierValue) resolved).getClassifier();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedClassifier_local = Optional.empty();
				\t\t}
				\t\tthis.ownedClassifier = ownedClassifier_local;

				\t\tOptional<OwnedEnumeration_FieldType> ownedEnumeration_local;
				\t\ttry {
				\t\t\townedEnumeration_local = findFieldValue(recordValue, OWNED_ENUMERATION__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn OwnedEnumeration_FieldType.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedEnumeration_local = Optional.empty();
				\t\t}
				\t\tthis.ownedEnumeration = ownedEnumeration_local;

				\t\tOptional<OwnedUnits_FieldType> ownedUnits_local;
				\t\ttry {
				\t\t\townedUnits_local = findFieldValue(recordValue, OWNED_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn OwnedUnits_FieldType.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedUnits_local = Optional.empty();
				\t\t}
				\t\tthis.ownedUnits = ownedUnits_local;

				\t\tOptionalLong ownedIntegerNoUnits_local;
				\t\ttry {
				\t\t\townedIntegerNoUnits_local = findFieldValue(recordValue, OWNED_INTEGER_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedIntegerNoUnits_local = OptionalLong.empty();
				\t\t}
				\t\tthis.ownedIntegerNoUnits = ownedIntegerNoUnits_local;

				\t\tOptionalDouble ownedRealNoUnits_local;
				\t\ttry {
				\t\t\townedRealNoUnits_local = findFieldValue(recordValue, OWNED_REAL_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((RealLiteral) resolved).getValue();
				\t\t\t}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRealNoUnits_local = OptionalDouble.empty();
				\t\t}
				\t\tthis.ownedRealNoUnits = ownedRealNoUnits_local;

				\t\tOptional<IntegerWithUnits<Time>> ownedNumberWithUnitsNoImport_local;
				\t\ttry {
				\t\t\townedNumberWithUnitsNoImport_local = findFieldValue(recordValue, OWNED_NUMBER_WITH_UNITS_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new IntegerWithUnits<>(resolved, Time.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedNumberWithUnitsNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.ownedNumberWithUnitsNoImport = ownedNumberWithUnitsNoImport_local;

				\t\tOptional<IntegerWithUnits<Mass>> ownedNumberWithUnitsWithImport_local;
				\t\ttry {
				\t\t\townedNumberWithUnitsWithImport_local = findFieldValue(recordValue, OWNED_NUMBER_WITH_UNITS_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new IntegerWithUnits<>(resolved, Mass.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedNumberWithUnitsWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.ownedNumberWithUnitsWithImport = ownedNumberWithUnitsWithImport_local;

				\t\tOptional<IntegerRangeWithUnits<Mass>> ownedRangeNoImport_local;
				\t\ttry {
				\t\t\townedRangeNoImport_local = findFieldValue(recordValue, OWNED_RANGE_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new IntegerRangeWithUnits<>(resolved, Mass.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRangeNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.ownedRangeNoImport = ownedRangeNoImport_local;

				\t\tOptional<RealRangeWithUnits<Mass>> ownedRangeImportNumber_local;
				\t\ttry {
				\t\t\townedRangeImportNumber_local = findFieldValue(recordValue, OWNED_RANGE_IMPORT_NUMBER__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new RealRangeWithUnits<>(resolved, Mass.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRangeImportNumber_local = Optional.empty();
				\t\t}
				\t\tthis.ownedRangeImportNumber = ownedRangeImportNumber_local;

				\t\tOptional<IntegerRangeWithUnits<Mass>> ownedRangeImportUnits_local;
				\t\ttry {
				\t\t\townedRangeImportUnits_local = findFieldValue(recordValue, OWNED_RANGE_IMPORT_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new IntegerRangeWithUnits<>(resolved, Mass.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRangeImportUnits_local = Optional.empty();
				\t\t}
				\t\tthis.ownedRangeImportUnits = ownedRangeImportUnits_local;

				\t\tOptional<OwnedRecord_FieldType> ownedRecord_local;
				\t\ttry {
				\t\t\townedRecord_local = findFieldValue(recordValue, OWNED_RECORD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new OwnedRecord_FieldType(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedRecord_local = Optional.empty();
				\t\t}
				\t\tthis.ownedRecord = ownedRecord_local;

				\t\tOptional<InstanceObject> ownedReference_local;
				\t\ttry {
				\t\t\townedReference_local = findFieldValue(recordValue, OWNED_REFERENCE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\townedReference_local = Optional.empty();
				\t\t}
				\t\tthis.ownedReference = ownedReference_local;

				\t\tOptional<Boolean> referencedBoolean_local;
				\t\ttry {
				\t\t\treferencedBoolean_local = findFieldValue(recordValue, REFERENCED_BOOLEAN__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedBoolean_local = Optional.empty();
				\t\t}
				\t\tthis.referencedBoolean = referencedBoolean_local;

				\t\tOptional<String> referencedString_local;
				\t\ttry {
				\t\t\treferencedString_local = findFieldValue(recordValue, REFERENCED_STRING__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedString_local = Optional.empty();
				\t\t}
				\t\tthis.referencedString = referencedString_local;

				\t\tOptional<Classifier> referencedClassifier_local;
				\t\ttry {
				\t\t\treferencedClassifier_local = findFieldValue(recordValue, REFERENCED_CLASSIFIER__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ClassifierValue) resolved).getClassifier();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedClassifier_local = Optional.empty();
				\t\t}
				\t\tthis.referencedClassifier = referencedClassifier_local;

				\t\tOptional<EnumType1> referencedEnumerationNoImport_local;
				\t\ttry {
				\t\t\treferencedEnumerationNoImport_local = findFieldValue(recordValue, REFERENCED_ENUMERATION_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn EnumType1.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedEnumerationNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedEnumerationNoImport = referencedEnumerationNoImport_local;

				\t\tOptional<Color> referencedEnumerationWithImport_local;
				\t\ttry {
				\t\t\treferencedEnumerationWithImport_local = findFieldValue(recordValue, REFERENCED_ENUMERATION_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn Color.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedEnumerationWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedEnumerationWithImport = referencedEnumerationWithImport_local;

				\t\tOptional<Time> referencedUnitsNoImport_local;
				\t\ttry {
				\t\t\treferencedUnitsNoImport_local = findFieldValue(recordValue, REFERENCED_UNITS_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn Time.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedUnitsNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedUnitsNoImport = referencedUnitsNoImport_local;

				\t\tOptional<Mass> referencedUnitsWithImport_local;
				\t\ttry {
				\t\t\treferencedUnitsWithImport_local = findFieldValue(recordValue, REFERENCED_UNITS_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn Mass.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedUnitsWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedUnitsWithImport = referencedUnitsWithImport_local;

				\t\tOptionalLong referencedIntegerNoUnits_local;
				\t\ttry {
				\t\t\treferencedIntegerNoUnits_local = findFieldValue(recordValue, REFERENCED_INTEGER_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedIntegerNoUnits_local = OptionalLong.empty();
				\t\t}
				\t\tthis.referencedIntegerNoUnits = referencedIntegerNoUnits_local;

				\t\tOptionalDouble referencedRealNoUnits_local;
				\t\ttry {
				\t\t\treferencedRealNoUnits_local = findFieldValue(recordValue, REFERENCED_REAL_NO_UNITS__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((RealLiteral) resolved).getValue();
				\t\t\t}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedRealNoUnits_local = OptionalDouble.empty();
				\t\t}
				\t\tthis.referencedRealNoUnits = referencedRealNoUnits_local;

				\t\tOptional<IntegerWithUnits<IntegerOwnedUnits>> referencedNumberWithUnitsNoImport_local;
				\t\ttry {
				\t\t\treferencedNumberWithUnitsNoImport_local = findFieldValue(recordValue, REFERENCED_NUMBER_WITH_UNITS_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new IntegerWithUnits<>(resolved, IntegerOwnedUnits.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedNumberWithUnitsNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedNumberWithUnitsNoImport = referencedNumberWithUnitsNoImport_local;

				\t\tOptional<RealWithUnits<Mass>> referencedNumberWithUnitsWithImport_local;
				\t\ttry {
				\t\t\treferencedNumberWithUnitsWithImport_local = findFieldValue(recordValue, REFERENCED_NUMBER_WITH_UNITS_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new RealWithUnits<>(resolved, Mass.class);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedNumberWithUnitsWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedNumberWithUnitsWithImport = referencedNumberWithUnitsWithImport_local;

				\t\tOptional<IntegerRange> referencedRangeNoImport_local;
				\t\ttry {
				\t\t\treferencedRangeNoImport_local = findFieldValue(recordValue, REFERENCED_RANGE_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new IntegerRange(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedRangeNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedRangeNoImport = referencedRangeNoImport_local;

				\t\tOptional<RealRange> referencedRangeWithImport_local;
				\t\ttry {
				\t\t\treferencedRangeWithImport_local = findFieldValue(recordValue, REFERENCED_RANGE_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new RealRange(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedRangeWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedRangeWithImport = referencedRangeWithImport_local;

				\t\tOptional<RecordOfBoolean> referencedRecordNoImport_local;
				\t\ttry {
				\t\t\treferencedRecordNoImport_local = findFieldValue(recordValue, REFERENCED_RECORD_NO_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new RecordOfBoolean(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedRecordNoImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedRecordNoImport = referencedRecordNoImport_local;

				\t\tOptional<BasicRecord> referencedRecordWithImport_local;
				\t\ttry {
				\t\t\treferencedRecordWithImport_local = findFieldValue(recordValue, REFERENCED_RECORD_WITH_IMPORT__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new BasicRecord(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedRecordWithImport_local = Optional.empty();
				\t\t}
				\t\tthis.referencedRecordWithImport = referencedRecordWithImport_local;

				\t\tOptional<InstanceObject> referencedReference_local;
				\t\ttry {
				\t\t\treferencedReference_local = findFieldValue(recordValue, REFERENCED_REFERENCE__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\treferencedReference_local = Optional.empty();
				\t\t}
				\t\tthis.referencedReference = referencedReference_local;
				\t}

				\tpublic Optional<Boolean> getOwnedBoolean() {
				\t\treturn ownedBoolean;
				\t}

				\tpublic Optional<String> getOwnedString() {
				\t\treturn ownedString;
				\t}

				\tpublic Optional<Classifier> getOwnedClassifier() {
				\t\treturn ownedClassifier;
				\t}

				\tpublic Optional<OwnedEnumeration_FieldType> getOwnedEnumeration() {
				\t\treturn ownedEnumeration;
				\t}

				\tpublic Optional<OwnedUnits_FieldType> getOwnedUnits() {
				\t\treturn ownedUnits;
				\t}

				\tpublic OptionalLong getOwnedIntegerNoUnits() {
				\t\treturn ownedIntegerNoUnits;
				\t}

				\tpublic OptionalDouble getOwnedRealNoUnits() {
				\t\treturn ownedRealNoUnits;
				\t}

				\tpublic Optional<IntegerWithUnits<Time>> getOwnedNumberWithUnitsNoImport() {
				\t\treturn ownedNumberWithUnitsNoImport;
				\t}

				\tpublic Optional<IntegerWithUnits<Mass>> getOwnedNumberWithUnitsWithImport() {
				\t\treturn ownedNumberWithUnitsWithImport;
				\t}

				\tpublic Optional<IntegerRangeWithUnits<Mass>> getOwnedRangeNoImport() {
				\t\treturn ownedRangeNoImport;
				\t}

				\tpublic Optional<RealRangeWithUnits<Mass>> getOwnedRangeImportNumber() {
				\t\treturn ownedRangeImportNumber;
				\t}

				\tpublic Optional<IntegerRangeWithUnits<Mass>> getOwnedRangeImportUnits() {
				\t\treturn ownedRangeImportUnits;
				\t}

				\tpublic Optional<OwnedRecord_FieldType> getOwnedRecord() {
				\t\treturn ownedRecord;
				\t}

				\tpublic Optional<InstanceObject> getOwnedReference() {
				\t\treturn ownedReference;
				\t}

				\tpublic Optional<Boolean> getReferencedBoolean() {
				\t\treturn referencedBoolean;
				\t}

				\tpublic Optional<String> getReferencedString() {
				\t\treturn referencedString;
				\t}

				\tpublic Optional<Classifier> getReferencedClassifier() {
				\t\treturn referencedClassifier;
				\t}

				\tpublic Optional<EnumType1> getReferencedEnumerationNoImport() {
				\t\treturn referencedEnumerationNoImport;
				\t}

				\tpublic Optional<Color> getReferencedEnumerationWithImport() {
				\t\treturn referencedEnumerationWithImport;
				\t}

				\tpublic Optional<Time> getReferencedUnitsNoImport() {
				\t\treturn referencedUnitsNoImport;
				\t}

				\tpublic Optional<Mass> getReferencedUnitsWithImport() {
				\t\treturn referencedUnitsWithImport;
				\t}

				\tpublic OptionalLong getReferencedIntegerNoUnits() {
				\t\treturn referencedIntegerNoUnits;
				\t}

				\tpublic OptionalDouble getReferencedRealNoUnits() {
				\t\treturn referencedRealNoUnits;
				\t}

				\tpublic Optional<IntegerWithUnits<IntegerOwnedUnits>> getReferencedNumberWithUnitsNoImport() {
				\t\treturn referencedNumberWithUnitsNoImport;
				\t}

				\tpublic Optional<RealWithUnits<Mass>> getReferencedNumberWithUnitsWithImport() {
				\t\treturn referencedNumberWithUnitsWithImport;
				\t}

				\tpublic Optional<IntegerRange> getReferencedRangeNoImport() {
				\t\treturn referencedRangeNoImport;
				\t}

				\tpublic Optional<RealRange> getReferencedRangeWithImport() {
				\t\treturn referencedRangeWithImport;
				\t}

				\tpublic Optional<RecordOfBoolean> getReferencedRecordNoImport() {
				\t\treturn referencedRecordNoImport;
				\t}

				\tpublic Optional<BasicRecord> getReferencedRecordWithImport() {
				\t\treturn referencedRecordWithImport;
				\t}

				\tpublic Optional<InstanceObject> getReferencedReference() {
				\t\treturn referencedReference;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (ownedBoolean.isEmpty()
				\t\t\t\t&& ownedString.isEmpty()
				\t\t\t\t&& ownedClassifier.isEmpty()
				\t\t\t\t&& ownedEnumeration.isEmpty()
				\t\t\t\t&& ownedUnits.isEmpty()
				\t\t\t\t&& ownedIntegerNoUnits.isEmpty()
				\t\t\t\t&& ownedRealNoUnits.isEmpty()
				\t\t\t\t&& ownedNumberWithUnitsNoImport.isEmpty()
				\t\t\t\t&& ownedNumberWithUnitsWithImport.isEmpty()
				\t\t\t\t&& ownedRangeNoImport.isEmpty()
				\t\t\t\t&& ownedRangeImportNumber.isEmpty()
				\t\t\t\t&& ownedRangeImportUnits.isEmpty()
				\t\t\t\t&& ownedRecord.isEmpty()
				\t\t\t\t&& ownedReference.isEmpty()
				\t\t\t\t&& referencedBoolean.isEmpty()
				\t\t\t\t&& referencedString.isEmpty()
				\t\t\t\t&& referencedClassifier.isEmpty()
				\t\t\t\t&& referencedEnumerationNoImport.isEmpty()
				\t\t\t\t&& referencedEnumerationWithImport.isEmpty()
				\t\t\t\t&& referencedUnitsNoImport.isEmpty()
				\t\t\t\t&& referencedUnitsWithImport.isEmpty()
				\t\t\t\t&& referencedIntegerNoUnits.isEmpty()
				\t\t\t\t&& referencedRealNoUnits.isEmpty()
				\t\t\t\t&& referencedNumberWithUnitsNoImport.isEmpty()
				\t\t\t\t&& referencedNumberWithUnitsWithImport.isEmpty()
				\t\t\t\t&& referencedRangeNoImport.isEmpty()
				\t\t\t\t&& referencedRangeWithImport.isEmpty()
				\t\t\t\t&& referencedRecordNoImport.isEmpty()
				\t\t\t\t&& referencedRecordWithImport.isEmpty()
				\t\t\t\t&& referencedReference.isEmpty()
				\t\t) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\townedBoolean.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_BOOLEAN__URI, OWNED_BOOLEAN__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\townedString.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_STRING__URI, OWNED_STRING__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\townedClassifier.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_CLASSIFIER__URI, OWNED_CLASSIFIER__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\townedEnumeration.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_ENUMERATION__URI, OWNED_ENUMERATION__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\townedUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_UNITS__URI, OWNED_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\townedIntegerNoUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_INTEGER_NO_UNITS__URI, OWNED_INTEGER_NO_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\townedRealNoUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_REAL_NO_UNITS__URI, OWNED_REAL_NO_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\townedNumberWithUnitsNoImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_NUMBER_WITH_UNITS_NO_IMPORT__URI, OWNED_NUMBER_WITH_UNITS_NO_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\townedNumberWithUnitsWithImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_NUMBER_WITH_UNITS_WITH_IMPORT__URI, OWNED_NUMBER_WITH_UNITS_WITH_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\townedRangeNoImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_RANGE_NO_IMPORT__URI, OWNED_RANGE_NO_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\townedRangeImportNumber.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_RANGE_IMPORT_NUMBER__URI, OWNED_RANGE_IMPORT_NUMBER__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\townedRangeImportUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_RANGE_IMPORT_UNITS__URI, OWNED_RANGE_IMPORT_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\townedRecord.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_RECORD__URI, OWNED_RECORD__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\townedReference.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, OWNED_REFERENCE__URI, OWNED_REFERENCE__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\treferencedBoolean.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_BOOLEAN__URI, REFERENCED_BOOLEAN__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\treferencedString.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_STRING__URI, REFERENCED_STRING__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\treferencedClassifier.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_CLASSIFIER__URI, REFERENCED_CLASSIFIER__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\treferencedEnumerationNoImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_ENUMERATION_NO_IMPORT__URI, REFERENCED_ENUMERATION_NO_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\treferencedEnumerationWithImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_ENUMERATION_WITH_IMPORT__URI, REFERENCED_ENUMERATION_WITH_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\treferencedUnitsNoImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_UNITS_NO_IMPORT__URI, REFERENCED_UNITS_NO_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\treferencedUnitsWithImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_UNITS_WITH_IMPORT__URI, REFERENCED_UNITS_WITH_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\treferencedIntegerNoUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_INTEGER_NO_UNITS__URI, REFERENCED_INTEGER_NO_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\treferencedRealNoUnits.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_REAL_NO_UNITS__URI, REFERENCED_REAL_NO_UNITS__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\treferencedNumberWithUnitsNoImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_NUMBER_WITH_UNITS_NO_IMPORT__URI, REFERENCED_NUMBER_WITH_UNITS_NO_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\treferencedNumberWithUnitsWithImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_NUMBER_WITH_UNITS_WITH_IMPORT__URI, REFERENCED_NUMBER_WITH_UNITS_WITH_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\treferencedRangeNoImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_RANGE_NO_IMPORT__URI, REFERENCED_RANGE_NO_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression());
				\t\t});
				\t\treferencedRangeWithImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_RANGE_WITH_IMPORT__URI, REFERENCED_RANGE_WITH_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression());
				\t\t});
				\t\treferencedRecordNoImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_RECORD_NO_IMPORT__URI, REFERENCED_RECORD_NO_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\treferencedRecordWithImport.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_RECORD_WITH_IMPORT__URI, REFERENCED_RECORD_WITH_IMPORT__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\treferencedReference.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, REFERENCED_REFERENCE__URI, REFERENCED_REFERENCE__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(
				\t\t\t\townedBoolean,
				\t\t\t\townedString,
				\t\t\t\townedClassifier,
				\t\t\t\townedEnumeration,
				\t\t\t\townedUnits,
				\t\t\t\townedIntegerNoUnits,
				\t\t\t\townedRealNoUnits,
				\t\t\t\townedNumberWithUnitsNoImport,
				\t\t\t\townedNumberWithUnitsWithImport,
				\t\t\t\townedRangeNoImport,
				\t\t\t\townedRangeImportNumber,
				\t\t\t\townedRangeImportUnits,
				\t\t\t\townedRecord,
				\t\t\t\townedReference,
				\t\t\t\treferencedBoolean,
				\t\t\t\treferencedString,
				\t\t\t\treferencedClassifier,
				\t\t\t\treferencedEnumerationNoImport,
				\t\t\t\treferencedEnumerationWithImport,
				\t\t\t\treferencedUnitsNoImport,
				\t\t\t\treferencedUnitsWithImport,
				\t\t\t\treferencedIntegerNoUnits,
				\t\t\t\treferencedRealNoUnits,
				\t\t\t\treferencedNumberWithUnitsNoImport,
				\t\t\t\treferencedNumberWithUnitsWithImport,
				\t\t\t\treferencedRangeNoImport,
				\t\t\t\treferencedRangeWithImport,
				\t\t\t\treferencedRecordNoImport,
				\t\t\t\treferencedRecordWithImport,
				\t\t\t\treferencedReference
				\t\t);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordType1 other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.ownedBoolean, other.ownedBoolean)
				\t\t\t\t&& Objects.equals(this.ownedString, other.ownedString)
				\t\t\t\t&& Objects.equals(this.ownedClassifier, other.ownedClassifier)
				\t\t\t\t&& Objects.equals(this.ownedEnumeration, other.ownedEnumeration)
				\t\t\t\t&& Objects.equals(this.ownedUnits, other.ownedUnits)
				\t\t\t\t&& Objects.equals(this.ownedIntegerNoUnits, other.ownedIntegerNoUnits)
				\t\t\t\t&& Objects.equals(this.ownedRealNoUnits, other.ownedRealNoUnits)
				\t\t\t\t&& Objects.equals(this.ownedNumberWithUnitsNoImport, other.ownedNumberWithUnitsNoImport)
				\t\t\t\t&& Objects.equals(this.ownedNumberWithUnitsWithImport, other.ownedNumberWithUnitsWithImport)
				\t\t\t\t&& Objects.equals(this.ownedRangeNoImport, other.ownedRangeNoImport)
				\t\t\t\t&& Objects.equals(this.ownedRangeImportNumber, other.ownedRangeImportNumber)
				\t\t\t\t&& Objects.equals(this.ownedRangeImportUnits, other.ownedRangeImportUnits)
				\t\t\t\t&& Objects.equals(this.ownedRecord, other.ownedRecord)
				\t\t\t\t&& Objects.equals(this.ownedReference, other.ownedReference)
				\t\t\t\t&& Objects.equals(this.referencedBoolean, other.referencedBoolean)
				\t\t\t\t&& Objects.equals(this.referencedString, other.referencedString)
				\t\t\t\t&& Objects.equals(this.referencedClassifier, other.referencedClassifier)
				\t\t\t\t&& Objects.equals(this.referencedEnumerationNoImport, other.referencedEnumerationNoImport)
				\t\t\t\t&& Objects.equals(this.referencedEnumerationWithImport, other.referencedEnumerationWithImport)
				\t\t\t\t&& Objects.equals(this.referencedUnitsNoImport, other.referencedUnitsNoImport)
				\t\t\t\t&& Objects.equals(this.referencedUnitsWithImport, other.referencedUnitsWithImport)
				\t\t\t\t&& Objects.equals(this.referencedIntegerNoUnits, other.referencedIntegerNoUnits)
				\t\t\t\t&& Objects.equals(this.referencedRealNoUnits, other.referencedRealNoUnits)
				\t\t\t\t&& Objects.equals(this.referencedNumberWithUnitsNoImport, other.referencedNumberWithUnitsNoImport)
				\t\t\t\t&& Objects.equals(this.referencedNumberWithUnitsWithImport, other.referencedNumberWithUnitsWithImport)
				\t\t\t\t&& Objects.equals(this.referencedRangeNoImport, other.referencedRangeNoImport)
				\t\t\t\t&& Objects.equals(this.referencedRangeWithImport, other.referencedRangeWithImport)
				\t\t\t\t&& Objects.equals(this.referencedRecordNoImport, other.referencedRecordNoImport)
				\t\t\t\t&& Objects.equals(this.referencedRecordWithImport, other.referencedRecordWithImport)
				\t\t\t\t&& Objects.equals(this.referencedReference, other.referencedReference);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.ownedBoolean.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_BOOLEAN__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedString.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_STRING__NAME);
				\t\t\tbuilder.append(" => \\"");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append("\\";");
				\t\t});
				\t\tthis.ownedClassifier.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_CLASSIFIER__NAME);
				\t\t\tbuilder.append(" => classifier (");
				\t\t\tbuilder.append(field.getQualifiedName());
				\t\t\tbuilder.append(");");
				\t\t});
				\t\tthis.ownedEnumeration.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_ENUMERATION__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedUnits.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedIntegerNoUnits.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_INTEGER_NO_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedRealNoUnits.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_REAL_NO_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedNumberWithUnitsNoImport.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_NUMBER_WITH_UNITS_NO_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedNumberWithUnitsWithImport.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_NUMBER_WITH_UNITS_WITH_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedRangeNoImport.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_RANGE_NO_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedRangeImportNumber.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_RANGE_IMPORT_NUMBER__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedRangeImportUnits.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_RANGE_IMPORT_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedRecord.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_RECORD__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.ownedReference.ifPresent(field -> {
				\t\t\tbuilder.append(OWNED_REFERENCE__NAME);
				\t\t\tbuilder.append(" => reference (");
				\t\t\tbuilder.append(field.getName());
				\t\t\tbuilder.append(");");
				\t\t});
				\t\tthis.referencedBoolean.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_BOOLEAN__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.referencedString.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_STRING__NAME);
				\t\t\tbuilder.append(" => \\"");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append("\\";");
				\t\t});
				\t\tthis.referencedClassifier.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_CLASSIFIER__NAME);
				\t\t\tbuilder.append(" => classifier (");
				\t\t\tbuilder.append(field.getQualifiedName());
				\t\t\tbuilder.append(");");
				\t\t});
				\t\tthis.referencedEnumerationNoImport.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_ENUMERATION_NO_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.referencedEnumerationWithImport.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_ENUMERATION_WITH_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.referencedUnitsNoImport.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_UNITS_NO_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.referencedUnitsWithImport.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_UNITS_WITH_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.referencedIntegerNoUnits.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_INTEGER_NO_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.referencedRealNoUnits.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_REAL_NO_UNITS__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.referencedNumberWithUnitsNoImport.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_NUMBER_WITH_UNITS_NO_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.referencedNumberWithUnitsWithImport.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_NUMBER_WITH_UNITS_WITH_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.referencedRangeNoImport.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_RANGE_NO_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.referencedRangeWithImport.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_RANGE_WITH_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.referencedRecordNoImport.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_RECORD_NO_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.referencedRecordWithImport.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_RECORD_WITH_IMPORT__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.referencedReference.ifPresent(field -> {
				\t\t\tbuilder.append(REFERENCED_REFERENCE__NAME);
				\t\t\tbuilder.append(" => reference (");
				\t\t\tbuilder.append(field.getName());
				\t\t\tbuilder.append(");");
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}

				\tpublic enum OwnedEnumeration_FieldType implements GeneratedEnumeration {
				\t\tALLEGHENY("allegheny", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.3/@ownedPropertyType/@ownedLiteral.0"),
				\t\tMONONGAHELA("monongahela", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.3/@ownedPropertyType/@ownedLiteral.1"),
				\t\tOHIO("ohio", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.3/@ownedPropertyType/@ownedLiteral.2");

				\t\tprivate final String originalName;
				\t\tprivate final URI uri;

				\t\tprivate OwnedEnumeration_FieldType(String originalName, String uri) {
				\t\t\tthis.originalName = originalName;
				\t\t\tthis.uri = URI.createURI(uri);
				\t\t}

				\t\tpublic static OwnedEnumeration_FieldType valueOf(PropertyExpression propertyExpression) {
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
				\t\tINCH(1.0, "inch", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.4/@ownedPropertyType/@ownedLiteral.0"),
				\t\tFOOT(12.0, "foot", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.4/@ownedPropertyType/@ownedLiteral.1"),
				\t\tYARD(36.0, "yard", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.4/@ownedPropertyType/@ownedLiteral.2");

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
				\t\tpublic static final String STRING_FIELD__NAME = "string_field";
				\t\tpublic static final String INTEGER_FIELD__NAME = "integer_field";
				\t\tpublic static final URI STRING_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.12/@ownedPropertyType/@ownedField.0");
				\t\tpublic static final URI INTEGER_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.12/@ownedPropertyType/@ownedField.1");

				\t\tprivate final Optional<String> stringField;
				\t\tprivate final OptionalLong integerField;

				\t\tpublic OwnedRecord_FieldType(
				\t\t\t\tOptional<String> stringField,
				\t\t\t\tOptionalLong integerField
				\t\t) {
				\t\t\tthis.stringField = stringField;
				\t\t\tthis.integerField = integerField;
				\t\t}

				\t\tpublic OwnedRecord_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\tOptional<String> stringField_local;
				\t\t\ttry {
				\t\t\t\tstringField_local = findFieldValue(recordValue, STRING_FIELD__NAME).map(field -> {
				\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t\t});
				\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\tstringField_local = Optional.empty();
				\t\t\t}
				\t\t\tthis.stringField = stringField_local;

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
				\t\t}

				\t\tpublic OwnedRecord_FieldType(PropertyExpression propertyExpression) {
				\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\tOptional<String> stringField_local;
				\t\t\ttry {
				\t\t\t\tstringField_local = findFieldValue(recordValue, STRING_FIELD__NAME).map(field -> {
				\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t\t});
				\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\tstringField_local = Optional.empty();
				\t\t\t}
				\t\t\tthis.stringField = stringField_local;

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
				\t\t}

				\t\tpublic Optional<String> getStringField() {
				\t\t\treturn stringField;
				\t\t}

				\t\tpublic OptionalLong getIntegerField() {
				\t\t\treturn integerField;
				\t\t}

				\t\t@Override
				\t\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\t\tif (stringField.isEmpty()
				\t\t\t\t\t&& integerField.isEmpty()
				\t\t\t) {
				\t\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t\t}
				\t\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\t\tstringField.ifPresent(field -> {
				\t\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\t\tfieldAssociation.setProperty(loadField(resourceSet, STRING_FIELD__URI, STRING_FIELD__NAME));
				\t\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t\t});
				\t\t\tintegerField.ifPresent(field -> {
				\t\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\t\tfieldAssociation.setProperty(loadField(resourceSet, INTEGER_FIELD__URI, INTEGER_FIELD__NAME));
				\t\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t\t});
				\t\t\treturn recordValue;
				\t\t}

				\t\t@Override
				\t\tpublic int hashCode() {
				\t\t\treturn Objects.hash(
				\t\t\t\t\tstringField,
				\t\t\t\t\tintegerField
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
				\t\t\treturn Objects.equals(this.stringField, other.stringField)
				\t\t\t\t\t&& Objects.equals(this.integerField, other.integerField);
				\t\t}

				\t\t@Override
				\t\tpublic String toString() {
				\t\t\tvar builder = new StringBuilder();
				\t\t\tbuilder.append('[');
				\t\t\tthis.stringField.ifPresent(field -> {
				\t\t\t\tbuilder.append(STRING_FIELD__NAME);
				\t\t\t\tbuilder.append(" => \\"");
				\t\t\t\tbuilder.append(field);
				\t\t\t\tbuilder.append("\\";");
				\t\t\t});
				\t\t\tthis.integerField.ifPresent(field -> {
				\t\t\t\tbuilder.append(INTEGER_FIELD__NAME);
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
				\tpublic static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.10/@ownedField.0");

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
		var recordOfString = """
				package ps1;

				import java.util.Objects;
				import java.util.Optional;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.StringLiteral;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordOfString extends GeneratedRecord {
				\tpublic static final String FIELD__NAME = "field";
				\tpublic static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.0");

				\tprivate final Optional<String> field;

				\tpublic RecordOfString(Optional<String> field) {
				\t\tthis.field = field;
				\t}

				\tpublic RecordOfString(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<String> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic RecordOfString(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<String> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic Optional<String> getField() {
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
				\t\tif (!(obj instanceof RecordOfString other)) {
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
				\t\t\tbuilder.append(" => \\"");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append("\\";");
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var recordOfClassifier = """
				package ps1;

				import java.util.Objects;
				import java.util.Optional;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.Classifier;
				import org.osate.aadl2.ClassifierValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordOfClassifier extends GeneratedRecord {
				\tpublic static final String FIELD__NAME = "field";
				\tpublic static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.0");

				\tprivate final Optional<Classifier> field;

				\tpublic RecordOfClassifier(Optional<Classifier> field) {
				\t\tthis.field = field;
				\t}

				\tpublic RecordOfClassifier(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Classifier> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ClassifierValue) resolved).getClassifier();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic RecordOfClassifier(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Classifier> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ClassifierValue) resolved).getClassifier();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic Optional<Classifier> getField() {
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
				\t\tif (!(obj instanceof RecordOfClassifier other)) {
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
				\t\t\tbuilder.append(" => classifier (");
				\t\t\tbuilder.append(field.getQualifiedName());
				\t\t\tbuilder.append(");");
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var recordOfEnum = """
				package ps1;

				import java.util.Objects;
				import java.util.Optional;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedEnumeration;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordOfEnum extends GeneratedRecord {
				\tpublic static final String FIELD__NAME = "field";
				\tpublic static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.13/@ownedField.0");

				\tprivate final Optional<Field_FieldType> field;

				\tpublic RecordOfEnum(Optional<Field_FieldType> field) {
				\t\tthis.field = field;
				\t}

				\tpublic RecordOfEnum(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Field_FieldType> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn Field_FieldType.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic RecordOfEnum(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Field_FieldType> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn Field_FieldType.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic Optional<Field_FieldType> getField() {
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
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
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
				\t\tif (!(obj instanceof RecordOfEnum other)) {
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

				\tpublic enum Field_FieldType implements GeneratedEnumeration {
				\t\tA("a", "__synthetic1.aadl#/0/@ownedPropertyType.13/@ownedField.0/@ownedPropertyType/@ownedLiteral.0"),
				\t\tB("b", "__synthetic1.aadl#/0/@ownedPropertyType.13/@ownedField.0/@ownedPropertyType/@ownedLiteral.1"),
				\t\tC("c", "__synthetic1.aadl#/0/@ownedPropertyType.13/@ownedField.0/@ownedPropertyType/@ownedLiteral.2");

				\t\tprivate final String originalName;
				\t\tprivate final URI uri;

				\t\tprivate Field_FieldType(String originalName, String uri) {
				\t\t\tthis.originalName = originalName;
				\t\t\tthis.uri = URI.createURI(uri);
				\t\t}

				\t\tpublic static Field_FieldType valueOf(PropertyExpression propertyExpression) {
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
				}
				""";
		var recordOfUnits = """
				package ps1;

				import java.util.Objects;
				import java.util.Optional;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
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

				public class RecordOfUnits extends GeneratedRecord {
				\tpublic static final String FIELD__NAME = "field";
				\tpublic static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.14/@ownedField.0");

				\tprivate final Optional<Field_FieldType> field;

				\tpublic RecordOfUnits(Optional<Field_FieldType> field) {
				\t\tthis.field = field;
				\t}

				\tpublic RecordOfUnits(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Field_FieldType> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn Field_FieldType.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic RecordOfUnits(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Field_FieldType> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn Field_FieldType.valueOf(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic Optional<Field_FieldType> getField() {
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
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
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
				\t\tif (!(obj instanceof RecordOfUnits other)) {
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

				\tpublic enum Field_FieldType implements GeneratedUnits<Field_FieldType> {
				\t\tMM(1.0, "mm", "__synthetic1.aadl#/0/@ownedPropertyType.14/@ownedField.0/@ownedPropertyType/@ownedLiteral.0"),
				\t\tCM(10.0, "cm", "__synthetic1.aadl#/0/@ownedPropertyType.14/@ownedField.0/@ownedPropertyType/@ownedLiteral.1");

				\t\tprivate final double factorToBase;
				\t\tprivate final String originalName;
				\t\tprivate final URI uri;

				\t\tprivate Field_FieldType(double factorToBase, String originalName, String uri) {
				\t\t\tthis.factorToBase = factorToBase;
				\t\t\tthis.originalName = originalName;
				\t\t\tthis.uri = URI.createURI(uri);
				\t\t}

				\t\tpublic static Field_FieldType valueOf(PropertyExpression propertyExpression) {
				\t\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorToBase() {
				\t\t\treturn factorToBase;
				\t\t}

				\t\t@Override
				\t\tpublic double getFactorTo(Field_FieldType target) {
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
		var recordOfInteger = """
				package ps1;

				import java.util.Objects;
				import java.util.Optional;
				import java.util.OptionalLong;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.IntegerLiteral;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordOfInteger extends GeneratedRecord {
				\tpublic static final String FIELD__NAME = "field";
				\tpublic static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.15/@ownedField.0");

				\tprivate final OptionalLong field;

				\tpublic RecordOfInteger(OptionalLong field) {
				\t\tthis.field = field;
				\t}

				\tpublic RecordOfInteger(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptionalLong field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = OptionalLong.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic RecordOfInteger(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptionalLong field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = OptionalLong.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic OptionalLong getField() {
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
				\t\tif (!(obj instanceof RecordOfInteger other)) {
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
		var recordOfReal = """
				package ps1;

				import java.util.Objects;
				import java.util.Optional;
				import java.util.OptionalDouble;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RealLiteral;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordOfReal extends GeneratedRecord {
				\tpublic static final String FIELD__NAME = "field";
				\tpublic static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.16/@ownedField.0");

				\tprivate final OptionalDouble field;

				\tpublic RecordOfReal(OptionalDouble field) {
				\t\tthis.field = field;
				\t}

				\tpublic RecordOfReal(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptionalDouble field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((RealLiteral) resolved).getValue();
				\t\t\t}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = OptionalDouble.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic RecordOfReal(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptionalDouble field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((RealLiteral) resolved).getValue();
				\t\t\t}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = OptionalDouble.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic OptionalDouble getField() {
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
				\t\tif (!(obj instanceof RecordOfReal other)) {
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
		var recordOfReference = """
				package ps1;

				import java.util.Objects;
				import java.util.Optional;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.instance.InstanceObject;
				import org.osate.aadl2.instance.InstanceReferenceValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordOfReference extends GeneratedRecord {
				\tpublic static final String FIELD__NAME = "field";
				\tpublic static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.17/@ownedField.0");

				\tprivate final Optional<InstanceObject> field;

				\tpublic RecordOfReference(Optional<InstanceObject> field) {
				\t\tthis.field = field;
				\t}

				\tpublic RecordOfReference(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<InstanceObject> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic RecordOfReference(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<InstanceObject> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic Optional<InstanceObject> getField() {
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
				\t\tif (!(obj instanceof RecordOfReference other)) {
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
				\t\t\tbuilder.append(" => reference (");
				\t\t\tbuilder.append(field.getName());
				\t\t\tbuilder.append(");");
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var nestedRecord = """
				package ps1;

				import java.util.Objects;
				import java.util.Optional;
				import java.util.OptionalLong;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.IntegerLiteral;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class NestedRecord extends GeneratedRecord {
				\tpublic static final String FIELD1__NAME = "field1";
				\tpublic static final URI FIELD1__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.18/@ownedField.0");

				\tprivate final Optional<Field1_FieldType> field1;

				\tpublic NestedRecord(Optional<Field1_FieldType> field1) {
				\t\tthis.field1 = field1;
				\t}

				\tpublic NestedRecord(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Field1_FieldType> field1_local;
				\t\ttry {
				\t\t\tfield1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn new Field1_FieldType(resolved, lookupContext, mode);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield1_local = Optional.empty();
				\t\t}
				\t\tthis.field1 = field1_local;
				\t}

				\tpublic NestedRecord(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Field1_FieldType> field1_local;
				\t\ttry {
				\t\t\tfield1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn new Field1_FieldType(resolved);
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield1_local = Optional.empty();
				\t\t}
				\t\tthis.field1 = field1_local;
				\t}

				\tpublic Optional<Field1_FieldType> getField1() {
				\t\treturn field1;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (field1.isEmpty()) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\tfield1.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD1__URI, FIELD1__NAME));
				\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(field1);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof NestedRecord other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.field1, other.field1);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.field1.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD1__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}

				\tpublic static class Field1_FieldType extends GeneratedRecord {
				\t\tpublic static final String FIELD2__NAME = "field2";
				\t\tpublic static final URI FIELD2__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.18/@ownedField.0/@ownedPropertyType/@ownedField.0");

				\t\tprivate final Optional<Field2_FieldType> field2;

				\t\tpublic Field1_FieldType(Optional<Field2_FieldType> field2) {
				\t\t\tthis.field2 = field2;
				\t\t}

				\t\tpublic Field1_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\tOptional<Field2_FieldType> field2_local;
				\t\t\ttry {
				\t\t\t\tfield2_local = findFieldValue(recordValue, FIELD2__NAME).map(field -> {
				\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\t\treturn new Field2_FieldType(resolved, lookupContext, mode);
				\t\t\t\t});
				\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\tfield2_local = Optional.empty();
				\t\t\t}
				\t\t\tthis.field2 = field2_local;
				\t\t}

				\t\tpublic Field1_FieldType(PropertyExpression propertyExpression) {
				\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\tOptional<Field2_FieldType> field2_local;
				\t\t\ttry {
				\t\t\t\tfield2_local = findFieldValue(recordValue, FIELD2__NAME).map(field -> {
				\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\t\treturn new Field2_FieldType(resolved);
				\t\t\t\t});
				\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\tfield2_local = Optional.empty();
				\t\t\t}
				\t\t\tthis.field2 = field2_local;
				\t\t}

				\t\tpublic Optional<Field2_FieldType> getField2() {
				\t\t\treturn field2;
				\t\t}

				\t\t@Override
				\t\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\t\tif (field2.isEmpty()) {
				\t\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t\t}
				\t\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\t\tfield2.ifPresent(field -> {
				\t\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD2__URI, FIELD2__NAME));
				\t\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t\t});
				\t\t\treturn recordValue;
				\t\t}

				\t\t@Override
				\t\tpublic int hashCode() {
				\t\t\treturn Objects.hash(field2);
				\t\t}

				\t\t@Override
				\t\tpublic boolean equals(Object obj) {
				\t\t\tif (this == obj) {
				\t\t\t\treturn true;
				\t\t\t}
				\t\t\tif (!(obj instanceof Field1_FieldType other)) {
				\t\t\t\treturn false;
				\t\t\t}
				\t\t\treturn Objects.equals(this.field2, other.field2);
				\t\t}

				\t\t@Override
				\t\tpublic String toString() {
				\t\t\tvar builder = new StringBuilder();
				\t\t\tbuilder.append('[');
				\t\t\tthis.field2.ifPresent(field -> {
				\t\t\t\tbuilder.append(FIELD2__NAME);
				\t\t\t\tbuilder.append(" => ");
				\t\t\t\tbuilder.append(field);
				\t\t\t\tbuilder.append(';');
				\t\t\t});
				\t\t\tbuilder.append(']');
				\t\t\treturn builder.toString();
				\t\t}

				\t\tpublic static class Field2_FieldType extends GeneratedRecord {
				\t\t\tpublic static final String FIELD3__NAME = "field3";
				\t\t\tpublic static final URI FIELD3__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.18/@ownedField.0/@ownedPropertyType/@ownedField.0/@ownedPropertyType/@ownedField.0");

				\t\t\tprivate final Optional<Field3_FieldType> field3;

				\t\t\tpublic Field2_FieldType(Optional<Field3_FieldType> field3) {
				\t\t\t\tthis.field3 = field3;
				\t\t\t}

				\t\t\tpublic Field2_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\t\tOptional<Field3_FieldType> field3_local;
				\t\t\t\ttry {
				\t\t\t\t\tfield3_local = findFieldValue(recordValue, FIELD3__NAME).map(field -> {
				\t\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\t\t\treturn new Field3_FieldType(resolved, lookupContext, mode);
				\t\t\t\t\t});
				\t\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\t\tfield3_local = Optional.empty();
				\t\t\t\t}
				\t\t\t\tthis.field3 = field3_local;
				\t\t\t}

				\t\t\tpublic Field2_FieldType(PropertyExpression propertyExpression) {
				\t\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\t\tOptional<Field3_FieldType> field3_local;
				\t\t\t\ttry {
				\t\t\t\t\tfield3_local = findFieldValue(recordValue, FIELD3__NAME).map(field -> {
				\t\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\t\t\treturn new Field3_FieldType(resolved);
				\t\t\t\t\t});
				\t\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\t\tfield3_local = Optional.empty();
				\t\t\t\t}
				\t\t\t\tthis.field3 = field3_local;
				\t\t\t}

				\t\t\tpublic Optional<Field3_FieldType> getField3() {
				\t\t\t\treturn field3;
				\t\t\t}

				\t\t\t@Override
				\t\t\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\t\t\tif (field3.isEmpty()) {
				\t\t\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t\t\t}
				\t\t\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\t\t\tfield3.ifPresent(field -> {
				\t\t\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD3__URI, FIELD3__NAME));
				\t\t\t\t\tfieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
				\t\t\t\t});
				\t\t\t\treturn recordValue;
				\t\t\t}

				\t\t\t@Override
				\t\t\tpublic int hashCode() {
				\t\t\t\treturn Objects.hash(field3);
				\t\t\t}

				\t\t\t@Override
				\t\t\tpublic boolean equals(Object obj) {
				\t\t\t\tif (this == obj) {
				\t\t\t\t\treturn true;
				\t\t\t\t}
				\t\t\t\tif (!(obj instanceof Field2_FieldType other)) {
				\t\t\t\t\treturn false;
				\t\t\t\t}
				\t\t\t\treturn Objects.equals(this.field3, other.field3);
				\t\t\t}

				\t\t\t@Override
				\t\t\tpublic String toString() {
				\t\t\t\tvar builder = new StringBuilder();
				\t\t\t\tbuilder.append('[');
				\t\t\t\tthis.field3.ifPresent(field -> {
				\t\t\t\t\tbuilder.append(FIELD3__NAME);
				\t\t\t\t\tbuilder.append(" => ");
				\t\t\t\t\tbuilder.append(field);
				\t\t\t\t\tbuilder.append(';');
				\t\t\t\t});
				\t\t\t\tbuilder.append(']');
				\t\t\t\treturn builder.toString();
				\t\t\t}

				\t\t\tpublic static class Field3_FieldType extends GeneratedRecord {
				\t\t\t\tpublic static final String INNER_FIELD__NAME = "inner_field";
				\t\t\t\tpublic static final URI INNER_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.18/@ownedField.0/@ownedPropertyType/@ownedField.0/@ownedPropertyType/@ownedField.0/@ownedPropertyType/@ownedField.0");

				\t\t\t\tprivate final OptionalLong innerField;

				\t\t\t\tpublic Field3_FieldType(OptionalLong innerField) {
				\t\t\t\t\tthis.innerField = innerField;
				\t\t\t\t}

				\t\t\t\tpublic Field3_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\t\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\t\t\tOptionalLong innerField_local;
				\t\t\t\t\ttry {
				\t\t\t\t\t\tinnerField_local = findFieldValue(recordValue, INNER_FIELD__NAME).map(field -> {
				\t\t\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\t\t\tinnerField_local = OptionalLong.empty();
				\t\t\t\t\t}
				\t\t\t\t\tthis.innerField = innerField_local;
				\t\t\t\t}

				\t\t\t\tpublic Field3_FieldType(PropertyExpression propertyExpression) {
				\t\t\t\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\t\t\t\tOptionalLong innerField_local;
				\t\t\t\t\ttry {
				\t\t\t\t\t\tinnerField_local = findFieldValue(recordValue, INNER_FIELD__NAME).map(field -> {
				\t\t\t\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\t\t\t\treturn ((IntegerLiteral) resolved).getValue();
				\t\t\t\t\t\t}).map(OptionalLong::of).orElse(OptionalLong.empty());
				\t\t\t\t\t} catch (PropertyNotPresentException e) {
				\t\t\t\t\t\tinnerField_local = OptionalLong.empty();
				\t\t\t\t\t}
				\t\t\t\t\tthis.innerField = innerField_local;
				\t\t\t\t}

				\t\t\t\tpublic OptionalLong getInnerField() {
				\t\t\t\t\treturn innerField;
				\t\t\t\t}

				\t\t\t\t@Override
				\t\t\t\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\t\t\t\tif (innerField.isEmpty()) {
				\t\t\t\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t\t\t\t}
				\t\t\t\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\t\t\t\tinnerField.ifPresent(field -> {
				\t\t\t\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\t\t\t\tfieldAssociation.setProperty(loadField(resourceSet, INNER_FIELD__URI, INNER_FIELD__NAME));
				\t\t\t\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t\t\t\t});
				\t\t\t\t\treturn recordValue;
				\t\t\t\t}

				\t\t\t\t@Override
				\t\t\t\tpublic int hashCode() {
				\t\t\t\t\treturn Objects.hash(innerField);
				\t\t\t\t}

				\t\t\t\t@Override
				\t\t\t\tpublic boolean equals(Object obj) {
				\t\t\t\t\tif (this == obj) {
				\t\t\t\t\t\treturn true;
				\t\t\t\t\t}
				\t\t\t\t\tif (!(obj instanceof Field3_FieldType other)) {
				\t\t\t\t\t\treturn false;
				\t\t\t\t\t}
				\t\t\t\t\treturn Objects.equals(this.innerField, other.innerField);
				\t\t\t\t}

				\t\t\t\t@Override
				\t\t\t\tpublic String toString() {
				\t\t\t\t\tvar builder = new StringBuilder();
				\t\t\t\t\tbuilder.append('[');
				\t\t\t\t\tthis.innerField.ifPresent(field -> {
				\t\t\t\t\t\tbuilder.append(INNER_FIELD__NAME);
				\t\t\t\t\t\tbuilder.append(" => ");
				\t\t\t\t\t\tbuilder.append(field);
				\t\t\t\t\t\tbuilder.append(';');
				\t\t\t\t\t});
				\t\t\t\t\tbuilder.append(']');
				\t\t\t\t\treturn builder.toString();
				\t\t\t\t}
				\t\t\t}
				\t\t}
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(ps1, ps2));
		assertEquals("src-gen/ps1", results.getPackagePath());
		assertEquals(14, results.getClasses().size());

		assertEquals("Ps1.java", results.getClasses().get(0).getFileName());
		assertEquals(ps1Class, results.getClasses().get(0).getContents());

		assertEquals("Time.java", results.getClasses().get(1).getFileName());
		assertEquals(time, results.getClasses().get(1).getContents());

		assertEquals("IntegerOwnedUnits.java", results.getClasses().get(2).getFileName());
		assertEquals(integerOwnedUnits, results.getClasses().get(2).getContents());

		assertEquals("EnumType1.java", results.getClasses().get(3).getFileName());
		assertEquals(enumType1, results.getClasses().get(3).getContents());

		assertEquals("RecordType1.java", results.getClasses().get(4).getFileName());
		assertEquals(recordType1, results.getClasses().get(4).getContents());

		assertEquals("RecordOfBoolean.java", results.getClasses().get(5).getFileName());
		assertEquals(recordOfBoolean, results.getClasses().get(5).getContents());

		assertEquals("RecordOfString.java", results.getClasses().get(6).getFileName());
		assertEquals(recordOfString, results.getClasses().get(6).getContents());

		assertEquals("RecordOfClassifier.java", results.getClasses().get(7).getFileName());
		assertEquals(recordOfClassifier, results.getClasses().get(7).getContents());

		assertEquals("RecordOfEnum.java", results.getClasses().get(8).getFileName());
		assertEquals(recordOfEnum, results.getClasses().get(8).getContents());

		assertEquals("RecordOfUnits.java", results.getClasses().get(9).getFileName());
		assertEquals(recordOfUnits, results.getClasses().get(9).getContents());

		assertEquals("RecordOfInteger.java", results.getClasses().get(10).getFileName());
		assertEquals(recordOfInteger, results.getClasses().get(10).getContents());

		assertEquals("RecordOfReal.java", results.getClasses().get(11).getFileName());
		assertEquals(recordOfReal, results.getClasses().get(11).getContents());

		assertEquals("RecordOfReference.java", results.getClasses().get(12).getFileName());
		assertEquals(recordOfReference, results.getClasses().get(12).getContents());

		assertEquals("NestedRecord.java", results.getClasses().get(13).getFileName());
		assertEquals(nestedRecord, results.getClasses().get(13).getContents());
	}
}
