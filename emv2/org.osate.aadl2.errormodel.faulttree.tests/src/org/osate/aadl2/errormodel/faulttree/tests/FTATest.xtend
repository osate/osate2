package org.osate.aadl2.errormodel.faulttree.tests

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.NamedElement
import org.osate.aadl2.errormodel.FaultTree.EventType
import org.osate.aadl2.errormodel.FaultTree.FaultTreeType
import org.osate.aadl2.errormodel.FaultTree.LogicOperation
import org.osate.aadl2.errormodel.faulttree.generation.CreateFTAModel
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource
import org.osate.xtext.aadl2.errormodel.util.EMV2Util

import static org.junit.Assert.*
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken
import org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil

@RunWith(typeof(XtextRunner))
@InjectWith(ErrorModelInjectorProvider)
class FTATest {

	@Inject
	TestHelper<AadlPackage> testHelper

	var primaryroot = null

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
	var static SystemInstance instancevoter
	var static SystemInstance instanceDualFGS
	var static SystemInstance instanceFilteredFlow
	var static SystemInstance instanceAllFlows
	var static SystemInstance instanceOptimize
	var static SystemInstance instanceTransitionBranch
	var static SystemInstance instanceOR1OFProbability
	var static SystemInstance instancePathProbability
	var static SystemInstance instanceIssue1819
	var static SystemInstance instanceIssue1882
	var static SystemInstance instanceIssue1893
	var static SystemInstance instanceIssue1913
	var static SystemInstance instanceIssue1915
	var static SystemInstance instanceIssue1899
	var static SystemInstance instanceIssue1837
	var static SystemInstance instanceIssue1837bis
	var static SystemInstance instanceIssue1962
	var static SystemInstance instanceIssue1961

	val static stateFail = "state Failed"
	val static stateFailStop = "state FailStop"
	val static stateOp = "state Operational"

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
	val voterFile = "voter.aadl"
	val errorlibFile = "ErrorModellibrary.aadl"
	val FTerrorlibFile = "FTerrorlibrary.aadl"
	val dualfgsFile = "DualFGS.aadl"
	val fgselibFile = "FGSErrorModelLibrary.aadl"
	val filteredflowsFile = "FilteredFlows.aadl"
	val allflowsFile = "AllFlows.aadl"
	val optimizeFile = "OptimizeTree.aadl"
	val transitionbranchFile = "branchtransitions.aadl"
	val SysErrorLibFile = "Sys_Error_Lib.aadl"
	val OR1OFProbabilityfile = "OR1OFProbability.aadl"
	val PathProbabilityfile = "PathProbability.aadl"
	val Issue1819file = "Issue1819.aadl"
	val Issue1882file = "Issue1882.aadl"
	val GPSErrorLibraryFile = "GPSErrorLibrary.aadl"
	val GPSPartsFile = "GPSParts.aadl"
	val GPSSystemFile = "GPSSystem.aadl"
	val HardwarePartsFile = "HardwareParts.aadl"
	val EMTypesFile = "EMTypes.aadl"
	val ScrubbedTSFile = "ScrubbedTS.aadl"
	val ScrubbedClFile = "ScrubbedCl.aadl"
	val accessfeaturesFile = "accessfeatures.aadl"
	val Issue1837file = "Issue1837.aadl"
	val Issue1962file = "Issue1962.aadl"
	val Issue1961file = "Issue1961.aadl"

