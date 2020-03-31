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
class RecordOfListTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testRecordOfListType() {
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
				
				record_of_list_of_boolean: type record (
					field1: list of aadlboolean;
					field2: list of list of aadlboolean;
					field3: list of list of list of aadlboolean;
					field4: list of list of list of list of aadlboolean;
					field5: list of list of list of list of list of aadlboolean;
				);
				record_of_list_of_string: type record (
					field1: list of aadlstring;
					field5: list of list of list of list of list of aadlstring;
				);
				record_of_list_of_classifier: type record (
					field1: list of classifier;
					field5: list of list of list of list of list of classifier;
				);
				record_of_list_of_integer_no_units: type record (field: list of aadlinteger;);
				record_of_list_of_real_no_units: type record (field: list of aadlreal;);
				record_of_list_of_reference: type record (
					field1: list of reference;
					field5: list of list of list of list of list of reference;
				);
				
				record_of_list_of_owned_types: type record (
					owned_enum: list of enumeration (mercury, gemini, apollo);
					owned_units: list of units (ms, s => ms * 1000);
					owned_integer_with_units: list of aadlinteger units ps1::time;
					owned_range: list of range of aadlinteger;
					owned_record: list of record (
						boolean_field: aadlboolean;
						record_field: record (
							string_field: aadlstring;
							integer_field: aadlinteger;
						);
					);
				);
				
				record_of_list_of_referenced_types: type record (
					enum_no_import: list of ps1::enum_type_1;
					enum_with_import: list of ps2::color;
					units_no_import: list of ps1::time;
					units_with_import: list of ps2::mass;
					number_with_units_no_import: list of ps1::integer_owned_units;
					number_with_units_with_import: list of ps2::mass_type;
					range_no_import: list of ps1::range_of_integer_no_units;
					range_with_import: list of ps2::basic_range;
					record_no_import: list of ps1::record_of_boolean;
					record_with_import: list of ps2::basic_record;
				);
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
		val recordOfListOfBoolean = '''
			package ps1;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			
			public class RecordOfListOfBoolean {
				private final Optional<List<Boolean>> field1;
				private final Optional<List<List<Boolean>>> field2;
				private final Optional<List<List<List<Boolean>>>> field3;
				private final Optional<List<List<List<List<Boolean>>>>> field4;
				private final Optional<List<List<List<List<List<Boolean>>>>>> field5;
				
				private RecordOfListOfBoolean(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field1 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field1"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((BooleanLiteral) element1).getValue();
								}).collect(Collectors.toList());
							})
							.findAny();
					field2 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field2"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
										return ((BooleanLiteral) element2).getValue();
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							})
							.findAny();
					field3 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field3"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
										return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
											return ((BooleanLiteral) element3).getValue();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							})
							.findAny();
					field4 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field4"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
										return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
											return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
												return ((BooleanLiteral) element4).getValue();
											}).collect(Collectors.toList());
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							})
							.findAny();
					field5 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field5"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
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
							})
							.findAny();
				}
				
				public static RecordOfListOfBoolean getValue(PropertyExpression propertyExpression) {
					return new RecordOfListOfBoolean(propertyExpression);
				}
				
				public Optional<List<Boolean>> getField1() {
					return field1;
				}
				
				public Optional<List<List<Boolean>>> getField2() {
					return field2;
				}
				
				public Optional<List<List<List<Boolean>>>> getField3() {
					return field3;
				}
				
				public Optional<List<List<List<List<Boolean>>>>> getField4() {
					return field4;
				}
				
				public Optional<List<List<List<List<List<Boolean>>>>>> getField5() {
					return field5;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							field1,
							field2,
							field3,
							field4,
							field5
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfListOfBoolean)) {
						return false;
					}
					RecordOfListOfBoolean other = (RecordOfListOfBoolean) obj;
					return Objects.equals(field1, other.field1)
							&& Objects.equals(field2, other.field2)
							&& Objects.equals(field3, other.field3)
							&& Objects.equals(field4, other.field4)
							&& Objects.equals(field5, other.field5);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field1.ifPresent(field -> {
						builder.append("field1 => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					field2.ifPresent(field -> {
						builder.append("field2 => ");
						builder.append(field.stream().map(element1 -> {
							return element1.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"));
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					field3.ifPresent(field -> {
						builder.append("field3 => ");
						builder.append(field.stream().map(element1 -> {
							return element1.stream().map(element2 -> {
								return element2.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"));
							}).collect(Collectors.joining(", ", "(", ")"));
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					field4.ifPresent(field -> {
						builder.append("field4 => ");
						builder.append(field.stream().map(element1 -> {
							return element1.stream().map(element2 -> {
								return element2.stream().map(element3 -> {
									return element3.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"));
								}).collect(Collectors.joining(", ", "(", ")"));
							}).collect(Collectors.joining(", ", "(", ")"));
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					field5.ifPresent(field -> {
						builder.append("field5 => ");
						builder.append(field.stream().map(element1 -> {
							return element1.stream().map(element2 -> {
								return element2.stream().map(element3 -> {
									return element3.stream().map(element4 -> {
										return element4.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"));
									}).collect(Collectors.joining(", ", "(", ")"));
								}).collect(Collectors.joining(", ", "(", ")"));
							}).collect(Collectors.joining(", ", "(", ")"));
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val recordOfListOfString = '''
			package ps1;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.StringLiteral;
			
