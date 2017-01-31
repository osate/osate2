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
package org.osate.aadl2.instance.textual.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess;

@Singleton
public class InstanceGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class SystemInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SystemInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cCategoryAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cCategoryComponentCategoryParserRuleCall_0_0 = (RuleCall)cCategoryAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cComponentImplementationAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cComponentImplementationComponentImplementationCrossReference_3_0 = (CrossReference)cComponentImplementationAssignment_3.eContents().get(0);
		private final RuleCall cComponentImplementationComponentImplementationImplRefParserRuleCall_3_0_1 = (RuleCall)cComponentImplementationComponentImplementationCrossReference_3_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cFeatureInstanceAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final RuleCall cFeatureInstanceFeatureInstanceParserRuleCall_5_0_0 = (RuleCall)cFeatureInstanceAssignment_5_0.eContents().get(0);
		private final Assignment cComponentInstanceAssignment_5_1 = (Assignment)cAlternatives_5.eContents().get(1);
		private final RuleCall cComponentInstanceComponentInstanceParserRuleCall_5_1_0 = (RuleCall)cComponentInstanceAssignment_5_1.eContents().get(0);
		private final Assignment cConnectionInstanceAssignment_5_2 = (Assignment)cAlternatives_5.eContents().get(2);
		private final RuleCall cConnectionInstanceConnectionInstanceParserRuleCall_5_2_0 = (RuleCall)cConnectionInstanceAssignment_5_2.eContents().get(0);
		private final Assignment cFlowSpecificationAssignment_5_3 = (Assignment)cAlternatives_5.eContents().get(3);
		private final RuleCall cFlowSpecificationFlowSpecificationInstanceParserRuleCall_5_3_0 = (RuleCall)cFlowSpecificationAssignment_5_3.eContents().get(0);
		private final Assignment cEndToEndFlowAssignment_5_4 = (Assignment)cAlternatives_5.eContents().get(4);
		private final RuleCall cEndToEndFlowEndToEndFlowInstanceParserRuleCall_5_4_0 = (RuleCall)cEndToEndFlowAssignment_5_4.eContents().get(0);
		private final Assignment cModeInstanceAssignment_5_5 = (Assignment)cAlternatives_5.eContents().get(5);
		private final RuleCall cModeInstanceModeInstanceParserRuleCall_5_5_0 = (RuleCall)cModeInstanceAssignment_5_5.eContents().get(0);
		private final Assignment cModeTransitionInstanceAssignment_5_6 = (Assignment)cAlternatives_5.eContents().get(6);
		private final RuleCall cModeTransitionInstanceModeTransitionInstanceParserRuleCall_5_6_0 = (RuleCall)cModeTransitionInstanceAssignment_5_6.eContents().get(0);
		private final Assignment cSystemOperationModeAssignment_5_7 = (Assignment)cAlternatives_5.eContents().get(7);
		private final RuleCall cSystemOperationModeSystemOperationModeParserRuleCall_5_7_0 = (RuleCall)cSystemOperationModeAssignment_5_7.eContents().get(0);
		private final Assignment cOwnedPropertyAssociationAssignment_5_8 = (Assignment)cAlternatives_5.eContents().get(8);
		private final RuleCall cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_5_8_0 = (RuleCall)cOwnedPropertyAssociationAssignment_5_8.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//SystemInstance returns instance::SystemInstance:
		//	category=ComponentCategory name=ID ":" componentImplementation=[aadl2::ComponentImplementation|ImplRef] "{"
		//	(featureInstance+=FeatureInstance | componentInstance+=ComponentInstance | connectionInstance+=ConnectionInstance |
		//	flowSpecification+=FlowSpecificationInstance | endToEndFlow+=EndToEndFlowInstance | modeInstance+=ModeInstance |
		//	modeTransitionInstance+=ModeTransitionInstance | systemOperationMode+=SystemOperationMode |
		//	ownedPropertyAssociation+=PropertyAssociationInstance)* "}";
		@Override public ParserRule getRule() { return rule; }

		//category=ComponentCategory name=ID ":" componentImplementation=[aadl2::ComponentImplementation|ImplRef] "{"
		//(featureInstance+=FeatureInstance | componentInstance+=ComponentInstance | connectionInstance+=ConnectionInstance |
		//flowSpecification+=FlowSpecificationInstance | endToEndFlow+=EndToEndFlowInstance | modeInstance+=ModeInstance |
		//modeTransitionInstance+=ModeTransitionInstance | systemOperationMode+=SystemOperationMode |
		//ownedPropertyAssociation+=PropertyAssociationInstance)* "}"
		public Group getGroup() { return cGroup; }

		//category=ComponentCategory
		public Assignment getCategoryAssignment_0() { return cCategoryAssignment_0; }

		//ComponentCategory
		public RuleCall getCategoryComponentCategoryParserRuleCall_0_0() { return cCategoryComponentCategoryParserRuleCall_0_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//":"
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//componentImplementation=[aadl2::ComponentImplementation|ImplRef]
		public Assignment getComponentImplementationAssignment_3() { return cComponentImplementationAssignment_3; }

		//[aadl2::ComponentImplementation|ImplRef]
		public CrossReference getComponentImplementationComponentImplementationCrossReference_3_0() { return cComponentImplementationComponentImplementationCrossReference_3_0; }

		//ImplRef
		public RuleCall getComponentImplementationComponentImplementationImplRefParserRuleCall_3_0_1() { return cComponentImplementationComponentImplementationImplRefParserRuleCall_3_0_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }

		//(featureInstance+=FeatureInstance | componentInstance+=ComponentInstance | connectionInstance+=ConnectionInstance |
		//flowSpecification+=FlowSpecificationInstance | endToEndFlow+=EndToEndFlowInstance | modeInstance+=ModeInstance |
		//modeTransitionInstance+=ModeTransitionInstance | systemOperationMode+=SystemOperationMode |
		//ownedPropertyAssociation+=PropertyAssociationInstance)*
		public Alternatives getAlternatives_5() { return cAlternatives_5; }

		//featureInstance+=FeatureInstance
		public Assignment getFeatureInstanceAssignment_5_0() { return cFeatureInstanceAssignment_5_0; }

		//FeatureInstance
		public RuleCall getFeatureInstanceFeatureInstanceParserRuleCall_5_0_0() { return cFeatureInstanceFeatureInstanceParserRuleCall_5_0_0; }

		//componentInstance+=ComponentInstance
		public Assignment getComponentInstanceAssignment_5_1() { return cComponentInstanceAssignment_5_1; }

		//ComponentInstance
		public RuleCall getComponentInstanceComponentInstanceParserRuleCall_5_1_0() { return cComponentInstanceComponentInstanceParserRuleCall_5_1_0; }

		//connectionInstance+=ConnectionInstance
		public Assignment getConnectionInstanceAssignment_5_2() { return cConnectionInstanceAssignment_5_2; }

		//ConnectionInstance
		public RuleCall getConnectionInstanceConnectionInstanceParserRuleCall_5_2_0() { return cConnectionInstanceConnectionInstanceParserRuleCall_5_2_0; }

		//flowSpecification+=FlowSpecificationInstance
		public Assignment getFlowSpecificationAssignment_5_3() { return cFlowSpecificationAssignment_5_3; }

		//FlowSpecificationInstance
		public RuleCall getFlowSpecificationFlowSpecificationInstanceParserRuleCall_5_3_0() { return cFlowSpecificationFlowSpecificationInstanceParserRuleCall_5_3_0; }

		//endToEndFlow+=EndToEndFlowInstance
		public Assignment getEndToEndFlowAssignment_5_4() { return cEndToEndFlowAssignment_5_4; }

		//EndToEndFlowInstance
		public RuleCall getEndToEndFlowEndToEndFlowInstanceParserRuleCall_5_4_0() { return cEndToEndFlowEndToEndFlowInstanceParserRuleCall_5_4_0; }

		//modeInstance+=ModeInstance
		public Assignment getModeInstanceAssignment_5_5() { return cModeInstanceAssignment_5_5; }

		//ModeInstance
		public RuleCall getModeInstanceModeInstanceParserRuleCall_5_5_0() { return cModeInstanceModeInstanceParserRuleCall_5_5_0; }

		//modeTransitionInstance+=ModeTransitionInstance
		public Assignment getModeTransitionInstanceAssignment_5_6() { return cModeTransitionInstanceAssignment_5_6; }

		//ModeTransitionInstance
		public RuleCall getModeTransitionInstanceModeTransitionInstanceParserRuleCall_5_6_0() { return cModeTransitionInstanceModeTransitionInstanceParserRuleCall_5_6_0; }

		//systemOperationMode+=SystemOperationMode
		public Assignment getSystemOperationModeAssignment_5_7() { return cSystemOperationModeAssignment_5_7; }

		//SystemOperationMode
		public RuleCall getSystemOperationModeSystemOperationModeParserRuleCall_5_7_0() { return cSystemOperationModeSystemOperationModeParserRuleCall_5_7_0; }

		//ownedPropertyAssociation+=PropertyAssociationInstance
		public Assignment getOwnedPropertyAssociationAssignment_5_8() { return cOwnedPropertyAssociationAssignment_5_8; }

		//PropertyAssociationInstance
		public RuleCall getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_5_8_0() { return cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_5_8_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}

	public class FeatureInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FeatureInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cDirectionAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cDirectionDirectionTypeParserRuleCall_0_0 = (RuleCall)cDirectionAssignment_0.eContents().get(0);
		private final Assignment cCategoryAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cCategoryFeatureCategoryParserRuleCall_1_0 = (RuleCall)cCategoryAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLeftSquareBracketKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cIndexAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cIndexLongParserRuleCall_3_1_0 = (RuleCall)cIndexAssignment_3_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		private final Keyword cColonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cFeatureAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cFeatureFeatureCrossReference_5_0 = (CrossReference)cFeatureAssignment_5.eContents().get(0);
		private final RuleCall cFeatureFeatureDeclarativeRefParserRuleCall_5_0_1 = (RuleCall)cFeatureFeatureCrossReference_5_0.eContents().get(1);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cLeftCurlyBracketKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Alternatives cAlternatives_6_1 = (Alternatives)cGroup_6.eContents().get(1);
		private final Assignment cFeatureInstanceAssignment_6_1_0 = (Assignment)cAlternatives_6_1.eContents().get(0);
		private final RuleCall cFeatureInstanceFeatureInstanceParserRuleCall_6_1_0_0 = (RuleCall)cFeatureInstanceAssignment_6_1_0.eContents().get(0);
		private final Assignment cOwnedPropertyAssociationAssignment_6_1_1 = (Assignment)cAlternatives_6_1.eContents().get(1);
		private final RuleCall cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_6_1_1_0 = (RuleCall)cOwnedPropertyAssociationAssignment_6_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6_2 = (Keyword)cGroup_6.eContents().get(2);
		
		//FeatureInstance returns instance::FeatureInstance:
		//	direction=DirectionType category=FeatureCategory name=ID ("[" index=Long "]")? ":"
		//	feature=[aadl2::Feature|DeclarativeRef] ("{" (featureInstance+=FeatureInstance |
		//	ownedPropertyAssociation+=PropertyAssociationInstance)* "}")?;
		@Override public ParserRule getRule() { return rule; }

		//direction=DirectionType category=FeatureCategory name=ID ("[" index=Long "]")? ":"
		//feature=[aadl2::Feature|DeclarativeRef] ("{" (featureInstance+=FeatureInstance |
		//ownedPropertyAssociation+=PropertyAssociationInstance)* "}")?
		public Group getGroup() { return cGroup; }

		//direction=DirectionType
		public Assignment getDirectionAssignment_0() { return cDirectionAssignment_0; }

		//DirectionType
		public RuleCall getDirectionDirectionTypeParserRuleCall_0_0() { return cDirectionDirectionTypeParserRuleCall_0_0; }

		//category=FeatureCategory
		public Assignment getCategoryAssignment_1() { return cCategoryAssignment_1; }

		//FeatureCategory
		public RuleCall getCategoryFeatureCategoryParserRuleCall_1_0() { return cCategoryFeatureCategoryParserRuleCall_1_0; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//("[" index=Long "]")?
		public Group getGroup_3() { return cGroup_3; }

		//"["
		public Keyword getLeftSquareBracketKeyword_3_0() { return cLeftSquareBracketKeyword_3_0; }

		//index=Long
		public Assignment getIndexAssignment_3_1() { return cIndexAssignment_3_1; }

		//Long
		public RuleCall getIndexLongParserRuleCall_3_1_0() { return cIndexLongParserRuleCall_3_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_3_2() { return cRightSquareBracketKeyword_3_2; }

		//":"
		public Keyword getColonKeyword_4() { return cColonKeyword_4; }

		//feature=[aadl2::Feature|DeclarativeRef]
		public Assignment getFeatureAssignment_5() { return cFeatureAssignment_5; }

		//[aadl2::Feature|DeclarativeRef]
		public CrossReference getFeatureFeatureCrossReference_5_0() { return cFeatureFeatureCrossReference_5_0; }

		//DeclarativeRef
		public RuleCall getFeatureFeatureDeclarativeRefParserRuleCall_5_0_1() { return cFeatureFeatureDeclarativeRefParserRuleCall_5_0_1; }

		//("{" (featureInstance+=FeatureInstance | ownedPropertyAssociation+=PropertyAssociationInstance)* "}")?
		public Group getGroup_6() { return cGroup_6; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_6_0() { return cLeftCurlyBracketKeyword_6_0; }

		//(featureInstance+=FeatureInstance | ownedPropertyAssociation+=PropertyAssociationInstance)*
		public Alternatives getAlternatives_6_1() { return cAlternatives_6_1; }

		//featureInstance+=FeatureInstance
		public Assignment getFeatureInstanceAssignment_6_1_0() { return cFeatureInstanceAssignment_6_1_0; }

		//FeatureInstance
		public RuleCall getFeatureInstanceFeatureInstanceParserRuleCall_6_1_0_0() { return cFeatureInstanceFeatureInstanceParserRuleCall_6_1_0_0; }

		//ownedPropertyAssociation+=PropertyAssociationInstance
		public Assignment getOwnedPropertyAssociationAssignment_6_1_1() { return cOwnedPropertyAssociationAssignment_6_1_1; }

		//PropertyAssociationInstance
		public RuleCall getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_6_1_1_0() { return cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_6_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_6_2() { return cRightCurlyBracketKeyword_6_2; }
	}

	public class ComponentInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ComponentInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cCategoryAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cCategoryComponentCategoryParserRuleCall_0_0 = (RuleCall)cCategoryAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftSquareBracketKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cIndexAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cIndexLongParserRuleCall_2_1_0 = (RuleCall)cIndexAssignment_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cInKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cModesKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		private final Assignment cInModeAssignment_3_3 = (Assignment)cGroup_3.eContents().get(3);
		private final CrossReference cInModeModeInstanceCrossReference_3_3_0 = (CrossReference)cInModeAssignment_3_3.eContents().get(0);
		private final RuleCall cInModeModeInstanceIDTerminalRuleCall_3_3_0_1 = (RuleCall)cInModeModeInstanceCrossReference_3_3_0.eContents().get(1);
		private final Group cGroup_3_4 = (Group)cGroup_3.eContents().get(4);
		private final Keyword cCommaKeyword_3_4_0 = (Keyword)cGroup_3_4.eContents().get(0);
		private final Assignment cInModeAssignment_3_4_1 = (Assignment)cGroup_3_4.eContents().get(1);
		private final CrossReference cInModeModeInstanceCrossReference_3_4_1_0 = (CrossReference)cInModeAssignment_3_4_1.eContents().get(0);
		private final RuleCall cInModeModeInstanceIDTerminalRuleCall_3_4_1_0_1 = (RuleCall)cInModeModeInstanceCrossReference_3_4_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3_5 = (Keyword)cGroup_3.eContents().get(5);
		private final Keyword cColonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cClassifierAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cClassifierComponentClassifierCrossReference_5_0 = (CrossReference)cClassifierAssignment_5.eContents().get(0);
		private final RuleCall cClassifierComponentClassifierClassifierRefParserRuleCall_5_0_1 = (RuleCall)cClassifierComponentClassifierCrossReference_5_0.eContents().get(1);
		private final Keyword cCommaKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cSubcomponentAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final CrossReference cSubcomponentSubcomponentCrossReference_7_0 = (CrossReference)cSubcomponentAssignment_7.eContents().get(0);
		private final RuleCall cSubcomponentSubcomponentDeclarativeRefParserRuleCall_7_0_1 = (RuleCall)cSubcomponentSubcomponentCrossReference_7_0.eContents().get(1);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cLeftCurlyBracketKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Alternatives cAlternatives_8_1 = (Alternatives)cGroup_8.eContents().get(1);
		private final Assignment cFeatureInstanceAssignment_8_1_0 = (Assignment)cAlternatives_8_1.eContents().get(0);
		private final RuleCall cFeatureInstanceFeatureInstanceParserRuleCall_8_1_0_0 = (RuleCall)cFeatureInstanceAssignment_8_1_0.eContents().get(0);
		private final Assignment cComponentInstanceAssignment_8_1_1 = (Assignment)cAlternatives_8_1.eContents().get(1);
		private final RuleCall cComponentInstanceComponentInstanceParserRuleCall_8_1_1_0 = (RuleCall)cComponentInstanceAssignment_8_1_1.eContents().get(0);
		private final Assignment cConnectionInstanceAssignment_8_1_2 = (Assignment)cAlternatives_8_1.eContents().get(2);
		private final RuleCall cConnectionInstanceConnectionInstanceParserRuleCall_8_1_2_0 = (RuleCall)cConnectionInstanceAssignment_8_1_2.eContents().get(0);
		private final Assignment cFlowSpecificationAssignment_8_1_3 = (Assignment)cAlternatives_8_1.eContents().get(3);
		private final RuleCall cFlowSpecificationFlowSpecificationInstanceParserRuleCall_8_1_3_0 = (RuleCall)cFlowSpecificationAssignment_8_1_3.eContents().get(0);
		private final Assignment cEndToEndFlowAssignment_8_1_4 = (Assignment)cAlternatives_8_1.eContents().get(4);
		private final RuleCall cEndToEndFlowEndToEndFlowInstanceParserRuleCall_8_1_4_0 = (RuleCall)cEndToEndFlowAssignment_8_1_4.eContents().get(0);
		private final Assignment cModeInstanceAssignment_8_1_5 = (Assignment)cAlternatives_8_1.eContents().get(5);
		private final RuleCall cModeInstanceModeInstanceParserRuleCall_8_1_5_0 = (RuleCall)cModeInstanceAssignment_8_1_5.eContents().get(0);
		private final Assignment cModeTransitionInstanceAssignment_8_1_6 = (Assignment)cAlternatives_8_1.eContents().get(6);
		private final RuleCall cModeTransitionInstanceModeTransitionInstanceParserRuleCall_8_1_6_0 = (RuleCall)cModeTransitionInstanceAssignment_8_1_6.eContents().get(0);
		private final Assignment cOwnedPropertyAssociationAssignment_8_1_7 = (Assignment)cAlternatives_8_1.eContents().get(7);
		private final RuleCall cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_8_1_7_0 = (RuleCall)cOwnedPropertyAssociationAssignment_8_1_7.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_8_2 = (Keyword)cGroup_8.eContents().get(2);
		
		//ComponentInstance returns instance::ComponentInstance:
		//	category=ComponentCategory name=ID ("[" index+=Long "]")* ("in" "modes" "(" inMode+=[instance::ModeInstance] (","
		//	inMode+=[instance::ModeInstance])* ")")? ":" classifier=[aadl2::ComponentClassifier|ClassifierRef] ","
		//	subcomponent=[aadl2::Subcomponent|DeclarativeRef] ("{" (featureInstance+=FeatureInstance |
		//	componentInstance+=ComponentInstance | connectionInstance+=ConnectionInstance |
		//	flowSpecification+=FlowSpecificationInstance | endToEndFlow+=EndToEndFlowInstance | modeInstance+=ModeInstance |
		//	modeTransitionInstance+=ModeTransitionInstance | ownedPropertyAssociation+=PropertyAssociationInstance)* "}")?;
		@Override public ParserRule getRule() { return rule; }

		//category=ComponentCategory name=ID ("[" index+=Long "]")* ("in" "modes" "(" inMode+=[instance::ModeInstance] (","
		//inMode+=[instance::ModeInstance])* ")")? ":" classifier=[aadl2::ComponentClassifier|ClassifierRef] ","
		//subcomponent=[aadl2::Subcomponent|DeclarativeRef] ("{" (featureInstance+=FeatureInstance |
		//componentInstance+=ComponentInstance | connectionInstance+=ConnectionInstance |
		//flowSpecification+=FlowSpecificationInstance | endToEndFlow+=EndToEndFlowInstance | modeInstance+=ModeInstance |
		//modeTransitionInstance+=ModeTransitionInstance | ownedPropertyAssociation+=PropertyAssociationInstance)* "}")?
		public Group getGroup() { return cGroup; }

		//category=ComponentCategory
		public Assignment getCategoryAssignment_0() { return cCategoryAssignment_0; }

		//ComponentCategory
		public RuleCall getCategoryComponentCategoryParserRuleCall_0_0() { return cCategoryComponentCategoryParserRuleCall_0_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//("[" index+=Long "]")*
		public Group getGroup_2() { return cGroup_2; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2_0() { return cLeftSquareBracketKeyword_2_0; }

		//index+=Long
		public Assignment getIndexAssignment_2_1() { return cIndexAssignment_2_1; }

		//Long
		public RuleCall getIndexLongParserRuleCall_2_1_0() { return cIndexLongParserRuleCall_2_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_2_2() { return cRightSquareBracketKeyword_2_2; }

		//("in" "modes" "(" inMode+=[instance::ModeInstance] ("," inMode+=[instance::ModeInstance])* ")")?
		public Group getGroup_3() { return cGroup_3; }

		//"in"
		public Keyword getInKeyword_3_0() { return cInKeyword_3_0; }

		//"modes"
		public Keyword getModesKeyword_3_1() { return cModesKeyword_3_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_3_2() { return cLeftParenthesisKeyword_3_2; }

		//inMode+=[instance::ModeInstance]
		public Assignment getInModeAssignment_3_3() { return cInModeAssignment_3_3; }

		//[instance::ModeInstance]
		public CrossReference getInModeModeInstanceCrossReference_3_3_0() { return cInModeModeInstanceCrossReference_3_3_0; }

		//ID
		public RuleCall getInModeModeInstanceIDTerminalRuleCall_3_3_0_1() { return cInModeModeInstanceIDTerminalRuleCall_3_3_0_1; }

		//("," inMode+=[instance::ModeInstance])*
		public Group getGroup_3_4() { return cGroup_3_4; }

		//","
		public Keyword getCommaKeyword_3_4_0() { return cCommaKeyword_3_4_0; }

		//inMode+=[instance::ModeInstance]
		public Assignment getInModeAssignment_3_4_1() { return cInModeAssignment_3_4_1; }

		//[instance::ModeInstance]
		public CrossReference getInModeModeInstanceCrossReference_3_4_1_0() { return cInModeModeInstanceCrossReference_3_4_1_0; }

		//ID
		public RuleCall getInModeModeInstanceIDTerminalRuleCall_3_4_1_0_1() { return cInModeModeInstanceIDTerminalRuleCall_3_4_1_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_3_5() { return cRightParenthesisKeyword_3_5; }

		//":"
		public Keyword getColonKeyword_4() { return cColonKeyword_4; }

		//classifier=[aadl2::ComponentClassifier|ClassifierRef]
		public Assignment getClassifierAssignment_5() { return cClassifierAssignment_5; }

		//[aadl2::ComponentClassifier|ClassifierRef]
		public CrossReference getClassifierComponentClassifierCrossReference_5_0() { return cClassifierComponentClassifierCrossReference_5_0; }

		//ClassifierRef
		public RuleCall getClassifierComponentClassifierClassifierRefParserRuleCall_5_0_1() { return cClassifierComponentClassifierClassifierRefParserRuleCall_5_0_1; }

		//","
		public Keyword getCommaKeyword_6() { return cCommaKeyword_6; }

		//subcomponent=[aadl2::Subcomponent|DeclarativeRef]
		public Assignment getSubcomponentAssignment_7() { return cSubcomponentAssignment_7; }

		//[aadl2::Subcomponent|DeclarativeRef]
		public CrossReference getSubcomponentSubcomponentCrossReference_7_0() { return cSubcomponentSubcomponentCrossReference_7_0; }

		//DeclarativeRef
		public RuleCall getSubcomponentSubcomponentDeclarativeRefParserRuleCall_7_0_1() { return cSubcomponentSubcomponentDeclarativeRefParserRuleCall_7_0_1; }

		//("{" (featureInstance+=FeatureInstance | componentInstance+=ComponentInstance | connectionInstance+=ConnectionInstance |
		//flowSpecification+=FlowSpecificationInstance | endToEndFlow+=EndToEndFlowInstance | modeInstance+=ModeInstance |
		//modeTransitionInstance+=ModeTransitionInstance | ownedPropertyAssociation+=PropertyAssociationInstance)* "}")?
		public Group getGroup_8() { return cGroup_8; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_8_0() { return cLeftCurlyBracketKeyword_8_0; }

		//(featureInstance+=FeatureInstance | componentInstance+=ComponentInstance | connectionInstance+=ConnectionInstance |
		//flowSpecification+=FlowSpecificationInstance | endToEndFlow+=EndToEndFlowInstance | modeInstance+=ModeInstance |
		//modeTransitionInstance+=ModeTransitionInstance | ownedPropertyAssociation+=PropertyAssociationInstance)*
		public Alternatives getAlternatives_8_1() { return cAlternatives_8_1; }

		//featureInstance+=FeatureInstance
		public Assignment getFeatureInstanceAssignment_8_1_0() { return cFeatureInstanceAssignment_8_1_0; }

		//FeatureInstance
		public RuleCall getFeatureInstanceFeatureInstanceParserRuleCall_8_1_0_0() { return cFeatureInstanceFeatureInstanceParserRuleCall_8_1_0_0; }

		//componentInstance+=ComponentInstance
		public Assignment getComponentInstanceAssignment_8_1_1() { return cComponentInstanceAssignment_8_1_1; }

		//ComponentInstance
		public RuleCall getComponentInstanceComponentInstanceParserRuleCall_8_1_1_0() { return cComponentInstanceComponentInstanceParserRuleCall_8_1_1_0; }

		//connectionInstance+=ConnectionInstance
		public Assignment getConnectionInstanceAssignment_8_1_2() { return cConnectionInstanceAssignment_8_1_2; }

		//ConnectionInstance
		public RuleCall getConnectionInstanceConnectionInstanceParserRuleCall_8_1_2_0() { return cConnectionInstanceConnectionInstanceParserRuleCall_8_1_2_0; }

		//flowSpecification+=FlowSpecificationInstance
		public Assignment getFlowSpecificationAssignment_8_1_3() { return cFlowSpecificationAssignment_8_1_3; }

		//FlowSpecificationInstance
		public RuleCall getFlowSpecificationFlowSpecificationInstanceParserRuleCall_8_1_3_0() { return cFlowSpecificationFlowSpecificationInstanceParserRuleCall_8_1_3_0; }

		//endToEndFlow+=EndToEndFlowInstance
		public Assignment getEndToEndFlowAssignment_8_1_4() { return cEndToEndFlowAssignment_8_1_4; }

		//EndToEndFlowInstance
		public RuleCall getEndToEndFlowEndToEndFlowInstanceParserRuleCall_8_1_4_0() { return cEndToEndFlowEndToEndFlowInstanceParserRuleCall_8_1_4_0; }

		//modeInstance+=ModeInstance
		public Assignment getModeInstanceAssignment_8_1_5() { return cModeInstanceAssignment_8_1_5; }

		//ModeInstance
		public RuleCall getModeInstanceModeInstanceParserRuleCall_8_1_5_0() { return cModeInstanceModeInstanceParserRuleCall_8_1_5_0; }

		//modeTransitionInstance+=ModeTransitionInstance
		public Assignment getModeTransitionInstanceAssignment_8_1_6() { return cModeTransitionInstanceAssignment_8_1_6; }

		//ModeTransitionInstance
		public RuleCall getModeTransitionInstanceModeTransitionInstanceParserRuleCall_8_1_6_0() { return cModeTransitionInstanceModeTransitionInstanceParserRuleCall_8_1_6_0; }

		//ownedPropertyAssociation+=PropertyAssociationInstance
		public Assignment getOwnedPropertyAssociationAssignment_8_1_7() { return cOwnedPropertyAssociationAssignment_8_1_7; }

		//PropertyAssociationInstance
		public RuleCall getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_8_1_7_0() { return cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_8_1_7_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_8_2() { return cRightCurlyBracketKeyword_8_2; }
	}

	public class ConnectionInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ConnectionInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cCompleteAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cCompleteCompleteKeyword_0_0 = (Keyword)cCompleteAssignment_0.eContents().get(0);
		private final Assignment cKindAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cKindConnectionKindParserRuleCall_1_0 = (RuleCall)cKindAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameSTRINGTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cSourceAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cSourceConnectionInstanceEndCrossReference_4_0 = (CrossReference)cSourceAssignment_4.eContents().get(0);
		private final RuleCall cSourceConnectionInstanceEndInstanceRefParserRuleCall_4_0_1 = (RuleCall)cSourceConnectionInstanceEndCrossReference_4_0.eContents().get(1);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cBidirectionalAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final Keyword cBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0 = (Keyword)cBidirectionalAssignment_5_0.eContents().get(0);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_5_1 = (Keyword)cAlternatives_5.eContents().get(1);
		private final Assignment cDestinationAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cDestinationConnectionInstanceEndCrossReference_6_0 = (CrossReference)cDestinationAssignment_6.eContents().get(0);
		private final RuleCall cDestinationConnectionInstanceEndInstanceRefParserRuleCall_6_0_1 = (RuleCall)cDestinationConnectionInstanceEndCrossReference_6_0.eContents().get(1);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cInKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Keyword cModesKeyword_7_1 = (Keyword)cGroup_7.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_7_2 = (Keyword)cGroup_7.eContents().get(2);
		private final Assignment cInSystemOperationModeAssignment_7_3 = (Assignment)cGroup_7.eContents().get(3);
		private final CrossReference cInSystemOperationModeSystemOperationModeCrossReference_7_3_0 = (CrossReference)cInSystemOperationModeAssignment_7_3.eContents().get(0);
		private final RuleCall cInSystemOperationModeSystemOperationModeSomRefParserRuleCall_7_3_0_1 = (RuleCall)cInSystemOperationModeSystemOperationModeCrossReference_7_3_0.eContents().get(1);
		private final Group cGroup_7_4 = (Group)cGroup_7.eContents().get(4);
		private final Keyword cCommaKeyword_7_4_0 = (Keyword)cGroup_7_4.eContents().get(0);
		private final Assignment cInSystemOperationModeAssignment_7_4_1 = (Assignment)cGroup_7_4.eContents().get(1);
		private final CrossReference cInSystemOperationModeSystemOperationModeCrossReference_7_4_1_0 = (CrossReference)cInSystemOperationModeAssignment_7_4_1.eContents().get(0);
		private final RuleCall cInSystemOperationModeSystemOperationModeSomRefParserRuleCall_7_4_1_0_1 = (RuleCall)cInSystemOperationModeSystemOperationModeCrossReference_7_4_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_7_5 = (Keyword)cGroup_7.eContents().get(5);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cInKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cTransitionsKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_8_2 = (Keyword)cGroup_8.eContents().get(2);
		private final Assignment cInModeTransitionAssignment_8_3 = (Assignment)cGroup_8.eContents().get(3);
		private final CrossReference cInModeTransitionModeTransitionInstanceCrossReference_8_3_0 = (CrossReference)cInModeTransitionAssignment_8_3.eContents().get(0);
		private final RuleCall cInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_3_0_1 = (RuleCall)cInModeTransitionModeTransitionInstanceCrossReference_8_3_0.eContents().get(1);
		private final Group cGroup_8_4 = (Group)cGroup_8.eContents().get(4);
		private final Keyword cCommaKeyword_8_4_0 = (Keyword)cGroup_8_4.eContents().get(0);
		private final Assignment cInModeTransitionAssignment_8_4_1 = (Assignment)cGroup_8_4.eContents().get(1);
		private final CrossReference cInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0 = (CrossReference)cInModeTransitionAssignment_8_4_1.eContents().get(0);
		private final RuleCall cInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_4_1_0_1 = (RuleCall)cInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_8_5 = (Keyword)cGroup_8.eContents().get(5);
		private final Keyword cLeftCurlyBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		private final Alternatives cAlternatives_10 = (Alternatives)cGroup.eContents().get(10);
		private final Assignment cConnectionReferenceAssignment_10_0 = (Assignment)cAlternatives_10.eContents().get(0);
		private final RuleCall cConnectionReferenceConnectionReferenceParserRuleCall_10_0_0 = (RuleCall)cConnectionReferenceAssignment_10_0.eContents().get(0);
		private final Assignment cOwnedPropertyAssociationAssignment_10_1 = (Assignment)cAlternatives_10.eContents().get(1);
		private final RuleCall cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0 = (RuleCall)cOwnedPropertyAssociationAssignment_10_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_11 = (Keyword)cGroup.eContents().get(11);
		
		//ConnectionInstance returns instance::ConnectionInstance:
		//	complete?="complete"? kind=ConnectionKind name=STRING ":" source=[instance::ConnectionInstanceEnd|InstanceRef]
		//	(bidirectional?="<->" | "->") destination=[instance::ConnectionInstanceEnd|InstanceRef] ("in" "modes" "("
		//	inSystemOperationMode+=[instance::SystemOperationMode|SomRef] (","
		//	inSystemOperationMode+=[instance::SystemOperationMode|SomRef])* ")")? ("in" "transitions" "("
		//	inModeTransition+=[instance::ModeTransitionInstance|TransitionRef] (","
		//	inModeTransition+=[instance::ModeTransitionInstance|TransitionRef])* ")")? "{"
		//	(connectionReference+=ConnectionReference | ownedPropertyAssociation+=PropertyAssociationInstance)+ "}";
		@Override public ParserRule getRule() { return rule; }

		//complete?="complete"? kind=ConnectionKind name=STRING ":" source=[instance::ConnectionInstanceEnd|InstanceRef]
		//(bidirectional?="<->" | "->") destination=[instance::ConnectionInstanceEnd|InstanceRef] ("in" "modes" "("
		//inSystemOperationMode+=[instance::SystemOperationMode|SomRef] (","
		//inSystemOperationMode+=[instance::SystemOperationMode|SomRef])* ")")? ("in" "transitions" "("
		//inModeTransition+=[instance::ModeTransitionInstance|TransitionRef] (","
		//inModeTransition+=[instance::ModeTransitionInstance|TransitionRef])* ")")? "{"
		//(connectionReference+=ConnectionReference | ownedPropertyAssociation+=PropertyAssociationInstance)+ "}"
		public Group getGroup() { return cGroup; }

		//complete?="complete"?
		public Assignment getCompleteAssignment_0() { return cCompleteAssignment_0; }

		//"complete"
		public Keyword getCompleteCompleteKeyword_0_0() { return cCompleteCompleteKeyword_0_0; }

		//kind=ConnectionKind
		public Assignment getKindAssignment_1() { return cKindAssignment_1; }

		//ConnectionKind
		public RuleCall getKindConnectionKindParserRuleCall_1_0() { return cKindConnectionKindParserRuleCall_1_0; }

		//name=STRING
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//STRING
		public RuleCall getNameSTRINGTerminalRuleCall_2_0() { return cNameSTRINGTerminalRuleCall_2_0; }

		//":"
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }

		//source=[instance::ConnectionInstanceEnd|InstanceRef]
		public Assignment getSourceAssignment_4() { return cSourceAssignment_4; }

		//[instance::ConnectionInstanceEnd|InstanceRef]
		public CrossReference getSourceConnectionInstanceEndCrossReference_4_0() { return cSourceConnectionInstanceEndCrossReference_4_0; }

		//InstanceRef
		public RuleCall getSourceConnectionInstanceEndInstanceRefParserRuleCall_4_0_1() { return cSourceConnectionInstanceEndInstanceRefParserRuleCall_4_0_1; }

		//bidirectional?="<->" | "->"
		public Alternatives getAlternatives_5() { return cAlternatives_5; }

		//bidirectional?="<->"
		public Assignment getBidirectionalAssignment_5_0() { return cBidirectionalAssignment_5_0; }

		//"<->"
		public Keyword getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0() { return cBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_5_1() { return cHyphenMinusGreaterThanSignKeyword_5_1; }

		//destination=[instance::ConnectionInstanceEnd|InstanceRef]
		public Assignment getDestinationAssignment_6() { return cDestinationAssignment_6; }

		//[instance::ConnectionInstanceEnd|InstanceRef]
		public CrossReference getDestinationConnectionInstanceEndCrossReference_6_0() { return cDestinationConnectionInstanceEndCrossReference_6_0; }

		//InstanceRef
		public RuleCall getDestinationConnectionInstanceEndInstanceRefParserRuleCall_6_0_1() { return cDestinationConnectionInstanceEndInstanceRefParserRuleCall_6_0_1; }

		//("in" "modes" "(" inSystemOperationMode+=[instance::SystemOperationMode|SomRef] (","
		//inSystemOperationMode+=[instance::SystemOperationMode|SomRef])* ")")?
		public Group getGroup_7() { return cGroup_7; }

		//"in"
		public Keyword getInKeyword_7_0() { return cInKeyword_7_0; }

		//"modes"
		public Keyword getModesKeyword_7_1() { return cModesKeyword_7_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_7_2() { return cLeftParenthesisKeyword_7_2; }

		//inSystemOperationMode+=[instance::SystemOperationMode|SomRef]
		public Assignment getInSystemOperationModeAssignment_7_3() { return cInSystemOperationModeAssignment_7_3; }

		//[instance::SystemOperationMode|SomRef]
		public CrossReference getInSystemOperationModeSystemOperationModeCrossReference_7_3_0() { return cInSystemOperationModeSystemOperationModeCrossReference_7_3_0; }

		//SomRef
		public RuleCall getInSystemOperationModeSystemOperationModeSomRefParserRuleCall_7_3_0_1() { return cInSystemOperationModeSystemOperationModeSomRefParserRuleCall_7_3_0_1; }

		//("," inSystemOperationMode+=[instance::SystemOperationMode|SomRef])*
		public Group getGroup_7_4() { return cGroup_7_4; }

		//","
		public Keyword getCommaKeyword_7_4_0() { return cCommaKeyword_7_4_0; }

		//inSystemOperationMode+=[instance::SystemOperationMode|SomRef]
		public Assignment getInSystemOperationModeAssignment_7_4_1() { return cInSystemOperationModeAssignment_7_4_1; }

		//[instance::SystemOperationMode|SomRef]
		public CrossReference getInSystemOperationModeSystemOperationModeCrossReference_7_4_1_0() { return cInSystemOperationModeSystemOperationModeCrossReference_7_4_1_0; }

		//SomRef
		public RuleCall getInSystemOperationModeSystemOperationModeSomRefParserRuleCall_7_4_1_0_1() { return cInSystemOperationModeSystemOperationModeSomRefParserRuleCall_7_4_1_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_7_5() { return cRightParenthesisKeyword_7_5; }

		//("in" "transitions" "(" inModeTransition+=[instance::ModeTransitionInstance|TransitionRef] (","
		//inModeTransition+=[instance::ModeTransitionInstance|TransitionRef])* ")")?
		public Group getGroup_8() { return cGroup_8; }

		//"in"
		public Keyword getInKeyword_8_0() { return cInKeyword_8_0; }

		//"transitions"
		public Keyword getTransitionsKeyword_8_1() { return cTransitionsKeyword_8_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_8_2() { return cLeftParenthesisKeyword_8_2; }

		//inModeTransition+=[instance::ModeTransitionInstance|TransitionRef]
		public Assignment getInModeTransitionAssignment_8_3() { return cInModeTransitionAssignment_8_3; }

		//[instance::ModeTransitionInstance|TransitionRef]
		public CrossReference getInModeTransitionModeTransitionInstanceCrossReference_8_3_0() { return cInModeTransitionModeTransitionInstanceCrossReference_8_3_0; }

		//TransitionRef
		public RuleCall getInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_3_0_1() { return cInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_3_0_1; }

		//("," inModeTransition+=[instance::ModeTransitionInstance|TransitionRef])*
		public Group getGroup_8_4() { return cGroup_8_4; }

		//","
		public Keyword getCommaKeyword_8_4_0() { return cCommaKeyword_8_4_0; }

		//inModeTransition+=[instance::ModeTransitionInstance|TransitionRef]
		public Assignment getInModeTransitionAssignment_8_4_1() { return cInModeTransitionAssignment_8_4_1; }

		//[instance::ModeTransitionInstance|TransitionRef]
		public CrossReference getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0() { return cInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0; }

		//TransitionRef
		public RuleCall getInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_4_1_0_1() { return cInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_4_1_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_8_5() { return cRightParenthesisKeyword_8_5; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_9() { return cLeftCurlyBracketKeyword_9; }

		//(connectionReference+=ConnectionReference | ownedPropertyAssociation+=PropertyAssociationInstance)+
		public Alternatives getAlternatives_10() { return cAlternatives_10; }

		//connectionReference+=ConnectionReference
		public Assignment getConnectionReferenceAssignment_10_0() { return cConnectionReferenceAssignment_10_0; }

		//ConnectionReference
		public RuleCall getConnectionReferenceConnectionReferenceParserRuleCall_10_0_0() { return cConnectionReferenceConnectionReferenceParserRuleCall_10_0_0; }

		//ownedPropertyAssociation+=PropertyAssociationInstance
		public Assignment getOwnedPropertyAssociationAssignment_10_1() { return cOwnedPropertyAssociationAssignment_10_1; }

		//PropertyAssociationInstance
		public RuleCall getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0() { return cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_11() { return cRightCurlyBracketKeyword_11; }
	}

	public class ConnectionReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ConnectionReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSourceAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cSourceConnectionInstanceEndCrossReference_0_0 = (CrossReference)cSourceAssignment_0.eContents().get(0);
		private final RuleCall cSourceConnectionInstanceEndInstanceRefParserRuleCall_0_0_1 = (RuleCall)cSourceConnectionInstanceEndCrossReference_0_0.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cDestinationAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cDestinationConnectionInstanceEndCrossReference_2_0 = (CrossReference)cDestinationAssignment_2.eContents().get(0);
		private final RuleCall cDestinationConnectionInstanceEndInstanceRefParserRuleCall_2_0_1 = (RuleCall)cDestinationConnectionInstanceEndCrossReference_2_0.eContents().get(1);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cConnectionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cConnectionConnectionCrossReference_4_0 = (CrossReference)cConnectionAssignment_4.eContents().get(0);
		private final RuleCall cConnectionConnectionDeclarativeRefParserRuleCall_4_0_1 = (RuleCall)cConnectionConnectionCrossReference_4_0.eContents().get(1);
		private final Keyword cInKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cContextAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cContextComponentInstanceCrossReference_6_0 = (CrossReference)cContextAssignment_6.eContents().get(0);
		private final RuleCall cContextComponentInstanceInstanceRefParserRuleCall_6_0_1 = (RuleCall)cContextComponentInstanceCrossReference_6_0.eContents().get(1);
		
		//ConnectionReference returns instance::ConnectionReference:
		//	source=[instance::ConnectionInstanceEnd|InstanceRef] "->" destination=[instance::ConnectionInstanceEnd|InstanceRef]
		//	":" connection=[aadl2::Connection|DeclarativeRef] "in" context=[instance::ComponentInstance|InstanceRef];
		@Override public ParserRule getRule() { return rule; }

		//source=[instance::ConnectionInstanceEnd|InstanceRef] "->" destination=[instance::ConnectionInstanceEnd|InstanceRef] ":"
		//connection=[aadl2::Connection|DeclarativeRef] "in" context=[instance::ComponentInstance|InstanceRef]
		public Group getGroup() { return cGroup; }

		//source=[instance::ConnectionInstanceEnd|InstanceRef]
		public Assignment getSourceAssignment_0() { return cSourceAssignment_0; }

		//[instance::ConnectionInstanceEnd|InstanceRef]
		public CrossReference getSourceConnectionInstanceEndCrossReference_0_0() { return cSourceConnectionInstanceEndCrossReference_0_0; }

		//InstanceRef
		public RuleCall getSourceConnectionInstanceEndInstanceRefParserRuleCall_0_0_1() { return cSourceConnectionInstanceEndInstanceRefParserRuleCall_0_0_1; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_1() { return cHyphenMinusGreaterThanSignKeyword_1; }

		//destination=[instance::ConnectionInstanceEnd|InstanceRef]
		public Assignment getDestinationAssignment_2() { return cDestinationAssignment_2; }

		//[instance::ConnectionInstanceEnd|InstanceRef]
		public CrossReference getDestinationConnectionInstanceEndCrossReference_2_0() { return cDestinationConnectionInstanceEndCrossReference_2_0; }

		//InstanceRef
		public RuleCall getDestinationConnectionInstanceEndInstanceRefParserRuleCall_2_0_1() { return cDestinationConnectionInstanceEndInstanceRefParserRuleCall_2_0_1; }

		//":"
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }

		//connection=[aadl2::Connection|DeclarativeRef]
		public Assignment getConnectionAssignment_4() { return cConnectionAssignment_4; }

		//[aadl2::Connection|DeclarativeRef]
		public CrossReference getConnectionConnectionCrossReference_4_0() { return cConnectionConnectionCrossReference_4_0; }

		//DeclarativeRef
		public RuleCall getConnectionConnectionDeclarativeRefParserRuleCall_4_0_1() { return cConnectionConnectionDeclarativeRefParserRuleCall_4_0_1; }

		//"in"
		public Keyword getInKeyword_5() { return cInKeyword_5; }

		//context=[instance::ComponentInstance|InstanceRef]
		public Assignment getContextAssignment_6() { return cContextAssignment_6; }

		//[instance::ComponentInstance|InstanceRef]
		public CrossReference getContextComponentInstanceCrossReference_6_0() { return cContextComponentInstanceCrossReference_6_0; }

		//InstanceRef
		public RuleCall getContextComponentInstanceInstanceRefParserRuleCall_6_0_1() { return cContextComponentInstanceInstanceRefParserRuleCall_6_0_1; }
	}

	public class FlowSpecificationInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FlowSpecificationInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cFlowKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cSourceAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cSourceFeatureInstanceCrossReference_3_0 = (CrossReference)cSourceAssignment_3.eContents().get(0);
		private final RuleCall cSourceFeatureInstanceInstanceRefParserRuleCall_3_0_1 = (RuleCall)cSourceFeatureInstanceCrossReference_3_0.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cDestinationAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cDestinationFeatureInstanceCrossReference_5_0 = (CrossReference)cDestinationAssignment_5.eContents().get(0);
		private final RuleCall cDestinationFeatureInstanceInstanceRefParserRuleCall_5_0_1 = (RuleCall)cDestinationFeatureInstanceCrossReference_5_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cInKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Keyword cModesKeyword_7_1 = (Keyword)cGroup_7.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_7_2 = (Keyword)cGroup_7.eContents().get(2);
		private final Assignment cInModeAssignment_7_3 = (Assignment)cGroup_7.eContents().get(3);
		private final CrossReference cInModeModeInstanceCrossReference_7_3_0 = (CrossReference)cInModeAssignment_7_3.eContents().get(0);
		private final RuleCall cInModeModeInstanceIDTerminalRuleCall_7_3_0_1 = (RuleCall)cInModeModeInstanceCrossReference_7_3_0.eContents().get(1);
		private final Group cGroup_7_4 = (Group)cGroup_7.eContents().get(4);
		private final Keyword cCommaKeyword_7_4_0 = (Keyword)cGroup_7_4.eContents().get(0);
		private final Assignment cInModeAssignment_7_4_1 = (Assignment)cGroup_7_4.eContents().get(1);
		private final CrossReference cInModeModeInstanceCrossReference_7_4_1_0 = (CrossReference)cInModeAssignment_7_4_1.eContents().get(0);
		private final RuleCall cInModeModeInstanceIDTerminalRuleCall_7_4_1_0_1 = (RuleCall)cInModeModeInstanceCrossReference_7_4_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_7_5 = (Keyword)cGroup_7.eContents().get(5);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cInKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cTransitionsKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_8_2 = (Keyword)cGroup_8.eContents().get(2);
		private final Assignment cInModeTransitionAssignment_8_3 = (Assignment)cGroup_8.eContents().get(3);
		private final CrossReference cInModeTransitionModeTransitionInstanceCrossReference_8_3_0 = (CrossReference)cInModeTransitionAssignment_8_3.eContents().get(0);
		private final RuleCall cInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_3_0_1 = (RuleCall)cInModeTransitionModeTransitionInstanceCrossReference_8_3_0.eContents().get(1);
		private final Group cGroup_8_4 = (Group)cGroup_8.eContents().get(4);
		private final Keyword cCommaKeyword_8_4_0 = (Keyword)cGroup_8_4.eContents().get(0);
		private final Assignment cInModeTransitionAssignment_8_4_1 = (Assignment)cGroup_8_4.eContents().get(1);
		private final CrossReference cInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0 = (CrossReference)cInModeTransitionAssignment_8_4_1.eContents().get(0);
		private final RuleCall cInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_4_1_0_1 = (RuleCall)cInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_8_5 = (Keyword)cGroup_8.eContents().get(5);
		private final Keyword cColonKeyword_9 = (Keyword)cGroup.eContents().get(9);
		private final Assignment cFlowSpecificationAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final CrossReference cFlowSpecificationFlowSpecificationCrossReference_10_0 = (CrossReference)cFlowSpecificationAssignment_10.eContents().get(0);
		private final RuleCall cFlowSpecificationFlowSpecificationDeclarativeRefParserRuleCall_10_0_1 = (RuleCall)cFlowSpecificationFlowSpecificationCrossReference_10_0.eContents().get(1);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cLeftCurlyBracketKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Assignment cOwnedPropertyAssociationAssignment_11_1 = (Assignment)cGroup_11.eContents().get(1);
		private final RuleCall cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_11_1_0 = (RuleCall)cOwnedPropertyAssociationAssignment_11_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_11_2 = (Keyword)cGroup_11.eContents().get(2);
		
		//FlowSpecificationInstance returns instance::FlowSpecificationInstance:
		//	"flow" name=ID "(" source=[instance::FeatureInstance|InstanceRef]? "->"
		//	destination=[instance::FeatureInstance|InstanceRef]? ")" ("in" "modes" "(" inMode+=[instance::ModeInstance] (","
		//	inMode+=[instance::ModeInstance])* ")")? ("in" "transitions" "("
		//	inModeTransition+=[instance::ModeTransitionInstance|TransitionRef] (","
		//	inModeTransition+=[instance::ModeTransitionInstance|TransitionRef])* ")")? ":"
		//	flowSpecification=[aadl2::FlowSpecification|DeclarativeRef] ("{"
		//	ownedPropertyAssociation+=PropertyAssociationInstance+ "}")?;
		@Override public ParserRule getRule() { return rule; }

		//"flow" name=ID "(" source=[instance::FeatureInstance|InstanceRef]? "->"
		//destination=[instance::FeatureInstance|InstanceRef]? ")" ("in" "modes" "(" inMode+=[instance::ModeInstance] (","
		//inMode+=[instance::ModeInstance])* ")")? ("in" "transitions" "("
		//inModeTransition+=[instance::ModeTransitionInstance|TransitionRef] (","
		//inModeTransition+=[instance::ModeTransitionInstance|TransitionRef])* ")")? ":"
		//flowSpecification=[aadl2::FlowSpecification|DeclarativeRef] ("{" ownedPropertyAssociation+=PropertyAssociationInstance+
		//"}")?
		public Group getGroup() { return cGroup; }

		//"flow"
		public Keyword getFlowKeyword_0() { return cFlowKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }

		//source=[instance::FeatureInstance|InstanceRef]?
		public Assignment getSourceAssignment_3() { return cSourceAssignment_3; }

		//[instance::FeatureInstance|InstanceRef]
		public CrossReference getSourceFeatureInstanceCrossReference_3_0() { return cSourceFeatureInstanceCrossReference_3_0; }

		//InstanceRef
		public RuleCall getSourceFeatureInstanceInstanceRefParserRuleCall_3_0_1() { return cSourceFeatureInstanceInstanceRefParserRuleCall_3_0_1; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_4() { return cHyphenMinusGreaterThanSignKeyword_4; }

		//destination=[instance::FeatureInstance|InstanceRef]?
		public Assignment getDestinationAssignment_5() { return cDestinationAssignment_5; }

		//[instance::FeatureInstance|InstanceRef]
		public CrossReference getDestinationFeatureInstanceCrossReference_5_0() { return cDestinationFeatureInstanceCrossReference_5_0; }

		//InstanceRef
		public RuleCall getDestinationFeatureInstanceInstanceRefParserRuleCall_5_0_1() { return cDestinationFeatureInstanceInstanceRefParserRuleCall_5_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }

		//("in" "modes" "(" inMode+=[instance::ModeInstance] ("," inMode+=[instance::ModeInstance])* ")")?
		public Group getGroup_7() { return cGroup_7; }

		//"in"
		public Keyword getInKeyword_7_0() { return cInKeyword_7_0; }

		//"modes"
		public Keyword getModesKeyword_7_1() { return cModesKeyword_7_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_7_2() { return cLeftParenthesisKeyword_7_2; }

		//inMode+=[instance::ModeInstance]
		public Assignment getInModeAssignment_7_3() { return cInModeAssignment_7_3; }

		//[instance::ModeInstance]
		public CrossReference getInModeModeInstanceCrossReference_7_3_0() { return cInModeModeInstanceCrossReference_7_3_0; }

		//ID
		public RuleCall getInModeModeInstanceIDTerminalRuleCall_7_3_0_1() { return cInModeModeInstanceIDTerminalRuleCall_7_3_0_1; }

		//("," inMode+=[instance::ModeInstance])*
		public Group getGroup_7_4() { return cGroup_7_4; }

		//","
		public Keyword getCommaKeyword_7_4_0() { return cCommaKeyword_7_4_0; }

		//inMode+=[instance::ModeInstance]
		public Assignment getInModeAssignment_7_4_1() { return cInModeAssignment_7_4_1; }

		//[instance::ModeInstance]
		public CrossReference getInModeModeInstanceCrossReference_7_4_1_0() { return cInModeModeInstanceCrossReference_7_4_1_0; }

		//ID
		public RuleCall getInModeModeInstanceIDTerminalRuleCall_7_4_1_0_1() { return cInModeModeInstanceIDTerminalRuleCall_7_4_1_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_7_5() { return cRightParenthesisKeyword_7_5; }

		//("in" "transitions" "(" inModeTransition+=[instance::ModeTransitionInstance|TransitionRef] (","
		//inModeTransition+=[instance::ModeTransitionInstance|TransitionRef])* ")")?
		public Group getGroup_8() { return cGroup_8; }

		//"in"
		public Keyword getInKeyword_8_0() { return cInKeyword_8_0; }

		//"transitions"
		public Keyword getTransitionsKeyword_8_1() { return cTransitionsKeyword_8_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_8_2() { return cLeftParenthesisKeyword_8_2; }

		//inModeTransition+=[instance::ModeTransitionInstance|TransitionRef]
		public Assignment getInModeTransitionAssignment_8_3() { return cInModeTransitionAssignment_8_3; }

		//[instance::ModeTransitionInstance|TransitionRef]
		public CrossReference getInModeTransitionModeTransitionInstanceCrossReference_8_3_0() { return cInModeTransitionModeTransitionInstanceCrossReference_8_3_0; }

		//TransitionRef
		public RuleCall getInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_3_0_1() { return cInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_3_0_1; }

		//("," inModeTransition+=[instance::ModeTransitionInstance|TransitionRef])*
		public Group getGroup_8_4() { return cGroup_8_4; }

		//","
		public Keyword getCommaKeyword_8_4_0() { return cCommaKeyword_8_4_0; }

		//inModeTransition+=[instance::ModeTransitionInstance|TransitionRef]
		public Assignment getInModeTransitionAssignment_8_4_1() { return cInModeTransitionAssignment_8_4_1; }

		//[instance::ModeTransitionInstance|TransitionRef]
		public CrossReference getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0() { return cInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0; }

		//TransitionRef
		public RuleCall getInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_4_1_0_1() { return cInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_4_1_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_8_5() { return cRightParenthesisKeyword_8_5; }

		//":"
		public Keyword getColonKeyword_9() { return cColonKeyword_9; }

		//flowSpecification=[aadl2::FlowSpecification|DeclarativeRef]
		public Assignment getFlowSpecificationAssignment_10() { return cFlowSpecificationAssignment_10; }

		//[aadl2::FlowSpecification|DeclarativeRef]
		public CrossReference getFlowSpecificationFlowSpecificationCrossReference_10_0() { return cFlowSpecificationFlowSpecificationCrossReference_10_0; }

		//DeclarativeRef
		public RuleCall getFlowSpecificationFlowSpecificationDeclarativeRefParserRuleCall_10_0_1() { return cFlowSpecificationFlowSpecificationDeclarativeRefParserRuleCall_10_0_1; }

		//("{" ownedPropertyAssociation+=PropertyAssociationInstance+ "}")?
		public Group getGroup_11() { return cGroup_11; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_11_0() { return cLeftCurlyBracketKeyword_11_0; }

		//ownedPropertyAssociation+=PropertyAssociationInstance+
		public Assignment getOwnedPropertyAssociationAssignment_11_1() { return cOwnedPropertyAssociationAssignment_11_1; }

		//PropertyAssociationInstance
		public RuleCall getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_11_1_0() { return cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_11_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_11_2() { return cRightCurlyBracketKeyword_11_2; }
	}

	public class EndToEndFlowInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EndToEndFlowInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEndKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cToKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cEndKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cFlowKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cNameAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cNameIDTerminalRuleCall_4_0 = (RuleCall)cNameAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Assignment cFlowElementAssignment_5_0 = (Assignment)cGroup_5.eContents().get(0);
		private final CrossReference cFlowElementFlowElementInstanceCrossReference_5_0_0 = (CrossReference)cFlowElementAssignment_5_0.eContents().get(0);
		private final RuleCall cFlowElementFlowElementInstanceInstanceRefParserRuleCall_5_0_0_1 = (RuleCall)cFlowElementFlowElementInstanceCrossReference_5_0_0.eContents().get(1);
		private final Group cGroup_5_1 = (Group)cGroup_5.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_5_1_0 = (Keyword)cGroup_5_1.eContents().get(0);
		private final Assignment cFlowElementAssignment_5_1_1 = (Assignment)cGroup_5_1.eContents().get(1);
		private final CrossReference cFlowElementFlowElementInstanceCrossReference_5_1_1_0 = (CrossReference)cFlowElementAssignment_5_1_1.eContents().get(0);
		private final RuleCall cFlowElementFlowElementInstanceInstanceRefParserRuleCall_5_1_1_0_1 = (RuleCall)cFlowElementFlowElementInstanceCrossReference_5_1_1_0.eContents().get(1);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cInKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Keyword cModesKeyword_6_1 = (Keyword)cGroup_6.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_6_2 = (Keyword)cGroup_6.eContents().get(2);
		private final Assignment cInSystemOperationModeAssignment_6_3 = (Assignment)cGroup_6.eContents().get(3);
		private final CrossReference cInSystemOperationModeSystemOperationModeCrossReference_6_3_0 = (CrossReference)cInSystemOperationModeAssignment_6_3.eContents().get(0);
		private final RuleCall cInSystemOperationModeSystemOperationModeSomRefParserRuleCall_6_3_0_1 = (RuleCall)cInSystemOperationModeSystemOperationModeCrossReference_6_3_0.eContents().get(1);
		private final Group cGroup_6_4 = (Group)cGroup_6.eContents().get(4);
		private final Keyword cCommaKeyword_6_4_0 = (Keyword)cGroup_6_4.eContents().get(0);
		private final Assignment cInSystemOperationModeAssignment_6_4_1 = (Assignment)cGroup_6_4.eContents().get(1);
		private final CrossReference cInSystemOperationModeSystemOperationModeCrossReference_6_4_1_0 = (CrossReference)cInSystemOperationModeAssignment_6_4_1.eContents().get(0);
		private final RuleCall cInSystemOperationModeSystemOperationModeSomRefParserRuleCall_6_4_1_0_1 = (RuleCall)cInSystemOperationModeSystemOperationModeCrossReference_6_4_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_6_5 = (Keyword)cGroup_6.eContents().get(5);
		private final Keyword cColonKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Assignment cEndToEndFlowAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final CrossReference cEndToEndFlowEndToEndFlowCrossReference_8_0 = (CrossReference)cEndToEndFlowAssignment_8.eContents().get(0);
		private final RuleCall cEndToEndFlowEndToEndFlowDeclarativeRefParserRuleCall_8_0_1 = (RuleCall)cEndToEndFlowEndToEndFlowCrossReference_8_0.eContents().get(1);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cLeftCurlyBracketKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Assignment cOwnedPropertyAssociationAssignment_9_1 = (Assignment)cGroup_9.eContents().get(1);
		private final RuleCall cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_9_1_0 = (RuleCall)cOwnedPropertyAssociationAssignment_9_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_9_2 = (Keyword)cGroup_9.eContents().get(2);
		
		//EndToEndFlowInstance returns instance::EndToEndFlowInstance:
		//	"end" "to" "end" "flow" name=ID (flowElement+=[instance::FlowElementInstance|InstanceRef] ("->"
		//	flowElement+=[instance::FlowElementInstance|InstanceRef])*)? ("in" "modes" "("
		//	inSystemOperationMode+=[instance::SystemOperationMode|SomRef] (","
		//	inSystemOperationMode+=[instance::SystemOperationMode|SomRef])* ")")? ":"
		//	endToEndFlow=[aadl2::EndToEndFlow|DeclarativeRef] ("{" ownedPropertyAssociation+=PropertyAssociationInstance "}")?;
		@Override public ParserRule getRule() { return rule; }

		//"end" "to" "end" "flow" name=ID (flowElement+=[instance::FlowElementInstance|InstanceRef] ("->"
		//flowElement+=[instance::FlowElementInstance|InstanceRef])*)? ("in" "modes" "("
		//inSystemOperationMode+=[instance::SystemOperationMode|SomRef] (","
		//inSystemOperationMode+=[instance::SystemOperationMode|SomRef])* ")")? ":"
		//endToEndFlow=[aadl2::EndToEndFlow|DeclarativeRef] ("{" ownedPropertyAssociation+=PropertyAssociationInstance "}")?
		public Group getGroup() { return cGroup; }

		//"end"
		public Keyword getEndKeyword_0() { return cEndKeyword_0; }

		//"to"
		public Keyword getToKeyword_1() { return cToKeyword_1; }

		//"end"
		public Keyword getEndKeyword_2() { return cEndKeyword_2; }

		//"flow"
		public Keyword getFlowKeyword_3() { return cFlowKeyword_3; }

		//name=ID
		public Assignment getNameAssignment_4() { return cNameAssignment_4; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_4_0() { return cNameIDTerminalRuleCall_4_0; }

		//(flowElement+=[instance::FlowElementInstance|InstanceRef] ("->"
		//flowElement+=[instance::FlowElementInstance|InstanceRef])*)?
		public Group getGroup_5() { return cGroup_5; }

		//flowElement+=[instance::FlowElementInstance|InstanceRef]
		public Assignment getFlowElementAssignment_5_0() { return cFlowElementAssignment_5_0; }

		//[instance::FlowElementInstance|InstanceRef]
		public CrossReference getFlowElementFlowElementInstanceCrossReference_5_0_0() { return cFlowElementFlowElementInstanceCrossReference_5_0_0; }

		//InstanceRef
		public RuleCall getFlowElementFlowElementInstanceInstanceRefParserRuleCall_5_0_0_1() { return cFlowElementFlowElementInstanceInstanceRefParserRuleCall_5_0_0_1; }

		//("->" flowElement+=[instance::FlowElementInstance|InstanceRef])*
		public Group getGroup_5_1() { return cGroup_5_1; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_5_1_0() { return cHyphenMinusGreaterThanSignKeyword_5_1_0; }

		//flowElement+=[instance::FlowElementInstance|InstanceRef]
		public Assignment getFlowElementAssignment_5_1_1() { return cFlowElementAssignment_5_1_1; }

		//[instance::FlowElementInstance|InstanceRef]
		public CrossReference getFlowElementFlowElementInstanceCrossReference_5_1_1_0() { return cFlowElementFlowElementInstanceCrossReference_5_1_1_0; }

		//InstanceRef
		public RuleCall getFlowElementFlowElementInstanceInstanceRefParserRuleCall_5_1_1_0_1() { return cFlowElementFlowElementInstanceInstanceRefParserRuleCall_5_1_1_0_1; }

		//("in" "modes" "(" inSystemOperationMode+=[instance::SystemOperationMode|SomRef] (","
		//inSystemOperationMode+=[instance::SystemOperationMode|SomRef])* ")")?
		public Group getGroup_6() { return cGroup_6; }

		//"in"
		public Keyword getInKeyword_6_0() { return cInKeyword_6_0; }

		//"modes"
		public Keyword getModesKeyword_6_1() { return cModesKeyword_6_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_6_2() { return cLeftParenthesisKeyword_6_2; }

		//inSystemOperationMode+=[instance::SystemOperationMode|SomRef]
		public Assignment getInSystemOperationModeAssignment_6_3() { return cInSystemOperationModeAssignment_6_3; }

		//[instance::SystemOperationMode|SomRef]
		public CrossReference getInSystemOperationModeSystemOperationModeCrossReference_6_3_0() { return cInSystemOperationModeSystemOperationModeCrossReference_6_3_0; }

		//SomRef
		public RuleCall getInSystemOperationModeSystemOperationModeSomRefParserRuleCall_6_3_0_1() { return cInSystemOperationModeSystemOperationModeSomRefParserRuleCall_6_3_0_1; }

		//("," inSystemOperationMode+=[instance::SystemOperationMode|SomRef])*
		public Group getGroup_6_4() { return cGroup_6_4; }

		//","
		public Keyword getCommaKeyword_6_4_0() { return cCommaKeyword_6_4_0; }

		//inSystemOperationMode+=[instance::SystemOperationMode|SomRef]
		public Assignment getInSystemOperationModeAssignment_6_4_1() { return cInSystemOperationModeAssignment_6_4_1; }

		//[instance::SystemOperationMode|SomRef]
		public CrossReference getInSystemOperationModeSystemOperationModeCrossReference_6_4_1_0() { return cInSystemOperationModeSystemOperationModeCrossReference_6_4_1_0; }

		//SomRef
		public RuleCall getInSystemOperationModeSystemOperationModeSomRefParserRuleCall_6_4_1_0_1() { return cInSystemOperationModeSystemOperationModeSomRefParserRuleCall_6_4_1_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_6_5() { return cRightParenthesisKeyword_6_5; }

		//":"
		public Keyword getColonKeyword_7() { return cColonKeyword_7; }

		//endToEndFlow=[aadl2::EndToEndFlow|DeclarativeRef]
		public Assignment getEndToEndFlowAssignment_8() { return cEndToEndFlowAssignment_8; }

		//[aadl2::EndToEndFlow|DeclarativeRef]
		public CrossReference getEndToEndFlowEndToEndFlowCrossReference_8_0() { return cEndToEndFlowEndToEndFlowCrossReference_8_0; }

		//DeclarativeRef
		public RuleCall getEndToEndFlowEndToEndFlowDeclarativeRefParserRuleCall_8_0_1() { return cEndToEndFlowEndToEndFlowDeclarativeRefParserRuleCall_8_0_1; }

		//("{" ownedPropertyAssociation+=PropertyAssociationInstance "}")?
		public Group getGroup_9() { return cGroup_9; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_9_0() { return cLeftCurlyBracketKeyword_9_0; }

		//ownedPropertyAssociation+=PropertyAssociationInstance
		public Assignment getOwnedPropertyAssociationAssignment_9_1() { return cOwnedPropertyAssociationAssignment_9_1; }

		//PropertyAssociationInstance
		public RuleCall getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_9_1_0() { return cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_9_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_9_2() { return cRightCurlyBracketKeyword_9_2; }
	}

	public class ModeInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ModeInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cInitialAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cInitialInitialKeyword_0_0 = (Keyword)cInitialAssignment_0.eContents().get(0);
		private final Assignment cDerivedAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cDerivedDerivedKeyword_1_0 = (Keyword)cDerivedAssignment_1.eContents().get(0);
		private final Keyword cModeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameIDTerminalRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cEqualsSignKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Alternatives cAlternatives_4_1 = (Alternatives)cGroup_4.eContents().get(1);
		private final Assignment cParentAssignment_4_1_0 = (Assignment)cAlternatives_4_1.eContents().get(0);
		private final CrossReference cParentModeInstanceCrossReference_4_1_0_0 = (CrossReference)cParentAssignment_4_1_0.eContents().get(0);
		private final RuleCall cParentModeInstanceIDTerminalRuleCall_4_1_0_0_1 = (RuleCall)cParentModeInstanceCrossReference_4_1_0_0.eContents().get(1);
		private final Group cGroup_4_1_1 = (Group)cAlternatives_4_1.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_4_1_1_0 = (Keyword)cGroup_4_1_1.eContents().get(0);
		private final Assignment cParentAssignment_4_1_1_1 = (Assignment)cGroup_4_1_1.eContents().get(1);
		private final CrossReference cParentModeInstanceCrossReference_4_1_1_1_0 = (CrossReference)cParentAssignment_4_1_1_1.eContents().get(0);
		private final RuleCall cParentModeInstanceIDTerminalRuleCall_4_1_1_1_0_1 = (RuleCall)cParentModeInstanceCrossReference_4_1_1_1_0.eContents().get(1);
		private final Group cGroup_4_1_1_2 = (Group)cGroup_4_1_1.eContents().get(2);
		private final Keyword cCommaKeyword_4_1_1_2_0 = (Keyword)cGroup_4_1_1_2.eContents().get(0);
		private final Assignment cParentAssignment_4_1_1_2_1 = (Assignment)cGroup_4_1_1_2.eContents().get(1);
		private final CrossReference cParentModeInstanceCrossReference_4_1_1_2_1_0 = (CrossReference)cParentAssignment_4_1_1_2_1.eContents().get(0);
		private final RuleCall cParentModeInstanceIDTerminalRuleCall_4_1_1_2_1_0_1 = (RuleCall)cParentModeInstanceCrossReference_4_1_1_2_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_4_1_1_3 = (Keyword)cGroup_4_1_1.eContents().get(3);
		private final Keyword cColonKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cModeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cModeModeCrossReference_6_0 = (CrossReference)cModeAssignment_6.eContents().get(0);
		private final RuleCall cModeModeDeclarativeRefParserRuleCall_6_0_1 = (RuleCall)cModeModeCrossReference_6_0.eContents().get(1);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cLeftCurlyBracketKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cOwnedPropertyAssociationAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_7_1_0 = (RuleCall)cOwnedPropertyAssociationAssignment_7_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7_2 = (Keyword)cGroup_7.eContents().get(2);
		
		//ModeInstance returns instance::ModeInstance:
		//	initial?="initial"? derived?="derived"? "mode" name=ID ("=" (parent+=[instance::ModeInstance] | "("
		//	parent+=[instance::ModeInstance] ("," parent+=[instance::ModeInstance])+ ")"))? ":" mode=[aadl2::Mode|DeclarativeRef]
		//	("{" ownedPropertyAssociation+=PropertyAssociationInstance "}")?;
		@Override public ParserRule getRule() { return rule; }

		//initial?="initial"? derived?="derived"? "mode" name=ID ("=" (parent+=[instance::ModeInstance] | "("
		//parent+=[instance::ModeInstance] ("," parent+=[instance::ModeInstance])+ ")"))? ":" mode=[aadl2::Mode|DeclarativeRef]
		//("{" ownedPropertyAssociation+=PropertyAssociationInstance "}")?
		public Group getGroup() { return cGroup; }

		//initial?="initial"?
		public Assignment getInitialAssignment_0() { return cInitialAssignment_0; }

		//"initial"
		public Keyword getInitialInitialKeyword_0_0() { return cInitialInitialKeyword_0_0; }

		//derived?="derived"?
		public Assignment getDerivedAssignment_1() { return cDerivedAssignment_1; }

		//"derived"
		public Keyword getDerivedDerivedKeyword_1_0() { return cDerivedDerivedKeyword_1_0; }

		//"mode"
		public Keyword getModeKeyword_2() { return cModeKeyword_2; }

		//name=ID
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_3_0() { return cNameIDTerminalRuleCall_3_0; }

		//("=" (parent+=[instance::ModeInstance] | "(" parent+=[instance::ModeInstance] ("," parent+=[instance::ModeInstance])+
		//")"))?
		public Group getGroup_4() { return cGroup_4; }

		//"="
		public Keyword getEqualsSignKeyword_4_0() { return cEqualsSignKeyword_4_0; }

		//parent+=[instance::ModeInstance] | "(" parent+=[instance::ModeInstance] ("," parent+=[instance::ModeInstance])+ ")"
		public Alternatives getAlternatives_4_1() { return cAlternatives_4_1; }

		//parent+=[instance::ModeInstance]
		public Assignment getParentAssignment_4_1_0() { return cParentAssignment_4_1_0; }

		//[instance::ModeInstance]
		public CrossReference getParentModeInstanceCrossReference_4_1_0_0() { return cParentModeInstanceCrossReference_4_1_0_0; }

		//ID
		public RuleCall getParentModeInstanceIDTerminalRuleCall_4_1_0_0_1() { return cParentModeInstanceIDTerminalRuleCall_4_1_0_0_1; }

		//"(" parent+=[instance::ModeInstance] ("," parent+=[instance::ModeInstance])+ ")"
		public Group getGroup_4_1_1() { return cGroup_4_1_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_4_1_1_0() { return cLeftParenthesisKeyword_4_1_1_0; }

		//parent+=[instance::ModeInstance]
		public Assignment getParentAssignment_4_1_1_1() { return cParentAssignment_4_1_1_1; }

		//[instance::ModeInstance]
		public CrossReference getParentModeInstanceCrossReference_4_1_1_1_0() { return cParentModeInstanceCrossReference_4_1_1_1_0; }

		//ID
		public RuleCall getParentModeInstanceIDTerminalRuleCall_4_1_1_1_0_1() { return cParentModeInstanceIDTerminalRuleCall_4_1_1_1_0_1; }

		//("," parent+=[instance::ModeInstance])+
		public Group getGroup_4_1_1_2() { return cGroup_4_1_1_2; }

		//","
		public Keyword getCommaKeyword_4_1_1_2_0() { return cCommaKeyword_4_1_1_2_0; }

		//parent+=[instance::ModeInstance]
		public Assignment getParentAssignment_4_1_1_2_1() { return cParentAssignment_4_1_1_2_1; }

		//[instance::ModeInstance]
		public CrossReference getParentModeInstanceCrossReference_4_1_1_2_1_0() { return cParentModeInstanceCrossReference_4_1_1_2_1_0; }

		//ID
		public RuleCall getParentModeInstanceIDTerminalRuleCall_4_1_1_2_1_0_1() { return cParentModeInstanceIDTerminalRuleCall_4_1_1_2_1_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_4_1_1_3() { return cRightParenthesisKeyword_4_1_1_3; }

		//":"
		public Keyword getColonKeyword_5() { return cColonKeyword_5; }

		//mode=[aadl2::Mode|DeclarativeRef]
		public Assignment getModeAssignment_6() { return cModeAssignment_6; }

		//[aadl2::Mode|DeclarativeRef]
		public CrossReference getModeModeCrossReference_6_0() { return cModeModeCrossReference_6_0; }

		//DeclarativeRef
		public RuleCall getModeModeDeclarativeRefParserRuleCall_6_0_1() { return cModeModeDeclarativeRefParserRuleCall_6_0_1; }

		//("{" ownedPropertyAssociation+=PropertyAssociationInstance "}")?
		public Group getGroup_7() { return cGroup_7; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_7_0() { return cLeftCurlyBracketKeyword_7_0; }

		//ownedPropertyAssociation+=PropertyAssociationInstance
		public Assignment getOwnedPropertyAssociationAssignment_7_1() { return cOwnedPropertyAssociationAssignment_7_1; }

		//PropertyAssociationInstance
		public RuleCall getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_7_1_0() { return cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_7_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_7_2() { return cRightCurlyBracketKeyword_7_2; }
	}

	public class ModeTransitionInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ModeTransitionInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cModeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cTransitionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameModeTransitionNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cSourceAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cSourceModeInstanceCrossReference_3_0 = (CrossReference)cSourceAssignment_3.eContents().get(0);
		private final RuleCall cSourceModeInstanceIDTerminalRuleCall_3_0_1 = (RuleCall)cSourceModeInstanceCrossReference_3_0.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cDestinationAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cDestinationModeInstanceCrossReference_5_0 = (CrossReference)cDestinationAssignment_5.eContents().get(0);
		private final RuleCall cDestinationModeInstanceIDTerminalRuleCall_5_0_1 = (RuleCall)cDestinationModeInstanceCrossReference_5_0.eContents().get(1);
		private final Keyword cColonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cModeTransitionAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final CrossReference cModeTransitionModeTransitionCrossReference_7_0 = (CrossReference)cModeTransitionAssignment_7.eContents().get(0);
		private final RuleCall cModeTransitionModeTransitionDeclarativeRefParserRuleCall_7_0_1 = (RuleCall)cModeTransitionModeTransitionCrossReference_7_0.eContents().get(1);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cLeftCurlyBracketKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Assignment cOwnedPropertyAssociationAssignment_8_1 = (Assignment)cGroup_8.eContents().get(1);
		private final RuleCall cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_8_1_0 = (RuleCall)cOwnedPropertyAssociationAssignment_8_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_8_2 = (Keyword)cGroup_8.eContents().get(2);
		
		//ModeTransitionInstance returns instance::ModeTransitionInstance:
		//	"mode" "transition" name=ModeTransitionName source=[instance::ModeInstance] "->" destination=[instance::ModeInstance]
		//	":" modeTransition=[aadl2::ModeTransition|DeclarativeRef] ("{" ownedPropertyAssociation+=PropertyAssociationInstance
		//	"}")?;
		@Override public ParserRule getRule() { return rule; }

		//"mode" "transition" name=ModeTransitionName source=[instance::ModeInstance] "->" destination=[instance::ModeInstance]
		//":" modeTransition=[aadl2::ModeTransition|DeclarativeRef] ("{" ownedPropertyAssociation+=PropertyAssociationInstance
		//"}")?
		public Group getGroup() { return cGroup; }

		//"mode"
		public Keyword getModeKeyword_0() { return cModeKeyword_0; }

		//"transition"
		public Keyword getTransitionKeyword_1() { return cTransitionKeyword_1; }

		//name=ModeTransitionName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ModeTransitionName
		public RuleCall getNameModeTransitionNameParserRuleCall_2_0() { return cNameModeTransitionNameParserRuleCall_2_0; }

		//source=[instance::ModeInstance]
		public Assignment getSourceAssignment_3() { return cSourceAssignment_3; }

		//[instance::ModeInstance]
		public CrossReference getSourceModeInstanceCrossReference_3_0() { return cSourceModeInstanceCrossReference_3_0; }

		//ID
		public RuleCall getSourceModeInstanceIDTerminalRuleCall_3_0_1() { return cSourceModeInstanceIDTerminalRuleCall_3_0_1; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_4() { return cHyphenMinusGreaterThanSignKeyword_4; }

		//destination=[instance::ModeInstance]
		public Assignment getDestinationAssignment_5() { return cDestinationAssignment_5; }

		//[instance::ModeInstance]
		public CrossReference getDestinationModeInstanceCrossReference_5_0() { return cDestinationModeInstanceCrossReference_5_0; }

		//ID
		public RuleCall getDestinationModeInstanceIDTerminalRuleCall_5_0_1() { return cDestinationModeInstanceIDTerminalRuleCall_5_0_1; }

		//":"
		public Keyword getColonKeyword_6() { return cColonKeyword_6; }

		//modeTransition=[aadl2::ModeTransition|DeclarativeRef]
		public Assignment getModeTransitionAssignment_7() { return cModeTransitionAssignment_7; }

		//[aadl2::ModeTransition|DeclarativeRef]
		public CrossReference getModeTransitionModeTransitionCrossReference_7_0() { return cModeTransitionModeTransitionCrossReference_7_0; }

		//DeclarativeRef
		public RuleCall getModeTransitionModeTransitionDeclarativeRefParserRuleCall_7_0_1() { return cModeTransitionModeTransitionDeclarativeRefParserRuleCall_7_0_1; }

		//("{" ownedPropertyAssociation+=PropertyAssociationInstance "}")?
		public Group getGroup_8() { return cGroup_8; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_8_0() { return cLeftCurlyBracketKeyword_8_0; }

		//ownedPropertyAssociation+=PropertyAssociationInstance
		public Assignment getOwnedPropertyAssociationAssignment_8_1() { return cOwnedPropertyAssociationAssignment_8_1; }

		//PropertyAssociationInstance
		public RuleCall getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_8_1_0() { return cOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_8_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_8_2() { return cRightCurlyBracketKeyword_8_2; }
	}

	public class SystemOperationModeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SystemOperationMode");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSomKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameSTRINGTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cCurrentModeAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final CrossReference cCurrentModeModeInstanceCrossReference_2_0_0 = (CrossReference)cCurrentModeAssignment_2_0.eContents().get(0);
		private final RuleCall cCurrentModeModeInstanceInstanceRefParserRuleCall_2_0_0_1 = (RuleCall)cCurrentModeModeInstanceCrossReference_2_0_0.eContents().get(1);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cCurrentModeAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final CrossReference cCurrentModeModeInstanceCrossReference_2_1_1_0 = (CrossReference)cCurrentModeAssignment_2_1_1.eContents().get(0);
		private final RuleCall cCurrentModeModeInstanceInstanceRefParserRuleCall_2_1_1_0_1 = (RuleCall)cCurrentModeModeInstanceCrossReference_2_1_1_0.eContents().get(1);
		
		//SystemOperationMode returns instance::SystemOperationMode:
		//	"som" name=STRING (currentMode+=[instance::ModeInstance|InstanceRef] (","
		//	currentMode+=[instance::ModeInstance|InstanceRef])*)?;
		@Override public ParserRule getRule() { return rule; }

		//"som" name=STRING (currentMode+=[instance::ModeInstance|InstanceRef] (","
		//currentMode+=[instance::ModeInstance|InstanceRef])*)?
		public Group getGroup() { return cGroup; }

		//"som"
		public Keyword getSomKeyword_0() { return cSomKeyword_0; }

		//name=STRING
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//STRING
		public RuleCall getNameSTRINGTerminalRuleCall_1_0() { return cNameSTRINGTerminalRuleCall_1_0; }

		//(currentMode+=[instance::ModeInstance|InstanceRef] ("," currentMode+=[instance::ModeInstance|InstanceRef])*)?
		public Group getGroup_2() { return cGroup_2; }

		//currentMode+=[instance::ModeInstance|InstanceRef]
		public Assignment getCurrentModeAssignment_2_0() { return cCurrentModeAssignment_2_0; }

		//[instance::ModeInstance|InstanceRef]
		public CrossReference getCurrentModeModeInstanceCrossReference_2_0_0() { return cCurrentModeModeInstanceCrossReference_2_0_0; }

		//InstanceRef
		public RuleCall getCurrentModeModeInstanceInstanceRefParserRuleCall_2_0_0_1() { return cCurrentModeModeInstanceInstanceRefParserRuleCall_2_0_0_1; }

		//("," currentMode+=[instance::ModeInstance|InstanceRef])*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//","
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//currentMode+=[instance::ModeInstance|InstanceRef]
		public Assignment getCurrentModeAssignment_2_1_1() { return cCurrentModeAssignment_2_1_1; }

		//[instance::ModeInstance|InstanceRef]
		public CrossReference getCurrentModeModeInstanceCrossReference_2_1_1_0() { return cCurrentModeModeInstanceCrossReference_2_1_1_0; }

		//InstanceRef
		public RuleCall getCurrentModeModeInstanceInstanceRefParserRuleCall_2_1_1_0_1() { return cCurrentModeModeInstanceInstanceRefParserRuleCall_2_1_1_0_1; }
	}

	public class PropertyAssociationInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PropertyAssociationInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPropertyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cPropertyPropertyCrossReference_0_0 = (CrossReference)cPropertyAssignment_0.eContents().get(0);
		private final RuleCall cPropertyPropertyQPREFParserRuleCall_0_0_1 = (RuleCall)cPropertyPropertyCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedValueOptionalModalPropertyValueParserRuleCall_2_0 = (RuleCall)cOwnedValueAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cCommaKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cOwnedValueAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_0 = (RuleCall)cOwnedValueAssignment_3_1.eContents().get(0);
		private final Keyword cColonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cPropertyAssociationAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cPropertyAssociationPropertyAssociationCrossReference_5_0 = (CrossReference)cPropertyAssociationAssignment_5.eContents().get(0);
		private final RuleCall cPropertyAssociationPropertyAssociationPropertyAssociationRefParserRuleCall_5_0_1 = (RuleCall)cPropertyAssociationPropertyAssociationCrossReference_5_0.eContents().get(1);
		
		//PropertyAssociationInstance returns instance::PropertyAssociationInstance:
		//	property=[aadl2::Property|QPREF] "=>" ownedValue+=OptionalModalPropertyValue (","
		//	ownedValue+=OptionalModalPropertyValue)* ":" propertyAssociation=[aadl2::PropertyAssociation|PropertyAssociationRef];
		@Override public ParserRule getRule() { return rule; }

		//property=[aadl2::Property|QPREF] "=>" ownedValue+=OptionalModalPropertyValue (","
		//ownedValue+=OptionalModalPropertyValue)* ":" propertyAssociation=[aadl2::PropertyAssociation|PropertyAssociationRef]
		public Group getGroup() { return cGroup; }

		//property=[aadl2::Property|QPREF]
		public Assignment getPropertyAssignment_0() { return cPropertyAssignment_0; }

		//[aadl2::Property|QPREF]
		public CrossReference getPropertyPropertyCrossReference_0_0() { return cPropertyPropertyCrossReference_0_0; }

		//QPREF
		public RuleCall getPropertyPropertyQPREFParserRuleCall_0_0_1() { return cPropertyPropertyQPREFParserRuleCall_0_0_1; }

		//"=>"
		public Keyword getEqualsSignGreaterThanSignKeyword_1() { return cEqualsSignGreaterThanSignKeyword_1; }

		//ownedValue+=OptionalModalPropertyValue
		public Assignment getOwnedValueAssignment_2() { return cOwnedValueAssignment_2; }

		//OptionalModalPropertyValue
		public RuleCall getOwnedValueOptionalModalPropertyValueParserRuleCall_2_0() { return cOwnedValueOptionalModalPropertyValueParserRuleCall_2_0; }

		//("," ownedValue+=OptionalModalPropertyValue)*
		public Group getGroup_3() { return cGroup_3; }

		//","
		public Keyword getCommaKeyword_3_0() { return cCommaKeyword_3_0; }

		//ownedValue+=OptionalModalPropertyValue
		public Assignment getOwnedValueAssignment_3_1() { return cOwnedValueAssignment_3_1; }

		//OptionalModalPropertyValue
		public RuleCall getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_0() { return cOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_0; }

		//":"
		public Keyword getColonKeyword_4() { return cColonKeyword_4; }

		//propertyAssociation=[aadl2::PropertyAssociation|PropertyAssociationRef]
		public Assignment getPropertyAssociationAssignment_5() { return cPropertyAssociationAssignment_5; }

		//[aadl2::PropertyAssociation|PropertyAssociationRef]
		public CrossReference getPropertyAssociationPropertyAssociationCrossReference_5_0() { return cPropertyAssociationPropertyAssociationCrossReference_5_0; }

		//PropertyAssociationRef
		public RuleCall getPropertyAssociationPropertyAssociationPropertyAssociationRefParserRuleCall_5_0_1() { return cPropertyAssociationPropertyAssociationPropertyAssociationRefParserRuleCall_5_0_1; }
	}

	public class OptionalModalPropertyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OptionalModalPropertyValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedValueAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedValuePropertyExpressionParserRuleCall_0_0 = (RuleCall)cOwnedValueAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cInKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cModesKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		private final Assignment cInModeAssignment_1_3 = (Assignment)cGroup_1.eContents().get(3);
		private final CrossReference cInModeModeCrossReference_1_3_0 = (CrossReference)cInModeAssignment_1_3.eContents().get(0);
		private final RuleCall cInModeModeSomRefParserRuleCall_1_3_0_1 = (RuleCall)cInModeModeCrossReference_1_3_0.eContents().get(1);
		private final Group cGroup_1_4 = (Group)cGroup_1.eContents().get(4);
		private final Keyword cCommaKeyword_1_4_0 = (Keyword)cGroup_1_4.eContents().get(0);
		private final Assignment cInModeAssignment_1_4_1 = (Assignment)cGroup_1_4.eContents().get(1);
		private final CrossReference cInModeModeCrossReference_1_4_1_0 = (CrossReference)cInModeAssignment_1_4_1.eContents().get(0);
		private final RuleCall cInModeModeSomRefParserRuleCall_1_4_1_0_1 = (RuleCall)cInModeModeCrossReference_1_4_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_1_5 = (Keyword)cGroup_1.eContents().get(5);
		
		//OptionalModalPropertyValue returns aadl2::ModalPropertyValue:
		//	ownedValue=PropertyExpression ("in" "modes" "(" inMode+=[aadl2::Mode|SomRef] ("," inMode+=[aadl2::Mode|SomRef])*
		//	")")?;
		@Override public ParserRule getRule() { return rule; }

		//ownedValue=PropertyExpression ("in" "modes" "(" inMode+=[aadl2::Mode|SomRef] ("," inMode+=[aadl2::Mode|SomRef])* ")")?
		public Group getGroup() { return cGroup; }

		//ownedValue=PropertyExpression
		public Assignment getOwnedValueAssignment_0() { return cOwnedValueAssignment_0; }

		//PropertyExpression
		public RuleCall getOwnedValuePropertyExpressionParserRuleCall_0_0() { return cOwnedValuePropertyExpressionParserRuleCall_0_0; }

		//("in" "modes" "(" inMode+=[aadl2::Mode|SomRef] ("," inMode+=[aadl2::Mode|SomRef])* ")")?
		public Group getGroup_1() { return cGroup_1; }

		//"in"
		public Keyword getInKeyword_1_0() { return cInKeyword_1_0; }

		//"modes"
		public Keyword getModesKeyword_1_1() { return cModesKeyword_1_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_1_2() { return cLeftParenthesisKeyword_1_2; }

		//inMode+=[aadl2::Mode|SomRef]
		public Assignment getInModeAssignment_1_3() { return cInModeAssignment_1_3; }

		//[aadl2::Mode|SomRef]
		public CrossReference getInModeModeCrossReference_1_3_0() { return cInModeModeCrossReference_1_3_0; }

		//SomRef
		public RuleCall getInModeModeSomRefParserRuleCall_1_3_0_1() { return cInModeModeSomRefParserRuleCall_1_3_0_1; }

		//("," inMode+=[aadl2::Mode|SomRef])*
		public Group getGroup_1_4() { return cGroup_1_4; }

		//","
		public Keyword getCommaKeyword_1_4_0() { return cCommaKeyword_1_4_0; }

		//inMode+=[aadl2::Mode|SomRef]
		public Assignment getInModeAssignment_1_4_1() { return cInModeAssignment_1_4_1; }

		//[aadl2::Mode|SomRef]
		public CrossReference getInModeModeCrossReference_1_4_1_0() { return cInModeModeCrossReference_1_4_1_0; }

		//SomRef
		public RuleCall getInModeModeSomRefParserRuleCall_1_4_1_0_1() { return cInModeModeSomRefParserRuleCall_1_4_1_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_1_5() { return cRightParenthesisKeyword_1_5; }
	}

	public class PropertyExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PropertyExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cRecordTermParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cReferenceTermParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cInstanceReferenceValueParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cComponentClassifierTermParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cComputedTermParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cStringTermParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cNumericRangeTermParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cRealTermParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cIntegerTermParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		private final RuleCall cListTermParserRuleCall_9 = (RuleCall)cAlternatives.eContents().get(9);
		private final RuleCall cBooleanLiteralParserRuleCall_10 = (RuleCall)cAlternatives.eContents().get(10);
		private final RuleCall cLiteralorReferenceTermParserRuleCall_11 = (RuleCall)cAlternatives.eContents().get(11);
		
		//PropertyExpression returns aadl2::PropertyExpression:
		//	RecordTerm | ReferenceTerm | InstanceReferenceValue | ComponentClassifierTerm | ComputedTerm | StringTerm |
		//	NumericRangeTerm | RealTerm | IntegerTerm | ListTerm | BooleanLiteral | LiteralorReferenceTerm;
		@Override public ParserRule getRule() { return rule; }

		//RecordTerm | ReferenceTerm | InstanceReferenceValue | ComponentClassifierTerm | ComputedTerm | StringTerm |
		//NumericRangeTerm | RealTerm | IntegerTerm | ListTerm | BooleanLiteral | LiteralorReferenceTerm
		public Alternatives getAlternatives() { return cAlternatives; }

		//RecordTerm
		public RuleCall getRecordTermParserRuleCall_0() { return cRecordTermParserRuleCall_0; }

		//ReferenceTerm
		public RuleCall getReferenceTermParserRuleCall_1() { return cReferenceTermParserRuleCall_1; }

		//InstanceReferenceValue
		public RuleCall getInstanceReferenceValueParserRuleCall_2() { return cInstanceReferenceValueParserRuleCall_2; }

		//ComponentClassifierTerm
		public RuleCall getComponentClassifierTermParserRuleCall_3() { return cComponentClassifierTermParserRuleCall_3; }

		//ComputedTerm
		public RuleCall getComputedTermParserRuleCall_4() { return cComputedTermParserRuleCall_4; }

		//StringTerm
		public RuleCall getStringTermParserRuleCall_5() { return cStringTermParserRuleCall_5; }

		//NumericRangeTerm
		public RuleCall getNumericRangeTermParserRuleCall_6() { return cNumericRangeTermParserRuleCall_6; }

		//RealTerm
		public RuleCall getRealTermParserRuleCall_7() { return cRealTermParserRuleCall_7; }

		//IntegerTerm
		public RuleCall getIntegerTermParserRuleCall_8() { return cIntegerTermParserRuleCall_8; }

		//ListTerm
		public RuleCall getListTermParserRuleCall_9() { return cListTermParserRuleCall_9; }

		//BooleanLiteral
		public RuleCall getBooleanLiteralParserRuleCall_10() { return cBooleanLiteralParserRuleCall_10; }

		//LiteralorReferenceTerm
		public RuleCall getLiteralorReferenceTermParserRuleCall_11() { return cLiteralorReferenceTermParserRuleCall_11; }
	}

	public class ContainmentPathElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ContainmentPathElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNamedElementAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cNamedElementNamedElementCrossReference_0_0 = (CrossReference)cNamedElementAssignment_0.eContents().get(0);
		private final RuleCall cNamedElementNamedElementDeclarativeRefParserRuleCall_0_0_1 = (RuleCall)cNamedElementNamedElementCrossReference_0_0.eContents().get(1);
		private final Assignment cArrayRangeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cArrayRangeArrayRangeParserRuleCall_1_0 = (RuleCall)cArrayRangeAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cSolidusKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cPathAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cPathContainmentPathElementParserRuleCall_2_1_0 = (RuleCall)cPathAssignment_2_1.eContents().get(0);
		
		//ContainmentPathElement returns aadl2::ContainmentPathElement:
		//	namedElement=[aadl2::NamedElement|DeclarativeRef] arrayRange+=ArrayRange? ("/" path=ContainmentPathElement)?;
		@Override public ParserRule getRule() { return rule; }

		//namedElement=[aadl2::NamedElement|DeclarativeRef] arrayRange+=ArrayRange? ("/" path=ContainmentPathElement)?
		public Group getGroup() { return cGroup; }

		//namedElement=[aadl2::NamedElement|DeclarativeRef]
		public Assignment getNamedElementAssignment_0() { return cNamedElementAssignment_0; }

		//[aadl2::NamedElement|DeclarativeRef]
		public CrossReference getNamedElementNamedElementCrossReference_0_0() { return cNamedElementNamedElementCrossReference_0_0; }

		//DeclarativeRef
		public RuleCall getNamedElementNamedElementDeclarativeRefParserRuleCall_0_0_1() { return cNamedElementNamedElementDeclarativeRefParserRuleCall_0_0_1; }

		//arrayRange+=ArrayRange?
		public Assignment getArrayRangeAssignment_1() { return cArrayRangeAssignment_1; }

		//ArrayRange
		public RuleCall getArrayRangeArrayRangeParserRuleCall_1_0() { return cArrayRangeArrayRangeParserRuleCall_1_0; }

		//("/" path=ContainmentPathElement)?
		public Group getGroup_2() { return cGroup_2; }

		//"/"
		public Keyword getSolidusKeyword_2_0() { return cSolidusKeyword_2_0; }

		//path=ContainmentPathElement
		public Assignment getPathAssignment_2_1() { return cPathAssignment_2_1; }

		//ContainmentPathElement
		public RuleCall getPathContainmentPathElementParserRuleCall_2_1_0() { return cPathContainmentPathElementParserRuleCall_2_1_0; }
	}

	public class InstanceReferenceValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InstanceReferenceValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cReferenceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cReferencedInstanceObjectAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cReferencedInstanceObjectInstanceObjectCrossReference_2_0 = (CrossReference)cReferencedInstanceObjectAssignment_2.eContents().get(0);
		private final RuleCall cReferencedInstanceObjectInstanceObjectInstanceRefParserRuleCall_2_0_1 = (RuleCall)cReferencedInstanceObjectInstanceObjectCrossReference_2_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//InstanceReferenceValue returns instance::InstanceReferenceValue:
		//	"reference" "(" referencedInstanceObject=[instance::InstanceObject|InstanceRef] ")";
		@Override public ParserRule getRule() { return rule; }

		//"reference" "(" referencedInstanceObject=[instance::InstanceObject|InstanceRef] ")"
		public Group getGroup() { return cGroup; }

		//"reference"
		public Keyword getReferenceKeyword_0() { return cReferenceKeyword_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//referencedInstanceObject=[instance::InstanceObject|InstanceRef]
		public Assignment getReferencedInstanceObjectAssignment_2() { return cReferencedInstanceObjectAssignment_2; }

		//[instance::InstanceObject|InstanceRef]
		public CrossReference getReferencedInstanceObjectInstanceObjectCrossReference_2_0() { return cReferencedInstanceObjectInstanceObjectCrossReference_2_0; }

		//InstanceRef
		public RuleCall getReferencedInstanceObjectInstanceObjectInstanceRefParserRuleCall_2_0_1() { return cReferencedInstanceObjectInstanceObjectInstanceRefParserRuleCall_2_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class DirectionTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DirectionType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cInKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cOutKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Keyword cInKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Keyword cOutKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		
		//DirectionType returns aadl2::DirectionType:
		//	"in" | "out" | "in" "out";
		@Override public ParserRule getRule() { return rule; }

		//"in" | "out" | "in" "out"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"in"
		public Keyword getInKeyword_0() { return cInKeyword_0; }

		//"out"
		public Keyword getOutKeyword_1() { return cOutKeyword_1; }

		//"in" "out"
		public Group getGroup_2() { return cGroup_2; }

		//"in"
		public Keyword getInKeyword_2_0() { return cInKeyword_2_0; }

		//"out"
		public Keyword getOutKeyword_2_1() { return cOutKeyword_2_1; }
	}

	public class FeatureCategoryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FeatureCategory");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cDataPortKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cEventPortKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cEventDataPortKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cParameterKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cBusAccessKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cDataAccessKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cSubprogramAccessKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cSubprogramGroupAccessKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cFeatureGroupKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cAbstractFeatureKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		
		//FeatureCategory returns instance::FeatureCategory:
		//	"dataPort" | "eventPort" | "eventDataPort" | "parameter" | "busAccess" | "dataAccess" | "subprogramAccess" |
		//	"subprogramGroupAccess" | "featureGroup" | "abstractFeature";
		@Override public ParserRule getRule() { return rule; }

		//"dataPort" | "eventPort" | "eventDataPort" | "parameter" | "busAccess" | "dataAccess" | "subprogramAccess" |
		//"subprogramGroupAccess" | "featureGroup" | "abstractFeature"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"dataPort"
		public Keyword getDataPortKeyword_0() { return cDataPortKeyword_0; }

		//"eventPort"
		public Keyword getEventPortKeyword_1() { return cEventPortKeyword_1; }

		//"eventDataPort"
		public Keyword getEventDataPortKeyword_2() { return cEventDataPortKeyword_2; }

		//"parameter"
		public Keyword getParameterKeyword_3() { return cParameterKeyword_3; }

		//"busAccess"
		public Keyword getBusAccessKeyword_4() { return cBusAccessKeyword_4; }

		//"dataAccess"
		public Keyword getDataAccessKeyword_5() { return cDataAccessKeyword_5; }

		//"subprogramAccess"
		public Keyword getSubprogramAccessKeyword_6() { return cSubprogramAccessKeyword_6; }

		//"subprogramGroupAccess"
		public Keyword getSubprogramGroupAccessKeyword_7() { return cSubprogramGroupAccessKeyword_7; }

		//"featureGroup"
		public Keyword getFeatureGroupKeyword_8() { return cFeatureGroupKeyword_8; }

		//"abstractFeature"
		public Keyword getAbstractFeatureKeyword_9() { return cAbstractFeatureKeyword_9; }
	}

	public class ComponentCategoryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ComponentCategory");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAbstractKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cBusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cDataKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cDeviceKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cMemoryKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cProcessKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cProcessorKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cSubprogramKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Group cGroup_8 = (Group)cAlternatives.eContents().get(8);
		private final Keyword cSubprogramKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cGroupKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Keyword cSystemKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Group cGroup_10 = (Group)cAlternatives.eContents().get(10);
		private final Keyword cThreadKeyword_10_0 = (Keyword)cGroup_10.eContents().get(0);
		private final Keyword cGroupKeyword_10_1 = (Keyword)cGroup_10.eContents().get(1);
		private final Keyword cThreadKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Group cGroup_12 = (Group)cAlternatives.eContents().get(12);
		private final Keyword cVirtualKeyword_12_0 = (Keyword)cGroup_12.eContents().get(0);
		private final Keyword cBusKeyword_12_1 = (Keyword)cGroup_12.eContents().get(1);
		private final Group cGroup_13 = (Group)cAlternatives.eContents().get(13);
		private final Keyword cVirtualKeyword_13_0 = (Keyword)cGroup_13.eContents().get(0);
		private final Keyword cProcessorKeyword_13_1 = (Keyword)cGroup_13.eContents().get(1);
		
		//ComponentCategory returns aadl2::ComponentCategory:
		//	"abstract" | "bus" | "data" | "device" | "memory" | "process" | "processor" | "subprogram" | "subprogram" "group" |
		//	"system" | "thread" "group" | "thread" | "virtual" "bus" | "virtual" "processor";
		@Override public ParserRule getRule() { return rule; }

		//"abstract" | "bus" | "data" | "device" | "memory" | "process" | "processor" | "subprogram" | "subprogram" "group" |
		//"system" | "thread" "group" | "thread" | "virtual" "bus" | "virtual" "processor"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"abstract"
		public Keyword getAbstractKeyword_0() { return cAbstractKeyword_0; }

		//"bus"
		public Keyword getBusKeyword_1() { return cBusKeyword_1; }

		//"data"
		public Keyword getDataKeyword_2() { return cDataKeyword_2; }

		//"device"
		public Keyword getDeviceKeyword_3() { return cDeviceKeyword_3; }

		//"memory"
		public Keyword getMemoryKeyword_4() { return cMemoryKeyword_4; }

		//"process"
		public Keyword getProcessKeyword_5() { return cProcessKeyword_5; }

		//"processor"
		public Keyword getProcessorKeyword_6() { return cProcessorKeyword_6; }

		//"subprogram"
		public Keyword getSubprogramKeyword_7() { return cSubprogramKeyword_7; }

		//"subprogram" "group"
		public Group getGroup_8() { return cGroup_8; }

		//"subprogram"
		public Keyword getSubprogramKeyword_8_0() { return cSubprogramKeyword_8_0; }

		//"group"
		public Keyword getGroupKeyword_8_1() { return cGroupKeyword_8_1; }

		//"system"
		public Keyword getSystemKeyword_9() { return cSystemKeyword_9; }

		//"thread" "group"
		public Group getGroup_10() { return cGroup_10; }

		//"thread"
		public Keyword getThreadKeyword_10_0() { return cThreadKeyword_10_0; }

		//"group"
		public Keyword getGroupKeyword_10_1() { return cGroupKeyword_10_1; }

		//"thread"
		public Keyword getThreadKeyword_11() { return cThreadKeyword_11; }

		//"virtual" "bus"
		public Group getGroup_12() { return cGroup_12; }

		//"virtual"
		public Keyword getVirtualKeyword_12_0() { return cVirtualKeyword_12_0; }

		//"bus"
		public Keyword getBusKeyword_12_1() { return cBusKeyword_12_1; }

		//"virtual" "processor"
		public Group getGroup_13() { return cGroup_13; }

		//"virtual"
		public Keyword getVirtualKeyword_13_0() { return cVirtualKeyword_13_0; }

		//"processor"
		public Keyword getProcessorKeyword_13_1() { return cProcessorKeyword_13_1; }
	}

	public class ConnectionKindElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ConnectionKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cFeatureConnectionKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cAccessConnectionKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cParameterConnectionKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cPortConnectionKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cFeatureGroupConnectionKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		
		//ConnectionKind returns instance::ConnectionKind:
		//	"featureConnection" | "accessConnection" | "parameterConnection" | "portConnection" | "featureGroupConnection";
		@Override public ParserRule getRule() { return rule; }

		//"featureConnection" | "accessConnection" | "parameterConnection" | "portConnection" | "featureGroupConnection"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"featureConnection"
		public Keyword getFeatureConnectionKeyword_0() { return cFeatureConnectionKeyword_0; }

		//"accessConnection"
		public Keyword getAccessConnectionKeyword_1() { return cAccessConnectionKeyword_1; }

		//"parameterConnection"
		public Keyword getParameterConnectionKeyword_2() { return cParameterConnectionKeyword_2; }

		//"portConnection"
		public Keyword getPortConnectionKeyword_3() { return cPortConnectionKeyword_3; }

		//"featureGroupConnection"
		public Keyword getFeatureGroupConnectionKeyword_4() { return cFeatureGroupConnectionKeyword_4; }
	}

	public class ClassifierRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ClassifierRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Keyword cColonColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cFullStopKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_2_1 = (RuleCall)cGroup_2.eContents().get(1);
		
		//ClassifierRef:
		//	(ID "::")+ ID ("." ID)?;
		@Override public ParserRule getRule() { return rule; }

		//(ID "::")+ ID ("." ID)?
		public Group getGroup() { return cGroup; }

		//(ID "::")+
		public Group getGroup_0() { return cGroup_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }

		//"::"
		public Keyword getColonColonKeyword_0_1() { return cColonColonKeyword_0_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }

		//("." ID)?
		public Group getGroup_2() { return cGroup_2; }

		//"."
		public Keyword getFullStopKeyword_2_0() { return cFullStopKeyword_2_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_2_1() { return cIDTerminalRuleCall_2_1; }
	}

	public class ImplRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ImplRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Keyword cColonColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cIDTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		
		//ImplRef:
		//	(ID "::")+ ID "." ID;
		@Override public ParserRule getRule() { return rule; }

		//(ID "::")+ ID "." ID
		public Group getGroup() { return cGroup; }

		//(ID "::")+
		public Group getGroup_0() { return cGroup_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }

		//"::"
		public Keyword getColonColonKeyword_0_1() { return cColonColonKeyword_0_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }

		//"."
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }

		//ID
		public RuleCall getIDTerminalRuleCall_3() { return cIDTerminalRuleCall_3; }
	}

	public class DeclarativeRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DeclarativeRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Keyword cColonColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cFullStopKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_2_1 = (RuleCall)cGroup_2.eContents().get(1);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Group cGroup_4_0 = (Group)cAlternatives_4.eContents().get(0);
		private final Keyword cTransitionKeyword_4_0_0 = (Keyword)cGroup_4_0.eContents().get(0);
		private final Keyword cNumberSignKeyword_4_0_1 = (Keyword)cGroup_4_0.eContents().get(1);
		private final RuleCall cINTEGER_LITTerminalRuleCall_4_0_2 = (RuleCall)cGroup_4_0.eContents().get(2);
		private final RuleCall cIDTerminalRuleCall_4_1 = (RuleCall)cAlternatives_4.eContents().get(1);
		
		//DeclarativeRef:
		//	(ID "::")+ ID ("." ID)? ":" ("transition" "#" INTEGER_LIT | ID);
		@Override public ParserRule getRule() { return rule; }

		//(ID "::")+ ID ("." ID)? ":" ("transition" "#" INTEGER_LIT | ID)
		public Group getGroup() { return cGroup; }

		//(ID "::")+
		public Group getGroup_0() { return cGroup_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }

		//"::"
		public Keyword getColonColonKeyword_0_1() { return cColonColonKeyword_0_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }

		//("." ID)?
		public Group getGroup_2() { return cGroup_2; }

		//"."
		public Keyword getFullStopKeyword_2_0() { return cFullStopKeyword_2_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_2_1() { return cIDTerminalRuleCall_2_1; }

		//":"
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }

		//"transition" "#" INTEGER_LIT | ID
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//"transition" "#" INTEGER_LIT
		public Group getGroup_4_0() { return cGroup_4_0; }

		//"transition"
		public Keyword getTransitionKeyword_4_0_0() { return cTransitionKeyword_4_0_0; }

		//"#"
		public Keyword getNumberSignKeyword_4_0_1() { return cNumberSignKeyword_4_0_1; }

		//INTEGER_LIT
		public RuleCall getINTEGER_LITTerminalRuleCall_4_0_2() { return cINTEGER_LITTerminalRuleCall_4_0_2; }

		//ID
		public RuleCall getIDTerminalRuleCall_4_1() { return cIDTerminalRuleCall_4_1; }
	}

	public class InstanceRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InstanceRef");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cParentKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_0_0 = (RuleCall)cGroup_1_0.eContents().get(0);
		private final Group cGroup_1_0_1 = (Group)cGroup_1_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_1_0_1_0 = (Keyword)cGroup_1_0_1.eContents().get(0);
		private final RuleCall cINTEGER_LITTerminalRuleCall_1_0_1_1 = (RuleCall)cGroup_1_0_1.eContents().get(1);
		private final Keyword cRightSquareBracketKeyword_1_0_1_2 = (Keyword)cGroup_1_0_1.eContents().get(2);
		private final Keyword cFullStopKeyword_1_0_2 = (Keyword)cGroup_1_0.eContents().get(2);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final Group cGroup_1_1_0 = (Group)cAlternatives_1_1.eContents().get(0);
		private final Keyword cConnectionKeyword_1_1_0_0 = (Keyword)cGroup_1_1_0.eContents().get(0);
		private final Keyword cNumberSignKeyword_1_1_0_1 = (Keyword)cGroup_1_1_0.eContents().get(1);
		private final RuleCall cINTEGER_LITTerminalRuleCall_1_1_0_2 = (RuleCall)cGroup_1_1_0.eContents().get(2);
		private final Group cGroup_1_1_1 = (Group)cAlternatives_1_1.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1_1_1_0 = (RuleCall)cGroup_1_1_1.eContents().get(0);
		private final Group cGroup_1_1_1_1 = (Group)cGroup_1_1_1.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_1_1_1_1_0 = (Keyword)cGroup_1_1_1_1.eContents().get(0);
		private final RuleCall cINTEGER_LITTerminalRuleCall_1_1_1_1_1 = (RuleCall)cGroup_1_1_1_1.eContents().get(1);
		private final Keyword cRightSquareBracketKeyword_1_1_1_1_2 = (Keyword)cGroup_1_1_1_1.eContents().get(2);
		
		//InstanceRef:
		//	"parent" | (ID ("[" INTEGER_LIT "]")* ".")* ("connection" "#" INTEGER_LIT | ID ("[" INTEGER_LIT "]")*);
		@Override public ParserRule getRule() { return rule; }

		//"parent" | (ID ("[" INTEGER_LIT "]")* ".")* ("connection" "#" INTEGER_LIT | ID ("[" INTEGER_LIT "]")*)
		public Alternatives getAlternatives() { return cAlternatives; }

		//"parent"
		public Keyword getParentKeyword_0() { return cParentKeyword_0; }

		//(ID ("[" INTEGER_LIT "]")* ".")* ("connection" "#" INTEGER_LIT | ID ("[" INTEGER_LIT "]")*)
		public Group getGroup_1() { return cGroup_1; }

		//(ID ("[" INTEGER_LIT "]")* ".")*
		public Group getGroup_1_0() { return cGroup_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_0_0() { return cIDTerminalRuleCall_1_0_0; }

		//("[" INTEGER_LIT "]")*
		public Group getGroup_1_0_1() { return cGroup_1_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_1_0_1_0() { return cLeftSquareBracketKeyword_1_0_1_0; }

		//INTEGER_LIT
		public RuleCall getINTEGER_LITTerminalRuleCall_1_0_1_1() { return cINTEGER_LITTerminalRuleCall_1_0_1_1; }

		//"]"
		public Keyword getRightSquareBracketKeyword_1_0_1_2() { return cRightSquareBracketKeyword_1_0_1_2; }

		//"."
		public Keyword getFullStopKeyword_1_0_2() { return cFullStopKeyword_1_0_2; }

		//"connection" "#" INTEGER_LIT | ID ("[" INTEGER_LIT "]")*
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }

		//"connection" "#" INTEGER_LIT
		public Group getGroup_1_1_0() { return cGroup_1_1_0; }

		//"connection"
		public Keyword getConnectionKeyword_1_1_0_0() { return cConnectionKeyword_1_1_0_0; }

		//"#"
		public Keyword getNumberSignKeyword_1_1_0_1() { return cNumberSignKeyword_1_1_0_1; }

		//INTEGER_LIT
		public RuleCall getINTEGER_LITTerminalRuleCall_1_1_0_2() { return cINTEGER_LITTerminalRuleCall_1_1_0_2; }

		//ID ("[" INTEGER_LIT "]")*
		public Group getGroup_1_1_1() { return cGroup_1_1_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1_1_0() { return cIDTerminalRuleCall_1_1_1_0; }

		//("[" INTEGER_LIT "]")*
		public Group getGroup_1_1_1_1() { return cGroup_1_1_1_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_1_1_1_1_0() { return cLeftSquareBracketKeyword_1_1_1_1_0; }

		//INTEGER_LIT
		public RuleCall getINTEGER_LITTerminalRuleCall_1_1_1_1_1() { return cINTEGER_LITTerminalRuleCall_1_1_1_1_1; }

		//"]"
		public Keyword getRightSquareBracketKeyword_1_1_1_1_2() { return cRightSquareBracketKeyword_1_1_1_1_2; }
	}

	public class SomRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SomRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSomKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cNumberSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cINTEGER_LITTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		
		//SomRef:
		//	"som" "#" INTEGER_LIT;
		@Override public ParserRule getRule() { return rule; }

		//"som" "#" INTEGER_LIT
		public Group getGroup() { return cGroup; }

		//"som"
		public Keyword getSomKeyword_0() { return cSomKeyword_0; }

		//"#"
		public Keyword getNumberSignKeyword_1() { return cNumberSignKeyword_1; }

		//INTEGER_LIT
		public RuleCall getINTEGER_LITTerminalRuleCall_2() { return cINTEGER_LITTerminalRuleCall_2; }
	}

	public class TransitionRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TransitionRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTransitionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cNumberSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cINTEGER_LITTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		
		//TransitionRef:
		//	"transition" "#" INTEGER_LIT;
		@Override public ParserRule getRule() { return rule; }

		//"transition" "#" INTEGER_LIT
		public Group getGroup() { return cGroup; }

		//"transition"
		public Keyword getTransitionKeyword_0() { return cTransitionKeyword_0; }

		//"#"
		public Keyword getNumberSignKeyword_1() { return cNumberSignKeyword_1; }

		//INTEGER_LIT
		public RuleCall getINTEGER_LITTerminalRuleCall_2() { return cINTEGER_LITTerminalRuleCall_2; }
	}

	public class ModeTransitionNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ModeTransitionName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Keyword cFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final RuleCall cIDTerminalRuleCall_4 = (RuleCall)cGroup.eContents().get(4);
		
		//ModeTransitionName:
		//	ID "." ID "." ID;
		@Override public ParserRule getRule() { return rule; }

		//ID "." ID "." ID
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//"."
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_2() { return cIDTerminalRuleCall_2; }

		//"."
		public Keyword getFullStopKeyword_3() { return cFullStopKeyword_3; }

		//ID
		public RuleCall getIDTerminalRuleCall_4() { return cIDTerminalRuleCall_4; }
	}

	public class PropertyAssociationRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PropertyAssociationRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Keyword cColonColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cFullStopKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_2_1 = (RuleCall)cGroup_2.eContents().get(1);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Alternatives cAlternatives_4_0 = (Alternatives)cGroup_4.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_4_0_0 = (RuleCall)cAlternatives_4_0.eContents().get(0);
		private final Group cGroup_4_0_1 = (Group)cAlternatives_4_0.eContents().get(1);
		private final Keyword cTransitionKeyword_4_0_1_0 = (Keyword)cGroup_4_0_1.eContents().get(0);
		private final Keyword cNumberSignKeyword_4_0_1_1 = (Keyword)cGroup_4_0_1.eContents().get(1);
		private final RuleCall cINTEGER_LITTerminalRuleCall_4_0_1_2 = (RuleCall)cGroup_4_0_1.eContents().get(2);
		private final Keyword cColonKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);
		private final Keyword cPropertyKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cNumberSignKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final RuleCall cINTEGER_LITTerminalRuleCall_7 = (RuleCall)cGroup.eContents().get(7);
		
		//PropertyAssociationRef:
		//	(ID "::")+ ID ("." ID)? ":" ((ID | "transition" "#" INTEGER_LIT) ":")? "property" "#" INTEGER_LIT;
		@Override public ParserRule getRule() { return rule; }

		//(ID "::")+ ID ("." ID)? ":" ((ID | "transition" "#" INTEGER_LIT) ":")? "property" "#" INTEGER_LIT
		public Group getGroup() { return cGroup; }

		//(ID "::")+
		public Group getGroup_0() { return cGroup_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }

		//"::"
		public Keyword getColonColonKeyword_0_1() { return cColonColonKeyword_0_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }

		//("." ID)?
		public Group getGroup_2() { return cGroup_2; }

		//"."
		public Keyword getFullStopKeyword_2_0() { return cFullStopKeyword_2_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_2_1() { return cIDTerminalRuleCall_2_1; }

		//":"
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }

		//((ID | "transition" "#" INTEGER_LIT) ":")?
		public Group getGroup_4() { return cGroup_4; }

		//ID | "transition" "#" INTEGER_LIT
		public Alternatives getAlternatives_4_0() { return cAlternatives_4_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_4_0_0() { return cIDTerminalRuleCall_4_0_0; }

		//"transition" "#" INTEGER_LIT
		public Group getGroup_4_0_1() { return cGroup_4_0_1; }

		//"transition"
		public Keyword getTransitionKeyword_4_0_1_0() { return cTransitionKeyword_4_0_1_0; }

		//"#"
		public Keyword getNumberSignKeyword_4_0_1_1() { return cNumberSignKeyword_4_0_1_1; }

		//INTEGER_LIT
		public RuleCall getINTEGER_LITTerminalRuleCall_4_0_1_2() { return cINTEGER_LITTerminalRuleCall_4_0_1_2; }

		//":"
		public Keyword getColonKeyword_4_1() { return cColonKeyword_4_1; }

		//"property"
		public Keyword getPropertyKeyword_5() { return cPropertyKeyword_5; }

		//"#"
		public Keyword getNumberSignKeyword_6() { return cNumberSignKeyword_6; }

		//INTEGER_LIT
		public RuleCall getINTEGER_LITTerminalRuleCall_7() { return cINTEGER_LITTerminalRuleCall_7; }
	}

	public class LongElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Long");
		private final RuleCall cINTEGER_LITTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//Long returns ecore::ELong:
		//	INTEGER_LIT;
		@Override public ParserRule getRule() { return rule; }

		//INTEGER_LIT
		public RuleCall getINTEGER_LITTerminalRuleCall() { return cINTEGER_LITTerminalRuleCall; }
	}
	
	
	private final SystemInstanceElements pSystemInstance;
	private final FeatureInstanceElements pFeatureInstance;
	private final ComponentInstanceElements pComponentInstance;
	private final ConnectionInstanceElements pConnectionInstance;
	private final ConnectionReferenceElements pConnectionReference;
	private final FlowSpecificationInstanceElements pFlowSpecificationInstance;
	private final EndToEndFlowInstanceElements pEndToEndFlowInstance;
	private final ModeInstanceElements pModeInstance;
	private final ModeTransitionInstanceElements pModeTransitionInstance;
	private final SystemOperationModeElements pSystemOperationMode;
	private final PropertyAssociationInstanceElements pPropertyAssociationInstance;
	private final OptionalModalPropertyValueElements pOptionalModalPropertyValue;
	private final PropertyExpressionElements pPropertyExpression;
	private final ContainmentPathElementElements pContainmentPathElement;
	private final InstanceReferenceValueElements pInstanceReferenceValue;
	private final DirectionTypeElements pDirectionType;
	private final FeatureCategoryElements pFeatureCategory;
	private final ComponentCategoryElements pComponentCategory;
	private final ConnectionKindElements pConnectionKind;
	private final ClassifierRefElements pClassifierRef;
	private final ImplRefElements pImplRef;
	private final DeclarativeRefElements pDeclarativeRef;
	private final InstanceRefElements pInstanceRef;
	private final SomRefElements pSomRef;
	private final TransitionRefElements pTransitionRef;
	private final ModeTransitionNameElements pModeTransitionName;
	private final PropertyAssociationRefElements pPropertyAssociationRef;
	private final LongElements pLong;
	
	private final Grammar grammar;

	private final PropertiesGrammarAccess gaProperties;

	@Inject
	public InstanceGrammarAccess(GrammarProvider grammarProvider,
		PropertiesGrammarAccess gaProperties) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaProperties = gaProperties;
		this.pSystemInstance = new SystemInstanceElements();
		this.pFeatureInstance = new FeatureInstanceElements();
		this.pComponentInstance = new ComponentInstanceElements();
		this.pConnectionInstance = new ConnectionInstanceElements();
		this.pConnectionReference = new ConnectionReferenceElements();
		this.pFlowSpecificationInstance = new FlowSpecificationInstanceElements();
		this.pEndToEndFlowInstance = new EndToEndFlowInstanceElements();
		this.pModeInstance = new ModeInstanceElements();
		this.pModeTransitionInstance = new ModeTransitionInstanceElements();
		this.pSystemOperationMode = new SystemOperationModeElements();
		this.pPropertyAssociationInstance = new PropertyAssociationInstanceElements();
		this.pOptionalModalPropertyValue = new OptionalModalPropertyValueElements();
		this.pPropertyExpression = new PropertyExpressionElements();
		this.pContainmentPathElement = new ContainmentPathElementElements();
		this.pInstanceReferenceValue = new InstanceReferenceValueElements();
		this.pDirectionType = new DirectionTypeElements();
		this.pFeatureCategory = new FeatureCategoryElements();
		this.pComponentCategory = new ComponentCategoryElements();
		this.pConnectionKind = new ConnectionKindElements();
		this.pClassifierRef = new ClassifierRefElements();
		this.pImplRef = new ImplRefElements();
		this.pDeclarativeRef = new DeclarativeRefElements();
		this.pInstanceRef = new InstanceRefElements();
		this.pSomRef = new SomRefElements();
		this.pTransitionRef = new TransitionRefElements();
		this.pModeTransitionName = new ModeTransitionNameElements();
		this.pPropertyAssociationRef = new PropertyAssociationRefElements();
		this.pLong = new LongElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.aadl2.instance.textual.Instance".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	public PropertiesGrammarAccess getPropertiesGrammarAccess() {
		return gaProperties;
	}

	
	//SystemInstance returns instance::SystemInstance:
	//	category=ComponentCategory name=ID ":" componentImplementation=[aadl2::ComponentImplementation|ImplRef] "{"
	//	(featureInstance+=FeatureInstance | componentInstance+=ComponentInstance | connectionInstance+=ConnectionInstance |
	//	flowSpecification+=FlowSpecificationInstance | endToEndFlow+=EndToEndFlowInstance | modeInstance+=ModeInstance |
	//	modeTransitionInstance+=ModeTransitionInstance | systemOperationMode+=SystemOperationMode |
	//	ownedPropertyAssociation+=PropertyAssociationInstance)* "}";
	public SystemInstanceElements getSystemInstanceAccess() {
		return pSystemInstance;
	}
	
	public ParserRule getSystemInstanceRule() {
		return getSystemInstanceAccess().getRule();
	}

	//FeatureInstance returns instance::FeatureInstance:
	//	direction=DirectionType category=FeatureCategory name=ID ("[" index=Long "]")? ":"
	//	feature=[aadl2::Feature|DeclarativeRef] ("{" (featureInstance+=FeatureInstance |
	//	ownedPropertyAssociation+=PropertyAssociationInstance)* "}")?;
	public FeatureInstanceElements getFeatureInstanceAccess() {
		return pFeatureInstance;
	}
	
	public ParserRule getFeatureInstanceRule() {
		return getFeatureInstanceAccess().getRule();
	}

	//ComponentInstance returns instance::ComponentInstance:
	//	category=ComponentCategory name=ID ("[" index+=Long "]")* ("in" "modes" "(" inMode+=[instance::ModeInstance] (","
	//	inMode+=[instance::ModeInstance])* ")")? ":" classifier=[aadl2::ComponentClassifier|ClassifierRef] ","
	//	subcomponent=[aadl2::Subcomponent|DeclarativeRef] ("{" (featureInstance+=FeatureInstance |
	//	componentInstance+=ComponentInstance | connectionInstance+=ConnectionInstance |
	//	flowSpecification+=FlowSpecificationInstance | endToEndFlow+=EndToEndFlowInstance | modeInstance+=ModeInstance |
	//	modeTransitionInstance+=ModeTransitionInstance | ownedPropertyAssociation+=PropertyAssociationInstance)* "}")?;
	public ComponentInstanceElements getComponentInstanceAccess() {
		return pComponentInstance;
	}
	
	public ParserRule getComponentInstanceRule() {
		return getComponentInstanceAccess().getRule();
	}

	//ConnectionInstance returns instance::ConnectionInstance:
	//	complete?="complete"? kind=ConnectionKind name=STRING ":" source=[instance::ConnectionInstanceEnd|InstanceRef]
	//	(bidirectional?="<->" | "->") destination=[instance::ConnectionInstanceEnd|InstanceRef] ("in" "modes" "("
	//	inSystemOperationMode+=[instance::SystemOperationMode|SomRef] (","
	//	inSystemOperationMode+=[instance::SystemOperationMode|SomRef])* ")")? ("in" "transitions" "("
	//	inModeTransition+=[instance::ModeTransitionInstance|TransitionRef] (","
	//	inModeTransition+=[instance::ModeTransitionInstance|TransitionRef])* ")")? "{"
	//	(connectionReference+=ConnectionReference | ownedPropertyAssociation+=PropertyAssociationInstance)+ "}";
	public ConnectionInstanceElements getConnectionInstanceAccess() {
		return pConnectionInstance;
	}
	
	public ParserRule getConnectionInstanceRule() {
		return getConnectionInstanceAccess().getRule();
	}

	//ConnectionReference returns instance::ConnectionReference:
	//	source=[instance::ConnectionInstanceEnd|InstanceRef] "->" destination=[instance::ConnectionInstanceEnd|InstanceRef]
	//	":" connection=[aadl2::Connection|DeclarativeRef] "in" context=[instance::ComponentInstance|InstanceRef];
	public ConnectionReferenceElements getConnectionReferenceAccess() {
		return pConnectionReference;
	}
	
	public ParserRule getConnectionReferenceRule() {
		return getConnectionReferenceAccess().getRule();
	}

	//FlowSpecificationInstance returns instance::FlowSpecificationInstance:
	//	"flow" name=ID "(" source=[instance::FeatureInstance|InstanceRef]? "->"
	//	destination=[instance::FeatureInstance|InstanceRef]? ")" ("in" "modes" "(" inMode+=[instance::ModeInstance] (","
	//	inMode+=[instance::ModeInstance])* ")")? ("in" "transitions" "("
	//	inModeTransition+=[instance::ModeTransitionInstance|TransitionRef] (","
	//	inModeTransition+=[instance::ModeTransitionInstance|TransitionRef])* ")")? ":"
	//	flowSpecification=[aadl2::FlowSpecification|DeclarativeRef] ("{"
	//	ownedPropertyAssociation+=PropertyAssociationInstance+ "}")?;
	public FlowSpecificationInstanceElements getFlowSpecificationInstanceAccess() {
		return pFlowSpecificationInstance;
	}
	
	public ParserRule getFlowSpecificationInstanceRule() {
		return getFlowSpecificationInstanceAccess().getRule();
	}

	//EndToEndFlowInstance returns instance::EndToEndFlowInstance:
	//	"end" "to" "end" "flow" name=ID (flowElement+=[instance::FlowElementInstance|InstanceRef] ("->"
	//	flowElement+=[instance::FlowElementInstance|InstanceRef])*)? ("in" "modes" "("
	//	inSystemOperationMode+=[instance::SystemOperationMode|SomRef] (","
	//	inSystemOperationMode+=[instance::SystemOperationMode|SomRef])* ")")? ":"
	//	endToEndFlow=[aadl2::EndToEndFlow|DeclarativeRef] ("{" ownedPropertyAssociation+=PropertyAssociationInstance "}")?;
	public EndToEndFlowInstanceElements getEndToEndFlowInstanceAccess() {
		return pEndToEndFlowInstance;
	}
	
	public ParserRule getEndToEndFlowInstanceRule() {
		return getEndToEndFlowInstanceAccess().getRule();
	}

	//ModeInstance returns instance::ModeInstance:
	//	initial?="initial"? derived?="derived"? "mode" name=ID ("=" (parent+=[instance::ModeInstance] | "("
	//	parent+=[instance::ModeInstance] ("," parent+=[instance::ModeInstance])+ ")"))? ":" mode=[aadl2::Mode|DeclarativeRef]
	//	("{" ownedPropertyAssociation+=PropertyAssociationInstance "}")?;
	public ModeInstanceElements getModeInstanceAccess() {
		return pModeInstance;
	}
	
	public ParserRule getModeInstanceRule() {
		return getModeInstanceAccess().getRule();
	}

	//ModeTransitionInstance returns instance::ModeTransitionInstance:
	//	"mode" "transition" name=ModeTransitionName source=[instance::ModeInstance] "->" destination=[instance::ModeInstance]
	//	":" modeTransition=[aadl2::ModeTransition|DeclarativeRef] ("{" ownedPropertyAssociation+=PropertyAssociationInstance
	//	"}")?;
	public ModeTransitionInstanceElements getModeTransitionInstanceAccess() {
		return pModeTransitionInstance;
	}
	
	public ParserRule getModeTransitionInstanceRule() {
		return getModeTransitionInstanceAccess().getRule();
	}

	//SystemOperationMode returns instance::SystemOperationMode:
	//	"som" name=STRING (currentMode+=[instance::ModeInstance|InstanceRef] (","
	//	currentMode+=[instance::ModeInstance|InstanceRef])*)?;
	public SystemOperationModeElements getSystemOperationModeAccess() {
		return pSystemOperationMode;
	}
	
	public ParserRule getSystemOperationModeRule() {
		return getSystemOperationModeAccess().getRule();
	}

	//PropertyAssociationInstance returns instance::PropertyAssociationInstance:
	//	property=[aadl2::Property|QPREF] "=>" ownedValue+=OptionalModalPropertyValue (","
	//	ownedValue+=OptionalModalPropertyValue)* ":" propertyAssociation=[aadl2::PropertyAssociation|PropertyAssociationRef];
	public PropertyAssociationInstanceElements getPropertyAssociationInstanceAccess() {
		return pPropertyAssociationInstance;
	}
	
	public ParserRule getPropertyAssociationInstanceRule() {
		return getPropertyAssociationInstanceAccess().getRule();
	}

	//OptionalModalPropertyValue returns aadl2::ModalPropertyValue:
	//	ownedValue=PropertyExpression ("in" "modes" "(" inMode+=[aadl2::Mode|SomRef] ("," inMode+=[aadl2::Mode|SomRef])*
	//	")")?;
	public OptionalModalPropertyValueElements getOptionalModalPropertyValueAccess() {
		return pOptionalModalPropertyValue;
	}
	
	public ParserRule getOptionalModalPropertyValueRule() {
		return getOptionalModalPropertyValueAccess().getRule();
	}

	//PropertyExpression returns aadl2::PropertyExpression:
	//	RecordTerm | ReferenceTerm | InstanceReferenceValue | ComponentClassifierTerm | ComputedTerm | StringTerm |
	//	NumericRangeTerm | RealTerm | IntegerTerm | ListTerm | BooleanLiteral | LiteralorReferenceTerm;
	public PropertyExpressionElements getPropertyExpressionAccess() {
		return pPropertyExpression;
	}
	
	public ParserRule getPropertyExpressionRule() {
		return getPropertyExpressionAccess().getRule();
	}

	//ContainmentPathElement returns aadl2::ContainmentPathElement:
	//	namedElement=[aadl2::NamedElement|DeclarativeRef] arrayRange+=ArrayRange? ("/" path=ContainmentPathElement)?;
	public ContainmentPathElementElements getContainmentPathElementAccess() {
		return pContainmentPathElement;
	}
	
	public ParserRule getContainmentPathElementRule() {
		return getContainmentPathElementAccess().getRule();
	}

	//InstanceReferenceValue returns instance::InstanceReferenceValue:
	//	"reference" "(" referencedInstanceObject=[instance::InstanceObject|InstanceRef] ")";
	public InstanceReferenceValueElements getInstanceReferenceValueAccess() {
		return pInstanceReferenceValue;
	}
	
	public ParserRule getInstanceReferenceValueRule() {
		return getInstanceReferenceValueAccess().getRule();
	}

	//DirectionType returns aadl2::DirectionType:
	//	"in" | "out" | "in" "out";
	public DirectionTypeElements getDirectionTypeAccess() {
		return pDirectionType;
	}
	
	public ParserRule getDirectionTypeRule() {
		return getDirectionTypeAccess().getRule();
	}

	//FeatureCategory returns instance::FeatureCategory:
	//	"dataPort" | "eventPort" | "eventDataPort" | "parameter" | "busAccess" | "dataAccess" | "subprogramAccess" |
	//	"subprogramGroupAccess" | "featureGroup" | "abstractFeature";
	public FeatureCategoryElements getFeatureCategoryAccess() {
		return pFeatureCategory;
	}
	
	public ParserRule getFeatureCategoryRule() {
		return getFeatureCategoryAccess().getRule();
	}

	//ComponentCategory returns aadl2::ComponentCategory:
	//	"abstract" | "bus" | "data" | "device" | "memory" | "process" | "processor" | "subprogram" | "subprogram" "group" |
	//	"system" | "thread" "group" | "thread" | "virtual" "bus" | "virtual" "processor";
	public ComponentCategoryElements getComponentCategoryAccess() {
		return pComponentCategory;
	}
	
	public ParserRule getComponentCategoryRule() {
		return getComponentCategoryAccess().getRule();
	}

	//ConnectionKind returns instance::ConnectionKind:
	//	"featureConnection" | "accessConnection" | "parameterConnection" | "portConnection" | "featureGroupConnection";
	public ConnectionKindElements getConnectionKindAccess() {
		return pConnectionKind;
	}
	
	public ParserRule getConnectionKindRule() {
		return getConnectionKindAccess().getRule();
	}

	//ClassifierRef:
	//	(ID "::")+ ID ("." ID)?;
	public ClassifierRefElements getClassifierRefAccess() {
		return pClassifierRef;
	}
	
	public ParserRule getClassifierRefRule() {
		return getClassifierRefAccess().getRule();
	}

	//ImplRef:
	//	(ID "::")+ ID "." ID;
	public ImplRefElements getImplRefAccess() {
		return pImplRef;
	}
	
	public ParserRule getImplRefRule() {
		return getImplRefAccess().getRule();
	}

	//DeclarativeRef:
	//	(ID "::")+ ID ("." ID)? ":" ("transition" "#" INTEGER_LIT | ID);
	public DeclarativeRefElements getDeclarativeRefAccess() {
		return pDeclarativeRef;
	}
	
	public ParserRule getDeclarativeRefRule() {
		return getDeclarativeRefAccess().getRule();
	}

	//InstanceRef:
	//	"parent" | (ID ("[" INTEGER_LIT "]")* ".")* ("connection" "#" INTEGER_LIT | ID ("[" INTEGER_LIT "]")*);
	public InstanceRefElements getInstanceRefAccess() {
		return pInstanceRef;
	}
	
	public ParserRule getInstanceRefRule() {
		return getInstanceRefAccess().getRule();
	}

	//SomRef:
	//	"som" "#" INTEGER_LIT;
	public SomRefElements getSomRefAccess() {
		return pSomRef;
	}
	
	public ParserRule getSomRefRule() {
		return getSomRefAccess().getRule();
	}

	//TransitionRef:
	//	"transition" "#" INTEGER_LIT;
	public TransitionRefElements getTransitionRefAccess() {
		return pTransitionRef;
	}
	
	public ParserRule getTransitionRefRule() {
		return getTransitionRefAccess().getRule();
	}

	//ModeTransitionName:
	//	ID "." ID "." ID;
	public ModeTransitionNameElements getModeTransitionNameAccess() {
		return pModeTransitionName;
	}
	
	public ParserRule getModeTransitionNameRule() {
		return getModeTransitionNameAccess().getRule();
	}

	//PropertyAssociationRef:
	//	(ID "::")+ ID ("." ID)? ":" ((ID | "transition" "#" INTEGER_LIT) ":")? "property" "#" INTEGER_LIT;
	public PropertyAssociationRefElements getPropertyAssociationRefAccess() {
		return pPropertyAssociationRef;
	}
	
	public ParserRule getPropertyAssociationRefRule() {
		return getPropertyAssociationRefAccess().getRule();
	}

	//Long returns ecore::ELong:
	//	INTEGER_LIT;
	public LongElements getLongAccess() {
		return pLong;
	}
	
	public ParserRule getLongRule() {
		return getLongAccess().getRule();
	}

	//PModel returns aadl2::Element: //| BasicPropertyAssociation | PropertyAssociation
	//	ContainedPropertyAssociation;
	public PropertiesGrammarAccess.PModelElements getPModelAccess() {
		return gaProperties.getPModelAccess();
	}
	
	public ParserRule getPModelRule() {
		return getPModelAccess().getRule();
	}

	//// Properties
	//ContainedPropertyAssociation returns aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF] ("=>" | append?="+=>") constant?="constant"? (ownedValue+=OptionalModalPropertyValue
	//	("," ownedValue+=OptionalModalPropertyValue)*) ("applies" "to" appliesTo+=ContainmentPath (","
	//	appliesTo+=ContainmentPath)*)? ("in" "binding" "(" inBinding+=[aadl2::Classifier|QCREF] ")")? ";";
	public PropertiesGrammarAccess.ContainedPropertyAssociationElements getContainedPropertyAssociationAccess() {
		return gaProperties.getContainedPropertyAssociationAccess();
	}
	
	public ParserRule getContainedPropertyAssociationRule() {
		return getContainedPropertyAssociationAccess().getRule();
	}

	//PropertyAssociation returns aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF] ("=>" | append?="+=>") constant?="constant"? (ownedValue+=OptionalModalPropertyValue
	//	("," ownedValue+=OptionalModalPropertyValue)*) ("in" "binding" "(" inBinding+=[aadl2::Classifier|QCREF] ")")? ";";
	public PropertiesGrammarAccess.PropertyAssociationElements getPropertyAssociationAccess() {
		return gaProperties.getPropertyAssociationAccess();
	}
	
	public ParserRule getPropertyAssociationRule() {
		return getPropertyAssociationAccess().getRule();
	}

	//BasicPropertyAssociation returns aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF] "=>" ownedValue+=PropertyValue ";";
	public PropertiesGrammarAccess.BasicPropertyAssociationElements getBasicPropertyAssociationAccess() {
		return gaProperties.getBasicPropertyAssociationAccess();
	}
	
	public ParserRule getBasicPropertyAssociationRule() {
		return getBasicPropertyAssociationAccess().getRule();
	}

	////	( 'annex' containmentPathElement+=AnnexPath )?
	//ContainmentPath returns aadl2::ContainedNamedElement:
	//	path=ContainmentPathElement;
	public PropertiesGrammarAccess.ContainmentPathElements getContainmentPathAccess() {
		return gaProperties.getContainmentPathAccess();
	}
	
	public ParserRule getContainmentPathRule() {
		return getContainmentPathAccess().getRule();
	}

	////AnnexPath returns aadl2::ContainmentPathElement:
	////	 namedElement=[aadl2::NamedElement|IDANNEXTEXT];
	//ModalPropertyValue returns aadl2::ModalPropertyValue:
	//	ownedValue=PropertyExpression "in" "modes" "(" inMode+=[aadl2::Mode] ("," inMode+=[aadl2::Mode])* ")";
	public PropertiesGrammarAccess.ModalPropertyValueElements getModalPropertyValueAccess() {
		return gaProperties.getModalPropertyValueAccess();
	}
	
	public ParserRule getModalPropertyValueRule() {
		return getModalPropertyValueAccess().getRule();
	}

	//// &&&&&&&&&& handling of in binding
	//PropertyValue returns aadl2::ModalPropertyValue:
	//	ownedValue=PropertyExpression;
	public PropertiesGrammarAccess.PropertyValueElements getPropertyValueAccess() {
		return gaProperties.getPropertyValueAccess();
	}
	
	public ParserRule getPropertyValueRule() {
		return getPropertyValueAccess().getRule();
	}

	//LiteralorReferenceTerm returns aadl2::NamedValue:
	//	namedValue=[aadl2::AbstractNamedValue|QPREF];
	public PropertiesGrammarAccess.LiteralorReferenceTermElements getLiteralorReferenceTermAccess() {
		return gaProperties.getLiteralorReferenceTermAccess();
	}
	
	public ParserRule getLiteralorReferenceTermRule() {
		return getLiteralorReferenceTermAccess().getRule();
	}

	//BooleanLiteral returns aadl2::BooleanLiteral:
	//	{aadl2::BooleanLiteral} (value?="true" | "false");
	public PropertiesGrammarAccess.BooleanLiteralElements getBooleanLiteralAccess() {
		return gaProperties.getBooleanLiteralAccess();
	}
	
	public ParserRule getBooleanLiteralRule() {
		return getBooleanLiteralAccess().getRule();
	}

	//ConstantValue returns aadl2::NamedValue:
	//	namedValue=[aadl2::PropertyConstant|QPREF];
	public PropertiesGrammarAccess.ConstantValueElements getConstantValueAccess() {
		return gaProperties.getConstantValueAccess();
	}
	
	public ParserRule getConstantValueRule() {
		return getConstantValueAccess().getRule();
	}

	//ReferenceTerm returns aadl2::ReferenceValue:
	//	"reference" "(" path=ContainmentPathElement //	( 'annex' ID '{**' 
	//	//	containmentPathElement+=ContainmentPathElement
	//	//	( '.' containmentPathElement+=ContainmentPathElement)*
	//	//	'**}')?
	//	")";
	public PropertiesGrammarAccess.ReferenceTermElements getReferenceTermAccess() {
		return gaProperties.getReferenceTermAccess();
	}
	
	public ParserRule getReferenceTermRule() {
		return getReferenceTermAccess().getRule();
	}

	//RecordTerm returns aadl2::RecordValue:
	//	"[" ownedFieldValue+=FieldPropertyAssociation+ "]";
	public PropertiesGrammarAccess.RecordTermElements getRecordTermAccess() {
		return gaProperties.getRecordTermAccess();
	}
	
	public ParserRule getRecordTermRule() {
		return getRecordTermAccess().getRule();
	}

	//OldRecordTerm returns aadl2::RecordValue:
	//	"(" ownedFieldValue+=FieldPropertyAssociation+ ")";
	public PropertiesGrammarAccess.OldRecordTermElements getOldRecordTermAccess() {
		return gaProperties.getOldRecordTermAccess();
	}
	
	public ParserRule getOldRecordTermRule() {
		return getOldRecordTermAccess().getRule();
	}

	//ComputedTerm returns aadl2::ComputedValue:
	//	"compute" "(" function=ID ")";
	public PropertiesGrammarAccess.ComputedTermElements getComputedTermAccess() {
		return gaProperties.getComputedTermAccess();
	}
	
	public ParserRule getComputedTermRule() {
		return getComputedTermAccess().getRule();
	}

	//ComponentClassifierTerm returns aadl2::ClassifierValue:
	//	"classifier" "(" classifier=[aadl2::ComponentClassifier|QCREF] ")";
	public PropertiesGrammarAccess.ComponentClassifierTermElements getComponentClassifierTermAccess() {
		return gaProperties.getComponentClassifierTermAccess();
	}
	
	public ParserRule getComponentClassifierTermRule() {
		return getComponentClassifierTermAccess().getRule();
	}

	//ListTerm returns aadl2::ListValue:
	//	{aadl2::ListValue} "(" (ownedListElement+=PropertyExpression ("," ownedListElement+=PropertyExpression)*)? ")";
	public PropertiesGrammarAccess.ListTermElements getListTermAccess() {
		return gaProperties.getListTermAccess();
	}
	
	public ParserRule getListTermRule() {
		return getListTermAccess().getRule();
	}

	//FieldPropertyAssociation returns aadl2::BasicPropertyAssociation:
	//	property=[aadl2::BasicProperty] "=>" ownedValue=PropertyExpression ";";
	public PropertiesGrammarAccess.FieldPropertyAssociationElements getFieldPropertyAssociationAccess() {
		return gaProperties.getFieldPropertyAssociationAccess();
	}
	
	public ParserRule getFieldPropertyAssociationRule() {
		return getFieldPropertyAssociationAccess().getRule();
	}

	//ANNEXREF: // check what values are ok inside ** **
	//	"{" STAR STAR ID STAR STAR "}";
	public PropertiesGrammarAccess.ANNEXREFElements getANNEXREFAccess() {
		return gaProperties.getANNEXREFAccess();
	}
	
	public ParserRule getANNEXREFRule() {
		return getANNEXREFAccess().getRule();
	}

	//PlusMinus returns aadl2::OperationKind:
	//	"+" | "-";
	public PropertiesGrammarAccess.PlusMinusElements getPlusMinusAccess() {
		return gaProperties.getPlusMinusAccess();
	}
	
	public ParserRule getPlusMinusRule() {
		return getPlusMinusAccess().getRule();
	}

	//StringTerm returns aadl2::StringLiteral:
	//	value=NoQuoteString;
	public PropertiesGrammarAccess.StringTermElements getStringTermAccess() {
		return gaProperties.getStringTermAccess();
	}
	
	public ParserRule getStringTermRule() {
		return getStringTermAccess().getRule();
	}

	//NoQuoteString: // remove quotes from string in ValueConverter
	//	STRING;
	public PropertiesGrammarAccess.NoQuoteStringElements getNoQuoteStringAccess() {
		return gaProperties.getNoQuoteStringAccess();
	}
	
	public ParserRule getNoQuoteStringRule() {
		return getNoQuoteStringAccess().getRule();
	}

	//ArrayRange returns aadl2::ArrayRange:
	//	{aadl2::ArrayRange} "[" lowerBound=INTVALUE (".." upperBound=INTVALUE)? "]";
	public PropertiesGrammarAccess.ArrayRangeElements getArrayRangeAccess() {
		return gaProperties.getArrayRangeAccess();
	}
	
	public ParserRule getArrayRangeRule() {
		return getArrayRangeAccess().getRule();
	}

	//SignedConstant returns aadl2::Operation:
	//	op=PlusMinus ownedPropertyExpression+=ConstantValue;
	public PropertiesGrammarAccess.SignedConstantElements getSignedConstantAccess() {
		return gaProperties.getSignedConstantAccess();
	}
	
	public ParserRule getSignedConstantRule() {
		return getSignedConstantAccess().getRule();
	}

	//IntegerTerm returns aadl2::IntegerLiteral:
	//	value=SignedInt unit=[aadl2::UnitLiteral]?;
	public PropertiesGrammarAccess.IntegerTermElements getIntegerTermAccess() {
		return gaProperties.getIntegerTermAccess();
	}
	
	public ParserRule getIntegerTermRule() {
		return getIntegerTermAccess().getRule();
	}

	//SignedInt returns aadl2::Integer:
	//	("+" | "-")? INTEGER_LIT;
	public PropertiesGrammarAccess.SignedIntElements getSignedIntAccess() {
		return gaProperties.getSignedIntAccess();
	}
	
	public ParserRule getSignedIntRule() {
		return getSignedIntAccess().getRule();
	}

	//RealTerm returns aadl2::RealLiteral:
	//	value=SignedReal unit=[aadl2::UnitLiteral]?;
	public PropertiesGrammarAccess.RealTermElements getRealTermAccess() {
		return gaProperties.getRealTermAccess();
	}
	
	public ParserRule getRealTermRule() {
		return getRealTermAccess().getRule();
	}

	//SignedReal returns aadl2::Real:
	//	("+" | "-")? REAL_LIT;
	public PropertiesGrammarAccess.SignedRealElements getSignedRealAccess() {
		return gaProperties.getSignedRealAccess();
	}
	
	public ParserRule getSignedRealRule() {
		return getSignedRealAccess().getRule();
	}

	//NumericRangeTerm returns aadl2::RangeValue:
	//	minimum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
	//	NumAlt ".." maximum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//	NumAlt ("delta" delta= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//	NumAlt)?;
	public PropertiesGrammarAccess.NumericRangeTermElements getNumericRangeTermAccess() {
		return gaProperties.getNumericRangeTermAccess();
	}
	
	public ParserRule getNumericRangeTermRule() {
		return getNumericRangeTermAccess().getRule();
	}

	//NumAlt returns aadl2::PropertyExpression:
	//	RealTerm | IntegerTerm | SignedConstant | ConstantValue;
	public PropertiesGrammarAccess.NumAltElements getNumAltAccess() {
		return gaProperties.getNumAltAccess();
	}
	
	public ParserRule getNumAltRule() {
		return getNumAltAccess().getRule();
	}

	//terminal SL_COMMENT:
	//	"--" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaProperties.getSL_COMMENTRule();
	} 

	//INTVALUE returns aadl2::Integer: //NUMERAL 	
	//	INTEGER_LIT;
	public PropertiesGrammarAccess.INTVALUEElements getINTVALUEAccess() {
		return gaProperties.getINTVALUEAccess();
	}
	
	public ParserRule getINTVALUERule() {
		return getINTVALUEAccess().getRule();
	}

	////terminal NUMERAL:
	////	(DIGIT)+('_' (DIGIT)+)*
	////;
	////terminal INT returns ecore::EInt: (DIGIT)+('_' (DIGIT)+)*;
	//terminal fragment EXPONENT:
	//	("e" | "E") ("+" | "-")? DIGIT+;
	public TerminalRule getEXPONENTRule() {
		return gaProperties.getEXPONENTRule();
	} 

	//terminal fragment INT_EXPONENT:
	//	("e" | "E") "+"? DIGIT+;
	public TerminalRule getINT_EXPONENTRule() {
		return gaProperties.getINT_EXPONENTRule();
	} 

	//terminal REAL_LIT:
	//	DIGIT+ ("_" DIGIT+)* ("." DIGIT+ ("_" DIGIT+)* EXPONENT?);
	public TerminalRule getREAL_LITRule() {
		return gaProperties.getREAL_LITRule();
	} 

	//terminal INTEGER_LIT:
	//	DIGIT+ ("_" DIGIT+)* ("#" BASED_INTEGER "#" INT_EXPONENT? | INT_EXPONENT?);
	public TerminalRule getINTEGER_LITRule() {
		return gaProperties.getINTEGER_LITRule();
	} 

	//terminal fragment DIGIT:
	//	"0".."9";
	public TerminalRule getDIGITRule() {
		return gaProperties.getDIGITRule();
	} 

	//terminal fragment EXTENDED_DIGIT:
	//	"0".."9" | "a".."f" | "A".."F";
	public TerminalRule getEXTENDED_DIGITRule() {
		return gaProperties.getEXTENDED_DIGITRule();
	} 

	//terminal fragment BASED_INTEGER:
	//	EXTENDED_DIGIT ("_"? EXTENDED_DIGIT)*;
	public TerminalRule getBASED_INTEGERRule() {
		return gaProperties.getBASED_INTEGERRule();
	} 

	//QCLREF:
	//	ID "::" ID;
	public PropertiesGrammarAccess.QCLREFElements getQCLREFAccess() {
		return gaProperties.getQCLREFAccess();
	}
	
	public ParserRule getQCLREFRule() {
		return getQCLREFAccess().getRule();
	}

	//QPREF:
	//	ID ("::" ID)?;
	public PropertiesGrammarAccess.QPREFElements getQPREFAccess() {
		return gaProperties.getQPREFAccess();
	}
	
	public ParserRule getQPREFRule() {
		return getQPREFAccess().getRule();
	}

	//QCREF:
	//	(ID "::")* ID ("." ID)?;
	public PropertiesGrammarAccess.QCREFElements getQCREFAccess() {
		return gaProperties.getQCREFAccess();
	}
	
	public ParserRule getQCREFRule() {
		return getQCREFAccess().getRule();
	}

	//STAR:
	//	"*";
	public PropertiesGrammarAccess.STARElements getSTARAccess() {
		return gaProperties.getSTARAccess();
	}
	
	public ParserRule getSTARRule() {
		return getSTARAccess().getRule();
	}

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaProperties.getSTRINGRule();
	} 

	////terminal ID  		: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	//terminal ID:
	//	("a".."z" | "A".."Z") ("_"? ("a".."z" | "A".."Z" | "0".."9"))*;
	public TerminalRule getIDRule() {
		return gaProperties.getIDRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaProperties.getWSRule();
	} 
}
