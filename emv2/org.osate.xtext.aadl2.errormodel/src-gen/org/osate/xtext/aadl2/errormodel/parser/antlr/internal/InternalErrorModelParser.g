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
parser grammar InternalErrorModelParser;

options {
	tokenVocab=InternalErrorModelLexer;
	superClass=AbstractInternalAntlrParser;
}

@header {
package org.osate.xtext.aadl2.errormodel.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess;

}

@members {

 	private ErrorModelGrammarAccess grammarAccess;

    public InternalErrorModelParser(TokenStream input, ErrorModelGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "EMV2Root";
   	}

   	@Override
   	protected ErrorModelGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleEMV2Root
entryRuleEMV2Root returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEMV2RootRule()); }
	iv_ruleEMV2Root=ruleEMV2Root
	{ $current=$iv_ruleEMV2Root.current; }
	EOF;

// Rule EMV2Root
ruleEMV2Root returns [EObject current=null]
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
					grammarAccess.getEMV2RootAccess().getEMV2RootAction_0(),
					$current);
			}
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2RootAccess().getLibraryEMV2LibraryParserRuleCall_1_0_0());
					}
					lv_library_1_0=ruleEMV2Library
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2RootRule());
						}
						set(
							$current,
							"library",
							lv_library_1_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2Library");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2RootAccess().getSubclausesEMV2SubclauseParserRuleCall_1_1_0());
					}
					lv_subclauses_2_0=ruleEMV2Subclause
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2RootRule());
						}
						add(
							$current,
							"subclauses",
							lv_subclauses_2_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2Subclause");
						afterParserOrEnumRuleCall();
					}
				)
			)*
		)
	)
;

// Entry rule entryRuleErrorModelSubclause
entryRuleErrorModelSubclause returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorModelSubclauseRule()); }
	iv_ruleErrorModelSubclause=ruleErrorModelSubclause
	{ $current=$iv_ruleErrorModelSubclause.current; }
	EOF;

// Rule ErrorModelSubclause
ruleErrorModelSubclause returns [EObject current=null]
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
					grammarAccess.getErrorModelSubclauseAccess().getErrorModelSubclauseAction_0(),
					$current);
			}
		)
		(
			otherlv_1=Use
			{
				newLeafNode(otherlv_1, grammarAccess.getErrorModelSubclauseAccess().getUseKeyword_1_0());
			}
			otherlv_2=Types
			{
				newLeafNode(otherlv_2, grammarAccess.getErrorModelSubclauseAccess().getTypesKeyword_1_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorModelSubclauseRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getUseTypesErrorModelLibraryCrossReference_1_2_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=Comma
				{
					newLeafNode(otherlv_4, grammarAccess.getErrorModelSubclauseAccess().getCommaKeyword_1_3_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getErrorModelSubclauseRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getUseTypesErrorModelLibraryCrossReference_1_3_1_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_6=Semicolon
			{
				newLeafNode(otherlv_6, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_1_4());
			}
		)?
		(
			otherlv_7=Use
			{
				newLeafNode(otherlv_7, grammarAccess.getErrorModelSubclauseAccess().getUseKeyword_2_0());
			}
			otherlv_8=Type
			{
				newLeafNode(otherlv_8, grammarAccess.getErrorModelSubclauseAccess().getTypeKeyword_2_1());
			}
			otherlv_9=Equivalence
			{
				newLeafNode(otherlv_9, grammarAccess.getErrorModelSubclauseAccess().getEquivalenceKeyword_2_2());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorModelSubclauseRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getTypeEquivalenceTypeMappingSetCrossReference_2_3_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_11=Semicolon
			{
				newLeafNode(otherlv_11, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_2_4());
			}
		)?
		(
			otherlv_12=Use
			{
				newLeafNode(otherlv_12, grammarAccess.getErrorModelSubclauseAccess().getUseKeyword_3_0());
			}
			otherlv_13=Mappings
			{
				newLeafNode(otherlv_13, grammarAccess.getErrorModelSubclauseAccess().getMappingsKeyword_3_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorModelSubclauseRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getTypeMappingSetTypeMappingSetCrossReference_3_2_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_15=Semicolon
			{
				newLeafNode(otherlv_15, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_3_3());
			}
		)?
		(
			otherlv_16=Use
			{
				newLeafNode(otherlv_16, grammarAccess.getErrorModelSubclauseAccess().getUseKeyword_4_0());
			}
			otherlv_17=Behavior
			{
				newLeafNode(otherlv_17, grammarAccess.getErrorModelSubclauseAccess().getBehaviorKeyword_4_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorModelSubclauseRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getUseBehaviorErrorBehaviorStateMachineCrossReference_4_2_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_19=Semicolon
			{
				newLeafNode(otherlv_19, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_4_3());
			}
		)?
		(
			otherlv_20=Error
			{
				newLeafNode(otherlv_20, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_5_0());
			}
			otherlv_21=Propagations
			{
				newLeafNode(otherlv_21, grammarAccess.getErrorModelSubclauseAccess().getPropagationsKeyword_5_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getPropagationsErrorPropagationParserRuleCall_5_2_0());
					}
					lv_propagations_22_0=ruleErrorPropagation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorModelSubclauseRule());
						}
						add(
							$current,
							"propagations",
							lv_propagations_22_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorPropagation");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			(
				otherlv_23=Flows
				{
					newLeafNode(otherlv_23, grammarAccess.getErrorModelSubclauseAccess().getFlowsKeyword_5_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getFlowsErrorFlowParserRuleCall_5_3_1_0());
						}
						lv_flows_24_0=ruleErrorFlow
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorModelSubclauseRule());
							}
							add(
								$current,
								"flows",
								lv_flows_24_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorFlow");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			otherlv_25=End
			{
				newLeafNode(otherlv_25, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_5_4());
			}
			otherlv_26=Propagations
			{
				newLeafNode(otherlv_26, grammarAccess.getErrorModelSubclauseAccess().getPropagationsKeyword_5_5());
			}
			otherlv_27=Semicolon
			{
				newLeafNode(otherlv_27, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_5_6());
			}
		)?
		(
			otherlv_28=Component
			{
				newLeafNode(otherlv_28, grammarAccess.getErrorModelSubclauseAccess().getComponentKeyword_6_0());
			}
			otherlv_29=Error
			{
				newLeafNode(otherlv_29, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_6_1());
			}
			otherlv_30=Behavior
			{
				newLeafNode(otherlv_30, grammarAccess.getErrorModelSubclauseAccess().getBehaviorKeyword_6_2());
			}
			(
				otherlv_31=Use
				{
					newLeafNode(otherlv_31, grammarAccess.getErrorModelSubclauseAccess().getUseKeyword_6_3_0());
				}
				otherlv_32=Transformations
				{
					newLeafNode(otherlv_32, grammarAccess.getErrorModelSubclauseAccess().getTransformationsKeyword_6_3_1());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getErrorModelSubclauseRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getUseTransformationTypeTransformationSetCrossReference_6_3_2_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_34=Semicolon
				{
					newLeafNode(otherlv_34, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_6_3_3());
				}
			)?
			(
				otherlv_35=Events
				{
					newLeafNode(otherlv_35, grammarAccess.getErrorModelSubclauseAccess().getEventsKeyword_6_4_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getEventsErrorBehaviorEventParserRuleCall_6_4_1_0());
						}
						lv_events_36_0=ruleErrorBehaviorEvent
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorModelSubclauseRule());
							}
							add(
								$current,
								"events",
								lv_events_36_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorEvent");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			(
				otherlv_37=Transitions
				{
					newLeafNode(otherlv_37, grammarAccess.getErrorModelSubclauseAccess().getTransitionsKeyword_6_5_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getTransitionsErrorBehaviorTransitionParserRuleCall_6_5_1_0());
						}
						lv_transitions_38_0=ruleErrorBehaviorTransition
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorModelSubclauseRule());
							}
							add(
								$current,
								"transitions",
								lv_transitions_38_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorTransition");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			(
				otherlv_39=Propagations
				{
					newLeafNode(otherlv_39, grammarAccess.getErrorModelSubclauseAccess().getPropagationsKeyword_6_6_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getOutgoingPropagationConditionsOutgoingPropagationConditionParserRuleCall_6_6_1_0());
						}
						lv_outgoingPropagationConditions_40_0=ruleOutgoingPropagationCondition
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorModelSubclauseRule());
							}
							add(
								$current,
								"outgoingPropagationConditions",
								lv_outgoingPropagationConditions_40_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.OutgoingPropagationCondition");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			(
				otherlv_41=Detections
				{
					newLeafNode(otherlv_41, grammarAccess.getErrorModelSubclauseAccess().getDetectionsKeyword_6_7_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getErrorDetectionsErrorDetectionParserRuleCall_6_7_1_0());
						}
						lv_errorDetections_42_0=ruleErrorDetection
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorModelSubclauseRule());
							}
							add(
								$current,
								"errorDetections",
								lv_errorDetections_42_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorDetection");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			(
				otherlv_43=Mode
				{
					newLeafNode(otherlv_43, grammarAccess.getErrorModelSubclauseAccess().getModeKeyword_6_8_0());
				}
				otherlv_44=Mappings
				{
					newLeafNode(otherlv_44, grammarAccess.getErrorModelSubclauseAccess().getMappingsKeyword_6_8_1());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getErrorStateToModeMappingsErrorStateToModeMappingParserRuleCall_6_8_2_0());
						}
						lv_errorStateToModeMappings_45_0=ruleErrorStateToModeMapping
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorModelSubclauseRule());
							}
							add(
								$current,
								"errorStateToModeMappings",
								lv_errorStateToModeMappings_45_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorStateToModeMapping");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			otherlv_46=End
			{
				newLeafNode(otherlv_46, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_6_9());
			}
			otherlv_47=Component
			{
				newLeafNode(otherlv_47, grammarAccess.getErrorModelSubclauseAccess().getComponentKeyword_6_10());
			}
			otherlv_48=Semicolon
			{
				newLeafNode(otherlv_48, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_6_11());
			}
		)?
		(
			otherlv_49=Composite
			{
				newLeafNode(otherlv_49, grammarAccess.getErrorModelSubclauseAccess().getCompositeKeyword_7_0());
			}
			otherlv_50=Error
			{
				newLeafNode(otherlv_50, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_7_1());
			}
			otherlv_51=Behavior
			{
				newLeafNode(otherlv_51, grammarAccess.getErrorModelSubclauseAccess().getBehaviorKeyword_7_2());
			}
			(
				otherlv_52=States
				{
					newLeafNode(otherlv_52, grammarAccess.getErrorModelSubclauseAccess().getStatesKeyword_7_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getStatesCompositeStateParserRuleCall_7_3_1_0());
						}
						lv_states_53_0=ruleCompositeState
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorModelSubclauseRule());
							}
							add(
								$current,
								"states",
								lv_states_53_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.CompositeState");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			otherlv_54=End
			{
				newLeafNode(otherlv_54, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_7_4());
			}
			otherlv_55=Composite
			{
				newLeafNode(otherlv_55, grammarAccess.getErrorModelSubclauseAccess().getCompositeKeyword_7_5());
			}
			otherlv_56=Semicolon
			{
				newLeafNode(otherlv_56, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_7_6());
			}
		)?
		(
			otherlv_57=Connection
			{
				newLeafNode(otherlv_57, grammarAccess.getErrorModelSubclauseAccess().getConnectionKeyword_8_0());
			}
			otherlv_58=Error
			{
				newLeafNode(otherlv_58, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_8_1());
			}
			(
				otherlv_59=Use
				{
					newLeafNode(otherlv_59, grammarAccess.getErrorModelSubclauseAccess().getUseKeyword_8_2_0());
				}
				otherlv_60=Transformations
				{
					newLeafNode(otherlv_60, grammarAccess.getErrorModelSubclauseAccess().getTransformationsKeyword_8_2_1());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getErrorModelSubclauseRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getTypeTransformationSetTypeTransformationSetCrossReference_8_2_2_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_62=Semicolon
				{
					newLeafNode(otherlv_62, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_8_2_3());
				}
			)?
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getConnectionErrorSourcesErrorSourceParserRuleCall_8_3_0());
					}
					lv_connectionErrorSources_63_0=ruleErrorSource
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorModelSubclauseRule());
						}
						add(
							$current,
							"connectionErrorSources",
							lv_connectionErrorSources_63_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorSource");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_64=End
			{
				newLeafNode(otherlv_64, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_8_4());
			}
			otherlv_65=Connection
			{
				newLeafNode(otherlv_65, grammarAccess.getErrorModelSubclauseAccess().getConnectionKeyword_8_5());
			}
			otherlv_66=Semicolon
			{
				newLeafNode(otherlv_66, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_8_6());
			}
		)?
		(
			otherlv_67=Propagation
			{
				newLeafNode(otherlv_67, grammarAccess.getErrorModelSubclauseAccess().getPropagationKeyword_9_0());
			}
			otherlv_68=Paths
			{
				newLeafNode(otherlv_68, grammarAccess.getErrorModelSubclauseAccess().getPathsKeyword_9_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getPointsPropagationPointParserRuleCall_9_2_0());
					}
					lv_points_69_0=rulePropagationPoint
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorModelSubclauseRule());
						}
						add(
							$current,
							"points",
							lv_points_69_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.PropagationPoint");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getPathsPropagationPathParserRuleCall_9_3_0());
					}
					lv_paths_70_0=rulePropagationPath
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorModelSubclauseRule());
						}
						add(
							$current,
							"paths",
							lv_paths_70_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.PropagationPath");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_71=End
			{
				newLeafNode(otherlv_71, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_9_4());
			}
			otherlv_72=Paths
			{
				newLeafNode(otherlv_72, grammarAccess.getErrorModelSubclauseAccess().getPathsKeyword_9_5());
			}
			otherlv_73=Semicolon
			{
				newLeafNode(otherlv_73, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_9_6());
			}
		)?
		(
			otherlv_74=Properties
			{
				newLeafNode(otherlv_74, grammarAccess.getErrorModelSubclauseAccess().getPropertiesKeyword_10_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorModelSubclauseAccess().getPropertiesEMV2PropertyAssociationParserRuleCall_10_1_0());
					}
					lv_properties_75_0=ruleEMV2PropertyAssociation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorModelSubclauseRule());
						}
						add(
							$current,
							"properties",
							lv_properties_75_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2PropertyAssociation");
						afterParserOrEnumRuleCall();
					}
				)
			)+
		)?
	)
;

// Entry rule entryRuleEMV2Subclause
entryRuleEMV2Subclause returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEMV2SubclauseRule()); }
	iv_ruleEMV2Subclause=ruleEMV2Subclause
	{ $current=$iv_ruleEMV2Subclause.current; }
	EOF;

