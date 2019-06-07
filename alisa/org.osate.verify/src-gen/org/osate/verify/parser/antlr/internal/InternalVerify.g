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
grammar InternalVerify;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.osate.verify.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.osate.verify.parser.antlr.internal; 

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
import org.osate.verify.services.VerifyGrammarAccess;

}

@parser::members {

 	private VerifyGrammarAccess grammarAccess;
 	
    public InternalVerifyParser(TokenStream input, VerifyGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Verification";	
   	}
   	
   	@Override
   	protected VerifyGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleVerification
entryRuleVerification returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVerificationRule()); }
	 iv_ruleVerification=ruleVerification 
	 { $current=$iv_ruleVerification.current; } 
	 EOF 
;

// Rule Verification
ruleVerification returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationAccess().getContentsVerificationPlanParserRuleCall_0_0()); 
	    }
		lv_contents_0_1=ruleVerificationPlan		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationRule());
	        }
       		add(
       			$current, 
       			"contents",
        		lv_contents_0_1, 
        		"org.osate.verify.Verify.VerificationPlan");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getVerificationAccess().getContentsVerificationMethodRegistryParserRuleCall_0_1()); 
	    }
		lv_contents_0_2=ruleVerificationMethodRegistry		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationRule());
	        }
       		add(
       			$current, 
       			"contents",
        		lv_contents_0_2, 
        		"org.osate.verify.Verify.VerificationMethodRegistry");
	        afterParserOrEnumRuleCall();
	    }

)

)
)+
;





// Entry rule entryRuleVerificationPlan
entryRuleVerificationPlan returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVerificationPlanRule()); }
	 iv_ruleVerificationPlan=ruleVerificationPlan 
	 { $current=$iv_ruleVerificationPlan.current; } 
	 EOF 
;

// Rule VerificationPlan
ruleVerificationPlan returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='verification' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVerificationPlanAccess().getVerificationKeyword_0());
    }
	otherlv_1='plan' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getVerificationPlanAccess().getPlanKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationPlanAccess().getNameQualifiedNameParserRuleCall_2_0()); 
	    }
		lv_name_2_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationPlanRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"org.osate.alisa.common.Common.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getVerificationPlanAccess().getColonKeyword_3_0());
    }
(
(
		lv_title_4_0=RULE_STRING
		{
			newLeafNode(lv_title_4_0, grammarAccess.getVerificationPlanAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationPlanRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_4_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))?	otherlv_5='for' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getVerificationPlanAccess().getForKeyword_4());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationPlanRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getVerificationPlanAccess().getRequirementSetRequirementSetCrossReference_5_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7='[' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getVerificationPlanAccess().getLeftSquareBracketKeyword_6());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7(), 0);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationPlanAccess().getDescriptionDescriptionParserRuleCall_7_0_0()); 
	    }
		lv_description_9_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationPlanRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_9_0, 
        		"org.osate.alisa.common.Common.Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7(), 1);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationPlanAccess().getClaimClaimParserRuleCall_7_1_0()); 
	    }
		lv_claim_10_0=ruleClaim		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationPlanRule());
	        }
       		add(
       			$current, 
       			"claim",
        		lv_claim_10_0, 
        		"org.osate.verify.Verify.Claim");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationPlanAccess().getRationaleRationaleParserRuleCall_7_2_0()); 
	    }
		lv_rationale_11_0=ruleRationale		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationPlanRule());
	        }
       		set(
       			$current, 
       			"rationale",
        		lv_rationale_11_0, 
        		"org.osate.alisa.common.Common.Rationale");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7(), 3);
	 				}
					({true}?=>(	otherlv_12='issues' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getVerificationPlanAccess().getIssuesKeyword_7_3_0());
    }
(
(
		lv_issues_13_0=RULE_STRING
		{
			newLeafNode(lv_issues_13_0, grammarAccess.getVerificationPlanAccess().getIssuesSTRINGTerminalRuleCall_7_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationPlanRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_13_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7());
	}

)	otherlv_14=']' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getVerificationPlanAccess().getRightSquareBracketKeyword_8());
    }
)
;





// Entry rule entryRuleClaim
entryRuleClaim returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getClaimRule()); }
	 iv_ruleClaim=ruleClaim 
	 { $current=$iv_ruleClaim.current; } 
	 EOF 
;

// Rule Claim
ruleClaim returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getClaimAccess().getClaimAction_0(),
            $current);
    }
)	otherlv_1='claim' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getClaimAccess().getClaimKeyword_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getClaimRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getClaimAccess().getRequirementRequirementCrossReference_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)?(	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getClaimAccess().getColonKeyword_3_0());
    }
(
(
		lv_title_4_0=RULE_STRING
		{
			newLeafNode(lv_title_4_0, grammarAccess.getClaimAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getClaimRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_4_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))?	otherlv_5='[' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getClaimAccess().getLeftSquareBracketKeyword_4());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getClaimAccess().getUnorderedGroup_5());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getClaimAccess().getUnorderedGroup_5(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getClaimAccess().getUnorderedGroup_5(), 0);
	 				}
					({true}?=>(	otherlv_7='activities' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getClaimAccess().getActivitiesKeyword_5_0_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getClaimAccess().getActivitiesVerificationActivityParserRuleCall_5_0_1_0()); 
	    }
		lv_activities_8_0=ruleVerificationActivity		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClaimRule());
	        }
       		add(
       			$current, 
       			"activities",
        		lv_activities_8_0, 
        		"org.osate.verify.Verify.VerificationActivity");
	        afterParserOrEnumRuleCall();
	    }

)
)*))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClaimAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getClaimAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getClaimAccess().getUnorderedGroup_5(), 1);
	 				}
					({true}?=>(	otherlv_9='assert' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getClaimAccess().getAssertKeyword_5_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getClaimAccess().getAssertArgumentExprParserRuleCall_5_1_1_0()); 
	    }
		lv_assert_10_0=ruleArgumentExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClaimRule());
	        }
       		set(
       			$current, 
       			"assert",
        		lv_assert_10_0, 
        		"org.osate.verify.Verify.ArgumentExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClaimAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getClaimAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getClaimAccess().getUnorderedGroup_5(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getClaimAccess().getRationaleRationaleParserRuleCall_5_2_0()); 
	    }
		lv_rationale_11_0=ruleRationale		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClaimRule());
	        }
       		set(
       			$current, 
       			"rationale",
        		lv_rationale_11_0, 
        		"org.osate.alisa.common.Common.Rationale");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClaimAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getClaimAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getClaimAccess().getUnorderedGroup_5(), 3);
	 				}
					({true}?=>(	otherlv_12='weight' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getClaimAccess().getWeightKeyword_5_3_0());
    }
