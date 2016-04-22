/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */
grammar InternalResults;

options {
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
	
}

@lexer::header {
package org.osate.results.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.osate.results.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.osate.results.services.ResultsGrammarAccess;

}

@parser::members {
 
 	private ResultsGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(ResultsGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleResultReport
entryRuleResultReport 
:
{ before(grammarAccess.getResultReportRule()); }
	 ruleResultReport
{ after(grammarAccess.getResultReportRule()); } 
	 EOF 
;

// Rule ResultReport
ruleResultReport
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getResultReportAccess().getAlternatives()); }
(rule__ResultReport__Alternatives)
{ after(grammarAccess.getResultReportAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleResultReportCollection
entryRuleResultReportCollection 
:
{ before(grammarAccess.getResultReportCollectionRule()); }
	 ruleResultReportCollection
{ after(grammarAccess.getResultReportCollectionRule()); } 
	 EOF 
;

// Rule ResultReportCollection
ruleResultReportCollection
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getResultReportCollectionAccess().getGroup()); }
(rule__ResultReportCollection__Group__0)
{ after(grammarAccess.getResultReportCollectionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleResultDataReport
entryRuleResultDataReport 
:
{ before(grammarAccess.getResultDataReportRule()); }
	 ruleResultDataReport
{ after(grammarAccess.getResultDataReportRule()); } 
	 EOF 
;

// Rule ResultDataReport
ruleResultDataReport
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getResultDataReportAccess().getGroup()); }
(rule__ResultDataReport__Group__0)
{ after(grammarAccess.getResultDataReportAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleResultContributor
entryRuleResultContributor 
:
{ before(grammarAccess.getResultContributorRule()); }
	 ruleResultContributor
{ after(grammarAccess.getResultContributorRule()); } 
	 EOF 
;

// Rule ResultContributor
ruleResultContributor
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getResultContributorAccess().getGroup()); }
(rule__ResultContributor__Group__0)
{ after(grammarAccess.getResultContributorAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleResultData
entryRuleResultData 
:
{ before(grammarAccess.getResultDataRule()); }
	 ruleResultData
{ after(grammarAccess.getResultDataRule()); } 
	 EOF 
;

// Rule ResultData
ruleResultData
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getResultDataAccess().getGroup()); }
(rule__ResultData__Group__0)
{ after(grammarAccess.getResultDataAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleIssuesReport
entryRuleIssuesReport 
:
{ before(grammarAccess.getIssuesReportRule()); }
	 ruleIssuesReport
{ after(grammarAccess.getIssuesReportRule()); } 
	 EOF 
;

// Rule IssuesReport
ruleIssuesReport
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIssuesReportAccess().getGroup()); }
(rule__IssuesReport__Group__0)
{ after(grammarAccess.getIssuesReportAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRuleDescriptionElement
entryRuleDescriptionElement 
:
{ before(grammarAccess.getDescriptionElementRule()); }
	 ruleDescriptionElement
{ after(grammarAccess.getDescriptionElementRule()); } 
	 EOF 
;

// Rule DescriptionElement
ruleDescriptionElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDescriptionElementAccess().getAlternatives()); }
(rule__DescriptionElement__Alternatives)
{ after(grammarAccess.getDescriptionElementAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}







// Entry rule entryRuleResultIssue
entryRuleResultIssue 
:
{ before(grammarAccess.getResultIssueRule()); }
	 ruleResultIssue
{ after(grammarAccess.getResultIssueRule()); } 
	 EOF 
;

// Rule ResultIssue
ruleResultIssue
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getResultIssueAccess().getGroup()); }
(rule__ResultIssue__Group__0)
{ after(grammarAccess.getResultIssueAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeRef
entryRuleTypeRef 
:
{ before(grammarAccess.getTypeRefRule()); }
	 ruleTypeRef
{ after(grammarAccess.getTypeRefRule()); } 
	 EOF 
;

// Rule TypeRef
ruleTypeRef
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeRefAccess().getAlternatives()); }
(rule__TypeRef__Alternatives)
{ after(grammarAccess.getTypeRefAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePropertyRef
entryRulePropertyRef 
:
{ before(grammarAccess.getPropertyRefRule()); }
	 rulePropertyRef
{ after(grammarAccess.getPropertyRefRule()); } 
	 EOF 
;

// Rule PropertyRef
rulePropertyRef
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPropertyRefAccess().getGroup()); }
(rule__PropertyRef__Group__0)
{ after(grammarAccess.getPropertyRefAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}







// Entry rule entryRuleAModelOrPropertyReference
entryRuleAModelOrPropertyReference 
:
{ before(grammarAccess.getAModelOrPropertyReferenceRule()); }
	 ruleAModelOrPropertyReference
{ after(grammarAccess.getAModelOrPropertyReferenceRule()); } 
	 EOF 
;

// Rule AModelOrPropertyReference
ruleAModelOrPropertyReference
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getAlternatives()); }
(rule__AModelOrPropertyReference__Alternatives)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNestedModelelement
entryRuleNestedModelelement 
:
{ before(grammarAccess.getNestedModelelementRule()); }
	 ruleNestedModelelement
{ after(grammarAccess.getNestedModelelementRule()); } 
	 EOF 
;

// Rule NestedModelelement
ruleNestedModelelement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNestedModelelementAccess().getGroup()); }
(rule__NestedModelelement__Group__0)
{ after(grammarAccess.getNestedModelelementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAModelReference
entryRuleAModelReference 
:
{ before(grammarAccess.getAModelReferenceRule()); }
	 ruleAModelReference
{ after(grammarAccess.getAModelReferenceRule()); } 
	 EOF 
;

// Rule AModelReference
ruleAModelReference
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAModelReferenceAccess().getGroup()); }
(rule__AModelReference__Group__0)
{ after(grammarAccess.getAModelReferenceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAPropertyReference
entryRuleAPropertyReference 
:
{ before(grammarAccess.getAPropertyReferenceRule()); }
	 ruleAPropertyReference
{ after(grammarAccess.getAPropertyReferenceRule()); } 
	 EOF 
;

// Rule APropertyReference
ruleAPropertyReference
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAPropertyReferenceAccess().getGroup()); }
(rule__APropertyReference__Group__0)
{ after(grammarAccess.getAPropertyReferenceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAVariableReference
entryRuleAVariableReference 
:
{ before(grammarAccess.getAVariableReferenceRule()); }
	 ruleAVariableReference
{ after(grammarAccess.getAVariableReferenceRule()); } 
	 EOF 
;

// Rule AVariableReference
ruleAVariableReference
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAVariableReferenceAccess().getGroup()); }
(rule__AVariableReference__Group__0)
{ after(grammarAccess.getAVariableReferenceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleShowValue
entryRuleShowValue 
:
{ before(grammarAccess.getShowValueRule()); }
	 ruleShowValue
{ after(grammarAccess.getShowValueRule()); } 
	 EOF 
;

// Rule ShowValue
ruleShowValue
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getShowValueAccess().getGroup()); }
(rule__ShowValue__Group__0)
{ after(grammarAccess.getShowValueAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleImageReference
entryRuleImageReference 
:
{ before(grammarAccess.getImageReferenceRule()); }
	 ruleImageReference
{ after(grammarAccess.getImageReferenceRule()); } 
	 EOF 
;

// Rule ImageReference
ruleImageReference
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getImageReferenceAccess().getGroup()); }
(rule__ImageReference__Group__0)
{ after(grammarAccess.getImageReferenceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleIMGREF
entryRuleIMGREF 
:
{ before(grammarAccess.getIMGREFRule()); }
	 ruleIMGREF
{ after(grammarAccess.getIMGREFRule()); } 
	 EOF 
;

// Rule IMGREF
ruleIMGREF
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIMGREFAccess().getGroup()); }
(rule__IMGREF__Group__0)
{ after(grammarAccess.getIMGREFAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAExpression
entryRuleAExpression 
:
{ before(grammarAccess.getAExpressionRule()); }
	 ruleAExpression
{ after(grammarAccess.getAExpressionRule()); } 
	 EOF 
;

// Rule AExpression
ruleAExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAExpressionAccess().getAOrExpressionParserRuleCall()); }
	ruleAOrExpression
{ after(grammarAccess.getAExpressionAccess().getAOrExpressionParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAOrExpression
entryRuleAOrExpression 
:
{ before(grammarAccess.getAOrExpressionRule()); }
	 ruleAOrExpression
{ after(grammarAccess.getAOrExpressionRule()); } 
	 EOF 
;

// Rule AOrExpression
ruleAOrExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAOrExpressionAccess().getGroup()); }
(rule__AOrExpression__Group__0)
{ after(grammarAccess.getAOrExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpOr
entryRuleOpOr 
:
{ before(grammarAccess.getOpOrRule()); }
	 ruleOpOr
{ after(grammarAccess.getOpOrRule()); } 
	 EOF 
;

// Rule OpOr
ruleOpOr
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOpOrAccess().getOrKeyword()); }

	'or' 

{ after(grammarAccess.getOpOrAccess().getOrKeyword()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAAndExpression
entryRuleAAndExpression 
:
{ before(grammarAccess.getAAndExpressionRule()); }
	 ruleAAndExpression
{ after(grammarAccess.getAAndExpressionRule()); } 
	 EOF 
;

// Rule AAndExpression
ruleAAndExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAAndExpressionAccess().getGroup()); }
(rule__AAndExpression__Group__0)
{ after(grammarAccess.getAAndExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpAnd
entryRuleOpAnd 
:
{ before(grammarAccess.getOpAndRule()); }
	 ruleOpAnd
{ after(grammarAccess.getOpAndRule()); } 
	 EOF 
;

// Rule OpAnd
ruleOpAnd
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOpAndAccess().getAndKeyword()); }

	'and' 

