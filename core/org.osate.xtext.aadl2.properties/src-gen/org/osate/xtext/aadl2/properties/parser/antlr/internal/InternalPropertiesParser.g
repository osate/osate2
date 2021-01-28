/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
parser grammar InternalPropertiesParser;

options {
	tokenVocab=InternalPropertiesLexer;
	superClass=AbstractInternalAntlrParser;
}

@header {
package org.osate.xtext.aadl2.properties.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess;

}

@members {

 	private PropertiesGrammarAccess grammarAccess;

    public InternalPropertiesParser(TokenStream input, PropertiesGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "PModel";
   	}

   	@Override
   	protected PropertiesGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRulePModel
entryRulePModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPModelRule()); }
	iv_rulePModel=rulePModel
	{ $current=$iv_rulePModel.current; }
	EOF;

// Rule PModel
rulePModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getPModelAccess().getContainedPropertyAssociationParserRuleCall());
	}
	this_ContainedPropertyAssociation_0=ruleContainedPropertyAssociation
	{
		$current = $this_ContainedPropertyAssociation_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleContainedPropertyAssociation
entryRuleContainedPropertyAssociation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); }
	iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation
	{ $current=$iv_ruleContainedPropertyAssociation.current; }
	EOF;

// Rule ContainedPropertyAssociation
ruleContainedPropertyAssociation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
				}
				ruleQPREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=EqualsSignGreaterThanSign
			{
				newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
			}
			    |
			(
				(
					lv_append_2_0=PlusSignEqualsSignGreaterThanSign
					{
						newLeafNode(lv_append_2_0, grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
						}
						setWithLastConsumed($current, "append", true, "+=>");
					}
				)
			)
		)
		(
			(
				lv_constant_3_0=Constant
				{
					newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
					}
					setWithLastConsumed($current, "constant", true, "constant");
				}
			)
		)?
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0());
					}
					lv_ownedValue_4_0=ruleOptionalModalPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
						}
						add(
							$current,
							"ownedValue",
							lv_ownedValue_4_0,
							"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_5=Comma
				{
					newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0());
						}
						lv_ownedValue_6_0=ruleOptionalModalPropertyValue
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
							}
							add(
								$current,
								"ownedValue",
								lv_ownedValue_6_0,
								"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)
		(
			{
				newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0());
			}
			ruleAppliesToKeywords
			{
				afterParserOrEnumRuleCall();
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0());
					}
					lv_appliesTo_8_0=ruleContainmentPath
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
						}
						add(
							$current,
							"appliesTo",
							lv_appliesTo_8_0,
							"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_9=Comma
				{
					newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0());
						}
						lv_appliesTo_10_0=ruleContainmentPath
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
							}
							add(
								$current,
								"appliesTo",
								lv_appliesTo_10_0,
								"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		(
			{
				newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0());
			}
			ruleInBindingKeywords
			{
				afterParserOrEnumRuleCall();
			}
			otherlv_12=LeftParenthesis
			{
				newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_2_0());
					}
					ruleQCREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_14=RightParenthesis
			{
				newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3());
			}
		)?
		otherlv_15=Semicolon
		{
			newLeafNode(otherlv_15, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRuleContainmentPath
entryRuleContainmentPath returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContainmentPathRule()); }
	iv_ruleContainmentPath=ruleContainmentPath
	{ $current=$iv_ruleContainmentPath.current; }
	EOF;

// Rule ContainmentPath
ruleContainmentPath returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0());
			}
			lv_path_0_0=ruleContainmentPathElement
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getContainmentPathRule());
				}
				set(
					$current,
					"path",
					lv_path_0_0,
					"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleOptionalModalPropertyValue
entryRuleOptionalModalPropertyValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOptionalModalPropertyValueRule()); }
	iv_ruleOptionalModalPropertyValue=ruleOptionalModalPropertyValue
	{ $current=$iv_ruleOptionalModalPropertyValue.current; }
	EOF;

