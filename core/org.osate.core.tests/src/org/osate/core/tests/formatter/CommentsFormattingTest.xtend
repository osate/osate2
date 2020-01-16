/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.core.tests.formatter

import com.google.inject.Inject
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
class CommentsFormattingTest {
	@Inject
	extension FormatterTestHelper
	
	@Test
	def void testPropertySet() {
		assertFormatted[
			useSerializer = false
			expectation = '''
				-- Comment
				property set ps1 is
					-- Comment
					with ps2;
					-- Comment
					with ps3;
				
					-- Comment
					type01: type aadlboolean;
					-- Comment
					type02: type aadlstring;
					-- Comment
					type03: type enumeration (a, b, c);
					-- Comment
					type04: type units (a, b => a * 10, c => b * 10);
					-- Comment
					type05: type aadlreal;
					-- Comment
					type06: type aadlinteger;
					-- Comment
					type07: type range of aadlinteger;
					-- Comment
					type08: type classifier (system);
					-- Comment
					type09: type reference (system);
					-- Comment
					type10: type record (f1: aadlinteger;);
					-- Comment
					const1: constant ps2::type1 => 5;
					-- Comment
					def1: ps3::type1 applies to (all);
					-- Comment
					def2: aadlinteger applies to (all);
				end ps1;'''
			toBeFormatted = '''
				 -- Comment
				property set ps1 is
				 -- Comment
				with ps2;
				 -- Comment
				with ps3;
				 -- Comment
				type01:type aadlboolean;
				 -- Comment
				type02:type aadlstring;
				 -- Comment
				type03:type enumeration(a,b,c);
				 -- Comment
				type04:type units(a,b=>a*10,c=>b*10);
				 -- Comment
				type05:type aadlreal;
				 -- Comment
				type06:type aadlinteger;
				 -- Comment
				type07:type range of aadlinteger;
				 -- Comment
				type08:type classifier(system);
				 -- Comment
				type09:type reference(system);
				 -- Comment
				type10:type record(f1:aadlinteger;);
				 -- Comment
				const1:constant ps2::type1=>5;
				 -- Comment
				def1:ps3::type1 applies to(all);
				 -- Comment
				def2:aadlinteger applies to(all);end ps1;
			'''
		]
	}
	
	@Test
	def void testPackage() {
		assertFormatted[
			useSerializer = false
			expectation = '''
				-- Comment
				package pkg1
				-- Comment
				public
					-- Comment
					with ps1;
					-- Comment
					with pkg2;
					-- Comment
					renames pkg2::all;
					-- Comment
					renames feature group pkg2::fgt1;
					-- Comment
					renames abstract pkg2::a1;
				
					-- Comment
					annex EMV2 {**
					**};
				
				-- Comment
				private
				-- Comment
				properties
					-- Comment
					ps1::def1 => 1;
					-- Comment
					ps1::def2 => 2;
				end pkg1;'''
			toBeFormatted = '''
				 -- Comment
				package pkg1
				 -- Comment
				public
				 -- Comment
				with ps1;
				 -- Comment
				with pkg2;
				 -- Comment
				renames pkg2::all;
				 -- Comment
				renames feature group pkg2::fgt1;
				 -- Comment
				renames abstract pkg2::a1;
				 -- Comment
				annex EMV2{**
					**};
				 -- Comment
				private
				 -- Comment
				properties
				 -- Comment
				ps1::def1=>1;
				 -- Comment
				ps1::def2=>2;
				end pkg1;
			'''
		]
		
		assertFormatted[
			useSerializer = false
			expectation = '''
				-- Comment
				package pkg2
				-- Comment
				public
					-- Comment
					feature group fgt1
					end fgt1;
				
					-- Comment
					abstract a1
					end a1;
				
					-- Comment
					abstract implementation a1.i1
					end a1.i1;
				-- Comment
				properties
					-- Comment
					none;
				end pkg2;'''
			toBeFormatted = '''
				 -- Comment
				package pkg2
				 -- Comment
				public
				 -- Comment
				feature group fgt1 end fgt1;
				 -- Comment
				abstract a1 end a1;
				 -- Comment
				abstract implementation a1.i1 end a1.i1;
				 -- Comment
				properties
				 -- Comment
				none;end pkg2;
			'''
		]
	}
	
