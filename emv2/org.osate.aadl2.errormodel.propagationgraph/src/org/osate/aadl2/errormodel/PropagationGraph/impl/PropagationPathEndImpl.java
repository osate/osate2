/**
 */
package org.osate.aadl2.errormodel.PropagationGraph.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Propagation Path End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathEndImpl#getInstanceObject <em>Instance Object</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathEndImpl#getErrorPropagation <em>Error Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathEndImpl#getComponentInstance <em>Component Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropagationPathEndImpl extends MinimalEObjectImpl.Container implements PropagationPathEnd {
	/**
	 * The cached value of the '{@link #getInstanceObject() <em>Instance Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceObject()
	 * @generated
	 * @ordered
	 */
	protected InstanceObject instanceObject;

	/**
	 * The cached value of the '{@link #getErrorPropagation() <em>Error Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorPropagation()
	 * @generated
	 * @ordered
	 */
	protected ErrorPropagation errorPropagation;

	/**
	 * The cached value of the '{@link #getComponentInstance() <em>Component Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentInstance()
	 * @generated
	 * @ordered
	 */
	protected ComponentInstance componentInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropagationPathEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PropagationGraphPackage.Literals.PROPAGATION_PATH_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceObject getInstanceObject() {
		if (instanceObject != null && instanceObject.eIsProxy()) {
			InternalEObject oldInstanceObject = (InternalEObject)instanceObject;
			instanceObject = (InstanceObject)eResolveProxy(oldInstanceObject);
			if (instanceObject != oldInstanceObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropagationGraphPackage.PROPAGATION_PATH_END__INSTANCE_OBJECT, oldInstanceObject, instanceObject));
			}
		}
		return instanceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceObject basicGetInstanceObject() {
		return instanceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceObject(InstanceObject newInstanceObject) {
		InstanceObject oldInstanceObject = instanceObject;
		instanceObject = newInstanceObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_PATH_END__INSTANCE_OBJECT, oldInstanceObject, instanceObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorPropagation getErrorPropagation() {
		if (errorPropagation != null && errorPropagation.eIsProxy()) {
			InternalEObject oldErrorPropagation = (InternalEObject)errorPropagation;
			errorPropagation = (ErrorPropagation)eResolveProxy(oldErrorPropagation);
			if (errorPropagation != oldErrorPropagation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropagationGraphPackage.PROPAGATION_PATH_END__ERROR_PROPAGATION, oldErrorPropagation, errorPropagation));
			}
		}
		return errorPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorPropagation basicGetErrorPropagation() {
		return errorPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorPropagation(ErrorPropagation newErrorPropagation) {
		ErrorPropagation oldErrorPropagation = errorPropagation;
		errorPropagation = newErrorPropagation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_PATH_END__ERROR_PROPAGATION, oldErrorPropagation, errorPropagation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance getComponentInstance() {
		if (componentInstance != null && componentInstance.eIsProxy()) {
			InternalEObject oldComponentInstance = (InternalEObject)componentInstance;
			componentInstance = (ComponentInstance)eResolveProxy(oldComponentInstance);
			if (componentInstance != oldComponentInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropagationGraphPackage.PROPAGATION_PATH_END__COMPONENT_INSTANCE, oldComponentInstance, componentInstance));
			}
		}
		return componentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance basicGetComponentInstance() {
		return componentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentInstance(ComponentInstance newComponentInstance) {
		ComponentInstance oldComponentInstance = componentInstance;
		componentInstance = newComponentInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_PATH_END__COMPONENT_INSTANCE, oldComponentInstance, componentInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PropagationGraphPackage.PROPAGATION_PATH_END__INSTANCE_OBJECT:
				if (resolve) return getInstanceObject();
				return basicGetInstanceObject();
			case PropagationGraphPackage.PROPAGATION_PATH_END__ERROR_PROPAGATION:
				if (resolve) return getErrorPropagation();
				return basicGetErrorPropagation();
			case PropagationGraphPackage.PROPAGATION_PATH_END__COMPONENT_INSTANCE:
				if (resolve) return getComponentInstance();
				return basicGetComponentInstance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PropagationGraphPackage.PROPAGATION_PATH_END__INSTANCE_OBJECT:
				setInstanceObject((InstanceObject)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_PATH_END__ERROR_PROPAGATION:
				setErrorPropagation((ErrorPropagation)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_PATH_END__COMPONENT_INSTANCE:
				setComponentInstance((ComponentInstance)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case PropagationGraphPackage.PROPAGATION_PATH_END__INSTANCE_OBJECT:
				setInstanceObject((InstanceObject)null);
				return;
			case PropagationGraphPackage.PROPAGATION_PATH_END__ERROR_PROPAGATION:
				setErrorPropagation((ErrorPropagation)null);
				return;
			case PropagationGraphPackage.PROPAGATION_PATH_END__COMPONENT_INSTANCE:
				setComponentInstance((ComponentInstance)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PropagationGraphPackage.PROPAGATION_PATH_END__INSTANCE_OBJECT:
				return instanceObject != null;
			case PropagationGraphPackage.PROPAGATION_PATH_END__ERROR_PROPAGATION:
				return errorPropagation != null;
			case PropagationGraphPackage.PROPAGATION_PATH_END__COMPONENT_INSTANCE:
				return componentInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //PropagationPathEndImpl