(
(
		lv_weight_13_0=RULE_INT
		{
			newLeafNode(lv_weight_13_0, grammarAccess.getClaimAccess().getWeightINTTerminalRuleCall_5_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getClaimRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"weight",
        		lv_weight_13_0, 
        		"org.eclipse.xtext.common.Terminals.INT");
	    }

)
)))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClaimAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getClaimAccess().getUnorderedGroup_5(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getClaimAccess().getUnorderedGroup_5(), 4);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getClaimAccess().getSubclaimClaimParserRuleCall_5_4_0()); 
	    }
		lv_subclaim_14_0=ruleClaim		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClaimRule());
	        }
       		add(
       			$current, 
       			"subclaim",
        		lv_subclaim_14_0, 
        		"org.osate.verify.Verify.Claim");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClaimAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getClaimAccess().getUnorderedGroup_5(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getClaimAccess().getUnorderedGroup_5(), 5);
	 				}
					({true}?=>(	otherlv_15='issues' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getClaimAccess().getIssuesKeyword_5_5_0());
    }
(
(
		lv_issues_16_0=RULE_STRING
		{
			newLeafNode(lv_issues_16_0, grammarAccess.getClaimAccess().getIssuesSTRINGTerminalRuleCall_5_5_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getClaimRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_16_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClaimAccess().getUnorderedGroup_5());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getClaimAccess().getUnorderedGroup_5());
	}

)	otherlv_17=']' 
    {
    	newLeafNode(otherlv_17, grammarAccess.getClaimAccess().getRightSquareBracketKeyword_6());
    }
)
;





// Entry rule entryRuleArgumentExpr
entryRuleArgumentExpr returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getArgumentExprRule()); }
	 iv_ruleArgumentExpr=ruleArgumentExpr 
	 { $current=$iv_ruleArgumentExpr.current; } 
	 EOF 
;

// Rule ArgumentExpr
ruleArgumentExpr returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

    { 
        newCompositeNode(grammarAccess.getArgumentExprAccess().getThenEvidenceExprParserRuleCall()); 
    }
    this_ThenEvidenceExpr_0=ruleThenEvidenceExpr
    { 
        $current = $this_ThenEvidenceExpr_0.current; 
        afterParserOrEnumRuleCall();
    }

;





// Entry rule entryRuleThenEvidenceExpr
entryRuleThenEvidenceExpr returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getThenEvidenceExprRule()); }
	 iv_ruleThenEvidenceExpr=ruleThenEvidenceExpr 
	 { $current=$iv_ruleThenEvidenceExpr.current; } 
	 EOF 
;

// Rule ThenEvidenceExpr
ruleThenEvidenceExpr returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getThenEvidenceExprAccess().getElseEvidenceExprParserRuleCall_0()); 
    }
    this_ElseEvidenceExpr_0=ruleElseEvidenceExpr
    { 
        $current = $this_ElseEvidenceExpr_0.current; 
        afterParserOrEnumRuleCall();
    }
(((((
)	'then' 
))=>((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getThenEvidenceExprAccess().getThenExprLeftAction_1_0_0_0(),
            $current);
    }
)	otherlv_2='then' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getThenEvidenceExprAccess().getThenKeyword_1_0_0_1());
    }
))(
(
		{ 
	        newCompositeNode(grammarAccess.getThenEvidenceExprAccess().getSuccessorThenEvidenceExprParserRuleCall_1_1_0()); 
	    }
		lv_successor_3_0=ruleThenEvidenceExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getThenEvidenceExprRule());
	        }
       		set(
       			$current, 
       			"successor",
        		lv_successor_3_0, 
        		"org.osate.verify.Verify.ThenEvidenceExpr");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleElseEvidenceExpr
entryRuleElseEvidenceExpr returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getElseEvidenceExprRule()); }
	 iv_ruleElseEvidenceExpr=ruleElseEvidenceExpr 
	 { $current=$iv_ruleElseEvidenceExpr.current; } 
	 EOF 
;

// Rule ElseEvidenceExpr
ruleElseEvidenceExpr returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getElseEvidenceExprAccess().getSingleElseEvidenceExprParserRuleCall_0()); 
    }
    this_SingleElseEvidenceExpr_0=ruleSingleElseEvidenceExpr
    { 
        $current = $this_SingleElseEvidenceExpr_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getElseEvidenceExprAccess().getCompositeElseEvidenceExprParserRuleCall_1()); 
    }
    this_CompositeElseEvidenceExpr_1=ruleCompositeElseEvidenceExpr
    { 
        $current = $this_CompositeElseEvidenceExpr_1.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleSingleElseEvidenceExpr
entryRuleSingleElseEvidenceExpr returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSingleElseEvidenceExprRule()); }
	 iv_ruleSingleElseEvidenceExpr=ruleSingleElseEvidenceExpr 
	 { $current=$iv_ruleSingleElseEvidenceExpr.current; } 
	 EOF 
;

// Rule SingleElseEvidenceExpr
ruleSingleElseEvidenceExpr returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getSingleElseEvidenceExprAccess().getVAReferenceParserRuleCall_0()); 
    }
    this_VAReference_0=ruleVAReference
    { 
        $current = $this_VAReference_0.current; 
        afterParserOrEnumRuleCall();
    }
(((((
)	'else' 
))=>((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getSingleElseEvidenceExprAccess().getElseExprLeftAction_1_0_0_0(),
            $current);
    }
)	otherlv_2='else' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getSingleElseEvidenceExprAccess().getElseKeyword_1_0_0_1());
    }
))((
(
		{ 
	        newCompositeNode(grammarAccess.getSingleElseEvidenceExprAccess().getErrorElseEvidenceExprParserRuleCall_1_1_0_0()); 
	    }
		lv_error_3_0=ruleElseEvidenceExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSingleElseEvidenceExprRule());
	        }
       		set(
       			$current, 
       			"error",
        		lv_error_3_0, 
        		"org.osate.verify.Verify.ElseEvidenceExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getSingleElseEvidenceExprAccess().getLeftSquareBracketKeyword_1_1_1_0());
    }
(	otherlv_5='fail' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getSingleElseEvidenceExprAccess().getFailKeyword_1_1_1_1_0());
    }
	otherlv_6=':' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getSingleElseEvidenceExprAccess().getColonKeyword_1_1_1_1_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSingleElseEvidenceExprAccess().getFailThenEvidenceExprParserRuleCall_1_1_1_1_2_0()); 
	    }
		lv_fail_7_0=ruleThenEvidenceExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSingleElseEvidenceExprRule());
	        }
       		set(
       			$current, 
       			"fail",
        		lv_fail_7_0, 
        		"org.osate.verify.Verify.ThenEvidenceExpr");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_8='timeout' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getSingleElseEvidenceExprAccess().getTimeoutKeyword_1_1_1_2_0());
    }
	otherlv_9=':' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getSingleElseEvidenceExprAccess().getColonKeyword_1_1_1_2_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSingleElseEvidenceExprAccess().getTimeoutThenEvidenceExprParserRuleCall_1_1_1_2_2_0()); 
	    }
		lv_timeout_10_0=ruleThenEvidenceExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSingleElseEvidenceExprRule());
	        }
       		set(
       			$current, 
       			"timeout",
        		lv_timeout_10_0, 
        		"org.osate.verify.Verify.ThenEvidenceExpr");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_11='error' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getSingleElseEvidenceExprAccess().getErrorKeyword_1_1_1_3_0());
    }
	otherlv_12=':' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getSingleElseEvidenceExprAccess().getColonKeyword_1_1_1_3_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSingleElseEvidenceExprAccess().getErrorThenEvidenceExprParserRuleCall_1_1_1_3_2_0()); 
	    }
		lv_error_13_0=ruleThenEvidenceExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSingleElseEvidenceExprRule());
	        }
       		set(
       			$current, 
       			"error",
        		lv_error_13_0, 
        		"org.osate.verify.Verify.ThenEvidenceExpr");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_14=']' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getSingleElseEvidenceExprAccess().getRightSquareBracketKeyword_1_1_1_4());
    }
)))*)
;