// Rule EMV2Subclause
ruleEMV2Subclause returns [EObject current=null]
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
					grammarAccess.getEMV2SubclauseAccess().getErrorModelSubclauseAction_0(),
					$current);
			}
		)
		otherlv_1=Subclause
		{
			newLeafNode(otherlv_1, grammarAccess.getEMV2SubclauseAccess().getSubclauseKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getNameQCREFParserRuleCall_2_0());
				}
				lv_name_2_0=ruleQCREF
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEMV2SubclauseRule());
					}
					set(
						$current,
						"name",
						lv_name_2_0,
						"org.osate.xtext.aadl2.properties.Properties.QCREF");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_3=Use
			{
				newLeafNode(otherlv_3, grammarAccess.getEMV2SubclauseAccess().getUseKeyword_3_0());
			}
			otherlv_4=Types
			{
				newLeafNode(otherlv_4, grammarAccess.getEMV2SubclauseAccess().getTypesKeyword_3_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEMV2SubclauseRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getUseTypesErrorModelLibraryCrossReference_3_2_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_6=Comma
				{
					newLeafNode(otherlv_6, grammarAccess.getEMV2SubclauseAccess().getCommaKeyword_3_3_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getEMV2SubclauseRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getUseTypesErrorModelLibraryCrossReference_3_3_1_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_8=Semicolon
			{
				newLeafNode(otherlv_8, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_3_4());
			}
		)?
		(
			otherlv_9=Use
			{
				newLeafNode(otherlv_9, grammarAccess.getEMV2SubclauseAccess().getUseKeyword_4_0());
			}
			otherlv_10=Type
			{
				newLeafNode(otherlv_10, grammarAccess.getEMV2SubclauseAccess().getTypeKeyword_4_1());
			}
			otherlv_11=Equivalence
			{
				newLeafNode(otherlv_11, grammarAccess.getEMV2SubclauseAccess().getEquivalenceKeyword_4_2());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEMV2SubclauseRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getTypeEquivalenceTypeMappingSetCrossReference_4_3_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_13=Semicolon
			{
				newLeafNode(otherlv_13, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_4_4());
			}
		)?
		(
			otherlv_14=Use
			{
				newLeafNode(otherlv_14, grammarAccess.getEMV2SubclauseAccess().getUseKeyword_5_0());
			}
			otherlv_15=Mappings
			{
				newLeafNode(otherlv_15, grammarAccess.getEMV2SubclauseAccess().getMappingsKeyword_5_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEMV2SubclauseRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getTypeMappingSetTypeMappingSetCrossReference_5_2_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_17=Semicolon
			{
				newLeafNode(otherlv_17, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_5_3());
			}
		)?
		(
			otherlv_18=Use
			{
				newLeafNode(otherlv_18, grammarAccess.getEMV2SubclauseAccess().getUseKeyword_6_0());
			}
			otherlv_19=Behavior
			{
				newLeafNode(otherlv_19, grammarAccess.getEMV2SubclauseAccess().getBehaviorKeyword_6_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEMV2SubclauseRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getUseBehaviorErrorBehaviorStateMachineCrossReference_6_2_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_21=Semicolon
			{
				newLeafNode(otherlv_21, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_6_3());
			}
		)?
		(
			otherlv_22=Error
			{
				newLeafNode(otherlv_22, grammarAccess.getEMV2SubclauseAccess().getErrorKeyword_7_0());
			}
			otherlv_23=Propagations
			{
				newLeafNode(otherlv_23, grammarAccess.getEMV2SubclauseAccess().getPropagationsKeyword_7_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getPropagationsErrorPropagationParserRuleCall_7_2_0());
					}
					lv_propagations_24_0=ruleErrorPropagation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2SubclauseRule());
						}
						add(
							$current,
							"propagations",
							lv_propagations_24_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorPropagation");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			(
				otherlv_25=Flows
				{
					newLeafNode(otherlv_25, grammarAccess.getEMV2SubclauseAccess().getFlowsKeyword_7_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getFlowsErrorFlowParserRuleCall_7_3_1_0());
						}
						lv_flows_26_0=ruleErrorFlow
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2SubclauseRule());
							}
							add(
								$current,
								"flows",
								lv_flows_26_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorFlow");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			otherlv_27=End
			{
				newLeafNode(otherlv_27, grammarAccess.getEMV2SubclauseAccess().getEndKeyword_7_4());
			}
			otherlv_28=Propagations
			{
				newLeafNode(otherlv_28, grammarAccess.getEMV2SubclauseAccess().getPropagationsKeyword_7_5());
			}
			otherlv_29=Semicolon
			{
				newLeafNode(otherlv_29, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_7_6());
			}
		)?
		(
			otherlv_30=Component
			{
				newLeafNode(otherlv_30, grammarAccess.getEMV2SubclauseAccess().getComponentKeyword_8_0());
			}
			otherlv_31=Error
			{
				newLeafNode(otherlv_31, grammarAccess.getEMV2SubclauseAccess().getErrorKeyword_8_1());
			}
			otherlv_32=Behavior
			{
				newLeafNode(otherlv_32, grammarAccess.getEMV2SubclauseAccess().getBehaviorKeyword_8_2());
			}
			(
				otherlv_33=Use
				{
					newLeafNode(otherlv_33, grammarAccess.getEMV2SubclauseAccess().getUseKeyword_8_3_0());
				}
				otherlv_34=Transformations
				{
					newLeafNode(otherlv_34, grammarAccess.getEMV2SubclauseAccess().getTransformationsKeyword_8_3_1());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getEMV2SubclauseRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getUseTransformationTypeTransformationSetCrossReference_8_3_2_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_36=Semicolon
				{
					newLeafNode(otherlv_36, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_8_3_3());
				}
			)?
			(
				otherlv_37=Events
				{
					newLeafNode(otherlv_37, grammarAccess.getEMV2SubclauseAccess().getEventsKeyword_8_4_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getEventsErrorBehaviorEventParserRuleCall_8_4_1_0());
						}
						lv_events_38_0=ruleErrorBehaviorEvent
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2SubclauseRule());
							}
							add(
								$current,
								"events",
								lv_events_38_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorEvent");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			(
				otherlv_39=Transitions
				{
					newLeafNode(otherlv_39, grammarAccess.getEMV2SubclauseAccess().getTransitionsKeyword_8_5_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getTransitionsErrorBehaviorTransitionParserRuleCall_8_5_1_0());
						}
						lv_transitions_40_0=ruleErrorBehaviorTransition
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2SubclauseRule());
							}
							add(
								$current,
								"transitions",
								lv_transitions_40_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorTransition");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			(
				otherlv_41=Propagations
				{
					newLeafNode(otherlv_41, grammarAccess.getEMV2SubclauseAccess().getPropagationsKeyword_8_6_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getOutgoingPropagationConditionsOutgoingPropagationConditionParserRuleCall_8_6_1_0());
						}
						lv_outgoingPropagationConditions_42_0=ruleOutgoingPropagationCondition
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2SubclauseRule());
							}
							add(
								$current,
								"outgoingPropagationConditions",
								lv_outgoingPropagationConditions_42_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.OutgoingPropagationCondition");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			(
				otherlv_43=Detections
				{
					newLeafNode(otherlv_43, grammarAccess.getEMV2SubclauseAccess().getDetectionsKeyword_8_7_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getErrorDetectionsErrorDetectionParserRuleCall_8_7_1_0());
						}
						lv_errorDetections_44_0=ruleErrorDetection
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2SubclauseRule());
							}
							add(
								$current,
								"errorDetections",
								lv_errorDetections_44_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorDetection");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			(
				otherlv_45=Mode
				{
					newLeafNode(otherlv_45, grammarAccess.getEMV2SubclauseAccess().getModeKeyword_8_8_0());
				}
				otherlv_46=Mappings
				{
					newLeafNode(otherlv_46, grammarAccess.getEMV2SubclauseAccess().getMappingsKeyword_8_8_1());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getErrorStateToModeMappingsErrorStateToModeMappingParserRuleCall_8_8_2_0());
						}
						lv_errorStateToModeMappings_47_0=ruleErrorStateToModeMapping
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2SubclauseRule());
							}
							add(
								$current,
								"errorStateToModeMappings",
								lv_errorStateToModeMappings_47_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorStateToModeMapping");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			otherlv_48=End
			{
				newLeafNode(otherlv_48, grammarAccess.getEMV2SubclauseAccess().getEndKeyword_8_9());
			}
			otherlv_49=Component
			{
				newLeafNode(otherlv_49, grammarAccess.getEMV2SubclauseAccess().getComponentKeyword_8_10());
			}
			otherlv_50=Semicolon
			{
				newLeafNode(otherlv_50, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_8_11());
			}
		)?
		(
			otherlv_51=Composite
			{
				newLeafNode(otherlv_51, grammarAccess.getEMV2SubclauseAccess().getCompositeKeyword_9_0());
			}
			otherlv_52=Error
			{
				newLeafNode(otherlv_52, grammarAccess.getEMV2SubclauseAccess().getErrorKeyword_9_1());
			}
			otherlv_53=Behavior
			{
				newLeafNode(otherlv_53, grammarAccess.getEMV2SubclauseAccess().getBehaviorKeyword_9_2());
			}
			(
				otherlv_54=States
				{
					newLeafNode(otherlv_54, grammarAccess.getEMV2SubclauseAccess().getStatesKeyword_9_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getStatesCompositeStateParserRuleCall_9_3_1_0());
						}
						lv_states_55_0=ruleCompositeState
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2SubclauseRule());
							}
							add(
								$current,
								"states",
								lv_states_55_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.CompositeState");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			otherlv_56=End
			{
				newLeafNode(otherlv_56, grammarAccess.getEMV2SubclauseAccess().getEndKeyword_9_4());
			}
			otherlv_57=Composite
			{
				newLeafNode(otherlv_57, grammarAccess.getEMV2SubclauseAccess().getCompositeKeyword_9_5());
			}
			otherlv_58=Semicolon
			{
				newLeafNode(otherlv_58, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_9_6());
			}
		)?
		(
			otherlv_59=Connection
			{
				newLeafNode(otherlv_59, grammarAccess.getEMV2SubclauseAccess().getConnectionKeyword_10_0());
			}
			otherlv_60=Error
			{
				newLeafNode(otherlv_60, grammarAccess.getEMV2SubclauseAccess().getErrorKeyword_10_1());
			}
			(
				otherlv_61=Use
				{
					newLeafNode(otherlv_61, grammarAccess.getEMV2SubclauseAccess().getUseKeyword_10_2_0());
				}
				otherlv_62=Transformations
				{
					newLeafNode(otherlv_62, grammarAccess.getEMV2SubclauseAccess().getTransformationsKeyword_10_2_1());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getEMV2SubclauseRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getTypeTransformationSetTypeTransformationSetCrossReference_10_2_2_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_64=Semicolon
				{
					newLeafNode(otherlv_64, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_10_2_3());
				}
			)?
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getConnectionErrorSourcesErrorSourceParserRuleCall_10_3_0());
					}
					lv_connectionErrorSources_65_0=ruleErrorSource
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2SubclauseRule());
						}
						add(
							$current,
							"connectionErrorSources",
							lv_connectionErrorSources_65_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorSource");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_66=End
			{
				newLeafNode(otherlv_66, grammarAccess.getEMV2SubclauseAccess().getEndKeyword_10_4());
			}
			otherlv_67=Connection
			{
				newLeafNode(otherlv_67, grammarAccess.getEMV2SubclauseAccess().getConnectionKeyword_10_5());
			}
			otherlv_68=Semicolon
			{
				newLeafNode(otherlv_68, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_10_6());
			}
		)?
		(
			otherlv_69=Propagation
			{
				newLeafNode(otherlv_69, grammarAccess.getEMV2SubclauseAccess().getPropagationKeyword_11_0());
			}
			otherlv_70=Paths
			{
				newLeafNode(otherlv_70, grammarAccess.getEMV2SubclauseAccess().getPathsKeyword_11_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getPointsPropagationPointParserRuleCall_11_2_0());
					}
					lv_points_71_0=rulePropagationPoint
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2SubclauseRule());
						}
						add(
							$current,
							"points",
							lv_points_71_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.PropagationPoint");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getPathsPropagationPathParserRuleCall_11_3_0());
					}
					lv_paths_72_0=rulePropagationPath
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2SubclauseRule());
						}
						add(
							$current,
							"paths",
							lv_paths_72_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.PropagationPath");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_73=End
			{
				newLeafNode(otherlv_73, grammarAccess.getEMV2SubclauseAccess().getEndKeyword_11_4());
			}
			otherlv_74=Paths
			{
				newLeafNode(otherlv_74, grammarAccess.getEMV2SubclauseAccess().getPathsKeyword_11_5());
			}
			otherlv_75=Semicolon
			{
				newLeafNode(otherlv_75, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_11_6());
			}
		)?
		(
			otherlv_76=Properties
			{
				newLeafNode(otherlv_76, grammarAccess.getEMV2SubclauseAccess().getPropertiesKeyword_12_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2SubclauseAccess().getPropertiesEMV2PropertyAssociationParserRuleCall_12_1_0());
					}
					lv_properties_77_0=ruleEMV2PropertyAssociation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2SubclauseRule());
						}
						add(
							$current,
							"properties",
							lv_properties_77_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2PropertyAssociation");
						afterParserOrEnumRuleCall();
					}
				)
			)+
		)?
		otherlv_78=End
		{
			newLeafNode(otherlv_78, grammarAccess.getEMV2SubclauseAccess().getEndKeyword_13());
		}
		otherlv_79=Subclause
		{
			newLeafNode(otherlv_79, grammarAccess.getEMV2SubclauseAccess().getSubclauseKeyword_14());
		}
		otherlv_80=Semicolon
		{
			newLeafNode(otherlv_80, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_15());
		}
	)
;

// Entry rule entryRuleErrorModelLibrary
entryRuleErrorModelLibrary returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorModelLibraryRule()); }
	iv_ruleErrorModelLibrary=ruleErrorModelLibrary
	{ $current=$iv_ruleErrorModelLibrary.current; }
	EOF;

// Rule ErrorModelLibrary
ruleErrorModelLibrary returns [EObject current=null]
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
					grammarAccess.getErrorModelLibraryAccess().getErrorModelLibraryAction_0(),
					$current);
			}
		)
		(
			otherlv_1=Error
			{
				newLeafNode(otherlv_1, grammarAccess.getErrorModelLibraryAccess().getErrorKeyword_1_0());
			}
			otherlv_2=Types
			{
				newLeafNode(otherlv_2, grammarAccess.getErrorModelLibraryAccess().getTypesKeyword_1_1());
			}
			(
				otherlv_3=Use
				{
					newLeafNode(otherlv_3, grammarAccess.getErrorModelLibraryAccess().getUseKeyword_1_2_0());
				}
				otherlv_4=Types
				{
					newLeafNode(otherlv_4, grammarAccess.getErrorModelLibraryAccess().getTypesKeyword_1_2_1());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getErrorModelLibraryRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getErrorModelLibraryAccess().getUseTypesErrorModelLibraryCrossReference_1_2_2_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_6=Comma
					{
						newLeafNode(otherlv_6, grammarAccess.getErrorModelLibraryAccess().getCommaKeyword_1_2_3_0());
					}
					(
						(
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getErrorModelLibraryRule());
								}
							}
							{
								newCompositeNode(grammarAccess.getErrorModelLibraryAccess().getUseTypesErrorModelLibraryCrossReference_1_2_3_1_0());
							}
							ruleQEMREF
							{
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				otherlv_8=Semicolon
				{
					newLeafNode(otherlv_8, grammarAccess.getErrorModelLibraryAccess().getSemicolonKeyword_1_2_4());
				}
			)?
			(
				otherlv_9=Extends
				{
					newLeafNode(otherlv_9, grammarAccess.getErrorModelLibraryAccess().getExtendsKeyword_1_3_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getErrorModelLibraryRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getErrorModelLibraryAccess().getExtendsErrorModelLibraryCrossReference_1_3_1_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_11=Comma
					{
						newLeafNode(otherlv_11, grammarAccess.getErrorModelLibraryAccess().getCommaKeyword_1_3_2_0());
					}
					(
						(
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getErrorModelLibraryRule());
								}
							}
							{
								newCompositeNode(grammarAccess.getErrorModelLibraryAccess().getExtendsErrorModelLibraryCrossReference_1_3_2_1_0());
							}
							ruleQEMREF
							{
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				otherlv_13=With
				{
					newLeafNode(otherlv_13, grammarAccess.getErrorModelLibraryAccess().getWithKeyword_1_3_3());
				}
			)?
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorModelLibraryAccess().getTypesTypeDefinitionParserRuleCall_1_4_0_0());
						}
						lv_types_14_0=ruleTypeDefinition
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorModelLibraryRule());
							}
							add(
								$current,
								"types",
								lv_types_14_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeDefinition");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorModelLibraryAccess().getTypesetsTypeSetDefinitionParserRuleCall_1_4_1_0());
						}
						lv_typesets_15_0=ruleTypeSetDefinition
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorModelLibraryRule());
							}
							add(
								$current,
								"typesets",
								lv_typesets_15_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetDefinition");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			(
				otherlv_16=Properties
				{
					newLeafNode(otherlv_16, grammarAccess.getErrorModelLibraryAccess().getPropertiesKeyword_1_5_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorModelLibraryAccess().getPropertiesBasicEMV2PropertyAssociationParserRuleCall_1_5_1_0());
						}
						lv_properties_17_0=ruleBasicEMV2PropertyAssociation
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorModelLibraryRule());
							}
							add(
								$current,
								"properties",
								lv_properties_17_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.BasicEMV2PropertyAssociation");
							afterParserOrEnumRuleCall();
						}
					)
				)+
			)?
			otherlv_18=End
			{
				newLeafNode(otherlv_18, grammarAccess.getErrorModelLibraryAccess().getEndKeyword_1_6());
			}
			otherlv_19=Types
			{
				newLeafNode(otherlv_19, grammarAccess.getErrorModelLibraryAccess().getTypesKeyword_1_7());
			}
			otherlv_20=Semicolon
			{
				newLeafNode(otherlv_20, grammarAccess.getErrorModelLibraryAccess().getSemicolonKeyword_1_8());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorModelLibraryAccess().getBehaviorsErrorBehaviorStateMachineParserRuleCall_2_0());
				}
				lv_behaviors_21_0=ruleErrorBehaviorStateMachine
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorModelLibraryRule());
					}
					add(
						$current,
						"behaviors",
						lv_behaviors_21_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorStateMachine");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorModelLibraryAccess().getMappingsTypeMappingSetParserRuleCall_3_0());
				}
				lv_mappings_22_0=ruleTypeMappingSet
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorModelLibraryRule());
					}
					add(
						$current,
						"mappings",
						lv_mappings_22_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeMappingSet");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorModelLibraryAccess().getTransformationsTypeTransformationSetParserRuleCall_4_0());
				}
				lv_transformations_23_0=ruleTypeTransformationSet
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorModelLibraryRule());
					}
					add(
						$current,
						"transformations",
						lv_transformations_23_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTransformationSet");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleEMV2Library
entryRuleEMV2Library returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEMV2LibraryRule()); }
	iv_ruleEMV2Library=ruleEMV2Library
	{ $current=$iv_ruleEMV2Library.current; }
	EOF;

// Rule EMV2Library
ruleEMV2Library returns [EObject current=null]
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
					$current = forceCreateModelElement(
						grammarAccess.getEMV2LibraryAccess().getErrorModelLibraryAction_0_0(),
						$current);
				}
			)
			(
				otherlv_1=Library
				{
					newLeafNode(otherlv_1, grammarAccess.getEMV2LibraryAccess().getLibraryKeyword_0_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2LibraryAccess().getNameQEMREFParserRuleCall_0_1_1_0());
						}
						lv_name_2_0=ruleQEMREF
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
							}
							set(
								$current,
								"name",
								lv_name_2_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.QEMREF");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_3=Error
					{
						newLeafNode(otherlv_3, grammarAccess.getEMV2LibraryAccess().getErrorKeyword_0_1_2_0());
					}
					otherlv_4=Types
					{
						newLeafNode(otherlv_4, grammarAccess.getEMV2LibraryAccess().getTypesKeyword_0_1_2_1());
					}
					(
						otherlv_5=Use
						{
							newLeafNode(otherlv_5, grammarAccess.getEMV2LibraryAccess().getUseKeyword_0_1_2_2_0());
						}
						otherlv_6=Types
						{
							newLeafNode(otherlv_6, grammarAccess.getEMV2LibraryAccess().getTypesKeyword_0_1_2_2_1());
						}
						(
							(
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getEMV2LibraryRule());
									}
								}
								{
									newCompositeNode(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryCrossReference_0_1_2_2_2_0());
								}
								ruleQEMREF
								{
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							otherlv_8=Comma
							{
								newLeafNode(otherlv_8, grammarAccess.getEMV2LibraryAccess().getCommaKeyword_0_1_2_2_3_0());
							}
							(
								(
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getEMV2LibraryRule());
										}
									}
									{
										newCompositeNode(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryCrossReference_0_1_2_2_3_1_0());
									}
									ruleQEMREF
									{
										afterParserOrEnumRuleCall();
									}
								)
							)
						)*
						otherlv_10=Semicolon
						{
							newLeafNode(otherlv_10, grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_0_1_2_2_4());
						}
					)?
					(
						otherlv_11=Extends
						{
							newLeafNode(otherlv_11, grammarAccess.getEMV2LibraryAccess().getExtendsKeyword_0_1_2_3_0());
						}
						(
							(
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getEMV2LibraryRule());
									}
								}
								{
									newCompositeNode(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryCrossReference_0_1_2_3_1_0());
								}
								ruleQEMREF
								{
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							otherlv_13=Comma
							{
								newLeafNode(otherlv_13, grammarAccess.getEMV2LibraryAccess().getCommaKeyword_0_1_2_3_2_0());
							}
							(
								(
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getEMV2LibraryRule());
										}
									}
									{
										newCompositeNode(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryCrossReference_0_1_2_3_2_1_0());
									}
									ruleQEMREF
									{
										afterParserOrEnumRuleCall();
									}
								)
							)
						)*
						otherlv_15=With
						{
							newLeafNode(otherlv_15, grammarAccess.getEMV2LibraryAccess().getWithKeyword_0_1_2_3_3());
						}
					)?
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getEMV2LibraryAccess().getTypesTypeDefinitionParserRuleCall_0_1_2_4_0_0());
								}
								lv_types_16_0=ruleTypeDefinition
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
									}
									add(
										$current,
										"types",
										lv_types_16_0,
										"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeDefinition");
									afterParserOrEnumRuleCall();
								}
							)
						)
						    |
						(
							(
								{
									newCompositeNode(grammarAccess.getEMV2LibraryAccess().getTypesetsTypeSetDefinitionParserRuleCall_0_1_2_4_1_0());
								}
								lv_typesets_17_0=ruleTypeSetDefinition
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
									}
									add(
										$current,
										"typesets",
										lv_typesets_17_0,
										"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetDefinition");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					(
						otherlv_18=Properties
						{
							newLeafNode(otherlv_18, grammarAccess.getEMV2LibraryAccess().getPropertiesKeyword_0_1_2_5_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getEMV2LibraryAccess().getPropertiesBasicEMV2PropertyAssociationParserRuleCall_0_1_2_5_1_0());
								}
								lv_properties_19_0=ruleBasicEMV2PropertyAssociation
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
									}
									add(
										$current,
										"properties",
										lv_properties_19_0,
										"org.osate.xtext.aadl2.errormodel.ErrorModel.BasicEMV2PropertyAssociation");
									afterParserOrEnumRuleCall();
								}
							)
						)+
					)?
					otherlv_20=End
					{
						newLeafNode(otherlv_20, grammarAccess.getEMV2LibraryAccess().getEndKeyword_0_1_2_6());
					}
					otherlv_21=Types
					{
						newLeafNode(otherlv_21, grammarAccess.getEMV2LibraryAccess().getTypesKeyword_0_1_2_7());
					}
					otherlv_22=Semicolon
					{
						newLeafNode(otherlv_22, grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_0_1_2_8());
					}
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2LibraryAccess().getBehaviorsErrorBehaviorStateMachineParserRuleCall_0_1_3_0());
						}
						lv_behaviors_23_0=ruleErrorBehaviorStateMachine
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
							}
							add(
								$current,
								"behaviors",
								lv_behaviors_23_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorStateMachine");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2LibraryAccess().getMappingsTypeMappingSetParserRuleCall_0_1_4_0());
						}
						lv_mappings_24_0=ruleTypeMappingSet
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
							}
							add(
								$current,
								"mappings",
								lv_mappings_24_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeMappingSet");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2LibraryAccess().getTransformationsTypeTransformationSetParserRuleCall_0_1_5_0());
						}
						lv_transformations_25_0=ruleTypeTransformationSet
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
							}
							add(
								$current,
								"transformations",
								lv_transformations_25_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTransformationSet");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
		)
		    |
		(
			otherlv_26=Package
			{
				newLeafNode(otherlv_26, grammarAccess.getEMV2LibraryAccess().getPackageKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2LibraryAccess().getNameQEMREFParserRuleCall_1_1_0());
					}
					lv_name_27_0=ruleQEMREF
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
						}
						set(
							$current,
							"name",
							lv_name_27_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.QEMREF");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_28=Public
			{
				newLeafNode(otherlv_28, grammarAccess.getEMV2LibraryAccess().getPublicKeyword_1_2());
			}
			otherlv_29=Annex
			{
				newLeafNode(otherlv_29, grammarAccess.getEMV2LibraryAccess().getAnnexKeyword_1_3());
			}
			this_ID_30=RULE_ID
			{
				newLeafNode(this_ID_30, grammarAccess.getEMV2LibraryAccess().getIDTerminalRuleCall_1_4());
			}
			otherlv_31=LeftCurlyBracketAsteriskAsterisk
			{
				newLeafNode(otherlv_31, grammarAccess.getEMV2LibraryAccess().getLeftCurlyBracketAsteriskAsteriskKeyword_1_5());
			}
			(
				otherlv_32=Error
				{
					newLeafNode(otherlv_32, grammarAccess.getEMV2LibraryAccess().getErrorKeyword_1_6_0());
				}
				otherlv_33=Types
				{
					newLeafNode(otherlv_33, grammarAccess.getEMV2LibraryAccess().getTypesKeyword_1_6_1());
				}
				(
					otherlv_34=Use
					{
						newLeafNode(otherlv_34, grammarAccess.getEMV2LibraryAccess().getUseKeyword_1_6_2_0());
					}
					otherlv_35=Types
					{
						newLeafNode(otherlv_35, grammarAccess.getEMV2LibraryAccess().getTypesKeyword_1_6_2_1());
					}
					(
						(
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getEMV2LibraryRule());
								}
							}
							{
								newCompositeNode(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryCrossReference_1_6_2_2_0());
							}
							ruleQEMREF
							{
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_37=Comma
						{
							newLeafNode(otherlv_37, grammarAccess.getEMV2LibraryAccess().getCommaKeyword_1_6_2_3_0());
						}
						(
							(
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getEMV2LibraryRule());
									}
								}
								{
									newCompositeNode(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryCrossReference_1_6_2_3_1_0());
								}
								ruleQEMREF
								{
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_39=Semicolon
					{
						newLeafNode(otherlv_39, grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_6_2_4());
					}
				)?
				(
					otherlv_40=Extends
					{
						newLeafNode(otherlv_40, grammarAccess.getEMV2LibraryAccess().getExtendsKeyword_1_6_3_0());
					}
					(
						(
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getEMV2LibraryRule());
								}
							}
							{
								newCompositeNode(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryCrossReference_1_6_3_1_0());
							}
							ruleQEMREF
							{
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_42=Comma
						{
							newLeafNode(otherlv_42, grammarAccess.getEMV2LibraryAccess().getCommaKeyword_1_6_3_2_0());
						}
						(
							(
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getEMV2LibraryRule());
									}
								}
								{
									newCompositeNode(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryCrossReference_1_6_3_2_1_0());
								}
								ruleQEMREF
								{
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_44=With
					{
						newLeafNode(otherlv_44, grammarAccess.getEMV2LibraryAccess().getWithKeyword_1_6_3_3());
					}
				)?
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getEMV2LibraryAccess().getTypesTypeDefinitionParserRuleCall_1_6_4_0_0());
							}
							lv_types_45_0=ruleTypeDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
								}
								add(
									$current,
									"types",
									lv_types_45_0,
									"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getEMV2LibraryAccess().getTypesetsTypeSetDefinitionParserRuleCall_1_6_4_1_0());
							}
							lv_typesets_46_0=ruleTypeSetDefinition
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
								}
								add(
									$current,
									"typesets",
									lv_typesets_46_0,
									"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetDefinition");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				(
					otherlv_47=Properties
					{
						newLeafNode(otherlv_47, grammarAccess.getEMV2LibraryAccess().getPropertiesKeyword_1_6_5_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getEMV2LibraryAccess().getPropertiesBasicEMV2PropertyAssociationParserRuleCall_1_6_5_1_0());
							}
							lv_properties_48_0=ruleBasicEMV2PropertyAssociation
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
								}
								add(
									$current,
									"properties",
									lv_properties_48_0,
									"org.osate.xtext.aadl2.errormodel.ErrorModel.BasicEMV2PropertyAssociation");
								afterParserOrEnumRuleCall();
							}
						)
					)+
				)?
				otherlv_49=End
				{
					newLeafNode(otherlv_49, grammarAccess.getEMV2LibraryAccess().getEndKeyword_1_6_6());
				}
				otherlv_50=Types
				{
					newLeafNode(otherlv_50, grammarAccess.getEMV2LibraryAccess().getTypesKeyword_1_6_7());
				}
				otherlv_51=Semicolon
				{
					newLeafNode(otherlv_51, grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_6_8());
				}
			)?
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2LibraryAccess().getBehaviorsErrorBehaviorStateMachineParserRuleCall_1_7_0());
					}
					lv_behaviors_52_0=ruleErrorBehaviorStateMachine
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
						}
						add(
							$current,
							"behaviors",
							lv_behaviors_52_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorStateMachine");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2LibraryAccess().getMappingsTypeMappingSetParserRuleCall_1_8_0());
					}
					lv_mappings_53_0=ruleTypeMappingSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
						}
						add(
							$current,
							"mappings",
							lv_mappings_53_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeMappingSet");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2LibraryAccess().getTransformationsTypeTransformationSetParserRuleCall_1_9_0());
					}
					lv_transformations_54_0=ruleTypeTransformationSet
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2LibraryRule());
						}
						add(
							$current,
							"transformations",
							lv_transformations_54_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTransformationSet");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_55=AsteriskAsteriskRightCurlyBracket
			{
				newLeafNode(otherlv_55, grammarAccess.getEMV2LibraryAccess().getAsteriskAsteriskRightCurlyBracketKeyword_1_10());
			}
			otherlv_56=Semicolon
			{
				newLeafNode(otherlv_56, grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_11());
			}
			otherlv_57=End
			{
				newLeafNode(otherlv_57, grammarAccess.getEMV2LibraryAccess().getEndKeyword_1_12());
			}
			{
				newCompositeNode(grammarAccess.getEMV2LibraryAccess().getQEMREFParserRuleCall_1_13());
			}
			ruleQEMREF
			{
				afterParserOrEnumRuleCall();
			}
			otherlv_59=Semicolon
			{
				newLeafNode(otherlv_59, grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_14());
			}
		)
	)
