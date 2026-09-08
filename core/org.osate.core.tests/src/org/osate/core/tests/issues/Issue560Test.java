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
public class Issue560Test extends XtextTest {
	private static final String AADL_TEXT = """
			package issue560
			public

			\tsystem top
			\t\tprototypes
			\t\t\tfgproto1: feature group fgt1;
			\t\tfeatures
			\t\t\tfg1: feature group fgt1;
			\t\t\tfg4: feature group fgproto1;
			\tend top;

			\tsystem implementation top.i
			\t\tsubcomponents
			\t\t\tasub1: abstract a2.i;
			\t\tconnections
			\t\t\tconn5: feature group fg4.fg3 -> asub1.fg2;
			\tend top.i;

			\tabstract a2
			\t\tfeatures
			\t\t\tfg2: feature group;
			\tend a2;

			\tabstract implementation a2.i
			\tend a2.i;

			\tfeature group fgt1
			\t\tfeatures
			\t\t\tfg3: feature group;
			\tend fgt1;
			end issue560;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue560() throws Exception {
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
		assertTrue("In top_i_instance: Expected 1 connection but found " + connections.size(),
				connections.size() == 1);
	}
}