// Entry rule entryRuleCompositeElseEvidenceExpr
entryRuleCompositeElseEvidenceExpr returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCompositeElseEvidenceExprRule()); }
	 iv_ruleCompositeElseEvidenceExpr=ruleCompositeElseEvidenceExpr 
	 { $current=$iv_ruleCompositeElseEvidenceExpr.current; } 
	 EOF 
;

// Rule CompositeElseEvidenceExpr
ruleCompositeElseEvidenceExpr returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getCompositeElseEvidenceExprAccess().getCompositeEvidenceExprParserRuleCall_0()); 
    }
    this_CompositeEvidenceExpr_0=ruleCompositeEvidenceExpr
    { 
        $current = $this_CompositeEvidenceExpr_0.current; 
        afterParserOrEnumRuleCall();
    }
(((((
)	'else' 
))=>((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getCompositeElseEvidenceExprAccess().getElseExprLeftAction_1_0_0_0(),
            $current);
    }
)	otherlv_2='else' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getCompositeElseEvidenceExprAccess().getElseKeyword_1_0_0_1());
    }
))(
(
		{ 
	        newCompositeNode(grammarAccess.getCompositeElseEvidenceExprAccess().getErrorElseEvidenceExprParserRuleCall_1_1_0()); 
	    }
		lv_error_3_0=ruleElseEvidenceExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCompositeElseEvidenceExprRule());
	        }
       		set(
       			$current, 
       			"error",
        		lv_error_3_0, 
        		"org.osate.verify.Verify.ElseEvidenceExpr");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleQuantifiedEvidenceExpr
entryRuleQuantifiedEvidenceExpr returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getQuantifiedEvidenceExprRule()); }
	 iv_ruleQuantifiedEvidenceExpr=ruleQuantifiedEvidenceExpr 
	 { $current=$iv_ruleQuantifiedEvidenceExpr.current; } 
	 EOF 
;

// Rule QuantifiedEvidenceExpr
ruleQuantifiedEvidenceExpr returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='all' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getQuantifiedEvidenceExprAccess().getAllKeyword_0());
    }
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getQuantifiedEvidenceExprAccess().getAllExprAction_1(),
            $current);
    }
)	otherlv_2='[' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getQuantifiedEvidenceExprAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getQuantifiedEvidenceExprAccess().getElementsThenEvidenceExprParserRuleCall_3_0()); 
	    }
		lv_elements_3_0=ruleThenEvidenceExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQuantifiedEvidenceExprRule());
	        }
       		add(
       			$current, 
       			"elements",
        		lv_elements_3_0, 
        		"org.osate.verify.Verify.ThenEvidenceExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getQuantifiedEvidenceExprAccess().getCommaKeyword_4_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getQuantifiedEvidenceExprAccess().getElementsThenEvidenceExprParserRuleCall_4_1_0()); 
	    }
		lv_elements_5_0=ruleThenEvidenceExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQuantifiedEvidenceExprRule());
	        }
       		add(
       			$current, 
       			"elements",
        		lv_elements_5_0, 
        		"org.osate.verify.Verify.ThenEvidenceExpr");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_6=']' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getQuantifiedEvidenceExprAccess().getRightSquareBracketKeyword_5());
    }
)
;





// Entry rule entryRuleCompositeEvidenceExpr
entryRuleCompositeEvidenceExpr returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCompositeEvidenceExprRule()); }
	 iv_ruleCompositeEvidenceExpr=ruleCompositeEvidenceExpr 
	 { $current=$iv_ruleCompositeEvidenceExpr.current; } 
	 EOF 
;

// Rule CompositeEvidenceExpr
ruleCompositeEvidenceExpr returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='(' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getCompositeEvidenceExprAccess().getLeftParenthesisKeyword_0_0());
    }

    { 
        newCompositeNode(grammarAccess.getCompositeEvidenceExprAccess().getThenEvidenceExprParserRuleCall_0_1()); 
    }
    this_ThenEvidenceExpr_1=ruleThenEvidenceExpr
    { 
        $current = $this_ThenEvidenceExpr_1.current; 
        afterParserOrEnumRuleCall();
    }
	otherlv_2=')' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getCompositeEvidenceExprAccess().getRightParenthesisKeyword_0_2());
    }
)
    |
    { 
        newCompositeNode(grammarAccess.getCompositeEvidenceExprAccess().getQuantifiedEvidenceExprParserRuleCall_1()); 
    }
    this_QuantifiedEvidenceExpr_3=ruleQuantifiedEvidenceExpr
    { 
        $current = $this_QuantifiedEvidenceExpr_3.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleVAReference
entryRuleVAReference returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVAReferenceRule()); }
	 iv_ruleVAReference=ruleVAReference 
	 { $current=$iv_ruleVAReference.current; } 
	 EOF 
;

// Rule VAReference
ruleVAReference returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getVAReferenceAccess().getRefExprAction_0(),
            $current);
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVAReferenceRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getVAReferenceAccess().getVerificationVerificationActivityCrossReference_1_0()); 
	}

)
))
;





// Entry rule entryRuleComputeRef
entryRuleComputeRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getComputeRefRule()); }
	 iv_ruleComputeRef=ruleComputeRef 
	 { $current=$iv_ruleComputeRef.current; } 
	 EOF 
;

// Rule ComputeRef
ruleComputeRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getComputeRefRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getComputeRefAccess().getComputeComputeDeclarationCrossReference_0()); 
	}

)
)
;





// Entry rule entryRuleVerificationActivity
entryRuleVerificationActivity returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVerificationActivityRule()); }
	 iv_ruleVerificationActivity=ruleVerificationActivity 
	 { $current=$iv_ruleVerificationActivity.current; } 
	 EOF 
;

// Rule VerificationActivity
ruleVerificationActivity returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getVerificationActivityAccess().getNameIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationActivityRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)(	otherlv_1=':' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getVerificationActivityAccess().getColonKeyword_1_0());
    }
