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

package org.osate.organization.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.organization.OrganizationInjectorProvider
import org.osate.organization.organization.Organization
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