			public class RecordOfListOfString {
				private final Optional<List<String>> field1;
				private final Optional<List<List<List<List<List<String>>>>>> field5;
				
				private RecordOfListOfString(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field1 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field1"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((StringLiteral) element1).getValue();
								}).collect(Collectors.toList());
							})
							.findAny();
					field5 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field5"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
										return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
											return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
												return ((ListValue) element4).getOwnedListElements().stream().map(element5 -> {
													return ((StringLiteral) element5).getValue();
												}).collect(Collectors.toList());
											}).collect(Collectors.toList());
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							})
							.findAny();
				}
				
				public static RecordOfListOfString getValue(PropertyExpression propertyExpression) {
					return new RecordOfListOfString(propertyExpression);
				}
				
				public Optional<List<String>> getField1() {
					return field1;
				}
				
				public Optional<List<List<List<List<List<String>>>>>> getField5() {
					return field5;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							field1,
							field5
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfListOfString)) {
						return false;
					}
					RecordOfListOfString other = (RecordOfListOfString) obj;
					return Objects.equals(field1, other.field1)
							&& Objects.equals(field5, other.field5);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field1.ifPresent(field -> {
						builder.append("field1 => ");
						builder.append(field.stream().map(element1 -> {
							return '\"' + element1 + '\"';
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					field5.ifPresent(field -> {
						builder.append("field5 => ");
						builder.append(field.stream().map(element1 -> {
							return element1.stream().map(element2 -> {
								return element2.stream().map(element3 -> {
									return element3.stream().map(element4 -> {
										return element4.stream().map(element5 -> {
											return '\"' + element5 + '\"';
										}).collect(Collectors.joining(", ", "(", ")"));
									}).collect(Collectors.joining(", ", "(", ")"));
								}).collect(Collectors.joining(", ", "(", ")"));
							}).collect(Collectors.joining(", ", "(", ")"));
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val recordOfListOfClassifier = '''
			package ps1;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Classifier;
			import org.osate.aadl2.ClassifierValue;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			
			public class RecordOfListOfClassifier {
				private final Optional<List<Classifier>> field1;
				private final Optional<List<List<List<List<List<Classifier>>>>>> field5;
				
				private RecordOfListOfClassifier(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field1 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field1"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((ClassifierValue) element1).getClassifier();
								}).collect(Collectors.toList());
							})
							.findAny();
					field5 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field5"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
										return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
											return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
												return ((ListValue) element4).getOwnedListElements().stream().map(element5 -> {
													return ((ClassifierValue) element5).getClassifier();
												}).collect(Collectors.toList());
											}).collect(Collectors.toList());
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							})
							.findAny();
				}
				
				public static RecordOfListOfClassifier getValue(PropertyExpression propertyExpression) {
					return new RecordOfListOfClassifier(propertyExpression);
				}
				
				public Optional<List<Classifier>> getField1() {
					return field1;
				}
				
				public Optional<List<List<List<List<List<Classifier>>>>>> getField5() {
					return field5;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							field1,
							field5
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfListOfClassifier)) {
						return false;
					}
					RecordOfListOfClassifier other = (RecordOfListOfClassifier) obj;
					return Objects.equals(field1, other.field1)
							&& Objects.equals(field5, other.field5);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field1.ifPresent(field -> {
						builder.append("field1 => ");
						builder.append(field.stream().map(element1 -> {
							return "classifier (" + element1.getQualifiedName() + ")";
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					field5.ifPresent(field -> {
						builder.append("field5 => ");
						builder.append(field.stream().map(element1 -> {
							return element1.stream().map(element2 -> {
								return element2.stream().map(element3 -> {
									return element3.stream().map(element4 -> {
										return element4.stream().map(element5 -> {
											return "classifier (" + element5.getQualifiedName() + ")";
										}).collect(Collectors.joining(", ", "(", ")"));
									}).collect(Collectors.joining(", ", "(", ")"));
								}).collect(Collectors.joining(", ", "(", ")"));
							}).collect(Collectors.joining(", ", "(", ")"));
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val recordOfListOfIntegerNoUnits = '''
			package ps1;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			
			public class RecordOfListOfIntegerNoUnits {
				private final Optional<List<Long>> field;
				
				private RecordOfListOfIntegerNoUnits(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((IntegerLiteral) element1).getValue();
								}).collect(Collectors.toList());
							})
							.findAny();
				}
				
				public static RecordOfListOfIntegerNoUnits getValue(PropertyExpression propertyExpression) {
					return new RecordOfListOfIntegerNoUnits(propertyExpression);
				}
				
				public Optional<List<Long>> getField() {
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
					if (!(obj instanceof RecordOfListOfIntegerNoUnits)) {
						return false;
					}
					RecordOfListOfIntegerNoUnits other = (RecordOfListOfIntegerNoUnits) obj;
					return Objects.equals(field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field.ifPresent(field -> {
						builder.append("field => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val recordOfListOfRealNoUnits = '''
			package ps1;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			import org.osate.aadl2.RecordValue;
			
			public class RecordOfListOfRealNoUnits {
				private final Optional<List<Double>> field;
				
				private RecordOfListOfRealNoUnits(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((RealLiteral) element1).getValue();
								}).collect(Collectors.toList());
							})
							.findAny();
				}
				
				public static RecordOfListOfRealNoUnits getValue(PropertyExpression propertyExpression) {
					return new RecordOfListOfRealNoUnits(propertyExpression);
				}
				
				public Optional<List<Double>> getField() {
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
					if (!(obj instanceof RecordOfListOfRealNoUnits)) {
						return false;
					}
					RecordOfListOfRealNoUnits other = (RecordOfListOfRealNoUnits) obj;
					return Objects.equals(field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field.ifPresent(field -> {
						builder.append("field => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val recordOfListOfReference = '''
			package ps1;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
			
			public class RecordOfListOfReference {
				private final Optional<List<InstanceObject>> field1;
				private final Optional<List<List<List<List<List<InstanceObject>>>>>> field5;
				
				private RecordOfListOfReference(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field1 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field1"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((InstanceReferenceValue) element1).getReferencedInstanceObject();
								}).collect(Collectors.toList());
							})
							.findAny();
					field5 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field5"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((ListValue) element1).getOwnedListElements().stream().map(element2 -> {
										return ((ListValue) element2).getOwnedListElements().stream().map(element3 -> {
											return ((ListValue) element3).getOwnedListElements().stream().map(element4 -> {
												return ((ListValue) element4).getOwnedListElements().stream().map(element5 -> {
													return ((InstanceReferenceValue) element5).getReferencedInstanceObject();
												}).collect(Collectors.toList());
											}).collect(Collectors.toList());
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							})
							.findAny();
				}
				
				public static RecordOfListOfReference getValue(PropertyExpression propertyExpression) {
					return new RecordOfListOfReference(propertyExpression);
				}
				
				public Optional<List<InstanceObject>> getField1() {
					return field1;
				}
				
				public Optional<List<List<List<List<List<InstanceObject>>>>>> getField5() {
					return field5;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							field1,
							field5
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfListOfReference)) {
						return false;
					}
					RecordOfListOfReference other = (RecordOfListOfReference) obj;
					return Objects.equals(field1, other.field1)
							&& Objects.equals(field5, other.field5);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					field1.ifPresent(field -> {
						builder.append("field1 => ");
						builder.append(field.stream().map(element1 -> {
							return "reference (" + element1.getName() + ")";
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					field5.ifPresent(field -> {
						builder.append("field5 => ");
						builder.append(field.stream().map(element1 -> {
							return element1.stream().map(element2 -> {
								return element2.stream().map(element3 -> {
									return element3.stream().map(element4 -> {
										return element4.stream().map(element5 -> {
											return "reference (" + element5.getName() + ")";
										}).collect(Collectors.joining(", ", "(", ")"));
									}).collect(Collectors.joining(", ", "(", ")"));
								}).collect(Collectors.joining(", ", "(", ")"));
							}).collect(Collectors.joining(", ", "(", ")"));
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val recordOfListOfOwnedTypes = '''
			package ps1;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.OptionalLong;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.StringLiteral;
			import org.osate.aadl2.UnitLiteral;
			
			public class RecordOfListOfOwnedTypes {
				private final Optional<List<OwnedEnumType>> ownedEnum;
				private final Optional<List<OwnedUnitsType>> ownedUnits;
				private final Optional<List<OwnedIntegerWithUnitsType>> ownedIntegerWithUnits;
				private final Optional<List<OwnedRangeType>> ownedRange;
				private final Optional<List<OwnedRecordType>> ownedRecord;
				
				private RecordOfListOfOwnedTypes(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					ownedEnum = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_enum"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return OwnedEnumType.valueOf(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					ownedUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_units"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return OwnedUnitsType.valueOf(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					ownedIntegerWithUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_integer_with_units"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new OwnedIntegerWithUnitsType(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					ownedRange = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_range"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new OwnedRangeType(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					ownedRecord = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_record"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new OwnedRecordType(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
				}
				
				public static RecordOfListOfOwnedTypes getValue(PropertyExpression propertyExpression) {
					return new RecordOfListOfOwnedTypes(propertyExpression);
				}
				
				public Optional<List<OwnedEnumType>> getOwnedEnum() {
					return ownedEnum;
				}
				
				public Optional<List<OwnedUnitsType>> getOwnedUnits() {
					return ownedUnits;
				}
				
				public Optional<List<OwnedIntegerWithUnitsType>> getOwnedIntegerWithUnits() {
					return ownedIntegerWithUnits;
				}
				
				public Optional<List<OwnedRangeType>> getOwnedRange() {
					return ownedRange;
				}
				
				public Optional<List<OwnedRecordType>> getOwnedRecord() {
					return ownedRecord;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							ownedEnum,
							ownedUnits,
							ownedIntegerWithUnits,
							ownedRange,
							ownedRecord
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfListOfOwnedTypes)) {
						return false;
					}
					RecordOfListOfOwnedTypes other = (RecordOfListOfOwnedTypes) obj;
					return Objects.equals(ownedEnum, other.ownedEnum)
							&& Objects.equals(ownedUnits, other.ownedUnits)
							&& Objects.equals(ownedIntegerWithUnits, other.ownedIntegerWithUnits)
							&& Objects.equals(ownedRange, other.ownedRange)
							&& Objects.equals(ownedRecord, other.ownedRecord);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					ownedEnum.ifPresent(field -> {
						builder.append("owned_enum => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					ownedUnits.ifPresent(field -> {
						builder.append("owned_units => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					ownedIntegerWithUnits.ifPresent(field -> {
						builder.append("owned_integer_with_units => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					ownedRange.ifPresent(field -> {
						builder.append("owned_range => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					ownedRecord.ifPresent(field -> {
						builder.append("owned_record => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum OwnedEnumType {
					MERCURY("mercury"),
					GEMINI("gemini"),
					APOLLO("apollo");
					
					private final String originalName;
					
					private OwnedEnumType(String originalName) {
						this.originalName = originalName;
					}
					
					public static OwnedEnumType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum OwnedUnitsType {
					MS(1.0, "ms"),
					S(1000.0, "s");
					
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
				
				public static class OwnedIntegerWithUnitsType {
					private final long value;
					private final Time unit;
					
					private OwnedIntegerWithUnitsType(PropertyExpression propertyExpression) {
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
						if (!(obj instanceof OwnedIntegerWithUnitsType)) {
							return false;
						}
						OwnedIntegerWithUnitsType other = (OwnedIntegerWithUnitsType) obj;
						return value == other.value && unit == other.unit;
					}
					
					@Override
					public String toString() {
						return value + unit.toString();
					}
				}
				
				public static class OwnedRangeType {
					private final long minimum;
					private final long maximum;
					private final OptionalLong delta;
					
					private OwnedRangeType(PropertyExpression propertyExpression) {
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
						if (!(obj instanceof OwnedRangeType)) {
							return false;
						}
						OwnedRangeType other = (OwnedRangeType) obj;
						return minimum == other.minimum && maximum == other.maximum && Objects.equals(delta, other.delta);
					}
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
						delta.ifPresent(it -> builder.append(" delta " + it));
						return builder.toString();
					}
				}
				
				public static class OwnedRecordType {
					private final Optional<Boolean> booleanField;
					private final Optional<RecordFieldType> recordField;
					
					private OwnedRecordType(PropertyExpression propertyExpression) {
						RecordValue recordValue = (RecordValue) propertyExpression;
						booleanField = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("boolean_field"))
								.map(field -> ((BooleanLiteral) field.getOwnedValue()).getValue())
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
					
					public Optional<RecordFieldType> getRecordField() {
						return recordField;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(
								booleanField,
								recordField
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
						return Objects.equals(booleanField, other.booleanField)
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
						recordField.ifPresent(field -> {
							builder.append("record_field => ");
							builder.append(field);
							builder.append(';');
						});
						builder.append(']');
						return builder.toString();
					}
					
					public static class RecordFieldType {
						private final Optional<String> stringField;
						private final OptionalLong integerField;
						
						private RecordFieldType(PropertyExpression propertyExpression) {
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
							if (!(obj instanceof RecordFieldType)) {
								return false;
							}
							RecordFieldType other = (RecordFieldType) obj;
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
			}
		'''
		val recordOfListOfReferencedTypes = '''
			package ps1;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			
			import ps2.BasicRange;
			import ps2.BasicRecord;
			import ps2.Color;
			import ps2.Mass;
			import ps2.MassType;
			
			public class RecordOfListOfReferencedTypes {
				private final Optional<List<EnumType1>> enumNoImport;
				private final Optional<List<Color>> enumWithImport;
				private final Optional<List<Time>> unitsNoImport;
				private final Optional<List<Mass>> unitsWithImport;
				private final Optional<List<IntegerOwnedUnits>> numberWithUnitsNoImport;
				private final Optional<List<MassType>> numberWithUnitsWithImport;
				private final Optional<List<RangeOfIntegerNoUnits>> rangeNoImport;
				private final Optional<List<BasicRange>> rangeWithImport;
				private final Optional<List<RecordOfBoolean>> recordNoImport;
				private final Optional<List<BasicRecord>> recordWithImport;
				
				private RecordOfListOfReferencedTypes(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					enumNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("enum_no_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return EnumType1.valueOf(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					enumWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("enum_with_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return Color.valueOf(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					unitsNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("units_no_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return Time.valueOf(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					unitsWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("units_with_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return Mass.valueOf(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					numberWithUnitsNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("number_with_units_no_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return IntegerOwnedUnits.getValue(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					numberWithUnitsWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("number_with_units_with_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return MassType.getValue(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					rangeNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("range_no_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return RangeOfIntegerNoUnits.getValue(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					rangeWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("range_with_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return BasicRange.getValue(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					recordNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("record_no_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return RecordOfBoolean.getValue(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					recordWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("record_with_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return BasicRecord.getValue(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
				}
				
				public static RecordOfListOfReferencedTypes getValue(PropertyExpression propertyExpression) {
					return new RecordOfListOfReferencedTypes(propertyExpression);
				}
				
				public Optional<List<EnumType1>> getEnumNoImport() {
					return enumNoImport;
				}
				
				public Optional<List<Color>> getEnumWithImport() {
					return enumWithImport;
				}
				
				public Optional<List<Time>> getUnitsNoImport() {
					return unitsNoImport;
				}
				
				public Optional<List<Mass>> getUnitsWithImport() {
					return unitsWithImport;
				}
				
				public Optional<List<IntegerOwnedUnits>> getNumberWithUnitsNoImport() {
					return numberWithUnitsNoImport;
				}
				
				public Optional<List<MassType>> getNumberWithUnitsWithImport() {
					return numberWithUnitsWithImport;
				}
				
				public Optional<List<RangeOfIntegerNoUnits>> getRangeNoImport() {
					return rangeNoImport;
				}
				
				public Optional<List<BasicRange>> getRangeWithImport() {
					return rangeWithImport;
				}
				
				public Optional<List<RecordOfBoolean>> getRecordNoImport() {
					return recordNoImport;
				}
				
				public Optional<List<BasicRecord>> getRecordWithImport() {
					return recordWithImport;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							enumNoImport,
							enumWithImport,
							unitsNoImport,
							unitsWithImport,
							numberWithUnitsNoImport,
							numberWithUnitsWithImport,
							rangeNoImport,
							rangeWithImport,
							recordNoImport,
							recordWithImport
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordOfListOfReferencedTypes)) {
						return false;
					}
					RecordOfListOfReferencedTypes other = (RecordOfListOfReferencedTypes) obj;
					return Objects.equals(enumNoImport, other.enumNoImport)
							&& Objects.equals(enumWithImport, other.enumWithImport)
							&& Objects.equals(unitsNoImport, other.unitsNoImport)
							&& Objects.equals(unitsWithImport, other.unitsWithImport)
							&& Objects.equals(numberWithUnitsNoImport, other.numberWithUnitsNoImport)
							&& Objects.equals(numberWithUnitsWithImport, other.numberWithUnitsWithImport)
							&& Objects.equals(rangeNoImport, other.rangeNoImport)
							&& Objects.equals(rangeWithImport, other.rangeWithImport)
							&& Objects.equals(recordNoImport, other.recordNoImport)
							&& Objects.equals(recordWithImport, other.recordWithImport);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					enumNoImport.ifPresent(field -> {
						builder.append("enum_no_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					enumWithImport.ifPresent(field -> {
						builder.append("enum_with_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					unitsNoImport.ifPresent(field -> {
						builder.append("units_no_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					unitsWithImport.ifPresent(field -> {
						builder.append("units_with_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					numberWithUnitsNoImport.ifPresent(field -> {
						builder.append("number_with_units_no_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					numberWithUnitsWithImport.ifPresent(field -> {
						builder.append("number_with_units_with_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					rangeNoImport.ifPresent(field -> {
						builder.append("range_no_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					rangeWithImport.ifPresent(field -> {
						builder.append("range_with_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					recordNoImport.ifPresent(field -> {
						builder.append("record_no_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					recordWithImport.ifPresent(field -> {
						builder.append("record_with_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
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
		
		assertEquals("RangeOfIntegerNoUnits.java", results.get(3).fileName)
		assertEquals(rangeOfIntegerNoUnits.toString, results.get(3).contents)
		
		assertEquals("RecordOfBoolean.java", results.get(4).fileName)
		assertEquals(recordOfBoolean.toString, results.get(4).contents)
		
		assertEquals("RecordOfListOfBoolean.java", results.get(5).fileName)
		assertEquals(recordOfListOfBoolean.toString, results.get(5).contents)
		
		assertEquals("RecordOfListOfString.java", results.get(6).fileName)
		assertEquals(recordOfListOfString.toString, results.get(6).contents)
		
		assertEquals("RecordOfListOfClassifier.java", results.get(7).fileName)
		assertEquals(recordOfListOfClassifier.toString, results.get(7).contents)
		
		assertEquals("RecordOfListOfIntegerNoUnits.java", results.get(8).fileName)
		assertEquals(recordOfListOfIntegerNoUnits.toString, results.get(8).contents)
		
		assertEquals("RecordOfListOfRealNoUnits.java", results.get(9).fileName)
		assertEquals(recordOfListOfRealNoUnits.toString, results.get(9).contents)
		
		assertEquals("RecordOfListOfReference.java", results.get(10).fileName)
		assertEquals(recordOfListOfReference.toString, results.get(10).contents)
		
		assertEquals("RecordOfListOfOwnedTypes.java", results.get(11).fileName)
		assertEquals(recordOfListOfOwnedTypes.toString, results.get(11).contents)
		
		assertEquals("RecordOfListOfReferencedTypes.java", results.get(12).fileName)
		assertEquals(recordOfListOfReferencedTypes.toString, results.get(12).contents)
	}
}