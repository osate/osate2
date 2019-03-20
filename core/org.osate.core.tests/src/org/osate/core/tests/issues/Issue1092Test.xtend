package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.Mode
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.ModeInstance
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instance.SystemOperationMode
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1092Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1092/"
	val static IMPLICIT_MAPPING_TEST = "ImplicitMapping.aadl"
	val static EXPLICIT_MAPPING_TEST = "ExplicitMapping.aadl"
	val static REGULAR_MODES_TEST = "RegularModes.aadl"
	val static UNMAPPED_MODES_TEST = "UnmappedModes.aadl"

	@Test
	def void testImplicitMapping() {
		val pkg = getPackage(IMPLICIT_MAPPING_TEST, PROJECT_LOCATION + IMPLICIT_MAPPING_TEST)
		
		val instance = getSystemInstance(pkg, "main.impl", "main_impl_Instance", null)

		val proc = instance.componentInstances.get(0)
		assertTrue("System is expected to have exactly one subcomponent", instance.componentInstances.size() == 1)
		assertTrue("Process 'proc' is expected as the only child of system", proc.name.equals("proc"))
		assertTrue("Process 'proc' is expected to exactly 2 modes", proc.modeInstances.size == 2)
		val proc_m1 = getAndTestElement(proc.modeInstances, 0,
			"Mode 'm1' is expected as the first mode of 'proc'", [m | m.name.equals("m1")])
		val proc_m2 = getAndTestElement(proc.modeInstances, 1, 
			"Mode 'm2' is expected as the second mode of 'proc'", [m | m.name.equals("m2")])
		
		assertTrue("Process 'proc' is expected to have exactly 2 subcomponents", proc.componentInstances.size == 2)
		val t1 = getAndTestElement(proc.componentInstances, 0,
			"Thread 't1' is expected as the first subcomponent of 'proc'", [t | t.name.equals("t1")])
		val t2 = getAndTestElement(proc.componentInstances, 1,
			"Thread 't2' is expected as the second subcomponent of 'proc'", [t | t.name.equals("t2")])
		
		val t1_modes = testThreadRequiredModes(proc, proc_m1, proc_m2, t1, "m1", "m2")
		val t2_modes = testThreadRequiredModes(proc, proc_m1, proc_m2, t2, "m1", "m2")
		
		assertTrue("System is expected to have exactly 2 system operation modes", instance.systemOperationModes.size == 2)
		val som1 = testSystemOperationMode(instance.systemOperationModes.get(0), proc_m1, t1_modes.get(0), t2_modes.get(0))
		val som2 = testSystemOperationMode(instance.systemOperationModes.get(1), proc_m2, t2_modes.get(1), t2_modes.get(1))
		
		val t1_props = t1.ownedPropertyAssociations
		assertTrue("Thread 't1' is expected to have exactly 1 property association", t1_props.size == 1)
		val t1_propVals = t1_props.get(0).ownedValues
		assertTrue("Thread 't1' is expected to have exactly 2 property values", t1_propVals.size == 2)
		val val1 = t1_propVals.get(0)
		assertTrue("The first property value is expected to have exactly 1 mode", val1.getInModes().size == 1)
		assertTrue("The first property value is expected to be in system operation mode '" + som1.name + "'", val1.getInModes().get(0) == som1)
		val val2 = t1_propVals.get(1)
		assertTrue("The second property value is expected to have exactly 1 mode", val2.getInModes().size == 1)
		assertTrue("The second property value is expected to be in system operation mode '" + som2.name + "'", val2.getInModes().get(0) == som2)
		
		val t2_props = t2.ownedPropertyAssociations
		assertTrue("Thread 't2' is expected to have exactly 1 property association", t2_props.size == 1)
		val t2_propVals = t2_props.get(0).ownedValues
		assertTrue("Thread 't1' is expected to have exactly 2 property values", t2_propVals.size == 2)
		val val1b = t2_propVals.get(0)
		assertTrue("The first property value is expected to have exactly 1 mode", val1b.getInModes().size == 1)
		assertTrue("The first property value is expected to be in system operation mode '" + som1.name + "'", val1b.getInModes().get(0) == som1)
		val val2b = t2_propVals.get(1)
		assertTrue("The second property value is expected to have exactly 1 mode", val2b.getInModes().size == 1)
		assertTrue("The second property value is expected to be in system operation mode '" + som2.name + "'", val2b.getInModes().get(0) == som2)
	}

	@Test
	def void testExplicitMapping() {
		val pkg = getPackage(EXPLICIT_MAPPING_TEST, PROJECT_LOCATION + EXPLICIT_MAPPING_TEST)
		
		val instance = getSystemInstance(pkg, "main.impl", "main_impl_Instance", null)

		val proc = instance.componentInstances.get(0)
		assertTrue("System is expected to have exactly one subcomponent", instance.componentInstances.size() == 1)
		assertTrue("Process 'proc' is expected as the only child of system", proc.name.equals("proc"))
		assertTrue("Process 'proc' is expected to exactly 2 modes", proc.modeInstances.size == 2)
		val proc_m1 = getAndTestElement(proc.modeInstances, 0,
			"Mode 'm1' is expected as the first mode of 'proc'", [m | m.name.equals("m1")])
		val proc_m2 = getAndTestElement(proc.modeInstances, 1, 
			"Mode 'm2' is expected as the second mode of 'proc'", [m | m.name.equals("m2")])
		
		assertTrue("Process 'proc' is expected to have exactly 2 subcomponents", proc.componentInstances.size == 2)
		val t1 = getAndTestElement(proc.componentInstances, 0,
			"Thread 't1' is expected as the first subcomponent of 'proc'", [t | t.name.equals("t1")])
		val t2 = getAndTestElement(proc.componentInstances, 1,
			"Thread 't2' is expected as the second subcomponent of 'proc'", [t | t.name.equals("t2")])
		
		val t1_modes = testThreadRequiredModes(proc, proc_m1, proc_m2, t1, "x1", "x2")
		val t2_modes = testThreadRequiredModes(proc, proc_m1, proc_m2, t2, "x1", "x2")
		
		assertTrue("System is expected to have exactly 2 system operation modes", instance.systemOperationModes.size == 2)
		val som1 = testSystemOperationMode(instance.systemOperationModes.get(0), proc_m1, t1_modes.get(0), t2_modes.get(0))
		val som2 = testSystemOperationMode(instance.systemOperationModes.get(1), proc_m2, t2_modes.get(1), t2_modes.get(1))
		
		val t1_props = t1.ownedPropertyAssociations
		assertTrue("Thread 't1' is expected to have exactly 1 property association", t1_props.size == 1)
		val t1_propVals = t1_props.get(0).ownedValues
		assertTrue("Thread 't1' is expected to have exactly 2 property values", t1_propVals.size == 2)
		val val1 = t1_propVals.get(0)
		assertTrue("The first property value is expected to have exactly 1 mode", val1.getInModes().size == 1)
		assertTrue("The first property value is expected to be in system operation mode '" + som1.name + "'", val1.getInModes().get(0) == som1)
		val val2 = t1_propVals.get(1)
		assertTrue("The second property value is expected to have exactly 1 mode", val2.getInModes().size == 1)
		assertTrue("The second property value is expected to be in system operation mode '" + som2.name + "'", val2.getInModes().get(0) == som2)
		
		val t2_props = t2.ownedPropertyAssociations
		assertTrue("Thread 't2' is expected to have exactly 1 property association", t2_props.size == 1)
		val t2_propVals = t2_props.get(0).ownedValues
		assertTrue("Thread 't1' is expected to have exactly 2 property values", t2_propVals.size == 2)
		val val1b = t2_propVals.get(0)
		assertTrue("The first property value is expected to have exactly 1 mode", val1b.getInModes().size == 1)
		assertTrue("The first property value is expected to be in system operation mode '" + som1.name + "'", val1b.getInModes().get(0) == som1)
		val val2b = t2_propVals.get(1)
		assertTrue("The second property value is expected to have exactly 1 mode", val2b.getInModes().size == 1)
		assertTrue("The second property value is expected to be in system operation mode '" + som2.name + "'", val2b.getInModes().get(0) == som2)
	}

	@Test
	def void testRegularModes() {
		val pkg = getPackage(REGULAR_MODES_TEST, PROJECT_LOCATION + REGULAR_MODES_TEST)
		
		val instance = getSystemInstance(pkg, "main.impl", "main_impl_Instance", null)

		val proc = instance.componentInstances.get(0)
		assertTrue("System is expected to have exactly one subcomponent", instance.componentInstances.size() == 1)
		assertTrue("Process 'proc' is expected as the only child of system", proc.name.equals("proc"))
		assertTrue("Process 'proc' is expected to exactly 2 modes", proc.modeInstances.size == 2)
		val proc_m1 = getAndTestElement(proc.modeInstances, 0,
			"Mode 'm1' is expected as the first mode of 'proc'", [m | m.name.equals("m1")])
		val proc_m2 = getAndTestElement(proc.modeInstances, 1, 
			"Mode 'm2' is expected as the second mode of 'proc'", [m | m.name.equals("m2")])
		
		assertTrue("Process 'proc' is expected to have exactly 2 subcomponents", proc.componentInstances.size == 2)
		val t1 = getAndTestElement(proc.componentInstances, 0,
			"Thread 't1' is expected as the first subcomponent of 'proc'", [t | t.name.equals("t1")])
		val t2 = getAndTestElement(proc.componentInstances, 1,
			"Thread 't2' is expected as the second subcomponent of 'proc'", [t | t.name.equals("t2")])
		
		val t1_modes = testThreadRegularModes(t1, "m1", "m2")
		val t2_modes = testThreadRegularModes(t2, "m1", "m2")
		
		assertTrue("System is expected to have exactly 8 system operation modes", instance.systemOperationModes.size == 8)
		val som0 = testSystemOperationMode(instance.systemOperationModes.get(0), proc_m1, t1_modes.get(0), t2_modes.get(0))
		val som1 = testSystemOperationMode(instance.systemOperationModes.get(1), proc_m1, t1_modes.get(0), t2_modes.get(1))
		val som2 = testSystemOperationMode(instance.systemOperationModes.get(2), proc_m1, t1_modes.get(1), t2_modes.get(0))
		val som3 = testSystemOperationMode(instance.systemOperationModes.get(3), proc_m1, t1_modes.get(1), t2_modes.get(1))
		val som4 = testSystemOperationMode(instance.systemOperationModes.get(4), proc_m2, t1_modes.get(0), t2_modes.get(0))
		val som5 = testSystemOperationMode(instance.systemOperationModes.get(5), proc_m2, t1_modes.get(0), t2_modes.get(1))
		val som6 = testSystemOperationMode(instance.systemOperationModes.get(6), proc_m2, t1_modes.get(1), t2_modes.get(0))
		val som7 = testSystemOperationMode(instance.systemOperationModes.get(7), proc_m2, t1_modes.get(1), t2_modes.get(1))
		
		val t1_props = t1.ownedPropertyAssociations
		assertTrue("Thread 't1' is expected to have exactly 1 property association", t1_props.size == 1)
		val t1_propVals = t1_props.get(0).ownedValues
		assertTrue("Thread 't1' is expected to have exactly 2 property values", t1_propVals.size == 2)
		testPropertyValueModes(t1_propVals.get(0).getInModes(), som0, som1, som4, som5)
		testPropertyValueModes(t1_propVals.get(1).getInModes(), som2, som3, som6, som7)
		
		val t2_props = t2.ownedPropertyAssociations
		assertTrue("Thread 't2' is expected to have exactly 1 property association", t2_props.size == 1)
		val t2_propVals = t2_props.get(0).ownedValues
		assertTrue("Thread 't2' is expected to have exactly 2 property values", t2_propVals.size == 2)
		testPropertyValueModes(t2_propVals.get(0).getInModes(), som0, som2, som4, som6)
		testPropertyValueModes(t2_propVals.get(1).getInModes(), som1, som3, som5, som7)
	}

	@Test
	def void testUnmappedModes() {
		val pkg = getPackage(UNMAPPED_MODES_TEST, PROJECT_LOCATION + UNMAPPED_MODES_TEST)
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = getSystemInstance(pkg, "main.impl", "main_impl_Instance", errorManager)
		val reporter = errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter
		val messages = reporter.errors

		assertTrue("Instance model should have exactly 4 errors", messages.length == 4)

		val proc = instance.componentInstances.get(0)
		assertTrue("System is expected to have exactly one subcomponent", instance.componentInstances.size() == 1)
		assertTrue("Process 'proc' is expected as the only child of system", proc.name.equals("proc"))
		assertTrue("Process 'proc' is expected to exactly 2 modes", proc.modeInstances.size == 2)
		val proc_m1 = getAndTestElement(proc.modeInstances, 0,
			"Mode 'm1' is expected as the first mode of 'proc'", [m | m.name.equals("m1")])
		val proc_m2 = getAndTestElement(proc.modeInstances, 1, 
			"Mode 'm2' is expected as the second mode of 'proc'", [m | m.name.equals("m2")])
		
		assertTrue("Process 'proc' is expected to have exactly 2 subcomponents", proc.componentInstances.size == 2)
		val t1 = getAndTestElement(proc.componentInstances, 0,
			"Thread 't1' is expected as the first subcomponent of 'proc'", [t | t.name.equals("t1")])
		val t2 = getAndTestElement(proc.componentInstances, 1,
			"Thread 't2' is expected as the second subcomponent of 'proc'", [t | t.name.equals("t2")])
		
		testThreadUnmappedModes(messages, t1, "x1", "x2")
		testThreadUnmappedModes(messages, t2, "x1", "x2")
		
		assertTrue("System is expected to have exactly 8 system operation modes", instance.systemOperationModes.size == 2)
		testSystemOperationMode(instance.systemOperationModes.get(0), proc_m1)
		testSystemOperationMode(instance.systemOperationModes.get(1), proc_m2)
	}

	private def static void testPropertyValueModes(List<Mode> actualModes, SystemOperationMode... testModes) {
		assertTrue("The property value is expected to have exactly " + testModes.length + " modes", actualModes.size == testModes.length)
		for (mi : testModes) {
			assertTrue("The property value is expected to be in system operation mode '" + mi.name + "'", actualModes.contains(mi))
		}
	}

	private def static SystemOperationMode testSystemOperationMode(SystemOperationMode som, ModeInstance... modes) {
		val size = modes.length
		assertTrue("System operation mode '" + som.name + "' is expected to have exactly " + size + " current modes", som.currentModes.size == size)
		for (ModeInstance mi : modes) {
			assertTrue("System operation mode '" + som.name + "' is expected to have mode '" + mi.name + "' as a current mode", som.currentModes.contains(mi))
		}
		return som
	}
	
	private def static List<ModeInstance> testThreadUnmappedModes(List<QueuingAnalysisErrorReporter.Message> messages, ComponentInstance t, String t_m1_name, String t_m2_name) {
		assertTrue("Thread '" + t.name + "' is expected to have exactly 2 modes", t.modeInstances.size == 2)
		val t_m1 = getAndTestElement(t.modeInstances, 0,
			"Mode '" + t_m1_name + "' is expected as the first mode of '" + t.name + "'", [m | m.name.equals(t_m1_name)])
		val t_m2 = getAndTestElement(t.modeInstances, 1,
			"Mode '" + t_m2_name + "' is expected as the second mode of '" + t.name + "'", [m | m.name.equals(t_m2_name)])
		
		
		assertTrue("Mode '" + t_m1.name + "' of '" + t.name + "' is expected to be derived", t_m1.isDerived)
		assertTrue("Mode '" + t_m1.name + "' of '" + t.name + "' is expected to have no parents", t_m1.parents.isEmpty())
		testForError(messages, t_m1, "Required mode '" + t_m1_name + "' not found in containing component")
		
		assertTrue("Mode '" + t_m2.name + "' of '" + t.name + "' is expected to be derived", t_m2.isDerived)
		assertTrue("Mode '" + t_m2.name + "' of '" + t.name + "' is expected to have no parents", t_m2.parents.isEmpty())
		testForError(messages, t_m2, "Required mode '" + t_m2_name + "' not found in containing component")
		
		return #[t_m1, t_m2]
	}
	
	private def static void testForError(List<QueuingAnalysisErrorReporter.Message> messages, EObject e, String errMessage) {
		messages.findFirst[where == e] => [
			assertEquals(kind, QueuingAnalysisErrorReporter.ERROR)
			assertEquals(message, errMessage)			
		]
	}
	
	private def static List<ModeInstance> testThreadRegularModes(ComponentInstance t, String t_m1_name, String t_m2_name) {
		assertTrue("Thread '" + t.name + "' is expected to have exactly 2 modes", t.modeInstances.size == 2)
		val t_m1 = getAndTestElement(t.modeInstances, 0,
			"Mode '" + t_m1_name + "' is expected as the first mode of '" + t.name + "'", [m | m.name.equals(t_m1_name)])
		val t_m2 = getAndTestElement(t.modeInstances, 1,
			"Mode '" + t_m2_name + "' is expected as the second mode of '" + t.name + "'", [m | m.name.equals(t_m2_name)])
		
		assertTrue("Mode '" + t_m1.name + "' of '" + t.name + "' is expected to not be derived", !t_m1.isDerived)
		assertTrue("Mode '" + t_m2.name + "' of '" + t.name + "' is expected to not be derived", !t_m2.isDerived)
		
		return #[t_m1, t_m2]
	}
	
	private def static List<ModeInstance> testThreadRequiredModes(ComponentInstance proc, ModeInstance proc_m1, ModeInstance proc_m2, ComponentInstance t, String t_m1_name, String t_m2_name) {
		assertTrue("Thread '" + t.name + "' is expected to have exactly 2 modes", t.modeInstances.size == 2)
		val t_m1 = getAndTestElement(t.modeInstances, 0,
			"Mode '" + t_m1_name + "' is expected as the first mode of '" + t.name + "'", [m | m.name.equals(t_m1_name)])
		val t_m2 = getAndTestElement(t.modeInstances, 1,
			"Mode '" + t_m2_name + "' is expected as the second mode of '" + t.name + "'", [m | m.name.equals(t_m2_name)])
		
		testModeMapping(proc, t, proc_m1, t_m1)
		testModeMapping(proc, t, proc_m2, t_m2)
		
		return #[t_m1, t_m2]
	}
	
	private def static void testModeMapping(ComponentInstance parentComponent, ComponentInstance subComponent, ModeInstance parent1, ModeInstance sub1) {
		assertTrue("Mode '" + sub1.name + "' of '" + subComponent.name + "' is expected to be derived", sub1.isDerived)
		assertTrue("Mode '" + sub1.name + "' of '" + subComponent.name + "' is expected to have mode '" + parent1.name + "' of '" + parentComponent.name + "' as its parent", sub1.parents.get(0) === parent1)
	}
	
	private def static <X> X getAndTestElement(EList<X> list, int idx, String msg, (X)=>boolean test) {
		val element = list.get(idx)
		assertTrue(msg, test.apply(element))
		return element
	}
	
	private def FluentIssueCollection getFluentIssueCollection(String fname, String path) {
		testHelper.testFile(path)
	}
	
	private def AadlPackage getPackage(String fname, String path) {
		getFluentIssueCollection(fname, path).resource.contents.head as AadlPackage
	}
	
	private def static SystemInstance getSystemInstance(
		AadlPackage pkg, String systemImplName, String expectedInstanceName, AnalysisErrorReporterManager errorManager
	) {
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + systemImplName + '" not found', cls.exists[name == systemImplName])
		
		// Instantiate system
		val sysImpl = cls.findFirst[name == systemImplName] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(expectedInstanceName, instance.name)
		return instance
		
	}
}
