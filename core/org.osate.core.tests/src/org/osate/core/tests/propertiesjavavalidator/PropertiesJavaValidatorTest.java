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
package org.osate.core.tests.propertiesjavavalidator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.ThreadType;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class PropertiesJavaValidatorTest extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	// Tests checkUnits
	@Test
	public void testMismatchedPropertyTypeMissingUnits() throws Exception {
		var ps = """
				property set ps is
					c: constant aadlinteger => 5;
				end ps;
				""";
		var missingUnitsTest = """
				package missingUnitsTest
				public
					with ps;
					thread t
						properties
							Period => ps::c;
					end t;
				end missingUnitsTest;
				""";
		var pkg = parse(missingUnitsTest, ps);
		assertEquals("missingUnitsTest", pkg.getName());
		var thread = (ThreadType) pkg.getPublicSection().getOwnedClassifiers().get(0);
		assertEquals("t", thread.getName());
		var association = thread.getOwnedPropertyAssociations().get(0);
		assertEquals("Period", association.getProperty().getName());
		// Tests checkUnits
		assertError(association.getOwnedValues().get(0).getOwnedValue(),
				"Property value is not of expected type AADL_Project::Time");
		assertAllIssuesReported();
	}

	// Tests checkDuplicateFieldAssignment
	@Test
	public void testCheckDuplicateFieldAssignment() throws Exception {
		var ps1 = """
				property set ps1 is
					def5 : record (
						f1 : aadlboolean;
						f2 : aadlinteger;
					) applies to (all);
				end ps1;
				""";
		var dupeFieldTest = """
				package dupeFieldTest
				public
					with ps1;
					abstract a
						properties
							ps1::def5 => [
								f1 => true;
								f1 => false;
							];
					end a;
				end dupeFieldTest;
				""";
		var pkg = parse(dupeFieldTest, ps1);
		assertEquals("dupeFieldTest", pkg.getName());
		var abstractType = (AbstractType) pkg.getPublicSection().getOwnedClassifiers().get(0);
		assertEquals("a", abstractType.getName());
		var association = abstractType.getOwnedPropertyAssociations().get(0);
		assertEquals("def5", association.getProperty().getName());
		var record = (RecordValue) association.getOwnedValues().get(0).getOwnedValue();
		assertError(record.getOwnedFieldValues().get(0), "Duplicate assignment of record value");
		assertError(record.getOwnedFieldValues().get(1), "Duplicate assignment of record value");
		assertAllIssuesReported();
	}

	// Tests for checking property set element reference require 'with' clause including when used in array size
	@Test
	public void testCheckPropertySetElementReference() throws Exception {
		var testPropRef = """
				package testpropref
				public
					-- A with statement should be required
					abstract a
						features
							feat_array: feature [SEI::nsloc]; -- Incorrect behavior. No error without the "with SEI;" statement
						properties
							SEI::nsloc => 5;  -- Correct behavior. Produces error unless there is a "with SEI;" statement
					end a;
				end testpropref;
				""";
		var pkg = parse(testPropRef);
		assertEquals("testpropref", pkg.getName());
		var abstractType = (AbstractType) pkg.getPublicSection().getOwnedClassifiers().getFirst();
		assertEquals("a", abstractType.getName());
		var feature = abstractType.getOwnedFeatures().getFirst();
		assertEquals("feat_array", feature.getName());
		// checkPropertySetElementReference
		assertError(feature.getArrayDimensions().getFirst().getSize(),
				"Couldn't resolve reference to ArraySizeProperty 'SEI::nsloc'.");
		/*
		 * These are not reported for the array size yet:
		 * "The referenced property set 'SEI' of property 'nsloc' is not listed in a with clause."
		 * "Array size should only be integer or property constant value, not a property value"
		 */
		var association = abstractType.getOwnedPropertyAssociations().getFirst();
		assertEquals("nsloc", association.getProperty().getName());
		// checkPropertySetElementReference
		assertError(association,
				"The referenced property set 'SEI' of property 'nsloc' is not listed in a with clause.");
		assertAllIssuesReported();
	}

	// checkInheritedMissingModes
	// Tests for checking for when inheriting a modal property value, but the value is undefined for local modes
	@Test
	public void testCheckInheritedMissingModes() throws Exception {
		var psimpv = """
				property set psimpv is
					p1: aadlinteger => 11 applies to (all);
					p2: aadlinteger => 12 applies to (all);
					p3: aadlinteger => 13 applies to (all);
					p4: aadlinteger => 14 applies to (all);
				end psimpv;
				""";
		var pkginheritedmpv = """
				package pkginheritedmpv
					public
						with psimpv;
						abstract a1
							modes
								m1: initial mode;
								m2: mode;
							properties
								psimpv::p1 => 1;
								psimpv::p2 => 1 in modes (m1), 2;
								psimpv::p3 => 1 in modes (m1), 2 in modes (m2), 3;
								psimpv::p4 => 1 in modes (m1), 2 in modes (m2);
						end a1;
						-- Warning "Value not set for mode m3 for property psimpv::p4"
						-- checkInheritedMissingModes
						abstract a2 extends  a1
							modes
								m3: mode;
						end a2;
				end pkginheritedmpv;
				""";
		var pkg = parse(pkginheritedmpv, psimpv);
		assertEquals("pkginheritedmpv", pkg.getName());
		var a2 = (AbstractType) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("a2", a2.getName());
		assertWarning(a2.getOwnedExtension(), "Value not set for mode m3 for property psimpv::p4");
		assertAllIssuesReported();
	}

	// checkContainedProperties
	// Tests for checking that modes have values when using appliesto
	@Test
	public void testCheckContainedProperties() throws Exception {
		var pscp = """
				property set pscp is
					def3: aadlstring => 'z' applies to (all);
				end pscp;
				""";
		var containedpropertiestest = """
				package containedpropertiestest
				public
					with pscp;
					abstract a1
						features
							fg1: feature group fgt1;
						modes
							m1: initial mode;
							m2: mode;
					end a1;
					abstract implementation a1.i
					subcomponents
						sub1: system s1.i;
					properties
						-- W: "Value not set for mode m2 for property pscp::def3"
						pscp::def3 => "a" in modes (m1) applies to fg1;
						-- W: "Value not set for mode m2 for property pscp::def3"
						pscp::def3 => "b" in modes (m1) applies to fg1.fg2;
						-- W: "Value not set for mode m4 for property pscp::def3"
						pscp::def3 => "c" in modes (m3) applies to sub1;
						-- W: "Value not set for mode m6 for property pscp::def3"
						pscp::def3 => "d" in modes (m5) applies to sub1.sub2;
						-- W: "Value not set for mode m6 for property pscp::def3"
						pscp::def3 => "e" in modes (m5) applies to sub1.sub2.fg3;
						-- E: "Couldn't resolve reference to mode 'm1' in applies to 'sub1.sub3'."
						pscp::def3 => "f" in modes (m1) applies to sub1.sub3;
					end a1.i;
					feature group fgt1
						features
							fg2: feature group;
					end fgt1;
					system s1
					end s1;
					system implementation s1.i
						subcomponents
							sub2: system s2.i;
							sub3: system;
						modes
							m3: initial mode;
							m4: mode;
					end s1.i;
					system s2
						features
							fg3: feature group;
						modes
							m5: initial mode;
							m6: mode;
					end s2;
					system implementation s2.i
					end s2.i;
				end containedpropertiestest;
				""";
		var pkg = parse(containedpropertiestest, pscp);
		assertEquals("containedpropertiestest", pkg.getName());
		var implementation = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("a1.i", implementation.getName());
		var associations = implementation.getOwnedPropertyAssociations();
		assertWarning(associations.getFirst(), "Value not set for mode m2 for property pscp::def3");
		assertWarning(associations.get(1), "Value not set for mode m2 for property pscp::def3");
		assertWarning(associations.get(2), "Value not set for mode m4 for property pscp::def3");
		assertWarning(associations.get(3), "Value not set for mode m6 for property pscp::def3");
		assertWarning(associations.get(4), "Value not set for mode m6 for property pscp::def3");
		assertError(associations.get(5).getOwnedValues().getFirst(),
				"Couldn't resolve reference to mode 'm1' in applies to 'sub1.sub3'.");
		assertAllIssuesReported();
	}

	// checkModalAppliesTo
	// Tests for checking that if property has in modes it can only have one appliesto value
	@Test
	public void testCheckModalAppliesTo() throws Exception {
		var psatm = """
				property set psatm is
					def1: aadlstring => 'z' applies to (all);
				end psatm;
				""";
		var modalappliesto = """
				package modalappliesto
					public
						with psatm;
						abstract a1
							features
								fg1: feature;
								fg2: feature;
							modes
								m1: initial mode;
								m2: mode;
							properties
								psatm::def1 => "a" in modes (m1,m2) applies to fg1,fg2;
						end a1;
				end modalappliesto;
				""";
		var pkg = parse(modalappliesto, psatm);
		assertEquals("modalappliesto", pkg.getName());
		var a1 = (AbstractType) pkg.getPublicSection().getOwnedClassifiers().getFirst();
		assertEquals("a1", a1.getName());
		assertError(a1.getOwnedPropertyAssociations().getFirst(),
				"If property value is assigned to a mode there can only be one element in the applies to statement.");
		assertAllIssuesReported();
	}

	// checkPropertyMissingModes
	// Tests for checking that property has values for all modes
	@Test
	public void testCheckPropertyMissingModes() throws Exception {
		var pspamm = """
				property set pspamm is
					p1: aadlinteger => 11 applies to (all);
					p2: aadlinteger => 12 applies to (all);
					p3: aadlinteger => 13 applies to (all);
					p4: aadlinteger => 14 applies to (all);
					p5: aadlinteger => 15 applies to (all);
				end pspamm;
				""";
		var pamissingmode = """
				package pamissingmode
				public
					with pspamm;
					abstract a1
						modes
							m1: initial mode;
							m2: mode;
						properties
							pspamm::p5 => 1 in modes (m1) ;
							pspamm::p1 => 1;
							pspamm::p2 => 1 in modes (m1), 2;
							pspamm::p3 => 1 in modes (m1), 2 in modes (m2), 3;
							pspamm::p4 => 1 in modes (m1), 2 in modes (m2);
					end a1;
				end pamissingmode;
				""";
		var pkg = parse(pamissingmode, pspamm);
		assertEquals("pamissingmode", pkg.getName());
		var a1 = (AbstractType) pkg.getPublicSection().getOwnedClassifiers().getFirst();
		assertEquals("a1", a1.getName());
		assertWarning(a1.getOwnedPropertyAssociations().getFirst(), "Missing value assigned for Mode m2");
		assertAllIssuesReported();
	}

	// checkSubcomponentMissingModeValues
	// Tests for checking that subcomponent inline property association has values for all modes
	@Test
	public void testCheckSubcomponentMissingModeValues() throws Exception {
		var psscmpv = """
				property set psscmpv is
					p1: aadlinteger => 11 applies to (all);
				end psscmpv;
				""";
		var subcompmmv = """
				package subcompmmv
				public
					with psscmpv;
					system implementation s.i
						subcomponents
							sub1: system s2.i {psscmpv::p1 => 1 in modes(m1);};
					end s.i;
					system s
					end s;
					system s2
					end s2;
					system implementation s2.i
						modes
							m1: initial mode;
							m2: mode;
					end s2.i;
				end subcompmmv;
				""";
		var pkg = parse(subcompmmv, psscmpv);
		assertEquals("subcompmmv", pkg.getName());
		var implementation = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().getFirst();
		assertEquals("s.i", implementation.getName());
		var subcomponent = implementation.getOwnedSystemSubcomponents().getFirst();
		assertEquals("sub1", subcomponent.getName());
		assertWarning(subcomponent.getOwnedPropertyAssociations().getFirst(),
				"Value not set for mode m2 for property psscmpv::p1");
		assertAllIssuesReported();
	}

	// checkCaseRangeValueUpperNotLessThanLower
	// Test for checking that the upper bound of a RangeValue is not less than its lower bound
	@Test
	public void testRangeValueUpperBoundNotLessThanLower() throws Exception {
		var psrange = """
				property set psrange is
					range1 : range of aadlinteger applies to (all);
					range2 : range of aadlinteger applies to (all);
					range3 : range of aadlinteger applies to (all);
				end psrange;
				""";
		var rangevalueupperlower = """
				package rangevalueupperlower
				public
					with psrange;
					abstract ab1
						properties
							deactivate_execution_time => 1sec .. 10ms delta 1ps;
							psrange::range1 => 10 .. 1;
							compute_execution_time => 10ms .. 1sec delta 1ps;
							psrange::range2 => 10 .. 10;
							psrange::range3 => 1 .. 10;
					end ab1;
				end rangevalueupperlower;
				""";
		var pkg = parse(rangevalueupperlower, psrange);
		assertEquals("rangevalueupperlower", pkg.getName());
		var ab1 = (AbstractType) pkg.getPublicSection().getOwnedClassifiers().getFirst();
		assertEquals("ab1", ab1.getName());
		assertError(ab1.getOwnedPropertyAssociations().getFirst().getOwnedValues().getFirst().getOwnedValue(),
				"Upper bound of range is less than the lower bound.");
		assertError(ab1.getOwnedPropertyAssociations().get(1).getOwnedValues().getFirst().getOwnedValue(),
				"Upper bound of range is less than the lower bound.");
		assertAllIssuesReported();
	}

	// checkCaseRangeValueDeltaNotNegative
	// Test for checking that the delta a RangeValue is not negative
	@Test
	public void testRangeValueForNegativeDelta() throws Exception {
		var rangevaluedelta = """
				package rangevaluedelta
				public
					abstract ab1
						properties
							activate_execution_time => 1ms..10ms delta -2ps;
					end ab1;
				end rangevaluedelta;
				""";
		var pkg = parse(rangevaluedelta);
		assertEquals("rangevaluedelta", pkg.getName());
		var ab1 = (AbstractType) pkg.getPublicSection().getOwnedClassifiers().getFirst();
		assertEquals("ab1", ab1.getName());
		var range = (RangeValue) ab1.getOwnedPropertyAssociations()
				.getFirst()
				.getOwnedValues()
				.getFirst()
				.getOwnedValue();
		assertError(range.getDelta(), "Range value has a negative delta component");
		assertAllIssuesReported();
	}

	// Tests validation of appends operator in contained propertyassociation
	@Test
	public void testCheckForAppendsInContainedPropertyAssociation() throws Exception {
		var appendsoperaterincontainedprop = """
				package appendsoperaterincontainedprop
					public
						system S
						end S;
						system implementation S.i
							subcomponents
								p: abstract A;
								q: abstract B;
								h: system H.i;
							connections
								c: feature p.dpa -> q.dpb;
							properties
								actual_connection_binding => (
									reference(h.p), reference(h.b)
								);
								 -- the following should be an error because it's a contained PA
								actual_connection_binding +=> (
									reference(h.r)
								) applies to c;
						end S.i;
						abstract A
							features
								dpa: feature;
						end A;
						abstract B
							features
								dpb: feature;
						end B;
						system H
						end H;
						system implementation H.i
							subcomponents
								p: processor;
								b: bus;
								r: device;
						end H.i;
				end appendsoperaterincontainedprop;
				""";
		var pkg = parse(appendsoperaterincontainedprop);
		assertEquals("appendsoperaterincontainedprop", pkg.getName());
		var implementation = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("S.i", implementation.getName());
		var association = implementation.getOwnedPropertyAssociations().get(1);
		assertEquals("actual_connection_binding", association.getProperty().getName().toLowerCase());
		assertError(association, "Append operator '+=>' cannot be used in contained property associations");
		assertAllIssuesReported();
	}

	// Tests validation of property association applies to array indices
	@Test
	public void testCheckPropertyAssociationAppliesToArrayIndex() throws Exception {
		var propertyAssocAppliestoArrayIndices = """
				package propertyAssocAppliestoArrayIndices
				public
					system implementation S.i
						subcomponents
							nodes1: process proc1.imp1[4];
							nodes2: process[2];
							nodes3: process;
							nodes4: process[];
							nodes5: process[Max_Urgency];
						properties
							-- array has more dimensions than defined
							deadline => 9 ms applies to nodes3[1];
							-- lowerbound > upperbound
							deadline => 8 ms applies to nodes2[2 .. 1];
							-- array out of bounds (array is 1 based not 0)
							deadline => 6 ms applies to nodes2[0];
							-- array out of bounds
							deadline => 7 ms applies to nodes1[6].t1[2] ;
							deadline => 7 ms applies to nodes1[3].t1[4] ;
							deadline => 7 ms applies to nodes1[6].t1[4] ;
							deadline => 7 ms applies to nodes5[15];
							deadline => 7 ms applies to nodes1[2].t1[1], nodes1[5].t1[2] ;
							-- array out of bounds (upperbound)
							deadline => 6 ms applies to nodes2[1 .. 8];
					end S.i;
					system S
					end S;
					   process proc1
					   end proc1;
					   process implementation proc1.imp1
						subcomponents
							t1: thread[3];
					   end proc1.imp1;
				end propertyAssocAppliestoArrayIndices;
				""";
		var pkg = parse(propertyAssocAppliestoArrayIndices);
		assertEquals("propertyAssocAppliestoArrayIndices", pkg.getName());
		var implementation = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().getFirst();
		assertEquals("S.i", implementation.getName());
		var associations = implementation.getOwnedPropertyAssociations();
		assertEquals("deadline", associations.getFirst().getProperty().getName().toLowerCase());
		assertArrayRangeError(associations.getFirst(), 0, 0, "'nodes3' is not an array");
		assertArrayRangeError(associations.get(1), 0, 0, "Range lower bound is greater than upper bound");
		assertArrayRangeError(associations.get(2), 0, 0, "Array indices start at 1");
		assertArrayRangeError(associations.get(3), 0, 0, "Index is greater than array size 4");
		assertArrayRangeError(associations.get(4), 0, 1, "Index is greater than array size 3");
		assertArrayRangeError(associations.get(5), 0, 0, "Index is greater than array size 4");
		assertArrayRangeError(associations.get(5), 0, 1, "Index is greater than array size 3");
		assertArrayRangeError(associations.get(6), 0, 0, "Index is greater than array size 12");
		assertArrayRangeError(associations.get(7), 1, 0, "Index is greater than array size 4");
		assertArrayRangeError(associations.get(8), 0, 0, "Upper bound is greater than array size 2");
		assertAllIssuesReported();
	}

	private AadlPackage parse(String source, String... referenced) throws Exception {
		testFileResult = issues = testHelper.testString(source, referenced);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(), new ArrayList<>());
		return (AadlPackage) testFileResult.getResource().getContents().getFirst();
	}

	private void assertAllIssuesReported() {
		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void assertArrayRangeError(PropertyAssociation association, int appliesToIndex,
			int pathElementIndex, String message) {
		var pathElement = association.getAppliesTos()
				.get(appliesToIndex)
				.getContainmentPathElements()
				.get(pathElementIndex);
		assertError(pathElement.getArrayRanges().getFirst(), message);
	}

	private void assertError(EObject object, String... messages) {
		AssertHelper.assertError(object, testFileResult.getIssues(), issueCollection, messages);
	}

	private void assertWarning(EObject object, String... messages) {
		AssertHelper.assertWarning(object, testFileResult.getIssues(), issueCollection, messages);
	}
}
