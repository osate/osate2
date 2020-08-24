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
		val ps1Class = '''
			package ps1;
			
			public class Ps1 {
				public static final String PS1__NAME = "ps1";
			}
		'''
		val time = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum Time implements GeneratedUnits<Time> {
				SEC(1.0, "sec", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				MIN(60.0, "min", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				HR(3600.0, "hr", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
				DAY(86400.0, "day", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private Time(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
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
				public double getFactorTo(Time target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val integerOwnedUnits = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum IntegerOwnedUnits implements GeneratedUnits<IntegerOwnedUnits> {
				MM(1.0, "mm", "__synthetic1.aadl#/0/@ownedPropertyType.1/@ownedUnitsType/@ownedLiteral.0"),
				CM(10.0, "cm", "__synthetic1.aadl#/0/@ownedPropertyType.1/@ownedUnitsType/@ownedLiteral.1"),
				M(1000.0, "m", "__synthetic1.aadl#/0/@ownedPropertyType.1/@ownedUnitsType/@ownedLiteral.2");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private IntegerOwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
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
				public double getFactorTo(IntegerOwnedUnits target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
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
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.pluginsupport.properties.GeneratedEnumeration;
			
			public enum EnumType1 implements GeneratedEnumeration {
				ONE("one", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedLiteral.0"),
				TWO("two", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedLiteral.1"),
				THREE("three", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedLiteral.2");
				
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
				
				@Override
				public URI getURI() {
					return uri;
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
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.BasicPropertyAssociation;
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.GeneratedRecord;
			
			public class RecordOfBoolean extends GeneratedRecord {
				public static final String FIELD__NAME = "field";
				public static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.4/@ownedField.0");
				
				private final Optional<Boolean> field;
				
				public RecordOfBoolean(Optional<Boolean> field) {
					this.field = field;
				}
				
				public RecordOfBoolean(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<Boolean> field_local;
					try {
						field_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((BooleanLiteral) resolved).getValue();
						});
					} catch (PropertyNotPresentException e) {
						field_local = Optional.empty();
					}
					this.field = field_local;
				}
				
				public Optional<Boolean> getField() {
					return field;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!field.isPresent()) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					field.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD__URI, FIELD__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
					});
					return recordValue;
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
						builder.append(FIELD__NAME);
						builder.append(" => ");
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
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.BasicPropertyAssociation;
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
				public static final String FIELD1__NAME = "field1";
				public static final String FIELD2__NAME = "field2";
				public static final String FIELD3__NAME = "field3";
				public static final String FIELD4__NAME = "field4";
				public static final String FIELD5__NAME = "field5";
				public static final URI FIELD1__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedField.0");
				public static final URI FIELD2__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedField.1");
				public static final URI FIELD3__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedField.2");
				public static final URI FIELD4__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedField.3");
				public static final URI FIELD5__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedField.4");
				
				private final Optional<List<Boolean>> field1;
				private final Optional<List<List<Boolean>>> field2;
				private final Optional<List<List<List<Boolean>>>> field3;
				private final Optional<List<List<List<List<Boolean>>>>> field4;
				private final Optional<List<List<List<List<List<Boolean>>>>>> field5;
				
				public RecordOfListOfBoolean(
						Optional<List<Boolean>> field1,
						Optional<List<List<Boolean>>> field2,
						Optional<List<List<List<Boolean>>>> field3,
						Optional<List<List<List<List<Boolean>>>>> field4,
						Optional<List<List<List<List<List<Boolean>>>>>> field5
				) {
					this.field1 = field1;
					this.field2 = field2;
					this.field3 = field3;
					this.field4 = field4;
					this.field5 = field5;
				}
				
				public RecordOfListOfBoolean(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<List<Boolean>> field1_local;
					try {
						field1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((BooleanLiteral) resolved1).getValue();
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						field1_local = Optional.empty();
					}
					this.field1 = field1_local;
					
					Optional<List<List<Boolean>>> field2_local;
					try {
						field2_local = findFieldValue(recordValue, FIELD2__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
									PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
									return ((BooleanLiteral) resolved2).getValue();
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						field2_local = Optional.empty();
					}
					this.field2 = field2_local;
					
					Optional<List<List<List<Boolean>>>> field3_local;
					try {
						field3_local = findFieldValue(recordValue, FIELD3__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
									PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
									return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
										PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
										return ((BooleanLiteral) resolved3).getValue();
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						field3_local = Optional.empty();
					}
					this.field3 = field3_local;
					
					Optional<List<List<List<List<Boolean>>>>> field4_local;
					try {
						field4_local = findFieldValue(recordValue, FIELD4__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
									PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
									return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
										PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
										return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
											PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
											return ((BooleanLiteral) resolved4).getValue();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						field4_local = Optional.empty();
					}
					this.field4 = field4_local;
					
					Optional<List<List<List<List<List<Boolean>>>>>> field5_local;
					try {
						field5_local = findFieldValue(recordValue, FIELD5__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
									PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
									return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
										PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
										return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
											PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
											return ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
												PropertyExpression resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
												return ((BooleanLiteral) resolved5).getValue();
											}).collect(Collectors.toList());
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						field5_local = Optional.empty();
					}
					this.field5 = field5_local;
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
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!field1.isPresent()
							&& !field2.isPresent()
							&& !field3.isPresent()
							&& !field4.isPresent()
							&& !field5.isPresent()
					) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					field1.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD1__URI, FIELD1__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1);
						}));
					});
					field2.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD2__URI, FIELD2__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1, element2 -> {
								return CodeGenUtil.toPropertyExpression(element2);
							});
						}));
					});
					field3.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD3__URI, FIELD3__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1, element2 -> {
								return CodeGenUtil.toPropertyExpression(element2, element3 -> {
									return CodeGenUtil.toPropertyExpression(element3);
								});
							});
						}));
					});
					field4.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD4__URI, FIELD4__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1, element2 -> {
								return CodeGenUtil.toPropertyExpression(element2, element3 -> {
									return CodeGenUtil.toPropertyExpression(element3, element4 -> {
										return CodeGenUtil.toPropertyExpression(element4);
									});
								});
							});
						}));
					});
					field5.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD5__URI, FIELD5__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1, element2 -> {
								return CodeGenUtil.toPropertyExpression(element2, element3 -> {
									return CodeGenUtil.toPropertyExpression(element3, element4 -> {
										return CodeGenUtil.toPropertyExpression(element4, element5 -> {
											return CodeGenUtil.toPropertyExpression(element5);
										});
									});
								});
							});
						}));
					});
					return recordValue;
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
						builder.append(FIELD1__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.field2.ifPresent(field -> {
						builder.append(FIELD2__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(element1 -> {
							return element1.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"));
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.field3.ifPresent(field -> {
						builder.append(FIELD3__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(element1 -> {
							return element1.stream().map(element2 -> {
								return element2.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"));
							}).collect(Collectors.joining(", ", "(", ")"));
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.field4.ifPresent(field -> {
						builder.append(FIELD4__NAME);
						builder.append(" => ");
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
						builder.append(FIELD5__NAME);
						builder.append(" => ");
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
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.BasicPropertyAssociation;
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
				public static final String FIELD1__NAME = "field1";
				public static final String FIELD5__NAME = "field5";
				public static final URI FIELD1__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.6/@ownedField.0");
				public static final URI FIELD5__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.6/@ownedField.1");
				
				private final Optional<List<String>> field1;
				private final Optional<List<List<List<List<List<String>>>>>> field5;
				
				public RecordOfListOfString(
						Optional<List<String>> field1,
						Optional<List<List<List<List<List<String>>>>>> field5
				) {
					this.field1 = field1;
					this.field5 = field5;
				}
				
				public RecordOfListOfString(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<List<String>> field1_local;
					try {
						field1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((StringLiteral) resolved1).getValue();
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						field1_local = Optional.empty();
					}
					this.field1 = field1_local;
					
					Optional<List<List<List<List<List<String>>>>>> field5_local;
					try {
						field5_local = findFieldValue(recordValue, FIELD5__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
									PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
									return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
										PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
										return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
											PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
											return ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
												PropertyExpression resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
												return ((StringLiteral) resolved5).getValue();
											}).collect(Collectors.toList());
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						field5_local = Optional.empty();
					}
					this.field5 = field5_local;
				}
				
				public Optional<List<String>> getField1() {
					return field1;
				}
				
				public Optional<List<List<List<List<List<String>>>>>> getField5() {
					return field5;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!field1.isPresent()
							&& !field5.isPresent()
					) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					field1.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD1__URI, FIELD1__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1);
						}));
					});
					field5.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD5__URI, FIELD5__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1, element2 -> {
								return CodeGenUtil.toPropertyExpression(element2, element3 -> {
									return CodeGenUtil.toPropertyExpression(element3, element4 -> {
										return CodeGenUtil.toPropertyExpression(element4, element5 -> {
											return CodeGenUtil.toPropertyExpression(element5);
										});
									});
								});
							});
						}));
					});
					return recordValue;
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
						builder.append(FIELD1__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(element1 -> {
							return '\"' + element1 + '\"';
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.field5.ifPresent(field -> {
						builder.append(FIELD5__NAME);
						builder.append(" => ");
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
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.BasicPropertyAssociation;
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
				public static final String FIELD1__NAME = "field1";
				public static final String FIELD5__NAME = "field5";
				public static final URI FIELD1__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.7/@ownedField.0");
				public static final URI FIELD5__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.7/@ownedField.1");
				
				private final Optional<List<Classifier>> field1;
				private final Optional<List<List<List<List<List<Classifier>>>>>> field5;
				
				public RecordOfListOfClassifier(
						Optional<List<Classifier>> field1,
						Optional<List<List<List<List<List<Classifier>>>>>> field5
				) {
					this.field1 = field1;
					this.field5 = field5;
				}
				
				public RecordOfListOfClassifier(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<List<Classifier>> field1_local;
					try {
						field1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((ClassifierValue) resolved1).getClassifier();
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						field1_local = Optional.empty();
					}
					this.field1 = field1_local;
					
					Optional<List<List<List<List<List<Classifier>>>>>> field5_local;
					try {
						field5_local = findFieldValue(recordValue, FIELD5__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
									PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
									return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
										PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
										return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
											PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
											return ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
												PropertyExpression resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
												return ((ClassifierValue) resolved5).getClassifier();
											}).collect(Collectors.toList());
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						field5_local = Optional.empty();
					}
					this.field5 = field5_local;
				}
				
				public Optional<List<Classifier>> getField1() {
					return field1;
				}
				
				public Optional<List<List<List<List<List<Classifier>>>>>> getField5() {
					return field5;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!field1.isPresent()
							&& !field5.isPresent()
					) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					field1.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD1__URI, FIELD1__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1);
						}));
					});
					field5.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD5__URI, FIELD5__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1, element2 -> {
								return CodeGenUtil.toPropertyExpression(element2, element3 -> {
									return CodeGenUtil.toPropertyExpression(element3, element4 -> {
										return CodeGenUtil.toPropertyExpression(element4, element5 -> {
											return CodeGenUtil.toPropertyExpression(element5);
										});
									});
								});
							});
						}));
					});
					return recordValue;
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
						builder.append(FIELD1__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(element1 -> {
							return "classifier (" + element1.getQualifiedName() + ")";
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.field5.ifPresent(field -> {
						builder.append(FIELD5__NAME);
						builder.append(" => ");
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
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.BasicPropertyAssociation;
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
				public static final String FIELD__NAME = "field";
				public static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.8/@ownedField.0");
				
				private final Optional<List<Long>> field;
				
				public RecordOfListOfIntegerNoUnits(Optional<List<Long>> field) {
					this.field = field;
				}
				
				public RecordOfListOfIntegerNoUnits(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<List<Long>> field_local;
					try {
						field_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((IntegerLiteral) resolved1).getValue();
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						field_local = Optional.empty();
					}
					this.field = field_local;
				}
				
				public Optional<List<Long>> getField() {
					return field;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!field.isPresent()) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					field.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD__URI, FIELD__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1);
						}));
					});
					return recordValue;
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
						builder.append(FIELD__NAME);
						builder.append(" => ");
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
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.BasicPropertyAssociation;
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
				public static final String FIELD__NAME = "field";
				public static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedField.0");
				
				private final Optional<List<Double>> field;
				
				public RecordOfListOfRealNoUnits(Optional<List<Double>> field) {
					this.field = field;
				}
				
				public RecordOfListOfRealNoUnits(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<List<Double>> field_local;
					try {
						field_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((RealLiteral) resolved1).getValue();
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						field_local = Optional.empty();
					}
					this.field = field_local;
				}
				
				public Optional<List<Double>> getField() {
					return field;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!field.isPresent()) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					field.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD__URI, FIELD__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1);
						}));
					});
					return recordValue;
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
						builder.append(FIELD__NAME);
						builder.append(" => ");
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
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.BasicPropertyAssociation;
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
				public static final String FIELD1__NAME = "field1";
				public static final String FIELD5__NAME = "field5";
				public static final URI FIELD1__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.10/@ownedField.0");
				public static final URI FIELD5__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.10/@ownedField.1");
				
				private final Optional<List<InstanceObject>> field1;
				private final Optional<List<List<List<List<List<InstanceObject>>>>>> field5;
				
				public RecordOfListOfReference(
						Optional<List<InstanceObject>> field1,
						Optional<List<List<List<List<List<InstanceObject>>>>>> field5
				) {
					this.field1 = field1;
					this.field5 = field5;
				}
				
				public RecordOfListOfReference(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<List<InstanceObject>> field1_local;
					try {
						field1_local = findFieldValue(recordValue, FIELD1__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						field1_local = Optional.empty();
					}
					this.field1 = field1_local;
					
					Optional<List<List<List<List<List<InstanceObject>>>>>> field5_local;
					try {
						field5_local = findFieldValue(recordValue, FIELD5__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
									PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
									return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
										PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
										return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
											PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
											return ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
												PropertyExpression resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
												return ((InstanceReferenceValue) resolved5).getReferencedInstanceObject();
											}).collect(Collectors.toList());
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						field5_local = Optional.empty();
					}
					this.field5 = field5_local;
				}
				
				public Optional<List<InstanceObject>> getField1() {
					return field1;
				}
				
				public Optional<List<List<List<List<List<InstanceObject>>>>>> getField5() {
					return field5;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!field1.isPresent()
							&& !field5.isPresent()
					) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					field1.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD1__URI, FIELD1__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1);
						}));
					});
					field5.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD5__URI, FIELD5__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1, element2 -> {
								return CodeGenUtil.toPropertyExpression(element2, element3 -> {
									return CodeGenUtil.toPropertyExpression(element3, element4 -> {
										return CodeGenUtil.toPropertyExpression(element4, element5 -> {
											return CodeGenUtil.toPropertyExpression(element5);
										});
									});
								});
							});
						}));
					});
					return recordValue;
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
						builder.append(FIELD1__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(element1 -> {
							return "reference (" + element1.getName() + ")";
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.field5.ifPresent(field -> {
						builder.append(FIELD5__NAME);
						builder.append(" => ");
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
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.BasicPropertyAssociation;
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
				public static final String OWNED_ENUM__NAME = "owned_enum";
				public static final String OWNED_UNITS__NAME = "owned_units";
				public static final String OWNED_INTEGER_WITH_UNITS__NAME = "owned_integer_with_units";
				public static final String OWNED_RANGE__NAME = "owned_range";
				public static final String OWNED_RECORD__NAME = "owned_record";
				public static final URI OWNED_ENUM__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.0");
				public static final URI OWNED_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.1");
				public static final URI OWNED_INTEGER_WITH_UNITS__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.2");
				public static final URI OWNED_RANGE__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.3");
				public static final URI OWNED_RECORD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.4");
				
				private final Optional<List<OwnedEnum_FieldType>> ownedEnum;
				private final Optional<List<OwnedUnits_FieldType>> ownedUnits;
				private final Optional<List<IntegerWithUnits<Time>>> ownedIntegerWithUnits;
				private final Optional<List<IntegerRange>> ownedRange;
				private final Optional<List<OwnedRecord_FieldType>> ownedRecord;
				
				public RecordOfListOfOwnedTypes(
						Optional<List<OwnedEnum_FieldType>> ownedEnum,
						Optional<List<OwnedUnits_FieldType>> ownedUnits,
						Optional<List<IntegerWithUnits<Time>>> ownedIntegerWithUnits,
						Optional<List<IntegerRange>> ownedRange,
						Optional<List<OwnedRecord_FieldType>> ownedRecord
				) {
					this.ownedEnum = ownedEnum;
					this.ownedUnits = ownedUnits;
					this.ownedIntegerWithUnits = ownedIntegerWithUnits;
					this.ownedRange = ownedRange;
					this.ownedRecord = ownedRecord;
				}
				
				public RecordOfListOfOwnedTypes(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<List<OwnedEnum_FieldType>> ownedEnum_local;
					try {
						ownedEnum_local = findFieldValue(recordValue, OWNED_ENUM__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return OwnedEnum_FieldType.valueOf(resolved1);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						ownedEnum_local = Optional.empty();
					}
					this.ownedEnum = ownedEnum_local;
					
					Optional<List<OwnedUnits_FieldType>> ownedUnits_local;
					try {
						ownedUnits_local = findFieldValue(recordValue, OWNED_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return OwnedUnits_FieldType.valueOf(resolved1);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						ownedUnits_local = Optional.empty();
					}
					this.ownedUnits = ownedUnits_local;
					
					Optional<List<IntegerWithUnits<Time>>> ownedIntegerWithUnits_local;
					try {
						ownedIntegerWithUnits_local = findFieldValue(recordValue, OWNED_INTEGER_WITH_UNITS__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerWithUnits<>(resolved1, Time.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						ownedIntegerWithUnits_local = Optional.empty();
					}
					this.ownedIntegerWithUnits = ownedIntegerWithUnits_local;
					
					Optional<List<IntegerRange>> ownedRange_local;
					try {
						ownedRange_local = findFieldValue(recordValue, OWNED_RANGE__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerRange(resolved1, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						ownedRange_local = Optional.empty();
					}
					this.ownedRange = ownedRange_local;
					
					Optional<List<OwnedRecord_FieldType>> ownedRecord_local;
					try {
						ownedRecord_local = findFieldValue(recordValue, OWNED_RECORD__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new OwnedRecord_FieldType(resolved1, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						ownedRecord_local = Optional.empty();
					}
					this.ownedRecord = ownedRecord_local;
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
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!ownedEnum.isPresent()
							&& !ownedUnits.isPresent()
							&& !ownedIntegerWithUnits.isPresent()
							&& !ownedRange.isPresent()
							&& !ownedRecord.isPresent()
					) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					ownedEnum.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, OWNED_ENUM__URI, OWNED_ENUM__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					ownedUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, OWNED_UNITS__URI, OWNED_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					ownedIntegerWithUnits.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, OWNED_INTEGER_WITH_UNITS__URI, OWNED_INTEGER_WITH_UNITS__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					ownedRange.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, OWNED_RANGE__URI, OWNED_RANGE__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression();
						}));
					});
					ownedRecord.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, OWNED_RECORD__URI, OWNED_RECORD__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					return recordValue;
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
						builder.append(OWNED_ENUM__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.ownedUnits.ifPresent(field -> {
						builder.append(OWNED_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.ownedIntegerWithUnits.ifPresent(field -> {
						builder.append(OWNED_INTEGER_WITH_UNITS__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.ownedRange.ifPresent(field -> {
						builder.append(OWNED_RANGE__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.ownedRecord.ifPresent(field -> {
						builder.append(OWNED_RECORD__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum OwnedEnum_FieldType implements GeneratedEnumeration {
					MERCURY("mercury", "__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.0/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
					GEMINI("gemini", "__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.0/@ownedPropertyType/@ownedElementType/@ownedLiteral.1"),
					APOLLO("apollo", "__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.0/@ownedPropertyType/@ownedElementType/@ownedLiteral.2");
					
					private final String originalName;
					private final URI uri;
					
					private OwnedEnum_FieldType(String originalName, String uri) {
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
					}
					
					public static OwnedEnum_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public URI getURI() {
						return uri;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum OwnedUnits_FieldType implements GeneratedUnits<OwnedUnits_FieldType> {
					MS(1.0, "ms", "__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.1/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
					S(1000.0, "s", "__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.1/@ownedPropertyType/@ownedElementType/@ownedLiteral.1");
					
					private final double factorToBase;
					private final String originalName;
					private final URI uri;
					
					private OwnedUnits_FieldType(double factorToBase, String originalName, String uri) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
						this.uri = URI.createURI(uri);
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
					public double getFactorTo(OwnedUnits_FieldType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public URI getURI() {
						return uri;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public static class OwnedRecord_FieldType extends GeneratedRecord {
					public static final String BOOLEAN_FIELD__NAME = "boolean_field";
					public static final String RECORD_FIELD__NAME = "record_field";
					public static final URI BOOLEAN_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.4/@ownedPropertyType/@ownedElementType/@ownedField.0");
					public static final URI RECORD_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.4/@ownedPropertyType/@ownedElementType/@ownedField.1");
					
					private final Optional<Boolean> booleanField;
					private final Optional<RecordField_FieldType> recordField;
					
					public OwnedRecord_FieldType(
							Optional<Boolean> booleanField,
							Optional<RecordField_FieldType> recordField
					) {
						this.booleanField = booleanField;
						this.recordField = recordField;
					}
					
					public OwnedRecord_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
						RecordValue recordValue = (RecordValue) propertyExpression;
						
						Optional<Boolean> booleanField_local;
						try {
							booleanField_local = findFieldValue(recordValue, BOOLEAN_FIELD__NAME).map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
								return ((BooleanLiteral) resolved).getValue();
							});
						} catch (PropertyNotPresentException e) {
							booleanField_local = Optional.empty();
						}
						this.booleanField = booleanField_local;
						
						Optional<RecordField_FieldType> recordField_local;
						try {
							recordField_local = findFieldValue(recordValue, RECORD_FIELD__NAME).map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
								return new RecordField_FieldType(resolved, lookupContext, mode);
							});
						} catch (PropertyNotPresentException e) {
							recordField_local = Optional.empty();
						}
						this.recordField = recordField_local;
					}
					
					public Optional<Boolean> getBooleanField() {
						return booleanField;
					}
					
					public Optional<RecordField_FieldType> getRecordField() {
						return recordField;
					}
					
					@Override
					public RecordValue toPropertyExpression(ResourceSet resourceSet) {
						if (!booleanField.isPresent()
								&& !recordField.isPresent()
						) {
							throw new IllegalStateException("Record must have at least one field set.");
						}
						RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
						booleanField.ifPresent(field -> {
							BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
							fieldAssociation.setProperty(loadField(resourceSet, BOOLEAN_FIELD__URI, BOOLEAN_FIELD__NAME));
							fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
						});
						recordField.ifPresent(field -> {
							BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
							fieldAssociation.setProperty(loadField(resourceSet, RECORD_FIELD__URI, RECORD_FIELD__NAME));
							fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
						});
						return recordValue;
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
							builder.append(BOOLEAN_FIELD__NAME);
							builder.append(" => ");
							builder.append(field);
							builder.append(';');
						});
						this.recordField.ifPresent(field -> {
							builder.append(RECORD_FIELD__NAME);
							builder.append(" => ");
							builder.append(field);
							builder.append(';');
						});
						builder.append(']');
						return builder.toString();
					}
					
					public static class RecordField_FieldType extends GeneratedRecord {
						public static final String STRING_FIELD__NAME = "string_field";
						public static final String INTEGER_FIELD__NAME = "integer_field";
						public static final URI STRING_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.4/@ownedPropertyType/@ownedElementType/@ownedField.1/@ownedPropertyType/@ownedField.0");
						public static final URI INTEGER_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.11/@ownedField.4/@ownedPropertyType/@ownedElementType/@ownedField.1/@ownedPropertyType/@ownedField.1");
						
						private final Optional<String> stringField;
						private final OptionalLong integerField;
						
						public RecordField_FieldType(
								Optional<String> stringField,
								OptionalLong integerField
						) {
							this.stringField = stringField;
							this.integerField = integerField;
						}
						
						public RecordField_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
							RecordValue recordValue = (RecordValue) propertyExpression;
							
							Optional<String> stringField_local;
							try {
								stringField_local = findFieldValue(recordValue, STRING_FIELD__NAME).map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((StringLiteral) resolved).getValue();
								});
							} catch (PropertyNotPresentException e) {
								stringField_local = Optional.empty();
							}
							this.stringField = stringField_local;
							
							OptionalLong integerField_local;
							try {
								integerField_local = findFieldValue(recordValue, INTEGER_FIELD__NAME).map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((IntegerLiteral) resolved).getValue();
								}).map(OptionalLong::of).orElse(OptionalLong.empty());
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
						public RecordValue toPropertyExpression(ResourceSet resourceSet) {
							if (!stringField.isPresent()
									&& !integerField.isPresent()
							) {
								throw new IllegalStateException("Record must have at least one field set.");
							}
							RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
							stringField.ifPresent(field -> {
								BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
								fieldAssociation.setProperty(loadField(resourceSet, STRING_FIELD__URI, STRING_FIELD__NAME));
								fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
							});
							integerField.ifPresent(field -> {
								BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
								fieldAssociation.setProperty(loadField(resourceSet, INTEGER_FIELD__URI, INTEGER_FIELD__NAME));
								fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
							});
							return recordValue;
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
								builder.append(STRING_FIELD__NAME);
								builder.append(" => \"");
								builder.append(field);
								builder.append("\";");
							});
							this.integerField.ifPresent(field -> {
								builder.append(INTEGER_FIELD__NAME);
								builder.append(" => ");
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
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.BasicPropertyAssociation;
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
				public static final String ENUM_NO_IMPORT__NAME = "enum_no_import";
				public static final String ENUM_WITH_IMPORT__NAME = "enum_with_import";
				public static final String UNITS_NO_IMPORT__NAME = "units_no_import";
				public static final String UNITS_WITH_IMPORT__NAME = "units_with_import";
				public static final String NUMBER_WITH_UNITS_NO_IMPORT__NAME = "number_with_units_no_import";
				public static final String NUMBER_WITH_UNITS_WITH_IMPORT__NAME = "number_with_units_with_import";
				public static final String RANGE_NO_IMPORT__NAME = "range_no_import";
				public static final String RANGE_WITH_IMPORT__NAME = "range_with_import";
				public static final String RECORD_NO_IMPORT__NAME = "record_no_import";
				public static final String RECORD_WITH_IMPORT__NAME = "record_with_import";
				public static final URI ENUM_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.0");
				public static final URI ENUM_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.1");
				public static final URI UNITS_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.2");
				public static final URI UNITS_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.3");
				public static final URI NUMBER_WITH_UNITS_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.4");
				public static final URI NUMBER_WITH_UNITS_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.5");
				public static final URI RANGE_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.6");
				public static final URI RANGE_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.7");
				public static final URI RECORD_NO_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.8");
				public static final URI RECORD_WITH_IMPORT__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.12/@ownedField.9");
				
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
				
				public RecordOfListOfReferencedTypes(
						Optional<List<EnumType1>> enumNoImport,
						Optional<List<Color>> enumWithImport,
						Optional<List<Time>> unitsNoImport,
						Optional<List<Mass>> unitsWithImport,
						Optional<List<IntegerWithUnits<IntegerOwnedUnits>>> numberWithUnitsNoImport,
						Optional<List<RealWithUnits<Mass>>> numberWithUnitsWithImport,
						Optional<List<IntegerRange>> rangeNoImport,
						Optional<List<RealRange>> rangeWithImport,
						Optional<List<RecordOfBoolean>> recordNoImport,
						Optional<List<BasicRecord>> recordWithImport
				) {
					this.enumNoImport = enumNoImport;
					this.enumWithImport = enumWithImport;
					this.unitsNoImport = unitsNoImport;
					this.unitsWithImport = unitsWithImport;
					this.numberWithUnitsNoImport = numberWithUnitsNoImport;
					this.numberWithUnitsWithImport = numberWithUnitsWithImport;
					this.rangeNoImport = rangeNoImport;
					this.rangeWithImport = rangeWithImport;
					this.recordNoImport = recordNoImport;
					this.recordWithImport = recordWithImport;
				}
				
				public RecordOfListOfReferencedTypes(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<List<EnumType1>> enumNoImport_local;
					try {
						enumNoImport_local = findFieldValue(recordValue, ENUM_NO_IMPORT__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return EnumType1.valueOf(resolved1);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						enumNoImport_local = Optional.empty();
					}
					this.enumNoImport = enumNoImport_local;
					
					Optional<List<Color>> enumWithImport_local;
					try {
						enumWithImport_local = findFieldValue(recordValue, ENUM_WITH_IMPORT__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return Color.valueOf(resolved1);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						enumWithImport_local = Optional.empty();
					}
					this.enumWithImport = enumWithImport_local;
					
					Optional<List<Time>> unitsNoImport_local;
					try {
						unitsNoImport_local = findFieldValue(recordValue, UNITS_NO_IMPORT__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return Time.valueOf(resolved1);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						unitsNoImport_local = Optional.empty();
					}
					this.unitsNoImport = unitsNoImport_local;
					
					Optional<List<Mass>> unitsWithImport_local;
					try {
						unitsWithImport_local = findFieldValue(recordValue, UNITS_WITH_IMPORT__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return Mass.valueOf(resolved1);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						unitsWithImport_local = Optional.empty();
					}
					this.unitsWithImport = unitsWithImport_local;
					
					Optional<List<IntegerWithUnits<IntegerOwnedUnits>>> numberWithUnitsNoImport_local;
					try {
						numberWithUnitsNoImport_local = findFieldValue(recordValue, NUMBER_WITH_UNITS_NO_IMPORT__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerWithUnits<>(resolved1, IntegerOwnedUnits.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						numberWithUnitsNoImport_local = Optional.empty();
					}
					this.numberWithUnitsNoImport = numberWithUnitsNoImport_local;
					
					Optional<List<RealWithUnits<Mass>>> numberWithUnitsWithImport_local;
					try {
						numberWithUnitsWithImport_local = findFieldValue(recordValue, NUMBER_WITH_UNITS_WITH_IMPORT__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RealWithUnits<>(resolved1, Mass.class);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						numberWithUnitsWithImport_local = Optional.empty();
					}
					this.numberWithUnitsWithImport = numberWithUnitsWithImport_local;
					
					Optional<List<IntegerRange>> rangeNoImport_local;
					try {
						rangeNoImport_local = findFieldValue(recordValue, RANGE_NO_IMPORT__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new IntegerRange(resolved1, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						rangeNoImport_local = Optional.empty();
					}
					this.rangeNoImport = rangeNoImport_local;
					
					Optional<List<RealRange>> rangeWithImport_local;
					try {
						rangeWithImport_local = findFieldValue(recordValue, RANGE_WITH_IMPORT__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RealRange(resolved1, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						rangeWithImport_local = Optional.empty();
					}
					this.rangeWithImport = rangeWithImport_local;
					
					Optional<List<RecordOfBoolean>> recordNoImport_local;
					try {
						recordNoImport_local = findFieldValue(recordValue, RECORD_NO_IMPORT__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new RecordOfBoolean(resolved1, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						recordNoImport_local = Optional.empty();
					}
					this.recordNoImport = recordNoImport_local;
					
					Optional<List<BasicRecord>> recordWithImport_local;
					try {
						recordWithImport_local = findFieldValue(recordValue, RECORD_WITH_IMPORT__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return new BasicRecord(resolved1, lookupContext, mode);
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						recordWithImport_local = Optional.empty();
					}
					this.recordWithImport = recordWithImport_local;
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
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!enumNoImport.isPresent()
							&& !enumWithImport.isPresent()
							&& !unitsNoImport.isPresent()
							&& !unitsWithImport.isPresent()
							&& !numberWithUnitsNoImport.isPresent()
							&& !numberWithUnitsWithImport.isPresent()
							&& !rangeNoImport.isPresent()
							&& !rangeWithImport.isPresent()
							&& !recordNoImport.isPresent()
							&& !recordWithImport.isPresent()
					) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					enumNoImport.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, ENUM_NO_IMPORT__URI, ENUM_NO_IMPORT__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					enumWithImport.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, ENUM_WITH_IMPORT__URI, ENUM_WITH_IMPORT__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					unitsNoImport.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, UNITS_NO_IMPORT__URI, UNITS_NO_IMPORT__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					unitsWithImport.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, UNITS_WITH_IMPORT__URI, UNITS_WITH_IMPORT__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					numberWithUnitsNoImport.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, NUMBER_WITH_UNITS_NO_IMPORT__URI, NUMBER_WITH_UNITS_NO_IMPORT__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					numberWithUnitsWithImport.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, NUMBER_WITH_UNITS_WITH_IMPORT__URI, NUMBER_WITH_UNITS_WITH_IMPORT__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					rangeNoImport.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, RANGE_NO_IMPORT__URI, RANGE_NO_IMPORT__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression();
						}));
					});
					rangeWithImport.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, RANGE_WITH_IMPORT__URI, RANGE_WITH_IMPORT__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression();
						}));
					});
					recordNoImport.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, RECORD_NO_IMPORT__URI, RECORD_NO_IMPORT__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					recordWithImport.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, RECORD_WITH_IMPORT__URI, RECORD_WITH_IMPORT__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return element1.toPropertyExpression(resourceSet);
						}));
					});
					return recordValue;
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
						builder.append(ENUM_NO_IMPORT__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.enumWithImport.ifPresent(field -> {
						builder.append(ENUM_WITH_IMPORT__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.unitsNoImport.ifPresent(field -> {
						builder.append(UNITS_NO_IMPORT__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.unitsWithImport.ifPresent(field -> {
						builder.append(UNITS_WITH_IMPORT__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.numberWithUnitsNoImport.ifPresent(field -> {
						builder.append(NUMBER_WITH_UNITS_NO_IMPORT__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.numberWithUnitsWithImport.ifPresent(field -> {
						builder.append(NUMBER_WITH_UNITS_WITH_IMPORT__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.rangeNoImport.ifPresent(field -> {
						builder.append(RANGE_NO_IMPORT__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.rangeWithImport.ifPresent(field -> {
						builder.append(RANGE_WITH_IMPORT__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.recordNoImport.ifPresent(field -> {
						builder.append(RECORD_NO_IMPORT__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.recordWithImport.ifPresent(field -> {
						builder.append(RECORD_WITH_IMPORT__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(ps1, ps2))
		assertEquals("src-gen/ps1", results.packagePath)
		assertEquals(13, results.classes.size)
		
		assertEquals("Ps1.java", results.classes.get(0).fileName)
		assertEquals(ps1Class.toString, results.classes.get(0).contents)
		
		assertEquals("Time.java", results.classes.get(1).fileName)
		assertEquals(time.toString, results.classes.get(1).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.classes.get(2).fileName)
		assertEquals(integerOwnedUnits.toString, results.classes.get(2).contents)
		
		assertEquals("EnumType1.java", results.classes.get(3).fileName)
		assertEquals(enumType1.toString, results.classes.get(3).contents)
		
		assertEquals("RecordOfBoolean.java", results.classes.get(4).fileName)
		assertEquals(recordOfBoolean.toString, results.classes.get(4).contents)
		
		assertEquals("RecordOfListOfBoolean.java", results.classes.get(5).fileName)
		assertEquals(recordOfListOfBoolean.toString, results.classes.get(5).contents)
		
		assertEquals("RecordOfListOfString.java", results.classes.get(6).fileName)
		assertEquals(recordOfListOfString.toString, results.classes.get(6).contents)
		
		assertEquals("RecordOfListOfClassifier.java", results.classes.get(7).fileName)
		assertEquals(recordOfListOfClassifier.toString, results.classes.get(7).contents)
		
		assertEquals("RecordOfListOfIntegerNoUnits.java", results.classes.get(8).fileName)
		assertEquals(recordOfListOfIntegerNoUnits.toString, results.classes.get(8).contents)
		
		assertEquals("RecordOfListOfRealNoUnits.java", results.classes.get(9).fileName)
		assertEquals(recordOfListOfRealNoUnits.toString, results.classes.get(9).contents)
		
		assertEquals("RecordOfListOfReference.java", results.classes.get(10).fileName)
		assertEquals(recordOfListOfReference.toString, results.classes.get(10).contents)
		
		assertEquals("RecordOfListOfOwnedTypes.java", results.classes.get(11).fileName)
		assertEquals(recordOfListOfOwnedTypes.toString, results.classes.get(11).contents)
		
		assertEquals("RecordOfListOfReferencedTypes.java", results.classes.get(12).fileName)
		assertEquals(recordOfListOfReferencedTypes.toString, results.classes.get(12).contents)
	}
}