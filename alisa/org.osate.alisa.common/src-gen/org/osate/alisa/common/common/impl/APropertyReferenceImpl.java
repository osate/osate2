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
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.AbstractNamedValue;

import org.osate.alisa.common.common.AModelReference;
import org.osate.alisa.common.common.APropertyReference;
import org.osate.alisa.common.common.CommonPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AProperty Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.APropertyReferenceImpl#getModelElementReference <em>Model Element Reference</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.APropertyReferenceImpl#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class APropertyReferenceImpl extends AExpressionImpl implements APropertyReference
{
  /**
   * The cached value of the '{@link #getModelElementReference() <em>Model Element Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelElementReference()
   * @generated
   * @ordered
   */
  protected AModelReference modelElementReference;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected AbstractNamedValue property;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected APropertyReferenceImpl()
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
    return CommonPackage.Literals.APROPERTY_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AModelReference getModelElementReference()
  {
    return modelElementReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelElementReference(AModelReference newModelElementReference, NotificationChain msgs)
  {
    AModelReference oldModelElementReference = modelElementReference;
    modelElementReference = newModelElementReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.APROPERTY_REFERENCE__MODEL_ELEMENT_REFERENCE, oldModelElementReference, newModelElementReference);
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
  public void setModelElementReference(AModelReference newModelElementReference)
  {
    if (newModelElementReference != modelElementReference)
    {
      NotificationChain msgs = null;
      if (modelElementReference != null)
        msgs = ((InternalEObject)modelElementReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.APROPERTY_REFERENCE__MODEL_ELEMENT_REFERENCE, null, msgs);
      if (newModelElementReference != null)
        msgs = ((InternalEObject)newModelElementReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.APROPERTY_REFERENCE__MODEL_ELEMENT_REFERENCE, null, msgs);
      msgs = basicSetModelElementReference(newModelElementReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.APROPERTY_REFERENCE__MODEL_ELEMENT_REFERENCE, newModelElementReference, newModelElementReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AbstractNamedValue getProperty()
  {
    if (property != null && ((EObject)property).eIsProxy())
    {
      InternalEObject oldProperty = (InternalEObject)property;
      property = (AbstractNamedValue)eResolveProxy(oldProperty);
      if (property != oldProperty)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CommonPackage.APROPERTY_REFERENCE__PROPERTY, oldProperty, property));
      }
    }
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractNamedValue basicGetProperty()
  {
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProperty(AbstractNamedValue newProperty)
  {
    AbstractNamedValue oldProperty = property;
    property = newProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.APROPERTY_REFERENCE__PROPERTY, oldProperty, property));
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
      case CommonPackage.APROPERTY_REFERENCE__MODEL_ELEMENT_REFERENCE:
        return basicSetModelElementReference(null, msgs);
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
      case CommonPackage.APROPERTY_REFERENCE__MODEL_ELEMENT_REFERENCE:
        return getModelElementReference();
      case CommonPackage.APROPERTY_REFERENCE__PROPERTY:
        if (resolve) return getProperty();
        return basicGetProperty();
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
      case CommonPackage.APROPERTY_REFERENCE__MODEL_ELEMENT_REFERENCE:
        setModelElementReference((AModelReference)newValue);
        return;
      case CommonPackage.APROPERTY_REFERENCE__PROPERTY:
        setProperty((AbstractNamedValue)newValue);
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
      case CommonPackage.APROPERTY_REFERENCE__MODEL_ELEMENT_REFERENCE:
        setModelElementReference((AModelReference)null);
        return;
      case CommonPackage.APROPERTY_REFERENCE__PROPERTY:
        setProperty((AbstractNamedValue)null);
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
      case CommonPackage.APROPERTY_REFERENCE__MODEL_ELEMENT_REFERENCE:
        return modelElementReference != null;
      case CommonPackage.APROPERTY_REFERENCE__PROPERTY:
        return property != null;
    }
    return super.eIsSet(featureID);
  }

} //APropertyReferenceImpl
