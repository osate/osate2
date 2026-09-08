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
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2057Test {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue2057/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testPortToPort() throws Exception {
		assertAllReferenceOneDeclaredConnection("port_to_port.aadl", "xxx");
	}

	@Test
	public void testDataToDataPort() throws Exception {
		assertAllReferenceOneDeclaredConnection("data_to_data_port.aadl", "yyy");
	}

	@Test
	public void testDataToAccess() throws Exception {
		assertAllReferenceOneDeclaredConnection("data_to_access.aadl", "ccc");
	}

	@Test
	public void testDataPortToData() throws Exception {
		assertAllReferenceOneDeclaredConnection("data_port_to_data.aadl", "yyy");
	}

	@Test
	public void testAccessToData() throws Exception {
		assertAllReferenceOneDeclaredConnection("access_to_data.aadl", "ccc");
	}

	private void assertAllReferenceOneDeclaredConnection(String file, String connectionName) throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT_LOCATION + file);
		SystemInstance system = getSystemInstance(pkg, "top.impl", "top_impl_Instance");
		var conns = system.getComponentInstances().get(0).getConnectionInstances();
		assertEquals(16, conns.size());

		ProcessImplementation processImpl = (ProcessImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> "process1.impl".equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		var declarativeConnection = processImpl.getOwnedConnections()
				.stream()
				.filter(connection -> connectionName.equals(connection.getName()))
				.findFirst()
				.orElse(null);

		for (int i = 0; i < conns.size(); i++) {
			var connRef = conns.get(i).getConnectionReferences();
			assertEquals(1, connRef.size());
			assertEquals(declarativeConnection, connRef.get(0).getConnection());
		}
	}

	private static SystemInstance getSystemInstance(AadlPackage pkg, String systemImplName,
			String expectedInstanceName) throws Exception {
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertTrue("System implementation \"" + systemImplName + "\" not found",
				classifiers.stream().anyMatch(classifier -> systemImplName.equals(classifier.getName())));
		SystemImplementation sysImpl = (SystemImplementation) classifiers.stream()
				.filter(classifier -> systemImplName.equals(classifier.getName()))
				.findFirst()
				.get();
		SystemInstance instance = InstantiateModel.instantiate(sysImpl);
		assertEquals(expectedInstanceName, instance.getName());
		return instance;
	}
}