{ after(grammarAccess.getOpAndAccess().getAndKeyword()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAEqualityExpression
entryRuleAEqualityExpression 
:
{ before(grammarAccess.getAEqualityExpressionRule()); }
	 ruleAEqualityExpression
{ after(grammarAccess.getAEqualityExpressionRule()); } 
	 EOF 
;

// Rule AEqualityExpression
ruleAEqualityExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getGroup()); }
(rule__AEqualityExpression__Group__0)
{ after(grammarAccess.getAEqualityExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpEquality
entryRuleOpEquality 
:
{ before(grammarAccess.getOpEqualityRule()); }
	 ruleOpEquality
{ after(grammarAccess.getOpEqualityRule()); } 
	 EOF 
;

// Rule OpEquality
ruleOpEquality
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOpEqualityAccess().getAlternatives()); }
(rule__OpEquality__Alternatives)
{ after(grammarAccess.getOpEqualityAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleARelationalExpression
entryRuleARelationalExpression 
:
{ before(grammarAccess.getARelationalExpressionRule()); }
	 ruleARelationalExpression
{ after(grammarAccess.getARelationalExpressionRule()); } 
	 EOF 
;

// Rule ARelationalExpression
ruleARelationalExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getARelationalExpressionAccess().getGroup()); }
(rule__ARelationalExpression__Group__0)
{ after(grammarAccess.getARelationalExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpCompare
entryRuleOpCompare 
:
{ before(grammarAccess.getOpCompareRule()); }
	 ruleOpCompare
{ after(grammarAccess.getOpCompareRule()); } 
	 EOF 
;

// Rule OpCompare
ruleOpCompare
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOpCompareAccess().getAlternatives()); }
(rule__OpCompare__Alternatives)
{ after(grammarAccess.getOpCompareAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAAdditiveExpression
entryRuleAAdditiveExpression 
:
{ before(grammarAccess.getAAdditiveExpressionRule()); }
	 ruleAAdditiveExpression
{ after(grammarAccess.getAAdditiveExpressionRule()); } 
	 EOF 
;

// Rule AAdditiveExpression
ruleAAdditiveExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getGroup()); }
(rule__AAdditiveExpression__Group__0)
{ after(grammarAccess.getAAdditiveExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpAdd
entryRuleOpAdd 
:
{ before(grammarAccess.getOpAddRule()); }
	 ruleOpAdd
{ after(grammarAccess.getOpAddRule()); } 
	 EOF 
;

// Rule OpAdd
ruleOpAdd
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOpAddAccess().getAlternatives()); }
(rule__OpAdd__Alternatives)
{ after(grammarAccess.getOpAddAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAMultiplicativeExpression
entryRuleAMultiplicativeExpression 
:
{ before(grammarAccess.getAMultiplicativeExpressionRule()); }
	 ruleAMultiplicativeExpression
{ after(grammarAccess.getAMultiplicativeExpressionRule()); } 
	 EOF 
;

// Rule AMultiplicativeExpression
ruleAMultiplicativeExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getGroup()); }
(rule__AMultiplicativeExpression__Group__0)
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpMulti
entryRuleOpMulti 
:
{ before(grammarAccess.getOpMultiRule()); }
	 ruleOpMulti
{ after(grammarAccess.getOpMultiRule()); } 
	 EOF 
;

// Rule OpMulti
ruleOpMulti
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOpMultiAccess().getAlternatives()); }
(rule__OpMulti__Alternatives)
{ after(grammarAccess.getOpMultiAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAUnaryOperation
entryRuleAUnaryOperation 
:
{ before(grammarAccess.getAUnaryOperationRule()); }
	 ruleAUnaryOperation
{ after(grammarAccess.getAUnaryOperationRule()); } 
	 EOF 
;

// Rule AUnaryOperation
ruleAUnaryOperation
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAUnaryOperationAccess().getAlternatives()); }
(rule__AUnaryOperation__Alternatives)
{ after(grammarAccess.getAUnaryOperationAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpUnary
entryRuleOpUnary 
:
{ before(grammarAccess.getOpUnaryRule()); }
	 ruleOpUnary
{ after(grammarAccess.getOpUnaryRule()); } 
	 EOF 
;

// Rule OpUnary
ruleOpUnary
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOpUnaryAccess().getAlternatives()); }
(rule__OpUnary__Alternatives)
{ after(grammarAccess.getOpUnaryAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAUnitExpression
entryRuleAUnitExpression 
:
{ before(grammarAccess.getAUnitExpressionRule()); }
	 ruleAUnitExpression
{ after(grammarAccess.getAUnitExpressionRule()); } 
	 EOF 
;

// Rule AUnitExpression
ruleAUnitExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAUnitExpressionAccess().getGroup()); }
(rule__AUnitExpression__Group__0)
{ after(grammarAccess.getAUnitExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAPrimaryExpression
entryRuleAPrimaryExpression 
:
{ before(grammarAccess.getAPrimaryExpressionRule()); }
	 ruleAPrimaryExpression
{ after(grammarAccess.getAPrimaryExpressionRule()); } 
	 EOF 
;

// Rule APrimaryExpression
ruleAPrimaryExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAPrimaryExpressionAccess().getAlternatives()); }
(rule__APrimaryExpression__Alternatives)
{ after(grammarAccess.getAPrimaryExpressionAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAFunctionCall
entryRuleAFunctionCall 
:
{ before(grammarAccess.getAFunctionCallRule()); }
	 ruleAFunctionCall
{ after(grammarAccess.getAFunctionCallRule()); } 
	 EOF 
;

// Rule AFunctionCall
ruleAFunctionCall
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAFunctionCallAccess().getGroup()); }
(rule__AFunctionCall__Group__0)
{ after(grammarAccess.getAFunctionCallAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleARangeExpression
entryRuleARangeExpression 
:
{ before(grammarAccess.getARangeExpressionRule()); }
	 ruleARangeExpression
{ after(grammarAccess.getARangeExpressionRule()); } 
	 EOF 
;

// Rule ARangeExpression
ruleARangeExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getARangeExpressionAccess().getGroup()); }
(rule__ARangeExpression__Group__0)
{ after(grammarAccess.getARangeExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAIfExpression
entryRuleAIfExpression 
:
{ before(grammarAccess.getAIfExpressionRule()); }
	 ruleAIfExpression
{ after(grammarAccess.getAIfExpressionRule()); } 
	 EOF 
;

// Rule AIfExpression
ruleAIfExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAIfExpressionAccess().getGroup()); }
(rule__AIfExpression__Group__0)
{ after(grammarAccess.getAIfExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleALiteral
entryRuleALiteral 
:
{ before(grammarAccess.getALiteralRule()); }
	 ruleALiteral
{ after(grammarAccess.getALiteralRule()); } 
	 EOF 
;

// Rule ALiteral
ruleALiteral
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getALiteralAccess().getAlternatives()); }
(rule__ALiteral__Alternatives)
{ after(grammarAccess.getALiteralAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAIntegerTerm
entryRuleAIntegerTerm 
:
{ before(grammarAccess.getAIntegerTermRule()); }
	 ruleAIntegerTerm
{ after(grammarAccess.getAIntegerTermRule()); } 
	 EOF 
;

// Rule AIntegerTerm
ruleAIntegerTerm
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAIntegerTermAccess().getValueAssignment()); }
(rule__AIntegerTerm__ValueAssignment)
{ after(grammarAccess.getAIntegerTermAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAInt
entryRuleAInt 
:
{ before(grammarAccess.getAIntRule()); }
	 ruleAInt
{ after(grammarAccess.getAIntRule()); } 
	 EOF 
;

// Rule AInt
ruleAInt
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAIntAccess().getINTTerminalRuleCall()); }
	RULE_INT
{ after(grammarAccess.getAIntAccess().getINTTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleARealTerm
entryRuleARealTerm 
:
{ before(grammarAccess.getARealTermRule()); }
	 ruleARealTerm
{ after(grammarAccess.getARealTermRule()); } 
	 EOF 
;

// Rule ARealTerm
ruleARealTerm
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getARealTermAccess().getValueAssignment()); }
(rule__ARealTerm__ValueAssignment)
{ after(grammarAccess.getARealTermAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAReal
entryRuleAReal 
:
{ before(grammarAccess.getARealRule()); }
	 ruleAReal
{ after(grammarAccess.getARealRule()); } 
	 EOF 
;

// Rule AReal
ruleAReal
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getARealAccess().getREAL_LITTerminalRuleCall()); }
	RULE_REAL_LIT
{ after(grammarAccess.getARealAccess().getREAL_LITTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleABooleanLiteral
entryRuleABooleanLiteral 
:
{ before(grammarAccess.getABooleanLiteralRule()); }
	 ruleABooleanLiteral
{ after(grammarAccess.getABooleanLiteralRule()); } 
	 EOF 
;

// Rule ABooleanLiteral
ruleABooleanLiteral
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getABooleanLiteralAccess().getGroup()); }
(rule__ABooleanLiteral__Group__0)
{ after(grammarAccess.getABooleanLiteralAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStringTerm
entryRuleStringTerm 
:
{ before(grammarAccess.getStringTermRule()); }
	 ruleStringTerm
{ after(grammarAccess.getStringTermRule()); } 
	 EOF 
;

// Rule StringTerm
ruleStringTerm
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStringTermAccess().getValueAssignment()); }
(rule__StringTerm__ValueAssignment)
{ after(grammarAccess.getStringTermAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNoQuoteString
entryRuleNoQuoteString 
:
{ before(grammarAccess.getNoQuoteStringRule()); }
	 ruleNoQuoteString
{ after(grammarAccess.getNoQuoteStringRule()); } 
	 EOF 
;

// Rule NoQuoteString
ruleNoQuoteString
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); }
	RULE_STRING
{ after(grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAParenthesizedExpression
entryRuleAParenthesizedExpression 
:
{ before(grammarAccess.getAParenthesizedExpressionRule()); }
	 ruleAParenthesizedExpression
{ after(grammarAccess.getAParenthesizedExpressionRule()); } 
	 EOF 
;

// Rule AParenthesizedExpression
ruleAParenthesizedExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAParenthesizedExpressionAccess().getGroup()); }
(rule__AParenthesizedExpression__Group__0)
{ after(grammarAccess.getAParenthesizedExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}







// Entry rule entryRuleAADLPROPERTYREFERENCE
entryRuleAADLPROPERTYREFERENCE 
:
{ before(grammarAccess.getAADLPROPERTYREFERENCERule()); }
	 ruleAADLPROPERTYREFERENCE
{ after(grammarAccess.getAADLPROPERTYREFERENCERule()); } 
	 EOF 
;

// Rule AADLPROPERTYREFERENCE
ruleAADLPROPERTYREFERENCE
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup()); }
(rule__AADLPROPERTYREFERENCE__Group__0)
{ after(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleURIID
entryRuleURIID 
:
{ before(grammarAccess.getURIIDRule()); }
	 ruleURIID
{ after(grammarAccess.getURIIDRule()); } 
	 EOF 
;

// Rule URIID
ruleURIID
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); }
	RULE_STRING
{ after(grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}






// Rule ResultIssueType
ruleResultIssueType
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueTypeAccess().getAlternatives()); }
(rule__ResultIssueType__Alternatives)
{ after(grammarAccess.getResultIssueTypeAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}





rule__ResultReport__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportAccess().getResultDataReportParserRuleCall_0()); }
	ruleResultDataReport
{ after(grammarAccess.getResultReportAccess().getResultDataReportParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getResultReportAccess().getResultReportCollectionParserRuleCall_1()); }
	ruleResultReportCollection
{ after(grammarAccess.getResultReportAccess().getResultReportCollectionParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getResultReportAccess().getIssuesReportParserRuleCall_2()); }
	ruleIssuesReport
{ after(grammarAccess.getResultReportAccess().getIssuesReportParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultData__Alternatives_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataAccess().getValueAssignment_2_0()); }
(rule__ResultData__ValueAssignment_2_0)
{ after(grammarAccess.getResultDataAccess().getValueAssignment_2_0()); }
)

    |(
{ before(grammarAccess.getResultDataAccess().getIntegerValueAssignment_2_1()); }
(rule__ResultData__IntegerValueAssignment_2_1)
{ after(grammarAccess.getResultDataAccess().getIntegerValueAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionElement__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); }
(rule__DescriptionElement__TextAssignment_0)
{ after(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); }
)

    |(
{ before(grammarAccess.getDescriptionElementAccess().getShowValueAssignment_1()); }
(rule__DescriptionElement__ShowValueAssignment_1)
{ after(grammarAccess.getDescriptionElementAccess().getShowValueAssignment_1()); }
)

    |(
{ before(grammarAccess.getDescriptionElementAccess().getThisTargetAssignment_2()); }
(rule__DescriptionElement__ThisTargetAssignment_2)
{ after(grammarAccess.getDescriptionElementAccess().getThisTargetAssignment_2()); }
)

    |(
{ before(grammarAccess.getDescriptionElementAccess().getImageAssignment_3()); }
(rule__DescriptionElement__ImageAssignment_3)
{ after(grammarAccess.getDescriptionElementAccess().getImageAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getGroup_0()); }
(rule__TypeRef__Group_0__0)
{ after(grammarAccess.getTypeRefAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getTypeRefAccess().getGroup_1()); }
(rule__TypeRef__Group_1__0)
{ after(grammarAccess.getTypeRefAccess().getGroup_1()); }
)

    |(
{ before(grammarAccess.getTypeRefAccess().getGroup_2()); }
(rule__TypeRef__Group_2__0)
{ after(grammarAccess.getTypeRefAccess().getGroup_2()); }
)

    |(
{ before(grammarAccess.getTypeRefAccess().getGroup_3()); }
(rule__TypeRef__Group_3__0)
{ after(grammarAccess.getTypeRefAccess().getGroup_3()); }
)

    |(
{ before(grammarAccess.getTypeRefAccess().getGroup_4()); }
(rule__TypeRef__Group_4__0)
{ after(grammarAccess.getTypeRefAccess().getGroup_4()); }
)

    |(
{ before(grammarAccess.getTypeRefAccess().getGroup_5()); }
(rule__TypeRef__Group_5__0)
{ after(grammarAccess.getTypeRefAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__AModelOrPropertyReference__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0()); }
(rule__AModelOrPropertyReference__Group_0__0)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceParserRuleCall_1()); }
	ruleAPropertyReference
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0()); }

	'%' 

