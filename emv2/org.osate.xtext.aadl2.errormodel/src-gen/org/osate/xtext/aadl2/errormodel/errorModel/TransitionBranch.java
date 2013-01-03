/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch#getTargetToken <em>Target Token</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch#isMask <em>Mask</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTransitionBranch()
 * @model
 * @generated
 */
public interface TransitionBranch extends EObject, Element
{
  /**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ErrorBehaviorState)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTransitionBranch_Target()
	 * @model
	 * @generated
	 */
  ErrorBehaviorState getTarget();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
  void setTarget(ErrorBehaviorState value);

  /**
	 * Returns the value of the '<em><b>Target Token</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Token</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Token</em>' containment reference.
	 * @see #setTargetToken(TypeToken)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTransitionBranch_TargetToken()
	 * @model containment="true"
	 * @generated
	 */
  TypeToken getTargetToken();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch#getTargetToken <em>Target Token</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Token</em>' containment reference.
	 * @see #getTargetToken()
	 * @generated
	 */
  void setTargetToken(TypeToken value);

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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTransitionBranch_Mask()
	 * @model
	 * @generated
	 */
  boolean isMask();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch#isMask <em>Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mask</em>' attribute.
	 * @see #isMask()
	 * @generated
	 */
  void setMask(boolean value);

  /**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTransitionBranch_Value()
	 * @model
	 * @generated
	 */
  String getValue();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
  void setValue(String value);

} // TransitionBranch
