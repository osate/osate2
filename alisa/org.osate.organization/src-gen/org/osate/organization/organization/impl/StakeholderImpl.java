/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.organization.organization.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.organization.organization.OrganizationPackage;
import org.osate.organization.organization.Stakeholder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stakeholder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.organization.organization.impl.StakeholderImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.organization.organization.impl.StakeholderImpl#getFullname <em>Fullname</em>}</li>
 *   <li>{@link org.osate.organization.organization.impl.StakeholderImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.organization.organization.impl.StakeholderImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.organization.organization.impl.StakeholderImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.osate.organization.organization.impl.StakeholderImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link org.osate.organization.organization.impl.StakeholderImpl#getPhone <em>Phone</em>}</li>
 *   <li>{@link org.osate.organization.organization.impl.StakeholderImpl#getSupervisor <em>Supervisor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StakeholderImpl extends MinimalEObjectImpl.Container implements Stakeholder
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getFullname() <em>Fullname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFullname()
   * @generated
   * @ordered
   */
  protected static final String FULLNAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFullname() <em>Fullname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFullname()
   * @generated
   * @ordered
   */
  protected String fullname = FULLNAME_EDEFAULT;

  /**
   * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected static final String TITLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected String title = TITLE_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getRole() <em>Role</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRole()
   * @generated
   * @ordered
   */
  protected static final String ROLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRole() <em>Role</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRole()
   * @generated
   * @ordered
   */
  protected String role = ROLE_EDEFAULT;

  /**
   * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmail()
   * @generated
   * @ordered
   */
  protected static final String EMAIL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmail()
   * @generated
   * @ordered
   */
  protected String email = EMAIL_EDEFAULT;

  /**
   * The default value of the '{@link #getPhone() <em>Phone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPhone()
   * @generated
   * @ordered
   */
  protected static final String PHONE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPhone() <em>Phone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPhone()
   * @generated
   * @ordered
   */
  protected String phone = PHONE_EDEFAULT;

  /**
   * The cached value of the '{@link #getSupervisor() <em>Supervisor</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupervisor()
   * @generated
   * @ordered
   */
  protected Stakeholder supervisor;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StakeholderImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return OrganizationPackage.Literals.STAKEHOLDER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.STAKEHOLDER__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFullname()
  {
    return fullname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFullname(String newFullname)
  {
    String oldFullname = fullname;
    fullname = newFullname;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.STAKEHOLDER__FULLNAME, oldFullname, fullname));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTitle(String newTitle)
  {
    String oldTitle = title;
    title = newTitle;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.STAKEHOLDER__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.STAKEHOLDER__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRole()
  {
    return role;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRole(String newRole)
  {
    String oldRole = role;
    role = newRole;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.STAKEHOLDER__ROLE, oldRole, role));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEmail()
  {
    return email;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEmail(String newEmail)
  {
    String oldEmail = email;
    email = newEmail;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.STAKEHOLDER__EMAIL, oldEmail, email));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPhone()
  {
    return phone;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPhone(String newPhone)
  {
    String oldPhone = phone;
    phone = newPhone;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.STAKEHOLDER__PHONE, oldPhone, phone));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stakeholder getSupervisor()
  {
    if (supervisor != null && supervisor.eIsProxy())
    {
      InternalEObject oldSupervisor = (InternalEObject)supervisor;
      supervisor = (Stakeholder)eResolveProxy(oldSupervisor);
      if (supervisor != oldSupervisor)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, OrganizationPackage.STAKEHOLDER__SUPERVISOR, oldSupervisor, supervisor));
      }
    }
    return supervisor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stakeholder basicGetSupervisor()
  {
    return supervisor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSupervisor(Stakeholder newSupervisor)
  {
    Stakeholder oldSupervisor = supervisor;
    supervisor = newSupervisor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.STAKEHOLDER__SUPERVISOR, oldSupervisor, supervisor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case OrganizationPackage.STAKEHOLDER__NAME:
        return getName();
      case OrganizationPackage.STAKEHOLDER__FULLNAME:
        return getFullname();
      case OrganizationPackage.STAKEHOLDER__TITLE:
        return getTitle();
      case OrganizationPackage.STAKEHOLDER__DESCRIPTION:
        return getDescription();
      case OrganizationPackage.STAKEHOLDER__ROLE:
        return getRole();
      case OrganizationPackage.STAKEHOLDER__EMAIL:
        return getEmail();
      case OrganizationPackage.STAKEHOLDER__PHONE:
        return getPhone();
      case OrganizationPackage.STAKEHOLDER__SUPERVISOR:
        if (resolve) return getSupervisor();
        return basicGetSupervisor();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case OrganizationPackage.STAKEHOLDER__NAME:
        setName((String)newValue);
        return;
      case OrganizationPackage.STAKEHOLDER__FULLNAME:
        setFullname((String)newValue);
        return;
      case OrganizationPackage.STAKEHOLDER__TITLE:
        setTitle((String)newValue);
        return;
      case OrganizationPackage.STAKEHOLDER__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case OrganizationPackage.STAKEHOLDER__ROLE:
        setRole((String)newValue);
        return;
      case OrganizationPackage.STAKEHOLDER__EMAIL:
        setEmail((String)newValue);
        return;
      case OrganizationPackage.STAKEHOLDER__PHONE:
        setPhone((String)newValue);
        return;
      case OrganizationPackage.STAKEHOLDER__SUPERVISOR:
        setSupervisor((Stakeholder)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case OrganizationPackage.STAKEHOLDER__NAME:
        setName(NAME_EDEFAULT);
        return;
      case OrganizationPackage.STAKEHOLDER__FULLNAME:
        setFullname(FULLNAME_EDEFAULT);
        return;
      case OrganizationPackage.STAKEHOLDER__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case OrganizationPackage.STAKEHOLDER__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case OrganizationPackage.STAKEHOLDER__ROLE:
        setRole(ROLE_EDEFAULT);
        return;
      case OrganizationPackage.STAKEHOLDER__EMAIL:
        setEmail(EMAIL_EDEFAULT);
        return;
      case OrganizationPackage.STAKEHOLDER__PHONE:
        setPhone(PHONE_EDEFAULT);
        return;
      case OrganizationPackage.STAKEHOLDER__SUPERVISOR:
        setSupervisor((Stakeholder)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case OrganizationPackage.STAKEHOLDER__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case OrganizationPackage.STAKEHOLDER__FULLNAME:
        return FULLNAME_EDEFAULT == null ? fullname != null : !FULLNAME_EDEFAULT.equals(fullname);
      case OrganizationPackage.STAKEHOLDER__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case OrganizationPackage.STAKEHOLDER__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case OrganizationPackage.STAKEHOLDER__ROLE:
        return ROLE_EDEFAULT == null ? role != null : !ROLE_EDEFAULT.equals(role);
      case OrganizationPackage.STAKEHOLDER__EMAIL:
        return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
      case OrganizationPackage.STAKEHOLDER__PHONE:
        return PHONE_EDEFAULT == null ? phone != null : !PHONE_EDEFAULT.equals(phone);
      case OrganizationPackage.STAKEHOLDER__SUPERVISOR:
        return supervisor != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", fullname: ");
    result.append(fullname);
    result.append(", title: ");
    result.append(title);
    result.append(", description: ");
    result.append(description);
    result.append(", role: ");
    result.append(role);
    result.append(", email: ");
    result.append(email);
    result.append(", phone: ");
    result.append(phone);
    result.append(')');
    return result.toString();
  }

} //StakeholderImpl
