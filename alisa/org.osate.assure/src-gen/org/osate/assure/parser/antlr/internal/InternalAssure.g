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
grammar InternalAssure;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.osate.assure.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.osate.assure.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.assure.services.AssureGrammarAccess;

}

@parser::members {

 	private AssureGrammarAccess grammarAccess;
 	
    public InternalAssureParser(TokenStream input, AssureGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "AssuranceCaseResult";	
   	}
   	
   	@Override
   	protected AssureGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleAssuranceCaseResult
entryRuleAssuranceCaseResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAssuranceCaseResultRule()); }
	 iv_ruleAssuranceCaseResult=ruleAssuranceCaseResult 
	 { $current=$iv_ruleAssuranceCaseResult.current; } 
	 EOF 
;

// Rule AssuranceCaseResult
ruleAssuranceCaseResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='case' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getAssuranceCaseResultAccess().getCaseKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseResultAccess().getNameQualifiedNameParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceCaseResultRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='[' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAssuranceCaseResultAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseResultAccess().getMetricsMetricsParserRuleCall_3_0()); 
	    }
		lv_metrics_3_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceCaseResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_3_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='message' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getAssuranceCaseResultAccess().getMessageKeyword_4_0());
    }
(
(
		lv_message_5_0=RULE_STRING
		{
			newLeafNode(lv_message_5_0, grammarAccess.getAssuranceCaseResultAccess().getMessageSTRINGTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceCaseResultRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_5_0, 
        		"STRING");
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseResultAccess().getModelResultModelResultParserRuleCall_5_0()); 
	    }
		lv_modelResult_6_0=ruleModelResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceCaseResultRule());
	        }
       		add(
       			$current, 
       			"modelResult",
        		lv_modelResult_6_0, 
        		"ModelResult");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_7=']' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getAssuranceCaseResultAccess().getRightSquareBracketKeyword_6());
    }
)
;





// Entry rule entryRuleModelResult
entryRuleModelResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getModelResultRule()); }
	 iv_ruleModelResult=ruleModelResult 
	 { $current=$iv_ruleModelResult.current; } 
	 EOF 
;

// Rule ModelResult
ruleModelResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='model' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getModelResultAccess().getModelKeyword_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModelResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getModelResultAccess().getPlanAssurancePlanCrossReference_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='for' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getModelResultAccess().getForKeyword_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModelResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getModelResultAccess().getTargetComponentImplementationCrossReference_3_0()); 
	    }
		ruleAadlClassifierReference		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getModelResultAccess().getLeftSquareBracketKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getModelResultAccess().getMetricsMetricsParserRuleCall_5_0()); 
	    }
		lv_metrics_5_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_5_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_6='message' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getModelResultAccess().getMessageKeyword_6_0());
    }
(
(
		lv_message_7_0=RULE_STRING
		{
			newLeafNode(lv_message_7_0, grammarAccess.getModelResultAccess().getMessageSTRINGTerminalRuleCall_6_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getModelResultRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_7_0, 
        		"STRING");
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getModelResultAccess().getClaimResultClaimResultParserRuleCall_7_0()); 
	    }
		lv_claimResult_8_0=ruleClaimResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelResultRule());
	        }
       		add(
       			$current, 
       			"claimResult",
        		lv_claimResult_8_0, 
        		"ClaimResult");
	        afterParserOrEnumRuleCall();
	    }

)
)*((
(
		{ 
	        newCompositeNode(grammarAccess.getModelResultAccess().getSubsystemResultSubsystemResultParserRuleCall_8_0_0()); 
	    }
		lv_subsystemResult_9_0=ruleSubsystemResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelResultRule());
	        }
       		add(
       			$current, 
       			"subsystemResult",
        		lv_subsystemResult_9_0, 
        		"SubsystemResult");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getModelResultAccess().getSubAssuranceCaseAssuranceCaseResultParserRuleCall_8_1_0()); 
	    }
		lv_subAssuranceCase_10_0=ruleAssuranceCaseResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelResultRule());
	        }
       		add(
       			$current, 
       			"subAssuranceCase",
        		lv_subAssuranceCase_10_0, 
        		"AssuranceCaseResult");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_11=']' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getModelResultAccess().getRightSquareBracketKeyword_9());
    }
)
;





// Entry rule entryRuleSubsystemResult
entryRuleSubsystemResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSubsystemResultRule()); }
	 iv_ruleSubsystemResult=ruleSubsystemResult 
	 { $current=$iv_ruleSubsystemResult.current; } 
	 EOF 
;

// Rule SubsystemResult
ruleSubsystemResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='subsystem' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getSubsystemResultAccess().getSubsystemKeyword_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSubsystemResultRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getSubsystemResultAccess().getTargetSystemSubcomponentCrossReference_1_0()); 
	}

)
)	otherlv_2='[' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getSubsystemResultAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSubsystemResultAccess().getMetricsMetricsParserRuleCall_3_0()); 
	    }
		lv_metrics_3_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSubsystemResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_3_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='message' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getSubsystemResultAccess().getMessageKeyword_4_0());
    }
(
(
		lv_message_5_0=RULE_STRING
		{
			newLeafNode(lv_message_5_0, grammarAccess.getSubsystemResultAccess().getMessageSTRINGTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSubsystemResultRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_5_0, 
        		"STRING");
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getSubsystemResultAccess().getClaimResultClaimResultParserRuleCall_5_0()); 
	    }
		lv_claimResult_6_0=ruleClaimResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSubsystemResultRule());
	        }
       		add(
       			$current, 
       			"claimResult",
        		lv_claimResult_6_0, 
        		"ClaimResult");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getSubsystemResultAccess().getSubsystemResultSubsystemResultParserRuleCall_6_0()); 
	    }
		lv_subsystemResult_7_0=ruleSubsystemResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSubsystemResultRule());
	        }
       		add(
       			$current, 
       			"subsystemResult",
        		lv_subsystemResult_7_0, 
        		"SubsystemResult");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_8=']' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getSubsystemResultAccess().getRightSquareBracketKeyword_7());
    }
)
;





// Entry rule entryRuleClaimResult
entryRuleClaimResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getClaimResultRule()); }
	 iv_ruleClaimResult=ruleClaimResult 
	 { $current=$iv_ruleClaimResult.current; } 
	 EOF 
;

// Rule ClaimResult
ruleClaimResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='claim' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getClaimResultAccess().getClaimKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getClaimResultAccess().getTargetReferenceQualifiedClaimReferenceParserRuleCall_1_0()); 
	    }
		lv_targetReference_1_0=ruleQualifiedClaimReference		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClaimResultRule());
	        }
       		set(
       			$current, 
       			"targetReference",
        		lv_targetReference_1_0, 
        		"QualifiedClaimReference");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='[' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getClaimResultAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getClaimResultAccess().getMetricsMetricsParserRuleCall_3_0()); 
	    }
		lv_metrics_3_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClaimResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_3_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='for' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getClaimResultAccess().getForKeyword_4_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getClaimResultRule());
	        }
        }
	otherlv_5=RULE_ID
	{
		newLeafNode(otherlv_5, grammarAccess.getClaimResultAccess().getModelElementNamedElementCrossReference_4_1_0()); 
	}

)
))?(	otherlv_6='message' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getClaimResultAccess().getMessageKeyword_5_0());
    }
(
(
		lv_message_7_0=RULE_STRING
		{
			newLeafNode(lv_message_7_0, grammarAccess.getClaimResultAccess().getMessageSTRINGTerminalRuleCall_5_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getClaimResultRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_7_0, 
        		"STRING");
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getClaimResultAccess().getSubClaimResultClaimResultParserRuleCall_6_0()); 
	    }
		lv_subClaimResult_8_0=ruleClaimResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClaimResultRule());
	        }
       		add(
       			$current, 
       			"subClaimResult",
        		lv_subClaimResult_8_0, 
        		"ClaimResult");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getClaimResultAccess().getVerificationActivityResultVerificationExprParserRuleCall_7_0()); 
	    }
		lv_verificationActivityResult_9_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClaimResultRule());
	        }
       		add(
       			$current, 
       			"verificationActivityResult",
        		lv_verificationActivityResult_9_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_10=']' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getClaimResultAccess().getRightSquareBracketKeyword_8());
    }
)
;





// Entry rule entryRulePreconditionResult
entryRulePreconditionResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPreconditionResultRule()); }
	 iv_rulePreconditionResult=rulePreconditionResult 
	 { $current=$iv_rulePreconditionResult.current; } 
	 EOF 
;