// Rule OptionalModalPropertyValue
ruleOptionalModalPropertyValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0());
				}
				lv_ownedValue_0_0=rulePropertyExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOptionalModalPropertyValueRule());
					}
					set(
						$current,
						"ownedValue",
						lv_ownedValue_0_0,
						"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			{
				newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModesKeywordsParserRuleCall_1_0());
			}
			ruleInModesKeywords
			{
				afterParserOrEnumRuleCall();
			}
			otherlv_2=LeftParenthesis
			{
				newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
						}
					}
					otherlv_3=RULE_ID
					{
						newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_2_0());
					}
				)
			)
			(
				otherlv_4=Comma
				{
					newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
							}
						}
						otherlv_5=RULE_ID
						{
							newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_1_0());
						}
					)
				)
			)*
			otherlv_6=RightParenthesis
			{
				newLeafNode(otherlv_6, grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_4());
			}
		)?
	)
;

// Entry rule entryRulePropertyValue
entryRulePropertyValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropertyValueRule()); }
	iv_rulePropertyValue=rulePropertyValue
	{ $current=$iv_rulePropertyValue.current; }
	EOF;

// Rule PropertyValue
rulePropertyValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0());
			}
			lv_ownedValue_0_0=rulePropertyExpression
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getPropertyValueRule());
				}
				set(
					$current,
					"ownedValue",
					lv_ownedValue_0_0,
					"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRulePropertyExpression
entryRulePropertyExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropertyExpressionRule()); }
	iv_rulePropertyExpression=rulePropertyExpression
	{ $current=$iv_rulePropertyExpression.current; }
	EOF;

// Rule PropertyExpression
rulePropertyExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0());
		}
		this_RecordTerm_0=ruleRecordTerm
		{
			$current = $this_RecordTerm_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1());
		}
		this_ReferenceTerm_1=ruleReferenceTerm
		{
			$current = $this_ReferenceTerm_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_2());
		}
		this_ComponentClassifierTerm_2=ruleComponentClassifierTerm
		{
			$current = $this_ComponentClassifierTerm_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3());
		}
		this_ComputedTerm_3=ruleComputedTerm
		{
			$current = $this_ComputedTerm_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4());
		}
		this_StringTerm_4=ruleStringTerm
		{
			$current = $this_StringTerm_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_5());
		}
		this_NumericRangeTerm_5=ruleNumericRangeTerm
		{
			$current = $this_NumericRangeTerm_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_6());
		}
		this_RealTerm_6=ruleRealTerm
		{
			$current = $this_RealTerm_6.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_7());
		}
		this_IntegerTerm_7=ruleIntegerTerm
		{
			$current = $this_IntegerTerm_7.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_8());
		}
		this_ListTerm_8=ruleListTerm
		{
			$current = $this_ListTerm_8.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_9());
		}
		this_BooleanLiteral_9=ruleBooleanLiteral
		{
			$current = $this_BooleanLiteral_9.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_10());
		}
		this_LiteralorReferenceTerm_10=ruleLiteralorReferenceTerm
		{
			$current = $this_LiteralorReferenceTerm_10.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralorReferenceTerm
entryRuleLiteralorReferenceTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralorReferenceTermRule()); }
	iv_ruleLiteralorReferenceTerm=ruleLiteralorReferenceTerm
	{ $current=$iv_ruleLiteralorReferenceTerm.current; }
	EOF;

// Rule LiteralorReferenceTerm
ruleLiteralorReferenceTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getLiteralorReferenceTermRule());
				}
			}
			{
				newCompositeNode(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0());
			}
			ruleQPREF
			{
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleBooleanLiteral
entryRuleBooleanLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBooleanLiteralRule()); }
	iv_ruleBooleanLiteral=ruleBooleanLiteral
	{ $current=$iv_ruleBooleanLiteral.current; }
	EOF;

// Rule BooleanLiteral
ruleBooleanLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_value_1_0=True
					{
						newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBooleanLiteralRule());
						}
						setWithLastConsumed($current, "value", true, "true");
					}
				)
			)
			    |
			otherlv_2=False
			{
				newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1());
			}
		)
	)
;

