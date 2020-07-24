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
class ResolveNamedValueTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testResolveNamedValue() {
		val resolveNamedValueTest = '''
			property set resolve_named_value_test is
				length: type units (m);
				
				bool_const: constant aadlboolean => true;
				int_const_1: constant aadlinteger => 1;
				int_const_2: constant aadlinteger => 2;
				int_with_units_const_1: constant aadlinteger units resolve_named_value_test::length => 3m;
				int_with_units_const_2: constant aadlinteger units resolve_named_value_test::length => 4m;
				real_const_1: constant aadlreal => 5.5;
				real_const_2: constant aadlreal => 6.6;
				real_with_units_const_1: constant aadlreal units resolve_named_value_test::length => 7.7m;
				real_with_units_const_2: constant aadlreal units resolve_named_value_test::length => 8.8m;
				list_1_int_const: constant list of aadlinteger => (resolve_named_value_test::int_const_1);
				list_2_int_const: constant list of list of aadlinteger => (resolve_named_value_test::list_1_int_const);
				list_3_int_const: constant list of list of list of aadlinteger => (resolve_named_value_test::list_2_int_const);
				
				int_def_1: aadlinteger applies to (all);
				int_def_2: aadlinteger applies to (all);
				list_3_int_def: list of list of list of aadlinteger applies to (all);
				int_range_no_units_def: range of aadlinteger applies to (all);
				int_range_with_units_def: range of aadlinteger units resolve_named_value_test::length applies to (all);
				real_range_no_units_def: range of aadlreal applies to (all);
				real_range_with_units_def: range of aadlreal units resolve_named_value_test::length applies to (all);
				record_def: record (
					bool_field: aadlboolean;
					int_field: aadlinteger;
					real_field: aadlreal;
					list_3_int_field: list of list of list of aadlinteger;
				) applies to (all);
			end resolve_named_value_test;
		'''
		val resolveNamedValueTestClass = '''
			package resolvenamedvaluetest;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.OptionalLong;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.IntegerRange;
			import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
			import org.osate.pluginsupport.properties.RealRange;
			import org.osate.pluginsupport.properties.RealRangeWithUnits;
			
			public class ResolveNamedValueTest {
				public static OptionalLong getIntDef1(NamedElement lookupContext) {
					return getIntDef1(lookupContext, Optional.empty());
				}
				
				public static OptionalLong getIntDef1(NamedElement lookupContext, Mode mode) {
					return getIntDef1(lookupContext, Optional.of(mode));
				}
				
				public static OptionalLong getIntDef1(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "resolve_named_value_test::int_def_1";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return OptionalLong.of(((IntegerLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalLong.empty();
					}
				}
				
				public static PropertyExpression getIntDef1_EObject(NamedElement lookupContext) {
					String name = "resolve_named_value_test::int_def_1";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static OptionalLong getIntDef2(NamedElement lookupContext) {
					return getIntDef2(lookupContext, Optional.empty());
				}
				
				public static OptionalLong getIntDef2(NamedElement lookupContext, Mode mode) {
					return getIntDef2(lookupContext, Optional.of(mode));
				}
				
				public static OptionalLong getIntDef2(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "resolve_named_value_test::int_def_2";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return OptionalLong.of(((IntegerLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalLong.empty();
					}
				}
				
				public static PropertyExpression getIntDef2_EObject(NamedElement lookupContext) {
					String name = "resolve_named_value_test::int_def_2";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<List<Long>>>> getList3IntDef(NamedElement lookupContext) {
					return getList3IntDef(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<Long>>>> getList3IntDef(NamedElement lookupContext, Mode mode) {
					return getList3IntDef(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<Long>>>> getList3IntDef(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "resolve_named_value_test::list_3_int_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
									PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
									return ((IntegerLiteral) resolved3).getValue();
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList3IntDef_EObject(NamedElement lookupContext) {
					String name = "resolve_named_value_test::list_3_int_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<IntegerRange> getIntRangeNoUnitsDef(NamedElement lookupContext) {
					return getIntRangeNoUnitsDef(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerRange> getIntRangeNoUnitsDef(NamedElement lookupContext, Mode mode) {
					return getIntRangeNoUnitsDef(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerRange> getIntRangeNoUnitsDef(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "resolve_named_value_test::int_range_no_units_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerRange(resolved, lookupContext, mode));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getIntRangeNoUnitsDef_EObject(NamedElement lookupContext) {
					String name = "resolve_named_value_test::int_range_no_units_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<IntegerRangeWithUnits<Length>> getIntRangeWithUnitsDef(NamedElement lookupContext) {
					return getIntRangeWithUnitsDef(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerRangeWithUnits<Length>> getIntRangeWithUnitsDef(NamedElement lookupContext, Mode mode) {
					return getIntRangeWithUnitsDef(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerRangeWithUnits<Length>> getIntRangeWithUnitsDef(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "resolve_named_value_test::int_range_with_units_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerRangeWithUnits<>(resolved, Length.class, lookupContext, mode));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getIntRangeWithUnitsDef_EObject(NamedElement lookupContext) {
					String name = "resolve_named_value_test::int_range_with_units_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<RealRange> getRealRangeNoUnitsDef(NamedElement lookupContext) {
					return getRealRangeNoUnitsDef(lookupContext, Optional.empty());
				}
				
				public static Optional<RealRange> getRealRangeNoUnitsDef(NamedElement lookupContext, Mode mode) {
					return getRealRangeNoUnitsDef(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RealRange> getRealRangeNoUnitsDef(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "resolve_named_value_test::real_range_no_units_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RealRange(resolved, lookupContext, mode));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRealRangeNoUnitsDef_EObject(NamedElement lookupContext) {
					String name = "resolve_named_value_test::real_range_no_units_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<RealRangeWithUnits<Length>> getRealRangeWithUnitsDef(NamedElement lookupContext) {
					return getRealRangeWithUnitsDef(lookupContext, Optional.empty());
				}
				
				public static Optional<RealRangeWithUnits<Length>> getRealRangeWithUnitsDef(NamedElement lookupContext, Mode mode) {
					return getRealRangeWithUnitsDef(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RealRangeWithUnits<Length>> getRealRangeWithUnitsDef(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "resolve_named_value_test::real_range_with_units_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RealRangeWithUnits<>(resolved, Length.class, lookupContext, mode));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRealRangeWithUnitsDef_EObject(NamedElement lookupContext) {
					String name = "resolve_named_value_test::real_range_with_units_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<RecordDef> getRecordDef(NamedElement lookupContext) {
					return getRecordDef(lookupContext, Optional.empty());
				}
				
				public static Optional<RecordDef> getRecordDef(NamedElement lookupContext, Mode mode) {
					return getRecordDef(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RecordDef> getRecordDef(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "resolve_named_value_test::record_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RecordDef(resolved, lookupContext, mode));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRecordDef_EObject(NamedElement lookupContext) {
					String name = "resolve_named_value_test::record_def";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val length = '''
			package resolvenamedvaluetest;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum Length implements GeneratedUnits<Length> {
				M(1.0, "m", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private Length(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static Length valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(Length target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public UnitLiteral toUnitLiteral(ResourceSet resourceSet) {
					UnitLiteral literal = (UnitLiteral) resourceSet.getEObject(uri, true);
					if (literal == null) {
						throw new RuntimeException("Could not resolve UnitLiteral '" + originalName + "'.");
					}
					return literal;
				}
				
				@Override
				public NamedValue toPropertyExpression(ResourceSet resourceSet) {
					NamedValue value = Aadl2Factory.eINSTANCE.createNamedValue();
					value.setNamedValue(toUnitLiteral(resourceSet));
					return value;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val recordDef = '''
			package resolvenamedvaluetest;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.OptionalDouble;
			import java.util.OptionalLong;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class RecordDef {
				private final Optional<Boolean> boolField;
				private final OptionalLong intField;
				private final OptionalDouble realField;
				private final Optional<List<List<List<Long>>>> list3IntField;
				
				public RecordDef(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<Boolean> boolField_local;
					try {
						boolField_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("bool_field"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((BooleanLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						boolField_local = Optional.empty();
					}
					this.boolField = boolField_local;
					
					OptionalLong intField_local;
					try {
						intField_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("int_field"))
								.mapToLong(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((IntegerLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						intField_local = OptionalLong.empty();
					}
					this.intField = intField_local;
					
					OptionalDouble realField_local;
					try {
						realField_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("real_field"))
								.mapToDouble(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((RealLiteral) resolved).getValue();
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						realField_local = OptionalDouble.empty();
					}
					this.realField = realField_local;
					
					Optional<List<List<List<Long>>>> list3IntField_local;
					try {
						list3IntField_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("list_3_int_field"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
										PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
										return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
											PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
											return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
												PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
												return ((IntegerLiteral) resolved3).getValue();
											}).collect(Collectors.toList());
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						list3IntField_local = Optional.empty();
					}
					this.list3IntField = list3IntField_local;
				}
				
				public Optional<Boolean> getBoolField() {
					return boolField;
				}
				
				public OptionalLong getIntField() {
					return intField;
				}
				
				public OptionalDouble getRealField() {
					return realField;
				}
				
				public Optional<List<List<List<Long>>>> getList3IntField() {
					return list3IntField;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							boolField,
							intField,
							realField,
							list3IntField
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordDef)) {
						return false;
					}
					RecordDef other = (RecordDef) obj;
					return Objects.equals(this.boolField, other.boolField)
							&& Objects.equals(this.intField, other.intField)
							&& Objects.equals(this.realField, other.realField)
							&& Objects.equals(this.list3IntField, other.list3IntField);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.boolField.ifPresent(field -> {
						builder.append("bool_field => ");
						builder.append(field);
						builder.append(';');
					});
					this.intField.ifPresent(field -> {
						builder.append("int_field => ");
						builder.append(field);
						builder.append(';');
					});
					this.realField.ifPresent(field -> {
						builder.append("real_field => ");
						builder.append(field);
						builder.append(';');
					});
					this.list3IntField.ifPresent(field -> {
						builder.append("list_3_int_field => ");
						builder.append(field.stream().map(element1 -> {
							return element1.stream().map(element2 -> {
								return element2.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")"));
							}).collect(Collectors.joining(", ", "(", ")"));
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(resolveNamedValueTest))
		assertEquals("src-gen/resolvenamedvaluetest", results.packagePath)
		assertEquals(3, results.classes.size)
		
		assertEquals("ResolveNamedValueTest.java", results.classes.get(0).fileName)
		assertEquals(resolveNamedValueTestClass.toString, results.classes.get(0).contents)
		
		assertEquals("Length.java", results.classes.get(1).fileName)
		assertEquals(length.toString, results.classes.get(1).contents)
		
		assertEquals("RecordDef.java", results.classes.get(2).fileName)
		assertEquals(recordDef.toString, results.classes.get(2).contents)
	}
}