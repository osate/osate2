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
parser grammar InternalReqSpecParser;

options {
	tokenVocab=InternalReqSpecLexer;
	superClass=AbstractInternalAntlrParser;
	
}

@header {
package org.osate.reqspec.parser.antlr.internal; 

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
import org.osate.reqspec.services.ReqSpecGrammarAccess;

}

@members {


	private ReqSpecGrammarAccess grammarAccess;
	 	
	public InternalReqSpecParser(TokenStream input, ReqSpecGrammarAccess grammarAccess) {
		this(input);
		this.grammarAccess = grammarAccess;
		registerRules(grammarAccess.getGrammar());
	}
	
	@Override
	protected String getFirstRuleName() {
		return "ReqSpec";	
	} 
	   	   	
	@Override
	protected ReqSpecGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}
}

@rulecatch { 
	catch (RecognitionException re) { 
	    recover(input,re); 
	    appendSkippedTokens();
	}
}




// Entry rule entryRuleReqSpec
entryRuleReqSpec returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getReqSpecRule()); }
	 iv_ruleReqSpec=ruleReqSpec 
	 { $current=$iv_ruleReqSpec.current; } 
	 EOF 
;

// Rule ReqSpec
ruleReqSpec returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
(
		{ 
	        newCompositeNode(grammarAccess.getReqSpecAccess().getPartsSystemRequirementsParserRuleCall_0_0()); 
	    }
		lv_parts_0_1=ruleSystemRequirements		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReqSpecRule());
	        }
       		add(
       			$current, 
       			"parts",
        		lv_parts_0_1, 
        		"SystemRequirements");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getReqSpecAccess().getPartsGlobalRequirementsParserRuleCall_0_1()); 
	    }
		lv_parts_0_2=ruleGlobalRequirements		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReqSpecRule());
	        }
       		add(
       			$current, 
       			"parts",
        		lv_parts_0_2, 
        		"GlobalRequirements");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getReqSpecAccess().getPartsStakeholderGoalsParserRuleCall_0_2()); 
	    }
		lv_parts_0_3=ruleStakeholderGoals		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReqSpecRule());
	        }
       		add(
       			$current, 
       			"parts",
        		lv_parts_0_3, 
        		"StakeholderGoals");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getReqSpecAccess().getPartsReqDocumentParserRuleCall_0_3()); 
	    }
		lv_parts_0_4=ruleReqDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReqSpecRule());
	        }
       		add(
       			$current, 
       			"parts",
        		lv_parts_0_4, 
        		"ReqDocument");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getReqSpecAccess().getPartsGlobalConstantsParserRuleCall_0_4()); 
	    }
		lv_parts_0_5=ruleGlobalConstants		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReqSpecRule());
	        }
       		add(
       			$current, 
       			"parts",
        		lv_parts_0_5, 
        		"GlobalConstants");
	        afterParserOrEnumRuleCall();
	    }

)

)
)+
;







// Entry rule entryRuleGlobalConstants
entryRuleGlobalConstants returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getGlobalConstantsRule()); }
	 iv_ruleGlobalConstants=ruleGlobalConstants 
	 { $current=$iv_ruleGlobalConstants.current; } 
	 EOF 
;

// Rule GlobalConstants
ruleGlobalConstants returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Constants
    {
    	newLeafNode(otherlv_0, grammarAccess.getGlobalConstantsAccess().getConstantsKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalConstantsAccess().getNameQualifiedNameParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalConstantsRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)
	otherlv_2=LeftSquareBracket
    {
    	newLeafNode(otherlv_2, grammarAccess.getGlobalConstantsAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalConstantsAccess().getConstantsValDeclarationParserRuleCall_3_0()); 
	    }
		lv_constants_3_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalConstantsRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_3_0, 
        		"ValDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
)*
	otherlv_4=RightSquareBracket
    {
    	newLeafNode(otherlv_4, grammarAccess.getGlobalConstantsAccess().getRightSquareBracketKeyword_4());
    }
)
;









// Entry rule entryRuleStakeholderGoals
entryRuleStakeholderGoals returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getStakeholderGoalsRule()); }
	 iv_ruleStakeholderGoals=ruleStakeholderGoals 
	 { $current=$iv_ruleStakeholderGoals.current; } 
	 EOF 
;

// Rule StakeholderGoals
ruleStakeholderGoals returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Stakeholder
    {
    	newLeafNode(otherlv_0, grammarAccess.getStakeholderGoalsAccess().getStakeholderKeyword_0());
    }

	otherlv_1=Goals
    {
    	newLeafNode(otherlv_1, grammarAccess.getStakeholderGoalsAccess().getGoalsKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getNameQualifiedNameParserRuleCall_2_0()); 
	    }
		lv_name_2_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStakeholderGoalsRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
	otherlv_3=Colon
    {
    	newLeafNode(otherlv_3, grammarAccess.getStakeholderGoalsAccess().getColonKeyword_3_0());
    }
(
(
		lv_title_4_0=RULE_STRING
		{
			newLeafNode(lv_title_4_0, grammarAccess.getStakeholderGoalsAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getStakeholderGoalsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_4_0, 
        		"STRING");
	    }

)
))?(
	otherlv_5=For
    {
    	newLeafNode(otherlv_5, grammarAccess.getStakeholderGoalsAccess().getForKeyword_4_0());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getStakeholderGoalsRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getTargetComponentClassifierCrossReference_4_1_0_0()); 
	    }
		ruleAadlClassifierReference		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getComponentCategoryComponentCategoryParserRuleCall_4_1_1_0()); 
	    }
		lv_componentCategory_7_0=ruleComponentCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStakeholderGoalsRule());
	        }
       		add(
       			$current, 
       			"componentCategory",
        		lv_componentCategory_7_0, 
        		"ComponentCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+))(
	otherlv_8=Use
    {
    	newLeafNode(otherlv_8, grammarAccess.getStakeholderGoalsAccess().getUseKeyword_5_0());
    }

	otherlv_9=Constants
    {
    	newLeafNode(otherlv_9, grammarAccess.getStakeholderGoalsAccess().getConstantsKeyword_5_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getStakeholderGoalsRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getImportConstantsGlobalConstantsCrossReference_5_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)?
	otherlv_11=LeftSquareBracket
    {
    	newLeafNode(otherlv_11, grammarAccess.getStakeholderGoalsAccess().getLeftSquareBracketKeyword_6());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 0);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getDescriptionDescriptionParserRuleCall_7_0_0()); 
	    }
		lv_description_13_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStakeholderGoalsRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_13_0, 
        		"Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 1);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getConstantsValDeclarationParserRuleCall_7_1_0()); 
	    }
		lv_constants_14_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStakeholderGoalsRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_14_0, 
        		"ValDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getContentGoalParserRuleCall_7_2_0()); 
	    }
		lv_content_15_0=ruleGoal		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStakeholderGoalsRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_15_0, 
        		"Goal");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 3);
	 				}
					({true}?=>(
	otherlv_16=See
    {
    	newLeafNode(otherlv_16, grammarAccess.getStakeholderGoalsAccess().getSeeKeyword_7_3_0());
    }

	otherlv_17=Document
    {
    	newLeafNode(otherlv_17, grammarAccess.getStakeholderGoalsAccess().getDocumentKeyword_7_3_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getDocReferenceExternalDocumentParserRuleCall_7_3_2_0()); 
	    }
		lv_docReference_18_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStakeholderGoalsRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_18_0, 
        		"ExternalDocument");
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 4);
	 				}
					({true}?=>(
	otherlv_19=Issues
    {
    	newLeafNode(otherlv_19, grammarAccess.getStakeholderGoalsAccess().getIssuesKeyword_7_4_0());
    }
(
(
		lv_issues_20_0=RULE_STRING
		{
			newLeafNode(lv_issues_20_0, grammarAccess.getStakeholderGoalsAccess().getIssuesSTRINGTerminalRuleCall_7_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getStakeholderGoalsRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_20_0, 
        		"STRING");
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7());
	}

)
	otherlv_21=RightSquareBracket
    {
    	newLeafNode(otherlv_21, grammarAccess.getStakeholderGoalsAccess().getRightSquareBracketKeyword_8());
    }
)
;





// Entry rule entryRuleReqDocument
entryRuleReqDocument returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getReqDocumentRule()); }
	 iv_ruleReqDocument=ruleReqDocument 
	 { $current=$iv_ruleReqDocument.current; } 
	 EOF 
;

// Rule ReqDocument
ruleReqDocument returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Document
    {
    	newLeafNode(otherlv_0, grammarAccess.getReqDocumentAccess().getDocumentKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getReqDocumentAccess().getNameQualifiedNameParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReqDocumentRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
	otherlv_2=Colon
    {
    	newLeafNode(otherlv_2, grammarAccess.getReqDocumentAccess().getColonKeyword_2_0());
    }
(
(
		lv_title_3_0=RULE_STRING
		{
			newLeafNode(lv_title_3_0, grammarAccess.getReqDocumentAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getReqDocumentRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_3_0, 
        		"STRING");
	    }

)
))?
	otherlv_4=LeftSquareBracket
    {
    	newLeafNode(otherlv_4, grammarAccess.getReqDocumentAccess().getLeftSquareBracketKeyword_3());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 0);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getReqDocumentAccess().getDescriptionDescriptionParserRuleCall_4_0_0()); 
	    }
		lv_description_6_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReqDocumentRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_6_0, 
        		"Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 1);
	 				}
					({true}?=>(
(
(
		{ 
	        newCompositeNode(grammarAccess.getReqDocumentAccess().getContentDocGoalParserRuleCall_4_1_0_0()); 
	    }
		lv_content_7_1=ruleDocGoal		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReqDocumentRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_7_1, 
        		"DocGoal");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getReqDocumentAccess().getContentDocRequirementParserRuleCall_4_1_0_1()); 
	    }
		lv_content_7_2=ruleDocRequirement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReqDocumentRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_7_2, 
        		"DocRequirement");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getReqDocumentAccess().getContentDocumentSectionParserRuleCall_4_1_0_2()); 
	    }
		lv_content_7_3=ruleDocumentSection		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReqDocumentRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_7_3, 
        		"DocumentSection");
	        afterParserOrEnumRuleCall();
	    }

)

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 2);
	 				}
					({true}?=>(
	otherlv_8=See
    {
    	newLeafNode(otherlv_8, grammarAccess.getReqDocumentAccess().getSeeKeyword_4_2_0());
    }

	otherlv_9=Document
    {
    	newLeafNode(otherlv_9, grammarAccess.getReqDocumentAccess().getDocumentKeyword_4_2_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getReqDocumentAccess().getDocReferenceExternalDocumentParserRuleCall_4_2_2_0()); 
	    }
		lv_docReference_10_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReqDocumentRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_10_0, 
        		"ExternalDocument");
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 3);
	 				}
					({true}?=>(
	otherlv_11=Issues
    {
    	newLeafNode(otherlv_11, grammarAccess.getReqDocumentAccess().getIssuesKeyword_4_3_0());
    }
(
(
		lv_issues_12_0=RULE_STRING
		{
			newLeafNode(lv_issues_12_0, grammarAccess.getReqDocumentAccess().getIssuesSTRINGTerminalRuleCall_4_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getReqDocumentRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_12_0, 
        		"STRING");
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4());
	}

)
	otherlv_13=RightSquareBracket
    {
    	newLeafNode(otherlv_13, grammarAccess.getReqDocumentAccess().getRightSquareBracketKeyword_5());
    }
)
;





// Entry rule entryRuleDocumentSection
entryRuleDocumentSection returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getDocumentSectionRule()); }
	 iv_ruleDocumentSection=ruleDocumentSection 
	 { $current=$iv_ruleDocumentSection.current; } 
	 EOF 
