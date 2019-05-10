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
	        newCompositeNode(grammarAccess.getReqSpecAccess().getPartsSystemRequirementSetParserRuleCall_0_0()); 
	    }
		lv_parts_0_1=ruleSystemRequirementSet		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReqSpecRule());
	        }
       		add(
       			$current, 
       			"parts",
        		lv_parts_0_1, 
        		"org.osate.reqspec.ReqSpec.SystemRequirementSet");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getReqSpecAccess().getPartsGlobalRequirementSetParserRuleCall_0_1()); 
	    }
		lv_parts_0_2=ruleGlobalRequirementSet		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReqSpecRule());
	        }
       		add(
       			$current, 
       			"parts",
        		lv_parts_0_2, 
        		"org.osate.reqspec.ReqSpec.GlobalRequirementSet");
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
        		"org.osate.reqspec.ReqSpec.StakeholderGoals");
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
        		"org.osate.reqspec.ReqSpec.ReqDocument");
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
        		"org.osate.reqspec.ReqSpec.GlobalConstants");
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
        		"org.osate.alisa.common.Common.QualifiedName");
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
        		"org.osate.reqspec.ReqSpec.ValDeclaration");
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
        		"org.osate.alisa.common.Common.QualifiedName");
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
		ruleAadlClassifierReference
		{ 
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
        		"org.osate.alisa.common.Common.ComponentCategory");
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
		ruleQualifiedName
		{ 
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
        		"org.osate.alisa.common.Common.Description");
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
        		"org.osate.reqspec.ReqSpec.ValDeclaration");
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
	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getGoalsGoalParserRuleCall_7_2_0()); 
	    }
		lv_goals_15_0=ruleGoal		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStakeholderGoalsRule());
	        }
       		add(
       			$current, 
       			"goals",
        		lv_goals_15_0, 
        		"org.osate.reqspec.ReqSpec.Goal");
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
        		"org.osate.reqspec.ReqSpec.ExternalDocument");
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
        		"org.osate.alisa.common.Common.QualifiedName");
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
        		"org.osate.alisa.common.Common.Description");
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
        		"org.osate.reqspec.ReqSpec.DocGoal");
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
        		"org.osate.reqspec.ReqSpec.DocRequirement");
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
        		"org.osate.reqspec.ReqSpec.DocumentSection");
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
        		"org.osate.reqspec.ReqSpec.ExternalDocument");
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
(((
(
		lv_label_1_0=RULE_ID
		{
			newLeafNode(lv_label_1_0, grammarAccess.getDocumentSectionAccess().getLabelIDTerminalRuleCall_1_0_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocumentSectionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"label",
        		lv_label_1_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)(
	otherlv_2=Colon
    {
    	newLeafNode(otherlv_2, grammarAccess.getDocumentSectionAccess().getColonKeyword_1_0_1_0());
    }
(
(
		lv_title_3_0=RULE_STRING
		{
			newLeafNode(lv_title_3_0, grammarAccess.getDocumentSectionAccess().getTitleSTRINGTerminalRuleCall_1_0_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocumentSectionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_3_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))?)
    |(
(
		lv_title_4_0=RULE_STRING
		{
			newLeafNode(lv_title_4_0, grammarAccess.getDocumentSectionAccess().getTitleSTRINGTerminalRuleCall_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocumentSectionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_4_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))
	otherlv_5=LeftSquareBracket
    {
    	newLeafNode(otherlv_5, grammarAccess.getDocumentSectionAccess().getLeftSquareBracketKeyword_2());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3(), 0);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getDescriptionDescriptionParserRuleCall_3_0_0()); 
	    }
		lv_description_7_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocumentSectionRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_7_0, 
        		"org.osate.alisa.common.Common.Description");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3(), 1);
	 				}
					({true}?=>(
(
(
		{ 
	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentDocGoalParserRuleCall_3_1_0_0()); 
	    }
		lv_content_8_1=ruleDocGoal		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocumentSectionRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_8_1, 
        		"org.osate.reqspec.ReqSpec.DocGoal");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentDocRequirementParserRuleCall_3_1_0_1()); 
	    }
		lv_content_8_2=ruleDocRequirement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocumentSectionRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_8_2, 
        		"org.osate.reqspec.ReqSpec.DocRequirement");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentDocumentSectionParserRuleCall_3_1_0_2()); 
	    }
		lv_content_8_3=ruleDocumentSection		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocumentSectionRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_8_3, 
        		"org.osate.reqspec.ReqSpec.DocumentSection");
	        afterParserOrEnumRuleCall();
	    }

)

)
))+
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3());
	}

)
	otherlv_9=RightSquareBracket
    {
    	newLeafNode(otherlv_9, grammarAccess.getDocumentSectionAccess().getRightSquareBracketKeyword_4());
    }
)
;





// Entry rule entryRuleSystemRequirementSet
entryRuleSystemRequirementSet returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getSystemRequirementSetRule()); }
	 iv_ruleSystemRequirementSet=ruleSystemRequirementSet 
	 { $current=$iv_ruleSystemRequirementSet.current; } 
	 EOF 
;

// Rule SystemRequirementSet
ruleSystemRequirementSet returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getSystemRequirementSetAccess().getSystemRequirementSetAction_0(),
            $current);
    }
)
	otherlv_1=KW_System
    {
    	newLeafNode(otherlv_1, grammarAccess.getSystemRequirementSetAccess().getSystemKeyword_1());
    }

	otherlv_2=Requirements
    {
    	newLeafNode(otherlv_2, grammarAccess.getSystemRequirementSetAccess().getRequirementsKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementSetAccess().getNameQualifiedNameParserRuleCall_3_0()); 
	    }
		lv_name_3_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementSetRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_3_0, 
        		"org.osate.alisa.common.Common.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
	otherlv_4=Colon
    {
    	newLeafNode(otherlv_4, grammarAccess.getSystemRequirementSetAccess().getColonKeyword_4_0());
    }
