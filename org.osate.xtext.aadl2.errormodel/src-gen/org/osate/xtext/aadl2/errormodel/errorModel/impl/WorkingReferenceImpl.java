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
import org.osate.xtext.aadl2.errormodel.errorModel.Feature;
import org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Working Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.WorkingReferenceImpl#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.WorkingReferenceImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.WorkingReferenceImpl#isSelf <em>Self</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.WorkingReferenceImpl#isWorking <em>Working</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkingReferenceImpl extends TriggerConditionExpressionImpl implements WorkingReference
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
   * The default value of the '{@link #isWorking() <em>Working</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWorking()
   * @generated
   * @ordered
   */
  protected static final boolean WORKING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWorking() <em>Working</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWorking()
   * @generated
   * @ordered
   */
  protected boolean working = WORKING_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WorkingReferenceImpl()
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
    return ErrorModelPackage.Literals.WORKING_REFERENCE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.WORKING_REFERENCE__BINDING, oldBinding, binding));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.WORKING_REFERENCE__FEATURE, oldFeature, feature));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.WORKING_REFERENCE__FEATURE, oldFeature, feature));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.WORKING_REFERENCE__SELF, oldSelf, self));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isWorking()
  {
    return working;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWorking(boolean newWorking)
  {
    boolean oldWorking = working;
    working = newWorking;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.WORKING_REFERENCE__WORKING, oldWorking, working));
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
      case ErrorModelPackage.WORKING_REFERENCE__BINDING:
        return getBinding();
      case ErrorModelPackage.WORKING_REFERENCE__FEATURE:
        if (resolve) return getFeature();
        return basicGetFeature();
      case ErrorModelPackage.WORKING_REFERENCE__SELF:
        return isSelf();
      case ErrorModelPackage.WORKING_REFERENCE__WORKING:
        return isWorking();
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
      case ErrorModelPackage.WORKING_REFERENCE__BINDING:
        setBinding((String)newValue);
        return;
      case ErrorModelPackage.WORKING_REFERENCE__FEATURE:
        setFeature((Feature)newValue);
        return;
      case ErrorModelPackage.WORKING_REFERENCE__SELF:
        setSelf((Boolean)newValue);
        return;
      case ErrorModelPackage.WORKING_REFERENCE__WORKING:
        setWorking((Boolean)newValue);
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
      case ErrorModelPackage.WORKING_REFERENCE__BINDING:
        setBinding(BINDING_EDEFAULT);
        return;
      case ErrorModelPackage.WORKING_REFERENCE__FEATURE:
        setFeature((Feature)null);
        return;
      case ErrorModelPackage.WORKING_REFERENCE__SELF:
        setSelf(SELF_EDEFAULT);
        return;
      case ErrorModelPackage.WORKING_REFERENCE__WORKING:
        setWorking(WORKING_EDEFAULT);
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
      case ErrorModelPackage.WORKING_REFERENCE__BINDING:
        return BINDING_EDEFAULT == null ? binding != null : !BINDING_EDEFAULT.equals(binding);
      case ErrorModelPackage.WORKING_REFERENCE__FEATURE:
        return feature != null;
      case ErrorModelPackage.WORKING_REFERENCE__SELF:
        return self != SELF_EDEFAULT;
      case ErrorModelPackage.WORKING_REFERENCE__WORKING:
        return working != WORKING_EDEFAULT;
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
    result.append(", working: ");
    result.append(working);
    result.append(')');
    return result.toString();
  }

} //WorkingReferenceImpl