;

// Rule DocumentSection
ruleDocumentSection returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Section
    {
    	newLeafNode(otherlv_0, grammarAccess.getDocumentSectionAccess().getSectionKeyword_0());
    }
(
(
		lv_label_1_0=RULE_ID
		{
			newLeafNode(lv_label_1_0, grammarAccess.getDocumentSectionAccess().getLabelIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocumentSectionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"label",
        		lv_label_1_0, 
        		"ID");
	    }

)
)(
	otherlv_2=Colon
    {
    	newLeafNode(otherlv_2, grammarAccess.getDocumentSectionAccess().getColonKeyword_2_0());
    }
(
(
		lv_title_3_0=RULE_STRING
		{
			newLeafNode(lv_title_3_0, grammarAccess.getDocumentSectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocumentSectionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_3_0, 
        		"STRING");
	    }

)
))?
	otherlv_4=LeftSquareBracket
    {
    	newLeafNode(otherlv_4, grammarAccess.getDocumentSectionAccess().getLeftSquareBracketKeyword_3());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_4());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_4(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_4(), 0);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getDescriptionDescriptionParserRuleCall_4_0_0()); 
	    }
		lv_description_6_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocumentSectionRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_6_0, 
        		"Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_4());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_4(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_4(), 1);
	 				}
					({true}?=>(
(
(
		{ 
	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentDocGoalParserRuleCall_4_1_0_0()); 
	    }
		lv_content_7_1=ruleDocGoal		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocumentSectionRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_7_1, 
        		"DocGoal");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentDocRequirementParserRuleCall_4_1_0_1()); 
	    }
		lv_content_7_2=ruleDocRequirement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocumentSectionRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_7_2, 
        		"DocRequirement");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentDocumentSectionParserRuleCall_4_1_0_2()); 
	    }
		lv_content_7_3=ruleDocumentSection		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocumentSectionRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_7_3, 
        		"DocumentSection");
	        afterParserOrEnumRuleCall();
	    }

)

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_4());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_4());
	}

)
	otherlv_8=RightSquareBracket
    {
    	newLeafNode(otherlv_8, grammarAccess.getDocumentSectionAccess().getRightSquareBracketKeyword_5());
    }
)
;





// Entry rule entryRuleSystemRequirements
entryRuleSystemRequirements returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getSystemRequirementsRule()); }
	 iv_ruleSystemRequirements=ruleSystemRequirements 
	 { $current=$iv_ruleSystemRequirements.current; } 
	 EOF 
;

// Rule SystemRequirements
ruleSystemRequirements returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getSystemRequirementsAccess().getSystemRequirementsAction_0(),
            $current);
    }
)
	otherlv_1=KW_System
    {
    	newLeafNode(otherlv_1, grammarAccess.getSystemRequirementsAccess().getSystemKeyword_1());
    }

	otherlv_2=Requirements
    {
    	newLeafNode(otherlv_2, grammarAccess.getSystemRequirementsAccess().getRequirementsKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementsAccess().getNameQualifiedNameParserRuleCall_3_0()); 
	    }
		lv_name_3_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementsRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_3_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
	otherlv_4=Colon
    {
    	newLeafNode(otherlv_4, grammarAccess.getSystemRequirementsAccess().getColonKeyword_4_0());
    }
(
(
		lv_title_5_0=RULE_STRING
		{
			newLeafNode(lv_title_5_0, grammarAccess.getSystemRequirementsAccess().getTitleSTRINGTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_5_0, 
        		"STRING");
	    }

)
))?
	otherlv_6=For
    {
    	newLeafNode(otherlv_6, grammarAccess.getSystemRequirementsAccess().getForKeyword_5());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementsRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementsAccess().getTargetComponentClassifierCrossReference_6_0()); 
	    }
		ruleAadlClassifierReference		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(
	otherlv_8=Use
    {
    	newLeafNode(otherlv_8, grammarAccess.getSystemRequirementsAccess().getUseKeyword_7_0());
    }

	otherlv_9=Constants
    {
    	newLeafNode(otherlv_9, grammarAccess.getSystemRequirementsAccess().getConstantsKeyword_7_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementsRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementsAccess().getImportConstantsGlobalConstantsCrossReference_7_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)?
	otherlv_11=LeftSquareBracket
    {
    	newLeafNode(otherlv_11, grammarAccess.getSystemRequirementsAccess().getLeftSquareBracketKeyword_8());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 0);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementsAccess().getDescriptionDescriptionParserRuleCall_9_0_0()); 
	    }
		lv_description_13_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementsRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_13_0, 
        		"Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 1);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementsAccess().getConstantsValDeclarationParserRuleCall_9_1_0()); 
	    }
		lv_constants_14_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementsRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_14_0, 
        		"ValDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementsAccess().getComputesComputeDeclarationParserRuleCall_9_2_0()); 
	    }
		lv_computes_15_0=ruleComputeDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementsRule());
	        }
       		add(
       			$current, 
       			"computes",
        		lv_computes_15_0, 
        		"ComputeDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 3);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementsAccess().getContentSystemRequirementParserRuleCall_9_3_0()); 
	    }
		lv_content_16_0=ruleSystemRequirement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementsRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_16_0, 
        		"SystemRequirement");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 4);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementsAccess().getIncludeIncludeGlobalRequirementParserRuleCall_9_4_0()); 
	    }
		lv_include_17_0=ruleIncludeGlobalRequirement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementsRule());
	        }
       		add(
       			$current, 
       			"include",
        		lv_include_17_0, 
        		"IncludeGlobalRequirement");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 5);
	 				}
					({true}?=>(
	otherlv_18=See
    {
    	newLeafNode(otherlv_18, grammarAccess.getSystemRequirementsAccess().getSeeKeyword_9_5_0());
    }

	otherlv_19=Document
    {
    	newLeafNode(otherlv_19, grammarAccess.getSystemRequirementsAccess().getDocumentKeyword_9_5_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementsAccess().getDocReferenceExternalDocumentParserRuleCall_9_5_2_0()); 
	    }
		lv_docReference_20_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementsRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_20_0, 
        		"ExternalDocument");
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 6)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 6);
	 				}
					({true}?=>(
	otherlv_21=See
    {
    	newLeafNode(otherlv_21, grammarAccess.getSystemRequirementsAccess().getSeeKeyword_9_6_0());
    }

	otherlv_22=Goals
    {
    	newLeafNode(otherlv_22, grammarAccess.getSystemRequirementsAccess().getGoalsKeyword_9_6_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementsRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementsAccess().getStakeholderGoalsReqRootCrossReference_9_6_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 7)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9(), 7);
	 				}
					({true}?=>(
	otherlv_24=Issues
    {
    	newLeafNode(otherlv_24, grammarAccess.getSystemRequirementsAccess().getIssuesKeyword_9_7_0());
    }
(
(
		lv_issues_25_0=RULE_STRING
		{
			newLeafNode(lv_issues_25_0, grammarAccess.getSystemRequirementsAccess().getIssuesSTRINGTerminalRuleCall_9_7_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementsRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_25_0, 
        		"STRING");
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_9());
	}

)
	otherlv_26=RightSquareBracket
    {
    	newLeafNode(otherlv_26, grammarAccess.getSystemRequirementsAccess().getRightSquareBracketKeyword_10());
    }
)
;





// Entry rule entryRuleGlobalRequirements
entryRuleGlobalRequirements returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getGlobalRequirementsRule()); }
	 iv_ruleGlobalRequirements=ruleGlobalRequirements 
	 { $current=$iv_ruleGlobalRequirements.current; } 
	 EOF 
;

// Rule GlobalRequirements
ruleGlobalRequirements returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getGlobalRequirementsAccess().getGlobalRequirementsAction_0(),
            $current);
    }
)
	otherlv_1=Global
    {
    	newLeafNode(otherlv_1, grammarAccess.getGlobalRequirementsAccess().getGlobalKeyword_1());
    }

	otherlv_2=Requirements
    {
    	newLeafNode(otherlv_2, grammarAccess.getGlobalRequirementsAccess().getRequirementsKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementsAccess().getNameQualifiedNameParserRuleCall_3_0()); 
	    }
		lv_name_3_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementsRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_3_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
	otherlv_4=Colon
    {
    	newLeafNode(otherlv_4, grammarAccess.getGlobalRequirementsAccess().getColonKeyword_4_0());
    }
