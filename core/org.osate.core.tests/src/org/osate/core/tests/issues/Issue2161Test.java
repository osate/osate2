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
import static org.junit.Assert.assertNotNull;
import static org.osate.core.tests.instantiation.InstanceLookup.connectionsInStableOrder;
import static org.osate.core.tests.instantiation.InstanceLookup.onlyConnection;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2161Test {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue2161/";

	private static final String ROOT_IMPL = "root.impl";

	private static final String ROOT_BIDIRECTIONAL = "Root.bidirectional";
	private static final String ROOT_FROM_SHARED = "Root.fromSharedComponent";
	private static final String ROOT_TO_SHARED = "Root.toSharedComponent";

	private static final String ROOT_BIDIRECTIONAL_INSTANCE = "Root_bidirectional_Instance";
	private static final String ROOT_FROM_SHARED_INSTANCE = "Root_fromSharedComponent_Instance";
	private static final String ROOT_TO_SHARED_INSTANCE = "Root_toSharedComponent_Instance";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testIssue222() throws Exception {
		var pkg = testHelper.parseFile(PROJECT_LOCATION + "test2.aadl");
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		var instance = instantiate(classifiers, ROOT_IMPL);

		// There should be no connection instances
		assertEquals(0, instance.getConnectionInstances().size());
	}

	@Test
	public void testSharedData_toData_asPeers() throws Exception {
		testOppositePaths("SharedData_to_Data_Peers.aadl", 1, false);
	}

	@Test
	public void testSharedData_toSubprogram_asPeers() throws Exception {
		testOppositePaths("SharedData_to_Subprogram_Peers.aadl", 1, false);
	}

	@Test
	public void testSharedSubprogram_toData_asPeers() throws Exception {
		testOppositePaths("SharedSubprogram_to_Data_Peers.aadl", 1, false);
	}

	@Test
	public void testSharedSubprogram_toSubprogram_asPeers() throws Exception {
		testOppositePaths("SharedSubprogram_to_Subprogram_Peers.aadl", 1, false);
	}

	@Test
	public void testSharedData_toData_inData() throws Exception {
		testOppositePaths("SharedData_to_Data_Nested_in_Data.aadl", 2, false);
	}

	@Test
	public void testSharedData_toSubprogram_inData() throws Exception {
		testOppositePaths("SharedData_to_Subprogram_Nested_in_Data.aadl", 2, false);
	}

	@Test
	public void testSharedSubprogram_toData_inData() throws Exception {
		testOppositePaths("SharedSubprogram_to_Data_Nested_in_Data.aadl", 2, false);
	}

	@Test
	public void testSharedSubprogram_toSubprogram_inData() throws Exception {
		testOppositePaths("SharedSubprogram_to_Subprogram_Nested_in_Data.aadl", 2, false);
	}

	@Test
	public void testSharedData_toData_inThread() throws Exception {
		testOppositePaths("SharedData_to_Data_Nested_in_Thread.aadl", 2, true);
	}

	@Test
	public void testSharedData_toSubprogram_inThread() throws Exception {
		testOppositePaths("SharedData_to_Subprogram_Nested_in_Thread.aadl", 2, true);
	}

	@Test
	public void testSharedSubprogram_toData_inThread() throws Exception {
		testOppositePaths("SharedSubprogram_to_Data_Nested_in_Thread.aadl", 2, true);
	}

	@Test
	public void testSharedSubprogram_toSubprogram_inThread() throws Exception {
		testOppositePaths("SharedSubprogram_to_Subprogram_Nested_in_Thread.aadl", 2, true);
	}

	/**
	 * Instantiates the bidirectional, the "from shared" and the "to shared" root implementation of the model and checks
	 * that the connection instances follow opposite paths through the shared component.
	 *
	 * @param aadlFile the model to instantiate
	 * @param expectedReferences the number of connection references of each connection instance
	 * @param nestedInThread whether the connections are declared in the process subcomponent rather than in the root
	 */
	private void testOppositePaths(String aadlFile, int expectedReferences, boolean nestedInThread) throws Exception {
		var pkg = testHelper.parseFile(PROJECT_LOCATION + aadlFile);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();

		instantiateBidirectional(classifiers, expectedReferences, nestedInThread);
		var fromShared = instantiateConnectionReferences(classifiers, ROOT_FROM_SHARED, ROOT_FROM_SHARED_INSTANCE,
				expectedReferences, nestedInThread);
		var toShared = instantiateConnectionReferences(classifiers, ROOT_TO_SHARED, ROOT_TO_SHARED_INSTANCE,
				expectedReferences, nestedInThread);

		// The connection instances from "to shared" and "from shared" should follow opposite paths
		for (var i = 0; i < expectedReferences; i++) {
			assertEquals(fromShared.get(i).getConnection().getName(),
					toShared.get(expectedReferences - 1 - i).getConnection().getName());
		}
	}

	private void instantiateBidirectional(EList<Classifier> classifiers, int expectedReferences,
			boolean nestedInThread) throws Exception {
		var instance = instantiate(classifiers, ROOT_BIDIRECTIONAL);
		assertEquals(ROOT_BIDIRECTIONAL_INSTANCE, instance.getName());
		var container = nestedInThread ? instance.getComponentInstances().get(0) : instance;

		// There should be exactly 2 connection instances
		assertEquals(2, container.getConnectionInstances().size());

		// The two of them, in an order derived from the model rather than from creation
		var pair = connectionsInStableOrder(container);
		var references1 = pair.get(0).getConnectionReferences();
		var references2 = pair.get(1).getConnectionReferences();
		assertEquals(expectedReferences, references1.size());
		assertEquals(expectedReferences, references2.size());

		// The two connection instances should follow opposite paths
		for (var i = 0; i < expectedReferences; i++) {
			assertEquals(references1.get(i).getConnection(),
					references2.get(expectedReferences - 1 - i).getConnection());
		}
	}

	private List<ConnectionReference> instantiateConnectionReferences(EList<Classifier> classifiers,
			String implementationName, String expectedInstanceName, int expectedReferences, boolean nestedInThread)
			throws Exception {
		var instance = instantiate(classifiers, implementationName);
		assertEquals(expectedInstanceName, instance.getName());
		var container = nestedInThread ? instance.getComponentInstances().get(0) : instance;

		// There should be exactly 1 connection instance
		assertEquals(1, container.getConnectionInstances().size());

		var references = onlyConnection(container).getConnectionReferences();
		assertEquals(expectedReferences, references.size());
		return references;
	}

	private static ComponentInstance instantiate(EList<Classifier> classifiers, String implementationName)
			throws Exception {
		var implementation = (SystemImplementation) classifiers.stream()
				.filter(classifier -> implementationName.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		assertNotNull("System implementation \"" + implementationName + "\" not found", implementation);
		return InstantiateModel.instantiate(implementation);
	}
}
