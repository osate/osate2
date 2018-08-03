package org.osate.categories.ui.wizards

import java.util.Map
import org.osate.categories.ui.internal.CategoriesActivator
import org.osate.ui.wizards.AbstractNewFileWizard

package abstract class AbstractCategoriesFileWizard extends AbstractNewFileWizard {
	new(String fileType, String fileExtension) {
		super(fileType, fileExtension, 0, CategoriesActivator.instance.log, "org.osate.categories.ui")
		addField(fileType + " file name", [fieldValue | !fieldValue.startsWith(".")])
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