(
(
		lv_title_2_0=RULE_STRING
		{
			newLeafNode(lv_title_2_0, grammarAccess.getVerificationActivityAccess().getTitleSTRINGTerminalRuleCall_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationActivityRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_2_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))?	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getVerificationActivityAccess().getColonKeyword_2());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityAccess().getComputesComputeRefParserRuleCall_3_0_0()); 
	    }
		lv_computes_4_0=ruleComputeRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityRule());
	        }
       		add(
       			$current, 
       			"computes",
        		lv_computes_4_0, 
        		"org.osate.verify.Verify.ComputeRef");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getVerificationActivityAccess().getCommaKeyword_3_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityAccess().getComputesComputeRefParserRuleCall_3_1_1_0()); 
	    }
		lv_computes_6_0=ruleComputeRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityRule());
	        }
       		add(
       			$current, 
       			"computes",
        		lv_computes_6_0, 
        		"org.osate.verify.Verify.ComputeRef");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_7='=' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getVerificationActivityAccess().getEqualsSignKeyword_3_2());
    }
)?(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationActivityRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityAccess().getMethodVerificationMethodCrossReference_4_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_9='(' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getVerificationActivityAccess().getLeftParenthesisKeyword_5());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityAccess().getActualsAExpressionParserRuleCall_6_0_0()); 
	    }
		lv_actuals_10_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityRule());
	        }
       		add(
       			$current, 
       			"actuals",
        		lv_actuals_10_0, 
        		"org.osate.alisa.common.Common.AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_11=',' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getVerificationActivityAccess().getCommaKeyword_6_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityAccess().getActualsAExpressionParserRuleCall_6_1_1_0()); 
	    }
		lv_actuals_12_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityRule());
	        }
       		add(
       			$current, 
       			"actuals",
        		lv_actuals_12_0, 
        		"org.osate.alisa.common.Common.AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_13=')' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getVerificationActivityAccess().getRightParenthesisKeyword_7());
    }
(	otherlv_14='property' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getVerificationActivityAccess().getPropertyKeyword_8_0());
    }
	otherlv_15='values' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getVerificationActivityAccess().getValuesKeyword_8_1());
    }
	otherlv_16='(' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getVerificationActivityAccess().getLeftParenthesisKeyword_8_2());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityAccess().getPropertyValuesAExpressionParserRuleCall_8_3_0_0()); 
	    }
		lv_propertyValues_17_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityRule());
	        }
       		add(
       			$current, 
       			"propertyValues",
        		lv_propertyValues_17_0, 
        		"org.osate.alisa.common.Common.AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_18=',' 
    {
    	newLeafNode(otherlv_18, grammarAccess.getVerificationActivityAccess().getCommaKeyword_8_3_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityAccess().getPropertyValuesAExpressionParserRuleCall_8_3_1_1_0()); 
	    }
		lv_propertyValues_19_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityRule());
	        }
       		add(
       			$current, 
       			"propertyValues",
        		lv_propertyValues_19_0, 
        		"org.osate.alisa.common.Common.AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_20=')' 
    {
    	newLeafNode(otherlv_20, grammarAccess.getVerificationActivityAccess().getRightParenthesisKeyword_8_4());
    }
)?(	otherlv_21='[' 
    {
    	newLeafNode(otherlv_21, grammarAccess.getVerificationActivityAccess().getLeftSquareBracketKeyword_9_0());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getVerificationActivityAccess().getUnorderedGroup_9_1());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationActivityAccess().getUnorderedGroup_9_1(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationActivityAccess().getUnorderedGroup_9_1(), 0);
	 				}
					({true}?=>(	otherlv_23='category' 
    {
    	newLeafNode(otherlv_23, grammarAccess.getVerificationActivityAccess().getCategoryKeyword_9_1_0_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationActivityRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityAccess().getCategoryCategoryCrossReference_9_1_0_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationActivityAccess().getUnorderedGroup_9_1());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationActivityAccess().getUnorderedGroup_9_1(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationActivityAccess().getUnorderedGroup_9_1(), 1);
	 				}
					({true}?=>(	otherlv_25='timeout' 
    {
    	newLeafNode(otherlv_25, grammarAccess.getVerificationActivityAccess().getTimeoutKeyword_9_1_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityAccess().getTimeoutAIntegerTermParserRuleCall_9_1_1_1_0()); 
	    }
		lv_timeout_26_0=ruleAIntegerTerm		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityRule());
	        }
       		set(
       			$current, 
       			"timeout",
        		lv_timeout_26_0, 
        		"org.osate.alisa.common.Common.AIntegerTerm");
	        afterParserOrEnumRuleCall();
	    }

)
)))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationActivityAccess().getUnorderedGroup_9_1());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationActivityAccess().getUnorderedGroup_9_1(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationActivityAccess().getUnorderedGroup_9_1(), 2);
	 				}
					({true}?=>(	otherlv_27='weight' 
    {
    	newLeafNode(otherlv_27, grammarAccess.getVerificationActivityAccess().getWeightKeyword_9_1_2_0());
    }
(
(
		lv_weight_28_0=RULE_INT
		{
			newLeafNode(lv_weight_28_0, grammarAccess.getVerificationActivityAccess().getWeightINTTerminalRuleCall_9_1_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationActivityRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"weight",
        		lv_weight_28_0, 
        		"org.eclipse.xtext.common.Terminals.INT");
	    }

)
)))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationActivityAccess().getUnorderedGroup_9_1());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getVerificationActivityAccess().getUnorderedGroup_9_1());
	}

)	otherlv_29=']' 
    {
    	newLeafNode(otherlv_29, grammarAccess.getVerificationActivityAccess().getRightSquareBracketKeyword_9_2());
    }
)?)
;





// Entry rule entryRuleVerificationValidation
entryRuleVerificationValidation returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVerificationValidationRule()); }
	 iv_ruleVerificationValidation=ruleVerificationValidation 
	 { $current=$iv_ruleVerificationValidation.current; } 
	 EOF 
;

// Rule VerificationValidation
ruleVerificationValidation returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='validation' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVerificationValidationAccess().getValidationKeyword_0());
    }
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getVerificationValidationAccess().getVerificationValidationAction_1(),
            $current);
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationValidationRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getVerificationValidationAccess().getMethodVerificationMethodCrossReference_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='(' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getVerificationValidationAccess().getLeftParenthesisKeyword_3());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationValidationRule());
	        }
        }
	otherlv_4=RULE_ID
	{
		newLeafNode(otherlv_4, grammarAccess.getVerificationValidationAccess().getParametersFormalParameterCrossReference_4_0_0()); 
	}

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getVerificationValidationAccess().getCommaKeyword_4_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationValidationRule());
	        }
        }
	otherlv_6=RULE_ID
	{
		newLeafNode(otherlv_6, grammarAccess.getVerificationValidationAccess().getParametersFormalParameterCrossReference_4_1_1_0()); 
	}

)
))*)?	otherlv_7=')' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getVerificationValidationAccess().getRightParenthesisKeyword_5());
    }
)
;





// Entry rule entryRuleVerificationPrecondition
entryRuleVerificationPrecondition returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVerificationPreconditionRule()); }
	 iv_ruleVerificationPrecondition=ruleVerificationPrecondition 
	 { $current=$iv_ruleVerificationPrecondition.current; } 
	 EOF 
;

// Rule VerificationPrecondition
ruleVerificationPrecondition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='precondition' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVerificationPreconditionAccess().getPreconditionKeyword_0());
    }
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getVerificationPreconditionAccess().getVerificationPreconditionAction_1(),
            $current);
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationPreconditionRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getVerificationPreconditionAccess().getMethodVerificationMethodCrossReference_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='(' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getVerificationPreconditionAccess().getLeftParenthesisKeyword_3());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationPreconditionRule());
	        }
        }
	otherlv_4=RULE_ID
	{
		newLeafNode(otherlv_4, grammarAccess.getVerificationPreconditionAccess().getParametersFormalParameterCrossReference_4_0_0()); 
	}

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getVerificationPreconditionAccess().getCommaKeyword_4_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationPreconditionRule());
	        }
        }
	otherlv_6=RULE_ID
	{
		newLeafNode(otherlv_6, grammarAccess.getVerificationPreconditionAccess().getParametersFormalParameterCrossReference_4_1_1_0()); 
	}

)
))*)?	otherlv_7=')' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getVerificationPreconditionAccess().getRightParenthesisKeyword_5());
    }
)
;





