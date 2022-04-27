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
package org.osate.aadl2.errormodel.instance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.osate.aadl2.errormodel.instance.BindingPath;
import org.osate.aadl2.errormodel.instance.BindingPropagation;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.BindingPathImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.BindingPathImpl#getSourcePropagations <em>Source Propagations</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.BindingPathImpl#getDestinationPropagations <em>Destination Propagations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BindingPathImpl extends EMV2InstanceObjectImpl implements BindingPath {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final BindingType TYPE_EDEFAULT = BindingType.PROCESSOR;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected BindingType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourcePropagations() <em>Source Propagations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePropagations()
	 * @generated
	 * @ordered
	 */
	protected EList<BindingPropagation> sourcePropagations;

	/**
	 * The cached value of the '{@link #getDestinationPropagations() <em>Destination Propagations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationPropagations()
	 * @generated
	 * @ordered
	 */
	protected EList<BindingPropagation> destinationPropagations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingPathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.BINDING_PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BindingType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(BindingType newType) {
		BindingType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.BINDING_PATH__TYPE, oldType,
					type));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<BindingPropagation> getSourcePropagations() {
		if (sourcePropagations == null) {
			sourcePropagations = new EObjectResolvingEList<>(BindingPropagation.class, this,
					EMV2InstancePackage.BINDING_PATH__SOURCE_PROPAGATIONS);
		}
		return sourcePropagations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<BindingPropagation> getDestinationPropagations() {
		if (destinationPropagations == null) {
			destinationPropagations = new EObjectResolvingEList<>(BindingPropagation.class, this,
					EMV2InstancePackage.BINDING_PATH__DESTINATION_PROPAGATIONS);
		}
		return destinationPropagations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EMV2InstancePackage.BINDING_PATH__TYPE:
			return getType();
		case EMV2InstancePackage.BINDING_PATH__SOURCE_PROPAGATIONS:
			return getSourcePropagations();
		case EMV2InstancePackage.BINDING_PATH__DESTINATION_PROPAGATIONS:
			return getDestinationPropagations();
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
		case EMV2InstancePackage.BINDING_PATH__TYPE:
			setType((BindingType) newValue);
			return;
		case EMV2InstancePackage.BINDING_PATH__SOURCE_PROPAGATIONS:
			getSourcePropagations().clear();
			getSourcePropagations().addAll((Collection<? extends BindingPropagation>) newValue);
			return;
		case EMV2InstancePackage.BINDING_PATH__DESTINATION_PROPAGATIONS:
			getDestinationPropagations().clear();
			getDestinationPropagations().addAll((Collection<? extends BindingPropagation>) newValue);
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
		case EMV2InstancePackage.BINDING_PATH__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case EMV2InstancePackage.BINDING_PATH__SOURCE_PROPAGATIONS:
			getSourcePropagations().clear();
			return;
		case EMV2InstancePackage.BINDING_PATH__DESTINATION_PROPAGATIONS:
			getDestinationPropagations().clear();
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
		case EMV2InstancePackage.BINDING_PATH__TYPE:
			return type != TYPE_EDEFAULT;
		case EMV2InstancePackage.BINDING_PATH__SOURCE_PROPAGATIONS:
			return sourcePropagations != null && !sourcePropagations.isEmpty();
		case EMV2InstancePackage.BINDING_PATH__DESTINATION_PROPAGATIONS:
			return destinationPropagations != null && !destinationPropagations.isEmpty();
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} // BindingPathImpl
