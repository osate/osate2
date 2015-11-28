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
)(	otherlv_2='plan' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAssuranceCaseResultAccess().getPlanKeyword_2_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceCaseResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseResultAccess().getPlanAssurancePlanCrossReference_2_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getAssuranceCaseResultAccess().getLeftSquareBracketKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseResultAccess().getMetricsMetricsParserRuleCall_4_0()); 
	    }
		lv_metrics_5_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceCaseResultRule());
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
    	newLeafNode(otherlv_6, grammarAccess.getAssuranceCaseResultAccess().getMessageKeyword_5_0());
    }
(
(
		lv_message_7_0=RULE_STRING
		{
			newLeafNode(lv_message_7_0, grammarAccess.getAssuranceCaseResultAccess().getMessageSTRINGTerminalRuleCall_5_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceCaseResultRule());
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
	        newCompositeNode(grammarAccess.getAssuranceCaseResultAccess().getModelResultModelResultParserRuleCall_6_0()); 
	    }
		lv_modelResult_8_0=ruleModelResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceCaseResultRule());
	        }
       		add(
       			$current, 
       			"modelResult",
        		lv_modelResult_8_0, 
        		"ModelResult");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_9=']' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getAssuranceCaseResultAccess().getRightSquareBracketKeyword_7());
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
	        newCompositeNode(grammarAccess.getModelResultAccess().getNameQualifiedNameParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelResultRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2='for' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getModelResultAccess().getForKeyword_2_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModelResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getModelResultAccess().getTargetComponentImplementationCrossReference_2_1_0()); 
	    }
		ruleAadlClassifierReference		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getModelResultAccess().getLeftSquareBracketKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getModelResultAccess().getMetricsMetricsParserRuleCall_4_0()); 
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
    	newLeafNode(otherlv_6, grammarAccess.getModelResultAccess().getMessageKeyword_5_0());
    }
(
(
		lv_message_7_0=RULE_STRING
		{
			newLeafNode(lv_message_7_0, grammarAccess.getModelResultAccess().getMessageSTRINGTerminalRuleCall_5_1_0()); 
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
	        newCompositeNode(grammarAccess.getModelResultAccess().getClaimResultClaimResultParserRuleCall_6_0()); 
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
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getModelResultAccess().getSubsystemResultSubsystemResultParserRuleCall_7_0()); 
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
)*(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModelResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getModelResultAccess().getSubAssuranceCaseAssuranceCaseResultCrossReference_8_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_11=']' 
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
	        newCompositeNode(grammarAccess.getSubsystemResultAccess().getNameQualifiedNameParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSubsystemResultRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='for' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getSubsystemResultAccess().getForKeyword_2());
    }
(
(
		lv_targetSystem_3_0=RULE_ID
		{
			newLeafNode(lv_targetSystem_3_0, grammarAccess.getSubsystemResultAccess().getTargetSystemIDTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSubsystemResultRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"targetSystem",
        		lv_targetSystem_3_0, 
        		"ID");
	    }

)
)	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getSubsystemResultAccess().getLeftSquareBracketKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSubsystemResultAccess().getMetricsMetricsParserRuleCall_5_0()); 
	    }
		lv_metrics_5_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSubsystemResultRule());
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
    	newLeafNode(otherlv_6, grammarAccess.getSubsystemResultAccess().getMessageKeyword_6_0());
    }
(
(
		lv_message_7_0=RULE_STRING
		{
			newLeafNode(lv_message_7_0, grammarAccess.getSubsystemResultAccess().getMessageSTRINGTerminalRuleCall_6_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSubsystemResultRule());
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
	        newCompositeNode(grammarAccess.getSubsystemResultAccess().getClaimResultClaimResultParserRuleCall_7_0()); 
	    }
		lv_claimResult_8_0=ruleClaimResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSubsystemResultRule());
	        }
       		add(
       			$current, 
       			"claimResult",
        		lv_claimResult_8_0, 
        		"ClaimResult");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getSubsystemResultAccess().getSubsystemResultSubsystemResultParserRuleCall_8_0()); 
	    }
		lv_subsystemResult_9_0=ruleSubsystemResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSubsystemResultRule());
	        }
       		add(
       			$current, 
       			"subsystemResult",
        		lv_subsystemResult_9_0, 
        		"SubsystemResult");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_10=']' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getSubsystemResultAccess().getRightSquareBracketKeyword_9());
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
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getClaimResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getClaimResultAccess().getTargetRequirementCrossReference_1_0()); 
	    }
		ruleQualifiedName		{ 
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
)(	otherlv_4='message' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getClaimResultAccess().getMessageKeyword_4_0());
    }
