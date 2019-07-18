package org.osate.core.tests.formatter

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.FormatterTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.testsupport.Aadl2InjectorProvider

/*
 * Some of the tests have useSerializer set to false. This has to do with the customizations done in
 * Aadl2TextRegionAccessBuilder. In that class, we customize the node model version to create hidden regions in
 * keyword-only parser rules. We did not customize the serializer version. For formatter tests that include these
 * keyword-only rules, useSerializer must be set to false or a comparison failure will occur because the text region
 * from the node model doesn't match the text region from the serializer.
 */
@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class FormatterTest extends XtextTest {
	@Inject
	extension FormatterTestHelper
	
	@Test
	def void testPropertySet() {
		//Empty property set
		assertFormatted[
			expectation = '''
				property set ps1 is
				end ps1;'''
			toBeFormatted = "property set ps1 is end ps1;"
		]
		
		//With statements only
		assertFormatted[
			expectation = '''
				property set ps1 is
					with ps2, ps3, ps4;
					with ps5;
				end ps1;'''
			toBeFormatted = "property set ps1 is with ps2,ps3,ps4;with ps5;end ps1;"
		]
		
		//With statement and content (property type)
		assertFormatted[
			expectation = '''
				property set ps1 is
					with ps2;
				
					type1: type aadlboolean;
				end ps1;'''
			toBeFormatted = "property set ps1 is with ps2;type1:type aadlboolean;end ps1;"
		]
	}
	
	@Test
	def void testBooleanType() {
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlboolean;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlboolean;end ps1;"
		]
	}
	
	@Test
	def void testStringType() {
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlstring;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlstring;end ps1;"
		]
	}
	
	@Test
	def void testEnumerationType() {
		//Fits on one line
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type enumeration (literal1, literal2, literal3);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type enumeration(literal1,literal2,literal3);end ps1;"
		]
		
		//Wrapped
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type enumeration (literal1, literal2, literal3, literal4, literal5, literal6, literal7, literal8, literal9,
						literal10, literal11, literal12, literal13, literal14, literal15, literal16, literal17, literal18, literal19,
						literal20);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type enumeration(literal1,literal2,literal3,literal4,literal5,literal6," +
					"literal7,literal8,literal9,literal10,literal11,literal12,literal13,literal14,literal15,literal16,literal17," +
					"literal18,literal19,literal20);end ps1;"
		]
		
		//Existing newlines with wrapping
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type enumeration (
						literal1, literal2,
						literal3,
						literal4, literal5, literal6, literal7, literal8, literal9, literal10, literal11, literal12, literal13,
						literal14, literal15, literal16, literal17
					);
					type2: type enumeration (literal1, literal2,
						literal3,
						literal4, literal5, literal6, literal7, literal8, literal9, literal10, literal11, literal12, literal13,
						literal14, literal15, literal16, literal17);
				end ps1;'''
			toBeFormatted = '''
				property set ps1 is type1:type enumeration(
				literal1,literal2,
				literal3,
				literal4,literal5,literal6,literal7,literal8,literal9,literal10,literal11,literal12,literal13,literal14,literal15,literal16,literal17
				);type2:type enumeration(literal1,literal2,
				literal3,
				literal4,literal5,literal6,literal7,literal8,literal9,literal10,literal11,literal12,literal13,literal14,literal15,literal16,literal17);end ps1;
			'''
		]
	}
	
	@Test
	def void testUnitsType() {
		//Fits on one line
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type units (unit1, unit2 => unit1 * 10, unit3 => unit2 * 10);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type units(unit1,unit2=>unit1*10,unit3=>unit2*10);end ps1;"
		]
		
		//Wrapped
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type units (unit1, unit2 => unit1 * 10, unit3 => unit2 * +10, unit4 => unit3 * -10, unit5 => unit4 * 10.5,
						unit6 => unit5 * +10.5, unit7 => unit6 * -10.5);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type units(unit1,unit2=>unit1*10,unit3=>unit2*+10,unit4=>unit3*-10," +
					"unit5=>unit4*10.5,unit6=>unit5*+10.5,unit7=>unit6*-10.5);end ps1;"
		]
		
		//Existing newlines with wrapping
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type units (
						unit1, unit2 => unit1 * 10,
						unit3 => unit2 * 10,
						unit4 => unit3 * 10, unit5 => unit4 * 10, unit6 => unit5 * 10, unit7 => unit6 * 10, unit8 => unit7 * 10,
						unit9 => unit8 * 10, unit10 => unit9 * 10
					);
					type2: type units (unit1, unit2 => unit1 * 10,
						unit3 => unit2 * 10,
						unit4 => unit3 * 10, unit5 => unit4 * 10, unit6 => unit5 * 10, unit7 => unit6 * 10, unit8 => unit7 * 10,
						unit9 => unit8 * 10, unit10 => unit9 * 10);
				end ps1;'''
			toBeFormatted = '''
				property set ps1 is type1:type units(
				unit1,unit2=>unit1*10,
				unit3=>unit2*10,
				unit4=>unit3*10,unit5=>unit4*10,unit6=>unit5*10,unit7=>unit6*10,unit8=>unit7*10,unit9=>unit8*10,unit10=>unit9*10
				);type2:type units(unit1,unit2=>unit1*10,
				unit3=>unit2*10,
				unit4=>unit3*10,unit5=>unit4*10,unit6=>unit5*10,unit7=>unit6*10,unit8=>unit7*10,unit9=>unit8*10,unit10=>unit9*10);end ps1;'''
		]
	}
	
	@Test
	def void testRealType() {
		//Simple type
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlreal;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlreal;end ps1;"
		]
		
		//With referenced units
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlreal units ps1::units1;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlreal units ps1::units1;end ps1;"
		]
		
		//With owned units
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlreal units (unit1, unit2 => unit1 * 10, unit3 => unit2 * 10, unit4 => unit3 * 10,
						unit5 => unit4 * 10);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlreal units(unit1,unit2=>unit1*10,unit3=>unit2*10,unit4=>unit3*10,unit5=>unit4*10);end ps1;"
		]
		
		//With range
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlreal ps1::const1 .. 10.0;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlreal ps1::const1..10.0;end ps1;"
		]
		
		//With range and referenced units
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlreal 1.0 unit1 .. 10.0 unit1 units ps1::units1;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlreal 1.0unit1..10.0unit1 units ps1::units1;end ps1;"
		]
		
		//With range of operations
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlreal -ps1::const1 .. +ps1::const1;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlreal-ps1::const1..+ps1::const1;end ps1;"
		]
		
		//With range and owned units
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlreal 1.0 unit1 .. 1.0 unit2 units (unit1, unit2 => unit1 * 10);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlreal 1.0unit1..1.0unit2 units(unit1,unit2=>unit1*10);end ps1;"
		]
	}
	
	@Test
	def void testIntegerType() {
		//Simple type
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlinteger;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlinteger;end ps1;"
		]
		
		//With referenced units
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlinteger units ps1::units1;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlinteger units ps1::units1;end ps1;"
		]
		
		//With owned units
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlinteger units (unit1, unit2 => unit1 * 10, unit3 => unit2 * 10, unit4 => unit3 * 10,
						unit5 => unit4 * 10);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlinteger units(unit1,unit2=>unit1*10,unit3=>unit2*10,unit4=>unit3*10,unit5=>unit4*10);end ps1;"
		]
		
		//With range
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlinteger ps1::const1 .. 10;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlinteger ps1::const1..10;end ps1;"
		]
		
		//With range and referenced units
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlinteger 1 unit1 .. 10 unit1 units ps1::units1;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlinteger 1unit1..10unit1 units ps1::units1;end ps1;"
		]
		
		//With range of operations
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlinteger -ps1::const1 .. +ps1::const1;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlinteger-ps1::const1..+ps1::const1;end ps1;"
		]
		
		//With range and owned units
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type aadlinteger 1 unit1 .. 1 unit2 units (unit1, unit2 => unit1 * 10);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type aadlinteger 1unit1..1unit2 units(unit1,unit2=>unit1*10);end ps1;"
		]
	}
	
	@Test
	def void testRangeType() {
		//Referenced number type
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type range of ps1::type2;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type range of ps1::type2;end ps1;"
		]
		
		//Owned integer type
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type range of aadlinteger;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type range of aadlinteger;end ps1;"
		]
		
		//Owned integer type with range
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type range of aadlinteger 1 .. 10;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type range of aadlinteger 1 ..10;end ps1;"
		]
		
		//Owned integer type with referenced units
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type range of aadlinteger units ps1::units1;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type range of aadlinteger units ps1::units1;end ps1;"
		]
		
		//Owned integer type with range and referenced units
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type range of aadlinteger 1m .. 10m units ps1::units1;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type range of aadlinteger 1m..10m units ps1::units1;end ps1;"
		]
		
		//Owned integer type with owned units
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type range of aadlinteger units (unit1, unit2 => unit1 * 10);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type range of aadlinteger units(unit1,unit2=>unit1*10);end ps1;"
		]
		
		//Owned integer type with range and owned units
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type range of aadlinteger 1m .. 1km units (m, km => m * 1000);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type range of aadlinteger 1m..1km units(m,km=>m*1000);end ps1;"
		]
		
		//Owned real type
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type range of aadlreal;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type range of aadlreal;end ps1;"
		]
		
		//Owned real type with range
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type range of aadlreal 1.0 .. 10.0;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type range of aadlreal 1.0..10.0;end ps1;"
		]
		
		//Owned real type with referenced units
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type range of aadlreal units ps1::units1;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type range of aadlreal units ps1::units1;end ps1;"
		]
		
		//Owned real type with range and referenced units
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type range of aadlreal 1.0m .. 10.0m units ps1::units1;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type range of aadlreal 1.0m..10.0m units ps1::units1;end ps1;"
		]
		
		//Owned real type with owned units
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type range of aadlreal units (unit1, unit2 => unit1 * 10);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type range of aadlreal units(unit1,unit2=>unit1*10);end ps1;"
		]
		
		//Owned real type with range and owned units
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type range of aadlreal 1.0m .. 1.0km units (m, km => m * 1000);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type range of aadlreal 1.0m..1.0km units(m,km=>m*1000);end ps1;"
		]
	}
	
	@Test
	def void testClassifierType() {
		//Simple type
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type classifier;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type classifier;end ps1;"
		]
		
		//With classifier references
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type classifier (bus, feature group type, {annex1}**elem1);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type classifier(bus,feature group type,{annex1}**elem1);end ps1;"
		]
	}
	
	@Test
	def void testReferenceType() {
		//Simple type
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type reference;
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type reference;end ps1;"
		]
		
		//With named element references
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type reference (bus, event data port, {annex1}**elem1);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type reference(bus,event data port,{annex1}**elem1);end ps1;"
		]
	}
	
	@Test
	def void testRecordType() {
		//Referenced property type
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type record (field1: ps1::type2;);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type record(field1:ps1::type2;);end ps1;"
		]
		
		//Referenced property type, wrapped
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type record (field1: ps1::type2; field2: ps1::type2; field3: ps1::type2; field4: ps1::type2;
						field5: ps1::type2;);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type record(field1:ps1::type2;field2:ps1::type2;field3:ps1::type2;" +
					"field4:ps1::type2;field5:ps1::type2;);end ps1;"
		]
		
		//Owned property type
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type record (field1: aadlinteger;);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type record(field1:aadlinteger;);end ps1;"
		]
		
		//Owned property type, wrapped
		assertFormatted[
			expectation = '''
				property set ps1 is
					type1: type record (field1: aadlinteger; field2: aadlinteger; field3: aadlinteger; field4: aadlinteger;
						field5: aadlinteger;);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type record(field1:aadlinteger;field2:aadlinteger;field3:aadlinteger;" +
					"field4:aadlinteger;field5:aadlinteger;);end ps1;"
		]
	}
	
	@Test
	def void testListType() {
		//Referenced element type
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type record (field1: list of ps1::type2;);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type record(field1:list of ps1::type2;);end ps1;"
		]
		
		//Owned element type
		assertFormatted[
			useSerializer = false
			expectation = '''
				property set ps1 is
					type1: type record (field1: list of aadlinteger;);
				end ps1;'''
			toBeFormatted = "property set ps1 is type1:type record(field1:list of aadlinteger;);end ps1;"
		]
	}
}