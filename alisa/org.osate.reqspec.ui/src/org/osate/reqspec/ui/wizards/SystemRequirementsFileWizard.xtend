package org.osate.reqspec.ui.wizards

import com.google.inject.Inject
import java.io.StringReader
import java.util.Map
import org.eclipse.xtext.parser.IParser
import org.osate.reqspec.services.ReqSpecGrammarAccess
import org.osate.reqspec.ui.internal.ReqSpecActivator
import org.osate.ui.wizards.AbstractNewFileWizard

class SystemRequirementsFileWizard extends AbstractNewFileWizard {
	val SYSTEM_REQUIREMENTS_LABEL = "System requirements name"
	val CLASSIFIER_LABEL = "Classifier"
	
	@Inject IParser parser
	@Inject ReqSpecGrammarAccess grammarAccess
	
	new() {
		super("System Requirements", "reqspec", 1, ReqSpecActivator.instance.log, "org.osate.reqspec.ui")
		addField(SYSTEM_REQUIREMENTS_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.qualifiedNameRule, new StringReader(fieldValue)).hasSyntaxErrors
		])
		addField(CLASSIFIER_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.aadlClassifierReferenceRule, new StringReader(fieldValue)).hasSyntaxErrors
		])
	}
	
	override fileContents(Map<String, String> fieldValues) {
		'''
			system requirements «fieldValues.get(SYSTEM_REQUIREMENTS_LABEL)» for «fieldValues.get(CLASSIFIER_LABEL)» [
				
			]'''
	}
}