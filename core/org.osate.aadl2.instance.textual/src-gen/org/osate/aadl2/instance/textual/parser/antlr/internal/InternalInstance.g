/*
<copyright>
Copyright  2016 by Carnegie Mellon University, all rights reserved.

Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
at http://www.eclipse.org/org/documents/epl-v10.html.

NO WARRANTY

ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.

Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
employees, and agents from all claims or demands made against them (and any related losses, expenses, or
attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
product liability, personal injury, death, damage to property, or violation of any laws or regulations.

Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
under the contract clause at 252.227.7013.
</copyright>
 */
grammar InternalInstance;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.osate.aadl2.instance.textual.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.osate.aadl2.instance.textual.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.aadl2.instance.textual.services.InstanceGrammarAccess;

}

@parser::members {

 	private InstanceGrammarAccess grammarAccess;
 	
    public InternalInstanceParser(TokenStream input, InstanceGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "SystemInstance";	
   	}
   	
   	@Override
   	protected InstanceGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleSystemInstance
entryRuleSystemInstance returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSystemInstanceRule()); }
	 iv_ruleSystemInstance=ruleSystemInstance 
	 { $current=$iv_ruleSystemInstance.current; } 
	 EOF 
;

// Rule SystemInstance
ruleSystemInstance returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
	    }
		lv_category_0_0=ruleComponentCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
	        }
       		set(
       			$current, 
       			"category",
        		lv_category_0_0, 
        		"org.osate.aadl2.instance.textual.Instance.ComponentCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getSystemInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemInstanceRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"org.osate.xtext.aadl2.properties.Properties.ID");
	    }

)
)	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getSystemInstanceAccess().getColonKeyword_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); 
	    }
		ruleImplRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4='{' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_0_0()); 
	    }
		lv_featureInstance_5_0=ruleFeatureInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
	        }
       		add(
       			$current, 
       			"featureInstance",
        		lv_featureInstance_5_0, 
        		"org.osate.aadl2.instance.textual.Instance.FeatureInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_0()); 
	    }
		lv_componentInstance_6_0=ruleComponentInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
	        }
       		add(
       			$current, 
       			"componentInstance",
        		lv_componentInstance_6_0, 
        		"org.osate.aadl2.instance.textual.Instance.ComponentInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_5_2_0()); 
	    }
		lv_connectionInstance_7_0=ruleConnectionInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
	        }
       		add(
       			$current, 
       			"connectionInstance",
        		lv_connectionInstance_7_0, 
        		"org.osate.aadl2.instance.textual.Instance.ConnectionInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_5_3_0()); 
	    }
		lv_flowSpecification_8_0=ruleFlowSpecificationInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
	        }
       		add(
       			$current, 
       			"flowSpecification",
        		lv_flowSpecification_8_0, 
        		"org.osate.aadl2.instance.textual.Instance.FlowSpecificationInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_5_4_0()); 
	    }
		lv_endToEndFlow_9_0=ruleEndToEndFlowInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
	        }
       		add(
       			$current, 
       			"endToEndFlow",
        		lv_endToEndFlow_9_0, 
        		"org.osate.aadl2.instance.textual.Instance.EndToEndFlowInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getModeInstanceModeInstanceParserRuleCall_5_5_0()); 
	    }
		lv_modeInstance_10_0=ruleModeInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
	        }
       		add(
       			$current, 
       			"modeInstance",
        		lv_modeInstance_10_0, 
        		"org.osate.aadl2.instance.textual.Instance.ModeInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_5_6_0()); 
	    }
		lv_modeTransitionInstance_11_0=ruleModeTransitionInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
	        }
       		add(
       			$current, 
       			"modeTransitionInstance",
        		lv_modeTransitionInstance_11_0, 
        		"org.osate.aadl2.instance.textual.Instance.ModeTransitionInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_7_0()); 
	    }
		lv_systemOperationMode_12_0=ruleSystemOperationMode		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
	        }
       		add(
       			$current, 
       			"systemOperationMode",
        		lv_systemOperationMode_12_0, 
        		"org.osate.aadl2.instance.textual.Instance.SystemOperationMode");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_5_8_0()); 
	    }
		lv_ownedPropertyAssociation_13_0=rulePropertyAssociationInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
	        }
       		add(
       			$current, 
       			"ownedPropertyAssociation",
        		lv_ownedPropertyAssociation_13_0, 
        		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_14='}' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6());
    }
)
;





// Entry rule entryRuleFeatureInstance
entryRuleFeatureInstance returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFeatureInstanceRule()); }
	 iv_ruleFeatureInstance=ruleFeatureInstance 
	 { $current=$iv_ruleFeatureInstance.current; } 
	 EOF 
;

// Rule FeatureInstance
ruleFeatureInstance returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_0_0()); 
	    }
		lv_direction_0_0=ruleDirectionType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
	        }
       		set(
       			$current, 
       			"direction",
        		lv_direction_0_0, 
        		"org.osate.aadl2.instance.textual.Instance.DirectionType");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_1_0()); 
	    }
		lv_category_1_0=ruleFeatureCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
	        }
       		set(
       			$current, 
       			"category",
        		lv_category_1_0, 
        		"org.osate.aadl2.instance.textual.Instance.FeatureCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getFeatureInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFeatureInstanceRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"org.osate.xtext.aadl2.properties.Properties.ID");
	    }

)
)(	otherlv_3='[' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getIndexLongParserRuleCall_3_1_0()); 
	    }
		lv_index_4_0=ruleLong		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
	        }
       		set(
       			$current, 
       			"index",
        		lv_index_4_0, 
        		"org.osate.aadl2.instance.textual.Instance.Long");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_5=']' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2());
    }
)?	otherlv_6=':' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getFeatureInstanceAccess().getColonKeyword_4());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFeatureInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
	    }
		ruleDeclarativeRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_8='{' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_6_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_1_0_0()); 
	    }
		lv_featureInstance_9_0=ruleFeatureInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
	        }
       		add(
       			$current, 
       			"featureInstance",
        		lv_featureInstance_9_0, 
        		"org.osate.aadl2.instance.textual.Instance.FeatureInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_6_1_1_0()); 
	    }
		lv_ownedPropertyAssociation_10_0=rulePropertyAssociationInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
	        }
       		add(
       			$current, 
       			"ownedPropertyAssociation",
        		lv_ownedPropertyAssociation_10_0, 
        		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_11='}' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getFeatureInstanceAccess().getRightCurlyBracketKeyword_6_2());
    }
)?)
;





// Entry rule entryRuleComponentInstance
entryRuleComponentInstance returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getComponentInstanceRule()); }
	 iv_ruleComponentInstance=ruleComponentInstance 
	 { $current=$iv_ruleComponentInstance.current; } 
	 EOF 
;

