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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.ErrorPathInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationInstance;
import org.osate.aadl2.errormodel.instance.TypeTokenInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Path Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPathInstanceImpl#getErrorPath <em>Error Path</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPathInstanceImpl#getIncomingPropagation <em>Incoming Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPathInstanceImpl#getOutgoingPropagation <em>Outgoing Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPathInstanceImpl#getIncomingTypeSet <em>Incoming Type Set</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPathInstanceImpl#getOutgoingTypeToken <em>Outgoing Type Token</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorPathInstanceImpl extends ErrorFlowInstanceImpl implements ErrorPathInstance {
	/**
	 * The cached value of the '{@link #getErrorPath() <em>Error Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorPath()
	 * @generated
	 * @ordered
	 */
	protected ErrorPath errorPath;

	/**
	 * The cached value of the '{@link #getIncomingPropagation() <em>Incoming Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingPropagation()
	 * @generated
	 * @ordered
	 */
	protected ErrorPropagationInstance incomingPropagation;

	/**
	 * The cached value of the '{@link #getOutgoingPropagation() <em>Outgoing Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingPropagation()
	 * @generated
	 * @ordered
	 */
	protected ErrorPropagationInstance outgoingPropagation;

	/**
	 * The cached value of the '{@link #getIncomingTypeSet() <em>Incoming Type Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingTypeSet()
	 * @generated
	 * @ordered
	 */
	protected AnonymousTypeSet incomingTypeSet;

	/**
	 * The cached value of the '{@link #getOutgoingTypeToken() <em>Outgoing Type Token</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingTypeToken()
	 * @generated
	 * @ordered
	 */
	protected TypeTokenInstance outgoingTypeToken;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorPathInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.ERROR_PATH_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorPath getErrorPath() {
		if (errorPath != null && errorPath.eIsProxy()) {
			InternalEObject oldErrorPath = (InternalEObject) errorPath;
			errorPath = (ErrorPath) eResolveProxy(oldErrorPath);
			if (errorPath != oldErrorPath) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.ERROR_PATH_INSTANCE__ERROR_PATH, oldErrorPath, errorPath));
				}
			}
		}
		return errorPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorPath basicGetErrorPath() {
		return errorPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setErrorPath(ErrorPath newErrorPath) {
		ErrorPath oldErrorPath = errorPath;
		errorPath = newErrorPath;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.ERROR_PATH_INSTANCE__ERROR_PATH,
					oldErrorPath, errorPath));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorPropagationInstance getIncomingPropagation() {
		return incomingPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncomingPropagation(ErrorPropagationInstance newIncomingPropagation,
			NotificationChain msgs) {
		ErrorPropagationInstance oldIncomingPropagation = incomingPropagation;
		incomingPropagation = newIncomingPropagation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_PROPAGATION, oldIncomingPropagation,
					newIncomingPropagation);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIncomingPropagation(ErrorPropagationInstance newIncomingPropagation) {
		if (newIncomingPropagation != incomingPropagation) {
			NotificationChain msgs = null;
			if (incomingPropagation != null) {
				msgs = ((InternalEObject) incomingPropagation).eInverseRemove(this,
						EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__INCOMING_ERROR_PATHS,
						ErrorPropagationInstance.class, msgs);
			}
			if (newIncomingPropagation != null) {
				msgs = ((InternalEObject) newIncomingPropagation).eInverseAdd(this,
						EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__INCOMING_ERROR_PATHS,
						ErrorPropagationInstance.class, msgs);
			}
			msgs = basicSetIncomingPropagation(newIncomingPropagation, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_PROPAGATION, newIncomingPropagation,
					newIncomingPropagation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorPropagationInstance getOutgoingPropagation() {
		return outgoingPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutgoingPropagation(ErrorPropagationInstance newOutgoingPropagation,
			NotificationChain msgs) {
		ErrorPropagationInstance oldOutgoingPropagation = outgoingPropagation;
		outgoingPropagation = newOutgoingPropagation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_PROPAGATION, oldOutgoingPropagation,
					newOutgoingPropagation);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutgoingPropagation(ErrorPropagationInstance newOutgoingPropagation) {
		if (newOutgoingPropagation != outgoingPropagation) {
			NotificationChain msgs = null;
			if (outgoingPropagation != null) {
				msgs = ((InternalEObject) outgoingPropagation).eInverseRemove(this,
						EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUTGOING_ERROR_PATHS,
						ErrorPropagationInstance.class, msgs);
			}
			if (newOutgoingPropagation != null) {
				msgs = ((InternalEObject) newOutgoingPropagation).eInverseAdd(this,
						EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUTGOING_ERROR_PATHS,
						ErrorPropagationInstance.class, msgs);
			}
			msgs = basicSetOutgoingPropagation(newOutgoingPropagation, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_PROPAGATION, newOutgoingPropagation,
					newOutgoingPropagation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnonymousTypeSet getIncomingTypeSet() {
		return incomingTypeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncomingTypeSet(AnonymousTypeSet newIncomingTypeSet, NotificationChain msgs) {
		AnonymousTypeSet oldIncomingTypeSet = incomingTypeSet;
		incomingTypeSet = newIncomingTypeSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_TYPE_SET, oldIncomingTypeSet, newIncomingTypeSet);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIncomingTypeSet(AnonymousTypeSet newIncomingTypeSet) {
		if (newIncomingTypeSet != incomingTypeSet) {
			NotificationChain msgs = null;
			if (incomingTypeSet != null) {
				msgs = ((InternalEObject) incomingTypeSet).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_TYPE_SET, null,
						msgs);
			}
			if (newIncomingTypeSet != null) {
				msgs = ((InternalEObject) newIncomingTypeSet).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_TYPE_SET, null,
						msgs);
			}
			msgs = basicSetIncomingTypeSet(newIncomingTypeSet, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_TYPE_SET, newIncomingTypeSet,
					newIncomingTypeSet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeTokenInstance getOutgoingTypeToken() {
		return outgoingTypeToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutgoingTypeToken(TypeTokenInstance newOutgoingTypeToken, NotificationChain msgs) {
		TypeTokenInstance oldOutgoingTypeToken = outgoingTypeToken;
		outgoingTypeToken = newOutgoingTypeToken;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_TYPE_TOKEN, oldOutgoingTypeToken,
					newOutgoingTypeToken);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutgoingTypeToken(TypeTokenInstance newOutgoingTypeToken) {
		if (newOutgoingTypeToken != outgoingTypeToken) {
			NotificationChain msgs = null;
			if (outgoingTypeToken != null) {
				msgs = ((InternalEObject) outgoingTypeToken).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_TYPE_TOKEN, null,
						msgs);
			}
			if (newOutgoingTypeToken != null) {
				msgs = ((InternalEObject) newOutgoingTypeToken).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_TYPE_TOKEN, null,
						msgs);
			}
			msgs = basicSetOutgoingTypeToken(newOutgoingTypeToken, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_TYPE_TOKEN, newOutgoingTypeToken,
					newOutgoingTypeToken));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_PROPAGATION:
			if (incomingPropagation != null) {
				msgs = ((InternalEObject) incomingPropagation).eInverseRemove(this,
						EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__INCOMING_ERROR_PATHS,
						ErrorPropagationInstance.class, msgs);
			}
			return basicSetIncomingPropagation((ErrorPropagationInstance) otherEnd, msgs);
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_PROPAGATION:
			if (outgoingPropagation != null) {
				msgs = ((InternalEObject) outgoingPropagation).eInverseRemove(this,
						EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUTGOING_ERROR_PATHS,
						ErrorPropagationInstance.class, msgs);
			}
			return basicSetOutgoingPropagation((ErrorPropagationInstance) otherEnd, msgs);
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
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_PROPAGATION:
			return basicSetIncomingPropagation(null, msgs);
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_PROPAGATION:
			return basicSetOutgoingPropagation(null, msgs);
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_TYPE_SET:
			return basicSetIncomingTypeSet(null, msgs);
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_TYPE_TOKEN:
			return basicSetOutgoingTypeToken(null, msgs);
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
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__ERROR_PATH:
			if (resolve) {
				return getErrorPath();
			}
			return basicGetErrorPath();
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_PROPAGATION:
			return getIncomingPropagation();
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_PROPAGATION:
			return getOutgoingPropagation();
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_TYPE_SET:
			return getIncomingTypeSet();
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_TYPE_TOKEN:
			return getOutgoingTypeToken();
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
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__ERROR_PATH:
			setErrorPath((ErrorPath) newValue);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_PROPAGATION:
			setIncomingPropagation((ErrorPropagationInstance) newValue);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_PROPAGATION:
			setOutgoingPropagation((ErrorPropagationInstance) newValue);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_TYPE_SET:
			setIncomingTypeSet((AnonymousTypeSet) newValue);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_TYPE_TOKEN:
			setOutgoingTypeToken((TypeTokenInstance) newValue);
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
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__ERROR_PATH:
			setErrorPath((ErrorPath) null);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_PROPAGATION:
			setIncomingPropagation((ErrorPropagationInstance) null);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_PROPAGATION:
			setOutgoingPropagation((ErrorPropagationInstance) null);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_TYPE_SET:
			setIncomingTypeSet((AnonymousTypeSet) null);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_TYPE_TOKEN:
			setOutgoingTypeToken((TypeTokenInstance) null);
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
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__ERROR_PATH:
			return errorPath != null;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_PROPAGATION:
			return incomingPropagation != null;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_PROPAGATION:
			return outgoingPropagation != null;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__INCOMING_TYPE_SET:
			return incomingTypeSet != null;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__OUTGOING_TYPE_TOKEN:
			return outgoingTypeToken != null;
		}
		return super.eIsSet(featureID);
	}

} // ErrorPathInstanceImpl
