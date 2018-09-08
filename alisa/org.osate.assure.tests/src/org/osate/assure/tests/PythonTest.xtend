/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.assure.tests

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.alisa.workbench.alisa.AssuranceCase
import org.osate.assure.generator.IAssureConstructor
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.pluginsupport.ExecutePythonUtil

@RunWith(XtextRunner)
@InjectWith(FullAlisaInjectorProvider)  
class PythonTest extends XtextTest {
	@Inject
	TestHelper<AssuranceCase> alisaTestHelper
	

	val projectprefix = "org.osate.assure.tests/models/SimpleControlSystem/"
	val propertiesprefix = projectprefix+"Properties/"
	val aadlprefix = projectprefix+"aadl/"
	var primaryroot = null

	@Before
	def void setUp() {
		primaryroot = alisaTestHelper.parseFile(aadlprefix+"SimpleControlSystem.aadl"
			,propertiesprefix+"ACVIP.aadl", propertiesprefix+"Physical.aadl",
			aadlprefix+"PhysicalResources.aadl",aadlprefix+"DataDictionary.aadl",
			aadlprefix+"Platform.aadl",aadlprefix+"Software.aadl", aadlprefix+"DigitalControlSystem.aadl"
		)
	}

	@Test
	def void SCSAadltest() {
		val pkg = primaryroot as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'SCS.tier1'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'SCS.tier1'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals("SCS_tier1_Instance", instance.name)
//		val engine = new ExecutePythonUtil
//		val scriptURL = "platform:/plugin/org.osate.assure.test/alisa_consistency/modelstatistics2.py";
//		engine.runPythonScript(scriptURL,instance);
	}

	
}