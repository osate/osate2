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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.Prototype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Prototype Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ComponentPrototypeBindingImpl#getActuals <em>Actual</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentPrototypeBindingImpl#getFormal <em>Formal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentPrototypeBindingImpl extends PrototypeBindingImpl implements ComponentPrototypeBinding {
	/**
	 * The cached value of the '{@link #getActuals() <em>Actual</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActuals()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentPrototypeActual> actuals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentPrototypeBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getComponentPrototypeBinding();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentPrototypeActual> getActuals() {
		if (actuals == null) {
			actuals = new EObjectContainmentEList<ComponentPrototypeActual>(ComponentPrototypeActual.class, this,
					Aadl2Package.COMPONENT_PROTOTYPE_BINDING__ACTUAL);
		}
		return actuals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentPrototypeActual createActual() {
		ComponentPrototypeActual newActual = (ComponentPrototypeActual) create(
				Aadl2Package.eINSTANCE.getComponentPrototypeActual());
		getActuals().add(newActual);
		return newActual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Prototype getFormal() {
		if (formal != null && ((EObject) formal).eIsProxy()) {
			InternalEObject oldFormal = (InternalEObject) formal;
			formal = (Prototype) eResolveProxy(oldFormal);
			if (formal != oldFormal) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.COMPONENT_PROTOTYPE_BINDING__FORMAL, oldFormal, formal));
				}
			}
		}
		return formal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Prototype basicGetFormal() {
		return formal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setFormal(Prototype newFormal) {
		if (newFormal != null && !((EObject) newFormal).eIsProxy() && !(newFormal instanceof ComponentPrototype)) {
			return;
		}
		Prototype oldFormal = formal;
		formal = newFormal;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.COMPONENT_PROTOTYPE_BINDING__FORMAL,
					oldFormal, formal));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFormal() {
		return formal != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.COMPONENT_PROTOTYPE_BINDING__ACTUAL:
			return ((InternalEList<?>) getActuals()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.COMPONENT_PROTOTYPE_BINDING__ACTUAL:
			return getActuals();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.COMPONENT_PROTOTYPE_BINDING__ACTUAL:
			getActuals().clear();
			getActuals().addAll((Collection<? extends ComponentPrototypeActual>) newValue);
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
		case Aadl2Package.COMPONENT_PROTOTYPE_BINDING__ACTUAL:
			getActuals().clear();
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
		case Aadl2Package.COMPONENT_PROTOTYPE_BINDING__ACTUAL:
			return actuals != null && !actuals.isEmpty();
		case Aadl2Package.COMPONENT_PROTOTYPE_BINDING__FORMAL:
			return isSetFormal();
		}
		return super.eIsSet(featureID);
	}

} // ComponentPrototypeBindingImpl
