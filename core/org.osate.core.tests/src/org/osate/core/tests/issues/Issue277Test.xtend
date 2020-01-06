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
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue277Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper;
	
	@Test
	def void issue277() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('Feature group type "TestInvExtendedFeatureGroup" not found', cls.exists[name == 'TestInvExtendedFeatureGroup'])

		val fgt = cls.findFirst[name == 'TestInvExtendedFeatureGroup']

		// check that the fgt contains the expected features
		val features = fgt.allFeatures
		val names = features.map[name]
		
		/* 2019-01-19: added check for feature q from root feature group type BaseFG.  FeatureGroupTypeImpl.getAllFeatures() 
		 * used to be broken and was fixed in Issue 1657.  So now 'q' is correctly returned here, but wasn't here before.
		 */
		assertTrue('Feature "q" not in feature group', names.contains('q'))
		assertTrue('Feature "o" not in feature group', names.contains('o'))
		assertTrue('Feature "r" not in feature group', names.contains('r'))
		/* 2019-01-19: As above, this was changed to reflect that there should now be exactly 3 features.  I assume
		 * the original intent of this check is to verify that the refined feature p from TestExtendedFeatureGroup is 
		 * part of the inverse feature group.
		 */
		assertTrue('Expected three features but found ' + features.size + ': ' + names, features.size == 3)
	}

	val aadlText = '''
		package issue277
		public
			system TestSys
				features
					fg1: feature group TestExtendedFeatureGroup;
					fg2: feature group TestInvExtendedFeatureGroup;
			end TestSys;
		
			system TestSubSys
			end TestSubSys;
		
			system implementation TestSys.Impl
			end TestSys.Impl;
		
		  feature group BaseFG
		  	features
		  		q: feature;
		  end BaseFG;
		  
			feature group TestFeatureGroup extends BaseFG
				features
					i: in feature;
					p: in feature;
			end TestFeatureGroup;
		
			feature group TestExtendedFeatureGroup extends TestFeatureGroup
				features
					p: refined to in data port;
			end TestExtendedFeatureGroup;
		
			feature group TestInvFeatureGroup
				features
					o: out feature;
					r: out feature;
				inverse of TestFeatureGroup
			end TestInvFeatureGroup;
		
			feature group TestInvExtendedFeatureGroup extends TestInvFeatureGroup
				inverse of TestExtendedFeatureGroup
			end TestInvExtendedFeatureGroup;
		end issue277;
	'''
}