// Rule PreconditionResult
rulePreconditionResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='precondition' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getPreconditionResultAccess().getPreconditionKeyword_0());
    }
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getPreconditionResultAccess().getPreconditionResultAction_1(),
            $current);
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getPreconditionResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getPreconditionResultAccess().getTargetVerificationMethodCrossReference_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='[' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getPreconditionResultAccess().getLeftSquareBracketKeyword_3());
    }
	otherlv_4='executionstate' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getPreconditionResultAccess().getExecutionstateKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPreconditionResultAccess().getExecutionStateVerificationExecutionStateEnumRuleCall_5_0()); 
	    }
		lv_executionState_5_0=ruleVerificationExecutionState		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPreconditionResultRule());
	        }
       		set(
       			$current, 
       			"executionState",
        		lv_executionState_5_0, 
        		"VerificationExecutionState");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_6='resultstate' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getPreconditionResultAccess().getResultstateKeyword_6());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPreconditionResultAccess().getResultStateVerificationResultStateEnumRuleCall_7_0()); 
	    }
		lv_resultState_7_0=ruleVerificationResultState		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPreconditionResultRule());
	        }
       		set(
       			$current, 
       			"resultState",
        		lv_resultState_7_0, 
        		"VerificationResultState");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_8='issues' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getPreconditionResultAccess().getIssuesKeyword_8_0());
    }
	otherlv_9='[' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getPreconditionResultAccess().getLeftSquareBracketKeyword_8_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPreconditionResultAccess().getIssuesResultIssueParserRuleCall_8_2_0()); 
	    }
		lv_issues_10_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPreconditionResultRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_10_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_11=']' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getPreconditionResultAccess().getRightSquareBracketKeyword_8_3());
    }
)?(	otherlv_12='report' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getPreconditionResultAccess().getReportKeyword_9_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getPreconditionResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getPreconditionResultAccess().getResultReportResultReportCrossReference_9_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getPreconditionResultAccess().getMetricsMetricsParserRuleCall_10_0()); 
	    }
		lv_metrics_14_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPreconditionResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_14_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_15='message' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getPreconditionResultAccess().getMessageKeyword_11_0());
    }
(
(
		lv_message_16_0=RULE_STRING
		{
			newLeafNode(lv_message_16_0, grammarAccess.getPreconditionResultAccess().getMessageSTRINGTerminalRuleCall_11_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPreconditionResultRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_16_0, 
        		"STRING");
	    }

)
))?	otherlv_17=']' 
    {
    	newLeafNode(otherlv_17, grammarAccess.getPreconditionResultAccess().getRightSquareBracketKeyword_12());
    }
)
;





// Entry rule entryRuleValidationResult
entryRuleValidationResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getValidationResultRule()); }
	 iv_ruleValidationResult=ruleValidationResult 
	 { $current=$iv_ruleValidationResult.current; } 
	 EOF 
;

// Rule ValidationResult
ruleValidationResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='validation' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getValidationResultAccess().getValidationKeyword_0());
    }
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getValidationResultAccess().getValidationResultAction_1(),
            $current);
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getValidationResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getValidationResultAccess().getTargetVerificationMethodCrossReference_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='[' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getValidationResultAccess().getLeftSquareBracketKeyword_3());
    }
	otherlv_4='executionstate' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getValidationResultAccess().getExecutionstateKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getValidationResultAccess().getExecutionStateVerificationExecutionStateEnumRuleCall_5_0()); 
	    }
		lv_executionState_5_0=ruleVerificationExecutionState		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValidationResultRule());
	        }
       		set(
       			$current, 
       			"executionState",
        		lv_executionState_5_0, 
        		"VerificationExecutionState");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_6='resultstate' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getValidationResultAccess().getResultstateKeyword_6());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getValidationResultAccess().getResultStateVerificationResultStateEnumRuleCall_7_0()); 
	    }
		lv_resultState_7_0=ruleVerificationResultState		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValidationResultRule());
	        }
       		set(
       			$current, 
       			"resultState",
        		lv_resultState_7_0, 
        		"VerificationResultState");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_8='issues' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getValidationResultAccess().getIssuesKeyword_8_0());
    }
	otherlv_9='[' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getValidationResultAccess().getLeftSquareBracketKeyword_8_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getValidationResultAccess().getIssuesResultIssueParserRuleCall_8_2_0()); 
	    }
		lv_issues_10_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValidationResultRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_10_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_11=']' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getValidationResultAccess().getRightSquareBracketKeyword_8_3());
    }
)?(	otherlv_12='report' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getValidationResultAccess().getReportKeyword_9_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getValidationResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getValidationResultAccess().getResultReportResultReportCrossReference_9_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getValidationResultAccess().getMetricsMetricsParserRuleCall_10_0()); 
	    }
		lv_metrics_14_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValidationResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_14_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_15='message' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getValidationResultAccess().getMessageKeyword_11_0());
    }
(
(
		lv_message_16_0=RULE_STRING
		{
			newLeafNode(lv_message_16_0, grammarAccess.getValidationResultAccess().getMessageSTRINGTerminalRuleCall_11_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getValidationResultRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_16_0, 
        		"STRING");
	    }

)
))?	otherlv_17=']' 
    {
    	newLeafNode(otherlv_17, grammarAccess.getValidationResultAccess().getRightSquareBracketKeyword_12());
    }
)
;





// Entry rule entryRuleVerificationActivityResult
entryRuleVerificationActivityResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVerificationActivityResultRule()); }
	 iv_ruleVerificationActivityResult=ruleVerificationActivityResult 
	 { $current=$iv_ruleVerificationActivityResult.current; } 
	 EOF 
;

// Rule VerificationActivityResult
ruleVerificationActivityResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='verification' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVerificationActivityResultAccess().getVerificationKeyword_0());
    }
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getVerificationActivityResultAccess().getVerificationActivityResultAction_1(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getTargetReferenceQualifiedVAReferenceParserRuleCall_2_0()); 
	    }
		lv_targetReference_2_0=ruleQualifiedVAReference		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityResultRule());
	        }
       		set(
       			$current, 
       			"targetReference",
        		lv_targetReference_2_0, 
        		"QualifiedVAReference");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='[' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getVerificationActivityResultAccess().getLeftSquareBracketKeyword_3());
    }
	otherlv_4='executionstate' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getVerificationActivityResultAccess().getExecutionstateKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getExecutionStateVerificationExecutionStateEnumRuleCall_5_0()); 
	    }
		lv_executionState_5_0=ruleVerificationExecutionState		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityResultRule());
	        }
       		set(
       			$current, 
       			"executionState",
        		lv_executionState_5_0, 
        		"VerificationExecutionState");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_6='resultstate' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getVerificationActivityResultAccess().getResultstateKeyword_6());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getResultStateVerificationResultStateEnumRuleCall_7_0()); 
	    }
		lv_resultState_7_0=ruleVerificationResultState		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityResultRule());
	        }
       		set(
       			$current, 
       			"resultState",
        		lv_resultState_7_0, 
        		"VerificationResultState");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_8='issues' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getVerificationActivityResultAccess().getIssuesKeyword_8_0());
    }
	otherlv_9='[' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getVerificationActivityResultAccess().getLeftSquareBracketKeyword_8_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getIssuesResultIssueParserRuleCall_8_2_0()); 
	    }
		lv_issues_10_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityResultRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_10_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_11=']' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getVerificationActivityResultAccess().getRightSquareBracketKeyword_8_3());
    }
)?(	otherlv_12='report' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getVerificationActivityResultAccess().getReportKeyword_9_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationActivityResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getResultReportResultReportCrossReference_9_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getMetricsMetricsParserRuleCall_10_0()); 
	    }
		lv_metrics_14_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_14_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_15='message' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getVerificationActivityResultAccess().getMessageKeyword_11_0());
    }
(
(
		lv_message_16_0=RULE_STRING
		{
			newLeafNode(lv_message_16_0, grammarAccess.getVerificationActivityResultAccess().getMessageSTRINGTerminalRuleCall_11_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationActivityResultRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_16_0, 
        		"STRING");
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getPreconditionResultPreconditionResultParserRuleCall_12_0()); 
	    }
		lv_preconditionResult_17_0=rulePreconditionResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityResultRule());
	        }
       		set(
       			$current, 
       			"preconditionResult",
        		lv_preconditionResult_17_0, 
        		"PreconditionResult");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getValidationResultValidationResultParserRuleCall_13_0()); 
	    }
		lv_validationResult_18_0=ruleValidationResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityResultRule());
	        }
       		set(
       			$current, 
       			"validationResult",
        		lv_validationResult_18_0, 
        		"ValidationResult");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_19=']' 
    {
    	newLeafNode(otherlv_19, grammarAccess.getVerificationActivityResultAccess().getRightSquareBracketKeyword_14());
    }
)
;







// Entry rule entryRuleVerificationExpr
entryRuleVerificationExpr returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVerificationExprRule()); }
	 iv_ruleVerificationExpr=ruleVerificationExpr 
	 { $current=$iv_ruleVerificationExpr.current; } 
	 EOF 
;

// Rule VerificationExpr
ruleVerificationExpr returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getVerificationExprAccess().getVerificationActivityResultParserRuleCall_0()); 
    }
    this_VerificationActivityResult_0=ruleVerificationActivityResult
    { 
        $current = $this_VerificationActivityResult_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVerificationExprAccess().getElseResultParserRuleCall_1()); 
    }
    this_ElseResult_1=ruleElseResult
    { 
        $current = $this_ElseResult_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVerificationExprAccess().getThenResultParserRuleCall_2()); 
    }
    this_ThenResult_2=ruleThenResult
    { 
        $current = $this_ThenResult_2.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleElseResult
entryRuleElseResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getElseResultRule()); }
	 iv_ruleElseResult=ruleElseResult 
	 { $current=$iv_ruleElseResult.current; } 
	 EOF 
;

