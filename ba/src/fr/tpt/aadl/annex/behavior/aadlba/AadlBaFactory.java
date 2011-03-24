/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 Télécom ParisTech and CNRS
 * 
 * Télécom ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage
 * @generated
 */
public interface AadlBaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AadlBaFactory eINSTANCE = fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Behavior Annex</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Annex</em>'.
	 * @generated
	 */
	BehaviorAnnex createBehaviorAnnex();

	/**
	 * Returns a new object of class '<em>Behavior State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior State</em>'.
	 * @generated
	 */
	BehaviorState createBehaviorState();

	/**
	 * Returns a new object of class '<em>Behavior Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Transition</em>'.
	 * @generated
	 */
	BehaviorTransition createBehaviorTransition();

	/**
	 * Returns a new object of class '<em>Behavior Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Variable</em>'.
	 * @generated
	 */
	BehaviorVariable createBehaviorVariable();

	/**
	 * Returns a new object of class '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comment</em>'.
	 * @generated
	 */
	Comment createComment();

	/**
	 * Returns a new object of class '<em>Declarator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Declarator</em>'.
	 * @generated
	 */
	Declarator createDeclarator();

	/**
	 * Returns a new object of class '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifier</em>'.
	 * @generated
	 */
	Identifier createIdentifier();

	/**
	 * Returns a new object of class '<em>Otherwise</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Otherwise</em>'.
	 * @generated
	 */
	Otherwise createOtherwise();

	/**
	 * Returns a new object of class '<em>Timeout Catch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timeout Catch</em>'.
	 * @generated
	 */
	TimeoutCatch createTimeoutCatch();

	/**
	 * Returns a new object of class '<em>Unique Component Classifier Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unique Component Classifier Reference</em>'.
	 * @generated
	 */
	UniqueComponentClassifierReference createUniqueComponentClassifierReference();

	/**
	 * Returns a new object of class '<em>Completion Relative Timeout Condition And Catch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Completion Relative Timeout Condition And Catch</em>'.
	 * @generated
	 */
	CompletionRelativeTimeoutConditionAndCatch createCompletionRelativeTimeoutConditionAndCatch();

	/**
	 * Returns a new object of class '<em>Dispatch Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dispatch Condition</em>'.
	 * @generated
	 */
	DispatchCondition createDispatchCondition();

	/**
	 * Returns a new object of class '<em>Dispatch Conjunction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dispatch Conjunction</em>'.
	 * @generated
	 */
	DispatchConjunction createDispatchConjunction();

	/**
	 * Returns a new object of class '<em>Dispatch Trigger Condition Stop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dispatch Trigger Condition Stop</em>'.
	 * @generated
	 */
	DispatchTriggerConditionStop createDispatchTriggerConditionStop();

	/**
	 * Returns a new object of class '<em>Dispatch Trigger Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dispatch Trigger Logical Expression</em>'.
	 * @generated
	 */
	DispatchTriggerLogicalExpression createDispatchTriggerLogicalExpression();

	/**
	 * Returns a new object of class '<em>Assignment Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment Action</em>'.
	 * @generated
	 */
	AssignmentAction createAssignmentAction();

	/**
	 * Returns a new object of class '<em>Behavior Action Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Action Block</em>'.
	 * @generated
	 */
	BehaviorActionBlock createBehaviorActionBlock();

	/**
	 * Returns a new object of class '<em>Behavior Action Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Action Sequence</em>'.
	 * @generated
	 */
	BehaviorActionSequence createBehaviorActionSequence();

	/**
	 * Returns a new object of class '<em>Behavior Action Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Action Set</em>'.
	 * @generated
	 */
	BehaviorActionSet createBehaviorActionSet();

	/**
	 * Returns a new object of class '<em>Data Component Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Component Reference</em>'.
	 * @generated
	 */
	DataComponentReference createDataComponentReference();

	/**
	 * Returns a new object of class '<em>For Or For All Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Or For All Statement</em>'.
	 * @generated
	 */
	ForOrForAllStatement createForOrForAllStatement();

	/**
	 * Returns a new object of class '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Statement</em>'.
	 * @generated
	 */
	IfStatement createIfStatement();

	/**
	 * Returns a new object of class '<em>Lock Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lock Action</em>'.
	 * @generated
	 */
	LockAction createLockAction();

	/**
	 * Returns a new object of class '<em>Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Name</em>'.
	 * @generated
	 */
	Name createName();

	/**
	 * Returns a new object of class '<em>Port Dequeue Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Dequeue Action</em>'.
	 * @generated
	 */
	PortDequeueAction createPortDequeueAction();

	/**
	 * Returns a new object of class '<em>Port Freeze Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Freeze Action</em>'.
	 * @generated
	 */
	PortFreezeAction createPortFreezeAction();

	/**
	 * Returns a new object of class '<em>Port Send Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Send Action</em>'.
	 * @generated
	 */
	PortSendAction createPortSendAction();

	/**
	 * Returns a new object of class '<em>Subprogram Call Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Call Action</em>'.
	 * @generated
	 */
	SubprogramCallAction createSubprogramCallAction();

	/**
	 * Returns a new object of class '<em>Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target</em>'.
	 * @generated
	 */
	Target createTarget();

	/**
	 * Returns a new object of class '<em>Timed Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Action</em>'.
	 * @generated
	 */
	TimedAction createTimedAction();

	/**
	 * Returns a new object of class '<em>Unlock Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unlock Action</em>'.
	 * @generated
	 */
	UnlockAction createUnlockAction();

	/**
	 * Returns a new object of class '<em>While Or Do Until Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Or Do Until Statement</em>'.
	 * @generated
	 */
	WhileOrDoUntilStatement createWhileOrDoUntilStatement();

	/**
	 * Returns a new object of class '<em>Behavior Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Time</em>'.
	 * @generated
	 */
	BehaviorTime createBehaviorTime();

	/**
	 * Returns a new object of class '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal</em>'.
	 * @generated
	 */
	BooleanLiteral createBooleanLiteral();

	/**
	 * Returns a new object of class '<em>Factor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Factor</em>'.
	 * @generated
	 */
	Factor createFactor();

	/**
	 * Returns a new object of class '<em>Integer Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Literal</em>'.
	 * @generated
	 */
	IntegerLiteral createIntegerLiteral();

	/**
	 * Returns a new object of class '<em>Integer Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Range</em>'.
	 * @generated
	 */
	IntegerRange createIntegerRange();

	/**
	 * Returns a new object of class '<em>Numeral</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeral</em>'.
	 * @generated
	 */
	Numeral createNumeral();

	/**
	 * Returns a new object of class '<em>Property Constant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Constant</em>'.
	 * @generated
	 */
	PropertyConstant createPropertyConstant();

	/**
	 * Returns a new object of class '<em>Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Value</em>'.
	 * @generated
	 */
	PropertyValue createPropertyValue();

	/**
	 * Returns a new object of class '<em>Port Count Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Count Value</em>'.
	 * @generated
	 */
	PortCountValue createPortCountValue();

	/**
	 * Returns a new object of class '<em>Port Dequeue Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Dequeue Value</em>'.
	 * @generated
	 */
	PortDequeueValue createPortDequeueValue();

	/**
	 * Returns a new object of class '<em>Port Fresh Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Fresh Value</em>'.
	 * @generated
	 */
	PortFreshValue createPortFreshValue();

	/**
	 * Returns a new object of class '<em>Real Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Literal</em>'.
	 * @generated
	 */
	RealLiteral createRealLiteral();

	/**
	 * Returns a new object of class '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation</em>'.
	 * @generated
	 */
	Relation createRelation();

	/**
	 * Returns a new object of class '<em>Simple Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Expression</em>'.
	 * @generated
	 */
	SimpleExpression createSimpleExpression();

	/**
	 * Returns a new object of class '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal</em>'.
	 * @generated
	 */
	StringLiteral createStringLiteral();

	/**
	 * Returns a new object of class '<em>Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Term</em>'.
	 * @generated
	 */
	Term createTerm();

	/**
	 * Returns a new object of class '<em>Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Expression</em>'.
	 * @generated
	 */
	ValueExpression createValueExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AadlBaPackage getAadlBaPackage();

} //AadlBaFactory
