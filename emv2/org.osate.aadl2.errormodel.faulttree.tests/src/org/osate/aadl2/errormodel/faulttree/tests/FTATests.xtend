package org.osate.aadl2.errormodel.faulttree.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.NamedElement
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.errormodel.FaultTree.LogicOperation
import org.osate.aadl2.errormodel.faulttree.generation.CreateFTAModel
import org.osate.aadl2.errormodel.tests.ErrorModelUiInjectorProvider
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent

import static org.junit.Assert.*
import org.osate.aadl2.errormodel.FaultTree.FaultTreeType
import org.osate.aadl2.errormodel.FaultTree.EventType
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErrorModelUiInjectorProvider))
class FTATests extends OsateTest {
	override getProjectName() {
		"FTATests"
	}

	static boolean once = true

	var static SystemInstance instance1
	var static SystemInstance instance2
	var static SystemInstance instance3
	var static SystemInstance instancecommon1
	var static SystemInstance instancecommon2
	var static SystemInstance instancecommon3
	var static SystemInstance instancecomposite
	var static SystemInstance instanceredundant
	var static SystemInstance instanceredundant21
	var static SystemInstance instanceredundant22
	var static SystemInstance instanceredundant23

	val static stateFail = "state Failed"
	val static stateFailStop = "state FailStop"
	val static stateOp = "state Operational"

	@Before
	override setUp() {
	}

	@After
	override cleanUp() {
	}

	@Before
	/**
	 * All tests use the same model
	 */
	def void initWorkspace() {
		if (once) {
			once = false
			createProject(projectName)
			setResourceRoot("platform:/resource/" + projectName)
			val modelroot = "org.osate.aadl2.errormodel.faulttree.tests/models/FTATests/"
			val fta1File = "fta1Test.aadl"
			val fta2File = "fta2Test.aadl"
			val fta3File = "fta3Test.aadl"
			val common1File = "common-error.aadl"
			val common2File = "common-error2.aadl"
			val common3File = "common-error3.aadl"
			val nestedcompositeFile = "nestedcomposite.aadl"
			val redundantFile = "redundant.aadl"
			val redundant2File = "redundant2.aadl"
			val errorlibFile = "ErrorModellibrary.aadl"
			val FTerrorlibFile = "FTerrorlibrary.aadl"
			createFiles(
				fta1File -> readFile(modelroot + fta1File),
				fta2File -> readFile(modelroot + fta2File),
				fta3File -> readFile(modelroot + fta3File),
				common1File -> readFile(modelroot + common1File),
				common2File -> readFile(modelroot + common2File),
				common3File -> readFile(modelroot + common3File),
				nestedcompositeFile -> readFile(modelroot + nestedcompositeFile),
				redundantFile -> readFile(modelroot + redundantFile),
				redundant2File -> readFile(modelroot + redundant2File),
				errorlibFile -> readFile(modelroot + errorlibFile),
				FTerrorlibFile -> readFile(modelroot + FTerrorlibFile)
			)
			suppressSerialization
			instance1 = instanceGenerator(fta1File, "main.i")
			instance2 = instanceGenerator(fta2File, "main.i")
			instance3 = instanceGenerator(fta3File, "main.i")
			instancecommon1 = instanceGenerator(common1File, "main.commonsource")
			instancecommon2 = instanceGenerator(common2File, "main.commonevents")
			instancecommon3 = instanceGenerator(common3File, "main.commoneventssingleport")
			instancecomposite = instanceGenerator(nestedcompositeFile, "main.nestedstate")
			instanceredundant = instanceGenerator(redundantFile, "main.compositestate")

			val result = testFile(redundant2File)
			val pkg = result.resource.contents.head as AadlPackage
			instanceredundant21 = instanceGenerator(pkg, "main2.composite")
			instanceredundant22 = instanceGenerator(pkg, "main2.compositesametype")
			instanceredundant23 = instanceGenerator(pkg, "main2.transition")
		}
	}

