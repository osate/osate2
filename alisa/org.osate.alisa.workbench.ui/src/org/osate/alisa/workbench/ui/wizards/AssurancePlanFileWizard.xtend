package org.osate.alisa.workbench.ui.wizards

import com.google.inject.Inject
import java.io.StringReader
import org.eclipse.xtext.parser.IParser
import org.osate.alisa.common.ui.wizards.AbstractAlisaFileWizard
import org.osate.alisa.workbench.services.AlisaGrammarAccess
import org.osate.alisa.workbench.ui.internal.AlisaActivator
import java.util.Map

class AssurancePlanFileWizard extends AbstractAlisaFileWizard {
	val CASE_LABEL = "Assurance Case Name"
	val PLAN_LABEL = "First Assurance Plan Name"
	val IMPLEMENTATION_LABEL = "Component Implementation"
	
	@Inject IParser parser
	@Inject AlisaGrammarAccess grammarAccess
	
	new() {
		super("Assurance Plan", "alisa", 3, AlisaActivator.instance.log, "org.osate.alisa.workbench.ui")
		addField(CASE_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.qualifiedNameRule, new StringReader(fieldValue)).hasSyntaxErrors
		])
		addField(PLAN_LABEL, [fieldValue | isValidId(fieldValue)])
		addField(IMPLEMENTATION_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.aadlClassifierReferenceRule, new StringReader(fieldValue)).hasSyntaxErrors &&
			fieldValue.contains(".")
		])
	}
	
	override fileContents(Map<String, String> fieldValues) {
		val implementationName = fieldValues.get(IMPLEMENTATION_LABEL)
		val typeName = implementationName.substring(0, implementationName.indexOf("."))
		'''
			assurance case «fieldValues.get(CASE_LABEL)» for «typeName» [
				assurance plan «fieldValues.get(PLAN_LABEL)» for «implementationName» [
					
				]
			]'''
	}
}