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
				
				public RecordOfListOfBoolean(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field1 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field1"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((BooleanLiteral) element1).getValue();
								}).collect(Collectors.toList());
							})
							.findAny();
					this.field2 = recordValue.getOwnedFieldValues()
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
					this.field3 = recordValue.getOwnedFieldValues()
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
					this.field4 = recordValue.getOwnedFieldValues()
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
					this.field5 = recordValue.getOwnedFieldValues()
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
					return Objects.equals(this.field1, other.field1)
							&& Objects.equals(this.field2, other.field2)
							&& Objects.equals(this.field3, other.field3)
							&& Objects.equals(this.field4, other.field4)
							&& Objects.equals(this.field5, other.field5);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field1.ifPresent(field -> {
						builder.append("field1 => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.field2.ifPresent(field -> {
						builder.append("field2 => ");
						builder.append(field.stream().map(element1 -> {
							return element1.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"));
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.field3.ifPresent(field -> {
						builder.append("field3 => ");
						builder.append(field.stream().map(element1 -> {
							return element1.stream().map(element2 -> {
								return element2.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"));
							}).collect(Collectors.joining(", ", "(", ")"));
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.field4.ifPresent(field -> {
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
					this.field5.ifPresent(field -> {
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
				
				public RecordOfListOfString(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field1 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field1"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((StringLiteral) element1).getValue();
								}).collect(Collectors.toList());
							})
							.findAny();
					this.field5 = recordValue.getOwnedFieldValues()
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
					return Objects.equals(this.field1, other.field1)
							&& Objects.equals(this.field5, other.field5);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field1.ifPresent(field -> {
						builder.append("field1 => ");
						builder.append(field.stream().map(element1 -> {
							return '\"' + element1 + '\"';
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.field5.ifPresent(field -> {
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
				
				public RecordOfListOfClassifier(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field1 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field1"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((ClassifierValue) element1).getClassifier();
								}).collect(Collectors.toList());
							})
							.findAny();
					this.field5 = recordValue.getOwnedFieldValues()
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
					return Objects.equals(this.field1, other.field1)
							&& Objects.equals(this.field5, other.field5);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field1.ifPresent(field -> {
						builder.append("field1 => ");
						builder.append(field.stream().map(element1 -> {
							return "classifier (" + element1.getQualifiedName() + ")";
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.field5.ifPresent(field -> {
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
				
				public RecordOfListOfIntegerNoUnits(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((IntegerLiteral) element1).getValue();
								}).collect(Collectors.toList());
							})
							.findAny();
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
					return Objects.equals(this.field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field.ifPresent(field -> {
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
				
				public RecordOfListOfRealNoUnits(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((RealLiteral) element1).getValue();
								}).collect(Collectors.toList());
							})
							.findAny();
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
					return Objects.equals(this.field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field.ifPresent(field -> {
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
				
				public RecordOfListOfReference(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field1 = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field1"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return ((InstanceReferenceValue) element1).getReferencedInstanceObject();
								}).collect(Collectors.toList());
							})
							.findAny();
					this.field5 = recordValue.getOwnedFieldValues()
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
					return Objects.equals(this.field1, other.field1)
							&& Objects.equals(this.field5, other.field5);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field1.ifPresent(field -> {
						builder.append("field1 => ");
						builder.append(field.stream().map(element1 -> {
							return "reference (" + element1.getName() + ")";
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.field5.ifPresent(field -> {
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
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.StringLiteral;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			import org.osate.pluginsupport.properties.IntegerRange;
			import org.osate.pluginsupport.properties.IntegerWithUnits;
			
			public class RecordOfListOfOwnedTypes {
				private final Optional<List<OwnedEnum_FieldType>> ownedEnum;
				private final Optional<List<OwnedUnits_FieldType>> ownedUnits;
				private final Optional<List<IntegerWithUnits<Time>>> ownedIntegerWithUnits;
				private final Optional<List<IntegerRange>> ownedRange;
				private final Optional<List<OwnedRecord_FieldType>> ownedRecord;
				
				public RecordOfListOfOwnedTypes(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.ownedEnum = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_enum"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return OwnedEnum_FieldType.valueOf(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.ownedUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_units"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return OwnedUnits_FieldType.valueOf(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.ownedIntegerWithUnits = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_integer_with_units"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new IntegerWithUnits<>(element1, Time.class);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.ownedRange = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_range"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new IntegerRange(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.ownedRecord = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned_record"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new OwnedRecord_FieldType(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
				}
				
				public Optional<List<OwnedEnum_FieldType>> getOwnedEnum() {
					return ownedEnum;
				}
				
				public Optional<List<OwnedUnits_FieldType>> getOwnedUnits() {
					return ownedUnits;
				}
				
				public Optional<List<IntegerWithUnits<Time>>> getOwnedIntegerWithUnits() {
					return ownedIntegerWithUnits;
				}
				
				public Optional<List<IntegerRange>> getOwnedRange() {
					return ownedRange;
				}
				
				public Optional<List<OwnedRecord_FieldType>> getOwnedRecord() {
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
					return Objects.equals(this.ownedEnum, other.ownedEnum)
							&& Objects.equals(this.ownedUnits, other.ownedUnits)
							&& Objects.equals(this.ownedIntegerWithUnits, other.ownedIntegerWithUnits)
							&& Objects.equals(this.ownedRange, other.ownedRange)
							&& Objects.equals(this.ownedRecord, other.ownedRecord);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.ownedEnum.ifPresent(field -> {
						builder.append("owned_enum => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.ownedUnits.ifPresent(field -> {
						builder.append("owned_units => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.ownedIntegerWithUnits.ifPresent(field -> {
						builder.append("owned_integer_with_units => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.ownedRange.ifPresent(field -> {
						builder.append("owned_range => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.ownedRecord.ifPresent(field -> {
						builder.append("owned_record => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum OwnedEnum_FieldType {
					MERCURY("mercury"),
					GEMINI("gemini"),
					APOLLO("apollo");
					
					private final String originalName;
					
					private OwnedEnum_FieldType(String originalName) {
						this.originalName = originalName;
					}
					
					public static OwnedEnum_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum OwnedUnits_FieldType implements GeneratedUnits {
					MS(1.0, "ms"),
					S(1000.0, "s");
					
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
					private final Optional<Boolean> booleanField;
					private final Optional<RecordField_FieldType> recordField;
					
					public OwnedRecord_FieldType(PropertyExpression propertyExpression) {
						RecordValue recordValue = (RecordValue) propertyExpression;
						this.booleanField = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("boolean_field"))
								.map(field -> ((BooleanLiteral) field.getOwnedValue()).getValue())
								.findAny();
						this.recordField = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("record_field"))
								.map(field -> new RecordField_FieldType(field.getOwnedValue()))
								.findAny();
					}
					
					public Optional<Boolean> getBooleanField() {
						return booleanField;
					}
					
					public Optional<RecordField_FieldType> getRecordField() {
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
						if (!(obj instanceof OwnedRecord_FieldType)) {
							return false;
						}
						OwnedRecord_FieldType other = (OwnedRecord_FieldType) obj;
						return Objects.equals(this.booleanField, other.booleanField)
								&& Objects.equals(this.recordField, other.recordField);
					}
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder();
						builder.append('[');
						this.booleanField.ifPresent(field -> {
							builder.append("boolean_field => ");
							builder.append(field);
							builder.append(';');
						});
						this.recordField.ifPresent(field -> {
							builder.append("record_field => ");
							builder.append(field);
							builder.append(';');
						});
						builder.append(']');
						return builder.toString();
					}
					
					public static class RecordField_FieldType {
						private final Optional<String> stringField;
						private final OptionalLong integerField;
						
						public RecordField_FieldType(PropertyExpression propertyExpression) {
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
							if (!(obj instanceof RecordField_FieldType)) {
								return false;
							}
							RecordField_FieldType other = (RecordField_FieldType) obj;
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
			import org.osate.pluginsupport.properties.IntegerRange;
			import org.osate.pluginsupport.properties.IntegerWithUnits;
			import org.osate.pluginsupport.properties.RealRange;
			import org.osate.pluginsupport.properties.RealWithUnits;
			
			import ps2.BasicRecord;
			import ps2.Color;
			import ps2.Mass;
			
			public class RecordOfListOfReferencedTypes {
				private final Optional<List<EnumType1>> enumNoImport;
				private final Optional<List<Color>> enumWithImport;
				private final Optional<List<Time>> unitsNoImport;
				private final Optional<List<Mass>> unitsWithImport;
				private final Optional<List<IntegerWithUnits<IntegerOwnedUnits>>> numberWithUnitsNoImport;
				private final Optional<List<RealWithUnits<Mass>>> numberWithUnitsWithImport;
				private final Optional<List<IntegerRange>> rangeNoImport;
				private final Optional<List<RealRange>> rangeWithImport;
				private final Optional<List<RecordOfBoolean>> recordNoImport;
				private final Optional<List<BasicRecord>> recordWithImport;
				
				public RecordOfListOfReferencedTypes(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.enumNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("enum_no_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return EnumType1.valueOf(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.enumWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("enum_with_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return Color.valueOf(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.unitsNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("units_no_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return Time.valueOf(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.unitsWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("units_with_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return Mass.valueOf(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.numberWithUnitsNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("number_with_units_no_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new IntegerWithUnits<>(element1, IntegerOwnedUnits.class);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.numberWithUnitsWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("number_with_units_with_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new RealWithUnits<>(element1, Mass.class);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.rangeNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("range_no_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new IntegerRange(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.rangeWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("range_with_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new RealRange(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.recordNoImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("record_no_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new RecordOfBoolean(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.recordWithImport = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("record_with_import"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new BasicRecord(element1);
								}).collect(Collectors.toList());
							})
							.findAny();
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
				
				public Optional<List<IntegerWithUnits<IntegerOwnedUnits>>> getNumberWithUnitsNoImport() {
					return numberWithUnitsNoImport;
				}
				
				public Optional<List<RealWithUnits<Mass>>> getNumberWithUnitsWithImport() {
					return numberWithUnitsWithImport;
				}
				
				public Optional<List<IntegerRange>> getRangeNoImport() {
					return rangeNoImport;
				}
				
				public Optional<List<RealRange>> getRangeWithImport() {
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
					return Objects.equals(this.enumNoImport, other.enumNoImport)
							&& Objects.equals(this.enumWithImport, other.enumWithImport)
							&& Objects.equals(this.unitsNoImport, other.unitsNoImport)
							&& Objects.equals(this.unitsWithImport, other.unitsWithImport)
							&& Objects.equals(this.numberWithUnitsNoImport, other.numberWithUnitsNoImport)
							&& Objects.equals(this.numberWithUnitsWithImport, other.numberWithUnitsWithImport)
							&& Objects.equals(this.rangeNoImport, other.rangeNoImport)
							&& Objects.equals(this.rangeWithImport, other.rangeWithImport)
							&& Objects.equals(this.recordNoImport, other.recordNoImport)
							&& Objects.equals(this.recordWithImport, other.recordWithImport);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.enumNoImport.ifPresent(field -> {
						builder.append("enum_no_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.enumWithImport.ifPresent(field -> {
						builder.append("enum_with_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.unitsNoImport.ifPresent(field -> {
						builder.append("units_no_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.unitsWithImport.ifPresent(field -> {
						builder.append("units_with_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.numberWithUnitsNoImport.ifPresent(field -> {
						builder.append("number_with_units_no_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.numberWithUnitsWithImport.ifPresent(field -> {
						builder.append("number_with_units_with_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.rangeNoImport.ifPresent(field -> {
						builder.append("range_no_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.rangeWithImport.ifPresent(field -> {
						builder.append("range_with_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.recordNoImport.ifPresent(field -> {
						builder.append("record_no_import => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.recordWithImport.ifPresent(field -> {
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
		assertEquals(12, results.size)
		
		assertEquals("Time.java", results.get(0).fileName)
		assertEquals(time.toString, results.get(0).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.get(1).fileName)
		assertEquals(integerOwnedUnits.toString, results.get(1).contents)
		
		assertEquals("EnumType1.java", results.get(2).fileName)
		assertEquals(enumType1.toString, results.get(2).contents)
		
		assertEquals("RecordOfBoolean.java", results.get(3).fileName)
		assertEquals(recordOfBoolean.toString, results.get(3).contents)
		
		assertEquals("RecordOfListOfBoolean.java", results.get(4).fileName)
		assertEquals(recordOfListOfBoolean.toString, results.get(4).contents)
		
		assertEquals("RecordOfListOfString.java", results.get(5).fileName)
		assertEquals(recordOfListOfString.toString, results.get(5).contents)
		
		assertEquals("RecordOfListOfClassifier.java", results.get(6).fileName)
		assertEquals(recordOfListOfClassifier.toString, results.get(6).contents)
		
		assertEquals("RecordOfListOfIntegerNoUnits.java", results.get(7).fileName)
		assertEquals(recordOfListOfIntegerNoUnits.toString, results.get(7).contents)
		
		assertEquals("RecordOfListOfRealNoUnits.java", results.get(8).fileName)
		assertEquals(recordOfListOfRealNoUnits.toString, results.get(8).contents)
		
		assertEquals("RecordOfListOfReference.java", results.get(9).fileName)
		assertEquals(recordOfListOfReference.toString, results.get(9).contents)
		
		assertEquals("RecordOfListOfOwnedTypes.java", results.get(10).fileName)
		assertEquals(recordOfListOfOwnedTypes.toString, results.get(10).contents)
		
		assertEquals("RecordOfListOfReferencedTypes.java", results.get(11).fileName)
		assertEquals(recordOfListOfReferencedTypes.toString, results.get(11).contents)
	}
}