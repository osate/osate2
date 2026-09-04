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
package org.osate.aadl2.errormodel.tests.formatter;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;

import com.google.inject.Inject;

/**
 * Characterizes EMV2 formatter output for libraries, subclauses, properties, comments, and expressions.
 */
@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class FormatterTest {
	@Inject
	private FormatterTestHelper formatterTestHelper;

	@Test
	public void library() {

		this.formatterTestHelper.assertFormatted(it -> {
			it.setUseSerializer(false);
			it.setAllowUnformattedWhitespace(false);
			var expectedText = """
					package test
					public
					\tannex EMV2 {**
					\t\terror types
					\t\t\tuse types ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
					\t\t\t\tErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
					\t\t\t\tErrorLibrary, ErrorLibrary, ErrorLibrary;
					\t\t\textends ErrorLibrary, lib2, lib3 with
					\t\t\tt1: type;
					\t\t\tt2: type extends AboveRange;
					\t\t\tt3 renames type AboveRange;
					\t\t\tts1: type set {t1, AboveRange, AsymmetricApproximateValue * AboveRange * AsymmetricExactValue *
					\t\t\t\tAsymmetricItemOmission * AsymmetricOmission * AsymmetricReplicatesError * AsymmetricServiceOmission *
					\t\t\t\tAsymmetricTiming, WriteWriteRace, UndetectableValueError, BelowRange, BoundedOmissionInterval,
					\t\t\t\tBoundedValueChange, Deadlock};
					\t\t\tts2 renames type set CommonErrors;
					\t\t\tproperties
					\t\t\t\tEMV2::Severity => 1 applies to t1;
					\t\t\t\tEMV2::Severity => 2 applies to t2;
					\t\tend types;
					\t\t
					\t\terror behavior bvr1
					\t\t\tuse types ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
					\t\t\t\tErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
					\t\t\t\tErrorLibrary, ErrorLibrary, ErrorLibrary;
					\t\t\tuse transformations transformation1;
					\t\t\tevents
					\t\t\t\tevt1: error event;
					\t\t\t\tevt2: error event {AboveRange};
					\t\t\t\tevt3: error event if "condition";
					\t\t\t\tevt4: error event {AboveRange} if "condition";
					\t\t\tstates
					\t\t\t\tstate1: initial state;
					\t\t\t\tstate2: state;
					\t\t\t\tstate3: state {AsymmetricExactValue * AboveRange * AsymmetricApproximateValue};
					\t\t\t\tstate4: state {AboveRange};
					\t\t\ttransitions
					\t\t\t\tall -[memory]-> same state;
					\t\t\t\ttransition1: all -[processor]-> same state;
					\t\t\t\tstate1 -[memory]-> same state;
					\t\t\t\ttransition2: state1 -[memory]-> same state;
					\t\t\t\tstate4 {AboveRange} -[memory]-> same state;
					\t\t\t\tall -[(memory)]-> same state;
					\t\t\t\tall -[memory]-> state1;
					\t\t\t\tall -[memory]-> state4 {AboveRange};
					\t\t\t\tall -[memory]-> (state1 with 0.1, state2 with EMV2::ExposurePeriod, state4 {AboveRange} with 0.1,
					\t\t\t\t\tsame state with others);
					\t\t\t\tall -[memory or memory or memory or memory or memory or memory or memory or memory or memory or memory or
					\t\t\t\t\tmemory or memory or memory]-> same state;
					\t\t\tproperties
					\t\t\t\tEMV2::StateKind => Working applies to state1;
					\t\t\t\tEMV2::StateKind => Working applies to state2;
					\t\tend behavior;
					\t\t
					\t\terror behavior bvr2
					\t\tend behavior;
					\t\t
					\t\ttype mappings map1
					\t\t\tuse types ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
					\t\t\t\tErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
					\t\t\t\tErrorLibrary, ErrorLibrary, ErrorLibrary;
					\t\t\t{AboveRange} -> {AsymmetricApproximateValue};
					\t\t\t{AsymmetricExactValue} -> {AsymmetricItemOmission};
					\t\tend mappings;
					\t\t
					\t\ttype mappings map2
					\t\t\t{ErrorLibrary::AsymmetricExactValue} -> {ErrorLibrary::AsymmetricItemOmission};
					\t\tend mappings;
					\t\t
					\t\ttype transformations transformation1
					\t\t\tuse types ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
					\t\t\t\tErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
					\t\t\t\tErrorLibrary, ErrorLibrary, ErrorLibrary;
					\t\t\tall -[]-> {AsymmetricReplicatesError};
					\t\t\tall -[{noerror}]-> {AsymmetricApproximateValue};
					\t\t\t{noerror} -[]-> {AboveRange};
					\t\t\t{noerror} -[{noerror}]-> {AsymmetricExactValue};
					\t\tend transformations;
					\t\t
					\t\ttype transformations transformation2
					\t\t\tall -[]-> {ErrorLibrary::AsymmetricServiceOmission};
					\t\tend transformations;
					\t**};
					end test;
					""";
			it.setExpectation(expectedText.stripTrailing());
			var unformattedText = "   package   test   public   annex   EMV2   {**   error   types   use   "
					+ "types   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ;   extends   ErrorLibrary   ,   lib2   ,   lib3   "
					+ "with   t1   :   type   ;   t2   :   type   extends   AboveRange   ;   t3   renames   "
					+ "type   AboveRange   ;   ts1   :   type   set   {   t1   ,   AboveRange   ,   "
					+ "AsymmetricApproximateValue   *   AboveRange   *   AsymmetricExactValue   *   "
					+ "AsymmetricItemOmission   *   AsymmetricOmission   *   AsymmetricReplicatesError   *   "
					+ "AsymmetricServiceOmission   *   AsymmetricTiming   ,   WriteWriteRace   ,   "
					+ "UndetectableValueError   ,   BelowRange   ,   BoundedOmissionInterval   ,   "
					+ "BoundedValueChange   ,   Deadlock   }   ;   ts2   renames   type   set   CommonErrors   "
					+ ";   properties   EMV2::Severity   =>   1   applies   to   t1   ;   EMV2::Severity   =>   "
					+ "2   applies   to   t2   ;   end   types   ;   error   behavior   bvr1   use   types   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ;   use   transformations   transformation1   ;   "
					+ "events   evt1   :   error   event   ;   evt2   :   error   event   {   AboveRange   }   "
					+ ";   evt3   :   error   event   if   \"condition\"   ;   evt4   :   error   event   {   "
					+ "AboveRange   }   if   \"condition\"   ;   states   state1   :   initial   state   ;   "
					+ "state2   :   state   ;   state3   :   state   {   AsymmetricExactValue   *   "
					+ "AboveRange   *   AsymmetricApproximateValue   }   ;   state4   :   state   {   "
					+ "AboveRange   }   ;   transitions   all   -[   memory   ]->   same   state   ;   "
					+ "transition1   :   all   -[   processor   ]->   same   state   ;   state1   -[   memory   "
					+ "]->   same   state   ;   transition2   :   state1   -[   memory   ]->   same   state   "
					+ ";   state4   {   AboveRange   }   -[   memory   ]->   same   state   ;   all   -[   (   "
					+ "memory   )   ]->   same   state   ;   all   -[   memory   ]->   state1   ;   all   -[   "
					+ "memory   ]->   state4   {   AboveRange   }   ;   all   -[   memory   ]->   (   state1   "
					+ "with   0.1   ,   state2   with   EMV2::ExposurePeriod   ,   state4   {   AboveRange   "
					+ "}   with   0.1   ,   same   state   with   others   )   ;   all   -[   memory   or   "
					+ "memory   or   memory   or   memory   or   memory   or   memory   or   memory   or   "
					+ "memory   or   memory   or   memory   or   memory   or   memory   or   memory   ]->   "
					+ "same   state   ;   properties   EMV2::StateKind   =>   Working   applies   to   state1   "
					+ ";   EMV2::StateKind   =>   Working   applies   to   state2   ;   end   behavior   ;   "
					+ "error   behavior   bvr2   end   behavior   ;   type   mappings   map1   use   types   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ;   {   AboveRange   }   ->   {   "
					+ "AsymmetricApproximateValue   }   ;   {   AsymmetricExactValue   }   ->   {   "
					+ "AsymmetricItemOmission   }   ;   end   mappings   ;   type   mappings   map2   {   "
					+ "ErrorLibrary::AsymmetricExactValue   }   ->   {   ErrorLibrary::AsymmetricItemOmission   "
					+ "}   ;   end   mappings   ;   type   transformations   transformation1   use   types   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ;   all   -[   ]->   {   AsymmetricReplicatesError   "
					+ "}   ;   all   -[   {   noerror   }   ]->   {   AsymmetricApproximateValue   }   ;   {   "
					+ "noerror   }   -[   ]->   {   AboveRange   }   ;   {   noerror   }   -[   {   noerror   "
					+ "}   ]->   {   AsymmetricExactValue   }   ;   end   transformations   ;   type   "
					+ "transformations   transformation2   all   -[   ]->   {   "
					+ "ErrorLibrary::AsymmetricServiceOmission   }   ;   end   transformations   ;   **}   ;   "
					+ "end   test   ;   ";
			it.setToBeFormatted(unformattedText);
		});
	}

	@Test
	public void subclause() {

		this.formatterTestHelper.assertFormatted(it -> {
			it.setUseSerializer(false);
			it.setAllowUnformattedWhitespace(false);
			var expectedText = """
					package test2
					public
					\tsystem s1
					\t\tfeatures
					\t\t\tport1: in event port;
					\t\t\tfg1: feature group fgt1;
					\t\tmodes
					\t\t\tmode1: initial mode;
					\tend s1;

					\tsystem implementation s1.i
					\t\tsubcomponents
					\t\t\tsub1: system s2.i;
					\t\tannex EMV2 {**
					\t\t\tuse types ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
					\t\t\t\tErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary, ErrorLibrary,
					\t\t\t\tErrorLibrary, ErrorLibrary, ErrorLibrary;
					\t\t\tuse type equivalence test::map1;
					\t\t\tuse mappings test::map1;
					\t\t\tuse behavior test::bvr1;
					\t\t\t
					\t\t\terror propagations
					\t\t\t\tmemory: in propagation {AboveRange};
					\t\t\t\tmemory: not in propagation {AsymmetricApproximateValue};
					\t\t\t\tmemory: out propagation {AboveRange};
					\t\t\t\tprocessor: out propagation {AboveRange};
					\t\t\t\tfg1.fport1: in propagation {AboveRange};
					\t\t\t\tfg1.fport1: out propagation {AboveRange};
					\t\t\t\tfg1.fg2.fg3.fg4.fport2: out propagation {AboveRange};
					\t\t\t\tflows
					\t\t\t\t\tsrc1: error source fg1.fport1;
					\t\t\t\t\tsrc2: error source memory;
					\t\t\t\t\tsrc3: error source all;
					\t\t\t\t\tsrc4: error source all {AboveRange};
					\t\t\t\t\tsrc5: error source all when state1;
					\t\t\t\t\tsrc6: error source all when state4 {AboveRange};
					\t\t\t\t\tsrc7: error source all when {AboveRange};
					\t\t\t\t\tsrc8: error source all when "string";
					\t\t\t\t\tsrc9: error source all if "condition";
					\t\t\t\t\tsrc10: error source all {AboveRange} when state1;
					\t\t\t\t\tsrc11: error source all {AboveRange} if "condition";
					\t\t\t\t\tsrc12: error source all when state1 if "condition";
					\t\t\t\t\tsrc13: error source all {AboveRange} when state1 if "condition";
					\t\t\t\t\tsink1: error sink all;
					\t\t\t\t\tsink2: error sink all;
					\t\t\t\t\tsink3: error sink fg1.fport1;
					\t\t\t\t\tsink4: error sink memory;
					\t\t\t\t\tsink5: error sink all {AboveRange};
					\t\t\t\t\tsink6: error sink all if "condition";
					\t\t\t\t\tsink7: error sink all {AboveRange} if "condition";
					\t\t\t\t\tpath1: error path all -> all;
					\t\t\t\t\tpath2: error path memory -> memory;
					\t\t\t\t\tpath3: error path fg1.fport1 -> fg1.fport1;
					\t\t\t\t\tpath4: error path all {AboveRange} -> all {AboveRange};
					\t\t\t\t\tpath5: error path all -> all use mappings test::map1;
					\t\t\t\t\tpath6: error path all -> all if "condition";
					\t\t\t\t\tpath7: error path all -> all {AboveRange} if "condition";
					\t\t\t\t\tpath8: error path all -> all use mappings test::map1 if "condition";
					\t\t\tend propagations;
					\t\t\t
					\t\t\tcomponent error behavior
					\t\t\t\tuse transformations test::transformation1;
					\t\t\t\tevents
					\t\t\t\t\tevt1: error event;
					\t\t\t\t\tevt2: error event;
					\t\t\t\t\tevt3: repair event;
					\t\t\t\t\tevt4: repair event when port1, port1, port1, port1, port1, port1, port1, port1, port1, port1, port1, port1,
					\t\t\t\t\t\tport1, port1, port1;
					\t\t\t\t\tevt5: recover event;
					\t\t\t\t\tevt6: recover event when port1, port1, port1, port1, port1, port1, port1, port1, port1, port1, port1, port1,
					\t\t\t\t\t\tport1, port1, port1;
					\t\t\t\t\tevt7: recover event if "condition";
					\t\t\t\t\tevt8: recover event when port1, port1, port1, port1, port1, port1, port1, port1, port1, port1, port1, port1,
					\t\t\t\t\t\tport1, port1, port1 if "condition";
					\t\t\t\ttransitions
					\t\t\t\t\tall -[memory]-> same state;
					\t\t\t\t\tall -[processor]-> same state;
					\t\t\t\tpropagations
					\t\t\t\t\tall -[]-> all {AboveRange};
					\t\t\t\t\tcondition1: all -[(memory)]-> all;
					\t\t\t\t\tstate1 -[(memory)]-> all;
					\t\t\t\t\tstate4 {AboveRange} -[(memory)]-> all;
					\t\t\t\t\tall -[(memory)]-> memory;
					\t\t\t\t\tall -[(memory)]-> memory {AboveRange};
					\t\t\t\t\tall -[memory or memory or memory or memory or memory or memory or memory or memory or memory or memory or
					\t\t\t\t\t\tmemory or memory or memory]-> memory;
					\t\t\t\tdetections
					\t\t\t\t\tall -[]-> port1 !;
					\t\t\t\t\tdetection1: all -[]-> port1 !;
					\t\t\t\t\tstate1 -[]-> port1 !;
					\t\t\t\t\tstate4 {AboveRange} -[]-> port1 !;
					\t\t\t\t\tall -[(memory)]-> port1 !;
					\t\t\t\t\tall -[]-> port1 ! (42);
					\t\t\t\t\tall -[]-> port1 ! ("string");
					\t\t\t\t\tall -[memory or memory or memory or memory or memory or memory or memory or memory or memory or memory or
					\t\t\t\t\t\tmemory or memory or memory and memory and memory and memory and memory and memory and memory and memory and
					\t\t\t\t\t\tmemory and memory {AboveRange} and all (memory {AboveRange}) and all - 42 (memory, memory, memory, memory,
					\t\t\t\t\t\tmemory, memory) and 1 ormore (memory and memory) and 1 ormore (memory, memory, memory, memory, memory,
					\t\t\t\t\t\tmemory, memory, memory, memory) and 1 orless (memory and memory) and 1 orless (memory, memory, memory,
					\t\t\t\t\t\tmemory, memory, memory, memory, memory, memory, memory)]-> port1 !;
					\t\t\t\tmode mappings
					\t\t\t\t\tstate1 in modes (mode1);
					\t\t\t\t\tstate1 in modes (mode1);
					\t\t\t\t\tstate1 {AboveRange} in modes (mode1);
					\t\t\t\t\tstate1 in modes (mode1, mode1, mode1, mode1, mode1, mode1, mode1, mode1, mode1, mode1, mode1, mode1, mode1,
					\t\t\t\t\t\tmode1, mode1, mode1, mode1, mode1);
					\t\t\tend component;
					\t\t\t
					\t\t\tcomposite error behavior
					\t\t\t\tstates
					\t\t\t\t\t[others]-> state1;
					\t\t\t\t\tcstate1: [others]-> state2;
					\t\t\t\t\t[in memory]-> state1;
					\t\t\t\t\t[others]-> state1 {AboveRange};
					\t\t\t\t\t[in memory or in memory or in memory or in memory or in memory or in memory or in memory or in memory or
					\t\t\t\t\t\tin memory or in memory or in memory and in memory and in memory and in memory and in memory and
					\t\t\t\t\t\tin memory and in memory and all (in memory {AboveRange}) and all - 42 (in memory, in memory, in memory,
					\t\t\t\t\t\tin memory, in memory, in memory) and 1 ormore (in memory) and 1 ormore (in memory, in memory, in memory,
					\t\t\t\t\t\tin memory, in memory, in memory, in memory, in memory, in memory, in memory) and 1 orless (in memory) and
					\t\t\t\t\t\t1 orless (in memory, in memory, in memory)]-> state1;
					\t\t\t\t\t[(in memory or in memory)]-> state1;
					\t\t\t\t\t[sub1.state1]-> state1;
					\t\t\t\t\t[sub1.state4 {AboveRange}]-> state1;
					\t\t\t\t\t[in memory {AboveRange}]-> state1;
					\t\t\t\t\t[(in memory)]-> state1;
					\t\t\t\t\t[sub1.sub2.state1]-> state1;
					\t\t\tend composite;
					\t\t\t
					\t\t\tconnection error
					\t\t\t\tuse transformations test::transformation1;
					\t\t\t\tsrc1: error source all;
					\t\t\t\tsrc2: error source all;
					\t\t\tend connection;
					\t\t\t
					\t\t\tpropagation paths
					\t\t\t\tpoint1: propagation point;
					\t\t\t\tpoint2: propagation point;
					\t\t\t\tpoint1 -> point2;
					\t\t\t\tppath1: point2 -> point1;
					\t\t\t\tppath2: sub1.point3 -> sub1.sub2.point4;
					\t\t\tend paths;
					\t\t\t
					\t\t\tproperties
					\t\t\t\tEMV2::ExposurePeriod => 1.0 applies to sink1;
					\t\t\t\tEMV2::ExposurePeriod => 1.0 applies to sink2;
					\t\t**};
					\tend s1.i;

					\tfeature group fgt1
					\t\tfeatures
					\t\t\tfport1: in out data port;
					\t\t\tfg2: feature group fgt2;
					\tend fgt1;

					\tfeature group fgt2
					\t\tfeatures
					\t\t\tfg3: feature group fgt3;
					\tend fgt2;

					\tfeature group fgt3
					\t\tfeatures
					\t\t\tfg4: feature group fgt4;
					\tend fgt3;

					\tfeature group fgt4
					\t\tfeatures
					\t\t\tfport2: in out data port;
					\tend fgt4;

					\tsystem s2
					\tend s2;

					\tsystem implementation s2.i
					\t\tsubcomponents
					\t\t\tsub2: system s3;
					\t\tannex EMV2 {**
					\t\t\tuse behavior test::bvr1;
					\t\t\t
					\t\t\tpropagation paths
					\t\t\t\tpoint3: propagation point;
					\t\t\tend paths;
					\t\t**};
					\tend s2.i;

					\tsystem s3
					\t\tannex EMV2 {**
					\t\t\tuse behavior test::bvr1;
					\t\t\t
					\t\t\tpropagation paths
					\t\t\t\tpoint4: propagation point;
					\t\t\tend paths;
					\t\t**};
					\tend s3;
					end test2;
					""";
			it.setExpectation(expectedText.stripTrailing());
			var unformattedText = "   package   test2   public   system   s1   features   port1   :   in   "
					+ "event   port   ;   fg1   :   feature   group   fgt1   ;   modes   mode1   :   initial   "
					+ "mode   ;   end   s1   ;   system   implementation   s1   .   i   subcomponents   sub1   "
					+ ":   system   s2.i   ;   annex   EMV2   {**   use   types   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   ErrorLibrary   ,   "
					+ "ErrorLibrary   ;   use   type   equivalence   test::map1   ;   use   mappings   "
					+ "test::map1   ;   use   behavior   test::bvr1   ;   error   propagations   memory   :   "
					+ "in   propagation   {   AboveRange   }   ;   memory   :   not   in   propagation   {   "
					+ "AsymmetricApproximateValue   }   ;   memory   :   out   propagation   {   AboveRange   "
					+ "}   ;   processor   :   out   propagation   {   AboveRange   }   ;   fg1   .   fport1   "
					+ ":   in   propagation   {   AboveRange   }   ;   fg1   .   fport1   :   out   "
					+ "propagation   {   AboveRange   }   ;   fg1   .   fg2   .   fg3   .   fg4   .   fport2   "
					+ ":   out   propagation   {   AboveRange   }   ;   flows   src1   :   error   source   "
					+ "fg1.fport1   ;   src2   :   error   source   memory   ;   src3   :   error   source   "
					+ "all   ;   src4   :   error   source   all   {   AboveRange   }   ;   src5   :   error   "
					+ "source   all   when   state1   ;   src6   :   error   source   all   when   state4   {   "
					+ "AboveRange   }   ;   src7   :   error   source   all   when   {   AboveRange   }   ;   "
					+ "src8   :   error   source   all   when   \"string\"   ;   src9   :   error   source   "
					+ "all   if   \"condition\"   ;   src10   :   error   source   all   {   AboveRange   }   "
					+ "when   state1   ;   src11   :   error   source   all   {   AboveRange   }   if   "
					+ "\"condition\"   ;   src12   :   error   source   all   when   state1   if   \"condition\"   "
					+ ";   src13   :   error   source   all   {   AboveRange   }   when   state1   if   "
					+ "\"condition\"   ;   sink1   :   error   sink   all   ;   sink2   :   error   sink   all   "
					+ ";   sink3   :   error   sink   fg1.fport1   ;   sink4   :   error   sink   memory   ;   "
					+ "sink5   :   error   sink   all   {   AboveRange   }   ;   sink6   :   error   sink   "
					+ "all   if   \"condition\"   ;   sink7   :   error   sink   all   {   AboveRange   }   if   "
					+ "\"condition\"   ;   path1   :   error   path   all   ->   all   ;   path2   :   error   "
					+ "path   memory   ->   memory   ;   path3   :   error   path   fg1.fport1   ->   "
					+ "fg1.fport1   ;   path4   :   error   path   all   {   AboveRange   }   ->   all   {   "
					+ "AboveRange   }   ;   path5   :   error   path   all   ->   all   use   mappings   "
					+ "test::map1   ;   path6   :   error   path   all   ->   all   if   \"condition\"   ;   "
					+ "path7   :   error   path   all   ->   all   {   AboveRange   }   if   \"condition\"   ;   "
					+ "path8   :   error   path   all   ->   all   use   mappings   test::map1   if   "
					+ "\"condition\"   ;   end   propagations   ;   component   error   behavior   use   "
					+ "transformations   test::transformation1   ;   events   evt1   :   error   event   ;  "
					+ " evt2   :   error   event   ;   evt3   :   repair   event   ;   evt4   :   repair   "
					+ "event   when   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   "
					+ "port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   "
					+ "port1   ,   port1   ;   evt5   :   recover   event   ;   evt6   :   recover   event   "
					+ "when   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   "
					+ ",   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   "
					+ ",   port1   ;   evt7   :   recover   event   if   \"condition\"   ;   evt8   :   recover   "
					+ "event   when   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   "
					+ "port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   port1   ,   "
					+ "port1   ,   port1   if   \"condition\"   ;   transitions   all   -[   memory   ]->   "
					+ "same   state   ;   all   -[   processor   ]->   same   state   ;   propagations   all   "
					+ "-[   ]->   all   {   AboveRange   }   ;   condition1   :   all   -[   (   memory   )   "
					+ "]->   all   ;   state1   -[   (   memory   )   ]->   all   ;   state4   {   AboveRange   "
					+ "}   -[   (   memory   )   ]->   all   ;   all   -[   (   memory   )   ]->   memory   ;   "
					+ "all   -[   (   memory   )   ]->   memory   {   AboveRange   }   ;   all   -[   memory   "
					+ "or   memory   or   memory   or   memory   or   memory   or   memory   or   memory   or   "
					+ "memory   or   memory   or   memory   or   memory   or   memory   or   memory   ]->   "
					+ "memory   ;   detections   all   -[   ]->   port1   !   ;   detection1   :   all   -[   "
					+ "]->   port1   !   ;   state1   -[   ]->   port1   !   ;   state4   {   AboveRange   }   "
					+ "-[   ]->   port1   !   ;   all   -[   (   memory   )   ]->   port1   !   ;   all   -[   "
					+ "]->   port1   !   (   42   )   ;   all   -[   ]->   port1   !   (   \"string\"   )   ;   "
					+ "all   -[   memory   or   memory   or   memory   or   memory   or   memory   or   "
					+ "memory   or   memory   or   memory   or   memory   or   memory   or   memory   or   "
					+ "memory   or   memory   and   memory   and   memory   and   memory   and   memory   and   "
					+ "memory   and   memory   and   memory   and   memory   and   memory   {   AboveRange   "
					+ "}   and   all   (   memory   {   AboveRange   }   )   and   all   -   42   (   memory   "
					+ ",   memory   ,   memory   ,   memory   ,   memory   ,   memory   )   and   1   ormore   "
					+ "(   memory   and   memory   )   and   1   ormore   (   memory   ,   memory   ,   "
					+ "memory   ,   memory   ,   memory   ,   memory   ,   memory   ,   memory   ,   memory   "
					+ ")   and   1   orless   (   memory   and   memory   )   and   1   orless   (   memory   "
					+ ",   memory   ,   memory   ,   memory   ,   memory   ,   memory   ,   memory   ,   "
					+ "memory   ,   memory   ,   memory   )   ]->   port1   !   ;   mode   mappings   state1   "
					+ "in   modes   (   mode1   )   ;   state1   in   modes   (   mode1   )   ;   state1   {   "
					+ "AboveRange   }   in   modes   (   mode1   )   ;   state1   in   modes   (   mode1   ,   "
					+ "mode1   ,   mode1   ,   mode1   ,   mode1   ,   mode1   ,   mode1   ,   mode1   ,   "
					+ "mode1   ,   mode1   ,   mode1   ,   mode1   ,   mode1   ,   mode1   ,   mode1   ,   "
					+ "mode1   ,   mode1   ,   mode1   )   ;   end   component   ;   composite   error   "
					+ "behavior   states   [   others   ]->   state1   ;   cstate1   :   [   others   ]->   "
					+ "state2   ;   [   in   memory   ]->   state1   ;   [   others   ]->   state1   {   "
					+ "AboveRange   }   ;   [   in   memory   or   in   memory   or   in   memory   or   in   "
					+ "memory   or   in   memory   or   in   memory   or   in   memory   or   in   memory   "
					+ "or   in   memory   or   in   memory   or   in   memory   and   in   memory   and   in   "
					+ "memory   and   in   memory   and   in   memory   and   in   memory   and   in   memory   "
					+ "and   all   (   in   memory   {   AboveRange   }   )   and   all   -   42   (   in   "
					+ "memory   ,   in   memory   ,   in   memory   ,   in   memory   ,   in   memory   ,   "
					+ "in   memory   )   and   1   ormore   (   in   memory   )   and   1   ormore   (   in   "
					+ "memory   ,   in   memory   ,   in   memory   ,   in   memory   ,   in   memory   ,   "
					+ "in   memory   ,   in   memory   ,   in   memory   ,   in   memory   ,   in   memory   "
					+ ")   and   1   orless   (   in   memory   )   and   1   orless   (   in   memory   ,   "
					+ "in   memory   ,   in   memory   )   ]->   state1   ;   [   (   in   memory   or   in   "
					+ "memory   )   ]->   state1   ;   [   sub1   .   state1   ]->   state1   ;   [   sub1   "
					+ ".   state4   {   AboveRange   }   ]->   state1   ;   [   in   memory   {   AboveRange   "
					+ "}   ]->   state1   ;   [   (   in   memory   )   ]->   state1   ;   [   sub1   .   "
					+ "sub2   .   state1   ]->   state1   ;   end   composite   ;   connection   error   use   "
					+ "transformations   test::transformation1   ;   src1   :   error   source   all   ;   "
					+ "src2   :   error   source   all   ;   end   connection   ;   propagation   paths   "
					+ "point1   :   propagation   point   ;   point2   :   propagation   point   ;   point1   "
					+ "->   point2   ;   ppath1   :   point2   ->   point1   ;   ppath2   :   sub1   .   "
					+ "point3   ->   sub1   .   sub2   .   point4   ;   end   paths   ;   properties   "
					+ "EMV2::ExposurePeriod   =>   1.0   applies   to   sink1   ;   EMV2::ExposurePeriod   =>   "
					+ "1.0   applies   to   sink2   ;   **}   ;   end   s1.i   ;   feature   group   fgt1   "
					+ "features   fport1   :   in   out   data   port   ;   fg2   :   feature   group   fgt2   "
					+ ";   end   fgt1   ;   feature   group   fgt2   features   fg3   :   feature   group   "
					+ "fgt3   ;   end   fgt2   ;   feature   group   fgt3   features   fg4   :   feature   "
					+ "group   fgt4   ;   end   fgt3   ;   feature   group   fgt4   features   fport2   :   "
					+ "in   out   data   port   ;   end   fgt4   ;   system   s2   end   s2   ;   system   "
					+ "implementation   s2   .   i   subcomponents   sub2   :   system   s3   ;   annex   "
					+ "EMV2   {**   use   behavior   test::bvr1   ;   propagation   paths   point3   :   "
					+ "propagation   point   ;   end   paths   ;   **}   ;   end   s2.i   ;   system   s3   "
					+ "annex   EMV2   {**   use   behavior   test::bvr1   ;   propagation   paths   point4   "
					+ ":   propagation   point   ;   end   paths   ;   **}   ;   end   s3   ;   end   test2   ;   ";
			it.setToBeFormatted(unformattedText);
		});
	}

	@Test
	public void parenthesis() {

		this.formatterTestHelper.assertFormatted(it -> {
			it.setUseSerializer(false);
			it.setAllowUnformattedWhitespace(false);
			var expectedText = """
					package paren_test
					public
					\tannex EMV2 {**
					\t\terror behavior bvr1
					\t\t\ttransitions
					\t\t\t\ttransition1: all -[(memory)]-> same state;
					\t\t\t\ttransition2: all -[(memory or memory)]-> same state;
					\t\t\t\ttransition3: all -[(memory and memory)]-> same state;
					\t\t\t\ttransition4: all -[(all (memory))]-> same state;
					\t\t\t\ttransition5: all -[(1 ormore (memory))]-> same state;
					\t\t\t\ttransition6: all -[(1 orless (memory))]-> same state;
					\t\tend behavior;
					\t**};

					\tabstract a1
					\t\tfeatures
					\t\t\tf: feature;
					\tend a1;

					\tabstract a2 extends a1
					\t\tfeatures
					\t\t\tf: refined to feature group;
					\tend a2;
					end paren_test;
					""";
			it.setExpectation(expectedText.stripTrailing());
			var unformattedText = "   package   paren_test   public   annex   EMV2   {**   error   behavior   "
					+ "bvr1   transitions   transition1   :   all   -[   (   memory   )   ]->   same   state   "
					+ ";   transition2   :   all   -[   (   memory   or   memory  )   ]->   same   state   ;   "
					+ "transition3   :   all   -[   (   memory   and   memory   )   ]->   same   state   ;   "
					+ "transition4   :   all   -[   (   all   (   memory   )   )   ]->   same   state   ;   "
					+ "transition5   :   all   -[   (   1   ormore   (   memory   )   )   ]->   same   state   "
					+ ";   transition6   :   all   -[   (   1   orless   (   memory   )   )   ]->   same   "
					+ "state   ;   end   behavior   ;   **}   ;   abstract   a1   features   f   :   feature   "
					+ ";   end   a1   ;   abstract   a2   extends   a1   features   f   :   refined   to   "
					+ "feature   group   ;   end   a2   ;   end   paren_test   ;   ";
			it.setToBeFormatted(unformattedText);
		});
	}

	@Test
	public void properties() {

		this.formatterTestHelper.assertFormatted(it -> {
			it.setUseSerializer(false);
			it.setAllowUnformattedWhitespace(false);
			var expectedText = """
					package prop
					public
					\tabstract a1
					\t\tfeatures
					\t\t\tf1: feature;
					\t\t\tf2: feature;
					\t\t\tf3: feature;
					\t\t\tfg1: feature group fgt1;
					\t\tmodes
					\t\t\tm1: initial mode;
					\t\t\tm2: mode;
					\t\t\tm3: mode;
					\t\tannex EMV2 {**
					\t\t\tuse types ErrorLibrary;
					\t\t\t
					\t\t\terror propagations
					\t\t\t\tf1: out propagation {AboveRange};
					\t\t\t\tf2: out propagation {AboveRange};
					\t\t\t\tf3: out propagation {AboveRange};
					\t\t\t\tfg1.fg2.fg3.fg4.f5: out propagation {AboveRange};
					\t\t\t\tmemory: out propagation {AboveRange};
					\t\t\tend propagations;
					\t\t\t
					\t\t\tcomponent error behavior
					\t\t\t\tpropagations
					\t\t\t\t\tall -[fg1.fg2.fg3.fg4.f5]-> all;
					\t\t\tend component;
					\t\t\t
					\t\t\tproperties
					\t\t\t\tEMV2::ExposurePeriod => 1.0 in modes (m1), 2.0 in modes (m2), 3.0 in modes (m3) applies to f1, f2, f3;
					\t\t\t\tEMV2::ExposurePeriod => 1.0 applies to fg1.fg2.fg3.fg4.f5;
					\t\t\t\tEMV2::ExposurePeriod => 1.0 applies to memory.AboveRange;
					\t\t\t\tps1::def1 => compute (f);
					\t\t\t\tps1::def2 => "foo";
					\t\t\t\tps1::def3 => classifier (fgt1);
					\t\t\t\tps1::def5 => true;
					\t\t\t\tps1::def6 => false;
					\t\t\t\tps1::def7 => a;
					\t\t\t\tps1::def8 => 1;
					\t\t\t\tps1::def9 => -1a;
					\t\t\t\tps1::def10 => 1.0;
					\t\t\t\tps1::def11 => -1.0a;
					\t\t\t\tps1::def12 => 1 .. 2;
					\t\t\t\tps1::def13 => 0 .. 10 delta 2;
					\t\t\t\tps1::def14 => -ps1::const1 .. +ps1::const1;
					\t\t\t\tps1::def15 => [f => 1;];
					\t\t\t\tps1::def16 => (1, 2, 3);
					\t\t**};
					\tend a1;

					\tabstract implementation a1.i1
					\t\tsubcomponents
					\t\t\tsub2: abstract a2.i1;
					\t\tannex EMV2 {**
					\t\t\tproperties
					\t\t\t\tEMV2::ExposurePeriod => 1.0 applies to ^sub2.sub3[1].sub4[1 .. 4]@f4.AboveRange;
					\t\t\t\tps1::def4 => reference (sub2);
					\t\t**};
					\tend a1.i1;

					\tabstract a2
					\tend a2;

					\tabstract implementation a2.i1
					\t\tsubcomponents
					\t\t\tsub3: abstract a3.i1;
					\tend a2.i1;

					\tabstract a3
					\tend a3;

					\tabstract implementation a3.i1
					\t\tsubcomponents
					\t\t\tsub4: abstract a4;
					\tend a3.i1;

					\tabstract a4
					\t\tfeatures
					\t\t\tf4: feature;
					\t\tannex EMV2 {**
					\t\t\tuse types ErrorLibrary;
					\t\t\t
					\t\t\terror propagations
					\t\t\t\tf4: out propagation {AboveRange};
					\t\t\tend propagations;
					\t\t**};
					\tend a4;

					\tfeature group fgt1
					\t\tfeatures
					\t\t\tfg2: feature group fgt2;
					\tend fgt1;

					\tfeature group fgt2
					\t\tfeatures
					\t\t\tfg3: feature group fgt3;
					\tend fgt2;

					\tfeature group fgt3
					\t\tfeatures
					\t\t\tfg4: feature group fgt4;
					\tend fgt3;

					\tfeature group fgt4
					\t\tfeatures
					\t\t\tf5: feature;
					\tend fgt4;

					\tannex EMV2 {**
					\t\terror types
					\t\t\tt1: type;
					\t\t\tt2: type;
					\t\t\tt3: type;
					\t\t\tproperties
					\t\t\t\tEMV2::ExposurePeriod => 1.0 applies to t1, t2, t3;
					\t\tend types;
					\t**};
					end prop;
					""";
			it.setExpectation(expectedText.stripTrailing());
			var unformattedText = "   package   prop   public   abstract   a1   features   f1   :   feature   "
					+ ";   f2   :   feature   ;   f3   :   feature   ;   fg1   :   feature   group   fgt1   ;   "
					+ "modes   m1   :   initial   mode   ;   m2   :   mode   ;   m3   :   mode   ;   annex   "
					+ "EMV2   {**   use   types   ErrorLibrary   ;   error   propagations   f1   :   out   "
					+ "propagation   {   AboveRange   }   ;   f2   :   out   propagation   {   AboveRange   }   "
					+ ";   f3   :   out   propagation   {   AboveRange   }   ;   fg1   .   fg2   .   fg3   .   "
					+ "fg4   .   f5   :   out   propagation   {   AboveRange   }   ;   memory   :   out   "
					+ "propagation   {   AboveRange   }   ;   end   propagations   ;   component   error   "
					+ "behavior   propagations   all   -[   fg1   .   fg2   .   fg3   .   fg4   .   f5   ]->   "
					+ "all   ;   end   component   ;   properties   EMV2::ExposurePeriod   =>   1.0   in   "
					+ "modes   (   m1   ),   2.0   in   modes   (   m2   ),   3.0   in   modes   (   m3   )   "
					+ "applies   to   f1,   f2,   f3   ;   EMV2::ExposurePeriod   =>   1.0   applies   to   "
					+ "fg1   .   fg2   .   fg3   .   fg4   .   f5   ;   EMV2::ExposurePeriod   =>   1.0   "
					+ "applies   to   memory   .   AboveRange   ;   ps1::def1   =>   compute   (   f   )   ;   "
					+ "ps1::def2   =>   \"foo\"   ;   ps1::def3   =>   classifier   (   fgt1   )   ;   "
					+ "ps1::def5   =>   true   ;   ps1::def6   =>   false   ;   ps1::def7   =>   a   ;   "
					+ "ps1::def8   =>   1   ;   ps1::def9   =>   -1   a   ;   ps1::def10   =>   1.0   ;   "
					+ "ps1::def11   =>   -1.0   a   ;   ps1::def12   =>   1   ..   2   ;   ps1::def13   =>   "
					+ "0   ..   10   delta   2   ;   ps1::def14   =>   -   ps1::const1   ..   +   ps1::const1   "
					+ ";   ps1::def15   =>   [   f   =>   1   ;   ]   ;   ps1::def16   =>   (   1,   2,   3   "
					+ ")   ;   **}   ;   end   a1   ;   abstract   implementation   a1   .   i1   "
					+ "subcomponents   sub2   :   abstract   a2.i1   ;   annex   EMV2   {**   properties   "
					+ "EMV2::ExposurePeriod   =>   1.0   applies   to   ^   sub2   .   sub3   [   1   ]   .   "
					+ "sub4   [   1   ..   4   ]   @   f4   .   AboveRange   ;   ps1::def4   =>   reference   "
					+ "(   sub2   )   ;   **}   ;   end   a1.i1   ;   abstract   a2   end   a2   ;   "
					+ "abstract   implementation   a2   .   i1   subcomponents   sub3   :   abstract   a3.i1   "
					+ ";   end   a2.i1   ;   abstract   a3   end   a3   ;   abstract   implementation   "
					+ "a3   .   i1   subcomponents   sub4   :   abstract   a4   ;   end   a3.i1   ;   "
					+ "abstract   a4   features   f4   :   feature   ;   annex   EMV2   {**   use   types   "
					+ "ErrorLibrary   ;   error   propagations   f4   :   out   propagation   {   AboveRange   "
					+ "}   ;   end   propagations   ;   **}   ;   end   a4   ;   feature   group   fgt1   "
					+ "features   fg2   :   feature   group   fgt2   ;   end   fgt1   ;   feature   group   "
					+ "fgt2   features   fg3   :   feature   group   fgt3   ;   end   fgt2   ;   feature   "
					+ "group   fgt3   features   fg4   :   feature   group   fgt4   ;   end   fgt3   ;   "
					+ "feature   group   fgt4   features   f5   :   feature   ;   end   fgt4   ;   annex   "
					+ "EMV2   {**   error   types   t1   :   type   ;   t2   :   type   ;   t3   :   type   ;   "
					+ "properties   EMV2::ExposurePeriod   =>   1.0   applies   to   t1,   t2,   t3   ;   end   "
					+ "types   ;   **}   ;   end   prop   ;   ";
			it.setToBeFormatted(unformattedText);
		});
	}

	@Test
	public void subclauseComments() {

		this.formatterTestHelper.assertFormatted(it -> {
			it.setUseSerializer(false);
			var expectedText = """
					package pkg1
					public
					\tabstract a1
					\t\tfeatures
					\t\t\tf1: feature;
					\t\tmodes
					\t\t\tm1: initial mode;
					\t\tannex EMV2 {**
					\t\t\t-- Comment
					\t\t\tuse types ErrorLibrary;
					\t\t\t-- Comment
					\t\t\tuse behavior pkg2::bvr1;
					\t\t\t
					\t\t\t-- Comment
					\t\t\terror propagations
					\t\t\t\t-- Comment
					\t\t\t\tmemory: in propagation {AboveRange};
					\t\t\t\t-- Comment
					\t\t\t\tflows
					\t\t\t\t\t-- Comment
					\t\t\t\t\tsource1: error source all;
					\t\t\tend propagations;
					\t\t\t
					\t\t\t-- Comment\t\t\t
					\t\t\tcomponent error behavior
					\t\t\t\t-- Comment
					\t\t\t\tevents
					\t\t\t\t\t-- Comment
					\t\t\t\t\tevent1: error event;
					\t\t\t\t-- Comment
					\t\t\t\ttransitions
					\t\t\t\t\t-- Comment
					\t\t\t\t\tall -[memory]-> same state;
					\t\t\t\t-- Comment
					\t\t\t\tpropagations
					\t\t\t\t\t-- Comment
					\t\t\t\t\tall -[memory]-> all;
					\t\t\t\t-- Comment
					\t\t\t\tdetections
					\t\t\t\t\t-- Comment
					\t\t\t\t\tall -[]-> f1 !;
					\t\t\t\t-- Comment
					\t\t\t\tmode mappings
					\t\t\t\t\t-- Comment
					\t\t\t\t\tstate1 in modes (m1);
					\t\t\tend component;
					\t\t\t
					\t\t\t-- Comment
					\t\t\tcomposite error behavior
					\t\t\t\t-- Comment
					\t\t\t\tstates
					\t\t\t\t\t-- Comment
					\t\t\t\t\t[others]-> state1;
					\t\t\tend composite;
					\t\t\t
					\t\t\t-- Comment
					\t\t\tconnection error
					\t\t\t\t-- Comment
					\t\t\t\terrorSource1: error source all;
					\t\t\tend connection;
					\t\t\t
					\t\t\t-- Comment
					\t\t\tpropagation paths
					\t\t\t\t-- Comment
					\t\t\t\tpoint1: propagation point;
					\t\t\t\t-- Comment
					\t\t\t\tpoint1 -> point1;
					\t\t\tend paths;
					\t\t\t
					\t\t\t-- Comment
					\t\t\tproperties
					\t\t\t\t-- Comment
					\t\t\t\tps1::def1 => 1;
					\t\t**};
					\tend a1;
					end pkg1;
					""";
			it.setExpectation(expectedText.stripTrailing());
			var unformattedText = """
					package pkg1 public abstract a1 features f1:feature;modes m1:initial mode;annex EMV2{**
					\s-- Comment
					use types ErrorLibrary;
					\s-- Comment
					use behavior pkg2::bvr1;\t\t\t
					\s-- Comment
					error propagations
					\s-- Comment
					memory:in propagation{AboveRange};
					\s-- Comment
					flows
					\s-- Comment
					source1:error source all;end propagations;\t\t\t
					\s-- Comment\t\t\t
					component error behavior
					\s-- Comment
					events
					\s-- Comment
					event1:error event;
					\s-- Comment
					transitions
					\s-- Comment
					all-[memory]->same state;
					\s-- Comment
					propagations
					\s-- Comment
					all-[memory]->all;
					\s-- Comment
					detections
					\s-- Comment
					all-[]->f1!;
					\s-- Comment
					mode mappings
					\s-- Comment
					state1 in modes(m1);end component;\t\t\t
					\s-- Comment
					composite error behavior
					\s-- Comment
					states
					\s-- Comment
					[others]->state1;end composite;\t\t\t
					\s-- Comment
					connection error
					\s-- Comment
					errorSource1:error source all;end connection;
					\s-- Comment
					propagation paths
					\s-- Comment
					point1:propagation point;
					\s-- Comment
					point1->point1;end paths;\t\t\t
					\s-- Comment
					properties
					\s-- Comment
					ps1::def1=>1;
					\t\t**};end a1;end pkg1;
					""";
			it.setToBeFormatted(unformattedText);
		});
	}

	@Test
	public void libraryComments() {

		this.formatterTestHelper.assertFormatted(it -> {
			it.setUseSerializer(false);
			var expectedText = """
					package pkg1
					public
					\tannex EMV2 {**
					\t\t-- Comment
					\t\terror types
					\t\t\t-- Comment
					\t\t\tt1: type;
					\t\t\t-- Comment
					\t\t\tts1: type set {t1};
					\t\t\t-- Comment
					\t\t\tproperties
					\t\t\t\t-- Comment
					\t\t\t\tps1::def1 => 1;
					\t\tend types;
					\t\t
					\t\t-- Comment
					\t\terror behavior bvr1
					\t\t\t-- Comment
					\t\t\tevents
					\t\t\t\t-- Comment
					\t\t\t\tevent1: error event;
					\t\t\t-- Comment
					\t\t\tstates
					\t\t\t\t-- Comment
					\t\t\t\tstate1: initial state;
					\t\t\t-- Comment
					\t\t\ttransitions
					\t\t\t\t-- Comment
					\t\t\t\tall -[memory]-> same state;
					\t\t\t-- Comment
					\t\t\tproperties
					\t\t\t\t-- Comment
					\t\t\t\tps1::def1 => 1;
					\t\tend behavior;
					\t\t
					\t\t-- Comment
					\t\ttype mappings mappings1
					\t\t\t-- Comment
					\t\t\t{ErrorLibrary::AboveRange} -> {ErrorLibrary::AboveRange};
					\t\tend mappings;
					\t\t
					\t\t-- Comment
					\t\ttype transformations transformations1
					\t\t\t-- Comment
					\t\t\tall -[]-> {ErrorLibrary::AboveRange};
					\t\tend transformations;
					\t**};
					end pkg1;
					""";
			it.setExpectation(expectedText.stripTrailing());
			var unformattedText = """
					package pkg1 public annex EMV2{**
					\s-- Comment
					error types
					\s-- Comment
					t1:type;
					\s-- Comment
					ts1:type set{t1};
					\s-- Comment
					properties
					\s-- Comment
					ps1::def1=>1;end types;\t\t
					\s-- Comment
					error behavior bvr1
					\s-- Comment
					events
					\s-- Comment
					event1:error event;
					\s-- Comment
					states
					\s-- Comment
					state1:initial state;
					\s-- Comment
					transitions
					\s-- Comment
					all-[memory]->same state;
					\s-- Comment
					properties
					\s-- Comment
					ps1::def1=>1;end behavior;\t\t
					\s-- Comment
					type mappings mappings1
					\s-- Comment
					{ErrorLibrary::AboveRange}->{ErrorLibrary::AboveRange};end mappings;\t\t
					\s-- Comment
					type transformations transformations1
					\s-- Comment
					all-[]->{ErrorLibrary::AboveRange};end transformations;**};end pkg1;
					""";
			it.setToBeFormatted(unformattedText);
		});
	}
}
