package org.osate.xtext.aadl2.properties.ui

import com.google.inject.Binder
import com.google.inject.Module
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution
import org.osate.xtext.aadl2.properties.ui.builder.PropertiesToBeBuiltComputerContribution

class PropertiesSharedStateContributingModule implements Module {
	override configure(Binder binder) {
		binder.bind(IToBeBuiltComputerContribution).to(PropertiesToBeBuiltComputerContribution)
	}
}