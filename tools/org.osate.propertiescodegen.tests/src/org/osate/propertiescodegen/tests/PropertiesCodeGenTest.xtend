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
			package enumtest;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			
			public enum EnumType1 {
				ONE("one", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				TWO("two", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				THREE("three", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2");
				
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
				
				public EnumerationLiteral toEnumerationLiteral(ResourceSet resourceSet) {
					EnumerationLiteral literal = (EnumerationLiteral) resourceSet.getEObject(uri, true);
					if (literal == null) {
						throw new RuntimeException("Could not resolve EnumerationLiteral '" + originalName + "'.");
					}
					return literal;
				}
				
				public NamedValue toPropertyExpression(ResourceSet resourceSet) {
					NamedValue value = Aadl2Factory.eINSTANCE.createNamedValue();
					value.setNamedValue(toEnumerationLiteral(resourceSet));
					return value;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(propertySet))
		assertEquals("src-gen/enumtest", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("EnumType1.java", results.classes.head.fileName)
		assertEquals(javaClass.toString, results.classes.head.contents)
	}
	
	@Test
	def void testUnitsType() {
		val propertySet = '''
			property set units_test is
				units_type_1: type units (mm, cm => mm * 10, m => cm * 100, inch => cm * 2.54, ft => inch * 12);
			end units_test;
		'''
		val javaClass = '''
			package unitstest;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum UnitsType1 implements GeneratedUnits<UnitsType1> {
				MM(1.0, "mm", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				CM(10.0, "cm", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				INCH(25.4, "inch", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3"),
				FT(304.8, "ft", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.4"),
				M(1000.0, "m", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private UnitsType1(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static UnitsType1 valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(UnitsType1 target) {
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
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(propertySet))
		assertEquals("src-gen/unitstest", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("UnitsType1.java", results.classes.head.fileName)
		assertEquals(javaClass.toString, results.classes.head.contents)
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
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
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
		val integerOwnedUnits = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum IntegerOwnedUnits implements GeneratedUnits<IntegerOwnedUnits> {
				MM(1.0, "mm", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedUnitsType/@ownedLiteral.0"),
				CM(10.0, "cm", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedUnitsType/@ownedLiteral.1"),
				M(1000.0, "m", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedUnitsType/@ownedLiteral.2");
				
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
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(ps1, ps2))
		assertEquals("src-gen/ps1", results.packagePath)
		assertEquals(2, results.classes.size)
		
		assertEquals("Time.java", results.classes.get(0).fileName)
		assertEquals(time.toString, results.classes.get(0).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.classes.get(1).fileName)
		assertEquals(integerOwnedUnits.toString, results.classes.get(1).contents)
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
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
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
		val realOwnedUnits = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum RealOwnedUnits implements GeneratedUnits<RealOwnedUnits> {
				ML(1.0, "ml", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedUnitsType/@ownedLiteral.0"),
				CL(10.0, "cl", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedUnitsType/@ownedLiteral.1"),
				L(1000.0, "l", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedUnitsType/@ownedLiteral.2");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private RealOwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static RealOwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(RealOwnedUnits target) {
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
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(ps1, ps2))
		assertEquals("src-gen/ps1", results.packagePath)
		assertEquals(2, results.classes.size)
		
		assertEquals("Time.java", results.classes.get(0).fileName)
		assertEquals(time.toString, results.classes.get(0).contents)
		
		assertEquals("RealOwnedUnits.java", results.classes.get(1).fileName)
		assertEquals(realOwnedUnits.toString, results.classes.get(1).contents)
	}
}