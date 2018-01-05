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
class Redundant2Test extends OsateTest {
	override getProjectName() {
		"Redundant2Test"
	}
	
	

/**
-- composite error behavior specification
-- Does not pick up contributions from CPU, memory, bus since they do not affect the FailStop state of voter.
-- Those are propagated as flows through outgoing propagations rather than related to state.
-- The composite error behavior expression can be expanded to include them
 * We are generating FailStop.
 */
	@Test
	def void redundantfta() {
		val aadlFile = "redundant2.aadl"
		val errlibFile = "FTerrorlibrary.aadl"
		val state = "state FailStop"
		createFiles(aadlFile -> aadlText, errlibFile -> fterrlibText) // TODO add all files to workspace
		suppressSerialization
		val result = testFile(aadlFile, errlibFile /*, referencedFile1, referencedFile2, etc. */ )

		// get the correct package
		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'main2.composite'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'main2.composite'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
//		assertEquals("fta_main_i_Instance", instance.name)

		
		val ft = CreateFTAModel.createFaultTree(instance,state)
		val uri = EcoreUtil.getURI(ft)
		val file = workspaceRoot.getFile(new Path(uri.toPlatformString(true)))
		val actual = Files.readStreamIntoString(file.contents)
		assertEquals('error', expected.trim, actual.trim)

// second test
		assertTrue('', cls.exists[name == 'main2.compositesametype'])

		// instantiate
		val sysImpl2 = cls.findFirst[name == 'main2.compositesametype'] as SystemImplementation
		val instance2 = InstantiateModel::buildInstanceModelFile(sysImpl2)
		val state2 = "state FailStop"
		val ft2 = CreateFTAModel.createFaultTree(instance2,state2)
		val uri2 = EcoreUtil.getURI(ft2)
		val file2 = workspaceRoot.getFile(new Path(uri2.toPlatformString(true)))
		val actual2 = Files.readStreamIntoString(file2.contents)
		assertEquals('error', expected2.trim, actual2.trim)

// third test
		assertTrue('', cls.exists[name == 'main2.transition'])

		// instantiate
		val sysImpl3 = cls.findFirst[name == 'main2.transition'] as SystemImplementation
		val instance3 = InstantiateModel::buildInstanceModelFile(sysImpl3)
		val state3 = "outgoing propagation on externaleffect{serviceomission}"
		val ft3 = CreateFTAModel.createFaultTree(instance3,state3)
		val uri3 = EcoreUtil.getURI(ft3)
		val file3 = workspaceRoot.getFile(new Path(uri3.toPlatformString(true)))
		val actual3 = Files.readStreamIntoString(file3.contents)
		assertEquals('error', expected3.trim, actual3.trim)
		
	}