// Rule ComponentInstance
ruleComponentInstance returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
	    }
		lv_category_0_0=ruleComponentCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
	        }
       		set(
       			$current, 
       			"category",
        		lv_category_0_0, 
        		"org.osate.aadl2.instance.textual.Instance.ComponentCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getComponentInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getClassifierComponentClassifierCrossReference_1_0()); 
	    }
		ruleClassifierRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getComponentInstanceRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"org.osate.xtext.aadl2.properties.Properties.ID");
	    }

)
)(	otherlv_3='[' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getIndexLongParserRuleCall_3_1_0()); 
	    }
		lv_index_4_0=ruleLong		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
	        }
       		add(
       			$current, 
       			"index",
        		lv_index_4_0, 
        		"org.osate.aadl2.instance.textual.Instance.Long");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_5=']' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_3_2());
    }
)*(	otherlv_6='in' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getComponentInstanceAccess().getInKeyword_4_0());
    }
	otherlv_7='modes' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getComponentInstanceAccess().getModesKeyword_4_1());
    }
	otherlv_8='(' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_4_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getComponentInstanceRule());
	        }
        }
	otherlv_9=RULE_ID
	{
		newLeafNode(otherlv_9, grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_4_3_0()); 
	}

)
)(	otherlv_10=',' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getComponentInstanceAccess().getCommaKeyword_4_4_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getComponentInstanceRule());
	        }
        }
	otherlv_11=RULE_ID
	{
		newLeafNode(otherlv_11, grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_4_4_1_0()); 
	}

)
))*	otherlv_12=')' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_4_5());
    }
)?	otherlv_13=':' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getComponentInstanceAccess().getColonKeyword_5());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getComponentInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_6_0()); 
	    }
		ruleDeclarativeRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_15='{' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_7_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_1_0_0()); 
	    }
		lv_featureInstance_16_0=ruleFeatureInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
	        }
       		add(
       			$current, 
       			"featureInstance",
        		lv_featureInstance_16_0, 
        		"org.osate.aadl2.instance.textual.Instance.FeatureInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_1_1_0()); 
	    }
		lv_componentInstance_17_0=ruleComponentInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
	        }
       		add(
       			$current, 
       			"componentInstance",
        		lv_componentInstance_17_0, 
        		"org.osate.aadl2.instance.textual.Instance.ComponentInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_7_1_2_0()); 
	    }
		lv_connectionInstance_18_0=ruleConnectionInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
	        }
       		add(
       			$current, 
       			"connectionInstance",
        		lv_connectionInstance_18_0, 
        		"org.osate.aadl2.instance.textual.Instance.ConnectionInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_7_1_3_0()); 
	    }
		lv_flowSpecification_19_0=ruleFlowSpecificationInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
	        }
       		add(
       			$current, 
       			"flowSpecification",
        		lv_flowSpecification_19_0, 
        		"org.osate.aadl2.instance.textual.Instance.FlowSpecificationInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_7_1_4_0()); 
	    }
		lv_endToEndFlow_20_0=ruleEndToEndFlowInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
	        }
       		add(
       			$current, 
       			"endToEndFlow",
        		lv_endToEndFlow_20_0, 
        		"org.osate.aadl2.instance.textual.Instance.EndToEndFlowInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_7_1_5_0()); 
	    }
		lv_modeInstance_21_0=ruleModeInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
	        }
       		add(
       			$current, 
       			"modeInstance",
        		lv_modeInstance_21_0, 
        		"org.osate.aadl2.instance.textual.Instance.ModeInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_7_1_6_0()); 
	    }
		lv_modeTransitionInstance_22_0=ruleModeTransitionInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
	        }
       		add(
       			$current, 
       			"modeTransitionInstance",
        		lv_modeTransitionInstance_22_0, 
        		"org.osate.aadl2.instance.textual.Instance.ModeTransitionInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_7_1_7_0()); 
	    }
		lv_ownedPropertyAssociation_23_0=rulePropertyAssociationInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
	        }
       		add(
       			$current, 
       			"ownedPropertyAssociation",
        		lv_ownedPropertyAssociation_23_0, 
        		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_24='}' 
    {
    	newLeafNode(otherlv_24, grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_7_2());
    }
)?)
;





// Entry rule entryRuleConnectionInstance
entryRuleConnectionInstance returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getConnectionInstanceRule()); }
	 iv_ruleConnectionInstance=ruleConnectionInstance 
	 { $current=$iv_ruleConnectionInstance.current; } 
	 EOF 
;

// Rule ConnectionInstance
ruleConnectionInstance returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_complete_0_0=	'complete' 
    {
        newLeafNode(lv_complete_0_0, grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionInstanceRule());
	        }
       		setWithLastConsumed($current, "complete", true, "complete");
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_1_0()); 
	    }
		lv_kind_1_0=ruleConnectionKind		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConnectionInstanceRule());
	        }
       		set(
       			$current, 
       			"kind",
        		lv_kind_1_0, 
        		"org.osate.aadl2.instance.textual.Instance.ConnectionKind");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_name_2_0=RULE_STRING
		{
			newLeafNode(lv_name_2_0, grammarAccess.getConnectionInstanceAccess().getNameSTRINGTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionInstanceRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"org.osate.xtext.aadl2.properties.Properties.STRING");
	    }

)
)	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getConnectionInstanceAccess().getColonKeyword_3());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_4_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)((
(
		lv_bidirectional_5_0=	'<->' 
    {
        newLeafNode(lv_bidirectional_5_0, grammarAccess.getConnectionInstanceAccess().getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionInstanceRule());
	        }
       		setWithLastConsumed($current, "bidirectional", true, "<->");
	    }

)
)
    |	otherlv_6='->' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getConnectionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1());
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_6_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_8='in' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getConnectionInstanceAccess().getInKeyword_7_0());
    }
	otherlv_9='modes' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getConnectionInstanceAccess().getModesKeyword_7_1());
    }
	otherlv_10='(' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_7_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionInstanceRule());
	        }
        }
	otherlv_11=RULE_ID
	{
		newLeafNode(otherlv_11, grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_3_0()); 
	}

)
)(	otherlv_12=',' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getConnectionInstanceAccess().getCommaKeyword_7_4_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionInstanceRule());
	        }
        }
	otherlv_13=RULE_ID
	{
		newLeafNode(otherlv_13, grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_4_1_0()); 
	}

)
))*	otherlv_14=')' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getConnectionInstanceAccess().getRightParenthesisKeyword_7_5());
    }
)?(	otherlv_15='in' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getConnectionInstanceAccess().getInKeyword_8_0());
    }
	otherlv_16='transitions' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getConnectionInstanceAccess().getTransitionsKeyword_8_1());
    }
	otherlv_17='(' 
    {
    	newLeafNode(otherlv_17, grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_8_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_3_0()); 
	    }
		ruleTransitionRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_19=',' 
    {
    	newLeafNode(otherlv_19, grammarAccess.getConnectionInstanceAccess().getCommaKeyword_8_4_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0()); 
	    }
		ruleTransitionRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_21=')' 
    {
    	newLeafNode(otherlv_21, grammarAccess.getConnectionInstanceAccess().getRightParenthesisKeyword_8_5());
    }
)?	otherlv_22='{' 
    {
    	newLeafNode(otherlv_22, grammarAccess.getConnectionInstanceAccess().getLeftCurlyBracketKeyword_9());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_10_0_0()); 
	    }
		lv_connectionReference_23_0=ruleConnectionReference		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConnectionInstanceRule());
	        }
       		add(
       			$current, 
       			"connectionReference",
        		lv_connectionReference_23_0, 
        		"org.osate.aadl2.instance.textual.Instance.ConnectionReference");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0()); 
	    }
		lv_ownedPropertyAssociation_24_0=rulePropertyAssociationInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConnectionInstanceRule());
	        }
       		add(
       			$current, 
       			"ownedPropertyAssociation",
        		lv_ownedPropertyAssociation_24_0, 
        		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
	        afterParserOrEnumRuleCall();
	    }

)
))+	otherlv_25='}' 
    {
    	newLeafNode(otherlv_25, grammarAccess.getConnectionInstanceAccess().getRightCurlyBracketKeyword_11());
    }
)
;