;

// Entry rule entryRuleEMV2PropertyAssociation
entryRuleEMV2PropertyAssociation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEMV2PropertyAssociationRule()); }
	iv_ruleEMV2PropertyAssociation=ruleEMV2PropertyAssociation
	{ $current=$iv_ruleEMV2PropertyAssociation.current; }
	EOF;

// Rule EMV2PropertyAssociation
ruleEMV2PropertyAssociation returns [EObject current=null]
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
						$current = createModelElement(grammarAccess.getEMV2PropertyAssociationRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEMV2PropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
				}
				ruleQPREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=EqualsSignGreaterThanSign
		{
			newLeafNode(otherlv_1, grammarAccess.getEMV2PropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2PropertyAssociationAccess().getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_0_0());
					}
					lv_ownedValues_2_0=ruleOptionalModalPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2PropertyAssociationRule());
						}
						add(
							$current,
							"ownedValues",
							lv_ownedValues_2_0,
							"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=Comma
				{
					newLeafNode(otherlv_3, grammarAccess.getEMV2PropertyAssociationAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2PropertyAssociationAccess().getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_1_1_0());
						}
						lv_ownedValues_4_0=ruleOptionalModalPropertyValue
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2PropertyAssociationRule());
							}
							add(
								$current,
								"ownedValues",
								lv_ownedValues_4_0,
								"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)
		(
			otherlv_5=Applies
			{
				newLeafNode(otherlv_5, grammarAccess.getEMV2PropertyAssociationAccess().getAppliesKeyword_3_0());
			}
			otherlv_6=To
			{
				newLeafNode(otherlv_6, grammarAccess.getEMV2PropertyAssociationAccess().getToKeyword_3_1());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2PropertyAssociationAccess().getEmv2PathEMV2PathParserRuleCall_3_2_0_0());
						}
						lv_emv2Path_7_0=ruleEMV2Path
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2PropertyAssociationRule());
							}
							add(
								$current,
								"emv2Path",
								lv_emv2Path_7_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2Path");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_8=Comma
					{
						newLeafNode(otherlv_8, grammarAccess.getEMV2PropertyAssociationAccess().getCommaKeyword_3_2_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getEMV2PropertyAssociationAccess().getEmv2PathEMV2PathParserRuleCall_3_2_1_1_0());
							}
							lv_emv2Path_9_0=ruleEMV2Path
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getEMV2PropertyAssociationRule());
								}
								add(
									$current,
									"emv2Path",
									lv_emv2Path_9_0,
									"org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2Path");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
		)?
		otherlv_10=Semicolon
		{
			newLeafNode(otherlv_10, grammarAccess.getEMV2PropertyAssociationAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRuleBasicEMV2PropertyAssociation
entryRuleBasicEMV2PropertyAssociation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBasicEMV2PropertyAssociationRule()); }
	iv_ruleBasicEMV2PropertyAssociation=ruleBasicEMV2PropertyAssociation
	{ $current=$iv_ruleBasicEMV2PropertyAssociation.current; }
	EOF;

// Rule BasicEMV2PropertyAssociation
ruleBasicEMV2PropertyAssociation returns [EObject current=null]
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
						$current = createModelElement(grammarAccess.getBasicEMV2PropertyAssociationRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getBasicEMV2PropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
				}
				ruleQPREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=EqualsSignGreaterThanSign
		{
			newLeafNode(otherlv_1, grammarAccess.getBasicEMV2PropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getBasicEMV2PropertyAssociationAccess().getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_0_0());
					}
					lv_ownedValues_2_0=ruleOptionalModalPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBasicEMV2PropertyAssociationRule());
						}
						add(
							$current,
							"ownedValues",
							lv_ownedValues_2_0,
							"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=Comma
				{
					newLeafNode(otherlv_3, grammarAccess.getBasicEMV2PropertyAssociationAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getBasicEMV2PropertyAssociationAccess().getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_1_1_0());
						}
						lv_ownedValues_4_0=ruleOptionalModalPropertyValue
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getBasicEMV2PropertyAssociationRule());
							}
							add(
								$current,
								"ownedValues",
								lv_ownedValues_4_0,
								"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)
		(
			otherlv_5=Applies
			{
				newLeafNode(otherlv_5, grammarAccess.getBasicEMV2PropertyAssociationAccess().getAppliesKeyword_3_0());
			}
			otherlv_6=To
			{
				newLeafNode(otherlv_6, grammarAccess.getBasicEMV2PropertyAssociationAccess().getToKeyword_3_1());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEmv2PathBasicEMV2PathParserRuleCall_3_2_0_0());
						}
						lv_emv2Path_7_0=ruleBasicEMV2Path
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getBasicEMV2PropertyAssociationRule());
							}
							add(
								$current,
								"emv2Path",
								lv_emv2Path_7_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.BasicEMV2Path");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_8=Comma
					{
						newLeafNode(otherlv_8, grammarAccess.getBasicEMV2PropertyAssociationAccess().getCommaKeyword_3_2_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEmv2PathBasicEMV2PathParserRuleCall_3_2_1_1_0());
							}
							lv_emv2Path_9_0=ruleBasicEMV2Path
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getBasicEMV2PropertyAssociationRule());
								}
								add(
									$current,
									"emv2Path",
									lv_emv2Path_9_0,
									"org.osate.xtext.aadl2.errormodel.ErrorModel.BasicEMV2Path");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)
		)?
		otherlv_10=Semicolon
		{
			newLeafNode(otherlv_10, grammarAccess.getBasicEMV2PropertyAssociationAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRuleEMV2Path
entryRuleEMV2Path returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEMV2PathRule()); }
	iv_ruleEMV2Path=ruleEMV2Path
	{ $current=$iv_ruleEMV2Path.current; }
	EOF;

// Rule EMV2Path
ruleEMV2Path returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0=CircumflexAccent
			{
				newLeafNode(otherlv_0, grammarAccess.getEMV2PathAccess().getCircumflexAccentKeyword_0_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2PathAccess().getContainmentPathContainmentPathElementParserRuleCall_0_1_0());
					}
					lv_containmentPath_1_0=ruleContainmentPathElement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2PathRule());
						}
						set(
							$current,
							"containmentPath",
							lv_containmentPath_1_0,
							"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_2=CommercialAt
			{
				newLeafNode(otherlv_2, grammarAccess.getEMV2PathAccess().getCommercialAtKeyword_0_2());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getEMV2PathAccess().getEmv2TargetEMV2PathElementOrKindParserRuleCall_1_0());
				}
				lv_emv2Target_3_0=ruleEMV2PathElementOrKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEMV2PathRule());
					}
					set(
						$current,
						"emv2Target",
						lv_emv2Target_3_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2PathElementOrKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleBasicEMV2Path
entryRuleBasicEMV2Path returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBasicEMV2PathRule()); }
	iv_ruleBasicEMV2Path=ruleBasicEMV2Path
	{ $current=$iv_ruleBasicEMV2Path.current; }
	EOF;

// Rule BasicEMV2Path
ruleBasicEMV2Path returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getBasicEMV2PathAccess().getEmv2TargetEMV2PathElementOrKindParserRuleCall_0());
			}
			lv_emv2Target_0_0=ruleEMV2PathElementOrKind
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getBasicEMV2PathRule());
				}
				set(
					$current,
					"emv2Target",
					lv_emv2Target_0_0,
					"org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2PathElementOrKind");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleEMV2PathElementOrKind
entryRuleEMV2PathElementOrKind returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEMV2PathElementOrKindRule()); }
	iv_ruleEMV2PathElementOrKind=ruleEMV2PathElementOrKind
	{ $current=$iv_ruleEMV2PathElementOrKind.current; }
	EOF;

// Rule EMV2PathElementOrKind
ruleEMV2PathElementOrKind returns [EObject current=null]
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
						newCompositeNode(grammarAccess.getEMV2PathElementOrKindAccess().getEmv2PropagationKindPropagationKindParserRuleCall_0_0_0());
					}
					lv_emv2PropagationKind_0_0=rulePropagationKind
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2PathElementOrKindRule());
						}
						set(
							$current,
							"emv2PropagationKind",
							lv_emv2PropagationKind_0_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.PropagationKind");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_1=FullStop
				{
					newLeafNode(otherlv_1, grammarAccess.getEMV2PathElementOrKindAccess().getFullStopKeyword_0_1_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getEMV2PathElementOrKindRule());
							}
						}
						otherlv_2=RULE_ID
						{
							newLeafNode(otherlv_2, grammarAccess.getEMV2PathElementOrKindAccess().getErrorTypeErrorTypesCrossReference_0_1_1_0());
						}
					)
				)
			)?
		)
		    |
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEMV2PathElementOrKindRule());
						}
					}
					otherlv_3=RULE_ID
					{
						newLeafNode(otherlv_3, grammarAccess.getEMV2PathElementOrKindAccess().getNamedElementNamedElementCrossReference_1_0_0());
					}
				)
			)
			(
				otherlv_4=FullStop
				{
					newLeafNode(otherlv_4, grammarAccess.getEMV2PathElementOrKindAccess().getFullStopKeyword_1_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2PathElementOrKindAccess().getPathEMV2PathElementParserRuleCall_1_1_1_0());
						}
						lv_path_5_0=ruleEMV2PathElement
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2PathElementOrKindRule());
							}
							set(
								$current,
								"path",
								lv_path_5_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2PathElement");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)
	)
;

// Entry rule entryRuleEMV2PathElement
entryRuleEMV2PathElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEMV2PathElementRule()); }
	iv_ruleEMV2PathElement=ruleEMV2PathElement
	{ $current=$iv_ruleEMV2PathElement.current; }
	EOF;

// Rule EMV2PathElement
ruleEMV2PathElement returns [EObject current=null]
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
						$current = createModelElement(grammarAccess.getEMV2PathElementRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getEMV2PathElementAccess().getNamedElementNamedElementCrossReference_0_0());
				}
			)
		)
		(
			otherlv_1=FullStop
			{
				newLeafNode(otherlv_1, grammarAccess.getEMV2PathElementAccess().getFullStopKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEMV2PathElementAccess().getPathEMV2PathElementParserRuleCall_1_1_0());
					}
					lv_path_2_0=ruleEMV2PathElement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEMV2PathElementRule());
						}
						set(
							$current,
							"path",
							lv_path_2_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2PathElement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleErrorTypes
entryRuleErrorTypes returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorTypesRule()); }
	iv_ruleErrorTypes=ruleErrorTypes
	{ $current=$iv_ruleErrorTypes.current; }
	EOF;

// Rule ErrorTypes
ruleErrorTypes returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getErrorTypesAccess().getTypeDefinitionParserRuleCall_0());
		}
		this_TypeDefinition_0=ruleTypeDefinition
		{
			$current = $this_TypeDefinition_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getErrorTypesAccess().getTypeSetDefinitionParserRuleCall_1());
		}
		this_TypeSetDefinition_1=ruleTypeSetDefinition
		{
			$current = $this_TypeSetDefinition_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTypeDefinition
entryRuleTypeDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeDefinitionRule()); }
	iv_ruleTypeDefinition=ruleTypeDefinition
	{ $current=$iv_ruleTypeDefinition.current; }
	EOF;

// Rule TypeDefinition
ruleTypeDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getTypeDefinitionAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTypeDefinitionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		(
			(
				otherlv_1=Colon
				{
					newLeafNode(otherlv_1, grammarAccess.getTypeDefinitionAccess().getColonKeyword_1_0_0());
				}
				otherlv_2=Type
				{
					newLeafNode(otherlv_2, grammarAccess.getTypeDefinitionAccess().getTypeKeyword_1_0_1());
				}
			)
			    |
			(
				otherlv_3=Colon
				{
					newLeafNode(otherlv_3, grammarAccess.getTypeDefinitionAccess().getColonKeyword_1_1_0());
				}
				otherlv_4=Type
				{
					newLeafNode(otherlv_4, grammarAccess.getTypeDefinitionAccess().getTypeKeyword_1_1_1());
				}
				otherlv_5=Extends
				{
					newLeafNode(otherlv_5, grammarAccess.getTypeDefinitionAccess().getExtendsKeyword_1_1_2());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getTypeDefinitionRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getTypeDefinitionAccess().getSuperTypeErrorTypeCrossReference_1_1_3_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				otherlv_7=Renames
				{
					newLeafNode(otherlv_7, grammarAccess.getTypeDefinitionAccess().getRenamesKeyword_1_2_0());
				}
				otherlv_8=Type
				{
					newLeafNode(otherlv_8, grammarAccess.getTypeDefinitionAccess().getTypeKeyword_1_2_1());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getTypeDefinitionRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getTypeDefinitionAccess().getAliasedTypeErrorTypeCrossReference_1_2_2_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)
		otherlv_10=Semicolon
		{
			newLeafNode(otherlv_10, grammarAccess.getTypeDefinitionAccess().getSemicolonKeyword_2());
		}
	)
;

// Entry rule entryRuleTypeSetDefinition
entryRuleTypeSetDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeSetDefinitionRule()); }
	iv_ruleTypeSetDefinition=ruleTypeSetDefinition
	{ $current=$iv_ruleTypeSetDefinition.current; }
	EOF;