// Entry rule entryRuleVerificationMethodRegistry
entryRuleVerificationMethodRegistry returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVerificationMethodRegistryRule()); }
	 iv_ruleVerificationMethodRegistry=ruleVerificationMethodRegistry 
	 { $current=$iv_ruleVerificationMethodRegistry.current; } 
	 EOF 
;

// Rule VerificationMethodRegistry
ruleVerificationMethodRegistry returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='verification' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVerificationMethodRegistryAccess().getVerificationKeyword_0());
    }
	otherlv_1='methods' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getVerificationMethodRegistryAccess().getMethodsKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodRegistryAccess().getNameQualifiedNameParserRuleCall_2_0()); 
	    }
		lv_name_2_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRegistryRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"org.osate.alisa.common.Common.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getVerificationMethodRegistryAccess().getColonKeyword_3_0());
    }
(
(
		lv_title_4_0=RULE_STRING
		{
			newLeafNode(lv_title_4_0, grammarAccess.getVerificationMethodRegistryAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationMethodRegistryRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_4_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))?	otherlv_5='[' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getVerificationMethodRegistryAccess().getLeftSquareBracketKeyword_4());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodRegistryAccess().getDescriptionDescriptionParserRuleCall_5_0_0()); 
	    }
		lv_description_6_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRegistryRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_6_0, 
        		"org.osate.alisa.common.Common.Description");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodRegistryAccess().getMethodsVerificationMethodParserRuleCall_5_1_0()); 
	    }
		lv_methods_7_0=ruleVerificationMethod		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRegistryRule());
	        }
       		add(
       			$current, 
       			"methods",
        		lv_methods_7_0, 
        		"org.osate.verify.Verify.VerificationMethod");
	        afterParserOrEnumRuleCall();
	    }

)
)*)	otherlv_8=']' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getVerificationMethodRegistryAccess().getRightSquareBracketKeyword_6());
    }
)
;





// Entry rule entryRuleFormalParameter
entryRuleFormalParameter returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFormalParameterRule()); }
	 iv_ruleFormalParameter=ruleFormalParameter 
	 { $current=$iv_ruleFormalParameter.current; } 
	 EOF 
;

// Rule FormalParameter
ruleFormalParameter returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getFormalParameterAccess().getNameIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFormalParameterRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)	otherlv_1=':' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getFormalParameterAccess().getColonKeyword_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getFormalParameterAccess().getTypeTypeRefParserRuleCall_2_0_0()); 
	    }
		lv_type_2_0=ruleTypeRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFormalParameterRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_2_0, 
        		"org.osate.alisa.common.Common.TypeRef");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(	otherlv_3='typeof' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getFormalParameterAccess().getTypeofKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFormalParameterAccess().getTypePropertyRefParserRuleCall_2_1_1_0()); 
	    }
		lv_type_4_0=rulePropertyRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFormalParameterRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_4_0, 
        		"org.osate.alisa.common.Common.PropertyRef");
	        afterParserOrEnumRuleCall();
	    }

)
)))(	otherlv_5='in' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getFormalParameterAccess().getInKeyword_3_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFormalParameterRule());
	        }
        }
	otherlv_6=RULE_ID
	{
		newLeafNode(otherlv_6, grammarAccess.getFormalParameterAccess().getUnitUnitLiteralCrossReference_3_1_0()); 
	}

)
))?)
;





// Entry rule entryRuleVerificationMethod
entryRuleVerificationMethod returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVerificationMethodRule()); }
	 iv_ruleVerificationMethod=ruleVerificationMethod 
	 { $current=$iv_ruleVerificationMethod.current; } 
	 EOF 
;

// Rule VerificationMethod
ruleVerificationMethod returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='method' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVerificationMethodAccess().getMethodKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getVerificationMethodAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationMethodRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)(	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getVerificationMethodAccess().getLeftParenthesisKeyword_2_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getTargetTypeTargetTypeEnumRuleCall_2_1_0_0()); 
	    }
		lv_targetType_3_0=ruleTargetType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRule());
	        }
       		set(
       			$current, 
       			"targetType",
        		lv_targetType_3_0, 
        		"org.osate.alisa.common.Common.TargetType");
	        afterParserOrEnumRuleCall();
	    }

)
)?
    |((
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getFormalsFormalParameterParserRuleCall_2_1_1_0_0()); 
	    }
		lv_formals_4_0=ruleFormalParameter		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRule());
	        }
       		add(
       			$current, 
       			"formals",
        		lv_formals_4_0, 
        		"org.osate.verify.Verify.FormalParameter");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getVerificationMethodAccess().getCommaKeyword_2_1_1_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getFormalsFormalParameterParserRuleCall_2_1_1_1_1_0()); 
	    }
		lv_formals_6_0=ruleFormalParameter		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRule());
	        }
       		add(
       			$current, 
       			"formals",
        		lv_formals_6_0, 
        		"org.osate.verify.Verify.FormalParameter");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
    |((
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getTargetTypeTargetTypeEnumRuleCall_2_1_2_0_0()); 
	    }
		lv_targetType_7_0=ruleTargetType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRule());
	        }
       		set(
       			$current, 
       			"targetType",
        		lv_targetType_7_0, 
        		"org.osate.alisa.common.Common.TargetType");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_8=',' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getVerificationMethodAccess().getCommaKeyword_2_1_2_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getFormalsFormalParameterParserRuleCall_2_1_2_2_0()); 
	    }
		lv_formals_9_0=ruleFormalParameter		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRule());
	        }
       		add(
       			$current, 
       			"formals",
        		lv_formals_9_0, 
        		"org.osate.verify.Verify.FormalParameter");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_10=',' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getVerificationMethodAccess().getCommaKeyword_2_1_2_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getFormalsFormalParameterParserRuleCall_2_1_2_3_1_0()); 
	    }
		lv_formals_11_0=ruleFormalParameter		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRule());
	        }
       		add(
       			$current, 
       			"formals",
        		lv_formals_11_0, 
        		"org.osate.verify.Verify.FormalParameter");
	        afterParserOrEnumRuleCall();
	    }

)
))*))	otherlv_12=')' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getVerificationMethodAccess().getRightParenthesisKeyword_2_2());
    }