// Entry rule entryRuleConnectionReference
entryRuleConnectionReference returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getConnectionReferenceRule()); }
	 iv_ruleConnectionReference=ruleConnectionReference 
	 { $current=$iv_ruleConnectionReference.current; } 
	 EOF 
;

// Rule ConnectionReference
ruleConnectionReference returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionReferenceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_0_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='->' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getConnectionReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionReferenceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_2_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getConnectionReferenceAccess().getColonKeyword_3());
    }
(
(
		lv_reverse_4_0=	'reverse' 
    {
        newLeafNode(lv_reverse_4_0, grammarAccess.getConnectionReferenceAccess().getReverseReverseKeyword_4_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionReferenceRule());
	        }
       		setWithLastConsumed($current, "reverse", true, "reverse");
	    }

)
)?(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionReferenceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_5_0()); 
	    }
		ruleDeclarativeRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_6='in' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getConnectionReferenceAccess().getInKeyword_6());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectionReferenceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_7_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleFlowSpecificationInstance
entryRuleFlowSpecificationInstance returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFlowSpecificationInstanceRule()); }
	 iv_ruleFlowSpecificationInstance=ruleFlowSpecificationInstance 
	 { $current=$iv_ruleFlowSpecificationInstance.current; } 
	 EOF 
;

// Rule FlowSpecificationInstance
ruleFlowSpecificationInstance returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='flow' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getFlowSpecificationInstanceAccess().getFlowKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getFlowSpecificationInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"org.osate.xtext.aadl2.properties.Properties.ID");
	    }

)
)	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceCrossReference_3_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_4='->' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getFlowSpecificationInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceCrossReference_5_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_6=')' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_6());
    }
(	otherlv_7='in' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_7_0());
    }
	otherlv_8='modes' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getFlowSpecificationInstanceAccess().getModesKeyword_7_1());
    }
	otherlv_9='(' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_7_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
	        }
        }
	otherlv_10=RULE_ID
	{
		newLeafNode(otherlv_10, grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_3_0()); 
	}

)
)(	otherlv_11=',' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_7_4_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
	        }
        }
	otherlv_12=RULE_ID
	{
		newLeafNode(otherlv_12, grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_4_1_0()); 
	}

)
))*	otherlv_13=')' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_7_5());
    }
)?(	otherlv_14='in' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_8_0());
    }
	otherlv_15='transitions' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getFlowSpecificationInstanceAccess().getTransitionsKeyword_8_1());
    }
	otherlv_16='(' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_8_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_3_0()); 
	    }
		ruleTransitionRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_18=',' 
    {
    	newLeafNode(otherlv_18, grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_8_4_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0()); 
	    }
		ruleTransitionRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_20=')' 
    {
    	newLeafNode(otherlv_20, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_8_5());
    }
)?	otherlv_21=':' 
    {
    	newLeafNode(otherlv_21, grammarAccess.getFlowSpecificationInstanceAccess().getColonKeyword_9());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_10_0()); 
	    }
		ruleDeclarativeRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_23='{' 
    {
    	newLeafNode(otherlv_23, grammarAccess.getFlowSpecificationInstanceAccess().getLeftCurlyBracketKeyword_11_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_11_1_0()); 
	    }
		lv_ownedPropertyAssociation_24_0=rulePropertyAssociationInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFlowSpecificationInstanceRule());
	        }
       		add(
       			$current, 
       			"ownedPropertyAssociation",
        		lv_ownedPropertyAssociation_24_0, 
        		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_25='}' 
    {
    	newLeafNode(otherlv_25, grammarAccess.getFlowSpecificationInstanceAccess().getRightCurlyBracketKeyword_11_2());
    }
)?)
;





// Entry rule entryRuleEndToEndFlowInstance
entryRuleEndToEndFlowInstance returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getEndToEndFlowInstanceRule()); }
	 iv_ruleEndToEndFlowInstance=ruleEndToEndFlowInstance 
	 { $current=$iv_ruleEndToEndFlowInstance.current; } 
	 EOF 
;

// Rule EndToEndFlowInstance
ruleEndToEndFlowInstance returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='end' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_0());
    }
	otherlv_1='to' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getEndToEndFlowInstanceAccess().getToKeyword_1());
    }
	otherlv_2='end' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_2());
    }
	otherlv_3='flow' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getEndToEndFlowInstanceAccess().getFlowKeyword_3());
    }
(
(
		lv_name_4_0=RULE_ID
		{
			newLeafNode(lv_name_4_0, grammarAccess.getEndToEndFlowInstanceAccess().getNameIDTerminalRuleCall_4_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_4_0, 
        		"org.osate.xtext.aadl2.properties.Properties.ID");
	    }

)
)((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_6='->' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getEndToEndFlowInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_1_1_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))*)?(	otherlv_8='in' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0());
    }
	otherlv_9='modes' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getEndToEndFlowInstanceAccess().getModesKeyword_6_1());
    }
	otherlv_10='(' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getEndToEndFlowInstanceAccess().getLeftParenthesisKeyword_6_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
	        }
        }
	otherlv_11=RULE_ID
	{
		newLeafNode(otherlv_11, grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_3_0()); 
	}

)
)(	otherlv_12=',' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getEndToEndFlowInstanceAccess().getCommaKeyword_6_4_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
	        }
        }
	otherlv_13=RULE_ID
	{
		newLeafNode(otherlv_13, grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_4_1_0()); 
	}

)
))*	otherlv_14=')' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getEndToEndFlowInstanceAccess().getRightParenthesisKeyword_6_5());
    }
)?	otherlv_15=':' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getEndToEndFlowInstanceAccess().getColonKeyword_7());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_8_0()); 
	    }
		ruleDeclarativeRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_17='{' 
    {
    	newLeafNode(otherlv_17, grammarAccess.getEndToEndFlowInstanceAccess().getLeftCurlyBracketKeyword_9_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_9_1_0()); 
	    }
		lv_ownedPropertyAssociation_18_0=rulePropertyAssociationInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getEndToEndFlowInstanceRule());
	        }
       		add(
       			$current, 
       			"ownedPropertyAssociation",
        		lv_ownedPropertyAssociation_18_0, 
        		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_19='}' 
    {
    	newLeafNode(otherlv_19, grammarAccess.getEndToEndFlowInstanceAccess().getRightCurlyBracketKeyword_9_2());
    }
)?)
;





// Entry rule entryRuleModeInstance
entryRuleModeInstance returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getModeInstanceRule()); }
	 iv_ruleModeInstance=ruleModeInstance 
	 { $current=$iv_ruleModeInstance.current; } 
	 EOF 
;

// Rule ModeInstance
ruleModeInstance returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_initial_0_0=	'initial' 
    {
        newLeafNode(lv_initial_0_0, grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getModeInstanceRule());
	        }
       		setWithLastConsumed($current, "initial", true, "initial");
	    }

)
)?(
(
		lv_derived_1_0=	'derived' 
    {
        newLeafNode(lv_derived_1_0, grammarAccess.getModeInstanceAccess().getDerivedDerivedKeyword_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getModeInstanceRule());
	        }
       		setWithLastConsumed($current, "derived", true, "derived");
	    }

)
)?	otherlv_2='mode' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getModeInstanceAccess().getModeKeyword_2());
    }
