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
class Fta1Test extends OsateTest {
	override getProjectName() {
		"test1"
	}
	
	

/**
 * example of simple composite error state with an AND operator.
 * The subcomponents have two states and a transition triggered by an error event.
 * The error event is a Basic Event.
 */
	@Test
	def void basicfta() {
		val aadlFile = "fta1Test.aadl"
		val state = "state Failed"
		createFiles(aadlFile -> aadlText) // TODO add all files to workspace
		suppressSerialization
		val result = testFile(aadlFile /*, referencedFile1, referencedFile2, etc. */ )

		// get the correct package
		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'main.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'main.i'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
//		assertEquals("fta_main_i_Instance", instance.name)

		val ft = CreateFTAModel.createTransformedFTA(instance,state)
		val testuri = EcoreUtil.getURI(ft)
		val file = workspaceRoot.getFile(new Path(testuri.toPlatformString(true)))
		val actual = Files.readStreamIntoString(file.contents)
		assertEquals('error', expected.trim, actual.trim)
	}

	val aadlText = '''
package fta1test


-- example of simple composite error state with an AND operator.
-- The subcomponents have two states and a transition triggered by an error event.
-- The error event is a Basic Event.


public

system s
annex EMV2 {**
	use types fta1test;
	use behavior fta1test::Simple;
**};
end s;

system main
end main;

system implementation main.i
subcomponents
	s1 : system s;
	s2 : system s;

annex EMV2 {**
	use types fta1test;
	use behavior fta1test::Simple;
	
	composite error behavior
		states
			[s1.Failed and s2.Failed]-> Failed;
		end composite;  
	
**};
end main.i;

annex EMV2 {**
	error types
		NoValue : type;
		BadValue : type;
		LateValue : type;
		NoService : type;
	end types;

	
	error behavior Simple
	events
		Failure : error event ;
	states
		Operational : initial state ;
		Failed : state ;
	transitions
		BadValueTransition : Operational -[ Failure ]-> Failed ;
	end behavior ;
		-- simple error model
	error behavior Basic
	events
	    Failure : error event;
	states
	    Operational: initial state;
	    Failed: state;
	transitions
	     Operational -[Failure]-> Failed;
	end behavior;
	
**};

end fta1test;
	'''

	val expected = '''
<?xml version="1.0" encoding="ASCII"?>
<FaultTree:FaultTree xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:FaultTree="http://www.aadl.info/FaultTree" name="fta1test_main_i-failed" description="Top Level Failure" root="//@events.2">
  <events name="s1-failure" description="Component 's1' failure event 'Failure'" referenceCount="1">
    <relatedInstanceObject href="../../fta1Test_main_i_Instance.aaxl2#//@componentInstance.0"/>
    <relatedEMV2Object href="../../../fta1Test.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="s2-failure" description="Component 's2' failure event 'Failure'" referenceCount="1">
    <relatedInstanceObject href="../../fta1Test_main_i_Instance.aaxl2#//@componentInstance.1"/>
    <relatedEMV2Object href="../../../fta1Test.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="fta1test_main_i-failed" subEvents="//@events.0 //@events.1" referenceCount="1" type="Intermediate" subEventLogic="And">
    <relatedInstanceObject href="../../fta1Test_main_i_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../fta1Test.aadl#/0/@ownedPublicSection/@ownedClassifier.2/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@states.0/@condition"/>
  </events>
  <instanceRoot href="../../fta1Test_main_i_Instance.aaxl2#/"/>
</FaultTree:FaultTree>
	'''
}