// Rule TypeSetDefinition
ruleTypeSetDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getTypeSetDefinitionAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTypeSetDefinitionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		(
			(
				otherlv_1=Colon
				{
					newLeafNode(otherlv_1, grammarAccess.getTypeSetDefinitionAccess().getColonKeyword_1_0_0());
				}
				otherlv_2=Type
				{
					newLeafNode(otherlv_2, grammarAccess.getTypeSetDefinitionAccess().getTypeKeyword_1_0_1());
				}
				otherlv_3=Set
				{
					newLeafNode(otherlv_3, grammarAccess.getTypeSetDefinitionAccess().getSetKeyword_1_0_2());
				}
				otherlv_4=LeftCurlyBracket
				{
					newLeafNode(otherlv_4, grammarAccess.getTypeSetDefinitionAccess().getLeftCurlyBracketKeyword_1_0_3());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeSetDefinitionAccess().getTypeTokensTypeSetElementParserRuleCall_1_0_4_0());
						}
						lv_typeTokens_5_0=ruleTypeSetElement
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeSetDefinitionRule());
							}
							add(
								$current,
								"typeTokens",
								lv_typeTokens_5_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetElement");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_6=Comma
					{
						newLeafNode(otherlv_6, grammarAccess.getTypeSetDefinitionAccess().getCommaKeyword_1_0_5_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getTypeSetDefinitionAccess().getTypeTokensTypeSetElementParserRuleCall_1_0_5_1_0());
							}
							lv_typeTokens_7_0=ruleTypeSetElement
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTypeSetDefinitionRule());
								}
								add(
									$current,
									"typeTokens",
									lv_typeTokens_7_0,
									"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetElement");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				otherlv_8=RightCurlyBracket
				{
					newLeafNode(otherlv_8, grammarAccess.getTypeSetDefinitionAccess().getRightCurlyBracketKeyword_1_0_6());
				}
			)
			    |
			(
				otherlv_9=Renames
				{
					newLeafNode(otherlv_9, grammarAccess.getTypeSetDefinitionAccess().getRenamesKeyword_1_1_0());
				}
				otherlv_10=Type
				{
					newLeafNode(otherlv_10, grammarAccess.getTypeSetDefinitionAccess().getTypeKeyword_1_1_1());
				}
				otherlv_11=Set
				{
					newLeafNode(otherlv_11, grammarAccess.getTypeSetDefinitionAccess().getSetKeyword_1_1_2());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getTypeSetDefinitionRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getTypeSetDefinitionAccess().getAliasedTypeTypeSetCrossReference_1_1_3_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)
		otherlv_13=Semicolon
		{
			newLeafNode(otherlv_13, grammarAccess.getTypeSetDefinitionAccess().getSemicolonKeyword_2());
		}
	)
;

// Entry rule entryRuleTypeSetConstructor
entryRuleTypeSetConstructor returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeSetConstructorRule()); }
	iv_ruleTypeSetConstructor=ruleTypeSetConstructor
	{ $current=$iv_ruleTypeSetConstructor.current; }
	EOF;

// Rule TypeSetConstructor
ruleTypeSetConstructor returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=LeftCurlyBracket
		{
			newLeafNode(otherlv_0, grammarAccess.getTypeSetConstructorAccess().getLeftCurlyBracketKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeSetConstructorAccess().getTypeTokensTypeSetElementParserRuleCall_1_0());
				}
				lv_typeTokens_1_0=ruleTypeSetElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeSetConstructorRule());
					}
					add(
						$current,
						"typeTokens",
						lv_typeTokens_1_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetElement");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2=Comma
			{
				newLeafNode(otherlv_2, grammarAccess.getTypeSetConstructorAccess().getCommaKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTypeSetConstructorAccess().getTypeTokensTypeSetElementParserRuleCall_2_1_0());
					}
					lv_typeTokens_3_0=ruleTypeSetElement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTypeSetConstructorRule());
						}
						add(
							$current,
							"typeTokens",
							lv_typeTokens_3_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetElement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_4=RightCurlyBracket
		{
			newLeafNode(otherlv_4, grammarAccess.getTypeSetConstructorAccess().getRightCurlyBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleTypeSetReference
entryRuleTypeSetReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeSetReferenceRule()); }
	iv_ruleTypeSetReference=ruleTypeSetReference
	{ $current=$iv_ruleTypeSetReference.current; }
	EOF;

// Rule TypeSetReference
ruleTypeSetReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getTypeSetReferenceAccess().getTypeSetConstructorParserRuleCall());
	}
	this_TypeSetConstructor_0=ruleTypeSetConstructor
	{
		$current = $this_TypeSetConstructor_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleTypeSetElement
entryRuleTypeSetElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeSetElementRule()); }
	iv_ruleTypeSetElement=ruleTypeSetElement
	{ $current=$iv_ruleTypeSetElement.current; }
	EOF;

// Rule TypeSetElement
ruleTypeSetElement returns [EObject current=null]
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
						$current = createModelElement(grammarAccess.getTypeSetElementRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getTypeSetElementAccess().getTypeErrorTypesCrossReference_0_0());
				}
				ruleQEMREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=Asterisk
			{
				newLeafNode(otherlv_1, grammarAccess.getTypeSetElementAccess().getAsteriskKeyword_1_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTypeSetElementRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getTypeSetElementAccess().getTypeErrorTypesCrossReference_1_1_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleNoErrorTypeSet
entryRuleNoErrorTypeSet returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNoErrorTypeSetRule()); }
	iv_ruleNoErrorTypeSet=ruleNoErrorTypeSet
	{ $current=$iv_ruleNoErrorTypeSet.current; }
	EOF;

// Rule NoErrorTypeSet
ruleNoErrorTypeSet returns [EObject current=null]
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
					grammarAccess.getNoErrorTypeSetAccess().getTypeSetAction_0(),
					$current);
			}
		)
		otherlv_1=LeftCurlyBracket
		{
			newLeafNode(otherlv_1, grammarAccess.getNoErrorTypeSetAccess().getLeftCurlyBracketKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getNoErrorTypeSetAccess().getTypeTokensNoErrorTypeTokenParserRuleCall_2_0());
				}
				lv_typeTokens_2_0=ruleNoErrorTypeToken
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNoErrorTypeSetRule());
					}
					add(
						$current,
						"typeTokens",
						lv_typeTokens_2_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.NoErrorTypeToken");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=RightCurlyBracket
		{
			newLeafNode(otherlv_3, grammarAccess.getNoErrorTypeSetAccess().getRightCurlyBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleNoErrorTypeToken
entryRuleNoErrorTypeToken returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNoErrorTypeTokenRule()); }
	iv_ruleNoErrorTypeToken=ruleNoErrorTypeToken
	{ $current=$iv_ruleNoErrorTypeToken.current; }
	EOF;

// Rule NoErrorTypeToken
ruleNoErrorTypeToken returns [EObject current=null]
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
					grammarAccess.getNoErrorTypeTokenAccess().getTypeTokenAction_0(),
					$current);
			}
		)
		(
			(
				lv_noError_1_0=Noerror
				{
					newLeafNode(lv_noError_1_0, grammarAccess.getNoErrorTypeTokenAccess().getNoErrorNoerrorKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNoErrorTypeTokenRule());
					}
					setWithLastConsumed($current, "noError", true, "noerror");
				}
			)
		)
	)
;

// Entry rule entryRuleTypeToken
entryRuleTypeToken returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeTokenRule()); }
	iv_ruleTypeToken=ruleTypeToken
	{ $current=$iv_ruleTypeToken.current; }
	EOF;

// Rule TypeToken
ruleTypeToken returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getTypeTokenAccess().getTypeSetReferenceParserRuleCall());
	}
	this_TypeSetReference_0=ruleTypeSetReference
	{
		$current = $this_TypeSetReference_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleTypeTokenOrNoError
entryRuleTypeTokenOrNoError returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeTokenOrNoErrorRule()); }
	iv_ruleTypeTokenOrNoError=ruleTypeTokenOrNoError
	{ $current=$iv_ruleTypeTokenOrNoError.current; }
	EOF;

// Rule TypeTokenOrNoError
ruleTypeTokenOrNoError returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTypeTokenOrNoErrorAccess().getTypeSetReferenceParserRuleCall_0());
		}
		this_TypeSetReference_0=ruleTypeSetReference
		{
			$current = $this_TypeSetReference_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeTokenOrNoErrorAccess().getNoErrorTypeSetParserRuleCall_1());
		}
		this_NoErrorTypeSet_1=ruleNoErrorTypeSet
		{
			$current = $this_NoErrorTypeSet_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTypeTokenConstraint
entryRuleTypeTokenConstraint returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeTokenConstraintRule()); }
	iv_ruleTypeTokenConstraint=ruleTypeTokenConstraint
	{ $current=$iv_ruleTypeTokenConstraint.current; }
	EOF;

// Rule TypeTokenConstraint
ruleTypeTokenConstraint returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getTypeTokenConstraintAccess().getTypeSetReferenceParserRuleCall());
	}
	this_TypeSetReference_0=ruleTypeSetReference
	{
		$current = $this_TypeSetReference_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleTypeTokenConstraintNoError
entryRuleTypeTokenConstraintNoError returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeTokenConstraintNoErrorRule()); }
	iv_ruleTypeTokenConstraintNoError=ruleTypeTokenConstraintNoError
	{ $current=$iv_ruleTypeTokenConstraintNoError.current; }
	EOF;

// Rule TypeTokenConstraintNoError
ruleTypeTokenConstraintNoError returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTypeTokenConstraintNoErrorAccess().getTypeSetReferenceParserRuleCall_0());
		}
		this_TypeSetReference_0=ruleTypeSetReference
		{
			$current = $this_TypeSetReference_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeTokenConstraintNoErrorAccess().getNoErrorTypeSetParserRuleCall_1());
		}
		this_NoErrorTypeSet_1=ruleNoErrorTypeSet
		{
			$current = $this_NoErrorTypeSet_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTypeTransformationSet
entryRuleTypeTransformationSet returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeTransformationSetRule()); }
	iv_ruleTypeTransformationSet=ruleTypeTransformationSet
	{ $current=$iv_ruleTypeTransformationSet.current; }
	EOF;

// Rule TypeTransformationSet
ruleTypeTransformationSet returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Type
		{
			newLeafNode(otherlv_0, grammarAccess.getTypeTransformationSetAccess().getTypeKeyword_0());
		}
		otherlv_1=Transformations
		{
			newLeafNode(otherlv_1, grammarAccess.getTypeTransformationSetAccess().getTransformationsKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getTypeTransformationSetAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTypeTransformationSetRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		(
			otherlv_3=Use
			{
				newLeafNode(otherlv_3, grammarAccess.getTypeTransformationSetAccess().getUseKeyword_3_0());
			}
			otherlv_4=Types
			{
				newLeafNode(otherlv_4, grammarAccess.getTypeTransformationSetAccess().getTypesKeyword_3_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTypeTransformationSetRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getTypeTransformationSetAccess().getUseTypesErrorModelLibraryCrossReference_3_2_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_6=Comma
				{
					newLeafNode(otherlv_6, grammarAccess.getTypeTransformationSetAccess().getCommaKeyword_3_3_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getTypeTransformationSetRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getTypeTransformationSetAccess().getUseTypesErrorModelLibraryCrossReference_3_3_1_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_8=Semicolon
			{
				newLeafNode(otherlv_8, grammarAccess.getTypeTransformationSetAccess().getSemicolonKeyword_3_4());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeTransformationSetAccess().getTransformationTypeTransformationParserRuleCall_4_0());
				}
				lv_transformation_9_0=ruleTypeTransformation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeTransformationSetRule());
					}
					add(
						$current,
						"transformation",
						lv_transformation_9_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTransformation");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_10=End
		{
			newLeafNode(otherlv_10, grammarAccess.getTypeTransformationSetAccess().getEndKeyword_5());
		}
		otherlv_11=Transformations
		{
			newLeafNode(otherlv_11, grammarAccess.getTypeTransformationSetAccess().getTransformationsKeyword_6());
		}
		otherlv_12=Semicolon
		{
			newLeafNode(otherlv_12, grammarAccess.getTypeTransformationSetAccess().getSemicolonKeyword_7());
		}
	)
;

// Entry rule entryRuleTypeTransformation
entryRuleTypeTransformation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeTransformationRule()); }
	iv_ruleTypeTransformation=ruleTypeTransformation
	{ $current=$iv_ruleTypeTransformation.current; }
	EOF;

// Rule TypeTransformation
ruleTypeTransformation returns [EObject current=null]
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
						newCompositeNode(grammarAccess.getTypeTransformationAccess().getSourceTypeTokenConstraintNoErrorParserRuleCall_0_0_0());
					}
					lv_source_0_0=ruleTypeTokenConstraintNoError
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTypeTransformationRule());
						}
						set(
							$current,
							"source",
							lv_source_0_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraintNoError");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					lv_allSources_1_0=All
					{
						newLeafNode(lv_allSources_1_0, grammarAccess.getTypeTransformationAccess().getAllSourcesAllKeyword_0_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTypeTransformationRule());
						}
						setWithLastConsumed($current, "allSources", true, "all");
					}
				)
			)
		)
		otherlv_2=HyphenMinusLeftSquareBracket
		{
			newLeafNode(otherlv_2, grammarAccess.getTypeTransformationAccess().getHyphenMinusLeftSquareBracketKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeTransformationAccess().getContributorTypeTokenConstraintNoErrorParserRuleCall_2_0());
				}
				lv_contributor_3_0=ruleTypeTokenConstraintNoError
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeTransformationRule());
					}
					set(
						$current,
						"contributor",
						lv_contributor_3_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraintNoError");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_4=RightSquareBracketHyphenMinusGreaterThanSign
		{
			newLeafNode(otherlv_4, grammarAccess.getTypeTransformationAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeTransformationAccess().getTargetTypeTokenParserRuleCall_4_0());
				}
				lv_target_5_0=ruleTypeToken
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeTransformationRule());
					}
					set(
						$current,
						"target",
						lv_target_5_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeToken");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6=Semicolon
		{
			newLeafNode(otherlv_6, grammarAccess.getTypeTransformationAccess().getSemicolonKeyword_5());
		}
	)
;

// Entry rule entryRuleTypeMappingSet
entryRuleTypeMappingSet returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeMappingSetRule()); }
	iv_ruleTypeMappingSet=ruleTypeMappingSet
	{ $current=$iv_ruleTypeMappingSet.current; }
	EOF;

// Rule TypeMappingSet
ruleTypeMappingSet returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Type
		{
			newLeafNode(otherlv_0, grammarAccess.getTypeMappingSetAccess().getTypeKeyword_0());
		}
		otherlv_1=Mappings
		{
			newLeafNode(otherlv_1, grammarAccess.getTypeMappingSetAccess().getMappingsKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getTypeMappingSetAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTypeMappingSetRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		(
			otherlv_3=Use
			{
				newLeafNode(otherlv_3, grammarAccess.getTypeMappingSetAccess().getUseKeyword_3_0());
			}
			otherlv_4=Types
			{
				newLeafNode(otherlv_4, grammarAccess.getTypeMappingSetAccess().getTypesKeyword_3_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTypeMappingSetRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getTypeMappingSetAccess().getUseTypesErrorModelLibraryCrossReference_3_2_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_6=Comma
				{
					newLeafNode(otherlv_6, grammarAccess.getTypeMappingSetAccess().getCommaKeyword_3_3_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getTypeMappingSetRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getTypeMappingSetAccess().getUseTypesErrorModelLibraryCrossReference_3_3_1_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_8=Semicolon
			{
				newLeafNode(otherlv_8, grammarAccess.getTypeMappingSetAccess().getSemicolonKeyword_3_4());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeMappingSetAccess().getMappingTypeMappingParserRuleCall_4_0());
				}
				lv_mapping_9_0=ruleTypeMapping
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeMappingSetRule());
					}
					add(
						$current,
						"mapping",
						lv_mapping_9_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeMapping");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_10=End
		{
			newLeafNode(otherlv_10, grammarAccess.getTypeMappingSetAccess().getEndKeyword_5());
		}
		otherlv_11=Mappings
		{
			newLeafNode(otherlv_11, grammarAccess.getTypeMappingSetAccess().getMappingsKeyword_6());
		}
		otherlv_12=Semicolon
		{
			newLeafNode(otherlv_12, grammarAccess.getTypeMappingSetAccess().getSemicolonKeyword_7());
		}
	)
;

// Entry rule entryRuleTypeMapping
entryRuleTypeMapping returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeMappingRule()); }
	iv_ruleTypeMapping=ruleTypeMapping
	{ $current=$iv_ruleTypeMapping.current; }
	EOF;

// Rule TypeMapping
ruleTypeMapping returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getTypeMappingAccess().getSourceTypeTokenConstraintParserRuleCall_0_0());
				}
				lv_source_0_0=ruleTypeTokenConstraint
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeMappingRule());
					}
					set(
						$current,
						"source",
						lv_source_0_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraint");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=HyphenMinusGreaterThanSign
		{
			newLeafNode(otherlv_1, grammarAccess.getTypeMappingAccess().getHyphenMinusGreaterThanSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeMappingAccess().getTargetTypeTokenParserRuleCall_2_0());
				}
				lv_target_2_0=ruleTypeToken
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeMappingRule());
					}
					set(
						$current,
						"target",
						lv_target_2_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeToken");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=Semicolon
		{
			newLeafNode(otherlv_3, grammarAccess.getTypeMappingAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRuleErrorPropagation
entryRuleErrorPropagation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorPropagationRule()); }
	iv_ruleErrorPropagation=ruleErrorPropagation
	{ $current=$iv_ruleErrorPropagation.current; }
	EOF;

// Rule ErrorPropagation
ruleErrorPropagation returns [EObject current=null]
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
					grammarAccess.getErrorPropagationAccess().getErrorPropagationAction_0(),
					$current);
			}
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorPropagationAccess().getKindPropagationKindParserRuleCall_1_0_0());
					}
					lv_kind_1_0=rulePropagationKind
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorPropagationRule());
						}
						set(
							$current,
							"kind",
							lv_kind_1_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.PropagationKind");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorPropagationAccess().getFeatureorPPRefFeatureorPPReferenceParserRuleCall_1_1_0());
					}
					lv_featureorPPRef_2_0=ruleFeatureorPPReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorPropagationRule());
						}
						set(
							$current,
							"featureorPPRef",
							lv_featureorPPRef_2_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.FeatureorPPReference");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		otherlv_3=Colon
		{
			newLeafNode(otherlv_3, grammarAccess.getErrorPropagationAccess().getColonKeyword_2());
		}
		(
			(
				lv_not_4_0=Not
				{
					newLeafNode(lv_not_4_0, grammarAccess.getErrorPropagationAccess().getNotNotKeyword_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getErrorPropagationRule());
					}
					setWithLastConsumed($current, "not", true, "not");
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorPropagationAccess().getDirectionPropagationDirectionParserRuleCall_4_0());
				}
				lv_direction_5_0=rulePropagationDirection
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorPropagationRule());
					}
					set(
						$current,
						"direction",
						lv_direction_5_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.PropagationDirection");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6=Propagation
		{
			newLeafNode(otherlv_6, grammarAccess.getErrorPropagationAccess().getPropagationKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorPropagationAccess().getTypeSetTypeSetReferenceParserRuleCall_6_0());
				}
				lv_typeSet_7_0=ruleTypeSetReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorPropagationRule());
					}
					set(
						$current,
						"typeSet",
						lv_typeSet_7_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_8=Semicolon
		{
			newLeafNode(otherlv_8, grammarAccess.getErrorPropagationAccess().getSemicolonKeyword_7());
		}
	)
;

// Entry rule entryRuleFeatureorPPReference
entryRuleFeatureorPPReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFeatureorPPReferenceRule()); }
	iv_ruleFeatureorPPReference=ruleFeatureorPPReference
	{ $current=$iv_ruleFeatureorPPReference.current; }
	EOF;

// Rule FeatureorPPReference
ruleFeatureorPPReference returns [EObject current=null]
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
						$current = createModelElement(grammarAccess.getFeatureorPPReferenceRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getFeatureorPPReferenceAccess().getFeatureorPPNamedElementCrossReference_0_0());
				}
			)
		)
		(
			otherlv_1=FullStop
			{
				newLeafNode(otherlv_1, grammarAccess.getFeatureorPPReferenceAccess().getFullStopKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getFeatureorPPReferenceAccess().getNextFeatureorPPReferenceParserRuleCall_1_1_0());
					}
					lv_next_2_0=ruleFeatureorPPReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getFeatureorPPReferenceRule());
						}
						set(
							$current,
							"next",
							lv_next_2_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.FeatureorPPReference");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRulePropagationDirection
entryRulePropagationDirection returns [String current=null]:
	{ newCompositeNode(grammarAccess.getPropagationDirectionRule()); }
	iv_rulePropagationDirection=rulePropagationDirection
	{ $current=$iv_rulePropagationDirection.current.getText(); }
	EOF;

// Rule PropagationDirection
rulePropagationDirection returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
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
			newLeafNode(kw, grammarAccess.getPropagationDirectionAccess().getInKeyword_0());
		}
		    |
		kw=Out
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPropagationDirectionAccess().getOutKeyword_1());
		}
	)
;

// Entry rule entryRulePropagationKind
entryRulePropagationKind returns [String current=null]:
	{ newCompositeNode(grammarAccess.getPropagationKindRule()); }
	iv_rulePropagationKind=rulePropagationKind
	{ $current=$iv_rulePropagationKind.current.getText(); }
	EOF;

