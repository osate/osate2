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

import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Error Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl#getImportedNamespace <em>Imported Namespace</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl#getTransitionCondition <em>Transition Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl#getPropagationCondition <em>Propagation Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl#getDetectionEvent <em>Detection Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentErrorBehaviorImpl extends MinimalEObjectImpl.Container implements ComponentErrorBehavior
{
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
   * The cached value of the '{@link #getTransitionCondition() <em>Transition Condition</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitionCondition()
   * @generated
   * @ordered
   */
  protected EList<TransitionCondition> transitionCondition;

  /**
   * The cached value of the '{@link #getPropagationCondition() <em>Propagation Condition</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropagationCondition()
   * @generated
   * @ordered
   */
  protected EList<PropagationCondition> propagationCondition;

  /**
   * The cached value of the '{@link #getDetectionEvent() <em>Detection Event</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDetectionEvent()
   * @generated
   * @ordered
   */
  protected EList<DetectionEvent> detectionEvent;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComponentErrorBehaviorImpl()
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
    return ErrorModelPackage.Literals.COMPONENT_ERROR_BEHAVIOR;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__IMPORTED_NAMESPACE, oldImportedNamespace, importedNamespace));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TransitionCondition> getTransitionCondition()
  {
    if (transitionCondition == null)
    {
      transitionCondition = new EObjectContainmentEList<TransitionCondition>(TransitionCondition.class, this, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__TRANSITION_CONDITION);
    }
    return transitionCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PropagationCondition> getPropagationCondition()
  {
    if (propagationCondition == null)
    {
      propagationCondition = new EObjectContainmentEList<PropagationCondition>(PropagationCondition.class, this, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__PROPAGATION_CONDITION);
    }
    return propagationCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DetectionEvent> getDetectionEvent()
  {
    if (detectionEvent == null)
    {
      detectionEvent = new EObjectContainmentEList<DetectionEvent>(DetectionEvent.class, this, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__DETECTION_EVENT);
    }
    return detectionEvent;
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
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__TRANSITION_CONDITION:
        return ((InternalEList<?>)getTransitionCondition()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__PROPAGATION_CONDITION:
        return ((InternalEList<?>)getPropagationCondition()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__DETECTION_EVENT:
        return ((InternalEList<?>)getDetectionEvent()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__IMPORTED_NAMESPACE:
        return getImportedNamespace();
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__TRANSITION_CONDITION:
        return getTransitionCondition();
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__PROPAGATION_CONDITION:
        return getPropagationCondition();
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__DETECTION_EVENT:
        return getDetectionEvent();
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
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__IMPORTED_NAMESPACE:
        setImportedNamespace((String)newValue);
        return;
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__TRANSITION_CONDITION:
        getTransitionCondition().clear();
        getTransitionCondition().addAll((Collection<? extends TransitionCondition>)newValue);
        return;
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__PROPAGATION_CONDITION:
        getPropagationCondition().clear();
        getPropagationCondition().addAll((Collection<? extends PropagationCondition>)newValue);
        return;
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__DETECTION_EVENT:
        getDetectionEvent().clear();
        getDetectionEvent().addAll((Collection<? extends DetectionEvent>)newValue);
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
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__IMPORTED_NAMESPACE:
        setImportedNamespace(IMPORTED_NAMESPACE_EDEFAULT);
        return;
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__TRANSITION_CONDITION:
        getTransitionCondition().clear();
        return;
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__PROPAGATION_CONDITION:
        getPropagationCondition().clear();
        return;
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__DETECTION_EVENT:
        getDetectionEvent().clear();
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
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__IMPORTED_NAMESPACE:
        return IMPORTED_NAMESPACE_EDEFAULT == null ? importedNamespace != null : !IMPORTED_NAMESPACE_EDEFAULT.equals(importedNamespace);
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__TRANSITION_CONDITION:
        return transitionCondition != null && !transitionCondition.isEmpty();
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__PROPAGATION_CONDITION:
        return propagationCondition != null && !propagationCondition.isEmpty();
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__DETECTION_EVENT:
        return detectionEvent != null && !detectionEvent.isEmpty();
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
    result.append(" (importedNamespace: ");
    result.append(importedNamespace);
    result.append(')');
    return result.toString();
  }

} //ComponentErrorBehaviorImpl
