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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3017Test extends XtextTest {
	private static final String PATH = "org.osate.core.tests/models/issue3017/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void unresolvedExpansionEndpointsAreRejected() throws Exception {
		var pkg = testHelper.parseFile(PATH + "Issue3017.aadl");
		validationHelper.assertNoIssues(pkg);
		var impl = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("Top.i"))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		SystemInstance instance = InstantiateModel.instantiate(impl, errorManager);

		assertNotNull(instance);
		var messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors();
		assertTrue(messages.stream().anyMatch(m -> m.message.equals("Connection source not found")));
		assertTrue(messages.stream().anyMatch(m -> m.message.equals("Connection destination not found")));

		Set<ConnectionInstance> containedConnections = Collections.newSetFromMap(new IdentityHashMap<>());
		containedConnections.addAll(instance.getAllConnectionInstances());
		assertTrue(containedConnections.stream().allMatch(c -> c.getSource() != null && c.getDestination() != null));

		assertInverseConnectionsAreContained(instance, containedConnections);
		instance.eAllContents().forEachRemaining(object -> {
			if (object instanceof ConnectionInstanceEnd end) {
				assertInverseConnectionsAreContained(end, containedConnections);
			}
		});
	}

	private static void assertInverseConnectionsAreContained(ConnectionInstanceEnd end,
			Set<ConnectionInstance> containedConnections) {
		assertTrue(containedConnections.containsAll(end.getSrcConnectionInstances()));
		assertTrue(containedConnections.containsAll(end.getDstConnectionInstances()));
	}
}
