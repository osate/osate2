/**
 */
package org.osate.organization.organization;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.organization.organization.OrganizationPackage
 * @generated
 */
public interface OrganizationFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  OrganizationFactory eINSTANCE = org.osate.organization.organization.impl.OrganizationFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Organization</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Organization</em>'.
   * @generated
   */
  Organization createOrganization();

  /**
   * Returns a new object of class '<em>Stakeholder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stakeholder</em>'.
   * @generated
   */
  Stakeholder createStakeholder();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  OrganizationPackage getOrganizationPackage();

} //OrganizationFactory
