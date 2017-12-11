package org.osate.reqspec.ui.wizards

import com.google.inject.Inject
import java.io.StringReader
import java.util.Map
import org.eclipse.xtext.parser.IParser
import org.osate.reqspec.services.ReqSpecGrammarAccess
import org.osate.reqspec.ui.internal.ReqSpecActivator
import org.osate.ui.wizards.AbstractNewFileWizard

class ConstantsFileWizard extends AbstractNewFileWizard {
	val CONSTANTS_LABEL = "Constants Name"
	
	@Inject IParser parser
	@Inject ReqSpecGrammarAccess grammarAccess
	
	new() {
		super("Constants", "constants", 1, ReqSpecActivator.instance.log, "org.osate.reqspec.ui")
		addField(CONSTANTS_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.qualifiedNameRule, new StringReader(fieldValue)).hasSyntaxErrors
		])
	}
	
	override fileContents(Map<String, String> fieldValues) {
		'''
			constants «fieldValues.get(CONSTANTS_LABEL)» [
				
			]'''
	}
}