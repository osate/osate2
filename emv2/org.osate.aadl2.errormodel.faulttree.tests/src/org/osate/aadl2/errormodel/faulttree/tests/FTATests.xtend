package org.osate.aadl2.errormodel.faulttree.tests

import org.eclipse.core.runtime.Path
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.util.Files
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.errormodel.faulttree.generation.CreateFTAModel
import org.osate.aadl2.errormodel.tests.ErrorModelUiInjectorProvider
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.OsateTest

import static org.junit.Assert.*
import org.eclipse.emf.ecore.util.EcoreUtil
import org.junit.Before
import org.junit.After
import org.osate.aadl2.instance.SystemInstance

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErrorModelUiInjectorProvider))
class FTATests extends OsateTest {
	override getProjectName() {
		"FTATests"
	}

	static boolean once = true
	
	val static modelroot = "org.osate.aadl2.errormodel.faulttree.tests/models/FTATests/"

//	var static FluentIssueCollection result
	var static SystemInstance instance

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
		val fta1File = "fta1Test.aadl"
		val fta2File = "fta2Test.aadl"
		val errorlibFile = "ErrorModellibrary.aadl"
		createFiles(fta1File -> readFile(modelroot + fta1File), fta2File -> readFile(modelroot + fta2File),errorlibFile -> readFile(modelroot + errorlibFile)) 
		suppressSerialization
		val result = testFile(fta1File ,errorlibFile,fta2File  )

		// get the correct package
		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'main.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'main.i'] as SystemImplementation
		instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		}
	}
	
	

/**
 * example of simple composite error state with an AND operator.
 * The subcomponents have two states and a transition triggered by an error event.
 * The error event is a Basic Event.
 */
	@Test
	def void fta1Test() {

		val state = "state Failed"
		val ft = CreateFTAModel.createFaultTree(instance,state)
		val testuri = EcoreUtil.getURI(ft)
		val file = workspaceRoot.getFile(new Path(testuri.toPlatformString(true)))
		val actual = Files.readStreamIntoString(file.contents)
		assertEquals('error', expectedfta1.trim, actual.trim)
	}


	val expectedfta1 = '''
<?xml version="1.0" encoding="ASCII"?>
<FaultTree:FaultTree xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:FaultTree="http://www.aadl.info/FaultTree" name="fta1test_main_i-failed_tree" root="//@events.2">
  <instanceRoot href="../../fta1Test_main_i_Instance.aaxl2#/"/>
  <events name="s1-failure" referenceCount="1">
    <relatedInstanceObject href="../../fta1Test_main_i_Instance.aaxl2#//@componentInstance.0"/>
    <relatedEMV2Object href="../../../fta1Test.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="s2-failure" referenceCount="1">
    <relatedInstanceObject href="../../fta1Test_main_i_Instance.aaxl2#//@componentInstance.1"/>
    <relatedEMV2Object href="../../../fta1Test.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="fta1test_main_i-failed" subEvents="//@events.0 //@events.1" referenceCount="1" type="Intermediate" subEventLogic="And">
    <relatedInstanceObject href="../../fta1Test_main_i_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../fta1Test.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@states.1"/>
  </events>
</FaultTree:FaultTree>
	'''
}
