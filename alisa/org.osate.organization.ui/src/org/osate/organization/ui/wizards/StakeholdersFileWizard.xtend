package org.osate.organization.ui.wizards

import java.util.Map
import org.osate.alisa.common.ui.wizards.AbstractAlisaFileWizard
import org.osate.organization.ui.internal.OrganizationActivator

class StakeholdersFileWizard extends AbstractAlisaFileWizard {
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