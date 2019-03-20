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
