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
grammar InternalAlisa;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.osate.alisa.workbench.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.osate.alisa.workbench.parser.antlr.internal; 

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
import org.osate.alisa.workbench.services.AlisaGrammarAccess;

}

@parser::members {

 	private AlisaGrammarAccess grammarAccess;
 	
    public InternalAlisaParser(TokenStream input, AlisaGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "AssuranceCase";	
   	}
   	
   	@Override
   	protected AlisaGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleAssuranceCase
entryRuleAssuranceCase returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAssuranceCaseRule()); }
	 iv_ruleAssuranceCase=ruleAssuranceCase 
	 { $current=$iv_ruleAssuranceCase.current; } 
	 EOF 
;

// Rule AssuranceCase
ruleAssuranceCase returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='assurance' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getAssuranceCaseAccess().getAssuranceKeyword_0());
    }
	otherlv_1='case' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAssuranceCaseAccess().getCaseKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseAccess().getNameQualifiedNameParserRuleCall_2_0()); 
	    }
		lv_name_2_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceCaseRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getAssuranceCaseAccess().getColonKeyword_3_0());
    }
(
(
		lv_title_4_0=RULE_STRING
		{
			newLeafNode(lv_title_4_0, grammarAccess.getAssuranceCaseAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceCaseRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_4_0, 
        		"STRING");
	    }

)
))?	otherlv_5='for' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getAssuranceCaseAccess().getForKeyword_4());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceCaseRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseAccess().getSystemComponentTypeCrossReference_5_0()); 
	    }
		ruleAadlClassifierReference		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7='[' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getAssuranceCaseAccess().getLeftSquareBracketKeyword_6());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseAccess().getDescriptionDescriptionParserRuleCall_7_0()); 
	    }
		lv_description_8_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceCaseRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_8_0, 
        		"Description");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseAccess().getAssurancePlansAssurancePlanParserRuleCall_8_0()); 
	    }
		lv_assurancePlans_9_0=ruleAssurancePlan		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceCaseRule());
	        }
       		add(
       			$current, 
       			"assurancePlans",
        		lv_assurancePlans_9_0, 
        		"AssurancePlan");
	        afterParserOrEnumRuleCall();
	    }

)
)+(
(
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseAccess().getTasksAssuranceTaskParserRuleCall_9_0()); 
	    }
		lv_tasks_10_0=ruleAssuranceTask		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceCaseRule());
	        }
       		add(
       			$current, 
       			"tasks",
        		lv_tasks_10_0, 
        		"AssuranceTask");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_11=']' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getAssuranceCaseAccess().getRightSquareBracketKeyword_10());
    }
)
;





// Entry rule entryRuleAssurancePlan
entryRuleAssurancePlan returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAssurancePlanRule()); }
	 iv_ruleAssurancePlan=ruleAssurancePlan 
	 { $current=$iv_ruleAssurancePlan.current; } 
	 EOF 
;

// Rule AssurancePlan
ruleAssurancePlan returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='assurance' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getAssurancePlanAccess().getAssuranceKeyword_0());
    }
	otherlv_1='plan' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAssurancePlanAccess().getPlanKeyword_1());
    }
(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getAssurancePlanAccess().getNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssurancePlanRule());
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
    	newLeafNode(otherlv_3, grammarAccess.getAssurancePlanAccess().getColonKeyword_3_0());
    }
