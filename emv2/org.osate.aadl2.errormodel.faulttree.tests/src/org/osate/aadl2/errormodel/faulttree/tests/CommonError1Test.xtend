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
import org.osate.aadl2.util.OsateDebug
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.errormodel.util.EMV2Util

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(ErrorModelUiInjectorProvider)
class CommonError1Test extends OsateTest {
	override getProjectName() {
		"CommonError1Test"
	}
	

/**
 * example with composite error state to the last subcomponents that affect the system error state
 * other components are included based on backward flow. 
 * The sensor contribution is based on an error source declaration.
 * We are generating FailStop.
 * 
 * We also test for Operational state. 
 */
	@Test
	def void commonerrorfta() {
		val aadlFile = "common-error1.aadl"
		val state = "state FailStop"
		createFiles(aadlFile -> aadlText) // TODO add all files to workspace
		suppressSerialization
		val result = testFile(aadlFile /*, referencedFile1, referencedFile2, etc. */ )

	  // get the correct package
		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'main.commonsource'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'main.commonsource'] as SystemImplementation

	// XXX get the EMV2 annex subclause
	// Similar to the EMV2 tests
	// When running a release build it returns null
	// works fine when running it as JUnit plugin test
		val res = EMV2Util.getEmbeddedEMV2Subclause(sysImpl)


		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
//		assertEquals("fta_main_i_Instance", instance.name)
		
		val uri =CreateFTAModel.createTransformedFTA(instance,state)
		
		val file = workspaceRoot.getFile(new Path(uri.toPlatformString(true)))
		val actual = Files.readStreamIntoString(file.contents)
		assertEquals('error', expected.trim, actual.trim)
		
		val stateop = "state Operational"
		val uriop=CreateFTAModel.createTransformedFTA(instance, stateop)
		
		val fileop = workspaceRoot.getFile(new Path(uriop.toPlatformString(true)))
		val actualop = Files.readStreamIntoString(fileop.contents)
		assertEquals('error', expectedOperational.trim, actualop.trim)
	}

	val aadlText = '''
package common_error1
public

data mydata
end mydata;

device sensor
features
	valueout : out data port mydata;
annex EMV2{**
 	use types ErrorLibrary;
 	error propagations
 		valueout : out propagation {LateDelivery};
 	flows
 		ef0 : error source valueout{LateDelivery};
 	end propagations;
 **};
end sensor;


system computing
features
	valuein : in data port mydata;
	valueout1 : out data port mydata;
	valueout2 : out data port mydata;
annex EMV2{**
 	use types ErrorLibrary;
	error propagations
 		valuein : in propagation {LateDelivery};
 		valueout1 : out propagation {ServiceError};
 		valueout2 : out propagation {ServiceError};
 	flows
 		ef0 : error path valuein{LateDelivery} -> valueout1{ServiceError};
 		ef1 : error path valuein{LateDelivery} -> valueout2{ServiceError};
 	end propagations;
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
-- The sensor contribution is based on an error source declaration.
system implementation main.commonsource
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
end main.commonsource;


end common_error1;
	'''

	val expected = '''
<?xml version="1.0" encoding="ASCII"?>
<FaultTree:FaultTree xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:FaultTree="http://www.aadl.info/FaultTree" name="common_error1_main_commonsource-failstop" description="Top Level Failure" root="//@events.3">
  <events name="s0-ef0-latedelivery" description="Component 's0' failure source 'LateDelivery'" referenceCount="1">
    <relatedInstanceObject href="../../common-error1_main_commonsource_Instance.aaxl2#//@componentInstance.0"/>
    <relatedErrorType href="../../../common-error1.aadl#/0/@ownedPublicSection/@ownedClassifier.2/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.0/@typeTokenConstraint"/>
    <relatedEMV2Object href="../../../common-error1.aadl#/0/@ownedPublicSection/@ownedClassifier.1/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.0"/>
  </events>
  <events name="a0-failure" description="Component 'a0'" referenceCount="1">
    <relatedInstanceObject href="../../common-error1_main_commonsource_Instance.aaxl2#//@componentInstance.1"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="a1-failure" description="Component 'a1'" referenceCount="1">
    <relatedInstanceObject href="../../common-error1_main_commonsource_Instance.aaxl2#//@componentInstance.2"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="common_error1_main_commonsource-failstop" description="Component 'main.commonsource' in failure mode 'FailStop'" subEvents="//@events.1 //@events.0 //@events.2" referenceCount="1" type="Intermediate">
    <relatedInstanceObject href="../../common-error1_main_commonsource_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@states.1"/>
  </events>
</FaultTree:FaultTree>	'''

	val expectedOperational = '''
<?xml version="1.0" encoding="ASCII"?>
<FaultTree:FaultTree xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:FaultTree="http://www.aadl.info/FaultTree" name="common_error1_main_commonsource-operational" description="Top Level Failure" root="//@events.0">
  <events name="common_error1_main_commonsource-operational" description="Component 'main.commonsource' in failure mode 'Operational'" referenceCount="1" type="Intermediate">
    <relatedInstanceObject href="../../common-error1_main_commonsource_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@states.0"/>
  </events>
</FaultTree:FaultTree>	'''
}
