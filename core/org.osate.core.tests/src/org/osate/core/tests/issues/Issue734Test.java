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
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue734Test extends XtextTest {
	private static final String AADL_TEXT = """
			package pkg1
			public
			\tsystem s1
			\tend s1;
			\t
			\tsystem implementation s1.i1
			\t\tsubcomponents
			\t\t\tsub1: device dev1;
			\t\t\tsub2: device dev2;
			\t\t\tsub3: device dev3;
			\t\t\tsub4: system s2.i1;
			\t\tconnections
			\t\t\tconn1: feature group sub1.f1 -> sub4.f4;
			\t\t\tconn2: feature group sub2.f2 -> sub4.f5;
			\t\t\tconn3: feature group sub4.f6 -> sub3.f3;
			\t\tflows
			\t\t\tflow1: end to end flow sub2.flow4 -> conn2 -> sub4.flow7 -> conn3 -> sub3.flow5;
			\t\t\tflow2: end to end flow sub1.flow3 -> conn1 -> sub4.flow6 -> conn3 -> sub3.flow5;
			\tend s1.i1;
			\t
			\tdevice dev1
			\t\tfeatures
			\t\t\tf1: feature group fgt1;
			\t\tflows
			\t\t\tflow3: flow source f1;
			\tend dev1;
			\t
			\tdevice dev2
			\t\tfeatures
			\t\t\tf2: feature group fgt2;
			\t\tflows
			\t\t\tflow4: flow source f2;
			\tend dev2;
			\t
			\tdevice dev3
			\t\tfeatures
			\t\t\tf3: feature group fgt3;
			\t\tflows
			\t\t\tflow5: flow sink f3;
			\tend dev3;
			\t
			\tsystem s2
			\t\tfeatures
			\t\t\tf4: feature group inverse of fgt1;
			\t\t\tf5: feature group inverse of fgt2;
			\t\t\tf6: feature group inverse of fgt3;
			\t\tflows
			\t\t\tflow6: flow path f4.f19 -> f6.f21;
			\t\t\tflow7: flow path f5.f20 -> f6.f21;
			\tend s2;
			\t
			\tsystem implementation s2.i1
			\t\tsubcomponents
			\t\t\tsub5: process p1.i1;
			\t\tconnections
			\t\t\tconn4: port f4.f19 -> sub5.f7;
			\t\t\tconn5: port f5.f20 -> sub5.f8;
			\t\t\tconn6: port sub5.f9 -> f6.f21;
			\t\tflows
			\t\t\tflow6: flow path f4.f19 -> conn4 -> sub5.flow8 -> conn6 -> f6.f21;
			\t\t\tflow7: flow path f5.f20 -> conn5 -> sub5.flow9 -> conn6 -> f6.f21;
			\tend s2.i1;
			\t
			\tprocess p1
			\t\tfeatures
			\t\t\tf7: in data port;
			\t\t\tf8: in data port;
			\t\t\tf9: out data port;
			\t\tflows
			\t\t\tflow8: flow path f7 -> f9;
			\t\t\tflow9: flow path f8 -> f9;
			\tend p1;
			\t
			\tprocess implementation p1.i1
			\t\tsubcomponents
			\t\t\tsub6: thread t1;
			\t\t\tsub7: thread t2;
			\t\t\tsub8: thread t3;
			\t\tconnections
			\t\t\tconn7: port sub7.f15 -> sub8.f16;
			\t\t\tconn8: port sub6.f12 -> sub7.f14;
			\t\t\tconn9: port sub6.f13 -> sub8.f17;
			\t\t\tconn10: port f7 -> sub6.f10;
			\t\t\tconn11: port f8 -> sub6.f11;
			\t\t\tconn12: port sub8.f18 -> f9;
			\t\tflows
			\t\t\tflow8: flow path f7 -> conn10 -> sub6.flow10 -> conn8 -> sub7.flow12 -> conn7 -> sub8.flow13 -> conn12 -> f9;
			\t\t\tflow9: flow path f8 -> conn11 -> sub6.flow11 -> conn9 -> sub8.flow14 -> conn12 -> f9;
			\tend p1.i1;
			\t
			\tthread t1
			\t\tfeatures
			\t\t\tf10: in data port;
			\t\t\tf11: in data port;
			\t\t\tf12: out data port;
			\t\t\tf13: out data port;
			\t\tflows
			\t\t\tflow10: flow path f10 -> f12;
			\t\t\tflow11: flow path f11 -> f13;
			\tend t1;
			\t
			\tthread t2
			\t\tfeatures
			\t\t\tf14: in data port;
			\t\t\tf15: out data port;
			\t\tflows
			\t\t\tflow12: flow path f14 -> f15;
			\tend t2;
			\t
			\tthread t3
			\t\tfeatures
			\t\t\tf16: in data port;
			\t\t\tf17: in data port;
			\t\t\tf18: out data port;
			\t\tflows
			\t\t\tflow13: flow path f16 -> f18;
			\t\t\tflow14: flow path f17 -> f18;
			\tend t3;
			\t
			\tfeature group fgt1
			\t\tfeatures
			\t\t\tf19: out data port;
			\tend fgt1;
			\t
			\tfeature group fgt2
			\t\tfeatures
			\t\t\tf20: out data port;
			\tend fgt2;
			\t
			\tfeature group fgt3
			\t\tfeatures
			\t\t\tf21: in data port;
			\tend fgt3;
			end pkg1;\t
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue734() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertEquals("pkg1", pkg.getName());

		SystemImplementation declared = (SystemImplementation) classifiers.get(1);
		assertEquals("s1.i1", declared.getName());
		SystemImplementation sysImpl = (SystemImplementation) classifiers.stream()
				.filter(classifier -> "s1.i1".equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		var instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("s1_i1_Instance", instance.getName());
		assertEquals(3, instance.getConnectionInstances().size());
	}
}
