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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorBehaviorTransitionImpl extends MinimalEObjectImpl.Container implements ErrorBehaviorTransition
{
  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected ErrorBehaviorState source;

  /**
   * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDestination()
   * @generated
   * @ordered
   */
  protected ErrorBehaviorState destination;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorBehaviorTransitionImpl()
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
    return ErrorModelPackage.Literals.ERROR_BEHAVIOR_TRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState getSource()
  {
    if (source != null && source.eIsProxy())
    {
      InternalEObject oldSource = (InternalEObject)source;
      source = (ErrorBehaviorState)eResolveProxy(oldSource);
      if (source != oldSource)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__SOURCE, oldSource, source));
      }
    }
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState basicGetSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(ErrorBehaviorState newSource)
  {
    ErrorBehaviorState oldSource = source;
    source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState getDestination()
  {
    if (destination != null && destination.eIsProxy())
    {
      InternalEObject oldDestination = (InternalEObject)destination;
      destination = (ErrorBehaviorState)eResolveProxy(oldDestination);
      if (destination != oldDestination)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__DESTINATION, oldDestination, destination));
      }
    }
    return destination;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState basicGetDestination()
  {
    return destination;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDestination(ErrorBehaviorState newDestination)
  {
    ErrorBehaviorState oldDestination = destination;
    destination = newDestination;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__DESTINATION, oldDestination, destination));
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
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__SOURCE:
        if (resolve) return getSource();
        return basicGetSource();
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__DESTINATION:
        if (resolve) return getDestination();
        return basicGetDestination();
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
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__SOURCE:
        setSource((ErrorBehaviorState)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__DESTINATION:
        setDestination((ErrorBehaviorState)newValue);
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
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__SOURCE:
        setSource((ErrorBehaviorState)null);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__DESTINATION:
        setDestination((ErrorBehaviorState)null);
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
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__SOURCE:
        return source != null;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__DESTINATION:
        return destination != null;
    }
    return super.eIsSet(featureID);
  }

} //ErrorBehaviorTransitionImpl
