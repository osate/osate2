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
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPathInstanceImpl#getSourcePropagation <em>Source Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPathInstanceImpl#getSourceTypeSet <em>Source Type Set</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPathInstanceImpl#getDestinationPropagation <em>Destination Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPathInstanceImpl#getDestinationTypeToken <em>Destination Type Token</em>}</li>
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
	 * The cached value of the '{@link #getSourcePropagation() <em>Source Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePropagation()
	 * @generated
	 * @ordered
	 */
	protected ErrorPropagationInstance sourcePropagation;

	/**
	 * The cached value of the '{@link #getSourceTypeSet() <em>Source Type Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceTypeSet()
	 * @generated
	 * @ordered
	 */
	protected AnonymousTypeSet sourceTypeSet;

	/**
	 * The cached value of the '{@link #getDestinationPropagation() <em>Destination Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationPropagation()
	 * @generated
	 * @ordered
	 */
	protected ErrorPropagationInstance destinationPropagation;

	/**
	 * The cached value of the '{@link #getDestinationTypeToken() <em>Destination Type Token</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationTypeToken()
	 * @generated
	 * @ordered
	 */
	protected TypeTokenInstance destinationTypeToken;

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
	public ErrorPropagationInstance getSourcePropagation() {
		return sourcePropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourcePropagation(ErrorPropagationInstance newSourcePropagation,
			NotificationChain msgs) {
		ErrorPropagationInstance oldSourcePropagation = sourcePropagation;
		sourcePropagation = newSourcePropagation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_PROPAGATION, oldSourcePropagation,
					newSourcePropagation);
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
	public void setSourcePropagation(ErrorPropagationInstance newSourcePropagation) {
		if (newSourcePropagation != sourcePropagation) {
			NotificationChain msgs = null;
			if (sourcePropagation != null) {
				msgs = ((InternalEObject) sourcePropagation).eInverseRemove(this,
						EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS,
						ErrorPropagationInstance.class, msgs);
			}
			if (newSourcePropagation != null) {
				msgs = ((InternalEObject) newSourcePropagation).eInverseAdd(this,
						EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS,
						ErrorPropagationInstance.class, msgs);
			}
			msgs = basicSetSourcePropagation(newSourcePropagation, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_PROPAGATION, newSourcePropagation,
					newSourcePropagation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorPropagationInstance getDestinationPropagation() {
		return destinationPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestinationPropagation(ErrorPropagationInstance newDestinationPropagation,
			NotificationChain msgs) {
		ErrorPropagationInstance oldDestinationPropagation = destinationPropagation;
		destinationPropagation = newDestinationPropagation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_PROPAGATION, oldDestinationPropagation,
					newDestinationPropagation);
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
	public void setDestinationPropagation(ErrorPropagationInstance newDestinationPropagation) {
		if (newDestinationPropagation != destinationPropagation) {
			NotificationChain msgs = null;
			if (destinationPropagation != null) {
				msgs = ((InternalEObject) destinationPropagation).eInverseRemove(this,
						EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS,
						ErrorPropagationInstance.class, msgs);
			}
			if (newDestinationPropagation != null) {
				msgs = ((InternalEObject) newDestinationPropagation).eInverseAdd(this,
						EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS,
						ErrorPropagationInstance.class, msgs);
			}
			msgs = basicSetDestinationPropagation(newDestinationPropagation, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_PROPAGATION, newDestinationPropagation,
					newDestinationPropagation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnonymousTypeSet getSourceTypeSet() {
		return sourceTypeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceTypeSet(AnonymousTypeSet newSourceTypeSet, NotificationChain msgs) {
		AnonymousTypeSet oldSourceTypeSet = sourceTypeSet;
		sourceTypeSet = newSourceTypeSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_TYPE_SET, oldSourceTypeSet, newSourceTypeSet);
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
	public void setSourceTypeSet(AnonymousTypeSet newSourceTypeSet) {
		if (newSourceTypeSet != sourceTypeSet) {
			NotificationChain msgs = null;
			if (sourceTypeSet != null) {
				msgs = ((InternalEObject) sourceTypeSet).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_TYPE_SET, null, msgs);
			}
			if (newSourceTypeSet != null) {
				msgs = ((InternalEObject) newSourceTypeSet).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_TYPE_SET, null, msgs);
			}
			msgs = basicSetSourceTypeSet(newSourceTypeSet, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_TYPE_SET, newSourceTypeSet, newSourceTypeSet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeTokenInstance getDestinationTypeToken() {
		return destinationTypeToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestinationTypeToken(TypeTokenInstance newDestinationTypeToken,
			NotificationChain msgs) {
		TypeTokenInstance oldDestinationTypeToken = destinationTypeToken;
		destinationTypeToken = newDestinationTypeToken;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_TYPE_TOKEN, oldDestinationTypeToken,
					newDestinationTypeToken);
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
	public void setDestinationTypeToken(TypeTokenInstance newDestinationTypeToken) {
		if (newDestinationTypeToken != destinationTypeToken) {
			NotificationChain msgs = null;
			if (destinationTypeToken != null) {
				msgs = ((InternalEObject) destinationTypeToken).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_TYPE_TOKEN, null,
						msgs);
			}
			if (newDestinationTypeToken != null) {
				msgs = ((InternalEObject) newDestinationTypeToken).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_TYPE_TOKEN, null,
						msgs);
			}
			msgs = basicSetDestinationTypeToken(newDestinationTypeToken, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_TYPE_TOKEN, newDestinationTypeToken,
					newDestinationTypeToken));
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
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_PROPAGATION:
			if (sourcePropagation != null) {
				msgs = ((InternalEObject) sourcePropagation).eInverseRemove(this,
						EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS,
						ErrorPropagationInstance.class, msgs);
			}
			return basicSetSourcePropagation((ErrorPropagationInstance) otherEnd, msgs);
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_PROPAGATION:
			if (destinationPropagation != null) {
				msgs = ((InternalEObject) destinationPropagation).eInverseRemove(this,
						EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS,
						ErrorPropagationInstance.class, msgs);
			}
			return basicSetDestinationPropagation((ErrorPropagationInstance) otherEnd, msgs);
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
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_PROPAGATION:
			return basicSetSourcePropagation(null, msgs);
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_TYPE_SET:
			return basicSetSourceTypeSet(null, msgs);
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_PROPAGATION:
			return basicSetDestinationPropagation(null, msgs);
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_TYPE_TOKEN:
			return basicSetDestinationTypeToken(null, msgs);
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
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_PROPAGATION:
			return getSourcePropagation();
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_TYPE_SET:
			return getSourceTypeSet();
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_PROPAGATION:
			return getDestinationPropagation();
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_TYPE_TOKEN:
			return getDestinationTypeToken();
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
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_PROPAGATION:
			setSourcePropagation((ErrorPropagationInstance) newValue);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_TYPE_SET:
			setSourceTypeSet((AnonymousTypeSet) newValue);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_PROPAGATION:
			setDestinationPropagation((ErrorPropagationInstance) newValue);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_TYPE_TOKEN:
			setDestinationTypeToken((TypeTokenInstance) newValue);
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
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_PROPAGATION:
			setSourcePropagation((ErrorPropagationInstance) null);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_TYPE_SET:
			setSourceTypeSet((AnonymousTypeSet) null);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_PROPAGATION:
			setDestinationPropagation((ErrorPropagationInstance) null);
			return;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_TYPE_TOKEN:
			setDestinationTypeToken((TypeTokenInstance) null);
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
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_PROPAGATION:
			return sourcePropagation != null;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_TYPE_SET:
			return sourceTypeSet != null;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_PROPAGATION:
			return destinationPropagation != null;
		case EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_TYPE_TOKEN:
			return destinationTypeToken != null;
		}
		return super.eIsSet(featureID);
	}

} // ErrorPathInstanceImpl
