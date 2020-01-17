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
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.ListValue
import org.osate.aadl2.RangeValue
import org.osate.aadl2.RecordValue
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue835Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue835() {
		val pkg = testHelper.parseString(aadlText, psText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('Component implementation "C.i" not found', cls.exists[name == 'C.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'C.i'] as AbstractImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals('C_i_Instance', instance.name)

		// check if Property associations have correct values
		val pas = instance.ownedPropertyAssociations
		val exp0 = pas.get(0).ownedValues.get(0).ownedValue as RecordValue
		val f0 = exp0.ownedFieldValues.get(0).ownedValue as IntegerLiteral
		assertTrue('Expected value 2 for ps835::rp.f', f0.value == 2)
		val f1 = exp0.ownedFieldValues.get(1).ownedValue as ListValue
		val e0 = f1.ownedListElements.get(0) as IntegerLiteral
		assertTrue('Expected value 2 for ps835::rp.f1#0', e0.value == 2)
		val e1 = f1.ownedListElements.get(0) as IntegerLiteral
		assertTrue('Expected value 2 for ps835::rp.f1#1', e1.value == 2)
		val exp1 = pas.get(1).ownedValues.get(0).ownedValue as RangeValue
		val min = exp1.minimum as IntegerLiteral
		assertTrue('Expected value 2 for min compute execution time', min.value == 2)
		val max = exp1.maximum as IntegerLiteral
		assertTrue('Expected value 2 for max compute execution time', max.value == 2)
	}

	val psText = '''
		property set ps835 is
			c: constant Time => 2ms;
			rt: type record (f: Time; f1: list of Time;);
			rp: ps835::rt applies to (all);
		end ps835;
	'''
	
	val aadlText = '''
		package issue835
		public
			with ps835;
			abstract C
			end C;
			
			abstract implementation C.i
				properties
					ps835::rp => [f => ps835::c; f1 => (ps835::c, ps835::c);];
					compute_execution_time => ps835::c .. ps835::c;
			end C.i;
		
		end issue835;
	'''
}