/**
 */
package org.osate.alisa2.model.safe2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accident</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa2.model.safe2.Accident#getAccidentlevel <em>Accidentlevel</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.Accident#getHazard <em>Hazard</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa2.model.safe2.Safe2Package#getAccident()
 * @model
 * @generated
 */
public interface Accident extends Fundamental {
	/**
	 * Returns the value of the '<em><b>Accidentlevel</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.alisa2.model.safe2.AccidentLevel#getAccident <em>Accident</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accidentlevel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accidentlevel</em>' reference.
	 * @see #setAccidentlevel(AccidentLevel)
	 * @see org.osate.alisa2.model.safe2.Safe2Package#getAccident_Accidentlevel()
	 * @see org.osate.alisa2.model.safe2.AccidentLevel#getAccident
	 * @model opposite="accident" required="true"
	 * @generated
	 */
	AccidentLevel getAccidentlevel();

	/**
	 * Sets the value of the '{@link org.osate.alisa2.model.safe2.Accident#getAccidentlevel <em>Accidentlevel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accidentlevel</em>' reference.
	 * @see #getAccidentlevel()
	 * @generated
	 */
	void setAccidentlevel(AccidentLevel value);

	/**
	 * Returns the value of the '<em><b>Hazard</b></em>' reference list.
	 * The list contents are of type {@link org.osate.alisa2.model.safe2.Hazard}.
	 * It is bidirectional and its opposite is '{@link org.osate.alisa2.model.safe2.Hazard#getAccident <em>Accident</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hazard</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hazard</em>' reference list.
	 * @see org.osate.alisa2.model.safe2.Safe2Package#getAccident_Hazard()
	 * @see org.osate.alisa2.model.safe2.Hazard#getAccident
	 * @model opposite="accident" required="true"
	 * @generated
	 */
	EList<Hazard> getHazard();

} // Accident