	val aadlText = '''
package redundant2
public

data mydata
end mydata;

-- cpu as example with error source as leaf of bindings
processor cpu
annex EMV2 {**
	use types errorlibrary;
	error propagations
		bindings: out propagation {ServiceError};
	flows
		cpufail : error source  bindings{ServiceError};
	end propagations;
**};
end cpu;


-- memory as example with error source as leaf of bindings
memory mem
annex EMV2 {**
	use types errorlibrary;
	error propagations
		bindings: out propagation {ServiceError};
	flows
		memfail : error source  bindings{ServiceError};
	end propagations;
**};
end mem;


-- bus as example with error source as leaf of bindings
bus transport
annex EMV2 {**
	use types errorlibrary;
	error propagations
		bindings: out propagation {ServiceError};
	flows
		busfail : error source  bindings{ServiceError};
	end propagations;
**};
end transport;

-- sensor as source of two errors
device sensor
features
	valueout : out data port mydata;
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;
 	error propagations
 		valueout : out propagation {LateDelivery, OutOfRange};
 	flows
 		ef0 : error source valueout{LateDelivery};
 		ef1 : error source valueout{OutOfRange};
 	end propagations;
 **};
end sensor;

-- actuator passes through errors and maps them into service omission
device actuator
features
	valuein : in data port mydata;
	actionout : out feature ;
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;
 	error propagations
 		valuein : in propagation {ItemOmission,ValueCorruption,InconsistentValue};
 		actionout: out propagation {ServiceOmission};
 	flows
 		ef1 : error path valuein{ItemOmission,ValueCorruption,InconsistentValue} -> actionout{ServiceOmission};
 	end propagations;
 **};
end actuator;

-- actuator.failstate elaborates error behavior with state machine
-- incoming errors are elaborated into a transition to failstop.
-- failstop propagates as service omission
device implementation actuator.failstate
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;
 	component error behavior
 	transitions
 		t0 : Operational -[ valuein{ItemOmission}]-> FailStop;
 		t1 : Operational -[ valuein{ValueCorruption}]-> FailStop;
 		t2 : Operational -[ valuein{InconsistentValue}]-> FailStop;
 	propagations
 		prop1: FailStop-[]-> actionout{ServiceOmission};
 	end component;
 **};
	
end actuator.failstate;


-- internal error events result in degraded or failstop
-- incoming propagation on both inputs results in item omission
thread voter_thr
features
	valuein1 : in data port mydata;
	valuein2 : in data port mydata;
	valueout : out data port mydata;
annex EMV2{**
 	use types ErrorLibrary;
 	-- we use our own three state EBSM.
 	-- a computeerror error event leads to Degraded, which as error source generates InconsistentValue
 	-- a Failure error event leads to FailStop, which propagates ItemOmission
 	use behavior FTErrorLibrary::DegradedFailStop;
 	error propagations
 		valuein1 : in propagation {LateDelivery, OutOfRange};
 		valuein2 : in propagation {LateDelivery, OutOfRange};
 		valueout : out propagation {ItemOmission,ValueCorruption,InconsistentValue};
 		processor: in propagation {ServiceError}; 
 		memory   : in propagation {ServiceError};
 	flows
 		ef1 : error path valuein1{LateDelivery,OutOfRange} -> valueout{ItemOmission};
 		ef2 : error path valuein2{LateDelivery,OutOfRange} -> valueout{ItemOmission};
 		-- ef3 and ef4 are to be used in FTA since there is no refinement in the component error behavior
 		ef3 : error path processor{ServiceError} -> valueout{ItemOmission};
 		ef4 : error path memory{ServiceError} -> valueout{ValueCorruption};
 		-- the error source is refined by prop2
 		ef5 : error source valueout{InconsistentValue};
 	end propagations;
 	component error behavior
 	propagations
 	prop1: Operational -[valuein1{LateDelivery, OutOfRange} and valuein2{LateDelivery, OutOfRange}]-> valueout{ItemOmission};
 	prop2: Degraded -[]-> valueout{InconsistentValue};
 	prop3: FailStop -[]-> valueout{ItemOmission};
 	end component;
 **};
end voter_thr;

thread voter_thr1
	-- in this case out of range on both results in out of range
	-- similarly late delivery on both results in late delivery
features
                valuein1 : in data port mydata;
                valuein2 : in data port mydata;
                valueout : out data port mydata;
annex EMV2{**
 use types ErrorLibrary, FTerrorlibrary;
 use behavior ErrorLibrary::FailStop;
 error propagations
   valuein1 : in propagation {LateDelivery, OutOfRange};
   valuein2 : in propagation {LateDelivery, OutOfRange};
   valueout : out propagation {ItemOmission,ValueCorruption,InconsistentValue, LateDelivery};
   processor: in propagation {ServiceError}; 
   memory   : in propagation {ServiceError};
 flows
   ef1 : error path valuein1{LateDelivery,OutOfRange} -> valueout{ItemOmission};
   ef2 : error path valuein2{LateDelivery,OutOfRange} -> valueout{ItemOmission};
   -- since there are no out propagation rules in the component error behavior
   -- the next three flows determine the FTA additions
   -- There is no need for an out propagation rule since it is an unconditional single propagation mapping.
   -- Each becomes an OR element in the FTA 
   ef3 : error path processor{ServiceError} -> valueout{ItemOmission};
   ef4 : error path memory{ServiceError} -> valueout{ValueCorruption};
   ef5 : error source valueout{InconsistentValue};
   -- ef5 indicates that voter_thr is an error source, i.e., there is some voter internal error event as the soruce.
   -- the user behavior declaration associates an error behavior state machine (EBSM) with a Failure error event.
   -- If it were a three state EBSM we would not know which state and related error event is the source.
   -- To address this we can do one of two things:
   -- 1) connect the EBSM to the error source via component error behavior declaration as done in voter_thr (above)
   -- 2) add a when clause to the error source declaration.
   --    when {ComputationError}  : the source is an implicit error event of type ComputationError 
   --    when FailStop : identifies the state whose incoming transition error event trigger is the source.
 end propagations;
 component error behavior
 propagations
 -- note these propagation rules do not map valuein1{LateDelivery} and valuein2{OutOfRange}
 -- in voter_thr the combinations are specified in the rule.
    p1 : all -[ valuein1{LateDelivery} and valuein2{LateDelivery}]-> valueout{LateDelivery};
    p2 : all -[ valuein1{OutOfRange} and valuein2{OutOfRange}]-> valueout{OutOfRange};
 end component;
**};
end voter_thr1;


process voter
features
	valuein1 : in data port mydata;
	valuein2 : in data port mydata;
	valueout : out data port mydata;
	-- No more warning if voter does not include an EMV2 subclause
end voter;

process implementation voter.i
subcomponents
	thr : thread voter_thr;
connections
	c0 : port valuein1 -> thr.valuein1;
	c1 : port valuein2 -> thr.valuein2;
	c2 : port thr.valueout -> valueout;
end voter.i;

process implementation voter.i1
subcomponents
	thr : thread voter_thr1;
connections
	c0 : port valuein1 -> thr.valuein1;
	c1 : port valuein2 -> thr.valuein2;
	c2 : port thr.valueout -> valueout;
end voter.i1;

system main2
	features
		externaleffect: out feature;
		annex EMV2 {**
			use types ErrorLibrary;
			error propagations
			externaleffect: out propagation {ServiceOmission};
			end propagations;
		**};
end main2;

-- in this configuration we map the actuator fail state into the top system fail state.
-- This requires that all incoming propagations result in a transition of the actuator to the fail state.
-- This error behavior is specified in actuator.failstate.
system implementation main2.composite
subcomponents
	sensor1 : device sensor;
	sensor2 : device sensor;
	voter   : process voter.i;
	actuator : device actuator.failstate;
	
	cpu : processor cpu;
	mem : memory mem;
	
	mybus : bus transport;
connections
	c0 : port sensor1.valueout -> voter.valuein1;
	c1 : port sensor2.valueout -> voter.valuein2;
	c2 : port voter.valueout -> actuator.valuein;
properties
	actual_processor_binding => (reference (cpu)) applies to voter;
	actual_memory_binding => (reference (mem)) applies to voter;
	Actual_Connection_Binding => (reference (mybus)) applies to c0;
	Actual_Connection_Binding => (reference (mybus)) applies to c1;
	Actual_Connection_Binding => (reference (mybus)) applies to c2;
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;
 	composite error behavior 
 	states
 		[ actuator.failstop ]-> FailStop;
 	end composite;
 **};
end main2.composite;

system implementation main2.compositesametype
subcomponents
	sensor1 : device sensor;
	sensor2 : device sensor;
	voter   : process voter.i1;
	actuator : device actuator.failstate;
	
	cpu : processor cpu;
	mem : memory mem;
	
	mybus : bus transport;
connections
	c0 : port sensor1.valueout -> voter.valuein1;
	c1 : port sensor2.valueout -> voter.valuein2;
	c2 : port voter.valueout -> actuator.valuein;
properties
	actual_processor_binding => (reference (cpu)) applies to voter;
	actual_memory_binding => (reference (mem)) applies to voter;
	Actual_Connection_Binding => (reference (mybus)) applies to c0;
	Actual_Connection_Binding => (reference (mybus)) applies to c1;
	Actual_Connection_Binding => (reference (mybus)) applies to c2;
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;
 	component error behavior
 	transitions
 	Operational -[actuator.actionout{ServiceOmission}]-> FailStop;
 	end component;
 	composite error behavior 
 	states
 		[ actuator.failstop ]-> FailStop;
 	end composite;
 **};
end main2.compositesametype;

-- In this configuration we map the outgoing propagation from the actuator to the outgoing propagation of main2.
-- Voter maps any error on both incoming (AND) to omission
system implementation main2.transition
subcomponents
	sensor1 : device sensor;
	sensor2 : device sensor;
	voter   : process voter.i;
	actuator : device actuator;
	
	cpu : processor cpu;
	mem : memory mem;
	
	mybus : bus transport;
connections
	c0 : port sensor1.valueout -> voter.valuein1;
	c1 : port sensor2.valueout -> voter.valuein2;
	c2 : port voter.valueout -> actuator.valuein;
properties
	actual_processor_binding => (reference (cpu)) applies to voter;
	actual_memory_binding => (reference (mem)) applies to voter;
	Actual_Connection_Binding => (reference (mybus)) applies to c0;
	Actual_Connection_Binding => (reference (mybus)) applies to c1;
	Actual_Connection_Binding => (reference (mybus)) applies to c2;
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;
	component error behavior
		propagations
		all -[actuator.actionout{ServiceOmission}]-> externaleffect{ServiceOmission};
	end component;
 **};
end main2.transition;

end redundant2;
	'''
	
