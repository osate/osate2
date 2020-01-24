/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue666Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue666() {
		
		val testFileResult = issues = testHelper.testString(aadlText)
		val pkg = testFileResult.resource.contents.head as AadlPackage
		pkg => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.get(2) as ComponentImplementation => [
				"outer.ok".assertEquals(name)
				val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
				val instance = InstantiateModel.instantiate(it, errorManager)
				val reporter = errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter
				val messages = reporter.errors
				instance => [
					"outer_ok_Instance".assertEquals(name)
					assertEquals(512, systemOperationModes.size)
					assertTrue(messages.empty)
				]
			]
			publicSection.ownedClassifiers.get(3) as ComponentImplementation => [
				"outer.tooManySOMs".assertEquals(name)
				val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
				val instance = InstantiateModel.instantiate(it, errorManager)
				val reporter = errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter
				val messages = reporter.errors				
				instance => [
					"outer_tooManySOMs_Instance".assertEquals(name)
					assertEquals(1000, systemOperationModes.size)
					messages => [
						assertEquals(1, size)
						head => [
							assertEquals(QueuingAnalysisErrorReporter.WARNING, kind)
							assertEquals("List of system operation modes is incomplete (see project property 'Instantiation')", message)
						]
					]
				]
			]
		]
	}
	val aadlText = '''
			package pkg1
			public
				abstract inner
					modes
						m1: initial mode;
						m2: mode;
				end inner;
				
				abstract outer
				end outer;
				
				abstract implementation outer.ok
					subcomponents
						sub1: abstract inner[9];
				end outer.ok;
				
				abstract implementation outer.tooManySOMs
					subcomponents
						sub2: abstract inner[10];
				end outer.tooManySOMs;
			end pkg1;
		'''
}