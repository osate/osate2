/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.AssureResult#getMetrics <em>Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getAssureResult()
 * @model
 * @generated
 */
public interface AssureResult extends EObject
{
  /**
   * Returns the value of the '<em><b>Metrics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metrics</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metrics</em>' containment reference.
   * @see #setMetrics(Metrics)
   * @see org.osate.assure.assure.AssurePackage#getAssureResult_Metrics()
   * @model containment="true"
   * @generated
   */
  Metrics getMetrics();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssureResult#getMetrics <em>Metrics</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metrics</em>' containment reference.
   * @see #getMetrics()
   * @generated
   */
  void setMetrics(Metrics value);

} // AssureResult
