package org.osate.organization.ui.wizards

import java.util.Map
import org.osate.organization.ui.internal.OrganizationActivator
import org.osate.ui.wizards.AbstractNewFileWizard

class StakeholdersFileWizard extends AbstractNewFileWizard {
	val ORGANIZATION_LABEL = "Organization Name"
	val STAKEHOLDER_LABEL = "First Stakeholder Name"
	
	new() {
		super("Stakeholders", "org", 1, OrganizationActivator.instance.log, "org.osate.organization.ui")
		addField(ORGANIZATION_LABEL, [fieldValue | isValidId(fieldValue)])
		addField(STAKEHOLDER_LABEL, [fieldValue | isValidId(fieldValue)])
	}
	
	override fileContents(Map<String, String> fieldValues) {
		'''
			organization «fieldValues.get(ORGANIZATION_LABEL)»
			stakeholder «fieldValues.get(STAKEHOLDER_LABEL)» [
				
			]'''
	}
}