(	otherlv_13='properties' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getVerificationMethodAccess().getPropertiesKeyword_2_3_0());
    }
	otherlv_14='(' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getVerificationMethodAccess().getLeftParenthesisKeyword_2_3_1());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationMethodRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getPropertiesPropertyCrossReference_2_3_2_0_0()); 
	    }
		ruleAADLPROPERTYREFERENCE		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_16=',' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getVerificationMethodAccess().getCommaKeyword_2_3_2_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationMethodRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getPropertiesPropertyCrossReference_2_3_2_1_1_0()); 
	    }
		ruleAADLPROPERTYREFERENCE		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_18=')' 
    {
    	newLeafNode(otherlv_18, grammarAccess.getVerificationMethodAccess().getRightParenthesisKeyword_2_3_3());
    }
)?(	otherlv_19='returns' 
    {
    	newLeafNode(otherlv_19, grammarAccess.getVerificationMethodAccess().getReturnsKeyword_2_4_0());
    }
	otherlv_20='(' 
    {
    	newLeafNode(otherlv_20, grammarAccess.getVerificationMethodAccess().getLeftParenthesisKeyword_2_4_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getResultsFormalParameterParserRuleCall_2_4_2_0_0()); 
	    }
		lv_results_21_0=ruleFormalParameter		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRule());
	        }
       		add(
       			$current, 
       			"results",
        		lv_results_21_0, 
        		"org.osate.verify.Verify.FormalParameter");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_22=',' 
    {
    	newLeafNode(otherlv_22, grammarAccess.getVerificationMethodAccess().getCommaKeyword_2_4_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getResultsFormalParameterParserRuleCall_2_4_2_1_1_0()); 
	    }
		lv_results_23_0=ruleFormalParameter		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRule());
	        }
       		add(
       			$current, 
       			"results",
        		lv_results_23_0, 
        		"org.osate.verify.Verify.FormalParameter");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_24=')' 
    {
    	newLeafNode(otherlv_24, grammarAccess.getVerificationMethodAccess().getRightParenthesisKeyword_2_4_3());
    }
)?((
(
		lv_isPredicate_25_0=	'boolean' 
    {
        newLeafNode(lv_isPredicate_25_0, grammarAccess.getVerificationMethodAccess().getIsPredicateBooleanKeyword_2_5_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationMethodRule());
	        }
       		setWithLastConsumed($current, "isPredicate", true, "boolean");
	    }

)
)
    |(
(
		lv_isResultReport_26_0=	'report' 
    {
        newLeafNode(lv_isResultReport_26_0, grammarAccess.getVerificationMethodAccess().getIsResultReportReportKeyword_2_5_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationMethodRule());
	        }
       		setWithLastConsumed($current, "isResultReport", true, "report");
	    }

)
))?)?(	otherlv_27=':' 
    {
    	newLeafNode(otherlv_27, grammarAccess.getVerificationMethodAccess().getColonKeyword_3_0());
    }
(
(
		lv_title_28_0=RULE_STRING
		{
			newLeafNode(lv_title_28_0, grammarAccess.getVerificationMethodAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationMethodRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_28_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))?(	otherlv_29='for' 
    {
    	newLeafNode(otherlv_29, grammarAccess.getVerificationMethodAccess().getForKeyword_4_0());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationMethodRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getTargetComponentClassifierCrossReference_4_1_0_0()); 
	    }
		ruleAadlClassifierReference		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getComponentCategoryComponentCategoryParserRuleCall_4_1_1_0()); 
	    }
		lv_componentCategory_31_0=ruleComponentCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRule());
	        }
       		add(
       			$current, 
       			"componentCategory",
        		lv_componentCategory_31_0, 
        		"org.osate.alisa.common.Common.ComponentCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+))?	otherlv_32='[' 
    {
    	newLeafNode(otherlv_32, grammarAccess.getVerificationMethodAccess().getLeftSquareBracketKeyword_5());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6(), 0);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getMethodKindMethodKindParserRuleCall_6_0_0()); 
	    }
		lv_methodKind_34_0=ruleMethodKind		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRule());
	        }
       		set(
       			$current, 
       			"methodKind",
        		lv_methodKind_34_0, 
        		"org.osate.verify.Verify.MethodKind");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6(), 1);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getDescriptionDescriptionParserRuleCall_6_1_0()); 
	    }
		lv_description_35_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_35_0, 
        		"org.osate.alisa.common.Common.Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getPreconditionVerificationPreconditionParserRuleCall_6_2_0()); 
	    }
		lv_precondition_36_0=ruleVerificationPrecondition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRule());
	        }
       		set(
       			$current, 
       			"precondition",
        		lv_precondition_36_0, 
        		"org.osate.verify.Verify.VerificationPrecondition");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6(), 3);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getValidationVerificationValidationParserRuleCall_6_3_0()); 
	    }
		lv_validation_37_0=ruleVerificationValidation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationMethodRule());
	        }
       		set(
       			$current, 
       			"validation",
        		lv_validation_37_0, 
        		"org.osate.verify.Verify.VerificationValidation");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6(), 4);
	 				}
					({true}?=>(	otherlv_38='category' 
    {
    	newLeafNode(otherlv_38, grammarAccess.getVerificationMethodAccess().getCategoryKeyword_6_4_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationMethodRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getVerificationMethodAccess().getCategoryCategoryCrossReference_6_4_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6());
	 				}
 				)
			)  

		)+
	  	{getUnorderedGroupHelper().canLeave(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6())}?	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6());
	}

)	otherlv_40=']' 
    {
    	newLeafNode(otherlv_40, grammarAccess.getVerificationMethodAccess().getRightSquareBracketKeyword_7());
    }
)
;





// Entry rule entryRuleMethodKind
entryRuleMethodKind returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMethodKindRule()); }
	 iv_ruleMethodKind=ruleMethodKind 
	 { $current=$iv_ruleMethodKind.current; } 
	 EOF 
;

// Rule MethodKind
ruleMethodKind returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getMethodKindAccess().getResoluteMethodParserRuleCall_0()); 
    }
    this_ResoluteMethod_0=ruleResoluteMethod
    { 
        $current = $this_ResoluteMethod_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getMethodKindAccess().getJavaMethodParserRuleCall_1()); 
    }
    this_JavaMethod_1=ruleJavaMethod
    { 
        $current = $this_JavaMethod_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getMethodKindAccess().getManualMethodParserRuleCall_2()); 
    }
    this_ManualMethod_2=ruleManualMethod
    { 
        $current = $this_ManualMethod_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getMethodKindAccess().getPluginMethodParserRuleCall_3()); 
    }
    this_PluginMethod_3=rulePluginMethod
    { 
        $current = $this_PluginMethod_3.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getMethodKindAccess().getAgreeMethodParserRuleCall_4()); 
    }
    this_AgreeMethod_4=ruleAgreeMethod
    { 
        $current = $this_AgreeMethod_4.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getMethodKindAccess().getJUnit4MethodParserRuleCall_5()); 
    }
    this_JUnit4Method_5=ruleJUnit4Method
    { 
        $current = $this_JUnit4Method_5.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getMethodKindAccess().getPythonMethodParserRuleCall_6()); 
    }
    this_PythonMethod_6=rulePythonMethod
    { 
        $current = $this_PythonMethod_6.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleResoluteMethod
entryRuleResoluteMethod returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResoluteMethodRule()); }
	 iv_ruleResoluteMethod=ruleResoluteMethod 
	 { $current=$iv_ruleResoluteMethod.current; } 
	 EOF 
;