// Entry rule entryRuleConstantValue
entryRuleConstantValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConstantValueRule()); }
	iv_ruleConstantValue=ruleConstantValue
	{ $current=$iv_ruleConstantValue.current; }
	EOF;

// Rule ConstantValue
ruleConstantValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getConstantValueRule());
				}
			}
			{
				newCompositeNode(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0());
			}
			ruleQPREF
			{
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleReferenceTerm
entryRuleReferenceTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReferenceTermRule()); }
	iv_ruleReferenceTerm=ruleReferenceTerm
	{ $current=$iv_ruleReferenceTerm.current; }
	EOF;

// Rule ReferenceTerm
ruleReferenceTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Reference
		{
			newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
		}
		otherlv_1=LeftParenthesis
		{
			newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0());
				}
				lv_path_2_0=ruleContainmentPathElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getReferenceTermRule());
					}
					set(
						$current,
						"path",
						lv_path_2_0,
						"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=RightParenthesis
		{
			newLeafNode(otherlv_3, grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleRecordTerm
entryRuleRecordTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRecordTermRule()); }
	iv_ruleRecordTerm=ruleRecordTerm
	{ $current=$iv_ruleRecordTerm.current; }
	EOF;

// Rule RecordTerm
ruleRecordTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=LeftSquareBracket
		{
			newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0());
				}
				lv_ownedFieldValue_1_0=ruleFieldPropertyAssociation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRecordTermRule());
					}
					add(
						$current,
						"ownedFieldValue",
						lv_ownedFieldValue_1_0,
						"org.osate.xtext.aadl2.properties.Properties.FieldPropertyAssociation");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_2=RightSquareBracket
		{
			newLeafNode(otherlv_2, grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2());
		}
	)
;

// Entry rule entryRuleComputedTerm
entryRuleComputedTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComputedTermRule()); }
	iv_ruleComputedTerm=ruleComputedTerm
	{ $current=$iv_ruleComputedTerm.current; }
	EOF;

// Rule ComputedTerm
ruleComputedTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Compute
		{
			newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
		}
		otherlv_1=LeftParenthesis
		{
			newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				lv_function_2_0=RULE_ID
				{
					newLeafNode(lv_function_2_0, grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getComputedTermRule());
					}
					setWithLastConsumed(
						$current,
						"function",
						lv_function_2_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_3=RightParenthesis
		{
			newLeafNode(otherlv_3, grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleComponentClassifierTerm
entryRuleComponentClassifierTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComponentClassifierTermRule()); }
	iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm
	{ $current=$iv_ruleComponentClassifierTerm.current; }
	EOF;

// Rule ComponentClassifierTerm
ruleComponentClassifierTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Classifier
		{
			newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
		}
		otherlv_1=LeftParenthesis
		{
			newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getComponentClassifierTermRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0());
				}
				ruleQCREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=RightParenthesis
		{
			newLeafNode(otherlv_3, grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleListTerm
entryRuleListTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getListTermRule()); }
	iv_ruleListTerm=ruleListTerm
	{ $current=$iv_ruleListTerm.current; }
	EOF;

// Rule ListTerm
ruleListTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getListTermAccess().getListValueAction_0(),
					$current);
			}
		)
		otherlv_1=LeftParenthesis
		{
			newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0());
					}
					lv_ownedListElement_2_0=rulePropertyExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getListTermRule());
						}
						add(
							$current,
							"ownedListElement",
							lv_ownedListElement_2_0,
							"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=Comma
				{
					newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0());
						}
						lv_ownedListElement_4_0=rulePropertyExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getListTermRule());
							}
							add(
								$current,
								"ownedListElement",
								lv_ownedListElement_4_0,
								"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_5=RightParenthesis
		{
			newLeafNode(otherlv_5, grammarAccess.getListTermAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleFieldPropertyAssociation
entryRuleFieldPropertyAssociation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); }
	iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation
	{ $current=$iv_ruleFieldPropertyAssociation.current; }
	EOF;

// Rule FieldPropertyAssociation
ruleFieldPropertyAssociation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0());
				}
			)
		)
		otherlv_1=EqualsSignGreaterThanSign
		{
			newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0());
				}
				lv_ownedValue_2_0=rulePropertyExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFieldPropertyAssociationRule());
					}
					set(
						$current,
						"ownedValue",
						lv_ownedValue_2_0,
						"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=Semicolon
		{
			newLeafNode(otherlv_3, grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRuleContainmentPathElement
entryRuleContainmentPathElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContainmentPathElementRule()); }
	iv_ruleContainmentPathElement=ruleContainmentPathElement
	{ $current=$iv_ruleContainmentPathElement.current; }
	EOF;

// Rule ContainmentPathElement
ruleContainmentPathElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getContainmentPathElementRule());
						}
					}
					otherlv_0=RULE_ID
					{
						newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0());
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0());
					}
					lv_arrayRange_1_0=ruleArrayRange
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
						}
						add(
							$current,
							"arrayRange",
							lv_arrayRange_1_0,
							"org.osate.xtext.aadl2.properties.Properties.ArrayRange");
						afterParserOrEnumRuleCall();
					}
				)
			)*
		)
		(
			otherlv_2=FullStop
			{
				newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_1_1_0());
					}
					lv_path_3_0=ruleContainmentPathElement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
						}
						set(
							$current,
							"path",
							lv_path_3_0,
							"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRulePlusMinus
entryRulePlusMinus returns [String current=null]:
	{ newCompositeNode(grammarAccess.getPlusMinusRule()); }
	iv_rulePlusMinus=rulePlusMinus
	{ $current=$iv_rulePlusMinus.current.getText(); }
	EOF;

// Rule PlusMinus
rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=PlusSign
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0());
		}
		    |
		kw=HyphenMinus
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1());
		}
	)
