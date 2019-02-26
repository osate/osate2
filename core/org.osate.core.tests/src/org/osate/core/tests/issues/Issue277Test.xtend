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
