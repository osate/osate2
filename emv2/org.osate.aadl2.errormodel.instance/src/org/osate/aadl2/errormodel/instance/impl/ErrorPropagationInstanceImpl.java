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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.ErrorPathInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
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
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl#getInTypeSet <em>In Type Set</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl#getOutTypeSet <em>Out Type Set</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl#getErrorSources <em>Error Sources</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl#getErrorSinks <em>Error Sinks</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl#getSourceErrorPaths <em>Source Error Paths</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl#getDestinationErrorPaths <em>Destination Error Paths</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ErrorPropagationInstanceImpl extends EMV2InstanceObjectImpl implements ErrorPropagationInstance {
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
	 * The cached value of the '{@link #getInTypeSet() <em>In Type Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInTypeSet()
	 * @generated
	 * @ordered
	 */
	protected AnonymousTypeSet inTypeSet;

	/**
	 * The cached value of the '{@link #getOutTypeSet() <em>Out Type Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutTypeSet()
	 * @generated
	 * @ordered
	 */
	protected AnonymousTypeSet outTypeSet;

	/**
	 * The cached value of the '{@link #getErrorSources() <em>Error Sources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorSources()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorSourceInstance> errorSources;

	/**
	 * The cached value of the '{@link #getErrorSinks() <em>Error Sinks</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorSinks()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorSinkInstance> errorSinks;

	/**
	 * The cached value of the '{@link #getSourceErrorPaths() <em>Source Error Paths</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceErrorPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorPathInstance> sourceErrorPaths;

	/**
	 * The cached value of the '{@link #getDestinationErrorPaths() <em>Destination Error Paths</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationErrorPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorPathInstance> destinationErrorPaths;

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
	public AnonymousTypeSet getInTypeSet() {
		return inTypeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInTypeSet(AnonymousTypeSet newInTypeSet, NotificationChain msgs) {
		AnonymousTypeSet oldInTypeSet = inTypeSet;
		inTypeSet = newInTypeSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET, oldInTypeSet, newInTypeSet);
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
	public void setInTypeSet(AnonymousTypeSet newInTypeSet) {
		if (newInTypeSet != inTypeSet) {
			NotificationChain msgs = null;
			if (inTypeSet != null) {
				msgs = ((InternalEObject) inTypeSet).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET, null,
						msgs);
			}
			if (newInTypeSet != null) {
				msgs = ((InternalEObject) newInTypeSet).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET, null,
						msgs);
			}
			msgs = basicSetInTypeSet(newInTypeSet, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET, newInTypeSet, newInTypeSet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnonymousTypeSet getOutTypeSet() {
		return outTypeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutTypeSet(AnonymousTypeSet newOutTypeSet, NotificationChain msgs) {
		AnonymousTypeSet oldOutTypeSet = outTypeSet;
		outTypeSet = newOutTypeSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET, oldOutTypeSet, newOutTypeSet);
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
	public void setOutTypeSet(AnonymousTypeSet newOutTypeSet) {
		if (newOutTypeSet != outTypeSet) {
			NotificationChain msgs = null;
			if (outTypeSet != null) {
				msgs = ((InternalEObject) outTypeSet).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET, null,
						msgs);
			}
			if (newOutTypeSet != null) {
				msgs = ((InternalEObject) newOutTypeSet).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET, null,
						msgs);
			}
			msgs = basicSetOutTypeSet(newOutTypeSet, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET, newOutTypeSet, newOutTypeSet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ErrorSourceInstance> getErrorSources() {
		if (errorSources == null) {
			errorSources = new EObjectWithInverseResolvingEList<>(ErrorSourceInstance.class, this,
					EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES,
					EMV2InstancePackage.ERROR_SOURCE_INSTANCE__PROPAGATION);
		}
		return errorSources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ErrorSinkInstance> getErrorSinks() {
		if (errorSinks == null) {
			errorSinks = new EObjectWithInverseResolvingEList<>(ErrorSinkInstance.class, this,
					EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SINKS,
					EMV2InstancePackage.ERROR_SINK_INSTANCE__PROPAGATION);
		}
		return errorSinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ErrorPathInstance> getSourceErrorPaths() {
		if (sourceErrorPaths == null) {
			sourceErrorPaths = new EObjectWithInverseResolvingEList<>(ErrorPathInstance.class, this,
					EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__SOURCE_PROPAGATION);
		}
		return sourceErrorPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ErrorPathInstance> getDestinationErrorPaths() {
		if (destinationErrorPaths == null) {
			destinationErrorPaths = new EObjectWithInverseResolvingEList<>(ErrorPathInstance.class,
					this, EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS,
					EMV2InstancePackage.ERROR_PATH_INSTANCE__DESTINATION_PROPAGATION);
		}
		return destinationErrorPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public DirectionType getDirection() {
		if (getInTypeSet() != null) {
			if (getOutTypeSet() != null) {
				return DirectionType.IN_OUT;
			} else {
				return DirectionType.IN;
			}
		} else if (getOutTypeSet() != null) {
			return DirectionType.OUT;
		} else {
			throw new IllegalStateException("Bot inTypeSet and outTypeSet are null.");
		}
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
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getErrorSources()).basicAdd(otherEnd, msgs);
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SINKS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getErrorSinks()).basicAdd(otherEnd, msgs);
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSourceErrorPaths()).basicAdd(otherEnd, msgs);
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDestinationErrorPaths()).basicAdd(otherEnd,
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
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET:
			return basicSetInTypeSet(null, msgs);
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET:
			return basicSetOutTypeSet(null, msgs);
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES:
			return ((InternalEList<?>) getErrorSources()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SINKS:
			return ((InternalEList<?>) getErrorSinks()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS:
			return ((InternalEList<?>) getSourceErrorPaths()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS:
			return ((InternalEList<?>) getDestinationErrorPaths()).basicRemove(otherEnd, msgs);
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
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET:
			return getInTypeSet();
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET:
			return getOutTypeSet();
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES:
			return getErrorSources();
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SINKS:
			return getErrorSinks();
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS:
			return getSourceErrorPaths();
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS:
			return getDestinationErrorPaths();
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
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET:
			setInTypeSet((AnonymousTypeSet) newValue);
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET:
			setOutTypeSet((AnonymousTypeSet) newValue);
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES:
			getErrorSources().clear();
			getErrorSources().addAll((Collection<? extends ErrorSourceInstance>) newValue);
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SINKS:
			getErrorSinks().clear();
			getErrorSinks().addAll((Collection<? extends ErrorSinkInstance>) newValue);
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS:
			getSourceErrorPaths().clear();
			getSourceErrorPaths().addAll((Collection<? extends ErrorPathInstance>) newValue);
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS:
			getDestinationErrorPaths().clear();
			getDestinationErrorPaths().addAll((Collection<? extends ErrorPathInstance>) newValue);
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
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET:
			setInTypeSet((AnonymousTypeSet) null);
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET:
			setOutTypeSet((AnonymousTypeSet) null);
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES:
			getErrorSources().clear();
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SINKS:
			getErrorSinks().clear();
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS:
			getSourceErrorPaths().clear();
			return;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS:
			getDestinationErrorPaths().clear();
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
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET:
			return inTypeSet != null;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET:
			return outTypeSet != null;
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES:
			return errorSources != null && !errorSources.isEmpty();
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__ERROR_SINKS:
			return errorSinks != null && !errorSinks.isEmpty();
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS:
			return sourceErrorPaths != null && !sourceErrorPaths.isEmpty();
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS:
			return destinationErrorPaths != null && !destinationErrorPaths.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public List<? extends NamedElement> getInstantiatedObjects() {
		var instantiatedObjects = new ArrayList<ErrorPropagation>();
		if (getInErrorPropagation() != null) {
			instantiatedObjects.add(getInErrorPropagation());
		}
		if (getOutErrorPropagation() != null) {
			instantiatedObjects.add(getOutErrorPropagation());
		}
		return instantiatedObjects;
	}
} // ErrorPropagationInstanceImpl
