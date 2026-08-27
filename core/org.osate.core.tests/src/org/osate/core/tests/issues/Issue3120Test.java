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

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemType;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;

import com.google.inject.Inject;
import com.google.inject.Injector;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3120Test {
	private static final String PATH = "org.osate.core.tests/models/issue3120/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private Injector injector;

	@Test
	public void concurrentIndexLookupsKeepTheirOwnReferenceText() throws Exception {
		var pkg = testHelper.parseFile(PATH + "Issue3120.aadl", PATH + "Other.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemType) pkg.getOwnedPublicSection().getOwnedClassifiers().get(0);
		var portD = findPort(system, "d");
		var portE = findPort(system, "e");
		var linkingService = injector.getInstance(CoordinatedPropertiesLinkingService.class);
		var reference = Aadl2Package.eINSTANCE.getDataPort_DataFeatureClassifier();

		try (var executor = Executors.newFixedThreadPool(2)) {
			var resultD = executor.submit(() -> linkingService.getIndexedObject(portD, reference, "Other::D"));
			var resultE = executor.submit(() -> linkingService.getIndexedObject(portE, reference, "Other::E"));

			assertEquals("D", ((NamedElement) resultD.get(10, TimeUnit.SECONDS)).getName());
			assertEquals("E", ((NamedElement) resultE.get(10, TimeUnit.SECONDS)).getName());
		}
	}

	private static DataPort findPort(SystemType system, String name) {
		return (DataPort) system.getOwnedFeatures()
				.stream()
				.filter(feature -> feature.getName().equals(name))
				.findFirst()
				.orElseThrow();
	}

	public static class CoordinatedPropertiesLinkingService extends PropertiesLinkingService {
		private final CyclicBarrier barrier = new CyclicBarrier(2);

		@Override
		public String getCrossRefNodeAsString(INode node) throws IllegalNodeException {
			try {
				barrier.await(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new AssertionError(e);
			} catch (BrokenBarrierException | TimeoutException e) {
				throw new AssertionError(e);
			}
			return super.getCrossRefNodeAsString(node);
		}
	}
}
