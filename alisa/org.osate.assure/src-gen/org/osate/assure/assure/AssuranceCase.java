/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.instance.SystemInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assurance Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.AssuranceCase#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssuranceCase#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssuranceCase#getResults <em>Results</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getAssuranceCase()
 * @model
 * @generated
 */
public interface AssuranceCase extends EObject
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
   * @see org.osate.assure.assure.AssurePackage#getAssuranceCase_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssuranceCase#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(SystemInstance)
   * @see org.osate.assure.assure.AssurePackage#getAssuranceCase_Target()
   * @model
   * @generated
   */
  SystemInstance getTarget();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssuranceCase#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(SystemInstance value);

  /**
   * Returns the value of the '<em><b>Results</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.AssuranceResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Results</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getAssuranceCase_Results()
   * @model containment="true"
   * @generated
   */
  EList<AssuranceResult> getResults();

} // AssuranceCase
