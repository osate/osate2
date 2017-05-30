package org.osate.core.tests.issues

import com.itemis.xtext.testing.XtextRunner2
import org.eclipse.xtext.junit4.InjectWith
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
class Issue508Test extends OsateTest {
	override getProjectName() {
		"issue508"
	}

	@Test
	def void issue508() {
		val aadlFile = "issue508.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "top.impl" not found', cls.exists[name == 'top.impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'top.impl'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals('top_impl_Instance', instance.name)

		// check if there are 2 connections in sub1
		val sub1 = instance.componentInstances.findFirst[name == 'sub1']
		val connections1 = sub1.connectionInstances
		assertTrue('In sub1: Expected 2 connections but found ' + connections1.size, connections1.size == 2)

		// check if there are 2 connections in sub2
		val sub2 = instance.componentInstances.findFirst[name == 'sub2']
		val connections2 = sub2.connectionInstances
		assertTrue('In sub2: Expected 2 connections but found ' + connections2.size, connections2.size == 2)
	}

	val aadlText = '''
package issue508
public
	feature group fgt
		features
			p1: out data port;
			p2: out data port;
	end fgt;

	system top
	end top;

	system implementation top.impl
		subcomponents
			sub1: system s1.impl;
			sub2: system s2.impl;
	end top.impl;

	system s1
	end s1;

	system implementation s1.impl
		subcomponents
			send: system sender;
			receive: system receiver;
		connections
			c1: feature group send.fg1 -> receive.fg2;
	end s1.impl;

	system s2
	end s2;

	system implementation s2.impl
		subcomponents
			send: system sender;
			receive: system receiver;
		connections
			c2: feature group send.fg1 <-> receive.fg2;
	end s2.impl;

	system sender
		features
			fg1: feature group fgt;
	end sender;

	system receiver
		features
			fg2: feature group inverse of fgt;
	end receiver;

end issue508;
'''
}
