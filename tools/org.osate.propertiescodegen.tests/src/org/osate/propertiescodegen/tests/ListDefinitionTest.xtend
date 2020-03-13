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
class ListDefinitionTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testListDefinition() {
		val ps2 = '''
			property set ps2 is
				mass: type units (g, kg => g * 1000);
				mass_type: type aadlreal units ps2::mass;
				color: type enumeration (red, green, blue);
				basic_range: type range of aadlreal;
				basic_record: type record (field: aadlreal;);
			end ps2;
		'''
		val ps1 = '''
			property set ps1 is
				with ps2;
				
				time: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				integer_owned_units: type aadlinteger units (mm, cm => mm * 10, m => cm * 100);
				enum_type_1: type enumeration (one, two, three);
				range_of_integer_no_units: type range of aadlinteger;
				record_of_boolean: type record (field: aadlboolean;);
				
				list_1_boolean: list of aadlboolean applies to (all);
				list_2_boolean: list of list of aadlboolean applies to (all);
				list_3_boolean: list of list of list of aadlboolean applies to (all);
				list_4_boolean: list of list of list of list of aadlboolean applies to (all);
				list_5_boolean: list of list of list of list of list of aadlboolean applies to (all);
				
				list_1_string: list of aadlstring applies to (all);
				list_1_classifier: list of classifier applies to (all);
				list_1_integer_no_units: list of aadlinteger applies to (all);
				list_1_real_no_units: list of aadlreal applies to (all);
				list_1_reference: list of reference applies to (all);
				
				list_1_owned_enum: list of enumeration (mercury, venus, earth, mars) applies to (all);
				list_1_owned_units: list of units (cm, m => cm * 100) applies to (all);
				list_1_owned_integer_with_units: list of aadlinteger units ps1::time applies to (all);
				list_1_owned_range: list of range of aadlinteger applies to (all);
				list_1_owned_record: list of record (
					boolean_field: aadlboolean;
					string_field: aadlstring;
					record_field: record (
						integer_field: aadlinteger;
						real_field: aadlreal;
					);
				) applies to (all);
				
				list_1_referenced_enum_no_import: list of ps1::enum_type_1 applies to (all);
				list_1_referenced_enum_with_import: list of ps2::color applies to (all);
				list_1_referenced_units_no_import: list of ps1::time applies to (all);
				list_1_referenced_units_with_import: list of ps2::mass applies to (all);
				list_1_referenced_number_with_units_no_import: list of ps1::integer_owned_units applies to (all);
				list_1_referenced_number_with_units_with_import: list of ps2::mass_type applies to (all);
				list_1_referenced_range_no_import: list of ps1::range_of_integer_no_units applies to (all);
				list_1_referenced_range_with_import: list of ps2::basic_range applies to (all);
				list_1_referenced_record_no_import: list of ps1::record_of_boolean applies to (all);
				list_1_referenced_record_with_import: list of ps2::basic_record applies to (all);
				
				list_3_owned_enum: list of list of list of enumeration (north_america, south_america) applies to (all);
				list_5_owned_range: list of list of list of list of list of range of aadlreal applies to (all);
				list_3_referenced_enum_no_import: list of list of list of ps1::enum_type_1 applies to (all);
				list_5_referenced_range_with_import: list of list of list of list of list of ps2::basic_range applies to (all);
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
				
				public static Time getValue(PropertyExpression propertyExpression) {
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
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			
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
				
				public static EnumType1 getValue(PropertyExpression propertyExpression) {
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
		val list1Boolean = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List1Boolean {
				public static List<Boolean> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((BooleanLiteral) element1).getValue();
					}).collect(Collectors.toList());
				}
			}
		'''
		val list2Boolean = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List2Boolean {
				public static List<List<Boolean>> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
							return ((BooleanLiteral) element2).getValue();
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
			}
		'''
		val list3Boolean = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List3Boolean {
				public static List<List<List<Boolean>>> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
							return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
								return ((BooleanLiteral) element3).getValue();
							}).collect(Collectors.toList());
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
			}
		'''
		val list4Boolean = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List4Boolean {
				public static List<List<List<List<Boolean>>>> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
							return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
								return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
									return ((BooleanLiteral) element4).getValue();
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
			}
		'''
		val list5Boolean = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List5Boolean {
				public static List<List<List<List<List<Boolean>>>>> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
							return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
								return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
									return ((ListValue) element4).getOwnedListElements().stream().map(element5 -> {
										return ((BooleanLiteral) element5).getValue();
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1String = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.StringLiteral;
			
			public class List1String {
				public static List<String> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((StringLiteral) element1).getValue();
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1Classifier = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Classifier;
			import org.osate.aadl2.ClassifierValue;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List1Classifier {
				public static List<Classifier> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((ClassifierValue) element1).getClassifier();
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1IntegerNoUnits = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List1IntegerNoUnits {
				public static List<Long> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((IntegerLiteral) element1).getValue();
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1RealNoUnits = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			
			public class List1RealNoUnits {
				public static List<Double> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((RealLiteral) element1).getValue();
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1Reference = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
			
			public class List1Reference {
				public static List<InstanceObject> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((InstanceReferenceValue) element1).getReferencedInstanceObject();
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1OwnedEnum = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List1OwnedEnum {
				public static List<ElementType> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						AbstractNamedValue abstractNamedValue = ((NamedValue) element1).getNamedValue();
						return ElementType.valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
					}).collect(Collectors.toList());
				}
				
				public enum ElementType {
					MERCURY("mercury"),
					VENUS("venus"),
					EARTH("earth"),
					MARS("mars");
					
					private final String originalName;
					
					private ElementType(String originalName) {
						this.originalName = originalName;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
			}
		'''
		val list1OwnedUnits = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			
			public class List1OwnedUnits {
				public static List<ElementType> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						AbstractNamedValue abstractNamedValue = ((NamedValue) element1).getNamedValue();
						return ElementType.valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}).collect(Collectors.toList());
				}
				
				public enum ElementType {
					CM(1.0, "cm"),
					M(100.0, "m");
					
					private final double factorToBase;
					private final String originalName;
					
					private ElementType(double factorToBase, String originalName) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
					}
					
					public double getFactorToBase() {
						return factorToBase;
					}
					
					public double getFactorTo(ElementType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
			}
		'''
		val list1OwnedIntegerWithUnits = '''
			package ps1;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List1OwnedIntegerWithUnits {
				public static List<ElementType> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return new ElementType(element1);
					}).collect(Collectors.toList());
				}
				
				public static class ElementType {
					private final long value;
					private final Time unit;
					
					private ElementType(PropertyExpression propertyExpression) {
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
						if (!(obj instanceof ElementType)) {
							return false;
						}
						ElementType other = (ElementType) obj;
						return value == other.value && unit == other.unit;
					}
					
					@Override
					public String toString() {
						return value + unit.toString();
					}
				}
			}
		'''
		val list1OwnedRange = '''
			package ps1;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.OptionalLong;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			
			public class List1OwnedRange {
				public static List<ElementType> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return new ElementType(element1);
					}).collect(Collectors.toList());
				}
				
				public static class ElementType {
					private final long minimum;
					private final long maximum;
					private final OptionalLong delta;
					
					private ElementType(PropertyExpression propertyExpression) {
						RangeValue rangeValue = (RangeValue) propertyExpression;
						minimum = ((IntegerLiteral) rangeValue.getMinimum()).getValue();
						maximum = ((IntegerLiteral) rangeValue.getMaximum()).getValue();
						if (rangeValue.getDelta() == null) {
							delta = OptionalLong.empty();
						} else {
							delta = OptionalLong.of(((IntegerLiteral) rangeValue.getDelta()).getValue());
						}
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
						if (!(obj instanceof ElementType)) {
							return false;
						}
						ElementType other = (ElementType) obj;
						return minimum == other.minimum && maximum == other.maximum && Objects.equals(delta, other.delta);
					}
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
						delta.ifPresent(it -> builder.append(" delta " + it));
						return builder.toString();
					}
				}
			}
		'''
		val list1OwnedRecord = '''
			package ps1;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.OptionalDouble;
			import java.util.OptionalLong;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.StringLiteral;
			
			public class List1OwnedRecord {
				public static List<ElementType> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return new ElementType(element1);
					}).collect(Collectors.toList());
				}
				
				public static class ElementType {
					private final Optional<Boolean> booleanField;
					private final Optional<String> stringField;
					private final Optional<RecordFieldType> recordField;
					
					private ElementType(PropertyExpression propertyExpression) {
						RecordValue recordValue = (RecordValue) propertyExpression;
						booleanField = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("boolean_field"))
								.map(field -> ((BooleanLiteral) field.getOwnedValue()).getValue())
								.findAny();
						stringField = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("string_field"))
								.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
								.findAny();
						recordField = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("record_field"))
								.map(field -> new RecordFieldType(field.getOwnedValue()))
								.findAny();
					}
					
					public Optional<Boolean> getBooleanField() {
						return booleanField;
					}
					
					public Optional<String> getStringField() {
						return stringField;
					}
					
					public Optional<RecordFieldType> getRecordField() {
						return recordField;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(
								booleanField,
								stringField,
								recordField
						);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof ElementType)) {
							return false;
						}
						ElementType other = (ElementType) obj;
						return Objects.equals(booleanField, other.booleanField)
								&& Objects.equals(stringField, other.stringField)
								&& Objects.equals(recordField, other.recordField);
					}
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder();
						builder.append('[');
						booleanField.ifPresent(field -> {
							builder.append("boolean_field => ");
							builder.append(field);
							builder.append(';');
						});
						stringField.ifPresent(field -> {
							builder.append("string_field => \"");
							builder.append(field);
							builder.append("\";");
						});
						recordField.ifPresent(field -> {
							builder.append("record_field => ");
							builder.append(field);
							builder.append(';');
						});
						builder.append(']');
						return builder.toString();
					}
					
					public static class RecordFieldType {
						private final OptionalLong integerField;
						private final OptionalDouble realField;
						
						private RecordFieldType(PropertyExpression propertyExpression) {
							RecordValue recordValue = (RecordValue) propertyExpression;
							integerField = recordValue.getOwnedFieldValues()
									.stream()
									.filter(field -> field.getProperty().getName().equals("integer_field"))
									.mapToLong(field -> ((IntegerLiteral) field.getOwnedValue()).getValue())
									.findAny();
							realField = recordValue.getOwnedFieldValues()
									.stream()
									.filter(field -> field.getProperty().getName().equals("real_field"))
									.mapToDouble(field -> ((RealLiteral) field.getOwnedValue()).getValue())
									.findAny();
						}
						
						public OptionalLong getIntegerField() {
							return integerField;
						}
						
						public OptionalDouble getRealField() {
							return realField;
						}
						
						@Override
						public int hashCode() {
							return Objects.hash(
									integerField,
									realField
							);
						}
						
						@Override
						public boolean equals(Object obj) {
							if (this == obj) {
								return true;
							}
							if (!(obj instanceof RecordFieldType)) {
								return false;
							}
							RecordFieldType other = (RecordFieldType) obj;
							return Objects.equals(integerField, other.integerField)
									&& Objects.equals(realField, other.realField);
						}
						
						@Override
						public String toString() {
							StringBuilder builder = new StringBuilder();
							builder.append('[');
							integerField.ifPresent(field -> {
								builder.append("integer_field => ");
								builder.append(field);
								builder.append(';');
							});
							realField.ifPresent(field -> {
								builder.append("real_field => ");
								builder.append(field);
								builder.append(';');
							});
							builder.append(']');
							return builder.toString();
						}
					}
				}
			}
		'''
		val list1ReferencedEnumNoImport = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List1ReferencedEnumNoImport {
				public static List<EnumType1> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return EnumType1.getValue(element1);
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1ReferencedEnumWithImport = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			import ps2.Color;
			
			public class List1ReferencedEnumWithImport {
				public static List<Color> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return Color.getValue(element1);
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1ReferencedUnitsNoImport = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List1ReferencedUnitsNoImport {
				public static List<Time> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return Time.getValue(element1);
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1ReferencedUnitsWithImport = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			import ps2.Mass;
			
			public class List1ReferencedUnitsWithImport {
				public static List<Mass> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return Mass.getValue(element1);
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1ReferencedNumberWithUnitsNoImport = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List1ReferencedNumberWithUnitsNoImport {
				public static List<IntegerOwnedUnits> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return IntegerOwnedUnits.getValue(element1);
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1ReferencedNumberWithUnitsWithImport = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			import ps2.MassType;
			
			public class List1ReferencedNumberWithUnitsWithImport {
				public static List<MassType> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return MassType.getValue(element1);
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1ReferencedRangeNoImport = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List1ReferencedRangeNoImport {
				public static List<RangeOfIntegerNoUnits> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return RangeOfIntegerNoUnits.getValue(element1);
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1ReferencedRangeWithImport = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			import ps2.BasicRange;
			
			public class List1ReferencedRangeWithImport {
				public static List<BasicRange> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return BasicRange.getValue(element1);
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1ReferencedRecordNoImport = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List1ReferencedRecordNoImport {
				public static List<RecordOfBoolean> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return RecordOfBoolean.getValue(element1);
					}).collect(Collectors.toList());
				}
			}
		'''
		val list1ReferencedRecordWithImport = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			import ps2.BasicRecord;
			
			public class List1ReferencedRecordWithImport {
				public static List<BasicRecord> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return BasicRecord.getValue(element1);
					}).collect(Collectors.toList());
				}
			}
		'''
		val list3OwnedEnum = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List3OwnedEnum {
				public static List<List<List<ElementType>>> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
							return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
								AbstractNamedValue abstractNamedValue = ((NamedValue) element3).getNamedValue();
								return ElementType.valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
				
				public enum ElementType {
					NORTH_AMERICA("north_america"),
					SOUTH_AMERICA("south_america");
					
					private final String originalName;
					
					private ElementType(String originalName) {
						this.originalName = originalName;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
			}
		'''
		val list5OwnedRange = '''
			package ps1;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.OptionalDouble;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			import org.osate.aadl2.RealLiteral;
			
			public class List5OwnedRange {
				public static List<List<List<List<List<ElementType>>>>> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
							return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
								return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
									return ((ListValue) element4).getOwnedListElements().stream().map(element5 -> {
										return new ElementType(element5);
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
				
				public static class ElementType {
					private final double minimum;
					private final double maximum;
					private final OptionalDouble delta;
					
					private ElementType(PropertyExpression propertyExpression) {
						RangeValue rangeValue = (RangeValue) propertyExpression;
						minimum = ((RealLiteral) rangeValue.getMinimum()).getValue();
						maximum = ((RealLiteral) rangeValue.getMaximum()).getValue();
						if (rangeValue.getDelta() == null) {
							delta = OptionalDouble.empty();
						} else {
							delta = OptionalDouble.of(((RealLiteral) rangeValue.getDelta()).getValue());
						}
					}
					
					public double getMinimum() {
						return minimum;
					}
					
					public double getMaximum() {
						return maximum;
					}
					
					public OptionalDouble getDelta() {
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
						if (!(obj instanceof ElementType)) {
							return false;
						}
						ElementType other = (ElementType) obj;
						return Double.doubleToLongBits(minimum) == Double.doubleToLongBits(other.minimum)
								&& Double.doubleToLongBits(maximum) == Double.doubleToLongBits(other.maximum)
								&& Objects.equals(delta, other.delta);
					}
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
						delta.ifPresent(it -> builder.append(" delta " + it));
						return builder.toString();
					}
				}
			}
		'''
		val list3ReferencedEnumNoImport = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class List3ReferencedEnumNoImport {
				public static List<List<List<EnumType1>>> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
							return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
								return EnumType1.getValue(element3);
							}).collect(Collectors.toList());
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
			}
		'''
		val list5ReferencedRangeWithImport = '''
			package ps1;
			
			import java.util.List;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			
			import ps2.BasicRange;
			
			public class List5ReferencedRangeWithImport {
				public static List<List<List<List<List<BasicRange>>>>> getValue(PropertyExpression propertyExpression) {
					return ((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
						return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
							return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
								return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
									return ((ListValue) element4).getOwnedListElements().stream().map(element5 -> {
										return BasicRange.getValue(element5);
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(ps1, ps2))
		assertEquals(34, results.size)
		
		assertEquals("Time.java", results.get(0).fileName)
		assertEquals(time.toString, results.get(0).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.get(1).fileName)
		assertEquals(integerOwnedUnits.toString, results.get(1).contents)
		
		assertEquals("EnumType1.java", results.get(2).fileName)
		assertEquals(enumType1.toString, results.get(2).contents)
		
		assertEquals("RangeOfIntegerNoUnits.java", results.get(3).fileName)
		assertEquals(rangeOfIntegerNoUnits.toString, results.get(3).contents)
		
		assertEquals("RecordOfBoolean.java", results.get(4).fileName)
		assertEquals(recordOfBoolean.toString, results.get(4).contents)
		
		assertEquals("List1Boolean.java", results.get(5).fileName)
		assertEquals(list1Boolean.toString, results.get(5).contents)
		
		assertEquals("List2Boolean.java", results.get(6).fileName)
		assertEquals(list2Boolean.toString, results.get(6).contents)
		
		assertEquals("List3Boolean.java", results.get(7).fileName)
		assertEquals(list3Boolean.toString, results.get(7).contents)
		
		assertEquals("List4Boolean.java", results.get(8).fileName)
		assertEquals(list4Boolean.toString, results.get(8).contents)
		
		assertEquals("List5Boolean.java", results.get(9).fileName)
		assertEquals(list5Boolean.toString, results.get(9).contents)
		
		assertEquals("List1String.java", results.get(10).fileName)
		assertEquals(list1String.toString, results.get(10).contents)
		
		assertEquals("List1Classifier.java", results.get(11).fileName)
		assertEquals(list1Classifier.toString, results.get(11).contents)
		
		assertEquals("List1IntegerNoUnits.java", results.get(12).fileName)
		assertEquals(list1IntegerNoUnits.toString, results.get(12).contents)
		
		assertEquals("List1RealNoUnits.java", results.get(13).fileName)
		assertEquals(list1RealNoUnits.toString, results.get(13).contents)
		
		assertEquals("List1Reference.java", results.get(14).fileName)
		assertEquals(list1Reference.toString, results.get(14).contents)
		
		assertEquals("List1OwnedEnum.java", results.get(15).fileName)
		assertEquals(list1OwnedEnum.toString, results.get(15).contents)
		
		assertEquals("List1OwnedUnits.java", results.get(16).fileName)
		assertEquals(list1OwnedUnits.toString, results.get(16).contents)
		
		assertEquals("List1OwnedIntegerWithUnits.java", results.get(17).fileName)
		assertEquals(list1OwnedIntegerWithUnits.toString, results.get(17).contents)
		
		assertEquals("List1OwnedRange.java", results.get(18).fileName)
		assertEquals(list1OwnedRange.toString, results.get(18).contents)
		
		assertEquals("List1OwnedRecord.java", results.get(19).fileName)
		assertEquals(list1OwnedRecord.toString, results.get(19).contents)
		
		assertEquals("List1ReferencedEnumNoImport.java", results.get(20).fileName)
		assertEquals(list1ReferencedEnumNoImport.toString, results.get(20).contents)
		
		assertEquals("List1ReferencedEnumWithImport.java", results.get(21).fileName)
		assertEquals(list1ReferencedEnumWithImport.toString, results.get(21).contents)
		
		assertEquals("List1ReferencedUnitsNoImport.java", results.get(22).fileName)
		assertEquals(list1ReferencedUnitsNoImport.toString, results.get(22).contents)
		
		assertEquals("List1ReferencedUnitsWithImport.java", results.get(23).fileName)
		assertEquals(list1ReferencedUnitsWithImport.toString, results.get(23).contents)
		
		assertEquals("List1ReferencedNumberWithUnitsNoImport.java", results.get(24).fileName)
		assertEquals(list1ReferencedNumberWithUnitsNoImport.toString, results.get(24).contents)
		
		assertEquals("List1ReferencedNumberWithUnitsWithImport.java", results.get(25).fileName)
		assertEquals(list1ReferencedNumberWithUnitsWithImport.toString, results.get(25).contents)
		
		assertEquals("List1ReferencedRangeNoImport.java", results.get(26).fileName)
		assertEquals(list1ReferencedRangeNoImport.toString, results.get(26).contents)
		
		assertEquals("List1ReferencedRangeWithImport.java", results.get(27).fileName)
		assertEquals(list1ReferencedRangeWithImport.toString, results.get(27).contents)
		
		assertEquals("List1ReferencedRecordNoImport.java", results.get(28).fileName)
		assertEquals(list1ReferencedRecordNoImport.toString, results.get(28).contents)
		
		assertEquals("List1ReferencedRecordWithImport.java", results.get(29).fileName)
		assertEquals(list1ReferencedRecordWithImport.toString, results.get(29).contents)
		
		assertEquals("List3OwnedEnum.java", results.get(30).fileName)
		assertEquals(list3OwnedEnum.toString, results.get(30).contents)
		
		assertEquals("List5OwnedRange.java", results.get(31).fileName)
		assertEquals(list5OwnedRange.toString, results.get(31).contents)
		
		assertEquals("List3ReferencedEnumNoImport.java", results.get(32).fileName)
		assertEquals(list3ReferencedEnumNoImport.toString, results.get(32).contents)
		
		assertEquals("List5ReferencedRangeWithImport.java", results.get(33).fileName)
		assertEquals(list5ReferencedRangeWithImport.toString, results.get(33).contents)
	}
}