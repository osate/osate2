package org.osate.core.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class PropertyTests extends OsateTest {
	@Test
	def void scope_A() {

		createFiles(
			"p1.aadl" -> '''
				package p1
				public
				  with p, ps1, ps;
				  
				  system s1 extends p::s
				    properties
				      ps::prop => 10cm;
				      ps1::prop1 => 10cm;
				      period => 1sec;
				  end s1;
				  
				  system implementation s1.i
				  subcomponents
				    d: data;
				  end s1.i;
				  
				end p1;
			''',
			"ps1.aadl" -> '''
				property set ps1 is
				  len_units1: type units (cm, m => cm * 100);
				  prop1: aadlinteger units ps1::len_units1 applies to (system);
				end ps;
			''',
			"ps.aadl" -> '''
				property set ps is
				  len_units: type units (cm, m => cm * 100);
				  prop: aadlinteger units ps::len_units applies to (system);
				end ps;
			''',
			"p.aadl" -> '''
				package p
				public
				  with ps;
				  
				  system s
				    properties
				      ps::prop => 10cm;
				  end s;
				  
				end p;
			''')

		suppressSerialization
		val result = testFile("p1.aadl")

		val pkg = result.resource.contents.head as AadlPackage
		assertAllCrossReferencesResolvable(pkg)
		
		val pas = pkg.ownedPublicSection.ownedClassifiers.head.ownedPropertyAssociations
		Assert.assertEquals("prop", pas.head.property.name)
		Assert.assertEquals("Period", pas.last.property.name)
		
		// instantiate
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.last as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		Assert.assertEquals("s1_i_Instance", instance.name)
		Assert.assertEquals(1, instance.componentInstances.size)
		Assert.assertEquals("d", instance.componentInstances.head.name)
	}

}