	@Test
	def void testComponentType() {
		assertFormatted[
			useSerializer = false
			expectation = '''
				-- Comment
				package pkg1
				-- Comment
				public
					-- Comment
					abstract a1
						-- Comment
						prototypes
							-- Comment
							none;
						-- Comment
						features
							-- Comment
							none;
						-- Comment
						flows
							-- Comment
							none;
						-- Comment
						modes
							-- Comment
							none;
						-- Comment
						properties
							-- Comment
							none;
					end a1;
				
					-- Comment
					abstract a2
						-- Comment
						requires modes
							-- Comment
							m1: mode;
					end a2;
				
					-- Comment
					abstract a3
						-- Comment
						prototypes
							-- Comment
							p1: feature group;
							-- Comment
							p2: feature;
							-- Comment
							p3: system;
						-- Comment
						features
							-- Comment
							f1: in data port;
							-- Comment
							f2: in event data port;
							-- Comment
							f3: in event port;
							-- Comment
							f4: feature group;
							-- Comment
							f5: provides subprogram access;
							-- Comment
							f6: provides subprogram group access;
							-- Comment
							f7: provides bus access;
							-- Comment
							f8: provides data access;
							-- Comment
							f9: feature;
						-- Comment
						flows
							-- Comment
							flow1: flow sink f1;
						-- Comment
						modes
							-- Comment
							m1: initial mode;
							-- Comment
							m2: mode;
							-- Comment
							m1 -[f3]-> m2;
						-- Comment
						properties
							-- Comment
							Period => 1ms;
						-- Comment
						annex EMV2 {**
						**};
					end a3;
				
					-- Comment
					subprogram s1
						-- Comment
						features
							-- Comment
							f1: in parameter;
					end s1;
				end pkg1;'''
			toBeFormatted = '''
				 -- Comment
				package pkg1
				 -- Comment
				public
				 -- Comment
				abstract a1
				 -- Comment
				prototypes
				 -- Comment
				none;
				 -- Comment
				features
				 -- Comment
				none;
				 -- Comment
				flows
				 -- Comment
				none;
				 -- Comment
				modes
				 -- Comment
				none;
				 -- Comment
				properties
				 -- Comment
				none;end a1;
				 -- Comment
				abstract a2
				 -- Comment
				requires modes
				 -- Comment
				m1:mode;end a2;
				 -- Comment
				abstract a3
				 -- Comment
				prototypes
				 -- Comment
				p1:feature group;
				 -- Comment
				p2:feature;
				 -- Comment
				p3:system;
				 -- Comment
				features
				 -- Comment
				f1:in data port;
				 -- Comment
				f2:in event data port;
				 -- Comment
				f3:in event port;
				 -- Comment
				f4:feature group;
				 -- Comment
				f5:provides subprogram access;
				 -- Comment
				f6:provides subprogram group access;
				 -- Comment
				f7:provides bus access;
				 -- Comment
				f8:provides data access;
				 -- Comment
				f9:feature;
				 -- Comment
				flows
				 -- Comment
				flow1:flow sink f1;
				 -- Comment
				modes
				 -- Comment
				m1:initial mode;
				 -- Comment
				m2:mode;
				 -- Comment
				m1-[f3]->m2;
				 -- Comment
				properties
				 -- Comment
				Period=>1ms;
				 -- Comment
				annex EMV2{**
						**};end a3;
				 -- Comment
				subprogram s1
				 -- Comment
				features
				 -- Comment
				f1:in parameter;end s1;end pkg1;
			'''
		]
	}
	