	val fterrlibText = '''
	package FTerrorlibrary
public
	annex emv2 {**
	
error types
	ComputationError: type;
end types;
error behavior DegradedFailStop
events
	ComputeError : error event;
	Failure : error event ;
states
	Operational : initial state ;
	Degraded: state;
	FailStop : state ;
transitions
	FirstFailure : Operational -[ ComputeError ]-> Degraded ;
	SecondFailure : Degraded -[ Failure ]-> FailStop ;
	DirectFailure : Operational -[ Failure ]-> FailStop ;
end behavior ;
		
	**};
	
end FTerrorlibrary;
	'''

	val expected = '''
<?xml version="1.0" encoding="ASCII"?>
<FaultTree:FaultTree xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:FaultTree="http://www.aadl.info/FaultTree" name="redundant2_main2_composite-failstop" description="Top Level Failure" root="//@events.7">
  <instanceRoot href="../../redundant2_main2_composite_Instance.aaxl2#/"/>
  <events name="sensor1-valueout-latedelivery,outofrange" description="Component 'sensor1' with outgoing  failure 'LateDelivery,OutOfRange" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_composite_Instance.aaxl2#//@componentInstance.1"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.7/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@outgoingPropagationConditions.0/@condition/@operands.0/@constraint"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.4/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@propagations.0"/>
  </events>
  <events name="sensor2-valueout-latedelivery,outofrange" description="Component 'sensor2' with outgoing  failure 'LateDelivery,OutOfRange" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_composite_Instance.aaxl2#//@componentInstance.2"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.7/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@outgoingPropagationConditions.0/@condition/@operands.1/@constraint"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.4/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@propagations.0"/>
  </events>
  <events name="Intermediate1" subEvents="//@events.0 //@events.1" referenceCount="1" type="Intermediate" subEventLogic="And">
    <relatedInstanceObject href="../../redundant2_main2_composite_Instance.aaxl2#//@componentInstance.5/@componentInstance.0"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.6/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@transitions.0/@condition/@constraint"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.7/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@outgoingPropagationConditions.0/@condition"/>
  </events>
  <events name="voter.thr-failure-itemomission" description="Component 'voter.thr' failure event 'Failure' type 'ItemOmission'" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_composite_Instance.aaxl2#//@componentInstance.5/@componentInstance.0"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.6/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@transitions.0/@condition/@constraint"/>
    <relatedEMV2Object href="../../../FTerrorlibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.1"/>
  </events>
  <events name="mem-memfail-serviceerror" description="Component 'mem' failure source 'ServiceError'" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_composite_Instance.aaxl2#//@componentInstance.4"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.7/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.3/@typeTokenConstraint"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.2/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.0"/>
  </events>
  <events name="voter.thr-computeerror-inconsistentvalue" description="Component 'voter.thr' failure event 'ComputeError' type 'InconsistentValue'" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_composite_Instance.aaxl2#//@componentInstance.5/@componentInstance.0"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.6/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@transitions.2/@condition/@constraint"/>
    <relatedEMV2Object href="../../../FTerrorlibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="actuator-failure" description="Component 'actuator' failure event 'Failure'" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_composite_Instance.aaxl2#//@componentInstance.3"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="redundant2_main2_composite-failstop" description="Component 'main2.composite' in failure mode 'FailStop'" subEvents="//@events.6 //@events.2 //@events.3 //@events.4 //@events.5" referenceCount="1" type="Intermediate">
    <relatedInstanceObject href="../../redundant2_main2_composite_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@states.1"/>
  </events>
</FaultTree:FaultTree>
	'''

