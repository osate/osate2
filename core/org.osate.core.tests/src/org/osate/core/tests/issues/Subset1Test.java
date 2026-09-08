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
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Subset1Test {
	private static final String AADL_TEXT = """
			package subset1
			public
			\t
			\t-- Feature Groups
			\tfeature group Sense_Whole
			      features
			\t    D1  : in data port;
			        D2  : in data port;
			        D3  : in data port;
			        D4  : in data port;
			        D5  : in data port;
			\tend Sense_Whole;
			\t\t
			\tfeature group Sense_Part_1
			\t  features
			\t    D1  : in data port;
			        D2  : in data port;
			        D3  : in data port;
			\tend Sense_Part_1;
			\t
			   feature group Sense_Part_2
			\t  features
			\t    D4  : in data port;
			        D5  : in data port;
			\tend Sense_Part_2;
			\t
			 -- containing system\t
			   system top
			   \tfeatures
			\t\tSense : feature group Sense_Whole;
			\t\tSenseout : feature group inverse of Sense_Whole;
			\tend top;
			\t
			\tsystem implementation top.i
			\t\tsubcomponents
			\t\t\tS1: system Sub1.base;
			\t\t\tS2: system Sub2.base;		\t
			\t\tconnections
			\t\t  ---  feature group on containing component split into two feature groups
			\t\t  Sub1_Sensed: feature group Sense -> S2.Sense ;
			\t\t  Sub2Out_Sensed: feature group S2.SenseOut -> Senseout;
			\t      Sub2_Sensed: feature group S1.Sense -> S2.Sense;\s
			\t\tproperties
			\t\t\tClassifier_Matching_Rule => Subset ;
			\tend top.i;
			\t
			\t
			   -- Sub Components\t
			\t
			\tsystem Sub1
			\t\tfeatures
			\t\t-- SSH Sensed
			\t\tSense : feature group inverse of Sense_Whole;      \s
			\tend Sub1;
			    system implementation Sub1.base
			    \tsubcomponents
			    \t\ts1: system subP;
			    \t\ts2: system subP;
			    \t\ts3: system subP;
			    \tconnections
			    \t\tc1: port s1.outp -> Sense.D4;
			    \t\tc2: port s2.outp -> Sense.D5;
			    \t\tc3: port s3.outp -> Sense.D3;
			    end Sub1.base;
			   \s
			    system Sub2
			    \tfeatures
			\t\tSense : feature group Sense_Part_2;      \s
			\t\tSenseOut : feature group inverse of Sense_Part_2;      \s
			\tend Sub2;
			    system implementation Sub2.base
			    \tsubcomponents
			    \t\ts1: system subP;
			    \t\ts2: system subP;
			    \tconnections
			    \t\tc1: port Sense.D4 -> s1.inp;
			    \t\tc2: port Sense.D5 -> s2.inp;
			    end Sub2.base;
			   \s
			    system subP
			    \tfeatures
			    \t\tinp: in data port;
			    \t\toutp: out data port;
			    end subP;
			\t
			end subset1;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue480() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertTrue("System implementation \"top.i\" not found",
				classifiers.stream().anyMatch(classifier -> "top.i".equals(classifier.getName())));
		SystemImplementation sysImpl = (SystemImplementation) classifiers.stream()
				.filter(classifier -> "top.i".equals(classifier.getName()))
				.findFirst()
				.get();
		var instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("top_i_Instance", instance.getName());
		var connections = instance.getConnectionInstances();
		assertTrue("In top_i_Instance: Expected 6 connections but found " + connections.size(),
				connections.size() == 6);
	}
}
