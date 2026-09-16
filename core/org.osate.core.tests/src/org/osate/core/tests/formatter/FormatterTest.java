/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.formatter;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.testsupport.Aadl2InjectorProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.itemis.xtext.testing.XtextTest;

/*
 * Some of the tests use assertFormattedWithoutSerializer. This has to do with the customizations done in
 * Aadl2TextRegionAccessBuilder. In that class, we customize the node model version to create hidden regions in
 * keyword-only parser rules. We did not customize the serializer version. For formatter tests that include these
 * keyword-only rules, the serializer must not be used or a comparison failure will occur because the text region
 * from the node model doesn't match the text region from the serializer.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class FormatterTest extends XtextTest {
	@Inject
	private FormatterTestHelper formatterTestHelper;

	@Inject
	private Provider<FormatterTestRequest> formatterTestRequestProvider;

	@Test
	public void testPropertySet() {
		// Empty property set
		assertFormatted("""
				property set ps1 is
				end ps1;""", "property set ps1 is end ps1;");

		// With statements only
		assertFormatted("""
				property set ps1 is
					with ps2, ps3, ps4;
					with ps5;
				end ps1;""", "property set ps1 is with ps2,ps3,ps4;with ps5;end ps1;");

		// With statement and content (property type)
		assertFormatted("""
				property set ps1 is
					with ps2;

					type1: type aadlboolean;
				end ps1;""", "property set ps1 is with ps2;type1:type aadlboolean;end ps1;");
	}

	@Test
	public void testBooleanType() {
		assertFormatted("""
				property set ps1 is
					type1: type aadlboolean;
				end ps1;""", "property set ps1 is type1:type aadlboolean;end ps1;");
	}

	@Test
	public void testStringType() {
		assertFormatted("""
				property set ps1 is
					type1: type aadlstring;
				end ps1;""", "property set ps1 is type1:type aadlstring;end ps1;");
	}

	@Test
	public void testEnumerationType() {
		// Fits on one line
		assertFormatted("""
				property set ps1 is
					type1: type enumeration (literal1, literal2, literal3);
				end ps1;""", "property set ps1 is type1:type enumeration(literal1,literal2,literal3);end ps1;");

		// Wrapped
		assertFormatted("""
				property set ps1 is
					type1: type enumeration (literal1, literal2, literal3, literal4, literal5, literal6, literal7, literal8, literal9,
						literal10, literal11, literal12, literal13, literal14, literal15, literal16, literal17, literal18, literal19,
						literal20);
				end ps1;""",
				"property set ps1 is type1:type enumeration(literal1,literal2,literal3,literal4,literal5,literal6,"
						+ "literal7,literal8,literal9,literal10,literal11,literal12,literal13,literal14,literal15,literal16,literal17,"
						+ "literal18,literal19,literal20);end ps1;");

		// Existing newlines with wrapping
		assertFormatted("""
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
				end ps1;""", """
				property set ps1 is type1:type enumeration(
				literal1,literal2,
				literal3,
				literal4,literal5,literal6,literal7,literal8,literal9,literal10,literal11,literal12,literal13,literal14,literal15,literal16,literal17
				);type2:type enumeration(literal1,literal2,
				literal3,
				literal4,literal5,literal6,literal7,literal8,literal9,literal10,literal11,literal12,literal13,literal14,literal15,literal16,literal17);end ps1;
				""");
	}

	@Test
	public void testUnitsType() {
		// Fits on one line
		assertFormatted("""
				property set ps1 is
					type1: type units (unit1, unit2 => unit1 * 10, unit3 => unit2 * 10);
				end ps1;""", "property set ps1 is type1:type units(unit1,unit2=>unit1*10,unit3=>unit2*10);end ps1;");

		// Wrapped
		assertFormatted("""
				property set ps1 is
					type1: type units (unit1, unit2 => unit1 * 10, unit3 => unit2 * +10, unit4 => unit3 * -10, unit5 => unit4 * 10.5,
						unit6 => unit5 * +10.5, unit7 => unit6 * -10.5);
				end ps1;""",
				"property set ps1 is type1:type units(unit1,unit2=>unit1*10,unit3=>unit2*+10,unit4=>unit3*-10,"
						+ "unit5=>unit4*10.5,unit6=>unit5*+10.5,unit7=>unit6*-10.5);end ps1;");

		// Existing newlines with wrapping
		assertFormatted("""
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
				end ps1;""", """
				property set ps1 is type1:type units(
				unit1,unit2=>unit1*10,
				unit3=>unit2*10,
				unit4=>unit3*10,unit5=>unit4*10,unit6=>unit5*10,unit7=>unit6*10,unit8=>unit7*10,unit9=>unit8*10,unit10=>unit9*10
				);type2:type units(unit1,unit2=>unit1*10,
				unit3=>unit2*10,
				unit4=>unit3*10,unit5=>unit4*10,unit6=>unit5*10,unit7=>unit6*10,unit8=>unit7*10,unit9=>unit8*10,unit10=>unit9*10);end ps1;""");
	}

	@Test
	public void testRealType() {
		// Simple type
		assertFormatted("""
				property set ps1 is
					type1: type aadlreal;
				end ps1;""", "property set ps1 is type1:type aadlreal;end ps1;");

		// With referenced units
		assertFormatted("""
				property set ps1 is
					type1: type aadlreal units ps1::units1;
				end ps1;""", "property set ps1 is type1:type aadlreal units ps1::units1;end ps1;");

		// With owned units
		assertFormatted("""
				property set ps1 is
					type1: type aadlreal units (unit1, unit2 => unit1 * 10, unit3 => unit2 * 10, unit4 => unit3 * 10,
						unit5 => unit4 * 10);
				end ps1;""",
				"property set ps1 is type1:type aadlreal units(unit1,unit2=>unit1*10,unit3=>unit2*10,unit4=>unit3*10,unit5=>unit4*10);end ps1;");

		// With range
		assertFormatted("""
				property set ps1 is
					type1: type aadlreal ps1::const1 .. 10.0;
				end ps1;""", "property set ps1 is type1:type aadlreal ps1::const1..10.0;end ps1;");

		// With range and referenced units
		assertFormatted("""
				property set ps1 is
					type1: type aadlreal 1.0 unit1 .. 10.0 unit1 units ps1::units1;
				end ps1;""", "property set ps1 is type1:type aadlreal 1.0unit1..10.0unit1 units ps1::units1;end ps1;");

		// With range of operations
		assertFormatted("""
				property set ps1 is
					type1: type aadlreal -ps1::const1 .. +ps1::const1;
				end ps1;""", "property set ps1 is type1:type aadlreal-ps1::const1..+ps1::const1;end ps1;");

		// With range and owned units
		assertFormatted("""
				property set ps1 is
					type1: type aadlreal 1.0 unit1 .. 1.0 unit2 units (unit1, unit2 => unit1 * 10);
				end ps1;""",
				"property set ps1 is type1:type aadlreal 1.0unit1..1.0unit2 units(unit1,unit2=>unit1*10);end ps1;");
	}

	@Test
	public void testIntegerType() {
		// Simple type
		assertFormatted("""
				property set ps1 is
					type1: type aadlinteger;
				end ps1;""", "property set ps1 is type1:type aadlinteger;end ps1;");

		// With referenced units
		assertFormatted("""
				property set ps1 is
					type1: type aadlinteger units ps1::units1;
				end ps1;""", "property set ps1 is type1:type aadlinteger units ps1::units1;end ps1;");

		// With owned units
		assertFormatted("""
				property set ps1 is
					type1: type aadlinteger units (unit1, unit2 => unit1 * 10, unit3 => unit2 * 10, unit4 => unit3 * 10,
						unit5 => unit4 * 10);
				end ps1;""",
				"property set ps1 is type1:type aadlinteger units(unit1,unit2=>unit1*10,unit3=>unit2*10,unit4=>unit3*10,unit5=>unit4*10);end ps1;");

		// With range
		assertFormatted("""
				property set ps1 is
					type1: type aadlinteger ps1::const1 .. 10;
				end ps1;""", "property set ps1 is type1:type aadlinteger ps1::const1..10;end ps1;");

		// With range and referenced units
		assertFormatted("""
				property set ps1 is
					type1: type aadlinteger 1 unit1 .. 10 unit1 units ps1::units1;
				end ps1;""", "property set ps1 is type1:type aadlinteger 1unit1..10unit1 units ps1::units1;end ps1;");

		// With range of operations
		assertFormatted("""
				property set ps1 is
					type1: type aadlinteger -ps1::const1 .. +ps1::const1;
				end ps1;""", "property set ps1 is type1:type aadlinteger-ps1::const1..+ps1::const1;end ps1;");

		// With range and owned units
		assertFormatted("""
				property set ps1 is
					type1: type aadlinteger 1 unit1 .. 1 unit2 units (unit1, unit2 => unit1 * 10);
				end ps1;""",
				"property set ps1 is type1:type aadlinteger 1unit1..1unit2 units(unit1,unit2=>unit1*10);end ps1;");
	}

	@Test
	public void testRangeType() {
		// Referenced number type
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type range of ps1::type2;
				end ps1;""", "property set ps1 is type1:type range of ps1::type2;end ps1;");

		// Owned integer type
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type range of aadlinteger;
				end ps1;""", "property set ps1 is type1:type range of aadlinteger;end ps1;");

		// Owned integer type with range
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type range of aadlinteger 1 .. 10;
				end ps1;""", "property set ps1 is type1:type range of aadlinteger 1 ..10;end ps1;");

		// Owned integer type with referenced units
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type range of aadlinteger units ps1::units1;
				end ps1;""", "property set ps1 is type1:type range of aadlinteger units ps1::units1;end ps1;");

		// Owned integer type with range and referenced units
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type range of aadlinteger 1m .. 10m units ps1::units1;
				end ps1;""", "property set ps1 is type1:type range of aadlinteger 1m..10m units ps1::units1;end ps1;");

		// Owned integer type with owned units
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type range of aadlinteger units (unit1, unit2 => unit1 * 10);
				end ps1;""", "property set ps1 is type1:type range of aadlinteger units(unit1,unit2=>unit1*10);end ps1;");

		// Owned integer type with range and owned units
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type range of aadlinteger 1m .. 1km units (m, km => m * 1000);
				end ps1;""", "property set ps1 is type1:type range of aadlinteger 1m..1km units(m,km=>m*1000);end ps1;");

		// Owned real type
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type range of aadlreal;
				end ps1;""", "property set ps1 is type1:type range of aadlreal;end ps1;");

		// Owned real type with range
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type range of aadlreal 1.0 .. 10.0;
				end ps1;""", "property set ps1 is type1:type range of aadlreal 1.0..10.0;end ps1;");

		// Owned real type with referenced units
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type range of aadlreal units ps1::units1;
				end ps1;""", "property set ps1 is type1:type range of aadlreal units ps1::units1;end ps1;");

		// Owned real type with range and referenced units
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type range of aadlreal 1.0m .. 10.0m units ps1::units1;
				end ps1;""", "property set ps1 is type1:type range of aadlreal 1.0m..10.0m units ps1::units1;end ps1;");

		// Owned real type with owned units
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type range of aadlreal units (unit1, unit2 => unit1 * 10);
				end ps1;""", "property set ps1 is type1:type range of aadlreal units(unit1,unit2=>unit1*10);end ps1;");

		// Owned real type with range and owned units
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type range of aadlreal 1.0m .. 1.0km units (m, km => m * 1000);
				end ps1;""", "property set ps1 is type1:type range of aadlreal 1.0m..1.0km units(m,km=>m*1000);end ps1;");
	}

	@Test
	public void testClassifierType() {
		// Simple type
		assertFormatted("""
				property set ps1 is
					type1: type classifier;
				end ps1;""", "property set ps1 is type1:type classifier;end ps1;");

		// With classifier references
		assertFormatted("""
				property set ps1 is
					type1: type classifier (bus, feature group type, {annex1}**elem1);
				end ps1;""",
				"property set ps1 is type1:type classifier(bus,feature group type,{annex1}**elem1);end ps1;");
	}

	@Test
	public void testReferenceType() {
		// Simple type
		assertFormatted("""
				property set ps1 is
					type1: type reference;
				end ps1;""", "property set ps1 is type1:type reference;end ps1;");

		// With named element references
		assertFormatted("""
				property set ps1 is
					type1: type reference (bus, event data port, {annex1}**elem1);
				end ps1;""",
				"property set ps1 is type1:type reference(bus,event data port,{annex1}**elem1);end ps1;");
	}

	@Test
	public void testRecordType() {
		// Referenced property type
		assertFormatted("""
				property set ps1 is
					type1: type record (field1: ps1::type2;);
				end ps1;""", "property set ps1 is type1:type record(field1:ps1::type2;);end ps1;");

		// Referenced property type, wrapped
		assertFormatted("""
				property set ps1 is
					type1: type record (field1: ps1::type2; field2: ps1::type2; field3: ps1::type2; field4: ps1::type2;
						field5: ps1::type2;);
				end ps1;""",
				"property set ps1 is type1:type record(field1:ps1::type2;field2:ps1::type2;field3:ps1::type2;"
						+ "field4:ps1::type2;field5:ps1::type2;);end ps1;");

		// Owned property type
		assertFormatted("""
				property set ps1 is
					type1: type record (field1: aadlinteger;);
				end ps1;""", "property set ps1 is type1:type record(field1:aadlinteger;);end ps1;");

		// Owned property type, wrapped
		assertFormatted("""
				property set ps1 is
					type1: type record (field1: aadlinteger; field2: aadlinteger; field3: aadlinteger; field4: aadlinteger;
						field5: aadlinteger;);
				end ps1;""",
				"property set ps1 is type1:type record(field1:aadlinteger;field2:aadlinteger;field3:aadlinteger;"
						+ "field4:aadlinteger;field5:aadlinteger;);end ps1;");
	}

	@Test
	public void testListType() {
		// Referenced element type
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type record (field1: list of ps1::type2;);
				end ps1;""", "property set ps1 is type1:type record(field1:list of ps1::type2;);end ps1;");

		// Owned element type
		assertFormattedWithoutSerializer("""
				property set ps1 is
					type1: type record (field1: list of aadlinteger;);
				end ps1;""", "property set ps1 is type1:type record(field1:list of aadlinteger;);end ps1;");
	}

	private void assertFormatted(String expectation, String toBeFormatted) {
		formatterTestHelper.assertFormatted(
				formatterTestRequestProvider.get().setExpectation(expectation).setToBeFormatted(toBeFormatted));
	}

	private void assertFormattedWithoutSerializer(String expectation, String toBeFormatted) {
		formatterTestHelper.assertFormatted(formatterTestRequestProvider.get()
				.setExpectation(expectation)
				.setToBeFormatted(toBeFormatted)
				.setUseSerializer(false));
	}
}