// Rule PropagationKind
rulePropagationKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=Processor
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPropagationKindAccess().getProcessorKeyword_0());
		}
		    |
		kw=Memory
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPropagationKindAccess().getMemoryKeyword_1());
		}
		    |
		kw=Connection
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPropagationKindAccess().getConnectionKeyword_2());
		}
		    |
		kw=Binding
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPropagationKindAccess().getBindingKeyword_3());
		}
		    |
		kw=Bindings
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPropagationKindAccess().getBindingsKeyword_4());
		}
		    |
		kw=Access
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPropagationKindAccess().getAccessKeyword_5());
		}
	)
;

// Entry rule entryRuleErrorFlow
entryRuleErrorFlow returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorFlowRule()); }
	iv_ruleErrorFlow=ruleErrorFlow
	{ $current=$iv_ruleErrorFlow.current; }
	EOF;

// Rule ErrorFlow
ruleErrorFlow returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getErrorFlowAccess().getErrorSourceParserRuleCall_0());
		}
		this_ErrorSource_0=ruleErrorSource
		{
			$current = $this_ErrorSource_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getErrorFlowAccess().getErrorSinkParserRuleCall_1());
		}
		this_ErrorSink_1=ruleErrorSink
		{
			$current = $this_ErrorSink_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getErrorFlowAccess().getErrorPathParserRuleCall_2());
		}
		this_ErrorPath_2=ruleErrorPath
		{
			$current = $this_ErrorPath_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleErrorSource
entryRuleErrorSource returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorSourceRule()); }
	iv_ruleErrorSource=ruleErrorSource
	{ $current=$iv_ruleErrorSource.current; }
	EOF;

// Rule ErrorSource
ruleErrorSource returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getErrorSourceAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getErrorSourceRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_1=Colon
		{
			newLeafNode(otherlv_1, grammarAccess.getErrorSourceAccess().getColonKeyword_1());
		}
		otherlv_2=Error
		{
			newLeafNode(otherlv_2, grammarAccess.getErrorSourceAccess().getErrorKeyword_2());
		}
		otherlv_3=Source
		{
			newLeafNode(otherlv_3, grammarAccess.getErrorSourceAccess().getSourceKeyword_3());
		}
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorSourceRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getErrorSourceAccess().getSourceModelElementNamedElementCrossReference_4_0_0());
					}
					ruleErrorPropagationPoint
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					lv_all_5_0=All
					{
						newLeafNode(lv_all_5_0, grammarAccess.getErrorSourceAccess().getAllAllKeyword_4_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorSourceRule());
						}
						setWithLastConsumed($current, "all", true, "all");
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorSourceAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_5_0());
				}
				lv_typeTokenConstraint_6_0=ruleTypeTokenConstraint
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorSourceRule());
					}
					set(
						$current,
						"typeTokenConstraint",
						lv_typeTokenConstraint_6_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraint");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_7=When
			{
				newLeafNode(otherlv_7, grammarAccess.getErrorSourceAccess().getWhenKeyword_6_0());
			}
			(
				(
					(
						(
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getErrorSourceRule());
								}
							}
							otherlv_8=RULE_ID
							{
								newLeafNode(otherlv_8, grammarAccess.getErrorSourceAccess().getFailureModeReferenceErrorBehaviorStateCrossReference_6_1_0_0_0());
							}
						)
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getErrorSourceAccess().getFailureModeTypeTypeSetReferenceParserRuleCall_6_1_0_1_0());
							}
							lv_failureModeType_9_0=ruleTypeSetReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getErrorSourceRule());
								}
								set(
									$current,
									"failureModeType",
									lv_failureModeType_9_0,
									"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetReference");
								afterParserOrEnumRuleCall();
							}
						)
					)?
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorSourceAccess().getFailureModeTypeTypeSetConstructorParserRuleCall_6_1_1_0());
						}
						lv_failureModeType_10_0=ruleTypeSetConstructor
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorSourceRule());
							}
							set(
								$current,
								"failureModeType",
								lv_failureModeType_10_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetConstructor");
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						lv_failureModeDescription_11_0=RULE_STRING
						{
							newLeafNode(lv_failureModeDescription_11_0, grammarAccess.getErrorSourceAccess().getFailureModeDescriptionSTRINGTerminalRuleCall_6_1_2_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getErrorSourceRule());
							}
							setWithLastConsumed(
								$current,
								"failureModeDescription",
								lv_failureModeDescription_11_0,
								"org.osate.xtext.aadl2.properties.Properties.STRING");
						}
					)
				)
			)
		)?
		(
			otherlv_12=If
			{
				newLeafNode(otherlv_12, grammarAccess.getErrorSourceAccess().getIfKeyword_7_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorSourceAccess().getFlowconditionIfConditionParserRuleCall_7_1_0());
					}
					lv_flowcondition_13_0=ruleIfCondition
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorSourceRule());
						}
						set(
							$current,
							"flowcondition",
							lv_flowcondition_13_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.IfCondition");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_14=Semicolon
		{
			newLeafNode(otherlv_14, grammarAccess.getErrorSourceAccess().getSemicolonKeyword_8());
		}
	)
;

// Entry rule entryRuleErrorSink
entryRuleErrorSink returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorSinkRule()); }
	iv_ruleErrorSink=ruleErrorSink
	{ $current=$iv_ruleErrorSink.current; }
	EOF;

// Rule ErrorSink
ruleErrorSink returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getErrorSinkAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getErrorSinkRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_1=Colon
		{
			newLeafNode(otherlv_1, grammarAccess.getErrorSinkAccess().getColonKeyword_1());
		}
		otherlv_2=Error
		{
			newLeafNode(otherlv_2, grammarAccess.getErrorSinkAccess().getErrorKeyword_2());
		}
		otherlv_3=Sink
		{
			newLeafNode(otherlv_3, grammarAccess.getErrorSinkAccess().getSinkKeyword_3());
		}
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorSinkRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getErrorSinkAccess().getIncomingErrorPropagationCrossReference_4_0_0());
					}
					ruleErrorPropagationPoint
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					lv_allIncoming_5_0=All
					{
						newLeafNode(lv_allIncoming_5_0, grammarAccess.getErrorSinkAccess().getAllIncomingAllKeyword_4_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorSinkRule());
						}
						setWithLastConsumed($current, "allIncoming", true, "all");
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorSinkAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_5_0());
				}
				lv_typeTokenConstraint_6_0=ruleTypeTokenConstraint
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorSinkRule());
					}
					set(
						$current,
						"typeTokenConstraint",
						lv_typeTokenConstraint_6_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraint");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_7=If
			{
				newLeafNode(otherlv_7, grammarAccess.getErrorSinkAccess().getIfKeyword_6_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorSinkAccess().getFlowconditionIfConditionParserRuleCall_6_1_0());
					}
					lv_flowcondition_8_0=ruleIfCondition
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorSinkRule());
						}
						set(
							$current,
							"flowcondition",
							lv_flowcondition_8_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.IfCondition");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_9=Semicolon
		{
			newLeafNode(otherlv_9, grammarAccess.getErrorSinkAccess().getSemicolonKeyword_7());
		}
	)
;

// Entry rule entryRuleErrorPath
entryRuleErrorPath returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorPathRule()); }
	iv_ruleErrorPath=ruleErrorPath
	{ $current=$iv_ruleErrorPath.current; }
	EOF;

// Rule ErrorPath
ruleErrorPath returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getErrorPathAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getErrorPathRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_1=Colon
		{
			newLeafNode(otherlv_1, grammarAccess.getErrorPathAccess().getColonKeyword_1());
		}
		otherlv_2=Error
		{
			newLeafNode(otherlv_2, grammarAccess.getErrorPathAccess().getErrorKeyword_2());
		}
		otherlv_3=Path
		{
			newLeafNode(otherlv_3, grammarAccess.getErrorPathAccess().getPathKeyword_3());
		}
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorPathRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getErrorPathAccess().getIncomingErrorPropagationCrossReference_4_0_0());
					}
					ruleErrorPropagationPoint
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					lv_allIncoming_5_0=All
					{
						newLeafNode(lv_allIncoming_5_0, grammarAccess.getErrorPathAccess().getAllIncomingAllKeyword_4_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorPathRule());
						}
						setWithLastConsumed($current, "allIncoming", true, "all");
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorPathAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_5_0());
				}
				lv_typeTokenConstraint_6_0=ruleTypeTokenConstraint
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorPathRule());
					}
					set(
						$current,
						"typeTokenConstraint",
						lv_typeTokenConstraint_6_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraint");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_7=HyphenMinusGreaterThanSign
		{
			newLeafNode(otherlv_7, grammarAccess.getErrorPathAccess().getHyphenMinusGreaterThanSignKeyword_6());
		}
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorPathRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getErrorPathAccess().getOutgoingErrorPropagationCrossReference_7_0_0());
					}
					ruleErrorPropagationPoint
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					lv_allOutgoing_9_0=All
					{
						newLeafNode(lv_allOutgoing_9_0, grammarAccess.getErrorPathAccess().getAllOutgoingAllKeyword_7_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorPathRule());
						}
						setWithLastConsumed($current, "allOutgoing", true, "all");
					}
				)
			)
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorPathAccess().getTargetTokenTypeTokenParserRuleCall_8_0_0());
					}
					lv_targetToken_10_0=ruleTypeToken
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorPathRule());
						}
						set(
							$current,
							"targetToken",
							lv_targetToken_10_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeToken");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				otherlv_11=Use
				{
					newLeafNode(otherlv_11, grammarAccess.getErrorPathAccess().getUseKeyword_8_1_0());
				}
				otherlv_12=Mappings
				{
					newLeafNode(otherlv_12, grammarAccess.getErrorPathAccess().getMappingsKeyword_8_1_1());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getErrorPathRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getErrorPathAccess().getTypeMappingSetTypeMappingSetCrossReference_8_1_2_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)?
		(
			otherlv_14=If
			{
				newLeafNode(otherlv_14, grammarAccess.getErrorPathAccess().getIfKeyword_9_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorPathAccess().getFlowconditionIfConditionParserRuleCall_9_1_0());
					}
					lv_flowcondition_15_0=ruleIfCondition
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorPathRule());
						}
						set(
							$current,
							"flowcondition",
							lv_flowcondition_15_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.IfCondition");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_16=Semicolon
		{
			newLeafNode(otherlv_16, grammarAccess.getErrorPathAccess().getSemicolonKeyword_10());
		}
	)
;

// Entry rule entryRuleIfCondition
entryRuleIfCondition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIfConditionRule()); }
	iv_ruleIfCondition=ruleIfCondition
	{ $current=$iv_ruleIfCondition.current; }
	EOF;

// Rule IfCondition
ruleIfCondition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_description_0_0=RULE_STRING
				{
					newLeafNode(lv_description_0_0, grammarAccess.getIfConditionAccess().getDescriptionSTRINGTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIfConditionRule());
					}
					setWithLastConsumed(
						$current,
						"description",
						lv_description_0_0,
						"org.osate.xtext.aadl2.properties.Properties.STRING");
				}
			)
		)
		    |
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIfConditionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getIfConditionAccess().getResoluteFunctionEObjectCrossReference_1_0());
				}
				ruleQEMREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getIfConditionAccess().getJavaMethodQUALIFIEDNAMEParserRuleCall_2_0());
				}
				lv_javaMethod_2_0=ruleQUALIFIEDNAME
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIfConditionRule());
					}
					set(
						$current,
						"javaMethod",
						lv_javaMethod_2_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.QUALIFIEDNAME");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleErrorPropagationPoint
entryRuleErrorPropagationPoint returns [String current=null]:
	{ newCompositeNode(grammarAccess.getErrorPropagationPointRule()); }
	iv_ruleErrorPropagationPoint=ruleErrorPropagationPoint
	{ $current=$iv_ruleErrorPropagationPoint.current.getText(); }
	EOF;

// Rule ErrorPropagationPoint
ruleErrorPropagationPoint returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
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
				newLeafNode(this_ID_0, grammarAccess.getErrorPropagationPointAccess().getIDTerminalRuleCall_0_0());
			}
			kw=FullStop
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getErrorPropagationPointAccess().getFullStopKeyword_0_1());
			}
		)*
		(
			{
				newCompositeNode(grammarAccess.getErrorPropagationPointAccess().getPropagationKindParserRuleCall_1_0());
			}
			this_PropagationKind_2=rulePropagationKind
			{
				$current.merge(this_PropagationKind_2);
			}
			{
				afterParserOrEnumRuleCall();
			}
			    |
			this_ID_3=RULE_ID
			{
				$current.merge(this_ID_3);
			}
			{
				newLeafNode(this_ID_3, grammarAccess.getErrorPropagationPointAccess().getIDTerminalRuleCall_1_1());
			}
		)
	)
;

// Entry rule entryRulePropagationPoint
entryRulePropagationPoint returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropagationPointRule()); }
	iv_rulePropagationPoint=rulePropagationPoint
	{ $current=$iv_rulePropagationPoint.current; }
	EOF;

// Rule PropagationPoint
rulePropagationPoint returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getPropagationPointAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPropagationPointRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_1=Colon
		{
			newLeafNode(otherlv_1, grammarAccess.getPropagationPointAccess().getColonKeyword_1());
		}
		otherlv_2=Propagation
		{
			newLeafNode(otherlv_2, grammarAccess.getPropagationPointAccess().getPropagationKeyword_2());
		}
		otherlv_3=Point
		{
			newLeafNode(otherlv_3, grammarAccess.getPropagationPointAccess().getPointKeyword_3());
		}
		otherlv_4=Semicolon
		{
			newLeafNode(otherlv_4, grammarAccess.getPropagationPointAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRulePropagationPath
entryRulePropagationPath returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropagationPathRule()); }
	iv_rulePropagationPath=rulePropagationPath
	{ $current=$iv_rulePropagationPath.current; }
	EOF;

// Rule PropagationPath
rulePropagationPath returns [EObject current=null]
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
					lv_name_0_0=RULE_ID
					{
						newLeafNode(lv_name_0_0, grammarAccess.getPropagationPathAccess().getNameIDTerminalRuleCall_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPropagationPathRule());
						}
						setWithLastConsumed(
							$current,
							"name",
							lv_name_0_0,
							"org.osate.xtext.aadl2.properties.Properties.ID");
					}
				)
			)
			otherlv_1=Colon
			{
				newLeafNode(otherlv_1, grammarAccess.getPropagationPathAccess().getColonKeyword_0_1());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getPropagationPathAccess().getSourceQualifiedPropagationPointParserRuleCall_1_0());
				}
				lv_source_2_0=ruleQualifiedPropagationPoint
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPropagationPathRule());
					}
					set(
						$current,
						"source",
						lv_source_2_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.QualifiedPropagationPoint");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=HyphenMinusGreaterThanSign
		{
			newLeafNode(otherlv_3, grammarAccess.getPropagationPathAccess().getHyphenMinusGreaterThanSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getPropagationPathAccess().getTargetQualifiedPropagationPointParserRuleCall_3_0());
				}
				lv_target_4_0=ruleQualifiedPropagationPoint
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPropagationPathRule());
					}
					set(
						$current,
						"target",
						lv_target_4_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.QualifiedPropagationPoint");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5=Semicolon
		{
			newLeafNode(otherlv_5, grammarAccess.getPropagationPathAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRuleQualifiedPropagationPoint
entryRuleQualifiedPropagationPoint returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedPropagationPointRule()); }
	iv_ruleQualifiedPropagationPoint=ruleQualifiedPropagationPoint
	{ $current=$iv_ruleQualifiedPropagationPoint.current; }
	EOF;

// Rule QualifiedPropagationPoint
ruleQualifiedPropagationPoint returns [EObject current=null]
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
						newCompositeNode(grammarAccess.getQualifiedPropagationPointAccess().getSubcomponentSubcomponentElementParserRuleCall_0_0_0());
					}
					lv_subcomponent_0_0=ruleSubcomponentElement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getQualifiedPropagationPointRule());
						}
						set(
							$current,
							"subcomponent",
							lv_subcomponent_0_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.SubcomponentElement");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_1=FullStop
			{
				newLeafNode(otherlv_1, grammarAccess.getQualifiedPropagationPointAccess().getFullStopKeyword_0_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getQualifiedPropagationPointAccess().getNextQualifiedPropagationPointParserRuleCall_0_2_0());
					}
					lv_next_2_0=ruleQualifiedPropagationPoint
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getQualifiedPropagationPointRule());
						}
						set(
							$current,
							"next",
							lv_next_2_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.QualifiedPropagationPoint");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getQualifiedPropagationPointRule());
					}
				}
				otherlv_3=RULE_ID
				{
					newLeafNode(otherlv_3, grammarAccess.getQualifiedPropagationPointAccess().getPropagationPointNamedElementCrossReference_1_0());
				}
			)
		)
	)
;

// Entry rule entryRuleErrorBehaviorStateMachine
entryRuleErrorBehaviorStateMachine returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorBehaviorStateMachineRule()); }
	iv_ruleErrorBehaviorStateMachine=ruleErrorBehaviorStateMachine
	{ $current=$iv_ruleErrorBehaviorStateMachine.current; }
	EOF;

// Rule ErrorBehaviorStateMachine
ruleErrorBehaviorStateMachine returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Error
		{
			newLeafNode(otherlv_0, grammarAccess.getErrorBehaviorStateMachineAccess().getErrorKeyword_0());
		}
		otherlv_1=Behavior
		{
			newLeafNode(otherlv_1, grammarAccess.getErrorBehaviorStateMachineAccess().getBehaviorKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getErrorBehaviorStateMachineAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getErrorBehaviorStateMachineRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		(
			otherlv_3=Use
			{
				newLeafNode(otherlv_3, grammarAccess.getErrorBehaviorStateMachineAccess().getUseKeyword_3_0());
			}
			otherlv_4=Types
			{
				newLeafNode(otherlv_4, grammarAccess.getErrorBehaviorStateMachineAccess().getTypesKeyword_3_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorBehaviorStateMachineRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesErrorModelLibraryCrossReference_3_2_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_6=Comma
				{
					newLeafNode(otherlv_6, grammarAccess.getErrorBehaviorStateMachineAccess().getCommaKeyword_3_3_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getErrorBehaviorStateMachineRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesErrorModelLibraryCrossReference_3_3_1_0());
						}
						ruleQEMREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_8=Semicolon
			{
				newLeafNode(otherlv_8, grammarAccess.getErrorBehaviorStateMachineAccess().getSemicolonKeyword_3_4());
			}
		)?
		(
			otherlv_9=Use
			{
				newLeafNode(otherlv_9, grammarAccess.getErrorBehaviorStateMachineAccess().getUseKeyword_4_0());
			}
			otherlv_10=Transformations
			{
				newLeafNode(otherlv_10, grammarAccess.getErrorBehaviorStateMachineAccess().getTransformationsKeyword_4_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorBehaviorStateMachineRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTransformationTypeTransformationSetCrossReference_4_2_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_12=Semicolon
			{
				newLeafNode(otherlv_12, grammarAccess.getErrorBehaviorStateMachineAccess().getSemicolonKeyword_4_3());
			}
		)?
		(
			otherlv_13=Events
			{
				newLeafNode(otherlv_13, grammarAccess.getErrorBehaviorStateMachineAccess().getEventsKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorBehaviorStateMachineAccess().getEventsErrorBehaviorEventParserRuleCall_5_1_0());
					}
					lv_events_14_0=ruleErrorBehaviorEvent
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorBehaviorStateMachineRule());
						}
						add(
							$current,
							"events",
							lv_events_14_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorEvent");
						afterParserOrEnumRuleCall();
					}
				)
			)+
		)?
		(
			otherlv_15=States
			{
				newLeafNode(otherlv_15, grammarAccess.getErrorBehaviorStateMachineAccess().getStatesKeyword_6_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorBehaviorStateMachineAccess().getStatesErrorBehaviorStateParserRuleCall_6_1_0());
					}
					lv_states_16_0=ruleErrorBehaviorState
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorBehaviorStateMachineRule());
						}
						add(
							$current,
							"states",
							lv_states_16_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorState");
						afterParserOrEnumRuleCall();
					}
				)
			)+
		)?
		(
			otherlv_17=Transitions
			{
				newLeafNode(otherlv_17, grammarAccess.getErrorBehaviorStateMachineAccess().getTransitionsKeyword_7_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorBehaviorStateMachineAccess().getTransitionsErrorBehaviorTransitionParserRuleCall_7_1_0());
					}
					lv_transitions_18_0=ruleErrorBehaviorTransition
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorBehaviorStateMachineRule());
						}
						add(
							$current,
							"transitions",
							lv_transitions_18_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorBehaviorTransition");
						afterParserOrEnumRuleCall();
					}
				)
			)+
		)?
		(
			otherlv_19=Properties
			{
				newLeafNode(otherlv_19, grammarAccess.getErrorBehaviorStateMachineAccess().getPropertiesKeyword_8_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorBehaviorStateMachineAccess().getPropertiesBasicEMV2PropertyAssociationParserRuleCall_8_1_0());
					}
					lv_properties_20_0=ruleBasicEMV2PropertyAssociation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorBehaviorStateMachineRule());
						}
						add(
							$current,
							"properties",
							lv_properties_20_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.BasicEMV2PropertyAssociation");
						afterParserOrEnumRuleCall();
					}
				)
			)+
		)?
		otherlv_21=End
		{
			newLeafNode(otherlv_21, grammarAccess.getErrorBehaviorStateMachineAccess().getEndKeyword_9());
		}
		otherlv_22=Behavior
		{
			newLeafNode(otherlv_22, grammarAccess.getErrorBehaviorStateMachineAccess().getBehaviorKeyword_10());
		}
		otherlv_23=Semicolon
		{
			newLeafNode(otherlv_23, grammarAccess.getErrorBehaviorStateMachineAccess().getSemicolonKeyword_11());
		}
	)
