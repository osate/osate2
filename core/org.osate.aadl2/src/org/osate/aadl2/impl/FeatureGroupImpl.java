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
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.Property;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupImpl#getFeatureType <em>Feature Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupImpl#isInverse <em>Inverse</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupImpl#getFeatureGroupType <em>Feature Group Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupImpl#getFeatureGroupPrototype <em>Feature Group Prototype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureGroupImpl extends DirectedFeatureImpl implements FeatureGroup {
	/**
	 * The cached value of the '{@link #getFeatureType() <em>Feature Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureType()
	 * @generated
	 * @ordered
	 */
	protected FeatureType featureType;
	/**
	 * The default value of the '{@link #isInverse() <em>Inverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInverse()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INVERSE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isInverse() <em>Inverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInverse()
	 * @generated
	 * @ordered
	 */
	protected boolean inverse = INVERSE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getFeatureGroup();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInverse() {
		return inverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInverse(boolean newInverse) {
		boolean oldInverse = inverse;
		inverse = newInverse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FEATURE_GROUP__INVERSE, oldInverse,
					inverse));
	}

	/**
	 * Get the classifier of given feature or its refinement ancestor, if it has one, otherwise null.
	 * @return The classifier, or <code>null</code> if no classifier.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public Classifier getAllClassifier() {
		return getAllFeatureGroupType();
	}

	/**
	 * Get the classifier of given feature, if it has one, otherwise null.
	 * @return The classifier, or <code>null</code> if no classifier.
	 */
	public Classifier getClassifier() {
		return getFeatureGroupType();
	}

	/*
	 * Get the feature group type of given feature group or its refinement ancestor, if it has
	 * one, otherwise null.
	 *
	 * @return The FeatureGroupType, or <code>null</code> if none.
	 */
	public FeatureGroupType getAllFeatureGroupType() {
		FeatureGroupType cc = getFeatureGroupType();
		Feature f = this;
		while (cc == null && f.getRefined() != null) {
			f = f.getRefined();
			if (f instanceof FeatureGroup) {
				cc = ((FeatureGroup) f).getFeatureGroupType();
			}
		}
		return cc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FeatureGroupType getFeatureGroupType() {
		EObject featureGroupType = getFeatureType();
		return (FeatureGroupType) (featureGroupType instanceof FeatureGroupType && !featureGroupType.eIsProxy()
				? featureGroupType
				: null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FeatureGroupType basicGetFeatureGroupType() {
		return (basicGetFeatureType() instanceof FeatureGroupType) ? (FeatureGroupType) basicGetFeatureType() : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FeatureGroupPrototype getFeatureGroupPrototype() {
		EObject featureGroupType = getFeatureType();
		return (FeatureGroupPrototype) (featureGroupType instanceof FeatureGroupPrototype
				&& !featureGroupType.eIsProxy() ? featureGroupType : null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FeatureGroupPrototype basicGetFeatureGroupPrototype() {
		return (basicGetFeatureType() instanceof FeatureGroupPrototype) ? (FeatureGroupPrototype) basicGetFeatureType()
				: null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType getFeatureType() {
		if (featureType != null && ((EObject) featureType).eIsProxy()) {
			InternalEObject oldFeatureType = (InternalEObject) featureType;
			featureType = (FeatureType) eResolveProxy(oldFeatureType);
			if (featureType != oldFeatureType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.FEATURE_GROUP__FEATURE_TYPE,
							oldFeatureType, featureType));
			}
		}
		return featureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType basicGetFeatureType() {
		return featureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureType(FeatureType newFeatureType) {
		FeatureType oldFeatureType = featureType;
		featureType = newFeatureType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FEATURE_GROUP__FEATURE_TYPE,
					oldFeatureType, featureType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.FEATURE_GROUP__FEATURE_TYPE:
			if (resolve)
				return getFeatureType();
			return basicGetFeatureType();
		case Aadl2Package.FEATURE_GROUP__INVERSE:
			return isInverse();
		case Aadl2Package.FEATURE_GROUP__FEATURE_GROUP_TYPE:
			if (resolve)
				return getFeatureGroupType();
			return basicGetFeatureGroupType();
		case Aadl2Package.FEATURE_GROUP__FEATURE_GROUP_PROTOTYPE:
			if (resolve)
				return getFeatureGroupPrototype();
			return basicGetFeatureGroupPrototype();
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
		case Aadl2Package.FEATURE_GROUP__FEATURE_TYPE:
			setFeatureType((FeatureType) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP__INVERSE:
			setInverse((Boolean) newValue);
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
		case Aadl2Package.FEATURE_GROUP__FEATURE_TYPE:
			setFeatureType((FeatureType) null);
			return;
		case Aadl2Package.FEATURE_GROUP__INVERSE:
			setInverse(INVERSE_EDEFAULT);
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
		case Aadl2Package.FEATURE_GROUP__FEATURE_TYPE:
			return featureType != null;
		case Aadl2Package.FEATURE_GROUP__INVERSE:
			return inverse != INVERSE_EDEFAULT;
		case Aadl2Package.FEATURE_GROUP__FEATURE_GROUP_TYPE:
			return basicGetFeatureGroupType() != null;
		case Aadl2Package.FEATURE_GROUP__FEATURE_GROUP_PROTOTYPE:
			return basicGetFeatureGroupPrototype() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (inverse: ");
		result.append(inverse);
		result.append(')');
		return result.toString();
	}

	/**
	 * return the index of the feature in the feature group type
	 * @param feature Feature
	 * @return int index of feature or -1 if not found
	 */
	public int getIndexOf(Feature feature) {
		if (getFeatureGroupType() == null) {
			return -1;
		}
		return getFeatureGroupType().getIndexOf(feature);
	}

	public boolean acceptsProperty(Property property) {
		if (super.acceptsProperty(property)) {
			return true;
		} else if (getFeatureGroupType() != null) {
			return getFeatureGroupType().checkAppliesToClassifier(property);
		} else {
			return false;
		}
	}

	public void getPropertyValueInternalHelper(final Property prop, final PropertyAcc pas,
			final boolean fromInstanceSlaveCall, final boolean all) throws InvalidModelException {
		// values from feature group type
		FeatureGroupType fgt = getFeatureGroupType();
		// TODO: Check if the property applies to the feature group type? (->
		// property.checkAppliesTo(NamedElement)?)
		if (fgt != null) {
			fgt.getPropertyValueInternal(prop, pas, fromInstanceSlaveCall, all);
		}
	}

	public void getPropertyValueTestHelper(Property prop, PropertyAcc pas, Classifier cl) {
		// values from feature group type
		FeatureGroupType fgt = getFeatureGroupType();
		// TODO: Check if the property applies to the feature group type? (->
		// property.checkAppliesTo(NamedElement)?)
		if (fgt != null) {
			fgt.getPropertyValueInternal(prop, pas, true, false);
		} else if (cl != null) {
			cl.getPropertyValueInternal(prop, pas, true, false);
		}
	}

	/**
	 * check for inverseof between two features.
	 * If they are feature groups then we check both the inverse of on the feature group and whether the feature group type is inverseof.
	 * @param f1
	 * @param f2
	 * @return boolean
	 */
	public boolean isInverseOf(FeatureGroup fg2) {
		FeatureGroupType fgt1 = getAllFeatureGroupType();
		FeatureGroupType fgt2 = fg2.getAllFeatureGroupType();
		if (fgt1.isInverseOf(fgt2) && (isInverse() == fg2.isInverse())) {
			return true;
		}
		if (fgt1 == fgt2 && (isInverse() != fg2.isInverse())) {
			return true;
		}
		return false;
	}

} // FeatureGroupImpl
