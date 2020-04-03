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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.aadl2.instance.FeatureInstance;

import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintElement;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Detection Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorDetectionInstanceImpl#getEmv2Element <em>Emv2 Element</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorDetectionInstanceImpl#getInStates <em>In States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorDetectionInstanceImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorDetectionInstanceImpl#getErrorCode <em>Error Code</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorDetectionInstanceImpl#getPort <em>Port</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorDetectionInstanceImpl extends EMV2InstanceObjectImpl implements ErrorDetectionInstance {
	/**
	 * The cached value of the '{@link #getEmv2Element() <em>Emv2 Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmv2Element()
	 * @generated
	 * @ordered
	 */
	protected ErrorDetection emv2Element;

	/**
	 * The cached value of the '{@link #getInStates() <em>In States</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInStates()
	 * @generated
	 * @ordered
	 */
	protected EList<StateInstance> inStates;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected ConstraintElement condition;

	/**
	 * The default value of the '{@link #getErrorCode() <em>Error Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorCode()
	 * @generated
	 * @ordered
	 */
	protected static final String ERROR_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getErrorCode() <em>Error Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorCode()
	 * @generated
	 * @ordered
	 */
	protected String errorCode = ERROR_CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected FeatureInstance port;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorDetectionInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.ERROR_DETECTION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorDetection getEmv2Element() {
		if (emv2Element != null && emv2Element.eIsProxy()) {
			InternalEObject oldEmv2Element = (InternalEObject)emv2Element;
			emv2Element = (ErrorDetection)eResolveProxy(oldEmv2Element);
			if (emv2Element != oldEmv2Element) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMV2InstancePackage.ERROR_DETECTION_INSTANCE__EMV2_ELEMENT, oldEmv2Element, emv2Element));
			}
		}
		return emv2Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorDetection basicGetEmv2Element() {
		return emv2Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEmv2Element(ErrorDetection newEmv2Element) {
		ErrorDetection oldEmv2Element = emv2Element;
		emv2Element = newEmv2Element;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.ERROR_DETECTION_INSTANCE__EMV2_ELEMENT, oldEmv2Element, emv2Element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<StateInstance> getInStates() {
		if (inStates == null) {
			inStates = new EObjectResolvingEList<StateInstance>(StateInstance.class, this, EMV2InstancePackage.ERROR_DETECTION_INSTANCE__IN_STATES);
		}
		return inStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstraintElement getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(ConstraintElement newCondition, NotificationChain msgs) {
		ConstraintElement oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.ERROR_DETECTION_INSTANCE__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCondition(ConstraintElement newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_DETECTION_INSTANCE__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_DETECTION_INSTANCE__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.ERROR_DETECTION_INSTANCE__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setErrorCode(String newErrorCode) {
		String oldErrorCode = errorCode;
		errorCode = newErrorCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.ERROR_DETECTION_INSTANCE__ERROR_CODE, oldErrorCode, errorCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureInstance getPort() {
		if (port != null && port.eIsProxy()) {
			InternalEObject oldPort = (InternalEObject)port;
			port = (FeatureInstance)eResolveProxy(oldPort);
			if (port != oldPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMV2InstancePackage.ERROR_DETECTION_INSTANCE__PORT, oldPort, port));
			}
		}
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureInstance basicGetPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPort(FeatureInstance newPort) {
		FeatureInstance oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.ERROR_DETECTION_INSTANCE__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__CONDITION:
				return basicSetCondition(null, msgs);
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
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__EMV2_ELEMENT:
				if (resolve) return getEmv2Element();
				return basicGetEmv2Element();
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__IN_STATES:
				return getInStates();
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__CONDITION:
				return getCondition();
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__ERROR_CODE:
				return getErrorCode();
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__PORT:
				if (resolve) return getPort();
				return basicGetPort();
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
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__EMV2_ELEMENT:
				setEmv2Element((ErrorDetection)newValue);
				return;
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__IN_STATES:
				getInStates().clear();
				getInStates().addAll((Collection<? extends StateInstance>)newValue);
				return;
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__CONDITION:
				setCondition((ConstraintElement)newValue);
				return;
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__ERROR_CODE:
				setErrorCode((String)newValue);
				return;
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__PORT:
				setPort((FeatureInstance)newValue);
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
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__EMV2_ELEMENT:
				setEmv2Element((ErrorDetection)null);
				return;
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__IN_STATES:
				getInStates().clear();
				return;
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__CONDITION:
				setCondition((ConstraintElement)null);
				return;
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__ERROR_CODE:
				setErrorCode(ERROR_CODE_EDEFAULT);
				return;
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__PORT:
				setPort((FeatureInstance)null);
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
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__EMV2_ELEMENT:
				return emv2Element != null;
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__IN_STATES:
				return inStates != null && !inStates.isEmpty();
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__CONDITION:
				return condition != null;
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__ERROR_CODE:
				return ERROR_CODE_EDEFAULT == null ? errorCode != null : !ERROR_CODE_EDEFAULT.equals(errorCode);
			case EMV2InstancePackage.ERROR_DETECTION_INSTANCE__PORT:
				return port != null;
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
		result.append(" (errorCode: ");
		result.append(errorCode);
		result.append(')');
		return result.toString();
	}

} //ErrorDetectionInstanceImpl
