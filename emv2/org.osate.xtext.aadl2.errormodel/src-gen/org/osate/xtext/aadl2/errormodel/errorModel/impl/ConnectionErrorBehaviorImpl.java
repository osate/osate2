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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Error Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ConnectionErrorBehaviorImpl#getTypeTransformationSet <em>Type Transformation Set</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ConnectionErrorBehaviorImpl#getConnectionErrorSources <em>Connection Error Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionErrorBehaviorImpl extends ElementImpl implements ConnectionErrorBehavior
{
  /**
   * The cached value of the '{@link #getTypeTransformationSet() <em>Type Transformation Set</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeTransformationSet()
   * @generated
   * @ordered
   */
  protected TypeTransformationSet typeTransformationSet;

  /**
   * The cached value of the '{@link #getConnectionErrorSources() <em>Connection Error Sources</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnectionErrorSources()
   * @generated
   * @ordered
   */
  protected EList<ConnectionErrorSource> connectionErrorSources;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConnectionErrorBehaviorImpl()
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
    return ErrorModelPackage.Literals.CONNECTION_ERROR_BEHAVIOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeTransformationSet getTypeTransformationSet()
  {
    if (typeTransformationSet != null && typeTransformationSet.eIsProxy())
    {
      InternalEObject oldTypeTransformationSet = (InternalEObject)typeTransformationSet;
      typeTransformationSet = (TypeTransformationSet)eResolveProxy(oldTypeTransformationSet);
      if (typeTransformationSet != oldTypeTransformationSet)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.CONNECTION_ERROR_BEHAVIOR__TYPE_TRANSFORMATION_SET, oldTypeTransformationSet, typeTransformationSet));
      }
    }
    return typeTransformationSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeTransformationSet basicGetTypeTransformationSet()
  {
    return typeTransformationSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeTransformationSet(TypeTransformationSet newTypeTransformationSet)
  {
    TypeTransformationSet oldTypeTransformationSet = typeTransformationSet;
    typeTransformationSet = newTypeTransformationSet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.CONNECTION_ERROR_BEHAVIOR__TYPE_TRANSFORMATION_SET, oldTypeTransformationSet, typeTransformationSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConnectionErrorSource> getConnectionErrorSources()
  {
    if (connectionErrorSources == null)
    {
      connectionErrorSources = new EObjectContainmentEList<ConnectionErrorSource>(ConnectionErrorSource.class, this, ErrorModelPackage.CONNECTION_ERROR_BEHAVIOR__CONNECTION_ERROR_SOURCES);
    }
    return connectionErrorSources;
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
      case ErrorModelPackage.CONNECTION_ERROR_BEHAVIOR__CONNECTION_ERROR_SOURCES:
        return ((InternalEList<?>)getConnectionErrorSources()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.CONNECTION_ERROR_BEHAVIOR__TYPE_TRANSFORMATION_SET:
        if (resolve) return getTypeTransformationSet();
        return basicGetTypeTransformationSet();
      case ErrorModelPackage.CONNECTION_ERROR_BEHAVIOR__CONNECTION_ERROR_SOURCES:
        return getConnectionErrorSources();
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
      case ErrorModelPackage.CONNECTION_ERROR_BEHAVIOR__TYPE_TRANSFORMATION_SET:
        setTypeTransformationSet((TypeTransformationSet)newValue);
        return;
      case ErrorModelPackage.CONNECTION_ERROR_BEHAVIOR__CONNECTION_ERROR_SOURCES:
        getConnectionErrorSources().clear();
        getConnectionErrorSources().addAll((Collection<? extends ConnectionErrorSource>)newValue);
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
      case ErrorModelPackage.CONNECTION_ERROR_BEHAVIOR__TYPE_TRANSFORMATION_SET:
        setTypeTransformationSet((TypeTransformationSet)null);
        return;
      case ErrorModelPackage.CONNECTION_ERROR_BEHAVIOR__CONNECTION_ERROR_SOURCES:
        getConnectionErrorSources().clear();
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
      case ErrorModelPackage.CONNECTION_ERROR_BEHAVIOR__TYPE_TRANSFORMATION_SET:
        return typeTransformationSet != null;
      case ErrorModelPackage.CONNECTION_ERROR_BEHAVIOR__CONNECTION_ERROR_SOURCES:
        return connectionErrorSources != null && !connectionErrorSources.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ConnectionErrorBehaviorImpl
