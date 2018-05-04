/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.reqspec.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.reqspec.ReqSpecInjectorProvider
import org.osate.reqspec.reqSpec.ReqSpec

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ReqSpecInjectorProvider))
class ReqSpecTests {
	
	@Inject extension ParseHelper<ReqSpec>
	@Inject extension ValidationTestHelper
	
	@Test
	// we need to remove the AADL reference here because AADL does not test headlessly
	def void testCorrectParsing() {
		'''
			stakeholder goals SCSgoals for "some ref" [
				goal g1 : "Safety" [
					description "The system shall be safe."
					rationale "This is a control system, whose failure affects lives. "
				]
			]
		'''.parse.assertNoErrors
	}
	
	@Test
  	def void testParsing() {
	      //goals
	      val model = '''
	          stakeholder goals SCSgoals for "some ref" 
	          [
		          goal g1 : "Safety" 
		          [
			          description "The system shall be safe."
			          rationale "This is a control system, whose failure affects lives. "
			          stakeholder sei.phf sei.dpg
		          ]
	          ]
	      '''.parse
      }
      
      @Test
      def void testDupeGoals() {
      		val model = '''
      		stakeholder goals braking_goals 
			[
				goal reliability_1 : "The braking system should work without issue"
				[
					description "We should be able to power the bulb"
					rationale "Braking is critical"
				]
				
				goal reliability_1 : "The braking system should work without issue"
				[
					description "We should be able to power the bulb"
					rationale "Braking is critical"
				]
			]'''.parse
			//must generate an error
			Assert::fail("Duplicate identifiers")
			// TODO: insert validation code here to handle gracefully.
      }
}