(
(
		lv_title_4_0=RULE_STRING
		{
			newLeafNode(lv_title_4_0, grammarAccess.getAssurancePlanAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssurancePlanRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_4_0, 
        		"STRING");
	    }

)
))?	otherlv_5='for' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getAssurancePlanAccess().getForKeyword_4());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssurancePlanRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getTargetComponentImplementationCrossReference_5_0()); 
	    }
		ruleAadlClassifierReference		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7='[' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getAssurancePlanAccess().getLeftSquareBracketKeyword_6());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getDescriptionDescriptionParserRuleCall_7_0_0()); 
	    }
		lv_description_9_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssurancePlanRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_9_0, 
        		"Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1);
	 				}
					({true}?=>(	otherlv_10='assure' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssurancePlanRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getAssureVerificationPlanCrossReference_7_1_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2);
	 				}
					({true}?=>(	otherlv_12='assure' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_2_0());
    }
	otherlv_13='global' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getAssurancePlanAccess().getGlobalKeyword_7_2_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssurancePlanRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getAssureGlobalVerificationPlanCrossReference_7_2_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3);
	 				}
					({true}?=>(	otherlv_15='assure' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_3_0());
    }
	otherlv_16='subsystem' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getAssurancePlanAccess().getSubsystemKeyword_7_3_1());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssurancePlanRule());
	        }
        }
	otherlv_17=RULE_ID
	{
		newLeafNode(otherlv_17, grammarAccess.getAssurancePlanAccess().getAssureSubsystemsSubcomponentCrossReference_7_3_2_0_0()); 
	}

)
)+
    |(
(
		lv_assureAll_18_0=	'all' 
    {
        newLeafNode(lv_assureAll_18_0, grammarAccess.getAssurancePlanAccess().getAssureAllAllKeyword_7_3_2_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssurancePlanRule());
	        }
       		setWithLastConsumed($current, "assureAll", true, "all");
	    }

)
))))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4);
	 				}
					({true}?=>(	otherlv_19='assume' 
    {
    	newLeafNode(otherlv_19, grammarAccess.getAssurancePlanAccess().getAssumeKeyword_7_4_0());
    }
	otherlv_20='subsystem' 
    {
    	newLeafNode(otherlv_20, grammarAccess.getAssurancePlanAccess().getSubsystemKeyword_7_4_1());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssurancePlanRule());
	        }
        }
	otherlv_21=RULE_ID
	{
		newLeafNode(otherlv_21, grammarAccess.getAssurancePlanAccess().getAssumeSubsystemsSubcomponentCrossReference_7_4_2_0_0()); 
	}

)
)+
    |(
(
		lv_assumeAll_22_0=	'all' 
    {
        newLeafNode(lv_assumeAll_22_0, grammarAccess.getAssurancePlanAccess().getAssumeAllAllKeyword_7_4_2_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssurancePlanRule());
	        }
       		setWithLastConsumed($current, "assumeAll", true, "all");
	    }

)
))))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 5);
	 				}
					({true}?=>(	otherlv_23='issues' 
    {
    	newLeafNode(otherlv_23, grammarAccess.getAssurancePlanAccess().getIssuesKeyword_7_5_0());
    }
(
(
		lv_issues_24_0=RULE_STRING
		{
			newLeafNode(lv_issues_24_0, grammarAccess.getAssurancePlanAccess().getIssuesSTRINGTerminalRuleCall_7_5_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssurancePlanRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_24_0, 
        		"STRING");
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
	}

)	otherlv_25=']' 
    {
    	newLeafNode(otherlv_25, grammarAccess.getAssurancePlanAccess().getRightSquareBracketKeyword_8());
    }
)
;





// Entry rule entryRuleAssuranceTask
entryRuleAssuranceTask returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAssuranceTaskRule()); }
	 iv_ruleAssuranceTask=ruleAssuranceTask 
	 { $current=$iv_ruleAssuranceTask.current; } 
	 EOF 
;

// Rule AssuranceTask
ruleAssuranceTask returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getAssuranceTaskAccess().getAssuranceTaskAction_0(),
            $current);
    }
)	otherlv_1='assurance' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAssuranceTaskAccess().getAssuranceKeyword_1());
    }
	otherlv_2='task' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAssuranceTaskAccess().getTaskKeyword_2());
    }
(
(
		lv_name_3_0=RULE_ID
		{
			newLeafNode(lv_name_3_0, grammarAccess.getAssuranceTaskAccess().getNameIDTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceTaskRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_3_0, 
        		"ID");
	    }

)
)(	otherlv_4=':' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getAssuranceTaskAccess().getColonKeyword_4_0());
    }
