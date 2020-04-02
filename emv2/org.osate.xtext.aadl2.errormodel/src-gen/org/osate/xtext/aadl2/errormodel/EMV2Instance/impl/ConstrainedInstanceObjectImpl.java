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
package org.osate.xtext.aadl2.errormodel.EMV2Instance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.instance.InstanceObject;

import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage;

import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constrained Instance Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl#getInstanceObject <em>Instance Object</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl#getPropagationKind <em>Propagation Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstrainedInstanceObjectImpl extends ConstraintElementImpl implements ConstrainedInstanceObject {
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
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeToken> constraint;

	/**
	 * The default value of the '{@link #getPropagationKind() <em>Propagation Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationKind()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPAGATION_KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropagationKind() <em>Propagation Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationKind()
	 * @generated
	 * @ordered
	 */
	protected String propagationKind = PROPAGATION_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstrainedInstanceObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.CONSTRAINED_INSTANCE_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstanceObject getInstanceObject() {
		if (instanceObject != null && instanceObject.eIsProxy()) {
			InternalEObject oldInstanceObject = (InternalEObject)instanceObject;
			instanceObject = (InstanceObject)eResolveProxy(oldInstanceObject);
			if (instanceObject != oldInstanceObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT, oldInstanceObject, instanceObject));
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
	@Override
	public void setInstanceObject(InstanceObject newInstanceObject) {
		InstanceObject oldInstanceObject = instanceObject;
		instanceObject = newInstanceObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT, oldInstanceObject, instanceObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypeToken> getConstraint() {
		if (constraint == null) {
			constraint = new EObjectContainmentEList<TypeToken>(TypeToken.class, this, EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT);
		}
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPropagationKind() {
		return propagationKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPropagationKind(String newPropagationKind) {
		String oldPropagationKind = propagationKind;
		propagationKind = newPropagationKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__PROPAGATION_KIND, oldPropagationKind, propagationKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT:
				return ((InternalEList<?>)getConstraint()).basicRemove(otherEnd, msgs);
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
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT:
				if (resolve) return getInstanceObject();
				return basicGetInstanceObject();
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT:
				return getConstraint();
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__PROPAGATION_KIND:
				return getPropagationKind();
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
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT:
				setInstanceObject((InstanceObject)newValue);
				return;
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT:
				getConstraint().clear();
				getConstraint().addAll((Collection<? extends TypeToken>)newValue);
				return;
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__PROPAGATION_KIND:
				setPropagationKind((String)newValue);
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
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT:
				setInstanceObject((InstanceObject)null);
				return;
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT:
				getConstraint().clear();
				return;
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__PROPAGATION_KIND:
				setPropagationKind(PROPAGATION_KIND_EDEFAULT);
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
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT:
				return instanceObject != null;
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT:
				return constraint != null && !constraint.isEmpty();
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT__PROPAGATION_KIND:
				return PROPAGATION_KIND_EDEFAULT == null ? propagationKind != null : !PROPAGATION_KIND_EDEFAULT.equals(propagationKind);
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (propagationKind: ");
		result.append(propagationKind);
		result.append(')');
		return result.toString();
	}

} //ConstrainedInstanceObjectImpl
