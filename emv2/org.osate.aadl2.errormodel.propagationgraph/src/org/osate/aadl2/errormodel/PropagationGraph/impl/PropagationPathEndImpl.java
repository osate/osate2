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
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Propagation Path End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathEndImpl#getConnectionInstance <em>Connection Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathEndImpl#getErrorPropagation <em>Error Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathEndImpl#getComponentInstance <em>Component Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathEndImpl#isHighlight <em>Highlight</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropagationPathEndImpl extends MinimalEObjectImpl.Container implements PropagationPathEnd {
	/**
	 * The cached value of the '{@link #getConnectionInstance() <em>Connection Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionInstance()
	 * @generated
	 * @ordered
	 */
	protected ConnectionInstance connectionInstance;

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
	 * The default value of the '{@link #isHighlight() <em>Highlight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHighlight()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIGHLIGHT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHighlight() <em>Highlight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHighlight()
	 * @generated
	 * @ordered
	 */
	protected boolean highlight = HIGHLIGHT_EDEFAULT;

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
	public ConnectionInstance getConnectionInstance() {
		if (connectionInstance != null && connectionInstance.eIsProxy()) {
			InternalEObject oldConnectionInstance = (InternalEObject)connectionInstance;
			connectionInstance = (ConnectionInstance)eResolveProxy(oldConnectionInstance);
			if (connectionInstance != oldConnectionInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropagationGraphPackage.PROPAGATION_PATH_END__CONNECTION_INSTANCE, oldConnectionInstance, connectionInstance));
			}
		}
		return connectionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInstance basicGetConnectionInstance() {
		return connectionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionInstance(ConnectionInstance newConnectionInstance) {
		ConnectionInstance oldConnectionInstance = connectionInstance;
		connectionInstance = newConnectionInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_PATH_END__CONNECTION_INSTANCE, oldConnectionInstance, connectionInstance));
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
	public boolean isHighlight() {
		return highlight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHighlight(boolean newHighlight) {
		boolean oldHighlight = highlight;
		highlight = newHighlight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropagationGraphPackage.PROPAGATION_PATH_END__HIGHLIGHT, oldHighlight, highlight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PropagationGraphPackage.PROPAGATION_PATH_END__CONNECTION_INSTANCE:
				if (resolve) return getConnectionInstance();
				return basicGetConnectionInstance();
			case PropagationGraphPackage.PROPAGATION_PATH_END__ERROR_PROPAGATION:
				if (resolve) return getErrorPropagation();
				return basicGetErrorPropagation();
			case PropagationGraphPackage.PROPAGATION_PATH_END__COMPONENT_INSTANCE:
				if (resolve) return getComponentInstance();
				return basicGetComponentInstance();
			case PropagationGraphPackage.PROPAGATION_PATH_END__HIGHLIGHT:
				return isHighlight();
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
			case PropagationGraphPackage.PROPAGATION_PATH_END__CONNECTION_INSTANCE:
				setConnectionInstance((ConnectionInstance)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_PATH_END__ERROR_PROPAGATION:
				setErrorPropagation((ErrorPropagation)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_PATH_END__COMPONENT_INSTANCE:
				setComponentInstance((ComponentInstance)newValue);
				return;
			case PropagationGraphPackage.PROPAGATION_PATH_END__HIGHLIGHT:
				setHighlight((Boolean)newValue);
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
			case PropagationGraphPackage.PROPAGATION_PATH_END__CONNECTION_INSTANCE:
				setConnectionInstance((ConnectionInstance)null);
				return;
			case PropagationGraphPackage.PROPAGATION_PATH_END__ERROR_PROPAGATION:
				setErrorPropagation((ErrorPropagation)null);
				return;
			case PropagationGraphPackage.PROPAGATION_PATH_END__COMPONENT_INSTANCE:
				setComponentInstance((ComponentInstance)null);
				return;
			case PropagationGraphPackage.PROPAGATION_PATH_END__HIGHLIGHT:
				setHighlight(HIGHLIGHT_EDEFAULT);
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
			case PropagationGraphPackage.PROPAGATION_PATH_END__CONNECTION_INSTANCE:
				return connectionInstance != null;
			case PropagationGraphPackage.PROPAGATION_PATH_END__ERROR_PROPAGATION:
				return errorPropagation != null;
			case PropagationGraphPackage.PROPAGATION_PATH_END__COMPONENT_INSTANCE:
				return componentInstance != null;
			case PropagationGraphPackage.PROPAGATION_PATH_END__HIGHLIGHT:
				return highlight != HIGHLIGHT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (highlight: ");
		result.append(highlight);
		result.append(')');
		return result.toString();
	}

} //PropagationPathEndImpl
