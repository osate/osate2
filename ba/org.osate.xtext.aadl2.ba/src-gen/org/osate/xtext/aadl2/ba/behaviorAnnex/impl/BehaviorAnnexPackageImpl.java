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
package org.osate.xtext.aadl2.ba.behaviorAnnex.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayDimension;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayIndex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionBlock;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSequence;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSet;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActions;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexFactory;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorBooleanLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorIntegerLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorRealLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStringLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchConjunction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerLogicalExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DoUntilStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ElementValues;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ElseIfClause;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.IntegerValue;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchConjunction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyArrayIndex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexPropertyReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexValue;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.Reference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnaryExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceSegment;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ValueConstant;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.WhileStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BehaviorAnnexPackageImpl extends EPackageImpl implements BehaviorAnnexPackage
{
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
  private EClass behaviorVariableGroupEClass = null;

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
  private EClass arrayDimensionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorPropertyAssociationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorStateGroupEClass = null;

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
  private EClass behaviorConditionEClass = null;

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
  private EClass dispatchConditionEClass = null;

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
  private EClass dispatchTriggerLogicalExpressionEClass = null;

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
  private EClass modeSwitchConditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modeSwitchConjunctionEClass = null;

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
  private EClass behaviorActionsEClass = null;

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
  private EClass assignmentActionEClass = null;

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
  private EClass timedActionEClass = null;

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
  private EClass elseIfClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass whileStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass doUntilStatementEClass = null;

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
  private EClass behaviorTimeEClass = null;

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
  private EClass valueExpressionEClass = null;

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
  private EClass behaviorIntegerLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorRealLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorStringLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorBooleanLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referenceExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass hashPropertyReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyReferenceTailEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedPropertyFieldEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyArrayIndexEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyIndexValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyIndexPropertyReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unindexedReferenceExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unindexedReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unindexedReferenceTailEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unindexedReferenceSegmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referenceTailEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referenceSegmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrayIndexEClass = null;

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
  private EClass binaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryExpressionEClass = null;

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
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private BehaviorAnnexPackageImpl()
  {
    super(eNS_URI, BehaviorAnnexFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link BehaviorAnnexPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static BehaviorAnnexPackage init()
  {
    if (isInited) return (BehaviorAnnexPackage)EPackage.Registry.INSTANCE.getEPackage(BehaviorAnnexPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredBehaviorAnnexPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    BehaviorAnnexPackageImpl theBehaviorAnnexPackage = registeredBehaviorAnnexPackage instanceof BehaviorAnnexPackageImpl ? (BehaviorAnnexPackageImpl)registeredBehaviorAnnexPackage : new BehaviorAnnexPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();
    Aadl2Package.eINSTANCE.eClass();

    // Create package meta-data objects
    theBehaviorAnnexPackage.createPackageContents();

    // Initialize created meta-data
    theBehaviorAnnexPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBehaviorAnnexPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(BehaviorAnnexPackage.eNS_URI, theBehaviorAnnexPackage);
    return theBehaviorAnnexPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorAnnex()
  {
    return behaviorAnnexEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorAnnex_VariableGroups()
  {
    return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorAnnex_StateGroups()
  {
    return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorAnnex_Transitions()
  {
    return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorVariableGroup()
  {
    return behaviorVariableGroupEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorVariableGroup_Variables()
  {
    return (EReference)behaviorVariableGroupEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorVariableGroup_DataClassifier()
  {
    return (EReference)behaviorVariableGroupEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorVariableGroup_InitialValue()
  {
    return (EReference)behaviorVariableGroupEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorVariableGroup_PropertyAssociations()
  {
    return (EReference)behaviorVariableGroupEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorVariable()
  {
    return behaviorVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorVariable_Name()
  {
    return (EAttribute)behaviorVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorVariable_ArrayDimensions()
  {
    return (EReference)behaviorVariableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getArrayDimension()
  {
    return arrayDimensionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getArrayDimension_Size()
  {
    return (EReference)arrayDimensionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorPropertyAssociation()
  {
    return behaviorPropertyAssociationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorPropertyAssociation_Property()
  {
    return (EReference)behaviorPropertyAssociationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorPropertyAssociation_OwnedValue()
  {
    return (EReference)behaviorPropertyAssociationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorStateGroup()
  {
    return behaviorStateGroupEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorStateGroup_States()
  {
    return (EReference)behaviorStateGroupEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorStateGroup_Initial()
  {
    return (EAttribute)behaviorStateGroupEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorStateGroup_Complete()
  {
    return (EAttribute)behaviorStateGroupEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorStateGroup_Final()
  {
    return (EAttribute)behaviorStateGroupEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorState()
  {
    return behaviorStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorState_Name()
  {
    return (EAttribute)behaviorStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorTransition()
  {
    return behaviorTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorTransition_Name()
  {
    return (EAttribute)behaviorTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorTransition_Priority()
  {
    return (EAttribute)behaviorTransitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorTransition_SourceStates()
  {
    return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorTransition_Condition()
  {
    return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorTransition_DestinationState()
  {
    return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorTransition_ActionBlock()
  {
    return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorCondition()
  {
    return behaviorConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorCondition_Dispatch()
  {
    return (EReference)behaviorConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorCondition_ModeSwitch()
  {
    return (EReference)behaviorConditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorCondition_Execute()
  {
    return (EReference)behaviorConditionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getExecuteCondition()
  {
    return executeConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getExecuteCondition_Value()
  {
    return (EReference)executeConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getExecuteCondition_Timeout()
  {
    return (EAttribute)executeConditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getExecuteCondition_Otherwise()
  {
    return (EAttribute)executeConditionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDispatchCondition()
  {
    return dispatchConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDispatchCondition_Trigger()
  {
    return (EReference)dispatchConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDispatchCondition_FrozenPorts()
  {
    return (EReference)dispatchConditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDispatchTriggerCondition()
  {
    return dispatchTriggerConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDispatchTriggerCondition_Expression()
  {
    return (EReference)dispatchTriggerConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getDispatchTriggerCondition_Timeout()
  {
    return (EAttribute)dispatchTriggerConditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDispatchTriggerCondition_Time()
  {
    return (EReference)dispatchTriggerConditionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getDispatchTriggerCondition_Stop()
  {
    return (EAttribute)dispatchTriggerConditionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDispatchTriggerLogicalExpression()
  {
    return dispatchTriggerLogicalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDispatchTriggerLogicalExpression_Conjunctions()
  {
    return (EReference)dispatchTriggerLogicalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDispatchConjunction()
  {
    return dispatchConjunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDispatchConjunction_Triggers()
  {
    return (EReference)dispatchConjunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getModeSwitchCondition()
  {
    return modeSwitchConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModeSwitchCondition_Conjunctions()
  {
    return (EReference)modeSwitchConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getModeSwitchConjunction()
  {
    return modeSwitchConjunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModeSwitchConjunction_Triggers()
  {
    return (EReference)modeSwitchConjunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorActionBlock()
  {
    return behaviorActionBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorActionBlock_Content()
  {
    return (EReference)behaviorActionBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorActionBlock_Timeout()
  {
    return (EReference)behaviorActionBlockEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorActions()
  {
    return behaviorActionsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorAction()
  {
    return behaviorActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAssignmentAction()
  {
    return assignmentActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAssignmentAction_Target()
  {
    return (EReference)assignmentActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAssignmentAction_Value()
  {
    return (EReference)assignmentActionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAssignmentAction_Any()
  {
    return (EAttribute)assignmentActionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCommunicationAction()
  {
    return communicationActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCommunicationAction_Reference()
  {
    return (EReference)communicationActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCommunicationAction_Send()
  {
    return (EAttribute)communicationActionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCommunicationAction_Parameters()
  {
    return (EReference)communicationActionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCommunicationAction_Dequeue()
  {
    return (EAttribute)communicationActionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCommunicationAction_Target()
  {
    return (EReference)communicationActionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCommunicationAction_Freeze()
  {
    return (EAttribute)communicationActionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCommunicationAction_Lock()
  {
    return (EAttribute)communicationActionEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCommunicationAction_Unlock()
  {
    return (EAttribute)communicationActionEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCommunicationAction_All()
  {
    return (EAttribute)communicationActionEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCommunicationAction_AllLock()
  {
    return (EAttribute)communicationActionEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCommunicationAction_AllUnlock()
  {
    return (EAttribute)communicationActionEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTimedAction()
  {
    return timedActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTimedAction_LowerTime()
  {
    return (EReference)timedActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTimedAction_UpperTime()
  {
    return (EReference)timedActionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTimedAction_Processors()
  {
    return (EReference)timedActionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIfStatement()
  {
    return ifStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getIfStatement_Condition()
  {
    return (EReference)ifStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getIfStatement_ThenActions()
  {
    return (EReference)ifStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getIfStatement_ElseIfs()
  {
    return (EReference)ifStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getIfStatement_ElseActions()
  {
    return (EReference)ifStatementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getElseIfClause()
  {
    return elseIfClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getElseIfClause_Condition()
  {
    return (EReference)elseIfClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getElseIfClause_Actions()
  {
    return (EReference)elseIfClauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getForStatement()
  {
    return forStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getForStatement_For()
  {
    return (EAttribute)forStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getForStatement_Forall()
  {
    return (EAttribute)forStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getForStatement_Variable()
  {
    return (EAttribute)forStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getForStatement_DataClassifier()
  {
    return (EReference)forStatementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getForStatement_Values()
  {
    return (EReference)forStatementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getForStatement_Actions()
  {
    return (EReference)forStatementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getWhileStatement()
  {
    return whileStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getWhileStatement_Condition()
  {
    return (EReference)whileStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getWhileStatement_Actions()
  {
    return (EReference)whileStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDoUntilStatement()
  {
    return doUntilStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDoUntilStatement_Actions()
  {
    return (EReference)doUntilStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDoUntilStatement_Condition()
  {
    return (EReference)doUntilStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getElementValues()
  {
    return elementValuesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getElementValues_Lower()
  {
    return (EReference)elementValuesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getElementValues_Upper()
  {
    return (EReference)elementValuesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorTime()
  {
    return behaviorTimeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorTime_Value()
  {
    return (EReference)behaviorTimeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorTime_Unit()
  {
    return (EReference)behaviorTimeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIntegerValue()
  {
    return integerValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getValueExpression()
  {
    return valueExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getValueConstant()
  {
    return valueConstantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorIntegerLiteral()
  {
    return behaviorIntegerLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorIntegerLiteral_Value()
  {
    return (EAttribute)behaviorIntegerLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorRealLiteral()
  {
    return behaviorRealLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorRealLiteral_Value()
  {
    return (EAttribute)behaviorRealLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorStringLiteral()
  {
    return behaviorStringLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorStringLiteral_Value()
  {
    return (EAttribute)behaviorStringLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorBooleanLiteral()
  {
    return behaviorBooleanLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorBooleanLiteral_Value()
  {
    return (EAttribute)behaviorBooleanLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getReferenceExpression()
  {
    return referenceExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReferenceExpression_Reference()
  {
    return (EReference)referenceExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReferenceExpression_Property()
  {
    return (EReference)referenceExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getReferenceExpression_Dequeue()
  {
    return (EAttribute)referenceExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getReferenceExpression_Count()
  {
    return (EAttribute)referenceExpressionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getReferenceExpression_Fresh()
  {
    return (EAttribute)referenceExpressionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getHashPropertyReference()
  {
    return hashPropertyReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getHashPropertyReference_Property()
  {
    return (EAttribute)hashPropertyReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getHashPropertyReference_Indexes()
  {
    return (EReference)hashPropertyReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getHashPropertyReference_Fields()
  {
    return (EReference)hashPropertyReferenceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyReferenceTail()
  {
    return propertyReferenceTailEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getPropertyReferenceTail_Property()
  {
    return (EAttribute)propertyReferenceTailEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPropertyReferenceTail_Indexes()
  {
    return (EReference)propertyReferenceTailEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPropertyReferenceTail_Fields()
  {
    return (EReference)propertyReferenceTailEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getNamedPropertyField()
  {
    return namedPropertyFieldEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getNamedPropertyField_Name()
  {
    return (EAttribute)namedPropertyFieldEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getNamedPropertyField_Indexes()
  {
    return (EReference)namedPropertyFieldEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyArrayIndex()
  {
    return propertyArrayIndexEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPropertyArrayIndex_Value()
  {
    return (EReference)propertyArrayIndexEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyIndexValue()
  {
    return propertyIndexValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyIndexPropertyReference()
  {
    return propertyIndexPropertyReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getPropertyIndexPropertyReference_Property()
  {
    return (EAttribute)propertyIndexPropertyReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUnindexedReferenceExpression()
  {
    return unindexedReferenceExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getUnindexedReferenceExpression_Reference()
  {
    return (EReference)unindexedReferenceExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getUnindexedReferenceExpression_Dequeue()
  {
    return (EAttribute)unindexedReferenceExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getUnindexedReferenceExpression_Count()
  {
    return (EAttribute)unindexedReferenceExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getUnindexedReferenceExpression_Fresh()
  {
    return (EAttribute)unindexedReferenceExpressionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUnindexedReference()
  {
    return unindexedReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getUnindexedReference_Segments()
  {
    return (EReference)unindexedReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getUnindexedReference_Tails()
  {
    return (EReference)unindexedReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUnindexedReferenceTail()
  {
    return unindexedReferenceTailEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getUnindexedReferenceTail_Separator()
  {
    return (EAttribute)unindexedReferenceTailEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getUnindexedReferenceTail_Segment()
  {
    return (EReference)unindexedReferenceTailEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUnindexedReferenceSegment()
  {
    return unindexedReferenceSegmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getUnindexedReferenceSegment_Name()
  {
    return (EAttribute)unindexedReferenceSegmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getReference()
  {
    return referenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReference_Segments()
  {
    return (EReference)referenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReference_Tails()
  {
    return (EReference)referenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getReferenceTail()
  {
    return referenceTailEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getReferenceTail_Separator()
  {
    return (EAttribute)referenceTailEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReferenceTail_Segment()
  {
    return (EReference)referenceTailEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getReferenceSegment()
  {
    return referenceSegmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getReferenceSegment_Name()
  {
    return (EAttribute)referenceSegmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReferenceSegment_Indexes()
  {
    return (EReference)referenceSegmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getArrayIndex()
  {
    return arrayIndexEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getArrayIndex_Value()
  {
    return (EReference)arrayIndexEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorActionSequence()
  {
    return behaviorActionSequenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorActionSequence_Actions()
  {
    return (EReference)behaviorActionSequenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorActionSet()
  {
    return behaviorActionSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorActionSet_Actions()
  {
    return (EReference)behaviorActionSetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBinaryExpression()
  {
    return binaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBinaryExpression_Left()
  {
    return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBinaryExpression_Operator()
  {
    return (EAttribute)binaryExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBinaryExpression_Right()
  {
    return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUnaryExpression()
  {
    return unaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getUnaryExpression_Operator()
  {
    return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getUnaryExpression_Operand()
  {
    return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorAnnexFactory getBehaviorAnnexFactory()
  {
    return (BehaviorAnnexFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    behaviorAnnexEClass = createEClass(BEHAVIOR_ANNEX);
    createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__VARIABLE_GROUPS);
    createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__STATE_GROUPS);
    createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__TRANSITIONS);

    behaviorVariableGroupEClass = createEClass(BEHAVIOR_VARIABLE_GROUP);
    createEReference(behaviorVariableGroupEClass, BEHAVIOR_VARIABLE_GROUP__VARIABLES);
    createEReference(behaviorVariableGroupEClass, BEHAVIOR_VARIABLE_GROUP__DATA_CLASSIFIER);
    createEReference(behaviorVariableGroupEClass, BEHAVIOR_VARIABLE_GROUP__INITIAL_VALUE);
    createEReference(behaviorVariableGroupEClass, BEHAVIOR_VARIABLE_GROUP__PROPERTY_ASSOCIATIONS);

    behaviorVariableEClass = createEClass(BEHAVIOR_VARIABLE);
    createEAttribute(behaviorVariableEClass, BEHAVIOR_VARIABLE__NAME);
    createEReference(behaviorVariableEClass, BEHAVIOR_VARIABLE__ARRAY_DIMENSIONS);

    arrayDimensionEClass = createEClass(ARRAY_DIMENSION);
    createEReference(arrayDimensionEClass, ARRAY_DIMENSION__SIZE);

    behaviorPropertyAssociationEClass = createEClass(BEHAVIOR_PROPERTY_ASSOCIATION);
    createEReference(behaviorPropertyAssociationEClass, BEHAVIOR_PROPERTY_ASSOCIATION__PROPERTY);
    createEReference(behaviorPropertyAssociationEClass, BEHAVIOR_PROPERTY_ASSOCIATION__OWNED_VALUE);

    behaviorStateGroupEClass = createEClass(BEHAVIOR_STATE_GROUP);
    createEReference(behaviorStateGroupEClass, BEHAVIOR_STATE_GROUP__STATES);
    createEAttribute(behaviorStateGroupEClass, BEHAVIOR_STATE_GROUP__INITIAL);
    createEAttribute(behaviorStateGroupEClass, BEHAVIOR_STATE_GROUP__COMPLETE);
    createEAttribute(behaviorStateGroupEClass, BEHAVIOR_STATE_GROUP__FINAL);

    behaviorStateEClass = createEClass(BEHAVIOR_STATE);
    createEAttribute(behaviorStateEClass, BEHAVIOR_STATE__NAME);

    behaviorTransitionEClass = createEClass(BEHAVIOR_TRANSITION);
    createEAttribute(behaviorTransitionEClass, BEHAVIOR_TRANSITION__NAME);
    createEAttribute(behaviorTransitionEClass, BEHAVIOR_TRANSITION__PRIORITY);
    createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__SOURCE_STATES);
    createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__CONDITION);
    createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__DESTINATION_STATE);
    createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__ACTION_BLOCK);

    behaviorConditionEClass = createEClass(BEHAVIOR_CONDITION);
    createEReference(behaviorConditionEClass, BEHAVIOR_CONDITION__DISPATCH);
    createEReference(behaviorConditionEClass, BEHAVIOR_CONDITION__MODE_SWITCH);
    createEReference(behaviorConditionEClass, BEHAVIOR_CONDITION__EXECUTE);

    executeConditionEClass = createEClass(EXECUTE_CONDITION);
    createEReference(executeConditionEClass, EXECUTE_CONDITION__VALUE);
    createEAttribute(executeConditionEClass, EXECUTE_CONDITION__TIMEOUT);
    createEAttribute(executeConditionEClass, EXECUTE_CONDITION__OTHERWISE);

    dispatchConditionEClass = createEClass(DISPATCH_CONDITION);
    createEReference(dispatchConditionEClass, DISPATCH_CONDITION__TRIGGER);
    createEReference(dispatchConditionEClass, DISPATCH_CONDITION__FROZEN_PORTS);

    dispatchTriggerConditionEClass = createEClass(DISPATCH_TRIGGER_CONDITION);
    createEReference(dispatchTriggerConditionEClass, DISPATCH_TRIGGER_CONDITION__EXPRESSION);
    createEAttribute(dispatchTriggerConditionEClass, DISPATCH_TRIGGER_CONDITION__TIMEOUT);
    createEReference(dispatchTriggerConditionEClass, DISPATCH_TRIGGER_CONDITION__TIME);
    createEAttribute(dispatchTriggerConditionEClass, DISPATCH_TRIGGER_CONDITION__STOP);

    dispatchTriggerLogicalExpressionEClass = createEClass(DISPATCH_TRIGGER_LOGICAL_EXPRESSION);
    createEReference(dispatchTriggerLogicalExpressionEClass, DISPATCH_TRIGGER_LOGICAL_EXPRESSION__CONJUNCTIONS);

    dispatchConjunctionEClass = createEClass(DISPATCH_CONJUNCTION);
    createEReference(dispatchConjunctionEClass, DISPATCH_CONJUNCTION__TRIGGERS);

    modeSwitchConditionEClass = createEClass(MODE_SWITCH_CONDITION);
    createEReference(modeSwitchConditionEClass, MODE_SWITCH_CONDITION__CONJUNCTIONS);

    modeSwitchConjunctionEClass = createEClass(MODE_SWITCH_CONJUNCTION);
    createEReference(modeSwitchConjunctionEClass, MODE_SWITCH_CONJUNCTION__TRIGGERS);

    behaviorActionBlockEClass = createEClass(BEHAVIOR_ACTION_BLOCK);
    createEReference(behaviorActionBlockEClass, BEHAVIOR_ACTION_BLOCK__CONTENT);
    createEReference(behaviorActionBlockEClass, BEHAVIOR_ACTION_BLOCK__TIMEOUT);

    behaviorActionsEClass = createEClass(BEHAVIOR_ACTIONS);

    behaviorActionEClass = createEClass(BEHAVIOR_ACTION);

    assignmentActionEClass = createEClass(ASSIGNMENT_ACTION);
    createEReference(assignmentActionEClass, ASSIGNMENT_ACTION__TARGET);
    createEReference(assignmentActionEClass, ASSIGNMENT_ACTION__VALUE);
    createEAttribute(assignmentActionEClass, ASSIGNMENT_ACTION__ANY);

    communicationActionEClass = createEClass(COMMUNICATION_ACTION);
    createEReference(communicationActionEClass, COMMUNICATION_ACTION__REFERENCE);
    createEAttribute(communicationActionEClass, COMMUNICATION_ACTION__SEND);
    createEReference(communicationActionEClass, COMMUNICATION_ACTION__PARAMETERS);
    createEAttribute(communicationActionEClass, COMMUNICATION_ACTION__DEQUEUE);
    createEReference(communicationActionEClass, COMMUNICATION_ACTION__TARGET);
    createEAttribute(communicationActionEClass, COMMUNICATION_ACTION__FREEZE);
    createEAttribute(communicationActionEClass, COMMUNICATION_ACTION__LOCK);
    createEAttribute(communicationActionEClass, COMMUNICATION_ACTION__UNLOCK);
    createEAttribute(communicationActionEClass, COMMUNICATION_ACTION__ALL);
    createEAttribute(communicationActionEClass, COMMUNICATION_ACTION__ALL_LOCK);
    createEAttribute(communicationActionEClass, COMMUNICATION_ACTION__ALL_UNLOCK);

    timedActionEClass = createEClass(TIMED_ACTION);
    createEReference(timedActionEClass, TIMED_ACTION__LOWER_TIME);
    createEReference(timedActionEClass, TIMED_ACTION__UPPER_TIME);
    createEReference(timedActionEClass, TIMED_ACTION__PROCESSORS);

    ifStatementEClass = createEClass(IF_STATEMENT);
    createEReference(ifStatementEClass, IF_STATEMENT__CONDITION);
    createEReference(ifStatementEClass, IF_STATEMENT__THEN_ACTIONS);
    createEReference(ifStatementEClass, IF_STATEMENT__ELSE_IFS);
    createEReference(ifStatementEClass, IF_STATEMENT__ELSE_ACTIONS);

    elseIfClauseEClass = createEClass(ELSE_IF_CLAUSE);
    createEReference(elseIfClauseEClass, ELSE_IF_CLAUSE__CONDITION);
    createEReference(elseIfClauseEClass, ELSE_IF_CLAUSE__ACTIONS);

    forStatementEClass = createEClass(FOR_STATEMENT);
    createEAttribute(forStatementEClass, FOR_STATEMENT__FOR);
    createEAttribute(forStatementEClass, FOR_STATEMENT__FORALL);
    createEAttribute(forStatementEClass, FOR_STATEMENT__VARIABLE);
    createEReference(forStatementEClass, FOR_STATEMENT__DATA_CLASSIFIER);
    createEReference(forStatementEClass, FOR_STATEMENT__VALUES);
    createEReference(forStatementEClass, FOR_STATEMENT__ACTIONS);

    whileStatementEClass = createEClass(WHILE_STATEMENT);
    createEReference(whileStatementEClass, WHILE_STATEMENT__CONDITION);
    createEReference(whileStatementEClass, WHILE_STATEMENT__ACTIONS);

    doUntilStatementEClass = createEClass(DO_UNTIL_STATEMENT);
    createEReference(doUntilStatementEClass, DO_UNTIL_STATEMENT__ACTIONS);
    createEReference(doUntilStatementEClass, DO_UNTIL_STATEMENT__CONDITION);

    elementValuesEClass = createEClass(ELEMENT_VALUES);
    createEReference(elementValuesEClass, ELEMENT_VALUES__LOWER);
    createEReference(elementValuesEClass, ELEMENT_VALUES__UPPER);

    behaviorTimeEClass = createEClass(BEHAVIOR_TIME);
    createEReference(behaviorTimeEClass, BEHAVIOR_TIME__VALUE);
    createEReference(behaviorTimeEClass, BEHAVIOR_TIME__UNIT);

    integerValueEClass = createEClass(INTEGER_VALUE);

    valueExpressionEClass = createEClass(VALUE_EXPRESSION);

    valueConstantEClass = createEClass(VALUE_CONSTANT);

    behaviorIntegerLiteralEClass = createEClass(BEHAVIOR_INTEGER_LITERAL);
    createEAttribute(behaviorIntegerLiteralEClass, BEHAVIOR_INTEGER_LITERAL__VALUE);

    behaviorRealLiteralEClass = createEClass(BEHAVIOR_REAL_LITERAL);
    createEAttribute(behaviorRealLiteralEClass, BEHAVIOR_REAL_LITERAL__VALUE);

    behaviorStringLiteralEClass = createEClass(BEHAVIOR_STRING_LITERAL);
    createEAttribute(behaviorStringLiteralEClass, BEHAVIOR_STRING_LITERAL__VALUE);

    behaviorBooleanLiteralEClass = createEClass(BEHAVIOR_BOOLEAN_LITERAL);
    createEAttribute(behaviorBooleanLiteralEClass, BEHAVIOR_BOOLEAN_LITERAL__VALUE);

    referenceExpressionEClass = createEClass(REFERENCE_EXPRESSION);
    createEReference(referenceExpressionEClass, REFERENCE_EXPRESSION__REFERENCE);
    createEReference(referenceExpressionEClass, REFERENCE_EXPRESSION__PROPERTY);
    createEAttribute(referenceExpressionEClass, REFERENCE_EXPRESSION__DEQUEUE);
    createEAttribute(referenceExpressionEClass, REFERENCE_EXPRESSION__COUNT);
    createEAttribute(referenceExpressionEClass, REFERENCE_EXPRESSION__FRESH);

    hashPropertyReferenceEClass = createEClass(HASH_PROPERTY_REFERENCE);
    createEAttribute(hashPropertyReferenceEClass, HASH_PROPERTY_REFERENCE__PROPERTY);
    createEReference(hashPropertyReferenceEClass, HASH_PROPERTY_REFERENCE__INDEXES);
    createEReference(hashPropertyReferenceEClass, HASH_PROPERTY_REFERENCE__FIELDS);

    propertyReferenceTailEClass = createEClass(PROPERTY_REFERENCE_TAIL);
    createEAttribute(propertyReferenceTailEClass, PROPERTY_REFERENCE_TAIL__PROPERTY);
    createEReference(propertyReferenceTailEClass, PROPERTY_REFERENCE_TAIL__INDEXES);
    createEReference(propertyReferenceTailEClass, PROPERTY_REFERENCE_TAIL__FIELDS);

    namedPropertyFieldEClass = createEClass(NAMED_PROPERTY_FIELD);
    createEAttribute(namedPropertyFieldEClass, NAMED_PROPERTY_FIELD__NAME);
    createEReference(namedPropertyFieldEClass, NAMED_PROPERTY_FIELD__INDEXES);

    propertyArrayIndexEClass = createEClass(PROPERTY_ARRAY_INDEX);
    createEReference(propertyArrayIndexEClass, PROPERTY_ARRAY_INDEX__VALUE);

    propertyIndexValueEClass = createEClass(PROPERTY_INDEX_VALUE);

    propertyIndexPropertyReferenceEClass = createEClass(PROPERTY_INDEX_PROPERTY_REFERENCE);
    createEAttribute(propertyIndexPropertyReferenceEClass, PROPERTY_INDEX_PROPERTY_REFERENCE__PROPERTY);

    unindexedReferenceExpressionEClass = createEClass(UNINDEXED_REFERENCE_EXPRESSION);
    createEReference(unindexedReferenceExpressionEClass, UNINDEXED_REFERENCE_EXPRESSION__REFERENCE);
    createEAttribute(unindexedReferenceExpressionEClass, UNINDEXED_REFERENCE_EXPRESSION__DEQUEUE);
    createEAttribute(unindexedReferenceExpressionEClass, UNINDEXED_REFERENCE_EXPRESSION__COUNT);
    createEAttribute(unindexedReferenceExpressionEClass, UNINDEXED_REFERENCE_EXPRESSION__FRESH);

    unindexedReferenceEClass = createEClass(UNINDEXED_REFERENCE);
    createEReference(unindexedReferenceEClass, UNINDEXED_REFERENCE__SEGMENTS);
    createEReference(unindexedReferenceEClass, UNINDEXED_REFERENCE__TAILS);

    unindexedReferenceTailEClass = createEClass(UNINDEXED_REFERENCE_TAIL);
    createEAttribute(unindexedReferenceTailEClass, UNINDEXED_REFERENCE_TAIL__SEPARATOR);
    createEReference(unindexedReferenceTailEClass, UNINDEXED_REFERENCE_TAIL__SEGMENT);

    unindexedReferenceSegmentEClass = createEClass(UNINDEXED_REFERENCE_SEGMENT);
    createEAttribute(unindexedReferenceSegmentEClass, UNINDEXED_REFERENCE_SEGMENT__NAME);

    referenceEClass = createEClass(REFERENCE);
    createEReference(referenceEClass, REFERENCE__SEGMENTS);
    createEReference(referenceEClass, REFERENCE__TAILS);

    referenceTailEClass = createEClass(REFERENCE_TAIL);
    createEAttribute(referenceTailEClass, REFERENCE_TAIL__SEPARATOR);
    createEReference(referenceTailEClass, REFERENCE_TAIL__SEGMENT);

    referenceSegmentEClass = createEClass(REFERENCE_SEGMENT);
    createEAttribute(referenceSegmentEClass, REFERENCE_SEGMENT__NAME);
    createEReference(referenceSegmentEClass, REFERENCE_SEGMENT__INDEXES);

    arrayIndexEClass = createEClass(ARRAY_INDEX);
    createEReference(arrayIndexEClass, ARRAY_INDEX__VALUE);

    behaviorActionSequenceEClass = createEClass(BEHAVIOR_ACTION_SEQUENCE);
    createEReference(behaviorActionSequenceEClass, BEHAVIOR_ACTION_SEQUENCE__ACTIONS);

    behaviorActionSetEClass = createEClass(BEHAVIOR_ACTION_SET);
    createEReference(behaviorActionSetEClass, BEHAVIOR_ACTION_SET__ACTIONS);

    binaryExpressionEClass = createEClass(BINARY_EXPRESSION);
    createEReference(binaryExpressionEClass, BINARY_EXPRESSION__LEFT);
    createEAttribute(binaryExpressionEClass, BINARY_EXPRESSION__OPERATOR);
    createEReference(binaryExpressionEClass, BINARY_EXPRESSION__RIGHT);

    unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
    createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__OPERATOR);
    createEReference(unaryExpressionEClass, UNARY_EXPRESSION__OPERAND);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    behaviorAnnexEClass.getESuperTypes().add(theAadl2Package.getAnnexSubclause());
    behaviorActionBlockEClass.getESuperTypes().add(this.getBehaviorAction());
    behaviorActionEClass.getESuperTypes().add(this.getBehaviorActions());
    assignmentActionEClass.getESuperTypes().add(this.getBehaviorAction());
    communicationActionEClass.getESuperTypes().add(this.getBehaviorAction());
    timedActionEClass.getESuperTypes().add(this.getBehaviorAction());
    ifStatementEClass.getESuperTypes().add(this.getBehaviorAction());
    forStatementEClass.getESuperTypes().add(this.getBehaviorAction());
    whileStatementEClass.getESuperTypes().add(this.getBehaviorAction());
    doUntilStatementEClass.getESuperTypes().add(this.getBehaviorAction());
    valueConstantEClass.getESuperTypes().add(this.getValueExpression());
    behaviorIntegerLiteralEClass.getESuperTypes().add(this.getIntegerValue());
    behaviorIntegerLiteralEClass.getESuperTypes().add(this.getValueConstant());
    behaviorIntegerLiteralEClass.getESuperTypes().add(this.getPropertyIndexValue());
    behaviorRealLiteralEClass.getESuperTypes().add(this.getValueConstant());
    behaviorStringLiteralEClass.getESuperTypes().add(this.getValueConstant());
    behaviorBooleanLiteralEClass.getESuperTypes().add(this.getValueConstant());
    referenceExpressionEClass.getESuperTypes().add(this.getIntegerValue());
    referenceExpressionEClass.getESuperTypes().add(this.getValueExpression());
    hashPropertyReferenceEClass.getESuperTypes().add(this.getIntegerValue());
    hashPropertyReferenceEClass.getESuperTypes().add(this.getValueConstant());
    propertyIndexPropertyReferenceEClass.getESuperTypes().add(this.getPropertyIndexValue());
    unindexedReferenceExpressionEClass.getESuperTypes().add(this.getPropertyIndexValue());
    behaviorActionSequenceEClass.getESuperTypes().add(this.getBehaviorActions());
    behaviorActionSetEClass.getESuperTypes().add(this.getBehaviorActions());
    binaryExpressionEClass.getESuperTypes().add(this.getValueExpression());
    unaryExpressionEClass.getESuperTypes().add(this.getValueExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(behaviorAnnexEClass, BehaviorAnnex.class, "BehaviorAnnex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorAnnex_VariableGroups(), this.getBehaviorVariableGroup(), null, "variableGroups", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorAnnex_StateGroups(), this.getBehaviorStateGroup(), null, "stateGroups", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorAnnex_Transitions(), this.getBehaviorTransition(), null, "transitions", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorVariableGroupEClass, BehaviorVariableGroup.class, "BehaviorVariableGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorVariableGroup_Variables(), this.getBehaviorVariable(), null, "variables", null, 0, -1, BehaviorVariableGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorVariableGroup_DataClassifier(), theAadl2Package.getComponentClassifier(), null, "dataClassifier", null, 0, 1, BehaviorVariableGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorVariableGroup_InitialValue(), this.getValueConstant(), null, "initialValue", null, 0, 1, BehaviorVariableGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorVariableGroup_PropertyAssociations(), this.getBehaviorPropertyAssociation(), null, "propertyAssociations", null, 0, -1, BehaviorVariableGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorVariableEClass, BehaviorVariable.class, "BehaviorVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBehaviorVariable_Name(), theEcorePackage.getEString(), "name", null, 0, 1, BehaviorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorVariable_ArrayDimensions(), this.getArrayDimension(), null, "arrayDimensions", null, 0, -1, BehaviorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrayDimensionEClass, ArrayDimension.class, "ArrayDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArrayDimension_Size(), this.getIntegerValue(), null, "size", null, 0, 1, ArrayDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorPropertyAssociationEClass, BehaviorPropertyAssociation.class, "BehaviorPropertyAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorPropertyAssociation_Property(), theAadl2Package.getProperty(), null, "property", null, 0, 1, BehaviorPropertyAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorPropertyAssociation_OwnedValue(), theAadl2Package.getPropertyExpression(), null, "ownedValue", null, 0, 1, BehaviorPropertyAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorStateGroupEClass, BehaviorStateGroup.class, "BehaviorStateGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorStateGroup_States(), this.getBehaviorState(), null, "states", null, 0, -1, BehaviorStateGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBehaviorStateGroup_Initial(), theEcorePackage.getEBoolean(), "initial", null, 0, 1, BehaviorStateGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBehaviorStateGroup_Complete(), theEcorePackage.getEBoolean(), "complete", null, 0, 1, BehaviorStateGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBehaviorStateGroup_Final(), theEcorePackage.getEBoolean(), "final", null, 0, 1, BehaviorStateGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorStateEClass, BehaviorState.class, "BehaviorState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBehaviorState_Name(), theEcorePackage.getEString(), "name", null, 0, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorTransitionEClass, BehaviorTransition.class, "BehaviorTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBehaviorTransition_Name(), theEcorePackage.getEString(), "name", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBehaviorTransition_Priority(), theEcorePackage.getEString(), "priority", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorTransition_SourceStates(), this.getBehaviorState(), null, "sourceStates", null, 0, -1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorTransition_Condition(), this.getBehaviorCondition(), null, "condition", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorTransition_DestinationState(), this.getBehaviorState(), null, "destinationState", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorTransition_ActionBlock(), this.getBehaviorActionBlock(), null, "actionBlock", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorConditionEClass, BehaviorCondition.class, "BehaviorCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorCondition_Dispatch(), this.getDispatchCondition(), null, "dispatch", null, 0, 1, BehaviorCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorCondition_ModeSwitch(), this.getModeSwitchCondition(), null, "modeSwitch", null, 0, 1, BehaviorCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorCondition_Execute(), this.getExecuteCondition(), null, "execute", null, 0, 1, BehaviorCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(executeConditionEClass, ExecuteCondition.class, "ExecuteCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExecuteCondition_Value(), this.getValueExpression(), null, "value", null, 0, 1, ExecuteCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExecuteCondition_Timeout(), theEcorePackage.getEBoolean(), "timeout", null, 0, 1, ExecuteCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExecuteCondition_Otherwise(), theEcorePackage.getEBoolean(), "otherwise", null, 0, 1, ExecuteCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dispatchConditionEClass, DispatchCondition.class, "DispatchCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDispatchCondition_Trigger(), this.getDispatchTriggerCondition(), null, "trigger", null, 0, 1, DispatchCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDispatchCondition_FrozenPorts(), this.getReference(), null, "frozenPorts", null, 0, -1, DispatchCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dispatchTriggerConditionEClass, DispatchTriggerCondition.class, "DispatchTriggerCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDispatchTriggerCondition_Expression(), this.getDispatchTriggerLogicalExpression(), null, "expression", null, 0, 1, DispatchTriggerCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDispatchTriggerCondition_Timeout(), theEcorePackage.getEBoolean(), "timeout", null, 0, 1, DispatchTriggerCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDispatchTriggerCondition_Time(), this.getBehaviorTime(), null, "time", null, 0, 1, DispatchTriggerCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDispatchTriggerCondition_Stop(), theEcorePackage.getEBoolean(), "stop", null, 0, 1, DispatchTriggerCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dispatchTriggerLogicalExpressionEClass, DispatchTriggerLogicalExpression.class, "DispatchTriggerLogicalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDispatchTriggerLogicalExpression_Conjunctions(), this.getDispatchConjunction(), null, "conjunctions", null, 0, -1, DispatchTriggerLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dispatchConjunctionEClass, DispatchConjunction.class, "DispatchConjunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDispatchConjunction_Triggers(), this.getReference(), null, "triggers", null, 0, -1, DispatchConjunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modeSwitchConditionEClass, ModeSwitchCondition.class, "ModeSwitchCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModeSwitchCondition_Conjunctions(), this.getModeSwitchConjunction(), null, "conjunctions", null, 0, -1, ModeSwitchCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modeSwitchConjunctionEClass, ModeSwitchConjunction.class, "ModeSwitchConjunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModeSwitchConjunction_Triggers(), this.getReference(), null, "triggers", null, 0, -1, ModeSwitchConjunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorActionBlockEClass, BehaviorActionBlock.class, "BehaviorActionBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorActionBlock_Content(), this.getBehaviorActions(), null, "content", null, 0, 1, BehaviorActionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorActionBlock_Timeout(), this.getBehaviorTime(), null, "timeout", null, 0, 1, BehaviorActionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorActionsEClass, BehaviorActions.class, "BehaviorActions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(behaviorActionEClass, BehaviorAction.class, "BehaviorAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(assignmentActionEClass, AssignmentAction.class, "AssignmentAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssignmentAction_Target(), this.getReference(), null, "target", null, 0, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignmentAction_Value(), this.getValueExpression(), null, "value", null, 0, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssignmentAction_Any(), theEcorePackage.getEBoolean(), "any", null, 0, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(communicationActionEClass, CommunicationAction.class, "CommunicationAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCommunicationAction_Reference(), this.getReference(), null, "reference", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCommunicationAction_Send(), theEcorePackage.getEBoolean(), "send", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCommunicationAction_Parameters(), this.getValueExpression(), null, "parameters", null, 0, -1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCommunicationAction_Dequeue(), theEcorePackage.getEBoolean(), "dequeue", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCommunicationAction_Target(), this.getReference(), null, "target", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCommunicationAction_Freeze(), theEcorePackage.getEBoolean(), "freeze", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCommunicationAction_Lock(), theEcorePackage.getEBoolean(), "lock", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCommunicationAction_Unlock(), theEcorePackage.getEBoolean(), "unlock", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCommunicationAction_All(), theEcorePackage.getEBoolean(), "all", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCommunicationAction_AllLock(), theEcorePackage.getEBoolean(), "allLock", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCommunicationAction_AllUnlock(), theEcorePackage.getEBoolean(), "allUnlock", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timedActionEClass, TimedAction.class, "TimedAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTimedAction_LowerTime(), this.getBehaviorTime(), null, "lowerTime", null, 0, 1, TimedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTimedAction_UpperTime(), this.getBehaviorTime(), null, "upperTime", null, 0, 1, TimedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTimedAction_Processors(), theAadl2Package.getComponentClassifier(), null, "processors", null, 0, -1, TimedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfStatement_Condition(), this.getValueExpression(), null, "condition", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfStatement_ThenActions(), this.getBehaviorActions(), null, "thenActions", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfStatement_ElseIfs(), this.getElseIfClause(), null, "elseIfs", null, 0, -1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfStatement_ElseActions(), this.getBehaviorActions(), null, "elseActions", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elseIfClauseEClass, ElseIfClause.class, "ElseIfClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getElseIfClause_Condition(), this.getValueExpression(), null, "condition", null, 0, 1, ElseIfClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getElseIfClause_Actions(), this.getBehaviorActions(), null, "actions", null, 0, 1, ElseIfClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(forStatementEClass, ForStatement.class, "ForStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getForStatement_For(), theEcorePackage.getEBoolean(), "for", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getForStatement_Forall(), theEcorePackage.getEBoolean(), "forall", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getForStatement_Variable(), theEcorePackage.getEString(), "variable", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForStatement_DataClassifier(), theAadl2Package.getComponentClassifier(), null, "dataClassifier", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForStatement_Values(), this.getElementValues(), null, "values", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForStatement_Actions(), this.getBehaviorActions(), null, "actions", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(whileStatementEClass, WhileStatement.class, "WhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWhileStatement_Condition(), this.getValueExpression(), null, "condition", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWhileStatement_Actions(), this.getBehaviorActions(), null, "actions", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(doUntilStatementEClass, DoUntilStatement.class, "DoUntilStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDoUntilStatement_Actions(), this.getBehaviorActions(), null, "actions", null, 0, 1, DoUntilStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDoUntilStatement_Condition(), this.getValueExpression(), null, "condition", null, 0, 1, DoUntilStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elementValuesEClass, ElementValues.class, "ElementValues", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getElementValues_Lower(), this.getIntegerValue(), null, "lower", null, 0, 1, ElementValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getElementValues_Upper(), this.getIntegerValue(), null, "upper", null, 0, 1, ElementValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorTimeEClass, BehaviorTime.class, "BehaviorTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorTime_Value(), this.getIntegerValue(), null, "value", null, 0, 1, BehaviorTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorTime_Unit(), theAadl2Package.getUnitLiteral(), null, "unit", null, 0, 1, BehaviorTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(integerValueEClass, IntegerValue.class, "IntegerValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(valueExpressionEClass, ValueExpression.class, "ValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(valueConstantEClass, ValueConstant.class, "ValueConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(behaviorIntegerLiteralEClass, BehaviorIntegerLiteral.class, "BehaviorIntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBehaviorIntegerLiteral_Value(), theEcorePackage.getEString(), "value", null, 0, 1, BehaviorIntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorRealLiteralEClass, BehaviorRealLiteral.class, "BehaviorRealLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBehaviorRealLiteral_Value(), theEcorePackage.getEString(), "value", null, 0, 1, BehaviorRealLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorStringLiteralEClass, BehaviorStringLiteral.class, "BehaviorStringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBehaviorStringLiteral_Value(), theEcorePackage.getEString(), "value", null, 0, 1, BehaviorStringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorBooleanLiteralEClass, BehaviorBooleanLiteral.class, "BehaviorBooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBehaviorBooleanLiteral_Value(), theEcorePackage.getEBoolean(), "value", null, 0, 1, BehaviorBooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referenceExpressionEClass, ReferenceExpression.class, "ReferenceExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReferenceExpression_Reference(), this.getReference(), null, "reference", null, 0, 1, ReferenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReferenceExpression_Property(), this.getPropertyReferenceTail(), null, "property", null, 0, 1, ReferenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReferenceExpression_Dequeue(), theEcorePackage.getEBoolean(), "dequeue", null, 0, 1, ReferenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReferenceExpression_Count(), theEcorePackage.getEBoolean(), "count", null, 0, 1, ReferenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReferenceExpression_Fresh(), theEcorePackage.getEBoolean(), "fresh", null, 0, 1, ReferenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hashPropertyReferenceEClass, HashPropertyReference.class, "HashPropertyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getHashPropertyReference_Property(), theEcorePackage.getEString(), "property", null, 0, 1, HashPropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHashPropertyReference_Indexes(), this.getPropertyArrayIndex(), null, "indexes", null, 0, -1, HashPropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHashPropertyReference_Fields(), this.getNamedPropertyField(), null, "fields", null, 0, -1, HashPropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyReferenceTailEClass, PropertyReferenceTail.class, "PropertyReferenceTail", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPropertyReferenceTail_Property(), theEcorePackage.getEString(), "property", null, 0, 1, PropertyReferenceTail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropertyReferenceTail_Indexes(), this.getPropertyArrayIndex(), null, "indexes", null, 0, -1, PropertyReferenceTail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropertyReferenceTail_Fields(), this.getNamedPropertyField(), null, "fields", null, 0, -1, PropertyReferenceTail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedPropertyFieldEClass, NamedPropertyField.class, "NamedPropertyField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedPropertyField_Name(), theEcorePackage.getEString(), "name", null, 0, 1, NamedPropertyField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNamedPropertyField_Indexes(), this.getPropertyArrayIndex(), null, "indexes", null, 0, -1, NamedPropertyField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyArrayIndexEClass, PropertyArrayIndex.class, "PropertyArrayIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropertyArrayIndex_Value(), this.getPropertyIndexValue(), null, "value", null, 0, 1, PropertyArrayIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyIndexValueEClass, PropertyIndexValue.class, "PropertyIndexValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(propertyIndexPropertyReferenceEClass, PropertyIndexPropertyReference.class, "PropertyIndexPropertyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPropertyIndexPropertyReference_Property(), theEcorePackage.getEString(), "property", null, 0, 1, PropertyIndexPropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unindexedReferenceExpressionEClass, UnindexedReferenceExpression.class, "UnindexedReferenceExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnindexedReferenceExpression_Reference(), this.getUnindexedReference(), null, "reference", null, 0, 1, UnindexedReferenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnindexedReferenceExpression_Dequeue(), theEcorePackage.getEBoolean(), "dequeue", null, 0, 1, UnindexedReferenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnindexedReferenceExpression_Count(), theEcorePackage.getEBoolean(), "count", null, 0, 1, UnindexedReferenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnindexedReferenceExpression_Fresh(), theEcorePackage.getEBoolean(), "fresh", null, 0, 1, UnindexedReferenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unindexedReferenceEClass, UnindexedReference.class, "UnindexedReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnindexedReference_Segments(), this.getUnindexedReferenceSegment(), null, "segments", null, 0, -1, UnindexedReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnindexedReference_Tails(), this.getUnindexedReferenceTail(), null, "tails", null, 0, -1, UnindexedReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unindexedReferenceTailEClass, UnindexedReferenceTail.class, "UnindexedReferenceTail", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnindexedReferenceTail_Separator(), theEcorePackage.getEString(), "separator", null, 0, 1, UnindexedReferenceTail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnindexedReferenceTail_Segment(), this.getUnindexedReferenceSegment(), null, "segment", null, 0, 1, UnindexedReferenceTail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unindexedReferenceSegmentEClass, UnindexedReferenceSegment.class, "UnindexedReferenceSegment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnindexedReferenceSegment_Name(), theEcorePackage.getEString(), "name", null, 0, 1, UnindexedReferenceSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReference_Segments(), this.getReferenceSegment(), null, "segments", null, 0, -1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReference_Tails(), this.getReferenceTail(), null, "tails", null, 0, -1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referenceTailEClass, ReferenceTail.class, "ReferenceTail", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReferenceTail_Separator(), theEcorePackage.getEString(), "separator", null, 0, 1, ReferenceTail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReferenceTail_Segment(), this.getReferenceSegment(), null, "segment", null, 0, 1, ReferenceTail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referenceSegmentEClass, ReferenceSegment.class, "ReferenceSegment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReferenceSegment_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ReferenceSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReferenceSegment_Indexes(), this.getArrayIndex(), null, "indexes", null, 0, -1, ReferenceSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrayIndexEClass, ArrayIndex.class, "ArrayIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArrayIndex_Value(), this.getIntegerValue(), null, "value", null, 0, 1, ArrayIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorActionSequenceEClass, BehaviorActionSequence.class, "BehaviorActionSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorActionSequence_Actions(), this.getBehaviorAction(), null, "actions", null, 0, -1, BehaviorActionSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorActionSetEClass, BehaviorActionSet.class, "BehaviorActionSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorActionSet_Actions(), this.getBehaviorAction(), null, "actions", null, 0, -1, BehaviorActionSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(binaryExpressionEClass, BinaryExpression.class, "BinaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinaryExpression_Left(), this.getValueExpression(), null, "left", null, 0, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBinaryExpression_Operator(), theEcorePackage.getEString(), "operator", null, 0, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinaryExpression_Right(), this.getValueExpression(), null, "right", null, 0, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnaryExpression_Operator(), theEcorePackage.getEString(), "operator", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnaryExpression_Operand(), this.getValueExpression(), null, "operand", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //BehaviorAnnexPackageImpl
