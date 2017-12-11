package org.osate.ui.wizards

import com.google.inject.Inject
import java.io.StringReader
import java.util.Map
import org.eclipse.xtext.parser.IParser
import org.osate.ui.OsateUiPlugin
import org.osate.workspace.WorkspacePlugin
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess
import org.osate.xtext.aadl2.ui.MyAadl2Activator

class NewAadlPackageWizard extends AbstractNewFileWizard {
	val PACKAGE_LABEL = "Aadl Package Name"
	
	@Inject IParser parser
	@Inject Aadl2GrammarAccess grammarAccess
	
	new() {
		super("AADL Package", "aadl", 1, OsateUiPlugin.^default.log, OsateUiPlugin.PLUGIN_ID)
		MyAadl2Activator.instance.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).injectMembers(this)
		addField(PACKAGE_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.PNAMERule, new StringReader(fieldValue)).hasSyntaxErrors
		])
	}
	
	override fileContents(Map<String, String> fieldValues) {
		val packageName = fieldValues.get(PACKAGE_LABEL)
		'''
			package «packageName»
			public
				
			end «packageName»;'''
	}
	
	override protected getFileName(String enteredName) {
		super.getFileName(enteredName).replaceAll(WorkspacePlugin.AADL_PACKAGE_SEPARATOR,
			WorkspacePlugin.FILE_PACKAGE_SEPARATOR
		)
	}
}