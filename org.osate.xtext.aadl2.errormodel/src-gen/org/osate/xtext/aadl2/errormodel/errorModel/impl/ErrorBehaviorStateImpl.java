/**
 * <copyright>
 * </copyright>
 *

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

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.PropertyAssociation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Behavior State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateImpl#isIntial <em>Intial</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorBehaviorStateImpl extends MinimalEObjectImpl.Container implements ErrorBehaviorState
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #isIntial() <em>Intial</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIntial()
   * @generated
   * @ordered
   */
  protected static final boolean INTIAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIntial() <em>Intial</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIntial()
   * @generated
   * @ordered
   */
  protected boolean intial = INTIAL_EDEFAULT;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<PropertyAssociation> properties;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorBehaviorStateImpl()
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
    return ErrorModelPackage.Literals.ERROR_BEHAVIOR_STATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_STATE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIntial()
  {
    return intial;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntial(boolean newIntial)
  {
    boolean oldIntial = intial;
    intial = newIntial;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_STATE__INTIAL, oldIntial, intial));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PropertyAssociation> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<PropertyAssociation>(PropertyAssociation.class, this, ErrorModelPackage.ERROR_BEHAVIOR_STATE__PROPERTIES);
    }
    return properties;
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE__NAME:
        return getName();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE__INTIAL:
        return isIntial();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE__PROPERTIES:
        return getProperties();
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE__NAME:
        setName((String)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE__INTIAL:
        setIntial((Boolean)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends PropertyAssociation>)newValue);
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE__INTIAL:
        setIntial(INTIAL_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE__PROPERTIES:
        getProperties().clear();
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE__INTIAL:
        return intial != INTIAL_EDEFAULT;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE__PROPERTIES:
        return properties != null && !properties.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(", intial: ");
    result.append(intial);
    result.append(')');
    return result.toString();
  }

} //ErrorBehaviorStateImpl
