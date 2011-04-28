/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: FeatureImpl.java,v 1.27 2011-04-11 13:35:53 lwrage Exp $
 */
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArraySpecification;
import org.osate.aadl2.ArrayableElement;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureConnectionEnd;
import org.osate.aadl2.Property;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.FeatureImpl#getArraySpecification <em>Array Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureImpl#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureImpl#getRefined <em>Refined</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FeatureImpl extends StructuralFeatureImpl implements
		Feature {
	/*
	 * The cached value of the '{@link #getArraySpecification() <em>Array
	 * Specification</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getArraySpecification()
	 * 
	 * @generated
	 * 
	 * @ordered
	 */
	protected ArraySpecification arraySpecification;
	/*
	 * The cached value of the '{@link #getPrototype() <em>Prototype</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPrototype()
	 * 
	 * @generated
	 * 
	 * @ordered
	 */
	protected Prototype prototype;

	/*
	 * The cached value of the '{@link #getRefined() <em>Refined</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRefined()
	 * 
	 * @generated
	 * 
	 * @ordered
	 */
	protected Feature refined;

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getFeature();
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ArraySpecification getArraySpecification() {
		return arraySpecification;
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetArraySpecification(
			ArraySpecification newArraySpecification, NotificationChain msgs) {
		ArraySpecification oldArraySpecification = arraySpecification;
		arraySpecification = newArraySpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					Aadl2Package.FEATURE__ARRAY_SPECIFICATION,
					oldArraySpecification, newArraySpecification);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setArraySpecification(ArraySpecification newArraySpecification) {
		if (newArraySpecification != arraySpecification) {
			NotificationChain msgs = null;
			if (arraySpecification != null)
				msgs = ((InternalEObject) arraySpecification).eInverseRemove(
						this, EOPPOSITE_FEATURE_BASE
								- Aadl2Package.FEATURE__ARRAY_SPECIFICATION,
						null, msgs);
			if (newArraySpecification != null)
				msgs = ((InternalEObject) newArraySpecification).eInverseAdd(
						this, EOPPOSITE_FEATURE_BASE
								- Aadl2Package.FEATURE__ARRAY_SPECIFICATION,
						null, msgs);
			msgs = basicSetArraySpecification(newArraySpecification, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.FEATURE__ARRAY_SPECIFICATION,
					newArraySpecification, newArraySpecification));
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ArraySpecification createArraySpecification() {
		ArraySpecification newArraySpecification = (ArraySpecification) create(Aadl2Package.eINSTANCE
				.getArraySpecification());
		setArraySpecification(newArraySpecification);
		return newArraySpecification;
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Prototype getPrototype() {
		if (prototype != null && ((EObject) prototype).eIsProxy()) {
			InternalEObject oldPrototype = (InternalEObject) prototype;
			prototype = (Prototype) eResolveProxy(oldPrototype);
			if (prototype != oldPrototype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.FEATURE__PROTOTYPE, oldPrototype,
							prototype));
			}
		}
		return prototype;
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Prototype basicGetPrototype() {
		return prototype;
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPrototype(Prototype newPrototype) {
		Prototype oldPrototype = prototype;
		prototype = newPrototype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.FEATURE__PROTOTYPE, oldPrototype, prototype));
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Feature getRefined() {
		if (refined != null && ((EObject) refined).eIsProxy()) {
			InternalEObject oldRefined = (InternalEObject) refined;
			refined = (Feature) eResolveProxy(oldRefined);
			if (refined != oldRefined) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.FEATURE__REFINED, oldRefined, refined));
			}
		}
		return refined;
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Feature basicGetRefined() {
		return refined;
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRefined(Feature newRefined) {
		Feature oldRefined = refined;
		refined = newRefined;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.FEATURE__REFINED, oldRefined, refined));
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetRefined() {
		return refined != null;
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ComponentClassifier getClassifier() {
		ComponentClassifier classifier = basicGetClassifier();
		return classifier != null && ((EObject) classifier).eIsProxy() ? (ComponentClassifier) eResolveProxy((InternalEObject) classifier)
				: classifier;
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ComponentClassifier basicGetClassifier() {
		return null;
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.FEATURE__ARRAY_SPECIFICATION:
			return basicSetArraySpecification(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.FEATURE__ARRAY_SPECIFICATION:
			return getArraySpecification();
		case Aadl2Package.FEATURE__CLASSIFIER:
			if (resolve)
				return getClassifier();
			return basicGetClassifier();
		case Aadl2Package.FEATURE__PROTOTYPE:
			if (resolve)
				return getPrototype();
			return basicGetPrototype();
		case Aadl2Package.FEATURE__REFINED:
			if (resolve)
				return getRefined();
			return basicGetRefined();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.FEATURE__ARRAY_SPECIFICATION:
			setArraySpecification((ArraySpecification) newValue);
			return;
		case Aadl2Package.FEATURE__PROTOTYPE:
			setPrototype((Prototype) newValue);
			return;
		case Aadl2Package.FEATURE__REFINED:
			setRefined((Feature) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.FEATURE__ARRAY_SPECIFICATION:
			setArraySpecification((ArraySpecification) null);
			return;
		case Aadl2Package.FEATURE__PROTOTYPE:
			setPrototype((Prototype) null);
			return;
		case Aadl2Package.FEATURE__REFINED:
			setRefined((Feature) null);
			return;
		}
		super.eUnset(featureID);
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.FEATURE__ARRAY_SPECIFICATION:
			return arraySpecification != null;
		case Aadl2Package.FEATURE__CLASSIFIER:
			return isSetClassifier();
		case Aadl2Package.FEATURE__PROTOTYPE:
			return prototype != null;
		case Aadl2Package.FEATURE__REFINED:
			return isSetRefined();
		}
		return super.eIsSet(featureID);
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
			case Aadl2Package.FEATURE__ARRAY_SPECIFICATION:
				return Aadl2Package.ARRAYABLE_ELEMENT__ARRAY_SPECIFICATION;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
			case Aadl2Package.ARRAYABLE_ELEMENT__ARRAY_SPECIFICATION:
				return Aadl2Package.FEATURE__ARRAY_SPECIFICATION;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetClassifier() {
		return false;
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public RefinableElement getRefinedElement() {
		return getRefined();
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public RefinableElement basicGetRefinedElement() {
		return basicGetRefined();
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetRefinedElement() {
		return false;
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
	public ComponentClassifier getAllClassifier() {
		ComponentClassifier cc = getClassifier();
		Feature f = this;
		while (cc == null && f.getRefined() != null) {
			f = f.getRefined();
			cc = f.getClassifier();
		}
		return cc;
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public void getPropertyValueInternal(final Property prop,
			final PropertyAcc pas, final boolean fromInstanceSlaveCall)
			throws InvalidModelException {
		Classifier owner = getContainingClassifier();

		if (pas.addLocalContained(this, owner) || pas.addLocal(this)) {
			return;
		}

		// values from refined features
		Feature refined = getRefined();
		while (refined != null) {
			if (pas.addLocal(refined)) {
				return;
			}
			refined = refined.getRefined();
		}

		getPropertyValueInternalHelper(prop, pas, fromInstanceSlaveCall);

		// values from container
		// Ignore fromInstanceSlaveCall because the classifier is a component or feature group TYPE, not an implementation.
		if (prop.isInherit()) {
			if (owner != null) {
				owner.getPropertyValueInternal(prop, pas, fromInstanceSlaveCall);
			} else {
				throw new InvalidModelException(this,
						"Feature is not contained in a component type");
			}
		}
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public void getPropertyValueInternalHelper(final Property prop,
			final PropertyAcc pas, final boolean fromInstanceSlaveCall)
			throws InvalidModelException {
		// values from classifier
		ComponentClassifier c = getClassifier();
		// TODO: Check if the property applies to the classifier? (-> property.checkAppliesTo(NamedElement)?)
		if (c != null) {
			c.getPropertyValueInternal(prop, pas, fromInstanceSlaveCall);
		}
	}

	public void getPropertyValueTest(Property prop, PropertyAcc pas,
			Classifier cl) {
		Classifier owner = getContainingClassifier();

		// local contained value
		if (pas.addLocalContained(this, owner) || pas.addLocal(this)) {
			return;
		}

		// values from refined features
		Feature refined = getRefined();
		while (refined != null) {
			if (pas.addLocal(refined)) {
				return;
			}
			refined = refined.getRefined();
		}

		getPropertyValueTestHelper(prop, pas, cl);

		// values from container
		// Ignore fromInstanceSlaveCall because the classifier is a component or feature group TYPE, not an implementation.
		if (prop.isInherit()) {
			if (owner != null) {
				owner.getPropertyValueInternal(prop, pas, true);
			} else {
				throw new InvalidModelException(this,
						"Feature is not contained in a component type");
			}
		}
	}

	public void getPropertyValueTestHelper(final Property prop,
			final PropertyAcc pas, Classifier cl) throws InvalidModelException {
		// values from classifier
		ComponentClassifier c = getClassifier();
		// TODO: Check if the property applies to the classifier? (-> property.checkAppliesTo(NamedElement)?)
		if (c != null) {
			c.getPropertyValueInternal(prop, pas, true);
		} else if (cl != null) {
			cl.getPropertyValueInternal(prop, pas, true);
		}
	}

} // FeatureImpl