(
(
		lv_message_5_0=RULE_STRING
		{
			newLeafNode(lv_message_5_0, grammarAccess.getClaimResultAccess().getMessageSTRINGTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getClaimResultRule());
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
	        newCompositeNode(grammarAccess.getClaimResultAccess().getSubClaimResultClaimResultParserRuleCall_5_0()); 
	    }
		lv_subClaimResult_6_0=ruleClaimResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClaimResultRule());
	        }
       		add(
       			$current, 
       			"subClaimResult",
        		lv_subClaimResult_6_0, 
        		"ClaimResult");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getClaimResultAccess().getVerificationActivityResultVerificationExprParserRuleCall_6_0()); 
	    }
		lv_verificationActivityResult_7_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClaimResultRule());
	        }
       		add(
       			$current, 
       			"verificationActivityResult",
        		lv_verificationActivityResult_7_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_8=']' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getClaimResultAccess().getRightSquareBracketKeyword_7());
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
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationActivityResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getTargetVerificationActivityCrossReference_2_0()); 
	    }
		ruleQualifiedName		{ 
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
))?(	otherlv_19='weight' 
    {
    	newLeafNode(otherlv_19, grammarAccess.getMetricsAccess().getWeightKeyword_10_0());
    }
(
(
		lv_weight_20_0=RULE_INT
		{
			newLeafNode(lv_weight_20_0, grammarAccess.getMetricsAccess().getWeightINTTerminalRuleCall_10_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"weight",
        		lv_weight_20_0, 
        		"INT");
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
(	otherlv_0='issue' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getResultIssueAccess().getIssueKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_1_0()); 
	    }
		lv_issueType_1_0=ruleResultIssueType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultIssueRule());
	        }
       		set(
       			$current, 
       			"issueType",
        		lv_issueType_1_0, 
        		"ResultIssueType");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_message_2_0=RULE_STRING
		{
			newLeafNode(lv_message_2_0, grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultIssueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_2_0, 
        		"STRING");
	    }

)
)(	otherlv_3='target' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getResultIssueAccess().getTargetKeyword_3_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultIssueRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_3_1_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_5='exception' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getResultIssueAccess().getExceptionKeyword_4_0());
    }