(
(
		lv_name_3_0=RULE_ID
		{
			newLeafNode(lv_name_3_0, grammarAccess.getModeInstanceAccess().getNameIDTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getModeInstanceRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_3_0, 
        		"org.osate.xtext.aadl2.properties.Properties.ID");
	    }

)
)(	otherlv_4='=' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getModeInstanceAccess().getEqualsSignKeyword_4_0());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModeInstanceRule());
	        }
        }
	otherlv_5=RULE_ID
	{
		newLeafNode(otherlv_5, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_0_0()); 
	}

)
)
    |(	otherlv_6='(' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getModeInstanceAccess().getLeftParenthesisKeyword_4_1_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModeInstanceRule());
	        }
        }
	otherlv_7=RULE_ID
	{
		newLeafNode(otherlv_7, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_1_0()); 
	}

)
)(	otherlv_8=',' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getModeInstanceAccess().getCommaKeyword_4_1_1_2_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModeInstanceRule());
	        }
        }
	otherlv_9=RULE_ID
	{
		newLeafNode(otherlv_9, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_2_1_0()); 
	}

)
))+	otherlv_10=')' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getModeInstanceAccess().getRightParenthesisKeyword_4_1_1_3());
    }
)))?	otherlv_11=':' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getModeInstanceAccess().getColonKeyword_5());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModeInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getModeInstanceAccess().getModeModeCrossReference_6_0()); 
	    }
		ruleDeclarativeRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_13='{' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getModeInstanceAccess().getLeftCurlyBracketKeyword_7_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getModeInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_7_1_0()); 
	    }
		lv_ownedPropertyAssociation_14_0=rulePropertyAssociationInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModeInstanceRule());
	        }
       		add(
       			$current, 
       			"ownedPropertyAssociation",
        		lv_ownedPropertyAssociation_14_0, 
        		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_15='}' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getModeInstanceAccess().getRightCurlyBracketKeyword_7_2());
    }
)?)
;





// Entry rule entryRuleModeTransitionInstance
entryRuleModeTransitionInstance returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getModeTransitionInstanceRule()); }
	 iv_ruleModeTransitionInstance=ruleModeTransitionInstance 
	 { $current=$iv_ruleModeTransitionInstance.current; } 
	 EOF 
;

// Rule ModeTransitionInstance
ruleModeTransitionInstance returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='mode' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0());
    }
	otherlv_1='transition' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1());
    }
(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getModeTransitionInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"org.osate.xtext.aadl2.properties.Properties.ID");
	    }

)
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
	        }
        }
	otherlv_3=RULE_ID
	{
		newLeafNode(otherlv_3, grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_3_0()); 
	}

)
)	otherlv_4='-[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getModeTransitionInstanceAccess().getHyphenMinusLeftSquareBracketKeyword_4());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getTriggerFeatureInstanceCrossReference_5_0_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_6=',' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getModeTransitionInstanceAccess().getCommaKeyword_5_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getTriggerFeatureInstanceCrossReference_5_1_1_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_8=']->' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getModeTransitionInstanceAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_6());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
	        }
        }
	otherlv_9=RULE_ID
	{
		newLeafNode(otherlv_9, grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_7_0()); 
	}

)
)	otherlv_10=':' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getModeTransitionInstanceAccess().getColonKeyword_8());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_9_0()); 
	    }
		ruleDeclarativeRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_12='{' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getModeTransitionInstanceAccess().getLeftCurlyBracketKeyword_10_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0()); 
	    }
		lv_ownedPropertyAssociation_13_0=rulePropertyAssociationInstance		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModeTransitionInstanceRule());
	        }
       		add(
       			$current, 
       			"ownedPropertyAssociation",
        		lv_ownedPropertyAssociation_13_0, 
        		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_14='}' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getModeTransitionInstanceAccess().getRightCurlyBracketKeyword_10_2());
    }
)?)
;





// Entry rule entryRuleSystemOperationMode
entryRuleSystemOperationMode returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSystemOperationModeRule()); }
	 iv_ruleSystemOperationMode=ruleSystemOperationMode 
	 { $current=$iv_ruleSystemOperationMode.current; } 
	 EOF 
;

// Rule SystemOperationMode
ruleSystemOperationMode returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='som' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getSystemOperationModeAccess().getSomKeyword_0());
    }
(
(
		lv_name_1_0=RULE_STRING
		{
			newLeafNode(lv_name_1_0, grammarAccess.getSystemOperationModeAccess().getNameSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemOperationModeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"org.osate.xtext.aadl2.properties.Properties.STRING");
	    }

)
)((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemOperationModeRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_0_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getSystemOperationModeAccess().getCommaKeyword_2_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemOperationModeRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_1_1_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))*)?)
;





// Entry rule entryRulePropertyAssociationInstance
entryRulePropertyAssociationInstance returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPropertyAssociationInstanceRule()); }
	 iv_rulePropertyAssociationInstance=rulePropertyAssociationInstance 
	 { $current=$iv_rulePropertyAssociationInstance.current; } 
	 EOF 
;

// Rule PropertyAssociationInstance
rulePropertyAssociationInstance returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getPropertyAssociationInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyPropertyCrossReference_0_0()); 
	    }
		ruleQPREF		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='=>' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getPropertyAssociationInstanceAccess().getEqualsSignGreaterThanSignKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_2_0()); 
	    }
		lv_ownedValue_2_0=ruleOptionalModalPropertyValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPropertyAssociationInstanceRule());
	        }
       		add(
       			$current, 
       			"ownedValue",
        		lv_ownedValue_2_0, 
        		"org.osate.aadl2.instance.textual.Instance.OptionalModalPropertyValue");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getPropertyAssociationInstanceAccess().getCommaKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_0()); 
	    }
		lv_ownedValue_4_0=ruleOptionalModalPropertyValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPropertyAssociationInstanceRule());
	        }
       		add(
       			$current, 
       			"ownedValue",
        		lv_ownedValue_4_0, 
        		"org.osate.aadl2.instance.textual.Instance.OptionalModalPropertyValue");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_5=':' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getPropertyAssociationInstanceAccess().getColonKeyword_4());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getPropertyAssociationInstanceRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssociationPropertyAssociationCrossReference_5_0()); 
	    }
		rulePropertyAssociationRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleOptionalModalPropertyValue
entryRuleOptionalModalPropertyValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getOptionalModalPropertyValueRule()); }
	 iv_ruleOptionalModalPropertyValue=ruleOptionalModalPropertyValue 
	 { $current=$iv_ruleOptionalModalPropertyValue.current; } 
	 EOF 
;

// Rule OptionalModalPropertyValue
ruleOptionalModalPropertyValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); 
	    }
		lv_ownedValue_0_0=rulePropertyExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOptionalModalPropertyValueRule());
	        }
       		set(
       			$current, 
       			"ownedValue",
        		lv_ownedValue_0_0, 
        		"org.osate.aadl2.instance.textual.Instance.PropertyExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='in' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getOptionalModalPropertyValueAccess().getInKeyword_1_0());
    }
	otherlv_2='modes' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getModesKeyword_1_1());
    }
	otherlv_3='(' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
	        }
        }
	otherlv_4=RULE_ID
	{
		newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_0()); 
	}

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_4_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
	        }
        }
	otherlv_6=RULE_ID
	{
		newLeafNode(otherlv_6, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_4_1_0()); 
	}

)
))*	otherlv_7=')' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_5());
    }
)?)
;





