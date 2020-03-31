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
class PropertyDefinitionTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testPropertyDefinition() {
		val ps2 = '''
			property set ps2 is
				mass: type units (g, kg => g * 1000);
				color: type enumeration (red, green, blue);
			end ps2;
		'''
		val ps1 = '''
			property set ps1 is
				with ps2;
				
				boolean_type_1: type aadlboolean;
				
				boolean_definition: aadlboolean applies to (all);
				string_definition: aadlstring applies to (all);
				classifier_definition: classifier applies to (all);
				units_definition: units (m, km => m * 1000) applies to (all);
				enum_definition: enumeration (washington, lincoln) applies to (all);
				integer_definition_no_units: aadlinteger applies to (all);
				integer_definition_with_units: aadlinteger units ps2::mass applies to (all);
				real_definition_no_units: aadlreal applies to (all);
				range_definition: range of aadlinteger applies to (all);
				record_definition: record (field: aadlboolean;) applies to (all);
				reference_definition: reference applies to (all);
				
				definition_with_referenced_type_local: ps1::boolean_type_1 applies to (all);
				definition_with_referenced_type_other_file: ps2::color applies to (all);
			end ps1;
		'''
		val ps1Class = '''
			package ps1;
			
			import java.util.Optional;
			import java.util.OptionalDouble;
			import java.util.OptionalLong;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.Classifier;
			import org.osate.aadl2.ClassifierValue;
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			import org.osate.aadl2.StringLiteral;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			
			import ps2.Color;
			
			public class Ps1 {
				public static Optional<Boolean> getBooleanDefinition(InstanceObject instanceObject) {
					String name = "ps1::boolean_definition";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((BooleanLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<String> getStringDefinition(InstanceObject instanceObject) {
					String name = "ps1::string_definition";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((StringLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<Classifier> getClassifierDefinition(InstanceObject instanceObject) {
					String name = "ps1::classifier_definition";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((ClassifierValue) propertyExpression).getClassifier());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<UnitsDefinition> getUnitsDefinition(InstanceObject instanceObject) {
					String name = "ps1::units_definition";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(UnitsDefinition.valueOf(propertyExpression));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<EnumDefinition> getEnumDefinition(InstanceObject instanceObject) {
					String name = "ps1::enum_definition";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(EnumDefinition.valueOf(propertyExpression));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static OptionalLong getIntegerDefinitionNoUnits(InstanceObject instanceObject) {
					String name = "ps1::integer_definition_no_units";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return OptionalLong.of(((IntegerLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalLong.empty();
					}
				}
				
				public static Optional<IntegerDefinitionWithUnits> getIntegerDefinitionWithUnits(InstanceObject instanceObject) {
					String name = "ps1::integer_definition_with_units";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(IntegerDefinitionWithUnits.getValue(propertyExpression));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static OptionalDouble getRealDefinitionNoUnits(InstanceObject instanceObject) {
					String name = "ps1::real_definition_no_units";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return OptionalDouble.of(((RealLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalDouble.empty();
					}
				}
				
				public static Optional<RangeDefinition> getRangeDefinition(InstanceObject instanceObject) {
					String name = "ps1::range_definition";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(RangeDefinition.getValue(propertyExpression));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<RecordDefinition> getRecordDefinition(InstanceObject instanceObject) {
					String name = "ps1::record_definition";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(RecordDefinition.getValue(propertyExpression));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<InstanceObject> getReferenceDefinition(InstanceObject instanceObject) {
					String name = "ps1::reference_definition";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<Boolean> getDefinitionWithReferencedTypeLocal(InstanceObject instanceObject) {
					String name = "ps1::definition_with_referenced_type_local";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(((BooleanLiteral) propertyExpression).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Optional<Color> getDefinitionWithReferencedTypeOtherFile(InstanceObject instanceObject) {
					String name = "ps1::definition_with_referenced_type_other_file";
					Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
						return Optional.of(Color.valueOf(propertyExpression));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
			}
		'''
		val unitsDefinition = '''
			package ps1;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			
			public enum UnitsDefinition {
				M(1.0, "m"),
				KM(1000.0, "km");
				
				private final double factorToBase;
				private final String originalName;
				
				private UnitsDefinition(double factorToBase, String originalName) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
				}
				
				public static UnitsDefinition valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				public double getFactorToBase() {
					return factorToBase;
				}
				
				public double getFactorTo(UnitsDefinition target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val enumDefinition = '''
			package ps1;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			
			public enum EnumDefinition {
				WASHINGTON("washington"),
				LINCOLN("lincoln");
				
