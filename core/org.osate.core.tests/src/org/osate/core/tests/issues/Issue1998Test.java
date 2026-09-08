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
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1998Test {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/issue1998/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void test1() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT_LOCATION + "Issue1998_1.aadl");
		SystemInstance system = getSystemInstance(pkg, "s.impl", "s_impl_Instance");
		assertTrue("There should be exactly one connection instance", system.getConnectionInstances().size() == 1);
	}

	@Test
	public void test2() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT_LOCATION + "Issue1998_2.aadl");
		SystemInstance system = getSystemInstance(pkg, "s.impl", "s_impl_Instance");
		assertTrue("There should be exactly one connection instance", system.getConnectionInstances().size() == 1);
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
