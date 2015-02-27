/**
 */
package org.osate.alisa.workbench.alisa;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assurance Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getAssurancePlan <em>Assurance Plan</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask()
 * @model
 * @generated
 */
public interface AssuranceTask extends AssurancePlan
{
  /**
   * Returns the value of the '<em><b>Assurance Plan</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assurance Plan</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assurance Plan</em>' reference.
   * @see #setAssurancePlan(AssurancePlan)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_AssurancePlan()
   * @model
   * @generated
   */
  AssurancePlan getAssurancePlan();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getAssurancePlan <em>Assurance Plan</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assurance Plan</em>' reference.
   * @see #getAssurancePlan()
   * @generated
   */
  void setAssurancePlan(AssurancePlan value);

} // AssuranceTask