	val expected2 = '''
<?xml version="1.0" encoding="ASCII"?>
<FaultTree:FaultTree xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:FaultTree="http://www.aadl.info/FaultTree" name="redundant2_main2_compositesametype-failstop" description="Top Level Failure" root="//@events.8">
  <instanceRoot href="../../redundant2_main2_compositesametype_Instance.aaxl2#/"/>
  <events name="sensor1-valueout-latedelivery,outofrange" description="Component 'sensor1' with outgoing  failure 'LateDelivery,OutOfRange" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_compositesametype_Instance.aaxl2#//@componentInstance.1"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.8/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.0/@typeTokenConstraint"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.4/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@propagations.0"/>
  </events>
  <events name="sensor2-valueout-latedelivery,outofrange" description="Component 'sensor2' with outgoing  failure 'LateDelivery,OutOfRange" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_compositesametype_Instance.aaxl2#//@componentInstance.2"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.8/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.1/@typeTokenConstraint"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.4/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@propagations.0"/>
  </events>
  <events name="cpu-cpufail-itemomission" description="Component 'cpu' failure source 'ItemOmission'" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_compositesametype_Instance.aaxl2#//@componentInstance.6"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.6/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@transitions.0/@condition/@constraint"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.1/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.0"/>
  </events>
  <events name="sensor1-ef1-outofrange" description="Component 'sensor1' failure source 'OutOfRange'" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_compositesametype_Instance.aaxl2#//@componentInstance.1"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.8/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@outgoingPropagationConditions.1/@typeToken"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.4/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.1"/>
  </events>
  <events name="sensor2-ef1-outofrange" description="Component 'sensor2' failure source 'OutOfRange'" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_compositesametype_Instance.aaxl2#//@componentInstance.2"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.8/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@outgoingPropagationConditions.1/@typeToken"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.4/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.1"/>
  </events>
  <events name="Intermediate1" subEvents="//@events.3 //@events.4" referenceCount="1" type="Intermediate" subEventLogic="And">
    <relatedInstanceObject href="../../redundant2_main2_compositesametype_Instance.aaxl2#//@componentInstance.5/@componentInstance.0"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.8/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@outgoingPropagationConditions.1/@typeToken"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.8/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@outgoingPropagationConditions.1/@condition"/>
  </events>
  <events name="voter.thr-ef5-inconsistentvalue" description="Component 'voter.thr' failure source 'InconsistentValue'" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_compositesametype_Instance.aaxl2#//@componentInstance.5/@componentInstance.0"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.6/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@transitions.2/@condition/@constraint"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.8/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@flows.4"/>
  </events>
  <events name="actuator-failure" description="Component 'actuator' failure event 'Failure'" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_compositesametype_Instance.aaxl2#//@componentInstance.3"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="redundant2_main2_compositesametype-failstop" description="Component 'main2.compositesametype' in failure mode 'FailStop'" subEvents="//@events.7 //@events.0 //@events.1 //@events.2 //@events.5 //@events.6" referenceCount="1" type="Intermediate">
    <relatedInstanceObject href="../../redundant2_main2_compositesametype_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@states.1"/>
  </events>
</FaultTree:FaultTree>
	'''
	
