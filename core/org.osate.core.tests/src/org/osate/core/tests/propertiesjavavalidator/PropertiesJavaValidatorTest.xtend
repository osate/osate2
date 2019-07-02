/*
 *
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 * 
 * NO WARRANTY
 * 
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 * 
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 * 
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.core.tests.propertiesjavavalidator

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.AbstractType
import org.osate.aadl2.RangeValue
import org.osate.aadl2.RecordValue
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.ThreadType
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class PropertiesJavaValidatorTest extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper

	// Tests typeCheckEndToEndFlowSegments
	@Test
	def void testMismatchedPropertyTypeMissingUnits() {
		val ps = '''
			property set ps is
				c: constant aadlinteger => 5; 
			end ps; 
		'''
		val missingUnitsTest = '''
			package missingUnitsTest
			public 
				with ps;
				thread t
					properties
						Period => ps::c;
				end t;
			end missingUnitsTest;
		'''
		val testFileResult = issues = testHelper.testString(missingUnitsTest, ps)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"missingUnitsTest".assertEquals(name)
			publicSection.ownedClassifiers.get(0) as ThreadType => [
				"t".assertEquals(name)
				ownedPropertyAssociations.get(0) => [
					it.property.name
					"Period".assertEquals(property.name)
					ownedValues.get(0).ownedValue => [
						// Tests checkUnits
						assertError(testFileResult.issues, issueCollection, "Number value is missing a unit")
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	// Tests checkDuplicateFieldAssignment
	@Test
	def void testCheckDuplicateFieldAssignment() {
		var ps1 = '''
			property set ps1 is
				def5 : record (
					f1 : aadlboolean;
					f2 : aadlinteger;
				) applies to (all);
			end ps1;
		'''
		val dupeFieldTest = '''
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
		'''
		val testFileResult = issues = testHelper.testString(dupeFieldTest, ps1)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"dupeFieldTest".assertEquals(name)
			publicSection.ownedClassifiers.get(0) as AbstractType => [
				"a".assertEquals(name)
				ownedPropertyAssociations.get(0) => [
					property.name
					"def5".assertEquals(property.name)
					ownedValues.get(0).getOwnedValue() as RecordValue => [
						getOwnedFieldValues().get(0) => [
							assertError(testFileResult.issues, issueCollection, "Duplicate assignment of record value")
						]
						getOwnedFieldValues().get(1) => [
							assertError(testFileResult.issues, issueCollection, "Duplicate assignment of record value")
						]
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	// Tests for checking property set element reference require 'with' clause including when used in array size
	@Test
	def void testCheckPropertySetElementReference() {
		val testPropRef = '''
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
		'''
		val testFileResult = issues = testHelper.testString(testPropRef)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"testpropref".assertEquals(name)
			publicSection.ownedClassifiers.head as AbstractType => [
				"a".assertEquals(name)
				ownedFeatures.head => [
					"feat_array".assertEquals(name)
					// checkPropertySetElementReference
					arrayDimensions.head.size.assertError(
						testFileResult.issues,
						issueCollection,
						"Couldn't resolve reference to ArraySizeProperty 'SEI::nsloc'."
					// "The referenced property set 'SEI' of property 'nsloc' is not listed in a with clause."
					// , "Array size should only be integer or property constant value, not a property value"
					)
				]
				ownedPropertyAssociations.head => [
					property => ["nsloc".assertEquals(name)]
					// checkPropertySetElementReference
					assertError(testFileResult.issues, issueCollection,
						"The referenced property set 'SEI' of property 'nsloc' is not listed in a with clause.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	// checkInheritedMissingModes
	// Tests for checking for when inheriting a modal property value, but the value is undefined for local modes
	@Test
	def void testCheckInheritedMissingModes() {
		val psimpv = '''
			property set psimpv is
				p1: aadlinteger => 11 applies to (all); 
				p2: aadlinteger => 12 applies to (all); 
				p3: aadlinteger => 13 applies to (all); 
				p4: aadlinteger => 14 applies to (all); 
			end psimpv;
		'''
		val pkginheritedmpv = '''
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
		'''
		val testFileResult = issues = testHelper.testString(pkginheritedmpv, psimpv)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkginheritedmpv".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractType => [
				"a2".assertEquals(name)
				ownedExtension.assertWarning(testFileResult.issues, issueCollection,
					"Value not set for mode m3 for property psimpv::p4")
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	// checkContainedProperties
	// Tests for checking that modes have values when using appliesto
	@Test
	def void testCheckContainedProperties() {
		val pscp = '''
			property set pscp is
				def3: aadlstring => 'z' applies to (all);
			end pscp;
		'''
		val containedpropertiestest = '''
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
		'''
		val testFileResult = issues = testHelper.testString(containedpropertiestest, pscp)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"containedpropertiestest".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				ownedPropertyAssociations.head => [
					assertWarning(testFileResult.issues, issueCollection,
						"Value not set for mode m2 for property pscp::def3")
				]
				ownedPropertyAssociations.get(1) => [
					assertWarning(testFileResult.issues, issueCollection,
						"Value not set for mode m2 for property pscp::def3")
				]
				ownedPropertyAssociations.get(2) => [
					assertWarning(testFileResult.issues, issueCollection,
						"Value not set for mode m4 for property pscp::def3")
				]
				ownedPropertyAssociations.get(3) => [
					assertWarning(testFileResult.issues, issueCollection,
						"Value not set for mode m6 for property pscp::def3")
				]
				ownedPropertyAssociations.get(4) => [
					assertWarning(testFileResult.issues, issueCollection,
						"Value not set for mode m6 for property pscp::def3")
				]
				ownedPropertyAssociations.get(5) => [
					ownedValues.head.assertError(testFileResult.issues, issueCollection,
						"Couldn't resolve reference to mode 'm1' in applies to 'sub1.sub3'.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	// checkModalAppliesTo
	// Tests for checking that if property has in modes it can only have one appliesto value
	@Test
	def void testCheckModalAppliesTo() {
		val psatm = '''
			property set psatm is
				def1: aadlstring => 'z' applies to (all);
			end psatm;
		'''
		val modalappliesto = '''
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
		'''
		val testFileResult = issues = testHelper.testString(modalappliesto, psatm)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"modalappliesto".assertEquals(name)
			publicSection.ownedClassifiers.head as AbstractType => [
				"a1".assertEquals(name)
				ownedPropertyAssociations.head => [
					assertError(testFileResult.issues, issueCollection,
						"If property value is assigned to a mode there can only be one element in the applies to statement.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	// checkPropertyMissingModes
	// Tests for checking that property has values for all modes
	@Test
	def void testCheckPropertyMissingModes() {
		val pspamm = '''
			property set pspamm is
				p1: aadlinteger => 11 applies to (all); 
				p2: aadlinteger => 12 applies to (all); 
				p3: aadlinteger => 13 applies to (all); 
				p4: aadlinteger => 14 applies to (all); 
				p5: aadlinteger => 15 applies to (all);
			end pspamm;
		'''
		val pamissingmode = '''
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
		'''
		val testFileResult = issues = testHelper.testString(pamissingmode, pspamm)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pamissingmode".assertEquals(name)
			publicSection.ownedClassifiers.head as AbstractType => [
				"a1".assertEquals(name)
				ownedPropertyAssociations.head => [
					assertWarning(testFileResult.issues, issueCollection, "Missing value assigned for Mode m2")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	// checkSubcomponentMissingModeValues
	// Tests for checking that subcomponent inline property association has values for all modes
	@Test
	def void testCheckSubcomponentMissingModeValues() {
		val psscmpv = '''
			property set psscmpv is
				p1: aadlinteger => 11 applies to (all); 
			end psscmpv;
		'''
		val subcompmmv = '''
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
		'''
		val testFileResult = issues = testHelper.testString(subcompmmv, psscmpv)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"subcompmmv".assertEquals(name)
			publicSection.ownedClassifiers.head as SystemImplementation => [
				"s.i".assertEquals(name)
				ownedSystemSubcomponents.head => [
					"sub1".assertEquals(name)
					ownedPropertyAssociations.head.assertWarning(testFileResult.issues, issueCollection,
						"Value not set for mode m2 for property psscmpv::p1")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	// checkCaseRangeValueUpperNotLessThanLower
	// Test for checking that the upper bound of a RangeValue is not less than its lower bound
	@Test
	def void testRangeValueUpperBoundNotLessThanLower() {
		val psrange = '''
			property set psrange is
				range1 : range of aadlinteger applies to (all);
				range2 : range of aadlinteger applies to (all);
				range3 : range of aadlinteger applies to (all);
			end psrange;
		'''
		val rangevalueupperlower = '''
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
		'''
		val testFileResult = issues = testHelper.testString(rangevalueupperlower, psrange)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"rangevalueupperlower".assertEquals(name)
			publicSection.ownedClassifiers.head as AbstractType => [
				"ab1".assertEquals(name)
				ownedPropertyAssociations.head => [
					ownedValues.head => [
						ownedValue.assertError(testFileResult.issues, issueCollection,
							"Upper bound of range is less than the lower bound.")
					]
				]
				ownedPropertyAssociations.get(1) => [
					ownedValues.head => [
						ownedValue.assertError(testFileResult.issues, issueCollection,
							"Upper bound of range is less than the lower bound.")
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	// checkCaseRangeValueDeltaNotNegative
	// Test for checking that the delta a RangeValue is not negative
	@Test
	def void testRangeValueForNegativeDelta() {
		val rangevaluedelta = '''
			package rangevaluedelta
			public
				abstract ab1
					properties
						activate_execution_time => 1ms..10ms delta -2ps;
				end ab1;
			end rangevaluedelta;
		'''
		val testFileResult = issues = testHelper.testString(rangevaluedelta)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"rangevaluedelta".assertEquals(name)
			publicSection.ownedClassifiers.head as AbstractType => [
				"ab1".assertEquals(name)
				ownedPropertyAssociations.head => [
					ownedValues.head => [
						ownedValue as RangeValue => [
							delta.assertError(testFileResult.issues, issueCollection,
								"Range value has a negative delta component")
						]
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	// Tests validation of appends operator in contained propertyassociation
	@Test
	def void testCheckForAppendsInContainedPropertyAssociation() {
		val appendsoperaterincontainedprop = '''
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
		'''
		val testFileResult = issues = testHelper.testString(appendsoperaterincontainedprop)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"appendsoperaterincontainedprop".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"S.i".assertEquals(name)
				ownedPropertyAssociations.get(1) => [
					"actual_connection_binding".assertEquals(property.name.toLowerCase)
					assertError(testFileResult.issues, issueCollection,
						"Append operator '+=>' cannot be used in contained property associations")
				]
			]

		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	// Tests validation of property association applies to  array indices
	@Test
	def void testCheckPropertyAssociationAppliesToArrayIndex() {
		val propertyAssocAppliestoArrayIndices = '''
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
						-- the following is fine because its not defined yet
						deadline => 7 ms applies to nodes4[2];
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
		'''
		val testFileResult = issues = testHelper.testString(propertyAssocAppliestoArrayIndices)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"propertyAssocAppliestoArrayIndices".assertEquals(name)
			publicSection.ownedClassifiers.head as SystemImplementation => [
				"S.i".assertEquals(name)
				ownedPropertyAssociations.head => [
					"deadline".assertEquals(property.name.toLowerCase)
					appliesTos.head => [
						containmentPathElements.head.arrayRanges.head => [
							assertError(testFileResult.issues, issueCollection,
								"'nodes3' is not an array")
						]
					]
				]
				ownedPropertyAssociations.get(1) => [
					appliesTos.head => [
						containmentPathElements.head => [
							arrayRanges.head => [
								assertError(testFileResult.issues, issueCollection,
									"Range lower bound is greater than upper bound")
							]
						]
					]
				]
				ownedPropertyAssociations.get(2) => [
					appliesTos.head => [
						containmentPathElements.head => [
							arrayRanges.head => [
								assertError(testFileResult.issues, issueCollection,
									"Array indices start at 1")
							]
						]
					]
				]
				ownedPropertyAssociations.get(3) => [
					appliesTos.head => [
						containmentPathElements.head => [
							arrayRanges.head => [
								assertError(testFileResult.issues, issueCollection,
									"Index is greater than array size 4")
							]
						]
					]
				]
				ownedPropertyAssociations.get(4) => [
					appliesTos.head => [
						containmentPathElements.get(1) => [
							arrayRanges.head => [
								assertError(testFileResult.issues, issueCollection,
									"Index is greater than array size 3")
							]
						]
					]
				]
				ownedPropertyAssociations.get(5) => [
					appliesTos.head => [
						containmentPathElements.head => [
							arrayRanges.head => [
								assertError(testFileResult.issues, issueCollection,
									"Index is greater than array size 4")
							]
						]
						containmentPathElements.get(1) => [
							arrayRanges.head => [
								assertError(testFileResult.issues, issueCollection,
									"Index is greater than array size 3")
							]
						]
					]
				]
				ownedPropertyAssociations.get(6) => [
					appliesTos.head => [
						containmentPathElements.head => [
							arrayRanges.head => [
								assertError(testFileResult.issues, issueCollection,
									"Index is greater than array size 12")
							]
						]
					]
				]
				ownedPropertyAssociations.get(7) => [
					appliesTos.get(1) => [
						containmentPathElements.head => [
							arrayRanges.head => [
								assertError(testFileResult.issues, issueCollection,
									"Index is greater than array size 4")
							]
						]
					]
				]
				ownedPropertyAssociations.get(8) => [
					appliesTos.head => [
						containmentPathElements.head => [
							arrayRanges.head => [
								assertError(testFileResult.issues, issueCollection,
									"Upper bound is greater than array size 2")
							]
						]
					]
				]

			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

}
