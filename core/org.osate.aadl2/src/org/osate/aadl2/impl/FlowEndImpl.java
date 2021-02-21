/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowEnd;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.FlowEndImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowEndImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowEndImpl#getArrayRange <em>Array Range</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FlowEndImpl extends ElementImpl implements FlowEnd {
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected FlowEnd context;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature feature;

	/**
	 * The cached value of the '{@link #getArrayRange() <em>Array Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayRange()
	 * @generated
	 * @ordered
	 */
	protected ArrayRange arrayRange;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getFlowEnd();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowEnd getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(FlowEnd newContext, NotificationChain msgs) {
		FlowEnd oldContext = context;
		context = newContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.FLOW_END__CONTEXT, oldContext, newContext);
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
	public void setContext(FlowEnd newContext) {
		if (newContext != context) {
			NotificationChain msgs = null;
			if (context != null) {
				msgs = ((InternalEObject) context).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.FLOW_END__CONTEXT, null, msgs);
			}
			if (newContext != null) {
				msgs = ((InternalEObject) newContext).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.FLOW_END__CONTEXT, null, msgs);
			}
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_END__CONTEXT, newContext,
					newContext));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowEnd createContext() {
		FlowEnd newContext = (FlowEnd) create(Aadl2Package.eINSTANCE.getFlowEnd());
		setContext(newContext);
		return newContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getFeature() {
		if (feature != null && ((EObject) feature).eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject) feature;
			feature = (Feature) eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.FLOW_END__FEATURE,
							oldFeature, feature));
				}
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(Feature newFeature) {
		Feature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_END__FEATURE, oldFeature, feature));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayRange getArrayRange() {
		return arrayRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArrayRange(ArrayRange newArrayRange, NotificationChain msgs) {
		ArrayRange oldArrayRange = arrayRange;
		arrayRange = newArrayRange;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.FLOW_END__ARRAY_RANGE, oldArrayRange, newArrayRange);
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
	public void setArrayRange(ArrayRange newArrayRange) {
		if (newArrayRange != arrayRange) {
			NotificationChain msgs = null;
			if (arrayRange != null) {
				msgs = ((InternalEObject) arrayRange).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.FLOW_END__ARRAY_RANGE, null, msgs);
			}
			if (newArrayRange != null) {
				msgs = ((InternalEObject) newArrayRange).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.FLOW_END__ARRAY_RANGE, null, msgs);
			}
			msgs = basicSetArrayRange(newArrayRange, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_END__ARRAY_RANGE, newArrayRange,
					newArrayRange));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayRange createArrayRange() {
		ArrayRange newArrayRange = (ArrayRange) create(Aadl2Package.eINSTANCE.getArrayRange());
		setArrayRange(newArrayRange);
		return newArrayRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.FLOW_END__CONTEXT:
			return basicSetContext(null, msgs);
		case Aadl2Package.FLOW_END__ARRAY_RANGE:
			return basicSetArrayRange(null, msgs);
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
		case Aadl2Package.FLOW_END__CONTEXT:
			return getContext();
		case Aadl2Package.FLOW_END__FEATURE:
			if (resolve) {
				return getFeature();
			}
			return basicGetFeature();
		case Aadl2Package.FLOW_END__ARRAY_RANGE:
			return getArrayRange();
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
		case Aadl2Package.FLOW_END__CONTEXT:
			setContext((FlowEnd) newValue);
			return;
		case Aadl2Package.FLOW_END__FEATURE:
			setFeature((Feature) newValue);
			return;
		case Aadl2Package.FLOW_END__ARRAY_RANGE:
			setArrayRange((ArrayRange) newValue);
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
		case Aadl2Package.FLOW_END__CONTEXT:
			setContext((FlowEnd) null);
			return;
		case Aadl2Package.FLOW_END__FEATURE:
			setFeature((Feature) null);
			return;
		case Aadl2Package.FLOW_END__ARRAY_RANGE:
			setArrayRange((ArrayRange) null);
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
		case Aadl2Package.FLOW_END__CONTEXT:
			return context != null;
		case Aadl2Package.FLOW_END__FEATURE:
			return feature != null;
		case Aadl2Package.FLOW_END__ARRAY_RANGE:
			return arrayRange != null;
		}
		return super.eIsSet(featureID);
	}

	public boolean hasIndex() {
		return arrayRange != null;
	}

	public int getIndex() {
		return hasIndex() ? (int) arrayRange.getLowerBound() : -1;
	}

} // FlowEndImpl
