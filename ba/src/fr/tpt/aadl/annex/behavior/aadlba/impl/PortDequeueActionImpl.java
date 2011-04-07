/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.Name;
import fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction;
import fr.tpt.aadl.annex.behavior.aadlba.Target;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Dequeue Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueActionImpl#getPortName <em>Port Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueActionImpl#getTargetOwned <em>Target Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortDequeueActionImpl extends BehaviorElementImpl implements PortDequeueAction {
	/**
	 * The cached value of the '{@link #getPortName() <em>Port Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortName()
	 * @generated
	 * @ordered
	 */
	protected Name portName;

	/**
	 * The cached value of the '{@link #getTargetOwned() <em>Target Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetOwned()
	 * @generated
	 * @ordered
	 */
	protected Target targetOwned;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortDequeueActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.PORT_DEQUEUE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Name getPortName() {
		return portName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPortName(Name newPortName, NotificationChain msgs) {
		Name oldPortName = portName;
		portName = newPortName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.PORT_DEQUEUE_ACTION__PORT_NAME, oldPortName, newPortName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPortName(Name newPortName) {
		if (newPortName != portName) {
			NotificationChain msgs = null;
			if (portName != null)
				msgs = ((InternalEObject)portName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.PORT_DEQUEUE_ACTION__PORT_NAME, null, msgs);
			if (newPortName != null)
				msgs = ((InternalEObject)newPortName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.PORT_DEQUEUE_ACTION__PORT_NAME, null, msgs);
			msgs = basicSetPortName(newPortName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.PORT_DEQUEUE_ACTION__PORT_NAME, newPortName, newPortName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Target getTargetOwned() {
		return targetOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetOwned(Target newTargetOwned, NotificationChain msgs) {
		Target oldTargetOwned = targetOwned;
		targetOwned = newTargetOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.PORT_DEQUEUE_ACTION__TARGET_OWNED, oldTargetOwned, newTargetOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetOwned(Target newTargetOwned) {
		if (newTargetOwned != targetOwned) {
			NotificationChain msgs = null;
			if (targetOwned != null)
				msgs = ((InternalEObject)targetOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.PORT_DEQUEUE_ACTION__TARGET_OWNED, null, msgs);
			if (newTargetOwned != null)
				msgs = ((InternalEObject)newTargetOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.PORT_DEQUEUE_ACTION__TARGET_OWNED, null, msgs);
			msgs = basicSetTargetOwned(newTargetOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.PORT_DEQUEUE_ACTION__TARGET_OWNED, newTargetOwned, newTargetOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.PORT_DEQUEUE_ACTION__PORT_NAME:
				return basicSetPortName(null, msgs);
			case AadlBaPackage.PORT_DEQUEUE_ACTION__TARGET_OWNED:
				return basicSetTargetOwned(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AadlBaPackage.PORT_DEQUEUE_ACTION__PORT_NAME:
				return getPortName();
			case AadlBaPackage.PORT_DEQUEUE_ACTION__TARGET_OWNED:
				return getTargetOwned();
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
			case AadlBaPackage.PORT_DEQUEUE_ACTION__PORT_NAME:
				setPortName((Name)newValue);
				return;
			case AadlBaPackage.PORT_DEQUEUE_ACTION__TARGET_OWNED:
				setTargetOwned((Target)newValue);
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
			case AadlBaPackage.PORT_DEQUEUE_ACTION__PORT_NAME:
				setPortName((Name)null);
				return;
			case AadlBaPackage.PORT_DEQUEUE_ACTION__TARGET_OWNED:
				setTargetOwned((Target)null);
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
			case AadlBaPackage.PORT_DEQUEUE_ACTION__PORT_NAME:
				return portName != null;
			case AadlBaPackage.PORT_DEQUEUE_ACTION__TARGET_OWNED:
				return targetOwned != null;
		}
		return super.eIsSet(featureID);
	}

} //PortDequeueActionImpl
