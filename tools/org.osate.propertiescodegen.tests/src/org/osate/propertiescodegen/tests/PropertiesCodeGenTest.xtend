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
				M(1000.0),
				INCH(25.4),
				FT(304.8);
				
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
}