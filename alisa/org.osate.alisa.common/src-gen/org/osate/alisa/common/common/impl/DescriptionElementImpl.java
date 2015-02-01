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
import org.osate.alisa.common.common.ShowValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Description Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.DescriptionElementImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.DescriptionElementImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.DescriptionElementImpl#isNewline <em>Newline</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.DescriptionElementImpl#isThisTarget <em>This Target</em>}</li>
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
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected ShowValue value;

  /**
   * The default value of the '{@link #isNewline() <em>Newline</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNewline()
   * @generated
   * @ordered
   */
  protected static final boolean NEWLINE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNewline() <em>Newline</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNewline()
   * @generated
   * @ordered
   */
  protected boolean newline = NEWLINE_EDEFAULT;

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
  public ShowValue getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(ShowValue newValue, NotificationChain msgs)
  {
    ShowValue oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.DESCRIPTION_ELEMENT__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(ShowValue newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.DESCRIPTION_ELEMENT__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.DESCRIPTION_ELEMENT__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DESCRIPTION_ELEMENT__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNewline()
  {
    return newline;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNewline(boolean newNewline)
  {
    boolean oldNewline = newline;
    newline = newNewline;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DESCRIPTION_ELEMENT__NEWLINE, oldNewline, newline));
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
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case CommonPackage.DESCRIPTION_ELEMENT__VALUE:
        return basicSetValue(null, msgs);
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
      case CommonPackage.DESCRIPTION_ELEMENT__VALUE:
        return getValue();
      case CommonPackage.DESCRIPTION_ELEMENT__NEWLINE:
        return isNewline();
      case CommonPackage.DESCRIPTION_ELEMENT__THIS_TARGET:
        return isThisTarget();
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
      case CommonPackage.DESCRIPTION_ELEMENT__VALUE:
        setValue((ShowValue)newValue);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__NEWLINE:
        setNewline((Boolean)newValue);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__THIS_TARGET:
        setThisTarget((Boolean)newValue);
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
      case CommonPackage.DESCRIPTION_ELEMENT__VALUE:
        setValue((ShowValue)null);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__NEWLINE:
        setNewline(NEWLINE_EDEFAULT);
        return;
      case CommonPackage.DESCRIPTION_ELEMENT__THIS_TARGET:
        setThisTarget(THIS_TARGET_EDEFAULT);
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
      case CommonPackage.DESCRIPTION_ELEMENT__VALUE:
        return value != null;
      case CommonPackage.DESCRIPTION_ELEMENT__NEWLINE:
        return newline != NEWLINE_EDEFAULT;
      case CommonPackage.DESCRIPTION_ELEMENT__THIS_TARGET:
        return thisTarget != THIS_TARGET_EDEFAULT;
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
    result.append(", newline: ");
    result.append(newline);
    result.append(", thisTarget: ");
    result.append(thisTarget);
    result.append(')');
    return result.toString();
  }

} //DescriptionElementImpl