	val expected3 = '''
<?xml version="1.0" encoding="ASCII"?>
<FaultTree:FaultTree xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:FaultTree="http://www.aadl.info/FaultTree" name="redundant2_main2_transition-externaleffect-serviceomission" description="Top Level Failure" root="//@events.5">
  <instanceRoot href="../../redundant2_main2_transition_Instance.aaxl2#/"/>
  <events name="sensor1-valueout-latedelivery,outofrange" description="Component 'sensor1' with outgoing  failure 'LateDelivery,OutOfRange" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_transition_Instance.aaxl2#//@componentInstance.1"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.7/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@outgoingPropagationConditions.0/@condition/@operands.0/@constraint"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.4/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@propagations.0"/>
  </events>
  <events name="sensor2-valueout-latedelivery,outofrange" description="Component 'sensor2' with outgoing  failure 'LateDelivery,OutOfRange" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_transition_Instance.aaxl2#//@componentInstance.2"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.7/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@outgoingPropagationConditions.0/@condition/@operands.1/@constraint"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.4/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@propagations.0"/>
  </events>
  <events name="Intermediate1" subEvents="//@events.0 //@events.1" referenceCount="1" type="Intermediate" subEventLogic="And">
    <relatedInstanceObject href="../../redundant2_main2_transition_Instance.aaxl2#//@componentInstance.5/@componentInstance.0"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.7/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@outgoingPropagationConditions.0/@typeToken"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.7/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@outgoingPropagationConditions.0/@condition"/>
  </events>
  <events name="voter.thr-computeerror-inconsistentvalue" description="Component 'voter.thr' failure event 'ComputeError' type 'InconsistentValue'" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_transition_Instance.aaxl2#//@componentInstance.5/@componentInstance.0"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.7/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@outgoingPropagationConditions.1/@typeToken"/>
    <relatedEMV2Object href="../../../FTerrorlibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="voter.thr-failure-itemomission" description="Component 'voter.thr' failure event 'Failure' type 'ItemOmission'" referenceCount="1">
    <relatedInstanceObject href="../../redundant2_main2_transition_Instance.aaxl2#//@componentInstance.5/@componentInstance.0"/>
    <relatedErrorType href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.7/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@outgoingPropagationConditions.2/@typeToken"/>
    <relatedEMV2Object href="../../../FTerrorlibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.1"/>
  </events>
  <events name="redundant2_main2_transition-externaleffect-serviceomission" description="Component 'main2.transition' with outgoing  failure 'ServiceOmission" subEvents="//@events.2 //@events.3 //@events.4" referenceCount="1" type="Intermediate">
    <relatedInstanceObject href="../../redundant2_main2_transition_Instance.aaxl2#/"/>
    <relatedErrorType href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#emv2$ErrorLibrary.ServiceOmission"/>
    <relatedEMV2Object href="../../../redundant2.aadl#/0/@ownedPublicSection/@ownedClassifier.12/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@propagations.0"/>
  </events>
</FaultTree:FaultTree>
	'''

}
