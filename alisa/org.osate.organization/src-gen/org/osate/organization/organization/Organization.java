/**
 */
package org.osate.organization.organization;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Organization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.organization.organization.Organization#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.organization.organization.Organization#getStakeholder <em>Stakeholder</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.organization.organization.OrganizationPackage#getOrganization()
 * @model
 * @generated
 */
public interface Organization extends EObject
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
   * @see org.osate.organization.organization.OrganizationPackage#getOrganization_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.organization.organization.Organization#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Stakeholder</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.organization.organization.Stakeholder}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stakeholder</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stakeholder</em>' containment reference list.
   * @see org.osate.organization.organization.OrganizationPackage#getOrganization_Stakeholder()
   * @model containment="true"
   * @generated
   */
  EList<Stakeholder> getStakeholder();

} // Organization
