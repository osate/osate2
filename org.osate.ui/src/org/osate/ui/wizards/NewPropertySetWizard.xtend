package org.osate.ui.wizards

import org.osate.ui.OsateUiPlugin
import java.util.Map

class NewPropertySetWizard extends AbstractNewFileWizard {
	val PROPERTY_SET_LABEL = "Property Set Name"
	
	new() {
		super("AADL Property Set", "aadl", 1, OsateUiPlugin.^default.log, OsateUiPlugin.PLUGIN_ID)
		addField(PROPERTY_SET_LABEL, [fieldValue | isValidId(fieldValue)])
	}
	
	override fileContents(Map<String, String> fieldValues) {
		val propertySetName = fieldValues.get(PROPERTY_SET_LABEL)
		'''
			property set «propertySetName» is
				
			end «propertySetName»;'''
	}
}