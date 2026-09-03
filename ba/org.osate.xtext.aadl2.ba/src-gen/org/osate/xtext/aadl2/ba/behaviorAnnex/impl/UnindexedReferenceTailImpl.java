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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceSegment;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceTail;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unindexed Reference Tail</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceTailImpl#getSeparator <em>Separator</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceTailImpl#getSegment <em>Segment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnindexedReferenceTailImpl extends MinimalEObjectImpl.Container implements UnindexedReferenceTail
{
  /**
   * The default value of the '{@link #getSeparator() <em>Separator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSeparator()
   * @generated
   * @ordered
   */
  protected static final String SEPARATOR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSeparator() <em>Separator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSeparator()
   * @generated
   * @ordered
   */
  protected String separator = SEPARATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getSegment() <em>Segment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSegment()
   * @generated
   * @ordered
   */
  protected UnindexedReferenceSegment segment;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnindexedReferenceTailImpl()
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
    return BehaviorAnnexPackage.Literals.UNINDEXED_REFERENCE_TAIL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getSeparator()
  {
    return separator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSeparator(String newSeparator)
  {
    String oldSeparator = separator;
    separator = newSeparator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEPARATOR, oldSeparator, separator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnindexedReferenceSegment getSegment()
  {
    return segment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSegment(UnindexedReferenceSegment newSegment, NotificationChain msgs)
  {
    UnindexedReferenceSegment oldSegment = segment;
    segment = newSegment;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEGMENT, oldSegment, newSegment);
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
  public void setSegment(UnindexedReferenceSegment newSegment)
  {
    if (newSegment != segment)
    {
      NotificationChain msgs = null;
      if (segment != null)
        msgs = ((InternalEObject)segment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEGMENT, null, msgs);
      if (newSegment != null)
        msgs = ((InternalEObject)newSegment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEGMENT, null, msgs);
      msgs = basicSetSegment(newSegment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEGMENT, newSegment, newSegment));
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
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEGMENT:
        return basicSetSegment(null, msgs);
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
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEPARATOR:
        return getSeparator();
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEGMENT:
        return getSegment();
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
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEPARATOR:
        setSeparator((String)newValue);
        return;
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEGMENT:
        setSegment((UnindexedReferenceSegment)newValue);
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
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEPARATOR:
        setSeparator(SEPARATOR_EDEFAULT);
        return;
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEGMENT:
        setSegment((UnindexedReferenceSegment)null);
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
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEPARATOR:
        return SEPARATOR_EDEFAULT == null ? separator != null : !SEPARATOR_EDEFAULT.equals(separator);
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL__SEGMENT:
        return segment != null;
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
    result.append(" (separator: ");
    result.append(separator);
    result.append(')');
    return result.toString();
  }

} //UnindexedReferenceTailImpl
