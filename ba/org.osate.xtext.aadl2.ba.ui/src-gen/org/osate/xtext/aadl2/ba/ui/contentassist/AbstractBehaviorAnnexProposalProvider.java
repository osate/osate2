/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ba.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.osate.xtext.aadl2.properties.ui.contentassist.PropertiesProposalProvider;

/**
 * Represents a generated, default implementation of superclass {@link PropertiesProposalProvider}.
 * Methods are dynamically dispatched on the first parameter, i.e., you can override them
 * with a more concrete subtype.
 */
public abstract class AbstractBehaviorAnnexProposalProvider extends PropertiesProposalProvider {

    public void completeBehaviorAnnex_VariableGroups(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorAnnex_StateGroups(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorAnnex_Transitions(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorVariableGroup_Variables(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorVariableGroup_DataClassifier(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorVariableGroup_InitialValue(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorVariableGroup_PropertyAssociations(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorVariable_Name(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorVariable_ArrayDimensions(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeArrayDimension_Size(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorPropertyAssociation_Property(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorPropertyAssociation_OwnedValue(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorStateGroup_States(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorStateGroup_Initial(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeBehaviorStateGroup_Complete(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeBehaviorStateGroup_Final(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeBehaviorState_Name(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorTransition_Name(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorTransition_Priority(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorTransition_SourceStates(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorTransition_Condition(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorTransition_DestinationState(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorTransition_ActionBlock(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorCondition_Dispatch(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorCondition_ModeSwitch(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorCondition_Execute(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeExecuteCondition_Value(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeExecuteCondition_Timeout(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeExecuteCondition_Otherwise(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeDispatchCondition_Trigger(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeDispatchCondition_FrozenPorts(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeDispatchTriggerCondition_Expression(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeDispatchTriggerCondition_Timeout(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeDispatchTriggerCondition_Time(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeDispatchTriggerCondition_Stop(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeDispatchTriggerLogicalExpression_Conjunctions(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeDispatchConjunction_Triggers(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeModeSwitchCondition_Conjunctions(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeModeSwitchConjunction_Triggers(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorActionBlock_Content(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorActionBlock_Timeout(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorActions_Actions(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeAssignmentAction_Target(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeAssignmentAction_Value(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeAssignmentAction_Any(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeCommunicationAction_Reference(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeCommunicationAction_Send(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeCommunicationAction_Parameters(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeCommunicationAction_Dequeue(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeCommunicationAction_Target(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeCommunicationAction_Freeze(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeCommunicationAction_Lock(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeCommunicationAction_Unlock(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeCommunicationAction_All(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeCommunicationAction_AllLock(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeCommunicationAction_AllUnlock(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeTimedAction_LowerTime(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeTimedAction_UpperTime(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeTimedAction_Processors(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor);
    }
    public void completeIfStatement_Condition(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeIfStatement_ThenActions(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeIfStatement_ElseIfs(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeIfStatement_ElseActions(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeElseIfClause_Condition(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeElseIfClause_Actions(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeForStatement_For(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeForStatement_Forall(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeForStatement_Variable(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeForStatement_DataClassifier(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor);
    }
    public void completeForStatement_Values(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeForStatement_Actions(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeWhileStatement_Condition(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeWhileStatement_Actions(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeDoUntilStatement_Actions(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeDoUntilStatement_Condition(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeElementValues_Lower(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeElementValues_Upper(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorTime_Value(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorTime_Unit(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor);
    }
    public void completeLogicalOrExpression_Operator(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
        // subclasses may override
    }
    public void completeLogicalOrExpression_Right(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeLogicalAndExpression_Operator(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeLogicalAndExpression_Right(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeRelationalExpression_Operator(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
        // subclasses may override
        // subclasses may override
        // subclasses may override
        // subclasses may override
        // subclasses may override
    }
    public void completeRelationalExpression_Right(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeAdditiveExpression_Operator(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
        // subclasses may override
    }
    public void completeAdditiveExpression_Right(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeMultiplicativeExpression_Operator(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
        // subclasses may override
        // subclasses may override
        // subclasses may override
    }
    public void completeMultiplicativeExpression_Right(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completePowerExpression_Operator(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completePowerExpression_Right(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeUnaryExpression_Operator(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
        // subclasses may override
        // subclasses may override
        // subclasses may override
    }
    public void completeUnaryExpression_Operand(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorIntegerLiteral_Value(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorRealLiteral_Value(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorStringLiteral_Value(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeBehaviorBooleanLiteral_Value(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeReferenceExpression_Reference(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeReferenceExpression_Property(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeReferenceExpression_Dequeue(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeReferenceExpression_Count(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeReferenceExpression_Fresh(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeHashPropertyReference_Property(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeHashPropertyReference_Indexes(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeHashPropertyReference_Fields(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completePropertyReferenceTail_Property(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completePropertyReferenceTail_Indexes(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completePropertyReferenceTail_Fields(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeNamedPropertyField_Name(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeNamedPropertyField_Indexes(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completePropertyArrayIndex_Value(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completePropertyIndexPropertyReference_Property(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeUnindexedReferenceExpression_Reference(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeUnindexedReferenceExpression_Dequeue(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeUnindexedReferenceExpression_Count(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeUnindexedReferenceExpression_Fresh(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void completeUnindexedReference_Segments(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeUnindexedReference_Tails(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeUnindexedReferenceTail_Separator(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeUnindexedReferenceTail_Segment(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeUnindexedReferenceSegment_Name(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeReference_Segments(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeReference_Tails(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeReferenceTail_Separator(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeReferenceTail_Segment(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeReferenceSegment_Name(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeReferenceSegment_Indexes(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }
    public void completeArrayIndex_Value(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);
    }

    public void complete_AnnexSubclause(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorAnnex(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorVariableGroup(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorVariable(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ArrayDimension(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorPropertyAssociation(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorStateGroup(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorState(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorTransition(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorCondition(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ExecuteCondition(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_DispatchCondition(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_DispatchTriggerCondition(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_DispatchTriggerLogicalExpression(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_DispatchConjunction(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ModeSwitchCondition(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ModeSwitchConjunction(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorActionBlock(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorActions(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorAction(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_AssignmentAction(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_CommunicationAction(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_TimedAction(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_IfStatement(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ElseIfClause(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ForStatement(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_WhileStatement(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_DoUntilStatement(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ElementValues(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorTime(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_IntegerValue(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ValueExpression(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_LogicalOrExpression(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_LogicalAndExpression(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_RelationalExpression(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_AdditiveExpression(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_MultiplicativeExpression(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_PowerExpression(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_UnaryExpression(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_PrimaryExpression(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ValueConstant(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorIntegerLiteral(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorRealLiteral(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorStringLiteral(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_BehaviorBooleanLiteral(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ReferenceExpression(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_HashPropertyReference(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_PropertyReferenceTail(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_NamedPropertyField(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_PropertyArrayIndex(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_PropertyIndexValue(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_PropertyIndexPropertyReference(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_UnindexedReferenceExpression(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_UnindexedReference(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_UnindexedReferenceTail(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_UnindexedReferenceSegment(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_QualifiedName(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_Reference(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ReferenceTail(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ReferenceSeparator(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ReferenceSegment(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
    public void complete_ArrayIndex(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // subclasses may override
    }
}
