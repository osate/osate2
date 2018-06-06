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
class Issue565Test extends OsateTest {
	@Test
	def void issue565() {
		val aadlFile = "issue565.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "Top.i" not found', cls.exists[name == 'Top.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'Top.i'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals('Top_i_Instance', instance.name)

		// check if there are 2 connections
		val connections = instance.connectionInstances
		assertTrue('In Top_i_instance: Expected 2 connections but found ' + connections.size, connections.size == 2)
	}

	val aadlText = '''
	package issue565
	public

		data MsgType
		end MsgType;

		feature group FGType
			features
				inPort: in out data port msgType;
		end FGType;

		process Proc
			features
				fgPorts: feature group FGType;
		end Proc;

		process InverseProc
			features
				fgPorts: feature group inverse of FGType;
		end InverseProc;

		system Sub
			features
				fgPorts: feature group inverse of FGType;
		end Sub;

		system implementation Sub.i
			subcomponents
				iproc: process InverseProc;
			connections
				c2: feature group fgPorts <-> iproc.fgPorts;
		end Sub.i;

		system Top
		end Top;

		system implementation Top.i
			subcomponents
				proc: process Proc;
				sub: system Sub.i;
			connections
				c1: feature group proc.fgPorts <-> sub.fgPorts;
		end Top.i;

	end issue565;
	'''
}
