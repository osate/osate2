package org.osate.ui.wizards

import java.util.Map
import org.osate.xtext.aadl2.ui.util.Aadl2NameValidators

final class NewPropertySetWizard extends AbstractNewModelUnitWizard {
	val static PROPERTY_SET_LABEL = "AADL property set name"
	
	new() {
		super("AADL Property Set", "AADL property set")
		addField(PROPERTY_SET_LABEL, Aadl2NameValidators.ID_VALIDATOR)
	}
	
	override fileContents(Map<String, String> fieldValues) {
		val propertySetName = fieldValues.get(PROPERTY_SET_LABEL)
		'''
			property set «propertySetName» is
				
			end «propertySetName»;'''
	}
}