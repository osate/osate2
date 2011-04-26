/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Sink</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink#getIncoming <em>Incoming</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSink()
 * @model
 * @generated
 */
public interface ErrorSink extends ErrorFlow
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
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSink_Incoming()
   * @model containment="true"
   * @generated
   */
  ErrorPropagationReference getIncoming();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink#getIncoming <em>Incoming</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Incoming</em>' containment reference.
   * @see #getIncoming()
   * @generated
   */
  void setIncoming(ErrorPropagationReference value);

} // ErrorSink
