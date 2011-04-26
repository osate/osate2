/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.Feature;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationDirection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Propagation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#isMask <em>Mask</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#getAppliesto <em>Appliesto</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorPropagationImpl extends MinimalEObjectImpl.Container implements ErrorPropagation
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected ErrorType type;

  /**
   * The default value of the '{@link #isMask() <em>Mask</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMask()
   * @generated
   * @ordered
   */
  protected static final boolean MASK_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMask() <em>Mask</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMask()
   * @generated
   * @ordered
   */
  protected boolean mask = MASK_EDEFAULT;

  /**
   * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected static final PropagationDirection DIRECTION_EDEFAULT = PropagationDirection.IN;

  /**
   * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected PropagationDirection direction = DIRECTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getBinding() <em>Binding</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBinding()
   * @generated
   * @ordered
   */
  protected EList<String> binding;

  /**
   * The cached value of the '{@link #getAppliesto() <em>Appliesto</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAppliesto()
   * @generated
   * @ordered
   */
  protected EList<Feature> appliesto;

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
  public ErrorType getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (ErrorType)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_PROPAGATION__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorType basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(ErrorType newType)
  {
    ErrorType oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMask()
  {
    return mask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMask(boolean newMask)
  {
    boolean oldMask = mask;
    mask = newMask;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__MASK, oldMask, mask));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropagationDirection getDirection()
  {
    return direction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDirection(PropagationDirection newDirection)
  {
    PropagationDirection oldDirection = direction;
    direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__DIRECTION, oldDirection, direction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getBinding()
  {
    if (binding == null)
    {
      binding = new EDataTypeEList<String>(String.class, this, ErrorModelPackage.ERROR_PROPAGATION__BINDING);
    }
    return binding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature> getAppliesto()
  {
    if (appliesto == null)
    {
      appliesto = new EObjectResolvingEList<Feature>(Feature.class, this, ErrorModelPackage.ERROR_PROPAGATION__APPLIESTO);
    }
    return appliesto;
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
      case ErrorModelPackage.ERROR_PROPAGATION__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case ErrorModelPackage.ERROR_PROPAGATION__MASK:
        return isMask();
      case ErrorModelPackage.ERROR_PROPAGATION__DIRECTION:
        return getDirection();
      case ErrorModelPackage.ERROR_PROPAGATION__BINDING:
        return getBinding();
      case ErrorModelPackage.ERROR_PROPAGATION__APPLIESTO:
        return getAppliesto();
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
      case ErrorModelPackage.ERROR_PROPAGATION__TYPE:
        setType((ErrorType)newValue);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__MASK:
        setMask((Boolean)newValue);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__DIRECTION:
        setDirection((PropagationDirection)newValue);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__BINDING:
        getBinding().clear();
        getBinding().addAll((Collection<? extends String>)newValue);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__APPLIESTO:
        getAppliesto().clear();
        getAppliesto().addAll((Collection<? extends Feature>)newValue);
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
      case ErrorModelPackage.ERROR_PROPAGATION__TYPE:
        setType((ErrorType)null);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__MASK:
        setMask(MASK_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__DIRECTION:
        setDirection(DIRECTION_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__BINDING:
        getBinding().clear();
        return;
      case ErrorModelPackage.ERROR_PROPAGATION__APPLIESTO:
        getAppliesto().clear();
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
      case ErrorModelPackage.ERROR_PROPAGATION__TYPE:
        return type != null;
      case ErrorModelPackage.ERROR_PROPAGATION__MASK:
        return mask != MASK_EDEFAULT;
      case ErrorModelPackage.ERROR_PROPAGATION__DIRECTION:
        return direction != DIRECTION_EDEFAULT;
      case ErrorModelPackage.ERROR_PROPAGATION__BINDING:
        return binding != null && !binding.isEmpty();
      case ErrorModelPackage.ERROR_PROPAGATION__APPLIESTO:
        return appliesto != null && !appliesto.isEmpty();
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
    result.append(" (mask: ");
    result.append(mask);
    result.append(", direction: ");
    result.append(direction);
    result.append(", binding: ");
    result.append(binding);
    result.append(')');
    return result.toString();
  }

} //ErrorPropagationImpl
