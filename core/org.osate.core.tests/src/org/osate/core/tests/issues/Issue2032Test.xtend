package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2032Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue2032/"
	
	val static ROOT_IMPL = "Root.impl"
	val static ROOT_INSTANCE = "Root_impl_Instance"
		
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void testJustBus_Device_FeatureGroup() {
		test2("JustBus_device_fg.aadl")
	}

	@Test
	def void testJustBus_Device() {
		test2("JustBus_device.aadl")
	}

	@Test
	def void testJustBus_Memory_FeatureGroup() {
		test2("JustBus_memory_fg.aadl")
	}

	@Test
	def void testJustBus_Memory() {
		test2("JustBus_memory.aadl")
	}

	@Test
	def void testJustBus_Processor_FeatureGroup() {
		test2("JustBus_processor_fg.aadl")
	}

	@Test
	def void testJustBus_Processor() {
		test2("JustBus_processor.aadl")
	}

	@Test
	def void testJustBus_System_FeatureGroup() {
		test2("JustBus_system_fg.aadl")
	}

	@Test
	def void testJustBus_System() {
		test2("JustBus_system.aadl")
	}

	@Test
	def void testJustData_Data_FeatureGroup() {
		test2("JustData_data_fg.aadl")
	}

	@Test
	def void testJustData_Data() {
		test2("JustData_data.aadl")
	}

	@Test
	def void testJustData_Process_FeatureGroup() {
		test2("JustData_process_fg.aadl")
	}

	@Test
	def void testJustData_Process() {
		test2("JustData_process.aadl")
	}

	@Test
	def void testJustData_Subprogram() {
		test0("JustData_subprogram.aadl")
	}

	@Test
	def void testJustData_System_FeatureGroup() {
		test2("JustData_system_fg.aadl")
	}

	@Test
	def void testJustData_System() {
		test2("JustData_system.aadl")
	}

	@Test
	def void testJustData_ThreadGroup_FeatureGroup() {
		test2("JustData_tg_fg.aadl")
	}

	@Test
	def void testJustData_ThreadGroup() {
		test2("JustData_tg.aadl")
	}

	@Test
	def void testJustData_Thread_FeatureGroup() {
		test2("JustData_thread_fg.aadl")
	}

	@Test
	def void testJustData_Thread() {
		test2("JustData_thread.aadl")
	}

	@Test
	def void testJustSubprogram_Data_FeatureGroup() {
		test2("JustSubprogram_data_fg.aadl")	
	}

	@Test
	def void testJustSubprogram_Data() {
		test2("JustSubprogram_data.aadl")	
	}

	@Test
	def void testJustSubprogram_Device_FeatureGroup() {
		test3("JustSubprogram_device_fg.aadl")	
	}

	@Test
	def void testJustSubprogram_Device() {
		test3("JustSubprogram_device.aadl")	
	}

	@Test
	def void testJustSubprogram_Process_FeatureGroup() {
		test2("JustSubprogram_process_fg.aadl")	
	}

	@Test
	def void testJustSubprogram_Process() {
		test2("JustSubprogram_process.aadl")	
	}

	@Test
	def void testJustSubprogram_System_FeatureGroup() {
		test2("JustSubprogram_system_fg.aadl")	
	}

	@Test
	def void testJustSubprogram_System() {
		test2("JustSubprogram_system.aadl")	
	}

	@Test
	def void testJustSubprogram_ThreadGroup_FeatureGroup() {
		test2("JustSubprogram_tg_fg.aadl")	
	}

	@Test
	def void testJustSubprogram_ThreadGroup() {
		test2("JustSubprogram_tg.aadl")	
	}

	@Test
	def void testJustSubprogram_Thread_FeatureGroup() {
		test2("JustSubprogram_thread_fg.aadl")	
	}

	@Test
	def void testJustSubprogram_Thread() {
		test2("JustSubprogram_thread.aadl")	
	}
	
	@Test
	def void testJustSubprogramGroup_Data_FeatureGroup() {
		test3("JustSubprogramGroup_data_fg.aadl")
	}
	
	@Test
	def void testJustSubprogramGroup_Data() {
		test3("JustSubprogramGroup_data.aadl")
	}
	
	@Test
	def void testJustSubprogramGroup_Process_FeatureGroup() {
		test2("JustSubprogramGroup_process_fg.aadl")
	}
	
	@Test
	def void testJustSubprogramGroup_Process() {
		test2("JustSubprogramGroup_process.aadl")
	}
	
	@Test
	def void testJustSubprogramGroup_System_FeatureGroup() {
		test2("JustSubprogramGroup_system_fg.aadl")
	}
	
	@Test
	def void testJustSubprogramGroup_System() {
		test2("JustSubprogramGroup_system.aadl")
	}
	
	@Test
	def void testJustSubprogramGroup_ThreadGroup_FeatureGroup() {
		test2("JustSubprogramGroup_tg_fg.aadl")
	}
	
	@Test
	def void testJustSubprogramGroup_ThreadGroup() {
		test2("JustSubprogramGroup_tg.aadl")
	}
	
	@Test
	def void testJustSubprogramGroup_Thread_FeatureGroup() {
		test2("JustSubprogramGroup_thread_fg.aadl")
	}
	
	@Test
	def void testJustSubprogramGroup_Thread() {
		test2("JustSubprogramGroup_thread.aadl")
	}
	
	@Test
	def void testVirtualBus_Device_FeatureGroup() {
		test2("JustVBus_device_fg.aadl")
	}
	
	@Test
	def void testVirtualBus_Device() {
		test2("JustVBus_device.aadl")
	}
	
	@Test
	def void testVirtualBus_Processor_FeatureGroup() {
		test2("JustVBus_processor_fg.aadl")
	}
	
	@Test
	def void testVirtualBus_Processor() {
		test2("JustVBus_processor.aadl")
	}
	
	@Test
	def void testVirtualBus_System_FeatureGroup() {
		test2("JustVBus_system_fg.aadl")
	}
	
	@Test
	def void testVirtualBus_System() {
		test2("JustVBus_system.aadl")
	}
	
	@Test
	def void testVirtualBus_VirtualProcessor_FeatureGroup() {
		test2("JustVBus_vprocessor_fg.aadl")
	}
	
	@Test
	def void testVirtualBus_VirtualProcessor() {
		test2("JustVBus_vprocessor.aadl")
	}
		
	@Test
	def void testAbstract_System() {
		test2("JustAbstract_system.aadl");
	}
		
	@Test
	def void testAbstract_Thread() {
		test1("JustAbstract_thread.aadl");
	}
		
	@Test
	def void testSubprogram_Subprogram() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "SubprogramWithSubprogram.aadl")

		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + ROOT_IMPL + '" not found', cls.exists[name == ROOT_IMPL])

		// Instantiate system
		val sysImpl = cls.findFirst[name == ROOT_IMPL] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_INSTANCE, instance.name)
		
		// There should be exactly 3 connection instances
		val myP = instance.componentInstances.get(0)
		assertEquals(3, myP.connectionInstances.size)
		
		val ci1 = myP.connectionInstances.get(0)
		val ci2 = myP.connectionInstances.get(1)
		val ci3 = myP.connectionInstances.get(2)
		
		// Each connection instance should have 1 connection reference
		val connRefs1 = ci1.connectionReferences
		val connRefs2 = ci2.connectionReferences
		val connRefs3 = ci3.connectionReferences
		assertEquals(1, connRefs1.size)
		assertEquals(1, connRefs2.size)
		assertEquals(1, connRefs3.size)
		
		
		// None of the threads or subprograms should have connection instances
		val t1 = myP.componentInstances.get(0)
		assertEquals(0, t1.connectionInstances.size)
		assertEquals(0, t1.componentInstances.get(0).connectionInstances.size)
		assertEquals(0, t1.componentInstances.get(0).componentInstances.get(0).connectionInstances.size)
		assertEquals(0, t1.componentInstances.get(0).componentInstances.get(1).connectionInstances.size)
		assertEquals(0, myP.componentInstances.get(1).connectionInstances.size)
		assertEquals(0, myP.componentInstances.get(2).connectionInstances.size)
		assertEquals(0, myP.componentInstances.get(3).connectionInstances.size)
	}
	
	@Test
	def void testStopAndGo() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "StopAndGo.aadl")

		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + ROOT_IMPL + '" not found', cls.exists[name == ROOT_IMPL])

		// Instantiate system
		val sysImpl = cls.findFirst[name == ROOT_IMPL] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_INSTANCE, instance.name)
		
		// There should be exactly 3 connection instances
		val myP = instance.componentInstances.get(0)
		assertEquals(3, myP.connectionInstances.size)
		
		val ci1 = myP.connectionInstances.get(0)
		val ci2 = myP.connectionInstances.get(1)
		val ci3 = myP.connectionInstances.get(2)

		// The first connection should just 'cc'
		val connRefs1 = ci1.connectionReferences
		assertEquals(1, connRefs1.size)
		assertEquals("cc", connRefs1.get(0).connection.name)
		
		// The second and third connections should be inverses.
		val connRefs2 = ci2.connectionReferences
		val connRefs3 = ci3.connectionReferences
		assertEquals(2, connRefs2.size)
		assertEquals(2, connRefs3.size)
		assertEquals(connRefs2.get(0).connection, connRefs3.get(1).connection)
		assertEquals(connRefs3.get(1).connection, connRefs2.get(0).connection)
		
		/* Thread t1 should have one connection */
		val t1 = myP.componentInstances.get(0)
		assertEquals(1, t1.connectionInstances.size)
		val qqRefs = t1.connectionInstances.get(0).connectionReferences
		assertEquals(1, qqRefs.size)
		assertEquals("qq", qqRefs.get(0).connection.name)
		
		/* Thread t2 should have one connection */
		val t2 = myP.componentInstances.get(1)
		assertEquals(1, t2.connectionInstances.size)
		val aaRefs = t2.connectionInstances.get(0).connectionReferences
		assertEquals(1, aaRefs.size)
		assertEquals("aa", aaRefs.get(0).connection.name)
	}
	
	@Test
	def void testStopAndGo_FeatureGroup() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "StopAndGo_fg.aadl")

		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + ROOT_IMPL + '" not found', cls.exists[name == ROOT_IMPL])

		// Instantiate system
		val sysImpl = cls.findFirst[name == ROOT_IMPL] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_INSTANCE, instance.name)
		
		// There should be exactly 4 connection instances
		val myP = instance.componentInstances.get(0)
		assertEquals(4, myP.connectionInstances.size)
		
		val ci1 = myP.connectionInstances.get(0)
		val ci2 = myP.connectionInstances.get(1)
		val ci3 = myP.connectionInstances.get(2)
		val ci4 = myP.connectionInstances.get(3)

		// The first two should have 1 connection and be the same
		val connRefs1 = ci1.connectionReferences
		val connRefs2 = ci2.connectionReferences
		assertEquals(1, connRefs1.size)
		assertEquals(1, connRefs2.size)
		assertEquals(connRefs1.get(0).connection, connRefs2.get(0).connection)
		
		// The third and fourth connections should be inverses.
		val connRefs3 = ci3.connectionReferences
		val connRefs4 = ci4.connectionReferences
		assertEquals(2, connRefs3.size)
		assertEquals(2, connRefs4.size)
		assertEquals(connRefs3.get(0).connection, connRefs4.get(1).connection)
		assertEquals(connRefs4.get(1).connection, connRefs3.get(0).connection)
	}
		
	private def void test0(String aadlFile) {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + aadlFile)

		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + ROOT_IMPL + '" not found', cls.exists[name == ROOT_IMPL])

		// Instantiate system
		val sysImpl = cls.findFirst[name == ROOT_IMPL] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_INSTANCE, instance.name)
		
		// There should be exactly 0 connection instances
		val myP = instance.componentInstances.get(0)
		assertEquals(0, myP.connectionInstances.size)
	}
		
	private def void test1(String aadlFile) {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + aadlFile)

		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + ROOT_IMPL + '" not found', cls.exists[name == ROOT_IMPL])

		// Instantiate system
		val sysImpl = cls.findFirst[name == ROOT_IMPL] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_INSTANCE, instance.name)
		
		// There should be exactly 2 connection instances
		val myP = instance.componentInstances.get(0)
		assertEquals(2, myP.connectionInstances.size)
		
		val ci1 = myP.connectionInstances.get(0)
		val ci2 = myP.connectionInstances.get(1)

		// Each connection instance should have 1 connection reference
		val connRefs1 = ci1.connectionReferences
		val connRefs2 = ci2.connectionReferences
		assertEquals(1, connRefs1.size)
		assertEquals(1, connRefs2.size)
		
		// The two connection instances should follow opposite paths
		assertEquals(connRefs1.get(0).connection, connRefs2.get(0).connection)
	}
	
	private def void test2(String aadlFile) {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + aadlFile)

		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + ROOT_IMPL + '" not found', cls.exists[name == ROOT_IMPL])

		// Instantiate system
		val sysImpl = cls.findFirst[name == ROOT_IMPL] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_INSTANCE, instance.name)
		
		// There should be exactly 2 connection instances
		val myP = instance.componentInstances.get(0)
		assertEquals(2, myP.connectionInstances.size)
		
		val ci1 = myP.connectionInstances.get(0)
		val ci2 = myP.connectionInstances.get(1)

		// Each connection instance should have 2 connection references
		val connRefs1 = ci1.connectionReferences
		val connRefs2 = ci2.connectionReferences
		assertEquals(2, connRefs1.size)
		assertEquals(2, connRefs2.size)
		
		// The two connection instances should follow opposite paths
		assertEquals(connRefs1.get(0).connection, connRefs2.get(1).connection)
		assertEquals(connRefs1.get(1).connection, connRefs2.get(0).connection)
	}
	
	private def void test3(String aadlFile) {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + aadlFile)

		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + ROOT_IMPL + '" not found', cls.exists[name == ROOT_IMPL])

		// Instantiate system
		val sysImpl = cls.findFirst[name == ROOT_IMPL] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_INSTANCE, instance.name)
		
		// There should be exactly 2 connection instances
		val myP = instance.componentInstances.get(0)
		assertEquals(2, myP.connectionInstances.size)
		
		val ci1 = myP.connectionInstances.get(0)
		val ci2 = myP.connectionInstances.get(1)

		// Each connection instance should have 3 connection references
		val connRefs1 = ci1.connectionReferences
		val connRefs2 = ci2.connectionReferences
		assertEquals(3, connRefs1.size)
		assertEquals(3, connRefs2.size)
		
		// The two connection instances should follow opposite paths
		assertEquals(connRefs1.get(0).connection, connRefs2.get(2).connection)
		assertEquals(connRefs1.get(1).connection, connRefs2.get(1).connection)
		assertEquals(connRefs1.get(2).connection, connRefs2.get(0).connection)
	}
}
