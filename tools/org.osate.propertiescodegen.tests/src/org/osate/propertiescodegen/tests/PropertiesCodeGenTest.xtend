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
class PropertiesCodeGenTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testEnumType() {
		val propertySet = '''
			property set enum_test is
				enum_type_1: type enumeration (one, two, three);
			end enum_test;
		'''
		val javaClass = '''
			package enum_test;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyConstant;
			import org.osate.aadl2.PropertyExpression;
			
			public enum EnumType1 {
				ONE,
				TWO,
				THREE;
				
				public static EnumType1 valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					if (abstractNamedValue instanceof EnumerationLiteral) {
						return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
					} else if (abstractNamedValue instanceof Property) {
						throw new IllegalArgumentException("Reference to property not supported");
					} else if (abstractNamedValue instanceof PropertyConstant) {
						throw new IllegalArgumentException("Reference to property constant not supported");
					} else {
						throw new AssertionError("Unexpected type: " + abstractNamedValue.getClass().getName());
					}
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(propertySet))
		assertEquals(1, results.size)
		assertEquals("EnumType1.java", results.head.fileName)
		assertEquals(javaClass.toString, results.head.contents)
	}
	
	@Test
	def void testUnitsType() {
		val propertySet = '''
			property set units_test is
				units_type_1: type units (mm, cm => mm * 10, m => cm * 100, inch => cm * 2.54, ft => inch * 12);
			end units_test;
		'''
		val javaClass = '''
			package units_test;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyConstant;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			
			public enum UnitsType1 {
				MM(1.0),
				CM(10.0),
				INCH(25.4),
				FT(304.8),
				M(1000.0);
				
				private final double factorToBase;
				
				private UnitsType1(double factorToBase) {
					this.factorToBase = factorToBase;
				}
				
				public double getFactorTo(UnitsType1 target) {
					return factorToBase / target.factorToBase;
				}
				
				public static UnitsType1 valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					if (abstractNamedValue instanceof UnitLiteral) {
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					} else if (abstractNamedValue instanceof Property) {
						throw new IllegalArgumentException("Reference to property not supported");
					} else if (abstractNamedValue instanceof PropertyConstant) {
						throw new IllegalArgumentException("Reference to property constant not supported");
					} else {
						throw new AssertionError("Unexpected type: " + abstractNamedValue.getClass().getName());
					}
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(propertySet))
		assertEquals(1, results.size)
		assertEquals("UnitsType1.java", results.head.fileName)
		assertEquals(javaClass.toString, results.head.contents)
	}
	
	@Test
	def void testIntegerType() {
		val ps2 = '''
			property set ps2 is
				mass: type units (g, kg => g * 1000);
			end ps2;
		'''
		val ps1 = '''
			property set ps1 is
				with ps2;
				
				time: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				
				integer_no_units: type aadlinteger;
				integer_owned_units: type aadlinteger units (mm, cm => mm * 10, m => cm * 100);
				integer_referenced_units_local: type aadlinteger units ps1::time;
				integer_referenced_units_other_file: type aadlinteger units ps2::mass;
			end ps1;
		'''
		val time = '''
			package ps1;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyConstant;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			
			public enum Time {
				SEC(1.0),
				MIN(60.0),
				HR(3600.0),
				DAY(86400.0);
				
				private final double factorToBase;
				
				private Time(double factorToBase) {
					this.factorToBase = factorToBase;
				}
				
				public double getFactorTo(Time target) {
					return factorToBase / target.factorToBase;
				}
				
				public static Time valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					if (abstractNamedValue instanceof UnitLiteral) {
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					} else if (abstractNamedValue instanceof Property) {
						throw new IllegalArgumentException("Reference to property not supported");
					} else if (abstractNamedValue instanceof PropertyConstant) {
						throw new IllegalArgumentException("Reference to property constant not supported");
					} else {
						throw new AssertionError("Unexpected type: " + abstractNamedValue.getClass().getName());
					}
				}
			}
		'''
		val integerNoUnits = '''
			package ps1;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			
			public class IntegerNoUnits {
				public static long getValue(PropertyExpression propertyExpression) {
					return ((IntegerLiteral) propertyExpression).getValue();
				}
			}
		'''
		val integerOwnedUnits = '''
			package ps1;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			
			public class IntegerOwnedUnits {
				private final long value;
				private final Units unit;
				
				public IntegerOwnedUnits(PropertyExpression propertyExpression) {
					IntegerLiteral integerLiteral = (IntegerLiteral) propertyExpression;
					value = integerLiteral.getValue();
					unit = Units.valueOf(integerLiteral.getUnit().getName().toUpperCase());
				}
				
				public long getValue() {
					return value;
				}
				
				public Units getUnit() {
					return unit;
				}
				
				public enum Units {
					MM(1.0),
					CM(10.0),
					M(1000.0);
					
					private final double factorToBase;
					
					private Units(double factorToBase) {
						this.factorToBase = factorToBase;
					}
					
					public double getFactorTo(Units target) {
						return factorToBase / target.factorToBase;
					}
				}
			}
		'''
		val integerReferencedUnitsLocal = '''
			package ps1;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			
			public class IntegerReferencedUnitsLocal {
				private final long value;
				private final Time unit;
				
				public IntegerReferencedUnitsLocal(PropertyExpression propertyExpression) {
					IntegerLiteral integerLiteral = (IntegerLiteral) propertyExpression;
					value = integerLiteral.getValue();
					unit = Time.valueOf(integerLiteral.getUnit().getName().toUpperCase());
				}
				
				public long getValue() {
					return value;
				}
				
				public Time getUnit() {
					return unit;
				}
			}
		'''
		val integerReferencedUnitsOtherFile = '''
			package ps1;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			
			import ps2.Mass;
			
			public class IntegerReferencedUnitsOtherFile {
				private final long value;
				private final Mass unit;
				
				public IntegerReferencedUnitsOtherFile(PropertyExpression propertyExpression) {
					IntegerLiteral integerLiteral = (IntegerLiteral) propertyExpression;
					value = integerLiteral.getValue();
					unit = Mass.valueOf(integerLiteral.getUnit().getName().toUpperCase());
				}
				
				public long getValue() {
					return value;
				}
				
				public Mass getUnit() {
					return unit;
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(ps1, ps2))
		assertEquals(5, results.size)
		
		assertEquals("Time.java", results.get(0).fileName)
		assertEquals(time.toString, results.get(0).contents)
		
		assertEquals("IntegerNoUnits.java", results.get(1).fileName)
		assertEquals(integerNoUnits.toString, results.get(1).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.get(2).fileName)
		assertEquals(integerOwnedUnits.toString, results.get(2).contents)
		
		assertEquals("IntegerReferencedUnitsLocal.java", results.get(3).fileName)
		assertEquals(integerReferencedUnitsLocal.toString, results.get(3).contents)
		
		assertEquals("IntegerReferencedUnitsOtherFile.java", results.get(4).fileName)
		assertEquals(integerReferencedUnitsOtherFile.toString, results.get(4).contents)
	}
}