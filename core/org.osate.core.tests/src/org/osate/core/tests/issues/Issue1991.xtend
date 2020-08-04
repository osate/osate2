package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError
import org.osate.aadl2.FlowImplementation
import org.osate.aadl2.ThreadImplementation

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1991 extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper

	//Tests checkDataSizeProperty
	@Test
	def void fgTest(){
		val test ='''
		package FGtest
		public
			feature group FG
				features
					outPort: out event port;
					inPort: in event port;
			end FG;
			
			
			thread T
				features
					fg: feature group FG;
					fg_inv: feature group inverse of fg;
				flows
					fsrc1: flow source fg;
		    		fsrc2: flow source fg_inv;
		
		    		fsnk1: flow sink fg;
		    		fsnk2: flow sink fg_inv;
		    		
		
		    		fpath1: flow path fg -> fg_inv;
		    		fpath2: flow path fg_inv -> fg;
		    		fpath3: flow path fg -> fg_inv;
		    		fpath4: flow path fg_inv -> fg;
			end T;
			
			thread implementation T.impl
				flows
					fsrc1: flow source fg.inPort; 
		    		fsrc2: flow source fg_inv.outPort; 
		    		
		    		fsnk1: flow sink fg.outPort;
		    		fsnk2: flow sink fg_inv.inPort; 
		
		    		fpath1: flow path fg.outPort -> fg_inv.outPort; 
		    		fpath2: flow path fg_inv.inPort -> fg.inPort;
		    		fpath3: flow path fg.inPort -> fg_inv.inPort;
		    		fpath4: flow path fg_inv.outPort -> fg.outPort;
			end T.impl;
		end FGtest;
		'''
		
		val testFileResult = issues = testHelper.testString(test)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"FGtest".assertEquals(name)
			publicSection.ownedClassifiers.get(2) as ThreadImplementation => [
				"T.impl".assertEquals(name)
				allFlowImplementations.get(0) as FlowImplementation => [
					it.outEnd.assertError(testFileResult.issues, issueCollection, "'fg.inPort' must be an out or in out feature.")
				]
				allFlowImplementations.get(1) as FlowImplementation => [
					it.outEnd.assertError(testFileResult.issues, issueCollection, "'fg_inv.outPort' must be an out or in out feature.")
				]
				allFlowImplementations.get(2) as FlowImplementation => [
					it.inEnd.assertError(testFileResult.issues, issueCollection, "'fg.outPort' must be an in or in out feature.")
				]
				allFlowImplementations.get(3) as FlowImplementation => [
					it.inEnd.assertError(testFileResult.issues, issueCollection, "'fg_inv.inPort' must be an in or in out feature.")
				]
				allFlowImplementations.get(4) as FlowImplementation => [
					it.inEnd.assertError(testFileResult.issues, issueCollection, "'fg.outPort' must be an in or in out feature.")
				]
				allFlowImplementations.get(5) as FlowImplementation => [
					it.inEnd.assertError(testFileResult.issues, issueCollection, "'fg_inv.inPort' must be an in or in out feature.")
				]
//				allFlowImplementations.get(6) as FlowImplementation => [
//					it.inEnd.assertError(testFileResult.issues, issueCollection, "'fg_inv.inPort' must be an in or in out feature.")
//				]
//				allFlowImplementations.get(7) as FlowImplementation => [
//					it.outEnd.assertError(testFileResult.issues, issueCollection, "'fg.inPort' must be an out or in out feature.")
//				]
				//assertError(testFileResult.issues, issueCollection, 'Data size of "d1.i5" (4 Bytes) is larger than the sum of its subcomponents (2 Bytes).')
			]
			
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
		
}