{ after(grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0()); }
)

    |(
{ before(grammarAccess.getShowValueAccess().getGroup_1_1()); }
(rule__ShowValue__Group_1_1__0)
{ after(grammarAccess.getShowValueAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OpEquality__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); }

	'==' 

{ after(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); }
)

    |(
{ before(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); }

	'!=' 

{ after(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OpCompare__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); }

	'>=' 

{ after(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); }
)

    |(
{ before(grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); }

	'<=' 

{ after(grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); }
)

    |(
{ before(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); }

	'>' 

{ after(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); }
)

    |(
{ before(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); }

	'<' 

{ after(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); }
)

    |(
{ before(grammarAccess.getOpCompareAccess().getGreaterThanSignLessThanSignKeyword_4()); }

	'><' 

{ after(grammarAccess.getOpCompareAccess().getGreaterThanSignLessThanSignKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OpAdd__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); }

	'+' 

{ after(grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); }
)

    |(
{ before(grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); }

	'-' 

{ after(grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OpMulti__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); }

	'*' 

{ after(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); }
)

    |(
{ before(grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); }

	'/' 

{ after(grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); }
)

    |(
{ before(grammarAccess.getOpMultiAccess().getDivKeyword_2()); }

	'div' 

{ after(grammarAccess.getOpMultiAccess().getDivKeyword_2()); }
)

    |(
{ before(grammarAccess.getOpMultiAccess().getModKeyword_3()); }

	'mod' 

{ after(grammarAccess.getOpMultiAccess().getModKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnaryOperation__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnaryOperationAccess().getGroup_0()); }
(rule__AUnaryOperation__Group_0__0)
{ after(grammarAccess.getAUnaryOperationAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getAUnaryOperationAccess().getAUnitExpressionParserRuleCall_1()); }
	ruleAUnitExpression
{ after(grammarAccess.getAUnaryOperationAccess().getAUnitExpressionParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OpUnary__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOpUnaryAccess().getNotKeyword_0()); }

	'not' 

{ after(grammarAccess.getOpUnaryAccess().getNotKeyword_0()); }
)

    |(
{ before(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); }

	'-' 

{ after(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); }
)

    |(
{ before(grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); }

	'+' 

{ after(grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__Alternatives_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getConvertAssignment_1_1_0()); }
(rule__AUnitExpression__ConvertAssignment_1_1_0)
{ after(grammarAccess.getAUnitExpressionAccess().getConvertAssignment_1_1_0()); }
)

    |(
{ before(grammarAccess.getAUnitExpressionAccess().getDropAssignment_1_1_1()); }
(rule__AUnitExpression__DropAssignment_1_1_1)
{ after(grammarAccess.getAUnitExpressionAccess().getDropAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__APrimaryExpression__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAPrimaryExpressionAccess().getALiteralParserRuleCall_0()); }
	ruleALiteral
{ after(grammarAccess.getAPrimaryExpressionAccess().getALiteralParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getAPrimaryExpressionAccess().getAVariableReferenceParserRuleCall_1()); }
	ruleAVariableReference
{ after(grammarAccess.getAPrimaryExpressionAccess().getAVariableReferenceParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getAPrimaryExpressionAccess().getAModelOrPropertyReferenceParserRuleCall_2()); }
	ruleAModelOrPropertyReference
{ after(grammarAccess.getAPrimaryExpressionAccess().getAModelOrPropertyReferenceParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getAPrimaryExpressionAccess().getAFunctionCallParserRuleCall_3()); }
	ruleAFunctionCall
{ after(grammarAccess.getAPrimaryExpressionAccess().getAFunctionCallParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getAPrimaryExpressionAccess().getARangeExpressionParserRuleCall_4()); }
	ruleARangeExpression
{ after(grammarAccess.getAPrimaryExpressionAccess().getARangeExpressionParserRuleCall_4()); }
)

    |(
{ before(grammarAccess.getAPrimaryExpressionAccess().getAIfExpressionParserRuleCall_5()); }
	ruleAIfExpression
{ after(grammarAccess.getAPrimaryExpressionAccess().getAIfExpressionParserRuleCall_5()); }
)

    |(
{ before(grammarAccess.getAPrimaryExpressionAccess().getAParenthesizedExpressionParserRuleCall_6()); }
	ruleAParenthesizedExpression
{ after(grammarAccess.getAPrimaryExpressionAccess().getAParenthesizedExpressionParserRuleCall_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ALiteral__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getALiteralAccess().getABooleanLiteralParserRuleCall_0()); }
	ruleABooleanLiteral
{ after(grammarAccess.getALiteralAccess().getABooleanLiteralParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getALiteralAccess().getARealTermParserRuleCall_1()); }
	ruleARealTerm
{ after(grammarAccess.getALiteralAccess().getARealTermParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getALiteralAccess().getAIntegerTermParserRuleCall_2()); }
	ruleAIntegerTerm
{ after(grammarAccess.getALiteralAccess().getAIntegerTermParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getALiteralAccess().getStringTermParserRuleCall_3()); }
	ruleStringTerm
{ after(grammarAccess.getALiteralAccess().getStringTermParserRuleCall_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ABooleanLiteral__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getABooleanLiteralAccess().getValueAssignment_1_0()); }
(rule__ABooleanLiteral__ValueAssignment_1_0)
{ after(grammarAccess.getABooleanLiteralAccess().getValueAssignment_1_0()); }
)

    |(
{ before(grammarAccess.getABooleanLiteralAccess().getFalseKeyword_1_1()); }

	'false' 

{ after(grammarAccess.getABooleanLiteralAccess().getFalseKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssueType__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0()); }
(	'tbd' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1()); }
(	'error' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2()); }
(	'warning' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3()); }
(	'info' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4()); }
(	'success' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4()); }
)

    |(
{ before(grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_5()); }
(	'fail' 
)
{ after(grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__ResultReportCollection__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__0__Impl
	rule__ResultReportCollection__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0()); }

	'reports' 

{ after(grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__1__Impl
	rule__ResultReportCollection__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getNameAssignment_1()); }
(rule__ResultReportCollection__NameAssignment_1)
{ after(grammarAccess.getResultReportCollectionAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__2__Impl
	rule__ResultReportCollection__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getGroup_2()); }
(rule__ResultReportCollection__Group_2__0)?
{ after(grammarAccess.getResultReportCollectionAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__3__Impl
	rule__ResultReportCollection__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getForKeyword_3()); }

	'for' 

{ after(grammarAccess.getResultReportCollectionAccess().getForKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__4__Impl
	rule__ResultReportCollection__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_4()); }
(rule__ResultReportCollection__TargetAssignment_4)
{ after(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__5__Impl
	rule__ResultReportCollection__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_5()); }

	'[' 

{ after(grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__6__Impl
	rule__ResultReportCollection__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getGroup_6()); }
(rule__ResultReportCollection__Group_6__0)?
{ after(grammarAccess.getResultReportCollectionAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__7__Impl
	rule__ResultReportCollection__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getContentAssignment_7()); }
(rule__ResultReportCollection__ContentAssignment_7)*
{ after(grammarAccess.getResultReportCollectionAccess().getContentAssignment_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__8__Impl
	rule__ResultReportCollection__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getIssuesAssignment_8()); }
(rule__ResultReportCollection__IssuesAssignment_8)?
{ after(grammarAccess.getResultReportCollectionAccess().getIssuesAssignment_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9()); }

	']' 

{ after(grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}






















rule__ResultReportCollection__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group_2__0__Impl
	rule__ResultReportCollection__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0()); }

	':' 

{ after(grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getTitleAssignment_2_1()); }
(rule__ResultReportCollection__TitleAssignment_2_1)
{ after(grammarAccess.getResultReportCollectionAccess().getTitleAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultReportCollection__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group_6__0__Impl
	rule__ResultReportCollection__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0()); }

	'description' 