(
(
		lv_exceptionType_6_0=RULE_STRING
		{
			newLeafNode(lv_exceptionType_6_0, grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultIssueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exceptionType",
        		lv_exceptionType_6_0, 
        		"STRING");
	    }

)
))?(	otherlv_7='[' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); 
	    }
		lv_issues_8_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultIssueRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_8_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_9=']' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2());
    }
)?)
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
)	otherlv_1='@' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAPropertyReferenceAccess().getCommercialAtKeyword_1());
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
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getShowValueRule());
	        }
        }
	otherlv_2=RULE_ID
	{
		newLeafNode(otherlv_2, grammarAccess.getShowValueAccess().getUnitUnitLiteralCrossReference_1_1_0()); 
	}

)
))?)
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
            grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getFeatureOpOrParserRuleCall_1_0_0_1_0()); 
	    }
		lv_feature_2_0=ruleOpOr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
	        }
       		set(
       			$current, 
       			"feature",
        		lv_feature_2_0, 
        		"OpOr");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getRightOperandAAndExpressionParserRuleCall_1_1_0()); 
	    }
		lv_rightOperand_3_0=ruleAAndExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
	        }
       		set(
       			$current, 
       			"rightOperand",
        		lv_rightOperand_3_0, 
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

	kw='||' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); 
    }

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
            grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getFeatureOpAndParserRuleCall_1_0_0_1_0()); 
	    }
		lv_feature_2_0=ruleOpAnd		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
	        }
       		set(
       			$current, 
       			"feature",
        		lv_feature_2_0, 
        		"OpAnd");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getRightOperandAEqualityExpressionParserRuleCall_1_1_0()); 
	    }
		lv_rightOperand_3_0=ruleAEqualityExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
	        }
       		set(
       			$current, 
       			"rightOperand",
        		lv_rightOperand_3_0, 
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

	kw='&&' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); 
    }

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
            grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getFeatureOpEqualityParserRuleCall_1_0_0_1_0()); 
	    }
		lv_feature_2_0=ruleOpEquality		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAEqualityExpressionRule());
	        }
       		set(
       			$current, 
       			"feature",
        		lv_feature_2_0, 
        		"OpEquality");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getRightOperandARelationalExpressionParserRuleCall_1_1_0()); 
	    }
		lv_rightOperand_3_0=ruleARelationalExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAEqualityExpressionRule());
	        }
       		set(
       			$current, 
       			"rightOperand",
        		lv_rightOperand_3_0, 
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
        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getAOtherOperatorExpressionParserRuleCall_0()); 
    }
    this_AOtherOperatorExpression_0=ruleAOtherOperatorExpression
    { 
        $current = $this_AOtherOperatorExpression_0.current; 
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
            grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getFeatureOpCompareParserRuleCall_1_0_0_1_0()); 
	    }
		lv_feature_2_0=ruleOpCompare		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
	        }
       		set(
       			$current, 
       			"feature",
        		lv_feature_2_0, 
        		"OpCompare");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getRightOperandAOtherOperatorExpressionParserRuleCall_1_1_0()); 
	    }
		lv_rightOperand_3_0=ruleAOtherOperatorExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
	        }
       		set(
       			$current, 
       			"rightOperand",
        		lv_rightOperand_3_0, 
        		"AOtherOperatorExpression");
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

    |(
	kw='<' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0()); 
    }

	kw='=' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1()); 
    }
)
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
)
    ;





// Entry rule entryRuleAOtherOperatorExpression
entryRuleAOtherOperatorExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAOtherOperatorExpressionRule()); }
	 iv_ruleAOtherOperatorExpression=ruleAOtherOperatorExpression 
	 { $current=$iv_ruleAOtherOperatorExpression.current; } 
	 EOF 
;

// Rule AOtherOperatorExpression
ruleAOtherOperatorExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getAOtherOperatorExpressionAccess().getAAdditiveExpressionParserRuleCall_0()); 
    }
    this_AAdditiveExpression_0=ruleAAdditiveExpression
    { 
        $current = $this_AAdditiveExpression_0.current; 
        afterParserOrEnumRuleCall();
    }
(((((
)(
(
ruleOpOther
)
)))=>((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAOtherOperatorExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAOtherOperatorExpressionAccess().getFeatureOpOtherParserRuleCall_1_0_0_1_0()); 
	    }
		lv_feature_2_0=ruleOpOther		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAOtherOperatorExpressionRule());
	        }
       		set(
       			$current, 
       			"feature",
        		lv_feature_2_0, 
        		"OpOther");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getAOtherOperatorExpressionAccess().getRightOperandAAdditiveExpressionParserRuleCall_1_1_0()); 
	    }
		lv_rightOperand_3_0=ruleAAdditiveExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAOtherOperatorExpressionRule());
	        }
       		set(
       			$current, 
       			"rightOperand",
        		lv_rightOperand_3_0, 
        		"AAdditiveExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleOpOther
entryRuleOpOther returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getOpOtherRule()); } 
	 iv_ruleOpOther=ruleOpOther 
	 { $current=$iv_ruleOpOther.current.getText(); }  
	 EOF 
;

// Rule OpOther
ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='->' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
    }

    |
	kw='..<' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1()); 
    }

    |(
	kw='>' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0()); 
    }

	kw='..' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1()); 
    }
)
    |
	kw='..' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3()); 
    }

    |
	kw='=>' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4()); 
    }

    |(
	kw='>' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0()); 
    }
