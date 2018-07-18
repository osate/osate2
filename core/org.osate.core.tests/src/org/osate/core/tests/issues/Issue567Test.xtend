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
class Issue567Test extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void issue567() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "S.top" not found', cls.exists[name == 'S.top'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'S.top'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals('S_top_Instance', instance.name)

		// check if there are 2 connections
		val connections = instance.connectionInstances
		assertTrue('In S_top_instance: Expected 2 connections but found ' + connections.size, connections.size == 2)
		
		// check if there is 1 end to end flow
		val etes = instance.endToEndFlows
		assertTrue('In S_top_instance: Expected 1 end to end flow but found ' + etes.size, etes.size == 1)
	}

	val aadlText = '''
package issue567
public

	feature group FG
		features
			outMsg: out event data port;
			inMsg: in data port;
	end FG;

	system Box
		features
			ioports: feature group FG;
		flows
			outFlow: flow source ioports.outMsg;
			inFlow: flow sink ioports.inMsg;
	end Box;

	process P
		features
			ioports: feature group inverse of FG;
		flows
			processFlow: flow path ioports.outMsg -> ioports.inMsg;
	end P;

	process implementation P.i
		subcomponents
			t1: thread T.i;
		connections
			c: feature group ioports <-> t1.ioports;
		flows
			processFlow: flow path ioports.outMsg -> c -> t1.threadFlow -> c -> ioports.inMsg;
	end P.i;

	thread T
		features
			ioports: feature group inverse of FG;
		flows
			threadFlow: flow path ioports.outMsg -> ioports.inMsg;
	end T;

	thread implementation T.i
	end T.i;

	system S
	end S;

	system implementation S.top
		subcomponents
			proc: process P.i;
			box: system Box;
		connections
			c: feature group box.ioports <-> proc.ioports;
		flows
			f_bb_proc_bb: end to end flow box.outFlow -> c -> proc.processFlow -> c -> box.inFlow;
	end S.top;

end issue567;	'''
}