{ after(grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultReportCollection__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultReportCollection__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getDescriptionAssignment_6_1()); }
(rule__ResultReportCollection__DescriptionAssignment_6_1)
{ after(grammarAccess.getResultReportCollectionAccess().getDescriptionAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultDataReport__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__0__Impl
	rule__ResultDataReport__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getReportKeyword_0()); }

	'report' 

{ after(grammarAccess.getResultDataReportAccess().getReportKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__1__Impl
	rule__ResultDataReport__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getNameAssignment_1()); }
(rule__ResultDataReport__NameAssignment_1)
{ after(grammarAccess.getResultDataReportAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__2__Impl
	rule__ResultDataReport__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getGroup_2()); }
(rule__ResultDataReport__Group_2__0)?
{ after(grammarAccess.getResultDataReportAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__3__Impl
	rule__ResultDataReport__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getForKeyword_3()); }

	'for' 

{ after(grammarAccess.getResultDataReportAccess().getForKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__4__Impl
	rule__ResultDataReport__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getTargetAssignment_4()); }
(rule__ResultDataReport__TargetAssignment_4)
{ after(grammarAccess.getResultDataReportAccess().getTargetAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__5__Impl
	rule__ResultDataReport__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getLeftSquareBracketKeyword_5()); }

	'[' 

{ after(grammarAccess.getResultDataReportAccess().getLeftSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__6__Impl
	rule__ResultDataReport__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getGroup_6()); }
(rule__ResultDataReport__Group_6__0)?
{ after(grammarAccess.getResultDataReportAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__7__Impl
	rule__ResultDataReport__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getGroup_7()); }
(rule__ResultDataReport__Group_7__0)?
{ after(grammarAccess.getResultDataReportAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__8__Impl
	rule__ResultDataReport__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getGroup_8()); }
(rule__ResultDataReport__Group_8__0)?
{ after(grammarAccess.getResultDataReportAccess().getGroup_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__9__Impl
	rule__ResultDataReport__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getIssuesAssignment_9()); }
(rule__ResultDataReport__IssuesAssignment_9)*
{ after(grammarAccess.getResultDataReportAccess().getIssuesAssignment_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group__10__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getRightSquareBracketKeyword_10()); }

	']' 

{ after(grammarAccess.getResultDataReportAccess().getRightSquareBracketKeyword_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}
























rule__ResultDataReport__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_2__0__Impl
	rule__ResultDataReport__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getColonKeyword_2_0()); }

	':' 

{ after(grammarAccess.getResultDataReportAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getTitleAssignment_2_1()); }
(rule__ResultDataReport__TitleAssignment_2_1)
{ after(grammarAccess.getResultDataReportAccess().getTitleAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultDataReport__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_6__0__Impl
	rule__ResultDataReport__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getDescriptionKeyword_6_0()); }

	'description' 

{ after(grammarAccess.getResultDataReportAccess().getDescriptionKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getDescriptionAssignment_6_1()); }
(rule__ResultDataReport__DescriptionAssignment_6_1)
{ after(grammarAccess.getResultDataReportAccess().getDescriptionAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultDataReport__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_7__0__Impl
	rule__ResultDataReport__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getHeadingKeyword_7_0()); }

	'heading' 

{ after(grammarAccess.getResultDataReportAccess().getHeadingKeyword_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_7__1__Impl
	rule__ResultDataReport__Group_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getHeadingAssignment_7_1()); }
(rule__ResultDataReport__HeadingAssignment_7_1)
{ after(grammarAccess.getResultDataReportAccess().getHeadingAssignment_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_7__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_7__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getContentAssignment_7_2()); }
(rule__ResultDataReport__ContentAssignment_7_2)*
{ after(grammarAccess.getResultDataReportAccess().getContentAssignment_7_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ResultDataReport__Group_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_8__0__Impl
	rule__ResultDataReport__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getResultsKeyword_8_0()); }

	'results' 

{ after(grammarAccess.getResultDataReportAccess().getResultsKeyword_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultDataReport__Group_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultDataReport__Group_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__Group_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getResultDataReportAccess().getResultDataAssignment_8_1()); }
(rule__ResultDataReport__ResultDataAssignment_8_1)
{ after(grammarAccess.getResultDataReportAccess().getResultDataAssignment_8_1()); }
)
(
{ before(grammarAccess.getResultDataReportAccess().getResultDataAssignment_8_1()); }
(rule__ResultDataReport__ResultDataAssignment_8_1)*
{ after(grammarAccess.getResultDataReportAccess().getResultDataAssignment_8_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultContributor__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__0__Impl
	rule__ResultContributor__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getContributorKeyword_0()); }

	'contributor' 

{ after(grammarAccess.getResultContributorAccess().getContributorKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__1__Impl
	rule__ResultContributor__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getTargetAssignment_1()); }
(rule__ResultContributor__TargetAssignment_1)
{ after(grammarAccess.getResultContributorAccess().getTargetAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__2__Impl
	rule__ResultContributor__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_2()); }

	'[' 

{ after(grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__3__Impl
	rule__ResultContributor__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getGroup_3()); }
(rule__ResultContributor__Group_3__0)?
{ after(grammarAccess.getResultContributorAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__4__Impl
	rule__ResultContributor__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getIssuesAssignment_4()); }
(rule__ResultContributor__IssuesAssignment_4)*
{ after(grammarAccess.getResultContributorAccess().getIssuesAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__5__Impl
	rule__ResultContributor__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_5()); }
(rule__ResultContributor__SubcontributorAssignment_5)*
{ after(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_6()); }

	']' 

{ after(grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__ResultContributor__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group_3__0__Impl
	rule__ResultContributor__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getResultsKeyword_3_0()); }

	'results' 

{ after(grammarAccess.getResultContributorAccess().getResultsKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultContributor__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultContributor__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getResultContributorAccess().getResultDataAssignment_3_1()); }
(rule__ResultContributor__ResultDataAssignment_3_1)
{ after(grammarAccess.getResultContributorAccess().getResultDataAssignment_3_1()); }
)
(
{ before(grammarAccess.getResultContributorAccess().getResultDataAssignment_3_1()); }
(rule__ResultContributor__ResultDataAssignment_3_1)*
{ after(grammarAccess.getResultContributorAccess().getResultDataAssignment_3_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultData__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultData__Group__0__Impl
	rule__ResultData__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultData__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataAccess().getNameAssignment_0()); }
(rule__ResultData__NameAssignment_0)
{ after(grammarAccess.getResultDataAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultData__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultData__Group__1__Impl
	rule__ResultData__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultData__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataAccess().getEqualsSignKeyword_1()); }

	'=' 

{ after(grammarAccess.getResultDataAccess().getEqualsSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultData__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultData__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultData__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataAccess().getAlternatives_2()); }
(rule__ResultData__Alternatives_2)
{ after(grammarAccess.getResultDataAccess().getAlternatives_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__IssuesReport__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group__0__Impl
	rule__IssuesReport__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getIssuesKeyword_0()); }

	'issues' 

{ after(grammarAccess.getIssuesReportAccess().getIssuesKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group__1__Impl
	rule__IssuesReport__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getNameAssignment_1()); }
(rule__IssuesReport__NameAssignment_1)
{ after(grammarAccess.getIssuesReportAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group__2__Impl
	rule__IssuesReport__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getGroup_2()); }
(rule__IssuesReport__Group_2__0)?
{ after(grammarAccess.getIssuesReportAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getGroup_3()); }
(rule__IssuesReport__Group_3__0)?
{ after(grammarAccess.getIssuesReportAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__IssuesReport__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_2__0__Impl
	rule__IssuesReport__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getForKeyword_2_0()); }

	'for' 

{ after(grammarAccess.getIssuesReportAccess().getForKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getTargetAssignment_2_1()); }
(rule__IssuesReport__TargetAssignment_2_1)
{ after(grammarAccess.getIssuesReportAccess().getTargetAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__IssuesReport__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_3__0__Impl
	rule__IssuesReport__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3_0()); }

	'[' 

{ after(grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_3__1__Impl
	rule__IssuesReport__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getGroup_3_1()); }
(rule__IssuesReport__Group_3_1__0)?
{ after(grammarAccess.getIssuesReportAccess().getGroup_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_3__2__Impl
	rule__IssuesReport__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getIssuesAssignment_3_2()); }
(rule__IssuesReport__IssuesAssignment_3_2)*
{ after(grammarAccess.getIssuesReportAccess().getIssuesAssignment_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group_3__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_3__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_3__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_3_3()); }

	']' 

{ after(grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_3_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__IssuesReport__Group_3_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_3_1__0__Impl
	rule__IssuesReport__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_3_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getDescriptionKeyword_3_1_0()); }

	'description' 

{ after(grammarAccess.getIssuesReportAccess().getDescriptionKeyword_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IssuesReport__Group_3_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IssuesReport__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__Group_3_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getDescriptionAssignment_3_1_1()); }
(rule__IssuesReport__DescriptionAssignment_3_1_1)
{ after(grammarAccess.getIssuesReportAccess().getDescriptionAssignment_3_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}











rule__ResultIssue__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group__0__Impl
	rule__ResultIssue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getIssueTypeAssignment_0()); }
(rule__ResultIssue__IssueTypeAssignment_0)
{ after(grammarAccess.getResultIssueAccess().getIssueTypeAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group__1__Impl
	rule__ResultIssue__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getMessageAssignment_1()); }
(rule__ResultIssue__MessageAssignment_1)
{ after(grammarAccess.getResultIssueAccess().getMessageAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group__2__Impl
	rule__ResultIssue__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getGroup_2()); }
(rule__ResultIssue__Group_2__0)?
{ after(grammarAccess.getResultIssueAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group__3__Impl
	rule__ResultIssue__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getGroup_3()); }
(rule__ResultIssue__Group_3__0)?
{ after(grammarAccess.getResultIssueAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group__4__Impl
	rule__ResultIssue__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getGroup_4()); }
(rule__ResultIssue__Group_4__0)?
{ after(grammarAccess.getResultIssueAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getGroup_5()); }
(rule__ResultIssue__Group_5__0)?
{ after(grammarAccess.getResultIssueAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__ResultIssue__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_2__0__Impl
	rule__ResultIssue__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getTargetKeyword_2_0()); }

	'target' 

{ after(grammarAccess.getResultIssueAccess().getTargetKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getTargetAssignment_2_1()); }
(rule__ResultIssue__TargetAssignment_2_1)
{ after(grammarAccess.getResultIssueAccess().getTargetAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultIssue__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_3__0__Impl
	rule__ResultIssue__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getExceptionKeyword_3_0()); }

	'exception' 

