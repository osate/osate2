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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stakeholder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.organization.organization.Stakeholder#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.organization.organization.Stakeholder#getFullname <em>Fullname</em>}</li>
 *   <li>{@link org.osate.organization.organization.Stakeholder#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.organization.organization.Stakeholder#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.organization.organization.Stakeholder#getRole <em>Role</em>}</li>
 *   <li>{@link org.osate.organization.organization.Stakeholder#getEmail <em>Email</em>}</li>
 *   <li>{@link org.osate.organization.organization.Stakeholder#getPhone <em>Phone</em>}</li>
 *   <li>{@link org.osate.organization.organization.Stakeholder#getSupervisor <em>Supervisor</em>}</li>
 * </ul>
 *
 * @see org.osate.organization.organization.OrganizationPackage#getStakeholder()
 * @model
 * @generated
 */
public interface Stakeholder extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.organization.organization.OrganizationPackage#getStakeholder_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.organization.organization.Stakeholder#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Fullname</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fullname</em>' attribute.
   * @see #setFullname(String)
   * @see org.osate.organization.organization.OrganizationPackage#getStakeholder_Fullname()
   * @model
   * @generated
   */
  String getFullname();

  /**
   * Sets the value of the '{@link org.osate.organization.organization.Stakeholder#getFullname <em>Fullname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fullname</em>' attribute.
   * @see #getFullname()
   * @generated
   */
  void setFullname(String value);

  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.osate.organization.organization.OrganizationPackage#getStakeholder_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.organization.organization.Stakeholder#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.osate.organization.organization.OrganizationPackage#getStakeholder_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.osate.organization.organization.Stakeholder#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Role</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role</em>' attribute.
   * @see #setRole(String)
   * @see org.osate.organization.organization.OrganizationPackage#getStakeholder_Role()
   * @model
   * @generated
   */
  String getRole();

  /**
   * Sets the value of the '{@link org.osate.organization.organization.Stakeholder#getRole <em>Role</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role</em>' attribute.
   * @see #getRole()
   * @generated
   */
  void setRole(String value);

  /**
   * Returns the value of the '<em><b>Email</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Email</em>' attribute.
   * @see #setEmail(String)
   * @see org.osate.organization.organization.OrganizationPackage#getStakeholder_Email()
   * @model
   * @generated
   */
  String getEmail();

  /**
   * Sets the value of the '{@link org.osate.organization.organization.Stakeholder#getEmail <em>Email</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Email</em>' attribute.
   * @see #getEmail()
   * @generated
   */
  void setEmail(String value);

  /**
   * Returns the value of the '<em><b>Phone</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Phone</em>' attribute.
   * @see #setPhone(String)
   * @see org.osate.organization.organization.OrganizationPackage#getStakeholder_Phone()
   * @model
   * @generated
   */
  String getPhone();

  /**
   * Sets the value of the '{@link org.osate.organization.organization.Stakeholder#getPhone <em>Phone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Phone</em>' attribute.
   * @see #getPhone()
   * @generated
   */
  void setPhone(String value);

  /**
   * Returns the value of the '<em><b>Supervisor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supervisor</em>' reference.
   * @see #setSupervisor(Stakeholder)
   * @see org.osate.organization.organization.OrganizationPackage#getStakeholder_Supervisor()
   * @model
   * @generated
   */
  Stakeholder getSupervisor();

  /**
   * Sets the value of the '{@link org.osate.organization.organization.Stakeholder#getSupervisor <em>Supervisor</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Supervisor</em>' reference.
   * @see #getSupervisor()
   * @generated
   */
  void setSupervisor(Stakeholder value);

} // Stakeholder