// Rule ElseResult
ruleElseResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='else' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getElseResultAccess().getElseKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getElseResultAccess().getFirstVerificationExprParserRuleCall_1_0()); 
	    }
		lv_first_1_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseResultRule());
	        }
       		add(
       			$current, 
       			"first",
        		lv_first_1_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)+(	otherlv_2='error' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getElseResultAccess().getErrorKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getElseResultAccess().getErrorVerificationExprParserRuleCall_2_1_0()); 
	    }
		lv_error_3_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseResultRule());
	        }
       		add(
       			$current, 
       			"error",
        		lv_error_3_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)+)?(	otherlv_4='fail' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getElseResultAccess().getFailKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getElseResultAccess().getFailVerificationExprParserRuleCall_3_1_0()); 
	    }
		lv_fail_5_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseResultRule());
	        }
       		add(
       			$current, 
       			"fail",
        		lv_fail_5_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)+)?(	otherlv_6='timeout' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getElseResultAccess().getTimeoutKeyword_4_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getElseResultAccess().getTimeoutVerificationExprParserRuleCall_4_1_0()); 
	    }
		lv_timeout_7_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseResultRule());
	        }
       		add(
       			$current, 
       			"timeout",
        		lv_timeout_7_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)+)?	otherlv_8='[' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getElseResultAccess().getLeftSquareBracketKeyword_5());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getElseResultAccess().getDidFailElseTypeEnumRuleCall_6_0()); 
	    }
		lv_didFail_9_0=ruleElseType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseResultRule());
	        }
       		set(
       			$current, 
       			"didFail",
        		lv_didFail_9_0, 
        		"ElseType");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getElseResultAccess().getMetricsMetricsParserRuleCall_7_0()); 
	    }
		lv_metrics_10_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_10_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_11=']' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getElseResultAccess().getRightSquareBracketKeyword_8());
    }
)
;





// Entry rule entryRuleThenResult
entryRuleThenResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getThenResultRule()); }
	 iv_ruleThenResult=ruleThenResult 
	 { $current=$iv_ruleThenResult.current; } 
	 EOF 
;

// Rule ThenResult
ruleThenResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='then' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getThenResultAccess().getThenKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getThenResultAccess().getFirstVerificationExprParserRuleCall_1_0()); 
	    }
		lv_first_1_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getThenResultRule());
	        }
       		add(
       			$current, 
       			"first",
        		lv_first_1_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_2='do' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getThenResultAccess().getDoKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getThenResultAccess().getSecondVerificationExprParserRuleCall_3_0()); 
	    }
		lv_second_3_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getThenResultRule());
	        }
       		add(
       			$current, 
       			"second",
        		lv_second_3_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getThenResultAccess().getLeftSquareBracketKeyword_4());
    }
(
(
		lv_didThenFail_5_0=	'thenfailed' 
    {
        newLeafNode(lv_didThenFail_5_0, grammarAccess.getThenResultAccess().getDidThenFailThenfailedKeyword_5_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getThenResultRule());
	        }
       		setWithLastConsumed($current, "didThenFail", true, "thenfailed");
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getThenResultAccess().getMetricsMetricsParserRuleCall_6_0()); 
	    }
		lv_metrics_6_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getThenResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_6_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7=']' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getThenResultAccess().getRightSquareBracketKeyword_7());
    }
)
;





// Entry rule entryRuleMetrics
entryRuleMetrics returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMetricsRule()); }
	 iv_ruleMetrics=ruleMetrics 
	 { $current=$iv_ruleMetrics.current; } 
	 EOF 
;

// Rule Metrics
ruleMetrics returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getMetricsAccess().getMetricsAction_0(),
            $current);
    }
)(	otherlv_1='tbdcount' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMetricsAccess().getTbdcountKeyword_1_0());
    }
(
(
		lv_tbdCount_2_0=RULE_INT
		{
			newLeafNode(lv_tbdCount_2_0, grammarAccess.getMetricsAccess().getTbdCountINTTerminalRuleCall_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"tbdCount",
        		lv_tbdCount_2_0, 
        		"INT");
	    }

)
))?(	otherlv_3='successcount' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getMetricsAccess().getSuccesscountKeyword_2_0());
    }
(
(
		lv_successCount_4_0=RULE_INT
		{
			newLeafNode(lv_successCount_4_0, grammarAccess.getMetricsAccess().getSuccessCountINTTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"successCount",
        		lv_successCount_4_0, 
        		"INT");
	    }

)
))?(	otherlv_5='failcount' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getMetricsAccess().getFailcountKeyword_3_0());
    }
(
(
		lv_failCount_6_0=RULE_INT
		{
			newLeafNode(lv_failCount_6_0, grammarAccess.getMetricsAccess().getFailCountINTTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"failCount",
        		lv_failCount_6_0, 
        		"INT");
	    }

)
))?(	otherlv_7='timeoutcount' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getMetricsAccess().getTimeoutcountKeyword_4_0());
    }
(
(
		lv_timeoutCount_8_0=RULE_INT
		{
			newLeafNode(lv_timeoutCount_8_0, grammarAccess.getMetricsAccess().getTimeoutCountINTTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"timeoutCount",
        		lv_timeoutCount_8_0, 
        		"INT");
	    }

)
))?(	otherlv_9='errorcount' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getMetricsAccess().getErrorcountKeyword_5_0());
    }
(
(
		lv_errorCount_10_0=RULE_INT
		{
			newLeafNode(lv_errorCount_10_0, grammarAccess.getMetricsAccess().getErrorCountINTTerminalRuleCall_5_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"errorCount",
        		lv_errorCount_10_0, 
        		"INT");
	    }

)
))?(	otherlv_11='didelsecount' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getMetricsAccess().getDidelsecountKeyword_6_0());
    }
(
(
		lv_didelseCount_12_0=RULE_INT
		{
			newLeafNode(lv_didelseCount_12_0, grammarAccess.getMetricsAccess().getDidelseCountINTTerminalRuleCall_6_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"didelseCount",
        		lv_didelseCount_12_0, 
        		"INT");
	    }

)
))?(	otherlv_13='thenskipcount' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getMetricsAccess().getThenskipcountKeyword_7_0());
    }
(
(
		lv_thenskipCount_14_0=RULE_INT
		{
			newLeafNode(lv_thenskipCount_14_0, grammarAccess.getMetricsAccess().getThenskipCountINTTerminalRuleCall_7_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"thenskipCount",
        		lv_thenskipCount_14_0, 
        		"INT");
	    }

)
))?(	otherlv_15='prefailcount' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getMetricsAccess().getPrefailcountKeyword_8_0());
    }
