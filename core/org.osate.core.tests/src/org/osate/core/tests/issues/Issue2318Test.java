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

import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.osate.core.tests.instantiation.InstanceLookup.connectionThrough;
import static org.osate.core.tests.instantiation.InstanceLookup.connectionWithReferenceCount;
import static org.osate.core.tests.instantiation.InstanceLookup.onlyConnection;
import static org.osate.core.tests.instantiation.InstanceLookup.onlyFlow;

import java.util.List;
import java.util.Set;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2318Test {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue2318/";
	private static final String FILE01 = "DirectionTests/UniqueNames/UniDirToContainer_unique.aadl";
	private static final String FILE02 = "DirectionTests/UniqueNames/BiDirToContainer_OutToIn_unique.aadl";
	private static final String FILE03 = "DirectionTests/UniqueNames/BiDirToContainer_InToOut_unique.aadl";
	private static final String FILE04 = "DirectionTests/UniqueNames/UniDirPeerToPeer_unique.aadl";
	private static final String FILE05 = "DirectionTests/UniqueNames/BiDirPeerToPeer_LtoR_unique.aadl";
	private static final String FILE06 = "DirectionTests/UniqueNames/BiDirPeerToPeer_RtoL_unique.aadl";

	private static final String FILE11 = "DirectionTests/SameNames/UniDirToContainer_same.aadl";
	private static final String FILE12 = "DirectionTests/SameNames/BiDirToContainer_OutToIn_same.aadl";
	private static final String FILE13 = "DirectionTests/SameNames/BiDirToContainer_InToOut_same.aadl";
	private static final String FILE14 = "DirectionTests/SameNames/UniDirPeerToPeer_same.aadl";
	private static final String FILE15 = "DirectionTests/SameNames/BiDirPeerToPeer_LtoR_same.aadl";
	private static final String FILE16 = "DirectionTests/SameNames/BiDirPeerToPeer_RtoL_same.aadl";

	private static final String TOPLEVEL_I = "toplevel.i";
	private static final String SUBSYSTEM_I = "subsystem.i";
	private static final String CONN = "conn";
	private static final String CONN2 = "conn2";

	private static final String FIND_FEATURE = "findTests/findFeatureInstance.aadl";

	private static final String ORIGINAL = "original";
	private static final String REFINED = "refinedd"; // yes, two d's --- "refined" is a keyword, so cannot be a name
	private static final String UNRELATED = "unrelated";

	private static final String FIND_SUBCOMPONENT = "findTests/findSubcomponentInstance.aadl";

	private static final String XORIGINAL = "X.original";
	private static final String XREFINED = "X.refinedd"; // yes, two d's --- "refined" is a keyword, so cannot be a name
	private static final String XUNRELATED = "X.unrelated";

	private static final String FIND_FLOW_SPEC = "findTests/findFlowSpecInstance.aadl";
	private static final String FIND_END_TO_END_FLOW = "findTests/findEndToEndFlowInstance.aadl";
	private static final String FIND_CONNECTION = "findTests/findConnectionInstance.aadl";

	private static final String BI_DIR_PORT_SIMPLE_SAMENAMES = "issueTests/BiDirPortSimple_samenames.aadl";
	private static final String BI_DIR_PORT_SIMPLE_UNIQUENAMES = "issueTests/BiDirPortSimple_uniquenames.aadl";
	private static final String FEATURE_GROUP_TEST = "issueTests/FeatureGroupTest.aadl";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void UniDirToContainer_unique() throws Exception {
		assertSingleConnection(FILE01);
	}

	@Test
	public void BiDirToContainer_OutToIn_unique() throws Exception {
		assertTwoConnections(FILE02, false, true);
	}

	@Test
	public void BiDirToContainer_InToOut_unique() throws Exception {
		assertTwoConnections(FILE03, true, false);
	}

	@Test
	public void UniDirPeerToPeer_unique() throws Exception {
		assertSingleConnection(FILE04);
	}

	@Test
	public void BiDirPeerToPeer_LtoR_unique() throws Exception {
		assertTwoConnections(FILE05, false, true);
	}

	@Test
	public void BiDirPeerToPeer_RtoL_unique() throws Exception {
		assertTwoConnections(FILE06, true, false);
	}

	@Test
	public void UniDirToContainer_same() throws Exception {
		assertSingleConnection(FILE11);
	}

	@Test
	public void BiDirToContainer_OutToIn_same() throws Exception {
		assertTwoConnections(FILE12, false, true);
	}

	@Test
	public void BiDirToContainer_InToOut_same() throws Exception {
		assertTwoConnections(FILE13, true, false);
	}

	@Test
	public void UniDirPeerToPeer_same() throws Exception {
		assertSingleConnection(FILE14);
	}

	@Test
	public void BiDirPeerToPeer_LtoR_same() throws Exception {
		assertTwoConnections(FILE15, false, true);
	}

	@Test
	public void BiDirPeerToPeer_RtoL_same() throws Exception {
		assertTwoConnections(FILE16, true, false);
	}

	@Test
	public void findFeature() throws Exception {
		var pkg = testHelper.parseFile(PROJECT_LOCATION + FIND_FEATURE);

		// Get the declarative features
		var originalFeature = ((SystemType) classifier(pkg, ORIGINAL)).getOwnedFeatures().get(0);
		var refinedFeature = ((SystemType) classifier(pkg, REFINED)).getOwnedFeatures().get(0);
		var unrelatedFeature = ((SystemType) classifier(pkg, UNRELATED)).getOwnedFeatures().get(0);

		// instantiate
		var instance = instantiate(pkg, TOPLEVEL_I);

		var originalInstance = instance.getComponentInstances().get(0);
		var originalFeatureInstance = originalInstance.getFeatureInstances().get(0);

		var refinedInstance = instance.getComponentInstances().get(1);
		var refinedFeatureInstance = refinedInstance.getFeatureInstances().get(0);

		var unrelatedInstance = instance.getComponentInstances().get(2);
		var unrelatedFeatureInstance = unrelatedInstance.getFeatureInstances().get(0);

		assertEquals(originalFeatureInstance, originalInstance.findFeatureInstance(originalFeature));
		assertEquals(originalFeatureInstance, originalInstance.findFeatureInstance(refinedFeature));
		assertNull(originalInstance.findFeatureInstance(unrelatedFeature));

		assertEquals(refinedFeatureInstance, refinedInstance.findFeatureInstance(originalFeature));
		assertEquals(refinedFeatureInstance, refinedInstance.findFeatureInstance(refinedFeature));
		assertNull(refinedInstance.findFeatureInstance(unrelatedFeature));

		assertNull(unrelatedInstance.findFeatureInstance(originalFeature));
		assertNull(unrelatedInstance.findFeatureInstance(refinedFeature));
		assertEquals(unrelatedFeatureInstance, unrelatedInstance.findFeatureInstance(unrelatedFeature));
	}

	@Test
	public void findSubcomponent() throws Exception {
		var pkg = testHelper.parseFile(PROJECT_LOCATION + FIND_SUBCOMPONENT);

		// Get the declarative subcomponents
		var originalSubcomponent = ((SystemImplementation) classifier(pkg, XORIGINAL)).getOwnedSubcomponents().get(0);
		var refinedSubcomponent = ((SystemImplementation) classifier(pkg, XREFINED)).getOwnedSubcomponents().get(0);
		var unrelatedSubcomponent = ((SystemImplementation) classifier(pkg, XUNRELATED)).getOwnedSubcomponents().get(0);

		// instantiate
		var instance = instantiate(pkg, TOPLEVEL_I);

		var originalInstance = instance.getComponentInstances().get(0);
		var originalSubcomponentInstance = originalInstance.getComponentInstances().get(0);

		var refinedInstance = instance.getComponentInstances().get(1);
		var refinedSubcomponentInstance = refinedInstance.getComponentInstances().get(0);

		var unrelatedInstance = instance.getComponentInstances().get(2);
		var unrelatedSubcomponentInstance = unrelatedInstance.getComponentInstances().get(0);

		assertEquals(originalSubcomponentInstance, originalInstance.findSubcomponentInstance(originalSubcomponent));
		assertEquals(originalSubcomponentInstance, originalInstance.findSubcomponentInstance(refinedSubcomponent));
		assertNull(originalInstance.findSubcomponentInstance(unrelatedSubcomponent));

		assertEquals(refinedSubcomponentInstance, refinedInstance.findSubcomponentInstance(originalSubcomponent));
		assertEquals(refinedSubcomponentInstance, refinedInstance.findSubcomponentInstance(refinedSubcomponent));
		assertNull(refinedInstance.findSubcomponentInstance(unrelatedSubcomponent));

		assertNull(unrelatedInstance.findSubcomponentInstance(originalSubcomponent));
		assertNull(unrelatedInstance.findSubcomponentInstance(refinedSubcomponent));
		assertEquals(unrelatedSubcomponentInstance, unrelatedInstance.findSubcomponentInstance(unrelatedSubcomponent));
	}

	@Test
	public void findFlowSpec() throws Exception {
		var pkg = testHelper.parseFile(PROJECT_LOCATION + FIND_FLOW_SPEC);

		// Get the declarative flow specifications
		var originalFlowSpec = ((SystemType) classifier(pkg, ORIGINAL)).getOwnedFlowSpecifications().get(0);
		var refinedFlowSpec = ((SystemType) classifier(pkg, REFINED)).getOwnedFlowSpecifications().get(0);
		var unrelatedFlowSpec = ((SystemType) classifier(pkg, UNRELATED)).getOwnedFlowSpecifications().get(0);

		// instantiate
		var instance = instantiate(pkg, TOPLEVEL_I);

		var originalInstance = instance.getComponentInstances().get(0);
		var originalFlowSpecInstance = originalInstance.getFlowSpecifications().get(0);

		var refinedInstance = instance.getComponentInstances().get(1);
		var refinedFlowSpecInstance = refinedInstance.getFlowSpecifications().get(0);

		var unrelatedInstance = instance.getComponentInstances().get(2);
		var unrelatedFlowSpecInstance = unrelatedInstance.getFlowSpecifications().get(0);

		assertEquals(originalFlowSpecInstance, originalInstance.findFlowSpecInstance(originalFlowSpec));
		assertEquals(originalFlowSpecInstance, originalInstance.findFlowSpecInstance(refinedFlowSpec));
		assertNull(originalInstance.findFlowSpecInstance(unrelatedFlowSpec)); // should be null, but due to bug is not

		assertEquals(refinedFlowSpecInstance, refinedInstance.findFlowSpecInstance(originalFlowSpec));
		assertEquals(refinedFlowSpecInstance, refinedInstance.findFlowSpecInstance(refinedFlowSpec));
		assertNull(refinedInstance.findFlowSpecInstance(unrelatedFlowSpec)); // should be null, but due to bug is not

		assertNull(unrelatedInstance.findFlowSpecInstance(originalFlowSpec)); // should be null, but due to bug is not
		assertNull(unrelatedInstance.findFlowSpecInstance(refinedFlowSpec)); // should be null, but due to bug is not
		assertEquals(unrelatedFlowSpecInstance, unrelatedInstance.findFlowSpecInstance(unrelatedFlowSpec));
	}

	@Test
	public void findEndToEndFlow() throws Exception {
		var pkg = testHelper.parseFile(PROJECT_LOCATION + FIND_END_TO_END_FLOW);

		// Get the declarative end to end flows
		var originalFlow = ((SystemImplementation) classifier(pkg, XORIGINAL)).getOwnedEndToEndFlows().get(0);
		var refinedFlow = ((SystemImplementation) classifier(pkg, XREFINED)).getOwnedEndToEndFlows().get(0);
		var unrelatedFlow = ((SystemImplementation) classifier(pkg, XUNRELATED)).getOwnedEndToEndFlows().get(0);

		// instantiate
		var instance = instantiate(pkg, TOPLEVEL_I);

		var originalInstance = instance.getComponentInstances().get(0);
		var originalFlowInstance = onlyFlow(originalInstance);

		var refinedInstance = instance.getComponentInstances().get(1);
		var refinedFlowInstance = onlyFlow(refinedInstance);

		var unrelatedInstance = instance.getComponentInstances().get(2);
		var unrelatedFlowInstance = onlyFlow(unrelatedInstance);

		assertEquals(originalFlowInstance, originalInstance.findEndToEndFlowInstance(originalFlow));
		assertEquals(originalFlowInstance, originalInstance.findEndToEndFlowInstance(refinedFlow));
		assertNull(originalInstance.findEndToEndFlowInstance(unrelatedFlow)); // should be null, but due to bug is not

		assertEquals(refinedFlowInstance, refinedInstance.findEndToEndFlowInstance(originalFlow));
		assertEquals(refinedFlowInstance, refinedInstance.findEndToEndFlowInstance(refinedFlow));
		assertNull(refinedInstance.findEndToEndFlowInstance(unrelatedFlow)); // should be null, but due to bug is not

		assertNull(unrelatedInstance.findEndToEndFlowInstance(originalFlow)); // should be null, but due to bug is not
		assertNull(unrelatedInstance.findEndToEndFlowInstance(refinedFlow)); // should be null, but due to bug is not
		assertEquals(unrelatedFlowInstance, unrelatedInstance.findEndToEndFlowInstance(unrelatedFlow));
	}

	@Test
	public void findConnection() throws Exception {
		var pkg = testHelper.parseFile(PROJECT_LOCATION + FIND_CONNECTION);

		// Get the declarative connections
		var toplevel = (SystemImplementation) classifier(pkg, TOPLEVEL_I);
		var co = toplevel.getOwnedConnections().get(0);
		var cr = toplevel.getOwnedConnections().get(1);
		var cu = toplevel.getOwnedConnections().get(2);

		var originalConnection = ((SystemImplementation) classifier(pkg, XORIGINAL)).getOwnedConnections().get(0);
		var refinedConnection = ((SystemImplementation) classifier(pkg, XREFINED)).getOwnedConnections().get(0);
		var unrelatedConnection = ((SystemImplementation) classifier(pkg, XUNRELATED)).getOwnedConnections().get(0);

		var subsystem = (ProcessImplementation) classifier(pkg, SUBSYSTEM_I);
		var conn2 = subsystem.getOwnedConnections().get(0);

		// instantiate
		var instance = instantiate(toplevel);

		var originalInstance = instance.getComponentInstances().get(0);
		var refinedInstance = instance.getComponentInstances().get(1);
		var unrelatedInstance = instance.getComponentInstances().get(2);

		/*
		 * Check that the connection instances are built correctly. Each is found by the declarations it traverses,
		 * which is what told them apart before their position did.
		 */
		assertEquals(3, instance.getConnectionInstances().size());
		var originalConnectionInstance = connectionThrough(instance, conn2, originalConnection, co);
		var refinedConnectionInstance = connectionThrough(instance, conn2, refinedConnection, cr);
		var unrelatedConnectionInstance = connectionThrough(instance, conn2, unrelatedConnection, cu);

		checkFound(originalInstance, originalConnection, originalConnectionInstance);
		checkFound(originalInstance, refinedConnection, originalConnectionInstance);
		checkNotFound(originalInstance, unrelatedConnection);

		checkFound(refinedInstance, originalConnection, refinedConnectionInstance);
		checkFound(refinedInstance, refinedConnection, refinedConnectionInstance);
		checkNotFound(refinedInstance, unrelatedConnection);

		checkNotFound(unrelatedInstance, originalConnection);
		checkNotFound(unrelatedInstance, refinedConnection);
		checkFound(unrelatedInstance, unrelatedConnection, unrelatedConnectionInstance);
	}

	@Test
	public void BiDirPortSimple_samenames() throws Exception {
		assertBothOrientations(BI_DIR_PORT_SIMPLE_SAMENAMES);
	}

	@Test
	public void BiDirPortSimple_uniquenames() throws Exception {
		assertBothOrientations(BI_DIR_PORT_SIMPLE_UNIQUENAMES);
	}

	@Test
	public void featureGroupTest() throws Exception {
		assertBothOrientations(FEATURE_GROUP_TEST);
	}

	/**
	 * The model has a single connection instance that traverses conn2 in the subsystem and conn in the top level, both
	 * in their declared direction.
	 */
	private void assertSingleConnection(String fileName) throws Exception {
		var pkg = testHelper.parseFile(PROJECT_LOCATION + fileName);

		// Get the declarative connections
		var toplevel = (SystemImplementation) classifier(pkg, TOPLEVEL_I);
		var conn = connection(toplevel.getOwnedConnections(), CONN);
		var subsystem = (ProcessImplementation) classifier(pkg, SUBSYSTEM_I);
		var conn2 = connection(subsystem.getOwnedConnections(), CONN2);

		// instantiate
		var instance = instantiate(toplevel);

		assertEquals(1, instance.getConnectionInstances().size());
		var connectionInstance = onlyConnection(instance);
		assertFalse(connectionInstance.isBidirectional());
		assertConnectionReferences(connectionInstance, conn2, false, conn, false);
	}

	/**
	 * The model has two connection instances: one that traverses only the top level connection and one that traverses
	 * both connections.
	 *
	 * @param shortReverse whether the single reference of the shorter connection instance is reversed
	 * @param longReverse whether the top level reference of the longer connection instance is reversed
	 */
	private void assertTwoConnections(String fileName, boolean shortReverse, boolean longReverse) throws Exception {
		var pkg = testHelper.parseFile(PROJECT_LOCATION + fileName);

		// Get the declarative connections
		var toplevel = (SystemImplementation) classifier(pkg, TOPLEVEL_I);
		var conn = connection(toplevel.getOwnedConnections(), CONN);
		var subsystem = (ProcessImplementation) classifier(pkg, SUBSYSTEM_I);
		var conn2 = connection(subsystem.getOwnedConnections(), CONN2);

		// instantiate
		var instance = instantiate(toplevel);

		assertEquals(2, instance.getConnectionInstances().size());

		var shortInstance = connectionWithReferenceCount(instance, 1);
		assertEquals(1, shortInstance.getConnectionReferences().size());
		var shortReference = shortInstance.getConnectionReferences().getFirst();
		assertEquals(conn, shortReference.getConnection());
		assertEquals(shortReverse, shortReference.isReverse());

		var longInstance = connectionWithReferenceCount(instance, 2);
		assertFalse(longInstance.isBidirectional());
		assertConnectionReferences(longInstance, conn2, false, conn, longReverse);
	}

	/** Both orientations of the connection exist, whichever order they were created in. */
	private void assertBothOrientations(String fileName) throws Exception {
		var pkg = testHelper.parseFile(PROJECT_LOCATION + fileName);

		// Get the declarative connections
		var toplevel = (SystemImplementation) classifier(pkg, TOPLEVEL_I);
		var conn = toplevel.getOwnedConnections().get(0);
		var subsystem = (ProcessImplementation) classifier(pkg, SUBSYSTEM_I);
		var conn2 = subsystem.getOwnedConnections().get(0);

		// instantiate
		var instance = instantiate(toplevel);

		// Check that the connection instances are built correctly
		assertEquals(2, instance.getConnectionInstances().size());
		assertEquals(Set.of(List.of(conn, conn2), List.of(conn2, conn)),
				instance.getConnectionInstances()
						.stream()
						.map(connectionInstance -> connectionInstance.getConnectionReferences()
								.stream()
								.map(ConnectionReference::getConnection)
								.toList())
						.collect(toSet()));
	}

	private static void assertConnectionReferences(ConnectionInstance connectionInstance, Connection first,
			boolean firstReverse, Connection second, boolean secondReverse) {
		assertEquals(2, connectionInstance.getConnectionReferences().size());
		var firstReference = connectionInstance.getConnectionReferences().get(0);
		var secondReference = connectionInstance.getConnectionReferences().get(1);
		assertEquals(first, firstReference.getConnection());
		assertEquals(firstReverse, firstReference.isReverse());
		assertEquals(second, secondReference.getConnection());
		assertEquals(secondReverse, secondReference.isReverse());
		assertEquals(secondReference.getSource(), firstReference.getDestination());
	}

	private static void checkFound(ComponentInstance componentInstance, Connection connection,
			ConnectionInstance expected) {
		var found = componentInstance.findConnectionInstance(connection);
		assertEquals(1, found.size());
		assertEquals(expected, found.get(0));
	}

	private static void checkNotFound(ComponentInstance componentInstance, Connection connection) {
		assertEquals(0, componentInstance.findConnectionInstance(connection).size());
	}

	private static SystemInstance instantiate(AadlPackage pkg, String implementationName) throws Exception {
		return instantiate((SystemImplementation) classifier(pkg, implementationName));
	}

	private static SystemInstance instantiate(SystemImplementation implementation) throws Exception {
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		return InstantiateModel.instantiate(implementation, errorManager);
	}

	private static Classifier classifier(AadlPackage pkg, String name) {
		return pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> name.equals(classifier.getName()))
				.findFirst()
				.orElseThrow();
	}

	private static Connection connection(List<? extends Connection> connections, String name) {
		return connections.stream().filter(connection -> name.equals(connection.getName())).findFirst().orElseThrow();
	}
}
