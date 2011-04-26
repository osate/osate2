/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subcomponent State Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference#getSubcomponent <em>Subcomponent</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference#getErrortype <em>Errortype</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getSubcomponentStateReference()
 * @model
 * @generated
 */
public interface SubcomponentStateReference extends StateConditionExpression
{
  /**
   * Returns the value of the '<em><b>Subcomponent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subcomponent</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subcomponent</em>' reference.
   * @see #setSubcomponent(Feature)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getSubcomponentStateReference_Subcomponent()
   * @model
   * @generated
   */
  Feature getSubcomponent();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference#getSubcomponent <em>Subcomponent</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subcomponent</em>' reference.
   * @see #getSubcomponent()
   * @generated
   */
  void setSubcomponent(Feature value);

  /**
   * Returns the value of the '<em><b>Errortype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Errortype</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Errortype</em>' reference.
   * @see #setErrortype(ErrorBehaviorState)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getSubcomponentStateReference_Errortype()
   * @model
   * @generated
   */
  ErrorBehaviorState getErrortype();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference#getErrortype <em>Errortype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Errortype</em>' reference.
   * @see #getErrortype()
   * @generated
   */
  void setErrortype(ErrorBehaviorState value);

} // SubcomponentStateReference
