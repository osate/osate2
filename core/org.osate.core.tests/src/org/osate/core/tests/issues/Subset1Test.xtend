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
class Subset1Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue480() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "top.i" not found', cls.exists[name == 'top.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'top.i'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
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
