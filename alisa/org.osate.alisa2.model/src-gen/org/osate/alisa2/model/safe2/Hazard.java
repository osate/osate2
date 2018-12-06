/**
 */
package org.osate.alisa2.model.safe2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hazard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa2.model.safe2.Hazard#getAccident <em>Accident</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.Hazard#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa2.model.safe2.Safe2Package#getHazard()
 * @model
 * @generated
 */
public interface Hazard extends Fundamental {
	/**
	 * Returns the value of the '<em><b>Accident</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.alisa2.model.safe2.Accident#getHazard <em>Hazard</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accident</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accident</em>' reference.
	 * @see #setAccident(Accident)
	 * @see org.osate.alisa2.model.safe2.Safe2Package#getHazard_Accident()
	 * @see org.osate.alisa2.model.safe2.Accident#getHazard
	 * @model opposite="hazard" required="true"
	 * @generated
	 */
	Accident getAccident();

	/**
	 * Sets the value of the '{@link org.osate.alisa2.model.safe2.Hazard#getAccident <em>Accident</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accident</em>' reference.
	 * @see #getAccident()
	 * @generated
	 */
	void setAccident(Accident value);

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' reference list.
	 * The list contents are of type {@link org.osate.alisa2.model.safe2.Constraint}.
	 * It is bidirectional and its opposite is '{@link org.osate.alisa2.model.safe2.Constraint#getHazard <em>Hazard</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' reference list.
	 * @see org.osate.alisa2.model.safe2.Safe2Package#getHazard_Constraint()
	 * @see org.osate.alisa2.model.safe2.Constraint#getHazard
	 * @model opposite="hazard" required="true"
	 * @generated
	 */
	EList<Constraint> getConstraint();

} // Hazard
