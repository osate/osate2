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
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.osate.results.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.osate.results.parser.antlr.internal; 

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
import org.osate.results.services.ResultsGrammarAccess;

}

@parser::members {

 	private ResultsGrammarAccess grammarAccess;
 	
    public InternalResultsParser(TokenStream input, ResultsGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "ResultReport";	
   	}
   	
   	@Override
   	protected ResultsGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleResultReport
entryRuleResultReport returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResultReportRule()); }
	 iv_ruleResultReport=ruleResultReport 
	 { $current=$iv_ruleResultReport.current; } 
	 EOF 
;

// Rule ResultReport
ruleResultReport returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getResultReportAccess().getResultDataReportParserRuleCall_0()); 
    }
    this_ResultDataReport_0=ruleResultDataReport
    { 
        $current = $this_ResultDataReport_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getResultReportAccess().getResultReportCollectionParserRuleCall_1()); 
    }
    this_ResultReportCollection_1=ruleResultReportCollection
    { 
        $current = $this_ResultReportCollection_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getResultReportAccess().getIssuesReportParserRuleCall_2()); 
    }
    this_IssuesReport_2=ruleIssuesReport
    { 
        $current = $this_IssuesReport_2.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleResultReportCollection
entryRuleResultReportCollection returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResultReportCollectionRule()); }
	 iv_ruleResultReportCollection=ruleResultReportCollection 
	 { $current=$iv_ruleResultReportCollection.current; } 
	 EOF 
;

// Rule ResultReportCollection
ruleResultReportCollection returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='reports' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportCollectionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0());
    }
(
(
		lv_title_3_0=RULE_STRING
		{
			newLeafNode(lv_title_3_0, grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportCollectionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_3_0, 
        		"STRING");
	    }

)
))?	otherlv_4='for' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getResultReportCollectionAccess().getForKeyword_3());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportCollectionRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_4_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_6='[' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_5());
    }
(	otherlv_7='description' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0());
    }
(
(
		lv_decription_8_0=RULE_STRING
		{
			newLeafNode(lv_decription_8_0, grammarAccess.getResultReportCollectionAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportCollectionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"decription",
        		lv_decription_8_0, 
        		"STRING");
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); 
	    }
		lv_content_9_0=ruleResultReport		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultReportCollectionRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_9_0, 
        		"ResultReport");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getIssuesResultIssueParserRuleCall_8_0()); 
	    }
		lv_issues_10_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultReportCollectionRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_10_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_11=']' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9());
    }
)
;





// Entry rule entryRuleResultDataReport
entryRuleResultDataReport returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResultDataReportRule()); }
	 iv_ruleResultDataReport=ruleResultDataReport 
	 { $current=$iv_ruleResultDataReport.current; } 
	 EOF 
;

// Rule ResultDataReport
ruleResultDataReport returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='report' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getResultDataReportAccess().getReportKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getResultDataReportAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultDataReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getResultDataReportAccess().getColonKeyword_2_0());
    }
(
(
		lv_title_3_0=RULE_STRING
		{
			newLeafNode(lv_title_3_0, grammarAccess.getResultDataReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultDataReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_3_0, 
        		"STRING");
	    }

)
))?	otherlv_4='for' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getResultDataReportAccess().getForKeyword_3());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultDataReportRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getResultDataReportAccess().getTargetEObjectCrossReference_4_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_6='[' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getResultDataReportAccess().getLeftSquareBracketKeyword_5());
    }
(	otherlv_7='description' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getResultDataReportAccess().getDescriptionKeyword_6_0());
    }
(
(
		lv_decription_8_0=RULE_STRING
		{
			newLeafNode(lv_decription_8_0, grammarAccess.getResultDataReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultDataReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"decription",
        		lv_decription_8_0, 
        		"STRING");
	    }

)
))?(	otherlv_9='heading' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getResultDataReportAccess().getHeadingKeyword_7_0());
    }
