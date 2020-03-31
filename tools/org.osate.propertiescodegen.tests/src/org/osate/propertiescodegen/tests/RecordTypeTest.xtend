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
			
			public enum Time {
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
				
				public double getFactorToBase() {
					return factorToBase;
				}
				
				public double getFactorTo(Time target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val integerOwnedUnits = '''
			package ps1;
			
			import java.util.Objects;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			
			public class IntegerOwnedUnits {
				private final long value;
				private final Units unit;
				
				private IntegerOwnedUnits(PropertyExpression propertyExpression) {
					IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
					value = numberValue.getValue();
					unit = Units.valueOf(numberValue.getUnit().getName().toUpperCase());
				}
				
				public static IntegerOwnedUnits getValue(PropertyExpression propertyExpression) {
					return new IntegerOwnedUnits(propertyExpression);
				}
				
				public long getValue() {
					return value;
				}
				
				public Units getUnit() {
					return unit;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(value, unit);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof IntegerOwnedUnits)) {
						return false;
					}
					IntegerOwnedUnits other = (IntegerOwnedUnits) obj;
					return value == other.value && unit == other.unit;
				}
				
				@Override
				public String toString() {
					return value + unit.toString();
				}
				
				public enum Units {
					MM(1.0, "mm"),
					CM(10.0, "cm"),
					M(1000.0, "m");
					
					private final double factorToBase;
					private final String originalName;
					
					private Units(double factorToBase, String originalName) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
					}
					
					public static Units valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					public double getFactorToBase() {
						return factorToBase;
					}
					
					public double getFactorTo(Units target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
			}
		'''
		val integerReferencedUnitsOtherFile = '''
			package ps1;
			
			import java.util.Objects;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			
			import ps2.Mass;
			
			public class IntegerReferencedUnitsOtherFile {
				private final long value;
				private final Mass unit;
				
				private IntegerReferencedUnitsOtherFile(PropertyExpression propertyExpression) {
					IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
					value = numberValue.getValue();
					unit = Mass.valueOf(numberValue.getUnit().getName().toUpperCase());
				}
				
				public static IntegerReferencedUnitsOtherFile getValue(PropertyExpression propertyExpression) {
					return new IntegerReferencedUnitsOtherFile(propertyExpression);
				}
				
				public long getValue() {
					return value;
				}
				
				public Mass getUnit() {
					return unit;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(value, unit);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof IntegerReferencedUnitsOtherFile)) {
						return false;
					}
					IntegerReferencedUnitsOtherFile other = (IntegerReferencedUnitsOtherFile) obj;
					return value == other.value && unit == other.unit;
				}
				
				@Override
				public String toString() {
					return value + unit.toString();
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
		val rangeOfIntegerNoUnits = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.OptionalLong;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			
			public class RangeOfIntegerNoUnits {
				private final long minimum;
				private final long maximum;
				private final OptionalLong delta;
				
				private RangeOfIntegerNoUnits(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = ((IntegerLiteral) rangeValue.getMinimum()).getValue();
					maximum = ((IntegerLiteral) rangeValue.getMaximum()).getValue();
					if (rangeValue.getDelta() == null) {
						delta = OptionalLong.empty();
					} else {
						delta = OptionalLong.of(((IntegerLiteral) rangeValue.getDelta()).getValue());
					}
				}
				
				public static RangeOfIntegerNoUnits getValue(PropertyExpression propertyExpression) {
					return new RangeOfIntegerNoUnits(propertyExpression);
				}
				
				public long getMinimum() {
					return minimum;
				}
				
				public long getMaximum() {
					return maximum;
				}
				
				public OptionalLong getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RangeOfIntegerNoUnits)) {
						return false;
					}
					RangeOfIntegerNoUnits other = (RangeOfIntegerNoUnits) obj;
					return minimum == other.minimum && maximum == other.maximum && Objects.equals(delta, other.delta);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
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
			import org.osate.aadl2.RangeValue;
			import org.osate.aadl2.RealLiteral;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.StringLiteral;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
			
			import ps2.BasicRange;
			import ps2.BasicRecord;
			import ps2.Color;
			import ps2.Mass;
			import ps2.MassType;
			
			public class RecordType1 {
				private final Optional<Boolean> ownedBoolean;
				private final Optional<String> ownedString;
				private final Optional<Classifier> ownedClassifier;
				private final Optional<OwnedEnumerationType> ownedEnumeration;
				private final Optional<OwnedUnitsType> ownedUnits;
				private final OptionalLong ownedIntegerNoUnits;
				private final OptionalDouble ownedRealNoUnits;
				private final Optional<OwnedNumberWithUnitsNoImportType> ownedNumberWithUnitsNoImport;
				private final Optional<OwnedNumberWithUnitsWithImportType> ownedNumberWithUnitsWithImport;
				private final Optional<OwnedRangeNoImportType> ownedRangeNoImport;
				private final Optional<OwnedRangeImportNumberType> ownedRangeImportNumber;
				private final Optional<OwnedRangeImportUnitsType> ownedRangeImportUnits;
				private final Optional<OwnedRecordType> ownedRecord;
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
				private final Optional<IntegerOwnedUnits> referencedNumberWithUnitsNoImport;
				private final Optional<MassType> referencedNumberWithUnitsWithImport;
				private final Optional<RangeOfIntegerNoUnits> referencedRangeNoImport;
				private final Optional<BasicRange> referencedRangeWithImport;
				private final Optional<RecordOfBoolean> referencedRecordNoImport;
				private final Optional<BasicRecord> referencedRecordWithImport;
				private final Optional<InstanceObject> referencedReference;
				
				private RecordType1(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					ownedBoolean = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_boolean"))
							.map(field -> ((BooleanLiteral) field.getOwnedValue()).getValue())
							.findAny();
					ownedString = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_string"))
							.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
							.findAny();
					ownedClassifier = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_classifier"))
							.map(field -> ((ClassifierValue) field.getOwnedValue()).getClassifier())
							.findAny();
					ownedEnumeration = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_enumeration"))
							.map(field -> OwnedEnumerationType.valueOf(field.getOwnedValue()))
							.findAny();
					ownedUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_units"))
							.map(field -> OwnedUnitsType.valueOf(field.getOwnedValue()))
							.findAny();
					ownedIntegerNoUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_integer_no_units"))
							.mapToLong(field -> ((IntegerLiteral) field.getOwnedValue()).getValue())
							.findAny();
					ownedRealNoUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_real_no_units"))
							.mapToDouble(field -> ((RealLiteral) field.getOwnedValue()).getValue())
							.findAny();
					ownedNumberWithUnitsNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_number_with_units_no_import"))
							.map(field -> new OwnedNumberWithUnitsNoImportType(field.getOwnedValue()))
							.findAny();
					ownedNumberWithUnitsWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_number_with_units_with_import"))
							.map(field -> new OwnedNumberWithUnitsWithImportType(field.getOwnedValue()))
							.findAny();
					ownedRangeNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_range_no_import"))
							.map(field -> new OwnedRangeNoImportType(field.getOwnedValue()))
							.findAny();
					ownedRangeImportNumber = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_range_import_number"))
							.map(field -> new OwnedRangeImportNumberType(field.getOwnedValue()))
							.findAny();
					ownedRangeImportUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_range_import_units"))
							.map(field -> new OwnedRangeImportUnitsType(field.getOwnedValue()))
							.findAny();
					ownedRecord = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_record"))
							.map(field -> new OwnedRecordType(field.getOwnedValue()))
							.findAny();
					ownedReference = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_reference"))
							.map(field -> ((InstanceReferenceValue) field.getOwnedValue()).getReferencedInstanceObject())
							.findAny();
					referencedBoolean = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_boolean"))
							.map(field -> ((BooleanLiteral) field.getOwnedValue()).getValue())
							.findAny();
					referencedString = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_string"))
							.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
							.findAny();
					referencedClassifier = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_classifier"))
							.map(field -> ((ClassifierValue) field.getOwnedValue()).getClassifier())
							.findAny();
					referencedEnumerationNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_enumeration_no_import"))
							.map(field -> EnumType1.valueOf(field.getOwnedValue()))
							.findAny();
					referencedEnumerationWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_enumeration_with_import"))
							.map(field -> Color.valueOf(field.getOwnedValue()))
							.findAny();
					referencedUnitsNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_units_no_import"))
							.map(field -> Time.valueOf(field.getOwnedValue()))
							.findAny();
					referencedUnitsWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_units_with_import"))
							.map(field -> Mass.valueOf(field.getOwnedValue()))
							.findAny();
					referencedIntegerNoUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_integer_no_units"))
							.mapToLong(field -> ((IntegerLiteral) field.getOwnedValue()).getValue())
							.findAny();
					referencedRealNoUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_real_no_units"))
							.mapToDouble(field -> ((RealLiteral) field.getOwnedValue()).getValue())
							.findAny();
					referencedNumberWithUnitsNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_number_with_units_no_import"))
							.map(field -> IntegerOwnedUnits.getValue(field.getOwnedValue()))
							.findAny();
					referencedNumberWithUnitsWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_number_with_units_with_import"))
							.map(field -> MassType.getValue(field.getOwnedValue()))
							.findAny();
					referencedRangeNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_range_no_import"))
							.map(field -> RangeOfIntegerNoUnits.getValue(field.getOwnedValue()))
							.findAny();
					referencedRangeWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_range_with_import"))
							.map(field -> BasicRange.getValue(field.getOwnedValue()))
							.findAny();
					referencedRecordNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_record_no_import"))
							.map(field -> RecordOfBoolean.getValue(field.getOwnedValue()))
							.findAny();
					referencedRecordWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_record_with_import"))
							.map(field -> BasicRecord.getValue(field.getOwnedValue()))
							.findAny();
					referencedReference = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("referenced_reference"))
							.map(field -> ((InstanceReferenceValue) field.getOwnedValue()).getReferencedInstanceObject())
							.findAny();
				}
				
				public static RecordType1 getValue(PropertyExpression propertyExpression) {
					return new RecordType1(propertyExpression);
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
				
				public Optional<OwnedEnumerationType> getOwnedEnumeration() {
					return ownedEnumeration;
				}
				
				public Optional<OwnedUnitsType> getOwnedUnits() {
					return ownedUnits;
				}
				
				public OptionalLong getOwnedIntegerNoUnits() {
					return ownedIntegerNoUnits;
				}
				
				public OptionalDouble getOwnedRealNoUnits() {
					return ownedRealNoUnits;
				}
				
				public Optional<OwnedNumberWithUnitsNoImportType> getOwnedNumberWithUnitsNoImport() {
					return ownedNumberWithUnitsNoImport;
				}
				
				public Optional<OwnedNumberWithUnitsWithImportType> getOwnedNumberWithUnitsWithImport() {
					return ownedNumberWithUnitsWithImport;
				}
				
				public Optional<OwnedRangeNoImportType> getOwnedRangeNoImport() {
					return ownedRangeNoImport;
				}
				
				public Optional<OwnedRangeImportNumberType> getOwnedRangeImportNumber() {
					return ownedRangeImportNumber;
				}
				
				public Optional<OwnedRangeImportUnitsType> getOwnedRangeImportUnits() {
					return ownedRangeImportUnits;
				}
				
				public Optional<OwnedRecordType> getOwnedRecord() {
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
				
				public Optional<IntegerOwnedUnits> getReferencedNumberWithUnitsNoImport() {
					return referencedNumberWithUnitsNoImport;
				}
				
				public Optional<MassType> getReferencedNumberWithUnitsWithImport() {
					return referencedNumberWithUnitsWithImport;
				}
				
				public Optional<RangeOfIntegerNoUnits> getReferencedRangeNoImport() {
					return referencedRangeNoImport;
				}
				
				public Optional<BasicRange> getReferencedRangeWithImport() {
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
					return Objects.equals(ownedBoolean, other.ownedBoolean)
							&& Objects.equals(ownedString, other.ownedString)
							&& Objects.equals(ownedClassifier, other.ownedClassifier)
							&& Objects.equals(ownedEnumeration, other.ownedEnumeration)
							&& Objects.equals(ownedUnits, other.ownedUnits)
							&& Objects.equals(ownedIntegerNoUnits, other.ownedIntegerNoUnits)
							&& Objects.equals(ownedRealNoUnits, other.ownedRealNoUnits)
							&& Objects.equals(ownedNumberWithUnitsNoImport, other.ownedNumberWithUnitsNoImport)
							&& Objects.equals(ownedNumberWithUnitsWithImport, other.ownedNumberWithUnitsWithImport)
							&& Objects.equals(ownedRangeNoImport, other.ownedRangeNoImport)
							&& Objects.equals(ownedRangeImportNumber, other.ownedRangeImportNumber)
							&& Objects.equals(ownedRangeImportUnits, other.ownedRangeImportUnits)
							&& Objects.equals(ownedRecord, other.ownedRecord)
							&& Objects.equals(ownedReference, other.ownedReference)
							&& Objects.equals(referencedBoolean, other.referencedBoolean)
							&& Objects.equals(referencedString, other.referencedString)
							&& Objects.equals(referencedClassifier, other.referencedClassifier)
							&& Objects.equals(referencedEnumerationNoImport, other.referencedEnumerationNoImport)
							&& Objects.equals(referencedEnumerationWithImport, other.referencedEnumerationWithImport)
							&& Objects.equals(referencedUnitsNoImport, other.referencedUnitsNoImport)
							&& Objects.equals(referencedUnitsWithImport, other.referencedUnitsWithImport)
							&& Objects.equals(referencedIntegerNoUnits, other.referencedIntegerNoUnits)
							&& Objects.equals(referencedRealNoUnits, other.referencedRealNoUnits)
							&& Objects.equals(referencedNumberWithUnitsNoImport, other.referencedNumberWithUnitsNoImport)
							&& Objects.equals(referencedNumberWithUnitsWithImport, other.referencedNumberWithUnitsWithImport)
							&& Objects.equals(referencedRangeNoImport, other.referencedRangeNoImport)
							&& Objects.equals(referencedRangeWithImport, other.referencedRangeWithImport)
							&& Objects.equals(referencedRecordNoImport, other.referencedRecordNoImport)
							&& Objects.equals(referencedRecordWithImport, other.referencedRecordWithImport)
							&& Objects.equals(referencedReference, other.referencedReference);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					ownedBoolean.ifPresent(field -> {
						builder.append("owned_boolean => ");
						builder.append(field);
						builder.append(';');
					});
					ownedString.ifPresent(field -> {
						builder.append("owned_string => \"");
						builder.append(field);
						builder.append("\";");
					});
					ownedClassifier.ifPresent(field -> {
						builder.append("owned_classifier => classifier (");
						builder.append(field.getQualifiedName());
						builder.append(");");
					});
					ownedEnumeration.ifPresent(field -> {
						builder.append("owned_enumeration => ");
						builder.append(field);
						builder.append(';');
					});
					ownedUnits.ifPresent(field -> {
						builder.append("owned_units => ");
						builder.append(field);
						builder.append(';');
					});
					ownedIntegerNoUnits.ifPresent(field -> {
						builder.append("owned_integer_no_units => ");
						builder.append(field);
						builder.append(';');
					});
					ownedRealNoUnits.ifPresent(field -> {
						builder.append("owned_real_no_units => ");
						builder.append(field);
						builder.append(';');
					});
					ownedNumberWithUnitsNoImport.ifPresent(field -> {
						builder.append("owned_number_with_units_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					ownedNumberWithUnitsWithImport.ifPresent(field -> {
						builder.append("owned_number_with_units_with_import => ");
						builder.append(field);
						builder.append(';');
					});
					ownedRangeNoImport.ifPresent(field -> {
						builder.append("owned_range_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					ownedRangeImportNumber.ifPresent(field -> {
						builder.append("owned_range_import_number => ");
						builder.append(field);
						builder.append(';');
					});
					ownedRangeImportUnits.ifPresent(field -> {
						builder.append("owned_range_import_units => ");
						builder.append(field);
						builder.append(';');
					});
					ownedRecord.ifPresent(field -> {
						builder.append("owned_record => ");
						builder.append(field);
						builder.append(';');
					});
					ownedReference.ifPresent(field -> {
						builder.append("owned_reference => reference (");
						builder.append(field.getName());
						builder.append(");");
					});
					referencedBoolean.ifPresent(field -> {
						builder.append("referenced_boolean => ");
						builder.append(field);
						builder.append(';');
					});
					referencedString.ifPresent(field -> {
						builder.append("referenced_string => \"");
						builder.append(field);
						builder.append("\";");
					});
					referencedClassifier.ifPresent(field -> {
						builder.append("referenced_classifier => classifier (");
						builder.append(field.getQualifiedName());
						builder.append(");");
					});
					referencedEnumerationNoImport.ifPresent(field -> {
						builder.append("referenced_enumeration_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					referencedEnumerationWithImport.ifPresent(field -> {
						builder.append("referenced_enumeration_with_import => ");
						builder.append(field);
						builder.append(';');
					});
					referencedUnitsNoImport.ifPresent(field -> {
						builder.append("referenced_units_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					referencedUnitsWithImport.ifPresent(field -> {
						builder.append("referenced_units_with_import => ");
						builder.append(field);
						builder.append(';');
					});
					referencedIntegerNoUnits.ifPresent(field -> {
						builder.append("referenced_integer_no_units => ");
						builder.append(field);
						builder.append(';');
					});
					referencedRealNoUnits.ifPresent(field -> {
						builder.append("referenced_real_no_units => ");
						builder.append(field);
						builder.append(';');
					});
					referencedNumberWithUnitsNoImport.ifPresent(field -> {
						builder.append("referenced_number_with_units_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					referencedNumberWithUnitsWithImport.ifPresent(field -> {
						builder.append("referenced_number_with_units_with_import => ");
						builder.append(field);
						builder.append(';');
					});
					referencedRangeNoImport.ifPresent(field -> {
						builder.append("referenced_range_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					referencedRangeWithImport.ifPresent(field -> {
						builder.append("referenced_range_with_import => ");
						builder.append(field);
						builder.append(';');
					});
					referencedRecordNoImport.ifPresent(field -> {
						builder.append("referenced_record_no_import => ");
						builder.append(field);
						builder.append(';');
					});
					referencedRecordWithImport.ifPresent(field -> {
						builder.append("referenced_record_with_import => ");
						builder.append(field);
						builder.append(';');
					});
					referencedReference.ifPresent(field -> {
						builder.append("referenced_reference => reference (");
						builder.append(field.getName());
						builder.append(");");
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum OwnedEnumerationType {
					ALLEGHENY("allegheny"),
					MONONGAHELA("monongahela"),
					OHIO("ohio");
					
					private final String originalName;
					
					private OwnedEnumerationType(String originalName) {
						this.originalName = originalName;
					}
					
					public static OwnedEnumerationType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum OwnedUnitsType {
					INCH(1.0, "inch"),
					FOOT(12.0, "foot"),
					YARD(36.0, "yard");
					
					private final double factorToBase;
					private final String originalName;
					
					private OwnedUnitsType(double factorToBase, String originalName) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
					}
					
					public static OwnedUnitsType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					public double getFactorToBase() {
						return factorToBase;
					}
					
					public double getFactorTo(OwnedUnitsType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public static class OwnedNumberWithUnitsNoImportType {
					private final long value;
					private final Time unit;
					
					private OwnedNumberWithUnitsNoImportType(PropertyExpression propertyExpression) {
						IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
						value = numberValue.getValue();
						unit = Time.valueOf(numberValue.getUnit().getName().toUpperCase());
					}
					
					public long getValue() {
						return value;
					}
					
					public Time getUnit() {
						return unit;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(value, unit);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof OwnedNumberWithUnitsNoImportType)) {
							return false;
						}
						OwnedNumberWithUnitsNoImportType other = (OwnedNumberWithUnitsNoImportType) obj;
						return value == other.value && unit == other.unit;
					}
					
					@Override
					public String toString() {
						return value + unit.toString();
					}
				}
				
				public static class OwnedNumberWithUnitsWithImportType {
					private final long value;
					private final Mass unit;
					
					private OwnedNumberWithUnitsWithImportType(PropertyExpression propertyExpression) {
						IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
						value = numberValue.getValue();
						unit = Mass.valueOf(numberValue.getUnit().getName().toUpperCase());
					}
					
					public long getValue() {
						return value;
					}
					
					public Mass getUnit() {
						return unit;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(value, unit);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof OwnedNumberWithUnitsWithImportType)) {
							return false;
						}
						OwnedNumberWithUnitsWithImportType other = (OwnedNumberWithUnitsWithImportType) obj;
						return value == other.value && unit == other.unit;
					}
					
					@Override
					public String toString() {
						return value + unit.toString();
					}
				}
				
				public static class OwnedRangeNoImportType {
					private final IntegerReferencedUnitsOtherFile minimum;
					private final IntegerReferencedUnitsOtherFile maximum;
					private final Optional<IntegerReferencedUnitsOtherFile> delta;
					
					private OwnedRangeNoImportType(PropertyExpression propertyExpression) {
						RangeValue rangeValue = (RangeValue) propertyExpression;
						minimum = IntegerReferencedUnitsOtherFile.getValue(rangeValue.getMinimum());
						maximum = IntegerReferencedUnitsOtherFile.getValue(rangeValue.getMaximum());
						delta = Optional.ofNullable(rangeValue.getDelta()).map(IntegerReferencedUnitsOtherFile::getValue);
					}
					
					public IntegerReferencedUnitsOtherFile getMinimum() {
						return minimum;
					}
					
					public IntegerReferencedUnitsOtherFile getMaximum() {
						return maximum;
					}
					
					public Optional<IntegerReferencedUnitsOtherFile> getDelta() {
						return delta;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(minimum, maximum, delta);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof OwnedRangeNoImportType)) {
							return false;
						}
						OwnedRangeNoImportType other = (OwnedRangeNoImportType) obj;
						return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
								&& Objects.equals(delta, other.delta);
					}
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
						delta.ifPresent(it -> builder.append(" delta " + it));
						return builder.toString();
					}
				}
				
				public static class OwnedRangeImportNumberType {
					private final MassType minimum;
					private final MassType maximum;
					private final Optional<MassType> delta;
					
					private OwnedRangeImportNumberType(PropertyExpression propertyExpression) {
						RangeValue rangeValue = (RangeValue) propertyExpression;
						minimum = MassType.getValue(rangeValue.getMinimum());
						maximum = MassType.getValue(rangeValue.getMaximum());
						delta = Optional.ofNullable(rangeValue.getDelta()).map(MassType::getValue);
					}
					
					public MassType getMinimum() {
						return minimum;
					}
					
					public MassType getMaximum() {
						return maximum;
					}
					
					public Optional<MassType> getDelta() {
						return delta;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(minimum, maximum, delta);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof OwnedRangeImportNumberType)) {
							return false;
						}
						OwnedRangeImportNumberType other = (OwnedRangeImportNumberType) obj;
						return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
								&& Objects.equals(delta, other.delta);
					}
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
						delta.ifPresent(it -> builder.append(" delta " + it));
						return builder.toString();
					}
				}
				
				public static class OwnedRangeImportUnitsType {
					private final Number minimum;
					private final Number maximum;
					private final Optional<Number> delta;
					
					private OwnedRangeImportUnitsType(PropertyExpression propertyExpression) {
						RangeValue rangeValue = (RangeValue) propertyExpression;
						minimum = new Number(rangeValue.getMinimum());
						maximum = new Number(rangeValue.getMaximum());
						delta = Optional.ofNullable(rangeValue.getDelta()).map(Number::new);
					}
					
					public Number getMinimum() {
						return minimum;
					}
					
					public Number getMaximum() {
						return maximum;
					}
					
					public Optional<Number> getDelta() {
						return delta;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(minimum, maximum, delta);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof OwnedRangeImportUnitsType)) {
							return false;
						}
						OwnedRangeImportUnitsType other = (OwnedRangeImportUnitsType) obj;
						return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
								&& Objects.equals(delta, other.delta);
					}
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
						delta.ifPresent(it -> builder.append(" delta " + it));
						return builder.toString();
					}
					
					public static class Number {
						private final long value;
						private final Mass unit;
						
						private Number(PropertyExpression propertyExpression) {
							IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
							value = numberValue.getValue();
							unit = Mass.valueOf(numberValue.getUnit().getName().toUpperCase());
						}
						
						public long getValue() {
							return value;
						}
						
						public Mass getUnit() {
							return unit;
						}
						
						@Override
						public int hashCode() {
							return Objects.hash(value, unit);
						}
						
						@Override
						public boolean equals(Object obj) {
							if (this == obj) {
								return true;
							}
							if (!(obj instanceof Number)) {
								return false;
							}
							Number other = (Number) obj;
							return value == other.value && unit == other.unit;
						}
						
						@Override
						public String toString() {
							return value + unit.toString();
						}
					}
				}
				
				public static class OwnedRecordType {
					private final Optional<String> stringField;
					private final OptionalLong integerField;
					
					private OwnedRecordType(PropertyExpression propertyExpression) {
						RecordValue recordValue = (RecordValue) propertyExpression;
						stringField = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("string_field"))
								.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
								.findAny();
						integerField = recordValue.getOwnedFieldValues()
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
						if (!(obj instanceof OwnedRecordType)) {
							return false;
						}
						OwnedRecordType other = (OwnedRecordType) obj;
						return Objects.equals(stringField, other.stringField)
								&& Objects.equals(integerField, other.integerField);
					}
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder();
						builder.append('[');
						stringField.ifPresent(field -> {
							builder.append("string_field => \"");
							builder.append(field);
							builder.append("\";");
						});
						integerField.ifPresent(field -> {
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
				
				private RecordOfBoolean(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> ((BooleanLiteral) field.getOwnedValue()).getValue())
							.findAny();
				}
				
				public static RecordOfBoolean getValue(PropertyExpression propertyExpression) {
					return new RecordOfBoolean(propertyExpression);
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
					return Objects.equals(field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field.ifPresent(field -> {
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
				
				private RecordOfString(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
							.findAny();
				}
				
				public static RecordOfString getValue(PropertyExpression propertyExpression) {
					return new RecordOfString(propertyExpression);
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
					return Objects.equals(field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field.ifPresent(field -> {
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
				
				private RecordOfClassifier(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> ((ClassifierValue) field.getOwnedValue()).getClassifier())
							.findAny();
				}
				
				public static RecordOfClassifier getValue(PropertyExpression propertyExpression) {
					return new RecordOfClassifier(propertyExpression);
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
					return Objects.equals(field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field.ifPresent(field -> {
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
				private final Optional<FieldType> field;
				
				private RecordOfEnum(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> FieldType.valueOf(field.getOwnedValue()))
							.findAny();
				}
				
				public static RecordOfEnum getValue(PropertyExpression propertyExpression) {
					return new RecordOfEnum(propertyExpression);
				}
				
				public Optional<FieldType> getField() {
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
					return Objects.equals(field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field.ifPresent(field -> {
						builder.append("field => ");
						builder.append(field);
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum FieldType {
					A("a"),
					B("b"),
					C("c");
					
					private final String originalName;
					
					private FieldType(String originalName) {
						this.originalName = originalName;
					}
					
					public static FieldType valueOf(PropertyExpression propertyExpression) {
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
			
			public class RecordOfUnits {
				private final Optional<FieldType> field;
				
				private RecordOfUnits(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> FieldType.valueOf(field.getOwnedValue()))
							.findAny();
				}
				
				public static RecordOfUnits getValue(PropertyExpression propertyExpression) {
					return new RecordOfUnits(propertyExpression);
				}
				
				public Optional<FieldType> getField() {
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
					return Objects.equals(field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field.ifPresent(field -> {
						builder.append("field => ");
						builder.append(field);
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum FieldType {
					MM(1.0, "mm"),
					CM(10.0, "cm");
					
					private final double factorToBase;
					private final String originalName;
					
					private FieldType(double factorToBase, String originalName) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
					}
					
					public static FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					public double getFactorToBase() {
						return factorToBase;
					}
					
					public double getFactorTo(FieldType target) {
						return factorToBase / target.factorToBase;
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
				
				private RecordOfInteger(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.mapToLong(field -> ((IntegerLiteral) field.getOwnedValue()).getValue())
							.findAny();
				}
				
				public static RecordOfInteger getValue(PropertyExpression propertyExpression) {
					return new RecordOfInteger(propertyExpression);
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
					return Objects.equals(field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field.ifPresent(field -> {
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
				
				private RecordOfReal(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.mapToDouble(field -> ((RealLiteral) field.getOwnedValue()).getValue())
							.findAny();
				}
				
				public static RecordOfReal getValue(PropertyExpression propertyExpression) {
					return new RecordOfReal(propertyExpression);
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
					return Objects.equals(field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field.ifPresent(field -> {
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
				
				private RecordOfReference(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> ((InstanceReferenceValue) field.getOwnedValue()).getReferencedInstanceObject())
							.findAny();
				}
				
				public static RecordOfReference getValue(PropertyExpression propertyExpression) {
					return new RecordOfReference(propertyExpression);
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
					return Objects.equals(field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field.ifPresent(field -> {
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
				private final Optional<Field1Type> field1;
				
				private NestedRecord(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field1 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field1"))
							.map(field -> new Field1Type(field.getOwnedValue()))
							.findAny();
				}
				
				public static NestedRecord getValue(PropertyExpression propertyExpression) {
					return new NestedRecord(propertyExpression);
				}
				
				public Optional<Field1Type> getField1() {
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
					return Objects.equals(field1, other.field1);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field1.ifPresent(field -> {
						builder.append("field1 => ");
						builder.append(field);
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public static class Field1Type {
					private final Optional<Field2Type> field2;
					
					private Field1Type(PropertyExpression propertyExpression) {
						RecordValue recordValue = (RecordValue) propertyExpression;
						field2 = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("field2"))
								.map(field -> new Field2Type(field.getOwnedValue()))
								.findAny();
					}
					
					public Optional<Field2Type> getField2() {
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
						if (!(obj instanceof Field1Type)) {
							return false;
						}
						Field1Type other = (Field1Type) obj;
						return Objects.equals(field2, other.field2);
					}
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder();
						builder.append('[');
						field2.ifPresent(field -> {
							builder.append("field2 => ");
							builder.append(field);
							builder.append(';');
						});
						builder.append(']');
						return builder.toString();
					}
					
					public static class Field2Type {
						private final Optional<Field3Type> field3;
						
						private Field2Type(PropertyExpression propertyExpression) {
							RecordValue recordValue = (RecordValue) propertyExpression;
							field3 = recordValue.getOwnedFieldValues()
									.stream()
									.filter(field -> field.getProperty().getName().equals("field3"))
									.map(field -> new Field3Type(field.getOwnedValue()))
									.findAny();
						}
						
						public Optional<Field3Type> getField3() {
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
							if (!(obj instanceof Field2Type)) {
								return false;
							}
							Field2Type other = (Field2Type) obj;
							return Objects.equals(field3, other.field3);
						}
						
						@Override
						public String toString() {
							StringBuilder builder = new StringBuilder();
							builder.append('[');
							field3.ifPresent(field -> {
								builder.append("field3 => ");
								builder.append(field);
								builder.append(';');
							});
							builder.append(']');
							return builder.toString();
						}
						
						public static class Field3Type {
							private final OptionalLong innerField;
							
							private Field3Type(PropertyExpression propertyExpression) {
								RecordValue recordValue = (RecordValue) propertyExpression;
								innerField = recordValue.getOwnedFieldValues()
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
								if (!(obj instanceof Field3Type)) {
									return false;
								}
								Field3Type other = (Field3Type) obj;
								return Objects.equals(innerField, other.innerField);
							}
							
							@Override
							public String toString() {
								StringBuilder builder = new StringBuilder();
								builder.append('[');
								innerField.ifPresent(field -> {
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
		assertEquals(15, results.size)
		
		assertEquals("Time.java", results.get(0).fileName)
		assertEquals(time.toString, results.get(0).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.get(1).fileName)
		assertEquals(integerOwnedUnits.toString, results.get(1).contents)
		
		assertEquals("IntegerReferencedUnitsOtherFile.java", results.get(2).fileName)
		assertEquals(integerReferencedUnitsOtherFile.toString, results.get(2).contents)
		
		assertEquals("EnumType1.java", results.get(3).fileName)
		assertEquals(enumType1.toString, results.get(3).contents)
		
		assertEquals("RangeOfIntegerNoUnits.java", results.get(4).fileName)
		assertEquals(rangeOfIntegerNoUnits.toString, results.get(4).contents)
		
		assertEquals("RecordType1.java", results.get(5).fileName)
		assertEquals(recordType1.toString, results.get(5).contents)
		
		assertEquals("RecordOfBoolean.java", results.get(6).fileName)
		assertEquals(recordOfBoolean.toString, results.get(6).contents)
		
		assertEquals("RecordOfString.java", results.get(7).fileName)
		assertEquals(recordOfString.toString, results.get(7).contents)
		
		assertEquals("RecordOfClassifier.java", results.get(8).fileName)
		assertEquals(recordOfClassifier.toString, results.get(8).contents)
		
		assertEquals("RecordOfEnum.java", results.get(9).fileName)
		assertEquals(recordOfEnum.toString, results.get(9).contents)
		
		assertEquals("RecordOfUnits.java", results.get(10).fileName)
		assertEquals(recordOfUnits.toString, results.get(10).contents)
		
		assertEquals("RecordOfInteger.java", results.get(11).fileName)
		assertEquals(recordOfInteger.toString, results.get(11).contents)
		
		assertEquals("RecordOfReal.java", results.get(12).fileName)
		assertEquals(recordOfReal.toString, results.get(12).contents)
		
		assertEquals("RecordOfReference.java", results.get(13).fileName)
		assertEquals(recordOfReference.toString, results.get(13).contents)
		
		assertEquals("NestedRecord.java", results.get(14).fileName)
		assertEquals(nestedRecord.toString, results.get(14).contents)
	}
}