(
(
		lv_title_5_0=RULE_STRING
		{
			newLeafNode(lv_title_5_0, grammarAccess.getSystemRequirementSetAccess().getTitleSTRINGTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementSetRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_5_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))?
	otherlv_6=For
    {
    	newLeafNode(otherlv_6, grammarAccess.getSystemRequirementSetAccess().getForKeyword_5());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementSetRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementSetAccess().getTargetComponentClassifierCrossReference_6_0()); 
	    }
		ruleAadlClassifierReference
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(
	otherlv_8=Use
    {
    	newLeafNode(otherlv_8, grammarAccess.getSystemRequirementSetAccess().getUseKeyword_7_0());
    }

	otherlv_9=Constants
    {
    	newLeafNode(otherlv_9, grammarAccess.getSystemRequirementSetAccess().getConstantsKeyword_7_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementSetRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementSetAccess().getImportConstantsGlobalConstantsCrossReference_7_2_0()); 
	    }
		ruleQualifiedName
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)?
	otherlv_11=LeftSquareBracket
    {
    	newLeafNode(otherlv_11, grammarAccess.getSystemRequirementSetAccess().getLeftSquareBracketKeyword_8());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementSetAccess().getDescriptionDescriptionParserRuleCall_9_0_0()); 
	    }
		lv_description_12_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementSetRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_12_0, 
        		"org.osate.alisa.common.Common.Description");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementSetAccess().getConstantsValDeclarationParserRuleCall_9_1_0()); 
	    }
		lv_constants_13_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementSetRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_13_0, 
        		"org.osate.reqspec.ReqSpec.ValDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementSetAccess().getComputesComputeDeclarationParserRuleCall_9_2_0()); 
	    }
		lv_computes_14_0=ruleComputeDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementSetRule());
	        }
       		add(
       			$current, 
       			"computes",
        		lv_computes_14_0, 
        		"org.osate.alisa.common.Common.ComputeDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementSetAccess().getRequirementsSystemRequirementParserRuleCall_9_3_0()); 
	    }
		lv_requirements_15_0=ruleSystemRequirement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementSetRule());
	        }
       		add(
       			$current, 
       			"requirements",
        		lv_requirements_15_0, 
        		"org.osate.reqspec.ReqSpec.SystemRequirement");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementSetAccess().getIncludeIncludeGlobalRequirementParserRuleCall_9_4_0()); 
	    }
		lv_include_16_0=ruleIncludeGlobalRequirement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementSetRule());
	        }
       		add(
       			$current, 
       			"include",
        		lv_include_16_0, 
        		"org.osate.reqspec.ReqSpec.IncludeGlobalRequirement");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
	otherlv_17=See
    {
    	newLeafNode(otherlv_17, grammarAccess.getSystemRequirementSetAccess().getSeeKeyword_9_5_0());
    }

	otherlv_18=Document
    {
    	newLeafNode(otherlv_18, grammarAccess.getSystemRequirementSetAccess().getDocumentKeyword_9_5_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementSetAccess().getDocReferenceExternalDocumentParserRuleCall_9_5_2_0()); 
	    }
		lv_docReference_19_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementSetRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_19_0, 
        		"org.osate.reqspec.ReqSpec.ExternalDocument");
	        afterParserOrEnumRuleCall();
	    }

)
)+)
    |(
	otherlv_20=See
    {
    	newLeafNode(otherlv_20, grammarAccess.getSystemRequirementSetAccess().getSeeKeyword_9_6_0());
    }

	otherlv_21=Goals
    {
    	newLeafNode(otherlv_21, grammarAccess.getSystemRequirementSetAccess().getGoalsKeyword_9_6_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementSetRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementSetAccess().getStakeholderGoalsReqRootCrossReference_9_6_2_0()); 
	    }
		ruleQualifiedName
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)
    |(
	otherlv_23=Issues
    {
    	newLeafNode(otherlv_23, grammarAccess.getSystemRequirementSetAccess().getIssuesKeyword_9_7_0());
    }
(
(
		lv_issues_24_0=RULE_STRING
		{
			newLeafNode(lv_issues_24_0, grammarAccess.getSystemRequirementSetAccess().getIssuesSTRINGTerminalRuleCall_9_7_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementSetRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_24_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
)+))*
	otherlv_25=RightSquareBracket
    {
    	newLeafNode(otherlv_25, grammarAccess.getSystemRequirementSetAccess().getRightSquareBracketKeyword_10());
    }
)
;





// Entry rule entryRuleGlobalRequirementSet
entryRuleGlobalRequirementSet returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getGlobalRequirementSetRule()); }
	 iv_ruleGlobalRequirementSet=ruleGlobalRequirementSet 
	 { $current=$iv_ruleGlobalRequirementSet.current; } 
	 EOF 
;

// Rule GlobalRequirementSet
ruleGlobalRequirementSet returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getGlobalRequirementSetAccess().getGlobalRequirementSetAction_0(),
            $current);
    }
)
	otherlv_1=Global
    {
    	newLeafNode(otherlv_1, grammarAccess.getGlobalRequirementSetAccess().getGlobalKeyword_1());
    }

	otherlv_2=Requirements
    {
    	newLeafNode(otherlv_2, grammarAccess.getGlobalRequirementSetAccess().getRequirementsKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementSetAccess().getNameQualifiedNameParserRuleCall_3_0()); 
	    }
		lv_name_3_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementSetRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_3_0, 
        		"org.osate.alisa.common.Common.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
	otherlv_4=Colon
    {
    	newLeafNode(otherlv_4, grammarAccess.getGlobalRequirementSetAccess().getColonKeyword_4_0());
    }
