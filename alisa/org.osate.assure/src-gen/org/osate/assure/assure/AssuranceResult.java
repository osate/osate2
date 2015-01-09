/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.instance.InstanceObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assurance Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.AssuranceResult#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssuranceResult#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getAssuranceResult()
 * @model
 * @generated
 */
public interface AssuranceResult extends EObject
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
   * @see org.osate.assure.assure.AssurePackage#getAssuranceResult_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssuranceResult#getName <em>Name</em>}' attribute.
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
   * @see #setTarget(InstanceObject)
   * @see org.osate.assure.assure.AssurePackage#getAssuranceResult_Target()
   * @model
   * @generated
   */
  InstanceObject getTarget();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssuranceResult#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(InstanceObject value);

} // AssuranceResult
