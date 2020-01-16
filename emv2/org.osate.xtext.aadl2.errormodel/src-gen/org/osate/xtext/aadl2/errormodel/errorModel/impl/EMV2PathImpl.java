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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.ContainmentPathElement;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMV2 Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PathImpl#getContainmentPath <em>Containment Path</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PathImpl#getEmv2Target <em>Emv2 Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EMV2PathImpl extends ElementImpl implements EMV2Path
{
  /**
   * The cached value of the '{@link #getContainmentPath() <em>Containment Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContainmentPath()
   * @generated
   * @ordered
   */
  protected ContainmentPathElement containmentPath;

  /**
   * The cached value of the '{@link #getEmv2Target() <em>Emv2 Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmv2Target()
   * @generated
   * @ordered
   */
  protected EMV2PathElement emv2Target;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EMV2PathImpl()
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
    return ErrorModelPackage.Literals.EMV2_PATH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContainmentPathElement getContainmentPath()
  {
    return containmentPath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContainmentPath(ContainmentPathElement newContainmentPath, NotificationChain msgs)
  {
    ContainmentPathElement oldContainmentPath = containmentPath;
    containmentPath = newContainmentPath;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH, oldContainmentPath, newContainmentPath);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContainmentPath(ContainmentPathElement newContainmentPath)
  {
    if (newContainmentPath != containmentPath)
    {
      NotificationChain msgs = null;
      if (containmentPath != null)
        msgs = ((InternalEObject)containmentPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH, null, msgs);
      if (newContainmentPath != null)
        msgs = ((InternalEObject)newContainmentPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH, null, msgs);
      msgs = basicSetContainmentPath(newContainmentPath, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH, newContainmentPath, newContainmentPath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMV2PathElement getEmv2Target()
  {
    return emv2Target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEmv2Target(EMV2PathElement newEmv2Target, NotificationChain msgs)
  {
    EMV2PathElement oldEmv2Target = emv2Target;
    emv2Target = newEmv2Target;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH__EMV2_TARGET, oldEmv2Target, newEmv2Target);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEmv2Target(EMV2PathElement newEmv2Target)
  {
    if (newEmv2Target != emv2Target)
    {
      NotificationChain msgs = null;
      if (emv2Target != null)
        msgs = ((InternalEObject)emv2Target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.EMV2_PATH__EMV2_TARGET, null, msgs);
      if (newEmv2Target != null)
        msgs = ((InternalEObject)newEmv2Target).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.EMV2_PATH__EMV2_TARGET, null, msgs);
      msgs = basicSetEmv2Target(newEmv2Target, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH__EMV2_TARGET, newEmv2Target, newEmv2Target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH:
        return basicSetContainmentPath(null, msgs);
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        return basicSetEmv2Target(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH:
        return getContainmentPath();
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        return getEmv2Target();
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
      case ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH:
        setContainmentPath((ContainmentPathElement)newValue);
        return;
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        setEmv2Target((EMV2PathElement)newValue);
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
      case ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH:
        setContainmentPath((ContainmentPathElement)null);
        return;
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        setEmv2Target((EMV2PathElement)null);
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
      case ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH:
        return containmentPath != null;
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        return emv2Target != null;
    }
    return super.eIsSet(featureID);
  }

} //EMV2PathImpl
