/**
 */
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.ImageReference;
import org.osate.alisa.common.common.ShowValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Description Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.DescriptionElementImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.DescriptionElementImpl#getShowValue <em>Show Value</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.DescriptionElementImpl#isThisTarget <em>This Target</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.DescriptionElementImpl#getImage <em>Image</em>}</li>
 * </ul>
 * </p>
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
   * The cached value of the '{@link #getShowValue() <em>Show Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShowValue()
   * @generated
   * @ordered
   */
  protected ShowValue showValue;

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
  public String getText()
  {
    return text;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
  public ShowValue getShowValue()
  {
    return showValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetShowValue(ShowValue newShowValue, NotificationChain msgs)
  {
    ShowValue oldShowValue = showValue;
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
  public void setShowValue(ShowValue newShowValue)
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
  public boolean isThisTarget()
  {
    return thisTarget;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE:
        return basicSetShowValue(null, msgs);
      case CommonPackage.DESCRIPTION_ELEMENT__IMAGE:
        return basicSetImage(null, msgs);
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
      case CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE:
        return getShowValue();
      case CommonPackage.DESCRIPTION_ELEMENT__THIS_TARGET:
        return isThisTarget();
      case CommonPackage.DESCRIPTION_ELEMENT__IMAGE:
        return getImage();
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
      case CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE:
        setShowValue((ShowValue)newValue);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__THIS_TARGET:
        setThisTarget((Boolean)newValue);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__IMAGE:
        setImage((ImageReference)newValue);
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
      case CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE:
        setShowValue((ShowValue)null);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__THIS_TARGET:
        setThisTarget(THIS_TARGET_EDEFAULT);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__IMAGE:
        setImage((ImageReference)null);
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
      case CommonPackage.DESCRIPTION_ELEMENT__SHOW_VALUE:
        return showValue != null;
      case CommonPackage.DESCRIPTION_ELEMENT__THIS_TARGET:
        return thisTarget != THIS_TARGET_EDEFAULT;
      case CommonPackage.DESCRIPTION_ELEMENT__IMAGE:
        return image != null;
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (text: ");
    result.append(text);
    result.append(", thisTarget: ");
    result.append(thisTarget);
    result.append(')');
    return result.toString();
  }

} //DescriptionElementImpl