(
(
		lv_title_5_0=RULE_STRING
		{
			newLeafNode(lv_title_5_0, grammarAccess.getGlobalRequirementSetAccess().getTitleSTRINGTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementSetRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_5_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))?(
	otherlv_6=Use
    {
    	newLeafNode(otherlv_6, grammarAccess.getGlobalRequirementSetAccess().getUseKeyword_5_0());
    }

	otherlv_7=Constants
    {
    	newLeafNode(otherlv_7, grammarAccess.getGlobalRequirementSetAccess().getConstantsKeyword_5_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementSetRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementSetAccess().getImportConstantsGlobalConstantsCrossReference_5_2_0()); 
	    }
		ruleQualifiedName
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)?
	otherlv_9=LeftSquareBracket
    {
    	newLeafNode(otherlv_9, grammarAccess.getGlobalRequirementSetAccess().getLeftSquareBracketKeyword_6());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementSetAccess().getDescriptionDescriptionParserRuleCall_7_0_0()); 
	    }
		lv_description_10_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementSetRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_10_0, 
        		"org.osate.alisa.common.Common.Description");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementSetAccess().getConstantsValDeclarationParserRuleCall_7_1_0()); 
	    }
		lv_constants_11_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementSetRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_11_0, 
        		"org.osate.reqspec.ReqSpec.ValDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementSetAccess().getComputesComputeDeclarationParserRuleCall_7_2_0()); 
	    }
		lv_computes_12_0=ruleComputeDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementSetRule());
	        }
       		add(
       			$current, 
       			"computes",
        		lv_computes_12_0, 
        		"org.osate.alisa.common.Common.ComputeDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementSetAccess().getRequirementsGlobalRequirementParserRuleCall_7_3_0()); 
	    }
		lv_requirements_13_0=ruleGlobalRequirement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementSetRule());
	        }
       		add(
       			$current, 
       			"requirements",
        		lv_requirements_13_0, 
        		"org.osate.reqspec.ReqSpec.GlobalRequirement");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
	otherlv_14=See
    {
    	newLeafNode(otherlv_14, grammarAccess.getGlobalRequirementSetAccess().getSeeKeyword_7_4_0());
    }

	otherlv_15=Document
    {
    	newLeafNode(otherlv_15, grammarAccess.getGlobalRequirementSetAccess().getDocumentKeyword_7_4_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementSetAccess().getDocReferenceExternalDocumentParserRuleCall_7_4_2_0()); 
	    }
		lv_docReference_16_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementSetRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_16_0, 
        		"org.osate.reqspec.ReqSpec.ExternalDocument");
	        afterParserOrEnumRuleCall();
	    }

)
)+)
    |(
	otherlv_17=See
    {
    	newLeafNode(otherlv_17, grammarAccess.getGlobalRequirementSetAccess().getSeeKeyword_7_5_0());
    }

	otherlv_18=Goals
    {
    	newLeafNode(otherlv_18, grammarAccess.getGlobalRequirementSetAccess().getGoalsKeyword_7_5_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementSetRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementSetAccess().getStakeholderGoalsReqRootCrossReference_7_5_2_0()); 
	    }
		ruleQualifiedName
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)
    |(
	otherlv_20=Issues
    {
    	newLeafNode(otherlv_20, grammarAccess.getGlobalRequirementSetAccess().getIssuesKeyword_7_6_0());
    }
(
(
		lv_issues_21_0=RULE_STRING
		{
			newLeafNode(lv_issues_21_0, grammarAccess.getGlobalRequirementSetAccess().getIssuesSTRINGTerminalRuleCall_7_6_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementSetRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_21_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
)+))*
	otherlv_22=RightSquareBracket
    {
    	newLeafNode(otherlv_22, grammarAccess.getGlobalRequirementSetAccess().getRightSquareBracketKeyword_8());
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
        		"org.eclipse.xtext.common.Terminals.ID");
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
		ruleAadlClassifierReference
		{ 
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
	otherlv_10=Category
    {
    	newLeafNode(otherlv_10, grammarAccess.getDocGoalAccess().getCategoryKeyword_5_0_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getCategoryCategoryCrossReference_5_0_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 1);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); 
	    }
		lv_description_12_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocGoalRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_12_0, 
        		"org.osate.alisa.common.Common.Description");
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getConstantsValDeclarationParserRuleCall_5_2_0()); 
	    }
		lv_constants_13_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocGoalRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_13_0, 
        		"org.osate.reqspec.ReqSpec.ValDeclaration");
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 3);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getWhenconditionWhenConditionParserRuleCall_5_3_0()); 
	    }
		lv_whencondition_14_0=ruleWhenCondition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocGoalRule());
	        }
       		set(
       			$current, 
       			"whencondition",
        		lv_whencondition_14_0, 
        		"org.osate.reqspec.ReqSpec.WhenCondition");
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 4);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getRationaleRationaleParserRuleCall_5_4_0()); 
	    }
		lv_rationale_15_0=ruleRationale		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocGoalRule());
	        }
       		set(
       			$current, 
       			"rationale",
        		lv_rationale_15_0, 
        		"org.osate.alisa.common.Common.Rationale");
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
	        newCompositeNode(grammarAccess.getDocGoalAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_5_0()); 
	    }
		lv_changeUncertainty_16_0=ruleUncertainty		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocGoalRule());
	        }
       		set(
       			$current, 
       			"changeUncertainty",
        		lv_changeUncertainty_16_0, 
        		"org.osate.alisa.common.Common.Uncertainty");
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
	otherlv_17=Refines
    {
    	newLeafNode(otherlv_17, grammarAccess.getDocGoalAccess().getRefinesKeyword_5_6_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getRefinesReferenceGoalCrossReference_5_6_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 7)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 7);
	 				}
					({true}?=>(
	otherlv_19=Conflicts
    {
    	newLeafNode(otherlv_19, grammarAccess.getDocGoalAccess().getConflictsKeyword_5_7_0());
    }

	otherlv_20=With
    {
    	newLeafNode(otherlv_20, grammarAccess.getDocGoalAccess().getWithKeyword_5_7_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getConflictsReferenceGoalCrossReference_5_7_2_0()); 
	    }
		ruleQualifiedName
		{ 
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
	otherlv_22=Evolves
    {
    	newLeafNode(otherlv_22, grammarAccess.getDocGoalAccess().getEvolvesKeyword_5_8_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getEvolvesReferenceRequirementCrossReference_5_8_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
					({true}?=>((
(
		lv_dropped_24_0=
	Dropped
    {
        newLeafNode(lv_dropped_24_0, grammarAccess.getDocGoalAccess().getDroppedDroppedKeyword_5_9_0_0());
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
		lv_dropRationale_25_0=RULE_STRING
		{
			newLeafNode(lv_dropRationale_25_0, grammarAccess.getDocGoalAccess().getDropRationaleSTRINGTerminalRuleCall_5_9_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"dropRationale",
        		lv_dropRationale_25_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
)?))
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
					({true}?=>(
	otherlv_26=Stakeholder
    {
    	newLeafNode(otherlv_26, grammarAccess.getDocGoalAccess().getStakeholderKeyword_5_10_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_10_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 11)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 11);
	 				}
					({true}?=>(
	otherlv_28=See
    {
    	newLeafNode(otherlv_28, grammarAccess.getDocGoalAccess().getSeeKeyword_5_11_0());
    }

	otherlv_29=Document
    {
    	newLeafNode(otherlv_29, grammarAccess.getDocGoalAccess().getDocumentKeyword_5_11_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getDocGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_11_2_0()); 
	    }
		lv_docReference_30_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocGoalRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_30_0, 
        		"org.osate.reqspec.ReqSpec.ExternalDocument");
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
	otherlv_31=Issues
    {
    	newLeafNode(otherlv_31, grammarAccess.getDocGoalAccess().getIssuesKeyword_5_12_0());
    }
(
(
		lv_issues_32_0=RULE_STRING
		{
			newLeafNode(lv_issues_32_0, grammarAccess.getDocGoalAccess().getIssuesSTRINGTerminalRuleCall_5_12_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocGoalRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_32_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
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
	otherlv_33=RightSquareBracket
    {
    	newLeafNode(otherlv_33, grammarAccess.getDocGoalAccess().getRightSquareBracketKeyword_6());
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
        		"org.eclipse.xtext.common.Terminals.ID");
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
	otherlv_8=Category
    {
    	newLeafNode(otherlv_8, grammarAccess.getGoalAccess().getCategoryKeyword_5_0_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getCategoryCategoryCrossReference_5_0_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); 
	    }
		lv_description_10_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGoalRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_10_0, 
        		"org.osate.alisa.common.Common.Description");
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getConstantsValDeclarationParserRuleCall_5_2_0()); 
	    }
		lv_constants_11_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGoalRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_11_0, 
        		"org.osate.reqspec.ReqSpec.ValDeclaration");
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getWhenconditionWhenConditionParserRuleCall_5_3_0()); 
	    }
		lv_whencondition_12_0=ruleWhenCondition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGoalRule());
	        }
       		set(
       			$current, 
       			"whencondition",
        		lv_whencondition_12_0, 
        		"org.osate.reqspec.ReqSpec.WhenCondition");
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getRationaleRationaleParserRuleCall_5_4_0()); 
	    }
		lv_rationale_13_0=ruleRationale		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGoalRule());
	        }
       		set(
       			$current, 
       			"rationale",
        		lv_rationale_13_0, 
        		"org.osate.alisa.common.Common.Rationale");
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
	        newCompositeNode(grammarAccess.getGoalAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_5_0()); 
	    }
		lv_changeUncertainty_14_0=ruleUncertainty		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGoalRule());
	        }
       		set(
       			$current, 
       			"changeUncertainty",
        		lv_changeUncertainty_14_0, 
        		"org.osate.alisa.common.Common.Uncertainty");
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
	otherlv_15=Refines
    {
    	newLeafNode(otherlv_15, grammarAccess.getGoalAccess().getRefinesKeyword_5_6_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_6_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7);
	 				}
					({true}?=>(
	otherlv_17=Conflicts
    {
    	newLeafNode(otherlv_17, grammarAccess.getGoalAccess().getConflictsKeyword_5_7_0());
    }

	otherlv_18=With
    {
    	newLeafNode(otherlv_18, grammarAccess.getGoalAccess().getWithKeyword_5_7_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_7_2_0()); 
	    }
		ruleQualifiedName
		{ 
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
	otherlv_20=Evolves
    {
    	newLeafNode(otherlv_20, grammarAccess.getGoalAccess().getEvolvesKeyword_5_8_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceRequirementCrossReference_5_8_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
					({true}?=>((
(
		lv_dropped_22_0=
	Dropped
    {
        newLeafNode(lv_dropped_22_0, grammarAccess.getGoalAccess().getDroppedDroppedKeyword_5_9_0_0());
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
		lv_dropRationale_23_0=RULE_STRING
		{
			newLeafNode(lv_dropRationale_23_0, grammarAccess.getGoalAccess().getDropRationaleSTRINGTerminalRuleCall_5_9_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"dropRationale",
        		lv_dropRationale_23_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
)?))
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
					({true}?=>(
	otherlv_24=Stakeholder
    {
    	newLeafNode(otherlv_24, grammarAccess.getGoalAccess().getStakeholderKeyword_5_10_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_10_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11);
	 				}
					({true}?=>(
	otherlv_26=See
    {
    	newLeafNode(otherlv_26, grammarAccess.getGoalAccess().getSeeKeyword_5_11_0());
    }

	otherlv_27=Goal
    {
    	newLeafNode(otherlv_27, grammarAccess.getGoalAccess().getGoalKeyword_5_11_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getGoalReferenceGoalCrossReference_5_11_2_0()); 
	    }
		ruleQualifiedName
		{ 
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
	otherlv_29=See
    {
    	newLeafNode(otherlv_29, grammarAccess.getGoalAccess().getSeeKeyword_5_12_0());
    }

	otherlv_30=Document
    {
    	newLeafNode(otherlv_30, grammarAccess.getGoalAccess().getDocumentKeyword_5_12_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_12_2_0()); 
	    }
		lv_docReference_31_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGoalRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_31_0, 
        		"org.osate.reqspec.ReqSpec.ExternalDocument");
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
	otherlv_32=Issues
    {
    	newLeafNode(otherlv_32, grammarAccess.getGoalAccess().getIssuesKeyword_5_13_0());
    }
(
(
		lv_issues_33_0=RULE_STRING
		{
			newLeafNode(lv_issues_33_0, grammarAccess.getGoalAccess().getIssuesSTRINGTerminalRuleCall_5_13_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGoalRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_33_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
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
	otherlv_34=RightSquareBracket
    {
    	newLeafNode(otherlv_34, grammarAccess.getGoalAccess().getRightSquareBracketKeyword_6());
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
        		"org.eclipse.xtext.common.Terminals.ID");
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
((
	otherlv_7=Category
    {
    	newLeafNode(otherlv_7, grammarAccess.getSystemRequirementAccess().getCategoryKeyword_5_0_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getCategoryCategoryCrossReference_5_0_1_0()); 
	    }
		ruleQualifiedName
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); 
	    }
		lv_description_9_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_9_0, 
        		"org.osate.alisa.common.Common.Description");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getWhenconditionWhenConditionParserRuleCall_5_2_0()); 
	    }
		lv_whencondition_10_0=ruleWhenCondition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		set(
       			$current, 
       			"whencondition",
        		lv_whencondition_10_0, 
        		"org.osate.reqspec.ReqSpec.WhenCondition");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getPredicateReqPredicateParserRuleCall_5_3_0()); 
	    }
		lv_predicate_11_0=ruleReqPredicate		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		set(
       			$current, 
       			"predicate",
        		lv_predicate_11_0, 
        		"org.osate.reqspec.ReqSpec.ReqPredicate");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getRationaleRationaleParserRuleCall_5_4_0()); 
	    }
		lv_rationale_12_0=ruleRationale		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		set(
       			$current, 
       			"rationale",
        		lv_rationale_12_0, 
        		"org.osate.alisa.common.Common.Rationale");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_5_0()); 
	    }
		lv_changeUncertainty_13_0=ruleUncertainty		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		set(
       			$current, 
       			"changeUncertainty",
        		lv_changeUncertainty_13_0, 
        		"org.osate.alisa.common.Common.Uncertainty");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
	otherlv_14=Mitigates
    {
    	newLeafNode(otherlv_14, grammarAccess.getSystemRequirementAccess().getMitigatesKeyword_5_6_0());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
	otherlv_15=RULE_ID
	{
		newLeafNode(otherlv_15, grammarAccess.getSystemRequirementAccess().getExceptionEObjectCrossReference_5_6_1_0_0()); 
	}

)
)
    |(
(
		lv_exceptionText_16_0=RULE_STRING
		{
			newLeafNode(lv_exceptionText_16_0, grammarAccess.getSystemRequirementAccess().getExceptionTextSTRINGTerminalRuleCall_5_6_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exceptionText",
        		lv_exceptionText_16_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
)))
    |(
	otherlv_17=Inherits
    {
    	newLeafNode(otherlv_17, grammarAccess.getSystemRequirementAccess().getInheritsKeyword_5_7_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getInheritsReferenceRequirementCrossReference_5_7_1_0()); 
	    }
		ruleQualifiedName
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))
    |((
(
		lv_dropped_19_0=
	Dropped
    {
        newLeafNode(lv_dropped_19_0, grammarAccess.getSystemRequirementAccess().getDroppedDroppedKeyword_5_8_0_0());
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
		lv_dropRationale_20_0=RULE_STRING
		{
			newLeafNode(lv_dropRationale_20_0, grammarAccess.getSystemRequirementAccess().getDropRationaleSTRINGTerminalRuleCall_5_8_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"dropRationale",
        		lv_dropRationale_20_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
)?)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getConstantsValDeclarationParserRuleCall_5_9_0()); 
	    }
		lv_constants_21_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_21_0, 
        		"org.osate.reqspec.ReqSpec.ValDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getComputesComputeDeclarationParserRuleCall_5_10_0()); 
	    }
		lv_computes_22_0=ruleComputeDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		add(
       			$current, 
       			"computes",
        		lv_computes_22_0, 
        		"org.osate.alisa.common.Common.ComputeDeclaration");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
	otherlv_23=Refines
    {
    	newLeafNode(otherlv_23, grammarAccess.getSystemRequirementAccess().getRefinesKeyword_5_11_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getRefinesReferenceRequirementCrossReference_5_11_1_0()); 
	    }
		ruleQualifiedName
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)
    |(
	otherlv_25=Decomposes
    {
    	newLeafNode(otherlv_25, grammarAccess.getSystemRequirementAccess().getDecomposesKeyword_5_12_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getDecomposesReferenceRequirementCrossReference_5_12_1_0()); 
	    }
		ruleQualifiedName
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)
    |(
	otherlv_27=Evolves
    {
    	newLeafNode(otherlv_27, grammarAccess.getSystemRequirementAccess().getEvolvesKeyword_5_13_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getEvolvesReferenceRequirementCrossReference_5_13_1_0()); 
	    }
		ruleQualifiedName
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)
    |(
	otherlv_29=Development
    {
    	newLeafNode(otherlv_29, grammarAccess.getSystemRequirementAccess().getDevelopmentKeyword_5_14_0());
    }

	otherlv_30=Stakeholder
    {
    	newLeafNode(otherlv_30, grammarAccess.getSystemRequirementAccess().getStakeholderKeyword_5_14_1());
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
		ruleQualifiedName
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)
    |(
	otherlv_32=See
    {
    	newLeafNode(otherlv_32, grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_15_0());
    }

	otherlv_33=Goal
    {
    	newLeafNode(otherlv_33, grammarAccess.getSystemRequirementAccess().getGoalKeyword_5_15_1());
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
		ruleQualifiedName
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)
    |(
	otherlv_35=See
    {
    	newLeafNode(otherlv_35, grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_16_0());
    }

	otherlv_36=Requirement
    {
    	newLeafNode(otherlv_36, grammarAccess.getSystemRequirementAccess().getRequirementKeyword_5_16_1());
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
		ruleQualifiedName
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)+)
    |(
	otherlv_38=See
    {
    	newLeafNode(otherlv_38, grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_17_0());
    }

	otherlv_39=Document
    {
    	newLeafNode(otherlv_39, grammarAccess.getSystemRequirementAccess().getDocumentKeyword_5_17_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_17_2_0()); 
	    }
		lv_docReference_40_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemRequirementRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_40_0, 
        		"org.osate.reqspec.ReqSpec.ExternalDocument");
	        afterParserOrEnumRuleCall();
	    }

)
)+)
    |(
	otherlv_41=Issues
    {
    	newLeafNode(otherlv_41, grammarAccess.getSystemRequirementAccess().getIssuesKeyword_5_18_0());
    }
(
(
		lv_issues_42_0=RULE_STRING
		{
			newLeafNode(lv_issues_42_0, grammarAccess.getSystemRequirementAccess().getIssuesSTRINGTerminalRuleCall_5_18_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemRequirementRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_42_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
)+))*
	otherlv_43=RightSquareBracket
    {
    	newLeafNode(otherlv_43, grammarAccess.getSystemRequirementAccess().getRightSquareBracketKeyword_6());
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
        		"org.eclipse.xtext.common.Terminals.ID");
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
        		"org.osate.alisa.common.Common.ComponentCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getTargetTypeTargetTypeEnumRuleCall_3_1_1_0()); 
	    }
		lv_targetType_6_0=ruleTargetType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		set(
       			$current, 
       			"targetType",
        		lv_targetType_6_0, 
        		"org.osate.alisa.common.Common.TargetType");
	        afterParserOrEnumRuleCall();
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
	otherlv_9=Category
    {
    	newLeafNode(otherlv_9, grammarAccess.getGlobalRequirementAccess().getCategoryKeyword_5_0_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getCategoryCategoryCrossReference_5_0_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 1);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); 
	    }
		lv_description_11_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_11_0, 
        		"org.osate.alisa.common.Common.Description");
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getConstantsValDeclarationParserRuleCall_5_2_0()); 
	    }
		lv_constants_12_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_12_0, 
        		"org.osate.reqspec.ReqSpec.ValDeclaration");
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 3);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getComputesComputeDeclarationParserRuleCall_5_3_0()); 
	    }
		lv_computes_13_0=ruleComputeDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		add(
       			$current, 
       			"computes",
        		lv_computes_13_0, 
        		"org.osate.alisa.common.Common.ComputeDeclaration");
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
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getWhenconditionWhenConditionParserRuleCall_5_4_0()); 
	    }
		lv_whencondition_14_0=ruleWhenCondition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		set(
       			$current, 
       			"whencondition",
        		lv_whencondition_14_0, 
        		"org.osate.reqspec.ReqSpec.WhenCondition");
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 5);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getPredicateReqPredicateParserRuleCall_5_5_0()); 
	    }
		lv_predicate_15_0=ruleReqPredicate		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		set(
       			$current, 
       			"predicate",
        		lv_predicate_15_0, 
        		"org.osate.reqspec.ReqSpec.ReqPredicate");
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
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getRationaleRationaleParserRuleCall_5_6_0()); 
	    }
		lv_rationale_16_0=ruleRationale		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		set(
       			$current, 
       			"rationale",
        		lv_rationale_16_0, 
        		"org.osate.alisa.common.Common.Rationale");
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
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_7_0()); 
	    }
		lv_changeUncertainty_17_0=ruleUncertainty		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		set(
       			$current, 
       			"changeUncertainty",
        		lv_changeUncertainty_17_0, 
        		"org.osate.alisa.common.Common.Uncertainty");
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
	otherlv_18=Mitigates
    {
    	newLeafNode(otherlv_18, grammarAccess.getGlobalRequirementAccess().getMitigatesKeyword_5_8_0());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
	otherlv_19=RULE_ID
	{
		newLeafNode(otherlv_19, grammarAccess.getGlobalRequirementAccess().getExceptionEObjectCrossReference_5_8_1_0_0()); 
	}

)
)
    |(
(
		lv_exceptionText_20_0=RULE_STRING
		{
			newLeafNode(lv_exceptionText_20_0, grammarAccess.getGlobalRequirementAccess().getExceptionTextSTRINGTerminalRuleCall_5_8_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exceptionText",
        		lv_exceptionText_20_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))))
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
	otherlv_21=Refines
    {
    	newLeafNode(otherlv_21, grammarAccess.getGlobalRequirementAccess().getRefinesKeyword_5_9_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getRefinesReferenceRequirementCrossReference_5_9_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 10)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 10);
	 				}
					({true}?=>(
	otherlv_23=Decomposes
    {
    	newLeafNode(otherlv_23, grammarAccess.getGlobalRequirementAccess().getDecomposesKeyword_5_10_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getDecomposesReferenceRequirementCrossReference_5_10_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
	otherlv_25=Evolves
    {
    	newLeafNode(otherlv_25, grammarAccess.getGlobalRequirementAccess().getEvolvesKeyword_5_11_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getEvolvesReferenceRequirementCrossReference_5_11_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
					({true}?=>((
(
		lv_dropped_27_0=
	Dropped
    {
        newLeafNode(lv_dropped_27_0, grammarAccess.getGlobalRequirementAccess().getDroppedDroppedKeyword_5_12_0_0());
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
		lv_dropRationale_28_0=RULE_STRING
		{
			newLeafNode(lv_dropRationale_28_0, grammarAccess.getGlobalRequirementAccess().getDropRationaleSTRINGTerminalRuleCall_5_12_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"dropRationale",
        		lv_dropRationale_28_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
)?))
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
					({true}?=>(
	otherlv_29=Development
    {
    	newLeafNode(otherlv_29, grammarAccess.getGlobalRequirementAccess().getDevelopmentKeyword_5_13_0());
    }

	otherlv_30=Stakeholder
    {
    	newLeafNode(otherlv_30, grammarAccess.getGlobalRequirementAccess().getStakeholderKeyword_5_13_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getDevelopmentStakeholderStakeholderCrossReference_5_13_2_0()); 
	    }
		ruleQualifiedName
		{ 
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 14)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 14);
	 				}
					({true}?=>(
	otherlv_32=See
    {
    	newLeafNode(otherlv_32, grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_14_0());
    }

	otherlv_33=Goal
    {
    	newLeafNode(otherlv_33, grammarAccess.getGlobalRequirementAccess().getGoalKeyword_5_14_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getGoalReferenceGoalCrossReference_5_14_2_0()); 
	    }
		ruleQualifiedName
		{ 
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
	otherlv_35=See
    {
    	newLeafNode(otherlv_35, grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_15_0());
    }

	otherlv_36=Requirement
    {
    	newLeafNode(otherlv_36, grammarAccess.getGlobalRequirementAccess().getRequirementKeyword_5_15_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getRequirementReferenceRequirementCrossReference_5_15_2_0()); 
	    }
		ruleQualifiedName
		{ 
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
	otherlv_38=See
    {
    	newLeafNode(otherlv_38, grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_16_0());
    }

	otherlv_39=Document
    {
    	newLeafNode(otherlv_39, grammarAccess.getGlobalRequirementAccess().getDocumentKeyword_5_16_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGlobalRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_16_2_0()); 
	    }
		lv_docReference_40_0=ruleExternalDocument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGlobalRequirementRule());
	        }
       		add(
       			$current, 
       			"docReference",
        		lv_docReference_40_0, 
        		"org.osate.reqspec.ReqSpec.ExternalDocument");
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
	otherlv_41=Issues
    {
    	newLeafNode(otherlv_41, grammarAccess.getGlobalRequirementAccess().getIssuesKeyword_5_17_0());
    }
(
(
		lv_issues_42_0=RULE_STRING
		{
			newLeafNode(lv_issues_42_0, grammarAccess.getGlobalRequirementAccess().getIssuesSTRINGTerminalRuleCall_5_17_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGlobalRequirementRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"issues",
        		lv_issues_42_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
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
	otherlv_43=RightSquareBracket
    {
    	newLeafNode(otherlv_43, grammarAccess.getGlobalRequirementAccess().getRightSquareBracketKeyword_6());
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
        		"org.eclipse.xtext.common.Terminals.ID");
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
		ruleAadlClassifierReference
		{ 
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
        		"org.osate.alisa.common.Common.ComponentCategory");
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
	otherlv_11=Category
    {
    	newLeafNode(otherlv_11, grammarAccess.getDocRequirementAccess().getCategoryKeyword_5_0_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getCategoryCategoryCrossReference_5_0_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 1);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); 
	    }
		lv_description_13_0=ruleDescription		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		set(
       			$current, 
       			"description",
        		lv_description_13_0, 
        		"org.osate.alisa.common.Common.Description");
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getConstantsValDeclarationParserRuleCall_5_2_0()); 
	    }
		lv_constants_14_0=ruleValDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		add(
       			$current, 
       			"constants",
        		lv_constants_14_0, 
        		"org.osate.reqspec.ReqSpec.ValDeclaration");
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 3);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getComputesComputeDeclarationParserRuleCall_5_3_0()); 
	    }
		lv_computes_15_0=ruleComputeDeclaration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		add(
       			$current, 
       			"computes",
        		lv_computes_15_0, 
        		"org.osate.alisa.common.Common.ComputeDeclaration");
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
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getWhenconditionWhenConditionParserRuleCall_5_4_0()); 
	    }
		lv_whencondition_16_0=ruleWhenCondition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		set(
       			$current, 
       			"whencondition",
        		lv_whencondition_16_0, 
        		"org.osate.reqspec.ReqSpec.WhenCondition");
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 5);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getPredicateReqPredicateParserRuleCall_5_5_0()); 
	    }
		lv_predicate_17_0=ruleReqPredicate		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		set(
       			$current, 
       			"predicate",
        		lv_predicate_17_0, 
        		"org.osate.reqspec.ReqSpec.ReqPredicate");
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
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getRationaleRationaleParserRuleCall_5_6_0()); 
	    }
		lv_rationale_18_0=ruleRationale		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		set(
       			$current, 
       			"rationale",
        		lv_rationale_18_0, 
        		"org.osate.alisa.common.Common.Rationale");
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
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_7_0()); 
	    }
		lv_changeUncertainty_19_0=ruleUncertainty		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDocRequirementRule());
	        }
       		set(
       			$current, 
       			"changeUncertainty",
        		lv_changeUncertainty_19_0, 
        		"org.osate.alisa.common.Common.Uncertainty");
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
	otherlv_20=Mitigates
    {
    	newLeafNode(otherlv_20, grammarAccess.getDocRequirementAccess().getMitigatesKeyword_5_8_0());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
	otherlv_21=RULE_ID
	{
		newLeafNode(otherlv_21, grammarAccess.getDocRequirementAccess().getExceptionEObjectCrossReference_5_8_1_0_0()); 
	}

)
)
    |(
(
		lv_exceptionText_22_0=RULE_STRING
		{
			newLeafNode(lv_exceptionText_22_0, grammarAccess.getDocRequirementAccess().getExceptionTextSTRINGTerminalRuleCall_5_8_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exceptionText",
        		lv_exceptionText_22_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))))
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
	otherlv_23=Refines
    {
    	newLeafNode(otherlv_23, grammarAccess.getDocRequirementAccess().getRefinesKeyword_5_9_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getRefinesReferenceRequirementCrossReference_5_9_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 10)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 10);
	 				}
					({true}?=>(
	otherlv_25=Decomposes
    {
    	newLeafNode(otherlv_25, grammarAccess.getDocRequirementAccess().getDecomposesKeyword_5_10_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getDecomposesReferenceRequirementCrossReference_5_10_1_0()); 
	    }
		ruleQualifiedName
		{ 
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
	otherlv_27=Inherits
    {
    	newLeafNode(otherlv_27, grammarAccess.getDocRequirementAccess().getInheritsKeyword_5_11_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDocRequirementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDocRequirementAccess().getInheritsReferenceRequirementCrossReference_5_11_1_0()); 
	    }
		ruleQualifiedName
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)))
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
		ruleQualifiedName
		{ 
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
		ruleQualifiedName
		{ 
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
		ruleQualifiedName
		{ 
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
        		"org.osate.reqspec.ReqSpec.ExternalDocument");
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
		ruleQualifiedName
		{ 
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
		lv_local_3_0=
	Self
    {
        newLeafNode(lv_local_3_0, grammarAccess.getIncludeGlobalRequirementAccess().getLocalSelfKeyword_2_1_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIncludeGlobalRequirementRule());
	        }
       		setWithLastConsumed($current, "local", true, "self");
	    }

)
)
    |(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getIncludeGlobalRequirementRule());
	        }
        }
	otherlv_4=RULE_ID
	{
		newLeafNode(otherlv_4, grammarAccess.getIncludeGlobalRequirementAccess().getTargetElementNamedElementCrossReference_2_1_1_0()); 
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
		newLeafNode(otherlv_9, grammarAccess.getWhenConditionAccess().getInErrorStateEObjectCrossReference_1_1_3_0()); 
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
		newLeafNode(otherlv_11, grammarAccess.getWhenConditionAccess().getInErrorStateEObjectCrossReference_1_1_4_1_0()); 
	}

)
))*)
    |((
(
		{ 
	        newCompositeNode(grammarAccess.getWhenConditionAccess().getConditionQualifiedNameParserRuleCall_1_2_0_0()); 
	    }
		lv_condition_12_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getWhenConditionRule());
	        }
       		set(
       			$current, 
       			"condition",
        		lv_condition_12_0, 
        		"org.osate.alisa.common.Common.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)
	otherlv_13=LeftParenthesis
    {
    	newLeafNode(otherlv_13, grammarAccess.getWhenConditionAccess().getLeftParenthesisKeyword_1_2_1());
    }

	otherlv_14=RightParenthesis
    {
    	newLeafNode(otherlv_14, grammarAccess.getWhenConditionAccess().getRightParenthesisKeyword_1_2_2());
    }
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
        newCompositeNode(grammarAccess.getReqPredicateAccess().getValuePredicateParserRuleCall_1()); 
    }
    this_ValuePredicate_1=ruleValuePredicate
    {
        $current = $this_ValuePredicate_1.current;
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
        		"org.eclipse.xtext.common.Terminals.STRING");
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
        		"org.osate.alisa.common.Common.AAndExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(
	otherlv_3=With
    {
    	newLeafNode(otherlv_3, grammarAccess.getValuePredicateAccess().getWithKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getValuePredicateAccess().getDesiredValueDesiredValueParserRuleCall_3_1_0()); 
	    }
		lv_desiredValue_4_0=ruleDesiredValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValuePredicateRule());
	        }
       		add(
       			$current, 
       			"desiredValue",
        		lv_desiredValue_4_0, 
        		"org.osate.reqspec.ReqSpec.DesiredValue");
	        afterParserOrEnumRuleCall();
	    }

)
)+)?)
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
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDesiredValueRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getDesiredValueAccess().getDesiredAVariableReferenceCrossReference_0_0()); 
	}

)
)((
(
		lv_upto_1_0=
	Upto
    {
        newLeafNode(lv_upto_1_0, grammarAccess.getDesiredValueAccess().getUptoUptoKeyword_1_0_0());
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
	otherlv_2=Downto
    {
    	newLeafNode(otherlv_2, grammarAccess.getDesiredValueAccess().getDowntoKeyword_1_1());
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getDesiredValueAccess().getValueAExpressionParserRuleCall_2_0()); 
	    }
		lv_value_3_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDesiredValueRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_3_0, 
        		"org.osate.alisa.common.Common.AExpression");
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
        		"org.osate.reqspec.ReqSpec.DOCPATH");
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
	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocFragmentQualifiedNameParserRuleCall_1_1_0()); 
	    }
		lv_docFragment_2_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExternalDocumentRule());
	        }
       		set(
       			$current, 
       			"docFragment",
        		lv_docFragment_2_0, 
        		"org.osate.alisa.common.Common.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
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
            grammarAccess.getValDeclarationAccess().getReqValDeclarationAction_0(),
            $current);
    }
)
	otherlv_1=Val
    {
    	newLeafNode(otherlv_1, grammarAccess.getValDeclarationAccess().getValKeyword_1());
    }
