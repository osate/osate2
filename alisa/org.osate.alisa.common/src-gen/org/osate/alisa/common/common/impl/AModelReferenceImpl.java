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
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.NamedElement;

import org.osate.alisa.common.common.AModelReference;
import org.osate.alisa.common.common.CommonPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AModel Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.AModelReferenceImpl#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.AModelReferenceImpl#getPrev <em>Prev</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AModelReferenceImpl extends AExpressionImpl implements AModelReference
{
  /**
   * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelElement()
   * @generated
   * @ordered
   */
  protected NamedElement modelElement;

  /**
   * The cached value of the '{@link #getPrev() <em>Prev</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrev()
   * @generated
   * @ordered
   */
  protected AModelReference prev;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AModelReferenceImpl()
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
    return CommonPackage.Literals.AMODEL_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamedElement getModelElement()
  {
    if (modelElement != null && ((EObject)modelElement).eIsProxy())
    {
      InternalEObject oldModelElement = (InternalEObject)modelElement;
      modelElement = (NamedElement)eResolveProxy(oldModelElement);
      if (modelElement != oldModelElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CommonPackage.AMODEL_REFERENCE__MODEL_ELEMENT, oldModelElement, modelElement));
      }
    }
    return modelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetModelElement()
  {
    return modelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setModelElement(NamedElement newModelElement)
  {
    NamedElement oldModelElement = modelElement;
    modelElement = newModelElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.AMODEL_REFERENCE__MODEL_ELEMENT, oldModelElement, modelElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AModelReference getPrev()
  {
    return prev;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrev(AModelReference newPrev, NotificationChain msgs)
  {
    AModelReference oldPrev = prev;
    prev = newPrev;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.AMODEL_REFERENCE__PREV, oldPrev, newPrev);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPrev(AModelReference newPrev)
  {
    if (newPrev != prev)
    {
      NotificationChain msgs = null;
      if (prev != null)
        msgs = ((InternalEObject)prev).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.AMODEL_REFERENCE__PREV, null, msgs);
      if (newPrev != null)
        msgs = ((InternalEObject)newPrev).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.AMODEL_REFERENCE__PREV, null, msgs);
      msgs = basicSetPrev(newPrev, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.AMODEL_REFERENCE__PREV, newPrev, newPrev));
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
      case CommonPackage.AMODEL_REFERENCE__PREV:
        return basicSetPrev(null, msgs);
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
      case CommonPackage.AMODEL_REFERENCE__MODEL_ELEMENT:
        if (resolve) return getModelElement();
        return basicGetModelElement();
      case CommonPackage.AMODEL_REFERENCE__PREV:
        return getPrev();
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
      case CommonPackage.AMODEL_REFERENCE__MODEL_ELEMENT:
        setModelElement((NamedElement)newValue);
        return;
      case CommonPackage.AMODEL_REFERENCE__PREV:
        setPrev((AModelReference)newValue);
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
      case CommonPackage.AMODEL_REFERENCE__MODEL_ELEMENT:
        setModelElement((NamedElement)null);
        return;
      case CommonPackage.AMODEL_REFERENCE__PREV:
        setPrev((AModelReference)null);
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
      case CommonPackage.AMODEL_REFERENCE__MODEL_ELEMENT:
        return modelElement != null;
      case CommonPackage.AMODEL_REFERENCE__PREV:
        return prev != null;
    }
    return super.eIsSet(featureID);
  }

} //AModelReferenceImpl
