/**
 */
package org.osate.alisa2.model.safe2;

import org.osate.aadl2.instance.FeatureInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa2.model.safe2.Constraint#getHazard <em>Hazard</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.Constraint#getPort <em>Port</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa2.model.safe2.Safe2Package#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends Fundamental {
	/**
	 * Returns the value of the '<em><b>Hazard</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.osate.alisa2.model.safe2.Hazard#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hazard</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hazard</em>' container reference.
	 * @see #setHazard(Hazard)
	 * @see org.osate.alisa2.model.safe2.Safe2Package#getConstraint_Hazard()
	 * @see org.osate.alisa2.model.safe2.Hazard#getConstraint
	 * @model opposite="constraint" required="true" transient="false"
	 * @generated
	 */
	Hazard getHazard();

	/**
	 * Sets the value of the '{@link org.osate.alisa2.model.safe2.Constraint#getHazard <em>Hazard</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hazard</em>' container reference.
	 * @see #getHazard()
	 * @generated
	 */
	void setHazard(Hazard value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' reference.
	 * @see #setPort(FeatureInstance)
	 * @see org.osate.alisa2.model.safe2.Safe2Package#getConstraint_Port()
	 * @model
	 * @generated
	 */
	FeatureInstance getPort();

	/**
	 * Sets the value of the '{@link org.osate.alisa2.model.safe2.Constraint#getPort <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' reference.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(FeatureInstance value);

} // Constraint
