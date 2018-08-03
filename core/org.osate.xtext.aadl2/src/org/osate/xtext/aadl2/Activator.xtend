package org.osate.xtext.aadl2

import org.eclipse.core.runtime.Plugin
import org.osgi.framework.BundleContext

class Activator extends Plugin {
	static Activator plugin
	
	override start(BundleContext context) throws Exception {
		super.start(context)
		plugin = this
	}
	
	override stop(BundleContext context) throws Exception {
		plugin = null
		super.stop(context)
	}
	
	def static getDefault() {
		plugin
	}
}