(
(
		lv_title_5_0=RULE_STRING
		{
			newLeafNode(lv_title_5_0, grammarAccess.getGlobalRequirementsAccess().getTitleSTRINGTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_5_0, 
        		"STRING");
	    }

)
))?(
	otherlv_6=Use
    {
    	newLeafNode(otherlv_6, grammarAccess.getGlobalRequirementsAccess().getUseKeyword_5_0());
    }

	otherlv_7=Constants
    {
    	newLeafNode(otherlv_7, grammarAccess.getGlobalRequirementsAccess().getConstantsKeyword_5_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementsRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementsAccess().getImportConstantsGlobalConstantsCrossReference_5_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)?
	otherlv_9=LeftSquareBracket
    {
    	newLeafNode(otherlv_9, grammarAccess.getGlobalRequirementsAccess().getLeftSquareBracketKeyword_6());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 0);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementsAccess().getDescriptionDescriptionParserRuleCall_7_0_0()); 
	    }
		lv_description_11_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementsRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_11_0, 
        		"Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 1);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementsAccess().getConstantsValDeclarationParserRuleCall_7_1_0()); 
	    }
		lv_constants_12_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementsRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_12_0, 
        		"ValDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementsAccess().getComputesComputeDeclarationParserRuleCall_7_2_0()); 
	    }
		lv_computes_13_0=ruleComputeDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementsRule());
	        }
       		add(
       			$current, 
       			"computes",
        		lv_computes_13_0, 
        		"ComputeDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 3);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementsAccess().getContentGlobalRequirementParserRuleCall_7_3_0()); 
	    }
		lv_content_14_0=ruleGlobalRequirement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementsRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_14_0, 
        		"GlobalRequirement");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 4);
	 				}
					({true}?=>(
	otherlv_15=See
    {
    	newLeafNode(otherlv_15, grammarAccess.getGlobalRequirementsAccess().getSeeKeyword_7_4_0());
    }

	otherlv_16=Document
    {
    	newLeafNode(otherlv_16, grammarAccess.getGlobalRequirementsAccess().getDocumentKeyword_7_4_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementsAccess().getDocReferenceExternalDocumentParserRuleCall_7_4_2_0()); 
	    }
		lv_docReference_17_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementsRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_17_0, 
        		"ExternalDocument");
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 5);
	 				}
					({true}?=>(
	otherlv_18=See
    {
    	newLeafNode(otherlv_18, grammarAccess.getGlobalRequirementsAccess().getSeeKeyword_7_5_0());
    }

	otherlv_19=Goals
    {
    	newLeafNode(otherlv_19, grammarAccess.getGlobalRequirementsAccess().getGoalsKeyword_7_5_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementsRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementsAccess().getStakeholderGoalsReqRootCrossReference_7_5_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 6)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7(), 6);
	 				}
					({true}?=>(
	otherlv_21=Issues
    {
    	newLeafNode(otherlv_21, grammarAccess.getGlobalRequirementsAccess().getIssuesKeyword_7_6_0());
    }
(
(
		lv_issues_22_0=RULE_STRING
		{
			newLeafNode(lv_issues_22_0, grammarAccess.getGlobalRequirementsAccess().getIssuesSTRINGTerminalRuleCall_7_6_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementsRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_22_0, 
        		"STRING");
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getGlobalRequirementsAccess().getUnorderedGroup_7());
	}

)
	otherlv_23=RightSquareBracket
    {
    	newLeafNode(otherlv_23, grammarAccess.getGlobalRequirementsAccess().getRightSquareBracketKeyword_8());
    }
)
;





// Entry rule entryRuleDocGoal
entryRuleDocGoal returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getDocGoalRule()); }
	 iv_ruleDocGoal=ruleDocGoal 
	 { $current=$iv_ruleDocGoal.current; } 
	 EOF 
;

// Rule DocGoal
ruleDocGoal returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Goal
    {
    	newLeafNode(otherlv_0, grammarAccess.getDocGoalAccess().getGoalKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getDocGoalAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(
	otherlv_2=Colon
    {
    	newLeafNode(otherlv_2, grammarAccess.getDocGoalAccess().getColonKeyword_2_0());
    }
(
(
		lv_title_3_0=RULE_STRING
		{
			newLeafNode(lv_title_3_0, grammarAccess.getDocGoalAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_3_0, 
        		"STRING");
	    }

)
))?(
	otherlv_4=For
    {
    	newLeafNode(otherlv_4, grammarAccess.getDocGoalAccess().getForKeyword_3_0());
    }
((
(
		lv_targetDescription_5_0=RULE_STRING
		{
			newLeafNode(lv_targetDescription_5_0, grammarAccess.getDocGoalAccess().getTargetDescriptionSTRINGTerminalRuleCall_3_1_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"targetDescription",
        		lv_targetDescription_5_0, 
        		"STRING");
	    }

)
)
    |((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getTargetComponentClassifierCrossReference_3_1_1_0_0()); 
	    }
		ruleAadlClassifierReference		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
        }
	otherlv_7=RULE_ID
	{
		newLeafNode(otherlv_7, grammarAccess.getDocGoalAccess().getTargetElementNamedElementCrossReference_3_1_1_1_0()); 
	}

)
)?)))?
	otherlv_8=LeftSquareBracket
    {
    	newLeafNode(otherlv_8, grammarAccess.getDocGoalAccess().getLeftSquareBracketKeyword_4());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 0);
	 				}
					({true}?=>(
	otherlv_10=Quality
    {
    	newLeafNode(otherlv_10, grammarAccess.getDocGoalAccess().getQualityKeyword_5_0_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
        }
	otherlv_11=RULE_ID
	{
		newLeafNode(otherlv_11, grammarAccess.getDocGoalAccess().getQualityCategoryQualityCategoryCrossReference_5_0_1_0()); 
	}

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 1);
	 				}
					({true}?=>(
	otherlv_12=Category
    {
    	newLeafNode(otherlv_12, grammarAccess.getDocGoalAccess().getCategoryKeyword_5_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
        }
	otherlv_13=RULE_ID
	{
		newLeafNode(otherlv_13, grammarAccess.getDocGoalAccess().getUserCategoryUserCategoryCrossReference_5_1_1_0()); 
	}

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getDescriptionDescriptionParserRuleCall_5_2_0()); 
	    }
		lv_description_14_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocGoalRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_14_0, 
        		"Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 3);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getConstantsValDeclarationParserRuleCall_5_3_0()); 
	    }
		lv_constants_15_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocGoalRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_15_0, 
        		"ValDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 4);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getWhenconditionWhenConditionParserRuleCall_5_4_0()); 
	    }
		lv_whencondition_16_0=ruleWhenCondition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocGoalRule());
	        }
       		set(
       			$current, 
       			"whencondition",
        		lv_whencondition_16_0, 
        		"WhenCondition");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 5);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getRationaleRationaleParserRuleCall_5_5_0()); 
	    }
		lv_rationale_17_0=ruleRationale		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocGoalRule());
	        }
       		set(
       			$current, 
       			"rationale",
        		lv_rationale_17_0, 
        		"Rationale");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 6)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 6);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_6_0()); 
	    }
		lv_changeUncertainty_18_0=ruleUncertainty		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocGoalRule());
	        }
       		set(
       			$current, 
       			"changeUncertainty",
        		lv_changeUncertainty_18_0, 
        		"Uncertainty");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 7)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 7);
	 				}
					({true}?=>(
	otherlv_19=Refines
    {
    	newLeafNode(otherlv_19, grammarAccess.getDocGoalAccess().getRefinesKeyword_5_7_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getRefinesReferenceGoalCrossReference_5_7_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 8)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 8);
	 				}
					({true}?=>(
	otherlv_21=Conflicts
    {
    	newLeafNode(otherlv_21, grammarAccess.getDocGoalAccess().getConflictsKeyword_5_8_0());
    }

	otherlv_22=With
    {
    	newLeafNode(otherlv_22, grammarAccess.getDocGoalAccess().getWithKeyword_5_8_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getConflictsReferenceGoalCrossReference_5_8_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 9)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 9);
	 				}
					({true}?=>(
	otherlv_24=Evolves
    {
    	newLeafNode(otherlv_24, grammarAccess.getDocGoalAccess().getEvolvesKeyword_5_9_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getEvolvesReferenceRequirementCrossReference_5_9_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 10)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 10);
	 				}
					({true}?=>((
(
		lv_dropped_26_0=
	Dropped
    {
        newLeafNode(lv_dropped_26_0, grammarAccess.getDocGoalAccess().getDroppedDroppedKeyword_5_10_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
       		setWithLastConsumed($current, "dropped", true, "dropped");
	    }

)
)(
(
		lv_dropRationale_27_0=RULE_STRING
		{
			newLeafNode(lv_dropRationale_27_0, grammarAccess.getDocGoalAccess().getDropRationaleSTRINGTerminalRuleCall_5_10_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"dropRationale",
        		lv_dropRationale_27_0, 
        		"STRING");
	    }

)
)?))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 11)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 11);
	 				}
					({true}?=>(
	otherlv_28=Stakeholder
    {
    	newLeafNode(otherlv_28, grammarAccess.getDocGoalAccess().getStakeholderKeyword_5_11_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_11_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 12)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 12);
	 				}
					({true}?=>(
	otherlv_30=See
    {
    	newLeafNode(otherlv_30, grammarAccess.getDocGoalAccess().getSeeKeyword_5_12_0());
    }

	otherlv_31=Document
    {
    	newLeafNode(otherlv_31, grammarAccess.getDocGoalAccess().getDocumentKeyword_5_12_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_12_2_0()); 
	    }
		lv_docReference_32_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocGoalRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_32_0, 
        		"ExternalDocument");
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 13)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 13);
	 				}
					({true}?=>(
	otherlv_33=Issues
    {
    	newLeafNode(otherlv_33, grammarAccess.getDocGoalAccess().getIssuesKeyword_5_13_0());
    }
(
(
		lv_issues_34_0=RULE_STRING
		{
			newLeafNode(lv_issues_34_0, grammarAccess.getDocGoalAccess().getIssuesSTRINGTerminalRuleCall_5_13_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_34_0, 
        		"STRING");
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	}

)
	otherlv_35=RightSquareBracket
    {
    	newLeafNode(otherlv_35, grammarAccess.getDocGoalAccess().getRightSquareBracketKeyword_6());
    }
)
;





// Entry rule entryRuleGoal
entryRuleGoal returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getGoalRule()); }
	 iv_ruleGoal=ruleGoal 
	 { $current=$iv_ruleGoal.current; } 
	 EOF 
;

