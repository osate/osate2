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

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Behavior State Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl#getImportedNamespace <em>Imported Namespace</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorBehaviorStateMachineImpl extends MinimalEObjectImpl.Container implements ErrorBehaviorStateMachine
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
   * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtends()
   * @generated
   * @ordered
   */
  protected ErrorBehaviorStateMachine extends_;

  /**
   * The default value of the '{@link #getImportedNamespace() <em>Imported Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportedNamespace()
   * @generated
   * @ordered
   */
  protected static final String IMPORTED_NAMESPACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImportedNamespace() <em>Imported Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportedNamespace()
   * @generated
   * @ordered
   */
  protected String importedNamespace = IMPORTED_NAMESPACE_EDEFAULT;

  /**
   * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvents()
   * @generated
   * @ordered
   */
  protected EList<ErrorBehaviorEvent> events;

  /**
   * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStates()
   * @generated
   * @ordered
   */
  protected EList<ErrorBehaviorState> states;

  /**
   * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitions()
   * @generated
   * @ordered
   */
  protected EList<ErrorBehaviorTransition> transitions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorBehaviorStateMachineImpl()
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
    return ErrorModelPackage.Literals.ERROR_BEHAVIOR_STATE_MACHINE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorStateMachine getExtends()
  {
    if (extends_ != null && extends_.eIsProxy())
    {
      InternalEObject oldExtends = (InternalEObject)extends_;
      extends_ = (ErrorBehaviorStateMachine)eResolveProxy(oldExtends);
      if (extends_ != oldExtends)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EXTENDS, oldExtends, extends_));
      }
    }
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorStateMachine basicGetExtends()
  {
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtends(ErrorBehaviorStateMachine newExtends)
  {
    ErrorBehaviorStateMachine oldExtends = extends_;
    extends_ = newExtends;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EXTENDS, oldExtends, extends_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getImportedNamespace()
  {
    return importedNamespace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImportedNamespace(String newImportedNamespace)
  {
    String oldImportedNamespace = importedNamespace;
    importedNamespace = newImportedNamespace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__IMPORTED_NAMESPACE, oldImportedNamespace, importedNamespace));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorBehaviorEvent> getEvents()
  {
    if (events == null)
    {
      events = new EObjectContainmentEList<ErrorBehaviorEvent>(ErrorBehaviorEvent.class, this, ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EVENTS);
    }
    return events;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorBehaviorState> getStates()
  {
    if (states == null)
    {
      states = new EObjectContainmentEList<ErrorBehaviorState>(ErrorBehaviorState.class, this, ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__STATES);
    }
    return states;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorBehaviorTransition> getTransitions()
  {
    if (transitions == null)
    {
      transitions = new EObjectContainmentEList<ErrorBehaviorTransition>(ErrorBehaviorTransition.class, this, ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS);
    }
    return transitions;
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EVENTS:
        return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__STATES:
        return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS:
        return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__NAME:
        return getName();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EXTENDS:
        if (resolve) return getExtends();
        return basicGetExtends();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__IMPORTED_NAMESPACE:
        return getImportedNamespace();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EVENTS:
        return getEvents();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__STATES:
        return getStates();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS:
        return getTransitions();
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__NAME:
        setName((String)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EXTENDS:
        setExtends((ErrorBehaviorStateMachine)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__IMPORTED_NAMESPACE:
        setImportedNamespace((String)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EVENTS:
        getEvents().clear();
        getEvents().addAll((Collection<? extends ErrorBehaviorEvent>)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__STATES:
        getStates().clear();
        getStates().addAll((Collection<? extends ErrorBehaviorState>)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS:
        getTransitions().clear();
        getTransitions().addAll((Collection<? extends ErrorBehaviorTransition>)newValue);
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EXTENDS:
        setExtends((ErrorBehaviorStateMachine)null);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__IMPORTED_NAMESPACE:
        setImportedNamespace(IMPORTED_NAMESPACE_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EVENTS:
        getEvents().clear();
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__STATES:
        getStates().clear();
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS:
        getTransitions().clear();
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EXTENDS:
        return extends_ != null;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__IMPORTED_NAMESPACE:
        return IMPORTED_NAMESPACE_EDEFAULT == null ? importedNamespace != null : !IMPORTED_NAMESPACE_EDEFAULT.equals(importedNamespace);
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EVENTS:
        return events != null && !events.isEmpty();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__STATES:
        return states != null && !states.isEmpty();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS:
        return transitions != null && !transitions.isEmpty();
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
    result.append(", importedNamespace: ");
    result.append(importedNamespace);
    result.append(')');
    return result.toString();
  }

} //ErrorBehaviorStateMachineImpl