(
(
		lv_preconditionfailCount_16_0=RULE_INT
		{
			newLeafNode(lv_preconditionfailCount_16_0, grammarAccess.getMetricsAccess().getPreconditionfailCountINTTerminalRuleCall_8_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"preconditionfailCount",
        		lv_preconditionfailCount_16_0, 
        		"INT");
	    }

)
))?(	otherlv_17='validfailcount' 
    {
    	newLeafNode(otherlv_17, grammarAccess.getMetricsAccess().getValidfailcountKeyword_9_0());
    }
(
(
		lv_validationfailCount_18_0=RULE_INT
		{
			newLeafNode(lv_validationfailCount_18_0, grammarAccess.getMetricsAccess().getValidationfailCountINTTerminalRuleCall_9_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"validationfailCount",
        		lv_validationfailCount_18_0, 
        		"INT");
	    }

)
))?(	otherlv_19='featurescount' 
    {
    	newLeafNode(otherlv_19, grammarAccess.getMetricsAccess().getFeaturescountKeyword_10_0());
    }
(
(
		lv_featuresCount_20_0=RULE_INT
		{
			newLeafNode(lv_featuresCount_20_0, grammarAccess.getMetricsAccess().getFeaturesCountINTTerminalRuleCall_10_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"featuresCount",
        		lv_featuresCount_20_0, 
        		"INT");
	    }

)
))?(	otherlv_21='featuresrequirementscount' 
    {
    	newLeafNode(otherlv_21, grammarAccess.getMetricsAccess().getFeaturesrequirementscountKeyword_11_0());
    }
(
(
		lv_featuresRequirementsCount_22_0=RULE_INT
		{
			newLeafNode(lv_featuresRequirementsCount_22_0, grammarAccess.getMetricsAccess().getFeaturesRequirementsCountINTTerminalRuleCall_11_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"featuresRequirementsCount",
        		lv_featuresRequirementsCount_22_0, 
        		"INT");
	    }

)
))?(	otherlv_23='qualitycategoryrequirementscount' 
    {
    	newLeafNode(otherlv_23, grammarAccess.getMetricsAccess().getQualitycategoryrequirementscountKeyword_12_0());
    }
(
(
		lv_qualityCategoryRequirementsCount_24_0=RULE_INT
		{
			newLeafNode(lv_qualityCategoryRequirementsCount_24_0, grammarAccess.getMetricsAccess().getQualityCategoryRequirementsCountINTTerminalRuleCall_12_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"qualityCategoryRequirementsCount",
        		lv_qualityCategoryRequirementsCount_24_0, 
        		"INT");
	    }

)
))?(	otherlv_25='totalqualitycategorycount' 
    {
    	newLeafNode(otherlv_25, grammarAccess.getMetricsAccess().getTotalqualitycategorycountKeyword_13_0());
    }
(
(
		lv_totalQualityCategoryCount_26_0=RULE_INT
		{
			newLeafNode(lv_totalQualityCategoryCount_26_0, grammarAccess.getMetricsAccess().getTotalQualityCategoryCountINTTerminalRuleCall_13_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"totalQualityCategoryCount",
        		lv_totalQualityCategoryCount_26_0, 
        		"INT");
	    }

)
))?(	otherlv_27='requirementswithoutplanclaimcount' 
    {
    	newLeafNode(otherlv_27, grammarAccess.getMetricsAccess().getRequirementswithoutplanclaimcountKeyword_14_0());
    }
(
(
		lv_requirementsWithoutPlanClaimCount_28_0=RULE_INT
		{
			newLeafNode(lv_requirementsWithoutPlanClaimCount_28_0, grammarAccess.getMetricsAccess().getRequirementsWithoutPlanClaimCountINTTerminalRuleCall_14_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"requirementsWithoutPlanClaimCount",
        		lv_requirementsWithoutPlanClaimCount_28_0, 
        		"INT");
	    }

)
))?(	otherlv_29='noverificationplanscount' 
    {
    	newLeafNode(otherlv_29, grammarAccess.getMetricsAccess().getNoverificationplanscountKeyword_15_0());
    }
(
(
		lv_noVerificationPlansCount_30_0=RULE_INT
		{
			newLeafNode(lv_noVerificationPlansCount_30_0, grammarAccess.getMetricsAccess().getNoVerificationPlansCountINTTerminalRuleCall_15_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"noVerificationPlansCount",
        		lv_noVerificationPlansCount_30_0, 
        		"INT");
	    }

)
))?(	otherlv_31='requirementscount' 
    {
    	newLeafNode(otherlv_31, grammarAccess.getMetricsAccess().getRequirementscountKeyword_16_0());
    }
(
(
		lv_requirementsCount_32_0=RULE_INT
		{
			newLeafNode(lv_requirementsCount_32_0, grammarAccess.getMetricsAccess().getRequirementsCountINTTerminalRuleCall_16_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"requirementsCount",
        		lv_requirementsCount_32_0, 
        		"INT");
	    }

)
))?(	otherlv_33='exceptionscount' 
    {
    	newLeafNode(otherlv_33, grammarAccess.getMetricsAccess().getExceptionscountKeyword_17_0());
    }
(
(
		lv_exceptionsCount_34_0=RULE_INT
		{
			newLeafNode(lv_exceptionsCount_34_0, grammarAccess.getMetricsAccess().getExceptionsCountINTTerminalRuleCall_17_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exceptionsCount",
        		lv_exceptionsCount_34_0, 
        		"INT");
	    }

)
))?(	otherlv_35='reqtargethasemv2subclausecount' 
    {
    	newLeafNode(otherlv_35, grammarAccess.getMetricsAccess().getReqtargethasemv2subclausecountKeyword_18_0());
    }
(
(
		lv_reqTargetHasEMV2SubclauseCount_36_0=RULE_INT
		{
			newLeafNode(lv_reqTargetHasEMV2SubclauseCount_36_0, grammarAccess.getMetricsAccess().getReqTargetHasEMV2SubclauseCountINTTerminalRuleCall_18_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"reqTargetHasEMV2SubclauseCount",
        		lv_reqTargetHasEMV2SubclauseCount_36_0, 
        		"INT");
	    }

)
))?(	otherlv_37='featuresrequiringclassifiercount' 
    {
    	newLeafNode(otherlv_37, grammarAccess.getMetricsAccess().getFeaturesrequiringclassifiercountKeyword_19_0());
    }
(
(
		lv_featuresRequiringClassifierCount_38_0=RULE_INT
		{
			newLeafNode(lv_featuresRequiringClassifierCount_38_0, grammarAccess.getMetricsAccess().getFeaturesRequiringClassifierCountINTTerminalRuleCall_19_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"featuresRequiringClassifierCount",
        		lv_featuresRequiringClassifierCount_38_0, 
        		"INT");
	    }

)
))?(	otherlv_39='featureswithrequiredclassifiercount' 
    {
    	newLeafNode(otherlv_39, grammarAccess.getMetricsAccess().getFeatureswithrequiredclassifiercountKeyword_20_0());
    }
(
(
		lv_featuresWithRequiredClassifierCount_40_0=RULE_INT
		{
			newLeafNode(lv_featuresWithRequiredClassifierCount_40_0, grammarAccess.getMetricsAccess().getFeaturesWithRequiredClassifierCountINTTerminalRuleCall_20_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"featuresWithRequiredClassifierCount",
        		lv_featuresWithRequiredClassifierCount_40_0, 
        		"INT");
	    }

)
))?(	otherlv_41='weight' 
    {
    	newLeafNode(otherlv_41, grammarAccess.getMetricsAccess().getWeightKeyword_21_0());
    }
(
(
		lv_weight_42_0=RULE_INT
		{
			newLeafNode(lv_weight_42_0, grammarAccess.getMetricsAccess().getWeightINTTerminalRuleCall_21_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"weight",
        		lv_weight_42_0, 
        		"INT");
	    }

)
))?(	otherlv_43='time' 
    {
    	newLeafNode(otherlv_43, grammarAccess.getMetricsAccess().getTimeKeyword_22_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMetricsAccess().getExecutionTimeAIntParserRuleCall_22_1_0()); 
	    }
		lv_executionTime_44_0=ruleAInt		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMetricsRule());
	        }
       		set(
       			$current, 
       			"executionTime",
        		lv_executionTime_44_0, 
        		"AInt");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;







// Entry rule entryRuleQualifiedClaimReference
entryRuleQualifiedClaimReference returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedClaimReferenceRule()); }
	 iv_ruleQualifiedClaimReference=ruleQualifiedClaimReference 
	 { $current=$iv_ruleQualifiedClaimReference.current; } 
	 EOF 
;

// Rule QualifiedClaimReference
ruleQualifiedClaimReference returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getQualifiedClaimReferenceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getQualifiedClaimReferenceAccess().getVerificationPlanVerificationPlanCrossReference_0_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='#' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getQualifiedClaimReferenceAccess().getNumberSignKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getQualifiedClaimReferenceAccess().getRequirementNestedClaimReferenceParserRuleCall_2_0()); 
	    }
		lv_requirement_2_0=ruleNestedClaimReference		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQualifiedClaimReferenceRule());
	        }
       		set(
       			$current, 
       			"requirement",
        		lv_requirement_2_0, 
        		"NestedClaimReference");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleQualifiedVAReference
entryRuleQualifiedVAReference returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedVAReferenceRule()); }
	 iv_ruleQualifiedVAReference=ruleQualifiedVAReference 
	 { $current=$iv_ruleQualifiedVAReference.current; } 
	 EOF 
;

// Rule QualifiedVAReference
ruleQualifiedVAReference returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getQualifiedVAReferenceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getQualifiedVAReferenceAccess().getVerificationPlanVerificationPlanCrossReference_0_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='#' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getQualifiedVAReferenceAccess().getNumberSignKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getQualifiedVAReferenceAccess().getRequirementNestedClaimReferenceParserRuleCall_2_0()); 
	    }
		lv_requirement_2_0=ruleNestedClaimReference		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQualifiedVAReferenceRule());
	        }
       		set(
       			$current, 
       			"requirement",
        		lv_requirement_2_0, 
        		"NestedClaimReference");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='#' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getQualifiedVAReferenceAccess().getNumberSignKeyword_3());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getQualifiedVAReferenceRule());
	        }
        }
	otherlv_4=RULE_ID
	{
		newLeafNode(otherlv_4, grammarAccess.getQualifiedVAReferenceAccess().getVerificationActivityVerificationActivityCrossReference_4_0()); 
	}

)
))
;





// Entry rule entryRuleNestedClaimReference
entryRuleNestedClaimReference returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNestedClaimReferenceRule()); }
	 iv_ruleNestedClaimReference=ruleNestedClaimReference 
	 { $current=$iv_ruleNestedClaimReference.current; } 
	 EOF 
;

// Rule NestedClaimReference
ruleNestedClaimReference returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getNestedClaimReferenceRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getNestedClaimReferenceAccess().getRequirementRequirementCrossReference_0_0()); 
	}

)
)(	otherlv_1='.' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getNestedClaimReferenceAccess().getFullStopKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNestedClaimReferenceAccess().getSubNestedClaimReferenceParserRuleCall_1_1_0()); 
	    }
		lv_sub_2_0=ruleNestedClaimReference		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNestedClaimReferenceRule());
	        }
       		set(
       			$current, 
       			"sub",
        		lv_sub_2_0, 
        		"NestedClaimReference");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;







// Entry rule entryRuleDescriptionElement
entryRuleDescriptionElement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDescriptionElementRule()); }
	 iv_ruleDescriptionElement=ruleDescriptionElement 
	 { $current=$iv_ruleDescriptionElement.current; } 
	 EOF 
;