// Rule Goal
ruleGoal returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Goal
    {
    	newLeafNode(otherlv_0, grammarAccess.getGoalAccess().getGoalKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getGoalAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(
	otherlv_2=Colon
    {
    	newLeafNode(otherlv_2, grammarAccess.getGoalAccess().getColonKeyword_2_0());
    }
(
(
		lv_title_3_0=RULE_STRING
		{
			newLeafNode(lv_title_3_0, grammarAccess.getGoalAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_3_0, 
        		"STRING");
	    }

)
))?(
	otherlv_4=For
    {
    	newLeafNode(otherlv_4, grammarAccess.getGoalAccess().getForKeyword_3_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
	otherlv_5=RULE_ID
	{
		newLeafNode(otherlv_5, grammarAccess.getGoalAccess().getTargetElementNamedElementCrossReference_3_1_0()); 
	}

)
))?
	otherlv_6=LeftSquareBracket
    {
    	newLeafNode(otherlv_6, grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_4());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0);
	 				}
					({true}?=>(
	otherlv_8=Quality
    {
    	newLeafNode(otherlv_8, grammarAccess.getGoalAccess().getQualityKeyword_5_0_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
	otherlv_9=RULE_ID
	{
		newLeafNode(otherlv_9, grammarAccess.getGoalAccess().getQualityCategoryQualityCategoryCrossReference_5_0_1_0()); 
	}

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1);
	 				}
					({true}?=>(
	otherlv_10=Category
    {
    	newLeafNode(otherlv_10, grammarAccess.getGoalAccess().getCategoryKeyword_5_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
	otherlv_11=RULE_ID
	{
		newLeafNode(otherlv_11, grammarAccess.getGoalAccess().getUserCategoryUserCategoryCrossReference_5_1_1_0()); 
	}

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getDescriptionDescriptionParserRuleCall_5_2_0()); 
	    }
		lv_description_12_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGoalRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_12_0, 
        		"Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getConstantsValDeclarationParserRuleCall_5_3_0()); 
	    }
		lv_constants_13_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGoalRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_13_0, 
        		"ValDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getWhenconditionWhenConditionParserRuleCall_5_4_0()); 
	    }
		lv_whencondition_14_0=ruleWhenCondition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGoalRule());
	        }
       		set(
       			$current, 
       			"whencondition",
        		lv_whencondition_14_0, 
        		"WhenCondition");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getRationaleRationaleParserRuleCall_5_5_0()); 
	    }
		lv_rationale_15_0=ruleRationale		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGoalRule());
	        }
       		set(
       			$current, 
       			"rationale",
        		lv_rationale_15_0, 
        		"Rationale");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_6_0()); 
	    }
		lv_changeUncertainty_16_0=ruleUncertainty		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGoalRule());
	        }
       		set(
       			$current, 
       			"changeUncertainty",
        		lv_changeUncertainty_16_0, 
        		"Uncertainty");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7);
	 				}
					({true}?=>(
	otherlv_17=Refines
    {
    	newLeafNode(otherlv_17, grammarAccess.getGoalAccess().getRefinesKeyword_5_7_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_7_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8);
	 				}
					({true}?=>(
	otherlv_19=Conflicts
    {
    	newLeafNode(otherlv_19, grammarAccess.getGoalAccess().getConflictsKeyword_5_8_0());
    }

	otherlv_20=With
    {
    	newLeafNode(otherlv_20, grammarAccess.getGoalAccess().getWithKeyword_5_8_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_8_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9);
	 				}
					({true}?=>(
	otherlv_22=Evolves
    {
    	newLeafNode(otherlv_22, grammarAccess.getGoalAccess().getEvolvesKeyword_5_9_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceRequirementCrossReference_5_9_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10);
	 				}
					({true}?=>((
(
		lv_dropped_24_0=
	Dropped
    {
        newLeafNode(lv_dropped_24_0, grammarAccess.getGoalAccess().getDroppedDroppedKeyword_5_10_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
       		setWithLastConsumed($current, "dropped", true, "dropped");
	    }

)
)(
(
		lv_dropRationale_25_0=RULE_STRING
		{
			newLeafNode(lv_dropRationale_25_0, grammarAccess.getGoalAccess().getDropRationaleSTRINGTerminalRuleCall_5_10_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"dropRationale",
        		lv_dropRationale_25_0, 
        		"STRING");
	    }

)
)?))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11);
	 				}
					({true}?=>(
	otherlv_26=Stakeholder
    {
    	newLeafNode(otherlv_26, grammarAccess.getGoalAccess().getStakeholderKeyword_5_11_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_11_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12);
	 				}
					({true}?=>(
	otherlv_28=See
    {
    	newLeafNode(otherlv_28, grammarAccess.getGoalAccess().getSeeKeyword_5_12_0());
    }

	otherlv_29=Goal
    {
    	newLeafNode(otherlv_29, grammarAccess.getGoalAccess().getGoalKeyword_5_12_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getGoalReferenceGoalCrossReference_5_12_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13);
	 				}
					({true}?=>(
	otherlv_31=See
    {
    	newLeafNode(otherlv_31, grammarAccess.getGoalAccess().getSeeKeyword_5_13_0());
    }

	otherlv_32=Document
    {
    	newLeafNode(otherlv_32, grammarAccess.getGoalAccess().getDocumentKeyword_5_13_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_13_2_0()); 
	    }
		lv_docReference_33_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGoalRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_33_0, 
        		"ExternalDocument");
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 14)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 14);
	 				}
					({true}?=>(
	otherlv_34=Issues
    {
    	newLeafNode(otherlv_34, grammarAccess.getGoalAccess().getIssuesKeyword_5_14_0());
    }
(
(
		lv_issues_35_0=RULE_STRING
		{
			newLeafNode(lv_issues_35_0, grammarAccess.getGoalAccess().getIssuesSTRINGTerminalRuleCall_5_14_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_35_0, 
        		"STRING");
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	}

)
	otherlv_36=RightSquareBracket
    {
    	newLeafNode(otherlv_36, grammarAccess.getGoalAccess().getRightSquareBracketKeyword_6());
    }
)
;





// Entry rule entryRuleSystemRequirement
entryRuleSystemRequirement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getSystemRequirementRule()); }
	 iv_ruleSystemRequirement=ruleSystemRequirement 
	 { $current=$iv_ruleSystemRequirement.current; } 
	 EOF 
;

// Rule SystemRequirement
ruleSystemRequirement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Requirement
    {
    	newLeafNode(otherlv_0, grammarAccess.getSystemRequirementAccess().getRequirementKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getSystemRequirementAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(
	otherlv_2=Colon
    {
    	newLeafNode(otherlv_2, grammarAccess.getSystemRequirementAccess().getColonKeyword_2_0());
    }
(
(
		lv_title_3_0=RULE_STRING
		{
			newLeafNode(lv_title_3_0, grammarAccess.getSystemRequirementAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_3_0, 
        		"STRING");
	    }

)
))?(
	otherlv_4=For
    {
    	newLeafNode(otherlv_4, grammarAccess.getSystemRequirementAccess().getForKeyword_3_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
	otherlv_5=RULE_ID
	{
		newLeafNode(otherlv_5, grammarAccess.getSystemRequirementAccess().getTargetElementNamedElementCrossReference_3_1_0()); 
	}

)
))?
	otherlv_6=LeftSquareBracket
    {
    	newLeafNode(otherlv_6, grammarAccess.getSystemRequirementAccess().getLeftSquareBracketKeyword_4());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 0);
	 				}
					({true}?=>(
	otherlv_8=Quality
    {
    	newLeafNode(otherlv_8, grammarAccess.getSystemRequirementAccess().getQualityKeyword_5_0_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
	otherlv_9=RULE_ID
	{
		newLeafNode(otherlv_9, grammarAccess.getSystemRequirementAccess().getQualityCategoryQualityCategoryCrossReference_5_0_1_0()); 
	}

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 1);
	 				}
					({true}?=>(
	otherlv_10=Category
    {
    	newLeafNode(otherlv_10, grammarAccess.getSystemRequirementAccess().getCategoryKeyword_5_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
	otherlv_11=RULE_ID
	{
		newLeafNode(otherlv_11, grammarAccess.getSystemRequirementAccess().getUserCategoryUserCategoryCrossReference_5_1_1_0()); 
	}

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getDescriptionDescriptionParserRuleCall_5_2_0()); 
	    }
		lv_description_12_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_12_0, 
        		"Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 3);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getConstantsValDeclarationParserRuleCall_5_3_0()); 
	    }
		lv_constants_13_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_13_0, 
        		"ValDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 4);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getComputesComputeDeclarationParserRuleCall_5_4_0()); 
	    }
		lv_computes_14_0=ruleComputeDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		add(
       			$current, 
       			"computes",
        		lv_computes_14_0, 
        		"ComputeDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 5);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getWhenconditionWhenConditionParserRuleCall_5_5_0()); 
	    }
		lv_whencondition_15_0=ruleWhenCondition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		set(
       			$current, 
       			"whencondition",
        		lv_whencondition_15_0, 
        		"WhenCondition");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 6)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 6);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getPredicateReqPredicateParserRuleCall_5_6_0()); 
	    }
		lv_predicate_16_0=ruleReqPredicate		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		set(
       			$current, 
       			"predicate",
        		lv_predicate_16_0, 
        		"ReqPredicate");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 7)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 7);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getRationaleRationaleParserRuleCall_5_7_0()); 
	    }
		lv_rationale_17_0=ruleRationale		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		set(
       			$current, 
       			"rationale",
        		lv_rationale_17_0, 
        		"Rationale");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 8)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 8);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_8_0()); 
	    }
		lv_changeUncertainty_18_0=ruleUncertainty		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		set(
       			$current, 
       			"changeUncertainty",
        		lv_changeUncertainty_18_0, 
        		"Uncertainty");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 9)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 9);
	 				}
					({true}?=>(
	otherlv_19=Mitigates
    {
    	newLeafNode(otherlv_19, grammarAccess.getSystemRequirementAccess().getMitigatesKeyword_5_9_0());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
	otherlv_20=RULE_ID
	{
		newLeafNode(otherlv_20, grammarAccess.getSystemRequirementAccess().getExceptionEObjectCrossReference_5_9_1_0_0()); 
	}

)
)
    |(
(
		lv_exceptionText_21_0=RULE_STRING
		{
			newLeafNode(lv_exceptionText_21_0, grammarAccess.getSystemRequirementAccess().getExceptionTextSTRINGTerminalRuleCall_5_9_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exceptionText",
        		lv_exceptionText_21_0, 
        		"STRING");
	    }

)
))))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 10)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 10);
	 				}
					({true}?=>(
	otherlv_22=Refines
    {
    	newLeafNode(otherlv_22, grammarAccess.getSystemRequirementAccess().getRefinesKeyword_5_10_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getRefinesReferenceRequirementCrossReference_5_10_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 11)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 11);
	 				}
					({true}?=>(
	otherlv_24=Decomposes
    {
    	newLeafNode(otherlv_24, grammarAccess.getSystemRequirementAccess().getDecomposesKeyword_5_11_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getDecomposesReferenceRequirementCrossReference_5_11_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 12)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 12);
	 				}
					({true}?=>(
	otherlv_26=Evolves
    {
    	newLeafNode(otherlv_26, grammarAccess.getSystemRequirementAccess().getEvolvesKeyword_5_12_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getEvolvesReferenceRequirementCrossReference_5_12_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 13)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 13);
	 				}
					({true}?=>((
(
		lv_dropped_28_0=
	Dropped
    {
        newLeafNode(lv_dropped_28_0, grammarAccess.getSystemRequirementAccess().getDroppedDroppedKeyword_5_13_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
       		setWithLastConsumed($current, "dropped", true, "dropped");
	    }

)
)(
(
		lv_dropRationale_29_0=RULE_STRING
		{
			newLeafNode(lv_dropRationale_29_0, grammarAccess.getSystemRequirementAccess().getDropRationaleSTRINGTerminalRuleCall_5_13_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"dropRationale",
        		lv_dropRationale_29_0, 
        		"STRING");
	    }

)
)?))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 14)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 14);
	 				}
					({true}?=>(
	otherlv_30=Development
    {
    	newLeafNode(otherlv_30, grammarAccess.getSystemRequirementAccess().getDevelopmentKeyword_5_14_0());
    }

	otherlv_31=Stakeholder
    {
    	newLeafNode(otherlv_31, grammarAccess.getSystemRequirementAccess().getStakeholderKeyword_5_14_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getDevelopmentStakeholderStakeholderCrossReference_5_14_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 15)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 15);
	 				}
					({true}?=>(
	otherlv_33=See
    {
    	newLeafNode(otherlv_33, grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_15_0());
    }

	otherlv_34=Goal
    {
    	newLeafNode(otherlv_34, grammarAccess.getSystemRequirementAccess().getGoalKeyword_5_15_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getGoalReferenceGoalCrossReference_5_15_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 16)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 16);
	 				}
					({true}?=>(
	otherlv_36=See
    {
    	newLeafNode(otherlv_36, grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_16_0());
    }

	otherlv_37=Requirement
    {
    	newLeafNode(otherlv_37, grammarAccess.getSystemRequirementAccess().getRequirementKeyword_5_16_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getRequirementReferenceRequirementCrossReference_5_16_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 17)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 17);
	 				}
					({true}?=>(
	otherlv_39=See
    {
    	newLeafNode(otherlv_39, grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_17_0());
    }

	otherlv_40=Document
    {
    	newLeafNode(otherlv_40, grammarAccess.getSystemRequirementAccess().getDocumentKeyword_5_17_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_17_2_0()); 
	    }
		lv_docReference_41_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_41_0, 
        		"ExternalDocument");
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 18)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), 18);
	 				}
					({true}?=>(
	otherlv_42=Issues
    {
    	newLeafNode(otherlv_42, grammarAccess.getSystemRequirementAccess().getIssuesKeyword_5_18_0());
    }
(
(
		lv_issues_43_0=RULE_STRING
		{
			newLeafNode(lv_issues_43_0, grammarAccess.getSystemRequirementAccess().getIssuesSTRINGTerminalRuleCall_5_18_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_43_0, 
        		"STRING");
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5());
	}

)
	otherlv_44=RightSquareBracket
    {
    	newLeafNode(otherlv_44, grammarAccess.getSystemRequirementAccess().getRightSquareBracketKeyword_6());
    }
)
;





// Entry rule entryRuleGlobalRequirement
entryRuleGlobalRequirement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getGlobalRequirementRule()); }
	 iv_ruleGlobalRequirement=ruleGlobalRequirement 
	 { $current=$iv_ruleGlobalRequirement.current; } 
	 EOF 
