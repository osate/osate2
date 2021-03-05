/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
import java.util.List
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue818Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue818/"
	val static TEST_FILE = "issue.aadl"
	
	val static FEATURES = #[ "in1", "x", "y" ]
	val static EXTENDED_FEATURES = #[ "in1", "x", "y", "in2" ]
	val static INVERSE_FEATURES = #[ "out1", "xx", "yy" ]
	val static INVERSE_EXTENDED_FEATURES = #[ "out1", "xx", "yy", "out2" ]

	@Test
	def void testFeatureGroups() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + TEST_FILE)
		
		val instance = getSystemInstance(pkg, "TestSys.Impl", "TestSys_Impl_Instance")

		testFeatureGroupFeature(instance, "featureGroup", FEATURES)
		testFeatureGroupFeature(instance, "inverseInferred", FEATURES)
		testFeatureGroupFeature(instance, "inverseExplicit", INVERSE_FEATURES)
		
		testFeatureGroupFeature(instance, "extendedFeatureGroup", EXTENDED_FEATURES)
		testFeatureGroupFeature(instance, "inverseExtendedInferred", EXTENDED_FEATURES)
		testFeatureGroupFeature(instance, "inverseExtendedExplicit", INVERSE_EXTENDED_FEATURES)
		
		testFeatureGroupFeature(instance, "emptyExtendedFeatureGroup", FEATURES)
		/* In the original issue, this was the problem case: OSATE was inferring the 
		 * members in1, x, and y.
		 */
		testFeatureGroupFeature(instance, "inverseEmptyExtendedExplicit", INVERSE_FEATURES)
	}

	private def static void testFeatureGroupFeature(SystemInstance system, String featureName, List<String> fgFeatureNames) {
		val featureInstance = system.featureInstances.findFirst[name == featureName]
		assertNotNull("Expected to find a feature named '" + featureName + "'", featureInstance)
		featureInstance => [
			assertTrue("Feature group instance '" + featureName + "' is expected to have exactly " + fgFeatureNames.size() + " features", featureInstances.size() == fgFeatureNames.size())
			for (var i = 0; i < fgFeatureNames.size(); i++) {
				assertTrue("Feature group instance '" + featureName + "' is expected to have a feature named '" + fgFeatureNames.get(i) + "' at index " + i, featureInstances.get(i).name.equals(fgFeatureNames.get(i)))
			}
		]
	} 

	private def static SystemInstance getSystemInstance(
		AadlPackage pkg, String systemImplName, String expectedInstanceName
	) {
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + systemImplName + '" not found', cls.exists[name == systemImplName])
		
		// Instantiate system
		val sysImpl = cls.findFirst[name == systemImplName] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(expectedInstanceName, instance.name)
		return instance
		
	}
}
