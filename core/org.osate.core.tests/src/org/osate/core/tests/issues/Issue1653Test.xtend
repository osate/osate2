package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.RealLiteral
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1653Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void scope_A() {

		val p = '''
				package issue1653
				public
				  with ps;
				  
				  system S
				    properties
				      ps::prop => 1_000.000_1;
				  end S;
				  
				end 1653;
			'''
		val ps = '''
				property set ps is
				  prop: aadlreal applies to (system);
				end ps;
			'''

		val pkg = testHelper.parseString(p, ps)

		assertAllCrossReferencesResolvable(pkg)
		
		val pas = pkg.ownedPublicSection.ownedClassifiers.head.ownedPropertyAssociations
		Assert.assertEquals("prop", pas.head.property.name)
		Assert.assertEquals(1000.0001, (pas.head.ownedValues.head.ownedValue as RealLiteral).value, 0.00001)
	}

}
