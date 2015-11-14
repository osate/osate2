/**
 */
package org.osate.alisa.workbench.alisa;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Work Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.AlisaWorkArea#getCases <em>Cases</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAlisaWorkArea()
 * @model
 * @generated
 */
public interface AlisaWorkArea extends EObject
{
  /**
   * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cases</em>' containment reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAlisaWorkArea_Cases()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getCases();

} // AlisaWorkArea
