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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.ErrorPropagationInstance;
import org.osate.aadl2.errormodel.instance.TypeProductInstance;
import org.osate.aadl2.errormodel.instance.TypeReference;
import org.osate.aadl2.errormodel.instance.TypeSetInstance;
import org.osate.aadl2.errormodel.instance.TypeTokenInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Propagation Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl#getInErrorPropagation <em>In Error Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl#getOutErrorPropagation <em>Out Error Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl#getInTokens <em>In Tokens</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl#getOutTokens <em>Out Tokens</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ErrorPropagationInstanceImpl extends ConstrainedInstanceObjectImpl
		implements ErrorPropagationInstance {
	/**
	 * The cached value of the '{@link #getInErrorPropagation() <em>In Error Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInErrorPropagation()
	 * @generated
	 * @ordered
	 */
	protected ErrorPropagation inErrorPropagation;

	/**
	 * The cached value of the '{@link #getOutErrorPropagation() <em>Out Error Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutErrorPropagation()
	 * @generated
	 * @ordered
	 */
	protected ErrorPropagation outErrorPropagation;

	/**
	 * The cached value of the '{@link #getInTokens() <em>In Tokens</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInTokens()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeTokenInstance> inTokens;

	/**
	 * The cached value of the '{@link #getOutTokens() <em>Out Tokens</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutTokens()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeTokenInstance> outTokens;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorPropagationInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.ERROR_PROPAGATION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorPropagation getInErrorPropagation() {
		if (inErrorPropagation != null && inErrorPropagation.eIsProxy()) {
			InternalEObject oldInErrorPropagation = (InternalEObject) inErrorPropagation;
			inErrorPropagation = (ErrorPropagation) eResolveProxy(oldInErrorPropagation);
			if (inErrorPropagation != oldInErrorPropagation) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION, oldInErrorPropagation,
							inErrorPropagation));
				}
			}
		}
		return inErrorPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorPropagation basicGetInErrorPropagation() {
		return inErrorPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInErrorPropagation(ErrorPropagation newInErrorPropagation) {
		ErrorPropagation oldInErrorPropagation = inErrorPropagation;
		inErrorPropagation = newInErrorPropagation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION, oldInErrorPropagation,
					inErrorPropagation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorPropagation getOutErrorPropagation() {
		if (outErrorPropagation != null && outErrorPropagation.eIsProxy()) {
			InternalEObject oldOutErrorPropagation = (InternalEObject) outErrorPropagation;
			outErrorPropagation = (ErrorPropagation) eResolveProxy(oldOutErrorPropagation);
			if (outErrorPropagation != oldOutErrorPropagation) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION,
							oldOutErrorPropagation, outErrorPropagation));
				}
			}
		}
		return outErrorPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorPropagation basicGetOutErrorPropagation() {
		return outErrorPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutErrorPropagation(ErrorPropagation newOutErrorPropagation) {
		ErrorPropagation oldOutErrorPropagation = outErrorPropagation;
		outErrorPropagation = newOutErrorPropagation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION, oldOutErrorPropagation,
					outErrorPropagation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypeTokenInstance> getInTokens() {
		if (inTokens == null) {
			inTokens = new EObjectContainmentEList<>(TypeTokenInstance.class, this,
					EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TOKENS);
		}
		return inTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypeTokenInstance> getOutTokens() {
		if (outTokens == null) {
			outTokens = new EObjectContainmentEList<>(TypeTokenInstance.class, this,
					EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TOKENS);
		}
		return outTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public DirectionType getDirection() {
		if (!getInTokens().isEmpty()) {
			if (!getOutTokens().isEmpty()) {
				return DirectionType.IN_OUT;
			} else {
				return DirectionType.IN;
			}
		} else if (!getOutTokens().isEmpty()) {
			return DirectionType.OUT;
		} else {
			throw new IllegalStateException("Both inTokens and outTokens are empty.");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<TypeTokenInstance> getAllInTokens() {
		var results = new BasicEList<TypeTokenInstance>();
		for (var token : getInTokens()) {
			if (token instanceof TypeReference || token instanceof TypeProductInstance) {
				results.add(token);
			} else if (token instanceof TypeSetInstance) {
				results.addAll(((TypeSetInstance) token).getAllTokens());
			} else {
				throw new RuntimeException(
						"getInTokens() contains something other than TypeReference, TypeSetInstance, or TypeProductInstance: "
								+ token);
			}
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<TypeTokenInstance> getAllOutTokens() {
		var results = new BasicEList<TypeTokenInstance>();
		for (var token : getOutTokens()) {
			if (token instanceof TypeReference || token instanceof TypeProductInstance) {
				results.add(token);
			} else if (token instanceof TypeSetInstance) {
				results.addAll(((TypeSetInstance) token).getAllTokens());
			} else {
				throw new RuntimeException(
						"getOutTokens() contains something other than TypeReference, TypeSetInstance, or TypeProductInstance: "
								+ token);
			}
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TOKENS:
			return ((InternalEList<?>) getInTokens()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TOKENS:
			return ((InternalEList<?>) getOutTokens()).basicRemove(otherEnd, msgs);
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
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION:
			if (resolve) {
				return getInErrorPropagation();
			}
			return basicGetInErrorPropagation();
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION:
			if (resolve) {
				return getOutErrorPropagation();
			}
			return basicGetOutErrorPropagation();
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TOKENS:
			return getInTokens();
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TOKENS:
			return getOutTokens();
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
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION:
			setInErrorPropagation((ErrorPropagation) newValue);
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION:
			setOutErrorPropagation((ErrorPropagation) newValue);
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TOKENS:
			getInTokens().clear();
			getInTokens().addAll((Collection<? extends TypeTokenInstance>) newValue);
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TOKENS:
			getOutTokens().clear();
			getOutTokens().addAll((Collection<? extends TypeTokenInstance>) newValue);
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
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION:
			setInErrorPropagation((ErrorPropagation) null);
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION:
			setOutErrorPropagation((ErrorPropagation) null);
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TOKENS:
			getInTokens().clear();
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TOKENS:
			getOutTokens().clear();
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
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION:
			return inErrorPropagation != null;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION:
			return outErrorPropagation != null;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TOKENS:
			return inTokens != null && !inTokens.isEmpty();
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TOKENS:
			return outTokens != null && !outTokens.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ErrorPropagationInstanceImpl
