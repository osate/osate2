package org.osate.ui.wizards

import org.osate.ui.OsateUiPlugin
import org.osate.xtext.aadl2.ui.MyAadl2Activator
import org.eclipse.core.resources.IContainer
import org.osate.xtext.aadl2.ui.util.Aadl2NameValidators

abstract class AbstractNewModelUnitWizard extends AbstractNewFileWizard {
	new(String titleFileType, String descriptionFileType) {
		super(titleFileType, descriptionFileType, "aadl", 1, OsateUiPlugin.^default.log, OsateUiPlugin.PLUGIN_ID)
		MyAadl2Activator.instance.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).injectMembers(this)
	}
			
	/* Not going to get here if no project is selected, so parent will never be null */
	override String validateFileName(IContainer parent, String modelUnitName) {
		Aadl2NameValidators.validateFileNameInScope(parent, modelUnitName)
	}
}