;

// Entry rule entryRuleStringTerm
entryRuleStringTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStringTermRule()); }
	iv_ruleStringTerm=ruleStringTerm
	{ $current=$iv_ruleStringTerm.current; }
	EOF;

// Rule StringTerm
ruleStringTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0());
			}
			lv_value_0_0=ruleNoQuoteString
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getStringTermRule());
				}
				set(
					$current,
					"value",
					lv_value_0_0,
					"org.osate.xtext.aadl2.properties.Properties.NoQuoteString");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleNoQuoteString
entryRuleNoQuoteString returns [String current=null]:
	{ newCompositeNode(grammarAccess.getNoQuoteStringRule()); }
	iv_ruleNoQuoteString=ruleNoQuoteString
	{ $current=$iv_ruleNoQuoteString.current.getText(); }
	EOF;

// Rule NoQuoteString
ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_STRING_0=RULE_STRING
	{
		$current.merge(this_STRING_0);
	}
	{
		newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall());
	}
;

// Entry rule entryRuleArrayRange
entryRuleArrayRange returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getArrayRangeRule()); }
	iv_ruleArrayRange=ruleArrayRange
	{ $current=$iv_ruleArrayRange.current; }
	EOF;

// Rule ArrayRange
ruleArrayRange returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
					$current);
			}
		)
		otherlv_1=LeftSquareBracket
		{
			newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0());
				}
				lv_lowerBound_2_0=ruleINTVALUE
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getArrayRangeRule());
					}
					set(
						$current,
						"lowerBound",
						lv_lowerBound_2_0,
						"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_3=FullStopFullStop
			{
				newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0());
					}
					lv_upperBound_4_0=ruleINTVALUE
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getArrayRangeRule());
						}
						set(
							$current,
							"upperBound",
							lv_upperBound_4_0,
							"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_5=RightSquareBracket
		{
			newLeafNode(otherlv_5, grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleSignedConstant
entryRuleSignedConstant returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSignedConstantRule()); }
	iv_ruleSignedConstant=ruleSignedConstant
	{ $current=$iv_ruleSignedConstant.current; }
	EOF;

// Rule SignedConstant
ruleSignedConstant returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0());
				}
				lv_op_0_0=rulePlusMinus
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignedConstantRule());
					}
					set(
						$current,
						"op",
						lv_op_0_0,
						"org.osate.xtext.aadl2.properties.Properties.PlusMinus");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0());
				}
				lv_ownedPropertyExpression_1_0=ruleConstantValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignedConstantRule());
					}
					add(
						$current,
						"ownedPropertyExpression",
						lv_ownedPropertyExpression_1_0,
						"org.osate.xtext.aadl2.properties.Properties.ConstantValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleIntegerTerm
entryRuleIntegerTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIntegerTermRule()); }
	iv_ruleIntegerTerm=ruleIntegerTerm
	{ $current=$iv_ruleIntegerTerm.current; }
	EOF;

