/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Error Behavior State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState#getSubcomponent <em>Subcomponent</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState#getNext <em>Next</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState#getState <em>State</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedErrorBehaviorState()
 * @model
 * @generated
 */
public interface QualifiedErrorBehaviorState extends EObject, Element {
	/**
	 * Returns the value of the '<em><b>Subcomponent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subcomponent</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subcomponent</em>' containment reference.
	 * @see #setSubcomponent(SubcomponentElement)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedErrorBehaviorState_Subcomponent()
	 * @model containment="true"
	 * @generated
	 */
	SubcomponentElement getSubcomponent();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState#getSubcomponent <em>Subcomponent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subcomponent</em>' containment reference.
	 * @see #getSubcomponent()
	 * @generated
	 */
	void setSubcomponent(SubcomponentElement value);

	/**
	 * Returns the value of the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next</em>' containment reference.
	 * @see #setNext(QualifiedErrorBehaviorState)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedErrorBehaviorState_Next()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedErrorBehaviorState getNext();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState#getNext <em>Next</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next</em>' containment reference.
	 * @see #getNext()
	 * @generated
	 */
	void setNext(QualifiedErrorBehaviorState value);

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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedErrorBehaviorState_State()
	 * @model
	 * @generated
	 */
	ErrorBehaviorState getState();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState#getState <em>State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(ErrorBehaviorState value);

} // QualifiedErrorBehaviorState
