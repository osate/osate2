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

import org.osate.aadl2.PropertyAssociation;

import org.osate.aadl2.impl.AnnexSubclauseImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.ConnectionTransformation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ObservablePropagationConnections;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subclause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getUseBehavior <em>Use Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getPropagation <em>Propagation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getComponentBehavior <em>Component Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getCompositeBehavior <em>Composite Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getObservablePropagationConnections <em>Observable Propagation Connections</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getConnectionTransformation <em>Connection Transformation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorModelSubclauseImpl extends AnnexSubclauseImpl implements ErrorModelSubclause
{
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
	 * The cached value of the '{@link #getPropagation() <em>Propagation</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPropagation()
	 * @generated
	 * @ordered
	 */
  protected ErrorPropagations propagation;

  /**
	 * The cached value of the '{@link #getComponentBehavior() <em>Component Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getComponentBehavior()
	 * @generated
	 * @ordered
	 */
  protected ComponentErrorBehavior componentBehavior;

  /**
	 * The cached value of the '{@link #getCompositeBehavior() <em>Composite Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCompositeBehavior()
	 * @generated
	 * @ordered
	 */
  protected CompositeErrorBehavior compositeBehavior;

  /**
	 * The cached value of the '{@link #getObservablePropagationConnections() <em>Observable Propagation Connections</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getObservablePropagationConnections()
	 * @generated
	 * @ordered
	 */
  protected ObservablePropagationConnections observablePropagationConnections;

  /**
	 * The cached value of the '{@link #getConnectionTransformation() <em>Connection Transformation</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getConnectionTransformation()
	 * @generated
	 * @ordered
	 */
  protected ConnectionTransformation connectionTransformation;

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
  protected ErrorModelSubclauseImpl()
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
		return ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR, oldUseBehavior, useBehavior));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR, oldUseBehavior, useBehavior));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorPropagations getPropagation()
  {
		return propagation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetPropagation(ErrorPropagations newPropagation, NotificationChain msgs)
  {
		ErrorPropagations oldPropagation = propagation;
		propagation = newPropagation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATION, oldPropagation, newPropagation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setPropagation(ErrorPropagations newPropagation)
  {
		if (newPropagation != propagation) {
			NotificationChain msgs = null;
			if (propagation != null)
				msgs = ((InternalEObject)propagation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATION, null, msgs);
			if (newPropagation != null)
				msgs = ((InternalEObject)newPropagation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATION, null, msgs);
			msgs = basicSetPropagation(newPropagation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATION, newPropagation, newPropagation));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ComponentErrorBehavior getComponentBehavior()
  {
		return componentBehavior;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetComponentBehavior(ComponentErrorBehavior newComponentBehavior, NotificationChain msgs)
  {
		ComponentErrorBehavior oldComponentBehavior = componentBehavior;
		componentBehavior = newComponentBehavior;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPONENT_BEHAVIOR, oldComponentBehavior, newComponentBehavior);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setComponentBehavior(ComponentErrorBehavior newComponentBehavior)
  {
		if (newComponentBehavior != componentBehavior) {
			NotificationChain msgs = null;
			if (componentBehavior != null)
				msgs = ((InternalEObject)componentBehavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPONENT_BEHAVIOR, null, msgs);
			if (newComponentBehavior != null)
				msgs = ((InternalEObject)newComponentBehavior).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPONENT_BEHAVIOR, null, msgs);
			msgs = basicSetComponentBehavior(newComponentBehavior, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPONENT_BEHAVIOR, newComponentBehavior, newComponentBehavior));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CompositeErrorBehavior getCompositeBehavior()
  {
		return compositeBehavior;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetCompositeBehavior(CompositeErrorBehavior newCompositeBehavior, NotificationChain msgs)
  {
		CompositeErrorBehavior oldCompositeBehavior = compositeBehavior;
		compositeBehavior = newCompositeBehavior;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPOSITE_BEHAVIOR, oldCompositeBehavior, newCompositeBehavior);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCompositeBehavior(CompositeErrorBehavior newCompositeBehavior)
  {
		if (newCompositeBehavior != compositeBehavior) {
			NotificationChain msgs = null;
			if (compositeBehavior != null)
				msgs = ((InternalEObject)compositeBehavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPOSITE_BEHAVIOR, null, msgs);
			if (newCompositeBehavior != null)
				msgs = ((InternalEObject)newCompositeBehavior).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPOSITE_BEHAVIOR, null, msgs);
			msgs = basicSetCompositeBehavior(newCompositeBehavior, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPOSITE_BEHAVIOR, newCompositeBehavior, newCompositeBehavior));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ObservablePropagationConnections getObservablePropagationConnections()
  {
		return observablePropagationConnections;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetObservablePropagationConnections(ObservablePropagationConnections newObservablePropagationConnections, NotificationChain msgs)
  {
		ObservablePropagationConnections oldObservablePropagationConnections = observablePropagationConnections;
		observablePropagationConnections = newObservablePropagationConnections;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OBSERVABLE_PROPAGATION_CONNECTIONS, oldObservablePropagationConnections, newObservablePropagationConnections);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setObservablePropagationConnections(ObservablePropagationConnections newObservablePropagationConnections)
  {
		if (newObservablePropagationConnections != observablePropagationConnections) {
			NotificationChain msgs = null;
			if (observablePropagationConnections != null)
				msgs = ((InternalEObject)observablePropagationConnections).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OBSERVABLE_PROPAGATION_CONNECTIONS, null, msgs);
			if (newObservablePropagationConnections != null)
				msgs = ((InternalEObject)newObservablePropagationConnections).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OBSERVABLE_PROPAGATION_CONNECTIONS, null, msgs);
			msgs = basicSetObservablePropagationConnections(newObservablePropagationConnections, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OBSERVABLE_PROPAGATION_CONNECTIONS, newObservablePropagationConnections, newObservablePropagationConnections));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ConnectionTransformation getConnectionTransformation()
  {
		return connectionTransformation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetConnectionTransformation(ConnectionTransformation newConnectionTransformation, NotificationChain msgs)
  {
		ConnectionTransformation oldConnectionTransformation = connectionTransformation;
		connectionTransformation = newConnectionTransformation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_TRANSFORMATION, oldConnectionTransformation, newConnectionTransformation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setConnectionTransformation(ConnectionTransformation newConnectionTransformation)
  {
		if (newConnectionTransformation != connectionTransformation) {
			NotificationChain msgs = null;
			if (connectionTransformation != null)
				msgs = ((InternalEObject)connectionTransformation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_TRANSFORMATION, null, msgs);
			if (newConnectionTransformation != null)
				msgs = ((InternalEObject)newConnectionTransformation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_TRANSFORMATION, null, msgs);
			msgs = basicSetConnectionTransformation(newConnectionTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_TRANSFORMATION, newConnectionTransformation, newConnectionTransformation));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<PropertyAssociation> getProperties()
  {
		if (properties == null) {
			properties = new EObjectContainmentEList<PropertyAssociation>(PropertyAssociation.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPERTIES);
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
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATION:
				return basicSetPropagation(null, msgs);
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPONENT_BEHAVIOR:
				return basicSetComponentBehavior(null, msgs);
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPOSITE_BEHAVIOR:
				return basicSetCompositeBehavior(null, msgs);
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OBSERVABLE_PROPAGATION_CONNECTIONS:
				return basicSetObservablePropagationConnections(null, msgs);
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_TRANSFORMATION:
				return basicSetConnectionTransformation(null, msgs);
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPERTIES:
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
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR:
				if (resolve) return getUseBehavior();
				return basicGetUseBehavior();
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATION:
				return getPropagation();
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPONENT_BEHAVIOR:
				return getComponentBehavior();
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPOSITE_BEHAVIOR:
				return getCompositeBehavior();
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OBSERVABLE_PROPAGATION_CONNECTIONS:
				return getObservablePropagationConnections();
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_TRANSFORMATION:
				return getConnectionTransformation();
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPERTIES:
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
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR:
				setUseBehavior((ErrorBehaviorStateMachine)newValue);
				return;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATION:
				setPropagation((ErrorPropagations)newValue);
				return;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPONENT_BEHAVIOR:
				setComponentBehavior((ComponentErrorBehavior)newValue);
				return;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPOSITE_BEHAVIOR:
				setCompositeBehavior((CompositeErrorBehavior)newValue);
				return;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OBSERVABLE_PROPAGATION_CONNECTIONS:
				setObservablePropagationConnections((ObservablePropagationConnections)newValue);
				return;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_TRANSFORMATION:
				setConnectionTransformation((ConnectionTransformation)newValue);
				return;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPERTIES:
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
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR:
				setUseBehavior((ErrorBehaviorStateMachine)null);
				return;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATION:
				setPropagation((ErrorPropagations)null);
				return;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPONENT_BEHAVIOR:
				setComponentBehavior((ComponentErrorBehavior)null);
				return;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPOSITE_BEHAVIOR:
				setCompositeBehavior((CompositeErrorBehavior)null);
				return;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OBSERVABLE_PROPAGATION_CONNECTIONS:
				setObservablePropagationConnections((ObservablePropagationConnections)null);
				return;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_TRANSFORMATION:
				setConnectionTransformation((ConnectionTransformation)null);
				return;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPERTIES:
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
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR:
				return useBehavior != null;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATION:
				return propagation != null;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPONENT_BEHAVIOR:
				return componentBehavior != null;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__COMPOSITE_BEHAVIOR:
				return compositeBehavior != null;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OBSERVABLE_PROPAGATION_CONNECTIONS:
				return observablePropagationConnections != null;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_TRANSFORMATION:
				return connectionTransformation != null;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPERTIES:
				return properties != null && !properties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ErrorModelSubclauseImpl