;

// Entry rule entryRuleErrorBehaviorEvent
entryRuleErrorBehaviorEvent returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorBehaviorEventRule()); }
	iv_ruleErrorBehaviorEvent=ruleErrorBehaviorEvent
	{ $current=$iv_ruleErrorBehaviorEvent.current; }
	EOF;

// Rule ErrorBehaviorEvent
ruleErrorBehaviorEvent returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getErrorBehaviorEventAccess().getErrorEventParserRuleCall_0());
		}
		this_ErrorEvent_0=ruleErrorEvent
		{
			$current = $this_ErrorEvent_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getErrorBehaviorEventAccess().getRepairEventParserRuleCall_1());
		}
		this_RepairEvent_1=ruleRepairEvent
		{
			$current = $this_RepairEvent_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getErrorBehaviorEventAccess().getRecoverEventParserRuleCall_2());
		}
		this_RecoverEvent_2=ruleRecoverEvent
		{
			$current = $this_RecoverEvent_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleErrorEvent
entryRuleErrorEvent returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorEventRule()); }
	iv_ruleErrorEvent=ruleErrorEvent
	{ $current=$iv_ruleErrorEvent.current; }
	EOF;

// Rule ErrorEvent
ruleErrorEvent returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getErrorEventAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getErrorEventRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_1=Colon
		{
			newLeafNode(otherlv_1, grammarAccess.getErrorEventAccess().getColonKeyword_1());
		}
		otherlv_2=Error
		{
			newLeafNode(otherlv_2, grammarAccess.getErrorEventAccess().getErrorKeyword_2());
		}
		otherlv_3=Event
		{
			newLeafNode(otherlv_3, grammarAccess.getErrorEventAccess().getEventKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorEventAccess().getTypeSetTypeSetReferenceParserRuleCall_4_0());
				}
				lv_typeSet_4_0=ruleTypeSetReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorEventRule());
					}
					set(
						$current,
						"typeSet",
						lv_typeSet_4_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetReference");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_5=If
			{
				newLeafNode(otherlv_5, grammarAccess.getErrorEventAccess().getIfKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorEventAccess().getEventconditionIfConditionParserRuleCall_5_1_0());
					}
					lv_eventcondition_6_0=ruleIfCondition
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorEventRule());
						}
						set(
							$current,
							"eventcondition",
							lv_eventcondition_6_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.IfCondition");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_7=Semicolon
		{
			newLeafNode(otherlv_7, grammarAccess.getErrorEventAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRuleRepairEvent
entryRuleRepairEvent returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRepairEventRule()); }
	iv_ruleRepairEvent=ruleRepairEvent
	{ $current=$iv_ruleRepairEvent.current; }
	EOF;

// Rule RepairEvent
ruleRepairEvent returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getRepairEventAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRepairEventRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_1=Colon
		{
			newLeafNode(otherlv_1, grammarAccess.getRepairEventAccess().getColonKeyword_1());
		}
		otherlv_2=Repair
		{
			newLeafNode(otherlv_2, grammarAccess.getRepairEventAccess().getRepairKeyword_2());
		}
		otherlv_3=Event
		{
			newLeafNode(otherlv_3, grammarAccess.getRepairEventAccess().getEventKeyword_3());
		}
		(
			otherlv_4=When
			{
				newLeafNode(otherlv_4, grammarAccess.getRepairEventAccess().getWhenKeyword_4_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getRepairEventRule());
						}
					}
					otherlv_5=RULE_ID
					{
						newLeafNode(otherlv_5, grammarAccess.getRepairEventAccess().getEventInitiatorNamedElementCrossReference_4_1_0());
					}
				)
			)
			(
				otherlv_6=Comma
				{
					newLeafNode(otherlv_6, grammarAccess.getRepairEventAccess().getCommaKeyword_4_2_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getRepairEventRule());
							}
						}
						otherlv_7=RULE_ID
						{
							newLeafNode(otherlv_7, grammarAccess.getRepairEventAccess().getEventInitiatorNamedElementCrossReference_4_2_1_0());
						}
					)
				)
			)*
		)?
		otherlv_8=Semicolon
		{
			newLeafNode(otherlv_8, grammarAccess.getRepairEventAccess().getSemicolonKeyword_5());
		}
	)
;

// Entry rule entryRuleRecoverEvent
entryRuleRecoverEvent returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRecoverEventRule()); }
	iv_ruleRecoverEvent=ruleRecoverEvent
	{ $current=$iv_ruleRecoverEvent.current; }
	EOF;

// Rule RecoverEvent
ruleRecoverEvent returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getRecoverEventAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRecoverEventRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_1=Colon
		{
			newLeafNode(otherlv_1, grammarAccess.getRecoverEventAccess().getColonKeyword_1());
		}
		otherlv_2=Recover
		{
			newLeafNode(otherlv_2, grammarAccess.getRecoverEventAccess().getRecoverKeyword_2());
		}
		otherlv_3=Event
		{
			newLeafNode(otherlv_3, grammarAccess.getRecoverEventAccess().getEventKeyword_3());
		}
		(
			otherlv_4=When
			{
				newLeafNode(otherlv_4, grammarAccess.getRecoverEventAccess().getWhenKeyword_4_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getRecoverEventRule());
						}
					}
					otherlv_5=RULE_ID
					{
						newLeafNode(otherlv_5, grammarAccess.getRecoverEventAccess().getEventInitiatorNamedElementCrossReference_4_1_0());
					}
				)
			)
			(
				otherlv_6=Comma
				{
					newLeafNode(otherlv_6, grammarAccess.getRecoverEventAccess().getCommaKeyword_4_2_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getRecoverEventRule());
							}
						}
						otherlv_7=RULE_ID
						{
							newLeafNode(otherlv_7, grammarAccess.getRecoverEventAccess().getEventInitiatorNamedElementCrossReference_4_2_1_0());
						}
					)
				)
			)*
		)?
		(
			otherlv_8=If
			{
				newLeafNode(otherlv_8, grammarAccess.getRecoverEventAccess().getIfKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getRecoverEventAccess().getConditionIfConditionParserRuleCall_5_1_0());
					}
					lv_condition_9_0=ruleIfCondition
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRecoverEventRule());
						}
						set(
							$current,
							"condition",
							lv_condition_9_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.IfCondition");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_10=Semicolon
		{
			newLeafNode(otherlv_10, grammarAccess.getRecoverEventAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRuleErrorBehaviorState
entryRuleErrorBehaviorState returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorBehaviorStateRule()); }
	iv_ruleErrorBehaviorState=ruleErrorBehaviorState
	{ $current=$iv_ruleErrorBehaviorState.current; }
	EOF;

// Rule ErrorBehaviorState
ruleErrorBehaviorState returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getErrorBehaviorStateAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getErrorBehaviorStateRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_1=Colon
		{
			newLeafNode(otherlv_1, grammarAccess.getErrorBehaviorStateAccess().getColonKeyword_1());
		}
		(
			(
				lv_intial_2_0=Initial
				{
					newLeafNode(lv_intial_2_0, grammarAccess.getErrorBehaviorStateAccess().getIntialInitialKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getErrorBehaviorStateRule());
					}
					setWithLastConsumed($current, "intial", true, "initial");
				}
			)
		)?
		otherlv_3=State
		{
			newLeafNode(otherlv_3, grammarAccess.getErrorBehaviorStateAccess().getStateKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorBehaviorStateAccess().getTypeSetTypeSetReferenceParserRuleCall_4_0());
				}
				lv_typeSet_4_0=ruleTypeSetReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorBehaviorStateRule());
					}
					set(
						$current,
						"typeSet",
						lv_typeSet_4_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeSetReference");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_5=Semicolon
		{
			newLeafNode(otherlv_5, grammarAccess.getErrorBehaviorStateAccess().getSemicolonKeyword_5());
		}
	)
;

// Entry rule entryRuleErrorBehaviorTransition
entryRuleErrorBehaviorTransition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorBehaviorTransitionRule()); }
	iv_ruleErrorBehaviorTransition=ruleErrorBehaviorTransition
	{ $current=$iv_ruleErrorBehaviorTransition.current; }
	EOF;

// Rule ErrorBehaviorTransition
ruleErrorBehaviorTransition returns [EObject current=null]
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
					lv_name_0_0=RULE_ID
					{
						newLeafNode(lv_name_0_0, grammarAccess.getErrorBehaviorTransitionAccess().getNameIDTerminalRuleCall_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorBehaviorTransitionRule());
						}
						setWithLastConsumed(
							$current,
							"name",
							lv_name_0_0,
							"org.osate.xtext.aadl2.properties.Properties.ID");
					}
				)
			)
			otherlv_1=Colon
			{
				newLeafNode(otherlv_1, grammarAccess.getErrorBehaviorTransitionAccess().getColonKeyword_0_1());
			}
		)?
		(
			(
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getErrorBehaviorTransitionRule());
							}
						}
						otherlv_2=RULE_ID
						{
							newLeafNode(otherlv_2, grammarAccess.getErrorBehaviorTransitionAccess().getSourceErrorBehaviorStateCrossReference_1_0_0_0());
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorBehaviorTransitionAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0());
						}
						lv_typeTokenConstraint_3_0=ruleTypeTokenConstraint
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorBehaviorTransitionRule());
							}
							set(
								$current,
								"typeTokenConstraint",
								lv_typeTokenConstraint_3_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraint");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)
			    |
			(
				(
					lv_allStates_4_0=All
					{
						newLeafNode(lv_allStates_4_0, grammarAccess.getErrorBehaviorTransitionAccess().getAllStatesAllKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorBehaviorTransitionRule());
						}
						setWithLastConsumed($current, "allStates", true, "all");
					}
				)
			)
		)
		otherlv_5=HyphenMinusLeftSquareBracket
		{
			newLeafNode(otherlv_5, grammarAccess.getErrorBehaviorTransitionAccess().getHyphenMinusLeftSquareBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorBehaviorTransitionAccess().getConditionConditionExpressionParserRuleCall_3_0());
				}
				lv_condition_6_0=ruleConditionExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorBehaviorTransitionRule());
					}
					set(
						$current,
						"condition",
						lv_condition_6_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.ConditionExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7=RightSquareBracketHyphenMinusGreaterThanSign
		{
			newLeafNode(otherlv_7, grammarAccess.getErrorBehaviorTransitionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4());
		}
		(
			(
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getErrorBehaviorTransitionRule());
							}
						}
						otherlv_8=RULE_ID
						{
							newLeafNode(otherlv_8, grammarAccess.getErrorBehaviorTransitionAccess().getTargetErrorBehaviorStateCrossReference_5_0_0_0());
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorBehaviorTransitionAccess().getTargetTokenTypeTokenParserRuleCall_5_0_1_0());
						}
						lv_targetToken_9_0=ruleTypeToken
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorBehaviorTransitionRule());
							}
							set(
								$current,
								"targetToken",
								lv_targetToken_9_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeToken");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)
			    |
			(
				(
					(
						lv_steadyState_10_0=Same
						{
							newLeafNode(lv_steadyState_10_0, grammarAccess.getErrorBehaviorTransitionAccess().getSteadyStateSameKeyword_5_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getErrorBehaviorTransitionRule());
							}
							setWithLastConsumed($current, "steadyState", true, "same");
						}
					)
				)
				otherlv_11=State
				{
					newLeafNode(otherlv_11, grammarAccess.getErrorBehaviorTransitionAccess().getStateKeyword_5_1_1());
				}
			)
			    |
			(
				otherlv_12=LeftParenthesis
				{
					newLeafNode(otherlv_12, grammarAccess.getErrorBehaviorTransitionAccess().getLeftParenthesisKeyword_5_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorBehaviorTransitionAccess().getDestinationBranchesTransitionBranchParserRuleCall_5_2_1_0());
						}
						lv_destinationBranches_13_0=ruleTransitionBranch
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorBehaviorTransitionRule());
							}
							add(
								$current,
								"destinationBranches",
								lv_destinationBranches_13_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.TransitionBranch");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_14=Comma
					{
						newLeafNode(otherlv_14, grammarAccess.getErrorBehaviorTransitionAccess().getCommaKeyword_5_2_2_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getErrorBehaviorTransitionAccess().getDestinationBranchesTransitionBranchParserRuleCall_5_2_2_1_0());
							}
							lv_destinationBranches_15_0=ruleTransitionBranch
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getErrorBehaviorTransitionRule());
								}
								add(
									$current,
									"destinationBranches",
									lv_destinationBranches_15_0,
									"org.osate.xtext.aadl2.errormodel.ErrorModel.TransitionBranch");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)+
				otherlv_16=RightParenthesis
				{
					newLeafNode(otherlv_16, grammarAccess.getErrorBehaviorTransitionAccess().getRightParenthesisKeyword_5_2_3());
				}
			)
		)
		otherlv_17=Semicolon
		{
			newLeafNode(otherlv_17, grammarAccess.getErrorBehaviorTransitionAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRuleTransitionBranch
entryRuleTransitionBranch returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransitionBranchRule()); }
	iv_ruleTransitionBranch=ruleTransitionBranch
	{ $current=$iv_ruleTransitionBranch.current; }
	EOF;

// Rule TransitionBranch
ruleTransitionBranch returns [EObject current=null]
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
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getTransitionBranchRule());
							}
						}
						otherlv_0=RULE_ID
						{
							newLeafNode(otherlv_0, grammarAccess.getTransitionBranchAccess().getTargetErrorBehaviorStateCrossReference_0_0_0_0());
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getTransitionBranchAccess().getTargetTokenTypeTokenParserRuleCall_0_0_1_0());
						}
						lv_targetToken_1_0=ruleTypeToken
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTransitionBranchRule());
							}
							set(
								$current,
								"targetToken",
								lv_targetToken_1_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeToken");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)
			    |
			(
				(
					(
						lv_steadyState_2_0=Same
						{
							newLeafNode(lv_steadyState_2_0, grammarAccess.getTransitionBranchAccess().getSteadyStateSameKeyword_0_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getTransitionBranchRule());
							}
							setWithLastConsumed($current, "steadyState", true, "same");
						}
					)
				)
				otherlv_3=State
				{
					newLeafNode(otherlv_3, grammarAccess.getTransitionBranchAccess().getStateKeyword_0_1_1());
				}
			)
		)
		otherlv_4=With
		{
			newLeafNode(otherlv_4, grammarAccess.getTransitionBranchAccess().getWithKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTransitionBranchAccess().getValueBranchValueParserRuleCall_2_0());
				}
				lv_value_5_0=ruleBranchValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransitionBranchRule());
					}
					set(
						$current,
						"value",
						lv_value_5_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.BranchValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleBranchValue
entryRuleBranchValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBranchValueRule()); }
	iv_ruleBranchValue=ruleBranchValue
	{ $current=$iv_ruleBranchValue.current; }
	EOF;

// Rule BranchValue
ruleBranchValue returns [EObject current=null]
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
					grammarAccess.getBranchValueAccess().getBranchValueAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_realvalue_1_0=RULE_REAL_LIT
					{
						newLeafNode(lv_realvalue_1_0, grammarAccess.getBranchValueAccess().getRealvalueREAL_LITTerminalRuleCall_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBranchValueRule());
						}
						setWithLastConsumed(
							$current,
							"realvalue",
							lv_realvalue_1_0,
							"org.osate.xtext.aadl2.properties.Properties.REAL_LIT");
					}
				)
			)
			    |
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBranchValueRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getBranchValueAccess().getSymboliclabelPropertyCrossReference_1_1_0());
					}
					ruleQEMREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					lv_others_3_0=Others
					{
						newLeafNode(lv_others_3_0, grammarAccess.getBranchValueAccess().getOthersOthersKeyword_1_2_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBranchValueRule());
						}
						setWithLastConsumed($current, "others", true, "others");
					}
				)
			)
		)
	)
;

// Entry rule entryRuleConditionExpression
entryRuleConditionExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConditionExpressionRule()); }
	iv_ruleConditionExpression=ruleConditionExpression
	{ $current=$iv_ruleConditionExpression.current; }
	EOF;

// Rule ConditionExpression
ruleConditionExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getConditionExpressionAccess().getAndExpressionParserRuleCall_0());
		}
		this_AndExpression_0=ruleAndExpression
		{
			$current = $this_AndExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getConditionExpressionAccess().getOrExpressionOperandsAction_1_0(),
						$current);
				}
			)
			otherlv_2=Or
			{
				newLeafNode(otherlv_2, grammarAccess.getConditionExpressionAccess().getOrKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getConditionExpressionAccess().getOperandsAndExpressionParserRuleCall_1_2_0());
					}
					lv_operands_3_0=ruleAndExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConditionExpressionRule());
						}
						add(
							$current,
							"operands",
							lv_operands_3_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.AndExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleAndExpression
entryRuleAndExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAndExpressionRule()); }
	iv_ruleAndExpression=ruleAndExpression
	{ $current=$iv_ruleAndExpression.current; }
	EOF;

// Rule AndExpression
ruleAndExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAndExpressionAccess().getConditionTermParserRuleCall_0());
		}
		this_ConditionTerm_0=ruleConditionTerm
		{
			$current = $this_ConditionTerm_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0(),
						$current);
				}
			)
			otherlv_2=And
			{
				newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAndKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getAndExpressionAccess().getOperandsConditionTermParserRuleCall_1_2_0());
					}
					lv_operands_3_0=ruleConditionTerm
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAndExpressionRule());
						}
						add(
							$current,
							"operands",
							lv_operands_3_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.ConditionTerm");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleAllExpression
entryRuleAllExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAllExpressionRule()); }
	iv_ruleAllExpression=ruleAllExpression
	{ $current=$iv_ruleAllExpression.current; }
	EOF;