// Rule DescriptionElement
ruleDescriptionElement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_text_0_0=RULE_STRING
		{
			newLeafNode(lv_text_0_0, grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDescriptionElementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"text",
        		lv_text_0_0, 
        		"STRING");
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getShowValueShowValueParserRuleCall_1_0()); 
	    }
		lv_showValue_1_0=ruleShowValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
	        }
       		set(
       			$current, 
       			"showValue",
        		lv_showValue_1_0, 
        		"ShowValue");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		lv_thisTarget_2_0=	'this' 
    {
        newLeafNode(lv_thisTarget_2_0, grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_2_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDescriptionElementRule());
	        }
       		setWithLastConsumed($current, "thisTarget", true, "this");
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getImageImageReferenceParserRuleCall_3_0()); 
	    }
		lv_image_3_0=ruleImageReference		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
	        }
       		set(
       			$current, 
       			"image",
        		lv_image_3_0, 
        		"ImageReference");
	        afterParserOrEnumRuleCall();
	    }

)
))
;









// Entry rule entryRuleResultIssue
entryRuleResultIssue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResultIssueRule()); }
	 iv_ruleResultIssue=ruleResultIssue 
	 { $current=$iv_ruleResultIssue.current; } 
	 EOF 
;

// Rule ResultIssue
ruleResultIssue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_0_0()); 
	    }
		lv_issueType_0_0=ruleResultIssueType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultIssueRule());
	        }
       		set(
       			$current, 
       			"issueType",
        		lv_issueType_0_0, 
        		"ResultIssueType");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_message_1_0=RULE_STRING
		{
			newLeafNode(lv_message_1_0, grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultIssueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_1_0, 
        		"STRING");
	    }

)
)(	otherlv_2='target' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getResultIssueAccess().getTargetKeyword_2_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultIssueRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_2_1_0()); 
	    }
		ruleNoQuoteString		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_4='exception' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getResultIssueAccess().getExceptionKeyword_3_0());
    }
(
(
		lv_exceptionType_5_0=RULE_STRING
		{
			newLeafNode(lv_exceptionType_5_0, grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultIssueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exceptionType",
        		lv_exceptionType_5_0, 
        		"STRING");
	    }

)
))?(	otherlv_6='diagnosticId' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getResultIssueAccess().getDiagnosticIdKeyword_4_0());
    }
(
(
		lv_diagnosticId_7_0=RULE_STRING
		{
			newLeafNode(lv_diagnosticId_7_0, grammarAccess.getResultIssueAccess().getDiagnosticIdSTRINGTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultIssueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"diagnosticId",
        		lv_diagnosticId_7_0, 
        		"STRING");
	    }

)
))?(	otherlv_8='[' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); 
	    }
		lv_issues_9_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultIssueRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_9_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_10=']' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2());
    }
)?)
;





// Entry rule entryRuleTypeRef
entryRuleTypeRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTypeRefRule()); }
	 iv_ruleTypeRef=ruleTypeRef 
	 { $current=$iv_ruleTypeRef.current; } 
	 EOF 
;

// Rule TypeRef
ruleTypeRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
    {
        $current = forceCreateModelElement(
            grammarAccess.getTypeRefAccess().getAadlBooleanAction_0_0(),
            $current);
    }
)	otherlv_1='boolean' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTypeRefAccess().getBooleanKeyword_0_1());
    }
)
    |((
    {
        $current = forceCreateModelElement(
            grammarAccess.getTypeRefAccess().getAadlIntegerAction_1_0(),
            $current);
    }
)	otherlv_3='integer' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getTypeRefAccess().getIntegerKeyword_1_1());
    }
(	otherlv_4='units' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getTypeRefAccess().getUnitsKeyword_1_2_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getTypeRefRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_1_2_1_0()); 
	    }
		ruleAADLPROPERTYREFERENCE		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?)
    |((
    {
        $current = forceCreateModelElement(
            grammarAccess.getTypeRefAccess().getAadlRealAction_2_0(),
            $current);
    }
)	otherlv_7='real' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getTypeRefAccess().getRealKeyword_2_1());
    }
(	otherlv_8='units' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getTypeRefAccess().getUnitsKeyword_2_2_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getTypeRefRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_2_2_1_0()); 
	    }
		ruleAADLPROPERTYREFERENCE		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?)
    |((
    {
        $current = forceCreateModelElement(
            grammarAccess.getTypeRefAccess().getAadlStringAction_3_0(),
            $current);
    }
)	otherlv_11='string' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getTypeRefAccess().getStringKeyword_3_1());
    }
)
    |((
    {
        $current = forceCreateModelElement(
            grammarAccess.getTypeRefAccess().getModelRefAction_4_0(),
            $current);
    }
)	otherlv_13='model' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getTypeRefAccess().getModelKeyword_4_1());
    }
	otherlv_14='element' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getTypeRefAccess().getElementKeyword_4_2());
    }
)
    |((
    {
        $current = forceCreateModelElement(
            grammarAccess.getTypeRefAccess().getTypeRefAction_5_0(),
            $current);
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getTypeRefRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getTypeRefAccess().getRefPropertyTypeCrossReference_5_1_0()); 
	    }
		ruleAADLPROPERTYREFERENCE		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)))
;





// Entry rule entryRulePropertyRef
entryRulePropertyRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPropertyRefRule()); }
	 iv_rulePropertyRef=rulePropertyRef 
	 { $current=$iv_rulePropertyRef.current; } 
	 EOF 
;

// Rule PropertyRef
rulePropertyRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getPropertyRefAccess().getPropertyRefAction_0(),
            $current);
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getPropertyRefRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getPropertyRefAccess().getRefPropertyCrossReference_1_0()); 
	    }
		ruleAADLPROPERTYREFERENCE		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))
;









// Entry rule entryRuleAModelOrPropertyReference
entryRuleAModelOrPropertyReference returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAModelOrPropertyReferenceRule()); }
	 iv_ruleAModelOrPropertyReference=ruleAModelOrPropertyReference 
	 { $current=$iv_ruleAModelOrPropertyReference.current; } 
	 EOF 
;

// Rule AModelOrPropertyReference
ruleAModelOrPropertyReference returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    { 
        newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getAModelReferenceParserRuleCall_0_0()); 
    }
    this_AModelReference_0=ruleAModelReference
    { 
        $current = $this_AModelReference_0.current; 
        afterParserOrEnumRuleCall();
    }
(((((
)	'#' 
))=>((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceModelElementReferenceAction_0_1_0_0_0(),
            $current);
    }
)	otherlv_2='#' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAModelOrPropertyReferenceAccess().getNumberSignKeyword_0_1_0_0_1());
    }
))(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAModelOrPropertyReferenceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0()); 
	    }
		ruleAADLPROPERTYREFERENCE		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?)
    |
    { 
        newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceParserRuleCall_1()); 
    }
    this_APropertyReference_4=ruleAPropertyReference
    { 
        $current = $this_APropertyReference_4.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleAModelReference
entryRuleAModelReference returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAModelReferenceRule()); }
	 iv_ruleAModelReference=ruleAModelReference 
	 { $current=$iv_ruleAModelReference.current; } 
	 EOF 
;

// Rule AModelReference
ruleAModelReference returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAModelReferenceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_0_0()); 
	    }
		ruleThisKeyword		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAModelReferenceAccess().getAModelReferencePrevAction_1_0(),
            $current);
    }
)	otherlv_2='.' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAModelReferenceAccess().getFullStopKeyword_1_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAModelReferenceRule());
	        }
        }
	otherlv_3=RULE_ID
	{
		newLeafNode(otherlv_3, grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_1_2_0()); 
	}

)
))*)
;





// Entry rule entryRuleAPropertyReference
entryRuleAPropertyReference returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAPropertyReferenceRule()); }
	 iv_ruleAPropertyReference=ruleAPropertyReference 
	 { $current=$iv_ruleAPropertyReference.current; } 
	 EOF 
;

// Rule APropertyReference
ruleAPropertyReference returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getAPropertyReferenceAccess().getAPropertyReferenceAction_0(),
            $current);
    }
)	otherlv_1='#' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAPropertyReferenceAccess().getNumberSignKeyword_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAPropertyReferenceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); 
	    }
		ruleAADLPROPERTYREFERENCE		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleAVariableReference
entryRuleAVariableReference returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAVariableReferenceRule()); }
	 iv_ruleAVariableReference=ruleAVariableReference 
	 { $current=$iv_ruleAVariableReference.current; } 
	 EOF 
;

// Rule AVariableReference
ruleAVariableReference returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getAVariableReferenceAccess().getAVariableReferenceAction_0(),
            $current);
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAVariableReferenceRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationCrossReference_1_0()); 
	}

)
))
;





// Entry rule entryRuleShowValue
entryRuleShowValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getShowValueRule()); }
	 iv_ruleShowValue=ruleShowValue 
	 { $current=$iv_ruleShowValue.current; } 
	 EOF 
;

// Rule ShowValue
ruleShowValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getShowValueRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getShowValueAccess().getRefAVariableDeclarationCrossReference_0_0()); 
	}

)
)(	otherlv_1='%' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0());
    }

    |(	otherlv_2='in' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getShowValueAccess().getInKeyword_1_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getShowValueRule());
	        }
        }
	otherlv_3=RULE_ID
	{
		newLeafNode(otherlv_3, grammarAccess.getShowValueAccess().getUnitUnitLiteralCrossReference_1_1_1_0()); 
	}

)
)))?)
;





// Entry rule entryRuleImageReference
entryRuleImageReference returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getImageReferenceRule()); }
	 iv_ruleImageReference=ruleImageReference 
	 { $current=$iv_ruleImageReference.current; } 
	 EOF 
;

