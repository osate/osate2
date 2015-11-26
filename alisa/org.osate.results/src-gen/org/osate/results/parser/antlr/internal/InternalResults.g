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
    	return "ResultReports";	
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




// Entry rule entryRuleResultReports
entryRuleResultReports returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResultReportsRule()); }
	 iv_ruleResultReports=ruleResultReports 
	 { $current=$iv_ruleResultReports.current; } 
	 EOF 
;

// Rule ResultReports
ruleResultReports returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getResultReportsAccess().getResultReportParserRuleCall_0()); 
    }
    this_ResultReport_0=ruleResultReport
    { 
        $current = $this_ResultReport_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getResultReportsAccess().getResultReportCollectionParserRuleCall_1()); 
    }
    this_ResultReportCollection_1=ruleResultReportCollection
    { 
        $current = $this_ResultReportCollection_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getResultReportsAccess().getIssueReportParserRuleCall_2()); 
    }
    this_IssueReport_2=ruleIssueReport
    { 
        $current = $this_IssueReport_2.current; 
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
))?	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_3());
    }
	otherlv_5='target' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getResultReportCollectionAccess().getTargetKeyword_4());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportCollectionRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_5_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_7='description' 
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
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getResultReportAccess().getResultReportAction_0(),
            $current);
    }
)	otherlv_1='report' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getResultReportAccess().getReportKeyword_1());
    }
(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getResultReportAccess().getNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"ID");
	    }

)
)(	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getResultReportAccess().getColonKeyword_3_0());
    }
(
(
		lv_title_4_0=RULE_STRING
		{
			newLeafNode(lv_title_4_0, grammarAccess.getResultReportAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_4_0, 
        		"STRING");
	    }

)
))?(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getResultReportAccess().getTargetEObjectCrossReference_4_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getResultReportAccess().getIssueTypeResultIssueTypeEnumRuleCall_5_0()); 
	    }
		lv_issueType_6_0=ruleResultIssueType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultReportRule());
	        }
       		set(
       			$current, 
       			"issueType",
        		lv_issueType_6_0, 
        		"ResultIssueType");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_message_7_0=RULE_STRING
		{
			newLeafNode(lv_message_7_0, grammarAccess.getResultReportAccess().getMessageSTRINGTerminalRuleCall_6_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_7_0, 
        		"STRING");
	    }

)
)(	otherlv_8='exception' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getResultReportAccess().getExceptionKeyword_7_0());
    }
(
(
		lv_exceptionType_9_0=RULE_STRING
		{
			newLeafNode(lv_exceptionType_9_0, grammarAccess.getResultReportAccess().getExceptionTypeSTRINGTerminalRuleCall_7_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exceptionType",
        		lv_exceptionType_9_0, 
        		"STRING");
	    }

)
))?	otherlv_10='[' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getResultReportAccess().getLeftSquareBracketKeyword_8());
    }
(	otherlv_11='description' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getResultReportAccess().getDescriptionKeyword_9_0());
    }
(
(
		lv_decription_12_0=RULE_STRING
		{
			newLeafNode(lv_decription_12_0, grammarAccess.getResultReportAccess().getDecriptionSTRINGTerminalRuleCall_9_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"decription",
        		lv_decription_12_0, 
        		"STRING");
	    }

)
))?(	otherlv_13='heading' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getResultReportAccess().getHeadingKeyword_10_0());
    }
(
(
		lv_heading_14_0=RULE_STRING
		{
			newLeafNode(lv_heading_14_0, grammarAccess.getResultReportAccess().getHeadingSTRINGTerminalRuleCall_10_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"heading",
        		lv_heading_14_0, 
        		"STRING");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getResultReportAccess().getContentResultContributorParserRuleCall_10_2_0()); 
	    }
		lv_content_15_0=ruleResultContributor		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultReportRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_15_0, 
        		"ResultContributor");
	        afterParserOrEnumRuleCall();
	    }

)
)*)?(	otherlv_16='results' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getResultReportAccess().getResultsKeyword_11_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getResultReportAccess().getResultDataResultDataParserRuleCall_11_1_0()); 
	    }
		lv_resultData_17_0=ruleResultData		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultReportRule());
	        }
       		add(
       			$current, 
       			"resultData",
        		lv_resultData_17_0, 
        		"ResultData");
	        afterParserOrEnumRuleCall();
	    }

)
)+)?(
(
		{ 
	        newCompositeNode(grammarAccess.getResultReportAccess().getIssuesResultIssueParserRuleCall_12_0()); 
	    }
		lv_issues_18_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultReportRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_18_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_19=']' 
    {
    	newLeafNode(otherlv_19, grammarAccess.getResultReportAccess().getRightSquareBracketKeyword_13());
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
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getResultContributorAccess().getResultContributorAction_0(),
            $current);
    }
)	otherlv_1='contributor' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getResultContributorAccess().getContributorKeyword_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultContributorRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_2_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getResultContributorAccess().getIssueTypeResultIssueTypeEnumRuleCall_3_0()); 
	    }
		lv_issueType_3_0=ruleResultIssueType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultContributorRule());
	        }
       		set(
       			$current, 
       			"issueType",
        		lv_issueType_3_0, 
        		"ResultIssueType");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_message_4_0=RULE_STRING
		{
			newLeafNode(lv_message_4_0, grammarAccess.getResultContributorAccess().getMessageSTRINGTerminalRuleCall_4_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultContributorRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_4_0, 
        		"STRING");
	    }

)
)(	otherlv_5='exception' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getResultContributorAccess().getExceptionKeyword_5_0());
    }
