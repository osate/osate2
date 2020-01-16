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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.Property;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.BranchValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.BranchValueImpl#getRealvalue <em>Realvalue</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.BranchValueImpl#getSymboliclabel <em>Symboliclabel</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.BranchValueImpl#isOthers <em>Others</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BranchValueImpl extends ElementImpl implements BranchValue
{
  /**
   * The default value of the '{@link #getRealvalue() <em>Realvalue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealvalue()
   * @generated
   * @ordered
   */
  protected static final String REALVALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRealvalue() <em>Realvalue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealvalue()
   * @generated
   * @ordered
   */
  protected String realvalue = REALVALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getSymboliclabel() <em>Symboliclabel</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymboliclabel()
   * @generated
   * @ordered
   */
  protected Property symboliclabel;

  /**
   * The default value of the '{@link #isOthers() <em>Others</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOthers()
   * @generated
   * @ordered
   */
  protected static final boolean OTHERS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOthers() <em>Others</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOthers()
   * @generated
   * @ordered
   */
  protected boolean others = OTHERS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BranchValueImpl()
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
    return ErrorModelPackage.Literals.BRANCH_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRealvalue()
  {
    return realvalue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRealvalue(String newRealvalue)
  {
    String oldRealvalue = realvalue;
    realvalue = newRealvalue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.BRANCH_VALUE__REALVALUE, oldRealvalue, realvalue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property getSymboliclabel()
  {
    if (symboliclabel != null && ((EObject)symboliclabel).eIsProxy())
    {
      InternalEObject oldSymboliclabel = (InternalEObject)symboliclabel;
      symboliclabel = (Property)eResolveProxy(oldSymboliclabel);
      if (symboliclabel != oldSymboliclabel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.BRANCH_VALUE__SYMBOLICLABEL, oldSymboliclabel, symboliclabel));
      }
    }
    return symboliclabel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property basicGetSymboliclabel()
  {
    return symboliclabel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSymboliclabel(Property newSymboliclabel)
  {
    Property oldSymboliclabel = symboliclabel;
    symboliclabel = newSymboliclabel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.BRANCH_VALUE__SYMBOLICLABEL, oldSymboliclabel, symboliclabel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOthers()
  {
    return others;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOthers(boolean newOthers)
  {
    boolean oldOthers = others;
    others = newOthers;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.BRANCH_VALUE__OTHERS, oldOthers, others));
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
      case ErrorModelPackage.BRANCH_VALUE__REALVALUE:
        return getRealvalue();
      case ErrorModelPackage.BRANCH_VALUE__SYMBOLICLABEL:
        if (resolve) return getSymboliclabel();
        return basicGetSymboliclabel();
      case ErrorModelPackage.BRANCH_VALUE__OTHERS:
        return isOthers();
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
      case ErrorModelPackage.BRANCH_VALUE__REALVALUE:
        setRealvalue((String)newValue);
        return;
      case ErrorModelPackage.BRANCH_VALUE__SYMBOLICLABEL:
        setSymboliclabel((Property)newValue);
        return;
      case ErrorModelPackage.BRANCH_VALUE__OTHERS:
        setOthers((Boolean)newValue);
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
      case ErrorModelPackage.BRANCH_VALUE__REALVALUE:
        setRealvalue(REALVALUE_EDEFAULT);
        return;
      case ErrorModelPackage.BRANCH_VALUE__SYMBOLICLABEL:
        setSymboliclabel((Property)null);
        return;
      case ErrorModelPackage.BRANCH_VALUE__OTHERS:
        setOthers(OTHERS_EDEFAULT);
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
      case ErrorModelPackage.BRANCH_VALUE__REALVALUE:
        return REALVALUE_EDEFAULT == null ? realvalue != null : !REALVALUE_EDEFAULT.equals(realvalue);
      case ErrorModelPackage.BRANCH_VALUE__SYMBOLICLABEL:
        return symboliclabel != null;
      case ErrorModelPackage.BRANCH_VALUE__OTHERS:
        return others != OTHERS_EDEFAULT;
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
    result.append(" (realvalue: ");
    result.append(realvalue);
    result.append(", others: ");
    result.append(others);
    result.append(')');
    return result.toString();
  }

} //BranchValueImpl
