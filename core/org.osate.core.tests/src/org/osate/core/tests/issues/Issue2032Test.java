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

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.osate.core.tests.instantiation.InstanceLookup.connectionsInStableOrder;
import static org.osate.core.tests.instantiation.InstanceLookup.onlyConnection;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2032Test {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue2032/";

	private static final String ROOT_IMPL = "Root.impl";
	private static final String ROOT_INSTANCE = "Root_impl_Instance";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testShortAccessConnections_Cleanup() throws Exception {
		var myP = instantiateRoot("ShortAccessConnections.aadl");

		/*
		 * Issue 3044: The port of the feature group gets a connection instance of its own, in addition to the two
		 * orientations of the access connection. It is not connected inside either thread, so the feature group
		 * connection is the whole of it.
		 */
		assertEquals(3, myP.getConnectionInstances().size());
		assertEquals("t1.fg.p -> t2.fgi.p, t1.s -> t2.s.rsa, t2.s.rsa -> t1.s",
				myP.getConnectionInstances()
						.stream()
						.map(ConnectionInstance::getName)
						.sorted()
						.collect(joining(", ")));

		var portConnection = myP.getConnectionInstances()
				.stream()
				.filter(connection -> "t1.fg.p -> t2.fgi.p".equals(connection.getName()))
				.findFirst()
				.orElseThrow();
		assertEquals(1, portConnection.getConnectionReferences().size());
		assertEquals("ca", portConnection.getConnectionReferences().getFirst().getConnection().getName());

		// Each access connection instance should have 3 connection references
		var accessConnections = connectionsInStableOrder(myP).stream()
				.filter(connection -> connection != portConnection)
				.toList();
		assertOppositeReferences(accessConnections.get(0), accessConnections.get(1), 3);
	}

	@Test
	public void testJustBus_Device_FeatureGroup() throws Exception {
		assertOppositeConnections("JustBus_device_fg.aadl", 2);
	}

	@Test
	public void testJustBus_Device() throws Exception {
		assertOppositeConnections("JustBus_device.aadl", 2);
	}

	@Test
	public void testJustBus_Memory_FeatureGroup() throws Exception {
		assertOppositeConnections("JustBus_memory_fg.aadl", 2);
	}

	@Test
	public void testJustBus_Memory() throws Exception {
		assertOppositeConnections("JustBus_memory.aadl", 2);
	}

	@Test
	public void testJustBus_Processor_FeatureGroup() throws Exception {
		assertOppositeConnections("JustBus_processor_fg.aadl", 2);
	}

	@Test
	public void testJustBus_Processor() throws Exception {
		assertOppositeConnections("JustBus_processor.aadl", 2);
	}

	@Test
	public void testJustBus_System_FeatureGroup() throws Exception {
		assertOppositeConnections("JustBus_system_fg.aadl", 2);
	}

	@Test
	public void testJustBus_System() throws Exception {
		assertOppositeConnections("JustBus_system.aadl", 2);
	}

	@Test
	public void testJustData_Data_FeatureGroup() throws Exception {
		assertOppositeConnections("JustData_data_fg.aadl", 2);
	}

	@Test
	public void testJustData_Data() throws Exception {
		assertOppositeConnections("JustData_data.aadl", 2);
	}

	@Test
	public void testJustData_Process_FeatureGroup() throws Exception {
		assertOppositeConnections("JustData_process_fg.aadl", 2);
	}

	@Test
	public void testJustData_Process() throws Exception {
		assertOppositeConnections("JustData_process.aadl", 2);
	}

	@Test
	public void testJustData_Subprogram() throws Exception {
		assertOppositeConnections("JustData_subprogram.aadl", 3);
	}

	@Test
	public void testJustData_System_FeatureGroup() throws Exception {
		assertOppositeConnections("JustData_system_fg.aadl", 2);
	}

	@Test
	public void testJustData_System() throws Exception {
		assertOppositeConnections("JustData_system.aadl", 2);
	}

	@Test
	public void testJustData_ThreadGroup_FeatureGroup() throws Exception {
		assertOppositeConnections("JustData_tg_fg.aadl", 2);
	}

	@Test
	public void testJustData_ThreadGroup() throws Exception {
		assertOppositeConnections("JustData_tg.aadl", 2);
	}

	@Test
	public void testJustData_Thread_FeatureGroup() throws Exception {
		assertOppositeConnections("JustData_thread_fg.aadl", 2);
	}

	@Test
	public void testJustData_Thread() throws Exception {
		assertOppositeConnections("JustData_thread.aadl", 2);
	}

	@Test
	public void testJustSubprogram_Data_FeatureGroup() throws Exception {
		assertOppositeConnections("JustSubprogram_data_fg.aadl", 2);
	}

	@Test
	public void testJustSubprogram_Data() throws Exception {
		assertOppositeConnections("JustSubprogram_data.aadl", 2);
	}

	@Test
	public void testJustSubprogram_Device_FeatureGroup() throws Exception {
		assertOppositeConnections("JustSubprogram_device_fg.aadl", 3);
	}

	@Test
	public void testJustSubprogram_Device() throws Exception {
		assertOppositeConnections("JustSubprogram_device.aadl", 3);
	}

	@Test
	public void testJustSubprogram_Process_FeatureGroup() throws Exception {
		assertOppositeConnections("JustSubprogram_process_fg.aadl", 2);
	}

	@Test
	public void testJustSubprogram_Process() throws Exception {
		assertOppositeConnections("JustSubprogram_process.aadl", 2);
	}

	@Test
	public void testJustSubprogram_System_FeatureGroup() throws Exception {
		assertOppositeConnections("JustSubprogram_system_fg.aadl", 2);
	}

	@Test
	public void testJustSubprogram_System() throws Exception {
		assertOppositeConnections("JustSubprogram_system.aadl", 2);
	}

	@Test
	public void testJustSubprogram_ThreadGroup_FeatureGroup() throws Exception {
		assertOppositeConnections("JustSubprogram_tg_fg.aadl", 2);
	}

	@Test
	public void testJustSubprogram_ThreadGroup() throws Exception {
		assertOppositeConnections("JustSubprogram_tg.aadl", 2);
	}

	@Test
	public void testJustSubprogram_Thread_FeatureGroup() throws Exception {
		assertOppositeConnections("JustSubprogram_thread_fg.aadl", 2);
	}

	@Test
	public void testJustSubprogram_Thread() throws Exception {
		assertOppositeConnections("JustSubprogram_thread.aadl", 2);
	}

	@Test
	public void testJustSubprogramGroup_Data_FeatureGroup() throws Exception {
		assertOppositeConnections("JustSubprogramGroup_data_fg.aadl", 3);
	}

	@Test
	public void testJustSubprogramGroup_Data() throws Exception {
		assertOppositeConnections("JustSubprogramGroup_data.aadl", 3);
	}

	@Test
	public void testJustSubprogramGroup_Process_FeatureGroup() throws Exception {
		assertOppositeConnections("JustSubprogramGroup_process_fg.aadl", 2);
	}

	@Test
	public void testJustSubprogramGroup_Process() throws Exception {
		assertOppositeConnections("JustSubprogramGroup_process.aadl", 2);
	}

	@Test
	public void testJustSubprogramGroup_System_FeatureGroup() throws Exception {
		assertOppositeConnections("JustSubprogramGroup_system_fg.aadl", 2);
	}

	@Test
	public void testJustSubprogramGroup_System() throws Exception {
		assertOppositeConnections("JustSubprogramGroup_system.aadl", 2);
	}

	@Test
	public void testJustSubprogramGroup_ThreadGroup_FeatureGroup() throws Exception {
		assertOppositeConnections("JustSubprogramGroup_tg_fg.aadl", 2);
	}

	@Test
	public void testJustSubprogramGroup_ThreadGroup() throws Exception {
		assertOppositeConnections("JustSubprogramGroup_tg.aadl", 2);
	}

	@Test
	public void testJustSubprogramGroup_Thread_FeatureGroup() throws Exception {
		assertOppositeConnections("JustSubprogramGroup_thread_fg.aadl", 2);
	}

	@Test
	public void testJustSubprogramGroup_Thread() throws Exception {
		assertOppositeConnections("JustSubprogramGroup_thread.aadl", 2);
	}

	@Test
	public void testVirtualBus_Device_FeatureGroup() throws Exception {
		assertOppositeConnections("JustVBus_device_fg.aadl", 2);
	}

	@Test
	public void testVirtualBus_Device() throws Exception {
		assertOppositeConnections("JustVBus_device.aadl", 2);
	}

	@Test
	public void testVirtualBus_Processor_FeatureGroup() throws Exception {
		assertOppositeConnections("JustVBus_processor_fg.aadl", 2);
	}

	@Test
	public void testVirtualBus_Processor() throws Exception {
		assertOppositeConnections("JustVBus_processor.aadl", 2);
	}

	@Test
	public void testVirtualBus_System_FeatureGroup() throws Exception {
		assertOppositeConnections("JustVBus_system_fg.aadl", 2);
	}

	@Test
	public void testVirtualBus_System() throws Exception {
		assertOppositeConnections("JustVBus_system.aadl", 2);
	}

	@Test
	public void testVirtualBus_VirtualProcessor_FeatureGroup() throws Exception {
		assertOppositeConnections("JustVBus_vprocessor_fg.aadl", 2);
	}

	@Test
	public void testVirtualBus_VirtualProcessor() throws Exception {
		assertOppositeConnections("JustVBus_vprocessor.aadl", 2);
	}

	@Test
	public void testAbstract_System() throws Exception {
		assertOppositeConnections("JustAbstract_system.aadl", 2);
	}

	@Test
	public void testAbstract_Thread() throws Exception {
		assertOppositeConnections("JustAbstract_thread.aadl", 1);
	}

	@Test
	public void testSubprogram_Subprogram() throws Exception {
		var myP = instantiateRoot("SubprogramWithSubprogram.aadl");

		// There should be exactly 3 connection instances
		assertEquals(3, myP.getConnectionInstances().size());

		// Each connection instance should have 1 connection reference
		assertTrue(myP.getConnectionInstances()
				.stream()
				.allMatch(connection -> connection.getConnectionReferences().size() == 1));

		// None of the threads or subprograms should have connection instances
		var t1 = myP.getComponentInstances().get(0);
		assertEquals(0, t1.getConnectionInstances().size());
		assertEquals(0, t1.getComponentInstances().get(0).getConnectionInstances().size());
		assertEquals(0,
				t1.getComponentInstances().get(0).getComponentInstances().get(0).getConnectionInstances().size());
		assertEquals(0,
				t1.getComponentInstances().get(0).getComponentInstances().get(1).getConnectionInstances().size());
		assertEquals(0, myP.getComponentInstances().get(1).getConnectionInstances().size());
		assertEquals(0, myP.getComponentInstances().get(2).getConnectionInstances().size());
		assertEquals(0, myP.getComponentInstances().get(3).getConnectionInstances().size());
	}

	@Test
	public void testStopAndGo() throws Exception {
		var myP = instantiateRoot("StopAndGo.aadl");

		// There should be exactly 3 connection instances
		assertEquals(3, myP.getConnectionInstances().size());

		// One connection is the declaration 'cc' on its own
		var single = myP.getConnectionInstances()
				.stream()
				.filter(connection -> connection.getConnectionReferences().size() == 1)
				.toList();
		assertEquals(1, single.size());
		assertEquals("cc", single.get(0).getConnectionReferences().getFirst().getConnection().getName());

		// The other two are inverses of each other, whichever order they were created in
		var pair = connectionsInStableOrder(myP).stream()
				.filter(connection -> connection.getConnectionReferences().size() == 2)
				.toList();
		assertEquals(2, pair.size());
		assertOppositeReferences(pair.get(0), pair.get(1), 2);

		/* Thread t1 should have one connection */
		var t1 = myP.getComponentInstances().get(0);
		assertEquals(1, t1.getConnectionInstances().size());
		var qqReferences = onlyConnection(t1).getConnectionReferences();
		assertEquals(1, qqReferences.size());
		assertEquals("qq", qqReferences.getFirst().getConnection().getName());

		/* Thread t2 should have one connection */
		var t2 = myP.getComponentInstances().get(1);
		assertEquals(1, t2.getConnectionInstances().size());
		var aaReferences = onlyConnection(t2).getConnectionReferences();
		assertEquals(1, aaReferences.size());
		assertEquals("aa", aaReferences.getFirst().getConnection().getName());
	}

	@Test
	public void testStopAndGo_FeatureGroup() throws Exception {
		var myP = instantiateRoot("StopAndGo_fg.aadl");

		// There should be exactly 3 connection instances
		assertEquals(3, myP.getConnectionInstances().size());

		// One connection has a single reference
		assertEquals(1, myP.getConnectionInstances()
				.stream()
				.filter(connection -> connection.getConnectionReferences().size() == 1)
				.count());

		// The other two are inverses of each other, whichever order they were created in
		var pair = connectionsInStableOrder(myP).stream()
				.filter(connection -> connection.getConnectionReferences().size() == 2)
				.toList();
		assertEquals(2, pair.size());
		assertOppositeReferences(pair.get(0), pair.get(1), 2);
	}

	/**
	 * Instantiates the root implementation of the model and checks that its process subcomponent contains exactly two
	 * connection instances that follow opposite paths.
	 *
	 * @param aadlFile the model to instantiate
	 * @param expectedReferences the number of connection references of each connection instance
	 */
	private void assertOppositeConnections(String aadlFile, int expectedReferences) throws Exception {
		var myP = instantiateRoot(aadlFile);

		// There should be exactly 2 connection instances
		assertEquals(2, myP.getConnectionInstances().size());

		// The two of them, in an order derived from the model rather than from creation
		var pair = connectionsInStableOrder(myP);
		assertOppositeReferences(pair.get(0), pair.get(1), expectedReferences);
	}

	private static void assertOppositeReferences(ConnectionInstance connection1, ConnectionInstance connection2,
			int expectedReferences) {
		var references1 = connection1.getConnectionReferences();
		var references2 = connection2.getConnectionReferences();
		assertEquals(expectedReferences, references1.size());
		assertEquals(expectedReferences, references2.size());

		// The two connection instances should follow opposite paths
		for (var i = 0; i < expectedReferences; i++) {
			assertEquals(references1.get(i).getConnection(),
					references2.get(expectedReferences - 1 - i).getConnection());
		}
	}

	/** Instantiates the root implementation of the model and returns its process subcomponent. */
	private ComponentInstance instantiateRoot(String aadlFile) throws Exception {
		var pkg = testHelper.parseFile(PROJECT_LOCATION + aadlFile);
		var implementation = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> ROOT_IMPL.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		assertNotNull("System implementation \"" + ROOT_IMPL + "\" not found", implementation);

		// Instantiate system
		var instance = InstantiateModel.instantiate(implementation);
		assertEquals(ROOT_INSTANCE, instance.getName());
		return instance.getComponentInstances().get(0);
	}
}
