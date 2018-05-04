package org.osate.ui.wizards

import java.util.Map

final class NewPropertySetWizard extends AbstractNewModelUnitWizard {
	val static PROPERTY_SET_LABEL = "AADL property set name"
	
	new() {
		super("AADL Property Set", "AADL property set")
		/* Property set names are required to be an identifier, which is ID in the parser.  But ID a 
		 * terminal lexical item and not a parse rule.  So we use INAME which is a parse rule
		 * defined by a simple ID.
		 */
		addField(PROPERTY_SET_LABEL, getFieldValidator(grammarAccess.INAMERule))
	}
	
	override fileContents(Map<String, String> fieldValues) {
		val propertySetName = fieldValues.get(PROPERTY_SET_LABEL)
		'''
			property set «propertySetName» is
				
			end «propertySetName»;'''
	}
}