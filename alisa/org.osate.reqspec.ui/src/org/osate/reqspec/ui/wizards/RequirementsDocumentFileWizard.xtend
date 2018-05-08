package org.osate.reqspec.ui.wizards

import com.google.inject.Inject
import java.io.StringReader
import java.util.Map
import org.eclipse.xtext.parser.IParser
import org.osate.reqspec.services.ReqSpecGrammarAccess
import org.osate.reqspec.ui.internal.ReqSpecActivator
import org.osate.ui.wizards.AbstractNewFileWizard

class RequirementsDocumentFileWizard extends AbstractNewFileWizard {
	val DOCUMENT_LABEL = "Document name"
	
	@Inject IParser parser
	@Inject ReqSpecGrammarAccess grammarAccess
	
	new() {
		super("Requirements Document", "reqdoc", 1, ReqSpecActivator.instance.log, "org.osate.reqspec.ui")
		addField(DOCUMENT_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.qualifiedNameRule, new StringReader(fieldValue)).hasSyntaxErrors
		])
	}
	
	override fileContents(Map<String, String> fieldValues) {
		'''
			document «fieldValues.get(DOCUMENT_LABEL)» [
				
			]'''
	}
}