	@Test
	def void testFeatureGroupType() {
		assertFormatted[
			useSerializer = false
			expectation = '''
				-- Comment
				package pkg1
				-- Comment
				public
					-- Comment
					with ps1;
				
					-- Comment
					feature group fgt1
						-- Comment
						prototypes
							-- Comment
							none;
						-- Comment
						features
							-- Comment
							f1: feature;
							-- Comment
							f2: feature;
						-- Comment
						properties
							-- Comment
							none;
					end fgt1;
				
					-- Comment
					feature group fgt2
						-- Comment
						inverse of fgt1
					end fgt2;
				
					-- Comment
					feature group fgt3
						-- Comment
						prototypes
							-- Comment
							none;
						-- Comment
						features
							-- Comment
							f1: feature;
							-- Comment
							f2: feature;
						-- Comment
						inverse of fgt1
						-- Comment
						properties
							-- Comment
							none;
					end fgt3;
				
					-- Comment
					feature group fgt4 extends fgt1
						-- Comment
						prototypes
							-- Comment
							p1: feature group;
							-- Comment
							p2: feature;
							-- Comment
							p3: system;
						-- Comment
						features
							-- Comment
							f3: in data port;
							-- Comment
							f4: in event data port;
							-- Comment
							f5: in event port;
							-- Comment
							f6: feature group;
							-- Comment
							f7: provides subprogram access;
							-- Comment
							f8: provides subprogram group access;
							-- Comment
							f9: provides bus access;
							-- Comment
							f10: provides data access;
							-- Comment
							f11: feature;
						-- Comment
						properties
							-- Comment
							ps1::def1 => 1;
							-- Comment
							ps1::def2 => 2;
						-- Comment
						annex EMV2 {**
						**};
					end fgt4;
				
					-- Comment
					feature group fgt5 extends fgt4 (p2 => in data port)
						-- Comment
						prototypes
							-- Comment
							none;
					end fgt5;
				end pkg1;'''
			toBeFormatted = '''
				 -- Comment
				package pkg1
				 -- Comment
				public
				 -- Comment
				with ps1;	
				 -- Comment
				feature group fgt1
				 -- Comment
				prototypes
				 -- Comment
				none;
				 -- Comment
				features
				 -- Comment
				f1:feature;
				 -- Comment
				f2:feature;
				 -- Comment
				properties
				 -- Comment
				none;end fgt1;	
				 -- Comment
				feature group fgt2
				 -- Comment
				inverse of fgt1 end fgt2;
				 -- Comment
				feature group fgt3
				 -- Comment
				prototypes
				 -- Comment
				none;
				 -- Comment
				features
				 -- Comment
				f1:feature;
				 -- Comment
				f2:feature;
				 -- Comment
				inverse of fgt1
				 -- Comment
				properties
				 -- Comment
				none;
				end fgt3;
				 -- Comment
				feature group fgt4 extends fgt1
				 -- Comment
				prototypes
				 -- Comment
				p1:feature group;
				 -- Comment
				p2:feature;
				 -- Comment
				p3:system;
				 -- Comment
				features
				 -- Comment
				f3:in data port;
				 -- Comment
				f4:in event data port;
				 -- Comment
				f5:in event port;
				 -- Comment
				f6:feature group;
				 -- Comment
				f7:provides subprogram access;
				 -- Comment
				f8:provides subprogram group access;
				 -- Comment
				f9:provides bus access;
				 -- Comment
				f10:provides data access;
				 -- Comment
				f11:feature;
				 -- Comment
				properties
				 -- Comment
				ps1::def1=>1;
				 -- Comment
				ps1::def2=>2;
				 -- Comment
				annex EMV2{**
						**};end fgt4;
				 -- Comment
				feature group fgt5 extends fgt4(p2=>in data port)
				 -- Comment
				 prototypes
				 -- Comment
				none;end fgt5;end pkg1;
			'''
		]
	}
	
