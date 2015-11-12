package org.osate.organization.tests

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.osate.organization.OrganizationInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.osate.organization.organization.Organization
import com.google.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.osate.organization.organization.OrganizationPackage
import org.osate.organization.validation.OrganizationValidator

@RunWith(typeof(XtextRunner))
	@InjectWith(typeof(OrganizationInjectorProvider))

class StakeholderTest {
	@Inject extension ParseHelper<Organization>
	@Inject extension ValidationTestHelper
	
	@Test
	def void testParsing() {
		val organization = '''
		organization Feiler
		stakeholder Peter
		'''.parse
		val sh = organization.stakeholder.get(0)
		Assert::assertEquals("Peter", sh.name)
		Assert::assertEquals("Feiler",organization.name)
	}
	
	@Test
	def void testValidation(){
		val organization = '''
		organization Feiler
		stakeholder Peter
		stakeholder Peter
		'''.parse
		organization.assertError(OrganizationPackage::eINSTANCE.stakeholder,
			OrganizationValidator::DUPLICATE_STAKEHOLDER,
			"Duplicate stakeholder 'Peter'")
		organization.assertError(OrganizationPackage::eINSTANCE.stakeholder,
			OrganizationValidator::DUPLICATE_STAKEHOLDER,
			"Duplicate stakeholder 'Peter'")
	}
}