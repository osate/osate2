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
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.alisa.common.common.AUnitExpression;
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.ImageReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Description Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.DescriptionElementImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.DescriptionElementImpl#isThisTarget <em>This Target</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.DescriptionElementImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.DescriptionElementImpl#getShowValue <em>Show Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DescriptionElementImpl extends MinimalEObjectImpl.Container implements DescriptionElement
{
  /**
   * The default value of the '{@link #getText() <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getText()
   * @generated
   * @ordered
   */
  protected static final String TEXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getText()
   * @generated
   * @ordered
   */
  protected String text = TEXT_EDEFAULT;

  /**
   * The default value of the '{@link #isThisTarget() <em>This Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isThisTarget()
   * @generated
   * @ordered
   */
  protected static final boolean THIS_TARGET_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isThisTarget() <em>This Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isThisTarget()
   * @generated
   * @ordered
   */
  protected boolean thisTarget = THIS_TARGET_EDEFAULT;

  /**
   * The cached value of the '{@link #getImage() <em>Image</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImage()
   * @generated
   * @ordered
   */
  protected ImageReference image;

  /**
   * The cached value of the '{@link #getShowValue() <em>Show Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShowValue()
   * @generated
   * @ordered
   */
  protected AUnitExpression showValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DescriptionElementImpl()
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
    return CommonPackage.Literals.DESCRIPTION_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText()
  {
    return text;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setText(String newText)
  {
    String oldText = text;
    text = newText;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DESCRIPTION_ELEMENT__TEXT, oldText, text));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isThisTarget()
  {
    return thisTarget;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setThisTarget(boolean newThisTarget)
  {
    boolean oldThisTarget = thisTarget;
    thisTarget = newThisTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DESCRIPTION_ELEMENT__THIS_TARGET, oldThisTarget, thisTarget));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImageReference getImage()
  {
    return image;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetImage(ImageReference newImage, NotificationChain msgs)
  {
    ImageReference oldImage = image;
    image = newImage;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.DESCRIPTION_ELEMENT__IMAGE, oldImage, newImage);
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
  public void setImage(ImageReference newImage)
  {
    if (newImage != image)
    {
      NotificationChain msgs = null;
      if (image != null)
        msgs = ((InternalEObject)image).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.DESCRIPTION_ELEMENT__IMAGE, null, msgs);
      if (newImage != null)
        msgs = ((InternalEObject)newImage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.DESCRIPTION_ELEMENT__IMAGE, null, msgs);
      msgs = basicSetImage(newImage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DESCRIPTION_ELEMENT__IMAGE, newImage, newImage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AUnitExpression getShowValue()
  {
    return showValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetShowValue(AUnitExpression newShowValue, NotificationChain msgs)
  {
    AUnitExpression oldShowValue = showValue;
    showValue = newShowValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE, oldShowValue, newShowValue);
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
  public void setShowValue(AUnitExpression newShowValue)
  {
    if (newShowValue != showValue)
    {
      NotificationChain msgs = null;
      if (showValue != null)
        msgs = ((InternalEObject)showValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE, null, msgs);
      if (newShowValue != null)
        msgs = ((InternalEObject)newShowValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE, null, msgs);
      msgs = basicSetShowValue(newShowValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE, newShowValue, newShowValue));
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
      case CommonPackage.DESCRIPTION_ELEMENT__IMAGE:
        return basicSetImage(null, msgs);
      case CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE:
        return basicSetShowValue(null, msgs);
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
      case CommonPackage.DESCRIPTION_ELEMENT__TEXT:
        return getText();
      case CommonPackage.DESCRIPTION_ELEMENT__THIS_TARGET:
        return isThisTarget();
      case CommonPackage.DESCRIPTION_ELEMENT__IMAGE:
        return getImage();
      case CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE:
        return getShowValue();
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
      case CommonPackage.DESCRIPTION_ELEMENT__TEXT:
        setText((String)newValue);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__THIS_TARGET:
        setThisTarget((Boolean)newValue);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__IMAGE:
        setImage((ImageReference)newValue);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE:
        setShowValue((AUnitExpression)newValue);
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
      case CommonPackage.DESCRIPTION_ELEMENT__TEXT:
        setText(TEXT_EDEFAULT);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__THIS_TARGET:
        setThisTarget(THIS_TARGET_EDEFAULT);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__IMAGE:
        setImage((ImageReference)null);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE:
        setShowValue((AUnitExpression)null);
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
      case CommonPackage.DESCRIPTION_ELEMENT__TEXT:
        return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
      case CommonPackage.DESCRIPTION_ELEMENT__THIS_TARGET:
        return thisTarget != THIS_TARGET_EDEFAULT;
      case CommonPackage.DESCRIPTION_ELEMENT__IMAGE:
        return image != null;
      case CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE:
        return showValue != null;
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
    result.append(" (text: ");
    result.append(text);
    result.append(", thisTarget: ");
    result.append(thisTarget);
    result.append(')');
    return result.toString();
  }

} //DescriptionElementImpl
