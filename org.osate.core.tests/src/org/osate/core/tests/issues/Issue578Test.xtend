package org.osate.core.tests.issues

import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextRunner2
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.SystemType
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Issue578Test extends OsateTest {
	override getProjectName() {
		"issue578"
	}

	@Test
	def void issue578TestA() {
		val aadlFile = "issue578A.aadl"
		val aadlText = '''
			package issue578A
			public
				system a
				end a;
				
				system implementation a.impl extends a.impl
				end a.impl;
			end issue578A;
		'''
		createFiles(aadlFile -> aadlText)
		
		suppressSerialization
		val testFileResult = testFile(aadlFile)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		
		testFileResult.resource.contents.head as AadlPackage => [
			"issue578A".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"a.impl".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of a.impl has a cycle.")
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)

		// instantiate
		val sysImpl = cls.findFirst[name == 'a.impl'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		val markers = OsateResourceUtil.convertToIResource(instance.eResource).findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ONE);
		markers =>[
			size.assertEquals(1)
			head =>[
				attributes.get(IMarker.SEVERITY) => [
					assertEquals(IMarker.SEVERITY_ERROR)
				]
				attributes.get(IMarker.MESSAGE) => [
					assertEquals("Circular extension: Component 'a.impl' directly or indirectly extends itself.")
				]
			]
		]
	}

	@Test
	def void issue578TestB() {
		val aadlFile = "issue578B.aadl"
		val aadlText = '''
				package issue578B
				public
					system b extends c
					end b;
					system implementation b.impl extends c.impl
					end b.impl;
				
					system c extends b
					end c;
					system implementation c.impl extends b.impl
					end c.impl;
				
				end issue578B;		'''
		createFiles(aadlFile -> aadlText)
		
		suppressSerialization
		val testFileResult = testFile(aadlFile)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		
		testFileResult.resource.contents.head as AadlPackage => [
			"issue578B".assertEquals(name)
			publicSection.ownedClassifiers.head as SystemType => [
				"b".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of b has a cycle.")
				]
			]
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"b.impl".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of b.impl has a cycle.")
				]
			]
			publicSection.ownedClassifiers.get(2) as SystemType => [
				"c".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of c has a cycle.")
				]
			]
			publicSection.ownedClassifiers.get(3) as SystemImplementation => [
				"c.impl".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of c.impl has a cycle.")
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)

		// instantiate b.impl
		var sysImpl = cls.findFirst[name == 'b.impl'] as SystemImplementation
		var instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		var markers = OsateResourceUtil.convertToIResource(instance.eResource).findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ONE);
		markers =>[
			size.assertEquals(2)
			head =>[
				attributes.get(IMarker.SEVERITY) => [
					assertEquals(IMarker.SEVERITY_ERROR)
				]
				attributes.get(IMarker.MESSAGE) as String => [
					if (indexOf("Classifier") < 0){
						assertEquals("Circular extension: Component 'b.impl' directly or indirectly extends itself.")
					} else {
						assertEquals("Circular extension: Classifier 'b' directly or indirectly extends itself.")
					}
				]
			]
			get(1) => [
				attributes.get(IMarker.SEVERITY) => [
					assertEquals(IMarker.SEVERITY_ERROR)
				]
				attributes.get(IMarker.MESSAGE) as String => [
					if (indexOf("Classifier") < 0){
						assertEquals("Circular extension: Component 'b.impl' directly or indirectly extends itself.")
					} else {
						assertEquals("Circular extension: Classifier 'b' directly or indirectly extends itself.")
					}
				]
			]
		]
		// instantiate c.impl
		sysImpl = cls.findFirst[name == 'c.impl'] as SystemImplementation
		instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		markers = OsateResourceUtil.convertToIResource(instance.eResource).findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ONE);
		markers =>[
			size.assertEquals(2)
			head =>[
				attributes.get(IMarker.SEVERITY) => [
					assertEquals(IMarker.SEVERITY_ERROR)
				]
				attributes.get(IMarker.MESSAGE) as String => [
					if (indexOf("Classifier") < 0){
						assertEquals("Circular extension: Component 'c.impl' directly or indirectly extends itself.")
					} else {
						assertEquals("Circular extension: Classifier 'c' directly or indirectly extends itself.")
					}
				]
			]
			get(1) => [
				attributes.get(IMarker.SEVERITY) => [
					assertEquals(IMarker.SEVERITY_ERROR)
				]
				attributes.get(IMarker.MESSAGE) as String => [
					if (indexOf("Classifier") < 0){
						assertEquals("Circular extension: Component 'c.impl' directly or indirectly extends itself.")
					} else {
						assertEquals("Circular extension: Classifier 'c' directly or indirectly extends itself.")
					}
				]
			]
		]
	}
	@Test
	def void issue578TestC() {
		val aadlFile = "issue578c.aadl"
		val aadlText = '''
			package issue578c
			public
				system d extends e
				end d;
			
				system e extends d
				end e;
			
				system implementation d.impl
				end d.impl;
			
			end issue578c;
		'''
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val testFileResult = testFile(aadlFile)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		
		testFileResult.resource.contents.head as AadlPackage => [
			"issue578c".assertEquals(name)
			publicSection.ownedClassifiers.head as SystemType => [
				"d".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of d has a cycle.")
				]
			]
			publicSection.ownedClassifiers.get(1) as SystemType => [
				"e".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of e has a cycle.")
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)

		// instantiate d.impl
		var sysImpl = cls.findFirst[name == 'd.impl'] as SystemImplementation
		var instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		var markers = OsateResourceUtil.convertToIResource(instance.eResource).findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ONE);
		markers =>[
			size.assertEquals(1)
			head =>[
				attributes.get(IMarker.SEVERITY) => [
					assertEquals(IMarker.SEVERITY_ERROR)
				]
				attributes.get(IMarker.MESSAGE) as String => [
					if (indexOf("Classifier 'd'") < 0){
						assertEquals("Circular extension: Classifier 'e' directly or indirectly extends itself.")
					} else {
						assertEquals("Circular extension: Classifier 'd' directly or indirectly extends itself.")
					}
				]
			]
		]
	}

}
