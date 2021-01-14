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

import java.util.Collection;
import java.util.HashSet;
import java.util.ListIterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.aadl2.util.NonNotifyingEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getClassifierFeatures <em>Classifier Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getMembers <em>Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getGeneralizations <em>Generalization</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getOwnedElements <em>Owned Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getGenerals <em>General</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getInheritedMembers <em>Inherited Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getOwnedAnnexSubclauses <em>Owned Annex Subclause</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getOwnedPrototypes <em>Owned Prototype</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getOwnedPrototypeBindings <em>Owned Prototype Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#isNoPrototypes <em>No Prototypes</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#isNoAnnexes <em>No Annexes</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#isNoProperties <em>No Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ClassifierImpl extends NamespaceImpl implements Classifier {
	/**
	 * The cached value of the '{@link #getOwnedAnnexSubclauses() <em>Owned Annex Subclause</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAnnexSubclauses()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnexSubclause> ownedAnnexSubclauses;

	/**
	 * The cached value of the '{@link #getOwnedPrototypes() <em>Owned Prototype</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPrototypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Prototype> ownedPrototypes;

	/**
	 * The cached value of the '{@link #getOwnedPrototypeBindings() <em>Owned Prototype Binding</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPrototypeBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<PrototypeBinding> ownedPrototypeBindings;

	/**
	 * The default value of the '{@link #isNoPrototypes() <em>No Prototypes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoPrototypes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_PROTOTYPES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoPrototypes() <em>No Prototypes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoPrototypes()
	 * @generated
	 * @ordered
	 */
	protected boolean noPrototypes = NO_PROTOTYPES_EDEFAULT;

	/**
	 * The default value of the '{@link #isNoAnnexes() <em>No Annexes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoAnnexes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_ANNEXES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoAnnexes() <em>No Annexes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoAnnexes()
	 * @generated
	 * @ordered
	 */
	protected boolean noAnnexes = NO_ANNEXES_EDEFAULT;

	/**
	 * The default value of the '{@link #isNoProperties() <em>No Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoProperties()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_PROPERTIES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoProperties() <em>No Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoProperties()
	 * @generated
	 * @ordered
	 */
	protected boolean noProperties = NO_PROPERTIES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getClassifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassifierFeature> getClassifierFeatures() {
		return new DerivedUnionEObjectEList<ClassifierFeature>(ClassifierFeature.class, this,
				Aadl2Package.CLASSIFIER__CLASSIFIER_FEATURE, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getMembersGen() {
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this, Aadl2Package.CLASSIFIER__MEMBER,
				MEMBER_ESUBSETS);
	}

	public EList<NamedElement> getMembers() {
		// DB This should be an EStructuralFeature.Setting
		// BasicEList<NamedElement> results = new BasicEList<NamedElement>(
		// getMembersGen());
		final EList<NamedElement> results = new NonNotifyingEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.CLASSIFIER__MEMBER);
		results.addAll(getMembersGen());
		results.addAll(getInheritedMembers());

		return results;
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getMembers() <em>Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] MEMBER_ESUBSETS = new int[] { Aadl2Package.CLASSIFIER__OWNED_MEMBER,
			Aadl2Package.CLASSIFIER__CLASSIFIER_FEATURE, Aadl2Package.CLASSIFIER__INHERITED_MEMBER };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getOwnedElements() {
		return new DerivedUnionEObjectEList<Element>(Element.class, this, Aadl2Package.CLASSIFIER__OWNED_ELEMENT,
				OWNED_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedElements() <em>Owned Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_ELEMENT_ESUBSETS = new int[] { Aadl2Package.CLASSIFIER__OWNED_COMMENT,
			Aadl2Package.CLASSIFIER__OWNED_MEMBER, Aadl2Package.CLASSIFIER__GENERALIZATION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getOwnedMembers() {
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.CLASSIFIER__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedMembers() <em>Owned Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_MEMBER_ESUBSETS = new int[] { Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE,
			Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE };

	/**
	 * @author dionisio
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<NamedElement> getInheritedMembers() {
		// DONE: implemented get inherited members
		// list to track for cycles
		EList<NamedElement> cls = new BasicInternalEList<NamedElement>(NamedElement.class);
		// members to be returned
		// DB The returned list must be an EStructuralFeature.Setting
		// EList<NamedElement> tmp = new BasicInternalEList<NamedElement>(
		// NamedElement.class);
		// final EList<Classifier> list = new BasicEList<Classifier>();
		final EList<NamedElement> tmp = new NonNotifyingEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.CLASSIFIER__INHERITED_MEMBER);
		cls.add(this);
		for (Generalization g : getGeneralizations()) {
			Classifier cl = g.getGeneral();
			if (!Aadl2Util.isNull(cl) && cl != this) {
				tmp.addAll(cl.getOwnedMembers());
				// add both to look for cycles
				cls.add(cl);
				((ClassifierImpl) cl).getInheritedMembers(tmp, cls);
				cls.remove(cl);
			}
		}
		return tmp;
	}

	protected EList<NamedElement> getInheritedMembers(EList<NamedElement> tmp, EList<NamedElement> cls) {
		// DONE: implemented get inherited members
		for (Generalization g : getGeneralizations()) {
			Classifier cl = g.getGeneral();
			if (!Aadl2Util.isNull(cl) && !cls.contains(cl)) {
				tmp.addAll(cl.getOwnedMembers());
				cls.add(cl);
				((ClassifierImpl) cl).getInheritedMembers(tmp, cls);
				cls.remove(cl);
			}
		}
		return tmp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Prototype> getOwnedPrototypes() {
		if (ownedPrototypes == null) {
			ownedPrototypes = new EObjectContainmentEList<Prototype>(Prototype.class, this,
					Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE);
		}
		return ownedPrototypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Prototype createOwnedPrototype(EClass eClass) {
		Prototype newOwnedPrototype = (Prototype) create(eClass);
		getOwnedPrototypes().add(newOwnedPrototype);
		return newOwnedPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PrototypeBinding> getOwnedPrototypeBindings() {
		if (ownedPrototypeBindings == null) {
			ownedPrototypeBindings = new EObjectContainmentEList<PrototypeBinding>(PrototypeBinding.class, this,
					Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING);
		}
		return ownedPrototypeBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrototypeBinding createOwnedPrototypeBinding(EClass eClass) {
		PrototypeBinding newOwnedPrototypeBinding = (PrototypeBinding) create(eClass);
		getOwnedPrototypeBindings().add(newOwnedPrototypeBinding);
		return newOwnedPrototypeBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Generalization> getGeneralizations() {
		return new DerivedUnionEObjectEList<Generalization>(Generalization.class, this,
				Aadl2Package.CLASSIFIER__GENERALIZATION, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getGenerals() {
		return new DerivedUnionEObjectEList<Classifier>(Classifier.class, this, Aadl2Package.CLASSIFIER__GENERAL, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnexSubclause> getOwnedAnnexSubclauses() {
		if (ownedAnnexSubclauses == null) {
			ownedAnnexSubclauses = new EObjectContainmentEList<AnnexSubclause>(AnnexSubclause.class, this,
					Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE);
		}
		return ownedAnnexSubclauses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnexSubclause createOwnedAnnexSubclause(EClass eClass) {
		AnnexSubclause newOwnedAnnexSubclause = (AnnexSubclause) create(eClass);
		getOwnedAnnexSubclauses().add(newOwnedAnnexSubclause);
		return newOwnedAnnexSubclause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DefaultAnnexSubclause createOwnedAnnexSubclause() {
		return (DefaultAnnexSubclause) createOwnedAnnexSubclause(Aadl2Package.eINSTANCE.getDefaultAnnexSubclause());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoProperties() {
		return noProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoProperties(boolean newNoProperties) {
		boolean oldNoProperties = noProperties;
		noProperties = newNoProperties;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CLASSIFIER__NO_PROPERTIES,
					oldNoProperties, noProperties));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoPrototypes() {
		return noPrototypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoPrototypes(boolean newNoPrototypes) {
		boolean oldNoPrototypes = noPrototypes;
		noPrototypes = newNoPrototypes;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CLASSIFIER__NO_PROTOTYPES,
					oldNoPrototypes, noPrototypes));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoAnnexes() {
		return noAnnexes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoAnnexes(boolean newNoAnnexes) {
		boolean oldNoAnnexes = noAnnexes;
		noAnnexes = newNoAnnexes;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CLASSIFIER__NO_ANNEXES, oldNoAnnexes,
					noAnnexes));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE:
			return ((InternalEList<?>) getOwnedAnnexSubclauses()).basicRemove(otherEnd, msgs);
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE:
			return ((InternalEList<?>) getOwnedPrototypes()).basicRemove(otherEnd, msgs);
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING:
			return ((InternalEList<?>) getOwnedPrototypeBindings()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.CLASSIFIER__CLASSIFIER_FEATURE:
			return getClassifierFeatures();
		case Aadl2Package.CLASSIFIER__GENERALIZATION:
			return getGeneralizations();
		case Aadl2Package.CLASSIFIER__GENERAL:
			return getGenerals();
		case Aadl2Package.CLASSIFIER__INHERITED_MEMBER:
			return getInheritedMembers();
		case Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE:
			return getOwnedAnnexSubclauses();
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE:
			return getOwnedPrototypes();
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING:
			return getOwnedPrototypeBindings();
		case Aadl2Package.CLASSIFIER__NO_PROTOTYPES:
			return isNoPrototypes();
		case Aadl2Package.CLASSIFIER__NO_ANNEXES:
			return isNoAnnexes();
		case Aadl2Package.CLASSIFIER__NO_PROPERTIES:
			return isNoProperties();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE:
			getOwnedAnnexSubclauses().clear();
			getOwnedAnnexSubclauses().addAll((Collection<? extends AnnexSubclause>) newValue);
			return;
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE:
			getOwnedPrototypes().clear();
			getOwnedPrototypes().addAll((Collection<? extends Prototype>) newValue);
			return;
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING:
			getOwnedPrototypeBindings().clear();
			getOwnedPrototypeBindings().addAll((Collection<? extends PrototypeBinding>) newValue);
			return;
		case Aadl2Package.CLASSIFIER__NO_PROTOTYPES:
			setNoPrototypes((Boolean) newValue);
			return;
		case Aadl2Package.CLASSIFIER__NO_ANNEXES:
			setNoAnnexes((Boolean) newValue);
			return;
		case Aadl2Package.CLASSIFIER__NO_PROPERTIES:
			setNoProperties((Boolean) newValue);
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
		case Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE:
			getOwnedAnnexSubclauses().clear();
			return;
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE:
			getOwnedPrototypes().clear();
			return;
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING:
			getOwnedPrototypeBindings().clear();
			return;
		case Aadl2Package.CLASSIFIER__NO_PROTOTYPES:
			setNoPrototypes(NO_PROTOTYPES_EDEFAULT);
			return;
		case Aadl2Package.CLASSIFIER__NO_ANNEXES:
			setNoAnnexes(NO_ANNEXES_EDEFAULT);
			return;
		case Aadl2Package.CLASSIFIER__NO_PROPERTIES:
			setNoProperties(NO_PROPERTIES_EDEFAULT);
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
		case Aadl2Package.CLASSIFIER__CLASSIFIER_FEATURE:
			return isSetClassifierFeatures();
		case Aadl2Package.CLASSIFIER__MEMBER:
			return isSetMembers();
		case Aadl2Package.CLASSIFIER__GENERALIZATION:
			return isSetGeneralizations();
		case Aadl2Package.CLASSIFIER__OWNED_ELEMENT:
			return isSetOwnedElements();
		case Aadl2Package.CLASSIFIER__GENERAL:
			return isSetGenerals();
		case Aadl2Package.CLASSIFIER__OWNED_MEMBER:
			return isSetOwnedMembers();
		case Aadl2Package.CLASSIFIER__INHERITED_MEMBER:
			return !getInheritedMembers().isEmpty();
		case Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE:
			return ownedAnnexSubclauses != null && !ownedAnnexSubclauses.isEmpty();
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE:
			return ownedPrototypes != null && !ownedPrototypes.isEmpty();
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING:
			return ownedPrototypeBindings != null && !ownedPrototypeBindings.isEmpty();
		case Aadl2Package.CLASSIFIER__NO_PROTOTYPES:
			return noPrototypes != NO_PROTOTYPES_EDEFAULT;
		case Aadl2Package.CLASSIFIER__NO_ANNEXES:
			return noAnnexes != NO_ANNEXES_EDEFAULT;
		case Aadl2Package.CLASSIFIER__NO_PROPERTIES:
			return noProperties != NO_PROPERTIES_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (noPrototypes: ");
		result.append(noPrototypes);
		result.append(", noAnnexes: ");
		result.append(noAnnexes);
		result.append(", noProperties: ");
		result.append(noProperties);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetClassifierFeatures() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMembers() {
		return super.isSetMembers() || isSetClassifierFeatures() || eIsSet(Aadl2Package.CLASSIFIER__INHERITED_MEMBER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetGeneralizations() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedElements() {
		return super.isSetOwnedElements() || isSetGeneralizations();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetGenerals() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers() || eIsSet(Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE)
				|| eIsSet(Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE);
	}

	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	public EList<Classifier> getSelfPlusAllExtended() {
		final EList<Classifier> result = new BasicEList<Classifier>();
		Classifier current = this;
		do {
			result.add(current);
			current = current.getExtended();
		} while (current != null && current != this && !result.contains(current));
		return result;
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public boolean acceptsProperty(Property property) {
		if (super.acceptsProperty(property)) {
			return true;
		} else {
			return checkAppliesToClassifier(property);
		}
	}

	/**
	 * Check whether the applies to classifiers in a property definition
	 * describe this classifier.
	 *
	 * @param property
	 * 			  The property definition
	 * @return Whether this classifier is a descendant of one of
	 * 		   the classifiers named in the property definition.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public boolean checkAppliesToClassifier(Property property) {
		for (Classifier appliesToClassifier : property.getAppliesToClassifiers()) {
			if (isDescendentOf(appliesToClassifier)) {
				return true;
			}
		}
		return false;
	}

	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public EList<PropertyAssociation> getAllPropertyAssociations() {
		final EList<PropertyAssociation> result = new BasicEList<PropertyAssociation>();
		final EList<Classifier> classifiers = getSelfPlusAllExtended();
		for (final ListIterator<Classifier> i = classifiers.listIterator(classifiers.size()); i.hasPrevious();) {
			final Classifier current = i.previous();
			result.addAll(current.getOwnedPropertyAssociations());
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.ComponentClassifier#lookupPrototypeBinding(org.osate.aadl2.Prototype)
	 */
	public PrototypeBinding lookupPrototypeBinding(Prototype proto) {
		PrototypeBinding result = null;

		for (PrototypeBinding pb : getOwnedPrototypeBindings()) {
			if (pb.getFormal() == proto) {
				result = pb;
				break;
			}
		}
		if (result == null) {
			for (Classifier general : getGenerals()) {
				result = general.lookupPrototypeBinding(proto);
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}

	/**
	 * find in owned members of classifier and then in extends
	 */
	public NamedElement findNamedElement(String name) {
		Classifier cl = this;
		HashSet<Classifier> visited = new HashSet<Classifier>();
		while (!Aadl2Util.isNull(cl) && !visited.contains(cl)) {
			NamedElement res = Aadl2Util.findOwnedNamedElement(cl, name);
			if (res != null) {
				return res;
			}
			visited.add(cl);
			cl = cl.getExtended();
		}
		return null;
	}

} // ClassifierImpl