((((
	'>' 

	'>' 
))=>(
	kw='>' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0()); 
    }

	kw='>' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1()); 
    }
))
    |
	kw='>' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1()); 
    }
))
    |(
	kw='<' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0()); 
    }
((((
	'<' 

	'<' 
))=>(
	kw='<' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0()); 
    }

	kw='<' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1()); 
    }
))
    |
	kw='<' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1()); 
    }

    |
	kw='=>' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2()); 
    }
))
    |
	kw='<>' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7()); 
    }

    |
	kw='?:' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_8()); 
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
            grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getFeatureOpAddParserRuleCall_1_0_0_1_0()); 
	    }
		lv_feature_2_0=ruleOpAdd		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
	        }
       		set(
       			$current, 
       			"feature",
        		lv_feature_2_0, 
        		"OpAdd");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getRightOperandAMultiplicativeExpressionParserRuleCall_1_1_0()); 
	    }
		lv_rightOperand_3_0=ruleAMultiplicativeExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
	        }
       		set(
       			$current, 
       			"rightOperand",
        		lv_rightOperand_3_0, 
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
            grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getFeatureOpMultiParserRuleCall_1_0_0_1_0()); 
	    }
		lv_feature_2_0=ruleOpMulti		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
	        }
       		set(
       			$current, 
       			"feature",
        		lv_feature_2_0, 
        		"OpMulti");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getRightOperandAUnaryOperationParserRuleCall_1_1_0()); 
	    }
		lv_rightOperand_3_0=ruleAUnaryOperation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
	        }
       		set(
       			$current, 
       			"rightOperand",
        		lv_rightOperand_3_0, 
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
	kw='**' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
    }

    |
	kw='/' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
    }

    |
	kw='%' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3()); 
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
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getFeatureOpUnaryParserRuleCall_0_1_0()); 
	    }
		lv_feature_1_0=ruleOpUnary		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAUnaryOperationRule());
	        }
       		set(
       			$current, 
       			"feature",
        		lv_feature_1_0, 
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
        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getAPrimaryExpressionParserRuleCall_1()); 
    }
    this_APrimaryExpression_3=ruleAPrimaryExpression
    { 
        $current = $this_APrimaryExpression_3.current; 
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
	kw='!' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
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
        newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAPropertyReferenceParserRuleCall_2()); 
    }
    this_APropertyReference_2=ruleAPropertyReference
    { 
        $current = $this_APropertyReference_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAParenthesizedExpressionParserRuleCall_3()); 
    }
    this_AParenthesizedExpression_3=ruleAParenthesizedExpression
    { 
        $current = $this_AParenthesizedExpression_3.current; 
        afterParserOrEnumRuleCall();
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
        newCompositeNode(grammarAccess.getALiteralAccess().getASetTermParserRuleCall_0()); 
    }
    this_ASetTerm_0=ruleASetTerm
    { 
        $current = $this_ASetTerm_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getALiteralAccess().getAListTermParserRuleCall_1()); 
    }
    this_AListTerm_1=ruleAListTerm
    { 
        $current = $this_AListTerm_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getALiteralAccess().getABooleanLiteralParserRuleCall_2()); 
    }
    this_ABooleanLiteral_2=ruleABooleanLiteral
    { 
        $current = $this_ABooleanLiteral_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getALiteralAccess().getARealTermParserRuleCall_3()); 
    }
    this_ARealTerm_3=ruleARealTerm
    { 
        $current = $this_ARealTerm_3.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getALiteralAccess().getAIntegerTermParserRuleCall_4()); 
    }
    this_AIntegerTerm_4=ruleAIntegerTerm
    { 
        $current = $this_AIntegerTerm_4.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getALiteralAccess().getANullLiteralParserRuleCall_5()); 
    }
    this_ANullLiteral_5=ruleANullLiteral
    { 
        $current = $this_ANullLiteral_5.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getALiteralAccess().getStringTermParserRuleCall_6()); 
    }
    this_StringTerm_6=ruleStringTerm
    { 
        $current = $this_StringTerm_6.current; 
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
((
(
		{ 
	        newCompositeNode(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0_0()); 
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
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAIntegerTermRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getAIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
	}

)
)?)
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
((
(
		{ 
	        newCompositeNode(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0_0()); 
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
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getARealTermRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getARealTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
	}

)
)?)
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







// Entry rule entryRuleNumAlt
entryRuleNumAlt returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNumAltRule()); }
	 iv_ruleNumAlt=ruleNumAlt 
	 { $current=$iv_ruleNumAlt.current; } 
	 EOF 
