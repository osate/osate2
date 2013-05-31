/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#isAllOutgoing <em>All Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeReference <em>Failure Mode Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeType <em>Failure Mode Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource()
 * @model
 * @generated
 */
public interface ErrorSource extends ErrorFlow
{
  /**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference.
	 * @see #setOutgoing(ErrorPropagation)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource_Outgoing()
	 * @model
	 * @generated
	 */
  ErrorPropagation getOutgoing();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getOutgoing <em>Outgoing</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing</em>' reference.
	 * @see #getOutgoing()
	 * @generated
	 */
  void setOutgoing(ErrorPropagation value);

  /**
	 * Returns the value of the '<em><b>All Outgoing</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>All Outgoing</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>All Outgoing</em>' attribute.
	 * @see #setAllOutgoing(boolean)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource_AllOutgoing()
	 * @model
	 * @generated
	 */
  boolean isAllOutgoing();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#isAllOutgoing <em>All Outgoing</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All Outgoing</em>' attribute.
	 * @see #isAllOutgoing()
	 * @generated
	 */
  void setAllOutgoing(boolean value);

  /**
	 * Returns the value of the '<em><b>Failure Mode Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Failure Mode Reference</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Mode Reference</em>' reference.
	 * @see #setFailureModeReference(ErrorBehaviorStateOrTypeSet)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource_FailureModeReference()
	 * @model
	 * @generated
	 */
  ErrorBehaviorStateOrTypeSet getFailureModeReference();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeReference <em>Failure Mode Reference</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Mode Reference</em>' reference.
	 * @see #getFailureModeReference()
	 * @generated
	 */
  void setFailureModeReference(ErrorBehaviorStateOrTypeSet value);

  /**
	 * Returns the value of the '<em><b>Failure Mode Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Failure Mode Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Mode Type</em>' containment reference.
	 * @see #setFailureModeType(TypeSet)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource_FailureModeType()
	 * @model containment="true"
	 * @generated
	 */
  TypeSet getFailureModeType();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeType <em>Failure Mode Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Mode Type</em>' containment reference.
	 * @see #getFailureModeType()
	 * @generated
	 */
  void setFailureModeType(TypeSet value);

} // ErrorSource