// Rule AllExpression
ruleAllExpression returns [EObject current=null]
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
					grammarAccess.getAllExpressionAccess().getAllExpressionAction_0(),
					$current);
			}
		)
		otherlv_1=All
		{
			newLeafNode(otherlv_1, grammarAccess.getAllExpressionAccess().getAllKeyword_1());
		}
		(
			otherlv_2=HyphenMinus
			{
				newLeafNode(otherlv_2, grammarAccess.getAllExpressionAccess().getHyphenMinusKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getAllExpressionAccess().getCountINTVALUEParserRuleCall_2_1_0());
					}
					lv_count_3_0=ruleINTVALUE
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAllExpressionRule());
						}
						set(
							$current,
							"count",
							lv_count_3_0,
							"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_4=LeftParenthesis
		{
			newLeafNode(otherlv_4, grammarAccess.getAllExpressionAccess().getLeftParenthesisKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAllExpressionAccess().getOperandsConditionElementParserRuleCall_4_0());
				}
				lv_operands_5_0=ruleConditionElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAllExpressionRule());
					}
					add(
						$current,
						"operands",
						lv_operands_5_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.ConditionElement");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_6=Comma
			{
				newLeafNode(otherlv_6, grammarAccess.getAllExpressionAccess().getCommaKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getAllExpressionAccess().getOperandsConditionElementParserRuleCall_5_1_0());
					}
					lv_operands_7_0=ruleConditionElement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAllExpressionRule());
						}
						add(
							$current,
							"operands",
							lv_operands_7_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.ConditionElement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_8=RightParenthesis
		{
			newLeafNode(otherlv_8, grammarAccess.getAllExpressionAccess().getRightParenthesisKeyword_6());
		}
	)
;

// Entry rule entryRuleOrmoreExpression
entryRuleOrmoreExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOrmoreExpressionRule()); }
	iv_ruleOrmoreExpression=ruleOrmoreExpression
	{ $current=$iv_ruleOrmoreExpression.current; }
	EOF;

// Rule OrmoreExpression
ruleOrmoreExpression returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getOrmoreExpressionAccess().getCountINTVALUEParserRuleCall_0_0());
				}
				lv_count_0_0=ruleINTVALUE
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOrmoreExpressionRule());
					}
					set(
						$current,
						"count",
						lv_count_0_0,
						"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=Ormore
		{
			newLeafNode(otherlv_1, grammarAccess.getOrmoreExpressionAccess().getOrmoreKeyword_1());
		}
		otherlv_2=LeftParenthesis
		{
			newLeafNode(otherlv_2, grammarAccess.getOrmoreExpressionAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getOrmoreExpressionAccess().getOperandsConditionExpressionParserRuleCall_3_0());
				}
				lv_operands_3_0=ruleConditionExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOrmoreExpressionRule());
					}
					add(
						$current,
						"operands",
						lv_operands_3_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.ConditionExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4=Comma
			{
				newLeafNode(otherlv_4, grammarAccess.getOrmoreExpressionAccess().getCommaKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getOrmoreExpressionAccess().getOperandsConditionExpressionParserRuleCall_4_1_0());
					}
					lv_operands_5_0=ruleConditionExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOrmoreExpressionRule());
						}
						add(
							$current,
							"operands",
							lv_operands_5_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.ConditionExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_6=RightParenthesis
		{
			newLeafNode(otherlv_6, grammarAccess.getOrmoreExpressionAccess().getRightParenthesisKeyword_5());
		}
	)
;

// Entry rule entryRuleOrlessExpression
entryRuleOrlessExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOrlessExpressionRule()); }
	iv_ruleOrlessExpression=ruleOrlessExpression
	{ $current=$iv_ruleOrlessExpression.current; }
	EOF;

// Rule OrlessExpression
ruleOrlessExpression returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getOrlessExpressionAccess().getCountINTVALUEParserRuleCall_0_0());
				}
				lv_count_0_0=ruleINTVALUE
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOrlessExpressionRule());
					}
					set(
						$current,
						"count",
						lv_count_0_0,
						"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=Orless
		{
			newLeafNode(otherlv_1, grammarAccess.getOrlessExpressionAccess().getOrlessKeyword_1());
		}
		otherlv_2=LeftParenthesis
		{
			newLeafNode(otherlv_2, grammarAccess.getOrlessExpressionAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getOrlessExpressionAccess().getOperandsConditionExpressionParserRuleCall_3_0());
				}
				lv_operands_3_0=ruleConditionExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOrlessExpressionRule());
					}
					add(
						$current,
						"operands",
						lv_operands_3_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.ConditionExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4=Comma
			{
				newLeafNode(otherlv_4, grammarAccess.getOrlessExpressionAccess().getCommaKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getOrlessExpressionAccess().getOperandsConditionExpressionParserRuleCall_4_1_0());
					}
					lv_operands_5_0=ruleConditionExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOrlessExpressionRule());
						}
						add(
							$current,
							"operands",
							lv_operands_5_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.ConditionExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_6=RightParenthesis
		{
			newLeafNode(otherlv_6, grammarAccess.getOrlessExpressionAccess().getRightParenthesisKeyword_5());
		}
	)
;

// Entry rule entryRuleConditionTerm
entryRuleConditionTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConditionTermRule()); }
	iv_ruleConditionTerm=ruleConditionTerm
	{ $current=$iv_ruleConditionTerm.current; }
	EOF;

// Rule ConditionTerm
ruleConditionTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getConditionTermAccess().getConditionElementParserRuleCall_0());
		}
		this_ConditionElement_0=ruleConditionElement
		{
			$current = $this_ConditionElement_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getConditionTermAccess().getOrmoreExpressionParserRuleCall_1());
		}
		this_OrmoreExpression_1=ruleOrmoreExpression
		{
			$current = $this_OrmoreExpression_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getConditionTermAccess().getOrlessExpressionParserRuleCall_2());
		}
		this_OrlessExpression_2=ruleOrlessExpression
		{
			$current = $this_OrlessExpression_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getConditionTermAccess().getAllExpressionParserRuleCall_3());
		}
		this_AllExpression_3=ruleAllExpression
		{
			$current = $this_AllExpression_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			otherlv_4=LeftParenthesis
			{
				newLeafNode(otherlv_4, grammarAccess.getConditionTermAccess().getLeftParenthesisKeyword_4_0());
			}
			{
				newCompositeNode(grammarAccess.getConditionTermAccess().getConditionExpressionParserRuleCall_4_1());
			}
			this_ConditionExpression_5=ruleConditionExpression
			{
				$current = $this_ConditionExpression_5.current;
				afterParserOrEnumRuleCall();
			}
			otherlv_6=RightParenthesis
			{
				newLeafNode(otherlv_6, grammarAccess.getConditionTermAccess().getRightParenthesisKeyword_4_2());
			}
		)
	)
;

// Entry rule entryRuleConditionElement
entryRuleConditionElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConditionElementRule()); }
	iv_ruleConditionElement=ruleConditionElement
	{ $current=$iv_ruleConditionElement.current; }
	EOF;

// Rule ConditionElement
ruleConditionElement returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getConditionElementAccess().getQualifiedErrorPropagationReferenceQualifiedErrorEventOrPropagationParserRuleCall_0_0());
				}
				lv_qualifiedErrorPropagationReference_0_0=ruleQualifiedErrorEventOrPropagation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConditionElementRule());
					}
					set(
						$current,
						"qualifiedErrorPropagationReference",
						lv_qualifiedErrorPropagationReference_0_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.QualifiedErrorEventOrPropagation");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getConditionElementAccess().getConstraintTypeTokenConstraintNoErrorParserRuleCall_1_0());
				}
				lv_constraint_1_0=ruleTypeTokenConstraintNoError
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConditionElementRule());
					}
					set(
						$current,
						"constraint",
						lv_constraint_1_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraintNoError");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleQualifiedErrorEventOrPropagation
entryRuleQualifiedErrorEventOrPropagation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedErrorEventOrPropagationRule()); }
	iv_ruleQualifiedErrorEventOrPropagation=ruleQualifiedErrorEventOrPropagation
	{ $current=$iv_ruleQualifiedErrorEventOrPropagation.current; }
	EOF;

// Rule QualifiedErrorEventOrPropagation
ruleQualifiedErrorEventOrPropagation returns [EObject current=null]
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
					grammarAccess.getQualifiedErrorEventOrPropagationAccess().getQualifiedErrorEventOrPropagationAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getQualifiedErrorEventOrPropagationAccess().getEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0());
				}
				lv_emv2Target_1_0=ruleEMV2ErrorPropagationPath
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getQualifiedErrorEventOrPropagationRule());
					}
					set(
						$current,
						"emv2Target",
						lv_emv2Target_1_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2ErrorPropagationPath");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleEMV2ErrorPropagationPath
entryRuleEMV2ErrorPropagationPath returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEMV2ErrorPropagationPathRule()); }
	iv_ruleEMV2ErrorPropagationPath=ruleEMV2ErrorPropagationPath
	{ $current=$iv_ruleEMV2ErrorPropagationPath.current; }
	EOF;

// Rule EMV2ErrorPropagationPath
ruleEMV2ErrorPropagationPath returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getEMV2ErrorPropagationPathAccess().getEmv2PropagationKindPropagationKindParserRuleCall_0_0());
				}
				lv_emv2PropagationKind_0_0=rulePropagationKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEMV2ErrorPropagationPathRule());
					}
					set(
						$current,
						"emv2PropagationKind",
						lv_emv2PropagationKind_0_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.PropagationKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEMV2ErrorPropagationPathRule());
						}
					}
					otherlv_1=RULE_ID
					{
						newLeafNode(otherlv_1, grammarAccess.getEMV2ErrorPropagationPathAccess().getNamedElementNamedElementCrossReference_1_0_0());
					}
				)
			)
			(
				otherlv_2=FullStop
				{
					newLeafNode(otherlv_2, grammarAccess.getEMV2ErrorPropagationPathAccess().getFullStopKeyword_1_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEMV2ErrorPropagationPathAccess().getPathEMV2ErrorPropagationPathParserRuleCall_1_1_1_0());
						}
						lv_path_3_0=ruleEMV2ErrorPropagationPath
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEMV2ErrorPropagationPathRule());
							}
							set(
								$current,
								"path",
								lv_path_3_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2ErrorPropagationPath");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)
	)
;

// Entry rule entryRuleEventOrPropagation
entryRuleEventOrPropagation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEventOrPropagationRule()); }
	iv_ruleEventOrPropagation=ruleEventOrPropagation
	{ $current=$iv_ruleEventOrPropagation.current; }
	EOF;

// Rule EventOrPropagation
ruleEventOrPropagation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getEventOrPropagationAccess().getErrorBehaviorEventParserRuleCall_0());
		}
		this_ErrorBehaviorEvent_0=ruleErrorBehaviorEvent
		{
			$current = $this_ErrorBehaviorEvent_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getEventOrPropagationAccess().getErrorPropagationParserRuleCall_1());
		}
		this_ErrorPropagation_1=ruleErrorPropagation
		{
			$current = $this_ErrorPropagation_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleOutgoingPropagationCondition
entryRuleOutgoingPropagationCondition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOutgoingPropagationConditionRule()); }
	iv_ruleOutgoingPropagationCondition=ruleOutgoingPropagationCondition
	{ $current=$iv_ruleOutgoingPropagationCondition.current; }
	EOF;

// Rule OutgoingPropagationCondition
ruleOutgoingPropagationCondition returns [EObject current=null]
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
					lv_name_0_0=RULE_ID
					{
						newLeafNode(lv_name_0_0, grammarAccess.getOutgoingPropagationConditionAccess().getNameIDTerminalRuleCall_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getOutgoingPropagationConditionRule());
						}
						setWithLastConsumed(
							$current,
							"name",
							lv_name_0_0,
							"org.osate.xtext.aadl2.properties.Properties.ID");
					}
				)
			)
			otherlv_1=Colon
			{
				newLeafNode(otherlv_1, grammarAccess.getOutgoingPropagationConditionAccess().getColonKeyword_0_1());
			}
		)?
		(
			(
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getOutgoingPropagationConditionRule());
							}
						}
						otherlv_2=RULE_ID
						{
							newLeafNode(otherlv_2, grammarAccess.getOutgoingPropagationConditionAccess().getStateErrorBehaviorStateCrossReference_1_0_0_0());
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getOutgoingPropagationConditionAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0());
						}
						lv_typeTokenConstraint_3_0=ruleTypeTokenConstraint
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getOutgoingPropagationConditionRule());
							}
							set(
								$current,
								"typeTokenConstraint",
								lv_typeTokenConstraint_3_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraint");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)
			    |
			(
				(
					lv_allStates_4_0=All
					{
						newLeafNode(lv_allStates_4_0, grammarAccess.getOutgoingPropagationConditionAccess().getAllStatesAllKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getOutgoingPropagationConditionRule());
						}
						setWithLastConsumed($current, "allStates", true, "all");
					}
				)
			)
		)
		otherlv_5=HyphenMinusLeftSquareBracket
		{
			newLeafNode(otherlv_5, grammarAccess.getOutgoingPropagationConditionAccess().getHyphenMinusLeftSquareBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getOutgoingPropagationConditionAccess().getConditionConditionExpressionParserRuleCall_3_0());
				}
				lv_condition_6_0=ruleConditionExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOutgoingPropagationConditionRule());
					}
					set(
						$current,
						"condition",
						lv_condition_6_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.ConditionExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_7=RightSquareBracketHyphenMinusGreaterThanSign
		{
			newLeafNode(otherlv_7, grammarAccess.getOutgoingPropagationConditionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4());
		}
		(
			(
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getOutgoingPropagationConditionRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getOutgoingPropagationConditionAccess().getOutgoingErrorPropagationCrossReference_5_0_0_0());
						}
						ruleErrorPropagationPoint
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					(
						lv_allPropagations_9_0=All
						{
							newLeafNode(lv_allPropagations_9_0, grammarAccess.getOutgoingPropagationConditionAccess().getAllPropagationsAllKeyword_5_0_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getOutgoingPropagationConditionRule());
							}
							setWithLastConsumed($current, "allPropagations", true, "all");
						}
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getOutgoingPropagationConditionAccess().getTypeTokenTypeTokenOrNoErrorParserRuleCall_5_1_0());
					}
					lv_typeToken_10_0=ruleTypeTokenOrNoError
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOutgoingPropagationConditionRule());
						}
						set(
							$current,
							"typeToken",
							lv_typeToken_10_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenOrNoError");
						afterParserOrEnumRuleCall();
					}
				)
			)?
		)
		otherlv_11=Semicolon
		{
			newLeafNode(otherlv_11, grammarAccess.getOutgoingPropagationConditionAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRuleErrorDetection
entryRuleErrorDetection returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorDetectionRule()); }
	iv_ruleErrorDetection=ruleErrorDetection
	{ $current=$iv_ruleErrorDetection.current; }
	EOF;

// Rule ErrorDetection
ruleErrorDetection returns [EObject current=null]
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
					lv_name_0_0=RULE_ID
					{
						newLeafNode(lv_name_0_0, grammarAccess.getErrorDetectionAccess().getNameIDTerminalRuleCall_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorDetectionRule());
						}
						setWithLastConsumed(
							$current,
							"name",
							lv_name_0_0,
							"org.osate.xtext.aadl2.properties.Properties.ID");
					}
				)
			)
			otherlv_1=Colon
			{
				newLeafNode(otherlv_1, grammarAccess.getErrorDetectionAccess().getColonKeyword_0_1());
			}
		)?
		(
			(
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getErrorDetectionRule());
							}
						}
						otherlv_2=RULE_ID
						{
							newLeafNode(otherlv_2, grammarAccess.getErrorDetectionAccess().getStateErrorBehaviorStateCrossReference_1_0_0_0());
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getErrorDetectionAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0());
						}
						lv_typeTokenConstraint_3_0=ruleTypeTokenConstraint
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getErrorDetectionRule());
							}
							set(
								$current,
								"typeTokenConstraint",
								lv_typeTokenConstraint_3_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraint");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)
			    |
			(
				(
					lv_allStates_4_0=All
					{
						newLeafNode(lv_allStates_4_0, grammarAccess.getErrorDetectionAccess().getAllStatesAllKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorDetectionRule());
						}
						setWithLastConsumed($current, "allStates", true, "all");
					}
				)
			)
		)
		otherlv_5=HyphenMinusLeftSquareBracket
		{
			newLeafNode(otherlv_5, grammarAccess.getErrorDetectionAccess().getHyphenMinusLeftSquareBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorDetectionAccess().getConditionConditionExpressionParserRuleCall_3_0());
				}
				lv_condition_6_0=ruleConditionExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorDetectionRule());
					}
					set(
						$current,
						"condition",
						lv_condition_6_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.ConditionExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_7=RightSquareBracketHyphenMinusGreaterThanSign
		{
			newLeafNode(otherlv_7, grammarAccess.getErrorDetectionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorDetectionAccess().getDetectionReportingPortReportingPortReferenceParserRuleCall_5_0());
				}
				lv_detectionReportingPort_8_0=ruleReportingPortReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorDetectionRule());
					}
					set(
						$current,
						"detectionReportingPort",
						lv_detectionReportingPort_8_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.ReportingPortReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_9=ExclamationMark
		{
			newLeafNode(otherlv_9, grammarAccess.getErrorDetectionAccess().getExclamationMarkKeyword_6());
		}
		(
			otherlv_10=LeftParenthesis
			{
				newLeafNode(otherlv_10, grammarAccess.getErrorDetectionAccess().getLeftParenthesisKeyword_7_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getErrorDetectionAccess().getErrorCodeErrorCodeValueParserRuleCall_7_1_0());
					}
					lv_errorCode_11_0=ruleErrorCodeValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getErrorDetectionRule());
						}
						set(
							$current,
							"errorCode",
							lv_errorCode_11_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.ErrorCodeValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_12=RightParenthesis
			{
				newLeafNode(otherlv_12, grammarAccess.getErrorDetectionAccess().getRightParenthesisKeyword_7_2());
			}
		)?
		otherlv_13=Semicolon
		{
			newLeafNode(otherlv_13, grammarAccess.getErrorDetectionAccess().getSemicolonKeyword_8());
		}
	)
;

// Entry rule entryRuleReportingPortReference
entryRuleReportingPortReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReportingPortReferenceRule()); }
	iv_ruleReportingPortReference=ruleReportingPortReference
	{ $current=$iv_ruleReportingPortReference.current; }
	EOF;

// Rule ReportingPortReference
ruleReportingPortReference returns [EObject current=null]
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
						$current = createModelElement(grammarAccess.getReportingPortReferenceRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getReportingPortReferenceAccess().getElementNamedElementCrossReference_0_0());
				}
			)
		)
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getReportingPortReferenceAccess().getReportingPortReferencePreviousAction_1_0(),
						$current);
				}
			)
			otherlv_2=FullStop
			{
				newLeafNode(otherlv_2, grammarAccess.getReportingPortReferenceAccess().getFullStopKeyword_1_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getReportingPortReferenceRule());
						}
					}
					otherlv_3=RULE_ID
					{
						newLeafNode(otherlv_3, grammarAccess.getReportingPortReferenceAccess().getElementNamedElementCrossReference_1_2_0());
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleErrorCodeValue
entryRuleErrorCodeValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorCodeValueRule()); }
	iv_ruleErrorCodeValue=ruleErrorCodeValue
	{ $current=$iv_ruleErrorCodeValue.current; }
	EOF;

// Rule ErrorCodeValue
ruleErrorCodeValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_intValue_0_0=RULE_INTEGER_LIT
				{
					newLeafNode(lv_intValue_0_0, grammarAccess.getErrorCodeValueAccess().getIntValueINTEGER_LITTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getErrorCodeValueRule());
					}
					setWithLastConsumed(
						$current,
						"intValue",
						lv_intValue_0_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.INTEGER_LIT");
				}
			)
		)
		    |
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getErrorCodeValueRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getErrorCodeValueAccess().getConstantPropertyConstantCrossReference_1_0());
				}
				ruleQPREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				lv_enumLiteral_2_0=RULE_STRING
				{
					newLeafNode(lv_enumLiteral_2_0, grammarAccess.getErrorCodeValueAccess().getEnumLiteralSTRINGTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getErrorCodeValueRule());
					}
					setWithLastConsumed(
						$current,
						"enumLiteral",
						lv_enumLiteral_2_0,
						"org.osate.xtext.aadl2.properties.Properties.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleErrorStateToModeMapping
entryRuleErrorStateToModeMapping returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getErrorStateToModeMappingRule()); }
	iv_ruleErrorStateToModeMapping=ruleErrorStateToModeMapping
	{ $current=$iv_ruleErrorStateToModeMapping.current; }
	EOF;

