/**
 */
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.TextElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.TextElementImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.TextElementImpl#isNewline <em>Newline</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextElementImpl extends MinimalEObjectImpl.Container implements TextElement
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TextElementImpl()
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
    return CommonPackage.Literals.TEXT_ELEMENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.TEXT_ELEMENT__TEXT, oldText, text));
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
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.TEXT_ELEMENT__NEWLINE, oldNewline, newline));
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
      case CommonPackage.TEXT_ELEMENT__TEXT:
        return getText();
      case CommonPackage.TEXT_ELEMENT__NEWLINE:
        return isNewline();
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
      case CommonPackage.TEXT_ELEMENT__TEXT:
        setText((String)newValue);
        return;
      case CommonPackage.TEXT_ELEMENT__NEWLINE:
        setNewline((Boolean)newValue);
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
      case CommonPackage.TEXT_ELEMENT__TEXT:
        setText(TEXT_EDEFAULT);
        return;
      case CommonPackage.TEXT_ELEMENT__NEWLINE:
        setNewline(NEWLINE_EDEFAULT);
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
      case CommonPackage.TEXT_ELEMENT__TEXT:
        return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
      case CommonPackage.TEXT_ELEMENT__NEWLINE:
        return newline != NEWLINE_EDEFAULT;
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
    result.append(')');
    return result.toString();
  }

} //TextElementImpl
