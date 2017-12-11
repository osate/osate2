package org.osate.reqspec.ui.wizards

import com.google.inject.Inject
import java.io.StringReader
import java.util.Map
import org.eclipse.xtext.parser.IParser
import org.osate.reqspec.services.ReqSpecGrammarAccess
import org.osate.reqspec.ui.internal.ReqSpecActivator
import org.osate.ui.wizards.AbstractNewFileWizard

class GlobalRequirementsFileWizard extends AbstractNewFileWizard {
	val GLOBAL_REQUIREMENTS_LABEL = "Global Requirements Name"
	
	@Inject IParser parser
	@Inject ReqSpecGrammarAccess grammarAccess
	
	new() {
		super("Global Requirements", "reqspec", 1, ReqSpecActivator.instance.log, "org.osate.reqspec.ui")
		addField(GLOBAL_REQUIREMENTS_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.qualifiedNameRule, new StringReader(fieldValue)).hasSyntaxErrors
		])
	}
	
	override fileContents(Map<String, String> fieldValues) {
		'''
			global requirements «fieldValues.get(GLOBAL_REQUIREMENTS_LABEL)» [
				
			]'''
	}
}