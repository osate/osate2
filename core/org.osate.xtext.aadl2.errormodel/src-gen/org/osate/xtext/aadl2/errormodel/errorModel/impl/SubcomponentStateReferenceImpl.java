/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.Feature;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subcomponent State Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.SubcomponentStateReferenceImpl#getSubcomponent <em>Subcomponent</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.SubcomponentStateReferenceImpl#getErrortype <em>Errortype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubcomponentStateReferenceImpl extends StateConditionExpressionImpl implements SubcomponentStateReference
{
  /**
   * The cached value of the '{@link #getSubcomponent() <em>Subcomponent</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubcomponent()
   * @generated
   * @ordered
   */
  protected Feature subcomponent;

  /**
   * The cached value of the '{@link #getErrortype() <em>Errortype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrortype()
   * @generated
   * @ordered
   */
  protected ErrorBehaviorState errortype;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SubcomponentStateReferenceImpl()
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
    return ErrorModelPackage.Literals.SUBCOMPONENT_STATE_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature getSubcomponent()
  {
    if (subcomponent != null && subcomponent.eIsProxy())
    {
      InternalEObject oldSubcomponent = (InternalEObject)subcomponent;
      subcomponent = (Feature)eResolveProxy(oldSubcomponent);
      if (subcomponent != oldSubcomponent)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE__SUBCOMPONENT, oldSubcomponent, subcomponent));
      }
    }
    return subcomponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature basicGetSubcomponent()
  {
    return subcomponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubcomponent(Feature newSubcomponent)
  {
    Feature oldSubcomponent = subcomponent;
    subcomponent = newSubcomponent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE__SUBCOMPONENT, oldSubcomponent, subcomponent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState getErrortype()
  {
    if (errortype != null && errortype.eIsProxy())
    {
      InternalEObject oldErrortype = (InternalEObject)errortype;
      errortype = (ErrorBehaviorState)eResolveProxy(oldErrortype);
      if (errortype != oldErrortype)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE__ERRORTYPE, oldErrortype, errortype));
      }
    }
    return errortype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState basicGetErrortype()
  {
    return errortype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setErrortype(ErrorBehaviorState newErrortype)
  {
    ErrorBehaviorState oldErrortype = errortype;
    errortype = newErrortype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE__ERRORTYPE, oldErrortype, errortype));
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
      case ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE__SUBCOMPONENT:
        if (resolve) return getSubcomponent();
        return basicGetSubcomponent();
      case ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE__ERRORTYPE:
        if (resolve) return getErrortype();
        return basicGetErrortype();
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
      case ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE__SUBCOMPONENT:
        setSubcomponent((Feature)newValue);
        return;
      case ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE__ERRORTYPE:
        setErrortype((ErrorBehaviorState)newValue);
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
      case ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE__SUBCOMPONENT:
        setSubcomponent((Feature)null);
        return;
      case ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE__ERRORTYPE:
        setErrortype((ErrorBehaviorState)null);
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
      case ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE__SUBCOMPONENT:
        return subcomponent != null;
      case ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE__ERRORTYPE:
        return errortype != null;
    }
    return super.eIsSet(featureID);
  }

} //SubcomponentStateReferenceImpl
