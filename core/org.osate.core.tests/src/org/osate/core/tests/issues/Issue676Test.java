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
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue676Test {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue676/";

	private static final String ISSUE643 = "issue643.aadl";

	private static final String ISSUE676 = "issue676.aadl";

	private static final String TOP_I = "top.i";

	private static final String INSTANCE_NAME1 = "top_i_Instance";

	private static final String E2E = "e2e";

	private static final String S_I = "s.i";

	private static final String INSTANCE_NAME2 = "s_i_Instance";

	private static final String CONN1 = "conn1";

	private static final String CONN2 = "conn2";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testIssue643() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT_LOCATION + ISSUE643);
		SystemImplementation sysImpl = systemImplementation(pkg, TOP_I);
		AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		var instance = InstantiateModel.instantiate(sysImpl, errorManager);
		assertEquals(INSTANCE_NAME1, instance.getName());
		var endToEndFlows = sysImpl.getAllEndToEndFlows();
		assertEquals(1, endToEndFlows.size());
		assertEquals(E2E, endToEndFlows.get(0).getName());
	}

	@Test
	public void testIssue676() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT_LOCATION + ISSUE676);
		SystemImplementation sysImpl = systemImplementation(pkg, S_I);
		var conn1 = sysImpl.getOwnedConnections()
				.stream()
				.filter(connection -> CONN1.equals(connection.getName()))
				.findFirst()
				.orElse(null);
		var conn2 = sysImpl.getOwnedConnections()
				.stream()
				.filter(connection -> CONN2.equals(connection.getName()))
				.findFirst()
				.orElse(null);
		AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		var instance = InstantiateModel.instantiate(sysImpl, errorManager);
		assertEquals(INSTANCE_NAME2, instance.getName());
		List<ConnectionInstance> connections = instance.getConnectionInstances();
		assertEquals(2, connections.size());

		/* Each connection instance must reference exactly one of the two declared connections. */
		assertEquals(Set.of(List.of(conn1), List.of(conn2)),
				connections.stream()
						.map(connection -> connection.getConnectionReferences()
								.stream()
								.map(ConnectionReference::getConnection)
								.toList())
						.collect(Collectors.toSet()));
		assertTrue(connections.stream().noneMatch(ConnectionInstance::isBidirectional));
	}

	private static SystemImplementation systemImplementation(AadlPackage pkg, String name) {
		return (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> name.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
	}
}
