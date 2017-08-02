package org.osate.aadl2.errormodel.tests

import org.eclipse.xtext.testing.IInjectorProvider
import org.osate.xtext.aadl2.errormodel.ui.MyErrorModelActivator

class ErrorModelUiInjectorProvider implements IInjectorProvider {
	override getInjector() {
		MyErrorModelActivator.instance.getInjector(MyErrorModelActivator.ORG_OSATE_XTEXT_AADL2_ERRORMODEL_ERRORMODEL)
	}
}