(
(
		lv_heading_10_0=RULE_STRING
		{
			newLeafNode(lv_heading_10_0, grammarAccess.getResultDataReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultDataReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"heading",
        		lv_heading_10_0, 
        		"STRING");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getResultDataReportAccess().getContentResultContributorParserRuleCall_7_2_0()); 
	    }
		lv_content_11_0=ruleResultContributor		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultDataReportRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_11_0, 
        		"ResultContributor");
	        afterParserOrEnumRuleCall();
	    }

)
)*)?(	otherlv_12='results' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getResultDataReportAccess().getResultsKeyword_8_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getResultDataReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); 
	    }
		lv_resultData_13_0=ruleResultData		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultDataReportRule());
	        }
       		add(
       			$current, 
       			"resultData",
        		lv_resultData_13_0, 
        		"ResultData");
	        afterParserOrEnumRuleCall();
	    }

)
)+)?(
(
		{ 
	        newCompositeNode(grammarAccess.getResultDataReportAccess().getIssuesResultIssueParserRuleCall_9_0()); 
	    }
		lv_issues_14_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultDataReportRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_14_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_15=']' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getResultDataReportAccess().getRightSquareBracketKeyword_10());
    }
)
;





// Entry rule entryRuleResultContributor
entryRuleResultContributor returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResultContributorRule()); }
	 iv_ruleResultContributor=ruleResultContributor 
	 { $current=$iv_ruleResultContributor.current; } 
	 EOF 
;

// Rule ResultContributor
ruleResultContributor returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='contributor' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getResultContributorAccess().getContributorKeyword_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultContributorRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_1_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='[' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_2());
    }
(	otherlv_3='results' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getResultContributorAccess().getResultsKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getResultContributorAccess().getResultDataResultDataParserRuleCall_3_1_0()); 
	    }
		lv_resultData_4_0=ruleResultData		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultContributorRule());
	        }
       		add(
       			$current, 
       			"resultData",
        		lv_resultData_4_0, 
        		"ResultData");
	        afterParserOrEnumRuleCall();
	    }

)
)+)?(
(
		{ 
	        newCompositeNode(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_4_0()); 
	    }
		lv_issues_5_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultContributorRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_5_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_5_0()); 
	    }
		lv_subcontributor_6_0=ruleResultContributor		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultContributorRule());
	        }
       		add(
       			$current, 
       			"subcontributor",
        		lv_subcontributor_6_0, 
        		"ResultContributor");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_7=']' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_6());
    }
)
;





// Entry rule entryRuleIssuesReport
entryRuleIssuesReport returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getIssuesReportRule()); }
	 iv_ruleIssuesReport=ruleIssuesReport 
	 { $current=$iv_ruleIssuesReport.current; } 
	 EOF 
;

// Rule IssuesReport
ruleIssuesReport returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='issues' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getIssuesReportAccess().getIssuesKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getIssuesReportAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIssuesReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(	otherlv_2='for' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getIssuesReportAccess().getForKeyword_2_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getIssuesReportRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_2_1_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3_0());
    }
(	otherlv_5='description' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getIssuesReportAccess().getDescriptionKeyword_3_1_0());
    }
(
(
		lv_description_6_0=RULE_STRING
		{
			newLeafNode(lv_description_6_0, grammarAccess.getIssuesReportAccess().getDescriptionSTRINGTerminalRuleCall_3_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIssuesReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"description",
        		lv_description_6_0, 
        		"STRING");
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getIssuesReportAccess().getIssuesResultIssueParserRuleCall_3_2_0()); 
	    }
		lv_issues_7_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIssuesReportRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_7_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_8=']' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_3_3());
    }
)?)
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





// Entry rule entryRuleResultData
entryRuleResultData returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResultDataRule()); }
	 iv_ruleResultData=ruleResultData 
	 { $current=$iv_ruleResultData.current; } 
	 EOF 
;

// Rule ResultData
ruleResultData returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultDataRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID");
	    }

)
)	otherlv_1='=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getResultDataAccess().getEqualsSignKeyword_1());
    }
(
(
		lv_value_2_0=RULE_STRING
		{
			newLeafNode(lv_value_2_0, grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultDataRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_2_0, 
        		"STRING");
	    }

)
))
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



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


