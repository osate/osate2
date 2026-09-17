/*******************************************************************************
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.propertiescodegen.tests;

import static org.junit.Assert.assertEquals;
import static org.osate.propertiescodegen.tests.GeneratedJavaCompiler.generateAndCompile;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.PropertySet;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

/** Verifies exact generated Java for properties code gen. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class PropertiesCodeGenTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testEnumType() throws Exception {
		var enumTest = """
				property set enum_test is
				\tenum_type_1: type enumeration (one, two, three);
				end enum_test;
				""";
		var enumTestClass = """
				package enumtest;

				public final class EnumTest {
				\tpublic static final String ENUM_TEST__NAME = "enum_test";

				\tprivate EnumTest() {}
				}
				""";
		var enumType1 = """
				package enumtest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.pluginsupport.properties.GeneratedEnumeration;

				public enum EnumType1 implements GeneratedEnumeration {
				\tONE("one", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				\tTWO("two", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				\tTHREE("three", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2");

				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate EnumType1(String originalName, String uri) {
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static EnumType1 valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(enumTest));
		assertEquals("src-gen/enumtest", results.getPackagePath());
		assertEquals(2, results.getClasses().size());

		assertEquals("EnumTest.java", results.getClasses().get(0).getFileName());
		assertEquals(enumTestClass, results.getClasses().get(0).getContents());

		assertEquals("EnumType1.java", results.getClasses().get(1).getFileName());
		assertEquals(enumType1, results.getClasses().get(1).getContents());
	}

	@Test
	public void testUnitsType() throws Exception {
		var unitsTest = """
				property set units_test is
				\tunits_type_1: type units (mm, cm => mm * 10, m => cm * 100, inch => cm * 2.54, ft => inch * 12);
				end units_test;
				""";
		var unitsTestClass = """
				package unitstest;

				public final class UnitsTest {
				\tpublic static final String UNITS_TEST__NAME = "units_test";

				\tprivate UnitsTest() {}
				}
				""";
		var unitsType1 = """
				package unitstest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum UnitsType1 implements GeneratedUnits<UnitsType1> {
				\tMM(1.0, "mm", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				\tCM(10.0, "cm", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				\tINCH(25.4, "inch", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3"),
				\tFT(304.8, "ft", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.4"),
				\tM(1000.0, "m", "__synthetic0.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate UnitsType1(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static UnitsType1 valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(UnitsType1 target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(unitsTest));
		assertEquals("src-gen/unitstest", results.getPackagePath());
		assertEquals(2, results.getClasses().size());

		assertEquals("UnitsTest.java", results.getClasses().get(0).getFileName());
		assertEquals(unitsTestClass, results.getClasses().get(0).getContents());

		assertEquals("UnitsType1.java", results.getClasses().get(1).getFileName());
		assertEquals(unitsType1, results.getClasses().get(1).getContents());
	}

	@Test
	public void testIntegerType() throws Exception {
		var ps2 = """
				property set ps2 is
				\tmass: type units (g, kg => g * 1000);
				end ps2;
				""";
		var ps1 = """
				property set ps1 is
				\twith ps2;
				\t
				\ttime: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				\t
				\tinteger_no_units: type aadlinteger;
				\tinteger_owned_units: type aadlinteger units (mm, cm => mm * 10, m => cm * 100);
				\tinteger_referenced_units_local: type aadlinteger units ps1::time;
				\tinteger_referenced_units_other_file: type aadlinteger units ps2::mass;
				end ps1;
				""";
		var ps1Class = """
				package ps1;

				public final class Ps1 {
				\tpublic static final String PS1__NAME = "ps1";

				\tprivate Ps1() {}
				}
				""";
		var time = """
				package ps1;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum Time implements GeneratedUnits<Time> {
				\tSEC(1.0, "sec", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				\tMIN(60.0, "min", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				\tHR(3600.0, "hr", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
				\tDAY(86400.0, "day", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate Time(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static Time valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(Time target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var integerOwnedUnits = """
				package ps1;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum IntegerOwnedUnits implements GeneratedUnits<IntegerOwnedUnits> {
				\tMM(1.0, "mm", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedUnitsType/@ownedLiteral.0"),
				\tCM(10.0, "cm", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedUnitsType/@ownedLiteral.1"),
				\tM(1000.0, "m", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedUnitsType/@ownedLiteral.2");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate IntegerOwnedUnits(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static IntegerOwnedUnits valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(IntegerOwnedUnits target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(ps1, ps2));
		assertEquals("src-gen/ps1", results.getPackagePath());
		assertEquals(3, results.getClasses().size());

		assertEquals("Ps1.java", results.getClasses().get(0).getFileName());
		assertEquals(ps1Class, results.getClasses().get(0).getContents());

		assertEquals("Time.java", results.getClasses().get(1).getFileName());
		assertEquals(time, results.getClasses().get(1).getContents());

		assertEquals("IntegerOwnedUnits.java", results.getClasses().get(2).getFileName());
		assertEquals(integerOwnedUnits, results.getClasses().get(2).getContents());
	}

	@Test
	public void testRealType() throws Exception {
		var ps2 = """
				property set ps2 is
				\tmass: type units (g, kg => g * 1000);
				end ps2;
				""";
		var ps1 = """
				property set ps1 is
				\twith ps2;
				\t
				\ttime: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				\t
				\treal_no_units: type aadlreal;
				\treal_owned_units: type aadlreal units (ml, cl => ml * 10, l => cl * 100);
				\treal_referenced_units_local: type aadlreal units ps1::time;
				\treal_referenced_units_other_file: type aadlreal units ps2::mass;
				end ps1;
				""";
		var ps1Class = """
				package ps1;

				public final class Ps1 {
				\tpublic static final String PS1__NAME = "ps1";

				\tprivate Ps1() {}
				}
				""";
		var time = """
				package ps1;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum Time implements GeneratedUnits<Time> {
				\tSEC(1.0, "sec", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				\tMIN(60.0, "min", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				\tHR(3600.0, "hr", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
				\tDAY(86400.0, "day", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate Time(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static Time valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(Time target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var realOwnedUnits = """
				package ps1;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum RealOwnedUnits implements GeneratedUnits<RealOwnedUnits> {
				\tML(1.0, "ml", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedUnitsType/@ownedLiteral.0"),
				\tCL(10.0, "cl", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedUnitsType/@ownedLiteral.1"),
				\tL(1000.0, "l", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedUnitsType/@ownedLiteral.2");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate RealOwnedUnits(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static RealOwnedUnits valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(RealOwnedUnits target) {
				\t\treturn factorToBase / target.factorToBase;
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(ps1, ps2));
		assertEquals("src-gen/ps1", results.getPackagePath());
		assertEquals(3, results.getClasses().size());

		assertEquals("Ps1.java", results.getClasses().get(0).getFileName());
		assertEquals(ps1Class, results.getClasses().get(0).getContents());

		assertEquals("Time.java", results.getClasses().get(1).getFileName());
		assertEquals(time, results.getClasses().get(1).getContents());

		assertEquals("RealOwnedUnits.java", results.getClasses().get(2).getFileName());
		assertEquals(realOwnedUnits, results.getClasses().get(2).getContents());
	}
}
