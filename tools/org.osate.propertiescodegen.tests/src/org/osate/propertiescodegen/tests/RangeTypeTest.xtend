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
class RangeTypeTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testRangeType() {
		val ps2 = '''
			property set ps2 is
				mass: type units (g, kg => g * 1000);
				
				mass_type: type aadlreal units ps2::mass;
			end ps2;
		'''
		val ps1 = '''
			property set ps1 is
				with ps2;
				
				time: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				
				integer_no_units: type aadlinteger;
				integer_owned_units: type aadlinteger units (mm, cm => mm * 10, m => cm * 100);
				real_no_units: type aadlreal;
				
				range_of_integer_no_units: type range of aadlinteger;
				range_of_integer_owned_units: type range of aadlinteger units (g, kg => g * 1000);
				range_of_integer_referenced_units_local: type range of aadlinteger units ps1::time;
				range_of_integer_referenced_units_other_file: type range of aadlinteger units ps2::mass;
				range_of_real_no_units: type range of aadlreal;
				range_of_real_owned_units: type range of aadlreal units (mN, cN => mN * 10, N => cN * 100);
				range_of_real_referenced_units_local: type range of aadlreal units ps1::time;
				range_of_real_referenced_units_other_file: type range of aadlreal units ps2::mass;
				range_of_referenced_integer_no_units: type range of ps1::integer_no_units;
				range_of_referenced_real_no_units: type range of ps1::real_no_units;
				range_of_referenced_number_local: type range of ps1::integer_owned_units;
				range_of_referenced_number_other_file: type range of ps2::mass_type;
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
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val rangeOfIntegerOwnedUnits = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum RangeOfIntegerOwnedUnits implements GeneratedUnits<RangeOfIntegerOwnedUnits> {
				G(1.0, "g", "__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				KG(1000.0, "kg", "__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private RangeOfIntegerOwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static RangeOfIntegerOwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(RangeOfIntegerOwnedUnits target) {
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
		val rangeOfRealOwnedUnits = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum RangeOfRealOwnedUnits implements GeneratedUnits<RangeOfRealOwnedUnits> {
				MN(1.0, "mN", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				CN(10.0, "cN", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1"),
				N(1000.0, "N", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedNumberType/@ownedUnitsType/@ownedLiteral.2");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private RangeOfRealOwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static RangeOfRealOwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(RangeOfRealOwnedUnits target) {
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
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(ps1, ps2))
		assertEquals("src-gen/ps1", results.packagePath)
		assertEquals(5, results.classes.size)
		
		assertEquals("Ps1.java", results.classes.get(0).fileName)
		assertEquals(ps1Class.toString, results.classes.get(0).contents)
		
		assertEquals("Time.java", results.classes.get(1).fileName)
		assertEquals(time.toString, results.classes.get(1).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.classes.get(2).fileName)
		assertEquals(integerOwnedUnits.toString, results.classes.get(2).contents)
		
		assertEquals("RangeOfIntegerOwnedUnits.java", results.classes.get(3).fileName)
		assertEquals(rangeOfIntegerOwnedUnits.toString, results.classes.get(3).contents)
		
		assertEquals("RangeOfRealOwnedUnits.java", results.classes.get(4).fileName)
		assertEquals(rangeOfRealOwnedUnits.toString, results.classes.get(4).contents)
	}
}