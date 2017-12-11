package org.osate.verify.ui.wizards

import com.google.inject.Inject
import java.io.StringReader
import java.util.Map
import org.eclipse.xtext.parser.IParser
import org.osate.ui.wizards.AbstractNewFileWizard
import org.osate.verify.services.VerifyGrammarAccess
import org.osate.verify.ui.internal.VerifyActivator

class VerificationPlanFileWizard extends AbstractNewFileWizard {
	val VERIFICATION_PLAN_LABEL = "Verification Plan Name"
	val REQUIREMENT_SET_LABEL = "Requirement Set"
	
	@Inject IParser parser
	@Inject VerifyGrammarAccess grammarAccess
	
	new() {
		super("Verification Plan", "verify", 1, VerifyActivator.instance.log, "org.osate.verify.ui")
		addField(VERIFICATION_PLAN_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.qualifiedNameRule, new StringReader(fieldValue)).hasSyntaxErrors
		])
		addField(REQUIREMENT_SET_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.qualifiedNameRule, new StringReader(fieldValue)).hasSyntaxErrors
		])
	}
	
	override fileContents(Map<String, String> fieldValues) {
		'''
			verification plan «fieldValues.get(VERIFICATION_PLAN_LABEL)» for «fieldValues.get(REQUIREMENT_SET_LABEL)» [
				
			]'''
	}
}