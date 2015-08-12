/**
 */
package org.osate.verify.verify.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.verify.verify.ManualMethod;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manual Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.ManualMethodImpl#getDialogID <em>Dialog ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ManualMethodImpl extends MethodTypeImpl implements ManualMethod
{
  /**
   * The default value of the '{@link #getDialogID() <em>Dialog ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDialogID()
   * @generated
   * @ordered
   */
  protected static final String DIALOG_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDialogID() <em>Dialog ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDialogID()
   * @generated
   * @ordered
   */
  protected String dialogID = DIALOG_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ManualMethodImpl()
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
    return VerifyPackage.Literals.MANUAL_METHOD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDialogID()
  {
    return dialogID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDialogID(String newDialogID)
  {
    String oldDialogID = dialogID;
    dialogID = newDialogID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.MANUAL_METHOD__DIALOG_ID, oldDialogID, dialogID));
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
      case VerifyPackage.MANUAL_METHOD__DIALOG_ID:
        return getDialogID();
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
      case VerifyPackage.MANUAL_METHOD__DIALOG_ID:
        setDialogID((String)newValue);
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
      case VerifyPackage.MANUAL_METHOD__DIALOG_ID:
        setDialogID(DIALOG_ID_EDEFAULT);
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
      case VerifyPackage.MANUAL_METHOD__DIALOG_ID:
        return DIALOG_ID_EDEFAULT == null ? dialogID != null : !DIALOG_ID_EDEFAULT.equals(dialogID);
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
    result.append(" (dialogID: ");
    result.append(dialogID);
    result.append(')');
    return result.toString();
  }

} //ManualMethodImpl
