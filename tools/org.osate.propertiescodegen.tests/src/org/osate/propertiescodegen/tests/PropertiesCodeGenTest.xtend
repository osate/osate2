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
	def void testBooleanType() {
		val propertySet = '''
			property set ps1 is
				boolean_type_1: type aadlboolean;
			end ps1;
		'''
		val javaClass = '''
			package ps1;
			
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.PropertyExpression;
			
			public class BooleanType1 {
				public static boolean getValue(PropertyExpression propertyExpression) {
					return ((BooleanLiteral) propertyExpression).getValue();
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(propertySet))
		assertEquals(1, results.size)
		assertEquals("BooleanType1.java", results.head.fileName)
		assertEquals(javaClass.toString, results.head.contents)
	}
	
	@Test
	def void testStringType() {
		val propertySet = '''
			property set ps1 is
				string_type_1: type aadlstring;
			end ps1;
		'''
		val javaClass = '''
			package ps1;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.StringLiteral;
			
			public class StringType1 {
				public static String getValue(PropertyExpression propertyExpression) {
					return ((StringLiteral) propertyExpression).getValue();
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(propertySet))
		assertEquals(1, results.size)
		assertEquals("StringType1.java", results.head.fileName)
		assertEquals(javaClass.toString, results.head.contents)
	}
	
	@Test
	def void testClassifierType() {
		val propertySet = '''
			property set ps1 is
				classifier_type_1: type classifier;
			end ps1;
		'''
		val javaClass = '''
			package ps1;
			
			import org.osate.aadl2.Classifier;
			import org.osate.aadl2.ClassifierValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class ClassifierType1 {
				public static Classifier getValue(PropertyExpression propertyExpression) {
					return ((ClassifierValue) propertyExpression).getClassifier();
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(propertySet))
		assertEquals(1, results.size)
		assertEquals("ClassifierType1.java", results.head.fileName)
		assertEquals(javaClass.toString, results.head.contents)
	}
	
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
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			
			public enum UnitsType1 {
				MM(1.0, "mm"),
				CM(10.0, "cm"),
				INCH(25.4, "inch"),
				FT(304.8, "ft"),
				M(1000.0, "m");
				
				private final double factorToBase;
				private final String originalName;
				
				private UnitsType1(double factorToBase, String originalName) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
				}
				
				public static UnitsType1 getValue(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				public double getFactorToBase() {
					return factorToBase;
				}
				
				public double getFactorTo(UnitsType1 target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
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
		val integerReferencedUnitsLocal = '''
			package ps1;
			
			import java.util.Objects;
			
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.PropertyExpression;
			
			public class IntegerReferencedUnitsLocal {
				private final long value;
				private final Time unit;
				
				private IntegerReferencedUnitsLocal(PropertyExpression propertyExpression) {
					IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
					value = numberValue.getValue();
					unit = Time.valueOf(numberValue.getUnit().getName().toUpperCase());
				}
				
				public static IntegerReferencedUnitsLocal getValue(PropertyExpression propertyExpression) {
					return new IntegerReferencedUnitsLocal(propertyExpression);
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
					if (!(obj instanceof IntegerReferencedUnitsLocal)) {
						return false;
					}
					IntegerReferencedUnitsLocal other = (IntegerReferencedUnitsLocal) obj;
					return value == other.value && unit == other.unit;
				}
				
				@Override
				public String toString() {
					return value + unit.toString();
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
	
	@Test
	def void testRealType() {
		val ps2 = '''
			property set ps2 is
				mass: type units (g, kg => g * 1000);
			end ps2;
		'''
		val ps1 = '''
			property set ps1 is
				with ps2;
				
				time: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				
				real_no_units: type aadlreal;
				real_owned_units: type aadlreal units (ml, cl => ml * 10, l => cl * 100);
				real_referenced_units_local: type aadlreal units ps1::time;
				real_referenced_units_other_file: type aadlreal units ps2::mass;
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
		val realNoUnits = '''
			package ps1;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			
			public class RealNoUnits {
				public static double getValue(PropertyExpression propertyExpression) {
					return ((RealLiteral) propertyExpression).getValue();
				}
			}
		'''
		val realOwnedUnits = '''
			package ps1;
			
			import java.util.Objects;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			
			public class RealOwnedUnits {
				private final double value;
				private final Units unit;
				
				private RealOwnedUnits(PropertyExpression propertyExpression) {
					RealLiteral numberValue = (RealLiteral) propertyExpression;
					value = numberValue.getValue();
					unit = Units.valueOf(numberValue.getUnit().getName().toUpperCase());
				}
				
				public static RealOwnedUnits getValue(PropertyExpression propertyExpression) {
					return new RealOwnedUnits(propertyExpression);
				}
				
				public double getValue() {
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
					if (!(obj instanceof RealOwnedUnits)) {
						return false;
					}
					RealOwnedUnits other = (RealOwnedUnits) obj;
					return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value) && unit == other.unit;
				}
				
				@Override
				public String toString() {
					return value + unit.toString();
				}
				
				public enum Units {
					ML(1.0, "ml"),
					CL(10.0, "cl"),
					L(1000.0, "l");
					
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
		val realReferencedUnitsLocal = '''
			package ps1;
			
			import java.util.Objects;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			
			public class RealReferencedUnitsLocal {
				private final double value;
				private final Time unit;
				
				private RealReferencedUnitsLocal(PropertyExpression propertyExpression) {
					RealLiteral numberValue = (RealLiteral) propertyExpression;
					value = numberValue.getValue();
					unit = Time.valueOf(numberValue.getUnit().getName().toUpperCase());
				}
				
				public static RealReferencedUnitsLocal getValue(PropertyExpression propertyExpression) {
					return new RealReferencedUnitsLocal(propertyExpression);
				}
				
				public double getValue() {
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
					if (!(obj instanceof RealReferencedUnitsLocal)) {
						return false;
					}
					RealReferencedUnitsLocal other = (RealReferencedUnitsLocal) obj;
					return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value) && unit == other.unit;
				}
				
				@Override
				public String toString() {
					return value + unit.toString();
				}
			}
		'''
		val realReferencedUnitsOtherFile = '''
			package ps1;
			
			import java.util.Objects;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			
			import ps2.Mass;
			
			public class RealReferencedUnitsOtherFile {
				private final double value;
				private final Mass unit;
				
				private RealReferencedUnitsOtherFile(PropertyExpression propertyExpression) {
					RealLiteral numberValue = (RealLiteral) propertyExpression;
					value = numberValue.getValue();
					unit = Mass.valueOf(numberValue.getUnit().getName().toUpperCase());
				}
				
				public static RealReferencedUnitsOtherFile getValue(PropertyExpression propertyExpression) {
					return new RealReferencedUnitsOtherFile(propertyExpression);
				}
				
				public double getValue() {
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
					if (!(obj instanceof RealReferencedUnitsOtherFile)) {
						return false;
					}
					RealReferencedUnitsOtherFile other = (RealReferencedUnitsOtherFile) obj;
					return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value) && unit == other.unit;
				}
				
				@Override
				public String toString() {
					return value + unit.toString();
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(ps1, ps2))
		assertEquals(5, results.size)
		
		assertEquals("Time.java", results.get(0).fileName)
		assertEquals(time.toString, results.get(0).contents)
		
		assertEquals("RealNoUnits.java", results.get(1).fileName)
		assertEquals(realNoUnits.toString, results.get(1).contents)
		
		assertEquals("RealOwnedUnits.java", results.get(2).fileName)
		assertEquals(realOwnedUnits.toString, results.get(2).contents)
		
		assertEquals("RealReferencedUnitsLocal.java", results.get(3).fileName)
		assertEquals(realReferencedUnitsLocal.toString, results.get(3).contents)
		
		assertEquals("RealReferencedUnitsOtherFile.java", results.get(4).fileName)
		assertEquals(realReferencedUnitsOtherFile.toString, results.get(4).contents)
	}
	
	@Test
	def void testReferenceType() {
		val propertySet = '''
			property set ps1 is
				reference_type_1: type reference;
			end ps1;
		'''
		val javaClass = '''
			package ps1;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
			
			public class ReferenceType1 {
				public static InstanceObject getValue(PropertyExpression propertyExpression) {
					return ((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject();
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(propertySet))
		assertEquals(1, results.size)
		assertEquals("ReferenceType1.java", results.head.fileName)
		assertEquals(javaClass.toString, results.head.contents)
	}
}