// Rule ImageReference
ruleImageReference returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='img' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getImageReferenceAccess().getImgKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0()); 
	    }
		lv_imgfile_1_0=ruleIMGREF		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getImageReferenceRule());
	        }
       		set(
       			$current, 
       			"imgfile",
        		lv_imgfile_1_0, 
        		"IMGREF");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleIMGREF
entryRuleIMGREF returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getIMGREFRule()); } 
	 iv_ruleIMGREF=ruleIMGREF 
	 { $current=$iv_ruleIMGREF.current.getText(); }  
	 EOF 
;

// Rule IMGREF
ruleIMGREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_0_0()); 
    }

	kw='/' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getIMGREFAccess().getSolidusKeyword_0_1()); 
    }
)*    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_1()); 
    }

	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getIMGREFAccess().getFullStopKeyword_2()); 
    }
    this_ID_4=RULE_ID    {
		$current.merge(this_ID_4);
    }

    { 
    newLeafNode(this_ID_4, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_3()); 
    }
)
    ;





// Entry rule entryRuleAExpression
entryRuleAExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAExpressionRule()); }
	 iv_ruleAExpression=ruleAExpression 
	 { $current=$iv_ruleAExpression.current; } 
	 EOF 
;

// Rule AExpression
ruleAExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

    { 
        newCompositeNode(grammarAccess.getAExpressionAccess().getAOrExpressionParserRuleCall()); 
    }
    this_AOrExpression_0=ruleAOrExpression
    { 
        $current = $this_AOrExpression_0.current; 
        afterParserOrEnumRuleCall();
    }

;





// Entry rule entryRuleAOrExpression
entryRuleAOrExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAOrExpressionRule()); }
	 iv_ruleAOrExpression=ruleAOrExpression 
	 { $current=$iv_ruleAOrExpression.current; } 
	 EOF 
;

// Rule AOrExpression
ruleAOrExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0()); 
    }
    this_AAndExpression_0=ruleAAndExpression
    { 
        $current = $this_AAndExpression_0.current; 
        afterParserOrEnumRuleCall();
    }
(((((
)(
(
ruleOpOr
)
)))=>((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0()); 
	    }
		lv_operator_2_0=ruleOpOr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
	        }
       		set(
       			$current, 
       			"operator",
        		lv_operator_2_0, 
        		"OpOr");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getRightAAndExpressionParserRuleCall_1_1_0()); 
	    }
		lv_right_3_0=ruleAAndExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_3_0, 
        		"AAndExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleOpOr
entryRuleOpOr returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getOpOrRule()); } 
	 iv_ruleOpOr=ruleOpOr 
	 { $current=$iv_ruleOpOr.current.getText(); }  
	 EOF 
;

// Rule OpOr
ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='or' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword_0()); 
    }

    |
	kw='||' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword_1()); 
    }
)
    ;





// Entry rule entryRuleAAndExpression
entryRuleAAndExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAAndExpressionRule()); }
	 iv_ruleAAndExpression=ruleAAndExpression 
	 { $current=$iv_ruleAAndExpression.current; } 
	 EOF 
;

// Rule AAndExpression
ruleAAndExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getAAndExpressionAccess().getAEqualityExpressionParserRuleCall_0()); 
    }
    this_AEqualityExpression_0=ruleAEqualityExpression
    { 
        $current = $this_AEqualityExpression_0.current; 
        afterParserOrEnumRuleCall();
    }
(((((
)(
(
ruleOpAnd
)
)))=>((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0()); 
	    }
		lv_operator_2_0=ruleOpAnd		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
	        }
       		set(
       			$current, 
       			"operator",
        		lv_operator_2_0, 
        		"OpAnd");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getRightAEqualityExpressionParserRuleCall_1_1_0()); 
	    }
		lv_right_3_0=ruleAEqualityExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_3_0, 
        		"AEqualityExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleOpAnd
entryRuleOpAnd returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getOpAndRule()); } 
	 iv_ruleOpAnd=ruleOpAnd 
	 { $current=$iv_ruleOpAnd.current.getText(); }  
	 EOF 
;

// Rule OpAnd
ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='and' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword_0()); 
    }

    |
	kw='&&' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword_1()); 
    }
)
    ;





// Entry rule entryRuleAEqualityExpression
entryRuleAEqualityExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAEqualityExpressionRule()); }
	 iv_ruleAEqualityExpression=ruleAEqualityExpression 
	 { $current=$iv_ruleAEqualityExpression.current; } 
	 EOF 
;

// Rule AEqualityExpression
ruleAEqualityExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getARelationalExpressionParserRuleCall_0()); 
    }
    this_ARelationalExpression_0=ruleARelationalExpression
    { 
        $current = $this_ARelationalExpression_0.current; 
        afterParserOrEnumRuleCall();
    }
(((((
)(
(
ruleOpEquality
)
)))=>((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0()); 
	    }
		lv_operator_2_0=ruleOpEquality		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAEqualityExpressionRule());
	        }
       		set(
       			$current, 
       			"operator",
        		lv_operator_2_0, 
        		"OpEquality");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getRightARelationalExpressionParserRuleCall_1_1_0()); 
	    }
		lv_right_3_0=ruleARelationalExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAEqualityExpressionRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_3_0, 
        		"ARelationalExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleOpEquality
entryRuleOpEquality returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getOpEqualityRule()); } 
	 iv_ruleOpEquality=ruleOpEquality 
	 { $current=$iv_ruleOpEquality.current.getText(); }  
	 EOF 
;

// Rule OpEquality
ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='==' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
    }

    |
	kw='!=' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
    }
)
    ;





// Entry rule entryRuleARelationalExpression
entryRuleARelationalExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getARelationalExpressionRule()); }
	 iv_ruleARelationalExpression=ruleARelationalExpression 
	 { $current=$iv_ruleARelationalExpression.current; } 
	 EOF 
;

// Rule ARelationalExpression
ruleARelationalExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getAAdditiveExpressionParserRuleCall_0()); 
    }
    this_AAdditiveExpression_0=ruleAAdditiveExpression
    { 
        $current = $this_AAdditiveExpression_0.current; 
        afterParserOrEnumRuleCall();
    }
(((((
)(
(
ruleOpCompare
)
)))=>((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0()); 
	    }
		lv_operator_2_0=ruleOpCompare		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
	        }
       		set(
       			$current, 
       			"operator",
        		lv_operator_2_0, 
        		"OpCompare");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getRightAAdditiveExpressionParserRuleCall_1_1_0()); 
	    }
		lv_right_3_0=ruleAAdditiveExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_3_0, 
        		"AAdditiveExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleOpCompare
entryRuleOpCompare returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getOpCompareRule()); } 
	 iv_ruleOpCompare=ruleOpCompare 
	 { $current=$iv_ruleOpCompare.current.getText(); }  
	 EOF 
;

// Rule OpCompare
ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='>=' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
    }

    |
	kw='<=' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
    }

    |
	kw='>' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
    }

    |
	kw='<' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
    }

    |
	kw='><' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignLessThanSignKeyword_4()); 
    }
)
    ;





// Entry rule entryRuleAAdditiveExpression
entryRuleAAdditiveExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAAdditiveExpressionRule()); }
	 iv_ruleAAdditiveExpression=ruleAAdditiveExpression 
	 { $current=$iv_ruleAAdditiveExpression.current; } 
	 EOF 
;

// Rule AAdditiveExpression
ruleAAdditiveExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0()); 
    }
    this_AMultiplicativeExpression_0=ruleAMultiplicativeExpression
    { 
        $current = $this_AMultiplicativeExpression_0.current; 
        afterParserOrEnumRuleCall();
    }
(((((
)(
(
ruleOpAdd
)
)))=>((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0()); 
	    }
		lv_operator_2_0=ruleOpAdd		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
	        }
       		set(
       			$current, 
       			"operator",
        		lv_operator_2_0, 
        		"OpAdd");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getRightAMultiplicativeExpressionParserRuleCall_1_1_0()); 
	    }
		lv_right_3_0=ruleAMultiplicativeExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_3_0, 
        		"AMultiplicativeExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleOpAdd
entryRuleOpAdd returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getOpAddRule()); } 
	 iv_ruleOpAdd=ruleOpAdd 
	 { $current=$iv_ruleOpAdd.current.getText(); }  
	 EOF 
;

// Rule OpAdd
ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='+' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
    }

    |
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
    }
)
    ;





// Entry rule entryRuleAMultiplicativeExpression
entryRuleAMultiplicativeExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAMultiplicativeExpressionRule()); }
	 iv_ruleAMultiplicativeExpression=ruleAMultiplicativeExpression 
	 { $current=$iv_ruleAMultiplicativeExpression.current; } 
	 EOF 
;

// Rule AMultiplicativeExpression
ruleAMultiplicativeExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getAUnaryOperationParserRuleCall_0()); 
    }
    this_AUnaryOperation_0=ruleAUnaryOperation
    { 
        $current = $this_AUnaryOperation_0.current; 
        afterParserOrEnumRuleCall();
    }
(((((
)(
(
ruleOpMulti
)
)))=>((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0()); 
	    }
		lv_operator_2_0=ruleOpMulti		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
	        }
       		set(
       			$current, 
       			"operator",
        		lv_operator_2_0, 
        		"OpMulti");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getRightAUnaryOperationParserRuleCall_1_1_0()); 
	    }
		lv_right_3_0=ruleAUnaryOperation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_3_0, 
        		"AUnaryOperation");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleOpMulti
