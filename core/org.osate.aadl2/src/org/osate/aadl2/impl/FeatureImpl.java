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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArrayableElement;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureClassifier;
import org.osate.aadl2.FeatureConnectionEnd;
import org.osate.aadl2.Property;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.FeatureImpl#getArrayDimensions <em>Array Dimension</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureImpl#getFeatureClassifier <em>Feature Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureImpl#getRefinedElement <em>Refined Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureImpl#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureImpl#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureImpl#getClassifier <em>Classifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FeatureImpl extends StructuralFeatureImpl implements Feature {
	/**
	 * The cached value of the '{@link #getArrayDimensions() <em>Array Dimension</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ArrayDimension> arrayDimensions;

	/**
	 * The cached value of the '{@link #getRefined() <em>Refined</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefined()
	 * @generated
	 * @ordered
	 */
	protected Feature refined;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getFeature();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArrayDimension> getArrayDimensions() {
		if (arrayDimensions == null) {
			arrayDimensions = new EObjectContainmentEList<ArrayDimension>(ArrayDimension.class, this,
					Aadl2Package.FEATURE__ARRAY_DIMENSION);
		}
		return arrayDimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayDimension createArrayDimension() {
		ArrayDimension newArrayDimension = (ArrayDimension) create(Aadl2Package.eINSTANCE.getArrayDimension());
		getArrayDimensions().add(newArrayDimension);
		return newArrayDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
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
	 * @generated NOT
	 */
	public FeatureClassifier basicGetFeatureClassifier() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Classifier getClassifier() {
		EObject classifier = getFeatureClassifier();
		return (ComponentClassifier) (classifier instanceof ComponentClassifier && !classifier.eIsProxy() ? classifier
				: null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComponentClassifier basicGetClassifier() {
		// DONE: implement this method to return the 'Classifier' reference
		return (basicGetFeatureClassifier() instanceof ComponentClassifier)
				? (ComponentClassifier) basicGetFeatureClassifier()
				: null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComponentPrototype getPrototype() {
		EObject prototype = getFeatureClassifier();
		return (ComponentPrototype) (prototype instanceof ComponentPrototype && !prototype.eIsProxy() ? prototype
				: null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComponentPrototype basicGetPrototype() {
		// DONE: implement this method to return the 'Prototype' reference
		return (basicGetFeatureClassifier() instanceof ComponentPrototype)
				? (ComponentPrototype) basicGetFeatureClassifier()
				: null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getRefined() {
		if (refined != null && ((EObject) refined).eIsProxy()) {
			InternalEObject oldRefined = (InternalEObject) refined;
			refined = (Feature) eResolveProxy(oldRefined);
			if (refined != oldRefined) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.FEATURE__REFINED, oldRefined,
							refined));
				}
			}
		}
		return refined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetRefined() {
		return refined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefined(Feature newRefined) {
		Feature oldRefined = refined;
		refined = newRefined;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FEATURE__REFINED, oldRefined, refined));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.FEATURE__ARRAY_DIMENSION:
			return ((InternalEList<?>) getArrayDimensions()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.FEATURE__ARRAY_DIMENSION:
			return getArrayDimensions();
		case Aadl2Package.FEATURE__FEATURE_CLASSIFIER:
			if (resolve) {
				return getFeatureClassifier();
			}
			return basicGetFeatureClassifier();
		case Aadl2Package.FEATURE__PROTOTYPE:
			if (resolve) {
				return getPrototype();
			}
			return basicGetPrototype();
		case Aadl2Package.FEATURE__REFINED:
			if (resolve) {
				return getRefined();
			}
			return basicGetRefined();
		case Aadl2Package.FEATURE__CLASSIFIER:
			if (resolve) {
				return getClassifier();
			}
			return basicGetClassifier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.FEATURE__ARRAY_DIMENSION:
			getArrayDimensions().clear();
			getArrayDimensions().addAll((Collection<? extends ArrayDimension>) newValue);
			return;
		case Aadl2Package.FEATURE__REFINED:
			setRefined((Feature) newValue);
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
		case Aadl2Package.FEATURE__ARRAY_DIMENSION:
			getArrayDimensions().clear();
			return;
		case Aadl2Package.FEATURE__REFINED:
			setRefined((Feature) null);
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
		case Aadl2Package.FEATURE__ARRAY_DIMENSION:
			return arrayDimensions != null && !arrayDimensions.isEmpty();
		case Aadl2Package.FEATURE__FEATURE_CLASSIFIER:
			return isSetFeatureClassifier();
		case Aadl2Package.FEATURE__REFINED_ELEMENT:
			return isSetRefinedElement();
		case Aadl2Package.FEATURE__PROTOTYPE:
			return basicGetPrototype() != null;
		case Aadl2Package.FEATURE__REFINED:
			return refined != null;
		case Aadl2Package.FEATURE__CLASSIFIER:
			return basicGetClassifier() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ConnectionEnd.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == FeatureConnectionEnd.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == ArrayableElement.class) {
			switch (derivedFeatureID) {
			case Aadl2Package.FEATURE__ARRAY_DIMENSION:
				return Aadl2Package.ARRAYABLE_ELEMENT__ARRAY_DIMENSION;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ConnectionEnd.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == FeatureConnectionEnd.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == ArrayableElement.class) {
			switch (baseFeatureID) {
			case Aadl2Package.ARRAYABLE_ELEMENT__ARRAY_DIMENSION:
				return Aadl2Package.FEATURE__ARRAY_DIMENSION;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetFeatureClassifier() {
		return eIsSet(Aadl2Package.FEATURE__PROTOTYPE) || eIsSet(Aadl2Package.FEATURE__CLASSIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RefinableElement getRefinedElement() {
		RefinableElement refinedElement = basicGetRefinedElement();
		return refinedElement != null && ((EObject) refinedElement).eIsProxy()
				? (RefinableElement) eResolveProxy((InternalEObject) refinedElement)
				: refinedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RefinableElement basicGetRefinedElement() {
		if (eIsSet(Aadl2Package.FEATURE__REFINED)) {
			return basicGetRefined();
		}
		return super.basicGetRefinedElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRefinedElement() {
		return super.isSetRefinedElement() || eIsSet(Aadl2Package.FEATURE__REFINED);
	}

	/*
	 * Return the feature and any of the features it refines
	 *
	 * @return EList of feature
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	public EList<Feature> getAllFeatureRefinements() {
		BasicEList<Feature> returnlist = new BasicEList<Feature>();
		Feature more = this;
		while (more != null) {
			returnlist.add(more);
			more = more.getRefined();
		}
		return returnlist;
	}

	/*
	 * Get the classifier of given feature or its refinement ancestor, if it has
	 * one, otherwise null.
	 *
	 * @return The classifier, or <code>null</code> if no classifier.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public Classifier getAllClassifier() {
		Classifier cc = getClassifier();
		Feature f = this;
		while (cc == null && f.getRefined() != null) {
			f = f.getRefined();
			cc = f.getClassifier();
		}
		return cc;
	}
	@Override
	public void getPropertyValueInternal(final Property prop, final PropertyAcc pas,
			final boolean fromInstanceSlaveCall, final boolean all) throws InvalidModelException {
		Classifier owner = getContainingClassifier();

		if (pas.addLocalContained(this, owner) && !all || pas.addLocal(this)) {
			if (!all) {
				return;
			}
		}

		// values from refined features
		Feature refined = getRefined();
		while (refined != null) {
			if (pas.addLocalContained(refined, refined.getContainingClassifier())) {
				if (!all) {
					return;
				}
			}
			if (pas.addLocal(refined)) {
				if (!all) {
					return;
				}
			}
			refined = refined.getRefined();
		}

		getPropertyValueInternalHelper(prop, pas, fromInstanceSlaveCall, all);

		// values from container
		// Ignore fromInstanceSlaveCall because the classifier is a component or
		// feature group TYPE, not an implementation.
		if (prop.isInherit()) {
			owner.getPropertyValueInternal(prop, pas, fromInstanceSlaveCall, all);
		}
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public void getPropertyValueInternalHelper(final Property prop, final PropertyAcc pas,
			final boolean fromInstanceSlaveCall, final boolean all) throws InvalidModelException {
		// values from classifier
		Classifier c = getClassifier();
		// TODO: Check if the property applies to the classifier? (->
		// property.checkAppliesTo(NamedElement)?)
		if (c != null) {
			c.getPropertyValueInternal(prop, pas, fromInstanceSlaveCall, all);
		}
	}

	public void getPropertyValue(Property prop, PropertyAcc pas, Classifier cl, final boolean all) {
		Classifier owner = getContainingClassifier();

		// local contained value
		if (pas.addLocalContained(this, owner) && !all || pas.addLocal(this)) {
			if (!all) {
				return;
			}
		}

		// values from refined features
		Feature refined = getRefined();
		while (refined != null) {
			if (pas.addLocal(refined)) {
				if (!all) {
					return;
				}
			}
			refined = refined.getRefined();
		}

		getPropertyValueHelper(prop, pas, cl, all);

		// values from container
		// Ignore fromInstanceSlaveCall because the classifier is a component or
		// feature group TYPE, not an implementation.
		if (prop.isInherit()) {
			owner.getPropertyValueInternal(prop, pas, true, all);
		}
	}

	public void getPropertyValueHelper(final Property prop, final PropertyAcc pas, Classifier cl, final boolean all)
			throws InvalidModelException {
		// values from classifier
		Classifier c = getClassifier();
		// TODO: Check if the property applies to the classifier? (->
		// property.checkAppliesTo(NamedElement)?)
		if (c != null) {
			c.getPropertyValueInternal(prop, pas, true, all);
		} else if (cl != null) {
			cl.getPropertyValueInternal(prop, pas, true, all);
		}
	}

} // FeatureImpl
