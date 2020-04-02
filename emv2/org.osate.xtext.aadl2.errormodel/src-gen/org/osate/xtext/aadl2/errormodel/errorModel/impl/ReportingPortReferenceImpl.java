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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.aadl2.NamedElement;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ReportingPortReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reporting Port Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ReportingPortReferenceImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ReportingPortReferenceImpl#getPrevious <em>Previous</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReportingPortReferenceImpl extends MinimalEObjectImpl.Container implements ReportingPortReference
{
  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected NamedElement element;

  /**
   * The cached value of the '{@link #getPrevious() <em>Previous</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrevious()
   * @generated
   * @ordered
   */
  protected ReportingPortReference previous;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReportingPortReferenceImpl()
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
    return ErrorModelPackage.Literals.REPORTING_PORT_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement getElement()
  {
    if (element != null && ((EObject)element).eIsProxy())
    {
      InternalEObject oldElement = (InternalEObject)element;
      element = (NamedElement)eResolveProxy(oldElement);
      if (element != oldElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.REPORTING_PORT_REFERENCE__ELEMENT, oldElement, element));
      }
    }
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(NamedElement newElement)
  {
    NamedElement oldElement = element;
    element = newElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.REPORTING_PORT_REFERENCE__ELEMENT, oldElement, element));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReportingPortReference getPrevious()
  {
    return previous;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrevious(ReportingPortReference newPrevious, NotificationChain msgs)
  {
    ReportingPortReference oldPrevious = previous;
    previous = newPrevious;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.REPORTING_PORT_REFERENCE__PREVIOUS, oldPrevious, newPrevious);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrevious(ReportingPortReference newPrevious)
  {
    if (newPrevious != previous)
    {
      NotificationChain msgs = null;
      if (previous != null)
        msgs = ((InternalEObject)previous).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.REPORTING_PORT_REFERENCE__PREVIOUS, null, msgs);
      if (newPrevious != null)
        msgs = ((InternalEObject)newPrevious).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.REPORTING_PORT_REFERENCE__PREVIOUS, null, msgs);
      msgs = basicSetPrevious(newPrevious, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.REPORTING_PORT_REFERENCE__PREVIOUS, newPrevious, newPrevious));
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
      case ErrorModelPackage.REPORTING_PORT_REFERENCE__PREVIOUS:
        return basicSetPrevious(null, msgs);
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
      case ErrorModelPackage.REPORTING_PORT_REFERENCE__ELEMENT:
        if (resolve) return getElement();
        return basicGetElement();
      case ErrorModelPackage.REPORTING_PORT_REFERENCE__PREVIOUS:
        return getPrevious();
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
      case ErrorModelPackage.REPORTING_PORT_REFERENCE__ELEMENT:
        setElement((NamedElement)newValue);
        return;
      case ErrorModelPackage.REPORTING_PORT_REFERENCE__PREVIOUS:
        setPrevious((ReportingPortReference)newValue);
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
      case ErrorModelPackage.REPORTING_PORT_REFERENCE__ELEMENT:
        setElement((NamedElement)null);
        return;
      case ErrorModelPackage.REPORTING_PORT_REFERENCE__PREVIOUS:
        setPrevious((ReportingPortReference)null);
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
      case ErrorModelPackage.REPORTING_PORT_REFERENCE__ELEMENT:
        return element != null;
      case ErrorModelPackage.REPORTING_PORT_REFERENCE__PREVIOUS:
        return previous != null;
    }
    return super.eIsSet(featureID);
  }

} //ReportingPortReferenceImpl
