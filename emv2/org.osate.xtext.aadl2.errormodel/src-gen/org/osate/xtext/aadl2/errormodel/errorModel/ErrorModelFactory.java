/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
 * @generated
 */
public interface ErrorModelFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ErrorModelFactory eINSTANCE = org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Subclause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subclause</em>'.
   * @generated
   */
  ErrorModelSubclause createErrorModelSubclause();

  /**
   * Returns a new object of class '<em>Library</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Library</em>'.
   * @generated
   */
  ErrorModelLibrary createErrorModelLibrary();

  /**
   * Returns a new object of class '<em>EMV2 Property Association</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EMV2 Property Association</em>'.
   * @generated
   */
  EMV2PropertyAssociation createEMV2PropertyAssociation();

  /**
   * Returns a new object of class '<em>EMV2 Path</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EMV2 Path</em>'.
   * @generated
   */
  EMV2Path createEMV2Path();

  /**
   * Returns a new object of class '<em>EMV2 Path Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EMV2 Path Element</em>'.
   * @generated
   */
  EMV2PathElement createEMV2PathElement();

  /**
   * Returns a new object of class '<em>Error Types</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Types</em>'.
   * @generated
   */
  ErrorTypes createErrorTypes();

  /**
   * Returns a new object of class '<em>Error Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Type</em>'.
   * @generated
   */
  ErrorType createErrorType();

  /**
   * Returns a new object of class '<em>Type Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Set</em>'.
   * @generated
   */
  TypeSet createTypeSet();

  /**
   * Returns a new object of class '<em>Type Token</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Token</em>'.
   * @generated
   */
  TypeToken createTypeToken();

  /**
   * Returns a new object of class '<em>Type Transformation Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Transformation Set</em>'.
   * @generated
   */
  TypeTransformationSet createTypeTransformationSet();

  /**
   * Returns a new object of class '<em>Type Transformation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Transformation</em>'.
   * @generated
   */
  TypeTransformation createTypeTransformation();

  /**
   * Returns a new object of class '<em>Type Mapping Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Mapping Set</em>'.
   * @generated
   */
  TypeMappingSet createTypeMappingSet();

  /**
   * Returns a new object of class '<em>Type Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Mapping</em>'.
   * @generated
   */
  TypeMapping createTypeMapping();

  /**
   * Returns a new object of class '<em>Error Propagation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Propagation</em>'.
   * @generated
   */
  ErrorPropagation createErrorPropagation();

  /**
   * Returns a new object of class '<em>Featureor PP Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Featureor PP Reference</em>'.
   * @generated
   */
  FeatureorPPReference createFeatureorPPReference();

  /**
   * Returns a new object of class '<em>Error Flow</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Flow</em>'.
   * @generated
   */
  ErrorFlow createErrorFlow();

  /**
   * Returns a new object of class '<em>Error Source</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Source</em>'.
   * @generated
   */
  ErrorSource createErrorSource();

  /**
   * Returns a new object of class '<em>Error Sink</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Sink</em>'.
   * @generated
   */
  ErrorSink createErrorSink();

  /**
   * Returns a new object of class '<em>Error Path</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Path</em>'.
   * @generated
   */
  ErrorPath createErrorPath();

  /**
   * Returns a new object of class '<em>If Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Condition</em>'.
   * @generated
   */
  IfCondition createIfCondition();

  /**
   * Returns a new object of class '<em>Propagation Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Propagation Point</em>'.
   * @generated
   */
  PropagationPoint createPropagationPoint();

  /**
   * Returns a new object of class '<em>Propagation Path</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Propagation Path</em>'.
   * @generated
   */
  PropagationPath createPropagationPath();

  /**
   * Returns a new object of class '<em>Qualified Propagation Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Propagation Point</em>'.
   * @generated
   */
  QualifiedPropagationPoint createQualifiedPropagationPoint();

  /**
   * Returns a new object of class '<em>Error Behavior State Machine</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Behavior State Machine</em>'.
   * @generated
   */
  ErrorBehaviorStateMachine createErrorBehaviorStateMachine();

  /**
   * Returns a new object of class '<em>Error Behavior Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Behavior Event</em>'.
   * @generated
   */
  ErrorBehaviorEvent createErrorBehaviorEvent();

  /**
   * Returns a new object of class '<em>Error Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Event</em>'.
   * @generated
   */
  ErrorEvent createErrorEvent();

  /**
   * Returns a new object of class '<em>Repair Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Repair Event</em>'.
   * @generated
   */
  RepairEvent createRepairEvent();

  /**
   * Returns a new object of class '<em>Recover Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Recover Event</em>'.
   * @generated
   */
  RecoverEvent createRecoverEvent();

  /**
   * Returns a new object of class '<em>Error Behavior State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Behavior State</em>'.
   * @generated
   */
  ErrorBehaviorState createErrorBehaviorState();

  /**
   * Returns a new object of class '<em>Error Behavior Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Behavior Transition</em>'.
   * @generated
   */
  ErrorBehaviorTransition createErrorBehaviorTransition();

  /**
   * Returns a new object of class '<em>Transition Branch</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Branch</em>'.
   * @generated
   */
  TransitionBranch createTransitionBranch();

  /**
   * Returns a new object of class '<em>Branch Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Branch Value</em>'.
   * @generated
   */
  BranchValue createBranchValue();

  /**
   * Returns a new object of class '<em>Condition Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Condition Expression</em>'.
   * @generated
   */
  ConditionExpression createConditionExpression();

  /**
   * Returns a new object of class '<em>Ormore Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ormore Expression</em>'.
   * @generated
   */
  OrmoreExpression createOrmoreExpression();

  /**
   * Returns a new object of class '<em>Orless Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Orless Expression</em>'.
   * @generated
   */
  OrlessExpression createOrlessExpression();

  /**
   * Returns a new object of class '<em>Condition Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Condition Element</em>'.
   * @generated
   */
  ConditionElement createConditionElement();

  /**
   * Returns a new object of class '<em>Event Or Propagation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event Or Propagation</em>'.
   * @generated
   */
  EventOrPropagation createEventOrPropagation();

  /**
   * Returns a new object of class '<em>Outgoing Propagation Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Outgoing Propagation Condition</em>'.
   * @generated
   */
  OutgoingPropagationCondition createOutgoingPropagationCondition();

  /**
   * Returns a new object of class '<em>Error Detection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Detection</em>'.
   * @generated
   */
  ErrorDetection createErrorDetection();

  /**
   * Returns a new object of class '<em>Error Code Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Code Value</em>'.
   * @generated
   */
  ErrorCodeValue createErrorCodeValue();

  /**
   * Returns a new object of class '<em>Error State To Mode Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error State To Mode Mapping</em>'.
   * @generated
   */
  ErrorStateToModeMapping createErrorStateToModeMapping();

  /**
   * Returns a new object of class '<em>Composite State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Composite State</em>'.
   * @generated
   */
  CompositeState createCompositeState();

  /**
   * Returns a new object of class '<em>Qualified Error Behavior State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Error Behavior State</em>'.
   * @generated
   */
  QualifiedErrorBehaviorState createQualifiedErrorBehaviorState();

  /**
   * Returns a new object of class '<em>Subcomponent Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subcomponent Element</em>'.
   * @generated
   */
  SubcomponentElement createSubcomponentElement();

  /**
   * Returns a new object of class '<em>EMV2 Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EMV2 Root</em>'.
   * @generated
   */
  EMV2Root createEMV2Root();

  /**
   * Returns a new object of class '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or Expression</em>'.
   * @generated
   */
  OrExpression createOrExpression();

  /**
   * Returns a new object of class '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Expression</em>'.
   * @generated
   */
  AndExpression createAndExpression();

  /**
   * Returns a new object of class '<em>All Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>All Expression</em>'.
   * @generated
   */
  AllExpression createAllExpression();

  /**
   * Returns a new object of class '<em>Qualified Error Event Or Propagation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Error Event Or Propagation</em>'.
   * @generated
   */
  QualifiedErrorEventOrPropagation createQualifiedErrorEventOrPropagation();

  /**
   * Returns a new object of class '<em>Qualified Error Propagation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Error Propagation</em>'.
   * @generated
   */
  QualifiedErrorPropagation createQualifiedErrorPropagation();

  /**
   * Returns a new object of class '<em>SCondition Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SCondition Element</em>'.
   * @generated
   */
  SConditionElement createSConditionElement();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ErrorModelPackage getErrorModelPackage();

} //ErrorModelFactory
