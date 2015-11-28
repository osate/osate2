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
package org.osate.verify.verify.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.alisa.common.common.ComputeDeclaration;
import org.osate.alisa.common.common.ValDeclaration;

import org.osate.categories.categories.PhaseCategory;
import org.osate.categories.categories.UserCategory;

import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getPropertyValues <em>Property Values</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getPhaseCategory <em>Phase Category</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getUserCategory <em>User Category</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getTimeout <em>Timeout</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VerificationActivityImpl extends MinimalEObjectImpl.Container implements VerificationActivity
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
   * The cached value of the '{@link #getResult() <em>Result</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResult()
   * @generated
   * @ordered
   */
  protected EList<ComputeDeclaration> result;

  /**
   * The cached value of the '{@link #getMethod() <em>Method</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethod()
   * @generated
   * @ordered
   */
  protected VerificationMethod method;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<ValDeclaration> parameters;

  /**
   * The cached value of the '{@link #getPropertyValues() <em>Property Values</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyValues()
   * @generated
   * @ordered
   */
  protected EList<ValDeclaration> propertyValues;

  /**
   * The cached value of the '{@link #getPhaseCategory() <em>Phase Category</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPhaseCategory()
   * @generated
   * @ordered
   */
  protected EList<PhaseCategory> phaseCategory;

  /**
   * The cached value of the '{@link #getUserCategory() <em>User Category</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCategory()
   * @generated
   * @ordered
   */
  protected EList<UserCategory> userCategory;

  /**
   * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeout()
   * @generated
   * @ordered
   */
  protected static final int TIMEOUT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeout()
   * @generated
   * @ordered
   */
  protected int timeout = TIMEOUT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VerificationActivityImpl()
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
    return VerifyPackage.Literals.VERIFICATION_ACTIVITY;
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
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ComputeDeclaration> getResult()
  {
    if (result == null)
    {
      result = new EObjectResolvingEList<ComputeDeclaration>(ComputeDeclaration.class, this, VerifyPackage.VERIFICATION_ACTIVITY__RESULT);
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationMethod getMethod()
  {
    if (method != null && method.eIsProxy())
    {
      InternalEObject oldMethod = (InternalEObject)method;
      method = (VerificationMethod)eResolveProxy(oldMethod);
      if (method != oldMethod)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.VERIFICATION_ACTIVITY__METHOD, oldMethod, method));
      }
    }
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationMethod basicGetMethod()
  {
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethod(VerificationMethod newMethod)
  {
    VerificationMethod oldMethod = method;
    method = newMethod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__METHOD, oldMethod, method));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ValDeclaration> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectResolvingEList<ValDeclaration>(ValDeclaration.class, this, VerifyPackage.VERIFICATION_ACTIVITY__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ValDeclaration> getPropertyValues()
  {
    if (propertyValues == null)
    {
      propertyValues = new EObjectResolvingEList<ValDeclaration>(ValDeclaration.class, this, VerifyPackage.VERIFICATION_ACTIVITY__PROPERTY_VALUES);
    }
    return propertyValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PhaseCategory> getPhaseCategory()
  {
    if (phaseCategory == null)
    {
      phaseCategory = new EObjectResolvingEList<PhaseCategory>(PhaseCategory.class, this, VerifyPackage.VERIFICATION_ACTIVITY__PHASE_CATEGORY);
    }
    return phaseCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UserCategory> getUserCategory()
  {
    if (userCategory == null)
    {
      userCategory = new EObjectResolvingEList<UserCategory>(UserCategory.class, this, VerifyPackage.VERIFICATION_ACTIVITY__USER_CATEGORY);
    }
    return userCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getTimeout()
  {
    return timeout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimeout(int newTimeout)
  {
    int oldTimeout = timeout;
    timeout = newTimeout;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT, oldTimeout, timeout));
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
      case VerifyPackage.VERIFICATION_ACTIVITY__NAME:
        return getName();
      case VerifyPackage.VERIFICATION_ACTIVITY__TITLE:
        return getTitle();
      case VerifyPackage.VERIFICATION_ACTIVITY__RESULT:
        return getResult();
      case VerifyPackage.VERIFICATION_ACTIVITY__METHOD:
        if (resolve) return getMethod();
        return basicGetMethod();
      case VerifyPackage.VERIFICATION_ACTIVITY__PARAMETERS:
        return getParameters();
      case VerifyPackage.VERIFICATION_ACTIVITY__PROPERTY_VALUES:
        return getPropertyValues();
      case VerifyPackage.VERIFICATION_ACTIVITY__PHASE_CATEGORY:
        return getPhaseCategory();
      case VerifyPackage.VERIFICATION_ACTIVITY__USER_CATEGORY:
        return getUserCategory();
      case VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT:
        return getTimeout();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case VerifyPackage.VERIFICATION_ACTIVITY__NAME:
        setName((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__TITLE:
        setTitle((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__RESULT:
        getResult().clear();
        getResult().addAll((Collection<? extends ComputeDeclaration>)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__METHOD:
        setMethod((VerificationMethod)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends ValDeclaration>)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__PROPERTY_VALUES:
        getPropertyValues().clear();
        getPropertyValues().addAll((Collection<? extends ValDeclaration>)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__PHASE_CATEGORY:
        getPhaseCategory().clear();
        getPhaseCategory().addAll((Collection<? extends PhaseCategory>)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__USER_CATEGORY:
        getUserCategory().clear();
        getUserCategory().addAll((Collection<? extends UserCategory>)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT:
        setTimeout((Integer)newValue);
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
      case VerifyPackage.VERIFICATION_ACTIVITY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__RESULT:
        getResult().clear();
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__METHOD:
        setMethod((VerificationMethod)null);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__PARAMETERS:
        getParameters().clear();
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__PROPERTY_VALUES:
        getPropertyValues().clear();
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__PHASE_CATEGORY:
        getPhaseCategory().clear();
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__USER_CATEGORY:
        getUserCategory().clear();
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT:
        setTimeout(TIMEOUT_EDEFAULT);
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
      case VerifyPackage.VERIFICATION_ACTIVITY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case VerifyPackage.VERIFICATION_ACTIVITY__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case VerifyPackage.VERIFICATION_ACTIVITY__RESULT:
        return result != null && !result.isEmpty();
      case VerifyPackage.VERIFICATION_ACTIVITY__METHOD:
        return method != null;
      case VerifyPackage.VERIFICATION_ACTIVITY__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case VerifyPackage.VERIFICATION_ACTIVITY__PROPERTY_VALUES:
        return propertyValues != null && !propertyValues.isEmpty();
      case VerifyPackage.VERIFICATION_ACTIVITY__PHASE_CATEGORY:
        return phaseCategory != null && !phaseCategory.isEmpty();
      case VerifyPackage.VERIFICATION_ACTIVITY__USER_CATEGORY:
        return userCategory != null && !userCategory.isEmpty();
      case VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT:
        return timeout != TIMEOUT_EDEFAULT;
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", title: ");
    result.append(title);
    result.append(", timeout: ");
    result.append(timeout);
    result.append(')');
    return result.toString();
  }

} //VerificationActivityImpl