{ after(grammarAccess.getResultIssueAccess().getExceptionKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getExceptionTypeAssignment_3_1()); }
(rule__ResultIssue__ExceptionTypeAssignment_3_1)
{ after(grammarAccess.getResultIssueAccess().getExceptionTypeAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultIssue__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_4__0__Impl
	rule__ResultIssue__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getDiagnosticIdKeyword_4_0()); }

	'diagnosticId' 

{ after(grammarAccess.getResultIssueAccess().getDiagnosticIdKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getDiagnosticIdAssignment_4_1()); }
(rule__ResultIssue__DiagnosticIdAssignment_4_1)
{ after(grammarAccess.getResultIssueAccess().getDiagnosticIdAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ResultIssue__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_5__0__Impl
	rule__ResultIssue__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0()); }

	'[' 

{ after(grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_5__1__Impl
	rule__ResultIssue__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getIssuesAssignment_5_1()); }
(rule__ResultIssue__IssuesAssignment_5_1)*
{ after(grammarAccess.getResultIssueAccess().getIssuesAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ResultIssue__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ResultIssue__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2()); }

	']' 

{ after(grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeRef__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_0__0__Impl
	rule__TypeRef__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getAadlBooleanAction_0_0()); }
(

)
{ after(grammarAccess.getTypeRefAccess().getAadlBooleanAction_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getBooleanKeyword_0_1()); }

	'boolean' 

{ after(grammarAccess.getTypeRefAccess().getBooleanKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeRef__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_1__0__Impl
	rule__TypeRef__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getAadlIntegerAction_1_0()); }
(

)
{ after(grammarAccess.getTypeRefAccess().getAadlIntegerAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_1__1__Impl
	rule__TypeRef__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getIntegerKeyword_1_1()); }

	'integer' 

{ after(grammarAccess.getTypeRefAccess().getIntegerKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getGroup_1_2()); }
(rule__TypeRef__Group_1_2__0)?
{ after(grammarAccess.getTypeRefAccess().getGroup_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeRef__Group_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_1_2__0__Impl
	rule__TypeRef__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getUnitKeyword_1_2_0()); }

	'unit' 

{ after(grammarAccess.getTypeRefAccess().getUnitKeyword_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_1_2_1()); }
(rule__TypeRef__ReferencedUnitsTypeAssignment_1_2_1)
{ after(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeRef__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_2__0__Impl
	rule__TypeRef__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getAadlRealAction_2_0()); }
(

)
{ after(grammarAccess.getTypeRefAccess().getAadlRealAction_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_2__1__Impl
	rule__TypeRef__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getRealKeyword_2_1()); }

	'real' 

{ after(grammarAccess.getTypeRefAccess().getRealKeyword_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getGroup_2_2()); }
(rule__TypeRef__Group_2_2__0)?
{ after(grammarAccess.getTypeRefAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeRef__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_2_2__0__Impl
	rule__TypeRef__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getUnitKeyword_2_2_0()); }

	'unit' 

{ after(grammarAccess.getTypeRefAccess().getUnitKeyword_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_2_2_1()); }
(rule__TypeRef__ReferencedUnitsTypeAssignment_2_2_1)
{ after(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeRef__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_3__0__Impl
	rule__TypeRef__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getAadlStringAction_3_0()); }
(

)
{ after(grammarAccess.getTypeRefAccess().getAadlStringAction_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getStringKeyword_3_1()); }

	'string' 

{ after(grammarAccess.getTypeRefAccess().getStringKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeRef__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_4__0__Impl
	rule__TypeRef__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getModelRefAction_4_0()); }
(

)
{ after(grammarAccess.getTypeRefAccess().getModelRefAction_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_4__1__Impl
	rule__TypeRef__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getModelKeyword_4_1()); }

	'model' 

{ after(grammarAccess.getTypeRefAccess().getModelKeyword_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getElementKeyword_4_2()); }

	'element' 

{ after(grammarAccess.getTypeRefAccess().getElementKeyword_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeRef__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_5__0__Impl
	rule__TypeRef__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getTypeRefAction_5_0()); }
(

)
{ after(grammarAccess.getTypeRefAccess().getTypeRefAction_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getRefAssignment_5_1()); }
(rule__TypeRef__RefAssignment_5_1)
{ after(grammarAccess.getTypeRefAccess().getRefAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PropertyRef__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyRef__Group__0__Impl
	rule__PropertyRef__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyRef__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyRefAccess().getPropertyRefAction_0()); }
(

)
{ after(grammarAccess.getPropertyRefAccess().getPropertyRefAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyRef__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyRef__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyRef__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyRefAccess().getRefAssignment_1()); }
(rule__PropertyRef__RefAssignment_1)
{ after(grammarAccess.getPropertyRefAccess().getRefAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}











rule__AModelOrPropertyReference__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0__0__Impl
	rule__AModelOrPropertyReference__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getAModelReferenceParserRuleCall_0_0()); }
	ruleAModelReference
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getAModelReferenceParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AModelOrPropertyReference__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1()); }
(rule__AModelOrPropertyReference__Group_0_1__0)?
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AModelOrPropertyReference__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0_1__0__Impl
	rule__AModelOrPropertyReference__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0()); }
(rule__AModelOrPropertyReference__Group_0_1_0__0)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AModelOrPropertyReference__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAssignment_0_1_1()); }
(rule__AModelOrPropertyReference__PropertyAssignment_0_1_1)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AModelOrPropertyReference__Group_0_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0_0()); }
(rule__AModelOrPropertyReference__Group_0_1_0_0__0)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__AModelOrPropertyReference__Group_0_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0_1_0_0__0__Impl
	rule__AModelOrPropertyReference__Group_0_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceModelElementReferenceAction_0_1_0_0_0()); }
(

)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceModelElementReferenceAction_0_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AModelOrPropertyReference__Group_0_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getNumberSignKeyword_0_1_0_0_1()); }

	'#' 

{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getNumberSignKeyword_0_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NestedModelelement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NestedModelelement__Group__0__Impl
	rule__NestedModelelement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NestedModelelement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedModelelementAccess().getModelElementAssignment_0()); }
(rule__NestedModelelement__ModelElementAssignment_0)
{ after(grammarAccess.getNestedModelelementAccess().getModelElementAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NestedModelelement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NestedModelelement__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NestedModelelement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedModelelementAccess().getGroup_1()); }
(rule__NestedModelelement__Group_1__0)?
{ after(grammarAccess.getNestedModelelementAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NestedModelelement__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NestedModelelement__Group_1__0__Impl
	rule__NestedModelelement__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NestedModelelement__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedModelelementAccess().getFullStopKeyword_1_0()); }

	'.' 

{ after(grammarAccess.getNestedModelelementAccess().getFullStopKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NestedModelelement__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NestedModelelement__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NestedModelelement__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedModelelementAccess().getNextAssignment_1_1()); }
(rule__NestedModelelement__NextAssignment_1_1)
{ after(grammarAccess.getNestedModelelementAccess().getNextAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AModelReference__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelReference__Group__0__Impl
	rule__AModelReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelReference__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelReferenceAccess().getAModelReferenceAction_0()); }
(

)
{ after(grammarAccess.getAModelReferenceAccess().getAModelReferenceAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AModelReference__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelReference__Group__1__Impl
	rule__AModelReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelReference__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelReferenceAccess().getThisKeyword_1()); }

	'this' 

{ after(grammarAccess.getAModelReferenceAccess().getThisKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AModelReference__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelReference__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelReference__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelReferenceAccess().getGroup_2()); }
(rule__AModelReference__Group_2__0)?
{ after(grammarAccess.getAModelReferenceAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AModelReference__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelReference__Group_2__0__Impl
	rule__AModelReference__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelReference__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelReferenceAccess().getFullStopKeyword_2_0()); }

	'.' 

{ after(grammarAccess.getAModelReferenceAccess().getFullStopKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AModelReference__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelReference__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelReference__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelReferenceAccess().getNextAssignment_2_1()); }
(rule__AModelReference__NextAssignment_2_1)
{ after(grammarAccess.getAModelReferenceAccess().getNextAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__APropertyReference__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__APropertyReference__Group__0__Impl
	rule__APropertyReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__APropertyReference__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAPropertyReferenceAccess().getAPropertyReferenceAction_0()); }
(

)
{ after(grammarAccess.getAPropertyReferenceAccess().getAPropertyReferenceAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__APropertyReference__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__APropertyReference__Group__1__Impl
	rule__APropertyReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__APropertyReference__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAPropertyReferenceAccess().getNumberSignKeyword_1()); }

	'#' 

{ after(grammarAccess.getAPropertyReferenceAccess().getNumberSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__APropertyReference__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__APropertyReference__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__APropertyReference__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAPropertyReferenceAccess().getPropertyAssignment_2()); }
(rule__APropertyReference__PropertyAssignment_2)
{ after(grammarAccess.getAPropertyReferenceAccess().getPropertyAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AVariableReference__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AVariableReference__Group__0__Impl
	rule__AVariableReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AVariableReference__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAVariableReferenceAccess().getAVariableReferenceAction_0()); }
(

)
{ after(grammarAccess.getAVariableReferenceAccess().getAVariableReferenceAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AVariableReference__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AVariableReference__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AVariableReference__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAVariableReferenceAccess().getVariableAssignment_1()); }
(rule__AVariableReference__VariableAssignment_1)
{ after(grammarAccess.getAVariableReferenceAccess().getVariableAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ShowValue__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShowValue__Group__0__Impl
	rule__ShowValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getRefAssignment_0()); }
(rule__ShowValue__RefAssignment_0)
{ after(grammarAccess.getShowValueAccess().getRefAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ShowValue__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShowValue__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getAlternatives_1()); }
(rule__ShowValue__Alternatives_1)?
{ after(grammarAccess.getShowValueAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ShowValue__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShowValue__Group_1_1__0__Impl
	rule__ShowValue__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getInKeyword_1_1_0()); }

	'in' 

{ after(grammarAccess.getShowValueAccess().getInKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ShowValue__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShowValue__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getUnitAssignment_1_1_1()); }
(rule__ShowValue__UnitAssignment_1_1_1)
{ after(grammarAccess.getShowValueAccess().getUnitAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ImageReference__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImageReference__Group__0__Impl
	rule__ImageReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ImageReference__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImageReferenceAccess().getImgKeyword_0()); }

	'img' 

{ after(grammarAccess.getImageReferenceAccess().getImgKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImageReference__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImageReference__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ImageReference__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImageReferenceAccess().getImgfileAssignment_1()); }
(rule__ImageReference__ImgfileAssignment_1)
{ after(grammarAccess.getImageReferenceAccess().getImgfileAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__IMGREF__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IMGREF__Group__0__Impl
	rule__IMGREF__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IMGREF__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIMGREFAccess().getGroup_0()); }
