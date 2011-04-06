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
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import edu.cmu.sei.aadl.aadl2.Aadl2Package;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaFactory;
import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction;
import fr.tpt.aadl.annex.behavior.aadlba.BasicAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSet;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnexFeatureType;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator;
import fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.Comment;
import fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction;
import fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeoutConditionAndCatch;
import fr.tpt.aadl.annex.behavior.aadlba.CondStatement;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference;
import fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation ;
import fr.tpt.aadl.annex.behavior.aadlba.Declarator;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerConditionStop;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression;
import fr.tpt.aadl.annex.behavior.aadlba.Element;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues;
import fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition;
import fr.tpt.aadl.annex.behavior.aadlba.Factor;
import fr.tpt.aadl.annex.behavior.aadlba.FeatureType;
import fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.IfStatement;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerRange;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable;
import fr.tpt.aadl.annex.behavior.aadlba.Literal;
import fr.tpt.aadl.annex.behavior.aadlba.LockAction;
import fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator;
import fr.tpt.aadl.annex.behavior.aadlba.LoopStatement;
import fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.Name;
import fr.tpt.aadl.annex.behavior.aadlba.NamedElement;
import fr.tpt.aadl.annex.behavior.aadlba.Numeral;
import fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.Otherwise;
import fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel;
import fr.tpt.aadl.annex.behavior.aadlba.PortCountValue;
import fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction;
import fr.tpt.aadl.annex.behavior.aadlba.PortDequeueValue;
import fr.tpt.aadl.annex.behavior.aadlba.PortFreezeAction;
import fr.tpt.aadl.annex.behavior.aadlba.PortFreshValue;
import fr.tpt.aadl.annex.behavior.aadlba.PortSendAction;
import fr.tpt.aadl.annex.behavior.aadlba.PropertyConstant;
import fr.tpt.aadl.annex.behavior.aadlba.PropertyValue;
import fr.tpt.aadl.annex.behavior.aadlba.RealLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.Relation;
import fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator;
import fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction;
import fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression;
import fr.tpt.aadl.annex.behavior.aadlba.StringLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction;
import fr.tpt.aadl.annex.behavior.aadlba.Target;
import fr.tpt.aadl.annex.behavior.aadlba.Term;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction;
import fr.tpt.aadl.annex.behavior.aadlba.TimeoutCatch;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference;
import fr.tpt.aadl.annex.behavior.aadlba.UnlockAction;
import fr.tpt.aadl.annex.behavior.aadlba.Value;
import fr.tpt.aadl.annex.behavior.aadlba.ValueConstant;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;
import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable;
import fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AadlBaPackageImpl extends EPackageImpl implements AadlBaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorAnnexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declaratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executeConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass otherwiseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeoutCatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uniqueComponentClassifierReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass factorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerValueConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerValueVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numeralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portCountValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portDequeueValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portFreshValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorActionBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorActionCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorActionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorActionSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorActionSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass condStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataComponentReferenceEClass = null;

	  /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EEnum dataRepresentationEEnum = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementValuesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forOrForAllStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lockActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portDequeueActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portFreezeActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portSendActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sharedDataActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramCallActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timedActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unlockActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileOrDoUntilStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completionRelativeTimeoutConditionAndCatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchConjunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchTriggerConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchTriggerConditionStopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchTriggerLogicalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum behaviorAnnexFeatureTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum featureTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum binaryAddingOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum binaryNumericOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum logicalOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum multiplyingOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum relationalOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unaryAddingOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unaryBooleanOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unaryNumericOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType booleanEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType integerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType realEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AadlBaPackageImpl() {
		super(eNS_URI, AadlBaFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link AadlBaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AadlBaPackage init() {
		if (isInited) return (AadlBaPackage)EPackage.Registry.INSTANCE.getEPackage(AadlBaPackage.eNS_URI);

		// Obtain or create and register package
		AadlBaPackageImpl theAadlBaPackage = (AadlBaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AadlBaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AadlBaPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Aadl2Package.eINSTANCE.eClass();

		// Create package meta-data objects
		theAadlBaPackage.createPackageContents();

		// Initialize created meta-data
		theAadlBaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAadlBaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AadlBaPackage.eNS_URI, theAadlBaPackage);
		return theAadlBaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorAnnex() {
		return behaviorAnnexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorAnnex_BehaviorVariables() {
		return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorAnnex_BehaviorStates() {
		return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorAnnex_BehaviorTransitions() {
		return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorCondition() {
		return behaviorConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorState() {
		return behaviorStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorState_Identifiers() {
		return (EReference)behaviorStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorState_Initial() {
		return (EAttribute)behaviorStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorState_Complete() {
		return (EAttribute)behaviorStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorState_Final() {
		return (EAttribute)behaviorStateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorTransition() {
		return behaviorTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTransition_TransitionIdentifier() {
		return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTransition_SourceStateIdentifiers() {
		return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTransition_BehaviorConditionOwned() {
		return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTransition_DestinationStateIdentifier() {
		return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTransition_BehaviorActionBlockOwned() {
		return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTransition_BehaviorTransitionPriority() {
		return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorVariable() {
		return behaviorVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorVariable_LocalVariableDeclarators() {
		return (EReference)behaviorVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorVariable_DataUniqueComponentClassifierReference() {
		return (EReference)behaviorVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComment() {
		return commentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComment_Body() {
		return (EAttribute)commentEClass.getEStructuralFeatures().get(0);
	}

	  /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EEnum getDataRepresentation() {
      return dataRepresentationEEnum;
   }
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclarator() {
		return declaratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeclarator_IdentifierOwned() {
		return (EReference)declaratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeclarator_ArraySizes() {
		return (EReference)declaratorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElement_BaRef() {
		return (EReference)elementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElement_AadlRef() {
		return (EReference)elementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecuteCondition() {
		return executeConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifier() {
		return identifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifier_Id() {
		return (EAttribute)identifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_QualifiedName() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_NamespaceSeparator() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Namespace() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOtherwise() {
		return otherwiseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeoutCatch() {
		return timeoutCatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUniqueComponentClassifierReference() {
		return uniqueComponentClassifierReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorTime() {
		return behaviorTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTime_IntegerValueOwned() {
		return (EReference)behaviorTimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTime_UnitIdentifier() {
		return (EReference)behaviorTimeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanLiteral() {
		return booleanLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanLiteral_Value() {
		return (EAttribute)booleanLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFactor() {
		return factorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFactor_ValueOwned() {
		return (EReference)factorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFactor_ValueSdOwned() {
		return (EReference)factorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFactor_BinaryNumericOperatorOwned() {
		return (EAttribute)factorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFactor_UnaryNumericOperatorOwned() {
		return (EAttribute)factorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFactor_UnaryBooleanOperatorOwned() {
		return (EAttribute)factorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerLiteral() {
		return integerLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerLiteral_Value() {
		return (EAttribute)integerLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerLiteral_Base() {
		return (EAttribute)integerLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerRange() {
		return integerRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntegerRange_LowerIntegerValue() {
		return (EReference)integerRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntegerRange_UpperIntegerValue() {
		return (EReference)integerRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerValue() {
		return integerValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerValueConstant() {
		return integerValueConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerValueVariable() {
		return integerValueVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumeral() {
		return numeralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumeral_Value() {
		return (EAttribute)numeralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericLiteral() {
		return numericLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericLiteral_ValueString() {
		return (EAttribute)numericLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyConstant() {
		return propertyConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyValue() {
		return propertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortCountValue() {
		return portCountValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortDequeueValue() {
		return portDequeueValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortFreshValue() {
		return portFreshValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealLiteral() {
		return realLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRealLiteral_Value() {
		return (EAttribute)realLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelation() {
		return relationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_SimpleExpressionOwned() {
		return (EReference)relationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_SimpleExpressionSdOwned() {
		return (EReference)relationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelation_RelationalOperatorOwned() {
		return (EAttribute)relationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleExpression() {
		return simpleExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleExpression_UnaryAddingOperatorOwned() {
		return (EAttribute)simpleExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleExpression_Terms() {
		return (EReference)simpleExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleExpression_BinaryAddingOperators() {
		return (EAttribute)simpleExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringLiteral() {
		return stringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringLiteral_Value() {
		return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerm() {
		return termEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerm_Factors() {
		return (EReference)termEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerm_MultiplyingOperators() {
		return (EAttribute)termEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValue() {
		return valueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueConstant() {
		return valueConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueExpression() {
		return valueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueExpression_Relations() {
		return (EReference)valueExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueExpression_LogicalOperators() {
		return (EAttribute)valueExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueVariable() {
		return valueVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignmentAction() {
		return assignmentActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignmentAction_TargetOwned() {
		return (EReference)assignmentActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignmentAction_ValueExpressionOwned() {
		return (EReference)assignmentActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentAction_Any() {
		return (EAttribute)assignmentActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicAction() {
		return basicActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorAction() {
		return behaviorActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorActionBlock() {
		return behaviorActionBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorActionBlock_BehaviorActionsOwned() {
		return (EReference)behaviorActionBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorActionBlock_BehaviorTimeOwned() {
		return (EReference)behaviorActionBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorActionCollection() {
		return behaviorActionCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorActionCollection_BehaviorActions() {
		return (EReference)behaviorActionCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorActions() {
		return behaviorActionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorActionSequence() {
		return behaviorActionSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorActionSet() {
		return behaviorActionSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationAction() {
		return communicationActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCondStatement() {
		return condStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataComponentReference() {
		return dataComponentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataComponentReference_Names() {
		return (EReference)dataComponentReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementValues() {
		return elementValuesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForOrForAllStatement() {
		return forOrForAllStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForOrForAllStatement_ElementIdentifier() {
		return (EReference)forOrForAllStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForOrForAllStatement_DataUniqueComponentClassifierReference() {
		return (EReference)forOrForAllStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForOrForAllStatement_ElementValuesOwned() {
		return (EReference)forOrForAllStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForOrForAllStatement_ForAll() {
		return (EAttribute)forOrForAllStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfStatement() {
		return ifStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfStatement_HasElse() {
		return (EAttribute)ifStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_LogicalValueExpressions() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_BehaviorActionsOwned() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLockAction() {
		return lockActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopStatement() {
		return loopStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopStatement_BehaviorActionsOwned() {
		return (EReference)loopStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getName_() {
		return nameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getName_IdentifierOwned() {
		return (EReference)nameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getName_ArrayIndexes() {
		return (EReference)nameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterLabel() {
		return parameterLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortDequeueAction() {
		return portDequeueActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortDequeueAction_PortName() {
		return (EReference)portDequeueActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortDequeueAction_TargetOwned() {
		return (EReference)portDequeueActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortFreezeAction() {
		return portFreezeActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortSendAction() {
		return portSendActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortSendAction_PortName() {
		return (EReference)portSendActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortSendAction_ValueExpressionOwned() {
		return (EReference)portSendActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSharedDataAction() {
		return sharedDataActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSharedDataAction_DataAccessName() {
		return (EReference)sharedDataActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramCallAction() {
		return subprogramCallActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramCallAction_SubprogramNames() {
		return (EReference)subprogramCallActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramCallAction_SubprogramReference() {
		return (EReference)subprogramCallActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramCallAction_ParameterLabels() {
		return (EReference)subprogramCallActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTarget() {
		return targetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimedAction() {
		return timedActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimedAction_LowerBehaviorTime() {
		return (EReference)timedActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimedAction_UpperBehaviorTime() {
		return (EReference)timedActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnlockAction() {
		return unlockActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileOrDoUntilStatement() {
		return whileOrDoUntilStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileOrDoUntilStatement_LogicalValueExpression() {
		return (EReference)whileOrDoUntilStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWhileOrDoUntilStatement_DoUntil() {
		return (EAttribute)whileOrDoUntilStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompletionRelativeTimeoutConditionAndCatch() {
		return completionRelativeTimeoutConditionAndCatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDispatchCondition() {
		return dispatchConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDispatchCondition_DispatchTriggerConditionOwned() {
		return (EReference)dispatchConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDispatchCondition_FrozenPorts() {
		return (EReference)dispatchConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDispatchConjunction() {
		return dispatchConjunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDispatchConjunction_DispatchTriggers() {
		return (EReference)dispatchConjunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDispatchTriggerCondition() {
		return dispatchTriggerConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDispatchTriggerConditionStop() {
		return dispatchTriggerConditionStopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDispatchTriggerLogicalExpression() {
		return dispatchTriggerLogicalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDispatchTriggerLogicalExpression_DispatchConjunctions() {
		return (EReference)dispatchTriggerLogicalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBehaviorAnnexFeatureType() {
		return behaviorAnnexFeatureTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFeatureType() {
		return featureTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBinaryAddingOperator() {
		return binaryAddingOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBinaryNumericOperator() {
		return binaryNumericOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLogicalOperator() {
		return logicalOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMultiplyingOperator() {
		return multiplyingOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRelationalOperator() {
		return relationalOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnaryAddingOperator() {
		return unaryAddingOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnaryBooleanOperator() {
		return unaryBooleanOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnaryNumericOperator() {
		return unaryNumericOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBoolean() {
		return booleanEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInteger() {
		return integerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getReal() {
		return realEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getString() {
		return stringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AadlBaFactory getAadlBaFactory() {
		return (AadlBaFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		behaviorAnnexEClass = createEClass(BEHAVIOR_ANNEX);
		createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__BEHAVIOR_VARIABLES);
		createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__BEHAVIOR_STATES);
		createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__BEHAVIOR_TRANSITIONS);

		behaviorConditionEClass = createEClass(BEHAVIOR_CONDITION);

		behaviorStateEClass = createEClass(BEHAVIOR_STATE);
		createEReference(behaviorStateEClass, BEHAVIOR_STATE__IDENTIFIERS);
		createEAttribute(behaviorStateEClass, BEHAVIOR_STATE__INITIAL);
		createEAttribute(behaviorStateEClass, BEHAVIOR_STATE__COMPLETE);
		createEAttribute(behaviorStateEClass, BEHAVIOR_STATE__FINAL);

		behaviorTransitionEClass = createEClass(BEHAVIOR_TRANSITION);
		createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER);
		createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS);
		createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED);
		createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER);
		createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__BEHAVIOR_ACTION_BLOCK_OWNED);
		createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY);

		behaviorVariableEClass = createEClass(BEHAVIOR_VARIABLE);
		createEReference(behaviorVariableEClass, BEHAVIOR_VARIABLE__LOCAL_VARIABLE_DECLARATORS);
		createEReference(behaviorVariableEClass, BEHAVIOR_VARIABLE__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE);

		commentEClass = createEClass(COMMENT);
		createEAttribute(commentEClass, COMMENT__BODY);

		declaratorEClass = createEClass(DECLARATOR);
		createEReference(declaratorEClass, DECLARATOR__IDENTIFIER_OWNED);
		createEReference(declaratorEClass, DECLARATOR__ARRAY_SIZES);

		elementEClass = createEClass(ELEMENT);
		createEReference(elementEClass, ELEMENT__BA_REF);
		createEReference(elementEClass, ELEMENT__AADL_REF);

		executeConditionEClass = createEClass(EXECUTE_CONDITION);

		identifierEClass = createEClass(IDENTIFIER);
		createEAttribute(identifierEClass, IDENTIFIER__ID);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__QUALIFIED_NAME);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAMESPACE_SEPARATOR);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAMESPACE);

		otherwiseEClass = createEClass(OTHERWISE);

		timeoutCatchEClass = createEClass(TIMEOUT_CATCH);

		uniqueComponentClassifierReferenceEClass = createEClass(UNIQUE_COMPONENT_CLASSIFIER_REFERENCE);

		behaviorTimeEClass = createEClass(BEHAVIOR_TIME);
		createEReference(behaviorTimeEClass, BEHAVIOR_TIME__INTEGER_VALUE_OWNED);
		createEReference(behaviorTimeEClass, BEHAVIOR_TIME__UNIT_IDENTIFIER);

		booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
		createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__VALUE);

		factorEClass = createEClass(FACTOR);
		createEReference(factorEClass, FACTOR__VALUE_OWNED);
		createEReference(factorEClass, FACTOR__VALUE_SD_OWNED);
		createEAttribute(factorEClass, FACTOR__BINARY_NUMERIC_OPERATOR_OWNED);
		createEAttribute(factorEClass, FACTOR__UNARY_NUMERIC_OPERATOR_OWNED);
		createEAttribute(factorEClass, FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED);

		integerLiteralEClass = createEClass(INTEGER_LITERAL);
		createEAttribute(integerLiteralEClass, INTEGER_LITERAL__VALUE);
		createEAttribute(integerLiteralEClass, INTEGER_LITERAL__BASE);

		integerRangeEClass = createEClass(INTEGER_RANGE);
		createEReference(integerRangeEClass, INTEGER_RANGE__LOWER_INTEGER_VALUE);
		createEReference(integerRangeEClass, INTEGER_RANGE__UPPER_INTEGER_VALUE);

		integerValueEClass = createEClass(INTEGER_VALUE);

		integerValueConstantEClass = createEClass(INTEGER_VALUE_CONSTANT);

		integerValueVariableEClass = createEClass(INTEGER_VALUE_VARIABLE);

		literalEClass = createEClass(LITERAL);

		numeralEClass = createEClass(NUMERAL);
		createEAttribute(numeralEClass, NUMERAL__VALUE);

		numericLiteralEClass = createEClass(NUMERIC_LITERAL);
		createEAttribute(numericLiteralEClass, NUMERIC_LITERAL__VALUE_STRING);

		propertyConstantEClass = createEClass(PROPERTY_CONSTANT);

		propertyValueEClass = createEClass(PROPERTY_VALUE);

		portCountValueEClass = createEClass(PORT_COUNT_VALUE);

		portDequeueValueEClass = createEClass(PORT_DEQUEUE_VALUE);

		portFreshValueEClass = createEClass(PORT_FRESH_VALUE);

		realLiteralEClass = createEClass(REAL_LITERAL);
		createEAttribute(realLiteralEClass, REAL_LITERAL__VALUE);

		relationEClass = createEClass(RELATION);
		createEReference(relationEClass, RELATION__SIMPLE_EXPRESSION_OWNED);
		createEReference(relationEClass, RELATION__SIMPLE_EXPRESSION_SD_OWNED);
		createEAttribute(relationEClass, RELATION__RELATIONAL_OPERATOR_OWNED);

		simpleExpressionEClass = createEClass(SIMPLE_EXPRESSION);
		createEAttribute(simpleExpressionEClass, SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED);
		createEReference(simpleExpressionEClass, SIMPLE_EXPRESSION__TERMS);
		createEAttribute(simpleExpressionEClass, SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS);

		stringLiteralEClass = createEClass(STRING_LITERAL);
		createEAttribute(stringLiteralEClass, STRING_LITERAL__VALUE);

		termEClass = createEClass(TERM);
		createEReference(termEClass, TERM__FACTORS);
		createEAttribute(termEClass, TERM__MULTIPLYING_OPERATORS);

		valueEClass = createEClass(VALUE);

		valueConstantEClass = createEClass(VALUE_CONSTANT);

		valueExpressionEClass = createEClass(VALUE_EXPRESSION);
		createEReference(valueExpressionEClass, VALUE_EXPRESSION__RELATIONS);
		createEAttribute(valueExpressionEClass, VALUE_EXPRESSION__LOGICAL_OPERATORS);

		valueVariableEClass = createEClass(VALUE_VARIABLE);

		assignmentActionEClass = createEClass(ASSIGNMENT_ACTION);
		createEReference(assignmentActionEClass, ASSIGNMENT_ACTION__TARGET_OWNED);
		createEReference(assignmentActionEClass, ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED);
		createEAttribute(assignmentActionEClass, ASSIGNMENT_ACTION__ANY);

		basicActionEClass = createEClass(BASIC_ACTION);

		behaviorActionEClass = createEClass(BEHAVIOR_ACTION);

		behaviorActionBlockEClass = createEClass(BEHAVIOR_ACTION_BLOCK);
		createEReference(behaviorActionBlockEClass, BEHAVIOR_ACTION_BLOCK__BEHAVIOR_ACTIONS_OWNED);
		createEReference(behaviorActionBlockEClass, BEHAVIOR_ACTION_BLOCK__BEHAVIOR_TIME_OWNED);

		behaviorActionCollectionEClass = createEClass(BEHAVIOR_ACTION_COLLECTION);
		createEReference(behaviorActionCollectionEClass, BEHAVIOR_ACTION_COLLECTION__BEHAVIOR_ACTIONS);

		behaviorActionsEClass = createEClass(BEHAVIOR_ACTIONS);

		behaviorActionSequenceEClass = createEClass(BEHAVIOR_ACTION_SEQUENCE);

		behaviorActionSetEClass = createEClass(BEHAVIOR_ACTION_SET);

		communicationActionEClass = createEClass(COMMUNICATION_ACTION);

		condStatementEClass = createEClass(COND_STATEMENT);

		dataComponentReferenceEClass = createEClass(DATA_COMPONENT_REFERENCE);
		createEReference(dataComponentReferenceEClass, DATA_COMPONENT_REFERENCE__NAMES);

		elementValuesEClass = createEClass(ELEMENT_VALUES);

		forOrForAllStatementEClass = createEClass(FOR_OR_FOR_ALL_STATEMENT);
		createEReference(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__ELEMENT_IDENTIFIER);
		createEReference(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE);
		createEReference(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED);
		createEAttribute(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__FOR_ALL);

		ifStatementEClass = createEClass(IF_STATEMENT);
		createEAttribute(ifStatementEClass, IF_STATEMENT__HAS_ELSE);
		createEReference(ifStatementEClass, IF_STATEMENT__LOGICAL_VALUE_EXPRESSIONS);
		createEReference(ifStatementEClass, IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED);

		lockActionEClass = createEClass(LOCK_ACTION);

		loopStatementEClass = createEClass(LOOP_STATEMENT);
		createEReference(loopStatementEClass, LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED);

		nameEClass = createEClass(NAME);
		createEReference(nameEClass, NAME__IDENTIFIER_OWNED);
		createEReference(nameEClass, NAME__ARRAY_INDEXES);

		parameterLabelEClass = createEClass(PARAMETER_LABEL);

		portDequeueActionEClass = createEClass(PORT_DEQUEUE_ACTION);
		createEReference(portDequeueActionEClass, PORT_DEQUEUE_ACTION__PORT_NAME);
		createEReference(portDequeueActionEClass, PORT_DEQUEUE_ACTION__TARGET_OWNED);

		portFreezeActionEClass = createEClass(PORT_FREEZE_ACTION);

		portSendActionEClass = createEClass(PORT_SEND_ACTION);
		createEReference(portSendActionEClass, PORT_SEND_ACTION__PORT_NAME);
		createEReference(portSendActionEClass, PORT_SEND_ACTION__VALUE_EXPRESSION_OWNED);

		sharedDataActionEClass = createEClass(SHARED_DATA_ACTION);
		createEReference(sharedDataActionEClass, SHARED_DATA_ACTION__DATA_ACCESS_NAME);

		subprogramCallActionEClass = createEClass(SUBPROGRAM_CALL_ACTION);
		createEReference(subprogramCallActionEClass, SUBPROGRAM_CALL_ACTION__SUBPROGRAM_NAMES);
		createEReference(subprogramCallActionEClass, SUBPROGRAM_CALL_ACTION__SUBPROGRAM_REFERENCE);
		createEReference(subprogramCallActionEClass, SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS);

		targetEClass = createEClass(TARGET);

		timedActionEClass = createEClass(TIMED_ACTION);
		createEReference(timedActionEClass, TIMED_ACTION__LOWER_BEHAVIOR_TIME);
		createEReference(timedActionEClass, TIMED_ACTION__UPPER_BEHAVIOR_TIME);

		unlockActionEClass = createEClass(UNLOCK_ACTION);

		whileOrDoUntilStatementEClass = createEClass(WHILE_OR_DO_UNTIL_STATEMENT);
		createEReference(whileOrDoUntilStatementEClass, WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION);
		createEAttribute(whileOrDoUntilStatementEClass, WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL);

		completionRelativeTimeoutConditionAndCatchEClass = createEClass(COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH);

		dispatchConditionEClass = createEClass(DISPATCH_CONDITION);
		createEReference(dispatchConditionEClass, DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION_OWNED);
		createEReference(dispatchConditionEClass, DISPATCH_CONDITION__FROZEN_PORTS);

		dispatchConjunctionEClass = createEClass(DISPATCH_CONJUNCTION);
		createEReference(dispatchConjunctionEClass, DISPATCH_CONJUNCTION__DISPATCH_TRIGGERS);

		dispatchTriggerConditionEClass = createEClass(DISPATCH_TRIGGER_CONDITION);

		dispatchTriggerConditionStopEClass = createEClass(DISPATCH_TRIGGER_CONDITION_STOP);

		dispatchTriggerLogicalExpressionEClass = createEClass(DISPATCH_TRIGGER_LOGICAL_EXPRESSION);
		createEReference(dispatchTriggerLogicalExpressionEClass, DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS);

		// Create enums
		behaviorAnnexFeatureTypeEEnum = createEEnum(BEHAVIOR_ANNEX_FEATURE_TYPE);
		dataRepresentationEEnum = createEEnum(DATA_REPRESENTATION);
		featureTypeEEnum = createEEnum(FEATURE_TYPE);
		binaryAddingOperatorEEnum = createEEnum(BINARY_ADDING_OPERATOR);
		binaryNumericOperatorEEnum = createEEnum(BINARY_NUMERIC_OPERATOR);
		logicalOperatorEEnum = createEEnum(LOGICAL_OPERATOR);
		multiplyingOperatorEEnum = createEEnum(MULTIPLYING_OPERATOR);
		relationalOperatorEEnum = createEEnum(RELATIONAL_OPERATOR);
		unaryAddingOperatorEEnum = createEEnum(UNARY_ADDING_OPERATOR);
		unaryBooleanOperatorEEnum = createEEnum(UNARY_BOOLEAN_OPERATOR);
		unaryNumericOperatorEEnum = createEEnum(UNARY_NUMERIC_OPERATOR);

		// Create data types
		booleanEDataType = createEDataType(BOOLEAN);
		integerEDataType = createEDataType(INTEGER);
		realEDataType = createEDataType(REAL);
		stringEDataType = createEDataType(STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		behaviorAnnexEClass.getESuperTypes().add(theAadl2Package.getAnnexSubclause());
		behaviorAnnexEClass.getESuperTypes().add(this.getElement());
		behaviorConditionEClass.getESuperTypes().add(this.getElement());
		behaviorStateEClass.getESuperTypes().add(this.getElement());
		behaviorTransitionEClass.getESuperTypes().add(this.getElement());
		behaviorVariableEClass.getESuperTypes().add(this.getElement());
		commentEClass.getESuperTypes().add(this.getElement());
		declaratorEClass.getESuperTypes().add(this.getElement());
		elementEClass.getESuperTypes().add(theAadl2Package.getElement());
		executeConditionEClass.getESuperTypes().add(this.getBehaviorCondition());
		identifierEClass.getESuperTypes().add(this.getElement());
		identifierEClass.getESuperTypes().add(this.getDispatchTriggerCondition());
		namedElementEClass.getESuperTypes().add(this.getElement());
		otherwiseEClass.getESuperTypes().add(this.getExecuteCondition());
		timeoutCatchEClass.getESuperTypes().add(this.getExecuteCondition());
		timeoutCatchEClass.getESuperTypes().add(this.getDispatchTriggerCondition());
		uniqueComponentClassifierReferenceEClass.getESuperTypes().add(this.getNamedElement());
		behaviorTimeEClass.getESuperTypes().add(this.getElement());
		booleanLiteralEClass.getESuperTypes().add(this.getLiteral());
		factorEClass.getESuperTypes().add(this.getElement());
		integerLiteralEClass.getESuperTypes().add(this.getNumericLiteral());
		integerRangeEClass.getESuperTypes().add(this.getElementValues());
		integerValueEClass.getESuperTypes().add(this.getElement());
		integerValueConstantEClass.getESuperTypes().add(this.getIntegerValue());
		integerValueVariableEClass.getESuperTypes().add(this.getIntegerValue());
		literalEClass.getESuperTypes().add(this.getValueConstant());
		numeralEClass.getESuperTypes().add(this.getElement());
		numericLiteralEClass.getESuperTypes().add(this.getLiteral());
		propertyConstantEClass.getESuperTypes().add(this.getNamedElement());
		propertyConstantEClass.getESuperTypes().add(this.getValueConstant());
		propertyValueEClass.getESuperTypes().add(this.getNamedElement());
		propertyValueEClass.getESuperTypes().add(this.getValueConstant());
		portCountValueEClass.getESuperTypes().add(this.getValueVariable());
		portCountValueEClass.getESuperTypes().add(this.getName_());
		portDequeueValueEClass.getESuperTypes().add(this.getValueVariable());
		portDequeueValueEClass.getESuperTypes().add(this.getName_());
		portFreshValueEClass.getESuperTypes().add(this.getValueVariable());
		portFreshValueEClass.getESuperTypes().add(this.getName_());
		realLiteralEClass.getESuperTypes().add(this.getNumericLiteral());
		relationEClass.getESuperTypes().add(this.getElement());
		simpleExpressionEClass.getESuperTypes().add(this.getElement());
		stringLiteralEClass.getESuperTypes().add(this.getLiteral());
		termEClass.getESuperTypes().add(this.getElement());
		valueEClass.getESuperTypes().add(this.getElement());
		valueConstantEClass.getESuperTypes().add(this.getValue());
		valueConstantEClass.getESuperTypes().add(this.getIntegerValueConstant());
		valueExpressionEClass.getESuperTypes().add(this.getValue());
		valueExpressionEClass.getESuperTypes().add(this.getParameterLabel());
		valueExpressionEClass.getESuperTypes().add(this.getExecuteCondition());
		valueVariableEClass.getESuperTypes().add(this.getValue());
		valueVariableEClass.getESuperTypes().add(this.getIntegerValueVariable());
		assignmentActionEClass.getESuperTypes().add(this.getBasicAction());
		basicActionEClass.getESuperTypes().add(this.getBehaviorAction());
		behaviorActionEClass.getESuperTypes().add(this.getBehaviorActions());
		behaviorActionBlockEClass.getESuperTypes().add(this.getElement());
		behaviorActionBlockEClass.getESuperTypes().add(this.getBehaviorAction());
		behaviorActionCollectionEClass.getESuperTypes().add(this.getBehaviorActions());
		behaviorActionsEClass.getESuperTypes().add(this.getElement());
		behaviorActionSequenceEClass.getESuperTypes().add(this.getBehaviorActionCollection());
		behaviorActionSetEClass.getESuperTypes().add(this.getBehaviorActionCollection());
		communicationActionEClass.getESuperTypes().add(this.getBasicAction());
		condStatementEClass.getESuperTypes().add(this.getBehaviorAction());
		dataComponentReferenceEClass.getESuperTypes().add(this.getElementValues());
		dataComponentReferenceEClass.getESuperTypes().add(this.getTarget());
		dataComponentReferenceEClass.getESuperTypes().add(this.getValueVariable());
		elementValuesEClass.getESuperTypes().add(this.getElement());
		forOrForAllStatementEClass.getESuperTypes().add(this.getLoopStatement());
		ifStatementEClass.getESuperTypes().add(this.getCondStatement());
		lockActionEClass.getESuperTypes().add(this.getSharedDataAction());
		loopStatementEClass.getESuperTypes().add(this.getCondStatement());
		nameEClass.getESuperTypes().add(this.getElementValues());
		nameEClass.getESuperTypes().add(this.getTarget());
		nameEClass.getESuperTypes().add(this.getValueVariable());
		parameterLabelEClass.getESuperTypes().add(this.getElement());
		portDequeueActionEClass.getESuperTypes().add(this.getCommunicationAction());
		portFreezeActionEClass.getESuperTypes().add(this.getCommunicationAction());
		portFreezeActionEClass.getESuperTypes().add(this.getName_());
		portSendActionEClass.getESuperTypes().add(this.getCommunicationAction());
		sharedDataActionEClass.getESuperTypes().add(this.getCommunicationAction());
		subprogramCallActionEClass.getESuperTypes().add(this.getCommunicationAction());
		targetEClass.getESuperTypes().add(this.getParameterLabel());
		targetEClass.getESuperTypes().add(this.getElement());
		timedActionEClass.getESuperTypes().add(this.getBasicAction());
		unlockActionEClass.getESuperTypes().add(this.getSharedDataAction());
		whileOrDoUntilStatementEClass.getESuperTypes().add(this.getLoopStatement());
		completionRelativeTimeoutConditionAndCatchEClass.getESuperTypes().add(this.getDispatchTriggerCondition());
		completionRelativeTimeoutConditionAndCatchEClass.getESuperTypes().add(this.getBehaviorTime());
		dispatchConditionEClass.getESuperTypes().add(this.getBehaviorCondition());
		dispatchConjunctionEClass.getESuperTypes().add(this.getElement());
		dispatchTriggerConditionEClass.getESuperTypes().add(this.getElement());
		dispatchTriggerConditionStopEClass.getESuperTypes().add(this.getDispatchTriggerCondition());
		dispatchTriggerLogicalExpressionEClass.getESuperTypes().add(this.getDispatchTriggerCondition());

		// Initialize classes and features; add operations and parameters
		initEClass(behaviorAnnexEClass, BehaviorAnnex.class, "BehaviorAnnex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorAnnex_BehaviorVariables(), this.getBehaviorVariable(), null, "behaviorVariables", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorAnnex_BehaviorStates(), this.getBehaviorState(), null, "behaviorStates", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorAnnex_BehaviorTransitions(), this.getBehaviorTransition(), null, "behaviorTransitions", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorConditionEClass, BehaviorCondition.class, "BehaviorCondition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorStateEClass, BehaviorState.class, "BehaviorState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorState_Identifiers(), this.getIdentifier(), null, "identifiers", null, 1, -1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorState_Initial(), this.getBoolean(), "initial", "false", 1, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorState_Complete(), this.getBoolean(), "complete", "false", 1, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorState_Final(), this.getBoolean(), "final", "false", 1, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorTransitionEClass, BehaviorTransition.class, "BehaviorTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorTransition_TransitionIdentifier(), this.getIdentifier(), null, "transitionIdentifier", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorTransition_SourceStateIdentifiers(), this.getIdentifier(), null, "sourceStateIdentifiers", null, 1, -1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorTransition_BehaviorConditionOwned(), this.getBehaviorCondition(), null, "behaviorConditionOwned", null, 1, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorTransition_DestinationStateIdentifier(), this.getIdentifier(), null, "destinationStateIdentifier", null, 1, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorTransition_BehaviorActionBlockOwned(), this.getBehaviorActionBlock(), null, "behaviorActionBlockOwned", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorTransition_BehaviorTransitionPriority(), this.getNumeral(), null, "behaviorTransitionPriority", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorVariableEClass, BehaviorVariable.class, "BehaviorVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorVariable_LocalVariableDeclarators(), this.getDeclarator(), null, "LocalVariableDeclarators", null, 1, -1, BehaviorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorVariable_DataUniqueComponentClassifierReference(), this.getUniqueComponentClassifierReference(), null, "DataUniqueComponentClassifierReference", null, 1, 1, BehaviorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commentEClass, Comment.class, "Comment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComment_Body(), this.getString(), "body", null, 0, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(declaratorEClass, Declarator.class, "Declarator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeclarator_IdentifierOwned(), this.getIdentifier(), null, "identifierOwned", null, 1, 1, Declarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeclarator_ArraySizes(), this.getIntegerValueConstant(), null, "arraySizes", null, 0, -1, Declarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElement_BaRef(), this.getElement(), null, "baRef", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElement_AadlRef(), theAadl2Package.getElement(), null, "aadlRef", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executeConditionEClass, ExecuteCondition.class, "ExecuteCondition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(identifierEClass, Identifier.class, "Identifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifier_Id(), this.getString(), "id", null, 0, 1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), this.getString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNamedElement_QualifiedName(), this.getString(), "qualifiedName", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNamedElement_NamespaceSeparator(), this.getString(), "namespaceSeparator", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_Namespace(), this.getString(), "namespace", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(otherwiseEClass, Otherwise.class, "Otherwise", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(timeoutCatchEClass, TimeoutCatch.class, "TimeoutCatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(uniqueComponentClassifierReferenceEClass, UniqueComponentClassifierReference.class, "UniqueComponentClassifierReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorTimeEClass, BehaviorTime.class, "BehaviorTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorTime_IntegerValueOwned(), this.getIntegerValue(), null, "integerValueOwned", null, 1, 1, BehaviorTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorTime_UnitIdentifier(), this.getIdentifier(), null, "unitIdentifier", null, 1, 1, BehaviorTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteral_Value(), this.getBoolean(), "value", "false", 0, 1, BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(factorEClass, Factor.class, "Factor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFactor_ValueOwned(), this.getValue(), null, "valueOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFactor_ValueSdOwned(), this.getValue(), null, "valueSdOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFactor_BinaryNumericOperatorOwned(), this.getBinaryNumericOperator(), "binaryNumericOperatorOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFactor_UnaryNumericOperatorOwned(), this.getUnaryNumericOperator(), "unaryNumericOperatorOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFactor_UnaryBooleanOperatorOwned(), this.getUnaryBooleanOperator(), "unaryBooleanOperatorOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerLiteralEClass, IntegerLiteral.class, "IntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteral_Value(), theAadl2Package.getInteger(), "value", "-1", 1, 1, IntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegerLiteral_Base(), this.getInteger(), "base", "-1", 1, 1, IntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerRangeEClass, IntegerRange.class, "IntegerRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntegerRange_LowerIntegerValue(), this.getIntegerValue(), null, "lowerIntegerValue", null, 1, 1, IntegerRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntegerRange_UpperIntegerValue(), this.getIntegerValue(), null, "upperIntegerValue", null, 1, 1, IntegerRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerValueEClass, IntegerValue.class, "IntegerValue", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerValueConstantEClass, IntegerValueConstant.class, "IntegerValueConstant", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerValueVariableEClass, IntegerValueVariable.class, "IntegerValueVariable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalEClass, Literal.class, "Literal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numeralEClass, Numeral.class, "Numeral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumeral_Value(), this.getInteger(), "value", null, 0, 1, Numeral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numericLiteralEClass, NumericLiteral.class, "NumericLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumericLiteral_ValueString(), this.getString(), "valueString", null, 1, 1, NumericLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyConstantEClass, PropertyConstant.class, "PropertyConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyValueEClass, PropertyValue.class, "PropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(portCountValueEClass, PortCountValue.class, "PortCountValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(portDequeueValueEClass, PortDequeueValue.class, "PortDequeueValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(portFreshValueEClass, PortFreshValue.class, "PortFreshValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(realLiteralEClass, RealLiteral.class, "RealLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRealLiteral_Value(), this.getReal(), "value", "-1.0", 0, 1, RealLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationEClass, Relation.class, "Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelation_SimpleExpressionOwned(), this.getSimpleExpression(), null, "simpleExpressionOwned", null, 1, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_SimpleExpressionSdOwned(), this.getSimpleExpression(), null, "simpleExpressionSdOwned", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelation_RelationalOperatorOwned(), this.getRelationalOperator(), "relationalOperatorOwned", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleExpressionEClass, SimpleExpression.class, "SimpleExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleExpression_UnaryAddingOperatorOwned(), this.getUnaryAddingOperator(), "unaryAddingOperatorOwned", null, 0, 1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleExpression_Terms(), this.getTerm(), null, "terms", null, 1, -1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleExpression_BinaryAddingOperators(), this.getBinaryAddingOperator(), "binaryAddingOperators", null, 0, -1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteral_Value(), this.getString(), "value", null, 1, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(termEClass, Term.class, "Term", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerm_Factors(), this.getFactor(), null, "factors", null, 1, -1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTerm_MultiplyingOperators(), this.getMultiplyingOperator(), "multiplyingOperators", null, 0, -1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueConstantEClass, ValueConstant.class, "ValueConstant", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueExpressionEClass, ValueExpression.class, "ValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValueExpression_Relations(), this.getRelation(), null, "relations", null, 1, -1, ValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValueExpression_LogicalOperators(), this.getLogicalOperator(), "logicalOperators", null, 0, -1, ValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueVariableEClass, ValueVariable.class, "ValueVariable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignmentActionEClass, AssignmentAction.class, "AssignmentAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignmentAction_TargetOwned(), this.getTarget(), null, "targetOwned", null, 1, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignmentAction_ValueExpressionOwned(), this.getValueExpression(), null, "valueExpressionOwned", null, 0, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignmentAction_Any(), this.getBoolean(), "any", "false", 0, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicActionEClass, BasicAction.class, "BasicAction", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorActionEClass, BehaviorAction.class, "BehaviorAction", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorActionBlockEClass, BehaviorActionBlock.class, "BehaviorActionBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorActionBlock_BehaviorActionsOwned(), this.getBehaviorActions(), null, "behaviorActionsOwned", null, 1, 1, BehaviorActionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorActionBlock_BehaviorTimeOwned(), this.getBehaviorTime(), null, "behaviorTimeOwned", null, 0, 1, BehaviorActionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorActionCollectionEClass, BehaviorActionCollection.class, "BehaviorActionCollection", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorActionCollection_BehaviorActions(), this.getBehaviorAction(), null, "behaviorActions", null, 1, -1, BehaviorActionCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorActionsEClass, BehaviorActions.class, "BehaviorActions", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorActionSequenceEClass, BehaviorActionSequence.class, "BehaviorActionSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorActionSetEClass, BehaviorActionSet.class, "BehaviorActionSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(communicationActionEClass, CommunicationAction.class, "CommunicationAction", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(condStatementEClass, CondStatement.class, "CondStatement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataComponentReferenceEClass, DataComponentReference.class, "DataComponentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataComponentReference_Names(), this.getName_(), null, "names", null, 1, -1, DataComponentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementValuesEClass, ElementValues.class, "ElementValues", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forOrForAllStatementEClass, ForOrForAllStatement.class, "ForOrForAllStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForOrForAllStatement_ElementIdentifier(), this.getIdentifier(), null, "elementIdentifier", null, 1, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForOrForAllStatement_DataUniqueComponentClassifierReference(), this.getUniqueComponentClassifierReference(), null, "dataUniqueComponentClassifierReference", null, 1, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForOrForAllStatement_ElementValuesOwned(), this.getElementValues(), null, "elementValuesOwned", null, 1, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForOrForAllStatement_ForAll(), this.getBoolean(), "forAll", "false", 0, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIfStatement_HasElse(), this.getBoolean(), "hasElse", "false", 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_LogicalValueExpressions(), this.getValueExpression(), null, "logicalValueExpressions", null, 1, -1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_BehaviorActionsOwned(), this.getBehaviorActions(), null, "behaviorActionsOwned", null, 1, -1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lockActionEClass, LockAction.class, "LockAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopStatementEClass, LoopStatement.class, "LoopStatement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopStatement_BehaviorActionsOwned(), this.getBehaviorActions(), null, "behaviorActionsOwned", null, 1, 1, LoopStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameEClass, Name.class, "Name", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getName_IdentifierOwned(), this.getIdentifier(), null, "identifierOwned", null, 1, 1, Name.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getName_ArrayIndexes(), this.getIntegerValueVariable(), null, "arrayIndexes", null, 0, -1, Name.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterLabelEClass, ParameterLabel.class, "ParameterLabel", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(portDequeueActionEClass, PortDequeueAction.class, "PortDequeueAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPortDequeueAction_PortName(), this.getName_(), null, "portName", null, 1, 1, PortDequeueAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortDequeueAction_TargetOwned(), this.getTarget(), null, "targetOwned", null, 0, 1, PortDequeueAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portFreezeActionEClass, PortFreezeAction.class, "PortFreezeAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(portSendActionEClass, PortSendAction.class, "PortSendAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPortSendAction_PortName(), this.getName_(), null, "portName", null, 1, 1, PortSendAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortSendAction_ValueExpressionOwned(), this.getValueExpression(), null, "valueExpressionOwned", null, 0, 1, PortSendAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sharedDataActionEClass, SharedDataAction.class, "SharedDataAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSharedDataAction_DataAccessName(), this.getName_(), null, "dataAccessName", null, 0, 1, SharedDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subprogramCallActionEClass, SubprogramCallAction.class, "SubprogramCallAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubprogramCallAction_SubprogramNames(), this.getName_(), null, "subprogramNames", null, 0, 2, SubprogramCallAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubprogramCallAction_SubprogramReference(), this.getUniqueComponentClassifierReference(), null, "subprogramReference", null, 0, 1, SubprogramCallAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubprogramCallAction_ParameterLabels(), this.getParameterLabel(), null, "parameterLabels", null, 0, -1, SubprogramCallAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetEClass, Target.class, "Target", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(timedActionEClass, TimedAction.class, "TimedAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimedAction_LowerBehaviorTime(), this.getBehaviorTime(), null, "lowerBehaviorTime", null, 1, 1, TimedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimedAction_UpperBehaviorTime(), this.getBehaviorTime(), null, "upperBehaviorTime", null, 0, 1, TimedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unlockActionEClass, UnlockAction.class, "UnlockAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(whileOrDoUntilStatementEClass, WhileOrDoUntilStatement.class, "WhileOrDoUntilStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhileOrDoUntilStatement_LogicalValueExpression(), this.getValueExpression(), null, "logicalValueExpression", null, 1, 1, WhileOrDoUntilStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWhileOrDoUntilStatement_DoUntil(), this.getBoolean(), "doUntil", "false", 0, 1, WhileOrDoUntilStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(completionRelativeTimeoutConditionAndCatchEClass, CompletionRelativeTimeoutConditionAndCatch.class, "CompletionRelativeTimeoutConditionAndCatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dispatchConditionEClass, DispatchCondition.class, "DispatchCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDispatchCondition_DispatchTriggerConditionOwned(), this.getDispatchTriggerCondition(), null, "dispatchTriggerConditionOwned", null, 0, 1, DispatchCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDispatchCondition_FrozenPorts(), this.getIdentifier(), null, "frozenPorts", null, 0, -1, DispatchCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dispatchConjunctionEClass, DispatchConjunction.class, "DispatchConjunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDispatchConjunction_DispatchTriggers(), this.getIdentifier(), null, "dispatchTriggers", null, 1, -1, DispatchConjunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dispatchTriggerConditionEClass, DispatchTriggerCondition.class, "DispatchTriggerCondition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dispatchTriggerConditionStopEClass, DispatchTriggerConditionStop.class, "DispatchTriggerConditionStop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dispatchTriggerLogicalExpressionEClass, DispatchTriggerLogicalExpression.class, "DispatchTriggerLogicalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDispatchTriggerLogicalExpression_DispatchConjunctions(), this.getDispatchConjunction(), null, "dispatchConjunctions", null, 1, -1, DispatchTriggerLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(behaviorAnnexFeatureTypeEEnum, BehaviorAnnexFeatureType.class, "BehaviorAnnexFeatureType");
		addEEnumLiteral(behaviorAnnexFeatureTypeEEnum, BehaviorAnnexFeatureType.NONE);
		addEEnumLiteral(behaviorAnnexFeatureTypeEEnum, BehaviorAnnexFeatureType.BEHAVIOR_VARIABLE);
		addEEnumLiteral(behaviorAnnexFeatureTypeEEnum, BehaviorAnnexFeatureType.UNIQUE_COMPONENT_CLASSIFIER_REFERENCE);

		initEEnum(dataRepresentationEEnum, DataRepresentation.class, "DataRepresentation");
      addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.UNKNOWN);
      addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.INTEGER);
      addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.FLOAT);
      addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.CHARACTER);
      addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.BOOLEAN);
      addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.STRING);
		
		initEEnum(featureTypeEEnum, FeatureType.class, "FeatureType");
		addEEnumLiteral(featureTypeEEnum, FeatureType.NONE);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_DATA_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_DATA_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_DATA_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_EVENT_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_EVENT_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_EVENT_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_EVENT_DATA_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_EVENT_DATA_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_EVENT_DATA_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_SUBPROGRAM_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_SUBPROGRAM_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.SUBPROGRAM_SUBCOMPONENT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.SUBPROGRAM_CLASSIFIER);
		addEEnumLiteral(featureTypeEEnum, FeatureType.SUBPROGRAM_PROTOTYPE);
		addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_DATA_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_DATA_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.DATA_SUBCOMPONENT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.DATA_CLASSIFIER);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_PARAMETER);
		addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_PARAMETER);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_PARAMETER);
		addEEnumLiteral(featureTypeEEnum, FeatureType.PROPERTY_CONSTANT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.PROPERTY_VALUE);
		addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_BUS_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_BUS_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.FEATURE_GROUP);
		addEEnumLiteral(featureTypeEEnum, FeatureType.ABSTRACT_FEATURE);

		initEEnum(binaryAddingOperatorEEnum, BinaryAddingOperator.class, "BinaryAddingOperator");
		addEEnumLiteral(binaryAddingOperatorEEnum, BinaryAddingOperator.NONE);
		addEEnumLiteral(binaryAddingOperatorEEnum, BinaryAddingOperator.PLUS);
		addEEnumLiteral(binaryAddingOperatorEEnum, BinaryAddingOperator.MINUS);

		initEEnum(binaryNumericOperatorEEnum, BinaryNumericOperator.class, "BinaryNumericOperator");
		addEEnumLiteral(binaryNumericOperatorEEnum, BinaryNumericOperator.NONE);
		addEEnumLiteral(binaryNumericOperatorEEnum, BinaryNumericOperator.MULTIPLY_MULTIPLY);

		initEEnum(logicalOperatorEEnum, LogicalOperator.class, "LogicalOperator");
		addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.NONE);
		addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.AND);
		addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.OR);
		addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.XOR);

		initEEnum(multiplyingOperatorEEnum, MultiplyingOperator.class, "MultiplyingOperator");
		addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.NONE);
		addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.MULTIPLY);
		addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.DIVIDE);
		addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.MOD);
		addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.REM);

		initEEnum(relationalOperatorEEnum, RelationalOperator.class, "RelationalOperator");
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.NONE);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.EQUAL);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.NOT_EQUAL);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_THAN);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_OR_EQUAL_THAN);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_THAN);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_OR_EQUAL_THAN);

		initEEnum(unaryAddingOperatorEEnum, UnaryAddingOperator.class, "UnaryAddingOperator");
		addEEnumLiteral(unaryAddingOperatorEEnum, UnaryAddingOperator.NONE);
		addEEnumLiteral(unaryAddingOperatorEEnum, UnaryAddingOperator.PLUS);
		addEEnumLiteral(unaryAddingOperatorEEnum, UnaryAddingOperator.MINUS);

		initEEnum(unaryBooleanOperatorEEnum, UnaryBooleanOperator.class, "UnaryBooleanOperator");
		addEEnumLiteral(unaryBooleanOperatorEEnum, UnaryBooleanOperator.NONE);
		addEEnumLiteral(unaryBooleanOperatorEEnum, UnaryBooleanOperator.NOT);

		initEEnum(unaryNumericOperatorEEnum, UnaryNumericOperator.class, "UnaryNumericOperator");
		addEEnumLiteral(unaryNumericOperatorEEnum, UnaryNumericOperator.NONE);
		addEEnumLiteral(unaryNumericOperatorEEnum, UnaryNumericOperator.ABS);

		// Initialize data types
		initEDataType(booleanEDataType, boolean.class, "Boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(integerEDataType, int.class, "Integer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(realEDataType, double.class, "Real", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //AadlBaPackageImpl
