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

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErrorModelUiInjectorProvider))
class Fta2Test extends OsateTest {
	override getProjectName() {
		"test2"
	}
	
	val static modelroot = "org.osate.aadl2.errormodel.faulttree.tests/models/FTATests/"

/**
 * This test uses a composite error state declaration with an AND that references
 * the last two subcomponents in a flow. For each we trace backward along propagations
 * to include the input to the subcomponent.
 */
	@Test
	def void basicfta() {
		val aadlFile = "fta2Test.aadl"
		val errorlibFile = "ErrorModellibrary.aadl"
		val state = "state Failed"
		createFiles(aadlFile -> readFile(modelroot + aadlFile), errorlibFile -> readFile(modelroot + errorlibFile)) 
		suppressSerialization
		val result = testFile(aadlFile , errorlibFile /*, referencedFile1, referencedFile2, etc. */ )

		// get the correct package
		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'main.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'main.i'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
//		assertEquals("fta_main_i_Instance", instance.name)

		
		val ft = CreateFTAModel.createFaultTree(instance,state)
		val uri = EcoreUtil.getURI(ft)
		val file = workspaceRoot.getFile(new Path(uri.toPlatformString(true)))
		val actual = Files.readStreamIntoString(file.contents)
		assertEquals('error', expected.trim, actual.trim)
	}


	val expected = '''
<?xml version="1.0" encoding="ASCII"?>
<FaultTree:FaultTree xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:FaultTree="http://www.aadl.info/FaultTree" name="fta2test_main_i-failed_tree" root="//@events.9">
  <instanceRoot href="../../fta2Test_main_i_Instance.aaxl2#/"/>
  <events name="sens1-f0-badvalue" referenceCount="1">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.0"/>
    <relatedErrorType href="../../../fta2Test.aadl#/0/@ownedPublicSection/@ownedClassifier.1/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@transitions.0/@condition/@constraint"/>
    <relatedEMV2Object href="../../../fta2Test.aadl#/0/@ownedPublicSection/@ownedClassifier.2/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.0"/>
  </events>
  <events name="s1-failure" referenceCount="1">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.2"/>
    <relatedEMV2Object href="../../../ErrorModellibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="s1-failed" subEvents="//@events.1 //@events.0" referenceCount="1" type="Intermediate">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.2"/>
    <relatedEMV2Object href="../../../ErrorModellibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@states.1"/>
  </events>
  <events name="sens1-failure" referenceCount="1" sharedEvent="true">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.0"/>
    <relatedEMV2Object href="../../../ErrorModellibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="Intermediate1" subEvents="//@events.2 //@events.3" referenceCount="1" type="Intermediate" subEventLogic="Xor">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../fta2Test.aadl#/0/@ownedPublicSection/@ownedClassifier.4/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@states.0/@condition/@operands.0"/>
  </events>
  <events name="sens2-f0-badvalue" referenceCount="1">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.1"/>
    <relatedErrorType href="../../../fta2Test.aadl#/0/@ownedPublicSection/@ownedClassifier.1/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@transitions.0/@condition/@constraint"/>
    <relatedEMV2Object href="../../../fta2Test.aadl#/0/@ownedPublicSection/@ownedClassifier.2/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.0"/>
  </events>
  <events name="s2-failure" referenceCount="1">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.3"/>
    <relatedEMV2Object href="../../../ErrorModellibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="s2-failed" subEvents="//@events.6 //@events.5" referenceCount="1" type="Intermediate">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.3"/>
    <relatedEMV2Object href="../../../ErrorModellibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@states.1"/>
  </events>
  <events name="Intermediate2" subEvents="//@events.7 //@events.10" referenceCount="1" type="Intermediate" subEventLogic="Xor">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../fta2Test.aadl#/0/@ownedPublicSection/@ownedClassifier.4/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@states.0/@condition/@operands.1"/>
  </events>
  <events name="fta2test_main_i-failed" subEvents="//@events.4 //@events.8" referenceCount="1" type="Intermediate" subEventLogic="And">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../ErrorModellibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@states.1"/>
  </events>
  <events name="sens1-failure" referenceCount="1" sharedEvent="true">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.0"/>
    <relatedEMV2Object href="../../../ErrorModellibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
</FaultTree:FaultTree>
	'''
}
