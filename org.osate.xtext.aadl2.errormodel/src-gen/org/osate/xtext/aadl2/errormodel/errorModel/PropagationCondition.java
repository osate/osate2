/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Propagation Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getOutPropagation <em>Out Propagation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#isMask <em>Mask</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#isWorking <em>Working</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getState <em>State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getPropagationCondition()
 * @model
 * @generated
 */
public interface PropagationCondition extends EObject
{
  /**
   * Returns the value of the '<em><b>Out Propagation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Out Propagation</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Out Propagation</em>' reference.
   * @see #setOutPropagation(ErrorPropagation)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getPropagationCondition_OutPropagation()
   * @model
   * @generated
   */
  ErrorPropagation getOutPropagation();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getOutPropagation <em>Out Propagation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Out Propagation</em>' reference.
   * @see #getOutPropagation()
   * @generated
   */
  void setOutPropagation(ErrorPropagation value);

  /**
   * Returns the value of the '<em><b>Mask</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mask</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mask</em>' attribute.
   * @see #setMask(boolean)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getPropagationCondition_Mask()
   * @model
   * @generated
   */
  boolean isMask();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#isMask <em>Mask</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mask</em>' attribute.
   * @see #isMask()
   * @generated
   */
  void setMask(boolean value);

  /**
   * Returns the value of the '<em><b>Working</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Working</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Working</em>' attribute.
   * @see #setWorking(boolean)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getPropagationCondition_Working()
   * @model
   * @generated
   */
  boolean isWorking();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#isWorking <em>Working</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Working</em>' attribute.
   * @see #isWorking()
   * @generated
   */
  void setWorking(boolean value);

  /**
   * Returns the value of the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' reference.
   * @see #setState(ErrorBehaviorState)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getPropagationCondition_State()
   * @model
   * @generated
   */
  ErrorBehaviorState getState();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getState <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' reference.
   * @see #getState()
   * @generated
   */
  void setState(ErrorBehaviorState value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(TriggerConditionExpression)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getPropagationCondition_Condition()
   * @model containment="true"
   * @generated
   */
  TriggerConditionExpression getCondition();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(TriggerConditionExpression value);

  /**
   * Returns the value of the '<em><b>Feature</b></em>' reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.Feature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getPropagationCondition_Feature()
   * @model
   * @generated
   */
  EList<Feature> getFeature();

} // PropagationCondition