// Rule ResoluteMethod
ruleResoluteMethod returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='resolute' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getResoluteMethodAccess().getResoluteKeyword_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getResoluteMethodRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getResoluteMethodAccess().getMethodReferenceEObjectCrossReference_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleJavaMethod
entryRuleJavaMethod returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getJavaMethodRule()); }
	 iv_ruleJavaMethod=ruleJavaMethod 
	 { $current=$iv_ruleJavaMethod.current; } 
	 EOF 
;

// Rule JavaMethod
ruleJavaMethod returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='java' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getJavaMethodAccess().getJavaKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getJavaMethodAccess().getMethodPathQualifiedNameParserRuleCall_1_0()); 
	    }
		lv_methodPath_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getJavaMethodRule());
	        }
       		set(
       			$current, 
       			"methodPath",
        		lv_methodPath_1_0, 
        		"org.osate.alisa.common.Common.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getJavaMethodAccess().getLeftParenthesisKeyword_2_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getJavaMethodAccess().getParamsJavaParameterParserRuleCall_2_1_0_0()); 
	    }
		lv_params_3_0=ruleJavaParameter		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getJavaMethodRule());
	        }
       		add(
       			$current, 
       			"params",
        		lv_params_3_0, 
        		"org.osate.verify.Verify.JavaParameter");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getJavaMethodAccess().getCommaKeyword_2_1_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getJavaMethodAccess().getParamsJavaParameterParserRuleCall_2_1_1_1_0()); 
	    }
		lv_params_5_0=ruleJavaParameter		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getJavaMethodRule());
	        }
       		add(
       			$current, 
       			"params",
        		lv_params_5_0, 
        		"org.osate.verify.Verify.JavaParameter");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_6=')' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getJavaMethodAccess().getRightParenthesisKeyword_2_2());
    }
)?)
;





// Entry rule entryRulePythonMethod
entryRulePythonMethod returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPythonMethodRule()); }
	 iv_rulePythonMethod=rulePythonMethod 
	 { $current=$iv_rulePythonMethod.current; } 
	 EOF 
;

// Rule PythonMethod
rulePythonMethod returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='python' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getPythonMethodAccess().getPythonKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPythonMethodAccess().getMethodPathQualifiedNameParserRuleCall_1_0()); 
	    }
		lv_methodPath_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPythonMethodRule());
	        }
       		set(
       			$current, 
       			"methodPath",
        		lv_methodPath_1_0, 
        		"org.osate.alisa.common.Common.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleManualMethod
entryRuleManualMethod returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getManualMethodRule()); }
	 iv_ruleManualMethod=ruleManualMethod 
	 { $current=$iv_ruleManualMethod.current; } 
	 EOF 
;

// Rule ManualMethod
ruleManualMethod returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='manual' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getManualMethodAccess().getManualKeyword_0());
    }
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getManualMethodAccess().getManualMethodAction_1(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getManualMethodAccess().getDialogIDQualifiedNameParserRuleCall_2_0()); 
	    }
		lv_dialogID_2_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getManualMethodRule());
	        }
       		set(
       			$current, 
       			"dialogID",
        		lv_dialogID_2_0, 
        		"org.osate.alisa.common.Common.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRulePluginMethod
entryRulePluginMethod returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPluginMethodRule()); }
	 iv_rulePluginMethod=rulePluginMethod 
	 { $current=$iv_rulePluginMethod.current; } 
	 EOF 
;

// Rule PluginMethod
rulePluginMethod returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='plugin' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getPluginMethodAccess().getPluginKeyword_0());
    }
(
(
		lv_methodID_1_0=RULE_ID
		{
			newLeafNode(lv_methodID_1_0, grammarAccess.getPluginMethodAccess().getMethodIDIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPluginMethodRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"methodID",
        		lv_methodID_1_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
))
;





// Entry rule entryRuleAgreeMethod
entryRuleAgreeMethod returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAgreeMethodRule()); }
	 iv_ruleAgreeMethod=ruleAgreeMethod 
	 { $current=$iv_ruleAgreeMethod.current; } 
	 EOF 
;

// Rule AgreeMethod
ruleAgreeMethod returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='agree' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getAgreeMethodAccess().getAgreeKeyword_0());
    }
((
(
		lv_singleLayer_1_0=	'single' 
    {
        newLeafNode(lv_singleLayer_1_0, grammarAccess.getAgreeMethodAccess().getSingleLayerSingleKeyword_1_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAgreeMethodRule());
	        }
       		setWithLastConsumed($current, "singleLayer", true, "single");
	    }

)
)
    |(
(
		lv_all_2_0=	'all' 
    {
        newLeafNode(lv_all_2_0, grammarAccess.getAgreeMethodAccess().getAllAllKeyword_1_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAgreeMethodRule());
	        }
       		setWithLastConsumed($current, "all", true, "all");
	    }

)
)))
;





// Entry rule entryRuleJUnit4Method
entryRuleJUnit4Method returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getJUnit4MethodRule()); }
	 iv_ruleJUnit4Method=ruleJUnit4Method 
	 { $current=$iv_ruleJUnit4Method.current; } 
	 EOF 
;

// Rule JUnit4Method
ruleJUnit4Method returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='junit' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getJUnit4MethodAccess().getJunitKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getJUnit4MethodAccess().getClassPathQualifiedNameParserRuleCall_1_0()); 
	    }
		lv_classPath_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getJUnit4MethodRule());
	        }
       		set(
       			$current, 
       			"classPath",
        		lv_classPath_1_0, 
        		"org.osate.alisa.common.Common.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleJavaParameter
entryRuleJavaParameter returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getJavaParameterRule()); }
	 iv_ruleJavaParameter=ruleJavaParameter 
	 { $current=$iv_ruleJavaParameter.current; } 
	 EOF 
;

// Rule JavaParameter
ruleJavaParameter returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_parameterType_0_0=RULE_ID
		{
			newLeafNode(lv_parameterType_0_0, grammarAccess.getJavaParameterAccess().getParameterTypeIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getJavaParameterRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"parameterType",
        		lv_parameterType_0_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getJavaParameterAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getJavaParameterRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
))
;





// Entry rule entryRuleDescription
entryRuleDescription returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDescriptionRule()); }
	 iv_ruleDescription=ruleDescription 
	 { $current=$iv_ruleDescription.current; } 
	 EOF 
;

// Rule Description
ruleDescription returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='description' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getDescriptionAccess().getDescriptionKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_1_0()); 
	    }
		lv_description_1_0=ruleDescriptionElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDescriptionRule());
	        }
       		add(
       			$current, 
       			"description",
        		lv_description_1_0, 
        		"org.osate.alisa.common.Common.DescriptionElement");
	        afterParserOrEnumRuleCall();
	    }

)
)+)
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
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
)
    |((
(
	'this' 
 

)
)=>
(
		lv_thisTarget_1_0=	'this' 
    {
        newLeafNode(lv_thisTarget_1_0, grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDescriptionElementRule());
	        }
       		setWithLastConsumed($current, "thisTarget", true, "this");
	    }

)
)
    |((
(
ruleImageReference
)
)=>
(
		{ 
	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getImageImageReferenceParserRuleCall_2_0()); 
	    }
		lv_image_2_0=ruleImageReference		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
	        }
       		set(
       			$current, 
       			"image",
        		lv_image_2_0, 
        		"org.osate.alisa.common.Common.ImageReference");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getShowValueShowValueParserRuleCall_3_0()); 
	    }
		lv_showValue_3_0=ruleShowValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
	        }
       		set(
       			$current, 
       			"showValue",
        		lv_showValue_3_0, 
        		"org.osate.alisa.common.Common.ShowValue");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleRationale
