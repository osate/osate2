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
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.AlisaWorkArea#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AlisaWorkArea#getCases <em>Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAlisaWorkArea()
 * @model
 * @generated
 */
public interface AlisaWorkArea extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAlisaWorkArea_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AlisaWorkArea#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.workbench.alisa.AssuranceEvidenceConfiguration}.
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
  EList<AssuranceEvidenceConfiguration> getCases();

} // AlisaWorkArea
