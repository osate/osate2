/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.errormodel.instance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.errormodel.instance.BindingPath;
import org.osate.aadl2.errormodel.instance.BindingPropagation;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding Propagation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.BindingPropagationImpl#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.BindingPropagationImpl#getSourceBindingPaths <em>Source Binding Paths</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.BindingPropagationImpl#getDestinationBindingPaths <em>Destination Binding Paths</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BindingPropagationImpl extends ErrorPropagationInstanceImpl implements BindingPropagation {
	/**
	 * The default value of the '{@link #getBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected static final BindingType BINDING_EDEFAULT = BindingType.PROCESSOR;

	/**
	 * The cached value of the '{@link #getBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected BindingType binding = BINDING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceBindingPaths() <em>Source Binding Paths</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceBindingPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<BindingPath> sourceBindingPaths;

	/**
	 * The cached value of the '{@link #getDestinationBindingPaths() <em>Destination Binding Paths</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationBindingPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<BindingPath> destinationBindingPaths;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingPropagationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.BINDING_PROPAGATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BindingType getBinding() {
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBinding(BindingType newBinding) {
		BindingType oldBinding = binding;
		binding = newBinding == null ? BINDING_EDEFAULT : newBinding;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.BINDING_PROPAGATION__BINDING,
					oldBinding, binding));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<BindingPath> getSourceBindingPaths() {
		if (sourceBindingPaths == null) {
			sourceBindingPaths = new EObjectWithInverseResolvingEList.ManyInverse<>(BindingPath.class, this,
					EMV2InstancePackage.BINDING_PROPAGATION__SOURCE_BINDING_PATHS,
					EMV2InstancePackage.BINDING_PATH__SOURCE_PROPAGATIONS);
		}
		return sourceBindingPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<BindingPath> getDestinationBindingPaths() {
		if (destinationBindingPaths == null) {
			destinationBindingPaths = new EObjectWithInverseResolvingEList.ManyInverse<>(BindingPath.class,
					this, EMV2InstancePackage.BINDING_PROPAGATION__DESTINATION_BINDING_PATHS,
					EMV2InstancePackage.BINDING_PATH__DESTINATION_PROPAGATIONS);
		}
		return destinationBindingPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EMV2InstancePackage.BINDING_PROPAGATION__SOURCE_BINDING_PATHS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSourceBindingPaths()).basicAdd(otherEnd,
					msgs);
		case EMV2InstancePackage.BINDING_PROPAGATION__DESTINATION_BINDING_PATHS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDestinationBindingPaths()).basicAdd(otherEnd,
					msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EMV2InstancePackage.BINDING_PROPAGATION__SOURCE_BINDING_PATHS:
			return ((InternalEList<?>) getSourceBindingPaths()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.BINDING_PROPAGATION__DESTINATION_BINDING_PATHS:
			return ((InternalEList<?>) getDestinationBindingPaths()).basicRemove(otherEnd, msgs);
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
		case EMV2InstancePackage.BINDING_PROPAGATION__BINDING:
			return getBinding();
		case EMV2InstancePackage.BINDING_PROPAGATION__SOURCE_BINDING_PATHS:
			return getSourceBindingPaths();
		case EMV2InstancePackage.BINDING_PROPAGATION__DESTINATION_BINDING_PATHS:
			return getDestinationBindingPaths();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case EMV2InstancePackage.BINDING_PROPAGATION__BINDING:
			setBinding((BindingType) newValue);
			return;
		case EMV2InstancePackage.BINDING_PROPAGATION__SOURCE_BINDING_PATHS:
			getSourceBindingPaths().clear();
			getSourceBindingPaths().addAll((Collection<? extends BindingPath>) newValue);
			return;
		case EMV2InstancePackage.BINDING_PROPAGATION__DESTINATION_BINDING_PATHS:
			getDestinationBindingPaths().clear();
			getDestinationBindingPaths().addAll((Collection<? extends BindingPath>) newValue);
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
		case EMV2InstancePackage.BINDING_PROPAGATION__BINDING:
			setBinding(BINDING_EDEFAULT);
			return;
		case EMV2InstancePackage.BINDING_PROPAGATION__SOURCE_BINDING_PATHS:
			getSourceBindingPaths().clear();
			return;
		case EMV2InstancePackage.BINDING_PROPAGATION__DESTINATION_BINDING_PATHS:
			getDestinationBindingPaths().clear();
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
		case EMV2InstancePackage.BINDING_PROPAGATION__BINDING:
			return binding != BINDING_EDEFAULT;
		case EMV2InstancePackage.BINDING_PROPAGATION__SOURCE_BINDING_PATHS:
			return sourceBindingPaths != null && !sourceBindingPaths.isEmpty();
		case EMV2InstancePackage.BINDING_PROPAGATION__DESTINATION_BINDING_PATHS:
			return destinationBindingPaths != null && !destinationBindingPaths.isEmpty();
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
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (binding: ");
		result.append(binding);
		result.append(')');
		return result.toString();
	}

} // BindingPropagationImpl