(rule__IMGREF__Group_0__0)*
{ after(grammarAccess.getIMGREFAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IMGREF__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IMGREF__Group__1__Impl
	rule__IMGREF__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IMGREF__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
{ after(grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IMGREF__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IMGREF__Group__2__Impl
	rule__IMGREF__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IMGREF__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIMGREFAccess().getFullStopKeyword_2()); }

	'.' 

{ after(grammarAccess.getIMGREFAccess().getFullStopKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IMGREF__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IMGREF__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IMGREF__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_3()); }
	RULE_ID
{ after(grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__IMGREF__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IMGREF__Group_0__0__Impl
	rule__IMGREF__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IMGREF__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_0_0()); }
	RULE_ID
{ after(grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IMGREF__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IMGREF__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IMGREF__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIMGREFAccess().getSolidusKeyword_0_1()); }

	'/' 

{ after(grammarAccess.getIMGREFAccess().getSolidusKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AOrExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group__0__Impl
	rule__AOrExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0()); }
	ruleAAndExpression
{ after(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AOrExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getGroup_1()); }
(rule__AOrExpression__Group_1__0)*
{ after(grammarAccess.getAOrExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AOrExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group_1__0__Impl
	rule__AOrExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getGroup_1_0()); }
(rule__AOrExpression__Group_1_0__0)
{ after(grammarAccess.getAOrExpressionAccess().getGroup_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AOrExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getRightAssignment_1_1()); }
(rule__AOrExpression__RightAssignment_1_1)
{ after(grammarAccess.getAOrExpressionAccess().getRightAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AOrExpression__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getGroup_1_0_0()); }
(rule__AOrExpression__Group_1_0_0__0)
{ after(grammarAccess.getAOrExpressionAccess().getGroup_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__AOrExpression__Group_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group_1_0_0__0__Impl
	rule__AOrExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
(

)
{ after(grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AOrExpression__Group_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getOperatorAssignment_1_0_0_1()); }
(rule__AOrExpression__OperatorAssignment_1_0_0_1)
{ after(grammarAccess.getAOrExpressionAccess().getOperatorAssignment_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AAndExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group__0__Impl
	rule__AAndExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getAEqualityExpressionParserRuleCall_0()); }
	ruleAEqualityExpression
{ after(grammarAccess.getAAndExpressionAccess().getAEqualityExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AAndExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getGroup_1()); }
(rule__AAndExpression__Group_1__0)*
{ after(grammarAccess.getAAndExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AAndExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group_1__0__Impl
	rule__AAndExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getGroup_1_0()); }
(rule__AAndExpression__Group_1_0__0)
{ after(grammarAccess.getAAndExpressionAccess().getGroup_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AAndExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getRightAssignment_1_1()); }
(rule__AAndExpression__RightAssignment_1_1)
{ after(grammarAccess.getAAndExpressionAccess().getRightAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AAndExpression__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getGroup_1_0_0()); }
(rule__AAndExpression__Group_1_0_0__0)
{ after(grammarAccess.getAAndExpressionAccess().getGroup_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__AAndExpression__Group_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group_1_0_0__0__Impl
	rule__AAndExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
(

)
{ after(grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AAndExpression__Group_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getOperatorAssignment_1_0_0_1()); }
(rule__AAndExpression__OperatorAssignment_1_0_0_1)
{ after(grammarAccess.getAAndExpressionAccess().getOperatorAssignment_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AEqualityExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group__0__Impl
	rule__AEqualityExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getARelationalExpressionParserRuleCall_0()); }
	ruleARelationalExpression
{ after(grammarAccess.getAEqualityExpressionAccess().getARelationalExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AEqualityExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getGroup_1()); }
(rule__AEqualityExpression__Group_1__0)*
{ after(grammarAccess.getAEqualityExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AEqualityExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group_1__0__Impl
	rule__AEqualityExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0()); }
(rule__AEqualityExpression__Group_1_0__0)
{ after(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AEqualityExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getRightAssignment_1_1()); }
(rule__AEqualityExpression__RightAssignment_1_1)
{ after(grammarAccess.getAEqualityExpressionAccess().getRightAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AEqualityExpression__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0_0()); }
(rule__AEqualityExpression__Group_1_0_0__0)
{ after(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__AEqualityExpression__Group_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group_1_0_0__0__Impl
	rule__AEqualityExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
(

)
{ after(grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AEqualityExpression__Group_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getOperatorAssignment_1_0_0_1()); }
(rule__AEqualityExpression__OperatorAssignment_1_0_0_1)
{ after(grammarAccess.getAEqualityExpressionAccess().getOperatorAssignment_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ARelationalExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group__0__Impl
	rule__ARelationalExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getAAdditiveExpressionParserRuleCall_0()); }
	ruleAAdditiveExpression
{ after(grammarAccess.getARelationalExpressionAccess().getAAdditiveExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARelationalExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getGroup_1()); }
(rule__ARelationalExpression__Group_1__0)*
{ after(grammarAccess.getARelationalExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ARelationalExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group_1__0__Impl
	rule__ARelationalExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getGroup_1_0()); }
(rule__ARelationalExpression__Group_1_0__0)
{ after(grammarAccess.getARelationalExpressionAccess().getGroup_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARelationalExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getRightAssignment_1_1()); }
(rule__ARelationalExpression__RightAssignment_1_1)
{ after(grammarAccess.getARelationalExpressionAccess().getRightAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ARelationalExpression__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getGroup_1_0_0()); }
(rule__ARelationalExpression__Group_1_0_0__0)
{ after(grammarAccess.getARelationalExpressionAccess().getGroup_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__ARelationalExpression__Group_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group_1_0_0__0__Impl
	rule__ARelationalExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
(

)
{ after(grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARelationalExpression__Group_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getOperatorAssignment_1_0_0_1()); }
(rule__ARelationalExpression__OperatorAssignment_1_0_0_1)
{ after(grammarAccess.getARelationalExpressionAccess().getOperatorAssignment_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AAdditiveExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group__0__Impl
	rule__AAdditiveExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0()); }
	ruleAMultiplicativeExpression
{ after(grammarAccess.getAAdditiveExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AAdditiveExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getGroup_1()); }
(rule__AAdditiveExpression__Group_1__0)*
{ after(grammarAccess.getAAdditiveExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AAdditiveExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group_1__0__Impl
	rule__AAdditiveExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0()); }
(rule__AAdditiveExpression__Group_1_0__0)
{ after(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AAdditiveExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getRightAssignment_1_1()); }
(rule__AAdditiveExpression__RightAssignment_1_1)
{ after(grammarAccess.getAAdditiveExpressionAccess().getRightAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AAdditiveExpression__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0_0()); }
(rule__AAdditiveExpression__Group_1_0_0__0)
{ after(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__AAdditiveExpression__Group_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group_1_0_0__0__Impl
	rule__AAdditiveExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
(

)
{ after(grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AAdditiveExpression__Group_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getOperatorAssignment_1_0_0_1()); }
(rule__AAdditiveExpression__OperatorAssignment_1_0_0_1)
{ after(grammarAccess.getAAdditiveExpressionAccess().getOperatorAssignment_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AMultiplicativeExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group__0__Impl
	rule__AMultiplicativeExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getAUnaryOperationParserRuleCall_0()); }
	ruleAUnaryOperation
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getAUnaryOperationParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AMultiplicativeExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1()); }
(rule__AMultiplicativeExpression__Group_1__0)*
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AMultiplicativeExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group_1__0__Impl
	rule__AMultiplicativeExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0()); }
(rule__AMultiplicativeExpression__Group_1_0__0)
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AMultiplicativeExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getRightAssignment_1_1()); }
(rule__AMultiplicativeExpression__RightAssignment_1_1)
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getRightAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AMultiplicativeExpression__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0_0()); }
(rule__AMultiplicativeExpression__Group_1_0_0__0)
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__AMultiplicativeExpression__Group_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group_1_0_0__0__Impl
	rule__AMultiplicativeExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
(

)
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AMultiplicativeExpression__Group_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorAssignment_1_0_0_1()); }
(rule__AMultiplicativeExpression__OperatorAssignment_1_0_0_1)
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorAssignment_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AUnaryOperation__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnaryOperation__Group_0__0__Impl
	rule__AUnaryOperation__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnaryOperation__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnaryOperationAccess().getAUnaryOperationAction_0_0()); }
(

)
{ after(grammarAccess.getAUnaryOperationAccess().getAUnaryOperationAction_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AUnaryOperation__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnaryOperation__Group_0__1__Impl
	rule__AUnaryOperation__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnaryOperation__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnaryOperationAccess().getOperatorAssignment_0_1()); }
(rule__AUnaryOperation__OperatorAssignment_0_1)
{ after(grammarAccess.getAUnaryOperationAccess().getOperatorAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AUnaryOperation__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnaryOperation__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnaryOperation__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnaryOperationAccess().getOperandAssignment_0_2()); }
(rule__AUnaryOperation__OperandAssignment_0_2)
{ after(grammarAccess.getAUnaryOperationAccess().getOperandAssignment_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AUnitExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnitExpression__Group__0__Impl
	rule__AUnitExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getAPrimaryExpressionParserRuleCall_0()); }
	ruleAPrimaryExpression
{ after(grammarAccess.getAUnitExpressionAccess().getAPrimaryExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AUnitExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnitExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getGroup_1()); }
(rule__AUnitExpression__Group_1__0)?
{ after(grammarAccess.getAUnitExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AUnitExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnitExpression__Group_1__0__Impl
	rule__AUnitExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getAUnitExpressionExpressionAction_1_0()); }
(

)
{ after(grammarAccess.getAUnitExpressionAccess().getAUnitExpressionExpressionAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AUnitExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnitExpression__Group_1__1__Impl
	rule__AUnitExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getAlternatives_1_1()); }
(rule__AUnitExpression__Alternatives_1_1)?
{ after(grammarAccess.getAUnitExpressionAccess().getAlternatives_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AUnitExpression__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnitExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getUnitAssignment_1_2()); }
(rule__AUnitExpression__UnitAssignment_1_2)
{ after(grammarAccess.getAUnitExpressionAccess().getUnitAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AFunctionCall__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group__0__Impl
	rule__AFunctionCall__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getAFunctionCallAction_0()); }
(

)
{ after(grammarAccess.getAFunctionCallAccess().getAFunctionCallAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AFunctionCall__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group__1__Impl
	rule__AFunctionCall__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getFunctionAssignment_1()); }