;

// Rule NumAlt
ruleNumAlt returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getNumAltAccess().getARealTermParserRuleCall_0()); 
    }
    this_ARealTerm_0=ruleARealTerm
    { 
        $current = $this_ARealTerm_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getNumAltAccess().getAIntegerTermParserRuleCall_1()); 
    }
    this_AIntegerTerm_1=ruleAIntegerTerm
    { 
        $current = $this_AIntegerTerm_1.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleASetTerm
entryRuleASetTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getASetTermRule()); }
	 iv_ruleASetTerm=ruleASetTerm 
	 { $current=$iv_ruleASetTerm.current; } 
	 EOF 
;

// Rule ASetTerm
ruleASetTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getASetTermAccess().getASetLiteralAction_0(),
            $current);
    }
)	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getASetTermAccess().getLeftCurlyBracketKeyword_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getASetTermAccess().getElementsAExpressionParserRuleCall_2_0_0()); 
	    }
		lv_elements_2_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getASetTermRule());
	        }
       		add(
       			$current, 
       			"elements",
        		lv_elements_2_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getASetTermAccess().getCommaKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getASetTermAccess().getElementsAExpressionParserRuleCall_2_1_1_0()); 
	    }
		lv_elements_4_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getASetTermRule());
	        }
       		add(
       			$current, 
       			"elements",
        		lv_elements_4_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getASetTermAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleAListTerm
entryRuleAListTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAListTermRule()); }
	 iv_ruleAListTerm=ruleAListTerm 
	 { $current=$iv_ruleAListTerm.current; } 
	 EOF 
;

// Rule AListTerm
ruleAListTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getAListTermAccess().getAListTermAction_0(),
            $current);
    }
)	otherlv_1='#' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAListTermAccess().getNumberSignKeyword_1());
    }
	otherlv_2='[' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAListTermAccess().getLeftSquareBracketKeyword_2());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getAListTermAccess().getElementsAExpressionParserRuleCall_3_0_0()); 
	    }
		lv_elements_3_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAListTermRule());
	        }
       		add(
       			$current, 
       			"elements",
        		lv_elements_3_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getAListTermAccess().getCommaKeyword_3_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAListTermAccess().getElementsAExpressionParserRuleCall_3_1_1_0()); 
	    }
		lv_elements_5_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAListTermRule());
	        }
       		add(
       			$current, 
       			"elements",
        		lv_elements_5_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_6=']' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getAListTermAccess().getRightSquareBracketKeyword_4());
    }
)
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





// Entry rule entryRuleANullLiteral
entryRuleANullLiteral returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getANullLiteralRule()); }
	 iv_ruleANullLiteral=ruleANullLiteral 
	 { $current=$iv_ruleANullLiteral.current; } 
	 EOF 
;

// Rule ANullLiteral
ruleANullLiteral returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getANullLiteralAccess().getANullLiteralAction_0(),
            $current);
    }
)	otherlv_1='null' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getANullLiteralAccess().getNullKeyword_1());
    }
)
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





// Entry rule entryRuleURIID
entryRuleURIID returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getURIIDRule()); } 
	 iv_ruleURIID=ruleURIID 
	 { $current=$iv_ruleURIID.current.getText(); }  
	 EOF 
;

// Rule URIID
ruleURIID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_STRING_0=RULE_STRING    {
		$current.merge(this_STRING_0);
    }

    { 
    newLeafNode(this_STRING_0, grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); 
    }

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
    |(	enumLiteral_1='unknown' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='error' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='warning' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='info' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_4()); 
    }
)
    |(	enumLiteral_5='success' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_5()); 
    }
)
    |(	enumLiteral_6='fail' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_6, grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_6()); 
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


