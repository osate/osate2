package org.osate.core.tests.issues

import com.itemis.xtext.testing.XtextRunner2
import org.eclipse.xtext.junit4.InjectWith
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
class Subset1Test extends OsateTest {
	override getProjectName() {
		"subset1"
	}

	@Test
	def void issue480() {
		val aadlFile = "subset1.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "top.i" not found', cls.exists[name == 'top.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'top.i'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals('top_i_Instance', instance.name)

		// check if there are 6 connections
		val connections = instance.connectionInstances
		assertTrue('In top_i_Instance: Expected 6 connections but found ' + connections.size, connections.size == 6)
	}

	val aadlText = '''
package subset1
public
	
	-- Feature Groups
	feature group Sense_Whole
      features
	    D1  : in data port;
        D2  : in data port;
        D3  : in data port;
        D4  : in data port;
        D5  : in data port;
	end Sense_Whole;
		
	feature group Sense_Part_1
	  features
	    D1  : in data port;
        D2  : in data port;
        D3  : in data port;
	end Sense_Part_1;
	
   feature group Sense_Part_2
	  features
	    D4  : in data port;
        D5  : in data port;
	end Sense_Part_2;
	
 -- containing system	
   system top
   	features
		Sense : feature group Sense_Whole;
		Senseout : feature group inverse of Sense_Whole;
	end top;
	
	system implementation top.i
		subcomponents
			S1: system Sub1.base;
			S2: system Sub2.base;			
		connections
		  ---  feature group on containing component split into two feature groups
		  Sub1_Sensed: feature group Sense -> S2.Sense ;
		  Sub2Out_Sensed: feature group S2.SenseOut -> Senseout;
	      Sub2_Sensed: feature group S1.Sense -> S2.Sense; 
		properties
			Classifier_Matching_Rule => Subset ;
	end top.i;
	
	
   -- Sub Components	
	
	system Sub1
		features
		-- SSH Sensed
		Sense : feature group inverse of Sense_Whole;       
	end Sub1;
    system implementation Sub1.base
    	subcomponents
    		s1: system subP;
    		s2: system subP;
    		s3: system subP;
    	connections
    		c1: port s1.outp -> Sense.D4;
    		c2: port s2.outp -> Sense.D5;
    		c3: port s3.outp -> Sense.D3;
    end Sub1.base;
    
    system Sub2
    	features
		Sense : feature group Sense_Part_2;       
		SenseOut : feature group inverse of Sense_Part_2;       
	end Sub2;
    system implementation Sub2.base
    	subcomponents
    		s1: system subP;
    		s2: system subP;
    	connections
    		c1: port Sense.D4 -> s1.inp;
    		c2: port Sense.D5 -> s2.inp;
    end Sub2.base;
    
    system subP
    	features
    		inp: in data port;
    		outp: out data port;
    end subP;
	
end subset1;
'''}