entryRuleOpMulti returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getOpMultiRule()); } 
	 iv_ruleOpMulti=ruleOpMulti 
	 { $current=$iv_ruleOpMulti.current.getText(); }  
	 EOF 
;

// Rule OpMulti
ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='*' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
    }

    |
	kw='/' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); 
    }

    |
	kw='div' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpMultiAccess().getDivKeyword_2()); 
    }

    |
	kw='mod' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpMultiAccess().getModKeyword_3()); 
    }
)
    ;





// Entry rule entryRuleAUnaryOperation
entryRuleAUnaryOperation returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAUnaryOperationRule()); }
	 iv_ruleAUnaryOperation=ruleAUnaryOperation 
	 { $current=$iv_ruleAUnaryOperation.current; } 
	 EOF 
;

// Rule AUnaryOperation
ruleAUnaryOperation returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
    {
        $current = forceCreateModelElement(
            grammarAccess.getAUnaryOperationAccess().getAUnaryOperationAction_0_0(),
            $current);
    }
)((
(
ruleOpUnary
)
)=>
(
		{ 
	        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0()); 
	    }
		lv_operator_1_0=ruleOpUnary		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAUnaryOperationRule());
	        }
       		set(
       			$current, 
       			"operator",
        		lv_operator_1_0, 
        		"OpUnary");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperandAUnaryOperationParserRuleCall_0_2_0()); 
	    }
		lv_operand_2_0=ruleAUnaryOperation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAUnaryOperationRule());
	        }
       		set(
       			$current, 
       			"operand",
        		lv_operand_2_0, 
        		"AUnaryOperation");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |
    { 
        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getAUnitExpressionParserRuleCall_1()); 
    }
    this_AUnitExpression_3=ruleAUnitExpression
    { 
        $current = $this_AUnitExpression_3.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleOpUnary
entryRuleOpUnary returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getOpUnaryRule()); } 
	 iv_ruleOpUnary=ruleOpUnary 
	 { $current=$iv_ruleOpUnary.current.getText(); }  
	 EOF 
;

// Rule OpUnary
ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='not' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpUnaryAccess().getNotKeyword_0()); 
    }

    |
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
    }

    |
	kw='+' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
    }
)
    ;





// Entry rule entryRuleAUnitExpression
entryRuleAUnitExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAUnitExpressionRule()); }
	 iv_ruleAUnitExpression=ruleAUnitExpression 
	 { $current=$iv_ruleAUnitExpression.current; } 
	 EOF 
;

// Rule AUnitExpression
ruleAUnitExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getAUnitExpressionAccess().getAPrimaryExpressionParserRuleCall_0()); 
    }
    this_APrimaryExpression_0=ruleAPrimaryExpression
    { 
        $current = $this_APrimaryExpression_0.current; 
        afterParserOrEnumRuleCall();
    }
((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAUnitExpressionAccess().getAUnitExpressionExpressionAction_1_0(),
            $current);
    }
)((
(
		lv_convert_2_0=	'%' 
    {
        newLeafNode(lv_convert_2_0, grammarAccess.getAUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAUnitExpressionRule());
	        }
       		setWithLastConsumed($current, "convert", true, "\%");
	    }

)
)
    |(
(
		lv_drop_3_0=	'in' 
    {
        newLeafNode(lv_drop_3_0, grammarAccess.getAUnitExpressionAccess().getDropInKeyword_1_1_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAUnitExpressionRule());
	        }
       		setWithLastConsumed($current, "drop", true, "in");
	    }

)
))?(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAUnitExpressionRule());
	        }
        }
	otherlv_4=RULE_ID
	{
		newLeafNode(otherlv_4, grammarAccess.getAUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0()); 
	}

)
))?)
;





// Entry rule entryRuleAPrimaryExpression
entryRuleAPrimaryExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAPrimaryExpressionRule()); }
	 iv_ruleAPrimaryExpression=ruleAPrimaryExpression 
	 { $current=$iv_ruleAPrimaryExpression.current; } 
	 EOF 
;

// Rule APrimaryExpression
ruleAPrimaryExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getALiteralParserRuleCall_0()); 
    }
    this_ALiteral_0=ruleALiteral
    { 
        $current = $this_ALiteral_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAVariableReferenceParserRuleCall_1()); 
    }
    this_AVariableReference_1=ruleAVariableReference
    { 
        $current = $this_AVariableReference_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAModelOrPropertyReferenceParserRuleCall_2()); 
    }
    this_AModelOrPropertyReference_2=ruleAModelOrPropertyReference
    { 
        $current = $this_AModelOrPropertyReference_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAFunctionCallParserRuleCall_3()); 
    }
    this_AFunctionCall_3=ruleAFunctionCall
    { 
        $current = $this_AFunctionCall_3.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getARangeExpressionParserRuleCall_4()); 
    }
    this_ARangeExpression_4=ruleARangeExpression
    { 
        $current = $this_ARangeExpression_4.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAIfExpressionParserRuleCall_5()); 
    }
    this_AIfExpression_5=ruleAIfExpression
    { 
        $current = $this_AIfExpression_5.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAParenthesizedExpressionParserRuleCall_6()); 
    }
    this_AParenthesizedExpression_6=ruleAParenthesizedExpression
    { 
        $current = $this_AParenthesizedExpression_6.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleAFunctionCall
entryRuleAFunctionCall returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAFunctionCallRule()); }
	 iv_ruleAFunctionCall=ruleAFunctionCall 
	 { $current=$iv_ruleAFunctionCall.current; } 
	 EOF 
;

// Rule AFunctionCall
ruleAFunctionCall returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getAFunctionCallAccess().getAFunctionCallAction_0(),
            $current);
    }
)(
(
		lv_function_1_0=RULE_ID
		{
			newLeafNode(lv_function_1_0, grammarAccess.getAFunctionCallAccess().getFunctionIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAFunctionCallRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"function",
        		lv_function_1_0, 
        		"ID");
	    }

)
)	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAFunctionCallAccess().getLeftParenthesisKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_0()); 
	    }
		lv_arguments_3_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
	        }
       		add(
       			$current, 
       			"arguments",
        		lv_arguments_3_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getAFunctionCallAccess().getCommaKeyword_4_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_4_1_0()); 
	    }
		lv_arguments_5_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
	        }
       		add(
       			$current, 
       			"arguments",
        		lv_arguments_5_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_6=')' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getAFunctionCallAccess().getRightParenthesisKeyword_5());
    }
)
;





// Entry rule entryRuleARangeExpression
entryRuleARangeExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getARangeExpressionRule()); }
	 iv_ruleARangeExpression=ruleARangeExpression 
	 { $current=$iv_ruleARangeExpression.current; } 
	 EOF 
;

// Rule ARangeExpression
ruleARangeExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getARangeExpressionAccess().getARangeAction_0(),
            $current);
    }
)	otherlv_1='[' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getARangeExpressionAccess().getLeftSquareBracketKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getARangeExpressionAccess().getMinimumAExpressionParserRuleCall_2_0()); 
	    }
		lv_minimum_2_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getARangeExpressionRule());
	        }
       		set(
       			$current, 
       			"minimum",
        		lv_minimum_2_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='..' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getARangeExpressionAccess().getFullStopFullStopKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getARangeExpressionAccess().getMaximumAExpressionParserRuleCall_4_0()); 
	    }
		lv_maximum_4_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getARangeExpressionRule());
	        }
       		set(
       			$current, 
       			"maximum",
        		lv_maximum_4_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(((	'delta' 
)=>	otherlv_5='delta' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getARangeExpressionAccess().getDeltaKeyword_5_0());
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getARangeExpressionAccess().getDeltaAExpressionParserRuleCall_5_1_0()); 
	    }
		lv_delta_6_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getARangeExpressionRule());
	        }
       		set(
       			$current, 
       			"delta",
        		lv_delta_6_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_7=']' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getARangeExpressionAccess().getRightSquareBracketKeyword_6());
    }
)
;





// Entry rule entryRuleAIfExpression
entryRuleAIfExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAIfExpressionRule()); }
	 iv_ruleAIfExpression=ruleAIfExpression 
	 { $current=$iv_ruleAIfExpression.current; } 
	 EOF 
;

// Rule AIfExpression
ruleAIfExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getAIfExpressionAccess().getAConditionalAction_0(),
            $current);
    }
)	otherlv_1='if' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAIfExpressionAccess().getIfKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getIfAExpressionParserRuleCall_2_0()); 
	    }
		lv_if_2_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
	        }
       		set(
       			$current, 
       			"if",
        		lv_if_2_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='then' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getAIfExpressionAccess().getThenKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getThenAExpressionParserRuleCall_4_0()); 
	    }
		lv_then_4_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
	        }
       		set(
       			$current, 
       			"then",
        		lv_then_4_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5='else' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getAIfExpressionAccess().getElseKeyword_5_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getElseAExpressionParserRuleCall_5_1_0()); 
	    }
		lv_else_6_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
	        }
       		set(
       			$current, 
       			"else",
        		lv_else_6_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_7='endif' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getAIfExpressionAccess().getEndifKeyword_6());
    }
)
;





