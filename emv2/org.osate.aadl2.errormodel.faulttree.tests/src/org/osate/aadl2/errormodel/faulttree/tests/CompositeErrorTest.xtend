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
import org.osate.aadl2.errormodel.FaultTree.util.FaultTreeUtils
import org.osate.aadl2.errormodel.FaultTree.LogicOperation
import org.osate.aadl2.errormodel.FaultTree.FaultTreeType
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState
import org.osate.aadl2.errormodel.FaultTree.EventType

@RunWith(XtextRunner)
@InjectWith(ErrorModelUiInjectorProvider)
class CompositeErrorTest extends OsateTest {
	override getProjectName() {
		"CompositeErrorTest"
	}
	

	@Test
	def void compositeerrorfta() {
		val aadlFile = "composite-error.aadl"
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

		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		
		val ft = CreateFTAModel.createModel(instance,state,FaultTreeType.COMPOSITE_PARTS);
		assertEquals(ft.events.size,3)
		for (event : ft.events) {
			if (event.type != EventType.INTERMEDIATE){
			assertTrue(event.relatedEMV2Object instanceof ErrorBehaviorState)
			}
		}
		
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

}