;

// Rule GlobalRequirement
ruleGlobalRequirement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Requirement
    {
    	newLeafNode(otherlv_0, grammarAccess.getGlobalRequirementAccess().getRequirementKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getGlobalRequirementAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(
	otherlv_2=Colon
    {
    	newLeafNode(otherlv_2, grammarAccess.getGlobalRequirementAccess().getColonKeyword_2_0());
    }
(
(
		lv_title_3_0=RULE_STRING
		{
			newLeafNode(lv_title_3_0, grammarAccess.getGlobalRequirementAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_3_0, 
        		"STRING");
	    }

)
))?(
	otherlv_4=For
    {
    	newLeafNode(otherlv_4, grammarAccess.getGlobalRequirementAccess().getForKeyword_3_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getComponentCategoryComponentCategoryParserRuleCall_3_1_0_0()); 
	    }
		lv_componentCategory_5_0=ruleComponentCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		add(
       			$current, 
       			"componentCategory",
        		lv_componentCategory_5_0, 
        		"ComponentCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+
    |(
(
		lv_connections_6_0=
	Connections
    {
        newLeafNode(lv_connections_6_0, grammarAccess.getGlobalRequirementAccess().getConnectionsConnectionsKeyword_3_1_1_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
       		setWithLastConsumed($current, "connections", true, "connections");
	    }

)
)))?
	otherlv_7=LeftSquareBracket
    {
    	newLeafNode(otherlv_7, grammarAccess.getGlobalRequirementAccess().getLeftSquareBracketKeyword_4());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 0);
	 				}
					({true}?=>(
	otherlv_9=Quality
    {
    	newLeafNode(otherlv_9, grammarAccess.getGlobalRequirementAccess().getQualityKeyword_5_0_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
	otherlv_10=RULE_ID
	{
		newLeafNode(otherlv_10, grammarAccess.getGlobalRequirementAccess().getQualityCategoryQualityCategoryCrossReference_5_0_1_0()); 
	}

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 1);
	 				}
					({true}?=>(
	otherlv_11=Category
    {
    	newLeafNode(otherlv_11, grammarAccess.getGlobalRequirementAccess().getCategoryKeyword_5_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
	otherlv_12=RULE_ID
	{
		newLeafNode(otherlv_12, grammarAccess.getGlobalRequirementAccess().getUserCategoryUserCategoryCrossReference_5_1_1_0()); 
	}

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getDescriptionDescriptionParserRuleCall_5_2_0()); 
	    }
		lv_description_13_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_13_0, 
        		"Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 3);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getConstantsValDeclarationParserRuleCall_5_3_0()); 
	    }
		lv_constants_14_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_14_0, 
        		"ValDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 4);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getComputesComputeDeclarationParserRuleCall_5_4_0()); 
	    }
		lv_computes_15_0=ruleComputeDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		add(
       			$current, 
       			"computes",
        		lv_computes_15_0, 
        		"ComputeDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 5);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getWhenconditionWhenConditionParserRuleCall_5_5_0()); 
	    }
		lv_whencondition_16_0=ruleWhenCondition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		set(
       			$current, 
       			"whencondition",
        		lv_whencondition_16_0, 
        		"WhenCondition");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 6)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 6);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getPredicateReqPredicateParserRuleCall_5_6_0()); 
	    }
		lv_predicate_17_0=ruleReqPredicate		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		set(
       			$current, 
       			"predicate",
        		lv_predicate_17_0, 
        		"ReqPredicate");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 7)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 7);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getRationaleRationaleParserRuleCall_5_7_0()); 
	    }
		lv_rationale_18_0=ruleRationale		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		set(
       			$current, 
       			"rationale",
        		lv_rationale_18_0, 
        		"Rationale");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 8)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 8);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_8_0()); 
	    }
		lv_changeUncertainty_19_0=ruleUncertainty		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		set(
       			$current, 
       			"changeUncertainty",
        		lv_changeUncertainty_19_0, 
        		"Uncertainty");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 9)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 9);
	 				}
					({true}?=>(
	otherlv_20=Mitigates
    {
    	newLeafNode(otherlv_20, grammarAccess.getGlobalRequirementAccess().getMitigatesKeyword_5_9_0());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
	otherlv_21=RULE_ID
	{
		newLeafNode(otherlv_21, grammarAccess.getGlobalRequirementAccess().getExceptionEObjectCrossReference_5_9_1_0_0()); 
	}

)
)
    |(
(
		lv_exceptionText_22_0=RULE_STRING
		{
			newLeafNode(lv_exceptionText_22_0, grammarAccess.getGlobalRequirementAccess().getExceptionTextSTRINGTerminalRuleCall_5_9_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exceptionText",
        		lv_exceptionText_22_0, 
        		"STRING");
	    }

)
))))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 10)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 10);
	 				}
					({true}?=>(
	otherlv_23=Refines
    {
    	newLeafNode(otherlv_23, grammarAccess.getGlobalRequirementAccess().getRefinesKeyword_5_10_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getRefinesReferenceRequirementCrossReference_5_10_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 11)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 11);
	 				}
					({true}?=>(
	otherlv_25=Decomposes
    {
    	newLeafNode(otherlv_25, grammarAccess.getGlobalRequirementAccess().getDecomposesKeyword_5_11_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getDecomposesReferenceRequirementCrossReference_5_11_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 12)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 12);
	 				}
					({true}?=>(
	otherlv_27=Evolves
    {
    	newLeafNode(otherlv_27, grammarAccess.getGlobalRequirementAccess().getEvolvesKeyword_5_12_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getEvolvesReferenceRequirementCrossReference_5_12_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 13)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 13);
	 				}
					({true}?=>((
(
		lv_dropped_29_0=
	Dropped
    {
        newLeafNode(lv_dropped_29_0, grammarAccess.getGlobalRequirementAccess().getDroppedDroppedKeyword_5_13_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
       		setWithLastConsumed($current, "dropped", true, "dropped");
	    }

)
)(
(
		lv_dropRationale_30_0=RULE_STRING
		{
			newLeafNode(lv_dropRationale_30_0, grammarAccess.getGlobalRequirementAccess().getDropRationaleSTRINGTerminalRuleCall_5_13_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"dropRationale",
        		lv_dropRationale_30_0, 
        		"STRING");
	    }

)
)?))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 14)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 14);
	 				}
					({true}?=>(
	otherlv_31=Development
    {
    	newLeafNode(otherlv_31, grammarAccess.getGlobalRequirementAccess().getDevelopmentKeyword_5_14_0());
    }

	otherlv_32=Stakeholder
    {
    	newLeafNode(otherlv_32, grammarAccess.getGlobalRequirementAccess().getStakeholderKeyword_5_14_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getDevelopmentStakeholderStakeholderCrossReference_5_14_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 15)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 15);
	 				}
					({true}?=>(
	otherlv_34=See
    {
    	newLeafNode(otherlv_34, grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_15_0());
    }

	otherlv_35=Goal
    {
    	newLeafNode(otherlv_35, grammarAccess.getGlobalRequirementAccess().getGoalKeyword_5_15_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getGoalReferenceGoalCrossReference_5_15_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 16)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 16);
	 				}
					({true}?=>(
	otherlv_37=See
    {
    	newLeafNode(otherlv_37, grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_16_0());
    }

	otherlv_38=Requirement
    {
    	newLeafNode(otherlv_38, grammarAccess.getGlobalRequirementAccess().getRequirementKeyword_5_16_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getRequirementReferenceRequirementCrossReference_5_16_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 17)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 17);
	 				}
					({true}?=>(
	otherlv_40=See
    {
    	newLeafNode(otherlv_40, grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_17_0());
    }

	otherlv_41=Document
    {
    	newLeafNode(otherlv_41, grammarAccess.getGlobalRequirementAccess().getDocumentKeyword_5_17_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_17_2_0()); 
	    }
		lv_docReference_42_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_42_0, 
        		"ExternalDocument");
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 18)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 18);
	 				}
					({true}?=>(
	otherlv_43=Issues
    {
    	newLeafNode(otherlv_43, grammarAccess.getGlobalRequirementAccess().getIssuesKeyword_5_18_0());
    }
(
(
		lv_issues_44_0=RULE_STRING
		{
			newLeafNode(lv_issues_44_0, grammarAccess.getGlobalRequirementAccess().getIssuesSTRINGTerminalRuleCall_5_18_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_44_0, 
        		"STRING");
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	}

)
	otherlv_45=RightSquareBracket
    {
    	newLeafNode(otherlv_45, grammarAccess.getGlobalRequirementAccess().getRightSquareBracketKeyword_6());
    }
)
;





// Entry rule entryRuleDocRequirement
entryRuleDocRequirement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getDocRequirementRule()); }
	 iv_ruleDocRequirement=ruleDocRequirement 
	 { $current=$iv_ruleDocRequirement.current; } 
	 EOF 
;

// Rule DocRequirement
ruleDocRequirement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Requirement
    {
    	newLeafNode(otherlv_0, grammarAccess.getDocRequirementAccess().getRequirementKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getDocRequirementAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(
	otherlv_2=Colon
    {
    	newLeafNode(otherlv_2, grammarAccess.getDocRequirementAccess().getColonKeyword_2_0());
    }
(
(
		lv_title_3_0=RULE_STRING
		{
			newLeafNode(lv_title_3_0, grammarAccess.getDocRequirementAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_3_0, 
        		"STRING");
	    }

)
))?(
	otherlv_4=For
    {
    	newLeafNode(otherlv_4, grammarAccess.getDocRequirementAccess().getForKeyword_3_0());
    }
((
(
		lv_targetDescription_5_0=RULE_STRING
		{
			newLeafNode(lv_targetDescription_5_0, grammarAccess.getDocRequirementAccess().getTargetDescriptionSTRINGTerminalRuleCall_3_1_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"targetDescription",
        		lv_targetDescription_5_0, 
        		"STRING");
	    }

)
)
    |((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getTargetComponentClassifierCrossReference_3_1_1_0_0()); 
	    }
		ruleAadlClassifierReference		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
	otherlv_7=RULE_ID
	{
		newLeafNode(otherlv_7, grammarAccess.getDocRequirementAccess().getTargetElementNamedElementCrossReference_3_1_1_1_0()); 
	}

)
)?)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getComponentCategoryComponentCategoryParserRuleCall_3_1_2_0()); 
	    }
		lv_componentCategory_8_0=ruleComponentCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		add(
       			$current, 
       			"componentCategory",
        		lv_componentCategory_8_0, 
        		"ComponentCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+))?
	otherlv_9=LeftSquareBracket
    {
    	newLeafNode(otherlv_9, grammarAccess.getDocRequirementAccess().getLeftSquareBracketKeyword_4());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 0);
	 				}
					({true}?=>(
	otherlv_11=Quality
    {
    	newLeafNode(otherlv_11, grammarAccess.getDocRequirementAccess().getQualityKeyword_5_0_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
	otherlv_12=RULE_ID
	{
		newLeafNode(otherlv_12, grammarAccess.getDocRequirementAccess().getQualityCategoryQualityCategoryCrossReference_5_0_1_0()); 
	}

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 1);
	 				}
					({true}?=>(
	otherlv_13=Category
    {
    	newLeafNode(otherlv_13, grammarAccess.getDocRequirementAccess().getCategoryKeyword_5_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
	otherlv_14=RULE_ID
	{
		newLeafNode(otherlv_14, grammarAccess.getDocRequirementAccess().getUserCategoryUserCategoryCrossReference_5_1_1_0()); 
	}

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getDescriptionDescriptionParserRuleCall_5_2_0()); 
	    }
		lv_description_15_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_15_0, 
        		"Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 3);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getConstantsValDeclarationParserRuleCall_5_3_0()); 
	    }
		lv_constants_16_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_16_0, 
        		"ValDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 4);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getComputesComputeDeclarationParserRuleCall_5_4_0()); 
	    }
		lv_computes_17_0=ruleComputeDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		add(
       			$current, 
       			"computes",
        		lv_computes_17_0, 
        		"ComputeDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 5);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getWhenconditionWhenConditionParserRuleCall_5_5_0()); 
	    }
		lv_whencondition_18_0=ruleWhenCondition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		set(
       			$current, 
       			"whencondition",
        		lv_whencondition_18_0, 
        		"WhenCondition");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 6)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 6);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getPredicateReqPredicateParserRuleCall_5_6_0()); 
	    }
		lv_predicate_19_0=ruleReqPredicate		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		set(
       			$current, 
       			"predicate",
        		lv_predicate_19_0, 
        		"ReqPredicate");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 7)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 7);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getRationaleRationaleParserRuleCall_5_7_0()); 
	    }
		lv_rationale_20_0=ruleRationale		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		set(
       			$current, 
       			"rationale",
        		lv_rationale_20_0, 
        		"Rationale");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 8)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 8);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_8_0()); 
	    }
		lv_changeUncertainty_21_0=ruleUncertainty		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		set(
       			$current, 
       			"changeUncertainty",
        		lv_changeUncertainty_21_0, 
        		"Uncertainty");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 9)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 9);
	 				}
					({true}?=>(
	otherlv_22=Mitigates
    {
    	newLeafNode(otherlv_22, grammarAccess.getDocRequirementAccess().getMitigatesKeyword_5_9_0());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
	otherlv_23=RULE_ID
	{
		newLeafNode(otherlv_23, grammarAccess.getDocRequirementAccess().getExceptionEObjectCrossReference_5_9_1_0_0()); 
	}

)
)
    |(
(
		lv_exceptionText_24_0=RULE_STRING
		{
			newLeafNode(lv_exceptionText_24_0, grammarAccess.getDocRequirementAccess().getExceptionTextSTRINGTerminalRuleCall_5_9_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exceptionText",
        		lv_exceptionText_24_0, 
        		"STRING");
	    }

)
))))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 10)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 10);
	 				}
					({true}?=>(
	otherlv_25=Refines
    {
    	newLeafNode(otherlv_25, grammarAccess.getDocRequirementAccess().getRefinesKeyword_5_10_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getRefinesReferenceRequirementCrossReference_5_10_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 11)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 11);
	 				}
					({true}?=>(
	otherlv_27=Decomposes
    {
    	newLeafNode(otherlv_27, grammarAccess.getDocRequirementAccess().getDecomposesKeyword_5_11_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getDecomposesReferenceRequirementCrossReference_5_11_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 12)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 12);
	 				}
					({true}?=>(
	otherlv_29=Evolves
    {
    	newLeafNode(otherlv_29, grammarAccess.getDocRequirementAccess().getEvolvesKeyword_5_12_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getEvolvesReferenceRequirementCrossReference_5_12_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 13)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 13);
	 				}
					({true}?=>((
(
		lv_dropped_31_0=
	Dropped
    {
        newLeafNode(lv_dropped_31_0, grammarAccess.getDocRequirementAccess().getDroppedDroppedKeyword_5_13_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
       		setWithLastConsumed($current, "dropped", true, "dropped");
	    }

)
)(
(
		lv_dropRationale_32_0=RULE_STRING
		{
			newLeafNode(lv_dropRationale_32_0, grammarAccess.getDocRequirementAccess().getDropRationaleSTRINGTerminalRuleCall_5_13_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"dropRationale",
        		lv_dropRationale_32_0, 
        		"STRING");
	    }

)
)?))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 14)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 14);
	 				}
					({true}?=>(
	otherlv_33=Development
    {
    	newLeafNode(otherlv_33, grammarAccess.getDocRequirementAccess().getDevelopmentKeyword_5_14_0());
    }

	otherlv_34=Stakeholder
    {
    	newLeafNode(otherlv_34, grammarAccess.getDocRequirementAccess().getStakeholderKeyword_5_14_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getDevelopmentStakeholderStakeholderCrossReference_5_14_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 15)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 15);
	 				}
					({true}?=>(
	otherlv_36=See
    {
    	newLeafNode(otherlv_36, grammarAccess.getDocRequirementAccess().getSeeKeyword_5_15_0());
    }

	otherlv_37=Goal
    {
    	newLeafNode(otherlv_37, grammarAccess.getDocRequirementAccess().getGoalKeyword_5_15_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getGoalReferenceGoalCrossReference_5_15_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 16)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 16);
	 				}
					({true}?=>(
	otherlv_39=See
    {
    	newLeafNode(otherlv_39, grammarAccess.getDocRequirementAccess().getSeeKeyword_5_16_0());
    }

	otherlv_40=Document
    {
    	newLeafNode(otherlv_40, grammarAccess.getDocRequirementAccess().getDocumentKeyword_5_16_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_16_2_0()); 
	    }
		lv_docReference_41_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_41_0, 
        		"ExternalDocument");
	        afterParserOrEnumRuleCall();
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 17)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 17);
	 				}
					({true}?=>(
	otherlv_42=Issues
    {
    	newLeafNode(otherlv_42, grammarAccess.getDocRequirementAccess().getIssuesKeyword_5_17_0());
    }
(
(
		lv_issues_43_0=RULE_STRING
		{
			newLeafNode(lv_issues_43_0, grammarAccess.getDocRequirementAccess().getIssuesSTRINGTerminalRuleCall_5_17_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_43_0, 
        		"STRING");
	    }

)
)+))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	}

)
	otherlv_44=RightSquareBracket
    {
    	newLeafNode(otherlv_44, grammarAccess.getDocRequirementAccess().getRightSquareBracketKeyword_6());
    }
)
;





