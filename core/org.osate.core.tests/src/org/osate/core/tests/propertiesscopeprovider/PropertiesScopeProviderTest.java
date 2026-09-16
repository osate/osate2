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
package org.osate.core.tests.propertiesscopeprovider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.ReferenceValue;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class PropertiesScopeProviderTest extends XtextTest {
	private static final String PS = """
			property set ps is
				ref1: reference (named element) applies to (all);
				ref2: reference (named element) applies to (all);
				ref3: reference (named element) applies to (all);
				ref4: reference (named element) applies to (all);
				ref5: reference (named element) applies to (all);
				ref6: reference (named element) applies to (all);
				ref7: reference (named element) applies to (all);
				ref8: reference (named element) applies to (all);
				ref9: reference (named element) applies to (all);
				ref10: reference (named element) applies to (all);
				ref11: reference (named element) applies to (all);
				ref12: reference (named element) applies to (all);
				ref13: reference (named element) applies to (all);
				ref14: reference (named element) applies to (all);
				ref15: reference (named element) applies to (all);
			end ps;
			""";

	private static final String DOT_OPERATOR_SCOPE_TEST_1 = """
			package DotOperatorScopeTest1
			public
				with ps;

				abstract a1
				prototypes
					aproto1: abstract;
					fgproto1: feature group;
				features
					ep1: in event port;
					dp1: in data port a3.i1;
					af1: feature;
					fg1: feature group fgt2;
					fg2: feature group fgproto1;
				flows
					fpath1: flow path af1 -> af1;
				end a1;

				abstract implementation a1.i1
				subcomponents
					asub1: abstract a3.i1;
					asub2: abstract aproto1;
					asub3: abstract a3.i1 (aproto4 => abstract a4, fgproto4 => feature group fgt2);
				internal features
					es1: event;
				processor features
					pp1: port;
				calls
					sequence1: {
						call1: subprogram subp1;
					} in modes (m1);
				connections
					fconn1: feature asub1.af3 -> asub1.af3;
				flows
					etef1: end to end flow asub1.fpath2 -> fconn1 -> asub1.fpath2;
				modes
					m1: initial mode;
					m2: mode;
					mt1: m1 -[ep1]-> m2;
				annex as1 {**
				**};
				end a1.i1;

				abstract a2 extends a1 (fgproto1 => feature group fgt2)
				prototypes
					aproto1: refined to abstract;
				features
					fg1: refined to feature group fgt2 {
						ps::ref1 => reference(af4) applies to af4;
						ps::ref2 => reference(fg7.af6) applies to fg7.af6;
						ps::ref3 => reference(fg8.af6) applies to fg8.af6;
						ps::ref4 => reference(fg9.af6) applies to fg9.af6;
					};
					fg2: refined to feature group {
						ps::ref1 => reference(af4) applies to af4;
						ps::ref2 => reference(fg7.af6) applies to fg7.af6;
						ps::ref3 => reference(fg8.af6) applies to fg8.af6;
						ps::ref4 => reference(fg9.af6) applies to fg9.af6;
					};
					dp1: refined to in data port a3.i1;
				flows
					fpath1: refined to flow path;
				end a2;

				abstract implementation a2.i1 extends a1.i1 (aproto1 => abstract a3.i1)
				subcomponents
					asub1: refined to abstract a3.i1 {
						ps::ref1 => reference(af3) applies to af3;
						ps::ref2 => reference(asub4.af5) applies to asub4.af5;
						ps::ref3 => reference(asub5.af5) applies to asub5.af5;
						ps::ref4 => reference(asub6.af5) applies to asub6.af5;
					};
					asub2: refined to abstract {
						ps::ref1 => reference(af3) applies to af3;
						ps::ref2 => reference(asub4.af5) applies to asub4.af5;
						ps::ref3 => reference(asub5.af5) applies to asub5.af5;
						ps::ref4 => reference(asub6.af5) applies to asub6.af5;
					};
					asub3: refined to abstract a3.i1 {ps::ref1 => reference(asub7.af5) applies to asub7.af5;};
				calls
					sequence2: {
						call2: subprogram subp1.i1;
					} in modes (m3);
				connections
					fconn1: refined to feature;
				modes
					m3: mode;
					m4: mode;
					mt2: m3 -[ep1]-> m4;
				properties
					ps::ref1 => reference(asub1) applies to asub1;
					ps::ref2 => reference(asub1.asub4) applies to asub1.asub4;
					ps::ref3 => reference(asub2.asub4) applies to asub2.asub4;
					ps::ref4 => reference(fg1.af4) applies to fg1.af4;
					ps::ref5 => reference(fg2.af4) applies to fg2.af4;
					ps::ref6 => reference(asub1.asub4.af5) applies to asub1.asub4.af5;
					ps::ref7 => reference(asub1.asub5.af5) applies to asub1.asub5.af5;
					ps::ref8 => reference(asub1.asub6.af5) applies to asub1.asub6.af5;
					ps::ref9 => reference(asub3.asub7.af5) applies to asub3.asub7.af5;
					ps::ref10 => reference(asub1.fg3.af4) applies to asub1.fg3.af4;
					ps::ref11 => reference(asub1.fg4.af4) applies to asub1.fg4.af4;
					ps::ref12 => reference(asub1.fg5.af4) applies to asub1.fg5.af4;
					ps::ref13 => reference(asub3.fg6.af4) applies to asub3.fg6.af4;
					ps::ref14 => reference(x) applies to x;
					ps::ref15 => reference(asub1.x) applies to asub1.x;
				end a2.i1;

				subprogram subp1
				features
					af2: feature;
				end subp1;

				subprogram implementation subp1.i1
				end subp1.i1;

				abstract a3
				prototypes
					aproto2: abstract a4;
					aproto3: abstract;
					aproto4: abstract;
					fgproto2: feature group fgt2;
					fgproto3: feature group;
					fgproto4: feature group;
				features
					af3: feature;
					ep2: in event port;
					fg3: feature group fgt2;
					fg4: feature group fgproto2;
					fg5: feature group fgproto3;
					fg6: feature group fgproto4;
				flows
					fpath2: flow path af3 -> af3;
				end a3;

				abstract implementation a3.i1 (aproto3 => abstract a4, fgproto3 => feature group fgt2)
				subcomponents
					asub4: abstract a4;
					asub5: abstract aproto2;
					asub6: abstract aproto3;
					asub7: abstract aproto4;
				internal features
					es2: event;
				processor features
					pp2: port;
				calls
					sequence3: {
						call3: subprogram subp1;
					};
				connections
					fconn2: feature asub4.af5 -> asub4.af5;
				flows
					etef2: end to end flow asub4.fpath3 -> fconn2 -> asub4.fpath3;
				modes
					m5: initial mode;
					m6: mode;
					mt3: m5 -[ep2]-> m6;
				annex as2 {**
				**};
				end a3.i1;

				feature group fgt1
				prototypes
					fgproto5: feature group fgt3;
					fgproto6: feature group;
				features
					af4: feature;
					fg7: feature group fgt3;
					fg8: feature group fgproto5;
					fg9: feature group fgproto6;
				end fgt1;

				feature group fgt2 extends fgt1 (fgproto6 => feature group fgt3)
				end fgt2;

				abstract a4
				features
					af5: feature;
				flows
					fpath3: flow path af5 -> af5;
				end a4;

				feature group fgt3
				features
					af6: feature;
				end fgt3;
			end DotOperatorScopeTest1;
			""";

	private static final String DOT_OPERATOR_SCOPE_TEST_2 = """
			package DotOperatorScopeTest2
			public
				with ps;

				abstract a1Base
				prototypes
					fgproto1: feature group fgt1;
					fgproto6: feature group;
					aproto1: abstract a2.i;
					aproto6: abstract;
				features
					fg1: feature group fgt1;
					fg7: feature group fgproto1;
					fg13: feature group fgproto6;
				end a1Base;

				abstract a1 extends a1Base (fgproto6 => feature group fgt1, aproto6 => abstract a2.i)
				features
					fg1: refined to feature group fgt1 {ps::ref1 => reference(fg2.fg3.fg4.fg5.fg6) applies to fg2.fg3.fg4.fg5.fg6;};
					fg7: refined to feature group {ps::ref1 => reference(fg8.fg9.fg10.fg11.fg12) applies to fg8.fg9.fg10.fg11.fg12;};
					fg13: refined to feature group {ps::ref1 => reference(fg14.fg15.fg16.fg17.fg18) applies to fg14.fg15.fg16.fg17.fg18;};
				properties
					ps::ref1 => reference(fg1.fg2.fg3.fg4.fg5.fg6) applies to fg1.fg2.fg3.fg4.fg5.fg6;
					ps::ref2 => reference(fg7.fg8.fg9.fg10.fg11.fg12) applies to fg7.fg8.fg9.fg10.fg11.fg12;
					ps::ref3 => reference(fg13.fg14.fg15.fg16.fg17.fg18) applies to fg13.fg14.fg15.fg16.fg17.fg18;
				end a1;

				abstract implementation a1.iBase
				subcomponents
					asub1: abstract a2.i;
					asub7: abstract aproto1;
					asub13: abstract aproto6;
					asub19: abstract a2.i (aproto11 => abstract a3.i);
				end a1.iBase;

				abstract implementation a1.i extends a1.iBase
				subcomponents
					asub1: refined to abstract a2.i {ps::ref1 => reference(asub2.asub3.asub4.asub5.asub6) applies to asub2.asub3.asub4.asub5.asub6;};
					asub7: refined to abstract {ps::ref1 => reference(asub8.asub9.asub10.asub11.asub12) applies to asub8.asub9.asub10.asub11.asub12;};
					asub13: refined to abstract {ps::ref1 => reference(asub14.asub15.asub16.asub17.asub18) applies to asub14.asub15.asub16.asub17.asub18;};
					asub19: refined to abstract a2.i {ps::ref1 => reference(asub20.asub21.asub22.asub23.asub24) applies to asub20.asub21.asub22.asub23.asub24;};
				properties
					ps::ref4 => reference(fg1.fg2.fg3.fg4.fg5.fg6) applies to fg1.fg2.fg3.fg4.fg5.fg6;
					ps::ref5 => reference(fg7.fg8.fg9.fg10.fg11.fg12) applies to fg7.fg8.fg9.fg10.fg11.fg12;
					ps::ref6 => reference(fg13.fg14.fg15.fg16.fg17.fg18) applies to fg13.fg14.fg15.fg16.fg17.fg18;
					ps::ref7 => reference(asub1.asub2.asub3.asub4.asub5.asub6) applies to asub1.asub2.asub3.asub4.asub5.asub6;
					ps::ref8 => reference(asub7.asub8.asub9.asub10.asub11.asub12) applies to asub7.asub8.asub9.asub10.asub11.asub12;
					ps::ref9 => reference(asub13.asub14.asub15.asub16.asub17.asub18) applies to asub13.asub14.asub15.asub16.asub17.asub18;
					ps::ref10 => reference(asub19.asub20.asub21.asub22.asub23.asub24) applies to asub19.asub20.asub21.asub22.asub23.asub24;
				end a1.i;

				abstract a2
				prototypes
					aproto2: abstract a3.i;
					aproto7: abstract;
					aproto11: abstract;
				end a2;

				abstract implementation a2.iBase
				subcomponents
					asub2: abstract a3.i;
					asub8: abstract aproto2;
					asub14: abstract aproto7;
					asub20: abstract aproto11;
				end a2.iBase;

				abstract implementation a2.i extends a2.iBase (aproto7 => abstract a3.i)
				end a2.i;

				abstract a3
				prototypes
					aproto3: abstract a4.i;
					aproto8: abstract;
				end a3;

				abstract implementation a3.iBase
				subcomponents
					asub3: abstract a4.i;
					asub9: abstract aproto3;
					asub15: abstract aproto8;
					asub21: abstract a4.i (aproto12 => abstract a5.i);
				end a3.iBase;

				abstract implementation a3.i extends a3.iBase (aproto8 => abstract a4.i)
				end a3.i;

				abstract a4
				prototypes
					aproto4: abstract a5.i;
					aproto9: abstract;
					aproto12: abstract;
				end a4;

				abstract implementation a4.iBase
				subcomponents
					asub4: abstract a5.i;
					asub10: abstract aproto4;
					asub16: abstract aproto9;
					asub22: abstract aproto12;
				end a4.iBase;

				abstract implementation a4.i extends a4.iBase (aproto9 => abstract a5.i)
				end a4.i;

				abstract a5
				prototypes
					aproto5: abstract a6.i;
					aproto10: abstract;
				end a5;

				abstract implementation a5.iBase
				subcomponents
					asub5: abstract a6.i;
					asub11: abstract aproto5;
					asub17: abstract aproto10;
					asub23: abstract a6.i;
				end a5.iBase;

				abstract implementation a5.i extends a5.iBase (aproto10 => abstract a6.i)
				end a5.i;

				abstract a6
				end a6;

				abstract implementation a6.i
				subcomponents
					asub6: abstract;
					asub12: abstract;
					asub18: abstract;
					asub24: abstract;
				end a6.i;

				feature group fgt1Base
				prototypes
					fgproto2: feature group fgt2;
					fgproto7: feature group;
				features
					fg2: feature group fgt2;
					fg8: feature group fgproto2;
					fg14: feature group fgproto7;
				end fgt1Base;

				feature group fgt1 extends fgt1Base (fgproto7 => feature group fgt2)
				properties
					ps::ref1 => reference(fg2.fg3.fg4.fg5.fg6) applies to fg2.fg3.fg4.fg5.fg6;
					ps::ref2 => reference(fg8.fg9.fg10.fg11.fg12) applies to fg8.fg9.fg10.fg11.fg12;
					ps::ref3 => reference(fg14.fg15.fg16.fg17.fg18) applies to fg14.fg15.fg16.fg17.fg18;
				end fgt1;

				feature group fgt2Base
				prototypes
					fgproto3: feature group fgt3;
					fgproto8: feature group;
				features
					fg3: feature group fgt3;
					fg9: feature group fgproto3;
					fg15: feature group fgproto8;
				end fgt2Base;

				feature group fgt2 extends fgt2Base (fgproto8 => feature group fgt3)
				end fgt2;

				feature group fgt3Base
				prototypes
					fgproto4: feature group fgt4;
					fgproto9: feature group;
				features
					fg4: feature group fgt4;
					fg10: feature group fgproto4;
					fg16: feature group fgproto9;
				end fgt3Base;

				feature group fgt3 extends fgt3Base (fgproto9 => feature group fgt4)
				end fgt3;

				feature group fgt4Base
				prototypes
					fgproto5: feature group fgt5;
					fgproto10: feature group;
				features
					fg5: feature group fgt5;
					fg11: feature group fgproto5;
					fg17: feature group fgproto10;
				end fgt4Base;

				feature group fgt4 extends fgt4Base (fgproto10 => feature group fgt5)
				end fgt4;

				feature group fgt5
				features
					fg6: feature group;
					fg12: feature group;
					fg18: feature group;
				end fgt5;
			end DotOperatorScopeTest2;
			""";

	private static final List<String> A1_I1_ELEMENTS = List.of("af1", "aproto1", "as1", "asub1", "asub2", "asub3",
			"call1", "call2", "call2", "dp1", "ep1", "es1", "etef1", "fconn1", "fg1", "fg2", "fgproto1", "fpath1",
			"m1", "m2", "m3", "m4", "mt1", "mt2", "pp1", "sequence1", "sequence2");

	private static final List<String> A2_I1_ELEMENTS = List.of("af3", "aproto2", "aproto3", "aproto4", "as2", "asub4",
			"asub5", "asub6", "asub7", "call3", "call3", "ep2", "es2", "etef2", "fconn2", "fg3", "fg4", "fg5", "fg6",
			"fgproto2", "fgproto3", "fgproto4", "fpath2", "m5", "m6", "mt3", "pp2", "sequence3");

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Inject
	AssertHelper assertHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	// Tests scope_ContainmentPathElement_namedElement
	@Test
	public void testContainmentPathElements() throws Exception {
		testFileResult = issues = testHelper.testString(DOT_OPERATOR_SCOPE_TEST_1, PS);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("DotOperatorScopeTest1", pkg.getName());
		var abstractType = (AbstractType) pkg.getPublicSection().getOwnedClassifiers().get(2);
		assertEquals("a2", abstractType.getName());
		var featureGroup = abstractType.getOwnedFeatureGroups().get(0);
		assertEquals("fg1", featureGroup.getName());
		var association = featureGroup.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		var referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		var pathElement = referenceValue.getPath();
		assertEquals("af4", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of());
		assertNull(pathElement.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("af4", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of());
		assertNull(pathElement.getPath());
		association = featureGroup.getOwnedPropertyAssociations().get(1);
		assertEquals("ps::ref2", association.getProperty().getQualifiedName());
		assertScope(association, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("fg7", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af6"));
		var pathElement2 = pathElement.getPath();
		assertEquals("af6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg7", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		association = featureGroup.getOwnedPropertyAssociations().get(2);
		assertEquals("ps::ref3", association.getProperty().getQualifiedName());
		assertScope(association, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("fg8", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg8", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		association = featureGroup.getOwnedPropertyAssociations().get(3);
		assertEquals("ps::ref4", association.getProperty().getQualifiedName());
		assertScope(association, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("fg9", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg9", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		featureGroup = abstractType.getOwnedFeatureGroups().get(1);
		assertEquals("fg2", featureGroup.getName());
		association = featureGroup.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("af4", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of());
		assertNull(pathElement.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("af4", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of());
		assertNull(pathElement.getPath());
		association = featureGroup.getOwnedPropertyAssociations().get(1);
		assertEquals("ps::ref2", association.getProperty().getQualifiedName());
		assertScope(association, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("fg7", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg7", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		association = featureGroup.getOwnedPropertyAssociations().get(2);
		assertEquals("ps::ref3", association.getProperty().getQualifiedName());
		assertScope(association, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("fg8", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg8", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		association = featureGroup.getOwnedPropertyAssociations().get(3);
		assertEquals("ps::ref4", association.getProperty().getQualifiedName());
		assertScope(association, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("fg9", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg9", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		var abstractImplementation = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(3);
		assertEquals("a2.i1", abstractImplementation.getName());
		var abstractSubcomponent = abstractImplementation.getOwnedAbstractSubcomponents().get(0);
		assertEquals("asub1", abstractSubcomponent.getName());
		association = abstractSubcomponent.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, A2_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A2_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("af3", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of());
		assertNull(pathElement.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("af3", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of());
		assertNull(pathElement.getPath());
		association = abstractSubcomponent.getOwnedPropertyAssociations().get(1);
		assertEquals("ps::ref2", association.getProperty().getQualifiedName());
		assertScope(association, A2_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A2_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub4", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub4", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		association = abstractSubcomponent.getOwnedPropertyAssociations().get(2);
		assertEquals("ps::ref3", association.getProperty().getQualifiedName());
		assertScope(association, A2_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A2_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub5", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub5", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		association = abstractSubcomponent.getOwnedPropertyAssociations().get(3);
		assertEquals("ps::ref4", association.getProperty().getQualifiedName());
		assertScope(association, A2_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A2_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub6", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub6", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		abstractSubcomponent = abstractImplementation.getOwnedAbstractSubcomponents().get(1);
		assertEquals("asub2", abstractSubcomponent.getName());
		association = abstractSubcomponent.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, A2_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A2_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("af3", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of());
		assertNull(pathElement.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("af3", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of());
		assertNull(pathElement.getPath());
		association = abstractSubcomponent.getOwnedPropertyAssociations().get(1);
		assertEquals("ps::ref2", association.getProperty().getQualifiedName());
		assertScope(association, A2_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A2_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub4", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub4", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		association = abstractSubcomponent.getOwnedPropertyAssociations().get(2);
		assertEquals("ps::ref3", association.getProperty().getQualifiedName());
		assertScope(association, A2_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A2_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub5", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub5", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		association = abstractSubcomponent.getOwnedPropertyAssociations().get(3);
		assertEquals("ps::ref4", association.getProperty().getQualifiedName());
		assertScope(association, A2_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A2_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub6", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub6", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		abstractSubcomponent = abstractImplementation.getOwnedAbstractSubcomponents().get(2);
		assertEquals("asub3", abstractSubcomponent.getName());
		association = abstractSubcomponent.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, A2_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A2_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub7", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub7", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af5", "fpath3"));
		pathElement2 = pathElement.getPath();
		assertEquals("af5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		assertNull(pathElement.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		assertNull(pathElement.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(1);
		assertEquals("ps::ref2", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("asub4", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af5", "fpath3"));
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("asub4", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af5", "fpath3"));
		assertNull(pathElement2.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(2);
		assertEquals("ps::ref3", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub2", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("asub4", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af5", "fpath3"));
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub2", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("asub4", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af5", "fpath3"));
		assertNull(pathElement2.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(3);
		assertEquals("ps::ref4", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("fg1", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af4", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg1", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af4", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(4);
		assertEquals("ps::ref5", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("fg2", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af4", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg2", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement2 = pathElement.getPath();
		assertEquals("af4", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of());
		assertNull(pathElement2.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(5);
		assertEquals("ps::ref6", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("asub4", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af5", "fpath3"));
		var pathElement3 = pathElement2.getPath();
		assertEquals("af5", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("asub4", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af5", "fpath3"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af5", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(6);
		assertEquals("ps::ref7", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("asub5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af5", "fpath3"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af5", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("asub5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af5", "fpath3"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af5", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(7);
		assertEquals("ps::ref8", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("asub6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af5", "fpath3"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af5", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("asub6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af5", "fpath3"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af5", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(8);
		assertEquals("ps::ref9", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub3", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("asub7", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af5", "fpath3"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af5", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub3", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("asub7", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af5", "fpath3"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af5", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(9);
		assertEquals("ps::ref10", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("fg3", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af4", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("fg3", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af4", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(10);
		assertEquals("ps::ref11", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("fg4", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af4", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("fg4", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af4", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(11);
		assertEquals("ps::ref12", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("fg5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af4", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("fg5", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af4", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(12);
		assertEquals("ps::ref13", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub3", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("fg6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af4", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub3", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertEquals("fg6", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("af4", "fg7", "fg8", "fg9", "fgproto5", "fgproto6"));
		pathElement3 = pathElement2.getPath();
		assertEquals("af4", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of());
		assertNull(pathElement3.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(13);
		assertEquals("ps::ref14", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertError(pathElement, "Couldn't resolve reference to 'x'.");
		assertScope(pathElement, A1_I1_ELEMENTS);
		assertNull(pathElement.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertError(pathElement, "Couldn't resolve reference to 'x'.");
		assertScope(pathElement, A1_I1_ELEMENTS);
		assertNull(pathElement.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(14);
		assertEquals("ps::ref15", association.getProperty().getQualifiedName());
		assertScope(association, A1_I1_ELEMENTS);
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, A1_I1_ELEMENTS);
		pathElement = referenceValue.getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertError(pathElement2, "Couldn't resolve reference to 'x'.");
		assertScope(pathElement2, A2_I1_ELEMENTS);
		assertNull(pathElement2.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, A2_I1_ELEMENTS);
		pathElement2 = pathElement.getPath();
		assertError(pathElement2, "Couldn't resolve reference to 'x'.");
		assertScope(pathElement2, A2_I1_ELEMENTS);
		assertNull(pathElement2.getPath());

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests scope_ContainmentPathElement_namedElement
	@Test
	public void testContainmentPathElements2() throws Exception {
		var pkg = testHelper.parseString(DOT_OPERATOR_SCOPE_TEST_2, PS);
		assertEquals("DotOperatorScopeTest2", pkg.getName());
		var abstractType = (AbstractType) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("a1", abstractType.getName());
		var featureGroup = abstractType.getOwnedFeatureGroups().get(0);
		assertEquals("fg1", featureGroup.getName());
		var association = featureGroup.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		var referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		var pathElement = referenceValue.getPath();
		assertEquals("fg2", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		var pathElement2 = pathElement.getPath();
		assertEquals("fg3", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		var pathElement3 = pathElement2.getPath();
		assertEquals("fg4", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		var pathElement4 = pathElement3.getPath();
		assertEquals("fg5", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg12", "fg18", "fg6"));
		var pathElement5 = pathElement4.getPath();
		assertEquals("fg6", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg2", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg3", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg4", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg5", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg12", "fg18", "fg6"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg6", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		featureGroup = abstractType.getOwnedFeatureGroups().get(1);
		assertEquals("fg7", featureGroup.getName());
		association = featureGroup.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement = referenceValue.getPath();
		assertEquals("fg8", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg9", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg10", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg11", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg12", "fg18", "fg6"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg12", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg8", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg9", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg10", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg11", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg12", "fg18", "fg6"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg12", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		featureGroup = abstractType.getOwnedFeatureGroups().get(2);
		assertEquals("fg13", featureGroup.getName());
		association = featureGroup.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement = referenceValue.getPath();
		assertEquals("fg14", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg15", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg16", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg17", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg12", "fg18", "fg6"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg18", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg14", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg15", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg16", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg17", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg12", "fg18", "fg6"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg18", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		association = abstractType.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, List.of("aproto1", "aproto6", "fg1", "fg13", "fg7", "fgproto1", "fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("aproto1", "aproto6", "fg1", "fg13", "fg7", "fgproto1", "fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("fg1", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg2", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg3", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg4", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg5", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("fg12", "fg18", "fg6"));
		var pathElement6 = pathElement5.getPath();
		assertEquals("fg6", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg1", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg2", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg3", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg4", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg5", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("fg12", "fg18", "fg6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("fg6", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		association = abstractType.getOwnedPropertyAssociations().get(1);
		assertEquals("ps::ref2", association.getProperty().getQualifiedName());
		assertScope(association, List.of("aproto1", "aproto6", "fg1", "fg13", "fg7", "fgproto1", "fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("aproto1", "aproto6", "fg1", "fg13", "fg7", "fgproto1", "fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("fg7", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg8", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg9", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg10", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg11", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("fg12", "fg18", "fg6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("fg12", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg7", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg8", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg9", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg10", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg11", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("fg12", "fg18", "fg6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("fg12", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		association = abstractType.getOwnedPropertyAssociations().get(2);
		assertEquals("ps::ref3", association.getProperty().getQualifiedName());
		assertScope(association, List.of("aproto1", "aproto6", "fg1", "fg13", "fg7", "fgproto1", "fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("aproto1", "aproto6", "fg1", "fg13", "fg7", "fgproto1", "fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("fg13", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg14", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg15", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg16", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg17", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("fg12", "fg18", "fg6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("fg18", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg13", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg14", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg15", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg16", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg17", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("fg12", "fg18", "fg6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("fg18", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		var abstractImplementation = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(3);
		assertEquals("a1.i", abstractImplementation.getName());
		var abstractSubcomponent = abstractImplementation.getOwnedAbstractSubcomponents().get(0);
		assertEquals("asub1", abstractSubcomponent.getName());
		association = abstractSubcomponent.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		pathElement = referenceValue.getPath();
		assertEquals("asub2", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub3", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub4", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub5", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub6", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub2", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub3", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub4", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub5", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub6", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		abstractSubcomponent = abstractImplementation.getOwnedAbstractSubcomponents().get(1);
		assertEquals("asub7", abstractSubcomponent.getName());
		association = abstractSubcomponent.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		pathElement = referenceValue.getPath();
		assertEquals("asub8", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub9", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub10", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub11", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub12", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub8", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub9", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub10", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub11", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub12", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		abstractSubcomponent = abstractImplementation.getOwnedAbstractSubcomponents().get(2);
		assertEquals("asub13", abstractSubcomponent.getName());
		association = abstractSubcomponent.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		pathElement = referenceValue.getPath();
		assertEquals("asub14", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub15", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub16", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub17", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub18", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub14", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub15", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub16", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub17", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub18", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		abstractSubcomponent = abstractImplementation.getOwnedAbstractSubcomponents().get(3);
		assertEquals("asub19", abstractSubcomponent.getName());
		association = abstractSubcomponent.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref1", association.getProperty().getQualifiedName());
		assertScope(association, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		pathElement = referenceValue.getPath();
		assertEquals("asub20", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub21", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub22", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub23", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub24", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub20", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub21", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub22", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub23", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub24", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of());
		assertNull(pathElement5.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(0);
		assertEquals("ps::ref4", association.getProperty().getQualifiedName());
		assertScope(association,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("fg1", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg2", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg3", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg4", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg5", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("fg12", "fg18", "fg6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("fg6", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg1", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg2", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg3", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg4", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg5", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("fg12", "fg18", "fg6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("fg6", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(1);
		assertEquals("ps::ref5", association.getProperty().getQualifiedName());
		assertScope(association,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("fg7", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg8", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg9", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg10", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg11", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("fg12", "fg18", "fg6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("fg12", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg7", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg8", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg9", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg10", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg11", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("fg12", "fg18", "fg6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("fg12", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(2);
		assertEquals("ps::ref6", association.getProperty().getQualifiedName());
		assertScope(association,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("fg13", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg14", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg15", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg16", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg17", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("fg12", "fg18", "fg6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("fg18", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("fg13", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("fg14", "fg2", "fg8", "fgproto2", "fgproto7"));
		pathElement2 = pathElement.getPath();
		assertEquals("fg14", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("fg15", "fg3", "fg9", "fgproto3", "fgproto8"));
		pathElement3 = pathElement2.getPath();
		assertEquals("fg15", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("fg10", "fg16", "fg4", "fgproto4", "fgproto9"));
		pathElement4 = pathElement3.getPath();
		assertEquals("fg16", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("fg11", "fg17", "fg5", "fgproto10", "fgproto5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("fg17", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("fg12", "fg18", "fg6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("fg18", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(3);
		assertEquals("ps::ref7", association.getProperty().getQualifiedName());
		assertScope(association,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub2", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub3", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub4", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub5", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("asub6", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub1", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub2", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub3", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub4", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub5", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("asub6", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(4);
		assertEquals("ps::ref8", association.getProperty().getQualifiedName());
		assertScope(association,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("asub7", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub8", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub9", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub10", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub11", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("asub12", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub7", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub8", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub9", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub10", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub11", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("asub12", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(5);
		assertEquals("ps::ref9", association.getProperty().getQualifiedName());
		assertScope(association,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("asub13", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub14", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub15", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub16", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub17", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("asub18", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub13", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub14", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub15", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub16", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub17", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("asub18", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		association = abstractImplementation.getOwnedPropertyAssociations().get(6);
		assertEquals("ps::ref10", association.getProperty().getQualifiedName());
		assertScope(association,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		referenceValue = (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
		assertScope(referenceValue,
				List.of("aproto1", "aproto6", "asub1", "asub13", "asub19", "asub7", "fg1", "fg13", "fg7", "fgproto1",
						"fgproto6"));
		pathElement = referenceValue.getPath();
		assertEquals("asub19", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub20", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub21", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub22", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub23", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("asub24", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
		pathElement = association.getAppliesTos().getFirst().getPath();
		assertEquals("asub19", pathElement.getNamedElement().getName());
		assertScope(pathElement, List.of("aproto11", "aproto2", "aproto7", "asub14", "asub2", "asub20", "asub8"));
		pathElement2 = pathElement.getPath();
		assertEquals("asub20", pathElement2.getNamedElement().getName());
		assertScope(pathElement2, List.of("aproto3", "aproto8", "asub15", "asub21", "asub3", "asub9"));
		pathElement3 = pathElement2.getPath();
		assertEquals("asub21", pathElement3.getNamedElement().getName());
		assertScope(pathElement3, List.of("aproto12", "aproto4", "aproto9", "asub10", "asub16", "asub22", "asub4"));
		pathElement4 = pathElement3.getPath();
		assertEquals("asub22", pathElement4.getNamedElement().getName());
		assertScope(pathElement4, List.of("aproto10", "aproto5", "asub11", "asub17", "asub23", "asub5"));
		pathElement5 = pathElement4.getPath();
		assertEquals("asub23", pathElement5.getNamedElement().getName());
		assertScope(pathElement5, List.of("asub12", "asub18", "asub24", "asub6"));
		pathElement6 = pathElement5.getPath();
		assertEquals("asub24", pathElement6.getNamedElement().getName());
		assertScope(pathElement6, List.of());
		assertNull(pathElement6.getPath());
	}

	private void assertScope(EObject object, List<String> expected) {
		assertHelper.assertScope(object, Aadl2Package.eINSTANCE.getContainmentPathElement_NamedElement(), expected);
	}

	private void assertError(EObject object, String... messages) {
		AssertHelper.assertError(object, testFileResult.getIssues(), issueCollection, messages);
	}
}
