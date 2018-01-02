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

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErrorModelUiInjectorProvider))
class Fta2Test extends OsateTest {
	override getProjectName() {
		"test2"
	}
	

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
		createFiles(aadlFile -> aadlText, errorlibFile -> errorlibText) 
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

		
		val uri =CreateFTAModel.createTransformedFTA(instance,state)
		val file = workspaceRoot.getFile(new Path(uri.toPlatformString(true)))
		val actual = Files.readStreamIntoString(file.contents)
		assertEquals('error', expected.trim, actual.trim)
	}

	val aadlText = '''
package fta2test
public


-- This test uses a composite error state declaration with an AND that references
-- the last two subcomponents in a flow. For each we trace backward along propagations
-- to include the input to the subcomponent.

data mydata
end mydata;

system s
features
	datain : in data port mydata; 
annex EMV2 {**
	use types ErrorModelLibrary;
	use behavior ErrorModelLibrary::Simple;
	
	error propagations
		datain : in propagation {BadValue};
	flows
		f0 : error sink datain {BadValue};
	end propagations;
	component error behavior
	transitions
		t0 : Operational -[datain{BadValue}]-> Failed;
	end component;
**};
end s;

device sensor
features
	dataout : out data port mydata;
annex EMV2 {**
	use types ErrorModelLibrary;
	use behavior ErrorModelLibrary::Simple;
	error propagations
		dataout : out propagation {BadValue};
	flows
		f0 : error source dataout {BadValue};
	end propagations;
**};	
end sensor;

system main
end main;

system implementation main.i
subcomponents
	s1 : system s;
	s2 : system s;
	sens1 : device sensor;
	sens2 : device sensor;
connections
	c0 : port sens1.dataout -> s1.datain;
	c1 : port sens2.dataout -> s2.datain;
annex EMV2 {**
	use types ErrorModelLibrary;
	use behavior ErrorModelLibrary::Simple;
	
	composite error behavior
		states
			[s1.Failed and s2.Failed]-> Failed;
		end composite;  
	
**};
end main.i;

end fta2test;
	'''

	val errorlibText = '''
package ErrorModelLibrary
public
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

end ErrorModelLibrary;
	'''

	val expected = '''
<?xml version="1.0" encoding="ASCII"?>
<FaultTree:FaultTree xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:FaultTree="http://www.aadl.info/FaultTree" name="fta2test_main_i-failed" description="Top Level Failure" root="//@events.6">
  <events name="sens1-f0-badvalue" description="Component 'sens1' failure source 'BadValue'" referenceCount="1">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.0"/>
    <relatedErrorType href="../../../fta2Test.aadl#/0/@ownedPublicSection/@ownedClassifier.1/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@transitions.0/@condition/@constraint"/>
    <relatedEMV2Object href="../../../fta2Test.aadl#/0/@ownedPublicSection/@ownedClassifier.2/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.0"/>
  </events>
  <events name="s1-failure" description="Component 's1' failure event 'Failure'" referenceCount="1">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.2"/>
    <relatedEMV2Object href="../../../ErrorModellibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="s1-failed" description="Component 's1' in failure mode 'Failed'" subEvents="//@events.1 //@events.0" referenceCount="1" type="Intermediate">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.2"/>
    <relatedEMV2Object href="../../../ErrorModellibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@states.1"/>
  </events>
  <events name="sens2-f0-badvalue" description="Component 'sens2' failure source 'BadValue'" referenceCount="1">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.1"/>
    <relatedErrorType href="../../../fta2Test.aadl#/0/@ownedPublicSection/@ownedClassifier.1/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@transitions.0/@condition/@constraint"/>
    <relatedEMV2Object href="../../../fta2Test.aadl#/0/@ownedPublicSection/@ownedClassifier.2/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.0"/>
  </events>
  <events name="s2-failure" description="Component 's2' failure event 'Failure'" referenceCount="1">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.3"/>
    <relatedEMV2Object href="../../../ErrorModellibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="s2-failed" description="Component 's2' in failure mode 'Failed'" subEvents="//@events.4 //@events.3" referenceCount="1" type="Intermediate">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#//@componentInstance.3"/>
    <relatedEMV2Object href="../../../ErrorModellibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@states.1"/>
  </events>
  <events name="fta2test_main_i-failed" subEvents="//@events.2 //@events.5" referenceCount="1" type="Intermediate" subEventLogic="And">
    <relatedInstanceObject href="../../fta2Test_main_i_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../fta2Test.aadl#/0/@ownedPublicSection/@ownedClassifier.4/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@states.0/@condition"/>
  </events>
</FaultTree:FaultTree>
	'''
}
