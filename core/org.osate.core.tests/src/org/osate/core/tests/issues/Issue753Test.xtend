package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class Issue753Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue753() {
		
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "conn_test.i" not found', cls.exists[name == 'conn_test.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'conn_test.i'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals('conn_test_i_Instance', instance.name)

		// check if there are 5 connections in test_sys
		val connections = instance.connectionInstances
		assertTrue('In conn_test_i_Instance: Expected 4 connections but found ' + connections.size, connections.size == 4)
	}

	val aadlText = '''
		package Issue753
		public 
		   with Base_Types;
		   
		   annex resolute {**
		     print_conns(sys : component) <=
		       ** "the component " sys " has the following connections" **
		         forall(c : connections(sys)) . print(c)
		       
		     print(c : connection) <=
		       ** c **
		         true
		   **};
		   
		 system conn_test
		 	features
		 		feat0 : in data port Base_Types::Integer;
		 		feat1 : out data port Base_Types::Integer;
		 end conn_test;
		 
		 system implementation conn_test.i
		 	subcomponents
		 		feat_data : data Base_Types::Integer;
		 		subme: system sub;
		 	connections
		 		conn0 : port feat0 -> feat_data;
		 		conn1: port feat_data -> feat1;
		 		conn2: port subme.outp -> feat1;
		 		conn3: port subme.outp -> feat_data;
		    annex resolute {**
		    	prove print_conns(this)
		    **};
		 end conn_test.i;
		 
		 system sub
		 	features
		 		outp: out data port Base_Types::Integer;
		 end sub;
			
		end Issue753;
	'''
}