(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getValDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getValDeclarationRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)(
	otherlv_3=Colon
    {
    	newLeafNode(otherlv_3, grammarAccess.getValDeclarationAccess().getColonKeyword_3_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getValDeclarationAccess().getTypeTypeRefParserRuleCall_3_1_0_0()); 
	    }
		lv_type_4_0=ruleTypeRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValDeclarationRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_4_0, 
        		"org.osate.alisa.common.Common.TypeRef");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
	otherlv_5=Typeof
    {
    	newLeafNode(otherlv_5, grammarAccess.getValDeclarationAccess().getTypeofKeyword_3_1_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getValDeclarationAccess().getTypePropertyRefParserRuleCall_3_1_1_1_0()); 
	    }
		lv_type_6_0=rulePropertyRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValDeclarationRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_6_0, 
        		"org.osate.alisa.common.Common.PropertyRef");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |((
(
		lv_range_7_0=
	LeftSquareBracket
    {
        newLeafNode(lv_range_7_0, grammarAccess.getValDeclarationAccess().getRangeLeftSquareBracketKeyword_3_1_2_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getValDeclarationRule());
	        }
       		setWithLastConsumed($current, "range", true, "[");
	    }

)
)((
(
		{ 
	        newCompositeNode(grammarAccess.getValDeclarationAccess().getTypeTypeRefParserRuleCall_3_1_2_1_0_0()); 
	    }
		lv_type_8_0=ruleTypeRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValDeclarationRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_8_0, 
        		"org.osate.alisa.common.Common.TypeRef");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
	otherlv_9=Typeof
    {
    	newLeafNode(otherlv_9, grammarAccess.getValDeclarationAccess().getTypeofKeyword_3_1_2_1_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getValDeclarationAccess().getTypePropertyRefParserRuleCall_3_1_2_1_1_1_0()); 
	    }
		lv_type_10_0=rulePropertyRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValDeclarationRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_10_0, 
        		"org.osate.alisa.common.Common.PropertyRef");
	        afterParserOrEnumRuleCall();
	    }

)
)))
	otherlv_11=RightSquareBracket
    {
    	newLeafNode(otherlv_11, grammarAccess.getValDeclarationAccess().getRightSquareBracketKeyword_3_1_2_2());
    }
)))?
	otherlv_12=EqualsSign
    {
    	newLeafNode(otherlv_12, grammarAccess.getValDeclarationAccess().getEqualsSignKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getValDeclarationAccess().getValueAExpressionParserRuleCall_5_0()); 
	    }
		lv_value_13_0=ruleAExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValDeclarationRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_13_0, 
        		"org.osate.alisa.common.Common.AExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(
	otherlv_14=As
    {
    	newLeafNode(otherlv_14, grammarAccess.getValDeclarationAccess().getAsKeyword_6_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getValDeclarationAccess().getPropertyPropertyRefParserRuleCall_6_1_0()); 
	    }
		lv_property_15_0=rulePropertyRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getValDeclarationRule());
	        }
       		set(
       			$current, 
       			"property",
        		lv_property_15_0, 
        		"org.osate.alisa.common.Common.PropertyRef");
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

