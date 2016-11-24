package org.osate.core.tests.issues

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Subset2Test extends OsateTest {
	override getProjectName() {
		"subset1"
	}

	@Test
	def void issue480() {
		val aadlFile = "subset2.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "main.subset" not found', cls.exists[name == 'main.subset'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'main.subset'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals('main_subset_Instance', instance.name)

		// check if there are 5 connections
		val connections = instance.connectionInstances
		assertTrue('In main_subset_Instance: Expected 5 connections but found ' + connections.size, connections.size == 5)
	}

	val aadlText = '''
package subset1

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
