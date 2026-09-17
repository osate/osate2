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

/** Verifies exact generated Java for range type. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class RangeTypeTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testRangeType() throws Exception {
		var ps2 = """
				property set ps2 is
				\tmass: type units (g, kg => g * 1000);
				\t
				\tmass_type: type aadlreal units ps2::mass;
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
				\treal_no_units: type aadlreal;
				\t
				\trange_of_integer_no_units: type range of aadlinteger;
				\trange_of_integer_owned_units: type range of aadlinteger units (g, kg => g * 1000);
				\trange_of_integer_referenced_units_local: type range of aadlinteger units ps1::time;
				\trange_of_integer_referenced_units_other_file: type range of aadlinteger units ps2::mass;
				\trange_of_real_no_units: type range of aadlreal;
				\trange_of_real_owned_units: type range of aadlreal units (mN, cN => mN * 10, N => cN * 100);
				\trange_of_real_referenced_units_local: type range of aadlreal units ps1::time;
				\trange_of_real_referenced_units_other_file: type range of aadlreal units ps2::mass;
				\trange_of_referenced_integer_no_units: type range of ps1::integer_no_units;
				\trange_of_referenced_real_no_units: type range of ps1::real_no_units;
				\trange_of_referenced_number_local: type range of ps1::integer_owned_units;
				\trange_of_referenced_number_other_file: type range of ps2::mass_type;
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
		var rangeOfIntegerOwnedUnits = """
				package ps1;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum RangeOfIntegerOwnedUnits implements GeneratedUnits<RangeOfIntegerOwnedUnits> {
				\tG(1.0, "g", "__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\tKG(1000.0, "kg", "__synthetic1.aadl#/0/@ownedPropertyType.5/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate RangeOfIntegerOwnedUnits(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static RangeOfIntegerOwnedUnits valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(RangeOfIntegerOwnedUnits target) {
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
		var rangeOfRealOwnedUnits = """
				package ps1;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum RangeOfRealOwnedUnits implements GeneratedUnits<RangeOfRealOwnedUnits> {
				\tMN(1.0, "mN", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedNumberType/@ownedUnitsType/@ownedLiteral.0"),
				\tCN(10.0, "cN", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedNumberType/@ownedUnitsType/@ownedLiteral.1"),
				\tN(1000.0, "N", "__synthetic1.aadl#/0/@ownedPropertyType.9/@ownedNumberType/@ownedUnitsType/@ownedLiteral.2");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate RangeOfRealOwnedUnits(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static RangeOfRealOwnedUnits valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(RangeOfRealOwnedUnits target) {
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
		assertEquals(5, results.getClasses().size());

		assertEquals("Ps1.java", results.getClasses().get(0).getFileName());
		assertEquals(ps1Class, results.getClasses().get(0).getContents());

		assertEquals("Time.java", results.getClasses().get(1).getFileName());
		assertEquals(time, results.getClasses().get(1).getContents());

		assertEquals("IntegerOwnedUnits.java", results.getClasses().get(2).getFileName());
		assertEquals(integerOwnedUnits, results.getClasses().get(2).getContents());

		assertEquals("RangeOfIntegerOwnedUnits.java", results.getClasses().get(3).getFileName());
		assertEquals(rangeOfIntegerOwnedUnits, results.getClasses().get(3).getContents());

		assertEquals("RangeOfRealOwnedUnits.java", results.getClasses().get(4).getFileName());
		assertEquals(rangeOfRealOwnedUnits, results.getClasses().get(4).getContents());
	}
}
