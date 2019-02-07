/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TypeTokenImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TypeTokenImpl#isNoError <em>No Error</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeTokenImpl extends ElementImpl implements TypeToken
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EList<ErrorTypes> type;

  /**
   * The default value of the '{@link #isNoError() <em>No Error</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNoError()
   * @generated
   * @ordered
   */
  protected static final boolean NO_ERROR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNoError() <em>No Error</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNoError()
   * @generated
   * @ordered
   */
  protected boolean noError = NO_ERROR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeTokenImpl()
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
    return ErrorModelPackage.Literals.TYPE_TOKEN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorTypes> getType()
  {
    if (type == null)
    {
      type = new EObjectResolvingEList<ErrorTypes>(ErrorTypes.class, this, ErrorModelPackage.TYPE_TOKEN__TYPE);
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNoError()
  {
    return noError;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNoError(boolean newNoError)
  {
    boolean oldNoError = noError;
    noError = newNoError;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TYPE_TOKEN__NO_ERROR, oldNoError, noError));
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
      case ErrorModelPackage.TYPE_TOKEN__TYPE:
        return getType();
      case ErrorModelPackage.TYPE_TOKEN__NO_ERROR:
        return isNoError();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ErrorModelPackage.TYPE_TOKEN__TYPE:
        getType().clear();
        getType().addAll((Collection<? extends ErrorTypes>)newValue);
        return;
      case ErrorModelPackage.TYPE_TOKEN__NO_ERROR:
        setNoError((Boolean)newValue);
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
      case ErrorModelPackage.TYPE_TOKEN__TYPE:
        getType().clear();
        return;
      case ErrorModelPackage.TYPE_TOKEN__NO_ERROR:
        setNoError(NO_ERROR_EDEFAULT);
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
      case ErrorModelPackage.TYPE_TOKEN__TYPE:
        return type != null && !type.isEmpty();
      case ErrorModelPackage.TYPE_TOKEN__NO_ERROR:
        return noError != NO_ERROR_EDEFAULT;
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
    result.append(" (noError: ");
    result.append(noError);
    result.append(')');
    return result.toString();
  }

} //TypeTokenImpl
