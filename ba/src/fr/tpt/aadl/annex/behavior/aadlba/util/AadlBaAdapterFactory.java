/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
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
package fr.tpt.aadl.annex.behavior.aadlba.util;

import edu.cmu.sei.aadl.aadl2.AnnexSubclause;
import edu.cmu.sei.aadl.aadl2.BooleanLiteral;
import edu.cmu.sei.aadl.aadl2.Element;
import edu.cmu.sei.aadl.aadl2.IntegerLiteral;
import edu.cmu.sei.aadl.aadl2.ModalElement;

import edu.cmu.sei.aadl.aadl2.NamedElement;
import edu.cmu.sei.aadl.aadl2.NumberValue;
import edu.cmu.sei.aadl.aadl2.PropertyExpression;
import edu.cmu.sei.aadl.aadl2.PropertyValue;
import edu.cmu.sei.aadl.aadl2.RealLiteral;
import edu.cmu.sei.aadl.aadl2.StringLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage
 * @generated
 */
public class AadlBaAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AadlBaPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AadlBaAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AadlBaPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AadlBaSwitch<Adapter> modelSwitch =
		new AadlBaSwitch<Adapter>() {
			@Override
			public Adapter caseAssignmentAction(AssignmentAction object) {
				return createAssignmentActionAdapter();
			}
			@Override
			public Adapter caseBasicAction(BasicAction object) {
				return createBasicActionAdapter();
			}
			@Override
			public Adapter caseBehaviorAction(BehaviorAction object) {
				return createBehaviorActionAdapter();
			}
			@Override
			public Adapter caseBehaviorActionBlock(BehaviorActionBlock object) {
				return createBehaviorActionBlockAdapter();
			}
			@Override
			public Adapter caseBehaviorActionCollection(BehaviorActionCollection object) {
				return createBehaviorActionCollectionAdapter();
			}
			@Override
			public Adapter caseBehaviorActions(BehaviorActions object) {
				return createBehaviorActionsAdapter();
			}
			@Override
			public Adapter caseBehaviorActionSequence(BehaviorActionSequence object) {
				return createBehaviorActionSequenceAdapter();
			}
			@Override
			public Adapter caseBehaviorActionSet(BehaviorActionSet object) {
				return createBehaviorActionSetAdapter();
			}
			@Override
			public Adapter caseBehaviorAnnex(BehaviorAnnex object) {
				return createBehaviorAnnexAdapter();
			}
			@Override
			public Adapter caseBehaviorCondition(BehaviorCondition object) {
				return createBehaviorConditionAdapter();
			}
			@Override
			public Adapter caseBehaviorElement(BehaviorElement object) {
				return createBehaviorElementAdapter();
			}
			@Override
			public Adapter caseBehaviorNamedElement(BehaviorNamedElement object) {
				return createBehaviorNamedElementAdapter();
			}
			@Override
			public Adapter caseBehaviorState(BehaviorState object) {
				return createBehaviorStateAdapter();
			}
			@Override
			public Adapter caseBehaviorTime(BehaviorTime object) {
				return createBehaviorTimeAdapter();
			}
			@Override
			public Adapter caseBehaviorTransition(BehaviorTransition object) {
				return createBehaviorTransitionAdapter();
			}
			@Override
			public Adapter caseBehaviorVariable(BehaviorVariable object) {
				return createBehaviorVariableAdapter();
			}
			@Override
			public Adapter caseBehaviorBooleanLiteral(BehaviorBooleanLiteral object) {
				return createBehaviorBooleanLiteralAdapter();
			}
			@Override
			public Adapter caseBehaviorStringLiteral(BehaviorStringLiteral object) {
				return createBehaviorStringLiteralAdapter();
			}
			@Override
			public Adapter caseCommunicationAction(CommunicationAction object) {
				return createCommunicationActionAdapter();
			}
			@Override
			public Adapter caseCompletionRelativeTimeoutConditionAndCatch(CompletionRelativeTimeoutConditionAndCatch object) {
				return createCompletionRelativeTimeoutConditionAndCatchAdapter();
			}
			@Override
			public Adapter caseCondStatement(CondStatement object) {
				return createCondStatementAdapter();
			}
			@Override
			public Adapter caseDataComponentReference(DataComponentReference object) {
				return createDataComponentReferenceAdapter();
			}
			@Override
			public Adapter caseDeclarator(Declarator object) {
				return createDeclaratorAdapter();
			}
			@Override
			public Adapter caseDispatchCondition(DispatchCondition object) {
				return createDispatchConditionAdapter();
			}
			@Override
			public Adapter caseDispatchConjunction(DispatchConjunction object) {
				return createDispatchConjunctionAdapter();
			}
			@Override
			public Adapter caseDispatchTriggerCondition(DispatchTriggerCondition object) {
				return createDispatchTriggerConditionAdapter();
			}
			@Override
			public Adapter caseDispatchTriggerConditionStop(DispatchTriggerConditionStop object) {
				return createDispatchTriggerConditionStopAdapter();
			}
			@Override
			public Adapter caseDispatchTriggerLogicalExpression(DispatchTriggerLogicalExpression object) {
				return createDispatchTriggerLogicalExpressionAdapter();
			}
			@Override
			public Adapter caseElementValues(ElementValues object) {
				return createElementValuesAdapter();
			}
			@Override
			public Adapter caseExecuteCondition(ExecuteCondition object) {
				return createExecuteConditionAdapter();
			}
			@Override
			public Adapter caseFactor(Factor object) {
				return createFactorAdapter();
			}
			@Override
			public Adapter caseForOrForAllStatement(ForOrForAllStatement object) {
				return createForOrForAllStatementAdapter();
			}
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter caseIfStatement(IfStatement object) {
				return createIfStatementAdapter();
			}
			@Override
			public Adapter caseBehaviorIntegerLiteral(BehaviorIntegerLiteral object) {
				return createBehaviorIntegerLiteralAdapter();
			}
			@Override
			public Adapter caseIntegerRange(IntegerRange object) {
				return createIntegerRangeAdapter();
			}
			@Override
			public Adapter caseIntegerValue(IntegerValue object) {
				return createIntegerValueAdapter();
			}
			@Override
			public Adapter caseIntegerValueConstant(IntegerValueConstant object) {
				return createIntegerValueConstantAdapter();
			}
			@Override
			public Adapter caseIntegerValueVariable(IntegerValueVariable object) {
				return createIntegerValueVariableAdapter();
			}
			@Override
			public Adapter caseLiteral(Literal object) {
				return createLiteralAdapter();
			}
			@Override
			public Adapter caseLockAction(LockAction object) {
				return createLockActionAdapter();
			}
			@Override
			public Adapter caseLoopStatement(LoopStatement object) {
				return createLoopStatementAdapter();
			}
			@Override
			public Adapter caseName(Name object) {
				return createNameAdapter();
			}
			@Override
			public Adapter caseNumeral(Numeral object) {
				return createNumeralAdapter();
			}
			@Override
			public Adapter caseNumericLiteral(NumericLiteral object) {
				return createNumericLiteralAdapter();
			}
			@Override
			public Adapter caseOtherwise(Otherwise object) {
				return createOtherwiseAdapter();
			}
			@Override
			public Adapter caseParameterLabel(ParameterLabel object) {
				return createParameterLabelAdapter();
			}
			@Override
			public Adapter casePortCountValue(PortCountValue object) {
				return createPortCountValueAdapter();
			}
			@Override
			public Adapter casePortDequeueAction(PortDequeueAction object) {
				return createPortDequeueActionAdapter();
			}
			@Override
			public Adapter casePortDequeueValue(PortDequeueValue object) {
				return createPortDequeueValueAdapter();
			}
			@Override
			public Adapter casePortFreezeAction(PortFreezeAction object) {
				return createPortFreezeActionAdapter();
			}
			@Override
			public Adapter casePortFreshValue(PortFreshValue object) {
				return createPortFreshValueAdapter();
			}
			@Override
			public Adapter casePortSendAction(PortSendAction object) {
				return createPortSendActionAdapter();
			}
			@Override
			public Adapter caseBehaviorPropertyConstant(BehaviorPropertyConstant object) {
				return createBehaviorPropertyConstantAdapter();
			}
			@Override
			public Adapter caseBehaviorPropertyValue(BehaviorPropertyValue object) {
				return createBehaviorPropertyValueAdapter();
			}
			@Override
			public Adapter caseBehaviorRealLiteral(BehaviorRealLiteral object) {
				return createBehaviorRealLiteralAdapter();
			}
			@Override
			public Adapter caseRelation(Relation object) {
				return createRelationAdapter();
			}
			@Override
			public Adapter caseSharedDataAction(SharedDataAction object) {
				return createSharedDataActionAdapter();
			}
			@Override
			public Adapter caseSimpleExpression(SimpleExpression object) {
				return createSimpleExpressionAdapter();
			}
			@Override
			public Adapter caseSubprogramCallAction(SubprogramCallAction object) {
				return createSubprogramCallActionAdapter();
			}
			@Override
			public Adapter caseTarget(Target object) {
				return createTargetAdapter();
			}
			@Override
			public Adapter caseTerm(Term object) {
				return createTermAdapter();
			}
			@Override
			public Adapter caseTimedAction(TimedAction object) {
				return createTimedActionAdapter();
			}
			@Override
			public Adapter caseTimeoutCatch(TimeoutCatch object) {
				return createTimeoutCatchAdapter();
			}
			@Override
			public Adapter caseUniqueComponentClassifierReference(UniqueComponentClassifierReference object) {
				return createUniqueComponentClassifierReferenceAdapter();
			}
			@Override
			public Adapter caseUnlockAction(UnlockAction object) {
				return createUnlockActionAdapter();
			}
			@Override
			public Adapter caseValue(Value object) {
				return createValueAdapter();
			}
			@Override
			public Adapter caseValueConstant(ValueConstant object) {
				return createValueConstantAdapter();
			}
			@Override
			public Adapter caseValueExpression(ValueExpression object) {
				return createValueExpressionAdapter();
			}
			@Override
			public Adapter caseValueVariable(ValueVariable object) {
				return createValueVariableAdapter();
			}
			@Override
			public Adapter caseWhileOrDoUntilStatement(WhileOrDoUntilStatement object) {
				return createWhileOrDoUntilStatementAdapter();
			}
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseModalElement(ModalElement object) {
				return createModalElementAdapter();
			}
			@Override
			public Adapter caseAnnexSubclause(AnnexSubclause object) {
				return createAnnexSubclauseAdapter();
			}
			@Override
			public Adapter casePropertyExpression(PropertyExpression object) {
				return createPropertyExpressionAdapter();
			}
			@Override
			public Adapter casePropertyValue(PropertyValue object) {
				return createPropertyValueAdapter();
			}
			@Override
			public Adapter caseBooleanLiteral(BooleanLiteral object) {
				return createBooleanLiteralAdapter();
			}
			@Override
			public Adapter caseStringLiteral(StringLiteral object) {
				return createStringLiteralAdapter();
			}
			@Override
			public Adapter caseNumberValue(NumberValue object) {
				return createNumberValueAdapter();
			}
			@Override
			public Adapter caseIntegerLiteral(IntegerLiteral object) {
				return createIntegerLiteralAdapter();
			}
			@Override
			public Adapter caseRealLiteral(RealLiteral object) {
				return createRealLiteralAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex <em>Behavior Annex</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex
	 * @generated
	 */
	public Adapter createBehaviorAnnexAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition <em>Behavior Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition
	 * @generated
	 */
	public Adapter createBehaviorConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement <em>Behavior Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement
	 * @generated
	 */
	public Adapter createBehaviorElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorNamedElement <em>Behavior Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorNamedElement
	 * @generated
	 */
	public Adapter createBehaviorNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState <em>Behavior State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState
	 * @generated
	 */
	public Adapter createBehaviorStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition <em>Behavior Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition
	 * @generated
	 */
	public Adapter createBehaviorTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable <em>Behavior Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable
	 * @generated
	 */
	public Adapter createBehaviorVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorBooleanLiteral <em>Behavior Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorBooleanLiteral
	 * @generated
	 */
	public Adapter createBehaviorBooleanLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorStringLiteral <em>Behavior String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorStringLiteral
	 * @generated
	 */
	public Adapter createBehaviorStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Declarator <em>Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Declarator
	 * @generated
	 */
	public Adapter createDeclaratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition <em>Execute Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition
	 * @generated
	 */
	public Adapter createExecuteConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Otherwise <em>Otherwise</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Otherwise
	 * @generated
	 */
	public Adapter createOtherwiseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.TimeoutCatch <em>Timeout Catch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.TimeoutCatch
	 * @generated
	 */
	public Adapter createTimeoutCatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference <em>Unique Component Classifier Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference
	 * @generated
	 */
	public Adapter createUniqueComponentClassifierReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime <em>Behavior Time</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime
	 * @generated
	 */
	public Adapter createBehaviorTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.BooleanLiteral
	 * @generated
	 */
	public Adapter createBooleanLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Factor
	 * @generated
	 */
	public Adapter createFactorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.IntegerLiteral
	 * @generated
	 */
	public Adapter createIntegerLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerRange <em>Integer Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerRange
	 * @generated
	 */
	public Adapter createIntegerRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValue <em>Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValue
	 * @generated
	 */
	public Adapter createIntegerValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant <em>Integer Value Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant
	 * @generated
	 */
	public Adapter createIntegerValueConstantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable <em>Integer Value Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable
	 * @generated
	 */
	public Adapter createIntegerValueVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Literal
	 * @generated
	 */
	public Adapter createLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Numeral <em>Numeral</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Numeral
	 * @generated
	 */
	public Adapter createNumeralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral <em>Numeric Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral
	 * @generated
	 */
	public Adapter createNumericLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortCountValue <em>Port Count Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortCountValue
	 * @generated
	 */
	public Adapter createPortCountValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueValue <em>Port Dequeue Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortDequeueValue
	 * @generated
	 */
	public Adapter createPortDequeueValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortFreshValue <em>Port Fresh Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortFreshValue
	 * @generated
	 */
	public Adapter createPortFreshValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.RealLiteral <em>Real Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.RealLiteral
	 * @generated
	 */
	public Adapter createRealLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Relation
	 * @generated
	 */
	public Adapter createRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression <em>Simple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression
	 * @generated
	 */
	public Adapter createSimpleExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.StringLiteral
	 * @generated
	 */
	public Adapter createStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.NumberValue <em>Number Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.NumberValue
	 * @generated
	 */
	public Adapter createNumberValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Term
	 * @generated
	 */
	public Adapter createTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Value
	 * @generated
	 */
	public Adapter createValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueConstant <em>Value Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueConstant
	 * @generated
	 */
	public Adapter createValueConstantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression <em>Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueExpression
	 * @generated
	 */
	public Adapter createValueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable <em>Value Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable
	 * @generated
	 */
	public Adapter createValueVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction <em>Assignment Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction
	 * @generated
	 */
	public Adapter createAssignmentActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BasicAction <em>Basic Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BasicAction
	 * @generated
	 */
	public Adapter createBasicActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction <em>Behavior Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction
	 * @generated
	 */
	public Adapter createBehaviorActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock <em>Behavior Action Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock
	 * @generated
	 */
	public Adapter createBehaviorActionBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection <em>Behavior Action Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection
	 * @generated
	 */
	public Adapter createBehaviorActionCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions <em>Behavior Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions
	 * @generated
	 */
	public Adapter createBehaviorActionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence <em>Behavior Action Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence
	 * @generated
	 */
	public Adapter createBehaviorActionSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSet <em>Behavior Action Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSet
	 * @generated
	 */
	public Adapter createBehaviorActionSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction <em>Communication Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction
	 * @generated
	 */
	public Adapter createCommunicationActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.CondStatement <em>Cond Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.CondStatement
	 * @generated
	 */
	public Adapter createCondStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference <em>Data Component Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference
	 * @generated
	 */
	public Adapter createDataComponentReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementValues <em>Element Values</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ElementValues
	 * @generated
	 */
	public Adapter createElementValuesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement <em>For Or For All Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement
	 * @generated
	 */
	public Adapter createForOrForAllStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IfStatement
	 * @generated
	 */
	public Adapter createIfStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorIntegerLiteral <em>Behavior Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorIntegerLiteral
	 * @generated
	 */
	public Adapter createBehaviorIntegerLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.LockAction <em>Lock Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.LockAction
	 * @generated
	 */
	public Adapter createLockActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.LoopStatement <em>Loop Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.LoopStatement
	 * @generated
	 */
	public Adapter createLoopStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Name <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Name
	 * @generated
	 */
	public Adapter createNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel <em>Parameter Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel
	 * @generated
	 */
	public Adapter createParameterLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction <em>Port Dequeue Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction
	 * @generated
	 */
	public Adapter createPortDequeueActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortFreezeAction <em>Port Freeze Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortFreezeAction
	 * @generated
	 */
	public Adapter createPortFreezeActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortSendAction <em>Port Send Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortSendAction
	 * @generated
	 */
	public Adapter createPortSendActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyConstant <em>Behavior Property Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyConstant
	 * @generated
	 */
	public Adapter createBehaviorPropertyConstantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyValue <em>Behavior Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyValue
	 * @generated
	 */
	public Adapter createBehaviorPropertyValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorRealLiteral <em>Behavior Real Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorRealLiteral
	 * @generated
	 */
	public Adapter createBehaviorRealLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction <em>Shared Data Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction
	 * @generated
	 */
	public Adapter createSharedDataActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction <em>Subprogram Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction
	 * @generated
	 */
	public Adapter createSubprogramCallActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Target <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Target
	 * @generated
	 */
	public Adapter createTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction <em>Timed Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.TimedAction
	 * @generated
	 */
	public Adapter createTimedActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.UnlockAction <em>Unlock Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnlockAction
	 * @generated
	 */
	public Adapter createUnlockActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement <em>While Or Do Until Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement
	 * @generated
	 */
	public Adapter createWhileOrDoUntilStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeoutConditionAndCatch <em>Completion Relative Timeout Condition And Catch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeoutConditionAndCatch
	 * @generated
	 */
	public Adapter createCompletionRelativeTimeoutConditionAndCatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition <em>Dispatch Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition
	 * @generated
	 */
	public Adapter createDispatchConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction <em>Dispatch Conjunction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction
	 * @generated
	 */
	public Adapter createDispatchConjunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition <em>Dispatch Trigger Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition
	 * @generated
	 */
	public Adapter createDispatchTriggerConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerConditionStop <em>Dispatch Trigger Condition Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerConditionStop
	 * @generated
	 */
	public Adapter createDispatchTriggerConditionStopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression <em>Dispatch Trigger Logical Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression
	 * @generated
	 */
	public Adapter createDispatchTriggerLogicalExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.ModalElement <em>Modal Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.ModalElement
	 * @generated
	 */
	public Adapter createModalElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.AnnexSubclause <em>Annex Subclause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.AnnexSubclause
	 * @generated
	 */
	public Adapter createAnnexSubclauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.PropertyExpression <em>Property Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.PropertyExpression
	 * @generated
	 */
	public Adapter createPropertyExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.PropertyValue <em>Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.PropertyValue
	 * @generated
	 */
	public Adapter createPropertyValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AadlBaAdapterFactory