entryRuleRationale returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRationaleRule()); }
	 iv_ruleRationale=ruleRationale 
	 { $current=$iv_ruleRationale.current; } 
	 EOF 
;

// Rule Rationale
ruleRationale returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='rationale' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getRationaleAccess().getRationaleKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getRationaleAccess().getDescriptionDescriptionElementParserRuleCall_1_0()); 
	    }
		lv_description_1_0=ruleDescriptionElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRationaleRule());
	        }
       		add(
       			$current, 
       			"description",
        		lv_description_1_0, 
        		"org.osate.alisa.common.Common.DescriptionElement");
	        afterParserOrEnumRuleCall();
	    }

)
)+)
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
	        newCompositeNode(grammarAccess.getShowValueAccess().getExpressionAVariableReferenceParserRuleCall_0_0()); 
	    }
		lv_expression_0_0=ruleAVariableReference		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getShowValueRule());
	        }
       		set(
       			$current, 
       			"expression",
        		lv_expression_0_0, 
        		"org.osate.alisa.common.Common.AVariableReference");
	        afterParserOrEnumRuleCall();
	    }

)
)(((
(
		lv_convert_1_0=	'%' 
    {
        newLeafNode(lv_convert_1_0, grammarAccess.getShowValueAccess().getConvertPercentSignKeyword_1_0_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getShowValueRule());
	        }
       		setWithLastConsumed($current, "convert", true, "\%");
	    }

)
)
    |(
(
		lv_drop_2_0=	'in' 
    {
        newLeafNode(lv_drop_2_0, grammarAccess.getShowValueAccess().getDropInKeyword_1_0_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getShowValueRule());
	        }
       		setWithLastConsumed($current, "drop", true, "in");
	    }

)
))(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getShowValueRule());
	        }
        }
	otherlv_3=RULE_ID
	{
		newLeafNode(otherlv_3, grammarAccess.getShowValueAccess().getUnitUnitLiteralCrossReference_1_1_0()); 
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
        		"org.osate.alisa.common.Common.IMGREF");
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
        		"org.osate.alisa.common.Common.OpOr");
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
        		"org.osate.alisa.common.Common.AAndExpression");
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
        		"org.osate.alisa.common.Common.OpAnd");
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
        		"org.osate.alisa.common.Common.AEqualityExpression");
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
        		"org.osate.alisa.common.Common.OpEquality");
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
        		"org.osate.alisa.common.Common.ARelationalExpression");
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
        		"org.osate.alisa.common.Common.OpCompare");
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
        		"org.osate.alisa.common.Common.AAdditiveExpression");
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
        		"org.osate.alisa.common.Common.OpAdd");
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
        		"org.osate.alisa.common.Common.AMultiplicativeExpression");
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
        		"org.osate.alisa.common.Common.OpMulti");
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
        		"org.osate.alisa.common.Common.AUnaryOperation");
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
        		"org.osate.alisa.common.Common.OpUnary");
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
        		"org.osate.alisa.common.Common.AUnaryOperation");
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
		{ 
	        newCompositeNode(grammarAccess.getAFunctionCallAccess().getFunctionQualifiedNameParserRuleCall_1_0()); 
	    }
		lv_function_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
	        }
       		set(
       			$current, 
       			"function",
        		lv_function_1_0, 
        		"org.osate.alisa.common.Common.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAFunctionCallAccess().getLeftParenthesisKeyword_2());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_0_0()); 
	    }
		lv_arguments_3_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
	        }
       		add(
       			$current, 
       			"arguments",
        		lv_arguments_3_0, 
        		"org.osate.alisa.common.Common.AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getAFunctionCallAccess().getCommaKeyword_3_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_1_1_0()); 
	    }
		lv_arguments_5_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
	        }
       		add(
       			$current, 
       			"arguments",
        		lv_arguments_5_0, 
        		"org.osate.alisa.common.Common.AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_6=')' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getAFunctionCallAccess().getRightParenthesisKeyword_4());
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
        		"org.osate.alisa.common.Common.AExpression");
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
        		"org.osate.alisa.common.Common.AExpression");
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
        		"org.osate.alisa.common.Common.AExpression");
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
        		"org.osate.alisa.common.Common.AExpression");
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
        		"org.osate.alisa.common.Common.AExpression");
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
        		"org.osate.alisa.common.Common.AExpression");
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
        		"org.osate.alisa.common.Common.AInt");
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
        		"org.osate.alisa.common.Common.AReal");
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
        		"org.osate.alisa.common.Common.NoQuoteString");
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





// Entry rule entryRuleComponentCategory
entryRuleComponentCategory returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getComponentCategoryRule()); } 
	 iv_ruleComponentCategory=ruleComponentCategory 
	 { $current=$iv_ruleComponentCategory.current.getText(); }  
	 EOF 
;

// Rule ComponentCategory
ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='abstract' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
    }

    |
	kw='bus' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
    }

    |
	kw='data' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
    }

    |
	kw='device' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
    }

    |
	kw='memory' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
    }

    |
	kw='process' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
    }

    |
	kw='processor' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
    }

    |
	kw='subprogram' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
    }

    |(
	kw='subprogram' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
    }

	kw='group' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
    }
)
    |
	kw='system' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
    }

    |(
	kw='thread' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
    }

	kw='group' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
    }
)
    |
	kw='thread' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
    }

    |(
	kw='virtual' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
    }

	kw='bus' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
    }
)
    |(
	kw='virtual' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
    }

	kw='processor' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); 
    }
))
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







// Rule TargetType
ruleTargetType returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='component' 
	{
        $current = grammarAccess.getTargetTypeAccess().getCOMPONENTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getTargetTypeAccess().getCOMPONENTEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='feature' 
	{
        $current = grammarAccess.getTargetTypeAccess().getFEATUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getTargetTypeAccess().getFEATUREEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='connection' 
	{
        $current = grammarAccess.getTargetTypeAccess().getCONNECTIONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getTargetTypeAccess().getCONNECTIONEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='flow' 
	{
        $current = grammarAccess.getTargetTypeAccess().getFLOWEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getTargetTypeAccess().getFLOWEnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='mode' 
	{
        $current = grammarAccess.getTargetTypeAccess().getMODEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getTargetTypeAccess().getMODEEnumLiteralDeclaration_4()); 
    }
)
    |(	enumLiteral_5='element' 
	{
        $current = grammarAccess.getTargetTypeAccess().getELEMENTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getTargetTypeAccess().getELEMENTEnumLiteralDeclaration_5()); 
    }
)
    |(	enumLiteral_6='root' 
	{
        $current = grammarAccess.getTargetTypeAccess().getROOTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_6, grammarAccess.getTargetTypeAccess().getROOTEnumLiteralDeclaration_6()); 
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


