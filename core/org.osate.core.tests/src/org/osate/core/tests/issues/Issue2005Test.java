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

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.core.tests.instantiation.InstanceLookup;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2005Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue2005/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testPkg1() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT_LOCATION + "pkg1.aadl");
		SystemImplementation sysImpl = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> "top.i".equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		var instance = InstantiateModel.instantiate(sysImpl);
		List<SystemOperationMode> soms = instance.getSystemOperationModes();
		assertEquals(12, soms.size());
		assertEquals(List.of("etef1a", "etef1b", "etef1c", "etef2a", "etef2b", "etef2c", "etef3a", "etef3b", "etef3c",
				"etef4a", "etef4b", "etef4c"), InstanceLookup.flowNames(instance));
		testETEF(soms, InstanceLookup.flow(instance, "etef1a"), List.of(3, 7));
		testETEF(soms, InstanceLookup.flow(instance, "etef1b"), List.of(3));
		testETEF(soms, InstanceLookup.flow(instance, "etef1c"), List.of(7));
		testETEF(soms, InstanceLookup.flow(instance, "etef2a"), List.of(8, 8));
		testETEF(soms, InstanceLookup.flow(instance, "etef2b"), List.of(4));
		testETEF(soms, InstanceLookup.flow(instance, "etef2c"), List.of(8));
		testETEF(soms, InstanceLookup.flow(instance, "etef3a"), List.of(5, 9));
		testETEF(soms, InstanceLookup.flow(instance, "etef3b"), List.of(5));
		testETEF(soms, InstanceLookup.flow(instance, "etef3c"), List.of(9));
		testETEF(soms, InstanceLookup.flow(instance, "etef4a"), List.of(6, 10));
		testETEF(soms, InstanceLookup.flow(instance, "etef4b"), List.of(6));
		testETEF(soms, InstanceLookup.flow(instance, "etef4c"), List.of(10));
	}

	@Test
	public void testPkg2() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT_LOCATION + "pkg2.aadl");
		SystemImplementation sysImpl = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> "top.i".equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		var instance = InstantiateModel.instantiate(sysImpl);
		List<SystemOperationMode> soms = instance.getSystemOperationModes();
		assertEquals(16, soms.size());
		assertEquals(1, instance.getEndToEndFlows().size());
		var etef10 = InstanceLookup.onlyFlow(instance);
		var inSOMs = etef10.getInSystemOperationModes();
		assertEquals(4, inSOMs.size());
		assertTrue(inSOMs.contains(getSOM(soms, 4)));
		assertTrue(inSOMs.contains(getSOM(soms, 8)));
		assertTrue(inSOMs.contains(getSOM(soms, 12)));
		assertTrue(inSOMs.contains(getSOM(soms, 16)));
	}

	private static void testETEF(List<SystemOperationMode> soms, EndToEndFlowInstance etef, List<Integer> somIdxs) {
		var inSOMs = etef.getInSystemOperationModes();
		assertEquals(somIdxs.size(), inSOMs.size());
		for (int i : somIdxs) {
			assertTrue(inSOMs.contains(getSOM(soms, i)));
		}
	}

	private static SystemOperationMode getSOM(List<SystemOperationMode> soms, int idx) {
		return soms.get(idx - 1);
	}
}
