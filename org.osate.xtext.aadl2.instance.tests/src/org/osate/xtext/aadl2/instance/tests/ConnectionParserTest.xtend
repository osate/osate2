package org.osate.xtext.aadl2.instance.tests

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.instance.ConnectionKind
import org.osate.aadl2.instance.SystemInstance
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.instance.InstanceUiInjectorProvider

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertFalse
import static extension org.junit.Assert.assertTrue

@RunWith(XtextRunner)
@InjectWith(InstanceUiInjectorProvider)
class ConnectionParserTest extends OsateTest {
	override getProjectName() {
		"ConnectionParserTest"
	}
	
	@Test
	def void testSimpleAcrossConnection() {
		val pkg1FileName = "pkg1.aadl"
		val si1FileName = "si1.instance"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				system s
				end s;
				
				system implementation s.i
				subcomponents
					sub1: device dev1;
					sub2: device dev2;
				connections
					conn1: port sub1.op -> sub2.ip;
					conn2: port sub1.op -> sub2.ip;
				end s.i;
				
				device dev1
				features
					op: out data port;
				end dev1;
				
				device dev2
				features
					ip: in data port;
				end dev2;
			end pkg1;
		''', si1FileName -> '''
			system si1 : pkg1::s.i {
				device sub1[0] : pkg1::s.i::sub1 {
					out dataPort op : pkg1::dev1::op source of (1.0, 1.1)
				}
				device sub2[0] : pkg1::s.i::sub2 {
					in dataPort ip : pkg1::dev2::ip destination of (1.0, 1.1)
				}
				complete portConnection "connName1" : sub1[0].op -> sub2[0].ip {
					sub1[0].op -> sub2[0].ip : pkg1::s.i::conn1 in parent
				}
				complete portConnection "connName2" : sub1[0].op -> sub2[0].ip {
					sub1[0].op -> sub2[0].ip : pkg1::s.i::conn2 in parent
				}
			}
		''')
		suppressSerialization
		testFile(pkg1FileName)
		testFile(si1FileName).resource.contents.head as SystemInstance => [si |
			"si1".assertEquals(si.name)
			si.componentInstances.get(0) => [
				"sub1".assertEquals(name)
				featureInstances.head => [
					"op".assertEquals(name)
					2.assertEquals(srcConnectionInstances.size)
					si.connectionInstances.get(0).assertEquals(srcConnectionInstances.get(0))
					si.connectionInstances.get(1).assertEquals(srcConnectionInstances.get(1))
					dstConnectionInstances.empty.assertTrue
				]
			]
			si.componentInstances.get(1) => [
				"sub2".assertEquals(name)
				featureInstances.head => [
					"ip".assertEquals(name)
					srcConnectionInstances.empty.assertTrue
					2.assertEquals(dstConnectionInstances.size)
					si.connectionInstances.get(0).assertEquals(dstConnectionInstances.get(0))
					si.connectionInstances.get(1).assertEquals(dstConnectionInstances.get(1))
				]
			]
			2.assertEquals(si.connectionInstances.size)
			si.connectionInstances.get(0) => [
				"connName1".assertEquals(name)
				complete.assertTrue
				ConnectionKind.PORT_CONNECTION.assertEquals(kind)
				bidirectional.assertFalse
				si.componentInstances.get(0).featureInstances.head.assertEquals(source)
				si.componentInstances.get(1).featureInstances.head.assertEquals(destination)
				1.assertEquals(connectionReferences.size)
				connectionReferences.head => [
					si.componentInstances.get(0).featureInstances.head.assertEquals(source)
					si.componentInstances.get(1).featureInstances.head.assertEquals(destination)
					"pkg1::s.i".assertEquals(connection.getContainerOfType(ComponentImplementation).getQualifiedName)
					"conn1".assertEquals(connection.name)
					si.assertEquals(context)
				]
			]
			si.connectionInstances.get(1) => [
				"connName2".assertEquals(name)
				complete.assertTrue
				ConnectionKind.PORT_CONNECTION.assertEquals(kind)
				bidirectional.assertFalse
				si.componentInstances.get(0).featureInstances.head.assertEquals(source)
				si.componentInstances.get(1).featureInstances.head.assertEquals(destination)
				1.assertEquals(connectionReferences.size)
				connectionReferences.head => [
					si.componentInstances.get(0).featureInstances.head.assertEquals(source)
					si.componentInstances.get(1).featureInstances.head.assertEquals(destination)
					"pkg1::s.i".assertEquals(connection.getContainerOfType(ComponentImplementation).getQualifiedName)
					"conn2".assertEquals(connection.name)
					si.assertEquals(context)
				]
			]
		]
	}
}