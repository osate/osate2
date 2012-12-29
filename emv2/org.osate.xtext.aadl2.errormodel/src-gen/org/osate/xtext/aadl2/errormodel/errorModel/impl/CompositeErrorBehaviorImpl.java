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

import org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Error Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.CompositeErrorBehaviorImpl#getUseTypes <em>Use Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.CompositeErrorBehaviorImpl#getUseBehavior <em>Use Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.CompositeErrorBehaviorImpl#getState <em>State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.CompositeErrorBehaviorImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeErrorBehaviorImpl extends ElementImpl implements CompositeErrorBehavior
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
	 * The cached value of the '{@link #getState() <em>State</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
  protected EList<CompositeState> state;

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
  protected CompositeErrorBehaviorImpl()
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
		return ErrorModelPackage.Literals.COMPOSITE_ERROR_BEHAVIOR;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<ErrorModelLibrary> getUseTypes()
  {
		if (useTypes == null) {
			useTypes = new EObjectResolvingEList<ErrorModelLibrary>(ErrorModelLibrary.class, this, ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__USE_TYPES);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__USE_BEHAVIOR, oldUseBehavior, useBehavior));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__USE_BEHAVIOR, oldUseBehavior, useBehavior));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<CompositeState> getState()
  {
		if (state == null) {
			state = new EObjectContainmentEList<CompositeState>(CompositeState.class, this, ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__STATE);
		}
		return state;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<PropertyAssociation> getProperties()
  {
		if (properties == null) {
			properties = new EObjectContainmentEList<PropertyAssociation>(PropertyAssociation.class, this, ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__PROPERTIES);
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
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__STATE:
				return ((InternalEList<?>)getState()).basicRemove(otherEnd, msgs);
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__PROPERTIES:
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
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__USE_TYPES:
				return getUseTypes();
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__USE_BEHAVIOR:
				if (resolve) return getUseBehavior();
				return basicGetUseBehavior();
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__STATE:
				return getState();
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__PROPERTIES:
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
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__USE_TYPES:
				getUseTypes().clear();
				getUseTypes().addAll((Collection<? extends ErrorModelLibrary>)newValue);
				return;
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__USE_BEHAVIOR:
				setUseBehavior((ErrorBehaviorStateMachine)newValue);
				return;
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__STATE:
				getState().clear();
				getState().addAll((Collection<? extends CompositeState>)newValue);
				return;
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__PROPERTIES:
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
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__USE_TYPES:
				getUseTypes().clear();
				return;
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__USE_BEHAVIOR:
				setUseBehavior((ErrorBehaviorStateMachine)null);
				return;
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__STATE:
				getState().clear();
				return;
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__PROPERTIES:
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
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__USE_TYPES:
				return useTypes != null && !useTypes.isEmpty();
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__USE_BEHAVIOR:
				return useBehavior != null;
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__STATE:
				return state != null && !state.isEmpty();
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR__PROPERTIES:
				return properties != null && !properties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeErrorBehaviorImpl
