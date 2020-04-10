package org.osate.propertiescodegen.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.PropertySet
import org.osate.propertiescodegen.PropertiesCodeGen
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class RecordTypeTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testRecordType() {
		val ps2 = '''
			property set ps2 is
				mass: type units (g, kg => g * 1000);
				mass_type: type aadlreal units ps2::mass;
				color: type enumeration (red, green, blue);
				basic_integer: type aadlinteger;
				basic_real: type aadlreal;
				basic_range: type range of aadlreal;
				basic_record: type record (field: aadlreal;);
			end ps2;
		'''
		val ps1 = '''
			property set ps1 is
				with ps2;
				
				time: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				integer_owned_units: type aadlinteger units (mm, cm => mm * 10, m => cm * 100);
				integer_referenced_units_other_file: type aadlinteger units ps2::mass;
				boolean_type_1: type aadlboolean;
				string_type_1: type aadlstring;
				classifier_type_1: type classifier;
				enum_type_1: type enumeration (one, two, three);
				reference_type_1: type reference;
				range_of_integer_no_units: type range of aadlinteger;
				
				record_type_1: type record (
					owned_boolean: aadlboolean;
					owned_string: aadlstring;
					owned_classifier: classifier;
					owned_enumeration: enumeration (allegheny, monongahela, ohio);
					owned_units: units (inch, foot => inch * 12, yard => foot * 3);
					owned_integer_no_units: aadlinteger;
					owned_real_no_units: aadlreal;
					owned_number_with_units_no_import: aadlinteger units ps1::time;
					owned_number_with_units_with_import: aadlinteger units ps2::mass;
					owned_range_no_import: range of ps1::integer_referenced_units_other_file;
					owned_range_import_number: range of ps2::mass_type;
					owned_range_import_units: range of aadlinteger units ps2::mass;
					owned_record: record (
						string_field: aadlstring;
						integer_field: aadlinteger;
					);
					owned_reference: reference;
					referenced_boolean: ps1::boolean_type_1;
					referenced_string: ps1::string_type_1;
					referenced_classifier: ps1::classifier_type_1;
					referenced_enumeration_no_import: ps1::enum_type_1;
					referenced_enumeration_with_import: ps2::color;
					referenced_units_no_import: ps1::time;
					referenced_units_with_import: ps2::mass;
					referenced_integer_no_units: ps2::basic_integer;
					referenced_real_no_units: ps2::basic_real;
					referenced_number_with_units_no_import: ps1::integer_owned_units;
					referenced_number_with_units_with_import: ps2::mass_type;
					referenced_range_no_import: ps1::range_of_integer_no_units;
					referenced_range_with_import: ps2::basic_range;
					referenced_record_no_import: ps1::record_of_boolean;
					referenced_record_with_import: ps2::basic_record;
					referenced_reference: ps1::reference_type_1;
				);
				record_of_boolean: type record (field: aadlboolean;);
				record_of_string: type record (field: aadlstring;);
				record_of_classifier: type record (field: classifier;);
				record_of_enum: type record (field: enumeration (a, b, c););
				record_of_units: type record (field: units (mm, cm => mm * 10););
				record_of_integer: type record (field: aadlinteger;);
				record_of_real: type record (field: aadlreal;);
				record_of_reference: type record (field: reference;);
				nested_record: type record(field1: record (field2: record (field3: record (inner_field: aadlinteger;););););
			end ps1;
		'''
		val time = '''
			package ps1;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum Time implements GeneratedUnits {
				SEC(1.0, "sec"),
				MIN(60.0, "min"),
				HR(3600.0, "hr"),
				DAY(86400.0, "day");
				
				private final double factorToBase;
				private final String originalName;
				
				private Time(double factorToBase, String originalName) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
				}
				
				public static Time valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val integerOwnedUnits = '''
			package ps1;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum IntegerOwnedUnits implements GeneratedUnits {
				MM(1.0, "mm"),
				CM(10.0, "cm"),
				M(1000.0, "m");
				
				private final double factorToBase;
				private final String originalName;
				
				private IntegerOwnedUnits(double factorToBase, String originalName) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
				}
				
				public static IntegerOwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val enumType1 = '''
			package ps1;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			
			public enum EnumType1 {
				ONE("one"),
				TWO("two"),
				THREE("three");
				
				private final String originalName;
				
				private EnumType1(String originalName) {
					this.originalName = originalName;
				}
				
				public static EnumType1 valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val recordType1 = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			import java.util.OptionalDouble;
			import java.util.OptionalLong;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.Classifier;
			import org.osate.aadl2.ClassifierValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.StringLiteral;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
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
			
			public class RecordType1 {
				private final Optional<Boolean> ownedBoolean;
				private final Optional<String> ownedString;
				private final Optional<Classifier> ownedClassifier;
				private final Optional<OwnedEnumeration_FieldType> ownedEnumeration;
				private final Optional<OwnedUnits_FieldType> ownedUnits;
				private final OptionalLong ownedIntegerNoUnits;
				private final OptionalDouble ownedRealNoUnits;
				private final Optional<IntegerWithUnits<Time>> ownedNumberWithUnitsNoImport;
				private final Optional<IntegerWithUnits<Mass>> ownedNumberWithUnitsWithImport;
				private final Optional<IntegerRangeWithUnits<Mass>> ownedRangeNoImport;
				private final Optional<RealRangeWithUnits<Mass>> ownedRangeImportNumber;
				private final Optional<IntegerRangeWithUnits<Mass>> ownedRangeImportUnits;
				private final Optional<OwnedRecord_FieldType> ownedRecord;
				private final Optional<InstanceObject> ownedReference;
				private final Optional<Boolean> referencedBoolean;
				private final Optional<String> referencedString;
				private final Optional<Classifier> referencedClassifier;
				private final Optional<EnumType1> referencedEnumerationNoImport;
				private final Optional<Color> referencedEnumerationWithImport;
				private final Optional<Time> referencedUnitsNoImport;
				private final Optional<Mass> referencedUnitsWithImport;
				private final OptionalLong referencedIntegerNoUnits;
				private final OptionalDouble referencedRealNoUnits;
				private final Optional<IntegerWithUnits<IntegerOwnedUnits>> referencedNumberWithUnitsNoImport;
				private final Optional<RealWithUnits<Mass>> referencedNumberWithUnitsWithImport;
				private final Optional<IntegerRange> referencedRangeNoImport;
				private final Optional<RealRange> referencedRangeWithImport;
				private final Optional<RecordOfBoolean> referencedRecordNoImport;
				private final Optional<BasicRecord> referencedRecordWithImport;
				private final Optional<InstanceObject> referencedReference;
				
				public RecordType1(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.ownedBoolean = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_boolean"))
							.map(field -> ((BooleanLiteral) field.getOwnedValue()).getValue())
							.findAny();
					this.ownedString = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_string"))
							.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
							.findAny();
					this.ownedClassifier = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_classifier"))
							.map(field -> ((ClassifierValue) field.getOwnedValue()).getClassifier())
							.findAny();
					this.ownedEnumeration = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_enumeration"))
							.map(field -> OwnedEnumeration_FieldType.valueOf(field.getOwnedValue()))
							.findAny();
					this.ownedUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_units"))
							.map(field -> OwnedUnits_FieldType.valueOf(field.getOwnedValue()))
							.findAny();
					this.ownedIntegerNoUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_integer_no_units"))
							.mapToLong(field -> ((IntegerLiteral) field.getOwnedValue()).getValue())
							.findAny();
					this.ownedRealNoUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_real_no_units"))
							.mapToDouble(field -> ((RealLiteral) field.getOwnedValue()).getValue())
							.findAny();
					this.ownedNumberWithUnitsNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_number_with_units_no_import"))
							.map(field -> new IntegerWithUnits<>(field.getOwnedValue(), Time.class))
							.findAny();
					this.ownedNumberWithUnitsWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_number_with_units_with_import"))
							.map(field -> new IntegerWithUnits<>(field.getOwnedValue(), Mass.class))
							.findAny();
					this.ownedRangeNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_range_no_import"))
							.map(field -> new IntegerRangeWithUnits<>(field.getOwnedValue(), Mass.class))
							.findAny();
					this.ownedRangeImportNumber = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_range_import_number"))
							.map(field -> new RealRangeWithUnits<>(field.getOwnedValue(), Mass.class))
							.findAny();
					this.ownedRangeImportUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_range_import_units"))
							.map(field -> new IntegerRangeWithUnits<>(field.getOwnedValue(), Mass.class))
							.findAny();
					this.ownedRecord = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_record"))
							.map(field -> new OwnedRecord_FieldType(field.getOwnedValue()))
							.findAny();
					this.ownedReference = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_reference"))
							.map(field -> ((InstanceReferenceValue) field.getOwnedValue()).getReferencedInstanceObject())
							.findAny();
					this.referencedBoolean = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_boolean"))
							.map(field -> ((BooleanLiteral) field.getOwnedValue()).getValue())
							.findAny();
					this.referencedString = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_string"))
							.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
							.findAny();
					this.referencedClassifier = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_classifier"))
							.map(field -> ((ClassifierValue) field.getOwnedValue()).getClassifier())
							.findAny();
					this.referencedEnumerationNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_enumeration_no_import"))
							.map(field -> EnumType1.valueOf(field.getOwnedValue()))
							.findAny();
					this.referencedEnumerationWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_enumeration_with_import"))
							.map(field -> Color.valueOf(field.getOwnedValue()))
							.findAny();
					this.referencedUnitsNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_units_no_import"))
							.map(field -> Time.valueOf(field.getOwnedValue()))
							.findAny();
					this.referencedUnitsWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_units_with_import"))
							.map(field -> Mass.valueOf(field.getOwnedValue()))
							.findAny();
					this.referencedIntegerNoUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_integer_no_units"))
							.mapToLong(field -> ((IntegerLiteral) field.getOwnedValue()).getValue())
							.findAny();
					this.referencedRealNoUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_real_no_units"))
							.mapToDouble(field -> ((RealLiteral) field.getOwnedValue()).getValue())
							.findAny();
					this.referencedNumberWithUnitsNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_number_with_units_no_import"))
							.map(field -> new IntegerWithUnits<>(field.getOwnedValue(), IntegerOwnedUnits.class))
							.findAny();
					this.referencedNumberWithUnitsWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_number_with_units_with_import"))
							.map(field -> new RealWithUnits<>(field.getOwnedValue(), Mass.class))
							.findAny();
					this.referencedRangeNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_range_no_import"))
							.map(field -> new IntegerRange(field.getOwnedValue()))
							.findAny();
					this.referencedRangeWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_range_with_import"))
							.map(field -> new RealRange(field.getOwnedValue()))
							.findAny();
					this.referencedRecordNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_record_no_import"))
							.map(field -> new RecordOfBoolean(field.getOwnedValue()))
							.findAny();
					this.referencedRecordWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_record_with_import"))
							.map(field -> new BasicRecord(field.getOwnedValue()))
							.findAny();
					this.referencedReference = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_reference"))
							.map(field -> ((InstanceReferenceValue) field.getOwnedValue()).getReferencedInstanceObject())
							.findAny();
				}
				
				public Optional<Boolean> getOwnedBoolean() {
					return ownedBoolean;
				}
				
				public Optional<String> getOwnedString() {
					return ownedString;
				}
				
				public Optional<Classifier> getOwnedClassifier() {
					return ownedClassifier;
				}
				
				public Optional<OwnedEnumeration_FieldType> getOwnedEnumeration() {
					return ownedEnumeration;
				}
				
				public Optional<OwnedUnits_FieldType> getOwnedUnits() {
					return ownedUnits;
				}
				
				public OptionalLong getOwnedIntegerNoUnits() {
					return ownedIntegerNoUnits;
				}
				
				public OptionalDouble getOwnedRealNoUnits() {
					return ownedRealNoUnits;
				}
				
				public Optional<IntegerWithUnits<Time>> getOwnedNumberWithUnitsNoImport() {
					return ownedNumberWithUnitsNoImport;
				}
				
				public Optional<IntegerWithUnits<Mass>> getOwnedNumberWithUnitsWithImport() {
					return ownedNumberWithUnitsWithImport;
				}
				
				public Optional<IntegerRangeWithUnits<Mass>> getOwnedRangeNoImport() {
					return ownedRangeNoImport;
				}
				
				public Optional<RealRangeWithUnits<Mass>> getOwnedRangeImportNumber() {
					return ownedRangeImportNumber;
				}
				
				public Optional<IntegerRangeWithUnits<Mass>> getOwnedRangeImportUnits() {
					return ownedRangeImportUnits;
				}
				
				public Optional<OwnedRecord_FieldType> getOwnedRecord() {
					return ownedRecord;
				}
				
				public Optional<InstanceObject> getOwnedReference() {
					return ownedReference;
				}
				
				public Optional<Boolean> getReferencedBoolean() {
					return referencedBoolean;
				}
				
				public Optional<String> getReferencedString() {
					return referencedString;
				}
				
				public Optional<Classifier> getReferencedClassifier() {
					return referencedClassifier;
				}
				
				public Optional<EnumType1> getReferencedEnumerationNoImport() {
					return referencedEnumerationNoImport;
				}
				
				public Optional<Color> getReferencedEnumerationWithImport() {
					return referencedEnumerationWithImport;
				}
				
				public Optional<Time> getReferencedUnitsNoImport() {
					return referencedUnitsNoImport;
				}
				
				public Optional<Mass> getReferencedUnitsWithImport() {
					return referencedUnitsWithImport;
				}
				
				public OptionalLong getReferencedIntegerNoUnits() {
					return referencedIntegerNoUnits;
				}
				
				public OptionalDouble getReferencedRealNoUnits() {
					return referencedRealNoUnits;
				}
				
				public Optional<IntegerWithUnits<IntegerOwnedUnits>> getReferencedNumberWithUnitsNoImport() {
					return referencedNumberWithUnitsNoImport;
				}
				
				public Optional<RealWithUnits<Mass>> getReferencedNumberWithUnitsWithImport() {
					return referencedNumberWithUnitsWithImport;
				}
				
				public Optional<IntegerRange> getReferencedRangeNoImport() {
					return referencedRangeNoImport;
				}
				
				public Optional<RealRange> getReferencedRangeWithImport() {
					return referencedRangeWithImport;
				}
				
				public Optional<RecordOfBoolean> getReferencedRecordNoImport() {
					return referencedRecordNoImport;
				}
				
				public Optional<BasicRecord> getReferencedRecordWithImport() {
					return referencedRecordWithImport;
				}
				
				public Optional<InstanceObject> getReferencedReference() {
					return referencedReference;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							ownedBoolean,
							ownedString,
							ownedClassifier,
							ownedEnumeration,
							ownedUnits,
							ownedIntegerNoUnits,
							ownedRealNoUnits,
							ownedNumberWithUnitsNoImport,
							ownedNumberWithUnitsWithImport,
							ownedRangeNoImport,
							ownedRangeImportNumber,
							ownedRangeImportUnits,
							ownedRecord,
							ownedReference,
							referencedBoolean,
							referencedString,
							referencedClassifier,
							referencedEnumerationNoImport,
							referencedEnumerationWithImport,
							referencedUnitsNoImport,
							referencedUnitsWithImport,
							referencedIntegerNoUnits,
							referencedRealNoUnits,
							referencedNumberWithUnitsNoImport,
							referencedNumberWithUnitsWithImport,
							referencedRangeNoImport,
							referencedRangeWithImport,
							referencedRecordNoImport,
							referencedRecordWithImport,
							referencedReference
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordType1)) {
						return false;
					}
					RecordType1 other = (RecordType1) obj;
					return Objects.equals(this.ownedBoolean, other.ownedBoolean)
							&& Objects.equals(this.ownedString, other.ownedString)
							&& Objects.equals(this.ownedClassifier, other.ownedClassifier)
							&& Objects.equals(this.ownedEnumeration, other.ownedEnumeration)
							&& Objects.equals(this.ownedUnits, other.ownedUnits)
							&& Objects.equals(this.ownedIntegerNoUnits, other.ownedIntegerNoUnits)
							&& Objects.equals(this.ownedRealNoUnits, other.ownedRealNoUnits)
							&& Objects.equals(this.ownedNumberWithUnitsNoImport, other.ownedNumberWithUnitsNoImport)
							&& Objects.equals(this.ownedNumberWithUnitsWithImport, other.ownedNumberWithUnitsWithImport)
							&& Objects.equals(this.ownedRangeNoImport, other.ownedRangeNoImport)
							&& Objects.equals(this.ownedRangeImportNumber, other.ownedRangeImportNumber)
							&& Objects.equals(this.ownedRangeImportUnits, other.ownedRangeImportUnits)
							&& Objects.equals(this.ownedRecord, other.ownedRecord)
							&& Objects.equals(this.ownedReference, other.ownedReference)
							&& Objects.equals(this.referencedBoolean, other.referencedBoolean)
							&& Objects.equals(this.referencedString, other.referencedString)
							&& Objects.equals(this.referencedClassifier, other.referencedClassifier)
							&& Objects.equals(this.referencedEnumerationNoImport, other.referencedEnumerationNoImport)
							&& Objects.equals(this.referencedEnumerationWithImport, other.referencedEnumerationWithImport)
							&& Objects.equals(this.referencedUnitsNoImport, other.referencedUnitsNoImport)
							&& Objects.equals(this.referencedUnitsWithImport, other.referencedUnitsWithImport)
							&& Objects.equals(this.referencedIntegerNoUnits, other.referencedIntegerNoUnits)
							&& Objects.equals(this.referencedRealNoUnits, other.referencedRealNoUnits)
							&& Objects.equals(this.referencedNumberWithUnitsNoImport, other.referencedNumberWithUnitsNoImport)
							&& Objects.equals(this.referencedNumberWithUnitsWithImport, other.referencedNumberWithUnitsWithImport)
							&& Objects.equals(this.referencedRangeNoImport, other.referencedRangeNoImport)
							&& Objects.equals(this.referencedRangeWithImport, other.referencedRangeWithImport)
							&& Objects.equals(this.referencedRecordNoImport, other.referencedRecordNoImport)
							&& Objects.equals(this.referencedRecordWithImport, other.referencedRecordWithImport)
							&& Objects.equals(this.referencedReference, other.referencedReference);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.ownedBoolean.ifPresent(field -> {
						builder.append("owned_boolean => ");
						builder.append(field);
						builder.append(';');
					});
					this.ownedString.ifPresent(field -> {
						builder.append("owned_string => \"");
						builder.append(field);
						builder.append("\";");
					});
					this.ownedClassifier.ifPresent(field -> {
						builder.append("owned_classifier => classifier (");
						builder.append(field.getQualifiedName());
						builder.append(");");
					});
					this.ownedEnumeration.ifPresent(field -> {
						builder.append("owned_enumeration => ");
						builder.append(field);
						builder.append(';');
					});
					this.ownedUnits.ifPresent(field -> {
						builder.append("owned_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.ownedIntegerNoUnits.ifPresent(field -> {
						builder.append("owned_integer_no_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.ownedRealNoUnits.ifPresent(field -> {
						builder.append("owned_real_no_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.ownedNumberWithUnitsNoImport.ifPresent(field -> {
						builder.append("owned_number_with_units_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					this.ownedNumberWithUnitsWithImport.ifPresent(field -> {
						builder.append("owned_number_with_units_with_import => ");
						builder.append(field);
						builder.append(';');
					});
					this.ownedRangeNoImport.ifPresent(field -> {
						builder.append("owned_range_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					this.ownedRangeImportNumber.ifPresent(field -> {
						builder.append("owned_range_import_number => ");
						builder.append(field);
						builder.append(';');
					});
					this.ownedRangeImportUnits.ifPresent(field -> {
						builder.append("owned_range_import_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.ownedRecord.ifPresent(field -> {
						builder.append("owned_record => ");
						builder.append(field);
						builder.append(';');
					});
					this.ownedReference.ifPresent(field -> {
						builder.append("owned_reference => reference (");
						builder.append(field.getName());
						builder.append(");");
					});
					this.referencedBoolean.ifPresent(field -> {
						builder.append("referenced_boolean => ");
						builder.append(field);
						builder.append(';');
					});
					this.referencedString.ifPresent(field -> {
						builder.append("referenced_string => \"");
						builder.append(field);
						builder.append("\";");
					});
					this.referencedClassifier.ifPresent(field -> {
						builder.append("referenced_classifier => classifier (");
						builder.append(field.getQualifiedName());
						builder.append(");");
					});
					this.referencedEnumerationNoImport.ifPresent(field -> {
						builder.append("referenced_enumeration_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					this.referencedEnumerationWithImport.ifPresent(field -> {
						builder.append("referenced_enumeration_with_import => ");
						builder.append(field);
						builder.append(';');
					});
					this.referencedUnitsNoImport.ifPresent(field -> {
						builder.append("referenced_units_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					this.referencedUnitsWithImport.ifPresent(field -> {
						builder.append("referenced_units_with_import => ");
						builder.append(field);
						builder.append(';');
					});
					this.referencedIntegerNoUnits.ifPresent(field -> {
						builder.append("referenced_integer_no_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.referencedRealNoUnits.ifPresent(field -> {
						builder.append("referenced_real_no_units => ");
						builder.append(field);
						builder.append(';');
					});
					this.referencedNumberWithUnitsNoImport.ifPresent(field -> {
						builder.append("referenced_number_with_units_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					this.referencedNumberWithUnitsWithImport.ifPresent(field -> {
						builder.append("referenced_number_with_units_with_import => ");
						builder.append(field);
						builder.append(';');
					});
					this.referencedRangeNoImport.ifPresent(field -> {
						builder.append("referenced_range_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					this.referencedRangeWithImport.ifPresent(field -> {
						builder.append("referenced_range_with_import => ");
						builder.append(field);
						builder.append(';');
					});
					this.referencedRecordNoImport.ifPresent(field -> {
						builder.append("referenced_record_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					this.referencedRecordWithImport.ifPresent(field -> {
						builder.append("referenced_record_with_import => ");
						builder.append(field);
						builder.append(';');
					});
					this.referencedReference.ifPresent(field -> {
						builder.append("referenced_reference => reference (");
						builder.append(field.getName());
						builder.append(");");
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum OwnedEnumeration_FieldType {
					ALLEGHENY("allegheny"),
					MONONGAHELA("monongahela"),
					OHIO("ohio");
					
					private final String originalName;
					
					private OwnedEnumeration_FieldType(String originalName) {
						this.originalName = originalName;
					}
					
					public static OwnedEnumeration_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum OwnedUnits_FieldType implements GeneratedUnits {
					INCH(1.0, "inch"),
					FOOT(12.0, "foot"),
					YARD(36.0, "yard");
					
					private final double factorToBase;
					private final String originalName;
					
					private OwnedUnits_FieldType(double factorToBase, String originalName) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
					}
					
					public static OwnedUnits_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public static class OwnedRecord_FieldType {
					private final Optional<String> stringField;
					private final OptionalLong integerField;
					
					public OwnedRecord_FieldType(PropertyExpression propertyExpression) {
						RecordValue recordValue = (RecordValue) propertyExpression;
						this.stringField = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("string_field"))
								.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
								.findAny();
						this.integerField = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("integer_field"))
								.mapToLong(field -> ((IntegerLiteral) field.getOwnedValue()).getValue())
								.findAny();
					}
					
					public Optional<String> getStringField() {
						return stringField;
					}
					
					public OptionalLong getIntegerField() {
						return integerField;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(
								stringField,
								integerField
						);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof OwnedRecord_FieldType)) {
							return false;
						}
						OwnedRecord_FieldType other = (OwnedRecord_FieldType) obj;
						return Objects.equals(this.stringField, other.stringField)
								&& Objects.equals(this.integerField, other.integerField);
					}
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder();
						builder.append('[');
						this.stringField.ifPresent(field -> {
							builder.append("string_field => \"");
							builder.append(field);
							builder.append("\";");
						});
						this.integerField.ifPresent(field -> {
							builder.append("integer_field => ");
							builder.append(field);
							builder.append(';');
						});
						builder.append(']');
						return builder.toString();
					}
				}
			}
		'''
		val recordOfBoolean = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			
			public class RecordOfBoolean {
				private final Optional<Boolean> field;
				
				public RecordOfBoolean(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> ((BooleanLiteral) field.getOwnedValue()).getValue())
							.findAny();
				}
				
				public Optional<Boolean> getField() {
					return field;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(field);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfBoolean)) {
						return false;
					}
					RecordOfBoolean other = (RecordOfBoolean) obj;
					return Objects.equals(this.field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field.ifPresent(field -> {
						builder.append("field => ");
						builder.append(field);
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val recordOfString = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.StringLiteral;
			
			public class RecordOfString {
				private final Optional<String> field;
				
				public RecordOfString(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
							.findAny();
				}
				
				public Optional<String> getField() {
					return field;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(field);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfString)) {
						return false;
					}
					RecordOfString other = (RecordOfString) obj;
					return Objects.equals(this.field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field.ifPresent(field -> {
						builder.append("field => \"");
						builder.append(field);
						builder.append("\";");
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val recordOfClassifier = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.Classifier;
			import org.osate.aadl2.ClassifierValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			
			public class RecordOfClassifier {
				private final Optional<Classifier> field;
				
				public RecordOfClassifier(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> ((ClassifierValue) field.getOwnedValue()).getClassifier())
							.findAny();
				}
				
				public Optional<Classifier> getField() {
					return field;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(field);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfClassifier)) {
						return false;
					}
					RecordOfClassifier other = (RecordOfClassifier) obj;
					return Objects.equals(this.field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field.ifPresent(field -> {
						builder.append("field => classifier (");
						builder.append(field.getQualifiedName());
						builder.append(");");
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val recordOfEnum = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			
			public class RecordOfEnum {
				private final Optional<Field_FieldType> field;
				
				public RecordOfEnum(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> Field_FieldType.valueOf(field.getOwnedValue()))
							.findAny();
				}
				
				public Optional<Field_FieldType> getField() {
					return field;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(field);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfEnum)) {
						return false;
					}
					RecordOfEnum other = (RecordOfEnum) obj;
					return Objects.equals(this.field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field.ifPresent(field -> {
						builder.append("field => ");
						builder.append(field);
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum Field_FieldType {
					A("a"),
					B("b"),
					C("c");
					
					private final String originalName;
					
					private Field_FieldType(String originalName) {
						this.originalName = originalName;
					}
					
					public static Field_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
			}
		'''
		val recordOfUnits = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public class RecordOfUnits {
				private final Optional<Field_FieldType> field;
				
				public RecordOfUnits(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> Field_FieldType.valueOf(field.getOwnedValue()))
							.findAny();
				}
				
				public Optional<Field_FieldType> getField() {
					return field;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(field);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfUnits)) {
						return false;
					}
					RecordOfUnits other = (RecordOfUnits) obj;
					return Objects.equals(this.field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field.ifPresent(field -> {
						builder.append("field => ");
						builder.append(field);
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum Field_FieldType implements GeneratedUnits {
					MM(1.0, "mm"),
					CM(10.0, "cm");
					
					private final double factorToBase;
					private final String originalName;
					
					private Field_FieldType(double factorToBase, String originalName) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
					}
					
					public static Field_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
			}
		'''
		val recordOfInteger = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.OptionalLong;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			
			public class RecordOfInteger {
				private final OptionalLong field;
				
				public RecordOfInteger(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.mapToLong(field -> ((IntegerLiteral) field.getOwnedValue()).getValue())
							.findAny();
				}
				
				public OptionalLong getField() {
					return field;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(field);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfInteger)) {
						return false;
					}
					RecordOfInteger other = (RecordOfInteger) obj;
					return Objects.equals(this.field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field.ifPresent(field -> {
						builder.append("field => ");
						builder.append(field);
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val recordOfReal = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.OptionalDouble;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			import org.osate.aadl2.RecordValue;
			
			public class RecordOfReal {
				private final OptionalDouble field;
				
				public RecordOfReal(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.mapToDouble(field -> ((RealLiteral) field.getOwnedValue()).getValue())
							.findAny();
				}
				
				public OptionalDouble getField() {
					return field;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(field);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfReal)) {
						return false;
					}
					RecordOfReal other = (RecordOfReal) obj;
					return Objects.equals(this.field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field.ifPresent(field -> {
						builder.append("field => ");
						builder.append(field);
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val recordOfReference = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
			
			public class RecordOfReference {
				private final Optional<InstanceObject> field;
				
				public RecordOfReference(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> ((InstanceReferenceValue) field.getOwnedValue()).getReferencedInstanceObject())
							.findAny();
				}
				
				public Optional<InstanceObject> getField() {
					return field;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(field);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfReference)) {
						return false;
					}
					RecordOfReference other = (RecordOfReference) obj;
					return Objects.equals(this.field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field.ifPresent(field -> {
						builder.append("field => reference (");
						builder.append(field.getName());
						builder.append(");");
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val nestedRecord = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			import java.util.OptionalLong;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			
			public class NestedRecord {
				private final Optional<Field1_FieldType> field1;
				
				public NestedRecord(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field1 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field1"))
							.map(field -> new Field1_FieldType(field.getOwnedValue()))
							.findAny();
				}
				
				public Optional<Field1_FieldType> getField1() {
					return field1;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(field1);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof NestedRecord)) {
						return false;
					}
					NestedRecord other = (NestedRecord) obj;
					return Objects.equals(this.field1, other.field1);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field1.ifPresent(field -> {
						builder.append("field1 => ");
						builder.append(field);
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public static class Field1_FieldType {
					private final Optional<Field2_FieldType> field2;
					
					public Field1_FieldType(PropertyExpression propertyExpression) {
						RecordValue recordValue = (RecordValue) propertyExpression;
						this.field2 = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("field2"))
								.map(field -> new Field2_FieldType(field.getOwnedValue()))
								.findAny();
					}
					
					public Optional<Field2_FieldType> getField2() {
						return field2;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(field2);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof Field1_FieldType)) {
							return false;
						}
						Field1_FieldType other = (Field1_FieldType) obj;
						return Objects.equals(this.field2, other.field2);
					}
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder();
						builder.append('[');
						this.field2.ifPresent(field -> {
							builder.append("field2 => ");
							builder.append(field);
							builder.append(';');
						});
						builder.append(']');
						return builder.toString();
					}
					
					public static class Field2_FieldType {
						private final Optional<Field3_FieldType> field3;
						
						public Field2_FieldType(PropertyExpression propertyExpression) {
							RecordValue recordValue = (RecordValue) propertyExpression;
							this.field3 = recordValue.getOwnedFieldValues()
									.stream()
									.filter(field -> field.getProperty().getName().equals("field3"))
									.map(field -> new Field3_FieldType(field.getOwnedValue()))
									.findAny();
						}
						
						public Optional<Field3_FieldType> getField3() {
							return field3;
						}
						
						@Override
						public int hashCode() {
							return Objects.hash(field3);
						}
						
						@Override
						public boolean equals(Object obj) {
							if (this == obj) {
								return true;
							}
							if (!(obj instanceof Field2_FieldType)) {
								return false;
							}
							Field2_FieldType other = (Field2_FieldType) obj;
							return Objects.equals(this.field3, other.field3);
						}
						
						@Override
						public String toString() {
							StringBuilder builder = new StringBuilder();
							builder.append('[');
							this.field3.ifPresent(field -> {
								builder.append("field3 => ");
								builder.append(field);
								builder.append(';');
							});
							builder.append(']');
							return builder.toString();
						}
						
						public static class Field3_FieldType {
							private final OptionalLong innerField;
							
							public Field3_FieldType(PropertyExpression propertyExpression) {
								RecordValue recordValue = (RecordValue) propertyExpression;
								this.innerField = recordValue.getOwnedFieldValues()
										.stream()
										.filter(field -> field.getProperty().getName().equals("inner_field"))
										.mapToLong(field -> ((IntegerLiteral) field.getOwnedValue()).getValue())
										.findAny();
							}
							
							public OptionalLong getInnerField() {
								return innerField;
							}
							
							@Override
							public int hashCode() {
								return Objects.hash(innerField);
							}
							
							@Override
							public boolean equals(Object obj) {
								if (this == obj) {
									return true;
								}
								if (!(obj instanceof Field3_FieldType)) {
									return false;
								}
								Field3_FieldType other = (Field3_FieldType) obj;
								return Objects.equals(this.innerField, other.innerField);
							}
							
							@Override
							public String toString() {
								StringBuilder builder = new StringBuilder();
								builder.append('[');
								this.innerField.ifPresent(field -> {
									builder.append("inner_field => ");
									builder.append(field);
									builder.append(';');
								});
								builder.append(']');
								return builder.toString();
							}
						}
					}
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(ps1, ps2))
		assertEquals(13, results.size)
		
		assertEquals("Time.java", results.get(0).fileName)
		assertEquals(time.toString, results.get(0).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.get(1).fileName)
		assertEquals(integerOwnedUnits.toString, results.get(1).contents)
		
		assertEquals("EnumType1.java", results.get(2).fileName)
		assertEquals(enumType1.toString, results.get(2).contents)
		
		assertEquals("RecordType1.java", results.get(3).fileName)
		assertEquals(recordType1.toString, results.get(3).contents)
		
		assertEquals("RecordOfBoolean.java", results.get(4).fileName)
		assertEquals(recordOfBoolean.toString, results.get(4).contents)
		
		assertEquals("RecordOfString.java", results.get(5).fileName)
		assertEquals(recordOfString.toString, results.get(5).contents)
		
		assertEquals("RecordOfClassifier.java", results.get(6).fileName)
		assertEquals(recordOfClassifier.toString, results.get(6).contents)
		
		assertEquals("RecordOfEnum.java", results.get(7).fileName)
		assertEquals(recordOfEnum.toString, results.get(7).contents)
		
		assertEquals("RecordOfUnits.java", results.get(8).fileName)
		assertEquals(recordOfUnits.toString, results.get(8).contents)
		
		assertEquals("RecordOfInteger.java", results.get(9).fileName)
		assertEquals(recordOfInteger.toString, results.get(9).contents)
		
		assertEquals("RecordOfReal.java", results.get(10).fileName)
		assertEquals(recordOfReal.toString, results.get(10).contents)
		
		assertEquals("RecordOfReference.java", results.get(11).fileName)
		assertEquals(recordOfReference.toString, results.get(11).contents)
		
		assertEquals("NestedRecord.java", results.get(12).fileName)
		assertEquals(nestedRecord.toString, results.get(12).contents)
	}
}