// Entry rule entryRulePropertyExpression
entryRulePropertyExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPropertyExpressionRule()); }
	 iv_rulePropertyExpression=rulePropertyExpression 
	 { $current=$iv_rulePropertyExpression.current; } 
	 EOF 
;

// Rule PropertyExpression
rulePropertyExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
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
        newCompositeNode(grammarAccess.getPropertyExpressionAccess().getInstanceReferenceValueParserRuleCall_2()); 
    }
    this_InstanceReferenceValue_2=ruleInstanceReferenceValue
    { 
        $current = $this_InstanceReferenceValue_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_3()); 
    }
    this_ComponentClassifierTerm_3=ruleComponentClassifierTerm
    { 
        $current = $this_ComponentClassifierTerm_3.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_4()); 
    }
    this_ComputedTerm_4=ruleComputedTerm
    { 
        $current = $this_ComputedTerm_4.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_5()); 
    }
    this_StringTerm_5=ruleStringTerm
    { 
        $current = $this_StringTerm_5.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_6()); 
    }
    this_NumericRangeTerm_6=ruleNumericRangeTerm
    { 
        $current = $this_NumericRangeTerm_6.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_7()); 
    }
    this_RealTerm_7=ruleRealTerm
    { 
        $current = $this_RealTerm_7.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_8()); 
    }
    this_IntegerTerm_8=ruleIntegerTerm
    { 
        $current = $this_IntegerTerm_8.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_9()); 
    }
    this_ListTerm_9=ruleListTerm
    { 
        $current = $this_ListTerm_9.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_10()); 
    }
    this_BooleanLiteral_10=ruleBooleanLiteral
    { 
        $current = $this_BooleanLiteral_10.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_11()); 
    }
    this_LiteralorReferenceTerm_11=ruleLiteralorReferenceTerm
    { 
        $current = $this_LiteralorReferenceTerm_11.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleContainmentPathElement
entryRuleContainmentPathElement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getContainmentPathElementRule()); }
	 iv_ruleContainmentPathElement=ruleContainmentPathElement 
	 { $current=$iv_ruleContainmentPathElement.current; } 
	 EOF 
;

// Rule ContainmentPathElement
ruleContainmentPathElement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getContainmentPathElementRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0()); 
	    }
		ruleDeclarativeRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_1_0()); 
	    }
		lv_arrayRange_1_0=ruleArrayRange		{
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
)?(	otherlv_2='/' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getSolidusKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_2_1_0()); 
	    }
		lv_path_3_0=ruleContainmentPathElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
	        }
       		set(
       			$current, 
       			"path",
        		lv_path_3_0, 
        		"org.osate.aadl2.instance.textual.Instance.ContainmentPathElement");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;





// Entry rule entryRuleInstanceReferenceValue
entryRuleInstanceReferenceValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getInstanceReferenceValueRule()); }
	 iv_ruleInstanceReferenceValue=ruleInstanceReferenceValue 
	 { $current=$iv_ruleInstanceReferenceValue.current; } 
	 EOF 
;

// Rule InstanceReferenceValue
ruleInstanceReferenceValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='reference' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getInstanceReferenceValueAccess().getReferenceKeyword_0());
    }
	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getInstanceReferenceValueAccess().getLeftParenthesisKeyword_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getInstanceReferenceValueRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getInstanceReferenceValueAccess().getReferencedInstanceObjectInstanceObjectCrossReference_2_0()); 
	    }
		ruleInstanceRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=')' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getInstanceReferenceValueAccess().getRightParenthesisKeyword_3());
    }
)
;





// Entry rule entryRuleDirectionType
entryRuleDirectionType returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getDirectionTypeRule()); } 
	 iv_ruleDirectionType=ruleDirectionType 
	 { $current=$iv_ruleDirectionType.current.getText(); }  
	 EOF 
;

// Rule DirectionType
ruleDirectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='in' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
    }

    |
	kw='out' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
    }

    |(
	kw='in' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 
    }

	kw='out' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_2_1()); 
    }
))
    ;





// Entry rule entryRuleFeatureCategory
entryRuleFeatureCategory returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getFeatureCategoryRule()); } 
	 iv_ruleFeatureCategory=ruleFeatureCategory 
	 { $current=$iv_ruleFeatureCategory.current.getText(); }  
	 EOF 
;

// Rule FeatureCategory
ruleFeatureCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='dataPort' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 
    }

    |
	kw='eventPort' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 
    }

    |
	kw='eventDataPort' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 
    }

    |
	kw='parameter' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
    }

    |
	kw='busAccess' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 
    }

    |
	kw='dataAccess' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataAccessKeyword_5()); 
    }

    |
	kw='subprogramAccess' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_6()); 
    }

    |
	kw='subprogramGroupAccess' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_7()); 
    }

    |
	kw='featureGroup' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_8()); 
    }

    |
	kw='abstractFeature' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getAbstractFeatureKeyword_9()); 
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





// Entry rule entryRuleConnectionKind
entryRuleConnectionKind returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getConnectionKindRule()); } 
	 iv_ruleConnectionKind=ruleConnectionKind 
	 { $current=$iv_ruleConnectionKind.current.getText(); }  
	 EOF 
;

// Rule ConnectionKind
ruleConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='featureConnection' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); 
    }

    |
	kw='accessConnection' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); 
    }

    |
	kw='parameterConnection' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); 
    }

    |
	kw='portConnection' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); 
    }

    |
	kw='featureGroupConnection' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureGroupConnectionKeyword_4()); 
    }
)
    ;





// Entry rule entryRuleClassifierRef
entryRuleClassifierRef returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getClassifierRefRule()); } 
	 iv_ruleClassifierRef=ruleClassifierRef 
	 { $current=$iv_ruleClassifierRef.current.getText(); }  
	 EOF 
;

// Rule ClassifierRef
ruleClassifierRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_0_0()); 
    }

	kw='::' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getClassifierRefAccess().getColonColonKeyword_0_1()); 
    }
)+    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_1()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getClassifierRefAccess().getFullStopKeyword_2_0()); 
    }
    this_ID_4=RULE_ID    {
		$current.merge(this_ID_4);
    }

    { 
    newLeafNode(this_ID_4, grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_2_1()); 
    }
)?)
    ;





// Entry rule entryRuleImplRef
entryRuleImplRef returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getImplRefRule()); } 
	 iv_ruleImplRef=ruleImplRef 
	 { $current=$iv_ruleImplRef.current.getText(); }  
	 EOF 
;

// Rule ImplRef
ruleImplRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_0_0()); 
    }

	kw='::' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getImplRefAccess().getColonColonKeyword_0_1()); 
    }
)+    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_1()); 
    }

	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getImplRefAccess().getFullStopKeyword_2()); 
    }
    this_ID_4=RULE_ID    {
		$current.merge(this_ID_4);
    }

    { 
    newLeafNode(this_ID_4, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_3()); 
    }
)
    ;





// Entry rule entryRuleDeclarativeRef
entryRuleDeclarativeRef returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getDeclarativeRefRule()); } 
	 iv_ruleDeclarativeRef=ruleDeclarativeRef 
	 { $current=$iv_ruleDeclarativeRef.current.getText(); }  
	 EOF 
;

