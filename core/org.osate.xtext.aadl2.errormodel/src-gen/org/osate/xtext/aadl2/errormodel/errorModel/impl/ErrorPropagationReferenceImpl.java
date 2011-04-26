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

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Propagation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationReferenceImpl#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationReferenceImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationReferenceImpl#isSelf <em>Self</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationReferenceImpl#getErrortype <em>Errortype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorPropagationReferenceImpl extends TriggerConditionExpressionImpl implements ErrorPropagationReference
{
  /**
   * The default value of the '{@link #getBinding() <em>Binding</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBinding()
   * @generated
   * @ordered
   */
  protected static final String BINDING_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBinding() <em>Binding</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBinding()
   * @generated
   * @ordered
   */
  protected String binding = BINDING_EDEFAULT;

  /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature()
   * @generated
   * @ordered
   */
  protected Feature feature;

  /**
   * The default value of the '{@link #isSelf() <em>Self</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSelf()
   * @generated
   * @ordered
   */
  protected static final boolean SELF_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSelf() <em>Self</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSelf()
   * @generated
   * @ordered
   */
  protected boolean self = SELF_EDEFAULT;

  /**
   * The cached value of the '{@link #getErrortype() <em>Errortype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrortype()
   * @generated
   * @ordered
   */
  protected ErrorType errortype;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorPropagationReferenceImpl()
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
    return ErrorModelPackage.Literals.ERROR_PROPAGATION_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBinding()
  {
    return binding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBinding(String newBinding)
  {
    String oldBinding = binding;
    binding = newBinding;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__BINDING, oldBinding, binding));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature getFeature()
  {
    if (feature != null && feature.eIsProxy())
    {
      InternalEObject oldFeature = (InternalEObject)feature;
      feature = (Feature)eResolveProxy(oldFeature);
      if (feature != oldFeature)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__FEATURE, oldFeature, feature));
      }
    }
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature basicGetFeature()
  {
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeature(Feature newFeature)
  {
    Feature oldFeature = feature;
    feature = newFeature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__FEATURE, oldFeature, feature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSelf()
  {
    return self;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelf(boolean newSelf)
  {
    boolean oldSelf = self;
    self = newSelf;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__SELF, oldSelf, self));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorType getErrortype()
  {
    if (errortype != null && errortype.eIsProxy())
    {
      InternalEObject oldErrortype = (InternalEObject)errortype;
      errortype = (ErrorType)eResolveProxy(oldErrortype);
      if (errortype != oldErrortype)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__ERRORTYPE, oldErrortype, errortype));
      }
    }
    return errortype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorType basicGetErrortype()
  {
    return errortype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setErrortype(ErrorType newErrortype)
  {
    ErrorType oldErrortype = errortype;
    errortype = newErrortype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__ERRORTYPE, oldErrortype, errortype));
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
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__BINDING:
        return getBinding();
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__FEATURE:
        if (resolve) return getFeature();
        return basicGetFeature();
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__SELF:
        return isSelf();
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__ERRORTYPE:
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
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__BINDING:
        setBinding((String)newValue);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__FEATURE:
        setFeature((Feature)newValue);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__SELF:
        setSelf((Boolean)newValue);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__ERRORTYPE:
        setErrortype((ErrorType)newValue);
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
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__BINDING:
        setBinding(BINDING_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__FEATURE:
        setFeature((Feature)null);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__SELF:
        setSelf(SELF_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__ERRORTYPE:
        setErrortype((ErrorType)null);
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
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__BINDING:
        return BINDING_EDEFAULT == null ? binding != null : !BINDING_EDEFAULT.equals(binding);
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__FEATURE:
        return feature != null;
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__SELF:
        return self != SELF_EDEFAULT;
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE__ERRORTYPE:
        return errortype != null;
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
    result.append(" (binding: ");
    result.append(binding);
    result.append(", self: ");
    result.append(self);
    result.append(')');
    return result.toString();
  }

} //ErrorPropagationReferenceImpl
