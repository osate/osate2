/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.common.util.EList;

import org.osate.categories.categories.HazardCategory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hazard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.Hazard#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Hazard#getRequirementReference <em>Requirement Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getHazard()
 * @model
 * @generated
 */
public interface Hazard extends ContractualElement
{
  /**
   * Returns the value of the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Category</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category</em>' reference.
   * @see #setCategory(HazardCategory)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getHazard_Category()
   * @model
   * @generated
   */
  HazardCategory getCategory();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.Hazard#getCategory <em>Category</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Category</em>' reference.
   * @see #getCategory()
   * @generated
   */
  void setCategory(HazardCategory value);

  /**
   * Returns the value of the '<em><b>Requirement Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Requirement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement Reference</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getHazard_RequirementReference()
   * @model
   * @generated
   */
  EList<Requirement> getRequirementReference();

} // Hazard