This


)
)=>
(
		lv_thisTarget_1_0=
	This
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
(
	otherlv_0=Rationale
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
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getUncertaintyAccess().getUncertaintyAction_0(),
            $current);
    }
)
	otherlv_1=Uncertainty
    {
    	newLeafNode(otherlv_1, grammarAccess.getUncertaintyAccess().getUncertaintyKeyword_1());
    }

	otherlv_2=LeftSquareBracket
    {
    	newLeafNode(otherlv_2, grammarAccess.getUncertaintyAccess().getLeftSquareBracketKeyword_2());
    }
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), 0);
	 				}
					({true}?=>(
	otherlv_4=Volatility
    {
    	newLeafNode(otherlv_4, grammarAccess.getUncertaintyAccess().getVolatilityKeyword_3_0_0());
    }
(
(
		lv_volatility_5_0=RULE_INT
		{
			newLeafNode(lv_volatility_5_0, grammarAccess.getUncertaintyAccess().getVolatilityINTTerminalRuleCall_3_0_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUncertaintyRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"volatility",
        		lv_volatility_5_0, 
        		"org.eclipse.xtext.common.Terminals.INT");
	    }

)
)))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), 1);
	 				}
					({true}?=>(
	otherlv_6=Precedence
    {
    	newLeafNode(otherlv_6, grammarAccess.getUncertaintyAccess().getPrecedenceKeyword_3_1_0());
    }
(
(
		lv_precedence_7_0=RULE_INT
		{
			newLeafNode(lv_precedence_7_0, grammarAccess.getUncertaintyAccess().getPrecedenceINTTerminalRuleCall_3_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUncertaintyRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"precedence",
        		lv_precedence_7_0, 
        		"org.eclipse.xtext.common.Terminals.INT");
	    }

)
)))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), 2);
	 				}
					({true}?=>(
	otherlv_8=Impact
    {
    	newLeafNode(otherlv_8, grammarAccess.getUncertaintyAccess().getImpactKeyword_3_2_0());
    }
(
(
		lv_impact_9_0=RULE_INT
		{
			newLeafNode(lv_impact_9_0, grammarAccess.getUncertaintyAccess().getImpactINTTerminalRuleCall_3_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUncertaintyRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"impact",
        		lv_impact_9_0, 
        		"org.eclipse.xtext.common.Terminals.INT");
	    }

)
)))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3());
	}

)
	otherlv_10=RightSquareBracket
    {
    	newLeafNode(otherlv_10, grammarAccess.getUncertaintyAccess().getRightSquareBracketKeyword_4());
    }
)
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
)
	otherlv_1=Boolean
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
)
	otherlv_3=Integer
    {
    	newLeafNode(otherlv_3, grammarAccess.getTypeRefAccess().getIntegerKeyword_1_1());
    }