	@Test
	def void testComponentImplementation() {
		assertFormatted[
			useSerializer = false
			expectation = '''
				-- Comment
				package pkg1
				-- Comment
				public
					-- Comment
					abstract a1
						-- Comment
						features
							-- Comment
							f1: feature;
						-- Comment
						flows
							-- Comment
							flow1: flow source f1;
					end a1;
				
					-- Comment
					abstract implementation a1.i1
						-- Comment
						prototypes
							-- Comment
							none;
						-- Comment
						subcomponents
							-- Comment
							none;
						-- Comment
						internal features
							-- Comment
							es1: event;
							-- Comment
							eds1: event data;
						-- Comment
						processor features
							-- Comment
							pp1: port;
							-- Comment
							sp1: subprogram;
						-- Comment
						calls
							-- Comment
							none;
						-- Comment
						connections
							-- Comment
							none;
						-- Comment
						flows
							-- Comment
							none;
						-- Comment
						modes
							-- Comment
							none;
						-- Comment
						properties
							-- Comment
							none;
					end a1.i1;
				
					-- Comment
					abstract implementation a1.i2
						-- Comment
						prototypes
							-- Comment
							p1: feature group;
							-- Comment
							p2: feature;
							-- Comment
							p3: system;
						-- Comment
						subcomponents
							-- Comment
							sub1: subprogram;
							-- Comment
							sub2: abstract a2;
							-- Comment
							sub3: abstract a3;
						-- Comment
						calls
							-- Comment
							sequence1: {
								-- Comment
								call1: subprogram sub1;
							};
						-- Comment
						connections
							-- Comment
							conn1: feature sub2.f2 -> sub3.f3;
							-- Comment
							conn2: feature sub2.f2 -> f1;
						-- Comment
						flows
							-- Comment
							flow1: flow source sub2.flow2 -> conn2 -> f1;
							-- Comment
							etef1: end to end flow sub2.flow2 -> conn1 -> sub3.flow3;
						-- Comment
						modes
							-- Comment
							m1: initial mode;
							-- Comment
							m2: mode;
						-- Comment
						properties
							-- Comment
							Dispatch_Able => true;
						-- Comment
						annex EMV2 {**
						**};
					end a1.i2;
				
					-- Comment
					abstract implementation a1.i3 extends a1.i2
						-- Comment
						prototypes
							-- Comment
							none;
					end a1.i3;
				
					-- Comment
					abstract implementation a1.i4 extends a1.i2 (p2 => in data port)
						-- Comment
						prototypes
							-- Comment
							none;
					end a1.i4;
				
					-- Comment
					abstract a2
						-- Comment
						features
							-- Comment
							f2: feature;
						-- Comment
						flows
							-- Comment
							flow2: flow source f2;
					end a2;
				
					-- Comment
					abstract a3
						-- Comment
						features
							-- Comment
							f3: feature;
						-- Comment
						flows
							-- Comment
							flow3: flow sink f3;
					end a3;
				end pkg1;'''
			toBeFormatted = '''
				 -- Comment
				package pkg1
				 -- Comment
				public
				 -- Comment
				abstract a1
				 -- Comment
				features
				 -- Comment
				f1:feature;
				 -- Comment
				flows
				 -- Comment
				flow1:flow source f1;end a1;
				 -- Comment
				abstract implementation a1.i1
				 -- Comment
				prototypes
				 -- Comment
				none;
				 -- Comment
				subcomponents
				 -- Comment
				none;
				 -- Comment
				internal features
				 -- Comment
				es1:event;
				 -- Comment
				eds1:event data;
				 -- Comment
				processor features
				 -- Comment
				pp1:port;
				 -- Comment
				sp1:subprogram;
				 -- Comment
				calls
				 -- Comment
				none;
				 -- Comment
				connections
				 -- Comment
				none;
				 -- Comment
				flows
				 -- Comment
				none;
				 -- Comment
				modes
				 -- Comment
				none;
				 -- Comment
				properties
				 -- Comment
				none;end a1.i1;
				 -- Comment
				abstract implementation a1.i2
				 -- Comment
				prototypes
				 -- Comment
				p1:feature group;
				 -- Comment
				p2:feature;
				 -- Comment
				p3:system;
				 -- Comment
				subcomponents
				 -- Comment
				sub1:subprogram;
				 -- Comment
				sub2:abstract a2;
				 -- Comment
				sub3:abstract a3;
				 -- Comment
				calls
				 -- Comment
				sequence1:{
				 -- Comment
				call1:subprogram sub1;};
				 -- Comment
				connections
				 -- Comment
				conn1:feature sub2.f2->sub3.f3;
				 -- Comment
				conn2:feature sub2.f2->f1;
				 -- Comment
				flows
				 -- Comment
				flow1:flow source sub2.flow2->conn2->f1;
				 -- Comment
				etef1:end to end flow sub2.flow2->conn1->sub3.flow3;
				 -- Comment
				modes
				 -- Comment
				m1:initial mode;
				 -- Comment
				m2:mode;
				 -- Comment
				properties
				 -- Comment
				Dispatch_Able=>true;
				 -- Comment
				annex EMV2{**
						**};end a1.i2;
				 -- Comment
				abstract implementation a1.i3 extends a1.i2
				 -- Comment
				prototypes
				 -- Comment
				none;end a1.i3;
				 -- Comment
				abstract implementation a1.i4 extends a1.i2(p2=>in data port)
				 -- Comment
				prototypes
				 -- Comment
				none;end a1.i4;
				 -- Comment
				abstract a2
				 -- Comment
				features
				 -- Comment
				f2:feature;
				 -- Comment
				flows
				 -- Comment
				flow2:flow source f2;end a2;
				 -- Comment
				abstract a3
				 -- Comment
				features
				 -- Comment
				f3:feature;
				 -- Comment
				flows
				 -- Comment
				flow3:flow sink f3;end a3;end pkg1;
			'''
		]
	}
}