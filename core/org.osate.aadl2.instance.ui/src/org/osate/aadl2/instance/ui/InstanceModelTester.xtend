package org.osate.aadl2.instance.ui

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.core.expressions.PropertyTester
import org.eclipse.core.resources.IFile
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.XtextResourceSet
import org.osate.aadl2.instance.SystemInstance
import org.osate.xtext.aadl2.instance.ui.internal.InstanceActivator

class InstanceModelTester extends PropertyTester {
	@Inject
	Provider<XtextResourceSet> resourceSetProvider
	
	new() {
		val injector = InstanceActivator.instance.getInjector(InstanceActivator.ORG_OSATE_XTEXT_AADL2_INSTANCE_INSTANCE)
		injector.injectMembers(this)
	}
	
	override test(Object receiver, String property, Object[] args, Object expectedValue) {
		switch receiver {
			IFile case property == "isInstanceModel": {
				val uri = URI.createPlatformResourceURI(receiver.fullPath.toString, false)
				val resource = resourceSetProvider.get.getResource(uri, true)
				resource?.contents?.head instanceof SystemInstance
			}
			default: false
		}
	}
}