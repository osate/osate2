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
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue810Test {
	@Inject extension ValidationTestHelper
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue810() {
		val pkg1 = '''
			package pkg1
			public
				abstract a1
				end a1;
				
				abstract implementation a1.i
					subcomponents
						sub1: abstract a2;
						sub2: abstract a2;
					connections
						conn1: feature group sub1.fg1 -> sub2.fg2;
						conn3: feature group sub1.fg3.fg5 -> sub2.fg4.fg5;
				end a1.i;
				
				abstract a2
					features
						fg1: out feature group fgt1;
						fg2: in feature group inverse of fgt1;
						fg3: feature group fgt2;
						fg4: feature group inverse of fgt2;
				end a2;
				
				feature group fgt1
					features
						p1: out data port;
				end fgt1;
				
				feature group fgt2
					features
						fg5: out feature group fgt1;
				end fgt2;
			end pkg1;
		'''
		testHelper.parseString(pkg1).assertNoIssues
	}
}