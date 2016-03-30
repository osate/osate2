/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.TriggerPort;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Detection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection#getState <em>State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection#getTypeTokenConstraint <em>Type Token Constraint</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection#isAllStates <em>All States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection#getDetectionReportingPort <em>Detection Reporting Port</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection#getErrorCode <em>Error Code</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorDetection()
 * @model
 * @generated
 */
public interface ErrorDetection extends EObject, NamedElement {
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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorDetection_State()
	 * @model
	 * @generated
	 */
	ErrorBehaviorState getState();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection#getState <em>State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(ErrorBehaviorState value);

	/**
	 * Returns the value of the '<em><b>Type Token Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Token Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Token Constraint</em>' containment reference.
	 * @see #setTypeTokenConstraint(TypeSet)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorDetection_TypeTokenConstraint()
	 * @model containment="true"
	 * @generated
	 */
	TypeSet getTypeTokenConstraint();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection#getTypeTokenConstraint <em>Type Token Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Token Constraint</em>' containment reference.
	 * @see #getTypeTokenConstraint()
	 * @generated
	 */
	void setTypeTokenConstraint(TypeSet value);

	/**
	 * Returns the value of the '<em><b>All States</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All States</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All States</em>' attribute.
	 * @see #setAllStates(boolean)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorDetection_AllStates()
	 * @model
	 * @generated
	 */
	boolean isAllStates();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection#isAllStates <em>All States</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All States</em>' attribute.
	 * @see #isAllStates()
	 * @generated
	 */
	void setAllStates(boolean value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ConditionExpression)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorDetection_Condition()
	 * @model containment="true"
	 * @generated
	 */
	ConditionExpression getCondition();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ConditionExpression value);

	/**
	 * Returns the value of the '<em><b>Detection Reporting Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detection Reporting Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detection Reporting Port</em>' reference.
	 * @see #setDetectionReportingPort(TriggerPort)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorDetection_DetectionReportingPort()
	 * @model
	 * @generated
	 */
	TriggerPort getDetectionReportingPort();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection#getDetectionReportingPort <em>Detection Reporting Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Detection Reporting Port</em>' reference.
	 * @see #getDetectionReportingPort()
	 * @generated
	 */
	void setDetectionReportingPort(TriggerPort value);

	/**
	 * Returns the value of the '<em><b>Error Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Code</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Code</em>' containment reference.
	 * @see #setErrorCode(ErrorCodeValue)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorDetection_ErrorCode()
	 * @model containment="true"
	 * @generated
	 */
	ErrorCodeValue getErrorCode();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection#getErrorCode <em>Error Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Code</em>' containment reference.
	 * @see #getErrorCode()
	 * @generated
	 */
	void setErrorCode(ErrorCodeValue value);

} // ErrorDetection