// Entry rule entryRuleIncludeGlobalRequirement
entryRuleIncludeGlobalRequirement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getIncludeGlobalRequirementRule()); }
	 iv_ruleIncludeGlobalRequirement=ruleIncludeGlobalRequirement 
	 { $current=$iv_ruleIncludeGlobalRequirement.current; } 
	 EOF 
;

// Rule IncludeGlobalRequirement
ruleIncludeGlobalRequirement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Include
    {
    	newLeafNode(otherlv_0, grammarAccess.getIncludeGlobalRequirementAccess().getIncludeKeyword_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getIncludeGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getIncludeGlobalRequirementAccess().getIncludeEObjectCrossReference_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(
	otherlv_2=For
    {
    	newLeafNode(otherlv_2, grammarAccess.getIncludeGlobalRequirementAccess().getForKeyword_2_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getIncludeGlobalRequirementAccess().getComponentCategoryComponentCategoryParserRuleCall_2_1_0_0()); 
	    }
		lv_componentCategory_3_0=ruleComponentCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIncludeGlobalRequirementRule());
	        }
       		add(
       			$current, 
       			"componentCategory",
        		lv_componentCategory_3_0, 
        		"ComponentCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+
    |(
(
		lv_self_4_0=
	Self
    {
        newLeafNode(lv_self_4_0, grammarAccess.getIncludeGlobalRequirementAccess().getSelfSelfKeyword_2_1_1_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIncludeGlobalRequirementRule());
	        }
       		setWithLastConsumed($current, "self", true, "self");
	    }

)
)))?)
;





