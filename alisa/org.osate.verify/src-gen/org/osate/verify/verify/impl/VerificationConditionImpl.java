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
package org.osate.verify.verify.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.verify.verify.FormalParameter;
import org.osate.verify.verify.VerificationCondition;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.VerificationConditionImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationConditionImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VerificationConditionImpl extends MinimalEObjectImpl.Container implements VerificationCondition
{
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
  protected EList<FormalParameter> parameters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VerificationConditionImpl()
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
    return VerifyPackage.Literals.VERIFICATION_CONDITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VerificationMethod getMethod()
  {
    if (method != null && method.eIsProxy())
    {
      InternalEObject oldMethod = (InternalEObject)method;
      method = (VerificationMethod)eResolveProxy(oldMethod);
      if (method != oldMethod)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.VERIFICATION_CONDITION__METHOD, oldMethod, method));
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
  @Override
  public void setMethod(VerificationMethod newMethod)
  {
    VerificationMethod oldMethod = method;
    method = newMethod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_CONDITION__METHOD, oldMethod, method));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<FormalParameter> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectResolvingEList<FormalParameter>(FormalParameter.class, this, VerifyPackage.VERIFICATION_CONDITION__PARAMETERS);
    }
    return parameters;
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
      case VerifyPackage.VERIFICATION_CONDITION__METHOD:
        if (resolve) return getMethod();
        return basicGetMethod();
      case VerifyPackage.VERIFICATION_CONDITION__PARAMETERS:
        return getParameters();
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
      case VerifyPackage.VERIFICATION_CONDITION__METHOD:
        setMethod((VerificationMethod)newValue);
        return;
      case VerifyPackage.VERIFICATION_CONDITION__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends FormalParameter>)newValue);
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
      case VerifyPackage.VERIFICATION_CONDITION__METHOD:
        setMethod((VerificationMethod)null);
        return;
      case VerifyPackage.VERIFICATION_CONDITION__PARAMETERS:
        getParameters().clear();
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
      case VerifyPackage.VERIFICATION_CONDITION__METHOD:
        return method != null;
      case VerifyPackage.VERIFICATION_CONDITION__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //VerificationConditionImpl
