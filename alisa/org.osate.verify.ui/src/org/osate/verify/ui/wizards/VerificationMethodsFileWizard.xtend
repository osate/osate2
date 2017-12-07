package org.osate.verify.ui.wizards

import com.google.inject.Inject
import java.io.StringReader
import org.eclipse.xtext.parser.IParser
import org.osate.alisa.common.ui.wizards.AbstractAlisaFileWizard
import org.osate.verify.services.VerifyGrammarAccess
import org.osate.verify.ui.internal.VerifyActivator
import java.util.Map

class VerificationMethodsFileWizard extends AbstractAlisaFileWizard {
	val VERIFICATION_METHODS_LABEL = "Verification Methods Name"
	
	@Inject IParser parser
	@Inject VerifyGrammarAccess grammarAccess
	
	new() {
		super("Verification Methods", "methodregistry", 1, VerifyActivator.instance.log, "org.osate.verify.ui")
		addField(VERIFICATION_METHODS_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.qualifiedNameRule, new StringReader(fieldValue)).hasSyntaxErrors
		])
	}
	
	override fileContents(Map<String, String> fieldValues) {
		'''
			verification methods «fieldValues.get(VERIFICATION_METHODS_LABEL)» [
				
			]'''
	}
}