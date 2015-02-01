/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.common.util.EList;

import org.osate.organization.organization.Stakeholder;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.Goal#getRefinesReference <em>Refines Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Goal#getConflictsReference <em>Conflicts Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Goal#getStakeholderReference <em>Stakeholder Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getGoal()
 * @model
 * @generated
 */
public interface Goal extends ContractualElement
{
  /**
   * Returns the value of the '<em><b>Refines Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Goal}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Refines Reference</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Refines Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getGoal_RefinesReference()
   * @model
   * @generated
   */
  EList<Goal> getRefinesReference();

  /**
   * Returns the value of the '<em><b>Conflicts Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Goal}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conflicts Reference</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conflicts Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getGoal_ConflictsReference()
   * @model
   * @generated
   */
  EList<Goal> getConflictsReference();

  /**
   * Returns the value of the '<em><b>Stakeholder Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.organization.organization.Stakeholder}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stakeholder Reference</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stakeholder Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getGoal_StakeholderReference()
   * @model
   * @generated
   */
  EList<Stakeholder> getStakeholderReference();

} // Goal