// Rule DeclarativeRef
ruleDeclarativeRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_0_0()); 
    }

	kw='::' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getColonColonKeyword_0_1()); 
    }
)+    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_1()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getFullStopKeyword_2_0()); 
    }
    this_ID_4=RULE_ID    {
		$current.merge(this_ID_4);
    }

    { 
    newLeafNode(this_ID_4, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_2_1()); 
    }
)?
	kw=':' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getColonKeyword_3()); 
    }
((
	kw='transition' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getTransitionKeyword_4_0_0()); 
    }

	kw='#' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getNumberSignKeyword_4_0_1()); 
    }
    this_INTEGER_LIT_8=RULE_INTEGER_LIT    {
		$current.merge(this_INTEGER_LIT_8);
    }

    { 
    newLeafNode(this_INTEGER_LIT_8, grammarAccess.getDeclarativeRefAccess().getINTEGER_LITTerminalRuleCall_4_0_2()); 
    }
)
    |    this_ID_9=RULE_ID    {
		$current.merge(this_ID_9);
    }

    { 
    newLeafNode(this_ID_9, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_4_1()); 
    }
))
    ;





// Entry rule entryRuleInstanceRef
entryRuleInstanceRef returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getInstanceRefRule()); } 
	 iv_ruleInstanceRef=ruleInstanceRef 
	 { $current=$iv_ruleInstanceRef.current.getText(); }  
	 EOF 
;

// Rule InstanceRef
ruleInstanceRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='parent' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getInstanceRefAccess().getParentKeyword_0()); 
    }

    |((    this_ID_1=RULE_ID    {
		$current.merge(this_ID_1);
    }

    { 
    newLeafNode(this_ID_1, grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_0_0()); 
    }
(
	kw='[' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_0_1_0()); 
    }
    this_INTEGER_LIT_3=RULE_INTEGER_LIT    {
		$current.merge(this_INTEGER_LIT_3);
    }

    { 
    newLeafNode(this_INTEGER_LIT_3, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_0_1_1()); 
    }

	kw=']' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_0_1_2()); 
    }
)*
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getInstanceRefAccess().getFullStopKeyword_1_0_2()); 
    }
)*((
	kw='connection' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getInstanceRefAccess().getConnectionKeyword_1_1_0_0()); 
    }

	kw='#' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getInstanceRefAccess().getNumberSignKeyword_1_1_0_1()); 
    }
    this_INTEGER_LIT_8=RULE_INTEGER_LIT    {
		$current.merge(this_INTEGER_LIT_8);
    }

    { 
    newLeafNode(this_INTEGER_LIT_8, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_0_2()); 
    }
)
    |(    this_ID_9=RULE_ID    {
		$current.merge(this_ID_9);
    }

    { 
    newLeafNode(this_ID_9, grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_1_1_0()); 
    }
(
	kw='[' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_1_1_1_0()); 
    }
    this_INTEGER_LIT_11=RULE_INTEGER_LIT    {
		$current.merge(this_INTEGER_LIT_11);
    }

    { 
    newLeafNode(this_INTEGER_LIT_11, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_1_1_1()); 
    }

	kw=']' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_1_1_1_2()); 
    }
)*))))
    ;





// Entry rule entryRuleTransitionRef
entryRuleTransitionRef returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getTransitionRefRule()); } 
	 iv_ruleTransitionRef=ruleTransitionRef 
	 { $current=$iv_ruleTransitionRef.current.getText(); }  
	 EOF 
;

// Rule TransitionRef
ruleTransitionRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='transition' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getTransitionRefAccess().getTransitionKeyword_0()); 
    }

	kw='#' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getTransitionRefAccess().getNumberSignKeyword_1()); 
    }
    this_INTEGER_LIT_2=RULE_INTEGER_LIT    {
		$current.merge(this_INTEGER_LIT_2);
    }

    { 
    newLeafNode(this_INTEGER_LIT_2, grammarAccess.getTransitionRefAccess().getINTEGER_LITTerminalRuleCall_2()); 
    }
)
    ;





// Entry rule entryRulePropertyAssociationRef
entryRulePropertyAssociationRef returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getPropertyAssociationRefRule()); } 
	 iv_rulePropertyAssociationRef=rulePropertyAssociationRef 
	 { $current=$iv_rulePropertyAssociationRef.current.getText(); }  
	 EOF 
;

// Rule PropertyAssociationRef
rulePropertyAssociationRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_0_0()); 
    }

	kw='::' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonColonKeyword_0_1()); 
    }
)+    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_1()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getFullStopKeyword_2_0()); 
    }
    this_ID_4=RULE_ID    {
		$current.merge(this_ID_4);
    }

    { 
    newLeafNode(this_ID_4, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_2_1()); 
    }
)?
	kw=':' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_3()); 
    }
((    this_ID_6=RULE_ID    {
		$current.merge(this_ID_6);
    }

    { 
    newLeafNode(this_ID_6, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_4_0_0()); 
    }

    |(
	kw='transition' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getTransitionKeyword_4_0_1_0()); 
    }

	kw='#' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getNumberSignKeyword_4_0_1_1()); 
    }
    this_INTEGER_LIT_9=RULE_INTEGER_LIT    {
		$current.merge(this_INTEGER_LIT_9);
    }

    { 
    newLeafNode(this_INTEGER_LIT_9, grammarAccess.getPropertyAssociationRefAccess().getINTEGER_LITTerminalRuleCall_4_0_1_2()); 
    }
))
	kw=':' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_4_1()); 
    }
)?
	kw='property' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getPropertyKeyword_5()); 
    }

	kw='#' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getNumberSignKeyword_6()); 
    }
    this_INTEGER_LIT_13=RULE_INTEGER_LIT    {
		$current.merge(this_INTEGER_LIT_13);
    }

    { 
    newLeafNode(this_INTEGER_LIT_13, grammarAccess.getPropertyAssociationRefAccess().getINTEGER_LITTerminalRuleCall_7()); 
    }
)
    ;





// Entry rule entryRuleLong
entryRuleLong returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getLongRule()); } 
	 iv_ruleLong=ruleLong 
	 { $current=$iv_ruleLong.current.getText(); }  
	 EOF 
;

// Rule Long
ruleLong returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_INTEGER_LIT_0=RULE_INTEGER_LIT    {
		$current.merge(this_INTEGER_LIT_0);
    }

    { 
    newLeafNode(this_INTEGER_LIT_0, grammarAccess.getLongAccess().getINTEGER_LITTerminalRuleCall()); 
    }

    ;







// Entry rule entryRuleContainedPropertyAssociation
entryRuleContainedPropertyAssociation returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); }
	 iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation 
	 { $current=$iv_ruleContainedPropertyAssociation.current; } 
	 EOF 
;

// Rule ContainedPropertyAssociation
ruleContainedPropertyAssociation returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
	    }
		ruleQPREF		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='=>' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
    }

    |(
(
		lv_append_2_0=	'+=>' 
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
))(
(
		lv_constant_3_0=	'constant' 
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
)?((
(
		{ 
	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); 
	    }
		lv_ownedValue_4_0=ruleOptionalModalPropertyValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
	        }
       		add(
       			$current, 
       			"ownedValue",
        		lv_ownedValue_4_0, 
        		"org.osate.aadl2.instance.textual.Instance.OptionalModalPropertyValue");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); 
	    }
		lv_ownedValue_6_0=ruleOptionalModalPropertyValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
	        }
       		add(
       			$current, 
       			"ownedValue",
        		lv_ownedValue_6_0, 
        		"org.osate.aadl2.instance.textual.Instance.OptionalModalPropertyValue");
	        afterParserOrEnumRuleCall();
	    }

)
))*)(
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
		lv_appliesTo_8_0=ruleContainmentPath		{
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
)(	otherlv_9=',' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0()); 
	    }
		lv_appliesTo_10_0=ruleContainmentPath		{
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
))*)?(
    { 
        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0()); 
    }