// Rule ErrorStateToModeMapping
ruleErrorStateToModeMapping returns [EObject current=null]
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
						$current = createModelElement(grammarAccess.getErrorStateToModeMappingRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getErrorStateToModeMappingAccess().getErrorStateErrorBehaviorStateCrossReference_0_0());
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getErrorStateToModeMappingAccess().getTypeTokenTypeTokenParserRuleCall_1_0());
				}
				lv_typeToken_1_0=ruleTypeToken
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getErrorStateToModeMappingRule());
					}
					set(
						$current,
						"typeToken",
						lv_typeToken_1_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeToken");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_2=In
		{
			newLeafNode(otherlv_2, grammarAccess.getErrorStateToModeMappingAccess().getInKeyword_2());
		}
		otherlv_3=Modes
		{
			newLeafNode(otherlv_3, grammarAccess.getErrorStateToModeMappingAccess().getModesKeyword_3());
		}
		otherlv_4=LeftParenthesis
		{
			newLeafNode(otherlv_4, grammarAccess.getErrorStateToModeMappingAccess().getLeftParenthesisKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getErrorStateToModeMappingRule());
					}
				}
				otherlv_5=RULE_ID
				{
					newLeafNode(otherlv_5, grammarAccess.getErrorStateToModeMappingAccess().getMappedModesModeCrossReference_5_0());
				}
			)
		)
		(
			otherlv_6=Comma
			{
				newLeafNode(otherlv_6, grammarAccess.getErrorStateToModeMappingAccess().getCommaKeyword_6_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getErrorStateToModeMappingRule());
						}
					}
					otherlv_7=RULE_ID
					{
						newLeafNode(otherlv_7, grammarAccess.getErrorStateToModeMappingAccess().getMappedModesModeCrossReference_6_1_0());
					}
				)
			)
		)*
		otherlv_8=RightParenthesis
		{
			newLeafNode(otherlv_8, grammarAccess.getErrorStateToModeMappingAccess().getRightParenthesisKeyword_7());
		}
		otherlv_9=Semicolon
		{
			newLeafNode(otherlv_9, grammarAccess.getErrorStateToModeMappingAccess().getSemicolonKeyword_8());
		}
	)
;

// Entry rule entryRuleCompositeState
entryRuleCompositeState returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCompositeStateRule()); }
	iv_ruleCompositeState=ruleCompositeState
	{ $current=$iv_ruleCompositeState.current; }
	EOF;

// Rule CompositeState
ruleCompositeState returns [EObject current=null]
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
					lv_name_0_0=RULE_ID
					{
						newLeafNode(lv_name_0_0, grammarAccess.getCompositeStateAccess().getNameIDTerminalRuleCall_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getCompositeStateRule());
						}
						setWithLastConsumed(
							$current,
							"name",
							lv_name_0_0,
							"org.osate.xtext.aadl2.properties.Properties.ID");
					}
				)
			)
			otherlv_1=Colon
			{
				newLeafNode(otherlv_1, grammarAccess.getCompositeStateAccess().getColonKeyword_0_1());
			}
		)?
		otherlv_2=LeftSquareBracket
		{
			newLeafNode(otherlv_2, grammarAccess.getCompositeStateAccess().getLeftSquareBracketKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getCompositeStateAccess().getConditionSConditionExpressionParserRuleCall_2_0_0());
					}
					lv_condition_3_0=ruleSConditionExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
						}
						set(
							$current,
							"condition",
							lv_condition_3_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.SConditionExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					lv_others_4_0=Others
					{
						newLeafNode(lv_others_4_0, grammarAccess.getCompositeStateAccess().getOthersOthersKeyword_2_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getCompositeStateRule());
						}
						setWithLastConsumed($current, "others", true, "others");
					}
				)
			)
		)
		otherlv_5=RightSquareBracketHyphenMinusGreaterThanSign
		{
			newLeafNode(otherlv_5, grammarAccess.getCompositeStateAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCompositeStateRule());
					}
				}
				otherlv_6=RULE_ID
				{
					newLeafNode(otherlv_6, grammarAccess.getCompositeStateAccess().getStateErrorBehaviorStateCrossReference_4_0());
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getCompositeStateAccess().getTypedTokenTypeTokenParserRuleCall_5_0());
				}
				lv_typedToken_7_0=ruleTypeToken
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCompositeStateRule());
					}
					set(
						$current,
						"typedToken",
						lv_typedToken_7_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeToken");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_8=Semicolon
		{
			newLeafNode(otherlv_8, grammarAccess.getCompositeStateAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRuleSConditionExpression
entryRuleSConditionExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSConditionExpressionRule()); }
	iv_ruleSConditionExpression=ruleSConditionExpression
	{ $current=$iv_ruleSConditionExpression.current; }
	EOF;

// Rule SConditionExpression
ruleSConditionExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getSConditionExpressionAccess().getSAndExpressionParserRuleCall_0());
		}
		this_SAndExpression_0=ruleSAndExpression
		{
			$current = $this_SAndExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getSConditionExpressionAccess().getOrExpressionOperandsAction_1_0(),
						$current);
				}
			)
			otherlv_2=Or
			{
				newLeafNode(otherlv_2, grammarAccess.getSConditionExpressionAccess().getOrKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSConditionExpressionAccess().getOperandsSAndExpressionParserRuleCall_1_2_0());
					}
					lv_operands_3_0=ruleSAndExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSConditionExpressionRule());
						}
						add(
							$current,
							"operands",
							lv_operands_3_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.SAndExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleSAndExpression
entryRuleSAndExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSAndExpressionRule()); }
	iv_ruleSAndExpression=ruleSAndExpression
	{ $current=$iv_ruleSAndExpression.current; }
	EOF;

// Rule SAndExpression
ruleSAndExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getSAndExpressionAccess().getSConditionTermParserRuleCall_0());
		}
		this_SConditionTerm_0=ruleSConditionTerm
		{
			$current = $this_SConditionTerm_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndAdd(
						grammarAccess.getSAndExpressionAccess().getAndExpressionOperandsAction_1_0(),
						$current);
				}
			)
			otherlv_2=And
			{
				newLeafNode(otherlv_2, grammarAccess.getSAndExpressionAccess().getAndKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSAndExpressionAccess().getOperandsSConditionTermParserRuleCall_1_2_0());
					}
					lv_operands_3_0=ruleSConditionTerm
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSAndExpressionRule());
						}
						add(
							$current,
							"operands",
							lv_operands_3_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.SConditionTerm");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleSOrmoreExpression
entryRuleSOrmoreExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSOrmoreExpressionRule()); }
	iv_ruleSOrmoreExpression=ruleSOrmoreExpression
	{ $current=$iv_ruleSOrmoreExpression.current; }
	EOF;

// Rule SOrmoreExpression
ruleSOrmoreExpression returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getSOrmoreExpressionAccess().getCountINTVALUEParserRuleCall_0_0());
				}
				lv_count_0_0=ruleINTVALUE
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSOrmoreExpressionRule());
					}
					set(
						$current,
						"count",
						lv_count_0_0,
						"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=Ormore
		{
			newLeafNode(otherlv_1, grammarAccess.getSOrmoreExpressionAccess().getOrmoreKeyword_1());
		}
		otherlv_2=LeftParenthesis
		{
			newLeafNode(otherlv_2, grammarAccess.getSOrmoreExpressionAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSOrmoreExpressionAccess().getOperandsSConditionExpressionParserRuleCall_3_0());
				}
				lv_operands_3_0=ruleSConditionExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSOrmoreExpressionRule());
					}
					add(
						$current,
						"operands",
						lv_operands_3_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.SConditionExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4=Comma
			{
				newLeafNode(otherlv_4, grammarAccess.getSOrmoreExpressionAccess().getCommaKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSOrmoreExpressionAccess().getOperandsSConditionExpressionParserRuleCall_4_1_0());
					}
					lv_operands_5_0=ruleSConditionExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSOrmoreExpressionRule());
						}
						add(
							$current,
							"operands",
							lv_operands_5_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.SConditionExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_6=RightParenthesis
		{
			newLeafNode(otherlv_6, grammarAccess.getSOrmoreExpressionAccess().getRightParenthesisKeyword_5());
		}
	)
;

// Entry rule entryRuleSOrlessExpression
entryRuleSOrlessExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSOrlessExpressionRule()); }
	iv_ruleSOrlessExpression=ruleSOrlessExpression
	{ $current=$iv_ruleSOrlessExpression.current; }
	EOF;

// Rule SOrlessExpression
ruleSOrlessExpression returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getSOrlessExpressionAccess().getCountINTVALUEParserRuleCall_0_0());
				}
				lv_count_0_0=ruleINTVALUE
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSOrlessExpressionRule());
					}
					set(
						$current,
						"count",
						lv_count_0_0,
						"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=Orless
		{
			newLeafNode(otherlv_1, grammarAccess.getSOrlessExpressionAccess().getOrlessKeyword_1());
		}
		otherlv_2=LeftParenthesis
		{
			newLeafNode(otherlv_2, grammarAccess.getSOrlessExpressionAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSOrlessExpressionAccess().getOperandsSConditionExpressionParserRuleCall_3_0());
				}
				lv_operands_3_0=ruleSConditionExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSOrlessExpressionRule());
					}
					add(
						$current,
						"operands",
						lv_operands_3_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.SConditionExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4=Comma
			{
				newLeafNode(otherlv_4, grammarAccess.getSOrlessExpressionAccess().getCommaKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSOrlessExpressionAccess().getOperandsSConditionExpressionParserRuleCall_4_1_0());
					}
					lv_operands_5_0=ruleSConditionExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSOrlessExpressionRule());
						}
						add(
							$current,
							"operands",
							lv_operands_5_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.SConditionExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_6=RightParenthesis
		{
			newLeafNode(otherlv_6, grammarAccess.getSOrlessExpressionAccess().getRightParenthesisKeyword_5());
		}
	)
;

// Entry rule entryRuleSAllExpression
entryRuleSAllExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSAllExpressionRule()); }
	iv_ruleSAllExpression=ruleSAllExpression
	{ $current=$iv_ruleSAllExpression.current; }
	EOF;

// Rule SAllExpression
ruleSAllExpression returns [EObject current=null]
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
					grammarAccess.getSAllExpressionAccess().getAllExpressionAction_0(),
					$current);
			}
		)
		otherlv_1=All
		{
			newLeafNode(otherlv_1, grammarAccess.getSAllExpressionAccess().getAllKeyword_1());
		}
		(
			otherlv_2=HyphenMinus
			{
				newLeafNode(otherlv_2, grammarAccess.getSAllExpressionAccess().getHyphenMinusKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSAllExpressionAccess().getCountINTVALUEParserRuleCall_2_1_0());
					}
					lv_count_3_0=ruleINTVALUE
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSAllExpressionRule());
						}
						set(
							$current,
							"count",
							lv_count_3_0,
							"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_4=LeftParenthesis
		{
			newLeafNode(otherlv_4, grammarAccess.getSAllExpressionAccess().getLeftParenthesisKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSAllExpressionAccess().getOperandsSConditionElementParserRuleCall_4_0());
				}
				lv_operands_5_0=ruleSConditionElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSAllExpressionRule());
					}
					add(
						$current,
						"operands",
						lv_operands_5_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.SConditionElement");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_6=Comma
			{
				newLeafNode(otherlv_6, grammarAccess.getSAllExpressionAccess().getCommaKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSAllExpressionAccess().getOperandsSConditionElementParserRuleCall_5_1_0());
					}
					lv_operands_7_0=ruleSConditionElement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSAllExpressionRule());
						}
						add(
							$current,
							"operands",
							lv_operands_7_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.SConditionElement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_8=RightParenthesis
		{
			newLeafNode(otherlv_8, grammarAccess.getSAllExpressionAccess().getRightParenthesisKeyword_6());
		}
	)
;

// Entry rule entryRuleSConditionTerm
entryRuleSConditionTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSConditionTermRule()); }
	iv_ruleSConditionTerm=ruleSConditionTerm
	{ $current=$iv_ruleSConditionTerm.current; }
	EOF;

// Rule SConditionTerm
ruleSConditionTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getSConditionTermAccess().getSConditionElementParserRuleCall_0());
		}
		this_SConditionElement_0=ruleSConditionElement
		{
			$current = $this_SConditionElement_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getSConditionTermAccess().getSOrmoreExpressionParserRuleCall_1());
		}
		this_SOrmoreExpression_1=ruleSOrmoreExpression
		{
			$current = $this_SOrmoreExpression_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getSConditionTermAccess().getSOrlessExpressionParserRuleCall_2());
		}
		this_SOrlessExpression_2=ruleSOrlessExpression
		{
			$current = $this_SOrlessExpression_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getSConditionTermAccess().getSAllExpressionParserRuleCall_3());
		}
		this_SAllExpression_3=ruleSAllExpression
		{
			$current = $this_SAllExpression_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			otherlv_4=LeftParenthesis
			{
				newLeafNode(otherlv_4, grammarAccess.getSConditionTermAccess().getLeftParenthesisKeyword_4_0());
			}
			{
				newCompositeNode(grammarAccess.getSConditionTermAccess().getSConditionExpressionParserRuleCall_4_1());
			}
			this_SConditionExpression_5=ruleSConditionExpression
			{
				$current = $this_SConditionExpression_5.current;
				afterParserOrEnumRuleCall();
			}
			otherlv_6=RightParenthesis
			{
				newLeafNode(otherlv_6, grammarAccess.getSConditionTermAccess().getRightParenthesisKeyword_4_2());
			}
		)
	)
;

// Entry rule entryRuleQualifiedErrorPropagation
entryRuleQualifiedErrorPropagation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedErrorPropagationRule()); }
	iv_ruleQualifiedErrorPropagation=ruleQualifiedErrorPropagation
	{ $current=$iv_ruleQualifiedErrorPropagation.current; }
	EOF;

// Rule QualifiedErrorPropagation
ruleQualifiedErrorPropagation returns [EObject current=null]
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
					grammarAccess.getQualifiedErrorPropagationAccess().getQualifiedErrorPropagationAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getQualifiedErrorPropagationAccess().getEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0());
				}
				lv_emv2Target_1_0=ruleEMV2ErrorPropagationPath
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getQualifiedErrorPropagationRule());
					}
					set(
						$current,
						"emv2Target",
						lv_emv2Target_1_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.EMV2ErrorPropagationPath");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleSConditionElement
entryRuleSConditionElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSConditionElementRule()); }
	iv_ruleSConditionElement=ruleSConditionElement
	{ $current=$iv_ruleSConditionElement.current; }
	EOF;

// Rule SConditionElement
ruleSConditionElement returns [EObject current=null]
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
					grammarAccess.getSConditionElementAccess().getSConditionElementAction_0(),
					$current);
			}
		)
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getSConditionElementAccess().getQualifiedStateQualifiedErrorBehaviorStateParserRuleCall_1_0_0_0());
						}
						lv_qualifiedState_1_0=ruleQualifiedErrorBehaviorState
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSConditionElementRule());
							}
							set(
								$current,
								"qualifiedState",
								lv_qualifiedState_1_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.QualifiedErrorBehaviorState");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getSConditionElementAccess().getConstraintTypeTokenConstraintParserRuleCall_1_0_1_0());
						}
						lv_constraint_2_0=ruleTypeTokenConstraint
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSConditionElementRule());
							}
							set(
								$current,
								"constraint",
								lv_constraint_2_0,
								"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraint");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)
			    |
			(
				otherlv_3=In
				{
					newLeafNode(otherlv_3, grammarAccess.getSConditionElementAccess().getInKeyword_1_1_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getSConditionElementAccess().getQualifiedErrorPropagationReferenceQualifiedErrorPropagationParserRuleCall_1_1_1_0_0());
							}
							lv_qualifiedErrorPropagationReference_4_0=ruleQualifiedErrorPropagation
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSConditionElementRule());
								}
								set(
									$current,
									"qualifiedErrorPropagationReference",
									lv_qualifiedErrorPropagationReference_4_0,
									"org.osate.xtext.aadl2.errormodel.ErrorModel.QualifiedErrorPropagation");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getSConditionElementAccess().getConstraintTypeTokenConstraintNoErrorParserRuleCall_1_1_1_1_0());
							}
							lv_constraint_5_0=ruleTypeTokenConstraintNoError
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getSConditionElementRule());
								}
								set(
									$current,
									"constraint",
									lv_constraint_5_0,
									"org.osate.xtext.aadl2.errormodel.ErrorModel.TypeTokenConstraintNoError");
								afterParserOrEnumRuleCall();
							}
						)
					)?
				)
			)
		)
	)
;

// Entry rule entryRuleQualifiedErrorBehaviorState
entryRuleQualifiedErrorBehaviorState returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedErrorBehaviorStateRule()); }
	iv_ruleQualifiedErrorBehaviorState=ruleQualifiedErrorBehaviorState
	{ $current=$iv_ruleQualifiedErrorBehaviorState.current; }
	EOF;

// Rule QualifiedErrorBehaviorState
ruleQualifiedErrorBehaviorState returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getQualifiedErrorBehaviorStateAccess().getSubcomponentSubcomponentElementParserRuleCall_0_0());
				}
				lv_subcomponent_0_0=ruleSubcomponentElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getQualifiedErrorBehaviorStateRule());
					}
					set(
						$current,
						"subcomponent",
						lv_subcomponent_0_0,
						"org.osate.xtext.aadl2.errormodel.ErrorModel.SubcomponentElement");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=FullStop
		{
			newLeafNode(otherlv_1, grammarAccess.getQualifiedErrorBehaviorStateAccess().getFullStopKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getQualifiedErrorBehaviorStateAccess().getNextQualifiedErrorBehaviorStateParserRuleCall_2_0_0());
					}
					lv_next_2_0=ruleQualifiedErrorBehaviorState
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getQualifiedErrorBehaviorStateRule());
						}
						set(
							$current,
							"next",
							lv_next_2_0,
							"org.osate.xtext.aadl2.errormodel.ErrorModel.QualifiedErrorBehaviorState");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getQualifiedErrorBehaviorStateRule());
						}
					}
					otherlv_3=RULE_ID
					{
						newLeafNode(otherlv_3, grammarAccess.getQualifiedErrorBehaviorStateAccess().getStateErrorBehaviorStateCrossReference_2_1_0());
					}
				)
			)
		)
	)
;

// Entry rule entryRuleSubcomponentElement
entryRuleSubcomponentElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSubcomponentElementRule()); }
	iv_ruleSubcomponentElement=ruleSubcomponentElement
	{ $current=$iv_ruleSubcomponentElement.current; }
	EOF;

// Rule SubcomponentElement
ruleSubcomponentElement returns [EObject current=null]
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
					$current = createModelElement(grammarAccess.getSubcomponentElementRule());
				}
			}
			otherlv_0=RULE_ID
			{
				newLeafNode(otherlv_0, grammarAccess.getSubcomponentElementAccess().getSubcomponentSubcomponentCrossReference_0());
			}
		)
	)
;

// Entry rule entryRuleQUALIFIEDNAME
entryRuleQUALIFIEDNAME returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQUALIFIEDNAMERule()); }
	iv_ruleQUALIFIEDNAME=ruleQUALIFIEDNAME
	{ $current=$iv_ruleQUALIFIEDNAME.current.getText(); }
	EOF;

// Rule QUALIFIEDNAME
ruleQUALIFIEDNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
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
			newLeafNode(this_ID_0, grammarAccess.getQUALIFIEDNAMEAccess().getIDTerminalRuleCall_0());
		}
		(
			kw=FullStop
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQUALIFIEDNAMEAccess().getFullStopKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getQUALIFIEDNAMEAccess().getIDTerminalRuleCall_1_1());
			}
		)+
	)
;

// Entry rule entryRuleQEMREF
entryRuleQEMREF returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQEMREFRule()); }
	iv_ruleQEMREF=ruleQEMREF
	{ $current=$iv_ruleQEMREF.current.getText(); }
	EOF;

// Rule QEMREF
ruleQEMREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
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
			newLeafNode(this_ID_0, grammarAccess.getQEMREFAccess().getIDTerminalRuleCall_0());
		}
		(
			kw=ColonColon
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQEMREFAccess().getColonColonKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getQEMREFAccess().getIDTerminalRuleCall_1_1());
			}
		)*
	)
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
