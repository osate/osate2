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
				
				public double getFactorTo(IntegerOwnedUnits target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val enumType1 = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			
			public enum EnumType1 {
				ONE("one", "__synthetic1.aadl#/0/@ownedPropertyType.6/@ownedLiteral.0"),
				TWO("two", "__synthetic1.aadl#/0/@ownedPropertyType.6/@ownedLiteral.1"),
				THREE("three", "__synthetic1.aadl#/0/@ownedPropertyType.6/@ownedLiteral.2");
				
				private final String originalName;
				private final URI uri;
				
				private EnumType1(String originalName, String uri) {
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static EnumType1 valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				public EnumerationLiteral toEnumerationLiteral(ResourceSet resourceSet) {
					EnumerationLiteral literal = (EnumerationLiteral) resourceSet.getEObject(uri, true);
					if (literal == null) {
						throw new RuntimeException("Could not resolve EnumerationLiteral '" + originalName + "'.");
					}
					return literal;
				}
				
				public NamedValue toPropertyExpression(ResourceSet resourceSet) {
					NamedValue value = Aadl2Factory.eINSTANCE.createNamedValue();
					value.setNamedValue(toEnumerationLiteral(resourceSet));
					return value;
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
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.AbstractNamedValue;
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
				
				public RecordType1(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<Boolean> ownedBoolean_local;
					try {
						ownedBoolean_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_boolean"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((BooleanLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedBoolean_local = Optional.empty();
					}
					this.ownedBoolean = ownedBoolean_local;
					
					Optional<String> ownedString_local;
					try {
						ownedString_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_string"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((StringLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedString_local = Optional.empty();
					}
					this.ownedString = ownedString_local;
					
					Optional<Classifier> ownedClassifier_local;
					try {
						ownedClassifier_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_classifier"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ClassifierValue) resolved).getClassifier();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedClassifier_local = Optional.empty();
					}
					this.ownedClassifier = ownedClassifier_local;
					
					Optional<OwnedEnumeration_FieldType> ownedEnumeration_local;
					try {
						ownedEnumeration_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_enumeration"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return OwnedEnumeration_FieldType.valueOf(resolved);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedEnumeration_local = Optional.empty();
					}
					this.ownedEnumeration = ownedEnumeration_local;
					
					Optional<OwnedUnits_FieldType> ownedUnits_local;
					try {
						ownedUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return OwnedUnits_FieldType.valueOf(resolved);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedUnits_local = Optional.empty();
					}
					this.ownedUnits = ownedUnits_local;
					
					OptionalLong ownedIntegerNoUnits_local;
					try {
						ownedIntegerNoUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_integer_no_units"))
								.mapToLong(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((IntegerLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedIntegerNoUnits_local = OptionalLong.empty();
					}
					this.ownedIntegerNoUnits = ownedIntegerNoUnits_local;
					
					OptionalDouble ownedRealNoUnits_local;
					try {
						ownedRealNoUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_real_no_units"))
								.mapToDouble(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((RealLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedRealNoUnits_local = OptionalDouble.empty();
					}
					this.ownedRealNoUnits = ownedRealNoUnits_local;
					
					Optional<IntegerWithUnits<Time>> ownedNumberWithUnitsNoImport_local;
					try {
						ownedNumberWithUnitsNoImport_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_number_with_units_no_import"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new IntegerWithUnits<>(resolved, Time.class);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedNumberWithUnitsNoImport_local = Optional.empty();
					}
					this.ownedNumberWithUnitsNoImport = ownedNumberWithUnitsNoImport_local;
					
					Optional<IntegerWithUnits<Mass>> ownedNumberWithUnitsWithImport_local;
					try {
						ownedNumberWithUnitsWithImport_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_number_with_units_with_import"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new IntegerWithUnits<>(resolved, Mass.class);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedNumberWithUnitsWithImport_local = Optional.empty();
					}
					this.ownedNumberWithUnitsWithImport = ownedNumberWithUnitsWithImport_local;
					
					Optional<IntegerRangeWithUnits<Mass>> ownedRangeNoImport_local;
					try {
						ownedRangeNoImport_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_range_no_import"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new IntegerRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedRangeNoImport_local = Optional.empty();
					}
					this.ownedRangeNoImport = ownedRangeNoImport_local;
					
					Optional<RealRangeWithUnits<Mass>> ownedRangeImportNumber_local;
					try {
						ownedRangeImportNumber_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_range_import_number"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new RealRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedRangeImportNumber_local = Optional.empty();
					}
					this.ownedRangeImportNumber = ownedRangeImportNumber_local;
					
					Optional<IntegerRangeWithUnits<Mass>> ownedRangeImportUnits_local;
					try {
						ownedRangeImportUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_range_import_units"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new IntegerRangeWithUnits<>(resolved, Mass.class, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedRangeImportUnits_local = Optional.empty();
					}
					this.ownedRangeImportUnits = ownedRangeImportUnits_local;
					
					Optional<OwnedRecord_FieldType> ownedRecord_local;
					try {
						ownedRecord_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_record"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new OwnedRecord_FieldType(resolved, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedRecord_local = Optional.empty();
					}
					this.ownedRecord = ownedRecord_local;
					
					Optional<InstanceObject> ownedReference_local;
					try {
						ownedReference_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned_reference"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						ownedReference_local = Optional.empty();
					}
					this.ownedReference = ownedReference_local;
					
					Optional<Boolean> referencedBoolean_local;
					try {
						referencedBoolean_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_boolean"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((BooleanLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedBoolean_local = Optional.empty();
					}
					this.referencedBoolean = referencedBoolean_local;
					
					Optional<String> referencedString_local;
					try {
						referencedString_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_string"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((StringLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedString_local = Optional.empty();
					}
					this.referencedString = referencedString_local;
					
					Optional<Classifier> referencedClassifier_local;
					try {
						referencedClassifier_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_classifier"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ClassifierValue) resolved).getClassifier();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedClassifier_local = Optional.empty();
					}
					this.referencedClassifier = referencedClassifier_local;
					
					Optional<EnumType1> referencedEnumerationNoImport_local;
					try {
						referencedEnumerationNoImport_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_enumeration_no_import"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return EnumType1.valueOf(resolved);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedEnumerationNoImport_local = Optional.empty();
					}
					this.referencedEnumerationNoImport = referencedEnumerationNoImport_local;
					
					Optional<Color> referencedEnumerationWithImport_local;
					try {
						referencedEnumerationWithImport_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_enumeration_with_import"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return Color.valueOf(resolved);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedEnumerationWithImport_local = Optional.empty();
					}
					this.referencedEnumerationWithImport = referencedEnumerationWithImport_local;
					
					Optional<Time> referencedUnitsNoImport_local;
					try {
						referencedUnitsNoImport_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_units_no_import"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return Time.valueOf(resolved);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedUnitsNoImport_local = Optional.empty();
					}
					this.referencedUnitsNoImport = referencedUnitsNoImport_local;
					
					Optional<Mass> referencedUnitsWithImport_local;
					try {
						referencedUnitsWithImport_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_units_with_import"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return Mass.valueOf(resolved);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedUnitsWithImport_local = Optional.empty();
					}
					this.referencedUnitsWithImport = referencedUnitsWithImport_local;
					
					OptionalLong referencedIntegerNoUnits_local;
					try {
						referencedIntegerNoUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_integer_no_units"))
								.mapToLong(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((IntegerLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedIntegerNoUnits_local = OptionalLong.empty();
					}
					this.referencedIntegerNoUnits = referencedIntegerNoUnits_local;
					
					OptionalDouble referencedRealNoUnits_local;
					try {
						referencedRealNoUnits_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_real_no_units"))
								.mapToDouble(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((RealLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedRealNoUnits_local = OptionalDouble.empty();
					}
					this.referencedRealNoUnits = referencedRealNoUnits_local;
					
					Optional<IntegerWithUnits<IntegerOwnedUnits>> referencedNumberWithUnitsNoImport_local;
					try {
						referencedNumberWithUnitsNoImport_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_number_with_units_no_import"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new IntegerWithUnits<>(resolved, IntegerOwnedUnits.class);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedNumberWithUnitsNoImport_local = Optional.empty();
					}
					this.referencedNumberWithUnitsNoImport = referencedNumberWithUnitsNoImport_local;
					
					Optional<RealWithUnits<Mass>> referencedNumberWithUnitsWithImport_local;
					try {
						referencedNumberWithUnitsWithImport_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_number_with_units_with_import"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new RealWithUnits<>(resolved, Mass.class);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedNumberWithUnitsWithImport_local = Optional.empty();
					}
					this.referencedNumberWithUnitsWithImport = referencedNumberWithUnitsWithImport_local;
					
					Optional<IntegerRange> referencedRangeNoImport_local;
					try {
						referencedRangeNoImport_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_range_no_import"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new IntegerRange(resolved, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedRangeNoImport_local = Optional.empty();
					}
					this.referencedRangeNoImport = referencedRangeNoImport_local;
					
					Optional<RealRange> referencedRangeWithImport_local;
					try {
						referencedRangeWithImport_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_range_with_import"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new RealRange(resolved, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedRangeWithImport_local = Optional.empty();
					}
					this.referencedRangeWithImport = referencedRangeWithImport_local;
					
					Optional<RecordOfBoolean> referencedRecordNoImport_local;
					try {
						referencedRecordNoImport_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_record_no_import"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new RecordOfBoolean(resolved, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedRecordNoImport_local = Optional.empty();
					}
					this.referencedRecordNoImport = referencedRecordNoImport_local;
					
					Optional<BasicRecord> referencedRecordWithImport_local;
					try {
						referencedRecordWithImport_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_record_with_import"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new BasicRecord(resolved, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedRecordWithImport_local = Optional.empty();
					}
					this.referencedRecordWithImport = referencedRecordWithImport_local;
					
					Optional<InstanceObject> referencedReference_local;
					try {
						referencedReference_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("referenced_reference"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						referencedReference_local = Optional.empty();
					}
					this.referencedReference = referencedReference_local;
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
					ALLEGHENY("allegheny", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.3/@ownedPropertyType/@ownedLiteral.0"),
					MONONGAHELA("monongahela", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.3/@ownedPropertyType/@ownedLiteral.1"),
					OHIO("ohio", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.3/@ownedPropertyType/@ownedLiteral.2");
					
					private final String originalName;
					private final URI uri;
					
					private OwnedEnumeration_FieldType(String originalName, String uri) {
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
					}
					
					public static OwnedEnumeration_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					public EnumerationLiteral toEnumerationLiteral(ResourceSet resourceSet) {
						EnumerationLiteral literal = (EnumerationLiteral) resourceSet.getEObject(uri, true);
						if (literal == null) {
							throw new RuntimeException("Could not resolve EnumerationLiteral '" + originalName + "'.");
						}
						return literal;
					}
					
					public NamedValue toPropertyExpression(ResourceSet resourceSet) {
						NamedValue value = Aadl2Factory.eINSTANCE.createNamedValue();
						value.setNamedValue(toEnumerationLiteral(resourceSet));
						return value;
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
					
					public double getFactorTo(OwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public static class OwnedRecord_FieldType {
					private final Optional<String> stringField;
					private final OptionalLong integerField;
					
					public OwnedRecord_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
						RecordValue recordValue = (RecordValue) propertyExpression;
						
						Optional<String> stringField_local;
						try {
							stringField_local = recordValue.getOwnedFieldValues()
									.stream()
									.filter(field -> field.getProperty().getName().equals("string_field"))
									.map(field -> {
										PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
										return ((StringLiteral) resolved).getValue();
									})
									.findAny();
						} catch (PropertyNotPresentException e) {
							stringField_local = Optional.empty();
						}
						this.stringField = stringField_local;
						
						OptionalLong integerField_local;
						try {
							integerField_local = recordValue.getOwnedFieldValues()
									.stream()
									.filter(field -> field.getProperty().getName().equals("integer_field"))
									.mapToLong(field -> {
										PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
										return ((IntegerLiteral) resolved).getValue();
									})
									.findAny();
						} catch (PropertyNotPresentException e) {
							integerField_local = OptionalLong.empty();
						}
						this.integerField = integerField_local;
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
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class RecordOfBoolean {
				private final Optional<Boolean> field;
				
				public RecordOfBoolean(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<Boolean> field_local;
					try {
						field_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("field"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((BooleanLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						field_local = Optional.empty();
					}
					this.field = field_local;
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
			
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.StringLiteral;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class RecordOfString {
				private final Optional<String> field;
				
				public RecordOfString(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<String> field_local;
					try {
						field_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("field"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((StringLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						field_local = Optional.empty();
					}
					this.field = field_local;
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
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class RecordOfClassifier {
				private final Optional<Classifier> field;
				
				public RecordOfClassifier(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<Classifier> field_local;
					try {
						field_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("field"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ClassifierValue) resolved).getClassifier();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						field_local = Optional.empty();
					}
					this.field = field_local;
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
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class RecordOfEnum {
				private final Optional<Field_FieldType> field;
				
				public RecordOfEnum(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<Field_FieldType> field_local;
					try {
						field_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("field"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return Field_FieldType.valueOf(resolved);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						field_local = Optional.empty();
					}
					this.field = field_local;
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
					A("a", "__synthetic1.aadl#/0/@ownedPropertyType.13/@ownedField.0/@ownedPropertyType/@ownedLiteral.0"),
					B("b", "__synthetic1.aadl#/0/@ownedPropertyType.13/@ownedField.0/@ownedPropertyType/@ownedLiteral.1"),
					C("c", "__synthetic1.aadl#/0/@ownedPropertyType.13/@ownedField.0/@ownedPropertyType/@ownedLiteral.2");
					
					private final String originalName;
					private final URI uri;
					
					private Field_FieldType(String originalName, String uri) {
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
					}
					
					public static Field_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					public EnumerationLiteral toEnumerationLiteral(ResourceSet resourceSet) {
						EnumerationLiteral literal = (EnumerationLiteral) resourceSet.getEObject(uri, true);
						if (literal == null) {
							throw new RuntimeException("Could not resolve EnumerationLiteral '" + originalName + "'.");
						}
						return literal;
					}
					
					public NamedValue toPropertyExpression(ResourceSet resourceSet) {
						NamedValue value = Aadl2Factory.eINSTANCE.createNamedValue();
						value.setNamedValue(toEnumerationLiteral(resourceSet));
						return value;
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
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public class RecordOfUnits {
				private final Optional<Field_FieldType> field;
				
				public RecordOfUnits(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<Field_FieldType> field_local;
					try {
						field_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("field"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return Field_FieldType.valueOf(resolved);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						field_local = Optional.empty();
					}
					this.field = field_local;
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
					
					public double getFactorTo(Field_FieldType target) {
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
			import java.util.Optional;
			import java.util.OptionalLong;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class RecordOfInteger {
				private final OptionalLong field;
				
				public RecordOfInteger(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					OptionalLong field_local;
					try {
						field_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("field"))
								.mapToLong(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((IntegerLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						field_local = OptionalLong.empty();
					}
					this.field = field_local;
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
			import java.util.Optional;
			import java.util.OptionalDouble;
			
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class RecordOfReal {
				private final OptionalDouble field;
				
				public RecordOfReal(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					OptionalDouble field_local;
					try {
						field_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("field"))
								.mapToDouble(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((RealLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						field_local = OptionalDouble.empty();
					}
					this.field = field_local;
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
			
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class RecordOfReference {
				private final Optional<InstanceObject> field;
				
				public RecordOfReference(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<InstanceObject> field_local;
					try {
						field_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("field"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						field_local = Optional.empty();
					}
					this.field = field_local;
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
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class NestedRecord {
				private final Optional<Field1_FieldType> field1;
				
				public NestedRecord(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<Field1_FieldType> field1_local;
					try {
						field1_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("field1"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new Field1_FieldType(resolved, lookupContext, mode);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						field1_local = Optional.empty();
					}
					this.field1 = field1_local;
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
					
					public Field1_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
						RecordValue recordValue = (RecordValue) propertyExpression;
						
						Optional<Field2_FieldType> field2_local;
						try {
							field2_local = recordValue.getOwnedFieldValues()
									.stream()
									.filter(field -> field.getProperty().getName().equals("field2"))
									.map(field -> {
										PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
										return new Field2_FieldType(resolved, lookupContext, mode);
									})
									.findAny();
						} catch (PropertyNotPresentException e) {
							field2_local = Optional.empty();
						}
						this.field2 = field2_local;
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
						
						public Field2_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
							RecordValue recordValue = (RecordValue) propertyExpression;
							
							Optional<Field3_FieldType> field3_local;
							try {
								field3_local = recordValue.getOwnedFieldValues()
										.stream()
										.filter(field -> field.getProperty().getName().equals("field3"))
										.map(field -> {
											PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
											return new Field3_FieldType(resolved, lookupContext, mode);
										})
										.findAny();
							} catch (PropertyNotPresentException e) {
								field3_local = Optional.empty();
							}
							this.field3 = field3_local;
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
							
							public Field3_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
								RecordValue recordValue = (RecordValue) propertyExpression;
								
								OptionalLong innerField_local;
								try {
									innerField_local = recordValue.getOwnedFieldValues()
											.stream()
											.filter(field -> field.getProperty().getName().equals("inner_field"))
											.mapToLong(field -> {
												PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
												return ((IntegerLiteral) resolved).getValue();
											})
											.findAny();
								} catch (PropertyNotPresentException e) {
									innerField_local = OptionalLong.empty();
								}
								this.innerField = innerField_local;
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
		assertEquals("src-gen/ps1", results.packagePath)
		assertEquals(13, results.classes.size)
		
		assertEquals("Time.java", results.classes.get(0).fileName)
		assertEquals(time.toString, results.classes.get(0).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.classes.get(1).fileName)
		assertEquals(integerOwnedUnits.toString, results.classes.get(1).contents)
		
		assertEquals("EnumType1.java", results.classes.get(2).fileName)
		assertEquals(enumType1.toString, results.classes.get(2).contents)
		
		assertEquals("RecordType1.java", results.classes.get(3).fileName)
		assertEquals(recordType1.toString, results.classes.get(3).contents)
		
		assertEquals("RecordOfBoolean.java", results.classes.get(4).fileName)
		assertEquals(recordOfBoolean.toString, results.classes.get(4).contents)
		
		assertEquals("RecordOfString.java", results.classes.get(5).fileName)
		assertEquals(recordOfString.toString, results.classes.get(5).contents)
		
		assertEquals("RecordOfClassifier.java", results.classes.get(6).fileName)
		assertEquals(recordOfClassifier.toString, results.classes.get(6).contents)
		
		assertEquals("RecordOfEnum.java", results.classes.get(7).fileName)
		assertEquals(recordOfEnum.toString, results.classes.get(7).contents)
		
		assertEquals("RecordOfUnits.java", results.classes.get(8).fileName)
		assertEquals(recordOfUnits.toString, results.classes.get(8).contents)
		
		assertEquals("RecordOfInteger.java", results.classes.get(9).fileName)
		assertEquals(recordOfInteger.toString, results.classes.get(9).contents)
		
		assertEquals("RecordOfReal.java", results.classes.get(10).fileName)
		assertEquals(recordOfReal.toString, results.classes.get(10).contents)
		
		assertEquals("RecordOfReference.java", results.classes.get(11).fileName)
		assertEquals(recordOfReference.toString, results.classes.get(11).contents)
		
		assertEquals("NestedRecord.java", results.classes.get(12).fileName)
		assertEquals(nestedRecord.toString, results.classes.get(12).contents)
	}
}