	@Before
	def void initWorkspace() {
		primaryroot = testHelper.parseFile(
			modelroot + fta1File,
			modelroot + fta2File,
			modelroot + fta3File,
			modelroot + common1File,
			modelroot + common2File,
			modelroot + common3File,
			modelroot + nestedcompositeFile,
			modelroot + redundantFile,
			modelroot + redundant2File,
			modelroot + voterFile,
			modelroot + dualfgsFile,
			modelroot + filteredflowsFile,
			modelroot + allflowsFile,
			modelroot + optimizeFile,
			modelroot + transitionbranchFile,
			modelroot + fgselibFile,
			modelroot + errorlibFile,
			modelroot + FTerrorlibFile,
			modelroot + SysErrorLibFile,
			modelroot + OR1OFProbabilityfile,
			modelroot + PathProbabilityfile,
			modelroot + Issue1819file,
			modelroot + Issue1882file,
			modelroot + GPSErrorLibraryFile,
			modelroot + HardwarePartsFile,
			modelroot + GPSPartsFile,
			modelroot + GPSSystemFile,
			modelroot + EMTypesFile,
			modelroot + ScrubbedTSFile,
			modelroot + ScrubbedClFile,
			modelroot + accessfeaturesFile,
			modelroot + Issue1837file,
			modelroot + Issue1962file,
			modelroot + Issue1961file
		)
		instance1 = instanceGenerator(modelroot + fta1File, "main.i")
		instance2 = instanceGenerator(modelroot + fta2File, "main.i")
		instance3 = instanceGenerator(modelroot + fta3File, "main.i")
		instancecommon1 = instanceGenerator(modelroot + common1File, "main.commonsource")
		instancecommon2 = instanceGenerator(modelroot + common2File, "main.commonevents")
		instancecommon3 = instanceGenerator(modelroot + common3File, "main.commoneventssingleport")
		instancecomposite = instanceGenerator(modelroot + nestedcompositeFile, "main.nestedstate")
		instanceredundant = instanceGenerator(modelroot + redundantFile, "main.compositestate")

		instanceredundant21 = instanceGenerator(modelroot + redundant2File, "main2.connection")
		instanceredundant22 = instanceGenerator(modelroot + redundant2File, "main2.compositesametype")
		instanceredundant23 = instanceGenerator(modelroot + redundant2File, "main2.transition")

		instancevoter = instanceGenerator(modelroot + voterFile, "voter.i")
		instanceDualFGS = instanceGenerator(modelroot + dualfgsFile, "FGS.impl")
		instanceFilteredFlow = instanceGenerator(modelroot + filteredflowsFile, "FGS.impl")
		instanceAllFlows = instanceGenerator(modelroot + allflowsFile, "FGS.impl")
		instanceOptimize = instanceGenerator(modelroot + optimizeFile, "Top.impl")
		instanceTransitionBranch = instanceGenerator(modelroot + transitionbranchFile, "BTCU.i")
		instanceOR1OFProbability = instanceGenerator(modelroot + OR1OFProbabilityfile, "S01.i")
		instancePathProbability = instanceGenerator(modelroot + PathProbabilityfile, "main.i")
		instanceIssue1819 = instanceGenerator(modelroot + Issue1819file, "Thermoheater.impl")
		instanceIssue1882 = instanceGenerator(modelroot + Issue1882file, "ac.twoengine")
		instanceIssue1893 = instanceGenerator(modelroot + GPSSystemFile, "GPS.Dual")
		instanceIssue1913 = instanceGenerator(modelroot + ScrubbedTSFile, "top.vccl")
		instanceIssue1915 = instanceGenerator(modelroot + ScrubbedClFile, "top.vc")
		instanceIssue1899 = instanceGenerator(modelroot + accessfeaturesFile, "top.ii")
		instanceIssue1837 = instanceGenerator(modelroot + Issue1837file, "TMR_Archetype.impl")
		instanceIssue1837bis = instanceGenerator(modelroot + Issue1837file, "TMR_Archetype.impl2")
		instanceIssue1962 = instanceGenerator(modelroot + Issue1962file, "ac.impl")
		instanceIssue1961 = instanceGenerator(modelroot + Issue1961file, "ac.impl")
	}

