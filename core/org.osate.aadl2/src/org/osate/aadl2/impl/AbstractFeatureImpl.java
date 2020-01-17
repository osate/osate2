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
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.FeatureClassifier;
import org.osate.aadl2.FeaturePrototype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.AbstractFeatureImpl#getFeatureClassifier <em>Feature Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractFeatureImpl#getFeaturePrototype <em>Feature Prototype</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractFeatureImpl#getAbstractFeatureClassifier <em>Abstract Feature Classifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractFeatureImpl extends DirectedFeatureImpl implements AbstractFeature {
	/**
	 * The cached value of the '{@link #getFeaturePrototype() <em>Feature Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturePrototype()
	 * @generated
	 * @ordered
	 */
	protected FeaturePrototype featurePrototype;

	/**
	 * The cached value of the '{@link #getAbstractFeatureClassifier() <em>Abstract Feature Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractFeatureClassifier()
	 * @generated
	 * @ordered
	 */
	protected FeatureClassifier abstractFeatureClassifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getAbstractFeature();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureClassifier getFeatureClassifier() {
		FeatureClassifier featureClassifier = basicGetFeatureClassifier();
		return featureClassifier != null && ((EObject) featureClassifier).eIsProxy()
				? (FeatureClassifier) eResolveProxy((InternalEObject) featureClassifier)
				: featureClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureClassifier basicGetFeatureClassifier() {
		if (eIsSet(Aadl2Package.ABSTRACT_FEATURE__ABSTRACT_FEATURE_CLASSIFIER)) {
			return basicGetAbstractFeatureClassifier();
		}
		return super.basicGetFeatureClassifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeaturePrototype getFeaturePrototype() {
		if (featurePrototype != null && ((EObject) featurePrototype).eIsProxy()) {
			InternalEObject oldFeaturePrototype = (InternalEObject) featurePrototype;
			featurePrototype = (FeaturePrototype) eResolveProxy(oldFeaturePrototype);
			if (featurePrototype != oldFeaturePrototype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.ABSTRACT_FEATURE__FEATURE_PROTOTYPE, oldFeaturePrototype, featurePrototype));
			}
		}
		return featurePrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeaturePrototype basicGetFeaturePrototype() {
		return featurePrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeaturePrototype(FeaturePrototype newFeaturePrototype) {
		FeaturePrototype oldFeaturePrototype = featurePrototype;
		featurePrototype = newFeaturePrototype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.ABSTRACT_FEATURE__FEATURE_PROTOTYPE,
					oldFeaturePrototype, featurePrototype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureClassifier getAbstractFeatureClassifier() {
		if (abstractFeatureClassifier != null && ((EObject) abstractFeatureClassifier).eIsProxy()) {
			InternalEObject oldAbstractFeatureClassifier = (InternalEObject) abstractFeatureClassifier;
			abstractFeatureClassifier = (FeatureClassifier) eResolveProxy(oldAbstractFeatureClassifier);
			if (abstractFeatureClassifier != oldAbstractFeatureClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.ABSTRACT_FEATURE__ABSTRACT_FEATURE_CLASSIFIER, oldAbstractFeatureClassifier,
							abstractFeatureClassifier));
			}
		}
		return abstractFeatureClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureClassifier basicGetAbstractFeatureClassifier() {
		return abstractFeatureClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractFeatureClassifier(FeatureClassifier newAbstractFeatureClassifier) {
		FeatureClassifier oldAbstractFeatureClassifier = abstractFeatureClassifier;
		abstractFeatureClassifier = newAbstractFeatureClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.ABSTRACT_FEATURE__ABSTRACT_FEATURE_CLASSIFIER, oldAbstractFeatureClassifier,
					abstractFeatureClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.ABSTRACT_FEATURE__FEATURE_PROTOTYPE:
			if (resolve)
				return getFeaturePrototype();
			return basicGetFeaturePrototype();
		case Aadl2Package.ABSTRACT_FEATURE__ABSTRACT_FEATURE_CLASSIFIER:
			if (resolve)
				return getAbstractFeatureClassifier();
			return basicGetAbstractFeatureClassifier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.ABSTRACT_FEATURE__FEATURE_PROTOTYPE:
			setFeaturePrototype((FeaturePrototype) newValue);
			return;
		case Aadl2Package.ABSTRACT_FEATURE__ABSTRACT_FEATURE_CLASSIFIER:
			setAbstractFeatureClassifier((FeatureClassifier) newValue);
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
		case Aadl2Package.ABSTRACT_FEATURE__FEATURE_PROTOTYPE:
			setFeaturePrototype((FeaturePrototype) null);
			return;
		case Aadl2Package.ABSTRACT_FEATURE__ABSTRACT_FEATURE_CLASSIFIER:
			setAbstractFeatureClassifier((FeatureClassifier) null);
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
		case Aadl2Package.ABSTRACT_FEATURE__FEATURE_CLASSIFIER:
			return isSetFeatureClassifier();
		case Aadl2Package.ABSTRACT_FEATURE__FEATURE_PROTOTYPE:
			return featurePrototype != null;
		case Aadl2Package.ABSTRACT_FEATURE__ABSTRACT_FEATURE_CLASSIFIER:
			return abstractFeatureClassifier != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFeatureClassifier() {
		return super.isSetFeatureClassifier() || eIsSet(Aadl2Package.ABSTRACT_FEATURE__ABSTRACT_FEATURE_CLASSIFIER);
	}

} // AbstractFeatureImpl
