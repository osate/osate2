/**
 */
package org.osate.asap.model.safe2;

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
 *   <li>{@link org.osate.asap.model.safe2.AccidentLevel#getAccident <em>Accident</em>}</li>
 * </ul>
 *
 * @see org.osate.asap.model.safe2.Safe2Package#getAccidentLevel()
 * @model
 * @generated
 */
public interface AccidentLevel extends Fundamental {
	/**
	 * Returns the value of the '<em><b>Accident</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.asap.model.safe2.Accident}.
	 * It is bidirectional and its opposite is '{@link org.osate.asap.model.safe2.Accident#getAccidentlevel <em>Accidentlevel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accident</em>' containment reference list.
	 * @see org.osate.asap.model.safe2.Safe2Package#getAccidentLevel_Accident()
	 * @see org.osate.asap.model.safe2.Accident#getAccidentlevel
	 * @model opposite="accidentlevel" containment="true" required="true"
	 * @generated
	 */
	EList<Accident> getAccident();

} // AccidentLevel