	def SystemInstance instanceGenerator(String filename, String rootclassifier) {
		val ac = primaryroot as AadlPackage
		val rs = ac.eResource.resourceSet
		val targetsrc = rs.getResource(URI.createURI(filename), true)

		// get the correct package
		val pkg = targetsrc.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == rootclassifier])
		// instantiate
		val sysImpl = cls.findFirst[name == rootclassifier] as ComponentImplementation
		return InstantiateModel::instantiate(sysImpl)
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
		assertEquals(ft.events.size, 7)
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
		assertEquals(ft.events.size, 7)
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
	def void redundant21ConnectionBindingTest() {
		val ft = CreateFTAModel.createFaultTree(instanceredundant21, stateFailStop)
		assertEquals(ft.events.size, 16)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		assertEquals(ft.root.subEvents.size, 9)
		val sube1 = ft.root.subEvents.get(2)
		assertEquals((sube1.relatedInstanceObject as NamedElement).name, "thr")
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertEquals(sube1.subEvents.size, 2)
		val subsube1 = sube1.subEvents.head
		val subsube2 = sube1.subEvents.get(1)
		assertEquals(subsube1.subEvents.size, 2)
		assertEquals(subsube2.subEvents.size, 2)
		assertTrue(subsube1.subEvents.head.relatedEMV2Object instanceof ErrorSource)
		assertEquals((subsube1.subEvents.head.relatedInstanceObject as NamedElement).name, "sensor1")
		assertEquals((subsube1.subEvents.get(1).relatedInstanceObject as NamedElement).name, "sensor1")
		assertEquals(EMV2Util.getName((subsube1.subEvents.head.relatedErrorType as TypeToken)), "LateDelivery")
		assertEquals(EMV2Util.getName((subsube1.subEvents.get(1).relatedErrorType as TypeToken)), "OutOfRange")
		assertTrue(subsube2.subEvents.head.relatedEMV2Object instanceof ErrorSource)
		assertEquals((subsube2.subEvents.head.relatedInstanceObject as NamedElement).name, "sensor2")
		assertEquals((subsube2.subEvents.get(1).relatedInstanceObject as NamedElement).name, "sensor2")
		assertEquals(EMV2Util.getName((subsube2.subEvents.head.relatedErrorType as TypeToken)), "LateDelivery")
		assertEquals(EMV2Util.getName((subsube2.subEvents.get(1).relatedErrorType as TypeToken)), "OutOfRange")
		assertTrue(ft.root.subEvents.exists[ev|ev.relatedInstanceObject instanceof ConnectionInstance])
	}

	@Test
	def void redundant22Test() {
		val ft = CreateFTAModel.createFaultTree(instanceredundant22, stateFailStop)
		assertEquals(ft.events.size, 11)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		val sube1 = ft.root.subEvents.head
		assertEquals((sube1.relatedInstanceObject as NamedElement).name, "actuator")
	}

	@Test
	def void redundant23Test() {
		val start = "outgoing propagation on externaleffect{serviceomission}"
		val ft = CreateFTAModel.createFaultTree(instanceredundant23, start)
		assertEquals(ft.events.size, 14)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		val sube1 = ft.root.subEvents.get(1)
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertEquals(sube1.subEvents.size, 2)
		val subsube1 = sube1.subEvents.head
		val subsube2 = sube1.subEvents.get(1)
		assertEquals(subsube1.subEvents.size, 2)
		assertEquals(subsube2.subEvents.size, 2)
		assertTrue(subsube1.subEvents.head.relatedEMV2Object instanceof ErrorSource)
		assertEquals((subsube1.subEvents.head.relatedInstanceObject as NamedElement).name, "sensor1")
		assertEquals((subsube1.subEvents.get(1).relatedInstanceObject as NamedElement).name, "sensor1")
		assertEquals(EMV2Util.getName((subsube1.subEvents.head.relatedErrorType as TypeToken)), "LateDelivery")
		assertEquals(EMV2Util.getName((subsube1.subEvents.get(1).relatedErrorType as TypeToken)), "OutOfRange")
		assertTrue(subsube2.subEvents.head.relatedEMV2Object instanceof ErrorSource)
		assertEquals((subsube2.subEvents.head.relatedInstanceObject as NamedElement).name, "sensor2")
		assertEquals((subsube2.subEvents.get(1).relatedInstanceObject as NamedElement).name, "sensor2")
		assertEquals(EMV2Util.getName((subsube2.subEvents.head.relatedErrorType as TypeToken)), "LateDelivery")
		assertEquals(EMV2Util.getName((subsube2.subEvents.get(1).relatedErrorType as TypeToken)), "OutOfRange")
	}

	@Test
	def void redundant2VoterFaultTreeTest() {
		val start = "outgoing propagation on valueout{ItemOmission}"
		val ft = CreateFTAModel.createFaultTree(instancevoter, start)
		assertEquals(ft.events.size, 5)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		assertEquals(ft.root.subEvents.size, 2)
		val sube1 = ft.root.subEvents.get(0)
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertEquals(sube1.subEvents.size, 2)
		val subsube1 = sube1.subEvents.head
		val subsube2 = sube1.subEvents.get(1)
		assertTrue(subsube1.relatedEMV2Object instanceof ErrorPropagation)
		assertEquals(EMV2Util.getPrintName(subsube1.relatedEMV2Object as NamedElement), "valuein1")
		assertEquals(EMV2Util.getName((subsube1.relatedErrorType as TypeToken)), "OutOfRange")
		assertTrue(subsube2.relatedEMV2Object instanceof ErrorPropagation)
		assertEquals(EMV2Util.getPrintName(subsube2.relatedEMV2Object as NamedElement), "valuein2")
		assertEquals(EMV2Util.getName((subsube2.relatedErrorType as TypeToken)), "OutOfRange")
	}

	@Test
	def void redundant2VoterFaultTreeInconsistentValueTest() {
		val start = "outgoing propagation on valueout{InconsistentValue}"
		val ft = CreateFTAModel.createFaultTree(instancevoter, start)
		assertEquals(ft.events.size, 2)
		assertEquals(ft.root.subEvents.size, 1)
		val sube1 = ft.root.subEvents.get(0)
		assertTrue(sube1.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube1.relatedEMV2Object as NamedElement).name, "ComputeError")
	}

	@Test
	def void redundant2VoterFaultTreeFailStopTest() {
		val start = "state FailStop"
		val ft = CreateFTAModel.createFaultTree(instancevoter, start)
		assertEquals(ft.events.size, 2)
		assertEquals(ft.root.subEvents.size, 1)
		val sube1 = ft.root.subEvents.get(0)
		assertTrue(sube1.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube1.relatedEMV2Object as NamedElement).name, "Failure")
	}

	@Test
	def void redundant2VoterFaultTreeDegradedTest() {
		val start = "state Degraded"
		val ft = CreateFTAModel.createFaultTree(instancevoter, start)
		assertEquals(ft.events.size, 2)
		assertEquals(ft.root.subEvents.size, 1)
		val sube1 = ft.root.subEvents.get(0)
		assertTrue(sube1.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube1.relatedEMV2Object as NamedElement).name, "ComputeError")
	}

	@Test
	def void DualFGSFaultTreeCriticalTest() {
		val start = "state CriticalModeFailure"
		val ft = CreateFTAModel.createFaultTree(instanceDualFGS, start)
		assertEquals(ft.events.size, 10)
		assertEquals(ft.root.subEvents.size, 3)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		val sube1 = ft.root.subEvents.get(0)
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertEquals(sube1.subEvents.size, 2)
		val subsube2 = sube1.subEvents.get(1)
		assertEquals(subsube2.subEvents.size, 2)
		assertEquals(subsube2.subEventLogic, LogicOperation.OR)
		val sube31 = subsube2.subEvents.get(0)
		assertTrue(sube31.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube31.relatedEMV2Object as NamedElement).name, "Failure")
		assertEquals((sube31.relatedInstanceObject as NamedElement).name, "AP2")
		val sube32 = subsube2.subEvents.get(1)
		assertTrue(sube32.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube32.relatedEMV2Object as NamedElement).name, "Failure")
		assertEquals((sube32.relatedInstanceObject as NamedElement).name, "FG2")
		val sube2 = ft.root.subEvents.get(1)
		assertTrue(sube2.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube2.relatedEMV2Object as NamedElement).name, "Failure")
		assertEquals((sube2.relatedInstanceObject as NamedElement).name, "AC")
		val sube3 = ft.root.subEvents.get(2)
		assertTrue(sube3.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((sube3.relatedEMV2Object as NamedElement).name, "Failure")
		assertEquals((sube3.relatedInstanceObject as NamedElement).name, "network")
	}

	@Test
	def void DualFGSFaultTraceCriticalTest() {
		val start = "state CriticalModeFailure"
		val ft = CreateFTAModel.createFaultTrace(instanceDualFGS, start)
		assertEquals(ft.events.size, 16)
		assertEquals(ft.root.subEvents.size, 3)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		val sube1 = ft.root.subEvents.get(2)
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertEquals(sube1.subEvents.size, 2)
		val subsube2 = sube1.subEvents.get(1)
		assertEquals(subsube2.subEvents.size, 2)
		assertEquals(subsube2.subEventLogic, LogicOperation.OR)
		val sube31 = subsube2.subEvents.get(0)
		assertTrue(sube31.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube31.relatedEMV2Object as NamedElement).name, "Failed")
		assertEquals((sube31.relatedInstanceObject as NamedElement).name, "AP2")
		val sube32 = subsube2.subEvents.get(1)
		assertTrue(sube32.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube32.relatedEMV2Object as NamedElement).name, "Failed")
		assertEquals((sube32.relatedInstanceObject as NamedElement).name, "FG2")
		val sube2 = ft.root.subEvents.get(0)
		assertTrue(sube2.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube2.relatedEMV2Object as NamedElement).name, "Failed")
		assertEquals((sube2.relatedInstanceObject as NamedElement).name, "AC")
		val subev2 = sube2.subEvents.get(0)
		assertTrue(subev2.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((subev2.relatedEMV2Object as NamedElement).name, "Failure")
		assertEquals((subev2.relatedInstanceObject as NamedElement).name, "AC")
		val sube3 = ft.root.subEvents.get(1)
		assertTrue(sube3.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube3.relatedEMV2Object as NamedElement).name, "Failed")
		assertEquals((sube3.relatedInstanceObject as NamedElement).name, "network")
	}

	@Test
	def void DualFGSPartsFaultTreeCriticalTest() {
		val start = "state CriticalModeFailure"
		val ft = CreateFTAModel.createPartsFaultTree(instanceDualFGS, start)
		assertEquals(ft.events.size, 10)
		assertEquals(ft.root.subEvents.size, 3)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		val sube1 = ft.root.subEvents.get(2)
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertEquals(sube1.subEvents.size, 2)
		val subsube2 = sube1.subEvents.get(1)
		assertEquals(subsube2.subEvents.size, 2)
		assertEquals(subsube2.subEventLogic, LogicOperation.OR)
		val sube31 = subsube2.subEvents.get(0)
		assertTrue(sube31.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube31.relatedEMV2Object as NamedElement).name, "Failed")
		assertEquals((sube31.relatedInstanceObject as NamedElement).name, "AP2")
		val sube32 = subsube2.subEvents.get(1)
		assertTrue(sube32.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube32.relatedEMV2Object as NamedElement).name, "Failed")
		assertEquals((sube32.relatedInstanceObject as NamedElement).name, "FG2")
		val sube2 = ft.root.subEvents.get(0)
		assertTrue(sube2.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube2.relatedEMV2Object as NamedElement).name, "Failed")
		assertEquals((sube2.relatedInstanceObject as NamedElement).name, "AC")
		val sube3 = ft.root.subEvents.get(1)
		assertTrue(sube3.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube3.relatedEMV2Object as NamedElement).name, "Failed")
		assertEquals((sube3.relatedInstanceObject as NamedElement).name, "network")
	}

	@Test
	def void DualFGSCutsetCriticalTest() {
		val start = "state CriticalModeFailure"
		val ft = CreateFTAModel.createMinimalCutSet(instanceDualFGS, start)
		assertEquals(13, ft.events.size)
		assertEquals(ft.root.subEvents.size, 6)
		val sube1 = ft.root.subEvents.get(0)
		assertEquals(sube1.subEvents.size, 2)
		val sube2 = ft.root.subEvents.get(1)
		assertEquals(sube1.subEvents.size, 2)
		val subsube1 = sube2.subEvents.get(0)
		assertTrue(subsube1.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((subsube1.relatedEMV2Object as NamedElement).name, "Failure")
		assertEquals((subsube1.relatedInstanceObject as NamedElement).name, "FG1")
		val subsube2 = sube2.subEvents.get(1)
		assertTrue(subsube2.relatedEMV2Object instanceof ErrorEvent)
		assertEquals((subsube2.relatedEMV2Object as NamedElement).name, "Failure")
		assertEquals((subsube2.relatedInstanceObject as NamedElement).name, "AP2")
		val sube3 = ft.root.subEvents.get(2)
		assertEquals(sube3.subEvents.size, 2)
		val sube4 = ft.root.subEvents.get(3)
		assertEquals(sube4.subEvents.size, 2)
		val sube5 = ft.root.subEvents.get(4)
		assertEquals(sube5.subEvents.size, 1)
		val sube6 = ft.root.subEvents.get(5)
		assertEquals(sube6.subEvents.size, 1)
	}

	@Test
	def void DualFGSFaultTreeNonCriticalTest() {
		val start = "state NonCriticalModeFailure"
		val ft = CreateFTAModel.createFaultTree(instanceDualFGS, start)
		assertEquals(ft.events.size, 16)
		assertEquals(ft.root.subEvents.size, 3)
		assertEquals(ft.root.subEventLogic, LogicOperation.AND)
		val sube1 = ft.root.subEvents.get(0)
		assertEquals(sube1.subEventLogic, LogicOperation.XOR)
		assertEquals(sube1.subEvents.size, 2)
		val subsube2 = sube1.subEvents.get(1)
		assertEquals(subsube2.subEvents.size, 3)
		assertEquals(subsube2.subEventLogic, LogicOperation.AND)
		val sube2 = ft.root.subEvents.get(1)
		assertTrue(sube2.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube2.relatedEMV2Object as NamedElement).name, "Operational")
		assertEquals((sube2.relatedInstanceObject as NamedElement).name, "AC")
		val sube3 = ft.root.subEvents.get(2)
		assertTrue(sube3.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube3.relatedEMV2Object as NamedElement).name, "Operational")
		assertEquals((sube3.relatedInstanceObject as NamedElement).name, "network")
	}

	@Test
	def void filteredFlowTest() {
		val start = "outgoing propagation on outport{NoValue}"
		val ft = CreateFTAModel.createFaultTrace(instanceFilteredFlow, start)
		assertEquals(ft.events.size, 9)
		assertEquals(ft.root.subEvents.size, 1)
		val sube1 = ft.root.subEvents.get(0)
		assertEquals(sube1.subEventLogic, LogicOperation.OR)
		assertEquals(sube1.subEvents.size, 2)
		val subsube1 = sube1.subEvents.get(0)
		assertEquals(subsube1.subEvents.size, 1)
		val subsubsube1 = subsube1.subEvents.get(0)
		assertEquals(subsubsube1.subEvents.size, 1)
	}

	@Test
	def void allFlowFaultTreeTest() {
		val start = "outgoing propagation on outport{ValueProblem}"
		val ft = CreateFTAModel.createFaultTree(instanceAllFlows, start)
		assertEquals(ft.events.size, 2)
		assertEquals(ft.root.subEvents.size, 1)
		val sube1 = ft.root.subEvents.get(0)
		assertTrue(sube1.type == EventType.EXTERNAL)
		assertTrue(sube1.relatedEMV2Object instanceof ErrorPropagation)
		assertEquals(EMV2Util.getPrintName(sube1.relatedEMV2Object as NamedElement), "inport")
	}

	@Test
	def void allFlowFaultTraceTest() {
		val start = "outgoing propagation on outport{ValueProblem}"
		val ft = CreateFTAModel.createFaultTrace(instanceAllFlows, start)
		assertEquals(11,ft.events.size)
		assertEquals(ft.root.subEvents.size, 1)
		val sube1 = ft.root.subEvents.get(0)
		assertEquals(sube1.subEventLogic, LogicOperation.OR)
		assertEquals(sube1.subEvents.size, 3)
		val sube11 = sube1.subEvents.get(0)
		assertTrue(sube11.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube11.relatedEMV2Object as NamedElement).name, "FailStop")
		val sube12 = sube1.subEvents.get(1)
		assertTrue(sube12.relatedEMV2Object instanceof ErrorPropagation)
		assertEquals(EMV2Util.getPrintName(sube12.relatedEMV2Object as NamedElement), "FromAP1Port")
		val sube13 = sube1.subEvents.get(2)
		assertTrue(sube13.relatedEMV2Object instanceof ErrorPropagation)
		assertEquals(EMV2Util.getPrintName(sube13.relatedEMV2Object as NamedElement), "FromAP2Port")
	}

	@Test
	def void allOptimizeFaultTreeTest1() {
		val stateFailStop = "state FailStop"
		val ft = CreateFTAModel.createFaultTree(instanceOptimize, stateFailStop)
		assertEquals(ft.events.size, 5)
		assertEquals(ft.root.subEvents.size, 2)
		assertEquals(ft.root.subEventLogic, LogicOperation.AND)
		val sube1 = ft.root.subEvents.get(0)
		assertEquals(sube1.subEventLogic, LogicOperation.OR)
		assertEquals(sube1.subEvents.size, 2)
		val sube11 = sube1.subEvents.get(0)
		assertTrue(sube11.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube11.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube11.relatedInstanceObject as NamedElement).name, "Sub2")
		val sube12 = sube1.subEvents.get(1)
		assertTrue(sube12.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube12.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube12.relatedInstanceObject as NamedElement).name, "Sub3")
		val sube2 = ft.root.subEvents.get(1)
		assertTrue(sube2.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube2.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube2.relatedInstanceObject as NamedElement).name, "Sub1")
	}

	@Test
	def void allOptimizeFaultTraceTest2() {
		val stateFailStop = "state Fail1"
		val ft = CreateFTAModel.createFaultTree(instanceOptimize, stateFailStop)
		assertEquals(ft.events.size, 5)
		assertEquals(ft.root.subEvents.size, 2)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		val sube1 = ft.root.subEvents.get(0)
		assertEquals(sube1.subEventLogic, LogicOperation.AND)
		assertEquals(sube1.subEvents.size, 2)
		val sube11 = sube1.subEvents.get(0)
		assertTrue(sube11.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube11.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube11.relatedInstanceObject as NamedElement).name, "Sub2")
		val sube12 = sube1.subEvents.get(1)
		assertTrue(sube12.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube12.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube12.relatedInstanceObject as NamedElement).name, "Sub3")
		val sube2 = ft.root.subEvents.get(1)
		assertTrue(sube2.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube2.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube2.relatedInstanceObject as NamedElement).name, "Sub1")
	}

	@Test
	def void allOptimizeFaultTraceTest3() {
		val stateFailStop = "state Fail2"
		val ft = CreateFTAModel.createFaultTree(instanceOptimize, stateFailStop)
		assertEquals(ft.events.size, 5)
		assertEquals(ft.root.subEvents.size, 2)
		assertEquals(ft.root.subEventLogic, LogicOperation.AND)
		val sube1 = ft.root.subEvents.get(0)
		assertEquals(sube1.subEventLogic, LogicOperation.XOR)
		assertEquals(sube1.subEvents.size, 2)
		val sube11 = sube1.subEvents.get(0)
		assertTrue(sube11.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube11.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube11.relatedInstanceObject as NamedElement).name, "Sub2")
		val sube12 = sube1.subEvents.get(1)
		assertTrue(sube12.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube12.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube12.relatedInstanceObject as NamedElement).name, "Sub3")
		val sube2 = ft.root.subEvents.get(1)
		assertTrue(sube2.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube2.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube2.relatedInstanceObject as NamedElement).name, "Sub1")
	}

	@Test
	def void allOptimizeFaultTraceTest4() {
		val stateFailStop = "state Fail3"
		val ft = CreateFTAModel.createFaultTree(instanceOptimize, stateFailStop)
		assertEquals(ft.events.size, 10)
		assertEquals(ft.root.subEvents.size, 2)
		assertEquals(ft.root.subEventLogic, LogicOperation.AND)
		val sube1 = ft.root.subEvents.get(0)
		assertEquals(sube1.subEventLogic, LogicOperation.XOR)
		assertEquals(sube1.subEvents.size, 2)
		val sube11 = sube1.subEvents.get(0)
		assertEquals(sube11.subEvents.size, 3)
		assertEquals(sube11.subEventLogic, LogicOperation.OR)
		val sube111 = sube11.subEvents.get(2)
		assertEquals(sube111.subEvents.size, 2)
		assertEquals(sube111.subEventLogic, LogicOperation.AND)
		val sube12 = sube1.subEvents.get(1)
		assertTrue(sube12.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube12.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube12.relatedInstanceObject as NamedElement).name, "Sub3")
		val sube2 = ft.root.subEvents.get(1)
		assertTrue(sube2.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube2.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube2.relatedInstanceObject as NamedElement).name, "Sub1")
	}

	@Test
	def void allOptimizeFaultTraceTest5() {
		val stateFailStop = "state Fail4"
		val ft = CreateFTAModel.createFaultTree(instanceOptimize, stateFailStop)
		assertEquals(ft.events.size, 2)
		assertEquals(ft.root.subEvents.size, 1)
		val sube1 = ft.root.subEvents.get(0)
		assertTrue(sube1.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube1.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube1.relatedInstanceObject as NamedElement).name, "Sub1")
	}

	@Test
	def void allOptimizeFaultTraceTest6() {
		val stateFailStop = "state Fail5"
		val ft = CreateFTAModel.createFaultTree(instanceOptimize, stateFailStop)
		assertEquals(4, ft.events.size)
		assertEquals(ft.root.subEvents.size, 2)
		val sube1 = ft.root.subEvents.get(0)
		assertEquals(sube1.subEventLogic, LogicOperation.XOR)
		assertEquals(sube1.subEvents.size, 2)
		val sube11 = sube1.subEvents.get(0)
		val sube12 = sube1.subEvents.get(1)
		assertTrue(sube11.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube11.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube11.relatedInstanceObject as NamedElement).name, "Sub1")
		assertTrue(sube12.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube12.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube12.relatedInstanceObject as NamedElement).name, "Sub6")
		val sube2 = ft.root.subEvents.get(1)
		assertTrue(sube2.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube2.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube2.relatedInstanceObject as NamedElement).name, "Sub1")
	}

	@Test
	def void allOptimizeFaultTraceTest7() {
		val stateFailStop = "state Fail6"
		val ft = CreateFTAModel.createFaultTree(instanceOptimize, stateFailStop)
		assertEquals(ft.events.size, 6)
		assertEquals(ft.root.subEvents.size, 2)
		val sube1 = ft.root.subEvents.get(1)
		assertEquals(sube1.subEventLogic, LogicOperation.OR)
		assertEquals(sube1.subEvents.size, 3)
		val sube11 = sube1.subEvents.get(0)
		val sube12 = sube1.subEvents.get(1)
		val sube13 = sube1.subEvents.get(2)
		assertTrue(sube11.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube11.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube11.relatedInstanceObject as NamedElement).name, "Sub2")
		assertTrue(sube12.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube12.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube12.relatedInstanceObject as NamedElement).name, "Sub4")
		assertTrue(sube13.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube13.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube13.relatedInstanceObject as NamedElement).name, "Sub6")
		val sube2 = ft.root.subEvents.get(0)
		assertTrue(sube2.relatedEMV2Object instanceof ErrorBehaviorState)
		assertEquals((sube2.relatedEMV2Object as NamedElement).name, "FailStop")
		assertEquals((sube2.relatedInstanceObject as NamedElement).name, "Sub1")
	}

	@Test
	def void allTransitionBranchFaultTreeTest() {
		val stateFailStop = "state FailStop"
		val ft = CreateFTAModel.createFaultTree(instanceTransitionBranch, stateFailStop)
		assertEquals(ft.events.size, 5)
		assertEquals(ft.root.subEvents.size, 2)
		val sube1 = ft.root.subEvents.get(0)
		val asube1 = sube1.subEvents.get(0)
		val asube2 = sube1.subEvents.get(1)
		assertEquals(ft.root.computedProbability.doubleValue, 6.0e-8, 1.0e-12)
		assertEquals(sube1.computedProbability.doubleValue, 9.0e-16, 1.0e-20)
		assertEquals(asube1.scale.doubleValue, 0.6, 0.001)
		assertEquals(asube2.scale.doubleValue, 0.6, 0.001)
	}

	@Test
	def void allTransitionBranchCutSetTest() {
		val stateFailStop = "state FailStop"
		val ft = CreateFTAModel.createMinimalCutSet(instanceTransitionBranch, stateFailStop)
		assertEquals(ft.events.size, 6)
		assertEquals(ft.root.subEvents.size, 2)
		val sube1 = ft.root.subEvents.get(0)
		val asube1 = sube1.subEvents.get(0)
		val asube2 = sube1.subEvents.get(1)
		assertEquals(ft.root.computedProbability.doubleValue, 6.0e-8, 1.0e-12)
		assertEquals(sube1.computedProbability.doubleValue, 9.0e-16, 1.0e-20)
		assertEquals(asube1.scale.doubleValue, 0.6, 0.001)
		assertEquals(asube2.scale.doubleValue, 0.6, 0.001)
	}

	@Test
	def void OR1OFProbabilityFaultTreeTest() {
		val outProp = "outgoing propagation on o{BadData}"
		val ft = CreateFTAModel.createFaultTree(instanceOR1OFProbability, outProp)
		assertEquals(ft.events.size, 9)
		assertEquals(ft.root.subEvents.size, 2)
		val sube1 = ft.root.subEvents.get(1)
		assertEquals(ft.root.computedProbability.doubleValue, 1.30285e-1, 1.0e-5)
		assertEquals(sube1.computedProbability.doubleValue, 1.215e-1, 1.0e-5)
	}

	@Test
	def void PathProbabilityFaultTreeTest() {
		val outProp = "state FaultyState"
		val ft = CreateFTAModel.createFaultTree(instancePathProbability, outProp)
		assertEquals(ft.events.size, 5)
		assertEquals(ft.root.subEvents.size, 4)
		val sube3 = ft.root.subEvents.get(2)
		val sube4 = ft.root.subEvents.get(3)
		assertEquals(ft.root.computedProbability.doubleValue, 9.79e-7, 1.0e-10)
		assertEquals(sube3.scale.doubleValue, 0.7, 0.001)
		assertEquals(sube4.scale.doubleValue, 0.6, 0.001)
	}

	@Test
	def void issue1819Test() {
		val ft = CreateFTAModel.createFaultTree(instanceIssue1819, "outgoing propagation on effect{ServiceOmission}")
		assertEquals(ft.events.size, 3)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		assertEquals((ft.root.subEvents.head.relatedEMV2Object as NamedElement).name, "heaterfails")
		assertEquals((ft.root.subEvents.head.relatedInstanceObject as NamedElement).name, "heater")
	}

	@Test
	def void issue1882Test() {
		val ft = CreateFTAModel.createFaultTree(instanceIssue1882, "outgoing propagation on aceffect{ServiceOmission}")
		assertEquals(ft.events.size, 3)
		assertEquals(ft.root.subEventLogic, LogicOperation.AND)
		assertEquals((ft.root.subEvents.head.relatedEMV2Object as NamedElement).name, "engineFailure")
		assertEquals((ft.root.subEvents.head.relatedInstanceObject as NamedElement).name, "engine1")
	}

	@Test
	def void issue1893Test() {
		val ft = CreateFTAModel.createFaultTree(instanceIssue1893, "outgoing propagation on location{ServiceOmission}")
		assertEquals(ft.events.size, 11)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		assertEquals(ft.root.subEvents.size, 8)
		val andnode = ft.root.subEvents.get(1)
		assertEquals(andnode.subEventLogic, LogicOperation.AND)
		assertEquals(andnode.subEvents.size, 2)
	}

	@Test
	def void issue1913Test() {
		val ft = CreateFTAModel.createFaultTree(instanceIssue1913, "outgoing propagation on effect{Bad}")
		assertEquals(ft.events.size, 1)
	}

	@Test
	def void issue1915Test() {
		val ft = CreateFTAModel.createFaultTree(instanceIssue1915, "outgoing propagation on effect{Bad}")
		assertEquals(ft.events.size, 2)
		val faultsource = ft.root.subEvents.get(0)
		assertEquals((faultsource.relatedEMV2Object as NamedElement).name, "d")
		assertEquals(EMV2Util.getName(faultsource.relatedErrorType as TypeToken), "ClFail")
	}

	@Test
	def void issue1899Test() {
		val ft = CreateFTAModel.createFaultTree(instanceIssue1899, "outgoing propagation on msg{ServiceOmission}")
		assertEquals(ft.events.size, 6)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		assertEquals(ft.root.subEvents.size, 5)
	}

	@Test
	def void issue1837Test() {
		val ft = CreateFTAModel.createFaultTree(instanceIssue1837, "state FailStop")
		assertEquals(ft.events.size, 6)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		assertEquals(ft.root.computedProbability.doubleValue, 1.04e-1, 0.01)
		assertEquals(ft.root.subEvents.get(0).subEventLogic, LogicOperation.KORMORE)
	}

	@Test
	def void issue1837bisTest() {
		val ft = CreateFTAModel.createFaultTree(instanceIssue1837bis, "state FailStop")
		assertEquals(ft.events.size, 6)
		assertEquals(ft.root.subEventLogic, LogicOperation.OR)
		assertEquals(ft.root.computedProbability.doubleValue, 0.0414, 0.01)
		assertEquals(ft.root.subEvents.get(0).subEventLogic, LogicOperation.KORMORE)
	}

	@Test
	def void issue1962Test() {
		val ft = CreateFTAModel.createFaultTree(instanceIssue1962, "outgoing propagation on aceffect{ServiceOmission}")
		assertEquals(ft.events.size, 7)
		val pilotand = ft.root.subEvents.get(0)
		val errorevent = pilotand.subEvents.get(1)
		assertEquals((errorevent.relatedInstanceObject as NamedElement).name, "pilot")
		assertEquals((errorevent.relatedEMV2Object as NamedElement).name, "mistakes")
		assertEquals(EMV2Util.getName(errorevent.relatedErrorType as TypeToken), "TimingError")
	}


	@Test
	def void issue1961Test() {
		val ft = CreateFTAModel.createFaultTree(instanceIssue1961, "outgoing propagation on aceffect{ServiceOmission}")
		assertEquals(ft.events.size, 8)
		assertEquals(ft.root.subEvents.size,3)
		val pilotand1 = ft.root.subEvents.get(0)
		val pilotand2 = ft.root.subEvents.get(1)
		val engine = ft.root.subEvents.get(2)
		assertEquals(pilotand1.subEventLogic, LogicOperation.PRIORITY_AND)
		assertEquals(pilotand2.subEventLogic, LogicOperation.PRIORITY_AND)
		assertEquals((engine.relatedInstanceObject as NamedElement).name, "engine1")
		assertEquals((engine.relatedEMV2Object as NamedElement).name, "engineFailure")
		assertEquals(EMV2Util.getName(engine.relatedErrorType as TypeToken), "ServiceOmission")
	}

}