(rule__AFunctionCall__FunctionAssignment_1)
{ after(grammarAccess.getAFunctionCallAccess().getFunctionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AFunctionCall__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group__2__Impl
	rule__AFunctionCall__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getLeftParenthesisKeyword_2()); }

	'(' 

{ after(grammarAccess.getAFunctionCallAccess().getLeftParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AFunctionCall__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group__3__Impl
	rule__AFunctionCall__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_3()); }
(rule__AFunctionCall__ArgumentsAssignment_3)
{ after(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AFunctionCall__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group__4__Impl
	rule__AFunctionCall__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getGroup_4()); }
(rule__AFunctionCall__Group_4__0)*
{ after(grammarAccess.getAFunctionCallAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AFunctionCall__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getRightParenthesisKeyword_5()); }

	')' 

{ after(grammarAccess.getAFunctionCallAccess().getRightParenthesisKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__AFunctionCall__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group_4__0__Impl
	rule__AFunctionCall__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getCommaKeyword_4_0()); }

	',' 

{ after(grammarAccess.getAFunctionCallAccess().getCommaKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AFunctionCall__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_4_1()); }
(rule__AFunctionCall__ArgumentsAssignment_4_1)
{ after(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ARangeExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__0__Impl
	rule__ARangeExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getARangeAction_0()); }
(

)
{ after(grammarAccess.getARangeExpressionAccess().getARangeAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__1__Impl
	rule__ARangeExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getLeftSquareBracketKeyword_1()); }

	'[' 

{ after(grammarAccess.getARangeExpressionAccess().getLeftSquareBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__2__Impl
	rule__ARangeExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getMinimumAssignment_2()); }
(rule__ARangeExpression__MinimumAssignment_2)
{ after(grammarAccess.getARangeExpressionAccess().getMinimumAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__3__Impl
	rule__ARangeExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getFullStopFullStopKeyword_3()); }

	'..' 

{ after(grammarAccess.getARangeExpressionAccess().getFullStopFullStopKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__4__Impl
	rule__ARangeExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getMaximumAssignment_4()); }
(rule__ARangeExpression__MaximumAssignment_4)
{ after(grammarAccess.getARangeExpressionAccess().getMaximumAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__5__Impl
	rule__ARangeExpression__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getGroup_5()); }
(rule__ARangeExpression__Group_5__0)?
{ after(grammarAccess.getARangeExpressionAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getRightSquareBracketKeyword_6()); }

	']' 

{ after(grammarAccess.getARangeExpressionAccess().getRightSquareBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__ARangeExpression__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group_5__0__Impl
	rule__ARangeExpression__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getDeltaKeyword_5_0()); }
(
	'delta' 
)
{ after(grammarAccess.getARangeExpressionAccess().getDeltaKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getDeltaAssignment_5_1()); }
(rule__ARangeExpression__DeltaAssignment_5_1)
{ after(grammarAccess.getARangeExpressionAccess().getDeltaAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AIfExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__0__Impl
	rule__AIfExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getAConditionalAction_0()); }
(

)
{ after(grammarAccess.getAIfExpressionAccess().getAConditionalAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__1__Impl
	rule__AIfExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getIfKeyword_1()); }

	'if' 

{ after(grammarAccess.getAIfExpressionAccess().getIfKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__2__Impl
	rule__AIfExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getIfAssignment_2()); }
(rule__AIfExpression__IfAssignment_2)
{ after(grammarAccess.getAIfExpressionAccess().getIfAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__3__Impl
	rule__AIfExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getThenKeyword_3()); }

	'then' 

{ after(grammarAccess.getAIfExpressionAccess().getThenKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__4__Impl
	rule__AIfExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getThenAssignment_4()); }
(rule__AIfExpression__ThenAssignment_4)
{ after(grammarAccess.getAIfExpressionAccess().getThenAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__5__Impl
	rule__AIfExpression__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getGroup_5()); }
(rule__AIfExpression__Group_5__0)?
{ after(grammarAccess.getAIfExpressionAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getEndifKeyword_6()); }

	'endif' 

{ after(grammarAccess.getAIfExpressionAccess().getEndifKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__AIfExpression__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group_5__0__Impl
	rule__AIfExpression__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getElseKeyword_5_0()); }

	'else' 

{ after(grammarAccess.getAIfExpressionAccess().getElseKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getElseAssignment_5_1()); }
(rule__AIfExpression__ElseAssignment_5_1)
{ after(grammarAccess.getAIfExpressionAccess().getElseAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ABooleanLiteral__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ABooleanLiteral__Group__0__Impl
	rule__ABooleanLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ABooleanLiteral__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getABooleanLiteralAccess().getBooleanLiteralAction_0()); }
(

)
{ after(grammarAccess.getABooleanLiteralAccess().getBooleanLiteralAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ABooleanLiteral__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ABooleanLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ABooleanLiteral__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getABooleanLiteralAccess().getAlternatives_1()); }
(rule__ABooleanLiteral__Alternatives_1)
{ after(grammarAccess.getABooleanLiteralAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AParenthesizedExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AParenthesizedExpression__Group__0__Impl
	rule__AParenthesizedExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AParenthesizedExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()); }

	'(' 

{ after(grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AParenthesizedExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AParenthesizedExpression__Group__1__Impl
	rule__AParenthesizedExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AParenthesizedExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAParenthesizedExpressionAccess().getAExpressionParserRuleCall_1()); }
	ruleAExpression
{ after(grammarAccess.getAParenthesizedExpressionAccess().getAExpressionParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AParenthesizedExpression__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AParenthesizedExpression__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AParenthesizedExpression__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAParenthesizedExpressionAccess().getRightParenthesisKeyword_2()); }

	')' 

{ after(grammarAccess.getAParenthesizedExpressionAccess().getRightParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}















rule__AADLPROPERTYREFERENCE__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AADLPROPERTYREFERENCE__Group__0__Impl
	rule__AADLPROPERTYREFERENCE__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AADLPROPERTYREFERENCE__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
{ after(grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AADLPROPERTYREFERENCE__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AADLPROPERTYREFERENCE__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AADLPROPERTYREFERENCE__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup_1()); }
(rule__AADLPROPERTYREFERENCE__Group_1__0)?
{ after(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AADLPROPERTYREFERENCE__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AADLPROPERTYREFERENCE__Group_1__0__Impl
	rule__AADLPROPERTYREFERENCE__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AADLPROPERTYREFERENCE__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAADLPROPERTYREFERENCEAccess().getColonColonKeyword_1_0()); }

	'::' 

{ after(grammarAccess.getAADLPROPERTYREFERENCEAccess().getColonColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AADLPROPERTYREFERENCE__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AADLPROPERTYREFERENCE__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AADLPROPERTYREFERENCE__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
{ after(grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ResultReportCollection__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__TitleAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__TargetAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_4_0()); }
(
{ before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); }
	ruleURIID{ after(grammarAccess.getResultReportCollectionAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); }
)
{ after(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__DescriptionAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultReportCollectionAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__ContentAssignment_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); }
	ruleResultReport{ after(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultReportCollection__IssuesAssignment_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultReportCollectionAccess().getIssuesResultIssueParserRuleCall_8_0()); }
	ruleResultIssue{ after(grammarAccess.getResultReportCollectionAccess().getIssuesResultIssueParserRuleCall_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getResultDataReportAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__TitleAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultDataReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__TargetAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getTargetEObjectCrossReference_4_0()); }
(
{ before(grammarAccess.getResultDataReportAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); }
	ruleURIID{ after(grammarAccess.getResultDataReportAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); }
)
{ after(grammarAccess.getResultDataReportAccess().getTargetEObjectCrossReference_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__DescriptionAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultDataReportAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__HeadingAssignment_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultDataReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__ContentAssignment_7_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getContentResultContributorParserRuleCall_7_2_0()); }
	ruleResultContributor{ after(grammarAccess.getResultDataReportAccess().getContentResultContributorParserRuleCall_7_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__ResultDataAssignment_8_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); }
	ruleResultData{ after(grammarAccess.getResultDataReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultDataReport__IssuesAssignment_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataReportAccess().getIssuesResultIssueParserRuleCall_9_0()); }
	ruleResultIssue{ after(grammarAccess.getResultDataReportAccess().getIssuesResultIssueParserRuleCall_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__TargetAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_1_0()); }
(
{ before(grammarAccess.getResultContributorAccess().getTargetEObjectURIIDParserRuleCall_1_0_1()); }
	ruleURIID{ after(grammarAccess.getResultContributorAccess().getTargetEObjectURIIDParserRuleCall_1_0_1()); }
)
{ after(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__ResultDataAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getResultDataResultDataParserRuleCall_3_1_0()); }
	ruleResultData{ after(grammarAccess.getResultContributorAccess().getResultDataResultDataParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__IssuesAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_4_0()); }
	ruleResultIssue{ after(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultContributor__SubcontributorAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_5_0()); }
	ruleResultContributor{ after(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultData__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultData__ValueAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0_0()); }
	RULE_STRING{ after(grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultData__IntegerValueAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultDataAccess().getIntegerValueINTTerminalRuleCall_2_1_0()); }
	RULE_INT{ after(grammarAccess.getResultDataAccess().getIntegerValueINTTerminalRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getIssuesReportAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__TargetAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_2_1_0()); }
(
{ before(grammarAccess.getIssuesReportAccess().getTargetEObjectURIIDParserRuleCall_2_1_0_1()); }
	ruleURIID{ after(grammarAccess.getIssuesReportAccess().getTargetEObjectURIIDParserRuleCall_2_1_0_1()); }
)
{ after(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__DescriptionAssignment_3_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getDescriptionSTRINGTerminalRuleCall_3_1_1_0()); }
	RULE_STRING{ after(grammarAccess.getIssuesReportAccess().getDescriptionSTRINGTerminalRuleCall_3_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IssuesReport__IssuesAssignment_3_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIssuesReportAccess().getIssuesResultIssueParserRuleCall_3_2_0()); }
	ruleResultIssue{ after(grammarAccess.getIssuesReportAccess().getIssuesResultIssueParserRuleCall_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DescriptionElement__TextAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); }
	RULE_STRING{ after(grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionElement__ShowValueAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDescriptionElementAccess().getShowValueShowValueParserRuleCall_1_0()); }
	ruleShowValue{ after(grammarAccess.getDescriptionElementAccess().getShowValueShowValueParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionElement__ThisTargetAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_2_0()); }
(
{ before(grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_2_0()); }

	'this' 

{ after(grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_2_0()); }
)

{ after(grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionElement__ImageAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDescriptionElementAccess().getImageImageReferenceParserRuleCall_3_0()); }
	ruleImageReference{ after(grammarAccess.getDescriptionElementAccess().getImageImageReferenceParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__ResultIssue__IssueTypeAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_0_0()); }
	ruleResultIssueType{ after(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__MessageAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__TargetAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_2_1_0()); }
(
{ before(grammarAccess.getResultIssueAccess().getTargetEObjectURIIDParserRuleCall_2_1_0_1()); }
	ruleURIID{ after(grammarAccess.getResultIssueAccess().getTargetEObjectURIIDParserRuleCall_2_1_0_1()); }
)
{ after(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__ExceptionTypeAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_3_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__DiagnosticIdAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getDiagnosticIdSTRINGTerminalRuleCall_4_1_0()); }
	RULE_STRING{ after(grammarAccess.getResultIssueAccess().getDiagnosticIdSTRINGTerminalRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ResultIssue__IssuesAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); }
	ruleResultIssue{ after(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__ReferencedUnitsTypeAssignment_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_1_2_1_0()); }
(
{ before(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_1_2_1_0_1()); }
	ruleAADLPROPERTYREFERENCE{ after(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_1_2_1_0_1()); }
)
{ after(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__ReferencedUnitsTypeAssignment_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_2_2_1_0()); }
(
{ before(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_2_2_1_0_1()); }
	ruleAADLPROPERTYREFERENCE{ after(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_2_2_1_0_1()); }
)
{ after(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__RefAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getRefPropertyTypeCrossReference_5_1_0()); }
(
{ before(grammarAccess.getTypeRefAccess().getRefPropertyTypeAADLPROPERTYREFERENCEParserRuleCall_5_1_0_1()); }
	ruleAADLPROPERTYREFERENCE{ after(grammarAccess.getTypeRefAccess().getRefPropertyTypeAADLPROPERTYREFERENCEParserRuleCall_5_1_0_1()); }
)
{ after(grammarAccess.getTypeRefAccess().getRefPropertyTypeCrossReference_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyRef__RefAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyRefAccess().getRefPropertyCrossReference_1_0()); }
(
{ before(grammarAccess.getPropertyRefAccess().getRefPropertyAADLPROPERTYREFERENCEParserRuleCall_1_0_1()); }
	ruleAADLPROPERTYREFERENCE{ after(grammarAccess.getPropertyRefAccess().getRefPropertyAADLPROPERTYREFERENCEParserRuleCall_1_0_1()); }
)
{ after(grammarAccess.getPropertyRefAccess().getRefPropertyCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AModelOrPropertyReference__PropertyAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0()); }
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_0_1_1_0_1()); }
	ruleAADLPROPERTYREFERENCE{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_0_1_1_0_1()); }
)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NestedModelelement__ModelElementAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedModelelementAccess().getModelElementNamedElementCrossReference_0_0()); }
(
{ before(grammarAccess.getNestedModelelementAccess().getModelElementNamedElementIDTerminalRuleCall_0_0_1()); }
	RULE_ID{ after(grammarAccess.getNestedModelelementAccess().getModelElementNamedElementIDTerminalRuleCall_0_0_1()); }
)
{ after(grammarAccess.getNestedModelelementAccess().getModelElementNamedElementCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NestedModelelement__NextAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedModelelementAccess().getNextNestedModelelementParserRuleCall_1_1_0()); }
	ruleNestedModelelement{ after(grammarAccess.getNestedModelelementAccess().getNextNestedModelelementParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AModelReference__NextAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelReferenceAccess().getNextNestedModelelementParserRuleCall_2_1_0()); }
	ruleNestedModelelement{ after(grammarAccess.getAModelReferenceAccess().getNextNestedModelelementParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__APropertyReference__PropertyAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); }
