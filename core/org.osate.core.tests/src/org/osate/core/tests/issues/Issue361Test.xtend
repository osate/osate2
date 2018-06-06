package org.osate.core.tests.issues

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2UiInjectorProvider
import org.osate.testsupport.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Issue361Test extends OsateTest {
	@Test
	def void issue361() {
		val aadlFile = "issue361.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "Block.impl" not found', cls.exists[name == 'Block.impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'Block.impl'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
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