// Entry rule entryRuleALiteral
entryRuleALiteral returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getALiteralRule()); }
	 iv_ruleALiteral=ruleALiteral 
	 { $current=$iv_ruleALiteral.current; } 
	 EOF 
;

// Rule ALiteral
ruleALiteral returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getALiteralAccess().getABooleanLiteralParserRuleCall_0()); 
    }
    this_ABooleanLiteral_0=ruleABooleanLiteral
    { 
        $current = $this_ABooleanLiteral_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getALiteralAccess().getARealTermParserRuleCall_1()); 
    }
    this_ARealTerm_1=ruleARealTerm
    { 
        $current = $this_ARealTerm_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getALiteralAccess().getAIntegerTermParserRuleCall_2()); 
    }
    this_AIntegerTerm_2=ruleAIntegerTerm
    { 
        $current = $this_AIntegerTerm_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getALiteralAccess().getStringTermParserRuleCall_3()); 
    }
    this_StringTerm_3=ruleStringTerm
    { 
        $current = $this_StringTerm_3.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleAIntegerTerm
entryRuleAIntegerTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAIntegerTermRule()); }
	 iv_ruleAIntegerTerm=ruleAIntegerTerm 
	 { $current=$iv_ruleAIntegerTerm.current; } 
	 EOF 
;

// Rule AIntegerTerm
ruleAIntegerTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0()); 
	    }
		lv_value_0_0=ruleAInt		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAIntegerTermRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_0_0, 
        		"AInt");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleAInt
entryRuleAInt returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getAIntRule()); } 
	 iv_ruleAInt=ruleAInt 
	 { $current=$iv_ruleAInt.current.getText(); }  
	 EOF 
;

// Rule AInt
ruleAInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    { 
    newLeafNode(this_INT_0, grammarAccess.getAIntAccess().getINTTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleARealTerm
entryRuleARealTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getARealTermRule()); }
	 iv_ruleARealTerm=ruleARealTerm 
	 { $current=$iv_ruleARealTerm.current; } 
	 EOF 
;

// Rule ARealTerm
ruleARealTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0()); 
	    }
		lv_value_0_0=ruleAReal		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getARealTermRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_0_0, 
        		"AReal");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleAReal
entryRuleAReal returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getARealRule()); } 
	 iv_ruleAReal=ruleAReal 
	 { $current=$iv_ruleAReal.current.getText(); }  
	 EOF 
;

// Rule AReal
ruleAReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_REAL_LIT_0=RULE_REAL_LIT    {
		$current.merge(this_REAL_LIT_0);
    }

    { 
    newLeafNode(this_REAL_LIT_0, grammarAccess.getARealAccess().getREAL_LITTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleABooleanLiteral
entryRuleABooleanLiteral returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getABooleanLiteralRule()); }
	 iv_ruleABooleanLiteral=ruleABooleanLiteral 
	 { $current=$iv_ruleABooleanLiteral.current; } 
	 EOF 
;

// Rule ABooleanLiteral
ruleABooleanLiteral returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getABooleanLiteralAccess().getBooleanLiteralAction_0(),
            $current);
    }
)((
(
		lv_value_1_0=	'true' 
    {
        newLeafNode(lv_value_1_0, grammarAccess.getABooleanLiteralAccess().getValueTrueKeyword_1_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getABooleanLiteralRule());
	        }
       		setWithLastConsumed($current, "value", true, "true");
	    }

)
)
    |	otherlv_2='false' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getABooleanLiteralAccess().getFalseKeyword_1_1());
    }
))
;





// Entry rule entryRuleStringTerm
entryRuleStringTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getStringTermRule()); }
	 iv_ruleStringTerm=ruleStringTerm 
	 { $current=$iv_ruleStringTerm.current; } 
	 EOF 
;

// Rule StringTerm
ruleStringTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
	    }
		lv_value_0_0=ruleNoQuoteString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStringTermRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_0_0, 
        		"NoQuoteString");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleNoQuoteString
entryRuleNoQuoteString returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getNoQuoteStringRule()); } 
	 iv_ruleNoQuoteString=ruleNoQuoteString 
	 { $current=$iv_ruleNoQuoteString.current.getText(); }  
	 EOF 
;

// Rule NoQuoteString
ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_STRING_0=RULE_STRING    {
		$current.merge(this_STRING_0);
    }

    { 
    newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleAParenthesizedExpression
entryRuleAParenthesizedExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAParenthesizedExpressionRule()); }
	 iv_ruleAParenthesizedExpression=ruleAParenthesizedExpression 
	 { $current=$iv_ruleAParenthesizedExpression.current; } 
	 EOF 
;

// Rule AParenthesizedExpression
ruleAParenthesizedExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='(' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
    }

    { 
        newCompositeNode(grammarAccess.getAParenthesizedExpressionAccess().getAExpressionParserRuleCall_1()); 
    }
    this_AExpression_1=ruleAExpression
    { 
        $current = $this_AExpression_1.current; 
        afterParserOrEnumRuleCall();
    }
	otherlv_2=')' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
    }
)
;







// Entry rule entryRuleAadlClassifierReference
entryRuleAadlClassifierReference returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); } 
	 iv_ruleAadlClassifierReference=ruleAadlClassifierReference 
	 { $current=$iv_ruleAadlClassifierReference.current.getText(); }  
	 EOF 
;

// Rule AadlClassifierReference
ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw='::' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_1_0()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1_1()); 
    }
)+(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
    }
    this_ID_4=RULE_ID    {
		$current.merge(this_ID_4);
    }

    { 
    newLeafNode(this_ID_4, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_2_1()); 
    }
)?)
    ;





// Entry rule entryRuleAADLPROPERTYREFERENCE
entryRuleAADLPROPERTYREFERENCE returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getAADLPROPERTYREFERENCERule()); } 
	 iv_ruleAADLPROPERTYREFERENCE=ruleAADLPROPERTYREFERENCE 
	 { $current=$iv_ruleAADLPROPERTYREFERENCE.current.getText(); }  
	 EOF 
;

// Rule AADLPROPERTYREFERENCE
ruleAADLPROPERTYREFERENCE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw='::' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getAADLPROPERTYREFERENCEAccess().getColonColonKeyword_1_0()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_1_1()); 
    }
)?)
    ;







// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); } 
	 iv_ruleQualifiedName=ruleQualifiedName 
	 { $current=$iv_ruleQualifiedName.current.getText(); }  
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
    }
)*)
    ;





// Entry rule entryRuleThisKeyword
entryRuleThisKeyword returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getThisKeywordRule()); } 
	 iv_ruleThisKeyword=ruleThisKeyword 
	 { $current=$iv_ruleThisKeyword.current.getText(); }  
	 EOF 
;

// Rule ThisKeyword
ruleThisKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

	kw='this' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getThisKeywordAccess().getThisKeyword()); 
    }

    ;





// Rule ElseType
ruleElseType returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='ok' 
	{
        $current = grammarAccess.getElseTypeAccess().getOKEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getElseTypeAccess().getOKEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='fail' 
	{
        $current = grammarAccess.getElseTypeAccess().getFAILEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getElseTypeAccess().getFAILEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='timeout' 
	{
        $current = grammarAccess.getElseTypeAccess().getTIMEOUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getElseTypeAccess().getTIMEOUTEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='error' 
	{
        $current = grammarAccess.getElseTypeAccess().getERROREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getElseTypeAccess().getERROREnumLiteralDeclaration_3()); 
    }
));



// Rule VerificationResultState
ruleVerificationResultState returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='tbd' 
	{
        $current = grammarAccess.getVerificationResultStateAccess().getTBDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getVerificationResultStateAccess().getTBDEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='success' 
	{
        $current = grammarAccess.getVerificationResultStateAccess().getSUCCESSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getVerificationResultStateAccess().getSUCCESSEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='fail' 
	{
        $current = grammarAccess.getVerificationResultStateAccess().getFAILEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getVerificationResultStateAccess().getFAILEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='error' 
	{
        $current = grammarAccess.getVerificationResultStateAccess().getERROREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getVerificationResultStateAccess().getERROREnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='timeout' 
	{
        $current = grammarAccess.getVerificationResultStateAccess().getTIMEOUTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getVerificationResultStateAccess().getTIMEOUTEnumLiteralDeclaration_4()); 
    }
));



// Rule VerificationExecutionState
ruleVerificationExecutionState returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='todo' 
	{
        $current = grammarAccess.getVerificationExecutionStateAccess().getTODOEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getVerificationExecutionStateAccess().getTODOEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='running' 
	{
        $current = grammarAccess.getVerificationExecutionStateAccess().getRUNNINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getVerificationExecutionStateAccess().getRUNNINGEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='redo' 
	{
        $current = grammarAccess.getVerificationExecutionStateAccess().getREDOEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getVerificationExecutionStateAccess().getREDOEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='completed' 
	{
        $current = grammarAccess.getVerificationExecutionStateAccess().getCOMPLETEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getVerificationExecutionStateAccess().getCOMPLETEDEnumLiteralDeclaration_3()); 
    }
));



// Rule ResultIssueType
ruleResultIssueType returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='tbd' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='error' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='warning' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='info' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='success' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4()); 
    }
)
    |(	enumLiteral_5='fail' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_5()); 
    }
));





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