// Entry rule entryRuleWhenCondition
entryRuleWhenCondition returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getWhenConditionRule()); }
	 iv_ruleWhenCondition=ruleWhenCondition 
	 { $current=$iv_ruleWhenCondition.current; } 
	 EOF 
;

// Rule WhenCondition
ruleWhenCondition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=When
    {
    	newLeafNode(otherlv_0, grammarAccess.getWhenConditionAccess().getWhenKeyword_0());
    }
((
	otherlv_1=In
    {
    	newLeafNode(otherlv_1, grammarAccess.getWhenConditionAccess().getInKeyword_1_0_0());
    }

	otherlv_2=Mode
    {
    	newLeafNode(otherlv_2, grammarAccess.getWhenConditionAccess().getModeKeyword_1_0_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getWhenConditionRule());
	        }
        }
	otherlv_3=RULE_ID
	{
		newLeafNode(otherlv_3, grammarAccess.getWhenConditionAccess().getInModeModeCrossReference_1_0_2_0()); 
	}

)
)(
	otherlv_4=Comma
    {
    	newLeafNode(otherlv_4, grammarAccess.getWhenConditionAccess().getCommaKeyword_1_0_3_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getWhenConditionRule());
	        }
        }
	otherlv_5=RULE_ID
	{
		newLeafNode(otherlv_5, grammarAccess.getWhenConditionAccess().getInModeModeCrossReference_1_0_3_1_0()); 
	}

)
))*)
    |(
	otherlv_6=In
    {
    	newLeafNode(otherlv_6, grammarAccess.getWhenConditionAccess().getInKeyword_1_1_0());
    }

	otherlv_7=Error
    {
    	newLeafNode(otherlv_7, grammarAccess.getWhenConditionAccess().getErrorKeyword_1_1_1());
    }

	otherlv_8=State
    {
    	newLeafNode(otherlv_8, grammarAccess.getWhenConditionAccess().getStateKeyword_1_1_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getWhenConditionRule());
	        }
        }
	otherlv_9=RULE_ID
	{
		newLeafNode(otherlv_9, grammarAccess.getWhenConditionAccess().getInErrorStateErrorBehaviorStateCrossReference_1_1_3_0()); 
	}

)
)(
	otherlv_10=Comma
    {
    	newLeafNode(otherlv_10, grammarAccess.getWhenConditionAccess().getCommaKeyword_1_1_4_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getWhenConditionRule());
	        }
        }
	otherlv_11=RULE_ID
	{
		newLeafNode(otherlv_11, grammarAccess.getWhenConditionAccess().getInErrorStateErrorBehaviorStateCrossReference_1_1_4_1_0()); 
	}

)
))*)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getWhenConditionAccess().getConditionAExpressionParserRuleCall_1_2_0()); 
	    }
		lv_condition_12_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getWhenConditionRule());
	        }
       		set(
       			$current, 
       			"condition",
        		lv_condition_12_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)))
;





// Entry rule entryRuleReqPredicate
entryRuleReqPredicate returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getReqPredicateRule()); }
	 iv_ruleReqPredicate=ruleReqPredicate 
	 { $current=$iv_ruleReqPredicate.current; } 
	 EOF 
;

// Rule ReqPredicate
ruleReqPredicate returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getReqPredicateAccess().getInformalPredicateParserRuleCall_0()); 
    }
    this_InformalPredicate_0=ruleInformalPredicate
    {
        $current = $this_InformalPredicate_0.current;
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getReqPredicateAccess().getPredicateParserRuleCall_1()); 
    }
    this_Predicate_1=rulePredicate
    {
        $current = $this_Predicate_1.current;
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getReqPredicateAccess().getValuePredicateParserRuleCall_2()); 
    }
    this_ValuePredicate_2=ruleValuePredicate
    {
        $current = $this_ValuePredicate_2.current;
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleInformalPredicate
entryRuleInformalPredicate returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getInformalPredicateRule()); }
	 iv_ruleInformalPredicate=ruleInformalPredicate 
	 { $current=$iv_ruleInformalPredicate.current; } 
	 EOF 
;

// Rule InformalPredicate
ruleInformalPredicate returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Informal
    {
    	newLeafNode(otherlv_0, grammarAccess.getInformalPredicateAccess().getInformalKeyword_0());
    }

	otherlv_1=Predicate
    {
    	newLeafNode(otherlv_1, grammarAccess.getInformalPredicateAccess().getPredicateKeyword_1());
    }
(
(
		lv_description_2_0=RULE_STRING
		{
			newLeafNode(lv_description_2_0, grammarAccess.getInformalPredicateAccess().getDescriptionSTRINGTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getInformalPredicateRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"description",
        		lv_description_2_0, 
        		"STRING");
	    }

)
))
;





// Entry rule entryRulePredicate
entryRulePredicate returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPredicateRule()); }
	 iv_rulePredicate=rulePredicate 
	 { $current=$iv_rulePredicate.current; } 
	 EOF 
;

// Rule Predicate
rulePredicate returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Predicate
    {
    	newLeafNode(otherlv_0, grammarAccess.getPredicateAccess().getPredicateKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPredicateAccess().getXpressionAExpressionParserRuleCall_1_0()); 
	    }
		lv_xpression_1_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPredicateRule());
	        }
       		set(
       			$current, 
       			"xpression",
        		lv_xpression_1_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleValuePredicate
entryRuleValuePredicate returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getValuePredicateRule()); }
	 iv_ruleValuePredicate=ruleValuePredicate 
	 { $current=$iv_ruleValuePredicate.current; } 
	 EOF 
;

// Rule ValuePredicate
ruleValuePredicate returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Value
    {
    	newLeafNode(otherlv_0, grammarAccess.getValuePredicateAccess().getValueKeyword_0());
    }

	otherlv_1=Predicate
    {
    	newLeafNode(otherlv_1, grammarAccess.getValuePredicateAccess().getPredicateKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getValuePredicateAccess().getXpressionAAndExpressionParserRuleCall_2_0()); 
	    }
		lv_xpression_2_0=ruleAAndExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValuePredicateRule());
	        }
       		set(
       			$current, 
       			"xpression",
        		lv_xpression_2_0, 
        		"AAndExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getValuePredicateAccess().getDesiredValueDesiredValueParserRuleCall_3_0()); 
	    }
		lv_desiredValue_3_0=ruleDesiredValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValuePredicateRule());
	        }
       		set(
       			$current, 
       			"desiredValue",
        		lv_desiredValue_3_0, 
        		"DesiredValue");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleDesiredValue
entryRuleDesiredValue returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getDesiredValueRule()); }
	 iv_ruleDesiredValue=ruleDesiredValue 
	 { $current=$iv_ruleDesiredValue.current; } 
	 EOF 
;

// Rule DesiredValue
ruleDesiredValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
(
		lv_upto_0_0=
	Upto
    {
        newLeafNode(lv_upto_0_0, grammarAccess.getDesiredValueAccess().getUptoUptoKeyword_0_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDesiredValueRule());
	        }
       		setWithLastConsumed($current, "upto", true, "upto");
	    }

)
)
    |
	otherlv_1=Downto
    {
    	newLeafNode(otherlv_1, grammarAccess.getDesiredValueAccess().getDowntoKeyword_0_1());
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getDesiredValueAccess().getValueAExpressionParserRuleCall_1_0()); 
	    }
		lv_value_2_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDesiredValueRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_2_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleExternalDocument
entryRuleExternalDocument returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getExternalDocumentRule()); }
	 iv_ruleExternalDocument=ruleExternalDocument 
	 { $current=$iv_ruleExternalDocument.current; } 
	 EOF 
;

// Rule ExternalDocument
ruleExternalDocument returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocReferenceDOCPATHParserRuleCall_0_0()); 
	    }
		lv_docReference_0_0=ruleDOCPATH		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExternalDocumentRule());
	        }
       		set(
       			$current, 
       			"docReference",
        		lv_docReference_0_0, 
        		"DOCPATH");
	        afterParserOrEnumRuleCall();
	    }

)
)(
	otherlv_1=NumberSign
    {
    	newLeafNode(otherlv_1, grammarAccess.getExternalDocumentAccess().getNumberSignKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocFragmentDOCFRAGMENTParserRuleCall_1_1_0()); 
	    }
		lv_docFragment_2_0=ruleDOCFRAGMENT		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExternalDocumentRule());
	        }
       		set(
       			$current, 
       			"docFragment",
        		lv_docFragment_2_0, 
        		"DOCFRAGMENT");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;





// Entry rule entryRuleDOCPATH
entryRuleDOCPATH returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getDOCPATHRule()); } 
	 iv_ruleDOCPATH=ruleDOCPATH 
	 { $current=$iv_ruleDOCPATH.current.getText(); }  
	 EOF 
;

// Rule DOCPATH
ruleDOCPATH returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
((    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_0_0()); 
    }

	kw=Solidus 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDOCPATHAccess().getSolidusKeyword_0_1()); 
    }
)*    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_1()); 
    }

	kw=FullStop 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDOCPATHAccess().getFullStopKeyword_2()); 
    }
    this_ID_4=RULE_ID    {
		$current.merge(this_ID_4);
    }

    { 
    newLeafNode(this_ID_4, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_3()); 
    }
)
    ;





// Entry rule entryRuleDOCFRAGMENT
entryRuleDOCFRAGMENT returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getDOCFRAGMENTRule()); } 
	 iv_ruleDOCFRAGMENT=ruleDOCFRAGMENT 
	 { $current=$iv_ruleDOCFRAGMENT.current.getText(); }  
	 EOF 
;

// Rule DOCFRAGMENT
ruleDOCFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw=FullStop 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDOCFRAGMENTAccess().getFullStopKeyword_1_0()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_1_1()); 
    }
)*)
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
(
	otherlv_0=Description
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
		lv_thisTarget_2_0=
	This
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
(
	otherlv_0=Rationale
    {
    	newLeafNode(otherlv_0, grammarAccess.getRationaleAccess().getRationaleKeyword_0());
    }
(
(
		lv_text_1_0=RULE_STRING
		{
			newLeafNode(lv_text_1_0, grammarAccess.getRationaleAccess().getTextSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRationaleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"text",
        		lv_text_1_0, 
        		"STRING");
	    }

)
))
;





// Entry rule entryRuleUncertainty
entryRuleUncertainty returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getUncertaintyRule()); }
	 iv_ruleUncertainty=ruleUncertainty 
	 { $current=$iv_ruleUncertainty.current; } 
	 EOF 
;

