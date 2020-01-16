/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.organization.organization;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.organization.organization.OrganizationFactory
 * @model kind="package"
 * @generated
 */
public interface OrganizationPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "organization";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/organization/Organization";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "organization";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  OrganizationPackage eINSTANCE = org.osate.organization.organization.impl.OrganizationPackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.organization.organization.impl.OrganizationImpl <em>Organization</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.organization.organization.impl.OrganizationImpl
   * @see org.osate.organization.organization.impl.OrganizationPackageImpl#getOrganization()
   * @generated
   */
  int ORGANIZATION = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORGANIZATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Stakeholder</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORGANIZATION__STAKEHOLDER = 1;

  /**
   * The number of structural features of the '<em>Organization</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORGANIZATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.organization.organization.impl.StakeholderImpl <em>Stakeholder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.organization.organization.impl.StakeholderImpl
   * @see org.osate.organization.organization.impl.OrganizationPackageImpl#getStakeholder()
   * @generated
   */
  int STAKEHOLDER = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER__NAME = 0;

  /**
   * The feature id for the '<em><b>Fullname</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER__FULLNAME = 1;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER__TITLE = 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER__DESCRIPTION = 3;

  /**
   * The feature id for the '<em><b>Role</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER__ROLE = 4;

  /**
   * The feature id for the '<em><b>Email</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER__EMAIL = 5;

  /**
   * The feature id for the '<em><b>Phone</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER__PHONE = 6;

  /**
   * The feature id for the '<em><b>Supervisor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER__SUPERVISOR = 7;

  /**
   * The number of structural features of the '<em>Stakeholder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_FEATURE_COUNT = 8;


  /**
   * Returns the meta object for class '{@link org.osate.organization.organization.Organization <em>Organization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Organization</em>'.
   * @see org.osate.organization.organization.Organization
   * @generated
   */
  EClass getOrganization();

  /**
   * Returns the meta object for the attribute '{@link org.osate.organization.organization.Organization#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.organization.organization.Organization#getName()
   * @see #getOrganization()
   * @generated
   */
  EAttribute getOrganization_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.organization.organization.Organization#getStakeholder <em>Stakeholder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Stakeholder</em>'.
   * @see org.osate.organization.organization.Organization#getStakeholder()
   * @see #getOrganization()
   * @generated
   */
  EReference getOrganization_Stakeholder();

  /**
   * Returns the meta object for class '{@link org.osate.organization.organization.Stakeholder <em>Stakeholder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stakeholder</em>'.
   * @see org.osate.organization.organization.Stakeholder
   * @generated
   */
  EClass getStakeholder();

  /**
   * Returns the meta object for the attribute '{@link org.osate.organization.organization.Stakeholder#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.organization.organization.Stakeholder#getName()
   * @see #getStakeholder()
   * @generated
   */
  EAttribute getStakeholder_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.organization.organization.Stakeholder#getFullname <em>Fullname</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fullname</em>'.
   * @see org.osate.organization.organization.Stakeholder#getFullname()
   * @see #getStakeholder()
   * @generated
   */
  EAttribute getStakeholder_Fullname();

  /**
   * Returns the meta object for the attribute '{@link org.osate.organization.organization.Stakeholder#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.organization.organization.Stakeholder#getTitle()
   * @see #getStakeholder()
   * @generated
   */
  EAttribute getStakeholder_Title();

  /**
   * Returns the meta object for the attribute '{@link org.osate.organization.organization.Stakeholder#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.osate.organization.organization.Stakeholder#getDescription()
   * @see #getStakeholder()
   * @generated
   */
  EAttribute getStakeholder_Description();

  /**
   * Returns the meta object for the attribute '{@link org.osate.organization.organization.Stakeholder#getRole <em>Role</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Role</em>'.
   * @see org.osate.organization.organization.Stakeholder#getRole()
   * @see #getStakeholder()
   * @generated
   */
  EAttribute getStakeholder_Role();

  /**
   * Returns the meta object for the attribute '{@link org.osate.organization.organization.Stakeholder#getEmail <em>Email</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Email</em>'.
   * @see org.osate.organization.organization.Stakeholder#getEmail()
   * @see #getStakeholder()
   * @generated
   */
  EAttribute getStakeholder_Email();

  /**
   * Returns the meta object for the attribute '{@link org.osate.organization.organization.Stakeholder#getPhone <em>Phone</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Phone</em>'.
   * @see org.osate.organization.organization.Stakeholder#getPhone()
   * @see #getStakeholder()
   * @generated
   */
  EAttribute getStakeholder_Phone();

  /**
   * Returns the meta object for the reference '{@link org.osate.organization.organization.Stakeholder#getSupervisor <em>Supervisor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Supervisor</em>'.
   * @see org.osate.organization.organization.Stakeholder#getSupervisor()
   * @see #getStakeholder()
   * @generated
   */
  EReference getStakeholder_Supervisor();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  OrganizationFactory getOrganizationFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.osate.organization.organization.impl.OrganizationImpl <em>Organization</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.organization.organization.impl.OrganizationImpl
     * @see org.osate.organization.organization.impl.OrganizationPackageImpl#getOrganization()
     * @generated
     */
    EClass ORGANIZATION = eINSTANCE.getOrganization();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ORGANIZATION__NAME = eINSTANCE.getOrganization_Name();

    /**
     * The meta object literal for the '<em><b>Stakeholder</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ORGANIZATION__STAKEHOLDER = eINSTANCE.getOrganization_Stakeholder();

    /**
     * The meta object literal for the '{@link org.osate.organization.organization.impl.StakeholderImpl <em>Stakeholder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.organization.organization.impl.StakeholderImpl
     * @see org.osate.organization.organization.impl.OrganizationPackageImpl#getStakeholder()
     * @generated
     */
    EClass STAKEHOLDER = eINSTANCE.getStakeholder();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STAKEHOLDER__NAME = eINSTANCE.getStakeholder_Name();

    /**
     * The meta object literal for the '<em><b>Fullname</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STAKEHOLDER__FULLNAME = eINSTANCE.getStakeholder_Fullname();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STAKEHOLDER__TITLE = eINSTANCE.getStakeholder_Title();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STAKEHOLDER__DESCRIPTION = eINSTANCE.getStakeholder_Description();

    /**
     * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STAKEHOLDER__ROLE = eINSTANCE.getStakeholder_Role();

    /**
     * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STAKEHOLDER__EMAIL = eINSTANCE.getStakeholder_Email();

    /**
     * The meta object literal for the '<em><b>Phone</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STAKEHOLDER__PHONE = eINSTANCE.getStakeholder_Phone();

    /**
     * The meta object literal for the '<em><b>Supervisor</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STAKEHOLDER__SUPERVISOR = eINSTANCE.getStakeholder_Supervisor();

  }

} //OrganizationPackage