(
{ before(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_2_0_1()); }
	ruleAADLPROPERTYREFERENCE{ after(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_2_0_1()); }
)
{ after(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AVariableReference__VariableAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationCrossReference_1_0()); }
(
{ before(grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationIDTerminalRuleCall_1_0_1()); }
	RULE_ID{ after(grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationIDTerminalRuleCall_1_0_1()); }
)
{ after(grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__RefAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getRefAVariableDeclarationCrossReference_0_0()); }
(
{ before(grammarAccess.getShowValueAccess().getRefAVariableDeclarationIDTerminalRuleCall_0_0_1()); }
	RULE_ID{ after(grammarAccess.getShowValueAccess().getRefAVariableDeclarationIDTerminalRuleCall_0_0_1()); }
)
{ after(grammarAccess.getShowValueAccess().getRefAVariableDeclarationCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__UnitAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getUnitUnitLiteralCrossReference_1_1_1_0()); }
(
{ before(grammarAccess.getShowValueAccess().getUnitUnitLiteralIDTerminalRuleCall_1_1_1_0_1()); }
	RULE_ID{ after(grammarAccess.getShowValueAccess().getUnitUnitLiteralIDTerminalRuleCall_1_1_1_0_1()); }
)
{ after(grammarAccess.getShowValueAccess().getUnitUnitLiteralCrossReference_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImageReference__ImgfileAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0()); }
	ruleIMGREF{ after(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__OperatorAssignment_1_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0()); }
	ruleOpOr{ after(grammarAccess.getAOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__RightAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getRightAAndExpressionParserRuleCall_1_1_0()); }
	ruleAAndExpression{ after(grammarAccess.getAOrExpressionAccess().getRightAAndExpressionParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__OperatorAssignment_1_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0()); }
	ruleOpAnd{ after(grammarAccess.getAAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__RightAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getRightAEqualityExpressionParserRuleCall_1_1_0()); }
	ruleAEqualityExpression{ after(grammarAccess.getAAndExpressionAccess().getRightAEqualityExpressionParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__OperatorAssignment_1_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0()); }
	ruleOpEquality{ after(grammarAccess.getAEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__RightAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getRightARelationalExpressionParserRuleCall_1_1_0()); }
	ruleARelationalExpression{ after(grammarAccess.getAEqualityExpressionAccess().getRightARelationalExpressionParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__OperatorAssignment_1_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0()); }
	ruleOpCompare{ after(grammarAccess.getARelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__RightAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getRightAAdditiveExpressionParserRuleCall_1_1_0()); }
	ruleAAdditiveExpression{ after(grammarAccess.getARelationalExpressionAccess().getRightAAdditiveExpressionParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__OperatorAssignment_1_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0()); }
	ruleOpAdd{ after(grammarAccess.getAAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__RightAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getRightAMultiplicativeExpressionParserRuleCall_1_1_0()); }
	ruleAMultiplicativeExpression{ after(grammarAccess.getAAdditiveExpressionAccess().getRightAMultiplicativeExpressionParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__OperatorAssignment_1_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0()); }
	ruleOpMulti{ after(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__RightAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getRightAUnaryOperationParserRuleCall_1_1_0()); }
	ruleAUnaryOperation{ after(grammarAccess.getAMultiplicativeExpressionAccess().getRightAUnaryOperationParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnaryOperation__OperatorAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0()); }
	ruleOpUnary{ after(grammarAccess.getAUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnaryOperation__OperandAssignment_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnaryOperationAccess().getOperandAUnaryOperationParserRuleCall_0_2_0()); }
	ruleAUnaryOperation{ after(grammarAccess.getAUnaryOperationAccess().getOperandAUnaryOperationParserRuleCall_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__ConvertAssignment_1_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getConvertToKeyword_1_1_0_0()); }
(
{ before(grammarAccess.getAUnitExpressionAccess().getConvertToKeyword_1_1_0_0()); }

	'to' 

{ after(grammarAccess.getAUnitExpressionAccess().getConvertToKeyword_1_1_0_0()); }
)

{ after(grammarAccess.getAUnitExpressionAccess().getConvertToKeyword_1_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__DropAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getDropInKeyword_1_1_1_0()); }
(
{ before(grammarAccess.getAUnitExpressionAccess().getDropInKeyword_1_1_1_0()); }

	'in' 

{ after(grammarAccess.getAUnitExpressionAccess().getDropInKeyword_1_1_1_0()); }
)

{ after(grammarAccess.getAUnitExpressionAccess().getDropInKeyword_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__UnitAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0()); }
(
{ before(grammarAccess.getAUnitExpressionAccess().getUnitUnitLiteralIDTerminalRuleCall_1_2_0_1()); }
	RULE_ID{ after(grammarAccess.getAUnitExpressionAccess().getUnitUnitLiteralIDTerminalRuleCall_1_2_0_1()); }
)
{ after(grammarAccess.getAUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__FunctionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getFunctionIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getAFunctionCallAccess().getFunctionIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__ArgumentsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_0()); }
	ruleAExpression{ after(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__ArgumentsAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_4_1_0()); }
	ruleAExpression{ after(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__MinimumAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getMinimumAExpressionParserRuleCall_2_0()); }
	ruleAExpression{ after(grammarAccess.getARangeExpressionAccess().getMinimumAExpressionParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__MaximumAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getMaximumAExpressionParserRuleCall_4_0()); }
	ruleAExpression{ after(grammarAccess.getARangeExpressionAccess().getMaximumAExpressionParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__DeltaAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getDeltaAExpressionParserRuleCall_5_1_0()); }
	ruleAExpression{ after(grammarAccess.getARangeExpressionAccess().getDeltaAExpressionParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__IfAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getIfAExpressionParserRuleCall_2_0()); }
	ruleAExpression{ after(grammarAccess.getAIfExpressionAccess().getIfAExpressionParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__ThenAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getThenAExpressionParserRuleCall_4_0()); }
	ruleAExpression{ after(grammarAccess.getAIfExpressionAccess().getThenAExpressionParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__ElseAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getElseAExpressionParserRuleCall_5_1_0()); }
	ruleAExpression{ after(grammarAccess.getAIfExpressionAccess().getElseAExpressionParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AIntegerTerm__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0()); }
	ruleAInt{ after(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ARealTerm__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0()); }
	ruleAReal{ after(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ABooleanLiteral__ValueAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getABooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }
(
{ before(grammarAccess.getABooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }

	'true' 

{ after(grammarAccess.getABooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }
)

{ after(grammarAccess.getABooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StringTerm__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); }
	ruleNoQuoteString{ after(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


fragment RULE_EXPONENT : ('e'|'E') ('+'|'-')? RULE_DIGIT+;

fragment RULE_INT_EXPONENT : ('e'|'E') '+'? RULE_DIGIT+;

RULE_REAL_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* '.' RULE_DIGIT+ ('_' RULE_DIGIT+)* RULE_EXPONENT?;

fragment RULE_DIGIT : '0'..'9';

fragment RULE_EXTENDED_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_BASED_INTEGER : RULE_EXTENDED_DIGIT ('_'? RULE_EXTENDED_DIGIT)*;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


