/**
 */
package org.osate.alisa2.model.safe2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accident Levels</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa2.model.safe2.AccidentLevels#getAccidentlevel <em>Accidentlevel</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa2.model.safe2.Safe2Package#getAccidentLevels()
 * @model
 * @generated
 */
public interface AccidentLevels extends EObject {
	/**
	 * Returns the value of the '<em><b>Accidentlevel</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.alisa2.model.safe2.AccidentLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accidentlevel</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accidentlevel</em>' containment reference list.
	 * @see org.osate.alisa2.model.safe2.Safe2Package#getAccidentLevels_Accidentlevel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AccidentLevel> getAccidentlevel();

} // AccidentLevels
