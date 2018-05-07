package org.osate.reqspec.ui.wizards

import com.google.inject.Inject
import java.io.StringReader
import java.util.Map
import org.eclipse.xtext.parser.IParser
import org.osate.reqspec.services.ReqSpecGrammarAccess
import org.osate.reqspec.ui.internal.ReqSpecActivator
import org.osate.ui.wizards.AbstractNewFileWizard

class StakeholderGoalsFileWizard extends AbstractNewFileWizard {
	val STAKEHOLDER_GOALS_LABEL = "Stakeholder goals name"
	val TARGET_LABEL = "Classifier or category"
	
	@Inject IParser parser
	@Inject ReqSpecGrammarAccess grammarAccess
	
	new() {
		super("Stakeholder Goals", "goals", 1, ReqSpecActivator.instance.log, "org.osate.reqspec.ui")
		addField(STAKEHOLDER_GOALS_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.qualifiedNameRule, new StringReader(fieldValue)).hasSyntaxErrors
		])
		addField(TARGET_LABEL, [fieldValue |
			!parser.parse(grammarAccess.aadlClassifierReferenceRule, new StringReader(fieldValue)).hasSyntaxErrors ||
			!parser.parse(grammarAccess.componentCategoryRule, new StringReader(fieldValue)).hasSyntaxErrors
		])
	}
	
	override fileContents(Map<String, String> fieldValues) {
		'''
			stakeholder goals «fieldValues.get(STAKEHOLDER_GOALS_LABEL)» for «fieldValues.get(TARGET_LABEL)» [
				
			]'''
	}
}