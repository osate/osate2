/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance;

import org.osate.aadl2.instance.InstanceObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constrained Instance Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getInstanceObject <em>Instance Object</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#isOutgoing <em>Outgoing</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getConstrainedInstanceObject()
 * @model
 * @generated
 */
public interface ConstrainedInstanceObject extends EMV2InstanceObject, Literal {
	/**
	 * Returns the value of the '<em><b>Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Object</em>' reference.
	 * @see #setInstanceObject(InstanceObject)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getConstrainedInstanceObject_InstanceObject()
	 * @model
	 * @generated
	 */
	InstanceObject getInstanceObject();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getInstanceObject <em>Instance Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Object</em>' reference.
	 * @see #getInstanceObject()
	 * @generated
	 */
	void setInstanceObject(InstanceObject value);

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' containment reference.
	 * @see #setConstraint(Literal)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getConstrainedInstanceObject_Constraint()
	 * @model containment="true"
	 * @generated
	 */
	Literal getConstraint();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getConstraint <em>Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' containment reference.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(Literal value);

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' attribute.
	 * @see #setOutgoing(boolean)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getConstrainedInstanceObject_Outgoing()
	 * @model
	 * @generated
	 */
	boolean isOutgoing();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#isOutgoing <em>Outgoing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing</em>' attribute.
	 * @see #isOutgoing()
	 * @generated
	 */
	void setOutgoing(boolean value);

} // ConstrainedInstanceObject