				private final String originalName;
				
				private EnumDefinition(String originalName) {
					this.originalName = originalName;
				}
				
				public static EnumDefinition valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val integerDefinitionWithUnits = '''
			package ps1;
			
			import java.util.Objects;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			
			import ps2.Mass;
			
			public class IntegerDefinitionWithUnits {
				private final long value;
				private final Mass unit;
				
				private IntegerDefinitionWithUnits(PropertyExpression propertyExpression) {
					IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
					value = numberValue.getValue();
					unit = Mass.valueOf(numberValue.getUnit().getName().toUpperCase());
				}
				
				public static IntegerDefinitionWithUnits getValue(PropertyExpression propertyExpression) {
					return new IntegerDefinitionWithUnits(propertyExpression);
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
					if (!(obj instanceof IntegerDefinitionWithUnits)) {
						return false;
					}
					IntegerDefinitionWithUnits other = (IntegerDefinitionWithUnits) obj;
					return value == other.value && unit == other.unit;
				}
				
				@Override
				public String toString() {
					return value + unit.toString();
				}
			}
		'''
		val rangeDefinition = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.OptionalLong;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RangeValue;
			
			public class RangeDefinition {
				private final long minimum;
				private final long maximum;
				private final OptionalLong delta;
				
				private RangeDefinition(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					minimum = ((IntegerLiteral) rangeValue.getMinimum()).getValue();
					maximum = ((IntegerLiteral) rangeValue.getMaximum()).getValue();
					if (rangeValue.getDelta() == null) {
						delta = OptionalLong.empty();
					} else {
						delta = OptionalLong.of(((IntegerLiteral) rangeValue.getDelta()).getValue());
					}
				}
				
				public static RangeDefinition getValue(PropertyExpression propertyExpression) {
					return new RangeDefinition(propertyExpression);
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
					if (!(obj instanceof RangeDefinition)) {
						return false;
					}
					RangeDefinition other = (RangeDefinition) obj;
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
		val recordDefinition = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			
			public class RecordDefinition {
				private final Optional<Boolean> field;
				
				private RecordDefinition(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> ((BooleanLiteral) field.getOwnedValue()).getValue())
							.findAny();
				}
				
				public static RecordDefinition getValue(PropertyExpression propertyExpression) {
					return new RecordDefinition(propertyExpression);
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
					if (!(obj instanceof RecordDefinition)) {
						return false;
					}
					RecordDefinition other = (RecordDefinition) obj;
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
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(ps1, ps2))
		assertEquals(6, results.size)
		
		assertEquals("Ps1.java", results.get(0).fileName)
		assertEquals(ps1Class.toString, results.get(0).contents)
		
		assertEquals("UnitsDefinition.java", results.get(1).fileName)
		assertEquals(unitsDefinition.toString, results.get(1).contents)
		
		assertEquals("EnumDefinition.java", results.get(2).fileName)
		assertEquals(enumDefinition.toString, results.get(2).contents)
		
		assertEquals("IntegerDefinitionWithUnits.java", results.get(3).fileName)
		assertEquals(integerDefinitionWithUnits.toString, results.get(3).contents)
		
		assertEquals("RangeDefinition.java", results.get(4).fileName)
		assertEquals(rangeDefinition.toString, results.get(4).contents)
		
		assertEquals("RecordDefinition.java", results.get(5).fileName)
		assertEquals(recordDefinition.toString, results.get(5).contents)
	}
}