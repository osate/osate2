package org.osate.reqspec.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.osate.reqspec.reqSpec.ReqSpec
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
//import org.example.entities.entities.EntityType
//import org.example.entities.entities.BasicType
import org.osate.reqspec.ReqSpecInjectorProvider

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
	          stakeholder goals SCSgoals for "some ref" [
	          goal g1 : "Safety" [
	          description "The system shall be safe."
	          rationale "This is a control system, whose failure affects lives. "
	          stakeholder sei.phf sei.dpg
	          ]
	          ]
	      '''.parse
	      val entity = model.contents.get(0);
	      //println(entity)
      }
}