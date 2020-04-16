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
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			import org.osate.aadl2.StringLiteral;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.IntegerRange;
			import org.osate.pluginsupport.properties.IntegerWithUnits;
			
			import ps2.Color;
			import ps2.Mass;
			
			public class Ps1 {
				public static Optional<Boolean> getBooleanDefinition(NamedElement lookupContext) {
					String name = "ps1::boolean_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((BooleanLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getBooleanDefinition_EObject(NamedElement lookupContext) {
					String name = "ps1::boolean_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDefinition(NamedElement lookupContext) {
					String name = "ps1::string_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDefinition_EObject(NamedElement lookupContext) {
					String name = "ps1::string_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<Classifier> getClassifierDefinition(NamedElement lookupContext) {
					String name = "ps1::classifier_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((ClassifierValue) resolved).getClassifier());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getClassifierDefinition_EObject(NamedElement lookupContext) {
					String name = "ps1::classifier_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<UnitsDefinition> getUnitsDefinition(NamedElement lookupContext) {
					String name = "ps1::units_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(UnitsDefinition.valueOf(resolved));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getUnitsDefinition_EObject(NamedElement lookupContext) {
					String name = "ps1::units_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<EnumDefinition> getEnumDefinition(NamedElement lookupContext) {
					String name = "ps1::enum_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(EnumDefinition.valueOf(resolved));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getEnumDefinition_EObject(NamedElement lookupContext) {
					String name = "ps1::enum_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static OptionalLong getIntegerDefinitionNoUnits(NamedElement lookupContext) {
					String name = "ps1::integer_definition_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return OptionalLong.of(((IntegerLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalLong.empty();
					}
				}
				
				public static PropertyExpression getIntegerDefinitionNoUnits_EObject(NamedElement lookupContext) {
					String name = "ps1::integer_definition_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<IntegerWithUnits<Mass>> getIntegerDefinitionWithUnits(NamedElement lookupContext) {
					String name = "ps1::integer_definition_with_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(new IntegerWithUnits<>(resolved, Mass.class));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getIntegerDefinitionWithUnits_EObject(NamedElement lookupContext) {
					String name = "ps1::integer_definition_with_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static OptionalDouble getRealDefinitionNoUnits(NamedElement lookupContext) {
					String name = "ps1::real_definition_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return OptionalDouble.of(((RealLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalDouble.empty();
					}
				}
				
				public static PropertyExpression getRealDefinitionNoUnits_EObject(NamedElement lookupContext) {
					String name = "ps1::real_definition_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<IntegerRange> getRangeDefinition(NamedElement lookupContext) {
					String name = "ps1::range_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(new IntegerRange(resolved, lookupContext));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRangeDefinition_EObject(NamedElement lookupContext) {
					String name = "ps1::range_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<RecordDefinition> getRecordDefinition(NamedElement lookupContext) {
					String name = "ps1::record_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(new RecordDefinition(resolved, lookupContext));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRecordDefinition_EObject(NamedElement lookupContext) {
					String name = "ps1::record_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<InstanceObject> getReferenceDefinition(NamedElement lookupContext) {
					String name = "ps1::reference_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getReferenceDefinition_EObject(NamedElement lookupContext) {
					String name = "ps1::reference_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<Boolean> getDefinitionWithReferencedTypeLocal(NamedElement lookupContext) {
					String name = "ps1::definition_with_referenced_type_local";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((BooleanLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getDefinitionWithReferencedTypeLocal_EObject(NamedElement lookupContext) {
					String name = "ps1::definition_with_referenced_type_local";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<Color> getDefinitionWithReferencedTypeOtherFile(NamedElement lookupContext) {
					String name = "ps1::definition_with_referenced_type_other_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(Color.valueOf(resolved));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getDefinitionWithReferencedTypeOtherFile_EObject(NamedElement lookupContext) {
					String name = "ps1::definition_with_referenced_type_other_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val unitsDefinition = '''
			package ps1;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum UnitsDefinition implements GeneratedUnits {
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
		val recordDefinition = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class RecordDefinition {
				private final Optional<Boolean> field;
				
				public RecordDefinition(PropertyExpression propertyExpression, NamedElement lookupContext) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.field = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("field"))
							.map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext);
								return ((BooleanLiteral) resolved).getValue();
							})
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
					if (!(obj instanceof RecordDefinition)) {
						return false;
					}
					RecordDefinition other = (RecordDefinition) obj;
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
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(ps1, ps2))
		assertEquals(4, results.size)
		
		assertEquals("Ps1.java", results.get(0).fileName)
		assertEquals(ps1Class.toString, results.get(0).contents)
		
		assertEquals("UnitsDefinition.java", results.get(1).fileName)
		assertEquals(unitsDefinition.toString, results.get(1).contents)
		
		assertEquals("EnumDefinition.java", results.get(2).fileName)
		assertEquals(enumDefinition.toString, results.get(2).contents)
		
		assertEquals("RecordDefinition.java", results.get(3).fileName)
		assertEquals(recordDefinition.toString, results.get(3).contents)
	}
	
	@Test
	def void testEmptyPropertySet() {
		val emptyPs = '''
			property set empty_ps is
			end empty_ps;
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(emptyPs))
		assertEquals(0, results.size)
	}
	
	@Test
	def void testSingleDefinition() {
		val singleDefinitionPs = '''
			property set single_definition_ps is
				sole_definition: aadlboolean applies to (all);
			end single_definition_ps;
		'''
		val singleDefinitionPsClass = '''
			package single_definition_ps;
			
			import java.util.Optional;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class SingleDefinitionPs {
				public static Optional<Boolean> getSoleDefinition(NamedElement lookupContext) {
					String name = "single_definition_ps::sole_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = lookupContext.getNonModalPropertyValue(property);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(propertyExpression, lookupContext);
						return Optional.of(((BooleanLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getSoleDefinition_EObject(NamedElement lookupContext) {
					String name = "single_definition_ps::sole_definition";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(singleDefinitionPs))
		assertEquals(1, results.size)
		
		assertEquals("SingleDefinitionPs.java", results.head.fileName)
		assertEquals(singleDefinitionPsClass.toString, results.head.contents)
	}
}