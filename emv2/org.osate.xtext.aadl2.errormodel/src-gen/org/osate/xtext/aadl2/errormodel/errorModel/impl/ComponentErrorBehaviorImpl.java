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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.PropertyAssociation;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Error Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl#getUseTypes <em>Use Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl#getUseBehavior <em>Use Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl#getUseTransformation <em>Use Transformation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl#getOutgoingPropagationConditions <em>Outgoing Propagation Conditions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl#getErrorDetections <em>Error Detections</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl#getErrorStateToModeMappings <em>Error State To Mode Mappings</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentErrorBehaviorImpl extends ElementImpl implements ComponentErrorBehavior
{
  /**
	 * The cached value of the '{@link #getUseTypes() <em>Use Types</em>}' reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUseTypes()
	 * @generated
	 * @ordered
	 */
  protected EList<ErrorModelLibrary> useTypes;

  /**
	 * The cached value of the '{@link #getUseBehavior() <em>Use Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUseBehavior()
	 * @generated
	 * @ordered
	 */
  protected ErrorBehaviorStateMachine useBehavior;

  /**
	 * The cached value of the '{@link #getUseTransformation() <em>Use Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUseTransformation()
	 * @generated
	 * @ordered
	 */
  protected TypeTransformationSet useTransformation;

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
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
  protected EList<ErrorBehaviorTransition> transitions;

  /**
	 * The cached value of the '{@link #getOutgoingPropagationConditions() <em>Outgoing Propagation Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOutgoingPropagationConditions()
	 * @generated
	 * @ordered
	 */
  protected EList<OutgoingPropagationCondition> outgoingPropagationConditions;

  /**
	 * The cached value of the '{@link #getErrorDetections() <em>Error Detections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getErrorDetections()
	 * @generated
	 * @ordered
	 */
  protected EList<ErrorDetection> errorDetections;

  /**
	 * The cached value of the '{@link #getErrorStateToModeMappings() <em>Error State To Mode Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getErrorStateToModeMappings()
	 * @generated
	 * @ordered
	 */
  protected EList<ErrorStateToModeMapping> errorStateToModeMappings;

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
  public EList<ErrorModelLibrary> getUseTypes()
  {
		if (useTypes == null) {
			useTypes = new EObjectResolvingEList<ErrorModelLibrary>(ErrorModelLibrary.class, this, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_TYPES);
		}
		return useTypes;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorBehaviorStateMachine getUseBehavior()
  {
		if (useBehavior != null && useBehavior.eIsProxy()) {
			InternalEObject oldUseBehavior = (InternalEObject)useBehavior;
			useBehavior = (ErrorBehaviorStateMachine)eResolveProxy(oldUseBehavior);
			if (useBehavior != oldUseBehavior) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_BEHAVIOR, oldUseBehavior, useBehavior));
			}
		}
		return useBehavior;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorBehaviorStateMachine basicGetUseBehavior()
  {
		return useBehavior;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setUseBehavior(ErrorBehaviorStateMachine newUseBehavior)
  {
		ErrorBehaviorStateMachine oldUseBehavior = useBehavior;
		useBehavior = newUseBehavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_BEHAVIOR, oldUseBehavior, useBehavior));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeTransformationSet getUseTransformation()
  {
		if (useTransformation != null && useTransformation.eIsProxy()) {
			InternalEObject oldUseTransformation = (InternalEObject)useTransformation;
			useTransformation = (TypeTransformationSet)eResolveProxy(oldUseTransformation);
			if (useTransformation != oldUseTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_TRANSFORMATION, oldUseTransformation, useTransformation));
			}
		}
		return useTransformation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeTransformationSet basicGetUseTransformation()
  {
		return useTransformation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setUseTransformation(TypeTransformationSet newUseTransformation)
  {
		TypeTransformationSet oldUseTransformation = useTransformation;
		useTransformation = newUseTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_TRANSFORMATION, oldUseTransformation, useTransformation));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<ErrorBehaviorEvent> getEvents()
  {
		if (events == null) {
			events = new EObjectContainmentEList<ErrorBehaviorEvent>(ErrorBehaviorEvent.class, this, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__EVENTS);
		}
		return events;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<ErrorBehaviorTransition> getTransitions()
  {
		if (transitions == null) {
			transitions = new EObjectContainmentEList<ErrorBehaviorTransition>(ErrorBehaviorTransition.class, this, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__TRANSITIONS);
		}
		return transitions;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<OutgoingPropagationCondition> getOutgoingPropagationConditions()
  {
		if (outgoingPropagationConditions == null) {
			outgoingPropagationConditions = new EObjectContainmentEList<OutgoingPropagationCondition>(OutgoingPropagationCondition.class, this, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__OUTGOING_PROPAGATION_CONDITIONS);
		}
		return outgoingPropagationConditions;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<ErrorDetection> getErrorDetections()
  {
		if (errorDetections == null) {
			errorDetections = new EObjectContainmentEList<ErrorDetection>(ErrorDetection.class, this, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__ERROR_DETECTIONS);
		}
		return errorDetections;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<ErrorStateToModeMapping> getErrorStateToModeMappings()
  {
		if (errorStateToModeMappings == null) {
			errorStateToModeMappings = new EObjectContainmentEList<ErrorStateToModeMapping>(ErrorStateToModeMapping.class, this, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__ERROR_STATE_TO_MODE_MAPPINGS);
		}
		return errorStateToModeMappings;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<PropertyAssociation> getProperties()
  {
		if (properties == null) {
			properties = new EObjectContainmentEList<PropertyAssociation>(PropertyAssociation.class, this, ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__PROPERTIES);
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
		switch (featureID) {
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__OUTGOING_PROPAGATION_CONDITIONS:
				return ((InternalEList<?>)getOutgoingPropagationConditions()).basicRemove(otherEnd, msgs);
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__ERROR_DETECTIONS:
				return ((InternalEList<?>)getErrorDetections()).basicRemove(otherEnd, msgs);
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__ERROR_STATE_TO_MODE_MAPPINGS:
				return ((InternalEList<?>)getErrorStateToModeMappings()).basicRemove(otherEnd, msgs);
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__PROPERTIES:
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
		switch (featureID) {
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_TYPES:
				return getUseTypes();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_BEHAVIOR:
				if (resolve) return getUseBehavior();
				return basicGetUseBehavior();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_TRANSFORMATION:
				if (resolve) return getUseTransformation();
				return basicGetUseTransformation();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__EVENTS:
				return getEvents();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__TRANSITIONS:
				return getTransitions();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__OUTGOING_PROPAGATION_CONDITIONS:
				return getOutgoingPropagationConditions();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__ERROR_DETECTIONS:
				return getErrorDetections();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__ERROR_STATE_TO_MODE_MAPPINGS:
				return getErrorStateToModeMappings();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__PROPERTIES:
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
		switch (featureID) {
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_TYPES:
				getUseTypes().clear();
				getUseTypes().addAll((Collection<? extends ErrorModelLibrary>)newValue);
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_BEHAVIOR:
				setUseBehavior((ErrorBehaviorStateMachine)newValue);
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_TRANSFORMATION:
				setUseTransformation((TypeTransformationSet)newValue);
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends ErrorBehaviorEvent>)newValue);
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends ErrorBehaviorTransition>)newValue);
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__OUTGOING_PROPAGATION_CONDITIONS:
				getOutgoingPropagationConditions().clear();
				getOutgoingPropagationConditions().addAll((Collection<? extends OutgoingPropagationCondition>)newValue);
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__ERROR_DETECTIONS:
				getErrorDetections().clear();
				getErrorDetections().addAll((Collection<? extends ErrorDetection>)newValue);
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__ERROR_STATE_TO_MODE_MAPPINGS:
				getErrorStateToModeMappings().clear();
				getErrorStateToModeMappings().addAll((Collection<? extends ErrorStateToModeMapping>)newValue);
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__PROPERTIES:
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
		switch (featureID) {
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_TYPES:
				getUseTypes().clear();
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_BEHAVIOR:
				setUseBehavior((ErrorBehaviorStateMachine)null);
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_TRANSFORMATION:
				setUseTransformation((TypeTransformationSet)null);
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__EVENTS:
				getEvents().clear();
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__TRANSITIONS:
				getTransitions().clear();
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__OUTGOING_PROPAGATION_CONDITIONS:
				getOutgoingPropagationConditions().clear();
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__ERROR_DETECTIONS:
				getErrorDetections().clear();
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__ERROR_STATE_TO_MODE_MAPPINGS:
				getErrorStateToModeMappings().clear();
				return;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__PROPERTIES:
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
		switch (featureID) {
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_TYPES:
				return useTypes != null && !useTypes.isEmpty();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_BEHAVIOR:
				return useBehavior != null;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__USE_TRANSFORMATION:
				return useTransformation != null;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__EVENTS:
				return events != null && !events.isEmpty();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__OUTGOING_PROPAGATION_CONDITIONS:
				return outgoingPropagationConditions != null && !outgoingPropagationConditions.isEmpty();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__ERROR_DETECTIONS:
				return errorDetections != null && !errorDetections.isEmpty();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__ERROR_STATE_TO_MODE_MAPPINGS:
				return errorStateToModeMappings != null && !errorStateToModeMappings.isEmpty();
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR__PROPERTIES:
				return properties != null && !properties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComponentErrorBehaviorImpl
