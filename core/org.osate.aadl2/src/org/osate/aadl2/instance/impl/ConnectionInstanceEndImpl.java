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
package org.osate.aadl2.instance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.InstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Instance End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionInstanceEndImpl#getSrcConnectionInstances <em>Src Connection Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionInstanceEndImpl#getDstConnectionInstances <em>Dst Connection Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConnectionInstanceEndImpl extends InstanceObjectImpl implements ConnectionInstanceEnd {
	/**
	 * The cached value of the '{@link #getSrcConnectionInstances() <em>Src Connection Instance</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcConnectionInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionInstance> srcConnectionInstances;
	/**
	 * The cached value of the '{@link #getDstConnectionInstances() <em>Dst Connection Instance</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstConnectionInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionInstance> dstConnectionInstances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionInstanceEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return InstancePackage.Literals.CONNECTION_INSTANCE_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectionInstance> getSrcConnectionInstances() {
		if (srcConnectionInstances == null) {
			srcConnectionInstances = new EObjectWithInverseEList<ConnectionInstance>(ConnectionInstance.class, this,
					InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE,
					InstancePackage.CONNECTION_INSTANCE__SOURCE);
		}
		return srcConnectionInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectionInstance> getDstConnectionInstances() {
		if (dstConnectionInstances == null) {
			dstConnectionInstances = new EObjectWithInverseEList<ConnectionInstance>(ConnectionInstance.class, this,
					InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE,
					InstancePackage.CONNECTION_INSTANCE__DESTINATION);
		}
		return dstConnectionInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSrcConnectionInstances()).basicAdd(otherEnd,
					msgs);
		case InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDstConnectionInstances()).basicAdd(otherEnd,
					msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE:
			return ((InternalEList<?>) getSrcConnectionInstances()).basicRemove(otherEnd, msgs);
		case InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE:
			return ((InternalEList<?>) getDstConnectionInstances()).basicRemove(otherEnd, msgs);
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
		case InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE:
			return getSrcConnectionInstances();
		case InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE:
			return getDstConnectionInstances();
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
		case InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE:
			getSrcConnectionInstances().clear();
			getSrcConnectionInstances().addAll((Collection<? extends ConnectionInstance>) newValue);
			return;
		case InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE:
			getDstConnectionInstances().clear();
			getDstConnectionInstances().addAll((Collection<? extends ConnectionInstance>) newValue);
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
		case InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE:
			getSrcConnectionInstances().clear();
			return;
		case InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE:
			getDstConnectionInstances().clear();
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
		case InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE:
			return srcConnectionInstances != null && !srcConnectionInstances.isEmpty();
		case InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE:
			return dstConnectionInstances != null && !dstConnectionInstances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ConnectionInstanceEndImpl
