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
		}'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(propertySet))
		assertEquals(1, results.size)
		assertEquals("EnumType1.java", results.head.fileName)
		assertEquals(javaClass.toString, results.head.contents)
	}
}