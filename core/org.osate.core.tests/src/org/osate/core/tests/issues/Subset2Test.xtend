package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Subset2Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue480() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "main.subset" not found', cls.exists[name == 'main.subset'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'main.subset'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals('main_subset_Instance', instance.name)

		// check if there are 6 connections
		val connections = instance.connectionInstances
		assertTrue('In main_subset_Instance: Expected 6 connections but found ' + connections.size, connections.size == 6)
	}

	val aadlText = '''
package subset2

public

data mydata
end mydata;

bus genericbus
end genericbus;

-- bi-directional sub feature group
feature group fgsub1
features
	f1 : in data port mydata;
	f2 : in data port mydata;	
	f4 : out data port mydata;	
end fgsub1;

-- bi-directional subset feature group
feature group fgsub2
features
	f3 : in data port mydata;
	f4 : out data port mydata;	
	b1: provides bus access genericbus;
end fgsub2;


-- Here, we have all
-- the features within the same feature group.
feature group fgfull
features
	f1 : out data port mydata;
	f2 : out data port mydata;
	f3 : out data port mydata;
	f4 : in data port mydata;	
	b1: requires bus access genericbus;
end fgfull;

--  sfull uses the feature group with
--  all the features.
system sfull
features
	f : feature group fgfull;
end sfull;


--  sbus uses the bus feature group
system sub2
features
	f : feature group fgsub2;
end sub2;


--  sport uses the ports feature group.
system sub1
features
	f : feature group fgsub1;
end sub1;

system main
end main;


--  We use Subset matching to allow DDS type of support.
system implementation main.subset
subcomponents
	sfull 	: system sfull;
	sub1 : system sub1;
	sub2 : system sub2;
	connections
	-- subc1 will generate connections in one direction only
	-- f4 is not included as it goes in the opposite direction to the connection.
	sub1c : feature group sfull.f -> sub1.f {Classifier_Matching_Rule => subset;};
	-- subc2 includes connections in both directions.
	sub2c : feature group sfull.f <-> sub2.f {Classifier_Matching_Rule => subset;};
end main.subset;
	
end subset2;
'''}