	def SystemInstance instanceGenerator(AadlPackage pkg, String rootclassifier) {
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == rootclassifier])
		// instantiate
		val sysImpl = cls.findFirst[name == rootclassifier] as SystemImplementation
		return InstantiateModel::buildInstanceModelFile(sysImpl)
	}

	def SystemInstance instanceGenerator(String filename, String rootclassifier) {
		val result = testFile(filename)

		// get the correct package
		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == rootclassifier])

		// instantiate
		val sysImpl = cls.findFirst[name == rootclassifier] as SystemImplementation
		return InstantiateModel::buildInstanceModelFile(sysImpl)
	}

	/**
	 * example of simple composite error state with an AND operator.
	 * The subcomponents have two states and a transition triggered by an error event.
	 * The error event is a Basic Event.
	 */
	@Test
	def void fta1Test1() {

		val ft = CreateFTAModel.createFaultTree(instance1, stateFail)
		assertEquals(ft.events.size, 3)
		assertEquals(ft.root.subEventLogic, LogicOperation.AND)
		assertEquals((ft.root.subEvents.head.relatedEMV2Object as NamedElement).name, "Failure")
		assertEquals((ft.root.subEvents.head.relatedInstanceObject as NamedElement).name, "s1")
	}

	@Test
	def void fta2Test1() {
		val ft = CreateFTAModel.createFaultTree(instance2, stateFail)
		assertEquals(ft.events.size, 11)
		assertEquals(ft.root.subEventLogic, LogicOperation.AND)
		val sube1 = ft.root.subEvents.head
		val sube2 = ft.root.subEvents.get(1)
		assertEquals(sube1.subEventLogic, LogicOperation.XOR)
		assertEquals(sube2.subEventLogic, LogicOperation.XOR)
		assertEquals(sube1.subEvents.head.subEventLogic, LogicOperation.OR)
		assertEquals(sube2.subEvents.head.subEventLogic, LogicOperation.OR)

	}

	@Test
	def void fta2Test2() {
		val ftr = CreateFTAModel.createFaultTrace(instance2, stateFail)
		assertEquals(ftr.events.size, 17)
	}

	@Test
	def void fta2Test3() {
		val ftparts = CreateFTAModel.createPartsFaultTree(instance2, stateFail)
		assertEquals(ftparts.events.size, 7)
		assertEquals(ftparts.root.subEventLogic, LogicOperation.AND)
		val sube11 = ftparts.root.subEvents.head
		val sube22 = ftparts.root.subEvents.get(1)
		assertEquals(sube11.subEventLogic, LogicOperation.XOR)
		assertEquals(sube22.subEventLogic, LogicOperation.XOR)
	}

	@Test
	def void fta3Test() {
		val ft = CreateFTAModel.createFaultTree(instance3, stateFail)
		assertEquals(ft.events.size, 9)
		assertEquals(ft.root.subEventLogic, LogicOperation.AND)
		val sube1 = ft.root.subEvents.head
		assertEquals((sube1.relatedInstanceObject as NamedElement).name, "s1")
		assertEquals(sube1.subEventLogic, LogicOperation.OR)
		assertTrue(sube1.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals(sube1.subEvents.size, 3)
		assertTrue(sube1.subEvents.head.relatedEMV2Object instanceof ErrorEvent)
	}

	@Test
	def void common1Test1() {
		val ft = CreateFTAModel.createFaultTree(instancecommon1, stateFailStop)
		assertEquals(ft.events.size, 5)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		val sube1 = ft.root.subEvents.head
		assertEquals((sube1.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertTrue(sube1.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals(sube1.subEvents.size, 2)
		assertTrue(sube1.subEvents.head.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube1.subEvents.head.relatedEMV2Object as ErrorEvent).name, "Failure")
		assertEquals((sube1.subEvents.head.relatedInstanceObject as NamedElement).name, "a0")
		assertEquals((sube1.subEvents.get(1).relatedInstanceObject as NamedElement).name, "a1")
	}

	@Test
	def void common1Test2() {
		val ft = CreateFTAModel.createFaultTree(instancecommon1, stateOp)
		assertEquals(ft.events.size, 1)
	}

	@Test
	def void common2Test() {
		val ft = CreateFTAModel.createFaultTree(instancecommon2, stateFailStop)
		assertEquals(ft.events.size, 5)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		val sube1 = ft.root.subEvents.head
		assertEquals((sube1.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertTrue(sube1.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals(sube1.subEvents.size, 2)
		assertTrue(sube1.subEvents.head.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube1.subEvents.head.relatedEMV2Object as ErrorEvent).name, "Failure")
		assertEquals((sube1.subEvents.head.relatedInstanceObject as NamedElement).name, "a0")
		assertEquals((sube1.subEvents.get(1).relatedInstanceObject as NamedElement).name, "a1")
	}

	@Test
	def void common3Test() {
		val ft = CreateFTAModel.createFaultTree(instancecommon3, stateFailStop)
		assertEquals(ft.events.size, 5)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		val sube1 = ft.root.subEvents.head
		assertEquals((sube1.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertTrue(sube1.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals(sube1.subEvents.size, 2)
		assertTrue(sube1.subEvents.head.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube1.subEvents.head.relatedEMV2Object as ErrorEvent).name, "Failure")
		assertEquals((sube1.subEvents.head.relatedInstanceObject as NamedElement).name, "a0")
		assertEquals((sube1.subEvents.get(1).relatedInstanceObject as NamedElement).name, "a1")
	}

	@Test
	def void compositeerrorfta() {

		val ft = CreateFTAModel.createModel(instancecommon1, stateFailStop, FaultTreeType.COMPOSITE_PARTS);
		assertEquals(ft.events.size, 3)
		for (event : ft.events) {
			if (event.type != EventType.INTERMEDIATE) {
				assertTrue(event.relatedEMV2Object instanceof ErrorBehaviorState)
			}
		}

	}

	@Test
	def void nestedcompositepartsfta() {
		val ft = CreateFTAModel.createPartsFaultTree(instancecomposite, stateFailStop);
		assertEquals(ft.events.size, 9)
		for (event : ft.events) {
			if (event.type != EventType.INTERMEDIATE) {
				assertTrue(event.relatedEMV2Object instanceof ErrorBehaviorState)
			}
		}
	}

	@Test
	def void nestedcompositefta() {
		val ft = CreateFTAModel.createFaultTree(instancecomposite, stateFailStop);
		assertEquals(ft.events.size, 8)
		for (event : ft.events) {
			if (event.type != EventType.INTERMEDIATE) {
				assertTrue(event.relatedEMV2Object instanceof ErrorEvent)
			}
		}
		assertEquals(ft.root.subEventLogic, LogicOperation.XOR)
		assertEquals(ft.root.subEvents.size, 3)
		val sube1 = ft.root.subEvents.head
		val sube2 = ft.root.subEvents.get(1)
		assertEquals((sube1.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertTrue(sube1.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals(sube1.subEvents.size, 2)
		assertEquals(sube2.subEvents.size, 2)
		assertTrue(sube1.subEvents.head.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube1.subEvents.head.relatedEMV2Object as ErrorEvent).name, "Failure")
		assertEquals((sube1.subEvents.head.relatedInstanceObject as NamedElement).name, "thr1")
		assertEquals((sube1.subEvents.get(1).relatedInstanceObject as NamedElement).name, "thr2")
		assertTrue(sube2.subEvents.head.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube2.subEvents.head.relatedEMV2Object as ErrorEvent).name, "Failure")
		assertEquals((sube2.subEvents.head.relatedInstanceObject as NamedElement).name, "sensor1")
		assertEquals((sube2.subEvents.get(1).relatedInstanceObject as NamedElement).name, "sensor2")
	}

	@Test
	def void redundantTest() {
		val ft = CreateFTAModel.createFaultTree(instanceredundant, stateFailStop)
		assertEquals(ft.events.size, 6)
		assertEquals(ft.root.subEventLogic, LogicOperation.XOR)
		val sube1 = ft.root.subEvents.get(0)
		val sube2 = ft.root.subEvents.get(1)
		val sube3 = ft.root.subEvents.get(2)
		assertEquals((sube2.relatedInstanceObject as NamedElement).name, "actuator")
		assertEquals((sube3.relatedInstanceObject as NamedElement).name, "thr")
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertEquals(sube1.subEvents.size, 2)
		assertTrue(sube1.subEvents.head.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube1.subEvents.head.relatedEMV2Object as ErrorEvent).name, "Failure")
		assertEquals((sube1.subEvents.head.relatedInstanceObject as NamedElement).name, "sensor1")
		assertEquals((sube1.subEvents.get(1).relatedInstanceObject as NamedElement).name, "sensor2")
	}

	@Test
	def void redundant21Test() {
		val ft = CreateFTAModel.createFaultTree(instanceredundant21, stateFailStop)
		assertEquals(ft.events.size, 8)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		assertEquals(ft.root.subEvents.size, 5)
		val sube1 = ft.root.subEvents.get(1)
		assertEquals((sube1.relatedInstanceObject as NamedElement).name, "thr")
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertEquals(sube1.subEvents.size, 2)
		assertTrue(sube1.subEvents.head.relatedEMV2Object instanceof ErrorPropagation)
		assertEquals((sube1.subEvents.head.relatedInstanceObject as NamedElement).name, "sensor1")
		assertEquals((sube1.subEvents.get(1).relatedInstanceObject as NamedElement).name, "sensor2")
	}

	@Test
	def void redundant22Test() {
		val ft = CreateFTAModel.createFaultTree(instanceredundant22, stateFailStop)
		assertEquals(ft.events.size, 10)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		val sube1 = ft.root.subEvents.head
		assertEquals((sube1.relatedInstanceObject as NamedElement).name, "actuator")
	}

	@Test
	def void redundant23Test() {
		val start = "outgoing propagation on externaleffect{serviceomission}"
		val ft = CreateFTAModel.createFaultTree(instanceredundant23, start)
		assertEquals(ft.events.size, 5)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		val sube1 = ft.root.subEvents.head
		assertEquals((sube1.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertTrue(sube1.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals(sube1.subEvents.size, 2)
		assertTrue(sube1.subEvents.head.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube1.subEvents.head.relatedEMV2Object as ErrorEvent).name, "Failure")
		assertEquals((sube1.subEvents.head.relatedInstanceObject as NamedElement).name, "a0")
		assertEquals((sube1.subEvents.get(1).relatedInstanceObject as NamedElement).name, "a1")
	}
}