(
(
		lv_title_5_0=RULE_STRING
		{
			newLeafNode(lv_title_5_0, grammarAccess.getAssuranceTaskAccess().getTitleSTRINGTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceTaskRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_5_0, 
        		"STRING");
	    }

)
))?	otherlv_6='[' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_5());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 0);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getAssuranceTaskAccess().getDescriptionDescriptionParserRuleCall_6_0_0()); 
	    }
		lv_description_8_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceTaskRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_8_0, 
        		"Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 1);
	 				}
					({true}?=>(	otherlv_9='category' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getAssuranceTaskAccess().getCategoryKeyword_6_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceTaskRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAssuranceTaskAccess().getCategoryCategoryCrossReference_6_1_1_0()); 
	    }
		ruleCatRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+(
(
		lv_anyCategory_11_0=	'any' 
    {
        newLeafNode(lv_anyCategory_11_0, grammarAccess.getAssuranceTaskAccess().getAnyCategoryAnyKeyword_6_1_2_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceTaskRule());
	        }
       		setWithLastConsumed($current, "anyCategory", true, "any");
	    }

)
)?))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 2);
	 				}
					({true}?=>(	otherlv_12='issues' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getAssuranceTaskAccess().getIssuesKeyword_6_2_0());
    }
(
(
		lv_issues_13_0=RULE_STRING
		{
			newLeafNode(lv_issues_13_0, grammarAccess.getAssuranceTaskAccess().getIssuesSTRINGTerminalRuleCall_6_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceTaskRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_13_0, 
        		"STRING");
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6());
	}

)	otherlv_14=']' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_7());
    }
)
;





// Entry rule entryRuleCatRef
entryRuleCatRef returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getCatRefRule()); } 
	 iv_ruleCatRef=ruleCatRef 
	 { $current=$iv_ruleCatRef.current.getText(); }  
	 EOF 
;

// Rule CatRef
ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getCatRefAccess().getIDTerminalRuleCall_0()); 
    }

	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getCatRefAccess().getFullStopKeyword_1()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getCatRefAccess().getIDTerminalRuleCall_2()); 
    }
)
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
        		"DescriptionElement");
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
		ruleURIID		{ 
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
(	otherlv_4='unit' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getTypeRefAccess().getUnitKeyword_1_2_0());
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
(	otherlv_8='unit' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getTypeRefAccess().getUnitKeyword_2_2_0());
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





// Entry rule entryRuleNestedModelelement
entryRuleNestedModelelement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNestedModelelementRule()); }
	 iv_ruleNestedModelelement=ruleNestedModelelement 
	 { $current=$iv_ruleNestedModelelement.current; } 
	 EOF 
;

// Rule NestedModelelement
ruleNestedModelelement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getNestedModelelementRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getNestedModelelementAccess().getModelElementNamedElementCrossReference_0_0()); 
	}

)
)(	otherlv_1='.' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getNestedModelelementAccess().getFullStopKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNestedModelelementAccess().getNextNestedModelelementParserRuleCall_1_1_0()); 
	    }
		lv_next_2_0=ruleNestedModelelement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNestedModelelementRule());
	        }
       		set(
       			$current, 
       			"next",
        		lv_next_2_0, 
        		"NestedModelelement");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
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
    {
        $current = forceCreateModelElement(
            grammarAccess.getAModelReferenceAccess().getAModelReferenceAction_0(),
            $current);
    }
)	otherlv_1='this' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAModelReferenceAccess().getThisKeyword_1());
    }
(	otherlv_2='.' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAModelReferenceAccess().getFullStopKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAModelReferenceAccess().getNextNestedModelelementParserRuleCall_2_1_0()); 
	    }
		lv_next_3_0=ruleNestedModelelement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAModelReferenceRule());
	        }
       		set(
       			$current, 
       			"next",
        		lv_next_3_0, 
        		"NestedModelelement");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
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

	kw='or' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword()); 
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

	kw='and' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword()); 
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
		lv_convert_2_0=	'to' 
    {
        newLeafNode(lv_convert_2_0, grammarAccess.getAUnitExpressionAccess().getConvertToKeyword_1_1_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAUnitExpressionRule());
	        }
       		setWithLastConsumed($current, "convert", true, "to");
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


