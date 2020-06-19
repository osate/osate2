/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.Property;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subprogram Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.SubprogramCallImpl#getCalledSubprogram <em>Called Subprogram</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramCallImpl#getContext <em>Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubprogramCallImpl extends BehavioralFeatureImpl implements SubprogramCall {
	/**
	 * The cached value of the '{@link #getCalledSubprogram() <em>Called Subprogram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalledSubprogram()
	 * @generated
	 * @ordered
	 */
	protected CalledSubprogram calledSubprogram;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected CallContext context;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubprogramCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getSubprogramCall();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalledSubprogram getCalledSubprogram() {
		if (calledSubprogram != null && ((EObject) calledSubprogram).eIsProxy()) {
			InternalEObject oldCalledSubprogram = (InternalEObject) calledSubprogram;
			calledSubprogram = (CalledSubprogram) eResolveProxy(oldCalledSubprogram);
			if (calledSubprogram != oldCalledSubprogram) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.SUBPROGRAM_CALL__CALLED_SUBPROGRAM, oldCalledSubprogram, calledSubprogram));
				}
			}
		}
		return calledSubprogram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalledSubprogram basicGetCalledSubprogram() {
		return calledSubprogram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalledSubprogram(CalledSubprogram newCalledSubprogram) {
		CalledSubprogram oldCalledSubprogram = calledSubprogram;
		calledSubprogram = newCalledSubprogram;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.SUBPROGRAM_CALL__CALLED_SUBPROGRAM,
					oldCalledSubprogram, calledSubprogram));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallContext getContext() {
		if (context != null && ((EObject) context).eIsProxy()) {
			InternalEObject oldContext = (InternalEObject) context;
			context = (CallContext) eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.SUBPROGRAM_CALL__CONTEXT,
							oldContext, context));
				}
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallContext basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(CallContext newContext) {
		CallContext oldContext = context;
		context = newContext;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.SUBPROGRAM_CALL__CONTEXT, oldContext,
					context));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.SUBPROGRAM_CALL__CALLED_SUBPROGRAM:
			if (resolve) {
				return getCalledSubprogram();
			}
			return basicGetCalledSubprogram();
		case Aadl2Package.SUBPROGRAM_CALL__CONTEXT:
			if (resolve) {
				return getContext();
			}
			return basicGetContext();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.SUBPROGRAM_CALL__CALLED_SUBPROGRAM:
			setCalledSubprogram((CalledSubprogram) newValue);
			return;
		case Aadl2Package.SUBPROGRAM_CALL__CONTEXT:
			setContext((CallContext) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.SUBPROGRAM_CALL__CALLED_SUBPROGRAM:
			setCalledSubprogram((CalledSubprogram) null);
			return;
		case Aadl2Package.SUBPROGRAM_CALL__CONTEXT:
			setContext((CallContext) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.SUBPROGRAM_CALL__CALLED_SUBPROGRAM:
			return calledSubprogram != null;
		case Aadl2Package.SUBPROGRAM_CALL__CONTEXT:
			return context != null;
		}
		return super.eIsSet(featureID);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.impl.NamedElementImpl#getNamespace()
	 */
	public Namespace getNamespace() {
		return (Namespace) eContainer().eContainer();
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.osate.aadl2.impl.NamedElementImpl#getPropertyValueInternal
	 * (org.osate.aadl2.Property,
	 * org.osate.aadl2.properties.AadlPropertyValue, boolean)
	 */
	public final void getPropertyValueInternal(final Property prop, final PropertyAcc pas,
			final boolean fromInstanceSlaveCall, final boolean all) throws InvalidModelException {
		final ComponentImplementation owner = (ComponentImplementation) getContainingClassifier();

		// local contained value
		if (!fromInstanceSlaveCall && pas.addLocalContained(this, owner)) {
			if (!all) {
				return;
			}
		}

		// get local value
		if (pas.addLocal(this)) {
			if (!all) {
				return;
			}
		}

		// get values from called subprogram
		if (getCalledSubprogram() instanceof Classifier) {
			((Classifier) getCalledSubprogram()).getPropertyValueInternal(prop, pas, fromInstanceSlaveCall, all);
		} else if (getCalledSubprogram() instanceof Feature) {
			((Feature) getCalledSubprogram()).getPropertyValueInternal(prop, pas, fromInstanceSlaveCall, all);
		}

		// get values from container
		if (!fromInstanceSlaveCall && prop.isInherit()) {
			owner.getPropertyValueInternal(prop, pas, fromInstanceSlaveCall, all);
		}
	}

} // SubprogramCallImpl
