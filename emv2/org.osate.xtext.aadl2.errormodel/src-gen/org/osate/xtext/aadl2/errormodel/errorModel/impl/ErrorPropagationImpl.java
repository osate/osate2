/**
 * *
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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

import org.osate.aadl2.DirectionType;

import org.osate.aadl2.impl.NamedElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Propagation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#getFeatureorPPRef <em>Featureor PP Ref</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#isNot <em>Not</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#getTypeSet <em>Type Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorPropagationImpl extends NamedElementImpl implements ErrorPropagation
{
  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final String KIND_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected String kind = KIND_EDEFAULT;

  /**
   * The cached value of the '{@link #getFeatureorPPRef() <em>Featureor PP Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureorPPRef()
   * @generated
   * @ordered
   */
  protected FeatureorPPReference featureorPPRef;

  /**
   * The default value of the '{@link #isNot() <em>Not</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNot()
   * @generated
   * @ordered
   */
  protected static final boolean NOT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNot() <em>Not</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNot()
   * @generated
   * @ordered
   */
  protected boolean not = NOT_EDEFAULT;

  /**
   * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected static final DirectionType DIRECTION_EDEFAULT = DirectionType.IN;

  /**
   * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected DirectionType direction = DIRECTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypeSet() <em>Type Set</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeSet()
   * @generated
   * @ordered
   */
  protected TypeSet typeSet;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorPropagationImpl()
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
    return ErrorModelPackage.Literals.ERROR_PROPAGATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getKind()
  {
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setKind(String newKind)
  {
    String oldKind = kind;
    kind = newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__KIND, oldKind, kind));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FeatureorPPReference getFeatureorPPRef()
  {
    return featureorPPRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFeatureorPPRef(FeatureorPPReference newFeatureorPPRef, NotificationChain msgs)
  {
    FeatureorPPReference oldFeatureorPPRef = featureorPPRef;
    featureorPPRef = newFeatureorPPRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REF, oldFeatureorPPRef, newFeatureorPPRef);
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
  public void setFeatureorPPRef(FeatureorPPReference newFeatureorPPRef)
  {
    if (newFeatureorPPRef != featureorPPRef)
    {
      NotificationChain msgs = null;
      if (featureorPPRef != null)
        msgs = ((InternalEObject)featureorPPRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REF, null, msgs);
      if (newFeatureorPPRef != null)
        msgs = ((InternalEObject)newFeatureorPPRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REF, null, msgs);
      msgs = basicSetFeatureorPPRef(newFeatureorPPRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REF, newFeatureorPPRef, newFeatureorPPRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isNot()
  {
    return not;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNot(boolean newNot)
  {
    boolean oldNot = not;
    not = newNot;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__NOT, oldNot, not));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DirectionType getDirection()
  {
    return direction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDirection(DirectionType newDirection)
  {
    DirectionType oldDirection = direction;
    direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__DIRECTION, oldDirection, direction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TypeSet getTypeSet()
  {
    return typeSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeSet(TypeSet newTypeSet, NotificationChain msgs)
  {
    TypeSet oldTypeSet = typeSet;
    typeSet = newTypeSet;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET, oldTypeSet, newTypeSet);
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
  public void setTypeSet(TypeSet newTypeSet)
  {
    if (newTypeSet != typeSet)
    {
      NotificationChain msgs = null;
      if (typeSet != null)
        msgs = ((InternalEObject)typeSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET, null, msgs);
      if (newTypeSet != null)
        msgs = ((InternalEObject)newTypeSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET, null, msgs);
      msgs = basicSetTypeSet(newTypeSet, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET, newTypeSet, newTypeSet));
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
      case ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REF:
        return basicSetFeatureorPPRef(null, msgs);
      case ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET:
        return basicSetTypeSet(null, msgs);
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
      case ErrorModelPackage.ERROR_PROPAGATION__KIND:
        return getKind();
      case ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REF:
        return getFeatureorPPRef();
      case ErrorModelPackage.ERROR_PROPAGATION__NOT:
        return isNot();
      case ErrorModelPackage.ERROR_PROPAGATION__DIRECTION:
        return getDirection();
      case ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET:
        return getTypeSet();
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
      case ErrorModelPackage.ERROR_PROPAGATION__KIND:
        setKind((String)newValue);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REF:
        setFeatureorPPRef((FeatureorPPReference)newValue);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__NOT:
        setNot((Boolean)newValue);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__DIRECTION:
        setDirection((DirectionType)newValue);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET:
        setTypeSet((TypeSet)newValue);
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
      case ErrorModelPackage.ERROR_PROPAGATION__KIND:
        setKind(KIND_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REF:
        setFeatureorPPRef((FeatureorPPReference)null);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__NOT:
        setNot(NOT_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__DIRECTION:
        setDirection(DIRECTION_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET:
        setTypeSet((TypeSet)null);
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
      case ErrorModelPackage.ERROR_PROPAGATION__KIND:
        return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
      case ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REF:
        return featureorPPRef != null;
      case ErrorModelPackage.ERROR_PROPAGATION__NOT:
        return not != NOT_EDEFAULT;
      case ErrorModelPackage.ERROR_PROPAGATION__DIRECTION:
        return direction != DIRECTION_EDEFAULT;
      case ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET:
        return typeSet != null;
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
    result.append(" (kind: ");
    result.append(kind);
    result.append(", not: ");
    result.append(not);
    result.append(", direction: ");
    result.append(direction);
    result.append(')');
    return result.toString();
  }

} //ErrorPropagationImpl
