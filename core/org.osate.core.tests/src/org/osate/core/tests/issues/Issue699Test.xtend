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
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class Issue699Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue699() {

		val pkg = testHelper.parseString(aadlText, psText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation S.i not found', cls.exists[name == 'S.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'S.i'] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val reporter = errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter
		val messages = reporter.errors
		assertEquals('S_i_Instance', instance.name)

		assertEquals(messages.size, 1)
		assertEquals(messages.head.message, "Property ps699::p has cyclic value")
	}

	val aadlText = '''
		package issue699
		public
			with ps699;
			system S
			end S;
			
			system implementation S.i
				properties
					ps699::p => ps699::q;
					ps699::q => ps699::p;
			end S.i;
		
		end issue699;
	'''
	val psText = '''
		property set ps699 is
			p: aadlinteger applies to (all);
			q: aadlinteger applies to (all);
		end ps699;
	'''
}
