package org.osate.core.tests.issues

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Issue753Test extends OsateTest {
	override getProjectName() {
		"issue448"
	}

	@Test
	def void issue753() {
		val aadlFile = "issue753.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "conn_test.i" not found', cls.exists[name == 'conn_test.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'conn_test.i'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
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
