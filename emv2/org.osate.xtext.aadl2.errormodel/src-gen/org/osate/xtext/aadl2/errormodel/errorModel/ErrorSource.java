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
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#isAllOutgoing <em>All Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeReference <em>Failure Mode Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeType <em>Failure Mode Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeDescription <em>Failure Mode Description</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource()
 * @model
 * @generated
 */
public interface ErrorSource extends ErrorFlow {
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
	 * @see #setFailureModeReference(ErrorBehaviorState)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource_FailureModeReference()
	 * @model
	 * @generated
	 */
	ErrorBehaviorState getFailureModeReference();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeReference <em>Failure Mode Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Mode Reference</em>' reference.
	 * @see #getFailureModeReference()
	 * @generated
	 */
	void setFailureModeReference(ErrorBehaviorState value);

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

	/**
	 * Returns the value of the '<em><b>Failure Mode Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Mode Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Mode Description</em>' attribute.
	 * @see #setFailureModeDescription(String)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource_FailureModeDescription()
	 * @model
	 * @generated
	 */
	String getFailureModeDescription();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getFailureModeDescription <em>Failure Mode Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Mode Description</em>' attribute.
	 * @see #getFailureModeDescription()
	 * @generated
	 */
	void setFailureModeDescription(String value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorSource_Condition()
	 * @model
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

} // ErrorSource
