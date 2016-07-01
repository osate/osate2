package org.osate.xtext.aadl2.properties.ui

import org.eclipse.ui.IStartup
import org.osate.xtext.aadl2.properties.PropertiesRuntimeModule

class PropertiesUiStartup implements IStartup {
	override earlyStartup() {
		new PropertiesRuntimeModule
	}
}