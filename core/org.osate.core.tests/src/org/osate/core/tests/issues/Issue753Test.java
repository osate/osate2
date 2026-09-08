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
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue753Test extends XtextTest {
	private static final String AADL_TEXT = """
			package Issue753
			public\s
			   with Base_Types;
			  \s
			   annex resolute {**
			     print_conns(sys : component) <=
			       ** "the component " sys " has the following connections" **
			         forall(c : connections(sys)) . print(c)
			      \s
			     print(c : connection) <=
			       ** c **
			         true
			   **};
			  \s
			 system conn_test
			 	features
			 		feat0 : in data port Base_Types::Integer;
			 		feat1 : out data port Base_Types::Integer;
			 end conn_test;
			\s
			 system implementation conn_test.i
			 	subcomponents
			 		feat_data : data Base_Types::Integer;
			 		subme: system sub;
			 	connections
			 		conn0 : port feat0 -> feat_data;
			 		conn1: port feat_data -> feat1;
			 		conn2: port subme.outp -> feat1;
			 		conn3: port subme.outp -> feat_data;
			    annex resolute {**
			    	prove print_conns(this)
			    **};
			 end conn_test.i;
			\s
			 system sub
			 	features
			 		outp: out data port Base_Types::Integer;
			 end sub;
			\t
			end Issue753;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue753() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertTrue("System implementation \"conn_test.i\" not found",
				classifiers.stream().anyMatch(classifier -> "conn_test.i".equals(classifier.getName())));
		SystemImplementation sysImpl = (SystemImplementation) classifiers.stream()
				.filter(classifier -> "conn_test.i".equals(classifier.getName()))
				.findFirst()
				.get();
		var instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("conn_test_i_Instance", instance.getName());
		var connections = instance.getConnectionInstances();
		assertTrue("In conn_test_i_Instance: Expected 4 connections but found " + connections.size(),
				connections.size() == 4);
	}
}