ruleInBindingKeywords
    { 
        afterParserOrEnumRuleCall();
    }
	otherlv_12='(' 
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
		ruleQCREF		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_14=')' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3());
    }
)?	otherlv_15=';' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6());
    }
)
;









// Entry rule entryRuleContainmentPath
entryRuleContainmentPath returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getContainmentPathRule()); }
	 iv_ruleContainmentPath=ruleContainmentPath 
	 { $current=$iv_ruleContainmentPath.current; } 
	 EOF 
;

// Rule ContainmentPath
ruleContainmentPath returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0()); 
	    }
		lv_path_0_0=ruleContainmentPathElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getContainmentPathRule());
	        }
       		set(
       			$current, 
       			"path",
        		lv_path_0_0, 
        		"org.osate.aadl2.instance.textual.Instance.ContainmentPathElement");
	        afterParserOrEnumRuleCall();
	    }

)
)
;







// Entry rule entryRulePropertyValue
entryRulePropertyValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPropertyValueRule()); }
	 iv_rulePropertyValue=rulePropertyValue 
	 { $current=$iv_rulePropertyValue.current; } 
	 EOF 
;

// Rule PropertyValue
rulePropertyValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); 
	    }
		lv_ownedValue_0_0=rulePropertyExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPropertyValueRule());
	        }
       		set(
       			$current, 
       			"ownedValue",
        		lv_ownedValue_0_0, 
        		"org.osate.aadl2.instance.textual.Instance.PropertyExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleLiteralorReferenceTerm
entryRuleLiteralorReferenceTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getLiteralorReferenceTermRule()); }
	 iv_ruleLiteralorReferenceTerm=ruleLiteralorReferenceTerm 
	 { $current=$iv_ruleLiteralorReferenceTerm.current; } 
	 EOF 
;

// Rule LiteralorReferenceTerm
ruleLiteralorReferenceTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
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
		ruleQPREF		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleBooleanLiteral
entryRuleBooleanLiteral returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getBooleanLiteralRule()); }
	 iv_ruleBooleanLiteral=ruleBooleanLiteral 
	 { $current=$iv_ruleBooleanLiteral.current; } 
	 EOF 
;

// Rule BooleanLiteral
ruleBooleanLiteral returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
            $current);
    }
)((
(
		lv_value_1_0=	'true' 
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
    |	otherlv_2='false' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1());
    }
))
;





// Entry rule entryRuleConstantValue
entryRuleConstantValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getConstantValueRule()); }
	 iv_ruleConstantValue=ruleConstantValue 
	 { $current=$iv_ruleConstantValue.current; } 
	 EOF 
;

// Rule ConstantValue
ruleConstantValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
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
		ruleQPREF		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleReferenceTerm
entryRuleReferenceTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getReferenceTermRule()); }
	 iv_ruleReferenceTerm=ruleReferenceTerm 
	 { $current=$iv_ruleReferenceTerm.current; } 
	 EOF 
;

// Rule ReferenceTerm
ruleReferenceTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='reference' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
    }
	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0()); 
	    }
		lv_path_2_0=ruleContainmentPathElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReferenceTermRule());
	        }
       		set(
       			$current, 
       			"path",
        		lv_path_2_0, 
        		"org.osate.aadl2.instance.textual.Instance.ContainmentPathElement");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=')' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_3());
    }
)
;





// Entry rule entryRuleRecordTerm
entryRuleRecordTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRecordTermRule()); }
	 iv_ruleRecordTerm=ruleRecordTerm 
	 { $current=$iv_ruleRecordTerm.current; } 
	 EOF 
;

// Rule RecordTerm
ruleRecordTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='[' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); 
	    }
		lv_ownedFieldValue_1_0=ruleFieldPropertyAssociation		{
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
)+	otherlv_2=']' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2());
    }
)
;







// Entry rule entryRuleComputedTerm
entryRuleComputedTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getComputedTermRule()); }
	 iv_ruleComputedTerm=ruleComputedTerm 
	 { $current=$iv_ruleComputedTerm.current; } 
	 EOF 
;

// Rule ComputedTerm
ruleComputedTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='compute' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
    }
	otherlv_1='(' 
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
)	otherlv_3=')' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3());
    }
)
;





// Entry rule entryRuleComponentClassifierTerm
entryRuleComponentClassifierTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getComponentClassifierTermRule()); }
	 iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm 
	 { $current=$iv_ruleComponentClassifierTerm.current; } 
	 EOF 
;

// Rule ComponentClassifierTerm
ruleComponentClassifierTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='classifier' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
    }
	otherlv_1='(' 
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
		ruleQCREF		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=')' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3());
    }
)
;





// Entry rule entryRuleListTerm
entryRuleListTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getListTermRule()); }
	 iv_ruleListTerm=ruleListTerm 
	 { $current=$iv_ruleListTerm.current; } 
	 EOF 
;

// Rule ListTerm
ruleListTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getListTermAccess().getListValueAction_0(),
            $current);
    }
)	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0()); 
	    }
		lv_ownedListElement_2_0=rulePropertyExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getListTermRule());
	        }
       		add(
       			$current, 
       			"ownedListElement",
        		lv_ownedListElement_2_0, 
        		"org.osate.aadl2.instance.textual.Instance.PropertyExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0()); 
	    }
		lv_ownedListElement_4_0=rulePropertyExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getListTermRule());
	        }
       		add(
       			$current, 
       			"ownedListElement",
        		lv_ownedListElement_4_0, 
        		"org.osate.aadl2.instance.textual.Instance.PropertyExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5=')' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getListTermAccess().getRightParenthesisKeyword_3());
    }
)
;





// Entry rule entryRuleFieldPropertyAssociation
entryRuleFieldPropertyAssociation returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); }
	 iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation 
	 { $current=$iv_ruleFieldPropertyAssociation.current; } 
	 EOF 
;

// Rule FieldPropertyAssociation
ruleFieldPropertyAssociation returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
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
)	otherlv_1='=>' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
	    }
		lv_ownedValue_2_0=rulePropertyExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFieldPropertyAssociationRule());
	        }
       		set(
       			$current, 
       			"ownedValue",
        		lv_ownedValue_2_0, 
        		"org.osate.aadl2.instance.textual.Instance.PropertyExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=';' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3());
    }
)
;







// Entry rule entryRulePlusMinus
entryRulePlusMinus returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getPlusMinusRule()); } 
	 iv_rulePlusMinus=rulePlusMinus 
	 { $current=$iv_rulePlusMinus.current.getText(); }  
	 EOF 
;

// Rule PlusMinus
rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='+' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
    }

    |
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1()); 
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
        		"org.osate.xtext.aadl2.properties.Properties.NoQuoteString");
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





// Entry rule entryRuleArrayRange
entryRuleArrayRange returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getArrayRangeRule()); }
	 iv_ruleArrayRange=ruleArrayRange 
	 { $current=$iv_ruleArrayRange.current; } 
	 EOF 
;

