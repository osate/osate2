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
package org.osate.aadl2.errormodel.tests.formatter

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.FormatterTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class FormatterTest {
	@Inject extension FormatterTestHelper
	
	@Test
	def void library() {
		assertFormatted[
			useSerializer = false
			allowUnformattedWhitespace = false
			expectation = '''
				package test
				public
					annex EMV2 {**
						error types
							use types ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
								ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
								ErrorLibrary, ErrorLibrary, ErrorLibrary;
							extends ErrorLibrary, lib2, lib3 with
							t1: type;
							t2: type extends AboveRange;
							t3 renames type AboveRange;
							ts1: type set {t1, AboveRange, AsymmetricApproximateValue * AboveRange * AsymmetricExactValue *
								AsymmetricItemOmission * AsymmetricOmission * AsymmetricReplicatesError * AsymmetricServiceOmission *
								AsymmetricTiming, WriteWriteRace, UndetectableValueError, BelowRange, BoundedOmissionInterval,
								BoundedValueChange, Deadlock};
							ts2 renames type set CommonErrors;
							properties
								EMV2::Severity => 1 applies to t1;
								EMV2::Severity => 2 applies to t2;
						end types;
						
						error behavior bvr1
							use types ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
								ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
								ErrorLibrary, ErrorLibrary, ErrorLibrary;
							use transformations transformation1;
							events
								evt1: error event;
								evt2: error event {AboveRange};
								evt3: error event if "condition";
								evt4: error event {AboveRange} if "condition";
							states
								state1: initial state;
								state2: state;
								state3: state {AsymmetricExactValue * AboveRange * AsymmetricApproximateValue};
								state4: state {AboveRange};
							transitions
								all -[memory]-> same state;
								transition1: all -[processor]-> same state;
								state1 -[memory]-> same state;
								transition2: state1 -[memory]-> same state;
								state4 {AboveRange} -[memory]-> same state;
								all -[(memory)]-> same state;
								all -[memory]-> state1;
								all -[memory]-> state4 {AboveRange};
								all -[memory]-> (state1 with 0.1, state2 with EMV2::ExposurePeriod, state4 {AboveRange} with 0.1,
									same state with others);
								all -[memory or memory or memory or memory or memory or memory or memory or memory or memory or memory or
									memory or memory or memory]-> same state;
							properties
								EMV2::StateKind => Working applies to state1;
								EMV2::StateKind => Working applies to state2;
						end behavior;
						
						error behavior bvr2
						end behavior;
						
						type mappings map1
							use types ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
								ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
								ErrorLibrary, ErrorLibrary, ErrorLibrary;
							{AboveRange} -> {AsymmetricApproximateValue};
							{AsymmetricExactValue} -> {AsymmetricItemOmission};
						end mappings;
						
						type mappings map2
							{ErrorLibrary::AsymmetricExactValue} -> {ErrorLibrary::AsymmetricItemOmission};
						end mappings;
						
						type transformations transformation1
							use types ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
								ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
								ErrorLibrary, ErrorLibrary, ErrorLibrary;
							all -[]-> {AsymmetricReplicatesError};
							all -[{noerror}]-> {AsymmetricApproximateValue};
							{noerror} -[]-> {AboveRange};
							{noerror} -[{noerror}]-> {AsymmetricExactValue};
						end transformations;
						
						type transformations transformation2
							all -[]-> {ErrorLibrary::AsymmetricServiceOmission};
						end transformations;
					**};
				end test;'''
			toBeFormatted = '   package   test   public   annex   EMV2   {**   error   types   use   ' +
				'types   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ;   extends   ErrorLibrary   ,   lib2   ,   lib3   ' +
				'with   t1   :   type   ;   t2   :   type   extends   AboveRange   ;   t3   renames   ' +
				'type   AboveRange   ;   ts1   :   type   set   {   t1   ,   AboveRange   ,   ' +
				'AsymmetricApproximateValue   *   AboveRange   *   AsymmetricExactValue   *   ' +
				'AsymmetricItemOmission   *   AsymmetricOmission   *   AsymmetricReplicatesError   *   ' +
				'AsymmetricServiceOmission   *   AsymmetricTiming   ,   WriteWriteRace   ,   ' +
				'UndetectableValueError   ,   BelowRange   ,   BoundedOmissionInterval   ,   ' +
				'BoundedValueChange   ,   Deadlock   }   ;   ts2   renames   type   set   CommonErrors   ' +
				';   properties   EMV2::Severity   =>   1   applies   to   t1   ;   EMV2::Severity   =>   ' +
				'2   applies   to   t2   ;   end   types   ;   error   behavior   bvr1   use   types   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ;   use   transformations   transformation1   ;   ' +
				'events   evt1   :   error   event   ;   evt2   :   error   event   {   AboveRange   }   ' +
				';   evt3   :   error   event   if   "condition"   ;   evt4   :   error   event   {   ' +
				'AboveRange   }   if   "condition"   ;   states   state1   :   initial   state   ;   ' +
				'state2   :   state   ;   state3   :   state   {   AsymmetricExactValue   *   ' +
				'AboveRange   *   AsymmetricApproximateValue   }   ;   state4   :   state   {   ' +
				'AboveRange   }   ;   transitions   all   -[   memory   ]->   same   state   ;   ' +
				'transition1   :   all   -[   processor   ]->   same   state   ;   state1   -[   memory   ' +
				']->   same   state   ;   transition2   :   state1   -[   memory   ]->   same   state   ' +
				';   state4   {   AboveRange   }   -[   memory   ]->   same   state   ;   all   -[   (   ' +
				'memory   )   ]->   same   state   ;   all   -[   memory   ]->   state1   ;   all   -[   ' +
				'memory   ]->   state4   {   AboveRange   }   ;   all   -[   memory   ]->   (   state1   ' +
				'with   0.1   ,   state2   with   EMV2::ExposurePeriod   ,   state4   {   AboveRange   ' +
				'}   with   0.1   ,   same   state   with   others   )   ;   all   -[   memory   or   ' +
				'memory   or   memory   or   memory   or   memory   or   memory   or   memory   or   ' +
				'memory   or   memory   or   memory   or   memory   or   memory   or   memory   ]->   ' +
				'same   state   ;   properties   EMV2::StateKind   =>   Working   applies   to   state1   ' +
				';   EMV2::StateKind   =>   Working   applies   to   state2   ;   end   behavior   ;   ' +
				'error   behavior   bvr2   end   behavior   ;   type   mappings   map1   use   types   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ;   {   AboveRange   }   ->   {   ' +
				'AsymmetricApproximateValue   }   ;   {   AsymmetricExactValue   }   ->   {   ' +
				'AsymmetricItemOmission   }   ;   end   mappings   ;   type   mappings   map2   {   ' +
				'ErrorLibrary::AsymmetricExactValue   }   ->   {   ErrorLibrary::AsymmetricItemOmission   ' +
				'}   ;   end   mappings   ;   type   transformations   transformation1   use   types   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ;   all   -[   ]->   {   AsymmetricReplicatesError   ' +
				'}   ;   all   -[   {   noerror   }   ]->   {   AsymmetricApproximateValue   }   ;   {   ' +
				'noerror   }   -[   ]->   {   AboveRange   }   ;   {   noerror   }   -[   {   noerror   ' +
				'}   ]->   {   AsymmetricExactValue   }   ;   end   transformations   ;   type   ' +
				'transformations   transformation2   all   -[   ]->   {   ' +
				'ErrorLibrary::AsymmetricServiceOmission   }   ;   end   transformations   ;   **}   ;   ' +
				'end   test   ;   '
		]
	}
	
	@Test
	def void subclause() {
		assertFormatted[
			useSerializer = false
			allowUnformattedWhitespace = false
			expectation = '''
				package test2
				public
					system s1
						features
							port1: in event port;
							fg1: feature group fgt1;
						modes
							mode1: initial mode;
					end s1;
				
					system implementation s1.i
						subcomponents
							sub1: system s2.i;
						annex EMV2 {**
							use types ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
								ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
								ErrorLibrary, ErrorLibrary, ErrorLibrary;
							use type equivalence test::map1;
							use mappings test::map1;
							use behavior test::bvr1;
							
							error propagations
								memory: in propagation {AboveRange};
								memory: not in propagation {AsymmetricApproximateValue};
								memory: out propagation {AboveRange};
								processor: out propagation {AboveRange};
								fg1.fport1: in propagation {AboveRange};
								fg1.fport1: out propagation {AboveRange};
								fg1.fg2.fg3.fg4.fport2: out propagation {AboveRange};
								flows
									src1: error source fg1.fport1;
									src2: error source memory;
									src3: error source all;
									src4: error source all {AboveRange};
									src5: error source all when state1;
									src6: error source all when state4 {AboveRange};
									src7: error source all when {AboveRange};
									src8: error source all when "string";
									src9: error source all if "condition";
									src10: error source all {AboveRange} when state1;
									src11: error source all {AboveRange} if "condition";
									src12: error source all when state1 if "condition";
									src13: error source all {AboveRange} when state1 if "condition";
									sink1: error sink all;
									sink2: error sink all;
									sink3: error sink fg1.fport1;
									sink4: error sink memory;
									sink5: error sink all {AboveRange};
									sink6: error sink all if "condition";
									sink7: error sink all {AboveRange} if "condition";
									path1: error path all -> all;
									path2: error path memory -> memory;
									path3: error path fg1.fport1 -> fg1.fport1;
									path4: error path all {AboveRange} -> all {AboveRange};
									path5: error path all -> all use mappings test::map1;
									path6: error path all -> all if "condition";
									path7: error path all -> all {AboveRange} if "condition";
									path8: error path all -> all use mappings test::map1 if "condition";
							end propagations;
							
							component error behavior
								use transformations test::transformation1;
								events
									evt1: error event;
									evt2: error event;
									evt3: repair event;
									evt4: repair event when port1, port1, port1, port1, port1, port1, port1, port1, port1, port1, port1, port1,
										port1, port1, port1;
									evt5: recover event;
									evt6: recover event when port1, port1, port1, port1, port1, port1, port1, port1, port1, port1, port1, port1,
										port1, port1, port1;
									evt7: recover event if "condition";
									evt8: recover event when port1, port1, port1, port1, port1, port1, port1, port1, port1, port1, port1, port1,
										port1, port1, port1 if "condition";
								transitions
									all -[memory]-> same state;
									all -[processor]-> same state;
								propagations
									all -[]-> all {AboveRange};
									condition1: all -[(memory)]-> all;
									state1 -[(memory)]-> all;
									state4 {AboveRange} -[(memory)]-> all;
									all -[(memory)]-> memory;
									all -[(memory)]-> memory {AboveRange};
									all -[memory or memory or memory or memory or memory or memory or memory or memory or memory or memory or
										memory or memory or memory]-> memory;
								detections
									all -[]-> port1 !;
									detection1: all -[]-> port1 !;
									state1 -[]-> port1 !;
									state4 {AboveRange} -[]-> port1 !;
									all -[(memory)]-> port1 !;
									all -[]-> port1 ! (42);
									all -[]-> port1 ! ("string");
									all -[memory or memory or memory or memory or memory or memory or memory or memory or memory or memory or
										memory or memory or memory and memory and memory and memory and memory and memory and memory and memory and
										memory and memory {AboveRange} and all (memory {AboveRange}) and all - 42 (memory, memory, memory, memory,
										memory, memory) and 1 ormore (memory and memory) and 1 ormore (memory, memory, memory, memory, memory,
										memory, memory, memory, memory) and 1 orless (memory and memory) and 1 orless (memory, memory, memory,
										memory, memory, memory, memory, memory, memory, memory)]-> port1 !;
								mode mappings
									state1 in modes (mode1);
									state1 in modes (mode1);
									state1 {AboveRange} in modes (mode1);
									state1 in modes (mode1, mode1, mode1, mode1, mode1, mode1, mode1, mode1, mode1, mode1, mode1, mode1, mode1,
										mode1, mode1, mode1, mode1, mode1);
							end component;
							
							composite error behavior
								states
									[others]-> state1;
									cstate1: [others]-> state2;
									[in memory]-> state1;
									[others]-> state1 {AboveRange};
									[in memory or in memory or in memory or in memory or in memory or in memory or in memory or in memory or
										in memory or in memory or in memory and in memory and in memory and in memory and in memory and
										in memory and in memory and all (in memory {AboveRange}) and all - 42 (in memory, in memory, in memory,
										in memory, in memory, in memory) and 1 ormore (in memory) and 1 ormore (in memory, in memory, in memory,
										in memory, in memory, in memory, in memory, in memory, in memory, in memory) and 1 orless (in memory) and
										1 orless (in memory, in memory, in memory)]-> state1;
									[(in memory or in memory)]-> state1;
									[sub1.state1]-> state1;
									[sub1.state4 {AboveRange}]-> state1;
									[in memory {AboveRange}]-> state1;
									[(in memory)]-> state1;
									[sub1.sub2.state1]-> state1;
							end composite;
							
							connection error
								use transformations test::transformation1;
								src1: error source all;
								src2: error source all;
							end connection;
							
							propagation paths
								point1: propagation point;
								point2: propagation point;
								point1 -> point2;
								ppath1: point2 -> point1;
								ppath2: sub1.point3 -> sub1.sub2.point4;
							end paths;
							
							properties
								EMV2::ExposurePeriod => 1.0 applies to sink1;
								EMV2::ExposurePeriod => 1.0 applies to sink2;
						**};
					end s1.i;
				
					feature group fgt1
						features
							fport1: in out data port;
							fg2: feature group fgt2;
					end fgt1;
				
					feature group fgt2
						features
							fg3: feature group fgt3;
					end fgt2;
				
					feature group fgt3
						features
							fg4: feature group fgt4;
					end fgt3;
				
					feature group fgt4
						features
							fport2: in out data port;
					end fgt4;
				
					system s2
					end s2;
				
					system implementation s2.i
						subcomponents
							sub2: system s3;
						annex EMV2 {**
							use behavior test::bvr1;
							
							propagation paths
								point3: propagation point;
							end paths;
						**};
					end s2.i;
				
					system s3
						annex EMV2 {**
							use behavior test::bvr1;
							
							propagation paths
								point4: propagation point;
							end paths;
						**};
					end s3;
				end test2;'''
			toBeFormatted = '   package   test2   public   system   s1   features   port1   :   in   ' +
				'event   port   ;   fg1   :   feature   group   fgt1   ;   modes   mode1   :   initial   ' +
				'mode   ;   end   s1   ;   system   implementation   s1   .   i   subcomponents   sub1   ' +
				':   system   s2.i   ;   annex   EMV2   {**   use   types   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ' +
				'ErrorLibrary   ;   use   type   equivalence   test::map1   ;   use   mappings   ' +
				'test::map1   ;   use   behavior   test::bvr1   ;   error   propagations   memory   :   ' +
				'in   propagation   {   AboveRange   }   ;   memory   :   not   in   propagation   {   ' +
				'AsymmetricApproximateValue   }   ;   memory   :   out   propagation   {   AboveRange   ' +
				'}   ;   processor   :   out   propagation   {   AboveRange   }   ;   fg1   .   fport1   ' +
				':   in   propagation   {   AboveRange   }   ;   fg1   .   fport1   :   out   ' +
				'propagation   {   AboveRange   }   ;   fg1   .   fg2   .   fg3   .   fg4   .   fport2   ' +
				':   out   propagation   {   AboveRange   }   ;   flows   src1   :   error   source   ' +
				'fg1.fport1   ;   src2   :   error   source   memory   ;   src3   :   error   source   ' +
				'all   ;   src4   :   error   source   all   {   AboveRange   }   ;   src5   :   error   ' +
				'source   all   when   state1   ;   src6   :   error   source   all   when   state4   {   ' +
				'AboveRange   }   ;   src7   :   error   source   all   when   {   AboveRange   }   ;   ' +
				'src8   :   error   source   all   when   "string"   ;   src9   :   error   source   ' +
				'all   if   "condition"   ;   src10   :   error   source   all   {   AboveRange   }   ' +
				'when   state1   ;   src11   :   error   source   all   {   AboveRange   }   if   ' +
				'"condition"   ;   src12   :   error   source   all   when   state1   if   "condition"   ' +
				';   src13   :   error   source   all   {   AboveRange   }   when   state1   if   ' +
				'"condition"   ;   sink1   :   error   sink   all   ;   sink2   :   error   sink   all   ' +
				';   sink3   :   error   sink   fg1.fport1   ;   sink4   :   error   sink   memory   ;   ' +
				'sink5   :   error   sink   all   {   AboveRange   }   ;   sink6   :   error   sink   ' +
				'all   if   "condition"   ;   sink7   :   error   sink   all   {   AboveRange   }   if   ' +
				'"condition"   ;   path1   :   error   path   all   ->   all   ;   path2   :   error   ' +
				'path   memory   ->   memory   ;   path3   :   error   path   fg1.fport1   ->   ' +
				'fg1.fport1   ;   path4   :   error   path   all   {   AboveRange   }   ->   all   {   ' +
				'AboveRange   }   ;   path5   :   error   path   all   ->   all   use   mappings   ' +
				'test::map1   ;   path6   :   error   path   all   ->   all   if   "condition"   ;   ' +
				'path7   :   error   path   all   ->   all   {   AboveRange   }   if   "condition"   ;   ' +
				'path8   :   error   path   all   ->   all   use   mappings   test::map1   if   ' +
				'"condition"   ;   end   propagations   ;   component   error   behavior   use   ' +
				'transformations   test::transformation1   ;   events   evt1   :   error   event   ;  ' +
				' evt2   :   error   event   ;   evt3   :   repair   event   ;   evt4   :   repair   ' +
				'event   when   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   ' +
				'port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   ' +
				'port1   ,   port1   ;   evt5   :   recover   event   ;   evt6   :   recover   event   ' +
				'when   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ' +
				',   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ' +
				',   port1   ;   evt7   :   recover   event   if   "condition"   ;   evt8   :   recover   ' +
				'event   when   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   ' +
				'port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   ' +
				'port1   ,   port1   if   "condition"   ;   transitions   all   -[   memory   ]->   ' +
				'same   state   ;   all   -[   processor   ]->   same   state   ;   propagations   all   ' +
				'-[   ]->   all   {   AboveRange   }   ;   condition1   :   all   -[   (   memory   )   ' +
				']->   all   ;   state1   -[   (   memory   )   ]->   all   ;   state4   {   AboveRange   ' +
				'}   -[   (   memory   )   ]->   all   ;   all   -[   (   memory   )   ]->   memory   ;   ' +
				'all   -[   (   memory   )   ]->   memory   {   AboveRange   }   ;   all   -[   memory   ' +
				'or   memory   or   memory   or   memory   or   memory   or   memory   or   memory   or   ' +
				'memory   or   memory   or   memory   or   memory   or   memory   or   memory   ]->   ' +
				'memory   ;   detections   all   -[   ]->   port1   !   ;   detection1   :   all   -[   ' +
				']->   port1   !   ;   state1   -[   ]->   port1   !   ;   state4   {   AboveRange   }   ' +
				'-[   ]->   port1   !   ;   all   -[   (   memory   )   ]->   port1   !   ;   all   -[   ' +
				']->   port1   !   (   42   )   ;   all   -[   ]->   port1   !   (   "string"   )   ;   ' +
				'all   -[   memory   or   memory   or   memory   or   memory   or   memory   or   ' +
				'memory   or   memory   or   memory   or   memory   or   memory   or   memory   or   ' +
				'memory   or   memory   and   memory   and   memory   and   memory   and   memory   and   ' +
				'memory   and   memory   and   memory   and   memory   and   memory   {   AboveRange   ' +
				'}   and   all   (   memory   {   AboveRange   }   )   and   all   -   42   (   memory   ' +
				',   memory   ,   memory   ,   memory   ,   memory   ,   memory   )   and   1   ormore   ' +
				'(   memory   and   memory   )   and   1   ormore   (   memory   ,   memory   ,   ' +
				'memory   ,   memory   ,   memory   ,   memory   ,   memory   ,   memory   ,   memory   ' +
				')   and   1   orless   (   memory   and   memory   )   and   1   orless   (   memory   ' +
				',   memory   ,   memory   ,   memory   ,   memory   ,   memory   ,   memory   ,   ' +
				'memory   ,   memory   ,   memory   )   ]->   port1   !   ;   mode   mappings   state1   ' +
				'in   modes   (   mode1   )   ;   state1   in   modes   (   mode1   )   ;   state1   {   ' +
				'AboveRange   }   in   modes   (   mode1   )   ;   state1   in   modes   (   mode1   ,   ' +
				'mode1   ,   mode1   ,   mode1   ,   mode1   ,   mode1   ,   mode1   ,   mode1   ,   ' +
				'mode1   ,   mode1   ,   mode1   ,   mode1   ,   mode1   ,   mode1   ,   mode1   ,   ' +
				'mode1   ,   mode1   ,   mode1   )   ;   end   component   ;   composite   error   ' +
				'behavior   states   [   others   ]->   state1   ;   cstate1   :   [   others   ]->   ' +
				'state2   ;   [   in   memory   ]->   state1   ;   [   others   ]->   state1   {   ' +
				'AboveRange   }   ;   [   in   memory   or   in   memory   or   in   memory   or   in   ' +
				'memory   or   in   memory   or   in   memory   or   in   memory   or   in   memory   ' +
				'or   in   memory   or   in   memory   or   in   memory   and   in   memory   and   in   ' +
				'memory   and   in   memory   and   in   memory   and   in   memory   and   in   memory   ' +
				'and   all   (   in   memory   {   AboveRange   }   )   and   all   -   42   (   in   ' +
				'memory   ,   in   memory   ,   in   memory   ,   in   memory   ,   in   memory   ,   ' +
				'in   memory   )   and   1   ormore   (   in   memory   )   and   1   ormore   (   in   ' +
				'memory   ,   in   memory   ,   in   memory   ,   in   memory   ,   in   memory   ,   ' +
				'in   memory   ,   in   memory   ,   in   memory   ,   in   memory   ,   in   memory   ' +
				')   and   1   orless   (   in   memory   )   and   1   orless   (   in   memory   ,   ' +
				'in   memory   ,   in   memory   )   ]->   state1   ;   [   (   in   memory   or   in   ' +
				'memory   )   ]->   state1   ;   [   sub1   .   state1   ]->   state1   ;   [   sub1   ' +
				'.   state4   {   AboveRange   }   ]->   state1   ;   [   in   memory   {   AboveRange   ' +
				'}   ]->   state1   ;   [   (   in   memory   )   ]->   state1   ;   [   sub1   .   ' +
				'sub2   .   state1   ]->   state1   ;   end   composite   ;   connection   error   use   ' +
				'transformations   test::transformation1   ;   src1   :   error   source   all   ;   ' +
				'src2   :   error   source   all   ;   end   connection   ;   propagation   paths   ' +
				'point1   :   propagation   point   ;   point2   :   propagation   point   ;   point1   ' +
				'->   point2   ;   ppath1   :   point2   ->   point1   ;   ppath2   :   sub1   .   ' +
				'point3   ->   sub1   .   sub2   .   point4   ;   end   paths   ;   properties   ' +
				'EMV2::ExposurePeriod   =>   1.0   applies   to   sink1   ;   EMV2::ExposurePeriod   =>   ' +
				'1.0   applies   to   sink2   ;   **}   ;   end   s1.i   ;   feature   group   fgt1   ' +
				'features   fport1   :   in   out   data   port   ;   fg2   :   feature   group   fgt2   ' +
				';   end   fgt1   ;   feature   group   fgt2   features   fg3   :   feature   group   ' +
				'fgt3   ;   end   fgt2   ;   feature   group   fgt3   features   fg4   :   feature   ' +
				'group   fgt4   ;   end   fgt3   ;   feature   group   fgt4   features   fport2   :   ' +
				'in   out   data   port   ;   end   fgt4   ;   system   s2   end   s2   ;   system   ' +
				'implementation   s2   .   i   subcomponents   sub2   :   system   s3   ;   annex   ' +
				'EMV2   {**   use   behavior   test::bvr1   ;   propagation   paths   point3   :   ' +
				'propagation   point   ;   end   paths   ;   **}   ;   end   s2.i   ;   system   s3   ' +
				'annex   EMV2   {**   use   behavior   test::bvr1   ;   propagation   paths   point4   ' +
				':   propagation   point   ;   end   paths   ;   **}   ;   end   s3   ;   end   test2   ;   '
		]
	}
	
	@Test
	def void parenthesis() {
		assertFormatted[
			useSerializer = false
			allowUnformattedWhitespace = false
			expectation = '''
				package paren_test
				public
					annex EMV2 {**
						error behavior bvr1
							transitions
								transition1: all -[(memory)]-> same state;
								transition2: all -[(memory or memory)]-> same state;
								transition3: all -[(memory and memory)]-> same state;
								transition4: all -[(all (memory))]-> same state;
								transition5: all -[(1 ormore (memory))]-> same state;
								transition6: all -[(1 orless (memory))]-> same state;
						end behavior;
					**};
				
					abstract a1
						features
							f: feature;
					end a1;
				
					abstract a2 extends a1
						features
							f: refined to feature group;
					end a2;
				end paren_test;'''
			toBeFormatted = "   package   paren_test   public   annex   EMV2   {**   error   behavior   " +
				"bvr1   transitions   transition1   :   all   -[   (   memory   )   ]->   same   state   " +
				";   transition2   :   all   -[   (   memory   or   memory  )   ]->   same   state   ;   " +
				"transition3   :   all   -[   (   memory   and   memory   )   ]->   same   state   ;   " +
				"transition4   :   all   -[   (   all   (   memory   )   )   ]->   same   state   ;   " +
				"transition5   :   all   -[   (   1   ormore   (   memory   )   )   ]->   same   state   " +
				";   transition6   :   all   -[   (   1   orless   (   memory   )   )   ]->   same   " +
				"state   ;   end   behavior   ;   **}   ;   abstract   a1   features   f   :   feature   " +
				";   end   a1   ;   abstract   a2   extends   a1   features   f   :   refined   to   " +
				"feature   group   ;   end   a2   ;   end   paren_test   ;   "
		]
	}
	
	@Test
	def void properties() {
		assertFormatted[
			useSerializer = false
			allowUnformattedWhitespace = false
			expectation = '''
				package prop
				public
					abstract a1
						features
							f1: feature;
							f2: feature;
							f3: feature;
							fg1: feature group fgt1;
						modes
							m1: initial mode;
							m2: mode;
							m3: mode;
						annex EMV2 {**
							use types ErrorLibrary;
							
							error propagations
								f1: out propagation {AboveRange};
								f2: out propagation {AboveRange};
								f3: out propagation {AboveRange};
								fg1.fg2.fg3.fg4.f5: out propagation {AboveRange};
								memory: out propagation {AboveRange};
							end propagations;
							
							component error behavior
								propagations
									all -[fg1.fg2.fg3.fg4.f5]-> all;
							end component;
							
							properties
								EMV2::ExposurePeriod => 1.0 in modes (m1), 2.0 in modes (m2), 3.0 in modes (m3) applies to f1, f2, f3;
								EMV2::ExposurePeriod => 1.0 applies to fg1.fg2.fg3.fg4.f5;
								EMV2::ExposurePeriod => 1.0 applies to memory.AboveRange;
								ps1::def1 => compute (f);
								ps1::def2 => "foo";
								ps1::def3 => classifier (fgt1);
								ps1::def5 => true;
								ps1::def6 => false;
								ps1::def7 => a;
								ps1::def8 => 1;
								ps1::def9 => -1a;
								ps1::def10 => 1.0;
								ps1::def11 => -1.0a;
								ps1::def12 => 1 .. 2;
								ps1::def13 => 0 .. 10 delta 2;
								ps1::def14 => -ps1::const1 .. +ps1::const1;
								ps1::def15 => [f => 1;];
								ps1::def16 => (1, 2, 3);
						**};
					end a1;
				
					abstract implementation a1.i1
						subcomponents
							sub2: abstract a2.i1;
						annex EMV2 {**
							properties
								EMV2::ExposurePeriod => 1.0 applies to ^sub2.sub3[1].sub4[1 .. 4]@f4.AboveRange;
								ps1::def4 => reference (sub2);
						**};
					end a1.i1;
				
					abstract a2
					end a2;
				
					abstract implementation a2.i1
						subcomponents
							sub3: abstract a3.i1;
					end a2.i1;
				
					abstract a3
					end a3;
				
					abstract implementation a3.i1
						subcomponents
							sub4: abstract a4;
					end a3.i1;
				
					abstract a4
						features
							f4: feature;
						annex EMV2 {**
							use types ErrorLibrary;
							
							error propagations
								f4: out propagation {AboveRange};
							end propagations;
						**};
					end a4;
				
					feature group fgt1
						features
							fg2: feature group fgt2;
					end fgt1;
				
					feature group fgt2
						features
							fg3: feature group fgt3;
					end fgt2;
				
					feature group fgt3
						features
							fg4: feature group fgt4;
					end fgt3;
				
					feature group fgt4
						features
							f5: feature;
					end fgt4;
				
					annex EMV2 {**
						error types
							t1: type;
							t2: type;
							t3: type;
							properties
								EMV2::ExposurePeriod => 1.0 applies to t1, t2, t3;
						end types;
					**};
				end prop;'''
			toBeFormatted = '   package   prop   public   abstract   a1   features   f1   :   feature   ' +
				';   f2   :   feature   ;   f3   :   feature   ;   fg1   :   feature   group   fgt1   ;   ' +
				'modes   m1   :   initial   mode   ;   m2   :   mode   ;   m3   :   mode   ;   annex   ' +
				'EMV2   {**   use   types   ErrorLibrary   ;   error   propagations   f1   :   out   ' +
				'propagation   {   AboveRange   }   ;   f2   :   out   propagation   {   AboveRange   }   ' +
				';   f3   :   out   propagation   {   AboveRange   }   ;   fg1   .   fg2   .   fg3   .   ' +
				'fg4   .   f5   :   out   propagation   {   AboveRange   }   ;   memory   :   out   ' +
				'propagation   {   AboveRange   }   ;   end   propagations   ;   component   error   ' +
				'behavior   propagations   all   -[   fg1   .   fg2   .   fg3   .   fg4   .   f5   ]->   ' +
				'all   ;   end   component   ;   properties   EMV2::ExposurePeriod   =>   1.0   in   ' +
				'modes   (   m1   ),   2.0   in   modes   (   m2   ),   3.0   in   modes   (   m3   )   ' +
				'applies   to   f1,   f2,   f3   ;   EMV2::ExposurePeriod   =>   1.0   applies   to   ' +
				'fg1   .   fg2   .   fg3   .   fg4   .   f5   ;   EMV2::ExposurePeriod   =>   1.0   ' +
				'applies   to   memory   .   AboveRange   ;   ps1::def1   =>   compute   (   f   )   ;   ' +
				'ps1::def2   =>   "foo"   ;   ps1::def3   =>   classifier   (   fgt1   )   ;   ' +
				'ps1::def5   =>   true   ;   ps1::def6   =>   false   ;   ps1::def7   =>   a   ;   ' +
				'ps1::def8   =>   1   ;   ps1::def9   =>   -1   a   ;   ps1::def10   =>   1.0   ;   ' +
				'ps1::def11   =>   -1.0   a   ;   ps1::def12   =>   1   ..   2   ;   ps1::def13   =>   ' +
				'0   ..   10   delta   2   ;   ps1::def14   =>   -   ps1::const1   ..   +   ps1::const1   ' +
				';   ps1::def15   =>   [   f   =>   1   ;   ]   ;   ps1::def16   =>   (   1,   2,   3   ' +
				')   ;   **}   ;   end   a1   ;   abstract   implementation   a1   .   i1   ' +
				'subcomponents   sub2   :   abstract   a2.i1   ;   annex   EMV2   {**   properties   ' +
				'EMV2::ExposurePeriod   =>   1.0   applies   to   ^   sub2   .   sub3   [   1   ]   .   ' +
				'sub4   [   1   ..   4   ]   @   f4   .   AboveRange   ;   ps1::def4   =>   reference   ' +
				'(   sub2   )   ;   **}   ;   end   a1.i1   ;   abstract   a2   end   a2   ;   ' +
				'abstract   implementation   a2   .   i1   subcomponents   sub3   :   abstract   a3.i1   ' +
				';   end   a2.i1   ;   abstract   a3   end   a3   ;   abstract   implementation   ' +
				'a3   .   i1   subcomponents   sub4   :   abstract   a4   ;   end   a3.i1   ;   ' +
				'abstract   a4   features   f4   :   feature   ;   annex   EMV2   {**   use   types   ' +
				'ErrorLibrary   ;   error   propagations   f4   :   out   propagation   {   AboveRange   ' +
				'}   ;   end   propagations   ;   **}   ;   end   a4   ;   feature   group   fgt1   ' +
				'features   fg2   :   feature   group   fgt2   ;   end   fgt1   ;   feature   group   ' +
				'fgt2   features   fg3   :   feature   group   fgt3   ;   end   fgt2   ;   feature   ' +
				'group   fgt3   features   fg4   :   feature   group   fgt4   ;   end   fgt3   ;   ' +
				'feature   group   fgt4   features   f5   :   feature   ;   end   fgt4   ;   annex   ' +
				'EMV2   {**   error   types   t1   :   type   ;   t2   :   type   ;   t3   :   type   ;   ' +
				'properties   EMV2::ExposurePeriod   =>   1.0   applies   to   t1,   t2,   t3   ;   end   ' +
				'types   ;   **}   ;   end   prop   ;   '
		]
	}
	
	@Test
	def void subclauseComments() {
		assertFormatted[
			useSerializer = false
			expectation = '''
				package pkg1
				public
					abstract a1
						features
							f1: feature;
						modes
							m1: initial mode;
						annex EMV2 {**
							-- Comment
							use types ErrorLibrary;
							-- Comment
							use behavior pkg2::bvr1;
							
							-- Comment
							error propagations
								-- Comment
								memory: in propagation {AboveRange};
								-- Comment
								flows
									-- Comment
									source1: error source all;
							end propagations;
							
							-- Comment			
							component error behavior
								-- Comment
								events
									-- Comment
									event1: error event;
								-- Comment
								transitions
									-- Comment
									all -[memory]-> same state;
								-- Comment
								propagations
									-- Comment
									all -[memory]-> all;
								-- Comment
								detections
									-- Comment
									all -[]-> f1 !;
								-- Comment
								mode mappings
									-- Comment
									state1 in modes (m1);
							end component;
							
							-- Comment
							composite error behavior
								-- Comment
								states
									-- Comment
									[others]-> state1;
							end composite;
							
							-- Comment
							connection error
								-- Comment
								errorSource1: error source all;
							end connection;
							
							-- Comment
							propagation paths
								-- Comment
								point1: propagation point;
								-- Comment
								point1 -> point1;
							end paths;
							
							-- Comment
							properties
								-- Comment
								ps1::def1 => 1;
						**};
					end a1;
				end pkg1;'''
			toBeFormatted = '''
				package pkg1 public abstract a1 features f1:feature;modes m1:initial mode;annex EMV2{**
				 -- Comment
				use types ErrorLibrary;
				 -- Comment
				use behavior pkg2::bvr1;			
				 -- Comment
				error propagations
				 -- Comment
				memory:in propagation{AboveRange};
				 -- Comment
				flows
				 -- Comment
				source1:error source all;end propagations;			
				 -- Comment			
				component error behavior
				 -- Comment
				events
				 -- Comment
				event1:error event;
				 -- Comment
				transitions
				 -- Comment
				all-[memory]->same state;
				 -- Comment
				propagations
				 -- Comment
				all-[memory]->all;
				 -- Comment
				detections
				 -- Comment
				all-[]->f1!;
				 -- Comment
				mode mappings
				 -- Comment
				state1 in modes(m1);end component;			
				 -- Comment
				composite error behavior
				 -- Comment
				states
				 -- Comment
				[others]->state1;end composite;			
				 -- Comment
				connection error
				 -- Comment
				errorSource1:error source all;end connection;
				 -- Comment
				propagation paths
				 -- Comment
				point1:propagation point;
				 -- Comment
				point1->point1;end paths;			
				 -- Comment
				properties
				 -- Comment
				ps1::def1=>1;
						**};end a1;end pkg1;
			'''
		]
	}
	
	@Test
	def void libraryComments() {
		assertFormatted[
			useSerializer = false
			expectation = '''
				package pkg1
				public
					annex EMV2 {**
						-- Comment
						error types
							-- Comment
							t1: type;
							-- Comment
							ts1: type set {t1};
							-- Comment
							properties
								-- Comment
								ps1::def1 => 1;
						end types;
						
						-- Comment
						error behavior bvr1
							-- Comment
							events
								-- Comment
								event1: error event;
							-- Comment
							states
								-- Comment
								state1: initial state;
							-- Comment
							transitions
								-- Comment
								all -[memory]-> same state;
							-- Comment
							properties
								-- Comment
								ps1::def1 => 1;
						end behavior;
						
						-- Comment
						type mappings mappings1
							-- Comment
							{ErrorLibrary::AboveRange} -> {ErrorLibrary::AboveRange};
						end mappings;
						
						-- Comment
						type transformations transformations1
							-- Comment
							all -[]-> {ErrorLibrary::AboveRange};
						end transformations;
					**};
				end pkg1;'''
			toBeFormatted = '''
				package pkg1 public annex EMV2{**
				 -- Comment
				error types
				 -- Comment
				t1:type;
				 -- Comment
				ts1:type set{t1};
				 -- Comment
				properties
				 -- Comment
				ps1::def1=>1;end types;		
				 -- Comment
				error behavior bvr1
				 -- Comment
				events
				 -- Comment
				event1:error event;
				 -- Comment
				states
				 -- Comment
				state1:initial state;
				 -- Comment
				transitions
				 -- Comment
				all-[memory]->same state;
				 -- Comment
				properties
				 -- Comment
				ps1::def1=>1;end behavior;		
				 -- Comment
				type mappings mappings1
				 -- Comment
				{ErrorLibrary::AboveRange}->{ErrorLibrary::AboveRange};end mappings;		
				 -- Comment
				type transformations transformations1
				 -- Comment
				all-[]->{ErrorLibrary::AboveRange};end transformations;**};end pkg1;
			'''
		]
	}
}