(
	otherlv_4=Units
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
		ruleAADLPROPERTYREFERENCE
		{ 
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
)
	otherlv_7=Real
    {
    	newLeafNode(otherlv_7, grammarAccess.getTypeRefAccess().getRealKeyword_2_1());
    }
(
	otherlv_8=Units
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
		ruleAADLPROPERTYREFERENCE
		{ 
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
)
	otherlv_11=String
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
)
	otherlv_13=Model
    {
    	newLeafNode(otherlv_13, grammarAccess.getTypeRefAccess().getModelKeyword_4_1());
    }

	otherlv_14=Element
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
		ruleAADLPROPERTYREFERENCE
		{ 
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
		ruleAADLPROPERTYREFERENCE
		{ 
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
(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getComputeDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getComputeDeclarationRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)
	otherlv_3=Colon
    {
    	newLeafNode(otherlv_3, grammarAccess.getComputeDeclarationAccess().getColonKeyword_3());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getComputeDeclarationAccess().getTypeTypeRefParserRuleCall_4_0_0()); 
	    }
		lv_type_4_0=ruleTypeRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComputeDeclarationRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_4_0, 
        		"org.osate.alisa.common.Common.TypeRef");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
	otherlv_5=Typeof
    {
    	newLeafNode(otherlv_5, grammarAccess.getComputeDeclarationAccess().getTypeofKeyword_4_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getComputeDeclarationAccess().getTypePropertyRefParserRuleCall_4_1_1_0()); 
	    }
		lv_type_6_0=rulePropertyRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComputeDeclarationRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_6_0, 
        		"org.osate.alisa.common.Common.PropertyRef");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |((
(
		lv_range_7_0=
	LeftSquareBracket
    {
        newLeafNode(lv_range_7_0, grammarAccess.getComputeDeclarationAccess().getRangeLeftSquareBracketKeyword_4_2_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getComputeDeclarationRule());
	        }
       		setWithLastConsumed($current, "range", true, "[");
	    }

)
)((
(
		{ 
	        newCompositeNode(grammarAccess.getComputeDeclarationAccess().getTypeTypeRefParserRuleCall_4_2_1_0_0()); 
	    }
		lv_type_8_0=ruleTypeRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComputeDeclarationRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_8_0, 
        		"org.osate.alisa.common.Common.TypeRef");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
	otherlv_9=Typeof
    {
    	newLeafNode(otherlv_9, grammarAccess.getComputeDeclarationAccess().getTypeofKeyword_4_2_1_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getComputeDeclarationAccess().getTypePropertyRefParserRuleCall_4_2_1_1_1_0()); 
	    }
		lv_type_10_0=rulePropertyRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComputeDeclarationRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_10_0, 
        		"org.osate.alisa.common.Common.PropertyRef");
	        afterParserOrEnumRuleCall();
	    }

)
)))
	otherlv_11=RightSquareBracket
    {
    	newLeafNode(otherlv_11, grammarAccess.getComputeDeclarationAccess().getRightSquareBracketKeyword_4_2_2());
    }
)))
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
)
NumberSign
))=>((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceModelElementReferenceAction_0_1_0_0_0(),
            $current);
    }
)
	otherlv_2=NumberSign
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
		ruleAADLPROPERTYREFERENCE
		{ 
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
		ruleThisKeyword
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAModelReferenceAccess().getAModelReferencePrevAction_1_0(),
            $current);
    }
)
	otherlv_2=FullStop
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
)
	otherlv_1=NumberSign
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
		ruleAADLPROPERTYREFERENCE
		{ 
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
		lv_convert_1_0=
	PercentSign
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
		lv_drop_2_0=
	In
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
    @after { leaveRule();
    }:
(
	kw=Or 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword_0()); 
    }

    |
	kw=VerticalLineVerticalLine 
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
    @after { leaveRule();
    }:
(
	kw=And 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword_0()); 
    }

    |
	kw=AmpersandAmpersand 
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
    @after { leaveRule();
    }:
(
	kw=GreaterThanSignEqualsSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
    }

    |
	kw=LessThanSignEqualsSign 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
    }

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

    |
	kw=GreaterThanSignLessThanSign 
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
    @after { leaveRule();
    }:
(
	kw=Asterisk 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
    }

    |
	kw=Solidus 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); 
    }

    |
	kw=Div 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpMultiAccess().getDivKeyword_2()); 
    }

    |
	kw=Mod 
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
    @after { leaveRule();
    }:
(
	kw=Not 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getOpUnaryAccess().getNotKeyword_0()); 
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
		lv_convert_2_0=
	PercentSign
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
		lv_drop_3_0=
	In
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
)
	otherlv_2=LeftParenthesis
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
)(
	otherlv_4=Comma
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
))*)?
	otherlv_6=RightParenthesis
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
)
	otherlv_1=LeftSquareBracket
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
)
	otherlv_3=FullStopFullStop
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
)(((
Delta
)=>
	otherlv_5=Delta
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
))?
	otherlv_7=RightSquareBracket
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
)
	otherlv_1=If
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
)
	otherlv_3=Then
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
)(
	otherlv_5=Else
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
))?
	otherlv_7=Endif
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
    @after { leaveRule();
    }:
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
    @after { leaveRule();
    }:
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
    @after { leaveRule();
    }:

	kw=This 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getThisKeywordAccess().getThisKeyword()); 
    }

    ;