// Rule ArrayRange
ruleArrayRange returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
            $current);
    }
)	otherlv_1='[' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); 
	    }
		lv_lowerBound_2_0=ruleINTVALUE		{
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
)(	otherlv_3='..' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0()); 
	    }
		lv_upperBound_4_0=ruleINTVALUE		{
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
))?	otherlv_5=']' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4());
    }
)
;





// Entry rule entryRuleSignedConstant
entryRuleSignedConstant returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSignedConstantRule()); }
	 iv_ruleSignedConstant=ruleSignedConstant 
	 { $current=$iv_ruleSignedConstant.current; } 
	 EOF 
;

// Rule SignedConstant
ruleSignedConstant returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
	    }
		lv_op_0_0=rulePlusMinus		{
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
)(
(
		{ 
	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); 
	    }
		lv_ownedPropertyExpression_1_0=ruleConstantValue		{
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
))
;





// Entry rule entryRuleIntegerTerm
entryRuleIntegerTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getIntegerTermRule()); }
	 iv_ruleIntegerTerm=ruleIntegerTerm 
	 { $current=$iv_ruleIntegerTerm.current; } 
	 EOF 
;

// Rule IntegerTerm
ruleIntegerTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); 
	    }
		lv_value_0_0=ruleSignedInt		{
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
)(
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
)?)
;





// Entry rule entryRuleSignedInt
entryRuleSignedInt returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getSignedIntRule()); } 
	 iv_ruleSignedInt=ruleSignedInt 
	 { $current=$iv_ruleSignedInt.current.getText(); }  
	 EOF 
;

// Rule SignedInt
ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	kw='+' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); 
    }

    |
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); 
    }
)?    this_INTEGER_LIT_2=RULE_INTEGER_LIT    {
		$current.merge(this_INTEGER_LIT_2);
    }

    { 
    newLeafNode(this_INTEGER_LIT_2, grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1()); 
    }
)
    ;





// Entry rule entryRuleRealTerm
entryRuleRealTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRealTermRule()); }
	 iv_ruleRealTerm=ruleRealTerm 
	 { $current=$iv_ruleRealTerm.current; } 
	 EOF 
;

// Rule RealTerm
ruleRealTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); 
	    }
		lv_value_0_0=ruleSignedReal		{
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
)(
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
)?)
;





// Entry rule entryRuleSignedReal
entryRuleSignedReal returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getSignedRealRule()); } 
	 iv_ruleSignedReal=ruleSignedReal 
	 { $current=$iv_ruleSignedReal.current.getText(); }  
	 EOF 
;

// Rule SignedReal
ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	kw='+' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); 
    }

    |
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1()); 
    }
)?    this_REAL_LIT_2=RULE_REAL_LIT    {
		$current.merge(this_REAL_LIT_2);
    }

    { 
    newLeafNode(this_REAL_LIT_2, grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1()); 
    }
)
    ;





// Entry rule entryRuleNumericRangeTerm
entryRuleNumericRangeTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNumericRangeTermRule()); }
	 iv_ruleNumericRangeTerm=ruleNumericRangeTerm 
	 { $current=$iv_ruleNumericRangeTerm.current; } 
	 EOF 
;

// Rule NumericRangeTerm
ruleNumericRangeTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); 
	    }
		lv_minimum_0_0=ruleNumAlt		{
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
)	otherlv_1='..' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); 
	    }
		lv_maximum_2_0=ruleNumAlt		{
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
)(	otherlv_3='delta' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0()); 
	    }
		lv_delta_4_0=ruleNumAlt		{
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
))?)
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
entryRuleAppliesToKeywords returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getAppliesToKeywordsRule()); } 
	 iv_ruleAppliesToKeywords=ruleAppliesToKeywords 
	 { $current=$iv_ruleAppliesToKeywords.current.getText(); }  
	 EOF 
;

// Rule AppliesToKeywords
ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='applies' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getAppliesKeyword_0()); 
    }

	kw='to' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getToKeyword_1()); 
    }
)
    ;





// Entry rule entryRuleInBindingKeywords
entryRuleInBindingKeywords returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getInBindingKeywordsRule()); } 
	 iv_ruleInBindingKeywords=ruleInBindingKeywords 
	 { $current=$iv_ruleInBindingKeywords.current.getText(); }  
	 EOF 
;

// Rule InBindingKeywords
ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='in' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getInKeyword_0()); 
    }

	kw='binding' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getBindingKeyword_1()); 
    }
)
    ;





// Entry rule entryRuleInModesKeywords
entryRuleInModesKeywords returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getInModesKeywordsRule()); } 
	 iv_ruleInModesKeywords=ruleInModesKeywords 
	 { $current=$iv_ruleInModesKeywords.current.getText(); }  
	 EOF 
;

// Rule InModesKeywords
ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='in' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getInKeyword_0()); 
    }

	kw='modes' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getModesKeyword_1()); 
    }
)
    ;





// Entry rule entryRuleINTVALUE
entryRuleINTVALUE returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getINTVALUERule()); } 
	 iv_ruleINTVALUE=ruleINTVALUE 
	 { $current=$iv_ruleINTVALUE.current.getText(); }  
	 EOF 
;

// Rule INTVALUE
ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_INTEGER_LIT_0=RULE_INTEGER_LIT    {
		$current.merge(this_INTEGER_LIT_0);
    }

    { 
    newLeafNode(this_INTEGER_LIT_0, grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall()); 
    }

    ;







// Entry rule entryRuleQPREF
entryRuleQPREF returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQPREFRule()); } 
	 iv_ruleQPREF=ruleQPREF 
	 { $current=$iv_ruleQPREF.current.getText(); }  
	 EOF 
;

// Rule QPREF
ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw='::' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1()); 
    }
)?)
    ;





// Entry rule entryRuleQCREF
entryRuleQCREF returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQCREFRule()); } 
	 iv_ruleQCREF=ruleQCREF 
	 { $current=$iv_ruleQCREF.current.getText(); }  
	 EOF 
;

// Rule QCREF
ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
    }

	kw='::' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
    }
)*    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
    }
    this_ID_4=RULE_ID    {
		$current.merge(this_ID_4);
    }

    { 
    newLeafNode(this_ID_4, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); 
    }
)?)
    ;





// Entry rule entryRuleSTAR
entryRuleSTAR returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getSTARRule()); } 
	 iv_ruleSTAR=ruleSTAR 
	 { $current=$iv_ruleSTAR.current.getText(); }  
	 EOF 
;

// Rule STAR
ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

	kw='*' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getSTARAccess().getAsteriskKeyword()); 
    }

    ;





RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

fragment RULE_EXPONENT : ('e'|'E') ('+'|'-')? RULE_DIGIT+;

fragment RULE_INT_EXPONENT : ('e'|'E') '+'? RULE_DIGIT+;

RULE_REAL_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* '.' RULE_DIGIT+ ('_' RULE_DIGIT+)* RULE_EXPONENT?;

RULE_INTEGER_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* ('#' RULE_BASED_INTEGER '#' RULE_INT_EXPONENT?|RULE_INT_EXPONENT?);

fragment RULE_DIGIT : '0'..'9';

fragment RULE_EXTENDED_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_BASED_INTEGER : RULE_EXTENDED_DIGIT ('_'? RULE_EXTENDED_DIGIT)*;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ID : ('a'..'z'|'A'..'Z') ('_'? ('a'..'z'|'A'..'Z'|'0'..'9'))*;

RULE_WS : (' '|'\t'|'\r'|'\n')+;