(
(
		lv_exceptionType_6_0=RULE_STRING
		{
			newLeafNode(lv_exceptionType_6_0, grammarAccess.getResultContributorAccess().getExceptionTypeSTRINGTerminalRuleCall_5_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultContributorRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exceptionType",
        		lv_exceptionType_6_0, 
        		"STRING");
	    }

)
))?	otherlv_7='[' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_6());
    }
	otherlv_8='data' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getResultContributorAccess().getDataKeyword_7());
    }
(
(
		lv_cell_9_0=RULE_STRING
		{
			newLeafNode(lv_cell_9_0, grammarAccess.getResultContributorAccess().getCellSTRINGTerminalRuleCall_8_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultContributorRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"cell",
        		lv_cell_9_0, 
        		"STRING");
	    }

)
)+(
(
		{ 
	        newCompositeNode(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_9_0()); 
	    }
		lv_issues_10_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultContributorRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_10_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_10_0()); 
	    }
		lv_subcontributor_11_0=ruleResultContributor		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultContributorRule());
	        }
       		add(
       			$current, 
       			"subcontributor",
        		lv_subcontributor_11_0, 
        		"ResultContributor");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_12=']' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_11());
    }
)
;





// Entry rule entryRuleIssueReport
entryRuleIssueReport returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getIssueReportRule()); }
	 iv_ruleIssueReport=ruleIssueReport 
	 { $current=$iv_ruleIssueReport.current; } 
	 EOF 
;

// Rule IssueReport
ruleIssueReport returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getIssueReportAccess().getIssueReportAction_0(),
            $current);
    }
)	otherlv_1='issues' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getIssueReportAccess().getIssuesKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getIssueReportAccess().getIssueTypeResultIssueTypeEnumRuleCall_2_0()); 
	    }
		lv_issueType_2_0=ruleResultIssueType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIssueReportRule());
	        }
       		set(
       			$current, 
       			"issueType",
        		lv_issueType_2_0, 
        		"ResultIssueType");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_message_3_0=RULE_STRING
		{
			newLeafNode(lv_message_3_0, grammarAccess.getIssueReportAccess().getMessageSTRINGTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIssueReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_3_0, 
        		"STRING");
	    }

)
)(	otherlv_4='target' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getIssueReportAccess().getTargetKeyword_4_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getIssueReportRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getIssueReportAccess().getTargetEObjectCrossReference_4_1_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_6='exception' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getIssueReportAccess().getExceptionKeyword_5_0());
    }
(
(
		lv_exceptionType_7_0=RULE_STRING
		{
			newLeafNode(lv_exceptionType_7_0, grammarAccess.getIssueReportAccess().getExceptionTypeSTRINGTerminalRuleCall_5_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIssueReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exceptionType",
        		lv_exceptionType_7_0, 
        		"STRING");
	    }

)
))?(	otherlv_8='[' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getIssueReportAccess().getLeftSquareBracketKeyword_6_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getIssueReportAccess().getIssuesResultIssueParserRuleCall_6_1_0()); 
	    }
		lv_issues_9_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIssueReportRule());
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
    	newLeafNode(otherlv_10, grammarAccess.getIssueReportAccess().getRightSquareBracketKeyword_6_2());
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
((	enumLiteral_0='error' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='warning' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='info' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='success' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='fail' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_4()); 
    }
)
    |(	enumLiteral_5='unknown' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_5()); 
    }
));



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


