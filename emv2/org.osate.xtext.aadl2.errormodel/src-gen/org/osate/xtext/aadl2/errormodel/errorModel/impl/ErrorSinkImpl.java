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
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Sink</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSinkImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSinkImpl#isAllIncoming <em>All Incoming</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorSinkImpl extends ErrorFlowImpl implements ErrorSink
{
  /**
   * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncoming()
   * @generated
   * @ordered
   */
  protected ErrorPropagation incoming;

  /**
   * The default value of the '{@link #isAllIncoming() <em>All Incoming</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllIncoming()
   * @generated
   * @ordered
   */
  protected static final boolean ALL_INCOMING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAllIncoming() <em>All Incoming</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllIncoming()
   * @generated
   * @ordered
   */
  protected boolean allIncoming = ALL_INCOMING_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorSinkImpl()
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
    return ErrorModelPackage.Literals.ERROR_SINK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagation getIncoming()
  {
    if (incoming != null && incoming.eIsProxy())
    {
      InternalEObject oldIncoming = (InternalEObject)incoming;
      incoming = (ErrorPropagation)eResolveProxy(oldIncoming);
      if (incoming != oldIncoming)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_SINK__INCOMING, oldIncoming, incoming));
      }
    }
    return incoming;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagation basicGetIncoming()
  {
    return incoming;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIncoming(ErrorPropagation newIncoming)
  {
    ErrorPropagation oldIncoming = incoming;
    incoming = newIncoming;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SINK__INCOMING, oldIncoming, incoming));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAllIncoming()
  {
    return allIncoming;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAllIncoming(boolean newAllIncoming)
  {
    boolean oldAllIncoming = allIncoming;
    allIncoming = newAllIncoming;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SINK__ALL_INCOMING, oldAllIncoming, allIncoming));
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
      case ErrorModelPackage.ERROR_SINK__INCOMING:
        if (resolve) return getIncoming();
        return basicGetIncoming();
      case ErrorModelPackage.ERROR_SINK__ALL_INCOMING:
        return isAllIncoming();
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
      case ErrorModelPackage.ERROR_SINK__INCOMING:
        setIncoming((ErrorPropagation)newValue);
        return;
      case ErrorModelPackage.ERROR_SINK__ALL_INCOMING:
        setAllIncoming((Boolean)newValue);
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
      case ErrorModelPackage.ERROR_SINK__INCOMING:
        setIncoming((ErrorPropagation)null);
        return;
      case ErrorModelPackage.ERROR_SINK__ALL_INCOMING:
        setAllIncoming(ALL_INCOMING_EDEFAULT);
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
      case ErrorModelPackage.ERROR_SINK__INCOMING:
        return incoming != null;
      case ErrorModelPackage.ERROR_SINK__ALL_INCOMING:
        return allIncoming != ALL_INCOMING_EDEFAULT;
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
    result.append(" (allIncoming: ");
    result.append(allIncoming);
    result.append(')');
    return result.toString();
  }

} //ErrorSinkImpl
