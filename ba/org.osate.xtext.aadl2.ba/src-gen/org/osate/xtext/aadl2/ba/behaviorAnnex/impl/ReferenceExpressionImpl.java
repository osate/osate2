/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ba.behaviorAnnex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.Reference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceExpressionImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceExpressionImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceExpressionImpl#isDequeue <em>Dequeue</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceExpressionImpl#isCount <em>Count</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceExpressionImpl#isFresh <em>Fresh</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceExpressionImpl extends IntegerValueImpl implements ReferenceExpression
{
  /**
   * The cached value of the '{@link #getReference() <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReference()
   * @generated
   * @ordered
   */
  protected Reference reference;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected PropertyReferenceTail property;

  /**
   * The default value of the '{@link #isDequeue() <em>Dequeue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDequeue()
   * @generated
   * @ordered
   */
  protected static final boolean DEQUEUE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDequeue() <em>Dequeue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDequeue()
   * @generated
   * @ordered
   */
  protected boolean dequeue = DEQUEUE_EDEFAULT;

  /**
   * The default value of the '{@link #isCount() <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCount()
   * @generated
   * @ordered
   */
  protected static final boolean COUNT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCount() <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCount()
   * @generated
   * @ordered
   */
  protected boolean count = COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #isFresh() <em>Fresh</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFresh()
   * @generated
   * @ordered
   */
  protected static final boolean FRESH_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFresh() <em>Fresh</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFresh()
   * @generated
   * @ordered
   */
  protected boolean fresh = FRESH_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceExpressionImpl()
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
    return BehaviorAnnexPackage.Literals.REFERENCE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Reference getReference()
  {
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReference(Reference newReference, NotificationChain msgs)
  {
    Reference oldReference = reference;
    reference = newReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.REFERENCE_EXPRESSION__REFERENCE, oldReference, newReference);
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
  public void setReference(Reference newReference)
  {
    if (newReference != reference)
    {
      NotificationChain msgs = null;
      if (reference != null)
        msgs = ((InternalEObject)reference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.REFERENCE_EXPRESSION__REFERENCE, null, msgs);
      if (newReference != null)
        msgs = ((InternalEObject)newReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.REFERENCE_EXPRESSION__REFERENCE, null, msgs);
      msgs = basicSetReference(newReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.REFERENCE_EXPRESSION__REFERENCE, newReference, newReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyReferenceTail getProperty()
  {
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProperty(PropertyReferenceTail newProperty, NotificationChain msgs)
  {
    PropertyReferenceTail oldProperty = property;
    property = newProperty;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.REFERENCE_EXPRESSION__PROPERTY, oldProperty, newProperty);
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
  public void setProperty(PropertyReferenceTail newProperty)
  {
    if (newProperty != property)
    {
      NotificationChain msgs = null;
      if (property != null)
        msgs = ((InternalEObject)property).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.REFERENCE_EXPRESSION__PROPERTY, null, msgs);
      if (newProperty != null)
        msgs = ((InternalEObject)newProperty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.REFERENCE_EXPRESSION__PROPERTY, null, msgs);
      msgs = basicSetProperty(newProperty, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.REFERENCE_EXPRESSION__PROPERTY, newProperty, newProperty));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isDequeue()
  {
    return dequeue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDequeue(boolean newDequeue)
  {
    boolean oldDequeue = dequeue;
    dequeue = newDequeue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.REFERENCE_EXPRESSION__DEQUEUE, oldDequeue, dequeue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isCount()
  {
    return count;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCount(boolean newCount)
  {
    boolean oldCount = count;
    count = newCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.REFERENCE_EXPRESSION__COUNT, oldCount, count));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isFresh()
  {
    return fresh;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFresh(boolean newFresh)
  {
    boolean oldFresh = fresh;
    fresh = newFresh;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.REFERENCE_EXPRESSION__FRESH, oldFresh, fresh));
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
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__REFERENCE:
        return basicSetReference(null, msgs);
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__PROPERTY:
        return basicSetProperty(null, msgs);
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
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__REFERENCE:
        return getReference();
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__PROPERTY:
        return getProperty();
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__DEQUEUE:
        return isDequeue();
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__COUNT:
        return isCount();
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__FRESH:
        return isFresh();
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
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__REFERENCE:
        setReference((Reference)newValue);
        return;
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__PROPERTY:
        setProperty((PropertyReferenceTail)newValue);
        return;
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__DEQUEUE:
        setDequeue((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__COUNT:
        setCount((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__FRESH:
        setFresh((Boolean)newValue);
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
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__REFERENCE:
        setReference((Reference)null);
        return;
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__PROPERTY:
        setProperty((PropertyReferenceTail)null);
        return;
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__DEQUEUE:
        setDequeue(DEQUEUE_EDEFAULT);
        return;
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__COUNT:
        setCount(COUNT_EDEFAULT);
        return;
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__FRESH:
        setFresh(FRESH_EDEFAULT);
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
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__REFERENCE:
        return reference != null;
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__PROPERTY:
        return property != null;
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__DEQUEUE:
        return dequeue != DEQUEUE_EDEFAULT;
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__COUNT:
        return count != COUNT_EDEFAULT;
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION__FRESH:
        return fresh != FRESH_EDEFAULT;
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
    result.append(" (dequeue: ");
    result.append(dequeue);
    result.append(", count: ");
    result.append(count);
    result.append(", fresh: ");
    result.append(fresh);
    result.append(')');
    return result.toString();
  }

} //ReferenceExpressionImpl
