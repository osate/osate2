/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPath()
 * @model
 * @generated
 */
public interface ErrorPath extends ErrorFlow
{
  /**
   * Returns the value of the '<em><b>Incoming</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Incoming</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming</em>' containment reference.
   * @see #setIncoming(ErrorPropagationReference)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPath_Incoming()
   * @model containment="true"
   * @generated
   */
  ErrorPropagationReference getIncoming();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getIncoming <em>Incoming</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Incoming</em>' containment reference.
   * @see #getIncoming()
   * @generated
   */
  void setIncoming(ErrorPropagationReference value);

  /**
   * Returns the value of the '<em><b>Outgoing</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing</em>' containment reference.
   * @see #setOutgoing(ErrorPropagationReference)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPath_Outgoing()
   * @model containment="true"
   * @generated
   */
  ErrorPropagationReference getOutgoing();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getOutgoing <em>Outgoing</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Outgoing</em>' containment reference.
   * @see #getOutgoing()
   * @generated
   */
  void setOutgoing(ErrorPropagationReference value);

} // ErrorPath