// Rule TargetType
ruleTargetType returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((    enumLiteral_0=Component
    {
        $current = grammarAccess.getTargetTypeAccess().getCOMPONENTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getTargetTypeAccess().getCOMPONENTEnumLiteralDeclaration_0()); 
    }
)
    |(    enumLiteral_1=Feature
    {
        $current = grammarAccess.getTargetTypeAccess().getFEATUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getTargetTypeAccess().getFEATUREEnumLiteralDeclaration_1()); 
    }
)
    |(    enumLiteral_2=Connection
    {
        $current = grammarAccess.getTargetTypeAccess().getCONNECTIONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getTargetTypeAccess().getCONNECTIONEnumLiteralDeclaration_2()); 
    }
)
    |(    enumLiteral_3=Flow
    {
        $current = grammarAccess.getTargetTypeAccess().getFLOWEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getTargetTypeAccess().getFLOWEnumLiteralDeclaration_3()); 
    }
)
    |(    enumLiteral_4=Mode
    {
        $current = grammarAccess.getTargetTypeAccess().getMODEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getTargetTypeAccess().getMODEEnumLiteralDeclaration_4()); 
    }
)
    |(    enumLiteral_5=Element
    {
        $current = grammarAccess.getTargetTypeAccess().getELEMENTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getTargetTypeAccess().getELEMENTEnumLiteralDeclaration_5()); 
    }
)
    |(    enumLiteral_6=Root
    {
        $current = grammarAccess.getTargetTypeAccess().getROOTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_6, grammarAccess.getTargetTypeAccess().getROOTEnumLiteralDeclaration_6()); 
    }
));



