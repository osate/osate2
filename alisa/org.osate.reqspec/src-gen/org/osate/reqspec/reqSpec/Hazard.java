/**
 */
package org.osate.reqspec.reqSpec;

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
 *   <li>{@link org.osate.reqspec.reqSpec.Hazard#getDescription <em>Description</em>}</li>
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
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getHazard_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.Hazard#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

} // Hazard