// Rule IntegerTerm
ruleIntegerTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0());
				}
				lv_value_0_0=ruleSignedInt
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntegerTermRule());
					}
					set(
						$current,
						"value",
						lv_value_0_0,
						"org.osate.xtext.aadl2.properties.Properties.SignedInt");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIntegerTermRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0());
				}
			)
		)?
	)
;

// Entry rule entryRuleSignedInt
entryRuleSignedInt returns [String current=null]:
	{ newCompositeNode(grammarAccess.getSignedIntRule()); }
	iv_ruleSignedInt=ruleSignedInt
	{ $current=$iv_ruleSignedInt.current.getText(); }
	EOF;

// Rule SignedInt
ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			kw=PlusSign
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0());
			}
			    |
			kw=HyphenMinus
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1());
			}
		)?
		this_INTEGER_LIT_2=RULE_INTEGER_LIT
		{
			$current.merge(this_INTEGER_LIT_2);
		}
		{
			newLeafNode(this_INTEGER_LIT_2, grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleRealTerm
entryRuleRealTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRealTermRule()); }
	iv_ruleRealTerm=ruleRealTerm
	{ $current=$iv_ruleRealTerm.current; }
	EOF;

// Rule RealTerm
ruleRealTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0());
				}
				lv_value_0_0=ruleSignedReal
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRealTermRule());
					}
					set(
						$current,
						"value",
						lv_value_0_0,
						"org.osate.xtext.aadl2.properties.Properties.SignedReal");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRealTermRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0());
				}
			)
		)?
	)
;

// Entry rule entryRuleSignedReal
entryRuleSignedReal returns [String current=null]:
	{ newCompositeNode(grammarAccess.getSignedRealRule()); }
	iv_ruleSignedReal=ruleSignedReal
	{ $current=$iv_ruleSignedReal.current.getText(); }
	EOF;

// Rule SignedReal
ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			kw=PlusSign
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0());
			}
			    |
			kw=HyphenMinus
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1());
			}
		)?
		this_REAL_LIT_2=RULE_REAL_LIT
		{
			$current.merge(this_REAL_LIT_2);
		}
		{
			newLeafNode(this_REAL_LIT_2, grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleNumericRangeTerm
entryRuleNumericRangeTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNumericRangeTermRule()); }
	iv_ruleNumericRangeTerm=ruleNumericRangeTerm
	{ $current=$iv_ruleNumericRangeTerm.current; }
	EOF;

// Rule NumericRangeTerm
ruleNumericRangeTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0());
				}
				lv_minimum_0_0=ruleNumAlt
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
					}
					set(
						$current,
						"minimum",
						lv_minimum_0_0,
						"org.osate.xtext.aadl2.properties.Properties.NumAlt");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=FullStopFullStop
		{
			newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0());
				}
				lv_maximum_2_0=ruleNumAlt
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
					}
					set(
						$current,
						"maximum",
						lv_maximum_2_0,
						"org.osate.xtext.aadl2.properties.Properties.NumAlt");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_3=Delta
			{
				newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0());
					}
					lv_delta_4_0=ruleNumAlt
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
						}
						set(
							$current,
							"delta",
							lv_delta_4_0,
							"org.osate.xtext.aadl2.properties.Properties.NumAlt");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleNumAlt
entryRuleNumAlt returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNumAltRule()); }
	iv_ruleNumAlt=ruleNumAlt
	{ $current=$iv_ruleNumAlt.current; }
	EOF;

