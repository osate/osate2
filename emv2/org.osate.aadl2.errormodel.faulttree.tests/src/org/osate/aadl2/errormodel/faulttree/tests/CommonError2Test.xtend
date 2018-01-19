package org.osate.aadl2.errormodel.faulttree.tests

import org.eclipse.core.runtime.Path
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.util.Files
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.errormodel.tests.ErrorModelUiInjectorProvider
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.OsateTest

import static org.junit.Assert.*
import org.osate.aadl2.errormodel.faulttree.generation.CreateFTAModel
import org.eclipse.emf.ecore.util.EcoreUtil

@RunWith(XtextRunner)
@InjectWith(typeof(ErrorModelUiInjectorProvider))
class CommonError2Test extends OsateTest {
	override getProjectName() {
		"CommonError2Test"
	}
	
	

/**
-- example with composite error state to the last subcomponents that affect the system error state
-- other components are included based on backward flow. 
-- Each of those components has its own error state machine with error events.
 * We are generating FailStop.
 */
	@Test
	def void commonerrorfta() {
		val aadlFile = "common-error2.aadl"
		val state = "state FailStop"
		createFiles(aadlFile -> aadlText) // TODO add all files to workspace
		suppressSerialization
		val result = testFile(aadlFile /*, referencedFile1, referencedFile2, etc. */ )

		// get the correct package
		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'main.commonevents'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'main.commonevents'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
//		assertEquals("fta_main_i_Instance", instance.name)

		
		val ft = CreateFTAModel.createFaultTree(instance,state)
		val uri = EcoreUtil.getURI(ft)
		val file = workspaceRoot.getFile(new Path(uri.toPlatformString(true)))
		val actual = Files.readStreamIntoString(file.contents)
		assertEquals('error', expected.trim, actual.trim)
		
	}

	val aadlText = '''
package common_error2
public

data mydata
end mydata;

device sensor
features
	valueout : out data port mydata;
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;
 	error propagations
 		valueout : out propagation {LateDelivery,ServiceError};
 	flows
 		ef0 : error source valueout{LateDelivery};
 	end propagations;
 	component error behavior
 	propagations
 	FailStop -[]-> valueout{ServiceError};
	end component;
 **};
end sensor;


system computing
features
	valuein : in data port mydata;
	valueout1 : out data port mydata;
	valueout2 : out data port mydata;
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;
	error propagations
 		valuein : in propagation {LateDelivery,ServiceError};
 		valueout1 : out propagation {ServiceError};
 		valueout2 : out propagation {ServiceError};
 	flows
 		ef0 : error path valuein{LateDelivery,ServiceError} -> valueout1{ServiceError};
 		ef1 : error path valuein{LateDelivery,ServiceError} -> valueout2{ServiceError};
 	end propagations;
 	component error behavior
 	propagations
 	FailStop -[]-> valueout1{ServiceError};
 	FailStop -[]-> valueout2{ServiceError};
 	end component;
 **};
end computing;


device actuator
features
	valuein : in data port mydata;
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;
 	error propagations
 		valuein : in propagation {ServiceError};
 	flows
 		ef0 : error sink valuein{ServiceError};
 	end propagations;
 	
 	component error behavior
 	transitions
 		t0 : operational -[valuein{ServiceError}]-> failstop;
 	end component;
 	
 **};
end actuator;

system main
end main;

-- example with composite error state to the last subcomponents that affect the system error state
-- other components are included based on backward flow. 
-- Each of those components has its own error state machine with error events.
system implementation main.commonevents
subcomponents
	s0 : device sensor;
	c0 : system computing;
	a0 : device actuator;
	a1 : device actuator;
connections
	conn0 : port s0.valueout -> c0.valuein;
	conn1 : port c0.valueout1 -> a0.valuein;
	conn2 : port c0.valueout2 -> a1.valuein;
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;
 	
 	
 	composite error behavior
 	states
 		[a0.failstop and a1.failstop ]-> failstop;
 	end composite;
 **};
end main.commonevents;


end common_error2;
	'''

	val expected = '''
<?xml version="1.0" encoding="ASCII"?>
<FaultTree:FaultTree xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:FaultTree="http://www.aadl.info/FaultTree" name="common_error2_main_commonevents-failstop_tree" root="//@events.4">
  <instanceRoot href="../../common-error2_main_commonevents_Instance.aaxl2#/"/>
  <events name="c0-failure" referenceCount="1">
    <relatedInstanceObject href="../../common-error2_main_commonevents_Instance.aaxl2#//@componentInstance.3"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="a0-failure" referenceCount="1">
    <relatedInstanceObject href="../../common-error2_main_commonevents_Instance.aaxl2#//@componentInstance.1"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="a1-failure" referenceCount="1">
    <relatedInstanceObject href="../../common-error2_main_commonevents_Instance.aaxl2#//@componentInstance.2"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="Intermediate1" subEvents="//@events.1 //@events.2" referenceCount="1" type="Intermediate" subEventLogic="And">
    <relatedInstanceObject href="../../common-error2_main_commonevents_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../common-error2.aadl#/0/@ownedPublicSection/@ownedClassifier.5/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@states.0/@condition"/>
  </events>
  <events name="common_error2_main_commonevents-failstop" subEvents="//@events.3 //@events.0" referenceCount="1" type="Intermediate">
    <relatedInstanceObject href="../../common-error2_main_commonevents_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@states.1"/>
  </events>
</FaultTree:FaultTree>
	'''

}
