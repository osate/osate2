package org.osate.xtext.aadl2.ui

import com.google.inject.Binder
import com.google.inject.Module
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution
import org.osate.xtext.aadl2.ui.builder.Aadl2ToBeBuiltComputerContribution

class Aadl2SharedStateContributingModule implements Module {
	override configure(Binder binder) {
		binder.bind(IToBeBuiltComputerContribution).to(Aadl2ToBeBuiltComputerContribution)
	}
}