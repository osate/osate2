package org.osate.categories.ui.wizards

import org.osate.alisa.common.ui.wizards.AbstractAlisaFileWizard
import org.osate.categories.ui.internal.CategoriesActivator
import java.util.Map

package abstract class AbstractCategoriesFileWizard extends AbstractAlisaFileWizard {
	new(String fileType, String fileExtension) {
		super(fileType, fileExtension, 0, CategoriesActivator.instance.log, "org.osate.categories.ui")
		addField(fileType + " File Name", [fieldValue | !fieldValue.startsWith(".")])
	}
	
	override fileContents(Map<String, String> fieldValues) {
		""
	}
	
	override protected getFileName(String enteredName) {
		if (enteredName.endsWith("." + fileExtension)) {
			enteredName
		} else {
			enteredName + "." + fileExtension
		}
	}
}