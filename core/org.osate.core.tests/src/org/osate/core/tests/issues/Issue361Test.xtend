package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestResourceSet

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class Issue361Test extends XtextTest {
	
	@Inject 
	ParseHelper<AadlPackage> parseHelper;
	
	@Inject
	TestResourceSet resourceSet;
	
	@Test
	def void issue361() {
		val pkg = parseHelper.parse(aadlText, resourceSet.get())
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "Block.impl" not found', cls.exists[name == 'Block.impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'Block.impl'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl, pkg.eResource.resourceSet)
		assertEquals('Block_impl_Instance', instance.name)

		// check that there are two external connections
		val conns = instance.connectionInstances
		val names = conns.map[name]
		assertTrue('Connection "ins.input -> blk_process.input" not created', names.contains('ins.input -> blk_process.input'))
		assertTrue('Connection "blk_process.output -> outs.output" not created', names.contains('blk_process.output -> outs.output'))
		assertTrue('Expected two connection instances but found ' + conns.size, conns.size == 2)
	}

	val aadlText = '''
package issue361
public
	with Base_Types;

	feature group blk_ins
		features
			input: in data port Base_Types::Boolean;
	end blk_ins;

	feature group blk_outs
		features
			output: out data port Base_Types::Boolean;
	end blk_outs;

	system Block
		features 
			ins: feature group blk_ins;
			outs: feature group blk_outs;
	end Block;

	system implementation Block.impl
		subcomponents
			blk_process: process BlockProcess.impl;
		connections
			pin: port ins.input -> blk_process.input;
			pout: port blk_process.output -> outs.output;
	end Block.impl;

	process BlockProcess
		features
			input: in data port Base_Types::Boolean;
			output: out data port Base_Types::Boolean;
	end BlockProcess;

	process implementation BlockProcess.impl
	end BlockProcess.impl;

end issue361;
	'''
}