// Rule Uncertainty
ruleUncertainty returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Uncertainty
    {
    	newLeafNode(otherlv_0, grammarAccess.getUncertaintyAccess().getUncertaintyKeyword_0());
    }

	otherlv_1=LeftSquareBracket
    {
    	newLeafNode(otherlv_1, grammarAccess.getUncertaintyAccess().getLeftSquareBracketKeyword_1());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getUncertaintyAccess().getUnorderedGroup_2());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUncertaintyAccess().getUnorderedGroup_2(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getUncertaintyAccess().getUnorderedGroup_2(), 0);
	 				}
					({true}?=>(
	otherlv_3=Volatility
    {
    	newLeafNode(otherlv_3, grammarAccess.getUncertaintyAccess().getVolatilityKeyword_2_0_0());
    }
(
(
		lv_volatility_4_0=RULE_INT
		{
			newLeafNode(lv_volatility_4_0, grammarAccess.getUncertaintyAccess().getVolatilityINTTerminalRuleCall_2_0_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUncertaintyRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"volatility",
        		lv_volatility_4_0, 
        		"INT");
	    }

)
)))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUncertaintyAccess().getUnorderedGroup_2());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUncertaintyAccess().getUnorderedGroup_2(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getUncertaintyAccess().getUnorderedGroup_2(), 1);
	 				}
					({true}?=>(
	otherlv_5=Impact
    {
    	newLeafNode(otherlv_5, grammarAccess.getUncertaintyAccess().getImpactKeyword_2_1_0());
    }
(
(
		lv_impact_6_0=RULE_INT
		{
			newLeafNode(lv_impact_6_0, grammarAccess.getUncertaintyAccess().getImpactINTTerminalRuleCall_2_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUncertaintyRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"impact",
        		lv_impact_6_0, 
        		"INT");
	    }

)
)))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUncertaintyAccess().getUnorderedGroup_2());
	 				}
 				)
			)  

		)+
	  	{getUnorderedGroupHelper().canLeave(grammarAccess.getUncertaintyAccess().getUnorderedGroup_2())}?	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getUncertaintyAccess().getUnorderedGroup_2());
	}

)
	otherlv_7=RightSquareBracket
    {
    	newLeafNode(otherlv_7, grammarAccess.getUncertaintyAccess().getRightSquareBracketKeyword_3());
    }
)
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
)(
	otherlv_2=Target
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
))?(
	otherlv_4=Exception
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
))?(
	otherlv_6=LeftSquareBracket
    {
    	newLeafNode(otherlv_6, grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_4_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_4_1_0()); 
	    }
		lv_issues_7_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultIssueRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_7_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*
	otherlv_8=RightSquareBracket
    {
    	newLeafNode(otherlv_8, grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_4_2());
    }
)?)
;





// Entry rule entryRuleValDeclaration
entryRuleValDeclaration returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getValDeclarationRule()); }
	 iv_ruleValDeclaration=ruleValDeclaration 
	 { $current=$iv_ruleValDeclaration.current; } 
	 EOF 
;

// Rule ValDeclaration
ruleValDeclaration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getValDeclarationAccess().getValDeclarationAction_0(),
            $current);
    }
)
	otherlv_1=Val
    {
    	newLeafNode(otherlv_1, grammarAccess.getValDeclarationAccess().getValKeyword_1());
    }
(((((
(
RULE_ID

)
)(
(
RULE_ID

)
)))=>((
(
		lv_type_2_0=RULE_ID
		{
			newLeafNode(lv_type_2_0, grammarAccess.getValDeclarationAccess().getTypeIDTerminalRuleCall_2_0_0_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getValDeclarationRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"type",
        		lv_type_2_0, 
        		"ID");
	    }

)
)(
(
		lv_name_3_0=RULE_ID
		{
			newLeafNode(lv_name_3_0, grammarAccess.getValDeclarationAccess().getNameIDTerminalRuleCall_2_0_0_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getValDeclarationRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_3_0, 
        		"ID");
	    }

)
)))
    |(
(
		lv_name_4_0=RULE_ID
		{
			newLeafNode(lv_name_4_0, grammarAccess.getValDeclarationAccess().getNameIDTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getValDeclarationRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_4_0, 
        		"ID");
	    }

)
))
	otherlv_5=EqualsSign
    {
    	newLeafNode(otherlv_5, grammarAccess.getValDeclarationAccess().getEqualsSignKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getValDeclarationAccess().getRightAExpressionParserRuleCall_4_0()); 
	    }
		lv_right_6_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValDeclarationRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_6_0, 
        		"AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleComputeDeclaration
entryRuleComputeDeclaration returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getComputeDeclarationRule()); }
	 iv_ruleComputeDeclaration=ruleComputeDeclaration 
	 { $current=$iv_ruleComputeDeclaration.current; } 
	 EOF 
;

// Rule ComputeDeclaration
ruleComputeDeclaration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getComputeDeclarationAccess().getComputeDeclarationAction_0(),
            $current);
    }
)
	otherlv_1=Compute
    {
    	newLeafNode(otherlv_1, grammarAccess.getComputeDeclarationAccess().getComputeKeyword_1());
    }
(((((
(
RULE_ID

)
)(
(
RULE_ID

)
)))=>((
(
		lv_type_2_0=RULE_ID
		{
			newLeafNode(lv_type_2_0, grammarAccess.getComputeDeclarationAccess().getTypeIDTerminalRuleCall_2_0_0_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getComputeDeclarationRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"type",
        		lv_type_2_0, 
        		"ID");
	    }

)
)(
(
		lv_name_3_0=RULE_ID
		{
			newLeafNode(lv_name_3_0, grammarAccess.getComputeDeclarationAccess().getNameIDTerminalRuleCall_2_0_0_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getComputeDeclarationRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_3_0, 
        		"ID");
	    }

)
)))
    |(
(
		lv_name_4_0=RULE_ID
		{
			newLeafNode(lv_name_4_0, grammarAccess.getComputeDeclarationAccess().getNameIDTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getComputeDeclarationRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_4_0, 
        		"ID");
	    }

)
)))
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
)
	otherlv_1=CommercialAt
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
)(
	otherlv_1=PercentSign
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
(
	otherlv_0=Img
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
    @after { leaveRule();
    }:
((    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_0_0()); 
    }

	kw=Solidus 
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

	kw=FullStop 
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
    @after { leaveRule();
    }:

	kw=VerticalLineVerticalLine 
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
    @after { leaveRule();
    }:

	kw=AmpersandAmpersand 
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
    @after { leaveRule();
    }:
(
	kw=EqualsSignEqualsSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
    }

    |
	kw=ExclamationMarkEqualsSign 
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
    @after { leaveRule();
    }:
(
	kw=GreaterThanSignEqualsSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
    }

    |(
	kw=LessThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0()); 
    }

	kw=EqualsSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1()); 
    }
)
    |
	kw=GreaterThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
    }

    |
	kw=LessThanSign 
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
    @after { leaveRule();
    }:
(
	kw=HyphenMinusGreaterThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
    }

    |
	kw=FullStopFullStopLessThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1()); 
    }

    |(
	kw=GreaterThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0()); 
    }

	kw=FullStopFullStop 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1()); 
    }
)
    |
	kw=FullStopFullStop 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3()); 
    }

    |
	kw=EqualsSignGreaterThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4()); 
    }

    |(
	kw=GreaterThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0()); 
    }
((((
	GreaterThanSign 

	GreaterThanSign 
))=>(
	kw=GreaterThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0()); 
    }

	kw=GreaterThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1()); 
    }
))
    |
	kw=GreaterThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1()); 
    }
))
    |(
	kw=LessThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0()); 
    }
((((
	LessThanSign 

	LessThanSign 
))=>(
	kw=LessThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0()); 
    }

	kw=LessThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1()); 
    }
))
    |
	kw=LessThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1()); 
    }

    |
	kw=EqualsSignGreaterThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2()); 
    }
))
    |
	kw=LessThanSignGreaterThanSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7()); 
    }

    |
	kw=QuestionMarkColon 
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
    @after { leaveRule();
    }:
(
	kw=PlusSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
    }

    |
	kw=HyphenMinus 
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
    @after { leaveRule();
    }:
(
	kw=Asterisk 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
    }

    |
	kw=AsteriskAsterisk 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
    }

    |
	kw=Solidus 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
    }

    |
	kw=PercentSign 
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
    @after { leaveRule();
    }:
(
	kw=ExclamationMark 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
    }

    |
	kw=HyphenMinus 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
    }

    |
	kw=PlusSign 
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
    @after { leaveRule();
    }:
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
    @after { leaveRule();
    }:
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
)
	otherlv_1=LeftCurlyBracket
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
)(
	otherlv_3=Comma
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
))*)?
	otherlv_5=RightCurlyBracket
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
)
	otherlv_1=NumberSign
    {
    	newLeafNode(otherlv_1, grammarAccess.getAListTermAccess().getNumberSignKeyword_1());
    }

	otherlv_2=LeftSquareBracket
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
)(
	otherlv_4=Comma
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
))*)?
	otherlv_6=RightSquareBracket
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
(
	otherlv_0=LeftParenthesis
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

	otherlv_2=RightParenthesis
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
		lv_value_1_0=
	True
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
    |
	otherlv_2=False
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
)
	otherlv_1=Null
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
    @after { leaveRule();
    }:
    this_STRING_0=RULE_STRING    {
		$current.merge(this_STRING_0);
    }

    { 
    newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); 
    }

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
    @after { leaveRule();
    }:
(
	kw=Abstract 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
    }

    |
	kw=Bus 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
    }

    |
	kw=Data 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
    }

    |
	kw=Device 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
    }

    |
	kw=Memory 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
    }

    |
	kw=Process 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
    }

    |
	kw=Processor 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
    }

    |
	kw=Subprogram 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
    }

    |(
	kw=Subprogram 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
    }

	kw=Group 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
    }
)
    |
	kw=KW_System 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
    }

    |(
	kw=Thread 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
    }

	kw=Group 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
    }
)
    |
	kw=Thread 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
    }

    |(
	kw=Virtual 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
    }

	kw=Bus 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
    }
)
    |(
	kw=Virtual 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
    }

	kw=Processor 
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
    @after { leaveRule();
    }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw=ColonColon 
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
	kw=FullStop 
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
    @after { leaveRule();
    }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw=ColonColon 
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
    @after { leaveRule();
    }:
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
    @after { leaveRule();
    }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw=FullStop 
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
((    enumLiteral_0=Tbd
    {
        $current = grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0()); 
    }
)
    |(    enumLiteral_1=Error
    {
        $current = grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1()); 
    }
)
    |(    enumLiteral_2=Warning
    {
        $current = grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2()); 
    }
)
    |(    enumLiteral_3=Info
    {
        $current = grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3()); 
    }
)
    |(    enumLiteral_4=Success
    {
        $current = grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4()); 
    }
)
    |(    enumLiteral_5=Fail
    {
        $current = grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_5()); 
    }
));



