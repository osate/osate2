/**
 */
package org.osate.alisa2.model.safe2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accident Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa2.model.safe2.AccidentLevel#getAccident <em>Accident</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa2.model.safe2.Safe2Package#getAccidentLevel()
 * @model
 * @generated
 */
public interface AccidentLevel extends Fundamental {
	/**
	 * Returns the value of the '<em><b>Accident</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.alisa2.model.safe2.Accident}.
	 * It is bidirectional and its opposite is '{@link org.osate.alisa2.model.safe2.Accident#getAccidentlevel <em>Accidentlevel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accident</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accident</em>' containment reference list.
	 * @see org.osate.alisa2.model.safe2.Safe2Package#getAccidentLevel_Accident()
	 * @see org.osate.alisa2.model.safe2.Accident#getAccidentlevel
	 * @model opposite="accidentlevel" containment="true" required="true"
	 * @generated
	 */
	EList<Accident> getAccident();

} // AccidentLevel
