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
package org.osate.xtext.aadl2.errormodel.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;
import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess;

@Singleton
public class ErrorModelGrammarAccess extends AbstractGrammarElementFinder {
	
	public class EMV2RootElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2Root");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEMV2RootAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cLibraryAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cLibraryEMV2LibraryParserRuleCall_1_0_0 = (RuleCall)cLibraryAssignment_1_0.eContents().get(0);
		private final Assignment cSubclausesAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cSubclausesEMV2SubclauseParserRuleCall_1_1_0 = (RuleCall)cSubclausesAssignment_1_1.eContents().get(0);
		
		///*
		// * Note about symbolic labels as values for occurrence probability:
		// * Use property constant. The core allows it instead of an actual number.
		// * The tools generating stochastic models from such specification can interpret the constant name as the desired label.
		// */ // allow either of the two to be the root. Needed dummy 'library' keyword
		//EMV2Root aadl2::NamedElement:
		//	{EMV2Root} (library=EMV2Library | subclauses+=EMV2Subclause*);
		@Override public ParserRule getRule() { return rule; }
		
		//{EMV2Root} (library=EMV2Library | subclauses+=EMV2Subclause*)
		public Group getGroup() { return cGroup; }
		
		//{EMV2Root}
		public Action getEMV2RootAction_0() { return cEMV2RootAction_0; }
		
		//(library=EMV2Library | subclauses+=EMV2Subclause*)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//library=EMV2Library
		public Assignment getLibraryAssignment_1_0() { return cLibraryAssignment_1_0; }
		
		//EMV2Library
		public RuleCall getLibraryEMV2LibraryParserRuleCall_1_0_0() { return cLibraryEMV2LibraryParserRuleCall_1_0_0; }
		
		//subclauses+=EMV2Subclause*
		public Assignment getSubclausesAssignment_1_1() { return cSubclausesAssignment_1_1; }
		
		//EMV2Subclause
		public RuleCall getSubclausesEMV2SubclauseParserRuleCall_1_1_0() { return cSubclausesEMV2SubclauseParserRuleCall_1_1_0; }
	}
	public class AnnexLibraryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.AnnexLibrary");
		private final RuleCall cErrorModelLibraryParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//AnnexLibrary aadl2::AnnexLibrary:
		//	ErrorModelLibrary;
		@Override public ParserRule getRule() { return rule; }
		
		//ErrorModelLibrary
		public RuleCall getErrorModelLibraryParserRuleCall() { return cErrorModelLibraryParserRuleCall; }
	}
	public class AnnexSubclauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.AnnexSubclause");
		private final RuleCall cErrorModelSubclauseParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//AnnexSubclause aadl2::AnnexSubclause:
		//	ErrorModelSubclause;
		@Override public ParserRule getRule() { return rule; }
		
		//ErrorModelSubclause
		public RuleCall getErrorModelSubclauseParserRuleCall() { return cErrorModelSubclauseParserRuleCall; }
	}
	public class NamedElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.NamedElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cErrorModelLibraryParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cErrorTypesParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cErrorBehaviorEventParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cErrorBehaviorStateParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cErrorBehaviorTransitionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cErrorFlowParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cErrorPropagationParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cOutgoingPropagationConditionParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cPropagationPathParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		private final RuleCall cPropagationPointParserRuleCall_9 = (RuleCall)cAlternatives.eContents().get(9);
		private final RuleCall cCompositeStateParserRuleCall_10 = (RuleCall)cAlternatives.eContents().get(10);
		private final RuleCall cTypeTransformationSetParserRuleCall_11 = (RuleCall)cAlternatives.eContents().get(11);
		private final RuleCall cTypeMappingSetParserRuleCall_12 = (RuleCall)cAlternatives.eContents().get(12);
		private final RuleCall cErrorBehaviorStateMachineParserRuleCall_13 = (RuleCall)cAlternatives.eContents().get(13);
		private final RuleCall cErrorDetectionParserRuleCall_14 = (RuleCall)cAlternatives.eContents().get(14);
		private final RuleCall cEventOrPropagationParserRuleCall_15 = (RuleCall)cAlternatives.eContents().get(15);
		
		//NamedElement aadl2::NamedElement:
		//	ErrorModelLibrary | ErrorTypes | ErrorBehaviorEvent | ErrorBehaviorState | ErrorBehaviorTransition
		//	| ErrorFlow | ErrorPropagation | OutgoingPropagationCondition
		//	| PropagationPath | PropagationPoint | CompositeState
		//	| TypeTransformationSet | TypeMappingSet | ErrorBehaviorStateMachine
		//	| ErrorDetection | EventOrPropagation;
		@Override public ParserRule getRule() { return rule; }
		
		//ErrorModelLibrary | ErrorTypes | ErrorBehaviorEvent | ErrorBehaviorState | ErrorBehaviorTransition | ErrorFlow |
		//ErrorPropagation | OutgoingPropagationCondition | PropagationPath | PropagationPoint | CompositeState |
		//TypeTransformationSet | TypeMappingSet | ErrorBehaviorStateMachine | ErrorDetection | EventOrPropagation
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ErrorModelLibrary
		public RuleCall getErrorModelLibraryParserRuleCall_0() { return cErrorModelLibraryParserRuleCall_0; }
		
		//ErrorTypes
		public RuleCall getErrorTypesParserRuleCall_1() { return cErrorTypesParserRuleCall_1; }
		
		//ErrorBehaviorEvent
		public RuleCall getErrorBehaviorEventParserRuleCall_2() { return cErrorBehaviorEventParserRuleCall_2; }
		
		//ErrorBehaviorState
		public RuleCall getErrorBehaviorStateParserRuleCall_3() { return cErrorBehaviorStateParserRuleCall_3; }
		
		//ErrorBehaviorTransition
		public RuleCall getErrorBehaviorTransitionParserRuleCall_4() { return cErrorBehaviorTransitionParserRuleCall_4; }
		
		//ErrorFlow
		public RuleCall getErrorFlowParserRuleCall_5() { return cErrorFlowParserRuleCall_5; }
		
		//ErrorPropagation
		public RuleCall getErrorPropagationParserRuleCall_6() { return cErrorPropagationParserRuleCall_6; }
		
		//OutgoingPropagationCondition
		public RuleCall getOutgoingPropagationConditionParserRuleCall_7() { return cOutgoingPropagationConditionParserRuleCall_7; }
		
		//PropagationPath
		public RuleCall getPropagationPathParserRuleCall_8() { return cPropagationPathParserRuleCall_8; }
		
		//PropagationPoint
		public RuleCall getPropagationPointParserRuleCall_9() { return cPropagationPointParserRuleCall_9; }
		
		//CompositeState
		public RuleCall getCompositeStateParserRuleCall_10() { return cCompositeStateParserRuleCall_10; }
		
		//TypeTransformationSet
		public RuleCall getTypeTransformationSetParserRuleCall_11() { return cTypeTransformationSetParserRuleCall_11; }
		
		//TypeMappingSet
		public RuleCall getTypeMappingSetParserRuleCall_12() { return cTypeMappingSetParserRuleCall_12; }
		
		//ErrorBehaviorStateMachine
		public RuleCall getErrorBehaviorStateMachineParserRuleCall_13() { return cErrorBehaviorStateMachineParserRuleCall_13; }
		
		//ErrorDetection
		public RuleCall getErrorDetectionParserRuleCall_14() { return cErrorDetectionParserRuleCall_14; }
		
		//EventOrPropagation
		public RuleCall getEventOrPropagationParserRuleCall_15() { return cEventOrPropagationParserRuleCall_15; }
	}
	public class ModalElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ModalElement");
		private final RuleCall cErrorModelSubclauseParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//ModalElement aadl2::ModalElement:
		//	ErrorModelSubclause;
		@Override public ParserRule getRule() { return rule; }
		
		//ErrorModelSubclause
		public RuleCall getErrorModelSubclauseParserRuleCall() { return cErrorModelSubclauseParserRuleCall; }
	}
	public class ElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.Element");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTypeSetElementParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTypeTransformationParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cTypeMappingParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cQualifiedPropagationPointParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cTransitionBranchParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cBranchValueParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cErrorCodeValueParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cConditionElementParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cAndExpressionParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		private final RuleCall cConditionTermParserRuleCall_9 = (RuleCall)cAlternatives.eContents().get(9);
		private final RuleCall cConditionExpressionParserRuleCall_10 = (RuleCall)cAlternatives.eContents().get(10);
		private final RuleCall cOrmoreExpressionParserRuleCall_11 = (RuleCall)cAlternatives.eContents().get(11);
		private final RuleCall cOrlessExpressionParserRuleCall_12 = (RuleCall)cAlternatives.eContents().get(12);
		private final RuleCall cErrorStateToModeMappingParserRuleCall_13 = (RuleCall)cAlternatives.eContents().get(13);
		private final RuleCall cQualifiedErrorBehaviorStateParserRuleCall_14 = (RuleCall)cAlternatives.eContents().get(14);
		private final RuleCall cSubcomponentElementParserRuleCall_15 = (RuleCall)cAlternatives.eContents().get(15);
		private final RuleCall cFeatureorPPReferenceParserRuleCall_16 = (RuleCall)cAlternatives.eContents().get(16);
		private final RuleCall cEMV2PropertyAssociationParserRuleCall_17 = (RuleCall)cAlternatives.eContents().get(17);
		private final RuleCall cEMV2PathParserRuleCall_18 = (RuleCall)cAlternatives.eContents().get(18);
		private final RuleCall cEMV2PathElementParserRuleCall_19 = (RuleCall)cAlternatives.eContents().get(19);
		
		//Element aadl2::Element:
		//	TypeSetElement
		//	| TypeTransformation | TypeMapping
		//	| QualifiedPropagationPoint | TransitionBranch | BranchValue | ErrorCodeValue
		//	| ConditionElement | AndExpression | ConditionTerm
		//	| ConditionExpression | OrmoreExpression | OrlessExpression
		//	| ErrorStateToModeMapping | QualifiedErrorBehaviorState
		//	| SubcomponentElement | FeatureorPPReference | EMV2PropertyAssociation | EMV2Path | EMV2PathElement;
		@Override public ParserRule getRule() { return rule; }
		
		//TypeSetElement | TypeTransformation | TypeMapping | QualifiedPropagationPoint | TransitionBranch | BranchValue |
		//ErrorCodeValue | ConditionElement | AndExpression | ConditionTerm | ConditionExpression | OrmoreExpression |
		//OrlessExpression | ErrorStateToModeMapping | QualifiedErrorBehaviorState | SubcomponentElement | FeatureorPPReference |
		//EMV2PropertyAssociation | EMV2Path | EMV2PathElement
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//TypeSetElement
		public RuleCall getTypeSetElementParserRuleCall_0() { return cTypeSetElementParserRuleCall_0; }
		
		//TypeTransformation
		public RuleCall getTypeTransformationParserRuleCall_1() { return cTypeTransformationParserRuleCall_1; }
		
		//TypeMapping
		public RuleCall getTypeMappingParserRuleCall_2() { return cTypeMappingParserRuleCall_2; }
		
		//QualifiedPropagationPoint
		public RuleCall getQualifiedPropagationPointParserRuleCall_3() { return cQualifiedPropagationPointParserRuleCall_3; }
		
		//TransitionBranch
		public RuleCall getTransitionBranchParserRuleCall_4() { return cTransitionBranchParserRuleCall_4; }
		
		//BranchValue
		public RuleCall getBranchValueParserRuleCall_5() { return cBranchValueParserRuleCall_5; }
		
		//ErrorCodeValue
		public RuleCall getErrorCodeValueParserRuleCall_6() { return cErrorCodeValueParserRuleCall_6; }
		
		//ConditionElement
		public RuleCall getConditionElementParserRuleCall_7() { return cConditionElementParserRuleCall_7; }
		
		//AndExpression
		public RuleCall getAndExpressionParserRuleCall_8() { return cAndExpressionParserRuleCall_8; }
		
		//ConditionTerm
		public RuleCall getConditionTermParserRuleCall_9() { return cConditionTermParserRuleCall_9; }
		
		//ConditionExpression
		public RuleCall getConditionExpressionParserRuleCall_10() { return cConditionExpressionParserRuleCall_10; }
		
		//OrmoreExpression
		public RuleCall getOrmoreExpressionParserRuleCall_11() { return cOrmoreExpressionParserRuleCall_11; }
		
		//OrlessExpression
		public RuleCall getOrlessExpressionParserRuleCall_12() { return cOrlessExpressionParserRuleCall_12; }
		
		//ErrorStateToModeMapping
		public RuleCall getErrorStateToModeMappingParserRuleCall_13() { return cErrorStateToModeMappingParserRuleCall_13; }
		
		//QualifiedErrorBehaviorState
		public RuleCall getQualifiedErrorBehaviorStateParserRuleCall_14() { return cQualifiedErrorBehaviorStateParserRuleCall_14; }
		
		//SubcomponentElement
		public RuleCall getSubcomponentElementParserRuleCall_15() { return cSubcomponentElementParserRuleCall_15; }
		
		//FeatureorPPReference
		public RuleCall getFeatureorPPReferenceParserRuleCall_16() { return cFeatureorPPReferenceParserRuleCall_16; }
		
		//EMV2PropertyAssociation
		public RuleCall getEMV2PropertyAssociationParserRuleCall_17() { return cEMV2PropertyAssociationParserRuleCall_17; }
		
		//EMV2Path
		public RuleCall getEMV2PathParserRuleCall_18() { return cEMV2PathParserRuleCall_18; }
		
		//EMV2PathElement
		public RuleCall getEMV2PathElementParserRuleCall_19() { return cEMV2PathElementParserRuleCall_19; }
	}
	public class ErrorModelSubclauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorModelSubclause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cErrorModelSubclauseAction_0 = (Action)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cUseKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cTypesKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cUseTypesAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_1_2_0 = (CrossReference)cUseTypesAssignment_1_2.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_1_2_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_1_2_0.eContents().get(1);
		private final Group cGroup_1_3 = (Group)cGroup_1.eContents().get(3);
		private final Keyword cCommaKeyword_1_3_0 = (Keyword)cGroup_1_3.eContents().get(0);
		private final Assignment cUseTypesAssignment_1_3_1 = (Assignment)cGroup_1_3.eContents().get(1);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_1_3_1_0 = (CrossReference)cUseTypesAssignment_1_3_1.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_1_3_1_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_1_3_1_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_1_4 = (Keyword)cGroup_1.eContents().get(4);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cUseKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Keyword cTypeKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Keyword cEquivalenceKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Assignment cTypeEquivalenceAssignment_2_3 = (Assignment)cGroup_2.eContents().get(3);
		private final CrossReference cTypeEquivalenceTypeMappingSetCrossReference_2_3_0 = (CrossReference)cTypeEquivalenceAssignment_2_3.eContents().get(0);
		private final RuleCall cTypeEquivalenceTypeMappingSetQEMREFParserRuleCall_2_3_0_1 = (RuleCall)cTypeEquivalenceTypeMappingSetCrossReference_2_3_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_2_4 = (Keyword)cGroup_2.eContents().get(4);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cUseKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cMappingsKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Assignment cTypeMappingSetAssignment_3_2 = (Assignment)cGroup_3.eContents().get(2);
		private final CrossReference cTypeMappingSetTypeMappingSetCrossReference_3_2_0 = (CrossReference)cTypeMappingSetAssignment_3_2.eContents().get(0);
		private final RuleCall cTypeMappingSetTypeMappingSetQEMREFParserRuleCall_3_2_0_1 = (RuleCall)cTypeMappingSetTypeMappingSetCrossReference_3_2_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_3_3 = (Keyword)cGroup_3.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cUseKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Keyword cBehaviorKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);
		private final Assignment cUseBehaviorAssignment_4_2 = (Assignment)cGroup_4.eContents().get(2);
		private final CrossReference cUseBehaviorErrorBehaviorStateMachineCrossReference_4_2_0 = (CrossReference)cUseBehaviorAssignment_4_2.eContents().get(0);
		private final RuleCall cUseBehaviorErrorBehaviorStateMachineQEMREFParserRuleCall_4_2_0_1 = (RuleCall)cUseBehaviorErrorBehaviorStateMachineCrossReference_4_2_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cErrorKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cPropagationsKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Assignment cPropagationsAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final RuleCall cPropagationsErrorPropagationParserRuleCall_5_2_0 = (RuleCall)cPropagationsAssignment_5_2.eContents().get(0);
		private final Group cGroup_5_3 = (Group)cGroup_5.eContents().get(3);
		private final Keyword cFlowsKeyword_5_3_0 = (Keyword)cGroup_5_3.eContents().get(0);
		private final Assignment cFlowsAssignment_5_3_1 = (Assignment)cGroup_5_3.eContents().get(1);
		private final RuleCall cFlowsErrorFlowParserRuleCall_5_3_1_0 = (RuleCall)cFlowsAssignment_5_3_1.eContents().get(0);
		private final Keyword cEndKeyword_5_4 = (Keyword)cGroup_5.eContents().get(4);
		private final Keyword cPropagationsKeyword_5_5 = (Keyword)cGroup_5.eContents().get(5);
		private final Keyword cSemicolonKeyword_5_6 = (Keyword)cGroup_5.eContents().get(6);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cComponentKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Keyword cErrorKeyword_6_1 = (Keyword)cGroup_6.eContents().get(1);
		private final Keyword cBehaviorKeyword_6_2 = (Keyword)cGroup_6.eContents().get(2);
		private final Group cGroup_6_3 = (Group)cGroup_6.eContents().get(3);
		private final Keyword cUseKeyword_6_3_0 = (Keyword)cGroup_6_3.eContents().get(0);
		private final Keyword cTransformationsKeyword_6_3_1 = (Keyword)cGroup_6_3.eContents().get(1);
		private final Assignment cUseTransformationAssignment_6_3_2 = (Assignment)cGroup_6_3.eContents().get(2);
		private final CrossReference cUseTransformationTypeTransformationSetCrossReference_6_3_2_0 = (CrossReference)cUseTransformationAssignment_6_3_2.eContents().get(0);
		private final RuleCall cUseTransformationTypeTransformationSetQEMREFParserRuleCall_6_3_2_0_1 = (RuleCall)cUseTransformationTypeTransformationSetCrossReference_6_3_2_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_6_3_3 = (Keyword)cGroup_6_3.eContents().get(3);
		private final Group cGroup_6_4 = (Group)cGroup_6.eContents().get(4);
		private final Keyword cEventsKeyword_6_4_0 = (Keyword)cGroup_6_4.eContents().get(0);
		private final Assignment cEventsAssignment_6_4_1 = (Assignment)cGroup_6_4.eContents().get(1);
		private final RuleCall cEventsErrorBehaviorEventParserRuleCall_6_4_1_0 = (RuleCall)cEventsAssignment_6_4_1.eContents().get(0);
		private final Group cGroup_6_5 = (Group)cGroup_6.eContents().get(5);
		private final Keyword cTransitionsKeyword_6_5_0 = (Keyword)cGroup_6_5.eContents().get(0);
		private final Assignment cTransitionsAssignment_6_5_1 = (Assignment)cGroup_6_5.eContents().get(1);
		private final RuleCall cTransitionsErrorBehaviorTransitionParserRuleCall_6_5_1_0 = (RuleCall)cTransitionsAssignment_6_5_1.eContents().get(0);
		private final Group cGroup_6_6 = (Group)cGroup_6.eContents().get(6);
		private final Keyword cPropagationsKeyword_6_6_0 = (Keyword)cGroup_6_6.eContents().get(0);
		private final Assignment cOutgoingPropagationConditionsAssignment_6_6_1 = (Assignment)cGroup_6_6.eContents().get(1);
		private final RuleCall cOutgoingPropagationConditionsOutgoingPropagationConditionParserRuleCall_6_6_1_0 = (RuleCall)cOutgoingPropagationConditionsAssignment_6_6_1.eContents().get(0);
		private final Group cGroup_6_7 = (Group)cGroup_6.eContents().get(7);
		private final Keyword cDetectionsKeyword_6_7_0 = (Keyword)cGroup_6_7.eContents().get(0);
		private final Assignment cErrorDetectionsAssignment_6_7_1 = (Assignment)cGroup_6_7.eContents().get(1);
		private final RuleCall cErrorDetectionsErrorDetectionParserRuleCall_6_7_1_0 = (RuleCall)cErrorDetectionsAssignment_6_7_1.eContents().get(0);
		private final Group cGroup_6_8 = (Group)cGroup_6.eContents().get(8);
		private final Keyword cModeKeyword_6_8_0 = (Keyword)cGroup_6_8.eContents().get(0);
		private final Keyword cMappingsKeyword_6_8_1 = (Keyword)cGroup_6_8.eContents().get(1);
		private final Assignment cErrorStateToModeMappingsAssignment_6_8_2 = (Assignment)cGroup_6_8.eContents().get(2);
		private final RuleCall cErrorStateToModeMappingsErrorStateToModeMappingParserRuleCall_6_8_2_0 = (RuleCall)cErrorStateToModeMappingsAssignment_6_8_2.eContents().get(0);
		private final Keyword cEndKeyword_6_9 = (Keyword)cGroup_6.eContents().get(9);
		private final Keyword cComponentKeyword_6_10 = (Keyword)cGroup_6.eContents().get(10);
		private final Keyword cSemicolonKeyword_6_11 = (Keyword)cGroup_6.eContents().get(11);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cCompositeKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Keyword cErrorKeyword_7_1 = (Keyword)cGroup_7.eContents().get(1);
		private final Keyword cBehaviorKeyword_7_2 = (Keyword)cGroup_7.eContents().get(2);
		private final Group cGroup_7_3 = (Group)cGroup_7.eContents().get(3);
		private final Keyword cStatesKeyword_7_3_0 = (Keyword)cGroup_7_3.eContents().get(0);
		private final Assignment cStatesAssignment_7_3_1 = (Assignment)cGroup_7_3.eContents().get(1);
		private final RuleCall cStatesCompositeStateParserRuleCall_7_3_1_0 = (RuleCall)cStatesAssignment_7_3_1.eContents().get(0);
		private final Keyword cEndKeyword_7_4 = (Keyword)cGroup_7.eContents().get(4);
		private final Keyword cCompositeKeyword_7_5 = (Keyword)cGroup_7.eContents().get(5);
		private final Keyword cSemicolonKeyword_7_6 = (Keyword)cGroup_7.eContents().get(6);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cConnectionKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cErrorKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Group cGroup_8_2 = (Group)cGroup_8.eContents().get(2);
		private final Keyword cUseKeyword_8_2_0 = (Keyword)cGroup_8_2.eContents().get(0);
		private final Keyword cTransformationsKeyword_8_2_1 = (Keyword)cGroup_8_2.eContents().get(1);
		private final Assignment cTypeTransformationSetAssignment_8_2_2 = (Assignment)cGroup_8_2.eContents().get(2);
		private final CrossReference cTypeTransformationSetTypeTransformationSetCrossReference_8_2_2_0 = (CrossReference)cTypeTransformationSetAssignment_8_2_2.eContents().get(0);
		private final RuleCall cTypeTransformationSetTypeTransformationSetQEMREFParserRuleCall_8_2_2_0_1 = (RuleCall)cTypeTransformationSetTypeTransformationSetCrossReference_8_2_2_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_8_2_3 = (Keyword)cGroup_8_2.eContents().get(3);
		private final Assignment cConnectionErrorSourcesAssignment_8_3 = (Assignment)cGroup_8.eContents().get(3);
		private final RuleCall cConnectionErrorSourcesErrorSourceParserRuleCall_8_3_0 = (RuleCall)cConnectionErrorSourcesAssignment_8_3.eContents().get(0);
		private final Keyword cEndKeyword_8_4 = (Keyword)cGroup_8.eContents().get(4);
		private final Keyword cConnectionKeyword_8_5 = (Keyword)cGroup_8.eContents().get(5);
		private final Keyword cSemicolonKeyword_8_6 = (Keyword)cGroup_8.eContents().get(6);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cPropagationKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Keyword cPathsKeyword_9_1 = (Keyword)cGroup_9.eContents().get(1);
		private final Assignment cPointsAssignment_9_2 = (Assignment)cGroup_9.eContents().get(2);
		private final RuleCall cPointsPropagationPointParserRuleCall_9_2_0 = (RuleCall)cPointsAssignment_9_2.eContents().get(0);
		private final Assignment cPathsAssignment_9_3 = (Assignment)cGroup_9.eContents().get(3);
		private final RuleCall cPathsPropagationPathParserRuleCall_9_3_0 = (RuleCall)cPathsAssignment_9_3.eContents().get(0);
		private final Keyword cEndKeyword_9_4 = (Keyword)cGroup_9.eContents().get(4);
		private final Keyword cPathsKeyword_9_5 = (Keyword)cGroup_9.eContents().get(5);
		private final Keyword cSemicolonKeyword_9_6 = (Keyword)cGroup_9.eContents().get(6);
		private final Group cGroup_10 = (Group)cGroup.eContents().get(10);
		private final Keyword cPropertiesKeyword_10_0 = (Keyword)cGroup_10.eContents().get(0);
		private final Assignment cPropertiesAssignment_10_1 = (Assignment)cGroup_10.eContents().get(1);
		private final RuleCall cPropertiesEMV2PropertyAssociationParserRuleCall_10_1_0 = (RuleCall)cPropertiesAssignment_10_1.eContents().get(0);
		
		//ErrorModelSubclause:
		//	{ErrorModelSubclause} ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])*
		//	';')? ('use' 'type' 'equivalence' typeEquivalence=[TypeMappingSet|QEMREF] ';')? ('use' 'mappings'
		//	typeMappingSet=[TypeMappingSet|QEMREF] ';')? ('use' 'behavior' useBehavior=[ErrorBehaviorStateMachine|QEMREF]
		//	//   	('(' stateTypeBindings+=StateTypeBinding (',' stateTypeBindings+=StateTypeBinding)*')')?
		//	';')? ('error' 'propagations'
		//	propagations+=ErrorPropagation* ('flows'
		//	flows+=ErrorFlow+)?
		//	'end' 'propagations' ';')? ('component' 'error' 'behavior' ('use' 'transformations'
		//	useTransformation=[TypeTransformationSet|QEMREF] ';')? ('events' events+=ErrorBehaviorEvent+)? ('transitions'
		//	transitions+=ErrorBehaviorTransition+)? ('propagations'
		//	outgoingPropagationConditions+=OutgoingPropagationCondition+)? ('detections'
		//	errorDetections+=ErrorDetection+)? ('mode' 'mappings'
		//	errorStateToModeMappings+=ErrorStateToModeMapping+)?
		//	'end' 'component' ';')? ('composite' 'error' 'behavior' ('states'
		//	states+=CompositeState+)?
		//	'end' 'composite' ';')? ('connection' 'error' ('use' 'transformations'
		//	typeTransformationSet=[TypeTransformationSet|QEMREF] ';')?
		//	connectionErrorSources+=ErrorSource*
		//	'end' 'connection' ';')? ('propagation' 'paths'
		//	points+=PropagationPoint*
		//	paths+=PropagationPath*
		//	'end' 'paths' ';')? ('properties'
		//	properties+=EMV2PropertyAssociation+)?
		//	//	'**}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{ErrorModelSubclause} ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])*
		//';')? ('use' 'type' 'equivalence' typeEquivalence=[TypeMappingSet|QEMREF] ';')? ('use' 'mappings'
		//typeMappingSet=[TypeMappingSet|QEMREF] ';')? ('use' 'behavior' useBehavior=[ErrorBehaviorStateMachine|QEMREF] //   	('(' stateTypeBindings+=StateTypeBinding (',' stateTypeBindings+=StateTypeBinding)*')')?
		//';')? ('error' 'propagations' propagations+=ErrorPropagation* ('flows' flows+=ErrorFlow+)? 'end' 'propagations' ';')?
		//('component' 'error' 'behavior' ('use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF] ';')?
		//('events' events+=ErrorBehaviorEvent+)? ('transitions' transitions+=ErrorBehaviorTransition+)? ('propagations'
		//outgoingPropagationConditions+=OutgoingPropagationCondition+)? ('detections' errorDetections+=ErrorDetection+)? ('mode'
		//'mappings' errorStateToModeMappings+=ErrorStateToModeMapping+)? 'end' 'component' ';')? ('composite' 'error' 'behavior'
		//('states' states+=CompositeState+)? 'end' 'composite' ';')? ('connection' 'error' ('use' 'transformations'
		//typeTransformationSet=[TypeTransformationSet|QEMREF] ';')? connectionErrorSources+=ErrorSource* 'end' 'connection'
		//';')? ('propagation' 'paths' points+=PropagationPoint* paths+=PropagationPath* 'end' 'paths' ';')? ('properties'
		//properties+=EMV2PropertyAssociation+)?
		public Group getGroup() { return cGroup; }
		
		//{ErrorModelSubclause}
		public Action getErrorModelSubclauseAction_0() { return cErrorModelSubclauseAction_0; }
		
		//('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		public Group getGroup_1() { return cGroup_1; }
		
		//'use'
		public Keyword getUseKeyword_1_0() { return cUseKeyword_1_0; }
		
		//'types'
		public Keyword getTypesKeyword_1_1() { return cTypesKeyword_1_1; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_1_2() { return cUseTypesAssignment_1_2; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_1_2_0() { return cUseTypesErrorModelLibraryCrossReference_1_2_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_2_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_1_2_0_1; }
		
		//(',' useTypes+=[ErrorModelLibrary|QEMREF])*
		public Group getGroup_1_3() { return cGroup_1_3; }
		
		//','
		public Keyword getCommaKeyword_1_3_0() { return cCommaKeyword_1_3_0; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_1_3_1() { return cUseTypesAssignment_1_3_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_1_3_1_0() { return cUseTypesErrorModelLibraryCrossReference_1_3_1_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_3_1_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_1_3_1_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_1_4() { return cSemicolonKeyword_1_4; }
		
		//('use' 'type' 'equivalence' typeEquivalence=[TypeMappingSet|QEMREF] ';')?
		public Group getGroup_2() { return cGroup_2; }
		
		//'use'
		public Keyword getUseKeyword_2_0() { return cUseKeyword_2_0; }
		
		//'type'
		public Keyword getTypeKeyword_2_1() { return cTypeKeyword_2_1; }
		
		//'equivalence'
		public Keyword getEquivalenceKeyword_2_2() { return cEquivalenceKeyword_2_2; }
		
		//typeEquivalence=[TypeMappingSet|QEMREF]
		public Assignment getTypeEquivalenceAssignment_2_3() { return cTypeEquivalenceAssignment_2_3; }
		
		//[TypeMappingSet|QEMREF]
		public CrossReference getTypeEquivalenceTypeMappingSetCrossReference_2_3_0() { return cTypeEquivalenceTypeMappingSetCrossReference_2_3_0; }
		
		//QEMREF
		public RuleCall getTypeEquivalenceTypeMappingSetQEMREFParserRuleCall_2_3_0_1() { return cTypeEquivalenceTypeMappingSetQEMREFParserRuleCall_2_3_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_2_4() { return cSemicolonKeyword_2_4; }
		
		//('use' 'mappings' typeMappingSet=[TypeMappingSet|QEMREF] ';')?
		public Group getGroup_3() { return cGroup_3; }
		
		//'use'
		public Keyword getUseKeyword_3_0() { return cUseKeyword_3_0; }
		
		//'mappings'
		public Keyword getMappingsKeyword_3_1() { return cMappingsKeyword_3_1; }
		
		//typeMappingSet=[TypeMappingSet|QEMREF]
		public Assignment getTypeMappingSetAssignment_3_2() { return cTypeMappingSetAssignment_3_2; }
		
		//[TypeMappingSet|QEMREF]
		public CrossReference getTypeMappingSetTypeMappingSetCrossReference_3_2_0() { return cTypeMappingSetTypeMappingSetCrossReference_3_2_0; }
		
		//QEMREF
		public RuleCall getTypeMappingSetTypeMappingSetQEMREFParserRuleCall_3_2_0_1() { return cTypeMappingSetTypeMappingSetQEMREFParserRuleCall_3_2_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_3_3() { return cSemicolonKeyword_3_3; }
		
		//('use' 'behavior' useBehavior=[ErrorBehaviorStateMachine|QEMREF] //   	('(' stateTypeBindings+=StateTypeBinding (',' stateTypeBindings+=StateTypeBinding)*')')?
		//';')?
		public Group getGroup_4() { return cGroup_4; }
		
		//'use'
		public Keyword getUseKeyword_4_0() { return cUseKeyword_4_0; }
		
		//'behavior'
		public Keyword getBehaviorKeyword_4_1() { return cBehaviorKeyword_4_1; }
		
		//useBehavior=[ErrorBehaviorStateMachine|QEMREF]
		public Assignment getUseBehaviorAssignment_4_2() { return cUseBehaviorAssignment_4_2; }
		
		//[ErrorBehaviorStateMachine|QEMREF]
		public CrossReference getUseBehaviorErrorBehaviorStateMachineCrossReference_4_2_0() { return cUseBehaviorErrorBehaviorStateMachineCrossReference_4_2_0; }
		
		//QEMREF
		public RuleCall getUseBehaviorErrorBehaviorStateMachineQEMREFParserRuleCall_4_2_0_1() { return cUseBehaviorErrorBehaviorStateMachineQEMREFParserRuleCall_4_2_0_1; }
		
		////   	('(' stateTypeBindings+=StateTypeBinding (',' stateTypeBindings+=StateTypeBinding)*')')?
		//';'
		public Keyword getSemicolonKeyword_4_3() { return cSemicolonKeyword_4_3; }
		
		//('error' 'propagations' propagations+=ErrorPropagation* ('flows' flows+=ErrorFlow+)? 'end' 'propagations' ';')?
		public Group getGroup_5() { return cGroup_5; }
		
		//'error'
		public Keyword getErrorKeyword_5_0() { return cErrorKeyword_5_0; }
		
		//'propagations'
		public Keyword getPropagationsKeyword_5_1() { return cPropagationsKeyword_5_1; }
		
		//propagations+=ErrorPropagation*
		public Assignment getPropagationsAssignment_5_2() { return cPropagationsAssignment_5_2; }
		
		//ErrorPropagation
		public RuleCall getPropagationsErrorPropagationParserRuleCall_5_2_0() { return cPropagationsErrorPropagationParserRuleCall_5_2_0; }
		
		//('flows' flows+=ErrorFlow+)?
		public Group getGroup_5_3() { return cGroup_5_3; }
		
		//'flows'
		public Keyword getFlowsKeyword_5_3_0() { return cFlowsKeyword_5_3_0; }
		
		//flows+=ErrorFlow+
		public Assignment getFlowsAssignment_5_3_1() { return cFlowsAssignment_5_3_1; }
		
		//ErrorFlow
		public RuleCall getFlowsErrorFlowParserRuleCall_5_3_1_0() { return cFlowsErrorFlowParserRuleCall_5_3_1_0; }
		
		//'end'
		public Keyword getEndKeyword_5_4() { return cEndKeyword_5_4; }
		
		//'propagations'
		public Keyword getPropagationsKeyword_5_5() { return cPropagationsKeyword_5_5; }
		
		//';'
		public Keyword getSemicolonKeyword_5_6() { return cSemicolonKeyword_5_6; }
		
		//('component' 'error' 'behavior' ('use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF] ';')?
		//('events' events+=ErrorBehaviorEvent+)? ('transitions' transitions+=ErrorBehaviorTransition+)? ('propagations'
		//outgoingPropagationConditions+=OutgoingPropagationCondition+)? ('detections' errorDetections+=ErrorDetection+)? ('mode'
		//'mappings' errorStateToModeMappings+=ErrorStateToModeMapping+)? 'end' 'component' ';')?
		public Group getGroup_6() { return cGroup_6; }
		
		//'component'
		public Keyword getComponentKeyword_6_0() { return cComponentKeyword_6_0; }
		
		//'error'
		public Keyword getErrorKeyword_6_1() { return cErrorKeyword_6_1; }
		
		//'behavior'
		public Keyword getBehaviorKeyword_6_2() { return cBehaviorKeyword_6_2; }
		
		//('use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF] ';')?
		public Group getGroup_6_3() { return cGroup_6_3; }
		
		//'use'
		public Keyword getUseKeyword_6_3_0() { return cUseKeyword_6_3_0; }
		
		//'transformations'
		public Keyword getTransformationsKeyword_6_3_1() { return cTransformationsKeyword_6_3_1; }
		
		//useTransformation=[TypeTransformationSet|QEMREF]
		public Assignment getUseTransformationAssignment_6_3_2() { return cUseTransformationAssignment_6_3_2; }
		
		//[TypeTransformationSet|QEMREF]
		public CrossReference getUseTransformationTypeTransformationSetCrossReference_6_3_2_0() { return cUseTransformationTypeTransformationSetCrossReference_6_3_2_0; }
		
		//QEMREF
		public RuleCall getUseTransformationTypeTransformationSetQEMREFParserRuleCall_6_3_2_0_1() { return cUseTransformationTypeTransformationSetQEMREFParserRuleCall_6_3_2_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_6_3_3() { return cSemicolonKeyword_6_3_3; }
		
		//('events' events+=ErrorBehaviorEvent+)?
		public Group getGroup_6_4() { return cGroup_6_4; }
		
		//'events'
		public Keyword getEventsKeyword_6_4_0() { return cEventsKeyword_6_4_0; }
		
		//events+=ErrorBehaviorEvent+
		public Assignment getEventsAssignment_6_4_1() { return cEventsAssignment_6_4_1; }
		
		//ErrorBehaviorEvent
		public RuleCall getEventsErrorBehaviorEventParserRuleCall_6_4_1_0() { return cEventsErrorBehaviorEventParserRuleCall_6_4_1_0; }
		
		//('transitions' transitions+=ErrorBehaviorTransition+)?
		public Group getGroup_6_5() { return cGroup_6_5; }
		
		//'transitions'
		public Keyword getTransitionsKeyword_6_5_0() { return cTransitionsKeyword_6_5_0; }
		
		//transitions+=ErrorBehaviorTransition+
		public Assignment getTransitionsAssignment_6_5_1() { return cTransitionsAssignment_6_5_1; }
		
		//ErrorBehaviorTransition
		public RuleCall getTransitionsErrorBehaviorTransitionParserRuleCall_6_5_1_0() { return cTransitionsErrorBehaviorTransitionParserRuleCall_6_5_1_0; }
		
		//('propagations' outgoingPropagationConditions+=OutgoingPropagationCondition+)?
		public Group getGroup_6_6() { return cGroup_6_6; }
		
		//'propagations'
		public Keyword getPropagationsKeyword_6_6_0() { return cPropagationsKeyword_6_6_0; }
		
		//outgoingPropagationConditions+=OutgoingPropagationCondition+
		public Assignment getOutgoingPropagationConditionsAssignment_6_6_1() { return cOutgoingPropagationConditionsAssignment_6_6_1; }
		
		//OutgoingPropagationCondition
		public RuleCall getOutgoingPropagationConditionsOutgoingPropagationConditionParserRuleCall_6_6_1_0() { return cOutgoingPropagationConditionsOutgoingPropagationConditionParserRuleCall_6_6_1_0; }
		
		//('detections' errorDetections+=ErrorDetection+)?
		public Group getGroup_6_7() { return cGroup_6_7; }
		
		//'detections'
		public Keyword getDetectionsKeyword_6_7_0() { return cDetectionsKeyword_6_7_0; }
		
		//errorDetections+=ErrorDetection+
		public Assignment getErrorDetectionsAssignment_6_7_1() { return cErrorDetectionsAssignment_6_7_1; }
		
		//ErrorDetection
		public RuleCall getErrorDetectionsErrorDetectionParserRuleCall_6_7_1_0() { return cErrorDetectionsErrorDetectionParserRuleCall_6_7_1_0; }
		
		//('mode' 'mappings' errorStateToModeMappings+=ErrorStateToModeMapping+)?
		public Group getGroup_6_8() { return cGroup_6_8; }
		
		//'mode'
		public Keyword getModeKeyword_6_8_0() { return cModeKeyword_6_8_0; }
		
		//'mappings'
		public Keyword getMappingsKeyword_6_8_1() { return cMappingsKeyword_6_8_1; }
		
		//errorStateToModeMappings+=ErrorStateToModeMapping+
		public Assignment getErrorStateToModeMappingsAssignment_6_8_2() { return cErrorStateToModeMappingsAssignment_6_8_2; }
		
		//ErrorStateToModeMapping
		public RuleCall getErrorStateToModeMappingsErrorStateToModeMappingParserRuleCall_6_8_2_0() { return cErrorStateToModeMappingsErrorStateToModeMappingParserRuleCall_6_8_2_0; }
		
		//'end'
		public Keyword getEndKeyword_6_9() { return cEndKeyword_6_9; }
		
		//'component'
		public Keyword getComponentKeyword_6_10() { return cComponentKeyword_6_10; }
		
		//';'
		public Keyword getSemicolonKeyword_6_11() { return cSemicolonKeyword_6_11; }
		
		//('composite' 'error' 'behavior' ('states' states+=CompositeState+)? 'end' 'composite' ';')?
		public Group getGroup_7() { return cGroup_7; }
		
		//'composite'
		public Keyword getCompositeKeyword_7_0() { return cCompositeKeyword_7_0; }
		
		//'error'
		public Keyword getErrorKeyword_7_1() { return cErrorKeyword_7_1; }
		
		//'behavior'
		public Keyword getBehaviorKeyword_7_2() { return cBehaviorKeyword_7_2; }
		
		//('states' states+=CompositeState+)?
		public Group getGroup_7_3() { return cGroup_7_3; }
		
		//'states'
		public Keyword getStatesKeyword_7_3_0() { return cStatesKeyword_7_3_0; }
		
		//states+=CompositeState+
		public Assignment getStatesAssignment_7_3_1() { return cStatesAssignment_7_3_1; }
		
		//CompositeState
		public RuleCall getStatesCompositeStateParserRuleCall_7_3_1_0() { return cStatesCompositeStateParserRuleCall_7_3_1_0; }
		
		//'end'
		public Keyword getEndKeyword_7_4() { return cEndKeyword_7_4; }
		
		//'composite'
		public Keyword getCompositeKeyword_7_5() { return cCompositeKeyword_7_5; }
		
		//';'
		public Keyword getSemicolonKeyword_7_6() { return cSemicolonKeyword_7_6; }
		
		//('connection' 'error' ('use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF] ';')?
		//connectionErrorSources+=ErrorSource* 'end' 'connection' ';')?
		public Group getGroup_8() { return cGroup_8; }
		
		//'connection'
		public Keyword getConnectionKeyword_8_0() { return cConnectionKeyword_8_0; }
		
		//'error'
		public Keyword getErrorKeyword_8_1() { return cErrorKeyword_8_1; }
		
		//('use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF] ';')?
		public Group getGroup_8_2() { return cGroup_8_2; }
		
		//'use'
		public Keyword getUseKeyword_8_2_0() { return cUseKeyword_8_2_0; }
		
		//'transformations'
		public Keyword getTransformationsKeyword_8_2_1() { return cTransformationsKeyword_8_2_1; }
		
		//typeTransformationSet=[TypeTransformationSet|QEMREF]
		public Assignment getTypeTransformationSetAssignment_8_2_2() { return cTypeTransformationSetAssignment_8_2_2; }
		
		//[TypeTransformationSet|QEMREF]
		public CrossReference getTypeTransformationSetTypeTransformationSetCrossReference_8_2_2_0() { return cTypeTransformationSetTypeTransformationSetCrossReference_8_2_2_0; }
		
		//QEMREF
		public RuleCall getTypeTransformationSetTypeTransformationSetQEMREFParserRuleCall_8_2_2_0_1() { return cTypeTransformationSetTypeTransformationSetQEMREFParserRuleCall_8_2_2_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_8_2_3() { return cSemicolonKeyword_8_2_3; }
		
		//connectionErrorSources+=ErrorSource*
		public Assignment getConnectionErrorSourcesAssignment_8_3() { return cConnectionErrorSourcesAssignment_8_3; }
		
		//ErrorSource
		public RuleCall getConnectionErrorSourcesErrorSourceParserRuleCall_8_3_0() { return cConnectionErrorSourcesErrorSourceParserRuleCall_8_3_0; }
		
		//'end'
		public Keyword getEndKeyword_8_4() { return cEndKeyword_8_4; }
		
		//'connection'
		public Keyword getConnectionKeyword_8_5() { return cConnectionKeyword_8_5; }
		
		//';'
		public Keyword getSemicolonKeyword_8_6() { return cSemicolonKeyword_8_6; }
		
		//('propagation' 'paths' points+=PropagationPoint* paths+=PropagationPath* 'end' 'paths' ';')?
		public Group getGroup_9() { return cGroup_9; }
		
		//'propagation'
		public Keyword getPropagationKeyword_9_0() { return cPropagationKeyword_9_0; }
		
		//'paths'
		public Keyword getPathsKeyword_9_1() { return cPathsKeyword_9_1; }
		
		//points+=PropagationPoint*
		public Assignment getPointsAssignment_9_2() { return cPointsAssignment_9_2; }
		
		//PropagationPoint
		public RuleCall getPointsPropagationPointParserRuleCall_9_2_0() { return cPointsPropagationPointParserRuleCall_9_2_0; }
		
		//paths+=PropagationPath*
		public Assignment getPathsAssignment_9_3() { return cPathsAssignment_9_3; }
		
		//PropagationPath
		public RuleCall getPathsPropagationPathParserRuleCall_9_3_0() { return cPathsPropagationPathParserRuleCall_9_3_0; }
		
		//'end'
		public Keyword getEndKeyword_9_4() { return cEndKeyword_9_4; }
		
		//'paths'
		public Keyword getPathsKeyword_9_5() { return cPathsKeyword_9_5; }
		
		//';'
		public Keyword getSemicolonKeyword_9_6() { return cSemicolonKeyword_9_6; }
		
		//('properties' properties+=EMV2PropertyAssociation+)?
		public Group getGroup_10() { return cGroup_10; }
		
		//'properties'
		public Keyword getPropertiesKeyword_10_0() { return cPropertiesKeyword_10_0; }
		
		//properties+=EMV2PropertyAssociation+
		public Assignment getPropertiesAssignment_10_1() { return cPropertiesAssignment_10_1; }
		
		//EMV2PropertyAssociation
		public RuleCall getPropertiesEMV2PropertyAssociationParserRuleCall_10_1_0() { return cPropertiesEMV2PropertyAssociationParserRuleCall_10_1_0; }
	}
	public class EMV2SubclauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2Subclause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cErrorModelSubclauseAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cSubclauseKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameQCREFParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cUseKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cTypesKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Assignment cUseTypesAssignment_3_2 = (Assignment)cGroup_3.eContents().get(2);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_3_2_0 = (CrossReference)cUseTypesAssignment_3_2.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_3_2_0.eContents().get(1);
		private final Group cGroup_3_3 = (Group)cGroup_3.eContents().get(3);
		private final Keyword cCommaKeyword_3_3_0 = (Keyword)cGroup_3_3.eContents().get(0);
		private final Assignment cUseTypesAssignment_3_3_1 = (Assignment)cGroup_3_3.eContents().get(1);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_3_3_1_0 = (CrossReference)cUseTypesAssignment_3_3_1.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_3_1_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_3_3_1_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_3_4 = (Keyword)cGroup_3.eContents().get(4);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cUseKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Keyword cTypeKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);
		private final Keyword cEquivalenceKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		private final Assignment cTypeEquivalenceAssignment_4_3 = (Assignment)cGroup_4.eContents().get(3);
		private final CrossReference cTypeEquivalenceTypeMappingSetCrossReference_4_3_0 = (CrossReference)cTypeEquivalenceAssignment_4_3.eContents().get(0);
		private final RuleCall cTypeEquivalenceTypeMappingSetQEMREFParserRuleCall_4_3_0_1 = (RuleCall)cTypeEquivalenceTypeMappingSetCrossReference_4_3_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_4_4 = (Keyword)cGroup_4.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cUseKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cMappingsKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Assignment cTypeMappingSetAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final CrossReference cTypeMappingSetTypeMappingSetCrossReference_5_2_0 = (CrossReference)cTypeMappingSetAssignment_5_2.eContents().get(0);
		private final RuleCall cTypeMappingSetTypeMappingSetQEMREFParserRuleCall_5_2_0_1 = (RuleCall)cTypeMappingSetTypeMappingSetCrossReference_5_2_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_5_3 = (Keyword)cGroup_5.eContents().get(3);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cUseKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Keyword cBehaviorKeyword_6_1 = (Keyword)cGroup_6.eContents().get(1);
		private final Assignment cUseBehaviorAssignment_6_2 = (Assignment)cGroup_6.eContents().get(2);
		private final CrossReference cUseBehaviorErrorBehaviorStateMachineCrossReference_6_2_0 = (CrossReference)cUseBehaviorAssignment_6_2.eContents().get(0);
		private final RuleCall cUseBehaviorErrorBehaviorStateMachineQEMREFParserRuleCall_6_2_0_1 = (RuleCall)cUseBehaviorErrorBehaviorStateMachineCrossReference_6_2_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_6_3 = (Keyword)cGroup_6.eContents().get(3);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cErrorKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Keyword cPropagationsKeyword_7_1 = (Keyword)cGroup_7.eContents().get(1);
		private final Assignment cPropagationsAssignment_7_2 = (Assignment)cGroup_7.eContents().get(2);
		private final RuleCall cPropagationsErrorPropagationParserRuleCall_7_2_0 = (RuleCall)cPropagationsAssignment_7_2.eContents().get(0);
		private final Group cGroup_7_3 = (Group)cGroup_7.eContents().get(3);
		private final Keyword cFlowsKeyword_7_3_0 = (Keyword)cGroup_7_3.eContents().get(0);
		private final Assignment cFlowsAssignment_7_3_1 = (Assignment)cGroup_7_3.eContents().get(1);
		private final RuleCall cFlowsErrorFlowParserRuleCall_7_3_1_0 = (RuleCall)cFlowsAssignment_7_3_1.eContents().get(0);
		private final Keyword cEndKeyword_7_4 = (Keyword)cGroup_7.eContents().get(4);
		private final Keyword cPropagationsKeyword_7_5 = (Keyword)cGroup_7.eContents().get(5);
		private final Keyword cSemicolonKeyword_7_6 = (Keyword)cGroup_7.eContents().get(6);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cComponentKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cErrorKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Keyword cBehaviorKeyword_8_2 = (Keyword)cGroup_8.eContents().get(2);
		private final Group cGroup_8_3 = (Group)cGroup_8.eContents().get(3);
		private final Keyword cUseKeyword_8_3_0 = (Keyword)cGroup_8_3.eContents().get(0);
		private final Keyword cTransformationsKeyword_8_3_1 = (Keyword)cGroup_8_3.eContents().get(1);
		private final Assignment cUseTransformationAssignment_8_3_2 = (Assignment)cGroup_8_3.eContents().get(2);
		private final CrossReference cUseTransformationTypeTransformationSetCrossReference_8_3_2_0 = (CrossReference)cUseTransformationAssignment_8_3_2.eContents().get(0);
		private final RuleCall cUseTransformationTypeTransformationSetQEMREFParserRuleCall_8_3_2_0_1 = (RuleCall)cUseTransformationTypeTransformationSetCrossReference_8_3_2_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_8_3_3 = (Keyword)cGroup_8_3.eContents().get(3);
		private final Group cGroup_8_4 = (Group)cGroup_8.eContents().get(4);
		private final Keyword cEventsKeyword_8_4_0 = (Keyword)cGroup_8_4.eContents().get(0);
		private final Assignment cEventsAssignment_8_4_1 = (Assignment)cGroup_8_4.eContents().get(1);
		private final RuleCall cEventsErrorBehaviorEventParserRuleCall_8_4_1_0 = (RuleCall)cEventsAssignment_8_4_1.eContents().get(0);
		private final Group cGroup_8_5 = (Group)cGroup_8.eContents().get(5);
		private final Keyword cTransitionsKeyword_8_5_0 = (Keyword)cGroup_8_5.eContents().get(0);
		private final Assignment cTransitionsAssignment_8_5_1 = (Assignment)cGroup_8_5.eContents().get(1);
		private final RuleCall cTransitionsErrorBehaviorTransitionParserRuleCall_8_5_1_0 = (RuleCall)cTransitionsAssignment_8_5_1.eContents().get(0);
		private final Group cGroup_8_6 = (Group)cGroup_8.eContents().get(6);
		private final Keyword cPropagationsKeyword_8_6_0 = (Keyword)cGroup_8_6.eContents().get(0);
		private final Assignment cOutgoingPropagationConditionsAssignment_8_6_1 = (Assignment)cGroup_8_6.eContents().get(1);
		private final RuleCall cOutgoingPropagationConditionsOutgoingPropagationConditionParserRuleCall_8_6_1_0 = (RuleCall)cOutgoingPropagationConditionsAssignment_8_6_1.eContents().get(0);
		private final Group cGroup_8_7 = (Group)cGroup_8.eContents().get(7);
		private final Keyword cDetectionsKeyword_8_7_0 = (Keyword)cGroup_8_7.eContents().get(0);
		private final Assignment cErrorDetectionsAssignment_8_7_1 = (Assignment)cGroup_8_7.eContents().get(1);
		private final RuleCall cErrorDetectionsErrorDetectionParserRuleCall_8_7_1_0 = (RuleCall)cErrorDetectionsAssignment_8_7_1.eContents().get(0);
		private final Group cGroup_8_8 = (Group)cGroup_8.eContents().get(8);
		private final Keyword cModeKeyword_8_8_0 = (Keyword)cGroup_8_8.eContents().get(0);
		private final Keyword cMappingsKeyword_8_8_1 = (Keyword)cGroup_8_8.eContents().get(1);
		private final Assignment cErrorStateToModeMappingsAssignment_8_8_2 = (Assignment)cGroup_8_8.eContents().get(2);
		private final RuleCall cErrorStateToModeMappingsErrorStateToModeMappingParserRuleCall_8_8_2_0 = (RuleCall)cErrorStateToModeMappingsAssignment_8_8_2.eContents().get(0);
		private final Keyword cEndKeyword_8_9 = (Keyword)cGroup_8.eContents().get(9);
		private final Keyword cComponentKeyword_8_10 = (Keyword)cGroup_8.eContents().get(10);
		private final Keyword cSemicolonKeyword_8_11 = (Keyword)cGroup_8.eContents().get(11);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cCompositeKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Keyword cErrorKeyword_9_1 = (Keyword)cGroup_9.eContents().get(1);
		private final Keyword cBehaviorKeyword_9_2 = (Keyword)cGroup_9.eContents().get(2);
		private final Group cGroup_9_3 = (Group)cGroup_9.eContents().get(3);
		private final Keyword cStatesKeyword_9_3_0 = (Keyword)cGroup_9_3.eContents().get(0);
		private final Assignment cStatesAssignment_9_3_1 = (Assignment)cGroup_9_3.eContents().get(1);
		private final RuleCall cStatesCompositeStateParserRuleCall_9_3_1_0 = (RuleCall)cStatesAssignment_9_3_1.eContents().get(0);
		private final Keyword cEndKeyword_9_4 = (Keyword)cGroup_9.eContents().get(4);
		private final Keyword cCompositeKeyword_9_5 = (Keyword)cGroup_9.eContents().get(5);
		private final Keyword cSemicolonKeyword_9_6 = (Keyword)cGroup_9.eContents().get(6);
		private final Group cGroup_10 = (Group)cGroup.eContents().get(10);
		private final Keyword cConnectionKeyword_10_0 = (Keyword)cGroup_10.eContents().get(0);
		private final Keyword cErrorKeyword_10_1 = (Keyword)cGroup_10.eContents().get(1);
		private final Group cGroup_10_2 = (Group)cGroup_10.eContents().get(2);
		private final Keyword cUseKeyword_10_2_0 = (Keyword)cGroup_10_2.eContents().get(0);
		private final Keyword cTransformationsKeyword_10_2_1 = (Keyword)cGroup_10_2.eContents().get(1);
		private final Assignment cTypeTransformationSetAssignment_10_2_2 = (Assignment)cGroup_10_2.eContents().get(2);
		private final CrossReference cTypeTransformationSetTypeTransformationSetCrossReference_10_2_2_0 = (CrossReference)cTypeTransformationSetAssignment_10_2_2.eContents().get(0);
		private final RuleCall cTypeTransformationSetTypeTransformationSetQEMREFParserRuleCall_10_2_2_0_1 = (RuleCall)cTypeTransformationSetTypeTransformationSetCrossReference_10_2_2_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_10_2_3 = (Keyword)cGroup_10_2.eContents().get(3);
		private final Assignment cConnectionErrorSourcesAssignment_10_3 = (Assignment)cGroup_10.eContents().get(3);
		private final RuleCall cConnectionErrorSourcesErrorSourceParserRuleCall_10_3_0 = (RuleCall)cConnectionErrorSourcesAssignment_10_3.eContents().get(0);
		private final Keyword cEndKeyword_10_4 = (Keyword)cGroup_10.eContents().get(4);
		private final Keyword cConnectionKeyword_10_5 = (Keyword)cGroup_10.eContents().get(5);
		private final Keyword cSemicolonKeyword_10_6 = (Keyword)cGroup_10.eContents().get(6);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cPropagationKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Keyword cPathsKeyword_11_1 = (Keyword)cGroup_11.eContents().get(1);
		private final Assignment cPointsAssignment_11_2 = (Assignment)cGroup_11.eContents().get(2);
		private final RuleCall cPointsPropagationPointParserRuleCall_11_2_0 = (RuleCall)cPointsAssignment_11_2.eContents().get(0);
		private final Assignment cPathsAssignment_11_3 = (Assignment)cGroup_11.eContents().get(3);
		private final RuleCall cPathsPropagationPathParserRuleCall_11_3_0 = (RuleCall)cPathsAssignment_11_3.eContents().get(0);
		private final Keyword cEndKeyword_11_4 = (Keyword)cGroup_11.eContents().get(4);
		private final Keyword cPathsKeyword_11_5 = (Keyword)cGroup_11.eContents().get(5);
		private final Keyword cSemicolonKeyword_11_6 = (Keyword)cGroup_11.eContents().get(6);
		private final Group cGroup_12 = (Group)cGroup.eContents().get(12);
		private final Keyword cPropertiesKeyword_12_0 = (Keyword)cGroup_12.eContents().get(0);
		private final Assignment cPropertiesAssignment_12_1 = (Assignment)cGroup_12.eContents().get(1);
		private final RuleCall cPropertiesEMV2PropertyAssociationParserRuleCall_12_1_0 = (RuleCall)cPropertiesAssignment_12_1.eContents().get(0);
		private final Keyword cEndKeyword_13 = (Keyword)cGroup.eContents().get(13);
		private final Keyword cSubclauseKeyword_14 = (Keyword)cGroup.eContents().get(14);
		private final Keyword cSemicolonKeyword_15 = (Keyword)cGroup.eContents().get(15);
		
		//EMV2Subclause ErrorModelSubclause:
		//	{ErrorModelSubclause} 'subclause' name=QCREF ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('use' 'type' 'equivalence' typeEquivalence=[TypeMappingSet|QEMREF] ';')?
		//	('use' 'mappings' typeMappingSet=[TypeMappingSet|QEMREF] ';')? ('use' 'behavior'
		//	useBehavior=[ErrorBehaviorStateMachine|QEMREF]
		//	//   	('(' stateTypeBindings+=StateTypeBinding (',' stateTypeBindings+=StateTypeBinding)*')')?
		//	';')? ('error' 'propagations'
		//	propagations+=ErrorPropagation* ('flows'
		//	flows+=ErrorFlow+)?
		//	'end' 'propagations' ';')? ('component' 'error' 'behavior' ('use' 'transformations'
		//	useTransformation=[TypeTransformationSet|QEMREF] ';')? ('events' events+=ErrorBehaviorEvent+)? ('transitions'
		//	transitions+=ErrorBehaviorTransition+)? ('propagations'
		//	outgoingPropagationConditions+=OutgoingPropagationCondition+)? ('detections'
		//	errorDetections+=ErrorDetection+)? ('mode' 'mappings'
		//	errorStateToModeMappings+=ErrorStateToModeMapping+)?
		//	'end' 'component' ';')? ('composite' 'error' 'behavior' ('states'
		//	states+=CompositeState+)?
		//	'end' 'composite' ';')? ('connection' 'error' ('use' 'transformations'
		//	typeTransformationSet=[TypeTransformationSet|QEMREF] ';')?
		//	connectionErrorSources+=ErrorSource*
		//	'end' 'connection' ';')? ('propagation' 'paths'
		//	points+=PropagationPoint*
		//	paths+=PropagationPath*
		//	'end' 'paths' ';')? ('properties'
		//	properties+=EMV2PropertyAssociation+)?
		//	//	'**}'
		//	'end' 'subclause' ';';
		@Override public ParserRule getRule() { return rule; }
		
		//{ErrorModelSubclause} 'subclause' name=QCREF ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('use' 'type' 'equivalence' typeEquivalence=[TypeMappingSet|QEMREF] ';')?
		//('use' 'mappings' typeMappingSet=[TypeMappingSet|QEMREF] ';')? ('use' 'behavior'
		//useBehavior=[ErrorBehaviorStateMachine|QEMREF] //   	('(' stateTypeBindings+=StateTypeBinding (',' stateTypeBindings+=StateTypeBinding)*')')?
		//';')? ('error' 'propagations' propagations+=ErrorPropagation* ('flows' flows+=ErrorFlow+)? 'end' 'propagations' ';')?
		//('component' 'error' 'behavior' ('use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF] ';')?
		//('events' events+=ErrorBehaviorEvent+)? ('transitions' transitions+=ErrorBehaviorTransition+)? ('propagations'
		//outgoingPropagationConditions+=OutgoingPropagationCondition+)? ('detections' errorDetections+=ErrorDetection+)? ('mode'
		//'mappings' errorStateToModeMappings+=ErrorStateToModeMapping+)? 'end' 'component' ';')? ('composite' 'error' 'behavior'
		//('states' states+=CompositeState+)? 'end' 'composite' ';')? ('connection' 'error' ('use' 'transformations'
		//typeTransformationSet=[TypeTransformationSet|QEMREF] ';')? connectionErrorSources+=ErrorSource* 'end' 'connection'
		//';')? ('propagation' 'paths' points+=PropagationPoint* paths+=PropagationPath* 'end' 'paths' ';')? ('properties'
		//properties+=EMV2PropertyAssociation+)? //	'**}'
		//'end' 'subclause' ';'
		public Group getGroup() { return cGroup; }
		
		//{ErrorModelSubclause}
		public Action getErrorModelSubclauseAction_0() { return cErrorModelSubclauseAction_0; }
		
		//'subclause'
		public Keyword getSubclauseKeyword_1() { return cSubclauseKeyword_1; }
		
		//name=QCREF
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//QCREF
		public RuleCall getNameQCREFParserRuleCall_2_0() { return cNameQCREFParserRuleCall_2_0; }
		
		//('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		public Group getGroup_3() { return cGroup_3; }
		
		//'use'
		public Keyword getUseKeyword_3_0() { return cUseKeyword_3_0; }
		
		//'types'
		public Keyword getTypesKeyword_3_1() { return cTypesKeyword_3_1; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_3_2() { return cUseTypesAssignment_3_2; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_3_2_0() { return cUseTypesErrorModelLibraryCrossReference_3_2_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_0_1; }
		
		//(',' useTypes+=[ErrorModelLibrary|QEMREF])*
		public Group getGroup_3_3() { return cGroup_3_3; }
		
		//','
		public Keyword getCommaKeyword_3_3_0() { return cCommaKeyword_3_3_0; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_3_3_1() { return cUseTypesAssignment_3_3_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_3_3_1_0() { return cUseTypesErrorModelLibraryCrossReference_3_3_1_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_3_3_1_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_3_1_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_3_4() { return cSemicolonKeyword_3_4; }
		
		//('use' 'type' 'equivalence' typeEquivalence=[TypeMappingSet|QEMREF] ';')?
		public Group getGroup_4() { return cGroup_4; }
		
		//'use'
		public Keyword getUseKeyword_4_0() { return cUseKeyword_4_0; }
		
		//'type'
		public Keyword getTypeKeyword_4_1() { return cTypeKeyword_4_1; }
		
		//'equivalence'
		public Keyword getEquivalenceKeyword_4_2() { return cEquivalenceKeyword_4_2; }
		
		//typeEquivalence=[TypeMappingSet|QEMREF]
		public Assignment getTypeEquivalenceAssignment_4_3() { return cTypeEquivalenceAssignment_4_3; }
		
		//[TypeMappingSet|QEMREF]
		public CrossReference getTypeEquivalenceTypeMappingSetCrossReference_4_3_0() { return cTypeEquivalenceTypeMappingSetCrossReference_4_3_0; }
		
		//QEMREF
		public RuleCall getTypeEquivalenceTypeMappingSetQEMREFParserRuleCall_4_3_0_1() { return cTypeEquivalenceTypeMappingSetQEMREFParserRuleCall_4_3_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_4_4() { return cSemicolonKeyword_4_4; }
		
		//('use' 'mappings' typeMappingSet=[TypeMappingSet|QEMREF] ';')?
		public Group getGroup_5() { return cGroup_5; }
		
		//'use'
		public Keyword getUseKeyword_5_0() { return cUseKeyword_5_0; }
		
		//'mappings'
		public Keyword getMappingsKeyword_5_1() { return cMappingsKeyword_5_1; }
		
		//typeMappingSet=[TypeMappingSet|QEMREF]
		public Assignment getTypeMappingSetAssignment_5_2() { return cTypeMappingSetAssignment_5_2; }
		
		//[TypeMappingSet|QEMREF]
		public CrossReference getTypeMappingSetTypeMappingSetCrossReference_5_2_0() { return cTypeMappingSetTypeMappingSetCrossReference_5_2_0; }
		
		//QEMREF
		public RuleCall getTypeMappingSetTypeMappingSetQEMREFParserRuleCall_5_2_0_1() { return cTypeMappingSetTypeMappingSetQEMREFParserRuleCall_5_2_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_5_3() { return cSemicolonKeyword_5_3; }
		
		//('use' 'behavior' useBehavior=[ErrorBehaviorStateMachine|QEMREF] //   	('(' stateTypeBindings+=StateTypeBinding (',' stateTypeBindings+=StateTypeBinding)*')')?
		//';')?
		public Group getGroup_6() { return cGroup_6; }
		
		//'use'
		public Keyword getUseKeyword_6_0() { return cUseKeyword_6_0; }
		
		//'behavior'
		public Keyword getBehaviorKeyword_6_1() { return cBehaviorKeyword_6_1; }
		
		//useBehavior=[ErrorBehaviorStateMachine|QEMREF]
		public Assignment getUseBehaviorAssignment_6_2() { return cUseBehaviorAssignment_6_2; }
		
		//[ErrorBehaviorStateMachine|QEMREF]
		public CrossReference getUseBehaviorErrorBehaviorStateMachineCrossReference_6_2_0() { return cUseBehaviorErrorBehaviorStateMachineCrossReference_6_2_0; }
		
		//QEMREF
		public RuleCall getUseBehaviorErrorBehaviorStateMachineQEMREFParserRuleCall_6_2_0_1() { return cUseBehaviorErrorBehaviorStateMachineQEMREFParserRuleCall_6_2_0_1; }
		
		////   	('(' stateTypeBindings+=StateTypeBinding (',' stateTypeBindings+=StateTypeBinding)*')')?
		//';'
		public Keyword getSemicolonKeyword_6_3() { return cSemicolonKeyword_6_3; }
		
		//('error' 'propagations' propagations+=ErrorPropagation* ('flows' flows+=ErrorFlow+)? 'end' 'propagations' ';')?
		public Group getGroup_7() { return cGroup_7; }
		
		//'error'
		public Keyword getErrorKeyword_7_0() { return cErrorKeyword_7_0; }
		
		//'propagations'
		public Keyword getPropagationsKeyword_7_1() { return cPropagationsKeyword_7_1; }
		
		//propagations+=ErrorPropagation*
		public Assignment getPropagationsAssignment_7_2() { return cPropagationsAssignment_7_2; }
		
		//ErrorPropagation
		public RuleCall getPropagationsErrorPropagationParserRuleCall_7_2_0() { return cPropagationsErrorPropagationParserRuleCall_7_2_0; }
		
		//('flows' flows+=ErrorFlow+)?
		public Group getGroup_7_3() { return cGroup_7_3; }
		
		//'flows'
		public Keyword getFlowsKeyword_7_3_0() { return cFlowsKeyword_7_3_0; }
		
		//flows+=ErrorFlow+
		public Assignment getFlowsAssignment_7_3_1() { return cFlowsAssignment_7_3_1; }
		
		//ErrorFlow
		public RuleCall getFlowsErrorFlowParserRuleCall_7_3_1_0() { return cFlowsErrorFlowParserRuleCall_7_3_1_0; }
		
		//'end'
		public Keyword getEndKeyword_7_4() { return cEndKeyword_7_4; }
		
		//'propagations'
		public Keyword getPropagationsKeyword_7_5() { return cPropagationsKeyword_7_5; }
		
		//';'
		public Keyword getSemicolonKeyword_7_6() { return cSemicolonKeyword_7_6; }
		
		//('component' 'error' 'behavior' ('use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF] ';')?
		//('events' events+=ErrorBehaviorEvent+)? ('transitions' transitions+=ErrorBehaviorTransition+)? ('propagations'
		//outgoingPropagationConditions+=OutgoingPropagationCondition+)? ('detections' errorDetections+=ErrorDetection+)? ('mode'
		//'mappings' errorStateToModeMappings+=ErrorStateToModeMapping+)? 'end' 'component' ';')?
		public Group getGroup_8() { return cGroup_8; }
		
		//'component'
		public Keyword getComponentKeyword_8_0() { return cComponentKeyword_8_0; }
		
		//'error'
		public Keyword getErrorKeyword_8_1() { return cErrorKeyword_8_1; }
		
		//'behavior'
		public Keyword getBehaviorKeyword_8_2() { return cBehaviorKeyword_8_2; }
		
		//('use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF] ';')?
		public Group getGroup_8_3() { return cGroup_8_3; }
		
		//'use'
		public Keyword getUseKeyword_8_3_0() { return cUseKeyword_8_3_0; }
		
		//'transformations'
		public Keyword getTransformationsKeyword_8_3_1() { return cTransformationsKeyword_8_3_1; }
		
		//useTransformation=[TypeTransformationSet|QEMREF]
		public Assignment getUseTransformationAssignment_8_3_2() { return cUseTransformationAssignment_8_3_2; }
		
		//[TypeTransformationSet|QEMREF]
		public CrossReference getUseTransformationTypeTransformationSetCrossReference_8_3_2_0() { return cUseTransformationTypeTransformationSetCrossReference_8_3_2_0; }
		
		//QEMREF
		public RuleCall getUseTransformationTypeTransformationSetQEMREFParserRuleCall_8_3_2_0_1() { return cUseTransformationTypeTransformationSetQEMREFParserRuleCall_8_3_2_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_8_3_3() { return cSemicolonKeyword_8_3_3; }
		
		//('events' events+=ErrorBehaviorEvent+)?
		public Group getGroup_8_4() { return cGroup_8_4; }
		
		//'events'
		public Keyword getEventsKeyword_8_4_0() { return cEventsKeyword_8_4_0; }
		
		//events+=ErrorBehaviorEvent+
		public Assignment getEventsAssignment_8_4_1() { return cEventsAssignment_8_4_1; }
		
		//ErrorBehaviorEvent
		public RuleCall getEventsErrorBehaviorEventParserRuleCall_8_4_1_0() { return cEventsErrorBehaviorEventParserRuleCall_8_4_1_0; }
		
		//('transitions' transitions+=ErrorBehaviorTransition+)?
		public Group getGroup_8_5() { return cGroup_8_5; }
		
		//'transitions'
		public Keyword getTransitionsKeyword_8_5_0() { return cTransitionsKeyword_8_5_0; }
		
		//transitions+=ErrorBehaviorTransition+
		public Assignment getTransitionsAssignment_8_5_1() { return cTransitionsAssignment_8_5_1; }
		
		//ErrorBehaviorTransition
		public RuleCall getTransitionsErrorBehaviorTransitionParserRuleCall_8_5_1_0() { return cTransitionsErrorBehaviorTransitionParserRuleCall_8_5_1_0; }
		
		//('propagations' outgoingPropagationConditions+=OutgoingPropagationCondition+)?
		public Group getGroup_8_6() { return cGroup_8_6; }
		
		//'propagations'
		public Keyword getPropagationsKeyword_8_6_0() { return cPropagationsKeyword_8_6_0; }
		
		//outgoingPropagationConditions+=OutgoingPropagationCondition+
		public Assignment getOutgoingPropagationConditionsAssignment_8_6_1() { return cOutgoingPropagationConditionsAssignment_8_6_1; }
		
		//OutgoingPropagationCondition
		public RuleCall getOutgoingPropagationConditionsOutgoingPropagationConditionParserRuleCall_8_6_1_0() { return cOutgoingPropagationConditionsOutgoingPropagationConditionParserRuleCall_8_6_1_0; }
		
		//('detections' errorDetections+=ErrorDetection+)?
		public Group getGroup_8_7() { return cGroup_8_7; }
		
		//'detections'
		public Keyword getDetectionsKeyword_8_7_0() { return cDetectionsKeyword_8_7_0; }
		
		//errorDetections+=ErrorDetection+
		public Assignment getErrorDetectionsAssignment_8_7_1() { return cErrorDetectionsAssignment_8_7_1; }
		
		//ErrorDetection
		public RuleCall getErrorDetectionsErrorDetectionParserRuleCall_8_7_1_0() { return cErrorDetectionsErrorDetectionParserRuleCall_8_7_1_0; }
		
		//('mode' 'mappings' errorStateToModeMappings+=ErrorStateToModeMapping+)?
		public Group getGroup_8_8() { return cGroup_8_8; }
		
		//'mode'
		public Keyword getModeKeyword_8_8_0() { return cModeKeyword_8_8_0; }
		
		//'mappings'
		public Keyword getMappingsKeyword_8_8_1() { return cMappingsKeyword_8_8_1; }
		
		//errorStateToModeMappings+=ErrorStateToModeMapping+
		public Assignment getErrorStateToModeMappingsAssignment_8_8_2() { return cErrorStateToModeMappingsAssignment_8_8_2; }
		
		//ErrorStateToModeMapping
		public RuleCall getErrorStateToModeMappingsErrorStateToModeMappingParserRuleCall_8_8_2_0() { return cErrorStateToModeMappingsErrorStateToModeMappingParserRuleCall_8_8_2_0; }
		
		//'end'
		public Keyword getEndKeyword_8_9() { return cEndKeyword_8_9; }
		
		//'component'
		public Keyword getComponentKeyword_8_10() { return cComponentKeyword_8_10; }
		
		//';'
		public Keyword getSemicolonKeyword_8_11() { return cSemicolonKeyword_8_11; }
		
		//('composite' 'error' 'behavior' ('states' states+=CompositeState+)? 'end' 'composite' ';')?
		public Group getGroup_9() { return cGroup_9; }
		
		//'composite'
		public Keyword getCompositeKeyword_9_0() { return cCompositeKeyword_9_0; }
		
		//'error'
		public Keyword getErrorKeyword_9_1() { return cErrorKeyword_9_1; }
		
		//'behavior'
		public Keyword getBehaviorKeyword_9_2() { return cBehaviorKeyword_9_2; }
		
		//('states' states+=CompositeState+)?
		public Group getGroup_9_3() { return cGroup_9_3; }
		
		//'states'
		public Keyword getStatesKeyword_9_3_0() { return cStatesKeyword_9_3_0; }
		
		//states+=CompositeState+
		public Assignment getStatesAssignment_9_3_1() { return cStatesAssignment_9_3_1; }
		
		//CompositeState
		public RuleCall getStatesCompositeStateParserRuleCall_9_3_1_0() { return cStatesCompositeStateParserRuleCall_9_3_1_0; }
		
		//'end'
		public Keyword getEndKeyword_9_4() { return cEndKeyword_9_4; }
		
		//'composite'
		public Keyword getCompositeKeyword_9_5() { return cCompositeKeyword_9_5; }
		
		//';'
		public Keyword getSemicolonKeyword_9_6() { return cSemicolonKeyword_9_6; }
		
		//('connection' 'error' ('use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF] ';')?
		//connectionErrorSources+=ErrorSource* 'end' 'connection' ';')?
		public Group getGroup_10() { return cGroup_10; }
		
		//'connection'
		public Keyword getConnectionKeyword_10_0() { return cConnectionKeyword_10_0; }
		
		//'error'
		public Keyword getErrorKeyword_10_1() { return cErrorKeyword_10_1; }
		
		//('use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF] ';')?
		public Group getGroup_10_2() { return cGroup_10_2; }
		
		//'use'
		public Keyword getUseKeyword_10_2_0() { return cUseKeyword_10_2_0; }
		
		//'transformations'
		public Keyword getTransformationsKeyword_10_2_1() { return cTransformationsKeyword_10_2_1; }
		
		//typeTransformationSet=[TypeTransformationSet|QEMREF]
		public Assignment getTypeTransformationSetAssignment_10_2_2() { return cTypeTransformationSetAssignment_10_2_2; }
		
		//[TypeTransformationSet|QEMREF]
		public CrossReference getTypeTransformationSetTypeTransformationSetCrossReference_10_2_2_0() { return cTypeTransformationSetTypeTransformationSetCrossReference_10_2_2_0; }
		
		//QEMREF
		public RuleCall getTypeTransformationSetTypeTransformationSetQEMREFParserRuleCall_10_2_2_0_1() { return cTypeTransformationSetTypeTransformationSetQEMREFParserRuleCall_10_2_2_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_10_2_3() { return cSemicolonKeyword_10_2_3; }
		
		//connectionErrorSources+=ErrorSource*
		public Assignment getConnectionErrorSourcesAssignment_10_3() { return cConnectionErrorSourcesAssignment_10_3; }
		
		//ErrorSource
		public RuleCall getConnectionErrorSourcesErrorSourceParserRuleCall_10_3_0() { return cConnectionErrorSourcesErrorSourceParserRuleCall_10_3_0; }
		
		//'end'
		public Keyword getEndKeyword_10_4() { return cEndKeyword_10_4; }
		
		//'connection'
		public Keyword getConnectionKeyword_10_5() { return cConnectionKeyword_10_5; }
		
		//';'
		public Keyword getSemicolonKeyword_10_6() { return cSemicolonKeyword_10_6; }
		
		//('propagation' 'paths' points+=PropagationPoint* paths+=PropagationPath* 'end' 'paths' ';')?
		public Group getGroup_11() { return cGroup_11; }
		
		//'propagation'
		public Keyword getPropagationKeyword_11_0() { return cPropagationKeyword_11_0; }
		
		//'paths'
		public Keyword getPathsKeyword_11_1() { return cPathsKeyword_11_1; }
		
		//points+=PropagationPoint*
		public Assignment getPointsAssignment_11_2() { return cPointsAssignment_11_2; }
		
		//PropagationPoint
		public RuleCall getPointsPropagationPointParserRuleCall_11_2_0() { return cPointsPropagationPointParserRuleCall_11_2_0; }
		
		//paths+=PropagationPath*
		public Assignment getPathsAssignment_11_3() { return cPathsAssignment_11_3; }
		
		//PropagationPath
		public RuleCall getPathsPropagationPathParserRuleCall_11_3_0() { return cPathsPropagationPathParserRuleCall_11_3_0; }
		
		//'end'
		public Keyword getEndKeyword_11_4() { return cEndKeyword_11_4; }
		
		//'paths'
		public Keyword getPathsKeyword_11_5() { return cPathsKeyword_11_5; }
		
		//';'
		public Keyword getSemicolonKeyword_11_6() { return cSemicolonKeyword_11_6; }
		
		//('properties' properties+=EMV2PropertyAssociation+)?
		public Group getGroup_12() { return cGroup_12; }
		
		//'properties'
		public Keyword getPropertiesKeyword_12_0() { return cPropertiesKeyword_12_0; }
		
		//properties+=EMV2PropertyAssociation+
		public Assignment getPropertiesAssignment_12_1() { return cPropertiesAssignment_12_1; }
		
		//EMV2PropertyAssociation
		public RuleCall getPropertiesEMV2PropertyAssociationParserRuleCall_12_1_0() { return cPropertiesEMV2PropertyAssociationParserRuleCall_12_1_0; }
		
		////	'**}'
		//'end'
		public Keyword getEndKeyword_13() { return cEndKeyword_13; }
		
		//'subclause'
		public Keyword getSubclauseKeyword_14() { return cSubclauseKeyword_14; }
		
		//';'
		public Keyword getSemicolonKeyword_15() { return cSemicolonKeyword_15; }
	}
	public class ErrorModelLibraryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorModelLibrary");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cErrorModelLibraryAction_0 = (Action)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cErrorKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cTypesKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cUseKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Keyword cTypesKeyword_1_2_1 = (Keyword)cGroup_1_2.eContents().get(1);
		private final Assignment cUseTypesAssignment_1_2_2 = (Assignment)cGroup_1_2.eContents().get(2);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_1_2_2_0 = (CrossReference)cUseTypesAssignment_1_2_2.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_1_2_2_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_1_2_2_0.eContents().get(1);
		private final Group cGroup_1_2_3 = (Group)cGroup_1_2.eContents().get(3);
		private final Keyword cCommaKeyword_1_2_3_0 = (Keyword)cGroup_1_2_3.eContents().get(0);
		private final Assignment cUseTypesAssignment_1_2_3_1 = (Assignment)cGroup_1_2_3.eContents().get(1);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_1_2_3_1_0 = (CrossReference)cUseTypesAssignment_1_2_3_1.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_1_2_3_1_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_1_2_3_1_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_1_2_4 = (Keyword)cGroup_1_2.eContents().get(4);
		private final Group cGroup_1_3 = (Group)cGroup_1.eContents().get(3);
		private final Keyword cExtendsKeyword_1_3_0 = (Keyword)cGroup_1_3.eContents().get(0);
		private final Assignment cExtendsAssignment_1_3_1 = (Assignment)cGroup_1_3.eContents().get(1);
		private final CrossReference cExtendsErrorModelLibraryCrossReference_1_3_1_0 = (CrossReference)cExtendsAssignment_1_3_1.eContents().get(0);
		private final RuleCall cExtendsErrorModelLibraryQEMREFParserRuleCall_1_3_1_0_1 = (RuleCall)cExtendsErrorModelLibraryCrossReference_1_3_1_0.eContents().get(1);
		private final Group cGroup_1_3_2 = (Group)cGroup_1_3.eContents().get(2);
		private final Keyword cCommaKeyword_1_3_2_0 = (Keyword)cGroup_1_3_2.eContents().get(0);
		private final Assignment cExtendsAssignment_1_3_2_1 = (Assignment)cGroup_1_3_2.eContents().get(1);
		private final CrossReference cExtendsErrorModelLibraryCrossReference_1_3_2_1_0 = (CrossReference)cExtendsAssignment_1_3_2_1.eContents().get(0);
		private final RuleCall cExtendsErrorModelLibraryQEMREFParserRuleCall_1_3_2_1_0_1 = (RuleCall)cExtendsErrorModelLibraryCrossReference_1_3_2_1_0.eContents().get(1);
		private final Keyword cWithKeyword_1_3_3 = (Keyword)cGroup_1_3.eContents().get(3);
		private final Alternatives cAlternatives_1_4 = (Alternatives)cGroup_1.eContents().get(4);
		private final Assignment cTypesAssignment_1_4_0 = (Assignment)cAlternatives_1_4.eContents().get(0);
		private final RuleCall cTypesTypeDefinitionParserRuleCall_1_4_0_0 = (RuleCall)cTypesAssignment_1_4_0.eContents().get(0);
		private final Assignment cTypesetsAssignment_1_4_1 = (Assignment)cAlternatives_1_4.eContents().get(1);
		private final RuleCall cTypesetsTypeSetDefinitionParserRuleCall_1_4_1_0 = (RuleCall)cTypesetsAssignment_1_4_1.eContents().get(0);
		private final Group cGroup_1_5 = (Group)cGroup_1.eContents().get(5);
		private final Keyword cPropertiesKeyword_1_5_0 = (Keyword)cGroup_1_5.eContents().get(0);
		private final Assignment cPropertiesAssignment_1_5_1 = (Assignment)cGroup_1_5.eContents().get(1);
		private final RuleCall cPropertiesBasicEMV2PropertyAssociationParserRuleCall_1_5_1_0 = (RuleCall)cPropertiesAssignment_1_5_1.eContents().get(0);
		private final Keyword cEndKeyword_1_6 = (Keyword)cGroup_1.eContents().get(6);
		private final Keyword cTypesKeyword_1_7 = (Keyword)cGroup_1.eContents().get(7);
		private final Keyword cSemicolonKeyword_1_8 = (Keyword)cGroup_1.eContents().get(8);
		private final Assignment cBehaviorsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cBehaviorsErrorBehaviorStateMachineParserRuleCall_2_0 = (RuleCall)cBehaviorsAssignment_2.eContents().get(0);
		private final Assignment cMappingsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cMappingsTypeMappingSetParserRuleCall_3_0 = (RuleCall)cMappingsAssignment_3.eContents().get(0);
		private final Assignment cTransformationsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cTransformationsTypeTransformationSetParserRuleCall_4_0 = (RuleCall)cTransformationsAssignment_4.eContents().get(0);
		
		//ErrorModelLibrary:
		//	{ErrorModelLibrary} ('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('extends' extends+=[ErrorModelLibrary|QEMREF] (','
		//	extends+=[ErrorModelLibrary|QEMREF])*
		//	'with')? (types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties'
		//	properties+=BasicEMV2PropertyAssociation+)?
		//	'end' 'types' ';')?
		//	behaviors+=ErrorBehaviorStateMachine*
		//	mappings+=TypeMappingSet*
		//	transformations+=TypeTransformationSet*
		//	//	'**}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{ErrorModelLibrary} ('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('extends' extends+=[ErrorModelLibrary|QEMREF] (','
		//extends+=[ErrorModelLibrary|QEMREF])* 'with')? (types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties'
		//properties+=BasicEMV2PropertyAssociation+)? 'end' 'types' ';')? behaviors+=ErrorBehaviorStateMachine*
		//mappings+=TypeMappingSet* transformations+=TypeTransformationSet*
		public Group getGroup() { return cGroup; }
		
		//{ErrorModelLibrary}
		public Action getErrorModelLibraryAction_0() { return cErrorModelLibraryAction_0; }
		
		//('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		//('extends' extends+=[ErrorModelLibrary|QEMREF] (',' extends+=[ErrorModelLibrary|QEMREF])* 'with')?
		//(types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties' properties+=BasicEMV2PropertyAssociation+)? 'end'
		//'types' ';')?
		public Group getGroup_1() { return cGroup_1; }
		
		//'error'
		public Keyword getErrorKeyword_1_0() { return cErrorKeyword_1_0; }
		
		//'types'
		public Keyword getTypesKeyword_1_1() { return cTypesKeyword_1_1; }
		
		//('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		public Group getGroup_1_2() { return cGroup_1_2; }
		
		//'use'
		public Keyword getUseKeyword_1_2_0() { return cUseKeyword_1_2_0; }
		
		//'types'
		public Keyword getTypesKeyword_1_2_1() { return cTypesKeyword_1_2_1; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_1_2_2() { return cUseTypesAssignment_1_2_2; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_1_2_2_0() { return cUseTypesErrorModelLibraryCrossReference_1_2_2_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_2_2_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_1_2_2_0_1; }
		
		//(',' useTypes+=[ErrorModelLibrary|QEMREF])*
		public Group getGroup_1_2_3() { return cGroup_1_2_3; }
		
		//','
		public Keyword getCommaKeyword_1_2_3_0() { return cCommaKeyword_1_2_3_0; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_1_2_3_1() { return cUseTypesAssignment_1_2_3_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_1_2_3_1_0() { return cUseTypesErrorModelLibraryCrossReference_1_2_3_1_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_2_3_1_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_1_2_3_1_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_1_2_4() { return cSemicolonKeyword_1_2_4; }
		
		//('extends' extends+=[ErrorModelLibrary|QEMREF] (',' extends+=[ErrorModelLibrary|QEMREF])* 'with')?
		public Group getGroup_1_3() { return cGroup_1_3; }
		
		//'extends'
		public Keyword getExtendsKeyword_1_3_0() { return cExtendsKeyword_1_3_0; }
		
		//extends+=[ErrorModelLibrary|QEMREF]
		public Assignment getExtendsAssignment_1_3_1() { return cExtendsAssignment_1_3_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getExtendsErrorModelLibraryCrossReference_1_3_1_0() { return cExtendsErrorModelLibraryCrossReference_1_3_1_0; }
		
		//QEMREF
		public RuleCall getExtendsErrorModelLibraryQEMREFParserRuleCall_1_3_1_0_1() { return cExtendsErrorModelLibraryQEMREFParserRuleCall_1_3_1_0_1; }
		
		//(',' extends+=[ErrorModelLibrary|QEMREF])*
		public Group getGroup_1_3_2() { return cGroup_1_3_2; }
		
		//','
		public Keyword getCommaKeyword_1_3_2_0() { return cCommaKeyword_1_3_2_0; }
		
		//extends+=[ErrorModelLibrary|QEMREF]
		public Assignment getExtendsAssignment_1_3_2_1() { return cExtendsAssignment_1_3_2_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getExtendsErrorModelLibraryCrossReference_1_3_2_1_0() { return cExtendsErrorModelLibraryCrossReference_1_3_2_1_0; }
		
		//QEMREF
		public RuleCall getExtendsErrorModelLibraryQEMREFParserRuleCall_1_3_2_1_0_1() { return cExtendsErrorModelLibraryQEMREFParserRuleCall_1_3_2_1_0_1; }
		
		//'with'
		public Keyword getWithKeyword_1_3_3() { return cWithKeyword_1_3_3; }
		
		//(types+=TypeDefinition | typesets+=TypeSetDefinition)*
		public Alternatives getAlternatives_1_4() { return cAlternatives_1_4; }
		
		//types+=TypeDefinition
		public Assignment getTypesAssignment_1_4_0() { return cTypesAssignment_1_4_0; }
		
		//TypeDefinition
		public RuleCall getTypesTypeDefinitionParserRuleCall_1_4_0_0() { return cTypesTypeDefinitionParserRuleCall_1_4_0_0; }
		
		//typesets+=TypeSetDefinition
		public Assignment getTypesetsAssignment_1_4_1() { return cTypesetsAssignment_1_4_1; }
		
		//TypeSetDefinition
		public RuleCall getTypesetsTypeSetDefinitionParserRuleCall_1_4_1_0() { return cTypesetsTypeSetDefinitionParserRuleCall_1_4_1_0; }
		
		//('properties' properties+=BasicEMV2PropertyAssociation+)?
		public Group getGroup_1_5() { return cGroup_1_5; }
		
		//'properties'
		public Keyword getPropertiesKeyword_1_5_0() { return cPropertiesKeyword_1_5_0; }
		
		//properties+=BasicEMV2PropertyAssociation+
		public Assignment getPropertiesAssignment_1_5_1() { return cPropertiesAssignment_1_5_1; }
		
		//BasicEMV2PropertyAssociation
		public RuleCall getPropertiesBasicEMV2PropertyAssociationParserRuleCall_1_5_1_0() { return cPropertiesBasicEMV2PropertyAssociationParserRuleCall_1_5_1_0; }
		
		//'end'
		public Keyword getEndKeyword_1_6() { return cEndKeyword_1_6; }
		
		//'types'
		public Keyword getTypesKeyword_1_7() { return cTypesKeyword_1_7; }
		
		//';'
		public Keyword getSemicolonKeyword_1_8() { return cSemicolonKeyword_1_8; }
		
		//behaviors+=ErrorBehaviorStateMachine*
		public Assignment getBehaviorsAssignment_2() { return cBehaviorsAssignment_2; }
		
		//ErrorBehaviorStateMachine
		public RuleCall getBehaviorsErrorBehaviorStateMachineParserRuleCall_2_0() { return cBehaviorsErrorBehaviorStateMachineParserRuleCall_2_0; }
		
		//mappings+=TypeMappingSet*
		public Assignment getMappingsAssignment_3() { return cMappingsAssignment_3; }
		
		//TypeMappingSet
		public RuleCall getMappingsTypeMappingSetParserRuleCall_3_0() { return cMappingsTypeMappingSetParserRuleCall_3_0; }
		
		//transformations+=TypeTransformationSet*
		public Assignment getTransformationsAssignment_4() { return cTransformationsAssignment_4; }
		
		//TypeTransformationSet
		public RuleCall getTransformationsTypeTransformationSetParserRuleCall_4_0() { return cTransformationsTypeTransformationSetParserRuleCall_4_0; }
	}
	public class EMV2LibraryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2Library");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cErrorModelLibraryAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Keyword cLibraryKeyword_0_1_0 = (Keyword)cGroup_0_1.eContents().get(0);
		private final Assignment cNameAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final RuleCall cNameQEMREFParserRuleCall_0_1_1_0 = (RuleCall)cNameAssignment_0_1_1.eContents().get(0);
		private final Group cGroup_0_1_2 = (Group)cGroup_0_1.eContents().get(2);
		private final Keyword cErrorKeyword_0_1_2_0 = (Keyword)cGroup_0_1_2.eContents().get(0);
		private final Keyword cTypesKeyword_0_1_2_1 = (Keyword)cGroup_0_1_2.eContents().get(1);
		private final Group cGroup_0_1_2_2 = (Group)cGroup_0_1_2.eContents().get(2);
		private final Keyword cUseKeyword_0_1_2_2_0 = (Keyword)cGroup_0_1_2_2.eContents().get(0);
		private final Keyword cTypesKeyword_0_1_2_2_1 = (Keyword)cGroup_0_1_2_2.eContents().get(1);
		private final Assignment cUseTypesAssignment_0_1_2_2_2 = (Assignment)cGroup_0_1_2_2.eContents().get(2);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_0_1_2_2_2_0 = (CrossReference)cUseTypesAssignment_0_1_2_2_2.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_0_1_2_2_2_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_0_1_2_2_2_0.eContents().get(1);
		private final Group cGroup_0_1_2_2_3 = (Group)cGroup_0_1_2_2.eContents().get(3);
		private final Keyword cCommaKeyword_0_1_2_2_3_0 = (Keyword)cGroup_0_1_2_2_3.eContents().get(0);
		private final Assignment cUseTypesAssignment_0_1_2_2_3_1 = (Assignment)cGroup_0_1_2_2_3.eContents().get(1);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_0_1_2_2_3_1_0 = (CrossReference)cUseTypesAssignment_0_1_2_2_3_1.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_0_1_2_2_3_1_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_0_1_2_2_3_1_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_0_1_2_2_4 = (Keyword)cGroup_0_1_2_2.eContents().get(4);
		private final Group cGroup_0_1_2_3 = (Group)cGroup_0_1_2.eContents().get(3);
		private final Keyword cExtendsKeyword_0_1_2_3_0 = (Keyword)cGroup_0_1_2_3.eContents().get(0);
		private final Assignment cExtendsAssignment_0_1_2_3_1 = (Assignment)cGroup_0_1_2_3.eContents().get(1);
		private final CrossReference cExtendsErrorModelLibraryCrossReference_0_1_2_3_1_0 = (CrossReference)cExtendsAssignment_0_1_2_3_1.eContents().get(0);
		private final RuleCall cExtendsErrorModelLibraryQEMREFParserRuleCall_0_1_2_3_1_0_1 = (RuleCall)cExtendsErrorModelLibraryCrossReference_0_1_2_3_1_0.eContents().get(1);
		private final Group cGroup_0_1_2_3_2 = (Group)cGroup_0_1_2_3.eContents().get(2);
		private final Keyword cCommaKeyword_0_1_2_3_2_0 = (Keyword)cGroup_0_1_2_3_2.eContents().get(0);
		private final Assignment cExtendsAssignment_0_1_2_3_2_1 = (Assignment)cGroup_0_1_2_3_2.eContents().get(1);
		private final CrossReference cExtendsErrorModelLibraryCrossReference_0_1_2_3_2_1_0 = (CrossReference)cExtendsAssignment_0_1_2_3_2_1.eContents().get(0);
		private final RuleCall cExtendsErrorModelLibraryQEMREFParserRuleCall_0_1_2_3_2_1_0_1 = (RuleCall)cExtendsErrorModelLibraryCrossReference_0_1_2_3_2_1_0.eContents().get(1);
		private final Keyword cWithKeyword_0_1_2_3_3 = (Keyword)cGroup_0_1_2_3.eContents().get(3);
		private final Alternatives cAlternatives_0_1_2_4 = (Alternatives)cGroup_0_1_2.eContents().get(4);
		private final Assignment cTypesAssignment_0_1_2_4_0 = (Assignment)cAlternatives_0_1_2_4.eContents().get(0);
		private final RuleCall cTypesTypeDefinitionParserRuleCall_0_1_2_4_0_0 = (RuleCall)cTypesAssignment_0_1_2_4_0.eContents().get(0);
		private final Assignment cTypesetsAssignment_0_1_2_4_1 = (Assignment)cAlternatives_0_1_2_4.eContents().get(1);
		private final RuleCall cTypesetsTypeSetDefinitionParserRuleCall_0_1_2_4_1_0 = (RuleCall)cTypesetsAssignment_0_1_2_4_1.eContents().get(0);
		private final Group cGroup_0_1_2_5 = (Group)cGroup_0_1_2.eContents().get(5);
		private final Keyword cPropertiesKeyword_0_1_2_5_0 = (Keyword)cGroup_0_1_2_5.eContents().get(0);
		private final Assignment cPropertiesAssignment_0_1_2_5_1 = (Assignment)cGroup_0_1_2_5.eContents().get(1);
		private final RuleCall cPropertiesBasicEMV2PropertyAssociationParserRuleCall_0_1_2_5_1_0 = (RuleCall)cPropertiesAssignment_0_1_2_5_1.eContents().get(0);
		private final Keyword cEndKeyword_0_1_2_6 = (Keyword)cGroup_0_1_2.eContents().get(6);
		private final Keyword cTypesKeyword_0_1_2_7 = (Keyword)cGroup_0_1_2.eContents().get(7);
		private final Keyword cSemicolonKeyword_0_1_2_8 = (Keyword)cGroup_0_1_2.eContents().get(8);
		private final Assignment cBehaviorsAssignment_0_1_3 = (Assignment)cGroup_0_1.eContents().get(3);
		private final RuleCall cBehaviorsErrorBehaviorStateMachineParserRuleCall_0_1_3_0 = (RuleCall)cBehaviorsAssignment_0_1_3.eContents().get(0);
		private final Assignment cMappingsAssignment_0_1_4 = (Assignment)cGroup_0_1.eContents().get(4);
		private final RuleCall cMappingsTypeMappingSetParserRuleCall_0_1_4_0 = (RuleCall)cMappingsAssignment_0_1_4.eContents().get(0);
		private final Assignment cTransformationsAssignment_0_1_5 = (Assignment)cGroup_0_1.eContents().get(5);
		private final RuleCall cTransformationsTypeTransformationSetParserRuleCall_0_1_5_0 = (RuleCall)cTransformationsAssignment_0_1_5.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cPackageKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cNameAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cNameQEMREFParserRuleCall_1_1_0 = (RuleCall)cNameAssignment_1_1.eContents().get(0);
		private final Keyword cPublicKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		private final Keyword cAnnexKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);
		private final RuleCall cIDTerminalRuleCall_1_4 = (RuleCall)cGroup_1.eContents().get(4);
		private final Keyword cLeftCurlyBracketAsteriskAsteriskKeyword_1_5 = (Keyword)cGroup_1.eContents().get(5);
		private final Group cGroup_1_6 = (Group)cGroup_1.eContents().get(6);
		private final Keyword cErrorKeyword_1_6_0 = (Keyword)cGroup_1_6.eContents().get(0);
		private final Keyword cTypesKeyword_1_6_1 = (Keyword)cGroup_1_6.eContents().get(1);
		private final Group cGroup_1_6_2 = (Group)cGroup_1_6.eContents().get(2);
		private final Keyword cUseKeyword_1_6_2_0 = (Keyword)cGroup_1_6_2.eContents().get(0);
		private final Keyword cTypesKeyword_1_6_2_1 = (Keyword)cGroup_1_6_2.eContents().get(1);
		private final Assignment cUseTypesAssignment_1_6_2_2 = (Assignment)cGroup_1_6_2.eContents().get(2);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_1_6_2_2_0 = (CrossReference)cUseTypesAssignment_1_6_2_2.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_1_6_2_2_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_1_6_2_2_0.eContents().get(1);
		private final Group cGroup_1_6_2_3 = (Group)cGroup_1_6_2.eContents().get(3);
		private final Keyword cCommaKeyword_1_6_2_3_0 = (Keyword)cGroup_1_6_2_3.eContents().get(0);
		private final Assignment cUseTypesAssignment_1_6_2_3_1 = (Assignment)cGroup_1_6_2_3.eContents().get(1);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_1_6_2_3_1_0 = (CrossReference)cUseTypesAssignment_1_6_2_3_1.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_1_6_2_3_1_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_1_6_2_3_1_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_1_6_2_4 = (Keyword)cGroup_1_6_2.eContents().get(4);
		private final Group cGroup_1_6_3 = (Group)cGroup_1_6.eContents().get(3);
		private final Keyword cExtendsKeyword_1_6_3_0 = (Keyword)cGroup_1_6_3.eContents().get(0);
		private final Assignment cExtendsAssignment_1_6_3_1 = (Assignment)cGroup_1_6_3.eContents().get(1);
		private final CrossReference cExtendsErrorModelLibraryCrossReference_1_6_3_1_0 = (CrossReference)cExtendsAssignment_1_6_3_1.eContents().get(0);
		private final RuleCall cExtendsErrorModelLibraryQEMREFParserRuleCall_1_6_3_1_0_1 = (RuleCall)cExtendsErrorModelLibraryCrossReference_1_6_3_1_0.eContents().get(1);
		private final Group cGroup_1_6_3_2 = (Group)cGroup_1_6_3.eContents().get(2);
		private final Keyword cCommaKeyword_1_6_3_2_0 = (Keyword)cGroup_1_6_3_2.eContents().get(0);
		private final Assignment cExtendsAssignment_1_6_3_2_1 = (Assignment)cGroup_1_6_3_2.eContents().get(1);
		private final CrossReference cExtendsErrorModelLibraryCrossReference_1_6_3_2_1_0 = (CrossReference)cExtendsAssignment_1_6_3_2_1.eContents().get(0);
		private final RuleCall cExtendsErrorModelLibraryQEMREFParserRuleCall_1_6_3_2_1_0_1 = (RuleCall)cExtendsErrorModelLibraryCrossReference_1_6_3_2_1_0.eContents().get(1);
		private final Keyword cWithKeyword_1_6_3_3 = (Keyword)cGroup_1_6_3.eContents().get(3);
		private final Alternatives cAlternatives_1_6_4 = (Alternatives)cGroup_1_6.eContents().get(4);
		private final Assignment cTypesAssignment_1_6_4_0 = (Assignment)cAlternatives_1_6_4.eContents().get(0);
		private final RuleCall cTypesTypeDefinitionParserRuleCall_1_6_4_0_0 = (RuleCall)cTypesAssignment_1_6_4_0.eContents().get(0);
		private final Assignment cTypesetsAssignment_1_6_4_1 = (Assignment)cAlternatives_1_6_4.eContents().get(1);
		private final RuleCall cTypesetsTypeSetDefinitionParserRuleCall_1_6_4_1_0 = (RuleCall)cTypesetsAssignment_1_6_4_1.eContents().get(0);
		private final Group cGroup_1_6_5 = (Group)cGroup_1_6.eContents().get(5);
		private final Keyword cPropertiesKeyword_1_6_5_0 = (Keyword)cGroup_1_6_5.eContents().get(0);
		private final Assignment cPropertiesAssignment_1_6_5_1 = (Assignment)cGroup_1_6_5.eContents().get(1);
		private final RuleCall cPropertiesBasicEMV2PropertyAssociationParserRuleCall_1_6_5_1_0 = (RuleCall)cPropertiesAssignment_1_6_5_1.eContents().get(0);
		private final Keyword cEndKeyword_1_6_6 = (Keyword)cGroup_1_6.eContents().get(6);
		private final Keyword cTypesKeyword_1_6_7 = (Keyword)cGroup_1_6.eContents().get(7);
		private final Keyword cSemicolonKeyword_1_6_8 = (Keyword)cGroup_1_6.eContents().get(8);
		private final Assignment cBehaviorsAssignment_1_7 = (Assignment)cGroup_1.eContents().get(7);
		private final RuleCall cBehaviorsErrorBehaviorStateMachineParserRuleCall_1_7_0 = (RuleCall)cBehaviorsAssignment_1_7.eContents().get(0);
		private final Assignment cMappingsAssignment_1_8 = (Assignment)cGroup_1.eContents().get(8);
		private final RuleCall cMappingsTypeMappingSetParserRuleCall_1_8_0 = (RuleCall)cMappingsAssignment_1_8.eContents().get(0);
		private final Assignment cTransformationsAssignment_1_9 = (Assignment)cGroup_1.eContents().get(9);
		private final RuleCall cTransformationsTypeTransformationSetParserRuleCall_1_9_0 = (RuleCall)cTransformationsAssignment_1_9.eContents().get(0);
		private final Keyword cAsteriskAsteriskRightCurlyBracketKeyword_1_10 = (Keyword)cGroup_1.eContents().get(10);
		private final Keyword cSemicolonKeyword_1_11 = (Keyword)cGroup_1.eContents().get(11);
		private final Keyword cEndKeyword_1_12 = (Keyword)cGroup_1.eContents().get(12);
		private final RuleCall cQEMREFParserRuleCall_1_13 = (RuleCall)cGroup_1.eContents().get(13);
		private final Keyword cSemicolonKeyword_1_14 = (Keyword)cGroup_1.eContents().get(14);
		
		//EMV2Library ErrorModelLibrary:
		//	{ErrorModelLibrary} ('library' name=QEMREF ('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('extends' extends+=[ErrorModelLibrary|QEMREF] (','
		//	extends+=[ErrorModelLibrary|QEMREF])*
		//	'with')? (types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties'
		//	properties+=BasicEMV2PropertyAssociation+)?
		//	'end' 'types' ';')?
		//	behaviors+=ErrorBehaviorStateMachine*
		//	mappings+=TypeMappingSet*
		//	transformations+=TypeTransformationSet*) | 'package' name=QEMREF 'public'
		//	'annex' ID '{**' ('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('extends' extends+=[ErrorModelLibrary|QEMREF] (','
		//	extends+=[ErrorModelLibrary|QEMREF])*
		//	'with')? (types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties'
		//	properties+=BasicEMV2PropertyAssociation+)?
		//	'end' 'types' ';')?
		//	behaviors+=ErrorBehaviorStateMachine*
		//	mappings+=TypeMappingSet*
		//	transformations+=TypeTransformationSet*
		//	'**}' ';' 'end' QEMREF ';';
		@Override public ParserRule getRule() { return rule; }
		
		//{ErrorModelLibrary} ('library' name=QEMREF ('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('extends' extends+=[ErrorModelLibrary|QEMREF] (','
		//extends+=[ErrorModelLibrary|QEMREF])* 'with')? (types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties'
		//properties+=BasicEMV2PropertyAssociation+)? 'end' 'types' ';')? behaviors+=ErrorBehaviorStateMachine*
		//mappings+=TypeMappingSet* transformations+=TypeTransformationSet*) | 'package' name=QEMREF 'public' 'annex' ID '{**'
		//('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		//('extends' extends+=[ErrorModelLibrary|QEMREF] (',' extends+=[ErrorModelLibrary|QEMREF])* 'with')?
		//(types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties' properties+=BasicEMV2PropertyAssociation+)? 'end'
		//'types' ';')? behaviors+=ErrorBehaviorStateMachine* mappings+=TypeMappingSet* transformations+=TypeTransformationSet*
		//'**}' ';' 'end' QEMREF ';'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{ErrorModelLibrary} ('library' name=QEMREF ('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('extends' extends+=[ErrorModelLibrary|QEMREF] (','
		//extends+=[ErrorModelLibrary|QEMREF])* 'with')? (types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties'
		//properties+=BasicEMV2PropertyAssociation+)? 'end' 'types' ';')? behaviors+=ErrorBehaviorStateMachine*
		//mappings+=TypeMappingSet* transformations+=TypeTransformationSet*)
		public Group getGroup_0() { return cGroup_0; }
		
		//{ErrorModelLibrary}
		public Action getErrorModelLibraryAction_0_0() { return cErrorModelLibraryAction_0_0; }
		
		//('library' name=QEMREF ('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('extends' extends+=[ErrorModelLibrary|QEMREF] (','
		//extends+=[ErrorModelLibrary|QEMREF])* 'with')? (types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties'
		//properties+=BasicEMV2PropertyAssociation+)? 'end' 'types' ';')? behaviors+=ErrorBehaviorStateMachine*
		//mappings+=TypeMappingSet* transformations+=TypeTransformationSet*)
		public Group getGroup_0_1() { return cGroup_0_1; }
		
		//'library'
		public Keyword getLibraryKeyword_0_1_0() { return cLibraryKeyword_0_1_0; }
		
		//name=QEMREF
		public Assignment getNameAssignment_0_1_1() { return cNameAssignment_0_1_1; }
		
		//QEMREF
		public RuleCall getNameQEMREFParserRuleCall_0_1_1_0() { return cNameQEMREFParserRuleCall_0_1_1_0; }
		
		//('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		//('extends' extends+=[ErrorModelLibrary|QEMREF] (',' extends+=[ErrorModelLibrary|QEMREF])* 'with')?
		//(types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties' properties+=BasicEMV2PropertyAssociation+)? 'end'
		//'types' ';')?
		public Group getGroup_0_1_2() { return cGroup_0_1_2; }
		
		//'error'
		public Keyword getErrorKeyword_0_1_2_0() { return cErrorKeyword_0_1_2_0; }
		
		//'types'
		public Keyword getTypesKeyword_0_1_2_1() { return cTypesKeyword_0_1_2_1; }
		
		//('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		public Group getGroup_0_1_2_2() { return cGroup_0_1_2_2; }
		
		//'use'
		public Keyword getUseKeyword_0_1_2_2_0() { return cUseKeyword_0_1_2_2_0; }
		
		//'types'
		public Keyword getTypesKeyword_0_1_2_2_1() { return cTypesKeyword_0_1_2_2_1; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_0_1_2_2_2() { return cUseTypesAssignment_0_1_2_2_2; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_0_1_2_2_2_0() { return cUseTypesErrorModelLibraryCrossReference_0_1_2_2_2_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_0_1_2_2_2_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_0_1_2_2_2_0_1; }
		
		//(',' useTypes+=[ErrorModelLibrary|QEMREF])*
		public Group getGroup_0_1_2_2_3() { return cGroup_0_1_2_2_3; }
		
		//','
		public Keyword getCommaKeyword_0_1_2_2_3_0() { return cCommaKeyword_0_1_2_2_3_0; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_0_1_2_2_3_1() { return cUseTypesAssignment_0_1_2_2_3_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_0_1_2_2_3_1_0() { return cUseTypesErrorModelLibraryCrossReference_0_1_2_2_3_1_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_0_1_2_2_3_1_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_0_1_2_2_3_1_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_0_1_2_2_4() { return cSemicolonKeyword_0_1_2_2_4; }
		
		//('extends' extends+=[ErrorModelLibrary|QEMREF] (',' extends+=[ErrorModelLibrary|QEMREF])* 'with')?
		public Group getGroup_0_1_2_3() { return cGroup_0_1_2_3; }
		
		//'extends'
		public Keyword getExtendsKeyword_0_1_2_3_0() { return cExtendsKeyword_0_1_2_3_0; }
		
		//extends+=[ErrorModelLibrary|QEMREF]
		public Assignment getExtendsAssignment_0_1_2_3_1() { return cExtendsAssignment_0_1_2_3_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getExtendsErrorModelLibraryCrossReference_0_1_2_3_1_0() { return cExtendsErrorModelLibraryCrossReference_0_1_2_3_1_0; }
		
		//QEMREF
		public RuleCall getExtendsErrorModelLibraryQEMREFParserRuleCall_0_1_2_3_1_0_1() { return cExtendsErrorModelLibraryQEMREFParserRuleCall_0_1_2_3_1_0_1; }
		
		//(',' extends+=[ErrorModelLibrary|QEMREF])*
		public Group getGroup_0_1_2_3_2() { return cGroup_0_1_2_3_2; }
		
		//','
		public Keyword getCommaKeyword_0_1_2_3_2_0() { return cCommaKeyword_0_1_2_3_2_0; }
		
		//extends+=[ErrorModelLibrary|QEMREF]
		public Assignment getExtendsAssignment_0_1_2_3_2_1() { return cExtendsAssignment_0_1_2_3_2_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getExtendsErrorModelLibraryCrossReference_0_1_2_3_2_1_0() { return cExtendsErrorModelLibraryCrossReference_0_1_2_3_2_1_0; }
		
		//QEMREF
		public RuleCall getExtendsErrorModelLibraryQEMREFParserRuleCall_0_1_2_3_2_1_0_1() { return cExtendsErrorModelLibraryQEMREFParserRuleCall_0_1_2_3_2_1_0_1; }
		
		//'with'
		public Keyword getWithKeyword_0_1_2_3_3() { return cWithKeyword_0_1_2_3_3; }
		
		//(types+=TypeDefinition | typesets+=TypeSetDefinition)*
		public Alternatives getAlternatives_0_1_2_4() { return cAlternatives_0_1_2_4; }
		
		//types+=TypeDefinition
		public Assignment getTypesAssignment_0_1_2_4_0() { return cTypesAssignment_0_1_2_4_0; }
		
		//TypeDefinition
		public RuleCall getTypesTypeDefinitionParserRuleCall_0_1_2_4_0_0() { return cTypesTypeDefinitionParserRuleCall_0_1_2_4_0_0; }
		
		//typesets+=TypeSetDefinition
		public Assignment getTypesetsAssignment_0_1_2_4_1() { return cTypesetsAssignment_0_1_2_4_1; }
		
		//TypeSetDefinition
		public RuleCall getTypesetsTypeSetDefinitionParserRuleCall_0_1_2_4_1_0() { return cTypesetsTypeSetDefinitionParserRuleCall_0_1_2_4_1_0; }
		
		//('properties' properties+=BasicEMV2PropertyAssociation+)?
		public Group getGroup_0_1_2_5() { return cGroup_0_1_2_5; }
		
		//'properties'
		public Keyword getPropertiesKeyword_0_1_2_5_0() { return cPropertiesKeyword_0_1_2_5_0; }
		
		//properties+=BasicEMV2PropertyAssociation+
		public Assignment getPropertiesAssignment_0_1_2_5_1() { return cPropertiesAssignment_0_1_2_5_1; }
		
		//BasicEMV2PropertyAssociation
		public RuleCall getPropertiesBasicEMV2PropertyAssociationParserRuleCall_0_1_2_5_1_0() { return cPropertiesBasicEMV2PropertyAssociationParserRuleCall_0_1_2_5_1_0; }
		
		//'end'
		public Keyword getEndKeyword_0_1_2_6() { return cEndKeyword_0_1_2_6; }
		
		//'types'
		public Keyword getTypesKeyword_0_1_2_7() { return cTypesKeyword_0_1_2_7; }
		
		//';'
		public Keyword getSemicolonKeyword_0_1_2_8() { return cSemicolonKeyword_0_1_2_8; }
		
		//behaviors+=ErrorBehaviorStateMachine*
		public Assignment getBehaviorsAssignment_0_1_3() { return cBehaviorsAssignment_0_1_3; }
		
		//ErrorBehaviorStateMachine
		public RuleCall getBehaviorsErrorBehaviorStateMachineParserRuleCall_0_1_3_0() { return cBehaviorsErrorBehaviorStateMachineParserRuleCall_0_1_3_0; }
		
		//mappings+=TypeMappingSet*
		public Assignment getMappingsAssignment_0_1_4() { return cMappingsAssignment_0_1_4; }
		
		//TypeMappingSet
		public RuleCall getMappingsTypeMappingSetParserRuleCall_0_1_4_0() { return cMappingsTypeMappingSetParserRuleCall_0_1_4_0; }
		
		//transformations+=TypeTransformationSet*
		public Assignment getTransformationsAssignment_0_1_5() { return cTransformationsAssignment_0_1_5; }
		
		//TypeTransformationSet
		public RuleCall getTransformationsTypeTransformationSetParserRuleCall_0_1_5_0() { return cTransformationsTypeTransformationSetParserRuleCall_0_1_5_0; }
		
		//'package' name=QEMREF 'public' 'annex' ID '{**' ('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF]
		//(',' useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('extends' extends+=[ErrorModelLibrary|QEMREF] (','
		//extends+=[ErrorModelLibrary|QEMREF])* 'with')? (types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties'
		//properties+=BasicEMV2PropertyAssociation+)? 'end' 'types' ';')? behaviors+=ErrorBehaviorStateMachine*
		//mappings+=TypeMappingSet* transformations+=TypeTransformationSet* '**}' ';' 'end' QEMREF ';'
		public Group getGroup_1() { return cGroup_1; }
		
		//'package'
		public Keyword getPackageKeyword_1_0() { return cPackageKeyword_1_0; }
		
		//name=QEMREF
		public Assignment getNameAssignment_1_1() { return cNameAssignment_1_1; }
		
		//QEMREF
		public RuleCall getNameQEMREFParserRuleCall_1_1_0() { return cNameQEMREFParserRuleCall_1_1_0; }
		
		//'public'
		public Keyword getPublicKeyword_1_2() { return cPublicKeyword_1_2; }
		
		//'annex'
		public Keyword getAnnexKeyword_1_3() { return cAnnexKeyword_1_3; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_4() { return cIDTerminalRuleCall_1_4; }
		
		//'{**'
		public Keyword getLeftCurlyBracketAsteriskAsteriskKeyword_1_5() { return cLeftCurlyBracketAsteriskAsteriskKeyword_1_5; }
		
		//('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		//('extends' extends+=[ErrorModelLibrary|QEMREF] (',' extends+=[ErrorModelLibrary|QEMREF])* 'with')?
		//(types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties' properties+=BasicEMV2PropertyAssociation+)? 'end'
		//'types' ';')?
		public Group getGroup_1_6() { return cGroup_1_6; }
		
		//'error'
		public Keyword getErrorKeyword_1_6_0() { return cErrorKeyword_1_6_0; }
		
		//'types'
		public Keyword getTypesKeyword_1_6_1() { return cTypesKeyword_1_6_1; }
		
		//('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		public Group getGroup_1_6_2() { return cGroup_1_6_2; }
		
		//'use'
		public Keyword getUseKeyword_1_6_2_0() { return cUseKeyword_1_6_2_0; }
		
		//'types'
		public Keyword getTypesKeyword_1_6_2_1() { return cTypesKeyword_1_6_2_1; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_1_6_2_2() { return cUseTypesAssignment_1_6_2_2; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_1_6_2_2_0() { return cUseTypesErrorModelLibraryCrossReference_1_6_2_2_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_6_2_2_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_1_6_2_2_0_1; }
		
		//(',' useTypes+=[ErrorModelLibrary|QEMREF])*
		public Group getGroup_1_6_2_3() { return cGroup_1_6_2_3; }
		
		//','
		public Keyword getCommaKeyword_1_6_2_3_0() { return cCommaKeyword_1_6_2_3_0; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_1_6_2_3_1() { return cUseTypesAssignment_1_6_2_3_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_1_6_2_3_1_0() { return cUseTypesErrorModelLibraryCrossReference_1_6_2_3_1_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_6_2_3_1_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_1_6_2_3_1_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_1_6_2_4() { return cSemicolonKeyword_1_6_2_4; }
		
		//('extends' extends+=[ErrorModelLibrary|QEMREF] (',' extends+=[ErrorModelLibrary|QEMREF])* 'with')?
		public Group getGroup_1_6_3() { return cGroup_1_6_3; }
		
		//'extends'
		public Keyword getExtendsKeyword_1_6_3_0() { return cExtendsKeyword_1_6_3_0; }
		
		//extends+=[ErrorModelLibrary|QEMREF]
		public Assignment getExtendsAssignment_1_6_3_1() { return cExtendsAssignment_1_6_3_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getExtendsErrorModelLibraryCrossReference_1_6_3_1_0() { return cExtendsErrorModelLibraryCrossReference_1_6_3_1_0; }
		
		//QEMREF
		public RuleCall getExtendsErrorModelLibraryQEMREFParserRuleCall_1_6_3_1_0_1() { return cExtendsErrorModelLibraryQEMREFParserRuleCall_1_6_3_1_0_1; }
		
		//(',' extends+=[ErrorModelLibrary|QEMREF])*
		public Group getGroup_1_6_3_2() { return cGroup_1_6_3_2; }
		
		//','
		public Keyword getCommaKeyword_1_6_3_2_0() { return cCommaKeyword_1_6_3_2_0; }
		
		//extends+=[ErrorModelLibrary|QEMREF]
		public Assignment getExtendsAssignment_1_6_3_2_1() { return cExtendsAssignment_1_6_3_2_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getExtendsErrorModelLibraryCrossReference_1_6_3_2_1_0() { return cExtendsErrorModelLibraryCrossReference_1_6_3_2_1_0; }
		
		//QEMREF
		public RuleCall getExtendsErrorModelLibraryQEMREFParserRuleCall_1_6_3_2_1_0_1() { return cExtendsErrorModelLibraryQEMREFParserRuleCall_1_6_3_2_1_0_1; }
		
		//'with'
		public Keyword getWithKeyword_1_6_3_3() { return cWithKeyword_1_6_3_3; }
		
		//(types+=TypeDefinition | typesets+=TypeSetDefinition)*
		public Alternatives getAlternatives_1_6_4() { return cAlternatives_1_6_4; }
		
		//types+=TypeDefinition
		public Assignment getTypesAssignment_1_6_4_0() { return cTypesAssignment_1_6_4_0; }
		
		//TypeDefinition
		public RuleCall getTypesTypeDefinitionParserRuleCall_1_6_4_0_0() { return cTypesTypeDefinitionParserRuleCall_1_6_4_0_0; }
		
		//typesets+=TypeSetDefinition
		public Assignment getTypesetsAssignment_1_6_4_1() { return cTypesetsAssignment_1_6_4_1; }
		
		//TypeSetDefinition
		public RuleCall getTypesetsTypeSetDefinitionParserRuleCall_1_6_4_1_0() { return cTypesetsTypeSetDefinitionParserRuleCall_1_6_4_1_0; }
		
		//('properties' properties+=BasicEMV2PropertyAssociation+)?
		public Group getGroup_1_6_5() { return cGroup_1_6_5; }
		
		//'properties'
		public Keyword getPropertiesKeyword_1_6_5_0() { return cPropertiesKeyword_1_6_5_0; }
		
		//properties+=BasicEMV2PropertyAssociation+
		public Assignment getPropertiesAssignment_1_6_5_1() { return cPropertiesAssignment_1_6_5_1; }
		
		//BasicEMV2PropertyAssociation
		public RuleCall getPropertiesBasicEMV2PropertyAssociationParserRuleCall_1_6_5_1_0() { return cPropertiesBasicEMV2PropertyAssociationParserRuleCall_1_6_5_1_0; }
		
		//'end'
		public Keyword getEndKeyword_1_6_6() { return cEndKeyword_1_6_6; }
		
		//'types'
		public Keyword getTypesKeyword_1_6_7() { return cTypesKeyword_1_6_7; }
		
		//';'
		public Keyword getSemicolonKeyword_1_6_8() { return cSemicolonKeyword_1_6_8; }
		
		//behaviors+=ErrorBehaviorStateMachine*
		public Assignment getBehaviorsAssignment_1_7() { return cBehaviorsAssignment_1_7; }
		
		//ErrorBehaviorStateMachine
		public RuleCall getBehaviorsErrorBehaviorStateMachineParserRuleCall_1_7_0() { return cBehaviorsErrorBehaviorStateMachineParserRuleCall_1_7_0; }
		
		//mappings+=TypeMappingSet*
		public Assignment getMappingsAssignment_1_8() { return cMappingsAssignment_1_8; }
		
		//TypeMappingSet
		public RuleCall getMappingsTypeMappingSetParserRuleCall_1_8_0() { return cMappingsTypeMappingSetParserRuleCall_1_8_0; }
		
		//transformations+=TypeTransformationSet*
		public Assignment getTransformationsAssignment_1_9() { return cTransformationsAssignment_1_9; }
		
		//TypeTransformationSet
		public RuleCall getTransformationsTypeTransformationSetParserRuleCall_1_9_0() { return cTransformationsTypeTransformationSetParserRuleCall_1_9_0; }
		
		//'**}'
		public Keyword getAsteriskAsteriskRightCurlyBracketKeyword_1_10() { return cAsteriskAsteriskRightCurlyBracketKeyword_1_10; }
		
		//';'
		public Keyword getSemicolonKeyword_1_11() { return cSemicolonKeyword_1_11; }
		
		//'end'
		public Keyword getEndKeyword_1_12() { return cEndKeyword_1_12; }
		
		//QEMREF
		public RuleCall getQEMREFParserRuleCall_1_13() { return cQEMREFParserRuleCall_1_13; }
		
		//';'
		public Keyword getSemicolonKeyword_1_14() { return cSemicolonKeyword_1_14; }
	}
	public class EMV2PropertyAssociationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2PropertyAssociation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPropertyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cPropertyPropertyCrossReference_0_0 = (CrossReference)cPropertyAssignment_0.eContents().get(0);
		private final RuleCall cPropertyPropertyQPREFParserRuleCall_0_0_1 = (RuleCall)cPropertyPropertyCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cOwnedValuesAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOwnedValuesOptionalModalPropertyValueParserRuleCall_2_0_0 = (RuleCall)cOwnedValuesAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cOwnedValuesAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOwnedValuesOptionalModalPropertyValueParserRuleCall_2_1_1_0 = (RuleCall)cOwnedValuesAssignment_2_1_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cAppliesKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cToKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Group cGroup_3_2 = (Group)cGroup_3.eContents().get(2);
		private final Assignment cEmv2PathAssignment_3_2_0 = (Assignment)cGroup_3_2.eContents().get(0);
		private final RuleCall cEmv2PathEMV2PathParserRuleCall_3_2_0_0 = (RuleCall)cEmv2PathAssignment_3_2_0.eContents().get(0);
		private final Group cGroup_3_2_1 = (Group)cGroup_3_2.eContents().get(1);
		private final Keyword cCommaKeyword_3_2_1_0 = (Keyword)cGroup_3_2_1.eContents().get(0);
		private final Assignment cEmv2PathAssignment_3_2_1_1 = (Assignment)cGroup_3_2_1.eContents().get(1);
		private final RuleCall cEmv2PathEMV2PathParserRuleCall_3_2_1_1_0 = (RuleCall)cEmv2PathAssignment_3_2_1_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//EMV2PropertyAssociation:
		//	property=[aadl2::Property|QPREF]
		//	'=>' (ownedValues+=OptionalModalPropertyValue (',' ownedValues+=OptionalModalPropertyValue)*) ('applies' 'to'
		//	(emv2Path+=EMV2Path (',' emv2Path+=EMV2Path)*))?
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//property=[aadl2::Property|QPREF] '=>' (ownedValues+=OptionalModalPropertyValue (','
		//ownedValues+=OptionalModalPropertyValue)*) ('applies' 'to' (emv2Path+=EMV2Path (',' emv2Path+=EMV2Path)*))? ';'
		public Group getGroup() { return cGroup; }
		
		//property=[aadl2::Property|QPREF]
		public Assignment getPropertyAssignment_0() { return cPropertyAssignment_0; }
		
		//[aadl2::Property|QPREF]
		public CrossReference getPropertyPropertyCrossReference_0_0() { return cPropertyPropertyCrossReference_0_0; }
		
		//QPREF
		public RuleCall getPropertyPropertyQPREFParserRuleCall_0_0_1() { return cPropertyPropertyQPREFParserRuleCall_0_0_1; }
		
		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_1() { return cEqualsSignGreaterThanSignKeyword_1; }
		
		//(ownedValues+=OptionalModalPropertyValue (',' ownedValues+=OptionalModalPropertyValue)*)
		public Group getGroup_2() { return cGroup_2; }
		
		//ownedValues+=OptionalModalPropertyValue
		public Assignment getOwnedValuesAssignment_2_0() { return cOwnedValuesAssignment_2_0; }
		
		//OptionalModalPropertyValue
		public RuleCall getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_0_0() { return cOwnedValuesOptionalModalPropertyValueParserRuleCall_2_0_0; }
		
		//(',' ownedValues+=OptionalModalPropertyValue)*
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//','
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }
		
		//ownedValues+=OptionalModalPropertyValue
		public Assignment getOwnedValuesAssignment_2_1_1() { return cOwnedValuesAssignment_2_1_1; }
		
		//OptionalModalPropertyValue
		public RuleCall getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_1_1_0() { return cOwnedValuesOptionalModalPropertyValueParserRuleCall_2_1_1_0; }
		
		//('applies' 'to' (emv2Path+=EMV2Path (',' emv2Path+=EMV2Path)*))?
		public Group getGroup_3() { return cGroup_3; }
		
		//'applies'
		public Keyword getAppliesKeyword_3_0() { return cAppliesKeyword_3_0; }
		
		//'to'
		public Keyword getToKeyword_3_1() { return cToKeyword_3_1; }
		
		//(emv2Path+=EMV2Path (',' emv2Path+=EMV2Path)*)
		public Group getGroup_3_2() { return cGroup_3_2; }
		
		//emv2Path+=EMV2Path
		public Assignment getEmv2PathAssignment_3_2_0() { return cEmv2PathAssignment_3_2_0; }
		
		//EMV2Path
		public RuleCall getEmv2PathEMV2PathParserRuleCall_3_2_0_0() { return cEmv2PathEMV2PathParserRuleCall_3_2_0_0; }
		
		//(',' emv2Path+=EMV2Path)*
		public Group getGroup_3_2_1() { return cGroup_3_2_1; }
		
		//','
		public Keyword getCommaKeyword_3_2_1_0() { return cCommaKeyword_3_2_1_0; }
		
		//emv2Path+=EMV2Path
		public Assignment getEmv2PathAssignment_3_2_1_1() { return cEmv2PathAssignment_3_2_1_1; }
		
		//EMV2Path
		public RuleCall getEmv2PathEMV2PathParserRuleCall_3_2_1_1_0() { return cEmv2PathEMV2PathParserRuleCall_3_2_1_1_0; }
		
		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}
	public class BasicEMV2PropertyAssociationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.BasicEMV2PropertyAssociation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPropertyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cPropertyPropertyCrossReference_0_0 = (CrossReference)cPropertyAssignment_0.eContents().get(0);
		private final RuleCall cPropertyPropertyQPREFParserRuleCall_0_0_1 = (RuleCall)cPropertyPropertyCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cOwnedValuesAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOwnedValuesOptionalModalPropertyValueParserRuleCall_2_0_0 = (RuleCall)cOwnedValuesAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cOwnedValuesAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOwnedValuesOptionalModalPropertyValueParserRuleCall_2_1_1_0 = (RuleCall)cOwnedValuesAssignment_2_1_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cAppliesKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cToKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Group cGroup_3_2 = (Group)cGroup_3.eContents().get(2);
		private final Assignment cEmv2PathAssignment_3_2_0 = (Assignment)cGroup_3_2.eContents().get(0);
		private final RuleCall cEmv2PathBasicEMV2PathParserRuleCall_3_2_0_0 = (RuleCall)cEmv2PathAssignment_3_2_0.eContents().get(0);
		private final Group cGroup_3_2_1 = (Group)cGroup_3_2.eContents().get(1);
		private final Keyword cCommaKeyword_3_2_1_0 = (Keyword)cGroup_3_2_1.eContents().get(0);
		private final Assignment cEmv2PathAssignment_3_2_1_1 = (Assignment)cGroup_3_2_1.eContents().get(1);
		private final RuleCall cEmv2PathBasicEMV2PathParserRuleCall_3_2_1_1_0 = (RuleCall)cEmv2PathAssignment_3_2_1_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//BasicEMV2PropertyAssociation EMV2PropertyAssociation:
		//	property=[aadl2::Property|QPREF]
		//	'=>' (ownedValues+=OptionalModalPropertyValue (',' ownedValues+=OptionalModalPropertyValue)*) ('applies' 'to'
		//	(emv2Path+=BasicEMV2Path (',' emv2Path+=BasicEMV2Path)*))?
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//property=[aadl2::Property|QPREF] '=>' (ownedValues+=OptionalModalPropertyValue (','
		//ownedValues+=OptionalModalPropertyValue)*) ('applies' 'to' (emv2Path+=BasicEMV2Path (',' emv2Path+=BasicEMV2Path)*))?
		//';'
		public Group getGroup() { return cGroup; }
		
		//property=[aadl2::Property|QPREF]
		public Assignment getPropertyAssignment_0() { return cPropertyAssignment_0; }
		
		//[aadl2::Property|QPREF]
		public CrossReference getPropertyPropertyCrossReference_0_0() { return cPropertyPropertyCrossReference_0_0; }
		
		//QPREF
		public RuleCall getPropertyPropertyQPREFParserRuleCall_0_0_1() { return cPropertyPropertyQPREFParserRuleCall_0_0_1; }
		
		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_1() { return cEqualsSignGreaterThanSignKeyword_1; }
		
		//(ownedValues+=OptionalModalPropertyValue (',' ownedValues+=OptionalModalPropertyValue)*)
		public Group getGroup_2() { return cGroup_2; }
		
		//ownedValues+=OptionalModalPropertyValue
		public Assignment getOwnedValuesAssignment_2_0() { return cOwnedValuesAssignment_2_0; }
		
		//OptionalModalPropertyValue
		public RuleCall getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_0_0() { return cOwnedValuesOptionalModalPropertyValueParserRuleCall_2_0_0; }
		
		//(',' ownedValues+=OptionalModalPropertyValue)*
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//','
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }
		
		//ownedValues+=OptionalModalPropertyValue
		public Assignment getOwnedValuesAssignment_2_1_1() { return cOwnedValuesAssignment_2_1_1; }
		
		//OptionalModalPropertyValue
		public RuleCall getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_1_1_0() { return cOwnedValuesOptionalModalPropertyValueParserRuleCall_2_1_1_0; }
		
		//('applies' 'to' (emv2Path+=BasicEMV2Path (',' emv2Path+=BasicEMV2Path)*))?
		public Group getGroup_3() { return cGroup_3; }
		
		//'applies'
		public Keyword getAppliesKeyword_3_0() { return cAppliesKeyword_3_0; }
		
		//'to'
		public Keyword getToKeyword_3_1() { return cToKeyword_3_1; }
		
		//(emv2Path+=BasicEMV2Path (',' emv2Path+=BasicEMV2Path)*)
		public Group getGroup_3_2() { return cGroup_3_2; }
		
		//emv2Path+=BasicEMV2Path
		public Assignment getEmv2PathAssignment_3_2_0() { return cEmv2PathAssignment_3_2_0; }
		
		//BasicEMV2Path
		public RuleCall getEmv2PathBasicEMV2PathParserRuleCall_3_2_0_0() { return cEmv2PathBasicEMV2PathParserRuleCall_3_2_0_0; }
		
		//(',' emv2Path+=BasicEMV2Path)*
		public Group getGroup_3_2_1() { return cGroup_3_2_1; }
		
		//','
		public Keyword getCommaKeyword_3_2_1_0() { return cCommaKeyword_3_2_1_0; }
		
		//emv2Path+=BasicEMV2Path
		public Assignment getEmv2PathAssignment_3_2_1_1() { return cEmv2PathAssignment_3_2_1_1; }
		
		//BasicEMV2Path
		public RuleCall getEmv2PathBasicEMV2PathParserRuleCall_3_2_1_1_0() { return cEmv2PathBasicEMV2PathParserRuleCall_3_2_1_1_0; }
		
		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}
	public class EMV2PathElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2Path");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cCircumflexAccentKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cContainmentPathAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cContainmentPathContainmentPathElementParserRuleCall_0_1_0 = (RuleCall)cContainmentPathAssignment_0_1.eContents().get(0);
		private final Keyword cCommercialAtKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final Assignment cEmv2TargetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cEmv2TargetEMV2PathElementOrKindParserRuleCall_1_0 = (RuleCall)cEmv2TargetAssignment_1.eContents().get(0);
		
		//EMV2Path:
		//	('^' containmentPath=ContainmentPathElement '@')?
		//	emv2Target=EMV2PathElementOrKind;
		@Override public ParserRule getRule() { return rule; }
		
		//('^' containmentPath=ContainmentPathElement '@')? emv2Target=EMV2PathElementOrKind
		public Group getGroup() { return cGroup; }
		
		//('^' containmentPath=ContainmentPathElement '@')?
		public Group getGroup_0() { return cGroup_0; }
		
		//'^'
		public Keyword getCircumflexAccentKeyword_0_0() { return cCircumflexAccentKeyword_0_0; }
		
		//containmentPath=ContainmentPathElement
		public Assignment getContainmentPathAssignment_0_1() { return cContainmentPathAssignment_0_1; }
		
		//ContainmentPathElement
		public RuleCall getContainmentPathContainmentPathElementParserRuleCall_0_1_0() { return cContainmentPathContainmentPathElementParserRuleCall_0_1_0; }
		
		//'@'
		public Keyword getCommercialAtKeyword_0_2() { return cCommercialAtKeyword_0_2; }
		
		//emv2Target=EMV2PathElementOrKind
		public Assignment getEmv2TargetAssignment_1() { return cEmv2TargetAssignment_1; }
		
		//EMV2PathElementOrKind
		public RuleCall getEmv2TargetEMV2PathElementOrKindParserRuleCall_1_0() { return cEmv2TargetEMV2PathElementOrKindParserRuleCall_1_0; }
	}
	public class BasicEMV2PathElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.BasicEMV2Path");
		private final Assignment cEmv2TargetAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cEmv2TargetEMV2PathElementOrKindParserRuleCall_0 = (RuleCall)cEmv2TargetAssignment.eContents().get(0);
		
		//BasicEMV2Path EMV2Path:
		//	emv2Target=EMV2PathElementOrKind;
		@Override public ParserRule getRule() { return rule; }
		
		//emv2Target=EMV2PathElementOrKind
		public Assignment getEmv2TargetAssignment() { return cEmv2TargetAssignment; }
		
		//EMV2PathElementOrKind
		public RuleCall getEmv2TargetEMV2PathElementOrKindParserRuleCall_0() { return cEmv2TargetEMV2PathElementOrKindParserRuleCall_0; }
	}
	public class EMV2PathElementOrKindElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2PathElementOrKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Assignment cEmv2PropagationKindAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cEmv2PropagationKindPropagationKindParserRuleCall_0_0_0 = (RuleCall)cEmv2PropagationKindAssignment_0_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Keyword cFullStopKeyword_0_1_0 = (Keyword)cGroup_0_1.eContents().get(0);
		private final Assignment cErrorTypeAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final CrossReference cErrorTypeErrorTypesCrossReference_0_1_1_0 = (CrossReference)cErrorTypeAssignment_0_1_1.eContents().get(0);
		private final RuleCall cErrorTypeErrorTypesIDTerminalRuleCall_0_1_1_0_1 = (RuleCall)cErrorTypeErrorTypesCrossReference_0_1_1_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Assignment cNamedElementAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final CrossReference cNamedElementNamedElementCrossReference_1_0_0 = (CrossReference)cNamedElementAssignment_1_0.eContents().get(0);
		private final RuleCall cNamedElementNamedElementIDTerminalRuleCall_1_0_0_1 = (RuleCall)cNamedElementNamedElementCrossReference_1_0_0.eContents().get(1);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cFullStopKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cPathAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cPathEMV2PathElementParserRuleCall_1_1_1_0 = (RuleCall)cPathAssignment_1_1_1.eContents().get(0);
		
		//EMV2PathElementOrKind EMV2PathElement:
		//	emv2PropagationKind=PropagationKind ('.' errorType=[ErrorTypes])?
		//	| namedElement=[aadl2::NamedElement] ('.' path=EMV2PathElement)?;
		@Override public ParserRule getRule() { return rule; }
		
		//emv2PropagationKind=PropagationKind ('.' errorType=[ErrorTypes])? | namedElement=[aadl2::NamedElement] ('.'
		//path=EMV2PathElement)?
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//emv2PropagationKind=PropagationKind ('.' errorType=[ErrorTypes])?
		public Group getGroup_0() { return cGroup_0; }
		
		//emv2PropagationKind=PropagationKind
		public Assignment getEmv2PropagationKindAssignment_0_0() { return cEmv2PropagationKindAssignment_0_0; }
		
		//PropagationKind
		public RuleCall getEmv2PropagationKindPropagationKindParserRuleCall_0_0_0() { return cEmv2PropagationKindPropagationKindParserRuleCall_0_0_0; }
		
		//('.' errorType=[ErrorTypes])?
		public Group getGroup_0_1() { return cGroup_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_0_1_0() { return cFullStopKeyword_0_1_0; }
		
		//errorType=[ErrorTypes]
		public Assignment getErrorTypeAssignment_0_1_1() { return cErrorTypeAssignment_0_1_1; }
		
		//[ErrorTypes]
		public CrossReference getErrorTypeErrorTypesCrossReference_0_1_1_0() { return cErrorTypeErrorTypesCrossReference_0_1_1_0; }
		
		//ID
		public RuleCall getErrorTypeErrorTypesIDTerminalRuleCall_0_1_1_0_1() { return cErrorTypeErrorTypesIDTerminalRuleCall_0_1_1_0_1; }
		
		//namedElement=[aadl2::NamedElement] ('.' path=EMV2PathElement)?
		public Group getGroup_1() { return cGroup_1; }
		
		//namedElement=[aadl2::NamedElement]
		public Assignment getNamedElementAssignment_1_0() { return cNamedElementAssignment_1_0; }
		
		//[aadl2::NamedElement]
		public CrossReference getNamedElementNamedElementCrossReference_1_0_0() { return cNamedElementNamedElementCrossReference_1_0_0; }
		
		//ID
		public RuleCall getNamedElementNamedElementIDTerminalRuleCall_1_0_0_1() { return cNamedElementNamedElementIDTerminalRuleCall_1_0_0_1; }
		
		//('.' path=EMV2PathElement)?
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_1_0() { return cFullStopKeyword_1_1_0; }
		
		//path=EMV2PathElement
		public Assignment getPathAssignment_1_1_1() { return cPathAssignment_1_1_1; }
		
		//EMV2PathElement
		public RuleCall getPathEMV2PathElementParserRuleCall_1_1_1_0() { return cPathEMV2PathElementParserRuleCall_1_1_1_0; }
	}
	public class EMV2PathElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2PathElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNamedElementAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cNamedElementNamedElementCrossReference_0_0 = (CrossReference)cNamedElementAssignment_0.eContents().get(0);
		private final RuleCall cNamedElementNamedElementIDTerminalRuleCall_0_0_1 = (RuleCall)cNamedElementNamedElementCrossReference_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cPathAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cPathEMV2PathElementParserRuleCall_1_1_0 = (RuleCall)cPathAssignment_1_1.eContents().get(0);
		
		//EMV2PathElement:
		//	namedElement=[aadl2::NamedElement] ('.' path=EMV2PathElement)?;
		@Override public ParserRule getRule() { return rule; }
		
		//namedElement=[aadl2::NamedElement] ('.' path=EMV2PathElement)?
		public Group getGroup() { return cGroup; }
		
		//namedElement=[aadl2::NamedElement]
		public Assignment getNamedElementAssignment_0() { return cNamedElementAssignment_0; }
		
		//[aadl2::NamedElement]
		public CrossReference getNamedElementNamedElementCrossReference_0_0() { return cNamedElementNamedElementCrossReference_0_0; }
		
		//ID
		public RuleCall getNamedElementNamedElementIDTerminalRuleCall_0_0_1() { return cNamedElementNamedElementIDTerminalRuleCall_0_0_1; }
		
		//('.' path=EMV2PathElement)?
		public Group getGroup_1() { return cGroup_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//path=EMV2PathElement
		public Assignment getPathAssignment_1_1() { return cPathAssignment_1_1; }
		
		//EMV2PathElement
		public RuleCall getPathEMV2PathElementParserRuleCall_1_1_0() { return cPathEMV2PathElementParserRuleCall_1_1_0; }
	}
	public class ErrorTypesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorTypes");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTypeDefinitionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTypeSetDefinitionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//ErrorTypes:
		//	TypeDefinition | TypeSetDefinition;
		@Override public ParserRule getRule() { return rule; }
		
		//TypeDefinition | TypeSetDefinition
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//TypeDefinition
		public RuleCall getTypeDefinitionParserRuleCall_0() { return cTypeDefinitionParserRuleCall_0; }
		
		//TypeSetDefinition
		public RuleCall getTypeSetDefinitionParserRuleCall_1() { return cTypeSetDefinitionParserRuleCall_1; }
	}
	public class TypeDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TypeDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Keyword cColonKeyword_1_0_0 = (Keyword)cGroup_1_0.eContents().get(0);
		private final Keyword cTypeKeyword_1_0_1 = (Keyword)cGroup_1_0.eContents().get(1);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Keyword cColonKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Keyword cTypeKeyword_1_1_1 = (Keyword)cGroup_1_1.eContents().get(1);
		private final Keyword cExtendsKeyword_1_1_2 = (Keyword)cGroup_1_1.eContents().get(2);
		private final Assignment cSuperTypeAssignment_1_1_3 = (Assignment)cGroup_1_1.eContents().get(3);
		private final CrossReference cSuperTypeErrorTypeCrossReference_1_1_3_0 = (CrossReference)cSuperTypeAssignment_1_1_3.eContents().get(0);
		private final RuleCall cSuperTypeErrorTypeQEMREFParserRuleCall_1_1_3_0_1 = (RuleCall)cSuperTypeErrorTypeCrossReference_1_1_3_0.eContents().get(1);
		private final Group cGroup_1_2 = (Group)cAlternatives_1.eContents().get(2);
		private final Keyword cRenamesKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Keyword cTypeKeyword_1_2_1 = (Keyword)cGroup_1_2.eContents().get(1);
		private final Assignment cAliasedTypeAssignment_1_2_2 = (Assignment)cGroup_1_2.eContents().get(2);
		private final CrossReference cAliasedTypeErrorTypeCrossReference_1_2_2_0 = (CrossReference)cAliasedTypeAssignment_1_2_2.eContents().get(0);
		private final RuleCall cAliasedTypeErrorTypeQEMREFParserRuleCall_1_2_2_0_1 = (RuleCall)cAliasedTypeErrorTypeCrossReference_1_2_2_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//TypeDefinition ErrorType:
		//	name=ID (':' 'type' | ':' 'type' 'extends' superType=[ErrorType|QEMREF] | 'renames' 'type'
		//	aliasedType=[ErrorType|QEMREF])
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID (':' 'type' | ':' 'type' 'extends' superType=[ErrorType|QEMREF] | 'renames' 'type'
		//aliasedType=[ErrorType|QEMREF]) ';'
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//(':' 'type' | ':' 'type' 'extends' superType=[ErrorType|QEMREF] | 'renames' 'type' aliasedType=[ErrorType|QEMREF])
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		///*
		//		 * The first two options used to be combined into the following option
		//		 * 		(':' 'type' ( 'extends' superType=[ErrorType|QEMREF] )? )
		//		 * 
		//		 * This was causing problems with serialization of simple types where both the
		//		 * superType and the aliasedType are null.  The serializer was throwing an
		//		 * IConcreteSyntaxValidator.InvalidConcreteSyntaxException complaining that
		//		 * aliasedType must be set.  The exception specifies the constraint being violated:
		//		 * 		(superType?|aliasedType)
		//		 * 
		//		 * It seems like the combined version should work and I don't know why it doesn't
		//		 * work.  For some reason, it works if the options are separated out.
		//		 */ ':' 'type'
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//':'
		public Keyword getColonKeyword_1_0_0() { return cColonKeyword_1_0_0; }
		
		//'type'
		public Keyword getTypeKeyword_1_0_1() { return cTypeKeyword_1_0_1; }
		
		//':' 'type' 'extends' superType=[ErrorType|QEMREF]
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//':'
		public Keyword getColonKeyword_1_1_0() { return cColonKeyword_1_1_0; }
		
		//'type'
		public Keyword getTypeKeyword_1_1_1() { return cTypeKeyword_1_1_1; }
		
		//'extends'
		public Keyword getExtendsKeyword_1_1_2() { return cExtendsKeyword_1_1_2; }
		
		//superType=[ErrorType|QEMREF]
		public Assignment getSuperTypeAssignment_1_1_3() { return cSuperTypeAssignment_1_1_3; }
		
		//[ErrorType|QEMREF]
		public CrossReference getSuperTypeErrorTypeCrossReference_1_1_3_0() { return cSuperTypeErrorTypeCrossReference_1_1_3_0; }
		
		//QEMREF
		public RuleCall getSuperTypeErrorTypeQEMREFParserRuleCall_1_1_3_0_1() { return cSuperTypeErrorTypeQEMREFParserRuleCall_1_1_3_0_1; }
		
		//'renames' 'type' aliasedType=[ErrorType|QEMREF]
		public Group getGroup_1_2() { return cGroup_1_2; }
		
		//'renames'
		public Keyword getRenamesKeyword_1_2_0() { return cRenamesKeyword_1_2_0; }
		
		//'type'
		public Keyword getTypeKeyword_1_2_1() { return cTypeKeyword_1_2_1; }
		
		//aliasedType=[ErrorType|QEMREF]
		public Assignment getAliasedTypeAssignment_1_2_2() { return cAliasedTypeAssignment_1_2_2; }
		
		//[ErrorType|QEMREF]
		public CrossReference getAliasedTypeErrorTypeCrossReference_1_2_2_0() { return cAliasedTypeErrorTypeCrossReference_1_2_2_0; }
		
		//QEMREF
		public RuleCall getAliasedTypeErrorTypeQEMREFParserRuleCall_1_2_2_0_1() { return cAliasedTypeErrorTypeQEMREFParserRuleCall_1_2_2_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}
	public class TypeSetDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Keyword cColonKeyword_1_0_0 = (Keyword)cGroup_1_0.eContents().get(0);
		private final Keyword cTypeKeyword_1_0_1 = (Keyword)cGroup_1_0.eContents().get(1);
		private final Keyword cSetKeyword_1_0_2 = (Keyword)cGroup_1_0.eContents().get(2);
		private final Keyword cLeftCurlyBracketKeyword_1_0_3 = (Keyword)cGroup_1_0.eContents().get(3);
		private final Assignment cTypeTokensAssignment_1_0_4 = (Assignment)cGroup_1_0.eContents().get(4);
		private final RuleCall cTypeTokensTypeSetElementParserRuleCall_1_0_4_0 = (RuleCall)cTypeTokensAssignment_1_0_4.eContents().get(0);
		private final Group cGroup_1_0_5 = (Group)cGroup_1_0.eContents().get(5);
		private final Keyword cCommaKeyword_1_0_5_0 = (Keyword)cGroup_1_0_5.eContents().get(0);
		private final Assignment cTypeTokensAssignment_1_0_5_1 = (Assignment)cGroup_1_0_5.eContents().get(1);
		private final RuleCall cTypeTokensTypeSetElementParserRuleCall_1_0_5_1_0 = (RuleCall)cTypeTokensAssignment_1_0_5_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_1_0_6 = (Keyword)cGroup_1_0.eContents().get(6);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Keyword cRenamesKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Keyword cTypeKeyword_1_1_1 = (Keyword)cGroup_1_1.eContents().get(1);
		private final Keyword cSetKeyword_1_1_2 = (Keyword)cGroup_1_1.eContents().get(2);
		private final Assignment cAliasedTypeAssignment_1_1_3 = (Assignment)cGroup_1_1.eContents().get(3);
		private final CrossReference cAliasedTypeTypeSetCrossReference_1_1_3_0 = (CrossReference)cAliasedTypeAssignment_1_1_3.eContents().get(0);
		private final RuleCall cAliasedTypeTypeSetQEMREFParserRuleCall_1_1_3_0_1 = (RuleCall)cAliasedTypeTypeSetCrossReference_1_1_3_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//TypeSetDefinition TypeSet:
		//	name=ID (':' 'type' 'set' '{' typeTokens+=TypeSetElement (',' typeTokens+=TypeSetElement)* '}' | 'renames' 'type'
		//	'set' aliasedType=[TypeSet|QEMREF])
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID (':' 'type' 'set' '{' typeTokens+=TypeSetElement (',' typeTokens+=TypeSetElement)* '}' | 'renames' 'type' 'set'
		//aliasedType=[TypeSet|QEMREF]) ';'
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//(':' 'type' 'set' '{' typeTokens+=TypeSetElement (',' typeTokens+=TypeSetElement)* '}' | 'renames' 'type' 'set'
		//aliasedType=[TypeSet|QEMREF])
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//':' 'type' 'set' '{' typeTokens+=TypeSetElement (',' typeTokens+=TypeSetElement)* '}'
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//':'
		public Keyword getColonKeyword_1_0_0() { return cColonKeyword_1_0_0; }
		
		//'type'
		public Keyword getTypeKeyword_1_0_1() { return cTypeKeyword_1_0_1; }
		
		//'set'
		public Keyword getSetKeyword_1_0_2() { return cSetKeyword_1_0_2; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_1_0_3() { return cLeftCurlyBracketKeyword_1_0_3; }
		
		//typeTokens+=TypeSetElement
		public Assignment getTypeTokensAssignment_1_0_4() { return cTypeTokensAssignment_1_0_4; }
		
		//TypeSetElement
		public RuleCall getTypeTokensTypeSetElementParserRuleCall_1_0_4_0() { return cTypeTokensTypeSetElementParserRuleCall_1_0_4_0; }
		
		//(',' typeTokens+=TypeSetElement)*
		public Group getGroup_1_0_5() { return cGroup_1_0_5; }
		
		//','
		public Keyword getCommaKeyword_1_0_5_0() { return cCommaKeyword_1_0_5_0; }
		
		//typeTokens+=TypeSetElement
		public Assignment getTypeTokensAssignment_1_0_5_1() { return cTypeTokensAssignment_1_0_5_1; }
		
		//TypeSetElement
		public RuleCall getTypeTokensTypeSetElementParserRuleCall_1_0_5_1_0() { return cTypeTokensTypeSetElementParserRuleCall_1_0_5_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_1_0_6() { return cRightCurlyBracketKeyword_1_0_6; }
		
		//'renames' 'type' 'set' aliasedType=[TypeSet|QEMREF]
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//'renames'
		public Keyword getRenamesKeyword_1_1_0() { return cRenamesKeyword_1_1_0; }
		
		//'type'
		public Keyword getTypeKeyword_1_1_1() { return cTypeKeyword_1_1_1; }
		
		//'set'
		public Keyword getSetKeyword_1_1_2() { return cSetKeyword_1_1_2; }
		
		//aliasedType=[TypeSet|QEMREF]
		public Assignment getAliasedTypeAssignment_1_1_3() { return cAliasedTypeAssignment_1_1_3; }
		
		//[TypeSet|QEMREF]
		public CrossReference getAliasedTypeTypeSetCrossReference_1_1_3_0() { return cAliasedTypeTypeSetCrossReference_1_1_3_0; }
		
		//QEMREF
		public RuleCall getAliasedTypeTypeSetQEMREFParserRuleCall_1_1_3_0_1() { return cAliasedTypeTypeSetQEMREFParserRuleCall_1_1_3_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}
	public class TypeSetConstructorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetConstructor");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTypeTokensAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTypeTokensTypeSetElementParserRuleCall_1_0 = (RuleCall)cTypeTokensAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCommaKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTypeTokensAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTypeTokensTypeSetElementParserRuleCall_2_1_0 = (RuleCall)cTypeTokensAssignment_2_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//TypeSetConstructor TypeSet:
		//	'{' typeTokens+=TypeSetElement (',' typeTokens+=TypeSetElement)* '}';
		@Override public ParserRule getRule() { return rule; }
		
		//'{' typeTokens+=TypeSetElement (',' typeTokens+=TypeSetElement)* '}'
		public Group getGroup() { return cGroup; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }
		
		//typeTokens+=TypeSetElement
		public Assignment getTypeTokensAssignment_1() { return cTypeTokensAssignment_1; }
		
		//TypeSetElement
		public RuleCall getTypeTokensTypeSetElementParserRuleCall_1_0() { return cTypeTokensTypeSetElementParserRuleCall_1_0; }
		
		//(',' typeTokens+=TypeSetElement)*
		public Group getGroup_2() { return cGroup_2; }
		
		//','
		public Keyword getCommaKeyword_2_0() { return cCommaKeyword_2_0; }
		
		//typeTokens+=TypeSetElement
		public Assignment getTypeTokensAssignment_2_1() { return cTypeTokensAssignment_2_1; }
		
		//TypeSetElement
		public RuleCall getTypeTokensTypeSetElementParserRuleCall_2_1_0() { return cTypeTokensTypeSetElementParserRuleCall_2_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}
	public class TypeSetReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetReference");
		private final RuleCall cTypeSetConstructorParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//TypeSetReference TypeSet:
		//	TypeSetConstructor;
		@Override public ParserRule getRule() { return rule; }
		
		//TypeSetConstructor
		public RuleCall getTypeSetConstructorParserRuleCall() { return cTypeSetConstructorParserRuleCall; }
	}
	public class TypeSetElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cTypeErrorTypesCrossReference_0_0 = (CrossReference)cTypeAssignment_0.eContents().get(0);
		private final RuleCall cTypeErrorTypesQEMREFParserRuleCall_0_0_1 = (RuleCall)cTypeErrorTypesCrossReference_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cAsteriskKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final CrossReference cTypeErrorTypesCrossReference_1_1_0 = (CrossReference)cTypeAssignment_1_1.eContents().get(0);
		private final RuleCall cTypeErrorTypesQEMREFParserRuleCall_1_1_0_1 = (RuleCall)cTypeErrorTypesCrossReference_1_1_0.eContents().get(1);
		
		//TypeSetElement TypeToken:
		//	type+=[ErrorTypes|QEMREF] ('*' type+=[ErrorTypes|QEMREF])*;
		@Override public ParserRule getRule() { return rule; }
		
		//type+=[ErrorTypes|QEMREF] ('*' type+=[ErrorTypes|QEMREF])*
		public Group getGroup() { return cGroup; }
		
		//type+=[ErrorTypes|QEMREF]
		public Assignment getTypeAssignment_0() { return cTypeAssignment_0; }
		
		//[ErrorTypes|QEMREF]
		public CrossReference getTypeErrorTypesCrossReference_0_0() { return cTypeErrorTypesCrossReference_0_0; }
		
		//QEMREF
		public RuleCall getTypeErrorTypesQEMREFParserRuleCall_0_0_1() { return cTypeErrorTypesQEMREFParserRuleCall_0_0_1; }
		
		//('*' type+=[ErrorTypes|QEMREF])*
		public Group getGroup_1() { return cGroup_1; }
		
		//'*'
		public Keyword getAsteriskKeyword_1_0() { return cAsteriskKeyword_1_0; }
		
		//type+=[ErrorTypes|QEMREF]
		public Assignment getTypeAssignment_1_1() { return cTypeAssignment_1_1; }
		
		//[ErrorTypes|QEMREF]
		public CrossReference getTypeErrorTypesCrossReference_1_1_0() { return cTypeErrorTypesCrossReference_1_1_0; }
		
		//QEMREF
		public RuleCall getTypeErrorTypesQEMREFParserRuleCall_1_1_0_1() { return cTypeErrorTypesQEMREFParserRuleCall_1_1_0_1; }
	}
	public class NoErrorTypeSetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.NoErrorTypeSet");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTypeSetAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTypeTokensAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTypeTokensNoErrorTypeTokenParserRuleCall_2_0 = (RuleCall)cTypeTokensAssignment_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//NoErrorTypeSet TypeSet:
		//	{TypeSet}
		//	'{' typeTokens+=NoErrorTypeToken '}';
		@Override public ParserRule getRule() { return rule; }
		
		//{TypeSet} '{' typeTokens+=NoErrorTypeToken '}'
		public Group getGroup() { return cGroup; }
		
		//{TypeSet}
		public Action getTypeSetAction_0() { return cTypeSetAction_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }
		
		//typeTokens+=NoErrorTypeToken
		public Assignment getTypeTokensAssignment_2() { return cTypeTokensAssignment_2; }
		
		//NoErrorTypeToken
		public RuleCall getTypeTokensNoErrorTypeTokenParserRuleCall_2_0() { return cTypeTokensNoErrorTypeTokenParserRuleCall_2_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}
	public class NoErrorTypeTokenElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.NoErrorTypeToken");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTypeTokenAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNoErrorAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cNoErrorNoerrorKeyword_1_0 = (Keyword)cNoErrorAssignment_1.eContents().get(0);
		
		//NoErrorTypeToken TypeToken:
		//	{TypeToken} noError?='noerror';
		@Override public ParserRule getRule() { return rule; }
		
		//{TypeToken} noError?='noerror'
		public Group getGroup() { return cGroup; }
		
		//{TypeToken}
		public Action getTypeTokenAction_0() { return cTypeTokenAction_0; }
		
		//noError?='noerror'
		public Assignment getNoErrorAssignment_1() { return cNoErrorAssignment_1; }
		
		//'noerror'
		public Keyword getNoErrorNoerrorKeyword_1_0() { return cNoErrorNoerrorKeyword_1_0; }
	}
	public class TypeTokenElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TypeToken");
		private final RuleCall cTypeSetReferenceParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//TypeToken TypeSet:
		//	TypeSetReference;
		@Override public ParserRule getRule() { return rule; }
		
		//TypeSetReference
		public RuleCall getTypeSetReferenceParserRuleCall() { return cTypeSetReferenceParserRuleCall; }
	}
	public class TypeTokenOrNoErrorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenOrNoError");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTypeSetReferenceParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cNoErrorTypeSetParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		////returns TypeToken:
		////	{TypeToken}
		////     ('{' type+=[ErrorTypes|QEMREF] (('*') type+=[ErrorTypes|QEMREF])* '}')
		////;
		//TypeTokenOrNoError TypeSet:
		//	TypeSetReference | NoErrorTypeSet;
		@Override public ParserRule getRule() { return rule; }
		
		//TypeSetReference | NoErrorTypeSet
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//TypeSetReference
		public RuleCall getTypeSetReferenceParserRuleCall_0() { return cTypeSetReferenceParserRuleCall_0; }
		
		//NoErrorTypeSet
		public RuleCall getNoErrorTypeSetParserRuleCall_1() { return cNoErrorTypeSetParserRuleCall_1; }
	}
	public class TypeTokenConstraintElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraint");
		private final RuleCall cTypeSetReferenceParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		////returns TypeToken:
		////	TypeToken  
		////	| '{' NoErrorTypeToken '}'
		////;
		//TypeTokenConstraint TypeSet:
		//	TypeSetReference;
		@Override public ParserRule getRule() { return rule; }
		
		//TypeSetReference
		public RuleCall getTypeSetReferenceParserRuleCall() { return cTypeSetReferenceParserRuleCall; }
	}
	public class TypeTokenConstraintNoErrorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraintNoError");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTypeSetReferenceParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cNoErrorTypeSetParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//TypeTokenConstraintNoError TypeSet:
		//	TypeSetReference | NoErrorTypeSet;
		@Override public ParserRule getRule() { return rule; }
		
		//TypeSetReference | NoErrorTypeSet
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//TypeSetReference
		public RuleCall getTypeSetReferenceParserRuleCall_0() { return cTypeSetReferenceParserRuleCall_0; }
		
		//NoErrorTypeSet
		public RuleCall getNoErrorTypeSetParserRuleCall_1() { return cNoErrorTypeSetParserRuleCall_1; }
	}
	public class TypeTransformationSetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTransformationSet");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTypeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cTransformationsKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cUseKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cTypesKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Assignment cUseTypesAssignment_3_2 = (Assignment)cGroup_3.eContents().get(2);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_3_2_0 = (CrossReference)cUseTypesAssignment_3_2.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_3_2_0.eContents().get(1);
		private final Group cGroup_3_3 = (Group)cGroup_3.eContents().get(3);
		private final Keyword cCommaKeyword_3_3_0 = (Keyword)cGroup_3_3.eContents().get(0);
		private final Assignment cUseTypesAssignment_3_3_1 = (Assignment)cGroup_3_3.eContents().get(1);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_3_3_1_0 = (CrossReference)cUseTypesAssignment_3_3_1.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_3_1_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_3_3_1_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_3_4 = (Keyword)cGroup_3.eContents().get(4);
		private final Assignment cTransformationAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cTransformationTypeTransformationParserRuleCall_4_0 = (RuleCall)cTransformationAssignment_4.eContents().get(0);
		private final Keyword cEndKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cTransformationsKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Keyword cSemicolonKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//TypeTransformationSet:
		//	'type' 'transformations' name=ID ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		//	transformation+=TypeTransformation+
		//	'end' 'transformations' ';';
		@Override public ParserRule getRule() { return rule; }
		
		//'type' 'transformations' name=ID ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//useTypes+=[ErrorModelLibrary|QEMREF])* ';')? transformation+=TypeTransformation+ 'end' 'transformations' ';'
		public Group getGroup() { return cGroup; }
		
		//'type'
		public Keyword getTypeKeyword_0() { return cTypeKeyword_0; }
		
		//'transformations'
		public Keyword getTransformationsKeyword_1() { return cTransformationsKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		public Group getGroup_3() { return cGroup_3; }
		
		//'use'
		public Keyword getUseKeyword_3_0() { return cUseKeyword_3_0; }
		
		//'types'
		public Keyword getTypesKeyword_3_1() { return cTypesKeyword_3_1; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_3_2() { return cUseTypesAssignment_3_2; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_3_2_0() { return cUseTypesErrorModelLibraryCrossReference_3_2_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_0_1; }
		
		//(',' useTypes+=[ErrorModelLibrary|QEMREF])*
		public Group getGroup_3_3() { return cGroup_3_3; }
		
		//','
		public Keyword getCommaKeyword_3_3_0() { return cCommaKeyword_3_3_0; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_3_3_1() { return cUseTypesAssignment_3_3_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_3_3_1_0() { return cUseTypesErrorModelLibraryCrossReference_3_3_1_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_3_3_1_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_3_1_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_3_4() { return cSemicolonKeyword_3_4; }
		
		//transformation+=TypeTransformation+
		public Assignment getTransformationAssignment_4() { return cTransformationAssignment_4; }
		
		//TypeTransformation
		public RuleCall getTransformationTypeTransformationParserRuleCall_4_0() { return cTransformationTypeTransformationParserRuleCall_4_0; }
		
		//'end'
		public Keyword getEndKeyword_5() { return cEndKeyword_5; }
		
		//'transformations'
		public Keyword getTransformationsKeyword_6() { return cTransformationsKeyword_6; }
		
		//';'
		public Keyword getSemicolonKeyword_7() { return cSemicolonKeyword_7; }
	}
	public class TypeTransformationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTransformation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Assignment cSourceAssignment_0_0 = (Assignment)cAlternatives_0.eContents().get(0);
		private final RuleCall cSourceTypeTokenConstraintNoErrorParserRuleCall_0_0_0 = (RuleCall)cSourceAssignment_0_0.eContents().get(0);
		private final Assignment cAllSourcesAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final Keyword cAllSourcesAllKeyword_0_1_0 = (Keyword)cAllSourcesAssignment_0_1.eContents().get(0);
		private final Keyword cHyphenMinusLeftSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cContributorAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cContributorTypeTokenConstraintNoErrorParserRuleCall_2_0 = (RuleCall)cContributorAssignment_2.eContents().get(0);
		private final Keyword cRightSquareBracketHyphenMinusGreaterThanSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cTargetAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cTargetTypeTokenParserRuleCall_4_0 = (RuleCall)cTargetAssignment_4.eContents().get(0);
		private final Keyword cSemicolonKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//TypeTransformation:
		//	(source=TypeTokenConstraintNoError | allSources?='all')
		//	'-[' contributor=TypeTokenConstraintNoError? ']->' target=TypeToken ';';
		@Override public ParserRule getRule() { return rule; }
		
		//(source=TypeTokenConstraintNoError | allSources?='all') '-[' contributor=TypeTokenConstraintNoError? ']->'
		//target=TypeToken ';'
		public Group getGroup() { return cGroup; }
		
		//(source=TypeTokenConstraintNoError | allSources?='all')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//source=TypeTokenConstraintNoError
		public Assignment getSourceAssignment_0_0() { return cSourceAssignment_0_0; }
		
		//TypeTokenConstraintNoError
		public RuleCall getSourceTypeTokenConstraintNoErrorParserRuleCall_0_0_0() { return cSourceTypeTokenConstraintNoErrorParserRuleCall_0_0_0; }
		
		//allSources?='all'
		public Assignment getAllSourcesAssignment_0_1() { return cAllSourcesAssignment_0_1; }
		
		//'all'
		public Keyword getAllSourcesAllKeyword_0_1_0() { return cAllSourcesAllKeyword_0_1_0; }
		
		//'-['
		public Keyword getHyphenMinusLeftSquareBracketKeyword_1() { return cHyphenMinusLeftSquareBracketKeyword_1; }
		
		//contributor=TypeTokenConstraintNoError?
		public Assignment getContributorAssignment_2() { return cContributorAssignment_2; }
		
		//TypeTokenConstraintNoError
		public RuleCall getContributorTypeTokenConstraintNoErrorParserRuleCall_2_0() { return cContributorTypeTokenConstraintNoErrorParserRuleCall_2_0; }
		
		//']->'
		public Keyword getRightSquareBracketHyphenMinusGreaterThanSignKeyword_3() { return cRightSquareBracketHyphenMinusGreaterThanSignKeyword_3; }
		
		//target=TypeToken
		public Assignment getTargetAssignment_4() { return cTargetAssignment_4; }
		
		//TypeToken
		public RuleCall getTargetTypeTokenParserRuleCall_4_0() { return cTargetTypeTokenParserRuleCall_4_0; }
		
		//';'
		public Keyword getSemicolonKeyword_5() { return cSemicolonKeyword_5; }
	}
	public class TypeMappingSetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TypeMappingSet");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTypeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cMappingsKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cUseKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cTypesKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Assignment cUseTypesAssignment_3_2 = (Assignment)cGroup_3.eContents().get(2);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_3_2_0 = (CrossReference)cUseTypesAssignment_3_2.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_3_2_0.eContents().get(1);
		private final Group cGroup_3_3 = (Group)cGroup_3.eContents().get(3);
		private final Keyword cCommaKeyword_3_3_0 = (Keyword)cGroup_3_3.eContents().get(0);
		private final Assignment cUseTypesAssignment_3_3_1 = (Assignment)cGroup_3_3.eContents().get(1);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_3_3_1_0 = (CrossReference)cUseTypesAssignment_3_3_1.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_3_1_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_3_3_1_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_3_4 = (Keyword)cGroup_3.eContents().get(4);
		private final Assignment cMappingAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cMappingTypeMappingParserRuleCall_4_0 = (RuleCall)cMappingAssignment_4.eContents().get(0);
		private final Keyword cEndKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cMappingsKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Keyword cSemicolonKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//TypeMappingSet:
		//	'type' 'mappings' name=ID ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		//	mapping+=TypeMapping+
		//	'end' 'mappings' ';';
		@Override public ParserRule getRule() { return rule; }
		
		//'type' 'mappings' name=ID ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//useTypes+=[ErrorModelLibrary|QEMREF])* ';')? mapping+=TypeMapping+ 'end' 'mappings' ';'
		public Group getGroup() { return cGroup; }
		
		//'type'
		public Keyword getTypeKeyword_0() { return cTypeKeyword_0; }
		
		//'mappings'
		public Keyword getMappingsKeyword_1() { return cMappingsKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		public Group getGroup_3() { return cGroup_3; }
		
		//'use'
		public Keyword getUseKeyword_3_0() { return cUseKeyword_3_0; }
		
		//'types'
		public Keyword getTypesKeyword_3_1() { return cTypesKeyword_3_1; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_3_2() { return cUseTypesAssignment_3_2; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_3_2_0() { return cUseTypesErrorModelLibraryCrossReference_3_2_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_0_1; }
		
		//(',' useTypes+=[ErrorModelLibrary|QEMREF])*
		public Group getGroup_3_3() { return cGroup_3_3; }
		
		//','
		public Keyword getCommaKeyword_3_3_0() { return cCommaKeyword_3_3_0; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_3_3_1() { return cUseTypesAssignment_3_3_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_3_3_1_0() { return cUseTypesErrorModelLibraryCrossReference_3_3_1_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_3_3_1_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_3_1_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_3_4() { return cSemicolonKeyword_3_4; }
		
		//mapping+=TypeMapping+
		public Assignment getMappingAssignment_4() { return cMappingAssignment_4; }
		
		//TypeMapping
		public RuleCall getMappingTypeMappingParserRuleCall_4_0() { return cMappingTypeMappingParserRuleCall_4_0; }
		
		//'end'
		public Keyword getEndKeyword_5() { return cEndKeyword_5; }
		
		//'mappings'
		public Keyword getMappingsKeyword_6() { return cMappingsKeyword_6; }
		
		//';'
		public Keyword getSemicolonKeyword_7() { return cSemicolonKeyword_7; }
	}
	public class TypeMappingElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TypeMapping");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSourceAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cSourceTypeTokenConstraintParserRuleCall_0_0 = (RuleCall)cSourceAssignment_0.eContents().get(0);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTargetAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTargetTypeTokenParserRuleCall_2_0 = (RuleCall)cTargetAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//TypeMapping:
		//	source=TypeTokenConstraint '->' target=TypeToken ';';
		@Override public ParserRule getRule() { return rule; }
		
		//source=TypeTokenConstraint '->' target=TypeToken ';'
		public Group getGroup() { return cGroup; }
		
		//source=TypeTokenConstraint
		public Assignment getSourceAssignment_0() { return cSourceAssignment_0; }
		
		//TypeTokenConstraint
		public RuleCall getSourceTypeTokenConstraintParserRuleCall_0_0() { return cSourceTypeTokenConstraintParserRuleCall_0_0; }
		
		//'->'
		public Keyword getHyphenMinusGreaterThanSignKeyword_1() { return cHyphenMinusGreaterThanSignKeyword_1; }
		
		//target=TypeToken
		public Assignment getTargetAssignment_2() { return cTargetAssignment_2; }
		
		//TypeToken
		public RuleCall getTargetTypeTokenParserRuleCall_2_0() { return cTargetTypeTokenParserRuleCall_2_0; }
		
		//';'
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}
	public class ErrorPropagationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorPropagation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cErrorPropagationAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cKindAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cKindPropagationKindParserRuleCall_1_0_0 = (RuleCall)cKindAssignment_1_0.eContents().get(0);
		private final Assignment cFeatureorPPRefAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cFeatureorPPRefFeatureorPPReferenceParserRuleCall_1_1_0 = (RuleCall)cFeatureorPPRefAssignment_1_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNotAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final Keyword cNotNotKeyword_3_0 = (Keyword)cNotAssignment_3.eContents().get(0);
		private final Assignment cDirectionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cDirectionPropagationDirectionParserRuleCall_4_0 = (RuleCall)cDirectionAssignment_4.eContents().get(0);
		private final Keyword cPropagationKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cTypeSetAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cTypeSetTypeSetReferenceParserRuleCall_6_0 = (RuleCall)cTypeSetAssignment_6.eContents().get(0);
		private final Keyword cSemicolonKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		////StateTypeBinding returns ErrorBehaviorState:
		////	(intial?='initial')? 'state' name=ID typeSet = TypeSetReference
		////;
		//ErrorPropagation:
		//	{ErrorPropagation} (kind=PropagationKind | featureorPPRef=FeatureorPPReference)
		//	':' not?='not'? direction=PropagationDirection 'propagation'
		//	typeSet=TypeSetReference
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//{ErrorPropagation} (kind=PropagationKind | featureorPPRef=FeatureorPPReference) ':' not?='not'?
		//direction=PropagationDirection 'propagation' typeSet=TypeSetReference ';'
		public Group getGroup() { return cGroup; }
		
		//{ErrorPropagation}
		public Action getErrorPropagationAction_0() { return cErrorPropagationAction_0; }
		
		//(kind=PropagationKind | featureorPPRef=FeatureorPPReference)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//kind=PropagationKind
		public Assignment getKindAssignment_1_0() { return cKindAssignment_1_0; }
		
		//PropagationKind
		public RuleCall getKindPropagationKindParserRuleCall_1_0_0() { return cKindPropagationKindParserRuleCall_1_0_0; }
		
		//featureorPPRef=FeatureorPPReference
		public Assignment getFeatureorPPRefAssignment_1_1() { return cFeatureorPPRefAssignment_1_1; }
		
		//FeatureorPPReference
		public RuleCall getFeatureorPPRefFeatureorPPReferenceParserRuleCall_1_1_0() { return cFeatureorPPRefFeatureorPPReferenceParserRuleCall_1_1_0; }
		
		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
		
		//not?='not'?
		public Assignment getNotAssignment_3() { return cNotAssignment_3; }
		
		//'not'
		public Keyword getNotNotKeyword_3_0() { return cNotNotKeyword_3_0; }
		
		//direction=PropagationDirection
		public Assignment getDirectionAssignment_4() { return cDirectionAssignment_4; }
		
		//PropagationDirection
		public RuleCall getDirectionPropagationDirectionParserRuleCall_4_0() { return cDirectionPropagationDirectionParserRuleCall_4_0; }
		
		//'propagation'
		public Keyword getPropagationKeyword_5() { return cPropagationKeyword_5; }
		
		//typeSet=TypeSetReference
		public Assignment getTypeSetAssignment_6() { return cTypeSetAssignment_6; }
		
		//TypeSetReference
		public RuleCall getTypeSetTypeSetReferenceParserRuleCall_6_0() { return cTypeSetTypeSetReferenceParserRuleCall_6_0; }
		
		//';'
		public Keyword getSemicolonKeyword_7() { return cSemicolonKeyword_7; }
	}
	public class FeatureorPPReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.FeatureorPPReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cFeatureorPPAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cFeatureorPPNamedElementCrossReference_0_0 = (CrossReference)cFeatureorPPAssignment_0.eContents().get(0);
		private final RuleCall cFeatureorPPNamedElementIDTerminalRuleCall_0_0_1 = (RuleCall)cFeatureorPPNamedElementCrossReference_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cNextAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cNextFeatureorPPReferenceParserRuleCall_1_1_0 = (RuleCall)cNextAssignment_1_1.eContents().get(0);
		
		//FeatureorPPReference:
		//	featureorPP=[aadl2::NamedElement] ("." next=FeatureorPPReference)?;
		@Override public ParserRule getRule() { return rule; }
		
		//featureorPP=[aadl2::NamedElement] ("." next=FeatureorPPReference)?
		public Group getGroup() { return cGroup; }
		
		//featureorPP=[aadl2::NamedElement]
		public Assignment getFeatureorPPAssignment_0() { return cFeatureorPPAssignment_0; }
		
		//[aadl2::NamedElement]
		public CrossReference getFeatureorPPNamedElementCrossReference_0_0() { return cFeatureorPPNamedElementCrossReference_0_0; }
		
		//ID
		public RuleCall getFeatureorPPNamedElementIDTerminalRuleCall_0_0_1() { return cFeatureorPPNamedElementIDTerminalRuleCall_0_0_1; }
		
		//("." next=FeatureorPPReference)?
		public Group getGroup_1() { return cGroup_1; }
		
		//"."
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//next=FeatureorPPReference
		public Assignment getNextAssignment_1_1() { return cNextAssignment_1_1; }
		
		//FeatureorPPReference
		public RuleCall getNextFeatureorPPReferenceParserRuleCall_1_1_0() { return cNextFeatureorPPReferenceParserRuleCall_1_1_0; }
	}
	public class PropagationDirectionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.PropagationDirection");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cInKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cOutKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//PropagationDirection aadl2::DirectionType:
		//	'in' | 'out';
		@Override public ParserRule getRule() { return rule; }
		
		//'in' | 'out'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'in'
		public Keyword getInKeyword_0() { return cInKeyword_0; }
		
		//'out'
		public Keyword getOutKeyword_1() { return cOutKeyword_1; }
	}
	public class PropagationKindElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.PropagationKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cProcessorKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cMemoryKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cConnectionKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cBindingKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cBindingsKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cAccessKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		
		//PropagationKind:
		//	'processor' | 'memory' | 'connection' | 'binding' | 'bindings' | 'access';
		@Override public ParserRule getRule() { return rule; }
		
		//'processor' | 'memory' | 'connection' | 'binding' | 'bindings' | 'access'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'processor'
		public Keyword getProcessorKeyword_0() { return cProcessorKeyword_0; }
		
		//'memory'
		public Keyword getMemoryKeyword_1() { return cMemoryKeyword_1; }
		
		//'connection'
		public Keyword getConnectionKeyword_2() { return cConnectionKeyword_2; }
		
		//'binding'
		public Keyword getBindingKeyword_3() { return cBindingKeyword_3; }
		
		//'bindings'
		public Keyword getBindingsKeyword_4() { return cBindingsKeyword_4; }
		
		//'access'
		public Keyword getAccessKeyword_5() { return cAccessKeyword_5; }
	}
	public class ErrorFlowElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorFlow");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cErrorSourceParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cErrorSinkParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cErrorPathParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//// enum does not work as  
		////enum PropKind : PROCESSOR='processor'|MEMORY='memory'|BUS='bus'|DEVICE='device'|SYSTEM='system'
		////	            |VIRTUALBUS='virtual bus'|VIRTUALPROCESSOR='virtual processor'|BINDING='binding' | BINDINGS='bindings'|ACCESS='access'
		////;
		//ErrorFlow:
		//	ErrorSource | ErrorSink | ErrorPath;
		@Override public ParserRule getRule() { return rule; }
		
		//ErrorSource | ErrorSink | ErrorPath
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ErrorSource
		public RuleCall getErrorSourceParserRuleCall_0() { return cErrorSourceParserRuleCall_0; }
		
		//ErrorSink
		public RuleCall getErrorSinkParserRuleCall_1() { return cErrorSinkParserRuleCall_1; }
		
		//ErrorPath
		public RuleCall getErrorPathParserRuleCall_2() { return cErrorPathParserRuleCall_2; }
	}
	public class ErrorSourceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorSource");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cErrorKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cSourceKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cSourceModelElementAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final CrossReference cSourceModelElementNamedElementCrossReference_4_0_0 = (CrossReference)cSourceModelElementAssignment_4_0.eContents().get(0);
		private final RuleCall cSourceModelElementNamedElementErrorPropagationPointParserRuleCall_4_0_0_1 = (RuleCall)cSourceModelElementNamedElementCrossReference_4_0_0.eContents().get(1);
		private final Assignment cAllAssignment_4_1 = (Assignment)cAlternatives_4.eContents().get(1);
		private final Keyword cAllAllKeyword_4_1_0 = (Keyword)cAllAssignment_4_1.eContents().get(0);
		private final Assignment cTypeTokenConstraintAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cTypeTokenConstraintTypeTokenConstraintParserRuleCall_5_0 = (RuleCall)cTypeTokenConstraintAssignment_5.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cWhenKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Alternatives cAlternatives_6_1 = (Alternatives)cGroup_6.eContents().get(1);
		private final Group cGroup_6_1_0 = (Group)cAlternatives_6_1.eContents().get(0);
		private final Assignment cFailureModeReferenceAssignment_6_1_0_0 = (Assignment)cGroup_6_1_0.eContents().get(0);
		private final CrossReference cFailureModeReferenceErrorBehaviorStateCrossReference_6_1_0_0_0 = (CrossReference)cFailureModeReferenceAssignment_6_1_0_0.eContents().get(0);
		private final RuleCall cFailureModeReferenceErrorBehaviorStateIDTerminalRuleCall_6_1_0_0_0_1 = (RuleCall)cFailureModeReferenceErrorBehaviorStateCrossReference_6_1_0_0_0.eContents().get(1);
		private final Assignment cFailureModeTypeAssignment_6_1_0_1 = (Assignment)cGroup_6_1_0.eContents().get(1);
		private final RuleCall cFailureModeTypeTypeSetReferenceParserRuleCall_6_1_0_1_0 = (RuleCall)cFailureModeTypeAssignment_6_1_0_1.eContents().get(0);
		private final Assignment cFailureModeTypeAssignment_6_1_1 = (Assignment)cAlternatives_6_1.eContents().get(1);
		private final RuleCall cFailureModeTypeTypeSetConstructorParserRuleCall_6_1_1_0 = (RuleCall)cFailureModeTypeAssignment_6_1_1.eContents().get(0);
		private final Assignment cFailureModeDescriptionAssignment_6_1_2 = (Assignment)cAlternatives_6_1.eContents().get(2);
		private final RuleCall cFailureModeDescriptionSTRINGTerminalRuleCall_6_1_2_0 = (RuleCall)cFailureModeDescriptionAssignment_6_1_2.eContents().get(0);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cIfKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cFlowconditionAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cFlowconditionIfConditionParserRuleCall_7_1_0 = (RuleCall)cFlowconditionAssignment_7_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//ErrorSource:
		//	name=ID ':' 'error' 'source' (sourceModelElement=[aadl2::NamedElement|ErrorPropagationPoint] | all?='all')
		//	typeTokenConstraint=TypeTokenConstraint? ('when' (failureModeReference=[ErrorBehaviorState]
		//	failureModeType=TypeSetReference? | failureModeType=TypeSetConstructor | failureModeDescription=STRING))? ('if'
		//	flowcondition=IfCondition)?
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID ':' 'error' 'source' (sourceModelElement=[aadl2::NamedElement|ErrorPropagationPoint] | all?='all')
		//typeTokenConstraint=TypeTokenConstraint? ('when' (failureModeReference=[ErrorBehaviorState]
		//failureModeType=TypeSetReference? | failureModeType=TypeSetConstructor | failureModeDescription=STRING))? ('if'
		//flowcondition=IfCondition)? ';'
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }
		
		//'error'
		public Keyword getErrorKeyword_2() { return cErrorKeyword_2; }
		
		//'source'
		public Keyword getSourceKeyword_3() { return cSourceKeyword_3; }
		
		//(sourceModelElement=[aadl2::NamedElement|ErrorPropagationPoint] | all?='all')
		public Alternatives getAlternatives_4() { return cAlternatives_4; }
		
		//sourceModelElement=[aadl2::NamedElement|ErrorPropagationPoint]
		public Assignment getSourceModelElementAssignment_4_0() { return cSourceModelElementAssignment_4_0; }
		
		//[aadl2::NamedElement|ErrorPropagationPoint]
		public CrossReference getSourceModelElementNamedElementCrossReference_4_0_0() { return cSourceModelElementNamedElementCrossReference_4_0_0; }
		
		//ErrorPropagationPoint
		public RuleCall getSourceModelElementNamedElementErrorPropagationPointParserRuleCall_4_0_0_1() { return cSourceModelElementNamedElementErrorPropagationPointParserRuleCall_4_0_0_1; }
		
		//all?='all'
		public Assignment getAllAssignment_4_1() { return cAllAssignment_4_1; }
		
		//'all'
		public Keyword getAllAllKeyword_4_1_0() { return cAllAllKeyword_4_1_0; }
		
		//typeTokenConstraint=TypeTokenConstraint?
		public Assignment getTypeTokenConstraintAssignment_5() { return cTypeTokenConstraintAssignment_5; }
		
		//TypeTokenConstraint
		public RuleCall getTypeTokenConstraintTypeTokenConstraintParserRuleCall_5_0() { return cTypeTokenConstraintTypeTokenConstraintParserRuleCall_5_0; }
		
		//('when' (failureModeReference=[ErrorBehaviorState] failureModeType=TypeSetReference? |
		//failureModeType=TypeSetConstructor | failureModeDescription=STRING))?
		public Group getGroup_6() { return cGroup_6; }
		
		//'when'
		public Keyword getWhenKeyword_6_0() { return cWhenKeyword_6_0; }
		
		//(failureModeReference=[ErrorBehaviorState] failureModeType=TypeSetReference? | failureModeType=TypeSetConstructor |
		//failureModeDescription=STRING)
		public Alternatives getAlternatives_6_1() { return cAlternatives_6_1; }
		
		//failureModeReference=[ErrorBehaviorState] failureModeType=TypeSetReference?
		public Group getGroup_6_1_0() { return cGroup_6_1_0; }
		
		//failureModeReference=[ErrorBehaviorState]
		public Assignment getFailureModeReferenceAssignment_6_1_0_0() { return cFailureModeReferenceAssignment_6_1_0_0; }
		
		//[ErrorBehaviorState]
		public CrossReference getFailureModeReferenceErrorBehaviorStateCrossReference_6_1_0_0_0() { return cFailureModeReferenceErrorBehaviorStateCrossReference_6_1_0_0_0; }
		
		//ID
		public RuleCall getFailureModeReferenceErrorBehaviorStateIDTerminalRuleCall_6_1_0_0_0_1() { return cFailureModeReferenceErrorBehaviorStateIDTerminalRuleCall_6_1_0_0_0_1; }
		
		//failureModeType=TypeSetReference?
		public Assignment getFailureModeTypeAssignment_6_1_0_1() { return cFailureModeTypeAssignment_6_1_0_1; }
		
		//TypeSetReference
		public RuleCall getFailureModeTypeTypeSetReferenceParserRuleCall_6_1_0_1_0() { return cFailureModeTypeTypeSetReferenceParserRuleCall_6_1_0_1_0; }
		
		//failureModeType=TypeSetConstructor
		public Assignment getFailureModeTypeAssignment_6_1_1() { return cFailureModeTypeAssignment_6_1_1; }
		
		//TypeSetConstructor
		public RuleCall getFailureModeTypeTypeSetConstructorParserRuleCall_6_1_1_0() { return cFailureModeTypeTypeSetConstructorParserRuleCall_6_1_1_0; }
		
		//failureModeDescription=STRING
		public Assignment getFailureModeDescriptionAssignment_6_1_2() { return cFailureModeDescriptionAssignment_6_1_2; }
		
		//STRING
		public RuleCall getFailureModeDescriptionSTRINGTerminalRuleCall_6_1_2_0() { return cFailureModeDescriptionSTRINGTerminalRuleCall_6_1_2_0; }
		
		//('if' flowcondition=IfCondition)?
		public Group getGroup_7() { return cGroup_7; }
		
		//'if'
		public Keyword getIfKeyword_7_0() { return cIfKeyword_7_0; }
		
		//flowcondition=IfCondition
		public Assignment getFlowconditionAssignment_7_1() { return cFlowconditionAssignment_7_1; }
		
		//IfCondition
		public RuleCall getFlowconditionIfConditionParserRuleCall_7_1_0() { return cFlowconditionIfConditionParserRuleCall_7_1_0; }
		
		//';'
		public Keyword getSemicolonKeyword_8() { return cSemicolonKeyword_8; }
	}
	public class ErrorSinkElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorSink");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cErrorKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cSinkKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cIncomingAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final CrossReference cIncomingErrorPropagationCrossReference_4_0_0 = (CrossReference)cIncomingAssignment_4_0.eContents().get(0);
		private final RuleCall cIncomingErrorPropagationErrorPropagationPointParserRuleCall_4_0_0_1 = (RuleCall)cIncomingErrorPropagationCrossReference_4_0_0.eContents().get(1);
		private final Assignment cAllIncomingAssignment_4_1 = (Assignment)cAlternatives_4.eContents().get(1);
		private final Keyword cAllIncomingAllKeyword_4_1_0 = (Keyword)cAllIncomingAssignment_4_1.eContents().get(0);
		private final Assignment cTypeTokenConstraintAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cTypeTokenConstraintTypeTokenConstraintParserRuleCall_5_0 = (RuleCall)cTypeTokenConstraintAssignment_5.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cIfKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cFlowconditionAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cFlowconditionIfConditionParserRuleCall_6_1_0 = (RuleCall)cFlowconditionAssignment_6_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//ErrorSink:
		//	name=ID ':' 'error' 'sink' (incoming=[ErrorPropagation|ErrorPropagationPoint] | allIncoming?='all')
		//	typeTokenConstraint=TypeTokenConstraint? ('if' flowcondition=IfCondition)?
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID ':' 'error' 'sink' (incoming=[ErrorPropagation|ErrorPropagationPoint] | allIncoming?='all')
		//typeTokenConstraint=TypeTokenConstraint? ('if' flowcondition=IfCondition)? ';'
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }
		
		//'error'
		public Keyword getErrorKeyword_2() { return cErrorKeyword_2; }
		
		//'sink'
		public Keyword getSinkKeyword_3() { return cSinkKeyword_3; }
		
		//(incoming=[ErrorPropagation|ErrorPropagationPoint] | allIncoming?='all')
		public Alternatives getAlternatives_4() { return cAlternatives_4; }
		
		//incoming=[ErrorPropagation|ErrorPropagationPoint]
		public Assignment getIncomingAssignment_4_0() { return cIncomingAssignment_4_0; }
		
		//[ErrorPropagation|ErrorPropagationPoint]
		public CrossReference getIncomingErrorPropagationCrossReference_4_0_0() { return cIncomingErrorPropagationCrossReference_4_0_0; }
		
		//ErrorPropagationPoint
		public RuleCall getIncomingErrorPropagationErrorPropagationPointParserRuleCall_4_0_0_1() { return cIncomingErrorPropagationErrorPropagationPointParserRuleCall_4_0_0_1; }
		
		//allIncoming?='all'
		public Assignment getAllIncomingAssignment_4_1() { return cAllIncomingAssignment_4_1; }
		
		//'all'
		public Keyword getAllIncomingAllKeyword_4_1_0() { return cAllIncomingAllKeyword_4_1_0; }
		
		//typeTokenConstraint=TypeTokenConstraint?
		public Assignment getTypeTokenConstraintAssignment_5() { return cTypeTokenConstraintAssignment_5; }
		
		//TypeTokenConstraint
		public RuleCall getTypeTokenConstraintTypeTokenConstraintParserRuleCall_5_0() { return cTypeTokenConstraintTypeTokenConstraintParserRuleCall_5_0; }
		
		//('if' flowcondition=IfCondition)?
		public Group getGroup_6() { return cGroup_6; }
		
		//'if'
		public Keyword getIfKeyword_6_0() { return cIfKeyword_6_0; }
		
		//flowcondition=IfCondition
		public Assignment getFlowconditionAssignment_6_1() { return cFlowconditionAssignment_6_1; }
		
		//IfCondition
		public RuleCall getFlowconditionIfConditionParserRuleCall_6_1_0() { return cFlowconditionIfConditionParserRuleCall_6_1_0; }
		
		//';'
		public Keyword getSemicolonKeyword_7() { return cSemicolonKeyword_7; }
	}
	public class ErrorPathElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorPath");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cErrorKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cPathKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cIncomingAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final CrossReference cIncomingErrorPropagationCrossReference_4_0_0 = (CrossReference)cIncomingAssignment_4_0.eContents().get(0);
		private final RuleCall cIncomingErrorPropagationErrorPropagationPointParserRuleCall_4_0_0_1 = (RuleCall)cIncomingErrorPropagationCrossReference_4_0_0.eContents().get(1);
		private final Assignment cAllIncomingAssignment_4_1 = (Assignment)cAlternatives_4.eContents().get(1);
		private final Keyword cAllIncomingAllKeyword_4_1_0 = (Keyword)cAllIncomingAssignment_4_1.eContents().get(0);
		private final Assignment cTypeTokenConstraintAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cTypeTokenConstraintTypeTokenConstraintParserRuleCall_5_0 = (RuleCall)cTypeTokenConstraintAssignment_5.eContents().get(0);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Alternatives cAlternatives_7 = (Alternatives)cGroup.eContents().get(7);
		private final Assignment cOutgoingAssignment_7_0 = (Assignment)cAlternatives_7.eContents().get(0);
		private final CrossReference cOutgoingErrorPropagationCrossReference_7_0_0 = (CrossReference)cOutgoingAssignment_7_0.eContents().get(0);
		private final RuleCall cOutgoingErrorPropagationErrorPropagationPointParserRuleCall_7_0_0_1 = (RuleCall)cOutgoingErrorPropagationCrossReference_7_0_0.eContents().get(1);
		private final Assignment cAllOutgoingAssignment_7_1 = (Assignment)cAlternatives_7.eContents().get(1);
		private final Keyword cAllOutgoingAllKeyword_7_1_0 = (Keyword)cAllOutgoingAssignment_7_1.eContents().get(0);
		private final Alternatives cAlternatives_8 = (Alternatives)cGroup.eContents().get(8);
		private final Assignment cTargetTokenAssignment_8_0 = (Assignment)cAlternatives_8.eContents().get(0);
		private final RuleCall cTargetTokenTypeTokenParserRuleCall_8_0_0 = (RuleCall)cTargetTokenAssignment_8_0.eContents().get(0);
		private final Group cGroup_8_1 = (Group)cAlternatives_8.eContents().get(1);
		private final Keyword cUseKeyword_8_1_0 = (Keyword)cGroup_8_1.eContents().get(0);
		private final Keyword cMappingsKeyword_8_1_1 = (Keyword)cGroup_8_1.eContents().get(1);
		private final Assignment cTypeMappingSetAssignment_8_1_2 = (Assignment)cGroup_8_1.eContents().get(2);
		private final CrossReference cTypeMappingSetTypeMappingSetCrossReference_8_1_2_0 = (CrossReference)cTypeMappingSetAssignment_8_1_2.eContents().get(0);
		private final RuleCall cTypeMappingSetTypeMappingSetQEMREFParserRuleCall_8_1_2_0_1 = (RuleCall)cTypeMappingSetTypeMappingSetCrossReference_8_1_2_0.eContents().get(1);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cIfKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Assignment cFlowconditionAssignment_9_1 = (Assignment)cGroup_9.eContents().get(1);
		private final RuleCall cFlowconditionIfConditionParserRuleCall_9_1_0 = (RuleCall)cFlowconditionAssignment_9_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_10 = (Keyword)cGroup.eContents().get(10);
		
		//ErrorPath:
		//	name=ID ':' 'error' 'path' (incoming=[ErrorPropagation|ErrorPropagationPoint] | allIncoming?='all')
		//	typeTokenConstraint=TypeTokenConstraint? '->' (outgoing=[ErrorPropagation|ErrorPropagationPoint] | allOutgoing?='all')
		//	(targetToken=TypeToken | 'use' 'mappings' typeMappingSet=[TypeMappingSet|QEMREF])? ('if' flowcondition=IfCondition)?
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID ':' 'error' 'path' (incoming=[ErrorPropagation|ErrorPropagationPoint] | allIncoming?='all')
		//typeTokenConstraint=TypeTokenConstraint? '->' (outgoing=[ErrorPropagation|ErrorPropagationPoint] | allOutgoing?='all')
		//(targetToken=TypeToken | 'use' 'mappings' typeMappingSet=[TypeMappingSet|QEMREF])? ('if' flowcondition=IfCondition)?
		//';'
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }
		
		//'error'
		public Keyword getErrorKeyword_2() { return cErrorKeyword_2; }
		
		//'path'
		public Keyword getPathKeyword_3() { return cPathKeyword_3; }
		
		//(incoming=[ErrorPropagation|ErrorPropagationPoint] | allIncoming?='all')
		public Alternatives getAlternatives_4() { return cAlternatives_4; }
		
		//incoming=[ErrorPropagation|ErrorPropagationPoint]
		public Assignment getIncomingAssignment_4_0() { return cIncomingAssignment_4_0; }
		
		//[ErrorPropagation|ErrorPropagationPoint]
		public CrossReference getIncomingErrorPropagationCrossReference_4_0_0() { return cIncomingErrorPropagationCrossReference_4_0_0; }
		
		//ErrorPropagationPoint
		public RuleCall getIncomingErrorPropagationErrorPropagationPointParserRuleCall_4_0_0_1() { return cIncomingErrorPropagationErrorPropagationPointParserRuleCall_4_0_0_1; }
		
		//allIncoming?='all'
		public Assignment getAllIncomingAssignment_4_1() { return cAllIncomingAssignment_4_1; }
		
		//'all'
		public Keyword getAllIncomingAllKeyword_4_1_0() { return cAllIncomingAllKeyword_4_1_0; }
		
		//typeTokenConstraint=TypeTokenConstraint?
		public Assignment getTypeTokenConstraintAssignment_5() { return cTypeTokenConstraintAssignment_5; }
		
		//TypeTokenConstraint
		public RuleCall getTypeTokenConstraintTypeTokenConstraintParserRuleCall_5_0() { return cTypeTokenConstraintTypeTokenConstraintParserRuleCall_5_0; }
		
		//'->'
		public Keyword getHyphenMinusGreaterThanSignKeyword_6() { return cHyphenMinusGreaterThanSignKeyword_6; }
		
		//(outgoing=[ErrorPropagation|ErrorPropagationPoint] | allOutgoing?='all')
		public Alternatives getAlternatives_7() { return cAlternatives_7; }
		
		//outgoing=[ErrorPropagation|ErrorPropagationPoint]
		public Assignment getOutgoingAssignment_7_0() { return cOutgoingAssignment_7_0; }
		
		//[ErrorPropagation|ErrorPropagationPoint]
		public CrossReference getOutgoingErrorPropagationCrossReference_7_0_0() { return cOutgoingErrorPropagationCrossReference_7_0_0; }
		
		//ErrorPropagationPoint
		public RuleCall getOutgoingErrorPropagationErrorPropagationPointParserRuleCall_7_0_0_1() { return cOutgoingErrorPropagationErrorPropagationPointParserRuleCall_7_0_0_1; }
		
		//allOutgoing?='all'
		public Assignment getAllOutgoingAssignment_7_1() { return cAllOutgoingAssignment_7_1; }
		
		//'all'
		public Keyword getAllOutgoingAllKeyword_7_1_0() { return cAllOutgoingAllKeyword_7_1_0; }
		
		//(targetToken=TypeToken | 'use' 'mappings' typeMappingSet=[TypeMappingSet|QEMREF])?
		public Alternatives getAlternatives_8() { return cAlternatives_8; }
		
		//targetToken=TypeToken
		public Assignment getTargetTokenAssignment_8_0() { return cTargetTokenAssignment_8_0; }
		
		//TypeToken
		public RuleCall getTargetTokenTypeTokenParserRuleCall_8_0_0() { return cTargetTokenTypeTokenParserRuleCall_8_0_0; }
		
		//'use' 'mappings' typeMappingSet=[TypeMappingSet|QEMREF]
		public Group getGroup_8_1() { return cGroup_8_1; }
		
		//'use'
		public Keyword getUseKeyword_8_1_0() { return cUseKeyword_8_1_0; }
		
		//'mappings'
		public Keyword getMappingsKeyword_8_1_1() { return cMappingsKeyword_8_1_1; }
		
		//typeMappingSet=[TypeMappingSet|QEMREF]
		public Assignment getTypeMappingSetAssignment_8_1_2() { return cTypeMappingSetAssignment_8_1_2; }
		
		//[TypeMappingSet|QEMREF]
		public CrossReference getTypeMappingSetTypeMappingSetCrossReference_8_1_2_0() { return cTypeMappingSetTypeMappingSetCrossReference_8_1_2_0; }
		
		//QEMREF
		public RuleCall getTypeMappingSetTypeMappingSetQEMREFParserRuleCall_8_1_2_0_1() { return cTypeMappingSetTypeMappingSetQEMREFParserRuleCall_8_1_2_0_1; }
		
		//('if' flowcondition=IfCondition)?
		public Group getGroup_9() { return cGroup_9; }
		
		//'if'
		public Keyword getIfKeyword_9_0() { return cIfKeyword_9_0; }
		
		//flowcondition=IfCondition
		public Assignment getFlowconditionAssignment_9_1() { return cFlowconditionAssignment_9_1; }
		
		//IfCondition
		public RuleCall getFlowconditionIfConditionParserRuleCall_9_1_0() { return cFlowconditionIfConditionParserRuleCall_9_1_0; }
		
		//';'
		public Keyword getSemicolonKeyword_10() { return cSemicolonKeyword_10; }
	}
	public class IfConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.IfCondition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cDescriptionAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cDescriptionSTRINGTerminalRuleCall_0_0 = (RuleCall)cDescriptionAssignment_0.eContents().get(0);
		private final Assignment cResoluteFunctionAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final CrossReference cResoluteFunctionEObjectCrossReference_1_0 = (CrossReference)cResoluteFunctionAssignment_1.eContents().get(0);
		private final RuleCall cResoluteFunctionEObjectQEMREFParserRuleCall_1_0_1 = (RuleCall)cResoluteFunctionEObjectCrossReference_1_0.eContents().get(1);
		private final Assignment cJavaMethodAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final RuleCall cJavaMethodQUALIFIEDNAMEParserRuleCall_2_0 = (RuleCall)cJavaMethodAssignment_2.eContents().get(0);
		
		//IfCondition:
		//	description=STRING | resoluteFunction=[ecore::EObject|QEMREF] | javaMethod=QUALIFIEDNAME;
		@Override public ParserRule getRule() { return rule; }
		
		//description=STRING | resoluteFunction=[ecore::EObject|QEMREF] | javaMethod=QUALIFIEDNAME
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//description=STRING
		public Assignment getDescriptionAssignment_0() { return cDescriptionAssignment_0; }
		
		//STRING
		public RuleCall getDescriptionSTRINGTerminalRuleCall_0_0() { return cDescriptionSTRINGTerminalRuleCall_0_0; }
		
		//resoluteFunction=[ecore::EObject|QEMREF]
		public Assignment getResoluteFunctionAssignment_1() { return cResoluteFunctionAssignment_1; }
		
		//[ecore::EObject|QEMREF]
		public CrossReference getResoluteFunctionEObjectCrossReference_1_0() { return cResoluteFunctionEObjectCrossReference_1_0; }
		
		//QEMREF
		public RuleCall getResoluteFunctionEObjectQEMREFParserRuleCall_1_0_1() { return cResoluteFunctionEObjectQEMREFParserRuleCall_1_0_1; }
		
		//javaMethod=QUALIFIEDNAME
		public Assignment getJavaMethodAssignment_2() { return cJavaMethodAssignment_2; }
		
		//QUALIFIEDNAME
		public RuleCall getJavaMethodQUALIFIEDNAMEParserRuleCall_2_0() { return cJavaMethodQUALIFIEDNAMEParserRuleCall_2_0; }
	}
	public class ErrorPropagationPointElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorPropagationPoint");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Keyword cFullStopKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final RuleCall cPropagationKindParserRuleCall_1_0 = (RuleCall)cAlternatives_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cAlternatives_1.eContents().get(1);
		
		//// reference to error propagation  
		//ErrorPropagationPoint:
		//	(ID ".")* (PropagationKind | ID);
		@Override public ParserRule getRule() { return rule; }
		
		//(ID ".")* (PropagationKind | ID)
		public Group getGroup() { return cGroup; }
		
		//(ID ".")*
		public Group getGroup_0() { return cGroup_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }
		
		//"."
		public Keyword getFullStopKeyword_0_1() { return cFullStopKeyword_0_1; }
		
		//(PropagationKind | ID)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//PropagationKind
		public RuleCall getPropagationKindParserRuleCall_1_0() { return cPropagationKindParserRuleCall_1_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	public class PropagationPointElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.PropagationPoint");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cPropagationKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cPointKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//PropagationPoint:
		//	name=ID ':' 'propagation' 'point'
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID ':' 'propagation' 'point' ';'
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }
		
		//'propagation'
		public Keyword getPropagationKeyword_2() { return cPropagationKeyword_2; }
		
		//'point'
		public Keyword getPointKeyword_3() { return cPointKeyword_3; }
		
		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}
	public class PropagationPathElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.PropagationPath");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0_0 = (RuleCall)cNameAssignment_0_0.eContents().get(0);
		private final Keyword cColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cSourceAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cSourceQualifiedPropagationPointParserRuleCall_1_0 = (RuleCall)cSourceAssignment_1.eContents().get(0);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTargetAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cTargetQualifiedPropagationPointParserRuleCall_3_0 = (RuleCall)cTargetAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//PropagationPath:
		//	(name=ID ':')? source=QualifiedPropagationPoint '->' target=QualifiedPropagationPoint ';';
		@Override public ParserRule getRule() { return rule; }
		
		//(name=ID ':')? source=QualifiedPropagationPoint '->' target=QualifiedPropagationPoint ';'
		public Group getGroup() { return cGroup; }
		
		//(name=ID ':')?
		public Group getGroup_0() { return cGroup_0; }
		
		//name=ID
		public Assignment getNameAssignment_0_0() { return cNameAssignment_0_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0_0() { return cNameIDTerminalRuleCall_0_0_0; }
		
		//':'
		public Keyword getColonKeyword_0_1() { return cColonKeyword_0_1; }
		
		//source=QualifiedPropagationPoint
		public Assignment getSourceAssignment_1() { return cSourceAssignment_1; }
		
		//QualifiedPropagationPoint
		public RuleCall getSourceQualifiedPropagationPointParserRuleCall_1_0() { return cSourceQualifiedPropagationPointParserRuleCall_1_0; }
		
		//'->'
		public Keyword getHyphenMinusGreaterThanSignKeyword_2() { return cHyphenMinusGreaterThanSignKeyword_2; }
		
		//target=QualifiedPropagationPoint
		public Assignment getTargetAssignment_3() { return cTargetAssignment_3; }
		
		//QualifiedPropagationPoint
		public RuleCall getTargetQualifiedPropagationPointParserRuleCall_3_0() { return cTargetQualifiedPropagationPointParserRuleCall_3_0; }
		
		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}
	public class QualifiedPropagationPointElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.QualifiedPropagationPoint");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Assignment cSubcomponentAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cSubcomponentSubcomponentElementParserRuleCall_0_0_0 = (RuleCall)cSubcomponentAssignment_0_0.eContents().get(0);
		private final Keyword cFullStopKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cNextAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cNextQualifiedPropagationPointParserRuleCall_0_2_0 = (RuleCall)cNextAssignment_0_2.eContents().get(0);
		private final Assignment cPropagationPointAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final CrossReference cPropagationPointNamedElementCrossReference_1_0 = (CrossReference)cPropagationPointAssignment_1.eContents().get(0);
		private final RuleCall cPropagationPointNamedElementIDTerminalRuleCall_1_0_1 = (RuleCall)cPropagationPointNamedElementCrossReference_1_0.eContents().get(1);
		
		//QualifiedPropagationPoint:
		//	subcomponent=SubcomponentElement '.' next=QualifiedPropagationPoint | propagationPoint=[aadl2::NamedElement];
		@Override public ParserRule getRule() { return rule; }
		
		//// zero or more subcomponent references
		//subcomponent=SubcomponentElement '.' next=QualifiedPropagationPoint | propagationPoint=[aadl2::NamedElement]
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//// zero or more subcomponent references
		//subcomponent=SubcomponentElement '.' next=QualifiedPropagationPoint
		public Group getGroup_0() { return cGroup_0; }
		
		//subcomponent=SubcomponentElement
		public Assignment getSubcomponentAssignment_0_0() { return cSubcomponentAssignment_0_0; }
		
		//SubcomponentElement
		public RuleCall getSubcomponentSubcomponentElementParserRuleCall_0_0_0() { return cSubcomponentSubcomponentElementParserRuleCall_0_0_0; }
		
		//'.'
		public Keyword getFullStopKeyword_0_1() { return cFullStopKeyword_0_1; }
		
		//next=QualifiedPropagationPoint
		public Assignment getNextAssignment_0_2() { return cNextAssignment_0_2; }
		
		//QualifiedPropagationPoint
		public RuleCall getNextQualifiedPropagationPointParserRuleCall_0_2_0() { return cNextQualifiedPropagationPointParserRuleCall_0_2_0; }
		
		//propagationPoint=[aadl2::NamedElement]
		public Assignment getPropagationPointAssignment_1() { return cPropagationPointAssignment_1; }
		
		//[aadl2::NamedElement]
		public CrossReference getPropagationPointNamedElementCrossReference_1_0() { return cPropagationPointNamedElementCrossReference_1_0; }
		
		//ID
		public RuleCall getPropagationPointNamedElementIDTerminalRuleCall_1_0_1() { return cPropagationPointNamedElementIDTerminalRuleCall_1_0_1; }
	}
	public class ErrorBehaviorStateMachineElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorStateMachine");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cErrorKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cBehaviorKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cUseKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cTypesKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Assignment cUseTypesAssignment_3_2 = (Assignment)cGroup_3.eContents().get(2);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_3_2_0 = (CrossReference)cUseTypesAssignment_3_2.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_3_2_0.eContents().get(1);
		private final Group cGroup_3_3 = (Group)cGroup_3.eContents().get(3);
		private final Keyword cCommaKeyword_3_3_0 = (Keyword)cGroup_3_3.eContents().get(0);
		private final Assignment cUseTypesAssignment_3_3_1 = (Assignment)cGroup_3_3.eContents().get(1);
		private final CrossReference cUseTypesErrorModelLibraryCrossReference_3_3_1_0 = (CrossReference)cUseTypesAssignment_3_3_1.eContents().get(0);
		private final RuleCall cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_3_1_0_1 = (RuleCall)cUseTypesErrorModelLibraryCrossReference_3_3_1_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_3_4 = (Keyword)cGroup_3.eContents().get(4);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cUseKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Keyword cTransformationsKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);
		private final Assignment cUseTransformationAssignment_4_2 = (Assignment)cGroup_4.eContents().get(2);
		private final CrossReference cUseTransformationTypeTransformationSetCrossReference_4_2_0 = (CrossReference)cUseTransformationAssignment_4_2.eContents().get(0);
		private final RuleCall cUseTransformationTypeTransformationSetQEMREFParserRuleCall_4_2_0_1 = (RuleCall)cUseTransformationTypeTransformationSetCrossReference_4_2_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cEventsKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cEventsAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cEventsErrorBehaviorEventParserRuleCall_5_1_0 = (RuleCall)cEventsAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cStatesKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cStatesAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cStatesErrorBehaviorStateParserRuleCall_6_1_0 = (RuleCall)cStatesAssignment_6_1.eContents().get(0);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cTransitionsKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cTransitionsAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cTransitionsErrorBehaviorTransitionParserRuleCall_7_1_0 = (RuleCall)cTransitionsAssignment_7_1.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cPropertiesKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Assignment cPropertiesAssignment_8_1 = (Assignment)cGroup_8.eContents().get(1);
		private final RuleCall cPropertiesBasicEMV2PropertyAssociationParserRuleCall_8_1_0 = (RuleCall)cPropertiesAssignment_8_1.eContents().get(0);
		private final Keyword cEndKeyword_9 = (Keyword)cGroup.eContents().get(9);
		private final Keyword cBehaviorKeyword_10 = (Keyword)cGroup.eContents().get(10);
		private final Keyword cSemicolonKeyword_11 = (Keyword)cGroup.eContents().get(11);
		
		//ErrorBehaviorStateMachine:
		//	'error' 'behavior' name=ID ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('use' 'transformations'
		//	useTransformation+=[TypeTransformationSet|QEMREF] ';')? ('events' events+=ErrorBehaviorEvent+)? ('states'
		//	states+=ErrorBehaviorState+)? ('transitions' transitions+=ErrorBehaviorTransition+)? ('properties'
		//	properties+=BasicEMV2PropertyAssociation+)?
		//	'end' 'behavior' ';';
		@Override public ParserRule getRule() { return rule; }
		
		//'error' 'behavior' name=ID ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
		//useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('use' 'transformations' useTransformation+=[TypeTransformationSet|QEMREF]
		//';')? ('events' events+=ErrorBehaviorEvent+)? ('states' states+=ErrorBehaviorState+)? ('transitions'
		//transitions+=ErrorBehaviorTransition+)? ('properties' properties+=BasicEMV2PropertyAssociation+)? 'end' 'behavior' ';'
		public Group getGroup() { return cGroup; }
		
		//'error'
		public Keyword getErrorKeyword_0() { return cErrorKeyword_0; }
		
		//'behavior'
		public Keyword getBehaviorKeyword_1() { return cBehaviorKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
		public Group getGroup_3() { return cGroup_3; }
		
		//'use'
		public Keyword getUseKeyword_3_0() { return cUseKeyword_3_0; }
		
		//'types'
		public Keyword getTypesKeyword_3_1() { return cTypesKeyword_3_1; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_3_2() { return cUseTypesAssignment_3_2; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_3_2_0() { return cUseTypesErrorModelLibraryCrossReference_3_2_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_0_1; }
		
		//(',' useTypes+=[ErrorModelLibrary|QEMREF])*
		public Group getGroup_3_3() { return cGroup_3_3; }
		
		//','
		public Keyword getCommaKeyword_3_3_0() { return cCommaKeyword_3_3_0; }
		
		//useTypes+=[ErrorModelLibrary|QEMREF]
		public Assignment getUseTypesAssignment_3_3_1() { return cUseTypesAssignment_3_3_1; }
		
		//[ErrorModelLibrary|QEMREF]
		public CrossReference getUseTypesErrorModelLibraryCrossReference_3_3_1_0() { return cUseTypesErrorModelLibraryCrossReference_3_3_1_0; }
		
		//QEMREF
		public RuleCall getUseTypesErrorModelLibraryQEMREFParserRuleCall_3_3_1_0_1() { return cUseTypesErrorModelLibraryQEMREFParserRuleCall_3_3_1_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_3_4() { return cSemicolonKeyword_3_4; }
		
		//('use' 'transformations' useTransformation+=[TypeTransformationSet|QEMREF] ';')?
		public Group getGroup_4() { return cGroup_4; }
		
		//'use'
		public Keyword getUseKeyword_4_0() { return cUseKeyword_4_0; }
		
		//'transformations'
		public Keyword getTransformationsKeyword_4_1() { return cTransformationsKeyword_4_1; }
		
		//useTransformation+=[TypeTransformationSet|QEMREF]
		public Assignment getUseTransformationAssignment_4_2() { return cUseTransformationAssignment_4_2; }
		
		//[TypeTransformationSet|QEMREF]
		public CrossReference getUseTransformationTypeTransformationSetCrossReference_4_2_0() { return cUseTransformationTypeTransformationSetCrossReference_4_2_0; }
		
		//QEMREF
		public RuleCall getUseTransformationTypeTransformationSetQEMREFParserRuleCall_4_2_0_1() { return cUseTransformationTypeTransformationSetQEMREFParserRuleCall_4_2_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_4_3() { return cSemicolonKeyword_4_3; }
		
		//('events' events+=ErrorBehaviorEvent+)?
		public Group getGroup_5() { return cGroup_5; }
		
		//'events'
		public Keyword getEventsKeyword_5_0() { return cEventsKeyword_5_0; }
		
		//events+=ErrorBehaviorEvent+
		public Assignment getEventsAssignment_5_1() { return cEventsAssignment_5_1; }
		
		//ErrorBehaviorEvent
		public RuleCall getEventsErrorBehaviorEventParserRuleCall_5_1_0() { return cEventsErrorBehaviorEventParserRuleCall_5_1_0; }
		
		//('states' states+=ErrorBehaviorState+)?
		public Group getGroup_6() { return cGroup_6; }
		
		//'states'
		public Keyword getStatesKeyword_6_0() { return cStatesKeyword_6_0; }
		
		//states+=ErrorBehaviorState+
		public Assignment getStatesAssignment_6_1() { return cStatesAssignment_6_1; }
		
		//ErrorBehaviorState
		public RuleCall getStatesErrorBehaviorStateParserRuleCall_6_1_0() { return cStatesErrorBehaviorStateParserRuleCall_6_1_0; }
		
		//('transitions' transitions+=ErrorBehaviorTransition+)?
		public Group getGroup_7() { return cGroup_7; }
		
		//'transitions'
		public Keyword getTransitionsKeyword_7_0() { return cTransitionsKeyword_7_0; }
		
		//transitions+=ErrorBehaviorTransition+
		public Assignment getTransitionsAssignment_7_1() { return cTransitionsAssignment_7_1; }
		
		//ErrorBehaviorTransition
		public RuleCall getTransitionsErrorBehaviorTransitionParserRuleCall_7_1_0() { return cTransitionsErrorBehaviorTransitionParserRuleCall_7_1_0; }
		
		//('properties' properties+=BasicEMV2PropertyAssociation+)?
		public Group getGroup_8() { return cGroup_8; }
		
		//'properties'
		public Keyword getPropertiesKeyword_8_0() { return cPropertiesKeyword_8_0; }
		
		//properties+=BasicEMV2PropertyAssociation+
		public Assignment getPropertiesAssignment_8_1() { return cPropertiesAssignment_8_1; }
		
		//BasicEMV2PropertyAssociation
		public RuleCall getPropertiesBasicEMV2PropertyAssociationParserRuleCall_8_1_0() { return cPropertiesBasicEMV2PropertyAssociationParserRuleCall_8_1_0; }
		
		//'end'
		public Keyword getEndKeyword_9() { return cEndKeyword_9; }
		
		//'behavior'
		public Keyword getBehaviorKeyword_10() { return cBehaviorKeyword_10; }
		
		//';'
		public Keyword getSemicolonKeyword_11() { return cSemicolonKeyword_11; }
	}
	public class ErrorBehaviorEventElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorEvent");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cErrorEventParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRepairEventParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cRecoverEventParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//ErrorBehaviorEvent:
		//	ErrorEvent | RepairEvent | RecoverEvent;
		@Override public ParserRule getRule() { return rule; }
		
		//ErrorEvent | RepairEvent | RecoverEvent
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ErrorEvent
		public RuleCall getErrorEventParserRuleCall_0() { return cErrorEventParserRuleCall_0; }
		
		//RepairEvent
		public RuleCall getRepairEventParserRuleCall_1() { return cRepairEventParserRuleCall_1; }
		
		//RecoverEvent
		public RuleCall getRecoverEventParserRuleCall_2() { return cRecoverEventParserRuleCall_2; }
	}
	public class ErrorEventElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorEvent");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cErrorKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cEventKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cTypeSetAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cTypeSetTypeSetReferenceParserRuleCall_4_0 = (RuleCall)cTypeSetAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cIfKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cEventconditionAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cEventconditionIfConditionParserRuleCall_5_1_0 = (RuleCall)cEventconditionAssignment_5_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//ErrorEvent:
		//	name=ID ':' 'error' 'event'
		//	typeSet=TypeSetReference? ('if' eventcondition=IfCondition)?
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID ':' 'error' 'event' typeSet=TypeSetReference? ('if' eventcondition=IfCondition)? ';'
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }
		
		//'error'
		public Keyword getErrorKeyword_2() { return cErrorKeyword_2; }
		
		//'event'
		public Keyword getEventKeyword_3() { return cEventKeyword_3; }
		
		//typeSet=TypeSetReference?
		public Assignment getTypeSetAssignment_4() { return cTypeSetAssignment_4; }
		
		//TypeSetReference
		public RuleCall getTypeSetTypeSetReferenceParserRuleCall_4_0() { return cTypeSetTypeSetReferenceParserRuleCall_4_0; }
		
		//('if' eventcondition=IfCondition)?
		public Group getGroup_5() { return cGroup_5; }
		
		//'if'
		public Keyword getIfKeyword_5_0() { return cIfKeyword_5_0; }
		
		//eventcondition=IfCondition
		public Assignment getEventconditionAssignment_5_1() { return cEventconditionAssignment_5_1; }
		
		//IfCondition
		public RuleCall getEventconditionIfConditionParserRuleCall_5_1_0() { return cEventconditionIfConditionParserRuleCall_5_1_0; }
		
		//';'
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
	}
	public class RepairEventElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.RepairEvent");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cRepairKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cEventKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cWhenKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cEventInitiatorAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final CrossReference cEventInitiatorNamedElementCrossReference_4_1_0 = (CrossReference)cEventInitiatorAssignment_4_1.eContents().get(0);
		private final RuleCall cEventInitiatorNamedElementIDTerminalRuleCall_4_1_0_1 = (RuleCall)cEventInitiatorNamedElementCrossReference_4_1_0.eContents().get(1);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Keyword cCommaKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cEventInitiatorAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final CrossReference cEventInitiatorNamedElementCrossReference_4_2_1_0 = (CrossReference)cEventInitiatorAssignment_4_2_1.eContents().get(0);
		private final RuleCall cEventInitiatorNamedElementIDTerminalRuleCall_4_2_1_0_1 = (RuleCall)cEventInitiatorNamedElementCrossReference_4_2_1_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//// add event condition 
		//RepairEvent:
		//	name=ID ':' 'repair' 'event' ('when' eventInitiator+=[aadl2::NamedElement] (","
		//	eventInitiator+=[aadl2::NamedElement])*)?
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID ':' 'repair' 'event' ('when' eventInitiator+=[aadl2::NamedElement] (","
		//eventInitiator+=[aadl2::NamedElement])*)? ';'
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }
		
		//'repair'
		public Keyword getRepairKeyword_2() { return cRepairKeyword_2; }
		
		//'event'
		public Keyword getEventKeyword_3() { return cEventKeyword_3; }
		
		//('when' eventInitiator+=[aadl2::NamedElement] ("," eventInitiator+=[aadl2::NamedElement])*)?
		public Group getGroup_4() { return cGroup_4; }
		
		//'when'
		public Keyword getWhenKeyword_4_0() { return cWhenKeyword_4_0; }
		
		//eventInitiator+=[aadl2::NamedElement]
		public Assignment getEventInitiatorAssignment_4_1() { return cEventInitiatorAssignment_4_1; }
		
		//[aadl2::NamedElement]
		public CrossReference getEventInitiatorNamedElementCrossReference_4_1_0() { return cEventInitiatorNamedElementCrossReference_4_1_0; }
		
		//ID
		public RuleCall getEventInitiatorNamedElementIDTerminalRuleCall_4_1_0_1() { return cEventInitiatorNamedElementIDTerminalRuleCall_4_1_0_1; }
		
		//("," eventInitiator+=[aadl2::NamedElement])*
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//","
		public Keyword getCommaKeyword_4_2_0() { return cCommaKeyword_4_2_0; }
		
		//eventInitiator+=[aadl2::NamedElement]
		public Assignment getEventInitiatorAssignment_4_2_1() { return cEventInitiatorAssignment_4_2_1; }
		
		//[aadl2::NamedElement]
		public CrossReference getEventInitiatorNamedElementCrossReference_4_2_1_0() { return cEventInitiatorNamedElementCrossReference_4_2_1_0; }
		
		//ID
		public RuleCall getEventInitiatorNamedElementIDTerminalRuleCall_4_2_1_0_1() { return cEventInitiatorNamedElementIDTerminalRuleCall_4_2_1_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_5() { return cSemicolonKeyword_5; }
	}
	public class RecoverEventElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.RecoverEvent");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cRecoverKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cEventKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cWhenKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cEventInitiatorAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final CrossReference cEventInitiatorNamedElementCrossReference_4_1_0 = (CrossReference)cEventInitiatorAssignment_4_1.eContents().get(0);
		private final RuleCall cEventInitiatorNamedElementIDTerminalRuleCall_4_1_0_1 = (RuleCall)cEventInitiatorNamedElementCrossReference_4_1_0.eContents().get(1);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Keyword cCommaKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cEventInitiatorAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final CrossReference cEventInitiatorNamedElementCrossReference_4_2_1_0 = (CrossReference)cEventInitiatorAssignment_4_2_1.eContents().get(0);
		private final RuleCall cEventInitiatorNamedElementIDTerminalRuleCall_4_2_1_0_1 = (RuleCall)cEventInitiatorNamedElementCrossReference_4_2_1_0.eContents().get(1);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cIfKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cConditionAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cConditionIfConditionParserRuleCall_5_1_0 = (RuleCall)cConditionAssignment_5_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//RecoverEvent:
		//	name=ID ':' 'recover' 'event' ('when' eventInitiator+=[aadl2::NamedElement] (","
		//	eventInitiator+=[aadl2::NamedElement])*)? ('if' condition=IfCondition)?
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID ':' 'recover' 'event' ('when' eventInitiator+=[aadl2::NamedElement] (","
		//eventInitiator+=[aadl2::NamedElement])*)? ('if' condition=IfCondition)? ';'
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }
		
		//'recover'
		public Keyword getRecoverKeyword_2() { return cRecoverKeyword_2; }
		
		//'event'
		public Keyword getEventKeyword_3() { return cEventKeyword_3; }
		
		//('when' eventInitiator+=[aadl2::NamedElement] ("," eventInitiator+=[aadl2::NamedElement])*)?
		public Group getGroup_4() { return cGroup_4; }
		
		//'when'
		public Keyword getWhenKeyword_4_0() { return cWhenKeyword_4_0; }
		
		//eventInitiator+=[aadl2::NamedElement]
		public Assignment getEventInitiatorAssignment_4_1() { return cEventInitiatorAssignment_4_1; }
		
		//[aadl2::NamedElement]
		public CrossReference getEventInitiatorNamedElementCrossReference_4_1_0() { return cEventInitiatorNamedElementCrossReference_4_1_0; }
		
		//ID
		public RuleCall getEventInitiatorNamedElementIDTerminalRuleCall_4_1_0_1() { return cEventInitiatorNamedElementIDTerminalRuleCall_4_1_0_1; }
		
		//("," eventInitiator+=[aadl2::NamedElement])*
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//","
		public Keyword getCommaKeyword_4_2_0() { return cCommaKeyword_4_2_0; }
		
		//eventInitiator+=[aadl2::NamedElement]
		public Assignment getEventInitiatorAssignment_4_2_1() { return cEventInitiatorAssignment_4_2_1; }
		
		//[aadl2::NamedElement]
		public CrossReference getEventInitiatorNamedElementCrossReference_4_2_1_0() { return cEventInitiatorNamedElementCrossReference_4_2_1_0; }
		
		//ID
		public RuleCall getEventInitiatorNamedElementIDTerminalRuleCall_4_2_1_0_1() { return cEventInitiatorNamedElementIDTerminalRuleCall_4_2_1_0_1; }
		
		//('if' condition=IfCondition)?
		public Group getGroup_5() { return cGroup_5; }
		
		//'if'
		public Keyword getIfKeyword_5_0() { return cIfKeyword_5_0; }
		
		//condition=IfCondition
		public Assignment getConditionAssignment_5_1() { return cConditionAssignment_5_1; }
		
		//IfCondition
		public RuleCall getConditionIfConditionParserRuleCall_5_1_0() { return cConditionIfConditionParserRuleCall_5_1_0; }
		
		//';'
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
	}
	public class ErrorBehaviorStateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorState");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cIntialAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cIntialInitialKeyword_2_0 = (Keyword)cIntialAssignment_2.eContents().get(0);
		private final Keyword cStateKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cTypeSetAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cTypeSetTypeSetReferenceParserRuleCall_4_0 = (RuleCall)cTypeSetAssignment_4.eContents().get(0);
		private final Keyword cSemicolonKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		////add recover initiator 
		//ErrorBehaviorState:
		//	name=ID ':' intial?='initial'? 'state'
		//	typeSet=TypeSetReference?
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID ':' intial?='initial'? 'state' typeSet=TypeSetReference? ';'
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }
		
		//intial?='initial'?
		public Assignment getIntialAssignment_2() { return cIntialAssignment_2; }
		
		//'initial'
		public Keyword getIntialInitialKeyword_2_0() { return cIntialInitialKeyword_2_0; }
		
		//'state'
		public Keyword getStateKeyword_3() { return cStateKeyword_3; }
		
		//typeSet=TypeSetReference?
		public Assignment getTypeSetAssignment_4() { return cTypeSetAssignment_4; }
		
		//TypeSetReference
		public RuleCall getTypeSetTypeSetReferenceParserRuleCall_4_0() { return cTypeSetTypeSetReferenceParserRuleCall_4_0; }
		
		//';'
		public Keyword getSemicolonKeyword_5() { return cSemicolonKeyword_5; }
	}
	public class ErrorBehaviorTransitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorTransition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0_0 = (RuleCall)cNameAssignment_0_0.eContents().get(0);
		private final Keyword cColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Assignment cSourceAssignment_1_0_0 = (Assignment)cGroup_1_0.eContents().get(0);
		private final CrossReference cSourceErrorBehaviorStateCrossReference_1_0_0_0 = (CrossReference)cSourceAssignment_1_0_0.eContents().get(0);
		private final RuleCall cSourceErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1 = (RuleCall)cSourceErrorBehaviorStateCrossReference_1_0_0_0.eContents().get(1);
		private final Assignment cTypeTokenConstraintAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final RuleCall cTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0 = (RuleCall)cTypeTokenConstraintAssignment_1_0_1.eContents().get(0);
		private final Assignment cAllStatesAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final Keyword cAllStatesAllKeyword_1_1_0 = (Keyword)cAllStatesAssignment_1_1.eContents().get(0);
		private final Keyword cHyphenMinusLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cConditionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cConditionConditionExpressionParserRuleCall_3_0 = (RuleCall)cConditionAssignment_3.eContents().get(0);
		private final Keyword cRightSquareBracketHyphenMinusGreaterThanSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Group cGroup_5_0 = (Group)cAlternatives_5.eContents().get(0);
		private final Assignment cTargetAssignment_5_0_0 = (Assignment)cGroup_5_0.eContents().get(0);
		private final CrossReference cTargetErrorBehaviorStateCrossReference_5_0_0_0 = (CrossReference)cTargetAssignment_5_0_0.eContents().get(0);
		private final RuleCall cTargetErrorBehaviorStateIDTerminalRuleCall_5_0_0_0_1 = (RuleCall)cTargetErrorBehaviorStateCrossReference_5_0_0_0.eContents().get(1);
		private final Assignment cTargetTokenAssignment_5_0_1 = (Assignment)cGroup_5_0.eContents().get(1);
		private final RuleCall cTargetTokenTypeTokenParserRuleCall_5_0_1_0 = (RuleCall)cTargetTokenAssignment_5_0_1.eContents().get(0);
		private final Group cGroup_5_1 = (Group)cAlternatives_5.eContents().get(1);
		private final Assignment cSteadyStateAssignment_5_1_0 = (Assignment)cGroup_5_1.eContents().get(0);
		private final Keyword cSteadyStateSameKeyword_5_1_0_0 = (Keyword)cSteadyStateAssignment_5_1_0.eContents().get(0);
		private final Keyword cStateKeyword_5_1_1 = (Keyword)cGroup_5_1.eContents().get(1);
		private final Group cGroup_5_2 = (Group)cAlternatives_5.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_5_2_0 = (Keyword)cGroup_5_2.eContents().get(0);
		private final Assignment cDestinationBranchesAssignment_5_2_1 = (Assignment)cGroup_5_2.eContents().get(1);
		private final RuleCall cDestinationBranchesTransitionBranchParserRuleCall_5_2_1_0 = (RuleCall)cDestinationBranchesAssignment_5_2_1.eContents().get(0);
		private final Group cGroup_5_2_2 = (Group)cGroup_5_2.eContents().get(2);
		private final Keyword cCommaKeyword_5_2_2_0 = (Keyword)cGroup_5_2_2.eContents().get(0);
		private final Assignment cDestinationBranchesAssignment_5_2_2_1 = (Assignment)cGroup_5_2_2.eContents().get(1);
		private final RuleCall cDestinationBranchesTransitionBranchParserRuleCall_5_2_2_1_0 = (RuleCall)cDestinationBranchesAssignment_5_2_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5_2_3 = (Keyword)cGroup_5_2.eContents().get(3);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//ErrorBehaviorTransition:
		//	(name=ID ':')? (source=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint? | allStates?='all')
		//	'-[' condition=ConditionExpression ']->' (target=[ErrorBehaviorState] targetToken=TypeToken? | steadyState?='same'
		//	'state' | '(' destinationBranches+=TransitionBranch (',' destinationBranches+=TransitionBranch)+ ')')
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//(name=ID ':')? (source=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint? | allStates?='all') '-['
		//condition=ConditionExpression ']->' (target=[ErrorBehaviorState] targetToken=TypeToken? | steadyState?='same' 'state' |
		//'(' destinationBranches+=TransitionBranch (',' destinationBranches+=TransitionBranch)+ ')') ';'
		public Group getGroup() { return cGroup; }
		
		//(name=ID ':')?
		public Group getGroup_0() { return cGroup_0; }
		
		//name=ID
		public Assignment getNameAssignment_0_0() { return cNameAssignment_0_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0_0() { return cNameIDTerminalRuleCall_0_0_0; }
		
		//':'
		public Keyword getColonKeyword_0_1() { return cColonKeyword_0_1; }
		
		//(source=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint? | allStates?='all')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//source=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint?
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//source=[ErrorBehaviorState]
		public Assignment getSourceAssignment_1_0_0() { return cSourceAssignment_1_0_0; }
		
		//[ErrorBehaviorState]
		public CrossReference getSourceErrorBehaviorStateCrossReference_1_0_0_0() { return cSourceErrorBehaviorStateCrossReference_1_0_0_0; }
		
		//ID
		public RuleCall getSourceErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1() { return cSourceErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1; }
		
		//typeTokenConstraint=TypeTokenConstraint?
		public Assignment getTypeTokenConstraintAssignment_1_0_1() { return cTypeTokenConstraintAssignment_1_0_1; }
		
		//TypeTokenConstraint
		public RuleCall getTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0() { return cTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0; }
		
		//allStates?='all'
		public Assignment getAllStatesAssignment_1_1() { return cAllStatesAssignment_1_1; }
		
		//'all'
		public Keyword getAllStatesAllKeyword_1_1_0() { return cAllStatesAllKeyword_1_1_0; }
		
		//'-['
		public Keyword getHyphenMinusLeftSquareBracketKeyword_2() { return cHyphenMinusLeftSquareBracketKeyword_2; }
		
		//condition=ConditionExpression
		public Assignment getConditionAssignment_3() { return cConditionAssignment_3; }
		
		//ConditionExpression
		public RuleCall getConditionConditionExpressionParserRuleCall_3_0() { return cConditionConditionExpressionParserRuleCall_3_0; }
		
		//']->'
		public Keyword getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4() { return cRightSquareBracketHyphenMinusGreaterThanSignKeyword_4; }
		
		//(target=[ErrorBehaviorState] targetToken=TypeToken? | steadyState?='same' 'state' | '('
		//destinationBranches+=TransitionBranch (',' destinationBranches+=TransitionBranch)+ ')')
		public Alternatives getAlternatives_5() { return cAlternatives_5; }
		
		//target=[ErrorBehaviorState] targetToken=TypeToken?
		public Group getGroup_5_0() { return cGroup_5_0; }
		
		//target=[ErrorBehaviorState]
		public Assignment getTargetAssignment_5_0_0() { return cTargetAssignment_5_0_0; }
		
		//[ErrorBehaviorState]
		public CrossReference getTargetErrorBehaviorStateCrossReference_5_0_0_0() { return cTargetErrorBehaviorStateCrossReference_5_0_0_0; }
		
		//ID
		public RuleCall getTargetErrorBehaviorStateIDTerminalRuleCall_5_0_0_0_1() { return cTargetErrorBehaviorStateIDTerminalRuleCall_5_0_0_0_1; }
		
		//targetToken=TypeToken?
		public Assignment getTargetTokenAssignment_5_0_1() { return cTargetTokenAssignment_5_0_1; }
		
		//TypeToken
		public RuleCall getTargetTokenTypeTokenParserRuleCall_5_0_1_0() { return cTargetTokenTypeTokenParserRuleCall_5_0_1_0; }
		
		//steadyState?='same' 'state'
		public Group getGroup_5_1() { return cGroup_5_1; }
		
		//steadyState?='same'
		public Assignment getSteadyStateAssignment_5_1_0() { return cSteadyStateAssignment_5_1_0; }
		
		//'same'
		public Keyword getSteadyStateSameKeyword_5_1_0_0() { return cSteadyStateSameKeyword_5_1_0_0; }
		
		//'state'
		public Keyword getStateKeyword_5_1_1() { return cStateKeyword_5_1_1; }
		
		//'(' destinationBranches+=TransitionBranch (',' destinationBranches+=TransitionBranch)+ ')'
		public Group getGroup_5_2() { return cGroup_5_2; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_5_2_0() { return cLeftParenthesisKeyword_5_2_0; }
		
		//destinationBranches+=TransitionBranch
		public Assignment getDestinationBranchesAssignment_5_2_1() { return cDestinationBranchesAssignment_5_2_1; }
		
		//TransitionBranch
		public RuleCall getDestinationBranchesTransitionBranchParserRuleCall_5_2_1_0() { return cDestinationBranchesTransitionBranchParserRuleCall_5_2_1_0; }
		
		//(',' destinationBranches+=TransitionBranch)+
		public Group getGroup_5_2_2() { return cGroup_5_2_2; }
		
		//','
		public Keyword getCommaKeyword_5_2_2_0() { return cCommaKeyword_5_2_2_0; }
		
		//destinationBranches+=TransitionBranch
		public Assignment getDestinationBranchesAssignment_5_2_2_1() { return cDestinationBranchesAssignment_5_2_2_1; }
		
		//TransitionBranch
		public RuleCall getDestinationBranchesTransitionBranchParserRuleCall_5_2_2_1_0() { return cDestinationBranchesTransitionBranchParserRuleCall_5_2_2_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5_2_3() { return cRightParenthesisKeyword_5_2_3; }
		
		//';'
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
	}
	public class TransitionBranchElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.TransitionBranch");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cAlternatives_0.eContents().get(0);
		private final Assignment cTargetAssignment_0_0_0 = (Assignment)cGroup_0_0.eContents().get(0);
		private final CrossReference cTargetErrorBehaviorStateCrossReference_0_0_0_0 = (CrossReference)cTargetAssignment_0_0_0.eContents().get(0);
		private final RuleCall cTargetErrorBehaviorStateIDTerminalRuleCall_0_0_0_0_1 = (RuleCall)cTargetErrorBehaviorStateCrossReference_0_0_0_0.eContents().get(1);
		private final Assignment cTargetTokenAssignment_0_0_1 = (Assignment)cGroup_0_0.eContents().get(1);
		private final RuleCall cTargetTokenTypeTokenParserRuleCall_0_0_1_0 = (RuleCall)cTargetTokenAssignment_0_0_1.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cAlternatives_0.eContents().get(1);
		private final Assignment cSteadyStateAssignment_0_1_0 = (Assignment)cGroup_0_1.eContents().get(0);
		private final Keyword cSteadyStateSameKeyword_0_1_0_0 = (Keyword)cSteadyStateAssignment_0_1_0.eContents().get(0);
		private final Keyword cStateKeyword_0_1_1 = (Keyword)cGroup_0_1.eContents().get(1);
		private final Keyword cWithKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cValueBranchValueParserRuleCall_2_0 = (RuleCall)cValueAssignment_2.eContents().get(0);
		
		//TransitionBranch:
		//	(target=[ErrorBehaviorState] targetToken=TypeToken? | steadyState?='same' 'state')
		//	'with' value=BranchValue;
		@Override public ParserRule getRule() { return rule; }
		
		//(target=[ErrorBehaviorState] targetToken=TypeToken? | steadyState?='same' 'state') 'with' value=BranchValue
		public Group getGroup() { return cGroup; }
		
		//(target=[ErrorBehaviorState] targetToken=TypeToken? | steadyState?='same' 'state')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//target=[ErrorBehaviorState] targetToken=TypeToken?
		public Group getGroup_0_0() { return cGroup_0_0; }
		
		//target=[ErrorBehaviorState]
		public Assignment getTargetAssignment_0_0_0() { return cTargetAssignment_0_0_0; }
		
		//[ErrorBehaviorState]
		public CrossReference getTargetErrorBehaviorStateCrossReference_0_0_0_0() { return cTargetErrorBehaviorStateCrossReference_0_0_0_0; }
		
		//ID
		public RuleCall getTargetErrorBehaviorStateIDTerminalRuleCall_0_0_0_0_1() { return cTargetErrorBehaviorStateIDTerminalRuleCall_0_0_0_0_1; }
		
		//targetToken=TypeToken?
		public Assignment getTargetTokenAssignment_0_0_1() { return cTargetTokenAssignment_0_0_1; }
		
		//TypeToken
		public RuleCall getTargetTokenTypeTokenParserRuleCall_0_0_1_0() { return cTargetTokenTypeTokenParserRuleCall_0_0_1_0; }
		
		//steadyState?='same' 'state'
		public Group getGroup_0_1() { return cGroup_0_1; }
		
		//steadyState?='same'
		public Assignment getSteadyStateAssignment_0_1_0() { return cSteadyStateAssignment_0_1_0; }
		
		//'same'
		public Keyword getSteadyStateSameKeyword_0_1_0_0() { return cSteadyStateSameKeyword_0_1_0_0; }
		
		//'state'
		public Keyword getStateKeyword_0_1_1() { return cStateKeyword_0_1_1; }
		
		//'with'
		public Keyword getWithKeyword_1() { return cWithKeyword_1; }
		
		//value=BranchValue
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }
		
		//BranchValue
		public RuleCall getValueBranchValueParserRuleCall_2_0() { return cValueBranchValueParserRuleCall_2_0; }
	}
	public class BranchValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.BranchValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBranchValueAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cRealvalueAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cRealvalueREAL_LITTerminalRuleCall_1_0_0 = (RuleCall)cRealvalueAssignment_1_0.eContents().get(0);
		private final Assignment cSymboliclabelAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final CrossReference cSymboliclabelPropertyCrossReference_1_1_0 = (CrossReference)cSymboliclabelAssignment_1_1.eContents().get(0);
		private final RuleCall cSymboliclabelPropertyQEMREFParserRuleCall_1_1_0_1 = (RuleCall)cSymboliclabelPropertyCrossReference_1_1_0.eContents().get(1);
		private final Assignment cOthersAssignment_1_2 = (Assignment)cAlternatives_1.eContents().get(2);
		private final Keyword cOthersOthersKeyword_1_2_0 = (Keyword)cOthersAssignment_1_2.eContents().get(0);
		
		//// store real literal as integer, ID as reference to property constant
		//BranchValue:
		//	{BranchValue} (realvalue=REAL_LIT | symboliclabel=[aadl2::Property|QEMREF] | others?='others');
		@Override public ParserRule getRule() { return rule; }
		
		//{BranchValue} (realvalue=REAL_LIT | symboliclabel=[aadl2::Property|QEMREF] | others?='others')
		public Group getGroup() { return cGroup; }
		
		//{BranchValue}
		public Action getBranchValueAction_0() { return cBranchValueAction_0; }
		
		//(realvalue=REAL_LIT | symboliclabel=[aadl2::Property|QEMREF] | others?='others')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//realvalue=REAL_LIT
		public Assignment getRealvalueAssignment_1_0() { return cRealvalueAssignment_1_0; }
		
		//REAL_LIT
		public RuleCall getRealvalueREAL_LITTerminalRuleCall_1_0_0() { return cRealvalueREAL_LITTerminalRuleCall_1_0_0; }
		
		//symboliclabel=[aadl2::Property|QEMREF]
		public Assignment getSymboliclabelAssignment_1_1() { return cSymboliclabelAssignment_1_1; }
		
		//[aadl2::Property|QEMREF]
		public CrossReference getSymboliclabelPropertyCrossReference_1_1_0() { return cSymboliclabelPropertyCrossReference_1_1_0; }
		
		//QEMREF
		public RuleCall getSymboliclabelPropertyQEMREFParserRuleCall_1_1_0_1() { return cSymboliclabelPropertyQEMREFParserRuleCall_1_1_0_1; }
		
		//others?='others'
		public Assignment getOthersAssignment_1_2() { return cOthersAssignment_1_2; }
		
		//'others'
		public Keyword getOthersOthersKeyword_1_2_0() { return cOthersOthersKeyword_1_2_0; }
	}
	public class ConditionExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ConditionExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAndExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cOrExpressionOperandsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cOrKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cOperandsAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cOperandsAndExpressionParserRuleCall_1_2_0 = (RuleCall)cOperandsAssignment_1_2.eContents().get(0);
		
		//// condition expression for component specific transitions 
		//// based on error events and incoming propagations
		//ConditionExpression:
		//	AndExpression ({OrExpression.operands+=current} 'or' operands+=AndExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//AndExpression ({OrExpression.operands+=current} 'or' operands+=AndExpression)*
		public Group getGroup() { return cGroup; }
		
		//AndExpression
		public RuleCall getAndExpressionParserRuleCall_0() { return cAndExpressionParserRuleCall_0; }
		
		//({OrExpression.operands+=current} 'or' operands+=AndExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{OrExpression.operands+=current}
		public Action getOrExpressionOperandsAction_1_0() { return cOrExpressionOperandsAction_1_0; }
		
		//'or'
		public Keyword getOrKeyword_1_1() { return cOrKeyword_1_1; }
		
		//operands+=AndExpression
		public Assignment getOperandsAssignment_1_2() { return cOperandsAssignment_1_2; }
		
		//AndExpression
		public RuleCall getOperandsAndExpressionParserRuleCall_1_2_0() { return cOperandsAndExpressionParserRuleCall_1_2_0; }
	}
	public class AndExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.AndExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cConditionTermParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cAndExpressionOperandsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cAndKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cOperandsAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cOperandsConditionTermParserRuleCall_1_2_0 = (RuleCall)cOperandsAssignment_1_2.eContents().get(0);
		
		//AndExpression ConditionExpression:
		//	ConditionTerm ({AndExpression.operands+=current} 'and' operands+=ConditionTerm)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ConditionTerm ({AndExpression.operands+=current} 'and' operands+=ConditionTerm)*
		public Group getGroup() { return cGroup; }
		
		//ConditionTerm
		public RuleCall getConditionTermParserRuleCall_0() { return cConditionTermParserRuleCall_0; }
		
		//({AndExpression.operands+=current} 'and' operands+=ConditionTerm)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{AndExpression.operands+=current}
		public Action getAndExpressionOperandsAction_1_0() { return cAndExpressionOperandsAction_1_0; }
		
		//'and'
		public Keyword getAndKeyword_1_1() { return cAndKeyword_1_1; }
		
		//operands+=ConditionTerm
		public Assignment getOperandsAssignment_1_2() { return cOperandsAssignment_1_2; }
		
		//ConditionTerm
		public RuleCall getOperandsConditionTermParserRuleCall_1_2_0() { return cOperandsConditionTermParserRuleCall_1_2_0; }
	}
	public class AllExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.AllExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAllExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cAllKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cHyphenMinusKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cCountAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cCountINTVALUEParserRuleCall_2_1_0 = (RuleCall)cCountAssignment_2_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOperandsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOperandsConditionElementParserRuleCall_4_0 = (RuleCall)cOperandsAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cCommaKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cOperandsAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cOperandsConditionElementParserRuleCall_5_1_0 = (RuleCall)cOperandsAssignment_5_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//AllExpression ConditionExpression:
		//	{AllExpression} 'all' ('-' count=INTVALUE)? '(' operands+=ConditionElement (',' operands+=ConditionElement)* ')';
		@Override public ParserRule getRule() { return rule; }
		
		//{AllExpression} 'all' ('-' count=INTVALUE)? '(' operands+=ConditionElement (',' operands+=ConditionElement)* ')'
		public Group getGroup() { return cGroup; }
		
		//{AllExpression}
		public Action getAllExpressionAction_0() { return cAllExpressionAction_0; }
		
		//'all'
		public Keyword getAllKeyword_1() { return cAllKeyword_1; }
		
		//('-' count=INTVALUE)?
		public Group getGroup_2() { return cGroup_2; }
		
		//'-'
		public Keyword getHyphenMinusKeyword_2_0() { return cHyphenMinusKeyword_2_0; }
		
		//count=INTVALUE
		public Assignment getCountAssignment_2_1() { return cCountAssignment_2_1; }
		
		//INTVALUE
		public RuleCall getCountINTVALUEParserRuleCall_2_1_0() { return cCountINTVALUEParserRuleCall_2_1_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }
		
		//operands+=ConditionElement
		public Assignment getOperandsAssignment_4() { return cOperandsAssignment_4; }
		
		//ConditionElement
		public RuleCall getOperandsConditionElementParserRuleCall_4_0() { return cOperandsConditionElementParserRuleCall_4_0; }
		
		//(',' operands+=ConditionElement)*
		public Group getGroup_5() { return cGroup_5; }
		
		//','
		public Keyword getCommaKeyword_5_0() { return cCommaKeyword_5_0; }
		
		//operands+=ConditionElement
		public Assignment getOperandsAssignment_5_1() { return cOperandsAssignment_5_1; }
		
		//ConditionElement
		public RuleCall getOperandsConditionElementParserRuleCall_5_1_0() { return cOperandsConditionElementParserRuleCall_5_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }
	}
	public class OrmoreExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.OrmoreExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cCountAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cCountINTVALUEParserRuleCall_0_0 = (RuleCall)cCountAssignment_0.eContents().get(0);
		private final Keyword cOrmoreKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOperandsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOperandsConditionExpressionParserRuleCall_3_0 = (RuleCall)cOperandsAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOperandsAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOperandsConditionExpressionParserRuleCall_4_1_0 = (RuleCall)cOperandsAssignment_4_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//OrmoreExpression:
		//	count=INTVALUE 'ormore' '(' operands+=ConditionExpression (',' operands+=ConditionExpression)* ')';
		@Override public ParserRule getRule() { return rule; }
		
		//count=INTVALUE 'ormore' '(' operands+=ConditionExpression (',' operands+=ConditionExpression)* ')'
		public Group getGroup() { return cGroup; }
		
		//count=INTVALUE
		public Assignment getCountAssignment_0() { return cCountAssignment_0; }
		
		//INTVALUE
		public RuleCall getCountINTVALUEParserRuleCall_0_0() { return cCountINTVALUEParserRuleCall_0_0; }
		
		//'ormore'
		public Keyword getOrmoreKeyword_1() { return cOrmoreKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//operands+=ConditionExpression
		public Assignment getOperandsAssignment_3() { return cOperandsAssignment_3; }
		
		//ConditionExpression
		public RuleCall getOperandsConditionExpressionParserRuleCall_3_0() { return cOperandsConditionExpressionParserRuleCall_3_0; }
		
		//(',' operands+=ConditionExpression)*
		public Group getGroup_4() { return cGroup_4; }
		
		//','
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }
		
		//operands+=ConditionExpression
		public Assignment getOperandsAssignment_4_1() { return cOperandsAssignment_4_1; }
		
		//ConditionExpression
		public RuleCall getOperandsConditionExpressionParserRuleCall_4_1_0() { return cOperandsConditionExpressionParserRuleCall_4_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}
	public class OrlessExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.OrlessExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cCountAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cCountINTVALUEParserRuleCall_0_0 = (RuleCall)cCountAssignment_0.eContents().get(0);
		private final Keyword cOrlessKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOperandsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOperandsConditionExpressionParserRuleCall_3_0 = (RuleCall)cOperandsAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOperandsAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOperandsConditionExpressionParserRuleCall_4_1_0 = (RuleCall)cOperandsAssignment_4_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//OrlessExpression:
		//	count=INTVALUE 'orless' '(' operands+=ConditionExpression (',' operands+=ConditionExpression)* ')';
		@Override public ParserRule getRule() { return rule; }
		
		//count=INTVALUE 'orless' '(' operands+=ConditionExpression (',' operands+=ConditionExpression)* ')'
		public Group getGroup() { return cGroup; }
		
		//count=INTVALUE
		public Assignment getCountAssignment_0() { return cCountAssignment_0; }
		
		//INTVALUE
		public RuleCall getCountINTVALUEParserRuleCall_0_0() { return cCountINTVALUEParserRuleCall_0_0; }
		
		//'orless'
		public Keyword getOrlessKeyword_1() { return cOrlessKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//operands+=ConditionExpression
		public Assignment getOperandsAssignment_3() { return cOperandsAssignment_3; }
		
		//ConditionExpression
		public RuleCall getOperandsConditionExpressionParserRuleCall_3_0() { return cOperandsConditionExpressionParserRuleCall_3_0; }
		
		//(',' operands+=ConditionExpression)*
		public Group getGroup_4() { return cGroup_4; }
		
		//','
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }
		
		//operands+=ConditionExpression
		public Assignment getOperandsAssignment_4_1() { return cOperandsAssignment_4_1; }
		
		//ConditionExpression
		public RuleCall getOperandsConditionExpressionParserRuleCall_4_1_0() { return cOperandsConditionExpressionParserRuleCall_4_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}
	public class ConditionTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ConditionTerm");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cConditionElementParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cOrmoreExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cOrlessExpressionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cAllExpressionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final Group cGroup_4 = (Group)cAlternatives.eContents().get(4);
		private final Keyword cLeftParenthesisKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final RuleCall cConditionExpressionParserRuleCall_4_1 = (RuleCall)cGroup_4.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		
		//ConditionTerm ConditionExpression:
		//	ConditionElement
		//	| OrmoreExpression
		//	| OrlessExpression
		//	| AllExpression
		//	| '(' ConditionExpression ')';
		@Override public ParserRule getRule() { return rule; }
		
		//ConditionElement | OrmoreExpression | OrlessExpression | AllExpression | '(' ConditionExpression ')'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ConditionElement
		public RuleCall getConditionElementParserRuleCall_0() { return cConditionElementParserRuleCall_0; }
		
		//OrmoreExpression
		public RuleCall getOrmoreExpressionParserRuleCall_1() { return cOrmoreExpressionParserRuleCall_1; }
		
		//OrlessExpression
		public RuleCall getOrlessExpressionParserRuleCall_2() { return cOrlessExpressionParserRuleCall_2; }
		
		//AllExpression
		public RuleCall getAllExpressionParserRuleCall_3() { return cAllExpressionParserRuleCall_3; }
		
		//'(' ConditionExpression ')'
		public Group getGroup_4() { return cGroup_4; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_4_0() { return cLeftParenthesisKeyword_4_0; }
		
		//ConditionExpression
		public RuleCall getConditionExpressionParserRuleCall_4_1() { return cConditionExpressionParserRuleCall_4_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4_2() { return cRightParenthesisKeyword_4_2; }
	}
	public class ConditionElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ConditionElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cQualifiedErrorPropagationReferenceAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cQualifiedErrorPropagationReferenceQualifiedErrorEventOrPropagationParserRuleCall_0_0 = (RuleCall)cQualifiedErrorPropagationReferenceAssignment_0.eContents().get(0);
		private final Assignment cConstraintAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cConstraintTypeTokenConstraintNoErrorParserRuleCall_1_0 = (RuleCall)cConstraintAssignment_1.eContents().get(0);
		
		//ConditionElement:
		//	qualifiedErrorPropagationReference=QualifiedErrorEventOrPropagation constraint=TypeTokenConstraintNoError?;
		@Override public ParserRule getRule() { return rule; }
		
		//qualifiedErrorPropagationReference=QualifiedErrorEventOrPropagation constraint=TypeTokenConstraintNoError?
		public Group getGroup() { return cGroup; }
		
		//qualifiedErrorPropagationReference=QualifiedErrorEventOrPropagation
		public Assignment getQualifiedErrorPropagationReferenceAssignment_0() { return cQualifiedErrorPropagationReferenceAssignment_0; }
		
		//QualifiedErrorEventOrPropagation
		public RuleCall getQualifiedErrorPropagationReferenceQualifiedErrorEventOrPropagationParserRuleCall_0_0() { return cQualifiedErrorPropagationReferenceQualifiedErrorEventOrPropagationParserRuleCall_0_0; }
		
		//constraint=TypeTokenConstraintNoError?
		public Assignment getConstraintAssignment_1() { return cConstraintAssignment_1; }
		
		//TypeTokenConstraintNoError
		public RuleCall getConstraintTypeTokenConstraintNoErrorParserRuleCall_1_0() { return cConstraintTypeTokenConstraintNoErrorParserRuleCall_1_0; }
	}
	public class QualifiedErrorEventOrPropagationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.QualifiedErrorEventOrPropagation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cQualifiedErrorEventOrPropagationAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cEmv2TargetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0 = (RuleCall)cEmv2TargetAssignment_1.eContents().get(0);
		
		////QualifiedErrorPropagation returns QualifiedErrorPropagation:
		////	(modelElementReference=NestedModelElement '.')?    (  kind=PropagationKind | errorPropagation=[ErrorPropagation|ID])
		////;
		////
		////NestedModelElement returns NestedModelElement:
		////	modelElement=[aadl2::NamedElement|ID] ( next=NestedModelElement)?
		////;
		//QualifiedErrorEventOrPropagation EMV2Path:
		//	{QualifiedErrorEventOrPropagation} emv2Target=EMV2ErrorPropagationPath;
		@Override public ParserRule getRule() { return rule; }
		
		//{QualifiedErrorEventOrPropagation} emv2Target=EMV2ErrorPropagationPath
		public Group getGroup() { return cGroup; }
		
		//{QualifiedErrorEventOrPropagation}
		public Action getQualifiedErrorEventOrPropagationAction_0() { return cQualifiedErrorEventOrPropagationAction_0; }
		
		//emv2Target=EMV2ErrorPropagationPath
		public Assignment getEmv2TargetAssignment_1() { return cEmv2TargetAssignment_1; }
		
		//EMV2ErrorPropagationPath
		public RuleCall getEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0() { return cEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0; }
	}
	public class EMV2ErrorPropagationPathElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2ErrorPropagationPath");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cEmv2PropagationKindAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cEmv2PropagationKindPropagationKindParserRuleCall_0_0 = (RuleCall)cEmv2PropagationKindAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Assignment cNamedElementAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final CrossReference cNamedElementNamedElementCrossReference_1_0_0 = (CrossReference)cNamedElementAssignment_1_0.eContents().get(0);
		private final RuleCall cNamedElementNamedElementIDTerminalRuleCall_1_0_0_1 = (RuleCall)cNamedElementNamedElementCrossReference_1_0_0.eContents().get(1);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cFullStopKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cPathAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cPathEMV2ErrorPropagationPathParserRuleCall_1_1_1_0 = (RuleCall)cPathAssignment_1_1_1.eContents().get(0);
		
		//EMV2ErrorPropagationPath EMV2PathElement:
		//	emv2PropagationKind=PropagationKind
		//	| namedElement=[aadl2::NamedElement] ('.' path=EMV2ErrorPropagationPath)?;
		@Override public ParserRule getRule() { return rule; }
		
		//emv2PropagationKind=PropagationKind | namedElement=[aadl2::NamedElement] ('.' path=EMV2ErrorPropagationPath)?
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//emv2PropagationKind=PropagationKind
		public Assignment getEmv2PropagationKindAssignment_0() { return cEmv2PropagationKindAssignment_0; }
		
		//PropagationKind
		public RuleCall getEmv2PropagationKindPropagationKindParserRuleCall_0_0() { return cEmv2PropagationKindPropagationKindParserRuleCall_0_0; }
		
		//namedElement=[aadl2::NamedElement] ('.' path=EMV2ErrorPropagationPath)?
		public Group getGroup_1() { return cGroup_1; }
		
		//namedElement=[aadl2::NamedElement]
		public Assignment getNamedElementAssignment_1_0() { return cNamedElementAssignment_1_0; }
		
		//[aadl2::NamedElement]
		public CrossReference getNamedElementNamedElementCrossReference_1_0_0() { return cNamedElementNamedElementCrossReference_1_0_0; }
		
		//ID
		public RuleCall getNamedElementNamedElementIDTerminalRuleCall_1_0_0_1() { return cNamedElementNamedElementIDTerminalRuleCall_1_0_0_1; }
		
		//('.' path=EMV2ErrorPropagationPath)?
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_1_0() { return cFullStopKeyword_1_1_0; }
		
		//path=EMV2ErrorPropagationPath
		public Assignment getPathAssignment_1_1_1() { return cPathAssignment_1_1_1; }
		
		//EMV2ErrorPropagationPath
		public RuleCall getPathEMV2ErrorPropagationPathParserRuleCall_1_1_1_0() { return cPathEMV2ErrorPropagationPathParserRuleCall_1_1_1_0; }
	}
	public class EventOrPropagationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.EventOrPropagation");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cErrorBehaviorEventParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cErrorPropagationParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//EventOrPropagation:
		//	ErrorBehaviorEvent | ErrorPropagation;
		@Override public ParserRule getRule() { return rule; }
		
		//ErrorBehaviorEvent | ErrorPropagation
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ErrorBehaviorEvent
		public RuleCall getErrorBehaviorEventParserRuleCall_0() { return cErrorBehaviorEventParserRuleCall_0; }
		
		//ErrorPropagation
		public RuleCall getErrorPropagationParserRuleCall_1() { return cErrorPropagationParserRuleCall_1; }
	}
	public class OutgoingPropagationConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.OutgoingPropagationCondition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0_0 = (RuleCall)cNameAssignment_0_0.eContents().get(0);
		private final Keyword cColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Assignment cStateAssignment_1_0_0 = (Assignment)cGroup_1_0.eContents().get(0);
		private final CrossReference cStateErrorBehaviorStateCrossReference_1_0_0_0 = (CrossReference)cStateAssignment_1_0_0.eContents().get(0);
		private final RuleCall cStateErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1 = (RuleCall)cStateErrorBehaviorStateCrossReference_1_0_0_0.eContents().get(1);
		private final Assignment cTypeTokenConstraintAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final RuleCall cTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0 = (RuleCall)cTypeTokenConstraintAssignment_1_0_1.eContents().get(0);
		private final Assignment cAllStatesAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final Keyword cAllStatesAllKeyword_1_1_0 = (Keyword)cAllStatesAssignment_1_1.eContents().get(0);
		private final Keyword cHyphenMinusLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cConditionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cConditionConditionExpressionParserRuleCall_3_0 = (RuleCall)cConditionAssignment_3.eContents().get(0);
		private final Keyword cRightSquareBracketHyphenMinusGreaterThanSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Alternatives cAlternatives_5_0 = (Alternatives)cGroup_5.eContents().get(0);
		private final Assignment cOutgoingAssignment_5_0_0 = (Assignment)cAlternatives_5_0.eContents().get(0);
		private final CrossReference cOutgoingErrorPropagationCrossReference_5_0_0_0 = (CrossReference)cOutgoingAssignment_5_0_0.eContents().get(0);
		private final RuleCall cOutgoingErrorPropagationErrorPropagationPointParserRuleCall_5_0_0_0_1 = (RuleCall)cOutgoingErrorPropagationCrossReference_5_0_0_0.eContents().get(1);
		private final Assignment cAllPropagationsAssignment_5_0_1 = (Assignment)cAlternatives_5_0.eContents().get(1);
		private final Keyword cAllPropagationsAllKeyword_5_0_1_0 = (Keyword)cAllPropagationsAssignment_5_0_1.eContents().get(0);
		private final Assignment cTypeTokenAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cTypeTokenTypeTokenOrNoErrorParserRuleCall_5_1_0 = (RuleCall)cTypeTokenAssignment_5_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//OutgoingPropagationCondition:
		//	(name=ID ':')? (state=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint? | allStates?='all')
		//	'-[' condition=ConditionExpression? ']->' ((outgoing=[ErrorPropagation|ErrorPropagationPoint] |
		//	allPropagations?='all') typeToken=TypeTokenOrNoError?)
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//(name=ID ':')? (state=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint? | allStates?='all') '-['
		//condition=ConditionExpression? ']->' ((outgoing=[ErrorPropagation|ErrorPropagationPoint] | allPropagations?='all')
		//typeToken=TypeTokenOrNoError?) ';'
		public Group getGroup() { return cGroup; }
		
		//(name=ID ':')?
		public Group getGroup_0() { return cGroup_0; }
		
		//name=ID
		public Assignment getNameAssignment_0_0() { return cNameAssignment_0_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0_0() { return cNameIDTerminalRuleCall_0_0_0; }
		
		//':'
		public Keyword getColonKeyword_0_1() { return cColonKeyword_0_1; }
		
		//(state=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint? | allStates?='all')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//state=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint?
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//state=[ErrorBehaviorState]
		public Assignment getStateAssignment_1_0_0() { return cStateAssignment_1_0_0; }
		
		//[ErrorBehaviorState]
		public CrossReference getStateErrorBehaviorStateCrossReference_1_0_0_0() { return cStateErrorBehaviorStateCrossReference_1_0_0_0; }
		
		//ID
		public RuleCall getStateErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1() { return cStateErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1; }
		
		//typeTokenConstraint=TypeTokenConstraint?
		public Assignment getTypeTokenConstraintAssignment_1_0_1() { return cTypeTokenConstraintAssignment_1_0_1; }
		
		//TypeTokenConstraint
		public RuleCall getTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0() { return cTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0; }
		
		//allStates?='all'
		public Assignment getAllStatesAssignment_1_1() { return cAllStatesAssignment_1_1; }
		
		//'all'
		public Keyword getAllStatesAllKeyword_1_1_0() { return cAllStatesAllKeyword_1_1_0; }
		
		//'-['
		public Keyword getHyphenMinusLeftSquareBracketKeyword_2() { return cHyphenMinusLeftSquareBracketKeyword_2; }
		
		//condition=ConditionExpression?
		public Assignment getConditionAssignment_3() { return cConditionAssignment_3; }
		
		//ConditionExpression
		public RuleCall getConditionConditionExpressionParserRuleCall_3_0() { return cConditionConditionExpressionParserRuleCall_3_0; }
		
		//']->'
		public Keyword getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4() { return cRightSquareBracketHyphenMinusGreaterThanSignKeyword_4; }
		
		//((outgoing=[ErrorPropagation|ErrorPropagationPoint] | allPropagations?='all') typeToken=TypeTokenOrNoError?)
		public Group getGroup_5() { return cGroup_5; }
		
		//(outgoing=[ErrorPropagation|ErrorPropagationPoint] | allPropagations?='all')
		public Alternatives getAlternatives_5_0() { return cAlternatives_5_0; }
		
		//outgoing=[ErrorPropagation|ErrorPropagationPoint]
		public Assignment getOutgoingAssignment_5_0_0() { return cOutgoingAssignment_5_0_0; }
		
		//[ErrorPropagation|ErrorPropagationPoint]
		public CrossReference getOutgoingErrorPropagationCrossReference_5_0_0_0() { return cOutgoingErrorPropagationCrossReference_5_0_0_0; }
		
		//ErrorPropagationPoint
		public RuleCall getOutgoingErrorPropagationErrorPropagationPointParserRuleCall_5_0_0_0_1() { return cOutgoingErrorPropagationErrorPropagationPointParserRuleCall_5_0_0_0_1; }
		
		//allPropagations?='all'
		public Assignment getAllPropagationsAssignment_5_0_1() { return cAllPropagationsAssignment_5_0_1; }
		
		//'all'
		public Keyword getAllPropagationsAllKeyword_5_0_1_0() { return cAllPropagationsAllKeyword_5_0_1_0; }
		
		//typeToken=TypeTokenOrNoError?
		public Assignment getTypeTokenAssignment_5_1() { return cTypeTokenAssignment_5_1; }
		
		//TypeTokenOrNoError
		public RuleCall getTypeTokenTypeTokenOrNoErrorParserRuleCall_5_1_0() { return cTypeTokenTypeTokenOrNoErrorParserRuleCall_5_1_0; }
		
		//';'
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
	}
	public class ErrorDetectionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorDetection");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0_0 = (RuleCall)cNameAssignment_0_0.eContents().get(0);
		private final Keyword cColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Assignment cStateAssignment_1_0_0 = (Assignment)cGroup_1_0.eContents().get(0);
		private final CrossReference cStateErrorBehaviorStateCrossReference_1_0_0_0 = (CrossReference)cStateAssignment_1_0_0.eContents().get(0);
		private final RuleCall cStateErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1 = (RuleCall)cStateErrorBehaviorStateCrossReference_1_0_0_0.eContents().get(1);
		private final Assignment cTypeTokenConstraintAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final RuleCall cTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0 = (RuleCall)cTypeTokenConstraintAssignment_1_0_1.eContents().get(0);
		private final Assignment cAllStatesAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final Keyword cAllStatesAllKeyword_1_1_0 = (Keyword)cAllStatesAssignment_1_1.eContents().get(0);
		private final Keyword cHyphenMinusLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cConditionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cConditionConditionExpressionParserRuleCall_3_0 = (RuleCall)cConditionAssignment_3.eContents().get(0);
		private final Keyword cRightSquareBracketHyphenMinusGreaterThanSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cDetectionReportingPortAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cDetectionReportingPortReportingPortReferenceParserRuleCall_5_0 = (RuleCall)cDetectionReportingPortAssignment_5.eContents().get(0);
		private final Keyword cExclamationMarkKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cLeftParenthesisKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cErrorCodeAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cErrorCodeErrorCodeValueParserRuleCall_7_1_0 = (RuleCall)cErrorCodeAssignment_7_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_7_2 = (Keyword)cGroup_7.eContents().get(2);
		private final Keyword cSemicolonKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//ErrorDetection:
		//	(name=ID ':')? (state=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint? | allStates?='all')
		//	'-[' condition=ConditionExpression? ']->'
		//	detectionReportingPort=ReportingPortReference '!' ('(' errorCode=ErrorCodeValue ')')?
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//(name=ID ':')? (state=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint? | allStates?='all') '-['
		//condition=ConditionExpression? ']->' detectionReportingPort=ReportingPortReference '!' ('(' errorCode=ErrorCodeValue
		//')')? ';'
		public Group getGroup() { return cGroup; }
		
		//(name=ID ':')?
		public Group getGroup_0() { return cGroup_0; }
		
		//name=ID
		public Assignment getNameAssignment_0_0() { return cNameAssignment_0_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0_0() { return cNameIDTerminalRuleCall_0_0_0; }
		
		//':'
		public Keyword getColonKeyword_0_1() { return cColonKeyword_0_1; }
		
		//(state=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint? | allStates?='all')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//state=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint?
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//state=[ErrorBehaviorState]
		public Assignment getStateAssignment_1_0_0() { return cStateAssignment_1_0_0; }
		
		//[ErrorBehaviorState]
		public CrossReference getStateErrorBehaviorStateCrossReference_1_0_0_0() { return cStateErrorBehaviorStateCrossReference_1_0_0_0; }
		
		//ID
		public RuleCall getStateErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1() { return cStateErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1; }
		
		//typeTokenConstraint=TypeTokenConstraint?
		public Assignment getTypeTokenConstraintAssignment_1_0_1() { return cTypeTokenConstraintAssignment_1_0_1; }
		
		//TypeTokenConstraint
		public RuleCall getTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0() { return cTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0; }
		
		//allStates?='all'
		public Assignment getAllStatesAssignment_1_1() { return cAllStatesAssignment_1_1; }
		
		//'all'
		public Keyword getAllStatesAllKeyword_1_1_0() { return cAllStatesAllKeyword_1_1_0; }
		
		//'-['
		public Keyword getHyphenMinusLeftSquareBracketKeyword_2() { return cHyphenMinusLeftSquareBracketKeyword_2; }
		
		//condition=ConditionExpression?
		public Assignment getConditionAssignment_3() { return cConditionAssignment_3; }
		
		//ConditionExpression
		public RuleCall getConditionConditionExpressionParserRuleCall_3_0() { return cConditionConditionExpressionParserRuleCall_3_0; }
		
		//']->'
		public Keyword getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4() { return cRightSquareBracketHyphenMinusGreaterThanSignKeyword_4; }
		
		//detectionReportingPort=ReportingPortReference
		public Assignment getDetectionReportingPortAssignment_5() { return cDetectionReportingPortAssignment_5; }
		
		//ReportingPortReference
		public RuleCall getDetectionReportingPortReportingPortReferenceParserRuleCall_5_0() { return cDetectionReportingPortReportingPortReferenceParserRuleCall_5_0; }
		
		//'!'
		public Keyword getExclamationMarkKeyword_6() { return cExclamationMarkKeyword_6; }
		
		//('(' errorCode=ErrorCodeValue ')')?
		public Group getGroup_7() { return cGroup_7; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_7_0() { return cLeftParenthesisKeyword_7_0; }
		
		//errorCode=ErrorCodeValue
		public Assignment getErrorCodeAssignment_7_1() { return cErrorCodeAssignment_7_1; }
		
		//ErrorCodeValue
		public RuleCall getErrorCodeErrorCodeValueParserRuleCall_7_1_0() { return cErrorCodeErrorCodeValueParserRuleCall_7_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_7_2() { return cRightParenthesisKeyword_7_2; }
		
		//';'
		public Keyword getSemicolonKeyword_8() { return cSemicolonKeyword_8; }
	}
	public class ReportingPortReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ReportingPortReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cElementAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cElementNamedElementCrossReference_0_0 = (CrossReference)cElementAssignment_0.eContents().get(0);
		private final RuleCall cElementNamedElementIDTerminalRuleCall_0_0_1 = (RuleCall)cElementNamedElementCrossReference_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cReportingPortReferencePreviousAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cFullStopKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cElementAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final CrossReference cElementNamedElementCrossReference_1_2_0 = (CrossReference)cElementAssignment_1_2.eContents().get(0);
		private final RuleCall cElementNamedElementIDTerminalRuleCall_1_2_0_1 = (RuleCall)cElementNamedElementCrossReference_1_2_0.eContents().get(1);
		
		//ReportingPortReference:
		//	element=[aadl2::NamedElement] ({ReportingPortReference.previous=current} '.' element=[aadl2::NamedElement])*;
		@Override public ParserRule getRule() { return rule; }
		
		//element=[aadl2::NamedElement] ({ReportingPortReference.previous=current} '.' element=[aadl2::NamedElement])*
		public Group getGroup() { return cGroup; }
		
		//element=[aadl2::NamedElement]
		public Assignment getElementAssignment_0() { return cElementAssignment_0; }
		
		//[aadl2::NamedElement]
		public CrossReference getElementNamedElementCrossReference_0_0() { return cElementNamedElementCrossReference_0_0; }
		
		//ID
		public RuleCall getElementNamedElementIDTerminalRuleCall_0_0_1() { return cElementNamedElementIDTerminalRuleCall_0_0_1; }
		
		//({ReportingPortReference.previous=current} '.' element=[aadl2::NamedElement])*
		public Group getGroup_1() { return cGroup_1; }
		
		//{ReportingPortReference.previous=current}
		public Action getReportingPortReferencePreviousAction_1_0() { return cReportingPortReferencePreviousAction_1_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1_1() { return cFullStopKeyword_1_1; }
		
		//element=[aadl2::NamedElement]
		public Assignment getElementAssignment_1_2() { return cElementAssignment_1_2; }
		
		//[aadl2::NamedElement]
		public CrossReference getElementNamedElementCrossReference_1_2_0() { return cElementNamedElementCrossReference_1_2_0; }
		
		//ID
		public RuleCall getElementNamedElementIDTerminalRuleCall_1_2_0_1() { return cElementNamedElementIDTerminalRuleCall_1_2_0_1; }
	}
	public class ErrorCodeValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorCodeValue");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cIntValueAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cIntValueINTEGER_LITTerminalRuleCall_0_0 = (RuleCall)cIntValueAssignment_0.eContents().get(0);
		private final Assignment cConstantAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final CrossReference cConstantPropertyConstantCrossReference_1_0 = (CrossReference)cConstantAssignment_1.eContents().get(0);
		private final RuleCall cConstantPropertyConstantQPREFParserRuleCall_1_0_1 = (RuleCall)cConstantPropertyConstantCrossReference_1_0.eContents().get(1);
		private final Assignment cEnumLiteralAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final RuleCall cEnumLiteralSTRINGTerminalRuleCall_2_0 = (RuleCall)cEnumLiteralAssignment_2.eContents().get(0);
		
		//ErrorCodeValue:
		//	intValue=INTEGER_LIT | constant=[aadl2::PropertyConstant|QPREF] | enumLiteral=STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//intValue=INTEGER_LIT | constant=[aadl2::PropertyConstant|QPREF] | enumLiteral=STRING
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//intValue=INTEGER_LIT
		public Assignment getIntValueAssignment_0() { return cIntValueAssignment_0; }
		
		//INTEGER_LIT
		public RuleCall getIntValueINTEGER_LITTerminalRuleCall_0_0() { return cIntValueINTEGER_LITTerminalRuleCall_0_0; }
		
		//constant=[aadl2::PropertyConstant|QPREF]
		public Assignment getConstantAssignment_1() { return cConstantAssignment_1; }
		
		//[aadl2::PropertyConstant|QPREF]
		public CrossReference getConstantPropertyConstantCrossReference_1_0() { return cConstantPropertyConstantCrossReference_1_0; }
		
		//QPREF
		public RuleCall getConstantPropertyConstantQPREFParserRuleCall_1_0_1() { return cConstantPropertyConstantQPREFParserRuleCall_1_0_1; }
		
		//enumLiteral=STRING
		public Assignment getEnumLiteralAssignment_2() { return cEnumLiteralAssignment_2; }
		
		//STRING
		public RuleCall getEnumLiteralSTRINGTerminalRuleCall_2_0() { return cEnumLiteralSTRINGTerminalRuleCall_2_0; }
	}
	public class ErrorStateToModeMappingElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorStateToModeMapping");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cErrorStateAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cErrorStateErrorBehaviorStateCrossReference_0_0 = (CrossReference)cErrorStateAssignment_0.eContents().get(0);
		private final RuleCall cErrorStateErrorBehaviorStateIDTerminalRuleCall_0_0_1 = (RuleCall)cErrorStateErrorBehaviorStateCrossReference_0_0.eContents().get(1);
		private final Assignment cTypeTokenAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTypeTokenTypeTokenParserRuleCall_1_0 = (RuleCall)cTypeTokenAssignment_1.eContents().get(0);
		private final Keyword cInKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cModesKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cMappedModesAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cMappedModesModeCrossReference_5_0 = (CrossReference)cMappedModesAssignment_5.eContents().get(0);
		private final RuleCall cMappedModesModeIDTerminalRuleCall_5_0_1 = (RuleCall)cMappedModesModeCrossReference_5_0.eContents().get(1);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cCommaKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cMappedModesAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final CrossReference cMappedModesModeCrossReference_6_1_0 = (CrossReference)cMappedModesAssignment_6_1.eContents().get(0);
		private final RuleCall cMappedModesModeIDTerminalRuleCall_6_1_0_1 = (RuleCall)cMappedModesModeCrossReference_6_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Keyword cSemicolonKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//ErrorStateToModeMapping:
		//	errorState=[ErrorBehaviorState] typeToken=TypeToken?
		//	'in' 'modes' '('
		//	mappedModes+=[aadl2::Mode] (',' mappedModes+=[aadl2::Mode])* ')' ';';
		@Override public ParserRule getRule() { return rule; }
		
		//errorState=[ErrorBehaviorState] typeToken=TypeToken? 'in' 'modes' '(' mappedModes+=[aadl2::Mode] (','
		//mappedModes+=[aadl2::Mode])* ')' ';'
		public Group getGroup() { return cGroup; }
		
		//errorState=[ErrorBehaviorState]
		public Assignment getErrorStateAssignment_0() { return cErrorStateAssignment_0; }
		
		//[ErrorBehaviorState]
		public CrossReference getErrorStateErrorBehaviorStateCrossReference_0_0() { return cErrorStateErrorBehaviorStateCrossReference_0_0; }
		
		//ID
		public RuleCall getErrorStateErrorBehaviorStateIDTerminalRuleCall_0_0_1() { return cErrorStateErrorBehaviorStateIDTerminalRuleCall_0_0_1; }
		
		//typeToken=TypeToken?
		public Assignment getTypeTokenAssignment_1() { return cTypeTokenAssignment_1; }
		
		//TypeToken
		public RuleCall getTypeTokenTypeTokenParserRuleCall_1_0() { return cTypeTokenTypeTokenParserRuleCall_1_0; }
		
		//'in'
		public Keyword getInKeyword_2() { return cInKeyword_2; }
		
		//'modes'
		public Keyword getModesKeyword_3() { return cModesKeyword_3; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_4() { return cLeftParenthesisKeyword_4; }
		
		//mappedModes+=[aadl2::Mode]
		public Assignment getMappedModesAssignment_5() { return cMappedModesAssignment_5; }
		
		//[aadl2::Mode]
		public CrossReference getMappedModesModeCrossReference_5_0() { return cMappedModesModeCrossReference_5_0; }
		
		//ID
		public RuleCall getMappedModesModeIDTerminalRuleCall_5_0_1() { return cMappedModesModeIDTerminalRuleCall_5_0_1; }
		
		//(',' mappedModes+=[aadl2::Mode])*
		public Group getGroup_6() { return cGroup_6; }
		
		//','
		public Keyword getCommaKeyword_6_0() { return cCommaKeyword_6_0; }
		
		//mappedModes+=[aadl2::Mode]
		public Assignment getMappedModesAssignment_6_1() { return cMappedModesAssignment_6_1; }
		
		//[aadl2::Mode]
		public CrossReference getMappedModesModeCrossReference_6_1_0() { return cMappedModesModeCrossReference_6_1_0; }
		
		//ID
		public RuleCall getMappedModesModeIDTerminalRuleCall_6_1_0_1() { return cMappedModesModeIDTerminalRuleCall_6_1_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_7() { return cRightParenthesisKeyword_7; }
		
		//';'
		public Keyword getSemicolonKeyword_8() { return cSemicolonKeyword_8; }
	}
	public class CompositeStateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.CompositeState");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0_0 = (RuleCall)cNameAssignment_0_0.eContents().get(0);
		private final Keyword cColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cConditionAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final RuleCall cConditionSConditionExpressionParserRuleCall_2_0_0 = (RuleCall)cConditionAssignment_2_0.eContents().get(0);
		private final Assignment cOthersAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final Keyword cOthersOthersKeyword_2_1_0 = (Keyword)cOthersAssignment_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketHyphenMinusGreaterThanSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cStateAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cStateErrorBehaviorStateCrossReference_4_0 = (CrossReference)cStateAssignment_4.eContents().get(0);
		private final RuleCall cStateErrorBehaviorStateIDTerminalRuleCall_4_0_1 = (RuleCall)cStateErrorBehaviorStateCrossReference_4_0.eContents().get(1);
		private final Assignment cTypedTokenAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cTypedTokenTypeTokenParserRuleCall_5_0 = (RuleCall)cTypedTokenAssignment_5.eContents().get(0);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//CompositeState:
		//	(name=ID ':')?
		//	'[' (condition=SConditionExpression | others?='others') ']->' state=[ErrorBehaviorState] typedToken=TypeToken? ';';
		@Override public ParserRule getRule() { return rule; }
		
		//(name=ID ':')? '[' (condition=SConditionExpression | others?='others') ']->' state=[ErrorBehaviorState]
		//typedToken=TypeToken? ';'
		public Group getGroup() { return cGroup; }
		
		//(name=ID ':')?
		public Group getGroup_0() { return cGroup_0; }
		
		//name=ID
		public Assignment getNameAssignment_0_0() { return cNameAssignment_0_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0_0() { return cNameIDTerminalRuleCall_0_0_0; }
		
		//':'
		public Keyword getColonKeyword_0_1() { return cColonKeyword_0_1; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_1() { return cLeftSquareBracketKeyword_1; }
		
		//(condition=SConditionExpression | others?='others')
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//condition=SConditionExpression
		public Assignment getConditionAssignment_2_0() { return cConditionAssignment_2_0; }
		
		//SConditionExpression
		public RuleCall getConditionSConditionExpressionParserRuleCall_2_0_0() { return cConditionSConditionExpressionParserRuleCall_2_0_0; }
		
		//others?='others'
		public Assignment getOthersAssignment_2_1() { return cOthersAssignment_2_1; }
		
		//'others'
		public Keyword getOthersOthersKeyword_2_1_0() { return cOthersOthersKeyword_2_1_0; }
		
		//']->'
		public Keyword getRightSquareBracketHyphenMinusGreaterThanSignKeyword_3() { return cRightSquareBracketHyphenMinusGreaterThanSignKeyword_3; }
		
		//state=[ErrorBehaviorState]
		public Assignment getStateAssignment_4() { return cStateAssignment_4; }
		
		//[ErrorBehaviorState]
		public CrossReference getStateErrorBehaviorStateCrossReference_4_0() { return cStateErrorBehaviorStateCrossReference_4_0; }
		
		//ID
		public RuleCall getStateErrorBehaviorStateIDTerminalRuleCall_4_0_1() { return cStateErrorBehaviorStateIDTerminalRuleCall_4_0_1; }
		
		//typedToken=TypeToken?
		public Assignment getTypedTokenAssignment_5() { return cTypedTokenAssignment_5; }
		
		//TypeToken
		public RuleCall getTypedTokenTypeTokenParserRuleCall_5_0() { return cTypedTokenTypeTokenParserRuleCall_5_0; }
		
		//';'
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
	}
	public class SConditionExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.SConditionExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cSAndExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cOrExpressionOperandsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cOrKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cOperandsAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cOperandsSAndExpressionParserRuleCall_1_2_0 = (RuleCall)cOperandsAssignment_1_2.eContents().get(0);
		
		//// condition expressions for composite states
		//// based on states only  
		//SConditionExpression ConditionExpression:
		//	SAndExpression ({OrExpression.operands+=current} 'or' operands+=SAndExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//SAndExpression ({OrExpression.operands+=current} 'or' operands+=SAndExpression)*
		public Group getGroup() { return cGroup; }
		
		//SAndExpression
		public RuleCall getSAndExpressionParserRuleCall_0() { return cSAndExpressionParserRuleCall_0; }
		
		//({OrExpression.operands+=current} 'or' operands+=SAndExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{OrExpression.operands+=current}
		public Action getOrExpressionOperandsAction_1_0() { return cOrExpressionOperandsAction_1_0; }
		
		//'or'
		public Keyword getOrKeyword_1_1() { return cOrKeyword_1_1; }
		
		//operands+=SAndExpression
		public Assignment getOperandsAssignment_1_2() { return cOperandsAssignment_1_2; }
		
		//SAndExpression
		public RuleCall getOperandsSAndExpressionParserRuleCall_1_2_0() { return cOperandsSAndExpressionParserRuleCall_1_2_0; }
	}
	public class SAndExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.SAndExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cSConditionTermParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cAndExpressionOperandsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cAndKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cOperandsAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cOperandsSConditionTermParserRuleCall_1_2_0 = (RuleCall)cOperandsAssignment_1_2.eContents().get(0);
		
		//SAndExpression ConditionExpression:
		//	SConditionTerm ({AndExpression.operands+=current} 'and' operands+=SConditionTerm)*;
		@Override public ParserRule getRule() { return rule; }
		
		//SConditionTerm ({AndExpression.operands+=current} 'and' operands+=SConditionTerm)*
		public Group getGroup() { return cGroup; }
		
		//SConditionTerm
		public RuleCall getSConditionTermParserRuleCall_0() { return cSConditionTermParserRuleCall_0; }
		
		//({AndExpression.operands+=current} 'and' operands+=SConditionTerm)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{AndExpression.operands+=current}
		public Action getAndExpressionOperandsAction_1_0() { return cAndExpressionOperandsAction_1_0; }
		
		//'and'
		public Keyword getAndKeyword_1_1() { return cAndKeyword_1_1; }
		
		//operands+=SConditionTerm
		public Assignment getOperandsAssignment_1_2() { return cOperandsAssignment_1_2; }
		
		//SConditionTerm
		public RuleCall getOperandsSConditionTermParserRuleCall_1_2_0() { return cOperandsSConditionTermParserRuleCall_1_2_0; }
	}
	public class SOrmoreExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.SOrmoreExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cCountAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cCountINTVALUEParserRuleCall_0_0 = (RuleCall)cCountAssignment_0.eContents().get(0);
		private final Keyword cOrmoreKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOperandsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOperandsSConditionExpressionParserRuleCall_3_0 = (RuleCall)cOperandsAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOperandsAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOperandsSConditionExpressionParserRuleCall_4_1_0 = (RuleCall)cOperandsAssignment_4_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//SOrmoreExpression OrmoreExpression:
		//	count=INTVALUE 'ormore' '(' operands+=SConditionExpression (',' operands+=SConditionExpression)* ')';
		@Override public ParserRule getRule() { return rule; }
		
		//count=INTVALUE 'ormore' '(' operands+=SConditionExpression (',' operands+=SConditionExpression)* ')'
		public Group getGroup() { return cGroup; }
		
		//count=INTVALUE
		public Assignment getCountAssignment_0() { return cCountAssignment_0; }
		
		//INTVALUE
		public RuleCall getCountINTVALUEParserRuleCall_0_0() { return cCountINTVALUEParserRuleCall_0_0; }
		
		//'ormore'
		public Keyword getOrmoreKeyword_1() { return cOrmoreKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//operands+=SConditionExpression
		public Assignment getOperandsAssignment_3() { return cOperandsAssignment_3; }
		
		//SConditionExpression
		public RuleCall getOperandsSConditionExpressionParserRuleCall_3_0() { return cOperandsSConditionExpressionParserRuleCall_3_0; }
		
		//(',' operands+=SConditionExpression)*
		public Group getGroup_4() { return cGroup_4; }
		
		//','
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }
		
		//operands+=SConditionExpression
		public Assignment getOperandsAssignment_4_1() { return cOperandsAssignment_4_1; }
		
		//SConditionExpression
		public RuleCall getOperandsSConditionExpressionParserRuleCall_4_1_0() { return cOperandsSConditionExpressionParserRuleCall_4_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}
	public class SOrlessExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.SOrlessExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cCountAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cCountINTVALUEParserRuleCall_0_0 = (RuleCall)cCountAssignment_0.eContents().get(0);
		private final Keyword cOrlessKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOperandsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOperandsSConditionExpressionParserRuleCall_3_0 = (RuleCall)cOperandsAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOperandsAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOperandsSConditionExpressionParserRuleCall_4_1_0 = (RuleCall)cOperandsAssignment_4_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//SOrlessExpression OrlessExpression:
		//	count=INTVALUE 'orless' '(' operands+=SConditionExpression (',' operands+=SConditionExpression)* ')';
		@Override public ParserRule getRule() { return rule; }
		
		//count=INTVALUE 'orless' '(' operands+=SConditionExpression (',' operands+=SConditionExpression)* ')'
		public Group getGroup() { return cGroup; }
		
		//count=INTVALUE
		public Assignment getCountAssignment_0() { return cCountAssignment_0; }
		
		//INTVALUE
		public RuleCall getCountINTVALUEParserRuleCall_0_0() { return cCountINTVALUEParserRuleCall_0_0; }
		
		//'orless'
		public Keyword getOrlessKeyword_1() { return cOrlessKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//operands+=SConditionExpression
		public Assignment getOperandsAssignment_3() { return cOperandsAssignment_3; }
		
		//SConditionExpression
		public RuleCall getOperandsSConditionExpressionParserRuleCall_3_0() { return cOperandsSConditionExpressionParserRuleCall_3_0; }
		
		//(',' operands+=SConditionExpression)*
		public Group getGroup_4() { return cGroup_4; }
		
		//','
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }
		
		//operands+=SConditionExpression
		public Assignment getOperandsAssignment_4_1() { return cOperandsAssignment_4_1; }
		
		//SConditionExpression
		public RuleCall getOperandsSConditionExpressionParserRuleCall_4_1_0() { return cOperandsSConditionExpressionParserRuleCall_4_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}
	public class SAllExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.SAllExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAllExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cAllKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cHyphenMinusKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cCountAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cCountINTVALUEParserRuleCall_2_1_0 = (RuleCall)cCountAssignment_2_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOperandsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOperandsSConditionElementParserRuleCall_4_0 = (RuleCall)cOperandsAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cCommaKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cOperandsAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cOperandsSConditionElementParserRuleCall_5_1_0 = (RuleCall)cOperandsAssignment_5_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//SAllExpression ConditionExpression:
		//	{AllExpression} 'all' ('-' count=INTVALUE)?
		//	'(' operands+=SConditionElement (',' operands+=SConditionElement)* ')';
		@Override public ParserRule getRule() { return rule; }
		
		//{AllExpression} 'all' ('-' count=INTVALUE)? '(' operands+=SConditionElement (',' operands+=SConditionElement)* ')'
		public Group getGroup() { return cGroup; }
		
		//{AllExpression}
		public Action getAllExpressionAction_0() { return cAllExpressionAction_0; }
		
		//'all'
		public Keyword getAllKeyword_1() { return cAllKeyword_1; }
		
		//('-' count=INTVALUE)?
		public Group getGroup_2() { return cGroup_2; }
		
		//'-'
		public Keyword getHyphenMinusKeyword_2_0() { return cHyphenMinusKeyword_2_0; }
		
		//count=INTVALUE
		public Assignment getCountAssignment_2_1() { return cCountAssignment_2_1; }
		
		//INTVALUE
		public RuleCall getCountINTVALUEParserRuleCall_2_1_0() { return cCountINTVALUEParserRuleCall_2_1_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }
		
		//operands+=SConditionElement
		public Assignment getOperandsAssignment_4() { return cOperandsAssignment_4; }
		
		//SConditionElement
		public RuleCall getOperandsSConditionElementParserRuleCall_4_0() { return cOperandsSConditionElementParserRuleCall_4_0; }
		
		//(',' operands+=SConditionElement)*
		public Group getGroup_5() { return cGroup_5; }
		
		//','
		public Keyword getCommaKeyword_5_0() { return cCommaKeyword_5_0; }
		
		//operands+=SConditionElement
		public Assignment getOperandsAssignment_5_1() { return cOperandsAssignment_5_1; }
		
		//SConditionElement
		public RuleCall getOperandsSConditionElementParserRuleCall_5_1_0() { return cOperandsSConditionElementParserRuleCall_5_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }
	}
	public class SConditionTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.SConditionTerm");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSConditionElementParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cSOrmoreExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cSOrlessExpressionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cSAllExpressionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final Group cGroup_4 = (Group)cAlternatives.eContents().get(4);
		private final Keyword cLeftParenthesisKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final RuleCall cSConditionExpressionParserRuleCall_4_1 = (RuleCall)cGroup_4.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		
		//SConditionTerm ConditionExpression:
		//	SConditionElement
		//	| SOrmoreExpression
		//	| SOrlessExpression
		//	| SAllExpression
		//	| '(' SConditionExpression ')';
		@Override public ParserRule getRule() { return rule; }
		
		//SConditionElement | SOrmoreExpression | SOrlessExpression | SAllExpression | '(' SConditionExpression ')'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//SConditionElement
		public RuleCall getSConditionElementParserRuleCall_0() { return cSConditionElementParserRuleCall_0; }
		
		//SOrmoreExpression
		public RuleCall getSOrmoreExpressionParserRuleCall_1() { return cSOrmoreExpressionParserRuleCall_1; }
		
		//SOrlessExpression
		public RuleCall getSOrlessExpressionParserRuleCall_2() { return cSOrlessExpressionParserRuleCall_2; }
		
		//SAllExpression
		public RuleCall getSAllExpressionParserRuleCall_3() { return cSAllExpressionParserRuleCall_3; }
		
		//'(' SConditionExpression ')'
		public Group getGroup_4() { return cGroup_4; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_4_0() { return cLeftParenthesisKeyword_4_0; }
		
		//SConditionExpression
		public RuleCall getSConditionExpressionParserRuleCall_4_1() { return cSConditionExpressionParserRuleCall_4_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4_2() { return cRightParenthesisKeyword_4_2; }
	}
	public class QualifiedErrorPropagationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.QualifiedErrorPropagation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cQualifiedErrorPropagationAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cEmv2TargetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0 = (RuleCall)cEmv2TargetAssignment_1.eContents().get(0);
		
		//QualifiedErrorPropagation EMV2Path:
		//	{QualifiedErrorPropagation} emv2Target=EMV2ErrorPropagationPath;
		@Override public ParserRule getRule() { return rule; }
		
		//{QualifiedErrorPropagation} emv2Target=EMV2ErrorPropagationPath
		public Group getGroup() { return cGroup; }
		
		//{QualifiedErrorPropagation}
		public Action getQualifiedErrorPropagationAction_0() { return cQualifiedErrorPropagationAction_0; }
		
		//emv2Target=EMV2ErrorPropagationPath
		public Assignment getEmv2TargetAssignment_1() { return cEmv2TargetAssignment_1; }
		
		//EMV2ErrorPropagationPath
		public RuleCall getEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0() { return cEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0; }
	}
	public class SConditionElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.SConditionElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cSConditionElementAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Assignment cQualifiedStateAssignment_1_0_0 = (Assignment)cGroup_1_0.eContents().get(0);
		private final RuleCall cQualifiedStateQualifiedErrorBehaviorStateParserRuleCall_1_0_0_0 = (RuleCall)cQualifiedStateAssignment_1_0_0.eContents().get(0);
		private final Assignment cConstraintAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final RuleCall cConstraintTypeTokenConstraintParserRuleCall_1_0_1_0 = (RuleCall)cConstraintAssignment_1_0_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Keyword cInKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Group cGroup_1_1_1 = (Group)cGroup_1_1.eContents().get(1);
		private final Assignment cQualifiedErrorPropagationReferenceAssignment_1_1_1_0 = (Assignment)cGroup_1_1_1.eContents().get(0);
		private final RuleCall cQualifiedErrorPropagationReferenceQualifiedErrorPropagationParserRuleCall_1_1_1_0_0 = (RuleCall)cQualifiedErrorPropagationReferenceAssignment_1_1_1_0.eContents().get(0);
		private final Assignment cConstraintAssignment_1_1_1_1 = (Assignment)cGroup_1_1_1.eContents().get(1);
		private final RuleCall cConstraintTypeTokenConstraintNoErrorParserRuleCall_1_1_1_1_0 = (RuleCall)cConstraintAssignment_1_1_1_1.eContents().get(0);
		
		//SConditionElement ConditionElement:
		//	{SConditionElement} (qualifiedState=QualifiedErrorBehaviorState constraint=TypeTokenConstraint? |
		//	'in' (qualifiedErrorPropagationReference=QualifiedErrorPropagation constraint=TypeTokenConstraintNoError?));
		@Override public ParserRule getRule() { return rule; }
		
		//{SConditionElement} (qualifiedState=QualifiedErrorBehaviorState constraint=TypeTokenConstraint? | 'in'
		//(qualifiedErrorPropagationReference=QualifiedErrorPropagation constraint=TypeTokenConstraintNoError?))
		public Group getGroup() { return cGroup; }
		
		//{SConditionElement}
		public Action getSConditionElementAction_0() { return cSConditionElementAction_0; }
		
		//(qualifiedState=QualifiedErrorBehaviorState constraint=TypeTokenConstraint? | 'in'
		//(qualifiedErrorPropagationReference=QualifiedErrorPropagation constraint=TypeTokenConstraintNoError?))
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//qualifiedState=QualifiedErrorBehaviorState constraint=TypeTokenConstraint?
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//qualifiedState=QualifiedErrorBehaviorState
		public Assignment getQualifiedStateAssignment_1_0_0() { return cQualifiedStateAssignment_1_0_0; }
		
		//QualifiedErrorBehaviorState
		public RuleCall getQualifiedStateQualifiedErrorBehaviorStateParserRuleCall_1_0_0_0() { return cQualifiedStateQualifiedErrorBehaviorStateParserRuleCall_1_0_0_0; }
		
		//constraint=TypeTokenConstraint?
		public Assignment getConstraintAssignment_1_0_1() { return cConstraintAssignment_1_0_1; }
		
		//TypeTokenConstraint
		public RuleCall getConstraintTypeTokenConstraintParserRuleCall_1_0_1_0() { return cConstraintTypeTokenConstraintParserRuleCall_1_0_1_0; }
		
		//'in' (qualifiedErrorPropagationReference=QualifiedErrorPropagation constraint=TypeTokenConstraintNoError?)
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//'in'
		public Keyword getInKeyword_1_1_0() { return cInKeyword_1_1_0; }
		
		//(qualifiedErrorPropagationReference=QualifiedErrorPropagation constraint=TypeTokenConstraintNoError?)
		public Group getGroup_1_1_1() { return cGroup_1_1_1; }
		
		//qualifiedErrorPropagationReference=QualifiedErrorPropagation
		public Assignment getQualifiedErrorPropagationReferenceAssignment_1_1_1_0() { return cQualifiedErrorPropagationReferenceAssignment_1_1_1_0; }
		
		//QualifiedErrorPropagation
		public RuleCall getQualifiedErrorPropagationReferenceQualifiedErrorPropagationParserRuleCall_1_1_1_0_0() { return cQualifiedErrorPropagationReferenceQualifiedErrorPropagationParserRuleCall_1_1_1_0_0; }
		
		//constraint=TypeTokenConstraintNoError?
		public Assignment getConstraintAssignment_1_1_1_1() { return cConstraintAssignment_1_1_1_1; }
		
		//TypeTokenConstraintNoError
		public RuleCall getConstraintTypeTokenConstraintNoErrorParserRuleCall_1_1_1_1_0() { return cConstraintTypeTokenConstraintNoErrorParserRuleCall_1_1_1_1_0; }
	}
	public class QualifiedErrorBehaviorStateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.QualifiedErrorBehaviorState");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSubcomponentAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cSubcomponentSubcomponentElementParserRuleCall_0_0 = (RuleCall)cSubcomponentAssignment_0.eContents().get(0);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cNextAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final RuleCall cNextQualifiedErrorBehaviorStateParserRuleCall_2_0_0 = (RuleCall)cNextAssignment_2_0.eContents().get(0);
		private final Assignment cStateAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final CrossReference cStateErrorBehaviorStateCrossReference_2_1_0 = (CrossReference)cStateAssignment_2_1.eContents().get(0);
		private final RuleCall cStateErrorBehaviorStateIDTerminalRuleCall_2_1_0_1 = (RuleCall)cStateErrorBehaviorStateCrossReference_2_1_0.eContents().get(1);
		
		//QualifiedErrorBehaviorState:
		//	subcomponent=SubcomponentElement '.' (next=QualifiedErrorBehaviorState | state=[ErrorBehaviorState]);
		@Override public ParserRule getRule() { return rule; }
		
		//subcomponent=SubcomponentElement '.' (next=QualifiedErrorBehaviorState | state=[ErrorBehaviorState])
		public Group getGroup() { return cGroup; }
		
		//subcomponent=SubcomponentElement
		public Assignment getSubcomponentAssignment_0() { return cSubcomponentAssignment_0; }
		
		//SubcomponentElement
		public RuleCall getSubcomponentSubcomponentElementParserRuleCall_0_0() { return cSubcomponentSubcomponentElementParserRuleCall_0_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }
		
		//(next=QualifiedErrorBehaviorState | state=[ErrorBehaviorState])
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//next=QualifiedErrorBehaviorState
		public Assignment getNextAssignment_2_0() { return cNextAssignment_2_0; }
		
		//QualifiedErrorBehaviorState
		public RuleCall getNextQualifiedErrorBehaviorStateParserRuleCall_2_0_0() { return cNextQualifiedErrorBehaviorStateParserRuleCall_2_0_0; }
		
		//state=[ErrorBehaviorState]
		public Assignment getStateAssignment_2_1() { return cStateAssignment_2_1; }
		
		//[ErrorBehaviorState]
		public CrossReference getStateErrorBehaviorStateCrossReference_2_1_0() { return cStateErrorBehaviorStateCrossReference_2_1_0; }
		
		//ID
		public RuleCall getStateErrorBehaviorStateIDTerminalRuleCall_2_1_0_1() { return cStateErrorBehaviorStateIDTerminalRuleCall_2_1_0_1; }
	}
	public class SubcomponentElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.SubcomponentElement");
		private final Assignment cSubcomponentAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cSubcomponentSubcomponentCrossReference_0 = (CrossReference)cSubcomponentAssignment.eContents().get(0);
		private final RuleCall cSubcomponentSubcomponentIDTerminalRuleCall_0_1 = (RuleCall)cSubcomponentSubcomponentCrossReference_0.eContents().get(1);
		
		//SubcomponentElement:
		//	subcomponent=[aadl2::Subcomponent];
		@Override public ParserRule getRule() { return rule; }
		
		//subcomponent=[aadl2::Subcomponent]
		public Assignment getSubcomponentAssignment() { return cSubcomponentAssignment; }
		
		//[aadl2::Subcomponent]
		public CrossReference getSubcomponentSubcomponentCrossReference_0() { return cSubcomponentSubcomponentCrossReference_0; }
		
		//ID
		public RuleCall getSubcomponentSubcomponentIDTerminalRuleCall_0_1() { return cSubcomponentSubcomponentIDTerminalRuleCall_0_1; }
	}
	public class QUALIFIEDNAMEElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.QUALIFIEDNAME");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QUALIFIEDNAME:
		//	ID ('.' ID)+;
		@Override public ParserRule getRule() { return rule; }
		
		//ID ('.' ID)+
		public Group getGroup() { return cGroup; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//('.' ID)+
		public Group getGroup_1() { return cGroup_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	public class QEMREFElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.QEMREF");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QEMREF:
		//	ID ('::' ID)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ID ('::' ID)*
		public Group getGroup() { return cGroup; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//('::' ID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'::'
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	private final EMV2RootElements pEMV2Root;
	private final AnnexLibraryElements pAnnexLibrary;
	private final AnnexSubclauseElements pAnnexSubclause;
	private final NamedElementElements pNamedElement;
	private final ModalElementElements pModalElement;
	private final ElementElements pElement;
	private final ErrorModelSubclauseElements pErrorModelSubclause;
	private final EMV2SubclauseElements pEMV2Subclause;
	private final ErrorModelLibraryElements pErrorModelLibrary;
	private final EMV2LibraryElements pEMV2Library;
	private final EMV2PropertyAssociationElements pEMV2PropertyAssociation;
	private final BasicEMV2PropertyAssociationElements pBasicEMV2PropertyAssociation;
	private final EMV2PathElements pEMV2Path;
	private final BasicEMV2PathElements pBasicEMV2Path;
	private final EMV2PathElementOrKindElements pEMV2PathElementOrKind;
	private final EMV2PathElementElements pEMV2PathElement;
	private final ErrorTypesElements pErrorTypes;
	private final TypeDefinitionElements pTypeDefinition;
	private final TypeSetDefinitionElements pTypeSetDefinition;
	private final TypeSetConstructorElements pTypeSetConstructor;
	private final TypeSetReferenceElements pTypeSetReference;
	private final TypeSetElementElements pTypeSetElement;
	private final NoErrorTypeSetElements pNoErrorTypeSet;
	private final NoErrorTypeTokenElements pNoErrorTypeToken;
	private final TypeTokenElements pTypeToken;
	private final TypeTokenOrNoErrorElements pTypeTokenOrNoError;
	private final TypeTokenConstraintElements pTypeTokenConstraint;
	private final TypeTokenConstraintNoErrorElements pTypeTokenConstraintNoError;
	private final TypeTransformationSetElements pTypeTransformationSet;
	private final TypeTransformationElements pTypeTransformation;
	private final TypeMappingSetElements pTypeMappingSet;
	private final TypeMappingElements pTypeMapping;
	private final ErrorPropagationElements pErrorPropagation;
	private final FeatureorPPReferenceElements pFeatureorPPReference;
	private final PropagationDirectionElements pPropagationDirection;
	private final PropagationKindElements pPropagationKind;
	private final ErrorFlowElements pErrorFlow;
	private final ErrorSourceElements pErrorSource;
	private final ErrorSinkElements pErrorSink;
	private final ErrorPathElements pErrorPath;
	private final IfConditionElements pIfCondition;
	private final ErrorPropagationPointElements pErrorPropagationPoint;
	private final PropagationPointElements pPropagationPoint;
	private final PropagationPathElements pPropagationPath;
	private final QualifiedPropagationPointElements pQualifiedPropagationPoint;
	private final ErrorBehaviorStateMachineElements pErrorBehaviorStateMachine;
	private final ErrorBehaviorEventElements pErrorBehaviorEvent;
	private final ErrorEventElements pErrorEvent;
	private final RepairEventElements pRepairEvent;
	private final RecoverEventElements pRecoverEvent;
	private final ErrorBehaviorStateElements pErrorBehaviorState;
	private final ErrorBehaviorTransitionElements pErrorBehaviorTransition;
	private final TransitionBranchElements pTransitionBranch;
	private final BranchValueElements pBranchValue;
	private final ConditionExpressionElements pConditionExpression;
	private final AndExpressionElements pAndExpression;
	private final AllExpressionElements pAllExpression;
	private final OrmoreExpressionElements pOrmoreExpression;
	private final OrlessExpressionElements pOrlessExpression;
	private final ConditionTermElements pConditionTerm;
	private final ConditionElementElements pConditionElement;
	private final QualifiedErrorEventOrPropagationElements pQualifiedErrorEventOrPropagation;
	private final EMV2ErrorPropagationPathElements pEMV2ErrorPropagationPath;
	private final EventOrPropagationElements pEventOrPropagation;
	private final OutgoingPropagationConditionElements pOutgoingPropagationCondition;
	private final ErrorDetectionElements pErrorDetection;
	private final ReportingPortReferenceElements pReportingPortReference;
	private final ErrorCodeValueElements pErrorCodeValue;
	private final ErrorStateToModeMappingElements pErrorStateToModeMapping;
	private final CompositeStateElements pCompositeState;
	private final SConditionExpressionElements pSConditionExpression;
	private final SAndExpressionElements pSAndExpression;
	private final SOrmoreExpressionElements pSOrmoreExpression;
	private final SOrlessExpressionElements pSOrlessExpression;
	private final SAllExpressionElements pSAllExpression;
	private final SConditionTermElements pSConditionTerm;
	private final QualifiedErrorPropagationElements pQualifiedErrorPropagation;
	private final SConditionElementElements pSConditionElement;
	private final QualifiedErrorBehaviorStateElements pQualifiedErrorBehaviorState;
	private final SubcomponentElementElements pSubcomponentElement;
	private final TerminalRule tSL_COMMENT;
	private final TerminalRule tINTEGER_LIT;
	private final QUALIFIEDNAMEElements pQUALIFIEDNAME;
	private final QEMREFElements pQEMREF;
	
	private final Grammar grammar;
	
	private final PropertiesGrammarAccess gaProperties;

	@Inject
	public ErrorModelGrammarAccess(GrammarProvider grammarProvider,
			PropertiesGrammarAccess gaProperties) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaProperties = gaProperties;
		this.pEMV2Root = new EMV2RootElements();
		this.pAnnexLibrary = new AnnexLibraryElements();
		this.pAnnexSubclause = new AnnexSubclauseElements();
		this.pNamedElement = new NamedElementElements();
		this.pModalElement = new ModalElementElements();
		this.pElement = new ElementElements();
		this.pErrorModelSubclause = new ErrorModelSubclauseElements();
		this.pEMV2Subclause = new EMV2SubclauseElements();
		this.pErrorModelLibrary = new ErrorModelLibraryElements();
		this.pEMV2Library = new EMV2LibraryElements();
		this.pEMV2PropertyAssociation = new EMV2PropertyAssociationElements();
		this.pBasicEMV2PropertyAssociation = new BasicEMV2PropertyAssociationElements();
		this.pEMV2Path = new EMV2PathElements();
		this.pBasicEMV2Path = new BasicEMV2PathElements();
		this.pEMV2PathElementOrKind = new EMV2PathElementOrKindElements();
		this.pEMV2PathElement = new EMV2PathElementElements();
		this.pErrorTypes = new ErrorTypesElements();
		this.pTypeDefinition = new TypeDefinitionElements();
		this.pTypeSetDefinition = new TypeSetDefinitionElements();
		this.pTypeSetConstructor = new TypeSetConstructorElements();
		this.pTypeSetReference = new TypeSetReferenceElements();
		this.pTypeSetElement = new TypeSetElementElements();
		this.pNoErrorTypeSet = new NoErrorTypeSetElements();
		this.pNoErrorTypeToken = new NoErrorTypeTokenElements();
		this.pTypeToken = new TypeTokenElements();
		this.pTypeTokenOrNoError = new TypeTokenOrNoErrorElements();
		this.pTypeTokenConstraint = new TypeTokenConstraintElements();
		this.pTypeTokenConstraintNoError = new TypeTokenConstraintNoErrorElements();
		this.pTypeTransformationSet = new TypeTransformationSetElements();
		this.pTypeTransformation = new TypeTransformationElements();
		this.pTypeMappingSet = new TypeMappingSetElements();
		this.pTypeMapping = new TypeMappingElements();
		this.pErrorPropagation = new ErrorPropagationElements();
		this.pFeatureorPPReference = new FeatureorPPReferenceElements();
		this.pPropagationDirection = new PropagationDirectionElements();
		this.pPropagationKind = new PropagationKindElements();
		this.pErrorFlow = new ErrorFlowElements();
		this.pErrorSource = new ErrorSourceElements();
		this.pErrorSink = new ErrorSinkElements();
		this.pErrorPath = new ErrorPathElements();
		this.pIfCondition = new IfConditionElements();
		this.pErrorPropagationPoint = new ErrorPropagationPointElements();
		this.pPropagationPoint = new PropagationPointElements();
		this.pPropagationPath = new PropagationPathElements();
		this.pQualifiedPropagationPoint = new QualifiedPropagationPointElements();
		this.pErrorBehaviorStateMachine = new ErrorBehaviorStateMachineElements();
		this.pErrorBehaviorEvent = new ErrorBehaviorEventElements();
		this.pErrorEvent = new ErrorEventElements();
		this.pRepairEvent = new RepairEventElements();
		this.pRecoverEvent = new RecoverEventElements();
		this.pErrorBehaviorState = new ErrorBehaviorStateElements();
		this.pErrorBehaviorTransition = new ErrorBehaviorTransitionElements();
		this.pTransitionBranch = new TransitionBranchElements();
		this.pBranchValue = new BranchValueElements();
		this.pConditionExpression = new ConditionExpressionElements();
		this.pAndExpression = new AndExpressionElements();
		this.pAllExpression = new AllExpressionElements();
		this.pOrmoreExpression = new OrmoreExpressionElements();
		this.pOrlessExpression = new OrlessExpressionElements();
		this.pConditionTerm = new ConditionTermElements();
		this.pConditionElement = new ConditionElementElements();
		this.pQualifiedErrorEventOrPropagation = new QualifiedErrorEventOrPropagationElements();
		this.pEMV2ErrorPropagationPath = new EMV2ErrorPropagationPathElements();
		this.pEventOrPropagation = new EventOrPropagationElements();
		this.pOutgoingPropagationCondition = new OutgoingPropagationConditionElements();
		this.pErrorDetection = new ErrorDetectionElements();
		this.pReportingPortReference = new ReportingPortReferenceElements();
		this.pErrorCodeValue = new ErrorCodeValueElements();
		this.pErrorStateToModeMapping = new ErrorStateToModeMappingElements();
		this.pCompositeState = new CompositeStateElements();
		this.pSConditionExpression = new SConditionExpressionElements();
		this.pSAndExpression = new SAndExpressionElements();
		this.pSOrmoreExpression = new SOrmoreExpressionElements();
		this.pSOrlessExpression = new SOrlessExpressionElements();
		this.pSAllExpression = new SAllExpressionElements();
		this.pSConditionTerm = new SConditionTermElements();
		this.pQualifiedErrorPropagation = new QualifiedErrorPropagationElements();
		this.pSConditionElement = new SConditionElementElements();
		this.pQualifiedErrorBehaviorState = new QualifiedErrorBehaviorStateElements();
		this.pSubcomponentElement = new SubcomponentElementElements();
		this.tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.SL_COMMENT");
		this.tINTEGER_LIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.errormodel.ErrorModel.INTEGER_LIT");
		this.pQUALIFIEDNAME = new QUALIFIEDNAMEElements();
		this.pQEMREF = new QEMREFElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.xtext.aadl2.errormodel.ErrorModel".equals(grammar.getName())) {
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

	
	///*
	// * Note about symbolic labels as values for occurrence probability:
	// * Use property constant. The core allows it instead of an actual number.
	// * The tools generating stochastic models from such specification can interpret the constant name as the desired label.
	// */ // allow either of the two to be the root. Needed dummy 'library' keyword
	//EMV2Root aadl2::NamedElement:
	//	{EMV2Root} (library=EMV2Library | subclauses+=EMV2Subclause*);
	public EMV2RootElements getEMV2RootAccess() {
		return pEMV2Root;
	}
	
	public ParserRule getEMV2RootRule() {
		return getEMV2RootAccess().getRule();
	}
	
	//AnnexLibrary aadl2::AnnexLibrary:
	//	ErrorModelLibrary;
	public AnnexLibraryElements getAnnexLibraryAccess() {
		return pAnnexLibrary;
	}
	
	public ParserRule getAnnexLibraryRule() {
		return getAnnexLibraryAccess().getRule();
	}
	
	//AnnexSubclause aadl2::AnnexSubclause:
	//	ErrorModelSubclause;
	public AnnexSubclauseElements getAnnexSubclauseAccess() {
		return pAnnexSubclause;
	}
	
	public ParserRule getAnnexSubclauseRule() {
		return getAnnexSubclauseAccess().getRule();
	}
	
	//NamedElement aadl2::NamedElement:
	//	ErrorModelLibrary | ErrorTypes | ErrorBehaviorEvent | ErrorBehaviorState | ErrorBehaviorTransition
	//	| ErrorFlow | ErrorPropagation | OutgoingPropagationCondition
	//	| PropagationPath | PropagationPoint | CompositeState
	//	| TypeTransformationSet | TypeMappingSet | ErrorBehaviorStateMachine
	//	| ErrorDetection | EventOrPropagation;
	public NamedElementElements getNamedElementAccess() {
		return pNamedElement;
	}
	
	public ParserRule getNamedElementRule() {
		return getNamedElementAccess().getRule();
	}
	
	//ModalElement aadl2::ModalElement:
	//	ErrorModelSubclause;
	public ModalElementElements getModalElementAccess() {
		return pModalElement;
	}
	
	public ParserRule getModalElementRule() {
		return getModalElementAccess().getRule();
	}
	
	//Element aadl2::Element:
	//	TypeSetElement
	//	| TypeTransformation | TypeMapping
	//	| QualifiedPropagationPoint | TransitionBranch | BranchValue | ErrorCodeValue
	//	| ConditionElement | AndExpression | ConditionTerm
	//	| ConditionExpression | OrmoreExpression | OrlessExpression
	//	| ErrorStateToModeMapping | QualifiedErrorBehaviorState
	//	| SubcomponentElement | FeatureorPPReference | EMV2PropertyAssociation | EMV2Path | EMV2PathElement;
	public ElementElements getElementAccess() {
		return pElement;
	}
	
	public ParserRule getElementRule() {
		return getElementAccess().getRule();
	}
	
	//ErrorModelSubclause:
	//	{ErrorModelSubclause} ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (',' useTypes+=[ErrorModelLibrary|QEMREF])*
	//	';')? ('use' 'type' 'equivalence' typeEquivalence=[TypeMappingSet|QEMREF] ';')? ('use' 'mappings'
	//	typeMappingSet=[TypeMappingSet|QEMREF] ';')? ('use' 'behavior' useBehavior=[ErrorBehaviorStateMachine|QEMREF]
	//	//   	('(' stateTypeBindings+=StateTypeBinding (',' stateTypeBindings+=StateTypeBinding)*')')?
	//	';')? ('error' 'propagations'
	//	propagations+=ErrorPropagation* ('flows'
	//	flows+=ErrorFlow+)?
	//	'end' 'propagations' ';')? ('component' 'error' 'behavior' ('use' 'transformations'
	//	useTransformation=[TypeTransformationSet|QEMREF] ';')? ('events' events+=ErrorBehaviorEvent+)? ('transitions'
	//	transitions+=ErrorBehaviorTransition+)? ('propagations'
	//	outgoingPropagationConditions+=OutgoingPropagationCondition+)? ('detections'
	//	errorDetections+=ErrorDetection+)? ('mode' 'mappings'
	//	errorStateToModeMappings+=ErrorStateToModeMapping+)?
	//	'end' 'component' ';')? ('composite' 'error' 'behavior' ('states'
	//	states+=CompositeState+)?
	//	'end' 'composite' ';')? ('connection' 'error' ('use' 'transformations'
	//	typeTransformationSet=[TypeTransformationSet|QEMREF] ';')?
	//	connectionErrorSources+=ErrorSource*
	//	'end' 'connection' ';')? ('propagation' 'paths'
	//	points+=PropagationPoint*
	//	paths+=PropagationPath*
	//	'end' 'paths' ';')? ('properties'
	//	properties+=EMV2PropertyAssociation+)?
	//	//	'**}'
	//;
	public ErrorModelSubclauseElements getErrorModelSubclauseAccess() {
		return pErrorModelSubclause;
	}
	
	public ParserRule getErrorModelSubclauseRule() {
		return getErrorModelSubclauseAccess().getRule();
	}
	
	//EMV2Subclause ErrorModelSubclause:
	//	{ErrorModelSubclause} 'subclause' name=QCREF ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
	//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('use' 'type' 'equivalence' typeEquivalence=[TypeMappingSet|QEMREF] ';')?
	//	('use' 'mappings' typeMappingSet=[TypeMappingSet|QEMREF] ';')? ('use' 'behavior'
	//	useBehavior=[ErrorBehaviorStateMachine|QEMREF]
	//	//   	('(' stateTypeBindings+=StateTypeBinding (',' stateTypeBindings+=StateTypeBinding)*')')?
	//	';')? ('error' 'propagations'
	//	propagations+=ErrorPropagation* ('flows'
	//	flows+=ErrorFlow+)?
	//	'end' 'propagations' ';')? ('component' 'error' 'behavior' ('use' 'transformations'
	//	useTransformation=[TypeTransformationSet|QEMREF] ';')? ('events' events+=ErrorBehaviorEvent+)? ('transitions'
	//	transitions+=ErrorBehaviorTransition+)? ('propagations'
	//	outgoingPropagationConditions+=OutgoingPropagationCondition+)? ('detections'
	//	errorDetections+=ErrorDetection+)? ('mode' 'mappings'
	//	errorStateToModeMappings+=ErrorStateToModeMapping+)?
	//	'end' 'component' ';')? ('composite' 'error' 'behavior' ('states'
	//	states+=CompositeState+)?
	//	'end' 'composite' ';')? ('connection' 'error' ('use' 'transformations'
	//	typeTransformationSet=[TypeTransformationSet|QEMREF] ';')?
	//	connectionErrorSources+=ErrorSource*
	//	'end' 'connection' ';')? ('propagation' 'paths'
	//	points+=PropagationPoint*
	//	paths+=PropagationPath*
	//	'end' 'paths' ';')? ('properties'
	//	properties+=EMV2PropertyAssociation+)?
	//	//	'**}'
	//	'end' 'subclause' ';';
	public EMV2SubclauseElements getEMV2SubclauseAccess() {
		return pEMV2Subclause;
	}
	
	public ParserRule getEMV2SubclauseRule() {
		return getEMV2SubclauseAccess().getRule();
	}
	
	//ErrorModelLibrary:
	//	{ErrorModelLibrary} ('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
	//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('extends' extends+=[ErrorModelLibrary|QEMREF] (','
	//	extends+=[ErrorModelLibrary|QEMREF])*
	//	'with')? (types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties'
	//	properties+=BasicEMV2PropertyAssociation+)?
	//	'end' 'types' ';')?
	//	behaviors+=ErrorBehaviorStateMachine*
	//	mappings+=TypeMappingSet*
	//	transformations+=TypeTransformationSet*
	//	//	'**}'
	//;
	public ErrorModelLibraryElements getErrorModelLibraryAccess() {
		return pErrorModelLibrary;
	}
	
	public ParserRule getErrorModelLibraryRule() {
		return getErrorModelLibraryAccess().getRule();
	}
	
	//EMV2Library ErrorModelLibrary:
	//	{ErrorModelLibrary} ('library' name=QEMREF ('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
	//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('extends' extends+=[ErrorModelLibrary|QEMREF] (','
	//	extends+=[ErrorModelLibrary|QEMREF])*
	//	'with')? (types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties'
	//	properties+=BasicEMV2PropertyAssociation+)?
	//	'end' 'types' ';')?
	//	behaviors+=ErrorBehaviorStateMachine*
	//	mappings+=TypeMappingSet*
	//	transformations+=TypeTransformationSet*) | 'package' name=QEMREF 'public'
	//	'annex' ID '{**' ('error' 'types' ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
	//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('extends' extends+=[ErrorModelLibrary|QEMREF] (','
	//	extends+=[ErrorModelLibrary|QEMREF])*
	//	'with')? (types+=TypeDefinition | typesets+=TypeSetDefinition)* ('properties'
	//	properties+=BasicEMV2PropertyAssociation+)?
	//	'end' 'types' ';')?
	//	behaviors+=ErrorBehaviorStateMachine*
	//	mappings+=TypeMappingSet*
	//	transformations+=TypeTransformationSet*
	//	'**}' ';' 'end' QEMREF ';';
	public EMV2LibraryElements getEMV2LibraryAccess() {
		return pEMV2Library;
	}
	
	public ParserRule getEMV2LibraryRule() {
		return getEMV2LibraryAccess().getRule();
	}
	
	//EMV2PropertyAssociation:
	//	property=[aadl2::Property|QPREF]
	//	'=>' (ownedValues+=OptionalModalPropertyValue (',' ownedValues+=OptionalModalPropertyValue)*) ('applies' 'to'
	//	(emv2Path+=EMV2Path (',' emv2Path+=EMV2Path)*))?
	//	';';
	public EMV2PropertyAssociationElements getEMV2PropertyAssociationAccess() {
		return pEMV2PropertyAssociation;
	}
	
	public ParserRule getEMV2PropertyAssociationRule() {
		return getEMV2PropertyAssociationAccess().getRule();
	}
	
	//BasicEMV2PropertyAssociation EMV2PropertyAssociation:
	//	property=[aadl2::Property|QPREF]
	//	'=>' (ownedValues+=OptionalModalPropertyValue (',' ownedValues+=OptionalModalPropertyValue)*) ('applies' 'to'
	//	(emv2Path+=BasicEMV2Path (',' emv2Path+=BasicEMV2Path)*))?
	//	';';
	public BasicEMV2PropertyAssociationElements getBasicEMV2PropertyAssociationAccess() {
		return pBasicEMV2PropertyAssociation;
	}
	
	public ParserRule getBasicEMV2PropertyAssociationRule() {
		return getBasicEMV2PropertyAssociationAccess().getRule();
	}
	
	//EMV2Path:
	//	('^' containmentPath=ContainmentPathElement '@')?
	//	emv2Target=EMV2PathElementOrKind;
	public EMV2PathElements getEMV2PathAccess() {
		return pEMV2Path;
	}
	
	public ParserRule getEMV2PathRule() {
		return getEMV2PathAccess().getRule();
	}
	
	//BasicEMV2Path EMV2Path:
	//	emv2Target=EMV2PathElementOrKind;
	public BasicEMV2PathElements getBasicEMV2PathAccess() {
		return pBasicEMV2Path;
	}
	
	public ParserRule getBasicEMV2PathRule() {
		return getBasicEMV2PathAccess().getRule();
	}
	
	//EMV2PathElementOrKind EMV2PathElement:
	//	emv2PropagationKind=PropagationKind ('.' errorType=[ErrorTypes])?
	//	| namedElement=[aadl2::NamedElement] ('.' path=EMV2PathElement)?;
	public EMV2PathElementOrKindElements getEMV2PathElementOrKindAccess() {
		return pEMV2PathElementOrKind;
	}
	
	public ParserRule getEMV2PathElementOrKindRule() {
		return getEMV2PathElementOrKindAccess().getRule();
	}
	
	//EMV2PathElement:
	//	namedElement=[aadl2::NamedElement] ('.' path=EMV2PathElement)?;
	public EMV2PathElementElements getEMV2PathElementAccess() {
		return pEMV2PathElement;
	}
	
	public ParserRule getEMV2PathElementRule() {
		return getEMV2PathElementAccess().getRule();
	}
	
	//ErrorTypes:
	//	TypeDefinition | TypeSetDefinition;
	public ErrorTypesElements getErrorTypesAccess() {
		return pErrorTypes;
	}
	
	public ParserRule getErrorTypesRule() {
		return getErrorTypesAccess().getRule();
	}
	
	//TypeDefinition ErrorType:
	//	name=ID (':' 'type' | ':' 'type' 'extends' superType=[ErrorType|QEMREF] | 'renames' 'type'
	//	aliasedType=[ErrorType|QEMREF])
	//	';';
	public TypeDefinitionElements getTypeDefinitionAccess() {
		return pTypeDefinition;
	}
	
	public ParserRule getTypeDefinitionRule() {
		return getTypeDefinitionAccess().getRule();
	}
	
	//TypeSetDefinition TypeSet:
	//	name=ID (':' 'type' 'set' '{' typeTokens+=TypeSetElement (',' typeTokens+=TypeSetElement)* '}' | 'renames' 'type'
	//	'set' aliasedType=[TypeSet|QEMREF])
	//	';';
	public TypeSetDefinitionElements getTypeSetDefinitionAccess() {
		return pTypeSetDefinition;
	}
	
	public ParserRule getTypeSetDefinitionRule() {
		return getTypeSetDefinitionAccess().getRule();
	}
	
	//TypeSetConstructor TypeSet:
	//	'{' typeTokens+=TypeSetElement (',' typeTokens+=TypeSetElement)* '}';
	public TypeSetConstructorElements getTypeSetConstructorAccess() {
		return pTypeSetConstructor;
	}
	
	public ParserRule getTypeSetConstructorRule() {
		return getTypeSetConstructorAccess().getRule();
	}
	
	//TypeSetReference TypeSet:
	//	TypeSetConstructor;
	public TypeSetReferenceElements getTypeSetReferenceAccess() {
		return pTypeSetReference;
	}
	
	public ParserRule getTypeSetReferenceRule() {
		return getTypeSetReferenceAccess().getRule();
	}
	
	//TypeSetElement TypeToken:
	//	type+=[ErrorTypes|QEMREF] ('*' type+=[ErrorTypes|QEMREF])*;
	public TypeSetElementElements getTypeSetElementAccess() {
		return pTypeSetElement;
	}
	
	public ParserRule getTypeSetElementRule() {
		return getTypeSetElementAccess().getRule();
	}
	
	//NoErrorTypeSet TypeSet:
	//	{TypeSet}
	//	'{' typeTokens+=NoErrorTypeToken '}';
	public NoErrorTypeSetElements getNoErrorTypeSetAccess() {
		return pNoErrorTypeSet;
	}
	
	public ParserRule getNoErrorTypeSetRule() {
		return getNoErrorTypeSetAccess().getRule();
	}
	
	//NoErrorTypeToken TypeToken:
	//	{TypeToken} noError?='noerror';
	public NoErrorTypeTokenElements getNoErrorTypeTokenAccess() {
		return pNoErrorTypeToken;
	}
	
	public ParserRule getNoErrorTypeTokenRule() {
		return getNoErrorTypeTokenAccess().getRule();
	}
	
	//TypeToken TypeSet:
	//	TypeSetReference;
	public TypeTokenElements getTypeTokenAccess() {
		return pTypeToken;
	}
	
	public ParserRule getTypeTokenRule() {
		return getTypeTokenAccess().getRule();
	}
	
	////returns TypeToken:
	////	{TypeToken}
	////     ('{' type+=[ErrorTypes|QEMREF] (('*') type+=[ErrorTypes|QEMREF])* '}')
	////;
	//TypeTokenOrNoError TypeSet:
	//	TypeSetReference | NoErrorTypeSet;
	public TypeTokenOrNoErrorElements getTypeTokenOrNoErrorAccess() {
		return pTypeTokenOrNoError;
	}
	
	public ParserRule getTypeTokenOrNoErrorRule() {
		return getTypeTokenOrNoErrorAccess().getRule();
	}
	
	////returns TypeToken:
	////	TypeToken  
	////	| '{' NoErrorTypeToken '}'
	////;
	//TypeTokenConstraint TypeSet:
	//	TypeSetReference;
	public TypeTokenConstraintElements getTypeTokenConstraintAccess() {
		return pTypeTokenConstraint;
	}
	
	public ParserRule getTypeTokenConstraintRule() {
		return getTypeTokenConstraintAccess().getRule();
	}
	
	//TypeTokenConstraintNoError TypeSet:
	//	TypeSetReference | NoErrorTypeSet;
	public TypeTokenConstraintNoErrorElements getTypeTokenConstraintNoErrorAccess() {
		return pTypeTokenConstraintNoError;
	}
	
	public ParserRule getTypeTokenConstraintNoErrorRule() {
		return getTypeTokenConstraintNoErrorAccess().getRule();
	}
	
	//TypeTransformationSet:
	//	'type' 'transformations' name=ID ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
	//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
	//	transformation+=TypeTransformation+
	//	'end' 'transformations' ';';
	public TypeTransformationSetElements getTypeTransformationSetAccess() {
		return pTypeTransformationSet;
	}
	
	public ParserRule getTypeTransformationSetRule() {
		return getTypeTransformationSetAccess().getRule();
	}
	
	//TypeTransformation:
	//	(source=TypeTokenConstraintNoError | allSources?='all')
	//	'-[' contributor=TypeTokenConstraintNoError? ']->' target=TypeToken ';';
	public TypeTransformationElements getTypeTransformationAccess() {
		return pTypeTransformation;
	}
	
	public ParserRule getTypeTransformationRule() {
		return getTypeTransformationAccess().getRule();
	}
	
	//TypeMappingSet:
	//	'type' 'mappings' name=ID ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
	//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')?
	//	mapping+=TypeMapping+
	//	'end' 'mappings' ';';
	public TypeMappingSetElements getTypeMappingSetAccess() {
		return pTypeMappingSet;
	}
	
	public ParserRule getTypeMappingSetRule() {
		return getTypeMappingSetAccess().getRule();
	}
	
	//TypeMapping:
	//	source=TypeTokenConstraint '->' target=TypeToken ';';
	public TypeMappingElements getTypeMappingAccess() {
		return pTypeMapping;
	}
	
	public ParserRule getTypeMappingRule() {
		return getTypeMappingAccess().getRule();
	}
	
	////StateTypeBinding returns ErrorBehaviorState:
	////	(intial?='initial')? 'state' name=ID typeSet = TypeSetReference
	////;
	//ErrorPropagation:
	//	{ErrorPropagation} (kind=PropagationKind | featureorPPRef=FeatureorPPReference)
	//	':' not?='not'? direction=PropagationDirection 'propagation'
	//	typeSet=TypeSetReference
	//	';';
	public ErrorPropagationElements getErrorPropagationAccess() {
		return pErrorPropagation;
	}
	
	public ParserRule getErrorPropagationRule() {
		return getErrorPropagationAccess().getRule();
	}
	
	//FeatureorPPReference:
	//	featureorPP=[aadl2::NamedElement] ("." next=FeatureorPPReference)?;
	public FeatureorPPReferenceElements getFeatureorPPReferenceAccess() {
		return pFeatureorPPReference;
	}
	
	public ParserRule getFeatureorPPReferenceRule() {
		return getFeatureorPPReferenceAccess().getRule();
	}
	
	//PropagationDirection aadl2::DirectionType:
	//	'in' | 'out';
	public PropagationDirectionElements getPropagationDirectionAccess() {
		return pPropagationDirection;
	}
	
	public ParserRule getPropagationDirectionRule() {
		return getPropagationDirectionAccess().getRule();
	}
	
	//PropagationKind:
	//	'processor' | 'memory' | 'connection' | 'binding' | 'bindings' | 'access';
	public PropagationKindElements getPropagationKindAccess() {
		return pPropagationKind;
	}
	
	public ParserRule getPropagationKindRule() {
		return getPropagationKindAccess().getRule();
	}
	
	//// enum does not work as  
	////enum PropKind : PROCESSOR='processor'|MEMORY='memory'|BUS='bus'|DEVICE='device'|SYSTEM='system'
	////	            |VIRTUALBUS='virtual bus'|VIRTUALPROCESSOR='virtual processor'|BINDING='binding' | BINDINGS='bindings'|ACCESS='access'
	////;
	//ErrorFlow:
	//	ErrorSource | ErrorSink | ErrorPath;
	public ErrorFlowElements getErrorFlowAccess() {
		return pErrorFlow;
	}
	
	public ParserRule getErrorFlowRule() {
		return getErrorFlowAccess().getRule();
	}
	
	//ErrorSource:
	//	name=ID ':' 'error' 'source' (sourceModelElement=[aadl2::NamedElement|ErrorPropagationPoint] | all?='all')
	//	typeTokenConstraint=TypeTokenConstraint? ('when' (failureModeReference=[ErrorBehaviorState]
	//	failureModeType=TypeSetReference? | failureModeType=TypeSetConstructor | failureModeDescription=STRING))? ('if'
	//	flowcondition=IfCondition)?
	//	';';
	public ErrorSourceElements getErrorSourceAccess() {
		return pErrorSource;
	}
	
	public ParserRule getErrorSourceRule() {
		return getErrorSourceAccess().getRule();
	}
	
	//ErrorSink:
	//	name=ID ':' 'error' 'sink' (incoming=[ErrorPropagation|ErrorPropagationPoint] | allIncoming?='all')
	//	typeTokenConstraint=TypeTokenConstraint? ('if' flowcondition=IfCondition)?
	//	';';
	public ErrorSinkElements getErrorSinkAccess() {
		return pErrorSink;
	}
	
	public ParserRule getErrorSinkRule() {
		return getErrorSinkAccess().getRule();
	}
	
	//ErrorPath:
	//	name=ID ':' 'error' 'path' (incoming=[ErrorPropagation|ErrorPropagationPoint] | allIncoming?='all')
	//	typeTokenConstraint=TypeTokenConstraint? '->' (outgoing=[ErrorPropagation|ErrorPropagationPoint] | allOutgoing?='all')
	//	(targetToken=TypeToken | 'use' 'mappings' typeMappingSet=[TypeMappingSet|QEMREF])? ('if' flowcondition=IfCondition)?
	//	';';
	public ErrorPathElements getErrorPathAccess() {
		return pErrorPath;
	}
	
	public ParserRule getErrorPathRule() {
		return getErrorPathAccess().getRule();
	}
	
	//IfCondition:
	//	description=STRING | resoluteFunction=[ecore::EObject|QEMREF] | javaMethod=QUALIFIEDNAME;
	public IfConditionElements getIfConditionAccess() {
		return pIfCondition;
	}
	
	public ParserRule getIfConditionRule() {
		return getIfConditionAccess().getRule();
	}
	
	//// reference to error propagation  
	//ErrorPropagationPoint:
	//	(ID ".")* (PropagationKind | ID);
	public ErrorPropagationPointElements getErrorPropagationPointAccess() {
		return pErrorPropagationPoint;
	}
	
	public ParserRule getErrorPropagationPointRule() {
		return getErrorPropagationPointAccess().getRule();
	}
	
	//PropagationPoint:
	//	name=ID ':' 'propagation' 'point'
	//	';';
	public PropagationPointElements getPropagationPointAccess() {
		return pPropagationPoint;
	}
	
	public ParserRule getPropagationPointRule() {
		return getPropagationPointAccess().getRule();
	}
	
	//PropagationPath:
	//	(name=ID ':')? source=QualifiedPropagationPoint '->' target=QualifiedPropagationPoint ';';
	public PropagationPathElements getPropagationPathAccess() {
		return pPropagationPath;
	}
	
	public ParserRule getPropagationPathRule() {
		return getPropagationPathAccess().getRule();
	}
	
	//QualifiedPropagationPoint:
	//	subcomponent=SubcomponentElement '.' next=QualifiedPropagationPoint | propagationPoint=[aadl2::NamedElement];
	public QualifiedPropagationPointElements getQualifiedPropagationPointAccess() {
		return pQualifiedPropagationPoint;
	}
	
	public ParserRule getQualifiedPropagationPointRule() {
		return getQualifiedPropagationPointAccess().getRule();
	}
	
	//ErrorBehaviorStateMachine:
	//	'error' 'behavior' name=ID ('use' 'types' useTypes+=[ErrorModelLibrary|QEMREF] (','
	//	useTypes+=[ErrorModelLibrary|QEMREF])* ';')? ('use' 'transformations'
	//	useTransformation+=[TypeTransformationSet|QEMREF] ';')? ('events' events+=ErrorBehaviorEvent+)? ('states'
	//	states+=ErrorBehaviorState+)? ('transitions' transitions+=ErrorBehaviorTransition+)? ('properties'
	//	properties+=BasicEMV2PropertyAssociation+)?
	//	'end' 'behavior' ';';
	public ErrorBehaviorStateMachineElements getErrorBehaviorStateMachineAccess() {
		return pErrorBehaviorStateMachine;
	}
	
	public ParserRule getErrorBehaviorStateMachineRule() {
		return getErrorBehaviorStateMachineAccess().getRule();
	}
	
	//ErrorBehaviorEvent:
	//	ErrorEvent | RepairEvent | RecoverEvent;
	public ErrorBehaviorEventElements getErrorBehaviorEventAccess() {
		return pErrorBehaviorEvent;
	}
	
	public ParserRule getErrorBehaviorEventRule() {
		return getErrorBehaviorEventAccess().getRule();
	}
	
	//ErrorEvent:
	//	name=ID ':' 'error' 'event'
	//	typeSet=TypeSetReference? ('if' eventcondition=IfCondition)?
	//	';';
	public ErrorEventElements getErrorEventAccess() {
		return pErrorEvent;
	}
	
	public ParserRule getErrorEventRule() {
		return getErrorEventAccess().getRule();
	}
	
	//// add event condition 
	//RepairEvent:
	//	name=ID ':' 'repair' 'event' ('when' eventInitiator+=[aadl2::NamedElement] (","
	//	eventInitiator+=[aadl2::NamedElement])*)?
	//	';';
	public RepairEventElements getRepairEventAccess() {
		return pRepairEvent;
	}
	
	public ParserRule getRepairEventRule() {
		return getRepairEventAccess().getRule();
	}
	
	//RecoverEvent:
	//	name=ID ':' 'recover' 'event' ('when' eventInitiator+=[aadl2::NamedElement] (","
	//	eventInitiator+=[aadl2::NamedElement])*)? ('if' condition=IfCondition)?
	//	';';
	public RecoverEventElements getRecoverEventAccess() {
		return pRecoverEvent;
	}
	
	public ParserRule getRecoverEventRule() {
		return getRecoverEventAccess().getRule();
	}
	
	////add recover initiator 
	//ErrorBehaviorState:
	//	name=ID ':' intial?='initial'? 'state'
	//	typeSet=TypeSetReference?
	//	';';
	public ErrorBehaviorStateElements getErrorBehaviorStateAccess() {
		return pErrorBehaviorState;
	}
	
	public ParserRule getErrorBehaviorStateRule() {
		return getErrorBehaviorStateAccess().getRule();
	}
	
	//ErrorBehaviorTransition:
	//	(name=ID ':')? (source=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint? | allStates?='all')
	//	'-[' condition=ConditionExpression ']->' (target=[ErrorBehaviorState] targetToken=TypeToken? | steadyState?='same'
	//	'state' | '(' destinationBranches+=TransitionBranch (',' destinationBranches+=TransitionBranch)+ ')')
	//	';';
	public ErrorBehaviorTransitionElements getErrorBehaviorTransitionAccess() {
		return pErrorBehaviorTransition;
	}
	
	public ParserRule getErrorBehaviorTransitionRule() {
		return getErrorBehaviorTransitionAccess().getRule();
	}
	
	//TransitionBranch:
	//	(target=[ErrorBehaviorState] targetToken=TypeToken? | steadyState?='same' 'state')
	//	'with' value=BranchValue;
	public TransitionBranchElements getTransitionBranchAccess() {
		return pTransitionBranch;
	}
	
	public ParserRule getTransitionBranchRule() {
		return getTransitionBranchAccess().getRule();
	}
	
	//// store real literal as integer, ID as reference to property constant
	//BranchValue:
	//	{BranchValue} (realvalue=REAL_LIT | symboliclabel=[aadl2::Property|QEMREF] | others?='others');
	public BranchValueElements getBranchValueAccess() {
		return pBranchValue;
	}
	
	public ParserRule getBranchValueRule() {
		return getBranchValueAccess().getRule();
	}
	
	//// condition expression for component specific transitions 
	//// based on error events and incoming propagations
	//ConditionExpression:
	//	AndExpression ({OrExpression.operands+=current} 'or' operands+=AndExpression)*;
	public ConditionExpressionElements getConditionExpressionAccess() {
		return pConditionExpression;
	}
	
	public ParserRule getConditionExpressionRule() {
		return getConditionExpressionAccess().getRule();
	}
	
	//AndExpression ConditionExpression:
	//	ConditionTerm ({AndExpression.operands+=current} 'and' operands+=ConditionTerm)*;
	public AndExpressionElements getAndExpressionAccess() {
		return pAndExpression;
	}
	
	public ParserRule getAndExpressionRule() {
		return getAndExpressionAccess().getRule();
	}
	
	//AllExpression ConditionExpression:
	//	{AllExpression} 'all' ('-' count=INTVALUE)? '(' operands+=ConditionElement (',' operands+=ConditionElement)* ')';
	public AllExpressionElements getAllExpressionAccess() {
		return pAllExpression;
	}
	
	public ParserRule getAllExpressionRule() {
		return getAllExpressionAccess().getRule();
	}
	
	//OrmoreExpression:
	//	count=INTVALUE 'ormore' '(' operands+=ConditionExpression (',' operands+=ConditionExpression)* ')';
	public OrmoreExpressionElements getOrmoreExpressionAccess() {
		return pOrmoreExpression;
	}
	
	public ParserRule getOrmoreExpressionRule() {
		return getOrmoreExpressionAccess().getRule();
	}
	
	//OrlessExpression:
	//	count=INTVALUE 'orless' '(' operands+=ConditionExpression (',' operands+=ConditionExpression)* ')';
	public OrlessExpressionElements getOrlessExpressionAccess() {
		return pOrlessExpression;
	}
	
	public ParserRule getOrlessExpressionRule() {
		return getOrlessExpressionAccess().getRule();
	}
	
	//ConditionTerm ConditionExpression:
	//	ConditionElement
	//	| OrmoreExpression
	//	| OrlessExpression
	//	| AllExpression
	//	| '(' ConditionExpression ')';
	public ConditionTermElements getConditionTermAccess() {
		return pConditionTerm;
	}
	
	public ParserRule getConditionTermRule() {
		return getConditionTermAccess().getRule();
	}
	
	//ConditionElement:
	//	qualifiedErrorPropagationReference=QualifiedErrorEventOrPropagation constraint=TypeTokenConstraintNoError?;
	public ConditionElementElements getConditionElementAccess() {
		return pConditionElement;
	}
	
	public ParserRule getConditionElementRule() {
		return getConditionElementAccess().getRule();
	}
	
	////QualifiedErrorPropagation returns QualifiedErrorPropagation:
	////	(modelElementReference=NestedModelElement '.')?    (  kind=PropagationKind | errorPropagation=[ErrorPropagation|ID])
	////;
	////
	////NestedModelElement returns NestedModelElement:
	////	modelElement=[aadl2::NamedElement|ID] ( next=NestedModelElement)?
	////;
	//QualifiedErrorEventOrPropagation EMV2Path:
	//	{QualifiedErrorEventOrPropagation} emv2Target=EMV2ErrorPropagationPath;
	public QualifiedErrorEventOrPropagationElements getQualifiedErrorEventOrPropagationAccess() {
		return pQualifiedErrorEventOrPropagation;
	}
	
	public ParserRule getQualifiedErrorEventOrPropagationRule() {
		return getQualifiedErrorEventOrPropagationAccess().getRule();
	}
	
	//EMV2ErrorPropagationPath EMV2PathElement:
	//	emv2PropagationKind=PropagationKind
	//	| namedElement=[aadl2::NamedElement] ('.' path=EMV2ErrorPropagationPath)?;
	public EMV2ErrorPropagationPathElements getEMV2ErrorPropagationPathAccess() {
		return pEMV2ErrorPropagationPath;
	}
	
	public ParserRule getEMV2ErrorPropagationPathRule() {
		return getEMV2ErrorPropagationPathAccess().getRule();
	}
	
	//EventOrPropagation:
	//	ErrorBehaviorEvent | ErrorPropagation;
	public EventOrPropagationElements getEventOrPropagationAccess() {
		return pEventOrPropagation;
	}
	
	public ParserRule getEventOrPropagationRule() {
		return getEventOrPropagationAccess().getRule();
	}
	
	//OutgoingPropagationCondition:
	//	(name=ID ':')? (state=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint? | allStates?='all')
	//	'-[' condition=ConditionExpression? ']->' ((outgoing=[ErrorPropagation|ErrorPropagationPoint] |
	//	allPropagations?='all') typeToken=TypeTokenOrNoError?)
	//	';';
	public OutgoingPropagationConditionElements getOutgoingPropagationConditionAccess() {
		return pOutgoingPropagationCondition;
	}
	
	public ParserRule getOutgoingPropagationConditionRule() {
		return getOutgoingPropagationConditionAccess().getRule();
	}
	
	//ErrorDetection:
	//	(name=ID ':')? (state=[ErrorBehaviorState] typeTokenConstraint=TypeTokenConstraint? | allStates?='all')
	//	'-[' condition=ConditionExpression? ']->'
	//	detectionReportingPort=ReportingPortReference '!' ('(' errorCode=ErrorCodeValue ')')?
	//	';';
	public ErrorDetectionElements getErrorDetectionAccess() {
		return pErrorDetection;
	}
	
	public ParserRule getErrorDetectionRule() {
		return getErrorDetectionAccess().getRule();
	}
	
	//ReportingPortReference:
	//	element=[aadl2::NamedElement] ({ReportingPortReference.previous=current} '.' element=[aadl2::NamedElement])*;
	public ReportingPortReferenceElements getReportingPortReferenceAccess() {
		return pReportingPortReference;
	}
	
	public ParserRule getReportingPortReferenceRule() {
		return getReportingPortReferenceAccess().getRule();
	}
	
	//ErrorCodeValue:
	//	intValue=INTEGER_LIT | constant=[aadl2::PropertyConstant|QPREF] | enumLiteral=STRING;
	public ErrorCodeValueElements getErrorCodeValueAccess() {
		return pErrorCodeValue;
	}
	
	public ParserRule getErrorCodeValueRule() {
		return getErrorCodeValueAccess().getRule();
	}
	
	//ErrorStateToModeMapping:
	//	errorState=[ErrorBehaviorState] typeToken=TypeToken?
	//	'in' 'modes' '('
	//	mappedModes+=[aadl2::Mode] (',' mappedModes+=[aadl2::Mode])* ')' ';';
	public ErrorStateToModeMappingElements getErrorStateToModeMappingAccess() {
		return pErrorStateToModeMapping;
	}
	
	public ParserRule getErrorStateToModeMappingRule() {
		return getErrorStateToModeMappingAccess().getRule();
	}
	
	//CompositeState:
	//	(name=ID ':')?
	//	'[' (condition=SConditionExpression | others?='others') ']->' state=[ErrorBehaviorState] typedToken=TypeToken? ';';
	public CompositeStateElements getCompositeStateAccess() {
		return pCompositeState;
	}
	
	public ParserRule getCompositeStateRule() {
		return getCompositeStateAccess().getRule();
	}
	
	//// condition expressions for composite states
	//// based on states only  
	//SConditionExpression ConditionExpression:
	//	SAndExpression ({OrExpression.operands+=current} 'or' operands+=SAndExpression)*;
	public SConditionExpressionElements getSConditionExpressionAccess() {
		return pSConditionExpression;
	}
	
	public ParserRule getSConditionExpressionRule() {
		return getSConditionExpressionAccess().getRule();
	}
	
	//SAndExpression ConditionExpression:
	//	SConditionTerm ({AndExpression.operands+=current} 'and' operands+=SConditionTerm)*;
	public SAndExpressionElements getSAndExpressionAccess() {
		return pSAndExpression;
	}
	
	public ParserRule getSAndExpressionRule() {
		return getSAndExpressionAccess().getRule();
	}
	
	//SOrmoreExpression OrmoreExpression:
	//	count=INTVALUE 'ormore' '(' operands+=SConditionExpression (',' operands+=SConditionExpression)* ')';
	public SOrmoreExpressionElements getSOrmoreExpressionAccess() {
		return pSOrmoreExpression;
	}
	
	public ParserRule getSOrmoreExpressionRule() {
		return getSOrmoreExpressionAccess().getRule();
	}
	
	//SOrlessExpression OrlessExpression:
	//	count=INTVALUE 'orless' '(' operands+=SConditionExpression (',' operands+=SConditionExpression)* ')';
	public SOrlessExpressionElements getSOrlessExpressionAccess() {
		return pSOrlessExpression;
	}
	
	public ParserRule getSOrlessExpressionRule() {
		return getSOrlessExpressionAccess().getRule();
	}
	
	//SAllExpression ConditionExpression:
	//	{AllExpression} 'all' ('-' count=INTVALUE)?
	//	'(' operands+=SConditionElement (',' operands+=SConditionElement)* ')';
	public SAllExpressionElements getSAllExpressionAccess() {
		return pSAllExpression;
	}
	
	public ParserRule getSAllExpressionRule() {
		return getSAllExpressionAccess().getRule();
	}
	
	//SConditionTerm ConditionExpression:
	//	SConditionElement
	//	| SOrmoreExpression
	//	| SOrlessExpression
	//	| SAllExpression
	//	| '(' SConditionExpression ')';
	public SConditionTermElements getSConditionTermAccess() {
		return pSConditionTerm;
	}
	
	public ParserRule getSConditionTermRule() {
		return getSConditionTermAccess().getRule();
	}
	
	//QualifiedErrorPropagation EMV2Path:
	//	{QualifiedErrorPropagation} emv2Target=EMV2ErrorPropagationPath;
	public QualifiedErrorPropagationElements getQualifiedErrorPropagationAccess() {
		return pQualifiedErrorPropagation;
	}
	
	public ParserRule getQualifiedErrorPropagationRule() {
		return getQualifiedErrorPropagationAccess().getRule();
	}
	
	//SConditionElement ConditionElement:
	//	{SConditionElement} (qualifiedState=QualifiedErrorBehaviorState constraint=TypeTokenConstraint? |
	//	'in' (qualifiedErrorPropagationReference=QualifiedErrorPropagation constraint=TypeTokenConstraintNoError?));
	public SConditionElementElements getSConditionElementAccess() {
		return pSConditionElement;
	}
	
	public ParserRule getSConditionElementRule() {
		return getSConditionElementAccess().getRule();
	}
	
	//QualifiedErrorBehaviorState:
	//	subcomponent=SubcomponentElement '.' (next=QualifiedErrorBehaviorState | state=[ErrorBehaviorState]);
	public QualifiedErrorBehaviorStateElements getQualifiedErrorBehaviorStateAccess() {
		return pQualifiedErrorBehaviorState;
	}
	
	public ParserRule getQualifiedErrorBehaviorStateRule() {
		return getQualifiedErrorBehaviorStateAccess().getRule();
	}
	
	//SubcomponentElement:
	//	subcomponent=[aadl2::Subcomponent];
	public SubcomponentElementElements getSubcomponentElementAccess() {
		return pSubcomponentElement;
	}
	
	public ParserRule getSubcomponentElementRule() {
		return getSubcomponentElementAccess().getRule();
	}
	
	//@Override
	//terminal SL_COMMENT:
	//	'--' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return tSL_COMMENT;
	}
	
	//@Override
	//terminal INTEGER_LIT:
	//	'0'..'9'+;
	public TerminalRule getINTEGER_LITRule() {
		return tINTEGER_LIT;
	}
	
	//QUALIFIEDNAME:
	//	ID ('.' ID)+;
	public QUALIFIEDNAMEElements getQUALIFIEDNAMEAccess() {
		return pQUALIFIEDNAME;
	}
	
	public ParserRule getQUALIFIEDNAMERule() {
		return getQUALIFIEDNAMEAccess().getRule();
	}
	
	//QEMREF:
	//	ID ('::' ID)*;
	public QEMREFElements getQEMREFAccess() {
		return pQEMREF;
	}
	
	public ParserRule getQEMREFRule() {
		return getQEMREFAccess().getRule();
	}
	
	//PModel aadl2::Element:
	//	ContainedPropertyAssociation //| BasicPropertyAssociation | PropertyAssociation
	//;
	public PropertiesGrammarAccess.PModelElements getPModelAccess() {
		return gaProperties.getPModelAccess();
	}
	
	public ParserRule getPModelRule() {
		return getPModelAccess().getRule();
	}
	
	//// Properties
	//ContainedPropertyAssociation aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF] ('=>' | append?='+=>') constant?='constant'? (ownedValue+=OptionalModalPropertyValue
	//	(',' ownedValue+=OptionalModalPropertyValue)*) (AppliesToKeywords appliesTo+=ContainmentPath (','
	//	appliesTo+=ContainmentPath)*)? (InBindingKeywords '(' inBinding+=[aadl2::Classifier|QCREF] ')')?
	//	';';
	public PropertiesGrammarAccess.ContainedPropertyAssociationElements getContainedPropertyAssociationAccess() {
		return gaProperties.getContainedPropertyAssociationAccess();
	}
	
	public ParserRule getContainedPropertyAssociationRule() {
		return getContainedPropertyAssociationAccess().getRule();
	}
	
	//PropertyAssociation aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF] ('=>' | append?='+=>') constant?='constant'? (ownedValue+=OptionalModalPropertyValue
	//	(',' ownedValue+=OptionalModalPropertyValue)*) (InBindingKeywords '(' inBinding+=[aadl2::Classifier|QCREF] ')')?
	//	';';
	public PropertiesGrammarAccess.PropertyAssociationElements getPropertyAssociationAccess() {
		return gaProperties.getPropertyAssociationAccess();
	}
	
	public ParserRule getPropertyAssociationRule() {
		return getPropertyAssociationAccess().getRule();
	}
	
	//BasicPropertyAssociation aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF]
	//	'=>' ownedValue+=PropertyValue ';';
	public PropertiesGrammarAccess.BasicPropertyAssociationElements getBasicPropertyAssociationAccess() {
		return gaProperties.getBasicPropertyAssociationAccess();
	}
	
	public ParserRule getBasicPropertyAssociationRule() {
		return getBasicPropertyAssociationAccess().getRule();
	}
	
	//ContainmentPath aadl2::ContainedNamedElement:
	//	path=ContainmentPathElement
	//	//	( 'annex' containmentPathElement+=AnnexPath )?
	//;
	public PropertiesGrammarAccess.ContainmentPathElements getContainmentPathAccess() {
		return gaProperties.getContainmentPathAccess();
	}
	
	public ParserRule getContainmentPathRule() {
		return getContainmentPathAccess().getRule();
	}
	
	////AnnexPath returns aadl2::ContainmentPathElement:
	////	 namedElement=[aadl2::NamedElement|IDANNEXTEXT];
	//ModalPropertyValue aadl2::ModalPropertyValue:
	//	ownedValue=PropertyExpression
	//	InModesKeywords '('
	//	inMode+=[aadl2::Mode] (',' inMode+=[aadl2::Mode])*
	//	')';
	public PropertiesGrammarAccess.ModalPropertyValueElements getModalPropertyValueAccess() {
		return gaProperties.getModalPropertyValueAccess();
	}
	
	public ParserRule getModalPropertyValueRule() {
		return getModalPropertyValueAccess().getRule();
	}
	
	//OptionalModalPropertyValue aadl2::ModalPropertyValue:
	//	ownedValue=PropertyExpression (InModesKeywords '('
	//	inMode+=[aadl2::Mode] (',' inMode+=[aadl2::Mode])*
	//	')')?;
	public PropertiesGrammarAccess.OptionalModalPropertyValueElements getOptionalModalPropertyValueAccess() {
		return gaProperties.getOptionalModalPropertyValueAccess();
	}
	
	public ParserRule getOptionalModalPropertyValueRule() {
		return getOptionalModalPropertyValueAccess().getRule();
	}
	
	//// &&&&&&&&&& handling of in binding
	//PropertyValue aadl2::ModalPropertyValue:
	//	ownedValue=PropertyExpression;
	public PropertiesGrammarAccess.PropertyValueElements getPropertyValueAccess() {
		return gaProperties.getPropertyValueAccess();
	}
	
	public ParserRule getPropertyValueRule() {
		return getPropertyValueAccess().getRule();
	}
	
	//PropertyExpression aadl2::PropertyExpression:
	//	RecordTerm | ReferenceTerm | ComponentClassifierTerm
	//	| ComputedTerm | StringTerm | NumericRangeTerm
	//	| RealTerm | IntegerTerm
	//	| ListTerm
	//	| BooleanLiteral | LiteralorReferenceTerm;
	public PropertiesGrammarAccess.PropertyExpressionElements getPropertyExpressionAccess() {
		return gaProperties.getPropertyExpressionAccess();
	}
	
	public ParserRule getPropertyExpressionRule() {
		return getPropertyExpressionAccess().getRule();
	}
	
	//LiteralorReferenceTerm aadl2::NamedValue:
	//	namedValue=[aadl2::AbstractNamedValue|QPREF];
	public PropertiesGrammarAccess.LiteralorReferenceTermElements getLiteralorReferenceTermAccess() {
		return gaProperties.getLiteralorReferenceTermAccess();
	}
	
	public ParserRule getLiteralorReferenceTermRule() {
		return getLiteralorReferenceTermAccess().getRule();
	}
	
	//BooleanLiteral aadl2::BooleanLiteral:
	//	{aadl2::BooleanLiteral} (value?='true' | 'false');
	public PropertiesGrammarAccess.BooleanLiteralElements getBooleanLiteralAccess() {
		return gaProperties.getBooleanLiteralAccess();
	}
	
	public ParserRule getBooleanLiteralRule() {
		return getBooleanLiteralAccess().getRule();
	}
	
	//ConstantValue aadl2::NamedValue:
	//	namedValue=[aadl2::PropertyConstant|QPREF];
	public PropertiesGrammarAccess.ConstantValueElements getConstantValueAccess() {
		return gaProperties.getConstantValueAccess();
	}
	
	public ParserRule getConstantValueRule() {
		return getConstantValueAccess().getRule();
	}
	
	//ReferenceTerm aadl2::ReferenceValue:
	//	'reference' '('
	//	path=ContainmentPathElement
	//	//	( 'annex' ID '{**' 
	//	//	containmentPathElement+=ContainmentPathElement
	//	//	( '.' containmentPathElement+=ContainmentPathElement)*
	//	//	'**}')?
	//	')';
	public PropertiesGrammarAccess.ReferenceTermElements getReferenceTermAccess() {
		return gaProperties.getReferenceTermAccess();
	}
	
	public ParserRule getReferenceTermRule() {
		return getReferenceTermAccess().getRule();
	}
	
	//RecordTerm aadl2::RecordValue:
	//	'['
	//	ownedFieldValue+=FieldPropertyAssociation+
	//	']';
	public PropertiesGrammarAccess.RecordTermElements getRecordTermAccess() {
		return gaProperties.getRecordTermAccess();
	}
	
	public ParserRule getRecordTermRule() {
		return getRecordTermAccess().getRule();
	}
	
	//OldRecordTerm aadl2::RecordValue:
	//	'('
	//	ownedFieldValue+=FieldPropertyAssociation+
	//	')';
	public PropertiesGrammarAccess.OldRecordTermElements getOldRecordTermAccess() {
		return gaProperties.getOldRecordTermAccess();
	}
	
	public ParserRule getOldRecordTermRule() {
		return getOldRecordTermAccess().getRule();
	}
	
	//ComputedTerm aadl2::ComputedValue:
	//	'compute' '('
	//	function=ID
	//	')';
	public PropertiesGrammarAccess.ComputedTermElements getComputedTermAccess() {
		return gaProperties.getComputedTermAccess();
	}
	
	public ParserRule getComputedTermRule() {
		return getComputedTermAccess().getRule();
	}
	
	//ComponentClassifierTerm aadl2::ClassifierValue:
	//	'classifier' '('
	//	classifier=[aadl2::ComponentClassifier|QCREF]
	//	')';
	public PropertiesGrammarAccess.ComponentClassifierTermElements getComponentClassifierTermAccess() {
		return gaProperties.getComponentClassifierTermAccess();
	}
	
	public ParserRule getComponentClassifierTermRule() {
		return getComponentClassifierTermAccess().getRule();
	}
	
	//ListTerm aadl2::ListValue:
	//	{aadl2::ListValue}
	//	'(' (ownedListElement+=PropertyExpression (',' ownedListElement+=PropertyExpression)*)?
	//	')';
	public PropertiesGrammarAccess.ListTermElements getListTermAccess() {
		return gaProperties.getListTermAccess();
	}
	
	public ParserRule getListTermRule() {
		return getListTermAccess().getRule();
	}
	
	//FieldPropertyAssociation aadl2::BasicPropertyAssociation:
	//	property=[aadl2::BasicProperty]
	//	'=>'
	//	ownedValue=PropertyExpression
	//	';';
	public PropertiesGrammarAccess.FieldPropertyAssociationElements getFieldPropertyAssociationAccess() {
		return gaProperties.getFieldPropertyAssociationAccess();
	}
	
	public ParserRule getFieldPropertyAssociationRule() {
		return getFieldPropertyAssociationAccess().getRule();
	}
	
	//// from AADL2
	//// need to add annex path element
	//ContainmentPathElement aadl2::ContainmentPathElement:
	//	(namedElement=[aadl2::NamedElement] arrayRange+=ArrayRange*) ('.' path=ContainmentPathElement)?
	//	//	 | 	 'annex' namedElement=[aadl2::NamedElement|ID]
	//;
	public PropertiesGrammarAccess.ContainmentPathElementElements getContainmentPathElementAccess() {
		return gaProperties.getContainmentPathElementAccess();
	}
	
	public ParserRule getContainmentPathElementRule() {
		return getContainmentPathElementAccess().getRule();
	}
	
	//ANNEXREF: // check what values are ok inside ** **
	//	'{' STAR STAR ID STAR STAR '}';
	public PropertiesGrammarAccess.ANNEXREFElements getANNEXREFAccess() {
		return gaProperties.getANNEXREFAccess();
	}
	
	public ParserRule getANNEXREFRule() {
		return getANNEXREFAccess().getRule();
	}
	
	//PlusMinus aadl2::OperationKind:
	//	'+' | '-';
	public PropertiesGrammarAccess.PlusMinusElements getPlusMinusAccess() {
		return gaProperties.getPlusMinusAccess();
	}
	
	public ParserRule getPlusMinusRule() {
		return getPlusMinusAccess().getRule();
	}
	
	//StringTerm aadl2::StringLiteral:
	//	value=NoQuoteString;
	public PropertiesGrammarAccess.StringTermElements getStringTermAccess() {
		return gaProperties.getStringTermAccess();
	}
	
	public ParserRule getStringTermRule() {
		return getStringTermAccess().getRule();
	}
	
	//NoQuoteString:
	//	STRING;
	public PropertiesGrammarAccess.NoQuoteStringElements getNoQuoteStringAccess() {
		return gaProperties.getNoQuoteStringAccess();
	}
	
	public ParserRule getNoQuoteStringRule() {
		return getNoQuoteStringAccess().getRule();
	}
	
	//ArrayRange aadl2::ArrayRange:
	//	{aadl2::ArrayRange}
	//	'[' lowerBound=INTVALUE ('..' upperBound=INTVALUE)?
	//	']';
	public PropertiesGrammarAccess.ArrayRangeElements getArrayRangeAccess() {
		return gaProperties.getArrayRangeAccess();
	}
	
	public ParserRule getArrayRangeRule() {
		return getArrayRangeAccess().getRule();
	}
	
	//SignedConstant aadl2::Operation:
	//	op=PlusMinus ownedPropertyExpression+=ConstantValue;
	public PropertiesGrammarAccess.SignedConstantElements getSignedConstantAccess() {
		return gaProperties.getSignedConstantAccess();
	}
	
	public ParserRule getSignedConstantRule() {
		return getSignedConstantAccess().getRule();
	}
	
	//IntegerTerm aadl2::IntegerLiteral:
	//	value=SignedInt unit=[aadl2::UnitLiteral]?;
	public PropertiesGrammarAccess.IntegerTermElements getIntegerTermAccess() {
		return gaProperties.getIntegerTermAccess();
	}
	
	public ParserRule getIntegerTermRule() {
		return getIntegerTermAccess().getRule();
	}
	
	//SignedInt aadl2::Integer:
	//	('+' | '-')? super::INTEGER_LIT;
	public PropertiesGrammarAccess.SignedIntElements getSignedIntAccess() {
		return gaProperties.getSignedIntAccess();
	}
	
	public ParserRule getSignedIntRule() {
		return getSignedIntAccess().getRule();
	}
	
	//RealTerm aadl2::RealLiteral:
	//	value=SignedReal unit=[aadl2::UnitLiteral]?;
	public PropertiesGrammarAccess.RealTermElements getRealTermAccess() {
		return gaProperties.getRealTermAccess();
	}
	
	public ParserRule getRealTermRule() {
		return getRealTermAccess().getRule();
	}
	
	//SignedReal aadl2::Real:
	//	('+' | '-')? REAL_LIT;
	public PropertiesGrammarAccess.SignedRealElements getSignedRealAccess() {
		return gaProperties.getSignedRealAccess();
	}
	
	public ParserRule getSignedRealRule() {
		return getSignedRealAccess().getRule();
	}
	
	//NumericRangeTerm aadl2::RangeValue:
	//	minimum=NumAlt //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
	//	'..' maximum=NumAlt ('delta' delta=NumAlt //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//)?;
	public PropertiesGrammarAccess.NumericRangeTermElements getNumericRangeTermAccess() {
		return gaProperties.getNumericRangeTermAccess();
	}
	
	public ParserRule getNumericRangeTermRule() {
		return getNumericRangeTermAccess().getRule();
	}
	
	//NumAlt aadl2::PropertyExpression:
	//	RealTerm | IntegerTerm | SignedConstant | ConstantValue;
	public PropertiesGrammarAccess.NumAltElements getNumAltAccess() {
		return gaProperties.getNumAltAccess();
	}
	
	public ParserRule getNumAltRule() {
		return getNumAltAccess().getRule();
	}
	
	//AppliesToKeywords:
	//	'applies' 'to';
	public PropertiesGrammarAccess.AppliesToKeywordsElements getAppliesToKeywordsAccess() {
		return gaProperties.getAppliesToKeywordsAccess();
	}
	
	public ParserRule getAppliesToKeywordsRule() {
		return getAppliesToKeywordsAccess().getRule();
	}
	
	//InBindingKeywords:
	//	'in' 'binding';
	public PropertiesGrammarAccess.InBindingKeywordsElements getInBindingKeywordsAccess() {
		return gaProperties.getInBindingKeywordsAccess();
	}
	
	public ParserRule getInBindingKeywordsRule() {
		return getInBindingKeywordsAccess().getRule();
	}
	
	//InModesKeywords:
	//	'in' 'modes';
	public PropertiesGrammarAccess.InModesKeywordsElements getInModesKeywordsAccess() {
		return gaProperties.getInModesKeywordsAccess();
	}
	
	public ParserRule getInModesKeywordsRule() {
		return getInModesKeywordsAccess().getRule();
	}
	
	//INTVALUE aadl2::Integer:
	//	super::INTEGER_LIT //NUMERAL 	
	//;
	public PropertiesGrammarAccess.INTVALUEElements getINTVALUEAccess() {
		return gaProperties.getINTVALUEAccess();
	}
	
	public ParserRule getINTVALUERule() {
		return getINTVALUEAccess().getRule();
	}
	
	//terminal fragment EXPONENT:
	//	('e' | 'E') ('+' | '-')? DIGIT+;
	public TerminalRule getEXPONENTRule() {
		return gaProperties.getEXPONENTRule();
	}
	
	//terminal fragment INT_EXPONENT:
	//	('e' | 'E') '+'? DIGIT+;
	public TerminalRule getINT_EXPONENTRule() {
		return gaProperties.getINT_EXPONENTRule();
	}
	
	//terminal REAL_LIT:
	//	DIGIT+ ('_' DIGIT+)* ('.' DIGIT+ ('_' DIGIT+)* EXPONENT?);
	public TerminalRule getREAL_LITRule() {
		return gaProperties.getREAL_LITRule();
	}
	
	//terminal fragment DIGIT:
	//	'0'..'9';
	public TerminalRule getDIGITRule() {
		return gaProperties.getDIGITRule();
	}
	
	//terminal fragment EXTENDED_DIGIT:
	//	'0'..'9' | 'a'..'f' | 'A'..'F';
	public TerminalRule getEXTENDED_DIGITRule() {
		return gaProperties.getEXTENDED_DIGITRule();
	}
	
	//terminal fragment BASED_INTEGER:
	//	EXTENDED_DIGIT ('_'? EXTENDED_DIGIT)*;
	public TerminalRule getBASED_INTEGERRule() {
		return gaProperties.getBASED_INTEGERRule();
	}
	
	//QCLREF:
	//	ID '::' ID;
	public PropertiesGrammarAccess.QCLREFElements getQCLREFAccess() {
		return gaProperties.getQCLREFAccess();
	}
	
	public ParserRule getQCLREFRule() {
		return getQCLREFAccess().getRule();
	}
	
	//QPREF:
	//	ID ('::' ID)?;
	public PropertiesGrammarAccess.QPREFElements getQPREFAccess() {
		return gaProperties.getQPREFAccess();
	}
	
	public ParserRule getQPREFRule() {
		return getQPREFAccess().getRule();
	}
	
	//QCREF:
	//	(ID '::')* ID ('.' ID)?;
	public PropertiesGrammarAccess.QCREFElements getQCREFAccess() {
		return gaProperties.getQCREFAccess();
	}
	
	public ParserRule getQCREFRule() {
		return getQCREFAccess().getRule();
	}
	
	//STAR:
	//	'*';
	public PropertiesGrammarAccess.STARElements getSTARAccess() {
		return gaProperties.getSTARAccess();
	}
	
	public ParserRule getSTARRule() {
		return getSTARAccess().getRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | "'" | '\\') | !('\\' | '"'))* '"' |
	//	"'" ('\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | "'" | '\\') | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaProperties.getSTRINGRule();
	}
	
	//terminal ID:
	//	('a'..'z'
	//	| 'A'..'Z') ('_'? ('a'..'z'
	//	| 'A'..'Z'
	//	| '0'..'9'))*;
	public TerminalRule getIDRule() {
		return gaProperties.getIDRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaProperties.getWSRule();
	}
}