// Rule NumAlt
ruleNumAlt returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0());
		}
		this_RealTerm_0=ruleRealTerm
		{
			$current = $this_RealTerm_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1());
		}
		this_IntegerTerm_1=ruleIntegerTerm
		{
			$current = $this_IntegerTerm_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2());
		}
		this_SignedConstant_2=ruleSignedConstant
		{
			$current = $this_SignedConstant_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3());
		}
		this_ConstantValue_3=ruleConstantValue
		{
			$current = $this_ConstantValue_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleAppliesToKeywords
entryRuleAppliesToKeywords returns [String current=null]:
	{ newCompositeNode(grammarAccess.getAppliesToKeywordsRule()); }
	iv_ruleAppliesToKeywords=ruleAppliesToKeywords
	{ $current=$iv_ruleAppliesToKeywords.current.getText(); }
	EOF;

// Rule AppliesToKeywords
ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=Applies
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getAppliesKeyword_0());
		}
		kw=To
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getToKeyword_1());
		}
	)
;

// Entry rule entryRuleInBindingKeywords
entryRuleInBindingKeywords returns [String current=null]:
	{ newCompositeNode(grammarAccess.getInBindingKeywordsRule()); }
	iv_ruleInBindingKeywords=ruleInBindingKeywords
	{ $current=$iv_ruleInBindingKeywords.current.getText(); }
	EOF;

// Rule InBindingKeywords
ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=In
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getInKeyword_0());
		}
		kw=Binding
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getBindingKeyword_1());
		}
	)
;

// Entry rule entryRuleInModesKeywords
entryRuleInModesKeywords returns [String current=null]:
	{ newCompositeNode(grammarAccess.getInModesKeywordsRule()); }
	iv_ruleInModesKeywords=ruleInModesKeywords
	{ $current=$iv_ruleInModesKeywords.current.getText(); }
	EOF;

// Rule InModesKeywords
ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=In
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getInKeyword_0());
		}
		kw=Modes
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getModesKeyword_1());
		}
	)
;

// Entry rule entryRuleINTVALUE
entryRuleINTVALUE returns [String current=null]:
	{ newCompositeNode(grammarAccess.getINTVALUERule()); }
	iv_ruleINTVALUE=ruleINTVALUE
	{ $current=$iv_ruleINTVALUE.current.getText(); }
	EOF;

// Rule INTVALUE
ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_INTEGER_LIT_0=RULE_INTEGER_LIT
	{
		$current.merge(this_INTEGER_LIT_0);
	}
	{
		newLeafNode(this_INTEGER_LIT_0, grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall());
	}
;

// Entry rule entryRuleQPREF
entryRuleQPREF returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQPREFRule()); }
	iv_ruleQPREF=ruleQPREF
	{ $current=$iv_ruleQPREF.current.getText(); }
	EOF;

// Rule QPREF
ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0());
		}
		(
			kw=ColonColon
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1());
			}
		)?
	)
;

// Entry rule entryRuleQCREF
entryRuleQCREF returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQCREFRule()); }
	iv_ruleQCREF=ruleQCREF
	{ $current=$iv_ruleQCREF.current.getText(); }
	EOF;

// Rule QCREF
ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			this_ID_0=RULE_ID
			{
				$current.merge(this_ID_0);
			}
			{
				newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0());
			}
			kw=ColonColon
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1());
			}
		)*
		this_ID_2=RULE_ID
		{
			$current.merge(this_ID_2);
		}
		{
			newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1());
		}
		(
			kw=FullStop
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0());
			}
			this_ID_4=RULE_ID
			{
				$current.merge(this_ID_4);
			}
			{
				newLeafNode(this_ID_4, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1());
			}
		)?
	)
;

// Entry rule entryRuleSTAR
entryRuleSTAR returns [String current=null]:
	{ newCompositeNode(grammarAccess.getSTARRule()); }
	iv_ruleSTAR=ruleSTAR
	{ $current=$iv_ruleSTAR.current.getText(); }
	EOF;

// Rule STAR
ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	kw=Asterisk
	{
		$current.merge(kw);
		newLeafNode(kw, grammarAccess.getSTARAccess().getAsteriskKeyword());
	}
;
