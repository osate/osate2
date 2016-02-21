/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMV2 Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PathImpl#getPaTarget <em>Pa Target</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PathImpl#getErrorType <em>Error Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PathImpl#getEmv2Target <em>Emv2 Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EMV2PathImpl extends MinimalEObjectImpl.Container implements EMV2Path
{
  /**
   * The default value of the '{@link #getPaTarget() <em>Pa Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPaTarget()
   * @generated
   * @ordered
   */
  protected static final String PA_TARGET_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPaTarget() <em>Pa Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPaTarget()
   * @generated
   * @ordered
   */
  protected String paTarget = PA_TARGET_EDEFAULT;

  /**
   * The cached value of the '{@link #getErrorType() <em>Error Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrorType()
   * @generated
   * @ordered
   */
  protected ErrorTypes errorType;

  /**
   * The cached value of the '{@link #getEmv2Target() <em>Emv2 Target</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmv2Target()
   * @generated
   * @ordered
   */
  protected EList<EMV2PathElement> emv2Target;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EMV2PathImpl()
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
    return ErrorModelPackage.Literals.EMV2_PATH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPaTarget()
  {
    return paTarget;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPaTarget(String newPaTarget)
  {
    String oldPaTarget = paTarget;
    paTarget = newPaTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH__PA_TARGET, oldPaTarget, paTarget));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorTypes getErrorType()
  {
    if (errorType != null && errorType.eIsProxy())
    {
      InternalEObject oldErrorType = (InternalEObject)errorType;
      errorType = (ErrorTypes)eResolveProxy(oldErrorType);
      if (errorType != oldErrorType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.EMV2_PATH__ERROR_TYPE, oldErrorType, errorType));
      }
    }
    return errorType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorTypes basicGetErrorType()
  {
    return errorType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setErrorType(ErrorTypes newErrorType)
  {
    ErrorTypes oldErrorType = errorType;
    errorType = newErrorType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH__ERROR_TYPE, oldErrorType, errorType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EMV2PathElement> getEmv2Target()
  {
    if (emv2Target == null)
    {
      emv2Target = new EObjectContainmentEList<EMV2PathElement>(EMV2PathElement.class, this, ErrorModelPackage.EMV2_PATH__EMV2_TARGET);
    }
    return emv2Target;
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
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        return ((InternalEList<?>)getEmv2Target()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.EMV2_PATH__PA_TARGET:
        return getPaTarget();
      case ErrorModelPackage.EMV2_PATH__ERROR_TYPE:
        if (resolve) return getErrorType();
        return basicGetErrorType();
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        return getEmv2Target();
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
      case ErrorModelPackage.EMV2_PATH__PA_TARGET:
        setPaTarget((String)newValue);
        return;
      case ErrorModelPackage.EMV2_PATH__ERROR_TYPE:
        setErrorType((ErrorTypes)newValue);
        return;
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        getEmv2Target().clear();
        getEmv2Target().addAll((Collection<? extends EMV2PathElement>)newValue);
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
      case ErrorModelPackage.EMV2_PATH__PA_TARGET:
        setPaTarget(PA_TARGET_EDEFAULT);
        return;
      case ErrorModelPackage.EMV2_PATH__ERROR_TYPE:
        setErrorType((ErrorTypes)null);
        return;
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        getEmv2Target().clear();
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
      case ErrorModelPackage.EMV2_PATH__PA_TARGET:
        return PA_TARGET_EDEFAULT == null ? paTarget != null : !PA_TARGET_EDEFAULT.equals(paTarget);
      case ErrorModelPackage.EMV2_PATH__ERROR_TYPE:
        return errorType != null;
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        return emv2Target != null && !emv2Target.isEmpty();
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
    result.append(" (paTarget: ");
    result.append(paTarget);
    result.append(')');
    return result.toString();
  }

} //EMV2PathImpl
